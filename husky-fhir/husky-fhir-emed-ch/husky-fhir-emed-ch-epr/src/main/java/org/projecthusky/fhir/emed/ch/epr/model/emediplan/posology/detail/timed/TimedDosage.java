package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;

/**
 * Specifies the moment and amount of a medication application. All TimedDosage objects must specify an amount to be
 * applied. It is not mandatory to specify the moment of application, but it is possibly to set them either precisely
 * or vaguely.
 */
public abstract class TimedDosage {
    @JsonProperty("t")
    protected TimedDosageType type;
}
