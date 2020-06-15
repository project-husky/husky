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
 * Original ART-DECOR template id: 1.3.6.1.4.1.19376.1.5.3.1.4.7.2 Template
 * description: <div>The product entry describes a medication or immunization
 * used in a
 * &lt;substanceAdministration&gt; <span style="line-height: 1.22;">or
 * &lt;supply&gt; act. It adopts the constraints of the ASTM/HL7 Continuity of
 * Care Document.</span></div>
 */
public class IheproductEntry
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ManufacturedProduct {

	public IheproductEntry() {
		super.setClassCode(org.ehealth_connector.common.hl7cdar2.RoleClassManufacturedProduct
				.fromValue("MANU"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.53"));
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
	 * Gets the hl7ManufacturedMaterial
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Material getHl7ManufacturedMaterial() {
		return manufacturedMaterial;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7ManufacturedMaterial
	 */
	public void setHl7ManufacturedMaterial(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Material value) {
		this.manufacturedMaterial = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
