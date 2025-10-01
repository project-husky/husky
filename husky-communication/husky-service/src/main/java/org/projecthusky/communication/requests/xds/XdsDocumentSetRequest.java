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

import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.DocumentRequest;
import org.projecthusky.xua.core.SecurityHeaderElement;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * A simple class to collect {@link DocumentRequest}s and use them to send to
 * the webservice. These requests will be answered by the service with
 * documents' contents.
 * 
 * @author szalai
 */
@Builder
@Getter
@ToString
public class XdsDocumentSetRequest  {
	@NonNull
	private Destination destination;
	/** may be null for testing environments like the EPD Playground */
	private SecurityHeaderElement xuaToken;
	@Singular
	private List<DocumentRequest> documentRequests;

	public static class XdsDocumentSetRequestBuilder {	}
}
