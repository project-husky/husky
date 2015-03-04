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
 * Attribution-ShareAlike 3.0 Switzerland License.
 * 
 * Year of publication: 2014
 * 
 *******************************************************************************/

package org.ehealth_connector.communication;

import java.net.URI;
import java.security.PrivateKey;

/**
 * The Class Destination.
 */
public class Destination {

	/**
	 * URI des Repository. Z.B. "urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b"
	 */
	private URI repositoryUri;

	/** URI for pix Source ITI-44. */
	private URI pixSourceUri; 

	/** URI for pix Query ITI-45. */
	private URI pixQueryUri; 

	/** The sender application oid for PIX/PDQ V3. */
	private String senderApplicationOid; 

	/** The sender facility oid for PIX/PDQ V3. */
	private String senderFacilityOid; 

	/** The receiver application oid for PIX/PDQ V3 */
	private String receiverApplicationOid; 

	/** The receiver facility oid  for PIX/PDQ V3 */
	private String receiverFacilityOid; 

	/**
	 * Privater X.509 Zertifikats-Schlüssel
	 */
	PrivateKey privateX509Key;

	/**
	 * ID des Empfängers der Nachricht. Z.B. 1.2.3.4.1789.10 bei
	 * "Princeton Hospital^^^^^^^^^1.2.3.4.1789.10"
	 */
	String intendedRecipientId;

	/**
	 * Name des Empfängers der Nachricht. Z.B. Princeton Hospital bei
	 * "Princeton Hospital^^^^^^^^^1.2.3.4.1789.10"
	 */
	String intendedRecipientName;

	/**
	 * Kommunikations-Endpunkt.
	 *
	 * @param repositoryUri URI des Kommunikations-Endpunkt
	 */
	public Destination(URI repositoryUri) {
		this(repositoryUri, null, null);
	}

	/**
	 * Kommunikations-Endpunkt (TLS).
	 *
	 * @param repositoryUri URI des Kommunikations-Endpunkt
	 * @param privateX509Key Privater X.509 Zertifikats-Schlüssel
	 */
	public Destination(URI repositoryUri, PrivateKey privateX509Key) {
		this(repositoryUri, null, null, privateX509Key);
	}

	/**
	 * Kommunikations-Endpunkt.
	 *
	 * @param repositoryUri URI des Kommunikations-Endpunkt
	 * @param intendedRecipientId Id des Empfängers
	 * @param intendedRecipientName Name des Empfängers
	 */
	public Destination(URI repositoryUri, String intendedRecipientId, String intendedRecipientName) {

	}

	/**
	 * Kommunikations-Endpunkt (TLS).
	 *
	 * @param repositoryUri URI des Kommunikations-Endpunkt
	 * @param intendedRecipientId Id des Empfängers
	 * @param intendedRecipientName Name des Empfängers
	 * @param privateX509Key Privater X.509 Zertifikats-Schlüssel
	 */
	public Destination(URI repositoryUri, String intendedRecipientId, String intendedRecipientName,
			PrivateKey privateX509Key) {

	}

	/**
	 * Liefert den Empfänger der Nachricht.
	 *
	 * @return das intendedRecipient Objekt
	 */
	public String getIntendedRecipientId() {
		return intendedRecipientId;
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
	 * Liefert den privaten X.509 Zertifikats-Schlüssel
	 * 
	 * @return das privateX509Key Objekt
	 */
	public PrivateKey getPrivateX509Key() {
		return privateX509Key;
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
	 * Gets the repository uri.
	 *
	 * @return the repository uri
	 */
	public URI getRepositoryUri() {
		return repositoryUri;
	}

	/**
	 * Liefert die URI des Kommunikations-Endpunkts.
	 *
	 * @return das repositoryUri Objekt
	 */
	public URI getResositoryUri() {
		return repositoryUri;
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
	 * Setzt den Empfänger der Nachricht.
	 *
	 * @param intendedRecipientId das intendedRecipientId Objekt welches gesetzt wird
	 */
	public void setIntendedRecipientId(String intendedRecipientId) {
		this.intendedRecipientId = intendedRecipientId;
	}

	/**
	 * Sets the pix query uri.
	 *
	 * @param pixQueryUri the new pix query uri
	 */
	public void setPixQueryUri(URI pixQueryUri) {
		this.pixQueryUri = pixQueryUri;
	}

	/**
	 * Sets the pix source uri.
	 *
	 * @param pixSourceUri the new pix source uri
	 */
	public void setPixSourceUri(URI pixSourceUri) {
		this.pixSourceUri = pixSourceUri;
	}

	/**
	 * Setzt den privaten X.509 Zertifikats-Schlüssel
	 * 
	 * @param privateX509Key das privateX509Key Objekt welches gesetzt wird
	 */
	public void setPrivateX509Key(PrivateKey privateX509Key) {
		this.privateX509Key = privateX509Key;
	}

	/**
	 * Sets the receiver application oid.
	 *
	 * @param receiverApplicationOid the new receiver application oid
	 */
	public void setReceiverApplicationOid(String receiverApplicationOid) {
		this.receiverApplicationOid = receiverApplicationOid;
	}

	/**
	 * Sets the receiver facility oid.
	 *
	 * @param receiverFacilityOid the new receiver facility oid
	 */
	public void setReceiverFacilityOid(String receiverFacilityOid) {
		this.receiverFacilityOid = receiverFacilityOid;
	}

	/**
	 * Sets the repository uri.
	 *
	 * @param repositoryUri the new repository uri
	 */
	public void setRepositoryUri(URI repositoryUri) {
		this.repositoryUri = repositoryUri;
	}

	/**
	 * Setzt die URI des Kommunikations-Endpunkts.
	 *
	 * @param repositoryUri das repositoryUri Objekt welches gesetzt wird
	 */
	public void setResositoryUri(URI repositoryUri) {
		this.repositoryUri = repositoryUri;
	}

	/**
	 * Sets the sender application oid.
	 *
	 * @param senderApplicationOid the new sender application oid
	 */
	public void setSenderApplicationOid(String senderApplicationOid) {
		this.senderApplicationOid = senderApplicationOid;
	}

	/**
	 * Sets the sender facility oid.
	 *
	 * @param senderFacilityOid the new sender facility oid
	 */
	public void setSenderFacilityOid(String senderFacilityOid) {
		this.senderFacilityOid = senderFacilityOid;
	}


}
