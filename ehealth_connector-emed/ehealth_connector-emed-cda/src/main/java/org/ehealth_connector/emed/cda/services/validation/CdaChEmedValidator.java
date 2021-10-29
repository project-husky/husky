package org.ehealth_connector.emed.cda.services.validation;

import com.helger.schematron.svrl.jaxb.FailedAssert;
import com.helger.schematron.xslt.SchematronResourceXSLT;
import org.ehealth_connector.common.utils.xml.XmlSchemaValidator;
import org.ehealth_connector.emed.cda.enums.EmedDocumentType;
import org.ehealth_connector.emed.cda.errors.InvalidEmedContentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Validator of the structure of CDA-CH-EMED documents. Two passes are done with the XML Schema and the Schematron
 * definitions.
 * <p>
 * The XML Schema validation is done with the Java XML library. The Schematron validation is done with PhSchematron.
 *
 * @author Quentin Ligier
 */
@Component
public class CdaChEmedValidator {

    private static final Logger log = LoggerFactory.getLogger(CdaChEmedValidator.class);

    /**
     * The path and file name of the XML Schema definition.
     */
    private static final String CCE_XSD_FILE_PATH = "schema/CDA-CH-EMED.xsd";

    /**
     * The path of the directory that contains CDA-CH-EMED XSLT files.
     */
    private static final String CCE_XSLT_PATH = "schematron/0.98.0/";

    /**
     * The patterns to transform the failed asserts location.
     */
    private static final Pattern LOCATION_HL7_PATTERN = Pattern.compile("\\*:([a-zA-Z0-9]+)\\[namespace-uri\\(\\)" +
            "='urn:hl7-org:v3']");
    private static final Pattern LOCATION_PHARM_PATTERN = Pattern.compile("\\*:([a-zA-Z0-9]+)\\[namespace-uri\\(\\)" +
            "='urn:ihe:pharm']");

    /**
     * The XML Schema that instantiates Schema {@link Validator}s.
     */
    private final XmlSchemaValidator schemaValidator;

    /**
     * The Schematron validators.
     */
    private final SchematronResourceXSLT mtpValidator;
    private final SchematronResourceXSLT preValidator;
    private final SchematronResourceXSLT disValidator;
    private final SchematronResourceXSLT padvValidator;
    private final SchematronResourceXSLT pmlValidator;
    private final SchematronResourceXSLT pmlcValidator;

    /**
     * Constructor.
     *
     * @throws IOException  if the XML Schema file is not found.
     * @throws SAXException if the XML Schema document is not valid.
     */
    public CdaChEmedValidator() throws IOException, SAXException {
        this.schemaValidator = new XmlSchemaValidator((new ClassPathResource(CCE_XSD_FILE_PATH)).getURL());

        this.mtpValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-MTP-error.xslt");
        this.preValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-PRE-error.xslt");
        this.disValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-DIS-error.xslt");
        this.padvValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-PADV-error.xslt");
        this.pmlValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-PML-error.xslt");
        this.pmlcValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-PMLC-error.xslt");
    }

    /**
     * Load in memory all schematron XSLT files to optimize the first validation of each type (the XSLT is kept in
     * memory after the first validation). Useful for on-demand validation services.
     */
    public void prewarm() {
        this.mtpValidator.getXSLTProvider();
        this.preValidator.getXSLTProvider();
        this.disValidator.getXSLTProvider();
        this.padvValidator.getXSLTProvider();
        this.pmlValidator.getXSLTProvider();
        this.pmlcValidator.getXSLTProvider();
    }

    /**
     * Validates a CDA-CH-EMED document.
     *
     * @param content The CCE document content as a {@link String}.
     * @throws InvalidEmedContentException if the document content is invalid.
     * @throws FileNotFoundException       if the file does not exist or is not readable.
     * @throws Exception                   if the validation raised an exception.
     */
    public void validate(final String content,
                         final EmedDocumentType type) throws Exception {
        Objects.requireNonNull(content);
        // No need to close the ByteArrayInputStream
        this.validate(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), type);
    }

    /**
     * Validates a CDA-CH-EMED document.
     *
     * @param file The CCE document content as a {@link File}.
     * @throws InvalidEmedContentException if the document content is invalid.
     * @throws IOException                 if an I/O error occurs.
     * @throws Exception                   if the validation raised an exception.
     */
    public void validate(final File file,
                         final EmedDocumentType type) throws Exception {
        Objects.requireNonNull(file);
        if (!file.isFile() || !file.canRead()) {
            throw new FileNotFoundException();
        }
        try (final var inputStream = new FileInputStream(file)) {
            this.validate(inputStream, type);
        }
    }

    /**
     * Validates a CDA-CH-EMED document.
     *
     * @param inputStream The CDA-CH-EMED document content as an {@link InputStream}. It's your responsibility to close
     *                    it.
     * @throws InvalidEmedContentException if the document content is invalid.
     * @throws Exception                   if the validation raised an exception.
     */
    public void validate(final InputStream inputStream,
                         final EmedDocumentType type) throws Exception {
        this.schemaValidator.validate(new StreamSource(inputStream));
        this.validateAgainstSchematron(inputStream, type);
    }

    /**
     * Validates a CDA-CH-EMED document against the Schematron.
     *
     * @param inputStream The CCE document content as an {@link InputStream}.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     * @throws Exception                   if the validation raised an exception.
     */
    private void validateAgainstSchematron(final InputStream inputStream,
                                           final EmedDocumentType type) throws Exception {
        final var validator = this.getSchematronValidator(type);

        final var output = validator.applySchematronValidationToSVRL(new StreamSource(inputStream));
        if (output == null) {
            log.error("The Schematron XSLT '{}' is invalid", validator.getID());
            throw new RuntimeException("The schematron XSLT file is invalid");
        }
        final var failedAssert = (FailedAssert) output.getActivePatternAndFiredRuleAndFailedAssert().stream()
                .filter(FailedAssert.class::isInstance)
                .findAny()
                .orElse(null);
        if (failedAssert != null) {
            String content = "";
            if (failedAssert.getDiagnosticReferenceOrPropertyReferenceOrTextCount() > 0) {
                content = (String) failedAssert.getDiagnosticReferenceOrPropertyReferenceOrTextAtIndex(0);
            }
            String location = failedAssert.getLocation();
            if (location != null) {
                location = location.replace("[1]", "");
                location = LOCATION_HL7_PATTERN.matcher(location).replaceAll("hl7:$1");
                location = LOCATION_PHARM_PATTERN.matcher(location).replaceAll("pharm:$1");
            }
            throw new InvalidEmedContentException("Schematron error: {" + content + "} in {" + location + "}");
        }
    }

    /**
     * Returns the corresponding Schematron validator to a CDA-CH-EMED type.
     *
     * @param type The CDA-CH-EMED type of the document to validate.
     * @return the corresponding validator.
     */
    private SchematronResourceXSLT getSchematronValidator(final EmedDocumentType type) {
        return switch (type) {
            case MTP -> this.mtpValidator;
            case PRE -> this.disValidator;
            case DIS -> this.preValidator;
            case PADV -> this.padvValidator;
            case PML -> this.pmlValidator;
            case PMLC -> this.pmlcValidator;
        };
    }
}
