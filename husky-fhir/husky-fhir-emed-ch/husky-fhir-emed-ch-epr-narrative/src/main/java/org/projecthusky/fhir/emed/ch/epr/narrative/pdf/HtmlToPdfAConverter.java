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

import java.io.IOException;
import java.util.Map;

/**
 * Functional interface of an HTML-to-PDF/A converter.
 *
 * @author Quentin Ligier
 **/
@FunctionalInterface
public interface HtmlToPdfAConverter {

    /**
     * Converts the HTML content to its PDF/A representation, with a custom template.
     *
     * @param lang             The document language, as an ISO code.
     * @param contextVariables The context variables to be added to the template processing. Note that {@code "lang"} is
     *                         automatically added with the code value of the received {@code lang} parameter.
     * @param templateContent The custom Thymeleaf content.
     * @return The content of the generated PDF/A.
     */
    // Allow any exception to be thrown
    byte[] convert(final NarrativeLanguage lang,
                   final Map<String, Object> contextVariables,
                   //final Map<String, String> bookmarks,
                   final String templateContent);
}
