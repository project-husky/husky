package org.projecthusky.communication.utils;

import java.util.Objects;
import java.util.random.RandomGenerator;

/**
 * A class representing a traceparent.
 * <p>
 * The traceId value is managed in the same way as {@link java.util.UUID}.
 *
 * @see <a href="https://www.w3.org/TR/trace-context/">Trace Context</a>
 * @author Quentin Ligier
 */
public class Traceparent {

    /**
     * The version of the traceparent. 8-bit unsigned integer. Version ff is invalid.
     */
    private final byte version;

    /**
     * The trace id. Split in two longs. 16-byte unsigned integer.
     */
    private final long traceIdMostSigBits;
    private final long traceIdLeastSigBits;

    /**
     * The parent id. 8-byte unsigned integer.
     */
    private final long parentId;

    /**
     * The flags. 8-bit unsigned integer.
     */
    private final byte flags;

    /**
     * Creates a new traceparent.
     *
     * @param version The version of the traceparent. 8-bit unsigned integer. Version ff is invalid.
     * @param traceIdMostSigBits The most significant bits of the traceId. 8-byte unsigned integer.
     * @param traceIdLeastSigBits The least significant bits of the traceId. 8-byte unsigned integer.
     * @param parentId The parent id. 8-byte unsigned integer.
     * @param flags The flags. 8-bit unsigned integer.
     */
    public Traceparent(byte version,
                       long traceIdMostSigBits,
                       long traceIdLeastSigBits,
                       long parentId,
                       byte flags) {
        this.version = version;
        this.traceIdMostSigBits = traceIdMostSigBits;
        this.traceIdLeastSigBits = traceIdLeastSigBits;
        this.parentId = parentId;
        this.flags = flags;
        if (version == (byte) 255) {
            throw new IllegalArgumentException("Version ff is invalid");
        }
    }

    /**
     * Generates a random traceparent, with version 0 and flags 0.
     */
    public static Traceparent random() {
        final var random = RandomGenerator.getDefault();
        return new Traceparent((byte) 0, random.nextLong(), random.nextLong(), random.nextLong(), (byte) 0);
    }

    /**
     * Parses a traceparent from a string.
     */
    public static Traceparent parse(final String value) {
        final String[] parts = value.split("-");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid traceparent format");
        }

        if (!isLowercaseHex(parts[0], 2)) {
            throw new IllegalArgumentException("The traceparent version shall be a two characters string");
        }
        final byte version = (byte)Integer.parseInt(parts[0], 16);

        if (!isLowercaseHex(parts[1], 32)) {
            throw new IllegalArgumentException("The traceparent traceId shall be a 32 characters string");
        }
        final long traceIdMostSigBits = Long.parseUnsignedLong(parts[1].substring(0, 16), 16);
        final long traceIdLeastSigBits = Long.parseUnsignedLong(parts[1].substring(16, 32), 16);

        if (!isLowercaseHex(parts[2], 16)) {
            throw new IllegalArgumentException("The traceparent parentId shall be a 16 characters string");
        }
        final long parentId = Long.parseUnsignedLong(parts[2], 16);

        if (!isLowercaseHex(parts[3], 2)) {
            throw new IllegalArgumentException("The traceparent flags shall be a two characters string");
        }
        final byte flags = (byte)Integer.parseInt(parts[3], 16);

        return new Traceparent(version, traceIdMostSigBits, traceIdLeastSigBits, parentId, flags);
    }

    public int version() {
        return Byte.toUnsignedInt(this.version);
    }

    public String traceId() {
        return String.format("%016x%016x", this.traceIdMostSigBits, this.traceIdLeastSigBits);
    }

    public String parentId() {
        return String.format("%016x", this.parentId);
    }

    public int flags() {
        return Byte.toUnsignedInt(this.flags);
    }

    /**
     * Returns the string representation of this traceparent.
     */
    @Override
    public String toString() {
        return String.format("%02x-%s-%s-%02x", this.version, this.traceId(), this.parentId(), this.flags);
    }

    /**
     * Duplicates this instance with the given version.
     */
    public Traceparent withVersion(final String version) {
        if (!isLowercaseHex(version, 2)) {
            throw new IllegalArgumentException("The traceparent version shall be a two characters string");
        }
        return new Traceparent((byte) Integer.parseUnsignedInt(version, 16),
                               this.traceIdMostSigBits,
                               this.traceIdLeastSigBits,
                               this.parentId,
                               this.flags);
    }

    /**
     * Duplicates this instance with the given trace id.
     */
    public Traceparent withTraceId(final String traceId) {
        if (!isLowercaseHex(traceId, 32)) {
            throw new IllegalArgumentException("The traceparent traceId shall be a 32 characters string");
        }
        final long traceIdMostSigBits = Long.parseUnsignedLong(traceId.substring(0, 16), 16);
        final long traceIdLeastSigBits = Long.parseUnsignedLong(traceId.substring(16, 32), 16);
        return new Traceparent(this.version,
                               traceIdMostSigBits,
                               traceIdLeastSigBits,
                               this.parentId,
                               this.flags);
    }

    /**
     * Duplicates this instance with the given parent id.
     */
    public Traceparent withParentId(final String parentId) {
        if (!isLowercaseHex(parentId, 16)) {
            throw new IllegalArgumentException("The traceparent parentId shall be a 16 characters string");
        }
        return new Traceparent(this.version,
                               this.traceIdMostSigBits,
                               this.traceIdLeastSigBits,
                               Long.parseUnsignedLong(parentId, 16),
                               this.flags);
    }

    /**
     * Duplicates this instance with the given flags.
     */
    public Traceparent withFlags(final String flags) {
        if (!isLowercaseHex(flags, 2)) {
            throw new IllegalArgumentException("The traceparent flags shall be a two characters string");
        }
        return new Traceparent(this.version,
                               this.traceIdMostSigBits,
                               this.traceIdLeastSigBits,
                               this.parentId,
                               (byte) Integer.parseUnsignedInt(flags, 16));
    }

    /**
     * Duplicates this instance with a random parent id.
     */
    public Traceparent withRandomParentId() {
        final var random = RandomGenerator.getDefault();
        return new Traceparent(this.version,
                               this.traceIdMostSigBits,
                               this.traceIdLeastSigBits,
                               random.nextLong(),
                               this.flags);
    }

    /**
     * Checks if the given string is a lowercase hexadecimal string of the given length.
     * @param string The string to check.
     * @param length The expected length of the string.
     * @return True if the string is a lowercase hexadecimal string of the given length, false otherwise.
     */
    private static boolean isLowercaseHex(final String string, final int length) {
        if (string.length() != length) {
            return false;
        }
        return string.chars().noneMatch(c -> c < '0' || c > 'f');
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final Traceparent that)) return false;
        return version == that.version
                && traceIdMostSigBits == that.traceIdMostSigBits
                && traceIdLeastSigBits == that.traceIdLeastSigBits
                && parentId == that.parentId
                && flags == that.flags;
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, traceIdMostSigBits, traceIdLeastSigBits, parentId, flags);
    }
}
