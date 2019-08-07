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
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.53
 * Template description: Chapter (CDA Body Section) containing the information about a current pregnancy. This section is specialisation of the Pregnancy Hostory section according to IHE PCC Technical Framework Revision 11.0 - November 11, 2016.The section MUST contain at least one Pregnancy Observation entry. In case of no pregnancy, one of the 'special case' codes MUST be used.This section SHALL not be present for male patients.For eVACDOC, this section MUST only contain the estimated delivery date.
 *
 * Element description: Chapter (CDA Body Section) containing the information about a current pregnancy. This section is specialisation of the Pregnancy Hostory section according to IHE PCC Technical Framework Revision 11.0 - November 11, 2016.The section MUST contain at least one Pregnancy Observation entry. In case of no pregnancy, one of the 'special case' codes MUST be used.This section SHALL not be present for male patients.For eVACDOC, this section MUST only contain the estimated delivery date.
 */
public class ChpccSectionCurrentPregnancyCoded extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {

	private org.ehealth_connector.common.hl7cdar2.CE hl7Code;

	/**
	 * The narrative text in the text element of the section MUST be generated automatically from the information in this entry.
	 */
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry hl7Entry;

	/**
	 * The narrative text in the text element of the section MUST be generated automatically from the information in this entry.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry> hl7Entry1;

	/**
	 * An ID for this section MAY be filled for traceability.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> hl7Id;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId2;

	/**
	 * The narrative text for this section.
	 */
	private org.ehealth_connector.common.hl7cdar2.StrucDocText hl7Text;

	private org.ehealth_connector.common.hl7cdar2.ST hl7Title;

	/**
	 * Adds a hl7Entry1
	 * The narrative text in the text element of the section MUST be generated automatically from the information in this entry.
	 */
	public void addHl7Entry1(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		if (hl7Entry1 == null)
			hl7Entry1 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry>();
		hl7Entry1.add(value);
	}

	/**
	 * Adds a hl7Id
	 * An ID for this section MAY be filled for traceability.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		if (hl7Id == null)
			hl7Id = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();
		hl7Id.add(value);
	}

	/**
	 * Adds a hl7Entry1
	 * The narrative text in the text element of the section MUST be generated automatically from the information in this entry.
	 */
	public void clearHl7Entry1() {
		hl7Entry1.clear();
	}

	/**
	 * Adds a hl7Id
	 * An ID for this section MAY be filled for traceability.
	 */
	public void clearHl7Id() {
		hl7Id.clear();
	}

	/**
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7Entry
	 * The narrative text in the text element of the section MUST be generated automatically from the information in this entry.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry getHl7Entry() {
		return hl7Entry;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		return hl7TemplateId;
	}

	/**
	 * Gets the hl7TemplateId1
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId1() {
		return hl7TemplateId1;
	}

	/**
	 * Gets the hl7TemplateId2
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId2() {
		return hl7TemplateId2;
	}

	/**
	 * Gets the hl7Text
	 * The narrative text for this section.
	 */
	public org.ehealth_connector.common.hl7cdar2.StrucDocText getHl7Text() {
		return hl7Text;
	}

	/**
	 * Gets the hl7Title
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return hl7Title;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpccSectionCurrentPregnancyCoded loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpccSectionCurrentPregnancyCoded loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpccSectionCurrentPregnancyCoded retVal;
		JAXBContext context = JAXBContext.newInstance(ChpccSectionCurrentPregnancyCoded.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpccSectionCurrentPregnancyCoded> root = mar.unmarshal(source, ChpccSectionCurrentPregnancyCoded.class);
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
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		hl7Code = value;
	}

	/**
	 * Sets the hl7Entry
	 * The narrative text in the text element of the section MUST be generated automatically from the information in this entry.
	 */
	public void setHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		hl7Entry = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId = value;
	}

	/**
	 * Sets the hl7TemplateId1
	 */
	public void setHl7TemplateId1(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId1 = value;
	}

	/**
	 * Sets the hl7TemplateId2
	 */
	public void setHl7TemplateId2(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId2 = value;
	}

	/**
	 * Sets the hl7Text
	 * The narrative text for this section.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.StrucDocText value) {
		hl7Text = value;
	}

	/**
	 * Sets the hl7Title
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		hl7Title = value;
	}
}
