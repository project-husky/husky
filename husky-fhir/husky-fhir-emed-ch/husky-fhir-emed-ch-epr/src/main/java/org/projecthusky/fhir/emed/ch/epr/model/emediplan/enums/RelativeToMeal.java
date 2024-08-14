package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum RelativeToMeal implements EMediplanEnum {
    BEFORE(1),
    DURING(2),
    AFTER(3),
    EMPTY_STOMACH(4),
    WITH_A_HIGH_FAT_MEAL(5),
    WITH_A_LIGHT_MEAL(6),
    WITH_A_MAIN_MEAL(7);

    @JsonValue
    private final int code;

    RelativeToMeal(int code) {
        this.code = code;
    }
}
