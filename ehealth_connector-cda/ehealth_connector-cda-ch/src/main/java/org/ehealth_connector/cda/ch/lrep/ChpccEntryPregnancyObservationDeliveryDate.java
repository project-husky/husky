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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.102
 * Template description: This element contains structured information about the delivery date of a pregnancy.
 *
 * Element description: This element contains structured information about the delivery date of a pregnancy.
 */
public class ChpccEntryPregnancyObservationDeliveryDate extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	/**
	 * This MAY be used to indicate who has documented the observation. This information supersedes any information recorded at higher level.
	 */
	@XmlElement(name = "hl7:author")
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author> hl7Author;

	/**
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	@XmlElement(name = "hl7:code")
	private org.ehealth_connector.common.hl7cdar2.CD hl7Code;

	/**
	 * Date or timestamp of the finding (physiologically relevant time of this observation).
	 */
	@XmlElement(name = "hl7:effectiveTime")
	private org.ehealth_connector.common.hl7cdar2.TS hl7EffectiveTime;

	/**
	 * Each observation SHALL have an identifier.
	 */
	@XmlElement(name = "hl7:id")
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	/**
	 * The statusCode shall be set to 'completed' for all observations.
	 */
	@XmlElement(name = "hl7:statusCode")
	private org.ehealth_connector.common.hl7cdar2.CS hl7StatusCode;

	@XmlElement(name = "hl7:templateId")
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	@XmlElement(name = "hl7:templateId")
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	@XmlElement(name = "hl7:templateId")
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId2;

	@XmlElement(name = "hl7:templateId")
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId3;

	/**
	 * The delivery date (clinical estimate)
	 */
	@XmlElement(name = "hl7:value")
	private org.ehealth_connector.common.hl7cdar2.TS hl7Value;

	/**
	 * Adds a hl7Author
	 * This MAY be used to indicate who has documented the observation. This information supersedes any information recorded at higher level.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		if (hl7Author == null)
			hl7Author = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author>();
		hl7Author.add(value);
	}

	/**
	 * Adds a hl7Author
	 * This MAY be used to indicate who has documented the observation. This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Author() {
		hl7Author.clear();
	}

	/**
	 * Gets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Date or timestamp of the finding (physiologically relevant time of this observation).
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7EffectiveTime() {
		return hl7EffectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * Each observation SHALL have an identifier.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return hl7Id;
	}

	/**
	 * Gets the hl7StatusCode
	 * The statusCode shall be set to 'completed' for all observations.
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
	 * Gets the hl7TemplateId2
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId2() {
		return hl7TemplateId2;
	}

	/**
	 * Gets the hl7TemplateId3
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId3() {
		return hl7TemplateId3;
	}

	/**
	 * Gets the hl7Value
	 * The delivery date (clinical estimate)
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7Value() {
		return hl7Value;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpccEntryPregnancyObservationDeliveryDate loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpccEntryPregnancyObservationDeliveryDate loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpccEntryPregnancyObservationDeliveryDate retVal;
		JAXBContext context = JAXBContext.newInstance(ChpccEntryPregnancyObservationDeliveryDate.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpccEntryPregnancyObservationDeliveryDate> root = mar.unmarshal(source, ChpccEntryPregnancyObservationDeliveryDate.class);
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
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		hl7Code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Date or timestamp of the finding (physiologically relevant time of this observation).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		hl7EffectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 * Each observation SHALL have an identifier.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7Id = value;
	}

	/**
	 * Sets the hl7StatusCode
	 * The statusCode shall be set to 'completed' for all observations.
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
	 * Sets the hl7TemplateId2
	 */
	public void setHl7TemplateId2(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId2 = value;
	}

	/**
	 * Sets the hl7TemplateId3
	 */
	public void setHl7TemplateId3(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId3 = value;
	}

	/**
	 * Sets the hl7Value
	 * The delivery date (clinical estimate)
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.TS value) {
		hl7Value = value;
	}
}
