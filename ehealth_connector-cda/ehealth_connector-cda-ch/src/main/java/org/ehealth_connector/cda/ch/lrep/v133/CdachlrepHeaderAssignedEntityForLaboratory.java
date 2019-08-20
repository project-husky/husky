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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.47
 * Template description: Reusable template for assigned entities a CDA-CH-LREP document.
 *
 * Element description: All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
 */
public class CdachlrepHeaderAssignedEntityForLaboratory {

	public CdachlrepHeaderAssignedEntityForLaboratory() {
		id.add(createHl7IdFixedValue("NAV", "2.51.1.3"));
	// cdachlrep_header_AssignedEntityForLaboratory/hl7:id:cs nullFlavor = "NAV";
	// cdachlrep_header_AssignedEntityForLaboratory/hl7:id:cs root = "2.51.1.3";
	}

	/**
	 * Address of the laboratory.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.AD> addr = new ArrayList<org.ehealth_connector.common.hl7cdar2.AD>();

	/**
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Person assignedPerson;

	/**
	 * A GS1 GLN is required. If it is not (yet) known, this MUST be declared using nullFlavor.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> id = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

	/**
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization representedOrganization;

	/**
	 * Phone and eMail of the laboratory.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.TEL> telecom = new ArrayList<org.ehealth_connector.common.hl7cdar2.TEL>();

	/**
	 * Adds a hl7Addr
	 * Address of the laboratory.
	 */
	public void addHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		addr.add(value);
	}

	/**
	 * Adds a hl7Id
	 * A GS1 GLN is required. If it is not (yet) known, this MUST be declared using nullFlavor.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		id.add(value);
	}

	/**
	 * Adds a hl7Telecom
	 * Phone and eMail of the laboratory.
	 */
	public void addHl7Telecom(org.ehealth_connector.common.hl7cdar2.TEL value) {
		telecom.add(value);
	}

	/**
	 * Adds a hl7Addr
	 * Address of the laboratory.
	 */
	public void clearHl7Addr() {
		addr.clear();
	}

	/**
	 * Adds a hl7Id
	 * A GS1 GLN is required. If it is not (yet) known, this MUST be declared using nullFlavor.
	 */
	public void clearHl7Id() {
		id.clear();
	}

	/**
	 * Adds a hl7Telecom
	 * Phone and eMail of the laboratory.
	 */
	public void clearHl7Telecom() {
		telecom.clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Id
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7IdFixedValue(String nullFlavor, String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7AssignedPerson
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Person getHl7AssignedPerson() {
		return assignedPerson;
	}

	/**
	 * Gets the hl7RepresentedOrganization
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization getHl7RepresentedOrganization() {
		return representedOrganization;
	}

	/**
	 * Sets the hl7AssignedPerson
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	public void setHl7AssignedPerson(org.ehealth_connector.common.hl7cdar2.POCDMT000040Person value) {
		this.assignedPerson = value;
	}

	/**
	 * Sets the hl7RepresentedOrganization
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	public void setHl7RepresentedOrganization(org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization value) {
		this.representedOrganization = value;
	}
}
