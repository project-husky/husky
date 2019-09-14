/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">Type of healthcare facility as per Annex 3  EPRO-FDHA.<br clear="none"/><br clear="none"/>This code describes the type of healthcare facility in which the document was compiled during the treatment process. In conjunction with the authorisation control, the patient can use this information to assign all documents from a specific type of healthcare facility to a specific confidentiality level in their rights and attributes, for example.<br clear="none"/></div>
 * <div class="de">Typ der Gesundheitseinrichtung gemäss Anhang 3 EPDV-EDI. <br clear="none"/><br clear="none"/>Dieser Code beschreibt den Typ der Gesundheitseinrichtung, in der das Dokument während des Behandlungsprozesses erstellt wurde. Der Patient kann im Zusammenhang mit der Berechtigungsteuerung diese Information nutzen, um beispielsweise in seinen Rechteattributen allen Dokumenten aus einem bestimmten Gesundheitseinrichtungstyp eine bestimmte Vertraulichkeitsstufe zuzuordnen.<br clear="none"/></div>
 * <div class="fr">Type de l'institution de santé selon l'annexe 3 ODEP-DFI.<br clear="none"/><br clear="none"/>Ce code décrit le type de l'institution de santé qui a élaboré le document pendant le processus thérapeutique. Le patient peut utiliser cette information pour gérer les droits d'accès et définir, dans les règles d'accès, un même niveau de confidentialité pour tous les documents émanant d'un type d'institution donné.<br clear="none"/></div>
 * <div class="it">Tipo di istituzione sanitaria secondo l'allegato 3 OCIP-DFI.<br clear="none"/><br clear="none"/>Questo codice descrive il tipo di istituzione sanitaria nella quale è stato creato il documento durante il processo terapeutico. Il paziente può utilizzare questa informazione in relazione al controllo delle autorizzazioni, ad esempio per attribuire un determinato grado di riservatezza a tutti i documenti provenienti da un determinato tipo di istituzione sanitaria.<br clear="none"/></div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum HealthcareFacilityTypeCode implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Accident and Emergency department</div>
	 * <div class="de">Notfall-/Rettungsdienste</div>
	 * <div class="fr">Service d'urgence et de sauvetage</div>
	 * <div class="it">Servizio di pronto soccorso e di salvataggio</div>
	 * <!-- @formatter:on -->
	 */
	ACCIDENT_AND_EMERGENCY_DEPARTMENT("225728007", "2.16.840.1.113883.6.96",
			"Accident and Emergency department (environment)", "Accident and Emergency department",
			"Notfall-/Rettungsdienste", "Service d'urgence et de sauvetage",
			"Servizio di pronto soccorso e di salvataggio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ambulatory care site</div>
	 * <div class="de">Ambulante Einrichtung/Ambulatorium</div>
	 * <div class="fr">Etablissement ambulatoire</div>
	 * <div class="it">Struttura ambulatoriale, incl. gli studi medici</div>
	 * <!-- @formatter:on -->
	 */
	AMBULATORY_CARE_SITE("35971002", "2.16.840.1.113883.6.96", "Ambulatory care site (environment)",
			"Ambulatory care site", "Ambulante Einrichtung/Ambulatorium",
			"Etablissement ambulatoire", "Struttura ambulatoriale, incl. gli studi medici"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Client's or patient's home</div>
	 * <div class="de">Domizil des Patienten</div>
	 * <div class="fr">Domicile du patient</div>
	 * <div class="it">Domicilio del paziente</div>
	 * <!-- @formatter:on -->
	 */
	CLIENT_OR_PATIENT_HOME("394778007", "2.16.840.1.113883.6.96",
			"Client's or patient's home (environment)", "Client's or patient's home",
			"Domizil des Patienten", "Domicile du patient", "Domicilio del paziente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Diagnostic institution</div>
	 * <div class="de">Institution für medizinische Diagnostik</div>
	 * <div class="fr">Institut d’aide au diagnostic</div>
	 * <div class="it">Istituto di diagnostica medica</div>
	 * <!-- @formatter:on -->
	 */
	DIAGNOSTIC_INSTITUTION("722171005", "2.16.840.1.113883.6.96",
			"Diagnostic institution (environment)", "Diagnostic institution",
			"Institution für medizinische Diagnostik", "Institut d’aide au diagnostic",
			"Istituto di diagnostica medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General practice premises</div>
	 * <div class="de">Arztpraxis</div>
	 * <div class="fr">Cabinet médical</div>
	 * <div class="it">Studio medico</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_PRACTICE_PREMISES("264358009", "2.16.840.1.113883.6.96",
			"General practice premises (environement)", "General practice premises", "Arztpraxis",
			"Cabinet médical", "Studio medico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Health Authority</div>
	 * <div class="de">Gesundheitsbehörde</div>
	 * <div class="fr">Autorité sanitaire</div>
	 * <div class="it">Autorità sanitaria</div>
	 * <!-- @formatter:on -->
	 */
	HEALTH_AUTHORITY("394747008", "2.16.840.1.113883.6.96", "Health Authority (qualifier value)",
			"Health Authority", "Gesundheitsbehörde", "Autorité sanitaire",
			"Autorità sanitaria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hospital</div>
	 * <div class="de">Stationäre Einrichtung/Spital</div>
	 * <div class="fr">Hôpital</div>
	 * <div class="it">Ospedale</div>
	 * <!-- @formatter:on -->
	 */
	HOSPITAL("22232009", "2.16.840.1.113883.6.96", "Hospital (environment)", "Hospital",
			"Stationäre Einrichtung/Spital", "Hôpital", "Ospedale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Military health institution</div>
	 * <div class="de">Armeeärztliche Dienste</div>
	 * <div class="fr">Service sanitaire de l'armée</div>
	 * <div class="it">Servizio di medicina militare</div>
	 * <!-- @formatter:on -->
	 */
	MILITARY_HEALTH_INSTITUTION("722172003", "2.16.840.1.113883.6.96",
			"Military health institution (environment)", "Military health institution",
			"Armeeärztliche Dienste", "Service sanitaire de l'armée",
			"Servizio di medicina militare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nursing home</div>
	 * <div class="de">Pflegeheim</div>
	 * <div class="fr">Etablissement médico-social</div>
	 * <div class="it">Casa di cura</div>
	 * <!-- @formatter:on -->
	 */
	NURSING_HOME("42665001", "2.16.840.1.113883.6.96", "Nursing home (environment)", "Nursing home",
			"Pflegeheim", "Etablissement médico-social", "Casa di cura"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Other Site of Care</div>
	 * <div class="de">Andere Gesundheitsorganisation</div>
	 * <div class="fr">Autres prestataires de soins</div>
	 * <div class="it">Altre organizzazioni sanitarie</div>
	 * <!-- @formatter:on -->
	 */
	OTHER_SITE_OF_CARE("43741000", "2.16.840.1.113883.6.96", "Site of care (social concept)",
			"Other Site of Care", "Andere Gesundheitsorganisation", "Autres prestataires de soins",
			"Altre organizzazioni sanitarie"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pharmacy</div>
	 * <div class="de">Apotheke</div>
	 * <div class="fr">Pharmacie</div>
	 * <div class="it">Farmacia</div>
	 * <!-- @formatter:on -->
	 */
	PHARMACY("264372000", "2.16.840.1.113883.6.96", "Pharmacy (environment)", "Pharmacy",
			"Apotheke", "Pharmacie", "Farmacia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prison based care site</div>
	 * <div class="de">Gesundheitseinrichtung in der Haftanstalt</div>
	 * <div class="fr">Service de santé en milieu carcéral</div>
	 * <div class="it">Struttura sanitaria in uno stabilimento carcerario</div>
	 * <!-- @formatter:on -->
	 */
	PRISON_BASED_CARE_SITE("722173008", "2.16.840.1.113883.6.96",
			"Prison based care site (environment)", "Prison based care site",
			"Gesundheitseinrichtung in der Haftanstalt", "Service de santé en milieu carcéral",
			"Struttura sanitaria in uno stabilimento carcerario"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Private home-based care</div>
	 * <div class="de">Organisation für Pflege zu Hause</div>
	 * <div class="fr">Soins à domicile</div>
	 * <div class="it">Servizio di assistenza e cura a domicilio</div>
	 * <!-- @formatter:on -->
	 */
	PRIVATE_HOME_BASED_CARE("66280005", "2.16.840.1.113883.6.96",
			"Private home-based care (environment)", "Private home-based care",
			"Organisation für Pflege zu Hause", "Soins à domicile",
			"Servizio di assistenza e cura a domicilio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rehabilitation hospital</div>
	 * <div class="de">Organisation für stationäre Rehabilitation</div>
	 * <div class="fr">Réadaptation stationnaire</div>
	 * <div class="it">Istituto di riabilitazione stazionaria</div>
	 * <!-- @formatter:on -->
	 */
	REHABILITATION_HOSPITAL("80522000", "2.16.840.1.113883.6.96",
			"Rehabilitation hospital (environment)", "Rehabilitation hospital",
			"Organisation für stationäre Rehabilitation", "Réadaptation stationnaire",
			"Istituto di riabilitazione stazionaria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Telemedicine institution</div>
	 * <div class="de">Telemedizinische Einrichtung</div>
	 * <div class="fr">Institut de télémédecine</div>
	 * <div class="it">Centro di telemedicina</div>
	 * <!-- @formatter:on -->
	 */
	TELEMEDICINE_INSTITUTION("288565001", "2.16.840.1.113883.6.96", "Medical center (environment)",
			"Telemedicine institution", "Telemedizinische Einrichtung",
			"Institut de télémédecine", "Centro di telemedicina");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Accident and Emergency department</div>
	 * <div class="de">Code für Notfall-/Rettungsdienste</div>
	 * <div class="fr">Code de Service d'urgence et de sauvetage</div>
	 * <div class="it">Code per Servizio di pronto soccorso e di salvataggio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACCIDENT_AND_EMERGENCY_DEPARTMENT_CODE = "225728007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ambulatory care site</div>
	 * <div class="de">Code für Ambulante Einrichtung/Ambulatorium</div>
	 * <div class="fr">Code de Etablissement ambulatoire</div>
	 * <div class="it">Code per Struttura ambulatoriale, incl. gli studi medici</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AMBULATORY_CARE_SITE_CODE = "35971002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Client's or patient's home</div>
	 * <div class="de">Code für Domizil des Patienten</div>
	 * <div class="fr">Code de Domicile du patient</div>
	 * <div class="it">Code per Domicilio del paziente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLIENT_OR_PATIENT_HOME_CODE = "394778007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Diagnostic institution</div>
	 * <div class="de">Code für Institution für medizinische Diagnostik</div>
	 * <div class="fr">Code de Institut d’aide au diagnostic</div>
	 * <div class="it">Code per Istituto di diagnostica medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIAGNOSTIC_INSTITUTION_CODE = "722171005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General practice premises</div>
	 * <div class="de">Code für Arztpraxis</div>
	 * <div class="fr">Code de Cabinet médical</div>
	 * <div class="it">Code per Studio medico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_PRACTICE_PREMISES_CODE = "264358009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Health Authority</div>
	 * <div class="de">Code für Gesundheitsbehörde</div>
	 * <div class="fr">Code de Autorité sanitaire</div>
	 * <div class="it">Code per Autorità sanitaria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEALTH_AUTHORITY_CODE = "394747008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hospital</div>
	 * <div class="de">Code für Stationäre Einrichtung/Spital</div>
	 * <div class="fr">Code de Hôpital</div>
	 * <div class="it">Code per Ospedale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOSPITAL_CODE = "22232009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Military health institution</div>
	 * <div class="de">Code für Armeeärztliche Dienste</div>
	 * <div class="fr">Code de Service sanitaire de l'armée</div>
	 * <div class="it">Code per Servizio di medicina militare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MILITARY_HEALTH_INSTITUTION_CODE = "722172003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nursing home</div>
	 * <div class="de">Code für Pflegeheim</div>
	 * <div class="fr">Code de Etablissement médico-social</div>
	 * <div class="it">Code per Casa di cura</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NURSING_HOME_CODE = "42665001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Other Site of Care</div>
	 * <div class="de">Code für Andere Gesundheitsorganisation</div>
	 * <div class="fr">Code de Autres prestataires de soins</div>
	 * <div class="it">Code per Altre organizzazioni sanitarie</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTHER_SITE_OF_CARE_CODE = "43741000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pharmacy</div>
	 * <div class="de">Code für Apotheke</div>
	 * <div class="fr">Code de Pharmacie</div>
	 * <div class="it">Code per Farmacia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHARMACY_CODE = "264372000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prison based care site</div>
	 * <div class="de">Code für Gesundheitseinrichtung in der Haftanstalt</div>
	 * <div class="fr">Code de Service de santé en milieu carcéral</div>
	 * <div class="it">Code per Struttura sanitaria in uno stabilimento carcerario</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRISON_BASED_CARE_SITE_CODE = "722173008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Private home-based care</div>
	 * <div class="de">Code für Organisation für Pflege zu Hause</div>
	 * <div class="fr">Code de Soins à domicile</div>
	 * <div class="it">Code per Servizio di assistenza e cura a domicilio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRIVATE_HOME_BASED_CARE_CODE = "66280005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rehabilitation hospital</div>
	 * <div class="de">Code für Organisation für stationäre Rehabilitation</div>
	 * <div class="fr">Code de Réadaptation stationnaire</div>
	 * <div class="it">Code per Istituto di riabilitazione stazionaria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REHABILITATION_HOSPITAL_CODE = "80522000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Telemedicine institution</div>
	 * <div class="de">Code für Telemedizinische Einrichtung</div>
	 * <div class="fr">Code de Institut de télémédecine</div>
	 * <div class="it">Code per Centro di telemedicina</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TELEMEDICINE_INSTITUTION_CODE = "288565001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.11";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "DocumentEntry.healthcareFacilityTypeCode";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static HealthcareFacilityTypeCode getEnum(String code) {
		for (final HealthcareFacilityTypeCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
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
			Enum.valueOf(HealthcareFacilityTypeCode.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final HealthcareFacilityTypeCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Machine interpretable and (inside this class) unique code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	 * <!-- @formatter:on -->
	 */
	private String code;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 * <!-- @formatter:on -->
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
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
	HealthcareFacilityTypeCode(String code, String codeSystem, String displayName,
			String displayNameEn, String displayNameDe, String displayNameFr,
			String displayNameIt) {
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
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 * <!-- @formatter:on -->
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
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set name.</div>
	 * <div class="de">Liefert den Value Set Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
