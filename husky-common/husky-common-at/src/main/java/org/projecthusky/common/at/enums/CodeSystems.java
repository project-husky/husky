/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.common.at.enums;

/**
 * Bekannte und häufig gebrauchte Identifikationsdomänen
 * <ul>
 * <li>Global Location Number (GLN): 2.51.1.3</li>
 * <li>Global Trade Item Number (GTIN): 1.3.160</li>
 * </ul>
 */
public enum CodeSystems implements org.projecthusky.common.model.IdentityDomain {

	/**
	 * OID: 2.16.756.5.30.1.127.3.1.20080401.1
	 */
	IcrDha080401Disease("2.16.756.5.30.1.127.3.1.20080401.1",
			"diseaseName (ICR-DHA, chapter 2.1.1)"),
	/**
	 * OID: 2.51.1.3 Global Location Number
	 */
	GLN("2.51.1.3", "Global Location Number"),
	/**
	 * OID: 1.3.160 Global Trade Item Number
	 */
	GTIN("2.51.1.1", "Global Trade Item Number"),
	/**
	 * SwissINDEX OID: 2.16.756.5.32
	 */
	SwissINDEX("2.16.756.5.30.2.6.1", "SwissINDEX"),
	/**
	 * OID: 2.16.756.5.32 WHO ATC Code
	 */
	WHOATCCode("2.16.840.1.113883.6.73", "WHO ATC Code"),
	/**
	 * OID: 2.16.756.5.30.1.129.1.3 Swiss Analysis List
	 */
	SwissAL("2.16.756.5.30.1.129.1.3", "Swiss analysis list (AL)"),
	/**
	 * OID: 2.16.756.5.30.1.129.1.4 Swiss Tarmed
	 */
	SwissTarmed("2.16.756.5.30.1.129.1.4", "Swiss Tarmed"),
	/**
	 * OID: 2.16.756.5.32 AHV Number (the new one)
	 */
	SwissSSN("2.16.756.5.32", "AHV Nummer (die Neue)"),
	/**
	 * OID: 2.16.756.5.32 AHV Number (the new one)
	 */
	SwissZSR("2.16.756.5.30.1.123.100.2.1.1", "ZSR Nummer der SASIS"),

	/**
	 * OID: 2.16.756.5.31 AHV Number (the old one)
	 */
	SwissSSNDeprecated("2.16.756.5.31", "AHV Nummer (die Alte)"),
	/**
	 * OID: 2.16.756.5.30.1.123.100.1.1.1 Insurance Card Number (VeKa)
	 */
	SWISS_VEKA_NR("2.16.756.5.30.1.123.100.1.1.1",
			"Kartennummern für die Versichertenkarte (VeKa)"),
	/**
	 * OID: 2.16.756.5.31 ICD-10
	 */
	ICD10("2.16.756.5.30.1.126.3.2", "ICD-10"),
	/**
	 * OID: 2.16.840.1.113883.6.121 Language Code
	 */
	LanguageCode("2.16.840.1.113883.6.121", "Language Code"),
	/**
	 * OID: 2.16.840.1.113883.5.25 HL7:Confidentiality
	 */
	ConfidentialityCode("2.16.840.1.113883.5.25", "HL7:Confidentiality"),
	/**
	 * OID: 2.16.840.1.113883.5.1 AdministrativeGender
	 */
	AdministrativeGender("2.16.840.1.113883.5.1", "HL7:AdministrativeGender"),

	/**
	 * OID: 2.16.840.1.113883.5.1119 AddressUse
	 */
	AddressUse("2.16.840.1.113883.5.1119", "AddressUse"),

	/**
	 * OID: 2.16.840.1.113883.5.89 ParticipationSignature
	 */
	ParticipationSignature("2.16.840.1.113883.5.89", "ParticipationSignature"),

	/**
	 * OID: 2.16.840.1.113883.5.14 ActStatus
	 */
	ActStatus("2.16.840.1.113883.5.14", "ActStatus"),

	/**
	 * OID: 2.16.840.1.113883.6.96 SNOMED CT
	 */
	SNOMEDCT("2.16.840.1.113883.6.96", "SNOMED CT"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.3.2013.1 Risc of complications
	 */
	RiscOfComplications("2.16.756.5.30.1.127.3.3.2013.1", "Komplikationsrisiken"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.3.2013.2 Risc of Exposure
	 */
	RiscOfExposure("2.16.756.5.30.1.127.3.3.2015.2", "Expositionsrisiken"),

	/**
	 * OID: 2.16.840.1.113883.5.4 HL7ActCode
	 */
	HL7ActCode("2.16.840.1.113883.5.4", "HL7ActCode"),

	/**
	 * OID: 2.16.840.1.113883.5.1063 HL7SeverityObservation
	 */
	HL7SeverityObservation("2.16.840.1.113883.5.1063", "HL7SeverityObservation"),

	/**
	 * OID: 2.16.840.1.113883.5.112 HL7RouteOfAdministration
	 */
	HL7RouteOfAdministration("2.16.840.1.113883.5.112", "HL7RouteOfAdministration"),

	/**
	 * OID: 2.16.840.1.113883.6.1 LOINC
	 */
	LOINC("2.16.840.1.113883.6.1", "LOINC"),

	/**
	 * OID: 2.16.840.1.113883.5.83 HL7ObservationInterpretation
	 */
	HL7ObservationInterpretation("2.16.840.1.113883.5.83", "HL7ObservationInterpretation"),

	/**
	 * OID: 2.16.840.1.113883.5.1008 HL7nullFlavor
	 */
	HL7nullFlavor("2.16.840.1.113883.5.1008", "HL7nullFlavor"),

	/**
	 * OID: 2.16.840.1.113883.6.294 WHO Drug Dictionary Medicinal Product ID
	 */
	WHO_D_D_MED_PPROD_ID("2.16.840.1.113883.6.294", "WHO Drug Dictionary Medicinal Product ID"),

	/**
	 * OID: 2.16.756.5.30.1.129.1.1.8 Swiss SOAS HLA Codes
	 */
	SwissSoasHlaCodes("2.16.756.5.30.1.129.1.1.8", "Swiss SOAS HLA"),

	/**
	 * OID: 2.16.756.5.30.1.127.3.2.20121101.2 Swiss PLRR-DHA LabObsList Codes
	 */
	SwissPlrrDhaLabObsList("2.16.756.5.30.1.127.3.2.20121101.2", "Swiss PLRR-DHA LabObsList");

	/**
	 * Gets the Enum with a given OID
	 *
	 * @param codeSystemId the code system OID.
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
