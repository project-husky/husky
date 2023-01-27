/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;

import java.util.Map;

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
     * @param subject     The document subject. It's inserted in a {@code <meta name="subject">} tag.
     * @param author      The document author. It's inserted in a {@code <meta name="author">} tag.
     * @param description The document description. It's inserted in a {@code <meta name="description">} tag.
     * @param title       The document title.
     * @param lang        The document language, as an ISO code.
     * @param bookmarks   A list of bookmarks to interesting parts of the document. The keys are labels that are shown
     *                    to the user, the values are HTML ID references (starting with '#').
     * @param cssContent  The CSS content to inject.
     * @param bodyContent The HTML content to convert. It will be inserted in a {@code <body>} tag.
     * @return The content of the generated PDF/A.
     * @throws Exception it may throw any exception.
     */
    @SuppressWarnings("java:S112")
    // Allow any exception to be thrown
    byte[] convert(final String subject,
                   final String author,
                   final String description,
                   final String title,
                   final NarrativeLanguage lang,
                   final Map<String, String> bookmarks,
                   final String cssContent,
                   final String bodyContent) throws Exception;
}
