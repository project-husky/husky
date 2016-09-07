/**
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

	/**
	 * Method to load axis2 config from ressource
	 */
	public static void initAxis2Config() {
		String axis2File = Util.extractFileFromResource("/conf/axis2.xml", false);
		log.debug("Loading Axis2 Config from " + axis2File);
		System.setProperty("axis2.xml", axis2File);
	}

}
