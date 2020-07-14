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
package org.ehealth_connector.cda.ch.emed.v096;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.35 Template
 * description: Dosage Instructions are a set of data elements which together
 * represent the dosage instructions to a medication such as duration of
 * treatment, medication frequency, dose quantity, route of administration, etc.
 * Dosage Instructions may be provided structured and/or narrative. This entry
 * describes structured dosage instructions.
 */
public class DosageInstructionsStartStopFrequency
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	/**
	 * Creates fixed contents for CDA Element hl7EffectiveTime
	 *
	 * @param operator
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.EIVLTS createHl7EffectiveTimeFixedValue(
			String operator) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.EIVLTS retVal = factory.createEIVLTS();
		retVal.setOperator(org.ehealth_connector.common.hl7cdar2.SetOperator.fromValue(operator));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7RouteCode
	 */
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7RouteCodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		return retVal;
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.EIVLTS, filled
	 * by: "A"
	 *
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.EIVLTS getPredefinedEffectiveTimeA() {
		return createHl7EffectiveTimeFixedValue("A");
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.CE, filled by:
	 *
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.CE getPredefinedRouteCode() {
		return createHl7RouteCodeFixedValue();
	}

	public DosageInstructionsStartStopFrequency() {
	}

	/**
	 * Adds a hl7ApproachSiteCode
	 */
	public void addHl7ApproachSiteCode(org.ehealth_connector.common.hl7cdar2.CD value) {
		getApproachSiteCode().add(value);
	}

	/**
	 * Adds a hl7ApproachSiteCode
	 */
	public void clearHl7ApproachSiteCode() {
		getApproachSiteCode().clear();
	}

	/**
	 * Gets the hl7DoseQuantity
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
		return doseQuantity;
	}

	/**
	 * Gets the hl7EffectiveTime Dosage Instructions PCC 6.3.4.16.10 - Start and
	 * Stop
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.SXCMTS> getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7RateQuantity
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLPQ getHl7RateQuantity() {
		return rateQuantity;
	}

	/**
	 * Gets the hl7RepeatNumber Number of repeats/refills
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLINT getHl7RepeatNumber() {
		return repeatNumber;
	}

	/**
	 * Gets the hl7RouteCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7RouteCode() {
		return routeCode;
	}

	/**
	 * Sets the hl7DoseQuantity
	 */
	public void setHl7DoseQuantity(org.ehealth_connector.common.hl7cdar2.IVLPQ value) {
		this.doseQuantity = value;
	}

	/**
	 * Sets the hl7EffectiveTime Dosage Instructions PCC 6.3.4.16.10 - Start and
	 * Stop
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.SXCMTS value) {
		getEffectiveTime().clear();
		getEffectiveTime().add(value);
	}

	/**
	 * Sets the hl7RateQuantity
	 */
	public void setHl7RateQuantity(org.ehealth_connector.common.hl7cdar2.IVLPQ value) {
		this.rateQuantity = value;
	}

	/**
	 * Sets the hl7RepeatNumber Number of repeats/refills
	 */
	public void setHl7RepeatNumber(org.ehealth_connector.common.hl7cdar2.IVLINT value) {
		this.repeatNumber = value;
	}

	/**
	 * Sets the hl7RouteCode
	 */
	public void setHl7RouteCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.routeCode = value;
	}
}
