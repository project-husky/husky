package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.common.enums.AdministrativeGender;

@Getter
public enum Gender implements EMediplanEnum {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    @JsonValue
    private final int code;

    Gender(int code) {
        this.code = code;
    }

    public static Gender fromEprAdministrativeGender(final AdministrativeGender administrativeGender) {
        return switch(administrativeGender) {
            case FEMALE -> FEMALE;
            case MALE -> MALE;
            case UNDIFFERENTIATED -> OTHER;
        };
    }

    public static Gender fromFhirAdministrativeGender(final org.hl7.fhir.r4.model.Enumerations.AdministrativeGender administrativeGender) {
        return switch(administrativeGender) {
            case MALE -> MALE;
            case FEMALE -> FEMALE;
            case OTHER -> OTHER;
            case UNKNOWN -> OTHER;
            case NULL -> OTHER;
        };
    }
}
