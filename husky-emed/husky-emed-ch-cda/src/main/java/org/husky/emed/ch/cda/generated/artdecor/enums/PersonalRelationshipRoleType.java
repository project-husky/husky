/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of PersonalRelationshipRoleType values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>Types of personal relationships between two living subjects.</p><p> <i>Example:</i> Parent, sibling, unrelated friend, neighbor</p>.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.19563<br>
 * Effective date: 2014-03-26 00:00<br>
 * Version: DEFN=UV=VO=1360-20160323<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-04-19")
public enum PersonalRelationshipRoleType implements ValueSetEnumInterface {

    /**
     * EN: adopted child.<br>
     */
    ADOPTED_CHILD_L3("CHLDADOPT",
                     "2.16.840.1.113883.5.111",
                     "adopted child",
                     "adopted child",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: adopted daughter.<br>
     */
    ADOPTED_DAUGHTER_L4("DAUADOPT",
                        "2.16.840.1.113883.5.111",
                        "adopted daughter",
                        "adopted daughter",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: adopted son.<br>
     */
    ADOPTED_SON_L4("SONADOPT",
                   "2.16.840.1.113883.5.111",
                   "adopted son",
                   "adopted son",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: adoptive father.<br>
     */
    ADOPTIVE_FATHER_L4("ADOPTF",
                       "2.16.840.1.113883.5.111",
                       "adoptive father",
                       "adoptive father",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: adoptive mother.<br>
     */
    ADOPTIVE_MOTHER_L4("ADOPTM",
                       "2.16.840.1.113883.5.111",
                       "adoptive mother",
                       "adoptive mother",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: adoptive parent.<br>
     */
    ADOPTIVE_PARENT_L3("ADOPTP",
                       "2.16.840.1.113883.5.111",
                       "adoptive parent",
                       "adoptive parent",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: aunt.<br>
     */
    AUNT_L3("AUNT",
            "2.16.840.1.113883.5.111",
            "aunt",
            "aunt",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: brother-in-law.<br>
     */
    BROTHER_IN_LAW_L5("BROINLAW",
                      "2.16.840.1.113883.5.111",
                      "brother-in-law",
                      "brother-in-law",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: brother.<br>
     */
    BROTHER_L3("BRO",
               "2.16.840.1.113883.5.111",
               "brother",
               "brother",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: child-in-law.<br>
     */
    CHILD_IN_LAW_L4("CHLDINLAW",
                    "2.16.840.1.113883.5.111",
                    "child-in-law",
                    "child-in-law",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: child.<br>
     */
    CHILD_L2("CHILD",
             "2.16.840.1.113883.5.111",
             "child",
             "child",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: cousin.<br>
     */
    COUSIN_L3("COUSN",
              "2.16.840.1.113883.5.111",
              "cousin",
              "cousin",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: daughter in-law.<br>
     */
    DAUGHTER_IN_LAW_L5("DAUINLAW",
                       "2.16.840.1.113883.5.111",
                       "daughter in-law",
                       "daughter in-law",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: daughter.<br>
     */
    DAUGHTER_L3("DAUC",
                "2.16.840.1.113883.5.111",
                "daughter",
                "daughter",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: domestic partner.<br>
     */
    DOMESTIC_PARTNER_L3("DOMPART",
                        "2.16.840.1.113883.5.111",
                        "domestic partner",
                        "domestic partner",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: extended family member.<br>
     */
    EXTENDED_FAMILY_MEMBER_L2("EXT",
                              "2.16.840.1.113883.5.111",
                              "extended family member",
                              "extended family member",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: family member.<br>
     */
    FAMILY_MEMBER_L1("FAMMEMB",
                     "2.16.840.1.113883.5.111",
                     "family member",
                     "family member",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: father-in-law.<br>
     */
    FATHER_IN_LAW_L5("FTHINLAW",
                     "2.16.840.1.113883.5.111",
                     "father-in-law",
                     "father-in-law",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: father.<br>
     */
    FATHER_L3("FTH",
              "2.16.840.1.113883.5.111",
              "father",
              "father",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: former spouse.<br>
     */
    FORMER_SPOUSE_L3("FMRSPS",
                     "2.16.840.1.113883.5.111",
                     "former spouse",
                     "former spouse",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: foster child.<br>
     */
    FOSTER_CHILD_L3("CHLDFOST",
                    "2.16.840.1.113883.5.111",
                    "foster child",
                    "foster child",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: foster daughter.<br>
     */
    FOSTER_DAUGHTER_L4("DAUFOST",
                       "2.16.840.1.113883.5.111",
                       "foster daughter",
                       "foster daughter",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: foster father.<br>
     */
    FOSTER_FATHER_L4("FTHFOST",
                     "2.16.840.1.113883.5.111",
                     "foster father",
                     "foster father",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: foster mother.<br>
     */
    FOSTER_MOTHER_L4("MTHFOST",
                     "2.16.840.1.113883.5.111",
                     "foster mother",
                     "foster mother",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: foster parent.<br>
     */
    FOSTER_PARENT_L3("PRNFOST",
                     "2.16.840.1.113883.5.111",
                     "foster parent",
                     "foster parent",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: foster son.<br>
     */
    FOSTER_SON_L4("SONFOST",
                  "2.16.840.1.113883.5.111",
                  "foster son",
                  "foster son",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: fraternal twin brother.<br>
     */
    FRATERNAL_TWIN_BROTHER_L6("FTWINBRO",
                              "2.16.840.1.113883.5.111",
                              "fraternal twin brother",
                              "fraternal twin brother",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: fraternal twin.<br>
     */
    FRATERNAL_TWIN_L5("FTWIN",
                      "2.16.840.1.113883.5.111",
                      "fraternal twin",
                      "fraternal twin",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: fraternal twin sister.<br>
     */
    FRATERNAL_TWIN_SISTER_L6("FTWINSIS",
                             "2.16.840.1.113883.5.111",
                             "fraternal twin sister",
                             "fraternal twin sister",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: gestational mother.<br>
     */
    GESTATIONAL_MOTHER_L4("GESTM",
                          "2.16.840.1.113883.5.111",
                          "gestational mother",
                          "gestational mother",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: grandchild.<br>
     */
    GRANDCHILD_L3("GRNDCHILD",
                  "2.16.840.1.113883.5.111",
                  "grandchild",
                  "grandchild",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: granddaughter.<br>
     */
    GRANDDAUGHTER_L4("GRNDDAU",
                     "2.16.840.1.113883.5.111",
                     "granddaughter",
                     "granddaughter",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: grandfather.<br>
     */
    GRANDFATHER_L4("GRFTH",
                   "2.16.840.1.113883.5.111",
                   "grandfather",
                   "grandfather",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: grandmother.<br>
     */
    GRANDMOTHER_L4("GRMTH",
                   "2.16.840.1.113883.5.111",
                   "grandmother",
                   "grandmother",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: grandparent.<br>
     */
    GRANDPARENT_L3("GRPRN",
                   "2.16.840.1.113883.5.111",
                   "grandparent",
                   "grandparent",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: grandson.<br>
     */
    GRANDSON_L4("GRNDSON",
                "2.16.840.1.113883.5.111",
                "grandson",
                "grandson",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: great grandfather.<br>
     */
    GREAT_GRANDFATHER_L4("GGRFTH",
                         "2.16.840.1.113883.5.111",
                         "great grandfather",
                         "great grandfather",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: great grandmother.<br>
     */
    GREAT_GRANDMOTHER_L4("GGRMTH",
                         "2.16.840.1.113883.5.111",
                         "great grandmother",
                         "great grandmother",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: great grandparent.<br>
     */
    GREAT_GRANDPARENT_L3("GGRPRN",
                         "2.16.840.1.113883.5.111",
                         "great grandparent",
                         "great grandparent",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: half-brother.<br>
     */
    HALF_BROTHER_L4("HBRO",
                    "2.16.840.1.113883.5.111",
                    "half-brother",
                    "half-brother",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: half-sibling.<br>
     */
    HALF_SIBLING_L3("HSIB",
                    "2.16.840.1.113883.5.111",
                    "half-sibling",
                    "half-sibling",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: half-sister.<br>
     */
    HALF_SISTER_L4("HSIS",
                   "2.16.840.1.113883.5.111",
                   "half-sister",
                   "half-sister",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: husband.<br>
     */
    HUSBAND_L4("HUSB",
               "2.16.840.1.113883.5.111",
               "husband",
               "husband",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: identical twin brother.<br>
     */
    IDENTICAL_TWIN_BROTHER_L6("ITWINBRO",
                              "2.16.840.1.113883.5.111",
                              "identical twin brother",
                              "identical twin brother",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: identical twin.<br>
     */
    IDENTICAL_TWIN_L5("ITWIN",
                      "2.16.840.1.113883.5.111",
                      "identical twin",
                      "identical twin",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: identical twin sister.<br>
     */
    IDENTICAL_TWIN_SISTER_L6("ITWINSIS",
                             "2.16.840.1.113883.5.111",
                             "identical twin sister",
                             "identical twin sister",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: inlaw.<br>
     */
    INLAW_L3("INLAW",
             "2.16.840.1.113883.5.111",
             "inlaw",
             "inlaw",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: maternal aunt.<br>
     */
    MATERNAL_AUNT_L4("MAUNT",
                     "2.16.840.1.113883.5.111",
                     "maternal aunt",
                     "maternal aunt",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: maternal cousin.<br>
     */
    MATERNAL_COUSIN_L4("MCOUSN",
                       "2.16.840.1.113883.5.111",
                       "maternal cousin",
                       "maternal cousin",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: maternal grandfather.<br>
     */
    MATERNAL_GRANDFATHER_L5("MGRFTH",
                            "2.16.840.1.113883.5.111",
                            "maternal grandfather",
                            "maternal grandfather",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: maternal grandmother.<br>
     */
    MATERNAL_GRANDMOTHER_L5("MGRMTH",
                            "2.16.840.1.113883.5.111",
                            "maternal grandmother",
                            "maternal grandmother",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: maternal grandparent.<br>
     */
    MATERNAL_GRANDPARENT_L4("MGRPRN",
                            "2.16.840.1.113883.5.111",
                            "maternal grandparent",
                            "maternal grandparent",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: maternal great-grandfather.<br>
     */
    MATERNAL_GREAT_GRANDFATHER_L5("MGGRFTH",
                                  "2.16.840.1.113883.5.111",
                                  "maternal great-grandfather",
                                  "maternal great-grandfather",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: maternal great-grandmother.<br>
     */
    MATERNAL_GREAT_GRANDMOTHER_L5("MGGRMTH",
                                  "2.16.840.1.113883.5.111",
                                  "maternal great-grandmother",
                                  "maternal great-grandmother",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: maternal great-grandparent.<br>
     */
    MATERNAL_GREAT_GRANDPARENT_L4("MGGRPRN",
                                  "2.16.840.1.113883.5.111",
                                  "maternal great-grandparent",
                                  "maternal great-grandparent",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: maternal uncle.<br>
     */
    MATERNAL_UNCLE_L4("MUNCLE",
                      "2.16.840.1.113883.5.111",
                      "maternal uncle",
                      "maternal uncle",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: mother-in-law.<br>
     */
    MOTHER_IN_LAW_L5("MTHINLAW",
                     "2.16.840.1.113883.5.111",
                     "mother-in-law",
                     "mother-in-law",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: mother.<br>
     */
    MOTHER_L3("MTH",
              "2.16.840.1.113883.5.111",
              "mother",
              "mother",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: natural brother.<br>
     */
    NATURAL_BROTHER_L4("NBRO",
                       "2.16.840.1.113883.5.111",
                       "natural brother",
                       "natural brother",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: natural child.<br>
     */
    NATURAL_CHILD_L3("NCHILD",
                     "2.16.840.1.113883.5.111",
                     "natural child",
                     "natural child",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: natural daughter.<br>
     */
    NATURAL_DAUGHTER_L4("DAU",
                        "2.16.840.1.113883.5.111",
                        "natural daughter",
                        "natural daughter",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: natural father.<br>
     */
    NATURAL_FATHER_L4("NFTH",
                      "2.16.840.1.113883.5.111",
                      "natural father",
                      "natural father",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: natural father of fetus.<br>
     */
    NATURAL_FATHER_OF_FETUS_L5("NFTHF",
                               "2.16.840.1.113883.5.111",
                               "natural father of fetus",
                               "natural father of fetus",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: natural mother.<br>
     */
    NATURAL_MOTHER_L4("NMTH",
                      "2.16.840.1.113883.5.111",
                      "natural mother",
                      "natural mother",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: natural mother of fetus.<br>
     */
    NATURAL_MOTHER_OF_FETUS_L5("NMTHF",
                               "2.16.840.1.113883.5.111",
                               "natural mother of fetus",
                               "natural mother of fetus",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: natural parent.<br>
     */
    NATURAL_PARENT_L3("NPRN",
                      "2.16.840.1.113883.5.111",
                      "natural parent",
                      "natural parent",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: natural sibling.<br>
     */
    NATURAL_SIBLING_L3("NSIB",
                       "2.16.840.1.113883.5.111",
                       "natural sibling",
                       "natural sibling",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: natural sister.<br>
     */
    NATURAL_SISTER_L4("NSIS",
                      "2.16.840.1.113883.5.111",
                      "natural sister",
                      "natural sister",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: natural son.<br>
     */
    NATURAL_SON_L4("SON",
                   "2.16.840.1.113883.5.111",
                   "natural son",
                   "natural son",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: neighbor.<br>
     */
    NEIGHBOR_L1("NBOR",
                "2.16.840.1.113883.5.111",
                "neighbor",
                "neighbor",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: nephew.<br>
     */
    NEPHEW_L4("NEPHEW",
              "2.16.840.1.113883.5.111",
              "nephew",
              "nephew",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: niece.<br>
     */
    NIECE_L4("NIECE",
             "2.16.840.1.113883.5.111",
             "niece",
             "niece",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: niece/nephew.<br>
     */
    NIECE_NEPHEW_L3("NIENEPH",
                    "2.16.840.1.113883.5.111",
                    "niece/nephew",
                    "niece/nephew",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: parent in-law.<br>
     */
    PARENT_IN_LAW_L4("PRNINLAW",
                     "2.16.840.1.113883.5.111",
                     "parent in-law",
                     "parent in-law",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: parent.<br>
     */
    PARENT_L2("PRN",
              "2.16.840.1.113883.5.111",
              "parent",
              "parent",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: paternal aunt.<br>
     */
    PATERNAL_AUNT_L4("PAUNT",
                     "2.16.840.1.113883.5.111",
                     "paternal aunt",
                     "paternal aunt",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: paternal cousin.<br>
     */
    PATERNAL_COUSIN_L4("PCOUSN",
                       "2.16.840.1.113883.5.111",
                       "paternal cousin",
                       "paternal cousin",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: paternal grandfather.<br>
     */
    PATERNAL_GRANDFATHER_L5("PGRFTH",
                            "2.16.840.1.113883.5.111",
                            "paternal grandfather",
                            "paternal grandfather",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: paternal grandmother.<br>
     */
    PATERNAL_GRANDMOTHER_L5("PGRMTH",
                            "2.16.840.1.113883.5.111",
                            "paternal grandmother",
                            "paternal grandmother",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: paternal grandparent.<br>
     */
    PATERNAL_GRANDPARENT_L4("PGRPRN",
                            "2.16.840.1.113883.5.111",
                            "paternal grandparent",
                            "paternal grandparent",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: paternal great-grandfather.<br>
     */
    PATERNAL_GREAT_GRANDFATHER_L5("PGGRFTH",
                                  "2.16.840.1.113883.5.111",
                                  "paternal great-grandfather",
                                  "paternal great-grandfather",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: paternal great-grandmother.<br>
     */
    PATERNAL_GREAT_GRANDMOTHER_L5("PGGRMTH",
                                  "2.16.840.1.113883.5.111",
                                  "paternal great-grandmother",
                                  "paternal great-grandmother",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: paternal great-grandparent.<br>
     */
    PATERNAL_GREAT_GRANDPARENT_L4("PGGRPRN",
                                  "2.16.840.1.113883.5.111",
                                  "paternal great-grandparent",
                                  "paternal great-grandparent",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: paternal uncle.<br>
     */
    PATERNAL_UNCLE_L4("PUNCLE",
                      "2.16.840.1.113883.5.111",
                      "paternal uncle",
                      "paternal uncle",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Roommate.<br>
     */
    ROOMMATE_L1("ROOM",
                "2.16.840.1.113883.5.111",
                "Roommate",
                "Roommate",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: self.<br>
     */
    SELF_L1("ONESELF",
            "2.16.840.1.113883.5.111",
            "self",
            "self",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: sibling in-law.<br>
     */
    SIBLING_IN_LAW_L4("SIBINLAW",
                      "2.16.840.1.113883.5.111",
                      "sibling in-law",
                      "sibling in-law",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: sibling.<br>
     */
    SIBLING_L2("SIB",
               "2.16.840.1.113883.5.111",
               "sibling",
               "sibling",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: significant other.<br>
     */
    SIGNIFICANT_OTHER_L2("SIGOTHR",
                         "2.16.840.1.113883.5.111",
                         "significant other",
                         "significant other",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: sister-in-law.<br>
     */
    SISTER_IN_LAW_L5("SISINLAW",
                     "2.16.840.1.113883.5.111",
                     "sister-in-law",
                     "sister-in-law",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: sister.<br>
     */
    SISTER_L3("SIS",
              "2.16.840.1.113883.5.111",
              "sister",
              "sister",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: son in-law.<br>
     */
    SON_IN_LAW_L5("SONINLAW",
                  "2.16.840.1.113883.5.111",
                  "son in-law",
                  "son in-law",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: son.<br>
     */
    SON_L3("SONC",
           "2.16.840.1.113883.5.111",
           "son",
           "son",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: spouse.<br>
     */
    SPOUSE_L3("SPS",
              "2.16.840.1.113883.5.111",
              "spouse",
              "spouse",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: stepbrother.<br>
     */
    STEPBROTHER_L4("STPBRO",
                   "2.16.840.1.113883.5.111",
                   "stepbrother",
                   "stepbrother",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: stepdaughter.<br>
     */
    STEPDAUGHTER_L4("STPDAU",
                    "2.16.840.1.113883.5.111",
                    "stepdaughter",
                    "stepdaughter",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: stepfather.<br>
     */
    STEPFATHER_L4("STPFTH",
                  "2.16.840.1.113883.5.111",
                  "stepfather",
                  "stepfather",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: stepmother.<br>
     */
    STEPMOTHER_L4("STPMTH",
                  "2.16.840.1.113883.5.111",
                  "stepmother",
                  "stepmother",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: stepsister.<br>
     */
    STEPSISTER_L4("STPSIS",
                  "2.16.840.1.113883.5.111",
                  "stepsister",
                  "stepsister",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: stepson.<br>
     */
    STEPSON_L4("STPSON",
               "2.16.840.1.113883.5.111",
               "stepson",
               "stepson",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: step child.<br>
     */
    STEP_CHILD_L3("STPCHLD",
                  "2.16.840.1.113883.5.111",
                  "step child",
                  "step child",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: step parent.<br>
     */
    STEP_PARENT_L3("STPPRN",
                   "2.16.840.1.113883.5.111",
                   "step parent",
                   "step parent",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: step sibling.<br>
     */
    STEP_SIBLING_L3("STPSIB",
                    "2.16.840.1.113883.5.111",
                    "step sibling",
                    "step sibling",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: twin brother.<br>
     */
    TWIN_BROTHER_L5("TWINBRO",
                    "2.16.840.1.113883.5.111",
                    "twin brother",
                    "twin brother",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: twin.<br>
     */
    TWIN_L4("TWIN",
            "2.16.840.1.113883.5.111",
            "twin",
            "twin",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: twin sister.<br>
     */
    TWIN_SISTER_L5("TWINSIS",
                   "2.16.840.1.113883.5.111",
                   "twin sister",
                   "twin sister",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: uncle.<br>
     */
    UNCLE_L3("UNCLE",
             "2.16.840.1.113883.5.111",
             "uncle",
             "uncle",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: unrelated friend.<br>
     */
    UNRELATED_FRIEND_L1("FRND",
                        "2.16.840.1.113883.5.111",
                        "unrelated friend",
                        "unrelated friend",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: wife.<br>
     */
    WIFE_L4("WIFE",
            "2.16.840.1.113883.5.111",
            "wife",
            "wife",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE");

    /**
     * EN: Code for adopted child.<br>
     */
    public static final String ADOPTED_CHILD_L3_CODE = "CHLDADOPT";

    /**
     * EN: Code for adopted daughter.<br>
     */
    public static final String ADOPTED_DAUGHTER_L4_CODE = "DAUADOPT";

    /**
     * EN: Code for adopted son.<br>
     */
    public static final String ADOPTED_SON_L4_CODE = "SONADOPT";

    /**
     * EN: Code for adoptive father.<br>
     */
    public static final String ADOPTIVE_FATHER_L4_CODE = "ADOPTF";

    /**
     * EN: Code for adoptive mother.<br>
     */
    public static final String ADOPTIVE_MOTHER_L4_CODE = "ADOPTM";

    /**
     * EN: Code for adoptive parent.<br>
     */
    public static final String ADOPTIVE_PARENT_L3_CODE = "ADOPTP";

    /**
     * EN: Code for aunt.<br>
     */
    public static final String AUNT_L3_CODE = "AUNT";

    /**
     * EN: Code for brother-in-law.<br>
     */
    public static final String BROTHER_IN_LAW_L5_CODE = "BROINLAW";

    /**
     * EN: Code for brother.<br>
     */
    public static final String BROTHER_L3_CODE = "BRO";

    /**
     * EN: Code for child-in-law.<br>
     */
    public static final String CHILD_IN_LAW_L4_CODE = "CHLDINLAW";

    /**
     * EN: Code for child.<br>
     */
    public static final String CHILD_L2_CODE = "CHILD";

    /**
     * EN: Code for cousin.<br>
     */
    public static final String COUSIN_L3_CODE = "COUSN";

    /**
     * EN: Code for daughter in-law.<br>
     */
    public static final String DAUGHTER_IN_LAW_L5_CODE = "DAUINLAW";

    /**
     * EN: Code for daughter.<br>
     */
    public static final String DAUGHTER_L3_CODE = "DAUC";

    /**
     * EN: Code for domestic partner.<br>
     */
    public static final String DOMESTIC_PARTNER_L3_CODE = "DOMPART";

    /**
     * EN: Code for extended family member.<br>
     */
    public static final String EXTENDED_FAMILY_MEMBER_L2_CODE = "EXT";

    /**
     * EN: Code for family member.<br>
     */
    public static final String FAMILY_MEMBER_L1_CODE = "FAMMEMB";

    /**
     * EN: Code for father-in-law.<br>
     */
    public static final String FATHER_IN_LAW_L5_CODE = "FTHINLAW";

    /**
     * EN: Code for father.<br>
     */
    public static final String FATHER_L3_CODE = "FTH";

    /**
     * EN: Code for former spouse.<br>
     */
    public static final String FORMER_SPOUSE_L3_CODE = "FMRSPS";

    /**
     * EN: Code for foster child.<br>
     */
    public static final String FOSTER_CHILD_L3_CODE = "CHLDFOST";

    /**
     * EN: Code for foster daughter.<br>
     */
    public static final String FOSTER_DAUGHTER_L4_CODE = "DAUFOST";

    /**
     * EN: Code for foster father.<br>
     */
    public static final String FOSTER_FATHER_L4_CODE = "FTHFOST";

    /**
     * EN: Code for foster mother.<br>
     */
    public static final String FOSTER_MOTHER_L4_CODE = "MTHFOST";

    /**
     * EN: Code for foster parent.<br>
     */
    public static final String FOSTER_PARENT_L3_CODE = "PRNFOST";

    /**
     * EN: Code for foster son.<br>
     */
    public static final String FOSTER_SON_L4_CODE = "SONFOST";

    /**
     * EN: Code for fraternal twin brother.<br>
     */
    public static final String FRATERNAL_TWIN_BROTHER_L6_CODE = "FTWINBRO";

    /**
     * EN: Code for fraternal twin.<br>
     */
    public static final String FRATERNAL_TWIN_L5_CODE = "FTWIN";

    /**
     * EN: Code for fraternal twin sister.<br>
     */
    public static final String FRATERNAL_TWIN_SISTER_L6_CODE = "FTWINSIS";

    /**
     * EN: Code for gestational mother.<br>
     */
    public static final String GESTATIONAL_MOTHER_L4_CODE = "GESTM";

    /**
     * EN: Code for grandchild.<br>
     */
    public static final String GRANDCHILD_L3_CODE = "GRNDCHILD";

    /**
     * EN: Code for granddaughter.<br>
     */
    public static final String GRANDDAUGHTER_L4_CODE = "GRNDDAU";

    /**
     * EN: Code for grandfather.<br>
     */
    public static final String GRANDFATHER_L4_CODE = "GRFTH";

    /**
     * EN: Code for grandmother.<br>
     */
    public static final String GRANDMOTHER_L4_CODE = "GRMTH";

    /**
     * EN: Code for grandparent.<br>
     */
    public static final String GRANDPARENT_L3_CODE = "GRPRN";

    /**
     * EN: Code for grandson.<br>
     */
    public static final String GRANDSON_L4_CODE = "GRNDSON";

    /**
     * EN: Code for great grandfather.<br>
     */
    public static final String GREAT_GRANDFATHER_L4_CODE = "GGRFTH";

    /**
     * EN: Code for great grandmother.<br>
     */
    public static final String GREAT_GRANDMOTHER_L4_CODE = "GGRMTH";

    /**
     * EN: Code for great grandparent.<br>
     */
    public static final String GREAT_GRANDPARENT_L3_CODE = "GGRPRN";

    /**
     * EN: Code for half-brother.<br>
     */
    public static final String HALF_BROTHER_L4_CODE = "HBRO";

    /**
     * EN: Code for half-sibling.<br>
     */
    public static final String HALF_SIBLING_L3_CODE = "HSIB";

    /**
     * EN: Code for half-sister.<br>
     */
    public static final String HALF_SISTER_L4_CODE = "HSIS";

    /**
     * EN: Code for husband.<br>
     */
    public static final String HUSBAND_L4_CODE = "HUSB";

    /**
     * EN: Code for identical twin brother.<br>
     */
    public static final String IDENTICAL_TWIN_BROTHER_L6_CODE = "ITWINBRO";

    /**
     * EN: Code for identical twin.<br>
     */
    public static final String IDENTICAL_TWIN_L5_CODE = "ITWIN";

    /**
     * EN: Code for identical twin sister.<br>
     */
    public static final String IDENTICAL_TWIN_SISTER_L6_CODE = "ITWINSIS";

    /**
     * EN: Code for inlaw.<br>
     */
    public static final String INLAW_L3_CODE = "INLAW";

    /**
     * EN: Code for maternal aunt.<br>
     */
    public static final String MATERNAL_AUNT_L4_CODE = "MAUNT";

    /**
     * EN: Code for maternal cousin.<br>
     */
    public static final String MATERNAL_COUSIN_L4_CODE = "MCOUSN";

    /**
     * EN: Code for maternal grandfather.<br>
     */
    public static final String MATERNAL_GRANDFATHER_L5_CODE = "MGRFTH";

    /**
     * EN: Code for maternal grandmother.<br>
     */
    public static final String MATERNAL_GRANDMOTHER_L5_CODE = "MGRMTH";

    /**
     * EN: Code for maternal grandparent.<br>
     */
    public static final String MATERNAL_GRANDPARENT_L4_CODE = "MGRPRN";

    /**
     * EN: Code for maternal great-grandfather.<br>
     */
    public static final String MATERNAL_GREAT_GRANDFATHER_L5_CODE = "MGGRFTH";

    /**
     * EN: Code for maternal great-grandmother.<br>
     */
    public static final String MATERNAL_GREAT_GRANDMOTHER_L5_CODE = "MGGRMTH";

    /**
     * EN: Code for maternal great-grandparent.<br>
     */
    public static final String MATERNAL_GREAT_GRANDPARENT_L4_CODE = "MGGRPRN";

    /**
     * EN: Code for maternal uncle.<br>
     */
    public static final String MATERNAL_UNCLE_L4_CODE = "MUNCLE";

    /**
     * EN: Code for mother-in-law.<br>
     */
    public static final String MOTHER_IN_LAW_L5_CODE = "MTHINLAW";

    /**
     * EN: Code for mother.<br>
     */
    public static final String MOTHER_L3_CODE = "MTH";

    /**
     * EN: Code for natural brother.<br>
     */
    public static final String NATURAL_BROTHER_L4_CODE = "NBRO";

    /**
     * EN: Code for natural child.<br>
     */
    public static final String NATURAL_CHILD_L3_CODE = "NCHILD";

    /**
     * EN: Code for natural daughter.<br>
     */
    public static final String NATURAL_DAUGHTER_L4_CODE = "DAU";

    /**
     * EN: Code for natural father.<br>
     */
    public static final String NATURAL_FATHER_L4_CODE = "NFTH";

    /**
     * EN: Code for natural father of fetus.<br>
     */
    public static final String NATURAL_FATHER_OF_FETUS_L5_CODE = "NFTHF";

    /**
     * EN: Code for natural mother.<br>
     */
    public static final String NATURAL_MOTHER_L4_CODE = "NMTH";

    /**
     * EN: Code for natural mother of fetus.<br>
     */
    public static final String NATURAL_MOTHER_OF_FETUS_L5_CODE = "NMTHF";

    /**
     * EN: Code for natural parent.<br>
     */
    public static final String NATURAL_PARENT_L3_CODE = "NPRN";

    /**
     * EN: Code for natural sibling.<br>
     */
    public static final String NATURAL_SIBLING_L3_CODE = "NSIB";

    /**
     * EN: Code for natural sister.<br>
     */
    public static final String NATURAL_SISTER_L4_CODE = "NSIS";

    /**
     * EN: Code for natural son.<br>
     */
    public static final String NATURAL_SON_L4_CODE = "SON";

    /**
     * EN: Code for neighbor.<br>
     */
    public static final String NEIGHBOR_L1_CODE = "NBOR";

    /**
     * EN: Code for nephew.<br>
     */
    public static final String NEPHEW_L4_CODE = "NEPHEW";

    /**
     * EN: Code for niece.<br>
     */
    public static final String NIECE_L4_CODE = "NIECE";

    /**
     * EN: Code for niece/nephew.<br>
     */
    public static final String NIECE_NEPHEW_L3_CODE = "NIENEPH";

    /**
     * EN: Code for parent in-law.<br>
     */
    public static final String PARENT_IN_LAW_L4_CODE = "PRNINLAW";

    /**
     * EN: Code for parent.<br>
     */
    public static final String PARENT_L2_CODE = "PRN";

    /**
     * EN: Code for paternal aunt.<br>
     */
    public static final String PATERNAL_AUNT_L4_CODE = "PAUNT";

    /**
     * EN: Code for paternal cousin.<br>
     */
    public static final String PATERNAL_COUSIN_L4_CODE = "PCOUSN";

    /**
     * EN: Code for paternal grandfather.<br>
     */
    public static final String PATERNAL_GRANDFATHER_L5_CODE = "PGRFTH";

    /**
     * EN: Code for paternal grandmother.<br>
     */
    public static final String PATERNAL_GRANDMOTHER_L5_CODE = "PGRMTH";

    /**
     * EN: Code for paternal grandparent.<br>
     */
    public static final String PATERNAL_GRANDPARENT_L4_CODE = "PGRPRN";

    /**
     * EN: Code for paternal great-grandfather.<br>
     */
    public static final String PATERNAL_GREAT_GRANDFATHER_L5_CODE = "PGGRFTH";

    /**
     * EN: Code for paternal great-grandmother.<br>
     */
    public static final String PATERNAL_GREAT_GRANDMOTHER_L5_CODE = "PGGRMTH";

    /**
     * EN: Code for paternal great-grandparent.<br>
     */
    public static final String PATERNAL_GREAT_GRANDPARENT_L4_CODE = "PGGRPRN";

    /**
     * EN: Code for paternal uncle.<br>
     */
    public static final String PATERNAL_UNCLE_L4_CODE = "PUNCLE";

    /**
     * EN: Code for Roommate.<br>
     */
    public static final String ROOMMATE_L1_CODE = "ROOM";

    /**
     * EN: Code for self.<br>
     */
    public static final String SELF_L1_CODE = "ONESELF";

    /**
     * EN: Code for sibling in-law.<br>
     */
    public static final String SIBLING_IN_LAW_L4_CODE = "SIBINLAW";

    /**
     * EN: Code for sibling.<br>
     */
    public static final String SIBLING_L2_CODE = "SIB";

    /**
     * EN: Code for significant other.<br>
     */
    public static final String SIGNIFICANT_OTHER_L2_CODE = "SIGOTHR";

    /**
     * EN: Code for sister-in-law.<br>
     */
    public static final String SISTER_IN_LAW_L5_CODE = "SISINLAW";

    /**
     * EN: Code for sister.<br>
     */
    public static final String SISTER_L3_CODE = "SIS";

    /**
     * EN: Code for son in-law.<br>
     */
    public static final String SON_IN_LAW_L5_CODE = "SONINLAW";

    /**
     * EN: Code for son.<br>
     */
    public static final String SON_L3_CODE = "SONC";

    /**
     * EN: Code for spouse.<br>
     */
    public static final String SPOUSE_L3_CODE = "SPS";

    /**
     * EN: Code for stepbrother.<br>
     */
    public static final String STEPBROTHER_L4_CODE = "STPBRO";

    /**
     * EN: Code for stepdaughter.<br>
     */
    public static final String STEPDAUGHTER_L4_CODE = "STPDAU";

    /**
     * EN: Code for stepfather.<br>
     */
    public static final String STEPFATHER_L4_CODE = "STPFTH";

    /**
     * EN: Code for stepmother.<br>
     */
    public static final String STEPMOTHER_L4_CODE = "STPMTH";

    /**
     * EN: Code for stepsister.<br>
     */
    public static final String STEPSISTER_L4_CODE = "STPSIS";

    /**
     * EN: Code for stepson.<br>
     */
    public static final String STEPSON_L4_CODE = "STPSON";

    /**
     * EN: Code for step child.<br>
     */
    public static final String STEP_CHILD_L3_CODE = "STPCHLD";

    /**
     * EN: Code for step parent.<br>
     */
    public static final String STEP_PARENT_L3_CODE = "STPPRN";

    /**
     * EN: Code for step sibling.<br>
     */
    public static final String STEP_SIBLING_L3_CODE = "STPSIB";

    /**
     * EN: Code for twin brother.<br>
     */
    public static final String TWIN_BROTHER_L5_CODE = "TWINBRO";

    /**
     * EN: Code for twin.<br>
     */
    public static final String TWIN_L4_CODE = "TWIN";

    /**
     * EN: Code for twin sister.<br>
     */
    public static final String TWIN_SISTER_L5_CODE = "TWINSIS";

    /**
     * EN: Code for uncle.<br>
     */
    public static final String UNCLE_L3_CODE = "UNCLE";

    /**
     * EN: Code for unrelated friend.<br>
     */
    public static final String UNRELATED_FRIEND_L1_CODE = "FRND";

    /**
     * EN: Code for wife.<br>
     */
    public static final String WIFE_L4_CODE = "WIFE";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.19563";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "PersonalRelationshipRoleType";

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
    public static PersonalRelationshipRoleType getEnum(@Nullable final String code) {
        for (final PersonalRelationshipRoleType x : values()) {
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
            Enum.valueOf(PersonalRelationshipRoleType.class,
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
        for (final PersonalRelationshipRoleType x : values()) {
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
    PersonalRelationshipRoleType(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
