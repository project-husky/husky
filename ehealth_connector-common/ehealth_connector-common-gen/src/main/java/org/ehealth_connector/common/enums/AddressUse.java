/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.common.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.PostalAddressUse;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

/*
 *<div class="de">Nutzungszweck von Adressen und Kommunikationsmitteln gemäss HL7 Vocabulary TelecommunicationAddressUse [2.16.840.1.113883.1.11.201] und AddressUse [2.16.840.1.113883.5.1119] Wichtigste für die Schweiz: Private (Privat;HP), Business(Geschäft;WP), Mobil(Mobile;MC)</div>
 *<div class="fr"></div>
 */
/**
 * <div class="de">Enum AddressUse.</div> <div class="fr">Enum AddressUse.</div>
 * <div class="it">Enum AddressUse.</div>
 */
public enum AddressUse {

	/** <div class="de">Geschäft</div> <div class="fr"></div>. */
	BUSINESS("WP", "Business"),

	/** <div class="de">Mobil</div> <div class="fr"></div>. */
	MOBILE("MC", "Mobile"),

	/** <div class="de">Privat</div> <div class="fr"></div>. */
	PRIVATE("HP", "Private"),

	/** <div class="de">Öffentlich</div> <div class="fr"></div>. */
	PUBLIC("PUB", "Public");

	/** The Constant BUSINESS_CODE. */
	public static final String BUSINESS_CODE = "WP";

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "AddressUse";

	/** The Constant CODE_SYSTEM. */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1119";

	/** The Constant MOBILE_CODE. */
	public static final String MOBILE_CODE = "MC";

	/** The Constant PRIVATE_CODE. */
	public static final String PRIVATE_CODE = "HP";

	/** The Constant PUBLIC_CODE. */
	public static final String PUBLIC_CODE = "PUB";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static AddressUse getEnum(String code) {
		for (final AddressUse x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(AddressUse.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de">code</div>
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (AddressUse x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	private String code;

	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	AddressUse(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the address use as postal address use.</div>
	 * <div class="de">Liefert address use as postal address use.</div>
	 *
	 * @return <div class="en">the address use as postal address use</div>
	 */
	public PostalAddressUse getAddressUseAsPostalAddressUse() {
		PostalAddressUse retVal = null;
		switch (this) {
		case PRIVATE:
			retVal = PostalAddressUse.HP;
			break;
		case BUSINESS:
			retVal = PostalAddressUse.WP;
			break;
		case MOBILE:
			retVal = PostalAddressUse.TMP;
			break;
		default:
			retVal = PostalAddressUse.HP;
		}
		return retVal;
	}

	// Special for this enum: Return the Use Code in different HL7 enum types
	/**
	 * <div class="en">Gets the address use as telecommunication address
	 * use.</div> <div class="de">Liefert address use as telecommunication
	 * address use.</div>
	 *
	 * @return <div class="en">the address use as telecommunication address
	 *         use</div>
	 */
	public TelecommunicationAddressUse getAddressUseAsTelecommunicationAddressUse() {
		TelecommunicationAddressUse retVal = null;
		switch (this) {
		case PRIVATE:
			retVal = TelecommunicationAddressUse.HP;
			break;
		case BUSINESS:
			retVal = TelecommunicationAddressUse.WP;
			break;
		case MOBILE:
			retVal = TelecommunicationAddressUse.MC;
			break;
		case PUBLIC:
			retVal = TelecommunicationAddressUse.PUB;
			break;
		default:
			retVal = TelecommunicationAddressUse.HP;
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CODE_SYSTEM_OID);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return displayName;
	}
}
