package org.ehc.cda.ch.enums;

import java.util.Arrays;

import org.ehc.common.Code;
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


	private String code;
	private String displayName;

	HistoryOfPastIllness (String code, String displayName) {
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
		for (HistoryOfPastIllness x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}