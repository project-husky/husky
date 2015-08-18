package org.ehealth_connector.communication.ch.enums;

public enum DateTimeRangeAttributes {
	CREATION_TIME ("creationTime"),
	SERVICE_START_TIME ("serviceStartTime"),
	SERVICE_STOP_TIME ("serviceStopTime");
	
	private String name;
	
	private DateTimeRangeAttributes (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
