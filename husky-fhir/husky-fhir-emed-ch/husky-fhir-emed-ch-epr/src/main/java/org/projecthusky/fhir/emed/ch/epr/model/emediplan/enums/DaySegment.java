package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;

@Getter
public enum DaySegment implements EMediplanEnum<Integer> {
    MORNING(1),
    NOON(2),
    EVENING(3),
    NIGHT(4);

    @JsonValue
    private final Integer code;

    DaySegment(int code) {
        this.code = code;
    }

    public static DaySegment fromTimingEventAmbu(final TimingEventAmbu timingEvent) {
        return switch (timingEvent) {
            case MORNING -> MORNING;
            case NOON -> NOON;
            case EVENING -> EVENING;
            case NIGHT -> NIGHT;
        };
    }
}
