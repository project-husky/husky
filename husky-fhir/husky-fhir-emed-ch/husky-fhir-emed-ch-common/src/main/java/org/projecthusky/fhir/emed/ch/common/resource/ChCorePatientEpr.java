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
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.Patient;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.AdministrativeGender;
import org.projecthusky.fhir.emed.ch.common.enums.ReligiousAffiliation;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * The HAPI custom structure for CH-CORE PatientEPR.
 *
 * @author Quentin Ligier
 **/
public class ChCorePatientEpr extends Patient {
    // TODO add support for extensions

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
     * Resolves patient's gender if possible.
     *
     * @return practitioner's gender.
     * @throws InvalidEmedContentException if the gender is not available.
     */
    @ExpectsValidResource
    public AdministrativeGender resolveGender() throws InvalidEmedContentException {
        if (!this.hasGender()) throw new InvalidEmedContentException("The gender is not available.");

        final var gender = AdministrativeGender.getEnum(this.getGender().toCode());
        if (gender == null) throw new InvalidEmedContentException("The gender is invalid.");

        return gender;
    }

    /**
     * Returns the patient's religion.
     *
     * @return The religion or {@code null}.
     */
    @Nullable
    public ReligiousAffiliation resolveReligion() {
        if (!this.hasReligion()) return null;

        return ReligiousAffiliation.getEnum(this.religion.getCodingFirstRep().getCode());
    }

    /**
     * Sets patient's gender.
     *
     * @param gender Administrative Gender - the gender that the person is considered to have for administration and
     *               record keeping purposes.
     * @return this.
     */
    public ChCorePatientEpr setGender(AdministrativeGender gender) {
        super.setGender(Enumerations.AdministrativeGender.fromCode(gender.getCodeValue()));
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
}
