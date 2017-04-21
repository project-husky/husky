/*
 * 
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
package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.MdhtSectionFacade;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class StudiesSummarySection. <div class="en">This element contains
 * information about the blood group.</div> <div class="de">Dieses Element
 * enthält die Daten zur Blutgruppe.</div>
 */
public class StudiesSummarySection
		extends MdhtSectionFacade<org.openhealthtools.mdht.uml.cda.ch.StudiesSummarySection> {

	/**
	 * Instantiates a new studies summary section.
	 */
	public StudiesSummarySection() {
		super(CHFactory.eINSTANCE.createStudiesSummarySection().init(),
				"2.16.756.5.30.1.1.1.1.3.4.1", "CDA-CH.LRTP.Body.StudiesSummaryL2");
	}

	/**
	 * Instantiates a new studies summary section.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public StudiesSummarySection(LanguageCode languageCode) {
		this();
		switch (languageCode) {
		case FRENCH:
			setTitle("Groupe sanguin");
			break;
		case GERMAN:
			this.setTitle("Blutgruppe");
			break;
		case ITALIAN:
			setTitle("Gruppo sanguigno");
			break;
		case ENGLISH:
			setTitle("Blood Group");
			break;
		}
	}

	/**
	 * Instantiates a new studies summary section.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public StudiesSummarySection(org.openhealthtools.mdht.uml.cda.ch.StudiesSummarySection mdht) {
		super(mdht);
	}

	/**
	 * Gets the blood group.
	 *
	 * @return the blood group
	 */
	public BloodGroupObservation getBloodGroup() {
		if (!getMdht().getBloodgroupObservations().isEmpty()) {
			return new BloodGroupObservation(getMdht().getBloodgroupObservations().get(0));
		}
		return null;
	}

	/**
	 * Sets the blood group.
	 *
	 * @param bloodGroup
	 *            the new blood group
	 */
	public void setBloodGroup(BloodGroupObservation bloodGroup) {
		if (!getMdht().getBloodgroupObservations().isEmpty()) {
			getMdht().getEntries().clear();
			getMdht().addObservation(bloodGroup.copy());
		} else {
			getMdht().addObservation(bloodGroup.copy());
		}
	}
}
