package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Hinweis: Diese Tabelle wird jährliche durch die EKIF angepasst (siehe auch [Impfplan 2013]). eHealth Suisse wird eine jährlich aktualisierte Version dieses Value-Sets in elektronischer Form publizieren. (Quelle: Schweizerischer [Impfplan], 7.2 Erhöhtes Expositionsrisiko und/oder Übertragungsrisiko)</div>
 *<div class="fr">Remarque : Ce tableau est adapté chaque année par la CFV (cf. également [plan de vaccination suisse 2013]). eHealth Suisse publiera une version actualisée chaque année de ce Value Set au format électronique. (Source : [Plan de vaccination suisse], 7.2 Risque accru dexposition et/ou de transmission)</div>
 */
public enum RiscOfExposure {

	/**
	 * <div class="de">Beschäftigte im Gesundheitswesen</div> <div
	 * class="fr">Personnel médical et soignant</div>
	 */
	BESCHAEFTIGTE_IM_GESUNDHEITSWESEN("1", "Beschäftigte im Gesundheitswesen"),
	/**
	 * <div class="de">Enge Kontaktpersonen von Erkrankten</div> <div
	 * class="fr">Personnes en contact étroit avec des malades</div>
	 */
	ENGE_KONTAKTPERSONEN_VON_HEPATITIS_B_ERKRANKTEN("2", "Enge Kontaktpersonen von Hepatitis-B Erkrankten"),
	/**
	 * <div class="de">Erwachsene und Kinder ab 6 Jahren, die in Endemiegebieten wohnen oder sich teilweise dort aufhalten</div>
	 * <div class="fr">Adultes et enfants dès 6 ans qui résident ou séjournent temporairement dans des territoires endémiques</div>
	 */
	ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIETEN_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN("3", "Erwachsene und Kinder ab 6 Jahren, die in Endemiegebieten wohnen oder sich teilweise dort aufhalten"),
	/**
	 * <div class="de">Exponierte Tierpfleger, -händler, -seuchenpolizisten </div>
	 * <div class="fr">"Personnes exposées qui soignent des animaux, marchands d’animaux </div>
	 */
	EXPONIERTE_TIERPFLEGER_HAENDLER_SEUCHENPOLIZISTEN("4", "Exponierte Tierpfleger, -händler, -seuchenpolizisten "),
	/**
	 * <div class="de">Kontaktpersonen von kranken oder gebrechlichen Personen</div>
	 * <div class="fr">EEntourage d'une personne malade ou fragile</div>
	 */
	KONTAKTPERSONEN_VON_KRANKEN_ODER_GEBRECHLICHEN_PERSONEN("5", "Kontaktpersonen von kranken oder gebrechlichen Personen"),
	/**
	 * <div class="de">Fledermausforscher und -schützer</div> 
	 * <div class="fr">Scientifiques effectuant des recherches sur les chiroptères, protecteurs ou amateurs de chauves-souris</div>
	 */
	FLEDERMAUSFORSCHER_UND_SCHUETZER("6", "Fledermausforscher und -schützer"),
	/**
	 * <div class="de">Geistig behinderte Personen in Heimen und deren BetreuerInnen</div>
	 * <div class="fr">Personnes handicapées mentales et personnel des institutions pour handicapés mentaux</div>
	 */
	GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN("7", "Geistig behinderte Personen in Heimen und deren BetreuerInnen"),
	/**
	 * <div class="de">Hämodialysepatienten</div>
	 * <div class="fr">Personnes dialysées</div>
	 */
	HAEMODIALYSEPATIENTEN("8", "Hämodialysepatienten"),
	/**
	 * <div class="de">Hämophile Personen</div>
	 * <div class="fr">Personnes hémophiles</div>
	 */
	HAEMOPHILE_PERSONEN("9", "Hämophile Personen"),
	/**
	 * <div class="de">Kanalisationsarbeiter und Angestellte von Kläranlagen</div>
	 * <div class="fr">Travailleurs des canalisations et des stations d’épuration</div>
	 */
	KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLAERANLAGEN("10", "Kanalisationsarbeiter und Angestellte von Kläranlagen"),
	/**
	 * <div class="de">Kinder aus Ländern mit mittlerer und hoher Endemizität, die in der Schweiz leben und für einen 
	 * vorübergehenden Aufenthalt in ihr Herkunftsland zurückkehren</div>
	 * <div class="fr">Enfants originaires de pays de moyenne et haute endémicité vivant en Suisse et retournant dans
	 * leurs pays pour des séjours temporaires</div>
	 */
	KINDER_AUS_LAENDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITAET_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FUER_EINEN_VORUEBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURUECKKEHREN("11", "Kinder aus Ländern mit mittlerer und hoher Endemizität, die in der Schweiz leben und für einen vorübergehenden Aufenthalt in ihr Herkunftsland zurückkehren"),
	/**
	 * <div class="de">Konsumenten von injizierbaren Drogen und deren Kontaktpersonen</div>
	 * <div class="fr">Consommateurs de drogues injectables et personnes à leur contact</div>
	 */
	KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN("12", "Konsumenten von injizierbaren Drogen und deren Kontaktpersonen"),
	/**
	 * <div class="de">Laborpersonal mit Hepatitis A/B Expositionsrisiko</div>
	 * <div class="fr">Personnel de laboratoire susceptible d’être exposé</div>
	 */
	LABORPERSONAL_MIT_HEPATITIS_A_B_EXPOSITIONSRISIKO("13", "Laborpersonal mit Hepatitis A/B Expositionsrisiko"),
	/**
	 * <div class="de">Männer, die mit Männern Geschlechtsverkehr haben</div>
	 * <div class="fr">Hommes ayant des relations sexuelles avec d’autres hommes</div>
	 */
	MAENNER_DIE_MIT_MAENNERN_GESCHLECHTSVERKEHR_HABEN("14", "Männer, die mit Männern Geschlechtsverkehr haben"),
	/**
	 * <div class="de">Patientinnen und Patienten in Pflegeheimen und in
	 * Einrichtungen für Personen mit chronischen Erkrankungen</div> <div
	 * class="fr">Patients résidant dans une maison de soins ou dans un
	 * établissement pour malades chroniques</div>
	 */
	PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FÜR_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN("15", "Patientinnen und Patienten in Pflegeheimen und in Einrichtungen für Personen mit chronischen Erkrankungen"),
	/**
	 * <div class="de">Personen aus Ländern mit hoher oder intermediärer Hepatitis-B-Endemizität</div>
	 * <div class="fr">Personnes provenant de zones d’endémie haute ou intermédiaire pour l’hépatite B</div>
	 */
	PERSONEN_AUS_LAENDERN_MIT_HOHER_ODER_INTERMEDIAERER_HEPATITIS_B_ENDEMIZITAET("16", "Personen aus Ländern mit hoher oder intermediärer Hepatitis-B-Endemizität"),
	/**
	 * <div class="de">Personen mit einer sexuell übertragbaren Krankheit</div>
	 * <div class="fr">Personnes consultant pour une maladie sexuellement transmissible</div>
	 */
	PERSONEN_MIT_EINER_SEXUELL_UEBERTRAGBAREN_KRANKHEIT("17", "Personen mit einer sexuell übertragbaren Krankheit"),
	/**
	 * <div class="de">Personen mit engem Kontakt zu Personen aus Ländern mit hoher Endemizität</div>
	 * <div class="fr">Personnes en contact étroit avec des personnes en provenance de pays de haute endémicité</div>
	 */
	PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LAENDERN_MIT_HOHER_ENDEMIZITAET("18", "Personen mit engem Kontakt zu Personen aus Ländern mit hoher Endemizität"),
	/**
	 * <div class="de">Personen mit häufig wechselnden Sexualpartnern</div>
	 * <div class="fr">Personnes changeant souvent de partenaires sexuels</div>
	 */
	PERSONEN_MIT_HAEUFIG_WECHSELNDEN_SEXUALPARTNERN("19", "Personen mit häufig wechselnden Sexualpartnern"),
	/**
	 * <div class="de">Personen mit regelmässigem Kontakt (beruflich/familiär) zu
	 * Säuglingen < 6 Monaten, schwangere Frauen</div> <div class="fr">Personnes
	 * en contact professionnel ou familial régulier avec des nourrissons < 6
	 * mois, femmes enceintes</div>
	 */
	PERSONEN_MIT_REGELMAESSIGEM_KONTAKT_BERUFLICHFAMILIAER_ZU_SAEUGLINGEN_KLEINER_6_MONATEN_SCHWANGERE_FRAUEN("20","Personen mit regelmässigem Kontakt (beruflich/familiär) zu Säuglingen < 6 Monaten, schwangere Frauen"),
	/**
	 * <div class="de">Rekruten (Militär)</div>
	 * <div class="fr">Recrues (militaires)</div>
	 */
	REKRUTEN_MILITAER("21", "Rekruten (Militär)"),
	/**
	 * <div class="de">Sozialarbeiter, Gefängnispersonal und Polizeiangestellte mit häufigem Kontakt zu Konsumenten von
	 * injizierbaren Drogen</div>
	 * <div class="fr">Travailleurs sociaux, personnel des prisons et de la police en contact fréquent avec des
	 * consommateurs de drogues injectables</div>
	 */
	SOZIALARBEITER_GEFAENGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HAEUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN("22","Sozialarbeiter, Gefängnispersonal und Polizeiangestellte mit häufigem Kontakt zu Konsumenten von injizierbaren Drogen"),
	/**
	 * <div class="de">Tierärzte (inkl. Studenten, Praxisangestellte)</div>
	 * <div class="fr">Vétérinaires (y compris étudiants, assistants vétérinaires)</div>
	 */
	TIERAERZTE_INKL_STUDENTEN_PRAXISANGESTELLTE("23", "Tierärzte (inkl. Studenten, Praxisangestellte)"),
	/**
	 * <div class="de">Enge Kontaktpersonen von Hepatitis A-Erkrankten</div>
	 * <div class="fr">Hépatite A dans l'entourage</div>
	 */
	ENGE_KONTAKTPERSONEN_VON_HEPATITIS_A_ERKRANKTEN("24", "Enge Kontaktpersonen von Hepatitis A-Erkrankten"),
	/**
	 * <div class="de">Enge Kontaktpersonen von Meningokokken-Erkrankten</div>
	 * <div class="fr">Hépatite A dans l'entourage</div>
	 */
	ENGE_KONTAKTPERSONEN_VON_MENINGOKOKKEN_ERKRANKTEN("25", "Enge Kontaktpersonen von Meningokokken-Erkrankten"),
	/**
	 * <div class="de">Laborpersonal mit Meningokokken Expositionsrisiko</div>
	 * <div class="fr"></div>
	 */
	LABORPERSONAL_MIT_MENINGOKOKKEN_EXPOSITIONSRISIKO("26", "Laborpersonal mit Meningokokken Expositionsrisiko"),
	/**
	 * <div class="de">Laborpersonal mit Rabies Expositionsrisiko</div>
	 * <div class="fr"></div>
	 */
	LABORPERSONAL_MIT_RABIES_EXPOSITIONSRISIKO("27", "Laborpersonal mit Rabies Expositionsrisiko"),
	/**
	 * <div class="de">Kinderkrippe/Hort vor 5 Monaten</div>
	 * <div class="fr">Crèche/garderie avant 5 mois</div>
	 */
	KINDERKRIPPE_HORT_VOR_5_MONATEN("28", "Kinderkrippe/Hort vor 5 Monaten"),
	/**
	 * <div class="de">Kontaktpersonen von einer schwangeren Frau</div>
	 * <div class="fr">Entourage d'une femme enceinte</div>
	 */
	KONTAKTPERSONEN_VON_EINER_SCHWANGEREN_FRAU("29", "Kontaktpersonen von einer schwangeren Frau"),
	/**
	 * <div class="de">Mitarbeitende von Kinderkrippen</div>
	 * <div class="fr">Professionnels de la petite enfance</div>
	 */
	MITARBEITENDE_VON_KINDERKRIPPEN("30", "Mitarbeitende von Kinderkrippen"),
	/**
	 * <div class="de">Andere Expositionsrisiken</div>
	 * <div class="fr">Autres risques d’exposition</div>
	 */
	ANDERE_EXPOSITIONSRISIKEN("999", "Andere Expositionsrisiken");
	//	public static final String BESCHÄFTIGTE_IM_GESUNDHEITSWESEN_CODE = "1";
	//	public static final String ENGE_KONTAKTPERSONEN_VON_ERKRANKTEN_CODE = "2";
	//	public static final String ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIETEN_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN_CODE = "3";
	//	public static final String EXPONIERTE_TIERPFLEGER__HÄNDLER__SEUCHENPOLIZISTEN_CODE = "4";
	//	public static final String FAMILIENANGEHÖRIGE_VON_PERSONEN_MIT_EINEM_ERHÖHTEN_RISIKO_CODE = "5";
	//	public static final String FLEDERMAUSFORSCHER_UND__SCHÜTZER_CODE = "6";
	//	public static final String GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN_CODE = "7";
	//	public static final String HÄMODIALYSEPATIENTEN_CODE = "8";
	//	public static final String HÄMOPHILE_PERSONEN_CODE = "9";
	//	public static final String KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLÄRANLAGEN_CODE = "10";
	//	public static final String KINDER_AUS_LÄNDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITÄT_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FÜR_EINEN_VORÜBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURÜCKKEHREN_CODE = "11";
	//	public static final String KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN_CODE = "12";
	//	public static final String LABORPERSONAL_CODE = "13";
	//	public static final String MÄNNER_DIE_MIT_MÄNNERN_GESCHLECHTSVERKEHR_HABEN_CODE = "14";
	//	public static final String PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FÜR_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN_CODE = "15";
	//	public static final String PERSONEN_AUS_LÄNDERN_MIT_HOHER_ODER_INTERMEDIÄRER_HEPATITIS_B_ENDEMIZITÄT_CODE = "16";
	//	public static final String PERSONEN_MIT_EINER_SEXUELL_ÜBERTRAGBAREN_KRANKHEIT_CODE = "17";
	//	public static final String PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LÄNDERN_MIT_HOHER_ENDEMIZITÄT_CODE = "18";
	//	public static final String PERSONEN_MIT_HÄUFIG_WECHSELNDEN_SEXUALPARTNERN_CODE = "19";
	//	public static final String PERSONEN_MIT_REGELMÄSSIGEM_KONTAKT_BERUFLICHFAMILIÄR_ZU_SÄUGLINGEN_kleiner_6_MONATEN_SCHWANGERE_FRAUEN_CODE = "20";
	//	public static final String REKRUTEN_MILITÄR_CODE = "21";
	//	public static final String SOZIALARBEITER_GEFÄNGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HÄUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_CODE = "22";
	//	public static final String TIERÄRZTE_INKL__STUDENTEN_PRAXISANGESTELLTE_CODE = "23";
	//	public static final String ANDERE_EXPOSITIONSRISIKEN_CODE = "999";

	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.2013.2";
	public static final String CODE_SYSTEM_NAME = "DefinedByEKIFAndEHealthSuisse";

	private String code;
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display
	 * Name</div> <div class="de">Instantiiert dieses Enum Object mittels eines
	 * Codes und einem Display Name</div>
	 * 
	 * @param code
	 * <br>
	 *          <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *          <div class="de"> display name</div>
	 */
	private RiscOfExposure(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * 
	 * @param code
	 * <br>
	 *          <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static RiscOfExposure getEnum(String code) {
		for (final RiscOfExposure x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * Check if a given Code/Text concern is of type RiscOfExposure
	 *
	 * @param code The code of a concern to check
	 * @param displayName The display name of a concern
	 * @return true in case the specific code and it's display name fit an enum value
	 */
	public static boolean isRiscOfExposure(String code, String displayName) {
		final RiscOfExposure aRisc = getEnum(code);
		return aRisc == null ? false : aRisc.getDisplayName().equalsIgnoreCase(displayName);
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 * 
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCodeSystemName(CODE_SYSTEM_NAME);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>
	 * 
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
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
	 * <div class="en">Gets the actual Code as string</div> <div
	 * class="de">Liefert den eigentlichen Code als String</div>
	 * 
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 * 
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 * 
	 * 
	 * @param enumName
	 * <br>
	 *          <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden
	 * ist.</div>
	 * 
	 * @param codeValue
	 * <br>
	 *          <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (final RiscOfExposure x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}
