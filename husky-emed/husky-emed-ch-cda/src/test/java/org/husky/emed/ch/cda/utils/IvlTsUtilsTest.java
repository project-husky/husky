package org.husky.emed.ch.cda.utils;

import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
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
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link IiUtils} class.
 *
 * @author Ronaldo Loureiro
 */
class IvlTsUtilsTest {

    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040SubstanceAdministration.class;
    private final Unmarshaller UNMARSHALLER;

    public IvlTsUtilsTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testGetExclusiveLowInstant() throws Exception {
        IVLTS ivlts = this.createIvlts("""
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <high value="20220310120000+0100" />
                </effectiveTime>""");

        assertEquals(Instant.parse("2022-01-10T11:00:01.00Z").toEpochMilli(),
                IvlTsUtils.getExclusiveLowInstant(ivlts).toEpochMilli());
    }

    @Test
    void testGetExclusiveHighInstant() throws Exception {
        IVLTS ivlts = this.createIvlts("""
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <high value="20220310120000+0100" />
                </effectiveTime>""");

        assertEquals(Instant.parse("2022-03-10T10:59:59.00Z").toEpochMilli(),
                IvlTsUtils.getExclusiveHighInstant(ivlts).toEpochMilli());
    }

    @Test
    void testGetWidth() throws Exception {
        IVLTS ivlts = this.createIvlts("""
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <width value="5184000" unit="s"/>
                </effectiveTime>""");

        assertEquals(Duration.ofSeconds(5184000).toSeconds(), IvlTsUtils.getWidth(ivlts).get(ChronoUnit.SECONDS));

        ivlts = this.createIvlts("""
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <width value="8640" unit="min"/>
                </effectiveTime>""");

        assertEquals(Duration.ofMinutes(8640).toSeconds(), IvlTsUtils.getWidth(ivlts).get(ChronoUnit.SECONDS));

        ivlts = this.createIvlts("""
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <width value="144" unit="h"/>
                </effectiveTime>""");

        assertEquals(Duration.ofHours(144).toSeconds(), IvlTsUtils.getWidth(ivlts).get(ChronoUnit.SECONDS));

        ivlts = this.createIvlts("""
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <width unit="s"/>
                </effectiveTime>""");

        IVLTS finalIvlts = ivlts;
        assertThrows(IllegalArgumentException.class, () -> IvlTsUtils.getWidth(finalIvlts));

        ivlts = this.createIvlts("""
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <width value="144" unit="unknown"/>
                </effectiveTime>""");

        IVLTS finalIvlts1 = ivlts;
        assertThrows(IllegalArgumentException.class, () -> IvlTsUtils.getWidth(finalIvlts1));

        ivlts = this.createIvlts("""
                <effectiveTime xsi:type="IVL_TS">
                    <low value="20220110120000+0100" />
                    <high value="20220310120000+0100" />
                </effectiveTime>""");

        assertNull(IvlTsUtils.getWidth(ivlts));
    }

    private IVLTS createIvlts(String effectiveTime) throws ParserConfigurationException, JAXBException, IOException, SAXException {
        final var completeElement = "<substanceAdministration classCode=\"SBADM\" moodCode=\"INT\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "<templateId root=\"1.3.6.1.4.1.19376.1.9.1.3.6\" />"
                + effectiveTime
                + "</substanceAdministration>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var substanceAdministration = (POCDMT000040SubstanceAdministration) JAXBIntrospector.getValue(root);
        return (IVLTS) substanceAdministration.getEffectiveTime().get(0);
    }
}