package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

@Getter
public enum PosologyType implements EMediplanEnum<Integer> {
    DAILY(1),
    FREE_TEXT(2),
    SINGLE(3),
    CYCLIC(4),
    SEQUENCE(5);

    @JsonValue
    private final Integer code;

    PosologyType(int code) {
        this.code = code;
    }
}
