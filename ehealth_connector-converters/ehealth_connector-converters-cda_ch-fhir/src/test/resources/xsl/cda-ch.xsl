<?xml version="1.0" encoding="UTF-8"?>
<!--
********************************************************
Default Stylesheet for CDA-CH

History:
Derived from HL7 Finland R2 Tyylitiedosto: Tyyli_R2_B3_01.xslt
Updated by Calvin E. Beebe, Mayo Clinic - Rochester Mn.
Updated by Keith W. Boone, Dictaphone - Burlington, MA
Updated by Kai U. Heitmann, Heitmann Consulting Service, NL for VHitG, Germany
Updated by Tony Schaller, medshare GmbH and HL7 affiliate Switzerland, for CDA-CH V1.2
Updated by Nico Ehinger, ELCA SA, code refactoring
Updated by Tony Schaller, medshare GmbH and HL7 affiliate Switzerland, revised for CDA-CH Body templates and language dependent rendering
Updated by Tony Schaller, medshare GmbH, revised for base64 embedded object rendering

********************************************************
-->
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:n1="urn:hl7-org:v3"
	xmlns:n2="urn:hl7-org:v3/meta/voc"
	xmlns:voc="urn:hl7-org:v3/voc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	>

	<xsl:output method="html" indent="yes" version="4.01" encoding="ISO-8859-1" doctype-public="-//W3C//DTD HTML 4.01//EN"/>

	<!-- The following variables are designed to be overwritten in a project specific xsl that imports the current cda-ch.xsl an example can be found in suva-emedidoc.xsl -->
	<xsl:variable name="organizationName">
		<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='HL7.ch']/@displayName"/>
	</xsl:variable>

	<xsl:variable name="language">
		<xsl:choose>
			<xsl:when test="/n1:ClinicalDocument/n1:languageCode/@code">
				<xsl:value-of select="substring(/n1:ClinicalDocument/n1:languageCode/@code,1,2)"/>
			</xsl:when>
			<xsl:otherwise>de</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>

	<xsl:variable name="tableWidth">50%</xsl:variable>
	<xsl:variable name="title">
		<xsl:choose>
			<xsl:when test="/n1:ClinicalDocument/n1:title">
				<xsl:value-of select="/n1:ClinicalDocument/n1:title"/>
			</xsl:when>
			<xsl:otherwise>Clinical Document</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	<xsl:template match="/">
		<xsl:apply-templates select="n1:ClinicalDocument"/>
	</xsl:template>
	<xsl:template match="n1:ClinicalDocument">
		<html>
			<head>
				<xsl:comment>
					Do NOT edit this HTML directly, it was generated via an XSLt transformation from the original release 2 CDA
					Document.
				</xsl:comment>
				<title>
					<xsl:value-of select="$title"/>
				</title>
				<xsl:element name="link">
					<xsl:attribute name="rel">stylesheet</xsl:attribute>
					<xsl:attribute name="type">text/css</xsl:attribute>
					<xsl:attribute name="href">../../../../xsl/cda-ch.css</xsl:attribute>
				</xsl:element>
				<xsl:apply-templates select="/processing-instruction('xml-stylesheet')"/>
			</head>
			<body>
				<h1 class="logo">
					<br />
					<xsl:value-of select="$title"/>
				</h1>
				<hr/>
				<table class="head">
					<thead>
						<tr>
							<th class="label1">
								<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Patient']/@displayName"/>
								<xsl:text>:</xsl:text>
							</th>
							<th class="value1">
								<xsl:call-template name="getLastFirstName">
									<xsl:with-param name="name" select="/n1:ClinicalDocument/n1:recordTarget/n1:patientRole/n1:patient/n1:name"/>
								</xsl:call-template>
							</th>
							<th class="label2">
								<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Birthday']/@displayName"/>
								<xsl:text>:</xsl:text>
							</th>
							<th class="value2">
								<xsl:call-template name="formatDate">
									<xsl:with-param name="date"
									select="/n1:ClinicalDocument/n1:recordTarget/n1:patientRole/n1:patient/n1:birthTime/@value"/>
								</xsl:call-template>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="label1">
							</td>
							<td class="value1">
								<xsl:call-template name="getContactInfo">
									<xsl:with-param name="contact" select="/n1:ClinicalDocument/n1:recordTarget/n1:patientRole"/>
								</xsl:call-template>
							</td>
							<td class="label2">
								<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='IDsPatient']/@displayName"/>
								<xsl:text>:</xsl:text>
							</td>
							<td class="value2">
								<xsl:call-template name="getIDs">
									<xsl:with-param name="entity" select="/n1:ClinicalDocument/n1:recordTarget/n1:patientRole"/>
								</xsl:call-template>
							</td>
						</tr>
						<tr>
							<xsl:variable name="sex"
							select="/n1:ClinicalDocument/n1:recordTarget/n1:patientRole/n1:patient/n1:administrativeGenderCode/@code"/>
							<xsl:variable name="maritalStatus"
							select="/n1:ClinicalDocument/n1:recordTarget/n1:patientRole/n1:patient/n1:maritalStatusCode/@code"/>
							<xsl:variable name="religion"
							select="/n1:ClinicalDocument/n1:recordTarget/n1:patientRole/n1:patient/n1:religiousAffiliationCode/n1:originalText/text()"/>

							<td class="label1">
								<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Creation']/@displayName"/>
								<xsl:text>:</xsl:text>
							</td>
							<td class="value1">
								<xsl:call-template name="formatDate">
									<xsl:with-param name="date" select="/n1:ClinicalDocument/n1:effectiveTime/@value"/>
								</xsl:call-template>
							</td>
							<td class="label2">
								<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Sex']/@displayName"/>
								<xsl:text>:</xsl:text>
								<xsl:if test="$maritalStatus">
									<br />
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatus']/@displayName"/>
									<xsl:text>:</xsl:text>
								</xsl:if>
								<xsl:if test="$religion">
									<br />
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Religion']/@displayName"/>
									<xsl:text>:</xsl:text>
								</xsl:if>
							</td>
							<td class="value2">
								<xsl:choose>
									<xsl:when test="$sex='M'">
										<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='man']/@displayName"/>
									</xsl:when>
									<xsl:when test="$sex='F'">
										<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='woman']/@displayName"/>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='unknown']/@displayName"/>
									</xsl:otherwise>
								</xsl:choose>
								<xsl:if test="$maritalStatus">
									<br />
									<xsl:choose>
										<xsl:when test="$maritalStatus='A'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatusAnnulled']/@displayName"/>
										</xsl:when>
										<xsl:when test="$maritalStatus='D'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatusDivorced']/@displayName"/>
										</xsl:when>
										<xsl:when test="$maritalStatus='T'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatusDomesticPartner']/@displayName"/>
										</xsl:when>
										<xsl:when test="$maritalStatus='L'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatusLegallySeparated']/@displayName"/>
										</xsl:when>
										<xsl:when test="$maritalStatus='M'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatusMarried']/@displayName"/>
										</xsl:when>
										<xsl:when test="$maritalStatus='S'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatusNeverMarried']/@displayName"/>
										</xsl:when>
										<xsl:when test="$maritalStatus='P'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatusPolygamous']/@displayName"/>
										</xsl:when>
										<xsl:when test="$maritalStatus='W'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='MaritalStatusWidowed']/@displayName"/>
										</xsl:when>
										<xsl:otherwise>
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='unknown']/@displayName"/>
										</xsl:otherwise>
									</xsl:choose>
								</xsl:if>
								<xsl:if test="$religion">
									<br />
									<xsl:value-of select="$religion"/>
								</xsl:if>
							</td>
						</tr>
					</tbody>
				</table>
				<hr/>
				<xsl:apply-templates select="n1:component/n1:structuredBody|n1:component/n1:nonXMLBody"/>
				<xsl:call-template name="participants"/>
				<hr/>
				<xsl:call-template name="bottomline"/>
				<hr/>
			</body>
		</html>
	</xsl:template>

	<!-- apply custom css  -->
	<xsl:template match="/processing-instruction('xml-stylesheet')">
		<xsl:variable name="type" select='substring-before(substring-after(., "type=&apos;"), "&apos;")'/>
		<xsl:choose>
			<xsl:when test="$type='text/css'">
				<xsl:element name="link">
					<xsl:attribute name="rel">stylesheet</xsl:attribute>
					<xsl:attribute name="type">text/css</xsl:attribute>
					<xsl:attribute name="href">
						<xsl:value-of select='substring-before(substring-after(., "href=&apos;"), "&apos;")'/>
					</xsl:attribute>
				</xsl:element>
			</xsl:when>
		</xsl:choose>
	</xsl:template>

	<!-- Get all IDs  -->
	<xsl:template name="getIDs">
		<xsl:param name="entity"/>
		<table class="pids">
			<xsl:apply-templates select="$entity/n1:id"/>
		</table>
	</xsl:template>
	<xsl:template match="n1:id">
		<tr>
			<td width="50%" align="left">
				<xsl:variable name="domain"
				select="./@root"/>
				<xsl:choose>
					<xsl:when test="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value=$domain]/@displayName">
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value=$domain]/@displayName"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="./@root"/>
					</xsl:otherwise>
				</xsl:choose>
				<xsl:text>:</xsl:text>
			</td>
			<td width="50%" align="left">
				<xsl:value-of select="./@extension"/>
			</td>
		</tr>
	</xsl:template>

	<!-- Get a Name  -->
	<xsl:template name="getName">
		<xsl:param name="name"/>
		<xsl:choose>
			<xsl:when test="$name/n1:family">
				<xsl:if test="$name/n1:prefix">
					<xsl:value-of select="$name/n1:prefix"/>
					<xsl:text> </xsl:text>
				</xsl:if>
				<xsl:value-of select="$name/n1:given"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="$name/n1:family"/>
				<xsl:if test="$name/n1:suffix">
					<xsl:text>, </xsl:text>
					<xsl:value-of select="$name/n1:suffix"/>
				</xsl:if>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$name"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="getLastFirstName">
		<xsl:param name="name"/>
		<xsl:choose>
			<xsl:when test="$name/n1:family">
				<xsl:value-of select="$name/n1:family"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="$name/n1:given"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$name"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- Get the recipient type  -->
	<xsl:template name="getRecipientType">
		<xsl:param name="typeCode"/>
		<xsl:choose>
			<xsl:when test="$typeCode='PRCP'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='PrimaryReceiver']/@displayName"/>
			</xsl:when>
			<xsl:when test="$typeCode='TRC'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='SecondaryReceiver']/@displayName"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='unknown']/@displayName"/>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:text>:</xsl:text>
	</xsl:template>

	<!--  Format Date
	outputs a date in Month Day, Year form
	e.g., 19991207  ==>  7. Dezember 1999 -->
	<xsl:template name="formatDate">
		<xsl:param name="date"/>
		<xsl:choose>
			<xsl:when test="substring ($date, 7, 1)='0'">
				<xsl:value-of select="substring ($date, 8, 1)"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="substring ($date, 7, 2)"/>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:choose>
			<xsl:when test="$language='de' or $language='de-CH'">
				<xsl:text>. </xsl:text>
			</xsl:when>
			<xsl:otherwise>
				<xsl:text> </xsl:text>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:variable name="month" select="substring ($date, 5, 2)"/>
		<xsl:choose>
			<xsl:when test="$month='01'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='January']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='02'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='February']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='03'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='March']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='04'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='April']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='05'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='May']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='06'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='June']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='07'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='July']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='08'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='August']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='09'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='September']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='10'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='October']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='11'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='November']/@displayName"/>
			</xsl:when>
			<xsl:when test="$month='12'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='December']/@displayName"/>
			</xsl:when>
		</xsl:choose>
		<xsl:text> </xsl:text>
		<xsl:value-of select="substring ($date, 1, 4)"/>
	</xsl:template>
	<xsl:template match="n1:component/n1:nonXMLBody">
		<xsl:choose>
			<!-- if there is a reference, use that in an IFRAME -->
			<xsl:when test="n1:text/n1:reference">
				<IFRAME name="nonXMLBody" id="nonXMLBody" WIDTH="100%" HEIGHT="66%" src="{n1:text/n1:reference/@value}"/>
			</xsl:when>
			<xsl:when test="n1:text/@mediaType='text/plain'">
				<pre>
					<xsl:value-of select="n1:text/text()"/>
				</pre>
			</xsl:when>
			<xsl:otherwise>
				<CENTER>Cannot display the text</CENTER>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- StructuredBody -->
	<xsl:template match="n1:component/n1:structuredBody">
		<xsl:apply-templates select="n1:component/n1:section"/>
	</xsl:template>

	<!-- Component/Section -->
	<xsl:template match="n1:component/n1:section">
		<xsl:apply-templates select="n1:title">
			<xsl:with-param name="code" select="n1:code/@code"/>
		</xsl:apply-templates>
		<ul>
			<xsl:apply-templates select="n1:text"/>
			<xsl:if test="n1:component/n1:section">
				<div>
					<br/>
					<xsl:apply-templates select="n1:component/n1:section"/>
				</div>
			</xsl:if>
		</ul>
	</xsl:template>

	<!--  Title  -->
	<xsl:template match="n1:title">
		<xsl:param name="code" select="''"/>
		<h3 title="{$code}">
			<xsl:value-of select="."/>
		</h3>
	</xsl:template>

	<!--  Text   -->
	<xsl:template match="n1:text">
		<xsl:apply-templates select="n1:linkHtml"/>
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="n1:linkHtml">
		<a href="{@href}" target="_blank">
			<u>
				<xsl:value-of select="."/>
			</u>
		</a>
	</xsl:template>

	<!--  Paragraph  -->
	<xsl:template match="n1:paragraph">
		<xsl:apply-templates/>
		<p />
	</xsl:template>

	<!--  Line break  -->
	<xsl:template match="n1:br">
		<xsl:apply-templates/>
		<br />
	</xsl:template>

	<!--  Content w/ deleted text is hidden -->
	<xsl:template match="n1:content[@revised='delete']"/>

	<!--  Content  -->
	<xsl:template match="n1:content">
		<xsl:apply-templates/>
	</xsl:template>

	<!--  List  -->
	<xsl:template match="n1:list">
		<!-- Caption -->
		<xsl:if test="n1:caption">
			<span style="font-weight:bold; ">
				<xsl:apply-templates select="n1:caption"/>
			</span>
		</xsl:if>
		<!-- Item -->
		<xsl:choose>
			<xsl:when test="@listType='ordered'">
				<ol>
					<xsl:for-each select="n1:item">
						<li>
							<!-- List element-->
							<xsl:apply-templates/>
						</li>
					</xsl:for-each>
				</ol>
			</xsl:when>
			<xsl:otherwise>
				<!-- List is unordered -->
				<ul>
					<xsl:for-each select="n1:item">
						<li>
							<!-- List element-->
							<xsl:apply-templates/>
						</li>
					</xsl:for-each>
				</ul>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!--  Caption  -->
	<xsl:template match="n1:caption">
		<xsl:apply-templates/>
		<xsl:text>: </xsl:text>
	</xsl:template>

	<!-- Tables -->
	<xsl:template match="n1:table/@*|n1:thead/@*|n1:tfoot/@*|n1:tbody/@*|n1:colgroup/@*|n1:col/@*|n1:tr/@*|n1:th/@*|n1:td/@*">
		<xsl:copy>
			<xsl:apply-templates/>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="n1:table">
		<table class="body">
			<xsl:apply-templates/>
		</table>
	</xsl:template>
	<xsl:template match="n1:thead">
		<thead>
			<xsl:apply-templates/>
		</thead>
	</xsl:template>
	<xsl:template match="n1:tfoot">
		<tfoot>
			<xsl:apply-templates/>
		</tfoot>
	</xsl:template>
	<xsl:template match="n1:tbody">
		<tbody>
			<xsl:apply-templates/>
		</tbody>
	</xsl:template>
	<xsl:template match="n1:colgroup">
		<colgroup>
			<xsl:apply-templates/>
		</colgroup>
	</xsl:template>
	<xsl:template match="n1:col">
		<col>
			<xsl:apply-templates/>
		</col>
	</xsl:template>
	<xsl:template match="n1:tr">
		<tr>
			<xsl:apply-templates/>
		</tr>
	</xsl:template>
	<xsl:template match="n1:th">
		<th>
			<xsl:apply-templates/>
		</th>
	</xsl:template>
	<xsl:template match="n1:td">
		<td>
			<xsl:apply-templates/>
		</td>
	</xsl:template>
	<xsl:template match="n1:table/n1:caption">
		<span style="font-weight:bold; ">
			<xsl:apply-templates/>
		</span>
	</xsl:template>

	<!--  RenderMultiMedia	-->
	<xsl:template match="n1:renderMultiMedia">
		<xsl:variable name="imageRef" select="@referencedObject"/>
		<xsl:choose>
			<xsl:when test="//n1:regionOfInterest[@ID=$imageRef]">
				<!-- Here is where the Region of Interest image referencing goes -->
				<xsl:if
					test="//n1:regionOfInterest[@ID=$imageRef]//n1:observationMedia/n1:value[@mediaType='image/gif' or @mediaType='image/jpeg' or  @mediaType='image/png' or  @mediaType='image/bmp']">
					<br clear="all"/>
					<xsl:element name="img">
						<xsl:attribute name="src">
							<xsl:value-of select="//n1:regionOfInterest[@ID=$imageRef]//n1:observationMedia/n1:value/n1:reference/@value"/>
						</xsl:attribute>
					</xsl:element>
				</xsl:if>
			</xsl:when>
			<xsl:otherwise>
				<!-- Here is where the direct MultiMedia image referencing goes -->
				<xsl:if test="//n1:observationMedia[@ID=$imageRef]/n1:value[@representation='B64']">
					<!-- base64 embedded object -->
					<xsl:variable name="mediaType">
						<xsl:value-of select="//n1:observationMedia[@ID=$imageRef]/n1:value/@mediaType"/>
					</xsl:variable>
					<xsl:variable name="b64Text">
						<xsl:value-of select="//n1:observationMedia[@ID=$imageRef]/n1:value[@representation='B64']/text()"/>
					</xsl:variable>
					<br clear="all"/>
					<xsl:if test="//n1:observationMedia[@ID=$imageRef]/n1:value[(@mediaType='image/gif' or  @mediaType='image/jpeg' or  @mediaType='image/png' or  @mediaType='image/bmp')]">
						<!-- base64 embedded image -->
						<xsl:element name="img">
							<xsl:attribute name="src">
								<xsl:value-of select="concat(concat(concat('data:',$mediaType),';base64,'),$b64Text)"/>
							</xsl:attribute>
						</xsl:element>
					</xsl:if>
					<xsl:if test="//n1:observationMedia[@ID=$imageRef]/n1:value[(@mediaType='application/pdf')]">
						<!-- base64 embedded pdf -->
						<xsl:element name="embed">
							<xsl:attribute name="src">
								<xsl:value-of select="concat(concat(concat('data:',$mediaType),';base64,'),$b64Text)"/>
							</xsl:attribute>
							<xsl:attribute name="width">
								<xsl:value-of select="'800px'"/>
							</xsl:attribute>
							<xsl:attribute name="height">
								<xsl:value-of select="'1200px'"/>
							</xsl:attribute>
						</xsl:element>
					</xsl:if>
				</xsl:if>
				<xsl:if test="//n1:observationMedia[@ID=$imageRef]/n1:value[not(@representation='B64') and (@mediaType='image/gif' or  @mediaType='image/jpeg' or  @mediaType='image/png' or  @mediaType='image/bmp')]">
					<!-- referenced image file object -->
					<br clear="all"/>
					<xsl:element name="img">
						<xsl:attribute name="src">
							<xsl:value-of select="//n1:observationMedia[@ID=$imageRef]/n1:value/n1:reference/@value"/>
						</xsl:attribute>
					</xsl:element>
				</xsl:if>
				<xsl:if test="//n1:observationMedia[@ID=$imageRef]/n1:value[not(@representation='B64') and (@mediaType='application/pdf')]">
					<!-- referenced file object -->
					<br clear="all"/>
					<xsl:element name="embed">
						<xsl:attribute name="src">
							<xsl:value-of select="//n1:observationMedia[@ID=$imageRef]/n1:value/n1:reference/@value"/>
						</xsl:attribute>
						<xsl:attribute name="width">
							<xsl:value-of select="'800px'"/>
						</xsl:attribute>
						<xsl:attribute name="height">
							<xsl:value-of select="'1200px'"/>
						</xsl:attribute>
					</xsl:element>
				</xsl:if>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- Stylecode processing
	Supports Bold, Underline and Italics display
	-->
	<xsl:template match="//n1:*[@styleCode]">
		<xsl:if test="@styleCode='Bold'">
			<xsl:element name="b">
				<xsl:apply-templates/>
			</xsl:element>
		</xsl:if>
		<xsl:if test="@styleCode='Italics'">
			<xsl:element name="i">
				<xsl:apply-templates/>
			</xsl:element>
		</xsl:if>
		<xsl:if test="@styleCode='Underline'">
			<xsl:element name="u">
				<xsl:apply-templates/>
			</xsl:element>
		</xsl:if>
		<xsl:if test="contains(@styleCode,'Bold') and contains(@styleCode,'Italics') and not(contains(@styleCode, 'Underline'))">
			<xsl:element name="b">
				<xsl:element name="i">
					<xsl:apply-templates/>
				</xsl:element>
			</xsl:element>
		</xsl:if>
		<xsl:if test="contains(@styleCode,'Bold') and contains(@styleCode,'Underline') and not(contains(@styleCode, 'Italics'))">
			<xsl:element name="b">
				<xsl:element name="u">
					<xsl:apply-templates/>
				</xsl:element>
			</xsl:element>
		</xsl:if>
		<xsl:if test="contains(@styleCode,'Italics') and contains(@styleCode,'Underline') and not(contains(@styleCode, 'Bold'))">
			<xsl:element name="i">
				<xsl:element name="u">
					<xsl:apply-templates/>
				</xsl:element>
			</xsl:element>
		</xsl:if>
		<xsl:if test="contains(@styleCode,'Italics') and contains(@styleCode,'Underline') and contains(@styleCode, 'Bold')">
			<xsl:element name="b">
				<xsl:element name="i">
					<xsl:element name="u">
						<xsl:apply-templates/>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:if>
		<xsl:if test="not(contains(@styleCode,'Italics') or contains(@styleCode,'Underline') or contains(@styleCode, 'Bold'))">
			<xsl:apply-templates/>
		</xsl:if>
	</xsl:template>

	<!--  Superscript or Subscript   -->
	<xsl:template match="n1:sup">
		<xsl:element name="sup">
			<xsl:apply-templates/>
		</xsl:element>
	</xsl:template>
	<xsl:template match="n1:sub">
		<xsl:element name="sub">
			<xsl:apply-templates/>
		</xsl:element>
	</xsl:template>

	<!-- Contact Information -->
	<xsl:template name="getContactInfo">
		<xsl:param name="contact"/>
		<xsl:apply-templates select="$contact/n1:addr"/>
		<xsl:apply-templates select="$contact/n1:telecom"/>
	</xsl:template>
	<xsl:template match="n1:addr">
		<xsl:for-each select="n1:streetAddressLine">
			<xsl:value-of select="."/>
			<br/>
		</xsl:for-each>
		<xsl:if test="n1:streetName">
			<xsl:value-of select="n1:streetName"/>
			<xsl:text> </xsl:text>
			<xsl:value-of select="n1:houseNumber"/>
			<br/>
		</xsl:if>
		<xsl:value-of select="n1:postalCode"/>
		<xsl:text> </xsl:text>
		<xsl:value-of select="n1:city"/>
		<xsl:if test="n1:state">
			<xsl:text>, </xsl:text>
			<xsl:value-of select="n1:state"/>
		</xsl:if>
		<br/>
	</xsl:template>
	<xsl:template match="n1:telecom">
		<xsl:variable name="type" select="substring-before(@value, ':')"/>
		<xsl:variable name="value" select="substring-after(@value, ':')"/>
		<xsl:if test="$type">
			<xsl:call-template name="translateCode">
				<xsl:with-param name="code" select="$type"/>
			</xsl:call-template>
			<xsl:if test="@use">
				<xsl:text> </xsl:text>
				<xsl:call-template name="translateCode">
					<xsl:with-param name="code" select="@use"/>
				</xsl:call-template>
			</xsl:if>
			<xsl:text>: </xsl:text>
			<xsl:text> </xsl:text>
			<xsl:value-of select="$value"/>
			<br/>
		</xsl:if>
	</xsl:template>

	<!-- Performer 	-->
	<xsl:template name="performer">
		<table width="100%">
			<xsl:for-each select="//n1:serviceEvent/n1:performer">
				<tr>
					<td>
						<b>
							<xsl:call-template name="translateCode">
								<xsl:with-param name="code" select="n1:functionCode"/>
							</xsl:call-template>
						</b>
					</td>
					<td>
						<xsl:call-template name="getName">
							<xsl:with-param name="name" select="n1:assignedEntity/n1:assignedPerson/n1:name"/>
						</xsl:call-template>
						<xsl:text> (</xsl:text>
						<xsl:call-template name="translateCode">
							<xsl:with-param name="code" select="n1:assignedEntity/n1:code"/>
						</xsl:call-template>)
					</td>
				</tr>
				<tr>
					<td/>
					<td>
						<xsl:call-template name="getContactInfo">
							<xsl:with-param name="contact" select="n1:assignedEntity"/>
						</xsl:call-template>
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>

	<!--  AllParticipants  -->
	<xsl:template name="participants">
		<xsl:choose>
			<xsl:when test="/n1:ClinicalDocument/n1:participant">
				<h3>
					<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='PatientContacts']/@displayName"/>
				</h3>
				<ul>
					<table class="body">
						<thead>
							<tr>
								<th>
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='ParticipantType']/@displayName"/>
								</th>
								<th>
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='AssociatedEntityType']/@displayName"/>
								</th>
								<th>
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='AssociatedEntityRole']/@displayName"/>
								</th>
								<th colspan="2">
									<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Contact']/@displayName"/>
								</th>
								<th colspan="2">
									<xsl:text>ID</xsl:text>
								</th>
							</tr>
						</thead>
						<tbody>
							<xsl:for-each select="/n1:ClinicalDocument/n1:participant">
								<xsl:variable name="participantType">
									<xsl:choose>
										<xsl:when test="@typeCode='COV'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Coverage']/@displayName"/>
										</xsl:when>
										<xsl:when test="@typeCode='REF'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Referrer']/@displayName"/>
										</xsl:when>
										<xsl:when test="@typeCode='HLD'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Holder']/@displayName"/>
										</xsl:when>
										<xsl:when test="@typeCode='IND'">
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='IndirectContact']/@displayName"/>
										</xsl:when>
										<xsl:otherwise>
											Undefined participant type
										</xsl:otherwise>
									</xsl:choose>
								</xsl:variable>
								<xsl:for-each select="./n1:associatedEntity">
									<xsl:variable name="idCount" select="count(./n1:id)"/>
									<xsl:variable name="entityType">
										<xsl:choose>
											<xsl:when test="@classCode='COVPTY'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='CoveredParty']/@displayName"/>
											</xsl:when>
											<xsl:when test="@classCode='PAYOR'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Assurance']/@displayName"/>
											</xsl:when>
											<xsl:when test="@classCode='POLHOLD'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='PolicyHolder']/@displayName"/>
											</xsl:when>
											<xsl:when test="@classCode='CAREGIVER'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='CaregiverContact']/@displayName"/>
											</xsl:when>
											<xsl:when test="@classCode='CON'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Contact']/@displayName"/>
											</xsl:when>
											<xsl:when test="@classCode='ECON'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='EmergencyContact']/@displayName"/>
											</xsl:when>
											<xsl:when test="@classCode='PRS'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='PatientContact']/@displayName"/>
											</xsl:when>
											<xsl:when test="@classCode='PROV'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Provider']/@displayName"/>
											</xsl:when>
											<xsl:when test="@classCode='CLAIM'">
												<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Claim']/@displayName"/>
											</xsl:when>
											<xsl:otherwise>
												Undefined participant entity type
											</xsl:otherwise>
										</xsl:choose>
									</xsl:variable>
									<xsl:variable name="entityRole">
										<xsl:value-of select="n1:code/@code"/>
									</xsl:variable>
									<tr>
										<td>
											<xsl:value-of select="$participantType"/>
										</td>
										<td>
											<xsl:value-of select="$entityType"/>
										</td>
										<td>
											<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value=$entityRole]/@displayName"/>
										</td>
										<td>
											<xsl:call-template name="getName">
												<xsl:with-param name="name" select="n1:associatedPerson/n1:name"/>
											</xsl:call-template>
											<xsl:choose>
												<xsl:when test="n1:associatedPerson">
													<br />
													<xsl:call-template name="getContactInfo">
														<xsl:with-param name="contact" select="n1:associatedPerson"/>
													</xsl:call-template>
												</xsl:when>
											</xsl:choose>
										</td>
										<td>
											<xsl:call-template name="getName">
												<xsl:with-param name="name" select="n1:scopingOrganization/n1:name"/>
											</xsl:call-template>
											<xsl:choose>
												<xsl:when test="n1:scopingOrganization">
													<br />
													<xsl:call-template name="getContactInfo">
														<xsl:with-param name="contact" select="n1:scopingOrganization"/>
													</xsl:call-template>
												</xsl:when>
											</xsl:choose>
										</td>
										<td>
											<xsl:for-each select="./n1:id">
												<xsl:variable name="oidRoot" select="@root"/>
												<xsl:variable name="oidText" select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value=$oidRoot]/@displayName"/>
												<xsl:choose>
													<xsl:when test="$oidText">
														<xsl:value-of select="$oidText"/>
													</xsl:when>
													<xsl:otherwise>
														<xsl:value-of select="$oidRoot"/>
													</xsl:otherwise>
												</xsl:choose>
												<xsl:choose>
													<xsl:when test="$oidRoot">
														<xsl:text>:</xsl:text>
														<xsl:if test="$idCount &gt; position()">
															<br />
														</xsl:if>
													</xsl:when>
												</xsl:choose>
											</xsl:for-each>
										</td>
										<td>
											<xsl:for-each select="./n1:id">
												<xsl:value-of select="@extension"/>
												<xsl:if test="$idCount &gt; position()">
													<br />
												</xsl:if>
											</xsl:for-each>
										</td>
									</tr>
								</xsl:for-each>
							</xsl:for-each>
						</tbody>
					</table>
				</ul>
			</xsl:when>
		</xsl:choose>
	</xsl:template>


	<!--  Bottomline  -->
	<xsl:template name="bottomline">
		<table class="foot">
			<xsl:if test="/n1:ClinicalDocument/n1:authorization/n1:consent">
				<tr>
					<th>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Consent']/@displayName"/>
						<xsl:text>:</xsl:text>
					</th>
					<td>
						<xsl:value-of select="/n1:ClinicalDocument/n1:authorization/n1:consent/n1:code/n1:originalText"/>
					</td>
				</tr>
			</xsl:if>
			<tr>
				<th>
					<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Custodian']/@displayName"/>
					<xsl:text>:</xsl:text>
				</th>
				<td>
					<xsl:if test="n1:custodian/n1:assignedCustodian/n1:representedCustodianOrganization">
						<xsl:call-template name="getName">
							<xsl:with-param name="name" select="n1:custodian/n1:assignedCustodian/n1:representedCustodianOrganization/n1:name"/>
						</xsl:call-template>
					</xsl:if>
				</td>
			</tr>
			<tr>
				<th class="empty"/>
				<td>
					<xsl:call-template name="getContactInfo">
						<xsl:with-param name="contact" select="n1:custodian/n1:assignedCustodian/n1:representedCustodianOrganization"/>
					</xsl:call-template>
				</td>
			</tr>
			<xsl:for-each select="/n1:ClinicalDocument/n1:author">
				<tr>
					<th>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Author']/@displayName"/>
						<xsl:text>:</xsl:text>
					</th>
					<td>
						<xsl:if test="n1:assignedAuthor/n1:representedOrganization/n1:name">
							<xsl:call-template name="getName">
								<xsl:with-param name="name" select="n1:assignedAuthor/n1:representedOrganization/n1:name"/>
							</xsl:call-template>
							<br />
						</xsl:if>
						<xsl:if test="n1:assignedAuthor/n1:assignedPerson/n1:name">
							<xsl:call-template name="getName">
								<xsl:with-param name="name" select="n1:assignedAuthor/n1:assignedPerson/n1:name"/>
							</xsl:call-template>
						</xsl:if>
						<xsl:if test="n1:assignedAuthor/n1:assignedAuthoringDevice">
							<xsl:value-of select="n1:assignedAuthor/n1:assignedAuthoringDevice/n1:softwareName"/>
						</xsl:if>
						<xsl:text> </xsl:text>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='theDate']/@displayName"/>
						<xsl:text> </xsl:text>
						<xsl:call-template name="formatDate">
							<xsl:with-param name="date" select="n1:time/@value"/>
						</xsl:call-template>
					</td>
				</tr>
				<tr>
					<th class="empty"/>
					<td>
						<xsl:if test="n1:assignedAuthor/n1:addr">
							<xsl:call-template name="getContactInfo">
								<xsl:with-param name="contact" select="n1:assignedAuthor"/>
							</xsl:call-template>
						</xsl:if>
						<xsl:if test="n1:assignedAuthor/n1:representedOrganization">
							<xsl:call-template name="getContactInfo">
								<xsl:with-param name="contact" select="n1:assignedAuthor/n1:representedOrganization"/>
							</xsl:call-template>
						</xsl:if>
					</td>
				</tr>
			</xsl:for-each>
			<xsl:for-each select="/n1:ClinicalDocument/n1:informant">
				<tr>
					<th>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Informer']/@displayName"/>
						<xsl:text>:</xsl:text>
					</th>
					<td>
						<xsl:if test="n1:assignedEntity/n1:assignedPerson|n1:relatedEntity/n1:relatedPerson">
							<xsl:call-template name="getName">
								<xsl:with-param name="name"
								select="n1:assignedEntity/n1:assignedPerson/n1:name|n1:relatedEntity/n1:relatedPerson/n1:name"/>
							</xsl:call-template>
							<xsl:if test="n1:relatedEntity/n1:code">
								<xsl:text> (</xsl:text>
								<xsl:call-template name="translateCode">
									<xsl:with-param name="code" select="n1:relatedEntity/n1:code"/>
								</xsl:call-template>
								<xsl:text>)</xsl:text>
							</xsl:if>
						</xsl:if>
					</td>
				</tr>
				<tr>
					<th class="empty"/>
					<td>
						<xsl:call-template name="getContactInfo">
							<xsl:with-param name="contact" select="n1:assignedEntity|n1:relatedEntity"/>
						</xsl:call-template>
					</td>
				</tr>
			</xsl:for-each>
			<xsl:for-each select="/n1:ClinicalDocument/n1:authenticator">
				<tr>
					<th>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Authenticator']/@displayName"/>
						<xsl:text>:</xsl:text>
					</th>
					<td>
						<xsl:call-template name="getName">
							<xsl:with-param name="name" select="n1:assignedEntity/n1:assignedPerson/n1:name"/>
						</xsl:call-template>
						<xsl:text> </xsl:text>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='theDate']/@displayName"/>
						<xsl:text> </xsl:text>
						<xsl:call-template name="formatDate">
							<xsl:with-param name="date" select="n1:time/@value"/>
						</xsl:call-template>
					</td>
				</tr>
				<tr>
					<th class="empty"/>
					<td>
						<xsl:call-template name="getContactInfo">
							<xsl:with-param name="contact" select="n1:assignedEntity"/>
						</xsl:call-template>
					</td>
				</tr>
			</xsl:for-each>
			<xsl:for-each select="/n1:ClinicalDocument/n1:legalAuthenticator">
				<tr>
					<th>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='LegalAuthenticator']/@displayName"/>
						<xsl:text>:</xsl:text>
					</th>
					<td>
						<xsl:call-template name="getName">
							<xsl:with-param name="name" select="n1:assignedEntity/n1:assignedPerson/n1:name"/>
						</xsl:call-template>
						<xsl:text> </xsl:text>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='theDate']/@displayName"/>
						<xsl:text> </xsl:text>
						<xsl:call-template name="formatDate">
							<xsl:with-param name="date" select="n1:time/@value"/>
						</xsl:call-template>
					</td>
				</tr>
				<tr>
					<th class="empty"/>
					<td>
						<xsl:call-template name="getContactInfo">
							<xsl:with-param name="contact" select="n1:assignedEntity"/>
						</xsl:call-template>
					</td>
				</tr>
			</xsl:for-each>
			<xsl:for-each select="/n1:ClinicalDocument/n1:dataEnterer">
				<tr>
					<th>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='DataEnterer']/@displayName"/>
						<xsl:text>:</xsl:text>
					</th>
					<td>
						<xsl:call-template name="getName">
							<xsl:with-param name="name" select="n1:assignedEntity/n1:assignedPerson/n1:name"/>
						</xsl:call-template>
						<xsl:text> </xsl:text>
						<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='theDate']/@displayName"/>
						<xsl:text> </xsl:text>
						<xsl:call-template name="formatDate">
							<xsl:with-param name="date" select="n1:time/@value"/>
						</xsl:call-template>
					</td>
				</tr>
			</xsl:for-each>
			<xsl:for-each select="/n1:ClinicalDocument/n1:informationRecipient">
				<tr>
					<th>
						<xsl:call-template name="getRecipientType">
							<xsl:with-param name="typeCode" select="@typeCode"/>
						</xsl:call-template>
					</th>
					<td>
						<xsl:if test="n1:intendedRecipient/n1:informationRecipient">
							<xsl:call-template name="getName">
								<xsl:with-param name="name" select="n1:intendedRecipient/n1:informationRecipient/n1:name"/>
							</xsl:call-template>
						</xsl:if>
						<xsl:if test="n1:intendedRecipient/n1:receivedOrganization">
							<xsl:call-template name="getName">
								<xsl:with-param name="name" select="n1:intendedRecipient/n1:receivedOrganization/n1:name"/>
							</xsl:call-template>
						</xsl:if>
					</td>
				</tr>
				<tr>
					<th class="empty"/>
					<td>
						<xsl:call-template name="getContactInfo">
							<xsl:with-param name="contact" select="n1:intendedRecipient/n1:receivedOrganization"/>
						</xsl:call-template>
						<xsl:if test="n1:intendedRecipient/n1:receivedOrganization">
							<br />
							<xsl:call-template name="getName">
								<xsl:with-param name="name" select="n1:intendedRecipient/n1:receivedOrganization/n1:name"/>
							</xsl:call-template>
							<br />
							<xsl:call-template name="getContactInfo">
								<xsl:with-param name="contact" select="n1:intendedRecipient/n1:receivedOrganization"/>
							</xsl:call-template>
						</xsl:if>
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>

	<!-- Telecom codes -->
	<xsl:template name="translateCode">
		<xsl:param name="code"/>
		<xsl:choose>
			<!-- lookup table Telecom URI -->
			<xsl:when test="$code='tel'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Tel']/@displayName"/>
			</xsl:when>
			<xsl:when test="$code='fax'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Fax']/@displayName"/>
			</xsl:when>
			<xsl:when test="$code='http'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Web']/@displayName"/>
			</xsl:when>
			<xsl:when test="$code='mailto'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='Mail']/@displayName"/>
			</xsl:when>
			<xsl:when test="$code='HP'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='home']/@displayName"/>
			</xsl:when>
			<xsl:when test="$code='WP'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='workplace']/@displayName"/>
			</xsl:when>
			<xsl:when test="$code='MC'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='mobile']/@displayName"/>
			</xsl:when>
			<xsl:when test="$code='PUB'">
				<xsl:value-of select="document('cda-ch-xsl-voc.xml')/localization/text[@language=$language and @value='workplace']/@displayName"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:text>{$code='</xsl:text>
				<xsl:value-of select="$code"/>
				<xsl:text>'?}</xsl:text>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

</xsl:stylesheet>
