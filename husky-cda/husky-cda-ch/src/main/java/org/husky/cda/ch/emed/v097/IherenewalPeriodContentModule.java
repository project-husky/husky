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
package org.husky.cda.ch.emed.v097;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;

/**
 * IHERenewalPeriodContentModule
 *
 * Template description: <div>Renewal Period Content Module describes the possible renewal of a Prescription Item in terms 1985 of duration or period of time (start / end date).</div>
 *
 * Element description: Renewal Period General Specification
 *
 * <!-- @formatter:off -->
 * Identifier: 1.3.6.1.4.1.19376.1.9.1.3.15
 * Effective date: 2018-01-11 15:34:25
 * Version: 2017
 * Status: pending
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class IherenewalPeriodContentModule
		extends org.husky.common.hl7cdar2.POCDMT000040Supply {

	public IherenewalPeriodContentModule() {
		super.setClassCode(org.husky.common.hl7cdar2.ActClassSupply.SPLY);
		super.setMoodCode(org.husky.common.hl7cdar2.XDocumentSubstanceMood.RQO);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.15"));
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7EffectiveTime In case the renewal period is bound by a
	 * precise date
	 */
	public java.util.List<org.husky.common.hl7cdar2.SXCMTS> getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7TemplateId Renewal Period effectiveTime
	 */
	public java.util.List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7EffectiveTime In case the renewal period is bound by a
	 * precise date
	 */
	public void setHl7EffectiveTime(org.husky.common.hl7cdar2.SXCMTS value) {
		getEffectiveTime().clear();
		getEffectiveTime().add(value);
	}

	/**
	 * Sets the hl7TemplateId Renewal Period effectiveTime
	 */
	public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
