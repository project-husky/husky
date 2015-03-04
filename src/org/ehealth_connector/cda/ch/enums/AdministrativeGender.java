package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Das Geschlecht einer Person, welches für verwaltungstechnische Belange verwendet wird</div>
 *<div class="fr"></div>
 */
public enum AdministrativeGender {

	/** 
	 *<div class="de">Weiblich</div>
	 *<div class="fr"></div>
	 */
	FEMALE ("F", "Female"),
	/** 
	 *<div class="de">Männlich</div>
	 *<div class="fr"></div>
	 */
	MALE ("M", "Male"),
	/** 
	 *<div class="de">Undifferenziert</div>
	 *<div class="fr"></div>
	 */
	UNDIFFERENTIATED ("UN", "Undifferentiated");
	public static final String FEMALE_CODE="F";
	public static final String MALE_CODE="M";
	public static final String UNDIFFERENTIATED_CODE="UN";


	public static final String CODE_SYSTEM="2.16.840.1.113883.5.1";
	public static final String CODE_SYSTEM_NAME="AdministrativeGender";


	public static AdministrativeGender getEnum(String code) {
		for (AdministrativeGender x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
	private String code;

	private String displayName;

	AdministrativeGender (String code, String displayName) {
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
		for (AdministrativeGender x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}