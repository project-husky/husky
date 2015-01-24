package ch.ehc.cda.enums;

import java.util.Arrays;
import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Quelle für Subset: [IHE PCC TF-2], 6.3.4.14.11</div>
*<div class="fr">Source du sous-ensemble : [IHE PCC TF-2], 6.3.4.14.11</div>
*/
public enum AllergiesSpecialConditions {

	/** 
	*<div class="de">Patient hat Allergie/Unverträglichkeit auf eine unbekannte Substanz</div>
	*<div class="fr">Le patient présente une allergie/intolérance à une substance inconnue.</div>
	*/
	SUBSTANCE_TYPE_UNKNOWN ("64970000", "Substance Type Unknown"),
	/** 
	*<div class="de">Keine Allergien bekannt</div>
	*<div class="fr">Aucune allergie connue</div>
	*/
	NO_KNOWN_ALLERGIES ("160244002", "No Known Allergies"),
	/** 
	*<div class="de">Keine Unverträglichkeiten von Medikamenten bekannt</div>
	*<div class="fr">Aucune intolérance à des médicaments connue</div>
	*/
	NO_KNOWN_DRUG_ALLERGIES ("409137002", "No Known Drug Allergies");
	public static final String SUBSTANCE_TYPE_UNKNOWN_CODE="64970000";
	public static final String NO_KNOWN_ALLERGIES_CODE="160244002";
	public static final String NO_KNOWN_DRUG_ALLERGIES_CODE="409137002";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME="SNOMED CT";


	private String code;
	private String displayName;

	AllergiesSpecialConditions (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public String getCodeValue() {
		return this.code;
	}

	public String getdisplayName() {
		return this.displayName;
	}

	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
		return ehcCode;
	}

	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}

	public boolean isInValueSet(String code) {
		for (AllergiesSpecialConditions x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public String getCodeSystemId() {
		return CODE_SYSTEM;
	}
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

}