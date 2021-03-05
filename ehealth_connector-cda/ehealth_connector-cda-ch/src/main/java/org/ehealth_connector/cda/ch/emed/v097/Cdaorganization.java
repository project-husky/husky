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
package org.ehealth_connector.cda.ch.emed.v097;

import javax.annotation.Generated;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * CDAOrganization
 *
 * Template description: Template CDA Organization (prototype, directly derived from POCD_RM000040 MIF)
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.840.1.113883.10.12.151
 * Effective date: 2005-09-07 00:00:00
 * Status: active
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class Cdaorganization
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization {

	public Cdaorganization() {
	}

	/**
	 * Adds a hl7Addr
	 */
	public void addHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		getAddr().add(value);
	}

	/**
	 * Adds a hl7Id
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Name
	 */
	public void addHl7Name(org.ehealth_connector.common.hl7cdar2.ON value) {
		getName().add(value);
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void addHl7Telecom(org.ehealth_connector.common.hl7cdar2.TEL value) {
		getTelecom().add(value);
	}

	/**
	 * Adds a hl7Addr
	 */
	public void clearHl7Addr() {
		getAddr().clear();
	}

	/**
	 * Adds a hl7Id
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Adds a hl7Name
	 */
	public void clearHl7Name() {
		getName().clear();
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void clearHl7Telecom() {
		getTelecom().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7AsOrganizationPartOf
	 *
	 * @param classCode
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf createHl7AsOrganizationPartOfFixedValue(
			String classCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf retVal = factory
				.createPOCDMT000040OrganizationPartOf();
		retVal.getClassCode().add(classCode);
		return retVal;
	}

	/**
	 * Gets the hl7AsOrganizationPartOf
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf getHl7AsOrganizationPartOf() {
		return asOrganizationPartOf;
	}

	/**
	 * Gets the hl7StandardIndustryClassCode SHALL be chosen from domain
	 * OrganizationIndustryClass
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7StandardIndustryClassCode() {
		return standardIndustryClassCode;
	}

	/**
	 * Adds a predefined
	 * org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf,
	 * filled by: "PART"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf getPredefinedAsOrganizationPartOfPart() {
		return createHl7AsOrganizationPartOfFixedValue("PART");
	}

	/**
	 * Sets the hl7AsOrganizationPartOf
	 */
	public void setHl7AsOrganizationPartOf(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf value) {
		this.asOrganizationPartOf = value;
	}

	/**
	 * Sets the hl7StandardIndustryClassCode SHALL be chosen from domain
	 * OrganizationIndustryClass
	 */
	public void setHl7StandardIndustryClassCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.standardIndustryClassCode = value;
	}
}
