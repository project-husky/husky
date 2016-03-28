<?xml version="1.0" encoding="UTF-8"?>
<!--
*******************************************************************************
Stylesheet for reporting Schematron validation results.

This XSL Stylesheet is the base SVRL to HTML implementation. It generates
a HTML Fragment only, with a "div" as root element (id=validation-report).

Language related parameters:
vocabularyUri:        URI of the vocabulary file with the localized texts
(must point to a valid vocabulary document)
uiLanguage:       	Language for labels (default: en). Examples: de, fr, it, en
hiddenLanguages:		Languages to hide (default: empty)

NOTE: The selected language is determined from the request parameters and from
the browser's preferred language, if JavaScript is enabled.

Parameters inherited from svrl_parse_structured.xsl:
ignoreEmptyPatterns:  Do not render patterns having no rules, nor failed
asserts, nor successful reports (default: false)
ignoreEmptyRules:     Do not render rules having no failed asserts nor
successful reports (default: false)
ignoreAllRules:       Never render rules (default: false)

NOTE: These parameters all expect a boolean value, so if you pass a string,
an empty string will be interpreted as "false" and anything else as "true".


History:
04.03.2013: Laurent Millet, initial version
05.10.2015: Tony Schaller, improved multi language support
*******************************************************************************
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:svrl="http://purl.oclc.org/dsdl/svrl"
	xmlns:iso="http://purl.oclc.org/dsdl/schematron"
	xmlns:xhtml="http://www.w3.org/1999/xhtml"
	xmlns:ms="http://medshare.net/XSLBase"
	exclude-result-prefixes="xs svrl iso xhtml ms">

	<xsl:import href="ms_base.xsl" />
	<xsl:import href="ms_html.xsl" />
	<xsl:import href="svrl_parse_structured.xsl" />

	<xsl:output method="html" omit-xml-declaration="yes" encoding="UTF-8" indent="yes" />

	<!-- Language related parameters -->
	<xsl:param name="vocabularyUri" as="xs:string?">svrl_report_voc.xml</xsl:param>
	<xsl:param name="uiLanguage" as="xs:string?">en</xsl:param>
	<xsl:param name="hiddenLanguages" as="xs:string?">de fr it</xsl:param>

	<!-- Parameters inherited from svrl_parse_structured.xsl -->
	<xsl:param name="ignoreEmptyPatterns" select="false()" />
	<xsl:param name="ignoreEmptyRules" select="false()" />
	<xsl:param name="ignoreAllRules" select="false()" />
	<xsl:param name="noPatternDetails" select="false()" />
	<xsl:param name="noRuleDetails" select="false()" />
	<xsl:param name="noAlertDetails" select="false()" />
	<xsl:param name="hiddenRoles" />

	<!--
	****************************************************************************
	-->

	<xsl:variable name="defaultTitle">Schematron Validierungsbericht</xsl:variable>
	<xsl:param name="reportTitle" as="xs:string?" select="$defaultTitle" />

	<xsl:variable name="imagesDir">resources/images</xsl:variable>

	<xsl:variable name="reportContainerId">validation-report</xsl:variable>
	<xsl:variable name="patternsContainerId">patterns-container</xsl:variable>
	<xsl:variable name="rulesContainerClass">rules-container</xsl:variable>
	<xsl:variable name="alertsContainerClass">alerts-container</xsl:variable>

	<xsl:variable name="detailsClass">details</xsl:variable>

	<xsl:variable name="descriptionClass">description</xsl:variable>

	<!--
	****************************************************************************
	-->

	<xsl:template match="/">
		<xsl:call-template name="render_report" />
	</xsl:template>

	<xsl:template name="render_report_start">
		<xsl:variable name="currentDate" select="format-dateTime(
		current-dateTime(),'[Y]-[M01]-[D01] at [H01]:[m01]:[s01]')" />
		<xsl:comment>
			************************************************************************
			Schematron Validation Report
			Generate on <xsl:value-of select="$currentDate" />
			************************************************************************
			<xsl:text> </xsl:text>
		</xsl:comment>
	</xsl:template>

	<xsl:template name="render_report_end">
		<xsl:comment>*** End of Schematron Validation Report ***</xsl:comment>
	</xsl:template>

	<!--
	****************************************************************************
	Rendering of the Schematron Validation Report
	****************************************************************************
	-->

	<xsl:template name="render_report">
		<xsl:call-template name="render_report_start" />
		<xsl:call-template name="render_report_content" />
		<xsl:call-template name="render_report_end" />
	</xsl:template>

	<xsl:template name="render_report_content">
		<div id="{$reportContainerId}">
			<xsl:apply-templates select="/svrl:schematron-output" />
			<div id="{$patternsContainerId}">
				<xsl:apply-templates select="//svrl:active-pattern" />
			</div>
			<xsl:comment>End of Patterns Container <xsl:value-of select="$patternsContainerId" />
			</xsl:comment>
		</div>
		<xsl:comment>End of Schematron Report Container <xsl:value-of	select="$reportContainerId" />
		</xsl:comment>
	</xsl:template>

	<!--
	****************************************************************************
	Rendering of the schema title
	****************************************************************************
	-->

	<xsl:template match="svrl:schematron-output">
		<xsl:variable name="firstPattern" select="svrl:active-pattern[1]" />
		<xsl:variable name="documentation" select="svrl:text[. &lt;&lt; $firstPattern]" />
		<xsl:apply-templates select="$documentation" />
	</xsl:template>

	<xsl:function name="ms:schematronTitle">
		<xsl:param name="title" as="xs:string" />
		<xsl:param name="defaultTitle" as="xs:string" />
		<xsl:param name="node" as="item()" />
		<xsl:choose>
			<xsl:when test="$title">
				<xsl:value-of select="$title" />
			</xsl:when>
			<xsl:when test="string-length($node/@title) gt 0">
				<xsl:variable name="version" select="if (string-length($node/@schemaVersion) gt 0)
				then concat(' (Version ',$node/@schemaVersion,')') else ''" />
				<xsl:value-of select="concat($node/@title, $version)" />
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="if ($defaultTitle) then $defaultTitle else ''" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>

	<!--
	****************************************************************************
	Default rendering for documentation nodes
	****************************************************************************
	-->

	<xsl:template match="svrl:text">
		<xsl:call-template name="render_description" />
	</xsl:template>

	<xsl:template name="render_description">
		<xsl:choose>
			<xsl:when test="./xhtml:p">
				<xsl:for-each select="./xhtml:p">
					<xsl:variable name="lang" select="@lang" />
					<xsl:element name="p">
						<xsl:attribute name="lang" select="$lang" />
						<xsl:if test="contains($hiddenLanguages, $lang)">
							<xsl:attribute name="class" select="$hiddenClassName" />
						</xsl:if>
						<xsl:copy-of select="." />
					</xsl:element>
				</xsl:for-each>
			</xsl:when>
			<xsl:otherwise>
				<p>
					<xsl:copy-of select="." />
				</p>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template match="iso:span">
		<span>
			<xsl:copy-of select="@*" />
			<xsl:apply-templates />
		</span>
	</xsl:template>

	<xsl:template match="iso:emph">
		<em>
			<xsl:copy-of select="@*" />
			<xsl:apply-templates />
		</em>
	</xsl:template>

	<xsl:template match="text()">
		<xsl:copy-of select="." />
	</xsl:template>

	<!--
	****************************************************************************
	Rendering of the active patterns
	****************************************************************************
	-->

	<xsl:template name="render_pattern">
		<xsl:param name="firedRules" />
		<xsl:param name="positivePatternTests" />

		<xsl:variable name="class" select="concat('pattern',
			if (count($firedRules) eq 0) then ' no-rules' else '',
		if (count($positivePatternTests) eq 0) then ' no-alerts' else '')" />

		<xsl:variable name="id" select="if(@id) then @id else format-number(position(),'0000')" />
		<xsl:variable name="title" select="if(@name) then @name else $id" />

		<table class="{$class}" id="{$id}">
			<thead>
				<xsl:call-template name="render_pattern_header">
					<xsl:with-param name="title" select="$title" />
					<xsl:with-param name="firedRules" select="$firedRules" />
					<xsl:with-param name="positivePatternTests" select="$positivePatternTests" />
				</xsl:call-template>
			</thead>
			<xsl:if test="not($noPatternDetails)">
				<tbody>
					<xsl:call-template name="render_pattern_body" />
				</tbody>
			</xsl:if>
		</table>
	</xsl:template>

	<xsl:template name="render_pattern_header">
		<xsl:param name="title" />
		<xsl:param name="firedRules" />
		<xsl:param name="positivePatternTests" />
		<tr>
			<th class="pattern-header label-left">
				<xsl:copy-of select="ms:label('Pattern',':')" />
			</th>
			<th class="pattern-header value-left">
				<xsl:value-of select="$title" />
			</th>
			<th class="pattern-header label-left">
				<xsl:variable name="distinctFiredRules" select="$firedRules[not(@id = preceding::svrl:fired-rule/@id)]" />
				<xsl:copy-of select="concat(ms:label('label.messages', concat(': ', string(count($positivePatternTests)))), ', ', ms:label('label.rules', concat(': ', string(count($distinctFiredRules)))))" />
			</th>
			<th class="pattern-header value-right" width="10%">
				<xsl:if test="@see">
					<xsl:variable name="icon" select="concat($imagesDir,'/','see.png')" />
					<a href="{@see}" target="_blank">
						<img src="{$icon}" alt="{@see}" title="{@see}" />
					</a>
				</xsl:if>
			</th>
		</tr>
	</xsl:template>

	<xsl:template name="render_pattern_body">
		<xsl:if test="svrl:text">
			<tr class="{$detailsClass}">
				<td class="label-left">
					<xsl:copy-of select="ms:label('Description')" />
				</td>
				<td colspan="3">
					<xsl:apply-templates select="svrl:text" />
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template match="svrl:active-pattern" mode="render-fired-rules">
		<xsl:param name="firedRules" />
		<div class="{$rulesContainerClass}">
			<xsl:apply-imports>
				<xsl:with-param name="firedRules" select="$firedRules" />
			</xsl:apply-imports>
		</div>
		<xsl:variable name="id" select="if(@id) then @id else position()" />
		<xsl:comment>End of rules container of pattern <xsl:value-of select="$id" />
		</xsl:comment>
	</xsl:template>

	<!--
	****************************************************************************
	Rendering of the fired rules
	****************************************************************************
	-->

	<xsl:template name="render_rule">
		<xsl:param name="positiveRuleTests" />

		<xsl:variable name="class" select="concat('rule',
		if (count($positiveRuleTests) eq 0) then ' no-alerts' else '')" />
		<xsl:variable name="id" select="if(@id) then @id else generate-id()" />

		<table class="{$class}" id="{$id}">
			<thead>
				<xsl:call-template name="render_rule_header">
					<xsl:with-param name="title" select="$id" />
					<xsl:with-param name="positiveRuleTests" select="$positiveRuleTests" />
				</xsl:call-template>
			</thead>
			<tbody>
				<xsl:call-template name="render_rule_body" />
			</tbody>
		</table>
	</xsl:template>

	<xsl:template name="render_rule_header">
		<xsl:param name="title" />
		<xsl:param name="positiveRuleTests" />
		<tr>
			<th class="label-left">
				<xsl:copy-of select="ms:label('Rule',':')" />
			</th>
			<th class="value-left">
				<xsl:value-of select="$title" />
			</th>
			<th class="label-left">
				<xsl:variable name="totals" select="concat(': ',count($positiveRuleTests))" />
				<xsl:copy-of select="ms:label('label.messages',$totals)" />
			</th>
			<th class="value-right" width="10%">
				<xsl:if test="@see">
					<xsl:variable name="icon" select="concat($imagesDir,'/','see.png')" />
					<a href="{@see}" target="_blank">
						<img src="{$icon}" alt="{@see}" title="{@see}" />
					</a>
				</xsl:if>
			</th>
		</tr>
	</xsl:template>

	<xsl:template name="render_rule_body">
		<xsl:variable name="endElement" select="following-sibling::*[not(self::xhtml:*|self::svrl:text)][1]" />
		<xsl:variable name="documentation" select="following-sibling::*[. &lt;&lt; $endElement]" />

		<xsl:if test="not($noRuleDetails) and $documentation[self::xhtml:h3]">
			<tr class="{$detailsClass}">
				<td class="label-left">
					<xsl:copy-of select="concat(ms:label('Title'),':')" />
				</td>
				<td colspan="3" class="{$descriptionClass}">
					<xsl:copy-of select="ms:span($documentation[self::xhtml:h3])" />
				</td>
			</tr>
		</xsl:if>
		<xsl:if test="not($noRuleDetails) and $documentation[self::svrl:text or self::xhtml:p]">
			<tr class="{$detailsClass}">
				<td class="label-left">
					<xsl:copy-of select="concat(ms:label('Description'),':')" />
				</td>
				<td colspan="3" class="{$descriptionClass}">
					<xsl:apply-templates select="$documentation[self::svrl:text]" />
					<xsl:copy-of select="ms:span($documentation[self::xhtml:p])" />
				</td>
			</tr>
		</xsl:if>
		<tr>
			<td class="label-left">
				<xsl:copy-of select="concat(ms:label('Context'),':')" />
			</td>
			<td colspan="3">
				<xsl:value-of select="@context" />
			</td>
		</tr>
	</xsl:template>

	<xsl:template match="svrl:fired-rule" mode="render-reports">
		<xsl:param name="positiveRuleTests" />
		<div class="{$alertsContainerClass}">
			<xsl:apply-imports>
				<xsl:with-param name="positiveRuleTests" select="$positiveRuleTests" />
			</xsl:apply-imports>
		</div>
		<xsl:variable name="id" select="if(@id) then @id else generate-id()" />
		<xsl:comment>End of reports container of rule <xsl:value-of select="$id" />
		</xsl:comment>
	</xsl:template>

	<!--
	****************************************************************************
	Rendering of the alerts (successful reports and failed asserts)
	****************************************************************************
	-->

	<xsl:template match="svrl:failed-assert | svrl:successful-report">
		<xsl:if test="not(@role) or not(matches($hiddenRoles,concat('(^|\W)',@role,'($|\W)')))">
			<table class="{concat('alert ',@role)}">
				<thead>
					<xsl:call-template name="render_alert_header" />
				</thead>
				<tbody>
					<xsl:call-template name="render_alert_body" />
				</tbody>
			</table>
		</xsl:if>
	</xsl:template>

	<xsl:template name="render_alert_header">
		<tr>
			<th class="label-left">
				<xsl:copy-of select="ms:label(if (self::svrl:failed-assert)
				then 'Assert' else 'Report',':')" />
			</th>
			<th class="value-left">
				<xsl:value-of select="@id" />
			</th>
			<th width="40">
				<xsl:variable name="roleIcon" select="concat($imagesDir,'/',
				if(@role) then @role else 'missing','.png')" />
				<xsl:variable name="roleTooltip" select="ms:label(@role)" />
				<img src="{$roleIcon}" alt="{@role}" title="{$roleTooltip}" />
				<xsl:if test="@see">
					<xsl:variable name="seeIcon" select="concat($imagesDir,'/','see.png')" />
					<xsl:variable name="seeTooltip" select="ms:label('see.tooltip')" />
					<a href="{@see}" target="_blank">
						<img src="{$seeIcon}" alt="{@see}" title="{$seeTooltip}" />
					</a>
				</xsl:if>
			</th>
		</tr>
	</xsl:template>

	<xsl:template name="render_alert_body">
		<xsl:if test="not($noAlertDetails)">
			<tr class="{$detailsClass}">
				<td>
					<xsl:copy-of select="ms:label('Test',':')" />
				</td>
				<td colspan="2">
					<xsl:value-of select="@test" />
				</td>
			</tr>
			<tr class="{$detailsClass}">
				<td>
					<xsl:copy-of select="ms:label('Location',':')" />
				</td>
				<td colspan="2">
					<xsl:value-of select="@location" />
				</td>
			</tr>
		</xsl:if>
		<tr>
			<td>
				<xsl:copy-of select="ms:label('Description',':')" />
			</td>
			<td colspan="2" class="{$descriptionClass}">
				<xsl:apply-templates />
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>
