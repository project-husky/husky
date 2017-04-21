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

package org.ehealth_connector.cda.ch.edes.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

/*
 *<div class="de">Das folgende Subset ist für den vorliegenden Implementierungsleitfaden abschliessend. Andere Codes sind NICHT ERLAUBT.</div>
 *<div class="fr">Domaine de valeurs pour « Code dinterprétation »</div>
 */
public enum ObservationInterpretationForVitalSign {
	//@formatter:off
	/** <div class="en">Abnormal</div><div class="de">Abnormal</div> */
	ABNORMAL(ObservationInterpretation.ABNORMAL),
	/** <div class="en">Abnormal alert</div><div class="de">Abnormal (alarmierend)</div> */
	ABNORMAL_ALERT(ObservationInterpretation.ABNORMAL_ALERT),
	/** <div class="en">High</div><div class="de">Oberhalb Toleranz</div> */
	HIGH(ObservationInterpretation.HIGH),
	/** <div class="en">High alert</div><div class="de">Oberhalb Toleranz (alarmierend)</div> */
	HIGH_ALERT(ObservationInterpretation.HIGH_ALERT),
	/** <div class="en">Low</div><div class="de">Unterhalb Toleranz</div> */
	LOW(ObservationInterpretation.LOW),
	/** <div class="en">Low alert</div><div class="de">Unterhalb Toleranz (alarmierend)</div>. */
	LOW_ALERT(ObservationInterpretation.LOW_ALERT),
	/** <div class="en">Normal</div><div class="de">Normal</div> */
	NORMAL(ObservationInterpretation.NORMAL);
	//@formatter:on

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ObservationInterpretationForVitalSign getEnum(String code) {
		for (ObservationInterpretationForVitalSign x : values()) {
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
			Enum.valueOf(ObservationInterpretationForVitalSign.class, enumName);
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
		for (ObservationInterpretationForVitalSign x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	private ObservationInterpretation commonInterpretation;

	private ObservationInterpretationForVitalSign(ObservationInterpretation commonInterpretation) {
		this.commonInterpretation = commonInterpretation;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		return commonInterpretation.getCE();
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		return commonInterpretation.getCode();
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return commonInterpretation.getCodeSystemName();
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return commonInterpretation.getCodeSystemOid();
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return commonInterpretation.getCodeValue();
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return commonInterpretation.getDisplayName();
	}
}
