/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.core.ch.resource.r4;

import java.io.Serial;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.datatype.r4.CHCoreAddressECH11PlaceOfOrigin;
import org.projecthusky.fhir.core.ch.datatype.r4.CHCoreAddressEch11PlaceOfBirth;
import org.projecthusky.fhir.core.ch.enums.ReligiousAffiliation;
import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreCitizenshipExt;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.core.ch.util.FhirDateTimes;

/**
 * The HAPI custom structure for CH-Core patient.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient")
public class ChCorePatient extends Patient {

	@Serial
	private static final long serialVersionUID = -5096298481688744771L;

	public static final String LOCAL_PID_TYPE_SYSTEM = "http://terminology.hl7.org/CodeSystem/v2-0203";
	public static final String LOCAL_PID_TYPE_VALUE = "MR";

	/**
	 * Extension for a placeOfBirth.
	 */
	@Nullable
	@Child(name = "placeOfBirth", min = 0, max = 1)
	@Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-birthPlace", definedLocally = false)
	protected CHCoreAddressEch11PlaceOfBirth placeOfBirth;

	/**
	 * Extension for a placeOfOrigin.
	 */
	@Nullable
	@Child(name = "placeOfOrigin", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient-ech-11-placeoforigin", definedLocally = false)
	protected List<CHCoreAddressECH11PlaceOfOrigin> placeOfOrigin;

	/**
	 * Extension for a citizenship.
	 */
	@Nullable
	@Child(name = "citizenship", min = 0, max = 1)
	@Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-citizenship", definedLocally = false)
	protected List<ChCoreCitizenshipExt> citizenship;

	/**
	 * Extension for a religion.
	 */
	@Nullable
	@Child(name = "religion", min = 0, max = 1)
	@Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-religion", definedLocally = false)
	protected CodeableConcept religion;

	public @Nullable CHCoreAddressEch11PlaceOfBirth getPlaceOfBirth() {
		return placeOfBirth;
	}

	public ChCorePatient setPlaceOfBirth(CHCoreAddressEch11PlaceOfBirth placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
		return this;
	}

	public List<CHCoreAddressECH11PlaceOfOrigin> getPlaceOfOrigin() {
		if (placeOfOrigin == null) placeOfOrigin = new ArrayList<>();
		return placeOfOrigin;
	}

	public ChCorePatient setPlaceOfOrigin(List<CHCoreAddressECH11PlaceOfOrigin> placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
		return this;
	}

	public List<ChCoreCitizenshipExt> getCitizenship() {
		if (citizenship == null) citizenship = new ArrayList<>();
		return citizenship;
	}

	public ChCorePatient setCitizenship(List<ChCoreCitizenshipExt> citizenship) {
		this.citizenship = citizenship;
		return this;
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

	public @Nullable CodeableConcept getReligion() {
		return religion;
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
	 * Sets patient's religion.
	 *
	 * @param religion
	 *            Religious Affiliation - the patient's religion.
	 * @return this.
	 */
	public ChCorePatient setReligion(final ReligiousAffiliation religion) {
		final var system = UriType.fromOid(religion.getCodeSystemId());

		final var coding = new Coding().setCode(religion.getCodeValue()).setSystemElement(system)
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
	 * Resolves the human name.
	 *
	 * @return the human name.
	 * @throws InvalidContentException if the human name is missing.
	 */
	@ExpectsValidResource
	public HumanName resolveName() throws InvalidContentException {
		if (this.hasName()) {
			return this.name.getFirst();
		}
		throw new InvalidContentException("The human name is missing");
	}
	/**
	 * Resolves patient's gender if possible.
	 *
	 * @return practitioner's gender.
	 * @throws InvalidContentException if the gender is not available.
	 */
	@ExpectsValidResource
	public Enumerations.AdministrativeGender resolveGender() throws InvalidContentException {
		if (!this.hasGender()) throw new InvalidContentException("The gender is not available.");
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
	public List<Identifier> getLocalIds() {
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
	 * @throws InvalidContentException if the patient's birthdate is missing.
	 */
	@ExpectsValidResource
	public LocalDate resolveBirthDate() throws InvalidContentException {
		if (!this.hasBirthDate()) throw new InvalidContentException("The birthdate is missing.");
		return LocalDate.ofInstant(this.getBirthDate().toInstant(), ZoneId.systemDefault());
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
	 * Resolves the address.
	 *
	 * @return the address or {@code null}.
	 */
	@Nullable
	@ExpectsValidResource
	public Address resolveAddress() {
		if (this.hasAddress()) {
			return this.address.getFirst();
		}
		return null;
	}

	@Override
	public ChCorePatient copy() {
		final var copy = new ChCorePatient();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(final Patient dst) {
		super.copyValues(dst);
		if (dst instanceof final ChCorePatient als) {
			als.placeOfBirth = placeOfBirth == null ? null : placeOfBirth.copy();
			als.placeOfOrigin = new ArrayList<>();
			if (placeOfOrigin != null)
				placeOfOrigin.forEach(origin -> als.placeOfOrigin.add(origin.copy()));
			als.citizenship = new ArrayList<>();
			if (citizenship != null)
				citizenship.forEach(citizenship -> als.citizenship.add(citizenship.copy()));
			als.religion = religion == null ? null : religion.copy();
		}
	}
}
