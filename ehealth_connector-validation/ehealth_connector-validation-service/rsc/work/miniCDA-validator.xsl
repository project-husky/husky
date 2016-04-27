<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:schold="http://www.ascc.net/xml/schematron" xmlns:iso="http://purl.oclc.org/dsdl/schematron" xmlns:xhtml="http://www.w3.org/1999/xhtml" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:cda="urn:hl7-org:v3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0"><!--Implementers: please note that overriding process-prolog or process-root is 
    the preferred method for meta-stylesheets to use where possible. -->
<xsl:param name="archiveDirParameter"/><xsl:param name="archiveNameParameter"/><xsl:param name="fileNameParameter"/><xsl:param name="fileDirParameter"/><xsl:variable name="document-uri"><xsl:value-of select="document-uri(/)"/></xsl:variable>

<!--PHASES-->


<!--PROLOG-->
<xsl:output xmlns:svrl="http://purl.oclc.org/dsdl/svrl" method="xml" omit-xml-declaration="no" standalone="yes" indent="yes"/>

<!--XSD TYPES FOR XSLT2-->


<!--KEYS AND FUNCTIONS-->


<!--DEFAULT RULES-->


<!--MODE: SCHEMATRON-SELECT-FULL-PATH-->
<!--This mode can be used to generate an ugly though full XPath for locators-->
<xsl:template match="*" mode="schematron-select-full-path"><xsl:apply-templates select="." mode="schematron-get-full-path-2"/></xsl:template>

<!--MODE: SCHEMATRON-FULL-PATH-->
<!--This mode can be used to generate an ugly though full XPath for locators-->
<xsl:template match="*" mode="schematron-get-full-path"><xsl:apply-templates select="parent::*" mode="schematron-get-full-path"/><xsl:text>/</xsl:text><xsl:choose><xsl:when test="namespace-uri()=''"><xsl:value-of select="name()"/><xsl:variable name="p_1" select="1+    count(preceding-sibling::*[name()=name(current())])"/><xsl:if test="$p_1&gt;1 or following-sibling::*[name()=name(current())]">[<xsl:value-of select="$p_1"/>]</xsl:if></xsl:when><xsl:otherwise><xsl:text>*[local-name()='</xsl:text><xsl:value-of select="local-name()"/><xsl:text>']</xsl:text><xsl:variable name="p_2" select="1+   count(preceding-sibling::*[local-name()=local-name(current())])"/><xsl:if test="$p_2&gt;1 or following-sibling::*[local-name()=local-name(current())]">[<xsl:value-of select="$p_2"/>]</xsl:if></xsl:otherwise></xsl:choose></xsl:template><xsl:template match="@*" mode="schematron-get-full-path"><xsl:text>/</xsl:text><xsl:choose><xsl:when test="namespace-uri()=''">@<xsl:value-of select="name()"/></xsl:when><xsl:otherwise><xsl:text>@*[local-name()='</xsl:text><xsl:value-of select="local-name()"/><xsl:text>' and namespace-uri()='</xsl:text><xsl:value-of select="namespace-uri()"/><xsl:text>']</xsl:text></xsl:otherwise></xsl:choose></xsl:template>

<!--MODE: SCHEMATRON-FULL-PATH-2-->
<!--This mode can be used to generate prefixed XPath for humans-->
<xsl:template match="node() | @*" mode="schematron-get-full-path-2"><xsl:for-each select="ancestor-or-self::*"><xsl:text>/</xsl:text><xsl:value-of select="name(.)"/><xsl:if test="preceding-sibling::*[name(.)=name(current())]"><xsl:text>[</xsl:text><xsl:value-of select="count(preceding-sibling::*[name(.)=name(current())])+1"/><xsl:text>]</xsl:text></xsl:if></xsl:for-each><xsl:if test="not(self::*)"><xsl:text/>/@<xsl:value-of select="name(.)"/></xsl:if></xsl:template><!--MODE: SCHEMATRON-FULL-PATH-3-->
<!--This mode can be used to generate prefixed XPath for humans 
	(Top-level element has index)-->
<xsl:template match="node() | @*" mode="schematron-get-full-path-3"><xsl:for-each select="ancestor-or-self::*"><xsl:text>/</xsl:text><xsl:value-of select="name(.)"/><xsl:if test="parent::*"><xsl:text>[</xsl:text><xsl:value-of select="count(preceding-sibling::*[name(.)=name(current())])+1"/><xsl:text>]</xsl:text></xsl:if></xsl:for-each><xsl:if test="not(self::*)"><xsl:text/>/@<xsl:value-of select="name(.)"/></xsl:if></xsl:template>

<!--MODE: GENERATE-ID-FROM-PATH -->
<xsl:template match="/" mode="generate-id-from-path"/><xsl:template match="text()" mode="generate-id-from-path"><xsl:apply-templates select="parent::*" mode="generate-id-from-path"/><xsl:value-of select="concat('.text-', 1+count(preceding-sibling::text()), '-')"/></xsl:template><xsl:template match="comment()" mode="generate-id-from-path"><xsl:apply-templates select="parent::*" mode="generate-id-from-path"/><xsl:value-of select="concat('.comment-', 1+count(preceding-sibling::comment()), '-')"/></xsl:template><xsl:template match="processing-instruction()" mode="generate-id-from-path"><xsl:apply-templates select="parent::*" mode="generate-id-from-path"/><xsl:value-of select="concat('.processing-instruction-', 1+count(preceding-sibling::processing-instruction()), '-')"/></xsl:template><xsl:template match="@*" mode="generate-id-from-path"><xsl:apply-templates select="parent::*" mode="generate-id-from-path"/><xsl:value-of select="concat('.@', name())"/></xsl:template><xsl:template match="*" mode="generate-id-from-path" priority="-0.5"><xsl:apply-templates select="parent::*" mode="generate-id-from-path"/><xsl:text>.</xsl:text><xsl:value-of select="concat('.',name(),'-',1+count(preceding-sibling::*[name()=name(current())]),'-')"/></xsl:template>

<!--MODE: GENERATE-ID-2 -->
<xsl:template match="/" mode="generate-id-2">U</xsl:template><xsl:template match="*" mode="generate-id-2" priority="2"><xsl:text>U</xsl:text><xsl:number level="multiple" count="*"/></xsl:template><xsl:template match="node()" mode="generate-id-2"><xsl:text>U.</xsl:text><xsl:number level="multiple" count="*"/><xsl:text>n</xsl:text><xsl:number count="node()"/></xsl:template><xsl:template match="@*" mode="generate-id-2"><xsl:text>U.</xsl:text><xsl:number level="multiple" count="*"/><xsl:text>_</xsl:text><xsl:value-of select="string-length(local-name(.))"/><xsl:text>_</xsl:text><xsl:value-of select="translate(name(),':','.')"/></xsl:template><!--Strip characters--><xsl:template match="text()" priority="-1"/>

<!--SCHEMA SETUP-->
<xsl:template match="/"><svrl:schematron-output xmlns:svrl="http://purl.oclc.org/dsdl/svrl" title="" schemaVersion=""><xsl:attribute name="phase">all</xsl:attribute><xsl:comment><xsl:value-of select="$archiveDirParameter"/>   
		 <xsl:value-of select="$archiveNameParameter"/>  
		 <xsl:value-of select="$fileNameParameter"/>  
		 <xsl:value-of select="$fileDirParameter"/></xsl:comment><svrl:ns-prefix-in-attribute-values uri="urn:hl7-org:v3" prefix="cda"/><svrl:ns-prefix-in-attribute-values uri="http://www.w3.org/2001/XMLSchema-instance" prefix="xsi"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_01</xsl:attribute><xsl:attribute name="name">pattern_01</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M6"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_02</xsl:attribute><xsl:attribute name="name">pattern_02</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M7"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_03</xsl:attribute><xsl:attribute name="name">pattern_03</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M8"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_04</xsl:attribute><xsl:attribute name="name">pattern_04</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M9"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_11</xsl:attribute><xsl:attribute name="name">pattern_11</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M10"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_12</xsl:attribute><xsl:attribute name="name">pattern_12</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M11"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_13</xsl:attribute><xsl:attribute name="name">pattern_13</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M12"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_14</xsl:attribute><xsl:attribute name="name">pattern_14</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M13"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_21</xsl:attribute><xsl:attribute name="name">pattern_21</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M14"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_31</xsl:attribute><xsl:attribute name="name">pattern_31</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M15"/><svrl:active-pattern><xsl:attribute name="document"><xsl:value-of select="document-uri(/)"/></xsl:attribute><xsl:attribute name="id">pattern_41</xsl:attribute><xsl:attribute name="name">pattern_41</xsl:attribute><xsl:apply-templates/></svrl:active-pattern><xsl:apply-templates select="/" mode="M16"/></svrl:schematron-output></xsl:template>

<!--SCHEMATRON PATTERNS-->


<!--PATTERN pattern_01-->


	<!--RULE rule_01-->
<xsl:template match="/cda:ClinicalDocument" priority="1000" mode="M6"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="/cda:ClinicalDocument" id="rule_01"/>

		<!--REPORT error-->
<xsl:if test="cda:title/text() != 'test'"><svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:title/text() != 'test'"><xsl:attribute name="id">report_01</xsl:attribute><xsl:attribute name="role">error</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="en">Error: The English title must read 'test'</xhtml:p>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="de">Error: Der englische Titel muss lauten 'test'</xhtml:p>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="fr">Error: Le titre anglais doit être 'test'</xhtml:p>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="it">Error: Il titolo inglese deve essere 'test'</xhtml:p>
			</svrl:text></svrl:successful-report></xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M6"/></xsl:template><xsl:template match="text()" priority="-1" mode="M6"/><xsl:template match="@*|node()" priority="-2" mode="M6"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M6"/></xsl:template>

<!--PATTERN pattern_02-->


	<!--RULE rule_02-->
<xsl:template match="cda:ClinicalDocument" priority="1000" mode="M7"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="cda:ClinicalDocument" id="rule_02"/>

		<!--REPORT warning-->
<xsl:if test="cda:relatedDocument[@typeCode='RPLC']"><svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:relatedDocument[@typeCode='RPLC']"><xsl:attribute name="id">report_02</xsl:attribute><xsl:attribute name="role">warning</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="de">Warning: Dieses CDA-CH Dokument ersetzt ein anderes Dokument</xhtml:p>
			</svrl:text></svrl:successful-report></xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M7"/></xsl:template><xsl:template match="text()" priority="-1" mode="M7"/><xsl:template match="@*|node()" priority="-2" mode="M7"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M7"/></xsl:template>

<!--PATTERN pattern_03-->


	<!--RULE rule_03-->
<xsl:template match="cda:ClinicalDocument" priority="1000" mode="M8"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="cda:ClinicalDocument" id="rule_03"/>

		<!--REPORT information-->
<xsl:if test="cda:versionNumber"><svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:versionNumber"><xsl:attribute name="id">report_03</xsl:attribute><xsl:attribute name="role">information</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="de">Information: Dieses CDA-CH Dokument enthält eine versionNumber</xhtml:p>
			</svrl:text></svrl:successful-report></xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M8"/></xsl:template><xsl:template match="text()" priority="-1" mode="M8"/><xsl:template match="@*|node()" priority="-2" mode="M8"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M8"/></xsl:template>

<!--PATTERN pattern_04-->


	<!--RULE rule_04-->
<xsl:template match="/cda:ClinicalDocument" priority="1000" mode="M9"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="/cda:ClinicalDocument" id="rule_04"/>

		<!--REPORT debug-->
<xsl:if test="cda:confidentialityCode[@code='N']"><svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:confidentialityCode[@code='N']"><xsl:attribute name="id">report_04</xsl:attribute><xsl:attribute name="role">debug</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="de">Debug: Dieses CDA-CH Dokument ist in Vertraulichkeitsstufe Normal</xhtml:p>
			</svrl:text></svrl:successful-report></xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M9"/></xsl:template><xsl:template match="text()" priority="-1" mode="M9"/><xsl:template match="@*|node()" priority="-2" mode="M9"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M9"/></xsl:template>

<!--PATTERN pattern_11-->


	<!--RULE rule_11-->
<xsl:template match="/cda:ClinicalDocument" priority="1000" mode="M10"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="/cda:ClinicalDocument" id="rule_11"/>

		<!--ASSERT error-->
<xsl:choose><xsl:when test="not(cda:relatedDocument[@typeCode='RPLC']) or (cda:versionNumber[@value&gt;1])"/><xsl:otherwise><svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="not(cda:relatedDocument[@typeCode='RPLC']) or (cda:versionNumber[@value&gt;1])"><xsl:attribute name="id">assert_11</xsl:attribute><xsl:attribute name="role">error</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="de">Error: Wenn das Dokument ein anderes Dokument ersetzt, muss die Versionsnummer grösser als 1 sein</xhtml:p>
			</svrl:text></svrl:failed-assert></xsl:otherwise></xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M10"/></xsl:template><xsl:template match="text()" priority="-1" mode="M10"/><xsl:template match="@*|node()" priority="-2" mode="M10"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M10"/></xsl:template>

<!--PATTERN pattern_12-->


	<!--RULE rule_12-->
<xsl:template match="/cda:ClinicalDocument/cda:recordTarget/cda:patientRole/cda:addr" priority="1000" mode="M11"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="/cda:ClinicalDocument/cda:recordTarget/cda:patientRole/cda:addr" id="rule_12"/>

		<!--ASSERT warning-->
<xsl:choose><xsl:when test="(cda:streetName or cda:streetAddressLine) and cda:postalCode and cda:city"/><xsl:otherwise><svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="(cda:streetName or cda:streetAddressLine) and cda:postalCode and cda:city"><xsl:attribute name="id">assert_12</xsl:attribute><xsl:attribute name="role">warning</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="de">Warning: Dieses CDA-CH Dokument enthält eine unvollständige Adresse</xhtml:p>
			</svrl:text></svrl:failed-assert></xsl:otherwise></xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M11"/></xsl:template><xsl:template match="text()" priority="-1" mode="M11"/><xsl:template match="@*|node()" priority="-2" mode="M11"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M11"/></xsl:template>

<!--PATTERN pattern_13-->


	<!--RULE rule_13-->
<xsl:template match="cda:entry/cda:substanceAdministration/cda:consumable/cda:manufacturedProduct/cda:manufacturedMaterial" priority="1000" mode="M12"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="cda:entry/cda:substanceAdministration/cda:consumable/cda:manufacturedProduct/cda:manufacturedMaterial" id="rule_13"/>

		<!--ASSERT information-->
<xsl:choose><xsl:when test="cda:code[@code and @codeSystem='2.16.840.1.113883.6.73']"/><xsl:otherwise><svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:code[@code and @codeSystem='2.16.840.1.113883.6.73']"><xsl:attribute name="id">assert_13</xsl:attribute><xsl:attribute name="role">information</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="de">Information: Das Medikament enthält keinen WHO ATC Code </xhtml:p>
			</svrl:text></svrl:failed-assert></xsl:otherwise></xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M12"/></xsl:template><xsl:template match="text()" priority="-1" mode="M12"/><xsl:template match="@*|node()" priority="-2" mode="M12"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M12"/></xsl:template>

<!--PATTERN pattern_14-->


	<!--RULE rule_14-->
<xsl:template match="cda:entry/cda:substanceAdministration" priority="1000" mode="M13"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="cda:entry/cda:substanceAdministration" id="rule_14"/>

		<!--ASSERT debug-->
<xsl:choose><xsl:when test="cda:performer"/><xsl:otherwise><svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:performer"><xsl:attribute name="id">assert_14</xsl:attribute><xsl:attribute name="role">debug</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>
				<xhtml:p xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2001/XInclude" xmlns:ms="http://medshare.net/XSLBase" lang="de">Debug: Zum Medikament ist kein Performer deklariert</xhtml:p>
			</svrl:text></svrl:failed-assert></xsl:otherwise></xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M13"/></xsl:template><xsl:template match="text()" priority="-1" mode="M13"/><xsl:template match="@*|node()" priority="-2" mode="M13"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M13"/></xsl:template>

<!--PATTERN pattern_21-->


	<!--RULE rule_21-->
<xsl:template match="cda:entry/cda:substanceAdministration" priority="1000" mode="M14"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="cda:entry/cda:substanceAdministration" id="rule_21"/>

		<!--ASSERT error-->
<xsl:choose><xsl:when test="cda:author"/><xsl:otherwise><svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:author"><xsl:attribute name="see">http://foo.bar</xsl:attribute><xsl:attribute name="role">error</xsl:attribute><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>Fehler: Zum Medikament ist kein Autor deklariert</svrl:text></svrl:failed-assert></xsl:otherwise></xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M14"/></xsl:template><xsl:template match="text()" priority="-1" mode="M14"/><xsl:template match="@*|node()" priority="-2" mode="M14"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M14"/></xsl:template>

<!--PATTERN pattern_31-->


	<!--RULE rule_31-->
<xsl:template match="/cda:ClinicalDocument" priority="1000" mode="M15"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="/cda:ClinicalDocument" id="rule_31"/>

		<!--REPORT -->
<xsl:if test="cda:setId"><svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:setId"><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>Information: Das Dokument enthält eine setId</svrl:text></svrl:successful-report></xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M15"/></xsl:template><xsl:template match="text()" priority="-1" mode="M15"/><xsl:template match="@*|node()" priority="-2" mode="M15"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M15"/></xsl:template>

<!--PATTERN pattern_41-->


	<!--RULE rule_41-->
<xsl:template match="/cda:ClinicalDocument/cda:recordTarget/cda:patientRole" priority="1000" mode="M16"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="/cda:ClinicalDocument/cda:recordTarget/cda:patientRole" id="rule_41"/>

		<!--ASSERT -->
<xsl:choose><xsl:when test="cda:providerOrganization"/><xsl:otherwise><svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cda:providerOrganization"><xsl:attribute name="location"><xsl:apply-templates select="." mode="schematron-select-full-path"/></xsl:attribute><svrl:text>Fehler: Zum Patienten muss eine providerOrganization angegeben werden</svrl:text></svrl:failed-assert></xsl:otherwise></xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M16"/></xsl:template><xsl:template match="text()" priority="-1" mode="M16"/><xsl:template match="@*|node()" priority="-2" mode="M16"><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M16"/></xsl:template></xsl:stylesheet>