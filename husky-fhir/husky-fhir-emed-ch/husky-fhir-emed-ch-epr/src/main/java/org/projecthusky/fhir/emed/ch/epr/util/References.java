package org.projecthusky.fhir.emed.ch.epr.util;

import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;


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
     * Creates reference with {@link Resource} information.
     *
     * @param resource The {@link Resource} resource.
     * @return the reference
     */
    public static Reference createReference(final Resource resource) {
        return new Reference().setReference(resource.getId());
    }
}
