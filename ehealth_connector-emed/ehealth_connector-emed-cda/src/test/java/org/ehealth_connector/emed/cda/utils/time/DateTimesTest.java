package org.ehealth_connector.emed.cda.utils.time;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests of the {@link DateTimes} class.
 *
 * @author Quentin Ligier
 */
class DateTimesTest {

    @Test
    void testCompleteToEarliestInstant() {
        assertEquals("20190101000000.0000+0000", completeToEarliestInstant("2019"));
        assertEquals("20190301000000.0000+0000", completeToEarliestInstant("201903"));
        assertEquals("20190625000000.0000+0000", completeToEarliestInstant("20190625"));
        assertEquals("20190423170000.0000+0000", completeToEarliestInstant("2019042317"));
        assertEquals("20190807123400.0000+0000", completeToEarliestInstant("201908071234"));
        assertEquals("20191231235959.0000+0000", completeToEarliestInstant("20191231235959"));
        assertEquals("20191231235959.0000+0000", completeToEarliestInstant("20191231235959.0"));
        assertEquals("20191231235959.0123+0000", completeToEarliestInstant("20191231235959.0123"));
    }

    private String completeToEarliestInstant(final String originalHl7Dtm) {
        return DateTimes.completeToEarliestInstant(Hl7Dtm.fromHl7(originalHl7Dtm)).toHl7();
    }

    @Test
    void testCompleteToLatestInstant() {
        assertEquals("20191231235959.9990+0000", completeToLatestInstant("2019"));
        assertEquals("20190331235959.9990+0000", completeToLatestInstant("201903"));
        assertEquals("20190625235959.9990+0000", completeToLatestInstant("20190625"));
        assertEquals("20190423175959.9990+0000", completeToLatestInstant("2019042317"));
        assertEquals("20190807123459.9990+0000", completeToLatestInstant("201908071234"));
        assertEquals("20191231235858.9990+0000", completeToLatestInstant("20191231235858"));
        assertEquals("20191231235858.3000+0000", completeToLatestInstant("20191231235858.3"));
        assertEquals("20191231235858.3694+0000", completeToLatestInstant("20191231235858.3694"));
        assertEquals("20190131235959.9990+0000", completeToLatestInstant("201901"));
        assertEquals("20190228235959.9990+0000", completeToLatestInstant("201902"));
        assertEquals("20180228235959.9990+0000", completeToLatestInstant("201802"));
        assertEquals("20200229235959.9990+0000", completeToLatestInstant("202002"));
    }

    private String completeToLatestInstant(final String originalHl7Dtm) {
        return DateTimes.completeToLatestInstant(Hl7Dtm.fromHl7(originalHl7Dtm)).toHl7();
    }

    @Test
    void testToInstant() {
        assertEquals("2020-01-01T00:00:00Z", DateTimes.toInstant(Hl7Dtm.fromHl7("20200101")).toString());
        assertEquals("2020-01-01T00:00:00Z", DateTimes.toInstant(Hl7Dtm.fromHl7("20200101000000")).toString());
    }
}