package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link ChEmedEprValidator}.
 *
 * @author Quentin Ligier
 **/
class ChEmedEprValidatorTest {

    @Test
    void validateDocumentBundle() throws IOException {
        final var ctx = FhirContext.forR4Cached();
        final var validator = new ChEmedEprValidator(ctx);

        final var xml = new String(getClass().getResourceAsStream("/1-1-MedicationTreatmentPlan.xml").readAllBytes());
        assertTrue(validator.validateDocumentBundle(xml, EmedDocumentType.MTP).isSuccessful());
        assertFalse(validator.validateDocumentBundle(xml, EmedDocumentType.PRE).isSuccessful());
    }
}
