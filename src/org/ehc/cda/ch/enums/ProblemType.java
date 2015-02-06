package org.ehc.cda.ch.enums;

import java.util.Arrays;

import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Wertebereich für Art des Problems (SNOMED CT; 2.16.840.1.113883.6.96)</div>
 *<div class="fr">Domaine de valeurs pour « Type du problème » (SNOMED CT; 2.16.840.1.113883.6.96)</div>
 */
public enum ProblemType {

	/** 
	 *<div class="de">Problem</div>
	 *<div class="fr">Problème</div>
	 */
	PROBLEM ("55607006", "Problem "),
	/** 
	 *<div class="de">Krankheit</div>
	 *<div class="fr">Maladie</div>
	 */
	CONDITION ("64572001", "Condition"),
	/** 
	 *<div class="de">Funktionale Einschränkung</div>
	 *<div class="fr">Limitation fonctionnelle</div>
	 */
	FUNCTIONAL_LIMITATION ("248536006", "Functional limitation "),
	/** 
	 *<div class="de">Diagnose</div>
	 *<div class="fr">Diagnostic</div>
	 */
	DIAGNOSIS ("282291009", "Diagnosis"),
	/** 
	 *<div class="de">Befund</div>
	 *<div class="fr">Résultat</div>
	 */
	FINDING ("404684003", "Finding "),
	/** 
	 *<div class="de">Beschwerde</div>
	 *<div class="fr">Plainte</div>
	 */
	COMPLAINT ("409586006", "Complaint "),
	/** 
	 *<div class="de">Symptom</div>
	 *<div class="fr">Symptôme</div>
	 */
	SYMPTOM ("418799008", "Symptom ");
	public static final String PROBLEM_CODE="55607006";
	public static final String CONDITION_CODE="64572001";
	public static final String FUNCTIONAL_LIMITATION_CODE="248536006";
	public static final String DIAGNOSIS_CODE="282291009";
	public static final String FINDING_CODE="404684003";
	public static final String COMPLAINT_CODE="409586006";
	public static final String SYMPTOM_CODE="418799008";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME="SNOMED CT";


	private String code;
	private String displayName;

	ProblemType (String code, String displayName) {
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
		for (ProblemType x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}