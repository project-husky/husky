package org.projecthusky.fhir.emed.ch.epr.util;

import org.hl7.fhir.instance.model.api.IAnyResource;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;

import java.util.Date;


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
     * @deprecated Use {@link Reference#Reference(IAnyResource)} directly instead.
     */
    @Deprecated(forRemoval = true, since = "2024-04-19")
    public static Reference createReference(final Resource resource) {
        final var reference = new Reference();
        reference.setResource(resource);
        return reference;
    }

    /**
     * Creates a reference to an author, including the time extension if needed.
     * @param author The author to be referenced.
     * @return The created reference to the author.
     */
    public static Reference createAuthorReference(final Author author) {
        final var reference = new Reference((IAnyResource) author.getFirstNonNull());
        if (author.getTime() != null)
            reference.addExtension("http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time", new DateTimeType(Date.from(author.getTime())));
        return reference;
    }
}
