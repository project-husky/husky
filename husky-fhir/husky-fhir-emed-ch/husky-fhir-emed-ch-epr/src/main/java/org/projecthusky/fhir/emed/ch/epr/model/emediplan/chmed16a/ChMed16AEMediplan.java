package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.common.utils.datatypes.Gln;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplan;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the main eMediplan object, called {@code Medication} in CHMED16A specification. It contains exactly one
 * patient and a list of medications (named medicament in CHMED16A).
 * <p>
 * Based on the CHMED16A specs doc as published on its
 * <a href="https://github.com/ig-emediplan/specification/tree/main/chmed16a">GitHub site</a> as of 2025-06-25.
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed16AEMediplan extends EMediplan<ChMed16AExtension, ChMed16AMedicament> implements ChMed16AExtendable {
    public static final String EMEDIPLAN_VERSION = "CHMED16A";

    protected static final String PATIENT_FIELD_NAME = "Patient";
    protected static final String MEDICAMENTS_FIELD_NAME = "Medicaments";
    protected static final String RECOMMENDATIONS_FIELD_NAME = "Recoms";
    protected static final String EMEDIPLAN_TYPE_FIELD_NAME = "MedType";
    protected static final String ID_FIELD_NAME = "Id";
    protected static final String AUTHOR_FIELD_NAME = "Auth";
    protected static final String ZSR_FIELD_NAME = "Zsr";
    protected static final String TIMESTAMP_FIELD_NAME = "Dt";
    protected static final String REMARKS_FIELD_NAME = "Rmk";
    protected static final String VALIDATOR_FIELD_NAME = "ValBy";
    protected static final String VALIDATION_TIMESTAMP_FIELD_NAME = "ValDt";
    protected static final String EXTENSIONS_SCHEMA_FIELD_NAME = "PSchema";

    /**
     * The patient.
     */
    @JsonProperty(PATIENT_FIELD_NAME)
    protected ChMed16APatient patient;
    /**
     * The list of medicaments.
     */
    @JsonProperty(MEDICAMENTS_FIELD_NAME)
    protected List<@NonNull ChMed16AMedicament> medicaments;
    /**
     * The list of recommendations.
     */
    @JsonProperty(RECOMMENDATIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed16ARecommendation> recommendations;
    /**
     * The type of the Medication object.
     */
    @JsonProperty(EMEDIPLAN_TYPE_FIELD_NAME)
    protected EMediplanType type;
    /**
     * The ID of the eMediplan object.
     */
    @JsonProperty(ID_FIELD_NAME)
    protected String id;
    /**
     * Author (GLN2 if available, otherwise name).
     * <p>
     * eMediplan: GLN of a person or organisation
     * </p><p>
     * ePrescription: GLN of a person
     * </p><p>
     * The patient can also be the author of the eMediplan. In this case, the minimum requirement is that the term
     * "patient" is used to designate the author. Optionally, the patient's first name, last name and date of birth can
     * also be specified additionally.
     * </p>
     */
    @JsonProperty(AUTHOR_FIELD_NAME)
    protected String author;
    /**
     * ZSR (Zahlstellenregister) number of the author or their organisation.
     */
    @JsonProperty(ZSR_FIELD_NAME)
    protected @Nullable String zsr;
    /**
     * The date of creation. Format: yyyy-mm-ddThh:mm:ss+02:00 (ISO 86012 Combined date and time in UTC)
     * (e.g. 2016-06-16T16:26:15+02:00)
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = EMEDIPLAN_TIMEZONE)
    @JsonProperty(TIMESTAMP_FIELD_NAME)
    protected Instant timestamp;
    /**
     * Remark (any information/advice the author would like to share independently of a specific medicament).
     */
    @JsonProperty(REMARKS_FIELD_NAME)
    protected @Nullable String remark;
    /**
     * Validate by: the GLN of the healthcare professional who has validated the medication plan.
     */
    @JsonProperty(VALIDATOR_FIELD_NAME)
    protected @Nullable String validator;
    /**
     * Validate date: Date of validation, Format: YYYY-MM-DDThh:mm:ss±hh:mm (ISO 8601 Date and time with the offset)
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = EMEDIPLAN_TIMEZONE)
    @JsonProperty(VALIDATION_TIMESTAMP_FIELD_NAME)
    protected @Nullable Instant validationTimestamp;
    /**
     * The schema of the private fields. When empty or not specified, all private fields must be ignored.
     */
    @JsonProperty(EXTENSIONS_SCHEMA_FIELD_NAME)
    protected @Nullable String extensionsSchema;
    /**
     * The list of private fields.
     */
    @JsonProperty(ChMed16AExtension.EXTENSIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed16AExtension> extensions;

    @Override
    public List<@NonNull ChMed16AExtension> getExtensions() {
        if ( extensions == null ) extensions = new ArrayList<>();
        return extensions;
    }

    @Override
    public List<@NonNull ChMed16AMedicament> getMedicaments() {
        if (medicaments == null) medicaments = new ArrayList<>();
        return medicaments;
    }

    @Override
    public EMediplanType resolveType() {
        return getType();
    }

    @Override
    public ValidationResult validate(@Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type == null) {
            result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, EMEDIPLAN_TYPE_FIELD_NAME),
                    "The eMediplan object type is required, but it is missing."
            ));
        } else {
            if (timestamp == null) getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, TIMESTAMP_FIELD_NAME),
                    "The eMediplan object creation date is missing, but it is required."
            ); else {
                if (patient == null) getRequiredFieldValidationIssue(
                        getFieldValidationPath(basePath, PATIENT_FIELD_NAME),
                        "The patient object is missing, but it is required."
                );
                else result.add(patient.validate(basePath, type, timestamp));
            }

            if (recommendations != null && !recommendations.isEmpty()) {
                if (type == EMediplanType.POLYMEDICATION_CHECK) {
                    final var iterator = recommendations.listIterator();
                    while (iterator.hasNext()) {
                        final var index = iterator.nextIndex();
                        result.add(iterator.next().validate(getFieldValidationPath(basePath, RECOMMENDATIONS_FIELD_NAME, index)));
                    }
                } else result.add(getIgnoredFieldValidationIssue(
                        getFieldValidationPath(basePath, RECOMMENDATIONS_FIELD_NAME),
                        "No recommendations are expected for a document other than a polymedication check."
                ));
            }

            if (zsr != null && !zsr.isBlank() && (type != EMediplanType.PRESCRIPTION))
                result.add(getIgnoredFieldValidationIssue(
                        getFieldValidationPath(basePath, ZSR_FIELD_NAME),
                        "The ZSR number is present, but not expected for a document other than a prescription."
                ));

            if (remark != null && !remark.isBlank() && type == EMediplanType.POLYMEDICATION_CHECK)
                result.add(getIgnoredFieldValidationIssue(
                        getFieldValidationPath(basePath, REMARKS_FIELD_NAME),
                        "No general remarks are expected for a polymedication check."
                ));

            if (medicaments != null && !medicaments.isEmpty()) {
                final var iterator = medicaments.listIterator();
                while (iterator.hasNext()) {
                    final var index = iterator.nextIndex();
                    result.add(iterator.next().validate(getFieldValidationPath(basePath, MEDICAMENTS_FIELD_NAME, index)));
                }
            }
        }

        if (id == null || id.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, ID_FIELD_NAME),
                "The eMediplan document id is required, but it is missing."
        ));

        if (author == null || author.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, AUTHOR_FIELD_NAME),
                "The eMediplan document author is required, but it is missing."
        ));

        if (validator != null && !validator.isBlank()) {
            if (type == EMediplanType.PRESCRIPTION) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, VALIDATOR_FIELD_NAME),
                    "The medication is not expected to be validated for a prescription."
            ));
            if (Gln.match(validator)) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.VALUE,
                    getFieldValidationPath(basePath, VALIDATOR_FIELD_NAME),
                    "The document validator content is expected to be a valid GLN, but it is not."
            ));
        }

        if (validationTimestamp != null && type == EMediplanType.PRESCRIPTION) result.add(getIgnoredFieldValidationIssue(
                getFieldValidationPath(basePath, VALIDATION_TIMESTAMP_FIELD_NAME),
                "A medication validation date is not expected for a prescription document."
        ));

        if (extensionsSchema != null) {
            if (extensions != null && !extensions.isEmpty()) getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, ChMed16AExtension.EXTENSIONS_FIELD_NAME),
                    "There are present extensions (private fields), but no schema is defined for the document."
            );

        }

        return result;
    }

    @Override
    public void trim() {
        super.trim();

        if (recommendations != null && !recommendations.isEmpty()) recommendations.forEach(ChMed16ARecommendation::trim);
        if (zsr != null && zsr.isBlank()) zsr = null;
        if (remark != null && remark.isBlank()) remark = null;
        if (validator != null && validator.isBlank()) validator = null;
        if (extensionsSchema != null && extensionsSchema.isBlank()) extensionsSchema = null;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (extensions != null && !extensions.isEmpty()) || (inDepth && (
                (patient != null && patient.hasExtensions(true)) ||
                (medicaments != null && medicaments.stream().anyMatch(med -> med.hasExtensions(true))) ||
                (recommendations != null && recommendations.stream().anyMatch(rr -> rr.hasExtensions(true)))
                ));
    }

    @Override
    public String getEmediplanVersion() {
        return EMEDIPLAN_VERSION;
    }

    @Override
    public String getChTransmissionFormatPrefix() {
        return getEmediplanVersion() + "1";
    }
}
