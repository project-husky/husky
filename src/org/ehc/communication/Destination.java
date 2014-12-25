/*******************************************************************************
*
* The authorship of this code and the accompanying materials is held by
* medshare GmbH, Switzerland. All rights reserved.
* http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the
* Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the
* Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
*
* Year of publication: 2014
*
*******************************************************************************/

package org.ehc.communication;

import java.net.URI;
import java.security.PrivateKey;

public class Destination {

	/**
	 * URI des Repository. Z.B. "urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b"
	 */
	URI resositoryUri;

	/**
	 * Privater X.509 Zertifikats-Schlüssel
	 */
	PrivateKey privateX509Key;

	//
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
	 * Kommunikations-Endpunkt
	 * 
	 * @param resositoryUri
	 *          URI des Kommunikations-Endpunkt
	 * @param intendedRecipientId
	 *          Id des Empfängers
	 * @param intendedRecipientName
	 *          Name des Empfängers
	 */
	public Destination(URI resositoryUri, String intendedRecipientId,
			String intendedRecipientName) {

	}

	/**
	 * Kommunikations-Endpunkt (TLS)
	 * 
	 * @param resositoryUri
	 *          URI des Kommunikations-Endpunkt
	 * @param intendedRecipientId
	 *          Id des Empfängers
	 * @param intendedRecipientName
	 *          Name des Empfängers
	 * @param privateX509Key
	 *          Privater X.509 Zertifikats-Schlüssel
	 */
	public Destination(URI resositoryUri, String intendedRecipientId,
			String intendedRecipientName, PrivateKey privateX509Key) {

	}

	/**
	 * Liefert die URI des Kommunikations-Endpunkts
	 * 
	 * @return das resositoryUri Objekt
	 */
	public URI getResositoryUri() {
		return resositoryUri;
	}

	/**
	 * Setzt die URI des Kommunikations-Endpunkts
	 * 
	 * @param resositoryUri
	 *          das resositoryUri Objekt welches gesetzt wird
	 */
	public void setResositoryUri(URI resositoryUri) {
		this.resositoryUri = resositoryUri;
	}

	/**
	 * Liefert den Empfänger der Nachricht
	 * 
	 * @return das intendedRecipient Objekt
	 */
	public String getIntendedRecipientId() {
		return intendedRecipientId;
	}

	/**
	 * Setzt den Empfänger der Nachricht
	 * 
	 * @param intendedRecipientId
	 *          das intendedRecipientId Objekt welches gesetzt wird
	 */
	public void setIntendedRecipientId(String intendedRecipientId) {
		this.intendedRecipientId = intendedRecipientId;
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
	 * Setzt den privaten X.509 Zertifikats-Schlüssel
	 * 
	 * @param privateX509Key
	 *          das privateX509Key Objekt welches gesetzt wird
	 */
	public void setPrivateX509Key(PrivateKey privateX509Key) {
		this.privateX509Key = privateX509Key;
	}

}
