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
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.enums;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * Risk of Expsoure Enumerations for immunizations Value Set valid from 20150101
 * Value-Set: CDA-CH-VACD exp-risks (OID: 2.16.756.5.30.1.127.3.3.2)
 */
public enum RiskOfExposure {

	/**
	 * <div class="de">Beschäftigte im Gesundheitswesen</div>
	 * <div class="fr">Personnel médical et soignant</div>
	 * <div class="it">Personale medico e di cura</div>
	 */
	BESCHAEFTIGTE_IM_GESUNDHEITSWESEN("213001", "Beschäftigte im Gesundheitswesen", "Personnel médical et soignant", "Personale medico e di cura", "20130101", ""),
	/**
	 * <div class="de">Enge Kontaktpersonen von Meningokokken-Erkrankten</div>
	 * <div class="fr">Méningocoques dans l'entourage</div>
	 * <div class="it">Meningococco nell'entourage </div>
	 */
	ENGE_KONTAKTPERSONEN_VON_MENINGOKOKKEN_ERKRANKTEN("213028", "enge Kontaktpersonen von Meningokokken-Erkrankten", "Méningocoques dans l'entourage", "Meningococco nell'entourage", "20150101", ""),
	/**
	 * <div class="de">Erwachsene und Kinder ab 6 Jahren, die in Endemiegebieten
	 * wohnen oder sich teilweise dort aufhalten</div> <div class="fr">Adultes et
	 * enfants dès 6 ans qui résident ou séjournent temporairement dans des
	 * territoires endémiques</div> <div class="it">Adulti e bambini a partire dai
	 * 6 anni che risiedono o soggiornano in regioni endemiche</div>
	 */
	ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIET_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN("213003", "Erwachsene und Kinder ab 6 Jahren, die in Endemiegebieten wohnen oder sich teilweise dort aufhalten", "Adultes et enfants dès 6 ans qui résident ou séjournent temporairement dans des territoires endémiques ", "Adulti e bambini a partire dai 6 anni che risiedono o soggiornano in regioni endemiche", "20130101", ""),
	/**
	 * <div class="de">Familienangehörige von Personen mit einem erhöhten
	 * Risiko</div> <div class="fr">Entourage familial des personnes à risque
	 * accru de complications</div> <div class="it">Entourage famigliare di
	 * persone a maggiore rischio di complicazioni</div>
	 */
	FAMILIENANGEHOERIGE_VON_PERSONEN_MIT_EINEM_ERHOEHTEN_RISIKO("213005", "Familienangehörige von Personen mit einem erhöhten Risiko", "Entourage familial des personnes à risque accru de complications", "Entourage famigliare di persone a maggiore rischio di complicazioni", "20130101", ""),
	/**
	 * <div class="de">Fledermausforscher und -schützer</div>
	 * <div class="fr">Scientifiques effectuant des recherches sur les
	 * chiroptères, protecteurs ou amateurs de chauves-souris</div>
	 * <div class="it">Ricercatori che svolgono ricerche sui chirotteri,
	 * protettori o appassionati di pipistrelli</div>
	 */
	FLEDERMAUSFORSCHER_UND_SCHUETZER("213006", "Fledermausforscher und -schützer", "Scientifiques effectuant des recherches sur les chiroptères, protecteurs ou amateurs de chauves-souris", "Ricercatori che svolgono ricerche sui chirotteri, protettori o appassionati di pipistrelli", "20130101", ""),
	/**
	 * <div class="de">Geistig behinderte Personen in Heimen und deren
	 * BetreuerInnen</div> <div class="fr">Personnes handicapées mentales et
	 * personnel des institutions pour handicapés mentaux </div>
	 * <div class="it">Persone disabili mentali e personale degli istituti per
	 * disabili mentali</div>
	 */
	GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN("213007", "Geistig behinderte Personen in Heimen und deren BetreuerInnen", "Personnes handicapées mentales et personnel des institutions pour handicapés mentaux ", "Persone disabili mentali e personale degli istituti per disabili mentali", "20130101", ""),
	/**
	 * <div class="de">Kanalisationsarbeiter und Angestellte von Kläranlagen</div>
	 * <div class="fr">Travailleurs des canalisationset des stations
	 * d’épuration</div> <div class="it">Personale addetto alla manutenzione delle
	 * fognature e delle stazioni di depurazione</div>
	 */
	KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLAERANLAGEN("213010", "Kanalisationsarbeiter und Angestellte von Kläranlagen", "Travailleurs des canalisations et des stations d’épuration", "Personale addetto alla manutenzione delle fognature e delle stazioni di depurazione", "20130101", ""),
	/**
	 * <div class="de">Kinder aus Ländern mit mittlerer und hoher Endemizität, die
	 * in der Schweiz leben und für einen vorübergehenden Aufenthalt in ihr
	 * Herkunftsland zurückkehren</div> <div class="fr">Enfants originaires de
	 * pays de moyenne et haute endémicité vivant en Suisse et retournant dans
	 * leurs pays pour des séjours temporaires</div> <div class="it">Bambini
	 * originari di paesi di media ed elevata endemicità che vivono in Svizzera e
	 * che ritornano nel loro paese per dei soggiorni temporanei</div>
	 */
	KINDER_AUS_LAENDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITAET_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FUER_EINEN_VORUEBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURUECKKEHREN("213011", "Kinder aus Ländern mit mittlerer und hoher Endemizität, die in der Schweiz leben und für einen vorübergehenden Aufenthalt in ihr Herkunftsland zurückkehren", "Enfants originaires de pays de moyenne et haute endémicité vivant en Suisse et retournant dans leurs pays pour des séjours temporaires", "Bambini originari di paesi di media ed elevata endemicità che vivono in Svizzera e che ritornano nel loro paese per dei soggiorni temporanei", "20130101", ""),
	/**
	 * <div class="de">Kinderkrippe / Hort vor 5 Monaten</div>
	 * <div class="fr">Crèche / garderie avant 5 mois </div> <div class="it">Asilo
	 * nido prima di 5 mesi</div>
	 */
	KINDERKRIPPE_HORT_VOR_5_MONATEN("213031", "Kinderkrippe/Hort vor 5 Monaten", "Crèche/garderie avant 5 mois", "Asilo nido prima di 5 mesi", "20150101", ""),
	/**
	 * <div class="de">Konsumenten von injizierbaren Drogen und deren
	 * Kontaktpersonen</div> <div class="fr">Consommateurs de drogues injectables
	 * et personnes à leur contact</div> <div class="it">Consumatori di droghe
	 * iniettabili e persone a loro contatto</div>
	 */
	KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN("213012", "Konsumenten von injizierbaren Drogen und deren Kontaktpersonen", "Consommateurs de drogues injectables et personnes à leur contact", "Consumatori di droghe iniettabili e persone a loro contatto", "20130101", ""),
	/**
	 * <div class="de">Kontaktpersonen von einer schwangeren Frau</div>
	 * <div class="fr">Entourage d ' une femme enceinte </div>
	 * <div class="it">Entourage di una donna incinta </div>
	 */
	KONTAKTPERSONEN_VON_EINER_SCHWANGEREN_FRAU("213032", "Kontaktpersonen von einer schwangeren Frau", "Entourage d'une femme enceinte", "Entourage di una donna incinta", "20150101", ""),
	/**
	 * <div class="de">Kontaktpersonen von Hepatitis-A-Erkrankten</div>
	 * <div class="fr">Hépatite A dans l'entourage</div> <div class="it">Epatite A
	 * nell'entourage </div>
	 */
	KONTAKTPERSONEN_VON_HEPATITIS_A_ERKRANKTEN("213027", "Kontaktpersonen von Hepatitis-A-Erkrankten", "Hépatite A dans l'entourage", "Epatite A nell'entourage", "20150101", ""),
	/**
	 * <div class="de">Kontaktpersonen von Hepatitis-B-Erkrankten</div>
	 * <div class="fr">Hépatite B dans l'entourage</div> <div class="it">Epatite B
	 * nell'entourage </div>
	 */
	KONTAKTPERSONEN_VON_HEPATITIS_B_ERKRANKTEN("213026", "Kontaktpersonen von Hepatitis-B-Erkrankten", "Hépatite B dans l'entourage", "Epatite B nell'entourage", "20150101", ""),
	/**
	 * <div class="de">Laborpersonal mit Bakterien-Expositionsrisiko</div>
	 * <div class="fr">Personnel de laboratoire exposé aux bactéries</div>
	 * <div class="it">Personale di laboratorio esposto ai batteri</div>
	 */
	LABORPERSONAL_MIT_BAKTERIEN_EXPOSITIONSRISIKO("213030", "Laborpersonal mit Bakterien-Expositionsrisiko", "Personnel de laboratoire exposé aux bactéries", "Personale di laboratorio esposto ai batteri", "20150101", ""),
	/**
	 * <div class="de">Laborpersonal mit Virus-Expositionsrisiko</div>
	 * <div class="fr">Personnel de laboratoire exposé aux virus</div>
	 * <div class="it">Personale di laboratorio esposto ai virus</div>
	 */
	LABORPERSONAL_MIT_VIRUS_EXPOSITIONSRISIKO("213029", "Laborpersonal mit Virus-Expositionsrisiko", "Personnel de laboratoire exposé aux virus", "Personale di laboratorio esposto ai virus", "20150101", ""),
	/**
	 * <div class="de">Männer, die mit Männern Geschlechtsverkehr haben</div>
	 * <div class="fr">Hommes ayant des relations sexuelles avec d’autres
	 * hommes</div> <div class="it">Uomini che hanno rapporti sessuali con altri
	 * uomini</div>
	 */
	MAENNER_DIE_MIT_MAENNERN_GESCHLECHTSVERKEHR_HABEN("213014", "Männer, die mit Männern Geschlechtsverkehr haben", "Hommes ayant des relations sexuelles avec d’autres hommes", "Uomini che hanno rapporti sessuali con altri uomini", "20130101", ""),
	/**
	 * <div class="de">Mitarbeitende von Kinderkrippen</div>
	 * <div class="fr">Professionnels de la petite enfance</div>
	 * <div class="it">Professionisti della prima infanzia</div>
	 */
	MITARBEITENDE_VON_KINDERKRIPPEN("213033", "Mitarbeitende von Kinderkrippen", "Professionnels de la petite enfance", "Professionisti della prima infanzia", "20150101", ""),
	/**
	 * <div class="de">Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit
	 * hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren
	 * (in ihrem ersten Lebensjahr ) </div> <div class="fr">Nouveau - nés ou
	 * nourrissons &lt; 12 mois originaire d’un pays à haute endémie et
	 * susceptibles d’y retourner dans leur 1ère année de vie </div>
	 * <div class="it">Neonati o lattanti &lt; 12 mesi originari di un paese a
	 * elevata endemia e suscettibili di ritornarci nel loro primo anno di
	 * vita </div>
	 */
	NEUGEBORENE_UND_SAEUGLINGE_UNTER_12_MONATEN_AUS_LAENDERN_MIT_HOHER_TUBERKULOSE_PRAEVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURUECKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR("213024", "Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren (in ihrem ersten Lebensjahr)", "Nouveau-nés ou nourrissons < 12 mois originaire d’un pays à haute endémie et susceptibles d’y retourner dans leur 1ère année de vie", "Neonati o lattanti < 12 mesi originari di un paese a elevata endemia e suscettibili di ritornarci nel loro primo anno di vita ", "20150101", ""),
	/**
	 * <div class="de">Neugeborene von HBsAg-positiven Müttern </div>
	 * <div class="fr">Nouveau-nés de mères HBsAg positives</div>
	 * <div class="it">Neonati di madri HBsAg positive </div>
	 */
	NEUGEBORENE_VON_HBSAG_POSITIVEN_MUETTERN("213025", "Neugeborene von HBsAg-positiven Müttern", "Nouveau-nés de mères HBsAg positives", "Neonati di madri HBsAg positive", "20150101", ""),
	/**
	 * <div class="de">Patientinnen und Patienten in Pflegeheimen und in
	 * Einrichtungen für Personen mit chronischen Erkrankungen </div>
	 * <div class="fr">Patients résidant dans une maison de soins ou dans un
	 * établissement pour malades chroniques</div> <div class="it">Ospiti di una
	 * casa di cura o di un istituto per malati cronici</div>
	 */
	PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FUER_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN("213015", "Patientinnen und Patienten in Pflegeheimen und in Einrichtungen für Personen mit chronischen Erkrankungen", "Patients résidant dans une maison de soins ou dans un établissement pour malades chroniques", "Ospiti di una casa di cura o di un istituto per malati cronici", "20130101", ""),
	/**
	 * <div class="de">Personen aus Ländern mit hoher oder intermediärer
	 * Hepatitis-B-Endemizität</div> <div class="fr">Personnes provenant de zones
	 * d’endémie haute ou intermédiaire pour l’hépatite B</div>
	 * <div class="it">Persone provenienti da zone di endemicità elevata o
	 * intermedia per l’ epatite B</div>
	 */
	PERSONEN_AUS_LAENDERN_MIT_HOHER_ODER_INTERMEDIAERER_HEPATITIS_B_ENDEMIZITAET("213016", "Personen aus Ländern mit hoher oder intermediärer Hepatitis-B-Endemizität", "Personnes provenant de zones d’endémie haute ou intermédiaire pour l’hépatite B", "Persone provenienti da zone di endemicità elevata o intermedia per l’epatite B", "20130101", ""),
	/**
	 * <div class="de">Personen mit einer sexuell übertragbaren Krankheit</div>
	 * <div class="fr">Personnes consultant pour une maladie sexuellement
	 * transmissible</div> <div class="it">Persone che consultano per una malattia
	 * sessualmente trasmissibile</div>
	 */
	PERSONEN_MIT_EINER_SEXUELL_UEBERTRAGBAREN_KRANKHEIT("213017", "Personen mit einer sexuell übertragbaren Krankheit", "Personnes consultant pour une maladie sexuellement transmissible", "Persone che consultano per una malattia sessualmente trasmissibile", "20130101", ""),
	/**
	 * <div class="de">Personen mit engem Kontakt zu Personen aus Ländern mit
	 * hoher Endemizität</div> <div class="fr">Personnes en contact étroit avec
	 * des personnes en provenance de pays de haute endémicité</div>
	 * <div class="it">Persone a stretto contatto con delle persone provenienti da
	 * paesi di endemicità elevata</div>
	 */
	PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LAENDERN_MIT_HOHER_ENDEMIZITAET("213018", "Personen mit engem Kontakt zu Personen aus Ländern mit hoher Endemizität", "Personnes en contact étroit avec des personnes en provenance de pays de haute endémicité", "Persone a stretto contatto con delle persone provenienti da paesi di endemicità elevata", "20130101", ""),
	/**
	 * <div class="de">Personen mit häufig wechselnden Sexualpartnern</div>
	 * <div class="fr">Personnes changeant souvent de partenaires sexuels</div>
	 * <div class="it">Persone che cambiano spesso partner sessuale</div>
	 */
	PERSONEN_MIT_HAEUFIG_WECHSELNDEN_SEXUALPARTNERN("213019", "Personen mit häufig wechselnden Sexualpartnern", "Personnes changeant souvent de partenaires sexuels", "Persone che cambiano spesso partner sessuale", "20130101", ""),
	/**
	 * <div class="de">Personen mit regelmässigem Kontakt (beruflich / familiär)
	 * zu Säuglingen &lt; 6 Monaten, schwangere Frauen </div>
	 * <div class="fr">Personnes en contact professionnel ou familial régulier
	 * avec des nourrissons &lt; 6 mois, femmes enceintes </div>
	 * <div class="it">Personale in contatto professionale o famigliare con dei
	 * lattanti di meno di 6 mesi o con donne incinte </div>
	 */
	PERSONEN_MIT_REGELMAESSIGEM_KONTAKT_BERUFLICH_ODER_FAMILIAER_ZU_SAEUGLINGEN_UNTER_6_MONATEN_ODER_SCHWANGERE_FRAUEN("213020", "Personen mit regelmässigem Kontakt (beruflich / familiär) zu Säuglingen &lt; 6 Monaten, schwangere Frauen", "Personnes en contact professionnel ou familial régulier avec des nourrissons &lt; 6 mois, femmes enceintes", "Personale in contatto professionale o famigliare con dei lattanti di meno di 6 mesi o con donne incinte", "20130101", ""),
	/**
	 * <div class="de">Rekruten (Militär)</div> <div class="fr">Recrues
	 * (militaires)</div> <div class="it">Reclute (militari)</div>
	 */
	REKRUTEN_MILITAER("213021", "Rekruten (Militär)", "Recrues (militaires)", "Reclute (militari)", "20130101", ""),
	/**
	 * <div class="de">Sozialarbeiter, Gefängnispersonal und Polizeiangestellte
	 * mit häufigem Kontakt zu Konsumenten von injizierbaren Drogen</div>
	 * <div class="fr">Travailleurs sociaux, personnel des prisons et de la police
	 * en contact fréquent avec des consommateurs de drogues injectables</div>
	 * <div class="it">Lavoratori nel campo socio - educativo o della sicurezza
	 * (carceri, polizia) a contatto frequente con dei consumatori di droghe
	 * iniettabili</div>
	 */
	SOZIALARBEITER_GEFAENGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HAEUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN("213022", "Sozialarbeiter, Gefängnispersonal und Polizeiangestellte mit häufigem Kontakt zu Konsumenten von injizierbaren Drogen", "Travailleurs sociaux, personnel des prisons et de la police en contact fréquent avec des consommateurs de drogues injectables", "Lavoratori nel campo socio-educativo o della sicurezza (carceri, polizia) a contatto frequente con dei consumatori di droghe iniettabili", "20130101", ""),
	/**
	 * <div class="de">Tierärzte (inkl. Studenten, Praxisangestellte)</div>
	 * <div class="fr">Vétérinaires (étudiants : assistants vétérinaires)</div>
	 * <div class="it">Veterinari (studenti, assistenti veterinari)</div>
	 */
	TIERAERZTE_INKL_STUDENTEN_PRAXISANGESTELLTE("213023", "Tierärzte (inkl. Studenten, Praxisangestellte)", "Vétérinaires (étudiants : assistants vétérinaires)", "Veterinari (studenti, assistenti veterinari)", "20130101", "");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "CDA-CH-VACD exp-risks";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.2";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 *
	 * @param code
	 *          <br>
	 *          <div class="de">code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static RiskOfExposure getEnum(String code) {
		for (final RiskOfExposure x : values()) {
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
	 *          <br>
	 *          <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(RiskOfExposure.class, enumName);
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
	 *          <div class="de">code</div>
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (RiskOfExposure x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/** The code. */
	private String code;

	/** The display names per language */
	private Map<LanguageCode, String> displayNames;

	/** The Code valid from. */
	private Date validFrom;

	/** The Code valid to. */
	private Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display
	 * Name</div> <div class="de">Instantsiert dieses Enum Object mittels eines
	 * Codes und einem Display Name</div>.
	 *
	 * @param code
	 *          <br>
	 *          <div class="de">code</div>
	 * @param displayNameDe
	 *          the display name de
	 * @param displayNameFr
	 *          the display name fr
	 * @param displayNameIt
	 *          the display name it
	 * @param validFrom
	 *          the valid from
	 * @param validTo
	 *          the valid to
	 */
	private RiskOfExposure(String code, String displayNameDe, String displayNameFr,
			String displayNameIt, String validFrom, String validTo) {
		this.code = code;

		displayNames = new HashMap<>();
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);

		if (validFrom != null && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if (validTo != null && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>.
	 *
	 * @param languageCode
	 *          the language code
	 * @return <div class="en">the code</div>
	 */
	public Code getCode(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null && displayNames.get(languageCode) != null) {
			displayName = displayNames.get(languageCode);
		} else {
			displayName = displayNames.get(LanguageCode.GERMAN);
		}
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert die
	 * code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the display name defined by the language param. If
	 * language is unknow, german name is returned</div> <div class="de">Liefert
	 * display name gemäss Parameter, falls die Sprache unbekannt ist, wird
	 * standartmässig deutsch geliefert.</div>@param <div class="en">The language
	 * code.</div>
	 *
	 *
	 * @param languageCode
	 *          the language code to get the display name for @return returns the
	 *          display name in the desired language. if language not found,
	 *          display name in german will returned
	 *
	 * @return <div class="en">the display name in the defined language</div>
	 */
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null && displayNames.get(languageCode) != null) {
			displayName = displayNames.get(languageCode);
		} else {
			displayName = displayNames.get(LanguageCode.GERMAN);
		}
		return displayName;
	}

	/**
	 * Checks if the code is valid now.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return isValid(null);
	}

	/**
	 * Checks if the code is valid for the specified date
	 *
	 * @param date
	 *          the date
	 * @return true, if is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if (validFrom != null && validFrom.after(date)) {
			return false;
		}
		if (validTo != null && validTo.before(date)) {
			return false;
		}
		return true;
	}
}
