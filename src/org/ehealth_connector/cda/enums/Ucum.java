package org.ehealth_connector.cda.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">UCUM - Unified Code for Units of Measure</div>
 *<div class="fr">UCUM - Unified Code for Units of Measure</div>
 */
public enum Ucum {

	/**
	 * <div class="en">Descriptive Name</div>
	 */
	Descriptive_Name("Code", "Descriptive Name"),
	/**
	 * <div class="en">Percent [Most Common Healthcare Units]</div>
	 */
	Percent_Most_Common_Healthcare_Units("%",
			"Percent [Most Common Healthcare Units]"),
	/**
	 * <div class="en">PerMicroLiter [Most Common Healthcare Units]</div>
	 */
	PerMicroLiter_Most_Common_Healthcare_Units("/uL",
			"PerMicroLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">InternationalUnitsPerLiter [Most Common Healthcare
	 * Units]</div>
	 */
	InternationalUnitsPerLiter_Most_Common_Healthcare_Units("[iU]/L",
			"InternationalUnitsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">ThousandsPerMicroLiter [Most Common Healthcare
	 * Units]</div>
	 */
	ThousandsPerMicroLiter_Most_Common_Healthcare_Units("10*3/uL",
			"ThousandsPerMicroLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MillionsPerMicroLiter [Most Common Healthcare
	 * Units]</div>
	 */
	MillionsPerMicroLiter_Most_Common_Healthcare_Units("10*6/uL",
			"MillionsPerMicroLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">FemtoLiter [Most Common Healthcare Units]</div>
	 */
	FemtoLiter_Most_Common_Healthcare_Units("fL",
			"FemtoLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">GramsPerDeciLiter [Most Common Healthcare Units]</div>
	 */
	GramsPerDeciLiter_Most_Common_Healthcare_Units("g/dL",
			"GramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">GramsPerLiter [Most Common Healthcare Units]</div>
	 */
	GramsPerLiter_Most_Common_Healthcare_Units("g/L",
			"GramsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">GramsPerMilliLiter [Most Common Healthcare Units]</div>
	 */
	GramsPerMilliLiter_Most_Common_Healthcare_Units("g/mL",
			"GramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">KiloPascal [Most Common Healthcare Units]</div>
	 */
	KiloPascal_Most_Common_Healthcare_Units("kPa",
			"KiloPascal [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MilliInternationalUnitsPerMilliLiter [Most Common
	 * Healthcare Units]</div>
	 */
	MilliInternationalUnitsPerMilliLiter_Most_Common_Healthcare_Units(
			"m[iU]/mL",
			"MilliInternationalUnitsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MilliEquivalentsPerLiter [Most Common Healthcare
	 * Units]</div>
	 */
	MilliEquivalentsPerLiter_Most_Common_Healthcare_Units("meq/L",
			"MilliEquivalentsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MilliGramsPerDeciLiter [Most Common Healthcare
	 * Units]</div>
	 */
	MilliGramsPerDeciLiter_Most_Common_Healthcare_Units("mg/dL",
			"MilliGramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MilliMetersOfMercury [Most Common Healthcare Units]</div>
	 */
	MilliMetersOfMercury_Most_Common_Healthcare_Units("mm[Hg]",
			"MilliMetersOfMercury [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MilliMolesPerKiloGram [Most Common Healthcare
	 * Units]</div>
	 */
	MilliMolesPerKiloGram_Most_Common_Healthcare_Units("mmol/kg",
			"MilliMolesPerKiloGram [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MilliMolesPerLiter [Most Common Healthcare Units]</div>
	 */
	MilliMolesPerLiter_Most_Common_Healthcare_Units("mmol/L",
			"MilliMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MilliOsmolesPerKiloGram [Most Common Healthcare
	 * Units]</div>
	 */
	MilliOsmolesPerKiloGram_Most_Common_Healthcare_Units("mosm/kg",
			"MilliOsmolesPerKiloGram [Most Common Healthcare Units]"),
	/**
	 * <div class="en">NanoGramsPerMilliLiter [Most Common Healthcare
	 * Units]</div>
	 */
	NanoGramsPerMilliLiter_Most_Common_Healthcare_Units("ng/mL",
			"NanoGramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">NanoMolesPerLiter [Most Common Healthcare Units]</div>
	 */
	NanoMolesPerLiter_Most_Common_Healthcare_Units("nmol/L",
			"NanoMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">PicoGrams [Most Common Healthcare Units]</div>
	 */
	PicoGrams_Most_Common_Healthcare_Units("pg",
			"PicoGrams [Most Common Healthcare Units]"),
	/**
	 * <div class="en">PicoGramsPerMilliLiter [Most Common Healthcare
	 * Units]</div>
	 */
	PicoGramsPerMilliLiter_Most_Common_Healthcare_Units("pg/mL",
			"PicoGramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">PicoMolesPerLiter [Most Common Healthcare Units]</div>
	 */
	PicoMolesPerLiter_Most_Common_Healthcare_Units("pmol/L",
			"PicoMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">UnitsPerLiter [Most Common Healthcare Units]</div>
	 */
	UnitsPerLiter_Most_Common_Healthcare_Units("U/L",
			"UnitsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MicroInternationalUnitsPerMilliLiter [Most Common
	 * Healthcare Units]</div>
	 */
	MicroInternationalUnitsPerMilliLiter_Most_Common_Healthcare_Units(
			"u[iU]/mL",
			"MicroInternationalUnitsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MicroGramsPerDeciLiter [Most Common Healthcare
	 * Units]</div>
	 */
	MicroGramsPerDeciLiter_Most_Common_Healthcare_Units("ug/dL",
			"MicroGramsPerDeciLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MicroGramsPerLiter [Most Common Healthcare Units]</div>
	 */
	MicroGramsPerLiter_Most_Common_Healthcare_Units("ug/L",
			"MicroGramsPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MicroGramsPerMilliLiter [Most Common Healthcare
	 * Units]</div>
	 */
	MicroGramsPerMilliLiter_Most_Common_Healthcare_Units("ug/mL",
			"MicroGramsPerMilliLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">MicroMolesPerLiter [Most Common Healthcare Units]</div>
	 */
	MicroMolesPerLiter_Most_Common_Healthcare_Units("umol/L",
			"MicroMolesPerLiter [Most Common Healthcare Units]"),
	/**
	 * <div class="en">Log10 [Unity]</div>
	 */
	Log10_Unity("[lg]", "Log10 [Unity]"),
	/**
	 * <div class="en">MillionPerSpecimen [Unity]</div>
	 */
	MillionPerSpecimen_Unity("10*6/{Specimen}", "MillionPerSpecimen [Unity]"),
	/**
	 * <div class="en">PerTotalCount [Unity]</div>
	 */
	PerTotalCount_Unity("/{tot}", "PerTotalCount [Unity]"),
	/**
	 * <div class="en">Thousand [Unity]</div>
	 */
	Thousand_Unity("10*3", "Thousand [Unity]"),
	/**
	 * <div class="en">ThousandRedBloodCells [Unity]</div>
	 */
	ThousandRedBloodCells_Unity("10*3.{RBC}", "ThousandRedBloodCells [Unity]"),
	/**
	 * <div class="en">OneHundredThousand [Unity]</div>
	 */
	OneHundredThousand_Unity("10*5", "OneHundredThousand [Unity]"),
	/**
	 * <div class="en">Million [Unity]</div>
	 */
	Million_Unity("10*6", "Million [Unity]"),
	/**
	 * <div class="en">TenToEighth [Unity]</div>
	 */
	TenToEighth_Unity("10*8", "TenToEighth [Unity]"),
	/**
	 * <div class="en">Percent [General Fraction Unit]</div>
	 */
	Percent_General_Fraction_Unit("%", "Percent [General Fraction Unit]"),
	/**
	 * <div class="en">RelativePercent [General Fraction Unit]</div>
	 */
	RelativePercent_General_Fraction_Unit("{Relative}%",
			"RelativePercent [General Fraction Unit]"),
	/**
	 * <div class="en">PercentTotal [General Fraction Unit]</div>
	 */
	PercentTotal_General_Fraction_Unit("%{Total}",
			"PercentTotal [General Fraction Unit]"),
	/**
	 * <div class="en">Percent0to3Hours [General Fraction Unit]</div>
	 */
	Percent0to3Hours_General_Fraction_Unit("%{0to3Hours}",
			"Percent0to3Hours [General Fraction Unit]"),
	/**
	 * <div class="en">PerTenGiga [Number Fraction Units]</div>
	 */
	PerTenGiga_Number_Fraction_Units("/10*10",
			"PerTenGiga [Number Fraction Units]"),
	/**
	 * <div class="en">PerMillion [Number Fraction Units]</div>
	 */
	PerMillion_Number_Fraction_Units("/10*6",
			"PerMillion [Number Fraction Units]"),
	/**
	 * <div class="en">PerBillion [Number Fraction Units]</div>
	 */
	PerBillion_Number_Fraction_Units("/10*9",
			"PerBillion [Number Fraction Units]"),
	/**
	 * <div class="en">PerTrillion [Number Fraction Units]</div>
	 */
	PerTrillion_Number_Fraction_Units("/10*12",
			"PerTrillion [Number Fraction Units]"),
	/**
	 * <div class="en">PercentNormal [Number Fraction Units]</div>
	 */
	PercentNormal_Number_Fraction_Units("%{Normal}",
			"PercentNormal [Number Fraction Units]"),
	/**
	 * <div class="en">PercentSpermMotility [Number Fraction Units]</div>
	 */
	PercentSpermMotility_Number_Fraction_Units("%{SpermMotility}",
			"PercentSpermMotility [Number Fraction Units]"),
	/**
	 * <div class="en">PercentPositive [Number Fraction Units]</div>
	 */
	PercentPositive_Number_Fraction_Units("%{Positive}",
			"PercentPositive [Number Fraction Units]"),
	/**
	 * <div class="en">PercentFetalErythrocytes [Number Fraction Units]</div>
	 */
	PercentFetalErythrocytes_Number_Fraction_Units("%{FetalErythrocytes}",
			"PercentFetalErythrocytes [Number Fraction Units]"),
	/**
	 * <div class="en">PercentOfLymphocytes [Number Fraction Units]</div>
	 */
	PercentOfLymphocytes_Number_Fraction_Units("%{OfLymphocytes}",
			"PercentOfLymphocytes [Number Fraction Units]"),
	/**
	 * <div class="en">PercentofBacteria [Number Fraction Units]</div>
	 */
	PercentofBacteria_Number_Fraction_Units("%{ofBacteria}",
			"PercentofBacteria [Number Fraction Units]"),
	/**
	 * <div class="en">PercentOfWBCs [Number Fraction Units]</div>
	 */
	PercentOfWBCs_Number_Fraction_Units("%{OfWBCs}",
			"PercentOfWBCs [Number Fraction Units]"),
	/**
	 * <div class="en">PercentAbnormal [Number Fraction Units]</div>
	 */
	PercentAbnormal_Number_Fraction_Units("%{Abnormal}",
			"PercentAbnormal [Number Fraction Units]"),
	/**
	 * <div class="en">PercentEosinophilsSeen [Number Fraction Units]</div>
	 */
	PercentEosinophilsSeen_Number_Fraction_Units("%{EosSeen}",
			"PercentEosinophilsSeen [Number Fraction Units]"),
	/**
	 * <div class="en">PercentHemolysis [Number Fraction Units]</div>
	 */
	PercentHemolysis_Number_Fraction_Units("%{Hemolysis}",
			"PercentHemolysis [Number Fraction Units]"),
	/**
	 * <div class="en">PercentBlockade [Number Fraction Units]</div>
	 */
	PercentBlockade_Number_Fraction_Units("%{Blockade}",
			"PercentBlockade [Number Fraction Units]"),
	/**
	 * <div class="en">PercentPer100WBC [Number Fraction Units]</div>
	 */
	PercentPer100WBC_Number_Fraction_Units("%/100{WBC}",
			"PercentPer100WBC [Number Fraction Units]"),
	/**
	 * <div class="en">PercentBinding [Mass Or Substance Fraction Units]</div>
	 */
	PercentBinding_Mass_Or_Substance_Fraction_Units("%{Binding}",
			"PercentBinding [Mass Or Substance Fraction Units]"),
	/**
	 * <div class="en">PercentTotalProtein [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PercentTotalProtein_Mass_Or_Substance_Fraction_Units("%{TotalProtein}",
			"PercentTotalProtein [Mass Or Substance Fraction Units]"),
	/**
	 * <div class="en">PercentBound [Mass Or Substance Fraction Units]</div>
	 */
	PercentBound_Mass_Or_Substance_Fraction_Units("%{Bound}",
			"PercentBound [Mass Or Substance Fraction Units]"),
	/**
	 * <div class="en">PercentHemoglobin [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PercentHemoglobin_Mass_Or_Substance_Fraction_Units("%{Hemoglobin}",
			"PercentHemoglobin [Mass Or Substance Fraction Units]"),
	/**
	 * <div class="en">PercentHemoglobinSaturation [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PercentHemoglobinSaturation_Mass_Or_Substance_Fraction_Units(
			"%{HemoglobinSaturation}",
			"PercentHemoglobinSaturation [Mass Or Substance Fraction Units]"),
	/**
	 * <div class="en">PercentCarboxyhemoglobin [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PercentCarboxyhemoglobin_Mass_Or_Substance_Fraction_Units(
			"%{Carboxyhemoglobin}",
			"PercentCarboxyhemoglobin [Mass Or Substance Fraction Units]"),
	/**
	 * <div class="en">PercentHemoglobinA1C [Mass Or Substance Fraction
	 * Units]</div>
	 */
	PercentHemoglobinA1C_Mass_Or_Substance_Fraction_Units("%{HemoglobinA1C}",
			"PercentHemoglobinA1C [Mass Or Substance Fraction Units]"),
	/**
	 * <div class="en">PercentExcretion [Mass Or Substance Rate Fraction
	 * Units]</div>
	 */
	PercentExcretion_Mass_Or_Substance_Rate_Fraction_Units("%{Excretion}",
			"PercentExcretion [Mass Or Substance Rate Fraction Units]"),
	/**
	 * <div class="en">PercentUptake [Mass Or Substance Rate Fraction
	 * Units]</div>
	 */
	PercentUptake_Mass_Or_Substance_Rate_Fraction_Units("%{Uptake}",
			"PercentUptake [Mass Or Substance Rate Fraction Units]"),
	/**
	 * <div class="en">MicroGramsPerNanoGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MicroGramsPerNanoGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ug/ng",
			"MicroGramsPerNanoGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">NanoGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	NanoGramsPerMilliGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ng/mg",
			"NanoGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">NanoGramsPerMilliGramProtein [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units]</div>
	 */
	NanoGramsPerMilliGramProtein_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ng/mg{Protein}",
			"NanoGramsPerMilliGramProtein [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MicroGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MicroGramsPerMilliGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ug/mg",
			"MicroGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MicroGramsPerMilliGramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units]</div>
	 */
	MicroGramsPerMilliGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ug/mg{Cre}",
			"MicroGramsPerMilliGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MilliGramsPerMilliGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MilliGramsPerMilliGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"mg/mg",
			"MilliGramsPerMilliGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MilligramsPerMilligramCreatinine [Mass Ratio Or Mass
	 * Fraction Or Mass Content Units]</div>
	 */
	MilligramsPerMilligramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"mg/mg{Cre}",
			"MilligramsPerMilligramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">NanoGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	NanoGramsPerGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units("ng/g",
			"NanoGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">NanoGramsPerGramCreatinine [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units]</div>
	 */
	NanoGramsPerGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ng/g{Cre}",
			"NanoGramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MicroGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	MicroGramsPerGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units("ug/g",
			"MicroGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MicroGramPer100Gram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	MicroGramPer100Gram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ug/[100]g",
			"MicroGramPer100Gram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MicroGramPerGramDryWeight [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MicroGramPerGramDryWeight_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ug/g{DryWeight}",
			"MicroGramPerGramDryWeight [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MicroGramPerGramCreatinine [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units]</div>
	 */
	MicroGramPerGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ug/g{Cre}",
			"MicroGramPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MicroGramsPerGramHemoglobin [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units]</div>
	 */
	MicroGramsPerGramHemoglobin_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ug/g{Hgb}",
			"MicroGramsPerGramHemoglobin [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MilliGramsPerGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	MilliGramsPerGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units("mg/g",
			"MilliGramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MilliGramPerGramCreatinine [Mass Ratio Or Mass Fraction
	 * Or Mass Content Units]</div>
	 */
	MilliGramPerGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"mg/g{Cre}",
			"MilliGramPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">GramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content
	 * Units]</div>
	 */
	GramsPerGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units("g/g",
			"GramsPerGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">NanoGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	NanoGramsPerKiloGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ng/kg",
			"NanoGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MicroGramsPerKiloGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MicroGramsPerKiloGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"ug/kg",
			"MicroGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">MilliGramsPerKiloGram [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	MilliGramsPerKiloGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"mg/kg",
			"MilliGramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">GramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	GramsPerKiloGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units("g/kg",
			"GramsPerKiloGram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">GramsPer100Gram [Mass Ratio Or Mass Fraction Or Mass
	 * Content Units]</div>
	 */
	GramsPer100Gram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"g/[100]g",
			"GramsPer100Gram [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">GramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or
	 * Mass Content Units]</div>
	 */
	GramsPerGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units(
			"g/g{Cre}",
			"GramsPerGramCreatinine [Mass Ratio Or Mass Fraction Or Mass Content Units]"),
	/**
	 * <div class="en">PicoMolesPerMicroMole [Substance Ratio Or Substance
	 * Fraction Units]</div>
	 */
	PicoMolesPerMicroMole_Substance_Ratio_Or_Substance_Fraction_Units(
			"pmol/umol",
			"PicoMolesPerMicroMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">NanoMolesPerMilliMole [Substance Ratio Or Substance
	 * Fraction Units]</div>
	 */
	NanoMolesPerMilliMole_Substance_Ratio_Or_Substance_Fraction_Units(
			"nmol/mmol",
			"NanoMolesPerMilliMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">NanoMolesPerMilliMoleCreatinine [Substance Ratio Or
	 * Substance Fraction Units]</div>
	 */
	NanoMolesPerMilliMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units(
			"nmol/mmol{Cre}",
			"NanoMolesPerMilliMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">NanoMolesPerMole [Substance Ratio Or Substance Fraction
	 * Units]</div>
	 */
	NanoMolesPerMole_Substance_Ratio_Or_Substance_Fraction_Units("nmol/mol",
			"NanoMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">MicroMolesPerMole [Substance Ratio Or Substance Fraction
	 * Units]</div>
	 */
	MicroMolesPerMole_Substance_Ratio_Or_Substance_Fraction_Units("umol/mol",
			"MicroMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">MilliMolesPerMole [Substance Ratio Or Substance Fraction
	 * Units]</div>
	 */
	MilliMolesPerMole_Substance_Ratio_Or_Substance_Fraction_Units("mmol/mol",
			"MilliMolesPerMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">MilliMolesPerMoleCreatinine [Substance Ratio Or Substance
	 * Fraction Units]</div>
	 */
	MilliMolesPerMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units(
			"mmol/mol{Cre}",
			"MilliMolesPerMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">MicroMolesPerMoleCreatinine [Substance Ratio Or Substance
	 * Fraction Units]</div>
	 */
	MicroMolesPerMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units(
			"umol/mol{Cre}",
			"MicroMolesPerMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">EquivalentsPerMicroMole [Substance Ratio Or Substance
	 * Fraction Units]</div>
	 */
	EquivalentsPerMicroMole_Substance_Ratio_Or_Substance_Fraction_Units(
			"eq/umol",
			"EquivalentsPerMicroMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">EquivalentsPerMilliMole [Substance Ratio Or Substance
	 * Fraction Units]</div>
	 */
	EquivalentsPerMilliMole_Substance_Ratio_Or_Substance_Fraction_Units(
			"eq/mmol",
			"EquivalentsPerMilliMole [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">BoneCollagenEquivalentsPerMilliMoleCreatinine [Substance
	 * Ratio Or Substance Fraction Units]</div>
	 */
	BoneCollagenEquivalentsPerMilliMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units(
			"{BoneCollagen}eq/mmol{Cre}",
			"BoneCollagenEquivalentsPerMilliMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">BoneCollagenEquivalentsPerMicroMoleCreatinine [Substance
	 * Ratio Or Substance Fraction Units]</div>
	 */
	BoneCollagenEquivalentsPerMicroMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units(
			"{BoneCollagen}eq/umol{Cre}",
			"BoneCollagenEquivalentsPerMicroMoleCreatinine [Substance Ratio Or Substance Fraction Units]"),
	/**
	 * <div class="en">VolumePercent [Volume Fraction Units]</div>
	 */
	VolumePercent_Volume_Fraction_Units("%{vol}",
			"VolumePercent [Volume Fraction Units]"),
	/**
	 * <div class="en">PercentOxygen [Volume Fraction Units]</div>
	 */
	PercentOxygen_Volume_Fraction_Units("%{Oxygen}",
			"PercentOxygen [Volume Fraction Units]"),
	/**
	 * <div class="en">MilliLitersPerDeciLiter [Volume Fraction Units]</div>
	 */
	MilliLitersPerDeciLiter_Volume_Fraction_Units("mL/dL",
			"MilliLitersPerDeciLiter [Volume Fraction Units]"),
	/**
	 * <div class="en">PercentNormalPooledPlasma [Catalytic Fraction Or
	 * Arbitrary Fraction Units]</div>
	 */
	PercentNormalPooledPlasma_Catalytic_Fraction_Or_Arbitrary_Fraction_Units(
			"%{NormalPooledPlasma}",
			"PercentNormalPooledPlasma [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class="en">PercentActivity [Catalytic Fraction Or Arbitrary Fraction
	 * Units]</div>
	 */
	PercentActivity_Catalytic_Fraction_Or_Arbitrary_Fraction_Units(
			"%{Activity}",
			"PercentActivity [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class="en">PercentBasalActivity [Catalytic Fraction Or Arbitrary
	 * Fraction Units]</div>
	 */
	PercentBasalActivity_Catalytic_Fraction_Or_Arbitrary_Fraction_Units(
			"%{BasalActivity}",
			"PercentBasalActivity [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class="en">PercentInhibition [Catalytic Fraction Or Arbitrary
	 * Fraction Units]</div>
	 */
	PercentInhibition_Catalytic_Fraction_Or_Arbitrary_Fraction_Units(
			"%{Inhibition}",
			"PercentInhibition [Catalytic Fraction Or Arbitrary Fraction Units]"),
	/**
	 * <div class="en">PerEntity [Entitic Number Units]</div>
	 */
	PerEntity_Entitic_Number_Units("/{Entity}",
			"PerEntity [Entitic Number Units]"),
	/**
	 * <div class="en">Per100WBC [Entitic Number Units]</div>
	 */
	Per100WBC_Entitic_Number_Units("/100{WBC}",
			"Per100WBC [Entitic Number Units]"),
	/**
	 * <div class="en">Per100 [Entitic Number Units]</div>
	 */
	Per100_Entitic_Number_Units("/100", "Per100 [Entitic Number Units]"),
	/**
	 * <div class="en">Per100Spermatozoa [Entitic Number Units]</div>
	 */
	Per100Spermatozoa_Entitic_Number_Units("/100{Spermatozoa}",
			"Per100Spermatozoa [Entitic Number Units]"),
	/**
	 * <div class="en">PerTrillionRedBloodCells [Entitic Number Units]</div>
	 */
	PerTrillionRedBloodCells_Entitic_Number_Units("/10*12{rbc}",
			"PerTrillionRedBloodCells [Entitic Number Units]"),
	/**
	 * <div class="en">DegreesOfArc [Plane Angle Units]</div>
	 */
	DegreesOfArc_Plane_Angle_Units("deg", "DegreesOfArc [Plane Angle Units]"),
	/**
	 * <div class="en">PerArbitraryUnit [Arbitrary Number Units]</div>
	 */
	PerArbitraryUnit_Arbitrary_Number_Units("/[arb`U]",
			"PerArbitraryUnit [Arbitrary Number Units]"),
	/**
	 * <div class="en">MicroInternationalUnit [Arbitrary Units]</div>
	 */
	MicroInternationalUnit_Arbitrary_Units("u[iU]",
			"MicroInternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en">InternationalUnit [Arbitrary Units]</div>
	 */
	InternationalUnit_Arbitrary_Units("[iU]",
			"InternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en">MillionInternationalUnit [Arbitrary Units]</div>
	 */
	MillionInternationalUnit_Arbitrary_Units("10*6.[iU]",
			"MillionInternationalUnit [Arbitrary Units]"),
	/**
	 * <div class="en">Inch [English Length Units]</div>
	 */
	Inch_English_Length_Units("[in_i]", "Inch [English Length Units]"),
	/**
	 * <div class="en">Feet [English Length Units]</div>
	 */
	Feet_English_Length_Units("[ft_i]", "Feet [English Length Units]"),
	/**
	 * <div class="en">Yard [English Length Units]</div>
	 */
	Yard_English_Length_Units("[yd_i]", "Yard [English Length Units]"),
	/**
	 * <div class="en">Fathom [English Length Units]</div>
	 */
	Fathom_English_Length_Units("[fth_i]", "Fathom [English Length Units]"),
	/**
	 * <div class="en">StatuteMile [English Length Units]</div>
	 */
	StatuteMile_English_Length_Units("[mi_i]",
			"StatuteMile [English Length Units]"),
	/**
	 * <div class="en">NauticalMile [English Length Units]</div>
	 */
	NauticalMile_English_Length_Units("[nmi_i]",
			"NauticalMile [English Length Units]"),
	/**
	 * <div class="en">French [English Length Units]</div>
	 */
	French_English_Length_Units("[Ch]", "French [English Length Units]"),
	/**
	 * <div class="en">FemtoMeter [SI Length Units]</div>
	 */
	FemtoMeter_SI_Length_Units("fm", "FemtoMeter [SI Length Units]"),
	/**
	 * <div class="en">PicoMeter [SI Length Units]</div>
	 */
	PicoMeter_SI_Length_Units("pm", "PicoMeter [SI Length Units]"),
	/**
	 * <div class="en">NanoMeter [SI Length Units]</div>
	 */
	NanoMeter_SI_Length_Units("nm", "NanoMeter [SI Length Units]"),
	/**
	 * <div class="en">MicroMeter [SI Length Units]</div>
	 */
	MicroMeter_SI_Length_Units("um", "MicroMeter [SI Length Units]"),
	/**
	 * <div class="en">MilliMeter [SI Length Units]</div>
	 */
	MilliMeter_SI_Length_Units("mm", "MilliMeter [SI Length Units]"),
	/**
	 * <div class="en">CentiMeter [SI Length Units]</div>
	 */
	CentiMeter_SI_Length_Units("cm", "CentiMeter [SI Length Units]"),
	/**
	 * <div class="en">DeciMeter [SI Length Units]</div>
	 */
	DeciMeter_SI_Length_Units("dm", "DeciMeter [SI Length Units]"),
	/**
	 * <div class="en">Meter [SI Length Units]</div>
	 */
	Meter_SI_Length_Units("m", "Meter [SI Length Units]"),
	/**
	 * <div class="en">KiloMeter [SI Length Units]</div>
	 */
	KiloMeter_SI_Length_Units("km", "KiloMeter [SI Length Units]"),
	/**
	 * <div class="en">Grain [English Mass Units]</div>
	 */
	Grain_English_Mass_Units("[gr]", "Grain [English Mass Units]"),
	/**
	 * <div class="en">Ounce [English Mass Units]</div>
	 */
	Ounce_English_Mass_Units("[oz_av]", "Ounce [English Mass Units]"),
	/**
	 * <div class="en">TroyOunce [English Mass Units]</div>
	 */
	TroyOunce_English_Mass_Units("[oz_tr]", "TroyOunce [English Mass Units]"),
	/**
	 * <div class="en">Pound [English Mass Units]</div>
	 */
	Pound_English_Mass_Units("[lb_av]", "Pound [English Mass Units]"),
	/**
	 * <div class="en">Ton [English Mass Units]</div>
	 */
	Ton_English_Mass_Units("[ston_av]", "Ton [English Mass Units]"),
	/**
	 * <div class="en">Dram [English Mass Units]</div>
	 */
	Dram_English_Mass_Units("[dr_av]", "Dram [English Mass Units]"),
	/**
	 * <div class="en">FemtoGram [SI Mass Units]</div>
	 */
	FemtoGram_SI_Mass_Units("fg", "FemtoGram [SI Mass Units]"),
	/**
	 * <div class="en">PicoGram [SI Mass Units]</div>
	 */
	PicoGram_SI_Mass_Units("pg", "PicoGram [SI Mass Units]"),
	/**
	 * <div class="en">NanoGram [SI Mass Units]</div>
	 */
	NanoGram_SI_Mass_Units("ng", "NanoGram [SI Mass Units]"),
	/**
	 * <div class="en">MicroGram [SI Mass Units]</div>
	 */
	MicroGram_SI_Mass_Units("ug", "MicroGram [SI Mass Units]"),
	/**
	 * <div class="en">MicroGramsPerTotalVolume [SI Mass Units]</div>
	 */
	MicroGramsPerTotalVolume_SI_Mass_Units("ug/{TotalVolume}",
			"MicroGramsPerTotalVolume [SI Mass Units]"),
	/**
	 * <div class="en">MicroGramsPerSpecimen [SI Mass Units]</div>
	 */
	MicroGramsPerSpecimen_SI_Mass_Units("ug/{Specimen}",
			"MicroGramsPerSpecimen [SI Mass Units]"),
	/**
	 * <div class="en">MilliGram [SI Mass Units]</div>
	 */
	MilliGram_SI_Mass_Units("mg", "MilliGram [SI Mass Units]"),
	/**
	 * <div class="en">MilliGramsPerVolume [SI Mass Units]</div>
	 */
	MilliGramsPerVolume_SI_Mass_Units("mg/{Volume}",
			"MilliGramsPerVolume [SI Mass Units]"),
	/**
	 * <div class="en">MilliGramPerTotalVolume [SI Mass Units]</div>
	 */
	MilliGramPerTotalVolume_SI_Mass_Units("mg/{TotalVolume}",
			"MilliGramPerTotalVolume [SI Mass Units]"),
	/**
	 * <div class="en">Gram [SI Mass Units]</div>
	 */
	Gram_SI_Mass_Units("g", "Gram [SI Mass Units]"),
	/**
	 * <div class="en">GramsPerTotalWeight [SI Mass Units]</div>
	 */
	GramsPerTotalWeight_SI_Mass_Units("g/{TotalWeight}",
			"GramsPerTotalWeight [SI Mass Units]"),
	/**
	 * <div class="en">DeciGram [SI Mass Units]</div>
	 */
	DeciGram_SI_Mass_Units("dg", "DeciGram [SI Mass Units]"),
	/**
	 * <div class="en">CentiGram [SI Mass Units]</div>
	 */
	CentiGram_SI_Mass_Units("cg", "CentiGram [SI Mass Units]"),
	/**
	 * <div class="en">KiloGram [SI Mass Units]</div>
	 */
	KiloGram_SI_Mass_Units("kg", "KiloGram [SI Mass Units]"),
	/**
	 * <div class="en">MetricTon [SI Mass Units]</div>
	 */
	MetricTon_SI_Mass_Units("t", "MetricTon [SI Mass Units]"),
	/**
	 * <div class="en">PicoGramsPerMilliMeter [Lineic Mass Units]</div>
	 */
	PicoGramsPerMilliMeter_Lineic_Mass_Units("pg/mm",
			"PicoGramsPerMilliMeter [Lineic Mass Units]"),
	/**
	 * <div class="en">DegreesKelvin [Temperature Units]</div>
	 */
	DegreesKelvin_Temperature_Units("K", "DegreesKelvin [Temperature Units]"),
	/**
	 * <div class="en">DegreesCelsius [Temperature Units]</div>
	 */
	DegreesCelsius_Temperature_Units("Cel",
			"DegreesCelsius [Temperature Units]"),
	/**
	 * <div class="en">DegreesFahrenheit [Temperature Units]</div>
	 */
	DegreesFahrenheit_Temperature_Units("[degF]",
			"DegreesFahrenheit [Temperature Units]"),
	/**
	 * <div class="en">KelvinPerWatt [Thermal Resistance Units]</div>
	 */
	KelvinPerWatt_Thermal_Resistance_Units("K/W",
			"KelvinPerWatt [Thermal Resistance Units]"),
	/**
	 * <div class="en">PicoSecond [Time Units]</div>
	 */
	PicoSecond_Time_Units("ps", "PicoSecond [Time Units]"),
	/**
	 * <div class="en">NanoSecond [Time Units]</div>
	 */
	NanoSecond_Time_Units("ns", "NanoSecond [Time Units]"),
	/**
	 * <div class="en">MicroSecond [Time Units]</div>
	 */
	MicroSecond_Time_Units("us", "MicroSecond [Time Units]"),
	/**
	 * <div class="en">MilliSecond [Time Units]</div>
	 */
	MilliSecond_Time_Units("ms", "MilliSecond [Time Units]"),
	/**
	 * <div class="en">Second [Time Units]</div>
	 */
	Second_Time_Units("s", "Second [Time Units]"),
	/**
	 * <div class="en">KiloSecond [Time Units]</div>
	 */
	KiloSecond_Time_Units("ks", "KiloSecond [Time Units]"),
	/**
	 * <div class="en">Megasecond [Time Units]</div>
	 */
	Megasecond_Time_Units("Ms", "Megasecond [Time Units]"),
	/**
	 * <div class="en">Minute [Time Units]</div>
	 */
	Minute_Time_Units("min", "Minute [Time Units]"),
	/**
	 * <div class="en">Hour [Time Units]</div>
	 */
	Hour_Time_Units("h", "Hour [Time Units]"),
	/**
	 * <div class="en">Day [Time Units]</div>
	 */
	Day_Time_Units("d", "Day [Time Units]"),
	/**
	 * <div class="en">Week [Time Units]</div>
	 */
	Week_Time_Units("wk", "Week [Time Units]"),
	/**
	 * <div class="en">Month [Time Units]</div>
	 */
	Month_Time_Units("mo", "Month [Time Units]"),
	/**
	 * <div class="en">Year [Time Units]</div>
	 */
	Year_Time_Units("a", "Year [Time Units]"),
	/**
	 * <div class="en">Equivalent [Substance Units]</div>
	 */
	Equivalent_Substance_Units("eq", "Equivalent [Substance Units]"),
	/**
	 * <div class="en">MicroEquivalent [Substance Units]</div>
	 */
	MicroEquivalent_Substance_Units("ueq", "MicroEquivalent [Substance Units]"),
	/**
	 * <div class="en">MilliEquivalent [Substance Units]</div>
	 */
	MilliEquivalent_Substance_Units("meq", "MilliEquivalent [Substance Units]"),
	/**
	 * <div class="en">MilliEquivalentsPerSpecimen [Substance Units]</div>
	 */
	MilliEquivalentsPerSpecimen_Substance_Units("meq/{Specimen}",
			"MilliEquivalentsPerSpecimen [Substance Units]"),
	/**
	 * <div class="en">Mole [Substance Units]</div>
	 */
	Mole_Substance_Units("mol", "Mole [Substance Units]"),
	/**
	 * <div class="en">MilliMole [Substance Units]</div>
	 */
	MilliMole_Substance_Units("mmol", "MilliMole [Substance Units]"),
	/**
	 * <div class="en">MilliMolesPerTotalVolume [Substance Units]</div>
	 */
	MilliMolesPerTotalVolume_Substance_Units("mmol/{TotalVolume}",
			"MilliMolesPerTotalVolume [Substance Units]"),
	/**
	 * <div class="en">Femtomole [Substance Units]</div>
	 */
	Femtomole_Substance_Units("fmol", "Femtomole [Substance Units]"),
	/**
	 * <div class="en">PicoMole [Substance Units]</div>
	 */
	PicoMole_Substance_Units("pmol", "PicoMole [Substance Units]"),
	/**
	 * <div class="en">MicroMole [Substance Units]</div>
	 */
	MicroMole_Substance_Units("umol", "MicroMole [Substance Units]"),
	/**
	 * <div class="en">NanoMole [Substance Units]</div>
	 */
	NanoMole_Substance_Units("nmol", "NanoMole [Substance Units]"),
	/**
	 * <div class="en">MilliOsmole [Substance Units]</div>
	 */
	MilliOsmole_Substance_Units("mosm", "MilliOsmole [Substance Units]"),
	/**
	 * <div class="en">MilliEquivalentsPerSquareMeter [Areic Substance
	 * Units]</div>
	 */
	MilliEquivalentsPerSquareMeter_Areic_Substance_Units("meq/m2",
			"MilliEquivalentsPerSquareMeter [Areic Substance Units]"),
	/**
	 * <div class="en">MilliMolesPerSquareMeter [Areic Substance Units]</div>
	 */
	MilliMolesPerSquareMeter_Areic_Substance_Units("mmol/m2",
			"MilliMolesPerSquareMeter [Areic Substance Units]"),
	/**
	 * <div class="en">SquareInch [English Area Units]</div>
	 */
	SquareInch_English_Area_Units("[sin_i]", "SquareInch [English Area Units]"),
	/**
	 * <div class="en">SquareFeet [English Area Units]</div>
	 */
	SquareFeet_English_Area_Units("[sft_i]", "SquareFeet [English Area Units]"),
	/**
	 * <div class="en">SquareYard [English Area Units]</div>
	 */
	SquareYard_English_Area_Units("[syd_i]", "SquareYard [English Area Units]"),
	/**
	 * <div class="en">SquareMilliMeter [SI Area Units]</div>
	 */
	SquareMilliMeter_SI_Area_Units("mm2", "SquareMilliMeter [SI Area Units]"),
	/**
	 * <div class="en">SquareCentiMeter [SI Area Units]</div>
	 */
	SquareCentiMeter_SI_Area_Units("cm2", "SquareCentiMeter [SI Area Units]"),
	/**
	 * <div class="en">SquareMeter [SI Area Units]</div>
	 */
	SquareMeter_SI_Area_Units("m2", "SquareMeter [SI Area Units]"),
	/**
	 * <div class="en">FluidOunce [English Volume Units]</div>
	 */
	FluidOunce_English_Volume_Units("[foz_us]",
			"FluidOunce [English Volume Units]"),
	/**
	 * <div class="en">CubicInch [English Volume Units]</div>
	 */
	CubicInch_English_Volume_Units("[cin_i]",
			"CubicInch [English Volume Units]"),
	/**
	 * <div class="en">Cup [English Volume Units]</div>
	 */
	Cup_English_Volume_Units("[cup_us]", "Cup [English Volume Units]"),
	/**
	 * <div class="en">Pint [English Volume Units]</div>
	 */
	Pint_English_Volume_Units("[pt_us]", "Pint [English Volume Units]"),
	/**
	 * <div class="en">Quart [English Volume Units]</div>
	 */
	Quart_English_Volume_Units("[qt_us]", "Quart [English Volume Units]"),
	/**
	 * <div class="en">Gallon [English Volume Units]</div>
	 */
	Gallon_English_Volume_Units("[gal_us]", "Gallon [English Volume Units]"),
	/**
	 * <div class="en">FluidDram [English Volume Units]</div>
	 */
	FluidDram_English_Volume_Units("[fdr_us]",
			"FluidDram [English Volume Units]"),
	/**
	 * <div class="en">FemtoLiter [SI Volume Units]</div>
	 */
	FemtoLiter_SI_Volume_Units("fL", "FemtoLiter [SI Volume Units]"),
	/**
	 * <div class="en">PicoLiter [SI Volume Units]</div>
	 */
	PicoLiter_SI_Volume_Units("pL", "PicoLiter [SI Volume Units]"),
	/**
	 * <div class="en">NanoLiter [SI Volume Units]</div>
	 */
	NanoLiter_SI_Volume_Units("nL", "NanoLiter [SI Volume Units]"),
	/**
	 * <div class="en">MicroLiter [SI Volume Units]</div>
	 */
	MicroLiter_SI_Volume_Units("uL", "MicroLiter [SI Volume Units]"),
	/**
	 * <div class="en">MilliLiter [SI Volume Units]</div>
	 */
	MilliLiter_SI_Volume_Units("mL", "MilliLiter [SI Volume Units]"),
	/**
	 * <div class="en">MilliLitersPerHeartbeat [SI Volume Units]</div>
	 */
	MilliLitersPerHeartbeat_SI_Volume_Units("mL/{h`b}",
			"MilliLitersPerHeartbeat [SI Volume Units]"),
	/**
	 * <div class="en">Liter [SI Volume Units]</div>
	 */
	Liter_SI_Volume_Units("L", "Liter [SI Volume Units]"),
	/**
	 * <div class="en">DeciLiter [SI Volume Units]</div>
	 */
	DeciLiter_SI_Volume_Units("dL", "DeciLiter [SI Volume Units]"),
	/**
	 * <div class="en">CentiLiter [SI Volume Units]</div>
	 */
	CentiLiter_SI_Volume_Units("cL", "CentiLiter [SI Volume Units]"),
	/**
	 * <div class="en">KiloLiter [SI Volume Units]</div>
	 */
	KiloLiter_SI_Volume_Units("kL", "KiloLiter [SI Volume Units]"),
	/**
	 * <div class="en">HectoLiter [SI Volume Units]</div>
	 */
	HectoLiter_SI_Volume_Units("hL", "HectoLiter [SI Volume Units]"),
	/**
	 * <div class="en">LiterSquareSecondPerSecond [Volume Duration Units]</div>
	 */
	LiterSquareSecondPerSecond_Volume_Duration_Units("L.s2/s",
			"LiterSquareSecondPerSecond [Volume Duration Units]"),
	/**
	 * <div class="en">PerMilliGram [Number Content Units]</div>
	 */
	PerMilliGram_Number_Content_Units("/mg",
			"PerMilliGram [Number Content Units]"),
	/**
	 * <div class="en">PerGram [Number Content Units]</div>
	 */
	PerGram_Number_Content_Units("/g", "PerGram [Number Content Units]"),
	/**
	 * <div class="en">PerGramCreatinine [Number Content Units]</div>
	 */
	PerGramCreatinine_Number_Content_Units("/g{creat}",
			"PerGramCreatinine [Number Content Units]"),
	/**
	 * <div class="en">PerGramHemoglobin [Number Content Units]</div>
	 */
	PerGramHemoglobin_Number_Content_Units("/g{HGB}",
			"PerGramHemoglobin [Number Content Units]"),
	/**
	 * <div class="en">PerGramTotalNitrogen [Number Content Units]</div>
	 */
	PerGramTotalNitrogen_Number_Content_Units("/g{tot`nit}",
			"PerGramTotalNitrogen [Number Content Units]"),
	/**
	 * <div class="en">PerGramTotalProtein [Number Content Units]</div>
	 */
	PerGramTotalProtein_Number_Content_Units("/g{tot`prot}",
			"PerGramTotalProtein [Number Content Units]"),
	/**
	 * <div class="en">PerGramWetTissue [Number Content Units]</div>
	 */
	PerGramWetTissue_Number_Content_Units("/g{wet`tis}",
			"PerGramWetTissue [Number Content Units]"),
	/**
	 * <div class="en">PerKiloGram [Number Content Units]</div>
	 */
	PerKiloGram_Number_Content_Units("/kg",
			"PerKiloGram [Number Content Units]"),
	/**
	 * <div class="en">PerKiloGramBodyWeight [Number Content Units]</div>
	 */
	PerKiloGramBodyWeight_Number_Content_Units("/kg{body`wt}",
			"PerKiloGramBodyWeight [Number Content Units]"),
	/**
	 * <div class="en">FemtoMolesPerMilliGram [Substance Content Units]</div>
	 */
	FemtoMolesPerMilliGram_Substance_Content_Units("fmol/mg",
			"FemtoMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class="en">NanoMolesPerMilliGram [Substance Content Units]</div>
	 */
	NanoMolesPerMilliGram_Substance_Content_Units("nmol/mg",
			"NanoMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class="en">MicroMolesPerMilliGram [Substance Content Units]</div>
	 */
	MicroMolesPerMilliGram_Substance_Content_Units("umol/mg",
			"MicroMolesPerMilliGram [Substance Content Units]"),
	/**
	 * <div class="en">MicroMolesPerMilliGramCreatinine [Substance Content
	 * Units]</div>
	 */
	MicroMolesPerMilliGramCreatinine_Substance_Content_Units("umol/mg{Cre}",
			"MicroMolesPerMilliGramCreatinine [Substance Content Units]"),
	/**
	 * <div class="en">MolesPerKiloGram [Substance Content Units]</div>
	 */
	MolesPerKiloGram_Substance_Content_Units("mol/kg",
			"MolesPerKiloGram [Substance Content Units]"),
	/**
	 * <div class="en">FemtoMolesPerGram [Substance Content Units]</div>
	 */
	FemtoMolesPerGram_Substance_Content_Units("fmol/g",
			"FemtoMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en">NanoMolesPerGram [Substance Content Units]</div>
	 */
	NanoMolesPerGram_Substance_Content_Units("nmol/g",
			"NanoMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en">NanoMolesPerGramCreatinine [Substance Content
	 * Units]</div>
	 */
	NanoMolesPerGramCreatinine_Substance_Content_Units("nmol/g{Cre}",
			"NanoMolesPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class="en">MicroMolesPerGram [Substance Content Units]</div>
	 */
	MicroMolesPerGram_Substance_Content_Units("umol/g",
			"MicroMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en">MicroMolesPerGramCreatinine [Substance Content
	 * Units]</div>
	 */
	MicroMolesPerGramCreatinine_Substance_Content_Units("umol/g{Cre}",
			"MicroMolesPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class="en">MicroMolesPerGramHemoglobin [Substance Content
	 * Units]</div>
	 */
	MicroMolesPerGramHemoglobin_Substance_Content_Units("umol/g{Hgb}",
			"MicroMolesPerGramHemoglobin [Substance Content Units]"),
	/**
	 * <div class="en">MilliMolesPerGram [Substance Content Units]</div>
	 */
	MilliMolesPerGram_Substance_Content_Units("mmol/g",
			"MilliMolesPerGram [Substance Content Units]"),
	/**
	 * <div class="en">MilliMolesPerKiloGram [Substance Content Units]</div>
	 */
	MilliMolesPerKiloGram_Substance_Content_Units("mmol/kg",
			"MilliMolesPerKiloGram [Substance Content Units]"),
	/**
	 * <div class="en">OsmolesPerKiloGram [Substance Content Units]</div>
	 */
	OsmolesPerKiloGram_Substance_Content_Units("osm/kg",
			"OsmolesPerKiloGram [Substance Content Units]"),
	/**
	 * <div class="en">MilliOsmolesPerKiloGram [Substance Rate Content
	 * Units]</div>
	 */
	MilliOsmolesPerKiloGram_Substance_Rate_Content_Units("mosm/kg",
			"MilliOsmolesPerKiloGram [Substance Rate Content Units]"),
	/**
	 * <div class="en">MilliEquivalentsPerGram [Substance Content Units]</div>
	 */
	MilliEquivalentsPerGram_Substance_Content_Units("meq/g",
			"MilliEquivalentsPerGram [Substance Content Units]"),
	/**
	 * <div class="en">MilliEquivalentsPerGramCreatinine [Substance Content
	 * Units]</div>
	 */
	MilliEquivalentsPerGramCreatinine_Substance_Content_Units("meq/g{Cre}",
			"MilliEquivalentsPerGramCreatinine [Substance Content Units]"),
	/**
	 * <div class="en">MilliEquivalentsPerKiloGram [Substance Content
	 * Units]</div>
	 */
	MilliEquivalentsPerKiloGram_Substance_Content_Units("meq/kg",
			"MilliEquivalentsPerKiloGram [Substance Content Units]"),
	/**
	 * <div class="en">InternationalUnitsPerGram [Arbitrary Concentration
	 * Content Units]</div>
	 */
	InternationalUnitsPerGram_Arbitrary_Concentration_Content_Units("[iU]/g",
			"InternationalUnitsPerGram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class="en">InternationalUnitsPerGramHemoglobin [Arbitrary
	 * Concentration Content Units]</div>
	 */
	InternationalUnitsPerGramHemoglobin_Arbitrary_Concentration_Content_Units(
			"[iU]/g{Hgb}",
			"InternationalUnitsPerGramHemoglobin [Arbitrary Concentration Content Units]"),
	/**
	 * <div class="en">EhrlichUnitsPer100Gram [Arbitrary Concentration Content
	 * Units]</div>
	 */
	EhrlichUnitsPer100Gram_Arbitrary_Concentration_Content_Units(
			"{Ehrlich_U}/100g",
			"EhrlichUnitsPer100Gram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class="en">InternationalUnitsPerKilogram [Arbitrary Concentration
	 * Content Units]</div>
	 */
	InternationalUnitsPerKilogram_Arbitrary_Concentration_Content_Units(
			"[iU]/kg",
			"InternationalUnitsPerKilogram [Arbitrary Concentration Content Units]"),
	/**
	 * <div class="en">MicroMolesPerMinutePerGram [Substance Rate Content
	 * Units]</div>
	 */
	MicroMolesPerMinutePerGram_Substance_Rate_Content_Units("umol/min/g",
			"MicroMolesPerMinutePerGram [Substance Rate Content Units]"),
	/**
	 * <div class="en">MilliUnitsPerGram [Substance Rate Content Units]</div>
	 */
	MilliUnitsPerGram_Substance_Rate_Content_Units("mU/g",
			"MilliUnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class="en">MilliUnitsPerGramHemoglobin [Substance Rate Content
	 * Units]</div>
	 */
	MilliUnitsPerGramHemoglobin_Substance_Rate_Content_Units("mU/g{Hgb}",
			"MilliUnitsPerGramHemoglobin [Substance Rate Content Units]"),
	/**
	 * <div class="en">UnitsPerGram [Substance Rate Content Units]</div>
	 */
	UnitsPerGram_Substance_Rate_Content_Units("U/g",
			"UnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class="en">UnitsPerGramHemoglobin [Substance Rate Content
	 * Units]</div>
	 */
	UnitsPerGramHemoglobin_Substance_Rate_Content_Units("U/g{Hgb}",
			"UnitsPerGramHemoglobin [Substance Rate Content Units]"),
	/**
	 * <div class="en">UnitsPerGramCreatinine [Substance Rate Content
	 * Units]</div>
	 */
	UnitsPerGramCreatinine_Substance_Rate_Content_Units("U/g{Cre}",
			"UnitsPerGramCreatinine [Substance Rate Content Units]"),
	/**
	 * <div class="en">MilliUnitsPerMilliGramCreatinine [Substance Rate Content
	 * Units]</div>
	 */
	MilliUnitsPerMilliGramCreatinine_Substance_Rate_Content_Units("mU/mg{Cre}",
			"MilliUnitsPerMilliGramCreatinine [Substance Rate Content Units]"),
	/**
	 * <div class="en">MilliUnitsPerMilligram [Substance Rate Content
	 * Units]</div>
	 */
	MilliUnitsPerMilligram_Substance_Rate_Content_Units("mU/mg",
			"MilliUnitsPerMilligram [Substance Rate Content Units]"),
	/**
	 * <div class="en">KiloUnitsPerGram [Substance Rate Content Units]</div>
	 */
	KiloUnitsPerGram_Substance_Rate_Content_Units("kU/g",
			"KiloUnitsPerGram [Substance Rate Content Units]"),
	/**
	 * <div class="en">KatalPerKilogram [Substance Rate Content Units]</div>
	 */
	KatalPerKilogram_Substance_Rate_Content_Units("kat/kg",
			"KatalPerKilogram [Substance Rate Content Units]"),
	/**
	 * <div class="en">MilliLitersPerKiloGram [Volume Content Units]</div>
	 */
	MilliLitersPerKiloGram_Volume_Content_Units("mL/kg",
			"MilliLitersPerKiloGram [Volume Content Units]"),
	/**
	 * <div class="en">LitersPerKilogram [Volume Content Units]</div>
	 */
	LitersPerKilogram_Volume_Content_Units("L/kg",
			"LitersPerKilogram [Volume Content Units]"),
	/**
	 * <div class="en">KiloCaloriesPerOunce [Energy Content Units]</div>
	 */
	KiloCaloriesPerOunce_Energy_Content_Units("kCal/[oz_av]",
			"KiloCaloriesPerOunce [Energy Content Units]"),
	/**
	 * <div class="en">PerSquareMeter [Areic Number Units]</div>
	 */
	PerSquareMeter_Areic_Number_Units("/m2",
			"PerSquareMeter [Areic Number Units]"),
	/**
	 * <div class="en">GramsPerSquareMeter [Areic Mass Units]</div>
	 */
	GramsPerSquareMeter_Areic_Mass_Units("g/m2",
			"GramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en">KiloGramsPerSquareMeter [Areic Mass Units]</div>
	 */
	KiloGramsPerSquareMeter_Areic_Mass_Units("kg/m2",
			"KiloGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en">MicroGramsPerSquareMeter [Areic Mass Units]</div>
	 */
	MicroGramsPerSquareMeter_Areic_Mass_Units("ug/m2",
			"MicroGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en">MilliGramsPerSquareMeter [Areic Mass Units]</div>
	 */
	MilliGramsPerSquareMeter_Areic_Mass_Units("mg/m2",
			"MilliGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en">NanoGramsPerSquareMeter [Areic Mass Units]</div>
	 */
	NanoGramsPerSquareMeter_Areic_Mass_Units("ng/m2",
			"NanoGramsPerSquareMeter [Areic Mass Units]"),
	/**
	 * <div class="en">GramMeter [Massive Distance Units]</div>
	 */
	GramMeter_Massive_Distance_Units("g.m",
			"GramMeter [Massive Distance Units]"),
	/**
	 * <div class="en">GramMeterPerHeartbeat [Massive Distance Units]</div>
	 */
	GramMeterPerHeartbeat_Massive_Distance_Units("g.m/{hb}",
			"GramMeterPerHeartbeat [Massive Distance Units]"),
	/**
	 * <div class="en">GramMeterPerHeartbeatPerSquareMeter [Lineic Mass
	 * Units]</div>
	 */
	GramMeterPerHeartbeatPerSquareMeter_Lineic_Mass_Units("g.m/({hb}.m2)",
			"GramMeterPerHeartbeatPerSquareMeter [Lineic Mass Units]"),
	/**
	 * <div class="en">KiloGramsPerMole [Molar Mass Units]</div>
	 */
	KiloGramsPerMole_Molar_Mass_Units("kg/mol",
			"KiloGramsPerMole [Molar Mass Units]"),
	/**
	 * <div class="en">PerMicroLiter [Number Concentration Units]</div>
	 */
	PerMicroLiter_Number_Concentration_Units("/uL",
			"PerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class="en">CellsPerMicroLiter [Number Concentration Units]</div>
	 */
	CellsPerMicroLiter_Number_Concentration_Units("{Cells}/uL",
			"CellsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class="en">RedBloodCellsPerMicroLiter [Number Concentration
	 * Units]</div>
	 */
	RedBloodCellsPerMicroLiter_Number_Concentration_Units("{rbc}/uL",
			"RedBloodCellsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class="en">ThousandsPerMicroLiter [Number Concentration Units]</div>
	 */
	ThousandsPerMicroLiter_Number_Concentration_Units("10*3/uL",
			"ThousandsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class="en">MillionsPerMicroLiter [Number Concentration Units]</div>
	 */
	MillionsPerMicroLiter_Number_Concentration_Units("10*6/uL",
			"MillionsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class="en">BillionsPerMicroLiter [Number Concentration Units]</div>
	 */
	BillionsPerMicroLiter_Number_Concentration_Units("10*9/uL",
			"BillionsPerMicroLiter [Number Concentration Units]"),
	/**
	 * <div class="en">PerMilliLiter [Number Concentration Units]</div>
	 */
	PerMilliLiter_Number_Concentration_Units("/mL",
			"PerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en">SpermatozoaPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	SpermatozoaPerMilliLiter_Number_Concentration_Units("{Spermatozoa}/mL",
			"SpermatozoaPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en">CopiesPerMilliLiter [Number Concentration Units]</div>
	 */
	CopiesPerMilliLiter_Number_Concentration_Units("{Copies}/mL",
			"CopiesPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en">ThousandPerMilliLiter [Number Concentration Units]</div>
	 */
	ThousandPerMilliLiter_Number_Concentration_Units("10*3/mL",
			"ThousandPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en">ThousandCopiesPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	ThousandCopiesPerMilliLiter_Number_Concentration_Units("10*3{Copies}/mL",
			"ThousandCopiesPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en">MillionPerMilliLiter [Number Concentration Units]</div>
	 */
	MillionPerMilliLiter_Number_Concentration_Units("10*6/mL",
			"MillionPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en">BillionsPerMilliliter [Number Concentration Units]</div>
	 */
	BillionsPerMilliliter_Number_Concentration_Units("10*9/mL",
			"BillionsPerMilliliter [Number Concentration Units]"),
	/**
	 * <div class="en">ColonyFormingUnitsPerMilliLiter [Number Concentration
	 * Units]</div>
	 */
	ColonyFormingUnitsPerMilliLiter_Number_Concentration_Units("{cfu}/mL",
			"ColonyFormingUnitsPerMilliLiter [Number Concentration Units]"),
	/**
	 * <div class="en">PerDeciLiter [Number Concentration Units]</div>
	 */
	PerDeciLiter_Number_Concentration_Units("/dL",
			"PerDeciLiter [Number Concentration Units]"),
	/**
	 * <div class="en">PerLiter [Number Concentration Units]</div>
	 */
	PerLiter_Number_Concentration_Units("/L",
			"PerLiter [Number Concentration Units]"),
	/**
	 * <div class="en">ThousandPerLiter [Number Concentration Units]</div>
	 */
	ThousandPerLiter_Number_Concentration_Units("10*3/L",
			"ThousandPerLiter [Number Concentration Units]"),
	/**
	 * <div class="en">MillionPerLiter [Number Concentration Units]</div>
	 */
	MillionPerLiter_Number_Concentration_Units("10*6/L",
			"MillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class="en">TrillionPerLiter [Number Concentration Units]</div>
	 */
	TrillionPerLiter_Number_Concentration_Units("10*12/L",
			"TrillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class="en">BillionPerLiter [Number Concentration Units]</div>
	 */
	BillionPerLiter_Number_Concentration_Units("10*9/L",
			"BillionPerLiter [Number Concentration Units]"),
	/**
	 * <div class="en">PicoGramsPerMilliLiter [Mass Concentration Units]</div>
	 */
	PicoGramsPerMilliLiter_Mass_Concentration_Units("pg/mL",
			"PicoGramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">NanoGramsPerMilliLiter [Mass Concentration Units]</div>
	 */
	NanoGramsPerMilliLiter_Mass_Concentration_Units("ng/mL",
			"NanoGramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">NanoGramsPerMilliLiterRedBloodCells [Mass Concentration
	 * Units]</div>
	 */
	NanoGramsPerMilliLiterRedBloodCells_Mass_Concentration_Units("ng/mL{rbc}",
			"NanoGramsPerMilliLiterRedBloodCells [Mass Concentration Units]"),
	/**
	 * <div class="en">MicroGramsPerMilliLiter [Mass Concentration Units]</div>
	 */
	MicroGramsPerMilliLiter_Mass_Concentration_Units("ug/mL",
			"MicroGramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">MilliGramsPerMilliLiter [Mass Concentration Units]</div>
	 */
	MilliGramsPerMilliLiter_Mass_Concentration_Units("mg/mL",
			"MilliGramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">GramsPerMilliLiter [Mass Concentration Units]</div>
	 */
	GramsPerMilliLiter_Mass_Concentration_Units("g/mL",
			"GramsPerMilliLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">PicoGramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	PicoGramsPerDeciLiter_Mass_Concentration_Units("pg/dL",
			"PicoGramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">NanoGramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	NanoGramsPerDeciLiter_Mass_Concentration_Units("ng/dL",
			"NanoGramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">MicroGramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	MicroGramsPerDeciLiter_Mass_Concentration_Units("ug/dL",
			"MicroGramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">MicroGramsPerDeciLiterRedBloodCells [Mass Concentration
	 * Units]</div>
	 */
	MicroGramsPerDeciLiterRedBloodCells_Mass_Concentration_Units("ug/dL{rbc}",
			"MicroGramsPerDeciLiterRedBloodCells [Mass Concentration Units]"),
	/**
	 * <div class="en">MilliGramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	MilliGramsPerDeciLiter_Mass_Concentration_Units("mg/dL",
			"MilliGramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">MilliGramsPhenylketonesPerDeciLiter [Mass Concentration
	 * Units]</div>
	 */
	MilliGramsPhenylketonesPerDeciLiter_Mass_Concentration_Units(
			"mg{Phenylketones}/dL",
			"MilliGramsPhenylketonesPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">GramsPerDeciLiter [Mass Concentration Units]</div>
	 */
	GramsPerDeciLiter_Mass_Concentration_Units("g/dL",
			"GramsPerDeciLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">NanoGramsPerLiter [Mass Concentration Units]</div>
	 */
	NanoGramsPerLiter_Mass_Concentration_Units("ng/L",
			"NanoGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">PicoGramsPerLiter [Mass Concentration Units]</div>
	 */
	PicoGramsPerLiter_Mass_Concentration_Units("pg/L",
			"PicoGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">MicroGramsPerLiter [Mass Concentration Units]</div>
	 */
	MicroGramsPerLiter_Mass_Concentration_Units("ug/L",
			"MicroGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">MilliGramsPerLiter [Mass Concentration Units]</div>
	 */
	MilliGramsPerLiter_Mass_Concentration_Units("mg/L",
			"MilliGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">GramsPerLiter [Mass Concentration Units]</div>
	 */
	GramsPerLiter_Mass_Concentration_Units("g/L",
			"GramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">KiloGramsPerLiter [Mass Concentration Units]</div>
	 */
	KiloGramsPerLiter_Mass_Concentration_Units("kg/L",
			"KiloGramsPerLiter [Mass Concentration Units]"),
	/**
	 * <div class="en">MilliGramsPerCubicMeter [Mass Concentration Units]</div>
	 */
	MilliGramsPerCubicMeter_Mass_Concentration_Units("mg/m3",
			"MilliGramsPerCubicMeter [Mass Concentration Units]"),
	/**
	 * <div class="en">KiloGramsPerCubicMeter [Mass Concentration Units]</div>
	 */
	KiloGramsPerCubicMeter_Mass_Concentration_Units("kg/m3",
			"KiloGramsPerCubicMeter [Mass Concentration Units]"),
	/**
	 * <div class="en">FemtoMolesPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	FemtoMolesPerMilliLiter_Substance_Concentration_Units("fmol/mL",
			"FemtoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">PicoMolesPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	PicoMolesPerMilliLiter_Substance_Concentration_Units("pmol/mL",
			"PicoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">NanoMolesPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	NanoMolesPerMilliLiter_Substance_Concentration_Units("nmol/mL",
			"NanoMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MicroMolesPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MicroMolesPerMilliLiter_Substance_Concentration_Units("umol/mL",
			"MicroMolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MolesPerMilliLiter [Substance Concentration Units]</div>
	 */
	MolesPerMilliLiter_Substance_Concentration_Units("mol/mL",
			"MolesPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">PicoMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	PicoMolesPerDeciLiter_Substance_Concentration_Units("pmol/dL",
			"PicoMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">NanoMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	NanoMolesPerDeciLiter_Substance_Concentration_Units("nmol/dL",
			"NanoMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MicroMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	MicroMolesPerDeciLiter_Substance_Concentration_Units("umol/dL",
			"MicroMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MilliMolesPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	MilliMolesPerDeciLiter_Substance_Concentration_Units("mmol/dL",
			"MilliMolesPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MilliMolesPerLiter [Substance Concentration Units]</div>
	 */
	MilliMolesPerLiter_Substance_Concentration_Units("mmol/L",
			"MilliMolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">PicoMolesPerLiter [Substance Concentration Units]</div>
	 */
	PicoMolesPerLiter_Substance_Concentration_Units("pmol/L",
			"PicoMolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">NanoMolesPerLiter [Substance Concentration Units]</div>
	 */
	NanoMolesPerLiter_Substance_Concentration_Units("nmol/L",
			"NanoMolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MicroMolesPerLiter [Substance Concentration Units]</div>
	 */
	MicroMolesPerLiter_Substance_Concentration_Units("umol/L",
			"MicroMolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MolesPerLiter [Substance Concentration Units]</div>
	 */
	MolesPerLiter_Substance_Concentration_Units("mol/L",
			"MolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MolesPerCubicMeter [Substance Concentration Units]</div>
	 */
	MolesPerCubicMeter_Substance_Concentration_Units("mol/m3",
			"MolesPerCubicMeter [Substance Concentration Units]"),
	/**
	 * <div class="en">MicroEquivalentsPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MicroEquivalentsPerMilliLiter_Substance_Concentration_Units("ueq/mL",
			"MicroEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MilliEquivalentPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MilliEquivalentPerMilliLiter_Substance_Concentration_Units("meq/mL",
			"MilliEquivalentPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">EquivalentsPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	EquivalentsPerMilliLiter_Substance_Concentration_Units("eq/mL",
			"EquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">AHGEquivalentsPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	AHGEquivalentsPerMilliLiter_Substance_Concentration_Units("{AHG}eq/mL",
			"AHGEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MillionEquivalentsPerMilliLiter [Substance Concentration
	 * Units]</div>
	 */
	MillionEquivalentsPerMilliLiter_Substance_Concentration_Units("10*6.eq/mL",
			"MillionEquivalentsPerMilliLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MicroEquivalentsPerLiter [Substance Concentration
	 * Units]</div>
	 */
	MicroEquivalentsPerLiter_Substance_Concentration_Units("ueq/L",
			"MicroEquivalentsPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MilliEquivalentsPerLiter [Substance Concentration
	 * Units]</div>
	 */
	MilliEquivalentsPerLiter_Substance_Concentration_Units("meq/L",
			"MilliEquivalentsPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">EquivalentsPerLiter [Substance Concentration Units]</div>
	 */
	EquivalentsPerLiter_Substance_Concentration_Units("eq/L",
			"EquivalentsPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MilliEquivalentsPerDeciLiter [Substance Concentration
	 * Units]</div>
	 */
	MilliEquivalentsPerDeciLiter_Substance_Concentration_Units("meq/dL",
			"MilliEquivalentsPerDeciLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MilliOsmolesPerLiter [Substance Concentration
	 * Units]</div>
	 */
	MilliOsmolesPerLiter_Substance_Concentration_Units("mosm/L",
			"MilliOsmolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">OsmolesPerLiter [Substance Concentration Units]</div>
	 */
	OsmolesPerLiter_Substance_Concentration_Units("osm/L",
			"OsmolesPerLiter [Substance Concentration Units]"),
	/**
	 * <div class="en">MicroInternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	MicroInternationalUnitsPerMilliLiter_Arbitrary_Concentration_Units(
			"u[iU]/mL",
			"MicroInternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">MilliInternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	MilliInternationalUnitsPerMilliLiter_Arbitrary_Concentration_Units(
			"m[iU]/mL",
			"MilliInternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">IgGPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	IgGPhospholipidUnitsPerMilliLiter_Arbitrary_Concentration_Units(
			"{IgGPhospholipid}U/mL",
			"IgGPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">IgMPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	IgMPhospholipidUnitsPerMilliLiter_Arbitrary_Concentration_Units(
			"{IgMPhospholipid}U/mL",
			"IgMPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">ComplementCh50UnitsPerMilliLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	ComplementCh50UnitsPerMilliLiter_Arbitrary_Concentration_Units(
			"{ComplementCh50}U/mL",
			"ComplementCh50UnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">IgAPhospholipidUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	IgAPhospholipidUnitsPerMilliLiter_Arbitrary_Concentration_Units(
			"{IgAPhospholipid}U/mL",
			"IgAPhospholipidUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">ElisaUnitsPerMilliLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	ElisaUnitsPerMilliLiter_Arbitrary_Concentration_Units("{Elisa_U}/mL",
			"ElisaUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">InternationalUnitsPerMilliLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	InternationalUnitsPerMilliLiter_Arbitrary_Concentration_Units("[iU]/mL",
			"InternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">KiloInternationalUnitsPerMilliLiter [Arbitrary
	 * Concentration Units]</div>
	 */
	KiloInternationalUnitsPerMilliLiter_Arbitrary_Concentration_Units(
			"k[iU]/mL",
			"KiloInternationalUnitsPerMilliLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">InternationalUnitsPerDeciLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	InternationalUnitsPerDeciLiter_Arbitrary_Concentration_Units("[iU]/dL",
			"InternationalUnitsPerDeciLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">EhrlichUnitsPerDeciLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	EhrlichUnitsPerDeciLiter_Arbitrary_Concentration_Units("{Ehrlich_U}/dL",
			"EhrlichUnitsPerDeciLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">MilliInternationalUnitsPerLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	MilliInternationalUnitsPerLiter_Arbitrary_Concentration_Units("m[iU]/L",
			"MilliInternationalUnitsPerLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">InternationalUnitsPerLiter [Arbitrary Concentration
	 * Units]</div>
	 */
	InternationalUnitsPerLiter_Arbitrary_Concentration_Units("[iU]/L",
			"InternationalUnitsPerLiter [Arbitrary Concentration Units]"),
	/**
	 * <div class="en">pH [pH Units]</div>
	 */
	pH_pH_Units("[pH]", "pH [pH Units]");
	public static final String Descriptive_Name_CODE = "Code";
	public static final String Percent_Most_Common_Healthcare_Units_CODE = "%";
	public static final String PerMicroLiter_Most_Common_Healthcare_Units_CODE = "/uL";
	public static final String InternationalUnitsPerLiter_Most_Common_Healthcare_Units_CODE = "[iU]/L";
	public static final String ThousandsPerMicroLiter_Most_Common_Healthcare_Units_CODE = "10*3/uL";
	public static final String MillionsPerMicroLiter_Most_Common_Healthcare_Units_CODE = "10*6/uL";
	public static final String FemtoLiter_Most_Common_Healthcare_Units_CODE = "fL";
	public static final String GramsPerDeciLiter_Most_Common_Healthcare_Units_CODE = "g/dL";
	public static final String GramsPerLiter_Most_Common_Healthcare_Units_CODE = "g/L";
	public static final String GramsPerMilliLiter_Most_Common_Healthcare_Units_CODE = "g/mL";
	public static final String KiloPascal_Most_Common_Healthcare_Units_CODE = "kPa";
	public static final String MilliInternationalUnitsPerMilliLiter_Most_Common_Healthcare_Units_CODE = "m[iU]/mL";
	public static final String MilliEquivalentsPerLiter_Most_Common_Healthcare_Units_CODE = "meq/L";
	public static final String MilliGramsPerDeciLiter_Most_Common_Healthcare_Units_CODE = "mg/dL";
	public static final String MilliMetersOfMercury_Most_Common_Healthcare_Units_CODE = "mm[Hg]";
	public static final String MilliMolesPerKiloGram_Most_Common_Healthcare_Units_CODE = "mmol/kg";
	public static final String MilliMolesPerLiter_Most_Common_Healthcare_Units_CODE = "mmol/L";
	public static final String MilliOsmolesPerKiloGram_Most_Common_Healthcare_Units_CODE = "mosm/kg";
	public static final String NanoGramsPerMilliLiter_Most_Common_Healthcare_Units_CODE = "ng/mL";
	public static final String NanoMolesPerLiter_Most_Common_Healthcare_Units_CODE = "nmol/L";
	public static final String PicoGrams_Most_Common_Healthcare_Units_CODE = "pg";
	public static final String PicoGramsPerMilliLiter_Most_Common_Healthcare_Units_CODE = "pg/mL";
	public static final String PicoMolesPerLiter_Most_Common_Healthcare_Units_CODE = "pmol/L";
	public static final String UnitsPerLiter_Most_Common_Healthcare_Units_CODE = "U/L";
	public static final String MicroInternationalUnitsPerMilliLiter_Most_Common_Healthcare_Units_CODE = "u[iU]/mL";
	public static final String MicroGramsPerDeciLiter_Most_Common_Healthcare_Units_CODE = "ug/dL";
	public static final String MicroGramsPerLiter_Most_Common_Healthcare_Units_CODE = "ug/L";
	public static final String MicroGramsPerMilliLiter_Most_Common_Healthcare_Units_CODE = "ug/mL";
	public static final String MicroMolesPerLiter_Most_Common_Healthcare_Units_CODE = "umol/L";
	public static final String Log10_Unity_CODE = "[lg]";
	public static final String MillionPerSpecimen_Unity_CODE = "10*6/{Specimen}";
	public static final String PerTotalCount_Unity_CODE = "/{tot}";
	public static final String Thousand_Unity_CODE = "10*3";
	public static final String ThousandRedBloodCells_Unity_CODE = "10*3.{RBC}";
	public static final String OneHundredThousand_Unity_CODE = "10*5";
	public static final String Million_Unity_CODE = "10*6";
	public static final String TenToEighth_Unity_CODE = "10*8";
	public static final String Percent_General_Fraction_Unit_CODE = "%";
	public static final String RelativePercent_General_Fraction_Unit_CODE = "{Relative}%";
	public static final String PercentTotal_General_Fraction_Unit_CODE = "%{Total}";
	public static final String Percent0to3Hours_General_Fraction_Unit_CODE = "%{0to3Hours}";
	public static final String PerTenGiga_Number_Fraction_Units_CODE = "/10*10";
	public static final String PerMillion_Number_Fraction_Units_CODE = "/10*6";
	public static final String PerBillion_Number_Fraction_Units_CODE = "/10*9";
	public static final String PerTrillion_Number_Fraction_Units_CODE = "/10*12";
	public static final String PercentNormal_Number_Fraction_Units_CODE = "%{Normal}";
	public static final String PercentSpermMotility_Number_Fraction_Units_CODE = "%{SpermMotility}";
	public static final String PercentPositive_Number_Fraction_Units_CODE = "%{Positive}";
	public static final String PercentFetalErythrocytes_Number_Fraction_Units_CODE = "%{FetalErythrocytes}";
	public static final String PercentOfLymphocytes_Number_Fraction_Units_CODE = "%{OfLymphocytes}";
	public static final String PercentofBacteria_Number_Fraction_Units_CODE = "%{ofBacteria}";
	public static final String PercentOfWBCs_Number_Fraction_Units_CODE = "%{OfWBCs}";
	public static final String PercentAbnormal_Number_Fraction_Units_CODE = "%{Abnormal}";
	public static final String PercentEosinophilsSeen_Number_Fraction_Units_CODE = "%{EosSeen}";
	public static final String PercentHemolysis_Number_Fraction_Units_CODE = "%{Hemolysis}";
	public static final String PercentBlockade_Number_Fraction_Units_CODE = "%{Blockade}";
	public static final String PercentPer100WBC_Number_Fraction_Units_CODE = "%/100{WBC}";
	public static final String PercentBinding_Mass_Or_Substance_Fraction_Units_CODE = "%{Binding}";
	public static final String PercentTotalProtein_Mass_Or_Substance_Fraction_Units_CODE = "%{TotalProtein}";
	public static final String PercentBound_Mass_Or_Substance_Fraction_Units_CODE = "%{Bound}";
	public static final String PercentHemoglobin_Mass_Or_Substance_Fraction_Units_CODE = "%{Hemoglobin}";
	public static final String PercentHemoglobinSaturation_Mass_Or_Substance_Fraction_Units_CODE = "%{HemoglobinSaturation}";
	public static final String PercentCarboxyhemoglobin_Mass_Or_Substance_Fraction_Units_CODE = "%{Carboxyhemoglobin}";
	public static final String PercentHemoglobinA1C_Mass_Or_Substance_Fraction_Units_CODE = "%{HemoglobinA1C}";
	public static final String PercentExcretion_Mass_Or_Substance_Rate_Fraction_Units_CODE = "%{Excretion}";
	public static final String PercentUptake_Mass_Or_Substance_Rate_Fraction_Units_CODE = "%{Uptake}";
	public static final String MicroGramsPerNanoGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/ng";
	public static final String NanoGramsPerMilliGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ng/mg";
	public static final String NanoGramsPerMilliGramProtein_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ng/mg{Protein}";
	public static final String MicroGramsPerMilliGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/mg";
	public static final String MicroGramsPerMilliGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/mg{Cre}";
	public static final String MilliGramsPerMilliGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "mg/mg";
	public static final String MilligramsPerMilligramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "mg/mg{Cre}";
	public static final String NanoGramsPerGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ng/g";
	public static final String NanoGramsPerGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ng/g{Cre}";
	public static final String MicroGramsPerGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/g";
	public static final String MicroGramPer100Gram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/[100]g";
	public static final String MicroGramPerGramDryWeight_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/g{DryWeight}";
	public static final String MicroGramPerGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/g{Cre}";
	public static final String MicroGramsPerGramHemoglobin_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/g{Hgb}";
	public static final String MilliGramsPerGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "mg/g";
	public static final String MilliGramPerGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "mg/g{Cre}";
	public static final String GramsPerGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "g/g";
	public static final String NanoGramsPerKiloGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ng/kg";
	public static final String MicroGramsPerKiloGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "ug/kg";
	public static final String MilliGramsPerKiloGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "mg/kg";
	public static final String GramsPerKiloGram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "g/kg";
	public static final String GramsPer100Gram_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "g/[100]g";
	public static final String GramsPerGramCreatinine_Mass_Ratio_Or_Mass_Fraction_Or_Mass_Content_Units_CODE = "g/g{Cre}";
	public static final String PicoMolesPerMicroMole_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "pmol/umol";
	public static final String NanoMolesPerMilliMole_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "nmol/mmol";
	public static final String NanoMolesPerMilliMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "nmol/mmol{Cre}";
	public static final String NanoMolesPerMole_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "nmol/mol";
	public static final String MicroMolesPerMole_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "umol/mol";
	public static final String MilliMolesPerMole_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "mmol/mol";
	public static final String MilliMolesPerMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "mmol/mol{Cre}";
	public static final String MicroMolesPerMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "umol/mol{Cre}";
	public static final String EquivalentsPerMicroMole_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "eq/umol";
	public static final String EquivalentsPerMilliMole_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "eq/mmol";
	public static final String BoneCollagenEquivalentsPerMilliMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "{BoneCollagen}eq/mmol{Cre}";
	public static final String BoneCollagenEquivalentsPerMicroMoleCreatinine_Substance_Ratio_Or_Substance_Fraction_Units_CODE = "{BoneCollagen}eq/umol{Cre}";
	public static final String VolumePercent_Volume_Fraction_Units_CODE = "%{vol}";
	public static final String PercentOxygen_Volume_Fraction_Units_CODE = "%{Oxygen}";
	public static final String MilliLitersPerDeciLiter_Volume_Fraction_Units_CODE = "mL/dL";
	public static final String PercentNormalPooledPlasma_Catalytic_Fraction_Or_Arbitrary_Fraction_Units_CODE = "%{NormalPooledPlasma}";
	public static final String PercentActivity_Catalytic_Fraction_Or_Arbitrary_Fraction_Units_CODE = "%{Activity}";
	public static final String PercentBasalActivity_Catalytic_Fraction_Or_Arbitrary_Fraction_Units_CODE = "%{BasalActivity}";
	public static final String PercentInhibition_Catalytic_Fraction_Or_Arbitrary_Fraction_Units_CODE = "%{Inhibition}";
	public static final String PerEntity_Entitic_Number_Units_CODE = "/{Entity}";
	public static final String Per100WBC_Entitic_Number_Units_CODE = "/100{WBC}";
	public static final String Per100_Entitic_Number_Units_CODE = "/100";
	public static final String Per100Spermatozoa_Entitic_Number_Units_CODE = "/100{Spermatozoa}";
	public static final String PerTrillionRedBloodCells_Entitic_Number_Units_CODE = "/10*12{rbc}";
	public static final String DegreesOfArc_Plane_Angle_Units_CODE = "deg";
	public static final String PerArbitraryUnit_Arbitrary_Number_Units_CODE = "/[arb`U]";
	public static final String MicroInternationalUnit_Arbitrary_Units_CODE = "u[iU]";
	public static final String InternationalUnit_Arbitrary_Units_CODE = "[iU]";
	public static final String MillionInternationalUnit_Arbitrary_Units_CODE = "10*6.[iU]";
	public static final String Inch_English_Length_Units_CODE = "[in_i]";
	public static final String Feet_English_Length_Units_CODE = "[ft_i]";
	public static final String Yard_English_Length_Units_CODE = "[yd_i]";
	public static final String Fathom_English_Length_Units_CODE = "[fth_i]";
	public static final String StatuteMile_English_Length_Units_CODE = "[mi_i]";
	public static final String NauticalMile_English_Length_Units_CODE = "[nmi_i]";
	public static final String French_English_Length_Units_CODE = "[Ch]";
	public static final String FemtoMeter_SI_Length_Units_CODE = "fm";
	public static final String PicoMeter_SI_Length_Units_CODE = "pm";
	public static final String NanoMeter_SI_Length_Units_CODE = "nm";
	public static final String MicroMeter_SI_Length_Units_CODE = "um";
	public static final String MilliMeter_SI_Length_Units_CODE = "mm";
	public static final String CentiMeter_SI_Length_Units_CODE = "cm";
	public static final String DeciMeter_SI_Length_Units_CODE = "dm";
	public static final String Meter_SI_Length_Units_CODE = "m";
	public static final String KiloMeter_SI_Length_Units_CODE = "km";
	public static final String Grain_English_Mass_Units_CODE = "[gr]";
	public static final String Ounce_English_Mass_Units_CODE = "[oz_av]";
	public static final String TroyOunce_English_Mass_Units_CODE = "[oz_tr]";
	public static final String Pound_English_Mass_Units_CODE = "[lb_av]";
	public static final String Ton_English_Mass_Units_CODE = "[ston_av]";
	public static final String Dram_English_Mass_Units_CODE = "[dr_av]";
	public static final String FemtoGram_SI_Mass_Units_CODE = "fg";
	public static final String PicoGram_SI_Mass_Units_CODE = "pg";
	public static final String NanoGram_SI_Mass_Units_CODE = "ng";
	public static final String MicroGram_SI_Mass_Units_CODE = "ug";
	public static final String MicroGramsPerTotalVolume_SI_Mass_Units_CODE = "ug/{TotalVolume}";
	public static final String MicroGramsPerSpecimen_SI_Mass_Units_CODE = "ug/{Specimen}";
	public static final String MilliGram_SI_Mass_Units_CODE = "mg";
	public static final String MilliGramsPerVolume_SI_Mass_Units_CODE = "mg/{Volume}";
	public static final String MilliGramPerTotalVolume_SI_Mass_Units_CODE = "mg/{TotalVolume}";
	public static final String Gram_SI_Mass_Units_CODE = "g";
	public static final String GramsPerTotalWeight_SI_Mass_Units_CODE = "g/{TotalWeight}";
	public static final String DeciGram_SI_Mass_Units_CODE = "dg";
	public static final String CentiGram_SI_Mass_Units_CODE = "cg";
	public static final String KiloGram_SI_Mass_Units_CODE = "kg";
	public static final String MetricTon_SI_Mass_Units_CODE = "t";
	public static final String PicoGramsPerMilliMeter_Lineic_Mass_Units_CODE = "pg/mm";
	public static final String DegreesKelvin_Temperature_Units_CODE = "K";
	public static final String DegreesCelsius_Temperature_Units_CODE = "Cel";
	public static final String DegreesFahrenheit_Temperature_Units_CODE = "[degF]";
	public static final String KelvinPerWatt_Thermal_Resistance_Units_CODE = "K/W";
	public static final String PicoSecond_Time_Units_CODE = "ps";
	public static final String NanoSecond_Time_Units_CODE = "ns";
	public static final String MicroSecond_Time_Units_CODE = "us";
	public static final String MilliSecond_Time_Units_CODE = "ms";
	public static final String Second_Time_Units_CODE = "s";
	public static final String KiloSecond_Time_Units_CODE = "ks";
	public static final String Megasecond_Time_Units_CODE = "Ms";
	public static final String Minute_Time_Units_CODE = "min";
	public static final String Hour_Time_Units_CODE = "h";
	public static final String Day_Time_Units_CODE = "d";
	public static final String Week_Time_Units_CODE = "wk";
	public static final String Month_Time_Units_CODE = "mo";
	public static final String Year_Time_Units_CODE = "a";
	public static final String Equivalent_Substance_Units_CODE = "eq";
	public static final String MicroEquivalent_Substance_Units_CODE = "ueq";
	public static final String MilliEquivalent_Substance_Units_CODE = "meq";
	public static final String MilliEquivalentsPerSpecimen_Substance_Units_CODE = "meq/{Specimen}";
	public static final String Mole_Substance_Units_CODE = "mol";
	public static final String MilliMole_Substance_Units_CODE = "mmol";
	public static final String MilliMolesPerTotalVolume_Substance_Units_CODE = "mmol/{TotalVolume}";
	public static final String Femtomole_Substance_Units_CODE = "fmol";
	public static final String PicoMole_Substance_Units_CODE = "pmol";
	public static final String MicroMole_Substance_Units_CODE = "umol";
	public static final String NanoMole_Substance_Units_CODE = "nmol";
	public static final String MilliOsmole_Substance_Units_CODE = "mosm";
	public static final String MilliEquivalentsPerSquareMeter_Areic_Substance_Units_CODE = "meq/m2";
	public static final String MilliMolesPerSquareMeter_Areic_Substance_Units_CODE = "mmol/m2";
	public static final String SquareInch_English_Area_Units_CODE = "[sin_i]";
	public static final String SquareFeet_English_Area_Units_CODE = "[sft_i]";
	public static final String SquareYard_English_Area_Units_CODE = "[syd_i]";
	public static final String SquareMilliMeter_SI_Area_Units_CODE = "mm2";
	public static final String SquareCentiMeter_SI_Area_Units_CODE = "cm2";
	public static final String SquareMeter_SI_Area_Units_CODE = "m2";
	public static final String FluidOunce_English_Volume_Units_CODE = "[foz_us]";
	public static final String CubicInch_English_Volume_Units_CODE = "[cin_i]";
	public static final String Cup_English_Volume_Units_CODE = "[cup_us]";
	public static final String Pint_English_Volume_Units_CODE = "[pt_us]";
	public static final String Quart_English_Volume_Units_CODE = "[qt_us]";
	public static final String Gallon_English_Volume_Units_CODE = "[gal_us]";
	public static final String FluidDram_English_Volume_Units_CODE = "[fdr_us]";
	public static final String FemtoLiter_SI_Volume_Units_CODE = "fL";
	public static final String PicoLiter_SI_Volume_Units_CODE = "pL";
	public static final String NanoLiter_SI_Volume_Units_CODE = "nL";
	public static final String MicroLiter_SI_Volume_Units_CODE = "uL";
	public static final String MilliLiter_SI_Volume_Units_CODE = "mL";
	public static final String MilliLitersPerHeartbeat_SI_Volume_Units_CODE = "mL/{h`b}";
	public static final String Liter_SI_Volume_Units_CODE = "L";
	public static final String DeciLiter_SI_Volume_Units_CODE = "dL";
	public static final String CentiLiter_SI_Volume_Units_CODE = "cL";
	public static final String KiloLiter_SI_Volume_Units_CODE = "kL";
	public static final String HectoLiter_SI_Volume_Units_CODE = "hL";
	public static final String LiterSquareSecondPerSecond_Volume_Duration_Units_CODE = "L.s2/s";
	public static final String PerMilliGram_Number_Content_Units_CODE = "/mg";
	public static final String PerGram_Number_Content_Units_CODE = "/g";
	public static final String PerGramCreatinine_Number_Content_Units_CODE = "/g{creat}";
	public static final String PerGramHemoglobin_Number_Content_Units_CODE = "/g{HGB}";
	public static final String PerGramTotalNitrogen_Number_Content_Units_CODE = "/g{tot`nit}";
	public static final String PerGramTotalProtein_Number_Content_Units_CODE = "/g{tot`prot}";
	public static final String PerGramWetTissue_Number_Content_Units_CODE = "/g{wet`tis}";
	public static final String PerKiloGram_Number_Content_Units_CODE = "/kg";
	public static final String PerKiloGramBodyWeight_Number_Content_Units_CODE = "/kg{body`wt}";
	public static final String FemtoMolesPerMilliGram_Substance_Content_Units_CODE = "fmol/mg";
	public static final String NanoMolesPerMilliGram_Substance_Content_Units_CODE = "nmol/mg";
	public static final String MicroMolesPerMilliGram_Substance_Content_Units_CODE = "umol/mg";
	public static final String MicroMolesPerMilliGramCreatinine_Substance_Content_Units_CODE = "umol/mg{Cre}";
	public static final String MolesPerKiloGram_Substance_Content_Units_CODE = "mol/kg";
	public static final String FemtoMolesPerGram_Substance_Content_Units_CODE = "fmol/g";
	public static final String NanoMolesPerGram_Substance_Content_Units_CODE = "nmol/g";
	public static final String NanoMolesPerGramCreatinine_Substance_Content_Units_CODE = "nmol/g{Cre}";
	public static final String MicroMolesPerGram_Substance_Content_Units_CODE = "umol/g";
	public static final String MicroMolesPerGramCreatinine_Substance_Content_Units_CODE = "umol/g{Cre}";
	public static final String MicroMolesPerGramHemoglobin_Substance_Content_Units_CODE = "umol/g{Hgb}";
	public static final String MilliMolesPerGram_Substance_Content_Units_CODE = "mmol/g";
	public static final String MilliMolesPerKiloGram_Substance_Content_Units_CODE = "mmol/kg";
	public static final String OsmolesPerKiloGram_Substance_Content_Units_CODE = "osm/kg";
	public static final String MilliOsmolesPerKiloGram_Substance_Rate_Content_Units_CODE = "mosm/kg";
	public static final String MilliEquivalentsPerGram_Substance_Content_Units_CODE = "meq/g";
	public static final String MilliEquivalentsPerGramCreatinine_Substance_Content_Units_CODE = "meq/g{Cre}";
	public static final String MilliEquivalentsPerKiloGram_Substance_Content_Units_CODE = "meq/kg";
	public static final String InternationalUnitsPerGram_Arbitrary_Concentration_Content_Units_CODE = "[iU]/g";
	public static final String InternationalUnitsPerGramHemoglobin_Arbitrary_Concentration_Content_Units_CODE = "[iU]/g{Hgb}";
	public static final String EhrlichUnitsPer100Gram_Arbitrary_Concentration_Content_Units_CODE = "{Ehrlich_U}/100g";
	public static final String InternationalUnitsPerKilogram_Arbitrary_Concentration_Content_Units_CODE = "[iU]/kg";
	public static final String MicroMolesPerMinutePerGram_Substance_Rate_Content_Units_CODE = "umol/min/g";
	public static final String MilliUnitsPerGram_Substance_Rate_Content_Units_CODE = "mU/g";
	public static final String MilliUnitsPerGramHemoglobin_Substance_Rate_Content_Units_CODE = "mU/g{Hgb}";
	public static final String UnitsPerGram_Substance_Rate_Content_Units_CODE = "U/g";
	public static final String UnitsPerGramHemoglobin_Substance_Rate_Content_Units_CODE = "U/g{Hgb}";
	public static final String UnitsPerGramCreatinine_Substance_Rate_Content_Units_CODE = "U/g{Cre}";
	public static final String MilliUnitsPerMilliGramCreatinine_Substance_Rate_Content_Units_CODE = "mU/mg{Cre}";
	public static final String MilliUnitsPerMilligram_Substance_Rate_Content_Units_CODE = "mU/mg";
	public static final String KiloUnitsPerGram_Substance_Rate_Content_Units_CODE = "kU/g";
	public static final String KatalPerKilogram_Substance_Rate_Content_Units_CODE = "kat/kg";
	public static final String MilliLitersPerKiloGram_Volume_Content_Units_CODE = "mL/kg";
	public static final String LitersPerKilogram_Volume_Content_Units_CODE = "L/kg";
	public static final String KiloCaloriesPerOunce_Energy_Content_Units_CODE = "kCal/[oz_av]";
	public static final String PerSquareMeter_Areic_Number_Units_CODE = "/m2";
	public static final String GramsPerSquareMeter_Areic_Mass_Units_CODE = "g/m2";
	public static final String KiloGramsPerSquareMeter_Areic_Mass_Units_CODE = "kg/m2";
	public static final String MicroGramsPerSquareMeter_Areic_Mass_Units_CODE = "ug/m2";
	public static final String MilliGramsPerSquareMeter_Areic_Mass_Units_CODE = "mg/m2";
	public static final String NanoGramsPerSquareMeter_Areic_Mass_Units_CODE = "ng/m2";
	public static final String GramMeter_Massive_Distance_Units_CODE = "g.m";
	public static final String GramMeterPerHeartbeat_Massive_Distance_Units_CODE = "g.m/{hb}";
	public static final String GramMeterPerHeartbeatPerSquareMeter_Lineic_Mass_Units_CODE = "g.m/({hb}.m2)";
	public static final String KiloGramsPerMole_Molar_Mass_Units_CODE = "kg/mol";
	public static final String PerMicroLiter_Number_Concentration_Units_CODE = "/uL";
	public static final String CellsPerMicroLiter_Number_Concentration_Units_CODE = "{Cells}/uL";
	public static final String RedBloodCellsPerMicroLiter_Number_Concentration_Units_CODE = "{rbc}/uL";
	public static final String ThousandsPerMicroLiter_Number_Concentration_Units_CODE = "10*3/uL";
	public static final String MillionsPerMicroLiter_Number_Concentration_Units_CODE = "10*6/uL";
	public static final String BillionsPerMicroLiter_Number_Concentration_Units_CODE = "10*9/uL";
	public static final String PerMilliLiter_Number_Concentration_Units_CODE = "/mL";
	public static final String SpermatozoaPerMilliLiter_Number_Concentration_Units_CODE = "{Spermatozoa}/mL";
	public static final String CopiesPerMilliLiter_Number_Concentration_Units_CODE = "{Copies}/mL";
	public static final String ThousandPerMilliLiter_Number_Concentration_Units_CODE = "10*3/mL";
	public static final String ThousandCopiesPerMilliLiter_Number_Concentration_Units_CODE = "10*3{Copies}/mL";
	public static final String MillionPerMilliLiter_Number_Concentration_Units_CODE = "10*6/mL";
	public static final String BillionsPerMilliliter_Number_Concentration_Units_CODE = "10*9/mL";
	public static final String ColonyFormingUnitsPerMilliLiter_Number_Concentration_Units_CODE = "{cfu}/mL";
	public static final String PerDeciLiter_Number_Concentration_Units_CODE = "/dL";
	public static final String PerLiter_Number_Concentration_Units_CODE = "/L";
	public static final String ThousandPerLiter_Number_Concentration_Units_CODE = "10*3/L";
	public static final String MillionPerLiter_Number_Concentration_Units_CODE = "10*6/L";
	public static final String TrillionPerLiter_Number_Concentration_Units_CODE = "10*12/L";
	public static final String BillionPerLiter_Number_Concentration_Units_CODE = "10*9/L";
	public static final String PicoGramsPerMilliLiter_Mass_Concentration_Units_CODE = "pg/mL";
	public static final String NanoGramsPerMilliLiter_Mass_Concentration_Units_CODE = "ng/mL";
	public static final String NanoGramsPerMilliLiterRedBloodCells_Mass_Concentration_Units_CODE = "ng/mL{rbc}";
	public static final String MicroGramsPerMilliLiter_Mass_Concentration_Units_CODE = "ug/mL";
	public static final String MilliGramsPerMilliLiter_Mass_Concentration_Units_CODE = "mg/mL";
	public static final String GramsPerMilliLiter_Mass_Concentration_Units_CODE = "g/mL";
	public static final String PicoGramsPerDeciLiter_Mass_Concentration_Units_CODE = "pg/dL";
	public static final String NanoGramsPerDeciLiter_Mass_Concentration_Units_CODE = "ng/dL";
	public static final String MicroGramsPerDeciLiter_Mass_Concentration_Units_CODE = "ug/dL";
	public static final String MicroGramsPerDeciLiterRedBloodCells_Mass_Concentration_Units_CODE = "ug/dL{rbc}";
	public static final String MilliGramsPerDeciLiter_Mass_Concentration_Units_CODE = "mg/dL";
	public static final String MilliGramsPhenylketonesPerDeciLiter_Mass_Concentration_Units_CODE = "mg{Phenylketones}/dL";
	public static final String GramsPerDeciLiter_Mass_Concentration_Units_CODE = "g/dL";
	public static final String NanoGramsPerLiter_Mass_Concentration_Units_CODE = "ng/L";
	public static final String PicoGramsPerLiter_Mass_Concentration_Units_CODE = "pg/L";
	public static final String MicroGramsPerLiter_Mass_Concentration_Units_CODE = "ug/L";
	public static final String MilliGramsPerLiter_Mass_Concentration_Units_CODE = "mg/L";
	public static final String GramsPerLiter_Mass_Concentration_Units_CODE = "g/L";
	public static final String KiloGramsPerLiter_Mass_Concentration_Units_CODE = "kg/L";
	public static final String MilliGramsPerCubicMeter_Mass_Concentration_Units_CODE = "mg/m3";
	public static final String KiloGramsPerCubicMeter_Mass_Concentration_Units_CODE = "kg/m3";
	public static final String FemtoMolesPerMilliLiter_Substance_Concentration_Units_CODE = "fmol/mL";
	public static final String PicoMolesPerMilliLiter_Substance_Concentration_Units_CODE = "pmol/mL";
	public static final String NanoMolesPerMilliLiter_Substance_Concentration_Units_CODE = "nmol/mL";
	public static final String MicroMolesPerMilliLiter_Substance_Concentration_Units_CODE = "umol/mL";
	public static final String MolesPerMilliLiter_Substance_Concentration_Units_CODE = "mol/mL";
	public static final String PicoMolesPerDeciLiter_Substance_Concentration_Units_CODE = "pmol/dL";
	public static final String NanoMolesPerDeciLiter_Substance_Concentration_Units_CODE = "nmol/dL";
	public static final String MicroMolesPerDeciLiter_Substance_Concentration_Units_CODE = "umol/dL";
	public static final String MilliMolesPerDeciLiter_Substance_Concentration_Units_CODE = "mmol/dL";
	public static final String MilliMolesPerLiter_Substance_Concentration_Units_CODE = "mmol/L";
	public static final String PicoMolesPerLiter_Substance_Concentration_Units_CODE = "pmol/L";
	public static final String NanoMolesPerLiter_Substance_Concentration_Units_CODE = "nmol/L";
	public static final String MicroMolesPerLiter_Substance_Concentration_Units_CODE = "umol/L";
	public static final String MolesPerLiter_Substance_Concentration_Units_CODE = "mol/L";
	public static final String MolesPerCubicMeter_Substance_Concentration_Units_CODE = "mol/m3";
	public static final String MicroEquivalentsPerMilliLiter_Substance_Concentration_Units_CODE = "ueq/mL";
	public static final String MilliEquivalentPerMilliLiter_Substance_Concentration_Units_CODE = "meq/mL";
	public static final String EquivalentsPerMilliLiter_Substance_Concentration_Units_CODE = "eq/mL";
	public static final String AHGEquivalentsPerMilliLiter_Substance_Concentration_Units_CODE = "{AHG}eq/mL";
	public static final String MillionEquivalentsPerMilliLiter_Substance_Concentration_Units_CODE = "10*6.eq/mL";
	public static final String MicroEquivalentsPerLiter_Substance_Concentration_Units_CODE = "ueq/L";
	public static final String MilliEquivalentsPerLiter_Substance_Concentration_Units_CODE = "meq/L";
	public static final String EquivalentsPerLiter_Substance_Concentration_Units_CODE = "eq/L";
	public static final String MilliEquivalentsPerDeciLiter_Substance_Concentration_Units_CODE = "meq/dL";
	public static final String MilliOsmolesPerLiter_Substance_Concentration_Units_CODE = "mosm/L";
	public static final String OsmolesPerLiter_Substance_Concentration_Units_CODE = "osm/L";
	public static final String MicroInternationalUnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "u[iU]/mL";
	public static final String MilliInternationalUnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "m[iU]/mL";
	public static final String IgGPhospholipidUnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "{IgGPhospholipid}U/mL";
	public static final String IgMPhospholipidUnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "{IgMPhospholipid}U/mL";
	public static final String ComplementCh50UnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "{ComplementCh50}U/mL";
	public static final String IgAPhospholipidUnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "{IgAPhospholipid}U/mL";
	public static final String ElisaUnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "{Elisa_U}/mL";
	public static final String InternationalUnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "[iU]/mL";
	public static final String KiloInternationalUnitsPerMilliLiter_Arbitrary_Concentration_Units_CODE = "k[iU]/mL";
	public static final String InternationalUnitsPerDeciLiter_Arbitrary_Concentration_Units_CODE = "[iU]/dL";
	public static final String EhrlichUnitsPerDeciLiter_Arbitrary_Concentration_Units_CODE = "{Ehrlich_U}/dL";
	public static final String MilliInternationalUnitsPerLiter_Arbitrary_Concentration_Units_CODE = "m[iU]/L";
	public static final String InternationalUnitsPerLiter_Arbitrary_Concentration_Units_CODE = "[iU]/L";
	public static final String pH_pH_Units_CODE = "[pH]";

	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.8";
	public static final String CODE_SYSTEM_NAME = "UCUM - Unified Code for Units of Measure";

	private String code;
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div>
	 */
	private Ucum(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div> <div
	 * class="de">Liefert den eigentlichen Code als String</div>
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
	public String getdisplayName() {
		return this.displayName;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static Ucum getEnum(String code) {
		for (Ucum x : values()) {
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
	 * <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets
	 * vorhanden ist.</div>
	 *
	 * @param codeValue
	 * <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (Ucum x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
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
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

}