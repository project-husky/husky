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
package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.AbstractCodedVitalSigns;
import org.ehealth_connector.cda.BaseVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEdes;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

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
		this.getMdht().setTitle(Util.st(SectionsEdes.CODED_VITAL_SIGNS
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
	protected BaseVitalSignObservation createVitalSignObservation(
			org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation mdht) {
		return new VitalSignObservation(mdht);
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
