<?xml version="1.0" encoding="UTF-8"?>
<!--
********************************************************
Stylesheet for Documenting Schematron Rules and output as xhtml

Mit param name language werden die sprachlichen Meldungen gefiltert.
Dieser Parameter kann mittels Angabe als Xslt Argument beim XSL Transformer angegeben werden und damit kann dieses Stylesheet für alle Sprachen eingesetzt werden
- Java: <param name="lang" value="fr_ch" />
- .Net: XsltArgumentList.AddParam("language", "", "fr_ch");

History:
11.02.2010 Created by oliver egger, visionary ag
23.01.2011 Changed by Tony Schaller, medshare GmbH (Variables xsl:template match not allowed when using .Net XslCompiledTransform.Transform -> select in template not in match)
01.10.2011 Changed by Tony Schaller, medshare GmbH (enhancements for English and Italian translation of Schematrons)
********************************************************
-->
<xsl:stylesheet version="2.0"
	xmlns:xhtml="http://www.w3.org/1999/xhtml"
	xmlns="http://www.w3.org/1999/xhtml"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:sch="http://purl.oclc.org/dsdl/schematron">

	<xsl:output method="xml" omit-xml-declaration="yes" version="1.0" encoding="UTF-8" indent="yes"/>

	<!-- SDefault Sprach-Filter; wird durch Angabe als Parameter von 'aussen' übersteuert -->
	<xsl:param name="language">de_ch</xsl:param>

	<!-- Matched das Schemaelement -->
	<xsl:template match="sch:schema">
		<html xmlns="http://www.w3.org/1999/xhtml">
			<xsl:attribute name="xml:lang">
				<xsl:value-of select="$language" />
			</xsl:attribute>
			<head>
				<xsl:if test="xhtml:h1">
					<title>
						<xsl:value-of select="xhtml:h1[@lang=$language]"/>
					</title>
				</xsl:if>
				<meta http-equiv = "content-type" content = "application/xhtml+xml; charset=UTF-8" />
				<link rel="stylesheet" type="text/css" href="../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch-doc.css"></link>
			</head>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>

	<!-- Unterdrücken von nicht xhtml Text Elementen -->
	<xsl:template match="text()" />
	<xsl:template match="text()" mode="rulestranslated"/>
	<xsl:template match="text()" mode="entitydocumented"/>

	<!--  1. Wechsel des Namspaces der xhtml Elemente auf den Standard Namespace
	2. Seleketion nur von xhmtl Elementen die richtige Sprache gesetzt haben (oder keine)
	3. Entfernen des Sprachattributes aus dem Output -->
	<xsl:template match="xhtml:*">
		<xsl:choose>
			<xsl:when test="string(@lang)=$language or string(@lang)=''">
				<xsl:element name="{local-name()}">
					<xsl:for-each select="@*">
						<xsl:if test="name()!='lang'">
							<xsl:attribute name="{name()}">
								<xsl:value-of select="." />
							</xsl:attribute>
						</xsl:if>
					</xsl:for-each>
					<xsl:value-of select="text()"/>
					<xsl:apply-templates />
				</xsl:element>
			</xsl:when>
		</xsl:choose>
	</xsl:template>

	<!--  1. Wechsel des Namspaces der xhtml Elemente auf den Standard Namespace
	2. Seleketion nur von xhmtl Elementen die richtige Sprache gesetzt haben (oder keine)
	3. Entfernen des Sprachattributes aus dem Output -->
	<xsl:template match="xhtml:*" mode="entitydocumented">
		<xsl:choose>
			<xsl:when test="string(@lang)=$language or string(@lang)=''">
				<xsl:element name="{local-name()}">
					<xsl:for-each select="@*">
						<xsl:if test="name()!='lang'">
							<xsl:attribute name="{name()}">
								<xsl:value-of select="." />
							</xsl:attribute>
						</xsl:if>
					</xsl:for-each>
					<xsl:value-of select="text()"/>
					<xsl:apply-templates mode="entitydocumented"/>
				</xsl:element>
			</xsl:when>
		</xsl:choose>
	</xsl:template>


	<!--  Stellt einen Enitität dar -->
	<xsl:template match="sch:pattern">
		<xsl:choose>
			<xsl:when test="xhtml:ul/@id">
				<div>
					<table class="head">
						<thead>
							<tr>
								<th class="label1" width="10%">
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Entity']/@displayName"/>
									<xsl:text>:</xsl:text>
								</th>
								<th class="value1">
									<xsl:value-of select="xhtml:ul/@id" />
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="label1">
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='File']/@displayName"/>
									<xsl:text>:</xsl:text>
								</td>
								<td>
									<xsl:value-of select="xhtml:ul/xhtml:li[@class='filename']" />
								</td>
							</tr>
							<tr>
								<td class="label1">
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Version']/@displayName"/>
									<xsl:text>:</xsl:text>
								</td>
								<td>
									<xsl:value-of select="xhtml:ul/xhtml:li[@class='version']" />
								</td>
							</tr>
						</tbody>
					</table>
					<br />
				</div>
			</xsl:when>
		</xsl:choose>

		<xsl:apply-templates select="sch:rule" mode="entitydocumented"/>

	</xsl:template>

	<!--  Stellt einen Assert/Test in einer Tabelle dar -->
	<xsl:template match="sch:assert[@id]" mode="entitydocumented">
		<div>
			<table class="body" width="100%">
				<thead>
					<tr>
						<th class="label1" width="10%">
							<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Rule']/@displayName"/>
							<xsl:text>:</xsl:text>
						</th>
						<th class="value1">
							<xsl:value-of select="@id" />
						</th>
						<th class="label2" width="10%">
							<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Role']/@displayName"/>
							<xsl:text>:</xsl:text>
						</th>
						<th class="value2" width="10%">
							<xsl:choose>
								<xsl:when test="string(@role)">
									<xsl:variable name="role">
										<xsl:value-of select="@role"/>
									</xsl:variable>
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value=$role]/@displayName"/>
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='error']/@displayName"/>
								</xsl:otherwise>
							</xsl:choose>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="label1">
							<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Assert']/@displayName"/>
							<xsl:text>:</xsl:text>
						</td>
						<td colspan="3">
							<xsl:value-of select="@test" />
						</td>
					</tr>
				</tbody>
				<xsl:apply-templates select="child::node()" mode="rulestranslated"/>
			</table>
			<br />
		</div>
	</xsl:template>

	<xsl:template match="xhtml:p" mode="rulestranslated">
		<xsl:choose>
			<xsl:when test="string(@lang)=$language or string(@lang)=''">
				<tr>
					<td>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Description']/@displayName"/>
						<xsl:text>:</xsl:text>
					</td>
					<td colspan="3">
						<xsl:value-of select="."/>
						<xsl:apply-templates  mode="rulestranslated" />
					</td>
				</tr>
			</xsl:when>
		</xsl:choose>
	</xsl:template>

</xsl:stylesheet>
