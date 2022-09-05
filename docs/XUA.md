# Cross-Enterprise User Assertion Profile (XUA)

This profile provides a tool to communicate details about the identity of an authenticated user between different organizations. For these cross-enterprise transactions, it is important that the recipient can make access decisions based on the details provided. The XUA profile includes several actors. The central actors are the x-service user and the x-service provider. Moreover there are the user authentication provider and the X-Assertion Provider.
In Husky the XUA profile is implemented in the `husky-xua-gen-impl` module, more precisely in class SimpleXuaClient.

## Provide assertion

The transaction to provide a user assertion is called [ITI-40](<https://profiles.ihe.net/ITI/TF/Volume2/ITI-40.html>) 
in the security header of other transactions (e.g., RetrieveDocumentSet [ITI-43] to read documents from the EPR). 
The X-User Assertion shall be requested from the community using the Get X-User Assertion.   

An example for retrieving an X-User Assertion for authorization can be found in integration tests of husky xua-gen-impl module. 
The class is called XuaClientTest. To request an X-User Assertion you have to create an instance of SimpleXuaClient and 
XUserAssertionRequest to convey the claims.

```java
XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
    .clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

var role = new RoleBuilder().code("HCP").codeSystem("2.16.756.5.30.1.127.3.10.6")
    .displayName("Behandelnde(r)").buildObject();
var purposeOfUse = new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
    .displayName("Normal Access").buildObject();
String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
    .tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
    .appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
    .purposeOfUse(purposeOfUse).subjectRole(role).resourceId(resourceId).create();

List<XUserAssertionResponse> response = client.send(assertion, assertionRequest);

```

