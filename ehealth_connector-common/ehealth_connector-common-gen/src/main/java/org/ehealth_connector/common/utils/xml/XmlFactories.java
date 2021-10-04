package org.ehealth_connector.common.utils.xml;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFactoryConfigurationException;
import java.net.URL;
import java.util.Objects;

/**
 * Factories for XML-related classes.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class XmlFactories {

    /**
     * This class is not instantiable.
     */
    private XmlFactories() {}

    /**
     * Initializes and configures a {@link DocumentBuilder} that is not vulnerable to XXE injections (XInclude, Billions
     * Laugh Attack, ...).
     *
     * @return a configured {@link DocumentBuilder}.
     * @throws ParserConfigurationException if the parser is not Xerces2 compatible.
     * @see <a href="https://cheatsheetseries.owasp.org/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.html#html#jaxp-documentbuilderfactory-saxparserfactory-and-dom4j">XML
     * External Entity Prevention Cheat Sheet</a>
     * @see <a href="https://wiki.shibboleth.net/confluence/display/OS30/Secure+XML+Processing+Requirements">Secure XML
     * Processing Requirements</a>
     */
    public static DocumentBuilder newSafeDocumentBuilder() throws ParserConfigurationException {
        final var factory = DocumentBuilderFactory.newDefaultInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://apache.org/xml/features/xinclude", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        return factory.newDocumentBuilder();
    }

    /**
     * Initializes and configures a {@link Schema}.
     *
     * @param schema URL that represents a schema.
     * @return a configured {@link Schema}.
     * @throws SAXException if a SAX error occurs during parsing.
     */
    public static Schema newSafeSchema(final URL schema) throws SAXException {
        Objects.requireNonNull(schema);
        final var schemaFactory = SchemaFactory.newDefaultInstance();
        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        return schemaFactory.newSchema(schema);
    }

    /**
     * Initializes and configures a {@link XPath}.
     *
     * @return a configured {@link XPath}.
     * @throws XPathFactoryConfigurationException if the configuration fails.
     */
    public static XPath newSafeXpath() throws XPathFactoryConfigurationException {
        final var xpathFactory = XPathFactory.newDefaultInstance();
        xpathFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        return xpathFactory.newXPath();
    }

    /**
     * Initializes and configures a {@link Transformer}.
     *
     * @return a configured {@link Transformer}.
     * @throws TransformerConfigurationException if it is not possible to create a {@link Transformer} instance.
     */
    public static Transformer newTransformer() throws TransformerConfigurationException {
        final var transformerFactory = TransformerFactory.newDefaultInstance();
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        return transformerFactory.newTransformer();
    }

    /**
     * Initializes and configures a {@link Transformer} from a {@link Source}.
     *
     * @param source The source.
     * @return a configured {@link Transformer}.
     * @throws TransformerConfigurationException if it is not possible to create a {@link Transformer} instance.
     */
    public static Transformer newTransformer(final Source source) throws TransformerConfigurationException {
        Objects.requireNonNull(source);
        final var transformerFactory = TransformerFactory.newDefaultInstance();
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        return transformerFactory.newTransformer(source);
    }
}
