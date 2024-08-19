package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DoseType;

/**
 * A dose specifying a minimum and a maximum amount of medication.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RangeDose extends EMediplanDose {
    /**
     * The minimum amount of medication that must be applied.
     */
    @JsonProperty("aMin")
    protected double minimumAmount;
    /**
     * Te maximum amount of medication that must be applied.
     */
    @JsonProperty("aMax")
    protected double maximumAmount;

    public RangeDose() {
        super(DoseType.RANGE);
    }

    public RangeDose(double minimumAmount, double maximumAmount) {
        this();
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
    }
}
