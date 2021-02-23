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
package org.ehealth_connector.cda.ch.emed.v097;

import javax.annotation.Generated;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.13 Template
 * description: The Medication Treatment Plan Section contains a description of
 * the patient. It includes entries for Medication Treatment Plan Items as
 * described in the Medication Treatment Plan Item Entry Content Module.
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-02-23")
public class MedicationTreatmenPlanSectionContentModule
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {

	public MedicationTreatmenPlanSectionContentModule() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.13"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.2.6"));
		super.setCode(createHl7CodeFixedValue("77604-7", "2.16.840.1.113883.6.1", "LOINC",
				"Medication treatment plan.brief"));
	}

	/**
	 * Adds a hl7Author Information about the author of a CDA document, section
	 * or entry. An author MAY be a person or a device.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7Author Information about the author of a CDA document, section
	 * or entry. An author MAY be a person or a device.
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code
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
	 * Gets the hl7Entry
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry> getHl7Entry() {
		return entry;
	}

	/**
	 * Gets the hl7Id
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text
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
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Entry
	 */
	public void setHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		getEntry().clear();
		getEntry().add(value);
	}

	/**
	 * Sets the hl7Id
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		this.id = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text
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
