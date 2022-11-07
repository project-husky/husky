package org.projecthusky.fhir.emed.ch.epr.util;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprMedicationStatementMtp;

import java.util.List;

/**
 * Reference Utilities
 *
 * @author Ronaldo Loureiro
 */
public class References {

    /**
     * This class is not instantiable.
     */
    private References() {
    }

    /**
     * Resolves the first resource with the reference.
     *
     * @param reference the reference
     * @param contained the list of resource
     * @return the first resource with the reference or {@code null}.
     */
    @Nullable
    public static Resource resolveReference(String reference, List<Resource> contained) {
        return contained.stream()
                .filter(resource -> resource.getId().equals(reference))
                .findFirst()
                .orElse(null);
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
        final var reference = new Reference().setReference(resource.getIdentifierFirstRep().getValue());
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

    public static Reference createReference(final ChEmedEprMedication resource) {
        final var reference = new Reference().setReference(resource.getIdentifierFirstRep().getValue());
        reference.setResource(resource);
        return reference;
    }

    public static Reference createReference(final ChEmedEprMedicationStatementMtp resource) {
        final var reference = new Reference().setReference(resource.getIdentifierFirstRep().getValue());
        reference.setResource(resource);
        return reference;
    }
}
