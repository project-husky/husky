package org.projecthusky.fhir.emed.ch.epr.narrative.treatment;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.ProductCodeType;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;

import static org.junit.jupiter.api.Assertions.*;

class NarrativeTreatmentDocumentTest {


    @Test
    void testPmlc() throws Exception {
        final var xml = new String(getClass().getResourceAsStream("/2-7-MedicationCard.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var documents = parser.parse(xml, EmedDocumentType.PMLC);
        assertInstanceOf(ChEmedEprDocumentPmlc.class, documents);
        final var pmlcDocument = (ChEmedEprDocumentPmlc) documents;
        assertNotNull(pmlcDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPmlc.class, pmlcDocument.resolveComposition());


        final var document = NarrativeTreatmentDocument.builder(NarrativeLanguage.FRENCH)
                .emedDocumentDigest(pmlcDocument, EmedDocumentType.PMLC)
                .build();

//        assertEquals("Familien Hausarzt", document.getLastMedicalAuthor().getName());
//        assertEquals("Hausarzt", document.getLastMedicalAuthor().getOrganization());
//        assertNull(document.getLastMedicalAuthor().getAddress());
//        assertEquals(document.getLastMedicalAuthor(), document.getLastInterveningAuthor());
        assertEquals(EmedDocumentType.PMLC, document.getDocumentType());
        assertEquals("04.02.2012 14:05:00", document.getCreationTime());
        assertEquals("04.02.2012 14:05:00", document.getDocumentationTime());
        assertEquals("Monika Wegmüller", document.getPatientName());
//        assertEquals("", document.getPatientGender());
        assertEquals("15.05.1943", document.getPatientBirthDate());
        assertNull(document.getPatientAddress());
//        assertEquals("", document.getPatientContact());

        assertEquals(0, document.getRecentTreatments().size());
        assertEquals(2, document.getActiveTreatments().size());

        NarrativeTreatmentItem item1 = document.getActiveTreatments().get(0);
//        assertEquals("Familien Hausarzt",item1.getSectionAuthor().getName());
//        assertEquals("29.11.2011", item1.getPlanningTime());
        assertEquals("BELOC ZOK Ret Tabl 50 mg", item1.getProductName());
        assertEquals(ProductCodeType.GTIN, item1.getCodeType());
        assertEquals("7680521101306", item1.getProductCode());
        assertEquals("Comprimé", item1.getProductFormCode());
//        assertEquals(1, item1.getProductIngredients().size());
//        assertEquals("Tacrolimus", item1.getProductIngredients().get(0).getName());
//        assertEquals("0.5", item1.getProductIngredients().get(0).getQuantity());
//        assertEquals("mg", item1.getProductIngredients().get(0).getUnit());
//        assertEquals("10.01.2022", item1.getTreatmentStart());
//        assertEquals("10.03.2022", item1.getTreatmentStop());
//        assertNull(item1.getNarrativeDosageInstructions());
//        assertEquals("0.5", item1.getDosageIntakeMorning());
//        assertNull(item1.getDosageIntakeNoon());
//        assertNull(item1.getDosageIntakeEvening());
//        assertNull(item1.getDosageIntakeNight());
//        assertEquals("mg", item1.getDosageUnit());
//        assertEquals(1, item1.getRepeatNumber());
//        assertEquals("voie orale", item1.getRouteOfAdministration());
        assertEquals("Bluthochdruck", item1.getTreatmentReason());
        assertNull(item1.getPatientMedicationInstructions());
        assertNull(item1.getFulfilmentInstructions());
        assertFalse(item1.isInReserve());
        assertNull(item1.getAnnotationComment());
    }
}