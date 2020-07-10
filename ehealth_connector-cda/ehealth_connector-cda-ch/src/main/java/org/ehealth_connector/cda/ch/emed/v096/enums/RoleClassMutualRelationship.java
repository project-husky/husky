/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.cda.ch.emed.v096.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en"><p>    <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>A relationship that is based on mutual behavior of the two Entities as being related. The basis of such relationship may be agreements (e.g., spouses, contract parties) or they may be <i>de facto</i> behavior (e.g. friends) or may be an incidental involvement with each other (e.g. parties over a dispute, siblings, children).</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum RoleClassMutualRelationship implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">affiliate</div>
	 * <!-- @formatter:on -->
	 */
	AFFILIATE_L2("AFFL", "2.16.840.1.113883.5.110", "affiliate", "affiliate", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">agent</div>
	 * <!-- @formatter:on -->
	 */
	AGENT_L2("AGNT", "2.16.840.1.113883.5.110", "agent", "agent", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">assigned entity</div>
	 * <!-- @formatter:on -->
	 */
	ASSIGNED_ENTITY_L3("ASSIGNED", "2.16.840.1.113883.5.110", "assigned entity", "assigned entity",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">caregiver</div>
	 * <!-- @formatter:on -->
	 */
	CAREGIVER_L1("CAREGIVER", "2.16.840.1.113883.5.110", "caregiver", "caregiver", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Case Subject</div>
	 * <!-- @formatter:on -->
	 */
	CASE_SUBJECT_L3("CASEBJ", "2.16.840.1.113883.5.110", "Case Subject", "Case Subject",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">citizen</div>
	 * <!-- @formatter:on -->
	 */
	CITIZEN_L2("CIT", "2.16.840.1.113883.5.110", "citizen", "citizen", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">claimant</div>
	 * <!-- @formatter:on -->
	 */
	CLAIMANT_L3("CLAIM", "2.16.840.1.113883.5.110", "claimant", "claimant", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">clinical research investigator</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_RESEARCH_INVESTIGATOR_L2("CRINV", "2.16.840.1.113883.5.110",
			"clinical research investigator", "clinical research investigator", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">clinical research sponsor</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_RESEARCH_SPONSOR_L2("CRSPNSR", "2.16.840.1.113883.5.110", "clinical research sponsor",
			"clinical research sponsor", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">commissioning party</div>
	 * <!-- @formatter:on -->
	 */
	COMMISSIONING_PARTY_L4("COMPAR", "2.16.840.1.113883.5.110", "commissioning party",
			"commissioning party", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">contact</div>
	 * <!-- @formatter:on -->
	 */
	CONTACT_L3("CON", "2.16.840.1.113883.5.110", "contact", "contact", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">coverage sponsor</div>
	 * <!-- @formatter:on -->
	 */
	COVERAGE_SPONSOR_L2("SPNSR", "2.16.840.1.113883.5.110", "coverage sponsor", "coverage sponsor",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">covered party</div>
	 * <!-- @formatter:on -->
	 */
	COVERED_PARTY_L2("COVPTY", "2.16.840.1.113883.5.110", "covered party", "covered party",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">dependent</div>
	 * <!-- @formatter:on -->
	 */
	DEPENDENT_L4("DEPEN", "2.16.840.1.113883.5.110", "dependent", "dependent", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">emergency contact</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_CONTACT_L4("ECON", "2.16.840.1.113883.5.110", "emergency contact",
			"emergency contact", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">employee</div>
	 * <!-- @formatter:on -->
	 */
	EMPLOYEE_L2("EMP", "2.16.840.1.113883.5.110", "employee", "employee", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">guarantor GuarantorRole</div>
	 * <!-- @formatter:on -->
	 */
	GUARANTOR_GUARANTORROLE_L2("GUAR", "2.16.840.1.113883.5.110", "guarantor GuarantorRole",
			"guarantor GuarantorRole", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">guardian</div>
	 * <!-- @formatter:on -->
	 */
	GUARDIAN_L3("GUARD", "2.16.840.1.113883.5.110", "guardian", "guardian", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">healthcare provider</div>
	 * <!-- @formatter:on -->
	 */
	HEALTHCARE_PROVIDER_L3("PROV", "2.16.840.1.113883.5.110", "healthcare provider",
			"healthcare provider", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">individual</div>
	 * <!-- @formatter:on -->
	 */
	INDIVIDUAL_L4("INDIV", "2.16.840.1.113883.5.110", "individual", "individual", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Investigation Subject</div>
	 * <!-- @formatter:on -->
	 */
	INVESTIGATION_SUBJECT_L2("INVSBJ", "2.16.840.1.113883.5.110", "Investigation Subject",
			"Investigation Subject", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">invoice payor</div>
	 * <!-- @formatter:on -->
	 */
	INVOICE_PAYOR_L2("PAYOR", "2.16.840.1.113883.5.110", "invoice payor", "invoice payor",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">licensed entity</div>
	 * <!-- @formatter:on -->
	 */
	LICENSED_ENTITY_L2("LIC", "2.16.840.1.113883.5.110", "licensed entity", "licensed entity",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">military person</div>
	 * <!-- @formatter:on -->
	 */
	MILITARY_PERSON_L3("MIL", "2.16.840.1.113883.5.110", "military person", "military person",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">named insured</div>
	 * <!-- @formatter:on -->
	 */
	NAMED_INSURED_L3("NAMED", "2.16.840.1.113883.5.110", "named insured", "named insured",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">next of kin</div>
	 * <!-- @formatter:on -->
	 */
	NEXT_OF_KIN_L4("NOK", "2.16.840.1.113883.5.110", "next of kin", "next of kin", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">notary public</div>
	 * <!-- @formatter:on -->
	 */
	NOTARY_PUBLIC_L3("NOT", "2.16.840.1.113883.5.110", "notary public", "notary public",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">patient</div>
	 * <!-- @formatter:on -->
	 */
	PATIENT_L2("PAT", "2.16.840.1.113883.5.110", "patient", "patient", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">payee</div>
	 * <!-- @formatter:on -->
	 */
	PAYEE_L2("PAYEE", "2.16.840.1.113883.5.110", "payee", "payee", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">personal relationship</div>
	 * <!-- @formatter:on -->
	 */
	PERSONAL_RELATIONSHIP_L1("PRS", "2.16.840.1.113883.5.110", "personal relationship",
			"personal relationship", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">policy holder</div>
	 * <!-- @formatter:on -->
	 */
	POLICY_HOLDER_L2("POLHOLD", "2.16.840.1.113883.5.110", "policy holder", "policy holder",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">program eligible</div>
	 * <!-- @formatter:on -->
	 */
	PROGRAM_ELIGIBLE_L3("PROG", "2.16.840.1.113883.5.110", "program eligible", "program eligible",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">qualified entity</div>
	 * <!-- @formatter:on -->
	 */
	QUALIFIED_ENTITY_L2("QUAL", "2.16.840.1.113883.5.110", "qualified entity", "qualified entity",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">research subject</div>
	 * <!-- @formatter:on -->
	 */
	RESEARCH_SUBJECT_L3("RESBJ", "2.16.840.1.113883.5.110", "research subject", "research subject",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">RoleClassRelationshipFormal</div>
	 * <!-- @formatter:on -->
	 */
	ROLECLASSRELATIONSHIPFORMAL_L1("_RoleClassRelationshipFormal", "2.16.840.1.113883.5.110",
			"RoleClassRelationshipFormal", "RoleClassRelationshipFormal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">signing authority or officer</div>
	 * <!-- @formatter:on -->
	 */
	SIGNING_AUTHORITY_OR_OFFICER_L4("SGNOFF", "2.16.840.1.113883.5.110",
			"signing authority or officer", "signing authority or officer", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">student</div>
	 * <!-- @formatter:on -->
	 */
	STUDENT_L2("STD", "2.16.840.1.113883.5.110", "student", "student", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">subscriber</div>
	 * <!-- @formatter:on -->
	 */
	SUBSCRIBER_L4("SUBSCR", "2.16.840.1.113883.5.110", "subscriber", "subscriber", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">underwriter</div>
	 * <!-- @formatter:on -->
	 */
	UNDERWRITER_L2("UNDWRT", "2.16.840.1.113883.5.110", "underwriter", "underwriter", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for affiliate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFFILIATE_L2_CODE = "AFFL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for agent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AGENT_L2_CODE = "AGNT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for assigned entity</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ASSIGNED_ENTITY_L3_CODE = "ASSIGNED";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for caregiver</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CAREGIVER_L1_CODE = "CAREGIVER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Case Subject</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CASE_SUBJECT_L3_CODE = "CASEBJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for citizen</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CITIZEN_L2_CODE = "CIT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for claimant</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLAIMANT_L3_CODE = "CLAIM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for clinical research investigator</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_RESEARCH_INVESTIGATOR_L2_CODE = "CRINV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for clinical research sponsor</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_RESEARCH_SPONSOR_L2_CODE = "CRSPNSR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for commissioning party</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMMISSIONING_PARTY_L4_CODE = "COMPAR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for contact</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONTACT_L3_CODE = "CON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for coverage sponsor</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COVERAGE_SPONSOR_L2_CODE = "SPNSR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for covered party</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COVERED_PARTY_L2_CODE = "COVPTY";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for dependent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DEPENDENT_L4_CODE = "DEPEN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for emergency contact</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_CONTACT_L4_CODE = "ECON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for employee</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMPLOYEE_L2_CODE = "EMP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for guarantor GuarantorRole</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GUARANTOR_GUARANTORROLE_L2_CODE = "GUAR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for guardian</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GUARDIAN_L3_CODE = "GUARD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for healthcare provider</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEALTHCARE_PROVIDER_L3_CODE = "PROV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for individual</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INDIVIDUAL_L4_CODE = "INDIV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Investigation Subject</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INVESTIGATION_SUBJECT_L2_CODE = "INVSBJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for invoice payor</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INVOICE_PAYOR_L2_CODE = "PAYOR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for licensed entity</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LICENSED_ENTITY_L2_CODE = "LIC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for military person</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MILITARY_PERSON_L3_CODE = "MIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for named insured</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NAMED_INSURED_L3_CODE = "NAMED";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for next of kin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEXT_OF_KIN_L4_CODE = "NOK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for notary public</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NOTARY_PUBLIC_L3_CODE = "NOT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for patient</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATIENT_L2_CODE = "PAT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for payee</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAYEE_L2_CODE = "PAYEE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for personal relationship</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERSONAL_RELATIONSHIP_L1_CODE = "PRS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for policy holder</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POLICY_HOLDER_L2_CODE = "POLHOLD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for program eligible</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROGRAM_ELIGIBLE_L3_CODE = "PROG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for qualified entity</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUALIFIED_ENTITY_L2_CODE = "QUAL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for research subject</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RESEARCH_SUBJECT_L3_CODE = "RESBJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for RoleClassRelationshipFormal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLECLASSRELATIONSHIPFORMAL_L1_CODE = "_RoleClassRelationshipFormal";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for signing authority or officer</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIGNING_AUTHORITY_OR_OFFICER_L4_CODE = "SGNOFF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for student</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STUDENT_L2_CODE = "STD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for subscriber</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBSCRIBER_L4_CODE = "SUBSCR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for underwriter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNDERWRITER_L2_CODE = "UNDWRT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.19316";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "RoleClassMutualRelationship";

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
	public static RoleClassMutualRelationship getEnum(String code) {
		for (final RoleClassMutualRelationship x : values()) {
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
			Enum.valueOf(RoleClassMutualRelationship.class, enumName);
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
		for (final RoleClassMutualRelationship x : values()) {
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
	RoleClassMutualRelationship(String code, String codeSystem, String displayName,
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
