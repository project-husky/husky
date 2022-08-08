package org.husky.emed.ch.cda.utils.readers;

import org.husky.common.hl7cdar2.POCDMT000040Material;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.emed.ch.errors.InvalidEmedContentException;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bench of the {@link SubAdmEntryReader}
 *
 * @author Ronaldo Loureiro
 */
class SubAdmEntryReaderTest {
    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040SubstanceAdministration.class;
    private final Unmarshaller UNMARSHALLER;

    public SubAdmEntryReaderTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testMissingEntryId() throws Exception {
        var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <!-- Missing Id -->
                <text>
                    <reference value="#mtp.content" />
                </text>
                <statusCode code="completed" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <high value="20220310120000+0100" />
                </effectiveTime>
                <effectiveTime xsi:type="EIVL_TS" operator="A">
                    <event code="MORN" />
                </effectiveTime>
                <repeatNumber value="1" />
                <routeCode code="20053000" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Oral use" />
                <doseQuantity unit="mg" value="0.5" />
                """);

        assertThrows(InvalidEmedContentException.class, reader::getEntryId);
    }

    @Test
    void testPreconditionCriterion() throws Exception {
        var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <id root="00000000-0000-0000-0000-000000000005" />
                <text>
                    <reference value="#mtp.content" />
                </text>
                <statusCode code="completed" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <high value="20220310120000+0100" />
                </effectiveTime>
                <effectiveTime xsi:type="EIVL_TS" operator="A">
                    <event code="MORN" />
                </effectiveTime>
                <repeatNumber value="1" />
                <routeCode code="20053000" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Oral use" />
                <doseQuantity unit="mg" value="0.5" />""");

        assertTrue(reader.getPreconditionCriterionElement().isEmpty());
    }



    private SubAdmEntryReader unmarshall(final String substanceAdministrationContent) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<substanceAdministration classCode=\"SBADM\" moodCode=\"INT\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "<templateId root=\"1.3.6.1.4.1.19376.1.9.1.3.6\" />"
                + substanceAdministrationContent
                + "</substanceAdministration>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var substanceAdministration = (POCDMT000040SubstanceAdministration) JAXBIntrospector.getValue(root);
        return new SubAdmEntryReader(substanceAdministration);
    }
}