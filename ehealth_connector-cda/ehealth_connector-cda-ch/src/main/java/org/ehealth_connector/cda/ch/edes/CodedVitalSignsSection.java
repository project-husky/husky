/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch.edes;

import org.ehealth_connector.cda.AbstractCodedVitalSigns;
import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
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
