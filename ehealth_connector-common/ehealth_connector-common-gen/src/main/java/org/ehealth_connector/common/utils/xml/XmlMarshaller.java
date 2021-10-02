package org.ehealth_connector.common.utils.xml;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Objects;

/**
 * This class provides a marshaller implementation to convert various objects into their XML representation.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class XmlMarshaller {

    /**
     * This class is not instantiable.
     */
    private XmlMarshaller() {
    }

    /**
     * Marshalles an object to a {@link String}.
     *
     * @param object The object to marshall.
     * @return the XML representation of the {@code object}.
     * @throws JAXBException if an error was encountered while creating the marshaller.
     */
    public static String marshall(final Object object) throws JAXBException {
        Objects.requireNonNull(object);
        final var jaxbContext = JAXBContext.newInstance(object.getClass());
        final var marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        final var writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }
}
