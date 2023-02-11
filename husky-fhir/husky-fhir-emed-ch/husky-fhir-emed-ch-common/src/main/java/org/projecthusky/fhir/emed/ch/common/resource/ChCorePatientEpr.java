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
package org.projecthusky.fhir.emed.ch.common.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.ReligiousAffiliation;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * The HAPI custom structure for CH-CORE PatientEPR.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient-epr")
public class ChCorePatientEpr extends Patient {

    public static final String LOCAL_PID_TYPE_SYSTEM = "http://terminology.hl7.org/CodeSystem/v2-0203";
    public static final String LOCAL_PID_TYPE_VALUE = "MR";

    // TODO add support for extensions

    // TODO placeOfBirth

    // TODO placeOfOrigin

    // TODO citizenship

    @Nullable
    @Child(name = "religion")
    @Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-religion", definedLocally = false)
    protected CodeableConcept religion;

    /**
     * Empty constructor for the parser.
     */
    public ChCorePatientEpr() {
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
    public ChCorePatientEpr setReligion(final ReligiousAffiliation religion) {
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
    public ChCorePatientEpr setBirthDate(final LocalDate birthDate) {
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
}
