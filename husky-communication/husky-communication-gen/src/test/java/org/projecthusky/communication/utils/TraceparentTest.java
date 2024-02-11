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
package org.projecthusky.communication.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bench for the {@link Traceparent} class.
 *
 * @author Quentin Ligier
 **/
class TraceparentTest {

    @Test
    void testParse() {
        var traceparent = Traceparent.parse("00-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-01");
        assertEquals(0, traceparent.version());
        assertEquals("0af7651916cd43dd8448eb211c80319c", traceparent.traceId());
        assertEquals("b7ad6b7169203331", traceparent.parentId());
        assertEquals(1, traceparent.flags());
        assertEquals("00-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-01", traceparent.toString());

        traceparent = Traceparent.parse("fe-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-ff");
        assertEquals(254, traceparent.version());
        assertEquals("4bf92f3577b34da6a3ce929d0e0e4736", traceparent.traceId());
        assertEquals("00f067aa0ba902b7", traceparent.parentId());
        assertEquals(255, traceparent.flags());
        assertEquals("fe-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-ff", traceparent.toString());
    }

    @Test
    void testWithers() {
        var traceparent = Traceparent.parse("00-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-01");
        assertEquals("00-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-01", traceparent.toString());

        traceparent = traceparent.withVersion("02");
        assertEquals("02-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-01", traceparent.toString());

        traceparent = traceparent.withTraceId("4bf92f3577b34da6a3ce929d0e0e4736");
        assertEquals("02-4bf92f3577b34da6a3ce929d0e0e4736-b7ad6b7169203331-01", traceparent.toString());

        traceparent = traceparent.withParentId("00f067aa0ba902b7");
        assertEquals("02-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-01", traceparent.toString());

        traceparent = traceparent.withFlags("ff");
        assertEquals("02-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-ff", traceparent.toString());

        traceparent = traceparent.withRandomParentId();
        assertNotEquals("00f067aa0ba902b7", traceparent.parentId());
    }

    @Test
    void testInvalids() {
        assertThrows(IllegalArgumentException.class, () -> Traceparent.parse("ff-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-00"));

        final var traceparent = Traceparent.parse("00-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-01");
        assertThrows(IllegalArgumentException.class, () -> traceparent.withVersion("ff"));
    }

    @Test
    void testEquals() {
        var traceparent1 = Traceparent.parse("00-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-01");
        var traceparent2 = Traceparent.parse("00-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-01");
        var traceparent3 = Traceparent.parse("00-0af7651916cd43dd8448eb211c80319c-b7ad6b7169203331-02");
        assertEquals(traceparent1, traceparent2);
        assertNotEquals(traceparent1, traceparent3);

        traceparent1 = Traceparent.random();
        traceparent2 = Traceparent.random();
        traceparent3 = Traceparent.random();
        assertNotEquals(traceparent1, traceparent2);
        assertNotEquals(traceparent2, traceparent3);
        assertNotEquals(traceparent1, traceparent3);
    }
}