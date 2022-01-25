/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.narrative.pdf;

/**
 * Functional interface of an HTML-to-PDF/A converter.
 *
 * @author Quentin Ligier
 **/
@FunctionalInterface
public interface HtmlToPdfAConverter {

    /**
     * Converts the HTML content to its PDF/A representation.
     *
     * @param htmlContent The HTML content to convert.
     * @return The content of the generated PDF/A.
     * @throws Exception it may throw any exception.
     */
    @SuppressWarnings("java:S112") // Allow any exception to be thrown
    byte[] convert(final String htmlContent) throws Exception;
}
