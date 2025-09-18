package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

@Getter
public enum ChMed23AGender implements EMediplanEnum<Integer> {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    @JsonValue
    private final Integer code;

    ChMed23AGender(int code) {
        this.code = code;
    }

    public static ChMed23AGender fromEprAdministrativeGender(final AdministrativeGender administrativeGender) {
        return switch(administrativeGender) {
            case FEMALE -> FEMALE;
            case MALE -> MALE;
            case UNDIFFERENTIATED -> OTHER;
        };
    }

    public static ChMed23AGender fromFhirAdministrativeGender(final org.hl7.fhir.r4.model.Enumerations.AdministrativeGender administrativeGender) {
        return switch(administrativeGender) {
            case MALE -> MALE;
            case FEMALE -> FEMALE;
            case OTHER -> OTHER;
            case UNKNOWN -> OTHER;
            case NULL -> OTHER;
        };
    }
}
