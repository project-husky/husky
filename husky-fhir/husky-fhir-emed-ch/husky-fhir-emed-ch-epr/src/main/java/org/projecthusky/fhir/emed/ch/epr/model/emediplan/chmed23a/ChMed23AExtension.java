package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Extensions can be used to include additional information within an eMediplan that is not explicitly modelled by the
 * ChMed specification.
 */
@Data
@AllArgsConstructor
public class ChMed23AExtension implements ChMed23AExtendable, EMediplanObject {
    public static final String EXTENSIONS_FIELD_NAME = "exts";

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
    @JsonProperty(EXTENSIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed23AExtension> extensions;

    public List<@NonNull ChMed23AExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    public ValidationResult validate(final @Nullable String basePath) {
        final var result = validateExtensions(basePath);

        if (name == null || name.isBlank()) result.add(getRequiredFieldValidationIssue(
                 getFieldValidationPath(basePath, "nm"),
                "The extension name is required but it is missing"
        ));

        if (schema == null || schema.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "schema"),
                "The extension schema is required but it is missing"
        ));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return extensions != null && !extensions.isEmpty();
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
    public static @Nullable ChMed23AExtension findExtension(final @Nullable List<@NonNull ChMed23AExtension> extensions,
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
