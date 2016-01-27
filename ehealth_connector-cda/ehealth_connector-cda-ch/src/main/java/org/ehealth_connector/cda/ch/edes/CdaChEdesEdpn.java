package org.ehealth_connector.cda.ch.edes;

import java.util.Collections;
import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
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
	 * <div class="en">Gets the MDHT-CdaChEdesCtnn Object</div> <div
	 * class="de">Liefert das MDHT-CdaChEdesCtnn-Objekt zurück.</div>
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
		return getNarrativeText(getDoc().getAbilityToWorkSection());
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
		if (getDoc().getAbilityToWorkSection() == null) {
			getDoc().addSection(CHFactory.eINSTANCE.createAbilityToWorkSection());
		}
		getDoc().getAbilityToWorkSection().createStrucDocText(sb.toString());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createAllergiesReactionsSection());
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
			getDoc().addSection(PCCFactory.eINSTANCE.createAssessmentsSection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createChiefComplaintSection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createCodedVitalSignsSection());
		}
		getDoc().getCodedVitalSignsSection().createStrucDocText(sb.toString());
	}

	/**
	 * <div class="en">Add the coded vital sign observation to the
	 * document</div> <div class="de">Fügt das codierte Vitalzeichen in das
	 * Dokument ein</div>
	 * 
	 * @param sign VitalSign
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
			getDoc().addSection(PCCFactory.eINSTANCE.createEDDispositionSection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createFamilyMedicalHistorySection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createHistoryOfPresentIllness());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createImmunizationsSection());
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
			getDoc().addSection(PCCFactory.eINSTANCE.createIntravenousFluidsAdministeredSection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createMedicationsAdministeredSection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createMedicationsSection());
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
			getDoc().addSection(PCCFactory.eINSTANCE.createModeOfArrivalSection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createPregnancyHistorySection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createProceduresAndInterventionsSection());
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
			getDoc().addSection(PCCFactory.eINSTANCE.createReasonForVisitSection());
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
	public String getNarrativeTextSectionRemarks() {
		return getNarrativeText(getDoc().getRemarksSection());
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
		if (getDoc().getRemarksSection() == null) {
			getDoc().addSection(CHFactory.eINSTANCE.createRemarksSection());
		}
		getDoc().getRemarksSection().createStrucDocText(sb.toString());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createSocialHistorySection());
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
			getDoc().addSection(IHEFactory.eINSTANCE.createSurgeriesSection());
		}
		getDoc().getSurgeriesSection().createStrucDocText(sb.toString());
	}
}
