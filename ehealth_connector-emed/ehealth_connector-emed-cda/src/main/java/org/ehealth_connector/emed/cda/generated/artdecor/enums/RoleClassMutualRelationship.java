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
package org.ehealth_connector.emed.cda.generated.artdecor.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * Enumeration of RoleClassMutualRelationship values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>A relationship that is based on mutual behavior of the two Entities as being related. The basis of such relationship may be agreements (e.g., spouses, contract parties) or they may be <i>de facto</i> behavior (e.g. friends) or may be an incidental involvement with each other (e.g. parties over a dispute, siblings, children).</p><br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.19316<br>
 * Effective date: 2014-03-26 00:00<br>
 * Version: DEFN=UV=VO=1360-20160323<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-09-08")
public enum RoleClassMutualRelationship implements ValueSetEnumInterface {

    /**
     * EN: affiliate<br>
     */
    AFFILIATE_L2("AFFL",
                 "2.16.840.1.113883.5.110",
                 "affiliate",
                 "affiliate",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: agent<br>
     */
    AGENT_L2("AGNT",
             "2.16.840.1.113883.5.110",
             "agent",
             "agent",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: assigned entity<br>
     */
    ASSIGNED_ENTITY_L3("ASSIGNED",
                       "2.16.840.1.113883.5.110",
                       "assigned entity",
                       "assigned entity",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: caregiver<br>
     */
    CAREGIVER_L1("CAREGIVER",
                 "2.16.840.1.113883.5.110",
                 "caregiver",
                 "caregiver",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Case Subject<br>
     */
    CASE_SUBJECT_L3("CASEBJ",
                    "2.16.840.1.113883.5.110",
                    "Case Subject",
                    "Case Subject",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: citizen<br>
     */
    CITIZEN_L2("CIT",
               "2.16.840.1.113883.5.110",
               "citizen",
               "citizen",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: claimant<br>
     */
    CLAIMANT_L3("CLAIM",
                "2.16.840.1.113883.5.110",
                "claimant",
                "claimant",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: clinical research investigator<br>
     */
    CLINICAL_RESEARCH_INVESTIGATOR_L2("CRINV",
                                      "2.16.840.1.113883.5.110",
                                      "clinical research investigator",
                                      "clinical research investigator",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: clinical research sponsor<br>
     */
    CLINICAL_RESEARCH_SPONSOR_L2("CRSPNSR",
                                 "2.16.840.1.113883.5.110",
                                 "clinical research sponsor",
                                 "clinical research sponsor",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: commissioning party<br>
     */
    COMMISSIONING_PARTY_L4("COMPAR",
                           "2.16.840.1.113883.5.110",
                           "commissioning party",
                           "commissioning party",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: contact<br>
     */
    CONTACT_L3("CON",
               "2.16.840.1.113883.5.110",
               "contact",
               "contact",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: coverage sponsor<br>
     */
    COVERAGE_SPONSOR_L2("SPNSR",
                        "2.16.840.1.113883.5.110",
                        "coverage sponsor",
                        "coverage sponsor",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: covered party<br>
     */
    COVERED_PARTY_L2("COVPTY",
                     "2.16.840.1.113883.5.110",
                     "covered party",
                     "covered party",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: dependent<br>
     */
    DEPENDENT_L4("DEPEN",
                 "2.16.840.1.113883.5.110",
                 "dependent",
                 "dependent",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: emergency contact<br>
     */
    EMERGENCY_CONTACT_L4("ECON",
                         "2.16.840.1.113883.5.110",
                         "emergency contact",
                         "emergency contact",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: employee<br>
     */
    EMPLOYEE_L2("EMP",
                "2.16.840.1.113883.5.110",
                "employee",
                "employee",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: guarantor GuarantorRole<br>
     */
    GUARANTOR_GUARANTORROLE_L2("GUAR",
                               "2.16.840.1.113883.5.110",
                               "guarantor GuarantorRole",
                               "guarantor GuarantorRole",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: guardian<br>
     */
    GUARDIAN_L3("GUARD",
                "2.16.840.1.113883.5.110",
                "guardian",
                "guardian",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: healthcare provider<br>
     */
    HEALTHCARE_PROVIDER_L3("PROV",
                           "2.16.840.1.113883.5.110",
                           "healthcare provider",
                           "healthcare provider",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: individual<br>
     */
    INDIVIDUAL_L4("INDIV",
                  "2.16.840.1.113883.5.110",
                  "individual",
                  "individual",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Investigation Subject<br>
     */
    INVESTIGATION_SUBJECT_L2("INVSBJ",
                             "2.16.840.1.113883.5.110",
                             "Investigation Subject",
                             "Investigation Subject",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: invoice payor<br>
     */
    INVOICE_PAYOR_L2("PAYOR",
                     "2.16.840.1.113883.5.110",
                     "invoice payor",
                     "invoice payor",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: licensed entity<br>
     */
    LICENSED_ENTITY_L2("LIC",
                       "2.16.840.1.113883.5.110",
                       "licensed entity",
                       "licensed entity",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: military person<br>
     */
    MILITARY_PERSON_L3("MIL",
                       "2.16.840.1.113883.5.110",
                       "military person",
                       "military person",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: named insured<br>
     */
    NAMED_INSURED_L3("NAMED",
                     "2.16.840.1.113883.5.110",
                     "named insured",
                     "named insured",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: next of kin<br>
     */
    NEXT_OF_KIN_L4("NOK",
                   "2.16.840.1.113883.5.110",
                   "next of kin",
                   "next of kin",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: notary public<br>
     */
    NOTARY_PUBLIC_L3("NOT",
                     "2.16.840.1.113883.5.110",
                     "notary public",
                     "notary public",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: patient<br>
     */
    PATIENT_L2("PAT",
               "2.16.840.1.113883.5.110",
               "patient",
               "patient",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: payee<br>
     */
    PAYEE_L2("PAYEE",
             "2.16.840.1.113883.5.110",
             "payee",
             "payee",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: personal relationship<br>
     */
    PERSONAL_RELATIONSHIP_L1("PRS",
                             "2.16.840.1.113883.5.110",
                             "personal relationship",
                             "personal relationship",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: policy holder<br>
     */
    POLICY_HOLDER_L2("POLHOLD",
                     "2.16.840.1.113883.5.110",
                     "policy holder",
                     "policy holder",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: program eligible<br>
     */
    PROGRAM_ELIGIBLE_L3("PROG",
                        "2.16.840.1.113883.5.110",
                        "program eligible",
                        "program eligible",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: qualified entity<br>
     */
    QUALIFIED_ENTITY_L2("QUAL",
                        "2.16.840.1.113883.5.110",
                        "qualified entity",
                        "qualified entity",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: research subject<br>
     */
    RESEARCH_SUBJECT_L3("RESBJ",
                        "2.16.840.1.113883.5.110",
                        "research subject",
                        "research subject",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: RoleClassRelationshipFormal<br>
     */
    ROLECLASSRELATIONSHIPFORMAL_L1("_RoleClassRelationshipFormal",
                                   "2.16.840.1.113883.5.110",
                                   "RoleClassRelationshipFormal",
                                   "RoleClassRelationshipFormal",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: signing authority or officer<br>
     */
    SIGNING_AUTHORITY_OR_OFFICER_L4("SGNOFF",
                                    "2.16.840.1.113883.5.110",
                                    "signing authority or officer",
                                    "signing authority or officer",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE"),
    /**
     * EN: student<br>
     */
    STUDENT_L2("STD",
               "2.16.840.1.113883.5.110",
               "student",
               "student",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: subscriber<br>
     */
    SUBSCRIBER_L4("SUBSCR",
                  "2.16.840.1.113883.5.110",
                  "subscriber",
                  "subscriber",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: underwriter<br>
     */
    UNDERWRITER_L2("UNDWRT",
                   "2.16.840.1.113883.5.110",
                   "underwriter",
                   "underwriter",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE");

    /**
     * EN: Code for affiliate<br>
     */
    public static final String AFFILIATE_L2_CODE = "AFFL";

    /**
     * EN: Code for agent<br>
     */
    public static final String AGENT_L2_CODE = "AGNT";

    /**
     * EN: Code for assigned entity<br>
     */
    public static final String ASSIGNED_ENTITY_L3_CODE = "ASSIGNED";

    /**
     * EN: Code for caregiver<br>
     */
    public static final String CAREGIVER_L1_CODE = "CAREGIVER";

    /**
     * EN: Code for Case Subject<br>
     */
    public static final String CASE_SUBJECT_L3_CODE = "CASEBJ";

    /**
     * EN: Code for citizen<br>
     */
    public static final String CITIZEN_L2_CODE = "CIT";

    /**
     * EN: Code for claimant<br>
     */
    public static final String CLAIMANT_L3_CODE = "CLAIM";

    /**
     * EN: Code for clinical research investigator<br>
     */
    public static final String CLINICAL_RESEARCH_INVESTIGATOR_L2_CODE = "CRINV";

    /**
     * EN: Code for clinical research sponsor<br>
     */
    public static final String CLINICAL_RESEARCH_SPONSOR_L2_CODE = "CRSPNSR";

    /**
     * EN: Code for commissioning party<br>
     */
    public static final String COMMISSIONING_PARTY_L4_CODE = "COMPAR";

    /**
     * EN: Code for contact<br>
     */
    public static final String CONTACT_L3_CODE = "CON";

    /**
     * EN: Code for coverage sponsor<br>
     */
    public static final String COVERAGE_SPONSOR_L2_CODE = "SPNSR";

    /**
     * EN: Code for covered party<br>
     */
    public static final String COVERED_PARTY_L2_CODE = "COVPTY";

    /**
     * EN: Code for dependent<br>
     */
    public static final String DEPENDENT_L4_CODE = "DEPEN";

    /**
     * EN: Code for emergency contact<br>
     */
    public static final String EMERGENCY_CONTACT_L4_CODE = "ECON";

    /**
     * EN: Code for employee<br>
     */
    public static final String EMPLOYEE_L2_CODE = "EMP";

    /**
     * EN: Code for guarantor GuarantorRole<br>
     */
    public static final String GUARANTOR_GUARANTORROLE_L2_CODE = "GUAR";

    /**
     * EN: Code for guardian<br>
     */
    public static final String GUARDIAN_L3_CODE = "GUARD";

    /**
     * EN: Code for healthcare provider<br>
     */
    public static final String HEALTHCARE_PROVIDER_L3_CODE = "PROV";

    /**
     * EN: Code for individual<br>
     */
    public static final String INDIVIDUAL_L4_CODE = "INDIV";

    /**
     * EN: Code for Investigation Subject<br>
     */
    public static final String INVESTIGATION_SUBJECT_L2_CODE = "INVSBJ";

    /**
     * EN: Code for invoice payor<br>
     */
    public static final String INVOICE_PAYOR_L2_CODE = "PAYOR";

    /**
     * EN: Code for licensed entity<br>
     */
    public static final String LICENSED_ENTITY_L2_CODE = "LIC";

    /**
     * EN: Code for military person<br>
     */
    public static final String MILITARY_PERSON_L3_CODE = "MIL";

    /**
     * EN: Code for named insured<br>
     */
    public static final String NAMED_INSURED_L3_CODE = "NAMED";

    /**
     * EN: Code for next of kin<br>
     */
    public static final String NEXT_OF_KIN_L4_CODE = "NOK";

    /**
     * EN: Code for notary public<br>
     */
    public static final String NOTARY_PUBLIC_L3_CODE = "NOT";

    /**
     * EN: Code for patient<br>
     */
    public static final String PATIENT_L2_CODE = "PAT";

    /**
     * EN: Code for payee<br>
     */
    public static final String PAYEE_L2_CODE = "PAYEE";

    /**
     * EN: Code for personal relationship<br>
     */
    public static final String PERSONAL_RELATIONSHIP_L1_CODE = "PRS";

    /**
     * EN: Code for policy holder<br>
     */
    public static final String POLICY_HOLDER_L2_CODE = "POLHOLD";

    /**
     * EN: Code for program eligible<br>
     */
    public static final String PROGRAM_ELIGIBLE_L3_CODE = "PROG";

    /**
     * EN: Code for qualified entity<br>
     */
    public static final String QUALIFIED_ENTITY_L2_CODE = "QUAL";

    /**
     * EN: Code for research subject<br>
     */
    public static final String RESEARCH_SUBJECT_L3_CODE = "RESBJ";

    /**
     * EN: Code for RoleClassRelationshipFormal<br>
     */
    public static final String ROLECLASSRELATIONSHIPFORMAL_L1_CODE = "_RoleClassRelationshipFormal";

    /**
     * EN: Code for signing authority or officer<br>
     */
    public static final String SIGNING_AUTHORITY_OR_OFFICER_L4_CODE = "SGNOFF";

    /**
     * EN: Code for student<br>
     */
    public static final String STUDENT_L2_CODE = "STD";

    /**
     * EN: Code for subscriber<br>
     */
    public static final String SUBSCRIBER_L4_CODE = "SUBSCR";

    /**
     * EN: Code for underwriter<br>
     */
    public static final String UNDERWRITER_L2_CODE = "UNDWRT";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.19316";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "RoleClassMutualRelationship";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static RoleClassMutualRelationship getEnum(final String code) {
        for (final RoleClassMutualRelationship x : values()) {
            if (x.getCodeValue().equals(code)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given enum is part of this value set.
     *
     * @param enumName The name of the enum.
     * @return {@code true} if the name is found in this value set, {@code false} otherwise.
     */
    public static boolean isEnumOfValueSet(final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(RoleClassMutualRelationship.class,
                         enumName);
            return true;
        } catch (final IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Checks if a given code value is in this value set.
     *
     * @param codeValue The code value.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(final String codeValue) {
        for (final RoleClassMutualRelationship x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    private String code;

    /**
     * Identifier of the referencing code system.
     */
    private String codeSystem;

    /**
     * The display names per language.
     */
    private Map<LanguageCode, String> displayNames;

    /**
     * Instantiates this enum with a given code and display names.
     *
     * @param code          The code value.
     * @param codeSystem    The code system (OID).
     * @param displayName   The default display name.
     * @param displayNameEn The display name in English.
     * @param displayNameDe The display name in German.
     * @param displayNameFr The display name in French.
     * @param displayNameIt The display name in Italian.
     */
    RoleClassMutualRelationship(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
        this.code = code;
        this.codeSystem = codeSystem;
        this.displayNames = new HashMap<>();
        this.displayNames.put(null,
                              displayName);
        this.displayNames.put(LanguageCode.ENGLISH,
                              displayNameEn);
        this.displayNames.put(LanguageCode.GERMAN,
                              displayNameDe);
        this.displayNames.put(LanguageCode.FRENCH,
                              displayNameFr);
        this.displayNames.put(LanguageCode.ITALIAN,
                              displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system identifier.
     */
    @Override
    public String getCodeSystemName() {
        final CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
        if (cs != null) {
            return cs.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param. If there is no english translation, the default display name
     *      is returned.
     *
     * @param languageCode The language code to get the display name for.
     * @return the display name in the desired language. if language not found, display name in german will be returned.
     */
    @Override
    public String getDisplayName(final LanguageCode languageCode) {
        final String displayName = this.displayNames.get(languageCode);
        if (displayName == null && languageCode == LanguageCode.ENGLISH) {
            return this.displayNames.get(null);
        }
        return displayName;
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
