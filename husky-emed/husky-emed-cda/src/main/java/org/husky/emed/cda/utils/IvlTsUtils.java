package org.husky.emed.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.IVXBTS;
import org.husky.common.hl7cdar2.PQ;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;

import javax.xml.bind.JAXBElement;
import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.Optional;

/**
 * Utilities for the {@link IVLTS} resource.
 *
 * @author Quentin Ligier
 */
public class IvlTsUtils {

    /**
     * This class is not instantiable.
     */
    private IvlTsUtils() {
    }

    /**
     * Returns the lower inclusive value of the interval as an {@link Instant} if defined or {@code null}.
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return an inclusive {@link Instant} or {@code null}.
     */
    @Nullable
    public static Instant getInclusiveLowInstant(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        var low = getLowIvxbTs(ivlTs);
        if (low == null || !low.getNullFlavor().isEmpty()) {
            return null;
        }
        final Instant instant =
                DateTimes.toInstant(DateTimes.completeToEarliestInstant(Hl7Dtm.fromHl7(low.getValue())));
        if (low.isInclusive()) {
            return instant;
        } else {
            return instant.plusSeconds(1);
        }
    }

    /**
     * Returns the lower exclusive value of the interval as an {@link Instant} if defined or {@code null}.
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return an exclusive {@link Instant} or {@code null}.
     */
    @Nullable
    public static Instant getExclusiveLowInstant(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        var instant = getInclusiveLowInstant(ivlTs);
        if (instant == null) {
            return null;
        }
        return instant.plusSeconds(1);
    }

    /**
     * Returns the higher inclusive value of the interval as an {@link Instant} if defined or {@code null}.
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return an inclusive {@link Instant} or {@code null}.
     */
    @Nullable
    public static Instant getInclusiveHighInstant(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        var high = getHighIvxbTs(ivlTs);
        if (high == null || !high.getNullFlavor().isEmpty()) {
            return null;
        }
        final Instant instant =
                DateTimes.toInstant(DateTimes.completeToEarliestInstant(Hl7Dtm.fromHl7(high.getValue())));
        if (high.isInclusive()) {
            return instant;
        } else {
            return instant.minusSeconds(1);
        }
    }

    /**
     * Returns the higher exclusive value of the interval as an {@link Instant} if defined or {@code null}.
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return an exclusive {@link Instant} or {@code null}.
     */
    @Nullable
    public static Instant getExclusiveHighInstant(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        var instant = getInclusiveHighInstant(ivlTs);
        if (instant == null) {
            return null;
        }
        return instant.minusSeconds(1);
    }

    /**
     * Returns the lower value of the interval as an {@link IVXBTS} if defined or {@code null}. It can be inclusive or
     * exclusive.
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return the {@link IVXBTS} or {@code null}.
     */
    @Nullable
    public static IVXBTS getLowIvxbTs(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        return (IVXBTS) ivlTs.getRest().stream()
                .filter(rest -> "low".equals(rest.getName().getLocalPart()))
                .findAny()
                .map(JAXBElement::getValue)
                .orElse(null);
    }

    /**
     * Returns the higher value of the interval as an {@link IVXBTS} if defined or {@code null}. It can be inclusive or
     * exclusive.
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return the {@link IVXBTS} or {@code null}.
     */
    @Nullable
    public static IVXBTS getHighIvxbTs(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        return (IVXBTS) ivlTs.getRest().stream()
                .filter(rest -> "high".equals(rest.getName().getLocalPart()))
                .findAny()
                .map(JAXBElement::getValue)
                .orElse(null);
    }

    /**
     * Returns the interval width as a {@link TemporalAmount} if defined or {@code null}.
     *
     * TODO: Define the accepted temporal units.
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return the parsed {@link TemporalAmount} or {@code null}.
     */
    @Nullable
    public static TemporalAmount getWidth(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        final var width = (PQ) ivlTs.getRest().stream()
                .filter(rest -> "width".equals(rest.getName().getLocalPart()))
                .findAny()
                .map(JAXBElement::getValue)
                .orElse(null);
        if (width == null) {
            return null;
        }
        if (width.getValue() == null) {
            throw new IllegalArgumentException("The IVL_TS width has no value");
        }
        if (width.getUnit() == null) {
            throw new IllegalArgumentException("The IVL_TS width has no unit");
        }
        final long amount = Long.parseLong(width.getValue());
        return switch (width.getUnit()) {
            case "ms"  -> Duration.ofMillis(amount);
            case "s"   -> Duration.ofSeconds(amount);
            case "min" -> Duration.ofMinutes(amount);
            case "h"   -> Duration.ofHours(amount);
            case "d"   -> Period.ofDays((int) amount);
            case "wk"  -> Period.ofWeeks((int) amount);
            case "mo" -> Period.ofMonths((int) amount); // Or mo_g?
            case "a"  -> Period.ofYears((int) amount); // Or a_g?
            default -> throw new IllegalArgumentException("The IVL_TS width has an unknown unit: " + width.getUnit());
        };
    }
}
