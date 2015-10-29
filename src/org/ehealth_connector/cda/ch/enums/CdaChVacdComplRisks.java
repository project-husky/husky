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

	/** Anatomische oder funktionelle Asplenie */
	ANATOMISCHE_ODER_FUNKTIONELLE_ASPLENIE("113001", "Anatomische oder funktionelle Asplenie",
			"Asplénie anatomique ou fonctionnelle", "Asplenia anatomica o funzionale", "20130101",
			""),

	/**
	 * Andere Lungenerkrankungen (z.B. Mukoviszidose, Asthma bronchiale, etc.)
	 */
	ANDERE_LUNGENERKRANKUNGEN_ZB_MUKOVISZIDOSE_ASTHMA_BRONCHIALE_ETC("114006",
			"Andere Lungenerkrankungen (z.B. Mukoviszidose, Asthma bronchiale, etc.)",
			"Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)",
			"Altre malattie polmonari (p.es. mucoviscidosi, asma trattata con aerosol, ecc.)",
			"20140101", ""),

	/**
	 * Angeborene Immundefizienz, variables Immundefektsyndrom, defizitäre
	 * Antwort auf Polysaccharide
	 */
	ANGEBORENE_IMMUNDEFIZIENZ_VARIABLES_IMMUNDEFEKTSYNDROM_DEFIZITÄRE_ANTWORT_AUF_POLYSACCHARIDE(
			"114025",
			"Angeborene Immundefizienz, variables Immundefektsyndrom, defizitäre Antwort auf Polysaccharide",
			"Immunodéficience congénitale, immunodéficience commune variable, déficit réponse aux polysaccharidiques",
			"Immunodeficienza congenita, immunodeficienza comune variabile, deficit di risposta ai polisaccaridi",
			"20140101", ""),

	/**
	 * Autoimmunkrankheit, welche eine Immunsuppression erfordert
	 */
	AUTOIMMUNKRANKHEIT_WELCHE_EINE_IMMUNSUPPRESSION_ERFORDERT("114021",
			"Autoimmunkrankheit, welche eine Immunsuppression erfordert",
			"Maladie auto-immune exigeant vraisemblablement une immunosuppression",
			"Malattia autoimmune che richiede probabilmente una immunosoppressione", "20140101",
			""),

	/** Bronchiektasen durch Antikörpermangel */
	BRONCHIEKTASEN_DURCH_ANTIKÖRPERMANGEL("114005", "Bronchiektasen durch Antikörpermangel",
			"Bronchiectasies sur carence en anticorps", "Bronchiettasie su carenza in anticorpi",
			"20140101", ""),

	/** Chronisch obstruktive Pneumopathie */
	CHRONISCH_OBSTRUKTIVE_PNEUMOPATHIE("114003", "Chronisch obstruktive Pneumopathie",
			"Pneumopathie chronique obstructive", "Pneumopatia cronica ostruttiva", "20140101", ""),

	/** Chronische Lebererkrankung */
	CHRONISCHE_LEBERERKRANKUNG("114007", "Chronische Lebererkrankung",
			"Maladie hépatique chronique", "Malattia epatica cronica", "20140101", ""),

	/** Cochleaimplantat, in situ oder geplant */
	COCHLEAIMPLANTAT_IN_SITU_ODER_GEPLANT("113002", "Cochleaimplantat, in situ oder geplant",
			"Implant cochléaire, in situ ou planifié", "Impianto cocleare, in situ o pianificato",
			"20130101", ""),

	/**
	 * Defekte bei der Komplementaktivierung des alternativen Wegs oder Defizite
	 * der Terminalfaktoren des Komplementsystems
	 */
	@Deprecated DEFEKTE_BEI_DER_KOMPLEMENTAKTIVIERUNG_DES_ALTERNATIVEN_WEGS_ODER_DEFIZITE_DER_TERMINALFAKTOREN_DES_KOMPLEMENTSYSTEMS(
			"113003",
			"Defekte bei der Komplementaktivierung des alternativen Wegs oder Defizite der Terminalfaktoren des Komplementsystems",
			"Déficit en facteurs de la voie alterne ou terminale du complément",
			"Deficit di fattori della via alterna o terminale del complemento", "20130101",
			"20131231"),

	/**
	 * Diabetes mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren
	 */
	DIABETES_MIT_AUSWIRKUNG_AUF_DIE_FUNKTION_VON_HERZ_LUNGEN_ODER_NIEREN("114015",
			"Diabetes mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren",
			"Diabète avec répercussion sur la fonction cardiaque, pulmonaire ou rénale",
			"Diabete con ripercussioni sulla funzione cardiopolmonare o renale", "20140101", ""),

	/** Empfänger einer Solidorgantransplantation */
	EMPFÄNGER_EINER_SOLIDORGANTRANSPLANTATION("114019", "Empfänger einer Solidorgantransplantation",
			"Receveurs d&apos;une transplantation d&apos;organe solide",
			"Riceventi di un trapianto d&apos;organo solido", "20140101", ""),

	/** Empfänger einer Stammzelltransplantation */
	EMPFÄNGER_EINER_STAMMZELLTRANSPLANTATION("114020", "Empfänger einer Stammzelltransplantation",
			"Receveurs de cellules souches hématopoïétiques",
			"Riceventi di cellule staminali ematopoietiche", "20140101", ""),

	/**
	 * Geburt vor der 33. Schwangerschaftswoche oder Geburtsgewicht &lt; 1500g
	 */
	GEBURT_VOR_DER_33_SCHWANGERSCHAFTSWOCHE_ODER_GEBURTSGEWICHT_LT_1500G("113004",
			"Geburt vor der 33. Schwangerschaftswoche oder Geburtsgewicht < 1500g",
			"Naissance avant la 33e semaine de grossesse ou poids de naissance <1500 g",
			"Nascita prima della 33a settimana di gravidanza o peso alla nascita <1500 g",
			"20130101", ""),

	/** Hämoglobinopathie */
	@Deprecated HÄMOGLOBINOPATHIE("113005", "Hämoglobinopathie", "Hémoglobinopathie",
			"Emoglobinopatie", "20130101", "20131231"),

	/** Hepatopathien (chronische) */
	@Deprecated HEPATOPATHIEN_CHRONISCHE("113006", "Hepatopathien (chronische)",
			"Hépatopathies chroniques", "Epatopatie croniche", "20130101", "20131231"),

	/** Herzinsuffizienz */
	HERZINSUFFIZIENZ("114001", "Herzinsuffizienz", "Insuffisance cardiaque",
			"Insufficienza cardiaca", "20140101", ""),

	/**
	 * Herzkrankheiten (chronische, kongenitale Missbildungen)
	 */
	@Deprecated HERZKRANKHEITEN_CHRONISCHE_KONGENITALE_MISSBILDUNGEN("113007",
			"Herzkrankheiten (chronische, kongenitale Missbildungen)",
			"Cardiopathies chroniques, malformations congénitales",
			"Cardiopatie croniche, malformazioni congenite", "20130101", "20131231"),

	/**
	 * HIV Infektion mit CD4-Zellen &gt;= 15 % (Erwachsene: &gt;= 200 / µl)
	 */
	HIV_INFEKTION_MIT_CD4_ZELLEN_GTEQ_15_P_ERWACHSENE_GTEQ_200_µL("113008",
			"HIV Infektion mit CD4-Zellen >= 15 % (Erwachsene: >= 200 / µl)",
			" Infection à VIH avec CD4 >= 15% (Adultes : >= 200 / µl)",
			"Infezione HIV con CD4 >= 15% (Adulti : >= 200 / µl)", "20130101", ""),

	/**
	 * HIV Infektion mit CD4-Zellen &lt; 15 % (Erwachsene: &lt; 200 / µl)
	 */
	HIV_INFEKTION_MIT_CD4_ZELLEN_LT_15_P_ERWACHSENE_LT_200_µL("113009",
			"HIV Infektion mit CD4-Zellen < 15 % (Erwachsene: < 200 / µl)",
			"Infection à VIH avec CD4 < 15% (Adultes : < 200 / µl)",
			"Infezione HIV con CD4 < 15% (Adulti : < 200 / µl)", "20130101", ""),

	/**
	 * Immuninsuffizienz jeder Art (medikamentös, Transplantation, chron.
	 * Erkrankungen)
	 */
	@Deprecated IMMUNINSUFFIZIENZ_JEDER_ART_MEDIKAMENTÖS_TRANSPLANTATION_CHRON_ERKRANKUNGEN(
			"113010",
			"Immuninsuffizienz jeder Art (medikamentös, Transplantation, chron. Erkrankungen)",
			"Immunodéficiences (toutes situations) y. c. immunosuppression, immunosuppression médicamenteuse (transplantation, maladies chroniques) ",
			"Immunodeficienze (tutte le situazioni) compreso immunosoppressione e immunosoppressione medicamentosa (trapianto, malattie croniche)",
			"20130101", "20131231"),

	/** Kandidaten für eine Solidorgantransplantation */
	KANDIDATEN_FÜR_EINE_SOLIDORGANTRANSPLANTATION("114018",
			"Kandidaten für eine Solidorgantransplantation",
			"Candidats à une transplantation d&apos;organe solide",
			"Candidati a un trapianto d&apos;organo solido", "20140101", ""),

	/** Kardiopathie, angeborene Fehlbildung */
	KARDIOPATHIE_ANGEBORENE_FEHLBILDUNG("114002", "Kardiopathie, angeborene Fehlbildung",
			"Cardiopathie, malformation congénitale", "Cardiopatia, malformazione congenita",
			"20140101", ""),

	/**
	 * Kongenitales Immunmangelsyndrom (mangelnde Immunantwort auf
	 * Polysaccharide, Antikörpermangel)
	 */
	@Deprecated KONGENITALES_IMMUNMANGELSYNDROM_MANGELNDE_IMMUNANTWORT_AUF_POLYSACCHARIDE_ANTIKÖRPERMANGEL(
			"113011",
			"Kongenitales Immunmangelsyndrom (mangelnde Immunantwort auf Polysaccharide, Antikörpermangel)",
			"Immunodéficience congénitale (défaut de réponses aux polysaccharides, déficiences en anticorps)",
			"Immunodeficienza congenita (difetto di risposta ai polisaccaridi, deficienze in anticorpi)",
			"20130101", "20131231"),

	/** Leberzirrhose */
	LEBERZIRRHOSE("114008", "Leberzirrhose", "Cirrhose hépatique", "Cirrosi epatica", "20140101",
			""),

	/** Liquorfistel */
	LIQUORFISTEL("113013", "Liquorfistel", "Fistule de LCR", "Fistola di LCR", "20130101",
			"20131231"),

	/** Lymphom, Leukämie, Myelom */
	LYMPHOM_LEUKÄMIE_MYELOM("113012", "Lymphom, Leukämie, Myelom", "Lymphome, leucémie, myélome",
			"Linfoma, leucemia, mieloma", "20130101", ""),

	/** Mangel an Mannose-bindendem Lektin */
	MANGEL_AN_MANNOSE_BINDENDEM_LEKTIN("113014", "Mangel an Mannose-bindendem Lektin",
			"Déficit en lectine liant le mannose", "Deficit di lectina legante il mannosio",
			"20130101", ""),

	/**
	 * Mangel im klassischen oder alternativen Weg der Komplementaktivierung
	 */
	MANGEL_IM_KLASSISCHEN_ODER_ALTERNATIVEN_WEG_DER_KOMPLEMENTAKTIVIERUNG("114026",
			"Mangel im klassischen oder alternativen Weg der Komplementaktivierung",
			"Déficit en facteurs de la voie alterne ou terminale du complément",
			"Deficit in fattori della via alterna o terminale del complemento", "20140101", ""),

	/**
	 * Medikamentöse Immunosuppression (inkl. systemische
	 * Langzeitkortikoidtherapie und Radiotherapie)
	 */
	MEDIKAMENTÖSE_IMMUNOSUPPRESSION_INKL_SYSTEMISCHE_LANGZEITKORTIKOIDTHERAPIE_UND_RADIOTHERAPIE(
			"114022",
			"Medikamentöse Immunosuppression (inkl. systemische Langzeitkortikoidtherapie und Radiotherapie)",
			"Immunosuppression médicamenteuse (y c. corticothérapie de longue durée par voie générale et radiothérapie)",
			"Immunosoppressione medicamentosa (compresa una corticoterapia di lunga durata per via generale e una radioterapia)",
			"20140101", ""),

	/**
	 * Metabolische Erkrankungen mit Auswirkungen auf Herz, Lungen, Nieren
	 * und/oder Immunsystem (Diabetes, morbide Adipositas BMI &gt;= 40 )
	 */
	@Deprecated METABOLISCHE_ERKRANKUNGEN_MIT_AUSWIRKUNGEN_AUF_HERZ_LUNGEN_NIEREN_UND_ODER_IMMUNSYSTEM_DIABETES_MORBIDE_ADIPOSITAS_BMI_GTEQ_40_(
			"113015",
			"Metabolische Erkrankungen mit Auswirkungen auf Herz, Lungen, Nieren und/oder Immunsystem (Diabetes, morbide Adipositas BMI >= 40 )",
			"Maladies métaboliques chroniques affectant coeur, poumons et/ou défenses immunitaires (diabète, obésité morbide IMC >= 40)",
			"Malattie metaboliche croniche che colpiscono cuore, polmoni e/o difese immunitarie (diabete, obesità patologica con BMI >= 40) ",
			"20130101", "20131231"),

	/** Missbildungen der Schädelbasis */
	MISSBILDUNGEN_DER_SCHÄDELBASIS("113016", "Missbildungen der Schädelbasis",
			"Malformations de la base du crâne", "Malformazioni della base del cranio", "20130101",
			"20131231"),

	/** Morbide Adipositas (BMI &gt;= 40) */
	MORBIDE_ADIPOSITAS_BMI_GTEQ_40("114016", "Morbide Adipositas (BMI >= 40)",
			"Obésité morbide (IMC >= 40)", "Obesità patologica (IMC >= 40)", "20140101", ""),

	/** Mutter HBsAg positiv */
	MUTTER_HBSAG_POSITIV("114030", "Mutter HBsAg positiv", "Mère HBsAg positive",
			"Madre HBsAg positiva", "20140101", ""),

	/** Myelome */
	@Deprecated MYELOME("113017", "Myelome", "Myélome", "Mieloma", "20130101", "20131231"),

	/** Nephrotisches Syndrom */
	NEPHROTISCHES_SYNDROM("113018", "Nephrotisches Syndrom", "Syndrome néphrotique",
			"Sindrome nefrosica", "20130101", ""),

	/**
	 * Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit hoher
	 * Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren (in
	 * ihrem ersten Lebensjahr)
	 */
	@Deprecated NEUGEBORENE_UND_SÄUGLINGE_UNTER_12_MONATEN_AUS_LÄNDERN_MIT_HOHER_TUBERKULOSE_PRÄVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURÜCKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR(
			"113019",
			"Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren (in ihrem ersten Lebensjahr)",
			"Nouveau-nés ou nourrissons < 12 mois originaire d’un pays à haute endémie et susceptibles d’y retourner dans leur 1ère année de vie",
			"Neonati o lattanti < 12 mesi originari di un paese a elevata endemia e suscettibili di ritornarci nel loro primo anno di vita ",
			"20130101", "20131231"),

	/** Neugeborene von HBsAg-positiven Müttern */
	@Deprecated NEUGEBORENE_VON_HBSAG_POSITIVEN_MÜTTERN("113020",
			"Neugeborene von HBsAg-positiven Müttern", "Nouveau-nés de mères HBsAg positives",
			"Neonati di madri HBsAg positive", "20130101", "20131231"),

	/**
	 * Neurologische oder muskuloskelettale Erkrankung mit Auswirkung auf die
	 * Funktion von Herz, Lungen oder Nieren
	 */
	@Deprecated NEUROLOGISCHE_ODER_MUSKULOSKELETTALE_ERKRANKUNG_MIT_AUSWIRKUNG_AUF_DIE_FUNKTION_VON_HERZ_LUNGEN_ODER_NIEREN(
			"113022",
			"Neurologische oder muskuloskelettale Erkrankung mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren",
			"Affection neurologique ou musculo-squelettique avec répercussion sur la fonction cardiaque, pulmonaire ou rénale",
			"Affezione neurologica o muscolo-scheletrica con ripercussioni sulla funzione cardiaca, polmonare o renale",
			"20130101", "20131231"),

	/**
	 * Neuromuskuläre Krankheit (Falls Auswirkungen auf Herz-, Lungen- oder
	 * Nierenfunktion)
	 */
	NEUROMUSKULÄRE_KRANKHEIT_FALLS_AUSWIRKUNGEN_AUF_HERZ_LUNGEN_ODER_NIERENFUNKTION("114012",
			"Neuromuskuläre Krankheit (Falls Auswirkungen auf Herz-, Lungen- oder Nierenfunktion)",
			"Maladie neuromusculaire (Si répercussion sur la fonction cardiaque, pulmonaire ou rénale)",
			"Malattia neuromuscolare (Se ripercussione sulla funzione cardiaca, polmonare o renale)",
			"20140101", ""),

	/** Niereninsuffizienz */
	NIERENINSUFFIZIENZ("113023", "Niereninsuffizienz", "Insuffisance rénale",
			"Insufficienza renale", "20130101", ""),

	/** Pneumopathien (chronische) */
	@Deprecated PNEUMOPATHIEN_CHRONISCHE("113024", "Pneumopathien (chronische)",
			"Pneumopathies chroniques", "Pneumopatie croniche", "20130101", "20131231"),

	/**
	 * Schädelbasisfraktur / -Missbildung, zerebrospinale Liquorfistel
	 */
	SCHÄDELBASISFRAKTUR_MISSBILDUNG_ZEREBROSPINALE_LIQUORFISTEL("114032",
			"Schädelbasisfraktur / -Missbildung, zerebrospinale Liquorfistel",
			"Fracture ou malformation de la base du crâne, fistule de liquide céphalo-rachidien",
			"Frattura o malformazione della base del cranio, fistola di liquido cerebrospinale",
			"20140101", ""),

	/**
	 * Schwangere Frauen und Frauen, die in den letzten 4 Wochen entbunden haben
	 */
	@Deprecated SCHWANGERE_FRAUEN_UND_FRAUEN_DIE_IN_DEN_LETZTEN_4_WOCHEN_ENTBUNDEN_HABEN_("113025",
			"Schwangere Frauen und Frauen, die in den letzten 4 Wochen entbunden haben ",
			"Femmes enceintes ou ayant accouchées au cours des 4 semaines précédentes",
			"Donne incite o che hanno partorito nelle 4 settimane precedenti", "20130101",
			"20131231"),

	/** Schwangerschaft und post-partum Periode */
	SCHWANGERSCHAFT_UND_POST_PARTUM_PERIODE("114028", "Schwangerschaft und post-partum Periode",
			"Grossesse et post-partum", "Gravidanza e post-parto", "20140101", ""),

	/** Schwere Neurodermitis beim Kind */
	SCHWERE_NEURODERMITIS_BEIM_KIND("113021", "Schwere Neurodermitis beim Kind",
			"Eczema sévère chez l’enfant", "Eczema severo nel bambino", "20130101", ""),

	/**
	 * Schweres Asthma: bei verlängerter oder häufiger Behandlung mit oralen
	 * Steroiden
	 */
	SCHWERES_ASTHMA_BEI_VERLÄNGERTER_ODER_HÄUFIGER_BEHANDLUNG_MIT_ORALEN_STEROIDEN("114004",
			"Schweres Asthma: bei verlängerter oder häufiger Behandlung mit oralen Steroiden",
			"Asthme sévère : si traitement prolongé ou fréquent par des corticoïdes oraux",
			"Asma severa : se trattamento prolungato o frequente con corticoidi orali", "20140101",
			""),

	/** Sichelzellanämie */
	SICHELZELLANÄMIE("114014", "Sichelzellanämie", "Anémie falciforme", "Anemia falciforme",
			"20140101", "");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "CDA-CH-VACD compl-risks";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.1";

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