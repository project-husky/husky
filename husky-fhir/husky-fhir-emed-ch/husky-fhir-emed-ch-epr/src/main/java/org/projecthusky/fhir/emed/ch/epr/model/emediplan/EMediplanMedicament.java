package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * A base class for an eMediplan medicament object.
 *
 * @param <E> The type of extension object.
 */
public abstract class EMediplanMedicament<E extends EMediplanObject> implements EMediplanExtendable<E> {
    public final static Double DEFAULT_NUMBER_OF_PACKAGES = 1.0;

    public abstract String getId();
    public abstract MedicamentIdType getIdType();
    public abstract @Nullable String getReason();
    public abstract @Nullable String getPrescriber();
    public abstract @Nullable Double getNumberOfPackages();

    @JsonIgnore
    protected abstract String getIdFieldName();
    @JsonIgnore
    protected abstract String getIdTypeFieldName();

    /**
     * Whether the treatment is a self-medication, that is, it was added to the plan by the patient, or not.
     * @return {@code true} if self-medication, {@code false} otherwise.
     */
    @ExpectsValidResource
    public abstract boolean isSelfMedication();
    public abstract boolean isSubstitutionForbidden();
    public abstract void forbidSubstitution(final @Nullable Boolean selfMedication);

    /**
     * Resolves the actual number of packages, taking into account that the default is 1 if the actual number is not
     * specified.
     * <p>
     *     Note that it makes no sense to call this method in the context of a medication plan, since this is purely
     *     a prescription and dispense matter. A call to this method in the context of a medication plan will still
     *     yield a number (by default, 1), because this method is not context-aware.
     * </p>
     *
     * @return The number of packages to be delivered when redeeming the prescription.
     */
    public Double resolveNumberOfPackages() {
        if (getNumberOfPackages() == null) return DEFAULT_NUMBER_OF_PACKAGES;
        return getNumberOfPackages();
    }

    /**
     *
     * @param basePath           The object's JSON path.
     * @param contextAwareCaller Whether the method was called from a basic object validation (i.e.
     *                           {@link #validate(String)}) or with context (i.e. {@link #validate(String, EMediplanType)}).
     *                           This allows avoiding redundant checks, if the context-aware caller will also invoke
     *                           children validation that are context-aware, thus the basic validator will skip those.
     * @return The validation result.
     */
    protected ValidationResult validateBase(final @Nullable String basePath, boolean contextAwareCaller) {
        final var result = validateExtensions(basePath);

        if (getId() == null || getId().isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, getIdFieldName()),
                "The medicament id is missing or blank but it is mandatory."
        ));

        if (getIdType() == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, getIdTypeFieldName()),
                "The medicament id type is missing but it is mandatory."
        ));

        return result;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        return validateBase(basePath, false);
    }

    /**
     * Context-aware validation, that takes into account whether the eMediplan document is a treatment plan or a
     * prescription.
     *
     * @param basePath     The object's JSON path.
     * @param mediplanType The eMediplan document type.
     * @return The validation result.
     */
    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = validateBase(basePath, true);

        if (mediplanType == EMediplanType.PRESCRIPTION) {
            if (getIdType() != null && getIdType() == MedicamentIdType.PRODUCT_NUMBER) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    getFieldValidationPath(basePath, getIdTypeFieldName()),
                    "The medicament id type is a product number, but the eMediplan document is a prescription. Product numbers are not allowed for prescription documents."
            ));
        }

        return result;
    }

    @Override
    public void trim() {
        EMediplanExtendable.super.trim();
    }
}
