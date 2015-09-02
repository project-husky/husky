package org.ehealth_connector.communication;

import org.openhealthtools.ihe.atna.auditor.XDSConsumerAuditor;
import org.openhealthtools.ihe.xds.consumer.B_Consumer;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery;
import org.openhealthtools.ihe.xds.response.XDSQueryResponseType;

public class DocumentConsumer {
	private B_Consumer consumer;

	/**
	 * Instantiates a new convenience communication.
	 * 
	 * @param dest
	 *            the destination
	 * @param auditorEnabled
	 *            sets whether the ATNA audit is enable (secure) or disabled
	 *            (unsecure)
	 * @throws Exception
	 *             the exception
	 */
	public DocumentConsumer(Destination dest, boolean auditorEnabled)
			throws Exception {
		//txnData = new SubmitTransactionData();
		setDestination(dest);

		//c = new Consumer(registryURI);
		XDSConsumerAuditor.getAuditor().getConfig().setAuditorEnabled(auditorEnabled);
	}

	/**
	 * Sets the destination
	 * 
	 * @param dest
	 *            the destination
	 */
	public void setDestination(Destination dest) {
		dest.getSenderOrganizationalOid();
		consumer = new B_Consumer(dest.getRegistryUri());

		if (dest.getKeyStore() == null) {
			System.clearProperty("javax.net.ssl.keyStore");
			System.clearProperty("javax.net.ssl.keyStorePassword");
			System.clearProperty("javax.net.ssl.trustStore");
			System.clearProperty("javax.net.ssl.trustStorePassword");
		} else {
			System.setProperty("javax.net.ssl.keyStore", dest.getKeyStore());
			System.setProperty("javax.net.ssl.keyStorePassword",
					dest.getKeyStorePassword());
			System.setProperty("javax.net.ssl.trustStore", dest.getTrustStore());
			System.setProperty("javax.net.ssl.trustStorePassword",
					dest.getTrustStorePassword());
		}
	}
	
	public XDSQueryResponseType invokeStoredQuery(StoredQuery q, boolean returnReferencesOnly) throws Exception {
		return consumer.invokeStoredQuery(q, returnReferencesOnly);
	}
}
