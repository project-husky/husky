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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.AbstractAllergyProblem;
import org.ehealth_connector.cda.AbstractCda;
import org.ehealth_connector.cda.AbstractObservation;
import org.ehealth_connector.cda.AbstractProblemConcern;
import org.ehealth_connector.cda.AbstractProblemEntry;
import org.ehealth_connector.cda.ch.ActiveProblemConcern;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.ProblemConcern;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.ch.textbuilder.AllergyConcernChTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.EdDiagnosisChTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.ObservationChTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.ProblemConcernEntryChTextBuilder;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.enums.ProblemsSpecialConditions;
import org.ehealth_connector.cda.textbuilder.SimpleTextBuilder;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection;
import org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection;
import org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry;
import org.openhealthtools.mdht.uml.cda.ihe.pcc.PCCFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;

/**
 * <div class="en">This class represents common methods of EDES CDA documents.
 * It works on a ClinicalDocument. For internal use with specific EDES documents
 * like EDES-CTNN and EDES-EDPN.</div>
 */
public class CdaChEdesCommon {

	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1.3.1.1";
	private CodedVitalSignsSection mCodedVitalSigns;

	private final ClinicalDocument mdhtDocument;
	private final AbstractCda cdaDocument;

	/**
	 * Create a new common EDES CDA.
	 *
	 * @param document
	 *            MDHT ClinicalDocument object
	 */
	public CdaChEdesCommon(AbstractCda cdaDocument) {
		this.cdaDocument = cdaDocument;
		this.mdhtDocument = cdaDocument.getDoc();
	}

	/**
	 * <div class="en">Adds the active problem concern.</div>
	 * <div class="de">Fügt ein Aktives Leiden hinzu</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param activeProblemConcern
	 *            <br>
	 *            <div class="en"> active problem concern</div> <div class="de">
	 *            Das aktive Leiden</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void addActiveProblemConcern(ActiveProblemConcern activeProblemConcern,
			ActiveProblemsSection section) {

		// find or create (and add) the Section
		if (section == null) {
			section = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
			addSection(section);
		}

		// add the MDHT Object to the section
		section.addAct(activeProblemConcern.copyMdhtProblemConcernEntry());

		// update the MDHT Object content references to CDA level 1 text
		if (updateProblemConcernReferences(section.getActs(), SectionsEDES.ACTIVE_PROBLEMS)) {
			if (cdaDocument.IsNarrativeTextGenerationEnabled()) {
				// create the CDA level 1 text
				section.createStrucDocText(generateNarrativeTextActiveProblemConcerns(section));
			} else {
				setNarrativeTextSection(SectionsEDES.ACTIVE_PROBLEMS, section, "");
			}
		} else {
			section.createStrucDocText("Keine Angaben");
			activeProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships().get(0)
					.getObservation().setText(Util.createEd(""));
		}
	}

	/**
	 * <div class="en">Adds the AllergiesOrOtherAdverseReaction</div>
	 * <div class="de">Fügt ein Allergie-Leiden hinzu</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param AllergiesOrOtherAdverseReaction
	 *            <div class="de">Allergie leiden</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void addAllergiesOrOtherAdverseReaction(AllergyConcern allergyOrOtherAdverseReaction,
			AllergiesReactionsSection section) {
		if (section == null) {
			section = IHEFactory.eINSTANCE.createAllergiesReactionsSection().init();
			addSection(section);
		}
		// add the MDHT Object to the section
		section.addAct(allergyOrOtherAdverseReaction.copyMdhtAllergyConcern());

		// create the CDA level 2 text (either generated or empty text with
		// content reference)

		// update the MDHT Object content references to CDA level 1 text
		if (updateAllergyConcernReferences(section.getActs(),
				SectionsEDES.ALLERGIES_AND_OTHER_ADVERSE_REACTIONS)) {
			if (cdaDocument.IsNarrativeTextGenerationEnabled()) {
				// create the CDA level 1 text
				section.createStrucDocText(generateNarrativeTextAllergyProblemConcerns(section));
			} else {
				setNarrativeTextSection(SectionsEDES.ALLERGIES_AND_OTHER_ADVERSE_REACTIONS, section,
						"");
			}
		} else {
			section.createStrucDocText("Keine Angaben");
			allergyOrOtherAdverseReaction.copyMdhtAllergyConcern().getEntryRelationships().get(0)
					.getObservation().setText(Util.createEd(""));
		}
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
			Author author, org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection section,
			LanguageCode languageCode) {
		if (mCodedVitalSigns == null) {
			if (section == null) {
				section = IHEFactory.eINSTANCE.createCodedVitalSignsSection().init();
				addSection(section);
			}
			mCodedVitalSigns = new org.ehealth_connector.cda.ch.edes.CodedVitalSignsSection(
					languageCode, section);
		}

		mCodedVitalSigns.add(organizer, vitalSign, author, "vs");

		// update the MDHT Object content references to CDA level 1 text
		if (updateProblemConcernReferences(section.getActs(), SectionsEDES.CODED_VITAL_SIGNS)) {
			if (cdaDocument.IsNarrativeTextGenerationEnabled()) {
				// create the CDA level 1 text
				section.createStrucDocText(generateNarrativeTextCodedVitalSigns(
						mCodedVitalSigns.getVitalSignObservations()));
			} else {
				setNarrativeTextSection(SectionsEDES.CODED_VITAL_SIGNS, section, "");
			}
		}
	}

	public void addEdDiagnosis(ProblemConcern edDiagnosis, Section section) {
		if (section == null) {
			section = PCCFactory.eINSTANCE.createEDDiagnosesSection().init();
			addSection(section);
		}
		// add the MDHT Object to the section
		section.addAct(edDiagnosis.copyMdhtProblemConcernEntry());

		// create the CDA level 2 text (either generated or empty text with
		// content reference)

		// update the MDHT Object content references to CDA level 1 text
		if (updateEdDiagnoseReferences(section.getActs(), SectionsEDES.ED_DIAGNOSIS)) {
			if (cdaDocument.IsNarrativeTextGenerationEnabled()) {
				// create the CDA level 1 text
				section.createStrucDocText(generateNarrativeTextEdDiagnoses(section));
			} else {
				setNarrativeTextSection(SectionsEDES.ED_DIAGNOSIS, section, "");
			}
		} else {
			section.createStrucDocText("Keine Angaben");
			edDiagnosis.copyMdhtProblemConcernEntry().getEntryRelationships().get(0)
					.getObservation().setText(Util.createEd(""));
		}
	}

	/**
	 * <div class="en">Adds a PastIllness</div> <div class="de">Fügt ein
	 * vergangenes Leiden hinzu</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param PastIllness
	 *            the past problem concern
	 */
	public void addPastIllness(PastProblemConcern pastIllness,
			HistoryOfPastIllnessSection section) {
		if (section == null) {
			section = IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
			addSection(section);
		}
		// add the MDHT Object to the section
		section.addAct(pastIllness.copyMdhtProblemConcernEntry());

		// update the MDHT Object content references to CDA level 1 text
		if (updateProblemConcernReferences(section.getActs(),
				SectionsEDES.HISTORY_OF_PAST_ILLNESS)) {
			// create the CDA level 2 text (either generated or empty text with
			// content reference)
			if (cdaDocument.IsNarrativeTextGenerationEnabled()) {
				section.createStrucDocText(generateNarrativeTextPastProblemConcernEntries(section));
			} else {
				setNarrativeTextSection(SectionsEDES.HISTORY_OF_PAST_ILLNESS, section, "");
			}
		} else {
			section.createStrucDocText("");
			pastIllness.copyMdhtProblemConcernEntry().getEntryRelationships().get(0)
					.getObservation().setText(Util.createEd(""));
		}
	}

	public void addSection(Section section) {
		final SectionsEDES sectionEnum = SectionsEDES.getEnum(section);
		if (mdhtDocument.getLanguageCode() != null) {
			section.setTitle(Util.st(sectionEnum.getSectionTitle(
					LanguageCode.getEnum(mdhtDocument.getLanguageCode().getCode()))));
		}
		mdhtDocument.addSection(section);
	}

	/**
	 * <div class="en">Generates the human readable text of the active problems
	 * section</div> <div class="de">Liefert den menschenlesbaren Text des
	 * Kapitels zu Aktiven Leiden zurück</div>
	 *
	 * @return the active problem concerns text
	 */
	public String generateNarrativeTextActiveProblemConcerns(Section section) {
		final List<AbstractProblemConcern> problemConcernEntryList = new ArrayList<AbstractProblemConcern>();
		// Convert from the specific PastProblemConcern Type to the more
		// general PastProblemConcern
		problemConcernEntryList.addAll(getActiveProblemConcerns(section));
		final ProblemConcernEntryChTextBuilder b = new ProblemConcernEntryChTextBuilder(
				problemConcernEntryList, SectionsEDES.ACTIVE_PROBLEMS);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the allergy concerns
	 * section</div> <div class="de">Liefert den Text des Kapitels Allergie
	 * Leiden zurück</div>
	 *
	 * @return the allergy problem concerns text
	 */
	public String generateNarrativeTextAllergyProblemConcerns(Section section) {
		final AllergyConcernChTextBuilder b = new AllergyConcernChTextBuilder(
				getAllergyProblemConcerns(section),
				SectionsEDES.ALLERGIES_AND_OTHER_ADVERSE_REACTIONS);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the coded vital
	 * signs section</div> <div class="de">Liefert den menschenlesbaren Text des
	 * Kapitels zu Aktiven Leiden zurück</div>
	 *
	 * @return the active problem concerns text
	 */
	public String generateNarrativeTextCodedVitalSigns(
			List<AbstractObservation> vitalSignObservationList) {
		final ObservationChTextBuilder b = new ObservationChTextBuilder(vitalSignObservationList,
				SectionsEDES.CODED_VITAL_SIGNS);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the ed diagnoses
	 * section</div> <div class="de">Liefert den Text des Kapitels
	 * Notfalldiagnosen zurück</div>
	 *
	 * @return the allergy problem concerns text
	 */
	public String generateNarrativeTextEdDiagnoses(Section section) {
		final List<AbstractProblemConcern> problemConcernEntryList = new ArrayList<AbstractProblemConcern>();
		problemConcernEntryList.addAll(getEdDiagnoses(section));
		final EdDiagnosisChTextBuilder b = new EdDiagnosisChTextBuilder(problemConcernEntryList,
				SectionsEDES.ED_DIAGNOSIS);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the history of past
	 * illness section</div> <div class="de">Liefert den menschenlesbaren Text
	 * zu allen vergangenen Leiden zurück</div>
	 *
	 * @return the past problem concern entries text
	 */
	public String generateNarrativeTextPastProblemConcernEntries(
			List<PastProblemConcern> pastProblemConcerns) {
		final List<AbstractProblemConcern> problemConcernEntryList = new ArrayList<AbstractProblemConcern>();

		// Convert from the specific PastProblemConcern Type to the more
		// general PastProblemConcern
		problemConcernEntryList.addAll(pastProblemConcerns);
		final ProblemConcernEntryChTextBuilder b = new ProblemConcernEntryChTextBuilder(
				problemConcernEntryList, SectionsEDES.HISTORY_OF_PAST_ILLNESS);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the history of past
	 * illness section</div> <div class="de">Liefert den menschenlesbaren Text
	 * zu allen vergangenen Leiden zurück</div>
	 *
	 * @return the past problem concern entries text
	 */
	public String generateNarrativeTextPastProblemConcernEntries(Section section) {
		final List<AbstractProblemConcern> problemConcernEntryList = new ArrayList<AbstractProblemConcern>();

		// Convert from the specific PastProblemConcern Type to the more
		// general PastProblemConcern
		problemConcernEntryList.addAll(getPastProblemConcerns(section));
		final ProblemConcernEntryChTextBuilder b = new ProblemConcernEntryChTextBuilder(
				problemConcernEntryList, SectionsEDES.HISTORY_OF_PAST_ILLNESS);
		return b.toString();
	}

	/**
	 * <div class="en">Gets the active problems</div> <div class="de">Liefert
	 * alle Aktiven Leiden zurück</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return the active problem concerns
	 */
	public List<ActiveProblemConcern> getActiveProblemConcerns(Section section) {
		// Search for the right section
		if (section == null) {
			return null;
		}
		final EList<Act> acts = section.getActs();

		final List<ActiveProblemConcern> problemConcernEntries = new ArrayList<ActiveProblemConcern>();
		for (final Act act : acts) {
			final ActiveProblemConcern problemConcernEntry = new ActiveProblemConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	/**
	 * <div class="en">Gets AllergiesAndOtherAdverseReactions</div>
	 * <div class="de">Liefert alle Allergie Leiden zurück</div>
	 *
	 * @return the AllergiesAndOtherAdverseReactions
	 */
	public List<AllergyConcern> getAllergiesAndOtherAdverseReactions(
			AllergiesReactionsSection section) {
		if (section == null) {
			return Collections.emptyList();
		}
		final EList<Act> acts = section.getActs();

		final List<AllergyConcern> AllergyConcerns = new ArrayList<AllergyConcern>();
		for (final Act act : acts) {
			final AllergyConcern AllergyConcern = new AllergyConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) act);
			AllergyConcerns.add(AllergyConcern);
		}
		return AllergyConcerns;
	}

	/**
	 * <div class="en">Gets the allergy problem concerns</div>
	 * <div class="de">Liefert alle Allergie Leiden zurück</div>
	 *
	 * @return the allergy problem concerns
	 */
	public List<AllergyConcern> getAllergyProblemConcerns(Section section) {
		// Search for the right section
		if (section == null) {
			return null;
		}
		final EList<Act> acts = section.getActs();

		final List<AllergyConcern> problemConcernEntries = new ArrayList<AllergyConcern>();
		for (final Act act : acts) {
			final AllergyConcern problemConcernEntry = new AllergyConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	public String getAllergyTable(List<AllergyConcern> allergyConcerns) {
		final StringBuilder sb = new StringBuilder();
		if (!allergyConcerns.isEmpty()) {
			sb.append("<table><tbody>");
			final CS lcode = mdhtDocument.getLanguageCode();
			if (lcode != null) {
				switch (lcode.getCode()) {
				case LanguageCode.GERMAN_CODE:
					sb.append(
							"<tr><th> von </th><th> bis</th><th>Code</th><th>Beschreibung</th><th>Status</th><th>Kommentar</th></tr>");
					break;
				case LanguageCode.FRENCH_CODE:
					break;
				case LanguageCode.ITALIAN_CODE:
					break;
				case LanguageCode.ENGLISH_CODE:
					sb.append(
							"<tr><th> From </th><th> Until</th><th>Code</th><th>Description</th><th>Status</th><th>Commentar</th></tr>");
					break;
				}
			}
			for (final AllergyConcern AllergyConcern : allergyConcerns) {
				String strStatus = "-";
				String strCommentar = "-";
				if (AllergyConcern.getStatus().toString() != null)
					strStatus = AllergyConcern.getStatus().toString();
				if (AllergyConcern.getConcernEntry().getText().getText() != null)
					strCommentar = AllergyConcern.getConcernEntry().getText().getText();
				for (final AbstractAllergyProblem AllergyProblem : AllergyConcern
						.getAllergyProblems()) {
					String strStartDateTime = "-";
					String strEndDateTime = "-";
					String strCode = "-";
					String strDescription = "-";
					try {
						if (AllergyProblem.getStartDate() != null)
							strStartDateTime = DateUtil.formatDateCH(AllergyProblem.getStartDate());
						if (AllergyProblem.getEndDate() != null)
							strEndDateTime = DateUtil.formatDateCH(AllergyProblem.getEndDate());
					} catch (final NullPointerException npe) {
					}
					if (AllergyProblem.getValue().getCode().getCode() != null)
						strCode = AllergyProblem.getValue().getCode().getCode();

					// TODO This is draft implementation only! the text needs to
					// be
					// translated by the real code. Displaynames should never be
					// used!
					if (AllergyProblem.getValue().getCode().getDisplayName() != null)
						strDescription = AllergyProblem.getValue().getCode().getDisplayName();
					// if (strDescription.equals("-") ) strDescription =
					// AllergyProblem.getValue().GetOriginalTextReference();
					sb.append("<tr><td>" + strStartDateTime + "</td><td>" + strEndDateTime
							+ "</td><td>" + strCode + "</td><td>" + strDescription + "</td><td>"
							+ strStatus + "</td><td>" + strCommentar + "</td></tr>");
				}
			}
			sb.append("</tbody></table>");
		}

		return sb.toString();
	}

	/**
	 * <div class="en">Gets the ED diagnoses</div> <div class="de">Liefert alle
	 * Notfalldiagnosen zurück</div>
	 *
	 * @return the allergy problem concerns
	 */
	public List<ProblemConcern> getEdDiagnoses(Section section) {
		// Search for the right section
		if (section == null) {
			return null;
		}
		final EList<Act> acts = section.getActs();

		final List<ProblemConcern> diagnosesEntries = new ArrayList<ProblemConcern>();
		for (final Act act : acts) {
			final ProblemConcern diagnosis = new ProblemConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			diagnosesEntries.add(diagnosis);
		}
		return diagnosesEntries;
	}

	public String getNarrativeText(Section section) {
		if (section != null) {
			final StrucDocText t = section.getText();
			return Util.extractStringFromNonQuotedStrucDocText(t);
		}
		return null;
	}

	/**
	 * <div class="en">Gets HistoryOfPastIllness</div> <div class="de">Liefert
	 * alle vergangen Leiden zurück</div>
	 *
	 * @return the HistoryOfPastIllness
	 */
	public List<PastProblemConcern> getPastIllness(HistoryOfPastIllnessSection section) {
		if (section == null) {
			return Collections.emptyList();
		}
		final EList<Act> acts = section.getActs();

		final List<PastProblemConcern> problemConcernEntries = new ArrayList<PastProblemConcern>();
		for (final Act act : acts) {
			final PastProblemConcern problemConcernEntry = new PastProblemConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	/**
	 * <div class="en">Gets the past problem concerns</div>
	 * <div class="de">Liefert alle vergangen Leiden zurück</div>
	 *
	 * @return the past problem concern entries
	 */
	public List<PastProblemConcern> getPastProblemConcerns(Section section) {
		// Search for the right section
		if (section == null) {
			return null;
		}
		final EList<Act> acts = section.getActs();

		final List<PastProblemConcern> problemConcernEntries = new ArrayList<PastProblemConcern>();
		for (final Act act : acts) {
			final PastProblemConcern problemConcernEntry = new PastProblemConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	public String getProblemTable(Section section) {
		final EList<Act> acts = section.getActs();
		final StringBuilder sb = new StringBuilder();
		if (!acts.isEmpty()) {
			sb.append("<table><tbody>");
			final CS lcode = mdhtDocument.getLanguageCode();
			if (lcode != null) {
				switch (lcode.getCode()) {
				case LanguageCode.GERMAN_CODE:
					sb.append(
							"<tr><th> von </th><th> bis </th><th>Katalog</th><th>Code</th><th>Beschreibung</th><th>Status</th><th>Kommentar</th></tr>");
					break;
				case LanguageCode.FRENCH_CODE:
					break;
				case LanguageCode.ITALIAN_CODE:
					break;
				case LanguageCode.ENGLISH_CODE:
					sb.append(
							"<tr><th> From</th><th> Until</th><th>Catalog</th><th>Code</th><th>Description</th><th>Status</th><th>Commentar</th></tr>");
					break;
				}
			}
			for (final Act act : acts) {
				String strStatus = "-";
				String strCommentar = "-";
				final ProblemConcern Problemconcern = new ProblemConcern(
						(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
				if (Problemconcern.getConcernEntry().getText().getText() != null)
					strCommentar = Problemconcern.getConcernEntry().getText().getText();
				if (Problemconcern.getStatus().toString() != null)
					strStatus = Problemconcern.getStatus().toString();
				for (final AbstractProblemEntry Problementry : Problemconcern.getProblemEntries()) {
					String strStartDateTime = "-";
					String strEndDateTime = "-";
					String strCode = "-";
					String strCatalog = "-";
					String strDescription = "-";
					try {
						if (Problementry.getStartDate() != null)
							strStartDateTime = DateUtil
									.formatDateTimeCh(Problementry.getStartDate());
						if (Problementry.getEndDate() != null)
							strEndDateTime = DateUtil.formatDateTimeCh(Problementry.getEndDate());
					} catch (final NullPointerException npe) {
					}
					final Value value = Problementry.getValue();
					if (value.isCode()) {
						if (value.getCode().getCodeSystemName() != null)
							strCatalog = Problementry.getValue().getCode().getCodeSystemName();
						if ((value.getCode().getCode() != null)
								&& (Problementry.getValue().getCode().getCode() != ""))
							strCode = Problementry.getValue().getCode().getCode();

						// TODO This is draft implementation only! the text
						// needs to be
						// translated by the real code. Displaynames should
						// never be
						// used!
						if (value.getCode().getDisplayName() != null)
							strDescription = Problementry.getValue().getCode().getDisplayName();
					}
					if (value.isEd()) {
						strDescription = value.getEdText();
					}
					sb.append("<tr><td>" + strStartDateTime + "</td><td>" + strEndDateTime
							+ "</td><td>" + strCatalog + "</td><td>" + strCode + "</td><td>"
							+ strDescription + "</td><td>" + strStatus + "</td><td>" + strCommentar
							+ "</td></tr>");

				}
			}
			sb.append("</tbody></table>");
		}

		return sb.toString();
	}

	public void setNarrativeTextSection(SectionsEDES sectionEdes, Section section, String text) {
		if (section == null) {
			section = sectionEdes.createSection();
			addSection(section);
		}
		section.createStrucDocText(new SimpleTextBuilder(sectionEdes, text).toString());
	}

	private boolean updateAllergyConcernReferences(EList<Act> acts, SectionsEDES loincSectionCode) {
		int i = 0;
		for (final Act act : acts) {
			int j = 0;
			i++;
			final org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) act;
			for (final ProblemEntry problemEntry : problemConcernEntry.getAllergyIntolerances()) {
				// Check if the problem is not unknown (leads to no reference,
				// because there is no problem)
				final Code code = new Code(problemEntry.getCode());
				if ("2.16.840.1.113883.6.96".equals(code.getCodeSystem()) && code.getCode().equals(
						ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
					return false;
				} else {
					// Create references to level 1 text
					ED reference;
					if (cdaDocument.IsNarrativeTextGenerationEnabled()) {
						reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
					} else {
						reference = Util.createReference(1, loincSectionCode.getContentIdPrefix());
					}
					problemEntry.setText(EcoreUtil.copy(reference));
					problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
				}
				for (final EntryRelationship er : problemEntry.getEntryRelationships()) {
					j++;
					CdaChUtil.updateRefIfComment(cdaDocument.IsNarrativeTextGenerationEnabled(), er,
							String.valueOf(i) + String.valueOf(j), loincSectionCode);
				}
			}
		}
		return true;
	}

	private boolean updateEdDiagnoseReferences(EList<Act> acts, SectionsEDES loincSectionCode) {
		int i = 0;
		for (final Act act : acts) {
			int j = 0;
			i++;
			final org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act;
			for (final ProblemEntry problemEntry : problemConcernEntry.getProblemEntries()) {
				// Check if the problem is not unknown (leads to no reference,
				// because there is no problem)
				final Code code = new Code(problemEntry.getCode());
				if ("2.16.840.1.113883.6.96".equals(code.getCodeSystem()) && code.getCode().equals(
						ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
					return false;
				} else {
					// Create references to level 1 text
					ED reference;
					if (cdaDocument.IsNarrativeTextGenerationEnabled()) {
						reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
					} else {
						reference = Util.createReference(1, loincSectionCode.getContentIdPrefix());
					}
					problemEntry.setText(EcoreUtil.copy(reference));
					problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
				}
				for (final EntryRelationship er : problemEntry.getEntryRelationships()) {
					j++;
					CdaChUtil.updateRefIfComment(cdaDocument.IsNarrativeTextGenerationEnabled(), er,
							String.valueOf(i) + String.valueOf(j), loincSectionCode);
				}
			}
		}
		return true;
	}

	public boolean updateProblemConcernReferences(EList<Act> acts, SectionsEDES loincSectionCode) {
		@SuppressWarnings("unused")
		int i = 0;
		for (final Act act : acts) {
			final org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act;
			for (final org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry problemEntry : problemConcernEntry
					.getProblemEntries()) {
				// Check if the problem is not unknown (leads to no reference,
				// because there is no problem)
				final Code code = new Code(problemEntry.getCode());
				if ("2.16.840.1.113883.6.96".equals(code.getCodeSystem()) && code.getCode().equals(
						ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
					return false;
				} else {
					// Create references to level 1 text
					i++;
					ED reference;
					if (cdaDocument.IsNarrativeTextGenerationEnabled()) {
						reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
					} else {
						reference = Util.createReference(1, loincSectionCode.getContentIdPrefix());
					}
					problemEntry.setText(EcoreUtil.copy(reference));
					problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
				}
			}
		}
		return true;
	}
}
