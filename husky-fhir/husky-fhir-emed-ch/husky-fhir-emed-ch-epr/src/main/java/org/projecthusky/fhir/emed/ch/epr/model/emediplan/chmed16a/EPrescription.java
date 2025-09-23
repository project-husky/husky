package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.common.utils.datatypes.Gln;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanHealthcareProCarrier;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Model according to the specifications of
 * <a href="https://github.com/ig-emediplan/specification/blob/chmed16a-rev3/chmed16a/prescription.md">
 *     eMediplan in the context of ePrescription</a>. This extends the base {@link ChMed16AEMediplan} model.
 * <p>
 *     This class is intended for ePrescription following at least revision 2 of the CHMED16A Prescription specs. For
 *     revision 1, just use {@link ChMed16AEMediplan} instead.
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EPrescription extends ChMed16AEMediplan<EPrescriptionMedicament>
        implements EMediplanHealthcareProCarrier<ChMed16AHealthcarePerson, ChMed16AHealthcareOrganization> {
    protected static final String REVISION_FIELD_NAME = "rev";
    protected static final String HEALTHCARE_PERSON_FIELD_NAME = "HcPerson";
    protected static final String HEALTHCARE_ORGANIZATION_FIELD_NAME = "HcOrg";

    public static final int LAST_SUPPORTED_REVISION = 3;

    /**
     * The revision number of the specification. If no revision number is specified, it is assumed it uses revision 1
     * (the eMediplan base spec).
     * @since CHMED16A Prescription rev 2.
     */
    @JsonProperty(REVISION_FIELD_NAME)
    protected @Nullable Integer revision;
    /**
     * The healthcare person (the author of the document).
     * @since CHMED16A Prescription rev 2.
     */
    @JsonProperty(HEALTHCARE_PERSON_FIELD_NAME)
    protected ChMed16AHealthcarePerson healthcarePerson;

    /**
     * The healthcare organization in which the HealthcarePerson works.
     * @since CHMED16A Prescription rev 2.
     */
    @JsonProperty(HEALTHCARE_ORGANIZATION_FIELD_NAME)
    protected ChMed16AHealthcareOrganization healthcareOrganization;


    public EPrescription() {
        type = EMediplanType.PRESCRIPTION;
    }

    @Override
    public String getHealthcarePersonFieldName() {
        return HEALTHCARE_PERSON_FIELD_NAME;
    }

    @Override
    public String getHealthcareOrganizationFieldName() {
        return HEALTHCARE_ORGANIZATION_FIELD_NAME;
    }

    /**
     * In ePrescription, the author is always a professional.
     * @return {@code true}.
     */
    @Override
    public boolean isAuthorProfessional() {
        return true;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (revision != null) {
            if (revision < 1) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.VALUE,
                    "The ePrescription revision cannot be lower than 1.",
                    getFieldValidationPath(basePath, REVISION_FIELD_NAME)
            ));
            else {  if (revision == 1) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.VALUE,
                    "The ePrescription revision cannot be explicitly 1, since the revision field was added with revision 2. Also: for rev 1 use the base CHMED16A eMediplan object.",
                    getFieldValidationPath(basePath, REVISION_FIELD_NAME)
                ));
                else if (revision > LAST_SUPPORTED_REVISION) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.VALUE,
                    String.format("This revision of the eMediplan is not supported. Last supported: %d. Found: %d.", LAST_SUPPORTED_REVISION, revision),
                    getFieldValidationPath(basePath, REVISION_FIELD_NAME)
                ));
            }
        } else result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, REVISION_FIELD_NAME),
                "The revision field is mandatory, since the default value (1) is not supported by this class. Use the base CHMED16A eMediplan object instead."
        ));

        if (type != EMediplanType.PRESCRIPTION) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                "An ePrescription must be an eMediplan of type PRESCRIPTION.",
                getFieldValidationPath(basePath, EMEDIPLAN_TYPE_FIELD_NAME)
        ));

        result.add(validateHealtcareProInfo(basePath));
        if (author != null && healthcarePerson != null && Gln.match(author) && !author.equals(healthcarePerson.getGln()))
            result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    basePath == null? "" : basePath,
                    "If the author contains a GLN, it must match the GLN of the healthcare person object."
            ));

        return result;
    }

    @Override
    public void trim() {
        super.trim();
        if (revision != null && revision == 1) revision = null;
        if (healthcarePerson != null) healthcarePerson.trim();
        if (healthcareOrganization != null) healthcareOrganization.trim();
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return super.hasExtensions(inDepth)
                || (inDepth && healthcarePerson != null && healthcarePerson.hasExtensions(true))
                || (inDepth && healthcareOrganization != null && healthcareOrganization.hasExtensions(true));
    }
}
