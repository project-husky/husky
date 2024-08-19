package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DoseType;

/**
 * This is what ChMed23A calls DosageFromTo. It specifies how a dose changes during time, e.g. for infusions, starting
 * at one value and ending at a different value during the specified amount of time.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class IntervalDose extends EMediplanDose {
    /**
     * The dose start amount.
     */
    @JsonProperty("aFrom")
    protected double initialAmount;
    /**
     * The end start amount.
     */
    @JsonProperty("aTo")
    protected double finalAmount;
    /**
     * The unit of the dose duration.
     */
    @JsonProperty("duU")
    protected int durationUnit;
    /**
     * The duration (amount).
     */
    @JsonProperty("du")
    protected int duration;

    public IntervalDose() {
        super(DoseType.FROM_TO);
    }
}
