package org.husky.emed.ch.cda.digesters;

import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.POCDMT000040IntendedRecipient;
import org.husky.common.hl7cdar2.POCDMT000040Material;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.cda.utils.readers.ContainerPackagedMedicineReader;
import org.husky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.*;
import org.husky.emed.ch.models.document.EmedMtpDocumentDigest;
import org.husky.emed.ch.models.document.EmedPmlcDocumentDigest;
import org.husky.emed.ch.models.entry.EmedEntryDigest;
import org.husky.emed.ch.models.entry.EmedMtpEntryDigest;
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
 * Tests of the {@link CceDocumentDigester} class.
 *
 * @author Ronaldo Loureiro
 */
class CceDocumentDigesterTest {

    final String DIR_E_HEALTH_SUISSE = "/eHealthSuisse/v1.0/";
    final String DIR_SAMPLES_BY_HAND_MTP = "/Samples/ByHand/mtp/valid/";
    final String DIR_SAMPLES_BY_HAND_PMLC = "/Samples/ByHand/pmlc/valid/";

    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040ClinicalDocument.class;
    private final Unmarshaller UNMARSHALLER;

    public CceDocumentDigesterTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testPmlc() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_01_valid.xml", digester));
        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_02_valid.xml", digester));

        final var pmlcDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PMLC + "PMLC_01_valid.xml");
        final var digest = digester.digest(pmlcDocument);

        // Document
        assertNotNull(digest);
        assertInstanceOf(EmedPmlcDocumentDigest.class, digest);
        final var pmlcDigest = (EmedPmlcDocumentDigest) digest;
        assertNotNull(pmlcDigest);
        assertEquals("000C0000-0000-0000-0000-000000000001", pmlcDigest.getId().toString().toUpperCase());
        assertEquals("000C0000-0000-0000-0000-000000000001", pmlcDigest.getSetId().toString().toUpperCase());
        assertEquals(1, pmlcDigest.getVersion());
        assertEquals("fr-CH", pmlcDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, pmlcDigest.getConfidentialityCode());
        assertEquals(1641033240L, pmlcDigest.getCreationTime().toEpochSecond());
        assertEquals(1322560800000L, pmlcDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, pmlcDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, pmlcDigest.getAuthors().get(0));
        assertEquals(1322560800000L, pmlcDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", pmlcDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", pmlcDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", pmlcDigest.getAuthors().get(0).getAuthorGln());
        assertInstanceOf(OrganizationDigest.class, pmlcDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, pmlcDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, pmlcDigest.getRecipients().size());
        assertEquals(1, pmlcDigest.getRecipients().get(0).getAddresses().size());
        assertInstanceOf(PatientDigest.class, pmlcDigest.getPatient());
        assertEquals(1, pmlcDigest.getPatient().ids().size());
        assertEquals(new QualifiedIdentifier("11111111", "2.999"), pmlcDigest.getPatient().ids().get(0));
        assertEquals("Monika", pmlcDigest.getPatient().givenName());
        assertEquals("Wegmüller", pmlcDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, pmlcDigest.getPatient().gender());
        assertEquals(-9728, pmlcDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, pmlcDigest.getCustodian());
        assertNull(pmlcDigest.getRemarks());
        assertEquals(232961, pmlcDigest.getPdfRepresentation().length);
        
        // Entry
        assertEquals(2, pmlcDigest.getMtpEntryDigests().size());
        assertNotNull(pmlcDigest.getMtpEntryDigests().get(0).getEmedEntryType());
    }

    @Test
    void testPml() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        final var pmlDocument = this.loadDoc(DIR_E_HEALTH_SUISSE + "2-1-MedicationList.xml");
        assertThrows(UnsupportedOperationException.class, () -> digester.digest(pmlDocument));
    }

    @Test
    void testDocumentIdMissing() {
        String header = """
                <realmCode code="CHE" />
                <!-- Document ID is missing -->
                <code code="56445-0" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC" displayName="Medication summary">
                    <translation xsi:type="CD" code="721912009" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Medication summary document (record artifact)" />
                </code>
                <title>Plan de médication</title>
                <effectiveTime value="20220101113400+0100" />
                <confidentialityCode code="17621005" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Normally accessible" />
                <languageCode code="fr-CH" />
                <setId root="000C0000-0000-0000-0000-000000000001" />
                <versionNumber value="1" />
                """;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(this.unmarshall(header)));
    }

    @Test
    void testSetIdMissing() {
        String header = """
                <realmCode code="CHE" />
                <id root="000C0000-0000-0000-0000-000000000001" />
                <code code="56445-0" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC" displayName="Medication summary">
                    <translation xsi:type="CD" code="721912009" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Medication summary document (record artifact)" />
                </code>
                <title>Plan de médication</title>
                <effectiveTime value="20220101113400+0100" />
                <confidentialityCode code="17621005" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Normally accessible" />
                <languageCode code="fr-CH" />
                <!-- Set ID is missing -->
                <versionNumber value="1" />
                """;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(this.unmarshall(header)));
    }

    @Test
    void testVersionMissing() {
        String header = """
                <realmCode code="CHE" />
                <id root="000C0000-0000-0000-0000-000000000001" />
                <code code="56445-0" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC" displayName="Medication summary">
                    <translation xsi:type="CD" code="721912009" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Medication summary document (record artifact)" />
                </code>
                <title>Plan de médication</title>
                <effectiveTime value="20220101113400+0100" />
                <confidentialityCode code="17621005" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Normally accessible" />
                <languageCode code="fr-CH" />
                <setId root="000C0000-0000-0000-0000-000000000001" />
                <!-- Version is missing -->
                """;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(this.unmarshall(header)));
    }

    @Test
    void testEffectiveTimeMissing() {
        String header = """
                <realmCode code="CHE" />
                <id root="000C0000-0000-0000-0000-000000000001" />
                <code code="56445-0" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC" displayName="Medication summary">
                    <translation xsi:type="CD" code="721912009" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Medication summary document (record artifact)" />
                </code>
                <title>Plan de médication</title>
                <!-- Effective Time is missing -->
                <confidentialityCode code="17621005" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Normally accessible" />
                <languageCode code="fr-CH" />
                <setId root="000C0000-0000-0000-0000-000000000001" />
                <versionNumber value="1" />
                """;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(this.unmarshall(header)));
    }

    @Test
    void testConfidentialityCodeMissing() {
        String header = """
                <realmCode code="CHE" />
                <id root="000C0000-0000-0000-0000-000000000001" />
                <code code="56445-0" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC" displayName="Medication summary">
                    <translation xsi:type="CD" code="721912009" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Medication summary document (record artifact)" />
                </code>
                <title>Plan de médication</title>
                <effectiveTime value="20220101113400+0100" />
                <!-- Confidentiality code is missing -->
                <languageCode code="fr-CH" />
                <setId root="000C0000-0000-0000-0000-000000000001" />
                <versionNumber value="1" />
                """;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(this.unmarshall(header)));
    }

    @Test
    void testLanguageCodeMissing() {
        String header = """
                <realmCode code="CHE" />
                <id root="000C0000-0000-0000-0000-000000000001" />
                <code code="56445-0" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC" displayName="Medication summary">
                    <translation xsi:type="CD" code="721912009" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Medication summary document (record artifact)" />
                </code>
                <title>Plan de médication</title>
                <effectiveTime value="20220101113400+0100" />
                <confidentialityCode code="17621005" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Normally accessible" />
                <!-- Language code is missing -->
                <setId root="000C0000-0000-0000-0000-000000000001" />
                <versionNumber value="1" />
                """;

        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(this.unmarshall(header)));
    }

    private List<EmedEntryDigest> getEntryDigests(String docPath, CceDocumentDigester digester) throws Exception {
        final var document = this.loadDoc(docPath);
        return digester.digest(document).getEntryDigests();
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CceDocumentDigesterTest.class.getResourceAsStream("/CDA-CH-EMED"
                + docName));
    }

    private POCDMT000040ClinicalDocument unmarshall(final String content) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = """
                <ClinicalDocument xmlns:pharm="urn:ihe:pharm" xmlns="urn:hl7-org:v3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="urn:hl7-org:v3 ../../../../schemas/PHARM/schemas/cda/extendedschemas/CDA_extended_pharmacy.xsd">
                """ + content + """
                </ClinicalDocument>
                """;

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        return (POCDMT000040ClinicalDocument) JAXBIntrospector.getValue(root);
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