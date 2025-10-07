/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.xdsi;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.requests.RetrieveStudy;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.xua.core.SecurityHeaderElement;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * 
 */
@Builder
@Getter
@ToString
public class XdsiDocumentSetRequest {
	@NonNull
	private Destination destination;
	/** may be null for testing environments like the EPD Playground */
	private SecurityHeaderElement xuaToken;
	@Singular
	private List<RetrieveStudy> retrieveStudies;
	@Singular
	private List<String> transferSyntaxIds;

	public static class XdsiDocumentSetRequestBuilder {
	}
}
