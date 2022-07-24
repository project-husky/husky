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
import org.husky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.husky.emed.ch.enums.CceDocumentType;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bench of the {@link ClinicalDocumentReader}.
 *
 * @author Quentin Ligier
 **/
class ClinicalDocumentReaderTest {

    @Test
    void testMtp() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc("1-1-MedicationTreatmentPlan.xml"));

        assertEquals(CceDocumentType.MTP, reader.getDocumentType());
        assertFalse(reader.getPdfRepresentation().isPresent());
    }

    @Test
    void testPre() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc("2-6-MedicationPrescription.xml"));

        assertEquals(CceDocumentType.PRE, reader.getDocumentType());
        assertTrue(reader.getPdfRepresentation().isPresent());
    }

    @Test
    void testDis() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc("1-2-MedicationDispense.xml"));

        assertEquals(CceDocumentType.DIS, reader.getDocumentType());

    }

    @Test
    void testPadv() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc("2-2-PharmaceuticalAdvice.xml"));

        assertEquals(CceDocumentType.PADV, reader.getDocumentType());

    }

    @Test
    void testPml() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc("2-1-MedicationList.xml"));

        assertEquals(CceDocumentType.PML, reader.getDocumentType());

    }

    @Test
    void testPmlc() throws Exception {
        final var reader = new ClinicalDocumentReader(this.loadDoc("2-7-MedicationCard.xml"));

        assertEquals(CceDocumentType.PMLC, reader.getDocumentType());

    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(ClinicalDocumentReaderTest.class.getResourceAsStream("/CDA-CH-EMED" +
                "/eHealthSuisse/v1.0/" + docName));
    }
}