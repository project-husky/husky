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
package org.projecthusky.communication.services.svs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.utils.LangText;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.requests.svs.SvsValueSetRequest;
import org.projecthusky.communication.responses.svs.SvsValueSetResponse;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.valueset.api.ValueSetManager;
import org.projecthusky.valueset.config.ValueSetConfig;
import org.projecthusky.valueset.enums.SourceFormatType;
import org.projecthusky.valueset.enums.SourceSystemType;
import org.projecthusky.valueset.exceptions.InitializationException;
import org.projecthusky.valueset.model.ValueSet;
import org.projecthusky.valueset.model.ValueSetEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

/**
 * The Test Class for ValueSetManager with downloading value sets from ART-DECOR.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {
    TestApplication.class})
@EnableAutoConfiguration
class SvsValueSetManagerTest {

  @Autowired
  private HuskyService huskyService;

  /**
   * This test checks the behavior of the {@link ValueSetManager#downloadValueSetRaw(ValueSetConfig)} when downloading
   * value sets as a byte array. As an example the possible values for EprAuthorRole (2.16.756.5.30.1.127.3.10.1) are
   * downloaded.
   *
   * @throws MalformedURLException
   * @throws IOException
   */
  @Test
  void downloadRawTest()
      throws MalformedURLException, IOException, ParserConfigurationException, InitializationException, SAXException {
    String testUrl = "https://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json&id=2.16.756.5.30.1.127.3.10.1";

    // download expected values from fixed URL
    String downloadedString = IOUtils.toString(new URL(testUrl), StandardCharsets.UTF_8);

    // configure URL and the source system type for downloading value sets
    SvsValueSetRequest valueSetRequest = this.huskyService.createValueSetRequest()
        .sourceSystemType(SourceSystemType.ARTDECOR_FHIR)
        .sourceUrl(testUrl)
        .build();

    // download value sets
    SvsValueSetResponse downloadedByteArray = this.huskyService.send(valueSetRequest, true);
    String byteArrayString = new String(downloadedByteArray.getValueSetRaw(),
        StandardCharsets.UTF_8);
    assertEquals(downloadedString, byteArrayString);
  }

  /**
   * This test checks the behavior of the {@link ValueSetManager#downloadValueSetRaw(ValueSetConfig)} when downloading
   * value sets with an ID, which doesn't exist. As an example the possible values for EprAuthorRole
   * (2.16.756.5.30.1.127.3.10.1) are downloaded.
   *
   * @throws IOException
   */
  @Test
  void downloadRawUnknownIdTest()
      throws IOException, ParserConfigurationException, InitializationException, SAXException {
    // id in URL doesn't exists
    String testUrl = "https://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json&id=1.2.3.4.5";

    // configure URL and the source system type for downloading value sets
    SvsValueSetRequest valueSetRequest = this.huskyService.createValueSetRequest()
        .sourceSystemType(SourceSystemType.ARTDECOR_FHIR)
        .sourceUrl(testUrl)
        .build();

    // download value sets
    SvsValueSetResponse downloadedByteArray = this.huskyService.send(valueSetRequest, true);
    String byteArrayString = new String(downloadedByteArray.getValueSetRaw(),
        StandardCharsets.UTF_8);
    assertEquals("null", byteArrayString);
  }

  /**
   * This test checks the behavior of the {@link ValueSetManager#downloadValueSet(ValueSetConfig)} when downloading
   * value sets as {@link ValueSet} in JSON, XML or IHE SVS format. As an example the possible values for
   * DocumentEntry.author.authorRole (2.16.756.5.30.1.127.3.10.1.1.3) are downloaded.
   *
   * @throws IOException
   * @throws ParserConfigurationException
   * @throws SAXException
   * @throws InitializationException
   */
  @Test
  void downloadValueSetTest()
      throws IOException, ParserConfigurationException, InitializationException, SAXException {
    String baseUrlJson = "https://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json";
    String baseUrlIheSvs = "https://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=svs";
    String baseUrlXml = "https://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=xml";

    String projectFolder = "../../common/husky-common-ch/src/main/java/org/husky/common/ch/enums";
    SourceSystemType sourceSystemType = SourceSystemType.ARTDECOR_FHIR;

    String className1 = "AuthorRole";
    IdentificatorBaseType authorRoleId = IdentificatorBaseType.builder()
        .withRoot("2.16.756.5.30.1.127.3.10.1.1.3").build();
    Date authorRoleTimeStamp = new GregorianCalendar(2018, Calendar.JUNE, 13, 7, 40, 11).getTime();
    URL authorRoleSourceUrlJson;
    String authorRoleSourceUrlJsonString = "";

    authorRoleSourceUrlJson = ValueSetManager.buildValueSetArtDecorUrl(baseUrlJson,
        authorRoleId, authorRoleTimeStamp);
    authorRoleSourceUrlJsonString = authorRoleSourceUrlJson.toString();

    // configuring the download of value sets in JSON format
    // sets the URL for downloading and specifies the class name and the folder
    // where the values should be saved
    SvsValueSetRequest valueSetRequestJson = this.huskyService.createValueSetRequest()
        .className(className1)
        .projectFolder(projectFolder).sourceFormatType(SourceFormatType.JSON)
        .sourceSystemType(sourceSystemType).sourceUrl(authorRoleSourceUrlJsonString)
        .build();

    URL authorRoleSourceUrlIheSvs;
    String authorRoleSourceUrlIheSvsString = "";
    authorRoleSourceUrlIheSvs = ValueSetManager.buildValueSetArtDecorUrl(baseUrlIheSvs,
        authorRoleId, authorRoleTimeStamp);
    authorRoleSourceUrlIheSvsString = authorRoleSourceUrlIheSvs.toString();

    // configuring the download of value sets in IHE SVS XML format
    // sets the URL for downloading and specifies the class name and the folder
    // where the values should be saved
    SvsValueSetRequest valueSetRequestIheSvs = this.huskyService.createValueSetRequest()
        .className(className1)
        .projectFolder(projectFolder).sourceFormatType(SourceFormatType.IHESVS)
        .sourceSystemType(sourceSystemType)
        .sourceUrl(authorRoleSourceUrlIheSvsString).build();

    URL authorRoleSourceUrlXml;
    String authorRoleSourceUrlXmlString = "";
    authorRoleSourceUrlXml = ValueSetManager.buildValueSetArtDecorUrl(baseUrlXml, authorRoleId,
        authorRoleTimeStamp);
    authorRoleSourceUrlXmlString = authorRoleSourceUrlXml.toString();

    // configuring the download of value sets in XML format
    // sets the URL for downloading and specifies the class name and the folder
    // where the values should be saved
    SvsValueSetRequest valueSetRequestXml = this.huskyService.createValueSetRequest()
        .className(className1)
        .projectFolder(projectFolder).sourceFormatType(SourceFormatType.XML)
        .sourceSystemType(sourceSystemType).sourceUrl(authorRoleSourceUrlXmlString)
        .build();

    // download value sets in different formats
    SvsValueSetResponse valueSetJson = this.huskyService.send(valueSetRequestJson, false);
    SvsValueSetResponse valueSetIheSvs = this.huskyService.send(valueSetRequestIheSvs, false);
    SvsValueSetResponse valueSetXml = this.huskyService.send(valueSetRequestXml, false);

    // 1. Compare Json and IHE SVS
    assertEquals(valueSetJson.getValueSet().getIdentificator(),
        valueSetIheSvs.getValueSet().getIdentificator());
    assertEquals(valueSetJson.getValueSet().getDisplayName(),
        valueSetIheSvs.getValueSet().getDisplayName());
    // cannot be tested, as this information is not available in the
    // IHE SVS format:
    // assertEquals(valueSetJson.getName(), valueSetIheSvs.getName());
    assertEquals(valueSetJson.getValueSet().getStatus(), valueSetIheSvs.getValueSet().getStatus());
    assertEquals(valueSetJson.getValueSet().getVersion(),
        valueSetIheSvs.getValueSet().getVersion());

    // IHE SVS does only provide Purpose (which is loaded as English
    // description). It couldn't be tested because different namespaces are used
    /*
     * assertEquals(valueSetJson.getDescription(LanguageCode.ENGLISH),
     * valueSetIheSvs.getDescription(LanguageCode.ENGLISH));
     */

    for (ValueSetEntry vse : valueSetJson.getValueSet().getValueSetEntryList()) {
      ValueSetEntry obj = valueSetIheSvs.getValueSet()
          .getValueSetEntryByCode(vse.getCodeBaseType());
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
    assertEquals(valueSetJson.getValueSet().getIdentificator(),
        valueSetXml.getValueSet().getIdentificator());
    assertEquals(valueSetJson.getValueSet().getDisplayName(),
        valueSetXml.getValueSet().getDisplayName());
    // cannot be tested, as this information is not available in the
    // XML format:
    assertEquals(valueSetJson.getValueSet().getName(), valueSetXml.getValueSet().getName());
    assertEquals(valueSetJson.getValueSet().getStatus(), valueSetXml.getValueSet().getStatus());
    assertEquals(valueSetJson.getValueSet().getVersion(), valueSetXml.getValueSet().getVersion());

    for (LangText jsonDesc : valueSetJson.getValueSet().getDescriptionList()) {
      String xmlDesc = valueSetXml.getValueSet().getDescription(jsonDesc.getLangCode());
      assertNotNull(xmlDesc);
    }

    for (ValueSetEntry vse : valueSetJson.getValueSet().getValueSetEntryList()) {
      ValueSetEntry obj = valueSetXml.getValueSet().getValueSetEntryByCode(vse.getCodeBaseType());
      assertEquals(vse.getDesignationList().size(), obj.getDesignationList().size());
      assertEquals(vse.getLevel(), obj.getLevel());
      // cannot be tested, as this information is not available in the
      // XML format:
      assertEquals(vse.getValueSetEntryType(), obj.getValueSetEntryType());
    }
  }
}
