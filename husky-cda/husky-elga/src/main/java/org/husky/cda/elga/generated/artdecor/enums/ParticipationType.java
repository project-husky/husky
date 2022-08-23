/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of ParticipationType values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>A code specifying the meaning and purpose of every Participation instance. Each of its values implies specific constraints on the Roles undertaking the participation.</p>.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.10901<br>
 * Effective date: 2014-03-26 00:00<br>
 * Version: DEFN=UV=VO=1360-20160323<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-18")
public enum ParticipationType implements ValueSetEnumInterface {

    /**
     * EN: admitter.<br>
     */
    ADMITTER_L2("ADM",
                "2.16.840.1.113883.5.90",
                "admitter",
                "admitter",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: analyte.<br>
     */
    ANALYTE_L2("ALY",
               "2.16.840.1.113883.5.90",
               "analyte",
               "analyte",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: attender.<br>
     */
    ATTENDER_L2("ATND",
                "2.16.840.1.113883.5.90",
                "attender",
                "attender",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: authenticator.<br>
     */
    AUTHENTICATOR_L2("AUTHEN",
                     "2.16.840.1.113883.5.90",
                     "authenticator",
                     "authenticator",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: author (originator).<br>
     */
    AUTHOR_ORIGINATOR_L2("AUT",
                         "2.16.840.1.113883.5.90",
                         "author (originator)",
                         "author (originator)",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: baby.<br>
     */
    BABY_L2("BBY",
            "2.16.840.1.113883.5.90",
            "baby",
            "baby",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: beneficiary.<br>
     */
    BENEFICIARY_L2("BEN",
                   "2.16.840.1.113883.5.90",
                   "beneficiary",
                   "beneficiary",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: callback contact.<br>
     */
    CALLBACK_CONTACT_L2("CALLBCK",
                        "2.16.840.1.113883.5.90",
                        "callback contact",
                        "callback contact",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: catalyst.<br>
     */
    CATALYST_L2("CAT",
                "2.16.840.1.113883.5.90",
                "catalyst",
                "catalyst",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: causative agent.<br>
     */
    CAUSATIVE_AGENT_L2("CAGNT",
                       "2.16.840.1.113883.5.90",
                       "causative agent",
                       "causative agent",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: consultant.<br>
     */
    CONSULTANT_L2("CON",
                  "2.16.840.1.113883.5.90",
                  "consultant",
                  "consultant",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: consumable.<br>
     */
    CONSUMABLE_L2("CSM",
                  "2.16.840.1.113883.5.90",
                  "consumable",
                  "consumable",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: coverage target.<br>
     */
    COVERAGE_TARGET_L2("COV",
                       "2.16.840.1.113883.5.90",
                       "coverage target",
                       "coverage target",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: custodian.<br>
     */
    CUSTODIAN_L1("CST",
                 "2.16.840.1.113883.5.90",
                 "custodian",
                 "custodian",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: data entry person.<br>
     */
    DATA_ENTRY_PERSON_L3("ENT",
                         "2.16.840.1.113883.5.90",
                         "data entry person",
                         "data entry person",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: destination.<br>
     */
    DESTINATION_L2("DST",
                   "2.16.840.1.113883.5.90",
                   "destination",
                   "destination",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: device.<br>
     */
    DEVICE_L2("DEV",
              "2.16.840.1.113883.5.90",
              "device",
              "device",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: direct target.<br>
     */
    DIRECT_TARGET_L1("DIR",
                     "2.16.840.1.113883.5.90",
                     "direct target",
                     "direct target",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: discharger.<br>
     */
    DISCHARGER_L2("DIS",
                  "2.16.840.1.113883.5.90",
                  "discharger",
                  "discharger",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: distributor.<br>
     */
    DISTRIBUTOR_L2("DIST",
                   "2.16.840.1.113883.5.90",
                   "distributor",
                   "distributor",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: donor.<br>
     */
    DONOR_L2("DON",
             "2.16.840.1.113883.5.90",
             "donor",
             "donor",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: entry location.<br>
     */
    ENTRY_LOCATION_L2("ELOC",
                      "2.16.840.1.113883.5.90",
                      "entry location",
                      "entry location",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: escort.<br>
     */
    ESCORT_L2("ESC",
              "2.16.840.1.113883.5.90",
              "escort",
              "escort",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: ExposureAgent.<br>
     */
    EXPOSUREAGENT_L2("EXPAGNT",
                     "2.16.840.1.113883.5.90",
                     "ExposureAgent",
                     "ExposureAgent",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: ExposureParticipation.<br>
     */
    EXPOSUREPARTICIPATION_L2("EXPART",
                             "2.16.840.1.113883.5.90",
                             "ExposureParticipation",
                             "ExposureParticipation",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: ExposureSource.<br>
     */
    EXPOSURESOURCE_L3("EXSRC",
                      "2.16.840.1.113883.5.90",
                      "ExposureSource",
                      "ExposureSource",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: ExposureTarget.<br>
     */
    EXPOSURETARGET_L3("EXPTRGT",
                      "2.16.840.1.113883.5.90",
                      "ExposureTarget",
                      "ExposureTarget",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: guarantor party.<br>
     */
    GUARANTOR_PARTY_L2("GUAR",
                       "2.16.840.1.113883.5.90",
                       "guarantor party",
                       "guarantor party",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: holder.<br>
     */
    HOLDER_L2("HLD",
              "2.16.840.1.113883.5.90",
              "holder",
              "holder",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: indirect target.<br>
     */
    INDIRECT_TARGET_L1("IND",
                       "2.16.840.1.113883.5.90",
                       "indirect target",
                       "indirect target",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: informant.<br>
     */
    INFORMANT_L2("INF",
                 "2.16.840.1.113883.5.90",
                 "informant",
                 "informant",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: information recipient.<br>
     */
    INFORMATION_RECIPIENT_L1("IRCP",
                             "2.16.840.1.113883.5.90",
                             "information recipient",
                             "information recipient",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: legal authenticator.<br>
     */
    LEGAL_AUTHENTICATOR_L2("LA",
                           "2.16.840.1.113883.5.90",
                           "legal authenticator",
                           "legal authenticator",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: location.<br>
     */
    LOCATION_L1("LOC",
                "2.16.840.1.113883.5.90",
                "location",
                "location",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: non-reuseable device.<br>
     */
    NON_REUSEABLE_DEVICE_L3("NRD",
                            "2.16.840.1.113883.5.90",
                            "non-reuseable device",
                            "non-reuseable device",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: origin.<br>
     */
    ORIGIN_L2("ORG",
              "2.16.840.1.113883.5.90",
              "origin",
              "origin",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Participation.<br>
     */
    PARTICIPATION("PART",
                  "2.16.840.1.113883.5.90",
                  "Participation",
                  "Participation",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: ParticipationAncillary.<br>
     */
    PARTICIPATIONANCILLARY_L1("_ParticipationAncillary",
                              "2.16.840.1.113883.5.90",
                              "ParticipationAncillary",
                              "ParticipationAncillary",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: ParticipationInformationGenerator.<br>
     */
    PARTICIPATIONINFORMATIONGENERATOR_L1("_ParticipationInformationGenerator",
                                         "2.16.840.1.113883.5.90",
                                         "ParticipationInformationGenerator",
                                         "ParticipationInformationGenerator",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: performer.<br>
     */
    PERFORMER_L1("PRF",
                 "2.16.840.1.113883.5.90",
                 "performer",
                 "performer",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: primary information recipient.<br>
     */
    PRIMARY_INFORMATION_RECIPIENT_L2("PRCP",
                                     "2.16.840.1.113883.5.90",
                                     "primary information recipient",
                                     "primary information recipient",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: primary performer.<br>
     */
    PRIMARY_PERFORMER_L2("PPRF",
                         "2.16.840.1.113883.5.90",
                         "primary performer",
                         "primary performer",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: product.<br>
     */
    PRODUCT_L2("PRD",
               "2.16.840.1.113883.5.90",
               "product",
               "product",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: receiver.<br>
     */
    RECEIVER_L2("RCV",
                "2.16.840.1.113883.5.90",
                "receiver",
                "receiver",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: record target.<br>
     */
    RECORD_TARGET_L2("RCT",
                     "2.16.840.1.113883.5.90",
                     "record target",
                     "record target",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Referred By.<br>
     */
    REFERRED_BY_L2("REFB",
                   "2.16.840.1.113883.5.90",
                   "Referred By",
                   "Referred By",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Referred to.<br>
     */
    REFERRED_TO_L2("REFT",
                   "2.16.840.1.113883.5.90",
                   "Referred to",
                   "Referred to",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: referrer.<br>
     */
    REFERRER_L2("REF",
                "2.16.840.1.113883.5.90",
                "referrer",
                "referrer",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: remote.<br>
     */
    REMOTE_L2("RML",
              "2.16.840.1.113883.5.90",
              "remote",
              "remote",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: responsible party.<br>
     */
    RESPONSIBLE_PARTY_L1("RESP",
                         "2.16.840.1.113883.5.90",
                         "responsible party",
                         "responsible party",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: reusable device.<br>
     */
    REUSABLE_DEVICE_L3("RDV",
                       "2.16.840.1.113883.5.90",
                       "reusable device",
                       "reusable device",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: secondary performer.<br>
     */
    SECONDARY_PERFORMER_L2("SPRF",
                           "2.16.840.1.113883.5.90",
                           "secondary performer",
                           "secondary performer",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: specimen.<br>
     */
    SPECIMEN_L3("SPC",
                "2.16.840.1.113883.5.90",
                "specimen",
                "specimen",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: subject.<br>
     */
    SUBJECT_L2("SBJ",
               "2.16.840.1.113883.5.90",
               "subject",
               "subject",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: tracker.<br>
     */
    TRACKER_L2("TRC",
               "2.16.840.1.113883.5.90",
               "tracker",
               "tracker",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Transcriber.<br>
     */
    TRANSCRIBER_L2("TRANS",
                   "2.16.840.1.113883.5.90",
                   "Transcriber",
                   "Transcriber",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: ugent notification contact.<br>
     */
    UGENT_NOTIFICATION_CONTACT_L2("NOT",
                                  "2.16.840.1.113883.5.90",
                                  "ugent notification contact",
                                  "ugent notification contact",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: verifier.<br>
     */
    VERIFIER_L1("VRF",
                "2.16.840.1.113883.5.90",
                "verifier",
                "verifier",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: via.<br>
     */
    VIA_L2("VIA",
           "2.16.840.1.113883.5.90",
           "via",
           "via",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: witness.<br>
     */
    WITNESS_L2("WIT",
               "2.16.840.1.113883.5.90",
               "witness",
               "witness",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE");

    /**
     * EN: Code for admitter.<br>
     */
    public static final String ADMITTER_L2_CODE = "ADM";

    /**
     * EN: Code for analyte.<br>
     */
    public static final String ANALYTE_L2_CODE = "ALY";

    /**
     * EN: Code for attender.<br>
     */
    public static final String ATTENDER_L2_CODE = "ATND";

    /**
     * EN: Code for authenticator.<br>
     */
    public static final String AUTHENTICATOR_L2_CODE = "AUTHEN";

    /**
     * EN: Code for author (originator).<br>
     */
    public static final String AUTHOR_ORIGINATOR_L2_CODE = "AUT";

    /**
     * EN: Code for baby.<br>
     */
    public static final String BABY_L2_CODE = "BBY";

    /**
     * EN: Code for beneficiary.<br>
     */
    public static final String BENEFICIARY_L2_CODE = "BEN";

    /**
     * EN: Code for callback contact.<br>
     */
    public static final String CALLBACK_CONTACT_L2_CODE = "CALLBCK";

    /**
     * EN: Code for catalyst.<br>
     */
    public static final String CATALYST_L2_CODE = "CAT";

    /**
     * EN: Code for causative agent.<br>
     */
    public static final String CAUSATIVE_AGENT_L2_CODE = "CAGNT";

    /**
     * EN: Code for consultant.<br>
     */
    public static final String CONSULTANT_L2_CODE = "CON";

    /**
     * EN: Code for consumable.<br>
     */
    public static final String CONSUMABLE_L2_CODE = "CSM";

    /**
     * EN: Code for coverage target.<br>
     */
    public static final String COVERAGE_TARGET_L2_CODE = "COV";

    /**
     * EN: Code for custodian.<br>
     */
    public static final String CUSTODIAN_L1_CODE = "CST";

    /**
     * EN: Code for data entry person.<br>
     */
    public static final String DATA_ENTRY_PERSON_L3_CODE = "ENT";

    /**
     * EN: Code for destination.<br>
     */
    public static final String DESTINATION_L2_CODE = "DST";

    /**
     * EN: Code for device.<br>
     */
    public static final String DEVICE_L2_CODE = "DEV";

    /**
     * EN: Code for direct target.<br>
     */
    public static final String DIRECT_TARGET_L1_CODE = "DIR";

    /**
     * EN: Code for discharger.<br>
     */
    public static final String DISCHARGER_L2_CODE = "DIS";

    /**
     * EN: Code for distributor.<br>
     */
    public static final String DISTRIBUTOR_L2_CODE = "DIST";

    /**
     * EN: Code for donor.<br>
     */
    public static final String DONOR_L2_CODE = "DON";

    /**
     * EN: Code for entry location.<br>
     */
    public static final String ENTRY_LOCATION_L2_CODE = "ELOC";

    /**
     * EN: Code for escort.<br>
     */
    public static final String ESCORT_L2_CODE = "ESC";

    /**
     * EN: Code for ExposureAgent.<br>
     */
    public static final String EXPOSUREAGENT_L2_CODE = "EXPAGNT";

    /**
     * EN: Code for ExposureParticipation.<br>
     */
    public static final String EXPOSUREPARTICIPATION_L2_CODE = "EXPART";

    /**
     * EN: Code for ExposureSource.<br>
     */
    public static final String EXPOSURESOURCE_L3_CODE = "EXSRC";

    /**
     * EN: Code for ExposureTarget.<br>
     */
    public static final String EXPOSURETARGET_L3_CODE = "EXPTRGT";

    /**
     * EN: Code for guarantor party.<br>
     */
    public static final String GUARANTOR_PARTY_L2_CODE = "GUAR";

    /**
     * EN: Code for holder.<br>
     */
    public static final String HOLDER_L2_CODE = "HLD";

    /**
     * EN: Code for indirect target.<br>
     */
    public static final String INDIRECT_TARGET_L1_CODE = "IND";

    /**
     * EN: Code for informant.<br>
     */
    public static final String INFORMANT_L2_CODE = "INF";

    /**
     * EN: Code for information recipient.<br>
     */
    public static final String INFORMATION_RECIPIENT_L1_CODE = "IRCP";

    /**
     * EN: Code for legal authenticator.<br>
     */
    public static final String LEGAL_AUTHENTICATOR_L2_CODE = "LA";

    /**
     * EN: Code for location.<br>
     */
    public static final String LOCATION_L1_CODE = "LOC";

    /**
     * EN: Code for non-reuseable device.<br>
     */
    public static final String NON_REUSEABLE_DEVICE_L3_CODE = "NRD";

    /**
     * EN: Code for origin.<br>
     */
    public static final String ORIGIN_L2_CODE = "ORG";

    /**
     * EN: Code for Participation.<br>
     */
    public static final String PARTICIPATION_CODE = "PART";

    /**
     * EN: Code for ParticipationAncillary.<br>
     */
    public static final String PARTICIPATIONANCILLARY_L1_CODE = "_ParticipationAncillary";

    /**
     * EN: Code for ParticipationInformationGenerator.<br>
     */
    public static final String PARTICIPATIONINFORMATIONGENERATOR_L1_CODE = "_ParticipationInformationGenerator";

    /**
     * EN: Code for performer.<br>
     */
    public static final String PERFORMER_L1_CODE = "PRF";

    /**
     * EN: Code for primary information recipient.<br>
     */
    public static final String PRIMARY_INFORMATION_RECIPIENT_L2_CODE = "PRCP";

    /**
     * EN: Code for primary performer.<br>
     */
    public static final String PRIMARY_PERFORMER_L2_CODE = "PPRF";

    /**
     * EN: Code for product.<br>
     */
    public static final String PRODUCT_L2_CODE = "PRD";

    /**
     * EN: Code for receiver.<br>
     */
    public static final String RECEIVER_L2_CODE = "RCV";

    /**
     * EN: Code for record target.<br>
     */
    public static final String RECORD_TARGET_L2_CODE = "RCT";

    /**
     * EN: Code for Referred By.<br>
     */
    public static final String REFERRED_BY_L2_CODE = "REFB";

    /**
     * EN: Code for Referred to.<br>
     */
    public static final String REFERRED_TO_L2_CODE = "REFT";

    /**
     * EN: Code for referrer.<br>
     */
    public static final String REFERRER_L2_CODE = "REF";

    /**
     * EN: Code for remote.<br>
     */
    public static final String REMOTE_L2_CODE = "RML";

    /**
     * EN: Code for responsible party.<br>
     */
    public static final String RESPONSIBLE_PARTY_L1_CODE = "RESP";

    /**
     * EN: Code for reusable device.<br>
     */
    public static final String REUSABLE_DEVICE_L3_CODE = "RDV";

    /**
     * EN: Code for secondary performer.<br>
     */
    public static final String SECONDARY_PERFORMER_L2_CODE = "SPRF";

    /**
     * EN: Code for specimen.<br>
     */
    public static final String SPECIMEN_L3_CODE = "SPC";

    /**
     * EN: Code for subject.<br>
     */
    public static final String SUBJECT_L2_CODE = "SBJ";

    /**
     * EN: Code for tracker.<br>
     */
    public static final String TRACKER_L2_CODE = "TRC";

    /**
     * EN: Code for Transcriber.<br>
     */
    public static final String TRANSCRIBER_L2_CODE = "TRANS";

    /**
     * EN: Code for ugent notification contact.<br>
     */
    public static final String UGENT_NOTIFICATION_CONTACT_L2_CODE = "NOT";

    /**
     * EN: Code for verifier.<br>
     */
    public static final String VERIFIER_L1_CODE = "VRF";

    /**
     * EN: Code for via.<br>
     */
    public static final String VIA_L2_CODE = "VIA";

    /**
     * EN: Code for witness.<br>
     */
    public static final String WITNESS_L2_CODE = "WIT";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.10901";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ParticipationType";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.90";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ParticipationType getEnum(@Nullable final String code) {
        for (final ParticipationType x : values()) {
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
    public static boolean isEnumOfValueSet(@Nullable final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(ParticipationType.class,
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
    public static boolean isInValueSet(@Nullable final String codeValue) {
        for (final ParticipationType x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    @NonNull
    private final String code;

    /**
     * Identifier of the referencing code system.
     */
    @NonNull
    private final String codeSystem;

    /**
     * The display names per language. It's always stored in the given order: default display name (0), in English (1),
     * in German (2), in French (3) and in Italian (4).
     */
    @NonNull
    private final String[] displayNames;

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
    ParticipationType(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
        this.code = Objects.requireNonNull(code);
        this.codeSystem = Objects.requireNonNull(codeSystem);
        this.displayNames = new String[5];
        this.displayNames[0] = Objects.requireNonNull(displayName);
        this.displayNames[1] = Objects.requireNonNull(displayNameEn);
        this.displayNames[2] = Objects.requireNonNull(displayNameDe);
        this.displayNames[3] = Objects.requireNonNull(displayNameFr);
        this.displayNames[4] = Objects.requireNonNull(displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    @NonNull
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name.
     */
    @Override
    @NonNull
    public String getCodeSystemName() {
        final var codeSystem = CodeSystems.getEnum(this.codeSystem);
        if (codeSystem != null) {
            return codeSystem.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    @NonNull
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @Override
    @NonNull
    public String getDisplayName(@Nullable final LanguageCode languageCode) {
        if (languageCode == null) {
            return this.displayNames[0];
        }
        return switch(languageCode) {
            case ENGLISH ->
                this.displayNames[1];
            case GERMAN ->
                this.displayNames[2];
            case FRENCH ->
                this.displayNames[3];
            case ITALIAN ->
                this.displayNames[4];
            default ->
                "TOTRANSLATE";
        };
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    @NonNull
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    @NonNull
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
