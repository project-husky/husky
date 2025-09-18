package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.sequence.SequenceElement;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SequenceDosage extends PosologyDetail {
    protected static final String SEQUENCE_FIELD_NAME = "sos";

    /**
     * The ordered list of {@code SequenceElement} objects.
     */
    @JsonProperty(SEQUENCE_FIELD_NAME)
    protected List<@NonNull SequenceElement> sequence;

    public SequenceDosage() {
        super(PosologyType.SEQUENCE);
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != PosologyType.SEQUENCE) getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, POSOLOGY_TYPE_FIELD_NAME),
                "The posology type is sequence but the object is not."
        );

        if (sequence == null || sequence.isEmpty()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, SEQUENCE_FIELD_NAME),
                "The sequence dosage is missing the sequence list or it is empty."
        ));
        else {
            final var sequenceIterator = sequence.listIterator();
            while (sequenceIterator.hasNext()) {
                final var index = sequenceIterator.nextIndex();
                result.add(sequenceIterator.next().validate(getFieldValidationPath(basePath, SEQUENCE_FIELD_NAME, index)));
            }
        }

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return inDepth && sequence != null && sequence.stream().anyMatch(seq -> seq.hasExtensions(true));
    }

    @Override
    public void trim() {
        if (sequence != null && !sequence.isEmpty()) sequence.forEach(SequenceElement::trim);
    }
}
