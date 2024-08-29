package org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepetitionDuration extends Repetition implements DurationBoundRepeatable {
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
