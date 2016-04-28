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
package org.ehealth_connector.communication.exceptions;

/**
 * <div class="en">Exception in case when no document found</div>
 *
 * @version 1.0
 * @since Dec 15, 2015 11:23:08 AM
 *
 */
public class DocumentNotAccessibleException extends Exception {

	/** Field referencing the long */
	private static final long serialVersionUID = 7467379295958348748L;

	/**
	 * Default constructor to instanciate the object
	 */
	public DocumentNotAccessibleException() {
		super("The Document could not be found. Is the path correct?");
	}

}
