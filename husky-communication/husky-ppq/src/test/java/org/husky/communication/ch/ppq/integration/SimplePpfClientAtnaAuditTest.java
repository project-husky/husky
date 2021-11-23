package org.husky.communication.ch.ppq.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.GregorianCalendar;
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
import org.husky.xua.hl7v3.InstanceIdentifier;
import org.husky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.husky.xua.saml2.Assertion;
import org.husky.xua.saml2.impl.AssertionBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * This test class is to check whether ATNA audit messages are sent in the
 * course of CH-PPQ-1 transactions. This is tested by checking whether audit
 * entries have been written to the LOG file.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
@ActiveProfiles("atna")
public class SimplePpfClientAtnaAuditTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimplePpfClientAtnaAuditTest.class.getName());

	@Autowired
	private CamelContext camelContext;
	
	@Autowired
	private AuditContext auditContext;
	
	private String urlToPpq = "https://ehealthsuisse.ihe-europe.net:10443/ppq-repository";
	private String clientKeyStore = "src/test/resources/testKeystore.jks";
	private String clientKeyStorePass = "changeit";

	/**
	 * This method initializes IPF and OpenSAML XACML modules and sets key- and
	 * truststore.
	 */
	@BeforeEach
	public void setup() {
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
	}

	/**
	 * This tests whether an audit event with type PPQ-1 and ID 110106 is sent when
	 * a policy is added and deleted.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSendPpq1AddDeletePolicy() throws Exception {

		// initialize client to add and delete policy
		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);
		client.setAuditContext(auditContext);

		Assertion addPolicyAssertion = new AssertionBuilderImpl().version("2.0").id(UUID.randomUUID().toString())
				.issueInstant(new GregorianCalendar()).create();

		var nameIdAdd = new NameIDType();
		nameIdAdd.setValue("urn:oid:1.3.6.1.4.1.21367.2017.2.6.2");
		nameIdAdd.setNameQualifier("urn:e-health-suisse:community-index");
		addPolicyAssertion.setIssuer(nameIdAdd);

		XACMLPolicyStatementType policyStatement = new XACMLPolicyStatementType();
		PolicySetType policySetAdd = new PolicySetType();
		policySetAdd.setCombiningAlg(new PolicyDenyOverridesAlgorithm());

		var id = new EvaluatableIDImpl(String.format("urn:uuid:%s", UUID.randomUUID().toString()));
		policySetAdd.setPolicySetId(id);

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

		policySetAdd.setTarget(target);

		XACMLPolicySetIdReferenceStatementType referenceId = new XACMLPolicySetIdReferenceStatementType();
		IdReferenceType idReferenceAdd = new IdReferenceType();
		idReferenceAdd.setValue("urn:e-health-suisse:2015:policies:access-level:delegation-and-normal");
		referenceId.getPolicySetIdReference().add(idReferenceAdd);

		policySetAdd.getAdditionalInformation()
				.add(new JAXBElement<XACMLPolicySetIdReferenceStatementType>(
						new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicySetIdReference"),
						XACMLPolicySetIdReferenceStatementType.class, referenceId));

		policyStatement.getPolicyOrPolicySet().add(policySetAdd);

		addPolicyAssertion.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(policyStatement);

		org.opensaml.saml.saml2.core.Assertion addPolicyAssertionOpenSaml = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl()
				.create(addPolicyAssertion)
				.getWrappedObject();

		// create policy feed object with method add to add policy
		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.AddPolicy)
				.create(addPolicyAssertionOpenSaml);

		// add policy
		PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);

		// check if policy was added successfully
		assertTrue(response.getExceptions().isEmpty());

		// create assertion to delete policy
		Assertion deletePolicyAssertion = new AssertionBuilderImpl().version("2.0").id(UUID.randomUUID().toString())
				.issueInstant(new GregorianCalendar()).create();

		var nameId = new NameIDType();
		nameId.setValue("urn:oid:1.3.6.1.4.1.21367.2017.2.6.2");
		nameId.setNameQualifier("urn:e-health-suisse:community-index");
		deletePolicyAssertion.setIssuer(nameId);

		// set ID of policy which should be deleted
		XACMLPolicySetIdReferenceStatementType policySetIdReferenceStatement = new XACMLPolicySetIdReferenceStatementType();
		var idReference = new IdReferenceType();
		idReference.setValue(queryPolicySetId());
		policySetIdReferenceStatement.getPolicySetIdReference().add(idReference);

		deletePolicyAssertion.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(policySetIdReferenceStatement);

		org.opensaml.saml.saml2.core.Assertion deletePolicyAssertionOpenSaml = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl()
				.create(deletePolicyAssertion).getWrappedObject();

		// create policy feed object with method delete to delete policy
		ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.DeletePolicy)
				.create(deletePolicyAssertionOpenSaml);

		// delete policy
		response = client.send(null, ppFeedRequest);

		assertTrue(response.getExceptions().isEmpty());

		// check audit logging entries
		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110106\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"PPQ-1\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110153\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110152\""));
	}

	/**
	 * This method queries added policy with CH-PPQ-2
	 * 
	 * @return policy set ID
	 */
	private String queryPolicySetId() {
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
		PrivacyPolicyQueryResponseImpl responseQuery = (PrivacyPolicyQueryResponseImpl) clientPpq.send(null,
				query);

		assertNotNull(responseQuery);
		assertNotNull(responseQuery.getWrappedObject());

		assertNotNull(responseQuery.getWrappedObject().getStatus());
		assertNotNull(responseQuery.getWrappedObject().getStatus().getStatusCode());
		assertNotNull(responseQuery.getWrappedObject().getStatus().getStatusMessage());
		assertEquals("urn:oasis:names:tc:SAML:2.0:status:Success",
				responseQuery.getWrappedObject().getStatus().getStatusCode().getValue());

		assertNotNull(responseQuery.getWrappedObject().getAssertions());

		org.opensaml.saml.saml2.core.Assertion policyAssertion = responseQuery.getWrappedObject().getAssertions().get(0);

		var statement = (org.opensaml.xacml.profile.saml.XACMLPolicyStatementType) policyAssertion.getStatements()
				.get(0);

		assertNotNull(statement.getPolicySets());
		assertFalse(statement.getPolicySets().isEmpty());

		var policySet = statement.getPolicySets().get(0);

		assertNotNull(policySet);

		return policySet.getPolicySetId();
	}

	/**
	 * This method extracts content of LOG file and checks if auditing is basically
	 * enabled.
	 * 
	 * @return
	 * @throws IOException
	 */
	private String checkAuditLogging() throws IOException {
		File originLogFile = new File("log/Spring-TestEHC.log");

		// extract content of log file
		String logContent = new String(Files.readAllBytes(originLogFile.toPath()));

		// check if ATNA audit events could be sent
		assertFalse(logContent.contains("Failed to send ATNA audit event to destination"));

		// check if ATNA auditing is basically enabled
		assertTrue(logContent.contains("Auditing"));

		return logContent;
	}

}
