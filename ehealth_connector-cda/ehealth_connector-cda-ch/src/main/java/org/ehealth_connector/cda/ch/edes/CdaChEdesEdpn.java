package org.ehealth_connector.cda.ch.edes;

import java.util.Collections;
import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.textbuilder.SimpleTextBuilder;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.pcc.PCCFactory;

public class CdaChEdesEdpn extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn> {

	private CodedVitalSigns mCodedVitalSigns;

	public CdaChEdesEdpn() {
		super(CHFactory.eINSTANCE.createCdaChEdesEdpn().init());
	}

	public CdaChEdesEdpn(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn doc) {
		super(doc);
	}

	/**
	 * <div class="en">Creates a new EDES EDPN CDA document</div> <div
	 * class="de">Erstellt ein neues EDED EDPN CDA Dokument.</div>
	 * 
	 * @param language
	 * <br>
	 *            <div class="en">document language</div> <div
	 *            class="de">Sprache des Dokments</div> <div class="fr"></div>
	 *            <div class="it"></div>
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
	public CdaChEdesEdpn(LanguageCode language, String stylesheet, String cascadingStylesheet) {
		super(CHFactory.eINSTANCE.createCdaChEdesEdpn().init(), stylesheet, cascadingStylesheet);
		setLanguageCode(language);
	}

	/**
	 * <div class="en">Gets the MDHT-CdaChEdesEdpn Object</div> <div
	 * class="de">Liefert das MDHT-CdaChEdesEdpn-Objekt zurück.</div>
	 * 
	 * @return the doc
	 */
	@Override
	public org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn getDoc() {
		return (org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn) super.getDoc();
	}

	private String getNarrativeText(Section s) {
		if (s != null) {
			final StrucDocText t = s.getText();
			return Util.extractStringFromNonQuotedStrucDocText(t);
		}
		return null;
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
		return getNarrativeText(SectionsEDES.ABILITY_TO_WORK.findSection(getDoc()));
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ABILITY_TO_WORK, text);
		if (SectionsEDES.ABILITY_TO_WORK.findSection(getDoc()) == null) {
			getDoc().addSection(CHFactory.eINSTANCE.createAbilityToWorkSection().init());
		}
		SectionsEDES.ABILITY_TO_WORK.findSection(getDoc()).createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionActiveProblems() {
		return getNarrativeText(getDoc().getActiveProblemsSection());
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
	public void setNarrativeTextSectionActiveProblems(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ACTIVE_PROBLEMS, text);
		if (getDoc().getActiveProblemsSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createActiveProblemsSection().init());
		}
		getDoc().getActiveProblemsSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionAdvanceDirectives() {
		return getNarrativeText(getDoc().getAdvanceDirectivesSection());
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
	public void setNarrativeTextSectionAdvanceDirectives(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ADVANCE_DIRECTIVES, text);
		if (getDoc().getAdvanceDirectivesSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createAdvanceDirectivesSection().init());
		}
		getDoc().getAdvanceDirectivesSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionAllergiesReactions() {
		return getNarrativeText(getDoc().getAllergiesReactionsSection());
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
	public void setNarrativeTextSectionAllergiesReactions(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ALLERGIES_REACTIONS, text);
		if (getDoc().getAllergiesReactionsSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createAllergiesReactionsSection().init());
		}
		getDoc().getAllergiesReactionsSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionAssessmentAndPlan() {
		return getNarrativeText(getDoc().getAssessmentAndPlanSection());
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
	public void setNarrativeTextSectionAssessmentAndPlan(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ASSESSMENT_AND_PLAN, text);
		if (getDoc().getAssessmentAndPlanSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createAssessmentAndPlanSection().init());
		}
		getDoc().getAssessmentAndPlanSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getAssessmentsSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ASSESSMENTS, text);
		if (getDoc().getAssessmentsSection() == null) {
			getDoc().addSection(PCCFactory.eINSTANCE.createAssessmentsSection().init());
		}
		getDoc().getAssessmentsSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionCarePlan() {
		return getNarrativeText(getDoc().getCarePlanSection());
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
	public void setNarrativeTextSectionCarePlan(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.CARE_PLAN, text);
		if (getDoc().getCarePlanSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createCarePlanSection().init());
		}
		getDoc().getCarePlanSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getChiefComplaintSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.CHIEF_COMPLAINT, text);
		if (getDoc().getChiefComplaintSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createChiefComplaintSection().init());
		}
		getDoc().getChiefComplaintSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getCodedVitalSignsSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.CODED_VITAL_SIGNS, text);
		if (getDoc().getCodedVitalSignsSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createCodedVitalSignsSection().init());
		}
		getDoc().getCodedVitalSignsSection().createStrucDocText(sb.toString());
	}

	/**
	 * <div class="en">Add the coded vital sign observation to the
	 * document</div> <div class="de">Fügt das codierte Vitalzeichen in das
	 * Dokument ein</div>
	 * 
	 * @param sign
	 *            VitalSign <div class="en">The coded vital sign observation to
	 *            add</div> <div class="de">Das hinzuzufügende codierte
	 *            Vitalzeichen</div>
	 */
	public void addCodedVitalSign(VitalSignObservation sign) {
		if (mCodedVitalSigns == null) {
			CodedVitalSignsSection section = getDoc().getCodedVitalSignsSection();
			if (section == null) {
				section = IHEFactory.eINSTANCE.createCodedVitalSignsSection().init();
				getDoc().addSection(section);
			}
			mCodedVitalSigns = new CodedVitalSigns(section);
		}
		mCodedVitalSigns.add(sign);
	}

	/**
	 * <div class="en">Gets the coded vital sign observations</div> <div
	 * class="de">Liefert alle codierten Vitalzeichen zurück</div>
	 * 
	 * @return List with coded vital sign observations
	 */
	public List<VitalSignObservation> getCodedVitalSignObservations() {
		if (mCodedVitalSigns == null) {
			CodedVitalSignsSection section = getDoc().getCodedVitalSignsSection();
			if (section == null) {
				return Collections.emptyList();
			}
			mCodedVitalSigns = new CodedVitalSigns(section);
		}
		return mCodedVitalSigns.getCodedVitalSignObservations();
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
	public String getNarrativeTextSectionConsultations() {
		return getNarrativeText(getDoc().getConsultationsSection());
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
	public void setNarrativeTextSectionConsultations(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ED_CONSULTATIONS, text);
		if (getDoc().getConsultationsSection() == null) {
			getDoc().addSection(PCCFactory.eINSTANCE.createConsultationsSection().init());
		}
		getDoc().getConsultationsSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionEDDiagnoses() {
		return getNarrativeText(getDoc().getEDDiagnosesSection());
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
	public void setNarrativeTextSectionEDDiagnoses(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ED_DIAGNOSIS, text);
		if (getDoc().getEDDiagnosesSection() == null) {
			getDoc().addSection(PCCFactory.eINSTANCE.createEDDiagnosesSection().init());
		}
		getDoc().getEDDiagnosesSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionEDDisposition() {
		return getNarrativeText(getDoc().getEDDispositionSection());
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
	public void setNarrativeTextSectionEDDisposition(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.ED_DISPOSITION, text);
		if (getDoc().getEDDispositionSection() == null) {
			getDoc().addSection(PCCFactory.eINSTANCE.createEDDispositionSection().init());
		}
		getDoc().getEDDispositionSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getFamilyMedicalHistorySection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.FAMILY_MEDICAL_HISTORY,
				text);
		if (getDoc().getFamilyMedicalHistorySection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createFamilyMedicalHistorySection().init());
		}
		getDoc().getFamilyMedicalHistorySection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getHistoryOfPastIllnessSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.HISTORY_OF_PAST_ILLNESS,
				text);
		if (getDoc().getHistoryOfPastIllnessSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init());
		}
		getDoc().getHistoryOfPastIllnessSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getHistoryOfPresentIllness());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.HISTORY_OF_PRESENT_ILLNESS,
				text);
		if (getDoc().getHistoryOfPresentIllness() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createHistoryOfPresentIllness().init());
		}
		getDoc().getHistoryOfPresentIllness().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionHospitalDischargeMedications() {
		return getNarrativeText(getDoc().getHospitalDischargeMedicationsSection());
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
	public void setNarrativeTextSectionHospitalDischargeMedications(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(
				SectionsEDES.HOSPITAL_DISCHARGE_MEDICATIONS, text);
		if (getDoc().getHospitalDischargeMedicationsSection() == null) {
			getDoc().addSection(
					IHEFactory.eINSTANCE.createHospitalDischargeMedicationsSection().init());
		}
		getDoc().getHospitalDischargeMedicationsSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getImmunizationsSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.HISTORY_OF_IMMUNIZATION,
				text);
		if (getDoc().getImmunizationsSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createImmunizationsSection().init());
		}
		getDoc().getImmunizationsSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getIntravenousFluidsAdministeredSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(
				SectionsEDES.INTRAVENOUS_FLUIDS_ADMINISTERED, text);
		if (getDoc().getIntravenousFluidsAdministeredSection() == null) {
			getDoc().addSection(
					PCCFactory.eINSTANCE.createIntravenousFluidsAdministeredSection().init());
		}
		getDoc().getIntravenousFluidsAdministeredSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getMedicationsAdministeredSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.MEDICATIONS_ADMINISTERED,
				text);
		if (getDoc().getMedicationsAdministeredSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createMedicationsAdministeredSection().init());
		}
		getDoc().getMedicationsAdministeredSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getMedicationsSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.CURRENT_MEDICATIONS, text);
		if (getDoc().getMedicationsSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createMedicationsSection().init());
		}
		getDoc().getMedicationsSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getModeOfArrivalSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.MODE_OF_ARRIVAL, text);
		if (getDoc().getModeOfArrivalSection() == null) {
			getDoc().addSection(PCCFactory.eINSTANCE.createModeOfArrivalSection().init());
		}
		getDoc().getModeOfArrivalSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionPhysicalExam() {
		return getNarrativeText(getDoc().getPhysicalExamSection());
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
	public void setNarrativeTextSectionPhysicalExam(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.PHYSICAL_EXAMINATION, text);
		if (getDoc().getPhysicalExamSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createPhysicalExamSection().init());
		}
		getDoc().getPhysicalExamSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getPregnancyHistorySection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.HISTORY_OF_PREGNANCIES,
				text);
		if (getDoc().getPregnancyHistorySection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createPregnancyHistorySection().init());
		}
		getDoc().getPregnancyHistorySection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getProceduresAndInterventionsSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.PROCEDURES, text);
		if (getDoc().getProceduresAndInterventionsSection() == null) {
			getDoc().addSection(
					IHEFactory.eINSTANCE.createProceduresAndInterventionsSection().init());
		}
		getDoc().getProceduresAndInterventionsSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionProgressNote() {
		return getNarrativeText(getDoc().getProgressNoteSection());
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
	public void setNarrativeTextSectionProgressNote(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.PROGRESS_NOTE, text);
		if (getDoc().getProgressNoteSection() == null) {
			getDoc().addSection(PCCFactory.eINSTANCE.createProgressNoteSection().init());
		}
		getDoc().getProgressNoteSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getReasonForVisitSection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.REASON_FOR_VISIT, text);
		if (getDoc().getReasonForVisitSection() == null) {
			getDoc().addSection(PCCFactory.eINSTANCE.createReasonForVisitSection().init());
		}
		getDoc().getReasonForVisitSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionReferralSource() {
		return getNarrativeText(getDoc().getReferralSourceSection());
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
	public void setNarrativeTextSectionReferralSource(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.REFERRAL_SOURCE, text);
		if (getDoc().getReferralSourceSection() == null) {
			getDoc().addSection(PCCFactory.eINSTANCE.createReferralSourceSection().init());
		}
		getDoc().getReferralSourceSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionCodedResults() {
		return getNarrativeText(getDoc().getCodedResultsSection());
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
	public void setNarrativeTextSectionCodedResults(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.RESULTS, text);
		if (getDoc().getCodedResultsSection() == null) {
			getDoc().addSection(CHFactory.eINSTANCE.createCodedResultsSection().init());
		}
		getDoc().getCodedResultsSection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionReviewOfSystems() {
		return getNarrativeText(getDoc().getReviewOfSystemsSection());
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
	public void setNarrativeTextSectionReviewOfSystems(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.REVIEW_OF_SYSTEMS, text);
		if (getDoc().getReviewOfSystemsSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createReviewOfSystemsSection().init());
		}
		getDoc().getReviewOfSystemsSection().createStrucDocText(sb.toString());
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
		return getNarrativeText(SectionsEDES.REMARKS.findSection(getDoc()));
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.REMARKS, text);
		if (SectionsEDES.REMARKS.findSection(getDoc()) == null) {
			getDoc().addSection(CHFactory.eINSTANCE.createRemarksSection().init());
		}
		SectionsEDES.REMARKS.findSection(getDoc()).createStrucDocText(sb.toString());
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
		return getNarrativeText(getDoc().getSocialHistorySection());
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
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.SOCIAL_HISTORY, text);
		if (getDoc().getSocialHistorySection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createSocialHistorySection().init());
		}
		getDoc().getSocialHistorySection().createStrucDocText(sb.toString());
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
	public String getNarrativeTextSectionSurgeriesSection() {
		return getNarrativeText(getDoc().getSurgeriesSection());
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
	public void setNarrativeTextSectionSurgeriesSection(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsEDES.LIST_OF_SURGERIES, text);
		if (getDoc().getSurgeriesSection() == null) {
			getDoc().addSection(IHEFactory.eINSTANCE.createSurgeriesSection().init());
		}
		getDoc().getSurgeriesSection().createStrucDocText(sb.toString());
	}
}
