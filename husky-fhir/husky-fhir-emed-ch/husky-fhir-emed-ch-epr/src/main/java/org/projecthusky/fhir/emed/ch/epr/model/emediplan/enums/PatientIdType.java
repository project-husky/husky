package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum PatientIdType implements EMediplanEnum<Integer> {
    INSURANCE_CARD_NUMBER(1),
    LOCAL_PID(2);

    @JsonValue
    private final Integer code;

    PatientIdType(int code) {
        this.code = code;
    }
}
