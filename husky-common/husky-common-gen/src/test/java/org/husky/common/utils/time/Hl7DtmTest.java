package org.husky.common.utils.time;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests of the {@link Hl7Dtm} class.
 *
 * @author Quentin Ligier
 */
class Hl7DtmTest {

    @Test
    void testToOffsetDateTime() {
        assertEquals(
                OffsetDateTime.parse("2021-12-01T12:34:56+00:00").toInstant(),
                Hl7Dtm.toOffsetDateTime("20211201123456").toInstant()
        );
    }

    @Test
    void testToHl7() {
        var dateTime = OffsetDateTime.parse("2021-12-01T12:34:56+00:00");
        assertEquals("20211201123456.0000+0000", new Hl7Dtm(dateTime, Hl7Dtm.Precision.FRAC_SECOND).toHl7());
        assertEquals("20211201123456+0000", new Hl7Dtm(dateTime, Hl7Dtm.Precision.SECOND).toHl7());
        assertEquals("202112011234+0000", new Hl7Dtm(dateTime, Hl7Dtm.Precision.MINUTE).toHl7());
        assertEquals("2021120112+0000", new Hl7Dtm(dateTime, Hl7Dtm.Precision.HOUR).toHl7());
        assertEquals("20211201", new Hl7Dtm(dateTime, Hl7Dtm.Precision.DAY).toHl7());
        assertEquals("202112", new Hl7Dtm(dateTime, Hl7Dtm.Precision.MONTH).toHl7());
        assertEquals("2021", new Hl7Dtm(dateTime, Hl7Dtm.Precision.YEAR).toHl7());

        dateTime = OffsetDateTime.parse("2021-12-01T12:34:56+03:00");
        assertEquals("2021120112+0300", new Hl7Dtm(dateTime, Hl7Dtm.Precision.HOUR).toHl7());

        dateTime = OffsetDateTime.parse("2021-12-01T12:34:56-11:45");
        assertEquals("2021120112-1145", new Hl7Dtm(dateTime, Hl7Dtm.Precision.HOUR).toHl7());
    }

    @Test
    void testFromHl7() {
        assertEquals(Hl7Dtm.Precision.FRAC_SECOND, Hl7Dtm.fromHl7("20211201123456.1234+0100").getPrecision());
        assertEquals(Hl7Dtm.Precision.FRAC_SECOND, Hl7Dtm.fromHl7("20211201123456.1234").getPrecision());
        assertEquals(Hl7Dtm.Precision.FRAC_SECOND, Hl7Dtm.fromHl7("20211201123456.1+0100").getPrecision());
        assertEquals(Hl7Dtm.Precision.FRAC_SECOND, Hl7Dtm.fromHl7("20211201123456.1").getPrecision());
        assertEquals(Hl7Dtm.Precision.SECOND, Hl7Dtm.fromHl7("20211201123456+0400").getPrecision());
        assertEquals(Hl7Dtm.Precision.SECOND, Hl7Dtm.fromHl7("20211201123456").getPrecision());
        assertEquals(Hl7Dtm.Precision.MINUTE, Hl7Dtm.fromHl7("202112011234-1200").getPrecision());
        assertEquals(Hl7Dtm.Precision.MINUTE, Hl7Dtm.fromHl7("202112011234").getPrecision());
        assertEquals(Hl7Dtm.Precision.HOUR, Hl7Dtm.fromHl7("2021120112-0130").getPrecision());
        assertEquals(Hl7Dtm.Precision.HOUR, Hl7Dtm.fromHl7("2021120112").getPrecision());
        assertEquals(Hl7Dtm.Precision.DAY, Hl7Dtm.fromHl7("20211201").getPrecision());
        assertEquals(Hl7Dtm.Precision.MONTH, Hl7Dtm.fromHl7("202112").getPrecision());
        assertEquals(Hl7Dtm.Precision.YEAR, Hl7Dtm.fromHl7("2021").getPrecision());
    }
}