package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link ChEmedEprValidator} implementations.
 *
 * @author Quentin Ligier
 **/
class ChEmedEprValidatorTest {
    private static final Logger log = LoggerFactory.getLogger(ChEmedEprValidatorTest.class);

    @Test
    void validateDocumentBundleWithHapi() throws IOException, URISyntaxException, EOperationOutcome {
        final var ctx = FhirContext.forR4Cached();
        final var validator = new ChEmedEprHapiValidator(ctx);
        performValidate(ctx, validator);
    }

    private void performValidate(final FhirContext ctx, final ChEmedEprValidator validator) throws IOException, EOperationOutcome {
        final var parser = new ChEmedEprParser(ctx);

        final var xml = new String(getClass().getResourceAsStream("/examples/ch-emed/Bundle-1-1-MedicationTreatmentPlan.xml").readAllBytes());
        final var mtpDocument = parser.parse(xml, EmedDocumentType.MTP);
        ValidationResult results = validator.validateDocumentBundle(getClass().getResourceAsStream(
                "/examples/ch-emed/Bundle-1-1-MedicationTreatmentPlan.xml"), mtpDocument, Manager.FhirFormat.XML);

        for (final var message : results.getIssues()) {
            log.info(String.format("[%s][%s] %s", message.getSeverity().name(), message.getType().name(),
                    message.getMessage()));
        }

        assertTrue(results.isSuccessful());
        final var preDocument = parser.parse(xml, EmedDocumentType.PRE);
        results = validator.validateDocumentBundle(getClass().getResourceAsStream("/examples/ch-emed/Bundle-1-1-MedicationTreatmentPlan.xml"),
                preDocument,
                Manager.FhirFormat.XML);
        assertFalse(results.isSuccessful());
    }

    /**
     * Note that Bundle-2-6-MedicationPrescription cannot pass CH EMED EPR validation because it contains an E
     * substitution code, which is not allowed by CH EMED EPR (CH EMED EPR mandates that this is not filled or if filled
     * it is filled to indicate N).
     * @throws IOException
     */
    @Test
    void validatePreDocumentBundleWithHapi() throws IOException {
        final var ctx = FhirContext.forR4Cached();
        final var validator = new ChEmedEprHapiValidator(ctx);
        final var parser = new ChEmedEprParser(ctx);

        final var xml = new String(getClass().getResourceAsStream("/examples/ch-emed-epr/Bundle-DocumentPreParacetamolAxapharmCARAPMP004.xml").readAllBytes());
        final var doc = parser.parse(xml, EmedDocumentType.PRE);
        ValidationResult results = validator.validateDocumentBundle(getClass().getResourceAsStream(
                "/examples/ch-emed-epr/Bundle-DocumentPreParacetamolAxapharmCARAPMP004.xml"), doc, Manager.FhirFormat.XML);

        for (final var message : results.getIssues()) {
            log.info(String.format("[%s][%s] %s", message.getSeverity().name(), message.getType().name(),
                    message.getMessage()));
        }

        assertTrue(results.isSuccessful());
    }

    @Test
    void validateDisDocumentBundleWithHapi() throws IOException {
        final var ctx = FhirContext.forR4Cached();
        final var validator = new ChEmedEprHapiValidator(ctx);
        final var parser = new ChEmedEprParser(ctx);

        final var xml = new String(getClass().getResourceAsStream("/examples/ch-emed/Bundle-1-2-MedicationDispense.xml").readAllBytes());
        final var doc = parser.parse(xml, EmedDocumentType.DIS);
        ValidationResult results = validator.validateDocumentBundle(getClass().getResourceAsStream(
                "/examples/ch-emed/Bundle-1-2-MedicationDispense.xml"), doc, Manager.FhirFormat.XML);

        for (final var message : results.getIssues()) {
            log.info(String.format("[%s][%s] %s", message.getSeverity().name(), message.getType().name(),
                    message.getMessage()));
        }

        assertTrue(results.isSuccessful());
    }
}
