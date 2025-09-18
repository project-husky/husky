package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * Called {@code MedicationType} in ChMed specifications.
 */
@Getter
public enum EMediplanType implements EMediplanEnum<Integer> {
    MEDICATION_PLAN(1),
    @Deprecated POLYMEDICATION_CHECK(2),
    PRESCRIPTION(3);

    @JsonValue
    private final Integer code;

    EMediplanType(int code) {
        this.code = code;
    }
}
