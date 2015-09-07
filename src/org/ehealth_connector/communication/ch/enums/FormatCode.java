package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/*
*<div class="de">Dieser eindeutige Code definiert das Format des XDS Dokumentes. Zusammen mit dem epd_xds_mimeType, sollte es dem potentiellen Konsumenten genügend Informationen liefern, ob er in der Lage ist, das Dokument zu verarbeiten.</div>
*<div class="fr"></div>
*/
public enum FormatCode implements CodedMetadataEnumInterface {

	/** 
	*<div class="de">EPD Dokument</div>
	*<div class="fr"></div>
	*<div class="it"></div>
	*/
	EPD_DOKUMENT ("urn:epd:2015:EPD_Basic_Document", "EPD Dokument"),
	/** 
	*<div class="de">eImpfdossier</div>
	*<div class="fr"> </div>
	*<div class="it"> </div>
	*/
	EIMPFDOSSIER ("urn:epd:2015:EPD_Immunization Content", "eImpfdossier"),
	/** 
	*<div class="de">KOS Dokument</div>
	*<div class="fr">KOS Document</div>
	*<div class="it">KOS Document</div>
	*/
	KOS_DOKUMENT ("urn:ihe:rad:1.2.840.10008.5.1.4.1.1.88.59", "KOS Dokument");
	public static final String EPD_DOKUMENT_CODE="urn:epd:2015:EPD_Basic_Document";
	public static final String EIMPFDOSSIER_CODE="urn:epd:2015:EPD_Immunization Content";
	public static final String KOS_DOKUMENT_CODE="urn:ihe:rad:1.2.840.10008.5.1.4.1.1.88.59";


	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.127.3.10.1.9";
	public static final String CODE_SYSTEM_NAME="epd_xds_formatCode";


	protected String code;
	protected String displayName;

	
	/**
	* <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	* <div class="de">Instantiiert dieses Enum Object mittels eines Codes und einem Display Name</div>
	*
	*@param code <br>
	*	<div class="de"> code</div>
	* @param displayName <br>
	*	<div class="de"> display name</div>
	*/
	private FormatCode (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
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
	* <div class="en">Gets the display name.</div>
	* <div class="de">Liefert display name.</div>
	*
	* @return <div class="en">the display name</div>
	*/
	public String getdisplayName() {
		return this.displayName;
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
	* <div class="en">Gets the OHT CodedMetadataType Object</div>
	* <div class="de">Liefert das OHT CodedMetadataType Objekt</div>
	*
	* @return <div class="en">the codedMetadataType</div>
	*/
	public CodedMetadataType getCodedMetadataType() {
		CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();
		cmt.setSchemeName(CODE_SYSTEM_OID);
		cmt.setCode(this.getCodeValue());
		cmt.setDisplayName(XdsUtil.createInternationalString(this.getdisplayName(), "de-ch"));
		return cmt;
	}

 
	/**
	* <div class="en">Gets the Enum with a given code</div>
	* <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	*
	* @param code <br>
	*      <div class="de"> code</div>
	* @return <div class="en">the enum</div>
	*/
	public static FormatCode getEnum(String code) {
		for (FormatCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

  
	/**
	* <div class="en">Checks if a given enum is part of this value set.</div>
	* <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets ist.</div>
	*
	*
	* @param enumName <br>
	*      <div class="de"> enumName</div>
	* @return true, if enum is in this value set
	*/
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}


	/**
	* <div class="en">Checks if a given code value is in this value set.</div>
	* <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden ist.</div>
	*
	* @param codeValue <br>
	*      <div class="de"> code</div>
	* @return true, if is in value set
	*/
	public boolean isInValueSet(String codeValue) {
		for (FormatCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}


	/**
	* <div class="en">Gets the code system id.</div>
	* <div class="de">Liefert die code system id.</div>
	*
	* @return <div class="en">the code system id</div>
	*/
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	* <div class="en">Gets the code system name.</div>
	* <div class="de">Liefert code system name.</div>
	*
	* @return <div class="en">the code system name</div>
	*/
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

}