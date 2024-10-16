package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Describes an unstructured dosage consisting of free text.
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class FreeTextDosage extends PosologyDetail {
    /**
     * Free text describing the dosage if it cannot be expressed in a structured manner. It should not be empty.
     */
    protected String text;

    public FreeTextDosage() {
        super(PosologyType.FREE_TEXT);
    }

    public FreeTextDosage(final String text) {
        this();
        this.text = text;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != PosologyType.FREE_TEXT) getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, POSOLOGY_TYPE_FIELD_NAME),
                "The posology type is free text but the object is not a free text posology."
        );

        if (text == null || text.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "text"),
                "The free text must not be missing or blank for a free text (unstructured) dosage."
        ));

        return result;
    }
}
