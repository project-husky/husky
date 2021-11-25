# Privacy Policy (PPQ)

This profile should simplify the exchange of authorization policies and policy sets. The PPQ profile includes two actors, the policy source and the policy repository. More details you can find here [EPDV-EDI_Anhang_5_E1_DE_Ausgabe_4.pdf](https://www.bag.admin.ch/dam/bag/de/dokumente/nat-gesundheitsstrategien/strategie-ehealth/gesetzgebung-elektronisches-patientendossier/gesetze/anhang_5_ergaenzung_1_epdv_edi_ausgabe_4.pdf.download.pdf/EPDV-EDI_Anhang_5_E1_DE_Ausgabe_4.pdf).
In Husky the PPQ profile is implemented in the `husky-ppq` module. There are four different use cases, where three of them are based on the same transaction (add, update and delete). The only difference between them is the use of a different method.

## Add policies

The transaction to add policies is called PPQ-1 (Privacy Policy Feed). It is a transaction to add a policy or a policy set in a policy repository. In husky project, policy feed is implemented in class SimplePpfClient.

An example for policy feed can be found in integration tests of husky ppq module. The class is called SimplePpfClientTest. To add a policy you have to create an instance of SimplePpfClient and create an instance of PrivacyPolicyFeed with method `AddPolicy`. After that the method send must be executed. Further details can be found in the Javadoc.

```java
// initialize client to add policy
PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
client.setCamelContext(camelContext);
client.setAuditContext(auditContext);

Assertion addPolicyAssertion = new AssertionBuilderImpl().version("2.0")
		.id(UUID.randomUUID().toString()).issueInstant(new GregorianCalendar())
		.create();

// set needed parameters to assertion

org.opensaml.saml.saml2.core.Assertion addPolicyAssertionOpenSaml = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl()
				.create(addPolicyAssertion)
				.getWrappedObject();

// create policy feed object with method add to add policy
PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.AddPolicy)
				.create(addPolicyAssertionOpenSaml);

// add policy
PrivacyPolicyFeedResponse response = client.send(xuaAssertion, ppFeedRequest);
```

Further details on the implementation can be found at [IPF CH-PPQ-1](https://oehf.github.io/ipf-docs/docs/ihe/chppq1/>)

## Update policies

The transaction to update policies is called PPQ-1 (Privacy Policy Feed). It is a transaction to update a policy or a policy set in a policy repository. In husky project, policy feed is implemented in class SimplePpfClient.

An example for policy feed can be found in integration tests of husky ppq module. The class is called SimplePpfClientTest. To update a policy you have to create an instance of SimplePpfClient and create an instance of PrivacyPolicyFeed with method `UpdatePolicy`. After that the method send must be executed. Further details can be found in the Javadoc.

```java
// initialize client to update policy
PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
client.setCamelContext(camelContext);
client.setAuditContext(auditContext);

// create assertion to update policy
Assertion updatePolicyAssertion = new AssertionBuilderImpl().version("2.0").id(UUID.randomUUID().toString())
				.issueInstant(new GregorianCalendar()).create();

// set different assertion parameters

// set policy set ID reference
XACMLPolicySetIdReferenceStatementType referenceId = new XACMLPolicySetIdReferenceStatementType();
IdReferenceType idReference = new IdReferenceType();
idReference.setValue("urn:e-health-suisse:2015:policies:access-level:delegation-and-restricted");
referenceId.getPolicySetIdReference().add(idReference);

policySet.getAdditionalInformation()
		.add(new JAXBElement<XACMLPolicySetIdReferenceStatementType>(
						new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicySetIdReference"),
						XACMLPolicySetIdReferenceStatementType.class, referenceId));

policyStatement.getPolicyOrPolicySet().add(policySet);

updatePolicyAssertion.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(policyStatement);

org.opensaml.saml.saml2.core.Assertion updatePolicyAssertionOpenSaml = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl()
				.create(updatePolicyAssertion)
				.getWrappedObject();

// create policy feed object with method update to update policy
PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.UpdatePolicy)
				.create(updatePolicyAssertionOpenSaml);

// update policy
PrivacyPolicyFeedResponse response = client.send(xuaAssertion, ppFeedRequest);
```

Further details on the implementation can be found at [IPF CH-PPQ-1](https://oehf.github.io/ipf-docs/docs/ihe/chppq1/>)

## Delete policies

The transaction to delete policies is called PPQ-1 (Privacy Policy Feed). It is a transaction to delete a policy or a policy set in a policy repository. In husky project, policy feed is implemented in class SimplePpfClient.

An example for policy feed can be found in integration tests of husky ppq module. The class is called SimplePpfClientTest. To delete a policy you have to create an instance of SimplePpfClient and create an instance of PrivacyPolicyFeed with method `DeletePolicy`. After that the method send must be executed. Further details can be found in the Javadoc.

```java
// initialize client to delete policy
PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
client.setCamelContext(camelContext);
client.setAuditContext(auditContext);
		
// create assertion to delete policy
Assertion deletePolicyAssertion = new AssertionBuilderImpl().version("2.0").id(UUID.randomUUID().toString())
				.issueInstant(new GregorianCalendar()).create();

// set home community ID
var nameId = new NameIDType();
nameId.setValue("urn:oid:1.3.6.1.4.1.21367.2017.2.6.2");
nameId.setNameQualifier("urn:e-health-suisse:community-index");
deletePolicyAssertion.setIssuer(nameId);

// set ID of policy which should be deleted
XACMLPolicySetIdReferenceStatementType policySetIdReferenceStatement = new XACMLPolicySetIdReferenceStatementType();
var idReference = new IdReferenceType();
idReference.setValue(policySetId);
policySetIdReferenceStatement.getPolicySetIdReference().add(idReference);

deletePolicyAssertion.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(policySetIdReferenceStatement);

org.opensaml.saml.saml2.core.Assertion deletePolicyAssertionOpenSaml = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl()
				.create(deletePolicyAssertion).getWrappedObject();

// create policy feed object with method delete to delete policy
PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.DeletePolicy)
				.create(deletePolicyAssertionOpenSaml);

// delete policy
PrivacyPolicyFeedResponse response = client.send(xuaAssertion, ppFeedRequest);
```

Further details on the implementation can be found at [IPF CH-PPQ-1](https://oehf.github.io/ipf-docs/docs/ihe/chppq1/>)

## Retrieve policies

The transaction to retrieve policies is called PPQ-2. It is a transaction to retrieve policies from a policy repository. In husky project, policy query is implemented in class SimplePpqClient.

An example for policy query can be found in integration tests of husky ppq module. The class is called SimplePpqClientTest. To retrieve policies you have to create an instance of SimplePpqClient and create an instance of PrivacyPolicyQuery. After that the method send must be executed. Further details can be found in the Javadoc.

```java
PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore).clientKeyStorePassword(clientKeyStorePass).create();
SimplePpqClient client = ClientFactoryCh.getPpqClient(config);
client.setCamelContext(camelContext);
client.setAuditContext(auditContext);

InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
instanceIdentifier.setExtension("761337610411265304");
instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier).issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
PrivacyPolicyQueryResponseImpl response = (PrivacyPolicyQueryResponseImpl) client.send(securityHeader, query);

```

Further details on the implementation can be found at [IPF CH-PPQ-2](https://oehf.github.io/ipf-docs/docs/ihe/chppq2/)
