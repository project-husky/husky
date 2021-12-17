package org.husky.emed.cda.xml;

import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.emed.cda.generated.artdecor.*;
import org.husky.emed.errors.InvalidEmedContentException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Objects;

/**
 * This class provides an unmarshaller implementation to read CDA-CH-EMED clinical documents from their XML
 * representation.
 *
 * @author Quentin Ligier
 */
public class CceDocumentUnmarshaller {

    /**
     * This class is not instantiable.
     */
    private CceDocumentUnmarshaller() {
    }

    /**
     * Unmarshalles a CDA-CH-EMED document as a specialized {@link POCDMT000040ClinicalDocument} object.
     *
     * <ul>
     * <li>A PML document will be unmarshalled as {@link MedicationListDocument}.
     * <li>A PMLC document will be unmarshalled as {@link MedicationCardDocument}.
     * <li>An MTP document will be unmarshalled as {@link MedicationTreatmentPlanDocument}.
     * <li>A PRE document will be unmarshalled as {@link MedicationPrescriptionDocument}.
     * <li>A DIS document will be unmarshalled as {@link MedicationDispenseDocument}.
     * <li>A PADV document will be unmarshalled as {@link PharmaceuticalAdviceDocument}.
     * </ul>
     *
     * @param cdaContent The CDA XML content as a string.
     * @return the unmarshalled clinical document.
     * @throws SAXException                if any parse errors occur.
     * @throws InvalidEmedContentException if the CDA-CH-EMED document is invalid.
     */
    public static POCDMT000040ClinicalDocument unmarshall(final String cdaContent) throws SAXException,
            InvalidEmedContentException {
        Objects.requireNonNull(cdaContent);
        return unmarshall(new InputSource(new StringReader(cdaContent)));
    }

    /**
     * Unmarshalles a CDA-CH-EMED document as a specialized {@link POCDMT000040ClinicalDocument} object.
     *
     * <ul>
     * <li>A PML document will be unmarshalled as {@link MedicationListDocument}.
     * <li>A PMLC document will be unmarshalled as {@link MedicationCardDocument}.
     * <li>An MTP document will be unmarshalled as {@link MedicationTreatmentPlanDocument}.
     * <li>A PRE document will be unmarshalled as {@link MedicationPrescriptionDocument}.
     * <li>A DIS document will be unmarshalled as {@link MedicationDispenseDocument}.
     * <li>A PADV document will be unmarshalled as {@link PharmaceuticalAdviceDocument}.
     * </ul>
     *
     * @param cdaInputStream The CDA XML content as an {@link InputStream}.
     * @return the unmarshalled clinical document.
     * @throws SAXException                if any parse errors occur.
     * @throws InvalidEmedContentException if the CDA-CH-EMED document is invalid.
     */
    public static POCDMT000040ClinicalDocument unmarshall(final InputStream cdaInputStream) throws SAXException,
            InvalidEmedContentException {
        Objects.requireNonNull(cdaInputStream);
        return unmarshall(new InputSource(cdaInputStream));
    }

    /**
     * Unmarshalles a CDA-CH-EMED document as a specialized {@link POCDMT000040ClinicalDocument} object.
     *
     * <ul>
     * <li>A PML document will be unmarshalled as {@link MedicationListDocument}.
     * <li>A PMLC document will be unmarshalled as {@link MedicationCardDocument}.
     * <li>An MTP document will be unmarshalled as {@link MedicationTreatmentPlanDocument}.
     * <li>A PRE document will be unmarshalled as {@link MedicationPrescriptionDocument}.
     * <li>A DIS document will be unmarshalled as {@link MedicationDispenseDocument}.
     * <li>A PADV document will be unmarshalled as {@link PharmaceuticalAdviceDocument}.
     * </ul>
     *
     * @param inputSource The CDA XML content as an {@link InputSource}.
     * @return the unmarshalled clinical document.
     * @throws SAXException                if any parse errors occur.
     * @throws InvalidEmedContentException if the CDA-CH-EMED document is invalid.
     */
    public static POCDMT000040ClinicalDocument unmarshall(final InputSource inputSource) throws SAXException,
            InvalidEmedContentException {
        Objects.requireNonNull(inputSource);
        final Document document;
        try {
            document = XmlFactories.newSafeDocumentBuilder().parse(inputSource);
        } catch (final IOException | ParserConfigurationException exception) {
            throw new SAXException("Error while parsing the XML source", exception);
        }

        final Class<? extends POCDMT000040ClinicalDocument> unmarshalledClass = getUnmarshalledClass(document);
        try {
            final var context = JAXBContext.newInstance(unmarshalledClass);
            final var unmarshaller = context.createUnmarshaller();
            final Object root = unmarshaller.unmarshal(document, unmarshalledClass);
            return unmarshalledClass.cast(JAXBIntrospector.getValue(root));
        } catch (final JAXBException exception) {
            throw new InvalidEmedContentException("Error while unmarshalling the XML document", exception);
        }
    }

    /**
     * Returns the class as which the document will be unmarshalled from the main template ID.
     *
     * @param xmlDocument The parsed XML document.
     * @return the unmarshalled class.
     */
    private static Class<? extends POCDMT000040ClinicalDocument> getUnmarshalledClass(final Document xmlDocument) {
        final var nodes = xmlDocument.getDocumentElement().getElementsByTagNameNS("urn:hl7-org:v3", "templateId");
        Class<? extends POCDMT000040ClinicalDocument> returnClass;
        for (int i = 0; i < nodes.getLength(); ++i) {
            if (nodes.item(i) instanceof final Element element) {
                returnClass = switch (element.getAttribute("root")) {
                    case "2.16.756.5.30.1.1.10.1.7" -> MedicationTreatmentPlanDocument.class;
                    case "2.16.756.5.30.1.1.10.1.4" -> MedicationPrescriptionDocument.class;
                    case "2.16.756.5.30.1.1.10.1.5" -> MedicationDispenseDocument.class;
                    case "2.16.756.5.30.1.1.10.1.6" -> PharmaceuticalAdviceDocument.class;
                    case "2.16.756.5.30.1.1.10.1.13" -> MedicationListDocument.class;
                    case "2.16.756.5.30.1.1.10.1.3" -> MedicationCardDocument.class;
                    default -> null;
                };
                if (returnClass != null) {
                    return returnClass;
                }
            }
        }
        throw new InvalidEmedContentException("The type of the CDA-CH-EMED could not be evaluated");
    }
}
