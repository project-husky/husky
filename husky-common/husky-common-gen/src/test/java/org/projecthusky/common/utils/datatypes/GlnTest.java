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
 * Tests of the {@link Gln} class.
 *
 * @author Quentin Ligier
 **/
class GlnTest {

    @Test
    void match() {
        assertFalse(Gln.match(""));
        assertFalse(Gln.match("1"));
        assertFalse(Gln.match("760100286012"));
        assertFalse(Gln.match("76010028601233"));

        // Ensure check digits is working
        assertFalse(Gln.match("7601002860120"));
        assertFalse(Gln.match("7601002860121"));
        assertFalse(Gln.match("7601002860122"));
        assertTrue(Gln.match("7601002860123"));
        assertFalse(Gln.match("7601002860124"));
        assertFalse(Gln.match("7601002860125"));
        assertFalse(Gln.match("7601002860126"));
        assertFalse(Gln.match("7601002860127"));
        assertFalse(Gln.match("7601002860128"));
        assertFalse(Gln.match("7601002860129"));

        // 0 is a special check digit
        assertTrue(Gln.match("7601002860420"));
    }
}