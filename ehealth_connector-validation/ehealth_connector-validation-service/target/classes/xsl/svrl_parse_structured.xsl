<?xml version="1.0" encoding="UTF-8"?>
<!--
***********************************************"********************************
Stylesheet allowing a structured parsing of a SVRL document.

Parameters:
ignoreEmptyPatterns:  Do not render patterns having no rules, nor failed
asserts, nor successful reports (default: false)
ignoreEmptyRules:     Do not render rules having no failed asserts nor
successful reports (default: false)
ignoreAllRules:       Never render rules (default: false)
visibleRoles:			Do render asserts/reports of these classes
(default: visibleRoles= error warning information debug)

History:
30.12.2012: Laurent Millet, first version (draft)
02.01.2013: Laurent Millet, first final version
08.01.2013: Laurent Millet, corrected bug and enhancements
05.10.2015: Tony Schaller, improved multi language support
*******************************************************************************
-->
<xsl:stylesheet version="2.0"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:svrl="http://purl.oclc.org/dsdl/svrl"
	exclude-result-prefixes="svrl">

	<xsl:param name="ignoreEmptyPatterns" select="false()" />
	<xsl:param name="ignoreEmptyRules" select="false()" />
	<xsl:param name="ignoreAllRules" select="false()" />
	<xsl:param name="visibleRoles" as="xs:string?">error warning information debug</xsl:param>

	<!-- ==================================================================== -->
	<!-- Named Templates (callback functions)                                 -->
	<!--                                                                      -->
	<!-- The following named templates are examples. The importing stylesheet -->
	<!-- should overwrite and redefine this templates.                        -->
	<!-- ==================================================================== -->

	<xsl:template name="render_pattern">
		<xsl:param name="firedRules" />
		<xsl:param name="positivePatternTests" />
		<xsl:message>
		At active pattern [<xsl:value-of select="if(@id) then @id else position()" />]
		Fired Rules   : <xsl:value-of select="count($firedRules)" />
		Messages		: <xsl:value-of select="count($positivePatternTests)" />
	</xsl:message>
</xsl:template>

<xsl:template name="render_rule">
	<xsl:param name="positiveRuleTests" />
	<xsl:message>
	At rule [<xsl:value-of select="if(@id) then @id else @context" />]
	Fired : <xsl:value-of select="last()" />
	Alerts: <xsl:value-of select="count($positiveRuleTests)" />
</xsl:message>
</xsl:template>

<!-- ==================================================================== -->
<!-- Root Template                                                        -->
<!-- ==================================================================== -->

<xsl:template match="/">
	<xsl:message>
		Ignore Empty Patterns: <xsl:value-of select="$ignoreEmptyPatterns" />
		Ignore Empty Rules: <xsl:value-of select="$ignoreEmptyRules" />
		Ignore All Rules: <xsl:value-of select="$ignoreAllRules" />
	</xsl:message>
	<xsl:apply-templates select="//svrl:active-pattern" />
</xsl:template>

<!-- ==================================================================== -->
<!-- Active Patterns                                                      -->
<!-- ==================================================================== -->

<xsl:template match="svrl:active-pattern">
	<xsl:variable name="nextPattern" select="
	following-sibling::svrl:active-pattern[1]" />

	<xsl:variable name="firedRules" select="if ($nextPattern)
		then following-sibling::svrl:fired-rule[. &lt;&lt; $nextPattern]
	else following-sibling::svrl:fired-rule" />

	<xsl:variable name="positivePatternTests" select="if ($nextPattern)
		then (following-sibling::svrl:failed-assert
		| following-sibling::svrl:successful-report)[. &lt;&lt; $nextPattern]
		else (following-sibling::svrl:failed-assert
	| following-sibling::svrl:successful-report)" />

	<xsl:variable name="hasRules" select="count($firedRules) gt 0" />
	<xsl:variable name="hasErrors" select="count($positivePatternTests[not(@role) or @role='error']) gt 0" />
	<xsl:variable name="hasWarnings" select="count($positivePatternTests[@role='warning']) gt 0" />
	<xsl:variable name="hasInfos" select="count($positivePatternTests[@role='information' or @role='info']) gt 0" />
	<xsl:variable name="hasDebugs" select="count($positivePatternTests[@role='debug']) gt 0" />
	<xsl:variable name="rulesFiltered" select="$ignoreEmptyRules or $ignoreAllRules" />

	<xsl:variable name="doRenderPattern" select="not($ignoreEmptyPatterns)
		or (not($rulesFiltered) and $hasRules)
		or (contains($visibleRoles,'error') and $hasErrors)
		or (contains($visibleRoles,'warning') and $hasWarnings)
		or (contains($visibleRoles,'info') and $hasInfos)
	or (contains($visibleRoles,'debug') and $hasDebugs)" />

	<xsl:if test="$doRenderPattern">
		<xsl:call-template name="render_pattern">
			<xsl:with-param name="firedRules" select="$firedRules" />
			<xsl:with-param name="positivePatternTests" select="$positivePatternTests" />
		</xsl:call-template>

		<xsl:apply-templates select="." mode="render-fired-rules">
			<xsl:with-param name="firedRules" select="$firedRules" />
		</xsl:apply-templates>
	</xsl:if>
</xsl:template>

<xsl:template match="svrl:active-pattern" mode="render-fired-rules">
	<xsl:param name="firedRules" />
	<xsl:for-each select="distinct-values($firedRules/@context)">
		<xsl:apply-templates select="$firedRules[@context=current()]" />
	</xsl:for-each>
</xsl:template>

<!-- ==================================================================== -->
<!-- Fired Rules                                                          -->
<!-- ==================================================================== -->

<xsl:template match="svrl:fired-rule">
	<xsl:if test="position() eq 1">
		<xsl:variable name="patternId" select="
		preceding-sibling::svrl:active-pattern[1]/generate-id()" />

		<xsl:variable name="positiveRuleTests" select="
			(following-sibling::svrl:failed-assert | following-sibling::svrl:successful-report)
			[preceding-sibling::svrl:active-pattern[1]/generate-id()=$patternId
		and preceding-sibling::svrl:fired-rule[1]/@context=current()/@context]" />

		<xsl:variable name="hasReports" select="count($positiveRuleTests) gt 0" />
		<xsl:variable name="doRenderRule" select="not($ignoreAllRules)
		and (not($ignoreEmptyRules) or $hasReports)" />

		<xsl:if test="$doRenderRule">
			<xsl:call-template name="render_rule">
				<xsl:with-param name="positiveRuleTests" select="$positiveRuleTests" />
			</xsl:call-template>
		</xsl:if>

		<xsl:apply-templates select="." mode="render-reports">
			<xsl:with-param name="positiveRuleTests" select="$positiveRuleTests" />
		</xsl:apply-templates>
	</xsl:if>
</xsl:template>

<xsl:template match="svrl:fired-rule" mode="render-reports">
	<xsl:param name="positiveRuleTests" />
	<xsl:apply-templates select="$positiveRuleTests" />
</xsl:template>

<!-- ==================================================================== -->
<!-- Failed Asserts and Successful Reports                                -->
<!-- ==================================================================== -->

<xsl:template match="svrl:failed-assert | svrl:successful-report">
	<xsl:message>
		At <xsl:value-of select="concat('[',@location,'] ',svrl:text)" />
	</xsl:message>
</xsl:template>

</xsl:stylesheet>
