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
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.text.StringSubstitutor;
import org.husky.emed.ch.cda.narrative.enums.NarrativeLanguage;
import org.husky.emed.ch.cda.narrative.pdf.HtmlToPdfAConverter;
import org.husky.emed.ch.cda.narrative.pdf.OpenHtmlToPdfAConverter;
import org.husky.emed.ch.cda.narrative.utils.NarrativeUtils;
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

    /**
     * @param digest
     * @return
     */
    public byte[] generate(final EmedPmlcDocumentDigest digest) throws Exception {
        final var body = new StringBuilder();
        body.append(this.templateHeader);

        final Map<String, String> variables = new HashMap<>(64);
        variables.put("title", "Carte de médication");
        variables.put("subject", "");
        variables.put("author", "");
        variables.put("description", "");

        body.append("<h1>${title}</h1>");
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
                                <td class="col n">#%d</td>
                                <td class="col name">%s</td>
                                <td class="col dosage" colspan="5">%s</td>
                                <td class="col route-site">%s</td>
                            </tr>
                            """,
                    i,
                    this.getMedicationName(entry.getProduct(), true),
                    "",
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
            body.append("<hr>");
            body.append(String.format("<h2 id='med_%1$d'><span class='n'>%1$d</span %2$s</h2>", i,
                    this.getMedicationName(entry.getProduct(), true)));

            // Last author
            body.append("<div id='narrative last_author'>");
            body.append("<h3>Dernier intervenant</h3><p>");
            body.append("Auteur");
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

        body.append(this.templateFooter);

        final var stringSubstitutor = new StringSubstitutor(variables);
        return this.pdfConverter.convert(stringSubstitutor.replace(body));
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
