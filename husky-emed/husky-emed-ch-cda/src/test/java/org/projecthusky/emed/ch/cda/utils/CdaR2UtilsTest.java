package org.projecthusky.emed.ch.cda.utils;

import org.projecthusky.common.hl7cdar2.*;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
import org.projecthusky.emed.ch.models.common.EmedReference;
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
 * Tests of the {@link CdaR2Utils} class.
 *
 * @author Ronaldo Loureiro
 */
class CdaR2UtilsTest {

    private final Unmarshaller UNMARSHALLER;

    final String DIR_E_HEALTH_SUISSE = "/eHealthSuisse/v1.0/";
    final String DIR_SAMPLES_BY_HAND = "/Samples/ByHand/";

    public CdaR2UtilsTest() throws JAXBException {
        final var context = JAXBContext.newInstance(POCDMT000040Entry.class);

        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testGetSingleNonNullMixedOrThrow() throws Exception {
        var ingredients = this.unmarshall("""
                        <substanceAdministration classCode="SBADM" moodCode="INT">
                            <consumable>
                                <manufacturedProduct classCode="MANU">
                                    <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.2" />
                                    <templateId root="2.16.840.1.113883.10.20.1.53" />
                                    <manufacturedMaterial classCode="MMAT" determinerCode="KIND">
                                        <templateId root="2.16.756.5.30.1.1.10.4.33" />
                                        <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1"/>
                                        <pharm:ingredient classCode="ACTI">
                                            <pharm:quantity>
                                                <numerator xsi:type="PQ" unit="mg" value="800" />
                                                <denominator xsi:type="PQ" unit="732936001" value="1" />
                                            </pharm:quantity>
                                            <pharm:ingredient classCode="MMAT" determinerCode="KIND">
                                                <pharm:code code="363528007" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Sulfamethoxazole (substance)" />
                                                <pharm:name>Sulfamethoxazole</pharm:name>
                                            </pharm:ingredient>
                                        </pharm:ingredient>
                                    </manufacturedMaterial>
                                </manufacturedProduct>
                            </consumable>
                        </substanceAdministration>""")
                .getSubstanceAdministration()
                .getConsumable()
                .getManufacturedProduct()
                .getManufacturedMaterial()
                .getIngredient();

        assertEquals(1, ingredients.size());
        assertEquals("Sulfamethoxazole",
                CdaR2Utils.getSingleNonNullMixedOrThrow(ingredients.get(0).getIngredient().getValue().getName().get(0)));
        assertThrows(IllegalArgumentException.class,
                () -> CdaR2Utils.getSingleNonNullMixedOrThrow(ingredients.get(0).getQuantity().getNumerator()));

        ingredients.get(0).getIngredient().getValue().getName().get(0).setXmlMixed((String) null);
        assertThrows(IllegalArgumentException.class,
                () -> CdaR2Utils.getSingleNonNullMixedOrThrow(ingredients.get(0).getIngredient().getValue().getName().get(0)));
    }

    @Test
    void testGetSingleNullableMixedOrThrow() throws Exception {
        var substanceAdmin = this.unmarshall("""
                <substanceAdministration classCode="SBADM" moodCode="INT">
                    <text>
                        <reference value="#mtp.content" />
                    </text>
                    <consumable>
                        <manufacturedProduct classCode="MANU">
                            <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.2" />
                            <templateId root="2.16.840.1.113883.10.20.1.53" />
                            <manufacturedMaterial classCode="MMAT" determinerCode="KIND">
                                <templateId root="2.16.756.5.30.1.1.10.4.33" />
                                <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1"/>
                                <code code="7680483060499" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="BACTRIM forte cpr 800mg"/>
                                <pharm:ingredient classCode="ACTI">
                                    <pharm:quantity>
                                        <numerator xsi:type="PQ" unit="mg" value="800" />
                                        <denominator xsi:type="PQ" unit="732936001" value="1" />
                                    </pharm:quantity>
                                    <pharm:ingredient classCode="MMAT" determinerCode="KIND">
                                        <pharm:code code="363528007" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Sulfamethoxazole (substance)" />
                                        <pharm:name>Sulfamethoxazole</pharm:name>
                                    </pharm:ingredient>
                                </pharm:ingredient>
                            </manufacturedMaterial>
                        </manufacturedProduct>
                    </consumable>
                </substanceAdministration>""").getSubstanceAdministration();

        var ingredients = substanceAdmin.getConsumable().getManufacturedProduct().getManufacturedMaterial().getIngredient();

        assertEquals(1, ingredients.size());
        assertNull(CdaR2Utils.getSingleNullableMixedOrThrow(null));
        assertNull(CdaR2Utils.getSingleNullableMixedOrThrow(ingredients.get(0).getQuantity().getDenominator()));

        assertThrows(IllegalArgumentException.class,
                () -> CdaR2Utils.getSingleNullableMixedOrThrow(substanceAdmin.getText()));

        assertEquals("Sulfamethoxazole",
                CdaR2Utils.getSingleNullableMixedOrThrow(ingredients.get(0).getIngredient().getValue().getName().get(0)));

        ingredients.get(0).getIngredient().getValue().getName().get(0).setXmlMixed((String) null);
        assertNull(CdaR2Utils.getSingleNullableMixedOrThrow(ingredients.get(0).getIngredient().getValue().getName().get(0)));
    }

    @Test
    void testSupplyToEmedReference() throws Exception {
        var supply1 = this.unmarshall("""
                <supply classCode="SPLY" moodCode="EVN">
                    <id root="D0000000-0000-0000-0000-000000000001" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="D0000000-0000-0000-0000-000000000001"/>
                        </externalDocument>
                    </reference>
                </supply>""").getSupply();

        assertEquals(EmedReference.class, CdaR2Utils.toEmedReference(supply1).getClass());

        var supply2 = this.unmarshall("""
                <supply classCode="SPLY" moodCode="EVN">
                    <!-- Missing Id -->
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="D0000000-0000-0000-0000-000000000001"/>
                        </externalDocument>
                    </reference>
                </supply>""").getSupply();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(supply2));

        var supply3 = this.unmarshall("""
                <supply classCode="SPLY" moodCode="EVN">
                    <id root="D0000000-0000-0000-0000-000000000001" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="INVALID ID"/>
                        </externalDocument>
                    </reference>
                </supply>""").getSupply();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(supply3));


        var supply4 = this.unmarshall("""
                <supply classCode="SPLY" moodCode="EVN">
                    <id root="D0000000-0000-0000-0000-000000000001" />
                    <!-- Missing reference -->
                </supply>""").getSupply();

        assertInstanceOf(EmedReference.class, CdaR2Utils.toEmedReference(supply4));

        var supply5 = this.unmarshall("""
                <supply classCode="SPLY" moodCode="EVN">
                    <!-- Multiple IDs -->
                    <id root="D0000000-0000-0000-0000-000000000001" />
                    <id root="D0000000-0000-0000-0000-000000000002" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="D0000000-0000-0000-0000-000000000001"/>
                        </externalDocument>
                    </reference>
                </supply>""").getSupply();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(supply5));
    }

    @Test
    void testObservationToEmedReference() throws Exception {
        var obs1 = this.unmarshall("""
                <observation classCode="OBS" moodCode="EVN">
                    <id root="0AD00000-0000-0000-0000-000000000006" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="0AD00000-0000-0000-0000-000000000006"/>
                        </externalDocument>
                    </reference>
                </observation>""").getObservation();

        assertEquals(EmedReference.class, CdaR2Utils.toEmedReference(obs1).getClass());

        var obs2 = this.unmarshall("""
                <observation classCode="OBS" moodCode="EVN">
                    <!-- Missing ID -->
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="0AD00000-0000-0000-0000-000000000006"/>
                        </externalDocument>
                    </reference>
                </observation>""").getObservation();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(obs2));

        var obs3 = this.unmarshall("""
                <observation classCode="OBS" moodCode="EVN">
                    <id root="0AD00000-0000-0000-0000-000000000006" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="INVALID ID"/>
                        </externalDocument>
                    </reference>
                </observation>""").getObservation();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(obs3));

        var obs4 = this.unmarshall("""
                <observation classCode="OBS" moodCode="EVN">
                    <id root="0AD00000-0000-0000-0000-000000000006" />
                    <!-- Missing Reference -->
                </observation>""").getObservation();

        assertThrows(IllegalArgumentException.class, () -> CdaR2Utils.toEmedReference(obs4));

        var obs5 = this.unmarshall("""
                <observation classCode="OBS" moodCode="EVN">
                    <!-- Multiple IDs -->
                    <id root="0AD00000-0000-0000-0000-000000000006" />
                    <id root="0AD00000-0000-0000-0000-000000000007" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="0AD00000-0000-0000-0000-000000000006"/>
                        </externalDocument>
                    </reference>
                </observation>""").getObservation();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(obs5));
    }

    @Test
    void testSubstanceAdministrationToEmedReference() throws Exception {
        var substanceAdmin1 = this.unmarshall("""
                <substanceAdministration classCode="SBADM" moodCode="INT">
                    <id root="00000000-0000-0000-0000-000000000002" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="00000000-0000-0000-0000-000000000002"/>
                        </externalDocument>
                    </reference>
                </substanceAdministration>""").getSubstanceAdministration();

        assertEquals(EmedReference.class, CdaR2Utils.toEmedReference(substanceAdmin1).getClass());

        var substanceAdmin2 = this.unmarshall("""
                <substanceAdministration classCode="SBADM" moodCode="INT">
                    <!-- Missing ID -->
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="00000000-0000-0000-0000-000000000002"/>
                        </externalDocument>
                    </reference>
                </substanceAdministration>""").getSubstanceAdministration();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(substanceAdmin2));

        var substanceAdmin3 = this.unmarshall("""
                <substanceAdministration classCode="SBADM" moodCode="INT">
                    <id root="00000000-0000-0000-0000-000000000002" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="INVALID ID"/>
                        </externalDocument>
                    </reference>
                </substanceAdministration>""").getSubstanceAdministration();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(substanceAdmin3));

        var substanceAdmin4 = this.unmarshall("""
                <substanceAdministration classCode="SBADM" moodCode="INT">
                    <id root="00000000-0000-0000-0000-000000000002" />
                    <!-- Missing Reference -->
                </substanceAdministration>""").getSubstanceAdministration();

        assertEquals(EmedReference.class, CdaR2Utils.toEmedReference(substanceAdmin4).getClass());

        var substanceAdmin5 = this.unmarshall("""
                <substanceAdministration classCode="SBADM" moodCode="INT">
                    <!-- Multiple IDs -->
                    <id root="00000000-0000-0000-0000-000000000002" />
                    <id root="00000000-0000-0000-0000-000000000003" />
                    <reference typeCode="XCRPT">
                        <externalDocument>
                            <id root="00000000-0000-0000-0000-000000000002"/>
                        </externalDocument>
                    </reference>
                </substanceAdministration>""").getSubstanceAdministration();

        assertThrows(InvalidEmedContentException.class, () -> CdaR2Utils.toEmedReference(substanceAdmin5));
    }

    @Test
    void testGetContentSection() throws SAXException {
        assertTrue(CdaR2Utils.getContentSection(this.loadDoc(DIR_SAMPLES_BY_HAND + "mtp/valid/MTP_01_valid.xml")).isPresent());
        assertTrue(CdaR2Utils.getContentSection(this.loadDoc(DIR_E_HEALTH_SUISSE + "2-6-MedicationPrescription.xml")).isPresent());
        assertTrue(CdaR2Utils.getContentSection(this.loadDoc(DIR_E_HEALTH_SUISSE + "2-4-MedicationDispense.xml")).isPresent());
        assertTrue(CdaR2Utils.getContentSection(this.loadDoc(DIR_E_HEALTH_SUISSE + "2-2-PharmaceuticalAdvice.xml")).isPresent());
        assertTrue(CdaR2Utils.getContentSection(this.loadDoc(DIR_E_HEALTH_SUISSE + "2-1-MedicationList.xml")).isPresent());
        assertTrue(CdaR2Utils.getContentSection(this.loadDoc(DIR_E_HEALTH_SUISSE + "2-7-MedicationCard.xml")).isPresent());
        assertFalse(CdaR2Utils.getContentSection(this.loadDoc(DIR_SAMPLES_BY_HAND + "pmlc/invalid/PMLC_01_invalid.xml")).isPresent());
    }

    private POCDMT000040Entry unmarshall(String entryContent) throws ParserConfigurationException, JAXBException, IOException, SAXException {
        final var completeElement = """
                <entry xmlns:pharm="urn:ihe:pharm" xmlns="urn:hl7-org:v3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">""" +
                    entryContent + """
                </entry>""";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, POCDMT000040Entry.class);
        return (POCDMT000040Entry) JAXBIntrospector.getValue(root);
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CdaR2UtilsTest.class.getResourceAsStream("/CDA-CH-EMED" +
                docName));
    }
}