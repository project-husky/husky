package org.projecthusky.fhir.emed.ch.epr.util;

import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprEntry;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;

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
     * Creates reference with {@link ChEmedEprPractitionerRole} information.
     *
     * @param resource The {@link ChEmedEprPractitionerRole} resource.
     * @return the reference
     */
    public static Reference createReference(final ChEmedEprPractitionerRole resource) {
        return new Reference().setReference(resource.getIdentifierFirstRep().getValue());
    }

    /**
     * Creates reference with {@link ChCorePatientEpr} information.
     *
     * @param resource The {@link ChCorePatientEpr} resource.
     * @return the reference
     */
    public static Reference createReference(final ChCorePatientEpr resource) {
        return new Reference().setReference(resource.getIdentifierFirstRep().getValue());
    }

    /**
     * Creates reference with {@link Device} information.
     *
     * @param resource The {@link Device} resource.
     * @return the reference
     */
    public static Reference createReference(final Device resource) {
        return new Reference().setReference(resource.getIdentifierFirstRep().getValue());
    }

    /**
     * Creates reference with {@link ChEmedEprMedication} information.
     *
     * @param resource The {@link ChEmedEprMedication} resource.
     * @return the reference
     */
    public static Reference createReference(final ChEmedEprMedication resource) {
        return new Reference().setReference(resource.getIdentifierFirstRep().getValue());
    }

    /**
     * Creates reference with {@link ChEmedEprEntry} information.
     *
     * @param resource The {@link ChEmedEprEntry} resource.
     * @return the reference
     */
    public static Reference createReference(final ChEmedEprEntry resource) {
        return new Reference().setReference(Uuids.URN_PREFIX + resource.resolveIdentifier());
    }
}