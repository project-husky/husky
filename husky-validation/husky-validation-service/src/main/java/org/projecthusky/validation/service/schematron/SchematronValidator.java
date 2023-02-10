package org.projecthusky.validation.service.schematron;

import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.io.resource.inmemory.ReadableResourceByteArray;
import com.helger.schematron.api.xslt.AbstractSchematronXSLTBasedResource;
import com.helger.schematron.xslt.SchematronResourceXSLT;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.Arrays;

/**
 * A Schematron validator for XML files.
 *
 * <p>The underlying Schematron validator is not thread-safe.
 *
 * @author Quentin Ligier
 */
@NotThreadSafe
public class SchematronValidator {

    /**
     * The Schematron validator.
     */
    private final AbstractSchematronXSLTBasedResource<?> validator;

    /**
     * Constructs a Schematron validator.
     *
     * <p>Beware to only pass {@link IReadableResource} instances that have a unique resource ID or all instances of
     * the validator will use the same XSLT resource (internals use the resource ID as a key for caching).
     *
     * @param xsltResource The XSLT resource.
     * @throws IllegalArgumentException if the Schematron resource is invalid.
     */
    public SchematronValidator(final IReadableResource xsltResource) {
        this.validator = new SchematronResourceXSLT(xsltResource);
        if (!this.validator.isValidSchematron()) {
            throw new IllegalArgumentException("The Schematron resource is invalid");
        }
        if ("byte[]".equals(xsltResource.getResourceID())) {
            throw new IllegalArgumentException("The resource shall have a unique resource ID or the validator will " +
                    "get confused");
        }
    }

    /**
     * Constructs a Schematron validator from a XSLT file ({@code .xsl}).
     *
     * @param xsltFile The XSLT file.
     * @throws IllegalArgumentException if the Schematron resource is invalid.
     */
    public SchematronValidator(final File xsltFile) {
        this(new FileSystemResource(xsltFile));
    }

    /**
     * Constructs a Schematron validator from the content of a XSLT file ({@code .xsl}).
     *
     * @param xsltContent The XSLT file content.
     * @throws IllegalArgumentException if the Schematron resource is invalid.
     */
    public SchematronValidator(final byte[] xsltContent) {
        this(new ReadableResourceByteArray(String.valueOf(Arrays.hashCode(xsltContent)), xsltContent));
    }

    /**
     * Constructs a Schematron validator from a Schematron file ({@code .sch}).
     *
     * <p>If you are often using this method, you should consider transforming the Schematron file with the
     * {@link SchematronTransformer} and storing the result as it is an expensive operation.
     *
     * @param schematronFile The Schematron file.
     * @return the constructed Schematron validator.
     * @throws TransformerException     if the Schematron content transformation fails.
     * @throws IllegalArgumentException if the Schematron resource is invalid.
     */
    public static SchematronValidator fromSchematronFile(final File schematronFile) throws TransformerException {
        final var transformer = new SchematronTransformer();
        return new SchematronValidator(transformer.convertToXslt(schematronFile));
    }

    /**
     * Constructs a Schematron validator from a Schematron content ({@code .sch}).
     *
     * <p>If you are often using this method, you should consider transforming the Schematron content with the
     * {@link SchematronTransformer} and storing the result as it is an expensive operation.
     *
     * @param schematronContent The Schematron content.
     * @return the constructed Schematron validator.
     * @throws TransformerException     if the Schematron content transformation fails.
     * @throws IllegalArgumentException if the Schematron resource is invalid.
     */
    public static SchematronValidator fromSchematronContent(final byte[] schematronContent) throws TransformerException {
        final var transformer = new SchematronTransformer();
        return new SchematronValidator(transformer.convertToXslt(schematronContent));
    }

    /**
     * Performs the Schematron validation of an XML content.
     *
     * @param source The source of the XML content to validate. You can use {@link org.projecthusky.common.utils.Sources} to
     *               convert different objects to {@link Source}s.
     * @return the SVRL object containing the result. May be {@code null} when interpreting the Schematron failed.
     * @throws Exception in case the transformation somehow goes wrong.
     */
    @Nullable
    public SchematronReport validate(final Source source) throws Exception {
        final var result = this.validator.applySchematronValidationToSVRL(source);
        if (result == null) {
            return null;
        } else {
            final var ret = new SchematronReport();
            result.cloneTo(ret);
            return ret;
        }
    }
}
