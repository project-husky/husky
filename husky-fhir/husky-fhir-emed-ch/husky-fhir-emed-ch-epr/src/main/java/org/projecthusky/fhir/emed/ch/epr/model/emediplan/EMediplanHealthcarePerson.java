package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitioner;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Abstract base model for an eMediplan HealthcarePerson object, used in both CHMED16A ePrescription and CHMED23A
 * eMediplan documents.
 */
public abstract class EMediplanHealthcarePerson implements EMediplanObject {
    public abstract @Nullable String getGln();
    public abstract String getFirstName();
    public abstract String getLastName();
    public abstract @Nullable String getZsr();

    public abstract void setGln(final @Nullable String gln);
    public abstract void setFirstName(final String firstName);
    public abstract void setLastName(final String lastName);
    public abstract void setZsr(final @Nullable String zsr);

    @JsonIgnore
    public abstract String getGlnFieldName();
    @JsonIgnore
    public abstract String getFirstNameFieldName();
    @JsonIgnore
    public abstract String getLastNameFieldName();

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (getFirstName() == null || getFirstName().isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, getFirstNameFieldName()),
                "The healthcare professional's first name is missing but it is mandatory."
        ));

        if (getLastName() == null || getLastName().isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, getLastNameFieldName()),
                "The healthcare professional's last name is missing but is mandatory."
        ));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }

    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = validate(basePath);

        if (Objects.requireNonNull(mediplanType) == EMediplanType.PRESCRIPTION) {
            if (getGln() == null || getGln().isBlank()) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, getGlnFieldName()),
                    "The healthcare professional's GLN is missing, but it is mandatory for eMediplan prescription documents."
            ));
        }

        if (mediplanType == EMediplanType.MEDICATION_PLAN) {
            if (getZsr() != null && !getZsr().isBlank()) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, "zsr"),
                    "The healthcare's professional ZSR number should not be included in a eMediplan medication plan document."
            ));
        }

        return result;
    }

    /**
     * Gets an eMediplan practitioner object from a CH EMED EPR Practitioner object.
     * @param practitioner The CH EMED EPR Practitioner to be converted.
     * @return The resulting eMediplan practitioner.
     */
    protected static <T extends EMediplanHealthcarePerson> T fromChEmedEprPractitioner(
            final ChEmedEprPractitioner practitioner,
            final Class<T> type
    ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final var zsr = practitioner.resolveZsr();
        final var zsrNumber = zsr.isEmpty()? null : zsr.get(0);
        final var hcPerson =  type.getDeclaredConstructor().newInstance();
        hcPerson.setGln(practitioner.resolveGln());
        hcPerson.setFirstName(practitioner.resolveName().getGivenAsSingleString());
        hcPerson.setLastName(practitioner.resolveName().getFamily());
        hcPerson.setZsr(zsrNumber);
        return hcPerson;
    }

    /**
     * Gets an eMediplan practitioner object from a CH EMED EPR Practitioner object.
     * @param practitioner The CH EMED EPR Practitioner to be converted.
     * @param hcSupplier   The supplier of the HealthcarePerson object, normally a no-args constructor.
     * @return The resulting eMediplan practitioner.
     */
    public static <T extends EMediplanHealthcarePerson> T fromChEmedEprPractitioner(
            final ChEmedEprPractitioner practitioner,
            final Supplier<T> hcSupplier
            ) {
        final var zsr = practitioner.resolveZsr();
        final var zsrNumber = zsr.isEmpty()? null : zsr.get(0);
        final var hcPerson =  hcSupplier.get();
        hcPerson.setGln(practitioner.resolveGln());
        hcPerson.setFirstName(practitioner.resolveName().getGivenAsSingleString());
        hcPerson.setLastName(practitioner.resolveName().getFamily());
        hcPerson.setZsr(zsrNumber);
        return hcPerson;
    }
}
