/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.rmu;

import org.projecthusky.communication.requests.xds.AbstractXdsDocumentSetRequest;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**	
 * 
 */
@SuperBuilder
@Getter
@ToString
public class RestrictedMetadataUpdateRequest extends AbstractXdsDocumentSetRequest {

}
