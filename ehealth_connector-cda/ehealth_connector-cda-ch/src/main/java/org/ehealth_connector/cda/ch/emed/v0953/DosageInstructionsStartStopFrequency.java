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
package org.ehealth_connector.cda.ch.emed.v0953;

import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.35
 * Template description: Dosage Instructions are a set of data elements which together represent the dosage instructions to a medication such as duration of treatment, medication frequency, dose quantity, route of administration, etc. Dosage Instructions may be provided structured and/or narrative. This entry describes structured dosage instructions.
 */
public class DosageInstructionsStartStopFrequency extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	public DosageInstructionsStartStopFrequency() {
	// DosageInstructionsStartStopFrequency/hl7:effectiveTime:cs operator = "A";
	// This is fixed content for an optional element: createHl7EffectiveTimeFixedValue("A") --> Creating getPredefinedEffectiveTimeA();
	// DosageInstructionsStartStopFrequency/hl7:effectiveTime:cs operator = "A";
	// DosageInstructionsStartStopFrequency/hl7:effectiveTime:cs type = "SXPR_TS";
	// DosageInstructionsStartStopFrequency/hl7:routeCode:cs valueSet = valueSet("2.16.756.5.30.1.1.11.2"); --> org.ehealth_connector.cda.ch.emed.v0953.enums.RouteOfAdministrationEdqm
	// This is fixed content for an optional element: createHl7RouteCodeFixedValue() --> Creating getPredefinedRouteCode();
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
	 * Creates fixed contents for CDA Element hl7EffectiveTime
	 *
	 * @param operator the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.IVLTS createHl7EffectiveTimeFixedValue(String operator) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.IVLTS retVal = factory.createIVLTS();
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
	 * Gets the hl7DoseQuantity
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
		return doseQuantity;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Dosage Instructions PCC 6.3.4.16.10 - Start and Stop
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
	 * Gets the hl7RouteCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7RouteCode() {
		return routeCode;
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.IVLTS, filled by: "A"
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.IVLTS getPredefinedEffectiveTimeA() {
		return createHl7EffectiveTimeFixedValue("A");
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.CE, filled by:
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.CE getPredefinedRouteCode() {
		return createHl7RouteCodeFixedValue();
	}

	/**
	 * Sets the hl7DoseQuantity
	 */
	public void setHl7DoseQuantity(org.ehealth_connector.common.hl7cdar2.IVLPQ value) {
		this.doseQuantity = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Dosage Instructions PCC 6.3.4.16.10 - Start and Stop
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
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
	 * Sets the hl7RouteCode
	 */
	public void setHl7RouteCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.routeCode = value;
	}
}
