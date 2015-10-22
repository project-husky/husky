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
 * Value Set valid from 20150101 Value-Set: CDA-CH-VACD copml-risks (OID:
 * 2.16.756.5.30.1.127.3.3.1)
 */
public enum CdaChVacdComplRisks {

	/** CR113001. */
	CR113001("113001", "Anatomische oder funktionelle Asplenie",
			"Asplénie anatomique ou fonctionnelle", "Asplenia anatomica o funzionale", "20130101",
			""),

	/** CR113002. */
	CR113002("113002", "Cochleaimplantat, in situ oder geplant",
			"Implant cochléaire, in situ ou planifié", "Impianto cocleare, in situ o pianificato",
			"20130101", ""),

	/** CR113003. */
	@Deprecated CR113003("113003",
			"Defekte bei der Komplementaktivierung des alternativen Wegs oder Defizite der Terminalfaktoren des Komplementsystems",
			"Déficit en facteurs de la voie alterne ou terminale du complément",
			"Deficit di fattori della via alterna o terminale del complemento", "20130101",
			"20131231"),

	/** CR113004. */
	CR113004("113004", "Geburt vor der 33. Schwangerschaftswoche oder Geburtsgewicht < 1500g",
			"Naissance avant la 33e semaine de grossesse ou poids de naissance <1500 g",
			"Nascita prima della 33a settimana di gravidanza o peso alla nascita <1500 g",
			"20130101", ""),

	/** CR113005. */
	@Deprecated CR113005("113005", "Hämoglobinopathie", "Hémoglobinopathie", "Emoglobinopatie",
			"20130101", "20131231"),

	/** CR113006. */
	@Deprecated CR113006("113006", "Hepatopathien (chronische)", "Hépatopathies chroniques",
			"Epatopatie croniche", "20130101", "20131231"),

	/** CR113007. */
	@Deprecated CR113007("113007", "Herzkrankheiten (chronische, kongenitale Missbildungen)",
			"Cardiopathies chroniques, malformations congénitales",
			"Cardiopatie croniche, malformazioni congenite", "20130101", "20131231"),

	/** CR113008. */
	CR113008("113008", "HIV Infektion mit CD4-Zellen >= 15 % (Erwachsene: >= 200 / µl)",
			" Infection à VIH avec CD4 >= 15% (Adultes : >= 200 / µl)",
			"Infezione HIV con CD4 >= 15% (Adulti : >= 200 / µl)", "20130101", ""),

	/** CR113009. */
	CR113009("113009", "HIV Infektion mit CD4-Zellen < 15 % (Erwachsene: < 200 / µl)",
			"Infection à VIH avec CD4 < 15% (Adultes : < 200 / µl)",
			"Infezione HIV con CD4 < 15% (Adulti : < 200 / µl)", "20130101", ""),

	/** CR113010. */
	@Deprecated CR113010("113010",
			"Immuninsuffizienz jeder Art (medikamentös, Transplantation, chron. Erkrankungen)",
			"Immunodéficiences (toutes situations) y. c. immunosuppression, immunosuppression médicamenteuse (transplantation, maladies chroniques) ",
			"Immunodeficienze (tutte le situazioni) compreso immunosoppressione e immunosoppressione medicamentosa (trapianto, malattie croniche)",
			"20130101", "20131231"),

	/** CR113011. */
	@Deprecated CR113011("113011",
			"Kongenitales Immunmangelsyndrom (mangelnde Immunantwort auf Polysaccharide, Antikörpermangel)",
			"Immunodéficience congénitale (défaut de réponses aux polysaccharides, déficiences en anticorps)",
			"Immunodeficienza congenita (difetto di risposta ai polisaccaridi, deficienze in anticorpi)",
			"20130101", "20131231"),

	/** CR113012. */
	CR113012("113012", "Lymphom, Leukämie, Myelom", "Lymphome, leucémie, myélome",
			"Linfoma, leucemia, mieloma", "20130101", ""),

	/** CR113013. */
	@Deprecated CR113013("113013", "Liquorfistel", "Fistule de LCR", "Fistola di LCR", "20130101",
			"20131231"),

	/** CR113014. */
	CR113014("113014", "Mangel an Mannose-bindendem Lektin", "Déficit en lectine liant le mannose",
			"Deficit di lectina legante il mannosio", "20130101", ""),

	/** CR113015. */
	@Deprecated CR113015("113015",
			"Metabolische Erkrankungen mit Auswirkungen auf Herz, Lungen, Nieren und/oder Immunsystem (Diabetes, morbide Adipositas BMI >= 40 )",
			"Maladies métaboliques chroniques affectant coeur, poumons et/ou défenses immunitaires (diabète, obésité morbide IMC >= 40)",
			"Malattie metaboliche croniche che colpiscono cuore, polmoni e/o difese immunitarie (diabete, obesità patologica con BMI >= 40) ",
			"20130101", "20131231"),

	/** CR113016. */
	@Deprecated CR113016("113016", "Missbildungen der Schädelbasis",
			"Malformations de la base du crâne", "Malformazioni della base del cranio", "20130101",
			"20131231"),

	/** CR113017. */
	@Deprecated CR113017("113017", "Myelome", "Myélome", "Mieloma", "20130101", "20131231"),

	/** CR113018. */
	CR113018("113018", "Nephrotisches Syndrom", "Syndrome néphrotique", "Sindrome nefrosica",
			"20130101", ""),

	/** CR113019. */
	@Deprecated CR113019("113019",
			"Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren (in ihrem ersten Lebensjahr)",
			"Nouveau-nés ou nourrissons < 12 mois originaire d’un pays à haute endémie et susceptibles d’y retourner dans leur 1ère année de vie",
			"Neonati o lattanti < 12 mesi originari di un paese a elevata endemia e suscettibili di ritornarci nel loro primo anno di vita ",
			"20130101", "20131231"),

	/** CR113020. */
	@Deprecated CR113020("113020", "Neugeborene von HBsAg-positiven Müttern",
			"Nouveau-nés de mères HBsAg positives", "Neonati di madri HBsAg positive", "20130101",
			"20131231"),

	/** CR113021. */
	CR113021("113021", "Schwere Neurodermitis beim Kind", "Eczema sévère chez l’enfant",
			"Eczema severo nel bambino", "20130101", ""),

	/** CR113022. */
	@Deprecated CR113022("113022",
			"Neurologische oder muskuloskelettale Erkrankung mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren",
			"Affection neurologique ou musculo-squelettique avec répercussion sur la fonction cardiaque, pulmonaire ou rénale",
			"Affezione neurologica o muscolo-scheletrica con ripercussioni sulla funzione cardiaca, polmonare o renale",
			"20130101", "20131231"),

	/** CR113023. */
	CR113023("113023", "Niereninsuffizienz", "Insuffisance rénale", "Insufficienza renale",
			"20130101", ""),

	/** CR113024. */
	@Deprecated CR113024("113024", "Pneumopathien (chronische)", "Pneumopathies chroniques",
			"Pneumopatie croniche", "20130101", "20131231"),

	/** CR113025. */
	@Deprecated CR113025("113025",
			"Schwangere Frauen und Frauen, die in den letzten 4 Wochen entbunden haben ",
			"Femmes enceintes ou ayant accouchées au cours des 4 semaines précédentes",
			"Donne incite o che hanno partorito nelle 4 settimane precedenti", "20130101",
			"20131231"),

	/** CR114001. */
	CR114001("114001", "Herzinsuffizienz", "Insuffisance cardiaque", "Insufficienza cardiaca",
			"20140101", ""),

	/** CR114002. */
	CR114002("114002", "Kardiopathie, angeborene Fehlbildung",
			"Cardiopathie, malformation congénitale", "Cardiopatia, malformazione congenita",
			"20140101", ""),

	/** CR114003. */
	CR114003("114003", "Chronisch obstruktive Pneumopathie", "Pneumopathie chronique obstructive",
			"Pneumopatia cronica ostruttiva", "20140101", ""),

	/** CR114004. */
	CR114004("114004",
			"Schweres Asthma: bei verlängerter oder häufiger Behandlung mit oralen Steroiden",
			"Asthme sévère : si traitement prolongé ou fréquent par des corticoïdes oraux",
			"Asma severa : se trattamento prolungato o frequente con corticoidi orali", "20140101",
			""),

	/** CR114005. */
	CR114005("114005", "Bronchiektasen durch Antikörpermangel",
			"Bronchiectasies sur carence en anticorps", "Bronchiettasie su carenza in anticorpi",
			"20140101", ""),

	/** CR114006. */
	CR114006("114006", "Andere Lungenerkrankungen (z.B. Mukoviszidose, Asthma bronchiale, etc.)",
			"Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)",
			"Altre malattie polmonari (p.es. mucoviscidosi, asma trattata con aerosol, ecc.)",
			"20140101", ""),

	/** CR114007. */
	CR114007("114007", "Chronische Lebererkrankung", "Maladie hépatique chronique",
			"Malattia epatica cronica", "20140101", ""),

	/** CR114008. */
	CR114008("114008", "Leberzirrhose", "Cirrhose hépatique", "Cirrosi epatica", "20140101", ""),

	/** CR114012. */
	CR114012("114012",
			"Neuromuskuläre Krankheit (Falls Auswirkungen auf Herz-, Lungen- oder Nierenfunktion)",
			"Maladie neuromusculaire (Si répercussion sur la fonction cardiaque, pulmonaire ou rénale)",
			"Malattia neuromuscolare (Se ripercussione sulla funzione cardiaca, polmonare o renale)",
			"20140101", ""),

	/** CR114014. */
	CR114014("114014", "Sichelzellanämie", "Anémie falciforme", "Anemia falciforme", "20140101",
			""),

	/** CR114015. */
	CR114015("114015", "Diabetes mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren",
			"Diabète avec répercussion sur la fonction cardiaque, pulmonaire ou rénale",
			"Diabete con ripercussioni sulla funzione cardiopolmonare o renale", "20140101", ""),

	/** CR114016. */
	CR114016("114016", "Morbide Adipositas (BMI >= 40)", "Obésité morbide (IMC >= 40)",
			"Obesità patologica (IMC >= 40)", "20140101", ""),

	/** CR114018. */
	CR114018("114018", "Kandidaten für eine Solidorgantransplantation",
			"Candidats à une transplantation d&apos;organe solide",
			"Candidati a un trapianto d&apos;organo solido", "20140101", ""),

	/** CR114019. */
	CR114019("114019", "Empfänger einer Solidorgantransplantation",
			"Receveurs d&apos;une transplantation d&apos;organe solide",
			"Riceventi di un trapianto d&apos;organo solido", "20140101", ""),

	/** CR114020. */
	CR114020("114020", "Empfänger einer Stammzelltransplantation",
			"Receveurs de cellules souches hématopoïétiques",
			"Riceventi di cellule staminali ematopoietiche", "20140101", ""),

	/** CR114021. */
	CR114021("114021", "Autoimmunkrankheit, welche eine Immunsuppression erfordert",
			"Maladie auto-immune exigeant vraisemblablement une immunosuppression",
			"Malattia autoimmune che richiede probabilmente una immunosoppressione", "20140101",
			""),

	/** CR114022. */
	CR114022("114022",
			"Medikamentöse Immunosuppression (inkl. systemische Langzeitkortikoidtherapie und Radiotherapie)",
			"Immunosuppression médicamenteuse (y c. corticothérapie de longue durée par voie générale et radiothérapie)",
			"Immunosoppressione medicamentosa (compresa una corticoterapia di lunga durata per via generale e una radioterapia)",
			"20140101", ""),

	/** CR114025. */
	CR114025("114025",
			"Angeborene Immundefizienz, variables Immundefektsyndrom, defizitäre Antwort auf Polysaccharide",
			"Immunodéficience congénitale, immunodéficience commune variable, déficit réponse aux polysaccharidiques",
			"Immunodeficienza congenita, immunodeficienza comune variabile, deficit di risposta ai polisaccaridi",
			"20140101", ""),

	/** CR114026. */
	CR114026("114026", "Mangel im klassischen oder alternativen Weg der Komplementaktivierung",
			"Déficit en facteurs de la voie alterne ou terminale du complément",
			"Deficit in fattori della via alterna o terminale del complemento", "20140101", ""),

	/** CR114028. */
	CR114028("114028", "Schwangerschaft und post-partum Periode", "Grossesse et post-partum",
			"Gravidanza e post-parto", "20140101", ""),

	/** CR114030. */
	CR114030("114030", "Mutter HBsAg positiv", "Mère HBsAg positive", "Madre HBsAg positiva",
			"20140101", ""),

	/** CR114032. */
	CR114032("114032", "Schädelbasisfraktur / -Missbildung, zerebrospinale Liquorfistel",
			"Fracture ou malformation de la base du crâne, fistule de liquide céphalo-rachidien",
			"Frattura o malformazione della base del cranio, fistola di liquido cerebrospinale",
			"20140101", "");

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.1";

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "CDA-CH-VACD compl-risks";

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
	private CdaChVacdComplRisks(String code, String displayNameDe, String displayNameFr,
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
	public static CdaChVacdComplRisks getEnum(String code) {
		for (CdaChVacdComplRisks x : values()) {
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
		for (CdaChVacdComplRisks x : values()) {
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
	 * Checks if the code is valid for the specified date.
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