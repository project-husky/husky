<?xml version="1.0" encoding="UTF-8"?>
<!--
*******************************************************************************
mini CDA Schematron for eHC Unit Test for CDA Validation

History:
2016.04.13: Tony Schaller, medshare GmbH (first draft)
Schematron master file for the Swiss HL7 CDA-CH-VACD Template

*******************************************************************************
-->
<schema xmlns="http://purl.oclc.org/dsdl/schematron"
	xmlns:iso="http://purl.oclc.org/dsdl/schematron"
	xmlns:xhtml="http://www.w3.org/1999/xhtml"
	xmlns:xi="http://www.w3.org/2001/XInclude"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:ms="http://medshare.net/XSLBase"
	defaultPhase="all">
	<iso:phase xmlns="" id="all">
		<iso:active pattern="pattern_01"/>
		<iso:active pattern="pattern_02"/>
		<iso:active pattern="pattern_03"/>
		<iso:active pattern="pattern_04"/>
		<iso:active pattern="pattern_11"/>
		<iso:active pattern="pattern_12"/>
		<iso:active pattern="pattern_13"/>
		<iso:active pattern="pattern_14"/>
		<iso:active pattern="pattern_21"/>
		<iso:active pattern="pattern_31"/>
		<iso:active pattern="pattern_41"/>
	</iso:phase>
	<iso:phase xmlns="" id="error">
		<iso:active pattern="pattern_01"/>
		<iso:active pattern="pattern_11"/>
		<iso:active pattern="pattern_21"/>
		<iso:active pattern="pattern_31"/>
	</iso:phase>
	<iso:phase xmlns="" id="warning">
		<iso:active pattern="pattern_02"/>
		<iso:active pattern="pattern_12"/>
	</iso:phase>
	<iso:phase xmlns="" id="information">
		<iso:active pattern="pattern_03"/>
		<iso:active pattern="pattern_13"/>
		<iso:active pattern="pattern_41"/>
	</iso:phase>

	<ns prefix="cda" uri="urn:hl7-org:v3"/>
	<ns prefix="xsi" uri="http://www.w3.org/2001/XMLSchema-instance"/>

	<!--
	********************************************************
	CDA-CH style - reports
	******************************************************** -->
	<iso:pattern id="pattern_01">
		<iso:rule context="/cda:ClinicalDocument" id="rule_01">
			<report role="error"  test="cda:title/text() != 'test'" id="report_01">
				<xhtml:p lang="en">Error: The English title must read 'test'</xhtml:p>
				<xhtml:p lang="de">Error: Der englische Titel muss lauten 'test'</xhtml:p>
				<xhtml:p lang="fr">Error: Le titre anglais doit être 'test'</xhtml:p>
				<xhtml:p lang="it">Error: Il titolo inglese deve essere 'test'</xhtml:p>
			</report>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="pattern_02">
		<iso:rule context="cda:ClinicalDocument" id="rule_02">
			<report role="warning" test="cda:relatedDocument[@typeCode='RPLC']" id="report_02">
				<xhtml:p lang="de">Warning: Dieses CDA-CH Dokument ersetzt ein anderes Dokument</xhtml:p>
			</report>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="pattern_03">
		<iso:rule context="cda:ClinicalDocument" id="rule_03">
			<report role="information" test="cda:versionNumber" id="report_03">
				<xhtml:p lang="de">Information: Dieses CDA-CH Dokument enthält eine versionNumber</xhtml:p>
			</report>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="pattern_04">
		<iso:rule context="/cda:ClinicalDocument" id="rule_04">
			<report role="debug" test="cda:confidentialityCode[@code='N']" id="report_04">
				<xhtml:p lang="de">Debug: Dieses CDA-CH Dokument ist in Vertraulichkeitsstufe Normal</xhtml:p>
			</report>
		</iso:rule>
	</iso:pattern>

	<!--
	********************************************************
	CDA-CH style - asserts
	******************************************************** -->
	<iso:pattern id="pattern_11">
		<iso:rule context="/cda:ClinicalDocument" id="rule_11">
			<assert role="error" test="not(cda:relatedDocument[@typeCode='RPLC']) or (cda:versionNumber[@value&gt;1])" id="assert_11">
				<xhtml:p lang="de">Error: Wenn das Dokument ein anderes Dokument ersetzt, muss die Versionsnummer grösser als 1 sein</xhtml:p>
			</assert>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="pattern_12">
		<iso:rule context="/cda:ClinicalDocument/cda:recordTarget/cda:patientRole/cda:addr" id="rule_12">
			<assert role="warning" test="(cda:streetName or cda:streetAddressLine) and cda:postalCode and cda:city" id="assert_12">
				<xhtml:p lang="de">Warning: Dieses CDA-CH Dokument enthält eine unvollständige Adresse</xhtml:p>
			</assert>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="pattern_13">
		<iso:rule context="cda:entry/cda:substanceAdministration/cda:consumable/cda:manufacturedProduct/cda:manufacturedMaterial" id="rule_13">
			<assert role="information" test="cda:code[@code and @codeSystem='2.16.840.1.113883.6.73']" id="assert_13">
				<xhtml:p lang="de">Information: Das Medikament enthält keinen WHO ATC Code </xhtml:p>
			</assert>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="pattern_14">
		<iso:rule context="cda:entry/cda:substanceAdministration" id="rule_14">
			<assert role="debug" test="cda:performer" id="assert_14">
				<xhtml:p lang="de">Debug: Zum Medikament ist kein Performer deklariert</xhtml:p>
			</assert>
		</iso:rule>
	</iso:pattern>

	<!--
	********************************************************
	ELGA style - asserts
	******************************************************** -->
	<iso:pattern id="pattern_21">
		<iso:rule context="cda:entry/cda:substanceAdministration" id="rule_21">
      <assert role="error"
              see="http://foo.bar"
              test="cda:author">Fehler: Zum Medikament ist kein Autor deklariert</assert>
		</iso:rule>
	</iso:pattern>

	<!--
	********************************************************
	Other styles - reports
	******************************************************** -->
	<iso:pattern id="pattern_31">
		<iso:rule context="/cda:ClinicalDocument" id="rule_31">
      <report test="cda:setId">Information: Das Dokument enthält eine setId</report>
		</iso:rule>
	</iso:pattern>

	<!--
	********************************************************
	Other styles - asserts
	******************************************************** -->
	<iso:pattern id="pattern_41">
		<iso:rule context="/cda:ClinicalDocument/cda:recordTarget/cda:patientRole" id="rule_41">
      <assert test="cda:providerOrganization">Fehler: Zum Patienten muss eine providerOrganization angegeben werden</assert>
		</iso:rule>
	</iso:pattern>

</schema>
