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
import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;

/**
 * Value Set valid from 20150101 Value-Set: CDA-CH-VACD exp-risks (OID:
 * 2.16.756.5.30.1.127.3.3.2)
 */
public enum CdaChVacdExpRisks {

	/** ER_13001. */
	ER213001("213001", "Beschäftigte im Gesundheitswesen", "Personnel médical et soignant",
			"Personale medico e di cura", "20130101", ""),

	/** ER_13002. */
	ER213002("213002", "Enge Kontaktpersonen von Erkrankten",
			"Entourage familial d’une personne infectée",
			"Entourage famigliare di una persona infetta", "20130101", ""),

	/** ER_13003. */
	ER213003("213003",
			"Erwachsene und Kinder ab 6 Jahren, die in Endemiegebieten wohnen oder sich teilweise dort aufhalten",
			"Adultes et enfants dès 6 ans qui résident ou séjournent temporairement dans des territoires endémiques ",
			"Adulti e bambini a partire dai 6 anni che risiedono o soggiornano in regioni endemiche",
			"20130101", ""),

	/** ER_13004. */
	ER213004("213004", "Tierpfleger, -händler, -seuchenpolizisten",
			"Personnes exposées qui soignent des animaux, marchands d’animaux : personnel engagé dans la lutte contre les épizooties",
			"Persone esposte che curano animali, commercianti di animali, personale impiegato nella lotta contro le epizoozie",
			"20130101", ""),

	/** ER_13005. */
	ER213005("213005", "Familienangehörige von Personen mit einem erhöhten Risiko",
			"Entourage familial des personnes à risque accru de complications",
			"Entourage famigliare di persone a maggiore rischio di complicazioni", "20130101", ""),

	/** ER_13006. */
	ER213006("213006", "Fledermausforscher und -schützer",
			"Scientifiques effectuant des recherches sur les chiroptères, protecteurs ou amateurs de chauves-souris",
			"Ricercatori che svolgono ricerche sui chirotteri, protettori o appassionati di pipistrelli",
			"20130101", ""),

	/** ER_13007. */
	ER213007("213007", "Geistig behinderte Personen in Heimen und deren BetreuerInnen",
			"Personnes handicapées mentales et personnel des institutions pour handicapés mentaux ",
			"Persone disabili mentali e personale degli istituti per disabili mentali", "20130101",
			""),

	/** ER_13008. */
	ER213008("213008", "Hämodialysepatienten", "Personnes dialysées", "Persone in dialisi",
			"20130101", ""),

	/** ER_13009. */
	ER213009("213009", "Hämophile Personen", "Personnes hémophiles", "Persone affette da emofilia",
			"20130101", ""),

	/** ER_13010. */
	ER213010("213010", "Kanalisationsarbeiter und Angestellte von Kläranlagen",
			"Travailleurs des canalisations et des stations d’épuration",
			"Personale addetto alla manutenzione delle fognature e delle stazioni di depurazione",
			"20130101", ""),

	/** ER_13011. */
	ER213011("213011",
			"Kinder aus Ländern mit mittlerer und hoher Endemizität, die in der Schweiz leben und für einen vorübergehenden Aufenthalt in ihr Herkunftsland zurückkehren",
			"Enfants originaires de pays de moyenne et haute endémicité vivant en Suisse et retournant dans leurs pays pour des séjours temporaires",
			"Bambini originari di paesi di media ed elevata endemicità che vivono in Svizzera e che ritornano nel loro paese per dei soggiorni temporanei",
			"20130101", ""),

	/** ER_13012. */
	ER213012("213012", "Konsumenten von injizierbaren Drogen und deren Kontaktpersonen",
			"Consommateurs de drogues injectables et personnes à leur contact",
			"Consumatori di droghe iniettabili e persone a loro contatto", "20130101", ""),

	/** ER_13013. */
	ER213013("213013", "Laborpersonal", "Personnel de laboratoire susceptible d’être exposé",
			"Personale di laboratorio suscettibile di essere esposto", "20130101", ""),

	/** ER_13014. */
	ER213014("213014", "Männer, die mit Männern Geschlechtsverkehr haben",
			"Hommes ayant des relations sexuelles avec d’autres hommes",
			"Uomini che hanno rapporti sessuali con altri uomini", "20130101", ""),

	/** ER_13015. */
	ER213015("213015",
			"Patientinnen und Patienten in Pflegeheimen und in Einrichtungen für Personen mit chronischen Erkrankungen",
			"Patients résidant dans une maison de soins ou dans un établissement pour malades chroniques",
			"Ospiti di una casa di cura o di un istituto per malati cronici", "20130101", ""),

	/** ER_13016. */
	ER213016("213016", "Personen aus Ländern mit hoher oder intermediärer Hepatitis-B-Endemizität",
			"Personnes provenant de zones d’endémie haute ou intermédiaire pour l’hépatite B",
			"Persone provenienti da zone di endemicità elevata o intermedia per l’epatite B",
			"20130101", ""),

	/** ER_13017. */
	ER213017("213017", "Personen mit einer sexuell übertragbaren Krankheit",
			"Personnes consultant pour une maladie sexuellement transmissible",
			"Persone che consultano per una malattia sessualmente trasmissibile", "20130101", ""),

	/** ER_13018. */
	ER213018("213018", "Personen mit engem Kontakt zu Personen aus Ländern mit hoher Endemizität",
			"Personnes en contact étroit avec des personnes en provenance de pays de haute endémicité",
			"Persone a stretto contatto con delle persone provenienti da paesi di endemicità elevata",
			"20130101", ""),

	/** ER_13019. */
	ER213019("213019", "Personen mit häufig wechselnden Sexualpartnern",
			"Personnes changeant souvent de partenaires sexuels",
			"Persone che cambiano spesso partner sessuale", "20130101", ""),

	/** ER_13020. */
	ER213020("213020",
			"Personen mit regelmässigem Kontakt (beruflich / familiär) zu Säuglingen &lt; 6 Monaten, schwangere Frauen",
			"Personnes en contact professionnel ou familial régulier avec des nourrissons &lt; 6 mois, femmes enceintes",
			"Personale in contatto professionale o famigliare con dei lattanti di meno di 6 mesi o con donne incinte",
			"20130101", ""),

	/** ER_13021. */
	ER213021("213021", "Rekruten (Militär)", "Recrues (militaires)", "Reclute (militari)",
			"20130101", ""),

	/** ER_13022. */
	ER213022("213022",
			"Sozialarbeiter, Gefängnispersonal und Polizeiangestellte mit häufigem Kontakt zu Konsumenten von injizierbaren Drogen",
			"Travailleurs sociaux, personnel des prisons et de la police en contact fréquent avec des consommateurs de drogues injectables",
			"Lavoratori nel campo socio-educativo o della sicurezza (carceri, polizia) a contatto frequente con dei consumatori di droghe iniettabili",
			"20130101", ""),

	/** ER_13023. */
	ER213023("213023", "Tierärzte (inkl. Studenten, Praxisangestellte)",
			"Vétérinaires (étudiants : assistants vétérinaires)",
			"Veterinari (studenti, assistenti veterinari)", "20130101", "");

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.2";

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "CDA-CH-VACD exp-risks";

	/** The code. */
	private String code;

	/** The display name. */
	private String displayNameDe;

	/** The display name. */
	private String displayNameFr;

	/** The display name. */
	private String displayNameIt;

	/** The valid from Date. */
	private Date validFrom;

	/** The valid to Date. */
	private Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantsiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 * @param validFrom
	 *            the valid from
	 * @param validTo
	 *            the valid to
	 */
	private CdaChVacdExpRisks(String code, String displayNameDe, String displayNameFr,
			String displayNameIt, String validFrom, String validTo) {
		this.code = code;
		this.displayNameDe = displayNameDe;
		this.displayNameFr = displayNameFr;
		this.displayNameIt = displayNameIt;
		if (validFrom != null && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if (validTo != null && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static CdaChVacdExpRisks getEnum(String code) {
		for (CdaChVacdExpRisks x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>.
	 *
	 * @param languageCode
	 *            the language code
	 * @return <div class="en">the code</div>
	 */
	public Code getCode(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null) {
			switch (languageCode) {
			case GERMAN:
				displayName = displayNameDe;
				break;
			case FRENCH:
				displayName = displayNameFr;
				break;
			case ITALIAN:
				displayName = displayNameIt;
				break;
			}
		}
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
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
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
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
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 * 
	 * 
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets
	 * vorhanden ist.</div>
	 * 
	 * @param codeValue
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (CdaChVacdExpRisks x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
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
	 *            the date
	 * @return true, if is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if (this.validFrom != null && validFrom.after(date)) {
			return false;
		}
		if (this.validTo != null && validTo.before(date)) {
			return false;
		}
		return true;
	}

}