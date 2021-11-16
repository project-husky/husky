<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron"
  xmlns:sqf="http://www.schematron-quickfix.com/validator/process" queryBinding="xslt2"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <sch:title>Flowers</sch:title>
  <sch:pattern>
    <!-- Title - styling elements are not allowed in title. -->
    <sch:rule context="title | shortdesc">
      <sch:report test="b" subject="b" role="info"> Bold is not allowed in <sch:name/>
        element.</sch:report>
    </sch:rule>

    
    <!-- Unordered list asserts -->
    <sch:rule context="ul">
      <!-- Check that there is more that one lit item in a list -->
      <sch:assert test="count(li) > 1" role="warn"> A list must have more than one item
      </sch:assert>
    </sch:rule>

    <sch:rule context="li">
      <!-- The list item must not end with semicolon -->
      <sch:report test="ends-with(text()[last()], ';')" role="warn"> Semicolon is not allowed after list
        item.</sch:report>
    </sch:rule>

    <!-- External reference asserts -->
    <sch:rule context="xref[@scope = 'external']">
      <!-- Check the external link protocol -->
      <sch:assert test="matches(@href, '^http(s?)://')" role="warn"> An external link should start
        with http(s).</sch:assert>
    </sch:rule>

    <!-- Table asserts -->
    <sch:rule context="table">
      <sch:let name="minColumsNo" value="min(.//row/count(entry))"/>
      <sch:let name="reqColumsNo" value="max(.//row/count(entry))"/>

      <!-- Check the number of cells on each row -->
      <sch:assert test="$minColumsNo >= $reqColumsNo">Cells are missing. (The number of cells for
        each row must be <sch:value-of select="$reqColumsNo"/>)</sch:assert>
    </sch:rule>
    
    <sch:rule context="text()">
      <sch:report test="matches(., '(http|www)\S+') 
        and local-name(parent::node()) != 'xref'" role="info">
        The link should be an an xref element</sch:report>
    </sch:rule>
  </sch:pattern>
</sch:schema>
