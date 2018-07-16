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
package org.ehealth_connector.cda.ch.vacd.enums;

import org.ehealth_connector.cda.enums.ContentIdPrefix;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;

public enum SectionsVacd implements ContentIdPrefix {
	//@formatter:off
	HISTORY_OF_IMMUNIZATION("11369-6", "hoi", "Impfungen", "Vaccinations", "Vaccinazioni","Immunizations"),
	ACTIVE_PROBLEMS("11450-4", "ap", "Problemliste", "Liste des problèmes", "Elenco dei problemi", "Active Problems"),
	HISTORY_OF_PAST_ILLNESS("11348-0", "hipi", "Bisherige Krankheiten", "Antécédants médicaux", "Storia medica", "History of Past Illness"),
	ALLERGIES_REACTIONS("48765-2", "ar", "Allergien und Unverträglichkeiten", "Allergies et autres réactions indésirables", "Allergie e altre reazioni avverse", "Allergies and Other Adverse Reactions"),
	CODED_RESULTS("30954-2", "cr", "Codierte Resultate", "fr: TOTRANSLATE", "it: TOTRANSLATE", "Coded Results"),
	SEROLOGY_STUDIES("18727-8", "sst", "Laborbefund - Serologie", "Rapport de laboratoire - Sérologie", "Referto di laboratorio - Sierologia", "Laboratory report - Serology studies"),
	HISTORY_OF_PREGNANCIES("10162-6", "hop", "Schwangerschaften", "Grossesses", "Gravidanze", "Pregnancy History"),
	TREATMENT_PLAN("18776-5", "tp", "Impfplan", "fr: TOTRANSLATE", "it: TOTRANSLATE", "Immunization Recommendations"),
	REMARKS("48767-8", "k", "Kommentar", "Commentaire", "Osservazione", "Comment");
	//@formatter:on

	public static boolean isActiveProblems(String code) {
		return ACTIVE_PROBLEMS.getLoincCode().equals(code);
	}

	public static boolean isAllergiesReactions(String code) {
		return ALLERGIES_REACTIONS.getLoincCode().equals(code);
	}

	public static boolean isCodedResults(String code) {
		return CODED_RESULTS.getLoincCode().equals(code);
	}

	public static boolean isHistoryOfImmunization(String code) {
		return HISTORY_OF_IMMUNIZATION.getLoincCode().equals(code);
	}

	public static boolean isHistoryOfPastIllness(String code) {
		return HISTORY_OF_PAST_ILLNESS.getLoincCode().equals(code);
	}

	public static boolean isLaboratorySpeciality(String code) {
		return SEROLOGY_STUDIES.getLoincCode().equals(code);
	}

	public static boolean isRemarks(String code) {
		return REMARKS.getLoincCode().equals(code);
	}

	public static boolean isTreatmentPlan(String code) {
		return TREATMENT_PLAN.getLoincCode().equals(code);
	}

	private String loincCode;

	private String contentIdPrefix;

	private String sectionTitleDe;

	private String sectionTitleFr;

	private String sectionTitleIt;

	private String sectionTitleEn;

	SectionsVacd(String loincCode, String contentIdPrefix, String sectionTitleDe,
			String sectionTitleFr, String sectionTitleIt, String sectionTitleEn) {
		this.loincCode = loincCode;
		this.contentIdPrefix = contentIdPrefix;
		this.sectionTitleDe = sectionTitleDe;
		this.sectionTitleFr = sectionTitleFr;
		this.sectionTitleIt = sectionTitleIt;
		this.sectionTitleEn = sectionTitleEn;
	}

	@Override
	public String getContentIdPrefix() {
		return contentIdPrefix;
	}

	public String getLoincCode() {
		return loincCode;
	}

	public String getSectionTitle(CS lc) {
		final String lcStr = lc.getCode().toLowerCase();
		if (lcStr.equals(LanguageCode.GERMAN.getCodeValue().toLowerCase()))
			return getSectionTitleDe();
		if (lcStr.equals(LanguageCode.FRENCH.getCodeValue().toLowerCase()))
			return getSectionTitleFr();
		if (lcStr.equals(LanguageCode.ITALIAN.getCodeValue().toLowerCase()))
			return getSectionTitleIt();
		if ("de".equals(lcStr))
			return getSectionTitleDe();
		if ("fr".equals(lcStr))
			return getSectionTitleFr();
		if ("it".equals(lcStr))
			return getSectionTitleIt();
		if ("en".equals(lcStr))
			return getSectionTitleEn();
		return getSectionTitleDe();
	}

	public String getSectionTitleDe() {
		return sectionTitleDe;
	}

	public String getSectionTitleEn() {
		return sectionTitleEn;
	}

	public String getSectionTitleFr() {
		return sectionTitleFr;
	}

	public String getSectionTitleIt() {
		return sectionTitleIt;
	}
}
