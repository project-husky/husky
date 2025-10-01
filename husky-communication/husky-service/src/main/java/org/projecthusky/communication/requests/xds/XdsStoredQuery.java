/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.xds;

import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.xua.core.SecurityHeaderElement;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This is the abstract base class for all stored query requests. It contains
 * common parameters like destination, homeCommunityId and metadataLevel.
 * Subclasses must implement the getIpfQuery() method to return the specific
 * StoredQuery instance for that query type.
 */
@SuperBuilder
@Getter
@ToString
public abstract class XdsStoredQuery {
	@NonNull
	private Destination destination;
	/** may be null for testing environments like the EPD Playground */
	private SecurityHeaderElement xuaToken;
	/** homeCommunityId */
	private String homeCommunityId;
	/** metadataLevel */
	private Integer metadataLevel;

	public XdsStoredQuery(Destination destination, SecurityHeaderElement xuaToken) {
		this.destination = destination;
		this.xuaToken = xuaToken;
	}

	public abstract StoredQuery getIpfQuery();

}
