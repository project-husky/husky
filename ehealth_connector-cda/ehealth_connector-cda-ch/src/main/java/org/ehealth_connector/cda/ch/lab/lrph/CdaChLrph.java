package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.lab.lrph.enums.LrphSections;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.StructuredBody;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class CdaChLrph extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChLrph> {

	public CdaChLrph() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch lrph.
	 *
	 * @param languageCode
	 *          the language code
	 */
	protected CdaChLrph(LanguageCode languageCode) {
		this(languageCode, null, null);
	}

	public CdaChLrph(LanguageCode languageCode, String styleSheet, String css) {
		super(CHFactory.eINSTANCE.createCdaChLrph().init(), styleSheet, css);
		this.setLanguageCode(languageCode);
		// super.initCda();
	}

	/**
	 * Instantiates a new cda ch lrph.
	 *
	 * @param doc
	 *          mdht model document
	 */
	public CdaChLrph(org.openhealthtools.mdht.uml.cda.ch.CdaChLrph doc) {
		super(doc);
	}

	// Convenience function
	// Creates LaboratorySpecialtySection if not existing
	// Creates LaboratoryReportProcessingEntry if not existing
	// Creates SpecimenAct
	// adds the Laboratory Battery to the SpecimenAct
	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer organizer) {
		org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection laboratorySpecialtySection;
		// Try to determine the right code from the LaboratoryObservation and set it
		// in the Section
		final String section = getSpecialtySectionCodeFromLaboratoryObservationEnum(organizer);
		Code sectionCode = LrphSections.getEnum(section).getCode();
		if (getLaboratorySpecialtySection() == null) {
			if (sectionCode != null) {
				laboratorySpecialtySection = new LaboratorySpecialtySection(sectionCode);
			} else {
				laboratorySpecialtySection = new LaboratorySpecialtySection();
			}
		} else {
			laboratorySpecialtySection = getLaboratorySpecialtySection();
		}

		LaboratoryReportDataProcessingEntry lrdpe;
		if (laboratorySpecialtySection.getLaboratoryReportDataProcessingEntry() == null) {
			lrdpe = new LaboratoryReportDataProcessingEntry();
		} else {
			lrdpe = laboratorySpecialtySection.getLaboratoryReportDataProcessingEntry();
		}

		SpecimenAct se;
		if (lrdpe.getSpecimenAct() == null) {
			se = new SpecimenAct();
			se.setCode(sectionCode);
		} else {
			se = new SpecimenAct(lrdpe.getSpecimenAct().getMdht());
		}

		se.addLaboratoryBatteryOrganizer(organizer);
		lrdpe.setSpecimenAct(se);
		laboratorySpecialtySection.setLaboratoryReportDataProcessingEntry(lrdpe);
		setLaboratorySpecialtySection(laboratorySpecialtySection);
	}

	// Convenience Function
	// - Scan Observations for pseudonymization / anonymization related
	// NotifiableObservationLoinc or NotifiableObservationSnomed
	// - If such an element exists, use getPrivacyFilter() to determine
	// anonymization function
	// - Apply Anonymization function
	public void applyPrivacyFilter() {

	}

	// Convenience function
	// gets the LaboratorySpecialtySection
	// gets the SpecimenAct
	// gets the Laboratory Batteries from the SpecimenAct
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizerList() {
		if (getLaboratorySpecialtySection() != null
				&& getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry() != null
				&& getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct() != null) {
			return getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
					.getSpecimenAct().getLaboratoryBatteryOrganizers();
			//
			// // We have to cast the list to deliver the LRPH specific
			// // LaboratoryBatteryOrganizer
			// List<LaboratoryBatteryOrganizer> lboList = new
			// ArrayList<LaboratoryBatteryOrganizer>();
			// for
			// (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer
			// lbo : spa.getMdht()
			// .getLaboratoryBatteryOrganizers()) {
			// LaboratoryBatteryOrganizer lb = new LaboratoryBatteryOrganizer(lbo);
			// lboList.add(lb);
			// }
			// return lboList;
		}
		return null;
	}

	// protected
	// org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection
	// createSpecialtySection(
	// Code code) {
	// org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection section
	// = LABFactory.eINSTANCE
	// .createLaboratorySpecialtySection().init();
	// section.setTitle(Util.st(getSpecialitySectionTitle()));
	// section.setCode(code.getCE());
	// return section;
	// }

	// // Convenience function
	// // TODO In die SpecilatySection verschieben, da in dieser der zur
	// Observation
	// // passende Code mit angegen werden muss
	// public void addLaboratoryIsolateOrganizer(LaboratoryIsolateOrganizer
	// organizer) {
	//
	// }

	/**
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	public LaboratorySpecialtySection getLaboratorySpecialtySection() {
		if (!getMdht().getLaboratorySpecialtySections().isEmpty()) {
			return new LaboratorySpecialtySection(getMdht().getLaboratorySpecialtySections().get(0));
		}
		return null;
	}

	public String getNarrativeTextSectionLaboratorySpeciality() {
		if (this.getLaboratorySpecialtySection() != null
				&& this.getLaboratorySpecialtySection().getText() != null) {
			return this.getLaboratorySpecialtySection().getText();
		}
		return null;
	}

	private String getSpecialtySectionCodeFromLaboratoryObservationEnum(
			LaboratoryBatteryOrganizer organizer) {
		if (!organizer.getLaboratoryObservations().isEmpty()) {
			if (organizer.getLaboratoryObservations().get(0).getCodeAsEnum() != null) {
				// if present return LOINC Enum
				return organizer.getLaboratoryObservations().get(0).getCodeAsEnum().getSectionCode();
			} else {
				// if present return SNOMED Enum
				if (organizer.getLaboratoryObservations().get(0).getCodeAsSnomedEnum() != null) {
					return organizer.getLaboratoryObservations().get(0).getCodeAsSnomedEnum()
							.getSectionCode();
				}
			}
		}
		return null;
	}

	// protected List<LaboratorySpecialtySection> getLaboratorySpecialtySections()
	// {
	// List<LaboratorySpecialtySection> ssl = new
	// ArrayList<LaboratorySpecialtySection>();
	// for (Section s : getMdht().getAllSections()) {
	// if (s instanceof LaboratorySpecialitySection) {
	// ssl.add(new LaboratorySpecialtySection(
	// (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection) s));
	// }
	// }
	// return ssl;
	// }

	// // Convenience function
	// public NotificationOrganizer getNotificationOrganizer() {
	// return null;
	//
	// }

	// // Convenience function
	// // TODO In die SpecilatySection verschieben, da in dieser der zur
	// Observation
	// // passende Code mit angegen werden muss
	// public SpecimenCollection getSpecimenCollection() {
	// return null;
	//
	// }

	public SpecimenAct getSpecimenAct() {
		if (getLaboratorySpecialtySection() != null
				&& getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry() != null
				&& getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct() != null) {
			return getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
					.getSpecimenAct();
		}
		return null;
	}

	public void setLaboratorySpecialtySection(
			org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection laboratorySpecialtySection) {
		// Create a new structured body
		if (getMdht().getLaboratorySpecialtySections().isEmpty()) {
			getMdht().addSection(laboratorySpecialtySection.copy());
		} else {
			// We need to create a new Structured Body element, as the section list is
			// not modifiable
			StructuredBody sb = CDAFactory.eINSTANCE.createStructuredBody();
			CdaUtil.addSectionToStructuredBodyAsCopy(sb, laboratorySpecialtySection.copy());
			getMdht().setStructuredBody(sb);
		}
	}

	public void setNarrativeTextSectionLaboratorySpeciality(String text) {
		if (this.getLaboratorySpecialtySection() != null) {
			this.getLaboratorySpecialtySection().setText(text);
		}
	}

	// // Convenience function
	// public List<LaboratoryIsolateOrganizer> getLaboratoryIsolateOrganizerList()
	// {
	// return null;
	//
	// }

	// // Convenience function
	// // TODO In die SpecilatySection verschieben, da in dieser der zur
	// Observation
	// // passende Code mit angegen werden muss
	// public void setNotificationOrganizer(NotificationOrganizer organizer) {
	//
	// }

	// // Convenience function
	// public void setSpecimenCollection(SpecimenCollection procedure) {
	//
	// }
}
