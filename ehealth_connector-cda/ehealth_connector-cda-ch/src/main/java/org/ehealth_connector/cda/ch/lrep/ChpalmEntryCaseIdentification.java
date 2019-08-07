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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.15
 * Template description: If an examination belongs to a specific case, this CAN be documented with this element (in the Notification Organizer).
 */
public class ChpalmEntryCaseIdentification extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	/**
	 * The type of the case MUST be declared with a code. LOINC (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or values from the HL7 vocabulary ObservationType (2.16.840.1.113883.1.11.16226) SHOULD be used.
	 */
	private org.ehealth_connector.common.hl7cdar2.CE hl7Code;

	/**
	 * MAY contain the period of validity of the case.
	 */
	private org.ehealth_connector.common.hl7cdar2.IVLTS hl7EffectiveTime;

	/**
	 * The number of the case to which the examinations belong in this section MUST be declared. Multiple case numbers CAN be specified.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> hl7Id;

	/**
	 * The status 'completed' means the patient has been associated with the given case number.The status 'aborted' means the patient was associated with the case number in error.
	 */
	private org.ehealth_connector.common.hl7cdar2.CS hl7StatusCode;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	/**
	 * A not further specified precision of the case MUST be declared according to XD-LAB with data type 'CE'. If no further precision is known, nullFavor='UNK' MUST be used.
	 */
	private org.ehealth_connector.common.hl7cdar2.CE hl7Value;

	/**
	 * Adds a hl7Id
	 * The number of the case to which the examinations belong in this section MUST be declared. Multiple case numbers CAN be specified.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		if (hl7Id == null)
			hl7Id = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();
		hl7Id.add(value);
	}

	/**
	 * Adds a hl7Id
	 * The number of the case to which the examinations belong in this section MUST be declared. Multiple case numbers CAN be specified.
	 */
	public void clearHl7Id() {
		hl7Id.clear();
	}

	/**
	 * Gets the hl7Code
	 * The type of the case MUST be declared with a code. LOINC (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or values from the HL7 vocabulary ObservationType (2.16.840.1.113883.1.11.16226) SHOULD be used.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * MAY contain the period of validity of the case.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return hl7EffectiveTime;
	}

	/**
	 * Gets the hl7StatusCode
	 * The status 'completed' means the patient has been associated with the given case number.The status 'aborted' means the patient was associated with the case number in error.
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
	 * Gets the hl7Value
	 * A not further specified precision of the case MUST be declared according to XD-LAB with data type 'CE'. If no further precision is known, nullFavor='UNK' MUST be used.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Value() {
		return hl7Value;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryCaseIdentification loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryCaseIdentification loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpalmEntryCaseIdentification retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmEntryCaseIdentification.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmEntryCaseIdentification> root = mar.unmarshal(source, ChpalmEntryCaseIdentification.class);
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
	 * The type of the case MUST be declared with a code. LOINC (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or values from the HL7 vocabulary ObservationType (2.16.840.1.113883.1.11.16226) SHOULD be used.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		hl7Code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * MAY contain the period of validity of the case.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		hl7EffectiveTime = value;
	}

	/**
	 * Sets the hl7StatusCode
	 * The status 'completed' means the patient has been associated with the given case number.The status 'aborted' means the patient was associated with the case number in error.
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

	/**
	 * Sets the hl7Value
	 * A not further specified precision of the case MUST be declared according to XD-LAB with data type 'CE'. If no further precision is known, nullFavor='UNK' MUST be used.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.CE value) {
		hl7Value = value;
	}
}
