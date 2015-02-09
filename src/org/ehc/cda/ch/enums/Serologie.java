package org.ehc.cda.ch.enums;

import java.util.Arrays;

import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
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
	public static Serologie getEnum(String code) {
		for (Serologie x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
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

	Serologie (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
		return ehcCode;
	}

	public String getCodeSystemId() {
		return CODE_SYSTEM;
	}

	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	public String getCodeValue() {
		return code;
	}

	public String getdisplayName() {
		return displayName;
	}

	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}
	public boolean isInValueSet(String code) {
		for (Serologie x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}