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
package org.ehealth_connector.cda.ch.lrep.v140;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.53 Template
 * description: Chapter (CDA Body Section) containing the information about a
 * current pregnancy. This section is specialisation of the Pregnancy Hostory
 * section according to IHE PCC Technical Framework Revision 11.0 - November 11,
 * 2016.The section MUST contain at least one Pregnancy Observation entry. In
 * case of no pregnancy, one of the 'special case' codes MUST be used.This
 * section SHALL not be present for male patients.For eVACDOC, this section MUST
 * only contain the estimated delivery date.
 *
 * Element description: Chapter (CDA Body Section) containing the information
 * about a current pregnancy. This section is specialisation of the Pregnancy
 * Hostory section according to IHE PCC Technical Framework Revision 11.0 -
 * November 11, 2016.The section MUST contain at least one Pregnancy Observation
 * entry. In case of no pregnancy, one of the 'special case' codes MUST be
 * used.This section SHALL not be present for male patients.For eVACDOC, this
 * section MUST only contain the estimated delivery date.
 */
public class ChpccSectionCurrentPregnancyCoded
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {

	public ChpccSectionCurrentPregnancyCoded() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.53"));
		super.getTemplateId()
				.add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.5.3.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.127.77.1.10.1"));
		super.setCode(createHl7CodeFixedValue("10162-6", "2.16.840.1.113883.6.1", "LOINC",
				"HISTORY OF PREGNANCIES"));
	}

	/**
	 * Adds a hl7Id An ID for this section MAY be filled for traceability.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		id = value;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
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
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7CodeFixedValue(String code,
			String codeSystem, String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Entry
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry createHl7EntryFixedValue(
			String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry retVal = factory
				.createPOCDMT000040Entry();
		retVal.setTypeCode(
				org.ehealth_connector.common.hl7cdar2.XActRelationshipEntry.fromValue(typeCode));
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
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7Entry The narrative text in the text element of the section
	 * MUST be generated automatically from the information in this entry.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry> getHl7Entry() {
		return entry;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text The narrative text for this section.
	 */
	public org.ehealth_connector.common.hl7cdar2.StrucDocText getHl7Text() {
		return text;
	}

	/**
	 * Gets the hl7Title
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return title;
	}

	/**
	 * Adds a predefined
	 * org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry, filled by:
	 * "DRIV"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry getPredefinedEntryDriv() {
		return createHl7EntryFixedValue("DRIV");
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Entry The narrative text in the text element of the section
	 * MUST be generated automatically from the information in this entry.
	 */
	public void setHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		getEntry().clear();
		getEntry().add(value);
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text The narrative text for this section.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.StrucDocText value) {
		this.text = value;
	}

	/**
	 * Sets the hl7Title
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		this.title = value;
	}
}
