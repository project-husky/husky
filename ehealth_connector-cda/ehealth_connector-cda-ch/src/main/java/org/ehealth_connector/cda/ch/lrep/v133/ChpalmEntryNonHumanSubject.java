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

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.5
 * Template description: If, in a part of the document, laboratory obseravtions base exclusively on a sample of a non-human material (e.g., animal, water, soil, etc.) without reference to a patient, it MUST be declared using this element in the CDA body.Other parts of the document may contain laboratory observations that base on other samples (including samples taken from the patient).In addition, the IHE template 1.3.6.1.4.1.19376.1.3.3.1.2 - Non-Human Subject (recordTarget) MUST be used in the CDA header.
 */
public class ChpalmEntryNonHumanSubject {

	public ChpalmEntryNonHumanSubject() {
		templateId.add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.5"));
		templateId.add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3.1.2.1"));
	// chpalm_entry_NonHumanSubject/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.5";
	// chpalm_entry_NonHumanSubject/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.3.3.1.2.1";
	}

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedSubject relatedSubject;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> templateId = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

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
	 * Gets the hl7RelatedSubject
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedSubject getHl7RelatedSubject() {
		return relatedSubject;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (templateId != null)
			if (templateId.size() > 0)
				retVal = templateId.get(0);
		return retVal;
	}

	/**
	 * Sets the hl7RelatedSubject
	 */
	public void setHl7RelatedSubject(org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedSubject value) {
		this.relatedSubject = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		templateId.clear();
		templateId.add(value);
	}
}
