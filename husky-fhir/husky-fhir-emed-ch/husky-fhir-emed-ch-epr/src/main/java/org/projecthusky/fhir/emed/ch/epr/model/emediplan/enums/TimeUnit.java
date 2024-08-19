package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum TimeUnit implements EMediplanEnum {
    SECOND("1"),
    MINUTE("2"),
    HOUR("3"),
    DAY("4"),
    WEEK("5"),
    MONTH("6"),
    YEAR("7");

    @JsonValue
    private final String code;

    TimeUnit(String code) {
        this.code = code;
    }
}
