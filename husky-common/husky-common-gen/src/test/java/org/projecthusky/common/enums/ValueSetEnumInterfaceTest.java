package org.projecthusky.common.enums;

import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link ValueSetEnumInterface}.
 *
 * @author Quentin Ligier
 */
class ValueSetEnumInterfaceTest {

    @Test
    void testGetCE() {
        assertEquals("L", ObservationInterpretation.LOW.getCD().getCode());
        assertEquals("2.16.840.1.113883.5.83", ObservationInterpretation.LOW.getCD().getCodeSystem());
        assertEquals("HL7ObservationInterpretation", ObservationInterpretation.LOW.getCD().getCodeSystemName());
        assertEquals("Tief", ObservationInterpretation.LOW.getCD().getDisplayName());
        assertNull(ObservationInterpretation.LOW.getCD().getCodeSystemVersion());

        assertEquals("L", ObservationInterpretation.LOW.getCD(LanguageCode.FRENCH).getCode());
        assertEquals("2.16.840.1.113883.5.83", ObservationInterpretation.LOW.getCD(LanguageCode.FRENCH).getCodeSystem());
        assertEquals("HL7ObservationInterpretation", ObservationInterpretation.LOW.getCD(LanguageCode.FRENCH).getCodeSystemName());
        assertEquals("Bas", ObservationInterpretation.LOW.getCD(LanguageCode.FRENCH).getDisplayName());
    }

    @Test
    void testGetCD() {
        assertEquals("POS", ObservationInterpretation.POS.getCD().getCode());
        assertEquals("2.16.840.1.113883.5.83", ObservationInterpretation.POS.getCD().getCodeSystem());
        assertEquals("HL7ObservationInterpretation", ObservationInterpretation.POS.getCD().getCodeSystemName());
        assertEquals("Positiv", ObservationInterpretation.POS.getCD().getDisplayName());
        assertNull(ObservationInterpretation.POS.getCD().getCodeSystemVersion());

        assertEquals("POS", ObservationInterpretation.POS.getCD(LanguageCode.ITALIAN).getCode());
        assertEquals("2.16.840.1.113883.5.83", ObservationInterpretation.POS.getCD(LanguageCode.ITALIAN).getCodeSystem());
        assertEquals("HL7ObservationInterpretation", ObservationInterpretation.POS.getCD(LanguageCode.ITALIAN).getCodeSystemName());
        assertEquals("Positivo", ObservationInterpretation.POS.getCD(LanguageCode.ITALIAN).getDisplayName());
    }

    @Test
    void testGetCode() {
        assertEquals("I", ObservationInterpretation.INTERMEDIATE.getCode().getCode());
        assertEquals("2.16.840.1.113883.5.83", ObservationInterpretation.INTERMEDIATE.getCode().getCodeSystem());
        assertEquals("Intermediär", ObservationInterpretation.INTERMEDIATE.getCode().getDisplayName());

        assertEquals("I", ObservationInterpretation.INTERMEDIATE.getCode(LanguageCode.ENGLISH).getCode());
        assertEquals("2.16.840.1.113883.5.83", ObservationInterpretation.INTERMEDIATE.getCode(LanguageCode.ENGLISH).getCodeSystem());
        assertEquals("Intermediate", ObservationInterpretation.INTERMEDIATE.getCode(LanguageCode.ENGLISH).getDisplayName());
    }

    @Test
    void getIpfCode() {
        assertEquals(
                new Code("R", new LocalizedString("Resistant", "en", "UTF-8"), "2.16.840.1.113883.5.83"),
                ObservationInterpretation.RESISTANT.getIpfCode()
        );
    }

    @Test
    void testIsEqualTo() {
        assertTrue(ObservationInterpretation.NEG.isEqualTo(new Code("NEG", null, "2.16.840.1.113883.5.83")));
        assertTrue(ObservationInterpretation.NEG.isEqualTo(new Code("NEG", new LocalizedString(), "2.16.840.1.113883.5.83")));
        assertTrue(ObservationInterpretation.NEG.isEqualTo(new Code("NEG", new LocalizedString("NEGATIVE"), "2.16.840" +
                ".1.113883.5.83")));
        assertFalse(ObservationInterpretation.NEG.isEqualTo(new Code("POS", null, "2.16.840.1.113883.5.83")));
        assertFalse(ObservationInterpretation.NEG.isEqualTo(new Code("NEG", null, "2.16.840.1.113883.5.82")));
    }

    @Test
    void testIsContainedIn() {
        assertTrue(ObservationInterpretation.NORMAL.isContainedIn(List.of(new Code("N", null, "2.16.840.1.113883.5.83"))));
        assertTrue(ObservationInterpretation.NORMAL.isContainedIn(List.of(new Code("N", null, "2.16.840.1.113883.5.83"))));

        assertFalse(ObservationInterpretation.NORMAL.isContainedIn(List.of(new Code("AN", null, "2.16.840.1.113883.5" +
                ".83"))));
        assertFalse(ObservationInterpretation.NORMAL.isContainedIn(Collections.emptyList()));
        assertFalse(ObservationInterpretation.NORMAL.isContainedIn(Collections.emptySet()));
    }

    @Test
    void testGetCodedString() {
        assertEquals("AA^^^&2.16.840.1.113883.5.83&ISO", ObservationInterpretation.ABNORMAL_ALERT.getCodedString());
    }

    @Test
    void testGetDisplayName() {
        assertEquals("High", ObservationInterpretation.HIGH.getDisplayName());
        assertEquals("Hoch", ObservationInterpretation.HIGH.getDisplayName(null));
        assertEquals("High", ObservationInterpretation.HIGH.getDisplayName(LanguageCode.ENGLISH));
        assertEquals("Hoch", ObservationInterpretation.HIGH.getDisplayName(LanguageCode.GERMAN));
        assertEquals("Haut", ObservationInterpretation.HIGH.getDisplayName(LanguageCode.FRENCH));
        assertEquals("Alto", ObservationInterpretation.HIGH.getDisplayName(LanguageCode.ITALIAN));
    }
}
