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

import java.io.InputStream;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.projecthusky.common.communication.DocumentMetadata;
import org.projecthusky.common.enums.DocumentDescriptor;

@Getter
@Builder
@ToString
public class XdsDocumentWithMetadata {
  @NotNull
  private DocumentMetadata documentMetadata;
  /** Actual document that will be submitted */
  @NotBlank
  private InputStream dataStream;
  @NotNull
  private DocumentDescriptor documentDescriptor;

}
