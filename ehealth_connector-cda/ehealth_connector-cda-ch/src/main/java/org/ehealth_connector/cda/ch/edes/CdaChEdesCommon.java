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

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.AbstractAllergyProblem;
import org.ehealth_connector.cda.AbstractProblemEntry;
import org.ehealth_connector.cda.ch.AllergyConcern;
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
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;

public class CdaChEdesCommon {

	private static final String DOCTITLE_EN = "Emergency Department Encounter Summary";

	private static final String DOCTITLE_GER = "Notfallaustrittsbericht";
	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1.3.1.1";

	private ClinicalDocument document;

	public CdaChEdesCommon(ClinicalDocument document) {
		this.document = document;
	}

	public void addSection(Section section) {
		SectionsEDES sectionEnum = SectionsEDES.getEnum(section);
		if (document.getLanguageCode() != null) {
			section.setTitle(Util.st(sectionEnum
					.getSectionTitle(LanguageCode.getEnum(document.getLanguageCode().getCode()))));
		}
		document.addSection(section);
	}

	public String getAllergyTable(List<AllergyConcern> AllergyConcerns) {
		StringBuilder sb = new StringBuilder();
		if (!AllergyConcerns.isEmpty()) {
			sb.append("<table><tbody>");
			CS lcode = document.getLanguageCode();
			if (lcode != null) {
				switch (lcode.getCode()) {
				case LanguageCode.GERMAN_CODE:
					sb.append(
							"<tr><th> von Datum / Uhrzeit</th><th> bis Datum / Uhrzeit</th><th>Code</th><th>Beschreibung</th><th>Status</th><th>Kommentar</th></tr>");
					break;
				case LanguageCode.FRENCH_CODE:
					break;
				case LanguageCode.ITALIAN_CODE:
					break;
				case LanguageCode.ENGLISH_CODE:
					sb.append(
							"<tr><th> From Datum / Time</th><th> Until Date / Time</th><th>Code</th><th>Description</th><th>Status</th><th>Commentar</th></tr>");
					break;
				}
			}
			for (AllergyConcern AllergyConcern : AllergyConcerns) {
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
					// if (strDescription == "-") strDescription =
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

	public String getNarrativeText(Section s) {
		if (s != null) {
			final StrucDocText t = s.getText();
			return Util.extractStringFromNonQuotedStrucDocText(t);
		}
		return null;
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
							"<tr><th> von Datum / Uhrzeit</th><th> bis Datum / Uhrzeit</th><th>Katalog</th><th>Code</th><th>Beschreibung</th><th>Status</th><th>Kommentar</th></tr>");
					break;
				case LanguageCode.FRENCH_CODE:
					break;
				case LanguageCode.ITALIAN_CODE:
					break;
				case LanguageCode.ENGLISH_CODE:
					sb.append(
							"<tr><th> From Datum / Time</th><th> Until Date / Time</th><th>Catalog</th><th>Code</th><th>Description</th><th>Status</th><th>Commentar</th></tr>");
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
