package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.sequence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DosageSequenceType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SequenceElement implements EMediplanObject {
    @JsonProperty("t")
    protected DosageSequenceType type;
    @JsonProperty("du")
    protected int duration;
    @JsonProperty("duU")
    protected TimeUnit durationUnit;

    public SequenceElement(final DosageSequenceType type) {
        this.type = type;
    }
}
