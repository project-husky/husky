package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application.ApplicationInSegment;

import java.util.ArrayList;
import java.util.List;

/**
 * Specifies the day segment (morning, noon, evening, night) when a medication should be applied. This is called
 * DaySegments by ChMed23A.
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class DaySegmentsDosage extends EmbeddableTimedDosage {
    /**
     * Specifies the dosage to be applied per day segment.
     */
    @JsonProperty("ss")
    protected List<@NonNull ApplicationInSegment> applications;

    public DaySegmentsDosage() {
        super(TimedDosageType.DAY_SEGMENTS);
        getApplications();
    }

    public List<@NonNull ApplicationInSegment> getApplications() {
        if (applications == null) applications = new ArrayList<>();
        return applications;
    }

    public void addApplication(final ApplicationInSegment application) {
        getApplications().add(application);
    }
}
