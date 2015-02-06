package org.ehc.cda.ch.enums;

import java.util.Arrays;
import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Quelle für Subset: [IHE PCC TF-2], 6.3.4.14.11</div>
*<div class="fr">Source du sous-ensemble : [IHE PCC TF-2], 6.3.4.14.11</div>
*/
public enum ProblemsSpecialConditions {

	/** 
	*<div class="de">Keine relevante Anamnese</div>
	*<div class="fr">Aucune anamnèse pertinente</div>
	*/
	NO_SIGNIFICANT_MEDICAL_HISTORY ("160243008", "No Significant Medical History"),
	/** 
	*<div class="de">Patient hat keine aktuellen Probleme</div>
	*<div class="fr">Aucun problème actuel</div>
	*/
	NO_CURRENT_PROBLEMS_OR_DISABILITY ("160245001", "No current problems or disability"),
	/** 
	*<div class="de">Keine Anamnese bekannt</div>
	*<div class="fr">Aucune anamnèse connue</div>
	*/
	HISTORY_OF_PAST_ILLNESS_UNKNOWN ("396782006", "History of Past Illness unknown"),
	/** 
	*<div class="de">Keine Familienanamnese bekannt</div>
	*<div class="fr">Aucun antécédent familial connu</div>
	*/
	FAMILY_HISTORY_UNKNOWN ("407559004", "Family History Unknown");
	public static final String NO_SIGNIFICANT_MEDICAL_HISTORY_CODE="160243008";
	public static final String NO_CURRENT_PROBLEMS_OR_DISABILITY_CODE="160245001";
	public static final String HISTORY_OF_PAST_ILLNESS_UNKNOWN_CODE="396782006";
	public static final String FAMILY_HISTORY_UNKNOWN_CODE="407559004";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME="SNOMED CT";


	private String code;
	private String displayName;

	ProblemsSpecialConditions (String code, String displayName) {
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
		for (ProblemsSpecialConditions x : values()) {
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