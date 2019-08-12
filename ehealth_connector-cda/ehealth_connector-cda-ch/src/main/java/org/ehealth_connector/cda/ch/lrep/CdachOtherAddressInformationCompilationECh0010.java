/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.lrep;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.ehealth_connector.common.CdaNamespacePrefixMapper;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.35 Template
 * description: Address information according to the eCH-0010 V7.0
 * addressInformation data type. CDA-CH V2 derivatives, i.e. Swiss exchange
 * formats MAY use this template by either reference or specialisation.See
 * https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0010&amp;documentVersion=7.0
 * for more information.
 *
 * Element description: Free additional lines for additional address information
 * which can not be used in the other address fields (e.g. for c/o entries,
 * etc.), with a maximum length of 150 characters.addressLine1 should be used
 * for personalized addressing (e.g., c/o-Address).
 */
public class CdachOtherAddressInformationCompilationECh0010
		extends org.ehealth_connector.common.hl7cdar2.ADXP {

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException\n@throws IOException Signals that an I/O
	 *            exception has occurred.
	 */
	public static CdachOtherAddressInformationCompilationECh0010 loadFromFile(File inputFile)
			throws JAXBException, IOException {
		CdachOtherAddressInformationCompilationECh0010 retVal;
		JAXBContext context = JAXBContext
				.newInstance(CdachOtherAddressInformationCompilationECh0010.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachOtherAddressInformationCompilationECh0010> root = mar.unmarshal(source,
				CdachOtherAddressInformationCompilationECh0010.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFileName
	 *            the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException
	 *         Signals that an I/O exception has occurred.
	 */
	public static CdachOtherAddressInformationCompilationECh0010 loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Saves the current CDA document to file.
	 *
	 * @param outputFile
	 *            the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(File outputFile) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(this.getClass());
		Marshaller mar = context.createMarshaller();
		mar.setProperty("com.sun.xml.bind.namespacePrefixMapper", new CdaNamespacePrefixMapper());
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(this, outputFile);
	}

	/**
	 * Saves the current CDA document to file.
	 *
	 * @param outputFileName
	 *            the full path and filename of the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(String outputFileName) throws JAXBException {
		saveToFile(new File(outputFileName));
	}
}
