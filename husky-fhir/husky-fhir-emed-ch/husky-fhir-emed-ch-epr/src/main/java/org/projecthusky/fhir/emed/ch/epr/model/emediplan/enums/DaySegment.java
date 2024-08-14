package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DaySegment implements EMediplanEnum {
    MORNING(1),
    NOON(2),
    EVENING(3),
    NIGHT(4);

    @JsonValue
    private final int code;

    DaySegment(int code) {
        this.code = code;
    }
}
