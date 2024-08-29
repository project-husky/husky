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
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class EMediplanPatient implements EMediplanExtendable {
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
    @JsonProperty("mData")
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
                    .map(Coding::getCode).map(code -> {
                        if (code.length() == 2)
                            return code;
                        if (code.length() == 5 && code.toUpperCase().endsWith("-CH"))
                            return code.substring(0, code.length() - 3);
                        return null;
                    }).filter(Objects::nonNull).findAny().orElseGet(() -> {
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
}
