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
package org.ehealth_connector.cda.ch.lrep.v133;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.118 Template
 * description: Each chapter (Laboratory Speciality Section and Laboratory
 * Report Item Section) MUST contain exactly one findings group (CDA Body
 * Laboratory Report Data Processing Entry).
 */
public class CdachlrepEntryLaboratoryReportDataProcessingEntry
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry {

	/**
	 * Creates fixed contents for CDA Element hl7Act
	 *
	 * @param classCode
	 *            the desired fixed value for this argument.
	 * @param moodCode
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.POCDMT000040Act createHl7ActFixedValue(
			String classCode, String moodCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Act retVal = factory
				.createPOCDMT000040Act();
		retVal.setClassCode(org.ehealth_connector.common.hl7cdar2.XActClassDocumentEntryAct
				.fromValue(classCode));
		retVal.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XDocumentActMood.fromValue(moodCode));
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
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.POCDMT000040Act,
	 * filled by: "ACT", "EVN"
	 *
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040Act getPredefinedActActEvn() {
		return createHl7ActFixedValue("ACT", "EVN");
	}

	public CdachlrepEntryLaboratoryReportDataProcessingEntry() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.118"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.4"));
	}

	/**
	 * Gets the hl7Act
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Act getHl7Act() {
		return act;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7Act
	 */
	public void setHl7Act(org.ehealth_connector.common.hl7cdar2.POCDMT000040Act value) {
		this.act = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
