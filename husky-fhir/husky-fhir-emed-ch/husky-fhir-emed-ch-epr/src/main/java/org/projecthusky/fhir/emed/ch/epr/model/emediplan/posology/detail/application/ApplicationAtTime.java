package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

/**
 * Specifies a precise moment in time for a medication to be applied.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApplicationAtTime extends Application {
    /**
     * Time of day when the medicament must be applied (hh:mm:ss). The time applies to the time zone of Switzerland:
     * GMT+2 (summer time) or GMT+1 (winter time).
     * The time format hh:mm is also supported (e.g. 08:00).
     */
    @JsonProperty("dt")
    @JsonFormat(pattern = "hh:mm")
    protected LocalTime dt;
}
