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
package org.ehealth_connector.common.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.CodedMetadataEnumInterface;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/**
 * <div class="de">Dieser Code definiert die Rolle des Authors innerhalb der
 * Institution, z.B Arzt, Pflegefachperson, Therapeut, etc. Dieser Wert soll in
 * Kombination mit anderen Attributen eine eindeutige Kategorisierung der
 * Dokumente ermöglichen. Dies ist ein Sub-Attribut von epd_xds_author. Dieses
 * Sub-Attribut ist zwingend erforderlich.</div> <div class="fr"></div>
 */
public enum AuthorRole implements CodedMetadataEnumInterface {

	/**
	 * <div class="de">Andere</div> <div class="fr">Autre</div>
	 * <div class="it">Altro</div>
	 */
	ANDERE("40999", "Andere"), /**
								 * <div class="de">Apotheker</div>
								 * <div class="fr">Pharmacien/ne</div>
								 * <div class="it">Farmacista</div>
								 */
	APOTHEKER("40001", "Apotheker"), /**
										 * <div class="de">Arzt</div>
										 * <div class="fr">Médecin</div>
										 * <div class="it">Medico</div>
										 */
	ARZT("40002", "Arzt"), /**
							 * <div class="de">Chiropraktiker</div>
							 * <div class="fr">Chiropracteur</div>
							 * <div class="it">Chiropratico</div>
							 */
	CHIROPRAKTIKER("40003",
			"Chiropraktiker"), /**
								 * <div class="de">Ernährungsberater</div>
								 * <div class="fr">Diététicien/ne</div>
								 * <div class="it">Nutrizionista</div>
								 */
	ERNAHRUNGSBERATER("40004",
			"Ernährungsberater"), /**
									 * <div class="de">Hebamme</div>
									 * <div class="fr">Sage-femme</div>
									 * <div class="it">Ostetrica</div>
									 */
	HEBAMME("40005",
			"Hebamme"), /**
						 * <div class="de">Komplementärmediziner</div>
						 * <div class="fr">Thérapeute en médecine alternative et
						 * complémentaire</div> <div class="it">Terapista
						 * complementare</div>
						 */
	KOMPLEMENTARMEDIZINER("40006",
			"Komplementärmediziner"), /**
										 * <div class="de">Patient</div>
										 * <div class="fr">Patient/e</div>
										 * <div class="it">Paziente</div>
										 */
	PATIENT("40007",
			"Patient"), /**
						 * <div class="de">Pflegefachperson</div>
						 * <div class="fr">Infirmier/ère</div>
						 * <div class="it">Professionista della salute</div>
						 */
	PFLEGEFACHPERSON("40008",
			"Pflegefachperson"), /**
									 * <div class="de">Psychologe</div>
									 * <div class="fr">Psychologue</div>
									 * <div class="it">Psicologo</div>
									 */
	PSYCHOLOGE("40009",
			"Psychologe"), /**
							 * <div class="de">Sozialdienst</div>
							 * <div class="fr">Service social</div>
							 * <div class="it">Servizio sociale</div>
							 */
	SOZIALDIENST("40010", "Sozialdienst"), /**
											 * <div class="de">Therapeut</div>
											 * <div class="fr">Thérapeute</div>
											 * <div class="it">Terapista</div>
											 */
	THERAPEUT("40011", "Therapeut"), /**
										 * <div class="de">Unbekannt</div>
										 * <div class="fr">Inconnu</div>
										 * <div class="it">Ignoto</div>
										 */
	UNBEKANNT("40900", "Unbekannt"), /**
										 * <div class="de">Zahnarzt</div>
										 * <div class="fr">Dentiste</div>
										 * <div class="it">Dentista</div>
										 */
	ZAHNARZT("40012", "Zahnarzt");

	/**
	 * <div class="de">Code für Andere</div> <div class="fr">Code de Autre</div>
	 * <div class="it">Code per Altro</div>
	 */
	public static final String ANDERE_CODE = "40999";

	/**
	 * <div class="de">Code für Apotheker</div> <div class="fr">Code de
	 * Pharmacien/ne</div> <div class="it">Code per Farmacista</div>
	 */
	public static final String APOTHEKER_CODE = "40001";

	/**
	 * <div class="de">Code für Arzt</div> <div class="fr">Code de Médecin</div>
	 * <div class="it">Code per Medico</div>
	 */
	public static final String ARZT_CODE = "40002";

	/**
	 * <div class="de">Code für Chiropraktiker</div> <div class="fr">Code de
	 * Chiropracteur</div> <div class="it">Code per Chiropratico</div>
	 */
	public static final String CHIROPRAKTIKER_CODE = "40003";

	/**
	 * <div class="de">Code für Ernährungsberater</div> <div class="fr">Code de
	 * Diététicien/ne</div> <div class="it">Code per Nutrizionista</div>
	 */
	public static final String ERNAHRUNGSBERATER_CODE = "40004";

	/**
	 * <div class="de">Code für Hebamme</div> <div class="fr">Code de
	 * Sage-femme</div> <div class="it">Code per Ostetrica</div>
	 */
	public static final String HEBAMME_CODE = "40005";

	/**
	 * <div class="de">Code für Komplementärmediziner</div> <div class="fr">Code
	 * de Thérapeute en médecine alternative et complémentaire</div>
	 * <div class="it">Code per Terapista complementare</div>
	 */
	public static final String KOMPLEMENTARMEDIZINER_CODE = "40006";

	/**
	 * <div class="de">Code für Patient</div> <div class="fr">Code de
	 * Patient/e</div> <div class="it">Code per Paziente</div>
	 */
	public static final String PATIENT_CODE = "40007";

	/**
	 * <div class="de">Code für Pflegefachperson</div> <div class="fr">Code de
	 * Infirmier/ère</div> <div class="it">Code per Professionista della
	 * salute</div>
	 */
	public static final String PFLEGEFACHPERSON_CODE = "40008";

	/**
	 * <div class="de">Code für Psychologe</div> <div class="fr">Code de
	 * Psychologue</div> <div class="it">Code per Psicologo</div>
	 */
	public static final String PSYCHOLOGE_CODE = "40009";

	/**
	 * <div class="de">Code für Sozialdienst</div> <div class="fr">Code de
	 * Service social</div> <div class="it">Code per Servizio sociale</div>
	 */
	public static final String SOZIALDIENST_CODE = "40010";

	/**
	 * <div class="de">Code für Therapeut</div> <div class="fr">Code de
	 * Thérapeute</div> <div class="it">Code per Terapista</div>
	 */
	public static final String THERAPEUT_CODE = "40011";

	/**
	 * <div class="de">Code für Unbekannt</div> <div class="fr">Code de
	 * Inconnu</div> <div class="it">Code per Ignoto</div>
	 */
	public static final String UNBEKANNT_CODE = "40900";

	/**
	 * <div class="de">Code für Zahnarzt</div> <div class="fr">Code de
	 * Dentiste</div> <div class="it">Code per Dentista</div>
	 */
	public static final String ZAHNARZT_CODE = "40012";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.1.3";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_authorRole";

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
	private AuthorRole(String code, String displayName) {
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
	public static AuthorRole getEnum(String code) {
		for (final AuthorRole x : values()) {
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
		cmt.setDisplayName(XdsMetadataUtil.createInternationalString(this.getDisplayName(), "de-ch"));
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
			Enum.valueOf(AuthorRole.class, enumName);
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
	 *          <div class="de">code</div>
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (AuthorRole x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}
}
