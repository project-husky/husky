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
package org.ehealth_connector.common.ch.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.CodedMetadataEnumInterface;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/**
 * <div class="de">Dieser Code definiert die Vertraulichkeitsstufe des XDS
 * Dokuments. Dabei finden drei medizinische Stufen Anwendung: Nützliche Daten
 * mit einer breiten Zugänglichkeit, z.B. für den Notfall, medizinische Daten im
 * Sinne von Daten für die Behandelnden und sensible Daten im Sinne von Daten
 * für den Behandelnden des Vertrauens oder die Person des Vertrauens. Diese
 * drei Stufen werden zum Einen ergänzt mit einer Stufe für administrative
 * Daten. Diese ist zwingend notwendig. Zum Anderen werden sie ergänzt mit der
 * Stufe geheim, die zwar möglichst wenig zum Einsatz kommen sollte, aber für
 * die Akzeptanz wichtig ist (mit dieser Stufe ist sichergestellt, dass der
 * Patient seine Daten niemandem offenlegen muss). </div> <div class="fr"></div>
 */
public enum ConfidentialityCode implements CodedMetadataEnumInterface {

	/**
	 * <div class="de">administrative Daten</div> <div class="fr">données
	 * administratives</div> <div class="it">dati amministrativi</div>
	 */
	ADMINISTRATIVE_DATEN("30001", "administrative Daten"),
	/**
	 * <div class="de">geheime Daten</div> <div class="fr">données
	 * secrètes</div> <div class="it">dati segreti</div>
	 */
	GEHEIME_DATEN("30005", "geheime Daten"),
	/**
	 * <div class="de">medizinische Daten</div> <div class="fr">données
	 * médicales</div> <div class="it">dati medici</div>
	 */
	MEDIZINISCHE_DATEN("30003", "medizinische Daten"),
	/**
	 * <div class="de">nützliche Daten</div> <div class="fr">données
	 * utiles</div> <div class="it">dati utilitari</div>
	 */
	NUTZLICHE_DATEN("30002", "nützliche Daten"),
	/**
	 * <div class="de">sensible Daten</div> <div class="fr">données
	 * sensibles</div> <div class="it">dati stigmatizzanti</div>
	 */
	SENSIBLE_DATEN("30004", "sensible Daten");

	/**
	 * <div class="de">Code für administrative Daten</div> <div class="fr">Code
	 * de données administratives</div> <div class="it">Code per dati
	 * amministrativi</div>
	 */
	public static final String ADMINISTRATIVE_DATEN_CODE = "30001";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_confidentialityCode";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.5";

	/**
	 * <div class="de">Code für geheime Daten</div> <div class="fr">Code de
	 * données secrètes</div> <div class="it">Code per dati segreti</div>
	 */
	public static final String GEHEIME_DATEN_CODE = "30005";

	/**
	 * <div class="de">Code für medizinische Daten</div> <div class="fr">Code de
	 * données médicales</div> <div class="it">Code per dati medici</div>
	 */
	public static final String MEDIZINISCHE_DATEN_CODE = "30003";

	/**
	 * <div class="de">Code für nützliche Daten</div> <div class="fr">Code de
	 * données utiles</div> <div class="it">Code per dati utilitari</div>
	 */
	public static final String NUTZLICHE_DATEN_CODE = "30002";

	/**
	 * <div class="de">Code für sensible Daten</div> <div class="fr">Code de
	 * données sensibles</div> <div class="it">Code per dati
	 * stigmatizzanti</div>
	 */
	public static final String SENSIBLE_DATEN_CODE = "30004";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ConfidentialityCode getEnum(String code) {
		for (final ConfidentialityCode x : values()) {
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
			Enum.valueOf(ConfidentialityCode.class, enumName);
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
		for (ConfidentialityCode x : values()) {
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
	private ConfidentialityCode(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
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
}
