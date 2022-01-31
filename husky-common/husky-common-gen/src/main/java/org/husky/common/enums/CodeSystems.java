/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

package org.husky.common.enums;

import org.husky.common.model.IdentityDomain;

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
	ICR_DHA_08040_DISEASE("2.16.756.5.30.1.127.3.1.20080401.1",
			"diseaseName (ICR-DHA, chapter 2.1.1)"),
	/**
	 * OID: 2.51.1.3 <div class="en"> Global Location Number</div>
	 */
	GLN("2.51.1.3", "Global Location Number"),
	/**
	 * OID: 1.3.160 <div class="en">Global Trade Item Number</div>
	 */
	GTIN("2.51.1.1", "Global Trade Item Number"),
	/**
	 * <div class="en">SwissINDEX</div> OID: 2.16.756.5.32
	 * <div class="de">SwissINDEX</div> <div class="fr">SwissIndex</div>
	 */
	SWISS_INDEX("2.16.756.5.30.2.6.1", "SwissINDEX"),
	/**
	 * OID: 2.16.756.5.32 <div class="en">WHO ATC Code</div><div class="de">WHO
	 * ATC Code</div> <div class="fr">WHO ATC Code</div>
	 */
	WHO_ATC_CODE("2.16.840.1.113883.6.73", "WHO ATC Code"),
	/**
	 * OID: 2.16.756.5.30.1.129.1.3 <div class="en">Swiss Analysis List</div>
	 * <div class="de">Analysenliste (AL)</div> <div class="fr">Liste des
	 * analyses (LA)</div>
	 */
	SWISS_AL("2.16.756.5.30.1.129.1.3", "Swiss analysis list (AL)"),
	/**
	 * OID: 2.16.756.5.30.1.129.1.4 <div class="en">Swiss Tarmed</div>
	 * <div class="de">Tarmed</div> <div class="fr">Tarmed</div>
	 */
	SWISS_TARMED("2.16.756.5.30.1.129.1.4", "Swiss Tarmed"),
	/**
	 * OID: 2.16.756.5.32 <div class="en">AHV Number (the new one)</div>
	 * <div class="de">AHV Nummer (die Neue)</div> <div class="fr">No AVS (le
	 * nouveaux)</div>
	 */
	SWISS_SSN("2.16.756.5.32", "AHV Nummer (die Neue)"),
	/**
	 * OID: 2.16.756.5.32 <div class="en">AHV Number (the new one)</div>
	 * <div class="de">AHV Nummer (die Neue)</div> <div class="fr">No AVS (le
	 * nouveaux)</div>
	 */
	SWISS_ZSR("2.16.756.5.30.1.123.100.2.1.1", "ZSR Nummer der SASIS"),

	/**
	 * OID: 2.16.756.5.31 <div class="en">AHV Number (the old one)</div>
	 * <div class="de">AHV Nummer (die Alte)</div> <div class="fr">No AVS (le
	 * vieil)</div>
	 */
	SWISS_SSN_DEPRECATED("2.16.756.5.31", "AHV Nummer (die Alte)"),
	/**
	 * OID: 2.16.756.5.30.1.123.100.1.1.1 <div class="en">Insurance Card Number
	 * (VeKa)</div> <div class="de">Kartennummern für die Versichertenkarte
	 * (VeKa)</div> <div class="fr">No carte d insurance (VeKa)</div>
	 */
	SWISS_VEKA_NR("2.16.756.5.30.1.123.100.1.1.1",
			"Kartennummern für die Versichertenkarte (VeKa)"),
	/**
	 * OID: 2.16.756.5.31 <div class= "en">ICD-10 </div> <div class= "de">ICD-10
	 * </div> <div class= "fr">ICD-10 </div>
	 */
	ICD10("2.16.756.5.30.1.126.3.2", "ICD-10"),
	/**
	 * OID: 2.16.840.1.113883.6.121 <div class="en">Language Code</div>
	 */
	LANGUAGE_CODE("2.16.840.1.113883.6.121", "Language Code"),
	/**
	 * OID: 2.16.840.1.113883.5.25 <div class="en">Confidentiality Code</div>
	 */
	CONFIDENTIALITY_CODE("2.16.840.1.113883.5.25", "Confidentiality Code"),
	/**
	 * OID: 2.16.840.1.113883.5.1 <div class="en">AdministrativeGender </div>
	 */
	ADMINISTRATIVE_GENDER("2.16.840.1.113883.5.1", "HL7 AdministrativeGender"),

	/**
	 * OID: 2.16.840.1.113883.5.1119 <div class="en">AddressUse</div>
	 */
	ADDRESS_USE("2.16.840.1.113883.5.1119", "AddressUse"),

	/**
	 * OID: 2.16.840.1.113883.5.89 <div class="en">ParticipationSignature</div>
	 */
	PARTICIPANT_SIGNATURE("2.16.840.1.113883.5.89", "ParticipationSignature"),

	/**
	 * OID: 2.16.840.1.113883.5.14 <div class="en">ActStatus</div>
	 */
	ACT_STATUS("2.16.840.1.113883.5.14", "ActStatus"),

	/**
	 * OID: 2.16.840.1.113883.6.96 <div class="en">SNOMED CT</div>
	 */
	SNOMEDCT("2.16.840.1.113883.6.96", "SNOMED CT"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.3.2013.1 <div class="en">Risc of
	 * complications</div><div class="de">Komplikationsrisiken</div>
	 */
	RISC_OF_COMPLICATIONS("2.16.756.5.30.1.127.3.3.2013.1", "Komplikationsrisiken"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.3.2013.2 <div class="en">Risc of
	 * Exposure</div><div class="de">Expositionsrisiken</div>
	 */
	RISC_OF_EXPOSURE("2.16.756.5.30.1.127.3.3.2015.2", "Expositionsrisiken"),

	/**
	 * OID: 2.16.840.1.113883.5.4 <div class="en">HL7ActCode</div>
	 */
	HL7_ACT_CODE("2.16.840.1.113883.5.4", "HL7ActCode"),

	/**
	 * OID: 2.16.840.1.113883.5.1063
	 * <div class="en">HL7SeverityObservation</div>
	 */
	HL7_SEVERITY_OBSERVATION("2.16.840.1.113883.5.1063", "HL7SeverityObservation"),

	/**
	 * OID: 2.16.840.1.113883.5.112
	 * <div class="en">HL7RouteOfAdministration</div>
	 */
	HL7_ROUTE_OF_ADMINISTRATION("2.16.840.1.113883.5.112", "HL7RouteOfAdministration"),

	/**
	 * OID: 2.16.840.1.113883.6.1 <div class="en">LOINC</div>
	 */
	LOINC("2.16.840.1.113883.6.1", "LOINC"),

	/**
	 * OID: 2.16.840.1.113883.5.83
	 * <div class="en">HL7ObservationInterpretation</div>
	 */
	HL7_OBSERVATION_INTERPRETATION("2.16.840.1.113883.5.83", "HL7ObservationInterpretation"),

	/**
	 * OID: 2.16.840.1.113883.5.1008 <div class="en">HL7nullFlavor</div>
	 */
	HL7_NULL_FLAVOR("2.16.840.1.113883.5.1008", "HL7nullFlavor"),

	/**
	 * OID: 2.16.840.1.113883.6.294 <div class="en">WHO Drug Dictionary
	 * Medicinal Product ID</div>
	 */
	WHO_D_D_MED_PPROD_ID("2.16.840.1.113883.6.294", "WHO Drug Dictionary Medicinal Product ID"),

	/**
	 * OID: 2.16.756.5.30.1.129.1.1.8 <div class="en">Swiss SOAS HLA Codes</div>
	 */
	SWISS_SOAS_HLA_CODES("2.16.756.5.30.1.129.1.1.8", "Swiss SOAS HLA"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.2.20121101.2 <div class="en">Swiss PLRR-DHA
	 * LabObsList Codes</div>
	 */
	SWISS_PLRR_DHA_LAB_OBS_LIST("2.16.756.5.30.1.127.3.2.20121101.2", "Swiss PLRR-DHA LabObsList"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.10.3 Swiss EPR-SPID
	 */
	SWISS_EPR_SPID("2.16.756.5.30.1.127.3.10.3", "Swiss EPR-SPID"),

	/**
	 * OID: 2.16.840.1.113883.5.88 Participation Function
	 */
	PARTICIPATION_FUNCTION("2.16.840.1.113883.5.88", "Participation Function");

	/**
	 * <div class="en">Gets the Enum with a given OID</div>
	 * <div class="de">Liefert den Enum anhand einer gegebenen OID</div>
	 *
	 * @param codeSystemId
	 *            the code system OID.
	 * @return the desired Enum.
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
