package org.ehealth_connector.cda.ch.edes;

import org.ehealth_connector.cda.AbstractCodedVitalSigns;
import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignsSection;

public class CodedVitalSigns extends AbstractCodedVitalSigns {

	/**
	 * Instantiates a new vital signs section.
	 *
	 * @param languageCode
	 *          the language code
	 */
	public CodedVitalSigns(LanguageCode languageCode) {
		super(IHEFactory.eINSTANCE.createVitalSignsSection().init());
		this.languageCode = languageCode;
		this.getMdht().setTitle(
				Util.st(SectionsEDES.CODED_VITAL_SIGNS.getSectionTitle((languageCode != null ? languageCode
						: null))));
	}

	/**
	 * Instantiates a new vital signs section.
	 *
	 * @param section
	 *          the vital signs section
	 */
	protected CodedVitalSigns(VitalSignsSection section) {
		super(section);
	}

	@Override
	protected Identificator getUuid() {
		return CdaChUtil.createUuidEdes(null);
	}

	@Override
	protected AbstractVitalSignObservation createVitalSignObservation(VitalSignObservation mdht) {
		return new org.ehealth_connector.cda.ch.edes.VitalSignObservation(mdht);
	}

}
