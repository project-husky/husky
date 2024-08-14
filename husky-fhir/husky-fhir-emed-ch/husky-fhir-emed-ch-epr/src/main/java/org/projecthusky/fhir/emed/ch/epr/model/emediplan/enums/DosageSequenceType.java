package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DosageSequenceType implements EMediplanEnum{
    DOSAGE(1),
    PAUSE(2);

    @JsonValue
    private final int code;

    DosageSequenceType(int code) {
        this.code = code;
    }
}
