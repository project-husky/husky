package org.ehealth_connector.cda.enums.epsos;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Bezeichnung der Blutgruppe</div>
*<div class="fr"></div>
*/
public enum BloodGroup {

	/**
	 * <div class="en">blood group 0</div> <div class="de">0</div>
	 */
	BLOOD_GROUP_0("58460004", "blood group 0"),
	/**
	 * <div class="en">blood group 0 Rh(D) negative</div> <div class="de">0
	 * neg</div>
	 */
	BLOOD_GROUP_0_RHD_NEGATIVE("278148006", "blood group 0 Rh(D) negative"),
	/**
	 * <div class="en">blood group 0 Rh(D) positive</div> <div class="de">0
	 * pos</div>
	 */
	BLOOD_GROUP_0_RHD_POSITIVE("278147001", "blood group 0 Rh(D) positive"),
	/**
	 * <div class="en">blood group A</div> <div class="de">A</div>
	 */
	BLOOD_GROUP_A("112144000", "blood group A"),
	/**
	 * <div class="en">blood group A Rh(D) negative</div> <div class="de">A
	 * neg</div>
	 */
	BLOOD_GROUP_A_RHD_NEGATIVE("278152006", "blood group A Rh(D) negative"),
	/**
	 * <div class="en">blood group A Rh(D) positive</div> <div class="de">A
	 * pos</div>
	 */
	BLOOD_GROUP_A_RHD_POSITIVE("278149003", "blood group A Rh(D) positive"),
	/**
	 * <div class="en">blood group AB</div> <div class="de">AB</div>
	 */
	BLOOD_GROUP_AB("165743006", "blood group AB"),
	/**
	 * <div class="en">blood group AB Rh(D) negative</div> <div class="de">AB
	 * pos</div>
	 */
	BLOOD_GROUP_AB_RHD_NEGATIVE("278154007", "blood group AB Rh(D) negative"),
	/**
	 * <div class="en">blood group AB Rh(D) positive</div> <div class="de">AB
	 * neg</div>
	 */
	BLOOD_GROUP_AB_RHD_POSITIVE("278151004", "blood group AB Rh(D) positive"),
	/**
	 * <div class="en">blood group B</div> <div class="de">B</div>
	 */
	BLOOD_GROUP_B("112149005", "blood group B"),
	/**
	 * <div class="en">blood group B Rh(D) negative</div> <div class="de">B
	 * neg</div>
	 */
	BLOOD_GROUP_B_RHD_NEGATIVE("278153001", "blood group B Rh(D) negative"),
	/**
	 * <div class="en">blood group B Rh(D) positive</div> <div class="de">B
	 * pos</div>
	 */
	BLOOD_GROUP_B_RHD_POSITIVE("278150003", "blood group B Rh(D) positive");

	/**
	 * <div class="en">Code for blood group 0</div> <div class="de">Code für
	 * 0</div>
	 */
	public static final String BLOOD_GROUP_0_CODE = "58460004";

	/**
	 * <div class="en">Code for blood group 0 Rh(D) negative</div>
	 * <div class="de">Code für 0 neg</div>
	 */
	public static final String BLOOD_GROUP_0_RHD_NEGATIVE_CODE = "278148006";

	/**
	 * <div class="en">Code for blood group 0 Rh(D) positive</div>
	 * <div class="de">Code für 0 pos</div>
	 */
	public static final String BLOOD_GROUP_0_RHD_POSITIVE_CODE = "278147001";

	/**
	 * <div class="en">Code for blood group A</div> <div class="de">Code für
	 * A</div>
	 */
	public static final String BLOOD_GROUP_A_CODE = "112144000";

	/**
	 * <div class="en">Code for blood group A Rh(D) negative</div>
	 * <div class="de">Code für A neg</div>
	 */
	public static final String BLOOD_GROUP_A_RHD_NEGATIVE_CODE = "278152006";

	/**
	 * <div class="en">Code for blood group A Rh(D) positive</div>
	 * <div class="de">Code für A pos</div>
	 */
	public static final String BLOOD_GROUP_A_RHD_POSITIVE_CODE = "278149003";

	/**
	 * <div class="en">Code for blood group AB</div> <div class="de">Code für
	 * AB</div>
	 */
	public static final String BLOOD_GROUP_AB_CODE = "165743006";

	/**
	 * <div class="en">Code for blood group AB Rh(D) negative</div>
	 * <div class="de">Code für AB pos</div>
	 */
	public static final String BLOOD_GROUP_AB_RHD_NEGATIVE_CODE = "278154007";

	/**
	 * <div class="en">Code for blood group AB Rh(D) positive</div>
	 * <div class="de">Code für AB neg</div>
	 */
	public static final String BLOOD_GROUP_AB_RHD_POSITIVE_CODE = "278151004";

	/**
	 * <div class="en">Code for blood group B</div> <div class="de">Code für
	 * B</div>
	 */
	public static final String BLOOD_GROUP_B_CODE = "112149005";

	/**
	 * <div class="en">Code for blood group B Rh(D) negative</div>
	 * <div class="de">Code für B neg</div>
	 */
	public static final String BLOOD_GROUP_B_RHD_NEGATIVE_CODE = "278153001";

	/**
	 * <div class="en">Code for blood group B Rh(D) positive</div>
	 * <div class="de">Code für B pos</div>
	 */
	public static final String BLOOD_GROUP_B_RHD_POSITIVE_CODE = "278150003";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epSOSBloodGroup";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "1.3.6.1.4.1.12559.11.10.1.3.1.42.20";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static BloodGroup getEnum(String code) {
		for (BloodGroup x : values()) {
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
	 *
	 * @param enumName
	 *          <br>
	 *          <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(BloodGroup.class, enumName);
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
	 *          <br>
	 *          <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (BloodGroup x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	protected String code;

	/**
	 * <div class="en">Human readable name</div> <div class="de">Menschenlesbarer
	 * Name</div>
	 */
	protected String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display
	 * Name</div> <div class="de">Instantiiert dieses Enum Object mittels eines
	 * Codes und einem Display Name</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
	 * @param displayName
	 *          <br>
	 *          <div class="de"> display name</div>
	 */
	private BloodGroup(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
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
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
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
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert die
	 * code system id.</div>
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
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}

}