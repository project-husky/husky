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
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

/**
 * Enumeration of UnitCode values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.11.83<br>
 * Effective date: 2024-03-26 15:58<br>
 * Version: 2024<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-06-24")
public enum UnitCode implements ValueSetEnumInterface, FhirValueSetEnumInterface {

    /**
     * EN: a.<br>
     * DE: a.<br>
     * FR: a.<br>
     * IT: a.<br>
     */
    A("a",
      "http://unitsofmeasure.org",
      "Year",
      "a",
      "a",
      "a",
      "a"),
    /**
     * EN: Actuation.<br>
     * DE: Hub.<br>
     * FR: bouffée.<br>
     * IT: erogazione.<br>
     */
    ACTUATION("732981002",
              "http://snomed.info/sct",
              "Actuation (unit of presentation)",
              "Actuation",
              "Hub",
              "bouffée",
              "erogazione"),
    /**
     * EN: Ampule.<br>
     * DE: Ampulle.<br>
     * FR: ampoule.<br>
     * IT: fiala.<br>
     */
    AMPULE("732978007",
           "http://snomed.info/sct",
           "Ampule (unit of presentation)",
           "Ampule",
           "Ampulle",
           "ampoule",
           "fiala"),
    /**
     * EN: Application - unit of product usage (qualifier value).<br>
     * DE: Application - unit of product usage (qualifier value).<br>
     * FR: Application - unit of product usage (qualifier value).<br>
     * IT: Application - unit of product usage (qualifier value).<br>
     */
    APPLICATION_UNIT_OF_PRODUCT_USAGE_QUALIFIER_VALUE("413568008",
                                                      "http://snomed.info/sct",
                                                      "Application - unit of product usage (qualifier value)",
                                                      "Application - unit of product usage (qualifier value)",
                                                      "Application - unit of product usage (qualifier value)",
                                                      "Application - unit of product usage (qualifier value)",
                                                      "Application - unit of product usage (qualifier value)"),
    /**
     * EN: Applicator.<br>
     * DE: Applikator.<br>
     * FR: applicateur.<br>
     * IT: applicatore.<br>
     */
    APPLICATOR("732980001",
               "http://snomed.info/sct",
               "Applicator (unit of presentation)",
               "Applicator",
               "Applikator",
               "applicateur",
               "applicatore"),
    /**
     * EN: Bag.<br>
     * DE: Tasche.<br>
     * FR: sac.<br>
     * IT: sacca.<br>
     */
    BAG("732982009",
        "http://snomed.info/sct",
        "Bag (unit of presentation)",
        "Bag",
        "Tasche",
        "sac",
        "sacca"),
    /**
     * EN: Barrel.<br>
     * DE: Kanister.<br>
     * FR: fût.<br>
     * IT: fusto.<br>
     */
    BARREL("732983004",
           "http://snomed.info/sct",
           "Barrel (unit of presentation)",
           "Barrel",
           "Kanister",
           "fût",
           "fusto"),
    /**
     * EN: Blister.<br>
     * DE: Blisterpackung.<br>
     * FR: plaquette.<br>
     * IT: blister.<br>
     */
    BLISTER("732984005",
            "http://snomed.info/sct",
            "Blister (unit of presentation)",
            "Blister",
            "Blisterpackung",
            "plaquette",
            "blister"),
    /**
     * EN: Block.<br>
     * DE: Block.<br>
     * FR: bloc.<br>
     * IT: blocco.<br>
     */
    BLOCK("732985006",
          "http://snomed.info/sct",
          "Block (unit of presentation)",
          "Block",
          "Block",
          "bloc",
          "blocco"),
    /**
     * EN: Bottle.<br>
     * DE: Flasche.<br>
     * FR: flacon.<br>
     * IT: flacone.<br>
     */
    BOTTLE("732986007",
           "http://snomed.info/sct",
           "Bottle (unit of presentation)",
           "Bottle",
           "Flasche",
           "flacon",
           "flacone"),
    /**
     * EN: Bq.<br>
     * DE: Bq.<br>
     * FR: Bq.<br>
     * IT: Bq.<br>
     */
    BQ("Bq",
       "http://unitsofmeasure.org",
       "Becquerel",
       "Bq",
       "Bq",
       "Bq",
       "Bq"),
    /**
     * EN: Cachet.<br>
     * DE: Oblatenkapsel.<br>
     * FR: cachet.<br>
     * IT: cachet.<br>
     */
    CACHET("732987003",
           "http://snomed.info/sct",
           "Cachet (unit of presentation)",
           "Cachet",
           "Oblatenkapsel",
           "cachet",
           "cachet"),
    /**
     * EN: Capsule.<br>
     * DE: Kapsel.<br>
     * FR: capsule.<br>
     * IT: capsula.<br>
     */
    CAPSULE("732937005",
            "http://snomed.info/sct",
            "Capsule (unit of presentation)",
            "Capsule",
            "Kapsel",
            "capsule",
            "capsula"),
    /**
     * EN: Cartridge.<br>
     * DE: Patrone.<br>
     * FR: cartouche.<br>
     * IT: cartuccia.<br>
     */
    CARTRIDGE("732988008",
              "http://snomed.info/sct",
              "Cartridge (unit of presentation)",
              "Cartridge",
              "Patrone",
              "cartouche",
              "cartuccia"),
    /**
     * EN: CFU.<br>
     * DE: CFU.<br>
     * FR: CFU.<br>
     * IT: CFU.<br>
     */
    CFU("[CFU]",
        "http://unitsofmeasure.org",
        "Colony Forming Units",
        "CFU",
        "CFU",
        "CFU",
        "CFU"),
    /**
     * EN: Chewing gum.<br>
     * DE: Kaugummi.<br>
     * FR: gomme à mâcher.<br>
     * IT: gomma da masticare.<br>
     */
    CHEWING_GUM("732989000",
                "http://snomed.info/sct",
                "Chewing gum (unit of presentation)",
                "Chewing gum",
                "Kaugummi",
                "gomme à mâcher",
                "gomma da masticare"),
    /**
     * EN: cm.<br>
     * DE: cm.<br>
     * FR: cm.<br>
     * IT: cm.<br>
     */
    CM("cm",
       "http://unitsofmeasure.org",
       "centimeter",
       "cm",
       "cm",
       "cm",
       "cm"),
    /**
     * EN: cm2.<br>
     * DE: cm2.<br>
     * FR: cm2.<br>
     * IT: cm2.<br>
     */
    CM2("cm2",
        "http://unitsofmeasure.org",
        "square centimeter",
        "cm2",
        "cm2",
        "cm2",
        "cm2"),
    /**
     * EN: cm3.<br>
     * DE: cm3.<br>
     * FR: cm3.<br>
     * IT: cm3.<br>
     */
    CM3("cm3",
        "http://unitsofmeasure.org",
        "cubic centimeter",
        "cm3",
        "cm3",
        "cm3",
        "cm3"),
    /**
     * EN: Container.<br>
     * DE: Behältnis.<br>
     * FR: récipient.<br>
     * IT: contenitore.<br>
     */
    CONTAINER("732990009",
              "http://snomed.info/sct",
              "Container (unit of presentation)",
              "Container",
              "Behältnis",
              "récipient",
              "contenitore"),
    /**
     * EN: Cup.<br>
     * DE: Messbecher.<br>
     * FR: godet.<br>
     * IT: bicchiere dosatore.<br>
     */
    CUP("732991008",
        "http://snomed.info/sct",
        "Cup (unit of presentation)",
        "Cup",
        "Messbecher",
        "godet",
        "bicchiere dosatore"),
    /**
     * EN: Cylinder.<br>
     * DE: Zylinder.<br>
     * FR: cylindre.<br>
     * IT: cilindro.<br>
     */
    CYLINDER("732992001",
             "http://snomed.info/sct",
             "Cylinder (unit of presentation)",
             "Cylinder",
             "Zylinder",
             "cylindre",
             "cilindro"),
    /**
     * EN: d.<br>
     * DE: d.<br>
     * FR: d.<br>
     * IT: d.<br>
     */
    D("d",
      "http://unitsofmeasure.org",
      "Day",
      "d",
      "d",
      "d",
      "d"),
    /**
     * EN: Dose.<br>
     * DE: Dos.<br>
     * FR: dose.<br>
     * IT: dose.<br>
     */
    DOSE("408102007",
         "http://snomed.info/sct",
         "Dose",
         "Dose",
         "Dos",
         "dose",
         "dose"),
    /**
     * EN: Dressing.<br>
     * DE: Verband.<br>
     * FR: compresse.<br>
     * IT: garza.<br>
     */
    DRESSING("732993006",
             "http://snomed.info/sct",
             "Dressing (unit of presentation)",
             "Dressing",
             "Verband",
             "compresse",
             "garza"),
    /**
     * EN: Drop.<br>
     * DE: Tropfen.<br>
     * FR: goutte.<br>
     * IT: goccia.<br>
     */
    DROP("732994000",
         "http://snomed.info/sct",
         "Drop (unit of presentation)",
         "Drop",
         "Tropfen",
         "goutte",
         "goccia"),
    /**
     * EN: Film.<br>
     * DE: Film.<br>
     * FR: film.<br>
     * IT: film.<br>
     */
    FILM("732995004",
         "http://snomed.info/sct",
         "Film (unit of presentation)",
         "Film",
         "Film",
         "film",
         "film"),
    /**
     * EN: g.<br>
     * DE: g.<br>
     * FR: g.<br>
     * IT: g.<br>
     */
    G("g",
      "http://unitsofmeasure.org",
      "gram",
      "g",
      "g",
      "g",
      "g"),
    /**
     * EN: GBq.<br>
     * DE: GBq.<br>
     * FR: GBq.<br>
     * IT: GBq.<br>
     */
    GBQ("GBq",
        "http://unitsofmeasure.org",
        "gigaBecquerel",
        "GBq",
        "GBq",
        "GBq",
        "GBq"),
    /**
     * EN: h.<br>
     * DE: h.<br>
     * FR: h.<br>
     * IT: h.<br>
     */
    H("h",
      "http://unitsofmeasure.org",
      "Hour",
      "h",
      "h",
      "h",
      "h"),
    /**
     * EN: Implant.<br>
     * DE: Implantat.<br>
     * FR: implant.<br>
     * IT: impianto.<br>
     */
    IMPLANT("732996003",
            "http://snomed.info/sct",
            "Implant (unit of presentation)",
            "Implant",
            "Implantat",
            "implant",
            "impianto"),
    /**
     * EN: Inhaler.<br>
     * DE: Inhalator.<br>
     * FR: inhalateur.<br>
     * IT: inalatore.<br>
     */
    INHALER("732997007",
            "http://snomed.info/sct",
            "Inhaler (unit of presentation)",
            "Inhaler",
            "Inhalator",
            "inhalateur",
            "inalatore"),
    /**
     * EN: Insert.<br>
     * DE: Insert.<br>
     * FR: insert.<br>
     * IT: inserto.<br>
     */
    INSERT("732998002",
           "http://snomed.info/sct",
           "Insert (unit of presentation)",
           "Insert",
           "Insert",
           "insert",
           "inserto"),
    /**
     * EN: international unit.<br>
     * DE: Internationale Einheit.<br>
     * FR: unité(s) internationale(s).<br>
     * IT: unità internazionale(i).<br>
     */
    INTERNATIONAL_UNIT("[iU]",
                       "http://unitsofmeasure.org",
                       "international unit",
                       "international unit",
                       "Internationale Einheit",
                       "unité(s) internationale(s)",
                       "unità internazionale(i)"),
    /**
     * EN: Jar.<br>
     * DE: Weithalsgefäss.<br>
     * FR: pot.<br>
     * IT: vasetto.<br>
     */
    JAR("732999005",
        "http://snomed.info/sct",
        "Jar (unit of presentation)",
        "Jar",
        "Weithalsgefäss",
        "pot",
        "vasetto"),
    /**
     * EN: kBq.<br>
     * DE: kBq.<br>
     * FR: kBq.<br>
     * IT: kBq.<br>
     */
    KBQ("kBq",
        "http://unitsofmeasure.org",
        "kiloBecquerel",
        "kBq",
        "kBq",
        "kBq",
        "kBq"),
    /**
     * EN: kcal.<br>
     * DE: kcal.<br>
     * FR: kcal.<br>
     * IT: kcal.<br>
     */
    KCAL("kcal",
         "http://unitsofmeasure.org",
         "kilocalorie",
         "kcal",
         "kcal",
         "kcal",
         "kcal"),
    /**
     * EN: kg.<br>
     * DE: kg.<br>
     * FR: kg.<br>
     * IT: kg.<br>
     */
    KG("kg",
       "http://unitsofmeasure.org",
       "kilogram",
       "kg",
       "kg",
       "kg",
       "kg"),
    /**
     * EN: kJ.<br>
     * DE: kJ.<br>
     * FR: kJ.<br>
     * IT: kJ.<br>
     */
    KJ("kJ",
       "http://unitsofmeasure.org",
       "kilojoule",
       "kJ",
       "kJ",
       "kJ",
       "kJ"),
    /**
     * EN: lt.<br>
     * DE: lt.<br>
     * FR: lt.<br>
     * IT: l.<br>
     */
    LT("L",
       "http://unitsofmeasure.org",
       "liter",
       "lt",
       "lt",
       "lt",
       "l"),
    /**
     * EN: Lyophilisate.<br>
     * DE: Lyophilisat.<br>
     * FR: lyophilisat.<br>
     * IT: liofilizzato.<br>
     */
    LYOPHILISATE("733001005",
                 "http://snomed.info/sct",
                 "Lyophilisate (unit of presentation)",
                 "Lyophilisate",
                 "Lyophilisat",
                 "lyophilisat",
                 "liofilizzato"),
    /**
     * EN: Matrix.<br>
     * DE: Matrix.<br>
     * FR: matrice.<br>
     * IT: matrice.<br>
     */
    MATRIX("733002003",
           "http://snomed.info/sct",
           "Matrix (unit of presentation)",
           "Matrix",
           "Matrix",
           "matrice",
           "matrice"),
    /**
     * EN: MBq.<br>
     * DE: MBq.<br>
     * FR: MBq.<br>
     * IT: MBq.<br>
     */
    MBQ("MBq",
        "http://unitsofmeasure.org",
        "megaBecquerel",
        "MBq",
        "MBq",
        "MBq",
        "MBq"),
    /**
     * EN: meq.<br>
     * DE: meq.<br>
     * FR: mEq.<br>
     * IT: mEq.<br>
     */
    MEQ("meq",
        "http://unitsofmeasure.org",
        "milliequivalent",
        "meq",
        "meq",
        "mEq",
        "mEq"),
    /**
     * EN: mg.<br>
     * DE: mg.<br>
     * FR: mg.<br>
     * IT: mg.<br>
     */
    MG("mg",
       "http://unitsofmeasure.org",
       "milligram",
       "mg",
       "mg",
       "mg",
       "mg"),
    /**
     * EN: MillionInternationalUnit.<br>
     * DE: MioUI.<br>
     * FR: MioUI.<br>
     * IT: MioUI.<br>
     */
    MILLIONINTERNATIONALUNIT("10*6.[iU]",
                             "http://unitsofmeasure.org",
                             "MillionInternationalUnit",
                             "MillionInternationalUnit",
                             "MioUI",
                             "MioUI",
                             "MioUI"),
    /**
     * EN: min.<br>
     * DE: min.<br>
     * FR: min.<br>
     * IT: min.<br>
     */
    MIN("min",
        "http://unitsofmeasure.org",
        "Minute",
        "min",
        "min",
        "min",
        "min"),
    /**
     * EN: MioU.<br>
     * DE: MioU.<br>
     * FR: MioU.<br>
     * IT: MioU.<br>
     */
    MIOU("396186001",
         "http://snomed.info/sct",
         "(the number ten for arbitrary powers ^ 6) * Unit",
         "MioU",
         "MioU",
         "MioU",
         "MioU"),
    /**
     * EN: ml.<br>
     * DE: ml.<br>
     * FR: ml.<br>
     * IT: ml.<br>
     */
    ML("mL",
       "http://unitsofmeasure.org",
       "milliliter",
       "ml",
       "ml",
       "ml",
       "ml"),
    /**
     * EN: mm2.<br>
     * DE: mm2.<br>
     * FR: mm2.<br>
     * IT: mm2.<br>
     */
    MM2("mm2",
        "http://unitsofmeasure.org",
        "square millimeter",
        "mm2",
        "mm2",
        "mm2",
        "mm2"),
    /**
     * EN: mmol.<br>
     * DE: mmol.<br>
     * FR: mmol.<br>
     * IT: mmol.<br>
     */
    MMOL("mmol",
         "http://unitsofmeasure.org",
         "millimole",
         "mmol",
         "mmol",
         "mmol",
         "mmol"),
    /**
     * EN: mo.<br>
     * DE: mo.<br>
     * FR: mo.<br>
     * IT: mo.<br>
     */
    MO("mo",
       "http://unitsofmeasure.org",
       "Month",
       "mo",
       "mo",
       "mo",
       "mo"),
    /**
     * EN: mol.<br>
     * DE: mol.<br>
     * FR: mol.<br>
     * IT: mol.<br>
     */
    MOL("mol",
        "http://unitsofmeasure.org",
        "mole",
        "mol",
        "mol",
        "mol",
        "mol"),
    /**
     * EN: ng.<br>
     * DE: ng.<br>
     * FR: ng.<br>
     * IT: ng.<br>
     */
    NG("ng",
       "http://unitsofmeasure.org",
       "nanogram",
       "ng",
       "ng",
       "ng",
       "ng"),
    /**
     * EN: nl.<br>
     * DE: nl.<br>
     * FR: nl.<br>
     * IT: nl.<br>
     */
    NL("nL",
       "http://unitsofmeasure.org",
       "nanoliter",
       "nl",
       "nl",
       "nl",
       "nl"),
    /**
     * EN: nmol.<br>
     * DE: nmol.<br>
     * FR: nmol.<br>
     * IT: nmol.<br>
     */
    NMOL("nmol",
         "http://unitsofmeasure.org",
         "nanomole",
         "nmol",
         "nmol",
         "nmol",
         "nmol"),
    /**
     * EN: Package.<br>
     * DE: Packung.<br>
     * FR: emballage.<br>
     * IT: confezione.<br>
     */
    PACKAGE("1681000175101",
            "http://snomed.info/sct",
            "Package",
            "Package",
            "Packung",
            "emballage",
            "confezione"),
    /**
     * EN: Pad.<br>
     * DE: Pad.<br>
     * FR: tampon applicateur.<br>
     * IT: tampone.<br>
     */
    PAD("733003008",
        "http://snomed.info/sct",
        "Pad (unit of presentation)",
        "Pad",
        "Pad",
        "tampon applicateur",
        "tampone"),
    /**
     * EN: Pastille.<br>
     * DE: Pastille.<br>
     * FR: pastille molle.<br>
     * IT: pastiglia molle.<br>
     */
    PASTILLE("733004002",
             "http://snomed.info/sct",
             "Pastille (unit of presentation)",
             "Pastille",
             "Pastille",
             "pastille molle",
             "pastiglia molle"),
    /**
     * EN: Patch.<br>
     * DE: Patch.<br>
     * FR: patch.<br>
     * IT: cerotto.<br>
     */
    PATCH("733005001",
          "http://snomed.info/sct",
          "Patch (unit of presentation)",
          "Patch",
          "Patch",
          "patch",
          "cerotto"),
    /**
     * EN: Pen.<br>
     * DE: Pen.<br>
     * FR: stylo.<br>
     * IT: penna.<br>
     */
    PEN("733006000",
        "http://snomed.info/sct",
        "Pen (unit of presentation)",
        "Pen",
        "Pen",
        "stylo",
        "penna"),
    /**
     * EN: %.<br>
     * DE: %.<br>
     * FR: %.<br>
     * IT: %.<br>
     */
    PERCENT("%",
            "http://unitsofmeasure.org",
            "percent",
            "%",
            "%",
            "%",
            "%"),
    /**
     * EN: Pessary.<br>
     * DE: Pessar.<br>
     * FR: ovule.<br>
     * IT: ovulo.<br>
     */
    PESSARY("733007009",
            "http://snomed.info/sct",
            "Pessary (unit of presentation)",
            "Pessary",
            "Pessar",
            "ovule",
            "ovulo"),
    /**
     * EN: Piece(s).<br>
     * DE: Stk.<br>
     * FR: pce.<br>
     * IT: pz.<br>
     */
    PIECE("246205007",
          "http://snomed.info/sct",
          "Quantity (attribute)",
          "Piece(s)",
          "Stk",
          "pce",
          "pz"),
    /**
     * EN: Pillule.<br>
     * DE: Streukügelchen.<br>
     * FR: granule.<br>
     * IT: granuli.<br>
     */
    PILLULE("733008004",
            "http://snomed.info/sct",
            "Pillule (unit of presentation)",
            "Pillule",
            "Streukügelchen",
            "granule",
            "granuli"),
    /**
     * EN: Pipette.<br>
     * DE: Pipette.<br>
     * FR: pipette.<br>
     * IT: pipetta.<br>
     */
    PIPETTE("733009007",
            "http://snomed.info/sct",
            "Pipette (unit of presentation)",
            "Pipette",
            "Pipette",
            "pipette",
            "pipetta"),
    /**
     * EN: Plaster.<br>
     * DE: Pflaster.<br>
     * FR: emplâtre.<br>
     * IT: cerotto.<br>
     */
    PLASTER("733010002",
            "http://snomed.info/sct",
            "Plaster (unit of presentation)",
            "Plaster",
            "Pflaster",
            "emplâtre",
            "cerotto"),
    /**
     * EN: Plug.<br>
     * DE: Einsatz.<br>
     * FR: support poreux.<br>
     * IT: supporto.<br>
     */
    PLUG("733011003",
         "http://snomed.info/sct",
         "Plug (unit of presentation)",
         "Plug",
         "Einsatz",
         "support poreux",
         "supporto"),
    /**
     * EN: Pouch.<br>
     * DE: Beutelchen.<br>
     * FR: pochette.<br>
     * IT: sachetta.<br>
     */
    POUCH("733012005",
          "http://snomed.info/sct",
          "Pouch (unit of presentation)",
          "Pouch",
          "Beutelchen",
          "pochette",
          "sachetta"),
    /**
     * EN: ppm.<br>
     * DE: ppm.<br>
     * FR: ppm.<br>
     * IT: ppm.<br>
     */
    PPM("[ppm]",
        "http://unitsofmeasure.org",
        "Parts Per Million",
        "ppm",
        "ppm",
        "ppm",
        "ppm"),
    /**
     * EN: Sachet.<br>
     * DE: Beutel.<br>
     * FR: sachet.<br>
     * IT: bustina.<br>
     */
    SACHET("733013000",
           "http://snomed.info/sct",
           "Sachet (unit of presentation)",
           "Sachet",
           "Beutel",
           "sachet",
           "bustina"),
    /**
     * EN: sec.<br>
     * DE: sec.<br>
     * FR: sec.<br>
     * IT: sec.<br>
     */
    SEC("s",
        "http://unitsofmeasure.org",
        "Second",
        "sec",
        "sec",
        "sec",
        "sec"),
    /**
     * EN: Sponge.<br>
     * DE: Schwämmchen.<br>
     * FR: eponge.<br>
     * IT: spugna.<br>
     */
    SPONGE("733014006",
           "http://snomed.info/sct",
           "Sponge (unit of presentation)",
           "Sponge",
           "Schwämmchen",
           "eponge",
           "spugna"),
    /**
     * EN: Spoonful.<br>
     * DE: ein Löffel voll.<br>
     * FR: cuillerée.<br>
     * IT: cucciaio.<br>
     */
    SPOONFUL("733015007",
             "http://snomed.info/sct",
             "Spoonful (unit of presentation)",
             "Spoonful",
             "ein Löffel voll",
             "cuillerée",
             "cucciaio"),
    /**
     * EN: Stick.<br>
     * DE: Stäbchen.<br>
     * FR: bâton.<br>
     * IT: stick.<br>
     */
    STICK("733016008",
          "http://snomed.info/sct",
          "Stick (unit of presentation)",
          "Stick",
          "Stäbchen",
          "bâton",
          "stick"),
    /**
     * EN: Straw.<br>
     * DE: Trinkhalm.<br>
     * FR: paille.<br>
     * IT: cannuccia.<br>
     */
    STRAW("733017004",
          "http://snomed.info/sct",
          "Straw (unit of presentation)",
          "Straw",
          "Trinkhalm",
          "paille",
          "cannuccia"),
    /**
     * EN: Strip.<br>
     * DE: Streifen.<br>
     * FR: bandelette.<br>
     * IT: strip.<br>
     */
    STRIP("733018009",
          "http://snomed.info/sct",
          "Strip (unit of presentation)",
          "Strip",
          "Streifen",
          "bandelette",
          "strip"),
    /**
     * EN: Suppository.<br>
     * DE: Zäpfchen.<br>
     * FR: suppositoire.<br>
     * IT: supposta.<br>
     */
    SUPPOSITORY("733019001",
                "http://snomed.info/sct",
                "Suppository (unit of presentation)",
                "Suppository",
                "Zäpfchen",
                "suppositoire",
                "supposta"),
    /**
     * EN: Syringe.<br>
     * DE: Spritze.<br>
     * FR: seringue.<br>
     * IT: siringa.<br>
     */
    SYRINGE("733020007",
            "http://snomed.info/sct",
            "Syringe (unit of presentation)",
            "Syringe",
            "Spritze",
            "seringue",
            "siringa"),
    /**
     * EN: System.<br>
     * DE: System.<br>
     * FR: système.<br>
     * IT: sistema.<br>
     */
    SYSTEM("733021006",
           "http://snomed.info/sct",
           "System (unit of presentation)",
           "System",
           "System",
           "système",
           "sistema"),
    /**
     * EN: tablespoon - metric.<br>
     * DE: Esslöffel.<br>
     * FR: c. à soupe.<br>
     * IT: cucchiaio da minestra.<br>
     */
    TABLESPOON_METRIC("[tbs_m]",
                      "http://unitsofmeasure.org",
                      "tablespoon - metric",
                      "tablespoon - metric",
                      "Esslöffel",
                      "c. à soupe",
                      "cucchiaio da minestra"),
    /**
     * EN: Tablet.<br>
     * DE: Tablette.<br>
     * FR: comprimé.<br>
     * IT: compressa.<br>
     */
    TABLET("732936001",
           "http://snomed.info/sct",
           "Tablet (unit of presentation)",
           "Tablet",
           "Tablette",
           "comprimé",
           "compressa"),
    /**
     * EN: Tampon.<br>
     * DE: Tampon.<br>
     * FR: tampon diffuseur.<br>
     * IT: tampone.<br>
     */
    TAMPON("733022004",
           "http://snomed.info/sct",
           "Tampon (unit of presentation)",
           "Tampon",
           "Tampon",
           "tampon diffuseur",
           "tampone"),
    /**
     * EN: teaspoon - metric.<br>
     * DE: Teelöffel.<br>
     * FR: c. à café.<br>
     * IT: cucchiaino da caffè.<br>
     */
    TEASPOON_METRIC("[tsp_m]",
                    "http://unitsofmeasure.org",
                    "teaspoon - metric",
                    "teaspoon - metric",
                    "Teelöffel",
                    "c. à café",
                    "cucchiaino da caffè"),
    /**
     * EN: Thousand Per * Unit.<br>
     * DE: Tausend Einheiten.<br>
     * FR: millier d'unités.<br>
     * IT: mille per unità *.<br>
     */
    THOUSAND_PER_STAR_UNIT("2011000175108",
                           "http://snomed.info/sct",
                           "Thousand Per * Unit",
                           "Thousand Per * Unit",
                           "Tausend Einheiten",
                           "millier d'unités",
                           "mille per unità *"),
    /**
     * EN: Thread.<br>
     * DE: Faden.<br>
     * FR: fil.<br>
     * IT: filo.<br>
     */
    THREAD("733023009",
           "http://snomed.info/sct",
           "Thread (unit of presentation)",
           "Thread",
           "Faden",
           "fil",
           "filo"),
    /**
     * EN: Tube.<br>
     * DE: Tube.<br>
     * FR: tube.<br>
     * IT: tubo.<br>
     */
    TUBE("733024003",
         "http://snomed.info/sct",
         "Tube (unit of presentation)",
         "Tube",
         "Tube",
         "tube",
         "tubo"),
    /**
     * EN: µg.<br>
     * DE: µg.<br>
     * FR: µg.<br>
     * IT: µg.<br>
     */
    UG("ug",
       "http://unitsofmeasure.org",
       "microgram",
       "µg",
       "µg",
       "µg",
       "µg"),
    /**
     * EN: µl.<br>
     * DE: µl.<br>
     * FR: µl.<br>
     * IT: µl.<br>
     */
    UL("uL",
       "http://unitsofmeasure.org",
       "microliter",
       "µl",
       "µl",
       "µl",
       "µl"),
    /**
     * EN: µmol.<br>
     * DE: µmol.<br>
     * FR: µmol.<br>
     * IT: µmol.<br>
     */
    UMOL("umol",
         "http://unitsofmeasure.org",
         "micromole",
         "µmol",
         "µmol",
         "µmol",
         "µmol"),
    /**
     * EN: unit.<br>
     * DE: Einheit.<br>
     * FR: unité(s).<br>
     * IT: unità.<br>
     */
    UNIT("767525000",
         "http://snomed.info/sct",
         "Unit",
         "unit",
         "Einheit",
         "unité(s)",
         "unità"),
    /**
     * EN: Vessel.<br>
     * DE: Gefäss.<br>
     * FR: récipient étanche.<br>
     * IT: recipiente a tenuta.<br>
     */
    VESSEL("733025002",
           "http://snomed.info/sct",
           "Vessel (unit of presentation)",
           "Vessel",
           "Gefäss",
           "récipient étanche",
           "recipiente a tenuta"),
    /**
     * EN: Vial.<br>
     * DE: Durchstechflasche.<br>
     * FR: petit flacon.<br>
     * IT: flaconcino.<br>
     */
    VIAL("733026001",
         "http://snomed.info/sct",
         "Vial (unit of presentation)",
         "Vial",
         "Durchstechflasche",
         "petit flacon",
         "flaconcino");

    /**
     * EN: Code for a.<br>
     * DE: Code für a.<br>
     * FR: Code de a.<br>
     * IT: Code per a.<br>
     */
    public static final String A_CODE = "a";

    /**
     * EN: Code for Actuation.<br>
     * DE: Code für Hub.<br>
     * FR: Code de bouffée.<br>
     * IT: Code per erogazione.<br>
     */
    public static final String ACTUATION_CODE = "732981002";

    /**
     * EN: Code for Ampule.<br>
     * DE: Code für Ampulle.<br>
     * FR: Code de ampoule.<br>
     * IT: Code per fiala.<br>
     */
    public static final String AMPULE_CODE = "732978007";

    /**
     * EN: Code for Application - unit of product usage (qualifier value).<br>
     * DE: Code für Application - unit of product usage (qualifier value).<br>
     * FR: Code de Application - unit of product usage (qualifier value).<br>
     * IT: Code per Application - unit of product usage (qualifier value).<br>
     */
    public static final String APPLICATION_UNIT_OF_PRODUCT_USAGE_QUALIFIER_VALUE_CODE = "413568008";

    /**
     * EN: Code for Applicator.<br>
     * DE: Code für Applikator.<br>
     * FR: Code de applicateur.<br>
     * IT: Code per applicatore.<br>
     */
    public static final String APPLICATOR_CODE = "732980001";

    /**
     * EN: Code for Bag.<br>
     * DE: Code für Tasche.<br>
     * FR: Code de sac.<br>
     * IT: Code per sacca.<br>
     */
    public static final String BAG_CODE = "732982009";

    /**
     * EN: Code for Barrel.<br>
     * DE: Code für Kanister.<br>
     * FR: Code de fût.<br>
     * IT: Code per fusto.<br>
     */
    public static final String BARREL_CODE = "732983004";

    /**
     * EN: Code for Blister.<br>
     * DE: Code für Blisterpackung.<br>
     * FR: Code de plaquette.<br>
     * IT: Code per blister.<br>
     */
    public static final String BLISTER_CODE = "732984005";

    /**
     * EN: Code for Block.<br>
     * DE: Code für Block.<br>
     * FR: Code de bloc.<br>
     * IT: Code per blocco.<br>
     */
    public static final String BLOCK_CODE = "732985006";

    /**
     * EN: Code for Bottle.<br>
     * DE: Code für Flasche.<br>
     * FR: Code de flacon.<br>
     * IT: Code per flacone.<br>
     */
    public static final String BOTTLE_CODE = "732986007";

    /**
     * EN: Code for Bq.<br>
     * DE: Code für Bq.<br>
     * FR: Code de Bq.<br>
     * IT: Code per Bq.<br>
     */
    public static final String BQ_CODE = "Bq";

    /**
     * EN: Code for Cachet.<br>
     * DE: Code für Oblatenkapsel.<br>
     * FR: Code de cachet.<br>
     * IT: Code per cachet.<br>
     */
    public static final String CACHET_CODE = "732987003";

    /**
     * EN: Code for Capsule.<br>
     * DE: Code für Kapsel.<br>
     * FR: Code de capsule.<br>
     * IT: Code per capsula.<br>
     */
    public static final String CAPSULE_CODE = "732937005";

    /**
     * EN: Code for Cartridge.<br>
     * DE: Code für Patrone.<br>
     * FR: Code de cartouche.<br>
     * IT: Code per cartuccia.<br>
     */
    public static final String CARTRIDGE_CODE = "732988008";

    /**
     * EN: Code for CFU.<br>
     * DE: Code für CFU.<br>
     * FR: Code de CFU.<br>
     * IT: Code per CFU.<br>
     */
    public static final String CFU_CODE = "[CFU]";

    /**
     * EN: Code for Chewing gum.<br>
     * DE: Code für Kaugummi.<br>
     * FR: Code de gomme à mâcher.<br>
     * IT: Code per gomma da masticare.<br>
     */
    public static final String CHEWING_GUM_CODE = "732989000";

    /**
     * EN: Code for cm.<br>
     * DE: Code für cm.<br>
     * FR: Code de cm.<br>
     * IT: Code per cm.<br>
     */
    public static final String CM_CODE = "cm";

    /**
     * EN: Code for cm2.<br>
     * DE: Code für cm2.<br>
     * FR: Code de cm2.<br>
     * IT: Code per cm2.<br>
     */
    public static final String CM2_CODE = "cm2";

    /**
     * EN: Code for cm3.<br>
     * DE: Code für cm3.<br>
     * FR: Code de cm3.<br>
     * IT: Code per cm3.<br>
     */
    public static final String CM3_CODE = "cm3";

    /**
     * EN: Code for Container.<br>
     * DE: Code für Behältnis.<br>
     * FR: Code de récipient.<br>
     * IT: Code per contenitore.<br>
     */
    public static final String CONTAINER_CODE = "732990009";

    /**
     * EN: Code for Cup.<br>
     * DE: Code für Messbecher.<br>
     * FR: Code de godet.<br>
     * IT: Code per bicchiere dosatore.<br>
     */
    public static final String CUP_CODE = "732991008";

    /**
     * EN: Code for Cylinder.<br>
     * DE: Code für Zylinder.<br>
     * FR: Code de cylindre.<br>
     * IT: Code per cilindro.<br>
     */
    public static final String CYLINDER_CODE = "732992001";

    /**
     * EN: Code for d.<br>
     * DE: Code für d.<br>
     * FR: Code de d.<br>
     * IT: Code per d.<br>
     */
    public static final String D_CODE = "d";

    /**
     * EN: Code for Dose.<br>
     * DE: Code für Dos.<br>
     * FR: Code de dose.<br>
     * IT: Code per dose.<br>
     */
    public static final String DOSE_CODE = "408102007";

    /**
     * EN: Code for Dressing.<br>
     * DE: Code für Verband.<br>
     * FR: Code de compresse.<br>
     * IT: Code per garza.<br>
     */
    public static final String DRESSING_CODE = "732993006";

    /**
     * EN: Code for Drop.<br>
     * DE: Code für Tropfen.<br>
     * FR: Code de goutte.<br>
     * IT: Code per goccia.<br>
     */
    public static final String DROP_CODE = "732994000";

    /**
     * EN: Code for Film.<br>
     * DE: Code für Film.<br>
     * FR: Code de film.<br>
     * IT: Code per film.<br>
     */
    public static final String FILM_CODE = "732995004";

    /**
     * EN: Code for g.<br>
     * DE: Code für g.<br>
     * FR: Code de g.<br>
     * IT: Code per g.<br>
     */
    public static final String G_CODE = "g";

    /**
     * EN: Code for GBq.<br>
     * DE: Code für GBq.<br>
     * FR: Code de GBq.<br>
     * IT: Code per GBq.<br>
     */
    public static final String GBQ_CODE = "GBq";

    /**
     * EN: Code for h.<br>
     * DE: Code für h.<br>
     * FR: Code de h.<br>
     * IT: Code per h.<br>
     */
    public static final String H_CODE = "h";

    /**
     * EN: Code for Implant.<br>
     * DE: Code für Implantat.<br>
     * FR: Code de implant.<br>
     * IT: Code per impianto.<br>
     */
    public static final String IMPLANT_CODE = "732996003";

    /**
     * EN: Code for Inhaler.<br>
     * DE: Code für Inhalator.<br>
     * FR: Code de inhalateur.<br>
     * IT: Code per inalatore.<br>
     */
    public static final String INHALER_CODE = "732997007";

    /**
     * EN: Code for Insert.<br>
     * DE: Code für Insert.<br>
     * FR: Code de insert.<br>
     * IT: Code per inserto.<br>
     */
    public static final String INSERT_CODE = "732998002";

    /**
     * EN: Code for international unit.<br>
     * DE: Code für Internationale Einheit.<br>
     * FR: Code de unité(s) internationale(s).<br>
     * IT: Code per unità internazionale(i).<br>
     */
    public static final String INTERNATIONAL_UNIT_CODE = "[iU]";

    /**
     * EN: Code for Jar.<br>
     * DE: Code für Weithalsgefäss.<br>
     * FR: Code de pot.<br>
     * IT: Code per vasetto.<br>
     */
    public static final String JAR_CODE = "732999005";

    /**
     * EN: Code for kBq.<br>
     * DE: Code für kBq.<br>
     * FR: Code de kBq.<br>
     * IT: Code per kBq.<br>
     */
    public static final String KBQ_CODE = "kBq";

    /**
     * EN: Code for kcal.<br>
     * DE: Code für kcal.<br>
     * FR: Code de kcal.<br>
     * IT: Code per kcal.<br>
     */
    public static final String KCAL_CODE = "kcal";

    /**
     * EN: Code for kg.<br>
     * DE: Code für kg.<br>
     * FR: Code de kg.<br>
     * IT: Code per kg.<br>
     */
    public static final String KG_CODE = "kg";

    /**
     * EN: Code for kJ.<br>
     * DE: Code für kJ.<br>
     * FR: Code de kJ.<br>
     * IT: Code per kJ.<br>
     */
    public static final String KJ_CODE = "kJ";

    /**
     * EN: Code for lt.<br>
     * DE: Code für lt.<br>
     * FR: Code de lt.<br>
     * IT: Code per l.<br>
     */
    public static final String LT_CODE = "L";

    /**
     * EN: Code for Lyophilisate.<br>
     * DE: Code für Lyophilisat.<br>
     * FR: Code de lyophilisat.<br>
     * IT: Code per liofilizzato.<br>
     */
    public static final String LYOPHILISATE_CODE = "733001005";

    /**
     * EN: Code for Matrix.<br>
     * DE: Code für Matrix.<br>
     * FR: Code de matrice.<br>
     * IT: Code per matrice.<br>
     */
    public static final String MATRIX_CODE = "733002003";

    /**
     * EN: Code for MBq.<br>
     * DE: Code für MBq.<br>
     * FR: Code de MBq.<br>
     * IT: Code per MBq.<br>
     */
    public static final String MBQ_CODE = "MBq";

    /**
     * EN: Code for meq.<br>
     * DE: Code für meq.<br>
     * FR: Code de mEq.<br>
     * IT: Code per mEq.<br>
     */
    public static final String MEQ_CODE = "meq";

    /**
     * EN: Code for mg.<br>
     * DE: Code für mg.<br>
     * FR: Code de mg.<br>
     * IT: Code per mg.<br>
     */
    public static final String MG_CODE = "mg";

    /**
     * EN: Code for MillionInternationalUnit.<br>
     * DE: Code für MioUI.<br>
     * FR: Code de MioUI.<br>
     * IT: Code per MioUI.<br>
     */
    public static final String MILLIONINTERNATIONALUNIT_CODE = "10*6.[iU]";

    /**
     * EN: Code for min.<br>
     * DE: Code für min.<br>
     * FR: Code de min.<br>
     * IT: Code per min.<br>
     */
    public static final String MIN_CODE = "min";

    /**
     * EN: Code for MioU.<br>
     * DE: Code für MioU.<br>
     * FR: Code de MioU.<br>
     * IT: Code per MioU.<br>
     */
    public static final String MIOU_CODE = "396186001";

    /**
     * EN: Code for ml.<br>
     * DE: Code für ml.<br>
     * FR: Code de ml.<br>
     * IT: Code per ml.<br>
     */
    public static final String ML_CODE = "mL";

    /**
     * EN: Code for mm2.<br>
     * DE: Code für mm2.<br>
     * FR: Code de mm2.<br>
     * IT: Code per mm2.<br>
     */
    public static final String MM2_CODE = "mm2";

    /**
     * EN: Code for mmol.<br>
     * DE: Code für mmol.<br>
     * FR: Code de mmol.<br>
     * IT: Code per mmol.<br>
     */
    public static final String MMOL_CODE = "mmol";

    /**
     * EN: Code for mo.<br>
     * DE: Code für mo.<br>
     * FR: Code de mo.<br>
     * IT: Code per mo.<br>
     */
    public static final String MO_CODE = "mo";

    /**
     * EN: Code for mol.<br>
     * DE: Code für mol.<br>
     * FR: Code de mol.<br>
     * IT: Code per mol.<br>
     */
    public static final String MOL_CODE = "mol";

    /**
     * EN: Code for ng.<br>
     * DE: Code für ng.<br>
     * FR: Code de ng.<br>
     * IT: Code per ng.<br>
     */
    public static final String NG_CODE = "ng";

    /**
     * EN: Code for nl.<br>
     * DE: Code für nl.<br>
     * FR: Code de nl.<br>
     * IT: Code per nl.<br>
     */
    public static final String NL_CODE = "nL";

    /**
     * EN: Code for nmol.<br>
     * DE: Code für nmol.<br>
     * FR: Code de nmol.<br>
     * IT: Code per nmol.<br>
     */
    public static final String NMOL_CODE = "nmol";

    /**
     * EN: Code for Package.<br>
     * DE: Code für Packung.<br>
     * FR: Code de emballage.<br>
     * IT: Code per confezione.<br>
     */
    public static final String PACKAGE_CODE = "1681000175101";

    /**
     * EN: Code for Pad.<br>
     * DE: Code für Pad.<br>
     * FR: Code de tampon applicateur.<br>
     * IT: Code per tampone.<br>
     */
    public static final String PAD_CODE = "733003008";

    /**
     * EN: Code for Pastille.<br>
     * DE: Code für Pastille.<br>
     * FR: Code de pastille molle.<br>
     * IT: Code per pastiglia molle.<br>
     */
    public static final String PASTILLE_CODE = "733004002";

    /**
     * EN: Code for Patch.<br>
     * DE: Code für Patch.<br>
     * FR: Code de patch.<br>
     * IT: Code per cerotto.<br>
     */
    public static final String PATCH_CODE = "733005001";

    /**
     * EN: Code for Pen.<br>
     * DE: Code für Pen.<br>
     * FR: Code de stylo.<br>
     * IT: Code per penna.<br>
     */
    public static final String PEN_CODE = "733006000";

    /**
     * EN: Code for %.<br>
     * DE: Code für %.<br>
     * FR: Code de %.<br>
     * IT: Code per %.<br>
     */
    public static final String PERCENT_CODE = "%";

    /**
     * EN: Code for Pessary.<br>
     * DE: Code für Pessar.<br>
     * FR: Code de ovule.<br>
     * IT: Code per ovulo.<br>
     */
    public static final String PESSARY_CODE = "733007009";

    /**
     * EN: Code for Piece(s).<br>
     * DE: Code für Stk.<br>
     * FR: Code de pce.<br>
     * IT: Code per pz.<br>
     */
    public static final String PIECE_CODE = "246205007";

    /**
     * EN: Code for Pillule.<br>
     * DE: Code für Streukügelchen.<br>
     * FR: Code de granule.<br>
     * IT: Code per granuli.<br>
     */
    public static final String PILLULE_CODE = "733008004";

    /**
     * EN: Code for Pipette.<br>
     * DE: Code für Pipette.<br>
     * FR: Code de pipette.<br>
     * IT: Code per pipetta.<br>
     */
    public static final String PIPETTE_CODE = "733009007";

    /**
     * EN: Code for Plaster.<br>
     * DE: Code für Pflaster.<br>
     * FR: Code de emplâtre.<br>
     * IT: Code per cerotto.<br>
     */
    public static final String PLASTER_CODE = "733010002";

    /**
     * EN: Code for Plug.<br>
     * DE: Code für Einsatz.<br>
     * FR: Code de support poreux.<br>
     * IT: Code per supporto.<br>
     */
    public static final String PLUG_CODE = "733011003";

    /**
     * EN: Code for Pouch.<br>
     * DE: Code für Beutelchen.<br>
     * FR: Code de pochette.<br>
     * IT: Code per sachetta.<br>
     */
    public static final String POUCH_CODE = "733012005";

    /**
     * EN: Code for ppm.<br>
     * DE: Code für ppm.<br>
     * FR: Code de ppm.<br>
     * IT: Code per ppm.<br>
     */
    public static final String PPM_CODE = "[ppm]";

    /**
     * EN: Code for Sachet.<br>
     * DE: Code für Beutel.<br>
     * FR: Code de sachet.<br>
     * IT: Code per bustina.<br>
     */
    public static final String SACHET_CODE = "733013000";

    /**
     * EN: Code for sec.<br>
     * DE: Code für sec.<br>
     * FR: Code de sec.<br>
     * IT: Code per sec.<br>
     */
    public static final String SEC_CODE = "s";

    /**
     * EN: Code for Sponge.<br>
     * DE: Code für Schwämmchen.<br>
     * FR: Code de eponge.<br>
     * IT: Code per spugna.<br>
     */
    public static final String SPONGE_CODE = "733014006";

    /**
     * EN: Code for Spoonful.<br>
     * DE: Code für ein Löffel voll.<br>
     * FR: Code de cuillerée.<br>
     * IT: Code per cucciaio.<br>
     */
    public static final String SPOONFUL_CODE = "733015007";

    /**
     * EN: Code for Stick.<br>
     * DE: Code für Stäbchen.<br>
     * FR: Code de bâton.<br>
     * IT: Code per stick.<br>
     */
    public static final String STICK_CODE = "733016008";

    /**
     * EN: Code for Straw.<br>
     * DE: Code für Trinkhalm.<br>
     * FR: Code de paille.<br>
     * IT: Code per cannuccia.<br>
     */
    public static final String STRAW_CODE = "733017004";

    /**
     * EN: Code for Strip.<br>
     * DE: Code für Streifen.<br>
     * FR: Code de bandelette.<br>
     * IT: Code per strip.<br>
     */
    public static final String STRIP_CODE = "733018009";

    /**
     * EN: Code for Suppository.<br>
     * DE: Code für Zäpfchen.<br>
     * FR: Code de suppositoire.<br>
     * IT: Code per supposta.<br>
     */
    public static final String SUPPOSITORY_CODE = "733019001";

    /**
     * EN: Code for Syringe.<br>
     * DE: Code für Spritze.<br>
     * FR: Code de seringue.<br>
     * IT: Code per siringa.<br>
     */
    public static final String SYRINGE_CODE = "733020007";

    /**
     * EN: Code for System.<br>
     * DE: Code für System.<br>
     * FR: Code de système.<br>
     * IT: Code per sistema.<br>
     */
    public static final String SYSTEM_CODE = "733021006";

    /**
     * EN: Code for tablespoon - metric.<br>
     * DE: Code für Esslöffel.<br>
     * FR: Code de c. à soupe.<br>
     * IT: Code per cucchiaio da minestra.<br>
     */
    public static final String TABLESPOON_METRIC_CODE = "[tbs_m]";

    /**
     * EN: Code for Tablet.<br>
     * DE: Code für Tablette.<br>
     * FR: Code de comprimé.<br>
     * IT: Code per compressa.<br>
     */
    public static final String TABLET_CODE = "732936001";

    /**
     * EN: Code for Tampon.<br>
     * DE: Code für Tampon.<br>
     * FR: Code de tampon diffuseur.<br>
     * IT: Code per tampone.<br>
     */
    public static final String TAMPON_CODE = "733022004";

    /**
     * EN: Code for teaspoon - metric.<br>
     * DE: Code für Teelöffel.<br>
     * FR: Code de c. à café.<br>
     * IT: Code per cucchiaino da caffè.<br>
     */
    public static final String TEASPOON_METRIC_CODE = "[tsp_m]";

    /**
     * EN: Code for Thousand Per * Unit.<br>
     * DE: Code für Tausend Einheiten.<br>
     * FR: Code de millier d'unités.<br>
     * IT: Code per mille per unità *.<br>
     */
    public static final String THOUSAND_PER_STAR_UNIT_CODE = "2011000175108";

    /**
     * EN: Code for Thread.<br>
     * DE: Code für Faden.<br>
     * FR: Code de fil.<br>
     * IT: Code per filo.<br>
     */
    public static final String THREAD_CODE = "733023009";

    /**
     * EN: Code for Tube.<br>
     * DE: Code für Tube.<br>
     * FR: Code de tube.<br>
     * IT: Code per tubo.<br>
     */
    public static final String TUBE_CODE = "733024003";

    /**
     * EN: Code for µg.<br>
     * DE: Code für µg.<br>
     * FR: Code de µg.<br>
     * IT: Code per µg.<br>
     */
    public static final String UG_CODE = "ug";

    /**
     * EN: Code for µl.<br>
     * DE: Code für µl.<br>
     * FR: Code de µl.<br>
     * IT: Code per µl.<br>
     */
    public static final String UL_CODE = "uL";

    /**
     * EN: Code for µmol.<br>
     * DE: Code für µmol.<br>
     * FR: Code de µmol.<br>
     * IT: Code per µmol.<br>
     */
    public static final String UMOL_CODE = "umol";

    /**
     * EN: Code for unit.<br>
     * DE: Code für Einheit.<br>
     * FR: Code de unité(s).<br>
     * IT: Code per unità.<br>
     */
    public static final String UNIT_CODE = "767525000";

    /**
     * EN: Code for Vessel.<br>
     * DE: Code für Gefäss.<br>
     * FR: Code de récipient étanche.<br>
     * IT: Code per recipiente a tenuta.<br>
     */
    public static final String VESSEL_CODE = "733025002";

    /**
     * EN: Code for Vial.<br>
     * DE: Code für Durchstechflasche.<br>
     * FR: Code de petit flacon.<br>
     * IT: Code per flaconcino.<br>
     */
    public static final String VIAL_CODE = "733026001";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.83";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "UnitCode";

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
    UnitCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
     * Returns the enum value as a FHIR Coding.
     */
    @Override
    public Coding getCoding() {
        return new Coding(this.getCodeSystemId(),
                          this.getCodeValue(),
                          this.getCodeSystemName());
    }

    /**
     * Returns the enum value as a FHIR CodeableConcept.
     */
    @Override
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept().setText(this.getCodeSystemName()).addCoding(this.getCoding());
    }

    /**
     * Compares the enum value to the given FHIR Coding.
     *
     * @param coding The FHIR Coding to be compared.
     * @return {@code true} if they have the same system and value, {@code false} otherwise.
     */
    @Override
    public boolean isEqualTo(final Coding coding) {
        return this.getCodeSystemId().equals(coding.getSystem()) && this.getCodeValue().equals(coding.getCode());
    }

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static UnitCode getEnum(@Nullable final String code) {
        for (final UnitCode x : values()) {
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
            Enum.valueOf(UnitCode.class,
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
        for (final UnitCode x : values()) {
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
    public static UnitCode getEnum(@Nullable final Coding coding) {
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
