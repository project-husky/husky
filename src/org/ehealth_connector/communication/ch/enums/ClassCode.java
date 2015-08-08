package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/*
*<div class="de">Dieser Code definiert die Klasse des Dokumentes und richtet sich nach der CEN 13606 Norm. Unterhalb der Klassen sind Typen definiert im Attribut epd_xds_typeCode.</div>
*<div class="fr"></div>
*/
public enum ClassCode implements CodedMetadataEnumÎnterface {

	/** 
	*<div class="de">Konsultationseinträge/-Notizen</div>
	*<div class="fr">Notes de consultation</div>
	*<div class="it">Rapporti e note di consultazione</div>
	*/
	NOTES_ON_CONSULTATIONS ("DTC01", "Notes on Consultations"),
	/** 
	*<div class="de">Verlaufseinträge/-Notizen</div>
	*<div class="fr">Notes de suivi</div>
	*<div class="it">Note di evoluzione</div>
	*/
	PROGRESS_NOTES ("DTC02", "Progress Notes"),
	/** 
	*<div class="de">Interventionseinträge/-Notizen</div>
	*<div class="fr">Notes d'interventions</div>
	*<div class="it">Rapporti e note d'intervento</div>
	*/
	NOTES_ON_PROCEDURES ("DTC03", "Notes on Procedures"),
	/** 
	*<div class="de">Untersuchungs-/ Prozedur-Anforderungen</div>
	*<div class="fr">Demandes d'examen / procédure</div>
	*<div class="it">Richieste d'esame</div>
	*/
	TESTSPROCEDURE_REQUESTS ("DTC04", "Tests/Procedure Requests"),
	/** 
	*<div class="de">Zuweisungen/Überweisungen</div>
	*<div class="fr">Demandes de prise en charge</div>
	*<div class="it">Richieste di presa a carico</div>
	*/
	CLINICAL_CARE_REFERRALS ("DTC05", "Clinical Care Referrals"),
	/** 
	*<div class="de">Zusammenfassende Berichte</div>
	*<div class="fr">Résumés d'épisode</div>
	*<div class="it">Riassunti di episodio</div>
	*/
	EPISODE_SUMMARY_REPORTS ("DTC06", "Episode Summary Reports"),
	/** 
	*<div class="de">Verlaufs-Berichte</div>
	*<div class="fr">Rapports d'évolution</div>
	*<div class="it">Rapporti di evoluzione</div>
	*/
	PROGRESS_REPORTS ("DTC07", "Progress Reports"),
	/** 
	*<div class="de">Diagnostische Untersuchungsbefunde</div>
	*<div class="fr">Résultats d'examen diagnostic</div>
	*<div class="it">Risultati di esame diagnostico</div>
	*/
	DIAGNOSTIC_TEST_RESULTS ("DTC08", "Diagnostic Test Results"),
	/** 
	*<div class="de">Meldungen</div>
	*<div class="fr">"Notifications/Déclarations"</div>
	*<div class="it">Notifiche/dichiarazioni</div>
	*/
	NOTIFICATIONS ("DTC09", "Notifications"),
	/** 
	*<div class="de">Zusammenfassungen der Krankengeschichte</div>
	*<div class="fr">Résumés d'antécédents</div>
	*<div class="it">Riassunti della storia clinica</div>
	*/
	HISTORIC_OVERVIEWS ("DTC10", "Historic Overviews"),
	/** 
	*<div class="de">Zusammenfassungen aktueller Zustand</div>
	*<div class="fr">Résumés de l'état actuel</div>
	*<div class="it">Riassunti dello stato attuale</div>
	*/
	PRESENT_STATE_SUMMARIES ("DTC11", "Present State Summaries"),
	/** 
	*<div class="de">Behandlungspläne, Behandlungsschemata</div>
	*<div class="fr">Plans de soins</div>
	*<div class="it">Schema di terapia</div>
	*/
	CARE_PLANS ("DTC12", "Care Plans"),
	/** 
	*<div class="de">Warnungen /Risiken</div>
	*<div class="fr">Alertes</div>
	*<div class="it">Allertamenti</div>
	*/
	ALERTS ("DTC13", "Alerts"),
	/** 
	*<div class="de">Gescannte Dokumente</div>
	*<div class="fr">Documents scannés</div>
	*<div class="it">Documenti scansionati</div>
	*/
	SCANNED_DOCUMENTS ("DTC20", "Scanned Documents"),
	/** 
	*<div class="de">Eigene Daten des Patienten</div>
	*<div class="fr">Documents introduits par le patients</div>
	*<div class="it">Documenti inseriti dal paziente</div>
	*/
	DATA_FROM_PATIENT ("DTC21", "Data from Patient"),
	/** 
	*<div class="de">anderweitige Dokumente</div>
	*<div class="fr">Autre</div>
	*<div class="it">Altro</div>
	*/
	OTHER_COMPOSITION ("DTC90", "Other Composition");
	public static final String NOTES_ON_CONSULTATIONS_CODE="DTC01";
	public static final String PROGRESS_NOTES_CODE="DTC02";
	public static final String NOTES_ON_PROCEDURES_CODE="DTC03";
	public static final String TESTSPROCEDURE_REQUESTS_CODE="DTC04";
	public static final String CLINICAL_CARE_REFERRALS_CODE="DTC05";
	public static final String EPISODE_SUMMARY_REPORTS_CODE="DTC06";
	public static final String PROGRESS_REPORTS_CODE="DTC07";
	public static final String DIAGNOSTIC_TEST_RESULTS_CODE="DTC08";
	public static final String NOTIFICATIONS_CODE="DTC09";
	public static final String HISTORIC_OVERVIEWS_CODE="DTC10";
	public static final String PRESENT_STATE_SUMMARIES_CODE="DTC11";
	public static final String CARE_PLANS_CODE="DTC12";
	public static final String ALERTS_CODE="DTC13";
	public static final String SCANNED_DOCUMENTS_CODE="DTC20";
	public static final String DATA_FROM_PATIENT_CODE="DTC21";
	public static final String OTHER_COMPOSITION_CODE="DTC90";


	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.127.3.10.1.3";
	public static final String CODE_SYSTEM_NAME="epd_xds_classCode";


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
	private ClassCode (String code, String displayName) {
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

	public CodedMetadataType getCodedMetadataType() {
		CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();
		cmt.setSchemeUUID(CODE_SYSTEM_OID);
		cmt.setSchemeName(CODE_SYSTEM_NAME);
		cmt.setCode(this.getCodeValue());
		cmt.setDisplayName(XdsUtil.createInternationalString(this.getdisplayName()));
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
	public static ClassCode getEnum(String code) {
		for (ClassCode x : values()) {
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
		for (ClassCode x : values()) {
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