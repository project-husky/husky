package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry;
import org.ehealth_connector.cda.ihe.lab.LaboratorySpecialtySection;
import org.ehealth_connector.cda.utils.CdaUtil;
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
		// TODO Determine the right code from the Observation

		LaboratorySpecialtySection laboratorySpecialtySection;
		if (getLaboratorySpecialtySection() == null) {
			laboratorySpecialtySection = new LaboratorySpecialtySection();
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

	// Convenience function
	// gets the LaboratorySpecialtySection
	// gets the SpecimenAct
	// gets the Laboratory Batteries from the SpecimenAct
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizerList() {
		if (getLaboratorySpecialtySection() != null
				&& getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry() != null
				&& getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct() != null) {
			SpecimenAct spa = new SpecimenAct(getLaboratorySpecialtySection()
					.getLaboratoryReportDataProcessingEntry().getSpecimenAct().copy());

			// We have to cast the list to deliver the LRPH specific
			// LaboratoryBatteryOrganizer
			List<LaboratoryBatteryOrganizer> lboList = new ArrayList<LaboratoryBatteryOrganizer>();
			for (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer lbo : spa.getMdht()
					.getLaboratoryBatteryOrganizers()) {
				LaboratoryBatteryOrganizer lb = new LaboratoryBatteryOrganizer(lbo);
				lboList.add(lb);
			}
			return lboList;
		}
		return null;
	}

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

	// // Convenience function
	// public List<LaboratoryIsolateOrganizer> getLaboratoryIsolateOrganizerList()
	// {
	// return null;
	//
	// }

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

	public void setLaboratorySpecialtySection(LaboratorySpecialtySection lss) {
		// Create a new structured body
		StructuredBody sb = CDAFactory.eINSTANCE.createStructuredBody();

		CdaUtil.addSectionToStructuredBodyAsCopy(sb, lss.copy());
		getMdht().setStructuredBody(sb);
	}

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
