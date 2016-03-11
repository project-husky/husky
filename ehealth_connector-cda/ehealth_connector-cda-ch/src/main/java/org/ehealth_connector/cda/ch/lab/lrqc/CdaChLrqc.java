package org.ehealth_connector.cda.ch.lab.lrqc;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReport;
import org.ehealth_connector.cda.ch.lab.lrqc.enums.SpecialtySections;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.StructuredBody;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class CdaChLrqc
		extends AbstractLaboratoryReport<org.openhealthtools.mdht.uml.cda.ch.CdaChLrqc> {

	/**
	 * Standard constructor
	 */
	public CdaChLrqc() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch lrqc.
	 *
	 * @param languageCode
	 *          the language code
	 */
	protected CdaChLrqc(LanguageCode languageCode) {
		this(languageCode, null, null);
	}

	/**
	 * Constructor with the recommended elements for the LRPH document Header.
	 *
	 * @param languageCode
	 *          the language code
	 * @param author
	 *          the author of the document (a laboratory)
	 * @param refOrderingPhysician
	 *          a physician
	 * @param patient
	 *          the patient
	 * @param recipient
	 *          the recipient (e.g. the Bundesamt für Gesundheit)
	 */
	public CdaChLrqc(LanguageCode languageCode, Author author,
			ReferralOrderingPhysician refOrderingPhysician, org.ehealth_connector.common.Patient patient,
			IntendedRecipient recipient) {
		this(languageCode);
		setPatient(patient);
		setEmtpyCustodian();
		addAuthor(author);
		addReferralOrderingPhysician(refOrderingPhysician);
		addIntendedRecipient(recipient);
	}

	/**
	 * Instantiates a new cda ch lrqc.
	 *
	 * @param languageCode
	 *          language of the document contents
	 * @param styleSheet
	 *          an extensible style sheet (XSLT) to transform and render the
	 *          document
	 * @param css
	 *          cascading style sheet (CSS) to add style information for rendering
	 */
	public CdaChLrqc(LanguageCode languageCode, String styleSheet, String css) {
		super(CHFactory.eINSTANCE.createCdaChLrqc().init(), languageCode, styleSheet, css);
		this.setLanguageCode(languageCode);
	}

	/**
	 * Instantiates a new cda ch lrqc.
	 *
	 * @param doc
	 *          mdht model document
	 */
	public CdaChLrqc(org.openhealthtools.mdht.uml.cda.ch.CdaChLrqc doc) {
		super(doc);
	}

	/**
	 * Convenience function to add a Laboratory Battery Organizer and create the
	 * necessary elements, if they do not exist. If the elements exist, their
	 * contents will not be overwritten.
	 *
	 * These elements are: LaboratorySpecialtySection (section code is derived
	 * automatically from the LaboratoryObservation enum)
	 * LaboratoryReportProcessingEntry SpecimenAct with the given Laboratory
	 * Battery Organizer
	 *
	 * @param organizer
	 *          the LaboratoryBatteryOrganizer holding at least one
	 *          LaboratoryObservation
	 */
	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer organizer) {
		// Try to determine the right code from the LaboratoryObservation and set it
		// in the Section
		final String section = getSpecialtySectionCodeFromLaboratoryObservationEnum(organizer);
		Code sectionCode = null;
		if (section != null) {
			sectionCode = SpecialtySections.getEnum(section).getCode();
		}

		SpecimenAct se;
		if (getSpecimenAct() == null) {
			se = new SpecimenAct();
		} else {
			se = getSpecimenAct();
		}
		se.addLaboratoryBatteryOrganizer(organizer);

		setSpecimenAct(se, sectionCode);
	}

	public List<IntendedRecipient> getIntendedRecipientsLrqc() {
		List<IntendedRecipient> il = new ArrayList<IntendedRecipient>();
		for (InformationRecipient ir : getMdht().getInformationRecipients()) {
			if (ir instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient) {
				org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient iheIr = (org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient) ir;
				il.add(new IntendedRecipient(iheIr));
			}
		}
		return il;
	}

	// /**
	// * Convenience function which applies the right privacy protection
	// algorithm,
	// * depending on an existing LaboratoryObservation element. This element has
	// to
	// * be added to this document before. If different privacy filter related
	// * observations exist, this function will apply the most restrictive privacy
	// * filter.
	// *
	// * @throws IllegalArgumentException
	// * when the needed element for applying the anonymization does not
	// * exist in the current instance of the document.
	// */
	// public void applyPrivacyFilter() throws IllegalArgumentException {
	// for (LaboratoryBatteryOrganizer lbo : getLaboratoryBatteryOrganizerList())
	// {
	// String privacyFilter = getPrivacyFilterFromLaboratoryObservationEnum(lbo);
	// if (privacyFilter == null)
	// throw new IllegalArgumentException();
	// switch (privacyFilter) {
	// case "none":
	// break;
	// case "initials":
	// applyPrivacyFilterInitials(getMdht());
	// break;
	// case "conditional":
	// // TODO
	// break;
	// case "hiv":
	// // TODO
	// break;
	// }
	// }
	// }

	/**
	 * Convenience function to return all LaboratoryBatteryOrganizers directly
	 * from all underlying
	 * LaboratorySpecialtySection/LaboratoryReportDataProcessingEntry/SpecimenAct
	 * element.
	 *
	 * @return a list of LaboratoryBatteryOrganizers.
	 */
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizerList() {
		ArrayList<LaboratoryBatteryOrganizer> lbol = new ArrayList<LaboratoryBatteryOrganizer>();
		LaboratorySpecialtySection lss = getLaboratorySpecialtySection();
		if (lss != null) {
			LaboratoryReportDataProcessingEntry lrdpe = lss.getLaboratoryReportDataProcessingEntry();
			if (lrdpe != null) {
				SpecimenAct se = lrdpe.getSpecimenAct();
				if (se != null) {
					lbol.addAll(se.getLaboratoryBatteryOrganizers());
				}
			}
		}
		return lbol;
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

	/**
	 * Convenience function to return the (LOINC) section code from a given
	 * LaboratoryObservation, which is hold in the given
	 * LaboratoryBatteryOrganizer.
	 *
	 * @param organizer
	 *          the LaboratoryBatteryOrganizer
	 * @return the section code
	 */
	private String getSpecialtySectionCodeFromLaboratoryObservationEnum(
			LaboratoryBatteryOrganizer organizer) {
		if (!organizer.getLaboratoryObservations().isEmpty()) {
			if (organizer.getLaboratoryObservations().get(0).getCodeAsEnum() != null) {
				// if present return LOINC Enum
				return organizer.getLaboratoryObservations().get(0).getCodeAsEnum().getSectionCode();
			} else {
				// if present return SNOMED Enum
				if (organizer.getLaboratoryObservations().get(0).getCodeAsEnum() != null) {
					return organizer.getLaboratoryObservations().get(0).getCodeAsEnum().getSectionCode();
				}
			}
		}
		return null;
	}

	// /**
	// * Convenience function to return the
	// * PatientPrivacyFilter(none,initials,conditional,hiv) from a
	// * LaboratoryObservation, which is hold in the given
	// * LaboratoryBatteryOrganizer.
	// *
	// * @param organizer
	// * the LaboratoryBatteryOrganizer
	// * @return the section code
	// */
	// private String getPrivacyFilterFromLaboratoryObservationEnum(
	// LaboratoryBatteryOrganizer organizer) {
	// if (!organizer.getLaboratoryObservations().isEmpty()) {
	// if (organizer.getLaboratoryObservations().get(0).getCodeAsEnum() != null) {
	// // if present return LOINC Enum
	// return organizer.getLaboratoryObservations().get(0).getCodeAsEnum()
	// .getPatientPrivacyFilter();
	// } else {
	// // if present return SNOMED Enum
	// if (organizer.getLaboratoryObservations().get(0).getCodeAsSnomedEnum() !=
	// null) {
	// return organizer.getLaboratoryObservations().get(0).getCodeAsSnomedEnum()
	// .getPatientPrivacyFilter();
	// }
	// }
	// }
	// return null;
	// }

	/**
	 * Convenience function, which returns the SpecimenAct directly from the
	 * underlying LaboratorySpecialtySection/LaboratoryReportDataProcessingEntry
	 * element
	 *
	 * @return the SpecimenAct. Returns null, if this element does not exist.
	 */
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

	/**
	 * Sets a LaboratorySpecialtySection
	 *
	 * @param laboratorySpecialtySection
	 *          the section
	 */
	public void setLaboratorySpecialtySection(
			org.ehealth_connector.cda.ch.lab.lrqc.LaboratorySpecialtySection laboratorySpecialtySection) {
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

	/**
	 * Convenience function to add a Specimen and create the necessary elements,
	 * if they do not exist. If the elements exist, their contents will NOT be
	 * overwritten. These elements are: LaboratorySpecialtySection (will be
	 * initialized with the given code), LaboratoryReportDataProcessigEntry
	 *
	 * @param act
	 *          the specimenAct
	 */
	public void setSpecimenAct(SpecimenAct act, Code sectionCode) {
		LaboratorySpecialtySection laboratorySpecialtySection;
		if (getLaboratorySpecialtySection() == null) {
			if (sectionCode != null) {
				laboratorySpecialtySection = new LaboratorySpecialtySection(sectionCode, getLanguageCode());
				getMdht().setCode(sectionCode.getCE());
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

		if (sectionCode != null) {
			act.setCode(sectionCode);
		}

		lrdpe.setSpecimenAct(act);
		laboratorySpecialtySection.setLaboratoryReportDataProcessingEntry(lrdpe);
		setLaboratorySpecialtySection(laboratorySpecialtySection);
	}
}
