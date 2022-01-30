/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.narrative.pdf;

import com.openhtmltopdf.extend.FSUriResolver;
import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * The implementation of {@link HtmlToPdfAConverter} with the Open HTML to PDF converter library.
 *
 * @author Quentin Ligier
 **/
public class OpenHtmlToPdfAConverter implements HtmlToPdfAConverter {

    /**
     * The list of declared fonts.
     */
    private final List<Font> fonts = new ArrayList<>();

    /**
     * The name of the producer to set in generated PDF documents.
     */
    @Nullable
    private String producerName = null;

    /**
     * The URI resolver to
     */
    @Nullable
    private FSUriResolver uriResolver;

    /**
     * Sets the producer name that will be included in generated PDF documents. Use {@code null} to disable.
     *
     * @param producerName The producer name or {@code null}.
     */
    public void setProducerName(@Nullable final String producerName) {
        this.producerName = producerName;
    }

    /**
     * Gets the producer name.
     */
    @Nullable
    public String getProducerName() {
        return this.producerName;
    }

    /**
     * Declares a new font. Fonts are embedded only when they are used by the converter.
     *
     * @param family      The font family (name).
     * @param weight      The font CSS weight (100-900).
     * @param style       The font style.
     * @param inputStream The font {@link InputStream} supplier. It shall not return {@code null}.
     */
    public void addFont(final String family,
                        final int weight,
                        final BaseRendererBuilder.FontStyle style,
                        final Callable<InputStream> inputStream) {
        this.fonts.add(new Font(family, weight, style, inputStream));
    }

    /**
     * Gets the declared fonts.
     */
    public List<@NonNull Font> getFonts() {
        return this.fonts;
    }

    @Nullable
    public FSUriResolver getUriResolver() {
        return uriResolver;
    }

    public void setUriResolver(@Nullable final FSUriResolver uriResolver) {
        this.uriResolver = uriResolver;
    }

    /**
     * Converts the HTML content to its PDF/A representation.
     *
     * @param htmlContent The HTML content to convert.
     * @return The content of the generated PDF/A.
     */
    @Override
    @SuppressWarnings("java:S2093") // Cannot use try-with-resources with font input streams
    public byte[] convert(String htmlContent) throws IOException {
        final PdfRendererBuilder builder = new PdfRendererBuilder();
        if (this.producerName != null) {
            builder.withProducer(this.producerName);
        }

        builder.useFastMode();
        builder.usePdfAConformance(PdfRendererBuilder.PdfAConformance.PDFA_1_A);
        builder.usePdfUaAccessbility(false);
        if (this.uriResolver != null) {
            builder.useUriResolver(this.uriResolver);
        }

        final List<InputStream> inputStreams = new ArrayList<>();

        final byte[] pdfBytes;
        try {
            for (final var font : this.fonts) {
                final InputStream inputStream;
                try {
                    inputStream = font.inputStream().call();
                } catch (final Exception e) {
                    throw new IllegalArgumentException("The font callable has thrown an exception", e);
                }
                if (inputStream == null) {
                    throw new IllegalArgumentException("The font callable has returned null");
                }
                inputStreams.add(inputStream);
                builder.useFont(() -> inputStream, font.family(), font.weight(), font.style(), true);
            }

            builder.withHtmlContent(htmlContent, "./");
            builder.useColorProfile(ColorProfiles.getSrgbIccProfile());
            final var baosPdf = new ByteArrayOutputStream(); // No need to close it
            builder.toStream(baosPdf);
            builder.run();
            pdfBytes = baosPdf.toByteArray();
        } finally {
            // Clean resources
            for (final var inputStream : inputStreams) {
                inputStream.close();
            }
        }
        return pdfBytes;
    }

    /**
     * Record of a font declaration.
     */
    private record Font(String family,
                        int weight,
                        BaseRendererBuilder.FontStyle style,
                        Callable<InputStream> inputStream) {
    }
}
