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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.62
 * Template description: The document MUST contain a title. The following translations of the LOINC codes specified in XD-LAB MUST be used:Multidisciplinary reports<table><tbody><tr><th>LOINC Code</th><th>Text</th></tr><tr><td>11502-2</td><td>[ge]: Multidisziplinäre Befunde[fr]: Résultats multidisciplinaires[it]: Risultati multidisciplinari</td></tr></tbody></table>Findings of a particular disciplineThe same translations as for Laboratory Speciality Section are to be used.
 *
 * Element description: The document title must follow the following text format where &lt;human readable code&gt; is the local translation of the document LOINC code:
 * - [de]: 'Laborbefund - &lt;human readable code&gt;'
 * - [fr]: 'Rapport de laboratoire - &lt;human readable code&gt;'
 * - [it]: 'Referto di laboratorio - &lt;human readable code&gt;'
 * - [en]: 'Laboratory report - &lt;human readable code&gt;'
 */
public class CdachlrepHeaderDocumentTitle extends org.ehealth_connector.common.hl7cdar2.ST {

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachlrepHeaderDocumentTitle loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachlrepHeaderDocumentTitle loadFromFile(File inputFile) throws JAXBException, IOException {
		CdachlrepHeaderDocumentTitle retVal;
		JAXBContext context = JAXBContext.newInstance(CdachlrepHeaderDocumentTitle.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachlrepHeaderDocumentTitle> root = mar.unmarshal(source, CdachlrepHeaderDocumentTitle.class);
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
