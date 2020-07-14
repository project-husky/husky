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
package org.ehealth_connector.cda.ch.emed.v096;

import java.util.ArrayList;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 1.3.6.1.4.1.19376.1.5.3.1.4.1.2 Template
 * description: A problem observation may reference a health status observation.
 * This structure is included in the target observation using the
 * &lt;entryRelationship&gt; element defined in the CDA Schema. The health
 * status observation records information about the current health status of the
 * patient. The example below shows the recording the health status, and is used
 * as the context for the following sections.
 */
public class IhehealthStatusObservation
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue(String code,
			String codeSystem, String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Value
	 */
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7ValueFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		return retVal;
	}

	private ArrayList<org.ehealth_connector.common.Code> vocabStatusCodeCode = new ArrayList<org.ehealth_connector.common.Code>();

	public IhehealthStatusObservation() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.51"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.1.2"));
		super.setCode(createHl7CodeFixedValue("11323-3", "2.16.840.1.113883.6.1", "LOINC",
				"Health Status"));
		vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed")
				.withCodeSystem("2.16.840.1.113883.5.14").build()));
		statusCode = (new Code(CodeBaseType.builder().withCode("completed")
				.withCodeSystem("2.16.840.1.113883.5.14").build())).getHl7CdaR2Cs();
		super.getValue().add(createHl7ValueFixedValue());
	}

	/**
	 * Gets the hl7Code This observation is of health status, as indicated by
	 * the &lt;code&gt; element. This element must be present.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7StatusCode The code attribute of &lt;statusCode&gt; for all
	 * clinical status observations shall be completed. While the
	 * &lt;statusCode&gt; element is required in all acts to record the status
	 * of the act, the only sensible value of this element in this context is
	 * completed.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text The &lt;text&gt; element is required and points to the
	 * text describing the problem being recorded; including any dates,
	 * comments, et cetera. The &lt;reference&gt; contains a URI in value
	 * attribute. This URI points to the free text description of the problem in
	 * the document that is being described.
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Gets the hl7Value The &lt;value&gt; element contains the health status.
	 * It is always represented using the CE datatype (xsi:type='CE'). It shall
	 * contain a code from the following set of values from SNOMED CT.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.ANY> getHl7Value() {
		return value;
	}

	/**
	 * Returns a list of vocab codes as definied in the ART-DECOR model
	 */
	public ArrayList<org.ehealth_connector.common.Code> getVocabStatusCodeCode() {
		return vocabStatusCodeCode;
	}

	/**
	 * Sets the hl7Code This observation is of health status, as indicated by
	 * the &lt;code&gt; element. This element must be present.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7StatusCode The code attribute of &lt;statusCode&gt; for all
	 * clinical status observations shall be completed. While the
	 * &lt;statusCode&gt; element is required in all acts to record the status
	 * of the act, the only sensible value of this element in this context is
	 * completed.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		this.statusCode = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text The &lt;text&gt; element is required and points to the
	 * text describing the problem being recorded; including any dates,
	 * comments, et cetera. The &lt;reference&gt; contains a URI in value
	 * attribute. This URI points to the free text description of the problem in
	 * the document that is being described.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}

	/**
	 * Sets the hl7Value The &lt;value&gt; element contains the health status.
	 * It is always represented using the CE datatype (xsi:type='CE'). It shall
	 * contain a code from the following set of values from SNOMED CT.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.CE value) {
		getValue().clear();
		getValue().add(value);
	}
}
