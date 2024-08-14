package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum PosologyType implements EMediplanEnum {
    DAILY(1),
    FREE_TEXT(2),
    SINGLE(3),
    CYCLIC(4),
    SEQUENCE(5);

    @JsonValue
    private final int code;

    PosologyType(int code) {
        this.code = code;
    }
}
