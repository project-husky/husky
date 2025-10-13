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
package org.projecthusky.communication.responses.pix;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

/**
 * High level result class that contains the IDs asked for with a
 * {@link PixPatientIDQuery}.
 * 
 * @author szalai
 */
@Getter
@Builder
public class PixPatientIDResult {
	/** List of patient IDs that were found. */
	@Singular
	private List<String> patientIDs;

	/** List of ID entries that were found. */
	@Singular
	private List<PixPatientIDEntry> idEntries;

	private String queryResponseCode;

	private String acknowledgementTypeCode;
	
	private String errorText;
}
