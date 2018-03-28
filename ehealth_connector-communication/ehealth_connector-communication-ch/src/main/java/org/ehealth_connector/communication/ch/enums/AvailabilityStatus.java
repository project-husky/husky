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

import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.valuesets.ValueSetEnumInterface;

/**
 * <div class="en">Document availability status as per Annex 3&amp;#160;
 * EPRO-FDHA, Chapter 2.2.&lt;br clear="none"/&gt;</div>
 * <div class="de">Verfügbarkeitsstatus des Dokumentes gemäss Anhang 3 EPDV-EDI,
 * Kapitel 2.2.&lt;br clear="none"/&gt;</div> <div class="fr">Statut de
 * disponibilité du document selon l'annexe 3 ODEP-DFI, chapitre 2.2.&lt;br
 * clear="none"/&gt;</div> <div class="it">Stato di disponibilità del documento
 * secondo l'allegato 3 OCIP-DFI, capitolo 2.2. &lt;br clear="none"/&gt;</div>
 */
public enum AvailabilityStatus implements ValueSetEnumInterface {

	/**
	 * <div class="en">Approved</div> <div class="de">genehmigt</div>
	 * <div class="fr">approuvé</div> <div class="it">approvato</div>
	 */
	APPROVED("urn:oasis:names:tc:ebxml-regrep:StatusType:Approved", "Approved", "Approved", "genehmigt", "approuvé", "approvato"),
	/**
	 * <div class="en">Deprecated</div> <div class="de">veraltet</div>
	 * <div class="fr">caduc</div> <div class="it">obsoleto</div>
	 */
	DEPRECATED("urn:oasis:names:tc:ebxml-regrep:StatusType:Deprecated", "Deprecated", "Deprecated", "veraltet", "caduc", "obsoleto");

	/**
	 * <div class="en">Code for Approved</div> <div class="de">Code für
	 * genehmigt</div> <div class="fr">Code de approuvé</div>
	 * <div class="it">Code per approvato</div>
	 */
	public static final String APPROVED_CODE = "urn:oasis:names:tc:ebxml-regrep:StatusType:Approved";

	/**
	 * <div class="en">Code for Deprecated</div> <div class="de">Code für
	 * veraltet</div> <div class="fr">Code de caduc</div> <div class="it">Code
	 * per obsoleto</div>
	 */
	public static final String DEPRECATED_CODE = "urn:oasis:names:tc:ebxml-regrep:StatusType:Deprecated";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_availabilityStatus";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.2";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static AvailabilityStatus getEnum(String code) {
		for (final AvailabilityStatus x : values()) {
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
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(AvailabilityStatus.class, enumName);
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
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final AvailabilityStatus x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

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
	 * Display Name</div> <div class="de">Instanziiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param code
	 *            <div class="de">code</div>
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
	AvailabilityStatus(String code, String displayName, String displayNameEn, String displayNameDe,
			String displayNameFr, String displayNameIt) {
		this.code = code;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
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
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is
	 * returned.</div> <div class="de">Liefert display name gemäss Parameter,
	 * falls es keine Englische Übersetzung gibt, wird der default-Name
	 * zurückgegeben.</div>
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}
}
