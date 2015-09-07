package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/*
*<div class="de">Dieser Code definiert die Rolle des Authors innerhalb der Institution, z.B Arzt, Pflegefachperson, Therapeut, etc. Dieser Wert soll in Kombination mit anderen Attributen eine eindeutige Kategorisierung der Dokumente ermöglichen. Dies ist ein Sub-Attribut von epd_xds_author. Dieses Sub-Attribut ist zwingend erforderlich.</div>
*<div class="fr"></div>
*/
public enum AuthorRole implements CodedMetadataEnumInterface {

	/** 
	*<div class="de">Apotheker</div>
	*<div class="fr">Pharmacien/ne</div>
	*<div class="it">Farmacista</div>
	*/
	APOTHEKER ("40001", "Apotheker"),
	/** 
	*<div class="de">Arzt</div>
	*<div class="fr">Médecin</div>
	*<div class="it">Medico</div>
	*/
	ARZT ("40002", "Arzt"),
	/** 
	*<div class="de">Chiropraktiker</div>
	*<div class="fr">Chiropracteur</div>
	*<div class="it">Chiropratico</div>
	*/
	CHIROPRAKTIKER ("40003", "Chiropraktiker"),
	/** 
	*<div class="de">Ernährungsberater</div>
	*<div class="fr">Diététicien/ne</div>
	*<div class="it">Nutrizionista</div>
	*/
	ERNÄHRUNGSBERATER ("40004", "Ernährungsberater"),
	/** 
	*<div class="de">Hebamme</div>
	*<div class="fr">Sage-femme</div>
	*<div class="it">Ostetrica</div>
	*/
	HEBAMME ("40005", "Hebamme"),
	/** 
	*<div class="de">Komplementärmediziner</div>
	*<div class="fr">Thérapeute en médecine alternative et complémentaire</div>
	*<div class="it">Terapista complementare</div>
	*/
	KOMPLEMENTÄRMEDIZINER ("40006", "Komplementärmediziner"),
	/** 
	*<div class="de">Patient</div>
	*<div class="fr">Patient/e</div>
	*<div class="it">Paziente</div>
	*/
	PATIENT ("40007", "Patient"),
	/** 
	*<div class="de">Pflegefachperson</div>
	*<div class="fr">Infirmier/ère</div>
	*<div class="it">Professionista della salute</div>
	*/
	PFLEGEFACHPERSON ("40008", "Pflegefachperson"),
	/** 
	*<div class="de">Psychologe</div>
	*<div class="fr">Psychologue</div>
	*<div class="it">Psicologo</div>
	*/
	PSYCHOLOGE ("40009", "Psychologe"),
	/** 
	*<div class="de">Sozialdienst</div>
	*<div class="fr">Service social</div>
	*<div class="it">Servizio sociale</div>
	*/
	SOZIALDIENST ("40010", "Sozialdienst"),
	/** 
	*<div class="de">Therapeut</div>
	*<div class="fr">Thérapeute</div>
	*<div class="it">Terapista</div>
	*/
	THERAPEUT ("40011", "Therapeut"),
	/** 
	*<div class="de">Zahnarzt</div>
	*<div class="fr">Dentiste</div>
	*<div class="it">Dentista</div>
	*/
	ZAHNARZT ("40012", "Zahnarzt"),
	/** 
	*<div class="de">Unbekannt</div>
	*<div class="fr">Inconnu</div>
	*<div class="it">Ignoto</div>
	*/
	UNBEKANNT ("40900", "Unbekannt"),
	/** 
	*<div class="de">Andere</div>
	*<div class="fr">Autre</div>
	*<div class="it">Altro</div>
	*/
	ANDERE ("40999", "Andere");
	public static final String APOTHEKER_CODE="40001";
	public static final String ARZT_CODE="40002";
	public static final String CHIROPRAKTIKER_CODE="40003";
	public static final String ERNÄHRUNGSBERATER_CODE="40004";
	public static final String HEBAMME_CODE="40005";
	public static final String KOMPLEMENTÄRMEDIZINER_CODE="40006";
	public static final String PATIENT_CODE="40007";
	public static final String PFLEGEFACHPERSON_CODE="40008";
	public static final String PSYCHOLOGE_CODE="40009";
	public static final String SOZIALDIENST_CODE="40010";
	public static final String THERAPEUT_CODE="40011";
	public static final String ZAHNARZT_CODE="40012";
	public static final String UNBEKANNT_CODE="40900";
	public static final String ANDERE_CODE="40999";


	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.127.3.10.1.1.3";
	public static final String CODE_SYSTEM_NAME="epd_xds_authorRole";


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
	private AuthorRole (String code, String displayName) {
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
	public static AuthorRole getEnum(String code) {
		for (AuthorRole x : values()) {
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
		for (AuthorRole x : values()) {
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