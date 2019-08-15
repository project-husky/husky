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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.lrep.v133;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Hl7CdaR2Util;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.1.10
 * Template description: Swiss Laboratory Report - General Report
 *
 * Element description: Swiss Laboratory Report - General ReportConformity rules that are not further modelled in ART-DECOR:
 * - XML encodingUTF-8 encoding is required. All CDA-CH V2 documents MUST start with this line:&lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * - Phone numbersPhone numbers MUST be declared in the international format.Dots (.) MUST be used as separators for grouping of number blocks.The minus sign (-) MUST be used as a separator between public and internal telephone numbers. Purpose: Some telephone exchanges - especially in the US, allow direct dial-up of an internal telephone number after the actual connection has been established over the public telephone network.Examples:&lt;telecom value="tel:+41.33.123.45.67"/&gt;&lt;telecom value="tel:+1.987.654.3210-999"/&gt;
 */
@XmlRootElement(name = "ClinicalDocument", namespace = "urn:hl7-org:v3")
public class CdaChLrepGrV1 extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

	/**
	 * Sets the version number to 1 and makes sure the setId is the same as the document id.
	 * @param newDocId the new doc id
	 */
	public void initFirstVersion(Identificator newDocId) {
		Identificator docId = newDocId;
		if (docId == null)
			docId = new Identificator(Identificator.builder().withRoot(org.openhealthtools.ihe.utils.UUID.generate()).build());
		super.setId(docId.getHl7CdaR2Ii());
		setVersion(docId, 1);
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException the JAXB exception\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdaChLrepGrV1 loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException the JAXB exception\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdaChLrepGrV1 loadFromFile(File inputFile) throws JAXBException, IOException {
		CdaChLrepGrV1 retVal;
		JAXBContext context = JAXBContext.newInstance(CdaChLrepGrV1.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdaChLrepGrV1> root = mar.unmarshal(source, CdaChLrepGrV1.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFileName the full path and filename of the destination file.
	 * @throws JAXBException the JAXB exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws TransformerException the transformer exception
	 */
	public void saveToFile(String outputFileName) throws JAXBException, ParserConfigurationException, TransformerException {
		saveToFile(new File(outputFileName), null, null);
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFile the destination file.
	 * @throws JAXBException the JAXB exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws TransformerException the transformer exception
	 */
	public void saveToFile(File outputFile) throws JAXBException, ParserConfigurationException, TransformerException {
		saveToFile(outputFile, null, null);
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFileName the full path and filename of the destination file.
	 * @param xsl the path and filename or url to the rendering stylesheet
	 * @param css the path and filename or url to the rendering css
	 * @throws JAXBException the JAXB exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws TransformerException the transformer exception
	 */
	public void saveToFile(String outputFileName, String xsl, String css) throws JAXBException, ParserConfigurationException, TransformerException {
		saveToFile(new File(outputFileName), xsl, css);
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFile the destination file.
	 * @param xsl the path and filename or url to the rendering stylesheet
	 * @param css the path and filename or url to the rendering css
	 * @throws JAXBException the JAXB exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws TransformerException the transformer exception
	 */
	public void saveToFile(File outputFile, String xsl, String css) throws JAXBException, ParserConfigurationException, TransformerException {
		CdaUtil.saveJaxbObjectToFile(this, outputFile, xsl, css);
	}

	/**
	 * <div class="en">Sets the document set Id and version number.</div>
	 *
	 * <div class="de">Weist dem Dokument eine Set Id und eine Versionsnummer zu.</div>
	 * @param idVersion1 the set Id (if null, the document ID will be used)
	 * @param version the version of the document
	 */
	public void setVersion(Identificator idVersion1, int version) {
		super.setSetId(idVersion1.getHl7CdaR2Ii());
		super.setVersionNumber(Hl7CdaR2Util.createHl7CdaR2Int(version));
	}
}
