package org.projecthusky.emed.ch.cda.utils.readers;

import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
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
    void testEntryAuthorElement() throws Exception {
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
                <doseQuantity unit="mg" value="0.5" />
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
                </author>""");

        assertTrue(reader.getEntryAuthorElement().isPresent());
        assertFalse(reader.getEntryAuthorElement().get().getAssignedAuthor().getId().isEmpty());
        assertEquals("2.51.1.3", reader.getEntryAuthorElement().get().getAssignedAuthor().getId().get(0).getRoot());

        reader = this.unmarshall("""
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

        assertFalse(reader.getEntryAuthorElement().isPresent());
        assertFalse(reader.getParentDocumentAuthorElement().isPresent());
    }

    @Test
    void testParentDocumentAuthorElement() throws Exception {
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
                <doseQuantity unit="mg" value="0.5" />
                <author>
                    <templateId root="2.16.756.5.30.1.1.10.9.23" />
                    <time value="20111129110000+0100" />
                    <assignedAuthor>
                        <id root="2.51.1.3" extension="7600000000001" />
                        <assignedPerson>
                            <name>
                                <family>Hausarzt</family>
                                <given>Familien</given>
                            </name>
                        </assignedPerson>
                    </assignedAuthor>
                </author>
                <author>
                    <templateId root="2.16.756.5.30.1.1.10.9.23" />
                    <time value="20111129110000+0100" />
                    <assignedAuthor>
                        <id root="2.51.1.4" extension="7600000000002" />
                        <assignedPerson>
                            <name>
                                <family>Hau</family>
                                <given>Len</given>
                            </name>
                        </assignedPerson>
                    </assignedAuthor>
                </author>""");

        assertTrue(reader.getParentDocumentAuthorElement().isPresent());
        assertFalse(reader.getParentDocumentAuthorElement().get().getAssignedAuthor().getId().isEmpty());
        assertEquals("2.51.1.4", reader.getParentDocumentAuthorElement().get().getAssignedAuthor().getId().get(0).getRoot());
    }

    @Test
    void testDosageIntakeModeElement() throws Exception {
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

        assertFalse(reader.getDosageIntakeModeElement().isPresent());
    }

    @Test
    void testDosageInstructionsElement() throws Exception {
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

        assertFalse(reader.getDosageInstructionsElement().isPresent());
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

        assertFalse(reader.getPreconditionCriterionElement().isPresent());

        reader = this.unmarshall("""
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
                <doseQuantity unit="mg" value="0.5" />
                <precondition>
                    <criterion>
                        <text>
                        Precondition
                        
                        <reference value="#mtp.content" />
                        </text>
                    </criterion>
                </precondition>""");

        assertTrue(reader.getPreconditionCriterionElement().isPresent());
        assertEquals("Precondition", reader.getPreconditionCriterionElement().get().getText().getTextContent());
    }

    @Test
    void testManufacturedMaterialReader() throws Exception {
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
                <doseQuantity unit="mg" value="0.5" />
                """);

        assertThrows(InvalidEmedContentException.class, reader::getManufacturedMaterialReader);
    }

    @Test
    void testIsInReserveAndIsSubstitutionPermitted() throws Exception {

        String base = """
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
                <doseQuantity unit="mg" value="0.5" />
                """;

        var reader = this.unmarshall(base + """
                <entryRelationship typeCode="COMP">
                    <act classCode="ACT" moodCode="DEF">
                        <templateId root="2.16.756.5.30.1.1.10.10" />
                        <code code="225761000" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED Clinical Terms" displayName="As required (qualifier value)" />
                        <statusCode code="completed"/>
                    </act>
                </entryRelationship>
                <entryRelationship typeCode="COMP">
                    <act classCode="ACT" moodCode="DEF">
                        <templateId root="1.3.6.1.4.1.19376.1.9.1.3.9.1" />
                        <!-- Missing code -->
                        <statusCode code="completed" />
                    </act>
                </entryRelationship>
                """);

        assertTrue(reader.isInReserve());
        assertTrue(reader.isSubstitutionPermitted());

        reader = this.unmarshall(base);
        assertFalse(reader.isInReserve());

        reader = this.unmarshall(base + """
                <entryRelationship typeCode="COMP">
                    <act classCode="ACT" moodCode="DEF">
                        <templateId root="2.16.756.5.30.1.1.10.10" />
                        <statusCode code="completed"/>
                    </act>
                </entryRelationship>
                """);

        assertFalse(reader.isInReserve());
    }

    private SubAdmEntryReader unmarshall(final String substanceAdministrationContent) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<substanceAdministration classCode=\"SBADM\" moodCode=\"INT\" xmlns:pharm=\"urn:ihe:pharm\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
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