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

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.118
 * Template description: Each chapter (Laboratory Speciality Section and Laboratory Report Item Section) MUST contain exactly one findings group (CDA Body Laboratory Report Data Processing Entry).
 */
public class CdachlrepEntryLaboratoryReportDataProcessingEntry {

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Act act;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> templateId = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

	/**
	 * Gets the hl7Act
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Act getHl7Act() {
		return act;
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
	 * Sets the hl7Act
	 */
	public void setHl7Act(org.ehealth_connector.common.hl7cdar2.POCDMT000040Act value) {
		this.act = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		templateId.clear();
		templateId.add(value);
	}
}
