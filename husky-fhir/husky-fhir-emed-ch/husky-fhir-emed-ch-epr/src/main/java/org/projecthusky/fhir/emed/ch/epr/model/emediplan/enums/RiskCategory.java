package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum RiskCategory implements EMediplanEnum<Integer> {
    RENAL_INSUFFICIENCY(1),
    LIVER_INSUFFICIENCY(2),
    REPRODUCTION(3),
    COMPETITIVE_ATHLETE(4),
    OPERATING_VEHICLES_OR_MACHINES(5),
    ALLERGIES(6),
    DIABETES(7);

    @JsonValue
    private final Integer code;

    RiskCategory(int code) {
        this.code = code;
    }
}
