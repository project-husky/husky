package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DaySegment;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;

/**
 * Specifies a day segment (morning, noon, evening or night) when a medication must be applied.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ApplicationInSegment extends Application {
    @JsonProperty("s")
    protected DaySegment segment;

    public ApplicationInSegment(final EMediplanDose dose, final DaySegment segment) {
        super( dose );
        this.segment = segment;
    }
}
