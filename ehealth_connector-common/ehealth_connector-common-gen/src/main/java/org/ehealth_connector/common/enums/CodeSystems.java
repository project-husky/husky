/*
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

package org.ehealth_connector.common.enums;

import org.ehealth_connector.valueset.enums.IdentityDomain;

/**
 * Bekannte und häufig gebrauchte Identifikationsdomänen
 * <ul>
 * <li>Global Location Number (GLN): 2.51.1.3</li>
 * <li>Global Trade Item Number (GTIN): 1.3.160</li>
 * </ul>
 */
public enum CodeSystems implements IdentityDomain {

	/**
	 * OID: 2.16.756.5.30.1.127.3.1.20080401.1 <div class="de">Krankheiten und
	 * Unfallfolgen (VVK-EDI, Kapitel 2.1.1)</div> <div class="fr">Désignation
	 * de la maladie ou de la séquelle d’accident (OCA-DFI, chapitre
	 * 2.1.1)</div>
	 */
	IcrDha080401Disease("2.16.756.5.30.1.127.3.1.20080401.1", "diseaseName (ICR-DHA, chapter 2.1.1)"),
	/**
	 * OID: 2.51.1.3 <div class="en"> Global Location Number</div>
	 */
	GLN("2.51.1.3", "Global Location Number"),
	/**
	 * OID: 1.3.160 <div class="en">Global Trade Item Number</div>
	 */
	GTIN("1.3.160", "Global Trade Item Number"),
	/**
	 * <div class="en">SwissINDEX</div> OID: 2.16.756.5.32
	 * <div class="de">SwissINDEX</div> <div class="fr">SwissIndex</div>
	 */
	SwissINDEX("2.16.756.5.30.2.6.1", "SwissINDEX"),
	/**
	 * OID: 2.16.756.5.32 <div class="en">WHO ATC Code</div><div class="de">WHO
	 * ATC Code</div> <div class="fr">WHO ATC Code</div>
	 */
	WHOATCCode("2.16.840.1.113883.6.73", "WHO ATC Code"),
	/**
	 * OID: 2.16.756.5.30.1.129.1.3 <div class="en">Swiss Analysis List</div>
	 * <div class="de">Analysenliste (AL)</div> <div class="fr">Liste des
	 * analyses (LA)</div>
	 */
	SwissAL("2.16.756.5.30.1.129.1.3", "Swiss Analysis List"),
	/**
	 * OID: 2.16.756.5.32 <div class="en">AHV Number (the new one)</div>
	 * <div class="de">AHV Nummer (die Neue)</div> <div class="fr">No AVS (le
	 * nouveaux)</div>
	 */
	SwissSSN("2.16.756.5.32", "AHV Nummer (die Neue)"),
	/**
	 * OID: 2.16.756.5.32 <div class="en">AHV Number (the new one)</div>
	 * <div class="de">AHV Nummer (die Neue)</div> <div class="fr">No AVS (le
	 * nouveaux)</div>
	 */
	SwissZSR("2.16.756.5.30.1.123.100.2.1.1", "ZSR Nummer der SASIS"),

	/**
	 * OID: 2.16.756.5.31 <div class="en">AHV Number (the old one)</div>
	 * <div class="de">AHV Nummer (die Alte)</div> <div class="fr">No AVS (le
	 * vieil)</div>
	 */
	SwissSSNDeprecated("2.16.756.5.31", "AHV Nummer (die Alte)"),
	/**
	 * OID: 2.16.756.5.30.1.123.100.1.1.1 <div class="en">Insurance Card Number
	 * (VeKa)</div> <div class="de">Kartennummern für die Versichertenkarte
	 * (VeKa)</div> <div class="fr">No carte d insurance (VeKa)</div>
	 */
	SWISS_VEKA_NR("2.16.756.5.30.1.123.100.1.1.1", "Kartennummern für die Versichertenkarte (VeKa)"),
	/**
	 * OID: 2.16.756.5.31 <div class= "en">ICD-10 </div> <div class= "de">ICD-10
	 * </div> <div class= "fr">ICD-10 </div>
	 */
	ICD10("2.16.756.5.30.1.126.3.2", "ICD-10"),
	/**
	 * OID: 2.16.840.1.113883.6.121 <div class="en">Language Code</div>
	 */
	LanguageCode("2.16.840.1.113883.6.121", "Language Code"),
	/**
	 * OID: 2.16.840.1.113883.5.25 <div class="en">Confidentiality Code</div>
	 */
	ConfidentialityCode("2.16.840.1.113883.5.25", "Confidentiality Code"),
	/**
	 * OID: 2.16.840.1.113883.5.1 <div class="en">AdministrativeGender </div>
	 */
	AdministrativeGender("2.16.840.1.113883.5.1", "AdministrativeGender"),

	/**
	 * OID: 2.16.840.1.113883.5.1119 <div class="en">AddressUse</div>
	 */
	AddressUse("2.16.840.1.113883.5.1119", "AddressUse"),

	/**
	 * OID: 2.16.840.1.113883.5.89 <div class="en">ParticipationSignature</div>
	 */
	ParticipationSignature("2.16.840.1.113883.5.89", "ParticipationSignature"),

	/**
	 * OID: 2.16.840.1.113883.5.14 <div class="en">ActStatus</div>
	 */
	ActStatus("2.16.840.1.113883.5.14", "ActStatus"),

	/**
	 * OID: 2.16.840.1.113883.6.96 <div class="en">SNOMED CT</div>
	 */
	SNOMEDCT("2.16.840.1.113883.6.96", "SNOMED CT"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.3.2013.1 <div class="en">Risc of
	 * complications</div><div class="de">Komplikationsrisiken</div>
	 */
	RiscOfComplications("2.16.756.5.30.1.127.3.3.2013.1", "Komplikationsrisiken"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.3.2013.2 <div class="en">Risc of
	 * Exposure</div><div class="de">Expositionsrisiken</div>
	 */
	RiscOfExposure("2.16.756.5.30.1.127.3.3.2015.2", "Expositionsrisiken"),

	/**
	 * OID: 2.16.840.1.113883.5.4 <div class="en">HL7ActCode</div>
	 */
	HL7ActCode("2.16.840.1.113883.5.4", "HL7ActCode"),

	/**
	 * OID: 2.16.840.1.113883.5.1063
	 * <div class="en">HL7SeverityObservation</div>
	 */
	HL7SeverityObservation("2.16.840.1.113883.5.1063", "HL7SeverityObservation"),

	/**
	 * OID: 2.16.840.1.113883.5.112
	 * <div class="en">HL7RouteOfAdministration</div>
	 */
	HL7RouteOfAdministration("2.16.840.1.113883.5.112", "HL7RouteOfAdministration"),

	/**
	 * OID: 2.16.840.1.113883.6.1 <div class="en">LOINC</div>
	 */
	LOINC("2.16.840.1.113883.6.1", "LOINC"),

	/**
	 * OID: 2.16.840.1.113883.5.83
	 * <div class="en">HL7ObservationInterpretation</div>
	 */
	HL7ObservationInterpretation("2.16.840.1.113883.5.83", "HL7ObservationInterpretation"),

	/**
	 * OID: 2.16.840.1.113883.5.1008 <div class="en">HL7nullFlavor</div>
	 */
	HL7nullFlavor("2.16.840.1.113883.5.1008", "HL7nullFlavor"),

	/**
	 * OID: 2.16.840.1.113883.6.294 <div class="en">WHO Drug Dictionary
	 * Medicinal Product ID</div>
	 */
	WHO_D_D_MED_PPROD_ID("2.16.840.1.113883.6.294", "WHO Drug Dictionary Medicinal Product ID");

	/**
	 * TODO tsc dokumentieren <div class="en">Gets the Enum with a given
	 * code</div> <div class="de">Liefert den Enum anhand eines gegebenen
	 * codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static CodeSystems getEnum(String codeSystemId) {
		for (CodeSystems x : values()) {
			if (x.getCodeSystemId().equals(codeSystemId)) {
				return x;
			}
		}
		return null;
	}

	private String codeSystem;

	private String codeSystemName;

	CodeSystems(String oid, String name) {
		codeSystem = oid;
		codeSystemName = name;
	}

	@Override
	public String getCodeSystemId() {
		return codeSystem;
	}

	@Override
	public String getCodeSystemName() {
		return codeSystemName;
	}

}
