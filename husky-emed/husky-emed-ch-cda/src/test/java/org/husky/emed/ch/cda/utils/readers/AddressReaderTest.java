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

    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040IntendedRecipient.class;
    private final Unmarshaller UNMARSHALLER;

    public AddressReaderTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testGetStreetAddressLines() throws Exception {
        var addressReader = this.unmarshall("""
                <addr>
                    <country>CH</country>
                    <city>Musterhausen</city>
                    <postalCode>9999</postalCode>
                    <houseNumber>3</houseNumber>
                    <additionalLocator>OG Ost</additionalLocator>
                    <streetAddressLine>Chalet Edelweiss</streetAddressLine>
                    <streetAddressLine>Wegmüller Family</streetAddressLine>
                    <streetName>Wishard Blvd</streetName>
                </addr>
                """);

        assertEquals(2, addressReader.getStreetAddressLines().size());
        assertEquals("Chalet Edelweiss", addressReader.getStreetAddressLines().get(0));
        assertEquals("Wegmüller Family", addressReader.getStreetAddressLines().get(1));
    }

    @Test
    void testGetEmptyStreetAddressLines() throws Exception {
        var addressReader = this.unmarshall("""
                <addr>
                    <country>CH</country>
                    <city>Musterhausen</city>
                    <postalCode>9999</postalCode>
                    <houseNumber>3</houseNumber>
                    <additionalLocator>OG Ost</additionalLocator>
                    <streetName>Wishard Blvd</streetName>
                </addr>
                """);

        assertTrue(addressReader.getStreetAddressLines().isEmpty());
    }


    @Test
    void testGetState() throws Exception {
        var addressReader = this.unmarshall("""
                <addr>
                    <country>CH</country>
                    <city>Musterhausen</city>
                    <postalCode>9999</postalCode>
                    <houseNumber>3</houseNumber>
                    <additionalLocator>OG Ost</additionalLocator>
                    <streetAddressLine>Chalet Edelweiss</streetAddressLine>
                    <streetAddressLine>Wegmüller Family</streetAddressLine>
                    <streetName>Wishard Blvd</streetName>
                </addr>
                """);

        assertFalse(addressReader.getState().isPresent());
    }

    private AddressReader unmarshall(final String addr) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<informationRecipient typeCode=\"PRCP\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "<templateId root=\"2.16.756.5.30.1.1.10.2.4\" />"
                + addr
                + "    <informationRecipient>\n" +
                "          <name>\n" +
                "              <family>Wegmüller</family>\n" +
                "              <given>Monika</given>\n" +
                "          </name>\n" +
                "      </informationRecipient>"
                + "</informationRecipient>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var address = (POCDMT000040IntendedRecipient) JAXBIntrospector.getValue(root);
        return new AddressReader(address.getAddr().get(0));
    }

}
