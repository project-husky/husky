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
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.XActRelationshipEntry;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.53 Template
 * description: Chapter (CDA Body Section) containing the information about a
 * current pregnancy. This section is specialisation of the Pregnancy Hostory
 * section according to IHE PCC Technical Framework Revision 11.0 - November 11,
 * 2016.The section MUST contain at least one Pregnancy Observation entry. In
 * case of no pregnancy, one of the 'special case' codes MUST be used.This
 * section SHALL not be present for male patients.For eVACDOC, this section MUST
 * only contain the estimated delivery date.
 *
 * Element description: Chapter (CDA Body Section) containing the information
 * about a current pregnancy. This section is specialisation of the Pregnancy
 * Hostory section according to IHE PCC Technical Framework Revision 11.0 -
 * November 11, 2016.The section MUST contain at least one Pregnancy Observation
 * entry. In case of no pregnancy, one of the 'special case' codes MUST be
 * used.This section SHALL not be present for male patients.For eVACDOC, this
 * section MUST only contain the estimated delivery date.
 */
public class ChpccSectionCurrentPregnancyCoded
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException\n@throws IOException Signals that an I/O
	 *            exception has occurred.
	 */
	public static ChpccSectionCurrentPregnancyCoded loadFromFile(File inputFile)
			throws JAXBException, IOException {
		ChpccSectionCurrentPregnancyCoded retVal;
		JAXBContext context = JAXBContext.newInstance(ChpccSectionCurrentPregnancyCoded.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpccSectionCurrentPregnancyCoded> root = mar.unmarshal(source,
				ChpccSectionCurrentPregnancyCoded.class);
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
	public static ChpccSectionCurrentPregnancyCoded loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	public ChpccSectionCurrentPregnancyCoded() {
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.53");
		setHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.5.3.4");
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.127.77.1.10.1");
		setHl7CodeFixedValue("10162-6", "2.16.840.1.113883.6.1", "LOINC", "HISTORY OF PREGNANCIES");
		setHl7EntryFixedValue("DRIV");
		setHl7EntryFixedValue("DRIV");
	}

	/**
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7Entry The narrative text in the text element of the section
	 * MUST be generated automatically from the information in this entry.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry getHl7Entry() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry retVal = null;
		if (super.getEntry() != null)
			if (super.getEntry().size() > 0)
				retVal = super.getEntry().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Id An ID for this section MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return super.id;
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
	 * Gets the hl7Text The narrative text for this section.
	 */
	public org.ehealth_connector.common.hl7cdar2.StrucDocText getHl7Text() {
		return super.text;
	}

	/**
	 * Gets the hl7Title
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return super.title;
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
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
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
		org.ehealth_connector.common.hl7cdar2.CE member = factory.createCE();
		member.setCode(code);
		member.setCodeSystem(codeSystem);
		member.setCodeSystemName(codeSystemName);
		member.setDisplayName(displayName);
		// setting the fixed value
		super.setCode(member);
	}

	/**
	 * Sets the hl7Entry The narrative text in the text element of the section
	 * MUST be generated automatically from the information in this entry.
	 */
	public void setHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		super.getEntry().clear();
		super.getEntry().add(value);
	}

	/**
	 * Creates fixed contents for hl7Entry
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 */
	public void setHl7EntryFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry member = factory
				.createPOCDMT000040Entry();
		member.setTypeCode(XActRelationshipEntry.valueOf(typeCode));
		// setting the fixed value
		super.getEntry().add(member);
	}

	/**
	 * Sets the hl7Id An ID for this section MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.id = value;
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

	/**
	 * Sets the hl7Text The narrative text for this section.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.StrucDocText value) {
		super.text = value;
	}

	/**
	 * Sets the hl7Title
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		super.title = value;
	}
}
