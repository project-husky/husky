package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.fhir.emed.ch.epr.enums.ChEmedEprTimeUnit;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

@Getter
public enum TimeUnit implements EMediplanEnum<Integer> {
    SECOND(1),
    MINUTE(2),
    HOUR(3),
    DAY(4),
    WEEK(5),
    MONTH(6),
    YEAR(7);

    @JsonValue
    private final Integer code;

    TimeUnit(int code) {
        this.code = code;
    }

    public static TimeUnit fromChEmedEprTimeUnit(final ChEmedEprTimeUnit chEmedEprTimeUnit) {
        return switch(chEmedEprTimeUnit) {
            case A -> YEAR;
            case SEC -> SECOND;
            case MIN -> MINUTE;
            case H -> HOUR;
            case D -> DAY;
            case MO -> MONTH;
        };
    }
}
