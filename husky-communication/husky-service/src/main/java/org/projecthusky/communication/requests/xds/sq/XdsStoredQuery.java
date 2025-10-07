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
package org.projecthusky.communication.requests.xds.sq;

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
