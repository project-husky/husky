/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import com.openhtmltopdf.extend.FSCacheEx;
import com.openhtmltopdf.extend.FSCacheValue;
import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.openhtmltopdf.slf4j.Slf4jLogger;
import com.openhtmltopdf.util.XRLog;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * The implementation of {@link HtmlToPdfAConverter} with the Open HTML to PDF converter library.
 *
 * @author Quentin Ligier
 **/
@Slf4j
public class OpenHtmlToPdfAConverter implements HtmlToPdfAConverter {

    /**
     * The list of declared fonts.
     */
    private final List<Font> fonts = new ArrayList<>();

    /**
     * The name of the producer to set in generated PDF documents.
     */
    @Nullable
    private String producerName;

    /**
     * A {@link Consumer} of {@link PdfRendererBuilder} to customize it before the PDF generation.
     */
    @Nullable
    private Consumer<PdfRendererBuilder> pdfRendererBuilderConsumer;

    /**
     * The Thymeleaf template engine.
     */
    @Getter
    private final TemplateEngine templateEngine;

    /**
     * Constructor.
     */
    public OpenHtmlToPdfAConverter() {
        XRLog.setLoggerImpl(new Slf4jLogger());

        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(new StringTemplateResolver());
    }

    /**
     * Gets the producer name.
     */
    @Nullable
    public String getProducerName() {
        return this.producerName;
    }

    /**
     * Sets the producer name that will be included in generated PDF documents. Use {@code null} to disable.
     *
     * @param producerName The producer name or {@code null}.
     */
    public void setProducerName(@Nullable final String producerName) {
        this.producerName = producerName;
    }

    /**
     * Declares a new font. Fonts are embedded in the PDF document only when they are used by the converter.
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
    public Consumer<PdfRendererBuilder> getPdfRendererBuilderConsumer() {
        return this.pdfRendererBuilderConsumer;
    }

    public void setPdfRendererBuilderConsumer(@Nullable final Consumer<PdfRendererBuilder> pdfRendererBuilderConsumer) {
        this.pdfRendererBuilderConsumer = pdfRendererBuilderConsumer;
    }

    @Override
    @SuppressWarnings("java:S2093") // Cannot use try-with-resources with font input streams
    public byte[] convert(final NarrativeLanguage lang,
                          final Map<String, Object> contextVariables,
                          final String templateContent) {
        // Prepare the full HTML content
        final var context = new Context();
        context.setVariable("lang", lang);
        contextVariables.forEach(context::setVariable);
        context.setLocale(lang.getLocale());
        final var htmlContent = this.templateEngine.process(templateContent, context);

        // Prepare the PDF generator
        final PdfRendererBuilder builder = new PdfRendererBuilder();
        if (this.producerName != null) {
            builder.withProducer(this.producerName);
        }
        builder.useFastMode();
        builder.usePdfAConformance(PdfRendererBuilder.PdfAConformance.PDFA_1_A);
        builder.usePdfUaAccessibility(false);
        if (this.pdfRendererBuilderConsumer != null) {
            this.pdfRendererBuilderConsumer.accept(builder);
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
            builder.useCacheStore(PdfRendererBuilder.CacheStore.PDF_FONT_METRICS, new FontCache());

            builder.withHtmlContent(htmlContent, "./");
            builder.useColorProfile(ColorProfiles.getSrgbIccProfile());
            final var baosPdf = new ByteArrayOutputStream(); // No need to close it
            builder.toStream(baosPdf);
            builder.run();
            pdfBytes = baosPdf.toByteArray();
        } catch (final IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            // Clean resources
            for (final var inputStream : inputStreams) {
                try {
                    inputStream.close();
                } catch(final IOException ex) {
                    log.error("Failed to close input stream.");
                }
            }
        }
        return pdfBytes;
    }

    /**
     * Record of a font declaration.
     */
    public record Font(String family,
                       int weight,
                       BaseRendererBuilder.FontStyle style,
                       Callable<InputStream> inputStream) {
    }

    /**
     * Implementation of a font cache.
     */
    public static class FontCache implements FSCacheEx<String, FSCacheValue> {
        private final Map<String, FSCacheValue> cache = new HashMap<>(4);

        @Override
        public void put(final String s, final FSCacheValue fsCacheValue) {
            Objects.requireNonNull(s, "s shall not be null in put()");
            Objects.requireNonNull(fsCacheValue, "fsCacheValue shall not be null in put()");
            this.cache.put(s, fsCacheValue);
        }

        @Override
        public FSCacheValue get(final String s, final Callable<? extends FSCacheValue> callable) {
            return Optional.ofNullable(this.get(s))
                    .orElseGet(() -> {
                        try {
                            return callable.call();
                        } catch (final Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

        @Override
        @Nullable
        public FSCacheValue get(final String s) {
            return this.cache.get(s);
        }
    }
}
