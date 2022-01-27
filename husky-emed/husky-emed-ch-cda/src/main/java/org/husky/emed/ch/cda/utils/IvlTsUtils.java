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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.PQ;
import org.husky.common.hl7cdar2.TS;
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
        var low = getLowTs(ivlTs);
        if (low == null || !low.getNullFlavor().isEmpty()) {
            return null;
        }
        return DateTimes.toInstant(DateTimes.completeToEarliestInstant(Hl7Dtm.fromHl7(low.getValue())));
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
        return Optional.ofNullable(getInclusiveLowInstant(ivlTs))
                .map(instant -> instant.plusSeconds(1))
                .orElse(null);
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
        var high = getHighTs(ivlTs);
        if (high == null || !high.getNullFlavor().isEmpty()) {
            return null;
        }
        return DateTimes.toInstant(DateTimes.completeToEarliestInstant(Hl7Dtm.fromHl7(high.getValue())));
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
        return Optional.ofNullable(getInclusiveHighInstant(ivlTs))
                .map(instant -> instant.minusSeconds(1))
                .orElse(null);
    }

    /**
     * Returns the lower value of the interval as an {@link TS} if defined or {@code null}. It is inclusive (closed
     * bound).
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return the {@link TS} or {@code null}.
     */
    @Nullable
    public static TS getLowTs(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        return (TS) ivlTs.getRest().stream()
                .filter(rest -> "low".equals(rest.getName().getLocalPart()))
                .findAny()
                .map(JAXBElement::getValue)
                .orElse(null);
    }

    /**
     * Returns the higher value of the interval as an {@link TS} if defined or {@code null}. It is inclusive (closed
     * bound).
     *
     * @param ivlTs The non-null IVL_TS to parse.
     * @return the {@link TS} or {@code null}.
     */
    @Nullable
    public static TS getHighTs(final IVLTS ivlTs) {
        Objects.requireNonNull(ivlTs);
        return (TS) ivlTs.getRest().stream()
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
