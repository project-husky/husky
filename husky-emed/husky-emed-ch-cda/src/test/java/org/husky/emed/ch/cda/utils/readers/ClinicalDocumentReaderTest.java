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
package org.husky.emed.ch.cda.utils.readers;

import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.POCDMT000040Section;
import org.husky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.husky.emed.ch.enums.CceDocumentType;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bench of the {@link ClinicalDocumentReader}.
 *
 * @author Quentin Ligier
 **/
class ClinicalDocumentReaderTest {

    final String DIR_E_HEALTH_SUISSE = "/eHealthSuisse/v1.0/";
    final String DIR_SAMPLES_BY_HAND = "/Samples/ByHand/";

    @Test
    void testMtp() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc(DIR_E_HEALTH_SUISSE + "1-1-MedicationTreatmentPlan.xml"));

        assertEquals(CceDocumentType.MTP, reader.getDocumentType());
        assertFalse(reader.getPdfRepresentation().isPresent());
        assertEquals(POCDMT000040Section.class, reader.getContentSection().getClass());
    }

    @Test
    void testPre() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc(DIR_E_HEALTH_SUISSE + "2-6-MedicationPrescription.xml"));

        assertEquals(CceDocumentType.PRE, reader.getDocumentType());
        assertTrue(reader.getPdfRepresentation().isPresent());
        assertEquals(POCDMT000040Section.class, reader.getContentSection().getClass());
        assertEquals(Instant.MIN.getEpochSecond(), reader.getPreValidityStartTime(Instant.MIN).getEpochSecond());
        assertNull(reader.getPreValidityStopTime());
    }

    @Test
    void testDis() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc(DIR_E_HEALTH_SUISSE + "1-2-MedicationDispense.xml"));

        assertEquals(CceDocumentType.DIS, reader.getDocumentType());
        assertEquals(POCDMT000040Section.class, reader.getContentSection().getClass());
    }

    @Test
    void testPadv() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc( DIR_E_HEALTH_SUISSE + "2-2-PharmaceuticalAdvice.xml"));

        assertEquals(CceDocumentType.PADV, reader.getDocumentType());
        assertEquals(POCDMT000040Section.class, reader.getContentSection().getClass());
    }

    @Test
    void testPml() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc(DIR_E_HEALTH_SUISSE + "2-1-MedicationList.xml"));

        assertEquals(CceDocumentType.PML, reader.getDocumentType());
        assertEquals(POCDMT000040Section.class, reader.getContentSection().getClass());
    }

    @Test
    void testPmlc() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc(DIR_E_HEALTH_SUISSE + "2-7-MedicationCard.xml"));

        assertEquals(CceDocumentType.PMLC, reader.getDocumentType());
        assertEquals(POCDMT000040Section.class, reader.getContentSection().getClass());
    }

    @Test
    void testInvalidTemplateID() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc(DIR_SAMPLES_BY_HAND + "mtp/invalid/MTP_04_invalid.xml"));

        assertThrows(InvalidEmedContentException.class, reader::getDocumentType);
        assertThrows(InvalidEmedContentException.class, reader::getContentSection);
    }

    @Test
    void testInvalidPdfRepresentation() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc(DIR_SAMPLES_BY_HAND + "pre/invalid/PRE_01_invalid.xml"));

        assertThrows(InvalidEmedContentException.class, reader::getPdfRepresentation);
    }

    @Test
    void testMissingPatient() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc(DIR_SAMPLES_BY_HAND + "mtp/invalid/MTP_06_invalid.xml"));
        assertThrows(InvalidEmedContentException.class, reader::getPatientDigest);
    }

    @Test
    void testGetCustodian() throws Exception {
        final var reader = this.loadDoc(DIR_SAMPLES_BY_HAND + "mtp/valid/MTP_06_valid.xml");
        reader.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization().setName(null);
        assertThrows(InvalidEmedContentException.class, new ClinicalDocumentReader(reader)::getCustodian);
        reader.setCustodian(null);
        assertThrows(InvalidEmedContentException.class, new ClinicalDocumentReader(reader)::getCustodian);
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(ClinicalDocumentReaderTest.class.getResourceAsStream("/CDA-CH-EMED" +
                docName));
    }
}