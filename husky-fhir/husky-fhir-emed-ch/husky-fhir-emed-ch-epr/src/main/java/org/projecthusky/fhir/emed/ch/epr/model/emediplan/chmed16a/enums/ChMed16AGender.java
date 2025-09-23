package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

@Getter
public enum ChMed16AGender implements EMediplanEnum<Integer> {
    MALE(1),
    FEMALE(2);

    @JsonValue
    private final Integer code;

    ChMed16AGender(int code) {
        this.code = code;
    }

    public static @Nullable ChMed16AGender fromEprAdministrativeGender(final AdministrativeGender administrativeGender) {
        return switch(administrativeGender) {
            case FEMALE -> FEMALE;
            case MALE -> MALE;
            case UNDIFFERENTIATED -> null;
        };
    }

    public static @Nullable ChMed16AGender fromFhirAdministrativeGender(final org.hl7.fhir.r4.model.Enumerations.AdministrativeGender administrativeGender) {
        return switch(administrativeGender) {
            case MALE -> MALE;
            case FEMALE -> FEMALE;
            case OTHER, UNKNOWN, NULL -> null;
        };
    }
}
