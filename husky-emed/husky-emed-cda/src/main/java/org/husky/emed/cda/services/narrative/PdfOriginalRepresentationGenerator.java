package org.husky.emed.cda.services.narrative;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.cda.models.document.EmedPmlcDocumentDigest;

/**
 * This class provides a way to generate a CDA-CH-EMED PRE or PMLC document original representation as a PDF 1/A. The
 * generated PDF contains the information of the CDA document rendered for human reading. The languages supported are
 * English, German, French and Italian.
 *
 * <p>To include the PDF in the document, see {@link NarrativeUtils#setPdfOriginalRepresentation()}
 *
 * <p>HTML template file:
 *
 * <p>Internals: it first creates an HTML document with all the data and then converts it to a PDF.
 *
 * @author Quentin Ligier
 */
public class PdfOriginalRepresentationGenerator extends AbstractNarrativeGenerator {

    private final File templateFile;

    /**
     * Constructor.
     *
     * @param narrativeLanguage The language to use to generate the narrative text.
     * @param htmlTemplateFile  The HTML template file to use; if {@code null}, the default HTML template will be used.
     */
    public PdfOriginalRepresentationGenerator(final NarrativeLanguage narrativeLanguage,
                                              @Nullable final File htmlTemplateFile) throws URISyntaxException {
        super(narrativeLanguage);
        if (htmlTemplateFile != null) {
            this.templateFile = htmlTemplateFile;
        } else {
            final var url = getClass().getClassLoader().getResource("narrative/template.openhtmltopdf.html");
            this.templateFile = new File(Objects.requireNonNull(url).toURI());
        }
    }

    public byte[] generate(final EmedPmlcDocumentDigest digest) {
        final var body = new StringBuilder();

        body.append("<h1>Carte de médication</h1>");
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
            body.append("<h3>Dernier intervenant</h3>");
            body.append(String.format("<p>%s</p>", "Auteur"));
            body.append("</div>");

            if (entry.getTreatmentReason() != null) {
                body.append("<div id='narrative fulfilment_instructions'>");
                body.append("<h3>Raison du traitement</h3>");
                body.append(String.format("<p>%s</p>", StringEscapeUtils.escapeXml(entry.getTreatmentReason())));
                body.append("</div>");
            }
            if (entry.getAnnotationComment() != null) {
                body.append("<div id='narrative annotation_comment'>");
                body.append("<h3>Commentaire</h3>");
                body.append(String.format("<p>%s</p>", StringEscapeUtils.escapeXml(entry.getAnnotationComment())));
                body.append("</div>");
            }
            if (entry.getPatientMedicationInstructions() != null) {
                body.append("<div id='narrative medication_instructions'>");
                body.append("<h3>Instructions de médication</h3>");
                body.append(String.format("<p>%s</p>", StringEscapeUtils.escapeXml(entry.getPatientMedicationInstructions())));
                body.append("</div>");
            }
            if (entry.getFulfilmentInstructions() != null) {
                body.append("<div id='narrative fulfilment_instructions'>");
                body.append("<h3>Instructions de fulfilment</h3>");
                body.append(String.format("<p>%s</p>", StringEscapeUtils.escapeXml(entry.getFulfilmentInstructions())));
                body.append("</div>");
            }

            ++i;
        }

        return new byte[]{};
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
