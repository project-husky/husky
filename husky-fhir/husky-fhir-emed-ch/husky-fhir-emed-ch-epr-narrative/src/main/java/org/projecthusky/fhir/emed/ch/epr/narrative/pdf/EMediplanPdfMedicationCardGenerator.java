package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.ChEmedEprTemplateResolver;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.NarrativeFormat;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.SoftwareProviderMetadataProvider;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EMediplanPdfMedicationCardGenerator extends PdfMedicationCardGenerator {

    public EMediplanPdfMedicationCardGenerator(final String template,
                                               final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(NarrativeFormat.EMEDIPLAN, template, softwareProviderMetadataProvider);
    }

    public EMediplanPdfMedicationCardGenerator(final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(NarrativeFormat.EMEDIPLAN, softwareProviderMetadataProvider);
        /* When using the default emediplan template, we need the internal template resolver since there are fragments
           within the PDF template.
         */
        pdfConverter.getTemplateEngine().setTemplateResolver(ChEmedEprTemplateResolver.get());
    }

    public byte[] generate(final ChEmedEprDocumentPmlc pmlcDocument, final NarrativeLanguage lang) {
        final var body = this.htmlNarrativeGenerator.generate(pmlcDocument, lang);

        final var bookmarks = new HashMap<String, String>(4, 0.75f);
        bookmarks.put("Carte de médication", "#header");
        bookmarks.put("Traitements actifs", "#active-treatments");
        bookmarks.put("Traitements en réserve", "#asneeded-treatments");

        final Map<String, Object> contextVariables = Map.of(
                "subject", formatHumanName(pmlcDocument.resolvePatient().resolveName()),
                "author", "Author", // TODO implement
                "description", "Une carte de médication pour le sujet, générée à la demande",
                "title", "Carte de médication",
                "bookmarks", bookmarks,
                "resource", pmlcDocument,
                "qrcode", "QRCODE PLACEHOLDER", // TODO replace with actual qr code
                "softwareMetadata", softwareProviderMetadata,
                "content", body
        );

        final var pdf = this.pdfConverter.convert(
                lang,
                contextVariables,
                template);
        validatePDF(pmlcDocument, pdf);
        return pdf;
    }
}
