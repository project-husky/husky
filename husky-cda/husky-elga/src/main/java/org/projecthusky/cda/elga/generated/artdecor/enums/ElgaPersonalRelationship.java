/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of ELGA_PersonalRelationship values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.10.17<br>
 * Effective date: 2021-09-27 11:04<br>
 * Version: 202109<br>
 * Status: NEW
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-18")
public enum ElgaPersonalRelationship implements ValueSetEnumInterface {

    /**
     * EN: adopted child.<br>
     */
    ADOPTED_CHILD_L2("CHLDADOPT",
                     "2.16.840.1.113883.5.111",
                     "adopted child",
                     "adopted child",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: adopted daughter.<br>
     */
    ADOPTED_DAUGHTER_L3("DAUADOPT",
                        "2.16.840.1.113883.5.111",
                        "adopted daughter",
                        "adopted daughter",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: adopted son.<br>
     */
    ADOPTED_SON_L3("SONADOPT",
                   "2.16.840.1.113883.5.111",
                   "adopted son",
                   "adopted son",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: aunt.<br>
     */
    AUNT_L1("AUNT",
            "2.16.840.1.113883.5.111",
            "aunt",
            "aunt",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: brother-in-law.<br>
     */
    BROTHER_IN_LAW_L3("BROINLAW",
                      "2.16.840.1.113883.5.111",
                      "brother-in-law",
                      "brother-in-law",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Brother.<br>
     */
    BROTHER_L2("BRO",
               "2.16.840.1.113883.5.111",
               "Brother",
               "Brother",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: child in-law.<br>
     */
    CHILD_IN_LAW_L2("CHLDINLAW",
                    "2.16.840.1.113883.5.111",
                    "child in-law",
                    "child in-law",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Child.<br>
     */
    CHILD_L1("CHILD",
             "2.16.840.1.113883.5.111",
             "Child",
             "Child",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: cousin.<br>
     */
    COUSIN_L1("COUSN",
              "2.16.840.1.113883.5.111",
              "cousin",
              "cousin",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: daughter in-law.<br>
     */
    DAUGHTER_IN_LAW_L3("DAUINLAW",
                       "2.16.840.1.113883.5.111",
                       "daughter in-law",
                       "daughter in-law",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Daughter.<br>
     */
    DAUGHTER_L2("DAUC",
                "2.16.840.1.113883.5.111",
                "Daughter",
                "Daughter",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: domestic partner.<br>
     */
    DOMESTIC_PARTNER("DOMPART",
                     "2.16.840.1.113883.5.111",
                     "domestic partner",
                     "domestic partner",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Family Member.<br>
     */
    FAMILY_MEMBER("FAMMEMB",
                  "2.16.840.1.113883.5.111",
                  "Family Member",
                  "Family Member",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: father-in-law.<br>
     */
    FATHER_IN_LAW_L3("FTHINLAW",
                     "2.16.840.1.113883.5.111",
                     "father-in-law",
                     "father-in-law",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Father.<br>
     */
    FATHER_L2("FTH",
              "2.16.840.1.113883.5.111",
              "Father",
              "Father",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: foster child.<br>
     */
    FOSTER_CHILD_L2("CHLDFOST",
                    "2.16.840.1.113883.5.111",
                    "foster child",
                    "foster child",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: foster daughter.<br>
     */
    FOSTER_DAUGHTER_L3("DAUFOST",
                       "2.16.840.1.113883.5.111",
                       "foster daughter",
                       "foster daughter",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: foster son.<br>
     */
    FOSTER_SON_L3("SONFOST",
                  "2.16.840.1.113883.5.111",
                  "foster son",
                  "foster son",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: grandchild.<br>
     */
    GRANDCHILD_L1("GRNDCHILD",
                  "2.16.840.1.113883.5.111",
                  "grandchild",
                  "grandchild",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: granddaughter.<br>
     */
    GRANDDAUGHTER_L2("GRNDDAU",
                     "2.16.840.1.113883.5.111",
                     "granddaughter",
                     "granddaughter",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Grandfather.<br>
     */
    GRANDFATHER_L2("GRFTH",
                   "2.16.840.1.113883.5.111",
                   "Grandfather",
                   "Grandfather",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Grandmother.<br>
     */
    GRANDMOTHER_L2("GRMTH",
                   "2.16.840.1.113883.5.111",
                   "Grandmother",
                   "Grandmother",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Grandparent.<br>
     */
    GRANDPARENT_L1("GRPRN",
                   "2.16.840.1.113883.5.111",
                   "Grandparent",
                   "Grandparent",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: grandson.<br>
     */
    GRANDSON_L2("GRNDSON",
                "2.16.840.1.113883.5.111",
                "grandson",
                "grandson",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: great grandfather.<br>
     */
    GREAT_GRANDFATHER_L2("GGRFTH",
                         "2.16.840.1.113883.5.111",
                         "great grandfather",
                         "great grandfather",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: great grandmother.<br>
     */
    GREAT_GRANDMOTHER_L2("GGRMTH",
                         "2.16.840.1.113883.5.111",
                         "great grandmother",
                         "great grandmother",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: great grandparent.<br>
     */
    GREAT_GRANDPARENT_L1("GGRPRN",
                         "2.16.840.1.113883.5.111",
                         "great grandparent",
                         "great grandparent",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: guardian.<br>
     */
    GUARDIAN("GUARD",
             "2.16.840.1.113883.5.111",
             "guardian",
             "guardian",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: half-brother.<br>
     */
    HALF_BROTHER_L3("HBRO",
                    "2.16.840.1.113883.5.111",
                    "half-brother",
                    "half-brother",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: half-sibling.<br>
     */
    HALF_SIBLING_L2("HSIB",
                    "2.16.840.1.113883.5.111",
                    "half-sibling",
                    "half-sibling",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: half-sister.<br>
     */
    HALF_SISTER_L3("HSIS",
                   "2.16.840.1.113883.5.111",
                   "half-sister",
                   "half-sister",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: husband.<br>
     */
    HUSBAND_L2("HUSB",
               "2.16.840.1.113883.5.111",
               "husband",
               "husband",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: mother-in-law.<br>
     */
    MOTHER_IN_LAW_L3("MTHINLAW",
                     "2.16.840.1.113883.5.111",
                     "mother-in-law",
                     "mother-in-law",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Mother.<br>
     */
    MOTHER_L2("MTH",
              "2.16.840.1.113883.5.111",
              "Mother",
              "Mother",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: natural brother.<br>
     */
    NATURAL_BROTHER_L3("NBRO",
                       "2.16.840.1.113883.5.111",
                       "natural brother",
                       "natural brother",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: natural child.<br>
     */
    NATURAL_CHILD_L2("NCHILD",
                     "2.16.840.1.113883.5.111",
                     "natural child",
                     "natural child",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: natural daughter.<br>
     */
    NATURAL_DAUGHTER_L3("DAU",
                        "2.16.840.1.113883.5.111",
                        "natural daughter",
                        "natural daughter",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: natural father.<br>
     */
    NATURAL_FATHER_L3("NFTH",
                      "2.16.840.1.113883.5.111",
                      "natural father",
                      "natural father",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: natural mother.<br>
     */
    NATURAL_MOTHER_L3("NMTH",
                      "2.16.840.1.113883.5.111",
                      "natural mother",
                      "natural mother",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: natural parent.<br>
     */
    NATURAL_PARENT_L2("NPRN",
                      "2.16.840.1.113883.5.111",
                      "natural parent",
                      "natural parent",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: natural sibling.<br>
     */
    NATURAL_SIBLING_L2("NSIB",
                       "2.16.840.1.113883.5.111",
                       "natural sibling",
                       "natural sibling",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: natural sister.<br>
     */
    NATURAL_SISTER_L3("NSIS",
                      "2.16.840.1.113883.5.111",
                      "natural sister",
                      "natural sister",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: natural son.<br>
     */
    NATURAL_SON_L3("SON",
                   "2.16.840.1.113883.5.111",
                   "natural son",
                   "natural son",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: neighbor.<br>
     */
    NEIGHBOR("NBOR",
             "2.16.840.1.113883.5.111",
             "neighbor",
             "neighbor",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: niece/nephew.<br>
     */
    NIECE_NEPHEW_L1("NIENEPH",
                    "2.16.840.1.113883.5.111",
                    "niece/nephew",
                    "niece/nephew",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: parent in-law.<br>
     */
    PARENT_IN_LAW_L2("PRNINLAW",
                     "2.16.840.1.113883.5.111",
                     "parent in-law",
                     "parent in-law",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Parent.<br>
     */
    PARENT_L1("PRN",
              "2.16.840.1.113883.5.111",
              "Parent",
              "Parent",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Roommate.<br>
     */
    ROOMMATE("ROOM",
             "2.16.840.1.113883.5.111",
             "Roommate",
             "Roommate",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: self.<br>
     */
    SELF("SELF",
         "2.16.840.1.113883.5.111",
         "self",
         "self",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: sibling in-law.<br>
     */
    SIBLING_IN_LAW_L2("SIBINLAW",
                      "2.16.840.1.113883.5.111",
                      "sibling in-law",
                      "sibling in-law",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Sibling.<br>
     */
    SIBLING_L1("SIB",
               "2.16.840.1.113883.5.111",
               "Sibling",
               "Sibling",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: significant other.<br>
     */
    SIGNIFICANT_OTHER("SIGOTHR",
                      "2.16.840.1.113883.5.111",
                      "significant other",
                      "significant other",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: sister-in-law.<br>
     */
    SISTER_IN_LAW_L3("SISINLAW",
                     "2.16.840.1.113883.5.111",
                     "sister-in-law",
                     "sister-in-law",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Sister.<br>
     */
    SISTER_L2("SIS",
              "2.16.840.1.113883.5.111",
              "Sister",
              "Sister",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: son in-law.<br>
     */
    SON_IN_LAW_L3("SONINLAW",
                  "2.16.840.1.113883.5.111",
                  "son in-law",
                  "son in-law",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: son.<br>
     */
    SON_L2("SONC",
           "2.16.840.1.113883.5.111",
           "son",
           "son",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: sponsored dependent.<br>
     */
    SPONSORED_DEPENDENT("SPON",
                        "2.16.840.1.113883.5.111",
                        "sponsored dependent",
                        "sponsored dependent",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: spouse.<br>
     */
    SPOUSE_L1("SPS",
              "2.16.840.1.113883.5.111",
              "spouse",
              "spouse",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: stepbrother.<br>
     */
    STEPBROTHER_L3("STPBRO",
                   "2.16.840.1.113883.5.111",
                   "stepbrother",
                   "stepbrother",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: stepdaughter.<br>
     */
    STEPDAUGHTER_L3("STPDAU",
                    "2.16.840.1.113883.5.111",
                    "stepdaughter",
                    "stepdaughter",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: stepfather.<br>
     */
    STEPFATHER_L3("STPFTH",
                  "2.16.840.1.113883.5.111",
                  "stepfather",
                  "stepfather",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: stepmother.<br>
     */
    STEPMOTHER_L3("STPMTH",
                  "2.16.840.1.113883.5.111",
                  "stepmother",
                  "stepmother",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: stepsister.<br>
     */
    STEPSISTER_L3("STPSIS",
                  "2.16.840.1.113883.5.111",
                  "stepsister",
                  "stepsister",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: stepson.<br>
     */
    STEPSON_L3("STPSON",
               "2.16.840.1.113883.5.111",
               "stepson",
               "stepson",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: step child.<br>
     */
    STEP_CHILD_L2("STPCHLD",
                  "2.16.840.1.113883.5.111",
                  "step child",
                  "step child",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: step parent.<br>
     */
    STEP_PARENT_L2("STPPRN",
                   "2.16.840.1.113883.5.111",
                   "step parent",
                   "step parent",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: step sibling.<br>
     */
    STEP_SIBLING_L2("STPSIB",
                    "2.16.840.1.113883.5.111",
                    "step sibling",
                    "step sibling",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: uncle.<br>
     */
    UNCLE_L1("UNCLE",
             "2.16.840.1.113883.5.111",
             "uncle",
             "uncle",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: unrelated friend.<br>
     */
    UNRELATED_FRIEND("FRND",
                     "2.16.840.1.113883.5.111",
                     "unrelated friend",
                     "unrelated friend",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: wife.<br>
     */
    WIFE_L2("WIFE",
            "2.16.840.1.113883.5.111",
            "wife",
            "wife",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE");

    /**
     * EN: Code for adopted child.<br>
     */
    public static final String ADOPTED_CHILD_L2_CODE = "CHLDADOPT";

    /**
     * EN: Code for adopted daughter.<br>
     */
    public static final String ADOPTED_DAUGHTER_L3_CODE = "DAUADOPT";

    /**
     * EN: Code for adopted son.<br>
     */
    public static final String ADOPTED_SON_L3_CODE = "SONADOPT";

    /**
     * EN: Code for aunt.<br>
     */
    public static final String AUNT_L1_CODE = "AUNT";

    /**
     * EN: Code for brother-in-law.<br>
     */
    public static final String BROTHER_IN_LAW_L3_CODE = "BROINLAW";

    /**
     * EN: Code for Brother.<br>
     */
    public static final String BROTHER_L2_CODE = "BRO";

    /**
     * EN: Code for child in-law.<br>
     */
    public static final String CHILD_IN_LAW_L2_CODE = "CHLDINLAW";

    /**
     * EN: Code for Child.<br>
     */
    public static final String CHILD_L1_CODE = "CHILD";

    /**
     * EN: Code for cousin.<br>
     */
    public static final String COUSIN_L1_CODE = "COUSN";

    /**
     * EN: Code for daughter in-law.<br>
     */
    public static final String DAUGHTER_IN_LAW_L3_CODE = "DAUINLAW";

    /**
     * EN: Code for Daughter.<br>
     */
    public static final String DAUGHTER_L2_CODE = "DAUC";

    /**
     * EN: Code for domestic partner.<br>
     */
    public static final String DOMESTIC_PARTNER_CODE = "DOMPART";

    /**
     * EN: Code for Family Member.<br>
     */
    public static final String FAMILY_MEMBER_CODE = "FAMMEMB";

    /**
     * EN: Code for father-in-law.<br>
     */
    public static final String FATHER_IN_LAW_L3_CODE = "FTHINLAW";

    /**
     * EN: Code for Father.<br>
     */
    public static final String FATHER_L2_CODE = "FTH";

    /**
     * EN: Code for foster child.<br>
     */
    public static final String FOSTER_CHILD_L2_CODE = "CHLDFOST";

    /**
     * EN: Code for foster daughter.<br>
     */
    public static final String FOSTER_DAUGHTER_L3_CODE = "DAUFOST";

    /**
     * EN: Code for foster son.<br>
     */
    public static final String FOSTER_SON_L3_CODE = "SONFOST";

    /**
     * EN: Code for grandchild.<br>
     */
    public static final String GRANDCHILD_L1_CODE = "GRNDCHILD";

    /**
     * EN: Code for granddaughter.<br>
     */
    public static final String GRANDDAUGHTER_L2_CODE = "GRNDDAU";

    /**
     * EN: Code for Grandfather.<br>
     */
    public static final String GRANDFATHER_L2_CODE = "GRFTH";

    /**
     * EN: Code for Grandmother.<br>
     */
    public static final String GRANDMOTHER_L2_CODE = "GRMTH";

    /**
     * EN: Code for Grandparent.<br>
     */
    public static final String GRANDPARENT_L1_CODE = "GRPRN";

    /**
     * EN: Code for grandson.<br>
     */
    public static final String GRANDSON_L2_CODE = "GRNDSON";

    /**
     * EN: Code for great grandfather.<br>
     */
    public static final String GREAT_GRANDFATHER_L2_CODE = "GGRFTH";

    /**
     * EN: Code for great grandmother.<br>
     */
    public static final String GREAT_GRANDMOTHER_L2_CODE = "GGRMTH";

    /**
     * EN: Code for great grandparent.<br>
     */
    public static final String GREAT_GRANDPARENT_L1_CODE = "GGRPRN";

    /**
     * EN: Code for guardian.<br>
     */
    public static final String GUARDIAN_CODE = "GUARD";

    /**
     * EN: Code for half-brother.<br>
     */
    public static final String HALF_BROTHER_L3_CODE = "HBRO";

    /**
     * EN: Code for half-sibling.<br>
     */
    public static final String HALF_SIBLING_L2_CODE = "HSIB";

    /**
     * EN: Code for half-sister.<br>
     */
    public static final String HALF_SISTER_L3_CODE = "HSIS";

    /**
     * EN: Code for husband.<br>
     */
    public static final String HUSBAND_L2_CODE = "HUSB";

    /**
     * EN: Code for mother-in-law.<br>
     */
    public static final String MOTHER_IN_LAW_L3_CODE = "MTHINLAW";

    /**
     * EN: Code for Mother.<br>
     */
    public static final String MOTHER_L2_CODE = "MTH";

    /**
     * EN: Code for natural brother.<br>
     */
    public static final String NATURAL_BROTHER_L3_CODE = "NBRO";

    /**
     * EN: Code for natural child.<br>
     */
    public static final String NATURAL_CHILD_L2_CODE = "NCHILD";

    /**
     * EN: Code for natural daughter.<br>
     */
    public static final String NATURAL_DAUGHTER_L3_CODE = "DAU";

    /**
     * EN: Code for natural father.<br>
     */
    public static final String NATURAL_FATHER_L3_CODE = "NFTH";

    /**
     * EN: Code for natural mother.<br>
     */
    public static final String NATURAL_MOTHER_L3_CODE = "NMTH";

    /**
     * EN: Code for natural parent.<br>
     */
    public static final String NATURAL_PARENT_L2_CODE = "NPRN";

    /**
     * EN: Code for natural sibling.<br>
     */
    public static final String NATURAL_SIBLING_L2_CODE = "NSIB";

    /**
     * EN: Code for natural sister.<br>
     */
    public static final String NATURAL_SISTER_L3_CODE = "NSIS";

    /**
     * EN: Code for natural son.<br>
     */
    public static final String NATURAL_SON_L3_CODE = "SON";

    /**
     * EN: Code for neighbor.<br>
     */
    public static final String NEIGHBOR_CODE = "NBOR";

    /**
     * EN: Code for niece/nephew.<br>
     */
    public static final String NIECE_NEPHEW_L1_CODE = "NIENEPH";

    /**
     * EN: Code for parent in-law.<br>
     */
    public static final String PARENT_IN_LAW_L2_CODE = "PRNINLAW";

    /**
     * EN: Code for Parent.<br>
     */
    public static final String PARENT_L1_CODE = "PRN";

    /**
     * EN: Code for Roommate.<br>
     */
    public static final String ROOMMATE_CODE = "ROOM";

    /**
     * EN: Code for self.<br>
     */
    public static final String SELF_CODE = "SELF";

    /**
     * EN: Code for sibling in-law.<br>
     */
    public static final String SIBLING_IN_LAW_L2_CODE = "SIBINLAW";

    /**
     * EN: Code for Sibling.<br>
     */
    public static final String SIBLING_L1_CODE = "SIB";

    /**
     * EN: Code for significant other.<br>
     */
    public static final String SIGNIFICANT_OTHER_CODE = "SIGOTHR";

    /**
     * EN: Code for sister-in-law.<br>
     */
    public static final String SISTER_IN_LAW_L3_CODE = "SISINLAW";

    /**
     * EN: Code for Sister.<br>
     */
    public static final String SISTER_L2_CODE = "SIS";

    /**
     * EN: Code for son in-law.<br>
     */
    public static final String SON_IN_LAW_L3_CODE = "SONINLAW";

    /**
     * EN: Code for son.<br>
     */
    public static final String SON_L2_CODE = "SONC";

    /**
     * EN: Code for sponsored dependent.<br>
     */
    public static final String SPONSORED_DEPENDENT_CODE = "SPON";

    /**
     * EN: Code for spouse.<br>
     */
    public static final String SPOUSE_L1_CODE = "SPS";

    /**
     * EN: Code for stepbrother.<br>
     */
    public static final String STEPBROTHER_L3_CODE = "STPBRO";

    /**
     * EN: Code for stepdaughter.<br>
     */
    public static final String STEPDAUGHTER_L3_CODE = "STPDAU";

    /**
     * EN: Code for stepfather.<br>
     */
    public static final String STEPFATHER_L3_CODE = "STPFTH";

    /**
     * EN: Code for stepmother.<br>
     */
    public static final String STEPMOTHER_L3_CODE = "STPMTH";

    /**
     * EN: Code for stepsister.<br>
     */
    public static final String STEPSISTER_L3_CODE = "STPSIS";

    /**
     * EN: Code for stepson.<br>
     */
    public static final String STEPSON_L3_CODE = "STPSON";

    /**
     * EN: Code for step child.<br>
     */
    public static final String STEP_CHILD_L2_CODE = "STPCHLD";

    /**
     * EN: Code for step parent.<br>
     */
    public static final String STEP_PARENT_L2_CODE = "STPPRN";

    /**
     * EN: Code for step sibling.<br>
     */
    public static final String STEP_SIBLING_L2_CODE = "STPSIB";

    /**
     * EN: Code for uncle.<br>
     */
    public static final String UNCLE_L1_CODE = "UNCLE";

    /**
     * EN: Code for unrelated friend.<br>
     */
    public static final String UNRELATED_FRIEND_CODE = "FRND";

    /**
     * EN: Code for wife.<br>
     */
    public static final String WIFE_L2_CODE = "WIFE";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.10.17";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ELGA_PersonalRelationship";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.111";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ElgaPersonalRelationship getEnum(@Nullable final String code) {
        for (final ElgaPersonalRelationship x : values()) {
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
            Enum.valueOf(ElgaPersonalRelationship.class,
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
        for (final ElgaPersonalRelationship x : values()) {
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
    ElgaPersonalRelationship(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
