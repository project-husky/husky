/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.narrative.generators;

import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.emed.ch.cda.narrative.enums.NarrativeLanguage;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.treatment.MedicationPackagedProduct;
import org.husky.emed.ch.models.treatment.MedicationProduct;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Optional;
import java.util.PropertyResourceBundle;

/**
 * Abstract base for narrative generators.
 *
 * @author Quentin Ligier
 */
public abstract class AbstractNarrativeGenerator {

    /**
     * The language of the narrative to be generated.
     */
    protected final NarrativeLanguage lang;

    /**
     * The resource bundle that contains the translations.
     */
    protected final PropertyResourceBundle bundle = null;

    protected AbstractNarrativeGenerator(final NarrativeLanguage lang) {
        this.lang = Objects.requireNonNull(lang);
    }

    /**
     * Formats a temporal object to the given format, respecting the generation locale.
     *
     * @param temporal The temporal object to format.
     * @param pattern The format, as described in the {@link DateTimeFormatter} class.
     * @throws DateTimeException if an error occurs during formatting.
     */
    protected String formatTemporal(final TemporalAccessor temporal,
                                    final String pattern) throws DateTimeException {
        return DateTimeFormatter.ofPattern(pattern, this.lang.getLocale())
                .format(temporal);
    }

    /**
     * Gets a translated message for the given key.
     *
     * @param key The key.
     * @return The translated message.
     * @throws MissingResourceException if no object for the given key can be found.
     * @throws ClassCastException       if the object found for the given key is not a string.
     */
    protected String getMessage(final String key) {
        return this.bundle.getString(key);
    }

    /**
     * Gets the translation of a value set enum element.
     *
     * @param valueSet The value set enum element.
     * @return The display name in the right language.
     */
    protected String getEnumNarrative(final ValueSetEnumInterface valueSet) {
        return valueSet.getDisplayName(this.lang.getLanguageCode());
    }

    /**
     * Gets the name of a medication product in HTML or StrucDocText.
     *
     * @param product The medication product.
     * @param isHtml  Whether it should be in HTML ({@code true}) or in StrucDocText ({@code false}).
     * @return The medication product name.
     */
    protected String formatMedicationName(final MedicationProduct product,
                                          final boolean isHtml) {
        final var name = Optional.ofNullable(product.getName()).orElse(
                Optional.ofNullable(product.getPackagedProduct()).map(MedicationPackagedProduct::getName).orElse(null)
        );
        final var gtin = Optional.ofNullable(product.getGtinCode()).orElse(
                Optional.ofNullable(product.getPackagedProduct()).map(MedicationPackagedProduct::getGtinCode).orElse(null)
        );
        if (name != null && gtin != null) {
            final var format = isHtml ? "%s<span class=\"gtin\">%s</span>" : "%s (%s)";
            return String.format(format, name, gtin);
        }
        final var magistral = "Préparation magistrale";
        if (name != null) {
            return String.format("%s (%s)", name, magistral);
        }
        return magistral;
    }

    /**
     * Gets the name of an author. It may be a person or a device.
     *
     * @param author The author.
     * @return The author name.
     */
    protected String formatAuthorName(final AuthorDigest author) {
        final var name = new StringBuilder();
        if (author.getGivenName() != null || author.getFamilyName() != null) {
            if (author.getGivenName() != null) {
                name.append(author.getGivenName());
            }
            if (author.getFamilyName() != null) {
                if (!name.isEmpty()) {
                    name.append(" ");
                }
                name.append(author.getFamilyName());
            }
        }
        if (author.getDeviceSoftwareName() != null) {
            name.append(author.getDeviceSoftwareName());
            if (author.getDeviceManufacturerModelName() != null) {
                name.append(" (");
                name.append(author.getDeviceManufacturerModelName());
                name.append(")");
            }
        }
        return name.toString();
    }
}
