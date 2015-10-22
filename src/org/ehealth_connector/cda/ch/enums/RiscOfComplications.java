package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * <div class="de">Hinweis: Diese Tabelle wird jährlich durch die EKIF angepasst (siehe auch [Impfplan]). eHealth Suisse
 * wird eine jährlich aktualisierte Version dieses Value-Sets in elektronischer Form publizieren. (Quelle:
 * Schweizerischer [Impfplan], 7.1 Erhöhtes Risiko von Komplikationen)</div>
 * <div class="fr">Remarque : Ce tableau est adapté chaque année par la CFV (cf. également [plan de vaccination
 * suisse]). eHealth Suisse publiera une version actualisée chaque année de ce Value Set au format électronique. (Source
 * : [Plan de vaccination suisse], 7.1 Risque accru de complications)</div>
 * @deprecated use org.ehealth_connector.cda.ch.enums.CdaChVacdExpRisks
 * @see <a href="https://svn.code.sf.net/p/hl7ch/code/trunk/schematrons/HL7.ch/CDA-CH/v1.2/">HL7.ch Schematrons</a>
 */
@Deprecated
public enum RiscOfComplications {

	/**
	 * <div class="de">Anatomische oder funktionelle Asplenie, Hyposplenie
	 * (Sichelzellanämie)</div> <div class="fr">Asplénie anatomique ou
	 * fonctionnelle, hyposplénie (anémie falciforme)</div>
	 */
	ANATOMISCHE_ODER_FUNKTIONELLE_ASPLENIE_HYPOSPLENIE_SICHELZELLANAEMIE("1", "Anatomische oder funktionelle Asplenie, Hyposplenie (Sichelzellanämie)"),
	/**
	 * <div class="de">Cochlea-Implantat</div> <div class="fr">Implant
	 * cochléaire</div>
	 */
	COCHLEA_IMPLANTAT("2", "Cochlea-Implantat"),
	/**
	 * <div class="de">Defekte bei der Komplementaktivierung des alternativen Wegs
	 * oder Defizite der Terminalfaktoren des Komplementsystems</div> <div
	 * class="fr">Déficits en facteurs de la voie alterne ou terminale du
	 * complément</div>
	 */
	DEFEKTE_BEI_DER_KOMPLEMENTAKTIVIERUNG_DES_ALTERNATIVEN_WEGS_ODER_DEFIZITE_DER_TERMINALFAKTOREN_DES_KOMPLEMENTSYSTEMS("3", "Defekte bei der Komplementaktivierung des alternativen Wegs oder Defizite der Terminalfaktoren des Komplementsystems"),
	/**
	 * <div class="de">Frühgeborene </div> <div class="fr">Prématurés</div>
	 */
	FRUEHGEBORENE_kleiner_33_WOCHEN_ODER_GEBURTSGEWICHT_kleiner_1500_G("4", "Frühgeborene (< 33 Wochen oder Geburtsgewicht < 1500 g)"),
	/**
	 * <div class="de">Sichelzellenanämie</div> <div
	 * class="fr"></div>
	 */
	SICHELZELLENANAEMIE("5", "Sichelzellenanämie"),
	/**
	 * <div class="de">Hepatopathien (chronische)</div> <div
	 * class="fr">Hépatopathies (chroniques)</div>
	 */
	HEPATOPATHIEN_CHRONISCHE("6", "Hepatopathien (chronische)"),
	/**
	 * <div class="de">Herzkrankheiten (chronische, kongenitale
	 * Missbildungen)</div> <div class="fr">Cardiopathies (chroniques,
	 * malformations congénitales)</div>
	 */
	HERZKRANKHEITEN_CHRONISCHE_KONGENITALE_MISSBILDUNGEN("7", "Herzkrankheiten (chronische, kongenitale Missbildungen)"),
	/**
	 * <div class="de">HIV-Infektion mit genügend T-Lymphozyten CD4</div> <div
	 * class="fr">VIH avec taux suffisant de lymphocytes T CD4</div>
	 */
	HIV_INFEKTION_MIT_GENUEGEND_T_LYMPHOZYTEN_CD4("8", "HIV-Infektion mit genügend T-Lymphozyten CD4"),
	/**
	 * <div class="de">HIV-Infektion mit ungenügend T-Lymphozyten CD4</div> <div
	 * class="fr">VIH avec taux insuffisant de lymphocytes T CD4</div>
	 */
	HIV_INFEKTION_MIT_UNGENUEGEND_T_LYMPHOZYTEN_CD4("9", "HIV-Infektion mit ungenügend T-Lymphozyten CD4"),
	/**
	 * <div class="de">Immuninsuffizienz jeder Art (medikamentös, Transplantation,
	 * chron. Erkrankungen)</div> <div class="fr">Immunodéficiences de tous types
	 * (immunosuppression médicamenteuse, transplantation, maladies
	 * chroniques)</div>
	 */
	IMMUNINSUFFIZIENZ_JEDER_ART_MEDIKAMENTÖS_TRANSPLANTATION_CHRON__ERKRANKUNGEN("10", "Immuninsuffizienz jeder Art (medikamentös, Transplantation, chron. Erkrankungen)"),
	/**
	 * <div class="de">Kongenitales Immunmangelsyndrom (mangelnde Immunantwort auf
	 * Polysaccharide, Antikörpermangel)</div> <div class="fr">Immunodéficience
	 * congénitale (défaut de réponse aux polysaccharides, déficiences en
	 * anticorps)</div>
	 */
	KONGENITALES_IMMUNMANGELSYNDROM_MANGELNDE_IMMUNANTWORT_AUF_POLYSACCHARIDE_ANTIKÖRPERMANGEL("11", "Kongenitales Immunmangelsyndrom (mangelnde Immunantwort auf Polysaccharide, Antikörpermangel)"),

	/**
	 * <div class="de">Liquorfistel</div> <div class="fr">Fistule de LCR</div>
	 */
	LIQUORFISTEL("13", "Liquorfistel"),
	/**
	 * <div class="de">Mangel an Mannose-bindendem Lektin</div> <div
	 * class="fr">Déficit en lectine liant le mannose</div>
	 */
	MANGEL_AN_MANNOSE_BINDENDEM_LEKTIN("14", "Mangel an Mannose-bindendem Lektin"),
	/**
	 * <div class="de">Metabolische Erkrankungen mit Auswirkungen auf Herz,
	 * Lungen, Nieren und/oder Immunsystem (Diabetes, morbide Adipositas BMI ? 40
	 * )</div> <div class="fr">Maladies métaboliques chroniques affectant cœur,
	 * poumons, reins et/ou défenses immunitaires (diabète, obésité morbide IMC ?
	 * 40)</div>
	 */
	METABOLISCHE_ERKRANKUNGEN_MIT_AUSWIRKUNGEN_AUF_HERZ_LUNGEN_NIEREN_UNDODER_IMMUNSYSTEM_DIABETES_MORBIDE_ADIPOSITAS_BMI__40("15", "Metabolische Erkrankungen mit Auswirkungen auf Herz, Lungen, Nieren und/oder Immunsystem (Diabetes, morbide Adipositas BMI ? 40 )"),
	/**
	 * <div class="de">Missbildungen der Schädelbasis</div> <div
	 * class="fr">Malformations de la base du crâne</div>
	 */
	MISSBILDUNGEN_DER_SCHAEDELBASIS("16", "Missbildungen der Schädelbasis"),
	/**
	 * <div class="de">Myelome</div> <div class="fr">Myélome</div>
	 */
	MYELOME("17", "Myelome"),
	/**
	 * <div class="de">Nephrotisches Syndrom</div> <div class="fr">Syndrome
	 * néphrotique</div>
	 */
	NEPHROTISCHES_SYNDROM("18", "Nephrotisches Syndrom"),
	/**
	 * <div class="de">Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit
	 * hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren
	 * (in ihrem ersten Lebensjahr)</div> <div class="fr">Nouveau-nés et
	 * nourrissons </div>
	 */
	NEUGEBORENE_UND_SAEUGLINGE_UNTER_12_MONATEN_AUS_LAENDERN_MIT_HOHER_TUBERKULOSE_PRAEVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURUECKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR("19", "Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren (in ihrem ersten Lebensjahr)"),
	/**
	 * <div class="de">Neugeborene von HBsAg-positiven Müttern</div> <div
	 * class="fr">Nouveau-nés de mères HBsAg positives</div>
	 */
	NEUGEBORENE_VON_HBSAG_POSITIVEN_MUETTERN("20", "Neugeborene von HBsAg-positiven Müttern"),
	/**
	 * <div class="de">Neurodermitis (schwere bei Kindern)</div> <div
	 * class="fr">Eczéma (sévère chez les enfants)</div>
	 */
	NEURODERMITIS_SCHWERE_BEI_KINDERN("21", "Neurodermitis (schwere bei Kindern)"),
	/**
	 * <div class="de">Neurologische oder muskuloskelettale Erkrankung mit
	 * Auswirkung auf die Funktion von Herz, Lungen oder Nieren</div> <div
	 * class="fr">Affection neurologique ou musculo-squelettique avec répercussion
	 * sur la fonction cardiaque, pulmonaire ou rénale</div>
	 */
	NEUROLOGISCHE_ODER_MUSKULOSKELETTALE_ERKRANKUNG_MIT_AUSWIRKUNG_AUF_DIE_FUNKTION_VON_HERZ_LUNGEN_ODER_NIEREN("22", "Neurologische oder muskuloskelettale Erkrankung mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren"),
	/**
	 * <div class="de">Schwerer Nierenschaden (Clearance &lt; 30ml/min oder Verschlechterung)</div>
	 * <div class="fr">Insuffisance rénale avancée (clearance &lt; 30ml/min ou en diminution)</div>
	 */
	SCHWERER_NIERENSCHADEN_CLEARANCE_KLEINER_30ML_PRO_MIN_ODER_VERSCHLECHTERUNG("23", "schwerer Nierenschaden (Clearance<30ml/min oder Verschlechterung)"),
	/**
	 * <div class="de">Schwere chronische Lungenerkrankungen (COPD Stadium 3 oder 4 oder Verschlechterung)</div> <div
	 * class="fr">Maladie pulmonaire chronique obstructive importante ou en aggravation</div>
	 */
	SCHWERE_CHRONISCHE_LUNGENERKRANKUNGEN_COPD_STADIUM_3_ODER_4_ODER_VERSCHLECHTERUNG("24", "Schwere chronische Lungenerkrankungen (COPD Stadium 3 oder 4 oder Verschlechterung)"),
	/**
	 * <div class="de">Schwangere Frauen und Frauen, die in den letzten 4 Wochen
	 * entbunden haben </div> <div class="fr">Femmes enceintes ou ayant accouché
	 * au cours des 4 semaines précédentes </div>
	 */
	SCHWANGERSCHAFT("25", "Schwangere Frauen und Frauen, die in den letzten 4 Wochen entbunden haben"),

	/**
	 * <div class="de">Andere Nirenerkrankungen</div>
	 * <div class="fr"></div>
	 */
	ANDERE_NIERENERKRANKUNGEN("26", "Andere Nierenerkrankungen"),
	/**
	 * <div class="de">Schweres Asthma (bei verlängerter oder häufiger Kortisonbehandlung)</div>
	 * <div class="fr"></div>
	 */
	SCHWERES_ASTHMA_BEI_VERLAENGERTER_ODER_HAEUFIGER_KORTISONBEHANDLUNG("27", "Schweres Asthma (bei verlängerter oder häufiger Kortisonbehandlung)"),
	/**
	 * <div class="de">Bronchiektasien bei angeborenem Antikörpermangel</div>
	 * <div class="fr"></div>
	 */
	BRONCHIEKTASIEN_BEI_ANGEBORENEM_ANTIKOERPER_MANGEL("28", "Bronchiektasien bei angeborenem Antikörpermangel"),
	/**
	 * <div class="de">Andere Lungenerkrankungen</div>
	 * <div class="fr"></div>
	 */
	ANDERE_LUNGENERKRANKUNGEN("29", "Andere Lungenerkrankungen"),
	/**
	 * <div class="de">Herzschwäche (Herzinsuffizienz Stadium III-IV oder Verschlechterung)</div>
	 * <div class="fr"></div>
	 */
	HERZSCHWÄCHE_HERZINSUFFIZIENZ_STADIUM_III_bis_IV_ODER_VERSCHLECHTERUNG("30", "Herzschwäche (Herzinsuffizienz Stadium III-IV oder Verschlechterung)"),
	/**
	 * <div class="de">Andere Herzerkrankungen</div>
	 * <div class="fr"></div>
	 */
	ANDERE_HERZERKRANKUNGEN("31", "Andere Herzerkrankungen"),
	/**
	 * <div class="de">Leberzirrhose</div>
	 * <div class="fr"></div>
	 */
	LEBERZIRRHOSE("32", "Leberzirrhose"),
	/**
	 * <div class="de">Andere Lebererkrankung</div>
	 * <div class="fr"></div>
	 */
	ANDERE_LEBERERKRANKUNG("33", "Andere Lebererkrankung"),
	/**
	 * <div class="de">Anderer Krebs</div>
	 * <div class="fr"></div>
	 */
	ANDERER_KREBS("34", "Anderer Krebs"),
	/**
	 * <div class="de">Rheumatismus oder Autoimmunkrankheit (vor medikamentöser Immunsuppression)</div>
	 * <div class="fr"></div>
	 */
	RHEUMATISMUS_ODER_AUTOIMMUNKRANKHEIT_VOR_MEDIKAMENTOESER_IMMUNSUPPRESSION("35", "Rheumatismus oder Autoimmunkrankheit (vor medikamentöser Immunsuppression)"),
	/**
	 * <div class="de">Protein-S- oder -C-Defizit</div>
	 * <div class="fr"></div>
	 */
	PROTEIN_S_ODER_C_DEFIZIT("36", "Protein-S- oder -C-Defizit"),
	/**
	 * <div class="de">Starkes Übergewicht (BMI ≥ 40)</div>
	 * <div class="fr"></div>
	 */
	STARKES_UEBERGEWICHT_BMI_GROESSER_GLEICH_40("37", "Starkes Übergewicht (BMI ≥ 40)"),

	/**
	 * <div class="de">Andere Komplikationsrisiken</div> <div class="fr">Autres
	 * risques de complication</div>
	 */
	ANDERE_KOMPLIKATIONSRISIKEN("999", "Andere Komplikationsrisiken");
	//	public static final String ANATOMISCHE_ODER_FUNKTIONELLE_ASPLENIE_HYPOSPLENIE_SICHELZELLANÄMIE_CODE = "1";
	//	public static final String COCHLEA_IMPLANTAT_CODE = "2";
	//	public static final String DEFEKTE_BEI_DER_KOMPLEMENTAKTIVIERUNG_DES_ALTERNATIVEN_WEGS_ODER_DEFIZITE_DER_TERMINALFAKTOREN_DES_KOMPLEMENTSYSTEMS_CODE = "3";
	//	public static final String FRÜHGEBORENE_kleiner_33_WOCHEN_ODER_GEBURTSGEWICHT_kleiner_1500_G_CODE = "4";
	//	public static final String HÄMOGLOBINOPATHIE_CODE = "5";
	//	public static final String HEPATOPATHIEN_CHRONISCHE_CODE = "6";
	//	public static final String HERZKRANKHEITEN_CHRONISCHE_KONGENITALE_MISSBILDUNGEN_CODE = "7";
	//	public static final String HIV_INFEKTION_MIT_GENÜGEND_T_LYMPHOZYTEN_CD4_CODE = "8";
	//	public static final String HIV_INFEKTION_MIT_UNGENÜGEND_T_LYMPHOZYTEN_CD4_CODE = "9";
	//	public static final String IMMUNINSUFFIZIENZ_JEDER_ART_MEDIKAMENTÖS_TRANSPLANTATION_CHRON__ERKRANKUNGEN_CODE = "10";
	//	public static final String KONGENITALES_IMMUNMANGELSYNDROM_MANGELNDE_IMMUNANTWORT_AUF_POLYSACCHARIDE_ANTIKÖRPERMANGEL_CODE = "11";
	//	public static final String LEUKÄMIEN_LYMPHOME_CODE = "12";
	//	public static final String LIQUORFISTEL_CODE = "13";
	//	public static final String MANGEL_AN_MANNOSE_BINDENDEM_LEKTIN_CODE = "14";
	//	public static final String METABOLISCHE_ERKRANKUNGEN_MIT_AUSWIRKUNGEN_AUF_HERZ_LUNGEN_NIEREN_UNDODER_IMMUNSYSTEM_DIABETES_MORBIDE_ADIPOSITAS_BMI__40_CODE = "15";
	//	public static final String MISSBILDUNGEN_DER_SCHÄDELBASIS_CODE = "16";
	//	public static final String MYELOME_CODE = "17";
	//	public static final String NEPHROTISCHES_SYNDROM_CODE = "18";
	//	public static final String NEUGEBORENE_UND_SÄUGLINGE_UNTER_12_MONATEN_AUS_LÄNDERN_MIT_HOHER_TUBERKULOSE_PRÄVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURÜCKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR_CODE = "19";
	//	public static final String NEUGEBORENE_VON_HBSAG_POSITIVEN_MÜTTERN_CODE = "20";
	//	public static final String NEURODERMITIS_SCHWERE_BEI_KINDERN_CODE = "21";
	//	public static final String NEUROLOGISCHE_ODER_MUSKULOSKELETTALE_ERKRANKUNG_MIT_AUSWIRKUNG_AUF_DIE_FUNKTION_VON_HERZ_LUNGEN_ODER_NIEREN_CODE = "22";
	//	public static final String NIERENINSUFFIZIENZ_CODE = "23";
	//	public static final String PNEUMOPATHIEN_CHRONISCHE_CODE = "24";
	//	public static final String SCHWANGERE_FRAUEN_UND_FRAUEN_DIE_IN_DEN_LETZTEN_4_WOCHEN_ENTBUNDEN_HABEN_CODE = "25";
	//	public static final String ANDERE_KOMPLIKATIONSRISIKEN_CODE = "999";

	/**
	 * Code System OID for all Complications Risks according defined Schematron <a
	 * href="https://svn.code.sf.net/p/hl7ch/code/trunk/schematrons/HL7.ch/CDA-CH/v1.2/cda-ch-vacd-voc.xml">HL7.ch
	 * Schematron Voc</a>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.2013.1";
	/**
	 * Code System Name for all Complications Risks according defined Schematron <a
	 * href="https://svn.code.sf.net/p/hl7ch/code/trunk/schematrons/HL7.ch/CDA-CH/v1.2/cda-ch-vacd-voc.xml">HL7.ch
	 * Schematron Voc</a>
	 */
	public static final String CODE_SYSTEM_NAME = "compl-risks-2015";

	private String code;
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display
	 * Name</div> <div class="de">Instantiiert dieses Enum Object mittels eines
	 * Codes und einem Display Name</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div>
	 */
	private RiscOfComplications(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static RiscOfComplications getEnum(String code) {
		RiscOfComplications lookupComplication = null;
		for (final RiscOfComplications aComplication : values()) {
			if (aComplication.getCodeValue().equals(code)) {
				lookupComplication = aComplication;
			}
		}
		return lookupComplication;
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
	 * @param enumName
	 * <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * Check if a given Code/Text concern is of type RiscOfComplication
	 *
	 * @param code The code of a concern to check
	 * @param displayName The display name of a concern
	 * @return true in case the specific code and it's display name fit an enum value
	 */
	public static boolean isRiscOfComplication(String code, String displayName) {
		final RiscOfComplications aRisc = getEnum(code);
		return aRisc == null ? false : aRisc.getDisplayName().equalsIgnoreCase(displayName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 * <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		boolean isInSet = false;
		for (final RiscOfComplications aRisk : values()) {
			if (aRisk.getCodeValue().equals(code)) {
				isInSet = true;
				break;
			}
		}
		return isInSet;
	}

}
