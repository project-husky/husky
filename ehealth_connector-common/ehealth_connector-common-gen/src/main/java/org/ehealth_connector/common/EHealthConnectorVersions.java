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

package org.ehealth_connector.common;

/**
 * Enum that contains the different Versions of the eHealtConnector
 *
 */
public enum EHealthConnectorVersions {
	/**
	 * OID: 2.16.756.5.30.1.139.1.1.1 eHealthConnector Proof of Concept
	 */
	EHealthConnectorR201402("2.16.756.5.30.1.139.1.1.1", "eHealthConnector Proof of Concept", "20140211"),

	/**
	 * OID: 2.16.756.5.30.1.139.1.1.2 eHealthConnector R201503
	 */
	EHealthConnectorR201503("2.16.756.5.30.1.139.1.1.2", "eHealthConnector R201503", "20150401"),

	/**
	 * OID: 2.16.756.5.30.1.139.1.1.3 eHealthConnector Rxxxxxx
	 */
	EHealthConnectorDev("2.16.756.5.30.1.139.1.1.3", "eHealthConnector trunk", "xxxxxxxx"),

	/**
	 * OID: 2.16.756.5.30.1.139.1.1.4 eHealthConnector R201510
	 */
	EHealthConnectorR201510("2.16.756.5.30.1.139.1.1.4", "eHealthConnector R201510", "R20151031"),

	/**
	 * OID: 2.16.756.5.30.1.139.1.1.5 eHealthConnector R201604
	 */
	EHealthConnectorR201604("2.16.756.5.30.1.139.1.1.5", "eHealthConnector R201604", "R20160430");
	
	/**
	 * OID: 2.16.756.5.30.1.139.1.1.6 eHealthConnector R201611
	 */
	EHealthConnectorR201611("2.16.756.5.30.1.139.1.1.6", "eHealthConnector R201611", "R201611xx");
	
	public static EHealthConnectorVersions getCurrentVersion() {
		return EHealthConnectorDev;
	}

	private String oid;
	private String systemVersionName;

	private String releaseDate;

	private EHealthConnectorVersions(String oid, String systemVersionName, String releaseDate) {
		this.oid = oid;
		this.systemVersionName = systemVersionName;
		this.releaseDate = releaseDate;
	}

	public String getOid() {
		return oid;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getSystemVersionName() {
		return systemVersionName;
	}

}
