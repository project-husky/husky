package org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition;

import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;

public interface DurationBoundRepeatable {
    int getDuration();
    TimeUnit getDurationUnit();
}
