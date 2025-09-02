package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.RepetitionType;

/**
 * Indicates how often a prescription can be repeated or how long the prescription is valid.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Repetition implements EMediplanObject {
    @JsonProperty("t")
    protected RepetitionType type;

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }
}
