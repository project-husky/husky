package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Extensions can be used to include additional information within an eMediplan that is not explicitly modelled by the
 * ChMed specification.
 */
@Data
@AllArgsConstructor
public class ChMed16AExtension implements ChMed16AExtendable {
    protected static final String NAME_FIELD_NAME = "Nm";
    public static final String EXTENSIONS_FIELD_NAME = "PFields";
    /**
     * Name of the field. Mandatory.
     */
    @JsonProperty(NAME_FIELD_NAME)
    protected String name;
    /**
     * The value of the field. Optional.
     */
    @JsonProperty("Val")
    protected @Nullable String value;
    /**
     * The list of nested extensions. Optional if empty.
     */
    @JsonProperty(EXTENSIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed16AExtension> extensions;

    public List<@NonNull ChMed16AExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    public ValidationResult validate(final @Nullable String basePath) {
        final var result = validateExtensions(basePath);

        if (name == null || name.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, NAME_FIELD_NAME),
                "The extension name is required but it is missing"
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
     * @param name       The field name to be matched.
     * @return The matching extension, if any, {@code null} otherwise.
     */
    @ExpectsValidResource
    public static @Nullable ChMed16AExtension findExtension(final @Nullable List<@NonNull ChMed16AExtension> extensions,
                                                            final String name) {
        if (extensions != null && !extensions.isEmpty()) {
            for (final var extension : extensions) {
                if (extension.getName().equals(name)) return extension;
            }
        }
        return null;
    }
}
