package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanExtendable;

/**
 * Interface for objects that contain extensions. The extension property itself is to be defined by the implementing
 * object, so that the JSON field name can be customized in principle. This interface provides convenience methods for
 * extensions with a default implementation.
 * @see ChMed16AExtension
 */
public interface ChMed16AExtendable extends EMediplanExtendable<ChMed16AExtension> {

    /**
     * Finds an extension within the embedded list of extensions whose schema and name match the provided ones. If the
     * list of embedded extensions is null or empty, or if no match is found, {@code null} is returned.
     *
     * @param name       The field name to be matched.
     * @return The matching extension, if any, {@code null} otherwise.
     */
    default @Nullable ChMed16AExtension findExtension(final String schema, final String name) {
        return ChMed16AExtension.findExtension(getExtensions(), name);
    }

    @JsonIgnore
    @Override
    default String getExtensionsFieldName() {
        return ChMed16AExtension.EXTENSIONS_FIELD_NAME;
    }
}
