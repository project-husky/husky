/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.17
 * Template description: Reusable template wherever an assigned entity with required name, addr and telecom is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.
 *
 * Element description: The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
 */
public class CdachOtherAssignedEntityCompilationNameAddrTelecom extends org.ehealth_connector.common.hl7cdar2.CE {

	/**
	 * A translation of the code to another coding system.
	 */
	@XmlElement(name = "hl7:translation")
	private ArrayList<org.ehealth_connector.common.hl7cdar2.CD> hl7Translation;

	/**
	 * Adds a hl7Translation
	 * A translation of the code to another coding system.
	 */
	public void addHl7Translation(org.ehealth_connector.common.hl7cdar2.CD value) {
		if (hl7Translation == null)
			hl7Translation = new ArrayList<org.ehealth_connector.common.hl7cdar2.CD>();
		hl7Translation.add(value);
	}

	/**
	 * Adds a hl7Translation
	 * A translation of the code to another coding system.
	 */
	public void clearHl7Translation() {
		hl7Translation.clear();
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachOtherAssignedEntityCompilationNameAddrTelecom loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachOtherAssignedEntityCompilationNameAddrTelecom loadFromFile(File inputFile) throws JAXBException, IOException {
		CdachOtherAssignedEntityCompilationNameAddrTelecom retVal;
		JAXBContext context = JAXBContext.newInstance(CdachOtherAssignedEntityCompilationNameAddrTelecom.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachOtherAssignedEntityCompilationNameAddrTelecom> root = mar.unmarshal(source, CdachOtherAssignedEntityCompilationNameAddrTelecom.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFileName the full path and filename of the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(String outputFileName) throws JAXBException {
		saveToFile(new File(outputFileName));
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFile the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(File outputFile) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(this.getClass());
		Marshaller mar = context.createMarshaller();
		mar.setProperty("com.sun.xml.bind.namespacePrefixMapper", new CdaNamespacePrefixMapper());
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(this, outputFile);
	}
}
