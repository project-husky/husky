/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.common.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="en">UCUM - Units of Measure</div>
*<div class="de">UCUM - Maßeinheiten</div>
*/
public enum Ucum {

	/**
	 * <div class="en">AHGEquivalentsPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	AHGEquivalentsPerMilliLiter("{AHG}eq/mL",
			"AHGEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> BillionPerLiter [Number Concentration Units] </div>
	 */
	BillionPerLiter("10*9/L", "BillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> BillionsPerMicroLiter [Number Concentration
	 * Units]</div>
	 */
	BillionsPerMicroLiter("10*9/uL", "BillionsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> BillionsPerMilliliter [Number Concentration Units]
	 * </div>
	 */
	BillionsPerMilliliter("10*9/mL", "BillionsPerMilliliter [Number Concentration Units]"),
	/**
	 * <div class= "en"> BoneCollagenEquivalentsPerMicroMoleCreatinine
	 * [Substance Ratio Or Substance Fraction Units] </div>
	 */
	BoneCollagenEquivalentsPerMicroMoleCreatinine("{BoneCollagen}eq/umol{Cre}",
			"BoneCollagenEquivalentsPerMicroMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> BoneCollagenEquivalentsPerMilliMoleCreatinine
	 * [Substance Ratio Or Substance Fraction Units] </div>
	 */
	BoneCollagenEquivalentsPerMilliMoleCreatinine("{BoneCollagen}eq/mmol{Cre}",
			"BoneCollagenEquivalentsPerMilliMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> CellsPerMicroLiter [Number Concentration Units] </div>
	 */
	CellsPerMicroLiter("{Cells}/uL", "CellsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> CentiGram [SI Mass Units]</div>
	 */
	CentiGram("cg", "CentiGram [SI Mass Units]"),
	/**
	 * <div class="en">CentiLiter [SI Volume Units]</div>
	 */
	CentiLiter("cL", "CentiLiter [SI Volume Units]"),
	/**
	 * <div class="en">CentiMeter [SI Length Units]</div>
	 */
	CentiMeter("cm", "CentiMeter [SI Length Units]"),
	/**
	 * <div class="en"> ColonyFormingUnitsPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	ColonyFormingUnitsPerMilliLiter("{cfu}/mL",
			"ColonyFormingUnitsPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class = "en"> ComplementCh50UnitsPerMilliLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	ComplementCh50UnitsPerMilliLiter("{ComplementCh50}U/mL",
			"ComplementCh50UnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> CopiesPerMilliLiter [Number Concentration Units]
	 * </div>
	 */
	CopiesPerMilliLiter("{Copies}/mL", "CopiesPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> CubicInch [English Volume Units] </div>
	 */
	CubicInch("[cin_i]", "CubicInch [English Volume Units]"),
	/**
	 * <div class="en">Cup [English Volume Units]</div>
	 */
	Cup("[cup_us]", "Cup [English Volume Units]"),
	/**
	 * <div class="en">Day [Time Units]</div>
	 */
	Day("d", "Day [Time Units]"),
	/**
	 * <div class="en">DeciGram [SI Mass Units]</div>
	 */
	DeciGram("dg", "DeciGram [SI Mass Units]"),
	/**
	 * <div class="en">DeciLiter [SI Volume Units]</div>
	 */
	DeciLiter("dL", "DeciLiter [SI Volume Units]"),
	/**
	 * <div class="en">DeciMeter [SI Length Units]</div>
	 */
	DeciMeter("dm", "DeciMeter [SI Length Units]"),
	/**
	 * <div class="en">DegreesCelsius [Temperature Units]</div>
	 */
	DegreesCelsius("Cel", "DegreesCelsius [Temperature Units]"),
	/**
	 * <div class="en"> DegreesFahrenheit [Temperature Units]</div>
	 */
	DegreesFahrenheit("[degF]", "DegreesFahrenheit [Temperature Units]"),
	/**
	 * <div class="en"> DegreesKelvin [Temperature Units]</div>
	 */
	DegreesKelvin("K", "DegreesKelvin [Temperature Units]"),
	/**
	 * <div class="en"> DegreesOfArc [Plane Angle Units]</div>
	 */
	DegreesOfArc("deg", "DegreesOfArc [Plane Angle Units]"),
	/**
	 * <div class="en"> Descriptive Name</div>
	 */
	Descriptive("Code", "Descriptive Name"),
	/**
	 * <div class="en">Dram [English Mass Units]</div>
	 */
	Dram("[dr_av]", "Dram [English Mass Units]"),
	/**
	 * <div class="en"> EhrlichUnitsPer100Gram [Arbitrary Concentration Content
	 * Units]</div>
	 */
	EhrlichUnitsPer100Gram("{Ehrlich_U}/100g",
			"EhrlichUnitsPer100Gram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class = "en"> EhrlichUnitsPerDeciLiter [Arbitrary Concentration
	 * Units] </div>
	 */
	EhrlichUnitsPerDeciLiter("{Ehrlich_U}/dL",
			"EhrlichUnitsPerDeciLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> ElisaUnitsPerMilliLiter [Arbitrary Concentration
	 * Units] </div>
	 */
	ElisaUnitsPerMilliLiter("{Elisa_U}/mL",
			"ElisaUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> Equivalent [Substance Units] </div>
	 */
	Equivalent("eq", "Equivalent [Substance Units]"),
	/**
	 * <div class="en"> EquivalentsPerLiter [Substance Concentration
	 * Units]</div>
	 */
	EquivalentsPerLiter("eq/L", "EquivalentsPerLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> EquivalentsPerMicroMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	EquivalentsPerMicroMole("eq/umol",
			"EquivalentsPerMicroMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> EquivalentsPerMilliLiter [Substance Concentration
	 * Units] </div>
	 */
	EquivalentsPerMilliLiter("eq/mL", "EquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> EquivalentsPerMilliMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	EquivalentsPerMilliMole("eq/mmol",
			"EquivalentsPerMilliMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> Fathom [English Length Units] </div>
	 */
	Fathom("[fth_i]", "Fathom [English Length Units]"),
	/**
	 * <div class="en">Feet [English Length Units]</div>
	 */
	Feet("[ft_i]", "Feet [English Length Units]"),
	/**
	 * <div class="en">FemtoGram [SI Mass Units]</div>
	 */
	FemtoGram("fg", "FemtoGram [SI Mass Units]"),
	/**
	 * <div class="en">FemtoLiter [Most Common Healthcare Units]</div>
	 */
	FemtoLiter("fL", "FemtoLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en"> FemtoMeter [SI Length Units]</div>
	 */
	FemtoMeter("fm", "FemtoMeter [SI Length Units]"),
	/**
	 * <div class="en">Femtomole [Substance Units]</div>
	 */
	Femtomole("fmol", "Femtomole [Substance Units]"),
	/**
	 * <div class="en">FemtoMolesPerGram [Substance Content Units]</div>
	 */
	FemtoMolesPerGram("fmol/g", "FemtoMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en"> FemtoMolesPerMilliGram [Substance Content Units]</div>
	 */
	FemtoMolesPerMilliGram("fmol/mg", "FemtoMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class= "en"> FemtoMolesPerMilliLiter [Substance Concentration Units]
	 * </div>
	 */
	FemtoMolesPerMilliLiter("fmol/mL", "FemtoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> FluidDram [English Volume Units] </div>
	 */
	FluidDram("[fdr_us]", "FluidDram [English Volume Units]"),
	/**
	 * <div class="en"> FluidOunce [English Volume Units]</div>
	 */
	FluidOunce("[foz_us]", "FluidOunce [English Volume Units]"),
	/**
	 * <div class="en">French [English Length Units]</div>
	 */
	French("[Ch]", "French [English Length Units]"),
	/**
	 * <div class="en">Gallon [English Volume Units]</div>
	 */
	Gallon("[gal_us]", "Gallon [English Volume Units]"),
	/**
	 * <div class="en">Grain [English Mass Units]</div>
	 */
	Grain("[gr]", "Grain [English Mass Units]"),
	/**
	 * <div class="en">Gram [SI Mass Units]</div>
	 */
	Gram("g", "Gram [SI Mass Units]"),
	/**
	 * <div class="en">GramMeter [Massive Distance Units]</div>
	 */
	GramMeter("g.m", "GramMeter [Massive Distance Units]"),
	/**
	 * <div class="en"> GramMeterPerHeartbeat [Massive Distance Units]</div>
	 */
	GramMeterPerHeartbeat("g.m/{hb}", "GramMeterPerHeartbeat [Massive Distance Units]"),
	/**
	 * <div class= "en"> GramMeterPerHeartbeatPerSquareMeter [Lineic Mass
	 * Units]</div>
	 */
	GramMeterPerHeartbeatPerSquareMeter("g.m/({hb}.m2)",
			"GramMeterPerHeartbeatPerSquareMeter [Lineic Mass Units]"),
	/**
	 * <div class = "en"> GramsPer100Gram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	GramsPer100Gram("g/[100]g",
			"GramsPer100Gram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> GramsPerDeciLiter [Most Common Healthcare Units]
	 * </div>
	 */
	GramsPerDeciLiter("g/dL", "GramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> GramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	GramsPerGram("g/g", "GramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> GramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	GramsPerGramCreatinine("g/g{Cre}",
			"GramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> GramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	GramsPerKiloGram("g/kg",
			"GramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> GramsPerLiter [Most Common Healthcare Units] </div>
	 */
	GramsPerLiter("g/L", "GramsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> GramsPerMilliLiter [Most Common Healthcare Units]</div>
	 */
	GramsPerMilliLiter("g/mL", "GramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> GramsPerSquareMeter [Areic Mass Units] </div>
	 */
	GramsPerSquareMeter("g/m2", "GramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> GramsPerTotalWeight [SI Mass Units]</div>
	 */
	GramsPerTotalWeight("g/{TotalWeight}", "GramsPerTotalWeight [SI Mass Units]"),
	/**
	 * <div class="en"> HectoLiter [SI Volume Units]</div>
	 */
	HectoLiter("hL", "HectoLiter [SI Volume Units]"),
	/**
	 * <div class="en">Hour [Time Units]</div>
	 */
	Hour("h", "Hour [Time Units]"),
	/**
	 * <div class="en"> IgAPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	IgAPhospholipidUnitsPerMilliLiter("{IgAPhospholipid}U/mL",
			"IgAPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> IgGPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	IgGPhospholipidUnitsPerMilliLiter("{IgGPhospholipid}U/mL",
			"IgGPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> IgMPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	IgMPhospholipidUnitsPerMilliLiter("{IgMPhospholipid}U/mL",
			"IgMPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> Inch [English Length Units] </div>
	 */
	Inch("[in_i]", "Inch [English Length Units]"),
	/**
	 * <div class="en">InternationalUnit [Arbitrary Units]</div>
	 */
	InternationalUnit("[iU]", "InternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en"> InternationalUnitsPerDeciLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	InternationalUnitsPerDeciLiter("[iU]/dL",
			"InternationalUnitsPerDeciLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerGram [Arbitrary Concentration
	 * Content Units] </div>
	 */
	InternationalUnitsPerGram("[iU]/g",
			"InternationalUnitsPerGram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerGramHemoglobin [Arbitrary
	 * Concentration Content Units] </div>
	 */
	InternationalUnitsPerGramHemoglobin("[iU]/g{Hgb}",
			"InternationalUnitsPerGramHemoglobin [Arbitrary Concentration Content Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerKilogram [Arbitrary Concentration
	 * Content Units] </div>
	 */
	InternationalUnitsPerKilogram("[iU]/kg",
			"InternationalUnitsPerKilogram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerLiter [Most Common Healthcare
	 * Units] </div>
	 */
	InternationalUnitsPerLiter("[iU]/L",
			"InternationalUnitsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> InternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	InternationalUnitsPerMilliLiter("[iU]/mL",
			"InternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> KatalPerKilogram [Substance Rate Content Units] </div>
	 */
	KatalPerKilogram("kat/kg", "KatalPerKilogram [Substance Rate Content Units]"),
	/**
	 * <div class= "en"> KelvinPerWatt [Thermal Resistance Units]</div>
	 */
	KelvinPerWatt("K/W", "KelvinPerWatt [Thermal Resistance Units]"),
	/**
	 * <div class="en"> KiloCaloriesPerOunce [Energy Content Units]</div>
	 */
	KiloCaloriesPerOunce("kCal/[oz_av]", "KiloCaloriesPerOunce [Energy Content Units]"),
	/**
	 * <div class="en"> KiloGram [SI Mass Units]</div>
	 */
	KiloGram("kg", "KiloGram [SI Mass Units]"),
	/**
	 * <div class="en"> KiloGramsPerCubicMeter [Mass Concentration Units]</div>
	 */
	KiloGramsPerCubicMeter("kg/m3", "KiloGramsPerCubicMeter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> KiloGramsPerLiter [Mass Concentration Units] </div>
	 */
	KiloGramsPerLiter("kg/L", "KiloGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> KiloGramsPerMole [Molar Mass Units]</div>
	 */
	KiloGramsPerMole("kg/mol", "KiloGramsPerMole [Molar Mass Units]"),
	/**
	 * <div class="en"> KiloGramsPerSquareMeter [Areic Mass Units]</div>
	 */
	KiloGramsPerSquareMeter("kg/m2", "KiloGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> KiloInternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	KiloInternationalUnitsPerMilliLiter("k[iU]/mL",
			"KiloInternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> KiloLiter [SI Volume Units] </div>
	 */
	KiloLiter("kL", "KiloLiter [SI Volume Units]"),
	/**
	 * <div class="en">KiloMeter [SI Length Units]</div>
	 */
	KiloMeter("km", "KiloMeter [SI Length Units]"),
	/**
	 * <div class="en">KiloPascal [Most Common Healthcare Units]</div>
	 */
	KiloPascal("kPa", "KiloPascal [Most Common Healthcare Units]"),
	/**
	 * <div class="en"> KiloSecond [Time Units]</div>
	 */
	KiloSecond("ks", "KiloSecond [Time Units]"),
	/**
	 * <div class="en">KiloUnitsPerGram [Substance Rate Content Units]</div>
	 */
	KiloUnitsPerGram("kU/g", "KiloUnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class= "en">Liter [SI Volume Units]</div>
	 */
	Liter("L", "Liter [SI Volume Units]"),
	/**
	 * <div class="en">LitersPerKilogram [Volume Content Units]</div>
	 */
	LitersPerKilogram("L/kg", "LitersPerKilogram [Volume Content Units]"),
	/**
	 * <div class="en"> LiterSquareSecondPerSecond [Volume Duration Units]</div>
	 */
	LiterSquareSecondPerSecond("L.s2/s", "LiterSquareSecondPerSecond [Volume Duration Units]"),
	/**
	 * <div class= "en"> Log10 [Unity] </div>
	 */
	Log10("[lg]", "Log10 [Unity]"),
	/**
	 * <div class="en">Megasecond [Time Units]</div>
	 */
	Megasecond("Ms", "Megasecond [Time Units]"),
	/**
	 * <div class="en">Meter [SI Length Units]</div>
	 */
	Meter("m", "Meter [SI Length Units]"),
	/**
	 * <div class="en">MetricTon [SI Mass Units]</div>
	 */
	MetricTon("t", "MetricTon [SI Mass Units]"),
	/**
	 * <div class="en">MicroEquivalent [Substance Units]</div>
	 */
	MicroEquivalent("ueq", "MicroEquivalent [Substance Units]"),
	/**
	 * <div class="en"> MicroEquivalentsPerLiter [Substance Concentration
	 * Units]</div>
	 */
	MicroEquivalentsPerLiter("ueq/L", "MicroEquivalentsPerLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MicroEquivalentsPerMilliLiter [Substance Concentration
	 * Units] </div>
	 */
	MicroEquivalentsPerMilliLiter("ueq/mL",
			"MicroEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MicroGram [SI Mass Units] </div>
	 */
	MicroGram("ug", "MicroGram [SI Mass Units]"),
	/**
	 * <div class="en"> MicroGramPer100Gram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	MicroGramPer100Gram("ug/[100]g",
			"MicroGramPer100Gram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramPerGramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	MicroGramPerGramCreatinine("ug/g{Cre}",
			"MicroGramPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramPerGramDryWeight [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units] </div>
	 */
	MicroGramPerGramDryWeight("ug/g{DryWeight}",
			"MicroGramPerGramDryWeight [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerDeciLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MicroGramsPerDeciLiter("ug/dL", "MicroGramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MicroGramsPerDeciLiterRedBloodCells [Mass
	 * Concentration Units] </div>
	 */
	MicroGramsPerDeciLiterRedBloodCells("ug/dL{rbc}",
			"MicroGramsPerDeciLiterRedBloodCells [Mass Concentration Units]"),
	/**
	 * <div class = "en"> MicroGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	MicroGramsPerGram("ug/g",
			"MicroGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerGramHemoglobin [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	MicroGramsPerGramHemoglobin("ug/g{Hgb}",
			"MicroGramsPerGramHemoglobin [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerKiloGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	MicroGramsPerKiloGram("ug/kg",
			"MicroGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerLiter [Mass Concentration Units] </div>
	 */
	MicroGramsPerLiter("ug/L", "MicroGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> MicroGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MicroGramsPerMilliGram("ug/mg",
			"MicroGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerMilliGramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	MicroGramsPerMilliGramCreatinine("ug/mg{Cre}",
			"MicroGramsPerMilliGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerMilliLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MicroGramsPerMilliLiter("ug/mL", "MicroGramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MicroGramsPerNanoGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	MicroGramsPerNanoGram("ug/ng",
			"MicroGramsPerNanoGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MicroGramsPerSpecimen [SI Mass Units] </div>
	 */
	MicroGramsPerSpecimen("ug/{Specimen}", "MicroGramsPerSpecimen [SI Mass Units]"),
	/**
	 * <div class="en"> MicroGramsPerSquareMeter [Areic Mass Units]</div>
	 */
	MicroGramsPerSquareMeter("ug/m2", "MicroGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> MicroGramsPerTotalVolume [SI Mass Units]</div>
	 */
	MicroGramsPerTotalVolume("ug/{TotalVolume}", "MicroGramsPerTotalVolume [SI Mass Units]"),
	/**
	 * <div class="en"> MicroInternationalUnit [Arbitrary Units]</div>
	 */
	MicroInternationalUnit("u[iU]", "MicroInternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en"> MicroInternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	MicroInternationalUnitsPerMilliLiter("u[iU]/mL",
			"MicroInternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> MicroLiter [SI Volume Units] </div>
	 */
	MicroLiter("uL", "MicroLiter [SI Volume Units]"),
	/**
	 * <div class="en">MicroMeter [SI Length Units]</div>
	 */
	MicroMeter("um", "MicroMeter [SI Length Units]"),
	/**
	 * <div class="en">MicroMole [Substance Units]</div>
	 */
	MicroMole("umol", "MicroMole [Substance Units]"),
	/**
	 * <div class="en"> MicroMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	MicroMolesPerDeciLiter("umol/dL", "MicroMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MicroMolesPerGram [Substance Content Units] </div>
	 */
	MicroMolesPerGram("umol/g", "MicroMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en"> MicroMolesPerGramCreatinine [Substance Content
	 * Units]</div>
	 */
	MicroMolesPerGramCreatinine("umol/g{Cre}",
			"MicroMolesPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class = "en"> MicroMolesPerGramHemoglobin [Substance Content Units]
	 * </div>
	 */
	MicroMolesPerGramHemoglobin("umol/g{Hgb}",
			"MicroMolesPerGramHemoglobin [Substance Content Units]"),
	/**
	 * <div class = "en"> MicroMolesPerLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MicroMolesPerLiter("umol/L", "MicroMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> MicroMolesPerMilliGram [Substance Content Units] </div>
	 */
	MicroMolesPerMilliGram("umol/mg", "MicroMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class= "en"> MicroMolesPerMilliGramCreatinine [Substance Content
	 * Units] </div>
	 */
	MicroMolesPerMilliGramCreatinine("umol/mg{Cre}",
			"MicroMolesPerMilliGramCreatinine [Substance Content Units]"),
	/**
	 * <div class = "en"> MicroMolesPerMilliLiter [Substance Concentration
	 * Units] </div>
	 */
	MicroMolesPerMilliLiter("umol/mL", "MicroMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MicroMolesPerMinutePerGram [Substance Rate Content
	 * Units] </div>
	 */
	MicroMolesPerMinutePerGram("umol/min/g",
			"MicroMolesPerMinutePerGram [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> MicroMolesPerMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	MicroMolesPerMole("umol/mol",
			"MicroMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> MicroMolesPerMoleCreatinine [Substance Ratio Or
	 * Substance Fraction Units] </div>
	 */
	MicroMolesPerMoleCreatinine("umol/mol{Cre}",
			"MicroMolesPerMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> MicroSecond [Time Units] </div>
	 */
	MicroSecond("us", "MicroSecond [Time Units]"),
	/**
	 * <div class="en">MilliEquivalent [Substance Units]</div>
	 */
	MilliEquivalent("meq", "MilliEquivalent [Substance Units]"),
	/**
	 * <div class="en"> MilliEquivalentPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MilliEquivalentPerMilliLiter("meq/mL",
			"MilliEquivalentPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerDeciLiter [Substance Concentration
	 * Units] </div>
	 */
	MilliEquivalentsPerDeciLiter("meq/dL",
			"MilliEquivalentsPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerGram [Substance Content Units]
	 * </div>
	 */
	MilliEquivalentsPerGram("meq/g", "MilliEquivalentsPerGram [Substance Content Units]"),
	/**
	 * <div class= "en"> MilliEquivalentsPerGramCreatinine [Substance Content
	 * Units] </div>
	 */
	MilliEquivalentsPerGramCreatinine("meq/g{Cre}",
			"MilliEquivalentsPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerKiloGram [Substance Content Units]
	 * </div>
	 */
	MilliEquivalentsPerKiloGram("meq/kg", "MilliEquivalentsPerKiloGram [Substance Content Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerLiter [Most Common Healthcare
	 * Units] </div>
	 */
	MilliEquivalentsPerLiter("meq/L", "MilliEquivalentsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliEquivalentsPerSpecimen [Substance Units] </div>
	 */
	MilliEquivalentsPerSpecimen("meq/{Specimen}", "MilliEquivalentsPerSpecimen [Substance Units]"),
	/**
	 * <div class= "en"> MilliEquivalentsPerSquareMeter [Areic Substance
	 * Units]</div>
	 */
	MilliEquivalentsPerSquareMeter("meq/m2",
			"MilliEquivalentsPerSquareMeter [Areic Substance Units]"),
	/**
	 * <div class = "en"> MilliGram [SI Mass Units] </div>
	 */
	MilliGram("mg", "MilliGram [SI Mass Units]"),
	/**
	 * <div class="en"> MilliGramPerGramCreatinine [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units]</div>
	 */
	MilliGramPerGramCreatinine("mg/g{Cre}",
			"MilliGramPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilliGramPerTotalVolume [SI Mass Units] </div>
	 */
	MilliGramPerTotalVolume("mg/{TotalVolume}", "MilliGramPerTotalVolume [SI Mass Units]"),
	/**
	 * <div class="en"> MilliGramsPerCubicMeter [Mass Concentration Units]</div>
	 */
	MilliGramsPerCubicMeter("mg/m3", "MilliGramsPerCubicMeter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> MilliGramsPerDeciLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MilliGramsPerDeciLiter("mg/dL", "MilliGramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	MilliGramsPerGram("mg/g",
			"MilliGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilliGramsPerKiloGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	MilliGramsPerKiloGram("mg/kg",
			"MilliGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilliGramsPerLiter [Mass Concentration Units] </div>
	 */
	MilliGramsPerLiter("mg/L", "MilliGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> MilliGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MilliGramsPerMilliGram("mg/mg",
			"MilliGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilligramsPerMilligramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	MilligramsPerMilligramCreatinine("mg/mg{Cre}",
			"MilligramsPerMilligramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> MilliGramsPerMilliLiter [Mass Concentration Units]
	 * </div>
	 */
	MilliGramsPerMilliLiter("mg/mL", "MilliGramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> MilliGramsPerSquareMeter [Areic Mass Units] </div>
	 */
	MilliGramsPerSquareMeter("mg/m2", "MilliGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> MilliGramsPerVolume [SI Mass Units]</div>
	 */
	MilliGramsPerVolume("mg/{Volume}", "MilliGramsPerVolume [SI Mass Units]"),
	/**
	 * <div class="en"> MilliGramsPhenylketonesPerDeciLiter [Mass Concentration
	 * Units]</div>
	 */
	MilliGramsPhenylketonesPerDeciLiter("mg{Phenylketones}/dL",
			"MilliGramsPhenylketonesPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class = "en"> MilliInternationalUnitsPerLiter [Arbitrary
	 * Concentration Units] </div>
	 */
	MilliInternationalUnitsPerLiter("m[iU]/L",
			"MilliInternationalUnitsPerLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class = "en"> MilliInternationalUnitsPerMilliLiter [Most Common
	 * Healthcare Units] </div>
	 */
	MilliInternationalUnitsPerMilliLiter("m[iU]/mL",
			"MilliInternationalUnitsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliLiter [SI Volume Units] </div>
	 */
	MilliLiter("mL", "MilliLiter [SI Volume Units]"),
	/**
	 * <div class="en"> MilliLitersPerDeciLiter [Volume Fraction Units]</div>
	 */
	MilliLitersPerDeciLiter("mL/dL", "MilliLitersPerDeciLiter [Volume Fraction Units]"),
	/**
	 * <div class= "en"> MilliLitersPerHeartbeat [SI Volume Units]</div>
	 */
	MilliLitersPerHeartbeat("mL/{h`b}", "MilliLitersPerHeartbeat [SI Volume Units]"),
	/**
	 * <div class="en"> MilliLitersPerKiloGram [Volume Content Units]</div>
	 */
	MilliLitersPerKiloGram("mL/kg", "MilliLitersPerKiloGram [Volume Content Units]"),
	/**
	 * <div class= "en"> MilliMeter [SI Length Units]</div>
	 */
	MilliMeter("mm", "MilliMeter [SI Length Units]"),
	/**
	 * <div class="en"> MilliMetersOfMercury [Most Common Healthcare
	 * Units]</div>
	 */
	MilliMetersOfMercury("mm[Hg]", "MilliMetersOfMercury [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> MilliMole [Substance Units] </div>
	 */
	MilliMole("mmol", "MilliMole [Substance Units]"),
	/**
	 * <div class="en"> MilliMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	MilliMolesPerDeciLiter("mmol/dL", "MilliMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MilliMolesPerGram [Substance Content Units] </div>
	 */
	MilliMolesPerGram("mmol/g", "MilliMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en"> MilliMolesPerKiloGram [Most Common Healthcare
	 * Units]</div>
	 */
	MilliMolesPerKiloGram("mmol/kg", "MilliMolesPerKiloGram [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliMolesPerLiter [Most Common Healthcare Units]
	 * </div>
	 */
	MilliMolesPerLiter("mmol/L", "MilliMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> MilliMolesPerMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	MilliMolesPerMole("mmol/mol",
			"MilliMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> MilliMolesPerMoleCreatinine [Substance Ratio Or
	 * Substance Fraction Units] </div>
	 */
	MilliMolesPerMoleCreatinine("mmol/mol{Cre}",
			"MilliMolesPerMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> MilliMolesPerSquareMeter [Areic Substance Units]
	 * </div>
	 */
	MilliMolesPerSquareMeter("mmol/m2", "MilliMolesPerSquareMeter [Areic Substance Units]"),
	/**
	 * <div class= "en"> MilliMolesPerTotalVolume [Substance Units] </div>
	 */
	MilliMolesPerTotalVolume("mmol/{TotalVolume}", "MilliMolesPerTotalVolume [Substance Units]"),
	/**
	 * <div class="en"> Million [Unity]</div>
	 */
	Million("10*6", "Million [Unity]"),
	/**
	 * <div class="en"> MillionEquivalentsPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MillionEquivalentsPerMilliLiter("10*6.eq/mL",
			"MillionEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MillionInternationalUnit [Arbitrary Units] </div>
	 */
	MillionInternationalUnit("10*6.[iU]", "MillionInternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en"> MillionPerLiter [Number Concentration Units]</div>
	 */
	MillionPerLiter("10*6/L", "MillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> MillionPerMilliLiter [Number Concentration Units]</div>
	 */
	MillionPerMilliLiter("10*6/mL", "MillionPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> MillionPerSpecimen [Unity] </div>
	 */
	MillionPerSpecimen("10*6/{Specimen}", "MillionPerSpecimen [Unity]"),
	/**
	 * <div class="en"> MillionsPerMicroLiter [Most Common Healthcare
	 * Units]</div>
	 */
	MillionsPerMicroLiter("10*6/uL", "MillionsPerMicroLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliOsmole [Substance Units] </div>
	 */
	MilliOsmole("mosm", "MilliOsmole [Substance Units]"),
	/**
	 * <div class="en"> MilliOsmolesPerKiloGram [Most Common Healthcare
	 * Units]</div>
	 */
	MilliOsmolesPerKiloGram("mosm/kg", "MilliOsmolesPerKiloGram [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> MilliOsmolesPerLiter [Substance Concentration Units]
	 * </div>
	 */
	MilliOsmolesPerLiter("mosm/L", "MilliOsmolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> MilliSecond [Time Units] </div>
	 */
	MilliSecond("ms", "MilliSecond [Time Units]"),
	/**
	 * <div class="en">MilliUnitsPerGram [Substance Rate Content Units]</div>
	 */
	MilliUnitsPerGram("mU/g", "MilliUnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class= "en"> MilliUnitsPerGramHemoglobin [Substance Rate Content
	 * Units] </div>
	 */
	MilliUnitsPerGramHemoglobin("mU/g{Hgb}",
			"MilliUnitsPerGramHemoglobin [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> MilliUnitsPerMilligram [Substance Rate Content Units]
	 * </div>
	 */
	MilliUnitsPerMilligram("mU/mg", "MilliUnitsPerMilligram [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> MilliUnitsPerMilliGramCreatinine [Substance Rate
	 * Content Units] </div>
	 */
	MilliUnitsPerMilliGramCreatinine("mU/mg{Cre}",
			"MilliUnitsPerMilliGramCreatinine [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> Minute [Time Units] </div>
	 */
	Minute("min", "Minute [Time Units]"),
	/**
	 * <div class="en">Mole [Substance Units]</div>
	 */
	Mole("mol", "Mole [Substance Units]"),
	/**
	 * <div class="en">MolesPerCubicMeter [Substance Concentration Units]</div>
	 */
	MolesPerCubicMeter("mol/m3", "MolesPerCubicMeter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> MolesPerKiloGram [Substance Content Units] </div>
	 */
	MolesPerKiloGram("mol/kg", "MolesPerKiloGram [Substance Content Units]"),
	/**
	 * <div class="en"> MolesPerLiter [Substance Concentration Units]</div>
	 */
	MolesPerLiter("mol/L", "MolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> MolesPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MolesPerMilliLiter("mol/mL", "MolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> Month [Time Units] </div>
	 */
	Month("mo", "Month [Time Units]"),
	/**
	 * <div class="en">NanoGram [SI Mass Units]</div>
	 */
	NanoGram("ng", "NanoGram [SI Mass Units]"),
	/**
	 * <div class="en"> NanoGramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	NanoGramsPerDeciLiter("ng/dL", "NanoGramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> NanoGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units] </div>
	 */
	NanoGramsPerGram("ng/g",
			"NanoGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerGramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	NanoGramsPerGramCreatinine("ng/g{Cre}",
			"NanoGramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerKiloGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units] </div>
	 */
	NanoGramsPerKiloGram("ng/kg",
			"NanoGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerLiter [Mass Concentration Units] </div>
	 */
	NanoGramsPerLiter("ng/L", "NanoGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> NanoGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	NanoGramsPerMilliGram("ng/mg",
			"NanoGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerMilliGramProtein [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units] </div>
	 */
	NanoGramsPerMilliGramProtein("ng/mg{Protein}",
			"NanoGramsPerMilliGramProtein [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class = "en"> NanoGramsPerMilliLiter [Most Common Healthcare Units]
	 * </div>
	 */
	NanoGramsPerMilliLiter("ng/mL", "NanoGramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> NanoGramsPerMilliLiterRedBloodCells [Mass Concentration
	 * Units] </div>
	 */
	NanoGramsPerMilliLiterRedBloodCells("ng/mL{rbc}",
			"NanoGramsPerMilliLiterRedBloodCells [Mass Concentration Units]"),
	/**
	 * <div class = "en"> NanoGramsPerSquareMeter [Areic Mass Units] </div>
	 */
	NanoGramsPerSquareMeter("ng/m2", "NanoGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en"> NanoLiter [SI Volume Units]</div>
	 */
	NanoLiter("nL", "NanoLiter [SI Volume Units]"),
	/**
	 * <div class="en">NanoMeter [SI Length Units]</div>
	 */
	NanoMeter("nm", "NanoMeter [SI Length Units]"),
	/**
	 * <div class="en">NanoMole [Substance Units]</div>
	 */
	NanoMole("nmol", "NanoMole [Substance Units]"),
	/**
	 * <div class="en"> NanoMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	NanoMolesPerDeciLiter("nmol/dL", "NanoMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> NanoMolesPerGram [Substance Content Units] </div>
	 */
	NanoMolesPerGram("nmol/g", "NanoMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en"> NanoMolesPerGramCreatinine [Substance Content
	 * Units]</div>
	 */
	NanoMolesPerGramCreatinine("nmol/g{Cre}",
			"NanoMolesPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class = "en"> NanoMolesPerLiter [Most Common Healthcare Units]
	 * </div>
	 */
	NanoMolesPerLiter("nmol/L", "NanoMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> NanoMolesPerMilliGram [Substance Content Units] </div>
	 */
	NanoMolesPerMilliGram("nmol/mg", "NanoMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class= "en"> NanoMolesPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	NanoMolesPerMilliLiter("nmol/mL", "NanoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> NanoMolesPerMilliMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	NanoMolesPerMilliMole("nmol/mmol",
			"NanoMolesPerMilliMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> NanoMolesPerMilliMoleCreatinine [Substance Ratio Or
	 * Substance Fraction Units] </div>
	 */
	NanoMolesPerMilliMoleCreatinine("nmol/mmol{Cre}",
			"NanoMolesPerMilliMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> NanoMolesPerMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	NanoMolesPerMole("nmol/mol", "NanoMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> NanoSecond [Time Units] </div>
	 */
	NanoSecond("ns", "NanoSecond [Time Units]"),
	/**
	 * <div class="en">NauticalMile [English Length Units]</div>
	 */
	NauticalMile("[nmi_i]", "NauticalMile [English Length Units]"),
	/**
	 * <div class="en"> OneHundredThousand [Unity]</div>
	 */
	OneHundredThousand("10*5", "OneHundredThousand [Unity]"),
	/**
	 * <div class="en"> OsmolesPerKiloGram [Substance Content Units]</div>
	 */
	OsmolesPerKiloGram("osm/kg", "OsmolesPerKiloGram [Substance Content Units]"),
	/**
	 * <div class= "en"> OsmolesPerLiter [Substance Concentration Units]</div>
	 */
	OsmolesPerLiter("osm/L", "OsmolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en">Ounce [English Mass Units]</div>
	 */
	Ounce("[oz_av]", "Ounce [English Mass Units]"),
	/**
	 * <div class="en">Per100 [Entitic Number Units]</div>
	 */
	Per100("/100", "Per100 [Entitic Number Units]"),
	/**
	 * <div class="en"> Per100Spermatozoa [Entitic Number Units]</div>
	 */
	Per100Spermatozoa("/100{Spermatozoa}", "Per100Spermatozoa [Entitic Number Units]"),
	/**
	 * <div class="en"> Per100WBC [Entitic Number Units]</div>
	 */
	Per100WBC("/100{WBC}", "Per100WBC [Entitic Number Units]"),
	/**
	 * <div class="en"> PerArbitraryUnit [Arbitrary Number Units]</div>
	 */
	PerArbitraryUnit("/[arb`U]", "PerArbitraryUnit [Arbitrary Number Units]"),
	/**
	 * <div class="en"> PerBillion [Number Fraction Units]</div>
	 */
	PerBillion("/10*9", "PerBillion [Number Fraction Units]"),
	/**
	 * <div class="en">Percent [Most Common Healthcare Units]</div>
	 */
	Percent("%", "Percent [Most Common Healthcare Units]"),
	/**
	 * <div class="en"> Percent0to3Hours [General Fraction Unit]</div>
	 */
	Percent0to3Hours("%{0to3Hours}", "Percent0to3Hours [General Fraction Unit]"),
	/**
	 * <div class="en"> PercentAbnormal [Number Fraction Units]</div>
	 */
	PercentAbnormal("%{Abnormal}", "PercentAbnormal [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentActivity [Catalytic Fraction Or Arbitrary
	 * Fraction Units]</div>
	 */
	PercentActivity("%{Activity}",
			"PercentActivity [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class = "en"> PercentBasalActivity [Catalytic Fraction Or Arbitrary
	 * Fraction Units] </div>
	 */
	PercentBasalActivity("%{BasalActivity}",
			"PercentBasalActivity [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class = "en"> PercentBinding [Mass Or Substance Fraction Units]
	 * </div>
	 */
	PercentBinding("%{Binding}", "PercentBinding [Mass Or Substance Fraction Units]"),
	/**
	 * <div class= "en"> PercentBlockade [Number Fraction Units] </div>
	 */
	PercentBlockade("%{Blockade}", "PercentBlockade [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentBound [Mass Or Substance Fraction Units]</div>
	 */
	PercentBound("%{Bound}", "PercentBound [Mass Or Substance Fraction Units]"),
	/**
	 * <div class= "en"> PercentCarboxyhemoglobin [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PercentCarboxyhemoglobin("%{Carboxyhemoglobin}",
			"PercentCarboxyhemoglobin [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentEosinophilsSeen [Number Fraction Units] </div>
	 */
	PercentEosinophilsSeen("%{EosSeen}", "PercentEosinophilsSeen [Number Fraction Units]"),
	/**
	 * <div class= "en"> PercentExcretion [Mass Or Substance Rate Fraction
	 * Units]</div>
	 */
	PercentExcretion("%{Excretion}", "PercentExcretion [Mass Or Substance Rate Fraction Units]"),
	/**
	 * <div class = "en"> PercentFetalErythrocytes [Number Fraction Units]
	 * </div>
	 */
	PercentFetalErythrocytes("%{FetalErythrocytes}",
			"PercentFetalErythrocytes [Number Fraction Units]"),
	/**
	 * <div class= "en"> PercentHemoglobin [Mass Or Substance Fraction Units]
	 * </div>
	 */
	PercentHemoglobin("%{Hemoglobin}", "PercentHemoglobin [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentHemoglobinA1C [Mass Or Substance Fraction
	 * Units] </div>
	 */
	PercentHemoglobinA1C("%{HemoglobinA1C}",
			"PercentHemoglobinA1C [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentHemoglobinSaturation [Mass Or Substance
	 * Fraction Units] </div>
	 */
	PercentHemoglobinSaturation("%{HemoglobinSaturation}",
			"PercentHemoglobinSaturation [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentHemolysis [Number Fraction Units] </div>
	 */
	PercentHemolysis("%{Hemolysis}", "PercentHemolysis [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentInhibition [Catalytic Fraction Or Arbitrary
	 * Fraction Units]</div>
	 */
	PercentInhibition("%{Inhibition}",
			"PercentInhibition [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class = "en"> PercentNormal [Number Fraction Units] </div>
	 */
	PercentNormal("%{Normal}", "PercentNormal [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentNormalPooledPlasma [Catalytic Fraction Or
	 * Arbitrary Fraction Units]</div>
	 */
	PercentNormalPooledPlasma("%{NormalPooledPlasma}",
			"PercentNormalPooledPlasma [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class = "en"> PercentofBacteria [Number Fraction Units] </div>
	 */
	PercentofBacteria("%{ofBacteria}", "PercentofBacteria [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentOfLymphocytes [Number Fraction Units]</div>
	 */
	PercentOfLymphocytes("%{OfLymphocytes}", "PercentOfLymphocytes [Number Fraction Units]"),
	/**
	 * <div class= "en"> PercentOfWBCs [Number Fraction Units]</div>
	 */
	PercentOfWBCs("%{OfWBCs}", "PercentOfWBCs [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentOxygen [Volume Fraction Units]</div>
	 */
	PercentOxygen("%{Oxygen}", "PercentOxygen [Volume Fraction Units]"),
	/**
	 * <div class="en"> PercentPer100WBC [Number Fraction Units]</div>
	 */
	PercentPer100WBC("%/100{WBC}", "PercentPer100WBC [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentPositive [Number Fraction Units]</div>
	 */
	PercentPositive("%{Positive}", "PercentPositive [Number Fraction Units]"),
	/**
	 * <div class="en"> PercentSpermMotility [Number Fraction Units]</div>
	 */
	PercentSpermMotility("%{SpermMotility}", "PercentSpermMotility [Number Fraction Units]"),
	/**
	 * <div class= "en"> PercentTotal [General Fraction Unit]</div>
	 */
	PercentTotal("%{Total}", "PercentTotal [General Fraction Unit]"),
	/**
	 * <div class="en"> PercentTotalProtein [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PercentTotalProtein("%{TotalProtein}",
			"PercentTotalProtein [Mass Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PercentUptake [Mass Or Substance Rate Fraction Units]
	 * </div>
	 */
	PercentUptake("%{Uptake}", "PercentUptake [Mass Or Substance Rate Fraction Units]"),
	/**
	 * <div class = "en"> PerDeciLiter [Number Concentration Units] </div>
	 */
	PerDeciLiter("/dL", "PerDeciLiter [Number Concentration Units]"),
	/**
	 * <div class="en"> PerEntity [Entitic Number Units]</div>
	 */
	PerEntity("/{Entity}", "PerEntity [Entitic Number Units]"),
	/**
	 * <div class="en">PerGram [Number Content Units]</div>
	 */
	PerGram("/g", "PerGram [Number Content Units]"),
	/**
	 * <div class="en"> PerGramCreatinine [Number Content Units]</div>
	 */
	PerGramCreatinine("/g{creat}", "PerGramCreatinine [Number Content Units]"),
	/**
	 * <div class="en"> PerGramHemoglobin [Number Content Units]</div>
	 */
	PerGramHemoglobin("/g{HGB}", "PerGramHemoglobin [Number Content Units]"),
	/**
	 * <div class="en"> PerGramTotalNitrogen [Number Content Units]</div>
	 */
	PerGramTotalNitrogen("/g{tot`nit}", "PerGramTotalNitrogen [Number Content Units]"),
	/**
	 * <div class="en"> PerGramTotalProtein [Number Content Units]</div>
	 */
	PerGramTotalProtein("/g{tot`prot}", "PerGramTotalProtein [Number Content Units]"),
	/**
	 * <div class="en"> PerGramWetTissue [Number Content Units]</div>
	 */
	PerGramWetTissue("/g{wet`tis}", "PerGramWetTissue [Number Content Units]"),
	/**
	 * <div class="en"> PerHour [Number Events]</div>
	 */
	PerHour("/h", "PerHour [Number Events]"),
	/**
	 * <div class="en">PerKiloGram [Number Content Units]</div>
	 */
	PerKiloGram("/kg", "PerKiloGram [Number Content Units]"),
	/**
	 * <div class="en"> PerKiloGramBodyWeight [Number Content Units]</div>
	 */
	PerKiloGramBodyWeight("/kg{body`wt}", "PerKiloGramBodyWeight [Number Content Units]"),
	/**
	 * <div class= "en">PerLiter [Number Concentration Units]</div>
	 */
	PerLiter("/L", "PerLiter [Number Concentration Units]"),
	/**
	 * <div class="en"> PerMicroLiter [Most Common Healthcare Units]</div>
	 */
	PerMicroLiter("/uL", "PerMicroLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> PerMilliGram [Number Content Units]</div>
	 */
	PerMilliGram("/mg", "PerMilliGram [Number Content Units]"),
	/**
	 * <div class="en"> PerMilliLiter [Number Concentration Units]</div>
	 */
	PerMilliLiter("/mL", "PerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en"> PerMillion [Number Fraction Units]</div>
	 */
	PerMillion("/10*6", "PerMillion [Number Fraction Units]"),
	/**
	 * <div class="en">PerMinute [Number Events]</div>
	 */
	PerMinute("/min", "PerMinute [Number Events]"),
	/**
	 * <div class="en">PerSecond [Number Events]</div>
	 */
	PerSecond("/s", "PerSecond [Number Events]"),
	/**
	 * <div class="en">PerSquareMeter [Areic Number Units]</div>
	 */
	PerSquareMeter("/m2", "PerSquareMeter [Areic Number Units]"),
	/**
	 * <div class="en"> PerTenGiga [Number Fraction Units]</div>
	 */
	PerTenGiga("/10*10", "PerTenGiga [Number Fraction Units]"),
	/**
	 * <div class="en"> PerTotalCount [Unity]</div>
	 */
	PerTotalCount("/{tot}", "PerTotalCount [Unity]"),
	/**
	 * <div class="en">PerTrillion [Number Fraction Units]</div>
	 */
	PerTrillion("/10*12", "PerTrillion [Number Fraction Units]"),
	/**
	 * <div class="en"> PerTrillionRedBloodCells [Entitic Number Units]</div>
	 */
	PerTrillionRedBloodCells("/10*12{rbc}", "PerTrillionRedBloodCells [Entitic Number Units]"),
	/**
	 * <div class= "en">pH [pH Units]</div>
	 */
	pH("[pH]", "pH [pH Units]"),
	/**
	 * <div class="en">PicoGram [SI Mass Units]</div>
	 */
	PicoGram("pg", "PicoGram [SI Mass Units]"),
	/**
	 * <div class="en">PicoGrams [Most Common Healthcare Units]</div>
	 */
	PicoGrams("pg", "PicoGrams [Most Common Healthcare Units]"),
	/**
	 * <div class="en"> PicoGramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	PicoGramsPerDeciLiter("pg/dL", "PicoGramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> PicoGramsPerLiter [Mass Concentration Units] </div>
	 */
	PicoGramsPerLiter("pg/L", "PicoGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class= "en"> PicoGramsPerMilliLiter [Most Common Healthcare
	 * Units]</div>
	 */
	PicoGramsPerMilliLiter("pg/mL", "PicoGramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class = "en"> PicoGramsPerMilliMeter [Lineic Mass Units] </div>
	 */
	PicoGramsPerMilliMeter("pg/mm", "PicoGramsPerMilliMeter [Lineic Mass Units]"),
	/**
	 * <div class="en"> PicoLiter [SI Volume Units]</div>
	 */
	PicoLiter("pL", "PicoLiter [SI Volume Units]"),
	/**
	 * <div class="en">PicoMeter [SI Length Units]</div>
	 */
	PicoMeter("pm", "PicoMeter [SI Length Units]"),
	/**
	 * <div class="en">PicoMole [Substance Units]</div>
	 */
	PicoMole("pmol", "PicoMole [Substance Units]"),
	/**
	 * <div class="en"> PicoMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	PicoMolesPerDeciLiter("pmol/dL", "PicoMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> PicoMolesPerLiter [Substance Concentration Units]
	 * </div>
	 */
	PicoMolesPerLiter("pmol/L", "PicoMolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class= "en"> PicoMolesPerMicroMole [Substance Ratio Or Substance
	 * Fraction Units] </div>
	 */
	PicoMolesPerMicroMole("pmol/umol",
			"PicoMolesPerMicroMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class = "en"> PicoMolesPerMilliLiter [Substance Concentration Units]
	 * </div>
	 */
	PicoMolesPerMilliLiter("pmol/mL", "PicoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class = "en"> PicoSecond [Time Units] </div>
	 */
	PicoSecond("ps", "PicoSecond [Time Units]"),
	/**
	 * <div class="en">Pint [English Volume Units]</div>
	 */
	Pint("[pt_us]", "Pint [English Volume Units]"),
	/**
	 * <div class="en">Pound [English Mass Units]</div>
	 */
	Pound("[lb_av]", "Pound [English Mass Units]"),
	/**
	 * <div class="en">Quart [English Volume Units]</div>
	 */
	Quart("[qt_us]", "Quart [English Volume Units]"),
	/**
	 * <div class="en"> RedBloodCellsPerMicroLiter [Number Concentration
	 * Units]</div>
	 */
	RedBloodCellsPerMicroLiter("{rbc}/uL",
			"RedBloodCellsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class = "en"> RelativePercent [General Fraction Unit] </div>
	 */
	RelativePercent("{Relative}%", "RelativePercent [General Fraction Unit]"),
	/**
	 * <div class="en"> Second [Time Units]</div>
	 */
	Second("s", "Second [Time Units]"),
	/**
	 * <div class="en">SpermatozoaPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	SpermatozoaPerMilliLiter("{Spermatozoa}/mL",
			"SpermatozoaPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class = "en"> SquareCentiMeter [SI Area Units] </div>
	 */
	SquareCentiMeter("cm2", "SquareCentiMeter [SI Area Units]"),
	/**
	 * <div class="en"> SquareFeet [English Area Units]</div>
	 */
	SquareFeet("[sft_i]", "SquareFeet [English Area Units]"),
	/**
	 * <div class="en">SquareInch [English Area Units]</div>
	 */
	SquareInch("[sin_i]", "SquareInch [English Area Units]"),
	/**
	 * <div class="en">SquareMeter [SI Area Units]</div>
	 */
	SquareMeter("m2", "SquareMeter [SI Area Units]"),
	/**
	 * <div class="en">SquareMilliMeter [SI Area Units]</div>
	 */
	SquareMilliMeter("mm2", "SquareMilliMeter [SI Area Units]"),
	/**
	 * <div class="en"> SquareYard [English Area Units]</div>
	 */
	SquareYard("[syd_i]", "SquareYard [English Area Units]"),
	/**
	 * <div class="en">StatuteMile [English Length Units]</div>
	 */
	StatuteMile("[mi_i]", "StatuteMile [English Length Units]"),
	/**
	 * <div class="en"> TenToEighth [Unity]</div>
	 */
	TenToEighth("10*8", "TenToEighth [Unity]"),
	/**
	 * <div class="en">Thousand [Unity]</div>
	 */
	Thousand("10*3", "Thousand [Unity]"),
	/**
	 * <div class="en"> ThousandCopiesPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	ThousandCopiesPerMilliLiter("10*3{Copies}/mL",
			"ThousandCopiesPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class = "en"> ThousandPerLiter [Number Concentration Units] </div>
	 */
	ThousandPerLiter("10*3/L", "ThousandPerLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> ThousandPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	ThousandPerMilliLiter("10*3/mL", "ThousandPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> ThousandRedBloodCells [Unity] </div>
	 */
	ThousandRedBloodCells("10*3.{RBC}", "ThousandRedBloodCells [Unity]"),
	/**
	 * <div class="en"> ThousandsPerMicroLiter [Number Concentration
	 * Units]</div>
	 */
	ThousandsPerMicroLiter("10*3/uL", "ThousandsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class= "en">Ton [English Mass Units] </div>
	 */
	Ton("[ston_av]", "Ton [English Mass Units]"),
	/**
	 * <div class="en">TrillionPerLiter [Number Concentration Units]</div>
	 */
	TrillionPerLiter("10*12/L", "TrillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class= "en"> TroyOunce [English Mass Units]</div>
	 */
	TroyOunce("[oz_tr]", "TroyOunce [English Mass Units]"),
	/**
	 * <div class="en">UnitsPerGram [Substance Rate Content Units]</div>
	 */
	UnitsPerGram("U/g", "UnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class="en"> UnitsPerGramCreatinine [Substance Rate Content
	 * Units]</div>
	 */
	UnitsPerGramCreatinine("U/g{Cre}", "UnitsPerGramCreatinine [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> UnitsPerGramHemoglobin [Substance Rate Content Units]
	 * </div>
	 */
	UnitsPerGramHemoglobin("U/g{Hgb}", "UnitsPerGramHemoglobin [Substance Rate Content Units]"),
	/**
	 * <div class = "en"> UnitsPerLiter [Most Common Healthcare Units] </div>
	 */
	UnitsPerLiter("U/L", "UnitsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class= "en"> VolumePercent [Volume Fraction Units]</div>
	 */
	VolumePercent("%{vol}", "VolumePercent [Volume Fraction Units]"),
	/**
	 * <div class="en">Week [Time Units]</div>
	 */
	Week("wk", "Week [Time Units]"),
	/**
	 * <div class="en">Yard [English Length Units]</div>
	 */
	Yard("[yd_i]", "Yard [English Length Units]"),
	/**
	 * <div class="en">Year [Time Units]</div>
	 */
	Year("a", "Year [Time Units]");
	public static final String AHGEquivalentsPerMilliLiter_CODE = "{AHG}eq/mL";
	public static final String BillionPerLiter_CODE = "10*9/L";
	public static final String BillionsPerMicroLiter_CODE = "10*9/uL";
	public static final String BillionsPerMilliliter_CODE = "10*9/mL";
	public static final String BoneCollagenEquivalentsPerMicroMoleCreatinine_CODE = "{BoneCollagen}eq/umol{Cre}";
	public static final String BoneCollagenEquivalentsPerMilliMoleCreatinine_CODE = "{BoneCollagen}eq/mmol{Cre}";
	public static final String CellsPerMicroLiter_CODE = "{Cells}/uL";
	public static final String CentiGram_CODE = "cg";
	public static final String CentiLiter_CODE = "cL";
	public static final String CentiMeter_CODE = "cm";
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
	public static final String ColonyFormingUnitsPerMilliLiter_CODE = "{cfu}/mL";
	public static final String ComplementCh50UnitsPerMilliLiter_CODE = "{ComplementCh50}U/mL";
	public static final String CopiesPerMilliLiter_CODE = "{Copies}/mL";
	public static final String CubicInch_CODE = "[cin_i]";
	public static final String Cup_CODE = "[cup_us]";
	public static final String Day_CODE = "d";
	public static final String DeciGram_CODE = "dg";
	public static final String DeciLiter_CODE = "dL";
	public static final String DeciMeter_CODE = "dm";
	public static final String DegreesCelsius_CODE = "Cel";
	public static final String DegreesFahrenheit_CODE = "[degF]";
	public static final String DegreesKelvin_CODE = "K";
	public static final String DegreesOfArc_CODE = "deg";
	public static final String Descriptive_CODE = "Code";
	public static final String Dram_CODE = "[dr_av]";
	public static final String EhrlichUnitsPer100Gram_CODE = "{Ehrlich_U}/100g";
	public static final String EhrlichUnitsPerDeciLiter_CODE = "{Ehrlich_U}/dL";
	public static final String ElisaUnitsPerMilliLiter_CODE = "{Elisa_U}/mL";
	public static final String Equivalent_CODE = "eq";
	public static final String EquivalentsPerLiter_CODE = "eq/L";
	public static final String EquivalentsPerMicroMole_CODE = "eq/umol";
	public static final String EquivalentsPerMilliLiter_CODE = "eq/mL";
	public static final String EquivalentsPerMilliMole_CODE = "eq/mmol";
	public static final String Fathom_CODE = "[fth_i]";
	public static final String Feet_CODE = "[ft_i]";
	public static final String FemtoGram_CODE = "fg";
	public static final String FemtoLiter_CODE = "fL";
	public static final String FemtoMeter_CODE = "fm";
	public static final String Femtomole_CODE = "fmol";
	public static final String FemtoMolesPerGram_CODE = "fmol/g";
	public static final String FemtoMolesPerMilliGram_CODE = "fmol/mg";
	public static final String FemtoMolesPerMilliLiter_CODE = "fmol/mL";
	public static final String FluidDram_CODE = "[fdr_us]";
	public static final String FluidOunce_CODE = "[foz_us]";
	public static final String French_CODE = "[Ch]";
	public static final String Gallon_CODE = "[gal_us]";
	public static final String Grain_CODE = "[gr]";
	public static final String Gram_CODE = "g";
	public static final String GramMeter_CODE = "g.m";
	public static final String GramMeterPerHeartbeat_CODE = "g.m/{hb}";
	public static final String GramMeterPerHeartbeatPerSquareMeter_CODE = "g.m/({hb}.m2)";
	public static final String GramsPer100Gram_CODE = "g/[100]g";
	public static final String GramsPerDeciLiter_CODE = "g/dL";
	public static final String GramsPerGram_CODE = "g/g";
	public static final String GramsPerGramCreatinine_CODE = "g/g{Cre}";
	public static final String GramsPerKiloGram_CODE = "g/kg";
	public static final String GramsPerLiter_CODE = "g/L";
	public static final String GramsPerMilliLiter_CODE = "g/mL";
	public static final String GramsPerSquareMeter_CODE = "g/m2";
	public static final String GramsPerTotalWeight_CODE = "g/{TotalWeight}";
	public static final String HectoLiter_CODE = "hL";
	public static final String Hour_CODE = "h";
	public static final String IgAPhospholipidUnitsPerMilliLiter_CODE = "{IgAPhospholipid}U/mL";
	public static final String IgGPhospholipidUnitsPerMilliLiter_CODE = "{IgGPhospholipid}U/mL";
	public static final String IgMPhospholipidUnitsPerMilliLiter_CODE = "{IgMPhospholipid}U/mL";
	public static final String Inch_CODE = "[in_i]";
	public static final String InternationalUnit_CODE = "[iU]";
	public static final String InternationalUnitsPerDeciLiter_CODE = "[iU]/dL";
	public static final String InternationalUnitsPerGram_CODE = "[iU]/g";
	public static final String InternationalUnitsPerGramHemoglobin_CODE = "[iU]/g{Hgb}";
	public static final String InternationalUnitsPerKilogram_CODE = "[iU]/kg";
	public static final String InternationalUnitsPerLiter_CODE = "[iU]/L";
	public static final String InternationalUnitsPerMilliLiter_CODE = "[iU]/mL";
	public static final String KatalPerKilogram_CODE = "kat/kg";
	public static final String KelvinPerWatt_CODE = "K/W";
	public static final String KiloCaloriesPerOunce_CODE = "kCal/[oz_av]";
	public static final String KiloGram_CODE = "kg";
	public static final String KiloGramsPerCubicMeter_CODE = "kg/m3";
	public static final String KiloGramsPerLiter_CODE = "kg/L";
	public static final String KiloGramsPerMole_CODE = "kg/mol";
	public static final String KiloGramsPerSquareMeter_CODE = "kg/m2";
	public static final String KiloInternationalUnitsPerMilliLiter_CODE = "k[iU]/mL";
	public static final String KiloLiter_CODE = "kL";
	public static final String KiloMeter_CODE = "km";
	public static final String KiloPascal_CODE = "kPa";
	public static final String KiloSecond_CODE = "ks";
	public static final String KiloUnitsPerGram_CODE = "kU/g";
	public static final String Liter_CODE = "L";
	public static final String LitersPerKilogram_CODE = "L/kg";
	public static final String LiterSquareSecondPerSecond_CODE = "L.s2/s";
	public static final String Log10_CODE = "[lg]";
	public static final String Megasecond_CODE = "Ms";
	public static final String Meter_CODE = "m";
	public static final String MetricTon_CODE = "t";
	public static final String MicroEquivalent_CODE = "ueq";
	public static final String MicroEquivalentsPerLiter_CODE = "ueq/L";
	public static final String MicroEquivalentsPerMilliLiter_CODE = "ueq/mL";
	public static final String MicroGram_CODE = "ug";
	public static final String MicroGramPer100Gram_CODE = "ug/[100]g";
	public static final String MicroGramPerGramCreatinine_CODE = "ug/g{Cre}";
	public static final String MicroGramPerGramDryWeight_CODE = "ug/g{DryWeight}";
	public static final String MicroGramsPerDeciLiter_CODE = "ug/dL";
	public static final String MicroGramsPerDeciLiterRedBloodCells_CODE = "ug/dL{rbc}";
	public static final String MicroGramsPerGram_CODE = "ug/g";
	public static final String MicroGramsPerGramHemoglobin_CODE = "ug/g{Hgb}";
	public static final String MicroGramsPerKiloGram_CODE = "ug/kg";
	public static final String MicroGramsPerLiter_CODE = "ug/L";
	public static final String MicroGramsPerMilliGram_CODE = "ug/mg";
	public static final String MicroGramsPerMilliGramCreatinine_CODE = "ug/mg{Cre}";
	public static final String MicroGramsPerMilliLiter_CODE = "ug/mL";
	public static final String MicroGramsPerNanoGram_CODE = "ug/ng";
	public static final String MicroGramsPerSpecimen_CODE = "ug/{Specimen}";
	public static final String MicroGramsPerSquareMeter_CODE = "ug/m2";
	public static final String MicroGramsPerTotalVolume_CODE = "ug/{TotalVolume}";
	public static final String MicroInternationalUnit_CODE = "u[iU]";
	public static final String MicroInternationalUnitsPerMilliLiter_CODE = "u[iU]/mL";
	public static final String MicroLiter_CODE = "uL";
	public static final String MicroMeter_CODE = "um";
	public static final String MicroMole_CODE = "umol";
	public static final String MicroMolesPerDeciLiter_CODE = "umol/dL";
	public static final String MicroMolesPerGram_CODE = "umol/g";
	public static final String MicroMolesPerGramCreatinine_CODE = "umol/g{Cre}";
	public static final String MicroMolesPerGramHemoglobin_CODE = "umol/g{Hgb}";
	public static final String MicroMolesPerLiter_CODE = "umol/L";
	public static final String MicroMolesPerMilliGram_CODE = "umol/mg";
	public static final String MicroMolesPerMilliGramCreatinine_CODE = "umol/mg{Cre}";
	public static final String MicroMolesPerMilliLiter_CODE = "umol/mL";
	public static final String MicroMolesPerMinutePerGram_CODE = "umol/min/g";
	public static final String MicroMolesPerMole_CODE = "umol/mol";
	public static final String MicroMolesPerMoleCreatinine_CODE = "umol/mol{Cre}";
	public static final String MicroSecond_CODE = "us";
	public static final String MilliEquivalent_CODE = "meq";
	public static final String MilliEquivalentPerMilliLiter_CODE = "meq/mL";
	public static final String MilliEquivalentsPerDeciLiter_CODE = "meq/dL";
	public static final String MilliEquivalentsPerGram_CODE = "meq/g";
	public static final String MilliEquivalentsPerGramCreatinine_CODE = "meq/g{Cre}";
	public static final String MilliEquivalentsPerKiloGram_CODE = "meq/kg";
	public static final String MilliEquivalentsPerLiter_CODE = "meq/L";
	public static final String MilliEquivalentsPerSpecimen_CODE = "meq/{Specimen}";
	public static final String MilliEquivalentsPerSquareMeter_CODE = "meq/m2";
	public static final String MilliGram_CODE = "mg";
	public static final String MilliGramPerGramCreatinine_CODE = "mg/g{Cre}";
	public static final String MilliGramPerTotalVolume_CODE = "mg/{TotalVolume}";
	public static final String MilliGramsPerDeciLiter_CODE = "mg/dL";
	public static final String MilliGramsPerGram_CODE = "mg/g";
	public static final String MilliGramsPerKiloGram_CODE = "mg/kg";
	public static final String MilliGramsPerLiter_CODE = "mg/L";
	public static final String MilliGramsPerMilliGram_CODE = "mg/mg";
	public static final String MilligramsPerMilligramCreatinine_CODE = "mg/mg{Cre}";
	public static final String MilliGramsPerMilliLiter_CODE = "mg/mL";
	public static final String MilliGramsPerSquareMeter_CODE = "mg/m2";
	public static final String MilliGramsPerVolume_CODE = "mg/{Volume}";
	public static final String MilliGramsPhenylketonesPerDeciLiter_CODE = "mg{Phenylketones}/dL";
	public static final String MilliInternationalUnitsPerLiter_CODE = "m[iU]/L";
	public static final String MilliInternationalUnitsPerMilliLiter_CODE = "m[iU]/mL";
	public static final String MilliLiter_CODE = "mL";
	public static final String MilliLitersPerDeciLiter_CODE = "mL/dL";
	public static final String MilliLitersPerHeartbeat_CODE = "mL/{h`b}";
	public static final String MilliLitersPerKiloGram_CODE = "mL/kg";
	public static final String MilliMeter_CODE = "mm";
	public static final String MilliMetersOfMercury_CODE = "mm[Hg]";
	public static final String MilliMole_CODE = "mmol";
	public static final String MilliMolesPerDeciLiter_CODE = "mmol/dL";
	public static final String MilliMolesPerGram_CODE = "mmol/g";
	public static final String MilliMolesPerKiloGram_CODE = "mmol/kg";
	public static final String MilliMolesPerLiter_CODE = "mmol/L";
	public static final String MilliMolesPerMole_CODE = "mmol/mol";
	public static final String MilliMolesPerMoleCreatinine_CODE = "mmol/mol{Cre}";
	public static final String MilliMolesPerSquareMeter_CODE = "mmol/m2";
	public static final String MilliMolesPerTotalVolume_CODE = "mmol/{TotalVolume}";
	public static final String Million_CODE = "10*6";
	public static final String MillionEquivalentsPerMilliLiter_CODE = "10*6.eq/mL";
	public static final String MillionInternationalUnit_CODE = "10*6.[iU]";
	public static final String MillionPerLiter_CODE = "10*6/L";
	public static final String MillionPerMilliLiter_CODE = "10*6/mL";
	public static final String MillionPerSpecimen_CODE = "10*6/{Specimen}";
	public static final String MillionsPerMicroLiter_CODE = "10*6/uL";
	public static final String MilliOsmole_CODE = "mosm";
	public static final String MilliOsmolesPerKiloGram_CODE = "mosm/kg";
	public static final String MilliOsmolesPerLiter_CODE = "mosm/L";
	public static final String MilliSecond_CODE = "ms";
	public static final String MilliUnitsPerGram_CODE = "mU/g";
	public static final String MilliUnitsPerGramHemoglobin_CODE = "mU/g{Hgb}";
	public static final String MilliUnitsPerMilligram_CODE = "mU/mg";
	public static final String MilliUnitsPerMilliGramCreatinine_CODE = "mU/mg{Cre}";
	public static final String Minute_CODE = "min";
	public static final String Mole_CODE = "mol";
	public static final String MolesPerCubicMeter_CODE = "mol/m3";
	public static final String MolesPerKiloGram_CODE = "mol/kg";
	public static final String MolesPerLiter_CODE = "mol/L";
	public static final String MolesPerMilliLiter_CODE = "mol/mL";
	public static final String Month_CODE = "mo";
	public static final String NanoGram_CODE = "ng";
	public static final String NanoGramsPerDeciLiter_CODE = "ng/dL";
	public static final String NanoGramsPerGram_CODE = "ng/g";
	public static final String NanoGramsPerGramCreatinine_CODE = "ng/g{Cre}";
	public static final String NanoGramsPerKiloGram_CODE = "ng/kg";
	public static final String NanoGramsPerLiter_CODE = "ng/L";
	public static final String NanoGramsPerMilliGram_CODE = "ng/mg";
	public static final String NanoGramsPerMilliGramProtein_CODE = "ng/mg{Protein}";
	public static final String NanoGramsPerMilliLiter_CODE = "ng/mL";
	public static final String NanoGramsPerMilliLiterRedBloodCells_CODE = "ng/mL{rbc}";
	public static final String NanoGramsPerSquareMeter_CODE = "ng/m2";
	public static final String NanoLiter_CODE = "nL";
	public static final String NanoMeter_CODE = "nm";
	public static final String NanoMole_CODE = "nmol";
	public static final String NanoMolesPerDeciLiter_CODE = "nmol/dL";
	public static final String NanoMolesPerGram_CODE = "nmol/g";
	public static final String NanoMolesPerGramCreatinine_CODE = "nmol/g{Cre}";
	public static final String NanoMolesPerLiter_CODE = "nmol/L";
	public static final String NanoMolesPerMilliGram_CODE = "nmol/mg";
	public static final String NanoMolesPerMilliLiter_CODE = "nmol/mL";
	public static final String NanoMolesPerMilliMole_CODE = "nmol/mmol";
	public static final String NanoMolesPerMilliMoleCreatinine_CODE = "nmol/mmol{Cre}";
	public static final String NanoMolesPerMole_CODE = "nmol/mol";
	public static final String NanoSecond_CODE = "ns";
	public static final String NauticalMile_CODE = "[nmi_i]";
	public static final String OneHundredThousand_CODE = "10*5";
	public static final String OsmolesPerKiloGram_CODE = "osm/kg";
	public static final String OsmolesPerLiter_CODE = "osm/L";
	public static final String Ounce_CODE = "[oz_av]";
	public static final String Per100_CODE = "/100";
	public static final String Per100Spermatozoa_CODE = "/100{Spermatozoa}";
	public static final String Per100WBC_CODE = "/100{WBC}";
	public static final String PerArbitraryUnit_CODE = "/[arb`U]";
	public static final String PerBillion_CODE = "/10*9";
	public static final String Percent_CODE = "%";
	public static final String Percent0to3Hours_CODE = "%{0to3Hours}";
	public static final String PercentAbnormal_CODE = "%{Abnormal}";
	public static final String PercentActivity_CODE = "%{Activity}";
	public static final String PercentBasalActivity_CODE = "%{BasalActivity}";
	public static final String PercentBinding_CODE = "%{Binding}";
	public static final String PercentBlockade_CODE = "%{Blockade}";
	public static final String PercentBound_CODE = "%{Bound}";
	public static final String PercentCarboxyhemoglobin_CODE = "%{Carboxyhemoglobin}";
	public static final String PercentEosinophilsSeen_CODE = "%{EosSeen}";
	public static final String PercentExcretion_CODE = "%{Excretion}";
	public static final String PercentFetalErythrocytes_CODE = "%{FetalErythrocytes}";
	public static final String PercentHemoglobin_CODE = "%{Hemoglobin}";
	public static final String PercentHemoglobinA1C_CODE = "%{HemoglobinA1C}";
	public static final String PercentHemoglobinSaturation_CODE = "%{HemoglobinSaturation}";
	public static final String PercentHemolysis_CODE = "%{Hemolysis}";
	public static final String PercentInhibition_CODE = "%{Inhibition}";
	public static final String PercentNormal_CODE = "%{Normal}";
	public static final String PercentNormalPooledPlasma_CODE = "%{NormalPooledPlasma}";
	public static final String PercentofBacteria_CODE = "%{ofBacteria}";
	public static final String PercentOfLymphocytes_CODE = "%{OfLymphocytes}";
	public static final String PercentOfWBCs_CODE = "%{OfWBCs}";
	public static final String PercentOxygen_CODE = "%{Oxygen}";
	public static final String PercentPer100WBC_CODE = "%/100{WBC}";
	public static final String PercentPositive_CODE = "%{Positive}";
	public static final String PercentSpermMotility_CODE = "%{SpermMotility}";
	public static final String PercentTotal_CODE = "%{Total}";
	public static final String PercentTotalProtein_CODE = "%{TotalProtein}";
	public static final String PercentUptake_CODE = "%{Uptake}";
	public static final String PerDeciLiter_CODE = "/dL";
	public static final String PerEntity_CODE = "/{Entity}";
	public static final String PerGram_CODE = "/g";
	public static final String PerGramCreatinine_CODE = "/g{creat}";
	public static final String PerGramHemoglobin_CODE = "/g{HGB}";
	public static final String PerGramTotalNitrogen_CODE = "/g{tot`nit}";
	public static final String PerGramTotalProtein_CODE = "/g{tot`prot}";
	public static final String PerGramWetTissue_CODE = "/g{wet`tis}";
	public static final String PerHour_CODE = "/h";
	public static final String PerKiloGram_CODE = "/kg";
	public static final String PerKiloGramBodyWeight_CODE = "/kg{body`wt}";
	public static final String PerLiter_CODE = "/L";
	public static final String PerMicroLiter_CODE = "/uL";
	public static final String PerMilliGram_CODE = "/mg";
	public static final String PerMilliLiter_CODE = "/mL";
	public static final String PerMillion_CODE = "/10*6";
	public static final String PerMinute_CODE = "/min";
	public static final String PerSecond_CODE = "/s";
	public static final String PerSquareMeter_CODE = "/m2";
	public static final String PerTenGiga_CODE = "/10*10";
	public static final String PerTotalCount_CODE = "/{tot}";
	public static final String PerTrillion_CODE = "/10*12";
	public static final String PerTrillionRedBloodCells_CODE = "/10*12{rbc}";
	public static final String pH_CODE = "[pH]";
	public static final String PicoGram_CODE = "pg";
	public static final String PicoGrams_CODE = "pg";
	public static final String PicoGramsPerDeciLiter_CODE = "pg/dL";
	public static final String PicoGramsPerLiter_CODE = "pg/L";
	public static final String PicoGramsPerMilliLiter_CODE = "pg/mL";
	public static final String PicoGramsPerMilliMeter_CODE = "pg/mm";
	public static final String PicoLiter_CODE = "pL";
	public static final String PicoMeter_CODE = "pm";
	public static final String PicoMole_CODE = "pmol";
	public static final String PicoMolesPerDeciLiter_CODE = "pmol/dL";
	public static final String PicoMolesPerLiter_CODE = "pmol/L";
	public static final String PicoMolesPerMicroMole_CODE = "pmol/umol";
	public static final String PicoMolesPerMilliLiter_CODE = "pmol/mL";
	public static final String PicoSecond_CODE = "ps";
	public static final String Pint_CODE = "[pt_us]";
	public static final String Pound_CODE = "[lb_av]";
	public static final String Quart_CODE = "[qt_us]";
	public static final String RedBloodCellsPerMicroLiter_CODE = "{rbc}/uL";
	public static final String RelativePercent_CODE = "{Relative}%";
	public static final String Second_CODE = "s";
	public static final String SpermatozoaPerMilliLiter_CODE = "{Spermatozoa}/mL";
	public static final String SquareCentiMeter_CODE = "cm2";
	public static final String SquareFeet_CODE = "[sft_i]";
	public static final String SquareInch_CODE = "[sin_i]";
	public static final String SquareMeter_CODE = "m2";
	public static final String SquareMilliMeter_CODE = "mm2";
	public static final String SquareYard_CODE = "[syd_i]";
	public static final String StatuteMile_CODE = "[mi_i]";
	public static final String TenToEighth_CODE = "10*8";
	public static final String Thousand_CODE = "10*3";
	public static final String ThousandCopiesPerMilliLiter_CODE = "10*3{Copies}/mL";
	public static final String ThousandPerLiter_CODE = "10*3/L";
	public static final String ThousandPerMilliLiter_CODE = "10*3/mL";
	public static final String ThousandRedBloodCells_CODE = "10*3.{RBC}";
	public static final String ThousandsPerMicroLiter_CODE = "10*3/uL";
	public static final String Ton_CODE = "[ston_av]";
	public static final String TrillionPerLiter_CODE = "10*12/L";
	public static final String TroyOunce_CODE = "[oz_tr]";
	public static final String UnitsPerGram_CODE = "U/g";
	public static final String UnitsPerGramCreatinine_CODE = "U/g{Cre}";
	public static final String UnitsPerGramHemoglobin_CODE = "U/g{Hgb}";
	public static final String UnitsPerLiter_CODE = "U/L";
	public static final String VolumePercent_CODE = "%{vol}";
	public static final String Week_CODE = "wk";

	public static final String Yard_CODE = "[yd_i]";

	public static final String Year_CODE = "a";

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
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
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