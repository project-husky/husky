<?xml version="1.0" encoding="UTF-8"?>
<!--
Copyright (c) 2001 Eddie Robertsson, Allette Systems Pty. Ltd.

 This software is provided 'as-is', without any express or implied warranty. 
 In no event will the authors be held liable for any damages arising from 
 the use of this software.

 Permission is granted to anyone to use this software for any purpose, 
 including commercial applications, and to alter it and redistribute it freely,
 subject to the following restrictions:

 1. The origin of this software must not be misrepresented; you must not claim
 that you wrote the original software. If you use this software in a product, 
 an acknowledgment in the product documentation would be appreciated but is 
 not required.

 2. Altered source versions must be plainly marked as such, and must not be 
 misrepresented as being the original software.

 3. This notice may not be removed or altered from any source distribution.
 
 Changes:
   April 27 2007 George Bina Converted to ISO Schematron.
-->
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron"
  xmlns:sqf="http://www.schematron-quickfix.com/validator/process"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns:t="www.allette.com.au/Tournament"
  queryBinding="xslt2">
  <sch:title>Schematron validation schema for the Tournament</sch:title>
  <xsl:key xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    match="t:Participants" name="Participant" use="t:Name/@id"/>
  <sch:ns prefix="t" uri="www.allette.com.au/Tournament"/>
  <sch:phase id="ParticipantsPhase">
    <sch:active pattern="Participants"/>
  </sch:phase>
  <sch:phase id="TeamsPhase">
    <sch:active pattern="Teams"/>
  </sch:phase>
  <!-- Pattern - Participants -->
  <sch:pattern id="Participants">
    <sch:rule context="t:Type[text() = 'Singles']">
      <sch:assert test="../t:Participants/@nbrParticipants >= 2">If
        you're playing single matches there must be at least 2
        participants.</sch:assert>
      <sch:assert test="../t:Participants/@nbrParticipants =
        ../t:Teams/@nbrTeams">If you're playing single matches the
        number of participants must equal the number of
        teams.</sch:assert>
    </sch:rule>
    <sch:rule context="t:Type[text() = 'Doubles']">
      <sch:assert test="../t:Participants/@nbrParticipants mod 2 = 0">If
        you're playing doubles the number of particiapants must be
        divisible by 2.</sch:assert>
      <sch:assert test="../t:Participants/@nbrParticipants =
        ../t:Teams/@nbrTeams * 2">If you're playing doubles the number
        of participants must equal the number of teams x 2.</sch:assert>
    </sch:rule>
    <sch:rule context="t:Participants">
      <sch:let name="participantsNo" value="count(t:Name)"/>
      <sch:assert test="$participantsNo = @nbrParticipants" sqf:fix="setParticipantsNo">The number of
        Name elements in <sch:name/> should match the @nbrParticipants
        attribute.</sch:assert>
      <sqf:fix id="setParticipantsNo" role="replace">
        <sqf:description>
          <sqf:title>Set the @nbrParticipants value to <sch:value-of select="$participantsNo"/></sqf:title>
        </sqf:description>
        <sqf:replace match="@nbrParticipants" node-type="attribute" target="nbrParticipants" select="$participantsNo"/>
      </sqf:fix>
      
    </sch:rule>
    <sch:rule context="t:Teams/t:Team/t:Member">
      <sch:assert test="key( 'Participant', text() )" sqf:fix="addMember">A team member must
        also be a participant in the tournament.</sch:assert>
      <sqf:fix id="addMember">
        <sqf:description>
          <sqf:title>Add the member to participants list</sqf:title>
        </sqf:description>
        <sch:let name="participantId" value="text()"/>
        <sqf:add match="../../../t:Participants" position="last-child">
          <t:Name id="{$participantId}">Member_<xsl:value-of select="$participantId"/></t:Name><xsl:text>
          </xsl:text>
        </sqf:add>
      </sqf:fix>
    </sch:rule>
  </sch:pattern>
  <!-- Pattern Teams -->
  <sch:pattern id="Teams">
    <sch:rule context="t:Teams">
      <sch:let name="teamsNo" value="count(t:Team)"/>
      <sch:assert diagnostics="d1" test="count(t:Team) = @nbrTeams" sqf:fix="setTeamsNo addTeams">The
        number of Team elements in <sch:name/> should match the
        @nbrTeams attribute.</sch:assert>
      
      <sqf:fix id="setTeamsNo" role="replace">
        <sqf:description>
          <sqf:title>Set the @nbrTeams value to <sch:value-of select="$teamsNo"/></sqf:title>
        </sqf:description>
        <sqf:replace match="@nbrTeams" node-type="attribute" target="nbrTeams" select="$teamsNo"/>
      </sqf:fix>
      
      <sqf:fix id="addTeams" use-when="xs:integer(@nbrTeams) gt $teamsNo">
        <sqf:description>
          <sqf:title>Add new teams to match the number specified in @nbrTeams attribute</sqf:title>
        </sqf:description>
        <sqf:add position="last-child">
          <xsl:for-each select="$teamsNo+1 to xs:integer(@nbrTeams)">
            <t:Team id="t{current()}" Name="Team {current()}"><xsl:text>
            </xsl:text><t:Member>p<xsl:value-of select="current()"/></t:Member><xsl:text>
            </xsl:text></t:Team><xsl:text>
            </xsl:text>
          </xsl:for-each>
        </sqf:add>
      </sqf:fix>
    </sch:rule>
  </sch:pattern>
  <!-- Diagnostics -->
  <sch:diagnostics>
    <sch:diagnostic id="d1"> Value of nbrTeams attribute = <sch:value-of
        select="@nbrTeams"/> and number of Team elements = <sch:value-of
        select="count(t:Team)"/></sch:diagnostic>
  </sch:diagnostics>
</sch:schema>
