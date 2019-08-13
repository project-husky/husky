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
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.59
 * Template description: Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
 *
 * Element description: Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
 */
public class CdachlrepHeaderAuthor extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Author {

	public CdachlrepHeaderAuthor() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.59"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.9.23"));
	}

	/**
	 * Creates fixed contents for hl7FunctionCode
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7FunctionCodeFixedValue(String nullFlavor, String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7AssignedAuthor
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedAuthor getHl7AssignedAuthor() {
		return super.assignedAuthor;
	}

	/**
	 * Gets the hl7FunctionCode
	 * The functionCode MUST be taken from the Swiss EPR Value-Set for author roles. See FDHA Ordinance on the Electronic Patient Record (EPRO-FDHA), Appendix 3: Metadata, Section 2.1.If the desired functionCode is not available in the Swiss EPR Value-Set for author roles, nullFlavor='NAV' MUST be used. In this case, the originalText element MUST contain the description of the role.Translations to other vocabularies are allowed.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7FunctionCode() {
		return super.functionCode;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getTemplateId() != null)
			if (super.getTemplateId().size() > 0)
				retVal = super.getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Time
	 * Date and time of the laboratory report creation.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7Time() {
		return super.time;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachlrepHeaderAuthor loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachlrepHeaderAuthor loadFromFile(File inputFile) throws JAXBException, IOException {
		CdachlrepHeaderAuthor retVal;
		JAXBContext context = JAXBContext.newInstance(CdachlrepHeaderAuthor.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachlrepHeaderAuthor> root = mar.unmarshal(source, CdachlrepHeaderAuthor.class);
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

	/**
	 * Sets the hl7AssignedAuthor
	 */
	public void setHl7AssignedAuthor(org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedAuthor value) {
		super.assignedAuthor = value;
	}

	/**
	 * Sets the hl7FunctionCode
	 * The functionCode MUST be taken from the Swiss EPR Value-Set for author roles. See FDHA Ordinance on the Electronic Patient Record (EPRO-FDHA), Appendix 3: Metadata, Section 2.1.If the desired functionCode is not available in the Swiss EPR Value-Set for author roles, nullFlavor='NAV' MUST be used. In this case, the originalText element MUST contain the description of the role.Translations to other vocabularies are allowed.
	 */
	public void setHl7FunctionCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		super.functionCode = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Time
	 * Date and time of the laboratory report creation.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.TS value) {
		super.time = value;
	}
}
