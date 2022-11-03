package org.projecthusky.fhir.emed.ch.epr.util;

import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;

/**
 * Reference Utilities
 *
 * @author Ronaldo Loureiro
 * // TODO reference.setResource ?
 */
public class References {

    /**
     * This class is not instantiable.
     */
    private References() {
    }

    /**
     * Creates reference with {@link ChEmedEprPractitionerRole} information.
     *
     * @param resource The {@link ChEmedEprPractitionerRole} resource.
     * @return the reference
     */
    public static Reference createReference(final ChEmedEprPractitionerRole resource) {
        final var reference = new Reference().setReference(resource.getIdentifierFirstRep().getValue());
        reference.setResource(resource);
        return reference;
    }

    /**
     * Creates reference with {@link ChCorePatientEpr} information.
     *
     * @param resource The {@link ChCorePatientEpr} resource.
     * @return the reference
     */
    public static Reference createReference(final ChCorePatientEpr resource) {
        final var reference = new Reference().setReference(resource.resolveIdentifier().getValue());
        reference.setResource(resource);
        return reference;
    }

    /**
     * Creates reference with {@link Device} information.
     *
     * @param resource The {@link Device} resource.
     * @return the reference
     */
    public static Reference createReference(final Device resource) {
        final var reference = new Reference().setReference(resource.getIdentifierFirstRep().getValue());
        reference.setResource(resource);
        return reference;
    }
}
