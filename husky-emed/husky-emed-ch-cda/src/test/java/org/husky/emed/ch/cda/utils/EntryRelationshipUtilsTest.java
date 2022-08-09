package org.husky.emed.ch.cda.utils;

import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.emed.ch.cda.utils.readers.SubAdmEntryReader;
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
 * Test bench of the {@link EntryRelationshipUtils}
 *
 * @author Ronaldo Loureiro
 */
class EntryRelationshipUtilsTest {
    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040SubstanceAdministration.class;
    private final Unmarshaller UNMARSHALLER;

    public EntryRelationshipUtilsTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testMultiplePatientMedicationInstructions() throws Exception {
        var substanceAdmin = this.unmarshall("""
                <entryRelationship typeCode="SUBJ" inversionInd="true">
                    <act classCode="ACT" moodCode="INT">
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.3"/>
                        <templateId root="2.16.840.1.113883.10.20.1.49"/>
                        <code code="PINSTRUCT" codeSystem="1.3.6.1.4.1.19376.1.5.3.2" codeSystemName="IHEActCode"/>
                        <text>Patient instructions N°1
                            <reference value="#ref"/>
                        </text>
                        <statusCode code="completed"/>
                    </act>
                </entryRelationship>
                <entryRelationship typeCode="SUBJ" inversionInd="true">
                    <act classCode="ACT" moodCode="INT">
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.3"/>
                        <templateId root="2.16.840.1.113883.10.20.1.49"/>
                        <code code="PINSTRUCT" codeSystem="1.3.6.1.4.1.19376.1.5.3.2" codeSystemName="IHEActCode"/>
                        <text>Patient instructions N°2
                            <reference value="#ref"/>
                        </text>
                        <statusCode code="completed"/>
                    </act>
                </entryRelationship>""");

        assertThrows(InvalidEmedContentException.class,
                () -> EntryRelationshipUtils.getPatientMedicationInstructions(substanceAdmin.getEntryRelationship()));
    }

    @Test
    void testMultipleFulfillmentInstructionsInstructions() throws Exception {
        var substanceAdmin = this.unmarshall("""
                <entryRelationship typeCode="SUBJ" inversionInd="true">
                    <act classCode="ACT" moodCode="INT">
                        <templateId root="2.16.840.1.113883.10.20.1.43"/>
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.3.1"/>
                        <code code="FINSTRUCT" codeSystem="1.3.6.1.4.1.19376.1.5.3.2" codeSystemName="IHEActCode"/>
                        <text>Fulfillment instructions N°1
                            <reference value="#ref"/>
                        </text>
                        <statusCode code="completed"/>
                    </act>
                </entryRelationship>
                <entryRelationship typeCode="SUBJ" inversionInd="true">
                    <act classCode="ACT" moodCode="INT">
                        <templateId root="2.16.840.1.113883.10.20.1.43"/>
                        <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.3.1"/>
                        <code code="FINSTRUCT" codeSystem="1.3.6.1.4.1.19376.1.5.3.2" codeSystemName="IHEActCode"/>
                        <text>Fulfillment instructions N°2
                            <reference value="#ref"/>
                        </text>
                        <statusCode code="completed"/>
                    </act>
                </entryRelationship>""");

        assertThrows(InvalidEmedContentException.class,
                () -> EntryRelationshipUtils.getFulfillmentInstructions(substanceAdmin.getEntryRelationship()));
    }

    @Test
    void testGetActsFromEntryRelationshipsListEmptyByTemplateId() throws Exception {
        assertTrue(EntryRelationshipUtils.getActsFromEntryRelationshipsByTemplateId(
                this.unmarshall("").getEntryRelationship(), "2.16.840.1.113883.10.20.1.43").isEmpty());
    }

    @Test
    void testGetObservationsFromEntryRelationshipsListEmptyByTemplateId() throws Exception {
        assertTrue(EntryRelationshipUtils.getObservationsFromEntryRelationshipsByTemplateId(
                this.unmarshall("").getEntryRelationship(), "2.16.840.1.113883.10.20.1.43").isEmpty());
    }

    @Test
    void testGetSupplyFromEntryRelationshipsListEmptyByTemplateId() throws Exception {
        assertTrue(EntryRelationshipUtils.getSupplyFromEntryRelationshipsByTemplateId(
                this.unmarshall("").getEntryRelationship(), "2.16.840.1.113883.10.20.1.43").isEmpty());
    }

    private POCDMT000040SubstanceAdministration unmarshall(final String entriesRelationship) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<substanceAdministration classCode=\"SBADM\" moodCode=\"INT\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "<templateId root=\"1.3.6.1.4.1.19376.1.9.1.3.6\" />"
                + entriesRelationship
                + "</substanceAdministration>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        return (POCDMT000040SubstanceAdministration) JAXBIntrospector.getValue(root);
    }
}