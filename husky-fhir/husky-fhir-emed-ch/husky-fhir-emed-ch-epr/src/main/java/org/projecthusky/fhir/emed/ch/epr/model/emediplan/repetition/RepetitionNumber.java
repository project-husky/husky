package org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.RepetitionType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepetitionNumber extends Repetition implements NumberBoundRepeatable {
    protected static final String VALUE_FIELD_NAME = "v";

    public RepetitionNumber() {
        super(RepetitionType.NUMBER);
    }

    public RepetitionNumber(final int value) {
        this();
        this.value = value;
    }

    /**
     * The value defining the number of repetitions, i.e. how often a prescribed medication can be redeemed after it has
     * been redeemed once. If the prescription is not to be redeemed more than once, set to 0.
     */
    @JsonProperty(VALUE_FIELD_NAME)
    protected int value;

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        return NumberBoundRepeatable.super.validate(getFieldValidationPath(basePath, VALUE_FIELD_NAME));
    }
}
