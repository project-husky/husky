# Privacy Policy (PPQ)

This profile should simplify the exchange of authorization policies and policy sets. The PPQ profile includes two actors, the policy source and the policy repository. More details you can find here [EPDV-EDI_Anhang_5_E1_DE_Ausgabe_4.pdf](https://www.bag.admin.ch/dam/bag/de/dokumente/nat-gesundheitsstrategien/strategie-ehealth/gesetzgebung-elektronisches-patientendossier/gesetze/anhang_5_ergaenzung_1_epdv_edi_ausgabe_4.pdf.download.pdf/EPDV-EDI_Anhang_5_E1_DE_Ausgabe_4.pdf).
In Husky the PPQ profile is implemented in the `husky-ppq` module. There are four different use cases, where three of them are based on the same transaction (add, update and delete). The only difference between them is the use of a different method.

## Add policies

The transaction to add policies is called PPQ-1 (Privacy Policy Feed). It is a transaction to add a policy or a policy set in a policy repository. In husky project, policy feed is implemented in class [SimplePpfClient](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpfClient.html).

An example for policy feed can be found in integration tests of husky ppq module. The class is called [SimplePpfClientTest](javadoc/org/husky/communication/ch/ppq/integration/SimplePpfClientTest.html). To add a policy you have to create an instance of [SimplePpfClient](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpfClient.html) and create an instance of [PrivacyPolicyFeed](javadoc/org/husky/communication/ch/ppq/api/PrivacyPolicyFeed.html) with method `AddPolicy`. After that the method [send](javadoc/org/husky/communication/ch/ppq/api/SimplePpfClient.html#send(org.husky.xua.core.SecurityHeaderElement,org.husky.communication.ch.ppq.api.PrivacyPolicyFeed)) must be executed. Further details can be found in the Javadoc.

```java
PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore).clientKeyStorePassword(clientKeyStorePass).create();
SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
client.setCamelContext(camelContext);
client.setAuditContext(auditContext);

File fileAssertionOnly = new File("src/test/resources/ch-ppq/add_policy_assertion.xml");

Assertion assertionRequest = null;
try (var fis = new FileInputStream(fileAssertionOnly)) {
    var deserializer = new AssertionDeserializerImpl();
    assertionRequest = deserializer.fromXmlByteArray(fis.readAllBytes());
}

org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) assertionRequest.getWrappedObject();
PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.AddPolicy).create(samlAssertion);

PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);
```

Further details on the implementation can be found at [IPF CH-PPQ-1](https://oehf.github.io/ipf-docs/docs/ihe/chppq1/>)

## Update policies

The transaction to update policies is called PPQ-1 (Privacy Policy Feed). It is a transaction to update a policy or a policy set in a policy repository. In husky project, policy feed is implemented in class [SimplePpfClient](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpfClient.html).

An example for policy feed can be found in integration tests of husky ppq module. The class is called [SimplePpfClientTest](javadoc/org/husky/communication/ch/ppq/integration/SimplePpfClientTest.html). To update a policy you have to create an instance of [SimplePpfClient](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpfClient.html) and create an instance of [PrivacyPolicyFeed](javadoc/org/husky/communication/ch/ppq/api/PrivacyPolicyFeed.html) with method `UpdatePolicy`. After that the method [send](javadoc/org/husky/communication/ch/ppq/api/SimplePpfClient.html#send(org.husky.xua.core.SecurityHeaderElement,org.husky.communication.ch.ppq.api.PrivacyPolicyFeed)) must be executed. Further details can be found in the Javadoc.

```java
PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore).clientKeyStorePassword(clientKeyStorePass).create();
SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
client.setCamelContext(camelContext);
client.setAuditContext(auditContext);

Assertion assertionRequest = null;
try (var fis = new FileInputStream(new File("src/test/resources/ch-ppq/update_policy_request_assertion_only.xml"))) {
    var deserializer = new AssertionDeserializerImpl();
    assertionRequest = deserializer.fromXmlByteArray(fis.readAllBytes());
}

var xacmlStatement = (XACMLPolicyStatementType) assertionRequest.getStatementOrAuthnStatementOrAuthzDecisionStatement().get(0);
var policySetType = (PolicySetType) xacmlStatement.getPolicyOrPolicySet().get(0);
policySetType.setPolicySetId(new EvaluatableIDImpl(policySetId));
xacmlStatement.getPolicyOrPolicySet().clear();
xacmlStatement.getPolicyOrPolicySet().add(policySetType);
assertionRequest.getStatementOrAuthnStatementOrAuthzDecisionStatement().clear();
assertionRequest.getStatementOrAuthnStatementOrAuthzDecisionStatement().add(xacmlStatement);

org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) assertionRequest.getWrappedObject();
PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.UpdatePolicy).create(samlAssertion);

PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);
```

Further details on the implementation can be found at [IPF CH-PPQ-1](https://oehf.github.io/ipf-docs/docs/ihe/chppq1/>)

## Delete policies

The transaction to delete policies is called PPQ-1 (Privacy Policy Feed). It is a transaction to delete a policy or a policy set in a policy repository. In husky project, policy feed is implemented in class [SimplePpfClient](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpfClient.html).

An example for policy feed can be found in integration tests of husky ppq module. The class is called [SimplePpfClientTest](javadoc/org/husky/communication/ch/ppq/integration/SimplePpfClientTest.html). To delete a policy you have to create an instance of [SimplePpfClient](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpfClient.html) and create an instance of [PrivacyPolicyFeed](javadoc/org/husky/communication/ch/ppq/api/PrivacyPolicyFeed.html) with method `DeletePolicy`. After that the method [send](javadoc/org/husky/communication/ch/ppq/api/SimplePpfClient.html#send(org.husky.xua.core.SecurityHeaderElement,org.husky.communication.ch.ppq.api.PrivacyPolicyFeed)) must be executed. Further details can be found in the Javadoc.

```java
PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore).clientKeyStorePassword(clientKeyStorePass).create();
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

org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) new AssertionBuilderImpl().create(assertionRequest).getWrappedObject();

PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.DeletePolicy).create(samlAssertion);

PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);
```

Further details on the implementation can be found at [IPF CH-PPQ-1](https://oehf.github.io/ipf-docs/docs/ihe/chppq1/>)

## Retrieve policies

The transaction to retrieve policies is called PPQ-2. It is a transaction to retrieve policies from a policy repository. In husky project, policy query is implemented in class [SimplePpqClient](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpqClient.html).

An example for policy query can be found in integration tests of husky ppq module. The class is called [SimplePpqClientTest](javadoc/org/husky/communication/ch/ppq/integration/SimplePpqClientTest.html). To retrieve policies you have to create an instance of [SimplePpqClient](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpqClient.html) and create an instance of [PrivacyPolicyQuery](javadoc/org/husky/communication/ch/ppq/api/PrivacyPolicyQuery.html). After that the method [send](javadoc/org/husky/communication/ch/ppq/impl/clients/SimplePpqClient.html#send(org.husky.xua.core.SecurityHeaderElement,org.husky.communication.ch.ppq.api.PrivacyPolicyQuery)) must be executed. Further details can be found in the Javadoc.

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
