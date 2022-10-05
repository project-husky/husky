/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.valueset.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.utils.LangText;
import org.projecthusky.valueset.api.ValueSetManager;
import org.projecthusky.valueset.config.ValueSetConfig;
import org.projecthusky.valueset.enums.SourceFormatType;
import org.projecthusky.valueset.enums.SourceSystemType;
import org.projecthusky.valueset.exceptions.InitializationException;
import org.projecthusky.valueset.model.ValueSet;
import org.projecthusky.valueset.model.ValueSetEntry;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

/**
 * The Test Class for ValueSetManager with downloading value sets from
 * ART-DECOR.
 */
class ValueSetManagerIntegrationTest {


	/**
	 * This test checks the behavior of the
	 * {@link ValueSetManager#downloadValueSetRaw(ValueSetConfig)} when downloading
	 * value sets as a byte array. As an example the possible values for
	 * EprAuthorRole (2.16.756.5.30.1.127.3.10.1) are downloaded.
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	void downloadRawTest() throws MalformedURLException, IOException {
		String testUrl = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json&id=2.16.756.5.30.1.127.3.10.1";

		// download expected values from fixed URL
		String downloadedString = IOUtils.toString(new URL(testUrl), StandardCharsets.UTF_8);
		ValueSetManager valueSetManager = new ValueSetManager();

		// configure URL and the source system type for downloading value sets
		ValueSetConfig valueSetConfig = ValueSetConfig.builder().withSourceSystemType(SourceSystemType.ARTDECOR_FHIR)
				.withSourceUrl(testUrl).build();

		// download value sets
		byte[] downloadedByteArray = valueSetManager.downloadValueSetRaw(valueSetConfig);
		String byteArrayString = new String(downloadedByteArray, StandardCharsets.UTF_8);
		assertEquals(downloadedString, byteArrayString);
	}

	/**
	 * This test checks the behavior of the
	 * {@link ValueSetManager#downloadValueSetRaw(ValueSetConfig)} when downloading
	 * value sets with an ID, which doesn't exist. As an example the possible values
	 * for EprAuthorRole (2.16.756.5.30.1.127.3.10.1) are downloaded.
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	void downloadRawUnknwonIdTest() throws MalformedURLException, IOException {
		// id in URL doesn't exists
		String testUrl = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json&id=1.2.3.4.5";

		ValueSetManager valueSetManager = new ValueSetManager();

		// configure URL and the source system type for downloading value sets
		ValueSetConfig valueSetConfig = ValueSetConfig.builder().withSourceSystemType(SourceSystemType.ARTDECOR_FHIR)
				.withSourceUrl(testUrl).build();

		// download value sets
		byte[] downloadedByteArray = valueSetManager.downloadValueSetRaw(valueSetConfig);
		String byteArrayString = new String(downloadedByteArray, StandardCharsets.UTF_8);
		assertEquals("null", byteArrayString);
	}

	/**
	 * This test checks the behavior of the
	 * {@link ValueSetManager#downloadValueSet(ValueSetConfig)} when downloading
	 * value sets as {@link ValueSet} in JSON, XML or IHE SVS format. As an example
	 * the possible values for DocumentEntry.author.authorRole
	 * (2.16.756.5.30.1.127.3.10.1.1.3) are downloaded.
	 * 
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws InitializationException
	 */
	@Test
	void downloadValueSetTest() throws IOException, ParserConfigurationException,
			SAXException, InitializationException {
		String baseUrlJson = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json";
		String baseUrlIheSvs = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=svs";
		String baseUrlXml = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=xml";

		String projectFolder = "../../common/husky-common-ch/src/main/java/org/husky/common/ch/enums";
		SourceSystemType sourceSystemType = SourceSystemType.ARTDECOR_FHIR;

		String className1 = "AuthorRole";
		IdentificatorBaseType authorRoleId = IdentificatorBaseType.builder()
				.withRoot("2.16.756.5.30.1.127.3.10.1.1.3").build();
		Date authorRoleTimeStamp = new GregorianCalendar(2018, 5, 13, 7, 40, 11).getTime();
		URL authorRoleSourceUrlJson;
		String authorRoleSourceUrlJsonString = "";

		authorRoleSourceUrlJson = ValueSetManager.buildValueSetArtDecorUrl(baseUrlJson,
				authorRoleId, authorRoleTimeStamp);
		authorRoleSourceUrlJsonString = authorRoleSourceUrlJson.toString();

		// configuring the download of value sets in JSON format
		// sets the URL for downloading and specifies the class name and the folder
		// where the values should be saved
		ValueSetConfig valueSetConfigJson = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder).withSourceFormatType(SourceFormatType.JSON)
				.withSourceSystemType(sourceSystemType).withSourceUrl(authorRoleSourceUrlJsonString)
				.build();

		URL authorRoleSourceUrlIheSvs;
		String authorRoleSourceUrlIheSvsString = "";
		authorRoleSourceUrlIheSvs = ValueSetManager.buildValueSetArtDecorUrl(baseUrlIheSvs,
				authorRoleId, authorRoleTimeStamp);
		authorRoleSourceUrlIheSvsString = authorRoleSourceUrlIheSvs.toString();


		// configuring the download of value sets in IHE SVS XML format
		// sets the URL for downloading and specifies the class name and the folder
		// where the values should be saved
		ValueSetConfig valueSetConfigIheSvs = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder).withSourceFormatType(SourceFormatType.IHESVS)
				.withSourceSystemType(sourceSystemType)
				.withSourceUrl(authorRoleSourceUrlIheSvsString).build();

		URL authorRoleSourceUrlXml;
		String authorRoleSourceUrlXmlString = "";
		authorRoleSourceUrlXml = ValueSetManager.buildValueSetArtDecorUrl(baseUrlXml, authorRoleId,
				authorRoleTimeStamp);
		authorRoleSourceUrlXmlString = authorRoleSourceUrlXml.toString();

		// configuring the download of value sets in XML format
		// sets the URL for downloading and specifies the class name and the folder
		// where the values should be saved
		ValueSetConfig valueSetConfigXml = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder).withSourceFormatType(SourceFormatType.XML)
				.withSourceSystemType(sourceSystemType).withSourceUrl(authorRoleSourceUrlXmlString)
				.build();

		// download value sets in different formats
		ValueSetManager valueSetManager = new ValueSetManager();
		ValueSet valueSetJson = valueSetManager.downloadValueSet(valueSetConfigJson);
		ValueSet valueSetIheSvs = valueSetManager.downloadValueSet(valueSetConfigIheSvs);
		ValueSet valueSetXml = valueSetManager.downloadValueSet(valueSetConfigXml);

		// 1. Compare Json and IHE SVS
		assertEquals(valueSetJson.getIdentificator(), valueSetIheSvs.getIdentificator());
		assertEquals(valueSetJson.getDisplayName(), valueSetIheSvs.getDisplayName());
		// cannot be tested, as this information is not available in the
		// IHE SVS format:
		// assertEquals(valueSetJson.getName(), valueSetIheSvs.getName());
		assertEquals(valueSetJson.getStatus(), valueSetIheSvs.getStatus());
		assertEquals(valueSetJson.getVersion(), valueSetIheSvs.getVersion());

		// IHE SVS does only provide Purpose (which is loaded as English
		// description). It couldn't be tested because different namespaces are used
		/*
		 * assertEquals(valueSetJson.getDescription(LanguageCode.ENGLISH),
		 * valueSetIheSvs.getDescription(LanguageCode.ENGLISH));
		 */

		for (ValueSetEntry vse : valueSetJson.getValueSetEntryList()) {
			ValueSetEntry obj = valueSetIheSvs.getValueSetEntryByCode(vse.getCodeBaseType());
			// cannot be tested, as this information is not available in the
			// IHE SVS format:
			// assertEquals(vse.getDesignationList().size(),
			// obj.getDesignationList().size());
			assertEquals(vse.getLevel(), obj.getLevel());
			// cannot be tested, as this information is not available in the
			// IHE SVS format:
			// assertEquals(vse.getValueSetEntryType(),
			// obj.getValueSetEntryType());
		}

		// 2. Compare Json and XML

		assertEquals(valueSetJson.getIdentificator(), valueSetXml.getIdentificator());
		assertEquals(valueSetJson.getDisplayName(), valueSetXml.getDisplayName());
		// cannot be tested, as this information is not available in the
		// XML format:
		assertEquals(valueSetJson.getName(), valueSetXml.getName());
		assertEquals(valueSetJson.getStatus(), valueSetXml.getStatus());
		assertEquals(valueSetJson.getVersion(), valueSetXml.getVersion());

		for (LangText jsonDesc : valueSetJson.getDescriptionList()) {
			String xmlDesc = valueSetXml.getDescription(jsonDesc.getLangCode());
			assertNotNull(xmlDesc);
		}

		for (ValueSetEntry vse : valueSetJson.getValueSetEntryList()) {
			ValueSetEntry obj = valueSetXml.getValueSetEntryByCode(vse.getCodeBaseType());
			assertEquals(vse.getDesignationList().size(), obj.getDesignationList().size());
			assertEquals(vse.getLevel(), obj.getLevel());
			// cannot be tested, as this information is not available in the
			// XML format:
			assertEquals(vse.getValueSetEntryType(), obj.getValueSetEntryType());
		}
	}

}
