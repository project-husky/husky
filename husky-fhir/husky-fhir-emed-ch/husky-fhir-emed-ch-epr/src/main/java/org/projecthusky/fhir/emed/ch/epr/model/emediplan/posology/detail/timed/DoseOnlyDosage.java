package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;

/**
 * Specifies a dosage without specifying a precise moment for the intake.
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class DoseOnlyDosage extends EmbeddableTimedDosage {
    /**
     * Specifies the dose to be applied.
     */
    @JsonProperty("do")
    protected EMediplanDose dose;

    public DoseOnlyDosage () {
        super(TimedDosageType.DOSAGE_ONLY);
    }

    public DoseOnlyDosage(final EMediplanDose dose) {
        super(TimedDosageType.DOSAGE_ONLY);
        this.dose = dose;
    }
}
