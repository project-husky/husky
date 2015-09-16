package org.ehealth_connector.communication.xd.storedquery;

/**
 * Interface for convenience stored queries
 */
public interface StoredQueryInterface {

	/**
	 * Gets the OHT StoredQuery object, which is being wrapped by this class
	 *
	 * @return the OHT StoredQuery
	 */
	public org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery getOhtStoredQuery();
}
