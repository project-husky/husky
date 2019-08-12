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

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.58 Template
 * description: Patient (Human Patient).Patient identifiersThe id (patient
 * identification number) can be declared multiple times. If multiple
 * identifications are known, all known IDs should be specified. For laboratory
 * reports, all IDs specified by the ordering system are to be returned. This
 * allows the receiver to assign its internal patient identification. OIDs of
 * code systems, which are published in the public OID registry for the Swiss
 * health care system (oid.refdata.ch) are REQUIRED. Others are NOT
 * ALLOWED.PseudonymizationIn special cases, the demographic data of the patient
 * need not be transmitted or they need to be pseudonymized (e.g., results of
 * genetic or forensic toxicology). The affected values must be replaced by a
 * nullFlavor of type "MSK" (masked), in order to shield the data.
 *
 * Element description: Patient (Human Patient).
 */
public class CdachlrepHeaderPatient
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget {

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException\n@throws IOException Signals that an I/O
	 *            exception has occurred.
	 */
	public static CdachlrepHeaderPatient loadFromFile(File inputFile)
			throws JAXBException, IOException {
		CdachlrepHeaderPatient retVal;
		JAXBContext context = JAXBContext.newInstance(CdachlrepHeaderPatient.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachlrepHeaderPatient> root = mar.unmarshal(source,
				CdachlrepHeaderPatient.class);
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
	public static CdachlrepHeaderPatient loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	public CdachlrepHeaderPatient() {
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.58");
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.1");
	}

	/**
	 * Gets the hl7PatientRole Exactly one patient MUST be declared.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040PatientRole getHl7PatientRole() {
		return super.patientRole;
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
	 * Sets the hl7PatientRole Exactly one patient MUST be declared.
	 */
	public void setHl7PatientRole(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040PatientRole value) {
		super.patientRole = value;
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
