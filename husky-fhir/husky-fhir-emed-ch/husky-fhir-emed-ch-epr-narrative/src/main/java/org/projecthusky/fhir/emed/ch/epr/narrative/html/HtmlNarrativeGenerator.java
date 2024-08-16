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
package org.projecthusky.fhir.emed.ch.epr.narrative.html;

import ca.uhn.fhir.context.FhirContext;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprMedicationStatementPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.time.Instant;
import java.util.*;

/**
 * A generator of narrative as HTML content.
 * <p>
 * The template engine is <a href="https://www.thymeleaf.org">Thymeleaf</a>. Templates are stored in
 * '/resources/narrative/templates'.
 *
 * @author Quentin Ligier
 **/
public class HtmlNarrativeGenerator extends AbstractNarrativeGenerator {

    /**
     * The FHIR context.
     */
    protected final FhirContext fhirContext;

    /**
     * The Thymeleaf template engine.
     */
    protected final TemplateEngine templateEngine;

    protected final NarrativeFormat narrativeFormat;

    public HtmlNarrativeGenerator(final NarrativeFormat format) throws IOException {
        super();
        this.fhirContext = FhirContext.forR4Cached();
        this.narrativeFormat = Objects.requireNonNull(format);
        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(ChEmedEprTemplateResolver.get());
    }

    @Override
    public String generate(final ChEmedEprDocumentPmlc document,
                           final NarrativeLanguage lang
                           ) {
        final var asneededTreatments = new HashMap<UUID, List<ChEmedEprMedicationStatementPmlc>>(5);
        final var activeTreatments = new HashMap<UUID, List<ChEmedEprMedicationStatementPmlc>>(5);
        //TODO replace last statement computation with call to ChEmedEprDocumentPmlc.resolveLastStatement()
        ChEmedEprMedicationStatementPmlc lastStatement = null;
        for (final var statement : document.resolveComposition().resolveMedicationStatements()) {
            if (statement.isShownInMedicationCard(document.resolveTimestamp())) {
                addStatementToTreatments(statement,
                        statement.resolveEffectiveDosageInstructions().isRegular() ? activeTreatments : asneededTreatments);
                if (lastStatement == null) lastStatement = statement;
                else {
                    if (getStatementAuthorshipDate(lastStatement).compareTo(getStatementAuthorshipDate(statement)) < 0)
                        lastStatement = statement;
                }
            }
        }

        final var context = new Context();
        context.setVariable("resource", document);
        context.setVariable("lang", lang);
        context.setVariable("fopase", this.valueSetEnumNarrativeForPatientService);
        context.setVariable("activeTreatments", activeTreatments);
        context.setVariable("asneededTreatments", asneededTreatments);
        context.setVariable("lastStatement", lastStatement);
        context.setVariable("issuedDate", document.resolveTimestamp());

        context.setLocale(lang.getLocale());
        return templateEngine
                .process(narrativeFormat == NarrativeFormat.CH_EMED_EPR ? "medication_card" : "emediplan/emediplan_body", context);
    }

    @Override
    public String generate(final ChEmedEprDocumentPre document,
                           final NarrativeLanguage lang) {
        final var context = new Context();
        context.setVariable("resource", document);
        context.setVariable("lang", lang);
        context.setVariable("fopase", this.valueSetEnumNarrativeForPatientService);
        context.setVariable("treatments", document.resolveComposition().resolveMedicationRequests());
        context.setVariable("author", document.resolveComposition().resolveFirstHumanAuthor());

        context.setLocale(lang.getLocale());
        return this.templateEngine.process("prescription", context);
    }

    /**
     * Adds a medication (instance) statement to the map of treatments.
     * @param statement The statement to be added.
     * @param treatments The map of treatments.
     */
    private static void addStatementToTreatments(final ChEmedEprMedicationStatementPmlc statement,
                                                 final Map<UUID, List<ChEmedEprMedicationStatementPmlc>> treatments) {
        final var planId = statement.getTreatmentPlanElement().resolveIdentifier();
        if (treatments.containsKey(planId)) treatments.get(planId).add(statement);
        else {
            final var treatmentsList = new ArrayList<ChEmedEprMedicationStatementPmlc>(5);
            treatmentsList.add(statement);
            treatments.put(planId, treatmentsList);
        }
    }

    /**
     * Gets the statement medical authorship timestamp.
     * @param statement The medication statement for which to determine the medical authorship timestamp.
     * @return The timestamp of the medical authorship.
     */
    private Instant getStatementAuthorshipDate(final ChEmedEprMedicationStatementPmlc statement) {
        return statement.resolveInformationSource().getTime();
    }
}
