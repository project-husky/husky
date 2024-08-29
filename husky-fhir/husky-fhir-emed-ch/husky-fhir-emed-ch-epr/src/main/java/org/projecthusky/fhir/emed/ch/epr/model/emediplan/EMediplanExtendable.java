package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Objects;

public interface EMediplanExtendable {
    List<@NonNull EMediplanExtension> getExtensions();

    default void addExtension(final @NonNull EMediplanExtension extension) {
        getExtensions().add(Objects.requireNonNull(extension));
    }

    /**
     * Finds an extension within the embedded list of extensions whose schema and name match the provided ones. If the
     * list of embedded extensions is null or empty, or if no match is found, {@code null} is returned.
     *
     * @param schema     The schema to be matched.
     * @param name       The field name to be matched.
     * @return The matching extension, if any, {@code null} otherwise.
     */
    default @Nullable EMediplanExtension findExtension(final String schema, final String name) {
        return EMediplanExtension.findExtension(getExtensions(), schema, name);
    }
}
