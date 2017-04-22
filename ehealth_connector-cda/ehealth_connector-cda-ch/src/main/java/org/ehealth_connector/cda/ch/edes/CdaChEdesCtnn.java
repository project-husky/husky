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

package org.ehealth_connector.cda.ch.edes;

import java.util.Collections;
import java.util.List;

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * <div class="en">This class represents a EDES CTNN CDA document. Note that for
 * the section naming, the data element index of IHE EDES was used. See also
 * CDA-CH-EDES, Tabelle 25: Überblick Datenelemente in EDES Inhaltsprofilen
 * </div>
 *
 */
public class CdaChEdesCtnn
		extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn> {

	private static final String DOCTITLE_EN = "Emergency Department Encounter Summary (Composite Triage and Nursing Note)";
	private static final String DOCTITLE_GER = "Notfallaustrittsbericht (aus pflegerischer Sicht)";

	/** main OID for CDA-CH-EDES CTNN */
	public static final String OID_MAIN = "1.3.6.1.4.1.19376.1.5.3.1.1.13.1.3";

	private final CdaChEdesCommon mCommon;

	private CodedVitalSignsSection mCodedVitalSigns;

	/**
	 * <div class="en">Creates a new EDES CTNN CDA document</div>
	 * <div class="de">Erstellt ein neues EDES CTNN CDA Dokument.</div>
	 */
	public CdaChEdesCtnn() {
		super(CHFactory.eINSTANCE.createCdaChEdesCtnn().init());
		mCommon = new CdaChEdesCommon(this);
	}

	/**
	 * <div class="en">Creates a new EDES CTNN CDA document</div>
	 * <div class="de">Erstellt ein neues EDES CTNN CDA Dokument.</div>
	 *
	 * @param language
	 *            <br>
	 *            <div class="en">document language</div>
	 *            <div class="de">Sprache des Dokments</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param stylesheet
	 *            <div class="en">stylesheet, which should be referenced to
	 *            render a human readable representation of the document</div>
	 *            <div class="de">Stylesheet, welches im CDA mittels
	 *            ?xml-stylesheet für die menschlich lesbare Darstellung
	 *            referenziert werden soll (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 * @param cascadingStylesheet
	 *            <div class="en">Cascading stylesheet, which should be
	 *            referenced to render a human readable representation of the
	 *            document</div> <div class="de">Cascasing Stylesheet, welches
	 *            Designinformationen für die menschlich lesbare Darstellung
	 *            referenziert (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 */
	public CdaChEdesCtnn(LanguageCode language, String stylesheet, String cascadingStylesheet) {
		super(CHFactory.eINSTANCE.createCdaChEdesCtnn().init(), stylesheet, cascadingStylesheet);
		setLanguageCode(language);

		// set the fixed Ctnn Code
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCode("X-TRIAGE");
		ce.setCodeSystem("2.16.840.1.113883.6.1");
		ce.setCodeSystemName("LOINC");
		ce.setDisplayName("Triage Note");
		getMdht().setCode(ce);

		mCommon = new CdaChEdesCommon(this);
		setTitle(getDocumentTitle());
	}

	/**
	 * <div class="en">Creates a new CdaChEdesCtnn convenience object on the
	 * basis of a MDHT-CdaChEdesCtnn object.</div> <div class="de">Erstellt ein
	 * neues CdaChEdesCtnn Convenience Objekt mittels eines MDHT-CdaChEdesCtnn
	 * Objekts.</div>
	 *
	 * @param doc
	 *            MDHT CdaChEdesCtnn object
	 */
	public CdaChEdesCtnn(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn doc) {
		super(doc);
		mCommon = new CdaChEdesCommon(this);
	}

	/**
	 * <div class="en">Adds the AllergiesOrOtherAdverseReaction</div>
	 * <div class="de">Fügt ein Allergie-Leiden hinzu</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param allergyOrOtherAdverseReaction
	 *            <br>
	 *            <div class="de">Allergie leiden</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void addAllergiesOrOtherAdverseReaction(AllergyConcern allergyOrOtherAdverseReaction) {
		mCommon.addAllergiesOrOtherAdverseReaction(allergyOrOtherAdverseReaction,
				getDoc().getAllergiesReactionsSection());
	}

	/**
	 * <div class="en">Add the coded vital sign observation to the
	 * document</div> <div class="de">Fügt das codierte Vitalzeichen in das
	 * Dokument ein</div>
	 *
	 * @param organizer
	 *            The desired organizer where to put the observation
	 * @param vitalSign
	 *            <div class="en">The coded vital sign observation to add</div>
	 *            <div class="de">Das hinzuzufügende codierte Vitalzeichen</div>
	 * @param author
	 *            the author of the observation
	 */
	public void addCodedVitalSign(VitalSignsOrganizer organizer, VitalSignObservation vitalSign,
			Author author) {
		mCommon.addCodedVitalSign(organizer, vitalSign, author,
				getDoc().getCodedVitalSignsSection(),
				LanguageCode.getEnum(getDoc().getLanguageCode().getCode()));
	}

	/**
	 * <div class="en">Adds a PastIllness</div> <div class="de">Fügt ein
	 * vergangenes Leiden hinzu</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param pastIllness
	 *            the past problem concern
	 */
	public void addPastIllness(PastProblemConcern pastIllness) {
		mCommon.addPastIllness(pastIllness, getDoc().getHistoryOfPastIllnessSection());
	}

	/**
	 * <div class="en">Gets AllergiesAndOtherAdverseReactions</div>
	 * <div class="de">Liefert alle Allergie Leiden zurück</div>
	 *
	 * @return the AllergiesAndOtherAdverseReactions
	 */
	public List<AllergyConcern> getAllergiesAndOtherAdverseReactions() {
		return mCommon
				.getAllergiesAndOtherAdverseReactions(getDoc().getAllergiesReactionsSection());
	}

	/**
	 * <div class="en">Gets the coded vital sign observations</div>
	 * <div class="de">Liefert alle codierten Vitalzeichen zurück</div>
	 *
	 * @return List with coded vital sign observations
	 */
	public List<AbstractVitalSignObservation> getCodedVitalSigns() {
		if (mCodedVitalSigns == null) {
			final org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection section = getDoc()
					.getCodedVitalSignsSection();
			if (section == null) {
				return Collections.emptyList();
			}
			final LanguageCode languageCode = LanguageCode
					.getEnum(getDoc().getLanguageCode().getCode());
			mCodedVitalSigns = new org.ehealth_connector.cda.ch.edes.CodedVitalSignsSection(
					languageCode, section);
		}
		return mCodedVitalSigns.getCodedVitalSignObservations();
	}

	/**
	 * Gets the CodedVitalSignsSection.
	 *
	 * @return the CodedVitalSignsSection
	 */
	public CodedVitalSignsSection getCodedVitalSignsSection() {
		for (final Section s : getMdht().getAllSections()) {
			if (s instanceof org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection) {
				return new CodedVitalSignsSection(
						(org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection) s);
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the MDHT-CdaChEdesCtnn Object</div>
	 * <div class="de">Liefert das MDHT-CdaChEdesCtnn-Objekt zurück.</div>
	 *
	 * @return the doc
	 */
	@Override
	public org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn getDoc() {
		return (org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn) super.getDoc();
	}

	public String getDocumentTitle() {
		final CS lcode = getDoc().getLanguageCode();
		if (lcode != null) {
			switch (lcode.getCode()) {
			case LanguageCode.GERMAN_CODE:
				return DOCTITLE_GER;
			case LanguageCode.FRENCH_CODE:
			case LanguageCode.ITALIAN_CODE:
			case LanguageCode.ENGLISH_CODE:
				return DOCTITLE_EN;
			}
		}
		return DOCTITLE_EN;
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionAbilityToWork() {
		return mCommon.getNarrativeText(SectionsEDES.ABILITY_TO_WORK.findSection(getDoc()));
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionAcuityAssessment() {
		return mCommon.getNarrativeText(getDoc().getAcuityAssessmentSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionAllergiesAndOtherAdverseReactions() {
		return mCommon.getNarrativeText(getDoc().getAllergiesReactionsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionAssessments() {
		return mCommon.getNarrativeText(getDoc().getAssessmentsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionChiefComplaint() {
		return mCommon.getNarrativeText(getDoc().getChiefComplaintSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionCodedVitalSigns() {
		return mCommon.getNarrativeText(getDoc().getCodedVitalSignsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionEdDisposition() {
		return mCommon.getNarrativeText(getDoc().getEDDispositionSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionFamilyMedicalHistory() {
		return mCommon.getNarrativeText(getDoc().getFamilyMedicalHistorySection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionHistoryOfPastIllness() {
		return mCommon.getNarrativeText(getDoc().getHistoryOfPastIllnessSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionHistoryOfPresentIllness() {
		return mCommon.getNarrativeText(getDoc().getHistoryOfPresentIllness());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionImmunizations() {
		return mCommon.getNarrativeText(getDoc().getImmunizationsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionIntravenousFluidsAdministered() {
		return mCommon.getNarrativeText(getDoc().getIntravenousFluidsAdministeredSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionListOfSurgeries() {
		return mCommon.getNarrativeText(getDoc().getSurgeriesSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionMedications() {
		return mCommon.getNarrativeText(getDoc().getMedicationsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionMedicationsAdministered() {
		return mCommon.getNarrativeText(getDoc().getMedicationsAdministeredSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionModeOfArrival() {
		return mCommon.getNarrativeText(getDoc().getModeOfArrivalSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionPregnancyHistory() {
		return mCommon.getNarrativeText(getDoc().getPregnancyHistorySection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionProceduresAndInterventions() {
		return mCommon.getNarrativeText(getDoc().getProceduresAndInterventionsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionReasonForVisit() {
		return mCommon.getNarrativeText(getDoc().getReasonForVisitSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionRemarks() {
		return mCommon.getNarrativeText(SectionsEDES.REMARKS.findSection(getDoc()));
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionSocialHistory() {
		return mCommon.getNarrativeText(getDoc().getSocialHistorySection());
	}

	/**
	 * <div class="en">Gets HistoryOfPastIllness</div> <div class="de">Liefert
	 * alle vergangen Leiden zurück</div>
	 *
	 * @return the HistoryOfPastIllness
	 */
	public List<PastProblemConcern> getPastIllness() {
		return mCommon.getPastIllness(getDoc().getHistoryOfPastIllnessSection());
	}

	/**
	 * Initializes internal lists when the CDA was loaded from file
	 */
	public void initAfterLoad() {
		mCommon.initCtnnAfterLoad(this);
	}

	/**
	 * Sets the CodedVitalSignsSection.
	 *
	 * @param codedVitalSigns
	 *            the CodedVitalSignsSection
	 */
	public void setCodedVitalSignsSection(CodedVitalSignsSection codedVitalSigns) {
		if (getCodedVitalSignsSection() == null) {
			getMdht().addSection(codedVitalSigns.copy());
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionAbilityToWork(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.ABILITY_TO_WORK,
				SectionsEDES.ABILITY_TO_WORK.findSection(getDoc()), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionAcuityAssessment(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.ACUITY_ASSESSMENT,
				getDoc().getAcuityAssessmentSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionAllergiesAndOtherAdverseReactions(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.ALLERGIES_AND_OTHER_ADVERSE_REACTIONS,
				getDoc().getAllergiesReactionsSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionAssessments(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.ASSESSMENTS, getDoc().getAssessmentsSection(),
				text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionChiefComplaint(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.CHIEF_COMPLAINT,
				getDoc().getChiefComplaintSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionCodedVitalSigns(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.CODED_VITAL_SIGNS,
				getDoc().getCodedVitalSignsSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionEdDisposition(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.ED_DISPOSITION,
				getDoc().getEDDispositionSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionFamilyMedicalHistory(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.FAMILY_MEDICAL_HISTORY,
				getDoc().getFamilyMedicalHistorySection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionHistoryOfPastIllness(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.HISTORY_OF_PAST_ILLNESS,
				getDoc().getHistoryOfPastIllnessSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionHistoryOfPresentIllness(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.HISTORY_OF_PRESENT_ILLNESS,
				getDoc().getHistoryOfPresentIllness(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionImmunizations(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.HISTORY_OF_IMMUNIZATION,
				getDoc().getImmunizationsSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionIntravenousFluidsAdministered(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.INTRAVENOUS_FLUIDS_ADMINISTERED,
				getDoc().getIntravenousFluidsAdministeredSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionListOfSurgeries(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.LIST_OF_SURGERIES,
				getDoc().getSurgeriesSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionMedications(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.CURRENT_MEDICATIONS,
				getDoc().getMedicationsSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionMedicationsAdministered(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.MEDICATIONS_ADMINISTERED,
				getDoc().getMedicationsAdministeredSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionModeOfArrival(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.MODE_OF_ARRIVAL,
				getDoc().getModeOfArrivalSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionPregnancyHistory(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.HISTORY_OF_PREGNANCIES,
				getDoc().getPregnancyHistorySection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionProceduresAndInterventions(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.PROCEDURES,
				getDoc().getProceduresAndInterventionsSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionReasonForVisit(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.REASON_FOR_VISIT,
				getDoc().getReasonForVisitSection(), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionRemarks(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.REMARKS,
				SectionsEDES.REMARKS.findSection(getDoc()), text);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionSocialHistory(String text) {
		mCommon.setNarrativeTextSection(SectionsEDES.SOCIAL_HISTORY,
				getDoc().getSocialHistorySection(), text);
	}

	/**
	 * Convenience function, which adds a Vital Sign Organizer and creates the
	 * Vital Sign Section automatically with the current LanguageCode of the
	 * document.
	 *
	 * @param organizer
	 *            the organizer
	 */
	public void setVitalSignsOrganizer(VitalSignsOrganizer organizer) {
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
