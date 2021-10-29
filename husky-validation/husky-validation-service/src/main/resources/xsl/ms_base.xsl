<?xml version="1.0" encoding="UTF-8"?>
<!--
******************************************************************************
Contains generic, reusable XSL templates and functions.

Parameters:
dictionaryUri:        URI of the dictionary file with the localized text
(default: none)

Format of a dictionary document;
<dictionary>
<entry key="word" lang="en" value="word" />
<entry key="word" lang="de" value="Wort" />
<entry key="word" lang="fr" value="mot" />
</dictionary>

History:
17.12.2012: Laurent Millet, medshare GmbH
02.03.2013: Laurent Millet, added support for rendering elements with @lang
05.10.2015: Tony Schaller, improved multi language support
******************************************************************************
-->
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:ms="http://medshare.net/XSLBase"
	exclude-result-prefixes="xs ms">

	<xsl:param name="dictionaryUri" as="xs:string?">dictionary.xml</xsl:param>
	<xsl:variable name="dictionary" select="if(doc-available($dictionaryUri))
	then doc($dictionaryUri)/dictionary else ()" />
	<xsl:variable name="detectedLanguages" select="distinct-values($dictionary/entry/@lang)" />

	<!--
	****************************************************************************
	The two following templates perform a deep copy of the entire XML tree.
	XSL templates matching specific element nodes or having a higher priority
	may overwrite this default behavior.
	****************************************************************************
	-->

	<!-- Perform a deep copy of all attributes and nodes -->
	<xsl:template match="@*|node()" priority="-2">
		<xsl:copy-of select="." />
	</xsl:template>

	<!-- Perform a simple copy of element nodes -->
	<xsl:template match="element()" priority="-1">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()" />
		</xsl:copy>
	</xsl:template>

	<!--
	****************************************************************************
	The following template handles all elements which have the "lang" or
	the "xml:lang" attribute. A matching element is copied to the output
	only if its "lang" attribute is found in the set of provided languages.
	****************************************************************************
	-->

	<xsl:template match="*[@lang or @xml:lang]">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()" />
		</xsl:copy>
	</xsl:template>

	<!--
	****************************************************************************
	Localization related XSL functions.
	****************************************************************************
	-->

	<xsl:function name="ms:localized" as="xs:string">
		<xsl:param name="key" as="xs:string" />
		<xsl:param name="lang" as="xs:string" />
		<xsl:value-of select="ms:localized($key,$lang,())" />
	</xsl:function>

	<xsl:function name="ms:localized" as="element(entry)*">
		<xsl:param name="key" as="xs:string" />
		<xsl:sequence select="$dictionary/entry[@key=$key]" />
	</xsl:function>

	<xsl:function name="ms:localized" as="xs:string">
		<xsl:param name="key" as="xs:string" />
		<xsl:param name="lang" as="xs:string" />
		<xsl:param name="args" as="xs:string*" />
		<xsl:variable name="text" select="$dictionary/entry[@key=$key and @lang=$lang]" />
		<xsl:variable name="value" select="if ($text/@value) then $text/@value else concat('[',$lang,':',$key,']')" />
		<xsl:value-of select="if (exists($args)) then ms:replace($value,$args) else $value" />
	</xsl:function>

	<xsl:function name="ms:replace" as="xs:string">
		<xsl:param name="input" as="xs:string" />
		<xsl:param name="args" as="xs:string*" />
		<xsl:value-of select="ms:replace($input,$args,1)" />
	</xsl:function>

	<xsl:function name="ms:replace" as="xs:string">
		<xsl:param name="input" as="xs:string" />
		<xsl:param name="args" as="xs:string*" />
		<xsl:param name="index" as="xs:integer" />
		<xsl:variable name="value" select="replace($input,concat('\$',$index),$args[$index])" />
		<xsl:value-of select="if ($index lt count($args)) then ms:replace($value,$args,$index+1) else $value" />
	</xsl:function>

</xsl:stylesheet>
