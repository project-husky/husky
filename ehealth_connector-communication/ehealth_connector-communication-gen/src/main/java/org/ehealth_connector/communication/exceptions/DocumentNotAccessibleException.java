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
