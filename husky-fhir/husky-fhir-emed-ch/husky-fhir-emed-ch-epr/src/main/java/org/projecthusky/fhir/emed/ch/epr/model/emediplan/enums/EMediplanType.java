package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * Called {@code MedicationType} in ChMed23A specifications.
 */
@Getter
public enum EMediplanType implements EMediplanEnum {
    MEDICATION_PLAN(1),
    @Deprecated POLYMEDICATION_CHECK(2),
    PRESCRIPTION(3);

    @JsonValue
    private final int code;

    EMediplanType(int code) {
        this.code = code;
    }
}
