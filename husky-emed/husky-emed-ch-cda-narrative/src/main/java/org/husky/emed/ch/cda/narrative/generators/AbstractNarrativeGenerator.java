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
import org.husky.emed.ch.models.treatment.MedicationPackagedProduct;
import org.husky.emed.ch.models.treatment.MedicationProduct;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.IOException;
import java.io.InputStream;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.function.Function;

/**
 * Abstract base for narrative generators.
 *
 * @author Quentin Ligier
 */
public abstract class AbstractNarrativeGenerator {

    /**
     * The resource bundle that contains the translations.
     */
    protected final EnumMap<NarrativeLanguage, PropertyResourceBundle> bundles = new EnumMap<>(NarrativeLanguage.class);

    protected AbstractNarrativeGenerator() throws IOException {
        final Function<String, InputStream> getRes = (final String lang) ->
                Objects.requireNonNull(AbstractNarrativeGenerator.class.getResourceAsStream("/narrative/translations/Messages." + lang + ".properties"));

        this.bundles.put(NarrativeLanguage.ENGLISH, new PropertyResourceBundle(getRes.apply("en")));
        this.bundles.put(NarrativeLanguage.FRENCH, new PropertyResourceBundle(getRes.apply("fr")));
        this.bundles.put(NarrativeLanguage.GERMAN, new PropertyResourceBundle(getRes.apply("de")));
        this.bundles.put(NarrativeLanguage.ITALIAN, new PropertyResourceBundle(getRes.apply("it")));
    }

    /**
     * Formats a temporal object to the given format, respecting the generation locale.
     *
     * @param temporal The temporal object to format.
     * @param pattern  The format, as described in the {@link DateTimeFormatter} class.
     * @param lang     The language of the narrative to be generated.
     * @throws DateTimeException if an error occurs during formatting.
     */
    String formatTemporal(final TemporalAccessor temporal,
                          final String pattern,
                          final NarrativeLanguage lang) throws DateTimeException {
        return DateTimeFormatter.ofPattern(pattern, lang.getLocale())
                .format(temporal);
    }

    /**
     * Gets a translated message for the given key.
     *
     * @param key  The key.
     * @param lang The language of the narrative to be generated.
     * @return The translated message.
     * @throws MissingResourceException if no object for the given key can be found.
     * @throws ClassCastException       if the object found for the given key is not a string.
     */
    String getMessage(final String key,
                      final NarrativeLanguage lang) {
        return this.bundles.get(lang).getString(key);
    }

    /**
     * Gets the translation of a value set enum element.
     *
     * @param valueSet The value set enum element.
     * @param lang     The language of the narrative to be generated.
     * @return The display name in the right language.
     */
    String getEnumNarrative(final ValueSetEnumInterface valueSet,
                            final NarrativeLanguage lang) {
        return valueSet.getDisplayName(lang.getLanguageCode());
    }

    /**
     * Gets the name of a medication product as a list of {@link Node}s.
     *
     * @param narDom  The narrative DOM factory.
     * @param product The medication product.
     * @param lang    The language of the narrative to be generated.
     * @return The medication product name.
     */
    List<Node> formatMedicationName(final NarrativeDomFactory narDom,
                                    final MedicationProduct product,
                                    final NarrativeLanguage lang) {
        final var name = Optional.ofNullable(product.getName()).orElse(
                Optional.ofNullable(product.getPackagedProduct()).map(MedicationPackagedProduct::getName).orElse(null)
        );
        final var gtin = Optional.ofNullable(product.getGtinCode()).orElse(
                Optional.ofNullable(product.getPackagedProduct()).map(MedicationPackagedProduct::getGtinCode).orElse(null)
        );
        if (name != null && gtin != null) {
            final var url = "https://compendium.ch/search/setculture/fr-CH?backUrl=https://compendium.ch/search?q=" + gtin;
            return List.of(
                    narDom.text(name),
                    narDom.link(url, gtin, "Voir la fiche du médicament", "gtin")
            );
        }
        final var magistral = "Préparation magistrale";
        if (name != null) {
            return List.of(narDom.text(name + " (" + magistral + ")"));
        }
        return List.of(narDom.text(magistral));
    }

    Element createMedicationTable(final NarrativeDomFactory narDom,
                                  final List<Element> bodyRows,
                                  final NarrativeLanguage lang) {
        final var theadRow1 = narDom.tr(null);
        theadRow1.appendChild(narDom.th("#n", "2", null));
        theadRow1.appendChild(narDom.th("Nom du médicament", "2", null));
        theadRow1.appendChild(narDom.th("Dosage", null, "5"));
        theadRow1.appendChild(narDom.th("Voie et localisation", "2", null));
        final var theadRow2 = narDom.tr(null);
        theadRow2.appendChild(narDom.th("Matin", null, null));
        theadRow2.appendChild(narDom.th("Midi", null, null));
        theadRow2.appendChild(narDom.th("Soir", null, null));
        theadRow2.appendChild(narDom.th("Nuit", null, null));
        theadRow2.appendChild(narDom.th("", null, null));

        final var thead = narDom.thead();
        thead.appendChild(theadRow1);
        thead.appendChild(theadRow2);

        final var tbody = narDom.tbody();
        for (final var bodyRow : bodyRows) {
            tbody.appendChild(bodyRow);
        }

        final var table = narDom.table();
        table.appendChild(thead);
        table.appendChild(tbody);
        return table;
    }
}
