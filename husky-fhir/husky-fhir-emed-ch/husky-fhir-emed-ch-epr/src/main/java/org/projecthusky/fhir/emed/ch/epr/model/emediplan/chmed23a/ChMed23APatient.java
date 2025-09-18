package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPatient;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.ChMed23AGender;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPatient;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ChMed23APatient extends EMediplanPatient<ChMed23AExtension> implements ChMed23AExtendable {
    protected static final String LANGUAGE_FIELD_NAME = "lng";
    protected static final String IDS_FIELD_NAME = "ids";
    protected static final String MEDICAL_DATA_FIELD_NAME = "mData";
    protected static final String PHONES_FIELD_NAME = "phones";
    protected static final String EMAILS_FIELD_NAME = "emails";

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
     * Date of birth, day precision. Format: yyyy-mm-dd (ISO 8601 Date)
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("bdt")
    protected LocalDate birthDate;
    /**
     * Gender of the patient. The terms gender and sex are considered synonyms in ChMed23A.
     */
    protected ChMed23AGender gender;
    /**
     * Postal address of the patient.
     */
    @JsonUnwrapped
    protected ChMed23APostalAddress address;
    /**
     * The patient's language (ISO 639-16 language code) (e.g. de). Note that while the lowercase version is preferred,
     * the codes are also valid in uppercase (e.g. DE).
     */
    @JsonProperty(LANGUAGE_FIELD_NAME)
    protected @Nullable String languageCode;
    /**
     * List of patient identifiers.
     */
    protected List<ChMed23APatientId> ids;
    /**
     * The list of extensions. Optional if empty.
     */
    @JsonProperty(ChMed23AExtension.EXTENSIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed23AExtension> extensions;
    /**
     * Medical data information.
     */
    @JsonProperty(MEDICAL_DATA_FIELD_NAME)
    protected @Nullable ChMed23APatientMedicalData medicalData;

    /**
     * List of phone numbers.
     */
    @JsonProperty(PHONES_FIELD_NAME)
    protected List<@NonNull String> phones;
    /**
     * List of email addresses.
     */
    @JsonProperty(EMAILS_FIELD_NAME)
    protected List<@NonNull String> emails;

    @Override
    protected String getLanguageFieldName() {
        return LANGUAGE_FIELD_NAME;
    }

    @Override
    protected String getIdsFieldName() {
        return IDS_FIELD_NAME;
    }

    @Override
    protected String getMedicalDataFieldName() {
        return MEDICAL_DATA_FIELD_NAME;
    }

    @Override
    protected String getPhonesFieldName() {
        return PHONES_FIELD_NAME;
    }

    @Override
    protected String getEmailsFieldName() {
        return EMAILS_FIELD_NAME;
    }

    @Override
    public List<@NonNull ChMed23AExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    @Override
    protected ValidationResult validateBase(final @Nullable String basePath, boolean contextAwareCaller) {
        final var result = super.validateBase(basePath, contextAwareCaller);

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

        if (ids == null || ids.isEmpty()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, getIdsFieldName()),
                "At least one patient identifier must be provided."
        ));

        return result;
    }

    /**
     * Gets an EMediplanPatient from an CH EPR patient.
     *
     * @param eprFhirPatient The CH EPR patient to be converted.
     * @return The eMediplan patient.
     */
    public static ChMed23APatient fromEprFhir(final ChEmedEprPatient eprFhirPatient,
                                              final @Nullable Observation weightObservation) {
        String language = null;
        final var fhirAddress = eprFhirPatient.resolveAddress();
        final var preferredLanguage = eprFhirPatient.resolveLanguageOfCorrespondence();
        if (preferredLanguage != null && preferredLanguage.hasLanguage() && preferredLanguage.getLanguage().hasCoding()) {
            language = preferredLanguage.getLanguage().getCoding().stream().filter(Coding::hasCode)
                    .map(Coding::getCode).map(ChMed23APatient::fhirLanguageCodeToEMediplanLanguageCode)
                    .filter(Objects::nonNull).findAny().orElseGet(() -> {
                        log.warn("Could not fetch a 2 letter code for the patient's language, but it is needed for eMediplan.");
                        return null;
                    });
        }
        ChMed23APatientMedicalData medicalData = null;
        if (weightObservation != null &&
                weightObservation.hasValueQuantity() &&
                weightObservation.getValueQuantity().hasCode() &&
                "kg".equals(weightObservation.getValueQuantity().getCode())
        ) {
            medicalData = new ChMed23APatientMedicalData();
            medicalData.setWeight(weightObservation.getValueQuantity().getValue().doubleValue());
        }
        return new ChMed23APatient(
                eprFhirPatient.getNameFirstRep().getGivenAsSingleString(),
                eprFhirPatient.getNameFirstRep().getFamily(),
                eprFhirPatient.resolveBirthDate(),
                ChMed23AGender.fromFhirAdministrativeGender(eprFhirPatient.resolveGender()),
                fhirAddress == null? null : ChMed23APostalAddress.fromFhirAddress(fhirAddress),
                language,
                eprFhirPatient.getIdentifier().stream().map(ChMed23APatientId::fromFhirIdentifier).toList(),
                null,
                medicalData,
                eprFhirPatient.resolvePhoneNumbersAsStrings(true),
                eprFhirPatient.resolveEmailAddressesAsStrings(true)
        );
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (extensions != null && !extensions.isEmpty()) || (inDepth && (
                (address != null && address.hasExtensions(true)) ||
                (ids != null && ids.stream().anyMatch(id -> id.hasExtensions(true))) ||
                (medicalData != null && medicalData.hasExtensions(true))
                ));
    }
}
