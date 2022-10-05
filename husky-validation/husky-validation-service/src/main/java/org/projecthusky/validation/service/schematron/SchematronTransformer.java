package org.projecthusky.validation.service.schematron;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.projecthusky.common.utils.xml.XmlFactories;

import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.io.resource.inmemory.ReadableResourceByteArray;
import com.helger.schematron.sch.SchematronProviderXSLTFromSCH;
import com.helger.schematron.sch.TransformerCustomizerSCH;

/**
 * A transformer from Schematron files ({@code .sch}) to XML Stylesheet Transform files ({@code .xsl}). Schematron
 * validators usually need the transformed XSLT files to execute them against the file to test.
 *
 * <p>The underlying XML {@link Transformer} is not thread safe.
 *
 * @author Quentin Ligier
 */
@NotThreadSafe
public class SchematronTransformer {

    /**
     * The XML transformer.
     */
    private final Transformer xmlTransformer;

    /**
     * Constructor.
     *
     * @throws TransformerConfigurationException if it is not possible to create a {@link Transformer} instance.
     */
    public SchematronTransformer() throws TransformerConfigurationException {
        this.xmlTransformer = XmlFactories.newTransformer();
    }

    /**
     * Transforms a Schematron file to a 'compiled', XSLT file.
     *
     * @param schematronFile The source Schematron ({@code .sch}) file.
     * @param xsltFile       The destination XSLT ({@code .xsl}) file.
     * @throws TransformerException if the XML transformation fails.
     */
    public void convertToXslt(final File schematronFile,
                              final File xsltFile) throws TransformerException, IOException {
        this.convertToXslt(new FileSystemResource(schematronFile), new FileWriter(xsltFile));
    }

    /**
     * Transforms a Schematron content to a 'compiled', XSLT content.
     *
     * @param schematronContent The source Schematron ({@code .sch}) content.
     * @return the content of the transformed XSLT.
     * @throws TransformerException if the XML transformation fails.
     */
    public byte[] convertToXslt(final byte[] schematronContent) throws TransformerException {
        final var stringWriter = new StringWriter();
        final var readableResource = new ReadableResourceByteArray(String.valueOf(Arrays.hashCode(schematronContent))
                , schematronContent);
        this.convertToXslt(readableResource, stringWriter);
        return stringWriter.toString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Transforms a Schematron file to a 'compiled', XSLT content.
     *
     * @param schematronFile The source Schematron ({@code .sch}) file.
     * @return the content of the transformed XSLT.
     * @throws TransformerException if the XML transformation fails.
     */
    public byte[] convertToXslt(final File schematronFile) throws TransformerException {
        final var stringWriter = new StringWriter();
        this.convertToXslt(new FileSystemResource(schematronFile), stringWriter);
        return stringWriter.toString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Transforms a Schematron resource and writes it to an output {@link Writer}.
     *
     * @param readableResource The Schematron resource to transform.
     * @param outputWriter The output writer.
     * @throws TransformerException if the XML transformation fails.
     */
    private void convertToXslt(final IReadableResource readableResource,
                               final Writer outputWriter) throws TransformerException {
        final var transformerCustomizer = new TransformerCustomizerSCH();
        final var xsltTransformer = new SchematronProviderXSLTFromSCH(readableResource, transformerCustomizer);
        this.xmlTransformer.transform(
                new DOMSource(xsltTransformer.getXSLTDocument()),
                new StreamResult(outputWriter)
        );
    }
}
