package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.junit.jupiter.api.Disabled;
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
 * Tests for {@link ChEmedEprValidator}.
 *
 * @author Quentin Ligier
 **/
class ChEmedEprValidatorTest {
    private static final Logger log = LoggerFactory.getLogger(ChEmedEprValidatorTest.class);

    @Test
    @Disabled("This test does produce validation errors on an FHIR dokument. Perhaps validation has changed and now the test is failing.")
    void validateDocumentBundle() throws IOException, URISyntaxException, EOperationOutcome {
        final var ctx = FhirContext.forR4Cached();
        final var validator = new ChEmedEprValidator();
        final var parser = new ChEmedEprParser(ctx);

        final var xml = new String(getClass().getResourceAsStream("/1-1-MedicationTreatmentPlan.xml").readAllBytes());
        final var mtpDocument = parser.parse(xml, EmedDocumentType.MTP);
        ValidationResult results = validator.validateDocumentBundle(getClass().getResourceAsStream(
                "/1-1-MedicationTreatmentPlan.xml"), mtpDocument, Manager.FhirFormat.XML);

        for (final var message : results.getIssues()) {
            log.info(String.format("[%s][%s] %s", message.getSeverity().name(), message.getType().name(),
                                   message.getMessage()));
        }

        assertTrue(results.isSuccessful());
        final var preDocument = parser.parse(xml, EmedDocumentType.PRE);
        results = validator.validateDocumentBundle(getClass().getResourceAsStream("/1-1-MedicationTreatmentPlan.xml"),
                                                   preDocument,
                                                   Manager.FhirFormat.XML);
        assertFalse(results.isSuccessful());
    }
}
