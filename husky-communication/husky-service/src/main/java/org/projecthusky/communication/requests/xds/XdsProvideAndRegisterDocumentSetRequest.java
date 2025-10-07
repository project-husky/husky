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

import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * A simple class to collect {@link XdsDocumentWithMetadata}s and use them to
 * send to the webservice. These requests will be answered by the service with
 * documents' contents.
 * 
 * @author szalai
 */
@SuperBuilder
@Getter
@ToString
public class XdsProvideAndRegisterDocumentSetRequest extends AbstractXdsDocumentSetRequest {

	/**
	 * If the Association field is not null the
	 * XdsProvideAndRegisterDocumentSetRequest will be a replacement of an already
	 * existing document
	 */
	private Association association;

	public static abstract class XdsProvideAndRegisterDocumentSetRequestBuilder<C extends XdsProvideAndRegisterDocumentSetRequest, B extends XdsProvideAndRegisterDocumentSetRequest.XdsProvideAndRegisterDocumentSetRequestBuilder<C, B>>
			extends AbstractXdsDocumentSetRequest.AbstractXdsDocumentSetRequestBuilder<C, B> {
	}
}
