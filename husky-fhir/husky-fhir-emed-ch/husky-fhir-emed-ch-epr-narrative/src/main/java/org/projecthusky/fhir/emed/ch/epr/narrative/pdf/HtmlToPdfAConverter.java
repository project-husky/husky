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
     * Converts the HTML content to its PDF/A representation, with a custom template.
     *
     * @param lang             The document language, as an ISO code.
     * @param contextVariables The context variables to be added to the template processing. Note that a context
     *                         variable {@code lang} is automatically added with the code value of the received
     *                         {@code lang} parameter.
     *                         Furthermore, the following context variables – and, possibly, others – are expected by
     *                         the default templates provided with this module, since they are needed to produce a valid
     *                         PDF/A document:
     *                         <ul>
     *                          <li>{@code title} - a string with the document's title.</li>
     *                          <li>{@code subject} - a string with the document's subject</li>
     *                          <li>{@code author} - a string with the document's author</li>
     *                          <li>{@code description} - a string with the document's description</li>
     *                          <li>{@code bookmarks} - a map of {@code <String, String>} pairs:
     *                              <ul>
     *                                  <li>Key: a string with the bookmark link reference, that is, the value of the
     *                                      href attribute of an anchor element within the processed template.
     *                                  </li>
     *                                  <li>Value: the value of the bookmark, that is, the string that will be used to
     *                                      display the bookmark itself.
     *                                  </li>
     *                              </ul>
     *                              For instance, the pair {@code ("Active Treatments", "#active-treatments")} should
     *                              be used to produce a bookmark to be rendered as {@code Active Treatments} that
     *                              would point to the HTML element with id {@code active-treatments} in the processed
     *                              template.
     *                          </li>
     *                         </ul>
     *                         Any callers using custom templates must make sure they are still setting these in their
     *                         templates either by means of these context variables or by any other method (e.g.
     *                         hardcoded in the template), as well as providing any other context variables that might
     *                         be required by said templates.
     * @param templateContent The custom Thymeleaf content.
     * @return The content of the generated PDF/A.
     */
    // Allow any exception to be thrown
    byte[] convert(final NarrativeLanguage lang,
                   final Map<String, Object> contextVariables,
                   final String templateContent);
}
