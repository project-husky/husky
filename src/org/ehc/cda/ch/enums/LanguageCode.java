package org.ehc.cda.ch.enums;

import java.util.Arrays;

import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

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
	public static LanguageCode getEnum(String code) {
		for (LanguageCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
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

	public CS getCS() {
		CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(code);
		return cs;
	}

	public String getdisplayName() {
		return displayName;
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

}