package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere LOINC Codes dürfen ebenfalls verwendet werden.</div>
*<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés LOINC.</div>
*/
public enum Serologie {

	/** 
	*<div class="de">Windpocken</div>
	*<div class="fr">Varicelle</div>
	*/
	VARICELLA_ZOSTER_VIRUS_AB_IGG ("22602-7", "Varicella zoster virus Ab.IgG"),
	/** 
	*<div class="de">Masern</div>
	*<div class="fr">Rougeole</div>
	*/
	MEASLES_VIRUS_AB_IGG ("22502-9", "Measles virus Ab.IgG"),
	/** 
	*<div class="de">Mumps</div>
	*<div class="fr">Oreillons</div>
	*/
	MUMPS_VIRUS_AB_IGG ("22417-0", "Mumps virus Ab.IgG"),
	/** 
	*<div class="de">Röteln</div>
	*<div class="fr">Rubéole</div>
	*/
	RUBELLA_VIRUS_AB_IGG ("41763-4", "Rubella virus Ab.IgG"),
	/** 
	*<div class="de">Hepatitis A</div>
	*<div class="fr">Hépatite A</div>
	*/
	HEPATITIS_A_VIRUS_AB_IGG ("22313-1", "Hepatitis A virus Ab.IgG"),
	/** 
	*<div class="de">Hepatitis B</div>
	*<div class="fr">Hépatite B</div>
	*/
	HEPATITIS_B_VIRUS_SURFACE_AB_IGG ("16935-9", "Hepatitis B virus surface Ab.IgG"),
	/** 
	*<div class="de">FSME</div>
	*<div class="fr">Encéphalite à tiques</div>
	*/
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB ("26061-2", "European tick borne encephalitis virus Ab"),
	/** 
	*<div class="de">Gelbfieber</div>
	*<div class="fr">Fièvre jaune</div>
	*/
	YELLOW_FEVER_VIRUS_AB ("6589-6", "Yellow fever virus Ab"),
	/** 
	*<div class="de">Tetanus</div>
	*<div class="fr">Tétanos</div>
	*/
	CLOSTRIDIUM_TETANI_TOXIN_AB_IGG ("58770-9", "Clostridium tetani toxin Ab.IgG");
	public static final String VARICELLA_ZOSTER_VIRUS_AB_IGG_CODE="22602-7";
	public static final String MEASLES_VIRUS_AB_IGG_CODE="22502-9";
	public static final String MUMPS_VIRUS_AB_IGG_CODE="22417-0";
	public static final String RUBELLA_VIRUS_AB_IGG_CODE="41763-4";
	public static final String HEPATITIS_A_VIRUS_AB_IGG_CODE="22313-1";
	public static final String HEPATITIS_B_VIRUS_SURFACE_AB_IGG_CODE="16935-9";
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB_CODE="26061-2";
	public static final String YELLOW_FEVER_VIRUS_AB_CODE="6589-6";
	public static final String CLOSTRIDIUM_TETANI_TOXIN_AB_IGG_CODE="58770-9";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.1";
	public static final String CODE_SYSTEM_NAME="LOINC";


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
	Serologie (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

 
	/**
	* <div class="en">Gets the actual Code as string</div>
	* <div class="de">Liefert den eigentlichen Code als String</div>
	*
	* @return <div class="en">the code</div>
	*/
	public String getCodeValue() {
		return this.code;
	}


	/**
	* <div class="en">Gets the display name.</div>
	* <div class="de">Liefert display name.</div>
	*
	* @return <div class="en">the display name</div>
	*/
	public String getdisplayName() {
		return this.displayName;
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
	* <div class="en">Gets the Enum with a given code</div>
	* <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	*
	* @param code <br>
	*      <div class="de"> code</div>
	* @return <div class="en">the enum</div>
	*/
	public static Serologie getEnum(String code) {
		for (Serologie x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

  
	/**
	* <div class="en">Checks if a given enum is part of this value set.</div>
	* <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets ist.</div>
	*
	*
	* @param enumStr <br>
	*      <div class="de"> enum str</div>
	* @return true, if is enum of value set
	*/
	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}


	/**
	* <div class="en">Checks if a given code is in this value set.</div>
	* <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden ist.</div>
	*
	* @param code <br>
	*      <div class="de"> code</div>
	* @return true, if is in value set
	*/
	public boolean isInValueSet(String code) {
		for (Serologie x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}


	/**
	* <div class="en">Gets the code system id.</div>
	* <div class="de">Liefert die code system id.</div>
	*
	* @return <div class="en">the code system id</div>
	*/
	public String getCodeSystemId() {
		return CODE_SYSTEM;
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

}