package org.projecthusky.communication.services.xua;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.StatementAbstractType;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.impl.AttributeValueImpl;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.ServerTestHelper;
import org.projecthusky.communication.requests.xua.XuaRequest;
import org.projecthusky.communication.responses.xua.XuaResponse;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.xua.communication.clients.XuaClient;
import org.projecthusky.xua.communication.xua.AppliesTo;
import org.projecthusky.xua.communication.xua.RequestType;
import org.projecthusky.xua.communication.xua.TokenType;
import org.projecthusky.xua.communication.xua.XUserAssertionResponse;
import org.projecthusky.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.projecthusky.xua.deserialization.impl.AssertionDeserializerImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.exceptions.SoapException;
import org.projecthusky.xua.hl7v3.PurposeOfUse;
import org.projecthusky.xua.hl7v3.Role;
import org.projecthusky.xua.hl7v3.impl.CodedWithEquivalentsBuilder;
import org.projecthusky.xua.saml2.impl.AttributeImpl;
import org.projecthusky.xua.serialization.impl.XUserAssertionResponseSerializerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The purpose of this test class is to check if the assertion query works for a
 * user.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
class XuaClientTest extends ServerTestHelper {

  private final Logger logger = LoggerFactory.getLogger(XuaClientTest.class);

  @Value(value = "${test.xua.uri:https://ehealthsuisse.ihe-europe.net:10443/STS}")
  private String urlToXua;

  @Value(value = "${test.xua.keystore.file:src/test/resources/project-husky.p12}")
  private String clientKeyStore;
  @Value(value = "${test.xua.keystore.password:husky2023}")
  private String clientKeyStorePass;
  @Value(value = "${test.xua.keystore.type:pkcs12}")
  private String clientKeyStoreType;
  @Value(value = "${test.xua.assertion.file:src/test/resources/Assertion.xml}")
  private String xuaAssertionFile;

  @Autowired
  private HuskyService huskyService;

  /**
   * This test checks the behavior of the
   * {@link XuaClient#send(SecurityHeaderElement, org.projecthusky.xua.communication.xua.XUserAssertionRequest)
   * when querying a XUA assertion for a registered healthcare professional
   *
   * @throws Exception
   */
  @Test
  void testGetAssertionForHcp()
      throws ClientSendException, DeserializeException, IOException {
    try (InputStream is = new FileInputStream(xuaAssertionFile)) {

      var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

      // set role of subject
      var role = new CodedWithEquivalentsBuilder().code("HCP").codeSystem("2.16.756.5.30.1.127.3.10.6")
          .displayName("Behandelnde(r)")
          .buildObject(Role.DEFAULT_NS_URI, Role.DEFAULT_ELEMENT_LOCAL_NAME, Role.DEFAULT_PREFIX);

      // set the purpose of use
      var purposeOfUse = new CodedWithEquivalentsBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
          .displayName("Normal Access").buildObject(PurposeOfUse.DEFAULT_NS_URI,
              PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);

      // set ID of patient with namespace EPR_SPID
      String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

      AppliesTo appliesTo = new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create();

      XuaRequest xuaRequest = this.huskyService.createXuaRequest().appliesTo(appliesTo).purposeOfUse(purposeOfUse)
          .subjectRole(role).resourceId(resourceId).requestType(RequestType.WST_ISSUE)
          .tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20).idpAssertion(idpAssertion)
          .repositoryUri(urlToXua).clientKeyStoreType(clientKeyStoreType).clientKeyStore(clientKeyStore)
          .clientKeyStorePass(clientKeyStorePass).build();

      // query XUA assertion
      XuaResponse response = huskyService.send(xuaRequest);

      // check if assertion is returned
      assertNotNull(response);

      //printOutresponse(response);

      assertNotNull(response.getAssertion());
      assertNotNull(((Assertion) response.getAssertion().getWrappedObject()).getIssuer());
      // check if correct issuer is included in assertion
      assertEquals("https://ehealthsuisse.ihe-europe.net/STS",
          ((Assertion) response.getAssertion().getWrappedObject()).getIssuer().getValue());

      String actualRole = null;
      String actualPurposeOfUse = null;
      String actualSubjectId = null;
      String actualResourceId = null;

      for (StatementAbstractType statement : response.getAssertion()
          .getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
        if (statement instanceof AttributeStatementType) {
          AttributeStatementType attributeStatementType = (AttributeStatementType) statement;

          for (Object obj : attributeStatementType.getAttributeOrEncryptedAttribute()) {
            if (obj instanceof AttributeType) {
              AttributeImpl attribute = (AttributeImpl) obj;

              if (attribute.isValueARole()) {
                actualRole = attribute.getValueAsRole().getCode();
              }

              if (attribute.isValueAPurposeOfUse()) {
                actualPurposeOfUse = attribute.getValueAsPurposeOfUse().getCode();
              }

              if (attribute.getName()
                  .equalsIgnoreCase("urn:oasis:names:tc:xspa:1.0:subject:subject-id")) {
                actualSubjectId = ((AttributeValueImpl) attribute.getWrappedObject()
                    .getAttributeValues().get(0)).getTextContent();
              }

              if (attribute.getName()
                  .equalsIgnoreCase("urn:oasis:names:tc:xacml:2.0:resource:resource-id")) {
                actualResourceId = (((AttributeValueImpl) attribute.getWrappedObject()
                    .getAttributeValues().get(0))).getTextContent();
              }

            }
          }
        }
      }

      // check attribute parameter of returned assertion
      assertEquals(role.getCode(), actualRole);
      assertEquals(purposeOfUse.getCode(), actualPurposeOfUse);
      assertEquals("Ann Andrews", actualSubjectId);
      assertEquals(resourceId, actualResourceId);
    }
  }

  private void printOutresponse(List<XUserAssertionResponse> responses) {
    responses.forEach(response -> {
      try {
        String xmlString = new XUserAssertionResponseSerializerImpl().toXmlString(response);
        logger.info(xmlString);
      } catch (SerializeException e) {

      }
    });

  }

  /**
   * This test checks the behavior of the
   * {@link XuaClient#send(SecurityHeaderElement, org.projecthusky.xua.communication.xua.XUserAssertionRequest)
   * when querying a XUA assertion for registered user with a wrong role.
   *
   * @throws Exception
   */
  @Test
  void testWrongAssertionDetailsForHcp()
      throws DeserializeException, IOException {
    try (InputStream is = new FileInputStream(xuaAssertionFile)) {

      var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

      var role = new CodedWithEquivalentsBuilder().code("AKT").codeSystem("1.2.3.4.5")
          .displayName("Behandelnde(r)")
          .buildObject(Role.DEFAULT_NS_URI, Role.DEFAULT_ELEMENT_LOCAL_NAME, Role.DEFAULT_PREFIX);
      var purposeOfUse = new CodedWithEquivalentsBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
          .displayName("Normal Access").buildObject(PurposeOfUse.DEFAULT_NS_URI,
              PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);
      String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

      AppliesTo appliesTo = new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create();

      XuaRequest xuaRequest = this.huskyService.createXuaRequest().appliesTo(appliesTo).purposeOfUse(purposeOfUse)
          .subjectRole(role).resourceId(resourceId).requestType(RequestType.WST_ISSUE)
          .tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20).idpAssertion(idpAssertion)
          .repositoryUri(urlToXua).clientKeyStoreType(clientKeyStoreType).clientKeyStore(clientKeyStore)
          .clientKeyStorePass(clientKeyStorePass).build();

      // query XUA assertion and expecting SoapException due to wrong role code
      assertThrows(SoapException.class, () -> huskyService.send(xuaRequest));
    }
  }

  /**
   * This test checks the behavior of the
   * {@link XuaClient#send(SecurityHeaderElement, org.projecthusky.xua.communication.xua.XUserAssertionRequest)
   * when querying a XUA assertion for registered user with a wrong role, a wrong
   * patient ID and a wrong purpose of use.
   *
   * @throws Exception
   */
  @Test
  void testInvalidXmlAssertionForHcp()
      throws DeserializeException, IOException {
    try (InputStream is = new FileInputStream(xuaAssertionFile)) {

      var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

      var role = new CodedWithEquivalentsBuilder().code("AKT").codeSystem("1.2.3.4.5")
          .displayName("Behandelnde(r)")
          .buildObject(Role.DEFAULT_NS_URI, Role.DEFAULT_ELEMENT_LOCAL_NAME, Role.DEFAULT_PREFIX);
      var purposeOfUse = new CodedWithEquivalentsBuilder().code("1234").codeSystem("1.2.3.4.5.6.7")
          .displayName("Normal Access").buildObject(PurposeOfUse.DEFAULT_NS_URI,
              PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);
      String resourceId = "1234^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

      AppliesTo appliesTo = new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create();

      XuaRequest xuaRequest = this.huskyService.createXuaRequest().appliesTo(appliesTo).purposeOfUse(purposeOfUse)
          .subjectRole(role).resourceId(resourceId).requestType(RequestType.WST_ISSUE)
          .tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20).idpAssertion(idpAssertion)
          .repositoryUri(urlToXua).clientKeyStoreType(clientKeyStoreType).clientKeyStore(clientKeyStore)
          .clientKeyStorePass(clientKeyStorePass).build();

      // query XUA assertion and expecting ClientSendException due to invalid
      // assertion
      assertThrows(ClientSendException.class, () -> huskyService.send(xuaRequest));
    }
  }
}

