/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
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
