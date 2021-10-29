<?xml version="1.0"?>
<!--
******************************************************************************
Stylesheet that transforms 
ISO Schematron SVRL containing xhtml elements to a valid medshare SVRL

History:
  2016.04.08: Tony Schaller, medshare GmbH (initial implementation)

******************************************************************************
-->
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xhtml="http://www.w3.org/1999/xhtml"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:svrl="http://purl.oclc.org/dsdl/svrl"
	>
	<xsl:output method="xml" encoding="UTF-8" indent="yes" />

	<!-- copies all content into the output -->
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>

	<!-- remove unused elements -->
	<xsl:template match="extends" />
	<xsl:template match="xhtml:h1" />
	<xsl:template match="xhtml:h2" />
	<xsl:template match="xhtml:h3" />

	<!-- make sure that ids are valid -->
	<xsl:template match="@id">
				<xsl:attribute name="id">
					<xsl:value-of select="concat(concat(replace(.,' ','_'),'_'),generate-id())" />
				</xsl:attribute>
	</xsl:template>

	<!-- tranform xhtml:p to medshare specific svrl:langText elements -->
	<xsl:template match="xhtml:p">
		<xsl:if test="parent::svrl:text/parent::svrl:failed-assert or parent::svrl:text/parent::svrl:successful-report">
			<xsl:element name="svrl:langText">
				<xsl:attribute name="lang">
					<xsl:value-of select="@lang" />
				</xsl:attribute>
				<xsl:copy-of select="text()"/>
			</xsl:element>
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>
