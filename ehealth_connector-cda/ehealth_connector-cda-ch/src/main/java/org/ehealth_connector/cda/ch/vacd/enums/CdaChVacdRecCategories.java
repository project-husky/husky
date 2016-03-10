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
package org.ehealth_connector.cda.ch.vacd.enums;

import java.util.Arrays;
import java.util.Date;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * These enum contains the recommendation category for immunization in
 * switzerland valid from 20150101 Value-Set: CDA-CH-VACD rec-categories (OID:
 * 2.16.756.5.30.1.127.3.3.4)
 */
public enum CdaChVacdRecCategories {

	/**
	 * <div class="de"> Empfohlene Basisimpfungen</div>
	 * <div class="fr">Vaccinations recommandées de base</div>
	 * <div class="it">Vaccinazioni raccomandate di base</div>
	 */
	REC_BASE("41501", "Empfohlene Basisimpfungen", "Vaccinations recommandées de base", "Vaccinazioni raccomandate di base", "20150101", ""),

	/**
	 * <div class="de"> Empfohlene ergänzende Impfungen</div>
	 * <div class="fr">Vaccinations recommandées complémentaires</div>
	 * <div class="it">Vaccinazioni raccomandate complementari</div>
	 */
	REC_COMPL("41502", "Empfohlene ergänzende Impfungen", "Vaccinations recommandées complémentaires", "Vaccinazioni raccomandate complementari", "20150101", ""),

	/**
	 * <div class="de"> Impfungen ohne Empfehlungen</div>
	 * <div class="fr">Vaccinations sans recommandation d’utilisation</div>
	 * <div class="it">Vaccinazioni senza raccomandazione d’utilizzo</div>
	 */
	REC_NONE("41504", "Impfungen ohne Empfehlungen", "Vaccinations sans recommandation d’utilisation", "Vaccinazioni senza raccomandazione d’utilizzo", "20150101", ""),

	/**
	 * <div class="de"> Empfohlene Impfungen für Risikogruppen</div>
	 * <div class="fr">Vaccinations recommandées à des groupes à risque</div>
	 * <div class="it">Vaccinazioni raccomandate a die gruppi a rischio</div>
	 */
	REC_RISK("41503", "Empfohlene Impfungen für Risikogruppen", "Vaccinations recommandées à des groupes à risque", "Vaccinazioni raccomandate a die gruppi a rischio", "20150101", "");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "CDA-CH-VACD rec-categories";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.4";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static CdaChVacdRecCategories getEnum(String code) {
		for (final CdaChVacdRecCategories x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/** The code. */
	private String code;

	/** The display name. */
	private String displayNameDe;

	/** The display name. */
	private String displayNameFr;

	/** The display name. */
	private String displayNameIt;

	/** The valid from Date. */
	private Date validFrom;

	/** The valid to Date. */
	private Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display
	 * Name</div> <div class="de">Instantiiert dieses Enum Object mittels eines
	 * Codes und einem Display Name</div>.
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
	 * @param displayNameDe
	 *          the display name de
	 * @param displayNameFr
	 *          the display name fr
	 * @param displayNameIt
	 *          the display name it
	 */
	private CdaChVacdRecCategories(String code, String displayNameDe, String displayNameFr,
			String displayNameIt, String validFrom, String validTo) {
		this.code = code;
		this.displayNameDe = displayNameDe;
		this.displayNameFr = displayNameFr;
		this.displayNameIt = displayNameIt;
		if ((validFrom != null) && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if ((validTo != null) && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>.
	 *
	 * @param languageCode
	 *          the language code
	 * @return <div class="en">the code</div>
	 */
	public Code getCode(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null) {
			switch (languageCode) {
			case GERMAN:
				displayName = displayNameDe;
				break;
			case FRENCH:
				displayName = displayNameFr;
				break;
			case ITALIAN:
				displayName = displayNameIt;
				break;
			default:
				displayName = displayNameDe;
				break;
			}
		}
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
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
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert die
	 * code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the german display name.</div> <div class="de">Liefert
	 * display name in deutscher Sprache.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return displayNameDe;
	}

	/**
	 * <div class="en">Gets the german display name.</div> <div class="de">Liefert
	 * display name in deutscher Sprache.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayNameDe() {
		return displayNameDe;
	}

	/**
	 * <div class="en">Gets the french display name.</div> <div class="de">Liefert
	 * display name in französischer Sprache.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayNameFr() {
		return displayNameFr;
	}

	/**
	 * <div class="en">Gets the italian display name.</div>
	 * <div class="de">Liefert display name in italienischer Sprache.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayNameIt() {
		return displayNameIt;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumName
	 *          <br>
	 *          <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *          <br>
	 *          <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (final CdaChVacdRecCategories x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the code is valid now.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return isValid(null);
	}

	/**
	 * Checks if the code is valid for the specified date
	 *
	 * @param date
	 *          the date
	 * @return true, if is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if ((this.validFrom != null) && validFrom.after(date)) {
			return false;
		}
		if ((this.validTo != null) && validTo.before(date)) {
			return false;
		}
		return true;
	}
}
