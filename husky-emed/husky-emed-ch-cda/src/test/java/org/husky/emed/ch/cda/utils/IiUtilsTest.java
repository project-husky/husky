/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.husky.common.hl7cdar2.II;
import org.husky.emed.ch.models.common.QualifiedIdentifier;
import org.junit.jupiter.api.Test;

import java.util.UUID;

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
        assertTrue(IiUtils.isValidUid(this.createIi("1." + "1".repeat(126), null)));
        assertTrue(IiUtils.isValidUid(this.createIi("1.2.3", "a".repeat(64))));
        assertTrue(IiUtils.isValidUid(this.createIi("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", null)));
        assertTrue(IiUtils.isValidUid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));

        assertFalse(IiUtils.isValidUid(null));
        assertFalse(IiUtils.isValidUid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", "1.2.3")));
        assertFalse(IiUtils.isValidUid(this.createIi("1FD28CE26AC94DE49C3F50883630d46F", null)));
        assertFalse(IiUtils.isValidUid(this.createIi("urn:uuid:1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));
        assertFalse(IiUtils.isValidUid(this.createIi(null, "1.2.3")));
        assertFalse(IiUtils.isValidUid(this.createIi("1." + "1".repeat(127), null)));
        assertFalse(IiUtils.isValidUid(this.createIi("1.2.3", "a".repeat(65))));
        assertFalse(IiUtils.isValidUid(this.createIi("urn:oid:1.2.3", null)));
    }

    @Test
    void testGetUuid() {
        assertEquals(UUID.fromString("1fd28ce2-6ac9-4de4-9c3f-50883630d46f"), IiUtils.getUuid(this.createIi("1fd28ce2-6ac9-4de4-9c3f-50883630d46f", null)));
        assertEquals(UUID.fromString("1fd28ce2-6ac9-4de4-9c3f-50883630d46f"), IiUtils.getUuid(this.createIi("1FD28CE2-6AC9-4DE4-9C3F-50883630d46F", null)));

        assertThrows(IllegalArgumentException.class, () -> IiUtils.getUuid(this.createIi("urn:uuid:1fd28ce2-6ac9-4de4" +
                "-9c3f-50883630d46f", null)));
        assertThrows(IllegalArgumentException.class, () -> IiUtils.getUuid(this.createIi("1.2.3", null)));
        assertThrows(IllegalArgumentException.class, () -> IiUtils.getUuid(this.createIi(null, "1.2.3")));
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
    void testGetNormalizedCx() {
        assertEquals("2.16.756.5.30.1.1.10.4.45^^^&1.2.3&ISO",
                IiUtils.getNormalizedCx(this.createIi("2.16.756.5.30.1.1.10.4.45", "1.2.3")));

        assertEquals("", IiUtils.getNormalizedCx(this.createIi(null, "1.2.3")));
    }

    @Test
    void testFromQualifiedIdentifier() {
        assertEquals(this.createIi("2.16.756.5.30.1.1.10.4.45", "1.2.3").getRoot(),
                IiUtils.fromQualifiedIdentifier(new QualifiedIdentifier("1.2.3", "2.16.756.5.30.1.1.10.4.45")).getRoot());

        assertEquals(this.createIi("2.16.756.5.30.1.1.10.4.45", "1.2.3").getExtension(),
                IiUtils.fromQualifiedIdentifier(new QualifiedIdentifier("1.2.3", "2.16.756.5.30.1.1.10.4.45")).getExtension());
    }

    private II createIi(@Nullable final String root,
                        @Nullable final String extension) {
        final II ii = new II();
        ii.setRoot(root);
        ii.setExtension(extension);
        return ii;
    }
}