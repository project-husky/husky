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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.84
 * Template description: The coded gestational age in days of gestation at birth of a patient. This item is intended to be applied for the child but not for the mother.
 *
 * Element description: The coded gestational age in days of gestation at birth of a patient. This item is intended to be applied for the child but not for the mother.
 */
public class CdachvacdEntryGestationalAgeAtBirth extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	/**
	 * This MAY be used to indicate who has documented the observation. This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author> hl7Author;

	/**
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	private org.ehealth_connector.common.hl7cdar2.CD hl7Code;

	/**
	 * Date or timestamp of the finding (physiologically relevant time of this observation).
	 */
	private org.ehealth_connector.common.hl7cdar2.TS hl7EffectiveTime;

	/**
	 * Each observation SHALL have an identifier.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	/**
	 * The statusCode SHALL be set to 'completed' for all observations.
	 */
	private org.ehealth_connector.common.hl7cdar2.CS hl7StatusCode;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	/**
	 * The gestational age, recorded in days. Therefore weeks have to be converted to days and back to weeks by the applications.Examples:
	 * - Application --&gt; CDA:37th week and 4th day = 37 * 7 + 4 days = 263 days
	 * - CDA --&gt; application:178 d = 25 weeks and 3 days
	 */
	private org.ehealth_connector.common.hl7cdar2.PQ hl7Value;

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
	 * The statusCode SHALL be set to 'completed' for all observations.
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
	 * The gestational age, recorded in days. Therefore weeks have to be converted to days and back to weeks by the applications.Examples:
	 * - Application --&gt; CDA:37th week and 4th day = 37 * 7 + 4 days = 263 days
	 * - CDA --&gt; application:178 d = 25 weeks and 3 days
	 */
	public org.ehealth_connector.common.hl7cdar2.PQ getHl7Value() {
		return hl7Value;
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
	 * The statusCode SHALL be set to 'completed' for all observations.
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
	 * The gestational age, recorded in days. Therefore weeks have to be converted to days and back to weeks by the applications.Examples:
	 * - Application --&gt; CDA:37th week and 4th day = 37 * 7 + 4 days = 263 days
	 * - CDA --&gt; application:178 d = 25 weeks and 3 days
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.PQ value) {
		hl7Value = value;
	}
}
