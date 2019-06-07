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
 * <div class="en">The content of the enum is as given by ART-DECOR. In case of
 * a possible implementation of the interface to the terminology server, a
 * mapping to the available statuses in the terminology server need to be
 * made.</div> <div class="de">Der Inhalt des Enums ist wie von ART-DECOR
 * vorgegeben. Bei einer allfälligen Implementierung der Schnittstelle zum
 * Terminologieserver muss hier evtl. ein Mapping zu den verfügbaren Stati im
 * Terminologieserver gemacht werden.</div>.
 */
public enum ValueSetStatus {

	//@formatter:off
	/**
	 * <div class="en">Draft status as given by ART-DECOR.</div>
	 * <div class="de">Entwurf Status gemäss ART-DECOR.</div>
	 */
	DRAFT,

	/**
	 * <div class="en">Pending status as given by ART-DECOR.</div>
	 * <div class="de">Ausstehend Status gemäss ART-DECOR.</div>
	 */
	PENDING,

	/**
	 * <div class="en">Rejected status as given by ART-DECOR.</div>
	 * <div class="de">Abgelehnt Status gemäss ART-DECOR.</div>
	 */
	REJECTED,

	/**
	 * <div class="en">Active status as given by ART-DECOR.</div>
	 * <div class="de">Aktiv Status gemäss ART-DECOR.</div>
	 */
	ACTIVE,

	/**
	 * <div class="en">Under pre-publication review status as given by ART-DECOR.</div>
	 * <div class="de">In der Überprüfung vor der Veröffentlichung Status gemäss ART-DECOR.</div>
	 */
	PREPUBLICATIONREVIEW;
	//@formatter:on

}
