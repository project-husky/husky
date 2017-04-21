/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

/**
 * Represents a convenience stored query object
 *
 */
public abstract class AbstractStoredQuery implements StoredQueryInterface {
	/**
	 * The OHT Stored Query Object
	 */
	private org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery ohtStoredQuery;

	/**
	 * Gets the OHT StoredQuery object, which is being wrapped by this class
	 *
	 * @return the OHT StoredQuery
	 */
	@Override
	public org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery getOhtStoredQuery() {
		return ohtStoredQuery;
	}

	/**
	 * Method to set
	 *
	 * @param ohtStoredQuery
	 *            the ohtStoredQuery to set
	 */
	public void setOhtStoredQuery(
			org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery ohtStoredQuery) {
		this.ohtStoredQuery = ohtStoredQuery;
	}
}
