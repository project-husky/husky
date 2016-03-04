package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.AbstractCodedVitalSigns;
import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;

public class CodedVitalSignsSection extends AbstractCodedVitalSigns {

	/**
	 * Instantiates a new vital signs section.
	 *
	 * @param languageCode
	 *          the language code
	 */
	public CodedVitalSignsSection(LanguageCode languageCode) {
		super(IHEFactory.eINSTANCE.createCodedVitalSignsSection().init());
		this.languageCode = languageCode;
		this.getMdht().setTitle(Util.st(SectionsEDES.CODED_VITAL_SIGNS
				.getSectionTitle((languageCode != null ? languageCode : null))));
	}

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param languageCode
	 *          the language code
	 * @param organizer
	 *          the VitalSignsOrganizer
	 */
	public CodedVitalSignsSection(LanguageCode languageCode, VitalSignsOrganizer organizer) {
		this(languageCode);
		setVitalSignsOrganizer(organizer);
	}

	/**
	 * Instantiates a new vital signs section.
	 *
	 * @param section
	 *          the vital signs section
	 */
	protected CodedVitalSignsSection(
			org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection section) {
		super(section);
	}

	@Override
	protected AbstractVitalSignObservation createVitalSignObservation(VitalSignObservation mdht) {
		return new org.ehealth_connector.cda.ch.lab.lrtp.VitalSignsObservation(mdht);
	}

	@Override
	protected Identificator getUuid() {
		return CdaChLrtp.createUuidLrtp(null);
	}

	public VitalSignsOrganizer getVitalSignsOrganizer() {
		if (!getMdht().getVitalSignsOrganizers().isEmpty()) {
			return new VitalSignsOrganizer(
					(org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer) getMdht()
							.getVitalSignsOrganizers().get(0));
		}
		return null;
	}

	public void setVitalSignsOrganizer(VitalSignsOrganizer organizer) {
		getMdht().getEntries().clear();
		getMdht().addOrganizer(organizer.copy());
	}
}
