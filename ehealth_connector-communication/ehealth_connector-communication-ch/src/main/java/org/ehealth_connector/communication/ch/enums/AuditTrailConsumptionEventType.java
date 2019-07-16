/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">Audit Trail Consumption Event Types for CH:ATC<br clear="none"/></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum AuditTrailConsumptionEventType implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Accessing the Patient Audit Record Repository</div>
	 * <div class="de">Auf die patientenbezogene Auditprotokoll-Ablage zugreifen</div>
	 * <div class="fr">En cours d’accès au dépôt de contrôle des dossiers de patients</div>
	 * <div class="it">Accesso all'Audit Record Repository del paziente</div>
	 * <!-- @formatter:on -->
	 */
	ACCESSING_THE_PATIENT_AUDIT_RECORD_REPOSITORY("ATC_LOG_READ", "2.16.756.5.30.1.127.3.10.7",
			"Accessing the Patient Audit Record Repository",
			"Accessing the Patient Audit Record Repository",
			"Auf die patientenbezogene Auditprotokoll-Ablage zugreifen",
			"En cours d’accès au dépôt de contrôle des dossiers de patients",
			"Accesso all'Audit Record Repository del paziente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assign a Healthcare Professional to Blacklist</div>
	 * <div class="de">Gesundheitsfachperson auf die schwarze Liste setzen</div>
	 * <div class="fr">Ajouter un professionnel de la santé à la liste noire</div>
	 * <div class="it">Aggiungere un professionista della salute alla lista nera</div>
	 * <!-- @formatter:on -->
	 */
	ASSIGN_A_HEALTHCARE_PROFESSIONAL_TO_BLACKLIST("ATC_POL_INCL_BLACKLIST",
			"2.16.756.5.30.1.127.3.10.7", "Assign a Healthcare Professional to Blacklist",
			"Assign a Healthcare Professional to Blacklist",
			"Gesundheitsfachperson auf die schwarze Liste setzen",
			"Ajouter un professionnel de la santé à la liste noire",
			"Aggiungere un professionista della salute alla lista nera"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Authorize participants to access level/date</div>
	 * <div class="de">Teilnehmende für Zugriffsstufe/Datum autorisieren</div>
	 * <div class="fr">Autoriser les participants pour ce niveau d’accès / à cette date</div>
	 * <div class="it">Autorizzare i partecipanti ad accedere a un livello/una data</div>
	 * <!-- @formatter:on -->
	 */
	AUTHORIZE_PARTICIPANTS_TO_ACCESS_LEVEL_DATE("ATC_POL_CREATE_AUT_PART_AL",
			"2.16.756.5.30.1.127.3.10.7", "Authorize participants to access level/date",
			"Authorize participants to access level/date",
			"Teilnehmende für Zugriffsstufe/Datum autorisieren",
			"Autoriser les participants pour ce niveau d’accès / à cette date",
			"Autorizzare i partecipanti ad accedere a un livello/una data"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Disabling Emergency Access</div>
	 * <div class="de">Notfall-Zugriff deaktivieren</div>
	 * <div class="fr">Désactiver l’accès d’urgence</div>
	 * <div class="it">Disabilitare l'accesso di emergenza</div>
	 * <!-- @formatter:on -->
	 */
	DISABLING_EMERGENCY_ACCESS("ATC_POL_DIS_EMER_USE", "2.16.756.5.30.1.127.3.10.7",
			"Disabling Emergency Access", "Disabling Emergency Access",
			"Notfall-Zugriff deaktivieren", "Désactiver l’accès d’urgence",
			"Disabilitare l'accesso di emergenza"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Document or Document Metadata update</div>
	 * <div class="de">Dokument- oder Dokument-Metadaten-Aktualisierung</div>
	 * <div class="fr">Mise à jour de documents ou de métadonnées de documents</div>
	 * <div class="it">Aggiornamento di un documento o dei metadati di un documento</div>
	 * <!-- @formatter:on -->
	 */
	DOCUMENT_OR_DOCUMENT_METADATA_UPDATE("ATC_DOC_UPDATE", "2.16.756.5.30.1.127.3.10.7",
			"Document or Document Metadata update", "Document or Document Metadata update",
			"Dokument- oder Dokument-Metadaten-Aktualisierung",
			"Mise à jour de documents ou de métadonnées de documents",
			"Aggiornamento di un documento o dei metadati di un documento"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Document removal</div>
	 * <div class="de">Dokumentlöschung</div>
	 * <div class="fr">Suppression de documents</div>
	 * <div class="it">Rimozione di un documento</div>
	 * <!-- @formatter:on -->
	 */
	DOCUMENT_REMOVAL("ATC_DOC_DELETE", "2.16.756.5.30.1.127.3.10.7", "Document removal",
			"Document removal", "Dokumentlöschung", "Suppression de documents",
			"Rimozione di un documento"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Document retrieval</div>
	 * <div class="de">Dokumentabruf</div>
	 * <div class="fr">Récupération de documents</div>
	 * <div class="it">Ricerca di un documento</div>
	 * <!-- @formatter:on -->
	 */
	DOCUMENT_RETRIEVAL("ATC_DOC_READ", "2.16.756.5.30.1.127.3.10.7", "Document retrieval",
			"Document retrieval", "Dokumentabruf", "Récupération de documents",
			"Ricerca di un documento"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Document upload</div>
	 * <div class="de">Dokument-Upload</div>
	 * <div class="fr">Chargement de documents</div>
	 * <div class="it">Upload di un documento</div>
	 * <!-- @formatter:on -->
	 */
	DOCUMENT_UPLOAD("ATC_DOC_CREATE", "2.16.756.5.30.1.127.3.10.7", "Document upload",
			"Document upload", "Dokument-Upload", "Chargement de documents",
			"Upload di un documento"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Enabling Emergency Access</div>
	 * <div class="de">Notfall-Zugriff aktivieren</div>
	 * <div class="fr">Autoriser l’accès d’urgence</div>
	 * <div class="it">Abilitare l'accesso di emergenza</div>
	 * <!-- @formatter:on -->
	 */
	ENABLING_EMERGENCY_ACCESS("ATC_POL_ENA_EMER_USE", "2.16.756.5.30.1.127.3.10.7",
			"Enabling Emergency Access", "Enabling Emergency Access", "Notfall-Zugriff aktivieren",
			"Autoriser l’accès d’urgence", "Abilitare l'accesso di emergenza"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Exclude a Healthcare Professional from Blacklist</div>
	 * <div class="de">Gesundheitsfachperson von der schwarzen Liste streichen</div>
	 * <div class="fr">Retirer un professionnel de la santé de la liste noire</div>
	 * <div class="it">Rimuovere un professionista della salute dalla lista nera</div>
	 * <!-- @formatter:on -->
	 */
	EXCLUDE_A_HEALTHCARE_PROFESSIONAL_FROM_BLACKLIST("ATC_POL_EXL_BLACKLIST",
			"2.16.756.5.30.1.127.3.10.7", "Exclude a Healthcare Professional from Blacklist",
			"Exclude a Healthcare Professional from Blacklist",
			"Gesundheitsfachperson von der schwarzen Liste streichen",
			"Retirer un professionnel de la santé de la liste noire",
			"Rimuovere un professionista della salute dalla lista nera"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Remove authorization for participants to access level/date</div>
	 * <div class="de">Autorisierung von Teilnehmenden für Zugriffsstufe/Datum aufheben</div>
	 * <div class="fr">Supprimer l’autorisation des participants à ce niveau d’accès / à cette date</div>
	 * <div class="it">Rimuovere l'autorizzazione di accesso dei partecipanti al livello/alla data</div>
	 * <!-- @formatter:on -->
	 */
	REMOVE_AUTHORIZATION_FOR_PARTICIPANTS_TO_ACCESS_LEVEL_DATE("ATC_POL_REMOVE_AUT_PART_AL",
			"2.16.756.5.30.1.127.3.10.7",
			"Remove authorization for participants to access level/date",
			"Remove authorization for participants to access level/date",
			"Autorisierung von Teilnehmenden für Zugriffsstufe/Datum aufheben",
			"Supprimer l’autorisation des participants à ce niveau d’accès / à cette date",
			"Rimuovere l'autorizzazione di accesso dei partecipanti al livello/alla data"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Set or update the default Confidentiality Level for new documents</div>
	 * <div class="de">Standard-Vertraulichkeitsstufe für neue Dokumente setzen oder aktualisieren</div>
	 * <div class="fr">Définir ou mettre à jour le niveau de confidentialité pour les nouveaux documents</div>
	 * <div class="it">Impostare o aggiornare il livello di confidenzialità di default per i documenti nuovi</div>
	 * <!-- @formatter:on -->
	 */
	SET_OR_UPDATE_THE_DEFAULT_CONFIDENTIALITY_LEVEL_FOR_NEW_DOCUMENTS("ATC_POL_DEF_CONFLEVEL",
			"2.16.756.5.30.1.127.3.10.7",
			"Set or update the default Confidentiality Level for new documents",
			"Set or update the default Confidentiality Level for new documents",
			"Standard-Vertraulichkeitsstufe für neue Dokumente setzen oder aktualisieren",
			"Définir ou mettre à jour le niveau de confidentialité pour les nouveaux documents",
			"Impostare o aggiornare il livello di confidenzialità di default per i documenti nuovi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Update access level/date of authorized participants</div>
	 * <div class="de">Zugriffsstufe/Datum autorisierter Teilnehmender aktualisieren</div>
	 * <div class="fr">Mettre à jour le niveau d’accès / la date des participants autorisés</div>
	 * <div class="it">Aggiornare il livello/la data di accesso dei partecipanti autorizzati</div>
	 * <!-- @formatter:on -->
	 */
	UPDATE_ACCESS_LEVEL_DATE_OF_AUTHORIZED_PARTICIPANTS("ATC_POL_UPDATE_AUT_PART_AL",
			"2.16.756.5.30.1.127.3.10.7", "Update access level/date of authorized participants",
			"Update access level/date of authorized participants",
			"Zugriffsstufe/Datum autorisierter Teilnehmender aktualisieren",
			"Mettre à jour le niveau d’accès / la date des participants autorisés",
			"Aggiornare il livello/la data di accesso dei partecipanti autorizzati");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Accessing the Patient Audit Record Repository</div>
	 * <div class="de">Code für Auf die patientenbezogene Auditprotokoll-Ablage zugreifen</div>
	 * <div class="fr">Code de En cours d’accès au dépôt de contrôle des dossiers de patients</div>
	 * <div class="it">Code per Accesso all'Audit Record Repository del paziente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACCESSING_THE_PATIENT_AUDIT_RECORD_REPOSITORY_CODE = "ATC_LOG_READ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Assign a Healthcare Professional to Blacklist</div>
	 * <div class="de">Code für Gesundheitsfachperson auf die schwarze Liste setzen</div>
	 * <div class="fr">Code de Ajouter un professionnel de la santé à la liste noire</div>
	 * <div class="it">Code per Aggiungere un professionista della salute alla lista nera</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ASSIGN_A_HEALTHCARE_PROFESSIONAL_TO_BLACKLIST_CODE = "ATC_POL_INCL_BLACKLIST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Authorize participants to access level/date</div>
	 * <div class="de">Code für Teilnehmende für Zugriffsstufe/Datum autorisieren</div>
	 * <div class="fr">Code de Autoriser les participants pour ce niveau d’accès / à cette date</div>
	 * <div class="it">Code per Autorizzare i partecipanti ad accedere a un livello/una data</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUTHORIZE_PARTICIPANTS_TO_ACCESS_LEVEL_DATE_CODE = "ATC_POL_CREATE_AUT_PART_AL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Disabling Emergency Access</div>
	 * <div class="de">Code für Notfall-Zugriff deaktivieren</div>
	 * <div class="fr">Code de Désactiver l’accès d’urgence</div>
	 * <div class="it">Code per Disabilitare l'accesso di emergenza</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISABLING_EMERGENCY_ACCESS_CODE = "ATC_POL_DIS_EMER_USE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Document or Document Metadata update</div>
	 * <div class="de">Code für Dokument- oder Dokument-Metadaten-Aktualisierung</div>
	 * <div class="fr">Code de Mise à jour de documents ou de métadonnées de documents</div>
	 * <div class="it">Code per Aggiornamento di un documento o dei metadati di un documento</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOCUMENT_OR_DOCUMENT_METADATA_UPDATE_CODE = "ATC_DOC_UPDATE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Document removal</div>
	 * <div class="de">Code für Dokumentlöschung</div>
	 * <div class="fr">Code de Suppression de documents</div>
	 * <div class="it">Code per Rimozione di un documento</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOCUMENT_REMOVAL_CODE = "ATC_DOC_DELETE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Document retrieval</div>
	 * <div class="de">Code für Dokumentabruf</div>
	 * <div class="fr">Code de Récupération de documents</div>
	 * <div class="it">Code per Ricerca di un documento</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOCUMENT_RETRIEVAL_CODE = "ATC_DOC_READ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Document upload</div>
	 * <div class="de">Code für Dokument-Upload</div>
	 * <div class="fr">Code de Chargement de documents</div>
	 * <div class="it">Code per Upload di un documento</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOCUMENT_UPLOAD_CODE = "ATC_DOC_CREATE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Enabling Emergency Access</div>
	 * <div class="de">Code für Notfall-Zugriff aktivieren</div>
	 * <div class="fr">Code de Autoriser l’accès d’urgence</div>
	 * <div class="it">Code per Abilitare l'accesso di emergenza</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENABLING_EMERGENCY_ACCESS_CODE = "ATC_POL_ENA_EMER_USE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Exclude a Healthcare Professional from Blacklist</div>
	 * <div class="de">Code für Gesundheitsfachperson von der schwarzen Liste streichen</div>
	 * <div class="fr">Code de Retirer un professionnel de la santé de la liste noire</div>
	 * <div class="it">Code per Rimuovere un professionista della salute dalla lista nera</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXCLUDE_A_HEALTHCARE_PROFESSIONAL_FROM_BLACKLIST_CODE = "ATC_POL_EXL_BLACKLIST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Remove authorization for participants to access level/date</div>
	 * <div class="de">Code für Autorisierung von Teilnehmenden für Zugriffsstufe/Datum aufheben</div>
	 * <div class="fr">Code de Supprimer l’autorisation des participants à ce niveau d’accès / à cette date</div>
	 * <div class="it">Code per Rimuovere l'autorizzazione di accesso dei partecipanti al livello/alla data</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REMOVE_AUTHORIZATION_FOR_PARTICIPANTS_TO_ACCESS_LEVEL_DATE_CODE = "ATC_POL_REMOVE_AUT_PART_AL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Set or update the default Confidentiality Level for new documents</div>
	 * <div class="de">Code für Standard-Vertraulichkeitsstufe für neue Dokumente setzen oder aktualisieren</div>
	 * <div class="fr">Code de Définir ou mettre à jour le niveau de confidentialité pour les nouveaux documents</div>
	 * <div class="it">Code per Impostare o aggiornare il livello di confidenzialità di default per i documenti nuovi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SET_OR_UPDATE_THE_DEFAULT_CONFIDENTIALITY_LEVEL_FOR_NEW_DOCUMENTS_CODE = "ATC_POL_DEF_CONFLEVEL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Update access level/date of authorized participants</div>
	 * <div class="de">Code für Zugriffsstufe/Datum autorisierter Teilnehmender aktualisieren</div>
	 * <div class="fr">Code de Mettre à jour le niveau d’accès / la date des participants autorisés</div>
	 * <div class="it">Code per Aggiornare il livello/la data di accesso dei partecipanti autorizzati</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UPDATE_ACCESS_LEVEL_DATE_OF_AUTHORIZED_PARTICIPANTS_CODE = "ATC_POL_UPDATE_AUT_PART_AL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.13.2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "EprAuditTrailConsumptionEventType";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static AuditTrailConsumptionEventType getEnum(String code) {
		for (final AuditTrailConsumptionEventType x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(AuditTrailConsumptionEventType.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final AuditTrailConsumptionEventType x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Machine interpretable and (inside this class) unique code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	 * <!-- @formatter:on -->
	 */
	private String code;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 * <!-- @formatter:on -->
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	AuditTrailConsumptionEventType(String code, String codeSystem, String displayName,
			String displayNameEn, String displayNameDe, String displayNameFr,
			String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set name.</div>
	 * <div class="de">Liefert den Value Set Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
