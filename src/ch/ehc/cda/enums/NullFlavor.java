package ch.ehc.cda.enums;

import java.util.Arrays;
import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Codesystem: HL7 nullFlavor Tabelle (OID: 2.16.840.1.113883.5.1008). Dieses Subset ist für den vorliegenden Implementierungsleitfaden abschliessend. Andere Codes sind NICHT ERLAUBT.</div>
*<div class="fr">Source du sous-ensemble : [IHE PCC TF-2],Table 6.3.4.16.7-1</div>
*/
public enum NullFlavor {

	/** 
	*<div class="de">Gefragt, aber keine Antwort erhalten</div>
	*<div class="fr">Question posée, mais aucune réponse reçue</div>
	*/
	ASKED_BUT_UNKNOWN ("ASKU", "asked but unknown"),
	/** 
	*<div class="de">Patient wünscht keine Weitergabe dieser Information</div>
	*<div class="fr">Le patient ne souhaite pas que cette information soit transmise.</div>
	*/
	MASKED ("MSK", "masked"),
	/** 
	*<div class="de">Nicht gefragt</div>
	*<div class="fr">Non demandé</div>
	*/
	NOT_ASKED ("NASK", "not asked"),
	/** 
	*<div class="de">Vorübergehend unbekannt, wird später ausgefüllt</div>
	*<div class="fr">Actuellement non connu, sera rempli plus tard.</div>
	*/
	TEMPORARILY_UNAVAILABLE ("NAV", "temporarily unavailable"),
	/** 
	*<div class="de">Unbekannt, ohne weitere Präzisierung</div>
	*<div class="fr">Non connu, sans autre précision</div>
	*/
	UNKNOWN ("UNK", "unknown");
	public static final String ASKED_BUT_UNKNOWN_CODE="ASKU";
	public static final String MASKED_CODE="MSK";
	public static final String NOT_ASKED_CODE="NASK";
	public static final String TEMPORARILY_UNAVAILABLE_CODE="NAV";
	public static final String UNKNOWN_CODE="UNK";


	public static final String CODE_SYSTEM="2.16.840.1.113883.5.1008";
	public static final String CODE_SYSTEM_NAME="HL7 nullFlavor ";


	private String code;
	private String displayName;

	NullFlavor (String code, String displayName) {
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
		for (NullFlavor x : values()) {
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