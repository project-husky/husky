package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

@Getter
public enum RepetitionType implements EMediplanEnum<Integer> {
    NUMBER(1),
    DURATION(2),
    NUMBER_AND_DURATION(3);

    @JsonValue
    private final Integer code;

    RepetitionType(int code) {
        this.code = code;
    }
}
