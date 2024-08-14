package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;

public abstract class PosologyDetail {
    @JsonProperty("t")
    protected PosologyType type;
}
