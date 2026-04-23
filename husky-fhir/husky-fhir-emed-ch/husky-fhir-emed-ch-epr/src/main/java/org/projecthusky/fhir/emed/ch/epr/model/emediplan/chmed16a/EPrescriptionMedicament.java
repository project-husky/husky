package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.regex.Pattern;

/**
 * Extension of the {@link ChMed16AMedicament} for the revision 3 of the CHMED16A ePrescription format.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EPrescriptionMedicament extends ChMed16AMedicament {
    protected static final String INDICATION_CODE_FIELD_NAME = "IndC";

    protected static final Pattern INDICATION_CODE_PATTERN =
            Pattern.compile("^[0-9]{5}\\.[0-9]{2}$");

    /**
     * This is the FOPH assigned indication code, which becomes
     * <a href="https://www.bag.admin.ch/dam/de/sd-web/PtwrsnPGN-1j/Rundschreiben%20des%20BAG%20zur%20%C3%9Cbermittlung%20des%20Indikationscode%20vom%2019.%20Februar%202026.pdf">mandatory for prescriptions</a>.
     * <p>
     *     This has the following format {@code XXXXX.XX}. That is, 5 digits, a dot, and 2 more digits. The first five
     *     digits correspond to the FOPH dossier number for the product, while the 2 last are a sequential number per
     *     dossier's reimbursable indication.
     * </p>
     */
    @JsonProperty(INDICATION_CODE_FIELD_NAME)
    protected @Nullable String indicationCode;

    protected String getIndicationCodeFieldName() {
        return INDICATION_CODE_FIELD_NAME;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);
        if (indicationCode != null && !INDICATION_CODE_PATTERN.matcher(indicationCode).matches()) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, INDICATION_CODE_FIELD_NAME),
                "The indication code, if present, must be of the form XXXXX.XX, that is 5 digits a dot and 2 digits."
        ));
        return result;
    }

    @Override
    public void trim() {
        super.trim();
    }
}
