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
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.11
 * Template description: Laboratory reports MAY contain information on the specimen. If there are more than one specimen associated to the order, then this item occurs multiple times.
 */
public class ChpalmEntrySpecimenCollection extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Procedure {

	/**
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	private org.ehealth_connector.common.hl7cdar2.CD hl7Code;

	/**
	 * Timestamp (e.g., for simple blood sampling) or period (e.g., 24 hour urine test) of the specimen collection or specimen creation.
	 * - Timestamp: Is declared using @value. Minimum accuracy of the value: Date (the time of the day is OPTIONAL).
	 * - Period: Is declared using low/@value and high/@value. Accuracy of the value: Date and time with hour and minute.
	 */
	private org.ehealth_connector.common.hl7cdar2.IVLTS hl7EffectiveTime;

	/**
	 * This MAY be used to indicate when the sample has arrived at the laboratory.
	 */
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship hl7EntryRelationship;

	/**
	 * This MAY be used to indicate observations of the specimen collection. This allows to provide information to the laboratory, that are important e.g. for a 24-hour urine test:
	 * - Collection period for 24 hour urine test: @code='13362-9' (Collection duration of Urine), @value='24', @unit='h'
	 * - Collected volume (urine quantity): @code='19153-6' (Volume in Urine collected for unspecified duration), @value: urine quantity, @unit: UCUM unit of urine quantity (e.g. ml, dl or l)
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship> hl7EntryRelationship1;

	/**
	 * An ID for this item MAY be filled for traceability.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	/**
	 * The information on the specimen MUST be declared.
	 */
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 hl7Participant;

	/**
	 * This can be used to specify who performed the specimen collection.
	 */
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 hl7Performer;

	/**
	 * This CAN be used to indicate the anatomical position of the specimen collection. This is particularly relevant in microbiology (e.g., when the sample was removed with a swab from the left foot). The HL7 vocabulary ActSite contains anatomical locations of organisms that may be at the center of the action.
	 */
	private org.ehealth_connector.common.hl7cdar2.CD hl7TargetSiteCode;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	private org.ehealth_connector.common.hl7cdar2.ED hl7Text;

	/**
	 * Adds a hl7EntryRelationship1
	 * This MAY be used to indicate observations of the specimen collection. This allows to provide information to the laboratory, that are important e.g. for a 24-hour urine test:
	 * - Collection period for 24 hour urine test: @code='13362-9' (Collection duration of Urine), @value='24', @unit='h'
	 * - Collected volume (urine quantity): @code='19153-6' (Volume in Urine collected for unspecified duration), @value: urine quantity, @unit: UCUM unit of urine quantity (e.g. ml, dl or l)
	 */
	public void addHl7EntryRelationship1(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		if (hl7EntryRelationship1 == null)
			hl7EntryRelationship1 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship>();
		hl7EntryRelationship1.add(value);
	}

	/**
	 * Adds a hl7EntryRelationship1
	 * This MAY be used to indicate observations of the specimen collection. This allows to provide information to the laboratory, that are important e.g. for a 24-hour urine test:
	 * - Collection period for 24 hour urine test: @code='13362-9' (Collection duration of Urine), @value='24', @unit='h'
	 * - Collected volume (urine quantity): @code='19153-6' (Volume in Urine collected for unspecified duration), @value: urine quantity, @unit: UCUM unit of urine quantity (e.g. ml, dl or l)
	 */
	public void clearHl7EntryRelationship1() {
		hl7EntryRelationship1.clear();
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
	 * Timestamp (e.g., for simple blood sampling) or period (e.g., 24 hour urine test) of the specimen collection or specimen creation.
	 * - Timestamp: Is declared using @value. Minimum accuracy of the value: Date (the time of the day is OPTIONAL).
	 * - Period: Is declared using low/@value and high/@value. Accuracy of the value: Date and time with hour and minute.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return hl7EffectiveTime;
	}

	/**
	 * Gets the hl7EntryRelationship
	 * This MAY be used to indicate when the sample has arrived at the laboratory.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getHl7EntryRelationship() {
		return hl7EntryRelationship;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return hl7Id;
	}

	/**
	 * Gets the hl7Participant
	 * The information on the specimen MUST be declared.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 getHl7Participant() {
		return hl7Participant;
	}

	/**
	 * Gets the hl7Performer
	 * This can be used to specify who performed the specimen collection.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 getHl7Performer() {
		return hl7Performer;
	}

	/**
	 * Gets the hl7TargetSiteCode
	 * This CAN be used to indicate the anatomical position of the specimen collection. This is particularly relevant in microbiology (e.g., when the sample was removed with a swab from the left foot). The HL7 vocabulary ActSite contains anatomical locations of organisms that may be at the center of the action.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7TargetSiteCode() {
		return hl7TargetSiteCode;
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
	 * Gets the hl7Text
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return hl7Text;
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
	 * Timestamp (e.g., for simple blood sampling) or period (e.g., 24 hour urine test) of the specimen collection or specimen creation.
	 * - Timestamp: Is declared using @value. Minimum accuracy of the value: Date (the time of the day is OPTIONAL).
	 * - Period: Is declared using low/@value and high/@value. Accuracy of the value: Date and time with hour and minute.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		hl7EffectiveTime = value;
	}

	/**
	 * Sets the hl7EntryRelationship
	 * This MAY be used to indicate when the sample has arrived at the laboratory.
	 */
	public void setHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		hl7EntryRelationship = value;
	}

	/**
	 * Sets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7Id = value;
	}

	/**
	 * Sets the hl7Participant
	 * The information on the specimen MUST be declared.
	 */
	public void setHl7Participant(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		hl7Participant = value;
	}

	/**
	 * Sets the hl7Performer
	 * This can be used to specify who performed the specimen collection.
	 */
	public void setHl7Performer(org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 value) {
		hl7Performer = value;
	}

	/**
	 * Sets the hl7TargetSiteCode
	 * This CAN be used to indicate the anatomical position of the specimen collection. This is particularly relevant in microbiology (e.g., when the sample was removed with a swab from the left foot). The HL7 vocabulary ActSite contains anatomical locations of organisms that may be at the center of the action.
	 */
	public void setHl7TargetSiteCode(org.ehealth_connector.common.hl7cdar2.CD value) {
		hl7TargetSiteCode = value;
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
	 * Sets the hl7Text
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		hl7Text = value;
	}
}
