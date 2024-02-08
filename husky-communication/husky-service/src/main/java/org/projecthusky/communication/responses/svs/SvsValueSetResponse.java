/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.responses.svs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.projecthusky.valueset.model.ValueSet;

/** Response class that contains both formats of the response marshalled in a ValueSet object
 * and raw dformat exactly as downloaded
 * ValueSetResponse will contain only one format at a time
 */

@Getter
@Builder
@ToString
public class SvsValueSetResponse {

  private ValueSet valueSet;
  private byte[] valueSetRaw;
}
