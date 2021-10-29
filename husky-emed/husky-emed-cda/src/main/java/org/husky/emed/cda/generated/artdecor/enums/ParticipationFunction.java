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
package org.husky.emed.cda.generated.artdecor.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of ParticipationFunction values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>This code is used to specify the exact function an actor had in a service in all necessary detail. This domain may include local extensions (CWE).</p><br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.10267<br>
 * Effective date: 2014-03-26 00:00<br>
 * Version: DEFN=UV=VO=1360-20160323<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-09-08")
public enum ParticipationFunction implements ValueSetEnumInterface {

    /**
     * EN: admitting physician<br>
     */
    ADMITTING_PHYSICIAN("ADMPHYS",
                        "2.16.840.1.113883.5.88",
                        "admitting physician",
                        "admitting physician",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: anesthesia nurse<br>
     */
    ANESTHESIA_NURSE("ANRS",
                     "2.16.840.1.113883.5.88",
                     "anesthesia nurse",
                     "anesthesia nurse",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: anesthesist<br>
     */
    ANESTHESIST("ANEST",
                "2.16.840.1.113883.5.88",
                "anesthesist",
                "anesthesist",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: assembly software<br>
     */
    ASSEMBLY_SOFTWARE("ASSEMBLER",
                      "2.16.840.1.113883.5.88",
                      "assembly software",
                      "assembly software",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: attending physician<br>
     */
    ATTENDING_PHYSICIAN("ATTPHYS",
                        "2.16.840.1.113883.5.88",
                        "attending physician",
                        "attending physician",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: AuthorizedParticipationFunction<br>
     */
    AUTHORIZEDPARTICIPATIONFUNCTION("_AuthorizedParticipationFunction",
                                    "2.16.840.1.113883.5.88",
                                    "AuthorizedParticipationFunction",
                                    "AuthorizedParticipationFunction",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE"),
    /**
     * EN: AuthorizedReceiverParticipationFunction<br>
     */
    AUTHORIZEDRECEIVERPARTICIPATIONFUNCTION_L1("_AuthorizedReceiverParticipationFunction",
                                               "2.16.840.1.113883.5.88",
                                               "AuthorizedReceiverParticipationFunction",
                                               "AuthorizedReceiverParticipationFunction",
                                               "TOTRANSLATE",
                                               "TOTRANSLATE",
                                               "TOTRANSLATE"),
    /**
     * EN: authorized provider masking author<br>
     */
    AUTHORIZED_PROVIDER_MASKING_AUTHOR_L2("PROMSK",
                                          "2.16.840.1.113883.5.88",
                                          "authorized provider masking author",
                                          "authorized provider masking author",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE"),
    /**
     * EN: caregiver information receiver<br>
     */
    CAREGIVER_INFORMATION_RECEIVER_L2("AUCG",
                                      "2.16.840.1.113883.5.88",
                                      "caregiver information receiver",
                                      "caregiver information receiver",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: care team information receiver<br>
     */
    CARE_TEAM_INFORMATION_RECEIVER_L2("AUTM",
                                      "2.16.840.1.113883.5.88",
                                      "care team information receiver",
                                      "care team information receiver",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: claims adjudication<br>
     */
    CLAIMS_ADJUDICATION_L2("CLMADJ",
                           "2.16.840.1.113883.5.88",
                           "claims adjudication",
                           "claims adjudication",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: composer software<br>
     */
    COMPOSER_SOFTWARE("COMPOSER",
                      "2.16.840.1.113883.5.88",
                      "composer software",
                      "composer software",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: ConsenterParticipationFunction<br>
     */
    CONSENTERPARTICIPATIONFUNCTION_L1("_ConsenterParticipationFunction",
                                      "2.16.840.1.113883.5.88",
                                      "ConsenterParticipationFunction",
                                      "ConsenterParticipationFunction",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: consent overrider<br>
     */
    CONSENT_OVERRIDER_L2("AUCOV",
                         "2.16.840.1.113883.5.88",
                         "consent overrider",
                         "consent overrider",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: CoverageParticipationFunction<br>
     */
    COVERAGEPARTICIPATIONFUNCTION("_CoverageParticipationFunction",
                                  "2.16.840.1.113883.5.88",
                                  "CoverageParticipationFunction",
                                  "CoverageParticipationFunction",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: discharging physician<br>
     */
    DISCHARGING_PHYSICIAN("DISPHYS",
                          "2.16.840.1.113883.5.88",
                          "discharging physician",
                          "discharging physician",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: emergency overrider<br>
     */
    EMERGENCY_OVERRIDER_L2("AUEMROV",
                           "2.16.840.1.113883.5.88",
                           "emergency overrider",
                           "emergency overrider",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: enrollment broker<br>
     */
    ENROLLMENT_BROKER_L2("ENROLL",
                         "2.16.840.1.113883.5.88",
                         "enrollment broker",
                         "enrollment broker",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: ffs management<br>
     */
    FFS_MANAGEMENT_L2("FFSMGT",
                      "2.16.840.1.113883.5.88",
                      "ffs management",
                      "ffs management",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: first assistant surgeon<br>
     */
    FIRST_ASSISTANT_SURGEON("FASST",
                            "2.16.840.1.113883.5.88",
                            "first assistant surgeon",
                            "first assistant surgeon",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: fully insured<br>
     */
    FULLY_INSURED_L2("FULINRD",
                     "2.16.840.1.113883.5.88",
                     "fully insured",
                     "fully insured",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: healthcare power of attorney consent author<br>
     */
    HEALTHCARE_POWER_OF_ATTORNEY_CONSENT_AUTHOR_L2("POACON",
                                                   "2.16.840.1.113883.5.88",
                                                   "healthcare power of attorney consent author",
                                                   "healthcare power of attorney consent author",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: legal guardian consent author<br>
     */
    LEGAL_GUARDIAN_CONSENT_AUTHOR_L2("GRDCON",
                                     "2.16.840.1.113883.5.88",
                                     "legal guardian consent author",
                                     "legal guardian consent author",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: legitimate relationship information receiver<br>
     */
    LEGITIMATE_RELATIONSHIP_INFORMATION_RECEIVER_L2("AULR",
                                                    "2.16.840.1.113883.5.88",
                                                    "legitimate relationship information receiver",
                                                    "legitimate relationship information receiver",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: managed care management<br>
     */
    MANAGED_CARE_MANAGEMENT_L2("MCMGT",
                               "2.16.840.1.113883.5.88",
                               "managed care management",
                               "managed care management",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: midwife<br>
     */
    MIDWIFE("MDWF",
            "2.16.840.1.113883.5.88",
            "midwife",
            "midwife",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: nurse assistant<br>
     */
    NURSE_ASSISTANT("NASST",
                    "2.16.840.1.113883.5.88",
                    "nurse assistant",
                    "nurse assistant",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: OverriderParticipationFunction<br>
     */
    OVERRIDERPARTICIPATIONFUNCTION_L1("_OverriderParticipationFunction",
                                      "2.16.840.1.113883.5.88",
                                      "OverriderParticipationFunction",
                                      "OverriderParticipationFunction",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: PayorParticipationFunction<br>
     */
    PAYORPARTICIPATIONFUNCTION_L1("_PayorParticipationFunction",
                                  "2.16.840.1.113883.5.88",
                                  "PayorParticipationFunction",
                                  "PayorParticipationFunction",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: payor contracting<br>
     */
    PAYOR_CONTRACTING_L2("PAYORCNTR",
                         "2.16.840.1.113883.5.88",
                         "payor contracting",
                         "payor contracting",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: personal representative consent author<br>
     */
    PERSONAL_REPRESENTATIVE_CONSENT_AUTHOR_L2("PRCON",
                                              "2.16.840.1.113883.5.88",
                                              "personal representative consent author",
                                              "personal representative consent author",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE"),
    /**
     * EN: primary care physician<br>
     */
    PRIMARY_CARE_PHYSICIAN("PCP",
                           "2.16.840.1.113883.5.88",
                           "primary care physician",
                           "primary care physician",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: primary surgeon<br>
     */
    PRIMARY_SURGEON("PRISURG",
                    "2.16.840.1.113883.5.88",
                    "primary surgeon",
                    "primary surgeon",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: provider management<br>
     */
    PROVIDER_MANAGEMENT_L2("PROVMGT",
                           "2.16.840.1.113883.5.88",
                           "provider management",
                           "provider management",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: reinsures<br>
     */
    REINSURES_L2("REINS",
                 "2.16.840.1.113883.5.88",
                 "reinsures",
                 "reinsures",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: retrocessionaires<br>
     */
    RETROCESSIONAIRES_L2("RETROCES",
                         "2.16.840.1.113883.5.88",
                         "retrocessionaires",
                         "retrocessionaires",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: reviewer<br>
     */
    REVIEWER("REVIEWER",
             "2.16.840.1.113883.5.88",
             "reviewer",
             "reviewer",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: rounding physician<br>
     */
    ROUNDING_PHYSICIAN("RNDPHYS",
                       "2.16.840.1.113883.5.88",
                       "rounding physician",
                       "rounding physician",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: scrub nurse<br>
     */
    SCRUB_NURSE("SNRS",
                "2.16.840.1.113883.5.88",
                "scrub nurse",
                "scrub nurse",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: second assistant surgeon<br>
     */
    SECOND_ASSISTANT_SURGEON("SASST",
                             "2.16.840.1.113883.5.88",
                             "second assistant surgeon",
                             "second assistant surgeon",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: self insured<br>
     */
    SELF_INSURED_L2("SELFINRD",
                    "2.16.840.1.113883.5.88",
                    "self insured",
                    "self insured",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: SponsorParticipationFunction<br>
     */
    SPONSORPARTICIPATIONFUNCTION_L1("_SponsorParticipationFunction",
                                    "2.16.840.1.113883.5.88",
                                    "SponsorParticipationFunction",
                                    "SponsorParticipationFunction",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE"),
    /**
     * EN: subcontracting risk<br>
     */
    SUBCONTRACTING_RISK_L2("SUBCTRT",
                           "2.16.840.1.113883.5.88",
                           "subcontracting risk",
                           "subcontracting risk",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: subject of consent author<br>
     */
    SUBJECT_OF_CONSENT_AUTHOR_L2("SUBCON",
                                 "2.16.840.1.113883.5.88",
                                 "subject of consent author",
                                 "subject of consent author",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: third assistant<br>
     */
    THIRD_ASSISTANT("TASST",
                    "2.16.840.1.113883.5.88",
                    "third assistant",
                    "third assistant",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: UnderwriterParticipationFunction<br>
     */
    UNDERWRITERPARTICIPATIONFUNCTION_L1("_UnderwriterParticipationFunction",
                                        "2.16.840.1.113883.5.88",
                                        "UnderwriterParticipationFunction",
                                        "UnderwriterParticipationFunction",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: underwriting<br>
     */
    UNDERWRITING_L2("UNDERWRTNG",
                    "2.16.840.1.113883.5.88",
                    "underwriting",
                    "underwriting",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: utilization management<br>
     */
    UTILIZATION_MANAGEMENT_L2("UMGT",
                              "2.16.840.1.113883.5.88",
                              "utilization management",
                              "utilization management",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: work area information receiver<br>
     */
    WORK_AREA_INFORMATION_RECEIVER_L2("AUWA",
                                      "2.16.840.1.113883.5.88",
                                      "work area information receiver",
                                      "work area information receiver",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE");

    /**
     * EN: Code for admitting physician<br>
     */
    public static final String ADMITTING_PHYSICIAN_CODE = "ADMPHYS";

    /**
     * EN: Code for anesthesia nurse<br>
     */
    public static final String ANESTHESIA_NURSE_CODE = "ANRS";

    /**
     * EN: Code for anesthesist<br>
     */
    public static final String ANESTHESIST_CODE = "ANEST";

    /**
     * EN: Code for assembly software<br>
     */
    public static final String ASSEMBLY_SOFTWARE_CODE = "ASSEMBLER";

    /**
     * EN: Code for attending physician<br>
     */
    public static final String ATTENDING_PHYSICIAN_CODE = "ATTPHYS";

    /**
     * EN: Code for AuthorizedParticipationFunction<br>
     */
    public static final String AUTHORIZEDPARTICIPATIONFUNCTION_CODE = "_AuthorizedParticipationFunction";

    /**
     * EN: Code for AuthorizedReceiverParticipationFunction<br>
     */
    public static final String AUTHORIZEDRECEIVERPARTICIPATIONFUNCTION_L1_CODE = "_AuthorizedReceiverParticipationFunction";

    /**
     * EN: Code for authorized provider masking author<br>
     */
    public static final String AUTHORIZED_PROVIDER_MASKING_AUTHOR_L2_CODE = "PROMSK";

    /**
     * EN: Code for caregiver information receiver<br>
     */
    public static final String CAREGIVER_INFORMATION_RECEIVER_L2_CODE = "AUCG";

    /**
     * EN: Code for care team information receiver<br>
     */
    public static final String CARE_TEAM_INFORMATION_RECEIVER_L2_CODE = "AUTM";

    /**
     * EN: Code for claims adjudication<br>
     */
    public static final String CLAIMS_ADJUDICATION_L2_CODE = "CLMADJ";

    /**
     * EN: Code for composer software<br>
     */
    public static final String COMPOSER_SOFTWARE_CODE = "COMPOSER";

    /**
     * EN: Code for ConsenterParticipationFunction<br>
     */
    public static final String CONSENTERPARTICIPATIONFUNCTION_L1_CODE = "_ConsenterParticipationFunction";

    /**
     * EN: Code for consent overrider<br>
     */
    public static final String CONSENT_OVERRIDER_L2_CODE = "AUCOV";

    /**
     * EN: Code for CoverageParticipationFunction<br>
     */
    public static final String COVERAGEPARTICIPATIONFUNCTION_CODE = "_CoverageParticipationFunction";

    /**
     * EN: Code for discharging physician<br>
     */
    public static final String DISCHARGING_PHYSICIAN_CODE = "DISPHYS";

    /**
     * EN: Code for emergency overrider<br>
     */
    public static final String EMERGENCY_OVERRIDER_L2_CODE = "AUEMROV";

    /**
     * EN: Code for enrollment broker<br>
     */
    public static final String ENROLLMENT_BROKER_L2_CODE = "ENROLL";

    /**
     * EN: Code for ffs management<br>
     */
    public static final String FFS_MANAGEMENT_L2_CODE = "FFSMGT";

    /**
     * EN: Code for first assistant surgeon<br>
     */
    public static final String FIRST_ASSISTANT_SURGEON_CODE = "FASST";

    /**
     * EN: Code for fully insured<br>
     */
    public static final String FULLY_INSURED_L2_CODE = "FULINRD";

    /**
     * EN: Code for healthcare power of attorney consent author<br>
     */
    public static final String HEALTHCARE_POWER_OF_ATTORNEY_CONSENT_AUTHOR_L2_CODE = "POACON";

    /**
     * EN: Code for legal guardian consent author<br>
     */
    public static final String LEGAL_GUARDIAN_CONSENT_AUTHOR_L2_CODE = "GRDCON";

    /**
     * EN: Code for legitimate relationship information receiver<br>
     */
    public static final String LEGITIMATE_RELATIONSHIP_INFORMATION_RECEIVER_L2_CODE = "AULR";

    /**
     * EN: Code for managed care management<br>
     */
    public static final String MANAGED_CARE_MANAGEMENT_L2_CODE = "MCMGT";

    /**
     * EN: Code for midwife<br>
     */
    public static final String MIDWIFE_CODE = "MDWF";

    /**
     * EN: Code for nurse assistant<br>
     */
    public static final String NURSE_ASSISTANT_CODE = "NASST";

    /**
     * EN: Code for OverriderParticipationFunction<br>
     */
    public static final String OVERRIDERPARTICIPATIONFUNCTION_L1_CODE = "_OverriderParticipationFunction";

    /**
     * EN: Code for PayorParticipationFunction<br>
     */
    public static final String PAYORPARTICIPATIONFUNCTION_L1_CODE = "_PayorParticipationFunction";

    /**
     * EN: Code for payor contracting<br>
     */
    public static final String PAYOR_CONTRACTING_L2_CODE = "PAYORCNTR";

    /**
     * EN: Code for personal representative consent author<br>
     */
    public static final String PERSONAL_REPRESENTATIVE_CONSENT_AUTHOR_L2_CODE = "PRCON";

    /**
     * EN: Code for primary care physician<br>
     */
    public static final String PRIMARY_CARE_PHYSICIAN_CODE = "PCP";

    /**
     * EN: Code for primary surgeon<br>
     */
    public static final String PRIMARY_SURGEON_CODE = "PRISURG";

    /**
     * EN: Code for provider management<br>
     */
    public static final String PROVIDER_MANAGEMENT_L2_CODE = "PROVMGT";

    /**
     * EN: Code for reinsures<br>
     */
    public static final String REINSURES_L2_CODE = "REINS";

    /**
     * EN: Code for retrocessionaires<br>
     */
    public static final String RETROCESSIONAIRES_L2_CODE = "RETROCES";

    /**
     * EN: Code for reviewer<br>
     */
    public static final String REVIEWER_CODE = "REVIEWER";

    /**
     * EN: Code for rounding physician<br>
     */
    public static final String ROUNDING_PHYSICIAN_CODE = "RNDPHYS";

    /**
     * EN: Code for scrub nurse<br>
     */
    public static final String SCRUB_NURSE_CODE = "SNRS";

    /**
     * EN: Code for second assistant surgeon<br>
     */
    public static final String SECOND_ASSISTANT_SURGEON_CODE = "SASST";

    /**
     * EN: Code for self insured<br>
     */
    public static final String SELF_INSURED_L2_CODE = "SELFINRD";

    /**
     * EN: Code for SponsorParticipationFunction<br>
     */
    public static final String SPONSORPARTICIPATIONFUNCTION_L1_CODE = "_SponsorParticipationFunction";

    /**
     * EN: Code for subcontracting risk<br>
     */
    public static final String SUBCONTRACTING_RISK_L2_CODE = "SUBCTRT";

    /**
     * EN: Code for subject of consent author<br>
     */
    public static final String SUBJECT_OF_CONSENT_AUTHOR_L2_CODE = "SUBCON";

    /**
     * EN: Code for third assistant<br>
     */
    public static final String THIRD_ASSISTANT_CODE = "TASST";

    /**
     * EN: Code for UnderwriterParticipationFunction<br>
     */
    public static final String UNDERWRITERPARTICIPATIONFUNCTION_L1_CODE = "_UnderwriterParticipationFunction";

    /**
     * EN: Code for underwriting<br>
     */
    public static final String UNDERWRITING_L2_CODE = "UNDERWRTNG";

    /**
     * EN: Code for utilization management<br>
     */
    public static final String UTILIZATION_MANAGEMENT_L2_CODE = "UMGT";

    /**
     * EN: Code for work area information receiver<br>
     */
    public static final String WORK_AREA_INFORMATION_RECEIVER_L2_CODE = "AUWA";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.10267";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ParticipationFunction";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static ParticipationFunction getEnum(final String code) {
        for (final ParticipationFunction x : values()) {
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
            Enum.valueOf(ParticipationFunction.class,
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
        for (final ParticipationFunction x : values()) {
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
    ParticipationFunction(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
