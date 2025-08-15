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
package org.projecthusky.fhir.vacd.ch.common.exceptions;

import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;

/**
 * 
 */
public class InvalidVacdContentException extends InvalidContentException {

	private static final long serialVersionUID = 7164585898389012650L;

	public InvalidVacdContentException(String string) {
		super(string);
	}

}
