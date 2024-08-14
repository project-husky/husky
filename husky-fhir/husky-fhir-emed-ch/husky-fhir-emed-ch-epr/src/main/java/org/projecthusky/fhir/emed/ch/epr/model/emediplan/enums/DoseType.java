package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DoseType implements EMediplanEnum {
    SIMPLE(1),
    FROM_TO(2),
    RANGE(3);

    @JsonValue
    private final int code;

    DoseType(int code) {
        this.code = code;
    }
}
