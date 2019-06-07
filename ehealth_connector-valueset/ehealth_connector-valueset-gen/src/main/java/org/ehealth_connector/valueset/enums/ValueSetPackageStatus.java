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
package org.ehealth_connector.valueset.enums;

/**
 * <div class="en">Availability status of a value set package. Availability is
 * based on HL7 FIHR.</div> <div class="de">Verfügbarkeitsstatus eines Value Set
 * Pakets. Die Verfügbarkeit orientiert sich an HL7 FIHR.</div>. See
 * https://www.hl7.org/fhir/Value Set-publication-status.html.
 */
public enum ValueSetPackageStatus {
	//@formatter:off
	/**
	 * <div class="en">Available Value Set package, which can be used for testing and further development. May be valid or not.</div>
	 * <div class="de">Verfügbares Value Set Paket, welches für Tests und Weiterentwicklung verwendet werden kann. Kann Gültig sein oder nicht.</div>
	 */
	DRAFT,

	/**
	 * <div class="en">Active Value Set Package. Is always valid.</div>
	 * <div class="de">Aktives Value Set Paket. Ist immer gültig.</div>
	 */
	ACTIVE,

	/**
	 * <div class="en">Outdated Value Set package which should not be used anymore.</div>
	 * <div class="de">Veraltetes Value Set Paket welches nicht mehr verwendet werden sollte.</div>
	 */
	RETIRED,

	/**
	 * <div class="en">The status is unknown.</div>
	 * <div class="de">Der Status ist nicht bekannt.</div>
	 */
	UNKNOWN;
	//@formatter:on

}
