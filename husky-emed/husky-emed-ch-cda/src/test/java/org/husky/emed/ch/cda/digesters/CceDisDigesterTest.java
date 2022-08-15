package org.husky.emed.ch.cda.digesters;

import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.husky.emed.ch.enums.ActivePharmaceuticalIngredient;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.enums.PharmaceuticalDoseFormEdqm;
import org.husky.emed.ch.enums.RegularUnitCodeAmbu;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.*;
import org.husky.emed.ch.models.document.EmedDisDocumentDigest;
import org.husky.emed.ch.models.entry.EmedEntryDigest;
import org.husky.emed.ch.models.treatment.MedicationProduct;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link CceDisEntryDigester} class.
 *
 * @author Ronaldo Loureiro
 */
class CceDisDigesterTest {

    final String DIR_E_HEALTH_SUISSE = "/eHealthSuisse/v1.0/";
    final String DIR_SAMPLES_BY_HAND = "/Samples/ByHand/dis/";

    @Test
    void testWithoutLoadDisDigester() throws Exception {
        final var digester = new CceDocumentDigester();
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "valid/DIS_01_valid.xml");

        assertThrows(NullPointerException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testDisDigester1() throws Exception {

        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "valid/DIS_01_valid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());
        final var digest = digester.digest(disDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedDisDocumentDigest.class, digest);
        final var disDigest = (EmedDisDocumentDigest) digest;


        // Document

        assertEquals("D0000000-0000-0000-0000-000000000001", disDigest.getId().toString().toUpperCase());
        assertEquals("D0000000-0000-0000-0000-000000000001", disDigest.getSetId().toString().toUpperCase());
        assertEquals(1, disDigest.getVersion());
        assertEquals("fr-CH", disDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, disDigest.getConfidentialityCode());
        assertEquals(1641033540L, disDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, disDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, disDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, disDigest.getAuthors().get(0));
        assertEquals(1328360400000L, disDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", disDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", disDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", disDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, disDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, disDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, disDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, disDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, disDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), disDigest.getPatient().ids());
        assertEquals("Monika", disDigest.getPatient().givenName());
        assertEquals("Wegmüller", disDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, disDigest.getPatient().gender());
        assertEquals(-9728, disDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, disDigest.getCustodian());
        assertNull(disDigest.getRemarks());
        assertEquals(0, disDigest.getPdfRepresentation().length);
        assertEquals(1, disDigest.getRecipients().size());
        assertEquals(1, disDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", disDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", disDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", disDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());
        assertNull(disDigest.getRecipients().get(0).getAddresses().get(0).getStreetName());
        assertNull(disDigest.getRecipients().get(0).getAddresses().get(0).getHouseNumber());

        // Entry
        final var disEntryDigest = disDigest.getDisEntryDigest();
        assertNotNull(disEntryDigest);
        assertEquals(0, disEntryDigest.getSequence());
        assertEquals(disDigest.getId(), disEntryDigest.getDocumentId());
        assertEquals("D0000000-0000-0000-0000-000000000001", disEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals("D0000000-0000-0000-0000-000000000001", disEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.DIS, disEntryDigest.getEmedEntryType());
        assertEquals("1", disEntryDigest.getQuantityValue());
        assertNull(disEntryDigest.getQuantityUnit());
        assertInstanceOf(MedicationDosageInstructions.class, disEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NORMAL, disEntryDigest.getDosageInstructions().getType());
        assertEquals(1, disEntryDigest.getDosageInstructions().getIntakes().size());
        assertEquals(Instant.parse("2022-01-10T11:00:00.00Z").getEpochSecond(), disEntryDigest.getDosageInstructions().getIntakePeriodStartTime().getEpochSecond());
        assertEquals(Instant.parse("2022-03-10T11:00:00.00Z").getEpochSecond(), disEntryDigest.getDosageInstructions().getIntakePeriodStopTime().getEpochSecond());
        assertNull(disEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, disEntryDigest.getProduct());
        assertEquals("7680531520746", disEntryDigest.getProduct().getGtinCode());
        assertEquals("7680531520746", disEntryDigest.getProduct().getPackageGtinCode());
        assertNull(disEntryDigest.getProduct().getAtcCode());
        assertEquals("PROGRAF caps 0.5 mg 50 Stk", disEntryDigest.getProduct().getName());
        assertEquals("PROGRAF caps 0.5 mg 50 Stk", disEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.CAPSULE_HARD, disEntryDigest.getProduct().getFormCode());
        assertNull(disEntryDigest.getProduct().getLotNumber());
        assertNull(disEntryDigest.getProduct().getExpirationDate());
        assertNull(disEntryDigest.getProduct().getPackageFormCode());
        assertEquals("50", disEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals("732937005", disEntryDigest.getProduct().getPackageCapacityQuantity().getUnit().getCodeValue());
        assertEquals(1, disEntryDigest.getProduct().getIngredients().size());
        assertEquals("Tacrolimus", disEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("0.5", disEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, disEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", disEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals("732937005", disEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.TACROLIMUS, disEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals(disDigest.getAuthors().get(0), disEntryDigest.getDocumentAuthor());
        assertEquals(disDigest.getAuthors().get(0), disEntryDigest.getSectionAuthor());

        assertNotNull(disEntryDigest.getPreEntryRef());
        assertEquals("00E00000-0000-0000-0000-000000000001", disEntryDigest.getPreEntryRef().getEntryId().toString().toUpperCase());
        assertEquals("00E00000-0000-0000-0000-000000000001", disEntryDigest.getPreEntryRef().getDocumentId().toString().toUpperCase());
    }

    @Test
    void testDisDigester2() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "valid/DIS_02_valid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());
        final var digest = digester.digest(disDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedDisDocumentDigest.class, digest);
        final var disDigest = (EmedDisDocumentDigest) digest;

        // Document
        assertEquals("D0000000-0000-0000-0000-000000000002", disDigest.getId().toString().toUpperCase());
        assertEquals("D0000000-0000-0000-0000-000000000002", disDigest.getSetId().toString().toUpperCase());
        assertEquals(1, disDigest.getVersion());
        assertEquals("fr-CH", disDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, disDigest.getConfidentialityCode());
        assertEquals(1641033540L, disDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, disDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, disDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, disDigest.getAuthors().get(0));
        assertEquals(1328360400000L, disDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", disDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", disDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", disDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, disDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, disDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, disDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, disDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, disDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), disDigest.getPatient().ids());
        assertEquals("Monika", disDigest.getPatient().givenName());
        assertEquals("Wegmüller", disDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, disDigest.getPatient().gender());
        assertEquals(-9728, disDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, disDigest.getCustodian());
        assertNull(disDigest.getRemarks());
        assertEquals(0, disDigest.getPdfRepresentation().length);
        assertEquals(1, disDigest.getRecipients().size());
        assertEquals(1, disDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", disDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", disDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", disDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());
        assertNull(disDigest.getRecipients().get(0).getAddresses().get(0).getStreetName());
        assertNull(disDigest.getRecipients().get(0).getAddresses().get(0).getHouseNumber());

        // Entry
        final var disEntryDigest = disDigest.getDisEntryDigest();
        assertNotNull(disEntryDigest);
        assertEquals(EmedEntryType.DIS, disEntryDigest.getEmedEntryType());
        assertEquals(0, disEntryDigest.getSequence());
        assertEquals(disDigest.getId(), disEntryDigest.getDocumentId());
        assertEquals("D0000000-0000-0000-0000-000000000002", disEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals("D0000000-0000-0000-0000-000000000002", disEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals("1", disEntryDigest.getQuantityValue());
        assertEquals("732997007", disEntryDigest.getQuantityUnit().getCodeValue());
        assertNull(disEntryDigest.getDosageInstructions());
        assertInstanceOf(MedicationProduct.class, disEntryDigest.getProduct());
        assertEquals("7680541890365", disEntryDigest.getProduct().getGtinCode());
        assertNull(disEntryDigest.getProduct().getPackageGtinCode());
        assertNull(disEntryDigest.getProduct().getAtcCode());
        assertEquals("NASONEX spray nasal doseur 50 mcg", disEntryDigest.getProduct().getName());
        assertNull(disEntryDigest.getProduct().getPackageName());
        assertNull(disEntryDigest.getProduct().getFormCode());
        assertNull(disEntryDigest.getProduct().getLotNumber());
        assertNull(disEntryDigest.getProduct().getExpirationDate());
        assertNull(disEntryDigest.getProduct().getPackageFormCode());
        assertNull(disEntryDigest.getProduct().getPackageCapacityQuantity());
        assertEquals(0, disEntryDigest.getProduct().getIngredients().size());
        assertEquals(disDigest.getAuthors().get(0), disEntryDigest.getDocumentAuthor());
        assertEquals(disDigest.getAuthors().get(0), disEntryDigest.getSectionAuthor());
        assertNull(disEntryDigest.getPreEntryRef());
        assertFalse(disEntryDigest.isInReserve());
        assertTrue(disEntryDigest.isOtc());
    }

    @Test
    void testMissingEntry() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "valid/DIS_02_valid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        disDocument.getComponent().getStructuredBody().getComponent().get(0).getSection().getEntry().clear();
        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testBadFillCode() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "invalid/DIS_02_invalid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testBadCodeSystemInFillCode() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "invalid/DIS_03_invalid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testMissingQuantity() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "invalid/DIS_04_invalid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testMissingManufacturedMaterial() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "valid/DIS_01_valid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        disDocument.getComponent().getStructuredBody().getComponent().get(0).getSection().getEntry().get(0).getSupply()
                .getProduct().getManufacturedProduct().setManufacturedMaterial(null);

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CceDisDigesterTest.class.getResourceAsStream("/CDA-CH-EMED"
                + docName));
    }

    public static class EmedEntryDigestServiceImpl implements EmedEntryDigestService {

        private final List<EmedEntryDigest> digests = new ArrayList<>();

        @Override
        public Optional<EmedEntryDigest> getById(UUID entryId) {
            return this.digests.stream().filter(digest -> digest.getEntryId().equals(entryId)).findAny();
        }

        @Override
        public int getSequence(UUID medicationTreatmentId, Instant creationTime) {
            return 0;
        }

        public void add(EmedEntryDigest digest) {
            this.digests.add(digest);
        }

        public void addAll(List<EmedEntryDigest> digests) {
            this.digests.addAll(digests);
        }
    }
}