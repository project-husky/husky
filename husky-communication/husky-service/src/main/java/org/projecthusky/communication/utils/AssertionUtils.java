package org.projecthusky.communication.utils;

import java.lang.reflect.Field;
import java.util.List;
import javax.xml.namespace.QName;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.RequestedSecurityToken;
import org.projecthusky.xua.communication.xua.XUserAssertionResponse;
import org.projecthusky.xua.communication.xua.impl.XUserAssertionResponseImpl;
import org.projecthusky.xua.saml2.Assertion;
import org.projecthusky.xua.saml2.impl.AssertionBuilderImpl;
import org.projecthusky.xua.saml2.impl.AssertionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssertionUtils {

  private static final Logger log = LoggerFactory.getLogger(AssertionUtils.class);

  public static org.projecthusky.xua.saml2.Assertion getXuaAssertionFromResponse(List<XUserAssertionResponse> response) {
    RequestSecurityTokenResponse responseCollection = ((XUserAssertionResponseImpl) response.get(0)).getWrappedObject();

    // copied from XUserAssertionResponseImpl, husky-xua-gen-impl
    List<XMLObject> requestedTokens = responseCollection.getUnknownXMLObjects(new QName(
        "http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedSecurityToken"));
    if (!requestedTokens.isEmpty()) {
      RequestedSecurityToken token = (RequestedSecurityToken) requestedTokens.get(0);
      org.opensaml.saml.saml2.core.Assertion openSamlAssertion =
          (org.opensaml.saml.saml2.core.Assertion) token.getUnknownXMLObject();
      org.projecthusky.xua.saml2.Assertion xua = convertSamlToHuskyAssertion(openSamlAssertion);
      return xua;
    }

    throw new IllegalArgumentException("Received XUA assertion does not contain any requestSecurityTokens.");
  }

  public static org.projecthusky.xua.saml2.Assertion convertSamlToHuskyAssertion(
      org.opensaml.saml.saml2.core.Assertion assertion) {
    org.projecthusky.xua.saml2.Assertion huskyIdpAssertion = new AssertionBuilderImpl().create();
    setAssertion(huskyIdpAssertion, assertion);
    return huskyIdpAssertion;
  }

  private static void setAssertion(Assertion huskyIdpAssertion, org.opensaml.saml.saml2.core.Assertion assertion) {
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
