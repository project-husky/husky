package org.husky.emed.ch.cda.utils.readers;

import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.common.hl7cdar2.POCDMT000040Material;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bench of the {@link ManufacturedMaterialReader}
 *
 * @author Ronaldo Loureiro
 */
class ManufacturedMaterialReaderTest {
    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040Material.class;
    private final Unmarshaller UNMARSHALLER;

    public ManufacturedMaterialReaderTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testMissingName() throws Exception {
        var reader = this.unmarshall("""
                <code code="7680581330012" codeSystem="2.51.1.1" codeSystemName="GTIN" />
                <pharm:formCode code="50040500" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Solution/ solution pour pulvérisation buccale/ laryngopharyngée" />
                <pharm:asContent classCode="CONT">
                    <pharm:containerPackagedMedicine classCode="CONT" determinerCode="INSTANCE">
                        <pharm:code code="7680581330012" codeSystem="2.51.1.1" codeSystemName="GTIN" />
                        <pharm:name>NEO-ANGIN spray av lidocaïne chlorhexidin 50 ml</pharm:name>
                        <pharm:capacityQuantity unit="mL" value="50" />
                    </pharm:containerPackagedMedicine>
                </pharm:asContent>""");

        assertThrows(InvalidEmedContentException.class, reader::getName);
    }

    @Test
    void testBadFormCode() throws Exception {
        var reader = this.unmarshall("""
                <code code="7680581330012" codeSystem="2.51.1.1" codeSystemName="GTIN" />
                <name>NEO-ANGIN spray av lidocaïne chlorhexidin</name>
                <pharm:asContent classCode="CONT">
                    <pharm:containerPackagedMedicine classCode="CONT" determinerCode="INSTANCE">
                        <pharm:code code="7680581330012" codeSystem="2.51.1.1" codeSystemName="GTIN" />
                        <pharm:name>NEO-ANGIN spray av lidocaïne chlorhexidin 50 ml</pharm:name>
                        <pharm:capacityQuantity unit="mL" value="50" />
                    </pharm:containerPackagedMedicine>
                </pharm:asContent>""");

        assertNull(reader.getFormCode());

        reader = this.unmarshall("""
                <code code="7680581330012" codeSystem="2.51.1.1" codeSystemName="GTIN" />
                <name>NEO-ANGIN spray av lidocaïne chlorhexidin</name>
                <pharm:formCode code="00000000" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Solution/ solution pour pulvérisation buccale/ laryngopharyngée" />
                <pharm:asContent classCode="CONT">
                    <pharm:containerPackagedMedicine classCode="CONT" determinerCode="INSTANCE">
                        <pharm:code code="7680581330012" codeSystem="2.51.1.1" codeSystemName="GTIN" />
                        <pharm:name>NEO-ANGIN spray av lidocaïne chlorhexidin 50 ml</pharm:name>
                        <pharm:capacityQuantity unit="mL" value="50" />
                    </pharm:containerPackagedMedicine>
                </pharm:asContent>""");

        assertThrows(InvalidEmedContentException.class, reader::getFormCode);
    }

    @Test
    void testActivePharmaceuticalIngredient() throws Exception {
        var medicationProduct = this.unmarshall("""
                <code code="7680483060499" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="BACTRIM forte cpr 800/160mg"/>
                <name>BACTRIM forte cpr 800/160mg</name>
                <pharm:formCode code="10219000" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Tablet" />
                <pharm:asContent classCode="CONT">
                    <pharm:containerPackagedMedicine classCode="CONT" determinerCode="INSTANCE">
                        <pharm:code code="7680483060499" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="BACTRIM forte cpr 800/160mg"/>
                        <pharm:name>BACTRIM forte cpr 800/160mg</pharm:name>
                        <pharm:capacityQuantity unit="732936001" value="20" />
                    </pharm:containerPackagedMedicine>
                </pharm:asContent>
                <pharm:ingredient classCode="ACTI">
                    <pharm:quantity>
                        <numerator xsi:type="PQ" unit="mg" value="800" />
                        <denominator xsi:type="PQ" unit="732936001" value="1" />
                    </pharm:quantity>
                    <pharm:ingredient classCode="MMAT" determinerCode="KIND">
                        <!-- Without pharm:code -->
                        <pharm:name>Sulfamethoxazole</pharm:name>
                    </pharm:ingredient>
                </pharm:ingredient>
                <pharm:ingredient classCode="ACTI">
                    <pharm:quantity>
                        <numerator xsi:type="PQ" unit="mg" value="160" />
                        <denominator xsi:type="PQ" unit="732936001" value="1" />
                    </pharm:quantity>
                    <pharm:ingredient classCode="MMAT" determinerCode="KIND">
                        <!-- With a non-existent code -->
                        <pharm:code code="000000000" codeSystem="2.16.840.1.113883.6.96" codeSystemName="SNOMED CT" displayName="Trimethoprim (substance)" />
                        <pharm:name>Trimethoprim</pharm:name>
                    </pharm:ingredient>
                </pharm:ingredient>""").toMedicationProduct();

        assertEquals(2, medicationProduct.getIngredients().size());
        assertNull(medicationProduct.getIngredients().get(0).getCode());
        assertNull(medicationProduct.getIngredients().get(1).getCode());
    }

    private ManufacturedMaterialReader unmarshall(final String manufacturerMaterial) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = """
                <manufacturedMaterial classCode="MMAT" determinerCode="KIND" xmlns:pharm="urn:ihe:pharm" xmlns="urn:hl7-org:v3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <templateId root="2.16.756.5.30.1.1.10.4.33" />
                    <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1" />
                    """ + manufacturerMaterial + """
                </manufacturedMaterial>
                """;

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var material = (POCDMT000040Material) JAXBIntrospector.getValue(root);
        return new ManufacturedMaterialReader(material);
    }

}