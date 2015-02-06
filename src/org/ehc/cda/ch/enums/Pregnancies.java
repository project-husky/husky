package org.ehc.cda.ch.enums;

import java.util.Arrays;

import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus [IHE PCC TF-2], Kapitel 6.3.4.25.4 dürfen ebenfalls verwendet werden. (Quelle für Sub-set: [IHE PCC TF-2], 6.3.4.25.4)</div>
 *<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés du chapitre 6.3.4.25.4 [IHE PCC TF-2]. (Source du sous-ensemble : [IHE PCC TF-2], 6.3.4.25.4)</div>
 */
public enum Pregnancies {

	/** 
	 *<div class="de">Entbindungsdatum (klinische Schätzung)</div>
	 *<div class="fr">Date de l’accouchement (estimation clinique)</div>
	 */
	DELIVERY_DATE_CLINICAL_ESTIMATE ("11778-8", "DELIVERY DATE (CLINICAL ESTIMATE)");
	public static final String DELIVERY_DATE_CLINICAL_ESTIMATE_CODE="11778-8";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.1";
	public static final String CODE_SYSTEM_NAME="LOINC";


	private String code;
	private String displayName;

	Pregnancies (String code, String displayName) {
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
		for (Pregnancies x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}