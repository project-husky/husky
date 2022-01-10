/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.common.enums;

/**
 * Enum that contains the different Versions of the eHealtConnector and husky
 *
 */
public enum EhcVersions {
	/**
	 * OID husky development edition (trunk)
	 */
	HUSKY_DEV("2.16.756.5.30.1.139.1.1.3", "husky trunk", "xxxxxxxx"),

	/**
	 * OID eHealthConnector Proof of Concept
	 */
	EHEALTH_CONNECTOR_R201402("2.16.756.5.30.1.139.1.1.1", "eHealthConnector Proof of Concept",
			"20140211"),

	/**
	 * OID eHealthConnector R201503
	 */
	EHEALTH_CONNECTOR_R201503("2.16.756.5.30.1.139.1.1.2", "eHealthConnector R201503", "2015-04-01"),

	/**
	 * OID eHealthConnector R201510
	 */
	EHEALTH_CONNECTOR_R201510("2.16.756.5.30.1.139.1.1.4", "eHealthConnector R201510", "2015-10-31"),

	/**
	 * OID eHealthConnector R201604
	 */
	EHEALTH_CONNECTOR_R201604("2.16.756.5.30.1.139.1.1.5", "eHealthConnector R201604", "2016-04-30"),

	/**
	 * OID eHealthConnector R201704
	 */
	EHEALTH_CONNECTOR_R201704("2.16.756.5.30.1.139.1.1.6", "eHealthConnector R201704", "2017-04-30"),

	/**
	 * OID eHealthConnector R201711
	 */
	EHEALTH_CONNECTOR_R201711("2.16.756.5.30.1.139.1.1.7", "eHealthConnector R201711", "2017-11-30"),

	/**
	 * OID eHealthConnector R201807
	 */
	EHEALTH_CONNECTOR_R201807("2.16.756.5.30.1.139.1.1.8", "eHealthConnector R201807", "2018-07-24"),

	/**
	 * OID eHealthConnector R201909
	 */
	EHEALTH_CONNECTOR_R201909("2.16.756.5.30.1.139.1.1.9", "eHealthConnector R201909", "2019-09-17"),

	/**
	 * OID eHealthConnector R202007
	 */
	EHEALTH_CONNECTOR_R202007("2.16.756.5.30.1.139.1.1.10", "eHealthConnector R202007", "2020-07-15"),

	/**
	 * OID husky Rxxxxxx
	 */
	// This is preparation for next release, only
	HUSKY_RXXXXXX("2.16.756.5.30.1.139.1.1.11", "husky Rxxxxxx",
			"todo release date");

	public static EhcVersions getCurrentVersion() {
		return EhcVersions.HUSKY_RXXXXXX;
	}

	private String oid;
	private String releaseDate;

	private String systemVersionName;

	private EhcVersions(String oid, String systemVersionName, String releaseDate) {
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
