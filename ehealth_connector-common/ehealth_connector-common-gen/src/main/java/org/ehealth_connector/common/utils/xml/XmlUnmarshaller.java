package org.ehealth_connector.common.utils.xml;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

/**
 * This class provides an unmarshaller implementation to read various objects from their XML representation.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class XmlUnmarshaller {

    /**
     * This class is not instantiable.
     */
    private XmlUnmarshaller() {
    }

    /**
     * Unmarshalles an object of type {@code <T>} from its XML representation given as a string.
     *
     * @param xmlContent The XML content.
     * @param returnType The type of object to unmarshall.
     * @param <T>        The type of object to unmarshall.
     * @return an object of type {@code <T>}.
     * @throws DataBindingException         if the unmarshalling fails because of the content.
     * @throws ParserConfigurationException if the unmarshalling fails because of the parser.
     */
    public static <T> T unmarshallStringAsType(final String xmlContent,
                                               final Class<T> returnType) throws ParserConfigurationException {
        return unmarshallAsType(new InputSource(new StringReader(xmlContent)), returnType);
    }

    /**
     * Unmarshalles an object of type {@code <T>} from an XML file.
     *
     * @param xmlFile    The XML file.
     * @param returnType The type of object to unmarshall.
     * @param <T>        The type of object to unmarshall.
     * @return an object of type {@code <T>}.
     * @throws DataBindingException         if the unmarshalling fails because of the content.
     * @throws ParserConfigurationException if the unmarshalling fails because of the parser.
     * @throws FileNotFoundException        if the file does not exist.
     * @throws IOException                  if an I/O error occurs.
     */
    public static <T> T unmarshallFileAsType(final File xmlFile,
                                             final Class<T> returnType) throws IOException, ParserConfigurationException {
        try (final var is = new FileInputStream(xmlFile)) {
            return unmarshallAsType(new InputSource(is), returnType);
        }
    }

    /**
     * Unmarshalles an object of type {@code <T>} from a {@link InputSource}.
     *
     * @param inputSource The source of the XML representation to unmarshall.
     * @param returnType  The type of object to unmarshall.
     * @param <T>         The type of object to unmarshall.
     * @return an object of type {@code <T>}.
     * @throws DataBindingException         if the unmarshalling fails because of the content.
     * @throws ParserConfigurationException if the unmarshalling fails because of the parser.
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshallAsType(final InputSource inputSource,
                                         final Class<T> returnType) throws ParserConfigurationException {
        try {
            final Document document = XmlFactories.newSafeDocumentBuilder().parse(inputSource);
            final var context = JAXBContext.newInstance(returnType);
            final var unmarshaller = context.createUnmarshaller();
            final Object root = unmarshaller.unmarshal(document, returnType);
            return (T) JAXBIntrospector.getValue(root); // Unchecked cast
        } catch (final JAXBException | SAXException | IOException exception) {
            throw new DataBindingException("Error while parsing", exception);
        }
    }
}
