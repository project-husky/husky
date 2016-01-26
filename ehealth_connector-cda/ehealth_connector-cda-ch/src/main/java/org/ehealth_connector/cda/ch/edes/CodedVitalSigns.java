package org.ehealth_connector.cda.ch.edes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.ccd.CCDFactory;
import org.openhealthtools.mdht.uml.cda.ccd.VitalSignsOrganizer;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignsSection;

public class CodedVitalSigns extends MdhtFacade<VitalSignsSection> {

	// default language is German
	private LanguageCode languageCode = LanguageCode.GERMAN;

	/**
	 * Instantiates a new vital signs section.
	 * 
	 * @param languageCode
	 *            the language code
	 */
	public CodedVitalSigns(LanguageCode languageCode) {
		super(IHEFactory.eINSTANCE.createVitalSignsSection().init(), null, null);
		this.languageCode = languageCode;
		this.getMdht().setTitle(
				Util.st(SectionsEDES.CODED_VITAL_SIGNS
						.getSectionTitle((languageCode != null ? languageCode.getCS() : null))));
	}

	/**
	 * Instantiates a new vital signs section.
	 * 
	 * @param section
	 *            the vital signs section
	 */
	protected CodedVitalSigns(VitalSignsSection section) {
		super(section, null, null);
	}

	public void add(VitalSignObservation sign) {
		VitalSignsOrganizer organizer = getOrganizerForDate(sign.getEffectiveTime());
		organizer.addObservation(sign.getMdhtCopy());
	}

	private VitalSignsOrganizer getOrganizerForDate(Date effectiveTime) {
		VitalSignsSection section = getMdht();
		EList<VitalSignsOrganizer> organizers = section.getVitalSignsOrganizers();
		for (VitalSignsOrganizer organizer : organizers) {
			Date organizerDate = DateUtil.parseIVL_TSVDateTimeValue(organizer.getEffectiveTime());
			if (organizerDate.equals(effectiveTime)) {
				return organizer;
			}
		}
		VitalSignsOrganizer organizer = CCDFactory.eINSTANCE.createVitalSignsOrganizer();
		try {
			organizer.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(effectiveTime));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		section.addOrganizer(organizer);
		return organizer;
	}

	public List<VitalSignObservation> getCodedVitalSignObservations() {
		List<VitalSignObservation> ret = new ArrayList<VitalSignObservation>();
		EList<Organizer> organizers = getMdht().getOrganizers();
		for (Organizer organizer : organizers) {
			EList<Observation> observations = organizer.getObservations();
			for (Observation observation : observations) {
				if (observation instanceof org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation) {
					ret.add(new VitalSignObservation(
							(org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation) observation));
				}
			}
		}
		return ret;
	}
}
