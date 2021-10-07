package org.ehealth_connector.common.utils;

import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.io.output.NullOutputStream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
    private StreamUtils() {}

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

    /**
     * Safe accessor to {@link List}s that returns null instead of throwing {@code IndexOutOfBoundsException}. Useful
     * in {@link java.util.Optional}s and {@link java.util.stream.Stream}s.
     *
     * @param list  The list.
     * @param index The index to access, positive or null.
     * @param <T>   The type of the list content.
     * @return the value of the list at the requested index as type {@code T} or {@code null}.
     */
    @Nullable
    public static <T> T getListIndex(final List<T> list, final int index) {
        Objects.requireNonNull(list);
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    /**
     * Safe accessor to {@link List}s that returns null instead of throwing {@code IndexOutOfBoundsException}. Useful
     * in {@link java.util.Optional}s and {@link java.util.stream.Stream}s.
     *
     * @param list The list.
     * @param <T>  The type of the list content.
     * @return the first value of the list as type {@code T} or {@code null}.
     */
    @Nullable
    public static <T> T getListFirst(final List<T> list) {
        Objects.requireNonNull(list);
        return getListIndex(list, 0);
    }
}
