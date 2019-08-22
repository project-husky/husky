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

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.840.1.113883.10.12.151
 * Template description: Template CDA Organization (prototype, directly derived from POCD_RM000040 MIF)
 */
public class Cdaorganization {

	public Cdaorganization() {
		this.asOrganizationPartOf = createHl7AsOrganizationPartOfFixedValue("PART");
	// CDAOrganization/hl7:asOrganizationPartOf:null classCode = "PART";
	}

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.AD> addr = new ArrayList<org.ehealth_connector.common.hl7cdar2.AD>();

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf asOrganizationPartOf;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> id = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.ON> name = new ArrayList<org.ehealth_connector.common.hl7cdar2.ON>();

	/**
	 * SHALL be chosen from domain OrganizationIndustryClass
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.CE standardIndustryClassCode;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.TEL> telecom = new ArrayList<org.ehealth_connector.common.hl7cdar2.TEL>();

	/**
	 * Adds a hl7Addr
	 */
	public void addHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		addr.add(value);
	}

	/**
	 * Adds a hl7Id
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		id.add(value);
	}

	/**
	 * Adds a hl7Name
	 */
	public void addHl7Name(org.ehealth_connector.common.hl7cdar2.ON value) {
		name.add(value);
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void addHl7Telecom(org.ehealth_connector.common.hl7cdar2.TEL value) {
		telecom.add(value);
	}

	/**
	 * Adds a hl7Addr
	 */
	public void clearHl7Addr() {
		addr.clear();
	}

	/**
	 * Adds a hl7Id
	 */
	public void clearHl7Id() {
		id.clear();
	}

	/**
	 * Adds a hl7Name
	 */
	public void clearHl7Name() {
		name.clear();
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void clearHl7Telecom() {
		telecom.clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7AsOrganizationPartOf
	 *
	 * @param classCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf createHl7AsOrganizationPartOfFixedValue(String classCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf retVal = factory.createPOCDMT000040OrganizationPartOf();
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
	 * Gets the hl7StandardIndustryClassCode
	 * SHALL be chosen from domain OrganizationIndustryClass
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7StandardIndustryClassCode() {
		return standardIndustryClassCode;
	}

	/**
	 * Sets the hl7AsOrganizationPartOf
	 */
	public void setHl7AsOrganizationPartOf(org.ehealth_connector.common.hl7cdar2.POCDMT000040OrganizationPartOf value) {
		this.asOrganizationPartOf = value;
	}

	/**
	 * Sets the hl7StandardIndustryClassCode
	 * SHALL be chosen from domain OrganizationIndustryClass
	 */
	public void setHl7StandardIndustryClassCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.standardIndustryClassCode = value;
	}
}
