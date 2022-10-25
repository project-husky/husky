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
 * Tests of the {@link IheXon} class.
 *
 * @author Quentin Ligier
 **/
class IheXonTest {

    @Test
    void constructor() {
        IheXon xon = new IheXon("Some Hospital", null, null);
        assertEquals("Some Hospital", xon.getOrganizationName());
        assertNull(xon.getOrganizationId());
        assertNull(xon.getAssigningAuthorityId());
        assertNull(xon.getAssigningAuthorityIdType());

        xon = new IheXon("Some Hospital", "2.999.1.2.3.4.5.6.7.8.9.1789.45", null);
        assertEquals("Some Hospital", xon.getOrganizationName());
        assertEquals("2.999.1.2.3.4.5.6.7.8.9.1789.45", xon.getOrganizationId());
        assertNull(xon.getAssigningAuthorityId());
        assertNull(xon.getAssigningAuthorityIdType());


        xon = new IheXon("Some Hospital", "45", "2.999.1.2.3.4.5.6.7.8.9.1789");
        assertEquals("Some Hospital", xon.getOrganizationName());
        assertEquals("45", xon.getOrganizationId());
        assertEquals("2.999.1.2.3.4.5.6.7.8.9.1789", xon.getAssigningAuthorityId());
        assertEquals("ISO", xon.getAssigningAuthorityIdType());
    }

    @Test
    void render() {
        IheXon xon = new IheXon("Some Hospital", null, null);
        assertEquals("Some Hospital", xon.render());

        xon = new IheXon("Some Hospital", "2.999.1.2.3.4.5.6.7.8.9.1789.45", null);
        assertEquals("Some Hospital^^^^^^^^^2.999.1.2.3.4.5.6.7.8.9.1789.45", xon.render());


        xon = new IheXon("Some Hospital", "45", "2.999.1.2.3.4.5.6.7.8.9.1789");
        assertEquals("Some Hospital^^^^^&2.999.1.2.3.4.5.6.7.8.9.1789&ISO^^^^45", xon.render());
    }

    @Test
    void parse() {
        IheXon xon = IheXon.parse("Some Hospital");
        assertNotNull(xon);
        assertEquals("Some Hospital", xon.getOrganizationName());
        assertNull(xon.getOrganizationId());
        assertNull(xon.getAssigningAuthorityId());
        assertNull(xon.getAssigningAuthorityIdType());

        xon = IheXon.parse("Some Hospital^^^^^^^^^2.999.1.2.3.4.5.6.7.8.9.1789.45");
        assertNotNull(xon);
        assertEquals("Some Hospital", xon.getOrganizationName());
        assertEquals("2.999.1.2.3.4.5.6.7.8.9.1789.45", xon.getOrganizationId());
        assertNull(xon.getAssigningAuthorityId());
        assertNull(xon.getAssigningAuthorityIdType());


        xon = IheXon.parse("Some Hospital^^^^^&2.999.1.2.3.4.5.6.7.8.9.1789&ISO^^^^45");
        assertNotNull(xon);
        assertEquals("Some Hospital", xon.getOrganizationName());
        assertEquals("45", xon.getOrganizationId());
        assertEquals("2.999.1.2.3.4.5.6.7.8.9.1789", xon.getAssigningAuthorityId());
        assertEquals("ISO", xon.getAssigningAuthorityIdType());
    }

    @Test
    void validate() {
        assertTrue(IheXon.validate("Some Hospital"));
        assertTrue(IheXon.validate("Some Hospital^^^^^^^^^2.999.1.2.3.4.5.6.7.8.9.1789.45"));
        assertTrue(IheXon.validate("Some Hospital^^^^^&2.999.1.2.3.4.5.6.7.8.9.1789&ISO^^^^45"));
        assertTrue(IheXon.validate("Some Hospital With A Name Longer Than 50 Characters, The Limit for HL7v2.5 XON " +
                "But Not For XDS XON"));

        assertFalse(IheXon.validate("Good Health Hospital^L^716^9^M10^&Hospital Master.Community Health and " +
                "Hospitals&L^XX^&Central Offices.Community Health and Hospitals&L^A")); // Illegal fields
        assertFalse(IheXon.validate("Good Health Hospital^L^4544^3^M10^CMS^XX^^A")); // Illegal fields
        assertFalse(IheXon.validate("^^^^^^^^^2.999.1.2.3.4.5.6.7.8.9.1789.45")); // Missing organization name
        assertFalse(IheXon.validate("Some Hospital^^^^^&2.999.1.2.3.4.5.6.7.8.9.1789&BADVALUE^^^^45")); // Bad
        // assigning authority id type
        assertFalse(IheXon.validate("Some Hospital^^^^^&2.999.1.2.3.4.5.6.7.8.9.1789&^^^^45")); // Missing assigning
        // authority id type
        assertFalse(IheXon.validate("Some Hospital With A Name Longer Than 50 Characters, The Limit for HL7v2.5 XON " +
                "But Not For XDS XON And Some Filling " +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ " +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ^^^^^&2.999.1.2.3.4.5.6.7.8.9.1789&ISO^^^^45")); // Longer than the max limit
    }
}