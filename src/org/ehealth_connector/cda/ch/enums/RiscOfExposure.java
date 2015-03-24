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
	TOTRANSLATE_1("1", "TOTRANSLATE"),
	/**
	 * <div class="de">Enge Kontaktpersonen von Erkrankten</div> <div
	 * class="fr">Personnes en contact étroit avec des malades</div>
	 */
	TOTRANSLATE_2("2", "TOTRANSLATE"),
	/**
	 * <div class="de">Erwachsene und Kinder ab 6 Jahren, die in Endemiegebieten
	 * wohnen oder sich teilweise dort aufhalten</div> <div class="fr">Adultes
	 * et enfants dès 6 ans qui résident ou séjournent temporairement dans des
	 * territoires endémiques</div>
	 */
	TOTRANSLATE_3("3", "TOTRANSLATE"),
	/**
	 * <div class="de">Exponierte Tierpfleger, -händler, -seuchenpolizisten
	 * </div> <div class="fr">"Personnes exposées qui soignent des animaux,
	 * marchands d’animaux </div>
	 */
	TOTRANSLATE_4("4", "TOTRANSLATE"),
	/**
	 * <div class="de">Familienangehörige von Personen mit einem erhöhten
	 * Risiko</div> <div class="fr">Entourage familial des personnes à risque
	 * accru de complications</div>
	 */
	TOTRANSLATE_5("5", "TOTRANSLATE"),
	/**
	 * <div class="de">Fledermausforscher und -schützer</div> <div
	 * class="fr">Scientifiques effectuant des recherches sur les chiroptères,
	 * protecteurs ou amateurs de chauves-souris</div>
	 */
	TOTRANSLATE_6("6", "TOTRANSLATE"),
	/**
	 * <div class="de">Geistig behinderte Personen in Heimen und deren
	 * BetreuerInnen</div> <div class="fr">Personnes handicapées mentales et
	 * personnel des institutions pour handicapés mentaux</div>
	 */
	TOTRANSLATE_7("7", "TOTRANSLATE"),
	/**
	 * <div class="de">Hämodialysepatienten</div> <div class="fr">Personnes
	 * dialysées</div>
	 */
	TOTRANSLATE_8("8", "TOTRANSLATE"),
	/**
	 * <div class="de">Hämophile Personen</div> <div class="fr">Personnes
	 * hémophiles</div>
	 */
	TOTRANSLATE_9("9", "TOTRANSLATE"),
	/**
	 * <div class="de">Kanalisationsarbeiter und Angestellte von
	 * Kläranlagen</div> <div class="fr">Travailleurs des canalisations et des
	 * stations d’épuration</div>
	 */
	TOTRANSLATE_10("10", "TOTRANSLATE"),
	/**
	 * <div class="de">Kinder aus Ländern mit mittlerer und hoher Endemizität,
	 * die in der Schweiz leben und für einen vorübergehenden Aufenthalt in ihr
	 * Herkunftsland zurückkehren</div> <div class="fr">Enfants originaires de
	 * pays de moyenne et haute endémicité vivant en Suisse et retournant dans
	 * leurs pays pour des séjours temporaires</div>
	 */
	TOTRANSLATE_11("11", "TOTRANSLATE"),
	/**
	 * <div class="de">Konsumenten von injizierbaren Drogen und deren
	 * Kontaktpersonen</div> <div class="fr">Consommateurs de drogues
	 * injectables et personnes à leur contact</div>
	 */
	TOTRANSLATE_12("12", "TOTRANSLATE"),
	/**
	 * <div class="de">Laborpersonal</div> <div class="fr">Personnel de
	 * laboratoire susceptible d’être exposé</div>
	 */
	TOTRANSLATE_13("13", "TOTRANSLATE"),
	/**
	 * <div class="de">Männer, die mit Männern Geschlechtsverkehr haben</div>
	 * <div class="fr">Hommes ayant des relations sexuelles avec d’autres
	 * hommes</div>
	 */
	TOTRANSLATE_14("14", "TOTRANSLATE"),
	/**
	 * <div class="de">Patientinnen und Patienten in Pflegeheimen und in
	 * Einrichtungen für Personen mit chronischen Erkrankungen</div> <div
	 * class="fr">Patients résidant dans une maison de soins ou dans un
	 * établissement pour malades chroniques</div>
	 */
	TOTRANSLATE_15("15", "TOTRANSLATE"),
	/**
	 * <div class="de">Personen aus Ländern mit hoher oder intermediärer
	 * Hepatitis-B-Endemizität</div> <div class="fr">Personnes provenant de
	 * zones d’endémie haute ou intermédiaire pour l’hépatite B</div>
	 */
	TOTRANSLATE_16("16", "TOTRANSLATE"),
	/**
	 * <div class="de">Personen mit einer sexuell übertragbaren Krankheit</div>
	 * <div class="fr">Personnes consultant pour une maladie sexuellement
	 * transmissible</div>
	 */
	TOTRANSLATE_17("17", "TOTRANSLATE"),
	/**
	 * <div class="de">Personen mit engem Kontakt zu Personen aus Ländern mit
	 * hoher Endemizität</div> <div class="fr">Personnes en contact étroit avec
	 * des personnes en provenance de pays de haute endémicité</div>
	 */
	TOTRANSLATE_18("18", "TOTRANSLATE"),
	/**
	 * <div class="de">Personen mit häufig wechselnden Sexualpartnern</div> <div
	 * class="fr">Personnes changeant souvent de partenaires sexuels</div>
	 */
	TOTRANSLATE_19("19", "TOTRANSLATE"),
	/**
	 * <div class="de">Personen mit regelmässigem Kontakt (beruflich/familiär)
	 * zu Säuglingen < 6 Monaten, schwangere Frauen</div> <div
	 * class="fr">Personnes en contact professionnel ou familial régulier avec
	 * des nourrissons < 6 mois, femmes enceintes</div>
	 */
	TOTRANSLATE_20("20", "TOTRANSLATE"),
	/**
	 * <div class="de">Rekruten (Militär)</div> <div class="fr">Recrues
	 * (militaires)</div>
	 */
	TOTRANSLATE_21("21", "TOTRANSLATE"),
	/**
	 * <div class="de">Sozialarbeiter, Gefängnispersonal und Polizeiangestellte
	 * mit häufigem Kontakt zu Konsumenten von injizierbaren Drogen</div> <div
	 * class="fr">Travailleurs sociaux, personnel des prisons et de la police en
	 * contact fréquent avec des consommateurs de drogues injectables</div>
	 */
	TOTRANSLATE_22("22", "TOTRANSLATE"),
	/**
	 * <div class="de">Tierärzte (inkl. Studenten, Praxisangestellte)</div> <div
	 * class="fr">Vétérinaires (y compris étudiants, assistants
	 * vétérinaires)</div>
	 */
	TOTRANSLATE_23("23", "TOTRANSLATE"),
	/**
	 * <div class="de">Andere Expositionsrisiken</div> <div class="fr">Autres
	 * risques d’exposition</div>
	 */
	TOTRANSLATE_24("999", "TOTRANSLATE");
	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static RiscOfExposure getEnum(String code) {
		for (RiscOfExposure x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	public static final String TOTRANSLATE_1_CODE = "1";
	public static final String TOTRANSLATE_2_CODE = "2";
	public static final String TOTRANSLATE_3_CODE = "3";
	public static final String TOTRANSLATE_4_CODE = "4";
	public static final String TOTRANSLATE_5_CODE = "5";
	public static final String TOTRANSLATE_6_CODE = "6";
	public static final String TOTRANSLATE_7_CODE = "7";
	public static final String TOTRANSLATE_8_CODE = "8";
	public static final String TOTRANSLATE_9_CODE = "9";
	public static final String TOTRANSLATE_10_CODE = "10";
	public static final String TOTRANSLATE_11_CODE = "11";
	public static final String TOTRANSLATE_12_CODE = "12";
	public static final String TOTRANSLATE_13_CODE = "13";
	public static final String TOTRANSLATE_14_CODE = "14";
	public static final String TOTRANSLATE_15_CODE = "15";
	public static final String TOTRANSLATE_16_CODE = "16";
	public static final String TOTRANSLATE_17_CODE = "17";
	public static final String TOTRANSLATE_18_CODE = "18";
	public static final String TOTRANSLATE_19_CODE = "19";
	public static final String TOTRANSLATE_20_CODE = "20";
	public static final String TOTRANSLATE_21_CODE = "21";
	public static final String TOTRANSLATE_22_CODE = "22";
	public static final String TOTRANSLATE_23_CODE = "23";

	public static final String TOTRANSLATE_24_CODE = "999";
	public static final String CODE_SYSTEM = "2.16.756.5.30.1.127.3.3.2013.2";

	public static final String CODE_SYSTEM_NAME = "Defined by EKIF und eHealth Suisse";
	private String code;

	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div>
	 */
	RiscOfExposure(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM);
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
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemId() {
		return CODE_SYSTEM;
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
	public String getdisplayName() {
		return displayName;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumStr
	 * <br>
	 *            <div class="de"> enum str</div>
	 * @return true, if is enum of value set
	 */
	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}

	/**
	 * <div class="en">Checks if a given code is in this value set.</div> <div
	 * class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden
	 * ist.</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String code) {
		for (RiscOfExposure x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}