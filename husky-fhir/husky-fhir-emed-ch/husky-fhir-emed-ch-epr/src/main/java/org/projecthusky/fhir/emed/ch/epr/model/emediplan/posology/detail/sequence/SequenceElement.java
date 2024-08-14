package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.sequence;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DosageSequenceType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;

public abstract class SequenceElement {
    @JsonProperty("t")
    protected DosageSequenceType type;
    @JsonProperty("du")
    protected int duration;
    @JsonProperty("duU")
    protected TimeUnit durationUnit;
}
