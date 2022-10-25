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
package org.projecthusky.common.utils.datatypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link IheCx} class.
 *
 * @author Quentin Ligier
 **/
class IheCxTest {

    @Test
    void constructor() {
        IheCx cx = new IheCx("543797436", "1.2.840.113619.6.197");
        assertEquals("543797436", cx.getIdNumber());
        assertEquals("1.2.840.113619.6.197", cx.getAssigningAuthorityId());
        assertEquals("ISO", cx.getAssigningAuthorityTypeId());
    }

    @Test
    void render() {
        IheCx cx = new IheCx("543797436", "1.2.840.113619.6.197");
        assertEquals("543797436^^^&1.2.840.113619.6.197&ISO", cx.render());
    }

    @Test
    void parse() {
        IheCx cx = IheCx.parse("543797436^^^&1.2.840.113619.6.197&ISO");
        assertNotNull(cx);
        assertEquals("543797436", cx.getIdNumber());
        assertEquals("1.2.840.113619.6.197", cx.getAssigningAuthorityId());
        assertEquals("ISO", cx.getAssigningAuthorityTypeId());
    }

    @Test
    void validate() {
        assertTrue(IheCx.validate("543797436^^^&1.2.840.113619.6.197&ISO"));

        assertFalse(IheCx.validate("1234567^4^M11^ADT01^MR^University Hospital"));
        assertFalse(IheCx.validate("543797436^^^&1.2.840.113619.6.197&"));
        assertFalse(IheCx.validate("543797436^^^&&ISO"));
        assertFalse(IheCx.validate("543797436^^^ASD&1.2.840.113619.6.197&ISO"));
        assertFalse(IheCx.validate("543797436^^asd^&1.2.840.113619.6.197&ISO"));
        assertFalse(IheCx.validate("543797436^asd^^&1.2.840.113619.6.197&ISO"));
        assertFalse(IheCx.validate("^^^&1.2.840.113619.6.197&ISO"));
    }
}