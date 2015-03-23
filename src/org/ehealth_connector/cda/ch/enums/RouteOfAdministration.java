/********************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 ********************************************************************************/

package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus HL7 RouteOfAdministration dürfen ebenfalls verwendet werden.Hinweis: Für Impfungen relevante Einträge sind fett markiert.</div>
 *<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés de HL7 RouteOfAdministration.Remarque : Les entrées pertinentes pour les vaccins sont indiquées en gras.</div>
 */
public enum RouteOfAdministration {

	/**
	 * <div class="de">Injektion, intradermal</div> <div class="fr">Injection
	 * intradermique</div>
	 */
	INJECTION_INTRADERMAL("IDINJ", "Injection, intradermal"),
	/**
	 * <div class="de">Inhalation, Vernebelung, nasal</div> <div
	 * class="fr">Inhalation par nébulisation nasale</div>
	 */
	INHALATION_NEBULIZATION_NASAL("NASNEB", "Inhalation, nebulization, nasal"),
	/**
	 * <div class="de">Schlucken, oral</div> <div class="fr">Prendre par la
	 * bouche</div>
	 */
	SWALLOW_ORAL("PO", "Swallow, oral "),
	/**
	 * <div class="de">Injektion, subkutan</div> <div class="fr">Injection
	 * sous-cutanée</div>
	 */
	INJECTION_SUBCUTANEOUS("SQ", "Injection, subcutaneous"),
	/**
	 * <div class="de">Diffusion, transdermal</div> <div class="fr">Diffusion
	 * transdermique</div>
	 */
	DIFFUSION_TRANSDERMAL("TRNSDERMD", "Diffusion, transdermal"),
	/**
	 * <div class="de">Injektion, intramuskulär</div> <div class="fr">Injection
	 * intra-musculaire</div>
	 */
	INJECTION_INTRAMUSCULAR("IM", "Injection, intramuscular");
	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static RouteOfAdministration getEnum(String code) {
		for (RouteOfAdministration x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	public static final String INJECTION_INTRADERMAL_CODE = "IDINJ";
	public static final String INHALATION_NEBULIZATION_NASAL_CODE = "NASNEB";
	public static final String SWALLOW_ORAL_CODE = "PO";
	public static final String INJECTION_SUBCUTANEOUS_CODE = "SQ";
	public static final String DIFFUSION_TRANSDERMAL_CODE = "TRNSDERMD";

	public static final String INJECTION_INTRAMUSCULAR_CODE = "IM";
	public static final String CODE_SYSTEM = "2.16.840.1.113883.5.112";

	public static final String CODE_SYSTEM_NAME = "HL7RouteOfAdministration";
	private String code;

	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div>
	 */
	RouteOfAdministration(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CODE_SYSTEM);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemId() {
		return CODE_SYSTEM;
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
	 * <div class="en">Gets the actual Code as string</div> <div
	 * class="de">Liefert den eigentlichen Code als String</div>
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
	public String getdisplayName() {
		return this.displayName;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumStr
	 * <br>
	 *            <div class="de"> enum str</div>
	 * @return true, if is enum of value set
	 */
	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}

	/**
	 * <div class="en">Checks if a given code is in this value set.</div> <div
	 * class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden
	 * ist.</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String code) {
		for (RouteOfAdministration x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}