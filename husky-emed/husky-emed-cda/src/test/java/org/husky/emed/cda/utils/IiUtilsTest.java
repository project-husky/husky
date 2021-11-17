package org.husky.emed.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.hl7cdar2.II;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link IiUtils} class.
 *
 * @author Quentin Ligier
 */
class IiUtilsTest {

    @Test
    void testIsValidUid() {
        assertTrue(IiUtils.isValidUid(this.createIi("2.16.756.5.30.1.1.10.4.45", "1.2.3")));
        assertTrue(IiUtils.isValidUid(this.createIi("urn:oid:1.2.3", null)));
        assertTrue(IiUtils.isValidUid(this.createIi("1." + "1".repeat(126), null)));
        assertTrue(IiUtils.isValidUid(this.createIi("1.2.3", "a".repeat(64))));
        assertTrue(IiUtils.isValidUid(this.createIi("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", null)));
        assertTrue(IiUtils.isValidUid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));
        assertTrue(IiUtils.isValidUid(this.createIi("urn:uuid:1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));

        assertFalse(IiUtils.isValidUid(null));
        assertFalse(IiUtils.isValidUid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", "1.2.3")));
        assertFalse(IiUtils.isValidUid(this.createIi("1FD28CE26AC94DE49C3F50883630d46F", null)));
        assertFalse(IiUtils.isValidUid(this.createIi(null, "1.2.3")));
        assertFalse(IiUtils.isValidUid(this.createIi("1." + "1".repeat(127), null)));
        assertFalse(IiUtils.isValidUid(this.createIi("1.2.3", "a".repeat(65))));
    }

    @Test
    void testNormalizeUid() {
        assertEquals("2.16.756.5.30.1.1.10.4.45^1.2.3", IiUtils.getNormalizedUid(this.createIi("2.16.756.5.30.1.1.10.4.45", "1" + ".2.3")));
        assertEquals("1.2.3", IiUtils.getNormalizedUid(this.createIi("urn:oid:1.2.3", null)));
        assertEquals("1." + "1".repeat(126), IiUtils.getNormalizedUid(this.createIi("1." + "1".repeat(126), null)));
        assertEquals("1.2.3^" + "a".repeat(64), IiUtils.getNormalizedUid(this.createIi("1.2.3", "a".repeat(64))));
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", IiUtils.getNormalizedUid(this.createIi("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", null)));
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", IiUtils.getNormalizedUid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", IiUtils.getNormalizedUid(this.createIi("urn:uuid:1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));
    }

    @Test
    void testIsValidUuid() {
        assertTrue(IiUtils.isValidUuid(this.createIi("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", null)));
        assertTrue(IiUtils.isValidUuid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));

        assertFalse(IiUtils.isValidUuid(null));
        assertFalse(IiUtils.isValidUuid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", "1.2.3")));
        assertFalse(IiUtils.isValidUuid(this.createIi("1FD28CE26AC94DE49C3F50883630d46F", null)));
        assertFalse(IiUtils.isValidUuid(this.createIi(null, "1.2.3")));
        assertFalse(IiUtils.isValidUuid(this.createIi("2.16.756.5.30.1.1.10.4.45", "1.2.3")));
        assertFalse(IiUtils.isValidUuid(this.createIi("urn:oid:1.2.3", null)));
    }

    @Test
    void testNormalizeUuid() {
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f",
                IiUtils.getNormalizedUuid(this.createIi("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", null)));
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f",
                IiUtils.getNormalizedUuid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));
        assertEquals("1fd28ce2-6ac9-4de4-9c3f-50883630d46f",
                IiUtils.getNormalizedUuid(this.createIi("urn:uuid:1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));
    }

    private II createIi(@Nullable final String root,
                        @Nullable final String extension) {
        final II ii = new II();
        ii.setRoot(root);
        ii.setExtension(extension);
        return ii;
    }
}