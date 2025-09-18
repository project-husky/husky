package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

@Getter
public enum DosageSequenceType implements EMediplanEnum<Integer> {
    DOSAGE(1),
    PAUSE(2);

    @JsonValue
    private final Integer code;

    DosageSequenceType(int code) {
        this.code = code;
    }
}
