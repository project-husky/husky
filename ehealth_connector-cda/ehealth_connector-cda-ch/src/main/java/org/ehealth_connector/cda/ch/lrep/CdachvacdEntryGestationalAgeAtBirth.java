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
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.84 Template
 * description: The coded gestational age in days of gestation at birth of a
 * patient. This item is intended to be applied for the child but not for the
 * mother.
 *
 * Element description: The coded gestational age in days of gestation at birth
 * of a patient. This item is intended to be applied for the child but not for
 * the mother.
 */
public class CdachvacdEntryGestationalAgeAtBirth
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException\n@throws IOException Signals that an I/O
	 *            exception has occurred.
	 */
	public static CdachvacdEntryGestationalAgeAtBirth loadFromFile(File inputFile)
			throws JAXBException, IOException {
		CdachvacdEntryGestationalAgeAtBirth retVal;
		JAXBContext context = JAXBContext.newInstance(CdachvacdEntryGestationalAgeAtBirth.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachvacdEntryGestationalAgeAtBirth> root = mar.unmarshal(source,
				CdachvacdEntryGestationalAgeAtBirth.class);
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
	public static CdachvacdEntryGestationalAgeAtBirth loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	public CdachvacdEntryGestationalAgeAtBirth() {
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.84");
		setHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.13");
		setHl7CodeFixedValue("49052-4", "2.16.840.1.113883.6.1", "LOINC",
				"Gestational age in days");
	}

	/**
	 * Adds a hl7Author This MAY be used to indicate who has documented the
	 * observation. This information supersedes any information recorded at
	 * higher level.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7Author This MAY be used to indicate who has documented the
	 * observation. This information supersedes any information recorded at
	 * higher level.
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Gets the hl7Code The human-readable text MUST be generated automatically
	 * from the structured information of this element. The text element MUST
	 * contain the reference to the corresponding text in the human readable
	 * part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7EffectiveTime Date or timestamp of the finding
	 * (physiologically relevant time of this observation).
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7EffectiveTime() {
		return super.effectiveTime;
	}

	/**
	 * Gets the hl7Id Each observation SHALL have an identifier.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getId() != null)
			if (super.getId().size() > 0)
				retVal = super.getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7StatusCode The statusCode SHALL be set to 'completed' for all
	 * observations.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return super.statusCode;
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
	 * Gets the hl7Value The gestational age, recorded in days. Therefore weeks
	 * have to be converted to days and back to weeks by the
	 * applications.Examples: - Application --&gt; CDA:37th week and 4th day =
	 * 37 * 7 + 4 days = 263 days - CDA --&gt; application:178 d = 25 weeks and
	 * 3 days
	 */
	public org.ehealth_connector.common.hl7cdar2.PQ getHl7Value() {
		org.ehealth_connector.common.hl7cdar2.PQ retVal = null;
		if (super.getValue() != null)
			if (super.getValue().size() > 0)
				retVal = (org.ehealth_connector.common.hl7cdar2.PQ) super.getValue().get(0);
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
	 * Sets the hl7Code The human-readable text MUST be generated automatically
	 * from the structured information of this element. The text element MUST
	 * contain the reference to the corresponding text in the human readable
	 * part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		super.code = value;
	}

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 * @param codeSystem
	 *            the desired fixed value for this argument.
	 * @param codeSystemName
	 *            the desired fixed value for this argument.
	 * @param displayName
	 *            the desired fixed value for this argument.
	 */
	public void setHl7CodeFixedValue(String code, String codeSystem, String codeSystemName,
			String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD member = factory.createCD();
		member.setCode(code);
		member.setCodeSystem(codeSystem);
		member.setCodeSystemName(codeSystemName);
		member.setDisplayName(displayName);
		// setting the fixed value
		super.setCode(member);
	}

	/**
	 * Sets the hl7EffectiveTime Date or timestamp of the finding
	 * (physiologically relevant time of this observation).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		ObjectFactory factory = new ObjectFactory();
		IVLTS ivlts = factory.createIVLTS();
		ivlts.setValue(value.getValue());
		super.effectiveTime = ivlts;
	}

	/**
	 * Sets the hl7Id Each observation SHALL have an identifier.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getId().clear();
		super.getId().add(value);
	}

	/**
	 * Sets the hl7StatusCode The statusCode SHALL be set to 'completed' for all
	 * observations.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.statusCode = value;
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
	 * Sets the hl7Value The gestational age, recorded in days. Therefore weeks
	 * have to be converted to days and back to weeks by the
	 * applications.Examples: - Application --&gt; CDA:37th week and 4th day =
	 * 37 * 7 + 4 days = 263 days - CDA --&gt; application:178 d = 25 weeks and
	 * 3 days
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.PQ value) {
		super.getValue().clear();
		super.getValue().add(value);
	}
}
