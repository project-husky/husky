package org.husky.common.utils;

import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.io.output.NullOutputStream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Helper utilities related to streams.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class StreamUtils {

    /**
     * This class is not instantiable.
     */
    private StreamUtils() {
    }

    /**
     * Calculates the size of a stream.
     *
     * @param inputStream The stream to measure.
     * @return the size of the stream.
     * @throws IOException if the {@link InputStream} is unreadable.
     */
    public static long calculateSize(final InputStream inputStream) throws IOException {
        Objects.requireNonNull(inputStream);
        try {
            inputStream.reset();
        } catch (final IOException ex) {
            // Ignore "mark/reset not supported" exceptions for ByteArrayInputStream
        }
        try (final var counter = new CountingOutputStream(NullOutputStream.NULL_OUTPUT_STREAM)) {
            int b;
            while ((b = inputStream.read()) != -1) {
                counter.write(b);
            }
            return counter.getByteCount();
        }
    }
}
