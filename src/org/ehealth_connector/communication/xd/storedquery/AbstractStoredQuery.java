package org.ehealth_connector.communication.xd.storedquery;

/**
 * Represents a convenience stored query object
 * 
 */
public abstract class AbstractStoredQuery implements StoredQueryInterface {
	/**
	 * The OHT Stored Query Object
	 */
	protected org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery ohtStoredQuery = null;

	/**
	 * Gets the OHT StoredQuery object, which is being wrapped by this class
	 * 
	 * @return the OHT StoredQuery
	 */
	@Override
	public org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery getOhtStoredQuery() {
		return ohtStoredQuery;
	}
}
