package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus den, in Kapitel 7.5.2.4 Spezifikation CDA Body Level 3  Problem Entry auf Seite 53 genannten Codesystemen dürfen ebenfalls verwendet werden. Hinweis: es handelt sich hier um durchgemachte Erkrankungen, die einen Immunschutz zur Folge haben.</div>
 *<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés des systèmes de codes mentionnés au cha-pitre 7.5.2.4 « Spécification CDA Body Level 3  Problem Entry » à la page 53. Remarque : il sagit ici d'antécédents médicaux ayant été à lorigine dune protection immunitaire.</div>
 */
public enum HistoryOfPastIllness {

	/** 
	 *<div class="de">Windpocken</div>
	 *<div class="fr">Varicelle</div>
	 */
	HO_CHICKENPOX ("38907003", "H/O: chickenpox"),
	/** 
	 *<div class="de">Masern</div>
	 *<div class="fr">Rougeole</div>
	 */
	HO_MEASLES ("14189004", "H/O: measles"),
	/** 
	 *<div class="de">Mumps</div>
	 *<div class="fr">Oreillons</div>
	 */
	HO_MUMPS ("36989005", "H/O: mumps"),
	/** 
	 *<div class="de">Röteln</div>
	 *<div class="fr">Rubéole</div>
	 */
	HO_RUBELLA ("36653000", "H/O: rubella"),
	/** 
	 *<div class="de">Hepatitis A</div>
	 *<div class="fr">Hépatite A</div>
	 */
	HEPATITIS_A ("40468003", "Hepatitis A"),
	/** 
	 *<div class="de">Hepatitis B</div>
	 *<div class="fr">Hépatite B</div>
	 */
	HEPATITIS_B ("66071002", "Hepatitis B"),
	/** 
	 *<div class="de">FSM</div>
	 *<div class="fr">Encéphalite à tiques</div>
	 */
	CENTRAL_EUROPEAN_ENCEPHALITIS ("16901001", "Central European encephalitis"),
	/** 
	 *<div class="de">Gelbfieber</div>
	 *<div class="fr">Fièvre jaune</div>
	 */
	YELLOW_FEVER ("16541001", "Yellow Fever"),
	/** 
	 *<div class="de">Tetanus</div>
	 *<div class="fr">Tétanos</div>
	 */
	TETANUS ("76902006", "Tetanus");
	public static final String HO_CHICKENPOX_CODE="38907003";
	public static final String HO_MEASLES_CODE="14189004";
	public static final String HO_MUMPS_CODE="36989005";
	public static final String HO_RUBELLA_CODE="36653000";
	public static final String HEPATITIS_A_CODE="40468003";
	public static final String HEPATITIS_B_CODE="66071002";
	public static final String CENTRAL_EUROPEAN_ENCEPHALITIS_CODE="16901001";
	public static final String YELLOW_FEVER_CODE="16541001";
	public static final String TETANUS_CODE="76902006";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME="SNOMED CT";


	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code <br>
	 *      <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static HistoryOfPastIllness getEnum(String code) {
		for (HistoryOfPastIllness x : values()) {
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
	HistoryOfPastIllness (String code, String displayName) {
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
		cd.setCodeSystem(CODE_SYSTEM);
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
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
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
		return CODE_SYSTEM;
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
	 * @param code <br>
	 *      <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (HistoryOfPastIllness x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}