package org.ehealth_connector.communication.ch.enums;

/**
 * Represents the XDS metadata attributes, which are related to DateTimeRanges
 *
 */
public enum DateTimeRangeAttributes {

	/**
	 * Time, when the author created the document
	 */
	CREATION_TIME("creationTime"),
	/**
	 * Start time of the service, which led to the document
	 */
	SERVICE_START_TIME("serviceStartTime"),
	/**
	 * End time of the service, which led to the document
	 */
	SERVICE_STOP_TIME("serviceStopTime");

	private String name;

	private DateTimeRangeAttributes(String name) {
		this.name = name;
	}

	/**
	 * Gets the XDS attribute name of the Enum
	 * 
	 * @return the name of the attribute
	 */
	public String getName() {
		return name;
	}
}
