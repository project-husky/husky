package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.common.utils.datatypes.Gln;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplan;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanHealthcareProCarrier;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.EMediplanAuthor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the main eMediplan object, called {@code Medication} in ChMed23A specification. It contains exactly one
 * patient and a list of medications (named medicament in ChMed23A).
 * <p>
 * Based on the CHMed23A specs doc version 2.1 and the CHMed23A posology specs doc version 2.1.
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed23AEMediplan extends EMediplan<ChMed23AExtension, ChMed23AMedicament>
        implements ChMed23AExtendable, EMediplanHealthcareProCarrier<ChMed23AHealthcarePerson, ChMed23AHealthcareOrganization> {
    public static final String EMEDIPLAN_VERSION = "CHMED23A";

    protected static final String HEALTHCARE_PERSON_FIELD_NAME = "hcPerson";
    protected static final String HEALTHCARE_ORGANIZATION_FIELD_NAME = "hcOrg";

    /**
     * The patient.
     */
    protected ChMed23APatient patient;
    /**
     * The healthcare person author of the document, required if the document author type is an HCP.
     */
    @JsonProperty(HEALTHCARE_PERSON_FIELD_NAME)
    protected @Nullable ChMed23AHealthcarePerson healthcarePerson;
    /**
     * The healthcare organization in which the HealthcarePerson works. Required if the document author type is an HCP.
     */
    @JsonProperty(HEALTHCARE_ORGANIZATION_FIELD_NAME)
    protected @Nullable ChMed23AHealthcareOrganization healthcareOrganization;
    /**
     * List of medications.
     */
    @JsonProperty("meds")
    protected List<@NonNull ChMed23AMedicament> medicaments;
    /**
     * The list of extensions. Optional if empty.
     */
    @JsonProperty("exts")
    protected @Nullable List<@NonNull ChMed23AExtension> extensions;
    /**
     * The type of Medication object, see {@link EMediplanType}. It is allowed to be missing if the author is a person,
     * in which case it is assumed that it is a {@link EMediplanType#MEDICATION_PLAN}.
     */
    @JsonProperty("medType")
    protected @Nullable EMediplanType type;
    /**
     * The id of the Medication object. The eMediplan document creator is responsible for assigning the id.
     */
    protected @Nullable String id;
    /**
     * The type of author of the document.
     */
    @JsonProperty("auth")
    protected EMediplanAuthor author;
    /**
     * The recipient (GLN) of the electronic prescription. To be used if the electronic prescription is to be
     * transmitted electronically to a healthcare professional.
     */
    @JsonProperty("rec")
    protected @Nullable String recipient;
    /**
     * The date of creation. Format: yyyy-mm-ddThh:mm:ss+02:00 (ISO 86012 Combined date and time in UTC)
     * (e.g. 2016-06-16T16:26:15+02:00)
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = EMEDIPLAN_TIMEZONE)
    @JsonProperty("dt")
    protected Instant timestamp;
    /**
     * Remark. Any information or advice the author would like to share independently of a specific medicament.
     */
    @JsonProperty("mk")
    protected @Nullable String remark;

    @Override
    public String getHealthcarePersonFieldName() {
        return HEALTHCARE_PERSON_FIELD_NAME;
    }

    @Override
    public String getHealthcareOrganizationFieldName() {
        return HEALTHCARE_ORGANIZATION_FIELD_NAME;
    }

    @Override
    public List<@NonNull ChMed23AMedicament> getMedicaments() {
        if (medicaments == null) medicaments = new ArrayList<>();
        return medicaments;
    }

    @Override
    public List<@NonNull ChMed23AExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    @Override
    @ExpectsValidResource
    public EMediplanType resolveType() {
        if (type == null) {
            if (author == null) throw new InvalidEmedContentException("The medication object author cannot be missing or empty.");
            if (author == EMediplanAuthor.HEALTHCARE_PERSON)
                throw new InvalidEmedContentException("The medication object type cannot be missing if the author is a healthcare person.");
            return EMediplanType.MEDICATION_PLAN;
        } else return type;
    }

    @Override
    public boolean isAuthorProfessional() {
        return author == EMediplanAuthor.HEALTHCARE_PERSON;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (author == null)
            result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, "auth"),
                    "The author type is missing but it is mandatory."
            ));
        else {
            final var resolvedType = resolveType();

            result.add(validateHealtcareProInfo(basePath));

            if (resolvedType == EMediplanType.MEDICATION_PLAN && author == EMediplanAuthor.HEALTHCARE_PERSON && (healthcarePerson == null || healthcarePerson.getGln() == null || healthcarePerson.getGln().isBlank()) && (healthcareOrganization == null || healthcareOrganization.getGln() == null || healthcareOrganization.getGln().isBlank()))
                result.add(getRequiredFieldValidationIssue(
                        basePath,
                        "The GLN of either the healthcare professional or the healthcare organization is mandatory for eMediplan treatment plan documents done by a healthcare professional."
                ));

            if (medicaments == null || medicaments.isEmpty()) {
                if (resolvedType == EMediplanType.PRESCRIPTION)
                    result.add(getRequiredFieldValidationIssue(
                            getFieldValidationPath(basePath, "meds"),
                            "The list of medicaments is missing or empty, but it is required to have at least one element when the Medication type is a Prescription."
                    ));
            } else {
                final var medsIterator = medicaments.listIterator();
                while (medsIterator.hasNext()) {
                    final var index = medsIterator.nextIndex();
                    result.add(medsIterator.next().validate(getFieldValidationPath(basePath, "meds", index), resolvedType));
                }
            }

            if (resolvedType == EMediplanType.POLYMEDICATION_CHECK)
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.CODEINVALID,
                        getFieldValidationPath(basePath, "medType"),
                        "The PolymedicationCheck (PMC) medication type is deprecated and should not be used."
                ));

            if (author == EMediplanAuthor.PATIENT && resolvedType == EMediplanType.PRESCRIPTION)
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.CODEINVALID,
                        getFieldValidationPath(basePath, "medType"),
                        "If the author is a patient, the medication type cannot be a prescription."
                ));

            if (recipient != null) {
                if (!Gln.match(recipient))
                    result.add(getValidationIssue(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.VALUE,
                            getFieldValidationPath(basePath, "rec"),
                            "The medication recipient content is not a valid GLN."
                    ));
                if (resolvedType == EMediplanType.MEDICATION_PLAN)
                    result.add(getIgnoredFieldValidationIssue(
                            getFieldValidationPath(basePath, "rec"),
                            "The recipient object is present, but the medication type is not a prescription."
                    ));
            }

            if (patient == null)
                result.add(getRequiredFieldValidationIssue(
                        getFieldValidationPath(basePath, "patient"),
                        "The patient object is missing, but it is required."
                ));
            else  result.add(patient.validate(basePath + ".patient", resolvedType, timestamp));
        }
        if (timestamp == null)
            result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, "dt"),
                    "The date of creation field is missing but it is mandatory"
            ));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (extensions != null && !extensions.isEmpty()) || (inDepth && (
                (patient != null && patient.hasExtensions(true)) ||
                (healthcarePerson != null && healthcarePerson.hasExtensions(true)) ||
                (healthcareOrganization != null && healthcareOrganization.hasExtensions(true)) ||
                (medicaments != null && medicaments.stream().anyMatch(med -> med.hasExtensions(true)))
                ));
    }

    @Override
    public void trim() {
        super.trim();

        if (healthcarePerson != null) healthcarePerson.trim();
        if (healthcareOrganization != null) healthcareOrganization.trim();

        if (type != null && type == EMediplanType.MEDICATION_PLAN && author != null && author == EMediplanAuthor.PATIENT)
            type = null;
    }

    @Override
    public String getEmediplanVersion() {
        return EMEDIPLAN_VERSION;
    }

    @Override
    public String getChTransmissionFormatPrefix() {
        return getEmediplanVersion() + ".";
    }
}
