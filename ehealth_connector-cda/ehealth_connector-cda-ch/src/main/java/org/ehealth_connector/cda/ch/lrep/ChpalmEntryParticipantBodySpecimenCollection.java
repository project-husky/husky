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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.24
 * Template description: Specimen Information.
 */
public class ChpalmEntryParticipantBodySpecimenCollection extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ParticipantRole {

	/**
	 * The specimen identification MUST be declared. If no specimen identification is available, nullFlavor='NA' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	@XmlElement(name = "hl7:id")
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	@XmlElement(name = "hl7:playingEntity")
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity hl7PlayingEntity;

	/**
	 * Gets the hl7Id
	 * The specimen identification MUST be declared. If no specimen identification is available, nullFlavor='NA' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return hl7Id;
	}

	/**
	 * Gets the hl7PlayingEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity getHl7PlayingEntity() {
		return hl7PlayingEntity;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryParticipantBodySpecimenCollection loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryParticipantBodySpecimenCollection loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpalmEntryParticipantBodySpecimenCollection retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmEntryParticipantBodySpecimenCollection.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmEntryParticipantBodySpecimenCollection> root = mar.unmarshal(source, ChpalmEntryParticipantBodySpecimenCollection.class);
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
	 * Sets the hl7Id
	 * The specimen identification MUST be declared. If no specimen identification is available, nullFlavor='NA' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7Id = value;
	}

	/**
	 * Sets the hl7PlayingEntity
	 */
	public void setHl7PlayingEntity(org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity value) {
		hl7PlayingEntity = value;
	}
}
