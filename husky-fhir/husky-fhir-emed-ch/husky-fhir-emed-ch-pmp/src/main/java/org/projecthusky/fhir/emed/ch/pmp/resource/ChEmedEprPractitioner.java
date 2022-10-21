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
package org.projecthusky.fhir.emed.ch.pmp.resource;

import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Practitioner;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCoreAddress;
import org.projecthusky.fhir.emed.ch.common.resource.ChCoreHumanName;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.common.util.Identifiers;

import java.util.List;

/**
 * The HAPI custom structure for CH-EMED-EPR Practitioner.
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprPractitioner extends Practitioner {

    /**
     * Resolves the practitioner's GLN identifier. A single identifier is expected.
     *
     * @return the GLN identifier.
     * @throws InvalidEmedContentException if the GLN is missing.
     */
    @ExpectsValidResource
    public String resolveGln() {
        final var identifier = Identifiers.getBySystem(this.getIdentifier(), FhirSystem.GLN);
        if (identifier == null || identifier.getValue() == null) {
            throw new InvalidEmedContentException("The GLN is missing");
        }
        return identifier.getValue();
    }

    /**
     * Sets the practitioner's GLN identifier. If the GLN already exists, it's replaced.
     *
     * @param gln the practitioner's GLN identifier
     * @return the created Identifier.
     */
    public Identifier setGln(final String gln) {
        var identifier = Identifiers.getBySystem(this.getIdentifier(), FhirSystem.GLN);
        if (identifier == null) {
            identifier = new Identifier();
            identifier.setSystem(FhirSystem.GLN);
        }
        identifier.setValue(gln);
        return identifier;
    }

    /**
     * Resolves the practitioner ZSR number(s). Zero or more identifiers are expected; in a prescription, at least one
     * identifier is required.
     *
     * @return a list of ZSR numbers.
     */
    public List<String> resolveZsr() {
        return Identifiers.findBySystem(this.getIdentifier(), FhirSystem.ZSR).stream()
                .map(Identifier::getValue)
                .toList();
    }

    /**
     * Adds a practitioner's ZSR number.
     *
     * @param zsr The ZSR number.
     * @return the created Identifier.
     */
    public Identifier addZsr(final String zsr) {
        final var identifier = this.addIdentifier();
        identifier.setSystem(FhirSystem.ZSR);
        identifier.setValue(zsr);
        return identifier;
    }

    /**
     * Resolves the human name.
     *
     * @return the human name.
     * @throws InvalidEmedContentException if the human name is missing.
     */
    @ExpectsValidResource
    public ChCoreHumanName resolveHumanName() {
        if (!this.name.isEmpty() && this.name.get(0) instanceof final ChCoreHumanName chHumanName) {
            return chHumanName;
        }
        throw new InvalidEmedContentException("The human name is missing");
    }

    /**
     * Resolves the address.
     *
     * @return the address.
     * @throws InvalidEmedContentException if the address is missing.
     */
    @ExpectsValidResource
    public ChCoreAddress resolveAddress() {
        if (!this.address.isEmpty() && this.address.get(0) instanceof final ChCoreAddress chAddress) {
            return chAddress;
        }
        throw new InvalidEmedContentException("The address is missing");
    }

    /*@ExpectsValidResource
    public void resolveGender() {
    }

    public void setGender() {
    }*/
}
