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
package org.husky.validation.service.enums;

/**
 * The Severity Enum.
 */
public enum Severity {

	/** Error Severity. */
	Error,
	/** Warning Severity. */
	Warning,
	/** Information Severity. */
	Information,
	/**
	 * Custom warning Severity (used for customizing warnings in the eHealth
	 * Connector.).
	 */
	CustomWarning
}
