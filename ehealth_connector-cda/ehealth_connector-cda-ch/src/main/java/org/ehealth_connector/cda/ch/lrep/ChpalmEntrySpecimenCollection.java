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
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.11
 * Template description: Laboratory reports MAY contain information on the specimen. If there are more than one specimen associated to the order, then this item occurs multiple times.
 */
public class ChpalmEntrySpecimenCollection extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Procedure {

	public ChpalmEntrySpecimenCollection() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.11"));
		codeFixedValue = createHl7CodeFixedValue("33882-2", "2.16.840.1.113883.6.1", "LOINC", "Collection date of Unspecified specimen");
	}

	private org.ehealth_connector.common.hl7cdar2.CD codeFixedValue;

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param code the desired fixed value for this argument.
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 * @param displayName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7EffectiveTime
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS createHl7EffectiveTimeFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.IVLTS retVal = factory.createIVLTS();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7EntryRelationship
	 *
	 * @param typeCode the desired fixed value for this argument.
	 * @param inversionInd the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
		retVal.setTypeCode(XActRelationshipEntryRelationship.fromValue(typeCode));
		retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7TargetSiteCode
	 *
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7TargetSiteCodeFixedValue(String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
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
	 * Gets the member codeFixedValue
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getCodeFixedValue() {
		return codeFixedValue;
	}

	/**
	 * Gets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Timestamp (e.g., for simple blood sampling) or period (e.g., 24 hour urine test) of the specimen collection or specimen creation.
	 * - Timestamp: Is declared using @value. Minimum accuracy of the value: Date (the time of the day is OPTIONAL).
	 * - Period: Is declared using low/@value and high/@value. Accuracy of the value: Date and time with hour and minute.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return super.effectiveTime;
	}

	/**
	 * Gets the hl7EntryRelationship
	 * This MAY be used to indicate when the sample has arrived at the laboratory.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getHl7EntryRelationship() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = null;
		if (super.getEntryRelationship() != null)
			if (super.getEntryRelationship().size() > 0)
				retVal = super.getEntryRelationship().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getId() != null)
			if (super.getId().size() > 0)
				retVal = super.getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Participant
	 * The information on the specimen MUST be declared.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 getHl7Participant() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 retVal = null;
		if (super.getParticipant() != null)
			if (super.getParticipant().size() > 0)
				retVal = super.getParticipant().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Performer
	 * This can be used to specify who performed the specimen collection.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 getHl7Performer() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 retVal = null;
		if (super.getPerformer() != null)
			if (super.getPerformer().size() > 0)
				retVal = super.getPerformer().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7TargetSiteCode
	 * This CAN be used to indicate the anatomical position of the specimen collection. This is particularly relevant in microbiology (e.g., when the sample was removed with a swab from the left foot). The HL7 vocabulary ActSite contains anatomical locations of organisms that may be at the center of the action.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7TargetSiteCode() {
		org.ehealth_connector.common.hl7cdar2.CD retVal = null;
		if (super.getTargetSiteCode() != null)
			if (super.getTargetSiteCode().size() > 0)
				retVal = super.getTargetSiteCode().get(0);
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
	 * Gets the hl7Text
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return super.text;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntrySpecimenCollection loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntrySpecimenCollection loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpalmEntrySpecimenCollection retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmEntrySpecimenCollection.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmEntrySpecimenCollection> root = mar.unmarshal(source, ChpalmEntrySpecimenCollection.class);
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
		super.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Timestamp (e.g., for simple blood sampling) or period (e.g., 24 hour urine test) of the specimen collection or specimen creation.
	 * - Timestamp: Is declared using @value. Minimum accuracy of the value: Date (the time of the day is OPTIONAL).
	 * - Period: Is declared using low/@value and high/@value. Accuracy of the value: Date and time with hour and minute.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		super.effectiveTime = value;
	}

	/**
	 * Sets the hl7EntryRelationship
	 * This MAY be used to indicate when the sample has arrived at the laboratory.
	 */
	public void setHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		super.getEntryRelationship().clear();
		super.getEntryRelationship().add(value);
	}

	/**
	 * Sets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getId().clear();
		super.getId().add(value);
	}

	/**
	 * Sets the hl7Participant
	 * The information on the specimen MUST be declared.
	 */
	public void setHl7Participant(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		super.getParticipant().clear();
		super.getParticipant().add(value);
	}

	/**
	 * Sets the hl7Performer
	 * This can be used to specify who performed the specimen collection.
	 */
	public void setHl7Performer(org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 value) {
		super.getPerformer().clear();
		super.getPerformer().add(value);
	}

	/**
	 * Sets the hl7TargetSiteCode
	 * This CAN be used to indicate the anatomical position of the specimen collection. This is particularly relevant in microbiology (e.g., when the sample was removed with a swab from the left foot). The HL7 vocabulary ActSite contains anatomical locations of organisms that may be at the center of the action.
	 */
	public void setHl7TargetSiteCode(org.ehealth_connector.common.hl7cdar2.CD value) {
		super.getTargetSiteCode().clear();
		super.getTargetSiteCode().add(value);
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
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		super.text = value;
	}
}
