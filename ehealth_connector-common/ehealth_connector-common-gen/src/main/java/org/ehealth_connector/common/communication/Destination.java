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

package org.ehealth_connector.common.communication;

import java.net.URI;

/**
 * The Class Destination. Describes an Endpoint for a transmission or
 * communication.
 */
public class Destination {

	/**
	 * <div class="en">The key store for TLS</div>
	 */
	private String keyStore;

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
	 * <div class="en">URI for the destination</div>
	 */
	private URI uri;

	/**
	 * <div class="en">The key store type</div>
	 */
	private String keyStoreType;

	/**
	 * <div class="en">The trust store type</div>
	 */
	private String trustStoreType;

	/**
	 * <div class="en">Communication Endpoint for any transaction.</div>
	 */
	public Destination() {
		keyStoreType = "jks";
		trustStoreType = "jks";
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
		keyStoreType = "jks";
		trustStoreType = "jks";
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
		this.keyStore = keyStore;
		this.keyStorePassword = keyStorePassword;
		this.trustStore = keyStore;
		this.trustStorePassword = keyStorePassword;
		setKeyStore();
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
	 * @param keyStoreType
	 *            the type of the truststore file (default: jks)
	 */
	public Destination(String senderOrganizationalOid, URI uri, String keyStore,
			String keyStorePassword, String keyStoreType) {
		this(senderOrganizationalOid, uri);
		this.keyStore = keyStore;
		this.keyStorePassword = keyStorePassword;
		this.keyStoreType = keyStoreType;
		this.trustStore = keyStore;
		this.trustStorePassword = keyStorePassword;
		this.trustStoreType = keyStoreType;
		setKeyStore();
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
		setKeyStore();
	}

	/**
	 * Communication Endpoint for a TLS-secured transaction with a seperate
	 * keystore and truststore.
	 *
	 * @param senderOrganizationalOid
	 *            Your OID
	 * @param uri
	 *            URI of the communication endpoint
	 * @param keyStore
	 *            path to the keystore file
	 * @param keyStorePassword
	 *            the password for the keystore file
	 * @param keyStoreType
	 *            the type of the keystore file (default: jks)
	 * @param trustStore
	 *            path to the truststore file
	 * @param trustStorePassword
	 *            the password for the truststore file
	 * @param trustStoreType
	 *            the type of the truststore file (default: jks)
	 */
	public Destination(String senderOrganizationalOid, URI uri, String keyStore,
			String keyStorePassword, String keyStoreType, String trustStore,
			String trustStorePassword, String trustStoreType) {
		this(senderOrganizationalOid, uri);
		this.keyStore = keyStore;
		this.keyStorePassword = keyStorePassword;
		this.keyStoreType = keyStoreType;
		this.trustStore = trustStore;
		this.trustStorePassword = trustStorePassword;
		this.trustStoreType = trustStoreType;
		setKeyStore();
	}

	@Override
	public Destination clone() throws CloneNotSupportedException {
		final Destination clone = new Destination();
		clone.keyStore = this.keyStore;
		clone.keyStorePassword = this.keyStorePassword;
		clone.keyStoreType = this.keyStoreType;
		clone.receiverApplicationOid = this.receiverApplicationOid;
		clone.receiverFacilityOid = this.receiverFacilityOid;
		clone.senderApplicationOid = this.senderApplicationOid;
		clone.senderFacilityOid = this.senderFacilityOid;
		clone.senderOrganizationalOid = this.senderOrganizationalOid;
		clone.trustStore = this.trustStore;
		clone.trustStorePassword = this.trustStorePassword;
		clone.trustStoreType = this.trustStoreType;
		clone.uri = this.uri;
		return clone;
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
	 * Method to get
	 *
	 * @return the keyStoreType
	 */
	public String getKeyStoreType() {
		return keyStoreType;
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

	/**
	 * Method to get
	 *
	 * @return the trustStoreType
	 */
	public String getTrustStoreType() {
		return trustStoreType;
	}

	public URI getUri() {
		return uri;
	}

	/**
	 * <div class="en">Sets the key and trust store for TLS communication</div>
	 */
	private void setKeyStore() {

		if (keyStore != null) {
			System.setProperty("javax.net.ssl.keyStore", keyStore);
			System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
			System.setProperty("javax.net.ssl.keyStoreType", keyStoreType);
			System.setProperty("javax.net.ssl.trustStore", trustStore);
			System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
			System.setProperty("javax.net.ssl.trustStoreType", trustStoreType);
		}
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
	 * Method to set
	 *
	 * @param keyStoreType
	 *            the keyStoreType to set
	 */
	public void setKeyStoreType(String keyStoreType) {
		this.keyStoreType = keyStoreType;
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
	 * <div class="en">Sets the trust store password.</div>
	 * <div class="de">Setzt trust store password.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @param trustStorePassword
	 *            <div class="en">the new trust store password</div>
	 *            <div class="de">das neue trust store password.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}

	/**
	 * Method to set
	 *
	 * @param trustStoreType
	 *            the trustStoreType to set
	 */
	public void setTrustStoreType(String trustStoreType) {
		this.trustStoreType = trustStoreType;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

}
