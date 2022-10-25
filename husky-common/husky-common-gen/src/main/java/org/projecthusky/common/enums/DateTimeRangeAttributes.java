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
package org.projecthusky.common.enums;

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
