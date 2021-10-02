/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.communication.xd.storedquery;

import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;

/**
 * Represents a convenience stored query object
 *
 */
public abstract class AbstractStoredQuery implements StoredQueryInterface {
	/**
	 * The IPF Stored Query Object
	 */
	private StoredQuery ipfStoredQuery;

	/**
	 * Gets the IPF StoredQuery object, which is being wrapped by this class
	 *
	 * @return the IPF StoredQuery
	 */
	@Override
	public StoredQuery getIpfQuery() {
		return ipfStoredQuery;
	}

	/**
	 * Method to set
	 *
	 * @param ipfStoredQuery the ipfStoredQuery to set
	 */
	public void setIpfStoredQuery(
			StoredQuery ipfStoredQuery) {
		this.ipfStoredQuery = ipfStoredQuery;
	}
}
