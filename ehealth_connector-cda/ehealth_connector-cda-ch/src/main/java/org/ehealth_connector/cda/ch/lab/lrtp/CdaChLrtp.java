package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.edes.VitalSignObservation;
import org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReport;
import org.ehealth_connector.cda.ch.lab.BloodGroupObservation;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.ReportScopes;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.SpecialtySections;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.IntendedRecipient;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

public class CdaChLrtp
		extends AbstractLaboratoryReport<org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp> {

	/**
	 * <div class="en">Creates a UUID for LRPH documents with the LRPH root ID and
	 * a generated extension.</div>
	 *
	 * @param id
	 *          <br>
	 *          <div class="en"> the id</div>
	 * @return the ii
	 */
	protected static Identificator createUuidLrtp(String id) {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		// ii.setRoot(OID_MAIN);
		if (id == null) {
			ii.setExtension(UUID.generate());
		} else {
			ii.setExtension(id);
		}
		return new Identificator(ii);
	}

	/**
	 * Standard constructor
	 */
	public CdaChLrtp() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch lrtp.
	 *
	 * @param languageCode
	 *          the language code
	 */
	protected CdaChLrtp(LanguageCode languageCode) {
		this(languageCode, null, null);
	}

	// TODO Add one constructor:
	// one with the LabObsListLoinc, which uses the getSpecialtySection Method
	// to determine the type of the section via the getEnum(code) method in the
	// SpecialtySections Enum

	/**
	 * Constructor with the recommended elements for the LRTP document Header.
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
	public CdaChLrtp(LanguageCode languageCode, Author author,
			ReferralOrderingPhysician refOrderingPhysician, org.ehealth_connector.common.Patient patient,
			IntendedRecipient recipient) {
		this(languageCode);
		setPatient(patient);
		setEmtpyCustodian();
		addAuthor(author);
		addReferralOrderingPhysician(refOrderingPhysician);
	}

	/**
	 * Instantiates a new cda ch lrtp.
	 *
	 * @param languageCode
	 *          language of the document contents
	 * @param styleSheet
	 *          an extensible style sheet (XSLT) to transform and render the
	 *          document
	 * @param css
	 *          cascading style sheet (CSS) to add style information for rendering
	 */
	public CdaChLrtp(LanguageCode languageCode, String styleSheet, String css) {
		super(CHFactory.eINSTANCE.createCdaChLrtp().init(), languageCode, styleSheet, css);
		this.setLanguageCode(languageCode);
	}

	/**
	 * Instantiates a new cda ch lrtp.
	 *
	 * @param doc
	 *          mdht model document
	 */
	public CdaChLrtp(org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp doc) {
		super(doc);
	}

	/**
	 * Convenience function to add a Laboratory Battery Organizer and create the
	 * necessary elements.
	 *
	 * These elements are: LaboratorySpecialtySection (section code is derived
	 * automatically from the first LaboratoryObservation enum)
	 * LaboratoryReportProcessingEntry SpecimenAct with the given Laboratory
	 * Battery Organizer
	 *
	 * @param organizer
	 *          the LaboratoryBatteryOrganizer holding at least one
	 *          LaboratoryObservation
	 */
	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer organizer) {
		LaboratorySpecialtySection laboratorySpecialtySection;
		// Try to determine the right code from the LaboratoryObservation and set it
		// in the Section
		final String section = getSectionCodeFromLaboratoryObservationEnum(organizer);
		Code sectionCode = null;
		if (section != null) {
			sectionCode = SpecialtySections.getEnum(section).getCode();
		}

		if (sectionCode != null) {
			laboratorySpecialtySection = new LaboratorySpecialtySection(sectionCode);
			getMdht().setCode(sectionCode.getCE());
		} else {
			laboratorySpecialtySection = new LaboratorySpecialtySection();
		}
		LaboratoryReportDataProcessingEntry lrdpe;
		lrdpe = new LaboratoryReportDataProcessingEntry();

		SpecimenAct se;
		se = new SpecimenAct();
		if (sectionCode != null) {
			se.setCode(sectionCode);
		}

		se.addLaboratoryBatteryOrganizer(organizer);
		lrdpe.setSpecimenAct(se);
		laboratorySpecialtySection.setLaboratoryReportDataProcessingEntry(lrdpe);

		addLaboratorySpecialtySection(laboratorySpecialtySection);
	}

	/**
	 * Sets a LaboratorySpecialtySection
	 *
	 * @param laboratorySpecialtySection
	 *          the section
	 */
	public void addLaboratorySpecialtySection(
			org.ehealth_connector.cda.ch.lab.lrtp.LaboratorySpecialtySection laboratorySpecialtySection) {
		getMdht().addSection(laboratorySpecialtySection.copy());
	}

	// Convenience function
	// - Create VitalSignsSection
	// - Create VitalSignsOrganizer
	// - Add VitalSignObservation
	public void addVitalSignObservation(VitalSignObservation observation) {

	}

	// Convenience Function
	// - Scan Observations for pseudonymization / anonymization related
	// NotifiableObservationLoinc or NotifiableObservationSnomed
	// - If such an element exists, use getPrivacyFilter() to determine
	// anonymization function
	// - Apply Anonymization function
	public void applyPrivacyFilter() {

	}

	public BloodGroupObservation getBloodGroup() {
		return null;

	}

	public ReportScopes getDocumentationOf() {
		return null;

	}

	/**
	 * Convenience function to return all LaboratoryBatteryOrganizers directly
	 * from the underlying
	 * LaboratorySpecialtySection/LaboratoryReportDataProcessingEntry/SpecimenAct
	 * element.
	 *
	 * @return a list of LaboratoryBatteryOrganizers. returns null, if this list
	 *         does not exist.
	 */
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizerList() {
		if (getLaboratorySpecialtySection() != null
				&& getLaboratorySpecialtySection().get(0).getLaboratoryReportDataProcessingEntry() != null
				&& getLaboratorySpecialtySection().get(0).getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct() != null) {
			return getLaboratorySpecialtySection().get(0).getLaboratoryReportDataProcessingEntry()
					.getSpecimenAct().getLaboratoryBatteryOrganizers();
		}
		return null;
	}

	/**
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	public List<LaboratorySpecialtySection> getLaboratorySpecialtySection() {
		List<LaboratorySpecialtySection> ls = new ArrayList<LaboratorySpecialtySection>();
		for (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection lss : getMdht()
				.getLaboratorySpecialtySections()) {
			ls.add(new LaboratorySpecialtySection(lss));
		}
		return ls;
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
	private String getSectionCodeFromLaboratoryObservationEnum(LaboratoryBatteryOrganizer organizer) {
		if (!organizer.getLaboratoryObservations().isEmpty()) {
			if (organizer.getLaboratoryObservations().get(0).getCodeAsLoincEnum() != null) {
				// if present return LOINC Enum
				return organizer.getLaboratoryObservations().get(0).getCodeAsLoincEnum().getSectionCode();
			}
		}
		return null;
	}

	// Convenience function
	public List<VitalSignObservation> getVitalSignObservationList() {
		return null;
	}

	@Override
	public void initCda() {

	}

	// Convenience function to set the blood group
	// - create Studies Summary
	// - set blood group observation
	public void setBloodGroup(BloodGroupObservation observation) {

	}

	// Convenience function to set the kind of donor
	public void setDocumentationOf(ReportScopes scope) {

	}
}
