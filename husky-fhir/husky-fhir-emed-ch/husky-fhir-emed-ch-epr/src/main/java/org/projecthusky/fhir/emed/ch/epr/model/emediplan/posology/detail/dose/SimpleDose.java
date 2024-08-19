package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DoseType;

@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleDose extends EMediplanDose {
    /**
     * The amount to be applied.
     */
    @JsonProperty("a")
    protected Double amount;

    public SimpleDose() {
        super(DoseType.SIMPLE);
    }

    public SimpleDose(Double amount) {
        this();
        this.amount = amount;
    }
}
