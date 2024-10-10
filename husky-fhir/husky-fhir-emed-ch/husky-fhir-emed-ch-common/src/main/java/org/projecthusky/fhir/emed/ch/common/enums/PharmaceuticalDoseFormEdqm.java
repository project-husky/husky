/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.common.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

/**
 * Enumeration of PharmaceuticalDoseFormEDQM values
 * <p>
 * EN: Valueset Pharmaceutical Dose Form from EDQM, PDF, export20.5.2021, see https://standardterms.edqm.eu/#.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.11.3<br>
 * Effective date: 2024-01-30 14:03<br>
 * Version: 2024<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-07-18")
public enum PharmaceuticalDoseFormEdqm implements ValueSetEnumInterface, FhirValueSetEnumInterface {

    /**
     * EN: Anticoagulant and preservative solution for blood.<br>
     * DE: Stabilisatorlösung für Blutkonserven.<br>
     * FR: Solution anticoagulante et de conservation du sang humain.<br>
     * IT: Soluzione anticoagulante e conservante per il sangue.<br>
     */
    ANTICOAGULANT_AND_PRESERVATIVE_SOLUTION_FOR_BLOOD("12102000",
                                                      "0.4.0.127.0.16.1.1.2.1",
                                                      "Anticoagulant and preservative solution for blood",
                                                      "Anticoagulant and preservative solution for blood",
                                                      "Stabilisatorlösung für Blutkonserven",
                                                      "Solution anticoagulante et de conservation du sang humain",
                                                      "Soluzione anticoagulante e conservante per il sangue"),
    /**
     * EN: Bath additive.<br>
     * DE: Badezusatz.<br>
     * FR: Adjuvant de bain.<br>
     * IT: Additivo per bagno.<br>
     */
    BATH_ADDITIVE("10501000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Bath additive",
                  "Bath additive",
                  "Badezusatz",
                  "Adjuvant de bain",
                  "Additivo per bagno"),
    /**
     * EN: Bladder irrigation.<br>
     * DE: Blasenspüllösung.<br>
     * FR: Solution pour irrigation vésicale.<br>
     * IT: Irrigazione vescicale.<br>
     */
    BLADDER_IRRIGATION("11502000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Bladder irrigation",
                       "Bladder irrigation",
                       "Blasenspüllösung",
                       "Solution pour irrigation vésicale",
                       "Irrigazione vescicale"),
    /**
     * EN: Buccal film.<br>
     * DE: Buccalfilm.<br>
     * FR: Film buccogingival.<br>
     * IT: Film orosolubile.<br>
     */
    BUCCAL_FILM("10314011",
                "0.4.0.127.0.16.1.1.2.1",
                "Buccal film",
                "Buccal film",
                "Buccalfilm",
                "Film buccogingival",
                "Film orosolubile"),
    /**
     * EN: Buccal tablet.<br>
     * DE: Buccaltablette.<br>
     * FR: Comprimé buccogingival.<br>
     * IT: Compressa orosolubile.<br>
     */
    BUCCAL_TABLET("10320000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Buccal tablet",
                  "Buccal tablet",
                  "Buccaltablette",
                  "Comprimé buccogingival",
                  "Compressa orosolubile"),
    /**
     * EN: Cachet.<br>
     * DE: Oblatenkapsel.<br>
     * FR: Cachet.<br>
     * IT: Cachet.<br>
     */
    CACHET("10209000",
           "0.4.0.127.0.16.1.1.2.1",
           "Cachet",
           "Cachet",
           "Oblatenkapsel",
           "Cachet",
           "Cachet"),
    /**
     * EN: Capsule, hard.<br>
     * DE: Hartkapsel.<br>
     * FR: Gélule.<br>
     * IT: Capsula rigida.<br>
     */
    CAPSULE_HARD("10210000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Capsule, hard",
                 "Capsule, hard",
                 "Hartkapsel",
                 "Gélule",
                 "Capsula rigida"),
    /**
     * EN: Capsule, soft.<br>
     * DE: Weichkapsel.<br>
     * FR: Capsule molle.<br>
     * IT: Capsula molle.<br>
     */
    CAPSULE_SOFT("10211000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Capsule, soft",
                 "Capsule, soft",
                 "Weichkapsel",
                 "Capsule molle",
                 "Capsula molle"),
    /**
     * EN: Chewable capsule, soft.<br>
     * DE: Weichkapsel zum Zerbeißen.<br>
     * FR: Capsule molle à mâcher.<br>
     * IT: Capsula molle masticabile.<br>
     */
    CHEWABLE_CAPSULE_SOFT("10214000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Chewable capsule, soft",
                          "Chewable capsule, soft",
                          "Weichkapsel zum Zerbeißen",
                          "Capsule molle à mâcher",
                          "Capsula molle masticabile"),
    /**
     * EN: Chewable/dispersible tablet.<br>
     * DE: Kautablette/Tablette zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Comprimé dispersible / à croquer.<br>
     * IT: Compressa masticabile/dispersibile.<br>
     */
    CHEWABLE_DISPERSIBLE_TABLET("50001000",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Chewable/dispersible tablet",
                                "Chewable/dispersible tablet",
                                "Kautablette/Tablette zur Herstellung einer Suspension zum Einnehmen",
                                "Comprimé dispersible / à croquer",
                                "Compressa masticabile/dispersibile"),
    /**
     * EN: Chewable tablet.<br>
     * DE: Kautablette.<br>
     * FR: Comprimé à croquer.<br>
     * IT: Compressa masticabile.<br>
     */
    CHEWABLE_TABLET("10228000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Chewable tablet",
                    "Chewable tablet",
                    "Kautablette",
                    "Comprimé à croquer",
                    "Compressa masticabile"),
    /**
     * EN: Coated granules.<br>
     * DE: Überzogenes Granulat.<br>
     * FR: Granulés enrobés.<br>
     * IT: Granulato rivestito.<br>
     */
    COATED_GRANULES("13046000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Coated granules",
                    "Coated granules",
                    "Überzogenes Granulat",
                    "Granulés enrobés",
                    "Granulato rivestito"),
    /**
     * EN: Coated tablet.<br>
     * DE: überzogene Tablette.<br>
     * FR: Comprimé enrobé.<br>
     * IT: Compressa rivestita.<br>
     */
    COATED_TABLET("10220000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Coated tablet",
                  "Coated tablet",
                  "überzogene Tablette",
                  "Comprimé enrobé",
                  "Compressa rivestita"),
    /**
     * EN: Collodion.<br>
     * DE: filmbildende Flüssigkeit.<br>
     * FR: Collodion.<br>
     * IT: Collodio.<br>
     */
    COLLODION("10520000",
              "0.4.0.127.0.16.1.1.2.1",
              "Collodion",
              "Collodion",
              "filmbildende Flüssigkeit",
              "Collodion",
              "Collodio"),
    /**
     * EN: Compressed lozenge.<br>
     * DE: Lutschtablette, gepresst.<br>
     * FR: Comprimé à sucer.<br>
     * IT: Pastiglia.<br>
     */
    COMPRESSED_LOZENGE("10322000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Compressed lozenge",
                       "Compressed lozenge",
                       "Lutschtablette, gepresst",
                       "Comprimé à sucer",
                       "Pastiglia"),
    /**
     * EN: Concentrate for concentrate for solution for infusion.<br>
     * DE: Konzentrat für ein Konzentrat zur Herstellung einer Infusionslösung.<br>
     * FR: Gaz médicinal liquéfié.<br>
     * IT: Concentrato per concentrato per soluzione per infusione.<br>
     */
    CONCENTRATE_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INFUSION("13001000",
                                                          "0.4.0.127.0.16.1.1.2.1",
                                                          "Concentrate for concentrate for solution for infusion",
                                                          "Concentrate for concentrate for solution for infusion",
                                                          "Konzentrat für ein Konzentrat zur Herstellung einer Infusionslösung",
                                                          "Gaz médicinal liquéfié",
                                                          "Concentrato per concentrato per soluzione per infusione"),
    /**
     * EN: Concentrate for cutaneous solution.<br>
     * DE: Konzentrat zur Herstellung einer Lösung zur Anwendung auf der Haut.<br>
     * FR: Solution à diluer pour solution cutanée.<br>
     * IT: Concentrato per soluzione cutanea.<br>
     */
    CONCENTRATE_FOR_CUTANEOUS_SOLUTION("10514000",
                                       "0.4.0.127.0.16.1.1.2.1",
                                       "Concentrate for cutaneous solution",
                                       "Concentrate for cutaneous solution",
                                       "Konzentrat zur Herstellung einer Lösung zur Anwendung auf der Haut",
                                       "Solution à diluer pour solution cutanée",
                                       "Concentrato per soluzione cutanea"),
    /**
     * EN: Concentrate for cutaneous spray, emulsion.<br>
     * DE: Konzentrat zur Herstellung eines Sprays zur Anwendung auf der Haut, Emulsion.<br>
     * FR: Solution à diluer pour émulsion pour pulvérisation cutanée.<br>
     * IT: Concentrato per spray cutaneo, emulsione.<br>
     */
    CONCENTRATE_FOR_CUTANEOUS_SPRAY_EMULSION("50009000",
                                             "0.4.0.127.0.16.1.1.2.1",
                                             "Concentrate for cutaneous spray, emulsion",
                                             "Concentrate for cutaneous spray, emulsion",
                                             "Konzentrat zur Herstellung eines Sprays zur Anwendung auf der Haut, Emulsion",
                                             "Solution à diluer pour émulsion pour pulvérisation cutanée",
                                             "Concentrato per spray cutaneo, emulsione"),
    /**
     * EN: Concentrate for dispersion for infusion.<br>
     * DE: Konzentrat zur Herstellung einer Infusionsdispersion.<br>
     * FR: Dispersion à diluer pour perfusion.<br>
     * IT: Concentrato per dispersione per infusione.<br>
     */
    CONCENTRATE_FOR_DISPERSION_FOR_INFUSION("50009300",
                                            "0.4.0.127.0.16.1.1.2.1",
                                            "Concentrate for dispersion for infusion",
                                            "Concentrate for dispersion for infusion",
                                            "Konzentrat zur Herstellung einer Infusionsdispersion",
                                            "Dispersion à diluer pour perfusion",
                                            "Concentrato per dispersione per infusione"),
    /**
     * EN: Concentrate for dispersion for injection.<br>
     * DE: Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Dispersion à diluer pour dispersion injectable.<br>
     * IT: Larva medicinale.<br>
     */
    CONCENTRATE_FOR_DISPERSION_FOR_INJECTION("13139000",
                                             "0.4.0.127.0.16.1.1.2.1",
                                             "Concentrate for dispersion for injection",
                                             "Concentrate for dispersion for injection",
                                             "Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen",
                                             "Dispersion à diluer pour dispersion injectable",
                                             "Larva medicinale"),
    /**
     * EN: Concentrate for emulsion for infusion.<br>
     * DE: Konzentrat zur Herstellung einer Emulsion zur Infusion.<br>
     * FR: Emulsion à diluer pour perfusion.<br>
     * IT: Concentrato per emulsione per infusione.<br>
     */
    CONCENTRATE_FOR_EMULSION_FOR_INFUSION("50009500",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Concentrate for emulsion for infusion",
                                          "Concentrate for emulsion for infusion",
                                          "Konzentrat zur Herstellung einer Emulsion zur Infusion",
                                          "Emulsion à diluer pour perfusion",
                                          "Concentrato per emulsione per infusione"),
    /**
     * EN: Concentrate for gargle.<br>
     * DE: Konzentrat zur Herstellung einer Gurgellösung.<br>
     * FR: Solution à diluer pour gargarisme.<br>
     * IT: Concentrato per soluzione per gargarismi.<br>
     */
    CONCENTRATE_FOR_GARGLE("10302000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Concentrate for gargle",
                           "Concentrate for gargle",
                           "Konzentrat zur Herstellung einer Gurgellösung",
                           "Solution à diluer pour gargarisme",
                           "Concentrato per soluzione per gargarismi"),
    /**
     * EN: Concentrate for intravesical solution.<br>
     * DE: Konzentrat zur Herstellung einer Lösung zur intravesikalen Anwendung.<br>
     * FR: Solution à diluer pour solution intravésicale.<br>
     * IT: Concentrato per soluzione endovescicale.<br>
     */
    CONCENTRATE_FOR_INTRAVESICAL_SOLUTION("50009750",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Concentrate for intravesical solution",
                                          "Concentrate for intravesical solution",
                                          "Konzentrat zur Herstellung einer Lösung zur intravesikalen Anwendung",
                                          "Solution à diluer pour solution intravésicale",
                                          "Concentrato per soluzione endovescicale"),
    /**
     * EN: Concentrate for nebuliser solution.<br>
     * DE: Konzentrat zur Herstellung einer Lösung für einen Vernebler.<br>
     * FR: Solution à diluer pour inhalation par nébuliseur.<br>
     * IT: Concentrato per soluzione per nebulizzatore.<br>
     */
    CONCENTRATE_FOR_NEBULISER_SOLUTION("13002000",
                                       "0.4.0.127.0.16.1.1.2.1",
                                       "Concentrate for nebuliser solution",
                                       "Concentrate for nebuliser solution",
                                       "Konzentrat zur Herstellung einer Lösung für einen Vernebler",
                                       "Solution à diluer pour inhalation par nébuliseur",
                                       "Concentrato per soluzione per nebulizzatore"),
    /**
     * EN: Concentrate for oral/rectal solution.<br>
     * DE: Konzentrat zur Herstellung einer Lösung zum Einnehmen /Rektallösung.<br>
     * FR: Solution à diluer pour solution orale/rectale.<br>
     * IT: Concentrato per soluzione orale/rettale.<br>
     */
    CONCENTRATE_FOR_ORAL_RECTAL_SOLUTION("50011000",
                                         "0.4.0.127.0.16.1.1.2.1",
                                         "Concentrate for oral/rectal solution",
                                         "Concentrate for oral/rectal solution",
                                         "Konzentrat zur Herstellung einer Lösung zum Einnehmen /Rektallösung",
                                         "Solution à diluer pour solution orale/rectale",
                                         "Concentrato per soluzione orale/rettale"),
    /**
     * EN: Concentrate for oral solution.<br>
     * DE: Konzentrat zur Herstellung einer Lösung  zum Einnehmen.<br>
     * FR: Solution à diluer pour solution buvable.<br>
     * IT: Concentrato per soluzione orale.<br>
     */
    CONCENTRATE_FOR_ORAL_SOLUTION("50010000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Concentrate for oral solution",
                                  "Concentrate for oral solution",
                                  "Konzentrat zur Herstellung einer Lösung  zum Einnehmen",
                                  "Solution à diluer pour solution buvable",
                                  "Concentrato per soluzione orale"),
    /**
     * EN: Concentrate for oral suspension.<br>
     * DE: Konzentrat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Suspension à diluer pour suspension buvable.<br>
     * IT: Concentrato per sospensione orale.<br>
     */
    CONCENTRATE_FOR_ORAL_SUSPENSION("10100500",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Concentrate for oral suspension",
                                    "Concentrate for oral suspension",
                                    "Konzentrat zur Herstellung einer Suspension zum Einnehmen",
                                    "Suspension à diluer pour suspension buvable",
                                    "Concentrato per sospensione orale"),
    /**
     * EN: Concentrate for oromucosal solution.<br>
     * DE: Konzentrat zur Herstellung einer Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Solution à diluer buccale.<br>
     * IT: Concentrato per soluzione per mucosa orale.<br>
     */
    CONCENTRATE_FOR_OROMUCOSAL_SOLUTION("13003000",
                                        "0.4.0.127.0.16.1.1.2.1",
                                        "Concentrate for oromucosal solution",
                                        "Concentrate for oromucosal solution",
                                        "Konzentrat zur Herstellung einer Lösung zur Anwendung in der Mundhöhle",
                                        "Solution à diluer buccale",
                                        "Concentrato per soluzione per mucosa orale"),
    /**
     * EN: Concentrate for rectal solution.<br>
     * DE: Konzentrat zur Herstellung einer Rektallösung.<br>
     * FR: Solution rectale à diluer.<br>
     * IT: Concentrato per soluzione rettale.<br>
     */
    CONCENTRATE_FOR_RECTAL_SOLUTION("11008000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Concentrate for rectal solution",
                                    "Concentrate for rectal solution",
                                    "Konzentrat zur Herstellung einer Rektallösung",
                                    "Solution rectale à diluer",
                                    "Concentrato per soluzione rettale"),
    /**
     * EN: Concentrate for solution for haemodialysis.<br>
     * DE: Konzentrat zur Herstellung einer Hämodialyselösung.<br>
     * FR: Solution à diluer pour hémodialyse.<br>
     * IT: Soluzione concentrata per emodialisi.<br>
     */
    CONCENTRATE_FOR_SOLUTION_FOR_HAEMODIALYSIS("11405000",
                                               "0.4.0.127.0.16.1.1.2.1",
                                               "Concentrate for solution for haemodialysis",
                                               "Concentrate for solution for haemodialysis",
                                               "Konzentrat zur Herstellung einer Hämodialyselösung",
                                               "Solution à diluer pour hémodialyse",
                                               "Soluzione concentrata per emodialisi"),
    /**
     * EN: Concentrate for solution for infusion.<br>
     * DE: Konzentrat zur Herstellung einer Infusionslösung.<br>
     * FR: Solution à diluer pour perfusion.<br>
     * IT: Concentrato per soluzione per infusione.<br>
     */
    CONCENTRATE_FOR_SOLUTION_FOR_INFUSION("11213000",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Concentrate for solution for infusion",
                                          "Concentrate for solution for infusion",
                                          "Konzentrat zur Herstellung einer Infusionslösung",
                                          "Solution à diluer pour perfusion",
                                          "Concentrato per soluzione per infusione"),
    /**
     * EN: Concentrate for solution for injection.<br>
     * DE: Konzentrat zur Herstellung einer Injektionslösung.<br>
     * FR: Solution à diluer injectable.<br>
     * IT: Concentrato per soluzione iniettabile.<br>
     */
    CONCENTRATE_FOR_SOLUTION_FOR_INJECTION("11209000",
                                           "0.4.0.127.0.16.1.1.2.1",
                                           "Concentrate for solution for injection",
                                           "Concentrate for solution for injection",
                                           "Konzentrat zur Herstellung einer Injektionslösung",
                                           "Solution à diluer injectable",
                                           "Concentrato per soluzione iniettabile"),
    /**
     * EN: Concentrate for solution for injection/infusion.<br>
     * DE: Konzentrat zur Herstellung einer Injektions- /Infusionslösung.<br>
     * FR: Solution à diluer pour solution injectable/pour perfusion.<br>
     * IT: Concentrato per soluzione iniettabile/ per infusione.<br>
     */
    CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_INFUSION("50079000",
                                                    "0.4.0.127.0.16.1.1.2.1",
                                                    "Concentrate for solution for injection/infusion",
                                                    "Concentrate for solution for injection/infusion",
                                                    "Konzentrat zur Herstellung einer Injektions- /Infusionslösung",
                                                    "Solution à diluer pour solution injectable/pour perfusion",
                                                    "Concentrato per soluzione iniettabile/ per infusione"),
    /**
     * EN: Concentrate for solution for intraocular irrigation.<br>
     * DE: Konzentrat zur Herstellung einer Lösung zur intraokularen Anwendung.<br>
     * FR: Solution à diluer pour solution pour irrigation intraoculaire.<br>
     * IT: Concentrato per soluzione per irrigazione intraoculare.<br>
     */
    CONCENTRATE_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION("10600500",
                                                        "0.4.0.127.0.16.1.1.2.1",
                                                        "Concentrate for solution for intraocular irrigation",
                                                        "Concentrate for solution for intraocular irrigation",
                                                        "Konzentrat zur Herstellung einer Lösung zur intraokularen Anwendung",
                                                        "Solution à diluer pour solution pour irrigation intraoculaire",
                                                        "Concentrato per soluzione per irrigazione intraoculare"),
    /**
     * EN: Concentrate for solution for peritoneal dialysis.<br>
     * DE: Konzentrat zur Herstellung einer Peritonealdialyselösung.<br>
     * FR: Solution à diluer pour solution pour dialyse péritonéale.<br>
     * IT: Concentrato per soluzione per dialisi peritoneale.<br>
     */
    CONCENTRATE_FOR_SOLUTION_FOR_PERITONEAL_DIALYSIS("50013250",
                                                     "0.4.0.127.0.16.1.1.2.1",
                                                     "Concentrate for solution for peritoneal dialysis",
                                                     "Concentrate for solution for peritoneal dialysis",
                                                     "Konzentrat zur Herstellung einer Peritonealdialyselösung",
                                                     "Solution à diluer pour solution pour dialyse péritonéale",
                                                     "Concentrato per soluzione per dialisi peritoneale"),
    /**
     * EN: Concentrate for suspension for injection.<br>
     * DE: Konzentrat zur Herstellung einer Injektionssuspension.<br>
     * FR: Suspension à diluer injectable.<br>
     * IT: Concentrato per sospensione iniettabile.<br>
     */
    CONCENTRATE_FOR_SUSPENSION_FOR_INJECTION("13004000",
                                             "0.4.0.127.0.16.1.1.2.1",
                                             "Concentrate for suspension for injection",
                                             "Concentrate for suspension for injection",
                                             "Konzentrat zur Herstellung einer Injektionssuspension",
                                             "Suspension à diluer injectable",
                                             "Concentrato per sospensione iniettabile"),
    /**
     * EN: Cream.<br>
     * DE: Creme.<br>
     * FR: Crème.<br>
     * IT: Crema.<br>
     */
    CREAM("10502000",
          "0.4.0.127.0.16.1.1.2.1",
          "Cream",
          "Cream",
          "Creme",
          "Crème",
          "Crema"),
    /**
     * EN: Cutaneous emulsion.<br>
     * DE: Emulsion zur Anwendung auf der Haut.<br>
     * FR: Emulsion cutanée.<br>
     * IT: Emulsione cutanea.<br>
     */
    CUTANEOUS_EMULSION("10516000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Cutaneous emulsion",
                       "Cutaneous emulsion",
                       "Emulsion zur Anwendung auf der Haut",
                       "Emulsion cutanée",
                       "Emulsione cutanea"),
    /**
     * EN: Cutaneous foam.<br>
     * DE: Schaum zur  Anwendung auf der Haut.<br>
     * FR: Mousse cutanée.<br>
     * IT: Schiuma cutanea.<br>
     */
    CUTANEOUS_FOAM("10507000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Cutaneous foam",
                   "Cutaneous foam",
                   "Schaum zur  Anwendung auf der Haut",
                   "Mousse cutanée",
                   "Schiuma cutanea"),
    /**
     * EN: Cutaneous liquid.<br>
     * DE: Flüssigkeit zur Anwendung auf der Haut.<br>
     * FR: Liquide cutané.<br>
     * IT: Liquido cutaneo.<br>
     */
    CUTANEOUS_LIQUID("10512000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Cutaneous liquid",
                     "Cutaneous liquid",
                     "Flüssigkeit zur Anwendung auf der Haut",
                     "Liquide cutané",
                     "Liquido cutaneo"),
    /**
     * EN: Cutaneous/nasal ointment.<br>
     * DE: Salbe zur Anwendung auf der Haut/Nasensalbe.<br>
     * FR: Pommade cutanée/ nasale.<br>
     * IT: Unguento cutaneo/nasale.<br>
     */
    CUTANEOUS_NASAL_OINTMENT("50015200",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Cutaneous/nasal ointment",
                             "Cutaneous/nasal ointment",
                             "Salbe zur Anwendung auf der Haut/Nasensalbe",
                             "Pommade cutanée/ nasale",
                             "Unguento cutaneo/nasale"),
    /**
     * EN: Cutaneous/oromucosal solution.<br>
     * DE: Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Dispersion à diluer pour dispersion injectable.<br>
     * IT: Larva medicinale.<br>
     */
    CUTANEOUS_OROMUCOSAL_SOLUTION("13140000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Cutaneous/oromucosal solution",
                                  "Cutaneous/oromucosal solution",
                                  "Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen",
                                  "Dispersion à diluer pour dispersion injectable",
                                  "Larva medicinale"),
    /**
     * EN: Cutaneous paste.<br>
     * DE: Paste zur Anwendung auf der Haut.<br>
     * FR: Pâte cutanée.<br>
     * IT: Pasta cutanea.<br>
     */
    CUTANEOUS_PASTE("10505000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Cutaneous paste",
                    "Cutaneous paste",
                    "Paste zur Anwendung auf der Haut",
                    "Pâte cutanée",
                    "Pasta cutanea"),
    /**
     * EN: Cutaneous patch.<br>
     * DE: Kutanes Pflaster.<br>
     * FR: Patch cutané.<br>
     * IT: Cerotto cutaneo.<br>
     */
    CUTANEOUS_PATCH("10517500",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Cutaneous patch",
                    "Cutaneous patch",
                    "Kutanes Pflaster",
                    "Patch cutané",
                    "Cerotto cutaneo"),
    /**
     * EN: Cutaneous powder.<br>
     * DE: Pulver zur Anwendung auf der Haut.<br>
     * FR: Poudre pour application cutanée.<br>
     * IT: Polvere cutanea.<br>
     */
    CUTANEOUS_POWDER("10517000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Cutaneous powder",
                     "Cutaneous powder",
                     "Pulver zur Anwendung auf der Haut",
                     "Poudre pour application cutanée",
                     "Polvere cutanea"),
    /**
     * EN: Cutaneous solution.<br>
     * DE: Lösung zur Anwendung auf der Haut.<br>
     * FR: Solution pour application cutanée.<br>
     * IT: Soluzione cutanea.<br>
     */
    CUTANEOUS_SOLUTION("10513000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Cutaneous solution",
                       "Cutaneous solution",
                       "Lösung zur Anwendung auf der Haut",
                       "Solution pour application cutanée",
                       "Soluzione cutanea"),
    /**
     * EN: Cutaneous solution/concentrate for oromucosal solution.<br>
     * DE: Lösung zur Anwendung auf der Haut/Konzentrat zur Herstellung einer Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Solution cutanée/ solution à diluer buccale.<br>
     * IT: Soluzione cutanea/concentrato per soluzione per mucosa orale.<br>
     */
    CUTANEOUS_SOLUTION_CONCENTRATE_FOR_OROMUCOSAL_SOLUTION("50015450",
                                                           "0.4.0.127.0.16.1.1.2.1",
                                                           "Cutaneous solution/concentrate for oromucosal solution",
                                                           "Cutaneous solution/concentrate for oromucosal solution",
                                                           "Lösung zur Anwendung auf der Haut/Konzentrat zur Herstellung einer Lösung zur Anwendung in der Mundhöhle",
                                                           "Solution cutanée/ solution à diluer buccale",
                                                           "Soluzione cutanea/concentrato per soluzione per mucosa orale"),
    /**
     * EN: Cutaneous spray, emulsion.<br>
     * DE: Spray zur Anwendung auf der Haut, Emulsion.<br>
     * FR: Émulsion pour pulvérisation cutanée.<br>
     * IT: Spray cutaneo, emulsione.<br>
     */
    CUTANEOUS_SPRAY_EMULSION("50015500",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Cutaneous spray, emulsion",
                             "Cutaneous spray, emulsion",
                             "Spray zur Anwendung auf der Haut, Emulsion",
                             "Émulsion pour pulvérisation cutanée",
                             "Spray cutaneo, emulsione"),
    /**
     * EN: Cutaneous spray, ointment.<br>
     * DE: Spray zur Anwendung auf der Haut, Salbe.<br>
     * FR: Pommade pour pulvérisation cutanée.<br>
     * IT: Spray cutaneo, unguento.<br>
     */
    CUTANEOUS_SPRAY_OINTMENT("50016000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Cutaneous spray, ointment",
                             "Cutaneous spray, ointment",
                             "Spray zur Anwendung auf der Haut, Salbe",
                             "Pommade pour pulvérisation cutanée",
                             "Spray cutaneo, unguento"),
    /**
     * EN: Cutaneous spray, powder.<br>
     * DE: Pulver-Spray zur Anwendung auf der Haut.<br>
     * FR: Poudre pour pulvérisation cutanée.<br>
     * IT: Spray cutaneo, polvere.<br>
     */
    CUTANEOUS_SPRAY_POWDER("10511000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Cutaneous spray, powder",
                           "Cutaneous spray, powder",
                           "Pulver-Spray zur Anwendung auf der Haut",
                           "Poudre pour pulvérisation cutanée",
                           "Spray cutaneo, polvere"),
    /**
     * EN: Cutaneous spray, solution.<br>
     * DE: Spray zur Anwendung auf der Haut, Lösung.<br>
     * FR: Solution pour pulvérisation cutanée.<br>
     * IT: Spray cutaneo, soluzione.<br>
     */
    CUTANEOUS_SPRAY_SOLUTION("10509000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Cutaneous spray, solution",
                             "Cutaneous spray, solution",
                             "Spray zur Anwendung auf der Haut, Lösung",
                             "Solution pour pulvérisation cutanée",
                             "Spray cutaneo, soluzione"),
    /**
     * EN: Cutaneous spray, suspension.<br>
     * DE: Spray zur Anwendung auf der Haut, Suspension.<br>
     * FR: Suspension pour pulvérisation cutanée.<br>
     * IT: Spray cutaneo, sospensione.<br>
     */
    CUTANEOUS_SPRAY_SUSPENSION("10510000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Cutaneous spray, suspension",
                               "Cutaneous spray, suspension",
                               "Spray zur Anwendung auf der Haut, Suspension",
                               "Suspension pour pulvérisation cutanée",
                               "Spray cutaneo, sospensione"),
    /**
     * EN: Cutaneous stick.<br>
     * DE: Stift zur Anwendung auf der Haut.<br>
     * FR: Bâton pour application cutanée.<br>
     * IT: Matita cutanea.<br>
     */
    CUTANEOUS_STICK("10523000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Cutaneous stick",
                    "Cutaneous stick",
                    "Stift zur Anwendung auf der Haut",
                    "Bâton pour application cutanée",
                    "Matita cutanea"),
    /**
     * EN: Cutaneous suspension.<br>
     * DE: Suspension zur Anwendung auf der Haut.<br>
     * FR: Suspension pour application cutanée.<br>
     * IT: Sospensione cutanea.<br>
     */
    CUTANEOUS_SUSPENSION("10515000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Cutaneous suspension",
                         "Cutaneous suspension",
                         "Suspension zur Anwendung auf der Haut",
                         "Suspension pour application cutanée",
                         "Sospensione cutanea"),
    /**
     * EN: Dental cement.<br>
     * DE: Dentalzement.<br>
     * FR: Ciment dentaire.<br>
     * IT: Polvere periodontale.<br>
     */
    DENTAL_CEMENT("10401500",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Dental cement",
                  "Dental cement",
                  "Dentalzement",
                  "Ciment dentaire",
                  "Polvere periodontale"),
    /**
     * EN: Dental emulsion.<br>
     * DE: Dentalemulsion.<br>
     * FR: Emulsion dentaire.<br>
     * IT: Emulsione dentale.<br>
     */
    DENTAL_EMULSION("10408000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Dental emulsion",
                    "Dental emulsion",
                    "Dentalemulsion",
                    "Emulsion dentaire",
                    "Emulsione dentale"),
    /**
     * EN: Dental gel.<br>
     * DE: Dentalgel.<br>
     * FR: Gel dentaire.<br>
     * IT: Gel dentale.<br>
     */
    DENTAL_GEL("10402000",
               "0.4.0.127.0.16.1.1.2.1",
               "Dental gel",
               "Dental gel",
               "Dentalgel",
               "Gel dentaire",
               "Gel dentale"),
    /**
     * EN: Dental paste.<br>
     * DE: Dentalpaste.<br>
     * FR: Pâte dentaire.<br>
     * IT: Spray cutaneo, unguento.<br>
     */
    DENTAL_PASTE("50017000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Dental paste",
                 "Dental paste",
                 "Dentalpaste",
                 "Pâte dentaire",
                 "Spray cutaneo, unguento"),
    /**
     * EN: Dental powder.<br>
     * DE: Dentalpulver.<br>
     * FR: Poudre dentaire.<br>
     * IT: Polvere dentale.<br>
     */
    DENTAL_POWDER("10405000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Dental powder",
                  "Dental powder",
                  "Dentalpulver",
                  "Poudre dentaire",
                  "Polvere dentale"),
    /**
     * EN: Dental solution.<br>
     * DE: Dentallösung.<br>
     * FR: Solution dentaire.<br>
     * IT: Soluzione dentale.<br>
     */
    DENTAL_SOLUTION("10406000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Dental solution",
                    "Dental solution",
                    "Dentallösung",
                    "Solution dentaire",
                    "Soluzione dentale"),
    /**
     * EN: Dental stick.<br>
     * DE: Dentalstift.<br>
     * FR: Bâton dentaire.<br>
     * IT: Bastoncino dentale.<br>
     */
    DENTAL_STICK("10403000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Dental stick",
                 "Dental stick",
                 "Dentalstift",
                 "Bâton dentaire",
                 "Bastoncino dentale"),
    /**
     * EN: Dental suspension.<br>
     * DE: Dentalsuspension.<br>
     * FR: Suspension dentaire.<br>
     * IT: Sospensione dentale.<br>
     */
    DENTAL_SUSPENSION("10407000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Dental suspension",
                      "Dental suspension",
                      "Dentalsuspension",
                      "Suspension dentaire",
                      "Sospensione dentale"),
    /**
     * EN: Denture lacquer.<br>
     * DE: Lack für die Gebisskontaktfläche.<br>
     * FR: Laque dentaire.<br>
     * IT: Smalto dentale.<br>
     */
    DENTURE_LACQUER("12101000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Denture lacquer",
                    "Denture lacquer",
                    "Lack für die Gebisskontaktfläche",
                    "Laque dentaire",
                    "Smalto dentale"),
    /**
     * EN: Dispersible tablet.<br>
     * DE: Tablette zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Comprimé dispersible.<br>
     * IT: Compressa dispersibile.<br>
     */
    DISPERSIBLE_TABLET("10121000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Dispersible tablet",
                       "Dispersible tablet",
                       "Tablette zur Herstellung einer Suspension zum Einnehmen",
                       "Comprimé dispersible",
                       "Compressa dispersibile"),
    /**
     * EN: Dispersible tablets for dose dispenser.<br>
     * DE: Tablette zur Herstellung einer Suspension zum Einnehmen für ein Dosiergerät.<br>
     * FR: Comprimés dispersibles pour dispensateur de dose.<br>
     * IT: Compresse dispersibili per dispensatore di dose.<br>
     */
    DISPERSIBLE_TABLETS_FOR_DOSE_DISPENSER("10121500",
                                           "0.4.0.127.0.16.1.1.2.1",
                                           "Dispersible tablets for dose dispenser",
                                           "Dispersible tablets for dose dispenser",
                                           "Tablette zur Herstellung einer Suspension zum Einnehmen für ein Dosiergerät",
                                           "Comprimés dispersibles pour dispensateur de dose",
                                           "Compresse dispersibili per dispensatore di dose"),
    /**
     * EN: Dispersion for concentrate for dispersion for infusion.<br>
     * DE: Dispersion für ein Konzentrat zur Herstellung einer Infusionsdispersion.<br>
     * FR: Dispersion pour dispersion à diluer pour perfusion.<br>
     * IT: Dispersione per concentrato per dispersione per infusione.<br>
     */
    DISPERSION_FOR_CONCENTRATE_FOR_DISPERSION_FOR_INFUSION("13005000",
                                                           "0.4.0.127.0.16.1.1.2.1",
                                                           "Dispersion for concentrate for dispersion for infusion",
                                                           "Dispersion for concentrate for dispersion for infusion",
                                                           "Dispersion für ein Konzentrat zur Herstellung einer Infusionsdispersion",
                                                           "Dispersion pour dispersion à diluer pour perfusion",
                                                           "Dispersione per concentrato per dispersione per infusione"),
    /**
     * EN: Dispersion for infusion.<br>
     * DE: Infusionsdispersion.<br>
     * FR: Dispersion pour perfusion.<br>
     * IT: Dispersione per infusione.<br>
     */
    DISPERSION_FOR_INFUSION("50017500",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Dispersion for infusion",
                            "Dispersion for infusion",
                            "Infusionsdispersion",
                            "Dispersion pour perfusion",
                            "Dispersione per infusione"),
    /**
     * EN: Dispersion for injection.<br>
     * DE: Injektionsdispersion.<br>
     * FR: Dispersion injectable.<br>
     * IT: Dispersione per preparazione iniettabile.<br>
     */
    DISPERSION_FOR_INJECTION("50077000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Dispersion for injection",
                             "Dispersion for injection",
                             "Injektionsdispersion",
                             "Dispersion injectable",
                             "Dispersione per preparazione iniettabile"),
    /**
     * EN: Dispersion for injection/infusion.<br>
     * DE: Dispersion zur Injektion /Infusion.<br>
     * FR: Dispersion injectable/ pour perfusion.<br>
     * IT: Dispersione iniettabile/per infusione.<br>
     */
    DISPERSION_FOR_INJECTION_INFUSION("13049000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Dispersion for injection/infusion",
                                      "Dispersion for injection/infusion",
                                      "Dispersion zur Injektion /Infusion",
                                      "Dispersion injectable/ pour perfusion",
                                      "Dispersione iniettabile/per infusione"),
    /**
     * EN: Ear cream.<br>
     * DE: Ohrencreme.<br>
     * FR: Crème auriculaire.<br>
     * IT: Crema auricolare.<br>
     */
    EAR_CREAM("10701000",
              "0.4.0.127.0.16.1.1.2.1",
              "Ear cream",
              "Ear cream",
              "Ohrencreme",
              "Crème auriculaire",
              "Crema auricolare"),
    /**
     * EN: Ear drops, emulsion.<br>
     * DE: Ohrentropfen, Emulsion.<br>
     * FR: Emulsion auriculaire en gouttes.<br>
     * IT: Gocce auricolari, emulsione.<br>
     */
    EAR_DROPS_EMULSION("10706000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Ear drops, emulsion",
                       "Ear drops, emulsion",
                       "Ohrentropfen, Emulsion",
                       "Emulsion auriculaire en gouttes",
                       "Gocce auricolari, emulsione"),
    /**
     * EN: Ear drops, powder for suspension.<br>
     * DE: Pulver zur Herstellung einer Ohrentropfensuspension.<br>
     * FR: Poudre pour suspension auriculaire en gouttes.<br>
     * IT: Gocce auricolari, polvere per sospensione.<br>
     */
    EAR_DROPS_POWDER_FOR_SUSPENSION("13006000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Ear drops, powder for suspension",
                                    "Ear drops, powder for suspension",
                                    "Pulver zur Herstellung einer Ohrentropfensuspension",
                                    "Poudre pour suspension auriculaire en gouttes",
                                    "Gocce auricolari, polvere per sospensione"),
    /**
     * EN: Ear drops, solution.<br>
     * DE: Ohrentropfen, Lösung.<br>
     * FR: Solution auriculaire en gouttes.<br>
     * IT: Gocce auricolari, soluzione.<br>
     */
    EAR_DROPS_SOLUTION("10704000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Ear drops, solution",
                       "Ear drops, solution",
                       "Ohrentropfen, Lösung",
                       "Solution auriculaire en gouttes",
                       "Gocce auricolari, soluzione"),
    /**
     * EN: Ear drops, suspension.<br>
     * DE: Ohrentropfen, Suspension.<br>
     * FR: Suspension auriculaire en gouttes.<br>
     * IT: Gocce auricolari, sospensione.<br>
     */
    EAR_DROPS_SUSPENSION("10705000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Ear drops, suspension",
                         "Ear drops, suspension",
                         "Ohrentropfen, Suspension",
                         "Suspension auriculaire en gouttes",
                         "Gocce auricolari, sospensione"),
    /**
     * EN: Ear/eye drops, solution.<br>
     * DE: Augen-/Ohrentropfen, Lösung.<br>
     * FR: Solution auriculaire/ophtalmique en gouttes.<br>
     * IT: Gocce auricolari/collirio, soluzione.<br>
     */
    EAR_EYE_DROPS_SOLUTION("50018000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Ear/eye drops, solution",
                           "Ear/eye drops, solution",
                           "Augen-/Ohrentropfen, Lösung",
                           "Solution auriculaire/ophtalmique en gouttes",
                           "Gocce auricolari/collirio, soluzione"),
    /**
     * EN: Ear/eye drops, suspension.<br>
     * DE: Augen-/Ohrentropfen, Suspension.<br>
     * FR: -.<br>
     * IT: Gocce auricolari/collirio, sospensione.<br>
     */
    EAR_EYE_DROPS_SUSPENSION("50018500",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Ear/eye drops, suspension",
                             "Ear/eye drops, suspension",
                             "Augen-/Ohrentropfen, Suspension",
                             "-",
                             "Gocce auricolari/collirio, sospensione"),
    /**
     * EN: Ear/eye/nasal drops, solution.<br>
     * DE: Augen-/Ohren-/Nasentropfen, Lösung.<br>
     * FR: Solution auriculaire/ ophtalmique/ nasale en gouttes.<br>
     * IT: Gocce auricolari/collirio/gocce nasali, soluzione.<br>
     */
    EAR_EYE_NASAL_DROPS_SOLUTION("50019500",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Ear/eye/nasal drops, solution",
                                 "Ear/eye/nasal drops, solution",
                                 "Augen-/Ohren-/Nasentropfen, Lösung",
                                 "Solution auriculaire/ ophtalmique/ nasale en gouttes",
                                 "Gocce auricolari/collirio/gocce nasali, soluzione"),
    /**
     * EN: Ear/eye ointment.<br>
     * DE: Augen-/Ohrensalbe.<br>
     * FR: Pommade auriculaire/ ophtalmique.<br>
     * IT: Unguento auricolare/oftalmico.<br>
     */
    EAR_EYE_OINTMENT("50019000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Ear/eye ointment",
                     "Ear/eye ointment",
                     "Augen-/Ohrensalbe",
                     "Pommade auriculaire/ ophtalmique",
                     "Unguento auricolare/oftalmico"),
    /**
     * EN: Ear gel.<br>
     * DE: Ohrengel.<br>
     * FR: Gel auriculaire.<br>
     * IT: Gel auricolare.<br>
     */
    EAR_GEL("10702000",
            "0.4.0.127.0.16.1.1.2.1",
            "Ear gel",
            "Ear gel",
            "Ohrengel",
            "Gel auriculaire",
            "Gel auricolare"),
    /**
     * EN: Ear/nasal drops, suspension.<br>
     * DE: Augen-/Nasentropfen, Suspension.<br>
     * FR: Suspension auriculaire/nasale en gouttes.<br>
     * IT: Gocce auricolari/nasali, sospensione.<br>
     */
    EAR_NASAL_DROPS_SUSPENSION("50020200",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Ear/nasal drops, suspension",
                               "Ear/nasal drops, suspension",
                               "Augen-/Nasentropfen, Suspension",
                               "Suspension auriculaire/nasale en gouttes",
                               "Gocce auricolari/nasali, sospensione"),
    /**
     * EN: Ear ointment.<br>
     * DE: Ohrensalbe.<br>
     * FR: Pommade auriculaire.<br>
     * IT: Unguento auricolare.<br>
     */
    EAR_OINTMENT("10703000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Ear ointment",
                 "Ear ointment",
                 "Ohrensalbe",
                 "Pommade auriculaire",
                 "Unguento auricolare"),
    /**
     * EN: Ear powder.<br>
     * DE: Ohrenpulver.<br>
     * FR: Poudre auriculaire.<br>
     * IT: Polvere auricolare.<br>
     */
    EAR_POWDER("10708000",
               "0.4.0.127.0.16.1.1.2.1",
               "Ear powder",
               "Ear powder",
               "Ohrenpulver",
               "Poudre auriculaire",
               "Polvere auricolare"),
    /**
     * EN: Ear spray, emulsion.<br>
     * DE: Ohrenspray, Emulsion.<br>
     * FR: Emulsion pour pulvérisation auriculaire.<br>
     * IT: Spray auricolare, emulsione.<br>
     */
    EAR_SPRAY_EMULSION("10711000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Ear spray, emulsion",
                       "Ear spray, emulsion",
                       "Ohrenspray, Emulsion",
                       "Emulsion pour pulvérisation auriculaire",
                       "Spray auricolare, emulsione"),
    /**
     * EN: Ear spray, solution.<br>
     * DE: Ohrenspray, Lösung.<br>
     * FR: Solution pour pulvérisation auriculaire.<br>
     * IT: Spray auricolare, soluzione.<br>
     */
    EAR_SPRAY_SOLUTION("10709000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Ear spray, solution",
                       "Ear spray, solution",
                       "Ohrenspray, Lösung",
                       "Solution pour pulvérisation auriculaire",
                       "Spray auricolare, soluzione"),
    /**
     * EN: Ear spray, suspension.<br>
     * DE: Ohrenspray, Suspension.<br>
     * FR: Suspension pour pulvérisation auriculaire.<br>
     * IT: Spray auricolare, sospensione.<br>
     */
    EAR_SPRAY_SUSPENSION("10710000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Ear spray, suspension",
                         "Ear spray, suspension",
                         "Ohrenspray, Suspension",
                         "Suspension pour pulvérisation auriculaire",
                         "Spray auricolare, sospensione"),
    /**
     * EN: Ear stick.<br>
     * DE: Ohrenstäbchen.<br>
     * FR: Bâton pour usage auriculaire.<br>
     * IT: Bastoncino auricolare.<br>
     */
    EAR_STICK("10715000",
              "0.4.0.127.0.16.1.1.2.1",
              "Ear stick",
              "Ear stick",
              "Ohrenstäbchen",
              "Bâton pour usage auriculaire",
              "Bastoncino auricolare"),
    /**
     * EN: Ear tampon.<br>
     * DE: Ohrentampon.<br>
     * FR: Tampon auriculaire.<br>
     * IT: Tampone auricolare.<br>
     */
    EAR_TAMPON("10714000",
               "0.4.0.127.0.16.1.1.2.1",
               "Ear tampon",
               "Ear tampon",
               "Ohrentampon",
               "Tampon auriculaire",
               "Tampone auricolare"),
    /**
     * EN: Ear wash, emulsion.<br>
     * DE: Ohrenspülung, Emulsion.<br>
     * FR: Emulsion pour lavage auriculaire.<br>
     * IT: Lavaggio auricolare, emulsione.<br>
     */
    EAR_WASH_EMULSION("10713000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Ear wash, emulsion",
                      "Ear wash, emulsion",
                      "Ohrenspülung, Emulsion",
                      "Emulsion pour lavage auriculaire",
                      "Lavaggio auricolare, emulsione"),
    /**
     * EN: Ear wash, solution.<br>
     * DE: Ohrenspüllösung.<br>
     * FR: Solution pour lavage auriculaire.<br>
     * IT: Lavaggio auricolare, soluzione.<br>
     */
    EAR_WASH_SOLUTION("10712000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Ear wash, solution",
                      "Ear wash, solution",
                      "Ohrenspüllösung",
                      "Solution pour lavage auriculaire",
                      "Lavaggio auricolare, soluzione"),
    /**
     * EN: Effervescent granules.<br>
     * DE: Brausegranulat.<br>
     * FR: Granulés effervescents.<br>
     * IT: Granulato effervescente.<br>
     */
    EFFERVESCENT_GRANULES("10205000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Effervescent granules",
                          "Effervescent granules",
                          "Brausegranulat",
                          "Granulés effervescents",
                          "Granulato effervescente"),
    /**
     * EN: Effervescent granules for oral suspension.<br>
     * DE: Brausegranulat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Granulés effervescents pour suspension buvable.<br>
     * IT: Granulato effervescente per sospensione orale.<br>
     */
    EFFERVESCENT_GRANULES_FOR_ORAL_SUSPENSION("13007000",
                                              "0.4.0.127.0.16.1.1.2.1",
                                              "Effervescent granules for oral suspension",
                                              "Effervescent granules for oral suspension",
                                              "Brausegranulat zur Herstellung einer Suspension zum Einnehmen",
                                              "Granulés effervescents pour suspension buvable",
                                              "Granulato effervescente per sospensione orale"),
    /**
     * EN: Effervescent powder.<br>
     * DE: Brausepulver.<br>
     * FR: Poudre effervescente.<br>
     * IT: Polvere effervescente.<br>
     */
    EFFERVESCENT_POWDER("10203000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Effervescent powder",
                        "Effervescent powder",
                        "Brausepulver",
                        "Poudre effervescente",
                        "Polvere effervescente"),
    /**
     * EN: Effervescent tablet.<br>
     * DE: Brausetablette.<br>
     * FR: Comprimé effervescent.<br>
     * IT: Compressa effervescente.<br>
     */
    EFFERVESCENT_TABLET("10222000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Effervescent tablet",
                        "Effervescent tablet",
                        "Brausetablette",
                        "Comprimé effervescent",
                        "Compressa effervescente"),
    /**
     * EN: Effervescent vaginal tablet.<br>
     * DE: Schaumovula.<br>
     * FR: Comprimé vaginal effervescent.<br>
     * IT: Compressa effervescente vaginale.<br>
     */
    EFFERVESCENT_VAGINAL_TABLET("10913000",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Effervescent vaginal tablet",
                                "Effervescent vaginal tablet",
                                "Schaumovula",
                                "Comprimé vaginal effervescent",
                                "Compressa effervescente vaginale"),
    /**
     * EN: Emulsion for emulsion for injection.<br>
     * DE: Emulsion zur Herstellung einer Emulsion zur Injektion.<br>
     * FR: Emulsion pour émulsion injectable.<br>
     * IT: Emulsione per emulsione iniettabile.<br>
     */
    EMULSION_FOR_EMULSION_FOR_INJECTION("13008000",
                                        "0.4.0.127.0.16.1.1.2.1",
                                        "Emulsion for emulsion for injection",
                                        "Emulsion for emulsion for injection",
                                        "Emulsion zur Herstellung einer Emulsion zur Injektion",
                                        "Emulsion pour émulsion injectable",
                                        "Emulsione per emulsione iniettabile"),
    /**
     * EN: Emulsion for infusion.<br>
     * DE: Emulsion zur Infusion.<br>
     * FR: Emulsion pour perfusion.<br>
     * IT: Emulsione per infusione.<br>
     */
    EMULSION_FOR_INFUSION("11211000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Emulsion for infusion",
                          "Emulsion for infusion",
                          "Emulsion zur Infusion",
                          "Emulsion pour perfusion",
                          "Emulsione per infusione"),
    /**
     * EN: Emulsion for injection.<br>
     * DE: Emulsion zur Injektion.<br>
     * FR: Emulsion injectable.<br>
     * IT: Emuslione iniettabile.<br>
     */
    EMULSION_FOR_INJECTION("11203000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Emulsion for injection",
                           "Emulsion for injection",
                           "Emulsion zur Injektion",
                           "Emulsion injectable",
                           "Emuslione iniettabile"),
    /**
     * EN: Emulsion for injection/infusion.<br>
     * DE: Emulsion zur Injektion/Infusion.<br>
     * FR: Émulsion injectable/pour perfusion.<br>
     * IT: Emulsione iniettabile/per infusione.<br>
     */
    EMULSION_FOR_INJECTION_INFUSION("50021000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Emulsion for injection/infusion",
                                    "Emulsion for injection/infusion",
                                    "Emulsion zur Injektion/Infusion",
                                    "Émulsion injectable/pour perfusion",
                                    "Emulsione iniettabile/per infusione"),
    /**
     * EN: Emulsion for suspension for injection.<br>
     * DE: Emulsion zur Herstellung einer Injektionssuspension.<br>
     * FR: Emulsion pour suspension injectable.<br>
     * IT: Emulsione per sospensione iniettabile.<br>
     */
    EMULSION_FOR_SUSPENSION_FOR_INJECTION("13091000",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Emulsion for suspension for injection",
                                          "Emulsion for suspension for injection",
                                          "Emulsion zur Herstellung einer Injektionssuspension",
                                          "Emulsion pour suspension injectable",
                                          "Emulsione per sospensione iniettabile"),
    /**
     * EN: Endocervical gel.<br>
     * DE: Gel zur endozervikalen Anwendung.<br>
     * FR: Gel endocervical.<br>
     * IT: Gel endocervicale.<br>
     */
    ENDOCERVICAL_GEL("11701000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Endocervical gel",
                     "Endocervical gel",
                     "Gel zur endozervikalen Anwendung",
                     "Gel endocervical",
                     "Gel endocervicale"),
    /**
     * EN: Endosinusial solution.<br>
     * DE: Lösung zur Anwendung in den Nebenhöhlen.<br>
     * FR: Solution endosinusale.<br>
     * IT: Soluzione endosinusale.<br>
     */
    ENDOSINUSIAL_SOLUTION("13041000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Endosinusial solution",
                          "Endosinusial solution",
                          "Lösung zur Anwendung in den Nebenhöhlen",
                          "Solution endosinusale",
                          "Soluzione endosinusale"),
    /**
     * EN: Endosinusial wash, suspension.<br>
     * DE: Nebenhöhlenspülung, Suspension.<br>
     * FR: Suspension pour lavage endosinusal.<br>
     * IT: Lavaggio endosinusale, sospensione.<br>
     */
    ENDOSINUSIAL_WASH_SUSPENSION("50022000",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Endosinusial wash, suspension",
                                 "Endosinusial wash, suspension",
                                 "Nebenhöhlenspülung, Suspension",
                                 "Suspension pour lavage endosinusal",
                                 "Lavaggio endosinusale, sospensione"),
    /**
     * EN: Endotracheopulmonary instillation, powder for solution.<br>
     * DE: Pulver zur Herstellung einer Lösung zur endotracheopulmonalen Instillation.<br>
     * FR: Poudre pour solution pour instillation endotrachéobronchique.<br>
     * IT: Polvere per soluzione per instillazione endotracheobronchiale.<br>
     */
    ENDOTRACHEOPULMONARY_INSTILLATION_POWDER_FOR_SOLUTION("11602000",
                                                          "0.4.0.127.0.16.1.1.2.1",
                                                          "Endotracheopulmonary instillation, powder for solution",
                                                          "Endotracheopulmonary instillation, powder for solution",
                                                          "Pulver zur Herstellung einer Lösung zur endotracheopulmonalen Instillation",
                                                          "Poudre pour solution pour instillation endotrachéobronchique",
                                                          "Polvere per soluzione per instillazione endotracheobronchiale"),
    /**
     * EN: Endotracheopulmonary instillation, powder for suspension.<br>
     * DE: Pulver zu Herstellung einer Suspension zur endotracheopulmonalen Instillation.<br>
     * FR: Poudre pour suspension pour instillation endotrachéobronchique.<br>
     * IT: Instillazione endotracheobronchiale, polvere per sospensione.<br>
     */
    ENDOTRACHEOPULMONARY_INSTILLATION_POWDER_FOR_SUSPENSION("13009000",
                                                            "0.4.0.127.0.16.1.1.2.1",
                                                            "Endotracheopulmonary instillation, powder for suspension",
                                                            "Endotracheopulmonary instillation, powder for suspension",
                                                            "Pulver zu Herstellung einer Suspension zur endotracheopulmonalen Instillation",
                                                            "Poudre pour suspension pour instillation endotrachéobronchique",
                                                            "Instillazione endotracheobronchiale, polvere per sospensione"),
    /**
     * EN: Endotracheopulmonary instillation, solution.<br>
     * DE: Lösung zur endotracheopulmonalen Instillation.<br>
     * FR: Solution pour instillation endotrachéobronchique.<br>
     * IT: Soluzione per instillazione endotracheobronchiale.<br>
     */
    ENDOTRACHEOPULMONARY_INSTILLATION_SOLUTION("11601000",
                                               "0.4.0.127.0.16.1.1.2.1",
                                               "Endotracheopulmonary instillation, solution",
                                               "Endotracheopulmonary instillation, solution",
                                               "Lösung zur endotracheopulmonalen Instillation",
                                               "Solution pour instillation endotrachéobronchique",
                                               "Soluzione per instillazione endotracheobronchiale"),
    /**
     * EN: Endotracheopulmonary instillation, suspension.<br>
     * DE: Suspension zur endotracheopulmonalen Instillation.<br>
     * FR: Suspension pour instillation endotrachéobronchique.<br>
     * IT: Sospensione per instillazione endotracheobronchiale.<br>
     */
    ENDOTRACHEOPULMONARY_INSTILLATION_SUSPENSION("11603000",
                                                 "0.4.0.127.0.16.1.1.2.1",
                                                 "Endotracheopulmonary instillation, suspension",
                                                 "Endotracheopulmonary instillation, suspension",
                                                 "Suspension zur endotracheopulmonalen Instillation",
                                                 "Suspension pour instillation endotrachéobronchique",
                                                 "Sospensione per instillazione endotracheobronchiale"),
    /**
     * EN: Epilesional solution.<br>
     * DE: Lösung zum Auftragen auf die Haut.<br>
     * FR: Solution épilésionnelle.<br>
     * IT: Soluzione epilesionale.<br>
     */
    EPILESIONAL_SOLUTION("13042000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Epilesional solution",
                         "Epilesional solution",
                         "Lösung zum Auftragen auf die Haut",
                         "Solution épilésionnelle",
                         "Soluzione epilesionale"),
    /**
     * EN: Eye cream.<br>
     * DE: Augencreme.<br>
     * FR: Crème ophtalmique.<br>
     * IT: Crema oftalmica.<br>
     */
    EYE_CREAM("10601000",
              "0.4.0.127.0.16.1.1.2.1",
              "Eye cream",
              "Eye cream",
              "Augencreme",
              "Crème ophtalmique",
              "Crema oftalmica"),
    /**
     * EN: Eye drops, emulsion.<br>
     * DE: Augentropfen, Emulsion.<br>
     * FR: Collyre en émulsion.<br>
     * IT: Collirio, emulsione.<br>
     */
    EYE_DROPS_EMULSION("10604500",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Eye drops, emulsion",
                       "Eye drops, emulsion",
                       "Augentropfen, Emulsion",
                       "Collyre en émulsion",
                       "Collirio, emulsione"),
    /**
     * EN: Eye drops, powder for solution.<br>
     * DE: Pulver zur Herstellung von Augentropfen, Lösung.<br>
     * FR: Poudre pour solution ophtalmique en gouttes.<br>
     * IT: Collirio, polvere per soluzione.<br>
     */
    EYE_DROPS_POWDER_FOR_SOLUTION("13010000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Eye drops, powder for solution",
                                  "Eye drops, powder for solution",
                                  "Pulver zur Herstellung von Augentropfen, Lösung",
                                  "Poudre pour solution ophtalmique en gouttes",
                                  "Collirio, polvere per soluzione"),
    /**
     * EN: Eye drops, powder for suspension.<br>
     * DE: Pulver zur Herstellung einer Augentropfensuspension.<br>
     * FR: Poudre pour suspension ophtalmique en gouttes.<br>
     * IT: Collirio, polvere per sospensione.<br>
     */
    EYE_DROPS_POWDER_FOR_SUSPENSION("13011000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Eye drops, powder for suspension",
                                    "Eye drops, powder for suspension",
                                    "Pulver zur Herstellung einer Augentropfensuspension",
                                    "Poudre pour suspension ophtalmique en gouttes",
                                    "Collirio, polvere per sospensione"),
    /**
     * EN: Eye drops, prolonged-release.<br>
     * DE: Augentropfen mit verlängerter Wirkungsdauer.<br>
     * FR: Collyre à libération prolongée.<br>
     * IT: Collirio a rilascio prolungato.<br>
     */
    EYE_DROPS_PROLONGED_RELEASE("10609000",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Eye drops, prolonged-release",
                                "Eye drops, prolonged-release",
                                "Augentropfen mit verlängerter Wirkungsdauer",
                                "Collyre à libération prolongée",
                                "Collirio a rilascio prolungato"),
    /**
     * EN: Eye drops, solution.<br>
     * DE: Augentropfen, Lösung.<br>
     * FR: Collyre en solution.<br>
     * IT: Collirio, soluzione.<br>
     */
    EYE_DROPS_SOLUTION("10604000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Eye drops, solution",
                       "Eye drops, solution",
                       "Augentropfen, Lösung",
                       "Collyre en solution",
                       "Collirio, soluzione"),
    /**
     * EN: Eye drops, solvent for reconstitution.<br>
     * DE: Lösungsmittel zur Herstellung von Augentropfen.<br>
     * FR: Solvant pour collyre.<br>
     * IT: Solvente per collirio.<br>
     */
    EYE_DROPS_SOLVENT_FOR_RECONSTITUTION("10608000",
                                         "0.4.0.127.0.16.1.1.2.1",
                                         "Eye drops, solvent for reconstitution",
                                         "Eye drops, solvent for reconstitution",
                                         "Lösungsmittel zur Herstellung von Augentropfen",
                                         "Solvant pour collyre",
                                         "Solvente per collirio"),
    /**
     * EN: Eye drops, suspension.<br>
     * DE: Augentropfensuspension.<br>
     * FR: Collyre en suspension.<br>
     * IT: Collirio, sospensione.<br>
     */
    EYE_DROPS_SUSPENSION("10605000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Eye drops, suspension",
                         "Eye drops, suspension",
                         "Augentropfensuspension",
                         "Collyre en suspension",
                         "Collirio, sospensione"),
    /**
     * EN: Eye gel.<br>
     * DE: Augengel.<br>
     * FR: Gel ophtalmique.<br>
     * IT: Gel oftalmico.<br>
     */
    EYE_GEL("10602000",
            "0.4.0.127.0.16.1.1.2.1",
            "Eye gel",
            "Eye gel",
            "Augengel",
            "Gel ophtalmique",
            "Gel oftalmico"),
    /**
     * EN: Eye lotion.<br>
     * DE: Augenbad.<br>
     * FR: Solution pour lavage ophtalmique.<br>
     * IT: Bagno oculare.<br>
     */
    EYE_LOTION("10610000",
               "0.4.0.127.0.16.1.1.2.1",
               "Eye lotion",
               "Eye lotion",
               "Augenbad",
               "Solution pour lavage ophtalmique",
               "Bagno oculare"),
    /**
     * EN: Eye lotion, solvent for reconstitution.<br>
     * DE: Lösungsmittel zur Herstellung eines Augenbades.<br>
     * FR: Solvant pour solution pour lavage ophtalmique.<br>
     * IT: Solvente per bagno oculare.<br>
     */
    EYE_LOTION_SOLVENT_FOR_RECONSTITUTION("10611000",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Eye lotion, solvent for reconstitution",
                                          "Eye lotion, solvent for reconstitution",
                                          "Lösungsmittel zur Herstellung eines Augenbades",
                                          "Solvant pour solution pour lavage ophtalmique",
                                          "Solvente per bagno oculare"),
    /**
     * EN: Eye ointment.<br>
     * DE: Augensalbe.<br>
     * FR: Pommade ophtalmique.<br>
     * IT: Unguento oftalmico.<br>
     */
    EYE_OINTMENT("10603000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Eye ointment",
                 "Eye ointment",
                 "Augensalbe",
                 "Pommade ophtalmique",
                 "Unguento oftalmico"),
    /**
     * EN: Film-coated tablet.<br>
     * DE: Filmtablette.<br>
     * FR: Comprimé pelliculé.<br>
     * IT: Compressa rivestita con film.<br>
     */
    FILM_COATED_TABLET("10221000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Film-coated tablet",
                       "Film-coated tablet",
                       "Filmtablette",
                       "Comprimé pelliculé",
                       "Compressa rivestita con film"),
    /**
     * EN: Gargle.<br>
     * DE: Gurgellösung.<br>
     * FR: Solution pour gargarisme.<br>
     * IT: Soluzione per gargarismi.<br>
     */
    GARGLE("10301000",
           "0.4.0.127.0.16.1.1.2.1",
           "Gargle",
           "Gargle",
           "Gurgellösung",
           "Solution pour gargarisme",
           "Soluzione per gargarismi"),
    /**
     * EN: Gargle/mouthwash.<br>
     * DE: Gurgellösung/Mundspülung.<br>
     * FR: Solution pour gargarisme/bain de bouche.<br>
     * IT: Soluzione per gargarismi/collutorio.<br>
     */
    GARGLE_MOUTHWASH("50024000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Gargle/mouthwash",
                     "Gargle/mouthwash",
                     "Gurgellösung/Mundspülung",
                     "Solution pour gargarisme/bain de bouche",
                     "Soluzione per gargarismi/collutorio"),
    /**
     * EN: Gargle/nasal wash.<br>
     * DE: Gurgellösung/Nasenspülung.<br>
     * FR: Solution pour gargarisme/ nasale.<br>
     * IT: Soluzione per gargarismi/lavaggio nasale.<br>
     */
    GARGLE_NASAL_WASH("50024500",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Gargle/nasal wash",
                      "Gargle/nasal wash",
                      "Gurgellösung/Nasenspülung",
                      "Solution pour gargarisme/ nasale",
                      "Soluzione per gargarismi/lavaggio nasale"),
    /**
     * EN: Gargle, powder for solution.<br>
     * DE: Pulver zur Herstellung einer Gurgellösung.<br>
     * FR: Poudre pour solution pour gargarisme.<br>
     * IT: Polvere per soluzione per gargarismi.<br>
     */
    GARGLE_POWDER_FOR_SOLUTION("10303000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Gargle, powder for solution",
                               "Gargle, powder for solution",
                               "Pulver zur Herstellung einer Gurgellösung",
                               "Poudre pour solution pour gargarisme",
                               "Polvere per soluzione per gargarismi"),
    /**
     * EN: Gargle, tablet for solution.<br>
     * DE: Tablette zur Herstellung einer Gurgellösung.<br>
     * FR: Comprimé pour solution pour gargarisme.<br>
     * IT: Compressa per soluzione per gargarismi.<br>
     */
    GARGLE_TABLET_FOR_SOLUTION("10304000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Gargle, tablet for solution",
                               "Gargle, tablet for solution",
                               "Tablette zur Herstellung einer Gurgellösung",
                               "Comprimé pour solution pour gargarisme",
                               "Compressa per soluzione per gargarismi"),
    /**
     * EN: Gastroenteral emulsion.<br>
     * DE: Emulsion zur gastrointestinalen Anwendung.<br>
     * FR: Emulsion gastroentérale.<br>
     * IT: Emulsione gastroenterica.<br>
     */
    GASTROENTERAL_EMULSION("12111000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Gastroenteral emulsion",
                           "Gastroenteral emulsion",
                           "Emulsion zur gastrointestinalen Anwendung",
                           "Emulsion gastroentérale",
                           "Emulsione gastroenterica"),
    /**
     * EN: Gastroenteral solution.<br>
     * DE: Lösung zur gastrointestinalen Anwendung.<br>
     * FR: Solution gastroentérale.<br>
     * IT: Soluzione gastroenterica.<br>
     */
    GASTROENTERAL_SOLUTION("12108000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Gastroenteral solution",
                           "Gastroenteral solution",
                           "Lösung zur gastrointestinalen Anwendung",
                           "Solution gastroentérale",
                           "Soluzione gastroenterica"),
    /**
     * EN: Gastroenteral suspension.<br>
     * DE: Suspension zur gastrointestinalen Anwendung.<br>
     * FR: Suspension gastroentérale.<br>
     * IT: Sospensione gastroenterica.<br>
     */
    GASTROENTERAL_SUSPENSION("12110000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Gastroenteral suspension",
                             "Gastroenteral suspension",
                             "Suspension zur gastrointestinalen Anwendung",
                             "Suspension gastroentérale",
                             "Sospensione gastroenterica"),
    /**
     * EN: Gastro-resistant capsule, hard.<br>
     * DE: magensaftresistente Hartkapsel.<br>
     * FR: Gélule gastrorésistante.<br>
     * IT: Capsula rigida gastroresistente.<br>
     */
    GASTRO_RESISTANT_CAPSULE_HARD("10212000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Gastro-resistant capsule, hard",
                                  "Gastro-resistant capsule, hard",
                                  "magensaftresistente Hartkapsel",
                                  "Gélule gastrorésistante",
                                  "Capsula rigida gastroresistente"),
    /**
     * EN: Gastro-resistant capsule, soft.<br>
     * DE: magensaftresistente Weichkapsel.<br>
     * FR: Capsule molle gastrorésistante.<br>
     * IT: Capsula molle gastroresistente.<br>
     */
    GASTRO_RESISTANT_CAPSULE_SOFT("10213000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Gastro-resistant capsule, soft",
                                  "Gastro-resistant capsule, soft",
                                  "magensaftresistente Weichkapsel",
                                  "Capsule molle gastrorésistante",
                                  "Capsula molle gastroresistente"),
    /**
     * EN: Gastro-resistant granules.<br>
     * DE: magensaftresistentes Granulat.<br>
     * FR: Granulés gastrorésistants.<br>
     * IT: Granulato gastroresistente.<br>
     */
    GASTRO_RESISTANT_GRANULES("10206000",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Gastro-resistant granules",
                              "Gastro-resistant granules",
                              "magensaftresistentes Granulat",
                              "Granulés gastrorésistants",
                              "Granulato gastroresistente"),
    /**
     * EN: Gastro-resistant granules for oral suspension.<br>
     * DE: magensaftresistentes Granulat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Granulés gastrorésistants pour suspension buvable.<br>
     * IT: Granulato gastroresistente per sospensione orale.<br>
     */
    GASTRO_RESISTANT_GRANULES_FOR_ORAL_SUSPENSION("50026000",
                                                  "0.4.0.127.0.16.1.1.2.1",
                                                  "Gastro-resistant granules for oral suspension",
                                                  "Gastro-resistant granules for oral suspension",
                                                  "magensaftresistentes Granulat zur Herstellung einer Suspension zum Einnehmen",
                                                  "Granulés gastrorésistants pour suspension buvable",
                                                  "Granulato gastroresistente per sospensione orale"),
    /**
     * EN: Gastro-resistant oral suspension.<br>
     * DE: Magensaftresistente Suspension zum Einnehmen.<br>
     * FR: Solution à libération prolongée intralésionnelle.<br>
     * IT: Larva medicinale.<br>
     */
    GASTRO_RESISTANT_ORAL_SUSPENSION("13133000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Gastro-resistant oral suspension",
                                     "Gastro-resistant oral suspension",
                                     "Magensaftresistente Suspension zum Einnehmen",
                                     "Solution à libération prolongée intralésionnelle",
                                     "Larva medicinale"),
    /**
     * EN: Gastro-resistant powder for oral suspension.<br>
     * DE: Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Solution à libération prolongée intralésionnelle.<br>
     * IT: Larva medicinale.<br>
     */
    GASTRO_RESISTANT_POWDER_FOR_ORAL_SUSPENSION("13136000",
                                                "0.4.0.127.0.16.1.1.2.1",
                                                "Gastro-resistant powder for oral suspension",
                                                "Gastro-resistant powder for oral suspension",
                                                "Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen",
                                                "Solution à libération prolongée intralésionnelle",
                                                "Larva medicinale"),
    /**
     * EN: Gastro-resistant tablet.<br>
     * DE: magensaftresistente Tablette.<br>
     * FR: Comprimé gastrorésistant.<br>
     * IT: Compressa gastroresistente.<br>
     */
    GASTRO_RESISTANT_TABLET("10225000",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Gastro-resistant tablet",
                            "Gastro-resistant tablet",
                            "magensaftresistente Tablette",
                            "Comprimé gastrorésistant",
                            "Compressa gastroresistente"),
    /**
     * EN: Gas for dispersion for infusion.<br>
     * DE: Gas zur Herstellung einer Infusionsdispersion.<br>
     * FR: Gaz pour dispersion pour perfusion.<br>
     * IT: Gas per dispersione per infusione.<br>
     */
    GAS_FOR_DISPERSION_FOR_INFUSION("13012000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Gas for dispersion for infusion",
                                    "Gas for dispersion for infusion",
                                    "Gas zur Herstellung einer Infusionsdispersion",
                                    "Gaz pour dispersion pour perfusion",
                                    "Gas per dispersione per infusione"),
    /**
     * EN: Gas for dispersion for injection.<br>
     * DE: Gas zur Herstellung einer Injektionsdispersion.<br>
     * FR: Gaz pour dispersion injectable.<br>
     * IT: Gas per dispersione iniettabile.<br>
     */
    GAS_FOR_DISPERSION_FOR_INJECTION("13013000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Gas for dispersion for injection",
                                     "Gas for dispersion for injection",
                                     "Gas zur Herstellung einer Injektionsdispersion",
                                     "Gaz pour dispersion injectable",
                                     "Gas per dispersione iniettabile"),
    /**
     * EN: Gas for dispersion for injection/infusion.<br>
     * DE: Gas zur Herstellung einer Injektions-/Infusionsdispersion.<br>
     * FR: Gaz pour dispersion injectable/ pour perfusion.<br>
     * IT: Gas per dispersione iniettabile/per infusione.<br>
     */
    GAS_FOR_DISPERSION_FOR_INJECTION_INFUSION("13050000",
                                              "0.4.0.127.0.16.1.1.2.1",
                                              "Gas for dispersion for injection/infusion",
                                              "Gas for dispersion for injection/infusion",
                                              "Gas zur Herstellung einer Injektions-/Infusionsdispersion",
                                              "Gaz pour dispersion injectable/ pour perfusion",
                                              "Gas per dispersione iniettabile/per infusione"),
    /**
     * EN: Gel.<br>
     * DE: Gel.<br>
     * FR: Gel.<br>
     * IT: Gel.<br>
     */
    GEL("10503000",
        "0.4.0.127.0.16.1.1.2.1",
        "Gel",
        "Gel",
        "Gel",
        "Gel",
        "Gel"),
    /**
     * EN: Gel for gel.<br>
     * DE: Gel zur Herstellung eines Gels.<br>
     * FR: Gel pour gel.<br>
     * IT: Gel per gel.<br>
     */
    GEL_FOR_GEL("13014000",
                "0.4.0.127.0.16.1.1.2.1",
                "Gel for gel",
                "Gel for gel",
                "Gel zur Herstellung eines Gels",
                "Gel pour gel",
                "Gel per gel"),
    /**
     * EN: Gel for injection.<br>
     * DE: Gel zur Injektion.<br>
     * FR: Gel injectable.<br>
     * IT: Gel iniettabile.<br>
     */
    GEL_FOR_INJECTION("11204000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Gel for injection",
                      "Gel for injection",
                      "Gel zur Injektion",
                      "Gel injectable",
                      "Gel iniettabile"),
    /**
     * EN: Gingival gel.<br>
     * DE: Gel zur Anwendung am Zahnfleisch.<br>
     * FR: Gel gingival.<br>
     * IT: Gel gengivale.<br>
     */
    GINGIVAL_GEL("10315000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Gingival gel",
                 "Gingival gel",
                 "Gel zur Anwendung am Zahnfleisch",
                 "Gel gingival",
                 "Gel gengivale"),
    /**
     * EN: Gingival paste.<br>
     * DE: Paste zur Anwendung am Zahnfleisch.<br>
     * FR: Pâte gingivale.<br>
     * IT: Pasta gengivale.<br>
     */
    GINGIVAL_PASTE("10316000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Gingival paste",
                   "Gingival paste",
                   "Paste zur Anwendung am Zahnfleisch",
                   "Pâte gingivale",
                   "Pasta gengivale"),
    /**
     * EN: Gingival solution.<br>
     * DE: Lösung zur Anwendung am Zahnfleisch.<br>
     * FR: Solution gingivale.<br>
     * IT: Soluzione gengivale.<br>
     */
    GINGIVAL_SOLUTION("10312000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Gingival solution",
                      "Gingival solution",
                      "Lösung zur Anwendung am Zahnfleisch",
                      "Solution gingivale",
                      "Soluzione gengivale"),
    /**
     * EN: Granules.<br>
     * DE: Granulat.<br>
     * FR: Granulés.<br>
     * IT: Granulato.<br>
     */
    GRANULES("10204000",
             "0.4.0.127.0.16.1.1.2.1",
             "Granules",
             "Granules",
             "Granulat",
             "Granulés",
             "Granulato"),
    /**
     * EN: Granules for oral/rectal suspension.<br>
     * DE: Granulat zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension.<br>
     * FR: Granulés pour suspension buvable/rectale.<br>
     * IT: Granulato per sospensione orale/rettale.<br>
     */
    GRANULES_FOR_ORAL_RECTAL_SUSPENSION("50029150",
                                        "0.4.0.127.0.16.1.1.2.1",
                                        "Granules for oral/rectal suspension",
                                        "Granules for oral/rectal suspension",
                                        "Granulat zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension",
                                        "Granulés pour suspension buvable/rectale",
                                        "Granulato per sospensione orale/rettale"),
    /**
     * EN: Granules for oral solution.<br>
     * DE: Granulat zur Herstellung einer Lösung zum Einnehmen.<br>
     * FR: Granulés pour solution buvable.<br>
     * IT: Granulato per soluzione orale.<br>
     */
    GRANULES_FOR_ORAL_SOLUTION("10112000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Granules for oral solution",
                               "Granules for oral solution",
                               "Granulat zur Herstellung einer Lösung zum Einnehmen",
                               "Granulés pour solution buvable",
                               "Granulato per soluzione orale"),
    /**
     * EN: Granules for oral suspension.<br>
     * DE: Granulat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Granulés pour suspension buvable.<br>
     * IT: Granulato per sospensione orale.<br>
     */
    GRANULES_FOR_ORAL_SUSPENSION("10113000",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Granules for oral suspension",
                                 "Granules for oral suspension",
                                 "Granulat zur Herstellung einer Suspension zum Einnehmen",
                                 "Granulés pour suspension buvable",
                                 "Granulato per sospensione orale"),
    /**
     * EN: Granules for rectal suspension.<br>
     * DE: Granulat zur Herstellung einer Rektalsuspension.<br>
     * FR: Granulés pour suspension rectale.<br>
     * IT: Granulato per sospensione rettale.<br>
     */
    GRANULES_FOR_RECTAL_SUSPENSION("13015000",
                                   "0.4.0.127.0.16.1.1.2.1",
                                   "Granules for rectal suspension",
                                   "Granules for rectal suspension",
                                   "Granulat zur Herstellung einer Rektalsuspension",
                                   "Granulés pour suspension rectale",
                                   "Granulato per sospensione rettale"),
    /**
     * EN: Granules for suspension for injection.<br>
     * DE: Granulat zur Herstellung einer Injektionssuspension.<br>
     * FR: Granulés pour suspension injectable.<br>
     * IT: Granulato per sospensione iniettabile.<br>
     */
    GRANULES_FOR_SUSPENSION_FOR_INJECTION("13048000",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Granules for suspension for injection",
                                          "Granules for suspension for injection",
                                          "Granulat zur Herstellung einer Injektionssuspension",
                                          "Granulés pour suspension injectable",
                                          "Granulato per sospensione iniettabile"),
    /**
     * EN: Granules for syrup.<br>
     * DE: Granulat zur Herstellung eines Sirups.<br>
     * FR: Granulés pour sirop.<br>
     * IT: Granulato per sciroppo.<br>
     */
    GRANULES_FOR_SYRUP("10119000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Granules for syrup",
                       "Granules for syrup",
                       "Granulat zur Herstellung eines Sirups",
                       "Granulés pour sirop",
                       "Granulato per sciroppo"),
    /**
     * EN: Granules for vaginal solution.<br>
     * DE: Granulat zur Herstellung einer Vaginallösung.<br>
     * FR: Granulés pour solution vaginale.<br>
     * IT: Granulato per soluzione vaginale.<br>
     */
    GRANULES_FOR_VAGINAL_SOLUTION("50029500",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Granules for vaginal solution",
                                  "Granules for vaginal solution",
                                  "Granulat zur Herstellung einer Vaginallösung",
                                  "Granulés pour solution vaginale",
                                  "Granulato per soluzione vaginale"),
    /**
     * EN: Herbal tea.<br>
     * DE: Arzneitee.<br>
     * FR: Plante(s) pour tisane.<br>
     * IT: Tisana.<br>
     */
    HERBAL_TEA("10122000",
               "0.4.0.127.0.16.1.1.2.1",
               "Herbal tea",
               "Herbal tea",
               "Arzneitee",
               "Plante(s) pour tisane",
               "Tisana"),
    /**
     * EN: Implant.<br>
     * DE: Implantat.<br>
     * FR: Implant.<br>
     * IT: Impianto.<br>
     */
    IMPLANT("11301000",
            "0.4.0.127.0.16.1.1.2.1",
            "Implant",
            "Implant",
            "Implantat",
            "Implant",
            "Impianto"),
    /**
     * EN: Implantation chain.<br>
     * DE: Kette zur Implantation.<br>
     * FR: Implant en chaîne.<br>
     * IT: Catenella per impianto.<br>
     */
    IMPLANTATION_CHAIN("11303000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Implantation chain",
                       "Implantation chain",
                       "Kette zur Implantation",
                       "Implant en chaîne",
                       "Catenella per impianto"),
    /**
     * EN: Implantation matrix.<br>
     * DE: Matrix zur Implantation.<br>
     * FR: Matrice pour implantation.<br>
     * IT: Catenella per impianto.<br>
     */
    IMPLANTATION_MATRIX("11303300",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Implantation matrix",
                        "Implantation matrix",
                        "Matrix zur Implantation",
                        "Matrice pour implantation",
                        "Catenella per impianto"),
    /**
     * EN: Implantation paste.<br>
     * DE: Paste für Implantate.<br>
     * FR: Pâte pour implantation.<br>
     * IT: Soluzione epilesionale.<br>
     */
    IMPLANTATION_PASTE("13043000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Implantation paste",
                       "Implantation paste",
                       "Paste für Implantate",
                       "Pâte pour implantation",
                       "Soluzione epilesionale"),
    /**
     * EN: Implantation suspension.<br>
     * DE: Suspension zur Implantation.<br>
     * FR: Suspension pour implantation.<br>
     * IT: Catenella per impianto.<br>
     */
    IMPLANTATION_SUSPENSION("11303500",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Implantation suspension",
                            "Implantation suspension",
                            "Suspension zur Implantation",
                            "Suspension pour implantation",
                            "Catenella per impianto"),
    /**
     * EN: Implantation tablet.<br>
     * DE: Tablette zur Implantation.<br>
     * FR: Comprimé pour implantation.<br>
     * IT: Compressa per impianto.<br>
     */
    IMPLANTATION_TABLET("11302000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Implantation tablet",
                        "Implantation tablet",
                        "Tablette zur Implantation",
                        "Comprimé pour implantation",
                        "Compressa per impianto"),
    /**
     * EN: Impregnated dressing.<br>
     * DE: imprägnierter Verband.<br>
     * FR: Compresse imprégnée.<br>
     * IT: Garza impregnata.<br>
     */
    IMPREGNATED_DRESSING("10525000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Impregnated dressing",
                         "Impregnated dressing",
                         "imprägnierter Verband",
                         "Compresse imprégnée",
                         "Garza impregnata"),
    /**
     * EN: Impregnated pad.<br>
     * DE: Imprägnierter Tampon.<br>
     * FR: Tampon imprégné.<br>
     * IT: Tampone medicato.<br>
     */
    IMPREGNATED_PAD("12117000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Impregnated pad",
                    "Impregnated pad",
                    "Imprägnierter Tampon",
                    "Tampon imprégné",
                    "Tampone medicato"),
    /**
     * EN: Impregnated plug.<br>
     * DE: Imprägnierter Einsatz.<br>
     * FR: Support poreux imprégné.<br>
     * IT: Supporto medicato.<br>
     */
    IMPREGNATED_PLUG("12117500",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Impregnated plug",
                     "Impregnated plug",
                     "Imprägnierter Einsatz",
                     "Support poreux imprégné",
                     "Supporto medicato"),
    /**
     * EN: Inhalation powder.<br>
     * DE: Pulver zur Inhalation.<br>
     * FR: Poudre pour inhalation.<br>
     * IT: Polvere per inalazione.<br>
     */
    INHALATION_POWDER("11109000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Inhalation powder",
                      "Inhalation powder",
                      "Pulver zur Inhalation",
                      "Poudre pour inhalation",
                      "Polvere per inalazione"),
    /**
     * EN: Inhalation powder, hard capsule.<br>
     * DE: Hartkapsel mit Pulver zur Inhalation.<br>
     * FR: Poudre pour inhalation en gélule.<br>
     * IT: Polvere per inalazione, capsula rigida.<br>
     */
    INHALATION_POWDER_HARD_CAPSULE("11110000",
                                   "0.4.0.127.0.16.1.1.2.1",
                                   "Inhalation powder, hard capsule",
                                   "Inhalation powder, hard capsule",
                                   "Hartkapsel mit Pulver zur Inhalation",
                                   "Poudre pour inhalation en gélule",
                                   "Polvere per inalazione, capsula rigida"),
    /**
     * EN: Inhalation powder, pre-dispensed.<br>
     * DE: einzeldosiertes Pulver zur Inhalation.<br>
     * FR: Poudre pour inhalation en récipient unidose.<br>
     * IT: Polvere per inalazione, pre-dosata.<br>
     */
    INHALATION_POWDER_PRE_DISPENSED("11111000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Inhalation powder, pre-dispensed",
                                    "Inhalation powder, pre-dispensed",
                                    "einzeldosiertes Pulver zur Inhalation",
                                    "Poudre pour inhalation en récipient unidose",
                                    "Polvere per inalazione, pre-dosata"),
    /**
     * EN: Inhalation powder, tablet.<br>
     * DE: Tablette mit Pulver zur Inhalation.<br>
     * FR: Comprimé pour inhalation par poudre.<br>
     * IT: Polvere per inalazione, compressa.<br>
     */
    INHALATION_POWDER_TABLET("50030000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Inhalation powder, tablet",
                             "Inhalation powder, tablet",
                             "Tablette mit Pulver zur Inhalation",
                             "Comprimé pour inhalation par poudre",
                             "Polvere per inalazione, compressa"),
    /**
     * EN: Inhalation solution.<br>
     * DE: Lösung zur Inhalation.<br>
     * FR: Solution à inhaler.<br>
     * IT: Soluzione per inalazione.<br>
     */
    INHALATION_SOLUTION("50081000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Inhalation solution",
                        "Inhalation solution",
                        "Lösung zur Inhalation",
                        "Solution à inhaler",
                        "Soluzione per inalazione"),
    /**
     * EN: Inhalation vapour, capsule.<br>
     * DE: Kapsel zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Capsule pour inhalation par vapeur.<br>
     * IT: Capsula per suffumigi.<br>
     */
    INHALATION_VAPOUR_CAPSULE("11113000",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Inhalation vapour, capsule",
                              "Inhalation vapour, capsule",
                              "Kapsel zur Herstellung eines Dampfs zur Inhalation",
                              "Capsule pour inhalation par vapeur",
                              "Capsula per suffumigi"),
    /**
     * EN: Inhalation vapour, effervescent tablet.<br>
     * DE: Brausetablette zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Comprimé effervescent pour inhalation par vapeur.<br>
     * IT: Vapore  per inalazione, compressa effervescente.<br>
     */
    INHALATION_VAPOUR_EFFERVESCENT_TABLET("50031000",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Inhalation vapour, effervescent tablet",
                                          "Inhalation vapour, effervescent tablet",
                                          "Brausetablette zur Herstellung eines Dampfs zur Inhalation",
                                          "Comprimé effervescent pour inhalation par vapeur",
                                          "Vapore  per inalazione, compressa effervescente"),
    /**
     * EN: Inhalation vapour, emulsion.<br>
     * DE: Emulsion zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Emulsion pour inhalation par vapeur.<br>
     * IT: Vapore per inalazione, emulsione.<br>
     */
    INHALATION_VAPOUR_EMULSION("50032000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Inhalation vapour, emulsion",
                               "Inhalation vapour, emulsion",
                               "Emulsion zur Herstellung eines Dampfs zur Inhalation",
                               "Emulsion pour inhalation par vapeur",
                               "Vapore per inalazione, emulsione"),
    /**
     * EN: Inhalation vapour, impregnated pad.<br>
     * DE: Dampf zur Inhalation, imprägnierter Einsatz.<br>
     * FR: Tampon imprégné pour inhalation par vapeur.<br>
     * IT: Vapore per inalazione, tampone medicato.<br>
     */
    INHALATION_VAPOUR_IMPREGNATED_PAD("50033000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Inhalation vapour, impregnated pad",
                                      "Inhalation vapour, impregnated pad",
                                      "Dampf zur Inhalation, imprägnierter Einsatz",
                                      "Tampon imprégné pour inhalation par vapeur",
                                      "Vapore per inalazione, tampone medicato"),
    /**
     * EN: Inhalation vapour, impregnated plug.<br>
     * DE: Dampf zur Inhalation, imprägnierter Einsatz.<br>
     * FR: Support poreux imprégné pour inhalation par vapeur.<br>
     * IT: Vapore per inalazione, supporto medicato.<br>
     */
    INHALATION_VAPOUR_IMPREGNATED_PLUG("50033100",
                                       "0.4.0.127.0.16.1.1.2.1",
                                       "Inhalation vapour, impregnated plug",
                                       "Inhalation vapour, impregnated plug",
                                       "Dampf zur Inhalation, imprägnierter Einsatz",
                                       "Support poreux imprégné pour inhalation par vapeur",
                                       "Vapore per inalazione, supporto medicato"),
    /**
     * EN: Inhalation vapour, liquid.<br>
     * DE: Flüssigkeit zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Liquide pour inhalation par vapeur.<br>
     * IT: Liquido per  suffumigi.<br>
     */
    INHALATION_VAPOUR_LIQUID("11117000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Inhalation vapour, liquid",
                             "Inhalation vapour, liquid",
                             "Flüssigkeit zur Herstellung eines Dampfs zur Inhalation",
                             "Liquide pour inhalation par vapeur",
                             "Liquido per  suffumigi"),
    /**
     * EN: Inhalation vapour, ointment.<br>
     * DE: Salbe zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Pommade pour inhalation par vapeur.<br>
     * IT: Unguento per suffumigi.<br>
     */
    INHALATION_VAPOUR_OINTMENT("11116000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Inhalation vapour, ointment",
                               "Inhalation vapour, ointment",
                               "Salbe zur Herstellung eines Dampfs zur Inhalation",
                               "Pommade pour inhalation par vapeur",
                               "Unguento per suffumigi"),
    /**
     * EN: Inhalation vapour, powder.<br>
     * DE: Pulver zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Poudre pour inhalation par vapeur.<br>
     * IT: Polvere per suffumigi.<br>
     */
    INHALATION_VAPOUR_POWDER("11112000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Inhalation vapour, powder",
                             "Inhalation vapour, powder",
                             "Pulver zur Herstellung eines Dampfs zur Inhalation",
                             "Poudre pour inhalation par vapeur",
                             "Polvere per suffumigi"),
    /**
     * EN: Inhalation vapour, solution.<br>
     * DE: Lösung zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Solution pour inhalation par vapeur.<br>
     * IT: Soluzione per  suffumigi.<br>
     */
    INHALATION_VAPOUR_SOLUTION("11114000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Inhalation vapour, solution",
                               "Inhalation vapour, solution",
                               "Lösung zur Herstellung eines Dampfs zur Inhalation",
                               "Solution pour inhalation par vapeur",
                               "Soluzione per  suffumigi"),
    /**
     * EN: Inhalation vapour, tablet.<br>
     * DE: Tablette zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Comprimé pour inhalation par vapeur.<br>
     * IT: Compressa per  suffumigi.<br>
     */
    INHALATION_VAPOUR_TABLET("11115000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Inhalation vapour, tablet",
                             "Inhalation vapour, tablet",
                             "Tablette zur Herstellung eines Dampfs zur Inhalation",
                             "Comprimé pour inhalation par vapeur",
                             "Compressa per  suffumigi"),
    /**
     * EN: Instant herbal tea.<br>
     * DE: Teeaufgusspulver.<br>
     * FR: Préparation instantanée pour tisane.<br>
     * IT: Tisana, polvere solubile.<br>
     */
    INSTANT_HERBAL_TEA("10202000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Instant herbal tea",
                       "Instant herbal tea",
                       "Teeaufgusspulver",
                       "Préparation instantanée pour tisane",
                       "Tisana, polvere solubile"),
    /**
     * EN: Intestinal gel.<br>
     * DE: Gel zur intestinalen Anwendung.<br>
     * FR: Gel intestinal.<br>
     * IT: Gel intestinale.<br>
     */
    INTESTINAL_GEL("12120000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Intestinal gel",
                   "Intestinal gel",
                   "Gel zur intestinalen Anwendung",
                   "Gel intestinal",
                   "Gel intestinale"),
    /**
     * EN: Intraocular instillation solution.<br>
     * DE: Lösung zur intraokularen Instillation.<br>
     * FR: Solution pour instillation intraoculaire.<br>
     * IT: Soluzione per instillazione intraoculare.<br>
     */
    INTRAOCULAR_INSTILLATION_SOLUTION("13044000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Intraocular instillation solution",
                                      "Intraocular instillation solution",
                                      "Lösung zur intraokularen Instillation",
                                      "Solution pour instillation intraoculaire",
                                      "Soluzione per instillazione intraoculare"),
    /**
     * EN: Intraperitoneal solution.<br>
     * DE: Lösung zur intraperitonealen Awendung.<br>
     * FR: Solution intrapéritonéale.<br>
     * IT: Soluzione intraperitoneale.<br>
     */
    INTRAPERITONEAL_SOLUTION("12111500",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Intraperitoneal solution",
                             "Intraperitoneal solution",
                             "Lösung zur intraperitonealen Awendung",
                             "Solution intrapéritonéale",
                             "Soluzione intraperitoneale"),
    /**
     * EN: Intrauterine delivery system.<br>
     * DE: Intrauterines Wirkstofffreisetzungssystem.<br>
     * FR: Système de diffusion intra-utérin.<br>
     * IT: Sistema a rilascio intrauterino.<br>
     */
    INTRAUTERINE_DELIVERY_SYSTEM("11901000",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Intrauterine delivery system",
                                 "Intrauterine delivery system",
                                 "Intrauterines Wirkstofffreisetzungssystem",
                                 "Système de diffusion intra-utérin",
                                 "Sistema a rilascio intrauterino"),
    /**
     * EN: Intrauterine gel.<br>
     * DE: Gel zur intrauterinen Anwendung.<br>
     * FR: Gel intra-utérin.<br>
     * IT: Gel intrauterino.<br>
     */
    INTRAUTERINE_GEL("13113000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intrauterine gel",
                     "Intrauterine gel",
                     "Gel zur intrauterinen Anwendung",
                     "Gel intra-utérin",
                     "Gel intrauterino"),
    /**
     * EN: Intravesical solution.<br>
     * DE: Lösung zur intravesikalen Anwendung.<br>
     * FR: Solution intravésicale.<br>
     * IT: Soluzione endovescicale.<br>
     */
    INTRAVESICAL_SOLUTION("11502500",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Intravesical solution",
                          "Intravesical solution",
                          "Lösung zur intravesikalen Anwendung",
                          "Solution intravésicale",
                          "Soluzione endovescicale"),
    /**
     * EN: Intravesical solution/solution for injection.<br>
     * DE: Lösung zur intravesikalen Anwendung/Injektionslösung.<br>
     * FR: Solution intravésicale/solution injectable.<br>
     * IT: Soluzione endovescicale/soluzione iniettabile.<br>
     */
    INTRAVESICAL_SOLUTION_SOLUTION_FOR_INJECTION("50033400",
                                                 "0.4.0.127.0.16.1.1.2.1",
                                                 "Intravesical solution/solution for injection",
                                                 "Intravesical solution/solution for injection",
                                                 "Lösung zur intravesikalen Anwendung/Injektionslösung",
                                                 "Solution intravésicale/solution injectable",
                                                 "Soluzione endovescicale/soluzione iniettabile"),
    /**
     * EN: Intravesical suspension.<br>
     * DE: Suspension zur intravesikalen Anwendung.<br>
     * FR: Suspension intravésicale.<br>
     * IT: Sospensione endovescicale.<br>
     */
    INTRAVESICAL_SUSPENSION("13045000",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Intravesical suspension",
                            "Intravesical suspension",
                            "Suspension zur intravesikalen Anwendung",
                            "Suspension intravésicale",
                            "Sospensione endovescicale"),
    /**
     * EN: Irrigation solution.<br>
     * DE: Spüllösung.<br>
     * FR: Solution pour irrigation.<br>
     * IT: Soluzione per irrigazione.<br>
     */
    IRRIGATION_SOLUTION("12113000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Irrigation solution",
                        "Irrigation solution",
                        "Spüllösung",
                        "Solution pour irrigation",
                        "Soluzione per irrigazione"),
    /**
     * EN: Kit for radiopharmaceutical preparation.<br>
     * DE: Kit für ein radioaktives Arzneimittel.<br>
     * FR: Trousse pour préparation radiopharmaceutique.<br>
     * IT: Kit per preparazione radiofarmaceutica.<br>
     */
    KIT_FOR_RADIOPHARMACEUTICAL_PREPARATION("12107000",
                                            "0.4.0.127.0.16.1.1.2.1",
                                            "Kit for radiopharmaceutical preparation",
                                            "Kit for radiopharmaceutical preparation",
                                            "Kit für ein radioaktives Arzneimittel",
                                            "Trousse pour préparation radiopharmaceutique",
                                            "Kit per preparazione radiofarmaceutica"),
    /**
     * EN: Laryngopharyngeal solution.<br>
     * DE: Lösung zur Anwendung im Rachenraum und am Kehlkopf.<br>
     * FR: Solution laryngopharyngée.<br>
     * IT: Soluzione laringofaringea.<br>
     */
    LARYNGOPHARYNGEAL_SOLUTION("13016000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Laryngopharyngeal solution",
                               "Laryngopharyngeal solution",
                               "Lösung zur Anwendung im Rachenraum und am Kehlkopf",
                               "Solution laryngopharyngée",
                               "Soluzione laringofaringea"),
    /**
     * EN: Laryngopharyngeal spray, solution.<br>
     * DE: Spray zur Anwendung im Rachenraum und am Kehlkopf, Lösung.<br>
     * FR: Solution pour pulvérisation laryngopharyngée.<br>
     * IT: Spray laringofaringeo, soluzione.<br>
     */
    LARYNGOPHARYNGEAL_SPRAY_SOLUTION("13017000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Laryngopharyngeal spray, solution",
                                     "Laryngopharyngeal spray, solution",
                                     "Spray zur Anwendung im Rachenraum und am Kehlkopf, Lösung",
                                     "Solution pour pulvérisation laryngopharyngée",
                                     "Spray laringofaringeo, soluzione"),
    /**
     * EN: Living tissue equivalent.<br>
     * DE: lebendes Gewebeäquivalent.<br>
     * FR: Substitut de tissu vivant.<br>
     * IT: Tessuto vivente da coltura di cellule.<br>
     */
    LIVING_TISSUE_EQUIVALENT("12118000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Living tissue equivalent",
                             "Living tissue equivalent",
                             "lebendes Gewebeäquivalent",
                             "Substitut de tissu vivant",
                             "Tessuto vivente da coltura di cellule"),
    /**
     * EN: Lozenge.<br>
     * DE: Lutschtablette.<br>
     * FR: Pastille.<br>
     * IT: Pastiglia.<br>
     */
    LOZENGE("10321000",
            "0.4.0.127.0.16.1.1.2.1",
            "Lozenge",
            "Lozenge",
            "Lutschtablette",
            "Pastille",
            "Pastiglia"),
    /**
     * EN: Matrix for implantation matrix.<br>
     * DE: Matrix für Matrix zur Implantation.<br>
     * FR: Matrice pour matrice pour implantation.<br>
     * IT: Spray laringofaringeo, soluzione.<br>
     */
    MATRIX_FOR_IMPLANTATION_MATRIX("13018000",
                                   "0.4.0.127.0.16.1.1.2.1",
                                   "Matrix for implantation matrix",
                                   "Matrix for implantation matrix",
                                   "Matrix für Matrix zur Implantation",
                                   "Matrice pour matrice pour implantation",
                                   "Spray laringofaringeo, soluzione"),
    /**
     * EN: Medicated chewing-gum.<br>
     * DE: wirkstoffhaltiges Kaugummi.<br>
     * FR: Gomme à mâcher médicamenteuse.<br>
     * IT: Gomma da masticare medicata.<br>
     */
    MEDICATED_CHEWING_GUM("10229000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Medicated chewing-gum",
                          "Medicated chewing-gum",
                          "wirkstoffhaltiges Kaugummi",
                          "Gomme à mâcher médicamenteuse",
                          "Gomma da masticare medicata"),
    /**
     * EN: Medicated nail lacquer.<br>
     * DE: wirkstoffhaltiger Nagellack.<br>
     * FR: Vernis à ongles médicamenteux.<br>
     * IT: Smalto medicato per unghie.<br>
     */
    MEDICATED_NAIL_LACQUER("10521000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Medicated nail lacquer",
                           "Medicated nail lacquer",
                           "wirkstoffhaltiger Nagellack",
                           "Vernis à ongles médicamenteux",
                           "Smalto medicato per unghie"),
    /**
     * EN: Medicated plaster.<br>
     * DE: wirkstoffhaltiges Pflaster.<br>
     * FR: Emplâtre médicamenteux.<br>
     * IT: Cerotto medicato.<br>
     */
    MEDICATED_PLASTER("10506000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Medicated plaster",
                      "Medicated plaster",
                      "wirkstoffhaltiges Pflaster",
                      "Emplâtre médicamenteux",
                      "Cerotto medicato"),
    /**
     * EN: Medicated sponge.<br>
     * DE: wirkstoffhaltiges Schwämmchen.<br>
     * FR: Eponge médicamenteuse.<br>
     * IT: Spugna medicata.<br>
     */
    MEDICATED_SPONGE("12119000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Medicated sponge",
                     "Medicated sponge",
                     "wirkstoffhaltiges Schwämmchen",
                     "Eponge médicamenteuse",
                     "Spugna medicata"),
    /**
     * EN: Medicated thread.<br>
     * DE: wirkstoffhaltiger Faden.<br>
     * FR: Fils médicamenteux.<br>
     * IT: Filo medicato.<br>
     */
    MEDICATED_THREAD("12130000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Medicated thread",
                     "Medicated thread",
                     "wirkstoffhaltiger Faden",
                     "Fils médicamenteux",
                     "Filo medicato"),
    /**
     * EN: Medicated vaginal tampon.<br>
     * DE: Wirkstoffhaltiger Vaginaltampon.<br>
     * FR: Tampon vaginal médicamenteux.<br>
     * IT: Tampone vaginale medicato.<br>
     */
    MEDICATED_VAGINAL_TAMPON("10914000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Medicated vaginal tampon",
                             "Medicated vaginal tampon",
                             "Wirkstoffhaltiger Vaginaltampon",
                             "Tampon vaginal médicamenteux",
                             "Tampone vaginale medicato"),
    /**
     * EN: Medicinal gas, compressed.<br>
     * DE: Gas zur medizinischen Anwendung, druckverdichtet.<br>
     * FR: Gaz médicinal comprimé.<br>
     * IT: Gas medicinale compresso.<br>
     */
    MEDICINAL_GAS_COMPRESSED("12301000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Medicinal gas, compressed",
                             "Medicinal gas, compressed",
                             "Gas zur medizinischen Anwendung, druckverdichtet",
                             "Gaz médicinal comprimé",
                             "Gas medicinale compresso"),
    /**
     * EN: Medicinal gas, cryogenic.<br>
     * DE: Gas zur medizinischen Anwendung, kälteverflüssigt.<br>
     * FR: Gaz médicinal cryogénique.<br>
     * IT: Gas medicinale criogenico.<br>
     */
    MEDICINAL_GAS_CRYOGENIC("12302000",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Medicinal gas, cryogenic",
                            "Medicinal gas, cryogenic",
                            "Gas zur medizinischen Anwendung, kälteverflüssigt",
                            "Gaz médicinal cryogénique",
                            "Gas medicinale criogenico"),
    /**
     * EN: Medicinal gas, liquefied.<br>
     * DE: Gas zur medizinischen Anwendung, verflüssigt.<br>
     * FR: Gaz médicinal liquéfié.<br>
     * IT: Gas medicinale liquefatto.<br>
     */
    MEDICINAL_GAS_LIQUEFIED("12303000",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Medicinal gas, liquefied",
                            "Medicinal gas, liquefied",
                            "Gas zur medizinischen Anwendung, verflüssigt",
                            "Gaz médicinal liquéfié",
                            "Gas medicinale liquefatto"),
    /**
     * EN: Medicinal larvae.<br>
     * DE: Larven zur medizinischen Anwendung.<br>
     * FR: Larves médicinales.<br>
     * IT: Larva medicinale.<br>
     */
    MEDICINAL_LARVAE("13124000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Medicinal larvae",
                     "Medicinal larvae",
                     "Larven zur medizinischen Anwendung",
                     "Larves médicinales",
                     "Larva medicinale"),
    /**
     * EN: Medicinal leech.<br>
     * DE: Blutegel zur medizinischen Anwendung.<br>
     * FR: Sangsue médicinale.<br>
     * IT: Sanguisuga medicinale.<br>
     */
    MEDICINAL_LEECH("13115000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Medicinal leech",
                    "Medicinal leech",
                    "Blutegel zur medizinischen Anwendung",
                    "Sangsue médicinale",
                    "Sanguisuga medicinale"),
    /**
     * EN: Modified-release capsule, hard.<br>
     * DE: Hartkapsel mit veränderter Wirkstofffreisetzung.<br>
     * FR: Gélule à libération modifiée.<br>
     * IT: Capsula rigida a rilascio modificato.<br>
     */
    MODIFIED_RELEASE_CAPSULE_HARD("10217000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Modified-release capsule, hard",
                                  "Modified-release capsule, hard",
                                  "Hartkapsel mit veränderter Wirkstofffreisetzung",
                                  "Gélule à libération modifiée",
                                  "Capsula rigida a rilascio modificato"),
    /**
     * EN: Modified-release capsule, soft.<br>
     * DE: Weichkapsel mit veränderter Wirkstofffreisetzung.<br>
     * FR: Capsule molle à libération modifiée.<br>
     * IT: Capsula molle a rilascio modificato.<br>
     */
    MODIFIED_RELEASE_CAPSULE_SOFT("10218000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Modified-release capsule, soft",
                                  "Modified-release capsule, soft",
                                  "Weichkapsel mit veränderter Wirkstofffreisetzung",
                                  "Capsule molle à libération modifiée",
                                  "Capsula molle a rilascio modificato"),
    /**
     * EN: Modified-release granules.<br>
     * DE: Granulat mit veränderter Wirkstofffreisetzung.<br>
     * FR: Granulés à libération modifiée.<br>
     * IT: Granulato a rilascio modificato.<br>
     */
    MODIFIED_RELEASE_GRANULES("10208000",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Modified-release granules",
                              "Modified-release granules",
                              "Granulat mit veränderter Wirkstofffreisetzung",
                              "Granulés à libération modifiée",
                              "Granulato a rilascio modificato"),
    /**
     * EN: Modified-release granules for oral suspension.<br>
     * DE: Granulat mit veränderter Wirkstofffreisetzung zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Granulés à libération modifiée pour suspension buvable.<br>
     * IT: Granulato a rilascio modificato per sospensione orale.<br>
     */
    MODIFIED_RELEASE_GRANULES_FOR_ORAL_SUSPENSION("50036000",
                                                  "0.4.0.127.0.16.1.1.2.1",
                                                  "Modified-release granules for oral suspension",
                                                  "Modified-release granules for oral suspension",
                                                  "Granulat mit veränderter Wirkstofffreisetzung zur Herstellung einer Suspension zum Einnehmen",
                                                  "Granulés à libération modifiée pour suspension buvable",
                                                  "Granulato a rilascio modificato per sospensione orale"),
    /**
     * EN: Modified-release oral suspension.<br>
     * DE: Suspension zum Einnehmen mit veränderter Wirkstofffreisetzung.<br>
     * FR: Solution à libération prolongée intralésionnelle.<br>
     * IT: Larva medicinale.<br>
     */
    MODIFIED_RELEASE_ORAL_SUSPENSION("13135000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Modified-release oral suspension",
                                     "Modified-release oral suspension",
                                     "Suspension zum Einnehmen mit veränderter Wirkstofffreisetzung",
                                     "Solution à libération prolongée intralésionnelle",
                                     "Larva medicinale"),
    /**
     * EN: Modified-release tablet.<br>
     * DE: Tablette mit veränderter Wirkstofffreisetzung.<br>
     * FR: Comprimé à libération modifiée.<br>
     * IT: Compressa a rilascio modificato.<br>
     */
    MODIFIED_RELEASE_TABLET("10227000",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Modified-release tablet",
                            "Modified-release tablet",
                            "Tablette mit veränderter Wirkstofffreisetzung",
                            "Comprimé à libération modifiée",
                            "Compressa a rilascio modificato"),
    /**
     * EN: Mouthwash.<br>
     * DE: Mundspülung.<br>
     * FR: Solution pour bain de bouche.<br>
     * IT: Collutorio.<br>
     */
    MOUTHWASH("10310000",
              "0.4.0.127.0.16.1.1.2.1",
              "Mouthwash",
              "Mouthwash",
              "Mundspülung",
              "Solution pour bain de bouche",
              "Collutorio"),
    /**
     * EN: Mouthwash, powder for solution.<br>
     * DE: Pulver zur Herstellung einer Mundspülung, Lösung.<br>
     * FR: Poudre pour solution pour bain de bouche.<br>
     * IT: Collutorio, polvere per soluzione.<br>
     */
    MOUTHWASH_POWDER_FOR_SOLUTION("50036050",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Mouthwash, powder for solution",
                                  "Mouthwash, powder for solution",
                                  "Pulver zur Herstellung einer Mundspülung, Lösung",
                                  "Poudre pour solution pour bain de bouche",
                                  "Collutorio, polvere per soluzione"),
    /**
     * EN: Mouthwash, tablet for solution.<br>
     * DE: Tablette zur Herstellung einer Mundspülung.<br>
     * FR: Comprimé pour solution pour bain de bouche.<br>
     * IT: Compressa per soluzione per collutorio.<br>
     */
    MOUTHWASH_TABLET_FOR_SOLUTION("10311000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Mouthwash, tablet for solution",
                                  "Mouthwash, tablet for solution",
                                  "Tablette zur Herstellung einer Mundspülung",
                                  "Comprimé pour solution pour bain de bouche",
                                  "Compressa per soluzione per collutorio"),
    /**
     * EN: Muco-adhesive buccal tablet.<br>
     * DE: mucoadhäsive Buccaltablette.<br>
     * FR: Comprimé buccogingival muco-adhésif.<br>
     * IT: Compressa buccale mucoadesiva.<br>
     */
    MUCO_ADHESIVE_BUCCAL_TABLET("10319000",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Muco-adhesive buccal tablet",
                                "Muco-adhesive buccal tablet",
                                "mucoadhäsive Buccaltablette",
                                "Comprimé buccogingival muco-adhésif",
                                "Compressa buccale mucoadesiva"),
    /**
     * EN: Nasal cream.<br>
     * DE: Nasencreme.<br>
     * FR: Crème nasale.<br>
     * IT: Crema nasale.<br>
     */
    NASAL_CREAM("10801000",
                "0.4.0.127.0.16.1.1.2.1",
                "Nasal cream",
                "Nasal cream",
                "Nasencreme",
                "Crème nasale",
                "Crema nasale"),
    /**
     * EN: Nasal drops, emulsion.<br>
     * DE: Nasentropfen, Emulsion.<br>
     * FR: Emulsion nasale en gouttes.<br>
     * IT: Gocce nasali, emulsione.<br>
     */
    NASAL_DROPS_EMULSION("10806000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Nasal drops, emulsion",
                         "Nasal drops, emulsion",
                         "Nasentropfen, Emulsion",
                         "Emulsion nasale en gouttes",
                         "Gocce nasali, emulsione"),
    /**
     * EN: Nasal drops, powder for solution.<br>
     * DE: Pulver zur Herstellung von Nasentropfen, Lösung.<br>
     * FR: Poudre pour solution nasale en gouttes.<br>
     * IT: Gocce nasali, polvere per soluzione.<br>
     */
    NASAL_DROPS_POWDER_FOR_SOLUTION("13020000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Nasal drops, powder for solution",
                                    "Nasal drops, powder for solution",
                                    "Pulver zur Herstellung von Nasentropfen, Lösung",
                                    "Poudre pour solution nasale en gouttes",
                                    "Gocce nasali, polvere per soluzione"),
    /**
     * EN: Nasal drops, solution.<br>
     * DE: Nasentropfen, Lösung.<br>
     * FR: Solution nasale en gouttes.<br>
     * IT: Gocce nasali, soluzione.<br>
     */
    NASAL_DROPS_SOLUTION("10804000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Nasal drops, solution",
                         "Nasal drops, solution",
                         "Nasentropfen, Lösung",
                         "Solution nasale en gouttes",
                         "Gocce nasali, soluzione"),
    /**
     * EN: Nasal drops, suspension.<br>
     * DE: Nasentropfen, Suspension.<br>
     * FR: Suspension nasale en gouttes.<br>
     * IT: Gocce nasali, sospensione.<br>
     */
    NASAL_DROPS_SUSPENSION("10805000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Nasal drops, suspension",
                           "Nasal drops, suspension",
                           "Nasentropfen, Suspension",
                           "Suspension nasale en gouttes",
                           "Gocce nasali, sospensione"),
    /**
     * EN: Nasal gel.<br>
     * DE: Nasengel.<br>
     * FR: Gel nasal.<br>
     * IT: Gel nasale.<br>
     */
    NASAL_GEL("10802000",
              "0.4.0.127.0.16.1.1.2.1",
              "Nasal gel",
              "Nasal gel",
              "Nasengel",
              "Gel nasal",
              "Gel nasale"),
    /**
     * EN: Nasal ointment.<br>
     * DE: Nasensalbe.<br>
     * FR: Pommade nasale.<br>
     * IT: Unguento nasale.<br>
     */
    NASAL_OINTMENT("10803000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Nasal ointment",
                   "Nasal ointment",
                   "Nasensalbe",
                   "Pommade nasale",
                   "Unguento nasale"),
    /**
     * EN: Nasal/oromucosal solution.<br>
     * DE: Lösung zur nasalen Anwendung/Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Solution nasale/buccale.<br>
     * IT: Soluzione nasale/per mucosa orale.<br>
     */
    NASAL_OROMUCOSAL_SOLUTION("50036500",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Nasal/oromucosal solution",
                              "Nasal/oromucosal solution",
                              "Lösung zur nasalen Anwendung/Lösung zur Anwendung in der Mundhöhle",
                              "Solution nasale/buccale",
                              "Soluzione nasale/per mucosa orale"),
    /**
     * EN: Nasal/oromucosal spray, solution.<br>
     * DE: Nasenspray und Spray zur Anwendung in der Mundhöhle, Lösung.<br>
     * FR: Solution pour pulvérisation nasale/ buccale.<br>
     * IT: Spray nasale/per mucosa orale, soluzione.<br>
     */
    NASAL_OROMUCOSAL_SPRAY_SOLUTION("50036700",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Nasal/oromucosal spray, solution",
                                    "Nasal/oromucosal spray, solution",
                                    "Nasenspray und Spray zur Anwendung in der Mundhöhle, Lösung",
                                    "Solution pour pulvérisation nasale/ buccale",
                                    "Spray nasale/per mucosa orale, soluzione"),
    /**
     * EN: Nasal powder.<br>
     * DE: Nasenpulver.<br>
     * FR: Poudre nasale.<br>
     * IT: Polvere nasale.<br>
     */
    NASAL_POWDER("10807000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Nasal powder",
                 "Nasal powder",
                 "Nasenpulver",
                 "Poudre nasale",
                 "Polvere nasale"),
    /**
     * EN: Nasal spray, emulsion.<br>
     * DE: Nasenspray, Emulsion.<br>
     * FR: Emulsion pour pulvérisation nasale.<br>
     * IT: Spray nasale, emulsione.<br>
     */
    NASAL_SPRAY_EMULSION("10810000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Nasal spray, emulsion",
                         "Nasal spray, emulsion",
                         "Nasenspray, Emulsion",
                         "Emulsion pour pulvérisation nasale",
                         "Spray nasale, emulsione"),
    /**
     * EN: Nasal spray, powder for solution.<br>
     * DE: Nasenspray, Pulver zur Herstellung einer Lösung.<br>
     * FR: Poudre pour solution pour pulvérisation nasale.<br>
     * IT: Spray nasale, polvere per soluzione.<br>
     */
    NASAL_SPRAY_POWDER_FOR_SOLUTION("50037100",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Nasal spray, powder for solution",
                                    "Nasal spray, powder for solution",
                                    "Nasenspray, Pulver zur Herstellung einer Lösung",
                                    "Poudre pour solution pour pulvérisation nasale",
                                    "Spray nasale, polvere per soluzione"),
    /**
     * EN: Nasal spray, solution.<br>
     * DE: Nasenspray, Lösung.<br>
     * FR: Solution pour pulvérisation nasale.<br>
     * IT: Spray nasale, soluzione.<br>
     */
    NASAL_SPRAY_SOLUTION("10808000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Nasal spray, solution",
                         "Nasal spray, solution",
                         "Nasenspray, Lösung",
                         "Solution pour pulvérisation nasale",
                         "Spray nasale, soluzione"),
    /**
     * EN: Nasal spray, solution/oromucosal solution.<br>
     * DE: Nasenspray, Lösung/Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Solution pour pulvérisation nasale/ solution buccale.<br>
     * IT: Spray nasale, soluzione/soluzione per mucosa orale.<br>
     */
    NASAL_SPRAY_SOLUTION_OROMUCOSAL_SOLUTION("50037400",
                                             "0.4.0.127.0.16.1.1.2.1",
                                             "Nasal spray, solution/oromucosal solution",
                                             "Nasal spray, solution/oromucosal solution",
                                             "Nasenspray, Lösung/Lösung zur Anwendung in der Mundhöhle",
                                             "Solution pour pulvérisation nasale/ solution buccale",
                                             "Spray nasale, soluzione/soluzione per mucosa orale"),
    /**
     * EN: Nasal spray, suspension.<br>
     * DE: Nasenspray, Suspension.<br>
     * FR: Suspension pour pulvérisation nasale.<br>
     * IT: Spray nasale, sospensione.<br>
     */
    NASAL_SPRAY_SUSPENSION("10809000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Nasal spray, suspension",
                           "Nasal spray, suspension",
                           "Nasenspray, Suspension",
                           "Suspension pour pulvérisation nasale",
                           "Spray nasale, sospensione"),
    /**
     * EN: Nasal stick.<br>
     * DE: Nasenstift.<br>
     * FR: Bâton pour usage nasal.<br>
     * IT: Bastoncino nasale.<br>
     */
    NASAL_STICK("10812000",
                "0.4.0.127.0.16.1.1.2.1",
                "Nasal stick",
                "Nasal stick",
                "Nasenstift",
                "Bâton pour usage nasal",
                "Bastoncino nasale"),
    /**
     * EN: Nasal wash.<br>
     * DE: Nasenspülung.<br>
     * FR: Solution pour lavage nasal.<br>
     * IT: Lavaggio nasale.<br>
     */
    NASAL_WASH("10811000",
               "0.4.0.127.0.16.1.1.2.1",
               "Nasal wash",
               "Nasal wash",
               "Nasenspülung",
               "Solution pour lavage nasal",
               "Lavaggio nasale"),
    /**
     * EN: Nebuliser dispersion.<br>
     * DE: Lyophilisat zur sublingualen Anwendung.<br>
     * FR: Solution à libération prolongée intralésionnelle.<br>
     * IT: Larva medicinale.<br>
     */
    NEBULISER_DISPERSION("13129000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Nebuliser dispersion",
                         "Nebuliser dispersion",
                         "Lyophilisat zur sublingualen Anwendung",
                         "Solution à libération prolongée intralésionnelle",
                         "Larva medicinale"),
    /**
     * EN: Nebuliser emulsion.<br>
     * DE: Emulsion für einen Vernebler.<br>
     * FR: Emulsion pour inhalation par nébuliseur.<br>
     * IT: Emulsione per nebulizzatore.<br>
     */
    NEBULISER_EMULSION("11105000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Nebuliser emulsion",
                       "Nebuliser emulsion",
                       "Emulsion für einen Vernebler",
                       "Emulsion pour inhalation par nébuliseur",
                       "Emulsione per nebulizzatore"),
    /**
     * EN: Nebuliser solution.<br>
     * DE: Lösung für einen Vernebler.<br>
     * FR: Solution pour inhalation par nébuliseur.<br>
     * IT: Soluzione per nebulizzatore.<br>
     */
    NEBULISER_SOLUTION("11101000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Nebuliser solution",
                       "Nebuliser solution",
                       "Lösung für einen Vernebler",
                       "Solution pour inhalation par nébuliseur",
                       "Soluzione per nebulizzatore"),
    /**
     * EN: Nebuliser suspension.<br>
     * DE: Suspension für einen Vernebler.<br>
     * FR: Suspension pour inhalation par nébuliseur.<br>
     * IT: Sospensione per nebulizzatore.<br>
     */
    NEBULISER_SUSPENSION("11102000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Nebuliser suspension",
                         "Nebuliser suspension",
                         "Suspension für einen Vernebler",
                         "Suspension pour inhalation par nébuliseur",
                         "Sospensione per nebulizzatore"),
    /**
     * EN: Ointment.<br>
     * DE: Salbe.<br>
     * FR: Pommade.<br>
     * IT: Unguento.<br>
     */
    OINTMENT("10504000",
             "0.4.0.127.0.16.1.1.2.1",
             "Ointment",
             "Ointment",
             "Salbe",
             "Pommade",
             "Unguento"),
    /**
     * EN: Ophthalmic insert.<br>
     * DE: Augeninsert.<br>
     * FR: Insert ophtalmique.<br>
     * IT: Inserto oftalmico.<br>
     */
    OPHTHALMIC_INSERT("10612000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Ophthalmic insert",
                      "Ophthalmic insert",
                      "Augeninsert",
                      "Insert ophtalmique",
                      "Inserto oftalmico"),
    /**
     * EN: Ophthalmic strip.<br>
     * DE: Teststreifen zur Anwendung am Auge.<br>
     * FR: Bandelette ophtalmique.<br>
     * IT: Striscia oftalmica.<br>
     */
    OPHTHALMIC_STRIP("10613000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Ophthalmic strip",
                     "Ophthalmic strip",
                     "Teststreifen zur Anwendung am Auge",
                     "Bandelette ophtalmique",
                     "Striscia oftalmica"),
    /**
     * EN: Oral drops, emulsion.<br>
     * DE: Tropfen zum Einnehmen, Emulsion.<br>
     * FR: Emulsion buvable en gouttes.<br>
     * IT: Gocce orali, emulsione.<br>
     */
    ORAL_DROPS_EMULSION("10103000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Oral drops, emulsion",
                        "Oral drops, emulsion",
                        "Tropfen zum Einnehmen, Emulsion",
                        "Emulsion buvable en gouttes",
                        "Gocce orali, emulsione"),
    /**
     * EN: Oral drops, granules for solution.<br>
     * DE: Granulat zur Herstellung von Tropfen zum Einnehmen, Lösung.<br>
     * FR: Granulés pour solution buvale en gouttes.<br>
     * IT: Gocce orali, granulato per soluzione.<br>
     */
    ORAL_DROPS_GRANULES_FOR_SOLUTION("50037500",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Oral drops, granules for solution",
                                     "Oral drops, granules for solution",
                                     "Granulat zur Herstellung von Tropfen zum Einnehmen, Lösung",
                                     "Granulés pour solution buvale en gouttes",
                                     "Gocce orali, granulato per soluzione"),
    /**
     * EN: Oral drops, liquid.<br>
     * DE: Tropfen zum Einnehmen, Flüssigkeit.<br>
     * FR: Liquide oral en gouttes.<br>
     * IT: Gocce orali, liquido.<br>
     */
    ORAL_DROPS_LIQUID("50037750",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Oral drops, liquid",
                      "Oral drops, liquid",
                      "Tropfen zum Einnehmen, Flüssigkeit",
                      "Liquide oral en gouttes",
                      "Gocce orali, liquido"),
    /**
     * EN: Oral drops, powder for suspension.<br>
     * DE: Pulver zur Herstellung von Tropfen zum Einnehmen, Suspension.<br>
     * FR: Poudre pour suspension oral en gouttes.<br>
     * IT: Gocce orali, polvere per sospensione.<br>
     */
    ORAL_DROPS_POWDER_FOR_SUSPENSION("50082000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Oral drops, powder for suspension",
                                     "Oral drops, powder for suspension",
                                     "Pulver zur Herstellung von Tropfen zum Einnehmen, Suspension",
                                     "Poudre pour suspension oral en gouttes",
                                     "Gocce orali, polvere per sospensione"),
    /**
     * EN: Oral drops, solution.<br>
     * DE: Tropfen zum Einnehmen, Lösung.<br>
     * FR: Solution buvable en gouttes.<br>
     * IT: Gocce orali, soluzione.<br>
     */
    ORAL_DROPS_SOLUTION("10101000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Oral drops, solution",
                        "Oral drops, solution",
                        "Tropfen zum Einnehmen, Lösung",
                        "Solution buvable en gouttes",
                        "Gocce orali, soluzione"),
    /**
     * EN: Oral drops, suspension.<br>
     * DE: Tropfen zum Einnehmen, Suspension.<br>
     * FR: Suspension buvable en gouttes.<br>
     * IT: Gocce orali, sospensione.<br>
     */
    ORAL_DROPS_SUSPENSION("10102000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Oral drops, suspension",
                          "Oral drops, suspension",
                          "Tropfen zum Einnehmen, Suspension",
                          "Suspension buvable en gouttes",
                          "Gocce orali, sospensione"),
    /**
     * EN: Oral emulsion.<br>
     * DE: Emulsion zum Einnehmen.<br>
     * FR: Emulsion buvable.<br>
     * IT: Emulsione orale.<br>
     */
    ORAL_EMULSION("10107000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Oral emulsion",
                  "Oral emulsion",
                  "Emulsion zum Einnehmen",
                  "Emulsion buvable",
                  "Emulsione orale"),
    /**
     * EN: Oral gel.<br>
     * DE: Gel zum Einnehmen.<br>
     * FR: Gel oral.<br>
     * IT: Gel orale.<br>
     */
    ORAL_GEL("10108000",
             "0.4.0.127.0.16.1.1.2.1",
             "Oral gel",
             "Oral gel",
             "Gel zum Einnehmen",
             "Gel oral",
             "Gel orale"),
    /**
     * EN: Oral gum.<br>
     * DE: Lutschpastille.<br>
     * FR: Gomme orale.<br>
     * IT: Pastiglia gommosa.<br>
     */
    ORAL_GUM("10230000",
             "0.4.0.127.0.16.1.1.2.1",
             "Oral gum",
             "Oral gum",
             "Lutschpastille",
             "Gomme orale",
             "Pastiglia gommosa"),
    /**
     * EN: Oral herbal material.<br>
     * DE: Pflanzenteile zum Einnehmen.<br>
     * FR: -.<br>
     * IT: Sostanza di origine vegetale  per uso orale.<br>
     */
    ORAL_HERBAL_MATERIAL("13106000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Oral herbal material",
                         "Oral herbal material",
                         "Pflanzenteile zum Einnehmen",
                         "-",
                         "Sostanza di origine vegetale  per uso orale"),
    /**
     * EN: Oral liquid.<br>
     * DE: Flüssigkeit zum Einnehmen.<br>
     * FR: Liquide oral.<br>
     * IT: Liquido orale.<br>
     */
    ORAL_LIQUID("10104000",
                "0.4.0.127.0.16.1.1.2.1",
                "Oral liquid",
                "Oral liquid",
                "Flüssigkeit zum Einnehmen",
                "Liquide oral",
                "Liquido orale"),
    /**
     * EN: Oral lyophilisate.<br>
     * DE: Lyophilisat zum Einnehmen.<br>
     * FR: Lyophilisat oral.<br>
     * IT: Liofilizzato orale.<br>
     */
    ORAL_LYOPHILISATE("10224000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Oral lyophilisate",
                      "Oral lyophilisate",
                      "Lyophilisat zum Einnehmen",
                      "Lyophilisat oral",
                      "Liofilizzato orale"),
    /**
     * EN: Oral paste.<br>
     * DE: Paste zum Einnehmen.<br>
     * FR: Pâte orale.<br>
     * IT: Pasta per uso orale.<br>
     */
    ORAL_PASTE("10109000",
               "0.4.0.127.0.16.1.1.2.1",
               "Oral paste",
               "Oral paste",
               "Paste zum Einnehmen",
               "Pâte orale",
               "Pasta per uso orale"),
    /**
     * EN: Oral powder.<br>
     * DE: Pulver zum Einnehmen.<br>
     * FR: Poudre orale.<br>
     * IT: Polvere orale.<br>
     */
    ORAL_POWDER("10201000",
                "0.4.0.127.0.16.1.1.2.1",
                "Oral powder",
                "Oral powder",
                "Pulver zum Einnehmen",
                "Poudre orale",
                "Polvere orale"),
    /**
     * EN: Oral/rectal solution.<br>
     * DE: Lösung zum Einnehmen/Rektallösung.<br>
     * FR: Solution buvable/rectale.<br>
     * IT: Soluzione orale/rettale.<br>
     */
    ORAL_RECTAL_SOLUTION("50037900",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Oral/rectal solution",
                         "Oral/rectal solution",
                         "Lösung zum Einnehmen/Rektallösung",
                         "Solution buvable/rectale",
                         "Soluzione orale/rettale"),
    /**
     * EN: Oral/rectal suspension.<br>
     * DE: Suspension zum Einnehmen/Rektalsuspension.<br>
     * FR: Suspension buvable/rectale.<br>
     * IT: Sospensione orale/rettale.<br>
     */
    ORAL_RECTAL_SUSPENSION("50038000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Oral/rectal suspension",
                           "Oral/rectal suspension",
                           "Suspension zum Einnehmen/Rektalsuspension",
                           "Suspension buvable/rectale",
                           "Sospensione orale/rettale"),
    /**
     * EN: Oral solution.<br>
     * DE: Lösung zum Einnehmen.<br>
     * FR: Solution  buvable.<br>
     * IT: Soluzione orale.<br>
     */
    ORAL_SOLUTION("10105000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Oral solution",
                  "Oral solution",
                  "Lösung zum Einnehmen",
                  "Solution  buvable",
                  "Soluzione orale"),
    /**
     * EN: Oral solution/concentrate for nebuliser solution.<br>
     * DE: Lösung zum Einnehmen/ Konzentrat zur Herstellung einer Lösung für einen Vernebler.<br>
     * FR: Solution orale/solution à diluer pour inhalation par nébuliseur.<br>
     * IT: Soluzione orale/concentrato per soluzione per nebulizzatore.<br>
     */
    ORAL_SOLUTION_CONCENTRATE_FOR_NEBULISER_SOLUTION("50038500",
                                                     "0.4.0.127.0.16.1.1.2.1",
                                                     "Oral solution/concentrate for nebuliser solution",
                                                     "Oral solution/concentrate for nebuliser solution",
                                                     "Lösung zum Einnehmen/ Konzentrat zur Herstellung einer Lösung für einen Vernebler",
                                                     "Solution orale/solution à diluer pour inhalation par nébuliseur",
                                                     "Soluzione orale/concentrato per soluzione per nebulizzatore"),
    /**
     * EN: Oral suspension.<br>
     * DE: Suspension zum Einnehmen.<br>
     * FR: Suspension buvable.<br>
     * IT: Sospensione orale.<br>
     */
    ORAL_SUSPENSION("10106000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Oral suspension",
                    "Oral suspension",
                    "Suspension zum Einnehmen",
                    "Suspension buvable",
                    "Sospensione orale"),
    /**
     * EN: Orodispersible film.<br>
     * DE: Schmelzfilm.<br>
     * FR: Film orodispersible.<br>
     * IT: Film orodispersibile.<br>
     */
    ORODISPERSIBLE_FILM("10236100",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Orodispersible film",
                        "Orodispersible film",
                        "Schmelzfilm",
                        "Film orodispersible",
                        "Film orodispersibile"),
    /**
     * EN: Orodispersible tablet.<br>
     * DE: Schmelztablette.<br>
     * FR: Comprimé orodispersible.<br>
     * IT: Compressa orodispersibile.<br>
     */
    ORODISPERSIBLE_TABLET("10223000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Orodispersible tablet",
                          "Orodispersible tablet",
                          "Schmelztablette",
                          "Comprimé orodispersible",
                          "Compressa orodispersibile"),
    /**
     * EN: Oromucosal capsule.<br>
     * DE: Kapsel zur Anwendung in der Mundhöhle.<br>
     * FR: Capsule buccale.<br>
     * IT: Capsula per mucosa orale.<br>
     */
    OROMUCOSAL_CAPSULE("10317000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Oromucosal capsule",
                       "Oromucosal capsule",
                       "Kapsel zur Anwendung in der Mundhöhle",
                       "Capsule buccale",
                       "Capsula per mucosa orale"),
    /**
     * EN: Oromucosal cream.<br>
     * DE: Creme zur Anwendung in der Mundhöhle.<br>
     * FR: crème buccale.<br>
     * IT: Crema per mucosa orale.<br>
     */
    OROMUCOSAL_CREAM("10314010",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Oromucosal cream",
                     "Oromucosal cream",
                     "Creme zur Anwendung in der Mundhöhle",
                     "crème buccale",
                     "Crema per mucosa orale"),
    /**
     * EN: Oromucosal drops.<br>
     * DE: Tropfen zur Anwendung in der Mundhöhle.<br>
     * FR: Solution buccale en gouttes.<br>
     * IT: Gocce per mucosa orale.<br>
     */
    OROMUCOSAL_DROPS("10307000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Oromucosal drops",
                     "Oromucosal drops",
                     "Tropfen zur Anwendung in der Mundhöhle",
                     "Solution buccale en gouttes",
                     "Gocce per mucosa orale"),
    /**
     * EN: Oromucosal gel.<br>
     * DE: Gel zur Anwendung in der Mundhöhle.<br>
     * FR: Gel buccal.<br>
     * IT: Gel per mucosa orale.<br>
     */
    OROMUCOSAL_GEL("10313000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Oromucosal gel",
                   "Oromucosal gel",
                   "Gel zur Anwendung in der Mundhöhle",
                   "Gel buccal",
                   "Gel per mucosa orale"),
    /**
     * EN: Oromucosal/laryngopharyngeal solution.<br>
     * DE: Lösung zur Anwendung in der Mundhöhle/im Rachenraum und am Kehlkopf.<br>
     * FR: Solution buccale/laryngopharyngée.<br>
     * IT: Soluzione per mucosa orale/laringofaringea.<br>
     */
    OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION("50039500",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Oromucosal/laryngopharyngeal solution",
                                          "Oromucosal/laryngopharyngeal solution",
                                          "Lösung zur Anwendung in der Mundhöhle/im Rachenraum und am Kehlkopf",
                                          "Solution buccale/laryngopharyngée",
                                          "Soluzione per mucosa orale/laringofaringea"),
    /**
     * EN: Oromucosal/laryngopharyngeal solution/spray, solution.<br>
     * DE: Lösung/Spray zur Anwendung in der Mundhöhle/im Rachenraum oder am Kehlkopf, Lösung.<br>
     * FR: Solution/ solution pour pulvérisation buccale/ laryngopharyngée.<br>
     * IT: Soluzione per mucosa orale/laringofaringea  o spray per mucosa orale/laringofaringeo, soluzione.<br>
     */
    OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION_SPRAY_SOLUTION("50040500",
                                                         "0.4.0.127.0.16.1.1.2.1",
                                                         "Oromucosal/laryngopharyngeal solution/spray, solution",
                                                         "Oromucosal/laryngopharyngeal solution/spray, solution",
                                                         "Lösung/Spray zur Anwendung in der Mundhöhle/im Rachenraum oder am Kehlkopf, Lösung",
                                                         "Solution/ solution pour pulvérisation buccale/ laryngopharyngée",
                                                         "Soluzione per mucosa orale/laringofaringea  o spray per mucosa orale/laringofaringeo, soluzione"),
    /**
     * EN: Oromucosal ointment.<br>
     * DE: Salbe zur Anwendung in der Mundhöhle.<br>
     * FR: Pommade buccale.<br>
     * IT: Unguento per mucosa orale.<br>
     */
    OROMUCOSAL_OINTMENT("10314005",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Oromucosal ointment",
                        "Oromucosal ointment",
                        "Salbe zur Anwendung in der Mundhöhle",
                        "Pommade buccale",
                        "Unguento per mucosa orale"),
    /**
     * EN: Oromucosal paste.<br>
     * DE: Paste zur Anwendung in der Mundhöhle.<br>
     * FR: Pâte buccale.<br>
     * IT: Pasta per mucosa orale.<br>
     */
    OROMUCOSAL_PASTE("10314000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Oromucosal paste",
                     "Oromucosal paste",
                     "Paste zur Anwendung in der Mundhöhle",
                     "Pâte buccale",
                     "Pasta per mucosa orale"),
    /**
     * EN: Oromucosal patch.<br>
     * DE: Pflaster zur Anwendung in der Mundhöhle.<br>
     * FR: Patch buccal.<br>
     * IT: Cerotto per mucosa orale.<br>
     */
    OROMUCOSAL_PATCH("50039000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Oromucosal patch",
                     "Oromucosal patch",
                     "Pflaster zur Anwendung in der Mundhöhle",
                     "Patch buccal",
                     "Cerotto per mucosa orale"),
    /**
     * EN: Oromucosal pouch.<br>
     * DE: Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Dispersion à diluer pour dispersion injectable.<br>
     * IT: Larva medicinale.<br>
     */
    OROMUCOSAL_POUCH("13141000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Oromucosal pouch",
                     "Oromucosal pouch",
                     "Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen",
                     "Dispersion à diluer pour dispersion injectable",
                     "Larva medicinale"),
    /**
     * EN: Oromucosal solution.<br>
     * DE: Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Solution buccale.<br>
     * IT: Soluzione per mucosa orale.<br>
     */
    OROMUCOSAL_SOLUTION("10305000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Oromucosal solution",
                        "Oromucosal solution",
                        "Lösung zur Anwendung in der Mundhöhle",
                        "Solution buccale",
                        "Soluzione per mucosa orale"),
    /**
     * EN: Oromucosal spray, emulsion.<br>
     * DE: Spray zur Anwendung in der Mundhöhle, Emulsion.<br>
     * FR: Emulsion pour pulvérisation buccale.<br>
     * IT: Spray per mucosa orale, emulsione.<br>
     */
    OROMUCOSAL_SPRAY_EMULSION("10308100",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Oromucosal spray, emulsion",
                              "Oromucosal spray, emulsion",
                              "Spray zur Anwendung in der Mundhöhle, Emulsion",
                              "Emulsion pour pulvérisation buccale",
                              "Spray per mucosa orale, emulsione"),
    /**
     * EN: Oromucosal spray, solution.<br>
     * DE: Spray zur Anwendung in der Mundhöhle, Lösung.<br>
     * FR: Solution pour pulvérisation buccale.<br>
     * IT: Spray per mucosa orale, soluzione.<br>
     */
    OROMUCOSAL_SPRAY_SOLUTION("10308200",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Oromucosal spray, solution",
                              "Oromucosal spray, solution",
                              "Spray zur Anwendung in der Mundhöhle, Lösung",
                              "Solution pour pulvérisation buccale",
                              "Spray per mucosa orale, soluzione"),
    /**
     * EN: Oromucosal spray, suspension.<br>
     * DE: Spray zur Anwendung in der Mundhöhle, Suspension.<br>
     * FR: Suspension pour pulvérisation buccale.<br>
     * IT: Spray per mucosa orale, sospensione.<br>
     */
    OROMUCOSAL_SPRAY_SUSPENSION("10308300",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Oromucosal spray, suspension",
                                "Oromucosal spray, suspension",
                                "Spray zur Anwendung in der Mundhöhle, Suspension",
                                "Suspension pour pulvérisation buccale",
                                "Spray per mucosa orale, sospensione"),
    /**
     * EN: Oromucosal suspension.<br>
     * DE: Suspension zur Anwendung in der Mundhöhle.<br>
     * FR: Suspension buccale.<br>
     * IT: Sospensione per mucosa orale.<br>
     */
    OROMUCOSAL_SUSPENSION("10306000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Oromucosal suspension",
                          "Oromucosal suspension",
                          "Suspension zur Anwendung in der Mundhöhle",
                          "Suspension buccale",
                          "Sospensione per mucosa orale"),
    /**
     * EN: Pastille.<br>
     * DE: Pastille.<br>
     * FR: Pâte à sucer.<br>
     * IT: Pastiglia molle.<br>
     */
    PASTILLE("10323000",
             "0.4.0.127.0.16.1.1.2.1",
             "Pastille",
             "Pastille",
             "Pastille",
             "Pâte à sucer",
             "Pastiglia molle"),
    /**
     * EN: Periodontal gel.<br>
     * DE: Gel zur periodontalen Anwendung.<br>
     * FR: Gel périodontal.<br>
     * IT: Gel periodontale.<br>
     */
    PERIODONTAL_GEL("10410000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Periodontal gel",
                    "Periodontal gel",
                    "Gel zur periodontalen Anwendung",
                    "Gel périodontal",
                    "Gel periodontale"),
    /**
     * EN: Periodontal insert.<br>
     * DE: Insert zur periodontalen Anwendung.<br>
     * FR: Insert périodontal.<br>
     * IT: Inserto periodontale.<br>
     */
    PERIODONTAL_INSERT("10411000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Periodontal insert",
                       "Periodontal insert",
                       "Insert zur periodontalen Anwendung",
                       "Insert périodontal",
                       "Inserto periodontale"),
    /**
     * EN: Periodontal powder.<br>
     * DE: Pulver zur periodontalen Anwendung.<br>
     * FR: Poudre péridontale.<br>
     * IT: Polvere periodontale.<br>
     */
    PERIODONTAL_POWDER("10401000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Periodontal powder",
                       "Periodontal powder",
                       "Pulver zur periodontalen Anwendung",
                       "Poudre péridontale",
                       "Polvere periodontale"),
    /**
     * EN: Pessary.<br>
     * DE: Vaginalzäpfchen.<br>
     * FR: Ovule.<br>
     * IT: Ovulo.<br>
     */
    PESSARY("10909000",
            "0.4.0.127.0.16.1.1.2.1",
            "Pessary",
            "Pessary",
            "Vaginalzäpfchen",
            "Ovule",
            "Ovulo"),
    /**
     * EN: Pillules.<br>
     * DE: Streukügelchen.<br>
     * FR: Granules.<br>
     * IT: Granuli.<br>
     */
    PILLULES("10231000",
             "0.4.0.127.0.16.1.1.2.1",
             "Pillules",
             "Pillules",
             "Streukügelchen",
             "Granules",
             "Granuli"),
    /**
     * EN: Plaster for provocation test.<br>
     * DE: Pflaster für Provokationstest.<br>
     * FR: patch pour test épicutané.<br>
     * IT: Cerotto per test di provocazione.<br>
     */
    PLASTER_FOR_PROVOCATION_TEST("10550000",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Plaster for provocation test",
                                 "Plaster for provocation test",
                                 "Pflaster für Provokationstest",
                                 "patch pour test épicutané",
                                 "Cerotto per test di provocazione"),
    /**
     * EN: Poultice.<br>
     * DE: Umschlagpaste.<br>
     * FR: Cataplasme.<br>
     * IT: Cataplasma.<br>
     */
    POULTICE("10522000",
             "0.4.0.127.0.16.1.1.2.1",
             "Poultice",
             "Poultice",
             "Umschlagpaste",
             "Cataplasme",
             "Cataplasma"),
    /**
     * EN: Powder for bladder irrigation.<br>
     * DE: Pulver zur Herstellung einer Blasenspüllösung.<br>
     * FR: Poudre pour solution pour irrigation vésicale.<br>
     * IT: Polvere per irrigazione vescicale.<br>
     */
    POWDER_FOR_BLADDER_IRRIGATION("11503000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Powder for bladder irrigation",
                                  "Powder for bladder irrigation",
                                  "Pulver zur Herstellung einer Blasenspüllösung",
                                  "Poudre pour solution pour irrigation vésicale",
                                  "Polvere per irrigazione vescicale"),
    /**
     * EN: Powder for concentrate for dispersion for infusion.<br>
     * DE: Pulver für ein Konzentrat zur Herstellung einer Infusionsdispersion.<br>
     * FR: Poudre pour dispersion à diluer pour dispersion pour perfusion.<br>
     * IT: Polvere per concentrato per dispersione per infusione.<br>
     */
    POWDER_FOR_CONCENTRATE_FOR_DISPERSION_FOR_INFUSION("50048750",
                                                       "0.4.0.127.0.16.1.1.2.1",
                                                       "Powder for concentrate for dispersion for infusion",
                                                       "Powder for concentrate for dispersion for infusion",
                                                       "Pulver für ein Konzentrat zur Herstellung einer Infusionsdispersion",
                                                       "Poudre pour dispersion à diluer pour dispersion pour perfusion",
                                                       "Polvere per concentrato per dispersione per infusione"),
    /**
     * EN: Powder for concentrate for intravesical suspension.<br>
     * DE: Pulver für ein Konzentrat zur Herstellung einer Suspension zur intravesikalen Anwendung.<br>
     * FR: Poudre pour suspension à diluer pour suspension intravésicale.<br>
     * IT: Polvere per concentrato per sospensione endovescicale.<br>
     */
    POWDER_FOR_CONCENTRATE_FOR_INTRAVESICAL_SUSPENSION("50049100",
                                                       "0.4.0.127.0.16.1.1.2.1",
                                                       "Powder for concentrate for intravesical suspension",
                                                       "Powder for concentrate for intravesical suspension",
                                                       "Pulver für ein Konzentrat zur Herstellung einer Suspension zur intravesikalen Anwendung",
                                                       "Poudre pour suspension à diluer pour suspension intravésicale",
                                                       "Polvere per concentrato per sospensione endovescicale"),
    /**
     * EN: Powder for concentrate for solution for haemodialysis.<br>
     * DE: Pulver für ein Konzentrat zur Herstellung einer Hämodialyselösung.<br>
     * FR: Poudre pour solution à diluer pour solution pour hémodialyse.<br>
     * IT: Polvere per concentrato per soluzione per emodialisi.<br>
     */
    POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_HAEMODIALYSIS("50049200",
                                                          "0.4.0.127.0.16.1.1.2.1",
                                                          "Powder for concentrate for solution for haemodialysis",
                                                          "Powder for concentrate for solution for haemodialysis",
                                                          "Pulver für ein Konzentrat zur Herstellung einer Hämodialyselösung",
                                                          "Poudre pour solution à diluer pour solution pour hémodialyse",
                                                          "Polvere per concentrato per soluzione per emodialisi"),
    /**
     * EN: Powder for concentrate for solution for infusion.<br>
     * DE: Pulver für ein Konzentrat zur Herstellung einer Infusionslösung.<br>
     * FR: Poudre pour solution à diluer pour perfusion.<br>
     * IT: Polvere per concentrato per soluzione per infusione.<br>
     */
    POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INFUSION("50043000",
                                                     "0.4.0.127.0.16.1.1.2.1",
                                                     "Powder for concentrate for solution for infusion",
                                                     "Powder for concentrate for solution for infusion",
                                                     "Pulver für ein Konzentrat zur Herstellung einer Infusionslösung",
                                                     "Poudre pour solution à diluer pour perfusion",
                                                     "Polvere per concentrato per soluzione per infusione"),
    /**
     * EN: Powder for concentrate for solution for injection/infusion.<br>
     * DE: Pulver für ein Konzentrat zur Herstellung einer Injektions-/Infusionslösung.<br>
     * FR: Poudre pour solution à diluer pour solution injectable/pour perfusion.<br>
     * IT: Polvere per concentrato per soluzione iniettabile/per infusione.<br>
     */
    POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_INFUSION("50049250",
                                                               "0.4.0.127.0.16.1.1.2.1",
                                                               "Powder for concentrate for solution for injection/infusion",
                                                               "Powder for concentrate for solution for injection/infusion",
                                                               "Pulver für ein Konzentrat zur Herstellung einer Injektions-/Infusionslösung",
                                                               "Poudre pour solution à diluer pour solution injectable/pour perfusion",
                                                               "Polvere per concentrato per soluzione iniettabile/per infusione"),
    /**
     * EN: Powder for cutaneous solution.<br>
     * DE: Pulver zur Herstellung einer Lösung zur Anwendung auf der Haut.<br>
     * FR: Poudre pour solution cutanée.<br>
     * IT: Polvere per soluzione cutanea.<br>
     */
    POWDER_FOR_CUTANEOUS_SOLUTION("10514500",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Powder for cutaneous solution",
                                  "Powder for cutaneous solution",
                                  "Pulver zur Herstellung einer Lösung zur Anwendung auf der Haut",
                                  "Poudre pour solution cutanée",
                                  "Polvere per soluzione cutanea"),
    /**
     * EN: Powder for dental cement.<br>
     * DE: Pulver zur Herstellung eines Dentalzements.<br>
     * FR: Poudre pour ciment dentaire.<br>
     * IT: Inserto periodontale.<br>
     */
    POWDER_FOR_DENTAL_CEMENT("10413000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Powder for dental cement",
                             "Powder for dental cement",
                             "Pulver zur Herstellung eines Dentalzements",
                             "Poudre pour ciment dentaire",
                             "Inserto periodontale"),
    /**
     * EN: Powder for dental gel.<br>
     * DE: Pulver zur Herstellung eines Dentalgels.<br>
     * FR: Poudre pour gel dentaire.<br>
     * IT: Polvere per gel.<br>
     */
    POWDER_FOR_DENTAL_GEL("13022000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Powder for dental gel",
                          "Powder for dental gel",
                          "Pulver zur Herstellung eines Dentalgels",
                          "Poudre pour gel dentaire",
                          "Polvere per gel"),
    /**
     * EN: Powder for dental solution.<br>
     * DE: Pulver zur Herstellung einer Dentallösung.<br>
     * FR: Poudre pour solution dentaire.<br>
     * IT: Polvere per concentrato per soluzione iniettabile/per infusione.<br>
     */
    POWDER_FOR_DENTAL_SOLUTION("50049270",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Powder for dental solution",
                               "Powder for dental solution",
                               "Pulver zur Herstellung einer Dentallösung",
                               "Poudre pour solution dentaire",
                               "Polvere per concentrato per soluzione iniettabile/per infusione"),
    /**
     * EN: Powder for dispersion for infusion.<br>
     * DE: Pulver zur Herstellung einer Infusionsdispersion.<br>
     * FR: Poudre pour dispersion pour perfusion.<br>
     * IT: Polvere per dispersione per infusione.<br>
     */
    POWDER_FOR_DISPERSION_FOR_INFUSION("11211500",
                                       "0.4.0.127.0.16.1.1.2.1",
                                       "Powder for dispersion for infusion",
                                       "Powder for dispersion for infusion",
                                       "Pulver zur Herstellung einer Infusionsdispersion",
                                       "Poudre pour dispersion pour perfusion",
                                       "Polvere per dispersione per infusione"),
    /**
     * EN: Powder for dispersion for injection.<br>
     * DE: Pulver zur Herstellung einer Injektionsdispersion.<br>
     * FR: Poudre pour dispersion injectable.<br>
     * IT: Polvere per dispersione iniettabile.<br>
     */
    POWDER_FOR_DISPERSION_FOR_INJECTION("13023000",
                                        "0.4.0.127.0.16.1.1.2.1",
                                        "Powder for dispersion for injection",
                                        "Powder for dispersion for injection",
                                        "Pulver zur Herstellung einer Injektionsdispersion",
                                        "Poudre pour dispersion injectable",
                                        "Polvere per dispersione iniettabile"),
    /**
     * EN: Powder for emulsion for injection.<br>
     * DE: Pulver zur Herstellung einer Emulsion zur Injektion.<br>
     * FR: Poudre pour émulsion injectable.<br>
     * IT: Polvere per emulsione iniettabile.<br>
     */
    POWDER_FOR_EMULSION_FOR_INJECTION("13040000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Powder for emulsion for injection",
                                      "Powder for emulsion for injection",
                                      "Pulver zur Herstellung einer Emulsion zur Injektion",
                                      "Poudre pour émulsion injectable",
                                      "Polvere per emulsione iniettabile"),
    /**
     * EN: Powder for endocervical gel.<br>
     * DE: Pulver zur Herstellung eines Gels zur endozervikalen Anwendung.<br>
     * FR: Poudre pour gel endocervical.<br>
     * IT: Polvere per gel endocervicale.<br>
     */
    POWDER_FOR_ENDOCERVICAL_GEL("13024000",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Powder for endocervical gel",
                                "Powder for endocervical gel",
                                "Pulver zur Herstellung eines Gels zur endozervikalen Anwendung",
                                "Poudre pour gel endocervical",
                                "Polvere per gel endocervicale"),
    /**
     * EN: Powder for endosinusial solution.<br>
     * DE: Pulver zur Herstellung einer Lösung zur Anwendung in den Nasennebenhöhlen.<br>
     * FR: Poudre pour solution endosinusale.<br>
     * IT: Polvere per soluzione endosinusale.<br>
     */
    POWDER_FOR_ENDOSINUSIAL_SOLUTION("13025000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Powder for endosinusial solution",
                                     "Powder for endosinusial solution",
                                     "Pulver zur Herstellung einer Lösung zur Anwendung in den Nasennebenhöhlen",
                                     "Poudre pour solution endosinusale",
                                     "Polvere per soluzione endosinusale"),
    /**
     * EN: Powder for epilesional solution.<br>
     * DE: Pulver zur Herstellung einer Lösung zum Auftragen auf die Wunde.<br>
     * FR: Poudre pour solution épilésionnelle.<br>
     * IT: Polvere per soluzione epilesionale.<br>
     */
    POWDER_FOR_EPILESIONAL_SOLUTION("50049300",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Powder for epilesional solution",
                                    "Powder for epilesional solution",
                                    "Pulver zur Herstellung einer Lösung zum Auftragen auf die Wunde",
                                    "Poudre pour solution épilésionnelle",
                                    "Polvere per soluzione epilesionale"),
    /**
     * EN: Powder for gel.<br>
     * DE: Pulver zur Herstellung eines Gels.<br>
     * FR: Poudre pour gel.<br>
     * IT: Polvere per gel.<br>
     */
    POWDER_FOR_GEL("13021000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Powder for gel",
                   "Powder for gel",
                   "Pulver zur Herstellung eines Gels",
                   "Poudre pour gel",
                   "Polvere per gel"),
    /**
     * EN: Powder for gingival gel.<br>
     * DE: Pulver zur Herstellung eines Gels zur Anwendung am Zahnfleisch.<br>
     * FR: Poudre pour gel gingival.<br>
     * IT: Polvere per gel gengivale.<br>
     */
    POWDER_FOR_GINGIVAL_GEL("13026000",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Powder for gingival gel",
                            "Powder for gingival gel",
                            "Pulver zur Herstellung eines Gels zur Anwendung am Zahnfleisch",
                            "Poudre pour gel gingival",
                            "Polvere per gel gengivale"),
    /**
     * EN: Powder for implantation matrix.<br>
     * DE: Pulver für Matrix zur Implantation.<br>
     * FR: Poudre pour matrice pour implantation.<br>
     * IT: Polvere per gel gengivale.<br>
     */
    POWDER_FOR_IMPLANTATION_MATRIX("13027000",
                                   "0.4.0.127.0.16.1.1.2.1",
                                   "Powder for implantation matrix",
                                   "Powder for implantation matrix",
                                   "Pulver für Matrix zur Implantation",
                                   "Poudre pour matrice pour implantation",
                                   "Polvere per gel gengivale"),
    /**
     * EN: Powder for implantation paste.<br>
     * DE: Pulver zur Herstellung einer Paste für ein Implantat.<br>
     * FR: Poudre pour pâte pour implantation.<br>
     * IT: Polvere per gel gengivale.<br>
     */
    POWDER_FOR_IMPLANTATION_PASTE("13028000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Powder for implantation paste",
                                  "Powder for implantation paste",
                                  "Pulver zur Herstellung einer Paste für ein Implantat",
                                  "Poudre pour pâte pour implantation",
                                  "Polvere per gel gengivale"),
    /**
     * EN: Powder for implantation suspension.<br>
     * DE: Pulver zur Herstellung einer Suspension zur Implantation.<br>
     * FR: Poudre pour suspension pour implantation.<br>
     * IT: Polvere per soluzione epilesionale.<br>
     */
    POWDER_FOR_IMPLANTATION_SUSPENSION("50049500",
                                       "0.4.0.127.0.16.1.1.2.1",
                                       "Powder for implantation suspension",
                                       "Powder for implantation suspension",
                                       "Pulver zur Herstellung einer Suspension zur Implantation",
                                       "Poudre pour suspension pour implantation",
                                       "Polvere per soluzione epilesionale"),
    /**
     * EN: Powder for intraocular instillation solution.<br>
     * DE: Pulver zur Herstellung einer Instillationslösung zur intraokularen Anwendung.<br>
     * FR: Poudre pour solution pour instillation intraoculaire.<br>
     * IT: Polvere per soluzione per instillazione intraoculare.<br>
     */
    POWDER_FOR_INTRAOCULAR_INSTILLATION_SOLUTION("13029000",
                                                 "0.4.0.127.0.16.1.1.2.1",
                                                 "Powder for intraocular instillation solution",
                                                 "Powder for intraocular instillation solution",
                                                 "Pulver zur Herstellung einer Instillationslösung zur intraokularen Anwendung",
                                                 "Poudre pour solution pour instillation intraoculaire",
                                                 "Polvere per soluzione per instillazione intraoculare"),
    /**
     * EN: Powder for intravesical solution.<br>
     * DE: Pulver zur Herstellung einer Lösung zur intravesikalen Anwendung.<br>
     * FR: Poudre pour solution intravésicale.<br>
     * IT: Polvere per soluzione endovescicale.<br>
     */
    POWDER_FOR_INTRAVESICAL_SOLUTION("50050000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Powder for intravesical solution",
                                     "Powder for intravesical solution",
                                     "Pulver zur Herstellung einer Lösung zur intravesikalen Anwendung",
                                     "Poudre pour solution intravésicale",
                                     "Polvere per soluzione endovescicale"),
    /**
     * EN: Powder for intravesical solution/solution for injection.<br>
     * DE: Pulver zur Herstellung einer Lösung zur intravesikalen Anwendung / Injektionslösung.<br>
     * FR: Poudre pour solution intravésicale/injectable.<br>
     * IT: Polvere per soluzione endovescicale/soluzione iniettabile.<br>
     */
    POWDER_FOR_INTRAVESICAL_SOLUTION_SOLUTION_FOR_INJECTION("50050500",
                                                            "0.4.0.127.0.16.1.1.2.1",
                                                            "Powder for intravesical solution/solution for injection",
                                                            "Powder for intravesical solution/solution for injection",
                                                            "Pulver zur Herstellung einer Lösung zur intravesikalen Anwendung / Injektionslösung",
                                                            "Poudre pour solution intravésicale/injectable",
                                                            "Polvere per soluzione endovescicale/soluzione iniettabile"),
    /**
     * EN: Powder for intravesical suspension.<br>
     * DE: Pulver zur Herstellung einer Suspensionen zur intravesikalen Anwendung.<br>
     * FR: Poudre pour suspension intravésicale.<br>
     * IT: Polvere per sospensione endovescicale.<br>
     */
    POWDER_FOR_INTRAVESICAL_SUSPENSION("50051000",
                                       "0.4.0.127.0.16.1.1.2.1",
                                       "Powder for intravesical suspension",
                                       "Powder for intravesical suspension",
                                       "Pulver zur Herstellung einer Suspensionen zur intravesikalen Anwendung",
                                       "Poudre pour suspension intravésicale",
                                       "Polvere per sospensione endovescicale"),
    /**
     * EN: Powder for nebuliser solution.<br>
     * DE: Pulver zur Herstellung einer Lösung für einen Vernebler.<br>
     * FR: Poudre pour solution pour inhalation par nébuliseur.<br>
     * IT: Polvere per soluzione per nebulizzatore.<br>
     */
    POWDER_FOR_NEBULISER_SOLUTION("11104000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Powder for nebuliser solution",
                                  "Powder for nebuliser solution",
                                  "Pulver zur Herstellung einer Lösung für einen Vernebler",
                                  "Poudre pour solution pour inhalation par nébuliseur",
                                  "Polvere per soluzione per nebulizzatore"),
    /**
     * EN: Powder for nebuliser suspension.<br>
     * DE: Pulver zur Herstellung einer Suspension für einen Vernebler.<br>
     * FR: Poudre pour suspension pour inhalation par nébuliseur.<br>
     * IT: Polvere per sospensione per nebulizzatore.<br>
     */
    POWDER_FOR_NEBULISER_SUSPENSION("11103000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Powder for nebuliser suspension",
                                    "Powder for nebuliser suspension",
                                    "Pulver zur Herstellung einer Suspension für einen Vernebler",
                                    "Poudre pour suspension pour inhalation par nébuliseur",
                                    "Polvere per sospensione per nebulizzatore"),
    /**
     * EN: Powder for oral/rectal suspension.<br>
     * DE: Pulver zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension.<br>
     * FR: Poudre pour suspension oral/rectal.<br>
     * IT: Polvere per sospensione orale/rettale.<br>
     */
    POWDER_FOR_ORAL_RECTAL_SUSPENSION("50052000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Powder for oral/rectal suspension",
                                      "Powder for oral/rectal suspension",
                                      "Pulver zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension",
                                      "Poudre pour suspension oral/rectal",
                                      "Polvere per sospensione orale/rettale"),
    /**
     * EN: Powder for oral solution.<br>
     * DE: Pulver zur Herstellung einer Lösung zum Einnehmen.<br>
     * FR: Poudre pour solution buvable.<br>
     * IT: Polvere per soluzione orale.<br>
     */
    POWDER_FOR_ORAL_SOLUTION("10110000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Powder for oral solution",
                             "Powder for oral solution",
                             "Pulver zur Herstellung einer Lösung zum Einnehmen",
                             "Poudre pour solution buvable",
                             "Polvere per soluzione orale"),
    /**
     * EN: Powder for oral suspension.<br>
     * DE: Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Poudre pour suspension buvable.<br>
     * IT: Polvere per sospensione orale.<br>
     */
    POWDER_FOR_ORAL_SUSPENSION("10111000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Powder for oral suspension",
                               "Powder for oral suspension",
                               "Pulver zur Herstellung einer Suspension zum Einnehmen",
                               "Poudre pour suspension buvable",
                               "Polvere per sospensione orale"),
    /**
     * EN: Powder for prolonged-release suspension for injection.<br>
     * DE: Pulver zur Herstellung einer Depot-Injektionssuspension.<br>
     * FR: Poudre pour suspension injectable à libération prolongée.<br>
     * IT: Polvere per sospensione iniettabile a rilascio prolungato.<br>
     */
    POWDER_FOR_PROLONGED_RELEASE_SUSPENSION_FOR_INJECTION("11208400",
                                                          "0.4.0.127.0.16.1.1.2.1",
                                                          "Powder for prolonged-release suspension for injection",
                                                          "Powder for prolonged-release suspension for injection",
                                                          "Pulver zur Herstellung einer Depot-Injektionssuspension",
                                                          "Poudre pour suspension injectable à libération prolongée",
                                                          "Polvere per sospensione iniettabile a rilascio prolungato"),
    /**
     * EN: Powder for rectal solution.<br>
     * DE: Pulver zur Herstellung einer Rektallösung.<br>
     * FR: Poudre pour solution rectale.<br>
     * IT: Polvere per soluzione rettale.<br>
     */
    POWDER_FOR_RECTAL_SOLUTION("11009000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Powder for rectal solution",
                               "Powder for rectal solution",
                               "Pulver zur Herstellung einer Rektallösung",
                               "Poudre pour solution rectale",
                               "Polvere per soluzione rettale"),
    /**
     * EN: Powder for rectal suspension.<br>
     * DE: Pulver zur Herstellung einer Rektalsuspension.<br>
     * FR: Poudre pour suspension rectale.<br>
     * IT: Polvere per sospensione rettale.<br>
     */
    POWDER_FOR_RECTAL_SUSPENSION("11010000",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Powder for rectal suspension",
                                 "Powder for rectal suspension",
                                 "Pulver zur Herstellung einer Rektalsuspension",
                                 "Poudre pour suspension rectale",
                                 "Polvere per sospensione rettale"),
    /**
     * EN: Powder for sealant.<br>
     * DE: Pulver für einen Gewebekleber.<br>
     * FR: Poudre pour colle.<br>
     * IT: Polvere per adesivo tissutale.<br>
     */
    POWDER_FOR_SEALANT("13031000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Powder for sealant",
                       "Powder for sealant",
                       "Pulver für einen Gewebekleber",
                       "Poudre pour colle",
                       "Polvere per adesivo tissutale"),
    /**
     * EN: Powder for solution for infusion.<br>
     * DE: Pulver zur Herstellung einer Infusionslösung.<br>
     * FR: Poudre pour solution pour perfusion.<br>
     * IT: Polvere per soluzione per infusione.<br>
     */
    POWDER_FOR_SOLUTION_FOR_INFUSION("11212000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Powder for solution for infusion",
                                     "Powder for solution for infusion",
                                     "Pulver zur Herstellung einer Infusionslösung",
                                     "Poudre pour solution pour perfusion",
                                     "Polvere per soluzione per infusione"),
    /**
     * EN: Powder for solution for injection.<br>
     * DE: Pulver zur Herstellung einer Injektionslösung.<br>
     * FR: Poudre pour solution injectable.<br>
     * IT: Polvere per soluzione iniettabile.<br>
     */
    POWDER_FOR_SOLUTION_FOR_INJECTION("11205000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Powder for solution for injection",
                                      "Powder for solution for injection",
                                      "Pulver zur Herstellung einer Injektionslösung",
                                      "Poudre pour solution injectable",
                                      "Polvere per soluzione iniettabile"),
    /**
     * EN: Powder for solution for injection/infusion.<br>
     * DE: Pulver zur Herstellung einer Injektions-/Infusionslösung.<br>
     * FR: Poudre pour solution injectable/pour perfusion.<br>
     * IT: Polvere per soluzione iniettabile/per infusione.<br>
     */
    POWDER_FOR_SOLUTION_FOR_INJECTION_INFUSION("50053500",
                                               "0.4.0.127.0.16.1.1.2.1",
                                               "Powder for solution for injection/infusion",
                                               "Powder for solution for injection/infusion",
                                               "Pulver zur Herstellung einer Injektions-/Infusionslösung",
                                               "Poudre pour solution injectable/pour perfusion",
                                               "Polvere per soluzione iniettabile/per infusione"),
    /**
     * EN: Powder for solution for injection/skin-prick test.<br>
     * DE: Pulver zur Herstellung einer Injektionslösung/Pricktestlösung.<br>
     * FR: Poudre pour solution injectable/ pour prick-test.<br>
     * IT: Polvere per soluzione iniettabile/per skin-prick test.<br>
     */
    POWDER_FOR_SOLUTION_FOR_INJECTION_SKIN_PRICK_TEST("13052000",
                                                      "0.4.0.127.0.16.1.1.2.1",
                                                      "Powder for solution for injection/skin-prick test",
                                                      "Powder for solution for injection/skin-prick test",
                                                      "Pulver zur Herstellung einer Injektionslösung/Pricktestlösung",
                                                      "Poudre pour solution injectable/ pour prick-test",
                                                      "Polvere per soluzione iniettabile/per skin-prick test"),
    /**
     * EN: Powder for solution for intraocular irrigation.<br>
     * DE: Pulver zur Herstellung einer Lösung zur intraokularen Anwendung.<br>
     * FR: Poudre pour solution pour irrigation intraoculaire.<br>
     * IT: Polvere per soluzione per irrigazione intraoculare.<br>
     */
    POWDER_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION("50073000",
                                                   "0.4.0.127.0.16.1.1.2.1",
                                                   "Powder for solution for intraocular irrigation",
                                                   "Powder for solution for intraocular irrigation",
                                                   "Pulver zur Herstellung einer Lösung zur intraokularen Anwendung",
                                                   "Poudre pour solution pour irrigation intraoculaire",
                                                   "Polvere per soluzione per irrigazione intraoculare"),
    /**
     * EN: Powder for solution for iontophoresis.<br>
     * DE: Pulver zur Herstellung einer Lösung zur Iontophorese.<br>
     * FR: Poudre pour solution pour iontophérèse.<br>
     * IT: Polvere per soluzione per ionoforesi.<br>
     */
    POWDER_FOR_SOLUTION_FOR_IONTOPHORESIS("10518500",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Powder for solution for iontophoresis",
                                          "Powder for solution for iontophoresis",
                                          "Pulver zur Herstellung einer Lösung zur Iontophorese",
                                          "Poudre pour solution pour iontophérèse",
                                          "Polvere per soluzione per ionoforesi"),
    /**
     * EN: Powder for solution for skin-prick test.<br>
     * DE: Pulver zur Herstellung einer Pricktestlösung.<br>
     * FR: Poudre pour solution pour prick-test.<br>
     * IT: Polvere per soluzione per skin-prick test.<br>
     */
    POWDER_FOR_SOLUTION_FOR_SKIN_PRICK_TEST("13032000",
                                            "0.4.0.127.0.16.1.1.2.1",
                                            "Powder for solution for skin-prick test",
                                            "Powder for solution for skin-prick test",
                                            "Pulver zur Herstellung einer Pricktestlösung",
                                            "Poudre pour solution pour prick-test",
                                            "Polvere per soluzione per skin-prick test"),
    /**
     * EN: Powder for suspension for injection.<br>
     * DE: Pulver zur Herstellung einer Injektionssuspension.<br>
     * FR: Poudre pour suspension injectable.<br>
     * IT: Polvere per sospensione iniettabile.<br>
     */
    POWDER_FOR_SUSPENSION_FOR_INJECTION("11206000",
                                        "0.4.0.127.0.16.1.1.2.1",
                                        "Powder for suspension for injection",
                                        "Powder for suspension for injection",
                                        "Pulver zur Herstellung einer Injektionssuspension",
                                        "Poudre pour suspension injectable",
                                        "Polvere per sospensione iniettabile"),
    /**
     * EN: Powder for syrup.<br>
     * DE: Pulver zur Herstellung eines Sirups.<br>
     * FR: Poudre pour sirop.<br>
     * IT: Polvere per sciroppo.<br>
     */
    POWDER_FOR_SYRUP("10118000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Powder for syrup",
                     "Powder for syrup",
                     "Pulver zur Herstellung eines Sirups",
                     "Poudre pour sirop",
                     "Polvere per sciroppo"),
    /**
     * EN: Powder for vaginal solution.<br>
     * DE: Pulver zur Herstellung einer Vaginallösung.<br>
     * FR: Poudre pour solution vaginale.<br>
     * IT: Polvere per soluzione vaginale.<br>
     */
    POWDER_FOR_VAGINAL_SOLUTION("13111000",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Powder for vaginal solution",
                                "Powder for vaginal solution",
                                "Pulver zur Herstellung einer Vaginallösung",
                                "Poudre pour solution vaginale",
                                "Polvere per soluzione vaginale"),
    /**
     * EN: Pressurised inhalation, emulsion.<br>
     * DE: Druckgasinhalation, Emulsion.<br>
     * FR: Emulsion pour inhalation en flacon pressurisé.<br>
     * IT: Emulsione pressurizzata per inalazione.<br>
     */
    PRESSURISED_INHALATION_EMULSION("11108000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Pressurised inhalation, emulsion",
                                    "Pressurised inhalation, emulsion",
                                    "Druckgasinhalation, Emulsion",
                                    "Emulsion pour inhalation en flacon pressurisé",
                                    "Emulsione pressurizzata per inalazione"),
    /**
     * EN: Pressurised inhalation, solution.<br>
     * DE: Druckgasinhalation, Lösung.<br>
     * FR: Solution pour inhalation en flacon pressurisé.<br>
     * IT: Soluzione pressurizzata per inalazione.<br>
     */
    PRESSURISED_INHALATION_SOLUTION("11106000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Pressurised inhalation, solution",
                                    "Pressurised inhalation, solution",
                                    "Druckgasinhalation, Lösung",
                                    "Solution pour inhalation en flacon pressurisé",
                                    "Soluzione pressurizzata per inalazione"),
    /**
     * EN: Pressurised inhalation, suspension.<br>
     * DE: Druckgasinhalation, Suspension.<br>
     * FR: Suspension pour inhalation en flacon pressurisé.<br>
     * IT: Sospensione pressurizzata per inalazione.<br>
     */
    PRESSURISED_INHALATION_SUSPENSION("11107000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Pressurised inhalation, suspension",
                                      "Pressurised inhalation, suspension",
                                      "Druckgasinhalation, Suspension",
                                      "Suspension pour inhalation en flacon pressurisé",
                                      "Sospensione pressurizzata per inalazione"),
    /**
     * EN: Prolonged-release capsule, hard.<br>
     * DE: Hartkapsel, retardiert.<br>
     * FR: Gélule à libération prolongée.<br>
     * IT: Capsula rigida a rilascio prolungato.<br>
     */
    PROLONGED_RELEASE_CAPSULE_HARD("10215000",
                                   "0.4.0.127.0.16.1.1.2.1",
                                   "Prolonged-release capsule, hard",
                                   "Prolonged-release capsule, hard",
                                   "Hartkapsel, retardiert",
                                   "Gélule à libération prolongée",
                                   "Capsula rigida a rilascio prolungato"),
    /**
     * EN: Prolonged-release capsule, soft.<br>
     * DE: Weichkapsel, retardiert.<br>
     * FR: Capsule molle à libération prolongée.<br>
     * IT: Capsula molle a rilascio prolungato.<br>
     */
    PROLONGED_RELEASE_CAPSULE_SOFT("10216000",
                                   "0.4.0.127.0.16.1.1.2.1",
                                   "Prolonged-release capsule, soft",
                                   "Prolonged-release capsule, soft",
                                   "Weichkapsel, retardiert",
                                   "Capsule molle à libération prolongée",
                                   "Capsula molle a rilascio prolungato"),
    /**
     * EN: Prolonged-release dispersion for injection.<br>
     * DE: Depot-Injektionsdispersion.<br>
     * FR: Larves médicinales.<br>
     * IT: Larva medicinale.<br>
     */
    PROLONGED_RELEASE_DISPERSION_FOR_INJECTION("13126000",
                                               "0.4.0.127.0.16.1.1.2.1",
                                               "Prolonged-release dispersion for injection",
                                               "Prolonged-release dispersion for injection",
                                               "Depot-Injektionsdispersion",
                                               "Larves médicinales",
                                               "Larva medicinale"),
    /**
     * EN: Prolonged-release granules.<br>
     * DE: Retardgranulat.<br>
     * FR: Granulés à libération prolongée.<br>
     * IT: Granulato a rilascio prolungato.<br>
     */
    PROLONGED_RELEASE_GRANULES("10207000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Prolonged-release granules",
                               "Prolonged-release granules",
                               "Retardgranulat",
                               "Granulés à libération prolongée",
                               "Granulato a rilascio prolungato"),
    /**
     * EN: Prolonged-release granules for oral suspension.<br>
     * DE: Retardgranulat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Granulés à libération prolongée pour suspension buvable.<br>
     * IT: Granulato a rilascio prolungato per sospensione orale.<br>
     */
    PROLONGED_RELEASE_GRANULES_FOR_ORAL_SUSPENSION("50056000",
                                                   "0.4.0.127.0.16.1.1.2.1",
                                                   "Prolonged-release granules for oral suspension",
                                                   "Prolonged-release granules for oral suspension",
                                                   "Retardgranulat zur Herstellung einer Suspension zum Einnehmen",
                                                   "Granulés à libération prolongée pour suspension buvable",
                                                   "Granulato a rilascio prolungato per sospensione orale"),
    /**
     * EN: Prolonged-release oral suspension.<br>
     * DE: Retardsuspension zum Einnehmen.<br>
     * FR: Solution à libération prolongée intralésionnelle.<br>
     * IT: Larva medicinale.<br>
     */
    PROLONGED_RELEASE_ORAL_SUSPENSION("13134000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Prolonged-release oral suspension",
                                      "Prolonged-release oral suspension",
                                      "Retardsuspension zum Einnehmen",
                                      "Solution à libération prolongée intralésionnelle",
                                      "Larva medicinale"),
    /**
     * EN: Prolonged-release solution for injection.<br>
     * DE: Depot-Injektionslösung.<br>
     * FR: Solution injectable à libération prolongée.<br>
     * IT: Soluzione iniettabile a rilascio prolungato.<br>
     */
    PROLONGED_RELEASE_SOLUTION_FOR_INJECTION("13076000",
                                             "0.4.0.127.0.16.1.1.2.1",
                                             "Prolonged-release solution for injection",
                                             "Prolonged-release solution for injection",
                                             "Depot-Injektionslösung",
                                             "Solution injectable à libération prolongée",
                                             "Soluzione iniettabile a rilascio prolungato"),
    /**
     * EN: Prolonged-release suspension for injection.<br>
     * DE: Depot-Injektionssuspension.<br>
     * FR: Suspension injectable à libération prolongée.<br>
     * IT: Sospensione iniettabile a rilascio prolungato.<br>
     */
    PROLONGED_RELEASE_SUSPENSION_FOR_INJECTION("11208500",
                                               "0.4.0.127.0.16.1.1.2.1",
                                               "Prolonged-release suspension for injection",
                                               "Prolonged-release suspension for injection",
                                               "Depot-Injektionssuspension",
                                               "Suspension injectable à libération prolongée",
                                               "Sospensione iniettabile a rilascio prolungato"),
    /**
     * EN: Prolonged-release tablet.<br>
     * DE: Retardtablette.<br>
     * FR: Comprimé à libération prolongée.<br>
     * IT: Compressa a rilascio prolungato.<br>
     */
    PROLONGED_RELEASE_TABLET("10226000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Prolonged-release tablet",
                             "Prolonged-release tablet",
                             "Retardtablette",
                             "Comprimé à libération prolongée",
                             "Compressa a rilascio prolungato"),
    /**
     * EN: Prolonged-release wound solution.<br>
     * DE: Lyophilisat zur sublingualen Anwendung.<br>
     * FR: Solution à libération prolongée intralésionnelle.<br>
     * IT: Larva medicinale.<br>
     */
    PROLONGED_RELEASE_WOUND_SOLUTION("13128000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Prolonged-release wound solution",
                                     "Prolonged-release wound solution",
                                     "Lyophilisat zur sublingualen Anwendung",
                                     "Solution à libération prolongée intralésionnelle",
                                     "Larva medicinale"),
    /**
     * EN: Radionuclide generator.<br>
     * DE: Radionuklidgenerator.<br>
     * FR: Générateur radiopharmaceutique.<br>
     * IT: Generatore di radionuclidi.<br>
     */
    RADIONUCLIDE_GENERATOR("12106000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Radionuclide generator",
                           "Radionuclide generator",
                           "Radionuklidgenerator",
                           "Générateur radiopharmaceutique",
                           "Generatore di radionuclidi"),
    /**
     * EN: Radiopharmaceutical precursor.<br>
     * DE: Markerzubereitung.<br>
     * FR: Précurseur radiopharmaceutique.<br>
     * IT: Precursore radiofarmaceutico.<br>
     */
    RADIOPHARMACEUTICAL_PRECURSOR("12105000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Radiopharmaceutical precursor",
                                  "Radiopharmaceutical precursor",
                                  "Markerzubereitung",
                                  "Précurseur radiopharmaceutique",
                                  "Precursore radiofarmaceutico"),
    /**
     * EN: Radiopharmaceutical precursor, solution.<br>
     * DE: Markerzubereitung, Lösung.<br>
     * FR: Solution de précurseur radiopharmaceutique.<br>
     * IT: Precursore di radionuclidi, soluzione.<br>
     */
    RADIOPHARMACEUTICAL_PRECURSOR_SOLUTION("50056500",
                                           "0.4.0.127.0.16.1.1.2.1",
                                           "Radiopharmaceutical precursor, solution",
                                           "Radiopharmaceutical precursor, solution",
                                           "Markerzubereitung, Lösung",
                                           "Solution de précurseur radiopharmaceutique",
                                           "Precursore di radionuclidi, soluzione"),
    /**
     * EN: Rectal capsule.<br>
     * DE: Rektalkapsel.<br>
     * FR: Capsule  rectale.<br>
     * IT: Capsula rettale.<br>
     */
    RECTAL_CAPSULE("11014000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Rectal capsule",
                   "Rectal capsule",
                   "Rektalkapsel",
                   "Capsule  rectale",
                   "Capsula rettale"),
    /**
     * EN: Rectal cream.<br>
     * DE: Rektalcreme.<br>
     * FR: Crème rectale.<br>
     * IT: Crema rettale.<br>
     */
    RECTAL_CREAM("11001000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Rectal cream",
                 "Rectal cream",
                 "Rektalcreme",
                 "Crème rectale",
                 "Crema rettale"),
    /**
     * EN: Rectal emulsion.<br>
     * DE: Rektalemulsion.<br>
     * FR: Emulsion rectale.<br>
     * IT: Emulsione rettale.<br>
     */
    RECTAL_EMULSION("11007000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Rectal emulsion",
                    "Rectal emulsion",
                    "Rektalemulsion",
                    "Emulsion rectale",
                    "Emulsione rettale"),
    /**
     * EN: Rectal foam.<br>
     * DE: Rektalschaum.<br>
     * FR: Mousse rectale.<br>
     * IT: Schiuma rettale.<br>
     */
    RECTAL_FOAM("11004000",
                "0.4.0.127.0.16.1.1.2.1",
                "Rectal foam",
                "Rectal foam",
                "Rektalschaum",
                "Mousse rectale",
                "Schiuma rettale"),
    /**
     * EN: Rectal gel.<br>
     * DE: Rektalgel.<br>
     * FR: Gel rectal.<br>
     * IT: Gel rettale.<br>
     */
    RECTAL_GEL("11002000",
               "0.4.0.127.0.16.1.1.2.1",
               "Rectal gel",
               "Rectal gel",
               "Rektalgel",
               "Gel rectal",
               "Gel rettale"),
    /**
     * EN: Rectal ointment.<br>
     * DE: Rektalsalbe.<br>
     * FR: Pommade rectale.<br>
     * IT: Unguento rettale.<br>
     */
    RECTAL_OINTMENT("11003000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Rectal ointment",
                    "Rectal ointment",
                    "Rektalsalbe",
                    "Pommade rectale",
                    "Unguento rettale"),
    /**
     * EN: Rectal solution.<br>
     * DE: Rektallösung.<br>
     * FR: Solution rectale.<br>
     * IT: Soluzione rettale.<br>
     */
    RECTAL_SOLUTION("11005000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Rectal solution",
                    "Rectal solution",
                    "Rektallösung",
                    "Solution rectale",
                    "Soluzione rettale"),
    /**
     * EN: Rectal suspension.<br>
     * DE: Rektalsuspension.<br>
     * FR: Suspension rectale.<br>
     * IT: Sospensione rettale.<br>
     */
    RECTAL_SUSPENSION("11006000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Rectal suspension",
                      "Rectal suspension",
                      "Rektalsuspension",
                      "Suspension rectale",
                      "Sospensione rettale"),
    /**
     * EN: Rectal tampon.<br>
     * DE: Rektaltampon.<br>
     * FR: Tampon rectal.<br>
     * IT: Tampone rettale.<br>
     */
    RECTAL_TAMPON("11015000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Rectal tampon",
                  "Rectal tampon",
                  "Rektaltampon",
                  "Tampon rectal",
                  "Tampone rettale"),
    /**
     * EN: Sealant.<br>
     * DE: Gewebekleber.<br>
     * FR: Colle.<br>
     * IT: Adesivo tissutale.<br>
     */
    SEALANT("12115000",
            "0.4.0.127.0.16.1.1.2.1",
            "Sealant",
            "Sealant",
            "Gewebekleber",
            "Colle",
            "Adesivo tissutale"),
    /**
     * EN: Sealant matrix.<br>
     * DE: Versiegelungsmatrix.<br>
     * FR: Matrice pour colle.<br>
     * IT: Matrice per adesivo tissutale.<br>
     */
    SEALANT_MATRIX("12115100",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Sealant matrix",
                   "Sealant matrix",
                   "Versiegelungsmatrix",
                   "Matrice pour colle",
                   "Matrice per adesivo tissutale"),
    /**
     * EN: Sealant powder.<br>
     * DE: Gewebekleber.<br>
     * FR: Poudre pour colle.<br>
     * IT: Adesivo tissutale, polvere.<br>
     */
    SEALANT_POWDER("12115200",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Sealant powder",
                   "Sealant powder",
                   "Gewebekleber",
                   "Poudre pour colle",
                   "Adesivo tissutale, polvere"),
    /**
     * EN: Shampoo.<br>
     * DE: Shampoo.<br>
     * FR: Shampoing.<br>
     * IT: Shampoo.<br>
     */
    SHAMPOO("10508000",
            "0.4.0.127.0.16.1.1.2.1",
            "Shampoo",
            "Shampoo",
            "Shampoo",
            "Shampoing",
            "Shampoo"),
    /**
     * EN: Soluble tablet.<br>
     * DE: Tablette zur Herstellung einer Lösung zum Einnehmen.<br>
     * FR: Comprimé pour solution buvable.<br>
     * IT: Compressa solubile.<br>
     */
    SOLUBLE_TABLET("10120000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Soluble tablet",
                   "Soluble tablet",
                   "Tablette zur Herstellung einer Lösung zum Einnehmen",
                   "Comprimé pour solution buvable",
                   "Compressa solubile"),
    /**
     * EN: Solution for blood fraction modification.<br>
     * DE: Lösung zur Modifikation einer Blutfraktion.<br>
     * FR: Solution pour la préparation ex vivo de fractions sanguines.<br>
     * IT: Soluzione per la modifica di frazione ematica.<br>
     */
    SOLUTION_FOR_BLOOD_FRACTION_MODIFICATION("12103000",
                                             "0.4.0.127.0.16.1.1.2.1",
                                             "Solution for blood fraction modification",
                                             "Solution for blood fraction modification",
                                             "Lösung zur Modifikation einer Blutfraktion",
                                             "Solution pour la préparation ex vivo de fractions sanguines",
                                             "Soluzione per la modifica di frazione ematica"),
    /**
     * EN: Solution for cardioplegia.<br>
     * DE: Kardioplege Lösung.<br>
     * FR: Solution de cardioplégie.<br>
     * IT: Soluzione per cardioplegia.<br>
     */
    SOLUTION_FOR_CARDIOPLEGIA("11209500",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Solution for cardioplegia",
                              "Solution for cardioplegia",
                              "Kardioplege Lösung",
                              "Solution de cardioplégie",
                              "Soluzione per cardioplegia"),
    /**
     * EN: Solution for cardioplegia/organ preservation.<br>
     * DE: Kardioplege Lösung/Organkonservierungslösung.<br>
     * FR: Solution pour cardioplégie/préservation d'organe.<br>
     * IT: Soluzione per cardioplegia/conservazione di organi.<br>
     */
    SOLUTION_FOR_CARDIOPLEGIA_ORGAN_PRESERVATION("13107000",
                                                 "0.4.0.127.0.16.1.1.2.1",
                                                 "Solution for cardioplegia/organ preservation",
                                                 "Solution for cardioplegia/organ preservation",
                                                 "Kardioplege Lösung/Organkonservierungslösung",
                                                 "Solution pour cardioplégie/préservation d'organe",
                                                 "Soluzione per cardioplegia/conservazione di organi"),
    /**
     * EN: Solution for dental cement.<br>
     * DE: Lösung zur Herstellung eines Dentalzements.<br>
     * FR: Solution pour ciment dentaire.<br>
     * IT: Inserto periodontale.<br>
     */
    SOLUTION_FOR_DENTAL_CEMENT("10414000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Solution for dental cement",
                               "Solution for dental cement",
                               "Lösung zur Herstellung eines Dentalzements",
                               "Solution pour ciment dentaire",
                               "Inserto periodontale"),
    /**
     * EN: Solution for haemodiafiltration.<br>
     * DE: Hämodiafiltrationslösung.<br>
     * FR: Solution pour hémodiafiltration.<br>
     * IT: Soluzione per emofiltrazione.<br>
     */
    SOLUTION_FOR_HAEMODIAFILTRATION("11403000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Solution for haemodiafiltration",
                                    "Solution for haemodiafiltration",
                                    "Hämodiafiltrationslösung",
                                    "Solution pour hémodiafiltration",
                                    "Soluzione per emofiltrazione"),
    /**
     * EN: Solution for haemodialysis.<br>
     * DE: Hämodialyselösung.<br>
     * FR: Solution pour hémodialyse.<br>
     * IT: Soluzione per emodialisi.<br>
     */
    SOLUTION_FOR_HAEMODIALYSIS("11404000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Solution for haemodialysis",
                               "Solution for haemodialysis",
                               "Hämodialyselösung",
                               "Solution pour hémodialyse",
                               "Soluzione per emodialisi"),
    /**
     * EN: Solution for haemodialysis/haemofiltration.<br>
     * DE: Hämodialyselösung/Hämofiltrationslösung.<br>
     * FR: Solution pour hémodialyse/hémofiltration.<br>
     * IT: Soluzione per emodialisi/emofiltrazione.<br>
     */
    SOLUTION_FOR_HAEMODIALYSIS_HAEMOFILTRATION("50057000",
                                               "0.4.0.127.0.16.1.1.2.1",
                                               "Solution for haemodialysis/haemofiltration",
                                               "Solution for haemodialysis/haemofiltration",
                                               "Hämodialyselösung/Hämofiltrationslösung",
                                               "Solution pour hémodialyse/hémofiltration",
                                               "Soluzione per emodialisi/emofiltrazione"),
    /**
     * EN: Solution for haemofiltration.<br>
     * DE: Hämofiltrationslösung.<br>
     * FR: Solution pour hémofiltration.<br>
     * IT: Soluzione per emofiltrazione.<br>
     */
    SOLUTION_FOR_HAEMOFILTRATION("11402000",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Solution for haemofiltration",
                                 "Solution for haemofiltration",
                                 "Hämofiltrationslösung",
                                 "Solution pour hémofiltration",
                                 "Soluzione per emofiltrazione"),
    /**
     * EN: Solution for infusion.<br>
     * DE: Infusionslösung.<br>
     * FR: Solution pour perfusion.<br>
     * IT: Soluzione per infusione.<br>
     */
    SOLUTION_FOR_INFUSION("11210000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Solution for infusion",
                          "Solution for infusion",
                          "Infusionslösung",
                          "Solution pour perfusion",
                          "Soluzione per infusione"),
    /**
     * EN: Solution for injection.<br>
     * DE: Injektionslösung.<br>
     * FR: Solution injectable.<br>
     * IT: Soluzione iniettabile.<br>
     */
    SOLUTION_FOR_INJECTION("11201000",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Solution for injection",
                           "Solution for injection",
                           "Injektionslösung",
                           "Solution injectable",
                           "Soluzione iniettabile"),
    /**
     * EN: Solution for injection/infusion.<br>
     * DE: Injektions-/Infusionslösung.<br>
     * FR: Solution injectable/pour perfusion.<br>
     * IT: Soluzione iniettabile o per infusione.<br>
     */
    SOLUTION_FOR_INJECTION_INFUSION("50060000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Solution for injection/infusion",
                                    "Solution for injection/infusion",
                                    "Injektions-/Infusionslösung",
                                    "Solution injectable/pour perfusion",
                                    "Soluzione iniettabile o per infusione"),
    /**
     * EN: Solution for injection/skin-prick test.<br>
     * DE: Injektionslösung/ Pricktestlösung.<br>
     * FR: Solution injectable/ pour prick-test.<br>
     * IT: Soluzione iniettabile/per skin-prick test.<br>
     */
    SOLUTION_FOR_INJECTION_SKIN_PRICK_TEST("13051000",
                                           "0.4.0.127.0.16.1.1.2.1",
                                           "Solution for injection/skin-prick test",
                                           "Solution for injection/skin-prick test",
                                           "Injektionslösung/ Pricktestlösung",
                                           "Solution injectable/ pour prick-test",
                                           "Soluzione iniettabile/per skin-prick test"),
    /**
     * EN: Solution for intraocular irrigation.<br>
     * DE: Lösung zur intraokularen Anwendung.<br>
     * FR: Solution pour irrigation intraoculaire.<br>
     * IT: Soluzione per irrigazione intraoculare.<br>
     */
    SOLUTION_FOR_INTRAOCULAR_IRRIGATION("50073500",
                                        "0.4.0.127.0.16.1.1.2.1",
                                        "Solution for intraocular irrigation",
                                        "Solution for intraocular irrigation",
                                        "Lösung zur intraokularen Anwendung",
                                        "Solution pour irrigation intraoculaire",
                                        "Soluzione per irrigazione intraoculare"),
    /**
     * EN: Solution for iontophoresis.<br>
     * DE: Lösung zur Iontophorese.<br>
     * FR: Solution pour iontophorèse.<br>
     * IT: Soluzione per iontoforesi.<br>
     */
    SOLUTION_FOR_IONTOPHORESIS("10518000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Solution for iontophoresis",
                               "Solution for iontophoresis",
                               "Lösung zur Iontophorese",
                               "Solution pour iontophorèse",
                               "Soluzione per iontoforesi"),
    /**
     * EN: Solution for organ preservation.<br>
     * DE: Organkonservierungslösung.<br>
     * FR: Solution pour conservation d'organe.<br>
     * IT: Soluzione per conservazione di organi.<br>
     */
    SOLUTION_FOR_ORGAN_PRESERVATION("12112000",
                                    "0.4.0.127.0.16.1.1.2.1",
                                    "Solution for organ preservation",
                                    "Solution for organ preservation",
                                    "Organkonservierungslösung",
                                    "Solution pour conservation d'organe",
                                    "Soluzione per conservazione di organi"),
    /**
     * EN: Solution for peritoneal dialysis.<br>
     * DE: Peritonealdialyselösung.<br>
     * FR: Solution pour dialyse péritonéale.<br>
     * IT: Soluzione per dialisi peritoneale.<br>
     */
    SOLUTION_FOR_PERITONEAL_DIALYSIS("11401000",
                                     "0.4.0.127.0.16.1.1.2.1",
                                     "Solution for peritoneal dialysis",
                                     "Solution for peritoneal dialysis",
                                     "Peritonealdialyselösung",
                                     "Solution pour dialyse péritonéale",
                                     "Soluzione per dialisi peritoneale"),
    /**
     * EN: Solution for provocation test.<br>
     * DE: Provokationstestlösung.<br>
     * FR: solution pour test de provocation.<br>
     * IT: Soluzione per saggio di provocazione.<br>
     */
    SOLUTION_FOR_PROVOCATION_TEST("12131000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Solution for provocation test",
                                  "Solution for provocation test",
                                  "Provokationstestlösung",
                                  "solution pour test de provocation",
                                  "Soluzione per saggio di provocazione"),
    /**
     * EN: Solution for sealant.<br>
     * DE: Lösung für Gewebekleber.<br>
     * FR: Solution pour colle.<br>
     * IT: Soluzione per adesivo tissutale.<br>
     */
    SOLUTION_FOR_SEALANT("50061500",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Solution for sealant",
                         "Solution for sealant",
                         "Lösung für Gewebekleber",
                         "Solution pour colle",
                         "Soluzione per adesivo tissutale"),
    /**
     * EN: Solution for skin-prick test.<br>
     * DE: Pricktestlösung.<br>
     * FR: solution pour prick-test.<br>
     * IT: Soluzione per skin-prick test.<br>
     */
    SOLUTION_FOR_SKIN_PRICK_TEST("10548000",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Solution for skin-prick test",
                                 "Solution for skin-prick test",
                                 "Pricktestlösung",
                                 "solution pour prick-test",
                                 "Soluzione per skin-prick test"),
    /**
     * EN: Solution for skin-scratch test.<br>
     * DE: Scratchtestlösung.<br>
     * FR: solution pour test intradermique.<br>
     * IT: Soluzione per scarificazione.<br>
     */
    SOLUTION_FOR_SKIN_SCRATCH_TEST("10549000",
                                   "0.4.0.127.0.16.1.1.2.1",
                                   "Solution for skin-scratch test",
                                   "Solution for skin-scratch test",
                                   "Scratchtestlösung",
                                   "solution pour test intradermique",
                                   "Soluzione per scarificazione"),
    /**
     * EN: Solution for solution for infusion.<br>
     * DE: Lösung zur Herstellung einer Infusionslösung.<br>
     * FR: Solution pour solution pour perfusion.<br>
     * IT: Soluzione per soluzione per infusione.<br>
     */
    SOLUTION_FOR_SOLUTION_FOR_INFUSION("13061000",
                                       "0.4.0.127.0.16.1.1.2.1",
                                       "Solution for solution for infusion",
                                       "Solution for solution for infusion",
                                       "Lösung zur Herstellung einer Infusionslösung",
                                       "Solution pour solution pour perfusion",
                                       "Soluzione per soluzione per infusione"),
    /**
     * EN: Solution for solution for injection.<br>
     * DE: Lösung zur Herstellung einer Injektionslösung.<br>
     * FR: Solution pour solution injectable.<br>
     * IT: Soluzione per soluzione iniettabile.<br>
     */
    SOLUTION_FOR_SOLUTION_FOR_INJECTION("13033000",
                                        "0.4.0.127.0.16.1.1.2.1",
                                        "Solution for solution for injection",
                                        "Solution for solution for injection",
                                        "Lösung zur Herstellung einer Injektionslösung",
                                        "Solution pour solution injectable",
                                        "Soluzione per soluzione iniettabile"),
    /**
     * EN: Solution for suspension for injection.<br>
     * DE: Lösung zur Herstellung einer Injektionssuspension.<br>
     * FR: Solution pour suspension injectable.<br>
     * IT: Soluzione per sospensione iniettabile.<br>
     */
    SOLUTION_FOR_SUSPENSION_FOR_INJECTION("13047000",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Solution for suspension for injection",
                                          "Solution for suspension for injection",
                                          "Lösung zur Herstellung einer Injektionssuspension",
                                          "Solution pour suspension injectable",
                                          "Soluzione per sospensione iniettabile"),
    /**
     * EN: Solvent for...<br>
     * DE: Lösungsmittel zur Herstellung...<br>
     * FR: Solvant pour...<br>
     * IT: Solvente per….<br>
     */
    SOLVENT_FOR("13035000",
                "0.4.0.127.0.16.1.1.2.1",
                "Solvent for...",
                "Solvent for...",
                "Lösungsmittel zur Herstellung...",
                "Solvant pour...",
                "Solvente per…"),
    /**
     * EN: Solvent for parenteral use.<br>
     * DE: Lösungsmittel zur Herstellung von Parenteralia.<br>
     * FR: Solvant pour préparation parentérale.<br>
     * IT: Solvente per uso parenterale.<br>
     */
    SOLVENT_FOR_PARENTERAL_USE("11216000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Solvent for parenteral use",
                               "Solvent for parenteral use",
                               "Lösungsmittel zur Herstellung von Parenteralia",
                               "Solvant pour préparation parentérale",
                               "Solvente per uso parenterale"),
    /**
     * EN: Solvent for solution for infusion.<br>
     * DE: Lösungsmittel zur Herstellung einer Infusionslösung.<br>
     * FR: Solvant pour solution pour perfusion.<br>
     * IT: Solvente per soluzione per infusione.<br>
     */
    SOLVENT_FOR_SOLUTION_FOR_INFUSION("50076000",
                                      "0.4.0.127.0.16.1.1.2.1",
                                      "Solvent for solution for infusion",
                                      "Solvent for solution for infusion",
                                      "Lösungsmittel zur Herstellung einer Infusionslösung",
                                      "Solvant pour solution pour perfusion",
                                      "Solvente per soluzione per infusione"),
    /**
     * EN: Solvent for solution for intraocular irrigation.<br>
     * DE: Lösungsmittel zur Herstellung einer Lösung zur intraokularen Anwendung.<br>
     * FR: Solvant pour solution pour irrigation intraoculaire.<br>
     * IT: Solvente per soluzione per irrigazione intraoculare.<br>
     */
    SOLVENT_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION("50074000",
                                                    "0.4.0.127.0.16.1.1.2.1",
                                                    "Solvent for solution for intraocular irrigation",
                                                    "Solvent for solution for intraocular irrigation",
                                                    "Lösungsmittel zur Herstellung einer Lösung zur intraokularen Anwendung",
                                                    "Solvant pour solution pour irrigation intraoculaire",
                                                    "Solvente per soluzione per irrigazione intraoculare"),
    /**
     * EN: Stomach irrigation.<br>
     * DE: Magenspülflüssigkeit.<br>
     * FR: Solution pour irrigation stomacale.<br>
     * IT: Liquido per lavanda gastrica.<br>
     */
    STOMACH_IRRIGATION("12114000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Stomach irrigation",
                       "Stomach irrigation",
                       "Magenspülflüssigkeit",
                       "Solution pour irrigation stomacale",
                       "Liquido per lavanda gastrica"),
    /**
     * EN: Sublingual film.<br>
     * DE: Schmelzfilm zur sublingualen Anwendung.<br>
     * FR: Film sublinguale.<br>
     * IT: Film sublinguale.<br>
     */
    SUBLINGUAL_FILM("10317500",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Sublingual film",
                    "Sublingual film",
                    "Schmelzfilm zur sublingualen Anwendung",
                    "Film sublinguale",
                    "Film sublinguale"),
    /**
     * EN: Sublingual lyophilisate.<br>
     * DE: Lyophilisat zur sublingualen Anwendung.<br>
     * FR: Larves médicinales.<br>
     * IT: Larva medicinale.<br>
     */
    SUBLINGUAL_LYOPHILISATE("13127000",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Sublingual lyophilisate",
                            "Sublingual lyophilisate",
                            "Lyophilisat zur sublingualen Anwendung",
                            "Larves médicinales",
                            "Larva medicinale"),
    /**
     * EN: Sublingual powder.<br>
     * DE: Pulver zur sublingualen Anwendung.<br>
     * FR: Poudre sublinguale.<br>
     * IT: Polvere sublinguale.<br>
     */
    SUBLINGUAL_POWDER("13105000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Sublingual powder",
                      "Sublingual powder",
                      "Pulver zur sublingualen Anwendung",
                      "Poudre sublinguale",
                      "Polvere sublinguale"),
    /**
     * EN: Sublingual spray, emulsion.<br>
     * DE: Sublingualspray, Emulsion.<br>
     * FR: Emulsion pour pulvérisation sublinguale.<br>
     * IT: Spray sublinguale, emulsione.<br>
     */
    SUBLINGUAL_SPRAY_EMULSION("10309100",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Sublingual spray, emulsion",
                              "Sublingual spray, emulsion",
                              "Sublingualspray, Emulsion",
                              "Emulsion pour pulvérisation sublinguale",
                              "Spray sublinguale, emulsione"),
    /**
     * EN: Sublingual spray, solution.<br>
     * DE: Sublingualspray, Lösung.<br>
     * FR: Solution pour pulvérisation sublinguale.<br>
     * IT: Spray sublinguale, soluzione.<br>
     */
    SUBLINGUAL_SPRAY_SOLUTION("10309200",
                              "0.4.0.127.0.16.1.1.2.1",
                              "Sublingual spray, solution",
                              "Sublingual spray, solution",
                              "Sublingualspray, Lösung",
                              "Solution pour pulvérisation sublinguale",
                              "Spray sublinguale, soluzione"),
    /**
     * EN: Sublingual spray, suspension.<br>
     * DE: Sublingualspray, Suspension.<br>
     * FR: Suspension pour pulvérisation sublinguale.<br>
     * IT: Spray sublinguale, sospensione.<br>
     */
    SUBLINGUAL_SPRAY_SUSPENSION("10309300",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Sublingual spray, suspension",
                                "Sublingual spray, suspension",
                                "Sublingualspray, Suspension",
                                "Suspension pour pulvérisation sublinguale",
                                "Spray sublinguale, sospensione"),
    /**
     * EN: Sublingual tablet.<br>
     * DE: Sublingualtablette.<br>
     * FR: Comprimé sublingual.<br>
     * IT: Compressa sublinguale.<br>
     */
    SUBLINGUAL_TABLET("10318000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Sublingual tablet",
                      "Sublingual tablet",
                      "Sublingualtablette",
                      "Comprimé sublingual",
                      "Compressa sublinguale"),
    /**
     * EN: Suppository.<br>
     * DE: Zäpfchen.<br>
     * FR: Suppositoire.<br>
     * IT: Supposta.<br>
     */
    SUPPOSITORY("11013000",
                "0.4.0.127.0.16.1.1.2.1",
                "Suppository",
                "Suppository",
                "Zäpfchen",
                "Suppositoire",
                "Supposta"),
    /**
     * EN: Suspension for emulsion for injection.<br>
     * DE: Suspension zur Herstellung einer Emulsion zur Injektion.<br>
     * FR: Suspension pour émulsion injectable.<br>
     * IT: Sospensione per emulsione iniettabile.<br>
     */
    SUSPENSION_FOR_EMULSION_FOR_INJECTION("13036000",
                                          "0.4.0.127.0.16.1.1.2.1",
                                          "Suspension for emulsion for injection",
                                          "Suspension for emulsion for injection",
                                          "Suspension zur Herstellung einer Emulsion zur Injektion",
                                          "Suspension pour émulsion injectable",
                                          "Sospensione per emulsione iniettabile"),
    /**
     * EN: Suspension for injection.<br>
     * DE: Injektionssuspension.<br>
     * FR: Suspension injectable.<br>
     * IT: Sospensione iniettabile.<br>
     */
    SUSPENSION_FOR_INJECTION("11202000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Suspension for injection",
                             "Suspension for injection",
                             "Injektionssuspension",
                             "Suspension injectable",
                             "Sospensione iniettabile"),
    /**
     * EN: Suspension for oral suspension.<br>
     * DE: Suspension zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Suspension pour suspension buvable.<br>
     * IT: Sospensione per sospensione orale.<br>
     */
    SUSPENSION_FOR_ORAL_SUSPENSION("13037000",
                                   "0.4.0.127.0.16.1.1.2.1",
                                   "Suspension for oral suspension",
                                   "Suspension for oral suspension",
                                   "Suspension zur Herstellung einer Suspension zum Einnehmen",
                                   "Suspension pour suspension buvable",
                                   "Sospensione per sospensione orale"),
    /**
     * EN: Suspension for suspension for injection.<br>
     * DE: Suspension zur Herstellung einer Injektionssuspension.<br>
     * FR: Suspension pour suspension injectable.<br>
     * IT: Sospensione per sospensione iniettabile.<br>
     */
    SUSPENSION_FOR_SUSPENSION_FOR_INJECTION("13039000",
                                            "0.4.0.127.0.16.1.1.2.1",
                                            "Suspension for suspension for injection",
                                            "Suspension for suspension for injection",
                                            "Suspension zur Herstellung einer Injektionssuspension",
                                            "Suspension pour suspension injectable",
                                            "Sospensione per sospensione iniettabile"),
    /**
     * EN: Syrup.<br>
     * DE: Sirup.<br>
     * FR: Sirop.<br>
     * IT: Sciroppo.<br>
     */
    SYRUP("10117000",
          "0.4.0.127.0.16.1.1.2.1",
          "Syrup",
          "Syrup",
          "Sirup",
          "Sirop",
          "Sciroppo"),
    /**
     * EN: Tablet.<br>
     * DE: Tablette.<br>
     * FR: Comprimé.<br>
     * IT: Compressa.<br>
     */
    TABLET("10219000",
           "0.4.0.127.0.16.1.1.2.1",
           "Tablet",
           "Tablet",
           "Tablette",
           "Comprimé",
           "Compressa"),
    /**
     * EN: Tablet for cutaneous solution.<br>
     * DE: Tablette zur Herstellung einer Lösung zur Anwendung auf der Haut.<br>
     * FR: Comprimé pour solution cutanée.<br>
     * IT: Compressa per soluzione cutanea.<br>
     */
    TABLET_FOR_CUTANEOUS_SOLUTION("13066000",
                                  "0.4.0.127.0.16.1.1.2.1",
                                  "Tablet for cutaneous solution",
                                  "Tablet for cutaneous solution",
                                  "Tablette zur Herstellung einer Lösung zur Anwendung auf der Haut",
                                  "Comprimé pour solution cutanée",
                                  "Compressa per soluzione cutanea"),
    /**
     * EN: Tablet for rectal solution.<br>
     * DE: Tablette zur Herstellung einer Rektallösung.<br>
     * FR: Comprimé pour solution rectale.<br>
     * IT: Compressa per soluzione rettale.<br>
     */
    TABLET_FOR_RECTAL_SOLUTION("11011000",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Tablet for rectal solution",
                               "Tablet for rectal solution",
                               "Tablette zur Herstellung einer Rektallösung",
                               "Comprimé pour solution rectale",
                               "Compressa per soluzione rettale"),
    /**
     * EN: Tablet for rectal suspension.<br>
     * DE: Tablette zur Herstellung einer Rektalsuspension.<br>
     * FR: Comprimé pour suspension rectale.<br>
     * IT: Compressa per sospensione rettale.<br>
     */
    TABLET_FOR_RECTAL_SUSPENSION("11012000",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Tablet for rectal suspension",
                                 "Tablet for rectal suspension",
                                 "Tablette zur Herstellung einer Rektalsuspension",
                                 "Comprimé pour suspension rectale",
                                 "Compressa per sospensione rettale"),
    /**
     * EN: Tablet for vaginal solution.<br>
     * DE: Tablette zur Herstellung einer Vaginallösung.<br>
     * FR: Comprimé pour solution vaginale.<br>
     * IT: Compressa per soluzione vaginale.<br>
     */
    TABLET_FOR_VAGINAL_SOLUTION("10908000",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Tablet for vaginal solution",
                                "Tablet for vaginal solution",
                                "Tablette zur Herstellung einer Vaginallösung",
                                "Comprimé pour solution vaginale",
                                "Compressa per soluzione vaginale"),
    /**
     * EN: Tablet with sensor.<br>
     * DE: Tablette mit Sensor.<br>
     * FR: Comprimé avec capteur.<br>
     * IT: Compressa con sensore.<br>
     */
    TABLET_WITH_SENSOR("13118000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Tablet with sensor",
                       "Tablet with sensor",
                       "Tablette mit Sensor",
                       "Comprimé avec capteur",
                       "Compressa con sensore"),
    /**
     * EN: Toothpaste.<br>
     * DE: Zahnpaste.<br>
     * FR: Pâte dentifrice.<br>
     * IT: Pasta dentifricia.<br>
     */
    TOOTHPASTE("10409000",
               "0.4.0.127.0.16.1.1.2.1",
               "Toothpaste",
               "Toothpaste",
               "Zahnpaste",
               "Pâte dentifrice",
               "Pasta dentifricia"),
    /**
     * EN: Transdermal gel.<br>
     * DE: Transdermales Gel.<br>
     * FR: Gel transdermique.<br>
     * IT: Gel transdermico.<br>
     */
    TRANSDERMAL_GEL("10546250",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Transdermal gel",
                    "Transdermal gel",
                    "Transdermales Gel",
                    "Gel transdermique",
                    "Gel transdermico"),
    /**
     * EN: Transdermal ointment.<br>
     * DE: Transdermale Salbe.<br>
     * FR: Pommade transdermique.<br>
     * IT: Unguento transdermico.<br>
     */
    TRANSDERMAL_OINTMENT("13102000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Transdermal ointment",
                         "Transdermal ointment",
                         "Transdermale Salbe",
                         "Pommade transdermique",
                         "Unguento transdermico"),
    /**
     * EN: Transdermal patch.<br>
     * DE: transdermales Pflaster.<br>
     * FR: Patch transdermique.<br>
     * IT: Cerotto transdermico.<br>
     */
    TRANSDERMAL_PATCH("10519000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Transdermal patch",
                      "Transdermal patch",
                      "transdermales Pflaster",
                      "Patch transdermique",
                      "Cerotto transdermico"),
    /**
     * EN: Transdermal solution.<br>
     * DE: transdermale Lösung.<br>
     * FR: Solution transdermique.<br>
     * IT: Soluzione transdermica.<br>
     */
    TRANSDERMAL_SOLUTION("10546400",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Transdermal solution",
                         "Transdermal solution",
                         "transdermale Lösung",
                         "Solution transdermique",
                         "Soluzione transdermica"),
    /**
     * EN: Transdermal spray, solution.<br>
     * DE: transdermales Spray, Lösung.<br>
     * FR: Solution pour pulvérisation transdermique.<br>
     * IT: Spray transdermico, soluzione.<br>
     */
    TRANSDERMAL_SPRAY_SOLUTION("10546500",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Transdermal spray, solution",
                               "Transdermal spray, solution",
                               "transdermales Spray, Lösung",
                               "Solution pour pulvérisation transdermique",
                               "Spray transdermico, soluzione"),
    /**
     * EN: Transdermal system.<br>
     * DE: transdermales System.<br>
     * FR: système transdermique.<br>
     * IT: Sistema transdermico.<br>
     */
    TRANSDERMAL_SYSTEM("10547000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Transdermal system",
                       "Transdermal system",
                       "transdermales System",
                       "système transdermique",
                       "Sistema transdermico"),
    /**
     * EN: Urethral emulsion.<br>
     * DE: Emulsion zur Anwendung in der Harnröhre.<br>
     * FR: Emulsion urétrale.<br>
     * IT: Emulsione uretrale.<br>
     */
    URETHRAL_EMULSION("13077000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Urethral emulsion",
                      "Urethral emulsion",
                      "Emulsion zur Anwendung in der Harnröhre",
                      "Emulsion urétrale",
                      "Emulsione uretrale"),
    /**
     * EN: Urethral gel.<br>
     * DE: Gel zur Anwendung in der Harnröhre.<br>
     * FR: Gel urétral.<br>
     * IT: Gel uretrale.<br>
     */
    URETHRAL_GEL("11504000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Urethral gel",
                 "Urethral gel",
                 "Gel zur Anwendung in der Harnröhre",
                 "Gel urétral",
                 "Gel uretrale"),
    /**
     * EN: Urethral ointment.<br>
     * DE: Salbe zur Anwendung in der Harnröhre.<br>
     * FR: Pommade urétrale.<br>
     * IT: Unguento uretrale.<br>
     */
    URETHRAL_OINTMENT("13123000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Urethral ointment",
                      "Urethral ointment",
                      "Salbe zur Anwendung in der Harnröhre",
                      "Pommade urétrale",
                      "Unguento uretrale"),
    /**
     * EN: Urethral stick.<br>
     * DE: Stäbchen zur Anwendung in der Harnröhre.<br>
     * FR: Bâton pour usage urétral.<br>
     * IT: Bastoncino uretrale.<br>
     */
    URETHRAL_STICK("11505000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Urethral stick",
                   "Urethral stick",
                   "Stäbchen zur Anwendung in der Harnröhre",
                   "Bâton pour usage urétral",
                   "Bastoncino uretrale"),
    /**
     * EN: Vaginal capsule, hard.<br>
     * DE: Hartkapsel zur vaginalen Anwendung.<br>
     * FR: Gélule vaginale.<br>
     * IT: Capsula rigida vaginale.<br>
     */
    VAGINAL_CAPSULE_HARD("10910000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Vaginal capsule, hard",
                         "Vaginal capsule, hard",
                         "Hartkapsel zur vaginalen Anwendung",
                         "Gélule vaginale",
                         "Capsula rigida vaginale"),
    /**
     * EN: Vaginal capsule, soft.<br>
     * DE: Weichkapsel zur vaginalen Anwendung.<br>
     * FR: Capsule molle vaginale.<br>
     * IT: Capsula molle vaginale.<br>
     */
    VAGINAL_CAPSULE_SOFT("10911000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Vaginal capsule, soft",
                         "Vaginal capsule, soft",
                         "Weichkapsel zur vaginalen Anwendung",
                         "Capsule molle vaginale",
                         "Capsula molle vaginale"),
    /**
     * EN: Vaginal cream.<br>
     * DE: Vaginalcreme.<br>
     * FR: Crème vaginale.<br>
     * IT: Crema vaginale.<br>
     */
    VAGINAL_CREAM("10901000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Vaginal cream",
                  "Vaginal cream",
                  "Vaginalcreme",
                  "Crème vaginale",
                  "Crema vaginale"),
    /**
     * EN: Vaginal delivery system.<br>
     * DE: vaginales Wirkstofffreisetzungssystem.<br>
     * FR: Système de diffusion vaginal.<br>
     * IT: Dispositivo vaginale.<br>
     */
    VAGINAL_DELIVERY_SYSTEM("10915000",
                            "0.4.0.127.0.16.1.1.2.1",
                            "Vaginal delivery system",
                            "Vaginal delivery system",
                            "vaginales Wirkstofffreisetzungssystem",
                            "Système de diffusion vaginal",
                            "Dispositivo vaginale"),
    /**
     * EN: Vaginal emulsion.<br>
     * DE: Vaginalemulsion.<br>
     * FR: Emulsion vaginale.<br>
     * IT: Emulsione vaginale.<br>
     */
    VAGINAL_EMULSION("10907000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Vaginal emulsion",
                     "Vaginal emulsion",
                     "Vaginalemulsion",
                     "Emulsion vaginale",
                     "Emulsione vaginale"),
    /**
     * EN: Vaginal foam.<br>
     * DE: Vaginalschaum.<br>
     * FR: Mousse vaginale.<br>
     * IT: Schiuma vaginale.<br>
     */
    VAGINAL_FOAM("10904000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Vaginal foam",
                 "Vaginal foam",
                 "Vaginalschaum",
                 "Mousse vaginale",
                 "Schiuma vaginale"),
    /**
     * EN: Vaginal gel.<br>
     * DE: Vaginalgel.<br>
     * FR: Gel vaginal.<br>
     * IT: Gel vaginale.<br>
     */
    VAGINAL_GEL("10902000",
                "0.4.0.127.0.16.1.1.2.1",
                "Vaginal gel",
                "Vaginal gel",
                "Vaginalgel",
                "Gel vaginal",
                "Gel vaginale"),
    /**
     * EN: Vaginal ointment.<br>
     * DE: Vaginalsalbe.<br>
     * FR: Pommade vaginale.<br>
     * IT: Unguento vaginale.<br>
     */
    VAGINAL_OINTMENT("10903000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Vaginal ointment",
                     "Vaginal ointment",
                     "Vaginalsalbe",
                     "Pommade vaginale",
                     "Unguento vaginale"),
    /**
     * EN: Vaginal solution.<br>
     * DE: Vaginallösung.<br>
     * FR: Solution vaginale.<br>
     * IT: Soluzione vaginale.<br>
     */
    VAGINAL_SOLUTION("10905000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Vaginal solution",
                     "Vaginal solution",
                     "Vaginallösung",
                     "Solution vaginale",
                     "Soluzione vaginale"),
    /**
     * EN: Vaginal suspension.<br>
     * DE: Vaginalsuspension.<br>
     * FR: Suspension vaginale.<br>
     * IT: Sospensione vaginale.<br>
     */
    VAGINAL_SUSPENSION("10906000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Vaginal suspension",
                       "Vaginal suspension",
                       "Vaginalsuspension",
                       "Suspension vaginale",
                       "Sospensione vaginale"),
    /**
     * EN: Vaginal tablet.<br>
     * DE: Vaginaltablette.<br>
     * FR: Comprimé vaginal.<br>
     * IT: Compressa vaginale.<br>
     */
    VAGINAL_TABLET("10912000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Vaginal tablet",
                   "Vaginal tablet",
                   "Vaginaltablette",
                   "Comprimé vaginal",
                   "Compressa vaginale"),
    /**
     * EN: Wound stick.<br>
     * DE: Wundstäbchen.<br>
     * FR: Bâton intralésionnel.<br>
     * IT: Matita emostatica.<br>
     */
    WOUND_STICK("12104000",
                "0.4.0.127.0.16.1.1.2.1",
                "Wound stick",
                "Wound stick",
                "Wundstäbchen",
                "Bâton intralésionnel",
                "Matita emostatica");

    /**
     * EN: Code for Anticoagulant and preservative solution for blood.<br>
     * DE: Code für Stabilisatorlösung für Blutkonserven.<br>
     * FR: Code de Solution anticoagulante et de conservation du sang humain.<br>
     * IT: Code per Soluzione anticoagulante e conservante per il sangue.<br>
     */
    public static final String ANTICOAGULANT_AND_PRESERVATIVE_SOLUTION_FOR_BLOOD_CODE = "12102000";

    /**
     * EN: Code for Bath additive.<br>
     * DE: Code für Badezusatz.<br>
     * FR: Code de Adjuvant de bain.<br>
     * IT: Code per Additivo per bagno.<br>
     */
    public static final String BATH_ADDITIVE_CODE = "10501000";

    /**
     * EN: Code for Bladder irrigation.<br>
     * DE: Code für Blasenspüllösung.<br>
     * FR: Code de Solution pour irrigation vésicale.<br>
     * IT: Code per Irrigazione vescicale.<br>
     */
    public static final String BLADDER_IRRIGATION_CODE = "11502000";

    /**
     * EN: Code for Buccal film.<br>
     * DE: Code für Buccalfilm.<br>
     * FR: Code de Film buccogingival.<br>
     * IT: Code per Film orosolubile.<br>
     */
    public static final String BUCCAL_FILM_CODE = "10314011";

    /**
     * EN: Code for Buccal tablet.<br>
     * DE: Code für Buccaltablette.<br>
     * FR: Code de Comprimé buccogingival.<br>
     * IT: Code per Compressa orosolubile.<br>
     */
    public static final String BUCCAL_TABLET_CODE = "10320000";

    /**
     * EN: Code for Cachet.<br>
     * DE: Code für Oblatenkapsel.<br>
     * FR: Code de Cachet.<br>
     * IT: Code per Cachet.<br>
     */
    public static final String CACHET_CODE = "10209000";

    /**
     * EN: Code for Capsule, hard.<br>
     * DE: Code für Hartkapsel.<br>
     * FR: Code de Gélule.<br>
     * IT: Code per Capsula rigida.<br>
     */
    public static final String CAPSULE_HARD_CODE = "10210000";

    /**
     * EN: Code for Capsule, soft.<br>
     * DE: Code für Weichkapsel.<br>
     * FR: Code de Capsule molle.<br>
     * IT: Code per Capsula molle.<br>
     */
    public static final String CAPSULE_SOFT_CODE = "10211000";

    /**
     * EN: Code for Chewable capsule, soft.<br>
     * DE: Code für Weichkapsel zum Zerbeißen.<br>
     * FR: Code de Capsule molle à mâcher.<br>
     * IT: Code per Capsula molle masticabile.<br>
     */
    public static final String CHEWABLE_CAPSULE_SOFT_CODE = "10214000";

    /**
     * EN: Code for Chewable/dispersible tablet.<br>
     * DE: Code für Kautablette/Tablette zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Comprimé dispersible / à croquer.<br>
     * IT: Code per Compressa masticabile/dispersibile.<br>
     */
    public static final String CHEWABLE_DISPERSIBLE_TABLET_CODE = "50001000";

    /**
     * EN: Code for Chewable tablet.<br>
     * DE: Code für Kautablette.<br>
     * FR: Code de Comprimé à croquer.<br>
     * IT: Code per Compressa masticabile.<br>
     */
    public static final String CHEWABLE_TABLET_CODE = "10228000";

    /**
     * EN: Code for Coated granules.<br>
     * DE: Code für Überzogenes Granulat.<br>
     * FR: Code de Granulés enrobés.<br>
     * IT: Code per Granulato rivestito.<br>
     */
    public static final String COATED_GRANULES_CODE = "13046000";

    /**
     * EN: Code for Coated tablet.<br>
     * DE: Code für überzogene Tablette.<br>
     * FR: Code de Comprimé enrobé.<br>
     * IT: Code per Compressa rivestita.<br>
     */
    public static final String COATED_TABLET_CODE = "10220000";

    /**
     * EN: Code for Collodion.<br>
     * DE: Code für filmbildende Flüssigkeit.<br>
     * FR: Code de Collodion.<br>
     * IT: Code per Collodio.<br>
     */
    public static final String COLLODION_CODE = "10520000";

    /**
     * EN: Code for Compressed lozenge.<br>
     * DE: Code für Lutschtablette, gepresst.<br>
     * FR: Code de Comprimé à sucer.<br>
     * IT: Code per Pastiglia.<br>
     */
    public static final String COMPRESSED_LOZENGE_CODE = "10322000";

    /**
     * EN: Code for Concentrate for concentrate for solution for infusion.<br>
     * DE: Code für Konzentrat für ein Konzentrat zur Herstellung einer Infusionslösung.<br>
     * FR: Code de Gaz médicinal liquéfié.<br>
     * IT: Code per Concentrato per concentrato per soluzione per infusione.<br>
     */
    public static final String CONCENTRATE_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INFUSION_CODE = "13001000";

    /**
     * EN: Code for Concentrate for cutaneous solution.<br>
     * DE: Code für Konzentrat zur Herstellung einer Lösung zur Anwendung auf der Haut.<br>
     * FR: Code de Solution à diluer pour solution cutanée.<br>
     * IT: Code per Concentrato per soluzione cutanea.<br>
     */
    public static final String CONCENTRATE_FOR_CUTANEOUS_SOLUTION_CODE = "10514000";

    /**
     * EN: Code for Concentrate for cutaneous spray, emulsion.<br>
     * DE: Code für Konzentrat zur Herstellung eines Sprays zur Anwendung auf der Haut, Emulsion.<br>
     * FR: Code de Solution à diluer pour émulsion pour pulvérisation cutanée.<br>
     * IT: Code per Concentrato per spray cutaneo, emulsione.<br>
     */
    public static final String CONCENTRATE_FOR_CUTANEOUS_SPRAY_EMULSION_CODE = "50009000";

    /**
     * EN: Code for Concentrate for dispersion for infusion.<br>
     * DE: Code für Konzentrat zur Herstellung einer Infusionsdispersion.<br>
     * FR: Code de Dispersion à diluer pour perfusion.<br>
     * IT: Code per Concentrato per dispersione per infusione.<br>
     */
    public static final String CONCENTRATE_FOR_DISPERSION_FOR_INFUSION_CODE = "50009300";

    /**
     * EN: Code for Concentrate for dispersion for injection.<br>
     * DE: Code für Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Dispersion à diluer pour dispersion injectable.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String CONCENTRATE_FOR_DISPERSION_FOR_INJECTION_CODE = "13139000";

    /**
     * EN: Code for Concentrate for emulsion for infusion.<br>
     * DE: Code für Konzentrat zur Herstellung einer Emulsion zur Infusion.<br>
     * FR: Code de Emulsion à diluer pour perfusion.<br>
     * IT: Code per Concentrato per emulsione per infusione.<br>
     */
    public static final String CONCENTRATE_FOR_EMULSION_FOR_INFUSION_CODE = "50009500";

    /**
     * EN: Code for Concentrate for gargle.<br>
     * DE: Code für Konzentrat zur Herstellung einer Gurgellösung.<br>
     * FR: Code de Solution à diluer pour gargarisme.<br>
     * IT: Code per Concentrato per soluzione per gargarismi.<br>
     */
    public static final String CONCENTRATE_FOR_GARGLE_CODE = "10302000";

    /**
     * EN: Code for Concentrate for intravesical solution.<br>
     * DE: Code für Konzentrat zur Herstellung einer Lösung zur intravesikalen Anwendung.<br>
     * FR: Code de Solution à diluer pour solution intravésicale.<br>
     * IT: Code per Concentrato per soluzione endovescicale.<br>
     */
    public static final String CONCENTRATE_FOR_INTRAVESICAL_SOLUTION_CODE = "50009750";

    /**
     * EN: Code for Concentrate for nebuliser solution.<br>
     * DE: Code für Konzentrat zur Herstellung einer Lösung für einen Vernebler.<br>
     * FR: Code de Solution à diluer pour inhalation par nébuliseur.<br>
     * IT: Code per Concentrato per soluzione per nebulizzatore.<br>
     */
    public static final String CONCENTRATE_FOR_NEBULISER_SOLUTION_CODE = "13002000";

    /**
     * EN: Code for Concentrate for oral/rectal solution.<br>
     * DE: Code für Konzentrat zur Herstellung einer Lösung zum Einnehmen /Rektallösung.<br>
     * FR: Code de Solution à diluer pour solution orale/rectale.<br>
     * IT: Code per Concentrato per soluzione orale/rettale.<br>
     */
    public static final String CONCENTRATE_FOR_ORAL_RECTAL_SOLUTION_CODE = "50011000";

    /**
     * EN: Code for Concentrate for oral solution.<br>
     * DE: Code für Konzentrat zur Herstellung einer Lösung  zum Einnehmen.<br>
     * FR: Code de Solution à diluer pour solution buvable.<br>
     * IT: Code per Concentrato per soluzione orale.<br>
     */
    public static final String CONCENTRATE_FOR_ORAL_SOLUTION_CODE = "50010000";

    /**
     * EN: Code for Concentrate for oral suspension.<br>
     * DE: Code für Konzentrat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Suspension à diluer pour suspension buvable.<br>
     * IT: Code per Concentrato per sospensione orale.<br>
     */
    public static final String CONCENTRATE_FOR_ORAL_SUSPENSION_CODE = "10100500";

    /**
     * EN: Code for Concentrate for oromucosal solution.<br>
     * DE: Code für Konzentrat zur Herstellung einer Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Solution à diluer buccale.<br>
     * IT: Code per Concentrato per soluzione per mucosa orale.<br>
     */
    public static final String CONCENTRATE_FOR_OROMUCOSAL_SOLUTION_CODE = "13003000";

    /**
     * EN: Code for Concentrate for rectal solution.<br>
     * DE: Code für Konzentrat zur Herstellung einer Rektallösung.<br>
     * FR: Code de Solution rectale à diluer.<br>
     * IT: Code per Concentrato per soluzione rettale.<br>
     */
    public static final String CONCENTRATE_FOR_RECTAL_SOLUTION_CODE = "11008000";

    /**
     * EN: Code for Concentrate for solution for haemodialysis.<br>
     * DE: Code für Konzentrat zur Herstellung einer Hämodialyselösung.<br>
     * FR: Code de Solution à diluer pour hémodialyse.<br>
     * IT: Code per Soluzione concentrata per emodialisi.<br>
     */
    public static final String CONCENTRATE_FOR_SOLUTION_FOR_HAEMODIALYSIS_CODE = "11405000";

    /**
     * EN: Code for Concentrate for solution for infusion.<br>
     * DE: Code für Konzentrat zur Herstellung einer Infusionslösung.<br>
     * FR: Code de Solution à diluer pour perfusion.<br>
     * IT: Code per Concentrato per soluzione per infusione.<br>
     */
    public static final String CONCENTRATE_FOR_SOLUTION_FOR_INFUSION_CODE = "11213000";

    /**
     * EN: Code for Concentrate for solution for injection.<br>
     * DE: Code für Konzentrat zur Herstellung einer Injektionslösung.<br>
     * FR: Code de Solution à diluer injectable.<br>
     * IT: Code per Concentrato per soluzione iniettabile.<br>
     */
    public static final String CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_CODE = "11209000";

    /**
     * EN: Code for Concentrate for solution for injection/infusion.<br>
     * DE: Code für Konzentrat zur Herstellung einer Injektions- /Infusionslösung.<br>
     * FR: Code de Solution à diluer pour solution injectable/pour perfusion.<br>
     * IT: Code per Concentrato per soluzione iniettabile/ per infusione.<br>
     */
    public static final String CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_INFUSION_CODE = "50079000";

    /**
     * EN: Code for Concentrate for solution for intraocular irrigation.<br>
     * DE: Code für Konzentrat zur Herstellung einer Lösung zur intraokularen Anwendung.<br>
     * FR: Code de Solution à diluer pour solution pour irrigation intraoculaire.<br>
     * IT: Code per Concentrato per soluzione per irrigazione intraoculare.<br>
     */
    public static final String CONCENTRATE_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION_CODE = "10600500";

    /**
     * EN: Code for Concentrate for solution for peritoneal dialysis.<br>
     * DE: Code für Konzentrat zur Herstellung einer Peritonealdialyselösung.<br>
     * FR: Code de Solution à diluer pour solution pour dialyse péritonéale.<br>
     * IT: Code per Concentrato per soluzione per dialisi peritoneale.<br>
     */
    public static final String CONCENTRATE_FOR_SOLUTION_FOR_PERITONEAL_DIALYSIS_CODE = "50013250";

    /**
     * EN: Code for Concentrate for suspension for injection.<br>
     * DE: Code für Konzentrat zur Herstellung einer Injektionssuspension.<br>
     * FR: Code de Suspension à diluer injectable.<br>
     * IT: Code per Concentrato per sospensione iniettabile.<br>
     */
    public static final String CONCENTRATE_FOR_SUSPENSION_FOR_INJECTION_CODE = "13004000";

    /**
     * EN: Code for Cream.<br>
     * DE: Code für Creme.<br>
     * FR: Code de Crème.<br>
     * IT: Code per Crema.<br>
     */
    public static final String CREAM_CODE = "10502000";

    /**
     * EN: Code for Cutaneous emulsion.<br>
     * DE: Code für Emulsion zur Anwendung auf der Haut.<br>
     * FR: Code de Emulsion cutanée.<br>
     * IT: Code per Emulsione cutanea.<br>
     */
    public static final String CUTANEOUS_EMULSION_CODE = "10516000";

    /**
     * EN: Code for Cutaneous foam.<br>
     * DE: Code für Schaum zur  Anwendung auf der Haut.<br>
     * FR: Code de Mousse cutanée.<br>
     * IT: Code per Schiuma cutanea.<br>
     */
    public static final String CUTANEOUS_FOAM_CODE = "10507000";

    /**
     * EN: Code for Cutaneous liquid.<br>
     * DE: Code für Flüssigkeit zur Anwendung auf der Haut.<br>
     * FR: Code de Liquide cutané.<br>
     * IT: Code per Liquido cutaneo.<br>
     */
    public static final String CUTANEOUS_LIQUID_CODE = "10512000";

    /**
     * EN: Code for Cutaneous/nasal ointment.<br>
     * DE: Code für Salbe zur Anwendung auf der Haut/Nasensalbe.<br>
     * FR: Code de Pommade cutanée/ nasale.<br>
     * IT: Code per Unguento cutaneo/nasale.<br>
     */
    public static final String CUTANEOUS_NASAL_OINTMENT_CODE = "50015200";

    /**
     * EN: Code for Cutaneous/oromucosal solution.<br>
     * DE: Code für Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Dispersion à diluer pour dispersion injectable.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String CUTANEOUS_OROMUCOSAL_SOLUTION_CODE = "13140000";

    /**
     * EN: Code for Cutaneous paste.<br>
     * DE: Code für Paste zur Anwendung auf der Haut.<br>
     * FR: Code de Pâte cutanée.<br>
     * IT: Code per Pasta cutanea.<br>
     */
    public static final String CUTANEOUS_PASTE_CODE = "10505000";

    /**
     * EN: Code for Cutaneous patch.<br>
     * DE: Code für Kutanes Pflaster.<br>
     * FR: Code de Patch cutané.<br>
     * IT: Code per Cerotto cutaneo.<br>
     */
    public static final String CUTANEOUS_PATCH_CODE = "10517500";

    /**
     * EN: Code for Cutaneous powder.<br>
     * DE: Code für Pulver zur Anwendung auf der Haut.<br>
     * FR: Code de Poudre pour application cutanée.<br>
     * IT: Code per Polvere cutanea.<br>
     */
    public static final String CUTANEOUS_POWDER_CODE = "10517000";

    /**
     * EN: Code for Cutaneous solution.<br>
     * DE: Code für Lösung zur Anwendung auf der Haut.<br>
     * FR: Code de Solution pour application cutanée.<br>
     * IT: Code per Soluzione cutanea.<br>
     */
    public static final String CUTANEOUS_SOLUTION_CODE = "10513000";

    /**
     * EN: Code for Cutaneous solution/concentrate for oromucosal solution.<br>
     * DE: Code für Lösung zur Anwendung auf der Haut/Konzentrat zur Herstellung einer Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Solution cutanée/ solution à diluer buccale.<br>
     * IT: Code per Soluzione cutanea/concentrato per soluzione per mucosa orale.<br>
     */
    public static final String CUTANEOUS_SOLUTION_CONCENTRATE_FOR_OROMUCOSAL_SOLUTION_CODE = "50015450";

    /**
     * EN: Code for Cutaneous spray, emulsion.<br>
     * DE: Code für Spray zur Anwendung auf der Haut, Emulsion.<br>
     * FR: Code de Émulsion pour pulvérisation cutanée.<br>
     * IT: Code per Spray cutaneo, emulsione.<br>
     */
    public static final String CUTANEOUS_SPRAY_EMULSION_CODE = "50015500";

    /**
     * EN: Code for Cutaneous spray, ointment.<br>
     * DE: Code für Spray zur Anwendung auf der Haut, Salbe.<br>
     * FR: Code de Pommade pour pulvérisation cutanée.<br>
     * IT: Code per Spray cutaneo, unguento.<br>
     */
    public static final String CUTANEOUS_SPRAY_OINTMENT_CODE = "50016000";

    /**
     * EN: Code for Cutaneous spray, powder.<br>
     * DE: Code für Pulver-Spray zur Anwendung auf der Haut.<br>
     * FR: Code de Poudre pour pulvérisation cutanée.<br>
     * IT: Code per Spray cutaneo, polvere.<br>
     */
    public static final String CUTANEOUS_SPRAY_POWDER_CODE = "10511000";

    /**
     * EN: Code for Cutaneous spray, solution.<br>
     * DE: Code für Spray zur Anwendung auf der Haut, Lösung.<br>
     * FR: Code de Solution pour pulvérisation cutanée.<br>
     * IT: Code per Spray cutaneo, soluzione.<br>
     */
    public static final String CUTANEOUS_SPRAY_SOLUTION_CODE = "10509000";

    /**
     * EN: Code for Cutaneous spray, suspension.<br>
     * DE: Code für Spray zur Anwendung auf der Haut, Suspension.<br>
     * FR: Code de Suspension pour pulvérisation cutanée.<br>
     * IT: Code per Spray cutaneo, sospensione.<br>
     */
    public static final String CUTANEOUS_SPRAY_SUSPENSION_CODE = "10510000";

    /**
     * EN: Code for Cutaneous stick.<br>
     * DE: Code für Stift zur Anwendung auf der Haut.<br>
     * FR: Code de Bâton pour application cutanée.<br>
     * IT: Code per Matita cutanea.<br>
     */
    public static final String CUTANEOUS_STICK_CODE = "10523000";

    /**
     * EN: Code for Cutaneous suspension.<br>
     * DE: Code für Suspension zur Anwendung auf der Haut.<br>
     * FR: Code de Suspension pour application cutanée.<br>
     * IT: Code per Sospensione cutanea.<br>
     */
    public static final String CUTANEOUS_SUSPENSION_CODE = "10515000";

    /**
     * EN: Code for Dental cement.<br>
     * DE: Code für Dentalzement.<br>
     * FR: Code de Ciment dentaire.<br>
     * IT: Code per Polvere periodontale.<br>
     */
    public static final String DENTAL_CEMENT_CODE = "10401500";

    /**
     * EN: Code for Dental emulsion.<br>
     * DE: Code für Dentalemulsion.<br>
     * FR: Code de Emulsion dentaire.<br>
     * IT: Code per Emulsione dentale.<br>
     */
    public static final String DENTAL_EMULSION_CODE = "10408000";

    /**
     * EN: Code for Dental gel.<br>
     * DE: Code für Dentalgel.<br>
     * FR: Code de Gel dentaire.<br>
     * IT: Code per Gel dentale.<br>
     */
    public static final String DENTAL_GEL_CODE = "10402000";

    /**
     * EN: Code for Dental paste.<br>
     * DE: Code für Dentalpaste.<br>
     * FR: Code de Pâte dentaire.<br>
     * IT: Code per Spray cutaneo, unguento.<br>
     */
    public static final String DENTAL_PASTE_CODE = "50017000";

    /**
     * EN: Code for Dental powder.<br>
     * DE: Code für Dentalpulver.<br>
     * FR: Code de Poudre dentaire.<br>
     * IT: Code per Polvere dentale.<br>
     */
    public static final String DENTAL_POWDER_CODE = "10405000";

    /**
     * EN: Code for Dental solution.<br>
     * DE: Code für Dentallösung.<br>
     * FR: Code de Solution dentaire.<br>
     * IT: Code per Soluzione dentale.<br>
     */
    public static final String DENTAL_SOLUTION_CODE = "10406000";

    /**
     * EN: Code for Dental stick.<br>
     * DE: Code für Dentalstift.<br>
     * FR: Code de Bâton dentaire.<br>
     * IT: Code per Bastoncino dentale.<br>
     */
    public static final String DENTAL_STICK_CODE = "10403000";

    /**
     * EN: Code for Dental suspension.<br>
     * DE: Code für Dentalsuspension.<br>
     * FR: Code de Suspension dentaire.<br>
     * IT: Code per Sospensione dentale.<br>
     */
    public static final String DENTAL_SUSPENSION_CODE = "10407000";

    /**
     * EN: Code for Denture lacquer.<br>
     * DE: Code für Lack für die Gebisskontaktfläche.<br>
     * FR: Code de Laque dentaire.<br>
     * IT: Code per Smalto dentale.<br>
     */
    public static final String DENTURE_LACQUER_CODE = "12101000";

    /**
     * EN: Code for Dispersible tablet.<br>
     * DE: Code für Tablette zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Comprimé dispersible.<br>
     * IT: Code per Compressa dispersibile.<br>
     */
    public static final String DISPERSIBLE_TABLET_CODE = "10121000";

    /**
     * EN: Code for Dispersible tablets for dose dispenser.<br>
     * DE: Code für Tablette zur Herstellung einer Suspension zum Einnehmen für ein Dosiergerät.<br>
     * FR: Code de Comprimés dispersibles pour dispensateur de dose.<br>
     * IT: Code per Compresse dispersibili per dispensatore di dose.<br>
     */
    public static final String DISPERSIBLE_TABLETS_FOR_DOSE_DISPENSER_CODE = "10121500";

    /**
     * EN: Code for Dispersion for concentrate for dispersion for infusion.<br>
     * DE: Code für Dispersion für ein Konzentrat zur Herstellung einer Infusionsdispersion.<br>
     * FR: Code de Dispersion pour dispersion à diluer pour perfusion.<br>
     * IT: Code per Dispersione per concentrato per dispersione per infusione.<br>
     */
    public static final String DISPERSION_FOR_CONCENTRATE_FOR_DISPERSION_FOR_INFUSION_CODE = "13005000";

    /**
     * EN: Code for Dispersion for infusion.<br>
     * DE: Code für Infusionsdispersion.<br>
     * FR: Code de Dispersion pour perfusion.<br>
     * IT: Code per Dispersione per infusione.<br>
     */
    public static final String DISPERSION_FOR_INFUSION_CODE = "50017500";

    /**
     * EN: Code for Dispersion for injection.<br>
     * DE: Code für Injektionsdispersion.<br>
     * FR: Code de Dispersion injectable.<br>
     * IT: Code per Dispersione per preparazione iniettabile.<br>
     */
    public static final String DISPERSION_FOR_INJECTION_CODE = "50077000";

    /**
     * EN: Code for Dispersion for injection/infusion.<br>
     * DE: Code für Dispersion zur Injektion /Infusion.<br>
     * FR: Code de Dispersion injectable/ pour perfusion.<br>
     * IT: Code per Dispersione iniettabile/per infusione.<br>
     */
    public static final String DISPERSION_FOR_INJECTION_INFUSION_CODE = "13049000";

    /**
     * EN: Code for Ear cream.<br>
     * DE: Code für Ohrencreme.<br>
     * FR: Code de Crème auriculaire.<br>
     * IT: Code per Crema auricolare.<br>
     */
    public static final String EAR_CREAM_CODE = "10701000";

    /**
     * EN: Code for Ear drops, emulsion.<br>
     * DE: Code für Ohrentropfen, Emulsion.<br>
     * FR: Code de Emulsion auriculaire en gouttes.<br>
     * IT: Code per Gocce auricolari, emulsione.<br>
     */
    public static final String EAR_DROPS_EMULSION_CODE = "10706000";

    /**
     * EN: Code for Ear drops, powder for suspension.<br>
     * DE: Code für Pulver zur Herstellung einer Ohrentropfensuspension.<br>
     * FR: Code de Poudre pour suspension auriculaire en gouttes.<br>
     * IT: Code per Gocce auricolari, polvere per sospensione.<br>
     */
    public static final String EAR_DROPS_POWDER_FOR_SUSPENSION_CODE = "13006000";

    /**
     * EN: Code for Ear drops, solution.<br>
     * DE: Code für Ohrentropfen, Lösung.<br>
     * FR: Code de Solution auriculaire en gouttes.<br>
     * IT: Code per Gocce auricolari, soluzione.<br>
     */
    public static final String EAR_DROPS_SOLUTION_CODE = "10704000";

    /**
     * EN: Code for Ear drops, suspension.<br>
     * DE: Code für Ohrentropfen, Suspension.<br>
     * FR: Code de Suspension auriculaire en gouttes.<br>
     * IT: Code per Gocce auricolari, sospensione.<br>
     */
    public static final String EAR_DROPS_SUSPENSION_CODE = "10705000";

    /**
     * EN: Code for Ear/eye drops, solution.<br>
     * DE: Code für Augen-/Ohrentropfen, Lösung.<br>
     * FR: Code de Solution auriculaire/ophtalmique en gouttes.<br>
     * IT: Code per Gocce auricolari/collirio, soluzione.<br>
     */
    public static final String EAR_EYE_DROPS_SOLUTION_CODE = "50018000";

    /**
     * EN: Code for Ear/eye drops, suspension.<br>
     * DE: Code für Augen-/Ohrentropfen, Suspension.<br>
     * FR: Code de -.<br>
     * IT: Code per Gocce auricolari/collirio, sospensione.<br>
     */
    public static final String EAR_EYE_DROPS_SUSPENSION_CODE = "50018500";

    /**
     * EN: Code for Ear/eye/nasal drops, solution.<br>
     * DE: Code für Augen-/Ohren-/Nasentropfen, Lösung.<br>
     * FR: Code de Solution auriculaire/ ophtalmique/ nasale en gouttes.<br>
     * IT: Code per Gocce auricolari/collirio/gocce nasali, soluzione.<br>
     */
    public static final String EAR_EYE_NASAL_DROPS_SOLUTION_CODE = "50019500";

    /**
     * EN: Code for Ear/eye ointment.<br>
     * DE: Code für Augen-/Ohrensalbe.<br>
     * FR: Code de Pommade auriculaire/ ophtalmique.<br>
     * IT: Code per Unguento auricolare/oftalmico.<br>
     */
    public static final String EAR_EYE_OINTMENT_CODE = "50019000";

    /**
     * EN: Code for Ear gel.<br>
     * DE: Code für Ohrengel.<br>
     * FR: Code de Gel auriculaire.<br>
     * IT: Code per Gel auricolare.<br>
     */
    public static final String EAR_GEL_CODE = "10702000";

    /**
     * EN: Code for Ear/nasal drops, suspension.<br>
     * DE: Code für Augen-/Nasentropfen, Suspension.<br>
     * FR: Code de Suspension auriculaire/nasale en gouttes.<br>
     * IT: Code per Gocce auricolari/nasali, sospensione.<br>
     */
    public static final String EAR_NASAL_DROPS_SUSPENSION_CODE = "50020200";

    /**
     * EN: Code for Ear ointment.<br>
     * DE: Code für Ohrensalbe.<br>
     * FR: Code de Pommade auriculaire.<br>
     * IT: Code per Unguento auricolare.<br>
     */
    public static final String EAR_OINTMENT_CODE = "10703000";

    /**
     * EN: Code for Ear powder.<br>
     * DE: Code für Ohrenpulver.<br>
     * FR: Code de Poudre auriculaire.<br>
     * IT: Code per Polvere auricolare.<br>
     */
    public static final String EAR_POWDER_CODE = "10708000";

    /**
     * EN: Code for Ear spray, emulsion.<br>
     * DE: Code für Ohrenspray, Emulsion.<br>
     * FR: Code de Emulsion pour pulvérisation auriculaire.<br>
     * IT: Code per Spray auricolare, emulsione.<br>
     */
    public static final String EAR_SPRAY_EMULSION_CODE = "10711000";

    /**
     * EN: Code for Ear spray, solution.<br>
     * DE: Code für Ohrenspray, Lösung.<br>
     * FR: Code de Solution pour pulvérisation auriculaire.<br>
     * IT: Code per Spray auricolare, soluzione.<br>
     */
    public static final String EAR_SPRAY_SOLUTION_CODE = "10709000";

    /**
     * EN: Code for Ear spray, suspension.<br>
     * DE: Code für Ohrenspray, Suspension.<br>
     * FR: Code de Suspension pour pulvérisation auriculaire.<br>
     * IT: Code per Spray auricolare, sospensione.<br>
     */
    public static final String EAR_SPRAY_SUSPENSION_CODE = "10710000";

    /**
     * EN: Code for Ear stick.<br>
     * DE: Code für Ohrenstäbchen.<br>
     * FR: Code de Bâton pour usage auriculaire.<br>
     * IT: Code per Bastoncino auricolare.<br>
     */
    public static final String EAR_STICK_CODE = "10715000";

    /**
     * EN: Code for Ear tampon.<br>
     * DE: Code für Ohrentampon.<br>
     * FR: Code de Tampon auriculaire.<br>
     * IT: Code per Tampone auricolare.<br>
     */
    public static final String EAR_TAMPON_CODE = "10714000";

    /**
     * EN: Code for Ear wash, emulsion.<br>
     * DE: Code für Ohrenspülung, Emulsion.<br>
     * FR: Code de Emulsion pour lavage auriculaire.<br>
     * IT: Code per Lavaggio auricolare, emulsione.<br>
     */
    public static final String EAR_WASH_EMULSION_CODE = "10713000";

    /**
     * EN: Code for Ear wash, solution.<br>
     * DE: Code für Ohrenspüllösung.<br>
     * FR: Code de Solution pour lavage auriculaire.<br>
     * IT: Code per Lavaggio auricolare, soluzione.<br>
     */
    public static final String EAR_WASH_SOLUTION_CODE = "10712000";

    /**
     * EN: Code for Effervescent granules.<br>
     * DE: Code für Brausegranulat.<br>
     * FR: Code de Granulés effervescents.<br>
     * IT: Code per Granulato effervescente.<br>
     */
    public static final String EFFERVESCENT_GRANULES_CODE = "10205000";

    /**
     * EN: Code for Effervescent granules for oral suspension.<br>
     * DE: Code für Brausegranulat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Granulés effervescents pour suspension buvable.<br>
     * IT: Code per Granulato effervescente per sospensione orale.<br>
     */
    public static final String EFFERVESCENT_GRANULES_FOR_ORAL_SUSPENSION_CODE = "13007000";

    /**
     * EN: Code for Effervescent powder.<br>
     * DE: Code für Brausepulver.<br>
     * FR: Code de Poudre effervescente.<br>
     * IT: Code per Polvere effervescente.<br>
     */
    public static final String EFFERVESCENT_POWDER_CODE = "10203000";

    /**
     * EN: Code for Effervescent tablet.<br>
     * DE: Code für Brausetablette.<br>
     * FR: Code de Comprimé effervescent.<br>
     * IT: Code per Compressa effervescente.<br>
     */
    public static final String EFFERVESCENT_TABLET_CODE = "10222000";

    /**
     * EN: Code for Effervescent vaginal tablet.<br>
     * DE: Code für Schaumovula.<br>
     * FR: Code de Comprimé vaginal effervescent.<br>
     * IT: Code per Compressa effervescente vaginale.<br>
     */
    public static final String EFFERVESCENT_VAGINAL_TABLET_CODE = "10913000";

    /**
     * EN: Code for Emulsion for emulsion for injection.<br>
     * DE: Code für Emulsion zur Herstellung einer Emulsion zur Injektion.<br>
     * FR: Code de Emulsion pour émulsion injectable.<br>
     * IT: Code per Emulsione per emulsione iniettabile.<br>
     */
    public static final String EMULSION_FOR_EMULSION_FOR_INJECTION_CODE = "13008000";

    /**
     * EN: Code for Emulsion for infusion.<br>
     * DE: Code für Emulsion zur Infusion.<br>
     * FR: Code de Emulsion pour perfusion.<br>
     * IT: Code per Emulsione per infusione.<br>
     */
    public static final String EMULSION_FOR_INFUSION_CODE = "11211000";

    /**
     * EN: Code for Emulsion for injection.<br>
     * DE: Code für Emulsion zur Injektion.<br>
     * FR: Code de Emulsion injectable.<br>
     * IT: Code per Emuslione iniettabile.<br>
     */
    public static final String EMULSION_FOR_INJECTION_CODE = "11203000";

    /**
     * EN: Code for Emulsion for injection/infusion.<br>
     * DE: Code für Emulsion zur Injektion/Infusion.<br>
     * FR: Code de Émulsion injectable/pour perfusion.<br>
     * IT: Code per Emulsione iniettabile/per infusione.<br>
     */
    public static final String EMULSION_FOR_INJECTION_INFUSION_CODE = "50021000";

    /**
     * EN: Code for Emulsion for suspension for injection.<br>
     * DE: Code für Emulsion zur Herstellung einer Injektionssuspension.<br>
     * FR: Code de Emulsion pour suspension injectable.<br>
     * IT: Code per Emulsione per sospensione iniettabile.<br>
     */
    public static final String EMULSION_FOR_SUSPENSION_FOR_INJECTION_CODE = "13091000";

    /**
     * EN: Code for Endocervical gel.<br>
     * DE: Code für Gel zur endozervikalen Anwendung.<br>
     * FR: Code de Gel endocervical.<br>
     * IT: Code per Gel endocervicale.<br>
     */
    public static final String ENDOCERVICAL_GEL_CODE = "11701000";

    /**
     * EN: Code for Endosinusial solution.<br>
     * DE: Code für Lösung zur Anwendung in den Nebenhöhlen.<br>
     * FR: Code de Solution endosinusale.<br>
     * IT: Code per Soluzione endosinusale.<br>
     */
    public static final String ENDOSINUSIAL_SOLUTION_CODE = "13041000";

    /**
     * EN: Code for Endosinusial wash, suspension.<br>
     * DE: Code für Nebenhöhlenspülung, Suspension.<br>
     * FR: Code de Suspension pour lavage endosinusal.<br>
     * IT: Code per Lavaggio endosinusale, sospensione.<br>
     */
    public static final String ENDOSINUSIAL_WASH_SUSPENSION_CODE = "50022000";

    /**
     * EN: Code for Endotracheopulmonary instillation, powder for solution.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zur endotracheopulmonalen Instillation.<br>
     * FR: Code de Poudre pour solution pour instillation endotrachéobronchique.<br>
     * IT: Code per Polvere per soluzione per instillazione endotracheobronchiale.<br>
     */
    public static final String ENDOTRACHEOPULMONARY_INSTILLATION_POWDER_FOR_SOLUTION_CODE = "11602000";

    /**
     * EN: Code for Endotracheopulmonary instillation, powder for suspension.<br>
     * DE: Code für Pulver zu Herstellung einer Suspension zur endotracheopulmonalen Instillation.<br>
     * FR: Code de Poudre pour suspension pour instillation endotrachéobronchique.<br>
     * IT: Code per Instillazione endotracheobronchiale, polvere per sospensione.<br>
     */
    public static final String ENDOTRACHEOPULMONARY_INSTILLATION_POWDER_FOR_SUSPENSION_CODE = "13009000";

    /**
     * EN: Code for Endotracheopulmonary instillation, solution.<br>
     * DE: Code für Lösung zur endotracheopulmonalen Instillation.<br>
     * FR: Code de Solution pour instillation endotrachéobronchique.<br>
     * IT: Code per Soluzione per instillazione endotracheobronchiale.<br>
     */
    public static final String ENDOTRACHEOPULMONARY_INSTILLATION_SOLUTION_CODE = "11601000";

    /**
     * EN: Code for Endotracheopulmonary instillation, suspension.<br>
     * DE: Code für Suspension zur endotracheopulmonalen Instillation.<br>
     * FR: Code de Suspension pour instillation endotrachéobronchique.<br>
     * IT: Code per Sospensione per instillazione endotracheobronchiale.<br>
     */
    public static final String ENDOTRACHEOPULMONARY_INSTILLATION_SUSPENSION_CODE = "11603000";

    /**
     * EN: Code for Epilesional solution.<br>
     * DE: Code für Lösung zum Auftragen auf die Haut.<br>
     * FR: Code de Solution épilésionnelle.<br>
     * IT: Code per Soluzione epilesionale.<br>
     */
    public static final String EPILESIONAL_SOLUTION_CODE = "13042000";

    /**
     * EN: Code for Eye cream.<br>
     * DE: Code für Augencreme.<br>
     * FR: Code de Crème ophtalmique.<br>
     * IT: Code per Crema oftalmica.<br>
     */
    public static final String EYE_CREAM_CODE = "10601000";

    /**
     * EN: Code for Eye drops, emulsion.<br>
     * DE: Code für Augentropfen, Emulsion.<br>
     * FR: Code de Collyre en émulsion.<br>
     * IT: Code per Collirio, emulsione.<br>
     */
    public static final String EYE_DROPS_EMULSION_CODE = "10604500";

    /**
     * EN: Code for Eye drops, powder for solution.<br>
     * DE: Code für Pulver zur Herstellung von Augentropfen, Lösung.<br>
     * FR: Code de Poudre pour solution ophtalmique en gouttes.<br>
     * IT: Code per Collirio, polvere per soluzione.<br>
     */
    public static final String EYE_DROPS_POWDER_FOR_SOLUTION_CODE = "13010000";

    /**
     * EN: Code for Eye drops, powder for suspension.<br>
     * DE: Code für Pulver zur Herstellung einer Augentropfensuspension.<br>
     * FR: Code de Poudre pour suspension ophtalmique en gouttes.<br>
     * IT: Code per Collirio, polvere per sospensione.<br>
     */
    public static final String EYE_DROPS_POWDER_FOR_SUSPENSION_CODE = "13011000";

    /**
     * EN: Code for Eye drops, prolonged-release.<br>
     * DE: Code für Augentropfen mit verlängerter Wirkungsdauer.<br>
     * FR: Code de Collyre à libération prolongée.<br>
     * IT: Code per Collirio a rilascio prolungato.<br>
     */
    public static final String EYE_DROPS_PROLONGED_RELEASE_CODE = "10609000";

    /**
     * EN: Code for Eye drops, solution.<br>
     * DE: Code für Augentropfen, Lösung.<br>
     * FR: Code de Collyre en solution.<br>
     * IT: Code per Collirio, soluzione.<br>
     */
    public static final String EYE_DROPS_SOLUTION_CODE = "10604000";

    /**
     * EN: Code for Eye drops, solvent for reconstitution.<br>
     * DE: Code für Lösungsmittel zur Herstellung von Augentropfen.<br>
     * FR: Code de Solvant pour collyre.<br>
     * IT: Code per Solvente per collirio.<br>
     */
    public static final String EYE_DROPS_SOLVENT_FOR_RECONSTITUTION_CODE = "10608000";

    /**
     * EN: Code for Eye drops, suspension.<br>
     * DE: Code für Augentropfensuspension.<br>
     * FR: Code de Collyre en suspension.<br>
     * IT: Code per Collirio, sospensione.<br>
     */
    public static final String EYE_DROPS_SUSPENSION_CODE = "10605000";

    /**
     * EN: Code for Eye gel.<br>
     * DE: Code für Augengel.<br>
     * FR: Code de Gel ophtalmique.<br>
     * IT: Code per Gel oftalmico.<br>
     */
    public static final String EYE_GEL_CODE = "10602000";

    /**
     * EN: Code for Eye lotion.<br>
     * DE: Code für Augenbad.<br>
     * FR: Code de Solution pour lavage ophtalmique.<br>
     * IT: Code per Bagno oculare.<br>
     */
    public static final String EYE_LOTION_CODE = "10610000";

    /**
     * EN: Code for Eye lotion, solvent for reconstitution.<br>
     * DE: Code für Lösungsmittel zur Herstellung eines Augenbades.<br>
     * FR: Code de Solvant pour solution pour lavage ophtalmique.<br>
     * IT: Code per Solvente per bagno oculare.<br>
     */
    public static final String EYE_LOTION_SOLVENT_FOR_RECONSTITUTION_CODE = "10611000";

    /**
     * EN: Code for Eye ointment.<br>
     * DE: Code für Augensalbe.<br>
     * FR: Code de Pommade ophtalmique.<br>
     * IT: Code per Unguento oftalmico.<br>
     */
    public static final String EYE_OINTMENT_CODE = "10603000";

    /**
     * EN: Code for Film-coated tablet.<br>
     * DE: Code für Filmtablette.<br>
     * FR: Code de Comprimé pelliculé.<br>
     * IT: Code per Compressa rivestita con film.<br>
     */
    public static final String FILM_COATED_TABLET_CODE = "10221000";

    /**
     * EN: Code for Gargle.<br>
     * DE: Code für Gurgellösung.<br>
     * FR: Code de Solution pour gargarisme.<br>
     * IT: Code per Soluzione per gargarismi.<br>
     */
    public static final String GARGLE_CODE = "10301000";

    /**
     * EN: Code for Gargle/mouthwash.<br>
     * DE: Code für Gurgellösung/Mundspülung.<br>
     * FR: Code de Solution pour gargarisme/bain de bouche.<br>
     * IT: Code per Soluzione per gargarismi/collutorio.<br>
     */
    public static final String GARGLE_MOUTHWASH_CODE = "50024000";

    /**
     * EN: Code for Gargle/nasal wash.<br>
     * DE: Code für Gurgellösung/Nasenspülung.<br>
     * FR: Code de Solution pour gargarisme/ nasale.<br>
     * IT: Code per Soluzione per gargarismi/lavaggio nasale.<br>
     */
    public static final String GARGLE_NASAL_WASH_CODE = "50024500";

    /**
     * EN: Code for Gargle, powder for solution.<br>
     * DE: Code für Pulver zur Herstellung einer Gurgellösung.<br>
     * FR: Code de Poudre pour solution pour gargarisme.<br>
     * IT: Code per Polvere per soluzione per gargarismi.<br>
     */
    public static final String GARGLE_POWDER_FOR_SOLUTION_CODE = "10303000";

    /**
     * EN: Code for Gargle, tablet for solution.<br>
     * DE: Code für Tablette zur Herstellung einer Gurgellösung.<br>
     * FR: Code de Comprimé pour solution pour gargarisme.<br>
     * IT: Code per Compressa per soluzione per gargarismi.<br>
     */
    public static final String GARGLE_TABLET_FOR_SOLUTION_CODE = "10304000";

    /**
     * EN: Code for Gastroenteral emulsion.<br>
     * DE: Code für Emulsion zur gastrointestinalen Anwendung.<br>
     * FR: Code de Emulsion gastroentérale.<br>
     * IT: Code per Emulsione gastroenterica.<br>
     */
    public static final String GASTROENTERAL_EMULSION_CODE = "12111000";

    /**
     * EN: Code for Gastroenteral solution.<br>
     * DE: Code für Lösung zur gastrointestinalen Anwendung.<br>
     * FR: Code de Solution gastroentérale.<br>
     * IT: Code per Soluzione gastroenterica.<br>
     */
    public static final String GASTROENTERAL_SOLUTION_CODE = "12108000";

    /**
     * EN: Code for Gastroenteral suspension.<br>
     * DE: Code für Suspension zur gastrointestinalen Anwendung.<br>
     * FR: Code de Suspension gastroentérale.<br>
     * IT: Code per Sospensione gastroenterica.<br>
     */
    public static final String GASTROENTERAL_SUSPENSION_CODE = "12110000";

    /**
     * EN: Code for Gastro-resistant capsule, hard.<br>
     * DE: Code für magensaftresistente Hartkapsel.<br>
     * FR: Code de Gélule gastrorésistante.<br>
     * IT: Code per Capsula rigida gastroresistente.<br>
     */
    public static final String GASTRO_RESISTANT_CAPSULE_HARD_CODE = "10212000";

    /**
     * EN: Code for Gastro-resistant capsule, soft.<br>
     * DE: Code für magensaftresistente Weichkapsel.<br>
     * FR: Code de Capsule molle gastrorésistante.<br>
     * IT: Code per Capsula molle gastroresistente.<br>
     */
    public static final String GASTRO_RESISTANT_CAPSULE_SOFT_CODE = "10213000";

    /**
     * EN: Code for Gastro-resistant granules.<br>
     * DE: Code für magensaftresistentes Granulat.<br>
     * FR: Code de Granulés gastrorésistants.<br>
     * IT: Code per Granulato gastroresistente.<br>
     */
    public static final String GASTRO_RESISTANT_GRANULES_CODE = "10206000";

    /**
     * EN: Code for Gastro-resistant granules for oral suspension.<br>
     * DE: Code für magensaftresistentes Granulat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Granulés gastrorésistants pour suspension buvable.<br>
     * IT: Code per Granulato gastroresistente per sospensione orale.<br>
     */
    public static final String GASTRO_RESISTANT_GRANULES_FOR_ORAL_SUSPENSION_CODE = "50026000";

    /**
     * EN: Code for Gastro-resistant oral suspension.<br>
     * DE: Code für Magensaftresistente Suspension zum Einnehmen.<br>
     * FR: Code de Solution à libération prolongée intralésionnelle.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String GASTRO_RESISTANT_ORAL_SUSPENSION_CODE = "13133000";

    /**
     * EN: Code for Gastro-resistant powder for oral suspension.<br>
     * DE: Code für Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Solution à libération prolongée intralésionnelle.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String GASTRO_RESISTANT_POWDER_FOR_ORAL_SUSPENSION_CODE = "13136000";

    /**
     * EN: Code for Gastro-resistant tablet.<br>
     * DE: Code für magensaftresistente Tablette.<br>
     * FR: Code de Comprimé gastrorésistant.<br>
     * IT: Code per Compressa gastroresistente.<br>
     */
    public static final String GASTRO_RESISTANT_TABLET_CODE = "10225000";

    /**
     * EN: Code for Gas for dispersion for infusion.<br>
     * DE: Code für Gas zur Herstellung einer Infusionsdispersion.<br>
     * FR: Code de Gaz pour dispersion pour perfusion.<br>
     * IT: Code per Gas per dispersione per infusione.<br>
     */
    public static final String GAS_FOR_DISPERSION_FOR_INFUSION_CODE = "13012000";

    /**
     * EN: Code for Gas for dispersion for injection.<br>
     * DE: Code für Gas zur Herstellung einer Injektionsdispersion.<br>
     * FR: Code de Gaz pour dispersion injectable.<br>
     * IT: Code per Gas per dispersione iniettabile.<br>
     */
    public static final String GAS_FOR_DISPERSION_FOR_INJECTION_CODE = "13013000";

    /**
     * EN: Code for Gas for dispersion for injection/infusion.<br>
     * DE: Code für Gas zur Herstellung einer Injektions-/Infusionsdispersion.<br>
     * FR: Code de Gaz pour dispersion injectable/ pour perfusion.<br>
     * IT: Code per Gas per dispersione iniettabile/per infusione.<br>
     */
    public static final String GAS_FOR_DISPERSION_FOR_INJECTION_INFUSION_CODE = "13050000";

    /**
     * EN: Code for Gel.<br>
     * DE: Code für Gel.<br>
     * FR: Code de Gel.<br>
     * IT: Code per Gel.<br>
     */
    public static final String GEL_CODE = "10503000";

    /**
     * EN: Code for Gel for gel.<br>
     * DE: Code für Gel zur Herstellung eines Gels.<br>
     * FR: Code de Gel pour gel.<br>
     * IT: Code per Gel per gel.<br>
     */
    public static final String GEL_FOR_GEL_CODE = "13014000";

    /**
     * EN: Code for Gel for injection.<br>
     * DE: Code für Gel zur Injektion.<br>
     * FR: Code de Gel injectable.<br>
     * IT: Code per Gel iniettabile.<br>
     */
    public static final String GEL_FOR_INJECTION_CODE = "11204000";

    /**
     * EN: Code for Gingival gel.<br>
     * DE: Code für Gel zur Anwendung am Zahnfleisch.<br>
     * FR: Code de Gel gingival.<br>
     * IT: Code per Gel gengivale.<br>
     */
    public static final String GINGIVAL_GEL_CODE = "10315000";

    /**
     * EN: Code for Gingival paste.<br>
     * DE: Code für Paste zur Anwendung am Zahnfleisch.<br>
     * FR: Code de Pâte gingivale.<br>
     * IT: Code per Pasta gengivale.<br>
     */
    public static final String GINGIVAL_PASTE_CODE = "10316000";

    /**
     * EN: Code for Gingival solution.<br>
     * DE: Code für Lösung zur Anwendung am Zahnfleisch.<br>
     * FR: Code de Solution gingivale.<br>
     * IT: Code per Soluzione gengivale.<br>
     */
    public static final String GINGIVAL_SOLUTION_CODE = "10312000";

    /**
     * EN: Code for Granules.<br>
     * DE: Code für Granulat.<br>
     * FR: Code de Granulés.<br>
     * IT: Code per Granulato.<br>
     */
    public static final String GRANULES_CODE = "10204000";

    /**
     * EN: Code for Granules for oral/rectal suspension.<br>
     * DE: Code für Granulat zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension.<br>
     * FR: Code de Granulés pour suspension buvable/rectale.<br>
     * IT: Code per Granulato per sospensione orale/rettale.<br>
     */
    public static final String GRANULES_FOR_ORAL_RECTAL_SUSPENSION_CODE = "50029150";

    /**
     * EN: Code for Granules for oral solution.<br>
     * DE: Code für Granulat zur Herstellung einer Lösung zum Einnehmen.<br>
     * FR: Code de Granulés pour solution buvable.<br>
     * IT: Code per Granulato per soluzione orale.<br>
     */
    public static final String GRANULES_FOR_ORAL_SOLUTION_CODE = "10112000";

    /**
     * EN: Code for Granules for oral suspension.<br>
     * DE: Code für Granulat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Granulés pour suspension buvable.<br>
     * IT: Code per Granulato per sospensione orale.<br>
     */
    public static final String GRANULES_FOR_ORAL_SUSPENSION_CODE = "10113000";

    /**
     * EN: Code for Granules for rectal suspension.<br>
     * DE: Code für Granulat zur Herstellung einer Rektalsuspension.<br>
     * FR: Code de Granulés pour suspension rectale.<br>
     * IT: Code per Granulato per sospensione rettale.<br>
     */
    public static final String GRANULES_FOR_RECTAL_SUSPENSION_CODE = "13015000";

    /**
     * EN: Code for Granules for suspension for injection.<br>
     * DE: Code für Granulat zur Herstellung einer Injektionssuspension.<br>
     * FR: Code de Granulés pour suspension injectable.<br>
     * IT: Code per Granulato per sospensione iniettabile.<br>
     */
    public static final String GRANULES_FOR_SUSPENSION_FOR_INJECTION_CODE = "13048000";

    /**
     * EN: Code for Granules for syrup.<br>
     * DE: Code für Granulat zur Herstellung eines Sirups.<br>
     * FR: Code de Granulés pour sirop.<br>
     * IT: Code per Granulato per sciroppo.<br>
     */
    public static final String GRANULES_FOR_SYRUP_CODE = "10119000";

    /**
     * EN: Code for Granules for vaginal solution.<br>
     * DE: Code für Granulat zur Herstellung einer Vaginallösung.<br>
     * FR: Code de Granulés pour solution vaginale.<br>
     * IT: Code per Granulato per soluzione vaginale.<br>
     */
    public static final String GRANULES_FOR_VAGINAL_SOLUTION_CODE = "50029500";

    /**
     * EN: Code for Herbal tea.<br>
     * DE: Code für Arzneitee.<br>
     * FR: Code de Plante(s) pour tisane.<br>
     * IT: Code per Tisana.<br>
     */
    public static final String HERBAL_TEA_CODE = "10122000";

    /**
     * EN: Code for Implant.<br>
     * DE: Code für Implantat.<br>
     * FR: Code de Implant.<br>
     * IT: Code per Impianto.<br>
     */
    public static final String IMPLANT_CODE = "11301000";

    /**
     * EN: Code for Implantation chain.<br>
     * DE: Code für Kette zur Implantation.<br>
     * FR: Code de Implant en chaîne.<br>
     * IT: Code per Catenella per impianto.<br>
     */
    public static final String IMPLANTATION_CHAIN_CODE = "11303000";

    /**
     * EN: Code for Implantation matrix.<br>
     * DE: Code für Matrix zur Implantation.<br>
     * FR: Code de Matrice pour implantation.<br>
     * IT: Code per Catenella per impianto.<br>
     */
    public static final String IMPLANTATION_MATRIX_CODE = "11303300";

    /**
     * EN: Code for Implantation paste.<br>
     * DE: Code für Paste für Implantate.<br>
     * FR: Code de Pâte pour implantation.<br>
     * IT: Code per Soluzione epilesionale.<br>
     */
    public static final String IMPLANTATION_PASTE_CODE = "13043000";

    /**
     * EN: Code for Implantation suspension.<br>
     * DE: Code für Suspension zur Implantation.<br>
     * FR: Code de Suspension pour implantation.<br>
     * IT: Code per Catenella per impianto.<br>
     */
    public static final String IMPLANTATION_SUSPENSION_CODE = "11303500";

    /**
     * EN: Code for Implantation tablet.<br>
     * DE: Code für Tablette zur Implantation.<br>
     * FR: Code de Comprimé pour implantation.<br>
     * IT: Code per Compressa per impianto.<br>
     */
    public static final String IMPLANTATION_TABLET_CODE = "11302000";

    /**
     * EN: Code for Impregnated dressing.<br>
     * DE: Code für imprägnierter Verband.<br>
     * FR: Code de Compresse imprégnée.<br>
     * IT: Code per Garza impregnata.<br>
     */
    public static final String IMPREGNATED_DRESSING_CODE = "10525000";

    /**
     * EN: Code for Impregnated pad.<br>
     * DE: Code für Imprägnierter Tampon.<br>
     * FR: Code de Tampon imprégné.<br>
     * IT: Code per Tampone medicato.<br>
     */
    public static final String IMPREGNATED_PAD_CODE = "12117000";

    /**
     * EN: Code for Impregnated plug.<br>
     * DE: Code für Imprägnierter Einsatz.<br>
     * FR: Code de Support poreux imprégné.<br>
     * IT: Code per Supporto medicato.<br>
     */
    public static final String IMPREGNATED_PLUG_CODE = "12117500";

    /**
     * EN: Code for Inhalation powder.<br>
     * DE: Code für Pulver zur Inhalation.<br>
     * FR: Code de Poudre pour inhalation.<br>
     * IT: Code per Polvere per inalazione.<br>
     */
    public static final String INHALATION_POWDER_CODE = "11109000";

    /**
     * EN: Code for Inhalation powder, hard capsule.<br>
     * DE: Code für Hartkapsel mit Pulver zur Inhalation.<br>
     * FR: Code de Poudre pour inhalation en gélule.<br>
     * IT: Code per Polvere per inalazione, capsula rigida.<br>
     */
    public static final String INHALATION_POWDER_HARD_CAPSULE_CODE = "11110000";

    /**
     * EN: Code for Inhalation powder, pre-dispensed.<br>
     * DE: Code für einzeldosiertes Pulver zur Inhalation.<br>
     * FR: Code de Poudre pour inhalation en récipient unidose.<br>
     * IT: Code per Polvere per inalazione, pre-dosata.<br>
     */
    public static final String INHALATION_POWDER_PRE_DISPENSED_CODE = "11111000";

    /**
     * EN: Code for Inhalation powder, tablet.<br>
     * DE: Code für Tablette mit Pulver zur Inhalation.<br>
     * FR: Code de Comprimé pour inhalation par poudre.<br>
     * IT: Code per Polvere per inalazione, compressa.<br>
     */
    public static final String INHALATION_POWDER_TABLET_CODE = "50030000";

    /**
     * EN: Code for Inhalation solution.<br>
     * DE: Code für Lösung zur Inhalation.<br>
     * FR: Code de Solution à inhaler.<br>
     * IT: Code per Soluzione per inalazione.<br>
     */
    public static final String INHALATION_SOLUTION_CODE = "50081000";

    /**
     * EN: Code for Inhalation vapour, capsule.<br>
     * DE: Code für Kapsel zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Code de Capsule pour inhalation par vapeur.<br>
     * IT: Code per Capsula per suffumigi.<br>
     */
    public static final String INHALATION_VAPOUR_CAPSULE_CODE = "11113000";

    /**
     * EN: Code for Inhalation vapour, effervescent tablet.<br>
     * DE: Code für Brausetablette zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Code de Comprimé effervescent pour inhalation par vapeur.<br>
     * IT: Code per Vapore  per inalazione, compressa effervescente.<br>
     */
    public static final String INHALATION_VAPOUR_EFFERVESCENT_TABLET_CODE = "50031000";

    /**
     * EN: Code for Inhalation vapour, emulsion.<br>
     * DE: Code für Emulsion zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Code de Emulsion pour inhalation par vapeur.<br>
     * IT: Code per Vapore per inalazione, emulsione.<br>
     */
    public static final String INHALATION_VAPOUR_EMULSION_CODE = "50032000";

    /**
     * EN: Code for Inhalation vapour, impregnated pad.<br>
     * DE: Code für Dampf zur Inhalation, imprägnierter Einsatz.<br>
     * FR: Code de Tampon imprégné pour inhalation par vapeur.<br>
     * IT: Code per Vapore per inalazione, tampone medicato.<br>
     */
    public static final String INHALATION_VAPOUR_IMPREGNATED_PAD_CODE = "50033000";

    /**
     * EN: Code for Inhalation vapour, impregnated plug.<br>
     * DE: Code für Dampf zur Inhalation, imprägnierter Einsatz.<br>
     * FR: Code de Support poreux imprégné pour inhalation par vapeur.<br>
     * IT: Code per Vapore per inalazione, supporto medicato.<br>
     */
    public static final String INHALATION_VAPOUR_IMPREGNATED_PLUG_CODE = "50033100";

    /**
     * EN: Code for Inhalation vapour, liquid.<br>
     * DE: Code für Flüssigkeit zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Code de Liquide pour inhalation par vapeur.<br>
     * IT: Code per Liquido per  suffumigi.<br>
     */
    public static final String INHALATION_VAPOUR_LIQUID_CODE = "11117000";

    /**
     * EN: Code for Inhalation vapour, ointment.<br>
     * DE: Code für Salbe zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Code de Pommade pour inhalation par vapeur.<br>
     * IT: Code per Unguento per suffumigi.<br>
     */
    public static final String INHALATION_VAPOUR_OINTMENT_CODE = "11116000";

    /**
     * EN: Code for Inhalation vapour, powder.<br>
     * DE: Code für Pulver zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Code de Poudre pour inhalation par vapeur.<br>
     * IT: Code per Polvere per suffumigi.<br>
     */
    public static final String INHALATION_VAPOUR_POWDER_CODE = "11112000";

    /**
     * EN: Code for Inhalation vapour, solution.<br>
     * DE: Code für Lösung zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Code de Solution pour inhalation par vapeur.<br>
     * IT: Code per Soluzione per  suffumigi.<br>
     */
    public static final String INHALATION_VAPOUR_SOLUTION_CODE = "11114000";

    /**
     * EN: Code for Inhalation vapour, tablet.<br>
     * DE: Code für Tablette zur Herstellung eines Dampfs zur Inhalation.<br>
     * FR: Code de Comprimé pour inhalation par vapeur.<br>
     * IT: Code per Compressa per  suffumigi.<br>
     */
    public static final String INHALATION_VAPOUR_TABLET_CODE = "11115000";

    /**
     * EN: Code for Instant herbal tea.<br>
     * DE: Code für Teeaufgusspulver.<br>
     * FR: Code de Préparation instantanée pour tisane.<br>
     * IT: Code per Tisana, polvere solubile.<br>
     */
    public static final String INSTANT_HERBAL_TEA_CODE = "10202000";

    /**
     * EN: Code for Intestinal gel.<br>
     * DE: Code für Gel zur intestinalen Anwendung.<br>
     * FR: Code de Gel intestinal.<br>
     * IT: Code per Gel intestinale.<br>
     */
    public static final String INTESTINAL_GEL_CODE = "12120000";

    /**
     * EN: Code for Intraocular instillation solution.<br>
     * DE: Code für Lösung zur intraokularen Instillation.<br>
     * FR: Code de Solution pour instillation intraoculaire.<br>
     * IT: Code per Soluzione per instillazione intraoculare.<br>
     */
    public static final String INTRAOCULAR_INSTILLATION_SOLUTION_CODE = "13044000";

    /**
     * EN: Code for Intraperitoneal solution.<br>
     * DE: Code für Lösung zur intraperitonealen Awendung.<br>
     * FR: Code de Solution intrapéritonéale.<br>
     * IT: Code per Soluzione intraperitoneale.<br>
     */
    public static final String INTRAPERITONEAL_SOLUTION_CODE = "12111500";

    /**
     * EN: Code for Intrauterine delivery system.<br>
     * DE: Code für Intrauterines Wirkstofffreisetzungssystem.<br>
     * FR: Code de Système de diffusion intra-utérin.<br>
     * IT: Code per Sistema a rilascio intrauterino.<br>
     */
    public static final String INTRAUTERINE_DELIVERY_SYSTEM_CODE = "11901000";

    /**
     * EN: Code for Intrauterine gel.<br>
     * DE: Code für Gel zur intrauterinen Anwendung.<br>
     * FR: Code de Gel intra-utérin.<br>
     * IT: Code per Gel intrauterino.<br>
     */
    public static final String INTRAUTERINE_GEL_CODE = "13113000";

    /**
     * EN: Code for Intravesical solution.<br>
     * DE: Code für Lösung zur intravesikalen Anwendung.<br>
     * FR: Code de Solution intravésicale.<br>
     * IT: Code per Soluzione endovescicale.<br>
     */
    public static final String INTRAVESICAL_SOLUTION_CODE = "11502500";

    /**
     * EN: Code for Intravesical solution/solution for injection.<br>
     * DE: Code für Lösung zur intravesikalen Anwendung/Injektionslösung.<br>
     * FR: Code de Solution intravésicale/solution injectable.<br>
     * IT: Code per Soluzione endovescicale/soluzione iniettabile.<br>
     */
    public static final String INTRAVESICAL_SOLUTION_SOLUTION_FOR_INJECTION_CODE = "50033400";

    /**
     * EN: Code for Intravesical suspension.<br>
     * DE: Code für Suspension zur intravesikalen Anwendung.<br>
     * FR: Code de Suspension intravésicale.<br>
     * IT: Code per Sospensione endovescicale.<br>
     */
    public static final String INTRAVESICAL_SUSPENSION_CODE = "13045000";

    /**
     * EN: Code for Irrigation solution.<br>
     * DE: Code für Spüllösung.<br>
     * FR: Code de Solution pour irrigation.<br>
     * IT: Code per Soluzione per irrigazione.<br>
     */
    public static final String IRRIGATION_SOLUTION_CODE = "12113000";

    /**
     * EN: Code for Kit for radiopharmaceutical preparation.<br>
     * DE: Code für Kit für ein radioaktives Arzneimittel.<br>
     * FR: Code de Trousse pour préparation radiopharmaceutique.<br>
     * IT: Code per Kit per preparazione radiofarmaceutica.<br>
     */
    public static final String KIT_FOR_RADIOPHARMACEUTICAL_PREPARATION_CODE = "12107000";

    /**
     * EN: Code for Laryngopharyngeal solution.<br>
     * DE: Code für Lösung zur Anwendung im Rachenraum und am Kehlkopf.<br>
     * FR: Code de Solution laryngopharyngée.<br>
     * IT: Code per Soluzione laringofaringea.<br>
     */
    public static final String LARYNGOPHARYNGEAL_SOLUTION_CODE = "13016000";

    /**
     * EN: Code for Laryngopharyngeal spray, solution.<br>
     * DE: Code für Spray zur Anwendung im Rachenraum und am Kehlkopf, Lösung.<br>
     * FR: Code de Solution pour pulvérisation laryngopharyngée.<br>
     * IT: Code per Spray laringofaringeo, soluzione.<br>
     */
    public static final String LARYNGOPHARYNGEAL_SPRAY_SOLUTION_CODE = "13017000";

    /**
     * EN: Code for Living tissue equivalent.<br>
     * DE: Code für lebendes Gewebeäquivalent.<br>
     * FR: Code de Substitut de tissu vivant.<br>
     * IT: Code per Tessuto vivente da coltura di cellule.<br>
     */
    public static final String LIVING_TISSUE_EQUIVALENT_CODE = "12118000";

    /**
     * EN: Code for Lozenge.<br>
     * DE: Code für Lutschtablette.<br>
     * FR: Code de Pastille.<br>
     * IT: Code per Pastiglia.<br>
     */
    public static final String LOZENGE_CODE = "10321000";

    /**
     * EN: Code for Matrix for implantation matrix.<br>
     * DE: Code für Matrix für Matrix zur Implantation.<br>
     * FR: Code de Matrice pour matrice pour implantation.<br>
     * IT: Code per Spray laringofaringeo, soluzione.<br>
     */
    public static final String MATRIX_FOR_IMPLANTATION_MATRIX_CODE = "13018000";

    /**
     * EN: Code for Medicated chewing-gum.<br>
     * DE: Code für wirkstoffhaltiges Kaugummi.<br>
     * FR: Code de Gomme à mâcher médicamenteuse.<br>
     * IT: Code per Gomma da masticare medicata.<br>
     */
    public static final String MEDICATED_CHEWING_GUM_CODE = "10229000";

    /**
     * EN: Code for Medicated nail lacquer.<br>
     * DE: Code für wirkstoffhaltiger Nagellack.<br>
     * FR: Code de Vernis à ongles médicamenteux.<br>
     * IT: Code per Smalto medicato per unghie.<br>
     */
    public static final String MEDICATED_NAIL_LACQUER_CODE = "10521000";

    /**
     * EN: Code for Medicated plaster.<br>
     * DE: Code für wirkstoffhaltiges Pflaster.<br>
     * FR: Code de Emplâtre médicamenteux.<br>
     * IT: Code per Cerotto medicato.<br>
     */
    public static final String MEDICATED_PLASTER_CODE = "10506000";

    /**
     * EN: Code for Medicated sponge.<br>
     * DE: Code für wirkstoffhaltiges Schwämmchen.<br>
     * FR: Code de Eponge médicamenteuse.<br>
     * IT: Code per Spugna medicata.<br>
     */
    public static final String MEDICATED_SPONGE_CODE = "12119000";

    /**
     * EN: Code for Medicated thread.<br>
     * DE: Code für wirkstoffhaltiger Faden.<br>
     * FR: Code de Fils médicamenteux.<br>
     * IT: Code per Filo medicato.<br>
     */
    public static final String MEDICATED_THREAD_CODE = "12130000";

    /**
     * EN: Code for Medicated vaginal tampon.<br>
     * DE: Code für Wirkstoffhaltiger Vaginaltampon.<br>
     * FR: Code de Tampon vaginal médicamenteux.<br>
     * IT: Code per Tampone vaginale medicato.<br>
     */
    public static final String MEDICATED_VAGINAL_TAMPON_CODE = "10914000";

    /**
     * EN: Code for Medicinal gas, compressed.<br>
     * DE: Code für Gas zur medizinischen Anwendung, druckverdichtet.<br>
     * FR: Code de Gaz médicinal comprimé.<br>
     * IT: Code per Gas medicinale compresso.<br>
     */
    public static final String MEDICINAL_GAS_COMPRESSED_CODE = "12301000";

    /**
     * EN: Code for Medicinal gas, cryogenic.<br>
     * DE: Code für Gas zur medizinischen Anwendung, kälteverflüssigt.<br>
     * FR: Code de Gaz médicinal cryogénique.<br>
     * IT: Code per Gas medicinale criogenico.<br>
     */
    public static final String MEDICINAL_GAS_CRYOGENIC_CODE = "12302000";

    /**
     * EN: Code for Medicinal gas, liquefied.<br>
     * DE: Code für Gas zur medizinischen Anwendung, verflüssigt.<br>
     * FR: Code de Gaz médicinal liquéfié.<br>
     * IT: Code per Gas medicinale liquefatto.<br>
     */
    public static final String MEDICINAL_GAS_LIQUEFIED_CODE = "12303000";

    /**
     * EN: Code for Medicinal larvae.<br>
     * DE: Code für Larven zur medizinischen Anwendung.<br>
     * FR: Code de Larves médicinales.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String MEDICINAL_LARVAE_CODE = "13124000";

    /**
     * EN: Code for Medicinal leech.<br>
     * DE: Code für Blutegel zur medizinischen Anwendung.<br>
     * FR: Code de Sangsue médicinale.<br>
     * IT: Code per Sanguisuga medicinale.<br>
     */
    public static final String MEDICINAL_LEECH_CODE = "13115000";

    /**
     * EN: Code for Modified-release capsule, hard.<br>
     * DE: Code für Hartkapsel mit veränderter Wirkstofffreisetzung.<br>
     * FR: Code de Gélule à libération modifiée.<br>
     * IT: Code per Capsula rigida a rilascio modificato.<br>
     */
    public static final String MODIFIED_RELEASE_CAPSULE_HARD_CODE = "10217000";

    /**
     * EN: Code for Modified-release capsule, soft.<br>
     * DE: Code für Weichkapsel mit veränderter Wirkstofffreisetzung.<br>
     * FR: Code de Capsule molle à libération modifiée.<br>
     * IT: Code per Capsula molle a rilascio modificato.<br>
     */
    public static final String MODIFIED_RELEASE_CAPSULE_SOFT_CODE = "10218000";

    /**
     * EN: Code for Modified-release granules.<br>
     * DE: Code für Granulat mit veränderter Wirkstofffreisetzung.<br>
     * FR: Code de Granulés à libération modifiée.<br>
     * IT: Code per Granulato a rilascio modificato.<br>
     */
    public static final String MODIFIED_RELEASE_GRANULES_CODE = "10208000";

    /**
     * EN: Code for Modified-release granules for oral suspension.<br>
     * DE: Code für Granulat mit veränderter Wirkstofffreisetzung zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Granulés à libération modifiée pour suspension buvable.<br>
     * IT: Code per Granulato a rilascio modificato per sospensione orale.<br>
     */
    public static final String MODIFIED_RELEASE_GRANULES_FOR_ORAL_SUSPENSION_CODE = "50036000";

    /**
     * EN: Code for Modified-release oral suspension.<br>
     * DE: Code für Suspension zum Einnehmen mit veränderter Wirkstofffreisetzung.<br>
     * FR: Code de Solution à libération prolongée intralésionnelle.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String MODIFIED_RELEASE_ORAL_SUSPENSION_CODE = "13135000";

    /**
     * EN: Code for Modified-release tablet.<br>
     * DE: Code für Tablette mit veränderter Wirkstofffreisetzung.<br>
     * FR: Code de Comprimé à libération modifiée.<br>
     * IT: Code per Compressa a rilascio modificato.<br>
     */
    public static final String MODIFIED_RELEASE_TABLET_CODE = "10227000";

    /**
     * EN: Code for Mouthwash.<br>
     * DE: Code für Mundspülung.<br>
     * FR: Code de Solution pour bain de bouche.<br>
     * IT: Code per Collutorio.<br>
     */
    public static final String MOUTHWASH_CODE = "10310000";

    /**
     * EN: Code for Mouthwash, powder for solution.<br>
     * DE: Code für Pulver zur Herstellung einer Mundspülung, Lösung.<br>
     * FR: Code de Poudre pour solution pour bain de bouche.<br>
     * IT: Code per Collutorio, polvere per soluzione.<br>
     */
    public static final String MOUTHWASH_POWDER_FOR_SOLUTION_CODE = "50036050";

    /**
     * EN: Code for Mouthwash, tablet for solution.<br>
     * DE: Code für Tablette zur Herstellung einer Mundspülung.<br>
     * FR: Code de Comprimé pour solution pour bain de bouche.<br>
     * IT: Code per Compressa per soluzione per collutorio.<br>
     */
    public static final String MOUTHWASH_TABLET_FOR_SOLUTION_CODE = "10311000";

    /**
     * EN: Code for Muco-adhesive buccal tablet.<br>
     * DE: Code für mucoadhäsive Buccaltablette.<br>
     * FR: Code de Comprimé buccogingival muco-adhésif.<br>
     * IT: Code per Compressa buccale mucoadesiva.<br>
     */
    public static final String MUCO_ADHESIVE_BUCCAL_TABLET_CODE = "10319000";

    /**
     * EN: Code for Nasal cream.<br>
     * DE: Code für Nasencreme.<br>
     * FR: Code de Crème nasale.<br>
     * IT: Code per Crema nasale.<br>
     */
    public static final String NASAL_CREAM_CODE = "10801000";

    /**
     * EN: Code for Nasal drops, emulsion.<br>
     * DE: Code für Nasentropfen, Emulsion.<br>
     * FR: Code de Emulsion nasale en gouttes.<br>
     * IT: Code per Gocce nasali, emulsione.<br>
     */
    public static final String NASAL_DROPS_EMULSION_CODE = "10806000";

    /**
     * EN: Code for Nasal drops, powder for solution.<br>
     * DE: Code für Pulver zur Herstellung von Nasentropfen, Lösung.<br>
     * FR: Code de Poudre pour solution nasale en gouttes.<br>
     * IT: Code per Gocce nasali, polvere per soluzione.<br>
     */
    public static final String NASAL_DROPS_POWDER_FOR_SOLUTION_CODE = "13020000";

    /**
     * EN: Code for Nasal drops, solution.<br>
     * DE: Code für Nasentropfen, Lösung.<br>
     * FR: Code de Solution nasale en gouttes.<br>
     * IT: Code per Gocce nasali, soluzione.<br>
     */
    public static final String NASAL_DROPS_SOLUTION_CODE = "10804000";

    /**
     * EN: Code for Nasal drops, suspension.<br>
     * DE: Code für Nasentropfen, Suspension.<br>
     * FR: Code de Suspension nasale en gouttes.<br>
     * IT: Code per Gocce nasali, sospensione.<br>
     */
    public static final String NASAL_DROPS_SUSPENSION_CODE = "10805000";

    /**
     * EN: Code for Nasal gel.<br>
     * DE: Code für Nasengel.<br>
     * FR: Code de Gel nasal.<br>
     * IT: Code per Gel nasale.<br>
     */
    public static final String NASAL_GEL_CODE = "10802000";

    /**
     * EN: Code for Nasal ointment.<br>
     * DE: Code für Nasensalbe.<br>
     * FR: Code de Pommade nasale.<br>
     * IT: Code per Unguento nasale.<br>
     */
    public static final String NASAL_OINTMENT_CODE = "10803000";

    /**
     * EN: Code for Nasal/oromucosal solution.<br>
     * DE: Code für Lösung zur nasalen Anwendung/Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Solution nasale/buccale.<br>
     * IT: Code per Soluzione nasale/per mucosa orale.<br>
     */
    public static final String NASAL_OROMUCOSAL_SOLUTION_CODE = "50036500";

    /**
     * EN: Code for Nasal/oromucosal spray, solution.<br>
     * DE: Code für Nasenspray und Spray zur Anwendung in der Mundhöhle, Lösung.<br>
     * FR: Code de Solution pour pulvérisation nasale/ buccale.<br>
     * IT: Code per Spray nasale/per mucosa orale, soluzione.<br>
     */
    public static final String NASAL_OROMUCOSAL_SPRAY_SOLUTION_CODE = "50036700";

    /**
     * EN: Code for Nasal powder.<br>
     * DE: Code für Nasenpulver.<br>
     * FR: Code de Poudre nasale.<br>
     * IT: Code per Polvere nasale.<br>
     */
    public static final String NASAL_POWDER_CODE = "10807000";

    /**
     * EN: Code for Nasal spray, emulsion.<br>
     * DE: Code für Nasenspray, Emulsion.<br>
     * FR: Code de Emulsion pour pulvérisation nasale.<br>
     * IT: Code per Spray nasale, emulsione.<br>
     */
    public static final String NASAL_SPRAY_EMULSION_CODE = "10810000";

    /**
     * EN: Code for Nasal spray, powder for solution.<br>
     * DE: Code für Nasenspray, Pulver zur Herstellung einer Lösung.<br>
     * FR: Code de Poudre pour solution pour pulvérisation nasale.<br>
     * IT: Code per Spray nasale, polvere per soluzione.<br>
     */
    public static final String NASAL_SPRAY_POWDER_FOR_SOLUTION_CODE = "50037100";

    /**
     * EN: Code for Nasal spray, solution.<br>
     * DE: Code für Nasenspray, Lösung.<br>
     * FR: Code de Solution pour pulvérisation nasale.<br>
     * IT: Code per Spray nasale, soluzione.<br>
     */
    public static final String NASAL_SPRAY_SOLUTION_CODE = "10808000";

    /**
     * EN: Code for Nasal spray, solution/oromucosal solution.<br>
     * DE: Code für Nasenspray, Lösung/Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Solution pour pulvérisation nasale/ solution buccale.<br>
     * IT: Code per Spray nasale, soluzione/soluzione per mucosa orale.<br>
     */
    public static final String NASAL_SPRAY_SOLUTION_OROMUCOSAL_SOLUTION_CODE = "50037400";

    /**
     * EN: Code for Nasal spray, suspension.<br>
     * DE: Code für Nasenspray, Suspension.<br>
     * FR: Code de Suspension pour pulvérisation nasale.<br>
     * IT: Code per Spray nasale, sospensione.<br>
     */
    public static final String NASAL_SPRAY_SUSPENSION_CODE = "10809000";

    /**
     * EN: Code for Nasal stick.<br>
     * DE: Code für Nasenstift.<br>
     * FR: Code de Bâton pour usage nasal.<br>
     * IT: Code per Bastoncino nasale.<br>
     */
    public static final String NASAL_STICK_CODE = "10812000";

    /**
     * EN: Code for Nasal wash.<br>
     * DE: Code für Nasenspülung.<br>
     * FR: Code de Solution pour lavage nasal.<br>
     * IT: Code per Lavaggio nasale.<br>
     */
    public static final String NASAL_WASH_CODE = "10811000";

    /**
     * EN: Code for Nebuliser dispersion.<br>
     * DE: Code für Lyophilisat zur sublingualen Anwendung.<br>
     * FR: Code de Solution à libération prolongée intralésionnelle.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String NEBULISER_DISPERSION_CODE = "13129000";

    /**
     * EN: Code for Nebuliser emulsion.<br>
     * DE: Code für Emulsion für einen Vernebler.<br>
     * FR: Code de Emulsion pour inhalation par nébuliseur.<br>
     * IT: Code per Emulsione per nebulizzatore.<br>
     */
    public static final String NEBULISER_EMULSION_CODE = "11105000";

    /**
     * EN: Code for Nebuliser solution.<br>
     * DE: Code für Lösung für einen Vernebler.<br>
     * FR: Code de Solution pour inhalation par nébuliseur.<br>
     * IT: Code per Soluzione per nebulizzatore.<br>
     */
    public static final String NEBULISER_SOLUTION_CODE = "11101000";

    /**
     * EN: Code for Nebuliser suspension.<br>
     * DE: Code für Suspension für einen Vernebler.<br>
     * FR: Code de Suspension pour inhalation par nébuliseur.<br>
     * IT: Code per Sospensione per nebulizzatore.<br>
     */
    public static final String NEBULISER_SUSPENSION_CODE = "11102000";

    /**
     * EN: Code for Ointment.<br>
     * DE: Code für Salbe.<br>
     * FR: Code de Pommade.<br>
     * IT: Code per Unguento.<br>
     */
    public static final String OINTMENT_CODE = "10504000";

    /**
     * EN: Code for Ophthalmic insert.<br>
     * DE: Code für Augeninsert.<br>
     * FR: Code de Insert ophtalmique.<br>
     * IT: Code per Inserto oftalmico.<br>
     */
    public static final String OPHTHALMIC_INSERT_CODE = "10612000";

    /**
     * EN: Code for Ophthalmic strip.<br>
     * DE: Code für Teststreifen zur Anwendung am Auge.<br>
     * FR: Code de Bandelette ophtalmique.<br>
     * IT: Code per Striscia oftalmica.<br>
     */
    public static final String OPHTHALMIC_STRIP_CODE = "10613000";

    /**
     * EN: Code for Oral drops, emulsion.<br>
     * DE: Code für Tropfen zum Einnehmen, Emulsion.<br>
     * FR: Code de Emulsion buvable en gouttes.<br>
     * IT: Code per Gocce orali, emulsione.<br>
     */
    public static final String ORAL_DROPS_EMULSION_CODE = "10103000";

    /**
     * EN: Code for Oral drops, granules for solution.<br>
     * DE: Code für Granulat zur Herstellung von Tropfen zum Einnehmen, Lösung.<br>
     * FR: Code de Granulés pour solution buvale en gouttes.<br>
     * IT: Code per Gocce orali, granulato per soluzione.<br>
     */
    public static final String ORAL_DROPS_GRANULES_FOR_SOLUTION_CODE = "50037500";

    /**
     * EN: Code for Oral drops, liquid.<br>
     * DE: Code für Tropfen zum Einnehmen, Flüssigkeit.<br>
     * FR: Code de Liquide oral en gouttes.<br>
     * IT: Code per Gocce orali, liquido.<br>
     */
    public static final String ORAL_DROPS_LIQUID_CODE = "50037750";

    /**
     * EN: Code for Oral drops, powder for suspension.<br>
     * DE: Code für Pulver zur Herstellung von Tropfen zum Einnehmen, Suspension.<br>
     * FR: Code de Poudre pour suspension oral en gouttes.<br>
     * IT: Code per Gocce orali, polvere per sospensione.<br>
     */
    public static final String ORAL_DROPS_POWDER_FOR_SUSPENSION_CODE = "50082000";

    /**
     * EN: Code for Oral drops, solution.<br>
     * DE: Code für Tropfen zum Einnehmen, Lösung.<br>
     * FR: Code de Solution buvable en gouttes.<br>
     * IT: Code per Gocce orali, soluzione.<br>
     */
    public static final String ORAL_DROPS_SOLUTION_CODE = "10101000";

    /**
     * EN: Code for Oral drops, suspension.<br>
     * DE: Code für Tropfen zum Einnehmen, Suspension.<br>
     * FR: Code de Suspension buvable en gouttes.<br>
     * IT: Code per Gocce orali, sospensione.<br>
     */
    public static final String ORAL_DROPS_SUSPENSION_CODE = "10102000";

    /**
     * EN: Code for Oral emulsion.<br>
     * DE: Code für Emulsion zum Einnehmen.<br>
     * FR: Code de Emulsion buvable.<br>
     * IT: Code per Emulsione orale.<br>
     */
    public static final String ORAL_EMULSION_CODE = "10107000";

    /**
     * EN: Code for Oral gel.<br>
     * DE: Code für Gel zum Einnehmen.<br>
     * FR: Code de Gel oral.<br>
     * IT: Code per Gel orale.<br>
     */
    public static final String ORAL_GEL_CODE = "10108000";

    /**
     * EN: Code for Oral gum.<br>
     * DE: Code für Lutschpastille.<br>
     * FR: Code de Gomme orale.<br>
     * IT: Code per Pastiglia gommosa.<br>
     */
    public static final String ORAL_GUM_CODE = "10230000";

    /**
     * EN: Code for Oral herbal material.<br>
     * DE: Code für Pflanzenteile zum Einnehmen.<br>
     * FR: Code de -.<br>
     * IT: Code per Sostanza di origine vegetale  per uso orale.<br>
     */
    public static final String ORAL_HERBAL_MATERIAL_CODE = "13106000";

    /**
     * EN: Code for Oral liquid.<br>
     * DE: Code für Flüssigkeit zum Einnehmen.<br>
     * FR: Code de Liquide oral.<br>
     * IT: Code per Liquido orale.<br>
     */
    public static final String ORAL_LIQUID_CODE = "10104000";

    /**
     * EN: Code for Oral lyophilisate.<br>
     * DE: Code für Lyophilisat zum Einnehmen.<br>
     * FR: Code de Lyophilisat oral.<br>
     * IT: Code per Liofilizzato orale.<br>
     */
    public static final String ORAL_LYOPHILISATE_CODE = "10224000";

    /**
     * EN: Code for Oral paste.<br>
     * DE: Code für Paste zum Einnehmen.<br>
     * FR: Code de Pâte orale.<br>
     * IT: Code per Pasta per uso orale.<br>
     */
    public static final String ORAL_PASTE_CODE = "10109000";

    /**
     * EN: Code for Oral powder.<br>
     * DE: Code für Pulver zum Einnehmen.<br>
     * FR: Code de Poudre orale.<br>
     * IT: Code per Polvere orale.<br>
     */
    public static final String ORAL_POWDER_CODE = "10201000";

    /**
     * EN: Code for Oral/rectal solution.<br>
     * DE: Code für Lösung zum Einnehmen/Rektallösung.<br>
     * FR: Code de Solution buvable/rectale.<br>
     * IT: Code per Soluzione orale/rettale.<br>
     */
    public static final String ORAL_RECTAL_SOLUTION_CODE = "50037900";

    /**
     * EN: Code for Oral/rectal suspension.<br>
     * DE: Code für Suspension zum Einnehmen/Rektalsuspension.<br>
     * FR: Code de Suspension buvable/rectale.<br>
     * IT: Code per Sospensione orale/rettale.<br>
     */
    public static final String ORAL_RECTAL_SUSPENSION_CODE = "50038000";

    /**
     * EN: Code for Oral solution.<br>
     * DE: Code für Lösung zum Einnehmen.<br>
     * FR: Code de Solution  buvable.<br>
     * IT: Code per Soluzione orale.<br>
     */
    public static final String ORAL_SOLUTION_CODE = "10105000";

    /**
     * EN: Code for Oral solution/concentrate for nebuliser solution.<br>
     * DE: Code für Lösung zum Einnehmen/ Konzentrat zur Herstellung einer Lösung für einen Vernebler.<br>
     * FR: Code de Solution orale/solution à diluer pour inhalation par nébuliseur.<br>
     * IT: Code per Soluzione orale/concentrato per soluzione per nebulizzatore.<br>
     */
    public static final String ORAL_SOLUTION_CONCENTRATE_FOR_NEBULISER_SOLUTION_CODE = "50038500";

    /**
     * EN: Code for Oral suspension.<br>
     * DE: Code für Suspension zum Einnehmen.<br>
     * FR: Code de Suspension buvable.<br>
     * IT: Code per Sospensione orale.<br>
     */
    public static final String ORAL_SUSPENSION_CODE = "10106000";

    /**
     * EN: Code for Orodispersible film.<br>
     * DE: Code für Schmelzfilm.<br>
     * FR: Code de Film orodispersible.<br>
     * IT: Code per Film orodispersibile.<br>
     */
    public static final String ORODISPERSIBLE_FILM_CODE = "10236100";

    /**
     * EN: Code for Orodispersible tablet.<br>
     * DE: Code für Schmelztablette.<br>
     * FR: Code de Comprimé orodispersible.<br>
     * IT: Code per Compressa orodispersibile.<br>
     */
    public static final String ORODISPERSIBLE_TABLET_CODE = "10223000";

    /**
     * EN: Code for Oromucosal capsule.<br>
     * DE: Code für Kapsel zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Capsule buccale.<br>
     * IT: Code per Capsula per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_CAPSULE_CODE = "10317000";

    /**
     * EN: Code for Oromucosal cream.<br>
     * DE: Code für Creme zur Anwendung in der Mundhöhle.<br>
     * FR: Code de crème buccale.<br>
     * IT: Code per Crema per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_CREAM_CODE = "10314010";

    /**
     * EN: Code for Oromucosal drops.<br>
     * DE: Code für Tropfen zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Solution buccale en gouttes.<br>
     * IT: Code per Gocce per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_DROPS_CODE = "10307000";

    /**
     * EN: Code for Oromucosal gel.<br>
     * DE: Code für Gel zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Gel buccal.<br>
     * IT: Code per Gel per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_GEL_CODE = "10313000";

    /**
     * EN: Code for Oromucosal/laryngopharyngeal solution.<br>
     * DE: Code für Lösung zur Anwendung in der Mundhöhle/im Rachenraum und am Kehlkopf.<br>
     * FR: Code de Solution buccale/laryngopharyngée.<br>
     * IT: Code per Soluzione per mucosa orale/laringofaringea.<br>
     */
    public static final String OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION_CODE = "50039500";

    /**
     * EN: Code for Oromucosal/laryngopharyngeal solution/spray, solution.<br>
     * DE: Code für Lösung/Spray zur Anwendung in der Mundhöhle/im Rachenraum oder am Kehlkopf, Lösung.<br>
     * FR: Code de Solution/ solution pour pulvérisation buccale/ laryngopharyngée.<br>
     * IT: Code per Soluzione per mucosa orale/laringofaringea  o spray per mucosa orale/laringofaringeo, soluzione.<br>
     */
    public static final String OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION_SPRAY_SOLUTION_CODE = "50040500";

    /**
     * EN: Code for Oromucosal ointment.<br>
     * DE: Code für Salbe zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Pommade buccale.<br>
     * IT: Code per Unguento per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_OINTMENT_CODE = "10314005";

    /**
     * EN: Code for Oromucosal paste.<br>
     * DE: Code für Paste zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Pâte buccale.<br>
     * IT: Code per Pasta per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_PASTE_CODE = "10314000";

    /**
     * EN: Code for Oromucosal patch.<br>
     * DE: Code für Pflaster zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Patch buccal.<br>
     * IT: Code per Cerotto per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_PATCH_CODE = "50039000";

    /**
     * EN: Code for Oromucosal pouch.<br>
     * DE: Code für Magensaftresistentes Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Dispersion à diluer pour dispersion injectable.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String OROMUCOSAL_POUCH_CODE = "13141000";

    /**
     * EN: Code for Oromucosal solution.<br>
     * DE: Code für Lösung zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Solution buccale.<br>
     * IT: Code per Soluzione per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_SOLUTION_CODE = "10305000";

    /**
     * EN: Code for Oromucosal spray, emulsion.<br>
     * DE: Code für Spray zur Anwendung in der Mundhöhle, Emulsion.<br>
     * FR: Code de Emulsion pour pulvérisation buccale.<br>
     * IT: Code per Spray per mucosa orale, emulsione.<br>
     */
    public static final String OROMUCOSAL_SPRAY_EMULSION_CODE = "10308100";

    /**
     * EN: Code for Oromucosal spray, solution.<br>
     * DE: Code für Spray zur Anwendung in der Mundhöhle, Lösung.<br>
     * FR: Code de Solution pour pulvérisation buccale.<br>
     * IT: Code per Spray per mucosa orale, soluzione.<br>
     */
    public static final String OROMUCOSAL_SPRAY_SOLUTION_CODE = "10308200";

    /**
     * EN: Code for Oromucosal spray, suspension.<br>
     * DE: Code für Spray zur Anwendung in der Mundhöhle, Suspension.<br>
     * FR: Code de Suspension pour pulvérisation buccale.<br>
     * IT: Code per Spray per mucosa orale, sospensione.<br>
     */
    public static final String OROMUCOSAL_SPRAY_SUSPENSION_CODE = "10308300";

    /**
     * EN: Code for Oromucosal suspension.<br>
     * DE: Code für Suspension zur Anwendung in der Mundhöhle.<br>
     * FR: Code de Suspension buccale.<br>
     * IT: Code per Sospensione per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_SUSPENSION_CODE = "10306000";

    /**
     * EN: Code for Pastille.<br>
     * DE: Code für Pastille.<br>
     * FR: Code de Pâte à sucer.<br>
     * IT: Code per Pastiglia molle.<br>
     */
    public static final String PASTILLE_CODE = "10323000";

    /**
     * EN: Code for Periodontal gel.<br>
     * DE: Code für Gel zur periodontalen Anwendung.<br>
     * FR: Code de Gel périodontal.<br>
     * IT: Code per Gel periodontale.<br>
     */
    public static final String PERIODONTAL_GEL_CODE = "10410000";

    /**
     * EN: Code for Periodontal insert.<br>
     * DE: Code für Insert zur periodontalen Anwendung.<br>
     * FR: Code de Insert périodontal.<br>
     * IT: Code per Inserto periodontale.<br>
     */
    public static final String PERIODONTAL_INSERT_CODE = "10411000";

    /**
     * EN: Code for Periodontal powder.<br>
     * DE: Code für Pulver zur periodontalen Anwendung.<br>
     * FR: Code de Poudre péridontale.<br>
     * IT: Code per Polvere periodontale.<br>
     */
    public static final String PERIODONTAL_POWDER_CODE = "10401000";

    /**
     * EN: Code for Pessary.<br>
     * DE: Code für Vaginalzäpfchen.<br>
     * FR: Code de Ovule.<br>
     * IT: Code per Ovulo.<br>
     */
    public static final String PESSARY_CODE = "10909000";

    /**
     * EN: Code for Pillules.<br>
     * DE: Code für Streukügelchen.<br>
     * FR: Code de Granules.<br>
     * IT: Code per Granuli.<br>
     */
    public static final String PILLULES_CODE = "10231000";

    /**
     * EN: Code for Plaster for provocation test.<br>
     * DE: Code für Pflaster für Provokationstest.<br>
     * FR: Code de patch pour test épicutané.<br>
     * IT: Code per Cerotto per test di provocazione.<br>
     */
    public static final String PLASTER_FOR_PROVOCATION_TEST_CODE = "10550000";

    /**
     * EN: Code for Poultice.<br>
     * DE: Code für Umschlagpaste.<br>
     * FR: Code de Cataplasme.<br>
     * IT: Code per Cataplasma.<br>
     */
    public static final String POULTICE_CODE = "10522000";

    /**
     * EN: Code for Powder for bladder irrigation.<br>
     * DE: Code für Pulver zur Herstellung einer Blasenspüllösung.<br>
     * FR: Code de Poudre pour solution pour irrigation vésicale.<br>
     * IT: Code per Polvere per irrigazione vescicale.<br>
     */
    public static final String POWDER_FOR_BLADDER_IRRIGATION_CODE = "11503000";

    /**
     * EN: Code for Powder for concentrate for dispersion for infusion.<br>
     * DE: Code für Pulver für ein Konzentrat zur Herstellung einer Infusionsdispersion.<br>
     * FR: Code de Poudre pour dispersion à diluer pour dispersion pour perfusion.<br>
     * IT: Code per Polvere per concentrato per dispersione per infusione.<br>
     */
    public static final String POWDER_FOR_CONCENTRATE_FOR_DISPERSION_FOR_INFUSION_CODE = "50048750";

    /**
     * EN: Code for Powder for concentrate for intravesical suspension.<br>
     * DE: Code für Pulver für ein Konzentrat zur Herstellung einer Suspension zur intravesikalen Anwendung.<br>
     * FR: Code de Poudre pour suspension à diluer pour suspension intravésicale.<br>
     * IT: Code per Polvere per concentrato per sospensione endovescicale.<br>
     */
    public static final String POWDER_FOR_CONCENTRATE_FOR_INTRAVESICAL_SUSPENSION_CODE = "50049100";

    /**
     * EN: Code for Powder for concentrate for solution for haemodialysis.<br>
     * DE: Code für Pulver für ein Konzentrat zur Herstellung einer Hämodialyselösung.<br>
     * FR: Code de Poudre pour solution à diluer pour solution pour hémodialyse.<br>
     * IT: Code per Polvere per concentrato per soluzione per emodialisi.<br>
     */
    public static final String POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_HAEMODIALYSIS_CODE = "50049200";

    /**
     * EN: Code for Powder for concentrate for solution for infusion.<br>
     * DE: Code für Pulver für ein Konzentrat zur Herstellung einer Infusionslösung.<br>
     * FR: Code de Poudre pour solution à diluer pour perfusion.<br>
     * IT: Code per Polvere per concentrato per soluzione per infusione.<br>
     */
    public static final String POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INFUSION_CODE = "50043000";

    /**
     * EN: Code for Powder for concentrate for solution for injection/infusion.<br>
     * DE: Code für Pulver für ein Konzentrat zur Herstellung einer Injektions-/Infusionslösung.<br>
     * FR: Code de Poudre pour solution à diluer pour solution injectable/pour perfusion.<br>
     * IT: Code per Polvere per concentrato per soluzione iniettabile/per infusione.<br>
     */
    public static final String POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_INFUSION_CODE = "50049250";

    /**
     * EN: Code for Powder for cutaneous solution.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zur Anwendung auf der Haut.<br>
     * FR: Code de Poudre pour solution cutanée.<br>
     * IT: Code per Polvere per soluzione cutanea.<br>
     */
    public static final String POWDER_FOR_CUTANEOUS_SOLUTION_CODE = "10514500";

    /**
     * EN: Code for Powder for dental cement.<br>
     * DE: Code für Pulver zur Herstellung eines Dentalzements.<br>
     * FR: Code de Poudre pour ciment dentaire.<br>
     * IT: Code per Inserto periodontale.<br>
     */
    public static final String POWDER_FOR_DENTAL_CEMENT_CODE = "10413000";

    /**
     * EN: Code for Powder for dental gel.<br>
     * DE: Code für Pulver zur Herstellung eines Dentalgels.<br>
     * FR: Code de Poudre pour gel dentaire.<br>
     * IT: Code per Polvere per gel.<br>
     */
    public static final String POWDER_FOR_DENTAL_GEL_CODE = "13022000";

    /**
     * EN: Code for Powder for dental solution.<br>
     * DE: Code für Pulver zur Herstellung einer Dentallösung.<br>
     * FR: Code de Poudre pour solution dentaire.<br>
     * IT: Code per Polvere per concentrato per soluzione iniettabile/per infusione.<br>
     */
    public static final String POWDER_FOR_DENTAL_SOLUTION_CODE = "50049270";

    /**
     * EN: Code for Powder for dispersion for infusion.<br>
     * DE: Code für Pulver zur Herstellung einer Infusionsdispersion.<br>
     * FR: Code de Poudre pour dispersion pour perfusion.<br>
     * IT: Code per Polvere per dispersione per infusione.<br>
     */
    public static final String POWDER_FOR_DISPERSION_FOR_INFUSION_CODE = "11211500";

    /**
     * EN: Code for Powder for dispersion for injection.<br>
     * DE: Code für Pulver zur Herstellung einer Injektionsdispersion.<br>
     * FR: Code de Poudre pour dispersion injectable.<br>
     * IT: Code per Polvere per dispersione iniettabile.<br>
     */
    public static final String POWDER_FOR_DISPERSION_FOR_INJECTION_CODE = "13023000";

    /**
     * EN: Code for Powder for emulsion for injection.<br>
     * DE: Code für Pulver zur Herstellung einer Emulsion zur Injektion.<br>
     * FR: Code de Poudre pour émulsion injectable.<br>
     * IT: Code per Polvere per emulsione iniettabile.<br>
     */
    public static final String POWDER_FOR_EMULSION_FOR_INJECTION_CODE = "13040000";

    /**
     * EN: Code for Powder for endocervical gel.<br>
     * DE: Code für Pulver zur Herstellung eines Gels zur endozervikalen Anwendung.<br>
     * FR: Code de Poudre pour gel endocervical.<br>
     * IT: Code per Polvere per gel endocervicale.<br>
     */
    public static final String POWDER_FOR_ENDOCERVICAL_GEL_CODE = "13024000";

    /**
     * EN: Code for Powder for endosinusial solution.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zur Anwendung in den Nasennebenhöhlen.<br>
     * FR: Code de Poudre pour solution endosinusale.<br>
     * IT: Code per Polvere per soluzione endosinusale.<br>
     */
    public static final String POWDER_FOR_ENDOSINUSIAL_SOLUTION_CODE = "13025000";

    /**
     * EN: Code for Powder for epilesional solution.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zum Auftragen auf die Wunde.<br>
     * FR: Code de Poudre pour solution épilésionnelle.<br>
     * IT: Code per Polvere per soluzione epilesionale.<br>
     */
    public static final String POWDER_FOR_EPILESIONAL_SOLUTION_CODE = "50049300";

    /**
     * EN: Code for Powder for gel.<br>
     * DE: Code für Pulver zur Herstellung eines Gels.<br>
     * FR: Code de Poudre pour gel.<br>
     * IT: Code per Polvere per gel.<br>
     */
    public static final String POWDER_FOR_GEL_CODE = "13021000";

    /**
     * EN: Code for Powder for gingival gel.<br>
     * DE: Code für Pulver zur Herstellung eines Gels zur Anwendung am Zahnfleisch.<br>
     * FR: Code de Poudre pour gel gingival.<br>
     * IT: Code per Polvere per gel gengivale.<br>
     */
    public static final String POWDER_FOR_GINGIVAL_GEL_CODE = "13026000";

    /**
     * EN: Code for Powder for implantation matrix.<br>
     * DE: Code für Pulver für Matrix zur Implantation.<br>
     * FR: Code de Poudre pour matrice pour implantation.<br>
     * IT: Code per Polvere per gel gengivale.<br>
     */
    public static final String POWDER_FOR_IMPLANTATION_MATRIX_CODE = "13027000";

    /**
     * EN: Code for Powder for implantation paste.<br>
     * DE: Code für Pulver zur Herstellung einer Paste für ein Implantat.<br>
     * FR: Code de Poudre pour pâte pour implantation.<br>
     * IT: Code per Polvere per gel gengivale.<br>
     */
    public static final String POWDER_FOR_IMPLANTATION_PASTE_CODE = "13028000";

    /**
     * EN: Code for Powder for implantation suspension.<br>
     * DE: Code für Pulver zur Herstellung einer Suspension zur Implantation.<br>
     * FR: Code de Poudre pour suspension pour implantation.<br>
     * IT: Code per Polvere per soluzione epilesionale.<br>
     */
    public static final String POWDER_FOR_IMPLANTATION_SUSPENSION_CODE = "50049500";

    /**
     * EN: Code for Powder for intraocular instillation solution.<br>
     * DE: Code für Pulver zur Herstellung einer Instillationslösung zur intraokularen Anwendung.<br>
     * FR: Code de Poudre pour solution pour instillation intraoculaire.<br>
     * IT: Code per Polvere per soluzione per instillazione intraoculare.<br>
     */
    public static final String POWDER_FOR_INTRAOCULAR_INSTILLATION_SOLUTION_CODE = "13029000";

    /**
     * EN: Code for Powder for intravesical solution.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zur intravesikalen Anwendung.<br>
     * FR: Code de Poudre pour solution intravésicale.<br>
     * IT: Code per Polvere per soluzione endovescicale.<br>
     */
    public static final String POWDER_FOR_INTRAVESICAL_SOLUTION_CODE = "50050000";

    /**
     * EN: Code for Powder for intravesical solution/solution for injection.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zur intravesikalen Anwendung / Injektionslösung.<br>
     * FR: Code de Poudre pour solution intravésicale/injectable.<br>
     * IT: Code per Polvere per soluzione endovescicale/soluzione iniettabile.<br>
     */
    public static final String POWDER_FOR_INTRAVESICAL_SOLUTION_SOLUTION_FOR_INJECTION_CODE = "50050500";

    /**
     * EN: Code for Powder for intravesical suspension.<br>
     * DE: Code für Pulver zur Herstellung einer Suspensionen zur intravesikalen Anwendung.<br>
     * FR: Code de Poudre pour suspension intravésicale.<br>
     * IT: Code per Polvere per sospensione endovescicale.<br>
     */
    public static final String POWDER_FOR_INTRAVESICAL_SUSPENSION_CODE = "50051000";

    /**
     * EN: Code for Powder for nebuliser solution.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung für einen Vernebler.<br>
     * FR: Code de Poudre pour solution pour inhalation par nébuliseur.<br>
     * IT: Code per Polvere per soluzione per nebulizzatore.<br>
     */
    public static final String POWDER_FOR_NEBULISER_SOLUTION_CODE = "11104000";

    /**
     * EN: Code for Powder for nebuliser suspension.<br>
     * DE: Code für Pulver zur Herstellung einer Suspension für einen Vernebler.<br>
     * FR: Code de Poudre pour suspension pour inhalation par nébuliseur.<br>
     * IT: Code per Polvere per sospensione per nebulizzatore.<br>
     */
    public static final String POWDER_FOR_NEBULISER_SUSPENSION_CODE = "11103000";

    /**
     * EN: Code for Powder for oral/rectal suspension.<br>
     * DE: Code für Pulver zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension.<br>
     * FR: Code de Poudre pour suspension oral/rectal.<br>
     * IT: Code per Polvere per sospensione orale/rettale.<br>
     */
    public static final String POWDER_FOR_ORAL_RECTAL_SUSPENSION_CODE = "50052000";

    /**
     * EN: Code for Powder for oral solution.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zum Einnehmen.<br>
     * FR: Code de Poudre pour solution buvable.<br>
     * IT: Code per Polvere per soluzione orale.<br>
     */
    public static final String POWDER_FOR_ORAL_SOLUTION_CODE = "10110000";

    /**
     * EN: Code for Powder for oral suspension.<br>
     * DE: Code für Pulver zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Poudre pour suspension buvable.<br>
     * IT: Code per Polvere per sospensione orale.<br>
     */
    public static final String POWDER_FOR_ORAL_SUSPENSION_CODE = "10111000";

    /**
     * EN: Code for Powder for prolonged-release suspension for injection.<br>
     * DE: Code für Pulver zur Herstellung einer Depot-Injektionssuspension.<br>
     * FR: Code de Poudre pour suspension injectable à libération prolongée.<br>
     * IT: Code per Polvere per sospensione iniettabile a rilascio prolungato.<br>
     */
    public static final String POWDER_FOR_PROLONGED_RELEASE_SUSPENSION_FOR_INJECTION_CODE = "11208400";

    /**
     * EN: Code for Powder for rectal solution.<br>
     * DE: Code für Pulver zur Herstellung einer Rektallösung.<br>
     * FR: Code de Poudre pour solution rectale.<br>
     * IT: Code per Polvere per soluzione rettale.<br>
     */
    public static final String POWDER_FOR_RECTAL_SOLUTION_CODE = "11009000";

    /**
     * EN: Code for Powder for rectal suspension.<br>
     * DE: Code für Pulver zur Herstellung einer Rektalsuspension.<br>
     * FR: Code de Poudre pour suspension rectale.<br>
     * IT: Code per Polvere per sospensione rettale.<br>
     */
    public static final String POWDER_FOR_RECTAL_SUSPENSION_CODE = "11010000";

    /**
     * EN: Code for Powder for sealant.<br>
     * DE: Code für Pulver für einen Gewebekleber.<br>
     * FR: Code de Poudre pour colle.<br>
     * IT: Code per Polvere per adesivo tissutale.<br>
     */
    public static final String POWDER_FOR_SEALANT_CODE = "13031000";

    /**
     * EN: Code for Powder for solution for infusion.<br>
     * DE: Code für Pulver zur Herstellung einer Infusionslösung.<br>
     * FR: Code de Poudre pour solution pour perfusion.<br>
     * IT: Code per Polvere per soluzione per infusione.<br>
     */
    public static final String POWDER_FOR_SOLUTION_FOR_INFUSION_CODE = "11212000";

    /**
     * EN: Code for Powder for solution for injection.<br>
     * DE: Code für Pulver zur Herstellung einer Injektionslösung.<br>
     * FR: Code de Poudre pour solution injectable.<br>
     * IT: Code per Polvere per soluzione iniettabile.<br>
     */
    public static final String POWDER_FOR_SOLUTION_FOR_INJECTION_CODE = "11205000";

    /**
     * EN: Code for Powder for solution for injection/infusion.<br>
     * DE: Code für Pulver zur Herstellung einer Injektions-/Infusionslösung.<br>
     * FR: Code de Poudre pour solution injectable/pour perfusion.<br>
     * IT: Code per Polvere per soluzione iniettabile/per infusione.<br>
     */
    public static final String POWDER_FOR_SOLUTION_FOR_INJECTION_INFUSION_CODE = "50053500";

    /**
     * EN: Code for Powder for solution for injection/skin-prick test.<br>
     * DE: Code für Pulver zur Herstellung einer Injektionslösung/Pricktestlösung.<br>
     * FR: Code de Poudre pour solution injectable/ pour prick-test.<br>
     * IT: Code per Polvere per soluzione iniettabile/per skin-prick test.<br>
     */
    public static final String POWDER_FOR_SOLUTION_FOR_INJECTION_SKIN_PRICK_TEST_CODE = "13052000";

    /**
     * EN: Code for Powder for solution for intraocular irrigation.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zur intraokularen Anwendung.<br>
     * FR: Code de Poudre pour solution pour irrigation intraoculaire.<br>
     * IT: Code per Polvere per soluzione per irrigazione intraoculare.<br>
     */
    public static final String POWDER_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION_CODE = "50073000";

    /**
     * EN: Code for Powder for solution for iontophoresis.<br>
     * DE: Code für Pulver zur Herstellung einer Lösung zur Iontophorese.<br>
     * FR: Code de Poudre pour solution pour iontophérèse.<br>
     * IT: Code per Polvere per soluzione per ionoforesi.<br>
     */
    public static final String POWDER_FOR_SOLUTION_FOR_IONTOPHORESIS_CODE = "10518500";

    /**
     * EN: Code for Powder for solution for skin-prick test.<br>
     * DE: Code für Pulver zur Herstellung einer Pricktestlösung.<br>
     * FR: Code de Poudre pour solution pour prick-test.<br>
     * IT: Code per Polvere per soluzione per skin-prick test.<br>
     */
    public static final String POWDER_FOR_SOLUTION_FOR_SKIN_PRICK_TEST_CODE = "13032000";

    /**
     * EN: Code for Powder for suspension for injection.<br>
     * DE: Code für Pulver zur Herstellung einer Injektionssuspension.<br>
     * FR: Code de Poudre pour suspension injectable.<br>
     * IT: Code per Polvere per sospensione iniettabile.<br>
     */
    public static final String POWDER_FOR_SUSPENSION_FOR_INJECTION_CODE = "11206000";

    /**
     * EN: Code for Powder for syrup.<br>
     * DE: Code für Pulver zur Herstellung eines Sirups.<br>
     * FR: Code de Poudre pour sirop.<br>
     * IT: Code per Polvere per sciroppo.<br>
     */
    public static final String POWDER_FOR_SYRUP_CODE = "10118000";

    /**
     * EN: Code for Powder for vaginal solution.<br>
     * DE: Code für Pulver zur Herstellung einer Vaginallösung.<br>
     * FR: Code de Poudre pour solution vaginale.<br>
     * IT: Code per Polvere per soluzione vaginale.<br>
     */
    public static final String POWDER_FOR_VAGINAL_SOLUTION_CODE = "13111000";

    /**
     * EN: Code for Pressurised inhalation, emulsion.<br>
     * DE: Code für Druckgasinhalation, Emulsion.<br>
     * FR: Code de Emulsion pour inhalation en flacon pressurisé.<br>
     * IT: Code per Emulsione pressurizzata per inalazione.<br>
     */
    public static final String PRESSURISED_INHALATION_EMULSION_CODE = "11108000";

    /**
     * EN: Code for Pressurised inhalation, solution.<br>
     * DE: Code für Druckgasinhalation, Lösung.<br>
     * FR: Code de Solution pour inhalation en flacon pressurisé.<br>
     * IT: Code per Soluzione pressurizzata per inalazione.<br>
     */
    public static final String PRESSURISED_INHALATION_SOLUTION_CODE = "11106000";

    /**
     * EN: Code for Pressurised inhalation, suspension.<br>
     * DE: Code für Druckgasinhalation, Suspension.<br>
     * FR: Code de Suspension pour inhalation en flacon pressurisé.<br>
     * IT: Code per Sospensione pressurizzata per inalazione.<br>
     */
    public static final String PRESSURISED_INHALATION_SUSPENSION_CODE = "11107000";

    /**
     * EN: Code for Prolonged-release capsule, hard.<br>
     * DE: Code für Hartkapsel, retardiert.<br>
     * FR: Code de Gélule à libération prolongée.<br>
     * IT: Code per Capsula rigida a rilascio prolungato.<br>
     */
    public static final String PROLONGED_RELEASE_CAPSULE_HARD_CODE = "10215000";

    /**
     * EN: Code for Prolonged-release capsule, soft.<br>
     * DE: Code für Weichkapsel, retardiert.<br>
     * FR: Code de Capsule molle à libération prolongée.<br>
     * IT: Code per Capsula molle a rilascio prolungato.<br>
     */
    public static final String PROLONGED_RELEASE_CAPSULE_SOFT_CODE = "10216000";

    /**
     * EN: Code for Prolonged-release dispersion for injection.<br>
     * DE: Code für Depot-Injektionsdispersion.<br>
     * FR: Code de Larves médicinales.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String PROLONGED_RELEASE_DISPERSION_FOR_INJECTION_CODE = "13126000";

    /**
     * EN: Code for Prolonged-release granules.<br>
     * DE: Code für Retardgranulat.<br>
     * FR: Code de Granulés à libération prolongée.<br>
     * IT: Code per Granulato a rilascio prolungato.<br>
     */
    public static final String PROLONGED_RELEASE_GRANULES_CODE = "10207000";

    /**
     * EN: Code for Prolonged-release granules for oral suspension.<br>
     * DE: Code für Retardgranulat zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Granulés à libération prolongée pour suspension buvable.<br>
     * IT: Code per Granulato a rilascio prolungato per sospensione orale.<br>
     */
    public static final String PROLONGED_RELEASE_GRANULES_FOR_ORAL_SUSPENSION_CODE = "50056000";

    /**
     * EN: Code for Prolonged-release oral suspension.<br>
     * DE: Code für Retardsuspension zum Einnehmen.<br>
     * FR: Code de Solution à libération prolongée intralésionnelle.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String PROLONGED_RELEASE_ORAL_SUSPENSION_CODE = "13134000";

    /**
     * EN: Code for Prolonged-release solution for injection.<br>
     * DE: Code für Depot-Injektionslösung.<br>
     * FR: Code de Solution injectable à libération prolongée.<br>
     * IT: Code per Soluzione iniettabile a rilascio prolungato.<br>
     */
    public static final String PROLONGED_RELEASE_SOLUTION_FOR_INJECTION_CODE = "13076000";

    /**
     * EN: Code for Prolonged-release suspension for injection.<br>
     * DE: Code für Depot-Injektionssuspension.<br>
     * FR: Code de Suspension injectable à libération prolongée.<br>
     * IT: Code per Sospensione iniettabile a rilascio prolungato.<br>
     */
    public static final String PROLONGED_RELEASE_SUSPENSION_FOR_INJECTION_CODE = "11208500";

    /**
     * EN: Code for Prolonged-release tablet.<br>
     * DE: Code für Retardtablette.<br>
     * FR: Code de Comprimé à libération prolongée.<br>
     * IT: Code per Compressa a rilascio prolungato.<br>
     */
    public static final String PROLONGED_RELEASE_TABLET_CODE = "10226000";

    /**
     * EN: Code for Prolonged-release wound solution.<br>
     * DE: Code für Lyophilisat zur sublingualen Anwendung.<br>
     * FR: Code de Solution à libération prolongée intralésionnelle.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String PROLONGED_RELEASE_WOUND_SOLUTION_CODE = "13128000";

    /**
     * EN: Code for Radionuclide generator.<br>
     * DE: Code für Radionuklidgenerator.<br>
     * FR: Code de Générateur radiopharmaceutique.<br>
     * IT: Code per Generatore di radionuclidi.<br>
     */
    public static final String RADIONUCLIDE_GENERATOR_CODE = "12106000";

    /**
     * EN: Code for Radiopharmaceutical precursor.<br>
     * DE: Code für Markerzubereitung.<br>
     * FR: Code de Précurseur radiopharmaceutique.<br>
     * IT: Code per Precursore radiofarmaceutico.<br>
     */
    public static final String RADIOPHARMACEUTICAL_PRECURSOR_CODE = "12105000";

    /**
     * EN: Code for Radiopharmaceutical precursor, solution.<br>
     * DE: Code für Markerzubereitung, Lösung.<br>
     * FR: Code de Solution de précurseur radiopharmaceutique.<br>
     * IT: Code per Precursore di radionuclidi, soluzione.<br>
     */
    public static final String RADIOPHARMACEUTICAL_PRECURSOR_SOLUTION_CODE = "50056500";

    /**
     * EN: Code for Rectal capsule.<br>
     * DE: Code für Rektalkapsel.<br>
     * FR: Code de Capsule  rectale.<br>
     * IT: Code per Capsula rettale.<br>
     */
    public static final String RECTAL_CAPSULE_CODE = "11014000";

    /**
     * EN: Code for Rectal cream.<br>
     * DE: Code für Rektalcreme.<br>
     * FR: Code de Crème rectale.<br>
     * IT: Code per Crema rettale.<br>
     */
    public static final String RECTAL_CREAM_CODE = "11001000";

    /**
     * EN: Code for Rectal emulsion.<br>
     * DE: Code für Rektalemulsion.<br>
     * FR: Code de Emulsion rectale.<br>
     * IT: Code per Emulsione rettale.<br>
     */
    public static final String RECTAL_EMULSION_CODE = "11007000";

    /**
     * EN: Code for Rectal foam.<br>
     * DE: Code für Rektalschaum.<br>
     * FR: Code de Mousse rectale.<br>
     * IT: Code per Schiuma rettale.<br>
     */
    public static final String RECTAL_FOAM_CODE = "11004000";

    /**
     * EN: Code for Rectal gel.<br>
     * DE: Code für Rektalgel.<br>
     * FR: Code de Gel rectal.<br>
     * IT: Code per Gel rettale.<br>
     */
    public static final String RECTAL_GEL_CODE = "11002000";

    /**
     * EN: Code for Rectal ointment.<br>
     * DE: Code für Rektalsalbe.<br>
     * FR: Code de Pommade rectale.<br>
     * IT: Code per Unguento rettale.<br>
     */
    public static final String RECTAL_OINTMENT_CODE = "11003000";

    /**
     * EN: Code for Rectal solution.<br>
     * DE: Code für Rektallösung.<br>
     * FR: Code de Solution rectale.<br>
     * IT: Code per Soluzione rettale.<br>
     */
    public static final String RECTAL_SOLUTION_CODE = "11005000";

    /**
     * EN: Code for Rectal suspension.<br>
     * DE: Code für Rektalsuspension.<br>
     * FR: Code de Suspension rectale.<br>
     * IT: Code per Sospensione rettale.<br>
     */
    public static final String RECTAL_SUSPENSION_CODE = "11006000";

    /**
     * EN: Code for Rectal tampon.<br>
     * DE: Code für Rektaltampon.<br>
     * FR: Code de Tampon rectal.<br>
     * IT: Code per Tampone rettale.<br>
     */
    public static final String RECTAL_TAMPON_CODE = "11015000";

    /**
     * EN: Code for Sealant.<br>
     * DE: Code für Gewebekleber.<br>
     * FR: Code de Colle.<br>
     * IT: Code per Adesivo tissutale.<br>
     */
    public static final String SEALANT_CODE = "12115000";

    /**
     * EN: Code for Sealant matrix.<br>
     * DE: Code für Versiegelungsmatrix.<br>
     * FR: Code de Matrice pour colle.<br>
     * IT: Code per Matrice per adesivo tissutale.<br>
     */
    public static final String SEALANT_MATRIX_CODE = "12115100";

    /**
     * EN: Code for Sealant powder.<br>
     * DE: Code für Gewebekleber.<br>
     * FR: Code de Poudre pour colle.<br>
     * IT: Code per Adesivo tissutale, polvere.<br>
     */
    public static final String SEALANT_POWDER_CODE = "12115200";

    /**
     * EN: Code for Shampoo.<br>
     * DE: Code für Shampoo.<br>
     * FR: Code de Shampoing.<br>
     * IT: Code per Shampoo.<br>
     */
    public static final String SHAMPOO_CODE = "10508000";

    /**
     * EN: Code for Soluble tablet.<br>
     * DE: Code für Tablette zur Herstellung einer Lösung zum Einnehmen.<br>
     * FR: Code de Comprimé pour solution buvable.<br>
     * IT: Code per Compressa solubile.<br>
     */
    public static final String SOLUBLE_TABLET_CODE = "10120000";

    /**
     * EN: Code for Solution for blood fraction modification.<br>
     * DE: Code für Lösung zur Modifikation einer Blutfraktion.<br>
     * FR: Code de Solution pour la préparation ex vivo de fractions sanguines.<br>
     * IT: Code per Soluzione per la modifica di frazione ematica.<br>
     */
    public static final String SOLUTION_FOR_BLOOD_FRACTION_MODIFICATION_CODE = "12103000";

    /**
     * EN: Code for Solution for cardioplegia.<br>
     * DE: Code für Kardioplege Lösung.<br>
     * FR: Code de Solution de cardioplégie.<br>
     * IT: Code per Soluzione per cardioplegia.<br>
     */
    public static final String SOLUTION_FOR_CARDIOPLEGIA_CODE = "11209500";

    /**
     * EN: Code for Solution for cardioplegia/organ preservation.<br>
     * DE: Code für Kardioplege Lösung/Organkonservierungslösung.<br>
     * FR: Code de Solution pour cardioplégie/préservation d'organe.<br>
     * IT: Code per Soluzione per cardioplegia/conservazione di organi.<br>
     */
    public static final String SOLUTION_FOR_CARDIOPLEGIA_ORGAN_PRESERVATION_CODE = "13107000";

    /**
     * EN: Code for Solution for dental cement.<br>
     * DE: Code für Lösung zur Herstellung eines Dentalzements.<br>
     * FR: Code de Solution pour ciment dentaire.<br>
     * IT: Code per Inserto periodontale.<br>
     */
    public static final String SOLUTION_FOR_DENTAL_CEMENT_CODE = "10414000";

    /**
     * EN: Code for Solution for haemodiafiltration.<br>
     * DE: Code für Hämodiafiltrationslösung.<br>
     * FR: Code de Solution pour hémodiafiltration.<br>
     * IT: Code per Soluzione per emofiltrazione.<br>
     */
    public static final String SOLUTION_FOR_HAEMODIAFILTRATION_CODE = "11403000";

    /**
     * EN: Code for Solution for haemodialysis.<br>
     * DE: Code für Hämodialyselösung.<br>
     * FR: Code de Solution pour hémodialyse.<br>
     * IT: Code per Soluzione per emodialisi.<br>
     */
    public static final String SOLUTION_FOR_HAEMODIALYSIS_CODE = "11404000";

    /**
     * EN: Code for Solution for haemodialysis/haemofiltration.<br>
     * DE: Code für Hämodialyselösung/Hämofiltrationslösung.<br>
     * FR: Code de Solution pour hémodialyse/hémofiltration.<br>
     * IT: Code per Soluzione per emodialisi/emofiltrazione.<br>
     */
    public static final String SOLUTION_FOR_HAEMODIALYSIS_HAEMOFILTRATION_CODE = "50057000";

    /**
     * EN: Code for Solution for haemofiltration.<br>
     * DE: Code für Hämofiltrationslösung.<br>
     * FR: Code de Solution pour hémofiltration.<br>
     * IT: Code per Soluzione per emofiltrazione.<br>
     */
    public static final String SOLUTION_FOR_HAEMOFILTRATION_CODE = "11402000";

    /**
     * EN: Code for Solution for infusion.<br>
     * DE: Code für Infusionslösung.<br>
     * FR: Code de Solution pour perfusion.<br>
     * IT: Code per Soluzione per infusione.<br>
     */
    public static final String SOLUTION_FOR_INFUSION_CODE = "11210000";

    /**
     * EN: Code for Solution for injection.<br>
     * DE: Code für Injektionslösung.<br>
     * FR: Code de Solution injectable.<br>
     * IT: Code per Soluzione iniettabile.<br>
     */
    public static final String SOLUTION_FOR_INJECTION_CODE = "11201000";

    /**
     * EN: Code for Solution for injection/infusion.<br>
     * DE: Code für Injektions-/Infusionslösung.<br>
     * FR: Code de Solution injectable/pour perfusion.<br>
     * IT: Code per Soluzione iniettabile o per infusione.<br>
     */
    public static final String SOLUTION_FOR_INJECTION_INFUSION_CODE = "50060000";

    /**
     * EN: Code for Solution for injection/skin-prick test.<br>
     * DE: Code für Injektionslösung/ Pricktestlösung.<br>
     * FR: Code de Solution injectable/ pour prick-test.<br>
     * IT: Code per Soluzione iniettabile/per skin-prick test.<br>
     */
    public static final String SOLUTION_FOR_INJECTION_SKIN_PRICK_TEST_CODE = "13051000";

    /**
     * EN: Code for Solution for intraocular irrigation.<br>
     * DE: Code für Lösung zur intraokularen Anwendung.<br>
     * FR: Code de Solution pour irrigation intraoculaire.<br>
     * IT: Code per Soluzione per irrigazione intraoculare.<br>
     */
    public static final String SOLUTION_FOR_INTRAOCULAR_IRRIGATION_CODE = "50073500";

    /**
     * EN: Code for Solution for iontophoresis.<br>
     * DE: Code für Lösung zur Iontophorese.<br>
     * FR: Code de Solution pour iontophorèse.<br>
     * IT: Code per Soluzione per iontoforesi.<br>
     */
    public static final String SOLUTION_FOR_IONTOPHORESIS_CODE = "10518000";

    /**
     * EN: Code for Solution for organ preservation.<br>
     * DE: Code für Organkonservierungslösung.<br>
     * FR: Code de Solution pour conservation d'organe.<br>
     * IT: Code per Soluzione per conservazione di organi.<br>
     */
    public static final String SOLUTION_FOR_ORGAN_PRESERVATION_CODE = "12112000";

    /**
     * EN: Code for Solution for peritoneal dialysis.<br>
     * DE: Code für Peritonealdialyselösung.<br>
     * FR: Code de Solution pour dialyse péritonéale.<br>
     * IT: Code per Soluzione per dialisi peritoneale.<br>
     */
    public static final String SOLUTION_FOR_PERITONEAL_DIALYSIS_CODE = "11401000";

    /**
     * EN: Code for Solution for provocation test.<br>
     * DE: Code für Provokationstestlösung.<br>
     * FR: Code de solution pour test de provocation.<br>
     * IT: Code per Soluzione per saggio di provocazione.<br>
     */
    public static final String SOLUTION_FOR_PROVOCATION_TEST_CODE = "12131000";

    /**
     * EN: Code for Solution for sealant.<br>
     * DE: Code für Lösung für Gewebekleber.<br>
     * FR: Code de Solution pour colle.<br>
     * IT: Code per Soluzione per adesivo tissutale.<br>
     */
    public static final String SOLUTION_FOR_SEALANT_CODE = "50061500";

    /**
     * EN: Code for Solution for skin-prick test.<br>
     * DE: Code für Pricktestlösung.<br>
     * FR: Code de solution pour prick-test.<br>
     * IT: Code per Soluzione per skin-prick test.<br>
     */
    public static final String SOLUTION_FOR_SKIN_PRICK_TEST_CODE = "10548000";

    /**
     * EN: Code for Solution for skin-scratch test.<br>
     * DE: Code für Scratchtestlösung.<br>
     * FR: Code de solution pour test intradermique.<br>
     * IT: Code per Soluzione per scarificazione.<br>
     */
    public static final String SOLUTION_FOR_SKIN_SCRATCH_TEST_CODE = "10549000";

    /**
     * EN: Code for Solution for solution for infusion.<br>
     * DE: Code für Lösung zur Herstellung einer Infusionslösung.<br>
     * FR: Code de Solution pour solution pour perfusion.<br>
     * IT: Code per Soluzione per soluzione per infusione.<br>
     */
    public static final String SOLUTION_FOR_SOLUTION_FOR_INFUSION_CODE = "13061000";

    /**
     * EN: Code for Solution for solution for injection.<br>
     * DE: Code für Lösung zur Herstellung einer Injektionslösung.<br>
     * FR: Code de Solution pour solution injectable.<br>
     * IT: Code per Soluzione per soluzione iniettabile.<br>
     */
    public static final String SOLUTION_FOR_SOLUTION_FOR_INJECTION_CODE = "13033000";

    /**
     * EN: Code for Solution for suspension for injection.<br>
     * DE: Code für Lösung zur Herstellung einer Injektionssuspension.<br>
     * FR: Code de Solution pour suspension injectable.<br>
     * IT: Code per Soluzione per sospensione iniettabile.<br>
     */
    public static final String SOLUTION_FOR_SUSPENSION_FOR_INJECTION_CODE = "13047000";

    /**
     * EN: Code for Solvent for...<br>
     * DE: Code für Lösungsmittel zur Herstellung...<br>
     * FR: Code de Solvant pour...<br>
     * IT: Code per Solvente per….<br>
     */
    public static final String SOLVENT_FOR_CODE = "13035000";

    /**
     * EN: Code for Solvent for parenteral use.<br>
     * DE: Code für Lösungsmittel zur Herstellung von Parenteralia.<br>
     * FR: Code de Solvant pour préparation parentérale.<br>
     * IT: Code per Solvente per uso parenterale.<br>
     */
    public static final String SOLVENT_FOR_PARENTERAL_USE_CODE = "11216000";

    /**
     * EN: Code for Solvent for solution for infusion.<br>
     * DE: Code für Lösungsmittel zur Herstellung einer Infusionslösung.<br>
     * FR: Code de Solvant pour solution pour perfusion.<br>
     * IT: Code per Solvente per soluzione per infusione.<br>
     */
    public static final String SOLVENT_FOR_SOLUTION_FOR_INFUSION_CODE = "50076000";

    /**
     * EN: Code for Solvent for solution for intraocular irrigation.<br>
     * DE: Code für Lösungsmittel zur Herstellung einer Lösung zur intraokularen Anwendung.<br>
     * FR: Code de Solvant pour solution pour irrigation intraoculaire.<br>
     * IT: Code per Solvente per soluzione per irrigazione intraoculare.<br>
     */
    public static final String SOLVENT_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION_CODE = "50074000";

    /**
     * EN: Code for Stomach irrigation.<br>
     * DE: Code für Magenspülflüssigkeit.<br>
     * FR: Code de Solution pour irrigation stomacale.<br>
     * IT: Code per Liquido per lavanda gastrica.<br>
     */
    public static final String STOMACH_IRRIGATION_CODE = "12114000";

    /**
     * EN: Code for Sublingual film.<br>
     * DE: Code für Schmelzfilm zur sublingualen Anwendung.<br>
     * FR: Code de Film sublinguale.<br>
     * IT: Code per Film sublinguale.<br>
     */
    public static final String SUBLINGUAL_FILM_CODE = "10317500";

    /**
     * EN: Code for Sublingual lyophilisate.<br>
     * DE: Code für Lyophilisat zur sublingualen Anwendung.<br>
     * FR: Code de Larves médicinales.<br>
     * IT: Code per Larva medicinale.<br>
     */
    public static final String SUBLINGUAL_LYOPHILISATE_CODE = "13127000";

    /**
     * EN: Code for Sublingual powder.<br>
     * DE: Code für Pulver zur sublingualen Anwendung.<br>
     * FR: Code de Poudre sublinguale.<br>
     * IT: Code per Polvere sublinguale.<br>
     */
    public static final String SUBLINGUAL_POWDER_CODE = "13105000";

    /**
     * EN: Code for Sublingual spray, emulsion.<br>
     * DE: Code für Sublingualspray, Emulsion.<br>
     * FR: Code de Emulsion pour pulvérisation sublinguale.<br>
     * IT: Code per Spray sublinguale, emulsione.<br>
     */
    public static final String SUBLINGUAL_SPRAY_EMULSION_CODE = "10309100";

    /**
     * EN: Code for Sublingual spray, solution.<br>
     * DE: Code für Sublingualspray, Lösung.<br>
     * FR: Code de Solution pour pulvérisation sublinguale.<br>
     * IT: Code per Spray sublinguale, soluzione.<br>
     */
    public static final String SUBLINGUAL_SPRAY_SOLUTION_CODE = "10309200";

    /**
     * EN: Code for Sublingual spray, suspension.<br>
     * DE: Code für Sublingualspray, Suspension.<br>
     * FR: Code de Suspension pour pulvérisation sublinguale.<br>
     * IT: Code per Spray sublinguale, sospensione.<br>
     */
    public static final String SUBLINGUAL_SPRAY_SUSPENSION_CODE = "10309300";

    /**
     * EN: Code for Sublingual tablet.<br>
     * DE: Code für Sublingualtablette.<br>
     * FR: Code de Comprimé sublingual.<br>
     * IT: Code per Compressa sublinguale.<br>
     */
    public static final String SUBLINGUAL_TABLET_CODE = "10318000";

    /**
     * EN: Code for Suppository.<br>
     * DE: Code für Zäpfchen.<br>
     * FR: Code de Suppositoire.<br>
     * IT: Code per Supposta.<br>
     */
    public static final String SUPPOSITORY_CODE = "11013000";

    /**
     * EN: Code for Suspension for emulsion for injection.<br>
     * DE: Code für Suspension zur Herstellung einer Emulsion zur Injektion.<br>
     * FR: Code de Suspension pour émulsion injectable.<br>
     * IT: Code per Sospensione per emulsione iniettabile.<br>
     */
    public static final String SUSPENSION_FOR_EMULSION_FOR_INJECTION_CODE = "13036000";

    /**
     * EN: Code for Suspension for injection.<br>
     * DE: Code für Injektionssuspension.<br>
     * FR: Code de Suspension injectable.<br>
     * IT: Code per Sospensione iniettabile.<br>
     */
    public static final String SUSPENSION_FOR_INJECTION_CODE = "11202000";

    /**
     * EN: Code for Suspension for oral suspension.<br>
     * DE: Code für Suspension zur Herstellung einer Suspension zum Einnehmen.<br>
     * FR: Code de Suspension pour suspension buvable.<br>
     * IT: Code per Sospensione per sospensione orale.<br>
     */
    public static final String SUSPENSION_FOR_ORAL_SUSPENSION_CODE = "13037000";

    /**
     * EN: Code for Suspension for suspension for injection.<br>
     * DE: Code für Suspension zur Herstellung einer Injektionssuspension.<br>
     * FR: Code de Suspension pour suspension injectable.<br>
     * IT: Code per Sospensione per sospensione iniettabile.<br>
     */
    public static final String SUSPENSION_FOR_SUSPENSION_FOR_INJECTION_CODE = "13039000";

    /**
     * EN: Code for Syrup.<br>
     * DE: Code für Sirup.<br>
     * FR: Code de Sirop.<br>
     * IT: Code per Sciroppo.<br>
     */
    public static final String SYRUP_CODE = "10117000";

    /**
     * EN: Code for Tablet.<br>
     * DE: Code für Tablette.<br>
     * FR: Code de Comprimé.<br>
     * IT: Code per Compressa.<br>
     */
    public static final String TABLET_CODE = "10219000";

    /**
     * EN: Code for Tablet for cutaneous solution.<br>
     * DE: Code für Tablette zur Herstellung einer Lösung zur Anwendung auf der Haut.<br>
     * FR: Code de Comprimé pour solution cutanée.<br>
     * IT: Code per Compressa per soluzione cutanea.<br>
     */
    public static final String TABLET_FOR_CUTANEOUS_SOLUTION_CODE = "13066000";

    /**
     * EN: Code for Tablet for rectal solution.<br>
     * DE: Code für Tablette zur Herstellung einer Rektallösung.<br>
     * FR: Code de Comprimé pour solution rectale.<br>
     * IT: Code per Compressa per soluzione rettale.<br>
     */
    public static final String TABLET_FOR_RECTAL_SOLUTION_CODE = "11011000";

    /**
     * EN: Code for Tablet for rectal suspension.<br>
     * DE: Code für Tablette zur Herstellung einer Rektalsuspension.<br>
     * FR: Code de Comprimé pour suspension rectale.<br>
     * IT: Code per Compressa per sospensione rettale.<br>
     */
    public static final String TABLET_FOR_RECTAL_SUSPENSION_CODE = "11012000";

    /**
     * EN: Code for Tablet for vaginal solution.<br>
     * DE: Code für Tablette zur Herstellung einer Vaginallösung.<br>
     * FR: Code de Comprimé pour solution vaginale.<br>
     * IT: Code per Compressa per soluzione vaginale.<br>
     */
    public static final String TABLET_FOR_VAGINAL_SOLUTION_CODE = "10908000";

    /**
     * EN: Code for Tablet with sensor.<br>
     * DE: Code für Tablette mit Sensor.<br>
     * FR: Code de Comprimé avec capteur.<br>
     * IT: Code per Compressa con sensore.<br>
     */
    public static final String TABLET_WITH_SENSOR_CODE = "13118000";

    /**
     * EN: Code for Toothpaste.<br>
     * DE: Code für Zahnpaste.<br>
     * FR: Code de Pâte dentifrice.<br>
     * IT: Code per Pasta dentifricia.<br>
     */
    public static final String TOOTHPASTE_CODE = "10409000";

    /**
     * EN: Code for Transdermal gel.<br>
     * DE: Code für Transdermales Gel.<br>
     * FR: Code de Gel transdermique.<br>
     * IT: Code per Gel transdermico.<br>
     */
    public static final String TRANSDERMAL_GEL_CODE = "10546250";

    /**
     * EN: Code for Transdermal ointment.<br>
     * DE: Code für Transdermale Salbe.<br>
     * FR: Code de Pommade transdermique.<br>
     * IT: Code per Unguento transdermico.<br>
     */
    public static final String TRANSDERMAL_OINTMENT_CODE = "13102000";

    /**
     * EN: Code for Transdermal patch.<br>
     * DE: Code für transdermales Pflaster.<br>
     * FR: Code de Patch transdermique.<br>
     * IT: Code per Cerotto transdermico.<br>
     */
    public static final String TRANSDERMAL_PATCH_CODE = "10519000";

    /**
     * EN: Code for Transdermal solution.<br>
     * DE: Code für transdermale Lösung.<br>
     * FR: Code de Solution transdermique.<br>
     * IT: Code per Soluzione transdermica.<br>
     */
    public static final String TRANSDERMAL_SOLUTION_CODE = "10546400";

    /**
     * EN: Code for Transdermal spray, solution.<br>
     * DE: Code für transdermales Spray, Lösung.<br>
     * FR: Code de Solution pour pulvérisation transdermique.<br>
     * IT: Code per Spray transdermico, soluzione.<br>
     */
    public static final String TRANSDERMAL_SPRAY_SOLUTION_CODE = "10546500";

    /**
     * EN: Code for Transdermal system.<br>
     * DE: Code für transdermales System.<br>
     * FR: Code de système transdermique.<br>
     * IT: Code per Sistema transdermico.<br>
     */
    public static final String TRANSDERMAL_SYSTEM_CODE = "10547000";

    /**
     * EN: Code for Urethral emulsion.<br>
     * DE: Code für Emulsion zur Anwendung in der Harnröhre.<br>
     * FR: Code de Emulsion urétrale.<br>
     * IT: Code per Emulsione uretrale.<br>
     */
    public static final String URETHRAL_EMULSION_CODE = "13077000";

    /**
     * EN: Code for Urethral gel.<br>
     * DE: Code für Gel zur Anwendung in der Harnröhre.<br>
     * FR: Code de Gel urétral.<br>
     * IT: Code per Gel uretrale.<br>
     */
    public static final String URETHRAL_GEL_CODE = "11504000";

    /**
     * EN: Code for Urethral ointment.<br>
     * DE: Code für Salbe zur Anwendung in der Harnröhre.<br>
     * FR: Code de Pommade urétrale.<br>
     * IT: Code per Unguento uretrale.<br>
     */
    public static final String URETHRAL_OINTMENT_CODE = "13123000";

    /**
     * EN: Code for Urethral stick.<br>
     * DE: Code für Stäbchen zur Anwendung in der Harnröhre.<br>
     * FR: Code de Bâton pour usage urétral.<br>
     * IT: Code per Bastoncino uretrale.<br>
     */
    public static final String URETHRAL_STICK_CODE = "11505000";

    /**
     * EN: Code for Vaginal capsule, hard.<br>
     * DE: Code für Hartkapsel zur vaginalen Anwendung.<br>
     * FR: Code de Gélule vaginale.<br>
     * IT: Code per Capsula rigida vaginale.<br>
     */
    public static final String VAGINAL_CAPSULE_HARD_CODE = "10910000";

    /**
     * EN: Code for Vaginal capsule, soft.<br>
     * DE: Code für Weichkapsel zur vaginalen Anwendung.<br>
     * FR: Code de Capsule molle vaginale.<br>
     * IT: Code per Capsula molle vaginale.<br>
     */
    public static final String VAGINAL_CAPSULE_SOFT_CODE = "10911000";

    /**
     * EN: Code for Vaginal cream.<br>
     * DE: Code für Vaginalcreme.<br>
     * FR: Code de Crème vaginale.<br>
     * IT: Code per Crema vaginale.<br>
     */
    public static final String VAGINAL_CREAM_CODE = "10901000";

    /**
     * EN: Code for Vaginal delivery system.<br>
     * DE: Code für vaginales Wirkstofffreisetzungssystem.<br>
     * FR: Code de Système de diffusion vaginal.<br>
     * IT: Code per Dispositivo vaginale.<br>
     */
    public static final String VAGINAL_DELIVERY_SYSTEM_CODE = "10915000";

    /**
     * EN: Code for Vaginal emulsion.<br>
     * DE: Code für Vaginalemulsion.<br>
     * FR: Code de Emulsion vaginale.<br>
     * IT: Code per Emulsione vaginale.<br>
     */
    public static final String VAGINAL_EMULSION_CODE = "10907000";

    /**
     * EN: Code for Vaginal foam.<br>
     * DE: Code für Vaginalschaum.<br>
     * FR: Code de Mousse vaginale.<br>
     * IT: Code per Schiuma vaginale.<br>
     */
    public static final String VAGINAL_FOAM_CODE = "10904000";

    /**
     * EN: Code for Vaginal gel.<br>
     * DE: Code für Vaginalgel.<br>
     * FR: Code de Gel vaginal.<br>
     * IT: Code per Gel vaginale.<br>
     */
    public static final String VAGINAL_GEL_CODE = "10902000";

    /**
     * EN: Code for Vaginal ointment.<br>
     * DE: Code für Vaginalsalbe.<br>
     * FR: Code de Pommade vaginale.<br>
     * IT: Code per Unguento vaginale.<br>
     */
    public static final String VAGINAL_OINTMENT_CODE = "10903000";

    /**
     * EN: Code for Vaginal solution.<br>
     * DE: Code für Vaginallösung.<br>
     * FR: Code de Solution vaginale.<br>
     * IT: Code per Soluzione vaginale.<br>
     */
    public static final String VAGINAL_SOLUTION_CODE = "10905000";

    /**
     * EN: Code for Vaginal suspension.<br>
     * DE: Code für Vaginalsuspension.<br>
     * FR: Code de Suspension vaginale.<br>
     * IT: Code per Sospensione vaginale.<br>
     */
    public static final String VAGINAL_SUSPENSION_CODE = "10906000";

    /**
     * EN: Code for Vaginal tablet.<br>
     * DE: Code für Vaginaltablette.<br>
     * FR: Code de Comprimé vaginal.<br>
     * IT: Code per Compressa vaginale.<br>
     */
    public static final String VAGINAL_TABLET_CODE = "10912000";

    /**
     * EN: Code for Wound stick.<br>
     * DE: Code für Wundstäbchen.<br>
     * FR: Code de Bâton intralésionnel.<br>
     * IT: Code per Matita emostatica.<br>
     */
    public static final String WOUND_STICK_CODE = "12104000";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.3";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "PharmaceuticalDoseFormEDQM";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "0.4.0.127.0.16.1.1.2.1";

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
    PharmaceuticalDoseFormEdqm(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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

    /**
     * Returns the code system, as used in FHIR.
     */
    @Override
    @NonNull
    public String getFhirSystem() {
        if (this.getCodeSystemId().startsWith("http")) {
            return this.getCodeSystemId();
        }
        return Oids.PREFIX_OID + this.getCodeSystemId();
    }

    /**
     * Returns the enum value as a FHIR Coding.
     */
    @Override
    @NonNull
    public Coding getCoding() {
        return new Coding(this.getFhirSystem(),
                          this.getCodeValue(),
                          this.displayNames[0]);
    }

    /**
     * Returns the enum value as a FHIR CodeableConcept.
     */
    @Override
    @NonNull
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept().setText(this.displayNames[0]).addCoding(this.getCoding());
    }

    /**
     * Returns the enum value as a FHIR Coding, translated in the requested language.
     */
    @Override
    @NonNull
    public Coding getCoding(final LanguageCode languageCode) {
        return new Coding(this.getFhirSystem(),
                          this.getCodeValue(),
                          this.getDisplayName(languageCode));
    }

    /**
     * Returns the enum value as a FHIR CodeableConcept, translated in the requested language.
     */
    @Override
    @NonNull
    public CodeableConcept getCodeableConcept(final LanguageCode languageCode) {
        return new CodeableConcept().setText(this.getDisplayName(languageCode)).addCoding(this.getCoding(languageCode));
    }

    /**
     * Compares the enum value to the given FHIR Coding.
     *
     * @param coding The FHIR Coding to be compared.
     * @return {@code true} if they have the same system and value, {@code false} otherwise.
     */
    @Override
    public boolean isEqualTo(final Coding coding) {
        return this.getFhirSystem().equals(coding.getSystem()) && this.getCodeValue().equals(coding.getCode());
    }

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static PharmaceuticalDoseFormEdqm getEnum(@Nullable final String code) {
        for (final PharmaceuticalDoseFormEdqm x : values()) {
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
            Enum.valueOf(PharmaceuticalDoseFormEdqm.class,
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
        for (final PharmaceuticalDoseFormEdqm x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the Enum with a given FHIR Coding.
     *
     * @param coding The FHIR Coding.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static PharmaceuticalDoseFormEdqm getEnum(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given FHIR Coding is in this value set.
     *
     * @param coding The FHIR Coding.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return true;
            }
        }
        return false;
    }
}
