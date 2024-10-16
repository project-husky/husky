package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.Gender;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class EMediplanPatient implements EMediplanExtendable, EMediplanObject {
    private static final Pattern LANGUAGE_CODE_PATTERN = Pattern.compile("[a-zA-Z]{2}" );
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\+?[0-9]+[ 0-9]*");
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^(?=.{1,64}@)[\\\\p{L}0-9_-]+(\\\\.[\\\\p{L}0-9_-]+)*@[^-][\\\\p{L}0-9-]+(\\\\.[\\\\p{L}0-9-]+)*(\\\\.[\\\\p{L}]{2,})$");

    protected static final String MEDICAL_DATA_FIELD_NAME = "mData";

    /**
     * First name.
     */
    @JsonProperty("fName")
    protected String firstName;
    /**
     * Last name.
     */
    @JsonProperty("lName")
    protected String lastName;
    /**
     * Date of birth, day precision. Format: yyyy-mm-dd (ISO 86013 Date)
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("bdt")
    protected LocalDate birthDate;
    /**
     * Gender of the patient. The terms gender and sex are considered synonyms in ChMed23A.
     */
    protected Gender gender;
    /**
     * Postal address of the patient.
     */
    @JsonUnwrapped
    protected EMediplanPostalAddress address;
    /**
     * The patient's language (ISO 639-16 language code) (e.g. de). Note that while the lowercase version is preferred,
     * the codes are also valid in uppercase (e.g. DE).
     */
    @JsonProperty("lng")
    protected String languageCode;
    /**
     * List of patient identifiers.
     */
    protected List<EMediplanPatientId> ids;
    /**
     * The list of extensions. Optional if empty.
     */
    @JsonProperty("exts")
    protected @Nullable List<@NonNull EMediplanExtension> extensions;
    /**
     * Medical data information.
     */
    @JsonProperty(MEDICAL_DATA_FIELD_NAME)
    protected @Nullable EMediplanPatientMedicalData medicalData;
    /**
     * List of phone numbers.
     */
    protected List<@NonNull String> phones;
    /**
     * List of email addresses.
     */
    protected List<@NonNull String> emails;

    public List<@NonNull EMediplanExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        return validateBase(basePath, false);
    }

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
        final var result = new ValidationResult();

        if (firstName == null || firstName.isBlank())
            result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, "fName"),
                    "The patient's first name is missing or it is blank, but it is mandatory."
            ));
        if (lastName == null || lastName.isBlank())
            result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath,"lName"),
                    "The patient's last name is missing or it is blank, but it is mandatory."
            ));

        if (birthDate == null)
            result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath,  "bdt"),
                    "The patient's birthdate is missing, but it is mandatory."
            ));

        if (gender == null)
            result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath ,"gender"),
                    "The patient's gender is missing, but it is mandatory."
            ));

        if (address != null) address.validate(basePath);

        if ((languageCode != null && !languageCode.isBlank())) {
            final var matcher = LANGUAGE_CODE_PATTERN.matcher(languageCode);
            if (!matcher.matches()) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.WARNING,
                    OperationOutcome.IssueType.CODEINVALID,
                    getFieldValidationPath(basePath, "lng"),
                    "The patient's language code should be a 2 letter ISO 639-16 language code."
            ));
        }

        if (ids == null || ids.isEmpty()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "ids"),
                "At least one patient identifier must be provided."
        ));
        else {
            final var idsIterator = ids.listIterator();
            while (idsIterator.hasNext()) {
                final var index = idsIterator.nextIndex();
                result.add(idsIterator.next().validate(getFieldValidationPath(basePath, "ids", index)));
            }
        }

        if (extensions != null && !extensions.isEmpty()) {
            final var extensionsIterator = extensions.listIterator();
            while (extensionsIterator.hasNext()) {
                final var index = extensionsIterator.nextIndex();
                result.add(extensionsIterator.next().validate(getFieldValidationPath(basePath, "exts", index)));
            }
        }

        if (medicalData != null && !contextAwareCaller)
            result.add(medicalData.validate(getFieldValidationPath(basePath, MEDICAL_DATA_FIELD_NAME)));

        if (phones != null && !phones.isEmpty()) {
            final var phonesIterator = phones.listIterator();
            while (phonesIterator.hasNext()) {
                final var index = phonesIterator.nextIndex();
                final var phone = phonesIterator.next();
                if (!PHONE_NUMBER_PATTERN.matcher(phone).matches()) result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.WARNING,
                        OperationOutcome.IssueType.VALUE,
                        getFieldValidationPath(basePath, "phones", index),
                        "The patient's phone number does not seem to be a valid phone number."
                ));
            }
        }
        if (emails != null && !emails.isEmpty()) {
            final var emailIterator = emails.listIterator();
            while (emailIterator.hasNext()) {
                final var index = emailIterator.nextIndex();
                final var email = emailIterator.next();
                if (!EMAIL_PATTERN.matcher(email).matches()) result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.WARNING,
                        OperationOutcome.IssueType.VALUE,
                        getFieldValidationPath(basePath, "emails", index),
                        "The patient's email address does not seem to be a valid email address."
                ));
            }
        }

        return result;
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
            if ((languageCode == null || languageCode.isBlank())) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, "lng"),
                    "The patient's language code is missing or is blank, but it is mandatory for a medication plan."
            ));
        }
        if (mediplanType == EMediplanType.PRESCRIPTION) {
            if (languageCode != null && !languageCode.isBlank()) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, "lng"),
                    "The patient's language code should not be present if the eMediplan document is a prescription."
            ));

            if (medicalData != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, MEDICAL_DATA_FIELD_NAME),
                    "The patient's medical data object should not be present in a prescription eMediplan document."
            ));
        }

        if (medicalData != null)
            result.add(medicalData.validate(
                    getFieldValidationPath(basePath, MEDICAL_DATA_FIELD_NAME),
                    Period.between(birthDate, LocalDate.ofInstant(timestamp, ZoneId.of(EMediplan.EMEDIPLAN_TIMEZONE)))
                    ));

        return result;
    }

    @Override
    public void trim() {
        if (address != null) address.trim();

        if (ids != null && !ids.isEmpty()) ids.forEach(EMediplanPatientId::trim);

        if (medicalData != null) medicalData.trim();
    }

    /**
     * Gets an EMediplanPatient from an CH EPR patient.
     *
     * @param eprFhirPatient The CH EPR patient to be converted.
     * @return The eMediplan patient.
     */
    public static EMediplanPatient fromEprFhir(final ChCorePatientEpr eprFhirPatient,
                                               final @Nullable Observation weightObservation) {
        String language = null;
        final var fhirAddress = eprFhirPatient.resolveAddress();
        final var preferredLanguage = eprFhirPatient.resolveLanguageOfCorrespondence();
        if (preferredLanguage != null && preferredLanguage.hasLanguage() && preferredLanguage.getLanguage().hasCoding()) {
            language = preferredLanguage.getLanguage().getCoding().stream().filter(Coding::hasCode)
                    .map(Coding::getCode).map(EMediplanPatient::fhirLanguageCodeToEMediplanLanguageCode)
                    .filter(Objects::nonNull).findAny().orElseGet(() -> {
                        log.warn("Could not fetch a 2 letter code for the patient's language, but it is needed for eMediplan.");
                        return null;
                    });
        }
        EMediplanPatientMedicalData medicalData = null;
        if (weightObservation != null &&
                weightObservation.hasValueQuantity() &&
                weightObservation.getValueQuantity().hasCode() &&
                "kg".equals(weightObservation.getValueQuantity().getCode())
        ) {
            medicalData = new EMediplanPatientMedicalData();
            medicalData.setWeight(weightObservation.getValueQuantity().getValue().doubleValue());
        }
        return new EMediplanPatient(
                eprFhirPatient.getNameFirstRep().getGivenAsSingleString(),
                eprFhirPatient.getNameFirstRep().getFamily(),
                eprFhirPatient.resolveBirthDate(),
                Gender.fromFhirAdministrativeGender(eprFhirPatient.resolveGender()),
                fhirAddress == null? null : EMediplanPostalAddress.fromFhirAddress(fhirAddress),
                language,
                eprFhirPatient.getIdentifier().stream().map(EMediplanPatientId::fromFhirIdentifier).toList(),
                null,
                medicalData,
                eprFhirPatient.resolvePhoneNumbersAsStrings(true),
                eprFhirPatient.resolveEmailAddressesAsStrings(true)
        );
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
}
