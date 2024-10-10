/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.responses.xua;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.RequestedSecurityToken;
import org.projecthusky.xua.communication.xua.XUserAssertionResponse;
import org.projecthusky.xua.communication.xua.impl.XUserAssertionResponseImpl;
import org.projecthusky.xua.saml2.impl.AssertionBuilderImpl;
import org.projecthusky.xua.saml2.impl.AssertionImpl;

/**
 * Class holding the XUA assertion.
 *
 * <p>
 * <b>Be aware:</b> Most frameworks are using the org.opensaml implementation of the SAMLAssertion.
 * For the Husky Framework, there is an own implementation of the Assertion, therefor, we will
 * transform the standard Assertion into the husky assertion.
 */
@Slf4j
@Getter
@ToString
public class XuaResponse {
  @NotNull
  private final org.projecthusky.xua.saml2.Assertion assertion;

  public XuaResponse(List<XUserAssertionResponse> xuaResponse) {
    assertion = getXuaAssertionFromResponse(xuaResponse);
  }

  /**
   * Important - do NOT use new AssertionBuilderImpl().create(assertion) as it will break the DOM of
   * the assertion object, e.g. the SignatureValue is removed! Therefor, we use reflection to avoid
   * this problem.
   */
  private org.projecthusky.xua.saml2.Assertion convertSamlToHuskyAssertion(
      org.opensaml.saml.saml2.core.Assertion assertion) {
    org.projecthusky.xua.saml2.Assertion huskyIdpAssertion = new AssertionBuilderImpl().create();
    setAssertion(huskyIdpAssertion, assertion);
    return huskyIdpAssertion;
  }

  private org.projecthusky.xua.saml2.Assertion getXuaAssertionFromResponse(
      List<XUserAssertionResponse> response) {
    RequestSecurityTokenResponse responseCollection = ((XUserAssertionResponseImpl) response.get(0)).getWrappedObject();

    // copied from XUserAssertionResponseImpl, husky-xua-gen-impl
    List<XMLObject> requestedTokens = responseCollection.getUnknownXMLObjects(new QName(
        "http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedSecurityToken"));
    if (!requestedTokens.isEmpty()) {
      RequestedSecurityToken token = (RequestedSecurityToken) requestedTokens.get(0);
      org.opensaml.saml.saml2.core.Assertion openSamlAssertion =
          (org.opensaml.saml.saml2.core.Assertion) token.getUnknownXMLObject();
      return convertSamlToHuskyAssertion(openSamlAssertion);
    }

    throw new RuntimeException("Received XUA assertion does not contain any requestSecurityTokens.");
  }

  private void setAssertion(org.projecthusky.xua.saml2.Assertion huskyIdpAssertion, org.opensaml.saml.saml2.core.Assertion assertion) {
    try {
      Field field = AssertionImpl.class.getDeclaredField("assertion");
      field.setAccessible(true);
      field.set(huskyIdpAssertion, assertion);
    } catch (Exception ex) {
      log.error("Converting opensaml assertion to husky assertion failed.", ex);
      throw new RuntimeException(ex);
    }
  }
}
