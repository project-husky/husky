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

import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.emed.ch.enums.RegularUnitCodeAmbu;
import org.husky.emed.ch.enums.RouteOfAdministrationAmbu;
import org.husky.emed.ch.enums.TimingEventAmbu;
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
 * Tests for the {@link DosageInstructionsReader} class.
 *
 * @author Quentin Ligier
 **/
class DosageInstructionsReaderTest {

    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040SubstanceAdministration.class;
    private final Unmarshaller UNMARSHALLER;

    public DosageInstructionsReaderTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testReadStructuredNormalDoseRegime() throws Exception {
        var dosageInstructions = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101200+0100" />
                    <high value="202203101200+0100" />
                </effectiveTime>
                <effectiveTime xsi:type="EIVL_TS" operator="A">
                    <event code="MORN" />
                </effectiveTime>
                <doseQuantity unit="mg" value="0.5" />
                """).getDosageInstructions();

        assertNull(dosageInstructions.getNarrativeDosageInstructions());
        assertEquals(1641812400000L, dosageInstructions.getIntakePeriodStartTime().toEpochMilli());
        assertEquals(1646910000000L, dosageInstructions.getIntakePeriodStopTime().toEpochMilli());
        assertEquals(1, dosageInstructions.getIntakes().size());
        assertEquals(RegularUnitCodeAmbu.MG, dosageInstructions.getIntakes().get(0).getDoseQuantity().getUnit());
        assertEquals("0.5", dosageInstructions.getIntakes().get(0).getDoseQuantity().getValue());
        assertEquals(TimingEventAmbu.MORNING, dosageInstructions.getIntakes().get(0).getEventTiming());

        dosageInstructions = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101043+0100" />
                    <high nullFlavor="UNK" />
                </effectiveTime>
                <effectiveTime xsi:type="SXPR_TS" operator="A">
                    <comp xsi:type="EIVL_TS">
                        <event code="MORN"/>
                    </comp>
                    <comp xsi:type="EIVL_TS">
                        <event code="NOON"/>
                    </comp>
                    <comp xsi:type="EIVL_TS" operator="I">
                        <event code="EVE"/>
                    </comp>
                </effectiveTime>
                <doseQuantity unit="g" value="1" />
                """).getDosageInstructions();
        assertNull(dosageInstructions.getNarrativeDosageInstructions());
        assertEquals(1641807780000L, dosageInstructions.getIntakePeriodStartTime().toEpochMilli());
        assertNull(dosageInstructions.getIntakePeriodStopTime());
        assertEquals(3, dosageInstructions.getIntakes().size());
        for (int i = 0; i < 3; ++i) {
            assertEquals(RegularUnitCodeAmbu.G, dosageInstructions.getIntakes().get(0).getDoseQuantity().getUnit());
            assertEquals("1", dosageInstructions.getIntakes().get(0).getDoseQuantity().getValue());
        }
        assertEquals(TimingEventAmbu.MORNING, dosageInstructions.getIntakes().get(0).getEventTiming());
        assertEquals(TimingEventAmbu.NOON, dosageInstructions.getIntakes().get(1).getEventTiming());
        assertEquals(TimingEventAmbu.EVENING, dosageInstructions.getIntakes().get(2).getEventTiming());
    }

    @Test
    void testNarrativeNormalDoseRegime() throws Exception {
        var dosageInstructions = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <entryRelationship typeCode="COMP">
                    <substanceAdministration classCode="SBADM" moodCode="INT">
                        <templateId root="2.16.756.5.30.1.1.10.4.52" />
                        <text>
                            narrative
    
                            <reference value="#mtp.content" />
                        </text>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                """).getDosageInstructions();

        assertEquals("narrative", dosageInstructions.getNarrativeDosageInstructions());
        assertNull(dosageInstructions.getIntakePeriodStartTime());
        assertNull(dosageInstructions.getIntakePeriodStopTime());
        assertEquals(0, dosageInstructions.getIntakes().size());
    }

    @Test
    void testSplitDoseRegime() throws Exception {
        var dosageInstructions = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.9" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101043+0100" />
                    <high nullFlavor="UNK" />
                </effectiveTime>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="1" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="MORN" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="2.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="2" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="NOON" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="1.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="3" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="EVE" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="2.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                """).getDosageInstructions();

        assertNull(dosageInstructions.getNarrativeDosageInstructions());
        assertEquals(1641807780000L, dosageInstructions.getIntakePeriodStartTime().toEpochMilli());
        assertNull(dosageInstructions.getIntakePeriodStopTime());
        assertEquals(3, dosageInstructions.getIntakes().size());
        assertEquals(RegularUnitCodeAmbu.DOSE, dosageInstructions.getIntakes().get(0).getDoseQuantity().getUnit());
        assertEquals("2.0", dosageInstructions.getIntakes().get(0).getDoseQuantity().getValue());
        assertEquals(TimingEventAmbu.MORNING, dosageInstructions.getIntakes().get(0).getEventTiming());
        assertEquals(RegularUnitCodeAmbu.DOSE, dosageInstructions.getIntakes().get(1).getDoseQuantity().getUnit());
        assertEquals("1.0", dosageInstructions.getIntakes().get(1).getDoseQuantity().getValue());
        assertEquals(TimingEventAmbu.NOON, dosageInstructions.getIntakes().get(1).getEventTiming());
        assertEquals(RegularUnitCodeAmbu.DOSE, dosageInstructions.getIntakes().get(2).getDoseQuantity().getUnit());
        assertEquals("2.0", dosageInstructions.getIntakes().get(2).getDoseQuantity().getValue());
        assertEquals(TimingEventAmbu.EVENING, dosageInstructions.getIntakes().get(2).getEventTiming());
    }

    @Test
    void testDuplicateTimingEvent() throws Exception {
        final var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <effectiveTime xsi:type="SXPR_TS" operator="A">
                    <comp xsi:type="EIVL_TS">
                        <event code="MORN"/>
                    </comp>
                    <comp xsi:type="EIVL_TS">
                        <event code="MORN"/> <!-- Twice MORN -->
                    </comp>
                </effectiveTime>
                <doseQuantity unit="g" value="1" />
                """);
        assertThrows(InvalidEmedContentException.class, reader::getDosageInstructions);
    }

    @Test
    void testUnsupportedDoseRegime() {
        assertThrows(InvalidEmedContentException.class, () -> this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.8" />
                """));
    }

    @Test
    void testRelatedComponentsInNormalDoseRegime() throws Exception {
        final var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="1" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="MORN" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="2.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                """);
        assertThrows(InvalidEmedContentException.class, reader::getDosageInstructions);
    }

    @Test
    void testBothTimingEventInNormalDoseRegime() throws Exception {
        final var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <effectiveTime xsi:type="EIVL_TS" operator="A">
                    <event code="MORN" />
                </effectiveTime>
                <effectiveTime xsi:type="SXPR_TS" operator="A">
                    <comp xsi:type="EIVL_TS">
                        <event code="NOON"/>
                    </comp>
                </effectiveTime>
                <doseQuantity unit="g" value="1" />
                """);
        assertThrows(InvalidEmedContentException.class, reader::getDosageInstructions);
    }

    @Test
    void testBadDosageInstructionTemplateId() throws Exception {

        final var completeElement = """
                <substanceAdministration classCode="SBADM" moodCode="INT" xmlns="urn:hl7-org:v3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                <templateId root="0.0.0.0.0.0.00000.0.0.0.0.0" />
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101200+0100" />
                    <high value="202203101200+0100" />
                </effectiveTime>
                <effectiveTime xsi:type="EIVL_TS" operator="A">
                    <event code="MORN" />
                </effectiveTime>
                <doseQuantity unit="mg" value="0.5" />
                </substanceAdministration>""";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, POCDMT000040SubstanceAdministration.class);
        final var substanceAdministration = (POCDMT000040SubstanceAdministration) JAXBIntrospector.getValue(root);

        assertThrows(InvalidEmedContentException.class, () -> new DosageInstructionsReader(substanceAdministration));
    }

    @Test
    void testGetDoseQuantity() throws Exception {
        final var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101200+0100" />
                    <high value="202203101200+0100" />
                </effectiveTime>
                <effectiveTime xsi:type="EIVL_TS" operator="A">
                    <event code="MORN" />
                </effectiveTime>
                <doseQuantity unit="mg" value="0.5" />""");

        assertTrue(reader.getDoseQuantity().isPresent());
        assertEquals(RegularUnitCodeAmbu.MG, reader.getDoseQuantity().get().getUnit());
        assertEquals("0.5", reader.getDoseQuantity().get().getValue());
    }

    @Test
    void testMissingRelatedComponentInSplitRegime() throws Exception {
        var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.9" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101043+0100" />
                    <high nullFlavor="UNK" />
                </effectiveTime>""");

        assertThrows(InvalidEmedContentException.class, reader::getDosageInstructions);
    }

    @Test
    void testTimingEventsInSplitRegime() throws Exception  {
        var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.9" />
                <effectiveTime xsi:type="SXPR_TS" operator="A">
                    <comp xsi:type="EIVL_TS">
                        <event code="MORN"/>
                    </comp>
                    <comp xsi:type="EIVL_TS" operator="I">
                        <event code="NOON"/>
                    </comp>
                </effectiveTime>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="1" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="MORN" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="2.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="2" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="NOON" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="1.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>""");

        assertThrows(InvalidEmedContentException.class, reader::getDosageInstructions);
    }

    @Test
    void testDosageTypeFromBadTemplateIds() {
        assertThrows(InvalidEmedContentException.class, () -> this.unmarshall("""
                <templateId root="0.0.0.0.0.0.00000.0.0.0.0.0.0.0" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101200+0100" />
                    <high value="202203101200+0100" />
                </effectiveTime>
                <effectiveTime xsi:type="EIVL_TS" operator="A">
                    <event code="MORN" />
                </effectiveTime>
                <doseQuantity unit="mg" value="0.5" />"""));
    }

    @Test
    void testGetSubordinateIntakeWithoutTimingEvent() throws Exception {
        var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.9" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101043+0100" />
                    <high nullFlavor="UNK" />
                </effectiveTime>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="1" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="MORN" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="2.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="2" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <!-- Missing timing event -->
                        <doseQuantity unit="{Dose}" value="1.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                """);

        assertThrows(InvalidEmedContentException.class, reader::getDosageInstructions);
    }

    @Test
    void testGetSubordinateIntakeWithoutDoseQuantity() throws Exception {
        var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.9" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101043+0100" />
                    <high nullFlavor="UNK" />
                </effectiveTime>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="1" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="MORN" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="2.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="2" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="EVE" />
                        </effectiveTime>
                        <!-- Missing dose quantity -->
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                """);

        assertThrows(InvalidEmedContentException.class, reader::getDosageInstructions);
    }

    @Test
    void testGetRelatedComponentsWithBadSequenceNumber() throws Exception {
        var reader = this.unmarshall("""
                <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.9" />
                <effectiveTime xsi:type="IVL_TS">
                    <low value="202201101043+0100" />
                    <high nullFlavor="UNK" />
                </effectiveTime>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="1" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="MORN" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="2.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                <entryRelationship typeCode="COMP">
                    <sequenceNumber value="0" />
                    <substanceAdministration moodCode="INT" classCode="SBADM">
                        <effectiveTime xsi:type="EIVL_TS">
                            <event code="NOON" />
                        </effectiveTime>
                        <doseQuantity unit="{Dose}" value="1.0"/>
                        <consumable>
                            <manufacturedProduct>
                                <manufacturedMaterial nullFlavor="NA" />
                            </manufacturedProduct>
                        </consumable>
                    </substanceAdministration>
                </entryRelationship>
                """);

        assertThrows(InvalidEmedContentException.class, reader::getDosageInstructions);
    }

    private DosageInstructionsReader unmarshall(final String substanceAdministrationContent) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<substanceAdministration classCode=\"SBADM\" moodCode=\"INT\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "<templateId root=\"1.3.6.1.4.1.19376.1.9.1.3.6\" />"
                + substanceAdministrationContent
                + "</substanceAdministration>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, POCDMT000040SubstanceAdministration.class);
        final var substanceAdministration = (POCDMT000040SubstanceAdministration) JAXBIntrospector.getValue(root);
        return new DosageInstructionsReader(substanceAdministration);
    }
}