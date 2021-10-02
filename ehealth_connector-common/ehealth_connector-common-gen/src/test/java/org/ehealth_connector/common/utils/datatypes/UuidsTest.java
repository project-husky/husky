package org.ehealth_connector.common.utils.datatypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link Uuids} class.
 *
 * @author Quentin Ligier
 */
class UuidsTest {

    @Test
    void testPattern() {
        assertTrue(Uuids.PATTERN.matcher("1fd28ce2-6ac9-4de4-9c3f-50883630d46f").matches());
        assertTrue(Uuids.PATTERN.matcher("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F").matches());

        assertFalse(Uuids.PATTERN.matcher("1fd28ce2-6ac9-4de4-9c3f-50883630d46z").matches());
        assertFalse(Uuids.PATTERN.matcher("urn:uuid:1fd28ce2-6ac9-4de4-9c3f-50883630d46f").matches());
        assertFalse(Uuids.PATTERN.matcher("urn:uuid:1FD28CE2-6AC9-4DE4-9C3F-50883630d46F").matches());
    }

    @Test
    void testPatternWithUrn() {
        assertTrue(Uuids.PATTERN_WITH_URN.matcher("urn:uuid:1fd28ce2-6ac9-4de4-9c3f-50883630d46f").matches());
        assertTrue(Uuids.PATTERN_WITH_URN.matcher("urn:uuid:1FD28CE2-6AC9-4DE4-9C3F-50883630d46F").matches());

        assertFalse(Uuids.PATTERN_WITH_URN.matcher("1fd28ce2-6ac9-4de4-9c3f-50883630d46f").matches());
        assertFalse(Uuids.PATTERN_WITH_URN.matcher("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F").matches());
        assertFalse(Uuids.PATTERN_WITH_URN.matcher("1fd28ce2-6ac9-4de4-9c3f-50883630d46z").matches());
    }

    @Test
    void testNormalize() {
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", Uuids.normalize("1fd28ce2-6ac9-4de4-9c3f-50883630d46f"));
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", Uuids.normalize("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F"));
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", Uuids.normalize("urn:uuid:1fd28ce2-6ac9-4de4-9c3f-50883630d46f"));
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", Uuids.normalize("urn:uuid:1FD28CE2-6AC9-4DE4-9C3F-50883630d46F"));
    }
}