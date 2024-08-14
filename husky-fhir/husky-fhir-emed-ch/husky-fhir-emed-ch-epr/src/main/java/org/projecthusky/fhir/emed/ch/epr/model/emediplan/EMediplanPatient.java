package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.PrimitiveType;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class EMediplanPatient {
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
     * Street.
     */
    protected @Nullable String street;
    /**
     * Postcode.
     */
    @JsonProperty("zip")
    protected @Nullable String postalCode;
    /**
     * City.
     */
    protected @Nullable String city;
    /**
     * Country. If the address is in Switzerland, this property does not need to be set, as it is assumed by default
     * that the address is in Switzerland.
     * Format: Alpha-2 code (ISO 3166 5Country Codes), e.g. {@code FR} for France.
     */
    protected @Nullable String country;
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
    //TODO add exts
    //TODO add mData
    /**
     * List of phone numbers.
     */
    protected List<@NonNull String> phones;
    /**
     * List of email addresses.
     */
    protected List<@NonNull String> emails;

    public static EMediplanPatient fromEprFhir(final ChCorePatientEpr eprFhirPatient) {
        String street = null, postalCode = null, city = null, country = null, language = null;
        final var fhirAddress = eprFhirPatient.resolveAddress();
        if (fhirAddress != null) {
            if (fhirAddress.hasLine())
                street = fhirAddress.getLine().stream().map(PrimitiveType::getValue).collect(Collectors.joining("\n"));
            if (fhirAddress.hasPostalCode()) postalCode = fhirAddress.getPostalCode();
            if (fhirAddress.hasCity()) city = fhirAddress.getCity();
            if (fhirAddress.hasCountryElement()) {
                final var countryElement = fhirAddress.getCountryElement();
                final var countryCode = countryElement.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/iso21090-SC-coding");
                if (countryCode != null && countryCode.hasValue() && countryCode.getValue() instanceof Coding countryCoding) {
                    country = countryCoding.getCode();
                }
            }
        }
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
        return new EMediplanPatient(
                eprFhirPatient.getNameFirstRep().getGivenAsSingleString(),
                eprFhirPatient.getNameFirstRep().getFamily(),
                eprFhirPatient.resolveBirthDate(),
                Gender.fromFhirAdministrativeGender(eprFhirPatient.resolveGender()),
                street,
                postalCode,
                city,
                country,
                language,
                eprFhirPatient.getIdentifier().stream().map(EMediplanPatientId::fromFhirIdentifier).toList(),
                eprFhirPatient.resolvePhoneNumbersAsStrings(true),
                eprFhirPatient.resolveEmailAddressesAsStrings(true)
        );
    }
}
