package org.projecthusky.common.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link IoStreamUtils} class.
 *
 * @author Quentin Ligier
 */

class IoStreamUtilsTest {

    @Test
    void testCalculateSize() throws Exception {
        assertEquals(4, IoStreamUtils.calculateSize(isFromString("asdf")));
        assertEquals(0, IoStreamUtils.calculateSize(isFromString("")));
        assertEquals(6, IoStreamUtils.calculateSize(isFromString("éàè")));
    }

    @Test
    void testCalculateSizeOfReadInputStream() throws Exception {
        final InputStream is = isFromString("asdf");
        is.skip(2);
        assertEquals(4, IoStreamUtils.calculateSize(is));
    }

    private InputStream isFromString(final String string) {
        Objects.requireNonNull(string);
        return new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
    }
}