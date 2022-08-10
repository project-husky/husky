package org.husky.emed.ch.cda.digesters;

import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.husky.emed.ch.enums.*;
import org.husky.emed.ch.models.common.*;
import org.husky.emed.ch.models.document.EmedPreDocumentDigest;
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
 * Tests of the {@link CcePreEntryDigester} class.
 *
 * @author Ronaldo Loureiro
 */
class CcePreDigesterTest {

    final String DIR_E_HEALTH_SUISSE = "/eHealthSuisse/v1.0/";
    final String DIR_SAMPLES_BY_HAND = "/Samples/ByHand/pre/valid/";

    @Test
    void testPreDigester() throws Exception {
        final var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND + "PRE_01_valid.xml");
        final var digester = new CceDocumentDigester(new CcePreDigesterTest.EmedEntryDigestServiceImpl());
        final var digest = digester.digest(preDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPreDocumentDigest.class, digest);
        final var preDigest = (EmedPreDocumentDigest) digest;

        // Document

        assertEquals("00E00000-0000-0000-0000-000000000001", preDigest.getId().toString().toUpperCase());
        assertEquals("00E00000-0000-0000-0000-000000000001", preDigest.getSetId().toString().toUpperCase());
        assertEquals(1, preDigest.getVersion());
        assertEquals("en-US", preDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, preDigest.getConfidentialityCode());
        assertEquals(1641033240L, preDigest.getCreationTime().toEpochSecond());
        assertEquals(1322560800000L, preDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, preDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, preDigest.getAuthors().get(0));
        assertEquals(1322560800000L, preDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", preDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", preDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", preDigest.getAuthors().get(0).getAuthorGln());
        assertInstanceOf(OrganizationDigest.class, preDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, preDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, preDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, preDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), preDigest.getPatient().ids());
        assertEquals("Monika", preDigest.getPatient().givenName());
        assertEquals("Wegmüller", preDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, preDigest.getPatient().gender());
        assertEquals(-9728, preDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, preDigest.getCustodian());
        assertNull(preDigest.getRemarks());
        assertNotEquals(0, preDigest.getPdfRepresentation().length);
        assertEquals(1, preDigest.getRecipients().size());
        assertEquals(1, preDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", preDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", preDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", preDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());
        assertNull(preDigest.getRecipients().get(0).getAddresses().get(0).getStreetName());
        assertNull(preDigest.getRecipients().get(0).getAddresses().get(0).getHouseNumber());
        assertEquals(Instant.parse("2022-01-01T10:34:00Z"), preDigest.getPrescriptionValidityStart());
        assertNull(preDigest.getPrescriptionValidityStop());

        // Entry
        assertEquals(1, preDigest.getPreEntryDigests().size());
        final var preEntryDigest = preDigest.getPreEntryDigests().get(0);
        assertNotNull(preEntryDigest);
        assertEquals(0, preEntryDigest.getSequence());
        assertEquals(preDigest.getId(), preEntryDigest.getDocumentId());
        assertEquals("00E00000-0000-0000-0000-000000000001", preEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals("00E00000-0000-0000-0000-000000000001", preEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PRE, preEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-01-10T11:00:00.00Z"), preEntryDigest.getItemValidityStart());
        assertEquals(Instant.parse("2022-03-10T11:00:00.00Z"), preEntryDigest.getItemValidityStop());
        assertEquals(preDigest.getPrescriptionValidityStart().toEpochMilli(), preEntryDigest.getPrescriptionDocumentValidityStart().toEpochMilli());
        assertNull(preEntryDigest.getPrescriptionDocumentValidityStop());
        assertEquals(2, preEntryDigest.getRepeatNumber());
        assertEquals(RouteOfAdministrationAmbu.ORAL_USE, preEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, preEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NORMAL, preEntryDigest.getDosageInstructions().getType());
        assertEquals(1, preEntryDigest.getDosageInstructions().getIntakes().size());
        assertNull(preEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, preEntryDigest.getProduct());
        assertNull(preEntryDigest.getProduct().getGtinCode());
        assertNull(preEntryDigest.getProduct().getPackageGtinCode());
        assertEquals("J01EE01", preEntryDigest.getProduct().getAtcCode());
        assertEquals("sulfamethoxazole and trimethoprim", preEntryDigest.getProduct().getName());
        assertNull(preEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.TABLET, preEntryDigest.getProduct().getFormCode());
        assertNull(preEntryDigest.getProduct().getLotNumber());
        assertNull(preEntryDigest.getProduct().getExpirationDate());
        assertNull(preEntryDigest.getProduct().getPackageFormCode());
        assertNull(preEntryDigest.getProduct().getPackageCapacityQuantity());
        assertEquals(2, preEntryDigest.getProduct().getIngredients().size());
        assertEquals("Sulfamethoxazole", preEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("800", preEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, preEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", preEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals("732936001", preEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.SULFAMETHOXAZOLE, preEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals("Trimethoprim", preEntryDigest.getProduct().getIngredients().get(1).getName());
        assertEquals("160", preEntryDigest.getProduct().getIngredients().get(1).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, preEntryDigest.getProduct().getIngredients().get(1).getQuantityNumerator().getUnit());
        assertEquals("1", preEntryDigest.getProduct().getIngredients().get(1).getQuantityDenominator().getValue());
        assertEquals("732936001", preEntryDigest.getProduct().getIngredients().get(1).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.TRIMETHOPRIM, preEntryDigest.getProduct().getIngredients().get(1).getCode());
        assertEquals(preDigest.getAuthors().get(0), preEntryDigest.getDocumentAuthor());
        assertEquals(preDigest.getAuthors().get(0), preEntryDigest.getSectionAuthor());

        assertEquals("Treatment Reason", preEntryDigest.getTreatmentReason());
        assertNotNull(preEntryDigest.getMtpReference());
        assertEquals("00000000-0000-0000-0000-000000000004", preEntryDigest.getMtpReference().getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000004", preEntryDigest.getMtpReference().getDocumentId().toString());
        assertNull(preEntryDigest.getFulfilmentInstructions());
        assertNull(preEntryDigest.getPatientMedicationInstructions());
        assertEquals("2", preEntryDigest.getQuantityToDispense());
        assertNull(preEntryDigest.getRenewalPeriod());
        assertNull(preEntryDigest.getAnnotationComment());




    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CcePreDigesterTest.class.getResourceAsStream("/CDA-CH-EMED"
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