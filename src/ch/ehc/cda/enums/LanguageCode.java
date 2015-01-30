package ch.ehc.cda.enums;

import java.util.Arrays;
import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Sprache</div>
*<div class="fr"></div>
*/
public enum LanguageCode {

	/** 
	*<div class="de">deutsch</div>
	*<div class="fr"></div>
	*/
	GERMAN ("de-CH", "german"),
	/** 
	*<div class="de">französisch</div>
	*<div class="fr"></div>
	*/
	FRENCH ("fr-CH", "french"),
	/** 
	*<div class="de">italienisch</div>
	*<div class="fr"></div>
	*/
	ITALIAN ("it-CH", "italian");
	public static final String GERMAN_CODE="de-CH";
	public static final String FRENCH_CODE="fr-CH";
	public static final String ITALIAN_CODE="it-CH";


	public static final String CODE_SYSTEM="ISO 3166";
	public static final String CODE_SYSTEM_NAME="";


	private String code;
	private String displayName;

	LanguageCode (String code, String displayName) {
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

	public CS getCS() {
		CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(code);
		return cs;
	}

	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}

	public boolean isInValueSet(String code) {
		for (LanguageCode x : values()) {
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