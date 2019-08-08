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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.13
 * Template description: A laboratory report MAY contain information on the obligation to report pathogen detection, on accumulation of observations or specific epidemiologically relevant events.Precise specification on the usage of this element is documented in the specification "Laboratory reports for public health (CDA-CH-LRPH)".
 */
public class ChpalmEntryNotificationOrganizer extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Organizer {

	@XmlElement(name = "hl7:component")
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4> hl7Component;

	@XmlElement(name = "hl7:component")
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4> hl7Component1;

	@XmlElement(name = "hl7:component")
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4> hl7Component2;

	/**
	 * Contains at least one notification.
	 */
	@XmlElement(name = "hl7:statusCode")
	private org.ehealth_connector.common.hl7cdar2.CS hl7StatusCode;

	@XmlElement(name = "hl7:templateId")
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	@XmlElement(name = "hl7:templateId")
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	/**
	 * Adds a hl7Component
	 */
	public void addHl7Component(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 value) {
		if (hl7Component == null)
			hl7Component = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4>();
		hl7Component.add(value);
	}

	/**
	 * Adds a hl7Component1
	 */
	public void addHl7Component1(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 value) {
		if (hl7Component1 == null)
			hl7Component1 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4>();
		hl7Component1.add(value);
	}

	/**
	 * Adds a hl7Component2
	 */
	public void addHl7Component2(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 value) {
		if (hl7Component2 == null)
			hl7Component2 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4>();
		hl7Component2.add(value);
	}

	/**
	 * Adds a hl7Component
	 */
	public void clearHl7Component() {
		hl7Component.clear();
	}

	/**
	 * Adds a hl7Component1
	 */
	public void clearHl7Component1() {
		hl7Component1.clear();
	}

	/**
	 * Adds a hl7Component2
	 */
	public void clearHl7Component2() {
		hl7Component2.clear();
	}

	/**
	 * Gets the hl7StatusCode
	 * Contains at least one notification.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return hl7StatusCode;
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
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryNotificationOrganizer loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryNotificationOrganizer loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpalmEntryNotificationOrganizer retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmEntryNotificationOrganizer.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmEntryNotificationOrganizer> root = mar.unmarshal(source, ChpalmEntryNotificationOrganizer.class);
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
	 * Sets the hl7StatusCode
	 * Contains at least one notification.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		hl7StatusCode = value;
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
}
