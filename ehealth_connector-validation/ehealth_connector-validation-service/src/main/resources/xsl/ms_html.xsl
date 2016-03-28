<?xml version="1.0" encoding="UTF-8"?>
<!--
******************************************************************************
Contains generic, reusable XSL templates and functions.

Prerequisites:
- this scripts requires the ms_base.xsl script for the basic localization support

History:
17.12.2012: Laurent Millet, medshare GmbH
02.03.2013: Laurent Millet, new, enhanced version
05.10.2015: Tony Schaller, improved multi language support
******************************************************************************
-->
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:ms="http://medshare.net/XSLBase"
	exclude-result-prefixes="xs ms">

	<xsl:variable name="hiddenClassName">hidden</xsl:variable>

	<!--
	****************************************************************************
	Dynamically adds or removes the hidden value from the class attribute.

	If an element has a "lang" attribute and if its value matches the value of
	the "lang" variable, then the "hidden" value is removed from the "class"
	attribute. In the other case, and if the "lang" variable  is not set or
	is empty, the "hidden" value is added to the "class" attribute.
	****************************************************************************
	-->

	<xsl:template match="*[@lang or @xml:lang]">
		<xsl:variable name="otherClasses" select="tokenize(normalize-space(
		replace(@class,$hiddenClassName,'')),'\s+')" />

		<xsl:variable name="classes" select="
			if (@lang=$detectedLanguages or @xml:lang=$detectedLanguages)
		then $otherClasses else ($otherClasses,$hiddenClassName)" />

		<xsl:copy>
			<xsl:copy-of select="@*" />
			<xsl:if test="exists($classes)">
				<xsl:attribute name="class" select="string-join($classes,' ')" />
			</xsl:if>
			<xsl:apply-templates select="node()" />
		</xsl:copy>
	</xsl:template>

	<!--
	****************************************************************************
	Rendering of the HTML header and body
	****************************************************************************
	-->

	<xsl:template name="render_html">
		<xsl:param name="title" as="xs:string?">HTML-Template</xsl:param>
		<xsl:param name="styles" as="xs:string*" />
		<xsl:param name="scripts" as="xs:string*" />
		<html>
			<head>
				<xsl:for-each select="$styles">
					<link rel="stylesheet" type="text/css" href="{.}" />
				</xsl:for-each>
				<title>
					<xsl:value-of select="$title" />
				</title>
				<xsl:for-each select="$scripts">
					<script src="{.}" />
				</xsl:for-each>
				<style>
					<xsl:value-of select="ms:replace('.$1 {display:none;}', $hiddenClassName)" />
				</style>
				<xsl:call-template name="render_html_head" />
			</head>
			<body>
				<xsl:call-template name="render_html_body" />
			</body>
		</html>
	</xsl:template>

	<xsl:template name="render_html_head" />
	<xsl:template name="render_html_body">
		<xsl:apply-templates />
	</xsl:template>

	<!--
	****************************************************************************
	Functions
	****************************************************************************
	-->

	<xsl:function name="ms:label" as="element(span)*">
		<xsl:param name="key" as="xs:string" />
		<xsl:copy-of select="ms:label($key,'')" />
	</xsl:function>

	<xsl:function name="ms:label" as="element(span)*">
		<xsl:param name="key" as="xs:string" />
		<xsl:param name="append" as="xs:string" />
		<xsl:copy-of select="ms:label($key,$append,'span')" />
	</xsl:function>

	<xsl:function name="ms:label" as="element()*">
		<xsl:param name="key" as="xs:string" />
		<xsl:param name="append" as="xs:string" />
		<xsl:param name="element" as="xs:string" />
		<xsl:for-each select="$detectedLanguages">
			<xsl:variable name="lang" select="." />
			<xsl:if test="$lang=$uiLanguage">
				<xsl:element name="{if($element) then $element else 'span'}">
					<xsl:attribute name="lang" select="$lang" />
					<xsl:value-of select="concat(ms:localized($key,$lang),$append)" />
				</xsl:element>
			</xsl:if>
		</xsl:for-each>
	</xsl:function>

	<xsl:function name="ms:span" as="element(span)*">
		<xsl:param name="elements" as="element()*" />
		<xsl:for-each select="$detectedLanguages">
			<xsl:variable name="lang" select="." />
			<xsl:element name="span">
				<xsl:attribute name="lang" select="$lang" />
				<xsl:if test="contains($hiddenLanguages, $lang)">
					<xsl:attribute name="class" select="$hiddenClassName" />
				</xsl:if>
				<xsl:value-of select="if($elements[@lang=$lang])
				then $elements[@lang=$lang]/text() else $elements[1]/text()" />
				<br />
			</xsl:element>
		</xsl:for-each>
	</xsl:function>

</xsl:stylesheet>
