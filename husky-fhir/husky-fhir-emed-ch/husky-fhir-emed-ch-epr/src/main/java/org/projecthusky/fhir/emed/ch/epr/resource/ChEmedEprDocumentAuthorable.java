package org.projecthusky.fhir.emed.ch.epr.resource;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.util.References;

/**
 * Interface defining common methods for all the resources having an authorDocument element.
 * This interfaces includes some default implementation so that the interface can be used with a composition approach,
 * so that the implementing resource can inherit from the base resource it is extending and yet implement this interface
 * and benefit from the default implementations of most methods.
 * */
public interface ChEmedEprDocumentAuthorable<T> {
    /**
     * Gets the authorDocument element in resource.
     *
     * @return the author document element.
     */
    @Nullable Reference getAuthorDocument();

    /**
     * Sets the authorDocument element in the resource.
     * @param reference The reference to be set as authorDocument.
     * @return this.
     */
    T setAuthorDocument(@Nullable final Reference reference);


    /**
     * Sets the author of the original document.
     * This method creates a reference from the provided resource.
     *
     * @param author the author.
     * @return this.
     */
    default T setAuthorDocument(final IBaseResource author) {
        return setAuthorDocument(new Reference((Resource) author));
    }

    /**
     * Sets the author of the original document.
     * This method creates a reference from the provided Author.
     *
     * @param author the author.
     * @return this.
     */
    default T  setAuthorDocument(final Author author) {
        return setAuthorDocument(References.createAuthorReference(author));
    }

    /**
     * Returns whether the author document exists.
     *
     * @return {@code true} if the author document exists, {@code false} otherwise.
     */
    default boolean hasAuthorDocument() {
        return getAuthorDocument() != null && !getAuthorDocument().isEmpty();
    }

    /**
     * Resolves the last author document resource if available.
     *
     * @return the author document resource or {@code null}.
     * @throws InvalidEmedContentException if the author document resource is invalid.
     */
    @Nullable
    @ExpectsValidResource
    default Author resolveAuthorDocument() throws InvalidEmedContentException {
        final var resource = getAuthorDocument().getResource();
        if (resource == null) return null;

        if (resource instanceof ChCorePatientEpr || resource instanceof ChEmedEprPractitionerRole) {
            final var author = new Author(getAuthorDocument().getResource());
            org.hl7.fhir.r4.model.Extension extension =
                    getAuthorDocument().getExtensionByUrl("http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time");
            if (extension != null) author.setTime(((DateTimeType) extension.getValue()).getValueAsCalendar().toInstant());
            return author;
        }
        throw new InvalidEmedContentException("The last author of the original document is invalid");
    }

    /**
     * Copies the author document resource to another object.
     * @param dst The destination resource.
     */
    default void copyAuthorDocumentValues(Resource dst) {
        if (dst instanceof final ChEmedEprDocumentAuthorable als) {
            als.setAuthorDocument(getAuthorDocument() == null ? null : getAuthorDocument().copy());
        }
    }
}
