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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.19
 * Template description: A confidentiality level of a CDA document instance according to the Swiss EPR regulation. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST reference this template.Language dependent references to the Swiss EPR regulation:
 * - en: Federal Act on the Electronic Patient Record (EPRA), FDHA Ordinance on the Electronic Patient Record (EPRO-FDHA), Appendix 3 (Metadata)
 * - de: Bundesgesetz über das elektronische Patientendossier (EPDG), Verordnung des EDI über das elektronische Patientendossier (EPDV-EDI), Anhang 3 (Metadaten)
 * - fr: Loi fédérale sur le dossier électronique du patient (LDEP), Ordonnance du DFI sur le dossier électronique du patient (ODEP-DFI), Annexe 3 (Métadonnées)
 * - it: Legge federale sulla cartella informatizzata del paziente (LCIP), Ordinanza del DFI sulla cartella informatizzata del paziente (OCIP-DFI), Allegato 3 (Metadati)
 *
 * Element description: Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.
 */
public class CdachHeaderDocumentConfidentialityCode extends org.ehealth_connector.common.hl7cdar2.CE {

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachHeaderDocumentConfidentialityCode loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachHeaderDocumentConfidentialityCode loadFromFile(File inputFile) throws JAXBException, IOException {
		CdachHeaderDocumentConfidentialityCode retVal;
		JAXBContext context = JAXBContext.newInstance(CdachHeaderDocumentConfidentialityCode.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachHeaderDocumentConfidentialityCode> root = mar.unmarshal(source, CdachHeaderDocumentConfidentialityCode.class);
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
