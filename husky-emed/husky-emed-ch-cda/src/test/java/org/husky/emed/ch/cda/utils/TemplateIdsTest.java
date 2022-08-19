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

import org.husky.common.hl7cdar2.II;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests of the {@link TemplateIds} class.
 *
 * @author Quentin Ligier
 **/
class TemplateIdsTest {

    private final static II II1 = stringToIi("1.2.3.1");
    private final static II II2 = stringToIi("1.2.3.2");
    private final static II II3 = stringToIi("1.2.3.3");
    private final static II II4 = stringToIi("1.2.3.4");
    private final static II II5 = stringToIi("1.2.3.5");
    private final static II II6 = stringToIi("1.2.3.6");
    private final static II II7 = stringToIi("1.2.3.7");
    private final static II II8 = stringToIi("1.2.3.8");

    @Test
    void isInList() {
        assertTrue(TemplateIds.isInList("1.2.3.1", List.of(II1)));
        assertTrue(TemplateIds.isInList("1.2.3.1", List.of(II1, II2, II3)));
        assertTrue(TemplateIds.isInList("1.2.3.1", List.of(II3, II2, II1)));
        assertTrue(TemplateIds.isInList("1.2.3.1", List.of(II2, II3, II4, II5, II6, II7, II8, II7, II1)));
        assertTrue(TemplateIds.isInList("1.2.3.1", List.of(II1, II1, II1)));

        assertFalse(TemplateIds.isInList("1.2.3.1", List.of(II2)));
        assertFalse(TemplateIds.isInList("1.2.3.1", List.of(II2, II3, II4, II5, II6, II7, II8, II7)));
        assertFalse(TemplateIds.isInList("1.2.3.1", List.of()));
        assertFalse(TemplateIds.isInList("1.2.3.1", null));
    }

    @Test
    void hasAllIds() {
        assertTrue(TemplateIds.hasAllIds(List.of(), List.of()));
        assertTrue(TemplateIds.hasAllIds(List.of(), List.of(II1, II2, II3)));
        assertTrue(TemplateIds.hasAllIds(List.of("1.2.3.1"), List.of(II1)));
        assertTrue(TemplateIds.hasAllIds(List.of("1.2.3.1"), List.of(II2, II1)));
        assertTrue(TemplateIds.hasAllIds(List.of("1.2.3.1"), List.of(II2, II3, II4, II5, II6, II7, II8, II7, II1)));
        assertTrue(TemplateIds.hasAllIds(List.of("1.2.3.1", "1.2.3.2"), List.of(II2, II1)));
        assertTrue(TemplateIds.hasAllIds(List.of("1.2.3.1", "1.2.3.2"), List.of(II2, II3, II4, II5, II6, II7, II8, II7, II1)));
        assertTrue(TemplateIds.hasAllIds(List.of("1.2.3.1", "1.2.3.2", "1.2.3.7"), List.of(II2, II3, II4, II5, II6, II7, II8, II7, II1)));

        assertFalse(TemplateIds.hasAllIds(List.of("1.2.3.1"), List.of()));
        assertFalse(TemplateIds.hasAllIds(List.of("1.2.3.1"), List.of(II2, II3)));
        assertFalse(TemplateIds.hasAllIds(List.of("1.2.3.1", "1.2.3.2"), List.of(II2, II3)));
        assertFalse(TemplateIds.hasAllIds(List.of("1.2.3.1", "1.2.3.2"), List.of(II1, II3)));
        assertFalse(TemplateIds.hasAllIds(List.of("1.2.3.1", "1.2.3.2"), null));
    }

    @Test
    void anyInList() {
        assertTrue(TemplateIds.anyInList(List.of(), List.of()));
        assertTrue(TemplateIds.anyInList(List.of(), List.of(II1, II2, II3)));
        assertTrue(TemplateIds.anyInList(List.of("1.2.3.1"), List.of(II1)));
        assertTrue(TemplateIds.anyInList(List.of("1.2.3.1"), List.of(II2, II1)));
        assertTrue(TemplateIds.anyInList(List.of("1.2.3.1"), List.of(II2, II3, II4, II5, II6, II7, II8, II7, II1)));
        assertTrue(TemplateIds.anyInList(List.of("1.2.3.1", "1.2.3.2"), List.of(II2, II1)));
        assertTrue(TemplateIds.anyInList(List.of("1.2.3.1", "1.2.3.2"), List.of(II2, II3, II4, II5, II6, II7, II8, II7, II1)));
        assertTrue(TemplateIds.anyInList(List.of("1.2.3.1", "1.2.3.2", "1.2.3.7"), List.of(II2, II3, II4, II5, II6, II7, II8, II7, II1)));
        assertTrue(TemplateIds.anyInList(List.of("1.2.3.1", "1.2.3.2"), List.of(II2, II3)));
        assertTrue(TemplateIds.anyInList(List.of("1.2.3.1", "1.2.3.2"), List.of(II1, II3)));

        assertFalse(TemplateIds.anyInList(List.of("1.2.3.1"), List.of()));
        assertFalse(TemplateIds.anyInList(List.of("1.2.3.1"), List.of(II2, II3)));
        assertFalse(TemplateIds.anyInList(List.of("1.2.3.1"), null));
    }

    private static II stringToIi(final String oid) {
        final II ii = new II();
        ii.setRoot(oid);
        return ii;
    }
}
