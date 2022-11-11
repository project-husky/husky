/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.epr.narrative.generators;

import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.pdf.HtmlToPdfAConverter;
import org.projecthusky.fhir.emed.ch.epr.narrative.pdf.OpenHtmlToPdfAConverter;
import org.projecthusky.fhir.emed.ch.epr.narrative.treatment.NarrativeTreatmentAuthor;
import org.projecthusky.fhir.emed.ch.epr.narrative.treatment.NarrativeTreatmentDocument;
import org.projecthusky.fhir.emed.ch.epr.narrative.treatment.NarrativeTreatmentItem;
import org.projecthusky.fhir.emed.ch.epr.narrative.utils.NarrativeUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.*;

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
     * @param document
     * @return
     */
    public byte[] generate(final NarrativeTreatmentDocument document) throws Exception {
        return this.generate(document, null, null);
    }

    /**
     * @param document
     * @param templateHeader The HTML template header (before the main content).
     * @param templateFooter The HTML template footer (after the main content).
     * @return
     */
    public byte[] generate(final NarrativeTreatmentDocument document,
                           @Nullable String templateHeader,
                           @Nullable String templateFooter) throws Exception {
        Objects.requireNonNull(document, "digest shall not be null in generate()");

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
        final NarrativeLanguage lang = document.getNarrativeLanguage();

        // Document title & Patient's personal data
        root.appendChild(this.formatHeader(narDom, document));

        // Last version
        root.appendChild(narDom.p(StringUtils.capitalize(this.getMessage("LAST_VERSION", lang)) + " " + document.getDocumentationTime()));

        // Medication table
        root.appendChild(narDom.title2(StringUtils.capitalize(this.getMessage("ACTIVE_TREATMENT", lang)), null));
        List<NarrativeTreatmentItem> activeTreatments = document.getActiveTreatments().stream()
                .filter(t -> !t.isInReserve())
                .toList();
        List<Element> medicationActiveTableRows = createMedicationTableRows(activeTreatments, lang, narDom);
        root.appendChild(this.createMedicationTable(narDom, medicationActiveTableRows, lang));

        // Medication in reserve
        root.appendChild(narDom.title2(StringUtils.capitalize(this.getMessage("IN_RESERVE_TREATMENT", lang)), null));
        List<NarrativeTreatmentItem> inReserveTreatment = document.getActiveTreatments().stream()
                .filter(NarrativeTreatmentItem::isInReserve)
                .toList();
        List<Element> medicationInReserveTableRows = createMedicationTableRows(inReserveTreatment, lang, narDom);
        root.appendChild(this.createMedicationTable(narDom, medicationInReserveTableRows, lang));

        Map<String, String> variables = new HashMap<>(64);
        variables.putIfAbsent("title", "Carte de médication");
        variables.putIfAbsent("subject", "");
        variables.putIfAbsent("author", this.author);
        variables.putIfAbsent("description", "");
        variables.putIfAbsent("lang", lang.getLanguageCode().getCodeValue());
        variables.putIfAbsent("generationDate", formatTemporal(Instant.now(), "dd.MM.yyyy HH:mm:ss", lang));

        final var stringSubstitutor = new StringSubstitutor(variables);
        final String body = stringSubstitutor.replace(templateHeader)
                + narDom.render()
                + stringSubstitutor.replace(templateFooter);

        return this.pdfConverter.convert(body);
    }

    private List<Element> createMedicationTableRows(final List<NarrativeTreatmentItem> treatments,
                                            final NarrativeLanguage lang,
                                            final NarrativeDomFactory narDom) throws IOException {
        final var medicationTableRows = new ArrayList<Element>();
        for (final var treatment : treatments) {
            final var cells = new ArrayList<Element>();

            String rowspanForMedication = null;
            if (treatment.getPatientMedicationInstructions() != null && treatment.getAnnotationComment() != null) {
                rowspanForMedication = "3";
            } else if (treatment.getPatientMedicationInstructions() != null || treatment.getAnnotationComment() != null) {
                rowspanForMedication = "2";
            }

            // Medication icon
            cells.add(narDom.td(narDom.img(treatment.getProductIcon(), this.getMessage("MEDICATION_ICON", lang)), "border-top", rowspanForMedication, null));

            // Medication name
            cells.add(narDom.td(this.formatMedicationName(narDom, treatment, lang), "col name border-top"));

            // Medication image
            var tdImage = narDom.td(null, "medication-image border-top text-center");
            if (treatment.getProductImageFront() != null) {
                tdImage.appendChild(narDom.img(treatment.getProductImageFront(), this.getMessage("MEDICATION_IMAGE", lang)));
            }

            if (treatment.getProductImageBack() != null) {
                tdImage.appendChild(narDom.img(treatment.getProductImageBack(), this.getMessage("MEDICATION_IMAGE", lang)));
            }
            cells.add(tdImage);

            // Dosage instructions (5 columns)
            cells.addAll(this.formatDosageCells(narDom, treatment));

            // Date from to
            var dateFromTo = narDom.p(null);
            dateFromTo.appendChild(narDom.text(treatment.getTreatmentStart()));
            dateFromTo.appendChild(narDom.br());
            if (treatment.getTreatmentStop() != null) {
                dateFromTo.appendChild(narDom.text(treatment.getTreatmentStop()));
            } else {
                dateFromTo.appendChild(narDom.text(StringUtils.capitalize(this.getMessage("UNKNOWN", lang))));
            }
            cells.add(narDom.td(dateFromTo, "border-top"));

            // Reason
            cells.add(narDom.td(treatment.getTreatmentReason(), "border-top"));

            // Prescribed by
            if (treatment.getSectionAuthor() != null) {
                cells.add(narDom.td(treatment.getSectionAuthor().getName(), "border-top"));
            } else {
                cells.add(narDom.td(null, "border-top"));
            }

            medicationTableRows.add(narDom.tr(cells, "border-top"));

            // Patient's instructions
            if (treatment.getPatientMedicationInstructions() != null) {
                var td = narDom.td(null, "patient-instructions", null, "10");
                td.appendChild(narDom.title4(StringUtils.capitalize(this.getMessage("PATIENT_INSTRUCTIONS", lang)), null));
                td.appendChild(narDom.text(treatment.getPatientMedicationInstructions()));
                medicationTableRows.add(narDom.tr(td, null));
            }

            // Comments
            if (treatment.getAnnotationComment() != null) {
                var td = narDom.td(null, "comments", null, "10");
                byte[] infoCircle = this.getResourceAsStream("/narrative/default/icons/info-circle.png").readAllBytes();
                td.appendChild(narDom.img("data:image/png;base64," + Base64.getEncoder().encodeToString(infoCircle), this.getMessage("COMMENT", lang)));
                td.appendChild(narDom.text(treatment.getAnnotationComment()));

                medicationTableRows.add(narDom.tr(td, null));
            }
        }

        if (medicationTableRows.isEmpty()) {
            final var td = narDom.td(narDom.em("Il n'y a pas de traitement actif"), "no-treatment");
            td.setAttribute("colspan", "11");
            medicationTableRows.add(narDom.tr(td, null));
        }

        return  medicationTableRows;
    }

    /**
     * Gets the {@link InputStream} of a resource.
     *
     * @param resource The resource path.
     * @return the non-null {@link InputStream} of the resource file.
     * @throws FileNotFoundException if the resource doesn't exist.
     */
    private InputStream getResourceAsStream(final String resource) throws FileNotFoundException {
        final var is = PdfOriginalRepresentationGenerator.class.getResourceAsStream(resource);
        if (is == null) {
            throw new FileNotFoundException("The resource '" + resource + "' is not found");
        }
        return is;
    }

    /**
     * Gets the name of an author. It may be a person or a device.
     *
     * @param author
     * @return The author name.
     */
    private Node formatAuthorName(final NarrativeDomFactory narDom,
                          final NarrativeTreatmentAuthor author) {

        final var p = narDom.p(null);
        p.appendChild(narDom.text(author.getName()));
        p.appendChild(narDom.br());

        p.appendChild(narDom.text(author.getOrganization()));
        p.appendChild(narDom.br());

        if (author.getAddress() != null && !author.getAddress().isEmpty()) {
            p.appendChild(narDom.text(author.getAddress()));
            p.appendChild(narDom.br());
        }

        return p;
    }

    /**
     * Gets information on the dosage of the medicine
     *
     * @param narDom
     * @param item The medicine
     * @return The dosages of the medicine
     */
    private List<Element> formatDosageCells(final NarrativeDomFactory narDom,
                                    final NarrativeTreatmentItem item) {
//        if (item.getNarrativeDosageInstructions() != null) {
//            final var td = narDom.td(item.getNarrativeDosageInstructions(), "col border-top");
//            td.setAttribute("colspan", "5");
//            return List.of(td);
//        }
        final var cells = new ArrayList<Element>(5);

        cells.add(displayQuantity(narDom, item.getDosageIntakeMorning()));
        cells.add(displayQuantity(narDom, item.getDosageIntakeNoon()));
        cells.add(displayQuantity(narDom, item.getDosageIntakeEvening()));
        cells.add(displayQuantity(narDom, item.getDosageIntakeNight()));

        if (item.getDosageUnit() != null) {
            cells.add(narDom.td(narDom.text(item.getDosageUnit()), "text-center unit border-top"));
        }
        return cells;
    }

    /**
     * Formats the dosage of the medicine
     *
     * @param narDom
     * @param quantity the dosage
     * @return
     */
    final Element displayQuantity(final NarrativeDomFactory narDom,
                                  @Nullable String quantity) {
        if (quantity == null || quantity.equals("")) {
            quantity = "0";
        }
        return narDom.td(quantity, "text-center th-timing border-top");
    }

    /**
     * Gets the patient's personal data
     *
     * @param narDom
     * @param document
     * @return the patient's personal data
     */
    private Element formatPatientPersonalData(final NarrativeDomFactory narDom,
                                              final NarrativeTreatmentDocument document) {
        var patientPersonalData = narDom.div(null, "patient-data");
        patientPersonalData.appendChild(narDom.title3(StringUtils.capitalize(this.getMessage("PATIENT_PERSONAL_DATA",document.getNarrativeLanguage())), null));
        patientPersonalData.appendChild(narDom.text(document.getPatientName()));
        patientPersonalData.appendChild(narDom.br());
        patientPersonalData.appendChild(narDom.text(String.format("%s, %s", document.getPatientBirthDate(), document.getPatientGender())));
        patientPersonalData.appendChild(narDom.br());
        if (document.getPatientAddress() != null) {
            patientPersonalData.appendChild(narDom.text(document.getPatientAddress()));
        }
        if (document.getPatientContact() != null) {
            String separator = document.getPatientAddress() != null ? " / " : "";
            patientPersonalData.appendChild(narDom.text(separator + document.getPatientContact()));
        }
        return patientPersonalData;
    }

    /**
     * Gets information of the header
     * @param narDom
     * @param document
     * @return the header
     */
    private Element formatHeader(final NarrativeDomFactory narDom,
                         final NarrativeTreatmentDocument document) {
        final var tr = narDom.tr(null, null);
        tr.appendChild(narDom.td(narDom.title1(StringUtils.capitalize(this.getMessage("TITLE", document.getNarrativeLanguage())), "title"), null));
        tr.appendChild(narDom.td(this.formatPatientPersonalData(narDom, document), null));
        final var tdAuthor = narDom.td(null, null);
        tdAuthor.appendChild(narDom.title3(StringUtils.capitalize(this.getMessage("AUTHOR_DOCUMENT", document.getNarrativeLanguage())), null));
        tdAuthor.appendChild(this.formatAuthorName(narDom, document.getLastMedicalAuthor()));

        tr.appendChild(tdAuthor);

        final var table = narDom.table();
        table.appendChild(tr);
        return table;
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
