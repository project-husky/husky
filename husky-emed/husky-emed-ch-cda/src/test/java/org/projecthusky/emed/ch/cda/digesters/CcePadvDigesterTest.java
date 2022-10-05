package org.projecthusky.emed.ch.cda.digesters;

import org.projecthusky.common.ch.enums.stable.ConfidentialityCode;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.emed.ch.cda.services.EmedEntryDigestService;
import org.projecthusky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.projecthusky.emed.ch.enums.EmedEntryType;
import org.projecthusky.emed.ch.enums.TimingEventAmbu;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
import org.projecthusky.emed.ch.models.common.*;
import org.projecthusky.emed.ch.models.document.EmedPadvDocumentDigest;
import org.projecthusky.emed.ch.models.entry.EmedEntryDigest;
import org.projecthusky.emed.ch.models.entry.padv.*;
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

class CcePadvDigesterTest {

    final String DIR_E_HEALTH_SUISSE = "/eHealthSuisse/v1.0/";
    final String DIR_SAMPLES_BY_HAND_PADV = "/Samples/ByHand/padv/";
    final String DIR_SAMPLES_BY_HAND_MTP = "/Samples/ByHand/mtp/valid/";
    final String DIR_SAMPLES_BY_HAND_PRE = "/Samples/ByHand/pre/valid/";
    final String DIR_SAMPLES_BY_HAND_DIS = "/Samples/ByHand/dis/valid/";

    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040Observation.class;
    private final Unmarshaller UNMARSHALLER;

    public CcePadvDigesterTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testWithoutLoadPadvDigester() throws Exception {
        final var digester = new CceDocumentDigester();
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_01_valid.xml");

        assertThrows(NullPointerException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testPadvOk() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_01_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_01_valid.xml");
        final var digest = digester.digest(padvDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPadvDocumentDigest.class, digest);
        final var padvDigest = (EmedPadvDocumentDigest) digest;

        // Document
        assertEquals("0AD00000-0000-0000-0000-000000000001", padvDigest.getId().toString().toUpperCase());
        assertEquals("0AD00000-0000-0000-0000-000000000001", padvDigest.getSetId().toString().toUpperCase());
        assertEquals(1, padvDigest.getVersion());
        assertEquals("fr-CH", padvDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, padvDigest.getConfidentialityCode());
        assertEquals(1641977280L, padvDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, padvDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, padvDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, padvDigest.getAuthors().get(0));
        assertEquals(1328360400000L, padvDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", padvDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", padvDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", padvDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, padvDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, padvDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, padvDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, padvDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), padvDigest.getPatient().ids());
        assertEquals("Monika", padvDigest.getPatient().givenName());
        assertEquals("Wegmüller", padvDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, padvDigest.getPatient().gender());
        assertEquals(-9728, padvDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getCustodian());
        assertNull(padvDigest.getRemarks());
        assertEquals(0, padvDigest.getPdfRepresentation().length);
        assertEquals(1, padvDigest.getRecipients().size());
        assertEquals(1, padvDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", padvDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", padvDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", padvDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());

        // Entry
        assertNotNull(padvDigest.getPadvEntryDigest());
        assertInstanceOf(EmedPadvOkEntryDigest.class, padvDigest.getPadvEntryDigest());
        final var padvEntryDigest = (EmedPadvOkEntryDigest) padvDigest.getPadvEntryDigest();
        assertEquals(0, padvEntryDigest.getSequence());
        assertEquals(padvDigest.getId(), padvEntryDigest.getDocumentId());
        assertEquals("0AD00000-0000-0000-0000-000000000001", padvEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.MTP, padvEntryDigest.getTargetedEntryType());
        assertEquals("00000000-0000-0000-0000-000000000001", padvEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PADV, padvEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-02-01T00:00:00.00Z"), padvEntryDigest.getEffectiveTime());
        assertEquals(padvDigest.getDocumentationTime(), padvEntryDigest.getPharmaceuticalAdviceTime());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getDocumentAuthor());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getSectionAuthor());
        assertTrue(padvEntryDigest.isCompleted());
        assertNull(padvEntryDigest.getAnnotationComment());
        assertEquals(0, padvEntryDigest.getRecommendedPrescriptions().size());
    }

    @Test
    void testPadvChangeDis() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_DIS + "DIS_01_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_02_valid.xml");
        final var digest = digester.digest(padvDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPadvDocumentDigest.class, digest);
        final var padvDigest = (EmedPadvDocumentDigest) digest;

        // Document
        assertEquals("0AD00000-0000-0000-0000-000000000002", padvDigest.getId().toString().toUpperCase());
        assertEquals("0AD00000-0000-0000-0000-000000000002", padvDigest.getSetId().toString().toUpperCase());
        assertEquals(1, padvDigest.getVersion());
        assertEquals("fr-CH", padvDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, padvDigest.getConfidentialityCode());
        assertEquals(1641977280L, padvDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, padvDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, padvDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, padvDigest.getAuthors().get(0));
        assertEquals(1328360400000L, padvDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", padvDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", padvDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", padvDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, padvDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, padvDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, padvDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, padvDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), padvDigest.getPatient().ids());
        assertEquals("Monika", padvDigest.getPatient().givenName());
        assertEquals("Wegmüller", padvDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, padvDigest.getPatient().gender());
        assertEquals(-9728, padvDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getCustodian());
        assertNull(padvDigest.getRemarks());
        assertEquals(0, padvDigest.getPdfRepresentation().length);
        assertEquals(1, padvDigest.getRecipients().size());
        assertEquals(1, padvDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", padvDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", padvDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", padvDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());

        // Entry
        assertNotNull(padvDigest.getPadvEntryDigest());
        assertInstanceOf(EmedPadvChangeEntryDigest.class, padvDigest.getPadvEntryDigest());
        final var padvEntryDigest = (EmedPadvChangeEntryDigest) padvDigest.getPadvEntryDigest();
        assertEquals(0, padvEntryDigest.getSequence());
        assertEquals(padvDigest.getId(), padvEntryDigest.getDocumentId());
        assertEquals("0AD00000-0000-0000-0000-000000000002", padvEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.DIS, padvEntryDigest.getTargetedEntryType());
        assertEquals("D0000000-0000-0000-0000-000000000001", padvEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PADV, padvEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-02-01T00:00:00.00Z"), padvEntryDigest.getEffectiveTime());
        assertEquals(padvDigest.getDocumentationTime(), padvEntryDigest.getPharmaceuticalAdviceTime());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getDocumentAuthor());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getSectionAuthor());
        assertFalse(padvEntryDigest.isCompleted());
        assertNull(padvEntryDigest.getAnnotationComment());

        assertNotNull(padvEntryDigest.getChangedDosageInstructions());
        var dosageInstructions = padvEntryDigest.getChangedDosageInstructions();
        assertNull(dosageInstructions.getNarrativeDosageInstructions());
        assertEquals(Instant.parse("2022-01-10T11:00:00.00Z"), dosageInstructions.getIntakePeriodStartTime());
        assertEquals(Instant.parse("2022-03-10T11:00:00.00Z"), dosageInstructions.getIntakePeriodStopTime());
        assertEquals(1, dosageInstructions.getIntakes().size());
        assertEquals(TimingEventAmbu.MORNING, dosageInstructions.getIntakes().get(0).getEventTiming());
        assertFalse(dosageInstructions.getIntake(TimingEventAmbu.NOON).isPresent());
        assertFalse(dosageInstructions.getIntake(TimingEventAmbu.EVENING).isPresent());
        assertFalse(dosageInstructions.getIntake(TimingEventAmbu.NIGHT).isPresent());
    }

    @Test
    void testPadvChangeMtp() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_01_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_07_valid.xml");
        final var digest = digester.digest(padvDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPadvDocumentDigest.class, digest);
        final var padvDigest = (EmedPadvDocumentDigest) digest;

        // Document
        assertEquals("0AD00000-0000-0000-0000-000000000007", padvDigest.getId().toString().toUpperCase());
        assertEquals("0AD00000-0000-0000-0000-000000000007", padvDigest.getSetId().toString().toUpperCase());
        assertEquals(1, padvDigest.getVersion());
        assertEquals("fr-CH", padvDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, padvDigest.getConfidentialityCode());
        assertEquals(1641977280L, padvDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, padvDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, padvDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, padvDigest.getAuthors().get(0));
        assertEquals(1328360400000L, padvDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", padvDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", padvDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", padvDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, padvDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, padvDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, padvDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, padvDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), padvDigest.getPatient().ids());
        assertEquals("Monika", padvDigest.getPatient().givenName());
        assertEquals("Wegmüller", padvDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, padvDigest.getPatient().gender());
        assertEquals(-9728, padvDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getCustodian());
        assertNull(padvDigest.getRemarks());
        assertEquals(0, padvDigest.getPdfRepresentation().length);
        assertEquals(1, padvDigest.getRecipients().size());
        assertEquals(1, padvDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", padvDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", padvDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", padvDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());

        // Entry
        assertNotNull(padvDigest.getPadvEntryDigest());
        assertInstanceOf(EmedPadvChangeEntryDigest.class, padvDigest.getPadvEntryDigest());
        final var padvEntryDigest = (EmedPadvChangeEntryDigest) padvDigest.getPadvEntryDigest();
        assertEquals(0, padvEntryDigest.getSequence());
        assertEquals(padvDigest.getId(), padvEntryDigest.getDocumentId());
        assertEquals("0AD00000-0000-0000-0000-000000000007", padvEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.MTP, padvEntryDigest.getTargetedEntryType());
        assertEquals("00000000-0000-0000-0000-000000000001", padvEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PADV, padvEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-02-01T00:00:00.00Z"), padvEntryDigest.getEffectiveTime());
        assertEquals(padvDigest.getDocumentationTime(), padvEntryDigest.getPharmaceuticalAdviceTime());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getDocumentAuthor());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getSectionAuthor());
        assertFalse(padvEntryDigest.isCompleted());
        assertNull(padvEntryDigest.getAnnotationComment());
        assertNull(padvEntryDigest.getChangedDosageInstructions());

        assertNotNull(padvEntryDigest.getChangedMtpEntry().getDosageInstructions());
        var dosageInstructions = padvEntryDigest.getChangedMtpEntry().getDosageInstructions();
        assertNull(dosageInstructions.getNarrativeDosageInstructions());
        assertEquals(Instant.parse("2022-01-10T11:00:00.00Z"), dosageInstructions.getIntakePeriodStartTime());
        assertEquals(Instant.parse("2022-03-10T11:00:00.00Z"), dosageInstructions.getIntakePeriodStopTime());
        assertEquals(2, dosageInstructions.getIntakes().size());
        assertTrue(dosageInstructions.getIntake(TimingEventAmbu.MORNING).isPresent());
        assertFalse(dosageInstructions.getIntake(TimingEventAmbu.NOON).isPresent());
        assertTrue(dosageInstructions.getIntake(TimingEventAmbu.EVENING).isPresent());
        assertFalse(dosageInstructions.getIntake(TimingEventAmbu.NIGHT).isPresent());
    }

    @Test
    void testPadvChangePre() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_PRE + "PRE_01_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_08_valid.xml");
        final var digest = digester.digest(padvDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPadvDocumentDigest.class, digest);
        final var padvDigest = (EmedPadvDocumentDigest) digest;

        // Document
        assertEquals("0AD00000-0000-0000-0000-000000000008", padvDigest.getId().toString().toUpperCase());
        assertEquals("0AD00000-0000-0000-0000-000000000008", padvDigest.getSetId().toString().toUpperCase());
        assertEquals(1, padvDigest.getVersion());
        assertEquals("fr-CH", padvDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, padvDigest.getConfidentialityCode());
        assertEquals(1641977280L, padvDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, padvDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, padvDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, padvDigest.getAuthors().get(0));
        assertEquals(1328360400000L, padvDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", padvDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", padvDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", padvDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, padvDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, padvDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, padvDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, padvDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), padvDigest.getPatient().ids());
        assertEquals("Monika", padvDigest.getPatient().givenName());
        assertEquals("Wegmüller", padvDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, padvDigest.getPatient().gender());
        assertEquals(-9728, padvDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getCustodian());
        assertNull(padvDigest.getRemarks());
        assertEquals(0, padvDigest.getPdfRepresentation().length);
        assertEquals(1, padvDigest.getRecipients().size());
        assertEquals(1, padvDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", padvDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", padvDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", padvDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());

        // Entry
        assertNotNull(padvDigest.getPadvEntryDigest());
        assertInstanceOf(EmedPadvChangeEntryDigest.class, padvDigest.getPadvEntryDigest());
        final var padvEntryDigest = (EmedPadvChangeEntryDigest) padvDigest.getPadvEntryDigest();
        assertEquals(0, padvEntryDigest.getSequence());
        assertEquals(padvDigest.getId(), padvEntryDigest.getDocumentId());
        assertEquals("0AD00000-0000-0000-0000-000000000008", padvEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.PRE, padvEntryDigest.getTargetedEntryType());
        assertEquals("00E00000-0000-0000-0000-000000000001", padvEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PADV, padvEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-02-01T00:00:00.00Z"), padvEntryDigest.getEffectiveTime());
        assertEquals(padvDigest.getDocumentationTime(), padvEntryDigest.getPharmaceuticalAdviceTime());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getDocumentAuthor());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getSectionAuthor());
        assertFalse(padvEntryDigest.isCompleted());
        assertNull(padvEntryDigest.getAnnotationComment());
        assertNull(padvEntryDigest.getChangedDosageInstructions());

        assertNotNull(padvEntryDigest.getChangedPreEntry().getDosageInstructions());
        var dosageInstructions = padvEntryDigest.getChangedPreEntry().getDosageInstructions();
        assertNull(dosageInstructions.getNarrativeDosageInstructions());
        assertEquals(Instant.parse("2022-01-10T11:00:00.00Z"), dosageInstructions.getIntakePeriodStartTime());
        assertEquals(Instant.parse("2022-03-10T11:00:00.00Z"), dosageInstructions.getIntakePeriodStopTime());
        assertEquals(1, dosageInstructions.getIntakes().size());
        assertTrue(dosageInstructions.getIntake(TimingEventAmbu.MORNING).isPresent());
        assertFalse(dosageInstructions.getIntake(TimingEventAmbu.NOON).isPresent());
        assertFalse(dosageInstructions.getIntake(TimingEventAmbu.EVENING).isPresent());
        assertFalse(dosageInstructions.getIntake(TimingEventAmbu.NIGHT).isPresent());
    }

    @Test
    void testPadvCancel() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_DIS + "DIS_01_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_03_valid.xml");
        final var digest = digester.digest(padvDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPadvDocumentDigest.class, digest);
        final var padvDigest = (EmedPadvDocumentDigest) digest;

        // Document
        assertEquals("0AD00000-0000-0000-0000-000000000003", padvDigest.getId().toString().toUpperCase());
        assertEquals("0AD00000-0000-0000-0000-000000000003", padvDigest.getSetId().toString().toUpperCase());
        assertEquals(1, padvDigest.getVersion());
        assertEquals("fr-CH", padvDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, padvDigest.getConfidentialityCode());
        assertEquals(1641977280L, padvDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, padvDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, padvDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, padvDigest.getAuthors().get(0));
        assertEquals(1328360400000L, padvDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", padvDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", padvDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", padvDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, padvDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, padvDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, padvDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, padvDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), padvDigest.getPatient().ids());
        assertEquals("Monika", padvDigest.getPatient().givenName());
        assertEquals("Wegmüller", padvDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, padvDigest.getPatient().gender());
        assertEquals(-9728, padvDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getCustodian());
        assertNull(padvDigest.getRemarks());
        assertEquals(0, padvDigest.getPdfRepresentation().length);
        assertEquals(1, padvDigest.getRecipients().size());
        assertEquals(1, padvDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", padvDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", padvDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", padvDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());

        // Entry
        assertNotNull(padvDigest.getPadvEntryDigest());
        assertInstanceOf(EmedPadvCancelEntryDigest.class, padvDigest.getPadvEntryDigest());
        final var padvEntryDigest = (EmedPadvCancelEntryDigest) padvDigest.getPadvEntryDigest();
        assertEquals(0, padvEntryDigest.getSequence());
        assertEquals(padvDigest.getId(), padvEntryDigest.getDocumentId());
        assertEquals("0AD00000-0000-0000-0000-000000000003", padvEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.DIS, padvEntryDigest.getTargetedEntryType());
        assertEquals("D0000000-0000-0000-0000-000000000001", padvEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PADV, padvEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-02-01T00:00:00.00Z"), padvEntryDigest.getEffectiveTime());
        assertEquals(padvDigest.getDocumentationTime(), padvEntryDigest.getPharmaceuticalAdviceTime());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getDocumentAuthor());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getSectionAuthor());
        assertTrue(padvEntryDigest.isCompleted());
        assertNull(padvEntryDigest.getAnnotationComment());
    }

    @Test
    void testPadvSuspend() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_02_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_04_valid.xml");
        final var digest = digester.digest(padvDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPadvDocumentDigest.class, digest);
        final var padvDigest = (EmedPadvDocumentDigest) digest;

        // Document
        assertEquals("0AD00000-0000-0000-0000-000000000004", padvDigest.getId().toString().toUpperCase());
        assertEquals("0AD00000-0000-0000-0000-000000000004", padvDigest.getSetId().toString().toUpperCase());
        assertEquals(1, padvDigest.getVersion());
        assertEquals("fr-CH", padvDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, padvDigest.getConfidentialityCode());
        assertEquals(1641977280L, padvDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, padvDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, padvDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, padvDigest.getAuthors().get(0));
        assertEquals(1328360400000L, padvDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", padvDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", padvDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", padvDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, padvDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, padvDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, padvDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, padvDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), padvDigest.getPatient().ids());
        assertEquals("Monika", padvDigest.getPatient().givenName());
        assertEquals("Wegmüller", padvDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, padvDigest.getPatient().gender());
        assertEquals(-9728, padvDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getCustodian());
        assertNull(padvDigest.getRemarks());
        assertEquals(0, padvDigest.getPdfRepresentation().length);
        assertEquals(1, padvDigest.getRecipients().size());
        assertEquals(1, padvDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", padvDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", padvDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", padvDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());

        // Entry
        assertNotNull(padvDigest.getPadvEntryDigest());
        assertInstanceOf(EmedPadvSuspendEntryDigest.class, padvDigest.getPadvEntryDigest());
        final var padvEntryDigest = (EmedPadvSuspendEntryDigest) padvDigest.getPadvEntryDigest();
        assertEquals(0, padvEntryDigest.getSequence());
        assertEquals(padvDigest.getId(), padvEntryDigest.getDocumentId());
        assertEquals("0AD00000-0000-0000-0000-000000000004", padvEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.MTP, padvEntryDigest.getTargetedEntryType());
        assertEquals("00000000-0000-0000-0000-000000000002", padvEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PADV, padvEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2012-02-04T13:00:00.00Z"), padvEntryDigest.getEffectiveTime());
        assertEquals(padvDigest.getDocumentationTime(), padvEntryDigest.getPharmaceuticalAdviceTime());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getDocumentAuthor());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getSectionAuthor());
        assertTrue(padvEntryDigest.isCompleted());
        assertEquals("Annotation Comment", padvEntryDigest.getAnnotationComment());
    }

    @Test
    void testPadvRefuse() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_PRE + "PRE_01_valid.xml", digester));

        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_05_valid.xml");
        final var digest = digester.digest(padvDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPadvDocumentDigest.class, digest);
        final var padvDigest = (EmedPadvDocumentDigest) digest;

        // Document
        assertEquals("0AD00000-0000-0000-0000-000000000005", padvDigest.getId().toString().toUpperCase());
        assertEquals("0AD00000-0000-0000-0000-000000000005", padvDigest.getSetId().toString().toUpperCase());
        assertEquals(1, padvDigest.getVersion());
        assertEquals("fr-CH", padvDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, padvDigest.getConfidentialityCode());
        assertEquals(1641977280L, padvDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, padvDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, padvDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, padvDigest.getAuthors().get(0));
        assertEquals(1328360400000L, padvDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", padvDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", padvDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", padvDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, padvDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, padvDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, padvDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, padvDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), padvDigest.getPatient().ids());
        assertEquals("Monika", padvDigest.getPatient().givenName());
        assertEquals("Wegmüller", padvDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, padvDigest.getPatient().gender());
        assertEquals(-9728, padvDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getCustodian());
        assertNull(padvDigest.getRemarks());
        assertEquals(0, padvDigest.getPdfRepresentation().length);
        assertEquals(1, padvDigest.getRecipients().size());
        assertEquals(1, padvDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", padvDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", padvDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", padvDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());

        // Entry
        assertNotNull(padvDigest.getPadvEntryDigest());
        assertInstanceOf(EmedPadvRefuseEntryDigest.class, padvDigest.getPadvEntryDigest());
        final var padvEntryDigest = (EmedPadvRefuseEntryDigest) padvDigest.getPadvEntryDigest();
        assertEquals(0, padvEntryDigest.getSequence());
        assertEquals(padvDigest.getId(), padvEntryDigest.getDocumentId());
        assertEquals("0AD00000-0000-0000-0000-000000000005", padvEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.PRE, padvEntryDigest.getTargetedEntryType());
        assertEquals("00E00000-0000-0000-0000-000000000001", padvEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PADV, padvEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2012-02-04T13:00:00.00Z"), padvEntryDigest.getEffectiveTime());
        assertEquals(padvDigest.getDocumentationTime(), padvEntryDigest.getPharmaceuticalAdviceTime());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getDocumentAuthor());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getSectionAuthor());
        assertTrue(padvEntryDigest.isCompleted());
        assertNull(padvEntryDigest.getAnnotationComment());
    }

    @Test
    void testPadvComment() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_DIS + "DIS_01_valid.xml", digester));

        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_06_valid.xml");
        final var digest = digester.digest(padvDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPadvDocumentDigest.class, digest);
        final var padvDigest = (EmedPadvDocumentDigest) digest;

        // Document
        assertEquals("0AD00000-0000-0000-0000-000000000006", padvDigest.getId().toString().toUpperCase());
        assertEquals("0AD00000-0000-0000-0000-000000000006", padvDigest.getSetId().toString().toUpperCase());
        assertEquals(1, padvDigest.getVersion());
        assertEquals("fr-CH", padvDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, padvDigest.getConfidentialityCode());
        assertEquals(1641977280L, padvDigest.getCreationTime().toEpochSecond());
        assertEquals(1328360400000L, padvDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, padvDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, padvDigest.getAuthors().get(0));
        assertEquals(1328360400000L, padvDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", padvDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", padvDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", padvDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, padvDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, padvDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, padvDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, padvDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), padvDigest.getPatient().ids());
        assertEquals("Monika", padvDigest.getPatient().givenName());
        assertEquals("Wegmüller", padvDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, padvDigest.getPatient().gender());
        assertEquals(-9728, padvDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, padvDigest.getCustodian());
        assertNull(padvDigest.getRemarks());
        assertEquals(0, padvDigest.getPdfRepresentation().length);
        assertEquals(1, padvDigest.getRecipients().size());
        assertEquals(1, padvDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", padvDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", padvDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", padvDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());

        // Entry
        assertNotNull(padvDigest.getPadvEntryDigest());
        assertInstanceOf(EmedPadvCommentEntryDigest.class, padvDigest.getPadvEntryDigest());
        final var padvEntryDigest = (EmedPadvCommentEntryDigest) padvDigest.getPadvEntryDigest();
        assertEquals(0, padvEntryDigest.getSequence());
        assertEquals(padvDigest.getId(), padvEntryDigest.getDocumentId());
        assertEquals("0AD00000-0000-0000-0000-000000000006", padvEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals(EmedEntryType.DIS, padvEntryDigest.getTargetedEntryType());
        assertEquals("D0000000-0000-0000-0000-000000000001", padvEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PADV, padvEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-02-01T00:00:00.00Z"), padvEntryDigest.getEffectiveTime());
        assertEquals(padvDigest.getDocumentationTime(), padvEntryDigest.getPharmaceuticalAdviceTime());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getDocumentAuthor());
        assertEquals(padvDigest.getAuthors().get(0), padvEntryDigest.getSectionAuthor());
        assertTrue(padvEntryDigest.isCompleted());
        assertNull(padvEntryDigest.getAnnotationComment());
        assertEquals("Comment on the referenced item", padvEntryDigest.getComment());
    }

    @Test
    void testMissingEntry() throws Exception {
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_05_valid.xml");
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        padvDocument.getComponent().getStructuredBody().getComponent().get(0).getSection().getEntry().clear();
        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testMissingReference() throws Exception {
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_05_valid.xml");
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        padvDocument.getComponent().getStructuredBody().getComponent().get(0).getSection().getEntry().get(0).getObservation().getEntryRelationship().clear();
        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testUnableToFindItemEntryDigest() throws Exception {
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "valid/PADV_05_valid.xml");
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);
        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testEntryIDMissing() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "invalid/PADV_01_invalid.xml");

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testStatusMissing() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);
        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_DIS + "DIS_01_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "invalid/PADV_02_invalid.xml");

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testStatusCodeMissing() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);
        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_02_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "invalid/PADV_03_invalid.xml");

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testCommentMissing() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);
        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_DIS + "DIS_01_valid.xml", digester));
        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "invalid/PADV_04_invalid.xml");

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testBadPreRecommended1() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_PRE + "PRE_01_valid.xml", digester));

        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "invalid/PADV_05_invalid.xml");
        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testBadPreRecommended2() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_01_valid.xml", digester));

        final var padvDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PADV + "invalid/PADV_06_invalid.xml");
        assertThrows(InvalidEmedContentException.class, () -> digester.digest(padvDocument));
    }

    @Test
    void testAuthorInSubstanceAdministration() throws Exception {
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

        var observation = """
                <templateId root="2.16.756.5.30.1.1.10.4.44" />
                <templateId root="1.3.6.1.4.1.19376.1.9.1.3.3" />
                <id root="0AD00000-0000-0000-0000-000000000001" />
                <code xsi:type="CD" code="OK" codeSystem="1.3.6.1.4.1.19376.1.9.2.1" codeSystemName="IHE Pharmaceutical Advice Status List" />
                <text xsi:type="ED">
                    Complementary information
    
                    <reference value="#padv.content" />
                </text>
                <statusCode code="completed" />
                <effectiveTime value="20220201" />
                <entryRelationship typeCode="REFR">
                    <substanceAdministration classCode="SBADM" moodCode="INT">
                        <templateId root="1.3.6.1.4.1.19376.1.9.1.3.10" />
                        <templateId root="2.16.756.5.30.1.1.10.4.45" />
                        <id root="00000000-0000-0000-0000-000000000001" />
                        <code code="MTPItem" codeSystem="1.3.6.1.4.1.19376.1.9.2.2" codeSystemName="IHE Pharmacy Item Type List" displayName="Medication Treatment Plan Item" />
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                        <reference typeCode="XCRPT">
                            <externalDocument>
                                <id root="00000000-0000-0000-0000-000000000001" />
                            </externalDocument>
                        </reference>
                    </substanceAdministration>
                </entryRelationship>
                """ + sectionAuthor;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_01_valid.xml", digester));

        var digest = new CcePadvEntryDigester(emedEntryDigestServiceImpl, new CceMtpEntryDigester(), new CcePreEntryDigester(emedEntryDigestServiceImpl))
                .createDigest(
                        this.unmarshall(observation),
                        UUID.randomUUID(),
                        Instant.now(),
                        null,
                        null);

        assertEquals(digest.getSectionAuthor(), digest.getDocumentAuthor());

        observation += documentAuthor;
        digest = new CcePadvEntryDigester(
                emedEntryDigestServiceImpl,
                new CceMtpEntryDigester(),
                new CcePreEntryDigester(emedEntryDigestServiceImpl))
                .createDigest(this.unmarshall(observation),
                        UUID.randomUUID(),
                        Instant.now(),
                        null,
                        null);

        assertNotEquals(digest.getSectionAuthor().getFamilyName(), digest.getDocumentAuthor().getFamilyName());
    }

    private List<EmedEntryDigest> getEntryDigests(String docPath, CceDocumentDigester digester) throws Exception {
        final var document = this.loadDoc(docPath);
        return digester.digest(document).getEntryDigests();
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CcePadvDigesterTest.class.getResourceAsStream("/CDA-CH-EMED"
                + docName));
    }

    private POCDMT000040Observation unmarshall(final String observation) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<observation classCode=\"OBS\" moodCode=\"EVN\" xmlns:pharm=\"urn:ihe:pharm\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + observation
                + "</observation>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, POCDMT000040Observation.class);
        return (POCDMT000040Observation) JAXBIntrospector.getValue(root);
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
