package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Wertebereich für Schweregrad (HL7 SeverityObservation; 2.16.840.1.113883.5.1063)</div>
 *<div class="fr">Domaine de valeurs pour « Score de sévérité » (HL7 SeverityObservation; 2.16.840.1.113883.5.1063)</div>
 */
public enum Severity {

	/** 
	 *<div class="de">Hoher Schweregrad</div>
	 *<div class="fr">Score de sévérité élevé</div>
	 */
	HIGH_SEVERITY ("H", "high severity"),
	/** 
	 *<div class="de">Mittlerer Schweregrad</div>
	 *<div class="fr">Score de sévérité moyen</div>
	 */
	MODERATE_SEVERITY ("M", "moderate severity"),
	/** 
	 *<div class="de">Leichter Schweregrad</div>
	 *<div class="fr">Score de sévérité bas</div>
	 */
	LOW_SEVERITY ("L", "low severity");
	public static final String HIGH_SEVERITY_CODE="H";
	public static final String MODERATE_SEVERITY_CODE="M";
	public static final String LOW_SEVERITY_CODE="L";


	public static final String CODE_SYSTEM="2.16.840.1.113883.5.1063";
	public static final String CODE_SYSTEM_NAME="HL7 SeverityObservation";


	public static Severity getEnum(String code) {
		for (Severity x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
	private String code;

	private String displayName;

	Severity (String code, String displayName) {
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
		for (Severity x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}