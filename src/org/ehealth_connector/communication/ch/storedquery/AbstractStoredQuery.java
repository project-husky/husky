package org.ehealth_connector.communication.ch.storedquery;

public abstract class AbstractStoredQuery implements StoredQueryInterface {
	protected org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery ohtStoredQuery = null;
	
	public org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery getOhtStoredQuery() {
		return ohtStoredQuery;
	}
}
