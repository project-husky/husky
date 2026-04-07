package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPatient;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Base class for modelling an eMediplan patient object, be it for CHMED16A or CHMED23A.
 * @param <E> The specific type of eMediplan extension.
 * @param <G> The specific type of eMediplan Gender enum.
 * @param <I> The specific type of patient identifier object.
 */
@Slf4j
public abstract class EMediplanPatient<E extends EMediplanObject, G extends EMediplanGender, I extends EMediplanIdentifier> implements EMediplanExtendable<E> {
    private static final Pattern LANGUAGE_CODE_PATTERN = Pattern.compile("^[a-zA-Z]{2}$" );
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\+?[0-9]+[ 0-9]*$");
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9/_-]+(\\.[\\p{L}0-9/_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$");

    @JsonIgnore
    protected abstract String getLanguageFieldName();
    @JsonIgnore
    protected abstract String getIdsFieldName();
    @JsonIgnore
    protected abstract String getMedicalDataFieldName();
    @JsonIgnore
    protected abstract String getPhonesFieldName();
    @JsonIgnore
    protected abstract String getEmailsFieldName();

    public abstract @Nullable String getFirstName();
    public abstract @Nullable String getLastName();
    public abstract @Nullable LocalDate getBirthDate();
    public abstract @Nullable G getGender();
    public abstract @Nullable EMediplanPostalAddress getAddress();
    public abstract @Nullable String getLanguageCode();
    public abstract @Nullable EMediplanPatientMedicalData<E> getMedicalData();
    public abstract List<@NonNull String> getPhones();
    public abstract List<@NonNull String> getEmails();
    public abstract @Nullable List<@NonNull I> getIds();

    /**
     * Base validation that performs or skips certain validation checks depending on whether the caller is context-aware
     * or not. This prevents redundant validation checks when the caller is context-aware and will also call children
     * context-aware validation methods instead of their basic counterparts, that will be skipped by this method.
     *
     * @param basePath           The object's JSON path.
     * @param contextAwareCaller Whether caller is context aware or not. If true, some validation checks might be skipped.
     * @return The validation result.
     */
    protected ValidationResult validateBase(final @Nullable String basePath, boolean contextAwareCaller) {
        final var result = validateExtensions(basePath);

        if (getAddress() != null) result.add(getAddress().validate(basePath));

        if ((getLanguageCode() != null && !getLanguageCode().isBlank())) {
            final var matcher = LANGUAGE_CODE_PATTERN.matcher(getLanguageCode());
            if (!matcher.matches()) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.WARNING,
                    OperationOutcome.IssueType.CODEINVALID,
                    getFieldValidationPath(basePath, getLanguageFieldName()),
                    "The patient's language code should be a 2 letter ISO 639-16 language code."
            ));
        }

        if (getIds() != null && !getIds().isEmpty()) {
            final var idsIterator = getIds().listIterator();
            while (idsIterator.hasNext()) {
                final var index = idsIterator.nextIndex();
                result.add(idsIterator.next().validate(getFieldValidationPath(basePath, getIdsFieldName(), index)));
            }
        }

        if (getMedicalData() != null && !contextAwareCaller)
            result.add(getMedicalData().validate(getFieldValidationPath(basePath, getMedicalDataFieldName())));

        if (!getPhones().isEmpty()) {
            final var phonesIterator = getPhones().listIterator();
            while (phonesIterator.hasNext()) {
                final var index = phonesIterator.nextIndex();
                final var phone = phonesIterator.next();
                result.add(validatePhone(basePath, getPhonesFieldName(), index, phone));
            }
        }

        if (!getEmails().isEmpty()) {
            final var emailIterator = getEmails().listIterator();
            while (emailIterator.hasNext()) {
                final var index = emailIterator.nextIndex();
                final var email = emailIterator.next();
                result.add(validateEmailAddress(basePath, getEmailsFieldName(), index, email));
            }
        }

        return result;
    }

    public ValidationResult validate(final @Nullable String basePath) {
        return validateBase(basePath, false);
    }

    /**
     * Validates the patient object taking into account which type of eMediplan document it belongs to. It performs the
     * basic check done by {@link #validate(String)} plus extra validation taking into account the document type.
     *
     * @param basePath     The base path of the JSON object.
     * @param mediplanType The type of eMediplan document.
     * @param timestamp    The timestamp of the eMediplan document creation.
     * @return The validation result.
     */
    public ValidationResult validate(final @Nullable String basePath,
                                     final EMediplanType mediplanType,
                                     final Instant timestamp) {
        Objects.requireNonNull(mediplanType);
        Objects.requireNonNull(timestamp);
        final var result = validateBase(basePath, true);
        if (mediplanType == EMediplanType.MEDICATION_PLAN) {
            if ((getLanguageCode() == null || getLanguageCode().isBlank())) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, getLanguageFieldName()),
                    "The patient's language code is missing or is blank, but it is mandatory for a medication plan."
            ));
        }
        if (mediplanType == EMediplanType.PRESCRIPTION) {
            if (getLanguageCode() != null && !getLanguageCode().isBlank()) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, getLanguageFieldName()),
                    "The patient's language code should not be present if the eMediplan document is a prescription."
            ));

            if (getMedicalData() != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, getMedicalDataFieldName()),
                    "The patient's medical data object should not be present in a prescription eMediplan document."
            ));
        }

        if (getMedicalData() != null && getBirthDate() != null)
            result.add(getMedicalData().validate(
                    getFieldValidationPath(basePath, getMedicalDataFieldName()),
                    Period.between(getBirthDate(), LocalDate.ofInstant(timestamp, ZoneId.of(EMediplan.EMEDIPLAN_TIMEZONE)))
            ));

        return result;
    }

    @Override
    public void trim() {
        if (getAddress() != null) getAddress().trim();

        if (getIds() != null && !getIds().isEmpty()) getIds().forEach(EMediplanObject::trim);

        if (getMedicalData() != null) getMedicalData().trim();
    }

    /**
     * Translates a code value from a FHIR language coding to an eMediplan language code.
     * <p>
     *     It expects a language code that would be either a 2-character ISO language code or one of the 5 characters
     *     long Swiss variants (e.g. fr-CH). Matching is not case-sensitive. A 5-character language code will be
     *     shortened to a 2 character code to comply with eMediplan specifications.
     * </p>
     *
     * @param code The language code.
     * @return The eMediplan language code.
     */
    public static @Nullable String fhirLanguageCodeToEMediplanLanguageCode(final String code) {
        if (code.length() == 2)
            return code;
        if (code.length() == 5 && code.toUpperCase().endsWith("-CH"))
            return code.substring(0, code.length() - 3);
        return null;
    }

    protected ValidationResult validatePhone(final @Nullable String basePath,
                                             final String fieldName,
                                             final int index,
                                             final String phone) {
        final var result = new ValidationResult();
        if (!PHONE_NUMBER_PATTERN.matcher(phone).matches()) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, fieldName, index),
                "The patient's phone number does not seem to be a valid phone number."
        ));
        return result;
    }

    protected ValidationResult validateEmailAddress(final @Nullable String basePath,
                                                    final String fieldName,
                                                    final int index,
                                                    final String email) {
        final var result = new ValidationResult();
        if (!EMAIL_PATTERN.matcher(email).matches()) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, fieldName, index),
                "The patient's email address does not seem to be a valid email address."
        ));
        return result;
    }

    /**
     * Gets the CH EMED EPR FHIR representation of the eMediplan patient object.
     * @return The CH EMED EPR patient object.
     * @throws InvalidEmedContentException if it is not possible to get a valid CH EMED EPR patient from the eMediplan
     *                                     object.
     */
    @ExpectsValidResource
    public ChEmedEprPatient toFhir() throws InvalidEmedContentException {
        final var fhirPatient = new ChEmedEprPatient();
        if (getFirstName() == null || getLastName() == null)
            throw new InvalidEmedContentException("The patient's first and last name are mandatory in the CH EMED EPR context.");
        final var name = fhirPatient.addName().setFamily(getLastName());
        if (getFirstName() == null) Arrays.stream(getFirstName().split(" ")).forEach(name::addGiven);
        if (getBirthDate() == null)
            throw new InvalidEmedContentException("The patient's birth date is mandatory in the CH EMED EPR context.");
        fhirPatient.setBirthDate(getBirthDate());
        if (getGender() == null) {
            log.warn("The patient's gender is mandatory in the CH EMED EPR context. The converter will use \"unknown\", but this will result on a warning on the CH EMED EPR validation side.");
            fhirPatient.setGender(Enumerations.AdministrativeGender.UNKNOWN);
        } else fhirPatient.setGender(getGender().toFhir());
        if (getAddress() != null) fhirPatient.addAddress(getAddress().toFhir());
        if (getLanguageCode() != null)
            fhirPatient.addCommunication()
                    .setLanguage(new CodeableConcept().addCoding(new Coding().setSystem("urn:ietf:bcp:47").setCode(getLanguageCode())));
        for (final var phone : getPhones()) fhirPatient.addPhoneNumber(phone);
        for (final var email : getEmails()) fhirPatient.addEmailAddress(email);
        if (getIds() == null)
            throw new InvalidEmedContentException("The patient must have at least one identifier in the CH EMED EPR context.");
        else {
            for (final var id : getIds()) fhirPatient.addIdentifier(id.toFhir());
        }
        return fhirPatient;
    }
}
