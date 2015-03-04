package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.PostalAddressUse;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

/*
 *<div class="de">Nutzungszweck von Adressen und Kommunikationsmitteln gemäss HL7 Vocabulary TelecommunicationAddressUse [2.16.840.1.113883.1.11.201] und AddressUse [2.16.840.1.113883.5.1119] Wichtigste für die Schweiz: Private (Privat;HP), Business(Geschäft;WP), Mobil(Mobile;MC)</div>
 *<div class="fr"></div>
 */
public enum AddressUse {

	/** 
	 *<div class="de">Privat</div>
	 *<div class="fr"></div>
	 */
	PRIVATE ("HP", "Private"),
	/** 
	 *<div class="de">Geschäft</div>
	 *<div class="fr"></div>
	 */
	BUSINESS ("WP", "Business"),
	/** 
	 *<div class="de">Mobil</div>
	 *<div class="fr"></div>
	 */
	MOBILE ("MC", "Mobile");
	public static final String PRIVATE_CODE="HP";
	public static final String BUSINESS_CODE="WP";
	public static final String MOBILE_CODE="MC";


	public static final String CODE_SYSTEM="2.16.840.1.113883.5.1119";
	public static final String CODE_SYSTEM_NAME="AddressUse";


	public static AddressUse getEnum(String code) {
		for (AddressUse x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
	private String code;

	private String displayName;

	AddressUse (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public PostalAddressUse getAddressUseAsPostalAddressUse () {
		switch (this) {
		case PRIVATE:
			return PostalAddressUse.HP;
		case BUSINESS:
			return PostalAddressUse.WP;
		case MOBILE:
			return PostalAddressUse.TMP;
		default:
			return PostalAddressUse.HP;
		}
	}

	//Special for this enum: Return the Use Code in different HL7 enum types
	public TelecommunicationAddressUse getAddressUseAsTelecommunicationAddressUse () {
		switch (this) {
		case PRIVATE:
			return TelecommunicationAddressUse.HP;
		case BUSINESS:
			return TelecommunicationAddressUse.WP;
		case MOBILE:
			return TelecommunicationAddressUse.MC;
		default:
			return TelecommunicationAddressUse.HP;
		}
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
		for (AddressUse x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}
}