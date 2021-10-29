package org.husky.communication.ch.ppq.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.apache.camel.CamelContext;
import org.apache.commons.io.IOUtils;
import org.husky.communication.ch.ppq.TestApplication;
import org.husky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryResponseImpl;
import org.husky.communication.ch.ppq.impl.clients.ClientFactoryCh;
import org.husky.communication.ch.ppq.impl.clients.SimplePpqClient;
import org.husky.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.husky.xua.communication.clients.XuaClient;
import org.husky.xua.communication.clients.impl.ClientFactory;
import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.husky.xua.communication.xua.RequestType;
import org.husky.xua.communication.xua.TokenType;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.husky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.husky.xua.communication.xua.impl.ch.PurposeOfUse;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.deserialization.impl.AssertionDeserializerImpl;
import org.husky.xua.hl7v3.InstanceIdentifier;
import org.husky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.husky.xua.hl7v3.impl.InstanceIdentifierImpl;
import org.husky.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.husky.xua.hl7v3.impl.RoleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.xacml20.Xacml20Utils;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.schema.impl.XSAnyImpl;
import org.opensaml.saml.saml2.core.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class SimplePpqClientTest {

	@Autowired
	private CamelContext camelContext;

	@Autowired
	private AuditContext auditContext;
	private String urlToPpq = "https://ehealthsuisse.ihe-europe.net:10443/ppq-repository";
	private String urlToXua = "https://ehealthsuisse.ihe-europe.net:10443/STS";
	private String clientKeyStore = "src/test/resources/testKeystore.jks";
	private String clientKeyStorePass = "changeit";
	private SecurityHeaderElement securityHeader = null;

	@BeforeEach
	public void setup() throws JAXBException {
		try {
			InitializationService.initialize();
			Xacml20Utils.initializeHerasaf();

			System.setProperty("javax.net.ssl.keyStore", clientKeyStore);
			System.setProperty("javax.net.ssl.keyStorePassword", clientKeyStorePass);
			System.setProperty("javax.net.ssl.trustStore", clientKeyStore);
			System.setProperty("javax.net.ssl.trustStorePassword", clientKeyStorePass);
		} catch (InitializationException e1) {
			e1.printStackTrace();
		}

		// query HCP assertion
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/ch-ppq/Assertion.xml"))) {

			var assertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var purposeOfUse = new PurposeOfUseBuilder().code(PurposeOfUse.NORMAL_ACCESS.getCodeValue())
					.codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName(PurposeOfUse.NORMAL_ACCESS.getDisplayName()).buildObject();
			var role = new RoleBuilder().code("HCP").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();

			var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
					.purposeOfUse(purposeOfUse)
					.subjectRole(role).resourceId("761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO")
					.create();

			List<XUserAssertionResponse> response = client.send(assertion, assertionRequest);

			securityHeader = response.get(0).getAssertion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryPatientPolicyWithNoPolicy() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient client = ClientFactoryCh.getPpqClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610411265304");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponseImpl response = (PrivacyPolicyQueryResponseImpl) client.send(securityHeader, query);

		assertNotNull(response);
		assertNotNull(response.getWrappedObject());

		assertNotNull(response.getWrappedObject().getStatus());
		assertNotNull(response.getWrappedObject().getStatus().getStatusCode());
		assertNotNull(response.getWrappedObject().getStatus().getStatusMessage());
		assertEquals("urn:e-health-suisse:2015:error:not-holder-of-patient-policies",
				response.getWrappedObject().getStatus().getStatusCode().getValue());

		assertEquals("An extension id, root id or a policySetIdReference must be provided",
				response.getWrappedObject().getStatus().getStatusMessage().getMessage());

		assertNotNull(response.getWrappedObject().getAssertions());
	}

	@Test
	public void testQueryPatientPolicyWithPolicy() throws Exception {

		// query HCP assertion
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient xuaClient = ClientFactory.getXuaClient(xuaClientConfig);

		SecurityHeaderElement patAssertion = null;
		try (InputStream is = new FileInputStream(new File("src/test/resources/ch-ppq/Assertion_bovie.xml"))) {

			var assertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var purposeOfUse = new PurposeOfUseBuilder().code(PurposeOfUse.NORMAL_ACCESS.getCodeValue())
					.codeSystem("2.16.756.5.30.1.127.3.10.6").displayName(PurposeOfUse.NORMAL_ACCESS.getDisplayName())
					.buildObject();
			var role = new RoleBuilder().code("PAT").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();

			var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("http://ehealthsuisse.ihe-europe.net/ppq-repository")
							.create())
					.purposeOfUse(purposeOfUse).subjectRole(role)
					.resourceId("761337610435209810^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO").create();

			List<XUserAssertionResponse> response = xuaClient.send(assertion, assertionRequest);

			patAssertion = response.get(0).getAssertion();
		}

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient client = ClientFactoryCh.getPpqClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610435209810");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponseImpl response = (PrivacyPolicyQueryResponseImpl) client
				.send(patAssertion, query);

		assertNotNull(response);
		assertNotNull(response.getWrappedObject());

		assertNotNull(response.getWrappedObject().getStatus());
		assertNotNull(response.getWrappedObject().getStatus().getStatusCode());
		assertNotNull(response.getWrappedObject().getStatus().getStatusMessage());
		assertEquals("urn:e-health-suisse:2015:error:not-holder-of-patient-policies",
				response.getWrappedObject().getStatus().getStatusCode().getValue());

		assertEquals("An extension id, root id or a policySetIdReference must be provided",
				response.getWrappedObject().getStatus().getStatusMessage().getValue());

		assertNotNull(response.getWrappedObject().getAssertions());
	}

	@Test
	public void testQueryHcpPolicyWithPolicy() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient client = ClientFactoryCh.getPpqClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610411265304");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponseImpl response = (PrivacyPolicyQueryResponseImpl) client.send(securityHeader, query);

		assertNotNull(response);
		assertNotNull(response.getWrappedObject());

		assertNotNull(response.getWrappedObject().getStatus());
		assertNotNull(response.getWrappedObject().getStatus().getStatusCode());
		assertNotNull(response.getWrappedObject().getStatus().getStatusMessage());
		assertEquals("urn:oasis:names:tc:SAML:2.0:status:Success",
				response.getWrappedObject().getStatus().getStatusCode().getValue());

		assertNotNull(response.getWrappedObject().getAssertions());

		Assertion assertion = response.getWrappedObject().getAssertions().get(0);

		assertNotNull(assertion);
		assertEquals("urn:e-health-suisse:community-index", assertion.getIssuer().getNameQualifier());
		assertEquals("urn:oid:1.3.6.1.4.1.21367.2017.2.6.2", assertion.getIssuer().getValue());

		assertNotNull(assertion.getStatements());

		assertNotNull(assertion.getStatements().get(0));
		assertTrue(
				assertion.getStatements().get(0) instanceof org.opensaml.xacml.profile.saml.XACMLPolicyStatementType);

		var statement = (org.opensaml.xacml.profile.saml.XACMLPolicyStatementType) assertion.getStatements().get(0);

		assertNotNull(statement.getPolicySets());
		assertFalse(statement.getPolicySets().isEmpty());

		var policySet = statement.getPolicySets().get(0);

		assertNotNull(policySet);
		assertEquals("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:deny-overrides",
				policySet.getPolicyCombiningAlgoId());
		assertEquals("Patient specific PolicySet", policySet.getDescription().getValue());

		assertNotNull(policySet.getTarget());
		assertNotNull(policySet.getTarget().getSubjects());
		assertNotNull(policySet.getTarget().getSubjects().getSubjects());
		assertNotNull(policySet.getTarget().getResources());
		assertNotNull(policySet.getTarget().getResources().getResources());

		assertFalse(policySet.getTarget().getSubjects().getSubjects().isEmpty());
		assertFalse(policySet.getTarget().getResources().getResources().isEmpty());

		var subject1 = policySet.getTarget().getSubjects().getSubjects().get(0);
		assertNotNull(subject1);
		assertFalse(subject1.getSubjectMatches().isEmpty());
		assertEquals("urn:oasis:names:tc:xacml:1.0:function:string-equal",
				subject1.getSubjectMatches().get(0).getMatchId());
		assertEquals("761337610411265304",
				subject1.getSubjectMatches().get(0).getAttributeValue().getValue());
		assertEquals("urn:oasis:names:tc:xacml:1.0:subject:subject-id",
				subject1.getSubjectMatches().get(0).getSubjectAttributeDesignator().getAttributeId());

		assertEquals("urn:oasis:names:tc:xacml:1.0:function:string-equal",
				subject1.getSubjectMatches().get(1).getMatchId());
		assertEquals("urn:e-health-suisse:2015:epr-spid",
				subject1.getSubjectMatches().get(1).getAttributeValue().getValue());
		assertEquals("urn:oasis:names:tc:xacml:1.0:subject:subject-id-qualifier",
				subject1.getSubjectMatches().get(1).getSubjectAttributeDesignator().getAttributeId());

		assertEquals("urn:hl7-org:v3:function:CV-equal",
				subject1.getSubjectMatches().get(2).getMatchId());
		var role = (XSAnyImpl) subject1.getSubjectMatches().get(2).getAttributeValue().getUnknownXMLObjects().get(0);
		assertEquals("PAT", role.getUnknownAttributes().get(new QName("code")));
		assertEquals("2.16.756.5.30.1.127.3.10.6", role.getUnknownAttributes().get(new QName("codeSystem")));
		assertEquals("urn:oasis:names:tc:xacml:2.0:subject:role",
				subject1.getSubjectMatches().get(2).getSubjectAttributeDesignator().getAttributeId());

		var resource = policySet.getTarget().getResources().getResources().get(0);
		assertNotNull(resource);
		assertFalse(resource.getResourceMatches().isEmpty());
		assertEquals("urn:hl7-org:v3:function:II-equal",
				resource.getResourceMatches().get(0).getMatchId());
		var instanceIdent = (InstanceIdentifierImpl) resource.getResourceMatches().get(0).getAttributeValue()
				.getUnknownXMLObjects().get(0);
		assertEquals("761337610411265304", instanceIdent.getExtension());
		assertEquals("2.16.756.5.30.1.127.3.10.3", instanceIdent.getRoot());
		assertEquals("urn:e-health-suisse:2015:epr-spid",
				resource.getResourceMatches().get(0).getResourceAttributeDesignator().getAttributeId());

		assertEquals("urn:e-health-suisse:2015:policies:access-level:full",
				policySet.getPolicySetIdReferences().get(0).getValue());

	}

}
