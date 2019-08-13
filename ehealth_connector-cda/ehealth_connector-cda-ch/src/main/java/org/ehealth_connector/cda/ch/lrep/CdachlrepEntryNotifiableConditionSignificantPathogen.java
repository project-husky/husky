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

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.86
 * Template description: Coding of a significant pathogen.
 */
public class CdachlrepEntryNotifiableConditionSignificantPathogen extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public CdachlrepEntryNotifiableConditionSignificantPathogen() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.86"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.14"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.1.1"));
		codeFixedValue = createHl7CodeFixedValue("170516003", "2.16.840.1.113883.6.96", "SNOMED CT", "Notification of disease");
	}

	private org.ehealth_connector.common.hl7cdar2.CD codeFixedValue;

	/**
	 * Adds a hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void clearHl7Id() {
		getId().clear();
	}

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
	 * Creates fixed contents for hl7Value
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7ValueFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
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
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Timestamp of the sampling.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return super.effectiveTime;
	}

	/**
	 * Gets the hl7StatusCode
	 * The status 'completed' means the patient has been associated with the given notifiable condition.The status 'aborted' means the patient was associated with the notifiable condition in error.
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
	 * Gets the hl7Value
	 * A code that defines the reportable state MUST be specified. If no code is known, nullFlavor='NA' MUST be used.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Value() {
		org.ehealth_connector.common.hl7cdar2.CE retVal = null;
		if (super.getValue() != null)
			if (super.getValue().size() > 0)
				retVal = (org.ehealth_connector.common.hl7cdar2.CE) super.getValue().get(0);
		return retVal;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachlrepEntryNotifiableConditionSignificantPathogen loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachlrepEntryNotifiableConditionSignificantPathogen loadFromFile(File inputFile) throws JAXBException, IOException {
		CdachlrepEntryNotifiableConditionSignificantPathogen retVal;
		JAXBContext context = JAXBContext.newInstance(CdachlrepEntryNotifiableConditionSignificantPathogen.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachlrepEntryNotifiableConditionSignificantPathogen> root = mar.unmarshal(source, CdachlrepEntryNotifiableConditionSignificantPathogen.class);
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
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		super.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Timestamp of the sampling.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		super.effectiveTime = value;
	}

	/**
	 * Sets the hl7StatusCode
	 * The status 'completed' means the patient has been associated with the given notifiable condition.The status 'aborted' means the patient was associated with the notifiable condition in error.
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
	 * Sets the hl7Value
	 * A code that defines the reportable state MUST be specified. If no code is known, nullFlavor='NA' MUST be used.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.CE value) {
		super.getValue().clear();
		super.getValue().add(value);
	}
}
