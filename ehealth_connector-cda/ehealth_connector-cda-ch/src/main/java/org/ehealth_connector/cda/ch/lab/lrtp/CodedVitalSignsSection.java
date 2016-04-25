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
package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.AbstractCodedVitalSigns;
import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;

/**
 * The Class CodedVitalSignsSection. <div class="en">This section contains a
 * list of measured / observed coded vital signs.</div> <div class="de">Dieser
 * Abschnitt enthält eine Liste der gemessenen/beobachteten Vitalzeichen. Die
 * Angabe erfolgt codiert.</div>
 */
public class CodedVitalSignsSection extends AbstractCodedVitalSigns {

	/**
	 * Instantiates a new coded vital signs section.
	 */
	public CodedVitalSignsSection() {
		super();
	}

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
	 * Instantiates the class with the required elements.
	 *
	 * @param languageCode
	 *            the language code
	 * @param organizer
	 *            the VitalSignsOrganizer
	 */
	public CodedVitalSignsSection(LanguageCode languageCode, VitalSignsOrganizer organizer) {
		this(languageCode);
		setVitalSignsOrganizer(organizer);
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
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCodedVitalSigns#createVitalSignObservation(org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation)
	 */
	@Override
	protected AbstractVitalSignObservation createVitalSignObservation(VitalSignObservation mdht) {
		return new org.ehealth_connector.cda.ch.lab.lrtp.VitalSignsObservation(mdht);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCodedVitalSigns#getUuid()
	 */
	@Override
	protected Identificator getUuid() {
		return CdaChUtil.createUniqueIdentificator();
	}

	/**
	 * Gets the vital signs organizer.
	 *
	 * @return the vital signs organizer
	 */
	public VitalSignsOrganizer getVitalSignsOrganizer() {
		if (!getMdht().getVitalSignsOrganizers().isEmpty()) {
			return new VitalSignsOrganizer(
					(org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer) getMdht()
							.getVitalSignsOrganizers().get(0));
		}
		return null;
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
