package org.projecthusky.fhir.emed.ch.epr.narrative.html;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.services.MedicationImageProvider;
import org.projecthusky.fhir.emed.ch.epr.narrative.services.ValueSetEnumNarrativeForPatientService;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.Objects;
import java.util.PropertyResourceBundle;
import java.util.function.Function;

/**
 * Abstract base for narrative generators.
 *
 * @author Quentin Ligier
 */
abstract class AbstractNarrativeGenerator {

    /**
     * The resource bundle that contains the translations.
     */
    protected final EnumMap<NarrativeLanguage, PropertyResourceBundle> bundles = new EnumMap<>(NarrativeLanguage.class);

    /**
     * A provider of better display name for enums, targeted at patients.
     */
    protected final ValueSetEnumNarrativeForPatientService valueSetEnumNarrativeForPatientService = new ValueSetEnumNarrativeForPatientService();

    /**
     * A provider of images for medications.
     */
    protected MedicationImageProvider medicationImageProvider = MedicationImageProvider.NO_OP_INSTANCE;

    AbstractNarrativeGenerator() throws IOException {
        final Function<String, InputStream> getRes = (final String lang) ->
                Objects.requireNonNull(AbstractNarrativeGenerator.class.getResourceAsStream(
                        "/narrative/translations/Messages." + lang + ".properties"));

        this.bundles.put(NarrativeLanguage.ENGLISH, new PropertyResourceBundle(getRes.apply("en")));
        this.bundles.put(NarrativeLanguage.FRENCH, new PropertyResourceBundle(getRes.apply("fr")));
        this.bundles.put(NarrativeLanguage.GERMAN, new PropertyResourceBundle(getRes.apply("de")));
        this.bundles.put(NarrativeLanguage.ITALIAN, new PropertyResourceBundle(getRes.apply("it")));
    }

    /**
     * Sets the medication images provider.
     *
     * @param medicationImageProvider The medication images provider to use, or {@code null}.
     */
    public void setMedicationImageProvider(@Nullable final MedicationImageProvider medicationImageProvider) {
        this.medicationImageProvider = Objects.requireNonNullElse(medicationImageProvider,
                                                                  MedicationImageProvider.NO_OP_INSTANCE);
    }

    /**
     * Generates the narrative for a medication card and return it as HTML content.
     *
     * @param document The medication card document.
     * @param lang The language of the narrative.
     * @return The HTML content of the narrative.
     */
    abstract public String generate(final ChEmedEprDocumentPmlc document,
                                    final NarrativeLanguage lang
                                    );

    /**
     * Generates the narrative for a prescription and return it as HTML content.
     *
     * @param document The prescription document.
     * @param lang The language of the narrative.
     * @return The HTML content of the narrative.
     */
     abstract public String generate(final ChEmedEprDocumentPre document,
                                     final NarrativeLanguage lang);
}
