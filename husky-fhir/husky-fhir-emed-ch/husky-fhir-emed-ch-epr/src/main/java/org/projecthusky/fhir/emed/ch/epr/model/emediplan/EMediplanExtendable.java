package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.List;
import java.util.Objects;

/**
 * Base interface for an eMediplan object that is extendable, that is, that may contain a list of extensions.
 * @param <E> The type of the extension object.
 */
public interface EMediplanExtendable<E extends EMediplanObject> extends EMediplanObject {
    /**
     * Gets the list of this object's extensions.
     * @return The list of extensions.
     */
    List<@NonNull E> getExtensions();

    /**
     *
     * @return The field name of the extensions.
     */
    @JsonIgnore
    String getExtensionsFieldName();

    /**
     * Adds an extension to the list of this object's extensions.
     * @param extension The extension to be added.
     */
    default void addExtension(final @NonNull E extension) {
        getExtensions().add(Objects.requireNonNull(extension));
    }

    @Override
    default void trim() {
        getExtensions().forEach(EMediplanObject::trim);
    }

    /**
     * Validates the object extensions.
     * @param basePath The base path of this object for the validation feedback.
     * @return The validation result.
     */
    default ValidationResult validateExtensions(final @Nullable String basePath) {
        final ValidationResult result = new ValidationResult();
        final var extensionsIterator = getExtensions().listIterator();
        while (extensionsIterator.hasNext()) {
            final var index = extensionsIterator.nextIndex();
            result.add(extensionsIterator.next().validate(getFieldValidationPath(basePath, getExtensionsFieldName(), index)));
        }
        return result;
    }
}
