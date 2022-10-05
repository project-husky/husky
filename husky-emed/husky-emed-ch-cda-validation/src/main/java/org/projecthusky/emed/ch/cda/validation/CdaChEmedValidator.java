/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.cda.validation;

import com.helger.commons.exception.InitializationException;
import com.helger.schematron.svrl.jaxb.FailedAssert;
import com.helger.schematron.svrl.jaxb.SchematronOutputType;
import com.helger.schematron.xslt.SchematronResourceXSLT;
import net.sf.saxon.xpath.XPathFactoryImpl;
import org.apache.cxf.common.xmlschema.LSInputImpl;
import org.projecthusky.common.utils.Sources;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.emed.ch.enums.CceDocumentType;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
import org.projecthusky.validation.service.pdf.PdfA12Validator;
import org.projecthusky.validation.service.schema.XmlSchemaValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.verapdf.core.ValidationException;
import org.verapdf.pdfa.results.TestAssertion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.annotation.concurrent.ThreadSafe;
import javax.xml.namespace.NamespaceContext;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Validator of the structure of CDA-CH-EMED documents. Two passes are done with the XML Schema and the Schematron
 * definitions.
 * <p>
 * The XML Schema validation is done with the Java XML library. The Schematron validation is done with ph-schematron.
 *
 * @author Quentin Ligier
 */
@Component
@ThreadSafe
public class CdaChEmedValidator {
    private static final Logger log = LoggerFactory.getLogger(CdaChEmedValidator.class);

    /**
     * The path and file name of the XML Schema definition.
     */
    public static final String CCE_XSD_PATH = "/schema/";

    /**
     * The path of the directory that contains CDA-CH-EMED XSLT files.
     */
    public static final String CCE_XSLT_PATH = "schematron/1.0.2/";

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
     * The PDF/A-1 or PDF/A-2 validator.
     */
    private final PdfA12Validator pdfValidator;

    /**
     * The XPath expression used to extract the PDF representation of the CDA-CH-EMED document.
     */
    private final XPathExpression pdfXpathExpression;

    /**
     * Returns the XML Schema validator for CDA-CH-EMED documents.
     *
     * @return an XML Schema validator.
     * @throws SAXException if an error arises while parsing the XML Schema.
     */
    public static XmlSchemaValidator getXmlSchemaValidator() throws SAXException {
        final LSResourceResolver resourceResolver = (type, namespaceURI, publicId, systemId, baseURI) -> {
            String path = null;
            if (systemId.endsWith("COCT_MT230100UV_extPHARM.xsd")) {
                path = "extPHARM/COCT_MT230100UV_extPHARM.xsd";
            } else if (systemId.endsWith("COCT_MT440001UV09_extPHARM.xsd")) {
                path = "extPHARM/COCT_MT440001UV09_extPHARM.xsd";
            } else if (systemId.endsWith("hl7v3_extPHARM.xsd")) {
                path = "extPHARM/hl7v3_extPHARM.xsd";
            } else if (systemId.endsWith("POCD_MT000040_extPHARM.xsd")) {
                path = "extPHARM/POCD_MT000040_extPHARM.xsd";
            } else if (systemId.endsWith("datatypes.xsd")) {
                path = "coreschemas/datatypes.xsd";
            } else if (systemId.endsWith("datatypes-base.xsd")) {
                path = "coreschemas/datatypes-base.xsd";
            } else if (systemId.endsWith("narrative-block.xsd")) {
                path = "coreschemas/narrative-block.xsd";
            } else if (systemId.endsWith("voc.xsd")) {
                path = "coreschemas/voc.xsd";
            }
            final var inputStream = CdaChEmedValidator.class.getResourceAsStream(CCE_XSD_PATH + path);
            return new LSInputImpl(null, path, Objects.requireNonNull(inputStream));
        };

        return new XmlSchemaValidator(Sources.fromInputStream(
                        CdaChEmedValidator.class.getResourceAsStream(CCE_XSD_PATH + "CDA-CH-EMED.xsd")),
                false, true, resourceResolver);
    }

    /**
     * Constructor.
     *
     * @throws IOException              if the XML Schema file is not found.
     * @throws SAXException             if the XML Schema document is not valid.
     * @throws XPathExpressionException if the XPath expression is not valid.
     */
    public CdaChEmedValidator() throws IOException, SAXException, XPathExpressionException {
        this.schemaValidator = getXmlSchemaValidator();

        this.mtpValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-MTP-error.xslt", getClass().getClassLoader());
        this.preValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-PRE-error.xslt", getClass().getClassLoader());
        this.disValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-DIS-error.xslt", getClass().getClassLoader());
        this.padvValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-PADV-error.xslt", getClass().getClassLoader());
        this.pmlValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-PML-error.xslt", getClass().getClassLoader());
        this.pmlcValidator = SchematronResourceXSLT.fromClassPath(CCE_XSLT_PATH + "cdachemed-PMLC-error.xslt", getClass().getClassLoader());

        this.pdfValidator = new PdfA12Validator();
        final var xPath = new XPathFactoryImpl().newXPath();
        xPath.setNamespaceContext(new NamespaceContext() {
            @Override
            public String getNamespaceURI(final String prefix) {
                return "urn:hl7-org:v3";
            }

            @Override
            public String getPrefix(final String namespaceURI) {
                return "hl7";
            }

            @Override
            public Iterator<String> getPrefixes(final String namespaceURI) {
                throw new UnsupportedOperationException();
            }
        });
        // Saxon's XPathExpression is thread-safe
        this.pdfXpathExpression = xPath.compile("//hl7:ClinicalDocument/hl7:component/hl7:structuredBody/"
                + "hl7:component/hl7:section[hl7:templateId[@root=\"2.16.756.5.30.1.1.10.3.45\"]]/hl7:entry/"
                + "hl7:observationMedia[hl7:templateId[@root=\"2.16.756.5.30.1.1.10.4.83\"]]/hl7:value/text()");
    }

    /**
     * Load in memory all schematron XSLT files to optimize the first validation of each type (the XSLT is kept in
     * memory after the first validation). Useful for on-demand validation services.
     */
    public void prewarm() {
        log.debug("Force-compiling all XSLT resources");
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
                         final CceDocumentType type) throws Exception {
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
                         final CceDocumentType type) throws Exception {
        Objects.requireNonNull(file);
        if (!file.isFile() || !file.canRead()) {
            throw new FileNotFoundException();
        }
        try (final var fileInputStream = new FileInputStream(file)) {
            this.validate(fileInputStream, type);
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
                         final CceDocumentType type) throws Exception {
        final var document = XmlFactories.newSafeDocumentBuilder().parse(inputStream);
        this.validate(new DOMSource(document), type);
    }

    /**
     * Validates a CDA-CH-EMED document.
     *
     * @param source The CDA-CH-EMED document content as a {@link DOMSource}.
     * @throws InvalidEmedContentException if the document content is invalid.
     * @throws IllegalArgumentException    if the {@link DOMSource} doesn't contain a {@link Document}.
     * @throws Exception                   if the validation raised an exception.
     */
    public void validate(final DOMSource source,
                         final CceDocumentType type) throws Exception {
        if (!(source.getNode() instanceof final Document document)) {
            throw new IllegalArgumentException("The DOMSource does not contain a Document");
        }
        final var report = this.schemaValidator.validate(source);
        SAXParseException exception = null;
        if (report.getFatalError() != null) {
            exception = report.getFatalError();
        } else if (!report.getErrors().isEmpty()) {
            exception = report.getErrors().get(0);
        }
        if (exception != null) {
            throw new InvalidEmedContentException("Schema error: " + exception.getMessage(), exception);
        }
        this.validateAgainstSchematron(source, type);
        this.validatePdfRepresentation(document.getDocumentElement());
    }

    /**
     * Validates a CDA-CH-EMED document against the Schematron.
     *
     * @param cceSource The CCE document content as a {@link DOMSource}.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     * @throws Exception                   if the validation raised an exception.
     */
    void validateAgainstSchematron(final DOMSource cceSource,
                                   final CceDocumentType type) throws Exception {
        final var validator = this.getSchematronValidator(type);
        final SchematronOutputType output = validator.applySchematronValidationToSVRL(cceSource);
        if (output == null) {
            log.error("The Schematron XSLT '{}' is invalid", validator.getID());
            throw new InitializationException("The schematron XSLT file is invalid");
        }

        final var failedAssert = (FailedAssert) output.getActivePatternAndFiredRuleAndFailedAssert().stream()
                .filter(FailedAssert.class::isInstance)
                .findAny()
                .orElse(null);
        if (failedAssert != null) {
            String content = "";
            if (failedAssert.getDiagnosticReferenceOrPropertyReferenceOrTextCount() > 0) {
                content = String.valueOf(failedAssert.getDiagnosticReferenceOrPropertyReferenceOrTextAtIndex(0));
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
     * Extracts a PDF representation of a CDA-CH-EMED file and validates it against conformance levels A-1 or A-2.
     */
    synchronized void validatePdfRepresentation(final Element cceElement) throws ValidationException, IOException,
            XPathExpressionException {
        final byte[] pdf = Optional.ofNullable(this.pdfXpathExpression.evaluate(cceElement, XPathConstants.STRING))
                .map(String.class::cast)
                .filter(string -> !string.isBlank())
                .map(String::strip)
                .map(string -> string.getBytes(StandardCharsets.UTF_8))
                .map(bytes -> Base64.getDecoder().decode(bytes))
                .orElse(null);
        if (pdf == null) {
            log.debug("No PDF has been found in the CDA-CH-EMED document");
            return;
        }
        final var result = this.pdfValidator.validate(pdf);
        if (!result.isCompliant()) {
            final String message = result.getTestAssertions().stream()
                    .filter(assertion -> assertion.getStatus() == TestAssertion.Status.FAILED)
                    .findAny()
                    .map(TestAssertion::getMessage)
                    .orElse("unknown error");
            throw new InvalidEmedContentException("PDF validation error: " + message);
        }
    }

    /**
     * Returns the corresponding Schematron validator to a CDA-CH-EMED type.
     *
     * @param type The CDA-CH-EMED type of the document to validate.
     * @return the corresponding validator.
     */
    SchematronResourceXSLT getSchematronValidator(final CceDocumentType type) {
        return switch (type) {
            case MTP -> this.mtpValidator;
            case PRE -> this.preValidator;
            case DIS -> this.disValidator;
            case PADV -> this.padvValidator;
            case PML -> this.pmlValidator;
            case PMLC -> this.pmlcValidator;
        };
    }
}
