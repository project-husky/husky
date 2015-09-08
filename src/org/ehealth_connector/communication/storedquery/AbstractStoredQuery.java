package org.ehealth_connector.communication.storedquery;

/**
 * Represents a convenience stored query object
 *
 */
public abstract class AbstractStoredQuery implements StoredQueryInterface {
	/**
	 * The OHT Stored Query Object
	 */
	protected org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery ohtStoredQuery = null;

	/*
	 * Gets the OHT StoredQuery object, which is being wrapped by this class
	 * 
	 * @see
	 * org.ehealth_connector.communication.storedquery.StoredQueryInterface#
	 * getOhtStoredQuery()
	 * 
	 * @returns the OHT StoredQuery
	 */
	@Override
	public org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery getOhtStoredQuery() {
		return ohtStoredQuery;
	}
}
