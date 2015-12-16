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
package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.CodedMetadataEnumInterface;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/**
 * <div class="de">Dieses Attribut enthält demografische Daten des
 * Patienten.</div> <div class="fr"></div>
 */
public enum SourcePatientInfo implements CodedMetadataEnumInterface {

	/**
	 * <div class="de">mehrdeutig</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	AMBIGUOUS("A", "Ambiguous"), /**
									 * <div class="de">weiblich</div>
									 * <div class="fr">feminin</div>
									 * <div class="it">femminile</div>
									 */
	FEMALE("F", "Female"), /**
							 * <div class="de">männlich</div>
							 * <div class="fr">masculin</div>
							 * <div class="it">maschile</div>
							 */
	MALE("M", "Male"), /**
						 * <div class="de">nicht zutreffend</div>
						 * <div class="fr"></div> <div class="it"></div>
						 */
	NOT_APPLICABLE("N", "Not applicable"), /**
											 * <div class="de">andere</div>
											 * <div class="fr">autre</div>
											 * <div class="it">altri</div>
											 */
	OTHER("O", "Other"), /**
							 * <div class="de">unbekannt</div>
							 * <div class="fr">inconnu</div>
							 * <div class="it">ignoto</div>
							 */
	UNKNOWN("U", "Unknown");

	/**
	 * <div class="de">Code für mehrdeutig</div>
	 */
	public static final String AMBIGUOUS_CODE = "A";

	/**
	 * <div class="de">Code für weiblich</div> <div class="fr">Code de
	 * feminin</div> <div class="it">Code per femminile</div>
	 */
	public static final String FEMALE_CODE = "F";

	/**
	 * <div class="de">Code für männlich</div> <div class="fr">Code de
	 * masculin</div> <div class="it">Code per maschile</div>
	 */
	public static final String MALE_CODE = "M";

	/**
	 * <div class="de">Code für nicht zutreffend</div>
	 */
	public static final String NOT_APPLICABLE_CODE = "N";

	/**
	 * <div class="de">Code für andere</div> <div class="fr">Code de autre</div>
	 * <div class="it">Code per altri</div>
	 */
	public static final String OTHER_CODE = "O";

	/**
	 * <div class="de">Code für unbekannt</div> <div class="fr">Code de
	 * inconnu</div> <div class="it">Code per ignoto</div>
	 */
	public static final String UNKNOWN_CODE = "U";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.25";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_sourcePatientInfo";

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
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
	private SourcePatientInfo(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * 
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static SourcePatientInfo getEnum(String code) {
		for (final SourcePatientInfo x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
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
	 * <div class="en">Gets the OHT CodedMetadataType Object</div>
	 * <div class="de">Liefert das OHT CodedMetadataType Objekt</div>
	 * 
	 * @return <div class="en">the codedMetadataType</div>
	 */
	@Override
	public CodedMetadataType getCodedMetadataType() {
		final CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();
		cmt.setSchemeName(CODE_SYSTEM_OID);
		cmt.setCode(this.getCodeValue());
		cmt.setDisplayName(
				XdsMetadataUtil.createInternationalString(this.getDisplayName(), "de-ch"));
		return cmt;
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

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 * 
	 * 
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets
	 * vorhanden ist.</div>
	 * 
	 * @param codeValue
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (final SourcePatientInfo x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}