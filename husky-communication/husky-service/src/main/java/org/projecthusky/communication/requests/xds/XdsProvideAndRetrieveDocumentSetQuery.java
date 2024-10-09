/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.requests.xds;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.communication.SubmissionSetMetadata;
import org.projecthusky.xua.core.SecurityHeaderElement;

@Getter
@Builder
@ToString
public class XdsProvideAndRetrieveDocumentSetQuery {
  @Singular("documentWithMetadata")
  private List<XdsDocumentWithMetadata> documentWithMetadata;
  @NotNull
  private SubmissionSetMetadata submissionSetMetadata;
  @NotNull
  private SecurityHeaderElement xuaToken;
  @NotNull
  private Destination destination;
  /** If the Association field is not null the ProvideAndRetrieveDocumentSetQuery will be a replacement of an already existing document */
  private Association association;

  public static class XdsProvideAndRetrieveDocumentSetQueryBuilder {};
}
