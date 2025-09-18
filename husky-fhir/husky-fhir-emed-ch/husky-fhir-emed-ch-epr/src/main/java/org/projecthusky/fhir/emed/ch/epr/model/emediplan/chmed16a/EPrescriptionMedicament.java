package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition.DurationBoundRepeatable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition.Repetition;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Extension of the {@link ChMed16AMedicament} for the revision 3 of the CHMED16A ePrescription format.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EPrescriptionMedicament extends ChMed16AMedicament {
    protected static final String REPETITION_EXTENDED_FIELD_NAME = "RepExtended";

    /**
     * This field replaces the previous Rep field (Revision 2 and prior) which was a single integer field representing
     * the number of months the prescription is valid for. To increase compatibility with older systems, it is advised
     * to include the Rep field alongside the RepExtended field if RepExtended is set to either Duration or
     * NumberAndDuration and the unit (u) is set to month (6).
     * <p>
     * The repetition object indicates how often a prescription can be repeated or how long the prescription is valid.
     * </p><p>
     * If no repetition object is set, it will be interpreted as if the RepetitionObject of the type Number had been set
     * with v=1.
     * </p><p>
     * If the prescription of a medicament is not repeatable, use the RepetitionObject with the type Number and set v=0.
     * </p>
     */
    @JsonProperty(REPETITION_EXTENDED_FIELD_NAME)
    protected @Nullable Repetition repetitionObject;

    /**
     * This method sets not only sets the repetition object as the received parameter, but it will also set the
     * legacy repetition value appropriately.
     * @param repetitionObject The repetition object to be set for this medicament.
     */
    public void setRepetitionObject(@Nullable Repetition repetitionObject) {
        this.repetitionObject = repetitionObject;
        if (repetitionObject == null) repetition = null;
        else {
            if (repetitionObject instanceof DurationBoundRepeatable durationRepetition && durationRepetition.getDurationUnit() == TimeUnit.MONTH)
                repetition = durationRepetition.getDuration();
             else repetition = null;
        }
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);
        if (repetitionObject != null && repetition != null) {
            if (!(repetitionObject instanceof DurationBoundRepeatable durationRepetition && durationRepetition.getDurationUnit() == TimeUnit.MONTH))
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.INVALID,
                        basePath == null? "" : basePath,
                        "Found the legacy repetition field, while the extended repetition object does not have a duration or the duration is not in months."
                ));
        } else {
            if (repetition != null ) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    basePath == null? "" : basePath,
                    "The legacy repetition field is not null, but there is no extended repetition field. This is not allowed."
            ));
            else if (repetitionObject != null && repetitionObject instanceof DurationBoundRepeatable durationRepetition && durationRepetition.getDurationUnit() == TimeUnit.MONTH) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.WARNING,
                    OperationOutcome.IssueType.INFORMATIONAL,
                    basePath == null? "" : basePath,
                    "There is an extended repetition field with a monthly duration. In these cases, the legacy repetition field should also be filled for compatibility reasons."
            ));
        }
        return result;
    }

    @Override
    public void trim() {
        super.trim();
        if (repetitionObject != null) repetitionObject.trim();
    }
}
