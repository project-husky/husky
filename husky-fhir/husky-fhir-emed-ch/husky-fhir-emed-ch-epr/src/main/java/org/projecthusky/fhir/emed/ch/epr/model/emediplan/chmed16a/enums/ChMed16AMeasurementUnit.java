package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

@Getter
public enum ChMed16AMeasurementUnit implements EMediplanEnum<Integer> {
    CENTIMETRE(1),
    KILOGRAM(2);

    @JsonValue
    private final Integer code;

    ChMed16AMeasurementUnit(int code) {
        this.code = code;
    }
}
