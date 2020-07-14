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
package org.ehealth_connector.cda.ch.vacd.v210;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.67 Template
 * description: CDA-CH-VACD V2 bases on CDA-CH V2.1 (2020) and the Immunization
 * Content profile (IHE PCC TF 11.0, 2016). This template defines the rules for
 * documents to be published in the Swiss EPR.
 *
 * Element description: Medical Documents Specification, IHE PCC Technical
 * Framework Revision 11.0 - November 11, 2016.
 */
public class CdachvacdHeaderTemplateIdsCdaChVacdV2Epr
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

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
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.II, filled by:
	 * "2.16.756.5.30.1.1.1.1.3.5.2"
	 *
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.II getPredefinedTemplateId2167565301111352() {
		return createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.3.5.2");
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.II, filled by:
	 * "2.16.756.5.30.1.127.1.4"
	 *
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.II getPredefinedTemplateId216756530112714() {
		return createHl7TemplateIdFixedValue("2.16.756.5.30.1.127.1.4");
	}

	public CdachvacdHeaderTemplateIdsCdaChVacdV2Epr() {
		super.getTemplateId()
				.add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.18.1.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.1"));
	}

	/**
	 * Gets the hl7TemplateId CDA-CH-VACD / eVACDOC V2.1 specification. This is
	 * an informational reference, only.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7TemplateId CDA-CH-VACD / eVACDOC V2.1 specification. This is
	 * an informational reference, only.
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
