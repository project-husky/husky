package org.ehealth_connector.common.utils.datatypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link Hl7v25} class.
 *
 * @author Quentin Ligier
 */
class Hl7v25Test {

    @Test
    void testEncodeSt() {
        assertEquals("", Hl7v25.encodeSt(""));
        assertEquals("1234", Hl7v25.encodeSt("1234"));
        assertEquals("a\\F\\b", Hl7v25.encodeSt("a|b"));
        assertEquals("Obstetrician \\T\\ Gynaecologist", Hl7v25.encodeSt("Obstetrician & Gynaecologist"));
        assertEquals("10\\S\\9/l", Hl7v25.encodeSt("10^9/l"));
        assertEquals("a\\R\\b", Hl7v25.encodeSt("a~b"));
        assertEquals("201104\\E\\123456", Hl7v25.encodeSt("201104\\123456"));
        assertEquals("Pierre DuRho\\S\\ne \\T\\ Cie", Hl7v25.encodeSt("Pierre DuRho^ne & Cie"));
    }
}