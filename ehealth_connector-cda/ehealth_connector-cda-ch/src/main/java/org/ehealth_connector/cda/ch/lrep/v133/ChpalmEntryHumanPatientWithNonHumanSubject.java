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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.lrep.v133;

import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.6 Template
 * description: If, in a part of the document, certain laboratory observations
 * for a human patient base on a sample of a non-human material (e.g., food
 * eaten by the patient or an animal that has bitten the patient), it MUST be
 * declared using this element in the CDA body. Other parts of the document may
 * contain laboratory observations that base on other samples (including samples
 * taken from the patient). In addition, the IHE template
 * 1.3.6.1.4.1.19376.1.3.3.1.3 - Human Patient with Non-Human Subject
 * (recordTarget) MUST be used in the CDA header.
 */
public class ChpalmEntryHumanPatientWithNonHumanSubject
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject {

	public ChpalmEntryHumanPatientWithNonHumanSubject() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3.1.3.1"));
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
	 * Gets the hl7RelatedSubject
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedSubject getHl7RelatedSubject() {
		return relatedSubject;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7RelatedSubject
	 */
	public void setHl7RelatedSubject(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedSubject value) {
		this.relatedSubject = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
