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
package org.ehealth_connector.cda.ch.emed.v0954;

import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 1.3.6.1.4.1.19376.1.9.1.3.15 Template
 * description: <div>Renewal Period Content Module describes the possible
 * renewal of a Prescription Item in terms 1985 of duration or period of time
 * (start / end date).</div>
 *
 * Element description: Renewal Period General Specification
 */
public class IherenewalPeriodContentModule
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Supply {

	public IherenewalPeriodContentModule() {
		super.setClassCode(org.ehealth_connector.common.hl7cdar2.ActClassSupply.fromValue("SPLY"));
		super.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.fromValue("RQO"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.15"));
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
	 * Gets the hl7EffectiveTime In case the renewal period is bound by a
	 * precise date
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.SXCMTS> getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7TemplateId Renewal Period effectiveTime
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7EffectiveTime In case the renewal period is bound by a
	 * precise date
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		getEffectiveTime().clear();
		getEffectiveTime().add(value);
	}

	/**
	 * Sets the hl7TemplateId Renewal Period effectiveTime
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
