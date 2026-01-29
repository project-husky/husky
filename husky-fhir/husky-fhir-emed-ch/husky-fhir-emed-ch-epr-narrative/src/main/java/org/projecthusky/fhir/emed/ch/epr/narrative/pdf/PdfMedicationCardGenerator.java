package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import lombok.extern.slf4j.Slf4j;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.*;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Slf4j
public abstract class PdfMedicationCardGenerator extends ChEmedEprPdfGenerator {
    public PdfMedicationCardGenerator(final NarrativeFormat narrativeFormat,
                                      final String template,
                                      final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(narrativeFormat, template, softwareProviderMetadataProvider);
    }

    public PdfMedicationCardGenerator(final NarrativeFormat narrativeFormat,
                                      final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        this(narrativeFormat,
             narrativeFormat == NarrativeFormat.CH_EMED_EPR ?
             getDefaultChEmedEprPdfTemplate() : getDefaultEmediplanPdfTemplate(), softwareProviderMetadataProvider
        );
    }

    public abstract byte[] generate(final ChEmedEprDocumentPmlc pmlcDocument,
                                    final NarrativeLanguage lang) throws Exception ;

    public static String getDefaultChEmedEprPdfTemplate() throws IOException {
        return getTemplate("/narrative/templates/pdfa_pmlc.html");
    }

    public static String getDefaultEmediplanPdfTemplate() {
        return "emediplan/emediplan_pdf";
    }
}
