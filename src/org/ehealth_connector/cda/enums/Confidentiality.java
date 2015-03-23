/********************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 ********************************************************************************/

package org.ehealth_connector.cda.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Vertraulichkeit</div>
 *<div class="fr"></div>
 */
public enum Confidentiality {

	/**
	 * <div class="de">Streng vertraulich</div> <div class="fr"></div>
	 */
	VERY_RESTRICTED("VR", "Very restricted"),
	/**
	 * <div class="de">Vertraulich</div> <div class="fr"></div>
	 */
	RESTRICED("R", "Restriced"),
	/**
	 * <div class="de">Normal</div> <div class="fr"></div>
	 */
	NORMAL("N", "Normal");
	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static Confidentiality getEnum(String code) {
		for (Confidentiality x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	public static final String VERY_RESTRICTED_CODE = "VR";
	public static final String RESTRICED_CODE = "R";

	public static final String NORMAL_CODE = "N";
	public static final String CODE_SYSTEM = "2.16.840.1.113883.5.25";

	public static final String CODE_SYSTEM_NAME = "Confidentiality";
	private String code;

	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div>
	 */
	Confidentiality(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CODE_SYSTEM);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemId() {
		return CODE_SYSTEM;
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
	 * <div class="en">Gets the actual Code as string</div> <div
	 * class="de">Liefert den eigentlichen Code als String</div>
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
	public String getdisplayName() {
		return this.displayName;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumStr
	 * <br>
	 *            <div class="de"> enum str</div>
	 * @return true, if is enum of value set
	 */
	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}

	/**
	 * <div class="en">Checks if a given code is in this value set.</div> <div
	 * class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden
	 * ist.</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String code) {
		for (Confidentiality x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}