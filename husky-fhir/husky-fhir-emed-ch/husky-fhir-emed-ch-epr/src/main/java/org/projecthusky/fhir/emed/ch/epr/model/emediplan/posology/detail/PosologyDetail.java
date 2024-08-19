package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PosologyDetail {
    @JsonProperty("t")
    protected PosologyType type;
}
