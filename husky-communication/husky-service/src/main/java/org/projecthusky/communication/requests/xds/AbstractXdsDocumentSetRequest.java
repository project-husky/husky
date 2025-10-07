/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.xds;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.communication.SubmissionSetMetadata;
import org.projecthusky.xua.core.SecurityHeaderElement;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 
 */
@SuperBuilder
@Getter
@ToString
public class AbstractXdsDocumentSetRequest {
	@NonNull
	private Destination destination;

	/** may be null for testing environments like the EPD Playground */
	private SecurityHeaderElement xuaToken;

	@Singular("documentWithMetadata")
	private List<XdsDocumentWithMetadata> documentWithMetadata;

	@NotNull
	private SubmissionSetMetadata submissionSetMetadata;
	
}
