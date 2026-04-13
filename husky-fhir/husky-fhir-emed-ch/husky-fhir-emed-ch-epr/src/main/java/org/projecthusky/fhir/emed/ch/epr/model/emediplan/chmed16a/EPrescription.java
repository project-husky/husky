package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.common.utils.datatypes.Gln;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplan;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanHealthcareProCarrier;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.io.IOException;
import java.util.Base64;

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

    protected static final int POSTAL_CODE_REV3_MAX_LENGTH = 10;
    protected static final int ZSR_REV3_MAX_LENGTH = 7;

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
                    getFieldValidationPath(basePath, REVISION_FIELD_NAME),
                    "The ePrescription revision cannot be lower than 1."
            ));
            else {
                if (revision == 1) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.VALUE,
                    getFieldValidationPath(basePath, REVISION_FIELD_NAME),
                    "The ePrescription revision cannot be explicitly 1, since the revision field was added with revision 2. Also: for rev 1 use the base CHMED16A eMediplan object."
                ));
                else {
                    if (revision == 3) validateRev3Constraints(basePath, result);
                    else if (revision > LAST_SUPPORTED_REVISION) result.add(getValidationIssue(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.VALUE,
                            getFieldValidationPath(basePath, REVISION_FIELD_NAME),
                            String.format("This revision of the eMediplan is not supported. Last supported: %d. Found: %d.", LAST_SUPPORTED_REVISION, revision)
                    ));
                }
            }
        } else result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, REVISION_FIELD_NAME),
                "The revision field is mandatory, since the default value (1) is not supported by this class. Use the base CHMED16A eMediplan object instead."
        ));

        if (type != EMediplanType.PRESCRIPTION) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, EMEDIPLAN_TYPE_FIELD_NAME),
                "An ePrescription must be an eMediplan of type PRESCRIPTION."
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

    /**
     * This method validates specific constraints added with rev3 of the eMediplan ePrescription exchange format.
     * <p>
     *     While a different approach of delegating new constraints to the objects themselves would have seemed cleaner,
     *     it would have required a refactoring for only a few simple extra checks. For the moment being, the approach
     *     of adding a new method per revision to add the newly added checks has been adopted. This decision might
     *     be reconsidered at a later stage.
     * </p>
     * @param basePath
     * @param result
     */
    protected void validateRev3Constraints(final @Nullable String basePath, final ValidationResult result) {
        if (patient != null && patient.getAddress() != null && patient.getAddress().getPostalCode() != null && patient.getAddress().getPostalCode().length() > POSTAL_CODE_REV3_MAX_LENGTH)
            result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.VALUE,
                    patient.getAddress().getFieldValidationPath(getFieldValidationPath(basePath, PATIENT_FIELD_NAME), patient.getAddress().getPostalCodeFieldName()),
                    "The patient's postal code cannot be longer than 10 characters in CHMED16A prescription rev 3."
            ));
        if (id != null && !Uuids.match(id)) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, ID_FIELD_NAME),
                "The CHMED16A prescription id must be an UUID since rev 3."
        ));
        if (zsr != null && zsr.length() > ZSR_REV3_MAX_LENGTH) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, ZSR_FIELD_NAME),
                "The CHMED16A prescription ZSR field must not be longer than 7 characters since rev 3."
        ));

        if (medicaments != null) {
            final var medicamentsIterator = medicaments.listIterator();
            while (medicamentsIterator.hasNext()) {
                final var index =  medicamentsIterator.nextIndex();
                final var medicament = medicamentsIterator.next();
                if (medicament.getRepetition() != null && medicament.getRepetition() > 99)
                    result.add(getValidationIssue(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.VALUE,
                            medicament.getFieldValidationPath(getFieldValidationPath(basePath, MEDICAMENTS_FIELD_NAME, index), medicament.getRepetitionFieldName()),
                            "The CHMED16A prescription medicament repetition cannot be greater than 99 since revision 3."
                    ));
                // since rev3, the number of packages must be an integer
                if (medicament.getNumberOfPackages() != null) {
                    if (medicament.getNumberOfPackages() > Integer.MAX_VALUE) result.add(getValidationIssue(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.VALUE,
                            medicament.getFieldValidationPath(getFieldValidationPath(basePath, MEDICAMENTS_FIELD_NAME, index), medicament.getNumberOfPackagesFieldName()),
                            "The CHMED16A prescription medicament must be an int since revision 3, but this number is too big."
                    ));
                    else if ((medicament.getNumberOfPackages() % 1) != 0) result.add(getValidationIssue(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.VALUE,
                            medicament.getFieldValidationPath(getFieldValidationPath(basePath, MEDICAMENTS_FIELD_NAME, index), medicament.getNumberOfPackagesFieldName()),
                            "The CHMED16A prescription medicament must be an integer since revision 3, but it seems to be a decimal value."
                    ));
                }
                if (medicament.getIndicationCode() != null && (revision == null || revision < 3))
                    result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.WARNING,
                        OperationOutcome.IssueType.VALUE,
                        medicament.getFieldValidationPath(getFieldValidationPath(basePath, MEDICAMENTS_FIELD_NAME, index), medicament.getIndicationCodeFieldName()),
                        "The CHMED16A prescription medicament has an indication code, but the ePrescription revision is not specified or is lower than 3, when this field has been introduced."
                ));
            }
        }

        if (healthcarePerson != null) {
            if (healthcarePerson.getGln() != null && healthcarePerson.getGln().length() > 13)
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.VALUE,
                        healthcarePerson.getFieldValidationPath(getFieldValidationPath(basePath, HEALTHCARE_PERSON_FIELD_NAME), healthcarePerson.getGlnFieldName()),
                        "The healthcare person GLN cannot be longer than 13 characters (since revision 3)."
                ));
            if (healthcarePerson.getZsr() != null && healthcarePerson.getZsr().length() > ZSR_REV3_MAX_LENGTH)
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.VALUE,
                        healthcarePerson.getFieldValidationPath(getFieldValidationPath(basePath, HEALTHCARE_PERSON_FIELD_NAME), healthcarePerson.getZsrFieldName()),
                        "The CHMED16A prescription healthcare person ZSR field must not be longer than 7 characters since rev 3."
                ));
        }

        if (healthcareOrganization != null) {
            if (healthcareOrganization.getAddress() != null && healthcareOrganization.getAddress().getPostalCode() != null && healthcareOrganization.getAddress().getPostalCode().length() > POSTAL_CODE_REV3_MAX_LENGTH)
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.VALUE,
                        healthcareOrganization.getAddress().getFieldValidationPath(getFieldValidationPath(basePath, HEALTHCARE_ORGANIZATION_FIELD_NAME), healthcareOrganization.getAddress().getPostalCodeFieldName()),
                        "The healthcare organization postal code cannot be longer than 10 characters in CHMED16A prescription rev 3."
                ));
            if (healthcareOrganization.getZsr() != null && healthcareOrganization.getZsr().length() > ZSR_REV3_MAX_LENGTH)
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.VALUE,
                        healthcareOrganization.getFieldValidationPath(getFieldValidationPath(basePath, HEALTHCARE_ORGANIZATION_FIELD_NAME), healthcareOrganization.getZsrFieldName()),
                        "The CHMED16A prescription healthcare organization ZSR field must not be longer than 7 characters since rev 3."
                ));
        }
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

    /**
     * Parses an ePrescription from a ChTransmissionFormat String, as specified by eMediplan.
     *
     * @param chTransmission The transmission content, e.g.
     *                       {@code CHMED16A1H4sIAAAAAAAAAzWPMU/DMBCFZ/IrolvB0p3b+O6yUSEEEkUM3RCDW7uiQyNE3AFV+e84diN5ed/ze093bdoWPnw6xSFB316zzOD53Z9jlvDihxEeKnxb4PYypvi74M3THARSZkOUH9xlY5pd2MZwOuTUkMb857ME6kQ2X8OcYyfYEWuHa3S3zmLu/n7mNVvI1HwthTe+Krp2+OACd7I3qvFoSOloNAgZF0UcH7yGzpdqeLyk77qKhIjMwqLVqmdYtCuDzljZEfUo/Vrv0faI0Ez/cZpKMywBAAA=}
     * @return The parsed EPrescription object.
     * @throws IOException If there was an I/O parsing error.
     * @throws InvalidEmedContentException if there were content errors that prevented parsing.
     */
    @ExpectsValidResource
    public static EPrescription fromChTransmissionFormat(final String chTransmission) throws IOException {
        if (chTransmission == null || chTransmission.isBlank())
            throw new InvalidEmedContentException("The chTransmission content cannot be null or empty");
        final var prefix = new EPrescription().getChTransmissionFormatPrefix();
        if (chTransmission.startsWith(prefix)) {
            final var compressedData = Base64.getDecoder().decode(chTransmission.substring(prefix.length()));
            final var uncompressedData = EMediplan.uncompressJson(compressedData);
            final var objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.readValue(uncompressedData, EPrescription.class);
        } else throw new InvalidEmedContentException("The ePrescription transmission content does not start with the appropriate prefix.");
    }
}
