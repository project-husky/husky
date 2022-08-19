/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.common.enums;

import org.husky.common.hl7cdar2.CD;
import org.husky.common.model.Code;

/*
*<div class="en">UCUM - Units of Measure</div>
*<div class="de">UCUM - Maßeinheiten</div>
*/
public enum Ucum {

	/**
	 * <div class="en">AHGEquivalentsPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	AHG_EQUIVALENTS_PER_MILLILITER(Ucum.AHG_EQUIVALENTS_PER_MILLILITER_CODE,
			"AHGEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> BillionPerLiter [Number Concentration Units] </div>
	 */
	BILLION_PER_LITER(Ucum.BILLION_PER_LITER_CODE, "BillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> BillionsPerMicroLiter [Number Concentration
	 * Units]</div>
	 */
	BILLIONS_PER_MICROLITER(Ucum.BILLIONS_PER_MICROLITER_CODE, "BillionsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> BillionsPerMilliliter [Number Concentration Units]
	 * </div>
	 */
	BILLIONS_PER_MILLILITER(Ucum.BILLIONS_PER_MILLILITER_CODE, "BillionsPerMilliliter [Number Concentration Units]"),
	/**
	 * <div class= "en"> BoneCollagenEquivalentsPerMicroMoleCreatinine
	 * [Substance Ratio Or Substance Fraction Units] </div>
	 */
	BONE_COLLAGEN_EQUIVALENTS_PER_MICRO_MOLE_CREATININE(Ucum.BONE_COLLAGEN_EQUIVALENTS_PER_MICROMOLE_CREATININE_CODE,
			"BoneCollagenEquivalentsPerMicroMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> BoneCollagenEquivalentsPerMilliMoleCreatinine
	 * [Substance Ratio Or Substance Fraction Units] </div>
	 */
	BONE_COLLAGEN_EQUIVALENTS_PER_MILLI_MOLE_CREATININE(Ucum.BONE_COLLAGEN_EQUIVALENTS_PER_MILLIOMOLE_CREATININE_CODE,
			"BoneCollagenEquivalentsPerMilliMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> CellsPerMicroLiter [Number Concentration Units] </div>
	 */
	CELLS_PER_MICROLITER(Ucum.CELLS_PER_MICROLITER_CODE, "CellsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> CentiGram [SI Mass Units]</div>
	 */
	CENTI_GRAM("cg", "CentiGram [SI Mass Units]"),
	/**
	 * <div class="en">CentiLiter [SI Volume Units]</div>
	 */
	CENTI_LITER("cL", "CentiLiter [SI Volume Units]"),
	/**
	 * <div class="en">CentiMeter [SI Length Units]</div>
	 */
	CENTI_METER("cm", "CentiMeter [SI Length Units]"),
	/**
	 * <div class="en"> ColonyFormingUnitsPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	COLONY_FORMING_UNITS_PER_MILLILITER(Ucum.COLONY_FORMING_UNITS_PER_MILLILITER_CODE,
			"ColonyFormingUnitsPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class = "en"> ComplementCh50UnitsPerMilliLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	COMPLEMENT_CH_50_UNITS_PER_MILLILITER(Ucum.COMPLEMENT_CH50_UNITS_PER_MILLILITER_CODE,
			"ComplementCh50UnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> CopiesPerMilliLiter [Number Concentration Units]
	 * </div>
	 */
	COPIES_PER_MILLILITER(Ucum.COPIES_PER_MILLILITER_CODE, "CopiesPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> CubicInch [English Volume Units] </div>
	 */
	CUBIC_INCH(Ucum.CUBIC_INCH_CODE, "CubicInch [English Volume Units]"),
	/**
	 * <div class="en">Cup [English Volume Units]</div>
	 */
	CUP(Ucum.CUP_CODE, "Cup [English Volume Units]"),
	/**
	 * <div class="en">Day [Time Units]</div>
	 */
	DAY("d", "Day [Time Units]"),
	/**
	 * <div class="en">DeciGram [SI Mass Units]</div>
	 */
	DECI_GRAM("dg", "DeciGram [SI Mass Units]"),
	/**
	 * <div class="en">DeciLiter [SI Volume Units]</div>
	 */
	DECI_LITER("dL", "DeciLiter [SI Volume Units]"),
	/**
	 * <div class="en">DeciMeter [SI Length Units]</div>
	 */
	DECI_METER("dm", "DeciMeter [SI Length Units]"),
	/**
	 * <div class="en">DegreesCelsius [Temperature Units]</div>
	 */
	DEGREES_CELSIUS("Cel", "DegreesCelsius [Temperature Units]"),
	/**
	 * <div class="en"> DegreesFahrenheit [Temperature Units]</div>
	 */
	DEGREES_FAHRENHEIT(Ucum.DEGREES_FAHRENHEIT_CODE, "DegreesFahrenheit [Temperature Units]"),
	/**
	 * <div class="en"> DegreesKelvin [Temperature Units]</div>
	 */
	DEGREES_KELVIN("K", "DegreesKelvin [Temperature Units]"),
	/**
	 * <div class="en"> DegreesOfArc [Plane Angle Units]</div>
	 */
	DEGREES_OF_ARC("deg", "DegreesOfArc [Plane Angle Units]"),
	/**
	 * <div class="en"> Descriptive Name</div>
	 */
	DESCRIPTIVE("Code", "Descriptive Name"),
	/**
	 * <div class="en">Dram [English Mass Units]</div>
	 */
	DRAM(Ucum.DRAM_CODE, "Dram [English Mass Units]"),
	/**
	 * <div class="en"> EhrlichUnitsPer100Gram [Arbitrary Concentration Content
	 * Units]</div>
	 */
	EHRLICH_UNITS_PER_100_GRAM(Ucum.EHRLICH_UNITS_PER_100_GRAM_CODE,
			"EhrlichUnitsPer100Gram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class = "en"> EhrlichUnitsPerDeciLiter [Arbitrary Concentration
	 * Units] </div>
	 */
	EHRLICH_UNITS_PER_DECI_LITER(Ucum.EHRLICH_UNITS_PER_DECILITER_CODE,
			"EhrlichUnitsPerDeciLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> ElisaUnitsPerMilliLiter [Arbitrary Concentration
	 * Units] </div>
	 */
	ELISA_UNITS_PER_MILLILITER(Ucum.ELISA_UNITY_PER_MILLILITER_CODE,
			"ElisaUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> Equivalent [Substance Units] </div>
	 */
	EQUIVALENT("eq", "Equivalent [Substance Units]"),
	/**
	 * <div class="en"> EquivalentsPerLiter [Substance Concentration
	 * Units]</div>
	 */
	EQUIVALENTS_PER_LITER("eq/L", "EquivalentsPerLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> EquivalentsPerMicroMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	EQUIVALENTS_PER_MICRO_MOLE(Ucum.EQUIVALENTS_PER_MICROMOLE_CODE,
			"EquivalentsPerMicroMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> EquivalentsPerMilliLiter [Substance Concentration
	 * Units] </div>
	 */
	EQUIVALENTS_PER_MILLILITER(Ucum.EQUIVALENTS_PER_MILLILITER_CODE, "EquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> EquivalentsPerMilliMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	EQUIVALENTS_PER_MILLIMOLE(Ucum.EQUIVALENTS_PER_MILLIMOLE_CODE,
			"EquivalentsPerMilliMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> Fathom [English Length Units] </div>
	 */
	FATHOM(Ucum.FATHOM_CODE, "Fathom [English Length Units]"),
	/**
	 * <div class="en">Feet [English Length Units]</div>
	 */
	FEET(Ucum.FEET_CODE, "Feet [English Length Units]"),
	/**
	 * <div class="en">FemtoGram [SI Mass Units]</div>
	 */
	FEMTO_GRAM("fg", "FemtoGram [SI Mass Units]"),
	/**
	 * <div class="en">FemtoLiter [Most Common Healthcare Units]</div>
	 */
	FEMTO_LITER("fL", "FemtoLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en"> FemtoMeter [SI Length Units]</div>
	 */
	FEMTO_METER("fm", "FemtoMeter [SI Length Units]"),
	/**
	 * <div class="en">Femtomole [Substance Units]</div>
	 */
	FEMTO_MOLE("fmol", "Femtomole [Substance Units]"),
	/**
	 * <div class="en">FemtoMolesPerGram [Substance Content Units]</div>
	 */
	FEMTO_MOLES_PER_GRAM(Ucum.FEMTOMOLES_PER_GRAM_CODE, "FemtoMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en"> FemtoMolesPerMilliGram [Substance Content Units]</div>
	 */
	FEMTO_MOLES_PER_MILLIGRAM(Ucum.FEMTOMOLES_PER_MILLIGRAM_CODE, "FemtoMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class= "en"> FemtoMolesPerMilliLiter [Substance Concentration Units]
	 * </div>
	 */
	FEMTO_MOLES_PER_MILLILITER(Ucum.FEMTOMOLES_PER_MILLILITER_CODE, "FemtoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> FluidDram [English Volume Units] </div>
	 */
	FLUID_DRAM(Ucum.FLUID_DRAM_CODE, "FluidDram [English Volume Units]"),
	/**
	 * <div class="en"> FluidOunce [English Volume Units]</div>
	 */
	FLUID_OUNCE(Ucum.FLUID_OUNCE_CODE, "FluidOunce [English Volume Units]"),
	/**
	 * <div class="en">French [English Length Units]</div>
	 */
	FRENCH("[Ch]", "French [English Length Units]"),
	/**
	 * <div class="en">Gallon [English Volume Units]</div>
	 */
	GALLON(Ucum.GALLON_CODE, "Gallon [English Volume Units]"),
	/**
	 * <div class="en">Grain [English Mass Units]</div>
	 */
	GRAIN("[gr]", "Grain [English Mass Units]"),
	/**
	 * <div class="en">Gram [SI Mass Units]</div>
	 */
	GRAM("g", "Gram [SI Mass Units]"),
	/**
	 * <div class="en">GramMeter [Massive Distance Units]</div>
	 */
	GRAM_METER("g.m", "GramMeter [Massive Distance Units]"),
	/**
	 * <div class="en"> GramMeterPerHeartbeat [Massive Distance Units]</div>
	 */
	GRAM_METER_PER_HEARTBEAT(Ucum.GRAM_METER_PER_HEARTBEAT_CODE, "GramMeterPerHeartbeat [Massive Distance Units]"),
	/**
	 * <div class= "en"> GramMeterPerHeartbeatPerSquareMeter [Lineic Mass
	 * Units]</div>
	 */
	GRAM_METER_PER_HEARTBEAT_PER_SQUARE_METER(Ucum.GRAM_METER_PER_HEARTBEAT_PER_SQUARE_METER_CODE,
			"GramMeterPerHeartbeatPerSquareMeter [Lineic Mass Units]"),
	/**
	 * <div class = "en"> GramsPer100Gram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	GRAMS_PER_100_GRAM(Ucum.GRAMS_PER_100_GRAM_CODE,
			"GramsPer100Gram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> GramsPerDeciLiter [Most Common Healthcare Units]
	 * </div>
	 */
	GRAMS_PER_DECI_LITER("g/dL", "GramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> GramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	GRAMS_PER_GRAM("g/g", "GramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> GramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	GRAMS_PER_GRAM_CREATININE(Ucum.GRAMS_PER_GRAM_CREATININE_CODE,
			"GramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> GramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	GRAMS_PER_KILOGRAM("g/kg",
			"GramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> GramsPerLiter [Most Common Healthcare Units] </div>
	 */
	GRAMS_PER_LITER("g/L", "GramsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> GramsPerMilliLiter [Most Common Healthcare Units]</div>
	 */
	GRAMS_PER_MILLILITER("g/mL", "GramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> GramsPerSquareMeter [Areic Mass Units] </div>
	 */
	GRAM_PER_SQUARE_METER("g/m2", "GramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> GramsPerTotalWeight [SI Mass Units]</div>
	 */
	GRAM_PER_TOTAL_WEIGHT(Ucum.GRAMS_PER_TOTAL_WEIGHT_CODE, "GramsPerTotalWeight [SI Mass Units]"),
	/**
	 * <div class="en"> HectoLiter [SI Volume Units]</div>
	 */
	HECTO_LITER("hL", "HectoLiter [SI Volume Units]"),
	/**
	 * <div class="en">Hour [Time Units]</div>
	 */
	HOUR("h", "Hour [Time Units]"),
	/**
	 * <div class="en"> IgAPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	IGA_PHOSPHOLIPID_UNITS_PER_MILLILITER(Ucum.IGA_PHOSPHOLIPID_UNITS_PER_MILLILITER_CODE,
			"IgAPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> IgGPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	IGG_PHOSPHOLIPID_UNITS_PER_MILLILITER(Ucum.IGG_PHOSPHOLIPID_UNITS_PER_MILLILITER_CODE,
			"IgGPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> IgMPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	IGM_PHOSPHOLIPID_UNITS_PER_MILLILITER(Ucum.IGM_PHOSPHOLIPID_UNITS_PER_MILLILITER_CODE,
			"IgMPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> Inch [English Length Units] </div>
	 */
	INCH(Ucum.INCH_CODE, "Inch [English Length Units]"),
	/**
	 * <div class="en">InternationalUnit [Arbitrary Units]</div>
	 */
	INTERNATIONAL_UNIT("[iU]", "InternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en"> InternationalUnitsPerDeciLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	INTERNATIONAL_UNITS_PER_DECILITER(Ucum.INTERNATIONAL_UNITS_PER_DECILITER_CODE,
			"InternationalUnitsPerDeciLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerGram [Arbitrary Concentration
	 * Content Units] </div>
	 */
	INTERNATIONAL_UNITS_PER_GRAM(Ucum.INTERNATIONAL_UNITS_PER_GRAM_CODE,
			"InternationalUnitsPerGram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerGramHemoglobin [Arbitrary
	 * Concentration Content Units] </div>
	 */
	INTERNATIONAL_UNITS_PER_GRAM_HEMOGLOBIN(Ucum.INTERNATIONAL_UNITS_PER_GRAM_HEMOGLOBIN_CODE,
			"InternationalUnitsPerGramHemoglobin [Arbitrary Concentration Content Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerKilogram [Arbitrary Concentration
	 * Content Units] </div>
	 */
	INTERNATIONAL_UNITS_PER_KILOGRAM(Ucum.INTERNATIONAL_UNITS_PER_KILOGRAM_CODE,
			"InternationalUnitsPerKilogram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerLiter [Most Common Healthcare
	 * Units] </div>
	 */
	INTERNATIONAL_UNITS_PER_LITER(Ucum.INTERNATIONAL_UNITS_PER_LITER_CODE,
			"InternationalUnitsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	INTERNATIONAL_UNIT_PER_MILLILITER(Ucum.INTERNATIONAL_UNITS_PER_MILLILITER_CODE,
			"InternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> KatalPerKilogram [Substance Rate Content Units] </div>
	 */
	KATAL_PER_KILOGRAM(Ucum.KATAL_PER_KILOGRAM_CODE, "KatalPerKilogram [Substance Rate Content Units]"),
	/**
	 * <div class= "en"> KelvinPerWatt [Thermal Resistance Units]</div>
	 */
	KELVIN_PER_WATT("K/W", "KelvinPerWatt [Thermal Resistance Units]"),
	/**
	 * <div class="en"> KiloCaloriesPerOunce [Energy Content Units]</div>
	 */
	KILO_CALORIES_PER_OUNCE(Ucum.KILO_CALORIES_PER_OUNCE_CODE, "KiloCaloriesPerOunce [Energy Content Units]"),
	/**
	 * <div class="en"> KiloGram [SI Mass Units]</div>
	 */
	KILOGRAM("kg", "KiloGram [SI Mass Units]"),
	/**
	 * <div class="en"> KiloGramsPerCubicMeter [Mass Concentration Units]</div>
	 */
	KILOGRAMS_PER_CUBICMETER(Ucum.KILOGRAMS_PER_CUBICMETER_CODE, "KiloGramsPerCubicMeter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> KiloGramsPerLiter [Mass Concentration Units] </div>
	 */
	KILOGRAMS_PER_LITER("kg/L", "KiloGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> KiloGramsPerMole [Molar Mass Units]</div>
	 */
	KILOGRAMS_PER_MOLE(Ucum.KILOGRAMS_PER_MOLE_CODE, "KiloGramsPerMole [Molar Mass Units]"),
	/**
	 * <div class="en"> KiloGramsPerSquareMeter [Areic Mass Units]</div>
	 */
	KILOGRAMS_PER_SQUARE_METER(Ucum.KILOGRAMS_PER_SQUAREMETER_CODE, "KiloGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> KiloInternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	KILO_INTERNATIONAL_UNITS_PER_MILLILITER(Ucum.KILO_INTERNATIONAL_UNITS_PER_MILLILITER_CODE,
			"KiloInternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> KiloLiter [SI Volume Units] </div>
	 */
	KILOLITER("kL", "KiloLiter [SI Volume Units]"),
	/**
	 * <div class="en">KiloMeter [SI Length Units]</div>
	 */
	KILOMETER("km", "KiloMeter [SI Length Units]"),
	/**
	 * <div class="en">KiloPascal [Most Common Healthcare Units]</div>
	 */
	KILOPASCAL("kPa", "KiloPascal [Most Common Healthcare Units]"),
	/**
	 * <div class="en"> KiloSecond [Time Units]</div>
	 */
	KILOSECOND("ks", "KiloSecond [Time Units]"),
	/**
	 * <div class="en">KiloUnitsPerGram [Substance Rate Content Units]</div>
	 */
	KILO_UNITS_PER_GRAM("kU/g", "KiloUnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class= "en">Liter [SI Volume Units]</div>
	 */
	LITER("L", "Liter [SI Volume Units]"),
	/**
	 * <div class="en">LitersPerKilogram [Volume Content Units]</div>
	 */
	LITERS_PER_KILOGRAM("L/kg", "LitersPerKilogram [Volume Content Units]"),
	/**
	 * <div class="en"> LiterSquareSecondPerSecond [Volume Duration Units]</div>
	 */
	LITER_SQUARE_SECOND_PER_SECOND(Ucum.LITER_SQUARE_SECOND_PER_SECOND_CODE, "LiterSquareSecondPerSecond [Volume Duration Units]"),
	/**
	 * <div class= "en"> Log10 [Unity] </div>
	 */
	LOG10("[lg]", "Log10 [Unity]"),
	/**
	 * <div class="en">Megasecond [Time Units]</div>
	 */
	MEGASECOND("Ms", "Megasecond [Time Units]"),
	/**
	 * <div class="en">Meter [SI Length Units]</div>
	 */
	METER("m", "Meter [SI Length Units]"),
	/**
	 * <div class="en">MetricTon [SI Mass Units]</div>
	 */
	METRIC_TON("t", "MetricTon [SI Mass Units]"),
	/**
	 * <div class="en">MicroEquivalent [Substance Units]</div>
	 */
	MICRO_EQUIVALENT("ueq", "MicroEquivalent [Substance Units]"),
	/**
	 * <div class="en"> MicroEquivalentsPerLiter [Substance Concentration
	 * Units]</div>
	 */
	MICRO_EQUIVALENT_PER_LITER(Ucum.MICRO_EQUIVALENTS_PER_LITER_CODE, "MicroEquivalentsPerLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MicroEquivalentsPerMilliLiter [Substance Concentration
	 * Units] </div>
	 */
	MICRO_EQUIVALENT_PER_MILLILITER(Ucum.MICRO_EQUIVALENTS_PER_MILLILITER_CODE,
			"MicroEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MicroGram [SI Mass Units] </div>
	 */
	MICROGRAM("ug", "MicroGram [SI Mass Units]"),
	/**
	 * <div class="en"> MicroGramPer100Gram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	MICROGRAM_PER_100_GRAM(Ucum.MICROGRAM_PER_100_GRAM_CODE,
			"MicroGramPer100Gram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramPerGramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	MICROGRAM_PER_GRAM_CREATININE(Ucum.MICROGRAM_PER_GRAM_CREATININE_CODE,
			"MicroGramPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramPerGramDryWeight [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units] </div>
	 */
	MICROGRAM_PER_GRAM_DRY_WEIGHT(Ucum.MICROGRAM_PER_GRAM_DRY_WEIGHT_CODE,
			"MicroGramPerGramDryWeight [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerDeciLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MICROGRAMS_PER_DECILITER(Ucum.MICROGRAMS_PER_DECILITER_CODE, "MicroGramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MicroGramsPerDeciLiterRedBloodCells [Mass
	 * Concentration Units] </div>
	 */
	MICROGRAMS_PER_DECILITER_RED_BLOOD_CELLS(Ucum.MICROGRAMS_PER_DECILITER_RED_BLOOD_CELLS_CODE,
			"MicroGramsPerDeciLiterRedBloodCells [Mass Concentration Units]"),
	/**
	 * <div class = "en"> MicroGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	MICROGRAMS_PER_GRAM("ug/g",
			"MicroGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerGramHemoglobin [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	MICROGRAMS_PER_GRAM_HEMOGLOBIN(Ucum.MICROGRAMS_PER_GRAM_HEMOGLOBIN_CODE,
			"MicroGramsPerGramHemoglobin [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerKiloGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	MICROGRAMS_PER_KILOGRAM(Ucum.MICROGRAMS_PER_KILOGRAM_CODE,
			"MicroGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerLiter [Mass Concentration Units] </div>
	 */
	MICROGRAMS_PER_LITER("ug/L", "MicroGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> MicroGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MICROGRAMS_PER_MILLIGRAM(Ucum.MICROGRAMS_PER_MILLIGRAM_CODE,
			"MicroGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerMilliGramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	MICROGRAMS_PER_MILLIGRAM_CREATININE(Ucum.MICROGRAMS_PER_MILLIGRAM_CREATININE_CODE,
			"MicroGramsPerMilliGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerMilliLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MICROGRAMS_PER_MILLILITER(Ucum.MICROGRAMS_PER_MILLILITER_CODE, "MicroGramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MicroGramsPerNanoGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	MICROGRAMS_PER_NANOGRAM(Ucum.MICROGRAMS_PER_NANOGRAM_CODE,
			"MicroGramsPerNanoGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerSpecimen [SI Mass Units] </div>
	 */
	MICROGRAMS_PER_SPECIMEN(Ucum.MICROGRAMS_PER_SPECIMEN_CODE, "MicroGramsPerSpecimen [SI Mass Units]"),
	/**
	 * <div class="en"> MicroGramsPerSquareMeter [Areic Mass Units]</div>
	 */
	MICROGRAMS_PER_SQUAREMETER(Ucum.MICROGRAMS_PER_SQUAREMETER_CODE, "MicroGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> MicroGramsPerTotalVolume [SI Mass Units]</div>
	 */
	MICROGRAMS_PER_TOTAL_VOLUME(Ucum.MICROGRAMS_PER_TOTAL_VOLUME_CODE, "MicroGramsPerTotalVolume [SI Mass Units]"),
	/**
	 * <div class="en"> MicroInternationalUnit [Arbitrary Units]</div>
	 */
	MICRO_INTERNATIONAL_UNIT(Ucum.MICRO_INTERNATIONAL_UNIT_CODE, "MicroInternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en"> MicroInternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	MICRO_INTERNATIONAL_UNITY_PER_MILLILITER(Ucum.MICRO_INTERNATIONAL_UNITS_PER_MILLILITER_CODE,
			"MicroInternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> MicroLiter [SI Volume Units] </div>
	 */
	MICROLITER("uL", "MicroLiter [SI Volume Units]"),
	/**
	 * <div class="en">MicroMeter [SI Length Units]</div>
	 */
	MICROMETER("um", "MicroMeter [SI Length Units]"),
	/**
	 * <div class="en">MicroMole [Substance Units]</div>
	 */
	MICROMOLE("umol", "MicroMole [Substance Units]"),
	/**
	 * <div class="en"> MicroMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	MICROMOLES_PER_DECILITER(Ucum.MICROMOLES_PER_DECILITER_CODE, "MicroMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MicroMolesPerGram [Substance Content Units] </div>
	 */
	MICROMOLES_PER_GRAM(Ucum.MICROMOLES_PER_GRAM_CODE, "MicroMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en"> MicroMolesPerGramCreatinine [Substance Content
	 * Units]</div>
	 */
	MICROMOLES_PER_GRAM_CREATININE(Ucum.MICROMOLES_PER_GRAM_CREATININE_CODE,
			"MicroMolesPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class = "en"> MicroMolesPerGramHemoglobin [Substance Content Units]
	 * </div>
	 */
	MICROMOLES_PER_GRAM_HEMOGLOBIN(Ucum.MICROMOLES_PER_GRAM_HEMOGLOBIN_CODE,
			"MicroMolesPerGramHemoglobin [Substance Content Units]"),
	/**
	 * <div class = "en"> MicroMolesPerLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MICROMOLES_PER_LITER(Ucum.MICROMOLES_PER_LITER_CODE, "MicroMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> MicroMolesPerMilliGram [Substance Content Units] </div>
	 */
	MICROMOLES_PER_MILLIGRAM(Ucum.MICROMOLES_PER_MILLIGRAM_CODE, "MicroMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class= "en"> MicroMolesPerMilliGramCreatinine [Substance Content
	 * Units] </div>
	 */
	MICROMOLES_PER_MILLIGRAM_CREATININE(Ucum.MICROMOLES_PER_MILLIGRAM_CREATININE_CODE,
			"MicroMolesPerMilliGramCreatinine [Substance Content Units]"),
	/**
	 * <div class = "en"> MicroMolesPerMilliLiter [Substance Concentration
	 * Units] </div>
	 */
	MICROMOLES_PER_MILLILITER(Ucum.MICROMOLES_PER_MILLILITER_CODE, "MicroMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MicroMolesPerMinutePerGram [Substance Rate Content
	 * Units] </div>
	 */
	MICROMOLES_PER_MINUTE_PER_GRAM(Ucum.MICROMOLES_PER_MINUTE_PER_GRAM_CODE,
			"MicroMolesPerMinutePerGram [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> MicroMolesPerMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	MICROMOLES_PER_MOLE(Ucum.MICROMOLES_PER_MOLE_CODE,
			"MicroMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> MicroMolesPerMoleCreatinine [Substance Ratio Or
	 * Substance Fraction Units] </div>
	 */
	MICROMOLES_PER_MOLE_CREATININE(Ucum.MICROMOLES_PER_MOLE_CREATININE_CODE,
			"MicroMolesPerMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> MicroSecond [Time Units] </div>
	 */
	MICROSECOND("us", "MicroSecond [Time Units]"),
	/**
	 * <div class="en">MilliEquivalent [Substance Units]</div>
	 */
	MILLI_EQUIVALENT("meq", "MilliEquivalent [Substance Units]"),
	/**
	 * <div class="en"> MilliEquivalentPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MILLI_EQUIVALENT_PER_MILLILITER(Ucum.MILLI_EQUIVALENT_PER_MILLILITER_CODE,
			"MilliEquivalentPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerDeciLiter [Substance Concentration
	 * Units] </div>
	 */
	MILLI_EQUIVALENTS_PER_DECILITER(Ucum.MILLI_EQUIVALENTS_PER_DECILITER_CODE,
			"MilliEquivalentsPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerGram [Substance Content Units]
	 * </div>
	 */
	MILLI_EQUIVALENTS_PER_GRAM(Ucum.MILLI_EQUIVALENTS_PER_GRAM_CODE, "MilliEquivalentsPerGram [Substance Content Units]"),
	/**
	 * <div class= "en"> MilliEquivalentsPerGramCreatinine [Substance Content
	 * Units] </div>
	 */
	MILLI_EQUIVALENTS_PER_GRAM_CREATININE(Ucum.MILLI_EQUIVALENTS_PER_GRAM_CREATININE_CODE,
			"MilliEquivalentsPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerKiloGram [Substance Content Units]
	 * </div>
	 */
	MILLI_EQUIVALENTS_PER_KILOGRAM(Ucum.MILLI_EQUIVALENTS_PER_KILOGRAM_CODE, "MilliEquivalentsPerKiloGram [Substance Content Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerLiter [Most Common Healthcare
	 * Units] </div>
	 */
	MILLI_EQUIVALENTS_PER_LITER(Ucum.MILLI_EQUIVALENTS_PER_LITER_CODE, "MilliEquivalentsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerSpecimen [Substance Units] </div>
	 */
	MILLI_EQUIVALENTS_PER_SPECIMEN(Ucum.MILLI_EQUIVALENTS_PER_SPECIMEN_CODE, "MilliEquivalentsPerSpecimen [Substance Units]"),
	/**
	 * <div class= "en"> MilliEquivalentsPerSquareMeter [Areic Substance
	 * Units]</div>
	 */
	MILLI_EQUIVALENTS_PER_SQUARE_METER(Ucum.MILLI_EQUIVALENTS_PER_SQUAREMETER_CODE,
			"MilliEquivalentsPerSquareMeter [Areic Substance Units]"),
	/**
	 * <div class = "en"> MilliGram [SI Mass Units] </div>
	 */
	MILLIGRAM("mg", "MilliGram [SI Mass Units]"),
	/**
	 * <div class="en"> MilliGramPerGramCreatinine [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units]</div>
	 */
	MILLIGRAM_PER_GRAM_CREATININE(Ucum.MILLIGRAM_PER_GRAM_CREATININE_CODE,
			"MilliGramPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilliGramPerTotalVolume [SI Mass Units] </div>
	 */
	MILLIGRAM_PER_TOTAL_VOLUME(Ucum.MILLIGRAM_PER_TOTAL_VOLUME_CODE, "MilliGramPerTotalVolume [SI Mass Units]"),
	/**
	 * <div class="en"> MilliGramsPerCubicMeter [Mass Concentration Units]</div>
	 */
	MILLIGRAMS_PER_CUBICMETER("mg/m3", "MilliGramsPerCubicMeter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> MilliGramsPerDeciLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MILLIGRAMS_PER_DECILITER(Ucum.MILLIGRAMS_PER_DECILITER_CODE, "MilliGramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	MILLIGRAMS_PER_GRAM("mg/g",
			"MilliGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilliGramsPerKiloGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	MILLIGRAMS_PER_KILOGRAM(Ucum.MILLIGRAMS_PER_KILOGRAM_CODE,
			"MilliGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilliGramsPerLiter [Mass Concentration Units] </div>
	 */
	MILLIGRAMS_PER_LITER("mg/L", "MilliGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> MilliGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MILLIGRAMS_PER_MILLIGRAM(Ucum.MILLIGRAMS_PER_MILLIGRAM_CODE,
			"MilliGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilligramsPerMilligramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	MILLIGRAMS_PER_MILLIGRAM_CREATININE(Ucum.MILLIGRAMS_PER_MILLIGRAM_CREATININE_CODE,
			"MilligramsPerMilligramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilliGramsPerMilliLiter [Mass Concentration Units]
	 * </div>
	 */
	MILLIGRAMS_PER_MILLILITER(Ucum.MILLIGRAMS_PER_MILLILITER_CODE, "MilliGramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> MilliGramsPerSquareMeter [Areic Mass Units] </div>
	 */
	MILLIGRAMS_PER_SQUARE_METER(Ucum.MILLIGRAMS_PER_SQUAREMETER_CODE, "MilliGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> MilliGramsPerVolume [SI Mass Units]</div>
	 */
	MILLIGRAMS_PER_VOLUME(Ucum.MILLIGRAMS_PER_VOLUME_CODE, "MilliGramsPerVolume [SI Mass Units]"),
	/**
	 * <div class="en"> MilliGramsPhenylketonesPerDeciLiter [Mass Concentration
	 * Units]</div>
	 */
	MILLIGRAMS_PER_PHENYLKETONES_PER_DECILITER(Ucum.MILLIGRAMS_PHENYLKETONES_PER_DECILITER_CODE,
			"MilliGramsPhenylketonesPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class = "en"> MilliInternationalUnitsPerLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	MILLI_INTERNATIONAL_UNITS_PER_LITER(Ucum.MILLI_INTERNATIONAL_UNITS_PER_LITER_CODE,
			"MilliInternationalUnitsPerLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> MilliInternationalUnitsPerMilliLiter [Most Common
	 * Healthcare Units] </div>
	 */
	MILLI_INTERNATIONAL_UNITS_PER_MILLILITER(Ucum.MILLI_INTERNATIONAL_UNITS_PER_MILLILITER_CODE,
			"MilliInternationalUnitsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliLiter [SI Volume Units] </div>
	 */
	MILLILITER("mL", "MilliLiter [SI Volume Units]"),
	/**
	 * <div class="en"> MilliLitersPerDeciLiter [Volume Fraction Units]</div>
	 */
	MILLILITERS_PER_DECILITER(Ucum.MILLILITERS_PER_DECILITER_CODE, "MilliLitersPerDeciLiter [Volume Fraction Units]"),
	/**
	 * <div class= "en"> MilliLitersPerHeartbeat [SI Volume Units]</div>
	 */
	MILLILITERS_PER_HEARTBEAT(Ucum.MILLILITERS_PER_HEARTBEAT_CODE, "MilliLitersPerHeartbeat [SI Volume Units]"),
	/**
	 * <div class="en"> MilliLitersPerKiloGram [Volume Content Units]</div>
	 */
	MILLILITERS_PER_KILOGRAM(Ucum.MILLILITERS_PER_KILOGRAM_CODE, "MilliLitersPerKiloGram [Volume Content Units]"),
	/**
	 * <div class= "en"> MilliMeter [SI Length Units]</div>
	 */
	MILLIMETER("mm", "MilliMeter [SI Length Units]"),
	/**
	 * <div class="en"> MilliMetersOfMercury [Most Common Healthcare
	 * Units]</div>
	 */
	MILLIMETERS_OF_MERCURY(Ucum.MILLIMETERS_OF_MERCURY_CODE, "MilliMetersOfMercury [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> MilliMole [Substance Units] </div>
	 */
	MILLIMOLE("mmol", "MilliMole [Substance Units]"),
	/**
	 * <div class="en"> MilliMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	MILLIMOLES_PER_DECILITER(Ucum.MILLIMOLES_PER_DECILITER_CODE, "MilliMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MilliMolesPerGram [Substance Content Units] </div>
	 */
	MILLIMOLES_PER_GRAM(Ucum.MILLIMOLES_PER_GRAM_CODE, "MilliMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en"> MilliMolesPerKiloGram [Most Common Healthcare
	 * Units]</div>
	 */
	MILLIMOLES_PER_KILOGRAM(Ucum.MILLIMOLES_PER_KILOGRAM_CODE, "MilliMolesPerKiloGram [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliMolesPerLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MILLIMOLES_PER_LITER(Ucum.MILLIMOLES_PER_LITER_CODE, "MilliMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> MilliMolesPerMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	MILLIMOLES_PER_MOLE(Ucum.MILLIMOLES_PER_MOLE_CODE,
			"MilliMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> MilliMolesPerMoleCreatinine [Substance Ratio Or
	 * Substance Fraction Units] </div>
	 */
	MILLIMOLES_PER_MOLE_CREATININE(Ucum.MILLIMOLES_PER_MOLE_CREATININE_CODE,
			"MilliMolesPerMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> MilliMolesPerSquareMeter [Areic Substance Units]
	 * </div>
	 */
	MILLIMOLES_PER_SQUARE_METER(Ucum.MILLIMOLES_PER_SQUAREMETER_CODE, "MilliMolesPerSquareMeter [Areic Substance Units]"),
	/**
	 * <div class= "en"> MilliMolesPerTotalVolume [Substance Units] </div>
	 */
	MILLIMOLES_PER_TOTAL_VOLUME(Ucum.MILLIMOLES_PER_TOTAL_VOLUME_CODE, "MilliMolesPerTotalVolume [Substance Units]"),
	/**
	 * <div class="en"> Million [Unity]</div>
	 */
	MILLION("10*6", "Million [Unity]"),
	/**
	 * <div class="en"> MillionEquivalentsPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MILLION_EQUIVALENTS_PER_MILLILITER(Ucum.MILLION_EQUIVALENTS_PER_MILLILITER_CODE,
			"MillionEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MillionInternationalUnit [Arbitrary Units] </div>
	 */
	MILLION_INTERNATIONAL_UNIT(Ucum.MILLION_INTERNATIONAL_UNIT_CODE, "MillionInternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en"> MillionPerLiter [Number Concentration Units]</div>
	 */
	MILLION_PER_LITER(Ucum.MILLION_PER_LITER_CODE, "MillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> MillionPerMilliLiter [Number Concentration Units]</div>
	 */
	MILLION_PER_MILLILITER(Ucum.MILLION_PER_MILLILITER_CODE, "MillionPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> MillionPerSpecimen [Unity] </div>
	 */
	MILLION_PER_SPECIMEN(Ucum.MILLION_PER_SPECIMEN_CODE, "MillionPerSpecimen [Unity]"),
	/**
	 * <div class="en"> MillionsPerMicroLiter [Most Common Healthcare
	 * Units]</div>
	 */
	MILLIONS_PER_MICROLITER(Ucum.MILLIONS_PER_MICROLITER_CODE, "MillionsPerMicroLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliOsmole [Substance Units] </div>
	 */
	MILLIOSMOLE("mosm", "MilliOsmole [Substance Units]"),
	/**
	 * <div class="en"> MilliOsmolesPerKiloGram [Most Common Healthcare
	 * Units]</div>
	 */
	MILLIOSMOLES_PER_KILOGRAM(Ucum.MILLIOSMOLES_PER_KILOGRAM_CODE, "MilliOsmolesPerKiloGram [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliOsmolesPerLiter [Substance Concentration Units]
	 * </div>
	 */
	MILLIOSMOLES_PER_LITER(Ucum.MILLIOSMOLES_PER_LITER_CODE, "MilliOsmolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MilliSecond [Time Units] </div>
	 */
	MILLISECOND("ms", "MilliSecond [Time Units]"),
	/**
	 * <div class="en">MilliUnitsPerGram [Substance Rate Content Units]</div>
	 */
	MILLI_UNITS_PER_GRAM("mU/g", "MilliUnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class= "en"> MilliUnitsPerGramHemoglobin [Substance Rate Content
	 * Units] </div>
	 */
	MILLI_UNITS_PER_GRAM_HEMOGLOBIN(Ucum.MILLI_UNITS_PER_GRAM_HEMOGLOBIN_CODE,
			"MilliUnitsPerGramHemoglobin [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> MilliUnitsPerMilligram [Substance Rate Content Units]
	 * </div>
	 */
	MILLI_UNITS_PER_MILLIGRAM(Ucum.MILLI_UNITS_PER_MILLIGRAM_CODE, "MilliUnitsPerMilligram [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> MilliUnitsPerMilliGramCreatinine [Substance Rate
	 * Content Units] </div>
	 */
	MILLI_UNITS_PER_MILLIGRAM_CREATININE(Ucum.MILLI_UNITS_PER_MILLIGRAM_CREATININE_CODE,
			"MilliUnitsPerMilliGramCreatinine [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> Minute [Time Units] </div>
	 */
	MINUTE("min", "Minute [Time Units]"),
	/**
	 * <div class="en">Mole [Substance Units]</div>
	 */
	MOLE("mol", "Mole [Substance Units]"),
	/**
	 * <div class="en">MolesPerCubicMeter [Substance Concentration Units]</div>
	 */
	MOLES_PER_CUBICMETER(Ucum.MOLES_PER_CUBICMETER_CODE, "MolesPerCubicMeter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> MolesPerKiloGram [Substance Content Units] </div>
	 */
	MOLES_PER_KILOGRAM(Ucum.MOLES_PER_KILOGRAM_CODE, "MolesPerKiloGram [Substance Content Units]"),
	/**
	 * <div class="en"> MolesPerLiter [Substance Concentration Units]</div>
	 */
	MOLES_PER_LITER(Ucum.MOLES_PER_LITER_CODE, "MolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> MolesPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MOLES_PER_MILLILITER(Ucum.MOLES_PER_MILLILITER_CODE, "MolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> Month [Time Units] </div>
	 */
	MONTH("mo", "Month [Time Units]"),
	/**
	 * <div class="en">NanoGram [SI Mass Units]</div>
	 */
	NANOGRAM("ng", "NanoGram [SI Mass Units]"),
	/**
	 * <div class="en"> NanoGramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	NANOGRAMS_PER_DECILITER(Ucum.NANOGRAMS_PER_DECILITER_CODE, "NanoGramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> NanoGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	NANOGRAMS_PER_GRAM("ng/g",
			"NanoGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerGramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	NANOGRAMS_PER_GRAM_CREATININE(Ucum.NANOGRAMS_PER_GRAM_CREATININE_CODE,
			"NanoGramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerKiloGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	NANOGRAMS_PER_KILOGRAM(Ucum.NANOGRAMS_PER_KILOGRAM_CODE,
			"NanoGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerLiter [Mass Concentration Units] </div>
	 */
	NANOGRAMS_PER_LITER("ng/L", "NanoGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> NanoGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	NANOGRAMS_PER_MILLIGRAM(Ucum.NANOGRAMS_PER_MILLIGRAM_CODE,
			"NanoGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerMilliGramProtein [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	NANOGRAMS_PER_MILLIGRAM_PROTEIN(Ucum.NANOGRAMS_PER_MILLIGRAM_PROTEIN_CODE,
			"NanoGramsPerMilliGramProtein [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerMilliLiter [Most Common Healthcare Units]
	 * </div>
	 */
	NANOGRAMS_PER_MILLILITER(Ucum.NANOGRAMS_PER_MILLILITER_CODE, "NanoGramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> NanoGramsPerMilliLiterRedBloodCells [Mass Concentration
	 * Units] </div>
	 */
	NANOGRAMS_PER_MILLILITER_RED_BLOOD_CELLS(Ucum.NANOGRAMS_PER_MILLILITER_RED_BLOOD_CELLS_CODE,
			"NanoGramsPerMilliLiterRedBloodCells [Mass Concentration Units]"),
	/**
	 * <div class = "en"> NanoGramsPerSquareMeter [Areic Mass Units] </div>
	 */
	NANOGRAMS_PER_SQUARE_METER(Ucum.NANOGRAMS_PER_SQUAREMETER_CODE, "NanoGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> NanoLiter [SI Volume Units]</div>
	 */
	NANOLITER("nL", "NanoLiter [SI Volume Units]"),
	/**
	 * <div class="en">NanoMeter [SI Length Units]</div>
	 */
	NANOMETER("nm", "NanoMeter [SI Length Units]"),
	/**
	 * <div class="en">NanoMole [Substance Units]</div>
	 */
	NANOMOLE("nmol", "NanoMole [Substance Units]"),
	/**
	 * <div class="en"> NanoMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	NANOMOLES_PER_DECILITER(Ucum.NANOMOLES_PER_DECILITER_CODE, "NanoMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> NanoMolesPerGram [Substance Content Units] </div>
	 */
	NANOMOLES_PER_GRAM(Ucum.NANOMOLES_PER_GRAM_CODE, "NanoMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en"> NanoMolesPerGramCreatinine [Substance Content
	 * Units]</div>
	 */
	NANOMOLES_PER_GRAM_CREATININE(Ucum.NANOMOLES_PER_GRAM_CREATININE_CODE,
			"NanoMolesPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class = "en"> NanoMolesPerLiter [Most Common Healthcare Units]
	 * </div>
	 */
	NANOMOLES_PER_LITER(Ucum.NANOMOLES_PER_LITER_CODE, "NanoMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> NanoMolesPerMilliGram [Substance Content Units] </div>
	 */
	NANOMOLES_PER_MILLIGRAM(Ucum.NANOMOLES_PER_MILLIGRAM_CODE, "NanoMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class= "en"> NanoMolesPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	NANOMOLES_PER_MILLILITER(Ucum.NANOMOLES_PER_MILLILITER_CODE, "NanoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> NanoMolesPerMilliMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	NANOMOLES_PER_MILLIMOLE(Ucum.NANOMOLES_PER_MILLIMOLE_CODE,
			"NanoMolesPerMilliMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> NanoMolesPerMilliMoleCreatinine [Substance Ratio Or
	 * Substance Fraction Units] </div>
	 */
	NANOMOLES_PER_MILLIMOLE_CREATININE(Ucum.NANOMOLES_PER_MILLIMOLE_CREATININE_CODE,
			"NanoMolesPerMilliMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> NanoMolesPerMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	NANOMOLES_PER_MOLE(Ucum.NANOMOLES_PER_MOLE_CODE, "NanoMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> NanoSecond [Time Units] </div>
	 */
	NANOSECOND("ns", "NanoSecond [Time Units]"),
	/**
	 * <div class="en">NauticalMile [English Length Units]</div>
	 */
	NAUTICAL_MILE(Ucum.NAUTICAL_MILE_CODE, "NauticalMile [English Length Units]"),
	/**
	 * <div class="en"> OneHundredThousand [Unity]</div>
	 */
	ONE_HUNDRED_THOUSAND("10*5", "OneHundredThousand [Unity]"),
	/**
	 * <div class="en"> OsmolesPerKiloGram [Substance Content Units]</div>
	 */
	OSMOLES_PER_KILOGRAM(Ucum.OSMOLES_PER_KILOGRAM_CODE, "OsmolesPerKiloGram [Substance Content Units]"),
	/**
	 * <div class= "en"> OsmolesPerLiter [Substance Concentration Units]</div>
	 */
	OSMOLES_PER_LITER(Ucum.OSMOLES_PER_LITER_CODE, "OsmolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en">Ounce [English Mass Units]</div>
	 */
	OUNCE(Ucum.OUNCE_CODE, "Ounce [English Mass Units]"),
	/**
	 * <div class="en">Per100 [Entitic Number Units]</div>
	 */
	PER100("/100", "Per100 [Entitic Number Units]"),
	/**
	 * <div class="en"> Per100Spermatozoa [Entitic Number Units]</div>
	 */
	PER100_SPERMATOZOA(Ucum.PER_100_SPERMATOZOA_CODE, "Per100Spermatozoa [Entitic Number Units]"),
	/**
	 * <div class="en"> Per100WBC [Entitic Number Units]</div>
	 */
	PER100_WBC(Ucum.PER_100_WBC_CODE, "Per100WBC [Entitic Number Units]"),
	/**
	 * <div class="en"> PerArbitraryUnit [Arbitrary Number Units]</div>
	 */
	PER_ARBITRARY_UNIT(Ucum.PER_ARBITRARY_UNIT_CODE, "PerArbitraryUnit [Arbitrary Number Units]"),
	/**
	 * <div class="en"> PerBillion [Number Fraction Units]</div>
	 */
	PER_BILLION(Ucum.PER_BILLION_CODE, "PerBillion [Number Fraction Units]"),
	/**
	 * <div class="en">Percent [Most Common Healthcare Units]</div>
	 */
	PERCENT("%", "Percent [Most Common Healthcare Units]"),
	/**
	 * <div class="en"> Percent0to3Hours [General Fraction Unit]</div>
	 */
	PERCENT_0_TO_3_HOURS(Ucum.PERCENT_0_TO_3_HOURS_CODE, "Percent0to3Hours [General Fraction Unit]"),
	/**
	 * <div class="en"> PercentAbnormal [Number Fraction Units]</div>
	 */
	PERCENT_ABNORMAL(Ucum.PERCENT_ABNORMAL_CODE, "PercentAbnormal [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentActivity [Catalytic Fraction Or Arbitrary
	 * Fraction Units]</div>
	 */
	PERCENT_ACTIVITY(Ucum.PERCENT_ACTIVITY_CODE,
			"PercentActivity [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class = "en"> PercentBasalActivity [Catalytic Fraction Or Arbitrary
	 * Fraction Units] </div>
	 */
	PERCENT_BASAL_ACTIVITY(Ucum.PERCENT_BASAL_ACTIVITY_CODE,
			"PercentBasalActivity [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class = "en"> PercentBinding [Mass Or Substance Fraction Units]
	 * </div>
	 */
	PERCENT_BINDING(Ucum.PERCENT_BINDING_CODE, "PercentBinding [Mass Or Substance Fraction Units]"),
	/**
	 * <div class= "en"> PercentBlockade [Number Fraction Units] </div>
	 */
	PERCENT_BLOCKADE(Ucum.PERCENT_BLOCKADE_CODE, "PercentBlockade [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentBound [Mass Or Substance Fraction Units]</div>
	 */
	PERCENT_BOUND(Ucum.PERCENT_BOUND_CODE, "PercentBound [Mass Or Substance Fraction Units]"),
	/**
	 * <div class= "en"> PercentCarboxyhemoglobin [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PERCENT_CARBOXY_HEMOGLOBIN(Ucum.PERCENT_CARBOXY_HEMOGLOBIN_CODE,
			"PercentCarboxyhemoglobin [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentEosinophilsSeen [Number Fraction Units] </div>
	 */
	PERCENT_EOSINOPHILS_SEEN(Ucum.PERCENT_EOSINOPHILS_SEEN_CODE, "PercentEosinophilsSeen [Number Fraction Units]"),
	/**
	 * <div class= "en"> PercentExcretion [Mass Or Substance Rate Fraction
	 * Units]</div>
	 */
	PERCENT_EXCRETION(Ucum.PERCENT_EXCRETION_CODE, "PercentExcretion [Mass Or Substance Rate Fraction Units]"),
	/**
	 * <div class = "en"> PercentFetalErythrocytes [Number Fraction Units]
	 * </div>
	 */
	PERCENT_FETAL_ERYTHROCYTES(Ucum.PERCENT_FETAL_ERYTHROCYTES_CODE,
			"PercentFetalErythrocytes [Number Fraction Units]"),
	/**
	 * <div class= "en"> PercentHemoglobin [Mass Or Substance Fraction Units]
	 * </div>
	 */
	PERCENT_HEMOGLOBIN(Ucum.PERCENT_HEMOGLOBIN_CODE, "PercentHemoglobin [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentHemoglobinA1C [Mass Or Substance Fraction
	 * Units] </div>
	 */
	PERCENT_HEMOGLOBIN_A1C(Ucum.PERCENT_HEMOGLOBIN_A1C_CODE,
			"PercentHemoglobinA1C [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentHemoglobinSaturation [Mass Or Substance
	 * Fraction Units] </div>
	 */
	PERCENT_HEMOGLOBIN_SATURATION(Ucum.PERCENT_HEMOGLOBIN_SATURATION_CODE,
			"PercentHemoglobinSaturation [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentHemolysis [Number Fraction Units] </div>
	 */
	PERCENT_HEMOLYSIS(Ucum.PERCENT_HEMOLYSIS_CODE, "PercentHemolysis [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentInhibition [Catalytic Fraction Or Arbitrary
	 * Fraction Units]</div>
	 */
	PERCENT_INHIBITION(Ucum.PERCENT_INHIBITION_CODE,
			"PercentInhibition [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class = "en"> PercentNormal [Number Fraction Units] </div>
	 */
	PERCENT_NORMAL(Ucum.PERCENT_NORMAL_CODE, "PercentNormal [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentNormalPooledPlasma [Catalytic Fraction Or
	 * Arbitrary Fraction Units]</div>
	 */
	PERCENT_NORMAL_POOLED_PLASMA(Ucum.PERCENT_NORMAL_POOLED_PLASMA_CODE,
			"PercentNormalPooledPlasma [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class = "en"> PercentofBacteria [Number Fraction Units] </div>
	 */
	PERCENT_OF_BACTERIA(Ucum.PERCENT_OF_BACTERIA_CODE, "PercentofBacteria [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentOfLymphocytes [Number Fraction Units]</div>
	 */
	PERCENT_OF_LYMPHOCYTES(Ucum.PERCENT_OF_LYMPHOCYTES_CODE, "PercentOfLymphocytes [Number Fraction Units]"),
	/**
	 * <div class= "en"> PercentOfWBCs [Number Fraction Units]</div>
	 */
	PERCENT_OF_WBCS(Ucum.PERCENT_OF_WBCS_CODE, "PercentOfWBCs [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentOxygen [Volume Fraction Units]</div>
	 */
	PERCENT_OXYGEN(Ucum.PERCENT_OXYGEN_CODE, "PercentOxygen [Volume Fraction Units]"),
	/**
	 * <div class="en"> PercentPer100WBC [Number Fraction Units]</div>
	 */
	PERCENT_PER_100WBC(Ucum.PERCENT_PER_100_WBC_CODE, "PercentPer100WBC [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentPositive [Number Fraction Units]</div>
	 */
	PERCENT_POSITIVE(Ucum.PERCENT_POSITIVE_CODE, "PercentPositive [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentSpermMotility [Number Fraction Units]</div>
	 */
	PERCENT_SPERM_MOTILITY(Ucum.PERCENT_SPERM_MOTILITY_CODE, "PercentSpermMotility [Number Fraction Units]"),
	/**
	 * <div class= "en"> PercentTotal [General Fraction Unit]</div>
	 */
	PERCENT_TOTAL(Ucum.PERCENT_TOTAL_CODE, "PercentTotal [General Fraction Unit]"),
	/**
	 * <div class="en"> PercentTotalProtein [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PERCENT_TOTAL_PROTEIN(Ucum.PERCENT_TOTAL_PROTEIN_CODE,
			"PercentTotalProtein [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentUptake [Mass Or Substance Rate Fraction Units]
	 * </div>
	 */
	PERCENT_UPTAKE(Ucum.PERCENT_UPTAKE_CODE, "PercentUptake [Mass Or Substance Rate Fraction Units]"),
	/**
	 * <div class = "en"> PerDeciLiter [Number Concentration Units] </div>
	 */
	PER_DECILITER("/dL", "PerDeciLiter [Number Concentration Units]"),
	/**
	 * <div class="en"> PerEntity [Entitic Number Units]</div>
	 */
	PER_ENTITY(Ucum.PER_ENTITY_CODE, "PerEntity [Entitic Number Units]"),
	/**
	 * <div class="en">PerGram [Number Content Units]</div>
	 */
	PER_GRAM("/g", "PerGram [Number Content Units]"),
	/**
	 * <div class="en"> PerGramCreatinine [Number Content Units]</div>
	 */
	PER_GRAM_CREATININE(Ucum.PER_GRAM_CREATININE_CODE, "PerGramCreatinine [Number Content Units]"),
	/**
	 * <div class="en"> PerGramHemoglobin [Number Content Units]</div>
	 */
	PER_GRAM_HEMOGLOBIN(Ucum.PER_GRAM_HEMOGLOBIN_CODE, "PerGramHemoglobin [Number Content Units]"),
	/**
	 * <div class="en"> PerGramTotalNitrogen [Number Content Units]</div>
	 */
	PER_GRAM_TOTAL_NITROGEN(Ucum.PER_GRAM_TOTAL_NITROGEN_CODE, "PerGramTotalNitrogen [Number Content Units]"),
	/**
	 * <div class="en"> PerGramTotalProtein [Number Content Units]</div>
	 */
	PER_GRAM_TOTAL_PROTEIN(Ucum.PER_GRAM_TOTAL_PROTEIN_CODE, "PerGramTotalProtein [Number Content Units]"),
	/**
	 * <div class="en"> PerGramWetTissue [Number Content Units]</div>
	 */
	PER_GRAM_WET_TISSUE(Ucum.PER_GRAM_WET_TISSUE_CODE, "PerGramWetTissue [Number Content Units]"),
	/**
	 * <div class="en"> PerHour [Number Events]</div>
	 */
	PER_HOUR("/h", "PerHour [Number Events]"),
	/**
	 * <div class="en">PerKiloGram [Number Content Units]</div>
	 */
	PER_KILOGRAM("/kg", "PerKiloGram [Number Content Units]"),
	/**
	 * <div class="en"> PerKiloGramBodyWeight [Number Content Units]</div>
	 */
	PER_KILOGRAM_BODY_WEIGHT(Ucum.PER_KILOGRAM_BODY_WEIGHT_CODE, "PerKiloGramBodyWeight [Number Content Units]"),
	/**
	 * <div class= "en">PerLiter [Number Concentration Units]</div>
	 */
	PER_LITER("/L", "PerLiter [Number Concentration Units]"),
	/**
	 * <div class="en"> PerMicroLiter [Most Common Healthcare Units]</div>
	 */
	PER_MICROLITER("/uL", "PerMicroLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> PerMilliGram [Number Content Units]</div>
	 */
	PER_MILLIGRAM("/mg", "PerMilliGram [Number Content Units]"),
	/**
	 * <div class="en"> PerMilliLiter [Number Concentration Units]</div>
	 */
	PER_MILLILITER("/mL", "PerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en"> PerMillion [Number Fraction Units]</div>
	 */
	PER_MILLION(Ucum.PER_MILLION_CODE, "PerMillion [Number Fraction Units]"),
	/**
	 * <div class="en">PerMinute [Number Events]</div>
	 */
	PER_MINUTE("/min", "PerMinute [Number Events]"),
	/**
	 * <div class="en">PerSecond [Number Events]</div>
	 */
	PER_SECOND("/s", "PerSecond [Number Events]"),
	/**
	 * <div class="en">PerSquareMeter [Areic Number Units]</div>
	 */
	PER_SQUARE_METER("/m2", "PerSquareMeter [Areic Number Units]"),
	/**
	 * <div class="en"> PerTenGiga [Number Fraction Units]</div>
	 */
	PER_TEN_GIGA(Ucum.PER_TEN_GIGA_CODE, "PerTenGiga [Number Fraction Units]"),
	/**
	 * <div class="en"> PerTotalCount [Unity]</div>
	 */
	PER_TOTAL_COUNT(Ucum.PER_TOTAL_COUNT_CODE, "PerTotalCount [Unity]"),
	/**
	 * <div class="en">PerTrillion [Number Fraction Units]</div>
	 */
	PER_TRILLION(Ucum.PER_TRILLION_CODE, "PerTrillion [Number Fraction Units]"),
	/**
	 * <div class="en"> PerTrillionRedBloodCells [Entitic Number Units]</div>
	 */
	PER_TRILLION_RED_BLOOD_CELLS(Ucum.PER_TRILLION_RED_BLOOD_CELLS_CODE, "PerTrillionRedBloodCells [Entitic Number Units]"),
	/**
	 * <div class= "en">pH [pH Units]</div>
	 */
	PH("[pH]", "pH [pH Units]"),
	/**
	 * <div class="en">PicoGram [SI Mass Units]</div>
	 */
	PICOGRAM("pg", "PicoGram [SI Mass Units]"),
	/**
	 * <div class="en">PicoGrams [Most Common Healthcare Units]</div>
	 */
	PICOGRAMS("pg", "PicoGrams [Most Common Healthcare Units]"),
	/**
	 * <div class="en"> PicoGramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	PICOGRAMS_PER_DECILITER(Ucum.PICOGRAMS_PER_DECILITER_CODE, "PicoGramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> PicoGramsPerLiter [Mass Concentration Units] </div>
	 */
	PICOGRAMS_PER_LITER("pg/L", "PicoGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> PicoGramsPerMilliLiter [Most Common Healthcare
	 * Units]</div>
	 */
	PICOGRAMS_PER_MILLILITER(Ucum.PICOGRAMS_PER_MILLILITER_CODE, "PicoGramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> PicoGramsPerMilliMeter [Lineic Mass Units] </div>
	 */
	PICOGRAMS_PER_MILLIMETER(Ucum.PICOGRAMS_PER_MILLIMETER_CODE, "PicoGramsPerMilliMeter [Lineic Mass Units]"),
	/**
	 * <div class="en"> PicoLiter [SI Volume Units]</div>
	 */
	PICOLITER("pL", "PicoLiter [SI Volume Units]"),
	/**
	 * <div class="en">PicoMeter [SI Length Units]</div>
	 */
	PICOMETER("pm", "PicoMeter [SI Length Units]"),
	/**
	 * <div class="en">PicoMole [Substance Units]</div>
	 */
	PICOMOLE("pmol", "PicoMole [Substance Units]"),
	/**
	 * <div class="en"> PicoMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	PICOMOLES_PER_DECILITER(Ucum.PICOMOLES_PER_DECILITER_CODE, "PicoMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> PicoMolesPerLiter [Substance Concentration Units]
	 * </div>
	 */
	PICOMOLES_PER_LITER(Ucum.PICOMOLES_PER_LITER_CODE, "PicoMolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> PicoMolesPerMicroMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	PICOMOLES_PER_MICROMOLE(Ucum.PICOMOLES_PER_MICROMOLE_CODE,
			"PicoMolesPerMicroMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PicoMolesPerMilliLiter [Substance Concentration Units]
	 * </div>
	 */
	PICOMOLES_PER_MILLILITER(Ucum.PICOMOLES_PER_MILLILITER_CODE, "PicoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> PicoSecond [Time Units] </div>
	 */
	PICOSECOND("ps", "PicoSecond [Time Units]"),
	/**
	 * <div class="en">Pint [English Volume Units]</div>
	 */
	PINT(Ucum.PINT_CODE, "Pint [English Volume Units]"),
	/**
	 * <div class="en">Pound [English Mass Units]</div>
	 */
	POUND(Ucum.POUND_CODE, "Pound [English Mass Units]"),
	/**
	 * <div class="en">Quart [English Volume Units]</div>
	 */
	QUART(Ucum.QUART_CODE, "Quart [English Volume Units]"),
	/**
	 * <div class="en"> RedBloodCellsPerMicroLiter [Number Concentration
	 * Units]</div>
	 */
	RED_BLOOD_CELLS_PER_MICROLITER(Ucum.RED_BLOOD_CELLS_PER_MICROLITER_CODE,
			"RedBloodCellsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class = "en"> RelativePercent [General Fraction Unit] </div>
	 */
	RELATIVE_PERCENT(Ucum.RELATIVE_PERCENT_CODE, "RelativePercent [General Fraction Unit]"),
	/**
	 * <div class="en"> Second [Time Units]</div>
	 */
	SECOND("s", "Second [Time Units]"),
	/**
	 * <div class="en">SpermatozoaPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	SPERMATOZOA_PER_MILLILITER(Ucum.SPERMATOZOA_PER_MILLILITER_CODE,
			"SpermatozoaPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class = "en"> SquareCentiMeter [SI Area Units] </div>
	 */
	SQUARE_CENTIMETER("cm2", "SquareCentiMeter [SI Area Units]"),
	/**
	 * <div class="en"> SquareFeet [English Area Units]</div>
	 */
	SQUARE_FEET(Ucum.SQUAREFEET_CODE, "SquareFeet [English Area Units]"),
	/**
	 * <div class="en">SquareInch [English Area Units]</div>
	 */
	SQUARE_INCH(Ucum.SQUAREINCH_CODE, "SquareInch [English Area Units]"),
	/**
	 * <div class="en">SquareMeter [SI Area Units]</div>
	 */
	SQUARE_METER("m2", "SquareMeter [SI Area Units]"),
	/**
	 * <div class="en">SquareMilliMeter [SI Area Units]</div>
	 */
	SQUARE_MILLIMETER("mm2", "SquareMilliMeter [SI Area Units]"),
	/**
	 * <div class="en"> SquareYard [English Area Units]</div>
	 */
	SQUARE_YARD(Ucum.SQUAREYARD_CODE, "SquareYard [English Area Units]"),
	/**
	 * <div class="en">StatuteMile [English Length Units]</div>
	 */
	STATUTEMILE(Ucum.STATUS_MILE_CODE, "StatuteMile [English Length Units]"),
	/**
	 * <div class="en"> TenToEighth [Unity]</div>
	 */
	TEN_TO_EIGHTH("10*8", "TenToEighth [Unity]"),
	/**
	 * <div class="en">Thousand [Unity]</div>
	 */
	THOUSAND("10*3", "Thousand [Unity]"),
	/**
	 * <div class="en"> ThousandCopiesPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	THOUSAND_COPIES_PER_MILLILITER(Ucum.THOUSAND_COPIES_PER_MILLILITER_CODE,
			"ThousandCopiesPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class = "en"> ThousandPerLiter [Number Concentration Units] </div>
	 */
	THOUSAND_PER_LITER(Ucum.THOUSAND_PER_LITER_CODE, "ThousandPerLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> ThousandPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	THOUSAND_PER_MILLILITER(Ucum.THOUSAND_PER_MILLILITER_CODE, "ThousandPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> ThousandRedBloodCells [Unity] </div>
	 */
	THOUSAND_PER_RED_BLOOD_CELLS(Ucum.THOUSAND_RED_BLOOD_CELLS_CODE, "ThousandRedBloodCells [Unity]"),
	/**
	 * <div class="en"> ThousandsPerMicroLiter [Number Concentration
	 * Units]</div>
	 */
	THOUSANDS_PER_MICROLITER(Ucum.THOUSANDS_PER_MICROLITER_CODE, "ThousandsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class= "en">Ton [English Mass Units] </div>
	 */
	TON(Ucum.TON_CODE, "Ton [English Mass Units]"),
	/**
	 * <div class="en">TrillionPerLiter [Number Concentration Units]</div>
	 */
	TRILLION_PER_LITER(Ucum.TRILLION_PER_LITER_CODE, "TrillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> TroyOunce [English Mass Units]</div>
	 */
	TROY_OUNCE(Ucum.TROY_OUNCE_CODE, "TroyOunce [English Mass Units]"),
	/**
	 * <div class="en">UnitsPerGram [Substance Rate Content Units]</div>
	 */
	UNITS_PER_GRAM("U/g", "UnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class="en"> UnitsPerGramCreatinine [Substance Rate Content
	 * Units]</div>
	 */
	UNITS_PER_GRAM_CREATININE(Ucum.UNITS_PER_GRAM_CREATININE_CODE, "UnitsPerGramCreatinine [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> UnitsPerGramHemoglobin [Substance Rate Content Units]
	 * </div>
	 */
	UNITS_PER_GRAM_HEMOGLOBIN(Ucum.UNITS_PER_GRAM_HEMOGLOBIN_CODE, "UnitsPerGramHemoglobin [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> UnitsPerLiter [Most Common Healthcare Units] </div>
	 */
	UNITS_PER_LITER("U/L", "UnitsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> VolumePercent [Volume Fraction Units]</div>
	 */
	VOLUME_PERCENT(Ucum.VOLUME_PERCENT_CODE, "VolumePercent [Volume Fraction Units]"),
	/**
	 * <div class="en">Week [Time Units]</div>
	 */
	WEEK("wk", "Week [Time Units]"),
	/**
	 * <div class="en">Yard [English Length Units]</div>
	 */
	YARD(Ucum.YARD_CODE, "Yard [English Length Units]"),
	/**
	 * <div class="en">Year [Time Units]</div>
	 */
	YEAR("a", "Year [Time Units]");

	public static final String AHG_EQUIVALENTS_PER_MILLILITER_CODE = "{AHG}eq/mL";
	public static final String BILLION_PER_LITER_CODE = "10*9/L";
	public static final String BILLIONS_PER_MICROLITER_CODE = "10*9/uL";
	public static final String BILLIONS_PER_MILLILITER_CODE = "10*9/mL";
	public static final String BONE_COLLAGEN_EQUIVALENTS_PER_MICROMOLE_CREATININE_CODE = "{BoneCollagen}eq/umol{Cre}";
	public static final String BONE_COLLAGEN_EQUIVALENTS_PER_MILLIOMOLE_CREATININE_CODE = "{BoneCollagen}eq/mmol{Cre}";
	public static final String CELLS_PER_MICROLITER_CODE = "{Cells}/uL";
	public static final String CENTIGRAM_CODE = "cg";
	public static final String CENTILITER_CODE = "cL";
	public static final String CENTIMETER_CODE = "cm";
	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "";
	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "";
	public static final String COLONY_FORMING_UNITS_PER_MILLILITER_CODE = "{cfu}/mL";
	public static final String COMPLEMENT_CH50_UNITS_PER_MILLILITER_CODE = "{ComplementCh50}U/mL";
	public static final String COPIES_PER_MILLILITER_CODE = "{Copies}/mL";
	public static final String CUBIC_INCH_CODE = "[cin_i]";
	public static final String CUP_CODE = "[cup_us]";
	public static final String DAY_CODE = "d";
	public static final String DECIGRAM_CODE = "dg";
	public static final String DECILITER_CODE = "dL";
	public static final String DECIMETER_CODE = "dm";
	public static final String DEGREES_CELSIUS_CODE = "Cel";
	public static final String DEGREES_FAHRENHEIT_CODE = "[degF]";
	public static final String DEGREES_KELVIN_CODE = "K";
	public static final String DEGREES_OF_ARC_CODE = "deg";
	public static final String DESCRIPTIVE_CODE = "Code";
	public static final String DRAM_CODE = "[dr_av]";
	public static final String EHRLICH_UNITS_PER_100_GRAM_CODE = "{Ehrlich_U}/100g";
	public static final String EHRLICH_UNITS_PER_DECILITER_CODE = "{Ehrlich_U}/dL";
	public static final String ELISA_UNITY_PER_MILLILITER_CODE = "{Elisa_U}/mL";
	public static final String EQUIVALENT_CODE = "eq";
	public static final String EQUIVALENTS_PER_LITER_CODE = "eq/L";
	public static final String EQUIVALENTS_PER_MICROMOLE_CODE = "eq/umol";
	public static final String EQUIVALENTS_PER_MILLILITER_CODE = "eq/mL";
	public static final String EQUIVALENTS_PER_MILLIMOLE_CODE = "eq/mmol";
	public static final String FATHOM_CODE = "[fth_i]";
	public static final String FEET_CODE = "[ft_i]";
	public static final String FEMTOGRAM_CODE = "fg";
	public static final String FEMTOLITER_CODE = "fL";
	public static final String FEMTOMETER_CODE = "fm";
	public static final String FEMTOMOLE_CODE = "fmol";
	public static final String FEMTOMOLES_PER_GRAM_CODE = "fmol/g";
	public static final String FEMTOMOLES_PER_MILLIGRAM_CODE = "fmol/mg";
	public static final String FEMTOMOLES_PER_MILLILITER_CODE = "fmol/mL";
	public static final String FLUID_DRAM_CODE = "[fdr_us]";
	public static final String FLUID_OUNCE_CODE = "[foz_us]";
	public static final String FRENCH_CODE = "[Ch]";
	public static final String GALLON_CODE = "[gal_us]";
	public static final String GRAIN_CODE = "[gr]";
	public static final String GRAM_CODE = "g";
	public static final String GRAM_METER_CODE = "g.m";
	public static final String GRAM_METER_PER_HEARTBEAT_CODE = "g.m/{hb}";
	public static final String GRAM_METER_PER_HEARTBEAT_PER_SQUARE_METER_CODE = "g.m/({hb}.m2)";
	public static final String GRAMS_PER_100_GRAM_CODE = "g/[100]g";
	public static final String GRAMS_PER_DECILITER_CODE = "g/dL";
	public static final String GRAMS_PER_GRAM_CODE = "g/g";
	public static final String GRAMS_PER_GRAM_CREATININE_CODE = "g/g{Cre}";
	public static final String GRAMS_PER_KILOGRAM_CODE = "g/kg";
	public static final String GRAMS_PER_LITER_CODE = "g/L";
	public static final String GRAMS_PER_MILLILITER_CODE = "g/mL";
	public static final String GRAMS_PER_SQUARE_METER_CODE = "g/m2";
	public static final String GRAMS_PER_TOTAL_WEIGHT_CODE = "g/{TotalWeight}";
	public static final String HECTOLITER_CODE = "hL";
	public static final String HOUR_CODE = "h";
	public static final String IGA_PHOSPHOLIPID_UNITS_PER_MILLILITER_CODE = "{IgAPhospholipid}U/mL";
	public static final String IGG_PHOSPHOLIPID_UNITS_PER_MILLILITER_CODE = "{IgGPhospholipid}U/mL";
	public static final String IGM_PHOSPHOLIPID_UNITS_PER_MILLILITER_CODE = "{IgMPhospholipid}U/mL";
	public static final String INCH_CODE = "[in_i]";
	public static final String INTERNATIONAL_UNIT_CODE = "[iU]";
	public static final String INTERNATIONAL_UNITS_PER_DECILITER_CODE = "[iU]/dL";
	public static final String INTERNATIONAL_UNITS_PER_GRAM_CODE = "[iU]/g";
	public static final String INTERNATIONAL_UNITS_PER_GRAM_HEMOGLOBIN_CODE = "[iU]/g{Hgb}";
	public static final String INTERNATIONAL_UNITS_PER_KILOGRAM_CODE = "[iU]/kg";
	public static final String INTERNATIONAL_UNITS_PER_LITER_CODE = "[iU]/L";
	public static final String INTERNATIONAL_UNITS_PER_MILLILITER_CODE = "[iU]/mL";
	public static final String KATAL_PER_KILOGRAM_CODE = "kat/kg";
	public static final String KELVIN_PER_WATT_CODE = "K/W";
	public static final String KILO_CALORIES_PER_OUNCE_CODE = "kCal/[oz_av]";
	public static final String KILOGRAM_CODE = "kg";
	public static final String KILOGRAMS_PER_CUBICMETER_CODE = "kg/m3";
	public static final String KILOGRAMS_PER_LITER_CODE = "kg/L";
	public static final String KILOGRAMS_PER_MOLE_CODE = "kg/mol";
	public static final String KILOGRAMS_PER_SQUAREMETER_CODE = "kg/m2";
	public static final String KILO_INTERNATIONAL_UNITS_PER_MILLILITER_CODE = "k[iU]/mL";
	public static final String KILOLITER_CODE = "kL";
	public static final String KILOMETER_CODE = "km";
	public static final String KILOPASCAL_CODE = "kPa";
	public static final String KILOSECOND_CODE = "ks";
	public static final String KILO_UNITS_PER_GRAM_CODE = "kU/g";
	public static final String LITER_CODE = "L";
	public static final String LITERS_PER_KILOGRAM_CODE = "L/kg";
	public static final String LITER_SQUARE_SECOND_PER_SECOND_CODE = "L.s2/s";
	public static final String LOG10_CODE = "[lg]";
	public static final String MEGASECOND_CODE = "Ms";
	public static final String METER_CODE = "m";
	public static final String METRIC_TON_CODE = "t";
	public static final String MICRO_EQUIVALENT_CODE = "ueq";
	public static final String MICRO_EQUIVALENTS_PER_LITER_CODE = "ueq/L";
	public static final String MICRO_EQUIVALENTS_PER_MILLILITER_CODE = "ueq/mL";
	public static final String MICROGRAM_CODE = "ug";
	public static final String MICROGRAM_PER_100_GRAM_CODE = "ug/[100]g";
	public static final String MICROGRAM_PER_GRAM_CREATININE_CODE = "ug/g{Cre}";
	public static final String MICROGRAM_PER_GRAM_DRY_WEIGHT_CODE = "ug/g{DryWeight}";
	public static final String MICROGRAMS_PER_DECILITER_CODE = "ug/dL";
	public static final String MICROGRAMS_PER_DECILITER_RED_BLOOD_CELLS_CODE = "ug/dL{rbc}";
	public static final String MICROGRAMS_PER_GRAM_CODE = "ug/g";
	public static final String MICROGRAMS_PER_GRAM_HEMOGLOBIN_CODE = "ug/g{Hgb}";
	public static final String MICROGRAMS_PER_KILOGRAM_CODE = "ug/kg";
	public static final String MICROGRAMS_PER_LITER_CODE = "ug/L";
	public static final String MICROGRAMS_PER_MILLIGRAM_CODE = "ug/mg";
	public static final String MICROGRAMS_PER_MILLIGRAM_CREATININE_CODE = "ug/mg{Cre}";
	public static final String MICROGRAMS_PER_MILLILITER_CODE = "ug/mL";
	public static final String MICROGRAMS_PER_NANOGRAM_CODE = "ug/ng";
	public static final String MICROGRAMS_PER_SPECIMEN_CODE = "ug/{Specimen}";
	public static final String MICROGRAMS_PER_SQUAREMETER_CODE = "ug/m2";
	public static final String MICROGRAMS_PER_TOTAL_VOLUME_CODE = "ug/{TotalVolume}";
	public static final String MICRO_INTERNATIONAL_UNIT_CODE = "u[iU]";
	public static final String MICRO_INTERNATIONAL_UNITS_PER_MILLILITER_CODE = "u[iU]/mL";
	public static final String MICROLITER_CODE = "uL";
	public static final String MICROMETER_CODE = "um";
	public static final String MICROMOLE_CODE = "umol";
	public static final String MICROMOLES_PER_DECILITER_CODE = "umol/dL";
	public static final String MICROMOLES_PER_GRAM_CODE = "umol/g";
	public static final String MICROMOLES_PER_GRAM_CREATININE_CODE = "umol/g{Cre}";
	public static final String MICROMOLES_PER_GRAM_HEMOGLOBIN_CODE = "umol/g{Hgb}";
	public static final String MICROMOLES_PER_LITER_CODE = "umol/L";
	public static final String MICROMOLES_PER_MILLIGRAM_CODE = "umol/mg";
	public static final String MICROMOLES_PER_MILLIGRAM_CREATININE_CODE = "umol/mg{Cre}";
	public static final String MICROMOLES_PER_MILLILITER_CODE = "umol/mL";
	public static final String MICROMOLES_PER_MINUTE_PER_GRAM_CODE = "umol/min/g";
	public static final String MICROMOLES_PER_MOLE_CODE = "umol/mol";
	public static final String MICROMOLES_PER_MOLE_CREATININE_CODE = "umol/mol{Cre}";
	public static final String MICROSECOND_CODE = "us";
	public static final String MILLI_EQUIVALENT_CODE = "meq";
	public static final String MILLI_EQUIVALENT_PER_MILLILITER_CODE = "meq/mL";
	public static final String MILLI_EQUIVALENTS_PER_DECILITER_CODE = "meq/dL";
	public static final String MILLI_EQUIVALENTS_PER_GRAM_CODE = "meq/g";
	public static final String MILLI_EQUIVALENTS_PER_GRAM_CREATININE_CODE = "meq/g{Cre}";
	public static final String MILLI_EQUIVALENTS_PER_KILOGRAM_CODE = "meq/kg";
	public static final String MILLI_EQUIVALENTS_PER_LITER_CODE = "meq/L";
	public static final String MILLI_EQUIVALENTS_PER_SPECIMEN_CODE = "meq/{Specimen}";
	public static final String MILLI_EQUIVALENTS_PER_SQUAREMETER_CODE = "meq/m2";
	public static final String MILLIGRAM_CODE = "mg";
	public static final String MILLIGRAM_PER_GRAM_CREATININE_CODE = "mg/g{Cre}";
	public static final String MILLIGRAM_PER_TOTAL_VOLUME_CODE = "mg/{TotalVolume}";
	public static final String MILLIGRAMS_PER_DECILITER_CODE = "mg/dL";
	public static final String MILLIGRAMS_PER_GRAM_CODE = "mg/g";
	public static final String MILLIGRAMS_PER_KILOGRAM_CODE = "mg/kg";
	public static final String MILLIGRAMS_PER_LITER_CODE = "mg/L";
	public static final String MILLIGRAMS_PER_MILLIGRAM_CODE = "mg/mg";
	public static final String MILLIGRAMS_PER_MILLIGRAM_CREATININE_CODE = "mg/mg{Cre}";
	public static final String MILLIGRAMS_PER_MILLILITER_CODE = "mg/mL";
	public static final String MILLIGRAMS_PER_SQUAREMETER_CODE = "mg/m2";
	public static final String MILLIGRAMS_PER_VOLUME_CODE = "mg/{Volume}";
	public static final String MILLIGRAMS_PHENYLKETONES_PER_DECILITER_CODE = "mg{Phenylketones}/dL";
	public static final String MILLI_INTERNATIONAL_UNITS_PER_LITER_CODE = "m[iU]/L";
	public static final String MILLI_INTERNATIONAL_UNITS_PER_MILLILITER_CODE = "m[iU]/mL";
	public static final String MILLILITER_CODE = "mL";
	public static final String MILLILITERS_PER_DECILITER_CODE = "mL/dL";
	public static final String MILLILITERS_PER_HEARTBEAT_CODE = "mL/{h`b}";
	public static final String MILLILITERS_PER_KILOGRAM_CODE = "mL/kg";
	public static final String MILLIMETER_CODE = "mm";
	public static final String MILLIMETERS_OF_MERCURY_CODE = "mm[Hg]";
	public static final String MILLIMOLE_CODE = "mmol";
	public static final String MILLIMOLES_PER_DECILITER_CODE = "mmol/dL";
	public static final String MILLIMOLES_PER_GRAM_CODE = "mmol/g";
	public static final String MILLIMOLES_PER_KILOGRAM_CODE = "mmol/kg";
	public static final String MILLIMOLES_PER_LITER_CODE = "mmol/L";
	public static final String MILLIMOLES_PER_MOLE_CODE = "mmol/mol";
	public static final String MILLIMOLES_PER_MOLE_CREATININE_CODE = "mmol/mol{Cre}";
	public static final String MILLIMOLES_PER_SQUAREMETER_CODE = "mmol/m2";
	public static final String MILLIMOLES_PER_TOTAL_VOLUME_CODE = "mmol/{TotalVolume}";
	public static final String MILLION_CODE = "10*6";
	public static final String MILLION_EQUIVALENTS_PER_MILLILITER_CODE = "10*6.eq/mL";
	public static final String MILLION_INTERNATIONAL_UNIT_CODE = "10*6.[iU]";
	public static final String MILLION_PER_LITER_CODE = "10*6/L";
	public static final String MILLION_PER_MILLILITER_CODE = "10*6/mL";
	public static final String MILLION_PER_SPECIMEN_CODE = "10*6/{Specimen}";
	public static final String MILLIONS_PER_MICROLITER_CODE = "10*6/uL";
	public static final String MILLIOSMOLE_CODE = "mosm";
	public static final String MILLIOSMOLES_PER_KILOGRAM_CODE = "mosm/kg";
	public static final String MILLIOSMOLES_PER_LITER_CODE = "mosm/L";
	public static final String MILLISECOND_CODE = "ms";
	public static final String MILLI_UNITS_PER_GRAM_CODE = "mU/g";
	public static final String MILLI_UNITS_PER_GRAM_HEMOGLOBIN_CODE = "mU/g{Hgb}";
	public static final String MILLI_UNITS_PER_MILLIGRAM_CODE = "mU/mg";
	public static final String MILLI_UNITS_PER_MILLIGRAM_CREATININE_CODE = "mU/mg{Cre}";
	public static final String MINUTE_CODE = "min";
	public static final String MOLE_CODE = "mol";
	public static final String MOLES_PER_CUBICMETER_CODE = "mol/m3";
	public static final String MOLES_PER_KILOGRAM_CODE = "mol/kg";
	public static final String MOLES_PER_LITER_CODE = "mol/L";
	public static final String MOLES_PER_MILLILITER_CODE = "mol/mL";
	public static final String MONTH_CODE = "mo";
	public static final String NANOGRAM_CODE = "ng";
	public static final String NANOGRAMS_PER_DECILITER_CODE = "ng/dL";
	public static final String NANOGRAMS_PER_GRAM_CODE = "ng/g";
	public static final String NANOGRAMS_PER_GRAM_CREATININE_CODE = "ng/g{Cre}";
	public static final String NANOGRAMS_PER_KILOGRAM_CODE = "ng/kg";
	public static final String NANOGRAMS_PER_LITER_CODE = "ng/L";
	public static final String NANOGRAMS_PER_MILLIGRAM_CODE = "ng/mg";
	public static final String NANOGRAMS_PER_MILLIGRAM_PROTEIN_CODE = "ng/mg{Protein}";
	public static final String NANOGRAMS_PER_MILLILITER_CODE = "ng/mL";
	public static final String NANOGRAMS_PER_MILLILITER_RED_BLOOD_CELLS_CODE = "ng/mL{rbc}";
	public static final String NANOGRAMS_PER_SQUAREMETER_CODE = "ng/m2";
	public static final String NANOLITER_CODE = "nL";
	public static final String NANOMETER_CODE = "nm";
	public static final String NANOMOLE_CODE = "nmol";
	public static final String NANOMOLES_PER_DECILITER_CODE = "nmol/dL";
	public static final String NANOMOLES_PER_GRAM_CODE = "nmol/g";
	public static final String NANOMOLES_PER_GRAM_CREATININE_CODE = "nmol/g{Cre}";
	public static final String NANOMOLES_PER_LITER_CODE = "nmol/L";
	public static final String NANOMOLES_PER_MILLIGRAM_CODE = "nmol/mg";
	public static final String NANOMOLES_PER_MILLILITER_CODE = "nmol/mL";
	public static final String NANOMOLES_PER_MILLIMOLE_CODE = "nmol/mmol";
	public static final String NANOMOLES_PER_MILLIMOLE_CREATININE_CODE = "nmol/mmol{Cre}";
	public static final String NANOMOLES_PER_MOLE_CODE = "nmol/mol";
	public static final String NANOSECOND_CODE = "ns";
	public static final String NAUTICAL_MILE_CODE = "[nmi_i]";
	public static final String ONE_HUNDRED_THOUSAND_CODE = "10*5";
	public static final String OSMOLES_PER_KILOGRAM_CODE = "osm/kg";
	public static final String OSMOLES_PER_LITER_CODE = "osm/L";
	public static final String OUNCE_CODE = "[oz_av]";
	public static final String PER_100_CODE = "/100";
	public static final String PER_100_SPERMATOZOA_CODE = "/100{Spermatozoa}";
	public static final String PER_100_WBC_CODE = "/100{WBC}";
	public static final String PER_ARBITRARY_UNIT_CODE = "/[arb`U]";
	public static final String PER_BILLION_CODE = "/10*9";
	public static final String PERCENT_CODE = "%";
	public static final String PERCENT_0_TO_3_HOURS_CODE = "%{0to3Hours}";
	public static final String PERCENT_ABNORMAL_CODE = "%{Abnormal}";
	public static final String PERCENT_ACTIVITY_CODE = "%{Activity}";
	public static final String PERCENT_BASAL_ACTIVITY_CODE = "%{BasalActivity}";
	public static final String PERCENT_BINDING_CODE = "%{Binding}";
	public static final String PERCENT_BLOCKADE_CODE = "%{Blockade}";
	public static final String PERCENT_BOUND_CODE = "%{Bound}";
	public static final String PERCENT_CARBOXY_HEMOGLOBIN_CODE = "%{Carboxyhemoglobin}";
	public static final String PERCENT_EOSINOPHILS_SEEN_CODE = "%{EosSeen}";
	public static final String PERCENT_EXCRETION_CODE = "%{Excretion}";
	public static final String PERCENT_FETAL_ERYTHROCYTES_CODE = "%{FetalErythrocytes}";
	public static final String PERCENT_HEMOGLOBIN_CODE = "%{Hemoglobin}";
	public static final String PERCENT_HEMOGLOBIN_A1C_CODE = "%{HemoglobinA1C}";
	public static final String PERCENT_HEMOGLOBIN_SATURATION_CODE = "%{HemoglobinSaturation}";
	public static final String PERCENT_HEMOLYSIS_CODE = "%{Hemolysis}";
	public static final String PERCENT_INHIBITION_CODE = "%{Inhibition}";
	public static final String PERCENT_NORMAL_CODE = "%{Normal}";
	public static final String PERCENT_NORMAL_POOLED_PLASMA_CODE = "%{NormalPooledPlasma}";
	public static final String PERCENT_OF_BACTERIA_CODE = "%{ofBacteria}";
	public static final String PERCENT_OF_LYMPHOCYTES_CODE = "%{OfLymphocytes}";
	public static final String PERCENT_OF_WBCS_CODE = "%{OfWBCs}";
	public static final String PERCENT_OXYGEN_CODE = "%{Oxygen}";
	public static final String PERCENT_PER_100_WBC_CODE = "%/100{WBC}";
	public static final String PERCENT_POSITIVE_CODE = "%{Positive}";
	public static final String PERCENT_SPERM_MOTILITY_CODE = "%{SpermMotility}";
	public static final String PERCENT_TOTAL_CODE = "%{Total}";
	public static final String PERCENT_TOTAL_PROTEIN_CODE = "%{TotalProtein}";
	public static final String PERCENT_UPTAKE_CODE = "%{Uptake}";
	public static final String PER_DECILITER_CODE = "/dL";
	public static final String PER_ENTITY_CODE = "/{Entity}";
	public static final String PER_GRAM_CODE = "/g";
	public static final String PER_GRAM_CREATININE_CODE = "/g{creat}";
	public static final String PER_GRAM_HEMOGLOBIN_CODE = "/g{HGB}";
	public static final String PER_GRAM_TOTAL_NITROGEN_CODE = "/g{tot`nit}";
	public static final String PER_GRAM_TOTAL_PROTEIN_CODE = "/g{tot`prot}";
	public static final String PER_GRAM_WET_TISSUE_CODE = "/g{wet`tis}";
	public static final String PER_HOUR_CODE = "/h";
	public static final String PER_KILOGRAM_CODE = "/kg";
	public static final String PER_KILOGRAM_BODY_WEIGHT_CODE = "/kg{body`wt}";
	public static final String PER_LITER_CODE = "/L";
	public static final String PER_MICROLITER_CODE = "/uL";
	public static final String PER_MILLIGRAM_CODE = "/mg";
	public static final String PER_MILLILITER_CODE = "/mL";
	public static final String PER_MILLION_CODE = "/10*6";
	public static final String PER_MINUTE_CODE = "/min";
	public static final String PER_SECOND_CODE = "/s";
	public static final String PER_SQUAREMETER_CODE = "/m2";
	public static final String PER_TEN_GIGA_CODE = "/10*10";
	public static final String PER_TOTAL_COUNT_CODE = "/{tot}";
	public static final String PER_TRILLION_CODE = "/10*12";
	public static final String PER_TRILLION_RED_BLOOD_CELLS_CODE = "/10*12{rbc}";
	public static final String PH_CODE = "[pH]";
	public static final String PICOGRAM_CODE = "pg";
	public static final String PICOGRAMS_CODE = "pg";
	public static final String PICOGRAMS_PER_DECILITER_CODE = "pg/dL";
	public static final String PICOGRAMS_PER_LITER_CODE = "pg/L";
	public static final String PICOGRAMS_PER_MILLILITER_CODE = "pg/mL";
	public static final String PICOGRAMS_PER_MILLIMETER_CODE = "pg/mm";
	public static final String PICOLITER_CODE = "pL";
	public static final String PICOMETER_CODE = "pm";
	public static final String PICOMOLE_CODE = "pmol";
	public static final String PICOMOLES_PER_DECILITER_CODE = "pmol/dL";
	public static final String PICOMOLES_PER_LITER_CODE = "pmol/L";
	public static final String PICOMOLES_PER_MICROMOLE_CODE = "pmol/umol";
	public static final String PICOMOLES_PER_MILLILITER_CODE = "pmol/mL";
	public static final String PICOSECOND_CODE = "ps";
	public static final String PINT_CODE = "[pt_us]";
	public static final String POUND_CODE = "[lb_av]";
	public static final String QUART_CODE = "[qt_us]";
	public static final String RED_BLOOD_CELLS_PER_MICROLITER_CODE = "{rbc}/uL";
	public static final String RELATIVE_PERCENT_CODE = "{Relative}%";
	public static final String SECOND_CODE = "s";
	public static final String SPERMATOZOA_PER_MILLILITER_CODE = "{Spermatozoa}/mL";
	public static final String SQUARE_CENTIMETER_CODE = "cm2";
	public static final String SQUAREFEET_CODE = "[sft_i]";
	public static final String SQUAREINCH_CODE = "[sin_i]";
	public static final String SQUAREMETER_CODE = "m2";
	public static final String SQUAREMILLIMETER_CODE = "mm2";
	public static final String SQUAREYARD_CODE = "[syd_i]";
	public static final String STATUS_MILE_CODE = "[mi_i]";
	public static final String TEN_TO_EIGHTH_CODE = "10*8";
	public static final String THOUSAND_CODE = "10*3";
	public static final String THOUSAND_COPIES_PER_MILLILITER_CODE = "10*3{Copies}/mL";
	public static final String THOUSAND_PER_LITER_CODE = "10*3/L";
	public static final String THOUSAND_PER_MILLILITER_CODE = "10*3/mL";
	public static final String THOUSAND_RED_BLOOD_CELLS_CODE = "10*3.{RBC}";
	public static final String THOUSANDS_PER_MICROLITER_CODE = "10*3/uL";
	public static final String TON_CODE = "[ston_av]";
	public static final String TRILLION_PER_LITER_CODE = "10*12/L";
	public static final String TROY_OUNCE_CODE = "[oz_tr]";
	public static final String UNITS_PER_GRAM_CODE = "U/g";
	public static final String UNITS_PER_GRAM_CREATININE_CODE = "U/g{Cre}";
	public static final String UNITS_PER_GRAM_HEMOGLOBIN_CODE = "U/g{Hgb}";
	public static final String UNITS_PER_LITER_CODE = "U/L";
	public static final String VOLUME_PERCENT_CODE = "%{vol}";
	public static final String WEEK_CODE = "wk";

	public static final String YARD_CODE = "[yd_i]";

	public static final String YEAR_CODE = "a";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static Ucum getEnum(String code) {
		for (final Ucum x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(Ucum.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final Ucum x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private Ucum(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		final var cd = new CD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	/**
	 * <div class="en">Gets the husky Code Object</div>
	 * <div class="de">Liefert das husky Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		return new Code(code, CODE_SYSTEM_OID, displayName);
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}

}