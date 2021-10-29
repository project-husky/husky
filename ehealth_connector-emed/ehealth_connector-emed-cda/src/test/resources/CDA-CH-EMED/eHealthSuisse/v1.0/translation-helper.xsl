<?xml version="1.0" encoding="UTF-8"?>
<!--
********************************************************
Stylesheet for extracting texts for translation and output them as xhtml

Mit param name filename wird der filenamen des Schematronfiles angegeben
Dieser Parameter kann mittels Angabe als Xslt Argument beim XSL Transformer angegeben werden und damit kann dieses Stylesheet für alle Sprachen eingesetzt werden
- Java: <param name="filename" value="cda-ch.sch" />
- .Net: XsltArgumentList.AddParam("filename", "", "cda-ch.sch");


History:
26.01.2011 Created by Tony Schaller, medshare GmbH
********************************************************
-->
<xsl:stylesheet version="2.0"
	xmlns:xhtml="http://www.w3.org/1999/xhtml"
	xmlns="http://www.w3.org/1999/xhtml"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:sch="http://purl.oclc.org/dsdl/schematron">

	<xsl:output method="xml" omit-xml-declaration="yes" version="1.0" encoding="UTF-8" indent="yes"/>

	<!-- Filenamen; wird durch Angabe als Parameter von 'aussen' übersteuert -->
	<xsl:param name="filename">dummy</xsl:param>

	<!-- Matched das Schemaelement -->
	<xsl:template match="sch:schema">
		<html xmlns="http://www.w3.org/1999/xhtml">
			<head>
				<meta http-equiv = "content-type" content = "application/xhtml+xml; charset=UTF-8" />
				<link rel="stylesheet" type="text/css" href="../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch-doc.css"></link>
			</head>
			<body>
				<table class="head">
					<thead>
						<tr>
							<th class="value1" colspan="3">
								<xsl:value-of select="$filename" />
							</th>
						</tr>
					</thead>
					<xsl:apply-templates />
				</table>
			</body>
		</html>
	</xsl:template>

	<!-- Unterdrücken von nicht xhtml Text Elementen -->
	<xsl:template match="text()" />
	<xsl:template match="text()" mode="rulestranslated"/>
	<xsl:template match="text()" mode="entitydocumented"/>

	<!-- Unterdrücken von Aufzählungen (das sind die referenzierten entities...) -->
	<xsl:template match="xhtml:ul" />

	<xsl:template match="xhtml:*">
		<tr>
			<td>
				<xsl:choose>
					<xsl:when test="parent::sch:schema and @lang">
						<!-- Titel / Referenz -->
						<xsl:value-of select="@class"/>
						<xsl:value-of select="@id"/>
					</xsl:when>
					<xsl:when test="parent::sch:pattern">
						<!-- Stufe Pattern -->
						<xsl:text>Pattern: </xsl:text>
						<xsl:value-of select="@id"/>
					</xsl:when>
					<xsl:when test="parent::sch:rule">
						<!-- Stufe Rule  -->
						<xsl:value-of select="ancestor::sch:pattern/xhtml:ul/xhtml:li[@class='filename']"/>
						<xsl:text>.</xsl:text>
						<xsl:choose>
							<xsl:when test="parent::sch:rule/@id">
								<xsl:value-of select="parent::sch:rule/@id"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:text>rule</xsl:text>
							</xsl:otherwise>
						</xsl:choose>
						<xsl:choose>
							<xsl:when test="self::xhtml:p">
								<xsl:text>.desc</xsl:text>
							</xsl:when>
							<xsl:when test="self::xhtml:h3">
								<xsl:text>.head</xsl:text>
							</xsl:when>
							<xsl:otherwise>
								<xsl:text>.unknown</xsl:text>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:when>
					<xsl:when test="parent::sch:assert">
						<!-- Stufe Assert  -->
						<xsl:value-of select="ancestor::sch:pattern/xhtml:ul/xhtml:li[@class='filename']"/>
						<xsl:text>.</xsl:text>
						<xsl:value-of select="parent::sch:assert/@id"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text>unknown entry</xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</td>
			<td>
				<xsl:value-of select="@lang"/>
			</td>
			<td>
				<xsl:value-of select="text()"/>
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>
