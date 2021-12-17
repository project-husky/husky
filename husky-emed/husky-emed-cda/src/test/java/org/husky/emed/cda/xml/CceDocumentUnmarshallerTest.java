package org.husky.emed.cda.xml;

import org.apache.commons.io.IOUtils;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.emed.cda.TestUtils;
import org.husky.emed.cda.generated.artdecor.MedicationTreatmentPlanDocument;
import org.husky.emed.errors.InvalidEmedContentException;
import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link CceDocumentUnmarshaller} class.
 *
 * @author Quentin Ligier
 */
class CceDocumentUnmarshallerTest {

    private static final String CCE_FILE = "CDA-CH-EMED/eHealthSuisse/v1.0/1-1-MedicationTreatmentPlan.xml";

    @Test
    void testUnmarshallString() throws Exception {
        final var is = Optional.ofNullable(TestUtils.class.getClassLoader().getResourceAsStream(CCE_FILE))
                .orElseThrow(() -> new RuntimeException("The resource path is invalid"));
        final var xml = IOUtils.toString(is, StandardCharsets.UTF_8);
        final var doc = CceDocumentUnmarshaller.unmarshall(xml);
        this.assertDoc(doc);
    }

    @Test
    void testUnmarshallInputStream() throws Exception {
        final var is = Optional.ofNullable(TestUtils.class.getClassLoader().getResourceAsStream(CCE_FILE))
                .orElseThrow(() -> new RuntimeException("The resource path is invalid"));
        final var doc = CceDocumentUnmarshaller.unmarshall(is);
        this.assertDoc(doc);
    }

    @Test
    void testUnmarshallInputSource() throws Exception {
        final var is = Optional.ofNullable(TestUtils.class.getClassLoader().getResourceAsStream(CCE_FILE))
                .orElseThrow(() -> new RuntimeException("The resource path is invalid"));
        final var source = new InputSource(is);
        final var doc = CceDocumentUnmarshaller.unmarshall(source);
        this.assertDoc(doc);
    }

    @Test
    void testUnmarshallInvalidDocument() throws Exception {
        final var is = Optional.ofNullable(TestUtils.class.getClassLoader().getResourceAsStream(CCE_FILE))
                .orElseThrow(() -> new RuntimeException("The resource path is invalid"));
        final var xml = IOUtils.toString(is, StandardCharsets.UTF_8).replace("2.16.756.5.30.1.1.10.1.7", "1.2.3");
        assertThrows(InvalidEmedContentException.class, () -> CceDocumentUnmarshaller.unmarshall(xml));
    }

    private void assertDoc(final POCDMT000040ClinicalDocument doc) {
        assertNotNull(doc);
        assertInstanceOf(MedicationTreatmentPlanDocument.class, doc);

    }
}