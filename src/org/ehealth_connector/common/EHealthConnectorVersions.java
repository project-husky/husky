package org.ehealth_connector.common;

public enum EHealthConnectorVersions {
	/**
	 * OID: 2.16.756.5.31 <div class="de">eHealth Connector V1</div> <div
	 * class="fr">eHealth Connector V1</div>
	 */
	EHealthConnectorV1 ("2.16.756.5.30.1.139.1.1.1","eHealthConnector V1.0","20150325");

	private String id;
	private String systemVersionName;
	private String releaseDate;

	EHealthConnectorVersions(String id, String systemVersionName, String releaseDate) {
		this.id = id;
		this.systemVersionName = systemVersionName;
		this.releaseDate = releaseDate;
	}

	public String getId() {
		return id;
	}

	public String getSystemVersionName() {
		return systemVersionName;
	}
	
	public String getReleaseDate() {
	  return releaseDate;
	}
}
