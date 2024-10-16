package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

@Getter
public enum RelativeToMeal implements EMediplanEnum<Integer> {
    BEFORE(1),
    DURING(2),
    AFTER(3),
    EMPTY_STOMACH(4),
    WITH_A_HIGH_FAT_MEAL(5),
    WITH_A_LIGHT_MEAL(6),
    WITH_A_MAIN_MEAL(7);

    @JsonValue
    private final Integer code;

    RelativeToMeal(int code) {
        this.code = code;
    }

    /**
     * Tries to convert the received FHIR coding to a RelativeToMeal enum value. This method has implemented its logic based
     * on the <a href="http://hl7.org/fhir/R4/valueset-additional-instruction-codes.html">example binding value set</a>
     * only.
     *
     * @param coding The coding to be converted.
     * @return The equivalent RelativeToMeal if it could be converted, {@code null} otherwise.
     */
    public static @Nullable RelativeToMeal fromCoding(final Coding coding) {
        if ("http://snomed.info/sct".equalsIgnoreCase(coding.getSystem()) && coding.hasCode()) {
            switch (coding.getCode()) {
                case "311501008": // half to one hour before food
                    return BEFORE;
                case "311504000": // with or after food
                    return DURING;
                case "717154004": // empty stomach
                    return EMPTY_STOMACH;
            }
        }
        return null;
    }

    /**
     * Trie to convert the received FHIR codeable concept to a RelativeToMeal enum value. See {@link #fromCoding(Coding)}
     * for information on the conversion of a single coding.
     * <p>
     * Once a matching coding is found, the method returns the converted value immediately.
     *
     * @param codeableConcept The codeable concept to be converted.
     * @return The RelativeToMeal enum value, if the codeable concept could be converted, {@code null} otherwise.
     */
    public static @Nullable RelativeToMeal fromCodeableConcept(final CodeableConcept codeableConcept) {
        for (final var coding : codeableConcept.getCoding()) {
            final var relativeToMeal = fromCoding(coding);
            if (relativeToMeal != null) return relativeToMeal;
        }
        return null;
    }
}
