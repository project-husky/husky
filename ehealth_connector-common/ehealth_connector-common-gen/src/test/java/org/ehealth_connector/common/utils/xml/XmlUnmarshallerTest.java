package org.ehealth_connector.common.utils.xml;

import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.ehealth_connector.common.hl7cdar2.ST;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

import javax.xml.bind.DataBindingException;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.bind.DataBindingException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

/**
 * Tests of the {@link XmlUnmarshaller} class.
 *
 * @author Quentin Ligier
 */
class XmlUnmarshallerTest {
    private static final String URL_TO_FETCH = "https://api.ipify.org/";
    private static final String FILE_TO_FETCH_WINDOWS = "C:/Windows/System32/drivers/etc/hosts";
    private static final String FILE_TO_FETCH_OTHERS = "/etc/hosts";

    /**
     * Support for entities shall be deactivated.
     */
    @Test
    void testEntitySupport() {
        final String xxe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<!DOCTYPE replace [<!ENTITY entity \"VULNERABLE\"> ]>" +
                "<ClinicalDocument xmlns=\"urn:hl7-org:v3\"><title>&entity;</title></ClinicalDocument>";
        Assertions.assertThrows(DataBindingException.class, () -> XmlUnmarshaller.unmarshallStringAsType(xxe, POCDMT000040ClinicalDocument.class));
    }

    /**
     * This attack can be used to perform a deny of service.
     */
    @Test
    void testBillionLaughAttack() {
        final String xxe = """
                <?xml version="1.0" encoding="UTF-8"?><!DOCTYPE data [
                <!ENTITY a0 "dos" >
                <!ENTITY a1 "&a0;&a0;&a0;&a0;&a0;&a0;&a0;&a0;&a0;&a0;">
                <!ENTITY a2 "&a1;&a1;&a1;&a1;&a1;&a1;&a1;&a1;&a1;&a1;">
                <!ENTITY a3 "&a2;&a2;&a2;&a2;&a2;&a2;&a2;&a2;&a2;&a2;">
                ]><ClinicalDocument xmlns="urn:hl7-org:v3"><title>&a3;</title></ClinicalDocument>""";
        Assertions.assertThrows(DataBindingException.class, () -> XmlUnmarshaller.unmarshallStringAsType(xxe, POCDMT000040ClinicalDocument.class));
    }

    @Test
    @EnabledOnOs(WINDOWS)
    void testXxeFileInjectionWindows() {
        final String xxe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<!DOCTYPE foo [ <!ENTITY xxe SYSTEM \"file:///" + FILE_TO_FETCH_WINDOWS + "\"> ]>" +
                "<ClinicalDocument xmlns=\"urn:hl7-org:v3\"><title>&xxe;</title></ClinicalDocument>";
        Assertions.assertThrows(DataBindingException.class, () -> XmlUnmarshaller.unmarshallStringAsType(xxe, POCDMT000040ClinicalDocument.class));
    }

    @Test
    @DisabledOnOs(WINDOWS)
    void testXxeFileInjectionOthers() {
        final String xxe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<!DOCTYPE foo [ <!ENTITY xxe SYSTEM \"file:///" + FILE_TO_FETCH_OTHERS + "\"> ]>" +
                "<ClinicalDocument xmlns=\"urn:hl7-org:v3\"><title>&xxe;</title></ClinicalDocument>";
        Assertions.assertThrows(DataBindingException.class, () -> XmlUnmarshaller.unmarshallStringAsType(xxe, POCDMT000040ClinicalDocument.class));
    }

    @Test
    void testXxeUrlInjection() {
        final String xxe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<!DOCTYPE foo [ <!ENTITY xxe SYSTEM \"" + URL_TO_FETCH + "\"> ]>" +
                "<ClinicalDocument xmlns=\"urn:hl7-org:v3\"><title>&xxe;</title></ClinicalDocument>";
        Assertions.assertThrows(DataBindingException.class, () -> XmlUnmarshaller.unmarshallStringAsType(xxe, POCDMT000040ClinicalDocument.class));
    }

    @Test
    @EnabledOnOs(WINDOWS)
    void testXIncludeFileInjectionWindows() throws ParserConfigurationException {
        final String xxe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<ClinicalDocument xmlns=\"urn:hl7-org:v3\">" +
                "<title xmlns:xi=\"http://www.w3.org/2001/XInclude\"><xi:include parse=\"text\" href=\"file:///" + FILE_TO_FETCH_WINDOWS + "\"/></title>" +
                "</ClinicalDocument>";
        final POCDMT000040ClinicalDocument cda = XmlUnmarshaller.unmarshallStringAsType(xxe, POCDMT000040ClinicalDocument.class);
        assertEquals("", cda.getTitle().xmlContent);
    }

    @Test
    @DisabledOnOs(WINDOWS)
    void testXIncludeFileInjectionOthers() throws ParserConfigurationException {
        final String xxe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<ClinicalDocument xmlns=\"urn:hl7-org:v3\">" +
                "<title xmlns:xi=\"http://www.w3.org/2001/XInclude\"><xi:include parse=\"text\" href=\"file:///" + FILE_TO_FETCH_OTHERS + "\"/></title>" +
                "</ClinicalDocument>";
        final POCDMT000040ClinicalDocument cda = XmlUnmarshaller.unmarshallStringAsType(xxe, POCDMT000040ClinicalDocument.class);
        assertEquals("", cda.getTitle().xmlContent);
    }

    @Test
    void testXIncludeUrlInjection() throws ParserConfigurationException {
        final String xxe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<ClinicalDocument xmlns=\"urn:hl7-org:v3\">" +
                "<title xmlns:xi=\"http://www.w3.org/2001/XInclude\"><xi:include parse=\"text\" href=\"" + URL_TO_FETCH + "\"/></title>" +
                "</ClinicalDocument>";
        final POCDMT000040ClinicalDocument cda = XmlUnmarshaller.unmarshallStringAsType(xxe, POCDMT000040ClinicalDocument.class);
        assertEquals("", cda.getTitle().xmlContent);
    }

    @Test
    void testUnmarshallingString() throws ParserConfigurationException {
        final String title = "Simple title";
        final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<title>" + title + "</title>";
        final ST unmarshalled = XmlUnmarshaller.unmarshallStringAsType(xml, ST.class);
        assertNotNull(unmarshalled);
        assertEquals(title, unmarshalled.xmlContent);
    }

    @Test
    @Disabled
    void testUnmarshallingFile() throws IOException {
        /*final Resource disResource = new ClassPathResource("commons/hl7/cda/ClinicalDocumentHelpersTest/DIS1.xml");
        final POCDMT000040ClinicalDocument cda = XmlUnmarshaller.unmarshallFileAsType(disResource.getFile(),
                POCDMT000040ClinicalDocument.class);
        assertNotNull(cda);*/
    }

}