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
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.pdf.HtmlToPdfAConverter;
import org.projecthusky.fhir.emed.ch.epr.narrative.pdf.OpenHtmlToPdfAConverter;
import org.projecthusky.fhir.emed.ch.epr.narrative.utils.NarrativeUtils;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    public PdfOriginalRepresentationGenerator() throws IOException, ParserConfigurationException {
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
    public PdfOriginalRepresentationGenerator(final HtmlToPdfAConverter htmlToPdfAConverter)
            throws IOException, ParserConfigurationException {
        super();
        this.pdfConverter = Objects.requireNonNull(htmlToPdfAConverter);
    }

    /**
     * Gets the PDF author
     *
     * @return the PDF author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the PDF author
     *
     * @param author the PDF author
     */
    public void setAuthor(final String author) {
        this.author = Objects.requireNonNull(author);
    }

    /**
     * It will use the default template.
     *
     * @param document the narrative document.
     * @param lang     The generation language.
     * @return the PDF bytearray.
     */
    public byte[] generate(final ChEmedEprDocumentPmlc document,
                           final NarrativeLanguage lang) throws Exception {
        return this.generate(document, lang, null, null);
    }

    /**
     * @param document       The narrative document.
     * @param lang           The generation language.
     * @param templateHeader The HTML template header (before the main content).
     * @param templateFooter The HTML template footer (after the main content).
     * @return The PDF bytearray.
     */
    public byte[] generate(final ChEmedEprDocumentPmlc document,
                           final NarrativeLanguage lang,
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

        final var root = narDom.getDocument().getDocumentElement();

        // Document title & Patient's personal data
        root.appendChild(this.formatHeader(document, lang));

        // Last version
        root.appendChild(narDom.p(StringUtils.capitalize(this.getMessage("LAST_VERSION",
                                                                         lang)) + " " + document.getTimestampElement().getValueAsString()));
/*
        // Medication table
        root.appendChild(narDom.title2(StringUtils.capitalize(this.getMessage("ACTIVE_TREATMENT", lang)), null));
        List<NarrativeTreatmentItem> activeTreatments = document.getActiveTreatments().stream()
                .filter(t -> !t.isInReserve())
                .toList();
        List<Element> medicationActiveTableRows = createMedicationTableRows(activeTreatments, lang);
        root.appendChild(this.createMedicationTable(medicationActiveTableRows, lang));

        // Medication in reserve
        root.appendChild(narDom.title2(StringUtils.capitalize(this.getMessage("IN_RESERVE_TREATMENT", lang)), null));
        List<NarrativeTreatmentItem> inReserveTreatment = document.getActiveTreatments().stream()
                .filter(NarrativeTreatmentItem::isInReserve)
                .toList();
        List<Element> medicationInReserveTableRows = createMedicationTableRows(inReserveTreatment, lang);
        root.appendChild(this.createMedicationTable(medicationInReserveTableRows, lang));
*/
        Map<String, String> variables = new HashMap<>(64);
        variables.putIfAbsent("title", "Carte de médication");
        variables.putIfAbsent("subject", this.formatHumanName(document.resolvePatient().resolveName()));
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

    /**
     * Creates the array with treatment.
     *
     * @param treatments The treatments
     * @param lang       The lang of the PDF.
     * @return The elements with treatments information.
     * @throws IOException if a resource icon isn't founded.
     *
    private List<Element> createMedicationTableRows(final List<NarrativeTreatmentItem> treatments,
                                                    final NarrativeLanguage lang) throws IOException {
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
            cells.add(narDom.td(narDom.img(treatment.getProductIcon(), this.getMessage("MEDICATION_ICON", lang)),
                                "border-top",
                                rowspanForMedication,
                                null));

            // Medication name
            cells.add(narDom.td(this.formatMedicationName(treatment, lang), "col name border-top"));

            // Medication image
            final var tdImage = narDom.td(null, "medication-image border-top text-center");
            if (treatment.getProductImageFront() != null) {
                tdImage.appendChild(narDom.img(treatment.getProductImageFront(),
                                               this.getMessage("MEDICATION_IMAGE", lang)));
            }

            if (treatment.getProductImageBack() != null) {
                tdImage.appendChild(narDom.img(treatment.getProductImageBack(),
                                               this.getMessage("MEDICATION_IMAGE", lang)));
            }
            cells.add(tdImage);

            // Dosage instructions (5 columns)
            cells.addAll(this.formatDosageCells(treatment));

            // Date from to
            final var dateFromTo = narDom.p(null);
            if (treatment.getTreatmentStart() != null) {
                dateFromTo.appendChild(narDom.text(treatment.getTreatmentStart()));
                dateFromTo.appendChild(narDom.br());
            }
            if (treatment.getTreatmentStop() != null) {
                dateFromTo.appendChild(narDom.text(treatment.getTreatmentStop()));
            } else {
                dateFromTo.appendChild(narDom.text(StringUtils.capitalize(this.getMessage("UNKNOWN", lang))));
            }
            cells.add(narDom.td(dateFromTo, "border-top"));

            // Reason
            cells.add(narDom.td(treatment.getTreatmentReason(), "border-top"));

            // Prescribed by
            if (treatment.getLastMedicalAuthor() != null) {
                cells.add(narDom.td(treatment.getLastMedicalAuthor().getName(), "border-top"));
            } else {
                cells.add(narDom.td(null, "border-top"));
            }

            medicationTableRows.add(narDom.tr(cells, "border-top"));

            // Patient's instructions
            if (treatment.getPatientMedicationInstructions() != null) {
                final var td = narDom.td(null, "patient-instructions", null, "10");
                td.appendChild(narDom.title4(StringUtils.capitalize(this.getMessage("PATIENT_INSTRUCTIONS", lang)),
                                             null));
                td.appendChild(narDom.text(treatment.getPatientMedicationInstructions()));
                medicationTableRows.add(narDom.tr(td, null));
            }

            // Comments
            if (treatment.getAnnotationComment() != null) {
                final var td = narDom.td(null, "comments", null, "10");
                byte[] infoCircle = this.getResourceAsStream("/narrative/default/icons/info-circle.png").readAllBytes();
                td.appendChild(narDom.img("data:image/png;base64," + Base64.getEncoder().encodeToString(infoCircle),
                                          this.getMessage("COMMENT", lang)));
                td.appendChild(narDom.text(treatment.getAnnotationComment()));

                medicationTableRows.add(narDom.tr(td, null));
            }
        }

        if (medicationTableRows.isEmpty()) {
            final var td = narDom.td(narDom.em("Il n'y a pas de traitement actif"), "no-treatment");
            td.setAttribute("colspan", "11");
            medicationTableRows.add(narDom.tr(td, null));
        }

        return medicationTableRows;
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
     * @param author The author.
     * @return The author name.
     *
    private Node formatAuthorName(final NarrativeTreatmentAuthor author) {

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
     * @param item   The medicine
     * @return The dosages of the medicine
     *
    private List<Element> formatDosageCells(final NarrativeTreatmentItem item) {

        final var cells = new ArrayList<Element>(5);

        cells.add(displayQuantity(item.getDosageIntakeMorning()));
        cells.add(displayQuantity(item.getDosageIntakeNoon()));
        cells.add(displayQuantity(item.getDosageIntakeEvening()));
        cells.add(displayQuantity(item.getDosageIntakeNight()));

        final var unit = item.getDosageUnit() != null ? item.getDosageUnit() : "Inconnu";
        cells.add(narDom.td(narDom.text(unit), "text-center unit border-top"));

        return cells;
    }

    /**
     * Formats the dosage of the medicine
     *
     * @param quantity The quantity.
     * @return
     */
    final Element displayQuantity(@Nullable String quantity) {
        if (quantity == null || "".equals(quantity)) {
            quantity = "0";
        }
        return narDom.td(quantity, "text-center th-timing border-top");
    }

    /**
     * Gets the patient's personal data
     *
     * @param patient The patient.
     * @param lang    The generation language.
     * @return the patient's personal data
     */
    private Element formatPatientPersonalData(final ChCorePatientEpr patient,
                                              final NarrativeLanguage lang) {
        final var patientPersonalData = narDom.div(null, "patient-data");
        patientPersonalData.appendChild(narDom.title3(StringUtils.capitalize(this.getMessage("PATIENT_PERSONAL_DATA",
                                                                                             lang)),
                                                      null));
        patientPersonalData.appendChild(narDom.text(this.formatHumanName(patient.resolveName())));
        patientPersonalData.appendChild(narDom.br());
        patientPersonalData.appendChild(narDom.text(String.format("%s, %s",
                                                                  patient.getBirthDateElement().getValueAsString(),
                                                                  patient.resolveGender())));
        patientPersonalData.appendChild(narDom.br());
        if (patient.resolveAddress() != null) {
            patientPersonalData.appendChild(this.formatAddress(patient.resolveAddress()));
        }
        if (!patient.getTelecom().isEmpty()) {
            patientPersonalData.appendChild(this.formatContactPoints(patient.getTelecom()));
        }
        return patientPersonalData;
    }

    /**
     * Gets information of the header.
     *
     * @param document The document.
     * @param lang     The generation language.
     * @return the header.
     */
    private Element formatHeader(final ChEmedEprDocumentPmlc document,
                                 final NarrativeLanguage lang) {
        final var tr = narDom.tr(null, null);
        tr.appendChild(narDom.td(narDom.title1(StringUtils.capitalize(this.getMessage("TITLE", lang)),
                                               "title"), null));
        tr.appendChild(narDom.td(this.formatPatientPersonalData(document.resolvePatient(), lang), null));

        final var tdAuthor = narDom.td(null, null);
        tdAuthor.appendChild(narDom.title3(StringUtils.capitalize(this.getMessage("AUTHOR_DOCUMENT", lang)),
                                           null));
        tdAuthor.appendChild(narDom.p(this.formatDevice(document.resolveComposition().resolveAuthor())));

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
