/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.common.enums;

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
