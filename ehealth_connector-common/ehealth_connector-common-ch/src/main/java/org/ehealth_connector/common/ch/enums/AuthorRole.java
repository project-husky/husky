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
package org.ehealth_connector.common.ch.enums;

import java.util.HashMap;
import java.util.Map;

import org.ehealth_connector.common.enums.LanguageCode;

/**
 * <div class="en">Role of the author as per Annex 3 EPRO-FDHA, Chapter
 * 2.1&lt;br clear="none"/&gt; &lt;br clear="none"/&gt;This code defines the
 * role of the author within the institution, e.g. doctor, nurse, therapist,
 * etc, This is a sub-attribute of epd_xds_author.&lt;br clear="none"/&gt;</div>
 * <div class="de">Rolle des Autors gemäss Anhang 3 EPDV-EDI, Kapitel 2.1&lt;br
 * clear="none"/&gt; &lt;br clear="none"/&gt;Dieser Code definiert die Rolle des
 * Authors innerhalb der Institution, z.B Arzt, Pflegefachperson, Therapeut,
 * etc. Dies ist ein Sub-Attribut von epd_xds_author.&lt;br
 * clear="none"/&gt;</div> <div class="fr">Rôle de l'auteur selon l'annexe 3
 * ODEP-DFI, chapitre 2.1&lt;br clear="none"/&gt; &lt;br clear="none"/&gt;Ce
 * code définit le rôle de l'auteur au sein de l'institution, p. ex, médecin,
 * professionnel des soins, thérapeute, etc. Il s'agit d'un sous-attribut
 * de&amp;#160; epd_xds_author.&lt;br clear="none"/&gt;</div>
 * <div class="it">Ruolo dell'autore secondo l'allegato 3 OCIP-DFI, capitolo
 * 2.1&lt;br clear="none"/&gt; &lt;br clear="none"/&gt;Questo codice definisce
 * il ruolo dell'autore all'interno dell'istituzione, p. es. medico, infermiere,
 * terapeuta, ecc. È un sottoattributo di epd_xds_author.&lt;br
 * clear="none"/&gt;</div>
 */
public enum AuthorRole implements ValueSetEnumInterface {

	/**
	 * <div class="en">Pharmacist</div> <div class="de">Apotheker</div>
	 * <div class="fr">Pharmacien</div> <div class="it">Farmacista</div>
	 */
	PHARMACIST("46255001", "2.16.840.1.113883.6.96", "Pharmacist (occupation)", "Pharmacist", "Apotheker", "Pharmacien", "Farmacista"),
	/**
	 * <div class="en">Physician </div> <div class="de">Arzt</div>
	 * <div class="fr">Médecin</div> <div class="it">Medico</div>
	 */
	PHYSICIAN("309343006", "2.16.840.1.113883.6.96", "Physician (occupation)", "Physician ", "Arzt", "Médecin", "Medico"),
	/**
	 * <div class="en">Chiropractor</div> <div class="de">Chiropraktiker</div>
	 * <div class="fr">Chiropracteur</div> <div class="it">Chiropratico</div>
	 */
	CHIROPRACTOR("3842006", "2.16.840.1.113883.6.96", "Chiropractor (occupation)", "Chiropractor", "Chiropraktiker", "Chiropracteur", "Chiropratico"),
	/**
	 * <div class="en">Dietitian</div> <div class="de">Ernährungsberater</div>
	 * <div class="fr">Diététicien</div> <div class="it">Nutrizionista</div>
	 */
	DIETITIAN("159033005", "2.16.840.1.113883.6.96", "Dietitian (occupation)", "Dietitian", "Ernährungsberater", "Diététicien", "Nutrizionista"),
	/**
	 * <div class="en">Midwife</div> <div class="de">Hebamme</div>
	 * <div class="fr">Sage-femme</div> <div class="it">Ostetrica</div>
	 */
	MIDWIFE("309453006", "2.16.840.1.113883.6.96", "Registered midwife (occupation)", "Midwife", "Hebamme", "Sage-femme", "Ostetrica"),
	/**
	 * <div class="en">Complementary therapist</div>
	 * <div class="de">Komplementärmediziner</div> <div class="fr">Thérapeute en
	 * médecine alternative et complémentaire</div> <div class="it">Terapista
	 * complementare</div>
	 */
	COMPLEMENTARY_THERAPIST("224609002", "2.16.840.1.113883.6.96", "Complementary health worker (occupation)", "Complementary therapist", "Komplementärmediziner", "Thérapeute en médecine alternative et complémentaire", "Terapista complementare"),
	/**
	 * <div class="en">Patient</div> <div class="de">Patient</div>
	 * <div class="fr">Patient</div> <div class="it">Paziente</div>
	 */
	PATIENT("116154003", "2.16.840.1.113883.6.96", "Patient (person)", "Patient", "Patient", "Patient", "Paziente"),
	/**
	 * <div class="en">Professional nurse</div>
	 * <div class="de">Pflegefachperson</div> <div class="fr">Infirmier</div>
	 * <div class="it">Infermiere professionale</div>
	 */
	PROFESSIONAL_NURSE("106292003", "2.16.840.1.113883.6.96", "Professional nurse (occupation)", "Professional nurse", "Pflegefachperson", "Infirmier", "Infermiere professionale"),
	/**
	 * <div class="en">Psychologist </div> <div class="de">Psychologe</div>
	 * <div class="fr">Psychologue</div> <div class="it">Psicologo</div>
	 */
	PSYCHOLOGIST("59944000", "2.16.840.1.113883.6.96", "Psychologist (occupation)", "Psychologist ", "Psychologe", "Psychologue", "Psicologo"),
	/**
	 * <div class="en">Social worker</div>
	 * <div class="de">Sozialdienstmitarbeiter</div> <div class="fr">Assistant
	 * social</div> <div class="it">Assistente sociale</div>
	 */
	SOCIAL_WORKER("158933003", "2.16.840.1.113883.6.96", "Social caseworker (general) (occupation)", "Social worker", "Sozialdienstmitarbeiter", "Assistant social", "Assistente sociale"),
	/**
	 * <div class="en">Speech therapist</div> <div class="de">Logopäde</div>
	 * <div class="fr">Logopédiste</div> <div class="it">Logopedista</div>
	 */
	SPEECH_THERAPIST("159026005", "2.16.840.1.113883.6.96", "Speech/language therapist (occupation)", "Speech therapist", "Logopäde", "Logopédiste", "Logopedista"),
	/**
	 * <div class="en">Physiotherapist</div>
	 * <div class="de">Physiotherapeut</div>
	 * <div class="fr">Physiothérapeute</div>
	 * <div class="it">Fisioterapista</div>
	 */
	PHYSIOTHERAPIST("36682004", "2.16.840.1.113883.6.96", "Physiotherapist (occupation)", "Physiotherapist", "Physiotherapeut", "Physiothérapeute", "Fisioterapista"),
	/**
	 * <div class="en">Occupational therapist</div>
	 * <div class="de">Ergotherapeut</div> <div class="fr">Ergothérapeute</div>
	 * <div class="it">Ergoterapista</div>
	 */
	OCCUPATIONAL_THERAPIST("80546007", "2.16.840.1.113883.6.96", "Occupational therapist (occupation)", "Occupational therapist", "Ergotherapeut", "Ergothérapeute", "Ergoterapista"),
	/**
	 * <div class="en">Breast Feeding Consultant</div>
	 * <div class="de">Stillberaterin</div> <div class="fr">Consultante en
	 * lactation</div> <div class="it">Consulente per l'allattamento</div>
	 */
	BREAST_FEEDING_CONSULTANT("225726006", "2.16.840.1.113883.6.96", "Lactation consultant (occupation)", "Breast Feeding Consultant", "Stillberaterin", "Consultante en lactation", "Consulente per l'allattamento"),
	/**
	 * <div class="en">Dentist</div> <div class="de">Zahnarzt</div>
	 * <div class="fr">Dentiste</div> <div class="it">Dentista</div>
	 */
	DENTIST("106289002", "2.16.840.1.113883.6.96", "Dentist (occupation)", "Dentist", "Zahnarzt", "Dentiste", "Dentista"),
	/**
	 * <div class="en">Radiologist</div> <div class="de">Radiologe</div>
	 * <div class="fr">Radiologue</div> <div class="it">Radiologo</div>
	 */
	RADIOLOGIST("66862007", "2.16.840.1.113883.6.96", "Radiologist (occupation)", "Radiologist", "Radiologe", "Radiologue", "Radiologo"),
	/**
	 * <div class="en">Healthcare professional</div> <div class="de">Andere
	 * Gesundheitsfachperson</div> <div class="fr">Autre professionnel de la
	 * santé</div> <div class="it">Altri professionisti della salute</div>
	 */
	HEALTHCARE_PROFESSIONAL("223366009", "2.16.840.1.113883.6.96", "Healthcare professional (occupation)", "Healthcare professional", "Andere Gesundheitsfachperson", "Autre professionnel de la santé", "Altri professionisti della salute");

	/**
	 * <div class="en">Code for Pharmacist</div> <div class="de">Code für
	 * Apotheker</div> <div class="fr">Code de Pharmacien</div>
	 * <div class="it">Code per Farmacista</div>
	 */
	public static final String PHARMACIST_CODE = "46255001";

	/**
	 * <div class="en">Code for Physician </div> <div class="de">Code für
	 * Arzt</div> <div class="fr">Code de Médecin</div> <div class="it">Code per
	 * Medico</div>
	 */
	public static final String PHYSICIAN_CODE = "309343006";

	/**
	 * <div class="en">Code for Chiropractor</div> <div class="de">Code für
	 * Chiropraktiker</div> <div class="fr">Code de Chiropracteur</div>
	 * <div class="it">Code per Chiropratico</div>
	 */
	public static final String CHIROPRACTOR_CODE = "3842006";

	/**
	 * <div class="en">Code for Dietitian</div> <div class="de">Code für
	 * Ernährungsberater</div> <div class="fr">Code de Diététicien</div>
	 * <div class="it">Code per Nutrizionista</div>
	 */
	public static final String DIETITIAN_CODE = "159033005";

	/**
	 * <div class="en">Code for Midwife</div> <div class="de">Code für
	 * Hebamme</div> <div class="fr">Code de Sage-femme</div>
	 * <div class="it">Code per Ostetrica</div>
	 */
	public static final String MIDWIFE_CODE = "309453006";

	/**
	 * <div class="en">Code for Complementary therapist</div>
	 * <div class="de">Code für Komplementärmediziner</div> <div class="fr">Code
	 * de Thérapeute en médecine alternative et complémentaire</div>
	 * <div class="it">Code per Terapista complementare</div>
	 */
	public static final String COMPLEMENTARY_THERAPIST_CODE = "224609002";

	/**
	 * <div class="en">Code for Patient</div> <div class="de">Code für
	 * Patient</div> <div class="fr">Code de Patient</div> <div class="it">Code
	 * per Paziente</div>
	 */
	public static final String PATIENT_CODE = "116154003";

	/**
	 * <div class="en">Code for Professional nurse</div> <div class="de">Code
	 * für Pflegefachperson</div> <div class="fr">Code de Infirmier</div>
	 * <div class="it">Code per Infermiere professionale</div>
	 */
	public static final String PROFESSIONAL_NURSE_CODE = "106292003";

	/**
	 * <div class="en">Code for Psychologist </div> <div class="de">Code für
	 * Psychologe</div> <div class="fr">Code de Psychologue</div>
	 * <div class="it">Code per Psicologo</div>
	 */
	public static final String PSYCHOLOGIST_CODE = "59944000";

	/**
	 * <div class="en">Code for Social worker</div> <div class="de">Code für
	 * Sozialdienstmitarbeiter</div> <div class="fr">Code de Assistant
	 * social</div> <div class="it">Code per Assistente sociale</div>
	 */
	public static final String SOCIAL_WORKER_CODE = "158933003";

	/**
	 * <div class="en">Code for Speech therapist</div> <div class="de">Code für
	 * Logopäde</div> <div class="fr">Code de Logopédiste</div>
	 * <div class="it">Code per Logopedista</div>
	 */
	public static final String SPEECH_THERAPIST_CODE = "159026005";

	/**
	 * <div class="en">Code for Physiotherapist</div> <div class="de">Code für
	 * Physiotherapeut</div> <div class="fr">Code de Physiothérapeute</div>
	 * <div class="it">Code per Fisioterapista</div>
	 */
	public static final String PHYSIOTHERAPIST_CODE = "36682004";

	/**
	 * <div class="en">Code for Occupational therapist</div>
	 * <div class="de">Code für Ergotherapeut</div> <div class="fr">Code de
	 * Ergothérapeute</div> <div class="it">Code per Ergoterapista</div>
	 */
	public static final String OCCUPATIONAL_THERAPIST_CODE = "80546007";

	/**
	 * <div class="en">Code for Breast Feeding Consultant</div>
	 * <div class="de">Code für Stillberaterin</div> <div class="fr">Code de
	 * Consultante en lactation</div> <div class="it">Code per Consulente per
	 * l'allattamento</div>
	 */
	public static final String BREAST_FEEDING_CONSULTANT_CODE = "225726006";

	/**
	 * <div class="en">Code for Dentist</div> <div class="de">Code für
	 * Zahnarzt</div> <div class="fr">Code de Dentiste</div>
	 * <div class="it">Code per Dentista</div>
	 */
	public static final String DENTIST_CODE = "106289002";

	/**
	 * <div class="en">Code for Radiologist</div> <div class="de">Code für
	 * Radiologe</div> <div class="fr">Code de Radiologue</div>
	 * <div class="it">Code per Radiologo</div>
	 */
	public static final String RADIOLOGIST_CODE = "66862007";

	/**
	 * <div class="en">Code for Healthcare professional</div>
	 * <div class="de">Code für Andere Gesundheitsfachperson</div>
	 * <div class="fr">Code de Autre professionnel de la santé</div>
	 * <div class="it">Code per Altri professionisti della salute</div>
	 */
	public static final String HEALTHCARE_PROFESSIONAL_CODE = "223366009";

	/**
	 * <div class="en">Name of the value set</div> <div class="de">Name des
	 * Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "epd_xds_authorRole";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.1.3";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static AuthorRole getEnum(String code) {
		for (final AuthorRole x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(AuthorRole.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final AuthorRole x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 */
	private String codeSystem;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instanziiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	AuthorRole(String code, String codeSystem, String displayName, String displayNameEn,
			String displayNameDe, String displayNameFr, String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemValue() {
		return this.codeSystem;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is
	 * returned.</div> <div class="de">Liefert display name gemäss Parameter,
	 * falls es keine Englische Übersetzung gibt, wird der default-Name
	 * zurückgegeben.</div>
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <div class="en">Gets the value set name.</div> <div class="de">Liefert
	 * den Value Set Namen.</div>
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
