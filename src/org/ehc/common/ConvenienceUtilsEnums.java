/*******************************************************************************
 * 
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 * 
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * 
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 * 
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 Switzerland License.
 * 
 * Year of publication: 2015
 * 
 *******************************************************************************/


package org.ehc.common;

/**
 * Auswahllisten für International gültige Wertemengen
 */
public class ConvenienceUtilsEnums {

  /**
   * Geschlecht gemäss HL7 Vocabulary AdministrativeGender [2.16.840.1.113883.5.1]
   * <ul>
   * <li>Male (männlich;M)</li>
   * <li>Female (weiblich;F)</li>
   * <li>Undifferentiated (undifferenziert;U)</li>
   * </ul>
   */
  public enum AdministrativeGenderCode {
    /**
     * männlich (HL7 Vocabulary Code: M)
     */
    Male,
    /**
     * weiblich (HL7 Vocabulary Code: F)
     */
    Female,
    /**
     * Undifferenziert (HL7 Vocabulary Code: U)
     */
    Undifferentiated
  }
  
  /**
   * Geschlecht gemäss HL7 Vocabulary AdministrativeGender [2.16.840.1.113883.5.1]
   * <ul>
   * <li>Male (männlich;M)</li>
   * <li>Female (weiblich;F)</li>
   * <li>Undifferentiated (undifferenziert;U)</li>
   * </ul>
   */
  public enum Test {
    /**
     * männlich (HL7 Vocabulary Code: M)
     */
    Bla,
    /**
     * weiblich (HL7 Vocabulary Code: F)
     */
    Blub,
    /**
     * Undifferenziert (HL7 Vocabulary Code: U)
     */
    Undifferentiated
  }

  /**
   * Nutzungszweck von Adressen und Kommunikationsmitteln gemäss HL7 Vocabulary
   * TelecommunicationAddressUse [2.16.840.1.113883.1.11.201] und AddressUse
   * [2.16.840.1.113883.5.1119] Wichtigste für die Schweiz: Private (Privat;HP),
   * Business(Geschäft;WP), Mobil(Mobile;MC), Restliche original gemäss HL7 V3 Vocabulary
   * (infrastructure/vocabulary/AddressUse.html)
   */
  public enum UseCode {
    Private, Business, Mobile, hl7CONF, hl7DIR, hl7EC, hl7H, hl7HV, hl7PG, hl7PUB, hl7TMP
  }

  /**
   * Bekannte und häufig gebrauchte Identifikationsdomänen
   * <ul>
   * <li>Global Location Number (GLN): 1.3.88</li>
   * <li>Global Trade Item Number (GTIN): 1.3.160</li>
   * </ul>
   */
  public enum KnownOID {

    /**
     * OID: 2.16.756.5.30.1.127.3.1.20080401.1 <div class="de">Krankheiten und Unfallfolgen
     * (VVK-EDI, Kapitel 2.1.1)</div> <div class="fr">Désignation de la maladie ou de la séquelle
     * d’accident (OCA-DFI, chapitre 2.1.1)</div>
     */
    IcrDha080401Disease,
    /**
     * OID: 1.3.88 <div class="en">Global Location Number</div>
     */
    GLN,
    /**
     * OID: 1.3.160 <div class="en">Global Trade Item Number</div>
     */
    GTIN,
    /**
     * OID: 2.16.756.5.32 <div class="de">AHV Nummer (die Neue)</div> <div class="fr">No AVS (le
     * nouveaux)</div>
     */
    SwissSSN,
    /**
     * OID: 2.16.756.5.31 <div class="de">AHV Nummer (die Alte)</div> <div class="fr">No AVS (le
     * vieil)</div>
     */
    SwissSSNDeprecated,
    /**
     * OID: 2.16.756.5.30.1.123.100.1.1.1<div class="de">Versichertenkarte</div> <div
     * class="fr">Carte d'assurance</div>
     */
    SwissInsuranceCard

  }

  public static String knownOID(KnownOID value) {
    switch (value) {
      case IcrDha080401Disease:
        return "2.16.756.5.30.1.127.3.1.20080401.1";
      case GLN:
        return "1.3.88";
      case GTIN:
        return "1.3.160";
      case SwissSSN:
        return "2.16.756.5.32";
      case SwissSSNDeprecated:
        return "2.16.756.5.31";
      case SwissInsuranceCard:
        return "2.16.756.5.30.1.123.100.1.1.1";
      default:
        return "undefined";
    }
  }

  /**
   * Art der Allergie oder Unverträglichkeit
   * 
   */
  public enum AllergyType {
    /**
     * Lebensmittelallergie (HL7 Vocabulary Code: FALG)
     */
    FoodAllergy
  }

  /**
   * Sprachen German (de-CH), French (fr-CH), Italian (it-CH)
   * 
   */
  public enum Language {
    German, French, Italian
  }

  /**
   * Schweregrad (z.B. einer Allergie oder Unverträglichkeit)
   * 
   */
  public enum Severity {
    /**
     * Hoher Schweregrad (HL7 Vocabulary Code: H)
     */
    HighSeverity,
    /**
     * Mittlerer Schweregrad (HL7 Vocabulary Code: M)
     */
    ModerateSeverity,
    /**
     * Leichter Schweregrad (HL7 Vocabulary Code: L)
     */
    LowSeverity
  }

  /**
   * Status (Aktiv, Inaktiv, Abgeschlossen, ...)
   */
  public enum StatusCode {
    /**
     * abgeschlossen
     */
    completed,

    /**
     * abgebrochen
     */
    aborted
  }

  /**
   * UCUM Einheiten AHGEquivalentsPerMilliLiter (AHGEquivalentsPerMilliLiter [Substance
   * Concentration Units];AHG eq/mL), BillionPerLiter (BillionPerLiter [Number Concentration
   * Units];10^9/L), BillionsPerMicroLiter (BillionsPerMicroLiter [Number Concentration
   * Units];10^9/uL), BillionsPerMilliliter (BillionsPerMilliliter [Number Concentration
   * Units];10^9/mL), BoneCollagenEquivalentsPerMicroMoleCreatinine
   * (BoneCollagenEquivalentsPerMicroMoleCreatinine [Substance Ratio Or Substance Fraction
   * Units];BCE/umol Cre), BoneCollagenEquivalentsPerMilliMoleCreatinine
   * (BoneCollagenEquivalentsPerMilliMoleCreatinine [Substance Ratio Or Substance Fraction
   * Units];BCE/mmol Cre), CellsPerMicroLiter (CellsPerMicroLiter [Number Concentration
   * Units];cells/uL), CentiGram (CentiGram [SI Mass Units];cg), CentiLiter (CentiLiter [SI Volume
   * Units];cL), CentiMeter (CentiMeter [SI Length Units];cm), ColonyFormingUnitsPerMilliLiter
   * (ColonyFormingUnitsPerMilliLiter [Number Concentration Units];cfu/mL),
   * ComplementCh50UnitsPerMilliLiter (ComplementCh50UnitsPerMilliLiter [Arbitrary Concentration
   * Units];CH50 U/mL), CopiesPerMilliLiter (CopiesPerMilliLiter [Number Concentration
   * Units];Copies/mL), CubicInch (CubicInch [English Volume Units];in^3), Cup (Cup [English Volume
   * Units];Cup), Day (Day [Time Units];d), DeciGram (DeciGram [SI Mass Units];dg), DeciLiter
   * (DeciLiter [SI Volume Units];dL), DeciMeter (DeciMeter [SI Length Units];dm), DegreesCelsius
   * (DegreesCelsius [Temperature Units];C), DegreesFahrenheit (DegreesFahrenheit [Temperature
   * Units];F), DegreesKelvin (DegreesKelvin [Temperature Units];K), DegreesOfArc (DegreesOfArc
   * [Plane Angle Units];Deg), Dram (Dram [English Mass Units];dr), EhrlichUnitsPer100Gram
   * (EhrlichUnitsPer100Gram [Arbitrary Concentration Content Units];EU/100 g),
   * EhrlichUnitsPerDeciLiter (EhrlichUnitsPerDeciLiter [Arbitrary Concentration Units];EU/dL),
   * ElisaUnitsPerMilliLiter (ElisaUnitsPerMilliLiter [Arbitrary Concentration Units];Elisa U/mL),
   * Equivalent (Equivalent [Substance Units];eq), EquivalentsPerLiter (EquivalentsPerLiter
   * [Substance Concentration Units];eg/L), EquivalentsPerMicroMole (EquivalentsPerMicroMole
   * [Substance Ratio Or Substance Fraction Units];eq/umol), EquivalentsPerMilliLiter
   * (EquivalentsPerMilliLiter [Substance Concentration Units];eq/mL), EquivalentsPerMilliMole
   * (EquivalentsPerMilliMole [Substance Ratio Or Substance Fraction Units];eq/mmol), Fathom (Fathom
   * [English Length Units];fathom), Feet (Feet [English Length Units];ft), FemtoGram (FemtoGram [SI
   * Mass Units];fg), FemtoLiter (FemtoLiter;fL), FemtoMeter (FemtoMeter [SI Length Units];fm),
   * Femtomole (Femtomole [Substance Units];fmol), FemtoMolesPerGram (FemtoMolesPerGram [Substance
   * Content Units];fmol/gm), FemtoMolesPerMilliGram (FemtoMolesPerMilliGram [Substance Content
   * Units];fmol/mg), FemtoMolesPerMilliLiter (FemtoMolesPerMilliLiter [Substance Concentration
   * Units];fmol/mL), FluidDram (FluidDram [English Volume Units];fl dr), FluidOunce (FluidOunce
   * [English Volume Units];fl oz), French (French [English Length Units];French Unit), Gallon
   * (Gallon [English Volume Units];gal), Grain (Grain [English Mass Units];gr), Gram (Gram [SI Mass
   * Units];g), GramMeter (GramMeter [Massive Distance Units];Gram Meter), GramMeterPerHeartbeat
   * (GramMeterPerHeartbeat [Massive Distance Units];Gram Meter/Heartbeat),
   * GramMeterPerHeartbeatPerSquareMeter (GramMeterPerHeartbeatPerSquareMeter [Lineic Mass
   * Units];Gram Meter/Heartbeat/m^2), GramsPer100Gram (GramsPer100Gram [Mass Ratio Or Mass Fraction
   * Or Mass Content Units];g/100g), GramsPerDeciLiter (GramsPerDeciLiter;g/dL), GramsPerGram
   * (GramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units];g/g), GramsPerGramCreatinine
   * (GramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units];g/g Cre),
   * GramsPerKiloGram (GramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units];g/kg),
   * GramsPerLiter (GramsPerLiter;g/L), GramsPerMilliLiter (GramsPerMilliLiter;g/mL),
   * GramsPerSquareMeter (GramsPerSquareMeter [Areic Mass Units];g/m^2), GramsPerTotalWeight
   * (GramsPerTotalWeight [SI Mass Units];g/Total Weight), HectoLiter (HectoLiter [SI Volume
   * Units];hL), Hour (Hour [Time Units];h), IgAPhospholipidUnitsPerMilliLiter
   * (IgAPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units];IgA Phospholipid U/mL),
   * IgGPhospholipidUnitsPerMilliLiter (IgGPhospholipidUnitsPerMilliLiter [Arbitrary Concentration
   * Units];IgG Phospholipid U/mL), IgMPhospholipidUnitsPerMilliLiter
   * (IgMPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units];IgM Phospholipid U/mL), Inch
   * (Inch [English Length Units];in), InternationalUnit (InternationalUnit [Arbitrary Units];IU),
   * InternationalUnitsPerDeciLiter (InternationalUnitsPerDeciLiter [Arbitrary Concentration
   * Units];IU/dL), InternationalUnitsPerGram (InternationalUnitsPerGram [Arbitrary Concentration
   * Content Units];IU/g), InternationalUnitsPerGramHemoglobin (InternationalUnitsPerGramHemoglobin
   * [Arbitrary Concentration Content Units];IU/g Hgb), InternationalUnitsPerKilogram
   * (InternationalUnitsPerKilogram [Arbitrary Concentration Content Units];IU/kg),
   * InternationalUnitsPerLiter (InternationalUnitsPerLiter;IU/L), InternationalUnitsPerMilliLiter
   * (InternationalUnitsPerMilliLiter [Arbitrary Concentration Units];IU/mL), KatalPerKilogram
   * (KatalPerKilogram [Substance Rate Content Units];kat/kg), KelvinPerWatt (KelvinPerWatt [Thermal
   * Resistance Units];K/Watt), KiloCaloriesPerOunce (KiloCaloriesPerOunce [Energy Content
   * Units];kCal/oz), KiloGram (KiloGram [SI Mass Units];kg), KiloGramsPerCubicMeter
   * (KiloGramsPerCubicMeter [Mass Concentration Units];kg/m^3), KiloGramsPerLiter
   * (KiloGramsPerLiter [Mass Concentration Units];kg/L), KiloGramsPerMole (KiloGramsPerMole [Molar
   * Mass Units];kg/mol), KiloGramsPerSquareMeter (KiloGramsPerSquareMeter [Areic Mass
   * Units];kg/m^2), KiloInternationalUnitsPerMilliLiter (KiloInternationalUnitsPerMilliLiter
   * [Arbitrary Concentration Units];kIU/mL), KiloLiter (KiloLiter [SI Volume Units];kL), KiloMeter
   * (KiloMeter [SI Length Units];km), KiloPascal (KiloPascal;kPa), KiloSecond (KiloSecond [Time
   * Units];ks), KiloUnitsPerGram (KiloUnitsPerGram [Substance Rate Content Units];kU/g), Liter
   * (Liter [SI Volume Units];L), LitersPerKilogram (LitersPerKilogram [Volume Content Units];L/kg),
   * LiterSquareSecondPerSecond (LiterSquareSecondPerSecond [Volume Duration Units];L s^2/s), Log10
   * (Log10 [Unity];log 10), Megasecond (Megasecond [Time Units];Ms), Meter (Meter [SI Length
   * Units];m), MetricTon (MetricTon [SI Mass Units];Metric Ton), MicroEquivalent (MicroEquivalent
   * [Substance Units];ueq), MicroEquivalentsPerLiter (MicroEquivalentsPerLiter [Substance
   * Concentration Units];ueg/L), MicroEquivalentsPerMilliLiter (MicroEquivalentsPerMilliLiter
   * [Substance Concentration Units];ueq/mL), MicroGram (MicroGram [SI Mass Units];ug),
   * MicroGramPer100Gram (MicroGramPer100Gram [Mass Ratio Or Mass Fraction Or Mass Content
   * Units];ug/100 g), MicroGramPerGramCreatinine (MicroGramPerGramCreatinine [Mass Ratio Or Mass
   * Fraction Or Mass Content Units];ug/g Cre), MicroGramPerGramDryWeight (MicroGramPerGramDryWeight
   * [Mass Ratio Or Mass Fraction Or Mass Content Units];ug/g Dry Weight), MicroGramsPerDeciLiter
   * (MicroGramsPerDeciLiter;ug/dL), MicroGramsPerDeciLiterRedBloodCells
   * (MicroGramsPerDeciLiterRedBloodCells [Mass Concentration Units];ug/dL RBCs), MicroGramsPerGram
   * (MicroGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units];ug/g),
   * MicroGramsPerGramHemoglobin (MicroGramsPerGramHemoglobin [Mass Ratio Or Mass Fraction Or Mass
   * Content Units];ug/g Hgb), MicroGramsPerKiloGram (MicroGramsPerKiloGram [Mass Ratio Or Mass
   * Fraction Or Mass Content Units];ug/kg), MicroGramsPerLiter (MicroGramsPerLiter;ug/L),
   * MicroGramsPerMilliGram (MicroGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content
   * Units];ug/mg), MicroGramsPerMilliGramCreatinine (MicroGramsPerMilliGramCreatinine [Mass Ratio
   * Or Mass Fraction Or Mass Content Units];ug/mg Cre), MicroGramsPerMilliLiter
   * (MicroGramsPerMilliLiter;ug/mL), MicroGramsPerNanoGram (MicroGramsPerNanoGram [Mass Ratio Or
   * Mass Fraction Or Mass Content Units];ug/ng), MicroGramsPerSpecimen (MicroGramsPerSpecimen [SI
   * Mass Units];ug/Spec), MicroGramsPerSquareMeter (MicroGramsPerSquareMeter [Areic Mass
   * Units];ug/m^2), MicroGramsPerTotalVolume (MicroGramsPerTotalVolume [SI Mass Units];ug/Total
   * Volume), MicroInternationalUnit (MicroInternationalUnit [Arbitrary Units];uIU),
   * MicroInternationalUnitsPerMilliLiter (MicroInternationalUnitsPerMilliLiter;uIU/mL), MicroLiter
   * (MicroLiter [SI Volume Units];uL), MicroMeter (MicroMeter [SI Length Units];um), MicroMole
   * (MicroMole [Substance Units];umol), MicroMolesPerDeciLiter (MicroMolesPerDeciLiter [Substance
   * Concentration Units];umol/dL), MicroMolesPerGram (MicroMolesPerGram [Substance Content
   * Units];umol/g), MicroMolesPerGramCreatinine (MicroMolesPerGramCreatinine [Substance Content
   * Units];umol/g Cre), MicroMolesPerGramHemoglobin (MicroMolesPerGramHemoglobin [Substance Content
   * Units];umol/g Hgb), MicroMolesPerLiter (MicroMolesPerLiter;umol/L), MicroMolesPerMilliGram
   * (MicroMolesPerMilliGram [Substance Content Units];umol/mg), MicroMolesPerMilliGramCreatinine
   * (MicroMolesPerMilliGramCreatinine [Substance Content Units];umol/mg Cre),
   * MicroMolesPerMilliLiter (MicroMolesPerMilliLiter [Substance Concentration Units];umol/mL),
   * MicroMolesPerMinutePerGram (MicroMolesPerMinutePerGram [Substance Rate Content
   * Units];umol/min/g), MicroMolesPerMole (MicroMolesPerMole [Substance Ratio Or Substance Fraction
   * Units];umol/mol), MicroMolesPerMoleCreatinine (MicroMolesPerMoleCreatinine [Substance Ratio Or
   * Substance Fraction Units];umol/mol Cre), MicroSecond (MicroSecond [Time Units];us),
   * MilliEquivalent (MilliEquivalent [Substance Units];meq), MilliEquivalentPerMilliLiter
   * (MilliEquivalentPerMilliLiter [Substance Concentration Units];meq/mL),
   * MilliEquivalentsPerDeciLiter (MilliEquivalentsPerDeciLiter [Substance Concentration
   * Units];meg/dL), MilliEquivalentsPerGram (MilliEquivalentsPerGram [Substance Content
   * Units];meq/g), MilliEquivalentsPerGramCreatinine (MilliEquivalentsPerGramCreatinine [Substance
   * Content Units];meq/g Cre), MilliEquivalentsPerKiloGram (MilliEquivalentsPerKiloGram [Substance
   * Content Units];meq/kg), MilliEquivalentsPerLiter (MilliEquivalentsPerLiter;mEq/L),
   * MilliEquivalentsPerSpecimen (MilliEquivalentsPerSpecimen [Substance Units];meq/Spec),
   * MilliEquivalentsPerSquareMeter (MilliEquivalentsPerSquareMeter [Areic Substance
   * Units];meg/m^2), MilliGram (MilliGram [SI Mass Units];mg), MilliGramPerGramCreatinine
   * (MilliGramPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units];mg/g Cre),
   * MilliGramPerTotalVolume (MilliGramPerTotalVolume [SI Mass Units];mg/Total Volume),
   * MilliGramsPerCubicMeter (MilliGramsPerCubicMeter [Mass Concentration Units];mg/m^3),
   * MilliGramsPerDeciLiter (MilliGramsPerDeciLiter;mg/dL), MilliGramsPerGram (MilliGramsPerGram
   * [Mass Ratio Or Mass Fraction Or Mass Content Units];mg/g), MilliGramsPerKiloGram
   * (MilliGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units];mg/kg),
   * MilliGramsPerLiter (MilliGramsPerLiter [Mass Concentration Units];mg/L), MilliGramsPerMilliGram
   * (MilliGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units];mg/mg),
   * MilligramsPerMilligramCreatinine (MilligramsPerMilligramCreatinine [Mass Ratio Or Mass Fraction
   * Or Mass Content Units];mg/mg Cre), MilliGramsPerMilliLiter (MilliGramsPerMilliLiter [Mass
   * Concentration Units];mg/mL), MilliGramsPerSquareMeter (MilliGramsPerSquareMeter [Areic Mass
   * Units];mg/m^2), MilliGramsPerVolume (MilliGramsPerVolume [SI Mass Units];mg/Volume),
   * MilliGramsPhenylketonesPerDeciLiter (MilliGramsPhenylketonesPerDeciLiter [Mass Concentration
   * Units];mg Phe/dL), MilliInternationalUnitsPerLiter (MilliInternationalUnitsPerLiter [Arbitrary
   * Concentration Units];mIU/L), MilliInternationalUnitsPerMilliLiter
   * (MilliInternationalUnitsPerMilliLiter;mIU/mL), MilliLiter (MilliLiter [SI Volume Units];mL),
   * MilliLitersPerDeciLiter (MilliLitersPerDeciLiter [Volume Fraction Units];cc/dL),
   * MilliLitersPerHeartbeat (MilliLitersPerHeartbeat [SI Volume Units];mL/heart beat),
   * MilliLitersPerKiloGram (MilliLitersPerKiloGram [Volume Content Units];mL/kg), MilliMeter
   * (MilliMeter [SI Length Units];mm), MilliMetersOfMercury (MilliMetersOfMercury;mm Hg), MilliMole
   * (MilliMole [Substance Units];mmol), MilliMolesPerDeciLiter (MilliMolesPerDeciLiter [Substance
   * Concentration Units];mmol/dL), MilliMolesPerGram (MilliMolesPerGram [Substance Content
   * Units];mmol/g), MilliMolesPerKiloGram (MilliMolesPerKiloGram;mmol/kg), MilliMolesPerLiter
   * (MilliMolesPerLiter;mmol/L), MilliMolesPerMole (MilliMolesPerMole [Substance Ratio Or Substance
   * Fraction Units];mmol/mol), MilliMolesPerMoleCreatinine (MilliMolesPerMoleCreatinine [Substance
   * Ratio Or Substance Fraction Units];mmol/mol Cre), MilliMolesPerSquareMeter
   * (MilliMolesPerSquareMeter [Areic Substance Units];mmol/m^2), MilliMolesPerTotalVolume
   * (MilliMolesPerTotalVolume [Substance Units];mmol/Total Volume), Million (Million
   * [Unity];x10^6), MillionEquivalentsPerMilliLiter (MillionEquivalentsPerMilliLiter [Substance
   * Concentration Units];10^6 eq/mL), MillionInternationalUnit (MillionInternationalUnit [Arbitrary
   * Units];10^6 IU), MillionPerLiter (MillionPerLiter [Number Concentration Units];10^6/L),
   * MillionPerMilliLiter (MillionPerMilliLiter [Number Concentration Units];10^6/mL),
   * MillionPerSpecimen (MillionPerSpecimen [Unity];x10^6/spec), MillionsPerMicroLiter
   * (MillionsPerMicroLiter;M/uL, x10^6/mm^3), MilliOsmole (MilliOsmole [Substance Units];mosm),
   * MilliOsmolesPerKiloGram (MilliOsmolesPerKiloGram;mOsm/kg), MilliOsmolesPerLiter
   * (MilliOsmolesPerLiter [Substance Concentration Units];mOsm/L), MilliSecond (MilliSecond [Time
   * Units];ms), MilliUnitsPerGram (MilliUnitsPerGram [Substance Rate Content Units];mU/g),
   * MilliUnitsPerGramHemoglobin (MilliUnitsPerGramHemoglobin [Substance Rate Content Units];mU/g
   * Hgb), MilliUnitsPerMilligram (MilliUnitsPerMilligram [Substance Rate Content Units];mU/mg),
   * MilliUnitsPerMilliGramCreatinine (MilliUnitsPerMilliGramCreatinine [Substance Rate Content
   * Units];mU/mg Cre), Minute (Minute [Time Units];min), Mole (Mole [Substance Units];mol),
   * MolesPerCubicMeter (MolesPerCubicMeter [Substance Concentration Units];mol/m^3),
   * MolesPerKiloGram (MolesPerKiloGram [Substance Content Units];mol/kg), MolesPerLiter
   * (MolesPerLiter [Substance Concentration Units];mol/L), MolesPerMilliLiter (MolesPerMilliLiter
   * [Substance Concentration Units];mol/mL), Month (Month [Time Units];Mo), NanoGram (NanoGram [SI
   * Mass Units];ng), NanoGramsPerDeciLiter (NanoGramsPerDeciLiter [Mass Concentration
   * Units];ng/dL), NanoGramsPerGram (NanoGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content
   * Units];ng/g), NanoGramsPerGramCreatinine (NanoGramsPerGramCreatinine [Mass Ratio Or Mass
   * Fraction Or Mass Content Units];ng/g Cre), NanoGramsPerKiloGram (NanoGramsPerKiloGram [Mass
   * Ratio Or Mass Fraction Or Mass Content Units];ng/kg), NanoGramsPerLiter (NanoGramsPerLiter
   * [Mass Concentration Units];ng/L), NanoGramsPerMilliGram (NanoGramsPerMilliGram [Mass Ratio Or
   * Mass Fraction Or Mass Content Units];ng/mg), NanoGramsPerMilliGramProtein
   * (NanoGramsPerMilliGramProtein [Mass Ratio Or Mass Fraction Or Mass Content Units];ng/mg Prot),
   * NanoGramsPerMilliLiter (NanoGramsPerMilliLiter;ng/mL), NanoGramsPerMilliLiterRedBloodCells
   * (NanoGramsPerMilliLiterRedBloodCells [Mass Concentration Units];ng/mL RBCs),
   * NanoGramsPerSquareMeter (NanoGramsPerSquareMeter [Areic Mass Units];ng/m^2), NanoLiter
   * (NanoLiter [SI Volume Units];nL), NanoMeter (NanoMeter [SI Length Units];nm), NanoMole
   * (NanoMole [Substance Units];nmol), NanoMolesPerDeciLiter (NanoMolesPerDeciLiter [Substance
   * Concentration Units];nmol/dL), NanoMolesPerGram (NanoMolesPerGram [Substance Content
   * Units];nmol/g), NanoMolesPerGramCreatinine (NanoMolesPerGramCreatinine [Substance Content
   * Units];nmol/g Cre), NanoMolesPerLiter (NanoMolesPerLiter;nmol/L), NanoMolesPerMilliGram
   * (NanoMolesPerMilliGram [Substance Content Units];nmol/mg), NanoMolesPerMilliLiter
   * (NanoMolesPerMilliLiter [Substance Concentration Units];nmol/mL), NanoMolesPerMilliMole
   * (NanoMolesPerMilliMole [Substance Ratio Or Substance Fraction Units];nmol/mmol),
   * NanoMolesPerMilliMoleCreatinine (NanoMolesPerMilliMoleCreatinine [Substance Ratio Or Substance
   * Fraction Units];nmol/mmol Cre), NanoMolesPerMole (NanoMolesPerMole [Substance Ratio Or
   * Substance Fraction Units];nmol/mol), NanoSecond (NanoSecond [Time Units];ns), NauticalMile
   * (NauticalMile [English Length Units];n mile), OneHundredThousand (OneHundredThousand
   * [Unity];x10^5), OsmolesPerKiloGram (OsmolesPerKiloGram [Substance Content Units];Osm/kg),
   * OsmolesPerLiter (OsmolesPerLiter [Substance Concentration Units];Osm/L), Ounce (Ounce [English
   * Mass Units];oz), Per100 (Per100 [Entitic Number Units];/100), Per100Spermatozoa
   * (Per100Spermatozoa [Entitic Number Units];/100 Sperm), Per100WBC (Per100WBC [Entitic Number
   * Units];/100 WBCs), PerArbitraryUnit (PerArbitraryUnit [Arbitrary Number Units];/Arbitrary
   * Unit), PerBillion (PerBillion [Number Fraction Units];/10^9), Percent (Percent;%),
   * Percent0to3Hours (Percent0to3Hours [General Fraction Unit];% 0-3 h), PercentAbnormal
   * (PercentAbnormal [Number Fraction Units];% Abnormal), PercentActivity (PercentActivity
   * [Catalytic Fraction Or Arbitrary Fraction Units];% Activity), PercentBasalActivity
   * (PercentBasalActivity [Catalytic Fraction Or Arbitrary Fraction Units];% Basal Activity),
   * PercentBinding (PercentBinding [Mass Or Substance Fraction Units];% Binding), PercentBlockade
   * (PercentBlockade [Number Fraction Units];% Blockade), PercentBound (PercentBound [Mass Or
   * Substance Fraction Units];% Bound), PercentCarboxyhemoglobin (PercentCarboxyhemoglobin [Mass Or
   * Substance Fraction Units];% CO Hgb), PercentEosinophilsSeen (PercentEosinophilsSeen [Number
   * Fraction Units];% EOS Seen), PercentExcretion (PercentExcretion [Mass Or Substance Rate
   * Fraction Units];% Excretion), PercentFetalErythrocytes (PercentFetalErythrocytes [Number
   * Fraction Units];% Fetal RBC), PercentHemoglobin (PercentHemoglobin [Mass Or Substance Fraction
   * Units];% Hgb), PercentHemoglobinA1C (PercentHemoglobinA1C [Mass Or Substance Fraction Units];%
   * Hgb A1C), PercentHemoglobinSaturation (PercentHemoglobinSaturation [Mass Or Substance Fraction
   * Units];% Hgb SAT), PercentHemolysis (PercentHemolysis [Number Fraction Units];% Hemolysis),
   * PercentInhibition (PercentInhibition [Catalytic Fraction Or Arbitrary Fraction Units];%
   * Inhibition), PercentNormal (PercentNormal [Number Fraction Units];% Normal),
   * PercentNormalPooledPlasma (PercentNormalPooledPlasma [Catalytic Fraction Or Arbitrary Fraction
   * Units];% Normal Pooled Plasma), PercentofBacteria (PercentofBacteria [Number Fraction Units];%
   * Bacteria), PercentOfLymphocytes (PercentOfLymphocytes [Number Fraction Units];% Lymphs),
   * PercentOfWBCs (PercentOfWBCs [Number Fraction Units];% WBCs), PercentOxygen (PercentOxygen
   * [Volume Fraction Units];% Oxygen), PercentPer100WBC (PercentPer100WBC [Number Fraction Units];%
   * per 100 WBC), PercentPositive (PercentPositive [Number Fraction Units];% Positive),
   * PercentSpermMotility (PercentSpermMotility [Number Fraction Units];% Sperm Motility),
   * PercentTotal (PercentTotal [General Fraction Unit];% of Total), PercentTotalProtein
   * (PercentTotalProtein [Mass Or Substance Fraction Units];% Total Protein), PercentUptake
   * (PercentUptake [Mass Or Substance Rate Fraction Units];% Uptake), PerDeciLiter (PerDeciLiter
   * [Number Concentration Units];/dL), PerEntity (PerEntity [Entitic Number Units];/Entity),
   * PerGram (PerGram [Number Content Units];/g), PerGramCreatinine (PerGramCreatinine [Number
   * Content Units];/g Cre), PerGramHemoglobin (PerGramHemoglobin [Number Content Units];/g Hgb),
   * PerGramTotalNitrogen (PerGramTotalNitrogen [Number Content Units];/g Total Nitrogen),
   * PerGramTotalProtein (PerGramTotalProtein [Number Content Units];/g Total Protein),
   * PerGramWetTissue (PerGramWetTissue [Number Content Units];/g Wet Tissue), PerKiloGram
   * (PerKiloGram [Number Content Units];/kg), PerKiloGramBodyWeight (PerKiloGramBodyWeight [Number
   * Content Units];/kg Body Weight), PerLiter (PerLiter [Number Concentration Units];/L),
   * PerMicroLiter (PerMicroLiter;/uL), PerMilliGram (PerMilliGram [Number Content Units];mg),
   * PerMilliLiter (PerMilliLiter [Number Concentration Units];/mL), PerMillion (PerMillion [Number
   * Fraction Units];/10^6), PerSquareMeter (PerSquareMeter [Areic Number Units];/m^2), PerTenGiga
   * (PerTenGiga [Number Fraction Units];/10^10), PerTotalCount (PerTotalCount [Unity];/Total),
   * PerTrillion (PerTrillion [Number Fraction Units];/10^12), PerTrillionRedBloodCells
   * (PerTrillionRedBloodCells [Entitic Number Units];/10^12 RBCs), pH (pH [pH Units];pH), PicoGram
   * (PicoGram [SI Mass Units];pg), PicoGrams (PicoGrams;pg), PicoGramsPerDeciLiter
   * (PicoGramsPerDeciLiter [Mass Concentration Units];pg/dL), PicoGramsPerLiter (PicoGramsPerLiter
   * [Mass Concentration Units];pg/L), PicoGramsPerMilliLiter (PicoGramsPerMilliLiter;pg/mL),
   * PicoGramsPerMilliMeter (PicoGramsPerMilliMeter [Lineic Mass Units];pg/mm), PicoLiter (PicoLiter
   * [SI Volume Units];pL), PicoMeter (PicoMeter [SI Length Units];pm), PicoMole (PicoMole
   * [Substance Units];pmol), PicoMolesPerDeciLiter (PicoMolesPerDeciLiter [Substance Concentration
   * Units];pmol/dL), PicoMolesPerLiter (PicoMolesPerLiter;pmol/L), PicoMolesPerMicroMole
   * (PicoMolesPerMicroMole [Substance Ratio Or Substance Fraction Units];pmol/umol),
   * PicoMolesPerMilliLiter (PicoMolesPerMilliLiter [Substance Concentration Units];pmol/mL),
   * PicoSecond (PicoSecond [Time Units];ps), Pint (Pint [English Volume Units];pt), Pound (Pound
   * [English Mass Units];lb), Quart (Quart [English Volume Units];qt), RedBloodCellsPerMicroLiter
   * (RedBloodCellsPerMicroLiter [Number Concentration Units];RBC/mm^3), RelativePercent
   * (RelativePercent [General Fraction Unit];Relative %), Second (Second [Time Units];sec),
   * SpermatozoaPerMilliLiter (SpermatozoaPerMilliLiter [Number Concentration Units];Sperm/mL),
   * SquareCentiMeter (SquareCentiMeter [SI Area Units];cm^2), SquareFeet (SquareFeet [English Area
   * Units];ft^2), SquareInch (SquareInch [English Area Units];in^2), SquareMeter (SquareMeter [SI
   * Area Units];m^2), SquareMilliMeter (SquareMilliMeter [SI Area Units];mm^2), SquareYard
   * (SquareYard [English Area Units];yd^2), StatuteMile (StatuteMile [English Length Units];mi),
   * TenToEighth (TenToEighth [Unity];x10^8), Thousand (Thousand [Unity];x10^3),
   * ThousandCopiesPerMilliLiter (ThousandCopiesPerMilliLiter [Number Concentration Units];10^3
   * copies/mL), ThousandPerLiter (ThousandPerLiter [Number Concentration Units];10^3/L),
   * ThousandPerMilliLiter (ThousandPerMilliLiter [Number Concentration Units];10^3/mL),
   * ThousandRedBloodCells (ThousandRedBloodCells [Unity];x10^3 RBCs), ThousandsPerMicroLiter
   * (ThousandsPerMicroLiter;K/uL, x10^3/mm^3), Ton (Ton [English Mass Units];Ton), TrillionPerLiter
   * (TrillionPerLiter [Number Concentration Units];10^12/L), TroyOunce (TroyOunce [English Mass
   * Units];tr oz), UnitsPerGram (UnitsPerGram [Substance Rate Content Units];U/g),
   * UnitsPerGramCreatinine (UnitsPerGramCreatinine [Substance Rate Content Units];U/g Cre),
   * UnitsPerGramHemoglobin (UnitsPerGramHemoglobin [Substance Rate Content Units];U/g Hgb),
   * UnitsPerLiter (UnitsPerLiter;U/L), VolumePercent (VolumePercent [Volume Fraction Units];Volume
   * %), Week (Week [Time Units];wk), Yard (Yard [English Length Units];yd), Year (Year [Time
   * Units];yr)
   */
  public enum UCUM {
    AHGEquivalentsPerMilliLiter, BillionPerLiter, BillionsPerMicroLiter, BillionsPerMilliliter, BoneCollagenEquivalentsPerMicroMoleCreatinine, BoneCollagenEquivalentsPerMilliMoleCreatinine, CellsPerMicroLiter, CentiGram, CentiLiter, CentiMeter, ColonyFormingUnitsPerMilliLiter, ComplementCh50UnitsPerMilliLiter, CopiesPerMilliLiter, CubicInch, Cup, Day, DeciGram, DeciLiter, DeciMeter, DegreesCelsius, DegreesFahrenheit, DegreesKelvin, DegreesOfArc, Dram, EhrlichUnitsPer100Gram, EhrlichUnitsPerDeciLiter, ElisaUnitsPerMilliLiter, Equivalent, EquivalentsPerLiter, EquivalentsPerMicroMole, EquivalentsPerMilliLiter, EquivalentsPerMilliMole, Fathom, Feet, FemtoGram, FemtoLiter, FemtoMeter, Femtomole, FemtoMolesPerGram, FemtoMolesPerMilliGram, FemtoMolesPerMilliLiter, FluidDram, FluidOunce, French, Gallon, Grain, Gram, GramMeter, GramMeterPerHeartbeat, GramMeterPerHeartbeatPerSquareMeter, GramsPer100Gram, GramsPerDeciLiter, GramsPerGram, GramsPerGramCreatinine, GramsPerKiloGram, GramsPerLiter, GramsPerMilliLiter, GramsPerSquareMeter, GramsPerTotalWeight, HectoLiter, Hour, IgAPhospholipidUnitsPerMilliLiter, IgGPhospholipidUnitsPerMilliLiter, IgMPhospholipidUnitsPerMilliLiter, Inch, InternationalUnit, InternationalUnitsPerDeciLiter, InternationalUnitsPerGram, InternationalUnitsPerGramHemoglobin, InternationalUnitsPerKilogram, InternationalUnitsPerLiter, InternationalUnitsPerMilliLiter, KatalPerKilogram, KelvinPerWatt, KiloCaloriesPerOunce, KiloGram, KiloGramsPerCubicMeter, KiloGramsPerLiter, KiloGramsPerMole, KiloGramsPerSquareMeter, KiloInternationalUnitsPerMilliLiter, KiloLiter, KiloMeter, KiloPascal, KiloSecond, KiloUnitsPerGram, Liter, LitersPerKilogram, LiterSquareSecondPerSecond, Log10, Megasecond, Meter, MetricTon, MicroEquivalent, MicroEquivalentsPerLiter, MicroEquivalentsPerMilliLiter, MicroGram, MicroGramPer100Gram, MicroGramPerGramCreatinine, MicroGramPerGramDryWeight, MicroGramsPerDeciLiter, MicroGramsPerDeciLiterRedBloodCells, MicroGramsPerGram, MicroGramsPerGramHemoglobin, MicroGramsPerKiloGram, MicroGramsPerLiter, MicroGramsPerMilliGram, MicroGramsPerMilliGramCreatinine, MicroGramsPerMilliLiter, MicroGramsPerNanoGram, MicroGramsPerSpecimen, MicroGramsPerSquareMeter, MicroGramsPerTotalVolume, MicroInternationalUnit, MicroInternationalUnitsPerMilliLiter, MicroLiter, MicroMeter, MicroMole, MicroMolesPerDeciLiter, MicroMolesPerGram, MicroMolesPerGramCreatinine, MicroMolesPerGramHemoglobin, MicroMolesPerLiter, MicroMolesPerMilliGram, MicroMolesPerMilliGramCreatinine, MicroMolesPerMilliLiter, MicroMolesPerMinutePerGram, MicroMolesPerMole, MicroMolesPerMoleCreatinine, MicroSecond, MilliEquivalent, MilliEquivalentPerMilliLiter, MilliEquivalentsPerDeciLiter, MilliEquivalentsPerGram, MilliEquivalentsPerGramCreatinine, MilliEquivalentsPerKiloGram, MilliEquivalentsPerLiter, MilliEquivalentsPerSpecimen, MilliEquivalentsPerSquareMeter, MilliGram, MilliGramPerGramCreatinine, MilliGramPerTotalVolume, MilliGramsPerCubicMeter, MilliGramsPerDeciLiter, MilliGramsPerGram, MilliGramsPerKiloGram, MilliGramsPerLiter, MilliGramsPerMilliGram, MilligramsPerMilligramCreatinine, MilliGramsPerMilliLiter, MilliGramsPerSquareMeter, MilliGramsPerVolume, MilliGramsPhenylketonesPerDeciLiter, MilliInternationalUnitsPerLiter, MilliInternationalUnitsPerMilliLiter, MilliLiter, MilliLitersPerDeciLiter, MilliLitersPerHeartbeat, MilliLitersPerKiloGram, MilliMeter, MilliMetersOfMercury, MilliMole, MilliMolesPerDeciLiter, MilliMolesPerGram, MilliMolesPerKiloGram, MilliMolesPerLiter, MilliMolesPerMole, MilliMolesPerMoleCreatinine, MilliMolesPerSquareMeter, MilliMolesPerTotalVolume, Million, MillionEquivalentsPerMilliLiter, MillionInternationalUnit, MillionPerLiter, MillionPerMilliLiter, MillionPerSpecimen, MillionsPerMicroLiter, MilliOsmole, MilliOsmolesPerKiloGram, MilliOsmolesPerLiter, MilliSecond, MilliUnitsPerGram, MilliUnitsPerGramHemoglobin, MilliUnitsPerMilligram, MilliUnitsPerMilliGramCreatinine, Minute, Mole, MolesPerCubicMeter, MolesPerKiloGram, MolesPerLiter, MolesPerMilliLiter, Month, NanoGram, NanoGramsPerDeciLiter, NanoGramsPerGram, NanoGramsPerGramCreatinine, NanoGramsPerKiloGram, NanoGramsPerLiter, NanoGramsPerMilliGram, NanoGramsPerMilliGramProtein, NanoGramsPerMilliLiter, NanoGramsPerMilliLiterRedBloodCells, NanoGramsPerSquareMeter, NanoLiter, NanoMeter, NanoMole, NanoMolesPerDeciLiter, NanoMolesPerGram, NanoMolesPerGramCreatinine, NanoMolesPerLiter, NanoMolesPerMilliGram, NanoMolesPerMilliLiter, NanoMolesPerMilliMole, NanoMolesPerMilliMoleCreatinine, NanoMolesPerMole, NanoSecond, NauticalMile, OneHundredThousand, OsmolesPerKiloGram, OsmolesPerLiter, Ounce, Per100, Per100Spermatozoa, Per100WBC, PerArbitraryUnit, PerBillion, Percent, Percent0to3Hours, PercentAbnormal, PercentActivity, PercentBasalActivity, PercentBinding, PercentBlockade, PercentBound, PercentCarboxyhemoglobin, PercentEosinophilsSeen, PercentExcretion, PercentFetalErythrocytes, PercentHemoglobin, PercentHemoglobinA1C, PercentHemoglobinSaturation, PercentHemolysis, PercentInhibition, PercentNormal, PercentNormalPooledPlasma, PercentofBacteria, PercentOfLymphocytes, PercentOfWBCs, PercentOxygen, PercentPer100WBC, PercentPositive, PercentSpermMotility, PercentTotal, PercentTotalProtein, PercentUptake, PerDeciLiter, PerEntity, PerGram, PerGramCreatinine, PerGramHemoglobin, PerGramTotalNitrogen, PerGramTotalProtein, PerGramWetTissue, PerKiloGram, PerKiloGramBodyWeight, PerLiter, PerMicroLiter, PerMilliGram, PerMilliLiter, PerMillion, PerSquareMeter, PerTenGiga, PerTotalCount, PerTrillion, PerTrillionRedBloodCells, pH, PicoGram, PicoGrams, PicoGramsPerDeciLiter, PicoGramsPerLiter, PicoGramsPerMilliLiter, PicoGramsPerMilliMeter, PicoLiter, PicoMeter, PicoMole, PicoMolesPerDeciLiter, PicoMolesPerLiter, PicoMolesPerMicroMole, PicoMolesPerMilliLiter, PicoSecond, Pint, Pound, Quart, RedBloodCellsPerMicroLiter, RelativePercent, Second, SpermatozoaPerMilliLiter, SquareCentiMeter, SquareFeet, SquareInch, SquareMeter, SquareMilliMeter, SquareYard, StatuteMile, TenToEighth, Thousand, ThousandCopiesPerMilliLiter, ThousandPerLiter, ThousandPerMilliLiter, ThousandRedBloodCells, ThousandsPerMicroLiter, Ton, TrillionPerLiter, TroyOunce, UnitsPerGram, UnitsPerGramCreatinine, UnitsPerGramHemoglobin, UnitsPerLiter, VolumePercent, Week, Yard, Year

  }


}
