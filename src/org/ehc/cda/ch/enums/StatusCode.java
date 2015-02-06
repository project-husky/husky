package org.ehc.cda.ch.enums;

import java.util.Arrays;

import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Die Codes beschreiben die möglichen Zustände einer Aktion</div>
 *<div class="fr"></div>
 */
public enum StatusCode {

	/** 
	 *<div class="de">aktuell</div>
	 *<div class="fr"></div>
	 */
	NEW ("new", "new"),
	/** 
	 *<div class="de">aktiv</div>
	 *<div class="fr"></div>
	 */
	ACTIV ("active", "activ"),
	/** 
	 *<div class="de">erledigt</div>
	 *<div class="fr"></div>
	 */
	COMPLETED ("completed", "completed"),
	/** 
	 *<div class="de">abwartend</div>
	 *<div class="fr"></div>
	 */
	HELD ("held", "held"),
	/** 
	 *<div class="de">abgebrochen</div>
	 *<div class="fr"></div>
	 */
	CANCELLED ("cancelled", "cancelled"),
	/** 
	 *<div class="de">ausgesetzt</div>
	 *<div class="fr"></div>
	 */
	SUSPENDED ("suspended", "suspended"),
	/** 
	 *<div class="de">nicht mehr gewollt</div>
	 *<div class="fr"></div>
	 */
	ABORTED ("aborted", "aborted");
	public static final String NEW_CODE="new";
	public static final String ACTIV_CODE="active";
	public static final String COMPLETED_CODE="completed";
	public static final String HELD_CODE="held";
	public static final String CANCELLED_CODE="cancelled";
	public static final String SUSPENDED_CODE="suspended";
	public static final String ABORTED_CODE="aborted";


	public static final String CODE_SYSTEM="2.16.840.1.113883.5.14";
	public static final String CODE_SYSTEM_NAME="ActStatus";


	private String code;
	private String displayName;

	StatusCode (String code, String displayName) {
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
		for (StatusCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}