package org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;

/**
 * Combination of both {@link RepetitionNumber} and {@link RepetitionDuration}.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RepetitionNumberAndDuration extends Repetition implements NumberBoundRepeatable, DurationBoundRepeatable{
    /**
     * The value defining the number of repetitions, i.e. how often a prescribed medication can be redeemed after it has
     * been redeemed once. If the prescription is not to be redeemed more than once, set to 0.
     */
    @JsonProperty("v")
    protected int value;
    /**
     * The duration of the prescription defining in which time frame the prescription can be redeemed, e.g. the
     * prescription can be redeemed an undefined number of times within for instance 6 months duration.
     */
    @JsonProperty("d")
    private int duration;
    /**
     * The unit of the duration.
     */
    @JsonProperty("u")
    private TimeUnit durationUnit;
}
