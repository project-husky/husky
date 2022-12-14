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
package org.projecthusky.fhir.emed.ch.epr.narrative.generators;

import ca.uhn.fhir.context.FhirContext;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.services.ValueSetEnumNarrativeForPatientService;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;

/**
 * A generator of narrative as HTML content.
 * <p>
 * The template engine is <a href="https://www.thymeleaf.org">Thymeleaf</a>. Templates are stored in
 * '/resources/narrative/templates'.
 *
 * @author Quentin Ligier
 **/
public class HtmlNarrativeGenerator {

    /**
     * The FHIR context.
     */
    protected final FhirContext fhirContext;

    /**
     * The Thymeleaf template engine.
     */
    protected final TemplateEngine templateEngine;

    /**
     * A service to get better display names for patients.
     */
    protected final ValueSetEnumNarrativeForPatientService fopase = new ValueSetEnumNarrativeForPatientService();

    public HtmlNarrativeGenerator() throws IOException {
        this.fhirContext = FhirContext.forR4Cached();

        final var templateResolver = new ClassLoaderTemplateResolver(this.getClass().getClassLoader());
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(true);
        templateResolver.setCacheTTLMs(300000L);
        templateResolver.setPrefix("/narrative/templates/");
        templateResolver.setSuffix(".html");

        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);
    }

    public String generate(final ChEmedEprDocumentPmlc document,
                           final NarrativeLanguage lang) {
        final var context = new Context();
        context.setVariable("resource", document);
        context.setVariable("lang", lang);
        context.setVariable("fopase", this.fopase);
        context.setLocale(lang.getLocale());
        return this.templateEngine.process("medication_card", context);
    }
}
