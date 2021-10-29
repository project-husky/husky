package org.ehealth_connector.emed.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.IVLTS;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.IVXBTS;
import org.ehealth_connector.emed.cda.utils.time.DateTimes;
import org.ehealth_connector.emed.cda.utils.time.Hl7Dtm;

import javax.xml.bind.JAXBElement;
import java.time.Instant;
import java.util.Objects;

/**
 * Utilities for the {@link IVLTS} resource.
 *
 * @author Quentin Ligier
 */
public class IvlTsUtils {

    /**
     * This class is not instantiable.
     */
    private IvlTsUtils() {}

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
}
