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

import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.text.StringSubstitutor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.cda.narrative.enums.NarrativeLanguage;
import org.husky.emed.ch.cda.narrative.pdf.HtmlToPdfAConverter;
import org.husky.emed.ch.cda.narrative.pdf.OpenHtmlToPdfAConverter;
import org.husky.emed.ch.cda.narrative.utils.NarrativeUtils;
import org.husky.emed.ch.enums.ChEmedTimingEvent;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;
import org.husky.emed.ch.models.common.MedicationDosageIntake;
import org.husky.emed.ch.models.common.QuantityWithUnit;
import org.husky.emed.ch.models.document.EmedPmlcDocumentDigest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * This class provides a way to generate a CDA-CH-EMED PRE or PMLC document original representation as a PDF 1/A. The
 * generated PDF contains the information of the CDA document rendered for human reading. The languages supported are
 * English, German, French and Italian.
 *
 * <p>To include the PDF in the document, see {@link NarrativeUtils#setPdfOriginalRepresentation}
 *
 * <p>HTML template file:
 *
 * <p>Internals: it first creates an HTML document with all the data and then converts it to a PDF.
 *
 * @author Quentin Ligier
 */
public class PdfOriginalRepresentationGenerator extends AbstractNarrativeGenerator {

    /**
     * The HTML template header (before the main content).
     */
    private final String templateHeader;

    /**
     * The HTML template footer (after the main content).
     */
    private final String templateFooter;

    /**
     * The HTML-to-PDF/A converter.
     */
    private final HtmlToPdfAConverter pdfConverter;

    /**
     * The PDF author.
     */
    private String author = "Husky PDF generator";

    /**
     * Simplified constructor. It will use the default template and HTML-to-PDF/A generator.
     *
     * @param narrativeLanguage The language to use to generate the narrative text.
     */
    public PdfOriginalRepresentationGenerator(final NarrativeLanguage narrativeLanguage) throws IOException, URISyntaxException {
        super(narrativeLanguage);
        this.templateHeader = Files.readString(Paths.get(this.getResource("narrative/default/template.header" +
                ".html").toURI()));
        this.templateFooter = "</body></html>";
        final var converter = new OpenHtmlToPdfAConverter();
        converter.setProducerName("The Husky library");
        converter.addFont("arimo", 400, BaseRendererBuilder.FontStyle.NORMAL,
                () -> this.getResource("narrative/default/font/Arimo-Regular.ttf").openStream());
        converter.addFont("arimo", 700, BaseRendererBuilder.FontStyle.NORMAL,
                () -> this.getResource("narrative/default/font/Arimo-Bold.ttf").openStream());
        this.pdfConverter = converter;
    }

    /**
     * Full constructor.
     *
     * @param narrativeLanguage   The language to use to generate the narrative text.
     * @param templateHeader      The HTML template header (before the main content).
     * @param templateFooter      The HTML template footer (after the main content).
     * @param htmlToPdfAConverter The HTML-to-PDF/A converter.
     */
    public PdfOriginalRepresentationGenerator(final NarrativeLanguage narrativeLanguage,
                                              final String templateHeader,
                                              final String templateFooter,
                                              final HtmlToPdfAConverter htmlToPdfAConverter) {
        super(narrativeLanguage);
        this.templateHeader = Objects.requireNonNull(templateHeader);
        this.templateFooter = Objects.requireNonNull(templateFooter);
        this.pdfConverter = Objects.requireNonNull(htmlToPdfAConverter);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = Objects.requireNonNull(author);
    }

    /**
     * @param digest
     * @return
     */
    public byte[] generate(final EmedPmlcDocumentDigest digest) throws Exception {
        final Map<String, String> variables = new HashMap<>(64);
        variables.put("title", "Carte de médication");
        variables.put("subject", "");
        variables.put("author", this.author);
        variables.put("description", "");
        return this.generate(digest, variables);
    }

    /**
     * @param digest
     * @param variables
     * @return
     */
    public byte[] generate(final EmedPmlcDocumentDigest digest,
                           final Map<String, String> variables) throws Exception {
        Objects.requireNonNull(digest, "digest shall not be null in generate()");
        Objects.requireNonNull(variables, "variables shall not be null in generate()");

        final var stringSubstitutor = new StringSubstitutor(variables);

        final var body = new StringBuilder();
        body.append(stringSubstitutor.replace(this.templateHeader));

        body.append(String.format("<h1>%s</h1>", variables.getOrDefault("title", "Carte de médication")));
        body.append("""
                <table>
                    <thead>
                        <tr>
                            <th rowspan="2">#n</th>
                            <th rowspan="2">Nom du médicament</th>
                            <th colspan="5">Dosage</th>
                            <th rowspan="2">Voie et localisation</th>
                        </tr>
                        <tr>
                            <th>Matin</th>
                            <th>Midi</th>
                            <th>Soir</th>
                            <th>Nuit</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                """);
        int i = 1;
        for (final var entry : digest.getMtpEntryDigests()) {
            final var routeSite = Optional.ofNullable(entry.getRouteOfAdministration()).map(this::getEnumNarrative)
                    .orElse("<span class='na'>N/A</span");

            body.append(String.format("""
                            <tr>
                                <td class="col n"><a href='#entry-%d'>#%1$d</a></td>
                                <td class="col name">%s</td>
                                %s
                                <td class="col route-site">%s</td>
                            </tr>
                            """,
                    i,
                    this.formatMedicationName(entry.getProduct(), true),
                    this.formatDosageCells(entry.getDosageInstructions()),
                    routeSite
            ));
            ++i;
        }
        body.append("""
                     </tbody>
                </table>
                 """);

        i = 1;
        for (final var entry : digest.getMtpEntryDigests()) {
            body.append(String.format("<hr id='entry-%d'>", i));
            body.append(String.format("<h2 id='med_%1$d'><span class='n'>%1$d</span %2$s</h2>", i,
                    this.formatMedicationName(entry.getProduct(), true)));

            // Last author
            body.append("<div id='narrative last_author'>");
            body.append("<h3>Dernier intervenant</h3><p>");
            body.append(this.formatAuthorName(entry.getSectionAuthor()));
            body.append("</p></div>");

            if (entry.getTreatmentReason() != null) {
                body.append("<div id='narrative fulfilment_instructions'>");
                body.append("<h3>Raison du traitement</h3><p>");
                body.append(StringEscapeUtils.escapeXml11(entry.getTreatmentReason()));
                body.append("</p></div>");
            }
            if (entry.getAnnotationComment() != null) {
                body.append("<div id='narrative annotation_comment'>");
                body.append("<h3>Commentaire</h3><p>");
                body.append(StringEscapeUtils.escapeXml11(entry.getAnnotationComment()));
                body.append("</p></div>");
            }
            if (entry.getPatientMedicationInstructions() != null) {
                body.append("<div id='narrative medication_instructions'>");
                body.append("<h3>Instructions de médication</h3><p>");
                body.append(StringEscapeUtils.escapeXml11(entry.getPatientMedicationInstructions()));
                body.append("</p></div>");
            }
            if (entry.getFulfilmentInstructions() != null) {
                body.append("<div id='narrative fulfilment_instructions'>");
                body.append("<h3>Instructions de fulfilment</h3><p>");
                body.append(StringEscapeUtils.escapeXml11(entry.getFulfilmentInstructions()));
                body.append("</p></div>");
            }

            ++i;
        }

        body.append("<hr>");
        body.append("<div id='narrative document_author'>");
        body.append("<h3>Auteur du document</h3><p>");
        body.append(this.formatAuthorName(digest.getAuthors().get(0)));
        body.append("</p></div>");

        body.append(stringSubstitutor.replace(this.templateFooter));

        return this.pdfConverter.convert(body.toString());
    }

    /**
     * Gets the {@link URL} of a resource.
     *
     * @param resource The resource path.
     * @return the non-null {@link URL} of the resource file.
     * @throws IllegalArgumentException if the resource doesn't exist.
     */
    protected URL getResource(final String resource) {
        final var url = PdfOriginalRepresentationGenerator.class.getResource(resource);
        if (url == null) {
            throw new IllegalArgumentException("The resource '" + resource + "' is not found");
        }
        return url;
    }

    /**
     * Gets the name of an author. It may be a person or a device.
     *
     * @param author The author or {@code null}.
     * @return The author name.
     */
    protected String formatAuthorName(@Nullable final AuthorDigest author) {
        if (author == null) {
            return "<em>Inconnu</em>";
        }
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
            name.append("<span class='device'>");
            name.append(author.getDeviceSoftwareName());
            if (author.getDeviceManufacturerModelName() != null) {
                name.append(" (");
                name.append(author.getDeviceManufacturerModelName());
                name.append(")");
            }
            name.append("</span>");
        }
        if (name.isEmpty()) {
            name.append("<em>Inconnu</em>");
        }
        name.append("<br>");

        if (!author.getTelecoms().getPhones().isEmpty()) {
            final var phone = author.getTelecoms().getPhones().get(0);
            name.append(String.format("<a href='%s'>%s</a><br>", phone, StringUtils.removeStart(phone, "tel:")));
        }
        if (!author.getTelecoms().getMails().isEmpty()) {
            final var mail = author.getTelecoms().getMails().get(0);
            name.append(String.format("<a href='%s'>%s</a><br>", mail, StringUtils.removeStart(mail, "mailto:")));
        }
        if (!author.getAddresses().isEmpty() && !author.getAddresses().get(0).isEmpty()) {
            final var address = author.getAddresses().get(0);
            name.append("<span class='address'>");

            if (address.getStreetName() != null) {
                name.append(address.getStreetName());
                if (address.getHouseNumber() != null) {
                    name.append(" ");
                    name.append(address.getHouseNumber());
                }
                name.append("<br>");
            }
            if (address.getPostalCode() != null || address.getCity() != null) {
                if (address.getPostalCode() != null) {
                    name.append(address.getPostalCode());
                    name.append(" ");
                }
                if (address.getCity() != null) {
                    name.append(address.getCity());
                }
                name.append("<br>");
            }
            if (address.getCountry() != null) {
                name.append(address.getCountry());
                name.append("<br>");
            }
            name.append("</span>");
        }

        return name.toString();
    }

    protected String formatDosageCells(final MedicationDosageInstructions dosageInstructions) {
        if (dosageInstructions.getNarrativeDosageInstructions() != null) {
            return "<td class='col dosage' colspan='5'>%s</td>";
        }
        final var cells = new StringBuilder();

        final Function<ChEmedTimingEvent, QuantityWithUnit> findIntake = event -> dosageInstructions.getIntakes().stream()
                .filter(intake -> event.equals(intake.getEventTiming()))
                .findAny()
                .map(MedicationDosageIntake::getDoseQuantity)
                .orElse(null);
        final Consumer<QuantityWithUnit> displayQuantity = quantity -> {
            if (quantity == null) {
                cells.append("<td></td>");
            } else {
                cells.append(String.format("<td>%s <span class='unit'>%s</span></td>", quantity.getValue(),
                        quantity.getUnit().getCodeValue()));
            }
        };
        displayQuantity.accept(findIntake.apply(ChEmedTimingEvent.MORNING));
        displayQuantity.accept(findIntake.apply(ChEmedTimingEvent.AFTERNOON));
        displayQuantity.accept(findIntake.apply(ChEmedTimingEvent.EVENING));
        displayQuantity.accept(findIntake.apply(ChEmedTimingEvent.NIGHT));
        cells.append("<td></td>");
        return cells.toString();
    }
}
/*
 * Qu'est-ce qu'on inclut dans une medication card?
 *
 * Tableau colonnes:
 * ID: #1
 * Nom: nom + gtin, ou nom (préparation magistrale), ou préparation magistrale
 * Statut: suspendu, actif, ...
 * Dosage: | | | | si structuré et possible, sinon narratif.
 * Voie et route: texte
 *
 * Pour chaque médicament:
 * Tous les narratifs (Fulfillment Instructions utile?)
 * Auteur de section (et auteur de document?)
 */
