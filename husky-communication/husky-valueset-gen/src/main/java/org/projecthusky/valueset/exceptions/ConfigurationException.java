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
package org.projecthusky.valueset.exceptions;

/**
 * Exception in case the value set configuration is invalid.
 */
public class ConfigurationException extends Exception {

    /**
     * The generated constant serialVersionUID.
     */
    private static final long serialVersionUID = 5998358174203522368L;

    /**
     * Default constructor to instantiate the object. A predefined text message will be used.
     */
    public ConfigurationException() {
        super("The value set configuration cannot be loaded. Please check the config file/stream.");
    }

    /**
     * Instantiates a new configuration exception by using the given text message.
     *
     * @param message the message
     */
    public ConfigurationException(String message) {
        super(message);
    }
}
