package org.projecthusky.fhir.emed.ch.common.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.ReligiousAffiliation;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.extension.PatientCitizenship;
import org.projecthusky.fhir.emed.ch.common.util.FhirDateTimes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient")
public class ChCorePatient extends Patient{

    public static final String LOCAL_PID_TYPE_SYSTEM = "http://terminology.hl7.org/CodeSystem/v2-0203";
    public static final String LOCAL_PID_TYPE_VALUE = "MR";
    public static final String PLACE_OF_BIRTH_URL = "http://hl7.org/fhir/StructureDefinition/patient-birthPlace";
    public static final String PLACE_OF_ORIGIN_URL =
            "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-address-ech-11-placeoforigin";
    public static final String RELIGION_URL = "http://hl7.org/fhir/StructureDefinition/patient-religion";

    @Nullable
    @Child(name = "placeOfBirth")
    @Extension(url = PLACE_OF_BIRTH_URL, definedLocally = false)
    @Getter @Setter
    protected Address placeOfBirth;

    @Nullable
    @Child(name = "placeOfOrigin")
    @Extension(url = PLACE_OF_ORIGIN_URL, definedLocally = false)
    @Setter
    protected List<Address> placeOfOrigin;

    @Nullable
    @Child(name = "citizenship")
    @Extension(url = PatientCitizenship.URL, definedLocally = false)
    @Setter
    protected List<PatientCitizenship> citizenship;

    @Nullable
    @Child(name = "religion")
    @Extension(url = RELIGION_URL, definedLocally = false)
    @Getter
    protected CodeableConcept religion;

    /**
     * Empty constructor for the parser.
     */
    public ChCorePatient() {
        super();
    }

    /**
     * Resolves the human name.
     *
     * @return the human name.
     * @throws InvalidEmedContentException if the human name is missing.
     */
    @ExpectsValidResource
    public HumanName resolveName() {
        if (this.hasName()) {
            return this.name.get(0);
        }
        throw new InvalidEmedContentException("The human name is missing");
    }

    /**
     * Resolves the address.
     *
     * @return the address or {@code null}.
     */
    @Nullable
    @ExpectsValidResource
    public Address resolveAddress() {
        if (this.hasAddress()) {
            return this.address.get(0);
        }
        return null;
    }

    /**
     * Resolves patient's gender if possible.
     *
     * @return practitioner's gender.
     * @throws InvalidEmedContentException if the gender is not available.
     */
    @ExpectsValidResource
    public Enumerations.AdministrativeGender resolveGender() throws InvalidEmedContentException {
        if (!this.hasGender()) throw new InvalidEmedContentException("The gender is not available.");
        return this.getGender();
    }

    /**
     * Resolves the patient's religion.
     *
     * @return The religion or {@code null}.
     */
    @Nullable
    public ReligiousAffiliation resolveReligion() {
        if (!this.hasReligion()) return null;
        return ReligiousAffiliation.getEnum(this.religion.getCodingFirstRep().getCode());
    }

    /**
     * Resolves the first local patient identifier or throws.
     *
     * @return the first local patient identifier.
     */
    public List<Identifier> getLocalIds() throws InvalidEmedContentException {
        return this.getIdentifier().stream()
                .filter(identifier -> identifier.getType() != null && !identifier.getType().getCoding().isEmpty())
                .filter(identifier -> !identifier.getType().getCodingFirstRep().getSystem().equals(LOCAL_PID_TYPE_SYSTEM))
                .filter(identifier -> !identifier.getType().getCodingFirstRep().getCode().equals(LOCAL_PID_TYPE_VALUE))
                .toList();
    }

    /**
     * Resolves the patient's birthdate or throws.
     *
     * @return the patient's birthdate.
     * @throws InvalidEmedContentException if the patient's birthdate is missing.
     */
    @ExpectsValidResource
    public LocalDate resolveBirthDate() throws InvalidEmedContentException {
        if (!this.hasBirthDate()) throw new InvalidEmedContentException("The birthdate is missing.");
        return LocalDate.ofInstant(this.getBirthDate().toInstant(), ZoneId.systemDefault());
    }

    /**
     * Sets patient's religion.
     *
     * @param religion Religious Affiliation - the patient's religion.
     * @return this.
     */
    public ChCorePatient setReligion(final ReligiousAffiliation religion) {
        final var system = UriType.fromOid(religion.getCodeSystemId());

        final var coding = new Coding()
                .setCode(religion.getCodeValue())
                .setSystemElement(system)
                .setDisplay(religion.getDisplayName());

        this.religion = new CodeableConcept(coding);
        return this;
    }

    /**
     * Sets the patient's birthdate.
     *
     * @param birthDate the patient's birthdate.
     * @return this.
     */
    public ChCorePatient setBirthDate(final LocalDate birthDate) {
        final var date = Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        super.setBirthDate(date);
        return this;
    }

    /**
     * Returns whether religion code exists.
     *
     * @return {@code true} if the religion code exists, {@code false} otherwise.
     */
    public boolean hasReligion() {
        return this.religion != null && !this.religion.isEmpty();
    }

    /**
     * Returns whether religion code exists.
     *
     * @return {@code true} if the religion code exists, {@code false} otherwise.
     */
    public boolean hasPlaceOfBirth() {
        return this.placeOfBirth != null && !this.placeOfBirth.isEmpty();
    }

    /**
     * Returns the place of origin of the patient is specified.
     *
     * @return {@code true} if the religion code exists, {@code false} otherwise.
     */
    public boolean hasPlaceOfOrigin() {
        return this.placeOfOrigin != null && !this.placeOfOrigin.isEmpty();
    }

    /**
     * Returns whether the citizenship of the patient is specified.
     *
     * @return {@code true} if the religion code exists, {@code false} otherwise.
     */
    public boolean hasCitizenship() {
        return this.citizenship != null && !this.citizenship.isEmpty();
    }

    /**
     * Adds a new local patient identifier.
     *
     * @param system The namespace for the identifier value.
     * @param value  The value that is unique.
     * @return the created identifier.
     */
    public Identifier addIdentifier(final String system,
                                    final String value) {
        final var codingType = new Coding()
                .setSystem(LOCAL_PID_TYPE_SYSTEM)
                .setCode(LOCAL_PID_TYPE_VALUE);
        return this.addIdentifier().setType(new CodeableConcept(codingType))
                .setSystem(system)
                .setValue(value);
    }

    /**
     * Resolves the language of correspondence (i.e. preferred communication language) of the patient.
     * @return the preferred patient component with the language of correspondence.
     */
    public @Nullable PatientCommunicationComponent resolveLanguageOfCorrespondence() {
        return getCommunication().stream().filter( com -> com != null && com.getPreferred()).findAny().orElse(null);
    }

    /**
     * Fetches the list of contact points which are an email address.
     * @return The list of contact points.
     */
    public List<@NonNull ContactPoint> resolveEmailAddresses() {
        return resolveTelecom(ContactPoint.ContactPointSystem.EMAIL);
    }

    /**
     * Fetches the list of email addresses values. It does not check their period.
     * @return The list of email addresses values.
     */
    public List<@NonNull String> resolveEmailAddressesAsStrings() {
        return resolveEmailAddressesAsStrings(false);
    }

    /**
     * Fetches the list of email address values, optionally checking if the period is valid at the moment.
     * @param activeOnly If true, the method will filter out email address for which the current timestamp is not within
     *                   the period boundaries, if defined.
     * @return The list of matching email addresses, as strings.
     */
    public List<@NonNull String> resolveEmailAddressesAsStrings(boolean activeOnly) {
        return resolveTelecomAsStrings(ContactPoint.ContactPointSystem.EMAIL, activeOnly);
    }

    /**
     * Fetches the list of contact points which are a phone number.
     * @return The list of contact points.
     */
    public List<@NonNull ContactPoint> resolvePhoneNumbers() {
        return resolveTelecom(ContactPoint.ContactPointSystem.PHONE);
    }

    /**
     * Fetches the list of phone number values. It does not check their period.
     * @return The list of phone number values as strings.
     */
    public List<@NonNull String> resolvePhoneNumbersAsStrings() {
        return resolvePhoneNumbersAsStrings(false);
    }

    /**
     * Fetches the list of email address values, optionally checking if the period is valid at the moment.
     * @param activeOnly If true, the method will filter out phone numbers for which the current timestamp is not within
     *                   the period boundaries, if defined.
     * @return The list of matching email addresses, as strings.
     */
    public List<@NonNull String> resolvePhoneNumbersAsStrings(boolean activeOnly) {
        return resolveTelecomAsStrings(ContactPoint.ContactPointSystem.PHONE, activeOnly);
    }

    /**
     * Fetches the list of telecom contact point values for the specified system and optionally checking whether they
     * are valid at the current time.
     *
     * @param system     The contact point system that must match.
     * @param activeOnly Whether to return only contact points for which the current timestamp is within the specified
     *                   boundaries (if any).
     * @return The list of strings with the matching contact points values.
     */
    private List<@NonNull String> resolveTelecomAsStrings(final ContactPoint.ContactPointSystem system,
                                                          boolean activeOnly) {
        return resolveTelecom(system).stream().filter(telecom -> {
            if (telecom.hasValue()) {
                if (activeOnly) {
                    if (telecom.hasPeriod() && (telecom.getPeriod().hasStart() || telecom.getPeriod().hasEnd())) {
                        if (telecom.getPeriod().hasStart() && telecom.getPeriod().getStartElement().getValueAsCalendar().after(Calendar.getInstance()))
                            return false;
                        if (telecom.getPeriod().hasEnd() && FhirDateTimes.completeToLatestInstant(telecom.getPeriod().getEndElement()).isBefore(Instant.now()))
                            return false;
                    } else return true;
                } else return true;
            }
            return false;
        }).map(ContactPoint::getValue).toList();
    }

    /**
     * Gets the list of telecom contact points that match the specified system.
     * @param system The specific system for which to fetch all the contact points.
     * @return The list of contact points.
     */
    private List<@NonNull ContactPoint> resolveTelecom(final ContactPoint.ContactPointSystem system) {
        return getTelecom().stream().filter(telecom -> telecom.getSystem() == system).toList();
    }

    /**
     * Gets the list of places of origin for the patient. The list can be empty.
     * @return The list of places of origin.
     */
    public List<@NonNull Address> getPlaceOfOrigin() {
        if (placeOfOrigin == null) placeOfOrigin = new ArrayList<>();
        return placeOfOrigin;
    }

    /**
     * Gets the list of citizenships for the patient. The list can be empty.
     * @return The list of citizenships.
     */
    public List<@NonNull PatientCitizenship> getCitizenship() {
        if (citizenship == null) citizenship = new ArrayList<>();
        return citizenship;
    }

    @Override
    public ChCorePatientEpr copy() {
        final var copy = new ChCorePatientEpr();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public void copyValues(final Patient dst) {
        super.copyValues(dst);
        if (dst instanceof final ChCorePatientEpr als) {
            als.placeOfBirth = placeOfBirth == null ? null : placeOfBirth.copy();
            als.placeOfOrigin = new ArrayList<>();
            if (placeOfOrigin != null)
                placeOfOrigin.forEach(origin -> als.placeOfOrigin.add(origin.copy()));
            als.placeOfOrigin = new ArrayList<>();
            if (citizenship != null)
                citizenship.forEach(citizenship -> als.citizenship.add(citizenship.copy()));
            als.religion = religion == null ? null : religion.copy();
        }
    }
}
