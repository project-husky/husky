package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Extensions can be used to include additional information within an eMediplan that is not explicitly modelled by the
 * ChMed specification.
 */
@Data
@AllArgsConstructor
public class EMediplanExtension implements EMediplanExtendable {
    /**
     * Name of the field. Mandatory.
     */
    @JsonProperty("nm")
    protected String name;
    /**
     * The value of the field. Optional.
     */
    @JsonProperty("val")
    protected @Nullable String value;
    /**
     * The Schema. It can be any string and can be used to determine how to interpret the extension. It is mandatory.
     */
    protected String schema;
    /**
     * The list of nested extensions. Optional if empty.
     */
    @JsonProperty("exts")
    protected @Nullable List<@NonNull EMediplanExtension> extensions;

    public List<@NonNull EMediplanExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    /**
     * Finds an extension within the provided list of extensions whose schema and name match the provided ones. If the
     * list of extensions is null or empty, or if no match is found, {@code null} is returned.
     *
     * @param extensions The list of extensions within to perform the search.
     * @param schema     The schema to be matched.
     * @param name       The field name to be matched.
     * @return The matching extension, if any, {@code null} otherwise.
     */
    @ExpectsValidResource
    public static @Nullable EMediplanExtension findExtension(final @Nullable List<@NonNull EMediplanExtension> extensions,
                                                             final String schema,
                                                             final String name) {
        if (extensions != null && !extensions.isEmpty()) {
            for (final var extension : extensions) {
                if (extension.getSchema().equals(schema) && extension.getName().equals(name)) return extension;
            }
        }
        return null;
    }
}
