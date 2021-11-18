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
package org.husky.communication.exceptions;

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
