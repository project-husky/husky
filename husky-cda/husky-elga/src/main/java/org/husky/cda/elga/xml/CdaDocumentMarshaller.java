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

package org.husky.cda.elga.xml;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * This class provides a marshaller implementation to convert CDA-ELGA documents
 * to their XML representation.
 *
 * @author Quentin Ligier
 */
public class CdaDocumentMarshaller {

    /**
     * This class is not instantiable.
     */
    private CdaDocumentMarshaller() {
    }

    /**
	 * Marshalles a CDA-ELGA document to a {@link String}.
	 *
	 * @param clinicalDocument The CDA-ELGA document to marshall.
	 * @param stylesheet       name of stylesheet
	 * @return the XML representation of the {@code clinicalDocument}.
	 * @throws JAXBException if an error was encountered while creating the
	 *                       marshaller.
	 */
	public static String marshall(final POCDMT000040ClinicalDocument clinicalDocument, String stylesheet)
			throws JAXBException {
        final var jaxbContext = JAXBContext.newInstance(clinicalDocument.getClass());
        final var marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders",
				String.format("<?xml-stylesheet type='text/xsl' href='%s' ?>", stylesheet));

		/*
		 * marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); // Remove the
		 * marshaller XML declaration
		 */

		final var writer = new StringWriter();
		/*
		 * writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); // This is
		 * required by the CCE spec
		 */
        marshaller.marshal(clinicalDocument, writer);
        return writer.toString();
    }
}
