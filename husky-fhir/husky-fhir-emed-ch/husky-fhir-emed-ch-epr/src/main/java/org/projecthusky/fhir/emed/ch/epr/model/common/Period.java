/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Instant;

/**
 * A time period, where the start or end time may be null.
 *
 * @author Quentin Ligier
 */
public record Period(@Nullable Instant startInclusive,
                     @Nullable Instant endInclusive) {

    /**
     * Constructor.
     *
     * @param startInclusive The inclusive lower bound or {@code null}.
     * @param endInclusive   The inclusive higher bound or {@code null}.
     */
    public Period(@Nullable final Instant startInclusive, @Nullable final Instant endInclusive) {
        if (startInclusive == null && endInclusive == null) {
            throw new IllegalArgumentException("Period: Either the start or end instants shall be specified");
        }
        if (startInclusive != null && endInclusive != null && startInclusive.isAfter(endInclusive)) {
            throw new IllegalArgumentException("Period: The time interval lower bound is after the higher bound");
        }
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }
}
