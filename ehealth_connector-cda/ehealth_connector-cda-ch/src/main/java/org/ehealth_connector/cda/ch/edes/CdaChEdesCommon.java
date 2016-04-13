/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch.edes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.AbstractAllergyProblem;
import org.ehealth_connector.cda.AbstractProblemEntry;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.ProblemConcern;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.textbuilder.SimpleTextBuilder;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection;
import org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;

/**
 * <div class="en">This class represents common methods of EDES CDA documents.
 * It works on a ClinicalDocument. For internal use with specific EDES documents
 * like EDES-CTNN and EDES-EDPN.</div>
 */
public class CdaChEdesCommon {

	private static final String DOCTITLE_EN = "Emergency Department Encounter Summary";

	private static final String DOCTITLE_GER = "Notfallaustrittsbericht";
	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1.3.1.1";

	private final ClinicalDocument document;

	/**
	 * Create a new common EDES CDA.
	 *
	 * @param document
	 *            MDHT ClinicalDocument object
	 */
	public CdaChEdesCommon(ClinicalDocument document) {
		this.document = document;
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
		section.createStrucDocText(getAllergyTable(getAllergiesAndOtherAdverseReactions(section)));
		// Generate <text> Allergy table</text>
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
		section.createStrucDocText(getProblemTable(section)); // Generate
		// <text>ProblemConcern
		// table</text>
	}

	public void addSection(Section section) {
		SectionsEDES sectionEnum = SectionsEDES.getEnum(section);
		if (document.getLanguageCode() != null) {
			section.setTitle(Util.st(sectionEnum
					.getSectionTitle(LanguageCode.getEnum(document.getLanguageCode().getCode()))));
		}
		document.addSection(section);
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

	public String getAllergyTable(List<AllergyConcern> allergyConcerns) {
		StringBuilder sb = new StringBuilder();
		if (!allergyConcerns.isEmpty()) {
			sb.append("<table><tbody>");
			CS lcode = document.getLanguageCode();
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
			for (AllergyConcern AllergyConcern : allergyConcerns) {
				String strStatus = "-";
				String strCommentar = "-";
				if (AllergyConcern.getStatus().toString() != null)
					strStatus = AllergyConcern.getStatus().toString();
				if (AllergyConcern.getConcernEntry().getText().getText() != null)
					strCommentar = AllergyConcern.getConcernEntry().getText().getText();
				for (AbstractAllergyProblem AllergyProblem : AllergyConcern.getAllergyProblems()) {
					String strStartDateTime = "-";
					String strEndDateTime = "-";
					String strCode = "-";
					String strDescription = "-";
					try {
						if (AllergyProblem.getStartDate() != null)
							strStartDateTime = AllergyProblem.getStartDate();
						if (AllergyProblem.getEndDate() != null)
							strEndDateTime = AllergyProblem.getEndDate();
					} catch (NullPointerException npe) {
					}
					if (AllergyProblem.getValue().getCode().getCode() != null)
						strCode = AllergyProblem.getValue().getCode().getCode();
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

	public String getDocumentTitle() {
		CS lcode = document.getLanguageCode();
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

	public String getProblemTable(Section section) {
		final EList<Act> acts = section.getActs();
		StringBuilder sb = new StringBuilder();
		if (!acts.isEmpty()) {
			sb.append("<table><tbody>");
			CS lcode = document.getLanguageCode();
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
				for (AbstractProblemEntry Problementry : Problemconcern.getProblemEntries()) {
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
					} catch (NullPointerException npe) {
					}
					if (Problementry.getValue().getCode().getCodeSystemName() != null)
						strCatalog = Problementry.getValue().getCode().getCodeSystemName();
					if (Problementry.getValue().getCode().getCode() != null
							&& Problementry.getValue().getCode().getCode() != "")
						strCode = Problementry.getValue().getCode().getCode();
					if (Problementry.getValue().getCode().getDisplayName() != null)
						strDescription = Problementry.getValue().getCode().getDisplayName();
					// if (strDescription == "-") strDescription =
					// Problementry.getValue().GetOriginalTextReference();
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
}
