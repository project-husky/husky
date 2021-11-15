package org.husky.communication.ch.ppq.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.camel.CamelContext;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyDenyOverridesAlgorithm;
import org.herasaf.xacml.core.dataTypeAttribute.impl.StringDataTypeAttribute;
import org.herasaf.xacml.core.function.impl.equalityPredicates.StringEqualFunction;
import org.herasaf.xacml.core.policy.impl.AttributeValueType;
import org.herasaf.xacml.core.policy.impl.EvaluatableIDImpl;
import org.herasaf.xacml.core.policy.impl.IdReferenceType;
import org.herasaf.xacml.core.policy.impl.PolicySetType;
import org.herasaf.xacml.core.policy.impl.ResourceAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.ResourceMatchType;
import org.herasaf.xacml.core.policy.impl.ResourceType;
import org.herasaf.xacml.core.policy.impl.ResourcesType;
import org.herasaf.xacml.core.policy.impl.SubjectAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.SubjectMatchType;
import org.herasaf.xacml.core.policy.impl.SubjectType;
import org.herasaf.xacml.core.policy.impl.SubjectsType;
import org.herasaf.xacml.core.policy.impl.TargetType;
import org.husky.communication.ch.enums.PurposeOfUse;
import org.husky.communication.ch.ppq.TestApplication;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.husky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryResponseImpl;
import org.husky.communication.ch.ppq.impl.clients.ClientFactoryCh;
import org.husky.communication.ch.ppq.impl.clients.SimplePpfClient;
import org.husky.communication.ch.ppq.impl.clients.SimplePpqClient;
import org.husky.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.authentication.impl.AuthnRequestBuilderImpl;
import org.husky.xua.communication.clients.XuaClient;
import org.husky.xua.communication.clients.impl.ClientFactory;
import org.husky.xua.communication.clients.impl.IdpSoapBindingClientByBasicAuth;
import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl;
import org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.husky.xua.communication.xua.RequestType;
import org.husky.xua.communication.xua.TokenType;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.husky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.deserialization.impl.AssertionDeserializerImpl;
import org.husky.xua.exceptions.ClientSendException;
import org.husky.xua.exceptions.DeserializeException;
import org.husky.xua.hl7v3.InstanceIdentifier;
import org.husky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.husky.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.husky.xua.hl7v3.impl.RoleBuilder;
import org.husky.xua.saml2.Assertion;
import org.husky.xua.saml2.impl.AssertionBuilderImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.xacml20.Xacml20Utils;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.functions.CvEqualFunction;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.functions.IiEqualFunction;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.types.CvDataTypeAttribute;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.types.IiDataTypeAttribute;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.XACMLPolicySetIdReferenceStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.CV;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.II;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.NameIDType;
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
@TestMethodOrder(OrderAnnotation.class)
public class SimplePpfClientTest {

	@Autowired
	private CamelContext camelContext;

	@Autowired
	private AuditContext auditContext;

	private String urlToPpq = "https://ehealthsuisse.ihe-europe.net:10443/ppq-repository";
	private static final String urlToXua = "https://ehealthsuisse.ihe-europe.net:10443/STS";
	private static final String urlToIdp = "https://ehealthsuisse.ihe-europe.net/idp/profile/SAML2/SOAP/ECP";
	private static final String clientKeyStore = "src/test/resources/testKeystore.jks";
	private static final String clientKeyStorePass = "changeit";
	private static SecurityHeaderElement patAssertion = null;

	@BeforeAll
	public static void setup() throws FileNotFoundException, IOException, DeserializeException, ClientSendException {
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

		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient xuaClient = ClientFactory.getXuaClient(xuaClientConfig);

		var purposeOfUse = new PurposeOfUseBuilder().code(PurposeOfUse.NORMAL_ACCESS.getCodeValue())
				.codeSystem("2.16.756.5.30.1.127.3.10.6").displayName(PurposeOfUse.NORMAL_ACCESS.getDisplayName())
				.buildObject();
		var role = new RoleBuilder().code("HCP").codeSystem("2.16.756.5.30.1.127.3.10.6").displayName("Behandelnde(r)")
				.buildObject();

		var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
				.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
				.appliesTo(new AppliesToBuilderImpl().address("http://ehealthsuisse.ihe-europe.net/ppq-repository")
						.create())
				.purposeOfUse(purposeOfUse).subjectRole(role)
				.resourceId("761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO").create();

		List<XUserAssertionResponse> response = xuaClient.send(requestIdpAssertion("aandrews", "azerty"),
				assertionRequest);

		patAssertion = response.get(0).getAssertion();
	}

	private static Assertion requestIdpAssertion(String user, String password) throws ClientSendException {
		IdpClientBasicAuthConfigImpl idpClientConfig = new IdpClientBasicAuthConfigBuilderImpl()
				.basicAuthPassword(password).basicAuthUsername(user).url(urlToIdp).create();

		IdpSoapBindingClientByBasicAuth client = (IdpSoapBindingClientByBasicAuth) ClientFactory
				.getIdpClient(idpClientConfig);

		AuthnRequest authnRequest = new AuthnRequestBuilderImpl()
				.assertionConsumerServiceUrl("https://sp-clone.ihe-europe.net/Shibboleth.sso/SAML2/ECP")
				.issueInstant(new GregorianCalendar()).id(String.valueOf(System.currentTimeMillis()))
				.protocolBinding("urn:oasis:names:tc:SAML:2.0:bindings:PAOS").version("2.0")
				.issuer("https://sp-clone.ihe-europe.net/shibboleth").nameIdPolicyAllowCreate(true)
				.providerId("https://idp.ihe-europe.net/idp/shibboleth").create();
		var response = client.send(authnRequest);

		return response.getAssertions().get(0);

	}

	@Test
	@Order(1)
	public void testSendPpq1AddPolicy() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		assertNotNull(patAssertion);

		File fileAssertionOnly = new File("src/test/resources/ch-ppq/add_policy_assertion.xml");

		Assertion assertionRequest = new AssertionBuilderImpl().version("2.0")
				.id(UUID.randomUUID().toString()).issueInstant(new GregorianCalendar())
				.create();

		var nameId = new NameIDType();
		nameId.setValue("urn:oid:1.3.6.1.4.1.21367.2017.2.6.2");
		nameId.setNameQualifier("urn:e-health-suisse:community-index");
		assertionRequest.setIssuer(nameId);

		XACMLPolicyStatementType policyStatement = new XACMLPolicyStatementType();
		PolicySetType policySet = new PolicySetType();
		policySet.setCombiningAlg(new PolicyDenyOverridesAlgorithm());

		var id = new EvaluatableIDImpl(String.format("urn:uuid:%s", UUID.randomUUID().toString()));
		policySet.setPolicySetId(id);

		TargetType target = new TargetType();
		SubjectsType subjects = new SubjectsType();
		SubjectType subject = new SubjectType();

		SubjectMatchType match1 = new SubjectMatchType();
		match1.setMatchFunction(new StringEqualFunction());
		AttributeValueType attributeVal = new AttributeValueType();
		attributeVal.setDataType(new StringDataTypeAttribute());
		attributeVal.getContent().add("7601002469191");
		match1.setAttributeValue(attributeVal);

		SubjectAttributeDesignatorType subjAttrDesgn = new SubjectAttributeDesignatorType();
		subjAttrDesgn.setAttributeId("urn:oasis:names:tc:xacml:1.0:subject:subject-id");
		subjAttrDesgn.setDataType(new StringDataTypeAttribute());
		match1.setSubjectAttributeDesignator(subjAttrDesgn);

		subject.getSubjectMatches().add(match1);

		SubjectMatchType match2 = new SubjectMatchType();
		match2.setMatchFunction(new StringEqualFunction());
		attributeVal = new AttributeValueType();
		attributeVal.setDataType(new StringDataTypeAttribute());
		attributeVal.getContent().add("urn:gs1:gln");
		match2.setAttributeValue(attributeVal);

		subjAttrDesgn = new SubjectAttributeDesignatorType();
		subjAttrDesgn.setAttributeId("urn:oasis:names:tc:xacml:1.0:subject:subject-id-qualifier");
		subjAttrDesgn.setDataType(new StringDataTypeAttribute());
		match2.setSubjectAttributeDesignator(subjAttrDesgn);

		subject.getSubjectMatches().add(match2);

		SubjectMatchType match3 = new SubjectMatchType();
		match3.setMatchFunction(new CvEqualFunction());
		attributeVal = new AttributeValueType();
		attributeVal.setDataType(new CvDataTypeAttribute());

		var cv = new CV();
		cv.setCode("HCP");
		cv.setCodeSystem("2.16.756.5.30.1.127.3.10.6");

		attributeVal.getContent()
				.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "CodedValue"), CV.class, cv));
		match3.setAttributeValue(attributeVal);

		subjAttrDesgn = new SubjectAttributeDesignatorType();
		subjAttrDesgn.setAttributeId("urn:oasis:names:tc:xacml:2.0:subject:role");
		subjAttrDesgn.setDataType(new CvDataTypeAttribute());
		match3.setSubjectAttributeDesignator(subjAttrDesgn);

		subject.getSubjectMatches().add(match3);

		subjects.getSubjects().add(subject);
		target.setSubjects(subjects);

		ResourcesType resources = new ResourcesType();
		ResourceType resource = new ResourceType();
		ResourceMatchType resourceMatch = new ResourceMatchType();
		resourceMatch.setMatchFunction(new IiEqualFunction());

		attributeVal = new AttributeValueType();
		attributeVal.setDataType(new IiDataTypeAttribute());
		var instanceId = new II();
		instanceId.setExtension("761337610411265304");
		instanceId.setRoot("2.16.756.5.30.1.127.3.10.3");
		attributeVal.getContent()
				.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "InstanceIdentifier"), II.class, instanceId));
		resourceMatch.setAttributeValue(attributeVal);

		ResourceAttributeDesignatorType resourceAttrDesign = new ResourceAttributeDesignatorType();
		resourceAttrDesign.setDataType(new IiDataTypeAttribute());
		resourceAttrDesign.setAttributeId("urn:e-health-suisse:2015:epr-spid");
		resourceMatch.setResourceAttributeDesignator(resourceAttrDesign);
		resource.getResourceMatches().add(resourceMatch);
		resources.getResources().add(resource);
		target.setResources(resources);

		policySet.setTarget(target);
		
		XACMLPolicySetIdReferenceStatementType referenceId = new XACMLPolicySetIdReferenceStatementType();
		IdReferenceType idReference = new IdReferenceType();
		idReference.setValue("urn:e-health-suisse:2015:policies:access-level:delegation-and-normal");
		referenceId.getPolicySetIdReference().add(idReference);
		
		policySet.getAdditionalInformation()
				.add(new JAXBElement<XACMLPolicySetIdReferenceStatementType>(
						new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicySetIdReference"),
						XACMLPolicySetIdReferenceStatementType.class, referenceId));

		policyStatement.getPolicyOrPolicySet().add(policySet);

		assertionRequest.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(policyStatement);

		org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl()
				.create(assertionRequest)
				.getWrappedObject();
		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.AddPolicy)
				.create(samlAssertion);

		PrivacyPolicyFeedResponse response = client.send(patAssertion, ppFeedRequest);

		assertTrue(response.getExceptions().isEmpty());
		assertNotEquals("urn:e-health-suisse:2015:response-status:failure", response.getStatus());
	}

	@Test
	@Order(2)
	public void testSendPpq1UpdatePolicy() throws Exception {
		assertNotNull(patAssertion);

		PpClientConfig configQuery = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient clientPpq = ClientFactoryCh.getPpqClient(configQuery);
		clientPpq.setCamelContext(camelContext);
		clientPpq.setAuditContext(auditContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610411265304");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponseImpl responseQuery = (PrivacyPolicyQueryResponseImpl) clientPpq.send(patAssertion,
				query);

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

		org.opensaml.xacml.policy.PolicySetType policySetExist = null;
		for (org.opensaml.xacml.policy.PolicySetType policySet : statement.getPolicySets()) {
			if (policySet != null && policySet.getPolicySetIdReferences() != null
					&& !policySet.getPolicySetIdReferences().isEmpty()
					&& policySet.getPolicySetIdReferences().get(0) != null
					&& policySet.getPolicySetIdReferences().get(0).getValue() != null
					&&
					"urn:e-health-suisse:2015:policies:access-level:delegation-and-normal".equalsIgnoreCase(policySet.getPolicySetIdReferences().get(0).getValue())) {
				policySetExist = policySet;
			}
		}

		assertNotNull(policySetExist);

		String policySetId = policySetExist.getPolicySetId();

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		Assertion assertionRequest = new AssertionBuilderImpl().version("2.0").id(UUID.randomUUID().toString())
				.issueInstant(new GregorianCalendar()).create();

		var nameId = new NameIDType();
		nameId.setValue("urn:oid:1.3.6.1.4.1.21367.2017.2.6.2");
		nameId.setNameQualifier("urn:e-health-suisse:community-index");
		assertionRequest.setIssuer(nameId);

		XACMLPolicyStatementType policyStatement = new XACMLPolicyStatementType();
		PolicySetType policySet = new PolicySetType();
		policySet.setCombiningAlg(new PolicyDenyOverridesAlgorithm());

		var id = new EvaluatableIDImpl(policySetId);
		policySet.setPolicySetId(id);

		policySet.setDescription("TEST UPDATE POLICY");

		TargetType target = new TargetType();
		SubjectsType subjects = new SubjectsType();
		SubjectType subject = new SubjectType();

		SubjectMatchType match1 = new SubjectMatchType();
		match1.setMatchFunction(new StringEqualFunction());
		AttributeValueType attributeVal = new AttributeValueType();
		attributeVal.setDataType(new StringDataTypeAttribute());
		attributeVal.getContent().add("7601002469191");
		match1.setAttributeValue(attributeVal);

		SubjectAttributeDesignatorType subjAttrDesgn = new SubjectAttributeDesignatorType();
		subjAttrDesgn.setAttributeId("urn:oasis:names:tc:xacml:1.0:subject:subject-id");
		subjAttrDesgn.setDataType(new StringDataTypeAttribute());
		match1.setSubjectAttributeDesignator(subjAttrDesgn);

		subject.getSubjectMatches().add(match1);

		SubjectMatchType match2 = new SubjectMatchType();
		match2.setMatchFunction(new StringEqualFunction());
		attributeVal = new AttributeValueType();
		attributeVal.setDataType(new StringDataTypeAttribute());
		attributeVal.getContent().add("urn:gs1:gln");
		match2.setAttributeValue(attributeVal);

		subjAttrDesgn = new SubjectAttributeDesignatorType();
		subjAttrDesgn.setAttributeId("urn:oasis:names:tc:xacml:1.0:subject:subject-id-qualifier");
		subjAttrDesgn.setDataType(new StringDataTypeAttribute());
		match2.setSubjectAttributeDesignator(subjAttrDesgn);

		subject.getSubjectMatches().add(match2);

		SubjectMatchType match3 = new SubjectMatchType();
		match3.setMatchFunction(new CvEqualFunction());
		attributeVal = new AttributeValueType();
		attributeVal.setDataType(new CvDataTypeAttribute());

		var cv = new CV();
		cv.setCode("HCP");
		cv.setCodeSystem("2.16.756.5.30.1.127.3.10.6");

		attributeVal.getContent().add(new JAXBElement<>(new QName("urn:hl7-org:v3", "CodedValue"), CV.class, cv));
		match3.setAttributeValue(attributeVal);

		subjAttrDesgn = new SubjectAttributeDesignatorType();
		subjAttrDesgn.setAttributeId("urn:oasis:names:tc:xacml:2.0:subject:role");
		subjAttrDesgn.setDataType(new CvDataTypeAttribute());
		match3.setSubjectAttributeDesignator(subjAttrDesgn);

		subject.getSubjectMatches().add(match3);

		subjects.getSubjects().add(subject);
		target.setSubjects(subjects);

		ResourcesType resources = new ResourcesType();
		ResourceType resource = new ResourceType();
		ResourceMatchType resourceMatch = new ResourceMatchType();
		resourceMatch.setMatchFunction(new IiEqualFunction());

		attributeVal = new AttributeValueType();
		attributeVal.setDataType(new IiDataTypeAttribute());
		var instanceId = new II();
		instanceId.setExtension("761337610411265304");
		instanceId.setRoot("2.16.756.5.30.1.127.3.10.3");
		attributeVal.getContent()
				.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "InstanceIdentifier"), II.class, instanceId));
		resourceMatch.setAttributeValue(attributeVal);

		ResourceAttributeDesignatorType resourceAttrDesign = new ResourceAttributeDesignatorType();
		resourceAttrDesign.setDataType(new IiDataTypeAttribute());
		resourceAttrDesign.setAttributeId("urn:e-health-suisse:2015:epr-spid");
		resourceMatch.setResourceAttributeDesignator(resourceAttrDesign);
		resource.getResourceMatches().add(resourceMatch);
		resources.getResources().add(resource);
		target.setResources(resources);

		policySet.setTarget(target);

		XACMLPolicySetIdReferenceStatementType referenceId = new XACMLPolicySetIdReferenceStatementType();
		IdReferenceType idReference = new IdReferenceType();
		idReference.setValue("urn:e-health-suisse:2015:policies:access-level:delegation-and-restricted");
		referenceId.getPolicySetIdReference().add(idReference);

		policySet.getAdditionalInformation()
				.add(new JAXBElement<XACMLPolicySetIdReferenceStatementType>(
						new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicySetIdReference"),
						XACMLPolicySetIdReferenceStatementType.class, referenceId));

		policyStatement.getPolicyOrPolicySet().add(policySet);

		assertionRequest.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(policyStatement);

		org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl()
				.create(assertionRequest)
				.getWrappedObject();

		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.UpdatePolicy)
				.create(samlAssertion);

		PrivacyPolicyFeedResponse response = client.send(patAssertion, ppFeedRequest);

		assertTrue(response.getExceptions().isEmpty());
		assertEquals("urn:e-health-suisse:2015:response-status:success", response.getStatus());

	}

	@Test
	@Order(3)
	public void testSendPpq1DeletePolicy() throws Exception {
		PpClientConfig configQuery = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient clientPpq = ClientFactoryCh.getPpqClient(configQuery);
		clientPpq.setCamelContext(camelContext);
		clientPpq.setAuditContext(auditContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610411265304");
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
				.create(assertionRequest).getWrappedObject();

		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.DeletePolicy)
				.create(samlAssertion);

		PrivacyPolicyFeedResponse response = client.send(patAssertion, ppFeedRequest);

		assertTrue(response.getExceptions().isEmpty());
		assertEquals("urn:e-health-suisse:2015:response-status:success", response.getStatus());
	}

}
