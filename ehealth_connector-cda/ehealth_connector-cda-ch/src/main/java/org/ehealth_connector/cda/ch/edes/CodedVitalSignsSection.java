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

package org.ehealth_connector.cda.ch.edes;

import org.ehealth_connector.cda.AbstractCodedVitalSigns;
import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;

public class CodedVitalSignsSection extends AbstractCodedVitalSigns {

	/**
	 * Instantiates a new vital signs section.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public CodedVitalSignsSection(LanguageCode languageCode) {
		super(IHEFactory.eINSTANCE.createCodedVitalSignsSection().init());
		this.setLanguageCode(languageCode);
		this.getMdht().setTitle(Util.st(SectionsEDES.CODED_VITAL_SIGNS
				.getSectionTitle((languageCode != null ? languageCode : null))));
	}

	/**
	 * Instantiates a new vital signs section.
	 *
	 * @param languageCode
	 *            the sections language
	 *
	 * @param section
	 *            the vital signs section
	 */
	protected CodedVitalSignsSection(LanguageCode languageCode,
			org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection section) {
		super(section);
		this.setLanguageCode(languageCode);
	}

	/**
	 * Instantiates a new vital signs section.
	 *
	 * @param section
	 *            the vital signs section
	 */
	protected CodedVitalSignsSection(
			org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection section) {
		super(section);
	}

	/**
	 * Creates a new EDES VitalSignObservation.
	 *
	 * @return EDES VitalSignObservation
	 */
	@Override
	protected AbstractVitalSignObservation createVitalSignObservation(VitalSignObservation mdht) {
		return new org.ehealth_connector.cda.ch.edes.VitalSignObservation(mdht);
	}

	/**
	 * Creates a UUID for EDES documents as Identificator.
	 *
	 * @return UUID as Identificator
	 */
	@Override
	protected Identificator getUuid() {
		return CdaChUtil.createUniqueIdentificator();
	}

	/**
	 * Initializes internal lists when the CDA was loaded from file
	 */
	public void initAfterLoad() {
		for (org.openhealthtools.mdht.uml.cda.ccd.VitalSignsOrganizer vsOrg : getMdht()
				.getVitalSignsOrganizers()) {
			for (Observation mdhtObs : vsOrg.getObservations()) {
				myVitalSignObservations.add(new org.ehealth_connector.cda.Observation(mdhtObs));
			}
		}

	}

	/**
	 * Sets the vital signs organizer.
	 *
	 * @param organizer
	 *            the new vital signs organizer
	 */
	public void setVitalSignsOrganizer(VitalSignsOrganizer organizer) {
		getMdht().getEntries().clear();
		getMdht().addOrganizer(organizer.copy());
	}

}
