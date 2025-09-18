package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanExtendable;

import java.util.List;
import java.util.Objects;

/**
 * Interface for objects that contain extensions. The extension property itself is to be defined by the implementing
 * object, so that the JSON field name can be customized in principle. This interface provides convenience methods for
 * extensions with a default implementation.
 * @see ChMed23AExtension
 */
public interface ChMed23AExtendable extends EMediplanExtendable<ChMed23AExtension> {
    /**
     * Finds an extension within the embedded list of extensions whose schema and name match the provided ones. If the
     * list of embedded extensions is null or empty, or if no match is found, {@code null} is returned.
     *
     * @param schema     The schema to be matched.
     * @param name       The field name to be matched.
     * @return The matching extension, if any, {@code null} otherwise.
     */
    default @Nullable ChMed23AExtension findExtension(final String schema, final String name) {
        return ChMed23AExtension.findExtension(getExtensions(), schema, name);
    }

    @Override
    default String getExtensionsFieldName() {
        return ChMed23AExtension.EXTENSIONS_FIELD_NAME;
    }
}
