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

package org.ehealth_connector.communication;

import java.net.URI;

/**
 * The Class Destination. Describes an Endpoint for a transmission or
 * communication.
 */
public class Destination {

	/**
	 * <div class="en">The key store for TLS</div>
	 */
	private String keyStore = null;

	/**
	 * <div class="en">The key store password for TLS</div>
	 */
	private String keyStorePassword;

	/**
	 * <div class="en">The receiver application oid</div>
	 */
	private String receiverApplicationOid;

	/**
	 * <div class="en">The receiver facility oid</div>
	 */
	private String receiverFacilityOid;

	/**
	 * <div class="en">The senders application oid</div>
	 */
	private String senderApplicationOid;

	/**
	 * <div class="en">The sender facility oid</div>
	 */
	private String senderFacilityOid;

	/**
	 * <div class="en">The sender organizational oid</div>
	 */
	private String senderOrganizationalOid;

	/**
	 * <div class="en">The trust store for TLS</div>
	 */
	private String trustStore;

	/**
	 * <div class="en">The trust store password for TLS</div>
	 */
	private String trustStorePassword;

	/**
	 * URI for the destination
	 */
	private URI uri;

	/**
	 * <div class="en">Communication Endpoint for any transaction.</div>
	 */
	public Destination() {
	}

	/**
	 * Communication Endpoint for an unsecured transaction.
	 * 
	 * @param senderOrganizationalOid
	 *            Oid of the Sender Organization
	 * @param uri
	 *            URI of the communication endpoint
	 */
	public Destination(String senderOrganizationalOid, URI uri) {
		this.uri = uri;
		this.senderOrganizationalOid = senderOrganizationalOid;
	}

	/**
	 * Communication Endpoint for a TLS-secured transaction with a single
	 * keystore that combines keystore and truststore.
	 * 
	 * @param senderOrganizationalOid
	 *            Your OID
	 * @param uri
	 *            URI of the communication endpoint
	 * @param keyStore
	 *            path to the keystore file
	 * @param keyStorePassword
	 *            the password for the keystore file
	 */
	public Destination(String senderOrganizationalOid, URI uri, String keyStore,
			String keyStorePassword) {
		this(senderOrganizationalOid, uri);
		setKeyStore(keyStore, keyStorePassword);
	}

	/**
	 * Communication Endpoint for a TLS-secured transaction with a seperate
	 * keystore and truststore.
	 * 
	 * 
	 * @param senderOrganizationalOid
	 *            Your OID
	 * @param uri
	 *            URI of the communication endpoint
	 * @param keyStore
	 *            path to the keystore file
	 * @param keyStorePassword
	 *            the password for the keystore file
	 * @param trustStore
	 *            path to the truststore file
	 * @param trustStorePassword
	 *            the password for the truststore file
	 */
	public Destination(String senderOrganizationalOid, URI uri, String keyStore,
			String keyStorePassword, String trustStore, String trustStorePassword) {
		this(senderOrganizationalOid, uri);
		this.keyStore = keyStore;
		this.keyStorePassword = keyStorePassword;
		this.trustStore = trustStore;
		this.trustStorePassword = trustStorePassword;
	}

	/**
	 * Gets the path to the keystore
	 * 
	 * @return path to the keystore as string
	 */
	public String getKeyStore() {
		return keyStore;
	}

	/**
	 * Gets the passoword for the keystore
	 * 
	 * @return password of the keystore
	 */
	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	/**
	 * Gets the receiver application oid.
	 * 
	 * @return the receiver application oid
	 */
	public String getReceiverApplicationOid() {
		return receiverApplicationOid;
	}

	/**
	 * Gets the receiver facility oid.
	 * 
	 * @return the receiver facility oid
	 */
	public String getReceiverFacilityOid() {
		return receiverFacilityOid;
	}

	/**
	 * Gets the sender application oid.
	 * 
	 * @return the sender application oid
	 */
	public String getSenderApplicationOid() {
		return senderApplicationOid;
	}

	/**
	 * Gets the sender facility oid.
	 * 
	 * @return the sender facility oid
	 */
	public String getSenderFacilityOid() {
		return senderFacilityOid;
	}

	/**
	 * Gets the sender Organizational OID
	 * 
	 * @return sender Organizational OID
	 */
	public String getSenderOrganizationalOid() {
		return senderOrganizationalOid;
	}

	/**
	 * Gets the path to the truststore
	 * 
	 * @return path to the trust store as string
	 */
	public String getTrustStore() {
		return trustStore;
	}

	/**
	 * Gets the password for the trust store
	 * 
	 * @return password for the trust store as string
	 */
	public String getTrustStorePassword() {
		return trustStorePassword;
	}

	public URI getUri() {
		return uri;
	}

	/**
	 * Sets the path to the key store
	 * 
	 * @param keyStore
	 *            path
	 */
	public void setKeyStore(String keyStore) {
		this.keyStore = keyStore;
	}

	/**
	 * Sets the password for the key store
	 * 
	 * @param keyStorePassword
	 *            the password for your keystore
	 */
	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	/**
	 * Sets the receiver application oid.
	 * 
	 * @param receiverApplicationOid
	 *            the new receiver application oid
	 */
	public void setReceiverApplicationOid(String receiverApplicationOid) {
		this.receiverApplicationOid = receiverApplicationOid;
	}

	/**
	 * Sets the receiver facility oid.
	 * 
	 * @param receiverFacilityOid
	 *            the new receiver facility oid
	 */
	public void setReceiverFacilityOid(String receiverFacilityOid) {
		this.receiverFacilityOid = receiverFacilityOid;
	}

	/**
	 * Sets the sender application oid.
	 * 
	 * @param senderApplicationOid
	 *            the new sender application oid
	 */
	public void setSenderApplicationOid(String senderApplicationOid) {
		this.senderApplicationOid = senderApplicationOid;
	}

	/**
	 * Sets the sender facility oid.
	 * 
	 * @param senderFacilityOid
	 *            the new sender facility oid
	 */
	public void setSenderFacilityOid(String senderFacilityOid) {
		this.senderFacilityOid = senderFacilityOid;
	}

	public void setSenderOrganizationalOid(String senderOrganizationalOid) {
		this.senderOrganizationalOid = senderOrganizationalOid;
	}

	public void setTrustStore(String trustStore) {
		this.trustStore = trustStore;
	}

	/**
	 * <div class="en">Sets the trust store password.</div> <div
	 * class="de">Setzt trust store password.</div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * 
	 * @param trustStorePassword
	 *            <div class="en">the new trust store password</div> <div
	 *            class="de">das neue trust store password.</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	/**
	 * <div class="en">Sets the key store for TLS communication
	 * 
	 * @param keyStore
	 * @param keyStorePassword
	 *            </div>
	 */
	private void setKeyStore(String keyStore, String keyStorePassword) {
		this.keyStore = keyStore;
		this.keyStorePassword = keyStorePassword;
		trustStore = keyStore;
		trustStorePassword = keyStorePassword;

		if (keyStore != null) {
			System.setProperty("javax.net.ssl.keyStore", keyStore);
			System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
			System.setProperty("javax.net.ssl.trustStore", trustStore);
			System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
		}
	}

}
