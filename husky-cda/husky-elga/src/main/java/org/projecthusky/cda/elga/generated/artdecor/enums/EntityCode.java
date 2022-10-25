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
 * Enumeration of EntityCode values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>A value representing the specific kind of Entity the instance represents.</p><p> <i>Examples:</i> A medical building, a Doberman Pinscher, a blood collection tube, a tissue biopsy.</p><p> <i>Rationale:</i> For each Entity, the value for this attribute is drawn from one of several coding systems depending on the Entity classCode, such as living subjects (animal and plant taxonomies), chemical substance (e.g., IUPAC code), organizations, insurance company, government agency, hospital, park, lake, syringe, etc. It is possible that Entity.code may be so fine grained that it represents a single instance. An example is the CDC vaccine manufacturer code, modeled as a concept vocabulary, when in fact each concept refers to a single instance.</p>.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.16040<br>
 * Effective date: 2014-03-26 00:00<br>
 * Version: DEFN=UV=VO=1360-20160323<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-18")
public enum EntityCode implements ValueSetEnumInterface {

    /**
     * EN: Abcess.<br>
     */
    ABCESS_L1("ABS",
              "2.16.840.1.113883.5.129",
              "Abcess",
              "Abcess",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: AccessMedicalDevice.<br>
     */
    ACCESSMEDICALDEVICE_L1("_AccessMedicalDevice",
                           "2.16.840.1.113883.5.1060",
                           "AccessMedicalDevice",
                           "AccessMedicalDevice",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: AccessMedicalDevice.<br>
     */
    ACCESSMEDICALDEVICE_L2("_AccessMedicalDevice",
                           "2.16.840.1.113883.5.1060",
                           "AccessMedicalDevice",
                           "AccessMedicalDevice",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: ACD Solution A.<br>
     */
    ACD_SOLUTION_A_L1("ACDA",
                      "2.16.840.1.113883.5.1060",
                      "ACD Solution A",
                      "ACD Solution A",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: ACD Solution A.<br>
     */
    ACD_SOLUTION_A_L2("ACDA",
                      "2.16.840.1.113883.5.1060",
                      "ACD Solution A",
                      "ACD Solution A",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: ACD Solution B.<br>
     */
    ACD_SOLUTION_B_L1("ACDB",
                      "2.16.840.1.113883.5.1060",
                      "ACD Solution B",
                      "ACD Solution B",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: ACD Solution B.<br>
     */
    ACD_SOLUTION_B_L2("ACDB",
                      "2.16.840.1.113883.5.1060",
                      "ACD Solution B",
                      "ACD Solution B",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Acetic Acid.<br>
     */
    ACETIC_ACID_L1("ACET",
                   "2.16.840.1.113883.5.1060",
                   "Acetic Acid",
                   "Acetic Acid",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Acetic Acid.<br>
     */
    ACETIC_ACID_L2("ACET",
                   "2.16.840.1.113883.5.1060",
                   "Acetic Acid",
                   "Acetic Acid",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: AdministrationMedicalDevice.<br>
     */
    ADMINISTRATIONMEDICALDEVICE_L1("_AdministrationMedicalDevice",
                                   "2.16.840.1.113883.5.1060",
                                   "AdministrationMedicalDevice",
                                   "AdministrationMedicalDevice",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: AdministrationMedicalDevice.<br>
     */
    ADMINISTRATIONMEDICALDEVICE_L2("_AdministrationMedicalDevice",
                                   "2.16.840.1.113883.5.1060",
                                   "AdministrationMedicalDevice",
                                   "AdministrationMedicalDevice",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Amber Bottle.<br>
     */
    AMBER_BOTTLE_L5("BOTA",
                    "2.16.840.1.113883.5.1060",
                    "Amber Bottle",
                    "Amber Bottle",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Amber Bottle.<br>
     */
    AMBER_BOTTLE_L6("BOTA",
                    "2.16.840.1.113883.5.1060",
                    "Amber Bottle",
                    "Amber Bottle",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Amies transport medium.<br>
     */
    AMIES_TRANSPORT_MEDIUM_L1("AMIES",
                              "2.16.840.1.113883.5.1060",
                              "Amies transport medium",
                              "Amies transport medium",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Amies transport medium.<br>
     */
    AMIES_TRANSPORT_MEDIUM_L2("AMIES",
                              "2.16.840.1.113883.5.1060",
                              "Amies transport medium",
                              "Amies transport medium",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Ammonium heparin.<br>
     */
    AMMONIUM_HEPARIN_L1("HEPA",
                        "2.16.840.1.113883.5.1060",
                        "Ammonium heparin",
                        "Ammonium heparin",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Ammonium heparin.<br>
     */
    AMMONIUM_HEPARIN_L2("HEPA",
                        "2.16.840.1.113883.5.1060",
                        "Ammonium heparin",
                        "Ammonium heparin",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Amniotic fluid.<br>
     */
    AMNIOTIC_FLUID_L1("AMN",
                      "2.16.840.1.113883.5.129",
                      "Amniotic fluid",
                      "Amniotic fluid",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Ampule.<br>
     */
    AMPULE_L4("AMP",
              "2.16.840.1.113883.5.1060",
              "Ampule",
              "Ampule",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Ampule.<br>
     */
    AMPULE_L5("AMP",
              "2.16.840.1.113883.5.1060",
              "Ampule",
              "Ampule",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Applicator.<br>
     */
    APPLICATOR_L2("APLCTR",
                  "2.16.840.1.113883.5.1060",
                  "Applicator",
                  "Applicator",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Applicator.<br>
     */
    APPLICATOR_L3("APLCTR",
                  "2.16.840.1.113883.5.1060",
                  "Applicator",
                  "Applicator",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Aspirate.<br>
     */
    ASPIRATE_L1("ASP",
                "2.16.840.1.113883.5.129",
                "Aspirate",
                "Aspirate",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: AutoInjector.<br>
     */
    AUTOINJECTOR_L3("AINJ",
                    "2.16.840.1.113883.5.1060",
                    "AutoInjector",
                    "AutoInjector",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: AutoInjector.<br>
     */
    AUTOINJECTOR_L4("AINJ",
                    "2.16.840.1.113883.5.1060",
                    "AutoInjector",
                    "AutoInjector",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Bacterial Transport medium.<br>
     */
    BACTERIAL_TRANSPORT_MEDIUM_L1("BACTM",
                                  "2.16.840.1.113883.5.1060",
                                  "Bacterial Transport medium",
                                  "Bacterial Transport medium",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Bacterial Transport medium.<br>
     */
    BACTERIAL_TRANSPORT_MEDIUM_L2("BACTM",
                                  "2.16.840.1.113883.5.1060",
                                  "Bacterial Transport medium",
                                  "Bacterial Transport medium",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Bag.<br>
     */
    BAG_L3("BAG",
           "2.16.840.1.113883.5.1060",
           "Bag",
           "Bag",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Bag.<br>
     */
    BAG_L4("BAG",
           "2.16.840.1.113883.5.1060",
           "Bag",
           "Bag",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Basophils.<br>
     */
    BASOPHILS_L1("BPH",
                 "2.16.840.1.113883.5.129",
                 "Basophils",
                 "Basophils",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Bed Location.<br>
     */
    BED_LOCATION_L1("BED",
                    "2.16.840.1.113883.5.1060",
                    "Bed Location",
                    "Bed Location",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Bile fluid.<br>
     */
    BILE_FLUID_L1("BIFL",
                  "2.16.840.1.113883.5.129",
                  "Bile fluid",
                  "Bile fluid",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Blister Pack.<br>
     */
    BLISTER_PACK_L3("BLSTRPK",
                    "2.16.840.1.113883.5.1060",
                    "Blister Pack",
                    "Blister Pack",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Blister Pack.<br>
     */
    BLISTER_PACK_L4("BLSTRPK",
                    "2.16.840.1.113883.5.1060",
                    "Blister Pack",
                    "Blister Pack",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Blood arterial.<br>
     */
    BLOOD_ARTERIAL_L1("BLDA",
                      "2.16.840.1.113883.5.129",
                      "Blood arterial",
                      "Blood arterial",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Blood bag.<br>
     */
    BLOOD_BAG_L1("BBL",
                 "2.16.840.1.113883.5.129",
                 "Blood bag",
                 "Blood bag",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Blood capillary.<br>
     */
    BLOOD_CAPILLARY_L1("BLDC",
                       "2.16.840.1.113883.5.129",
                       "Blood capillary",
                       "Blood capillary",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Blood - cord.<br>
     */
    BLOOD_CORD_L1("BLDCO",
                  "2.16.840.1.113883.5.129",
                  "Blood - cord",
                  "Blood - cord",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Blood Product.<br>
     */
    BLOOD_PRODUCT("BLDPRD",
                  "2.16.840.1.113883.5.1060",
                  "Blood Product",
                  "Blood Product",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Blood Product.<br>
     */
    BLOOD_PRODUCT_L1("BLDPRD",
                     "2.16.840.1.113883.5.1060",
                     "Blood Product",
                     "Blood Product",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Blood product unit.<br>
     */
    BLOOD_PRODUCT_UNIT_L1("BPU",
                          "2.16.840.1.113883.5.129",
                          "Blood product unit",
                          "Blood product unit",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Blood venous.<br>
     */
    BLOOD_VENOUS_L1("BLDV",
                    "2.16.840.1.113883.5.129",
                    "Blood venous",
                    "Blood venous",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Body fluid, unsp.<br>
     */
    BODY_FLUID_UNSP_L1("FLU",
                       "2.16.840.1.113883.5.129",
                       "Body fluid, unsp",
                       "Body fluid, unsp",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Bone.<br>
     */
    BONE_L1("BON",
            "2.16.840.1.113883.5.129",
            "Bone",
            "Bone",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Boric Acid.<br>
     */
    BORIC_ACID_L1("BOR",
                  "2.16.840.1.113883.5.1060",
                  "Boric Acid",
                  "Boric Acid",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Boric Acid.<br>
     */
    BORIC_ACID_L2("BOR",
                  "2.16.840.1.113883.5.1060",
                  "Boric Acid",
                  "Boric Acid",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Bottle.<br>
     */
    BOTTLE_L4("BOT",
              "2.16.840.1.113883.5.1060",
              "Bottle",
              "Bottle",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Bottle.<br>
     */
    BOTTLE_L5("BOT",
              "2.16.840.1.113883.5.1060",
              "Bottle",
              "Bottle",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Bouin's solution.<br>
     */
    BOUIN_S_SOLUTION_L1("BOUIN",
                        "2.16.840.1.113883.5.1060",
                        "Bouin's solution",
                        "Bouin's solution",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Bouin's solution.<br>
     */
    BOUIN_S_SOLUTION_L2("BOUIN",
                        "2.16.840.1.113883.5.1060",
                        "Bouin's solution",
                        "Bouin's solution",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Box.<br>
     */
    BOX_L4("BOX",
           "2.16.840.1.113883.5.1060",
           "Box",
           "Box",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Box.<br>
     */
    BOX_L5("BOX",
           "2.16.840.1.113883.5.1060",
           "Box",
           "Box",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Breast milk.<br>
     */
    BREAST_MILK_L1("MILK",
                   "2.16.840.1.113883.5.129",
                   "Breast milk",
                   "Breast milk",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Bronchial.<br>
     */
    BRONCHIAL_L1("BRO",
                 "2.16.840.1.113883.5.129",
                 "Bronchial",
                 "Bronchial",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Buffered 10% formalin.<br>
     */
    BUFFERED_10PERCENT_FORMALIN_L1("BF10",
                                   "2.16.840.1.113883.5.1060",
                                   "Buffered 10% formalin",
                                   "Buffered 10% formalin",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Buffered 10% formalin.<br>
     */
    BUFFERED_10PERCENT_FORMALIN_L2("BF10",
                                   "2.16.840.1.113883.5.1060",
                                   "Buffered 10% formalin",
                                   "Buffered 10% formalin",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Buffered Citrate.<br>
     */
    BUFFERED_CITRATE_L1("WEST",
                        "2.16.840.1.113883.5.1060",
                        "Buffered Citrate",
                        "Buffered Citrate",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Buffered Citrate.<br>
     */
    BUFFERED_CITRATE_L2("WEST",
                        "2.16.840.1.113883.5.1060",
                        "Buffered Citrate",
                        "Buffered Citrate",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Buffered skim milk.<br>
     */
    BUFFERED_SKIM_MILK_L1("BSKM",
                          "2.16.840.1.113883.5.1060",
                          "Buffered skim milk",
                          "Buffered skim milk",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Buffered skim milk.<br>
     */
    BUFFERED_SKIM_MILK_L2("BSKM",
                          "2.16.840.1.113883.5.1060",
                          "Buffered skim milk",
                          "Buffered skim milk",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Building Location.<br>
     */
    BUILDING_LOCATION_L1("BLDG",
                         "2.16.840.1.113883.5.1060",
                         "Building Location",
                         "Building Location",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Burn.<br>
     */
    BURN_L1("BRN",
            "2.16.840.1.113883.5.129",
            "Burn",
            "Burn",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Calculus (=Stone) Stone (use CALC).<br>
     */
    CALCULUS_STONE_STONE_USE_CALC_L1("CALC",
                                     "2.16.840.1.113883.5.129",
                                     "Calculus (=Stone) Stone (use CALC)",
                                     "Calculus (=Stone) Stone (use CALC)",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: Canister.<br>
     */
    CANISTER_L4("CNSTR",
                "2.16.840.1.113883.5.1060",
                "Canister",
                "Canister",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Canister.<br>
     */
    CANISTER_L5("CNSTR",
                "2.16.840.1.113883.5.1060",
                "Canister",
                "Canister",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Cannula.<br>
     */
    CANNULA_L1("CNL",
               "2.16.840.1.113883.5.129",
               "Cannula",
               "Cannula",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Can.<br>
     */
    CAN_L4("CAN",
           "2.16.840.1.113883.5.1060",
           "Can",
           "Can",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Can.<br>
     */
    CAN_L5("CAN",
           "2.16.840.1.113883.5.1060",
           "Can",
           "Can",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Cardiac muscle.<br>
     */
    CARDIAC_MUSCLE_L1("CDM",
                      "2.16.840.1.113883.5.129",
                      "Cardiac muscle",
                      "Cardiac muscle",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Card.<br>
     */
    CARD_L4("CARD",
            "2.16.840.1.113883.5.1060",
            "Card",
            "Card",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Card.<br>
     */
    CARD_L5("CARD",
            "2.16.840.1.113883.5.1060",
            "Card",
            "Card",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Carson's Modified 10% formalin.<br>
     */
    CARSON_S_MODIFIED_10PERCENT_FORMALIN_L1("CARS",
                                            "2.16.840.1.113883.5.1060",
                                            "Carson's Modified 10% formalin",
                                            "Carson's Modified 10% formalin",
                                            "TOTRANSLATE",
                                            "TOTRANSLATE",
                                            "TOTRANSLATE"),
    /**
     * EN: Carson's Modified 10% formalin.<br>
     */
    CARSON_S_MODIFIED_10PERCENT_FORMALIN_L2("CARS",
                                            "2.16.840.1.113883.5.1060",
                                            "Carson's Modified 10% formalin",
                                            "Carson's Modified 10% formalin",
                                            "TOTRANSLATE",
                                            "TOTRANSLATE",
                                            "TOTRANSLATE"),
    /**
     * EN: Cartridge.<br>
     */
    CARTRIDGE_L4("CART",
                 "2.16.840.1.113883.5.1060",
                 "Cartridge",
                 "Cartridge",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Cartridge.<br>
     */
    CARTRIDGE_L5("CART",
                 "2.16.840.1.113883.5.1060",
                 "Cartridge",
                 "Cartridge",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Cary Blair Medium.<br>
     */
    CARY_BLAIR_MEDIUM_L1("CARY",
                         "2.16.840.1.113883.5.1060",
                         "Cary Blair Medium",
                         "Cary Blair Medium",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Cary Blair Medium.<br>
     */
    CARY_BLAIR_MEDIUM_L2("CARY",
                         "2.16.840.1.113883.5.1060",
                         "Cary Blair Medium",
                         "Cary Blair Medium",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Catheter tip.<br>
     */
    CATHETER_TIP_L1("CTP",
                    "2.16.840.1.113883.5.129",
                    "Catheter tip",
                    "Catheter tip",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Cerebral spinal fluid.<br>
     */
    CEREBRAL_SPINAL_FLUID_L1("CSF",
                             "2.16.840.1.113883.5.129",
                             "Cerebral spinal fluid",
                             "Cerebral spinal fluid",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Cervical mucus.<br>
     */
    CERVICAL_MUCUS_L1("CVM",
                      "2.16.840.1.113883.5.129",
                      "Cervical mucus",
                      "Cervical mucus",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Cervix.<br>
     */
    CERVIX_L1("CVX",
              "2.16.840.1.113883.5.129",
              "Cervix",
              "Cervix",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Chlamydia transport medium.<br>
     */
    CHLAMYDIA_TRANSPORT_MEDIUM_L1("CHLTM",
                                  "2.16.840.1.113883.5.1060",
                                  "Chlamydia transport medium",
                                  "Chlamydia transport medium",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Chlamydia transport medium.<br>
     */
    CHLAMYDIA_TRANSPORT_MEDIUM_L2("CHLTM",
                                  "2.16.840.1.113883.5.1060",
                                  "Chlamydia transport medium",
                                  "Chlamydia transport medium",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Colostrum.<br>
     */
    COLOSTRUM_L1("COL",
                 "2.16.840.1.113883.5.129",
                 "Colostrum",
                 "Colostrum",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Compliance Package.<br>
     */
    COMPLIANCE_PACKAGE_L2("COMPPKG",
                          "2.16.840.1.113883.5.1060",
                          "Compliance Package",
                          "Compliance Package",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Compliance Package.<br>
     */
    COMPLIANCE_PACKAGE_L3("COMPPKG",
                          "2.16.840.1.113883.5.1060",
                          "Compliance Package",
                          "Compliance Package",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Conjunctiva.<br>
     */
    CONJUNCTIVA_L1("CNJT",
                   "2.16.840.1.113883.5.129",
                   "Conjunctiva",
                   "Conjunctiva",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: ContainerEntityType.<br>
     */
    CONTAINERENTITYTYPE_L1("_ContainerEntityType",
                           "2.16.840.1.113883.5.1060",
                           "ContainerEntityType",
                           "ContainerEntityType",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Cornea.<br>
     */
    CORNEA_L1("CRN",
              "2.16.840.1.113883.5.129",
              "Cornea",
              "Cornea",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: CTAD.<br>
     */
    CTAD_L1("CTAD",
            "2.16.840.1.113883.5.1060",
            "CTAD",
            "CTAD",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: CTAD.<br>
     */
    CTAD_L2("CTAD",
            "2.16.840.1.113883.5.1060",
            "CTAD",
            "CTAD",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Curettage.<br>
     */
    CURETTAGE_L1("CUR",
                 "2.16.840.1.113883.5.129",
                 "Curettage",
                 "Curettage",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Cyst.<br>
     */
    CYST_L1("CYST",
            "2.16.840.1.113883.5.129",
            "Cyst",
            "Cyst",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dialysis fluid.<br>
     */
    DIALYSIS_FLUID_L1("DIAF",
                      "2.16.840.1.113883.5.129",
                      "Dialysis fluid",
                      "Dialysis fluid",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Dial Pack.<br>
     */
    DIAL_PACK_L3("DIALPK",
                 "2.16.840.1.113883.5.1060",
                 "Dial Pack",
                 "Dial Pack",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Dial Pack.<br>
     */
    DIAL_PACK_L4("DIALPK",
                 "2.16.840.1.113883.5.1060",
                 "Dial Pack",
                 "Dial Pack",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Diskhaler.<br>
     */
    DISKHALER_L3("DSKUNH",
                 "2.16.840.1.113883.5.1060",
                 "Diskhaler",
                 "Diskhaler",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Diskhaler.<br>
     */
    DISKHALER_L4("DSKUNH",
                 "2.16.840.1.113883.5.1060",
                 "Diskhaler",
                 "Diskhaler",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Diskus.<br>
     */
    DISKUS_L3("DSKS",
              "2.16.840.1.113883.5.1060",
              "Diskus",
              "Diskus",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Diskus.<br>
     */
    DISKUS_L4("DSKS",
              "2.16.840.1.113883.5.1060",
              "Diskus",
              "Diskus",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Disk.<br>
     */
    DISK_L3("DISK",
            "2.16.840.1.113883.5.1060",
            "Disk",
            "Disk",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Disk.<br>
     */
    DISK_L4("DISK",
            "2.16.840.1.113883.5.1060",
            "Disk",
            "Disk",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosette.<br>
     */
    DOSETTE_L3("DOSET",
               "2.16.840.1.113883.5.1060",
               "Dosette",
               "Dosette",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Dosette.<br>
     */
    DOSETTE_L4("DOSET",
               "2.16.840.1.113883.5.1060",
               "Dosette",
               "Dosette",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Dose med or substance.<br>
     */
    DOSE_MED_OR_SUBSTANCE_L1("DOSE",
                             "2.16.840.1.113883.5.129",
                             "Dose med or substance",
                             "Dose med or substance",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Drain.<br>
     */
    DRAIN_L1("DRN",
             "2.16.840.1.113883.5.129",
             "Drain",
             "Drain",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Dropper Bottle.<br>
     */
    DROPPER_BOTTLE_L5("BOTD",
                      "2.16.840.1.113883.5.1060",
                      "Dropper Bottle",
                      "Dropper Bottle",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Dropper Bottle.<br>
     */
    DROPPER_BOTTLE_L6("BOTD",
                      "2.16.840.1.113883.5.1060",
                      "Dropper Bottle",
                      "Dropper Bottle",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Duodenal fluid.<br>
     */
    DUODENAL_FLUID_L1("DUFL",
                      "2.16.840.1.113883.5.129",
                      "Duodenal fluid",
                      "Duodenal fluid",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Ear.<br>
     */
    EAR_L1("EAR",
           "2.16.840.1.113883.5.129",
           "Ear",
           "Ear",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Ear wax (cerumen).<br>
     */
    EAR_WAX_CERUMEN_L1("EARW",
                       "2.16.840.1.113883.5.129",
                       "Ear wax (cerumen)",
                       "Ear wax (cerumen)",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Electrode.<br>
     */
    ELECTRODE_L1("ELT",
                 "2.16.840.1.113883.5.129",
                 "Electrode",
                 "Electrode",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Endocardium.<br>
     */
    ENDOCARDIUM_L1("ENDC",
                   "2.16.840.1.113883.5.129",
                   "Endocardium",
                   "Endocardium",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Endometrium.<br>
     */
    ENDOMETRIUM_L1("ENDM",
                   "2.16.840.1.113883.5.129",
                   "Endometrium",
                   "Endometrium",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Enteric bacteria transport medium.<br>
     */
    ENTERIC_BACTERIA_TRANSPORT_MEDIUM_L1("ENT",
                                         "2.16.840.1.113883.5.1060",
                                         "Enteric bacteria transport medium",
                                         "Enteric bacteria transport medium",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Enteric bacteria transport medium.<br>
     */
    ENTERIC_BACTERIA_TRANSPORT_MEDIUM_L2("ENT",
                                         "2.16.840.1.113883.5.1060",
                                         "Enteric bacteria transport medium",
                                         "Enteric bacteria transport medium",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Eosinophils.<br>
     */
    EOSINOPHILS_L1("EOS",
                   "2.16.840.1.113883.5.129",
                   "Eosinophils",
                   "Eosinophils",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Erythrocytes.<br>
     */
    ERYTHROCYTES_L1("RBC",
                    "2.16.840.1.113883.5.129",
                    "Erythrocytes",
                    "Erythrocytes",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Exhaled gas (=breath) Breath (use EXG).<br>
     */
    EXHALED_GAS_BREATH_BREATH_USE_EXG_L1("BRTH",
                                         "2.16.840.1.113883.5.129",
                                         "Exhaled gas (=breath) Breath (use EXG)",
                                         "Exhaled gas (=breath) Breath (use EXG)",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Eye.<br>
     */
    EYE_L1("EYE",
           "2.16.840.1.113883.5.129",
           "Eye",
           "Eye",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Fibroblasts.<br>
     */
    FIBROBLASTS_L1("FIB",
                   "2.16.840.1.113883.5.129",
                   "Fibroblasts",
                   "Fibroblasts",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Filter.<br>
     */
    FILTER_L1("FLT",
              "2.16.840.1.113883.5.129",
              "Filter",
              "Filter",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Fistula.<br>
     */
    FISTULA_L1("FIST",
               "2.16.840.1.113883.5.129",
               "Fistula",
               "Fistula",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Floor Location.<br>
     */
    FLOOR_LOCATION_L1("FLOOR",
                      "2.16.840.1.113883.5.1060",
                      "Floor Location",
                      "Floor Location",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Food sample.<br>
     */
    FOOD_SAMPLE_L1("FOOD",
                   "2.16.840.1.113883.5.129",
                   "Food sample",
                   "Food sample",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Gastric fluid/contents.<br>
     */
    GASTRIC_FLUID_CONTENTS_L1("GAST",
                              "2.16.840.1.113883.5.129",
                              "Gastric fluid/contents",
                              "Gastric fluid/contents",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Gas.<br>
     */
    GAS_L1("GAS",
           "2.16.840.1.113883.5.129",
           "Gas",
           "Gas",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Genital cervix.<br>
     */
    GENITAL_CERVIX_L1("GENC",
                      "2.16.840.1.113883.5.129",
                      "Genital cervix",
                      "Genital cervix",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Genital fluid.<br>
     */
    GENITAL_FLUID_L1("GENF",
                     "2.16.840.1.113883.5.129",
                     "Genital fluid",
                     "Genital fluid",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Genital.<br>
     */
    GENITAL_L1("GEN",
               "2.16.840.1.113883.5.129",
               "Genital",
               "Genital",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Genital lochia.<br>
     */
    GENITAL_LOCHIA_L1("GENL",
                      "2.16.840.1.113883.5.129",
                      "Genital lochia",
                      "Genital lochia",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Genital vaginal.<br>
     */
    GENITAL_VAGINAL_L1("GENV",
                       "2.16.840.1.113883.5.129",
                       "Genital vaginal",
                       "Genital vaginal",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Glass Bottle.<br>
     */
    GLASS_BOTTLE_L5("BOTG",
                    "2.16.840.1.113883.5.1060",
                    "Glass Bottle",
                    "Glass Bottle",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Glass Bottle.<br>
     */
    GLASS_BOTTLE_L6("BOTG",
                    "2.16.840.1.113883.5.1060",
                    "Glass Bottle",
                    "Glass Bottle",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Hair.<br>
     */
    HAIR_L1("HAR",
            "2.16.840.1.113883.5.129",
            "Hair",
            "Hair",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: household.<br>
     */
    HOUSEHOLD_L1("HHOLD",
                 "2.16.840.1.113883.5.1060",
                 "household",
                 "household",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: IndividualPackageEntityType.<br>
     */
    INDIVIDUALPACKAGEENTITYTYPE_L3("_IndividualPackageEntityType",
                                   "2.16.840.1.113883.5.1060",
                                   "IndividualPackageEntityType",
                                   "IndividualPackageEntityType",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: IndividualPackageEntityType.<br>
     */
    INDIVIDUALPACKAGEENTITYTYPE_L4("_IndividualPackageEntityType",
                                   "2.16.840.1.113883.5.1060",
                                   "IndividualPackageEntityType",
                                   "IndividualPackageEntityType",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Inhaled Gas.<br>
     */
    INHALED_GAS_L1("IHG",
                   "2.16.840.1.113883.5.129",
                   "Inhaled Gas",
                   "Inhaled Gas",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Inhaler.<br>
     */
    INHALER_L2("INH",
               "2.16.840.1.113883.5.1060",
               "Inhaler",
               "Inhaler",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Inhaler.<br>
     */
    INHALER_L3("INH",
               "2.16.840.1.113883.5.1060",
               "Inhaler",
               "Inhaler",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: InjectionMedicalDevice.<br>
     */
    INJECTIONMEDICALDEVICE_L2("_InjectionMedicalDevice",
                              "2.16.840.1.113883.5.1060",
                              "InjectionMedicalDevice",
                              "InjectionMedicalDevice",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: InjectionMedicalDevice.<br>
     */
    INJECTIONMEDICALDEVICE_L3("_InjectionMedicalDevice",
                              "2.16.840.1.113883.5.1060",
                              "InjectionMedicalDevice",
                              "InjectionMedicalDevice",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Intraveneous Line.<br>
     */
    INTRAVENEOUS_LINE_L3("IVLINE",
                         "2.16.840.1.113883.5.1060",
                         "Intraveneous Line",
                         "Intraveneous Line",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Intraveneous Line.<br>
     */
    INTRAVENEOUS_LINE_L4("IVLINE",
                         "2.16.840.1.113883.5.1060",
                         "Intraveneous Line",
                         "Intraveneous Line",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Intra-arterial Line.<br>
     */
    INTRA_ARTERIAL_LINE_L3("IALINE",
                           "2.16.840.1.113883.5.1060",
                           "Intra-arterial Line",
                           "Intra-arterial Line",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Intra-arterial Line.<br>
     */
    INTRA_ARTERIAL_LINE_L4("IALINE",
                           "2.16.840.1.113883.5.1060",
                           "Intra-arterial Line",
                           "Intra-arterial Line",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Intubation tube.<br>
     */
    INTUBATION_TUBE_L1("IT",
                       "2.16.840.1.113883.5.129",
                       "Intubation tube",
                       "Intubation tube",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Isolate.<br>
     */
    ISOLATE_L1("ISLT",
               "2.16.840.1.113883.5.129",
               "Isolate",
               "Isolate",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Jar.<br>
     */
    JAR_L4("JAR",
           "2.16.840.1.113883.5.1060",
           "Jar",
           "Jar",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Jar.<br>
     */
    JAR_L5("JAR",
           "2.16.840.1.113883.5.1060",
           "Jar",
           "Jar",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Jones Kendrick Medium.<br>
     */
    JONES_KENDRICK_MEDIUM_L1("JKM",
                             "2.16.840.1.113883.5.1060",
                             "Jones Kendrick Medium",
                             "Jones Kendrick Medium",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Jones Kendrick Medium.<br>
     */
    JONES_KENDRICK_MEDIUM_L2("JKM",
                             "2.16.840.1.113883.5.1060",
                             "Jones Kendrick Medium",
                             "Jones Kendrick Medium",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Jug.<br>
     */
    JUG_L4("JUG",
           "2.16.840.1.113883.5.1060",
           "Jug",
           "Jug",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Jug.<br>
     */
    JUG_L5("JUG",
           "2.16.840.1.113883.5.1060",
           "Jug",
           "Jug",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Karnovsky's fixative.<br>
     */
    KARNOVSKY_S_FIXATIVE_L1("KARN",
                            "2.16.840.1.113883.5.1060",
                            "Karnovsky's fixative",
                            "Karnovsky's fixative",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Karnovsky's fixative.<br>
     */
    KARNOVSKY_S_FIXATIVE_L2("KARN",
                            "2.16.840.1.113883.5.1060",
                            "Karnovsky's fixative",
                            "Karnovsky's fixative",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Kit.<br>
     */
    KIT_L2("KIT",
           "2.16.840.1.113883.5.1060",
           "Kit",
           "Kit",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Kit.<br>
     */
    KIT_L3("KIT",
           "2.16.840.1.113883.5.1060",
           "Kit",
           "Kit",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Lamella.<br>
     */
    LAMELLA_L1("LAM",
               "2.16.840.1.113883.5.129",
               "Lamella",
               "Lamella",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Leukocytes.<br>
     */
    LEUKOCYTES_L1("WBC",
                  "2.16.840.1.113883.5.129",
                  "Leukocytes",
                  "Leukocytes",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Line arterial.<br>
     */
    LINE_ARTERIAL_L1("LNA",
                     "2.16.840.1.113883.5.129",
                     "Line arterial",
                     "Line arterial",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Line.<br>
     */
    LINE_L1("LN",
            "2.16.840.1.113883.5.129",
            "Line",
            "Line",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Line.<br>
     */
    LINE_L2("LINE",
            "2.16.840.1.113883.5.1060",
            "Line",
            "Line",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Line.<br>
     */
    LINE_L3("LINE",
            "2.16.840.1.113883.5.1060",
            "Line",
            "Line",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Line venous.<br>
     */
    LINE_VENOUS_L1("LNV",
                   "2.16.840.1.113883.5.129",
                   "Line venous",
                   "Line venous",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Liquid NOS.<br>
     */
    LIQUID_NOS_L1("LIQ",
                  "2.16.840.1.113883.5.129",
                  "Liquid NOS",
                  "Liquid NOS",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Lithium iodoacetate.<br>
     */
    LITHIUM_IODOACETATE_L1("LIA",
                           "2.16.840.1.113883.5.1060",
                           "Lithium iodoacetate",
                           "Lithium iodoacetate",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Lithium iodoacetate.<br>
     */
    LITHIUM_IODOACETATE_L2("LIA",
                           "2.16.840.1.113883.5.1060",
                           "Lithium iodoacetate",
                           "Lithium iodoacetate",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Lithium/Li Heparin.<br>
     */
    LITHIUM_LI_HEPARIN_L1("HEPL",
                          "2.16.840.1.113883.5.1060",
                          "Lithium/Li Heparin",
                          "Lithium/Li Heparin",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Lithium/Li Heparin.<br>
     */
    LITHIUM_LI_HEPARIN_L2("HEPL",
                          "2.16.840.1.113883.5.1060",
                          "Lithium/Li Heparin",
                          "Lithium/Li Heparin",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Lymphocytes.<br>
     */
    LYMPHOCYTES_L1("LYM",
                   "2.16.840.1.113883.5.129",
                   "Lymphocytes",
                   "Lymphocytes",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: M4.<br>
     */
    M4_L1("M4",
          "2.16.840.1.113883.5.1060",
          "M4",
          "M4",
          "TOTRANSLATE",
          "TOTRANSLATE",
          "TOTRANSLATE"),
    /**
     * EN: M4.<br>
     */
    M4_L2("M4",
          "2.16.840.1.113883.5.1060",
          "M4",
          "M4",
          "TOTRANSLATE",
          "TOTRANSLATE",
          "TOTRANSLATE"),
    /**
     * EN: M4-RT.<br>
     */
    M4_RT_L1("M4RT",
             "2.16.840.1.113883.5.1060",
             "M4-RT",
             "M4-RT",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: M4-RT.<br>
     */
    M4_RT_L2("M4RT",
             "2.16.840.1.113883.5.1060",
             "M4-RT",
             "M4-RT",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: M5.<br>
     */
    M5_L1("M5",
          "2.16.840.1.113883.5.1060",
          "M5",
          "M5",
          "TOTRANSLATE",
          "TOTRANSLATE",
          "TOTRANSLATE"),
    /**
     * EN: M5.<br>
     */
    M5_L2("M5",
          "2.16.840.1.113883.5.1060",
          "M5",
          "M5",
          "TOTRANSLATE",
          "TOTRANSLATE",
          "TOTRANSLATE"),
    /**
     * EN: Macrophages.<br>
     */
    MACROPHAGES_L1("MAC",
                   "2.16.840.1.113883.5.129",
                   "Macrophages",
                   "Macrophages",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Marrow (bone).<br>
     */
    MARROW_BONE_L1("MAR",
                   "2.16.840.1.113883.5.129",
                   "Marrow (bone)",
                   "Marrow (bone)",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Meconium.<br>
     */
    MECONIUM_L1("MEC",
                "2.16.840.1.113883.5.129",
                "Meconium",
                "Meconium",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: MedicalDevice.<br>
     */
    MEDICALDEVICE_L1("_MedicalDevice",
                     "2.16.840.1.113883.5.1060",
                     "MedicalDevice",
                     "MedicalDevice",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Menstrual blood.<br>
     */
    MENSTRUAL_BLOOD_L1("MBLD",
                       "2.16.840.1.113883.5.129",
                       "Menstrual blood",
                       "Menstrual blood",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Michel's transport medium.<br>
     */
    MICHEL_S_TRANSPORT_MEDIUM_L1("MICHTM",
                                 "2.16.840.1.113883.5.1060",
                                 "Michel's transport medium",
                                 "Michel's transport medium",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: Michel's transport medium.<br>
     */
    MICHEL_S_TRANSPORT_MEDIUM_L2("MICHTM",
                                 "2.16.840.1.113883.5.1060",
                                 "Michel's transport medium",
                                 "Michel's transport medium",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: Milk.<br>
     */
    MILK_L1("MLK",
            "2.16.840.1.113883.5.129",
            "Milk",
            "Milk",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Minim.<br>
     */
    MINIM_L4("MINIM",
             "2.16.840.1.113883.5.1060",
             "Minim",
             "Minim",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Minim.<br>
     */
    MINIM_L5("MINIM",
             "2.16.840.1.113883.5.1060",
             "Minim",
             "Minim",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: MMD transport medium.<br>
     */
    MMD_TRANSPORT_MEDIUM_L1("MMDTM",
                            "2.16.840.1.113883.5.1060",
                            "MMD transport medium",
                            "MMD transport medium",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: MMD transport medium.<br>
     */
    MMD_TRANSPORT_MEDIUM_L2("MMDTM",
                            "2.16.840.1.113883.5.1060",
                            "MMD transport medium",
                            "MMD transport medium",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: MultiUseContainerEntityType.<br>
     */
    MULTIUSECONTAINERENTITYTYPE_L3("_MultiUseContainerEntityType",
                                   "2.16.840.1.113883.5.1060",
                                   "MultiUseContainerEntityType",
                                   "MultiUseContainerEntityType",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: MultiUseContainerEntityType.<br>
     */
    MULTIUSECONTAINERENTITYTYPE_L4("_MultiUseContainerEntityType",
                                   "2.16.840.1.113883.5.1060",
                                   "MultiUseContainerEntityType",
                                   "MultiUseContainerEntityType",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Nail.<br>
     */
    NAIL_L1("NAIL",
            "2.16.840.1.113883.5.129",
            "Nail",
            "Nail",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: NationEntityType.<br>
     */
    NATIONENTITYTYPE_L1("NAT",
                        "2.16.840.1.113883.5.1060",
                        "NationEntityType",
                        "NationEntityType",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Nebuamp.<br>
     */
    NEBUAMP_L4("NEBAMP",
               "2.16.840.1.113883.5.1060",
               "Nebuamp",
               "Nebuamp",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Nebuamp.<br>
     */
    NEBUAMP_L5("NEBAMP",
               "2.16.840.1.113883.5.1060",
               "Nebuamp",
               "Nebuamp",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Nitric Acid.<br>
     */
    NITRIC_ACID_L1("HNO3",
                   "2.16.840.1.113883.5.1060",
                   "Nitric Acid",
                   "Nitric Acid",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Nitric Acid.<br>
     */
    NITRIC_ACID_L2("HNO3",
                   "2.16.840.1.113883.5.1060",
                   "Nitric Acid",
                   "Nitric Acid",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: None.<br>
     */
    NONE_L1("NONE",
            "2.16.840.1.113883.5.1060",
            "None",
            "None",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: None.<br>
     */
    NONE_L2("NONE",
            "2.16.840.1.113883.5.1060",
            "None",
            "None",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: NonRigidContainerEntityType.<br>
     */
    NONRIGIDCONTAINERENTITYTYPE_L2("_NonRigidContainerEntityType",
                                   "2.16.840.1.113883.5.1060",
                                   "NonRigidContainerEntityType",
                                   "NonRigidContainerEntityType",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: NonRigidContainerEntityType.<br>
     */
    NONRIGIDCONTAINERENTITYTYPE_L3("_NonRigidContainerEntityType",
                                   "2.16.840.1.113883.5.1060",
                                   "NonRigidContainerEntityType",
                                   "NonRigidContainerEntityType",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Nose (nasal passage).<br>
     */
    NOSE_NASAL_PASSAGE_L1("NOS",
                          "2.16.840.1.113883.5.129",
                          "Nose (nasal passage)",
                          "Nose (nasal passage)",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: 10% Formalin.<br>
     */
    ONE_PERCENT_FORMALIN_L1("F10",
                            "2.16.840.1.113883.5.1060",
                            "10% Formalin",
                            "10% Formalin",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: 10% Formalin.<br>
     */
    ONE_PERCENT_FORMALIN_L2("F10",
                            "2.16.840.1.113883.5.1060",
                            "10% Formalin",
                            "10% Formalin",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: OrganizationEntityType.<br>
     */
    ORGANIZATIONENTITYTYPE("_OrganizationEntityType",
                           "2.16.840.1.113883.5.1060",
                           "OrganizationEntityType",
                           "OrganizationEntityType",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Ovule.<br>
     */
    OVULE_L4("OVUL",
             "2.16.840.1.113883.5.1060",
             "Ovule",
             "Ovule",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Ovule.<br>
     */
    OVULE_L5("OVUL",
             "2.16.840.1.113883.5.1060",
             "Ovule",
             "Ovule",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Package.<br>
     */
    PACKAGE_L1("PKG",
               "2.16.840.1.113883.5.1060",
               "Package",
               "Package",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Package.<br>
     */
    PACKAGE_L2("PKG",
               "2.16.840.1.113883.5.1060",
               "Package",
               "Package",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Packet.<br>
     */
    PACKET_L3("PACKT",
              "2.16.840.1.113883.5.1060",
              "Packet",
              "Packet",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Packet.<br>
     */
    PACKET_L4("PACKT",
              "2.16.840.1.113883.5.1060",
              "Packet",
              "Packet",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Page's Saline.<br>
     */
    PAGE_S_SALINE_L1("PAGE",
                     "2.16.840.1.113883.5.1060",
                     "Page's Saline",
                     "Page's Saline",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Page's Saline.<br>
     */
    PAGE_S_SALINE_L2("PAGE",
                     "2.16.840.1.113883.5.1060",
                     "Page's Saline",
                     "Page's Saline",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Pancreatic fluid.<br>
     */
    PANCREATIC_FLUID_L1("PAFL",
                        "2.16.840.1.113883.5.129",
                        "Pancreatic fluid",
                        "Pancreatic fluid",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Patient.<br>
     */
    PATIENT_L1("PAT",
               "2.16.840.1.113883.5.129",
               "Patient",
               "Patient",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Pen.<br>
     */
    PEN_L3("PEN",
           "2.16.840.1.113883.5.1060",
           "Pen",
           "Pen",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Pen.<br>
     */
    PEN_L4("PEN",
           "2.16.840.1.113883.5.1060",
           "Pen",
           "Pen",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Peritoneal fluid /ascites.<br>
     */
    PERITONEAL_FLUID_ASCITES_L1("PRT",
                                "2.16.840.1.113883.5.129",
                                "Peritoneal fluid /ascites",
                                "Peritoneal fluid /ascites",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: Phenol.<br>
     */
    PHENOL_L1("PHENOL",
              "2.16.840.1.113883.5.1060",
              "Phenol",
              "Phenol",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Phenol.<br>
     */
    PHENOL_L2("PHENOL",
              "2.16.840.1.113883.5.1060",
              "Phenol",
              "Phenol",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Placenta.<br>
     */
    PLACENTA_L1("PLC",
                "2.16.840.1.113883.5.129",
                "Placenta",
                "Placenta",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Plasma bag.<br>
     */
    PLASMA_BAG_L1("PLB",
                  "2.16.840.1.113883.5.129",
                  "Plasma bag",
                  "Plasma bag",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Plasma.<br>
     */
    PLASMA_L1("PLAS",
              "2.16.840.1.113883.5.129",
              "Plasma",
              "Plasma",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Plastic Bottle.<br>
     */
    PLASTIC_BOTTLE_L5("BOTP",
                      "2.16.840.1.113883.5.1060",
                      "Plastic Bottle",
                      "Plastic Bottle",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Plastic Bottle.<br>
     */
    PLASTIC_BOTTLE_L6("BOTP",
                      "2.16.840.1.113883.5.1060",
                      "Plastic Bottle",
                      "Plastic Bottle",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Platelet poor plasma.<br>
     */
    PLATELET_POOR_PLASMA_L1("PPP",
                            "2.16.840.1.113883.5.129",
                            "Platelet poor plasma",
                            "Platelet poor plasma",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Platelet rich plasma.<br>
     */
    PLATELET_RICH_PLASMA_L1("PRP",
                            "2.16.840.1.113883.5.129",
                            "Platelet rich plasma",
                            "Platelet rich plasma",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Pleural fluid (thoracentesis fld).<br>
     */
    PLEURAL_FLUID_THORACENTESIS_FLD_L1("PLR",
                                       "2.16.840.1.113883.5.129",
                                       "Pleural fluid (thoracentesis fld)",
                                       "Pleural fluid (thoracentesis fld)",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE"),
    /**
     * EN: Polyethylene Bottle.<br>
     */
    POLYETHYLENE_BOTTLE_L6("BOTPLY",
                           "2.16.840.1.113883.5.1060",
                           "Polyethylene Bottle",
                           "Polyethylene Bottle",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Polyethylene Bottle.<br>
     */
    POLYETHYLENE_BOTTLE_L7("BOTPLY",
                           "2.16.840.1.113883.5.1060",
                           "Polyethylene Bottle",
                           "Polyethylene Bottle",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Polymorphonuclear neutrophils.<br>
     */
    POLYMORPHONUCLEAR_NEUTROPHILS_L1("PMN",
                                     "2.16.840.1.113883.5.129",
                                     "Polymorphonuclear neutrophils",
                                     "Polymorphonuclear neutrophils",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: Polyvinylalcohol.<br>
     */
    POLYVINYLALCOHOL_L1("PVA",
                        "2.16.840.1.113883.5.1060",
                        "Polyvinylalcohol",
                        "Polyvinylalcohol",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Polyvinylalcohol.<br>
     */
    POLYVINYLALCOHOL_L2("PVA",
                        "2.16.840.1.113883.5.1060",
                        "Polyvinylalcohol",
                        "Polyvinylalcohol",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Potassium/K EDTA 15%.<br>
     */
    POTASSIUM_K_EDTA_15PERCENT_L1("EDTK15",
                                  "2.16.840.1.113883.5.1060",
                                  "Potassium/K EDTA 15%",
                                  "Potassium/K EDTA 15%",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Potassium/K EDTA 15%.<br>
     */
    POTASSIUM_K_EDTA_15PERCENT_L2("EDTK15",
                                  "2.16.840.1.113883.5.1060",
                                  "Potassium/K EDTA 15%",
                                  "Potassium/K EDTA 15%",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Potassium/K EDTA 7.5%.<br>
     */
    POTASSIUM_K_EDTA_7_5PERCENT_L1("EDTK75",
                                   "2.16.840.1.113883.5.1060",
                                   "Potassium/K EDTA 7.5%",
                                   "Potassium/K EDTA 7.5%",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Potassium/K EDTA 7.5%.<br>
     */
    POTASSIUM_K_EDTA_7_5PERCENT_L2("EDTK75",
                                   "2.16.840.1.113883.5.1060",
                                   "Potassium/K EDTA 7.5%",
                                   "Potassium/K EDTA 7.5%",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Potassium Oxalate.<br>
     */
    POTASSIUM_OXALATE_L1("KOX",
                         "2.16.840.1.113883.5.1060",
                         "Potassium Oxalate",
                         "Potassium Oxalate",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Potassium Oxalate.<br>
     */
    POTASSIUM_OXALATE_L2("KOX",
                         "2.16.840.1.113883.5.1060",
                         "Potassium Oxalate",
                         "Potassium Oxalate",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Pouch.<br>
     */
    POUCH_L3("PCH",
             "2.16.840.1.113883.5.1060",
             "Pouch",
             "Pouch",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Pouch.<br>
     */
    POUCH_L4("PCH",
             "2.16.840.1.113883.5.1060",
             "Pouch",
             "Pouch",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: PractitionerGroup.<br>
     */
    PRACTITIONERGROUP("PRAC",
                      "2.16.840.1.113883.5.1060",
                      "PractitionerGroup",
                      "PractitionerGroup",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Pump.<br>
     */
    PUMP_L2("PMP",
            "2.16.840.1.113883.5.1060",
            "Pump",
            "Pump",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Pump.<br>
     */
    PUMP_L3("PMP",
            "2.16.840.1.113883.5.1060",
            "Pump",
            "Pump",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Pus.<br>
     */
    PUS_L1("PUS",
           "2.16.840.1.113883.5.129",
           "Pus",
           "Pus",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Reagan Lowe Medium.<br>
     */
    REAGAN_LOWE_MEDIUM_L1("RLM",
                          "2.16.840.1.113883.5.1060",
                          "Reagan Lowe Medium",
                          "Reagan Lowe Medium",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Reagan Lowe Medium.<br>
     */
    REAGAN_LOWE_MEDIUM_L2("RLM",
                          "2.16.840.1.113883.5.1060",
                          "Reagan Lowe Medium",
                          "Reagan Lowe Medium",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: religious institution.<br>
     */
    RELIGIOUS_INSTITUTION_L1("RELIG",
                             "2.16.840.1.113883.5.1060",
                             "religious institution",
                             "religious institution",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: RigidContainerEntityType.<br>
     */
    RIGIDCONTAINERENTITYTYPE_L2("_RigidContainerEntityType",
                                "2.16.840.1.113883.5.1060",
                                "RigidContainerEntityType",
                                "RigidContainerEntityType",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: RigidContainerEntityType.<br>
     */
    RIGIDCONTAINERENTITYTYPE_L3("_RigidContainerEntityType",
                                "2.16.840.1.113883.5.1060",
                                "RigidContainerEntityType",
                                "RigidContainerEntityType",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: Room Location.<br>
     */
    ROOM_LOCATION_L1("ROOM",
                     "2.16.840.1.113883.5.1060",
                     "Room Location",
                     "Room Location",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Sachet.<br>
     */
    SACHET_L3("SACH",
              "2.16.840.1.113883.5.1060",
              "Sachet",
              "Sachet",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Sachet.<br>
     */
    SACHET_L4("SACH",
              "2.16.840.1.113883.5.1060",
              "Sachet",
              "Sachet",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Saliva.<br>
     */
    SALIVA_L1("SAL",
              "2.16.840.1.113883.5.129",
              "Saliva",
              "Saliva",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Seminal fluid.<br>
     */
    SEMINAL_FLUID_L1("SMN",
                     "2.16.840.1.113883.5.129",
                     "Seminal fluid",
                     "Seminal fluid",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Seminal plasma.<br>
     */
    SEMINAL_PLASMA_L1("SMPLS",
                      "2.16.840.1.113883.5.129",
                      "Seminal plasma",
                      "Seminal plasma",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Serum.<br>
     */
    SERUM_L1("SER",
             "2.16.840.1.113883.5.129",
             "Serum",
             "Serum",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Serum Separator Tube.<br>
     */
    SERUM_SEPARATOR_TUBE_L1("SST",
                            "2.16.840.1.113883.5.1060",
                            "Serum Separator Tube",
                            "Serum Separator Tube",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Serum Separator Tube.<br>
     */
    SERUM_SEPARATOR_TUBE_L2("SST",
                            "2.16.840.1.113883.5.1060",
                            "Serum Separator Tube",
                            "Serum Separator Tube",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Siliceous earth.<br>
     */
    SILICEOUS_EARTH_L1("SILICA",
                       "2.16.840.1.113883.5.1060",
                       "Siliceous earth",
                       "Siliceous earth",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Siliceous earth.<br>
     */
    SILICEOUS_EARTH_L2("SILICA",
                       "2.16.840.1.113883.5.1060",
                       "Siliceous earth",
                       "Siliceous earth",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: 6N HCL.<br>
     */
    SIX__HCL_L1("HCL6",
                "2.16.840.1.113883.5.1060",
                "6N HCL",
                "6N HCL",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: 6N HCL.<br>
     */
    SIX__HCL_L2("HCL6",
                "2.16.840.1.113883.5.1060",
                "6N HCL",
                "6N HCL",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Skeletal muscle.<br>
     */
    SKELETAL_MUSCLE_L1("SKM",
                       "2.16.840.1.113883.5.129",
                       "Skeletal muscle",
                       "Skeletal muscle",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Skin.<br>
     */
    SKIN_L1("SKN",
            "2.16.840.1.113883.5.129",
            "Skin",
            "Skin",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Sodium Fluoride, 100mg.<br>
     */
    SODIUM_FLUORIDE_100MG_L1("FL100",
                             "2.16.840.1.113883.5.1060",
                             "Sodium Fluoride, 100mg",
                             "Sodium Fluoride, 100mg",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Sodium Fluoride, 100mg.<br>
     */
    SODIUM_FLUORIDE_100MG_L2("FL100",
                             "2.16.840.1.113883.5.1060",
                             "Sodium Fluoride, 100mg",
                             "Sodium Fluoride, 100mg",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Sodium Fluoride, 10mg.<br>
     */
    SODIUM_FLUORIDE_10MG_L1("FL10",
                            "2.16.840.1.113883.5.1060",
                            "Sodium Fluoride, 10mg",
                            "Sodium Fluoride, 10mg",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Sodium Fluoride, 10mg.<br>
     */
    SODIUM_FLUORIDE_10MG_L2("FL10",
                            "2.16.840.1.113883.5.1060",
                            "Sodium Fluoride, 10mg",
                            "Sodium Fluoride, 10mg",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Sodium Fluoride.<br>
     */
    SODIUM_FLUORIDE_L1("NAF",
                       "2.16.840.1.113883.5.1060",
                       "Sodium Fluoride",
                       "Sodium Fluoride",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Sodium Fluoride.<br>
     */
    SODIUM_FLUORIDE_L2("NAF",
                       "2.16.840.1.113883.5.1060",
                       "Sodium Fluoride",
                       "Sodium Fluoride",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Sodium/Na EDTA.<br>
     */
    SODIUM_NA_EDTA_L1("EDTN",
                      "2.16.840.1.113883.5.1060",
                      "Sodium/Na EDTA",
                      "Sodium/Na EDTA",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Sodium/Na EDTA.<br>
     */
    SODIUM_NA_EDTA_L2("EDTN",
                      "2.16.840.1.113883.5.1060",
                      "Sodium/Na EDTA",
                      "Sodium/Na EDTA",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Sodium/Na Heparin.<br>
     */
    SODIUM_NA_HEPARIN_L1("HEPN",
                         "2.16.840.1.113883.5.1060",
                         "Sodium/Na Heparin",
                         "Sodium/Na Heparin",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Sodium/Na Heparin.<br>
     */
    SODIUM_NA_HEPARIN_L2("HEPN",
                         "2.16.840.1.113883.5.1060",
                         "Sodium/Na Heparin",
                         "Sodium/Na Heparin",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Sodium polyanethol sulfonate 0.35% in 0.85% sodium chloride.<br>
     */
    SODIUM_POLYANETHOL_SULFONATE_0_35PERCENT_IN_0_85PERCENT_SODIUM_CHLORIDE_L1("SPS",
                                                                               "2.16.840.1.113883.5.1060",
                                                                               "Sodium polyanethol sulfonate 0.35% in 0.85% sodium chloride",
                                                                               "Sodium polyanethol sulfonate 0.35% in 0.85% sodium chloride",
                                                                               "TOTRANSLATE",
                                                                               "TOTRANSLATE",
                                                                               "TOTRANSLATE"),
    /**
     * EN: Sodium polyanethol sulfonate 0.35% in 0.85% sodium chloride.<br>
     */
    SODIUM_POLYANETHOL_SULFONATE_0_35PERCENT_IN_0_85PERCENT_SODIUM_CHLORIDE_L2("SPS",
                                                                               "2.16.840.1.113883.5.1060",
                                                                               "Sodium polyanethol sulfonate 0.35% in 0.85% sodium chloride",
                                                                               "Sodium polyanethol sulfonate 0.35% in 0.85% sodium chloride",
                                                                               "TOTRANSLATE",
                                                                               "TOTRANSLATE",
                                                                               "TOTRANSLATE"),
    /**
     * EN: SpecimenAdditiveEntity.<br>
     */
    SPECIMENADDITIVEENTITY_L1("_SpecimenAdditiveEntity",
                              "2.16.840.1.113883.5.1060",
                              "SpecimenAdditiveEntity",
                              "SpecimenAdditiveEntity",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Spermatozoa.<br>
     */
    SPERMATOZOA_L1("SPRM",
                   "2.16.840.1.113883.5.129",
                   "Spermatozoa",
                   "Spermatozoa",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Sputum - coughed.<br>
     */
    SPUTUM_COUGHED_L1("SPTC",
                      "2.16.840.1.113883.5.129",
                      "Sputum - coughed",
                      "Sputum - coughed",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Sputum.<br>
     */
    SPUTUM_L1("SPT",
              "2.16.840.1.113883.5.129",
              "Sputum",
              "Sputum",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Sputum - tracheal aspirate.<br>
     */
    SPUTUM_TRACHEAL_ASPIRATE_L1("SPTT",
                                "2.16.840.1.113883.5.129",
                                "Sputum - tracheal aspirate",
                                "Sputum - tracheal aspirate",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: Stool = Fecal.<br>
     */
    STOOL_FECAL_L1("STL",
                   "2.16.840.1.113883.5.129",
                   "Stool = Fecal",
                   "Stool = Fecal",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Strip.<br>
     */
    STRIP_L3("STRIP",
             "2.16.840.1.113883.5.1060",
             "Strip",
             "Strip",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Strip.<br>
     */
    STRIP_L4("STRIP",
             "2.16.840.1.113883.5.1060",
             "Strip",
             "Strip",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Stuart transport medium.<br>
     */
    STUART_TRANSPORT_MEDIUM_L1("STUTM",
                               "2.16.840.1.113883.5.1060",
                               "Stuart transport medium",
                               "Stuart transport medium",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: Stuart transport medium.<br>
     */
    STUART_TRANSPORT_MEDIUM_L2("STUTM",
                               "2.16.840.1.113883.5.1060",
                               "Stuart transport medium",
                               "Stuart transport medium",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: Sweat.<br>
     */
    SWEAT_L1("SWT",
             "2.16.840.1.113883.5.129",
             "Sweat",
             "Sweat",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Synovial fluid (Joint fluid).<br>
     */
    SYNOVIAL_FLUID_JOINT_FLUID_L1("SNV",
                                  "2.16.840.1.113883.5.129",
                                  "Synovial fluid (Joint fluid)",
                                  "Synovial fluid (Joint fluid)",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Syringe.<br>
     */
    SYRINGE_L3("SYR",
               "2.16.840.1.113883.5.1060",
               "Syringe",
               "Syringe",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Syringe.<br>
     */
    SYRINGE_L4("SYR",
               "2.16.840.1.113883.5.1060",
               "Syringe",
               "Syringe",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: System.<br>
     */
    SYSTEM_L3("SYSTM",
              "2.16.840.1.113883.5.1060",
              "System",
              "System",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: System.<br>
     */
    SYSTEM_L4("SYSTM",
              "2.16.840.1.113883.5.1060",
              "System",
              "System",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Tears.<br>
     */
    TEARS_L1("TEAR",
             "2.16.840.1.113883.5.129",
             "Tears",
             "Tears",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: 3.2% Citrate.<br>
     */
    THREE_2PERCENT_CITRATE_L1("C32",
                              "2.16.840.1.113883.5.1060",
                              "3.2% Citrate",
                              "3.2% Citrate",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: 3.2% Citrate.<br>
     */
    THREE_2PERCENT_CITRATE_L2("C32",
                              "2.16.840.1.113883.5.1060",
                              "3.2% Citrate",
                              "3.2% Citrate",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: 3.8% Citrate.<br>
     */
    THREE_8PERCENT_CITRATE_L1("C38",
                              "2.16.840.1.113883.5.1060",
                              "3.8% Citrate",
                              "3.8% Citrate",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: 3.8% Citrate.<br>
     */
    THREE_8PERCENT_CITRATE_L2("C38",
                              "2.16.840.1.113883.5.1060",
                              "3.8% Citrate",
                              "3.8% Citrate",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Throat.<br>
     */
    THROAT_L1("THRT",
              "2.16.840.1.113883.5.129",
              "Throat",
              "Throat",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Thrombin.<br>
     */
    THROMBIN_L1("THROM",
                "2.16.840.1.113883.5.1060",
                "Thrombin",
                "Thrombin",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Thrombin.<br>
     */
    THROMBIN_L2("THROM",
                "2.16.840.1.113883.5.1060",
                "Thrombin",
                "Thrombin",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Thrombin NIH; soybean trypsin inhibitor.<br>
     */
    THROMBIN_NIH_SOYBEAN_TRYPSIN_INHIBITOR_L1("FDP",
                                              "2.16.840.1.113883.5.1060",
                                              "Thrombin NIH; soybean trypsin inhibitor",
                                              "Thrombin NIH; soybean trypsin inhibitor",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE"),
    /**
     * EN: Thrombin NIH; soybean trypsin inhibitor.<br>
     */
    THROMBIN_NIH_SOYBEAN_TRYPSIN_INHIBITOR_L2("FDP",
                                              "2.16.840.1.113883.5.1060",
                                              "Thrombin NIH; soybean trypsin inhibitor",
                                              "Thrombin NIH; soybean trypsin inhibitor",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE"),
    /**
     * EN: Thrombocyte (platelet).<br>
     */
    THROMBOCYTE_PLATELET_L1("THRB",
                            "2.16.840.1.113883.5.129",
                            "Thrombocyte (platelet)",
                            "Thrombocyte (platelet)",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Thymol.<br>
     */
    THYMOL_L1("THYMOL",
              "2.16.840.1.113883.5.1060",
              "Thymol",
              "Thymol",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Thymol.<br>
     */
    THYMOL_L2("THYMOL",
              "2.16.840.1.113883.5.1060",
              "Thymol",
              "Thymol",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Thyoglycolate broth.<br>
     */
    THYOGLYCOLATE_BROTH_L1("THYO",
                           "2.16.840.1.113883.5.1060",
                           "Thyoglycolate broth",
                           "Thyoglycolate broth",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Thyoglycolate broth.<br>
     */
    THYOGLYCOLATE_BROTH_L2("THYO",
                           "2.16.840.1.113883.5.1060",
                           "Thyoglycolate broth",
                           "Thyoglycolate broth",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Tin.<br>
     */
    TIN_L4("TIN",
           "2.16.840.1.113883.5.1060",
           "Tin",
           "Tin",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Tin.<br>
     */
    TIN_L5("TIN",
           "2.16.840.1.113883.5.1060",
           "Tin",
           "Tin",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Tissue gall bladder.<br>
     */
    TISSUE_GALL_BLADDER_L1("TISG",
                           "2.16.840.1.113883.5.129",
                           "Tissue gall bladder",
                           "Tissue gall bladder",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Tissue large intestine.<br>
     */
    TISSUE_LARGE_INTESTINE_L1("TLGI",
                              "2.16.840.1.113883.5.129",
                              "Tissue large intestine",
                              "Tissue large intestine",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Tissue lung.<br>
     */
    TISSUE_LUNG_L1("TLNG",
                   "2.16.840.1.113883.5.129",
                   "Tissue lung",
                   "Tissue lung",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Tissue placenta.<br>
     */
    TISSUE_PLACENTA_L1("TISPL",
                       "2.16.840.1.113883.5.129",
                       "Tissue placenta",
                       "Tissue placenta",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Tissue small intestine Tissue ulcer.<br>
     */
    TISSUE_SMALL_INTESTINE_TISSUE_ULCER_L1("TSMI",
                                           "2.16.840.1.113883.5.129",
                                           "Tissue small intestine Tissue ulcer",
                                           "Tissue small intestine Tissue ulcer",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: Tissue ulcer.<br>
     */
    TISSUE_ULCER_L1("TISU",
                    "2.16.840.1.113883.5.129",
                    "Tissue ulcer",
                    "Tissue ulcer",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Tissue, unspecified.<br>
     */
    TISSUE_UNSPECIFIED_L1("TISS",
                          "2.16.840.1.113883.5.129",
                          "Tissue, unspecified",
                          "Tissue, unspecified",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Toluene.<br>
     */
    TOLUENE_L1("TOLU",
               "2.16.840.1.113883.5.1060",
               "Toluene",
               "Toluene",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Toluene.<br>
     */
    TOLUENE_L2("TOLU",
               "2.16.840.1.113883.5.1060",
               "Toluene",
               "Toluene",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Tube.<br>
     */
    TUBE_L4("TUBE",
            "2.16.840.1.113883.5.1060",
            "Tube",
            "Tube",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Tube.<br>
     */
    TUBE_L5("TUBE",
            "2.16.840.1.113883.5.1060",
            "Tube",
            "Tube",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Tube, unspecified.<br>
     */
    TUBE_UNSPECIFIED_L1("TUB",
                        "2.16.840.1.113883.5.129",
                        "Tube, unspecified",
                        "Tube, unspecified",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Tub.<br>
     */
    TUB_L4("TUB",
           "2.16.840.1.113883.5.1060",
           "Tub",
           "Tub",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Tub.<br>
     */
    TUB_L5("TUB",
           "2.16.840.1.113883.5.1060",
           "Tub",
           "Tub",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Turbuhaler.<br>
     */
    TURBUHALER_L3("TRBINH",
                  "2.16.840.1.113883.5.1060",
                  "Turbuhaler",
                  "Turbuhaler",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Turbuhaler.<br>
     */
    TURBUHALER_L4("TRBINH",
                  "2.16.840.1.113883.5.1060",
                  "Turbuhaler",
                  "Turbuhaler",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Ulcer.<br>
     */
    ULCER_L1("ULC",
             "2.16.840.1.113883.5.129",
             "Ulcer",
             "Ulcer",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Umbilical blood.<br>
     */
    UMBILICAL_BLOOD_L1("UMB",
                       "2.16.840.1.113883.5.129",
                       "Umbilical blood",
                       "Umbilical blood",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Unknown medicine.<br>
     */
    UNKNOWN_MEDICINE_L1("UMED",
                        "2.16.840.1.113883.5.129",
                        "Unknown medicine",
                        "Unknown medicine",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Unknown substance.<br>
     */
    UNKNOWN_SUBSTANCE_L1("USUB",
                         "2.16.840.1.113883.5.129",
                         "Unknown substance",
                         "Unknown substance",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Ureaplasma transport medium.<br>
     */
    UREAPLASMA_TRANSPORT_MEDIUM_L1("URETM",
                                   "2.16.840.1.113883.5.1060",
                                   "Ureaplasma transport medium",
                                   "Ureaplasma transport medium",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Ureaplasma transport medium.<br>
     */
    UREAPLASMA_TRANSPORT_MEDIUM_L2("URETM",
                                   "2.16.840.1.113883.5.1060",
                                   "Ureaplasma transport medium",
                                   "Ureaplasma transport medium",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Urethra.<br>
     */
    URETHRA_L1("URTH",
               "2.16.840.1.113883.5.129",
               "Urethra",
               "Urethra",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Urine catheter.<br>
     */
    URINE_CATHETER_L1("URT",
                      "2.16.840.1.113883.5.129",
                      "Urine catheter",
                      "Urine catheter",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Urine clean catch.<br>
     */
    URINE_CLEAN_CATCH_L1("URC",
                         "2.16.840.1.113883.5.129",
                         "Urine clean catch",
                         "Urine clean catch",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Urine.<br>
     */
    URINE_L1("UR",
             "2.16.840.1.113883.5.129",
             "Urine",
             "Urine",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Urine sediment.<br>
     */
    URINE_SEDIMENT_L1("URNS",
                      "2.16.840.1.113883.5.129",
                      "Urine sediment",
                      "Urine sediment",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Vaccine.<br>
     */
    VACCINE("VCCNE",
            "2.16.840.1.113883.5.1060",
            "Vaccine",
            "Vaccine",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Vaccine.<br>
     */
    VACCINE_L1("VCCNE",
               "2.16.840.1.113883.5.1060",
               "Vaccine",
               "Vaccine",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Vial.<br>
     */
    VIAL_L4("VIAL",
            "2.16.840.1.113883.5.1060",
            "Vial",
            "Vial",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Vial.<br>
     */
    VIAL_L5("VIAL",
            "2.16.840.1.113883.5.1060",
            "Vial",
            "Vial",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Viral Transport medium.<br>
     */
    VIRAL_TRANSPORT_MEDIUM_L1("VIRTM",
                              "2.16.840.1.113883.5.1060",
                              "Viral Transport medium",
                              "Viral Transport medium",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Viral Transport medium.<br>
     */
    VIRAL_TRANSPORT_MEDIUM_L2("VIRTM",
                              "2.16.840.1.113883.5.1060",
                              "Viral Transport medium",
                              "Viral Transport medium",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Vomitus.<br>
     */
    VOMITUS_L1("VOM",
               "2.16.840.1.113883.5.129",
               "Vomitus",
               "Vomitus",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Water.<br>
     */
    WATER_L1("WAT",
             "2.16.840.1.113883.5.129",
             "Water",
             "Water",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Whole blood.<br>
     */
    WHOLE_BLOOD_L1("BLD",
                   "2.16.840.1.113883.5.129",
                   "Whole blood",
                   "Whole blood",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Whole body.<br>
     */
    WHOLE_BODY_L1("BDY",
                  "2.16.840.1.113883.5.129",
                  "Whole body",
                  "Whole body",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Wick.<br>
     */
    WICK_L1("WICK",
            "2.16.840.1.113883.5.129",
            "Wick",
            "Wick",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Wing Location.<br>
     */
    WING_LOCATION_L1("WING",
                     "2.16.840.1.113883.5.1060",
                     "Wing Location",
                     "Wing Location",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Wound abscess.<br>
     */
    WOUND_ABSCESS_L1("WNDA",
                     "2.16.840.1.113883.5.129",
                     "Wound abscess",
                     "Wound abscess",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Wound drainage.<br>
     */
    WOUND_DRAINAGE_L1("WNDD",
                      "2.16.840.1.113883.5.129",
                      "Wound drainage",
                      "Wound drainage",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Wound exudate.<br>
     */
    WOUND_EXUDATE_L1("WNDE",
                     "2.16.840.1.113883.5.129",
                     "Wound exudate",
                     "Wound exudate",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Wound.<br>
     */
    WOUND_L1("WND",
             "2.16.840.1.113883.5.129",
             "Wound",
             "Wound",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE");

    /**
     * EN: Code for Abcess.<br>
     */
    public static final String ABCESS_L1_CODE = "ABS";

    /**
     * EN: Code for AccessMedicalDevice.<br>
     */
    public static final String ACCESSMEDICALDEVICE_L1_CODE = "_AccessMedicalDevice";

    /**
     * EN: Code for AccessMedicalDevice.<br>
     */
    public static final String ACCESSMEDICALDEVICE_L2_CODE = "_AccessMedicalDevice";

    /**
     * EN: Code for ACD Solution A.<br>
     */
    public static final String ACD_SOLUTION_A_L1_CODE = "ACDA";

    /**
     * EN: Code for ACD Solution A.<br>
     */
    public static final String ACD_SOLUTION_A_L2_CODE = "ACDA";

    /**
     * EN: Code for ACD Solution B.<br>
     */
    public static final String ACD_SOLUTION_B_L1_CODE = "ACDB";

    /**
     * EN: Code for ACD Solution B.<br>
     */
    public static final String ACD_SOLUTION_B_L2_CODE = "ACDB";

    /**
     * EN: Code for Acetic Acid.<br>
     */
    public static final String ACETIC_ACID_L1_CODE = "ACET";

    /**
     * EN: Code for Acetic Acid.<br>
     */
    public static final String ACETIC_ACID_L2_CODE = "ACET";

    /**
     * EN: Code for AdministrationMedicalDevice.<br>
     */
    public static final String ADMINISTRATIONMEDICALDEVICE_L1_CODE = "_AdministrationMedicalDevice";

    /**
     * EN: Code for AdministrationMedicalDevice.<br>
     */
    public static final String ADMINISTRATIONMEDICALDEVICE_L2_CODE = "_AdministrationMedicalDevice";

    /**
     * EN: Code for Amber Bottle.<br>
     */
    public static final String AMBER_BOTTLE_L5_CODE = "BOTA";

    /**
     * EN: Code for Amber Bottle.<br>
     */
    public static final String AMBER_BOTTLE_L6_CODE = "BOTA";

    /**
     * EN: Code for Amies transport medium.<br>
     */
    public static final String AMIES_TRANSPORT_MEDIUM_L1_CODE = "AMIES";

    /**
     * EN: Code for Amies transport medium.<br>
     */
    public static final String AMIES_TRANSPORT_MEDIUM_L2_CODE = "AMIES";

    /**
     * EN: Code for Ammonium heparin.<br>
     */
    public static final String AMMONIUM_HEPARIN_L1_CODE = "HEPA";

    /**
     * EN: Code for Ammonium heparin.<br>
     */
    public static final String AMMONIUM_HEPARIN_L2_CODE = "HEPA";

    /**
     * EN: Code for Amniotic fluid.<br>
     */
    public static final String AMNIOTIC_FLUID_L1_CODE = "AMN";

    /**
     * EN: Code for Ampule.<br>
     */
    public static final String AMPULE_L4_CODE = "AMP";

    /**
     * EN: Code for Ampule.<br>
     */
    public static final String AMPULE_L5_CODE = "AMP";

    /**
     * EN: Code for Applicator.<br>
     */
    public static final String APPLICATOR_L2_CODE = "APLCTR";

    /**
     * EN: Code for Applicator.<br>
     */
    public static final String APPLICATOR_L3_CODE = "APLCTR";

    /**
     * EN: Code for Aspirate.<br>
     */
    public static final String ASPIRATE_L1_CODE = "ASP";

    /**
     * EN: Code for AutoInjector.<br>
     */
    public static final String AUTOINJECTOR_L3_CODE = "AINJ";

    /**
     * EN: Code for AutoInjector.<br>
     */
    public static final String AUTOINJECTOR_L4_CODE = "AINJ";

    /**
     * EN: Code for Bacterial Transport medium.<br>
     */
    public static final String BACTERIAL_TRANSPORT_MEDIUM_L1_CODE = "BACTM";

    /**
     * EN: Code for Bacterial Transport medium.<br>
     */
    public static final String BACTERIAL_TRANSPORT_MEDIUM_L2_CODE = "BACTM";

    /**
     * EN: Code for Bag.<br>
     */
    public static final String BAG_L3_CODE = "BAG";

    /**
     * EN: Code for Bag.<br>
     */
    public static final String BAG_L4_CODE = "BAG";

    /**
     * EN: Code for Basophils.<br>
     */
    public static final String BASOPHILS_L1_CODE = "BPH";

    /**
     * EN: Code for Bed Location.<br>
     */
    public static final String BED_LOCATION_L1_CODE = "BED";

    /**
     * EN: Code for Bile fluid.<br>
     */
    public static final String BILE_FLUID_L1_CODE = "BIFL";

    /**
     * EN: Code for Blister Pack.<br>
     */
    public static final String BLISTER_PACK_L3_CODE = "BLSTRPK";

    /**
     * EN: Code for Blister Pack.<br>
     */
    public static final String BLISTER_PACK_L4_CODE = "BLSTRPK";

    /**
     * EN: Code for Blood arterial.<br>
     */
    public static final String BLOOD_ARTERIAL_L1_CODE = "BLDA";

    /**
     * EN: Code for Blood bag.<br>
     */
    public static final String BLOOD_BAG_L1_CODE = "BBL";

    /**
     * EN: Code for Blood capillary.<br>
     */
    public static final String BLOOD_CAPILLARY_L1_CODE = "BLDC";

    /**
     * EN: Code for Blood - cord.<br>
     */
    public static final String BLOOD_CORD_L1_CODE = "BLDCO";

    /**
     * EN: Code for Blood Product.<br>
     */
    public static final String BLOOD_PRODUCT_CODE = "BLDPRD";

    /**
     * EN: Code for Blood Product.<br>
     */
    public static final String BLOOD_PRODUCT_L1_CODE = "BLDPRD";

    /**
     * EN: Code for Blood product unit.<br>
     */
    public static final String BLOOD_PRODUCT_UNIT_L1_CODE = "BPU";

    /**
     * EN: Code for Blood venous.<br>
     */
    public static final String BLOOD_VENOUS_L1_CODE = "BLDV";

    /**
     * EN: Code for Body fluid, unsp.<br>
     */
    public static final String BODY_FLUID_UNSP_L1_CODE = "FLU";

    /**
     * EN: Code for Bone.<br>
     */
    public static final String BONE_L1_CODE = "BON";

    /**
     * EN: Code for Boric Acid.<br>
     */
    public static final String BORIC_ACID_L1_CODE = "BOR";

    /**
     * EN: Code for Boric Acid.<br>
     */
    public static final String BORIC_ACID_L2_CODE = "BOR";

    /**
     * EN: Code for Bottle.<br>
     */
    public static final String BOTTLE_L4_CODE = "BOT";

    /**
     * EN: Code for Bottle.<br>
     */
    public static final String BOTTLE_L5_CODE = "BOT";

    /**
     * EN: Code for Bouin's solution.<br>
     */
    public static final String BOUIN_S_SOLUTION_L1_CODE = "BOUIN";

    /**
     * EN: Code for Bouin's solution.<br>
     */
    public static final String BOUIN_S_SOLUTION_L2_CODE = "BOUIN";

    /**
     * EN: Code for Box.<br>
     */
    public static final String BOX_L4_CODE = "BOX";

    /**
     * EN: Code for Box.<br>
     */
    public static final String BOX_L5_CODE = "BOX";

    /**
     * EN: Code for Breast milk.<br>
     */
    public static final String BREAST_MILK_L1_CODE = "MILK";

    /**
     * EN: Code for Bronchial.<br>
     */
    public static final String BRONCHIAL_L1_CODE = "BRO";

    /**
     * EN: Code for Buffered 10% formalin.<br>
     */
    public static final String BUFFERED_10PERCENT_FORMALIN_L1_CODE = "BF10";

    /**
     * EN: Code for Buffered 10% formalin.<br>
     */
    public static final String BUFFERED_10PERCENT_FORMALIN_L2_CODE = "BF10";

    /**
     * EN: Code for Buffered Citrate.<br>
     */
    public static final String BUFFERED_CITRATE_L1_CODE = "WEST";

    /**
     * EN: Code for Buffered Citrate.<br>
     */
    public static final String BUFFERED_CITRATE_L2_CODE = "WEST";

    /**
     * EN: Code for Buffered skim milk.<br>
     */
    public static final String BUFFERED_SKIM_MILK_L1_CODE = "BSKM";

    /**
     * EN: Code for Buffered skim milk.<br>
     */
    public static final String BUFFERED_SKIM_MILK_L2_CODE = "BSKM";

    /**
     * EN: Code for Building Location.<br>
     */
    public static final String BUILDING_LOCATION_L1_CODE = "BLDG";

    /**
     * EN: Code for Burn.<br>
     */
    public static final String BURN_L1_CODE = "BRN";

    /**
     * EN: Code for Calculus (=Stone) Stone (use CALC).<br>
     */
    public static final String CALCULUS_STONE_STONE_USE_CALC_L1_CODE = "CALC";

    /**
     * EN: Code for Canister.<br>
     */
    public static final String CANISTER_L4_CODE = "CNSTR";

    /**
     * EN: Code for Canister.<br>
     */
    public static final String CANISTER_L5_CODE = "CNSTR";

    /**
     * EN: Code for Cannula.<br>
     */
    public static final String CANNULA_L1_CODE = "CNL";

    /**
     * EN: Code for Can.<br>
     */
    public static final String CAN_L4_CODE = "CAN";

    /**
     * EN: Code for Can.<br>
     */
    public static final String CAN_L5_CODE = "CAN";

    /**
     * EN: Code for Cardiac muscle.<br>
     */
    public static final String CARDIAC_MUSCLE_L1_CODE = "CDM";

    /**
     * EN: Code for Card.<br>
     */
    public static final String CARD_L4_CODE = "CARD";

    /**
     * EN: Code for Card.<br>
     */
    public static final String CARD_L5_CODE = "CARD";

    /**
     * EN: Code for Carson's Modified 10% formalin.<br>
     */
    public static final String CARSON_S_MODIFIED_10PERCENT_FORMALIN_L1_CODE = "CARS";

    /**
     * EN: Code for Carson's Modified 10% formalin.<br>
     */
    public static final String CARSON_S_MODIFIED_10PERCENT_FORMALIN_L2_CODE = "CARS";

    /**
     * EN: Code for Cartridge.<br>
     */
    public static final String CARTRIDGE_L4_CODE = "CART";

    /**
     * EN: Code for Cartridge.<br>
     */
    public static final String CARTRIDGE_L5_CODE = "CART";

    /**
     * EN: Code for Cary Blair Medium.<br>
     */
    public static final String CARY_BLAIR_MEDIUM_L1_CODE = "CARY";

    /**
     * EN: Code for Cary Blair Medium.<br>
     */
    public static final String CARY_BLAIR_MEDIUM_L2_CODE = "CARY";

    /**
     * EN: Code for Catheter tip.<br>
     */
    public static final String CATHETER_TIP_L1_CODE = "CTP";

    /**
     * EN: Code for Cerebral spinal fluid.<br>
     */
    public static final String CEREBRAL_SPINAL_FLUID_L1_CODE = "CSF";

    /**
     * EN: Code for Cervical mucus.<br>
     */
    public static final String CERVICAL_MUCUS_L1_CODE = "CVM";

    /**
     * EN: Code for Cervix.<br>
     */
    public static final String CERVIX_L1_CODE = "CVX";

    /**
     * EN: Code for Chlamydia transport medium.<br>
     */
    public static final String CHLAMYDIA_TRANSPORT_MEDIUM_L1_CODE = "CHLTM";

    /**
     * EN: Code for Chlamydia transport medium.<br>
     */
    public static final String CHLAMYDIA_TRANSPORT_MEDIUM_L2_CODE = "CHLTM";

    /**
     * EN: Code for Colostrum.<br>
     */
    public static final String COLOSTRUM_L1_CODE = "COL";

    /**
     * EN: Code for Compliance Package.<br>
     */
    public static final String COMPLIANCE_PACKAGE_L2_CODE = "COMPPKG";

    /**
     * EN: Code for Compliance Package.<br>
     */
    public static final String COMPLIANCE_PACKAGE_L3_CODE = "COMPPKG";

    /**
     * EN: Code for Conjunctiva.<br>
     */
    public static final String CONJUNCTIVA_L1_CODE = "CNJT";

    /**
     * EN: Code for ContainerEntityType.<br>
     */
    public static final String CONTAINERENTITYTYPE_L1_CODE = "_ContainerEntityType";

    /**
     * EN: Code for Cornea.<br>
     */
    public static final String CORNEA_L1_CODE = "CRN";

    /**
     * EN: Code for CTAD.<br>
     */
    public static final String CTAD_L1_CODE = "CTAD";

    /**
     * EN: Code for CTAD.<br>
     */
    public static final String CTAD_L2_CODE = "CTAD";

    /**
     * EN: Code for Curettage.<br>
     */
    public static final String CURETTAGE_L1_CODE = "CUR";

    /**
     * EN: Code for Cyst.<br>
     */
    public static final String CYST_L1_CODE = "CYST";

    /**
     * EN: Code for Dialysis fluid.<br>
     */
    public static final String DIALYSIS_FLUID_L1_CODE = "DIAF";

    /**
     * EN: Code for Dial Pack.<br>
     */
    public static final String DIAL_PACK_L3_CODE = "DIALPK";

    /**
     * EN: Code for Dial Pack.<br>
     */
    public static final String DIAL_PACK_L4_CODE = "DIALPK";

    /**
     * EN: Code for Diskhaler.<br>
     */
    public static final String DISKHALER_L3_CODE = "DSKUNH";

    /**
     * EN: Code for Diskhaler.<br>
     */
    public static final String DISKHALER_L4_CODE = "DSKUNH";

    /**
     * EN: Code for Diskus.<br>
     */
    public static final String DISKUS_L3_CODE = "DSKS";

    /**
     * EN: Code for Diskus.<br>
     */
    public static final String DISKUS_L4_CODE = "DSKS";

    /**
     * EN: Code for Disk.<br>
     */
    public static final String DISK_L3_CODE = "DISK";

    /**
     * EN: Code for Disk.<br>
     */
    public static final String DISK_L4_CODE = "DISK";

    /**
     * EN: Code for Dosette.<br>
     */
    public static final String DOSETTE_L3_CODE = "DOSET";

    /**
     * EN: Code for Dosette.<br>
     */
    public static final String DOSETTE_L4_CODE = "DOSET";

    /**
     * EN: Code for Dose med or substance.<br>
     */
    public static final String DOSE_MED_OR_SUBSTANCE_L1_CODE = "DOSE";

    /**
     * EN: Code for Drain.<br>
     */
    public static final String DRAIN_L1_CODE = "DRN";

    /**
     * EN: Code for Dropper Bottle.<br>
     */
    public static final String DROPPER_BOTTLE_L5_CODE = "BOTD";

    /**
     * EN: Code for Dropper Bottle.<br>
     */
    public static final String DROPPER_BOTTLE_L6_CODE = "BOTD";

    /**
     * EN: Code for Duodenal fluid.<br>
     */
    public static final String DUODENAL_FLUID_L1_CODE = "DUFL";

    /**
     * EN: Code for Ear.<br>
     */
    public static final String EAR_L1_CODE = "EAR";

    /**
     * EN: Code for Ear wax (cerumen).<br>
     */
    public static final String EAR_WAX_CERUMEN_L1_CODE = "EARW";

    /**
     * EN: Code for Electrode.<br>
     */
    public static final String ELECTRODE_L1_CODE = "ELT";

    /**
     * EN: Code for Endocardium.<br>
     */
    public static final String ENDOCARDIUM_L1_CODE = "ENDC";

    /**
     * EN: Code for Endometrium.<br>
     */
    public static final String ENDOMETRIUM_L1_CODE = "ENDM";

    /**
     * EN: Code for Enteric bacteria transport medium.<br>
     */
    public static final String ENTERIC_BACTERIA_TRANSPORT_MEDIUM_L1_CODE = "ENT";

    /**
     * EN: Code for Enteric bacteria transport medium.<br>
     */
    public static final String ENTERIC_BACTERIA_TRANSPORT_MEDIUM_L2_CODE = "ENT";

    /**
     * EN: Code for Eosinophils.<br>
     */
    public static final String EOSINOPHILS_L1_CODE = "EOS";

    /**
     * EN: Code for Erythrocytes.<br>
     */
    public static final String ERYTHROCYTES_L1_CODE = "RBC";

    /**
     * EN: Code for Exhaled gas (=breath) Breath (use EXG).<br>
     */
    public static final String EXHALED_GAS_BREATH_BREATH_USE_EXG_L1_CODE = "BRTH";

    /**
     * EN: Code for Eye.<br>
     */
    public static final String EYE_L1_CODE = "EYE";

    /**
     * EN: Code for Fibroblasts.<br>
     */
    public static final String FIBROBLASTS_L1_CODE = "FIB";

    /**
     * EN: Code for Filter.<br>
     */
    public static final String FILTER_L1_CODE = "FLT";

    /**
     * EN: Code for Fistula.<br>
     */
    public static final String FISTULA_L1_CODE = "FIST";

    /**
     * EN: Code for Floor Location.<br>
     */
    public static final String FLOOR_LOCATION_L1_CODE = "FLOOR";

    /**
     * EN: Code for Food sample.<br>
     */
    public static final String FOOD_SAMPLE_L1_CODE = "FOOD";

    /**
     * EN: Code for Gastric fluid/contents.<br>
     */
    public static final String GASTRIC_FLUID_CONTENTS_L1_CODE = "GAST";

    /**
     * EN: Code for Gas.<br>
     */
    public static final String GAS_L1_CODE = "GAS";

    /**
     * EN: Code for Genital cervix.<br>
     */
    public static final String GENITAL_CERVIX_L1_CODE = "GENC";

    /**
     * EN: Code for Genital fluid.<br>
     */
    public static final String GENITAL_FLUID_L1_CODE = "GENF";

    /**
     * EN: Code for Genital.<br>
     */
    public static final String GENITAL_L1_CODE = "GEN";

    /**
     * EN: Code for Genital lochia.<br>
     */
    public static final String GENITAL_LOCHIA_L1_CODE = "GENL";

    /**
     * EN: Code for Genital vaginal.<br>
     */
    public static final String GENITAL_VAGINAL_L1_CODE = "GENV";

    /**
     * EN: Code for Glass Bottle.<br>
     */
    public static final String GLASS_BOTTLE_L5_CODE = "BOTG";

    /**
     * EN: Code for Glass Bottle.<br>
     */
    public static final String GLASS_BOTTLE_L6_CODE = "BOTG";

    /**
     * EN: Code for Hair.<br>
     */
    public static final String HAIR_L1_CODE = "HAR";

    /**
     * EN: Code for household.<br>
     */
    public static final String HOUSEHOLD_L1_CODE = "HHOLD";

    /**
     * EN: Code for IndividualPackageEntityType.<br>
     */
    public static final String INDIVIDUALPACKAGEENTITYTYPE_L3_CODE = "_IndividualPackageEntityType";

    /**
     * EN: Code for IndividualPackageEntityType.<br>
     */
    public static final String INDIVIDUALPACKAGEENTITYTYPE_L4_CODE = "_IndividualPackageEntityType";

    /**
     * EN: Code for Inhaled Gas.<br>
     */
    public static final String INHALED_GAS_L1_CODE = "IHG";

    /**
     * EN: Code for Inhaler.<br>
     */
    public static final String INHALER_L2_CODE = "INH";

    /**
     * EN: Code for Inhaler.<br>
     */
    public static final String INHALER_L3_CODE = "INH";

    /**
     * EN: Code for InjectionMedicalDevice.<br>
     */
    public static final String INJECTIONMEDICALDEVICE_L2_CODE = "_InjectionMedicalDevice";

    /**
     * EN: Code for InjectionMedicalDevice.<br>
     */
    public static final String INJECTIONMEDICALDEVICE_L3_CODE = "_InjectionMedicalDevice";

    /**
     * EN: Code for Intraveneous Line.<br>
     */
    public static final String INTRAVENEOUS_LINE_L3_CODE = "IVLINE";

    /**
     * EN: Code for Intraveneous Line.<br>
     */
    public static final String INTRAVENEOUS_LINE_L4_CODE = "IVLINE";

    /**
     * EN: Code for Intra-arterial Line.<br>
     */
    public static final String INTRA_ARTERIAL_LINE_L3_CODE = "IALINE";

    /**
     * EN: Code for Intra-arterial Line.<br>
     */
    public static final String INTRA_ARTERIAL_LINE_L4_CODE = "IALINE";

    /**
     * EN: Code for Intubation tube.<br>
     */
    public static final String INTUBATION_TUBE_L1_CODE = "IT";

    /**
     * EN: Code for Isolate.<br>
     */
    public static final String ISOLATE_L1_CODE = "ISLT";

    /**
     * EN: Code for Jar.<br>
     */
    public static final String JAR_L4_CODE = "JAR";

    /**
     * EN: Code for Jar.<br>
     */
    public static final String JAR_L5_CODE = "JAR";

    /**
     * EN: Code for Jones Kendrick Medium.<br>
     */
    public static final String JONES_KENDRICK_MEDIUM_L1_CODE = "JKM";

    /**
     * EN: Code for Jones Kendrick Medium.<br>
     */
    public static final String JONES_KENDRICK_MEDIUM_L2_CODE = "JKM";

    /**
     * EN: Code for Jug.<br>
     */
    public static final String JUG_L4_CODE = "JUG";

    /**
     * EN: Code for Jug.<br>
     */
    public static final String JUG_L5_CODE = "JUG";

    /**
     * EN: Code for Karnovsky's fixative.<br>
     */
    public static final String KARNOVSKY_S_FIXATIVE_L1_CODE = "KARN";

    /**
     * EN: Code for Karnovsky's fixative.<br>
     */
    public static final String KARNOVSKY_S_FIXATIVE_L2_CODE = "KARN";

    /**
     * EN: Code for Kit.<br>
     */
    public static final String KIT_L2_CODE = "KIT";

    /**
     * EN: Code for Kit.<br>
     */
    public static final String KIT_L3_CODE = "KIT";

    /**
     * EN: Code for Lamella.<br>
     */
    public static final String LAMELLA_L1_CODE = "LAM";

    /**
     * EN: Code for Leukocytes.<br>
     */
    public static final String LEUKOCYTES_L1_CODE = "WBC";

    /**
     * EN: Code for Line arterial.<br>
     */
    public static final String LINE_ARTERIAL_L1_CODE = "LNA";

    /**
     * EN: Code for Line.<br>
     */
    public static final String LINE_L1_CODE = "LN";

    /**
     * EN: Code for Line.<br>
     */
    public static final String LINE_L2_CODE = "LINE";

    /**
     * EN: Code for Line.<br>
     */
    public static final String LINE_L3_CODE = "LINE";

    /**
     * EN: Code for Line venous.<br>
     */
    public static final String LINE_VENOUS_L1_CODE = "LNV";

    /**
     * EN: Code for Liquid NOS.<br>
     */
    public static final String LIQUID_NOS_L1_CODE = "LIQ";

    /**
     * EN: Code for Lithium iodoacetate.<br>
     */
    public static final String LITHIUM_IODOACETATE_L1_CODE = "LIA";

    /**
     * EN: Code for Lithium iodoacetate.<br>
     */
    public static final String LITHIUM_IODOACETATE_L2_CODE = "LIA";

    /**
     * EN: Code for Lithium/Li Heparin.<br>
     */
    public static final String LITHIUM_LI_HEPARIN_L1_CODE = "HEPL";

    /**
     * EN: Code for Lithium/Li Heparin.<br>
     */
    public static final String LITHIUM_LI_HEPARIN_L2_CODE = "HEPL";

    /**
     * EN: Code for Lymphocytes.<br>
     */
    public static final String LYMPHOCYTES_L1_CODE = "LYM";

    /**
     * EN: Code for M4.<br>
     */
    public static final String M4_L1_CODE = "M4";

    /**
     * EN: Code for M4.<br>
     */
    public static final String M4_L2_CODE = "M4";

    /**
     * EN: Code for M4-RT.<br>
     */
    public static final String M4_RT_L1_CODE = "M4RT";

    /**
     * EN: Code for M4-RT.<br>
     */
    public static final String M4_RT_L2_CODE = "M4RT";

    /**
     * EN: Code for M5.<br>
     */
    public static final String M5_L1_CODE = "M5";

    /**
     * EN: Code for M5.<br>
     */
    public static final String M5_L2_CODE = "M5";

    /**
     * EN: Code for Macrophages.<br>
     */
    public static final String MACROPHAGES_L1_CODE = "MAC";

    /**
     * EN: Code for Marrow (bone).<br>
     */
    public static final String MARROW_BONE_L1_CODE = "MAR";

    /**
     * EN: Code for Meconium.<br>
     */
    public static final String MECONIUM_L1_CODE = "MEC";

    /**
     * EN: Code for MedicalDevice.<br>
     */
    public static final String MEDICALDEVICE_L1_CODE = "_MedicalDevice";

    /**
     * EN: Code for Menstrual blood.<br>
     */
    public static final String MENSTRUAL_BLOOD_L1_CODE = "MBLD";

    /**
     * EN: Code for Michel's transport medium.<br>
     */
    public static final String MICHEL_S_TRANSPORT_MEDIUM_L1_CODE = "MICHTM";

    /**
     * EN: Code for Michel's transport medium.<br>
     */
    public static final String MICHEL_S_TRANSPORT_MEDIUM_L2_CODE = "MICHTM";

    /**
     * EN: Code for Milk.<br>
     */
    public static final String MILK_L1_CODE = "MLK";

    /**
     * EN: Code for Minim.<br>
     */
    public static final String MINIM_L4_CODE = "MINIM";

    /**
     * EN: Code for Minim.<br>
     */
    public static final String MINIM_L5_CODE = "MINIM";

    /**
     * EN: Code for MMD transport medium.<br>
     */
    public static final String MMD_TRANSPORT_MEDIUM_L1_CODE = "MMDTM";

    /**
     * EN: Code for MMD transport medium.<br>
     */
    public static final String MMD_TRANSPORT_MEDIUM_L2_CODE = "MMDTM";

    /**
     * EN: Code for MultiUseContainerEntityType.<br>
     */
    public static final String MULTIUSECONTAINERENTITYTYPE_L3_CODE = "_MultiUseContainerEntityType";

    /**
     * EN: Code for MultiUseContainerEntityType.<br>
     */
    public static final String MULTIUSECONTAINERENTITYTYPE_L4_CODE = "_MultiUseContainerEntityType";

    /**
     * EN: Code for Nail.<br>
     */
    public static final String NAIL_L1_CODE = "NAIL";

    /**
     * EN: Code for NationEntityType.<br>
     */
    public static final String NATIONENTITYTYPE_L1_CODE = "NAT";

    /**
     * EN: Code for Nebuamp.<br>
     */
    public static final String NEBUAMP_L4_CODE = "NEBAMP";

    /**
     * EN: Code for Nebuamp.<br>
     */
    public static final String NEBUAMP_L5_CODE = "NEBAMP";

    /**
     * EN: Code for Nitric Acid.<br>
     */
    public static final String NITRIC_ACID_L1_CODE = "HNO3";

    /**
     * EN: Code for Nitric Acid.<br>
     */
    public static final String NITRIC_ACID_L2_CODE = "HNO3";

    /**
     * EN: Code for None.<br>
     */
    public static final String NONE_L1_CODE = "NONE";

    /**
     * EN: Code for None.<br>
     */
    public static final String NONE_L2_CODE = "NONE";

    /**
     * EN: Code for NonRigidContainerEntityType.<br>
     */
    public static final String NONRIGIDCONTAINERENTITYTYPE_L2_CODE = "_NonRigidContainerEntityType";

    /**
     * EN: Code for NonRigidContainerEntityType.<br>
     */
    public static final String NONRIGIDCONTAINERENTITYTYPE_L3_CODE = "_NonRigidContainerEntityType";

    /**
     * EN: Code for Nose (nasal passage).<br>
     */
    public static final String NOSE_NASAL_PASSAGE_L1_CODE = "NOS";

    /**
     * EN: Code for 10% Formalin.<br>
     */
    public static final String ONE_PERCENT_FORMALIN_L1_CODE = "F10";

    /**
     * EN: Code for 10% Formalin.<br>
     */
    public static final String ONE_PERCENT_FORMALIN_L2_CODE = "F10";

    /**
     * EN: Code for OrganizationEntityType.<br>
     */
    public static final String ORGANIZATIONENTITYTYPE_CODE = "_OrganizationEntityType";

    /**
     * EN: Code for Ovule.<br>
     */
    public static final String OVULE_L4_CODE = "OVUL";

    /**
     * EN: Code for Ovule.<br>
     */
    public static final String OVULE_L5_CODE = "OVUL";

    /**
     * EN: Code for Package.<br>
     */
    public static final String PACKAGE_L1_CODE = "PKG";

    /**
     * EN: Code for Package.<br>
     */
    public static final String PACKAGE_L2_CODE = "PKG";

    /**
     * EN: Code for Packet.<br>
     */
    public static final String PACKET_L3_CODE = "PACKT";

    /**
     * EN: Code for Packet.<br>
     */
    public static final String PACKET_L4_CODE = "PACKT";

    /**
     * EN: Code for Page's Saline.<br>
     */
    public static final String PAGE_S_SALINE_L1_CODE = "PAGE";

    /**
     * EN: Code for Page's Saline.<br>
     */
    public static final String PAGE_S_SALINE_L2_CODE = "PAGE";

    /**
     * EN: Code for Pancreatic fluid.<br>
     */
    public static final String PANCREATIC_FLUID_L1_CODE = "PAFL";

    /**
     * EN: Code for Patient.<br>
     */
    public static final String PATIENT_L1_CODE = "PAT";

    /**
     * EN: Code for Pen.<br>
     */
    public static final String PEN_L3_CODE = "PEN";

    /**
     * EN: Code for Pen.<br>
     */
    public static final String PEN_L4_CODE = "PEN";

    /**
     * EN: Code for Peritoneal fluid /ascites.<br>
     */
    public static final String PERITONEAL_FLUID_ASCITES_L1_CODE = "PRT";

    /**
     * EN: Code for Phenol.<br>
     */
    public static final String PHENOL_L1_CODE = "PHENOL";

    /**
     * EN: Code for Phenol.<br>
     */
    public static final String PHENOL_L2_CODE = "PHENOL";

    /**
     * EN: Code for Placenta.<br>
     */
    public static final String PLACENTA_L1_CODE = "PLC";

    /**
     * EN: Code for Plasma bag.<br>
     */
    public static final String PLASMA_BAG_L1_CODE = "PLB";

    /**
     * EN: Code for Plasma.<br>
     */
    public static final String PLASMA_L1_CODE = "PLAS";

    /**
     * EN: Code for Plastic Bottle.<br>
     */
    public static final String PLASTIC_BOTTLE_L5_CODE = "BOTP";

    /**
     * EN: Code for Plastic Bottle.<br>
     */
    public static final String PLASTIC_BOTTLE_L6_CODE = "BOTP";

    /**
     * EN: Code for Platelet poor plasma.<br>
     */
    public static final String PLATELET_POOR_PLASMA_L1_CODE = "PPP";

    /**
     * EN: Code for Platelet rich plasma.<br>
     */
    public static final String PLATELET_RICH_PLASMA_L1_CODE = "PRP";

    /**
     * EN: Code for Pleural fluid (thoracentesis fld).<br>
     */
    public static final String PLEURAL_FLUID_THORACENTESIS_FLD_L1_CODE = "PLR";

    /**
     * EN: Code for Polyethylene Bottle.<br>
     */
    public static final String POLYETHYLENE_BOTTLE_L6_CODE = "BOTPLY";

    /**
     * EN: Code for Polyethylene Bottle.<br>
     */
    public static final String POLYETHYLENE_BOTTLE_L7_CODE = "BOTPLY";

    /**
     * EN: Code for Polymorphonuclear neutrophils.<br>
     */
    public static final String POLYMORPHONUCLEAR_NEUTROPHILS_L1_CODE = "PMN";

    /**
     * EN: Code for Polyvinylalcohol.<br>
     */
    public static final String POLYVINYLALCOHOL_L1_CODE = "PVA";

    /**
     * EN: Code for Polyvinylalcohol.<br>
     */
    public static final String POLYVINYLALCOHOL_L2_CODE = "PVA";

    /**
     * EN: Code for Potassium/K EDTA 15%.<br>
     */
    public static final String POTASSIUM_K_EDTA_15PERCENT_L1_CODE = "EDTK15";

    /**
     * EN: Code for Potassium/K EDTA 15%.<br>
     */
    public static final String POTASSIUM_K_EDTA_15PERCENT_L2_CODE = "EDTK15";

    /**
     * EN: Code for Potassium/K EDTA 7.5%.<br>
     */
    public static final String POTASSIUM_K_EDTA_7_5PERCENT_L1_CODE = "EDTK75";

    /**
     * EN: Code for Potassium/K EDTA 7.5%.<br>
     */
    public static final String POTASSIUM_K_EDTA_7_5PERCENT_L2_CODE = "EDTK75";

    /**
     * EN: Code for Potassium Oxalate.<br>
     */
    public static final String POTASSIUM_OXALATE_L1_CODE = "KOX";

    /**
     * EN: Code for Potassium Oxalate.<br>
     */
    public static final String POTASSIUM_OXALATE_L2_CODE = "KOX";

    /**
     * EN: Code for Pouch.<br>
     */
    public static final String POUCH_L3_CODE = "PCH";

    /**
     * EN: Code for Pouch.<br>
     */
    public static final String POUCH_L4_CODE = "PCH";

    /**
     * EN: Code for PractitionerGroup.<br>
     */
    public static final String PRACTITIONERGROUP_CODE = "PRAC";

    /**
     * EN: Code for Pump.<br>
     */
    public static final String PUMP_L2_CODE = "PMP";

    /**
     * EN: Code for Pump.<br>
     */
    public static final String PUMP_L3_CODE = "PMP";

    /**
     * EN: Code for Pus.<br>
     */
    public static final String PUS_L1_CODE = "PUS";

    /**
     * EN: Code for Reagan Lowe Medium.<br>
     */
    public static final String REAGAN_LOWE_MEDIUM_L1_CODE = "RLM";

    /**
     * EN: Code for Reagan Lowe Medium.<br>
     */
    public static final String REAGAN_LOWE_MEDIUM_L2_CODE = "RLM";

    /**
     * EN: Code for religious institution.<br>
     */
    public static final String RELIGIOUS_INSTITUTION_L1_CODE = "RELIG";

    /**
     * EN: Code for RigidContainerEntityType.<br>
     */
    public static final String RIGIDCONTAINERENTITYTYPE_L2_CODE = "_RigidContainerEntityType";

    /**
     * EN: Code for RigidContainerEntityType.<br>
     */
    public static final String RIGIDCONTAINERENTITYTYPE_L3_CODE = "_RigidContainerEntityType";

    /**
     * EN: Code for Room Location.<br>
     */
    public static final String ROOM_LOCATION_L1_CODE = "ROOM";

    /**
     * EN: Code for Sachet.<br>
     */
    public static final String SACHET_L3_CODE = "SACH";

    /**
     * EN: Code for Sachet.<br>
     */
    public static final String SACHET_L4_CODE = "SACH";

    /**
     * EN: Code for Saliva.<br>
     */
    public static final String SALIVA_L1_CODE = "SAL";

    /**
     * EN: Code for Seminal fluid.<br>
     */
    public static final String SEMINAL_FLUID_L1_CODE = "SMN";

    /**
     * EN: Code for Seminal plasma.<br>
     */
    public static final String SEMINAL_PLASMA_L1_CODE = "SMPLS";

    /**
     * EN: Code for Serum.<br>
     */
    public static final String SERUM_L1_CODE = "SER";

    /**
     * EN: Code for Serum Separator Tube.<br>
     */
    public static final String SERUM_SEPARATOR_TUBE_L1_CODE = "SST";

    /**
     * EN: Code for Serum Separator Tube.<br>
     */
    public static final String SERUM_SEPARATOR_TUBE_L2_CODE = "SST";

    /**
     * EN: Code for Siliceous earth.<br>
     */
    public static final String SILICEOUS_EARTH_L1_CODE = "SILICA";

    /**
     * EN: Code for Siliceous earth.<br>
     */
    public static final String SILICEOUS_EARTH_L2_CODE = "SILICA";

    /**
     * EN: Code for 6N HCL.<br>
     */
    public static final String SIX__HCL_L1_CODE = "HCL6";

    /**
     * EN: Code for 6N HCL.<br>
     */
    public static final String SIX__HCL_L2_CODE = "HCL6";

    /**
     * EN: Code for Skeletal muscle.<br>
     */
    public static final String SKELETAL_MUSCLE_L1_CODE = "SKM";

    /**
     * EN: Code for Skin.<br>
     */
    public static final String SKIN_L1_CODE = "SKN";

    /**
     * EN: Code for Sodium Fluoride, 100mg.<br>
     */
    public static final String SODIUM_FLUORIDE_100MG_L1_CODE = "FL100";

    /**
     * EN: Code for Sodium Fluoride, 100mg.<br>
     */
    public static final String SODIUM_FLUORIDE_100MG_L2_CODE = "FL100";

    /**
     * EN: Code for Sodium Fluoride, 10mg.<br>
     */
    public static final String SODIUM_FLUORIDE_10MG_L1_CODE = "FL10";

    /**
     * EN: Code for Sodium Fluoride, 10mg.<br>
     */
    public static final String SODIUM_FLUORIDE_10MG_L2_CODE = "FL10";

    /**
     * EN: Code for Sodium Fluoride.<br>
     */
    public static final String SODIUM_FLUORIDE_L1_CODE = "NAF";

    /**
     * EN: Code for Sodium Fluoride.<br>
     */
    public static final String SODIUM_FLUORIDE_L2_CODE = "NAF";

    /**
     * EN: Code for Sodium/Na EDTA.<br>
     */
    public static final String SODIUM_NA_EDTA_L1_CODE = "EDTN";

    /**
     * EN: Code for Sodium/Na EDTA.<br>
     */
    public static final String SODIUM_NA_EDTA_L2_CODE = "EDTN";

    /**
     * EN: Code for Sodium/Na Heparin.<br>
     */
    public static final String SODIUM_NA_HEPARIN_L1_CODE = "HEPN";

    /**
     * EN: Code for Sodium/Na Heparin.<br>
     */
    public static final String SODIUM_NA_HEPARIN_L2_CODE = "HEPN";

    /**
     * EN: Code for Sodium polyanethol sulfonate 0.35% in 0.85% sodium chloride.<br>
     */
    public static final String SODIUM_POLYANETHOL_SULFONATE_0_35PERCENT_IN_0_85PERCENT_SODIUM_CHLORIDE_L1_CODE = "SPS";

    /**
     * EN: Code for Sodium polyanethol sulfonate 0.35% in 0.85% sodium chloride.<br>
     */
    public static final String SODIUM_POLYANETHOL_SULFONATE_0_35PERCENT_IN_0_85PERCENT_SODIUM_CHLORIDE_L2_CODE = "SPS";

    /**
     * EN: Code for SpecimenAdditiveEntity.<br>
     */
    public static final String SPECIMENADDITIVEENTITY_L1_CODE = "_SpecimenAdditiveEntity";

    /**
     * EN: Code for Spermatozoa.<br>
     */
    public static final String SPERMATOZOA_L1_CODE = "SPRM";

    /**
     * EN: Code for Sputum - coughed.<br>
     */
    public static final String SPUTUM_COUGHED_L1_CODE = "SPTC";

    /**
     * EN: Code for Sputum.<br>
     */
    public static final String SPUTUM_L1_CODE = "SPT";

    /**
     * EN: Code for Sputum - tracheal aspirate.<br>
     */
    public static final String SPUTUM_TRACHEAL_ASPIRATE_L1_CODE = "SPTT";

    /**
     * EN: Code for Stool = Fecal.<br>
     */
    public static final String STOOL_FECAL_L1_CODE = "STL";

    /**
     * EN: Code for Strip.<br>
     */
    public static final String STRIP_L3_CODE = "STRIP";

    /**
     * EN: Code for Strip.<br>
     */
    public static final String STRIP_L4_CODE = "STRIP";

    /**
     * EN: Code for Stuart transport medium.<br>
     */
    public static final String STUART_TRANSPORT_MEDIUM_L1_CODE = "STUTM";

    /**
     * EN: Code for Stuart transport medium.<br>
     */
    public static final String STUART_TRANSPORT_MEDIUM_L2_CODE = "STUTM";

    /**
     * EN: Code for Sweat.<br>
     */
    public static final String SWEAT_L1_CODE = "SWT";

    /**
     * EN: Code for Synovial fluid (Joint fluid).<br>
     */
    public static final String SYNOVIAL_FLUID_JOINT_FLUID_L1_CODE = "SNV";

    /**
     * EN: Code for Syringe.<br>
     */
    public static final String SYRINGE_L3_CODE = "SYR";

    /**
     * EN: Code for Syringe.<br>
     */
    public static final String SYRINGE_L4_CODE = "SYR";

    /**
     * EN: Code for System.<br>
     */
    public static final String SYSTEM_L3_CODE = "SYSTM";

    /**
     * EN: Code for System.<br>
     */
    public static final String SYSTEM_L4_CODE = "SYSTM";

    /**
     * EN: Code for Tears.<br>
     */
    public static final String TEARS_L1_CODE = "TEAR";

    /**
     * EN: Code for 3.2% Citrate.<br>
     */
    public static final String THREE_2PERCENT_CITRATE_L1_CODE = "C32";

    /**
     * EN: Code for 3.2% Citrate.<br>
     */
    public static final String THREE_2PERCENT_CITRATE_L2_CODE = "C32";

    /**
     * EN: Code for 3.8% Citrate.<br>
     */
    public static final String THREE_8PERCENT_CITRATE_L1_CODE = "C38";

    /**
     * EN: Code for 3.8% Citrate.<br>
     */
    public static final String THREE_8PERCENT_CITRATE_L2_CODE = "C38";

    /**
     * EN: Code for Throat.<br>
     */
    public static final String THROAT_L1_CODE = "THRT";

    /**
     * EN: Code for Thrombin.<br>
     */
    public static final String THROMBIN_L1_CODE = "THROM";

    /**
     * EN: Code for Thrombin.<br>
     */
    public static final String THROMBIN_L2_CODE = "THROM";

    /**
     * EN: Code for Thrombin NIH; soybean trypsin inhibitor.<br>
     */
    public static final String THROMBIN_NIH_SOYBEAN_TRYPSIN_INHIBITOR_L1_CODE = "FDP";

    /**
     * EN: Code for Thrombin NIH; soybean trypsin inhibitor.<br>
     */
    public static final String THROMBIN_NIH_SOYBEAN_TRYPSIN_INHIBITOR_L2_CODE = "FDP";

    /**
     * EN: Code for Thrombocyte (platelet).<br>
     */
    public static final String THROMBOCYTE_PLATELET_L1_CODE = "THRB";

    /**
     * EN: Code for Thymol.<br>
     */
    public static final String THYMOL_L1_CODE = "THYMOL";

    /**
     * EN: Code for Thymol.<br>
     */
    public static final String THYMOL_L2_CODE = "THYMOL";

    /**
     * EN: Code for Thyoglycolate broth.<br>
     */
    public static final String THYOGLYCOLATE_BROTH_L1_CODE = "THYO";

    /**
     * EN: Code for Thyoglycolate broth.<br>
     */
    public static final String THYOGLYCOLATE_BROTH_L2_CODE = "THYO";

    /**
     * EN: Code for Tin.<br>
     */
    public static final String TIN_L4_CODE = "TIN";

    /**
     * EN: Code for Tin.<br>
     */
    public static final String TIN_L5_CODE = "TIN";

    /**
     * EN: Code for Tissue gall bladder.<br>
     */
    public static final String TISSUE_GALL_BLADDER_L1_CODE = "TISG";

    /**
     * EN: Code for Tissue large intestine.<br>
     */
    public static final String TISSUE_LARGE_INTESTINE_L1_CODE = "TLGI";

    /**
     * EN: Code for Tissue lung.<br>
     */
    public static final String TISSUE_LUNG_L1_CODE = "TLNG";

    /**
     * EN: Code for Tissue placenta.<br>
     */
    public static final String TISSUE_PLACENTA_L1_CODE = "TISPL";

    /**
     * EN: Code for Tissue small intestine Tissue ulcer.<br>
     */
    public static final String TISSUE_SMALL_INTESTINE_TISSUE_ULCER_L1_CODE = "TSMI";

    /**
     * EN: Code for Tissue ulcer.<br>
     */
    public static final String TISSUE_ULCER_L1_CODE = "TISU";

    /**
     * EN: Code for Tissue, unspecified.<br>
     */
    public static final String TISSUE_UNSPECIFIED_L1_CODE = "TISS";

    /**
     * EN: Code for Toluene.<br>
     */
    public static final String TOLUENE_L1_CODE = "TOLU";

    /**
     * EN: Code for Toluene.<br>
     */
    public static final String TOLUENE_L2_CODE = "TOLU";

    /**
     * EN: Code for Tube.<br>
     */
    public static final String TUBE_L4_CODE = "TUBE";

    /**
     * EN: Code for Tube.<br>
     */
    public static final String TUBE_L5_CODE = "TUBE";

    /**
     * EN: Code for Tube, unspecified.<br>
     */
    public static final String TUBE_UNSPECIFIED_L1_CODE = "TUB";

    /**
     * EN: Code for Tub.<br>
     */
    public static final String TUB_L4_CODE = "TUB";

    /**
     * EN: Code for Tub.<br>
     */
    public static final String TUB_L5_CODE = "TUB";

    /**
     * EN: Code for Turbuhaler.<br>
     */
    public static final String TURBUHALER_L3_CODE = "TRBINH";

    /**
     * EN: Code for Turbuhaler.<br>
     */
    public static final String TURBUHALER_L4_CODE = "TRBINH";

    /**
     * EN: Code for Ulcer.<br>
     */
    public static final String ULCER_L1_CODE = "ULC";

    /**
     * EN: Code for Umbilical blood.<br>
     */
    public static final String UMBILICAL_BLOOD_L1_CODE = "UMB";

    /**
     * EN: Code for Unknown medicine.<br>
     */
    public static final String UNKNOWN_MEDICINE_L1_CODE = "UMED";

    /**
     * EN: Code for Unknown substance.<br>
     */
    public static final String UNKNOWN_SUBSTANCE_L1_CODE = "USUB";

    /**
     * EN: Code for Ureaplasma transport medium.<br>
     */
    public static final String UREAPLASMA_TRANSPORT_MEDIUM_L1_CODE = "URETM";

    /**
     * EN: Code for Ureaplasma transport medium.<br>
     */
    public static final String UREAPLASMA_TRANSPORT_MEDIUM_L2_CODE = "URETM";

    /**
     * EN: Code for Urethra.<br>
     */
    public static final String URETHRA_L1_CODE = "URTH";

    /**
     * EN: Code for Urine catheter.<br>
     */
    public static final String URINE_CATHETER_L1_CODE = "URT";

    /**
     * EN: Code for Urine clean catch.<br>
     */
    public static final String URINE_CLEAN_CATCH_L1_CODE = "URC";

    /**
     * EN: Code for Urine.<br>
     */
    public static final String URINE_L1_CODE = "UR";

    /**
     * EN: Code for Urine sediment.<br>
     */
    public static final String URINE_SEDIMENT_L1_CODE = "URNS";

    /**
     * EN: Code for Vaccine.<br>
     */
    public static final String VACCINE_CODE = "VCCNE";

    /**
     * EN: Code for Vaccine.<br>
     */
    public static final String VACCINE_L1_CODE = "VCCNE";

    /**
     * EN: Code for Vial.<br>
     */
    public static final String VIAL_L4_CODE = "VIAL";

    /**
     * EN: Code for Vial.<br>
     */
    public static final String VIAL_L5_CODE = "VIAL";

    /**
     * EN: Code for Viral Transport medium.<br>
     */
    public static final String VIRAL_TRANSPORT_MEDIUM_L1_CODE = "VIRTM";

    /**
     * EN: Code for Viral Transport medium.<br>
     */
    public static final String VIRAL_TRANSPORT_MEDIUM_L2_CODE = "VIRTM";

    /**
     * EN: Code for Vomitus.<br>
     */
    public static final String VOMITUS_L1_CODE = "VOM";

    /**
     * EN: Code for Water.<br>
     */
    public static final String WATER_L1_CODE = "WAT";

    /**
     * EN: Code for Whole blood.<br>
     */
    public static final String WHOLE_BLOOD_L1_CODE = "BLD";

    /**
     * EN: Code for Whole body.<br>
     */
    public static final String WHOLE_BODY_L1_CODE = "BDY";

    /**
     * EN: Code for Wick.<br>
     */
    public static final String WICK_L1_CODE = "WICK";

    /**
     * EN: Code for Wing Location.<br>
     */
    public static final String WING_LOCATION_L1_CODE = "WING";

    /**
     * EN: Code for Wound abscess.<br>
     */
    public static final String WOUND_ABSCESS_L1_CODE = "WNDA";

    /**
     * EN: Code for Wound drainage.<br>
     */
    public static final String WOUND_DRAINAGE_L1_CODE = "WNDD";

    /**
     * EN: Code for Wound exudate.<br>
     */
    public static final String WOUND_EXUDATE_L1_CODE = "WNDE";

    /**
     * EN: Code for Wound.<br>
     */
    public static final String WOUND_L1_CODE = "WND";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.16040";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "EntityCode";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.1060";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static EntityCode getEnum(@Nullable final String code) {
        for (final EntityCode x : values()) {
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
            Enum.valueOf(EntityCode.class,
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
        for (final EntityCode x : values()) {
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
    EntityCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
