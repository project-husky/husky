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

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.33 Template
 * description: Reusable template wherever an organization with required id,
 * name, address and communication means is used in a CDA-CH V2 document. CDA-CH
 * V2 derivatives, i.e. Swiss exchange formats MAY use this template by either
 * reference or specialisation.
 *
 * Element description: The organization's address.
 */
public class CdachOtherOrganizationCompilationIdNameAddrTelecom
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization {

	public CdachOtherOrganizationCompilationIdNameAddrTelecom() {
	}

	/**
	 * Adds a hl7Addr The organization's address.
	 */
	public void addHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		getAddr().add(value);
	}

	/**
	 * Adds a hl7Id The organization's id.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Name The organization's name.
	 */
	public void addHl7Name(org.ehealth_connector.common.hl7cdar2.ON value) {
		getName().add(value);
	}

	/**
	 * Adds a hl7Telecom The organization's means of communication (phone,
	 * eMail, ...).
	 */
	public void addHl7Telecom(org.ehealth_connector.common.hl7cdar2.TEL value) {
		getTelecom().add(value);
	}

	/**
	 * Adds a hl7Addr The organization's address.
	 */
	public void clearHl7Addr() {
		getAddr().clear();
	}

	/**
	 * Adds a hl7Id The organization's id.
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Adds a hl7Name The organization's name.
	 */
	public void clearHl7Name() {
		getName().clear();
	}

	/**
	 * Adds a hl7Telecom The organization's means of communication (phone,
	 * eMail, ...).
	 */
	public void clearHl7Telecom() {
		getTelecom().clear();
	}
}
