package org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.RepetitionType;

/**
 * Indicates how often a prescription can be repeated or how long the prescription is valid.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Repetition {
    @JsonProperty("t")
    protected RepetitionType type;
}
