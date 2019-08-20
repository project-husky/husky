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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.26
 * Template description: Reusable template wherever an organization with required GLN as id, name, address and communication means is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.
 *
 * Element description: The organization's address.
 */
public class CdachOtherOrganizationCompilationGlnNameAddrTelecom {

	public CdachOtherOrganizationCompilationGlnNameAddrTelecom() {
		id.add(createHl7IdFixedValue("2.51.1.3"));
	// cdach_other_OrganizationCompilationGlnNameAddrTelecom/hl7:id:uid root = "2.51.1.3";
	}

	/**
	 * The organization's address.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.AD> addr = new ArrayList<org.ehealth_connector.common.hl7cdar2.AD>();

	/**
	 * The organization's id (GLN).
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> id = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

	/**
	 * The organization's name.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.ON> name = new ArrayList<org.ehealth_connector.common.hl7cdar2.ON>();

	/**
	 * The organization's means of communication (phone, eMail, ...).
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.TEL> telecom = new ArrayList<org.ehealth_connector.common.hl7cdar2.TEL>();

	/**
	 * Adds a hl7Addr
	 * The organization's address.
	 */
	public void addHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		addr.add(value);
	}

	/**
	 * Adds a hl7Name
	 * The organization's name.
	 */
	public void addHl7Name(org.ehealth_connector.common.hl7cdar2.ON value) {
		name.add(value);
	}

	/**
	 * Adds a hl7Telecom
	 * The organization's means of communication (phone, eMail, ...).
	 */
	public void addHl7Telecom(org.ehealth_connector.common.hl7cdar2.TEL value) {
		telecom.add(value);
	}

	/**
	 * Adds a hl7Addr
	 * The organization's address.
	 */
	public void clearHl7Addr() {
		addr.clear();
	}

	/**
	 * Adds a hl7Name
	 * The organization's name.
	 */
	public void clearHl7Name() {
		name.clear();
	}

	/**
	 * Adds a hl7Telecom
	 * The organization's means of communication (phone, eMail, ...).
	 */
	public void clearHl7Telecom() {
		telecom.clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Id
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7IdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7Id
	 * The organization's id (GLN).
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (id != null)
			if (id.size() > 0)
				retVal = id.get(0);
		return retVal;
	}

	/**
	 * Sets the hl7Id
	 * The organization's id (GLN).
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		id.clear();
		id.add(value);
	}
}
