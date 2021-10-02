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
package org.ehealth_connector.communication.utils;

import org.ehealth_connector.common.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author roeland
 *
 */
public abstract class AbstractAxis2Util {

	private static final Logger log = LoggerFactory.getLogger(AbstractAxis2Util.class);

	private AbstractAxis2Util() {
		throw new IllegalStateException("This is a utility class!");
	}

	/**
	 * Method to load axis2 config from ressource
	 */
	public static void initAxis2Config() {
		String axis2File = Util.extractFileFromResource("/conf/axis2.xml", false);
		log.debug("Loading Axis2 Config from {}", axis2File);
		System.setProperty("axis2.xml", axis2File);
	}

}
