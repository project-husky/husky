package org.projecthusky.fhir.emed.ch.epr.narrative.generators;

import org.apache.commons.lang3.StringUtils;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.ProductCodeType;
import org.projecthusky.fhir.emed.ch.epr.narrative.services.ValueSetEnumNarrativeForPatientService;
import org.projecthusky.fhir.emed.ch.epr.narrative.treatment.NarrativeTreatmentIngredient;
import org.projecthusky.fhir.emed.ch.epr.narrative.treatment.NarrativeTreatmentItem;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.IOException;
import java.io.InputStream;
import java.time.DateTimeException;
import java.time.ZoneId;
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

    protected final ValueSetEnumNarrativeForPatientService valueSetEnumNarrativeForPatientService = new ValueSetEnumNarrativeForPatientService();

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
                .withZone(ZoneId.systemDefault())
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
     * @param item The medication product.
     * @param lang    The language of the narrative to be generated.
     * @return The medication product name.
     */
    List<Node> formatMedicationName(final NarrativeDomFactory narDom,
                                    final NarrativeTreatmentItem item,
                                    final NarrativeLanguage lang) {
        final var name = StringUtils.capitalize(item.getProductName());

        final var gtinOrAtcCode = item.getProductCode();

        if (item.getCodeType() == ProductCodeType.GTIN) {
            final var url = "https://compendium.ch/search/setculture/fr-CH?backUrl=https://compendium.ch/search?q=" + gtinOrAtcCode;

            final var formCode = item.getProductFormCode();

            final var ingredients = String.join(",", item.getProductIngredients().stream()
                    .map(NarrativeTreatmentIngredient::getName)
                    .toList());

            final var doseQuantities = String.join("/", item.getProductIngredients().stream()
                    .map(NarrativeTreatmentIngredient::getQuantity)
                    .toList());

            final var doseUnits = item.getProductIngredients().stream()
                    .map(NarrativeTreatmentIngredient::getUnit)
                    .distinct()
                    .toList();

            List<Node> nodeMedicationName = new ArrayList<>(List.of(
                    narDom.link(url, name, StringUtils.capitalize(this.getMessage("SEE_MEDICINE", lang)), null),
                    narDom.br()));

            if (formCode != null) {
                nodeMedicationName.add(narDom.text(formCode));
            }

            if (!item.getProductIngredients().isEmpty()) {
                nodeMedicationName.add(narDom.br());
                nodeMedicationName.add(narDom.text(ingredients + " - "));
                if (doseUnits.size() == 1) {
                    nodeMedicationName.add(narDom.text(doseQuantities + doseUnits.get(0)));
                }
            }

            return nodeMedicationName;
        }

        return List.of(narDom.text(name));
    }

    Element createMedicationTable(final NarrativeDomFactory narDom,
                                  final List<Element> bodyRows,
                                  final NarrativeLanguage lang) {
        final var theadRow1 = narDom.tr(null, null);
        theadRow1.appendChild(narDom.th(StringUtils.capitalize(this.getMessage("PACKAGE_NAME", lang)), null, "3", null));
        theadRow1.appendChild(narDom.th(formatDosageTh(narDom, TimingEventAmbu.MORNING, lang), null, null, "th-timing"));
        theadRow1.appendChild(narDom.th(formatDosageTh(narDom, TimingEventAmbu.NOON, lang), null, null, "th-timing"));
        theadRow1.appendChild(narDom.th(formatDosageTh(narDom, TimingEventAmbu.EVENING, lang), null, null, "th-timing"));
        theadRow1.appendChild(narDom.th(formatDosageTh(narDom, TimingEventAmbu.NIGHT, lang), null, null, "th-timing"));
        theadRow1.appendChild(narDom.th(StringUtils.capitalize(this.getMessage("DOSE_UNIT", lang)), null, null, null));
        theadRow1.appendChild(narDom.th(StringUtils.capitalize(this.getMessage("DATE_FROM_TO", lang)), null, null, null));
        theadRow1.appendChild(narDom.th(StringUtils.capitalize(this.getMessage("REASON", lang)), null, null, null));
        theadRow1.appendChild(narDom.th(StringUtils.capitalize(this.getMessage("PRESCRIBED_BY", lang)), null, null, null));

        final var thead = narDom.thead();
        thead.appendChild(theadRow1);

        final var tbody = narDom.tbody();
        for (final var bodyRow : bodyRows) {
            tbody.appendChild(bodyRow);
        }

        final var table = narDom.table();
        table.appendChild(thead);
        table.appendChild(tbody);
        return table;
    }

    Node formatDosageTh(final NarrativeDomFactory narDom,
                        final TimingEventAmbu timing,
                        final NarrativeLanguage lang) {
        Node dosageThNode = narDom.p(null);
        byte[] b64;
        try {
            b64 = switch (timing) {
                case MORNING:
                    yield AbstractNarrativeGenerator.class.getResourceAsStream("/narrative/default/icons/sunrise.png").readAllBytes();
                case NOON:
                    yield AbstractNarrativeGenerator.class.getResourceAsStream("/narrative/default/icons/brightness-high.png").readAllBytes();
                case EVENING:
                    yield AbstractNarrativeGenerator.class.getResourceAsStream("/narrative/default/icons/sunset.png").readAllBytes();
                case NIGHT:
                    yield AbstractNarrativeGenerator.class.getResourceAsStream("/narrative/default/icons/moon.png").readAllBytes();
            };
        } catch (Exception e) {
            b64 = null;
        }

        if (b64 != null) {
            dosageThNode.appendChild(narDom.img("data:image/png;base64," + Base64.getEncoder().encodeToString(b64), this.valueSetEnumNarrativeForPatientService.getMessage(timing, lang)));
        }
        dosageThNode.appendChild(narDom.br());
        dosageThNode.appendChild(narDom.text(StringUtils.capitalize(this.valueSetEnumNarrativeForPatientService.getMessage(timing, lang))));

        return dosageThNode;
    }
}
