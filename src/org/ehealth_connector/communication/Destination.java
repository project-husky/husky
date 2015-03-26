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
 * The Class Destination. Describes an Endpoint for a transmission or communication.
 */
/**
 * @author ahel
 *
 */
public class Destination {

	/**
	 * URI for the XDS Registry
	 */
	private URI registryUri;

	private String senderOrganizationalOid;

	private String keyStore = null;
	private String keyStorePassword;
	private String trustStore;
	private String trustStorePassword;
	/** URI for pix Source ITI-44. */
	private URI pixSourceUri;

	/** URI for pix Query ITI-45. */
	private URI pixQueryUri;

	/** The sender application oid for PIX/PDQ V3. */
	private String senderApplicationOid;

	/** The sender facility oid for PIX/PDQ V3 and XDS */
	private String senderFacilityOid;

	/** The receiver application oid for PIX/PDQ V3 */
	private String receiverApplicationOid;

	/** The receiver facility oid for PIX/PDQ V3 */
	private String receiverFacilityOid;

	public Destination() {

	}

	/**
	 * Communication Endpoint for an unsecured XDS-b transaction.
	 *
	 * @param senderOrganizationalOid
	 *            Oid of the Sender Organization
	 * @param repositoryUri
	 *            URI of the communication endpoint
	 */
	public Destination(String senderOrganizationalOid, URI repositoryUri) {
		registryUri = repositoryUri;
		this.senderOrganizationalOid = senderOrganizationalOid;
	}

	/**
	 * Communication Endpoint for a TLS-secured XDS-b transaction with a single
	 * keystore that combines keystore and truststore.
	 *
	 * @param repositoryUri
	 *            URI of the communication endpoint
	 * @param keyStore
	 *            path to the keystore file
	 * @param keyStorePassword
	 *            the password for the keystore file
	 */
	public Destination(String senderOrganizationalOid, URI repositoryUri,
			String keyStore, String keyStorePassword) {
		this(senderOrganizationalOid, repositoryUri);
		this.keyStore = keyStore;
		this.keyStorePassword = keyStorePassword;
		trustStore = keyStore;
		trustStorePassword = keyStorePassword;
	}

	/**
	 * Communication Endpoint for a TLS-secured XDS-b transaction with a
	 * seperate keystore and truststore.
	 *
	 * @param repositoryUri
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
	public Destination(String senderOrganizationalOid, URI repositoryUri,
			String keyStore, String keyStorePassword, String trustStore,
			String trustStorePassword) {
		this(senderOrganizationalOid, repositoryUri);
		this.keyStore = keyStore;
		this.keyStorePassword = keyStorePassword;
		this.trustStore = trustStore;
		this.trustStorePassword = trustStorePassword;
	}

	/**
	 * Gets the path to the keystore
	 * @return path to the keystore as string
	 */
	public String getKeyStore() {
		return keyStore;
	}

	/**
	 * Gets the passoword for the keystore
	 * @return password of the keystore
	 */
	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	/**
	 * Gets the pix query uri.
	 *
	 * @return the pix query uri
	 */
	public URI getPixQueryUri() {
		return pixQueryUri;
	}

	/**
	 * Gets the pix source uri.
	 *
	 * @return the pix source uri
	 */
	public URI getPixSourceUri() {
		return pixSourceUri;
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

	public URI getRegistryUri() {
		return registryUri;
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
	 * Sets the path to the key store
	 * 
	 * @param keyStore path
	 */
	public void setKeyStore(String keyStore) {
		this.keyStore = keyStore;
	}

	/**
	 * Sets the password for the key store
	 * 
	 * @param keyStorePassword
	 */
	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	/**
	 * Sets the pix query uri.
	 *
	 * @param pixQueryUri
	 *            the new pix query uri
	 */
	public void setPixQueryUri(URI pixQueryUri) {
		this.pixQueryUri = pixQueryUri;
	}

	/**
	 * Sets the pix source uri.
	 *
	 * @param pixSourceUri
	 *            the new pix source uri
	 */
	public void setPixSourceUri(URI pixSourceUri) {
		this.pixSourceUri = pixSourceUri;
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

	public void setRegistryUri(URI registryUri) {
		this.registryUri = registryUri;
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

}
