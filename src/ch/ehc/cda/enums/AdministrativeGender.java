package ch.ehc.cda.enums;

import java.util.Arrays;
import org.ehc.common.Code;
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


	private String code;
	private String displayName;

	AdministrativeGender (String code, String displayName) {
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

	public CE getCE() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CODE_SYSTEM);
		ce.setCode(code);
		return ce;
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

	public String getCodeSystemId() {
		return CODE_SYSTEM;
	}
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

}