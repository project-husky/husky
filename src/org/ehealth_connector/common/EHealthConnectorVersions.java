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

public enum EHealthConnectorVersions {
	/**
	 * OID: 2.16.756.5.31 <div class="de">eHealth Connector V1</div> <div
	 * class="fr">eHealth Connector V1</div>
	 */
	EHealthConnectorV1("2.16.756.5.30.1.139.1.1.1", "eHealthConnector V1.0",
			"20150325");

	private String id;
	private String systemVersionName;
	private String releaseDate;

	EHealthConnectorVersions(String id, String systemVersionName,
			String releaseDate) {
		this.id = id;
		this.systemVersionName = systemVersionName;
		this.releaseDate = releaseDate;
	}

	public String getId() {
		return id;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getSystemVersionName() {
		return systemVersionName;
	}
}
