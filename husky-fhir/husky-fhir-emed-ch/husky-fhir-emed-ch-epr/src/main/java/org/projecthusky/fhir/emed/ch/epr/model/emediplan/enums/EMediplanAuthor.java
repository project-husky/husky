package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * Called {@code MedicationAuthor} in ChMed23A specifications.
 */
@Getter
public enum EMediplanAuthor implements EMediplanEnum<Integer> {
    HEALTHCARE_PERSON(1),
    PATIENT(2);

    @JsonValue
    private final Integer code;

    EMediplanAuthor(int code) {
        this.code = code;
    }
}
