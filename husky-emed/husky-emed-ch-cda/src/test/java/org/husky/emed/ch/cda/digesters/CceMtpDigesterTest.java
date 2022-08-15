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
import org.husky.emed.ch.errors.InvalidEmedContentException;
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
class CceMtpDigesterTest {

    final String DIR_E_HEALTH_SUISSE = "/eHealthSuisse/v1.0/";
    final String DIR_SAMPLES_BY_HAND = "/Samples/ByHand/mtp/valid/";

    @Test
    void testMtpDigestion() throws Exception {
        final var mtpDocument = this.loadDoc(DIR_E_HEALTH_SUISSE + "1-1-MedicationTreatmentPlan.xml");
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
    void testMtp1Digestion() throws Exception{
        final var mtpDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "MTP_01_valid.xml");
        final var digester = new CceDocumentDigester();
        final var digest = digester.digest(mtpDocument);

        // Document
        assertNotNull(digest);
        assertInstanceOf(EmedMtpDocumentDigest.class, digest);
        final var mtpDigest = (EmedMtpDocumentDigest) digest;
        assertNotNull(mtpDigest);
        assertEquals("00000000-0000-0000-0000-000000000001", mtpDigest.getId().toString());
        assertEquals("00000000-0000-0000-0000-000000000001", mtpDigest.getSetId().toString());
        assertEquals(1, mtpDigest.getVersion());
        assertEquals("fr-CH", mtpDigest.getLanguageCode());
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
        assertEquals(mtpDigest.getId(), mtpEntryDigest.getDocumentId());
        assertEquals("00000000-0000-0000-0000-000000000001", mtpEntryDigest.getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000001", mtpEntryDigest.getMedicationTreatmentId().toString());
        assertEquals(EmedEntryType.MTP, mtpEntryDigest.getEmedEntryType());
        assertEquals(1322560800000L, mtpEntryDigest.getPlanningTime().toEpochMilli());
        assertEquals(1641812400000L, mtpEntryDigest.getPlannedItemValidityStart().toEpochMilli());
        assertEquals(1646910000000L, mtpEntryDigest.getPlannedItemValidityStop().toEpochMilli());
        assertEquals(1, mtpEntryDigest.getRepeatNumber());
        assertEquals(RouteOfAdministrationAmbu.ORAL_USE, mtpEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, mtpEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NORMAL, mtpEntryDigest.getDosageInstructions().getType());
        assertEquals(1, mtpEntryDigest.getDosageInstructions().getIntakes().size());
        assertEquals(TimingEventAmbu.MORNING, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getEventTiming());
        assertEquals("0.5", mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getUnit());
        assertNull(mtpEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertEquals(1641812400000L, mtpEntryDigest.getDosageInstructions().getIntakePeriodStartTime().toEpochMilli());
        assertEquals(1646910000000L, mtpEntryDigest.getDosageInstructions().getIntakePeriodStopTime().toEpochMilli());
        assertInstanceOf(MedicationProduct.class, mtpEntryDigest.getProduct());
        assertEquals("7680531520746", mtpEntryDigest.getProduct().getGtinCode());
        assertNull(mtpEntryDigest.getProduct().getAtcCode());
        assertEquals("PROGRAF caps 0.5 mg 50 Stk", mtpEntryDigest.getProduct().getName());
        assertNull(mtpEntryDigest.getProduct().getLotNumber());
        assertEquals(PharmaceuticalDoseFormEdqm.CAPSULE_HARD, mtpEntryDigest.getProduct().getFormCode());
        assertNull(mtpEntryDigest.getProduct().getExpirationDate());
        assertEquals("7680531520746", mtpEntryDigest.getProduct().getPackageGtinCode());
        assertEquals("PROGRAF caps 0.5 mg 50 Stk", mtpEntryDigest.getProduct().getPackageName());
        assertNull(mtpEntryDigest.getProduct().getPackageFormCode());
        assertEquals("50", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals("732937005", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getUnit().getCodeValue());
        assertEquals(1, mtpEntryDigest.getProduct().getIngredients().size());
        assertEquals("Tacrolimus", mtpEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("0.5", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals(RegularUnitCodeAmbu.CAPSULE, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit());
        assertEquals(ActivePharmaceuticalIngredient.TACROLIMUS, mtpEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getDocumentAuthor());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getSectionAuthor());

        assertNull(mtpEntryDigest.getFulfilmentInstructions());
        assertNull(mtpEntryDigest.getOriginalMtpReference());
        assertNull(mtpEntryDigest.getPatientMedicationInstructions());
        assertEquals("Treatment Reason", mtpEntryDigest.getTreatmentReason());
        assertTrue(mtpEntryDigest.isSubstitutionPermitted());
        assertEquals("Annotation Comments", mtpEntryDigest.getAnnotationComment());
        assertFalse(mtpEntryDigest.isInReserve());

    }

    @Test
    void testMtp2Digestion() throws Exception{
        final var mtpDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "MTP_02_valid.xml");
        final var digester = new CceDocumentDigester();
        final var digest = digester.digest(mtpDocument);

        // Document
        assertNotNull(digest);
        assertInstanceOf(EmedMtpDocumentDigest.class, digest);
        final var mtpDigest = (EmedMtpDocumentDigest) digest;
        assertNotNull(mtpDigest);
        assertEquals("00000000-0000-0000-0000-000000000002", mtpDigest.getId().toString());
        assertEquals("00000000-0000-0000-0000-000000000002", mtpDigest.getSetId().toString());
        assertEquals(1, mtpDigest.getVersion());
        assertEquals("fr-CH", mtpDigest.getLanguageCode());
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
        assertEquals(mtpDigest.getId(), mtpEntryDigest.getDocumentId());
        assertEquals("00000000-0000-0000-0000-000000000002", mtpEntryDigest.getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000002", mtpEntryDigest.getMedicationTreatmentId().toString());
        assertEquals(EmedEntryType.MTP, mtpEntryDigest.getEmedEntryType());
        assertEquals(1322560800000L, mtpEntryDigest.getPlanningTime().toEpochMilli());
        assertEquals(1641807780000L, mtpEntryDigest.getPlannedItemValidityStart().toEpochMilli());
        assertEquals(1641807780000L, mtpEntryDigest.getDosageInstructions().getIntakePeriodStartTime().toEpochMilli());
        assertNull(mtpEntryDigest.getPlannedItemValidityStop());
        assertNull(mtpEntryDigest.getDosageInstructions().getIntakePeriodStopTime());
        assertNull(mtpEntryDigest.getRepeatNumber());
        assertEquals(RouteOfAdministrationAmbu.NASAL_USE, mtpEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, mtpEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.SPLIT, mtpEntryDigest.getDosageInstructions().getType());
        assertEquals(3, mtpEntryDigest.getDosageInstructions().getIntakes().size());
        assertEquals(TimingEventAmbu.MORNING, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getEventTiming());
        assertEquals("2.0", mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getUnit());
        assertEquals(TimingEventAmbu.NOON, mtpEntryDigest.getDosageInstructions().getIntakes().get(1).getEventTiming());
        assertEquals("1.0", mtpEntryDigest.getDosageInstructions().getIntakes().get(1).getDoseQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getDosageInstructions().getIntakes().get(1).getDoseQuantity().getUnit());
        assertEquals(TimingEventAmbu.EVENING, mtpEntryDigest.getDosageInstructions().getIntakes().get(2).getEventTiming());
        assertEquals("2.0", mtpEntryDigest.getDosageInstructions().getIntakes().get(2).getDoseQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getDosageInstructions().getIntakes().get(2).getDoseQuantity().getUnit());
        assertNull(mtpEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, mtpEntryDigest.getProduct());
        assertEquals("7680541890365", mtpEntryDigest.getProduct().getGtinCode());
        assertEquals("7680541890365", mtpEntryDigest.getProduct().getPackageGtinCode());
        assertNull(mtpEntryDigest.getProduct().getAtcCode());
        assertEquals("NASONEX spray nasal doseur 50 mcg", mtpEntryDigest.getProduct().getName());
        assertEquals("NASONEX spray nasal doseur 50 mcg", mtpEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.NASAL_SPRAY_SOLUTION, mtpEntryDigest.getProduct().getFormCode());
        assertNull(mtpEntryDigest.getProduct().getLotNumber());
        assertNull(mtpEntryDigest.getProduct().getExpirationDate());
        assertNull(mtpEntryDigest.getProduct().getPackageFormCode());
        assertEquals("140", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getProduct().getPackageCapacityQuantity().getUnit());
        assertEquals(1, mtpEntryDigest.getProduct().getIngredients().size());
        assertEquals("Mometasone", mtpEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("50", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.UG, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit());
        assertEquals(ActivePharmaceuticalIngredient.MOMETASONE, mtpEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getDocumentAuthor());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getSectionAuthor());

        assertNull(mtpEntryDigest.getFulfilmentInstructions());
        assertNull(mtpEntryDigest.getOriginalMtpReference());
        assertNull(mtpEntryDigest.getPatientMedicationInstructions());
        assertEquals("Treatment Reason", mtpEntryDigest.getTreatmentReason());
        assertTrue(mtpEntryDigest.isSubstitutionPermitted());
        assertNull(mtpEntryDigest.getAnnotationComment());
        assertFalse(mtpEntryDigest.isInReserve());

    }

    @Test
    void testMtp3Digestion() throws Exception{
        final var mtpDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "MTP_03_valid.xml");
        final var digester = new CceDocumentDigester();
        final var digest = digester.digest(mtpDocument);

        // Document
        assertNotNull(digest);
        assertInstanceOf(EmedMtpDocumentDigest.class, digest);
        final var mtpDigest = (EmedMtpDocumentDigest) digest;
        assertNotNull(mtpDigest);
        assertEquals("00000000-0000-0000-0000-000000000003", mtpDigest.getId().toString());
        assertEquals("00000000-0000-0000-0000-000000000003", mtpDigest.getSetId().toString());
        assertEquals(1, mtpDigest.getVersion());
        assertEquals("fr-CH", mtpDigest.getLanguageCode());
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
        assertEquals(mtpDigest.getId(), mtpEntryDigest.getDocumentId());
        assertEquals("00000000-0000-0000-0000-000000000003", mtpEntryDigest.getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000003", mtpEntryDigest.getMedicationTreatmentId().toString());
        assertEquals(EmedEntryType.MTP, mtpEntryDigest.getEmedEntryType());
        assertEquals(1322560800000L, mtpEntryDigest.getPlanningTime().toEpochMilli());
        assertEquals(1322560800000L, mtpEntryDigest.getPlannedItemValidityStart().toEpochMilli());
        assertNull(mtpEntryDigest.getDosageInstructions().getIntakePeriodStartTime());
        assertEquals(1671062400000L, mtpEntryDigest.getPlannedItemValidityStop().toEpochMilli());
        assertEquals(1671062400000L, mtpEntryDigest.getDosageInstructions().getIntakePeriodStopTime().toEpochMilli());
        assertNull(mtpEntryDigest.getRepeatNumber());
        assertEquals(RouteOfAdministrationAmbu.OCULAR_USE, mtpEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, mtpEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NORMAL, mtpEntryDigest.getDosageInstructions().getType());
        assertEquals(1, mtpEntryDigest.getDosageInstructions().getIntakes().size());
        assertEquals(TimingEventAmbu.NIGHT, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getEventTiming());
        assertEquals("1", mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getValue());
        assertEquals("732997007", mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getUnit().getCodeValue());
        assertNull(mtpEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, mtpEntryDigest.getProduct());
        assertEquals("7680555680013", mtpEntryDigest.getProduct().getGtinCode());
        assertNull(mtpEntryDigest.getProduct().getPackageGtinCode());
        assertNull(mtpEntryDigest.getProduct().getAtcCode());
        assertEquals("SYMBICORT 100/6 turbuhaler", mtpEntryDigest.getProduct().getName());
        assertNull(mtpEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.INHALATION_POWDER, mtpEntryDigest.getProduct().getFormCode());
        assertNull(mtpEntryDigest.getProduct().getLotNumber());
        assertEquals(19341L, mtpEntryDigest.getProduct().getExpirationDate().toEpochDay());
        assertNull(mtpEntryDigest.getProduct().getPackageFormCode());
        assertNull(mtpEntryDigest.getProduct().getPackageCapacityQuantity());;
        assertEquals(2, mtpEntryDigest.getProduct().getIngredients().size());
        assertEquals("Budesonide", mtpEntryDigest.getProduct().getIngredients().get(0).getName());
        assertNull(mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator());
        assertNull(mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator());
        assertEquals(ActivePharmaceuticalIngredient.BUDESONIDE, mtpEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals("Formoterol", mtpEntryDigest.getProduct().getIngredients().get(1).getName());
        assertEquals("6.1", mtpEntryDigest.getProduct().getIngredients().get(1).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.UG, mtpEntryDigest.getProduct().getIngredients().get(1).getQuantityNumerator().getUnit());
        assertEquals("1", mtpEntryDigest.getProduct().getIngredients().get(1).getQuantityDenominator().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getProduct().getIngredients().get(1).getQuantityDenominator().getUnit());
        assertEquals(ActivePharmaceuticalIngredient.FORMOTEROL, mtpEntryDigest.getProduct().getIngredients().get(1).getCode());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getDocumentAuthor());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getSectionAuthor());

        assertNull(mtpEntryDigest.getFulfilmentInstructions());
        assertNull(mtpEntryDigest.getOriginalMtpReference());
        assertNull(mtpEntryDigest.getPatientMedicationInstructions());
        assertEquals("Treatment Reason", mtpEntryDigest.getTreatmentReason());
        assertFalse(mtpEntryDigest.isSubstitutionPermitted());
        assertEquals("Annotation Comments", mtpEntryDigest.getAnnotationComment());
        assertFalse(mtpEntryDigest.isInReserve());
    }

    @Test
    void testMtp4Digestion() throws Exception{
        final var mtpDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "MTP_04_valid.xml");
        final var digester = new CceDocumentDigester();
        final var digest = digester.digest(mtpDocument);

        // Document
        assertNotNull(digest);
        assertInstanceOf(EmedMtpDocumentDigest.class, digest);
        final var mtpDigest = (EmedMtpDocumentDigest) digest;
        assertNotNull(mtpDigest);
        assertEquals("00000000-0000-0000-0000-000000000004", mtpDigest.getId().toString());
        assertEquals("00000000-0000-0000-0000-000000000004", mtpDigest.getSetId().toString());
        assertEquals(1, mtpDigest.getVersion());
        assertEquals("fr-CH", mtpDigest.getLanguageCode());
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
        assertEquals(mtpDigest.getId(), mtpEntryDigest.getDocumentId());
        assertEquals("00000000-0000-0000-0000-000000000004", mtpEntryDigest.getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000004", mtpEntryDigest.getMedicationTreatmentId().toString());
        assertEquals(EmedEntryType.MTP, mtpEntryDigest.getEmedEntryType());
        assertEquals(1322560800000L, mtpEntryDigest.getPlanningTime().toEpochMilli());
        assertEquals(1322560800000L, mtpEntryDigest.getPlannedItemValidityStart().toEpochMilli());
        assertNull(mtpEntryDigest.getDosageInstructions().getIntakePeriodStartTime());
        assertNull(mtpEntryDigest.getPlannedItemValidityStop());
        assertNull(mtpEntryDigest.getDosageInstructions().getIntakePeriodStopTime());
        assertEquals(0, mtpEntryDigest.getRepeatNumber());
        assertNull(mtpEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, mtpEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NARRATIVE, mtpEntryDigest.getDosageInstructions().getType());
        assertEquals(0, mtpEntryDigest.getDosageInstructions().getIntakes().size());
        assertEquals("Dosage Instructions Non Structured", mtpEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, mtpEntryDigest.getProduct());
        assertEquals("7680483060499", mtpEntryDigest.getProduct().getGtinCode());
        assertEquals("7680483060499", mtpEntryDigest.getProduct().getPackageGtinCode());
        assertNull(mtpEntryDigest.getProduct().getAtcCode());
        assertEquals("BACTRIM forte cpr 800/160mg", mtpEntryDigest.getProduct().getName());
        assertEquals("BACTRIM forte cpr 800/160mg", mtpEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.TABLET, mtpEntryDigest.getProduct().getFormCode());
        assertNull(mtpEntryDigest.getProduct().getLotNumber());
        assertNull(mtpEntryDigest.getProduct().getExpirationDate());
        assertNull(mtpEntryDigest.getProduct().getPackageFormCode());
        assertEquals("20", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals("732936001", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getUnit().getCodeValue());
        assertEquals(2, mtpEntryDigest.getProduct().getIngredients().size());
        assertEquals("Sulfamethoxazole", mtpEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("800", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals("732936001", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.SULFAMETHOXAZOLE, mtpEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals("Trimethoprim", mtpEntryDigest.getProduct().getIngredients().get(1).getName());
        assertEquals("160", mtpEntryDigest.getProduct().getIngredients().get(1).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, mtpEntryDigest.getProduct().getIngredients().get(1).getQuantityNumerator().getUnit());
        assertEquals("1", mtpEntryDigest.getProduct().getIngredients().get(1).getQuantityDenominator().getValue());
        assertEquals("732936001", mtpEntryDigest.getProduct().getIngredients().get(1).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.TRIMETHOPRIM, mtpEntryDigest.getProduct().getIngredients().get(1).getCode());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getDocumentAuthor());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getSectionAuthor());

        assertNull(mtpEntryDigest.getFulfilmentInstructions());
        assertNull(mtpEntryDigest.getOriginalMtpReference());
        assertNull(mtpEntryDigest.getPatientMedicationInstructions());
        assertEquals("Treatment Reason", mtpEntryDigest.getTreatmentReason());
        assertTrue(mtpEntryDigest.isSubstitutionPermitted());
        assertNull(mtpEntryDigest.getAnnotationComment());
        assertFalse(mtpEntryDigest.isInReserve());
        assertEquals("2", mtpEntryDigest.getQuantityToDispense());
    }

    @Test
    void testMtp5Digestion() throws Exception{
        final var mtpDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "MTP_05_valid.xml");
        final var digester = new CceDocumentDigester();
        final var digest = digester.digest(mtpDocument);

        // Document
        assertNotNull(digest);
        assertInstanceOf(EmedMtpDocumentDigest.class, digest);
        final var mtpDigest = (EmedMtpDocumentDigest) digest;
        assertNotNull(mtpDigest);
        assertEquals("00000000-0000-0000-0000-000000000005", mtpDigest.getId().toString());
        assertEquals("00000000-0000-0000-0000-000000000005", mtpDigest.getSetId().toString());
        assertEquals(1, mtpDigest.getVersion());
        assertEquals("fr-CH", mtpDigest.getLanguageCode());
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
        assertEquals(2, mtpDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", mtpDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", mtpDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", mtpDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());
        assertNull(mtpDigest.getRecipients().get(0).getAddresses().get(0).getStreetName());
        assertNull(mtpDigest.getRecipients().get(0).getAddresses().get(0).getHouseNumber());
        assertEquals("3", mtpDigest.getRecipients().get(0).getAddresses().get(1).getHouseNumber());
        assertEquals("Wishard Blvd", mtpDigest.getRecipients().get(0).getAddresses().get(1).getStreetName());
        assertInstanceOf(PatientDigest.class, mtpDigest.getPatient());
        assertEquals(2, mtpDigest.getPatient().ids().size());
        assertEquals(new QualifiedIdentifier("11111111", "2.998"), mtpDigest.getPatient().ids().get(0));
        assertEquals(new QualifiedIdentifier("22222222", "2.999"), mtpDigest.getPatient().ids().get(1));
        assertEquals("Monika Mia", mtpDigest.getPatient().givenName());
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
        assertEquals(mtpDigest.getId(), mtpEntryDigest.getDocumentId());
        assertEquals("00000000-0000-0000-0000-000000000005", mtpEntryDigest.getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000005", mtpEntryDigest.getMedicationTreatmentId().toString());
        assertEquals(EmedEntryType.MTP, mtpEntryDigest.getEmedEntryType());
        assertEquals(1322560800000L, mtpEntryDigest.getPlanningTime().toEpochMilli());
        assertEquals(1641812400000L, mtpEntryDigest.getPlannedItemValidityStart().toEpochMilli());
        assertEquals(1641812400L, mtpEntryDigest.getDosageInstructions().getIntakePeriodStartTime().getEpochSecond());
        assertEquals(1646910000L, mtpEntryDigest.getPlannedItemValidityStop().getEpochSecond());
        assertEquals(1646910000L, mtpEntryDigest.getDosageInstructions().getIntakePeriodStopTime().getEpochSecond());
        assertEquals(1, mtpEntryDigest.getRepeatNumber());
        assertEquals(RouteOfAdministrationAmbu.ORAL_USE, mtpEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, mtpEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NORMAL, mtpEntryDigest.getDosageInstructions().getType());
        assertEquals(1, mtpEntryDigest.getDosageInstructions().getIntakes().size());
        assertNull(mtpEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, mtpEntryDigest.getProduct());
        assertEquals("7680531520746", mtpEntryDigest.getProduct().getGtinCode());
        assertEquals("7680531520746", mtpEntryDigest.getProduct().getPackageGtinCode());
        assertNull(mtpEntryDigest.getProduct().getAtcCode());
        assertEquals("PROGRAF caps 0.5 mg 50 Stk", mtpEntryDigest.getProduct().getName());
        assertEquals("PROGRAF caps 0.5 mg 50 Stk", mtpEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.CAPSULE_HARD, mtpEntryDigest.getProduct().getFormCode());
        assertNull(mtpEntryDigest.getProduct().getLotNumber());
        assertNull(mtpEntryDigest.getProduct().getExpirationDate());
        assertNull(mtpEntryDigest.getProduct().getPackageFormCode());
        assertEquals("50", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals("732937005", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getUnit().getCodeValue());
        assertEquals(1, mtpEntryDigest.getProduct().getIngredients().size());
        assertEquals("Tacrolimus", mtpEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("0.5", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals("732937005", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.TACROLIMUS, mtpEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getDocumentAuthor());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getSectionAuthor());

        assertNull(mtpEntryDigest.getFulfilmentInstructions());
        assertNull(mtpEntryDigest.getOriginalMtpReference());
        assertEquals("Avaler le comprimé avec de l'eau.", mtpEntryDigest.getPatientMedicationInstructions());
        assertEquals("Treatment Reason", mtpEntryDigest.getTreatmentReason());
        assertTrue(mtpEntryDigest.isSubstitutionPermitted());
        assertEquals("Annotation Comments", mtpEntryDigest.getAnnotationComment());
        assertFalse(mtpEntryDigest.isInReserve());
        assertNull(mtpEntryDigest.getQuantityToDispense());
    }

    @Test
    void testMtp6Digestion() throws Exception{
        final var mtpDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "MTP_06_valid.xml");
        final var digester = new CceDocumentDigester();
        final var digest = digester.digest(mtpDocument);

        // Document
        assertNotNull(digest);
        assertInstanceOf(EmedMtpDocumentDigest.class, digest);
        final var mtpDigest = (EmedMtpDocumentDigest) digest;
        assertNotNull(mtpDigest);
        assertEquals("00000000-0000-0000-0000-000000000006", mtpDigest.getId().toString());
        assertEquals("00000000-0000-0000-0000-000000000006", mtpDigest.getSetId().toString());
        assertEquals(1, mtpDigest.getVersion());
        assertEquals("fr-CH", mtpDigest.getLanguageCode());
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
        assertEquals(0, mtpDigest.getRecipients().get(0).getAddresses().size());
        assertInstanceOf(PatientDigest.class, mtpDigest.getPatient());
        assertEquals(1, mtpDigest.getPatient().ids().size());
        assertEquals(new QualifiedIdentifier("11111111", "2.999"), mtpDigest.getPatient().ids().get(0));
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
        assertEquals(mtpDigest.getId(), mtpEntryDigest.getDocumentId());
        assertEquals("00000000-0000-0000-0000-000000000006", mtpEntryDigest.getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000006", mtpEntryDigest.getMedicationTreatmentId().toString());
        assertEquals(EmedEntryType.MTP, mtpEntryDigest.getEmedEntryType());
        assertEquals(1322560800000L, mtpEntryDigest.getPlanningTime().toEpochMilli());
        assertEquals(1641807780000L, mtpEntryDigest.getPlannedItemValidityStart().toEpochMilli());
        assertEquals(1641807780000L, mtpEntryDigest.getDosageInstructions().getIntakePeriodStartTime().toEpochMilli());
        assertNull(mtpEntryDigest.getPlannedItemValidityStop());
        assertNull(mtpEntryDigest.getDosageInstructions().getIntakePeriodStopTime());
        assertNull(mtpEntryDigest.getRepeatNumber());
        assertEquals(RouteOfAdministrationAmbu.NASAL_USE, mtpEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, mtpEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.SPLIT, mtpEntryDigest.getDosageInstructions().getType());
        assertEquals(3, mtpEntryDigest.getDosageInstructions().getIntakes().size());
        assertEquals(TimingEventAmbu.MORNING, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getEventTiming());
        assertEquals("2.0", mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getDosageInstructions().getIntakes().get(0).getDoseQuantity().getUnit());
        assertEquals(TimingEventAmbu.NOON, mtpEntryDigest.getDosageInstructions().getIntakes().get(1).getEventTiming());
        assertEquals("1.0", mtpEntryDigest.getDosageInstructions().getIntakes().get(1).getDoseQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getDosageInstructions().getIntakes().get(1).getDoseQuantity().getUnit());
        assertEquals(TimingEventAmbu.EVENING, mtpEntryDigest.getDosageInstructions().getIntakes().get(2).getEventTiming());
        assertEquals("2.0", mtpEntryDigest.getDosageInstructions().getIntakes().get(2).getDoseQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getDosageInstructions().getIntakes().get(2).getDoseQuantity().getUnit());
        assertNull(mtpEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, mtpEntryDigest.getProduct());
        assertEquals("7680541890365", mtpEntryDigest.getProduct().getGtinCode());
        assertEquals("7680541890365", mtpEntryDigest.getProduct().getPackageGtinCode());
        assertNull(mtpEntryDigest.getProduct().getAtcCode());
        assertEquals("NASONEX spray nasal doseur 50 mcg", mtpEntryDigest.getProduct().getName());
        assertEquals("NASONEX spray nasal doseur 50 mcg", mtpEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.NASAL_SPRAY_SOLUTION, mtpEntryDigest.getProduct().getFormCode());
        assertNull(mtpEntryDigest.getProduct().getLotNumber());
        assertNull(mtpEntryDigest.getProduct().getExpirationDate());
        assertNull(mtpEntryDigest.getProduct().getPackageFormCode());
        assertEquals("140", mtpEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getProduct().getPackageCapacityQuantity().getUnit());
        assertEquals(1, mtpEntryDigest.getProduct().getIngredients().size());
        assertEquals("Mometasone", mtpEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("50", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.UG, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals(RegularUnitCodeAmbu.DOSE, mtpEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit());
        assertEquals(ActivePharmaceuticalIngredient.MOMETASONE, mtpEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getDocumentAuthor());
        assertEquals(mtpDigest.getAuthors().get(0), mtpEntryDigest.getSectionAuthor());

        assertNull(mtpEntryDigest.getFulfilmentInstructions());
        assertNull(mtpEntryDigest.getOriginalMtpReference());
        assertEquals("Appliquer une dose dans chaque narine.", mtpEntryDigest.getPatientMedicationInstructions());
        assertEquals("Treatment Reason", mtpEntryDigest.getTreatmentReason());
        assertTrue(mtpEntryDigest.isSubstitutionPermitted());
        assertNull(mtpEntryDigest.getAnnotationComment());
        assertFalse(mtpEntryDigest.isInReserve());
        assertNull(mtpEntryDigest.getQuantityToDispense());
    }

    @Test
    void testMissingMtpEntryTemplateId() throws Exception {
        final var mtpDocument = this.loadDoc("/Samples/ByHand/mtp/invalid/MTP_05_invalid.xml");
        final var digester = new CceDocumentDigester();

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(mtpDocument));

        mtpDocument.getComponent().getStructuredBody().getComponent().get(0).getSection().getEntry().clear();
        assertThrows(InvalidEmedContentException.class, () -> digester.digest(mtpDocument));
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CceMtpDigesterTest.class.getResourceAsStream("/CDA-CH-EMED"
                + docName));
    }
}
