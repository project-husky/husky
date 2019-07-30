/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.ch.lrep;

import java.util.ArrayList;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.34
 * Template description: Person name information (with required family and given name) according to the eCH-0011 V8.1 nameData data type. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.See https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0011&amp;documentVersion=8.1, section 3.3.2 nameData – Namensangaben for more information.
 *
 * Element description: The person's legal name (with required family and given name).
 */
public class CdachOtherPersonNameInformationCompilationECh0011 extends org.ehealth_connector.common.hl7cdar2.PN {

	/**
	 * The person's family name ([ge]: Nachname; [fr]: nom de famille).
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.ENXP> hl7Family;

	/**
	 * The person's maiden name ([ge]: Ledigname; [fr]: nom de célibataire).
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.ENXP> hl7Family1;

	/**
	 * The person's given name ([ge]: Vorname; [fr]: prénom).
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.ENXP> hl7Given;

	/**
	 * The person's call name ([ge]: Rufname; [fr]: nom usuel).
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.ENXP> hl7Given1;

	/**
	 * The person's academic title (such as Dr. med. or Prof.).
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.ENXP> hl7Prefix;

	/**
	 * Adds a hl7Family
	 * The person's family name ([ge]: Nachname; [fr]: nom de famille).
	 */
	public void addHl7Family(org.ehealth_connector.common.hl7cdar2.ENXP value) {
		hl7Family.add(value);
	}

	/**
	 * Adds a hl7Family1
	 * The person's maiden name ([ge]: Ledigname; [fr]: nom de célibataire).
	 */
	public void addHl7Family1(org.ehealth_connector.common.hl7cdar2.ENXP value) {
		hl7Family1.add(value);
	}

	/**
	 * Adds a hl7Given
	 * The person's given name ([ge]: Vorname; [fr]: prénom).
	 */
	public void addHl7Given(org.ehealth_connector.common.hl7cdar2.ENXP value) {
		hl7Given.add(value);
	}

	/**
	 * Adds a hl7Given1
	 * The person's call name ([ge]: Rufname; [fr]: nom usuel).
	 */
	public void addHl7Given1(org.ehealth_connector.common.hl7cdar2.ENXP value) {
		hl7Given1.add(value);
	}

	/**
	 * Adds a hl7Prefix
	 * The person's academic title (such as Dr. med. or Prof.).
	 */
	public void addHl7Prefix(org.ehealth_connector.common.hl7cdar2.ENXP value) {
		hl7Prefix.add(value);
	}

	/**
	 * Adds a hl7Family
	 * The person's family name ([ge]: Nachname; [fr]: nom de famille).
	 */
	public void clearHl7Family() {
		hl7Family.clear();
	}

	/**
	 * Adds a hl7Family1
	 * The person's maiden name ([ge]: Ledigname; [fr]: nom de célibataire).
	 */
	public void clearHl7Family1() {
		hl7Family1.clear();
	}

	/**
	 * Adds a hl7Given
	 * The person's given name ([ge]: Vorname; [fr]: prénom).
	 */
	public void clearHl7Given() {
		hl7Given.clear();
	}

	/**
	 * Adds a hl7Given1
	 * The person's call name ([ge]: Rufname; [fr]: nom usuel).
	 */
	public void clearHl7Given1() {
		hl7Given1.clear();
	}

	/**
	 * Adds a hl7Prefix
	 * The person's academic title (such as Dr. med. or Prof.).
	 */
	public void clearHl7Prefix() {
		hl7Prefix.clear();
	}
}
