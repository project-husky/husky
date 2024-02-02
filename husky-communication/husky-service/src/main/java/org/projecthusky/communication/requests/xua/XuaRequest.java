/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.requests.xua;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.projecthusky.xua.communication.xua.AppliesTo;
import org.projecthusky.xua.communication.xua.RequestType;
import org.projecthusky.xua.communication.xua.TokenType;
import org.projecthusky.xua.communication.xua.XUserAssertionRequest;
import org.projecthusky.xua.communication.xua.impl.ch.XUserAssertionRequestBuilderChImpl;
import org.projecthusky.xua.hl7v3.CE;
import org.projecthusky.xua.saml2.Assertion;

@Getter
@Builder
@ToString
public class XuaRequest {
  /**
   * The URL of the community endpoint the XUA assertion shall be used for authorization,
   * whose value is set in the Address child element
   */
  private AppliesTo appliesTo;
  private String context;
  private String dialect;
  /**
   * Conveying the purpose of use of the request, which must be taken from the EPR
   * value set defined in Annex 3 of the ordinances of the Swiss electronic patient dossier
   */
  private CE purposeOfUse;
  /** Conveying the EPR role of the user, which must be taken from the EPR value set defined in Annex 3. */
  private CE subjectRole;
  private String resourceId;
  private RequestType requestType;
  private TokenType tokenType;
  @NotBlank
  private String principalId;
  @NotBlank
  private String principalName;
  @NotNull
  private Assertion idpAssertion;
  /** Configuration fields used for creating the SimpleXuaClient used for sending the XUARequest */
  @NotBlank
  private String repositoryUri;
  @NotBlank
  private String clientKeyStoreType;
  @NotBlank
  private String clientKeyStore;
  @NotBlank
  private String clientKeyStorePass;

  public XUserAssertionRequest build() {
    return createXUserAssertionRequest();
  }

  private XUserAssertionRequest createXUserAssertionRequest() {
    XUserAssertionRequestBuilderChImpl chImpl = new XUserAssertionRequestBuilderChImpl();
    chImpl.principal(principalId, principalName);

    return chImpl.requestType(requestType)
        .tokenType(tokenType)
        .purposeOfUse(purposeOfUse)
        .appliesTo(appliesTo)
        .subjectRole(subjectRole)
        .resourceId(resourceId).create();
  }
}
