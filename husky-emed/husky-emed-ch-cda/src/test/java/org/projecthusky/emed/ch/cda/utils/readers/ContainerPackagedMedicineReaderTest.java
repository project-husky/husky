package org.projecthusky.emed.ch.cda.utils.readers;

import org.projecthusky.common.hl7cdar2.POCDMT000040Material;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test bench of the {@link ContainerPackagedMedicineReader}
 *
 * @author Ronaldo Loureiro
 */
class ContainerPackagedMedicineReaderTest {
    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040Material.class;
    private final Unmarshaller UNMARSHALLER;

    public ContainerPackagedMedicineReaderTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testMissingGtinCode() throws Exception {
        var containerPackageMedecine = this.unmarshall("""
                <pharm:containerPackagedMedicine classCode="CONT" determinerCode="INSTANCE">
                    <!-- Missing pharm:code -->
                    <pharm:name>BACTRIM forte cpr 800/160mg</pharm:name>
                    <pharm:capacityQuantity unit="732936001" value="20" />
                </pharm:containerPackagedMedicine>""");

        assertThrows(InvalidEmedContentException.class, containerPackageMedecine::getGtinCode);
    }

    @Test
    void testMissingName() throws Exception {
        var containerPackageMedecine = this.unmarshall("""
                <pharm:containerPackagedMedicine classCode="CONT" determinerCode="INSTANCE">
                    <pharm:code code="7680483060499" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="BACTRIM forte cpr 800/160mg"/>
                    <!-- Missing pharm:name -->
                    <pharm:capacityQuantity unit="732936001" value="20" />
                </pharm:containerPackagedMedicine>""");

        assertNull(containerPackageMedecine.getName());
    }

    @Test
    void testMissingCapacityQuantity() throws Exception {
        var containerPackageMedecine = this.unmarshall("""
                <pharm:containerPackagedMedicine classCode="CONT" determinerCode="INSTANCE">
                    <pharm:code code="7680483060499" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="BACTRIM forte cpr 800/160mg"/>
                    <pharm:name>BACTRIM forte cpr 800/160mg</pharm:name>
                    <!-- Missing pharm:capacityQuantity -->
                </pharm:containerPackagedMedicine>""");

        assertNull(containerPackageMedecine.getCapacityQuantity());
    }

    @Test
    void testBadFormCode() throws Exception {
        var containerPackageMedecine = this.unmarshall("""
                <pharm:containerPackagedMedicine classCode="CONT" determinerCode="INSTANCE">
                    <pharm:code code="7680483060499" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="BACTRIM forte cpr 800/160mg"/>
                    <pharm:name>BACTRIM forte cpr 800/160mg</pharm:name>
                    <pharm:capacityQuantity unit="732936001" value="20" />
                    <!-- Bad pharm:formcode -->
                    <pharm:formCode code="0000000" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Tablet" />
                </pharm:containerPackagedMedicine>""");

        assertThrows(InvalidEmedContentException.class, containerPackageMedecine::getFormCode);
    }

    private ContainerPackagedMedicineReader unmarshall(final String containerPackageMedecine) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = """
                <manufacturedMaterial classCode="MMAT" determinerCode="KIND" xmlns:pharm="urn:ihe:pharm" xmlns="urn:hl7-org:v3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <templateId root="2.16.756.5.30.1.1.10.4.33" />
                    <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1"/>
                    <code code="7680483060499" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="BACTRIM forte cpr 800/160mg"/>
                    <name>BACTRIM forte cpr 800/160mg</name>
                    <pharm:formCode code="10219000" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Tablet" />
                    <pharm:asContent classCode="CONT">
                        """ + containerPackageMedecine + """
                    </pharm:asContent>
                </manufacturedMaterial>
                """;

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var consumable = (POCDMT000040Material) JAXBIntrospector.getValue(root);
        return new ContainerPackagedMedicineReader(consumable.getAsContent().getContainerPackagedMedicine());
    }
}