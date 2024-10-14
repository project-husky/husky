/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

package org.projecthusky.cda.elga.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.JAXBIntrospector;
import javax.xml.parsers.ParserConfigurationException;

import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * This class provides an unmarshaller implementation to read CDA-ELGA clinical
 * documents from their XML representation.
 *
 * @author Quentin Ligier
 */
public class CdaDocumentUnmarshaller {

    /**
     * This class is not instantiable.
     */
    private CdaDocumentUnmarshaller() {
    }

    /**
	 * Unmarshalles a CDA-ELGA document as a specialized
	 * {@link POCDMT000040ClinicalDocument} object.
	 *
	 * @param cdaContent The CDA XML content as a string.
	 * @return the unmarshalled clinical document.
	 * @throws SAXException                if any parse errors occur.
	 * @throws JAXBException
	 */
	public static POCDMT000040ClinicalDocument unmarshall(final String cdaContent) throws SAXException, JAXBException {
        return unmarshall(new InputSource(new StringReader(cdaContent)));
    }

    /**
	 * Unmarshalles a CDA-ELGA document as a specialized
	 * {@link POCDMT000040ClinicalDocument} object.
	 *
	 * @param cdaInputStream The CDA XML content as an {@link InputStream}.
	 * @return the unmarshalled clinical document.
	 * @throws SAXException                if any parse errors occur.
	 * @throws JAXBException
	 */
	public static POCDMT000040ClinicalDocument unmarshall(final InputStream cdaInputStream)
			throws SAXException, JAXBException {
        return unmarshall(new InputSource(cdaInputStream));
    }

    /**
	 * Unmarshalles a CDA-ELGA document as a specialized
	 * {@link POCDMT000040ClinicalDocument} object.
	 *
	 * @param inputSource The CDA XML content as an {@link InputSource}.
	 * @return the unmarshalled clinical document.
	 * @throws SAXException                if any parse errors occur.
	 * @throws JAXBException
	 */
	public static POCDMT000040ClinicalDocument unmarshall(final InputSource inputSource)
			throws SAXException, JAXBException {
		final Document document;
        try {
            document = XmlFactories.newSafeDocumentBuilder().parse(inputSource);
        } catch (final IOException | ParserConfigurationException exception) {
            throw new SAXException("Error while parsing the XML source", exception);
        }

		final Class<? extends POCDMT000040ClinicalDocument> unmarshalledClass = POCDMT000040ClinicalDocument.class;
            final var context = JAXBContext.newInstance(unmarshalledClass);
            final var unmarshaller = context.createUnmarshaller();
            final Object root = unmarshaller.unmarshal(document, unmarshalledClass);
            return unmarshalledClass.cast(JAXBIntrospector.getValue(root));
    }
}
