package org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepetitionNumber extends Repetition implements NumberBoundRepeatable {
    /**
     * The value defining the number of repetitions, i.e. how often a prescribed medication can be redeemed after it has
     * been redeemed once. If the prescription is not to be redeemed more than once, set to 0.
     */
    @JsonProperty("v")
    protected int value;
}
