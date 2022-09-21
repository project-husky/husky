package org.husky.emed.ch.cda.utils.readers;

import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.xml.XmlFactories;
import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bench of the {@link AddressReader}
 *
 * @author Ronaldo Loureiro
 */
class AddressReaderTest {

    private final static Class<?> UNMARSHALLED_CLASS = AD.class;
    private final Unmarshaller UNMARSHALLER;

    public AddressReaderTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testFullAddress() throws Exception {
        final var addressReader = this.unmarshall("""
                <country>CH</country>
                <city>Musterhausen</city>
                <postalCode>9999</postalCode>
                <additionalLocator>OG Ost</additionalLocator>
                <streetAddressLine>Chalet Edelweiss</streetAddressLine>
                <streetAddressLine>Wegmüller Family</streetAddressLine>
                <state>GE</state>
                <postBox>1234</postBox>
                """);

        assertEquals(2, addressReader.getStreetAddressLines().size());
        assertEquals("Chalet Edelweiss", addressReader.getStreetAddressLines().get(0));
        assertEquals("Wegmüller Family", addressReader.getStreetAddressLines().get(1));
        assertEquals("CH", addressReader.getCountry().orElse(null));
        assertEquals("Musterhausen", addressReader.getCity().orElse(null));
        assertEquals("9999", addressReader.getPostalCode().orElse(null));
        assertEquals("GE", addressReader.getState().orElse(null));
        assertEquals("1234", addressReader.getPostbox().orElse(null));
        assertEquals("OG Ost", addressReader.getAdditionalLocator().orElse(null));
    }

    @Test
    void testEmptyAddress() throws Exception {
        final var addressReader = this.unmarshall("");

        assertTrue(addressReader.getStreetAddressLines().isEmpty());
        assertTrue(addressReader.getAdditionalLocator().isEmpty());
        assertTrue(addressReader.getCity().isEmpty());
        assertTrue(addressReader.getCountry().isEmpty());
        assertTrue(addressReader.getPostbox().isEmpty());
        assertTrue(addressReader.getPostalCode().isEmpty());
        assertTrue(addressReader.getState().isEmpty());
    }

    @Test
    void testNullFlavorAddress() throws Exception {
        final var addressReader = this.unmarshall("""
                <country nullFlavor="UNK"/>
                <city nullFlavor="UNK"/>
                <postalCode nullFlavor="UNK"/>
                <additionalLocator nullFlavor="UNK"/>
                <streetAddressLine nullFlavor="UNK"/>
                <state nullFlavor="UNK"/>
                <postBox nullFlavor="UNK"/>
                """);

        assertTrue(addressReader.getStreetAddressLines().isEmpty());
        assertTrue(addressReader.getAdditionalLocator().isEmpty());
        assertTrue(addressReader.getCity().isEmpty());
        assertTrue(addressReader.getCountry().isEmpty());
        assertTrue(addressReader.getPostbox().isEmpty());
        assertTrue(addressReader.getPostalCode().isEmpty());
        assertTrue(addressReader.getState().isEmpty());
    }

    private AddressReader unmarshall(final String addr) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<addr xsi:type=\"AD\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3" +
                ".org/2001/XMLSchema-instance\">"
                + addr
                + "</addr>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var address = (AD) JAXBIntrospector.getValue(root);
        return new AddressReader(address);
    }
}
