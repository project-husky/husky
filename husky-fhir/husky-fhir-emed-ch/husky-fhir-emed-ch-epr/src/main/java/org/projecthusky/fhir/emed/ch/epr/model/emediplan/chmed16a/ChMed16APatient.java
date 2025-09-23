package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreOrganization;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitioner;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPatient;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.ChMed16AGender;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.ChMed16AMeasurementType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.ChMed16AMeasurementUnit;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPatient;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ChMed16APatient extends EMediplanPatient<ChMed16AExtension> implements ChMed16AExtendable {
    protected static final String FIRST_NAME_FIELD_NAME = "FName";
    protected static final String LAST_NAME_FIELD_NAME = "LName";
    protected static final String BIRTH_DATE_FIELD_NAME = "BDt";
    protected static final String LANGUAGE_FIELD_NAME = "Lng";
    protected static final String IDS_FIELD_NAME = "Ids";
    protected static final String MEDICAL_DATA_FIELD_NAME = "Med";
    protected static final String PHONE_FIELD_NAME = "Phone";
    protected static final String EMAIL_FIELD_NAME = "Email";

    /**
     * First name.
     */
    @JsonProperty(FIRST_NAME_FIELD_NAME)
    protected @Nullable String firstName;
    /**
     * Last name.
     */
    @JsonProperty(LAST_NAME_FIELD_NAME)
    protected @Nullable String lastName;
    /**
     * Date of birth, day precision. Format: yyyy-mm-dd (ISO 8601 Date)
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty(BIRTH_DATE_FIELD_NAME)
    protected @Nullable LocalDate birthDate;
    /**
     * Gender of patient.
     */
    @JsonProperty("Gender")
    protected @Nullable ChMed16AGender gender;
    /**
     * Postal address of the patient.
     */
    @JsonUnwrapped
    protected @Nullable ChMed16APostalAddress address;
    /**
     * The patient's language (ISO 639-16 language code) (e.g. de). Note that while the lowercase version is preferred,
     * the codes are also valid in uppercase (e.g. DE).
     */
    @JsonProperty(LANGUAGE_FIELD_NAME)
    protected @Nullable String languageCode;
    /**
     * Phone number.
     */
    @JsonProperty(PHONE_FIELD_NAME)
    protected @Nullable String phone;
    /**
     * Email address
     */
    @JsonProperty(EMAIL_FIELD_NAME)
    protected @Nullable String email;
    /**
     * Receiver (GLN) of the electronic prescription. To be used if the electronic prescription is to be transmitted
     * electronically to a healthcare professional.
     */
    @JsonProperty("Rcv")
    protected @Nullable String receiver;
    /**
     * The list of patient identifiers
     */
    @JsonProperty(IDS_FIELD_NAME)
    protected @Nullable List<ChMed16APatientId> ids;
    /**
     * Medical data information.
     */
    @JsonProperty("Med")
    protected @Nullable ChMed16APatientMedicalData medicalData;
    /**
     * Extensions.
     */
    @JsonProperty(ChMed16AExtension.EXTENSIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed16AExtension> extensions;

    @Override
    public List<@NonNull ChMed16AExtension> getExtensions() {
        if ( extensions == null ) extensions = new ArrayList<>();
        return extensions;
    }

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
        return PHONE_FIELD_NAME;
    }

    @Override
    protected String getEmailsFieldName() {
        return EMAIL_FIELD_NAME;
    }

    @JsonIgnore
    @Override
    public List<@NonNull String> getPhones() {
        return phone == null? List.of() : List.of(phone);
    }

    @JsonIgnore
    @Override
    public List<@NonNull String> getEmails() {
        return email == null? List.of() : List.of(email);
    }

    public ValidationResult validate(final @Nullable String basePath,
                                     final EMediplanType mediplanType,
                                     final Instant timestamp) {
        final var result = super.validate(basePath, mediplanType, timestamp);

        if (mediplanType == EMediplanType.PRESCRIPTION || mediplanType == EMediplanType.POLYMEDICATION_CHECK) {
            if (firstName == null || firstName.isBlank())
                result.add(getRequiredFieldValidationIssue(
                        getFieldValidationPath(basePath, FIRST_NAME_FIELD_NAME),
                        "The patient's first name is missing or it is blank, but it is mandatory."
                ));
            if (lastName == null || lastName.isBlank())
                result.add(getRequiredFieldValidationIssue(
                        getFieldValidationPath(basePath,LAST_NAME_FIELD_NAME),
                        "The patient's last name is missing or it is blank, but it is mandatory."
                ));

            if (birthDate == null)
                result.add(getRequiredFieldValidationIssue(
                        getFieldValidationPath(basePath,  LAST_NAME_FIELD_NAME),
                        "The patient's birthdate is missing, but it is mandatory."
                ));
        }

        return result;
    }

    /**
     * Gets an EMediplanPatient from an CH EPR patient.
     *
     * @param eprFhirPatient    The CH EMED EPR patient to be converted.
     * @param weightObservation The CH EMED EPR weight observation, if any.
     * @param informationRecipients The recipients of the CH EMED EPR content.
     * @param mediplanType      The type of eMediplan document for which to get the patient. Some fields should be
     *                          omitted depending on the document type.
     * @return The eMediplan patient.
     */
    public static ChMed16APatient fromEprFhir(final ChEmedEprPatient eprFhirPatient,
                                              final @Nullable Observation weightObservation,
                                              final List<Reference> informationRecipients,
                                              final EMediplanType mediplanType) {
        String language = null;
        ChMed16APatientMedicalData medicalData = null;
        String receiver = null;
        final var fhirAddress = eprFhirPatient.resolveAddress();

        if (mediplanType == EMediplanType.MEDICATION_PLAN) {
            final var preferredLanguage = eprFhirPatient.resolveLanguageOfCorrespondence();
            if (preferredLanguage != null && preferredLanguage.hasLanguage() && preferredLanguage.getLanguage().hasCoding()) {
                language = preferredLanguage.getLanguage().getCoding().stream().filter(Coding::hasCode)
                        .map(Coding::getCode).map(ChMed16APatient::fhirLanguageCodeToEMediplanLanguageCode)
                        .filter(Objects::nonNull).findAny().orElseGet(() -> {
                            log.warn("Could not fetch a 2 letter code for the patient's language, but it is needed for eMediplan.");
                            return null;
                        });
            }

            if (weightObservation != null &&
                    weightObservation.hasValueQuantity() &&
                    weightObservation.getValueQuantity().hasCode() &&
                    "kg".equals(weightObservation.getValueQuantity().getCode())
            ) {
                medicalData = new ChMed16APatientMedicalData();
                medicalData.addMeasurement(new ChMed16APatientMedicalDataMeasurement(
                        ChMed16AMeasurementType.WEIGHT,
                        weightObservation.getValueQuantity().getValue().toString(),
                        ChMed16AMeasurementUnit.KILOGRAM
                ));
            }
        } else if (mediplanType == EMediplanType.PRESCRIPTION) {
            receiver = getFirstProfessionalRecipient(informationRecipients);
        }

        final var phones = eprFhirPatient.resolvePhoneNumbersAsStrings(true);
        final var emails = eprFhirPatient.resolveEmailAddressesAsStrings(true);

        return new ChMed16APatient(
                eprFhirPatient.getNameFirstRep().getGivenAsSingleString(),
                eprFhirPatient.getNameFirstRep().getFamily(),
                eprFhirPatient.resolveBirthDate(),
                ChMed16AGender.fromFhirAdministrativeGender(eprFhirPatient.resolveGender()),
                fhirAddress == null? null : ChMed16APostalAddress.fromFhirAddress(fhirAddress),
                language,
                phones.isEmpty() ? null : phones.getFirst(),
                emails.isEmpty() ? null : emails.getFirst(),
                receiver,
                eprFhirPatient.getIdentifier().stream().map(ChMed16APatientId::fromFhirIdentifier).filter(Objects::nonNull).toList(),
                medicalData,
                null
        );
    }

    protected static @Nullable String getFirstProfessionalRecipient(final List<Reference> recipients) {
        for (Reference reference : recipients) {
            if (reference != null) {
                final var resource = reference.getResource();
                if (resource != null) {
                    switch(resource) {
                        //we can assume that if we find a practitioner, CH EMED EPR always enforces having a GLN
                        case ChCorePractitioner practitioner: return practitioner.resolveGln();
                        case ChCoreOrganization org: {
                            if (org.hasGln()) return org.resolveGln();
                            break;
                        }
                        default:
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (extensions != null && !extensions.isEmpty()) || (inDepth && (
                (address != null && address.hasExtensions(true)) ||
                (ids != null && ids.stream().anyMatch(t -> t.hasExtensions(true))) ||
                (medicalData != null && medicalData.hasExtensions(true))
                ));
    }

    /**
     * Gets a string to be set at the eMediplan document object level, if the patient is the author, according to the
     * CHMED16A specs.
     *
     * @return The resulting author string.
     */
    public String toAuthorString() {
        final var builder = new StringBuilder("patient ");
        if (firstName != null) builder.append(firstName).append(" ");
        if (lastName != null) builder.append(lastName).append(" ");
        if (birthDate != null) builder.append(birthDate);
        return builder.toString().trim();
    }
}
