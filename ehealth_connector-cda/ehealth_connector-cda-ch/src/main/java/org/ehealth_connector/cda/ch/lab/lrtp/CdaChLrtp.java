package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReport;
import org.ehealth_connector.cda.ch.lab.BloodGroupObservation;
import org.ehealth_connector.cda.ch.lab.StudiesSummarySection;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.ReportScopes;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.SpecialtySections;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.IntendedRecipient;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.DocumentationOf;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.ServiceEvent;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

public class CdaChLrtp
		extends AbstractLaboratoryReport<org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp> {

	/**
	 * <div class="en">Creates a UUID for LRTP documents with the LRTP root ID and
	 * a generated extension.</div>
	 *
	 * @param id
	 *          <br>
	 *          <div class="en"> the id</div>
	 * @return the ii
	 */
	public static Identificator createUuidLrtp(String id) {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot("2.16.756.5.30.1.1.1.1.3.4.1");
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
	 * @param soasCode
	 *          <div class="en">the SOAS code (will be set in
	 *          recordTarget/patientRole/id/extension). Other Ids will be
	 *          deleted.</div> <div class="de">Die Spender- resp. Empfänger-ID
	 *          (der sogenannte SOAS-Code wird gesetzt in
	 *          recordTarget/patientRole/id/extension). Andere Ids werden
	 *          gelöscht.</div>
	 *
	 */
	public CdaChLrtp(LanguageCode languageCode, Author author,
			ReferralOrderingPhysician refOrderingPhysician, org.ehealth_connector.common.Patient patient,
			IntendedRecipient recipient, String soasCode) {
		this(languageCode);
		// set SOAS ID
		patient.getIds().clear();
		patient.getIds().add(new Identificator("2.16.756.5.30.1.129.1.1.1", soasCode));
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
	 * <div class="en">Convenience function to add the DocumentationOf element. In
	 * case of LRTP it determines the case of organ donor. </div>
	 * <div class="de">Convenience Funktion um das documentationOf element
	 * hinzuzufügen. Die Fallunterscheidung der untersuchten Person resp. der
	 * Geltungsbereich des Befundes (Leichenspender, Lebendspender,
	 * Organempfänger) wird im CDA Header mit dem documentationOf Element
	 * dokumentiert.</div>
	 *
	 * @param scope
	 *          the scope of this organ donor.
	 */
	public void addDocumentationOf(ReportScopes scope) {
		DocumentationOf dof = CDAFactory.eINSTANCE.createDocumentationOf();
		ServiceEvent se = CDAFactory.eINSTANCE.createServiceEvent();
		se.setCode(scope.getCE());
		dof.setServiceEvent(se);
		getMdht().getDocumentationOfs().add(dof);
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
			laboratorySpecialtySection = new LaboratorySpecialtySection(sectionCode, getLanguageCode());
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

	// Convenience Function
	// - Scan Observations for pseudonymization / anonymization related
	// NotifiableObservationLoinc or NotifiableObservationSnomed
	// - If such an element exists, use getPrivacyFilter() to determine
	// anonymization function
	// - Apply Anonymization function
	public void applyPrivacyFilter() {

	}

	/**
	 * Gets the BloodGroupObservation
	 *
	 * @return the BloodGroupObservation
	 */
	public BloodGroupObservation getBloodGroupObservation() {
		if (getStudiesSummarySection() != null && getStudiesSummarySection().getBloodGroup() != null) {
			return new BloodGroupObservation(getStudiesSummarySection().getBloodGroup().getMdht());
		}
		return null;
	}

	/**
	 * Gets the CodedVitalSignsSection
	 *
	 * @return the CodedVitalSignsSection
	 */
	public CodedVitalSignsSection getCodedVitalSignsSection() {
		for (Section s : getMdht().getAllSections()) {
			if (s instanceof org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection) {
				return new CodedVitalSignsSection(
						(org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection) s);
			}
		}
		return null;
	}

	/**
	 * <div class="en">Convenience function to get the LRTP relevant
	 * DocumentationOf elements. In case of LRTP it determines the case of organ
	 * donor. </div> <div class="de">Convenience Funktion um die LRTP-relevanten
	 * documentationOf Elemente zu erhalten. Die Fallunterscheidung der
	 * untersuchten Person resp. der Geltungsbereich des Befundes (Leichenspender,
	 * Lebendspender, Organempfänger) wird im CDA Header mit dem documentationOf
	 * Element dokumentiert.</div>
	 *
	 * @return the scope of this organ donor.
	 */
	public List<ReportScopes> getDocumentationOfs() {
		List<ReportScopes> rl = new ArrayList<ReportScopes>();
		for (DocumentationOf dof : getMdht().getDocumentationOfs()) {
			if (dof.getServiceEvent() != null && dof.getServiceEvent().getCode() != null) {
				ReportScopes rs = ReportScopes.getEnum(dof.getServiceEvent().getCode().getCode());
				if (rs != null) {
					rl.add(rs);
				}
			}
		}
		return rl;
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
	 * Returns the narrative Text of the CodedVitalSignsSection.
	 *
	 * @return the narrative Text. Returns null, if this text does not exist.
	 */
	public String getNarrativeTextSectionCodedVitalSignsSection() {
		if (getCodedVitalSignsSection() != null
				&& getCodedVitalSignsSection().getMdht().getText() != null
				&& getCodedVitalSignsSection().getMdht().getText().getText() != null) {
			return getCodedVitalSignsSection().getMdht().getText().getText();
		}
		return null;
	}

	/**
	 * Returns the narrative Text of the StudiesSummarySection.
	 *
	 * @return the narrative Text. Returns null, if this text does not exist.
	 */
	public String getNarrativeTextSectionStudiesSummarySection() {
		if (getStudiesSummarySection() != null && getStudiesSummarySection().getText() != null) {
			return getStudiesSummarySection().getText();
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
	private String getSectionCodeFromLaboratoryObservationEnum(LaboratoryBatteryOrganizer organizer) {
		if (!organizer.getLaboratoryObservations().isEmpty()) {
			if (organizer.getLaboratoryObservations().get(0).getCodeAsLoincEnum() != null) {
				// if present return LOINC Enum
				return organizer.getLaboratoryObservations().get(0).getCodeAsLoincEnum().getSectionCode();
			}
		}
		return null;
	}

	/**
	 * Gets the StudiesSummarySection
	 *
	 * @return the StudiesSummarySection
	 */
	public StudiesSummarySection getStudiesSummarySection() {
		for (Section s : getMdht().getAllSections()) {
			if (s instanceof org.openhealthtools.mdht.uml.cda.ch.StudiesSummarySection) {
				return new StudiesSummarySection(
						(org.openhealthtools.mdht.uml.cda.ch.StudiesSummarySection) s);
			}
		}
		return null;
	}

	/**
	 * Gets the VitalSignsOrganizer
	 *
	 * @return the VitalSignsOrganizer
	 */
	public VitalSignsOrganizer getVitalSignsOrganizer() {
		if (getCodedVitalSignsSection() != null
				&& getCodedVitalSignsSection().getVitalSignsOrganizer() != null) {
			return new VitalSignsOrganizer(
					getCodedVitalSignsSection().getVitalSignsOrganizer().getMdht());
		}
		return null;
	}

	/**
	 * Convenience function, which adds a BloodGroupObservation and creates the
	 * StudiesSummarySection automatically with the current LanguageCode of the
	 * document.
	 *
	 * @param observation
	 *          the observation
	 */
	public void setBloodGroupObservation(BloodGroupObservation observation) {
		// Check if this section already exists. If so, get it, else create it.
		StudiesSummarySection sss;
		if (getStudiesSummarySection() != null) {
			sss = getStudiesSummarySection();
		} else {
			sss = new StudiesSummarySection(getLanguageCode());
		}
		sss.setBloodGroup(observation);
		setStudiesSummary(sss);
	}

	/**
	 * Sets the CodedVitalSignsSection
	 *
	 * @param codedVitalSigns
	 *          the CodedVitalSignsSection
	 */
	public void setCodedVitalSignsSection(CodedVitalSignsSection codedVitalSigns) {
		if (getCodedVitalSignsSection() == null) {
			getMdht().addSection(codedVitalSigns.copy());
		}
	}

	/**
	 * Sets the section/text element for the CodedVitalSignsSection.
	 *
	 * @param text
	 *          the text
	 */
	public void setNarrativeTextSectionCodedVitalSignsSection(String text) {
		if (getCodedVitalSignsSection() != null) {
			getCodedVitalSignsSection().getMdht().createStrucDocText(text);
		}
	}

	/**
	 * Sets the section/text element for the StudiesSummarySection.
	 *
	 * @param text
	 *          the text
	 */
	public void setNarrativeTextSectionStudiesSummarySection(String text) {
		if (getStudiesSummarySection() != null) {
			getStudiesSummarySection().getMdht().createStrucDocText(text);
		}
	}

	/**
	 * Sets the StudiesSummarySection
	 *
	 * @param section
	 *          the StudiesSummarySection
	 */
	public void setStudiesSummary(StudiesSummarySection section) {
		if (getStudiesSummarySection() == null) {
			getMdht().addSection(section.copy());
		}
	}

	/**
	 * Convenience function, which adds a Vital Sign Organizer and creates the
	 * Vital Sign Section automatically with the current LanguageCode of the
	 * document.
	 *
	 * @param organizer
	 *          the organizer
	 */
	public void setVitalSignOrganizer(VitalSignsOrganizer organizer) {
		// Check if this section already exists. If so, get it, else create it.
		CodedVitalSignsSection cvs;
		if (getCodedVitalSignsSection() != null) {
			cvs = getCodedVitalSignsSection();
		} else {
			cvs = new CodedVitalSignsSection(getLanguageCode());
		}
		cvs.setVitalSignsOrganizer(organizer);
		setCodedVitalSignsSection(cvs);
	}
}
