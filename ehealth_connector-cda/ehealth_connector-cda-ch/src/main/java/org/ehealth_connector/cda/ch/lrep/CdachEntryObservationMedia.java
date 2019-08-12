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
import org.ehealth_connector.common.hl7cdar2.BinaryDataEncoding;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.83 Template
 * description: Multimedia objects (e.g., PDF representations of the CDA
 * document, pictures, Reiber diagrams, electrophoresis, etc.) MAY be integrated
 * into a CDA document, either by reference to external multimedia objects or by
 * means of XML embedding.This template defines only the embedding of multimedia
 * objects in the CDA document. References to external documents can be created
 * with the ExternalDocument template.For embedding in XML, the multimedia
 * objects Base-64 must be encoded.Due to the amount of data, only light objects
 * should be embedded.Heavy objects should be integrated using links to external
 * documents.
 */
public class CdachEntryObservationMedia
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ObservationMedia {

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException\n@throws IOException Signals that an I/O
	 *            exception has occurred.
	 */
	public static CdachEntryObservationMedia loadFromFile(File inputFile)
			throws JAXBException, IOException {
		CdachEntryObservationMedia retVal;
		JAXBContext context = JAXBContext.newInstance(CdachEntryObservationMedia.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachEntryObservationMedia> root = mar.unmarshal(source,
				CdachEntryObservationMedia.class);
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
	public static CdachEntryObservationMedia loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	public CdachEntryObservationMedia() {
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.83");
		setHl7ValueFixedValue("B64");
	}

	/**
	 * Adds a hl7Id IDs for this item MAY be filled for traceability.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Id IDs for this item MAY be filled for traceability.
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Gets the hl7EntryRelationship This template defines only the embedding of
	 * multimedia objects in the CDA document.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getHl7EntryRelationship() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = null;
		if (super.getEntryRelationship() != null)
			if (super.getEntryRelationship().size() > 0)
				retVal = super.getEntryRelationship().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7LanguageCode The RFC 1766 (ISO-639-1 and ISO 3166) based
	 * language in which the multimedia object is written. If it isn't known or
	 * not available (e.g. for pictures), use nullFlavor instead.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7LanguageCode() {
		return super.languageCode;
	}

	/**
	 * Gets the hl7Reference This template defines only the embedding of
	 * multimedia objects in the CDA document.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference getHl7Reference() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference retVal = null;
		if (super.getReference() != null)
			if (super.getReference().size() > 0)
				retVal = super.getReference().get(0);
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
	 * Gets the hl7Value The Base-64 encoded multimedia object.
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Value() {
		return super.value;
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
	 * Sets the hl7EntryRelationship This template defines only the embedding of
	 * multimedia objects in the CDA document.
	 */
	public void setHl7EntryRelationship(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		super.getEntryRelationship().clear();
		super.getEntryRelationship().add(value);
	}

	/**
	 * Sets the hl7LanguageCode The RFC 1766 (ISO-639-1 and ISO 3166) based
	 * language in which the multimedia object is written. If it isn't known or
	 * not available (e.g. for pictures), use nullFlavor instead.
	 */
	public void setHl7LanguageCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.languageCode = value;
	}

	/**
	 * Sets the hl7Reference This template defines only the embedding of
	 * multimedia objects in the CDA document.
	 */
	public void setHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		super.getReference().clear();
		super.getReference().add(value);
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
	 * Sets the hl7Value The Base-64 encoded multimedia object.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.ED value) {
		super.value = value;
	}

	/**
	 * Creates fixed contents for hl7Value
	 *
	 * @param representation
	 *            the desired fixed value for this argument.
	 */
	public void setHl7ValueFixedValue(String representation) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.ED member = factory.createED();
		member.setRepresentation(BinaryDataEncoding.fromValue(representation));
		// setting the fixed value
		super.setValue(member);
	}
}
