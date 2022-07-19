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
package org.husky.emed.ch.cda.digesters;

import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.husky.emed.ch.enums.*;
import org.husky.emed.ch.models.common.*;
import org.husky.emed.ch.models.document.EmedMtpDocumentDigest;
import org.husky.emed.ch.models.treatment.MedicationProduct;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link CceDocumentDigester} class.
 *
 * @author Quentin Ligier
 **/
@SuppressWarnings({"ConstantConditions", "java:S5961"}) // No null checks, no limit on number of assertions
class CceDocumentDigesterTest {

    @Test
    void testMtpDigestion() throws Exception {
        final var mtpDocument = this.loadDoc("1-1-MedicationTreatmentPlan.xml");
        final var digester = new CceDocumentDigester();
        final var digest = digester.digest(mtpDocument);

        // Document
        assertNotNull(digest);
        assertInstanceOf(EmedMtpDocumentDigest.class, digest);
        final var mtpDigest = (EmedMtpDocumentDigest) digest;
        assertNotNull(mtpDigest);
        assertEquals("c9f758a1-296c-4710-84d4-e181db8c7478", mtpDigest.getId().toString());
        assertEquals("c9f758a1-296c-4710-84d4-e181db8c7478", mtpDigest.getSetId().toString());
        assertEquals(1, mtpDigest.getVersion());
        assertEquals("de-CH", mtpDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, mtpDigest.getConfidentialityCode());
        assertEquals(1322560800L, mtpDigest.getCreationTime().toEpochSecond());
        assertEquals(1322560800000L, mtpDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, mtpDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, mtpDigest.getAuthors().get(0));
        assertEquals(1322560800000L, mtpDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", mtpDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", mtpDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", mtpDigest.getAuthors().get(0).getAuthorGln());
        assertInstanceOf(OrganizationDigest.class, mtpDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, mtpDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, mtpDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, mtpDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), mtpDigest.getPatient().ids());
        assertEquals("Monika", mtpDigest.getPatient().givenName());
        assertEquals("Wegmüller", mtpDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, mtpDigest.getPatient().gender());
        assertEquals(-9728, mtpDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, mtpDigest.getCustodian());
        assertNull(mtpDigest.getRemarks());
        assertEquals(0, mtpDigest.getPdfRepresentation().length);

        // Entry
        final var mtpEntryDigest = mtpDigest.getMtpEntryDigest();
        assertNotNull(mtpEntryDigest);
        assertEquals(0, mtpEntryDigest.getSequence());
        assertEquals("Bluthochdruck", mtpEntryDigest.getTreatmentReason());
        assertEquals(mtpDigest.getId(), mtpEntryDigest.getDocumentId());
        assertEquals("c9f758a1-296c-4710-84d4-e181db8c7478", mtpEntryDigest.getEntryId().toString());
        assertEquals("c9f758a1-296c-4710-84d4-e181db8c7478", mtpEntryDigest.getMedicationTreatmentId().toString());
        assertEquals(EmedEntryType.MTP, mtpEntryDigest.getEmedEntryType());
        assertEquals(1322560800000L, mtpEntryDigest.getPlanningTime().toEpochMilli());
        assertEquals(1322524800000L, mtpEntryDigest.getPlannedItemValidityStart().toEpochMilli());
        assertEquals(RouteOfAdministrationAmbu.ORAL_USE, mtpEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, mtpEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NARRATIVE, mtpEntryDigest.getDosageInstructions().getType());
        assertEquals(1, mtpEntryDigest.getDosageInstructions().getIntakes().size());
        assertEquals(TimingEventAmbu.MORNING, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getEventTiming());
        assertEquals("0.5", mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.TABLET, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getUnit());
        assertEquals("Morgens 1/2 Tablette nehmen", mtpEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertEquals(1322524800000L, mtpEntryDigest.getDosageInstructions().getIntakePeriodStartTime().toEpochMilli());
        assertNull(mtpEntryDigest.getDosageInstructions().getIntakePeriodStopTime());
        assertInstanceOf(MedicationProduct.class, mtpEntryDigest.getProduct());
        assertEquals("7680538751228", mtpEntryDigest.getProduct().getGtinCode());
        assertNull(mtpEntryDigest.getProduct().getAtcCode());
        assertEquals("TRIATEC Tabl 2.5 mg", mtpEntryDigest.getProduct().getName());
        assertNull(mtpEntryDigest.getProduct().getLotNumber());
        assertEquals(PharmaceuticalDoseFormEdqm.TABLET, mtpEntryDigest.getProduct().getFormCode());
        assertNull(mtpEntryDigest.getProduct().getExpirationDate());
        assertEquals("7680538751228", mtpEntryDigest.getProduct().getPackageGtinCode());
        assertEquals("TRIATEC Tabl 2.5 mg", mtpEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.TABLET, mtpEntryDigest.getProduct().getPackageFormCode());
        assertEquals("20", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals("732936001", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getUnit().getCodeValue());
        assertEquals(1, mtpEntryDigest.getProduct().getIngredients().size());
        assertEquals("Ramipril", mtpEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("2.5", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals(RegularUnitCodeAmbu.TABLET, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit());
        assertEquals(ActivePharmaceuticalIngredient.RAMIPRIL, mtpEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getDocumentAuthor());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getSectionAuthor());

        assertNull(mtpEntryDigest.getFulfilmentInstructions());
        assertNull(mtpEntryDigest.getOriginalMtpReference());
        assertNull(mtpEntryDigest.getPatientMedicationInstructions());
        assertNull(mtpEntryDigest.getRepeatNumber());
        assertNull(mtpEntryDigest.getPlannedItemValidityStop());
        assertNull(mtpEntryDigest.getAnnotationComment());
        assertFalse(mtpEntryDigest.isInReserve());
        assertTrue(mtpEntryDigest.isSubstitutionPermitted());
    }

    @Test
    void testGetDocumentType() throws Exception {
        assertEquals(CceDocumentType.MTP, CceDocumentDigester.getDocumentType(this.loadDoc("1-1-MedicationTreatmentPlan.xml")));
        assertEquals(CceDocumentType.PRE, CceDocumentDigester.getDocumentType(this.loadDoc("2-6-MedicationPrescription.xml")));
        assertEquals(CceDocumentType.DIS, CceDocumentDigester.getDocumentType(this.loadDoc("1-2-MedicationDispense.xml")));
        assertEquals(CceDocumentType.PADV, CceDocumentDigester.getDocumentType(this.loadDoc("2-2-PharmaceuticalAdvice.xml")));
        assertEquals(CceDocumentType.PML, CceDocumentDigester.getDocumentType(this.loadDoc("2-1-MedicationList.xml")));
        assertEquals(CceDocumentType.PMLC, CceDocumentDigester.getDocumentType(this.loadDoc("2-7-MedicationCard.xml")));
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CceDocumentDigesterTest.class.getResourceAsStream("/CDA-CH-EMED" +
                "/eHealthSuisse/v1.0/" + docName));
    }
}
