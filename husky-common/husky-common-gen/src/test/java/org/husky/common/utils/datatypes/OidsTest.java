package org.husky.common.utils.datatypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.husky.common.utils.datatypes.Oids;

/**
 * Tests of the {@link Oids} class.
 *
 * @author Quentin Ligier
 */
class OidsTest {

    @Test
    void testPattern() {
        assertTrue(Oids.PATTERN.matcher("2.16.756.5.30.1.1.10.4.45").matches());
        assertTrue(Oids.PATTERN.matcher("1.3.6.1.4.1.19376.1.9.1.2.1").matches());
        assertTrue(Oids.PATTERN.matcher("2.16.840.1.113883.3.3190.100").matches());
        assertTrue(Oids.PATTERN.matcher("1").matches());
        assertTrue(Oids.PATTERN.matcher("1.2").matches());
        assertTrue(Oids.PATTERN.matcher("1.2.3").matches());
        assertTrue(Oids.PATTERN.matcher("0").matches());
        assertTrue(Oids.PATTERN.matcher("0.0").matches());
        assertTrue(Oids.PATTERN.matcher("2.999").matches());
        assertTrue(Oids.PATTERN.matcher("1.3.6.1.4.1.6141.2.60.11.1.1.9.45").matches());
        assertTrue(Oids.PATTERN.matcher("1.2.840.113556.1.8000.2554.40967.37373.28267.18762.46013.40187.49693.44605").matches());
        assertTrue(Oids.PATTERN.matcher("2.25.329800735698586629295641978511506172918").matches());

        assertFalse(Oids.PATTERN.matcher("2.16.756.5.30.1.1.10.4.45.").matches());
        assertFalse(Oids.PATTERN.matcher("1.3.6.1.4..1.19376.1.9.1.2.1").matches());
        assertFalse(Oids.PATTERN.matcher("3.16.840.1.113883.3.3190.100").matches());
        assertFalse(Oids.PATTERN.matcher("3").matches());
        assertFalse(Oids.PATTERN.matcher("4").matches());
        assertFalse(Oids.PATTERN.matcher("9").matches());
        assertFalse(Oids.PATTERN.matcher("1.00").matches());
        assertFalse(Oids.PATTERN.matcher("1fd28ce2-6ac9-4de4-9c3f-50883630d46f").matches());
    }

    @Test
    void testPatternWithUrn() {
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:2.16.756.5.30.1.1.10.4.45").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:1.3.6.1.4.1.19376.1.9.1.2.1").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:2.16.840.1.113883.3.3190.100").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:1").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:1.2").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:1.2.3").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:0").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:0.0").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:2.999").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:1.3.6.1.4.1.6141.2.60.11.1.1.9.45").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:1.2.840.113556.1.8000.2554.40967.37373.28267.18762.46013.40187.49693.44605").matches());
        assertTrue(Oids.PATTERN_WITH_URN.matcher("urn:oid:2.25.329800735698586629295641978511506172918").matches());

        assertFalse(Oids.PATTERN_WITH_URN.matcher("URN:oid:2.16.756.5.30.1.1.10.4.45.").matches());
        assertFalse(Oids.PATTERN_WITH_URN.matcher("urn:uuid:1.3.6.1.4..1.19376.1.9.1.2.1").matches());
        assertFalse(Oids.PATTERN_WITH_URN.matcher("urn:3.16.840.1.113883.3.3190.100").matches());
        assertFalse(Oids.PATTERN_WITH_URN.matcher("1.2.3").matches());
        assertFalse(Oids.PATTERN_WITH_URN.matcher("1fd28ce2-6ac9-4de4-9c3f-50883630d46f").matches());
    }

    @Test
    void testNormalize() {
        assertEquals("2.16.756.5.30.1.1.10.4.45", Oids.normalize("urn:oid:2.16.756.5.30.1.1.10.4.45"));
        assertEquals("2.999", Oids.normalize("2.999"));
    }
}