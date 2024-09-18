package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.sequence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DosageSequenceType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.PosologyDetail;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class DosageSequenceElement extends SequenceElement {
    protected static final String DETAIL_FIELD_NAME = "po";

    @JsonProperty(DETAIL_FIELD_NAME)
    protected PosologyDetail detail;

    public DosageSequenceElement() {
        super(DosageSequenceType.DOSAGE);
    }

    public DosageSequenceElement(final PosologyDetail detail) {
        this();
        this.detail = detail;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != DosageSequenceType.DOSAGE) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, SEQUENCE_TYPE_FIELD_NAME),
                "The sequence element type must be PosologySequence for a sequence element with a posology detail object."
        ));

        if (detail == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DETAIL_FIELD_NAME),
                "The posology detail is missing but it is mandatory for a posology sequence element."
        ));

        return result;
    }
}
