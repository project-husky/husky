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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.45
 * Template description: This section MAY be used to provide the original representation of the current CDA document as it has been seen by the legal authenticator while signing.Notes:
 * - This template doesn't require PDF/A but keep in mind that only PDF/A contains all necessary information that allows to identically display the PDF on different machines.
 * - To ensure that digital data remains legible in the long term, PDF/A (but not PDF) is mentioned in the allowed list of archival formats for the Swiss Federal Archives.
 * - The certification requirements according to the Swiss EPR (EPRA) require PDF/A-1 oder PDF/A-2.
 * - Following the recommendations of CDA-CH V2 (2017), embedding the original representation in PDF/A-1a format is therefore strongly recommended.
 *
 * Element description: Contains the original representation of the current CDA document as it has been seen by the legal authenticator while signing.
 */
public class CdachSectionOriginalRepresentationCoded extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {

	public CdachSectionOriginalRepresentationCoded() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.45"));
	}

	/**
	 * Creates fixed contents for hl7Entry
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry createHl7EntryFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry retVal = factory.createPOCDMT000040Entry();
		retVal.setTypeCode(XActRelationshipEntry.valueOf(typeCode));
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
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7Entry
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry getHl7Entry() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry retVal = null;
		if (super.getEntry() != null)
			if (super.getEntry().size() > 0)
				retVal = super.getEntry().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this section MAY be filled for traceability.
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
	 * Gets the hl7Text
	 * MUST contain the reference (renderMultiMedia/@referencedObject) to the corrsponding observationMedia (embedded PDF) that shows the original representation signed by the legal authenticator.
	 */
	public org.ehealth_connector.common.hl7cdar2.StrucDocText getHl7Text() {
		return super.text;
	}

	/**
	 * Gets the hl7Title
	 * Fixed human readable title of this section.
	 * - [ge]: 'Original Darstellung'
	 * - [fr]: 'Représentation originale'
	 * - [it]: 'Rappresentazione originale'
	 * - [en]: 'Original representation'
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return super.title;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachSectionOriginalRepresentationCoded loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachSectionOriginalRepresentationCoded loadFromFile(File inputFile) throws JAXBException, IOException {
		CdachSectionOriginalRepresentationCoded retVal;
		JAXBContext context = JAXBContext.newInstance(CdachSectionOriginalRepresentationCoded.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachSectionOriginalRepresentationCoded> root = mar.unmarshal(source, CdachSectionOriginalRepresentationCoded.class);
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
		super.code = value;
	}

	/**
	 * Sets the hl7Entry
	 */
	public void setHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		super.getEntry().clear();
		super.getEntry().add(value);
	}

	/**
	 * Sets the hl7Id
	 * An ID for this section MAY be filled for traceability.
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
	 * Sets the hl7Text
	 * MUST contain the reference (renderMultiMedia/@referencedObject) to the corrsponding observationMedia (embedded PDF) that shows the original representation signed by the legal authenticator.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.StrucDocText value) {
		super.text = value;
	}

	/**
	 * Sets the hl7Title
	 * Fixed human readable title of this section.
	 * - [ge]: 'Original Darstellung'
	 * - [fr]: 'Représentation originale'
	 * - [it]: 'Rappresentazione originale'
	 * - [en]: 'Original representation'
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		super.title = value;
	}
}
