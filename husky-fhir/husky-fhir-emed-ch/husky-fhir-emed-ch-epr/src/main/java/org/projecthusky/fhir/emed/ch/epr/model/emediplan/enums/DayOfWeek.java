package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DayOfWeek implements EMediplanEnum<Integer> {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    @JsonValue
    private final Integer code;

    DayOfWeek(int code) {
        this.code = code;
    }
}
