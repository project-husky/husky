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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.55 Template
 * description: CDA-CH-LREP V1 bases on CDA-CH V2 (2017) and XD-LAB (IHE PaLM TF
 * 8.0, 2017).
 *
 * Element description: Sharing Laboratory Reports (XD-LAB) Content Module, IHE
 * PaLM Technical Framework Revision Revision 8.0 - June 21, 2017.
 */
public class CdachlrepHeaderTemplateIdsCdaChLrepV1
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

	public CdachlrepHeaderTemplateIdsCdaChLrepV1() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.127.1.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3"));
		// This is fixed content for an optional element:
		// createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.3.9.1") -->
		// Creating getPredefinedTemplateId2167565301111391();
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
	 * Gets the hl7TemplateId CDA-CH-LREP / Laboratory Reports V1 specification.
	 * This is an informational reference, only.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.II, filled by:
	 * "2.16.756.5.30.1.1.1.1.3.9.1"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.II getPredefinedTemplateId2167565301111391() {
		return createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.3.9.1");
	}

	/**
	 * Sets the hl7TemplateId CDA-CH-LREP / Laboratory Reports V1 specification.
	 * This is an informational reference, only.
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
