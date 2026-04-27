package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.NarrativeFormat;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.SoftwareProviderMetadataProvider;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class PdfPrescriptionGenerator extends ChEmedEprPdfGenerator {

    public PdfPrescriptionGenerator(final NarrativeFormat narrativeFormat,
                                    final String template,
                                    final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(narrativeFormat, template, softwareProviderMetadataProvider);
    }

    public PdfPrescriptionGenerator(final NarrativeFormat narrativeFormat,
                                    final String template,
                                    final SoftwareProviderMetadataProvider softwareProviderMetadataProvider,
                                    final FontFamily fontFamily
                                    )
            throws IOException, ParserConfigurationException {
        super(narrativeFormat, template, softwareProviderMetadataProvider, fontFamily);
    }

    public abstract byte[] generate(final ChEmedEprDocumentPre preDocument,
                                    final NarrativeLanguage lang) throws Exception ;
}
