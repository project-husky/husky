/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.communication.ch.enums.vacd.v140;

import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.common.model.Code;
import org.husky.common.utils.XdsMetadataUtil;

/*
 *<div class="de">Dieser eindeutige Code definiert das Format des XDS Dokumentes. Zusammen mit dem epd_xds_mimeType, sollte es dem potentiellen Konsumenten genügend Informationen liefern, ob er in der Lage ist, das Dokument zu verarbeiten.</div>
 *<div class="fr"></div>
 */
public enum FormatCode implements ValueSetEnumInterface {

	/**
	 * <div class="de">eImpfdossier</div> <div class="fr"> </div>
	 * <div class="it"> </div>
	 */
	EIMPFDOSSIER(FormatCode.EIMPFDOSSIER_CODE, "eImpfdossier"),
	/**
	 * <div class="de">EPD Dokument</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	EPD_DOKUMENT(FormatCode.EPD_DOKUMENT_CODE, "EPD Dokument"),
	/**
	 * <div class="de">KOS Dokument</div> <div class="fr">KOS Document</div>
	 * <div class="it">KOS Document</div>
	 */
	KOS_DOKUMENT(FormatCode.KOS_DOKUMENT_CODE, "KOS Dokument");

	/**
	 * <div class="de">Code für eImpfdossier</div> <div class="fr">Code de
	 * </div> <div class="it">Code per </div>
	 */
	public static final String EIMPFDOSSIER_CODE = "urn:epd:2015:EPD_ImmunizationContent";

	/**
	 * <div class="de">Code für EPD Dokument</div>
	 */
	public static final String EPD_DOKUMENT_CODE = "urn:epd:2015:EPD_Basic_Document";

	/**
	 * <div class="de">Code für KOS Dokument</div> <div class="fr">Code de KOS
	 * Document</div> <div class="it">Code per KOS Document</div>
	 */
	public static final String KOS_DOKUMENT_CODE = "urn:ihe:rad:1.2.840.10008.5.1.4.1.1.88.59";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.9";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_formatCode";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static FormatCode getEnum(String code) {
		for (final FormatCode x : values()) {
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
			Enum.valueOf(FormatCode.class, enumName);
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
		for (final FormatCode x : values()) {
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
	private FormatCode(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the husky Code Object</div>
	 * <div class="de">Liefert das husky Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public Code getCode() {
		return new Code(CODE_SYSTEM_OID, code, displayName);
	}

	/**
	 * <div class="en">Gets the IPF Code Object</div> <div class="de">Liefert das
	 * IPF Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public org.openehealth.ipf.commons.ihe.xds.core.metadata.Code getIpfCode() {
		final var cmt = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Code();
		cmt.setSchemeName(getCodeSystemId());
		cmt.setCode(getCodeValue());
		cmt.setDisplayName(XdsMetadataUtil.createInternationalString(getDisplayName(), "de-ch"));
		return cmt;
	}

	@Override
	public String getCodeSystemId() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	@Override
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
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public String getDisplayName(LanguageCode languageCode) {
		return this.displayName;
	}

	@Override
	public String getValueSetId() {
		return null;
	}

	@Override
	public String getValueSetName() {
		return null;
	}
}
