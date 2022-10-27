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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.common.util.Identifiers;

/**
 * The HAPI custom structure for CH-EMED Organization.
 *
 * @author Quentin Ligier
 **/
public class ChEmedOrganization extends Organization {
    // TODO create methods {resolveX, hasX, setX} for ber, uidb, zsr, gln (strings, nullable); address (CHCoreAddress)

    /**
     * Constructor
     */
    public ChEmedOrganization() {
        super();
    }

    /**
     * Resolves the organization's BER identifier.
     *
     * @return the BER identifier or {@code null}.
     */
    @Nullable
    public String resolveBer() {
        return Identifiers.getValueBySystem(this.getIdentifier(), FhirSystem.BER);
    }

    /**
     * Resolves the organization's UIDB identifier.
     *
     * @return the UIDB identifier or {@code null}.
     */
    @Nullable
    public String resolveUidb() {
        return Identifiers.getValueBySystem(this.getIdentifier(), FhirSystem.UIDB);
    }

    /**
     * Resolves the organization's ZSR identifier.
     *
     * @return the ZSR identifier or {@code null}.
     */
    @Nullable
    public String resolveZsr() {
        return Identifiers.getValueBySystem(this.getIdentifier(), FhirSystem.ZSR);
    }

    /**
     * Resolves the organization's GLN identifier.
     *
     * @return the GLN identifier or {@code null}.
     */
    @Nullable
    public String resolveGln() {
        return Identifiers.getValueBySystem(this.getIdentifier(), FhirSystem.GLN);
    }

    /**
     * Returns whether BER code exists.
     *
     * @return {@code true} if the BER code exists, {@code false} otherwise.
     */
    public boolean hasBer() {
        return this.resolveBer() != null;
    }

    /**
     * Returns whether UIDB code exists.
     *
     * @return {@code true} if the UIDB code exists, {@code false} otherwise.
     */
    public boolean hasUidb() {
        return this.resolveUidb() != null;
    }

    /**
     * Returns whether ZSR code exists.
     *
     * @return {@code true} if the ZSR code exists, {@code false} otherwise.
     */
    public boolean hasZsr() {
        return this.resolveZsr() != null;
    }

    /**
     * Returns whether GLN code exists.
     *
     * @return {@code true} if the GLN code exists, {@code false} otherwise.
     */
    public boolean hasGln() {
        return this.resolveGln() != null;
    }

    /**
     * Sets the organization's BER identifier. If the BER already exists, it's replaced.
     *
     * @param ber the organization's BER identifier.
     * @return the created/modified Identifier
     */
    public Identifier setBer(final String ber) {
        return Identifiers.setValueBySystem(this.getIdentifier(), FhirSystem.BER, ber);
    }

    /**
     * Sets the organization's UIDB identifier. If the UIDB already exists, it's replaced.
     *
     * @param uidb the organization's UIDB identifier.
     * @return the created/modified Identifier
     */
    public Identifier setUidb(final String uidb) {
        return Identifiers.setValueBySystem(this.getIdentifier(), FhirSystem.UIDB, uidb);
    }

    /**
     * Sets the organization's ZSR identifier. If the ZSR already exists, it's replaced.
     *
     * @param zsr the organization's ZSR identifier.
     * @return the created/modified Identifier
     */
    public Identifier setZsr(final String zsr) {
        return Identifiers.setValueBySystem(this.getIdentifier(), FhirSystem.ZSR, zsr);
    }

    /**
     * Sets the organization's GLN identifier. If the GLN already exists, it's replaced.
     *
     * @param gln the organization's GLN identifier.
     * @return the created/modified Identifier.
     */
    public Identifier setGln(final String gln) {
       return Identifiers.setValueBySystem(this.getIdentifier(), FhirSystem.GLN, gln);
    }

}
