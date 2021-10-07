package org.ehealth_connector.common.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link StreamUtils} class.
 *
 * @author Quentin Ligier
 */

class StreamUtilsTest {

    @Test
    void testCalculateSize() throws Exception {
        assertEquals(4, StreamUtils.calculateSize(isFromString("asdf")));
        assertEquals(0, StreamUtils.calculateSize(isFromString("")));
        assertEquals(6, StreamUtils.calculateSize(isFromString("éàè")));
    }

    @Test
    void testCalculateSizeOfReadInputStream() throws Exception {
        final InputStream is = isFromString("asdf");
        is.skip(2);
        assertEquals(4, StreamUtils.calculateSize(is));
    }

    private InputStream isFromString(final String string) {
        Objects.requireNonNull(string);
        return new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
    }
}