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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.12 Template
 * description: A laboratory report MAY contain information on the reception of
 * the specimen at the laboratory.
 */
public class ChpalmEntrySpecimenReceived
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Act {

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException\n@throws IOException Signals that an I/O
	 *            exception has occurred.
	 */
	public static ChpalmEntrySpecimenReceived loadFromFile(File inputFile)
			throws JAXBException, IOException {
		ChpalmEntrySpecimenReceived retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmEntrySpecimenReceived.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmEntrySpecimenReceived> root = mar.unmarshal(source,
				ChpalmEntrySpecimenReceived.class);
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
	public static ChpalmEntrySpecimenReceived loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	public ChpalmEntrySpecimenReceived() {
		setHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.3");
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.12");
		setHl7IdFixedValue("ASKU");
		setHl7CodeFixedValue("SPRECEIVE", "1.3.5.1.4.1.19376.1.5.3.2", "IHEActCode",
				"Receive Time");
	}

	/**
	 * Gets the hl7Code The human-readable text MUST be generated automatically
	 * from the structured information of this element. The text element MUST
	 * contain the reference to the corresponding text in the human readable
	 * part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7EffectiveTime Timestamp of the specimen reception at the
	 * laboratory. Minimum accuracy of the value: Date and time with hour and
	 * minute.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return super.effectiveTime;
	}

	/**
	 * Gets the hl7Id The delivered identification of specimen at the customer
	 * MUST be declared. If specimen identification is not available,
	 * nullFlavor='ASKU' MUST be used. In this case @root and @extension are NOT
	 * ALLOWED.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getId() != null)
			if (super.getId().size() > 0)
				retVal = super.getId().get(0);
		return retVal;
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

	/**
	 * Sets the hl7Code The human-readable text MUST be generated automatically
	 * from the structured information of this element. The text element MUST
	 * contain the reference to the corresponding text in the human readable
	 * part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		super.code = value;
	}

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 * @param codeSystem
	 *            the desired fixed value for this argument.
	 * @param codeSystemName
	 *            the desired fixed value for this argument.
	 * @param displayName
	 *            the desired fixed value for this argument.
	 */
	public void setHl7CodeFixedValue(String code, String codeSystem, String codeSystemName,
			String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD member = factory.createCD();
		member.setCode(code);
		member.setCodeSystem(codeSystem);
		member.setCodeSystemName(codeSystemName);
		member.setDisplayName(displayName);
		// setting the fixed value
		super.setCode(member);
	}

	/**
	 * Sets the hl7EffectiveTime Timestamp of the specimen reception at the
	 * laboratory. Minimum accuracy of the value: Date and time with hour and
	 * minute.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		super.effectiveTime = value;
	}

	/**
	 * Sets the hl7Id The delivered identification of specimen at the customer
	 * MUST be declared. If specimen identification is not available,
	 * nullFlavor='ASKU' MUST be used. In this case @root and @extension are NOT
	 * ALLOWED.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getId().clear();
		super.getId().add(value);
	}

	/**
	 * Creates fixed contents for hl7Id
	 *
	 * @param nullFlavor
	 *            the desired fixed value for this argument.
	 */
	public void setHl7IdFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II member = factory.createII();
		member.nullFlavor = new ArrayList<String>();
		member.nullFlavor.add(nullFlavor);
		// setting the fixed value
		super.getId().add(member);
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}

	/**
	 * Creates fixed contents for hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	public void setHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II member = factory.createII();
		member.setRoot(root);
		// setting the fixed value
		super.getTemplateId().add(member);
	}
}
