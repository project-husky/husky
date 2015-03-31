package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Hinweis: Diese Tabelle wird jährlich durch die EKIF angepasst (siehe auch [Impfplan]). eHealth Suisse wird eine jährlich aktualisierte Version dieses Value-Sets in elektronischer Form publizieren. (Quelle: Schweizerischer [Impfplan], 7.1 Erhöhtes Risiko von Komplikationen)</div>
 *<div class="fr">Remarque : Ce tableau est adapté chaque année par la CFV (cf. également [plan de vaccination suisse]). eHealth Suisse publiera une version actualisée chaque année de ce Value Set au format électronique. (Source : [Plan de vaccination suisse], 7.1 Risque accru de complications)</div>
 */
public enum RiscOfComplications {

	/** 
	 *<div class="de">Anatomische oder funktionelle Asplenie, Hyposplenie (Sichelzellanämie)</div>
	 *<div class="fr">Asplénie anatomique ou fonctionnelle, hyposplénie (anémie falciforme)</div>
	 */
	TOTRANSLATE_1 ("1", "TOTRANSLATE"),
	/** 
	 *<div class="de">Cochlea-Implantat</div>
	 *<div class="fr">Implant cochléaire</div>
	 */
	TOTRANSLATE_2 ("2", "TOTRANSLATE"),
	/** 
	 *<div class="de">Defekte bei der Komplementaktivierung des alternativen Wegs oder Defizite der Terminalfaktoren des Komplementsystems</div>
	 *<div class="fr">Déficits en facteurs de la voie alterne ou terminale du complément</div>
	 */
	TOTRANSLATE_3 ("3", "TOTRANSLATE"),
	/** 
	 *<div class="de">Frühgeborene (< 33 Wochen oder Geburtsgewicht < 1500 g)</div>
	 *<div class="fr">Prématurés (< 33 semaines ou poids à la naissance < 1500 g)</div>
	 */
	TOTRANSLATE_4 ("4", "TOTRANSLATE"),
	/** 
	 *<div class="de">Hämoglobinopathie</div>
	 *<div class="fr">Hémoglobinopathie</div>
	 */
	TOTRANSLATE_5 ("5", "TOTRANSLATE"),
	/** 
	 *<div class="de">Hepatopathien (chronische)</div>
	 *<div class="fr">Hépatopathies (chroniques)</div>
	 */
	TOTRANSLATE_6 ("6", "TOTRANSLATE"),
	/** 
	 *<div class="de">Herzkrankheiten (chronische, kongenitale Missbildungen)</div>
	 *<div class="fr">Cardiopathies (chroniques, malformations congénitales)</div>
	 */
	TOTRANSLATE_7 ("7", "TOTRANSLATE"),
	/** 
	 *<div class="de">HIV-Infektion mit genügend T-Lymphozyten CD4</div>
	 *<div class="fr">VIH avec taux suffisant de lymphocytes T CD4</div>
	 */
	TOTRANSLATE_8 ("8", "TOTRANSLATE"),
	/** 
	 *<div class="de">HIV-Infektion mit ungenügend T-Lymphozyten CD4</div>
	 *<div class="fr">VIH avec taux insuffisant de lymphocytes T CD4</div>
	 */
	TOTRANSLATE_9 ("9", "TOTRANSLATE"),
	/** 
	 *<div class="de">Immuninsuffizienz jeder Art (medikamentös, Transplantation, chron. Erkrankungen)</div>
	 *<div class="fr">Immunodéficiences de tous types (immunosuppression médicamenteuse, transplantation, maladies chroniques)</div>
	 */
	TOTRANSLATE_10 ("10", "TOTRANSLATE"),
	/** 
	 *<div class="de">Kongenitales Immunmangelsyndrom (mangelnde Immunantwort auf Polysaccharide, Antikörpermangel)</div>
	 *<div class="fr">Immunodéficience congénitale (défaut de réponse aux polysaccharides, déficiences en anticorps)</div>
	 */
	TOTRANSLATE_11 ("11", "TOTRANSLATE"),
	/** 
	 *<div class="de">Leukämien, Lymphome</div>
	 *<div class="fr">Leucémies, lymphomes</div>
	 */
	TOTRANSLATE_12 ("12", "TOTRANSLATE"),
	/** 
	 *<div class="de">Liquorfistel</div>
	 *<div class="fr">Fistule de LCR</div>
	 */
	TOTRANSLATE_13 ("13", "TOTRANSLATE"),
	/** 
	 *<div class="de">Mangel an Mannose-bindendem Lektin</div>
	 *<div class="fr">Déficit en lectine liant le mannose</div>
	 */
	TOTRANSLATE_14 ("14", "TOTRANSLATE"),
	/** 
	 *<div class="de">Metabolische Erkrankungen mit Auswirkungen auf Herz, Lungen, Nieren und/oder Immunsystem (Diabetes, morbide Adipositas BMI ? 40 )</div>
	 *<div class="fr">Maladies métaboliques chroniques affectant cœur, poumons, reins et/ou défenses immunitaires (diabète, obésité morbide IMC ? 40)</div>
	 */
	TOTRANSLATE_15 ("15", "TOTRANSLATE"),
	/** 
	 *<div class="de">Missbildungen der Schädelbasis</div>
	 *<div class="fr">Malformations de la base du crâne</div>
	 */
	TOTRANSLATE_16 ("16", "TOTRANSLATE"),
	/** 
	 *<div class="de">Myelome</div>
	 *<div class="fr">Myélome</div>
	 */
	TOTRANSLATE_17 ("17", "TOTRANSLATE"),
	/** 
	 *<div class="de">Nephrotisches Syndrom</div>
	 *<div class="fr">Syndrome néphrotique</div>
	 */
	TOTRANSLATE_18 ("18", "TOTRANSLATE"),
	/** 
	 *<div class="de">Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren (in ihrem ersten Lebensjahr)</div>
	 *<div class="fr">Nouveau-nés et nourrissons < 12 mois originaires d’un pays à taux élevé de prévalence de la tuberculose et susceptibles d’y retourner (dans leur 1re année de vie)</div>
	 */
	TOTRANSLATE_19 ("19", "TOTRANSLATE"),
	/** 
	 *<div class="de">Neugeborene von HBsAg-positiven Müttern</div>
	 *<div class="fr">Nouveau-nés de mères HBsAg positives</div>
	 */
	TOTRANSLATE_20 ("20", "TOTRANSLATE"),
	/** 
	 *<div class="de">Neurodermitis (schwere bei Kindern)</div>
	 *<div class="fr">Eczéma (sévère chez les enfants)</div>
	 */
	TOTRANSLATE_21 ("21", "TOTRANSLATE"),
	/** 
	 *<div class="de">Neurologische oder muskuloskelettale Erkrankung mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren</div>
	 *<div class="fr">Affection neurologique ou musculo-squelettique avec répercussion sur la fonction cardiaque, pulmonaire ou rénale</div>
	 */
	TOTRANSLATE_22 ("22", "TOTRANSLATE"),
	/** 
	 *<div class="de">Niereninsuffizienz</div>
	 *<div class="fr">Insuffisance rénale</div>
	 */
	TOTRANSLATE_23 ("23", "TOTRANSLATE"),
	/** 
	 *<div class="de">Pneumopathien (chronische)</div>
	 *<div class="fr">Pneumopathies (chroniques)</div>
	 */
	TOTRANSLATE_24 ("24", "TOTRANSLATE"),
	/** 
	 *<div class="de">Schwangere Frauen und Frauen, die in den letzten 4 Wochen entbunden haben </div>
	 *<div class="fr">Femmes enceintes ou ayant accouché au cours des 4 semaines précédentes </div>
	 */
	TOTRANSLATE_25 ("25", "TOTRANSLATE"),
	/** 
	 *<div class="de">Andere Komplikationsrisiken</div>
	 *<div class="fr">Autres risques de complication</div>
	 */
	TOTRANSLATE_26 ("999", "TOTRANSLATE");
	public static final String TOTRANSLATE_1_CODE="1";
	public static final String TOTRANSLATE_2_CODE="2";
	public static final String TOTRANSLATE_3_CODE="3";
	public static final String TOTRANSLATE_4_CODE="4";
	public static final String TOTRANSLATE_5_CODE="5";
	public static final String TOTRANSLATE_6_CODE="6";
	public static final String TOTRANSLATE_7_CODE="7";
	public static final String TOTRANSLATE_8_CODE="8";
	public static final String TOTRANSLATE_9_CODE="9";
	public static final String TOTRANSLATE_10_CODE="10";
	public static final String TOTRANSLATE_11_CODE="11";
	public static final String TOTRANSLATE_12_CODE="12";
	public static final String TOTRANSLATE_13_CODE="13";
	public static final String TOTRANSLATE_14_CODE="14";
	public static final String TOTRANSLATE_15_CODE="15";
	public static final String TOTRANSLATE_16_CODE="16";
	public static final String TOTRANSLATE_17_CODE="17";
	public static final String TOTRANSLATE_18_CODE="18";
	public static final String TOTRANSLATE_19_CODE="19";
	public static final String TOTRANSLATE_20_CODE="20";
	public static final String TOTRANSLATE_21_CODE="21";
	public static final String TOTRANSLATE_22_CODE="22";
	public static final String TOTRANSLATE_23_CODE="23";
	public static final String TOTRANSLATE_24_CODE="24";
	public static final String TOTRANSLATE_25_CODE="25";
	public static final String TOTRANSLATE_26_CODE="999";


	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.127.3.3.2013.1";
	public static final String CODE_SYSTEM_NAME="DefinedByEKIFAndEHealthSuisse";


	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code <br>
	 *      <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static RiscOfComplications getEnum(String code) {
		for (RiscOfComplications x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
	private String code;


	private String displayName;


	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instantiiert dieses Enum Object mittels eines Codes und einem Display Name</div>
	 *
	 *@param code <br>
	 *	<div class="de"> code</div>
	 * @param displayName <br>
	 *	<div class="de"> display name</div>
	 */
	private RiscOfComplications (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}


	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}


	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}


	/**
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}


	/**
	 * <div class="en">Gets the code system id.</div>
	 * <div class="de">Liefert die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}


	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}


	/**
	 * <div class="en">Gets the display name.</div>
	 * <div class="de">Liefert display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getdisplayName() {
		return displayName;
	}


	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets ist.</div>
	 *
	 *
	 * @param enumName <br>
	 *      <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden ist.</div>
	 *
	 * @param codeValue <br>
	 *      <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (RiscOfComplications x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}