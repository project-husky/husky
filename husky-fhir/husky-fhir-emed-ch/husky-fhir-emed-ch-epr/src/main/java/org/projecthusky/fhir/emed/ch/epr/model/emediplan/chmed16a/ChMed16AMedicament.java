package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.CdTyp9;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanMedicament;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.CdTyp26;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16APosology;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a medication as well as its dosage.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed16AMedicament extends EMediplanMedicament<ChMed16AExtension> implements ChMed16AExtendable {
    protected static final String ID_FIELD_NAME = "Id";
    protected static final String ID_TYPE_FIELD_NAME = "IdType";
    protected static final String POSOLOGY_FIELD_NAME = "Pos";
    protected static final String UNIT_FIELD_NAME = "Unit";
    protected static final String TAKING_REASON_FIELD_NAME = "TkgRsn";
    protected static final String SELF_MEDICATION_FIELD_NAME = "AutoMed";
    protected static final String PRESCRIBED_BY_FIELD_NAME = "PrscbBy";
    protected static final String ROUTE_OF_ADMINISTRATION_FIELD_NAME = "Roa";
    protected static final String REPETITION_FIELD_NAME = "Rep";
    protected static final String FORBID_SUBSTITUTION_FIELD_NAME = "Subs";
    protected static final String NUMBER_OF_PACKAGES_FIELD_NAME = "NbPack";

    /**
     * The ID defined in the IdType below. If the IdType is 'None', add a free text description here.
     */
    @JsonProperty(ID_FIELD_NAME)
    protected String id;
    /**
     * The type of id.
     */
    @JsonProperty(ID_TYPE_FIELD_NAME)
    protected MedicamentIdType idType;
    /**
     * The list of posologies.
     */
    @JsonProperty(POSOLOGY_FIELD_NAME)
    protected List<@NonNull ChMed16APosology> posology;
    /**
     * The quantity unit. Mandatory if Pos is defined. (The unit must be based on the standardized substance in the
     * INDEX database.)
     */
    @JsonProperty(UNIT_FIELD_NAME)
    protected @Nullable CdTyp9 unit;
    /**
     * Taking reason (the reason for the medication treatment).
     */
    @JsonProperty(TAKING_REASON_FIELD_NAME)
    protected @Nullable String reason;
    /**
     * Application instructions (further information on how to apply the medication, e.g. take before meals).
     */
    @JsonProperty("AppInstr")
    protected @Nullable String applicationInstructions;
    /**
     * Auto-medication (self-medication), 1 if it is auto-medication, 0 otherwise.
     */
    @JsonProperty(SELF_MEDICATION_FIELD_NAME)
    protected @Nullable Integer selfMedication;
    /**
     * Prescribed by: the GLN or designation of the person who prescribed the medicament (e.g. physician, pharmacist etc.)
     */
    @JsonProperty(PRESCRIBED_BY_FIELD_NAME)
    protected @Nullable String prescriber;
    /**
     * Route of administration. Possible values: CDTYP 26 in HCI's INDEX database/CODE schema.
     */
    @JsonProperty(ROUTE_OF_ADMINISTRATION_FIELD_NAME)
    protected @Nullable CdTyp26 routeOfAdministration;
    /**
     * Integer which defines the number of repetitions in months, e.g. permanent prescription for 6 months.
     */
    @JsonProperty(REPETITION_FIELD_NAME)
    protected @Nullable Integer repetition;
    /**
     * 1 if medicament should not be substituted, 0 otherwise. Default: 0
     */
    @JsonProperty(FORBID_SUBSTITUTION_FIELD_NAME)
    protected @Nullable Integer forbidSubstitution;
    /**
     * Number of packages to be delivered. Default: 1
     */
    @JsonProperty(NUMBER_OF_PACKAGES_FIELD_NAME)
    protected @Nullable Double numberOfPackages;
    /**
     * Extensions.
     */
    @JsonProperty(ChMed16AExtension.EXTENSIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed16AExtension> extensions;

    @Override
    public String getIdFieldName() {
        return ID_FIELD_NAME;
    }

    @Override
    public String getIdTypeFieldName() {
        return ID_TYPE_FIELD_NAME;
    }

    @Override
    public List<@NonNull ChMed16AExtension> getExtensions() {
        if ( extensions == null ) extensions = new ArrayList<>();
        return extensions;
    }

    /**
     * Convenience method to set the self-medication property using a boolean.
     */
    public void setSelfMedication(final boolean selfMedication) {
        this.selfMedication = selfMedication ? 1 : 0;
    }

    /**
     * This method expects the Medicament object to be valid. This means that it expects that the only case for the
     * self-medication property to be {@code null} is when the document is a prescription and, in this case, it
     * assumes that it is therefore not a self-medication. When not-null, the value returned is that of the property.
     *
     * @return Whether the medication is a self-medication treatment or a prescribed one.
     */
    @Override
    @ExpectsValidResource
    public boolean isSelfMedication() {
        if (selfMedication == null) return false;
        return selfMedication == 1;
    }

    @Override
    @JsonIgnore
    public boolean isSubstitutionForbidden() {
        return forbidSubstitution != null && forbidSubstitution == 1;
    }

    @Override
    public void forbidSubstitution(final @Nullable Boolean substitutionForbidden) {
        if (substitutionForbidden == null) forbidSubstitution = null;
        else this.forbidSubstitution = substitutionForbidden ? 1 : 0;
    }

    @Override
    public ValidationResult validateBase(final @Nullable String basePath, final boolean contextAwareCaller) {
        final var result = super.validateBase(basePath, contextAwareCaller);

        if (posology == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, POSOLOGY_FIELD_NAME),
                "The posology field is mandatory even if empty, but it is missing."
        ));
        else if (!contextAwareCaller && !posology.isEmpty()) {
            final var posologyIterator = posology.listIterator();
            while (posologyIterator.hasNext()) {
                final var index = posologyIterator.nextIndex();
                result.add(posologyIterator.next().validate(getFieldValidationPath(basePath, POSOLOGY_FIELD_NAME, index)));
            }
        }

        if (selfMedication != null && (selfMedication < 0 || selfMedication > 1)) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, SELF_MEDICATION_FIELD_NAME),
                "The self medication value has to be either 0 or 1, but a different value has been specified."
        ));

        if (forbidSubstitution != null && (forbidSubstitution < 0 || forbidSubstitution > 1)) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, FORBID_SUBSTITUTION_FIELD_NAME),
                "The substitution value has to be either 0 or 1, but a different value has been specified."
        ));

        return result;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = super.validate(basePath, mediplanType);

        if (posology != null) {
            if (posology.size() > 1 && (mediplanType == EMediplanType.POLYMEDICATION_CHECK || mediplanType == EMediplanType.PRESCRIPTION))
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.INVALID,
                        getFieldValidationPath(basePath, POSOLOGY_FIELD_NAME),
                        "There can be either 0 or 1 posology objects for a medication on a polymedication check or a prescription type of document, but more are specified."
                ));
            if (!posology.isEmpty()) {
                final var posologyIterator = posology.listIterator();
                while (posologyIterator.hasNext()) {
                    final var index = posologyIterator.nextIndex();
                    result.add(posologyIterator.next().validate(getFieldValidationPath(basePath, POSOLOGY_FIELD_NAME, index), mediplanType));
                }
            }
        }

        if (mediplanType == EMediplanType.MEDICATION_PLAN || mediplanType == EMediplanType.POLYMEDICATION_CHECK) {
            if (selfMedication == null) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, SELF_MEDICATION_FIELD_NAME),
                    "The self-medication field is mandatory for medication plans and polymedication check documents, but it is missing."
            ));

            if (repetition != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, REPETITION_FIELD_NAME),
                    "The repetition field is specified, but it is not expected for either a medication plan or a polymedication check."
            ));

            if (forbidSubstitution != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, FORBID_SUBSTITUTION_FIELD_NAME),
                    "The substitution field is present, but it is not expected for either a medication plan or a polymedication check."
            ));

            if (numberOfPackages != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, NUMBER_OF_PACKAGES_FIELD_NAME),
                    "The number of packages field is present, but it is not expected for either a medication plan or a polymedication check."
            ));

            if (mediplanType == EMediplanType.MEDICATION_PLAN) {
                if (unit == null) result.add(getRequiredFieldValidationIssue(
                        getFieldValidationPath(basePath, UNIT_FIELD_NAME),
                        "The dosage unit is missing, but it is required for medication plans."
                ));
            }
        } else {
            if (reason == null || reason.isBlank()) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, TAKING_REASON_FIELD_NAME),
                    "The medication object has a specified reason, but this is not expected for prescription documents."
            ));
            if (selfMedication != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, SELF_MEDICATION_FIELD_NAME),
                    "The medication object has a specified self-medication value, but this is not expected to be present for prescription documents."
            ));
        }

        if (mediplanType == EMediplanType.POLYMEDICATION_CHECK || mediplanType == EMediplanType.PRESCRIPTION) {
            if (prescriber != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, PRESCRIBED_BY_FIELD_NAME),
                    "The prescriber field is specified, but it is not expected for a polymedication check or a prescription document."
            ));
            if (routeOfAdministration != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, ROUTE_OF_ADMINISTRATION_FIELD_NAME),
                    "The route of administration is specified, but it is not expected for a polymedication check or a prescription document."
            ));
        }



        return result;
    }

    @Override
    public void trim() {
        super.trim();
        if (posology != null) posology.forEach(ChMed16APosology::trim);
        if (forbidSubstitution != null && forbidSubstitution == 0) forbidSubstitution = null;
        if (numberOfPackages != null && numberOfPackages == 1) numberOfPackages = null;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (extensions != null && !extensions.isEmpty()) || (inDepth && (
                (posology != null && posology.stream().anyMatch(pos -> pos.hasExtensions(true)))
                ));
    }
}
