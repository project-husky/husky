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

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 	
 */
@SuperBuilder
@Getter
@ToString
public class XdsUpdateDocumentSetRequest extends AbstractXdsDocumentSetRequest {

	public static abstract class XdsUpdateDocumentSetRequestBuilder<C extends XdsUpdateDocumentSetRequest, B extends XdsUpdateDocumentSetRequest.XdsUpdateDocumentSetRequestBuilder<C, B>>
			extends AbstractXdsDocumentSetRequest.AbstractXdsDocumentSetRequestBuilder<C, B> {
	}
}
