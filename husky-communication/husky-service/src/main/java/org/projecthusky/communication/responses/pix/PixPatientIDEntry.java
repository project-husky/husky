/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.responses.pix;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 */
@Getter
@Builder
public class PixPatientIDEntry {
	private String id;
	private String name;
	private String oid;
}
