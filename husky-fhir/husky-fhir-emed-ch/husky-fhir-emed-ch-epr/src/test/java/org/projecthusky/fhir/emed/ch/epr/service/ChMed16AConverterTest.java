package org.projecthusky.fhir.emed.ch.epr.service;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.ChMed16AConverter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChMed16AConverterTest {
    @Test
    void convertAndValidateMedicationCard() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-7-MedicationCard-UUIDfullUrl.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PMLC);
        assertInstanceOf(ChEmedEprDocumentPmlc.class, document);
        final var pmlcDocument = (ChEmedEprDocumentPmlc) document;
        assertNotNull(pmlcDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPmlc.class, pmlcDocument.resolveComposition());
        final var converter = new ChMed16AConverter();

        final var emediplan = converter.toEMediplan(pmlcDocument);
        assertNotNull(emediplan);

        final var validationResult = emediplan.validate();
        assertNotNull(validationResult);
        assertTrue(validationResult.isSuccessful());

        emediplan.trim();
        final var serializedEmediplan = emediplan.toChTransmissionFormat();
        assertNotNull(serializedEmediplan);
    }
}
