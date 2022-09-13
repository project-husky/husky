package org.husky.emed.ch.cda.digesters;

import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.POCDMT000040Supply;
import org.husky.common.utils.xml.XmlFactories;
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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
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
    final String DIR_SAMPLES_BY_HAND_DIS = "/Samples/ByHand/dis/";
    final String DIR_SAMPLES_BY_HAND_MTP = "/Samples/ByHand/mtp/valid/";
    final String DIR_SAMPLES_BY_HAND_PRE = "/Samples/ByHand/pre/valid/";

    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040Supply.class;
    private final Unmarshaller UNMARSHALLER;

    public CceDisDigesterTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testWithoutLoadDisDigester() throws Exception {
        final var digester = new CceDocumentDigester();
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_DIS + "valid/DIS_01_valid.xml");

        assertThrows(NullPointerException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testDisDigester1() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_PRE + "PRE_01_valid.xml", digester));

        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_DIS + "valid/DIS_01_valid.xml");
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

        // Entry
        final var disEntryDigest = disDigest.getDisEntryDigest();
        assertNotNull(disEntryDigest);
        assertEquals(0, disEntryDigest.getSequence());
        assertEquals(disDigest.getId(), disEntryDigest.getDocumentId());
        assertEquals("D0000000-0000-0000-0000-000000000001", disEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals("00E00000-0000-0000-0000-000000000001", disEntryDigest.getPreEntryRef().getEntryId().toString().toUpperCase());
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
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_DIS + "valid/DIS_02_valid.xml");
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
    void testDisDigester3() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_E_HEALTH_SUISSE + "1-1-MedicationTreatmentPlan.xml", digester));

        final var disDocument = this.loadDoc(DIR_E_HEALTH_SUISSE + "1-2-MedicationDispense.xml");
        final var digest = digester.digest(disDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedDisDocumentDigest.class, digest);
        final var disDigest = (EmedDisDocumentDigest) digest;

        // Document
        assertEquals("488BD23A-20C6-11E6-B67B-9E71128CAE77", disDigest.getId().toString().toUpperCase());
        assertEquals("488BD23A-20C6-11E6-B67B-9E71128CAE77", disDigest.getSetId().toString().toUpperCase());
        assertEquals(1, disDigest.getVersion());
        assertEquals("de-CH", disDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, disDigest.getConfidentialityCode());
        assertEquals(1322560860L, disDigest.getCreationTime().toEpochSecond());
        assertEquals(1322560800000L, disDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, disDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, disDigest.getAuthors().get(0));
        assertEquals(1322560800000L, disDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
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

        // Entry
        final var disEntryDigest = disDigest.getDisEntryDigest();
        assertNotNull(disEntryDigest);
        assertEquals(0, disEntryDigest.getSequence());
        assertEquals(disDigest.getId(), disEntryDigest.getDocumentId());
        assertEquals("488BD23A-20C6-11E6-B67B-9E71128CAE77", disEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.DIS, disEntryDigest.getEmedEntryType());
        assertEquals("1", disEntryDigest.getQuantityValue());
        assertNull(disEntryDigest.getQuantityUnit());
        assertInstanceOf(MedicationDosageInstructions.class, disEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NORMAL, disEntryDigest.getDosageInstructions().getType());
        assertEquals(1, disEntryDigest.getDosageInstructions().getIntakes().size());
        assertEquals(Instant.parse("2011-11-29T00:00:00.00Z").getEpochSecond(), disEntryDigest.getDosageInstructions().getIntakePeriodStartTime().getEpochSecond());
        assertNull(disEntryDigest.getDosageInstructions().getIntakePeriodStopTime());
        assertNull(disEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, disEntryDigest.getProduct());
        assertEquals("7680538751228", disEntryDigest.getProduct().getGtinCode());
        assertEquals("7680538751228", disEntryDigest.getProduct().getPackageGtinCode());
        assertNull(disEntryDigest.getProduct().getAtcCode());
        assertEquals("TRIATEC Tabl 2.5 mg", disEntryDigest.getProduct().getName());
        assertEquals("TRIATEC Tabl 2.5 mg", disEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.TABLET, disEntryDigest.getProduct().getFormCode());
        assertNull(disEntryDigest.getProduct().getLotNumber());
        assertNull(disEntryDigest.getProduct().getExpirationDate());
        assertEquals(PharmaceuticalDoseFormEdqm.TABLET, disEntryDigest.getProduct().getPackageFormCode());
        assertEquals("20", disEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals("732936001", disEntryDigest.getProduct().getPackageCapacityQuantity().getUnit().getCodeValue());
        assertEquals(1, disEntryDigest.getProduct().getIngredients().size());
        assertEquals("Ramipril", disEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("2.5", disEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, disEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", disEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals("732936001", disEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.RAMIPRIL, disEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals(disDigest.getAuthors().get(0), disEntryDigest.getDocumentAuthor());
        assertEquals(disDigest.getAuthors().get(0), disEntryDigest.getSectionAuthor());

        assertNull(disEntryDigest.getPreEntryRef());
        assertEquals("C9F758A1-296C-4710-84D4-E181DB8C7478", disEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
    }

    @Test
    void testMissingEntry() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_DIS + "valid/DIS_02_valid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        disDocument.getComponent().getStructuredBody().getComponent().get(0).getSection().getEntry().clear();
        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testBadFillCode() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_DIS + "invalid/DIS_02_invalid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testBadCodeSystemInFillCode() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_DIS + "invalid/DIS_03_invalid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testMissingQuantity() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_DIS + "invalid/DIS_04_invalid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testMissingManufacturedMaterial() throws Exception {
        final var disDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_DIS + "valid/DIS_01_valid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        disDocument.getComponent().getStructuredBody().getComponent().get(0).getSection().getEntry().get(0).getSupply()
                .getProduct().getManufacturedProduct().setManufacturedMaterial(null);

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(disDocument));
    }

    @Test
    void testMissingEntryId() throws Exception {
        var supply = """
                <templateId root="2.16.756.5.30.1.1.10.4.42" />
                <templateId root="1.3.6.1.4.1.19376.1.9.1.3.4" />
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.3" />
                <templateId root="2.16.840.1.113883.10.20.1.34" />
                <!-- Missing ID -->
                <text>
                    <reference value="#dis.content" />
                </text>
                <quantity value="1" unit="732997007" />
                <product>
                    <manufacturedProduct classCode="MANU">
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.2" />
                        <templateId root="2.16.840.1.113883.10.20.1.53" />
                        <manufacturedMaterial classCode="MMAT" determinerCode="KIND">
                            <templateId root="2.16.756.5.30.1.1.10.4.33" />
                            <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1" />
                            <code code="7680541890365" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="NASONEX spray nasal doseur 50 mcg" />
                            <name>NASONEX spray nasal doseur 50 mcg</name>
                        </manufacturedMaterial>
                    </manufacturedProduct>
                </product>
                """;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();

        assertThrows(InvalidEmedContentException.class, () -> new CceDisEntryDigester(emedEntryDigestServiceImpl).createDigest(this.unmarshall(supply),
                UUID.randomUUID(),
                Instant.now(),
                null,
                null)
        );
    }

    @Test
    void testAuthorInSupply() throws Exception {
        var sectionAuthor = """
                <author>
                    <templateId root="2.16.756.5.30.1.1.10.9.23" />
                    <time value="20111129110000+0100" />
                    <assignedAuthor>
                        <id root="2.51.1.3" extension="7601000234438" />
                        <assignedPerson>
                            <name>
                                <family>Hausarzt</family>
                                <given>Familien</given>
                            </name>
                        </assignedPerson>
                    </assignedAuthor>
                </author>
                """;

        var documentAuthor = """
                <author>
                    <templateId root="2.16.756.5.30.1.1.10.9.23" />
                    <time value="20111129110000+0100" />
                    <assignedAuthor>
                        <id root="2.51.1.3" extension="7601000234438" />
                        <assignedPerson>
                            <name>
                                <family>Zarsauh</family>
                                <given>Familien</given>
                            </name>
                        </assignedPerson>
                    </assignedAuthor>
                </author>
                """;

        var supply = """
                <templateId root="2.16.756.5.30.1.1.10.4.42" />
                <templateId root="1.3.6.1.4.1.19376.1.9.1.3.4" />
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.3" />
                <templateId root="2.16.840.1.113883.10.20.1.34" />
                <id root="D0000000-0000-0000-0000-000000000002" />
                <text>
                    <reference value="#dis.content" />
                </text>
                <quantity value="1" unit="732997007" />
                <product>
                    <manufacturedProduct classCode="MANU">
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.2" />
                        <templateId root="2.16.840.1.113883.10.20.1.53" />
                        <manufacturedMaterial classCode="MMAT" determinerCode="KIND">
                            <templateId root="2.16.756.5.30.1.1.10.4.33" />
                            <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1" />
                            <code code="7680541890365" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="NASONEX spray nasal doseur 50 mcg" />
                            <name>NASONEX spray nasal doseur 50 mcg</name>
                        </manufacturedMaterial>
                    </manufacturedProduct>
                </product>
                """ + sectionAuthor;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();

        var digest = new CceDisEntryDigester(emedEntryDigestServiceImpl).createDigest(this.unmarshall(supply),
                UUID.randomUUID(),
                Instant.now(),
                null,
                null);

        assertEquals(digest.getSectionAuthor(), digest.getDocumentAuthor());

        supply += documentAuthor;
        digest = new CceDisEntryDigester(emedEntryDigestServiceImpl).createDigest(this.unmarshall(supply),
                UUID.randomUUID(),
                Instant.now(),
                null,
                null);

        assertNotEquals(digest.getSectionAuthor().getFamilyName(), digest.getDocumentAuthor().getFamilyName());
    }

    @Test
    void testMedicationDispensedQuantity() throws Exception {
        var supply1 = """
                <templateId root="2.16.756.5.30.1.1.10.4.42" />
                <templateId root="1.3.6.1.4.1.19376.1.9.1.3.4" />
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.3" />
                <templateId root="2.16.840.1.113883.10.20.1.34" />
                <id root="D0000000-0000-0000-0000-000000000002" />
                <text>
                    <reference value="#dis.content" />
                </text>
                <!-- value and unit blank -->
                <quantity value="" unit="" />
                <product>
                    <manufacturedProduct classCode="MANU">
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.2" />
                        <templateId root="2.16.840.1.113883.10.20.1.53" />
                        <manufacturedMaterial classCode="MMAT" determinerCode="KIND">
                            <templateId root="2.16.756.5.30.1.1.10.4.33" />
                            <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1" />
                            <code code="7680541890365" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="NASONEX spray nasal doseur 50 mcg" />
                            <name>NASONEX spray nasal doseur 50 mcg</name>
                        </manufacturedMaterial>
                    </manufacturedProduct>
                </product>""";

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();

        assertThrows(InvalidEmedContentException.class, () -> new CceDisEntryDigester(emedEntryDigestServiceImpl)
                .createDigest(this.unmarshall(supply1),
                UUID.randomUUID(),
                Instant.now(),
                null,
                null));

        var supply2 = """
                <templateId root="2.16.756.5.30.1.1.10.4.42" />
                <templateId root="1.3.6.1.4.1.19376.1.9.1.3.4" />
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.3" />
                <templateId root="2.16.840.1.113883.10.20.1.34" />
                <id root="D0000000-0000-0000-0000-000000000002" />
                <text>
                    <reference value="#dis.content" />
                </text>
                <!-- value and unit null -->
                <quantity />
                <product>
                    <manufacturedProduct classCode="MANU">
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.2" />
                        <templateId root="2.16.840.1.113883.10.20.1.53" />
                        <manufacturedMaterial classCode="MMAT" determinerCode="KIND">
                            <templateId root="2.16.756.5.30.1.1.10.4.33" />
                            <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1" />
                            <code code="7680541890365" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="NASONEX spray nasal doseur 50 mcg" />
                            <name>NASONEX spray nasal doseur 50 mcg</name>
                        </manufacturedMaterial>
                    </manufacturedProduct>
                </product>""";

        assertThrows(InvalidEmedContentException.class, () -> new CceDisEntryDigester(emedEntryDigestServiceImpl)
                .createDigest(this.unmarshall(supply2),
                        UUID.randomUUID(),
                        Instant.now(),
                        null,
                        null));
    }

    @Test
    void testInReserve() throws Exception {
        var supply = """
                <templateId root="2.16.756.5.30.1.1.10.4.42" />
                <templateId root="1.3.6.1.4.1.19376.1.9.1.3.4" />
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.3" />
                <templateId root="2.16.840.1.113883.10.20.1.34" />
                <id root="D0000000-0000-0000-0000-000000000002" />
                <text>
                    <reference value="#dis.content" />
                </text>
                <quantity value="1" unit="732997007" />
                <product>
                    <manufacturedProduct classCode="MANU">
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.2" />
                        <templateId root="2.16.840.1.113883.10.20.1.53" />
                        <manufacturedMaterial classCode="MMAT" determinerCode="KIND">
                            <templateId root="2.16.756.5.30.1.1.10.4.33" />
                            <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1" />
                            <code code="7680541890365" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="NASONEX spray nasal doseur 50 mcg" />
                            <name>NASONEX spray nasal doseur 50 mcg</name>
                        </manufacturedMaterial>
                    </manufacturedProduct>
                </product>
                """;

        var erAsRequired = """
                <entryRelationship typeCode="COMP">
                    <act classCode="ACT" moodCode="DEF">
                        <templateId root="2.16.756.5.30.1.1.10.10" />
                        <code code="225761000" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED Clinical Terms" displayName="As required (qualifier value)" />
                        <statusCode code="completed" />
                    </act>
                </entryRelationship>""";

        var erRegular = """
                <entryRelationship typeCode="COMP">
                    <act classCode="ACT" moodCode="DEF">
                        <templateId root="2.16.756.5.30.1.1.10.10" />
                        <code code="17854005" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED Clinical Terms" displayName="Regular (qualifier value)" />
                        <statusCode code="completed" />
                    </act>
                </entryRelationship>""";

        var erWithoutCode = """
                <entryRelationship typeCode="COMP">
                    <act classCode="ACT" moodCode="DEF">
                        <templateId root="2.16.756.5.30.1.1.10.10" />
                        <!-- Missing Code -->
                        <statusCode code="completed" />
                    </act>
                </entryRelationship>""";

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();

        var digest = new CceDisEntryDigester(emedEntryDigestServiceImpl)
                .createDigest(this.unmarshall(supply + erAsRequired),
                        UUID.randomUUID(),
                        Instant.now(),
                        null,
                        null);

        assertTrue(digest.isInReserve());

        digest = new CceDisEntryDigester(emedEntryDigestServiceImpl)
                .createDigest(this.unmarshall(supply + erRegular),
                        UUID.randomUUID(),
                        Instant.now(),
                        null,
                        null);

        assertFalse(digest.isInReserve());

        digest = new CceDisEntryDigester(emedEntryDigestServiceImpl)
                .createDigest(this.unmarshall(supply + erWithoutCode),
                        UUID.randomUUID(),
                        Instant.now(),
                        null,
                        null);

        assertFalse(digest.isInReserve());
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CceDisDigesterTest.class.getResourceAsStream("/CDA-CH-EMED"
                + docName));
    }

    private POCDMT000040Supply unmarshall(final String supply) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<supply classCode=\"SPLY\" moodCode=\"EVN\" xmlns:pharm=\"urn:ihe:pharm\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + supply
                + "</supply>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, POCDMT000040Supply.class);
        return (POCDMT000040Supply) JAXBIntrospector.getValue(root);
    }

    private List<EmedEntryDigest> getEntryDigests(String docPath, CceDocumentDigester digester) throws Exception {
        final var document = this.loadDoc(docPath);
        return digester.digest(document).getEntryDigests();
    }

    private static class EmedEntryDigestServiceImpl implements EmedEntryDigestService {

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
