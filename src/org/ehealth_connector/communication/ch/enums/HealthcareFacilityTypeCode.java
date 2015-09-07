package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/*
*<div class="de">Dieser Code beschreibt den Typ der Gesundheitseinrichtung, in der das Dokument während des Behandlungsprozesses erstellt wurde. Der Patient kann im Zusammenhang mit der Berechtigungsteuerung diese Information nutzen, um beispielsweise in seinen Rechteattributen allen Dokumenten aus einem bestimmten Gesundheitseinrichtungstyp eine bestimmte Vertraulichkeitsstufe zuzuordnen. Passende interna-tionale Codes werden in einem nächsten Schritt definiert und können später in den IT-Systemen entsprechend abgeglichen werden.</div>
*<div class="fr"></div>
*/
public enum HealthcareFacilityTypeCode implements CodedMetadataEnumInterface {

	/** 
	*<div class="de">Institut für medizinische Diagnostik</div>
	*<div class="fr">Institut d’aide au diagnostic</div>
	*<div class="it">Istituto di diagnosi medica</div>
	*/
	INSTITUT_FÜR_MEDIZINISCHE_DIAGNOSTIK ("20001", "Institut für medizinische Diagnostik"),
	/** 
	*<div class="de">Notfall- / Rettungsdienste</div>
	*<div class="fr">Service d'urgence et de sauvetage</div>
	*<div class="it">Servizio di pronto soccorso e di salvataggio</div>
	*/
	NOTFALL___RETTUNGSDIENSTE ("20002", "Notfall- / Rettungsdienste"),
	/** 
	*<div class="de">Gesundheitsbehörde</div>
	*<div class="fr">Autorité de santé</div>
	*<div class="it">Autorità sanitaria</div>
	*/
	GESUNDHEITSBEHÖRDE ("20003", "Gesundheitsbehörde"),
	/** 
	*<div class="de">Organisation für Pflege zu Hause</div>
	*<div class="fr">Soins à domicile</div>
	*<div class="it">Servizio di cura e assistenza a domicilio</div>
	*/
	ORGANISATION_FÜR_PFLEGE_ZU_HAUSE ("20004", "Organisation für Pflege zu Hause"),
	/** 
	*<div class="de">stationäre Einrichtung / Spital</div>
	*<div class="fr">Hôpital</div>
	*<div class="it">Ospedale</div>
	*/
	STATIONÄRE_EINRICHTUNG__SPITAL ("20005", "stationäre Einrichtung / Spital"),
	/** 
	*<div class="de">Armeeärztliche Dienste</div>
	*<div class="fr">Service sanitaire </div>
	*<div class="it">Servizio di medicina militare</div>
	*/
	ARMEEÄRZTLICHE_DIENSTE ("20006", "Armeeärztliche Dienste"),
	/** 
	*<div class="de">Gesundheitseinrichtung in der Haftanstalt</div>
	*<div class="fr">Service santé dans la prison</div>
	*<div class="it">Struttura sanitaria in seno a uno stabilimento carcerario</div>
	*/
	GESUNDHEITSEINRICHTUNG_IN_DER_HAFTANSTALT ("20007", "Gesundheitseinrichtung in der Haftanstalt"),
	/** 
	*<div class="de">Sozio-Medizinische Institution</div>
	*<div class="fr">Etablissement médico-social</div>
	*<div class="it">Istituto/casa di cura</div>
	*/
	SOZIO_MEDIZINISCHE_INSTITUTION ("20008", "Sozio-Medizinische Institution"),
	/** 
	*<div class="de">Apotheke</div>
	*<div class="fr">Pharmacie</div>
	*<div class="it">Farmacia</div>
	*/
	APOTHEKE ("20009", "Apotheke"),
	/** 
	*<div class="de">Ambulante Einrichtung, inkl. Ambulatorium</div>
	*<div class="fr">Cabinet médical</div>
	*<div class="it">Studio medico</div>
	*/
	AMBULANTE_EINRICHTUNG_INKL__AMBULATORIUM ("20010", "Ambulante Einrichtung, inkl. Ambulatorium"),
	/** 
	*<div class="de">Organisation für stationäre Rehabilitation</div>
	*<div class="fr">Organisation de réhabilitation stationnaire</div>
	*<div class="it">Istituto di riabilitazione stazionaria</div>
	*/
	ORGANISATION_FÜR_STATIONÄRE_REHABILITATION ("20011", "Organisation für stationäre Rehabilitation"),
	/** 
	*<div class="de">zu Hause</div>
	*<div class="fr"> </div>
	*<div class="it"> </div>
	*/
	ZU_HAUSE ("20012", "zu Hause"),
	/** 
	*<div class="de">Unbekannt</div>
	*<div class="fr">Inconnu</div>
	*<div class="it">Ignoto</div>
	*/
	UNBEKANNT ("20900", "Unbekannt"),
	/** 
	*<div class="de">Andere Gesundheits-Organisation</div>
	*<div class="fr">Autres prestateurs de soins</div>
	*<div class="it">Altre organizzazioni sanitarie</div>
	*/
	ANDERE_GESUNDHEITS_ORGANISATION ("20999", "Andere Gesundheits-Organisation");
	public static final String INSTITUT_FÜR_MEDIZINISCHE_DIAGNOSTIK_CODE="20001";
	public static final String NOTFALL___RETTUNGSDIENSTE_CODE="20002";
	public static final String GESUNDHEITSBEHÖRDE_CODE="20003";
	public static final String ORGANISATION_FÜR_PFLEGE_ZU_HAUSE_CODE="20004";
	public static final String STATIONÄRE_EINRICHTUNG__SPITAL_CODE="20005";
	public static final String ARMEEÄRZTLICHE_DIENSTE_CODE="20006";
	public static final String GESUNDHEITSEINRICHTUNG_IN_DER_HAFTANSTALT_CODE="20007";
	public static final String SOZIO_MEDIZINISCHE_INSTITUTION_CODE="20008";
	public static final String APOTHEKE_CODE="20009";
	public static final String AMBULANTE_EINRICHTUNG_INKL__AMBULATORIUM_CODE="20010";
	public static final String ORGANISATION_FÜR_STATIONÄRE_REHABILITATION_CODE="20011";
	public static final String ZU_HAUSE_CODE="20012";
	public static final String UNBEKANNT_CODE="20900";
	public static final String ANDERE_GESUNDHEITS_ORGANISATION_CODE="20999";


	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.127.3.10.1.11";
	public static final String CODE_SYSTEM_NAME="epd_xds_healthcareFacilityTypeCode";


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
	private HealthcareFacilityTypeCode (String code, String displayName) {
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
	public static HealthcareFacilityTypeCode getEnum(String code) {
		for (HealthcareFacilityTypeCode x : values()) {
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
		for (HealthcareFacilityTypeCode x : values()) {
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