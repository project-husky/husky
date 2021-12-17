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
package org.husky.valueset.exceptions;

/**
 * Exception in case the value set mapping does not exist.
 */
public class MappingException extends Exception {

    /**
     * The generated constant serialVersionUID.
     */
    private static final long serialVersionUID = -1454634787837958402L;

    /**
     * Default constructor to instantiate the object. A predefined text message will be used.
     */
    public MappingException() {
        super("The requested mapping does not exist.");
    }

    /**
     * Instantiates a new mapping exception by using the given text message.
     *
     * @param message the message
     */
    public MappingException(String message) {
        super(message);
    }

}