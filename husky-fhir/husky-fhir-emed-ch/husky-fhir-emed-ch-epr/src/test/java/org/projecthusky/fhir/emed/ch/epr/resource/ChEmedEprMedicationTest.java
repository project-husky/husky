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
package org.projecthusky.fhir.emed.ch.epr.resource;

import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link ChEmedEprParser}.
 *
 * @author Quentin Ligier
 **/
class ChEmedEprMedicationTest {

    @Test
    void testSettingCodes() {
        var medication = new ChEmedEprMedication();
        assertFalse(medication.hasGtin());
        assertFalse(medication.hasAtc());

        medication.setGtin("1234", "GTIN");
        medication.setAtc("4321", "ATC");
        assertTrue(medication.hasGtin());
        assertTrue(medication.hasAtc());
        assertEquals("1234", medication.resolveGtinCode());
        assertEquals("4321", medication.resolveAtcCode());
        assertEquals("GTIN", medication.getCode().getText());
        assertEquals("GTIN", medication.getCode().getCoding().get(0).getDisplay());
        assertEquals("ATC", medication.getCode().getCoding().get(1).getDisplay());

        medication = new ChEmedEprMedication();
        assertFalse(medication.hasGtin());
        assertFalse(medication.hasAtc());

        medication.setAtc("4321", "ATC");
        medication.setGtin("1234", "GTIN");
        assertEquals("ATC", medication.getCode().getText());

        medication = new ChEmedEprMedication();
        medication.getCode().setText("Test");
        medication.setAtc("4321", "ATC");
        medication.setGtin("1234", "GTIN");
        assertEquals("Test", medication.getCode().getText());
    }
}