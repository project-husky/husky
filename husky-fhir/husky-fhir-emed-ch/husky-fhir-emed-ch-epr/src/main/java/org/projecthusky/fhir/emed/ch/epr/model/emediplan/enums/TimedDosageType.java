package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum TimedDosageType implements EMediplanEnum {
    DOSAGE_ONLY("1"),
    TIMES("2"),
    DAY_SEGMENTS("3"),
    WEEK_DAYS("4"),
    DAYS_OF_MONTH("5"),
    INTERVAL("6");

    @JsonValue
    private final String code;

    TimedDosageType(String code) {
        this.code = code;
    }
}
