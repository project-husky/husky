package org.husky.emed.ch.cda.utils.readers;

import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.emed.ch.errors.InvalidEmedContentException;
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
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bench of the {@link AuthorReader}
 *
 * @author Ronaldo Loureiro
 */
class AuthorReaderTest {

    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040Author.class;
    private final Unmarshaller UNMARSHALLER;

    public AuthorReaderTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testInvalidAuthor() {
        // templateId 2.16.756.5.30.1.1.10.9.23 is missing
        var author = """
                <functionCode code="PCP" codeSystem="2.16.840.1.113883.5.88" codeSystemName="Participation Function" displayName="primary care physician" />
                <time value="20111129110000+0100" />
                <assignedAuthor>
                    <id root="2.51.1.3" extension="7601000234438" />
                    <assignedPerson>
                        <name>
                            <family>Hausarzt</family>
                            <given>Familien</given>
                        </name>
                    </assignedPerson>
                </assignedAuthor>""";

        assertThrows(InvalidEmedContentException.class, () -> this.unmarshall(author));
    }

    @Test
    void testMissingAuthorshipTimestamp() throws Exception {
        var author = this.unmarshall("""
                <templateId root="2.16.756.5.30.1.1.10.9.23" />
                <functionCode code="PCP" codeSystem="2.16.840.1.113883.5.88" codeSystemName="Participation Function" displayName="primary care physician" />
                <assignedAuthor>
                    <id root="2.51.1.3" extension="7601000234438" />
                    <assignedPerson>
                        <name>
                            <family>Hausarzt</family>
                            <given>Familien</given>
                        </name>
                    </assignedPerson>
                </assignedAuthor>""");

        assertThrows(InvalidEmedContentException.class, author::getAuthorshipTimestamp);
    }

    @Test
    void testMissingGln() throws Exception {
        var author = this.unmarshall("""
                <templateId root="2.16.756.5.30.1.1.10.9.23" />
                <functionCode code="PCP" codeSystem="2.16.840.1.113883.5.88" codeSystemName="Participation Function" displayName="primary care physician" />
                <time value="20111129110000+0100" />
                <assignedAuthor>
                    <id root="" extension="7601000234438" />
                    <assignedPerson>
                        <name>
                            <family>Hausarzt</family>
                            <given>Familien</given>
                        </name>
                    </assignedPerson>
                </assignedAuthor>""");

        assertThrows(InvalidEmedContentException.class, author::getGln);
    }

    @Test
    void testLegalAcademicTitles() throws Exception {
        var author = this.unmarshall("""
                <templateId root="2.16.756.5.30.1.1.10.9.23" />
                <time value="20111129110000+0100" />
                <assignedAuthor>
                    <id root="2.51.1.3" extension="7601000234438" />
                    <assignedPerson>
                        <name use="L">
                            <prefix qualifier="AC">Prof.</prefix>
                            <family>Wegmüller</family>
                            <given>Monika</given>
                        </name>
                    </assignedPerson>
                </assignedAuthor>""");

        assertTrue(author.getPersonNames().isPresent());
        assertEquals(1, author.getPersonNames().get().getLegalAcademicTitles().size());
        assertEquals("Prof.", author.getPersonNames().get().getLegalAcademicTitles().get(0));

        author = this.unmarshall("""
                <templateId root="2.16.756.5.30.1.1.10.9.23" />
                <time value="20111129110000+0100" />
                <assignedAuthor>
                    <id root="2.51.1.4" extension="7601000234438" />
                    <assignedPerson>
                        <name use="L">
                            <!-- Bad Academic Title -->
                            <prefix qualifier="00">Prof.</prefix>
                            <family>Wegmüller</family>
                            <given>Monika</given>
                        </name>
                    </assignedPerson>
                </assignedAuthor>""");

        assertTrue(author.getPersonNames().isPresent());
        assertEquals(0, author.getPersonNames().get().getLegalAcademicTitles().size());
        assertEquals(1, author.getIds().size());
    }

    @Test
    void testMissingLegalName() throws Exception {
        var author = this.unmarshall("""
                <templateId root="2.16.756.5.30.1.1.10.9.23" />
                <time value="20111129110000+0100" />
                <assignedAuthor>
                    <id root="2.51.1.3" extension="7601000234438" />
                    <assignedPerson>
                        <name use="P">
                            <prefix qualifier="AC">Prof.</prefix>
                            <family>Wegmüller</family>
                            <given>Monika</given>
                        </name>
                    </assignedPerson>
                </assignedAuthor>""");

        assertTrue(author.getPersonNames().isPresent());
        assertThrows(NoSuchElementException.class, () -> author.getPersonNames().get().getLegalAcademicTitles());
    }

    @Test
    void testMissingAssignedAuthor() throws Exception {
        var author = this.unmarshall("""
                <templateId root="2.16.756.5.30.1.1.10.9.23" />
                <time value="20111129110000+0100" />
                <!-- Missing assigned author -->""");

        assertEquals(new TelecomReader(Collections.emptyList()).getWebsiteAddresses(), author.getTelecoms().getWebsiteAddresses());
        assertEquals(new TelecomReader(Collections.emptyList()).getOtherTelecoms(), author.getTelecoms().getOtherTelecoms());
        assertEquals(new TelecomReader(Collections.emptyList()).getFaxNumbers(), author.getTelecoms().getFaxNumbers());
        assertEquals(new TelecomReader(Collections.emptyList()).getMailAddresses(), author.getTelecoms().getMailAddresses());
    }

    private AuthorReader unmarshall(final String authorXML) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<author xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                authorXML +
                "</author>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var author = (POCDMT000040Author) JAXBIntrospector.getValue(root);
        return new AuthorReader(author);
    }

}