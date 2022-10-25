package org.projecthusky.emed.ch.cda.utils.readers;

import org.projecthusky.common.hl7cdar2.POCDMT000040AuthoringDevice;
import org.projecthusky.common.utils.xml.XmlFactories;
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
 * Test bench of the {@link DeviceReader}
 *
 * @author Ronaldo Loureiro
 */
class DeviceReaderTest {
    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040AuthoringDevice.class;
    private final Unmarshaller UNMARSHALLER;

    public DeviceReaderTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testDeviceReader() throws Exception {
        var authoringDevice = this.unmarshall("""
                <manufacturerModelName>4.0</manufacturerModelName>
                <softwareName>New generation KIS</softwareName>""");

        assertNotNull(authoringDevice);
        assertTrue(authoringDevice.getManufacturerModelName().isPresent());
        assertEquals("4.0", authoringDevice.getManufacturerModelName().get());
        assertEquals("New generation KIS", authoringDevice.getSoftwareName());
    }

    private DeviceReader unmarshall(final String authoringDevice) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = """
                <assignedAuthoringDevice xmlns="urn:hl7-org:v3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    """ + authoringDevice + """
                </assignedAuthoringDevice>
                """;

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var device = (POCDMT000040AuthoringDevice) JAXBIntrospector.getValue(root);
        return new DeviceReader(device);
    }
}