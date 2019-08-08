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

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.10
 * Template description: Declaration of analyzer, test kit and manufacturer used to determine the result.All participating elements (including devices), MUST according to XD-LAB contain name, addr and telecom.
 */
public class ChpalmEntryParticipantBodyDevice extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ParticipantRole {

	/**
	 * Gets the hl7PlayingDevice
	 * Analyzer used to determine the result.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Device getHl7PlayingDevice() {
		return super.playingDevice;
	}

	/**
	 * Gets the hl7ScopingEntity
	 * The test kit and its manufacturer CAN be specified.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Entity getHl7ScopingEntity() {
		return super.scopingEntity;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryParticipantBodyDevice loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryParticipantBodyDevice loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpalmEntryParticipantBodyDevice retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmEntryParticipantBodyDevice.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmEntryParticipantBodyDevice> root = mar.unmarshal(source, ChpalmEntryParticipantBodyDevice.class);
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
	 * Sets the hl7PlayingDevice
	 * Analyzer used to determine the result.
	 */
	public void setHl7PlayingDevice(org.ehealth_connector.common.hl7cdar2.POCDMT000040Device value) {
		super.playingDevice = value;
	}

	/**
	 * Sets the hl7ScopingEntity
	 * The test kit and its manufacturer CAN be specified.
	 */
	public void setHl7ScopingEntity(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entity value) {
		super.scopingEntity = value;
	}
}
