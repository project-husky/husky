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
package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Practitioner;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.core.ch.util.FhirSystem;
import org.projecthusky.fhir.core.ch.util.Identifiers;

import java.util.List;

/**
 * The HAPI custom structure for CH-EMED-EPR Practitioner.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-practitioner")
public class ChEmedEprPractitioner extends Practitioner {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprPractitioner() {
        super();
    }

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
     * @param gln the practitioner's GLN identifier.
     * @return the created Identifier.
     */
    public Identifier setGln(final String gln) {
        var identifier = Identifiers.getBySystem(this.getIdentifier(), FhirSystem.GLN);
        if (identifier == null) {
            identifier = this.addIdentifier();
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
    public HumanName resolveName() {
        if (!this.name.isEmpty()) {
            return this.name.getFirst();
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
    public Address resolveAddress() {
        if (!this.address.isEmpty()) {
            return this.address.getFirst();
        }
        throw new InvalidEmedContentException("The address is missing");
    }

    /**
     * Sets the practitioner's name. If the name already exists, it's replaced.
     *
     * @param humanName the practitioner's name.
     * @return this.
     */
    public ChEmedEprPractitioner setName(final HumanName humanName) {
        if (this.hasName()) this.getName().set(0, humanName);
        else this.addName(humanName);

        return this;
    }

    /**
     * Sets the practitioner's address. If the address already exists, it's replaced.
     *
     * @param address the practitioner's address.
     * @return this.
     */
    public ChEmedEprPractitioner setAddress(final Address address) {
        if (this.hasAddress()) this.getAddress().set(0, address);
        else this.addAddress(address);

        return this;
    }

    @Override
    public ChEmedEprPractitioner copy() {
      final var copy = new ChEmedEprPractitioner();
      this.copyValues(copy);
      return copy;
    }
}
