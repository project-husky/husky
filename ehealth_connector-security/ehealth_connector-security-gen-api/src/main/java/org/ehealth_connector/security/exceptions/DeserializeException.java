/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.exceptions;

/**
 * @since Feb 21, 2018 11:45:21 AM
 *
 */
public class DeserializeException extends Exception {

	/** Field referencing the long */
	private static final long serialVersionUID = -1343781617387784825L;

	/**
	 * Default constructor to instanciate the object
	 */
	public DeserializeException() {
		super();
	}

	/**
	 * Default constructor to instanciate the object
	 * 
	 * @param cause
	 */
	public DeserializeException(Throwable cause) {
		super(cause);
	}

	/**
	 * Default constructor to instanciate the object
	 * 
	 * @param message
	 */
	public DeserializeException(String message) {
		super(message);
	}

}
