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
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.12
 * Template description: Reusable template wherever an assigned entity with a required id is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.
 *
 * Element description: The assigned organization.
 */
public class CdachOtherAssignedEntityCompilationId {

	public CdachOtherAssignedEntityCompilationId() {
		this.code = createHl7CodeFixedValue("2.16.840.1.113883.6.96", "SNOMED CT");
	// cdach_other_AssignedEntityCompilationId/hl7:code:cs valueSet = valueSet("2.16.756.5.30.1.127.3.10.1.1.3");
	// cdach_other_AssignedEntityCompilationId/hl7:code:oid codeSystem = "2.16.840.1.113883.6.96";
	// cdach_other_AssignedEntityCompilationId/hl7:code:st codeSystemName = "SNOMED CT";
	}

	/**
	 * The assigned entity's address.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.AD> addr = new ArrayList<org.ehealth_connector.common.hl7cdar2.AD>();

	/**
	 * The assigned person.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Person assignedPerson;

	/**
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.CE code;

	/**
	 * The assigned entity's id (including the assigned person's id).
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> id = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

	/**
	 * The assigned organization.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization representedOrganization;

	/**
	 * The assigned entity's means of communication (phone, eMail, ...).
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.TEL> telecom = new ArrayList<org.ehealth_connector.common.hl7cdar2.TEL>();

	/**
	 * Adds a hl7Addr
	 * The assigned entity's address.
	 */
	public void addHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		addr.add(value);
	}

	/**
	 * Adds a hl7Id
	 * The assigned entity's id (including the assigned person's id).
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		id.add(value);
	}

	/**
	 * Adds a hl7Telecom
	 * The assigned entity's means of communication (phone, eMail, ...).
	 */
	public void addHl7Telecom(org.ehealth_connector.common.hl7cdar2.TEL value) {
		telecom.add(value);
	}

	/**
	 * Adds a hl7Addr
	 * The assigned entity's address.
	 */
	public void clearHl7Addr() {
		addr.clear();
	}

	/**
	 * Adds a hl7Id
	 * The assigned entity's id (including the assigned person's id).
	 */
	public void clearHl7Id() {
		id.clear();
	}

	/**
	 * Adds a hl7Telecom
	 * The assigned entity's means of communication (phone, eMail, ...).
	 */
	public void clearHl7Telecom() {
		telecom.clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7CodeFixedValue(String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		return retVal;
	}

	/**
	 * Gets the hl7AssignedPerson
	 * The assigned person.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Person getHl7AssignedPerson() {
		return assignedPerson;
	}

	/**
	 * Gets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7RepresentedOrganization
	 * The assigned organization.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization getHl7RepresentedOrganization() {
		return representedOrganization;
	}

	/**
	 * Sets the hl7AssignedPerson
	 * The assigned person.
	 */
	public void setHl7AssignedPerson(org.ehealth_connector.common.hl7cdar2.POCDMT000040Person value) {
		this.assignedPerson = value;
	}

	/**
	 * Sets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7RepresentedOrganization
	 * The assigned organization.
	 */
	public void setHl7RepresentedOrganization(org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization value) {
		this.representedOrganization = value;
	}
}
