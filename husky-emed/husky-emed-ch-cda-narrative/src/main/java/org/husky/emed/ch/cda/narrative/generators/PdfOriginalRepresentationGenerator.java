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
import org.husky.emed.ch.models.common.QuantityWithUnitCode;
import org.husky.emed.ch.models.document.EmedPmlcDocumentDigest;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
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
 * @author Quentin Ligier
 * @implNote It first creates an HTML document with all the data and then converts it to a PDF.
 */
public class PdfOriginalRepresentationGenerator extends AbstractNarrativeGenerator {

    /**
     * The HTML-to-PDF/A converter.
     */
    private final HtmlToPdfAConverter pdfConverter;

    /**
     * The PDF author.
     */
    private String author = "Husky PDF generator";

    /**
     * Simplified constructor. It will use the default HTML-to-PDF/A generator.
     */
    public PdfOriginalRepresentationGenerator() throws IOException {
        super();
        final var converter = new OpenHtmlToPdfAConverter();
        converter.setProducerName("The Husky library");
        converter.addFont("arimo", 400, BaseRendererBuilder.FontStyle.NORMAL,
                () -> this.getResourceAsStream("/narrative/default/font/Arimo-Regular.ttf"));
        converter.addFont("arimo", 700, BaseRendererBuilder.FontStyle.NORMAL,
                () -> this.getResourceAsStream("/narrative/default/font/Arimo-Bold.ttf"));
        this.pdfConverter = converter;
    }

    /**
     * Full constructor.
     *
     * @param htmlToPdfAConverter The HTML-to-PDF/A converter.
     */
    public PdfOriginalRepresentationGenerator(final HtmlToPdfAConverter htmlToPdfAConverter) throws IOException {
        super();
        this.pdfConverter = Objects.requireNonNull(htmlToPdfAConverter);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = Objects.requireNonNull(author);
    }

    /**
     * It will use the default template.
     *
     * @param digest
     * @return
     */
    public byte[] generate(final EmedPmlcDocumentDigest digest,
                           final NarrativeLanguage lang) throws Exception {
        return this.generate(digest, lang, null, null, null);
    }

    /**
     * @param digest
     * @param lang           The language to use to generate the narrative text.
     * @param variables
     * @param templateHeader The HTML template header (before the main content).
     * @param templateFooter The HTML template footer (after the main content).
     * @return
     */
    public byte[] generate(final EmedPmlcDocumentDigest digest,
                           final NarrativeLanguage lang,
                           @Nullable Map<String, String> variables,
                           @Nullable String templateHeader,
                           @Nullable String templateFooter) throws Exception {
        Objects.requireNonNull(digest, "digest shall not be null in generate()");
        Objects.requireNonNull(lang, "lang shall not be null in generate()");

        if (variables == null) {
            variables = new HashMap<>(64);
            variables.put("title", "Carte de médication");
            variables.put("subject", "");
            variables.put("author", this.author);
            variables.put("description", "");
        }
        if (templateHeader == null) {
            try (final var is = this.getResourceAsStream("/narrative/default/template.header.html")) {
                templateHeader = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            }
        }
        if (templateFooter == null) {
            templateFooter = "</body></html>";
        }

        final var narDom = new NarrativeDomFactory(true);
        final var root = narDom.getDocument().getDocumentElement();

        // Document title
        root.appendChild(narDom.title1(variables.getOrDefault("title", "Carte de médication")));

        // Medication table
        final var medicationTableRows = new ArrayList<Element>();
        int i = 1;
        for (final var entry : digest.getMtpEntryDigests()) {
            final var cells = new ArrayList<Element>();

            // Link to medication details
            final var tdLink = narDom.td(null, "col n");
            tdLink.appendChild(narDom.link("#entry-" + i, "#" + i, "Voir les détails", null));
            cells.add(tdLink);

            // Medication name
            cells.add(narDom.td(this.formatMedicationName(narDom, entry.getProduct(), lang), "col name"));

            // Dosage instructions (5 columns)
            cells.addAll(this.formatDosageCells(narDom, entry.getDosageInstructions(), lang));

            // Route and approach site
            final Node routeSite = Optional.ofNullable(entry.getRouteOfAdministration())
                    .map(routeOfAdministration -> this.getEnumNarrative(routeOfAdministration, lang))
                    .map(narDom::text)
                    .orElseGet(() -> narDom.span("N/A", "na"));
            cells.add(narDom.td(routeSite, "col route-site"));

            medicationTableRows.add(narDom.tr(cells));
            ++i;
        }
        root.appendChild(this.createMedicationTable(narDom, medicationTableRows, lang));

        // Medication details
        i = 1;
        for (final var entry : digest.getMtpEntryDigests()) {
            final var hr = narDom.getDocument().createElement("hr");
            hr.setAttribute("id", "entry-" + i);
            root.appendChild(hr);

            final var title2 = narDom.title2(List.of(
                    narDom.span(i, "n"),
                    this.formatMedicationName(narDom, entry.getProduct(), lang)
            ));
            title2.setAttribute("id", "med_" + i);
            root.appendChild(title2);

            // Last author
            root.appendChild(narDom.div(List.of(
                    narDom.title3("Dernier intervenant"),
                    narDom.p(this.formatAuthorName(narDom, entry.getSectionAuthor(), lang))
            ), "narrative last_author"));

            if (entry.getTreatmentReason() != null) {
                root.appendChild(narDom.div(List.of(
                        narDom.title3("Raison du traitement"),
                        narDom.p(StringEscapeUtils.escapeXml11(entry.getTreatmentReason()))
                ), "narrative treatment_reason"));
            }
            if (entry.getAnnotationComment() != null) {
                root.appendChild(narDom.div(List.of(
                        narDom.title3("Commentaire"),
                        narDom.p(StringEscapeUtils.escapeXml11(entry.getAnnotationComment()))
                ), "narrative annotation_comment"));
            }
            if (entry.getPatientMedicationInstructions() != null) {
                root.appendChild(narDom.div(List.of(
                        narDom.title3("Instructions de médication"),
                        narDom.p(StringEscapeUtils.escapeXml11(entry.getPatientMedicationInstructions()))
                ), "narrative medication_instructions"));
            }
            if (entry.getFulfilmentInstructions() != null) {
                root.appendChild(narDom.div(List.of(
                        narDom.title3("Instructions de fulfilment"),
                        narDom.p(StringEscapeUtils.escapeXml11(entry.getFulfilmentInstructions()))
                ), "narrative fulfilment_instructions"));
            }

            ++i;
        }

        root.appendChild(narDom.getDocument().createElement("hr"));
        root.appendChild(narDom.div(List.of(
                narDom.title3("Auteur du document"),
                narDom.p(this.formatAuthorName(narDom, digest.getAuthors().get(0), lang))
        ), "narrative document_author"));


        final var stringSubstitutor = new StringSubstitutor(variables);
        final String body = stringSubstitutor.replace(templateHeader)
                + narDom.render()
                + stringSubstitutor.replace(templateFooter);

        return this.pdfConverter.convert(body);
    }

    /**
     * Gets the {@link InputStream} of a resource.
     *
     * @param resource The resource path.
     * @return the non-null {@link InputStream} of the resource file.
     * @throws FileNotFoundException if the resource doesn't exist.
     */
    InputStream getResourceAsStream(final String resource) throws FileNotFoundException {
        final var is = PdfOriginalRepresentationGenerator.class.getResourceAsStream(resource);
        if (is == null) {
            throw new FileNotFoundException("The resource '" + resource + "' is not found");
        }
        return is;
    }

    /**
     * Gets the name of an author. It may be a person or a device.
     *
     * @param author The author or {@code null}.
     * @return The author name.
     */
    List<Node> formatAuthorName(final NarrativeDomFactory narDom,
                                @Nullable final AuthorDigest author,
                                final NarrativeLanguage lang) {
        if (author == null) {
            return List.of(narDom.em("Inconnu"));
        }

        final var nodes = new ArrayList<Node>();
        if (author.getGivenName() != null || author.getFamilyName() != null) {
            if (author.getGivenName() != null) {
                nodes.add(narDom.text(author.getGivenName()));
            }
            if (author.getFamilyName() != null) {
                if (!nodes.isEmpty()) {
                    nodes.add(narDom.text(" "));
                }
                nodes.add(narDom.text(author.getFamilyName()));
            }
        }
        if (author.getDeviceSoftwareName() != null) {
            final var deviceNodes = new ArrayList<>(2);
            deviceNodes.add(narDom.text(author.getDeviceSoftwareName()));
            if (author.getDeviceManufacturerModelName() != null) {
                deviceNodes.add(narDom.text(" (" + author.getDeviceManufacturerModelName() + ")"));
            }
            nodes.add(narDom.span(deviceNodes, "device"));
        }
        if (nodes.isEmpty()) {
            nodes.add(narDom.em("Inconnu"));
        }
        nodes.add(narDom.br());

        if (!author.getTelecoms().getPhones().isEmpty()) {
            final var phone = author.getTelecoms().getPhones().get(0);
            nodes.add(narDom.link(phone, StringUtils.removeStart(phone, "tel:"), "Appeler", "phone"));
            nodes.add(narDom.br());
        }
        if (!author.getTelecoms().getMails().isEmpty()) {
            final var mail = author.getTelecoms().getMails().get(0);
            nodes.add(narDom.link(mail, StringUtils.removeStart(mail, "mailto:"), "Ecrire un email", "mail"));
            nodes.add(narDom.br());
        }
        if (!author.getAddresses().isEmpty() && !author.getAddresses().get(0).isEmpty()) {
            final var address = author.getAddresses().get(0);
            final var addressNodes = new ArrayList<>(7);

            if (address.getStreetName() != null) {
                nodes.add(narDom.text(address.getStreetName()));
                if (address.getHouseNumber() != null) {
                    nodes.add(narDom.text(" " + address.getHouseNumber()));
                }
                nodes.add(narDom.br());
            }
            if (address.getPostalCode() != null || address.getCity() != null) {
                if (address.getPostalCode() != null) {
                    nodes.add(narDom.text(address.getPostalCode() + " "));
                }
                if (address.getCity() != null) {
                    nodes.add(narDom.text(address.getCity()));
                }
                nodes.add(narDom.br());
            }
            if (address.getCountry() != null) {
                nodes.add(narDom.text(address.getCountry()));
                nodes.add(narDom.br());
            }
            nodes.add(narDom.span(addressNodes, "address"));
        }

        return nodes;
    }

    List<Element> formatDosageCells(final NarrativeDomFactory narDom,
                                    final MedicationDosageInstructions dosageInstructions,
                                    final NarrativeLanguage lang) {
        if (dosageInstructions.getType() == MedicationDosageInstructions.Type.NARRATIVE) {
            final var td = narDom.td(dosageInstructions.getNarrativeDosageInstructions(), "col dosage");
            td.setAttribute("colspan", "5");
            return List.of(td);
        }
        final var cells = new ArrayList<Element>(5);

        final Function<ChEmedTimingEvent, QuantityWithUnitCode> findIntake = event -> dosageInstructions.getIntakes().stream()
                .filter(intake -> event.equals(intake.getEventTiming()))
                .findAny()
                .map(MedicationDosageIntake::getDoseQuantity)
                .orElse(null);
        final Consumer<QuantityWithUnitCode> displayQuantity = quantity -> {
            if (quantity == null) {
                cells.add(narDom.td(null, null));
            } else {
                cells.add(narDom.td(List.of(
                        narDom.text(quantity.getValue() + " "),
                        narDom.span(this.getEnumNarrative(quantity.getUnit(), lang), "unit")
                ), null));
            }
        };
        displayQuantity.accept(findIntake.apply(ChEmedTimingEvent.MORNING));
        displayQuantity.accept(findIntake.apply(ChEmedTimingEvent.AFTERNOON));
        displayQuantity.accept(findIntake.apply(ChEmedTimingEvent.EVENING));
        displayQuantity.accept(findIntake.apply(ChEmedTimingEvent.NIGHT));
        cells.add(narDom.td(null, null));
        return cells;
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
