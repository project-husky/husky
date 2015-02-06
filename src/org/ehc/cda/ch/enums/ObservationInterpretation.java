package org.ehc.cda.ch.enums;

import java.util.Arrays;

import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Codesystem: HL7 ObservationInterpretation (OID: 2.16.840.1.113883.5.83). Das folgende Subset (siehe auch OID 2.16.756.5.30.1.127.3.2.20121101.3) ist für den vorliegenden Implementierungsleitfaden abschliessend. Andere Codes sind NICHT ERLAUBT.</div>
 *<div class="fr">Domaine de valeurs pour « Code dinterprétation »</div>
 */
public enum ObservationInterpretation {

	/** 
	 *<div class="de">Positiv Erreger in Probe nachgewiesen</div>
	 *<div class="fr">Positif: Agent pathogène dépisté dans l’échantillon</div>
	 */
	POSITIVE_PATHOGEN_FOUND_IN_SPECIMEN ("POS", "Positive: Pathogen found in specimen"),
	/** 
	 *<div class="de">Negativ: Erreger konnte in Probe nicht nachgewiesen werden</div>
	 *<div class="fr">Négatif: L’agent pathogène n’a pas pu être dépisté dans l’échantillon</div>
	 */
	NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN ("NEG", "Negative: Pathogen couldn't be determined in speci-men");
	public static final String POSITIVE_PATHOGEN_FOUND_IN_SPECIMEN_CODE="POS";
	public static final String NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN_CODE="NEG";


	public static final String CODE_SYSTEM="2.16.840.1.113883.5.83";
	public static final String CODE_SYSTEM_NAME="HL7 ObservationInterpretation ";


	private String code;
	private String displayName;

	ObservationInterpretation (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public CE getCE() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CODE_SYSTEM);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
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
		for (ObservationInterpretation x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}