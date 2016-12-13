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
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.common.utils;

/**
 * System utilities
 *
 */
public class SystemUtil {

	/**
	 * Gets the number of available processors of the current machine
	 * 
	 * @return The number of available processors of the current machine
	 */
	public static int availableProcessors() {
		return Runtime.getRuntime().availableProcessors();
	}
}
