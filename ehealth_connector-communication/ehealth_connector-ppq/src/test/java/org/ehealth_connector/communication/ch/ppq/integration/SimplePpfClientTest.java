package org.ehealth_connector.communication.ch.ppq.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.apache.camel.CamelContext;
import org.ehealth_connector.communication.ch.ppq.TestApplication;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyQueryResponseImpl;
import org.ehealth_connector.communication.ch.ppq.impl.clients.ClientFactoryCh;
import org.ehealth_connector.communication.ch.ppq.impl.clients.SimplePpfClient;
import org.ehealth_connector.communication.ch.ppq.impl.clients.SimplePpqClient;
import org.ehealth_connector.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.ehealth_connector.xua.deserialization.impl.AssertionDeserializerImpl;
import org.ehealth_connector.xua.hl7v3.InstanceIdentifier;
import org.ehealth_connector.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.ehealth_connector.xua.saml2.Assertion;
import org.ehealth_connector.xua.saml2.impl.AssertionBuilderImpl;
import org.herasaf.xacml.core.policy.impl.EvaluatableIDImpl;
import org.herasaf.xacml.core.policy.impl.IdReferenceType;
import org.herasaf.xacml.core.policy.impl.PolicySetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.xacml20.Xacml20Utils;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.XACMLPolicySetIdReferenceStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class SimplePpfClientTest {

	@Autowired
	private CamelContext camelContext;

	@Autowired
	private AuditContext auditContext;

	private String urlToPpq = "http://ehealthsuisse.ihe-europe.net:8280/ppq-repository";
	private String clientKeyStore = "src/test/resources/testKeystore.jks";
	private String clientKeyStorePass = "changeit";

	@BeforeEach
	public void setup() {
		try {
			InitializationService.initialize();
			Xacml20Utils.initializeHerasaf();

			File file = new File(clientKeyStore);

			System.setProperty("javax.net.ssl.keyStore", clientKeyStore);
			System.setProperty("javax.net.ssl.keyStorePassword", clientKeyStorePass);
			System.setProperty("javax.net.ssl.trustStore", clientKeyStore);
			System.setProperty("javax.net.ssl.trustStorePassword", clientKeyStorePass);
		} catch (InitializationException e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testSendPpq1AddPolicy() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		File fileAssertionOnly = new File("src/test/resources/ch-ppq/add_policy_assertion.xml");

		Assertion assertionRequest = null;
		try (var fis = new FileInputStream(fileAssertionOnly)) {
			var deserializer = new AssertionDeserializerImpl();
			assertionRequest = deserializer.fromXmlByteArray(fis.readAllBytes());
		}

		org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) assertionRequest
				.getWrappedObject();
		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.AddPolicy)
				.create(samlAssertion);

		PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);

		assertTrue(response.getExceptions().isEmpty());
	}

	@Test
	public void testSendPpq1UpdatePolicy() throws Exception {
		PpClientConfig configQuery = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient clientPpq = ClientFactoryCh.getPpqClient(configQuery);
		clientPpq.setCamelContext(camelContext);
		clientPpq.setAuditContext(auditContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610435209810");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponseImpl responseQuery = (PrivacyPolicyQueryResponseImpl) clientPpq.send(null, query);

		assertNotNull(responseQuery);
		assertNotNull(responseQuery.getWrappedObject());

		assertNotNull(responseQuery.getWrappedObject().getStatus());
		assertNotNull(responseQuery.getWrappedObject().getStatus().getStatusCode());
		assertNotNull(responseQuery.getWrappedObject().getStatus().getStatusMessage());
		assertEquals("urn:oasis:names:tc:SAML:2.0:status:Success",
				responseQuery.getWrappedObject().getStatus().getStatusCode().getValue());

		assertNotNull(responseQuery.getWrappedObject().getAssertions());

		org.opensaml.saml.saml2.core.Assertion assertionQuery = responseQuery.getWrappedObject().getAssertions().get(0);

		var statement = (org.opensaml.xacml.profile.saml.XACMLPolicyStatementType) assertionQuery.getStatements()
				.get(0);

		assertNotNull(statement.getPolicySets());
		assertFalse(statement.getPolicySets().isEmpty());

		var policySet = statement.getPolicySets().get(0);

		assertNotNull(policySet);

		String policySetId = policySet.getPolicySetId();

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		Assertion assertionRequest = null;
		try (var fis = new FileInputStream(new File("src/test/resources/ch-ppq/update_policy_request_assertion_only.xml"))) {
			var deserializer = new AssertionDeserializerImpl();
			assertionRequest = deserializer.fromXmlByteArray(fis.readAllBytes());
		}

		var xacmlStatement = (XACMLPolicyStatementType) assertionRequest
				.getStatementOrAuthnStatementOrAuthzDecisionStatement().get(0);
		var policySetType = (PolicySetType) xacmlStatement.getPolicyOrPolicySet().get(0);
		policySetType.setPolicySetId(new EvaluatableIDImpl(policySetId));
		xacmlStatement.getPolicyOrPolicySet().clear();
		xacmlStatement.getPolicyOrPolicySet().add(policySetType);
		assertionRequest.getStatementOrAuthnStatementOrAuthzDecisionStatement().clear();
		assertionRequest.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(xacmlStatement);

		org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) assertionRequest
				.getWrappedObject();
		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.UpdatePolicy)
				.create(samlAssertion);

		PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);

		assertNull(response.getExceptions());

	}

	@Test
	public void testSendPpq1DeletePolicy() throws Exception {
		PpClientConfig configQuery = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient clientPpq = ClientFactoryCh.getPpqClient(configQuery);
		clientPpq.setCamelContext(camelContext);
		clientPpq.setAuditContext(auditContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610435209810");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponseImpl responseQuery = (PrivacyPolicyQueryResponseImpl) clientPpq.send(null, query);

		assertNotNull(responseQuery);
		assertNotNull(responseQuery.getWrappedObject());

		assertNotNull(responseQuery.getWrappedObject().getStatus());
		assertNotNull(responseQuery.getWrappedObject().getStatus().getStatusCode());
		assertNotNull(responseQuery.getWrappedObject().getStatus().getStatusMessage());
		assertEquals("urn:oasis:names:tc:SAML:2.0:status:Success",
				responseQuery.getWrappedObject().getStatus().getStatusCode().getValue());

		assertNotNull(responseQuery.getWrappedObject().getAssertions());

		org.opensaml.saml.saml2.core.Assertion assertionQuery = responseQuery.getWrappedObject().getAssertions().get(0);

		var statement = (org.opensaml.xacml.profile.saml.XACMLPolicyStatementType) assertionQuery.getStatements()
				.get(0);

		assertNotNull(statement.getPolicySets());
		assertFalse(statement.getPolicySets().isEmpty());

		var policySet = statement.getPolicySets().get(0);

		assertNotNull(policySet);

		String policySetId = policySet.getPolicySetId();


		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		File fileAssertionOnly = new File("src/test/resources/ch-ppq/delete_policy_assertion.xml");

		Assertion assertionRequest = null;
		try (var fis = new FileInputStream(fileAssertionOnly)) {
			var deserializer = new AssertionDeserializerImpl();
			assertionRequest = deserializer.fromXmlByteArray(fis.readAllBytes());
		}
		
		var xacmlStatement = new XACMLPolicySetIdReferenceStatementType();
		var idReference = new IdReferenceType();
		idReference.setValue(policySetId);
		xacmlStatement.getPolicySetIdReference().add(idReference);

		assertionRequest.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(xacmlStatement);


		org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl()
				.create(assertionRequest)
				.getWrappedObject();

		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.DeletePolicy)
				.create(samlAssertion);

		PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);

		assertTrue(response.getExceptions().isEmpty());
	}

}
