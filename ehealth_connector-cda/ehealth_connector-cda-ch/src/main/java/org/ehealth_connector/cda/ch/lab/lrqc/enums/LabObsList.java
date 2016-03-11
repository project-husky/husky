package org.ehealth_connector.cda.ch.lab.lrqc.enums;

import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Liste der Laborbeobachtungen für die externe obligatorische Qualitätskontrolle</div>
*<div class="fr"></div>
*/
public enum LabObsList {

	/**
	 * <div class="en">5-Fluorocytosine [Susceptibility]</div>
	 */
	_5_FLUOROCYTOSINE_SUSCEPTIBILITY("18855-7", "5-Fluorocytosine [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">ABO and Rh group [Type] in Blood</div>
	 */
	ABO_AND_RH_GROUP_TYPE_IN_BLOOD("882-1", "ABO and Rh group [Type] in Blood", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Activated partial thromboplastin time (aPTT) in Blood by
	 * Coagulation assay</div>
	 */
	ACTIVATED_PARTIAL_THROMBOPLASTIN_TIME_APTT_IN_BLOOD_BY_COAGULATION_ASSAY("3173-2", "Activated partial thromboplastin time (aPTT) in Blood by Coagulation assay", "18720-3", "20150101", ""),
	/**
	 * <div class="en">Alanine aminotransferase [Enzymatic activity/volume] in
	 * Serum or Plasma</div>
	 */
	ALANINE_AMINOTRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("1742-6", "Alanine aminotransferase [Enzymatic activity/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Albumin [Mass/volume] in Serum or Plasma</div>
	 */
	ALBUMIN_MASSVOLUME_IN_SERUM_OR_PLASMA("1751-7", "Albumin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Albumin [Mass/?volume] in Serum or Plasma by Bromocresol
	 * green (BCG) dye binding method</div>
	 */
	ALBUMIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_BROMOCRESOL_GREEN_BCG_DYE_BINDING_METHOD("61151-7", "Albumin [Mass/?volume] in Serum or Plasma by Bromocresol green (BCG) dye binding method", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Albumin [Mass/?volume] in Serum or Plasma by Bromocresol
	 * purple (BCP) dye binding method</div>
	 */
	ALBUMIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_BROMOCRESOL_PURPLE_BCP_DYE_BINDING_METHOD("61152-5", "Albumin [Mass/?volume] in Serum or Plasma by Bromocresol purple (BCP) dye binding method", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Albumin [Moles/volume] in Serum or Plasma</div>
	 */
	ALBUMIN_MOLESVOLUME_IN_SERUM_OR_PLASMA("54347-0", "Albumin [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Alkaline phosphatase [Enzymatic activity/volume] in Serum
	 * or Plasma</div>
	 */
	ALKALINE_PHOSPHATASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("6768-6", "Alkaline phosphatase [Enzymatic activity/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Alpha-1-Fetoprotein [Mass/volume] in Serum or Plasma</div>
	 */
	ALPHA_1_FETOPROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA("1834-1", "Alpha-1-Fetoprotein [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Alpha-1-Fetoprotein [Moles/?volume] in Serum or
	 * Plasma</div>
	 */
	ALPHA_1_FETOPROTEIN_MOLESVOLUME_IN_SERUM_OR_PLASMA("19177-5", "Alpha-1-Fetoprotein [Moles/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Alpha-1-Fetoprotein [Units/volume] in Serum or Plasma</div>
	 */
	ALPHA_1_FETOPROTEIN_UNITSVOLUME_IN_SERUM_OR_PLASMA("19176-7", "Alpha-1-Fetoprotein [Units/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Amitriptyline [Mass/volume] in Serum or Plasma</div>
	 */
	AMITRIPTYLINE_MASSVOLUME_IN_SERUM_OR_PLASMA("3333-2", "Amitriptyline [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Amitriptyline [Moles/volume] in Serum or Plasma</div>
	 */
	AMITRIPTYLINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14597-9", "Amitriptyline [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Amitriptyline+Nortriptyline [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	AMITRIPTYLINE_NORTRIPTYLINE_MASSVOLUME_IN_SERUM_OR_PLASMA("3335-7", "Amitriptyline+Nortriptyline [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Amitriptyline+Nortriptyline [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	AMITRIPTYLINE_NORTRIPTYLINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14598-7", "Amitriptyline+Nortriptyline [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Amphetamines [Presence] in Urine</div>
	 */
	AMPHETAMINES_PRESENCE_IN_URINE("3349-8", "Amphetamines [Presence] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Amphetamines [Presence] in Urine by Screen method</div>
	 */
	AMPHETAMINES_PRESENCE_IN_URINE_BY_SCREEN_METHOD("19261-7", "Amphetamines [Presence] in Urine by Screen method", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Amphotericin B [Susceptibility]</div>
	 */
	AMPHOTERICIN_B_SUSCEPTIBILITY("18863-1", "Amphotericin B [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Amylase [Enzymatic activity/?volume] in Serum or
	 * Plasma</div>
	 */
	AMYLASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("1798-8", "Amylase [Enzymatic activity/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Amylase.pancreatic [Enzymatic activity/volume] in Serum or
	 * Plasma</div>
	 */
	AMYLASE_PANCREATIC_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("1805-1", "Amylase.pancreatic [Enzymatic activity/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Anidulafungin [Susceptibility]</div>
	 */
	ANIDULAFUNGIN_SUSCEPTIBILITY("57095-2", "Anidulafungin [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Antidepressants [Identifier] in Serum or Plasma</div>
	 */
	ANTIDEPRESSANTS_IDENTIFIER_IN_SERUM_OR_PLASMA("16389-9", "Antidepressants [Identifier] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Appearance of Urine</div>
	 */
	APPEARANCE_OF_URINE("5767-9", "Appearance of Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Aspartate aminotransferase [Enzymatic activity/?volume] in
	 * Serum or Plasma</div>
	 */
	ASPARTATE_AMINOTRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("1920-8", "Aspartate aminotransferase [Enzymatic activity/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Bacteria [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	BACTERIA_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT("33218-9", "Bacteria [#/area] in Urine sediment by Automated count", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Bacteria identified in Urine by Culture</div>
	 */
	BACTERIA_IDENTIFIED_IN_URINE_BY_CULTURE("630-4", "Bacteria identified in Urine by Culture", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Bacteria [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	BACTERIA_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("25145-4", "Bacteria [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Barbiturates [Presence] in Serum or Plasma by Screen
	 * method</div>
	 */
	BARBITURATES_PRESENCE_IN_SERUM_OR_PLASMA_BY_SCREEN_METHOD("20421-4", "Barbiturates [Presence] in Serum or Plasma by Screen method", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Barbiturates [Presence] in Serum, Plasma or Blood</div>
	 */
	BARBITURATES_PRESENCE_IN_SERUM_PLASMA_OR_BLOOD("3376-1", "Barbiturates [Presence] in Serum, Plasma or Blood", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Barbiturates [Presence] in Urine</div>
	 */
	BARBITURATES_PRESENCE_IN_URINE("3377-9", "Barbiturates [Presence] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Barbiturates [Presence] in Urine by Screen method</div>
	 */
	BARBITURATES_PRESENCE_IN_URINE_BY_SCREEN_METHOD("19270-8", "Barbiturates [Presence] in Urine by Screen method", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Basophils/?100 leukocytes in Blood by Manual count</div>
	 */
	BASOPHILS100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("707-0", "Basophils/?100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Benzodiazepines [Presence] in Serum or Plasma</div>
	 */
	BENZODIAZEPINES_PRESENCE_IN_SERUM_OR_PLASMA("3389-4", "Benzodiazepines [Presence] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Benzodiazepines [Presence] in Urine</div>
	 */
	BENZODIAZEPINES_PRESENCE_IN_URINE("3390-2", "Benzodiazepines [Presence] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Benzodiazepines [Presence] in Urine by Screen method</div>
	 */
	BENZODIAZEPINES_PRESENCE_IN_URINE_BY_SCREEN_METHOD("14316-4", "Benzodiazepines [Presence] in Urine by Screen method", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Bg sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	BG_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA("57902-9", "Bg sup(a) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Bilirubin.total [Mass/volume] in Serum or Plasma</div>
	 */
	BILIRUBIN_TOTAL_MASSVOLUME_IN_SERUM_OR_PLASMA("1975-2", "Bilirubin.total [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Bilirubin.total [Moles/volume] in Serum or Plasma</div>
	 */
	BILIRUBIN_TOTAL_MOLESVOLUME_IN_SERUM_OR_PLASMA("14631-6", "Bilirubin.total [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Bilirubin.total [Presence] in Urine by Automated test
	 * strip</div>
	 */
	BILIRUBIN_TOTAL_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP("50551-1", "Bilirubin.total [Presence] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Bilirubin.total [Presence] in Urine by Test strip</div>
	 */
	BILIRUBIN_TOTAL_PRESENCE_IN_URINE_BY_TEST_STRIP("5770-3", "Bilirubin.total [Presence] in Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Blasts/?100 leukocytes in Blood by Manual count</div>
	 */
	BLASTS100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("709-6", "Blasts/?100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Blood group antibodies identified in Serum or Plasma</div>
	 */
	BLOOD_GROUP_ANTIBODIES_IDENTIFIED_IN_SERUM_OR_PLASMA("888-8", "Blood group antibodies identified in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Blood group antibody screen [Presence] in Serum or
	 * Plasma</div>
	 */
	BLOOD_GROUP_ANTIBODY_SCREEN_PRESENCE_IN_SERUM_OR_PLASMA("890-4", "Blood group antibody screen [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">C reactive protein [Mass/volume] in Serum or Plasma</div>
	 */
	C_REACTIVE_PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA("1988-5", "C reactive protein [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">C reactive protein [Mass/?volume] in Serum or Plasma by
	 * High sensitivity method</div>
	 */
	C_REACTIVE_PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_HIGH_SENSITIVITY_METHOD("30522-7", "C reactive protein [Mass/?volume] in Serum or Plasma by High sensitivity method", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Calcidiol [Mass/volume] in Serum or Plasma</div>
	 */
	CALCIDIOL_MASSVOLUME_IN_SERUM_OR_PLASMA("1989-3", "Calcidiol [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Calcidiol [Moles/volume] in Serum or Plasma</div>
	 */
	CALCIDIOL_MOLESVOLUME_IN_SERUM_OR_PLASMA("14635-7", "Calcidiol [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Calcium [Mass/?volume] in Serum or Plasma</div>
	 */
	CALCIUM_MASSVOLUME_IN_SERUM_OR_PLASMA("17861-6", "Calcium [Mass/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Calcium [Moles/?volume] in Serum or Plasma</div>
	 */
	CALCIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("2000-8", "Calcium [Moles/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Calcium oxalate crystals [Presence] in Urine sediment by
	 * Light microscopy</div>
	 */
	CALCIUM_OXALATE_CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("5774-5", "Calcium oxalate crystals [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Cannabinoids [Presence] in Urine</div>
	 */
	CANNABINOIDS_PRESENCE_IN_URINE("3427-2", "Cannabinoids [Presence] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Cannabinoids [Presence] in Urine by Screen method</div>
	 */
	CANNABINOIDS_PRESENCE_IN_URINE_BY_SCREEN_METHOD("18282-4", "Cannabinoids [Presence] in Urine by Screen method", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Carbon dioxide [Partial pressure] in Blood</div>
	 */
	CARBON_DIOXIDE_PARTIAL_PRESSURE_IN_BLOOD("11557-6", "Carbon dioxide [Partial pressure] in Blood", "18767-4", "20150101", ""),
	/**
	 * <div class="en">Carbon dioxide [Partial pressure] in Venous blood</div>
	 */
	CARBON_DIOXIDE_PARTIAL_PRESSURE_IN_VENOUS_BLOOD("2021-4", "Carbon dioxide [Partial pressure] in Venous blood", "18767-4", "20150101", ""),
	/**
	 * <div class="en">Carcinoembryonic Ag [Mass/volume] in Serum or Plasma</div>
	 */
	CARCINOEMBRYONIC_AG_MASSVOLUME_IN_SERUM_OR_PLASMA("2039-6", "Carcinoembryonic Ag [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Carcinoembryonic Ag [Moles/volume] in Serum or Plasma</div>
	 */
	CARCINOEMBRYONIC_AG_MOLESVOLUME_IN_SERUM_OR_PLASMA("19167-6", "Carcinoembryonic Ag [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Carcinoembryonic Ag [Units/volume] in Serum or Plasma</div>
	 */
	CARCINOEMBRYONIC_AG_UNITSVOLUME_IN_SERUM_OR_PLASMA("19166-8", "Carcinoembryonic Ag [Units/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Caspofungin [Susceptibility]</div>
	 */
	CASPOFUNGIN_SUSCEPTIBILITY("32378-2", "Caspofungin [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Cat dander IgE Ab RAST class [Presence] in Serum</div>
	 */
	CAT_DANDER_IGE_AB_RAST_CLASS_PRESENCE_IN_SERUM("15609-1", "Cat dander IgE Ab RAST class [Presence] in Serum", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cat dander IgE Ab [Units/volume] in Serum</div>
	 */
	CAT_DANDER_IGE_AB_UNITSVOLUME_IN_SERUM("6833-8", "Cat dander IgE Ab [Units/volume] in Serum", "18719-5", "20150101", ""),
	/**
	 * <div class="en">CD16+CD56+ cells [#/volume] in Blood</div>
	 */
	CD16_CD56_CELLS_VOLUME_IN_BLOOD("20402-4", "CD16+CD56+ cells [#/volume] in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD16+CD56+ cells/100 cells in Blood</div>
	 */
	CD16_CD56_CELLS100_CELLS_IN_BLOOD("18267-5", "CD16+CD56+ cells/100 cells in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD19 cells [#/volume] in Blood</div>
	 */
	CD19_CELLS_VOLUME_IN_BLOOD("8116-6", "CD19 cells [#/volume] in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD19 cells/100 cells in Blood</div>
	 */
	CD19_CELLS100_CELLS_IN_BLOOD("8117-4", "CD19 cells/100 cells in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD3+CD4+ (T4 helper) cells [#/volume] in Blood</div>
	 */
	CD3_CD4_T4_HELPER_CELLS_VOLUME_IN_BLOOD("24467-3", "CD3+CD4+ (T4 helper) cells [#/volume] in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD3+CD4+ (T4 helper) cells/100 cells in Blood</div>
	 */
	CD3_CD4_T4_HELPER_CELLS100_CELLS_IN_BLOOD("8123-2", "CD3+CD4+ (T4 helper) cells/100 cells in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD3+CD4+ (T4 helper) cells/CD3+CD8+ (T8 suppressor cells)
	 * cells [# Ratio] in Blood</div>
	 */
	CD3_CD4_T4_HELPER_CELLSCD3_CD8_T8_SUPPRESSOR_CELLS_CELLS_RATIO_IN_BLOOD("54218-3", "CD3+CD4+ (T4 helper) cells/CD3+CD8+ (T8 suppressor cells) cells [# Ratio] in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD3+CD8+ (T8 suppressor cells) cells [#/volume] in
	 * Blood</div>
	 */
	CD3_CD8_T8_SUPPRESSOR_CELLS_CELLS_VOLUME_IN_BLOOD("14135-8", "CD3+CD8+ (T8 suppressor cells) cells [#/volume] in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD3+CD8+ (T8 suppressor cells) cells/100 cells in
	 * Blood</div>
	 */
	CD3_CD8_T8_SUPPRESSOR_CELLS_CELLS100_CELLS_IN_BLOOD("8101-8", "CD3+CD8+ (T8 suppressor cells) cells/100 cells in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD3 cells [#/volume] in Blood</div>
	 */
	CD3_CELLS_VOLUME_IN_BLOOD("8122-4", "CD3 cells [#/volume] in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">CD3 cells/100 cells in Blood</div>
	 */
	CD3_CELLS100_CELLS_IN_BLOOD("8124-0", "CD3 cells/100 cells in Blood", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Chlamydia trachomatis DNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("21613-5", "Chlamydia trachomatis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Chloride [Moles/volume] in Serum or Plasma</div>
	 */
	CHLORIDE_MOLESVOLUME_IN_SERUM_OR_PLASMA("2075-0", "Chloride [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cholecalciferol (Vit D3) [Mass/?volume] in Serum or
	 * Plasma</div>
	 */
	CHOLECALCIFEROL_VIT_D3_MASSVOLUME_IN_SERUM_OR_PLASMA("1990-1", "Cholecalciferol (Vit D3) [Mass/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cholecalciferol (Vit D3) [Moles/?volume] in Serum or
	 * Plasma</div>
	 */
	CHOLECALCIFEROL_VIT_D3_MOLESVOLUME_IN_SERUM_OR_PLASMA("33958-0", "Cholecalciferol (Vit D3) [Moles/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cholesterol in HDL [Mass/volume] in Serum or Plasma</div>
	 */
	CHOLESTEROL_IN_HDL_MASSVOLUME_IN_SERUM_OR_PLASMA("2085-9", "Cholesterol in HDL [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cholesterol in HDL [Moles/volume] in Serum or Plasma</div>
	 */
	CHOLESTEROL_IN_HDL_MOLESVOLUME_IN_SERUM_OR_PLASMA("14646-4", "Cholesterol in HDL [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cholesterol [Mass/volume] in Serum or Plasma</div>
	 */
	CHOLESTEROL_MASSVOLUME_IN_SERUM_OR_PLASMA("2093-3", "Cholesterol [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cholesterol [Moles/volume] in Serum or Plasma</div>
	 */
	CHOLESTEROL_MOLESVOLUME_IN_SERUM_OR_PLASMA("14647-2", "Cholesterol [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Choriogonadotropin.beta subunit free [Moles/?volume] in
	 * Serum or Plasma</div>
	 */
	CHORIOGONADOTROPIN_BETA_SUBUNIT_FREE_MOLESVOLUME_IN_SERUM_OR_PLASMA("2115-4", "Choriogonadotropin.beta subunit free [Moles/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Choriogonadotropin.beta subunit [Units/?volume] in Serum or
	 * Plasma</div>
	 */
	CHORIOGONADOTROPIN_BETA_SUBUNIT_UNITSVOLUME_IN_SERUM_OR_PLASMA("21198-7", "Choriogonadotropin.beta subunit [Units/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Choriogonadotropin [Mass/volume] in Serum or Plasma</div>
	 */
	CHORIOGONADOTROPIN_MASSVOLUME_IN_SERUM_OR_PLASMA("34670-0", "Choriogonadotropin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Choriogonadotropin [Moles/volume] in Serum or Plasma</div>
	 */
	CHORIOGONADOTROPIN_MOLESVOLUME_IN_SERUM_OR_PLASMA("2119-6", "Choriogonadotropin [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Choriogonadotropin [Units/volume] in Serum or Plasma</div>
	 */
	CHORIOGONADOTROPIN_UNITSVOLUME_IN_SERUM_OR_PLASMA("19080-1", "Choriogonadotropin [Units/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Chromosome analysis.interphase [interpretation] in
	 * Unspecified specimen by Fluorescent in situ hybridization (FISH)
	 * Narrative</div>
	 */
	CHROMOSOME_ANALYSIS_INTERPHASE_INTERPRETATION_IN_UNSPECIFIED_SPECIMEN_BY_FLUORESCENT_IN_SITU_HYBRIDIZATION_FISH_NARRATIVE("59050-5", "Chromosome analysis.interphase [interpretation] in Unspecified specimen by Fluorescent in situ hybridization (FISH) Narrative", "26435-8", "20150101", ""),
	/**
	 * <div class="en">Chromosome analysis master panel - Blood or Tissue</div>
	 */
	CHROMOSOME_ANALYSIS_MASTER_PANEL_BLOOD_OR_TISSUE("62389-2", "Chromosome analysis master panel - Blood or Tissue", "26435-8", "20150101", ""),
	/**
	 * <div class="en">Chromosome analysis.metaphase panel - Blood by Fluorescent
	 * in situ hybridization (FISH)</div>
	 */
	CHROMOSOME_ANALYSIS_METAPHASE_PANEL_BLOOD_BY_FLUORESCENT_IN_SITU_HYBRIDIZATION_FISH("62344-7", "Chromosome analysis.metaphase panel - Blood by Fluorescent in situ hybridization (FISH)", "26435-8", "20150101", ""),
	/**
	 * <div class="en">Chromosome [Identifier] in Blood or Tissue by Molecular
	 * genetics method</div>
	 */
	CHROMOSOME_IDENTIFIER_IN_BLOOD_OR_TISSUE_BY_MOLECULAR_GENETICS_METHOD("48000-4", "Chromosome [Identifier] in Blood or Tissue by Molecular genetics method", "26435-8", "20150101", ""),
	/**
	 * <div class="en">Clarity of Urine</div>
	 */
	CLARITY_OF_URINE("32167-9", "Clarity of Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Clostridium difficile DNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	CLOSTRIDIUM_DIFFICILE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("61367-9", "Clostridium difficile DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Coarse Granular Casts [#/area] in Urine sediment by
	 * Automated count</div>
	 */
	COARSE_GRANULAR_CASTS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT("33227-0", "Coarse Granular Casts [#/area] in Urine sediment by Automated count", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Coarse Granular Casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	COARSE_GRANULAR_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("32175-2", "Coarse Granular Casts [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Cobalamin (Vitamin B12) [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	COBALAMIN_VITAMIN_B12_MASSVOLUME_IN_SERUM_OR_PLASMA("2132-9", "Cobalamin (Vitamin B12) [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cobalamin (Vitamin B12) [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	COBALAMIN_VITAMIN_B12_MOLESVOLUME_IN_SERUM_OR_PLASMA("14685-2", "Cobalamin (Vitamin B12) [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cocaine [Presence] in Urine</div>
	 */
	COCAINE_PRESENCE_IN_URINE("3397-7", "Cocaine [Presence] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Cocaine [Presence] in Urine by Screen method</div>
	 */
	COCAINE_PRESENCE_IN_URINE_BY_SCREEN_METHOD("19359-9", "Cocaine [Presence] in Urine by Screen method", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Cortisol [Mass/volume] in Serum or Plasma</div>
	 */
	CORTISOL_MASSVOLUME_IN_SERUM_OR_PLASMA("2143-6", "Cortisol [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Cortisol [Moles/volume] in Serum or Plasma</div>
	 */
	CORTISOL_MOLESVOLUME_IN_SERUM_OR_PLASMA("14675-3", "Cortisol [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Creatine kinase [Enzymatic activity/volume] in Serum or
	 * Plasma</div>
	 */
	CREATINE_KINASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("2157-6", "Creatine kinase [Enzymatic activity/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Creatinine [Mass/volume] in Serum or Plasma</div>
	 */
	CREATININE_MASSVOLUME_IN_SERUM_OR_PLASMA("2160-0", "Creatinine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Creatinine [Mass/volume] in Urine</div>
	 */
	CREATININE_MASSVOLUME_IN_URINE("2161-8", "Creatinine [Mass/volume] in Urine", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Creatinine [Moles/volume] in Serum or Plasma</div>
	 */
	CREATININE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14682-9", "Creatinine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Creatinine [Moles/volume] in Urine</div>
	 */
	CREATININE_MOLESVOLUME_IN_URINE("14683-7", "Creatinine [Moles/volume] in Urine", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Crystals.amorphous [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	CRYSTALS_AMORPHOUS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("60340-7", "Crystals.amorphous [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Crystals [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	CRYSTALS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT("53322-4", "Crystals [#/area] in Urine sediment by Automated count", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Crystals [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("49755-2", "Crystals [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Cyclic citrullinated peptide Ab [Units/?volume] in
	 * Serum</div>
	 */
	CYCLIC_CITRULLINATED_PEPTIDE_AB_UNITSVOLUME_IN_SERUM("53027-9", "Cyclic citrullinated peptide Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cyclic citrullinated peptide Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	CYCLIC_CITRULLINATED_PEPTIDE_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("32218-0", "Cyclic citrullinated peptide Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cyclic citrullinated peptide IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	CYCLIC_CITRULLINATED_PEPTIDE_IGG_AB_UNITSVOLUME_IN_SERUM("33935-8", "Cyclic citrullinated peptide IgG Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cystine crystals [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	CYSTINE_CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("5784-4", "Cystine crystals [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus Ab [Presence] in Serum</div>
	 */
	CYTOMEGALOVIRUS_AB_PRESENCE_IN_SERUM("22239-8", "Cytomegalovirus Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus DNA [Units/?volume] (viral load) in Plasma
	 * by Probe and target amplification method</div>
	 */
	CYTOMEGALOVIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("72493-0", "Cytomegalovirus DNA [Units/?volume] (viral load) in Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus DNA [#/?volume] (viral load) in Serum or
	 * Plasma by Probe and target amplification method</div>
	 */
	CYTOMEGALOVIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("30247-1", "Cytomegalovirus DNA [#/?volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus IgG Ab [Presence] in Serum</div>
	 */
	CYTOMEGALOVIRUS_IGG_AB_PRESENCE_IN_SERUM("22244-8", "Cytomegalovirus IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	CYTOMEGALOVIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("13949-3", "Cytomegalovirus IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus IgG Ab [Units/?volume] in Serum</div>
	 */
	CYTOMEGALOVIRUS_IGG_AB_UNITSVOLUME_IN_SERUM("7852-7", "Cytomegalovirus IgG Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus IgG Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	CYTOMEGALOVIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5124-3", "Cytomegalovirus IgG Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus IgM Ab [Presence] in Serum</div>
	 */
	CYTOMEGALOVIRUS_IGM_AB_PRESENCE_IN_SERUM("30325-5", "Cytomegalovirus IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	CYTOMEGALOVIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("24119-0", "Cytomegalovirus IgM Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus IgM Ab [Units/?volume] in Serum</div>
	 */
	CYTOMEGALOVIRUS_IGM_AB_UNITSVOLUME_IN_SERUM("7853-5", "Cytomegalovirus IgM Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Cytomegalovirus IgM Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	CYTOMEGALOVIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5126-8", "Cytomegalovirus IgM Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">D Ab [Presence] in Serum or Plasma</div>
	 */
	D_AB_PRESENCE_IN_SERUM_OR_PLASMA("975-3", "D Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Desipramine [Mass/volume] in Serum or Plasma</div>
	 */
	DESIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA("3531-1", "Desipramine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Desipramine [Moles/volume] in Serum or Plasma</div>
	 */
	DESIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14691-0", "Desipramine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Digoxin [Mass/volume] in Serum or Plasma</div>
	 */
	DIGOXIN_MASSVOLUME_IN_SERUM_OR_PLASMA("10535-3", "Digoxin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Digoxin [Moles/volume] in Serum or Plasma</div>
	 */
	DIGOXIN_MOLESVOLUME_IN_SERUM_OR_PLASMA("14698-5", "Digoxin [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">E Ab [Presence] in Serum or Plasma</div>
	 */
	E_AB_PRESENCE_IN_SERUM_OR_PLASMA("1018-1", "E Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Enterovirus RNA [Presence] in Unspecified specimen by Probe
	 * and target amplification method</div>
	 */
	ENTEROVIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("29591-5", "Enterovirus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Eosinophils/?100 leukocytes in Blood by Manual count</div>
	 */
	EOSINOPHILS100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("714-6", "Eosinophils/?100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Epithelial cells [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	EPITHELIAL_CELLS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT("33342-7", "Epithelial cells [#/area] in Urine sediment by Automated count", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Epithelial cells [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	EPITHELIAL_CELLS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("20453-7", "Epithelial cells [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Epithelial cells.renal [#/?volume] in Urine sediment</div>
	 */
	EPITHELIAL_CELLS_RENAL_VOLUME_IN_URINE_SEDIMENT("13653-1", "Epithelial cells.renal [#/?volume] in Urine sediment", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Epithelial cells.squamous [#/?volume] in Urine
	 * sediment</div>
	 */
	EPITHELIAL_CELLS_SQUAMOUS_VOLUME_IN_URINE_SEDIMENT("13654-9", "Epithelial cells.squamous [#/?volume] in Urine sediment", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus capsid IgG Ab [Presence] in Serum</div>
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_PRESENCE_IN_SERUM("30339-6", "Epstein Barr virus capsid IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus capsid IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("24114-1", "Epstein Barr virus capsid IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus capsid IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_UNITSVOLUME_IN_SERUM("7885-7", "Epstein Barr virus capsid IgG Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus capsid IgG Ab [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5157-3", "Epstein Barr virus capsid IgG Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus capsid IgM Ab [Presence] in Serum</div>
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_PRESENCE_IN_SERUM("30340-4", "Epstein Barr virus capsid IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus capsid IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("24115-8", "Epstein Barr virus capsid IgM Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus capsid IgM Ab [Units/?volume] in
	 * Serum</div>
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_UNITSVOLUME_IN_SERUM("7886-5", "Epstein Barr virus capsid IgM Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus capsid IgM Ab [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5159-9", "Epstein Barr virus capsid IgM Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus DNA [#/?volume] (viral load) in Serum or
	 * Plasma by Probe and target amplification method</div>
	 */
	EPSTEIN_BARR_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("47982-4", "Epstein Barr virus DNA [#/?volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus DNA [#/?volume] (viral load) in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	EPSTEIN_BARR_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("32585-2", "Epstein Barr virus DNA [#/?volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus early IgG Ab [Presence] in Serum</div>
	 */
	EPSTEIN_BARR_VIRUS_EARLY_IGG_AB_PRESENCE_IN_SERUM("22295-0", "Epstein Barr virus early IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus early IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	EPSTEIN_BARR_VIRUS_EARLY_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("40752-8", "Epstein Barr virus early IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus early IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	EPSTEIN_BARR_VIRUS_EARLY_IGG_AB_UNITSVOLUME_IN_SERUM("24007-7", "Epstein Barr virus early IgG Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus nuclear IgG Ab [Presence] in Serum</div>
	 */
	EPSTEIN_BARR_VIRUS_NUCLEAR_IGG_AB_PRESENCE_IN_SERUM("7883-2", "Epstein Barr virus nuclear IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus nuclear IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	EPSTEIN_BARR_VIRUS_NUCLEAR_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("5156-5", "Epstein Barr virus nuclear IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus nuclear IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	EPSTEIN_BARR_VIRUS_NUCLEAR_IGG_AB_UNITSVOLUME_IN_SERUM("31374-2", "Epstein Barr virus nuclear IgG Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Epstein Barr virus nuclear IgG Ab [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	EPSTEIN_BARR_VIRUS_NUCLEAR_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("30083-0", "Epstein Barr virus nuclear IgG Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Erythrocytes [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	ERYTHROCYTES_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT("46419-8", "Erythrocytes [#/area] in Urine sediment by Automated count", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Erythrocytes [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	ERYTHROCYTES_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("32776-7", "Erythrocytes [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Erythrocytes [#/?volume] in Blood by Automated count</div>
	 */
	ERYTHROCYTES_VOLUME_IN_BLOOD_BY_AUTOMATED_COUNT("789-8", "Erythrocytes [#/?volume] in Blood by Automated count", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Erythrocytes [#/volume] in Blood by Manual count</div>
	 */
	ERYTHROCYTES_VOLUME_IN_BLOOD_BY_MANUAL_COUNT("790-6", "Erythrocytes [#/volume] in Blood by Manual count", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Erythrocytes [#/volume] in Urine by Automated test
	 * strip</div>
	 */
	ERYTHROCYTES_VOLUME_IN_URINE_BY_AUTOMATED_TEST_STRIP("57747-8", "Erythrocytes [#/volume] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Erythrocytes [#/volume] in Urine by Test strip</div>
	 */
	ERYTHROCYTES_VOLUME_IN_URINE_BY_TEST_STRIP("20409-9", "Erythrocytes [#/volume] in Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Erythrocytes [#/?volume] in Urine sediment by Microscopy
	 * high power field</div>
	 */
	ERYTHROCYTES_VOLUME_IN_URINE_SEDIMENT_BY_MICROSCOPY_HIGH_POWER_FIELD("5808-1", "Erythrocytes [#/?volume] in Urine sediment by Microscopy high power field", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Estradiol (E2) [Mass/volume] in Serum or Plasma</div>
	 */
	ESTRADIOL_E2_MASSVOLUME_IN_SERUM_OR_PLASMA("2243-4", "Estradiol (E2) [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Estradiol (E2) [Moles/volume] in Serum or Plasma</div>
	 */
	ESTRADIOL_E2_MOLESVOLUME_IN_SERUM_OR_PLASMA("14715-7", "Estradiol (E2) [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Ethambutol 10 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ETHAMBUTOL_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25195-9", "Ethambutol 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Ethambutol 2.5 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ETHAMBUTOL_2_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25230-4", "Ethambutol 2.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Ethambutol 2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ETHAMBUTOL_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("55674-6", "Ethambutol 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Ethambutol 5 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ETHAMBUTOL_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25194-2", "Ethambutol 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Ethambutol 7.5 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ETHAMBUTOL_7_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25187-6", "Ethambutol 7.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Ethambutol 8 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ETHAMBUTOL_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("56025-0", "Ethambutol 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Ethambutol+Rifampin [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ETHAMBUTOL_RIFAMPIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("55154-9", "Ethambutol+Rifampin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Ethambutol [Susceptibility] by Method for Slow-growing
	 * mycobacteria</div>
	 */
	ETHAMBUTOL_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("20381-0", "Ethambutol [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Ferritin [Mass/volume] in Serum or Plasma</div>
	 */
	FERRITIN_MASSVOLUME_IN_SERUM_OR_PLASMA("2276-4", "Ferritin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Fibrin D-dimer FEU [Mass/volume] in Platelet poor
	 * plasma</div>
	 */
	FIBRIN_D_DIMER_FEU_MASSVOLUME_IN_PLATELET_POOR_PLASMA("48065-7", "Fibrin D-dimer FEU [Mass/volume] in Platelet poor plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Fibrin D-dimer FEU [Mass/volume] in Platelet poor plasma by
	 * Immunoassay</div>
	 */
	FIBRIN_D_DIMER_FEU_MASSVOLUME_IN_PLATELET_POOR_PLASMA_BY_IMMUNOASSAY("48067-3", "Fibrin D-dimer FEU [Mass/volume] in Platelet poor plasma by Immunoassay", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Fibrin D-dimer [Presence] in Platelet poor plasma</div>
	 */
	FIBRIN_D_DIMER_PRESENCE_IN_PLATELET_POOR_PLASMA("15179-5", "Fibrin D-dimer [Presence] in Platelet poor plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Fibrinogen [Mass/volume] in Platelet poor plasma by
	 * Coagulation assay</div>
	 */
	FIBRINOGEN_MASSVOLUME_IN_PLATELET_POOR_PLASMA_BY_COAGULATION_ASSAY("3255-7", "Fibrinogen [Mass/volume] in Platelet poor plasma by Coagulation assay", "18720-3", "20150101", ""),
	/**
	 * <div class="en">Fine Granular Casts [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	FINE_GRANULAR_CASTS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT("33225-4", "Fine Granular Casts [#/area] in Urine sediment by Automated count", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Fine Granular Casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	FINE_GRANULAR_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("32176-0", "Fine Granular Casts [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Fluconazole [Susceptibility]</div>
	 */
	FLUCONAZOLE_SUSCEPTIBILITY("18924-1", "Fluconazole [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Fluoxetine [Mass/volume] in Serum or Plasma</div>
	 */
	FLUOXETINE_MASSVOLUME_IN_SERUM_OR_PLASMA("3644-2", "Fluoxetine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Fluoxetine [Moles/volume] in Serum or Plasma</div>
	 */
	FLUOXETINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14728-0", "Fluoxetine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Fluoxetine+Norfluoxetine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	FLUOXETINE_NORFLUOXETINE_MASSVOLUME_IN_SERUM_OR_PLASMA("10339-0", "Fluoxetine+Norfluoxetine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Folate [Mass/volume] in Serum or Plasma</div>
	 */
	FOLATE_MASSVOLUME_IN_SERUM_OR_PLASMA("2284-8", "Folate [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Folate [Moles/volume] in Serum or Plasma</div>
	 */
	FOLATE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14732-2", "Folate [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Follitropin [Units/volume] in Serum or Plasma</div>
	 */
	FOLLITROPIN_UNITSVOLUME_IN_SERUM_OR_PLASMA("15067-2", "Follitropin [Units/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Fungus identified in Unspecified specimen by Culture</div>
	 */
	FUNGUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE("580-1", "Fungus identified in Unspecified specimen by Culture", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Fy sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	FY_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA("1024-9", "Fy sup(a) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Fy sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	FY_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA("1030-6", "Fy sup(b) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Gamma glutamyl transferase [Enzymatic activity/volume] in
	 * Serum or Plasma</div>
	 */
	GAMMA_GLUTAMYL_TRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("2324-2", "Gamma glutamyl transferase [Enzymatic activity/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Glucose [Mass/volume] in Serum or Plasma</div>
	 */
	GLUCOSE_MASSVOLUME_IN_SERUM_OR_PLASMA("2345-7", "Glucose [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Glucose [Moles/volume] in Serum or Plasma</div>
	 */
	GLUCOSE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14749-6", "Glucose [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Glucose [Presence] in Urine by Automated test strip</div>
	 */
	GLUCOSE_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP("50555-2", "Glucose [Presence] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Glucose [Presence] in Urine by Test strip</div>
	 */
	GLUCOSE_PRESENCE_IN_URINE_BY_TEST_STRIP("25428-4", "Glucose [Presence] in Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Granular casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	GRANULAR_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("25160-3", "Granular casts [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">H Ab [Presence] in Serum</div>
	 */
	H_AB_PRESENCE_IN_SERUM("1044-7", "H Ab [Presence] in Serum", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Hematocrit [Volume Fraction] of Blood</div>
	 */
	HEMATOCRIT_VOLUME_FRACTION_OF_BLOOD("20570-8", "Hematocrit [Volume Fraction] of Blood", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Hemoglobin A1c [Mass/?volume] in Blood</div>
	 */
	HEMOGLOBIN_A1C_MASSVOLUME_IN_BLOOD("41995-2", "Hemoglobin A1c [Mass/?volume] in Blood", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Hemoglobin A1c/Hemoglobin.total in Blood</div>
	 */
	HEMOGLOBIN_A1CHEMOGLOBIN_TOTAL_IN_BLOOD("4548-4", "Hemoglobin A1c/Hemoglobin.total in Blood", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Hemoglobin A1c/Hemoglobin.total in Blood by HPLC</div>
	 */
	HEMOGLOBIN_A1CHEMOGLOBIN_TOTAL_IN_BLOOD_BY_HPLC("17856-6", "Hemoglobin A1c/Hemoglobin.total in Blood by HPLC", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Hemoglobin A1c/Hemoglobin.total in Blood by IFCC
	 * protocol</div>
	 */
	HEMOGLOBIN_A1CHEMOGLOBIN_TOTAL_IN_BLOOD_BY_IFCC_PROTOCOL("59261-8", "Hemoglobin A1c/Hemoglobin.total in Blood by IFCC protocol", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Hemoglobin [Mass/volume] in Blood</div>
	 */
	HEMOGLOBIN_MASSVOLUME_IN_BLOOD("718-7", "Hemoglobin [Mass/volume] in Blood", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Hemoglobin [Moles/?volume] in Blood</div>
	 */
	HEMOGLOBIN_MOLESVOLUME_IN_BLOOD("59260-0", "Hemoglobin [Moles/?volume] in Blood", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Hemoglobin [Presence] in Urine by Automated test
	 * strip</div>
	 */
	HEMOGLOBIN_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP("57751-0", "Hemoglobin [Presence] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Hemoglobin [Presence] in Urine by Test strip</div>
	 */
	HEMOGLOBIN_PRESENCE_IN_URINE_BY_TEST_STRIP("5794-3", "Hemoglobin [Presence] in Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus Ab [Presence] in Serum</div>
	 */
	HEPATITIS_A_VIRUS_AB_PRESENCE_IN_SERUM("20575-7", "Hepatitis A virus Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_A_VIRUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("13951-9", "Hepatitis A virus Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus Ab [Units/?volume] in Serum</div>
	 */
	HEPATITIS_A_VIRUS_AB_UNITSVOLUME_IN_SERUM("22312-3", "Hepatitis A virus Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_A_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5183-9", "Hepatitis A virus Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus IgG Ab [Presence] in Serum</div>
	 */
	HEPATITIS_A_VIRUS_IGG_AB_PRESENCE_IN_SERUM("32018-4", "Hepatitis A virus IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_A_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("40724-7", "Hepatitis A virus IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus IgG Ab [Units/?volume] in Serum</div>
	 */
	HEPATITIS_A_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM("22313-1", "Hepatitis A virus IgG Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus IgG Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_A_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5179-7", "Hepatitis A virus IgG Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus IgG+?IgM Ab [Presence] in Serum</div>
	 */
	HEPATITIS_A_VIRUS_IGG_IGM_AB_PRESENCE_IN_SERUM("51913-2", "Hepatitis A virus IgG+?IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus IgM Ab [Presence] in Serum</div>
	 */
	HEPATITIS_A_VIRUS_IGM_AB_PRESENCE_IN_SERUM("22314-9", "Hepatitis A virus IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus IgM Ab [Units/?volume] in Serum</div>
	 */
	HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM("22315-6", "Hepatitis A virus IgM Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis A virus IgM Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5181-3", "Hepatitis A virus IgM Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus core Ab [Presence] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_CORE_AB_PRESENCE_IN_SERUM("16933-4", "Hepatitis B virus core Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus core Ab [Presence] in Serum or Plasma by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_CORE_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY("13952-7", "Hepatitis B virus core Ab [Presence] in Serum or Plasma by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus core Ab [Units/?volume] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_CORE_AB_UNITSVOLUME_IN_SERUM("22316-4", "Hepatitis B virus core Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus core IgG+?IgM Ab [Presence] in
	 * Serum</div>
	 */
	HEPATITIS_B_VIRUS_CORE_IGG_IGM_AB_PRESENCE_IN_SERUM("51914-0", "Hepatitis B virus core IgG+?IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus core IgM Ab [Presence] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_SERUM("31204-1", "Hepatitis B virus core IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus core IgM Ab [Presence] in Serum or Plasma
	 * by Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY("24113-3", "Hepatitis B virus core IgM Ab [Presence] in Serum or Plasma by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus core IgM Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_CORE_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5185-4", "Hepatitis B virus core IgM Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus DNA [Units/?volume] (viral load) in Serum
	 * or Plasma by Probe and target amplification method</div>
	 */
	HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("42595-9", "Hepatitis B virus DNA [Units/?volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus DNA [#/?volume] (viral load) in Serum or
	 * Plasma by Probe and target amplification method</div>
	 */
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("29615-2", "Hepatitis B virus DNA [#/?volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e Ab [Presence] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_E_AB_PRESENCE_IN_SERUM("22320-6", "Hepatitis B virus e Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_E_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("13953-5", "Hepatitis B virus e Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e Ab [Units/?volume] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_E_AB_UNITSVOLUME_IN_SERUM("22321-4", "Hepatitis B virus e Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_E_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5189-6", "Hepatitis B virus e Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e Ag [Presence] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM("31844-4", "Hepatitis B virus e Ag [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e Ag [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("13954-3", "Hepatitis B virus e Ag [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e Ag [Units/?volume] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_E_AG_UNITSVOLUME_IN_SERUM("31845-1", "Hepatitis B virus e Ag [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e Ag [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_E_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5191-2", "Hepatitis B virus e Ag [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e IgG Ab [Presence] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_E_IGG_AB_PRESENCE_IN_SERUM("41151-2", "Hepatitis B virus e IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus e IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_E_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("33463-1", "Hepatitis B virus e IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface Ab [Presence] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_AB_PRESENCE_IN_SERUM("22322-2", "Hepatitis B virus surface Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("10900-9", "Hepatitis B virus surface Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface Ab [Units/?volume] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_AB_UNITSVOLUME_IN_SERUM("16935-9", "Hepatitis B virus surface Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5193-8", "Hepatitis B virus surface Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface Ag [Presence] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM("5195-3", "Hepatitis B virus surface Ag [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface Ag [Presence] in Serum or Plasma
	 * by Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY("5196-1", "Hepatitis B virus surface Ag [Presence] in Serum or Plasma by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface Ag [Units/?volume] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_AG_UNITSVOLUME_IN_SERUM("58452-4", "Hepatitis B virus surface Ag [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface Ag [Units/?volume] in Serum or
	 * Plasma by Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_AG_UNITSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY("63557-3", "Hepatitis B virus surface Ag [Units/?volume] in Serum or Plasma by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface IgG Ab [Presence] in Serum</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_IGG_AB_PRESENCE_IN_SERUM("49177-9", "Hepatitis B virus surface IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis B virus surface IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_B_VIRUS_SURFACE_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("48070-7", "Hepatitis B virus surface IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus Ab [Presence] in Serum</div>
	 */
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM("16128-1", "Hepatitis C virus Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus Ab [Presence] in Serum by Immunoblot
	 * (IB)</div>
	 */
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB("5199-5", "Hepatitis C virus Ab [Presence] in Serum by Immunoblot (IB)", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus Ab [Presence] in Serum or Plasma by
	 * Immunoassay</div>
	 */
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY("13955-0", "Hepatitis C virus Ab [Presence] in Serum or Plasma by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_C_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5198-7", "Hepatitis C virus Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus genotype [Identifier] in Serum or Plasma
	 * by Probe and target amplification method</div>
	 */
	HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("32286-7", "Hepatitis C virus genotype [Identifier] in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus IgG Ab [Presence] in Serum</div>
	 */
	HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM("16129-9", "Hepatitis C virus IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("40726-2", "Hepatitis C virus IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus IgG Ab [Presence] in Serum by Immunoblot
	 * (IB)</div>
	 */
	HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB("33462-3", "Hepatitis C virus IgG Ab [Presence] in Serum by Immunoblot (IB)", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus IgG Ab [Units/?volume] in Serum</div>
	 */
	HEPATITIS_C_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM("16936-7", "Hepatitis C virus IgG Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus IgG Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HEPATITIS_C_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("57006-9", "Hepatitis C virus IgG Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus RNA [Units/volume] (viral load) in Serum
	 * or Plasma by Probe and target amplification method</div>
	 */
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("11011-4", "Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Hepatitis C virus RNA [#/?volume] (viral load) in Serum or
	 * Plasma by Probe and target amplification method</div>
	 */
	HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("20416-4", "Hepatitis C virus RNA [#/?volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Herpes simplex virus 1+?2 DNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	HERPES_SIMPLEX_VIRUS_1_2_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("20444-6", "Herpes simplex virus 1+?2 DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Herpes simplex virus 1 DNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	HERPES_SIMPLEX_VIRUS_1_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("16130-7", "Herpes simplex virus 1 DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Herpes simplex virus 2 DNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	HERPES_SIMPLEX_VIRUS_2_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("16131-5", "Herpes simplex virus 2 DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">HIV 1+2 Ab+HIV1 p24 Ag [Presence] in Serum by
	 * Immunoassay</div>
	 */
	HIV_1_2_AB_HIV1_P24_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("56888-1", "HIV 1+2 Ab+HIV1 p24 Ag [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">HIV 1+?2 Ab+?HIV1 p24 Ag [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	HIV_1_2_AB_HIV1_P24_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("58900-2", "HIV 1+?2 Ab+?HIV1 p24 Ag [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">HIV 1+?2 Ab [Presence] in Serum by Immunoblot (IB)</div>
	 */
	HIV_1_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB("44873-8", "HIV 1+?2 Ab [Presence] in Serum by Immunoblot (IB)", "18727-8", "20150101", ""),
	/**
	 * <div class="en">HIV 1+?2 Ab [Presence] in Unspecified specimen by Rapid
	 * immunoassay</div>
	 */
	HIV_1_2_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_RAPID_IMMUNOASSAY("49580-4", "HIV 1+?2 Ab [Presence] in Unspecified specimen by Rapid immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">HIV 1 Ab [Presence] in Serum by Immunoblot (IB)</div>
	 */
	HIV_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB("5221-7", "HIV 1 Ab [Presence] in Serum by Immunoblot (IB)", "18727-8", "20150101", ""),
	/**
	 * <div class="en">HIV 1 IgG Ab [Presence] in Serum by Immunoblot (IB)</div>
	 */
	HIV_1_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB("40732-0", "HIV 1 IgG Ab [Presence] in Serum by Immunoblot (IB)", "18727-8", "20150101", ""),
	/**
	 * <div class="en">HIV 1 RNA [Units/?volume] (viral load) in Serum or Plasma
	 * by Probe and target amplification method</div>
	 */
	HIV_1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("62469-2", "HIV 1 RNA [Units/?volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">HIV 1 RNA [#/?volume] (viral load) in Serum or Plasma by
	 * Probe and target amplification method</div>
	 */
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("20447-9", "HIV 1 RNA [#/?volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">HIV 2 Ab [Presence] in Serum by Immunoblot (IB)</div>
	 */
	HIV_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB("5225-8", "HIV 2 Ab [Presence] in Serum by Immunoblot (IB)", "18727-8", "20150101", ""),
	/**
	 * <div class="en">HIV 2 IgG Ab [Presence] in Serum by Immunoblot (IB)</div>
	 */
	HIV_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB("33806-1", "HIV 2 IgG Ab [Presence] in Serum by Immunoblot (IB)", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Hyaline casts [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	HYALINE_CASTS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT("33223-9", "Hyaline casts [#/area] in Urine sediment by Automated count", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Hyaline casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	HYALINE_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("25162-9", "Hyaline casts [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">I Ab [Presence] in Serum or Plasma</div>
	 */
	I_AB_PRESENCE_IN_SERUM_OR_PLASMA("1060-3", "I Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">IgA [Mass/volume] in Serum or Plasma</div>
	 */
	IGA_MASSVOLUME_IN_SERUM_OR_PLASMA("2458-8", "IgA [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">IgE [Units/volume] in Serum or Plasma</div>
	 */
	IGE_UNITSVOLUME_IN_SERUM_OR_PLASMA("19113-0", "IgE [Units/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">IgG [Mass/volume] in Serum or Plasma</div>
	 */
	IGG_MASSVOLUME_IN_SERUM_OR_PLASMA("2465-3", "IgG [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">IgM [Mass/volume] in Serum or Plasma</div>
	 */
	IGM_MASSVOLUME_IN_SERUM_OR_PLASMA("2472-9", "IgM [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">IH Ab [Presence] in Serum or Plasma</div>
	 */
	IH_AB_PRESENCE_IN_SERUM_OR_PLASMA("58078-7", "IH Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Imipramine+Desipramine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	IMIPRAMINE_DESIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA("9627-1", "Imipramine+Desipramine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Imipramine+Desipramine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	IMIPRAMINE_DESIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14794-2", "Imipramine+Desipramine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Imipramine [Mass/volume] in Serum or Plasma</div>
	 */
	IMIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA("3690-5", "Imipramine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Imipramine [Moles/volume] in Serum or Plasma</div>
	 */
	IMIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("15107-6", "Imipramine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Influenza virus A+B RNA [Presence] in Unspecified specimen
	 * by Probe and target amplification method</div>
	 */
	INFLUENZA_VIRUS_A_B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("62462-7", "Influenza virus A+B RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">INR in Blood by Coagulation assay</div>
	 */
	INR_IN_BLOOD_BY_COAGULATION_ASSAY("34714-6", "INR in Blood by Coagulation assay", "18720-3", "20150101", ""),
	/**
	 * <div class="en">Iron [Mass/volume] in Serum or Plasma</div>
	 */
	IRON_MASSVOLUME_IN_SERUM_OR_PLASMA("2498-4", "Iron [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Iron [Moles/volume] in Serum or Plasma</div>
	 */
	IRON_MOLESVOLUME_IN_SERUM_OR_PLASMA("14798-3", "Iron [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Isoniazid 0.1 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ISONIAZID_0_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25217-1", "Isoniazid 0.1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Isoniazid 0.2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ISONIAZID_0_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25218-9", "Isoniazid 0.2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Isoniazid 0.4 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ISONIAZID_0_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("29315-9", "Isoniazid 0.4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Isoniazid 1 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ISONIAZID_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25219-7", "Isoniazid 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Isoniazid 10 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ISONIAZID_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("55685-2", "Isoniazid 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Isoniazid 2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ISONIAZID_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("45215-1", "Isoniazid 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Isoniazid 5 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	ISONIAZID_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("42651-0", "Isoniazid 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Isoniazid [Susceptibility] by Method for Slow-growing
	 * mycobacteria</div>
	 */
	ISONIAZID_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("20383-6", "Isoniazid [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Itraconazole [Susceptibility]</div>
	 */
	ITRACONAZOLE_SUSCEPTIBILITY("32603-3", "Itraconazole [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Jk sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	JK_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA("1069-4", "Jk sup(a) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Jk sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	JK_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA("1075-1", "Jk sup(b) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Js sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	JS_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA("1081-9", "Js sup(a) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Js sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	JS_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA("1087-6", "Js sup(b) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">K Ab [Presence] in Serum or Plasma</div>
	 */
	K_AB_PRESENCE_IN_SERUM_OR_PLASMA("1093-4", "K Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Karyotype [Identifier] in Blood or Tissue Narrative</div>
	 */
	KARYOTYPE_IDENTIFIER_IN_BLOOD_OR_TISSUE_NARRATIVE("50619-6", "Karyotype [Identifier] in Blood or Tissue Narrative", "26435-8", "20150101", ""),
	/**
	 * <div class="en">Karyotype [Identifier] in Blood or Tissue Nominal</div>
	 */
	KARYOTYPE_IDENTIFIER_IN_BLOOD_OR_TISSUE_NOMINAL("29770-5", "Karyotype [Identifier] in Blood or Tissue Nominal", "26435-8", "20150101", ""),
	/**
	 * <div class="en">Ketones [Presence] in Urine by Automated test strip</div>
	 */
	KETONES_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP("57734-6", "Ketones [Presence] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Kp sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	KP_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA("1099-1", "Kp sup(a) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Kp sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	KP_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA("1105-6", "Kp sup(b) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Lactate dehydrogenase [Enzymatic activity/volume] in Serum
	 * or Plasma by Lactate to pyruvate reaction</div>
	 */
	LACTATE_DEHYDROGENASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_BY_LACTATE_TO_PYRUVATE_REACTION("14804-9", "Lactate dehydrogenase [Enzymatic activity/volume] in Serum or Plasma by Lactate to pyruvate reaction", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Lactate dehydrogenase [Enzymatic activity/volume] in Serum
	 * or Plasma by Pyruvate to lactate reaction</div>
	 */
	LACTATE_DEHYDROGENASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_BY_PYRUVATE_TO_LACTATE_REACTION("14805-6", "Lactate dehydrogenase [Enzymatic activity/volume] in Serum or Plasma by Pyruvate to lactate reaction", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Le sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	LE_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA("1112-2", "Le sup(a) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Le sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	LE_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA("1118-9", "Le sup(b) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Leucine crystals [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	LEUCINE_CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("5798-4", "Leucine crystals [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Leukocytes [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	LEUKOCYTES_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT("46702-7", "Leukocytes [#/area] in Urine sediment by Automated count", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Leukocytes [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	LEUKOCYTES_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("20455-2", "Leukocytes [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Leukocytes [#/?volume] in Blood by Automated count</div>
	 */
	LEUKOCYTES_VOLUME_IN_BLOOD_BY_AUTOMATED_COUNT("6690-2", "Leukocytes [#/?volume] in Blood by Automated count", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Leukocytes [#/volume] in Blood by Manual count</div>
	 */
	LEUKOCYTES_VOLUME_IN_BLOOD_BY_MANUAL_COUNT("804-5", "Leukocytes [#/volume] in Blood by Manual count", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Leukocytes [#/?volume] in unspecified time Urine sediment
	 * by Microscopy high power field</div>
	 */
	LEUKOCYTES_VOLUME_IN_UNSPECIFIED_TIME_URINE_SEDIMENT_BY_MICROSCOPY_HIGH_POWER_FIELD("63555-7", "Leukocytes [#/?volume] in unspecified time Urine sediment by Microscopy high power field", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Leukocytes [#/volume] in Urine by Automated test
	 * strip</div>
	 */
	LEUKOCYTES_VOLUME_IN_URINE_BY_AUTOMATED_TEST_STRIP("58805-3", "Leukocytes [#/volume] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Leukocytes [#/volume] in Urine by Test strip</div>
	 */
	LEUKOCYTES_VOLUME_IN_URINE_BY_TEST_STRIP("20408-1", "Leukocytes [#/volume] in Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Lipase [Enzymatic activity/volume] in Serum or Plasma</div>
	 */
	LIPASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("3040-3", "Lipase [Enzymatic activity/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Lithium [Mass/volume] in Serum or Plasma</div>
	 */
	LITHIUM_MASSVOLUME_IN_SERUM_OR_PLASMA("3719-2", "Lithium [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Lithium [Moles/volume] in Serum or Plasma</div>
	 */
	LITHIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("14334-7", "Lithium [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">little e Ab [Presence] in Serum or Plasma</div>
	 */
	LITTLE_E_AB_PRESENCE_IN_SERUM_OR_PLASMA("1162-7", "little e Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">little f Ab [Presence] in Serum or Plasma</div>
	 */
	LITTLE_F_AB_PRESENCE_IN_SERUM_OR_PLASMA("1168-4", "little f Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">little k Ab [Presence] in Serum or Plasma</div>
	 */
	LITTLE_K_AB_PRESENCE_IN_SERUM_OR_PLASMA("1192-4", "little k Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">little s Ab [Presence] in Serum or Plasma</div>
	 */
	LITTLE_S_AB_PRESENCE_IN_SERUM_OR_PLASMA("1210-4", "little s Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Lu sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	LU_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA("1135-3", "Lu sup(a) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Lu sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	LU_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA("1144-5", "Lu sup(b) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Lutropin [Units/volume] in Serum or Plasma</div>
	 */
	LUTROPIN_UNITSVOLUME_IN_SERUM_OR_PLASMA("10501-5", "Lutropin [Units/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Lymphocytes/?100 leukocytes in Blood by Manual count</div>
	 */
	LYMPHOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("737-7", "Lymphocytes/?100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">M Ab [Presence] in Serum or Plasma</div>
	 */
	M_AB_PRESENCE_IN_SERUM_OR_PLASMA("1228-6", "M Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Magnesium [Mass/volume] in Serum or Plasma</div>
	 */
	MAGNESIUM_MASSVOLUME_IN_SERUM_OR_PLASMA("19123-9", "Magnesium [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Magnesium [Moles/volume] in Serum or Plasma</div>
	 */
	MAGNESIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("2601-3", "Magnesium [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Major crossmatch [interpretation]</div>
	 */
	MAJOR_CROSSMATCH_INTERPRETATION("1250-0", "Major crossmatch [interpretation]", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Metamyelocytes/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	METAMYELOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("740-1", "Metamyelocytes/?100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Methadone [Mass/?volume] in Urine</div>
	 */
	METHADONE_MASSVOLUME_IN_URINE("3774-7", "Methadone [Mass/?volume] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Methadone [Moles/?volume] in Urine</div>
	 */
	METHADONE_MOLESVOLUME_IN_URINE("52958-6", "Methadone [Moles/?volume] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Methadone [Presence] in Urine</div>
	 */
	METHADONE_PRESENCE_IN_URINE("3773-9", "Methadone [Presence] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Methadone [Presence] in Urine by Screen method</div>
	 */
	METHADONE_PRESENCE_IN_URINE_BY_SCREEN_METHOD("19550-3", "Methadone [Presence] in Urine by Screen method", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Methicillin resistant Staphylococcus aureus (MRSA) DNA
	 * [Presence] by Probe and target amplification method</div>
	 */
	METHICILLIN_RESISTANT_STAPHYLOCOCCUS_AUREUS_MRSA_DNA_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("35492-8", "Methicillin resistant Staphylococcus aureus (MRSA) DNA [Presence] by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Methicillin resistant Staphylococcus aureus [Presence] in
	 * Unspecified specimen by Organism specific culture</div>
	 */
	METHICILLIN_RESISTANT_STAPHYLOCOCCUS_AUREUS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE("13317-3", "Methicillin resistant Staphylococcus aureus [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Mianserin [Mass/volume] in Serum or Plasma</div>
	 */
	MIANSERIN_MASSVOLUME_IN_SERUM_OR_PLASMA("2635-1", "Mianserin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Mianserin [Moles/volume] in Serum or Plasma</div>
	 */
	MIANSERIN_MOLESVOLUME_IN_SERUM_OR_PLASMA("25721-2", "Mianserin [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Mianserin+Normianserin [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	MIANSERIN_NORMIANSERIN_MASSVOLUME_IN_SERUM_OR_PLASMA("34341-8", "Mianserin+Normianserin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Micafungin [Susceptibility]</div>
	 */
	MICAFUNGIN_SUSCEPTIBILITY("65340-2", "Micafungin [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Mirtazapine [Mass/volume] in Serum or Plasma</div>
	 */
	MIRTAZAPINE_MASSVOLUME_IN_SERUM_OR_PLASMA("17283-3", "Mirtazapine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Mirtazapine [Moles/volume] in Serum or Plasma</div>
	 */
	MIRTAZAPINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("55554-0", "Mirtazapine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Mirtazapine+Normirtazapine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	MIRTAZAPINE_NORMIRTAZAPINE_MASSVOLUME_IN_SERUM_OR_PLASMA("62848-7", "Mirtazapine+Normirtazapine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Miscellaneous allergen IgE Ab RAST class [Presence] in
	 * Serum</div>
	 */
	MISCELLANEOUS_ALLERGEN_IGE_AB_RAST_CLASS_PRESENCE_IN_SERUM("33536-4", "Miscellaneous allergen IgE Ab RAST class [Presence] in Serum", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Mixed cellular casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	MIXED_CELLULAR_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("34173-5", "Mixed cellular casts [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Moclobemide [Mass/volume] in Serum or Plasma</div>
	 */
	MOCLOBEMIDE_MASSVOLUME_IN_SERUM_OR_PLASMA("74941-6", "Moclobemide [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Moclobemide [Moles/volume] in Serum or Plasma</div>
	 */
	MOCLOBEMIDE_MOLESVOLUME_IN_SERUM_OR_PLASMA("34413-5", "Moclobemide [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Monocytes/100 leukocytes in Blood by Manual count</div>
	 */
	MONOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("744-3", "Monocytes/100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Mycobacterium sp identified in Unspecified specimen by
	 * Organism specific culture</div>
	 */
	MYCOBACTERIUM_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE("543-9", "Mycobacterium sp identified in Unspecified specimen by Organism specific culture", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Mycobacterium tuberculosis complex DNA [Presence] in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("38379-4", "Mycobacterium tuberculosis complex DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Mycobacterium tuberculosis complex rRNA [Presence] in
	 * Unspecified specimen by DNA probe</div>
	 */
	MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE("17296-5", "Mycobacterium tuberculosis complex rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Myelocytes/?100 leukocytes in Blood by Manual count</div>
	 */
	MYELOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("749-2", "Myelocytes/?100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Myoglobin [Mass/volume] in Serum or Plasma</div>
	 */
	MYOGLOBIN_MASSVOLUME_IN_SERUM_OR_PLASMA("2639-3", "Myoglobin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Myoglobin [Mass/?volume] in Urine</div>
	 */
	MYOGLOBIN_MASSVOLUME_IN_URINE("2641-9", "Myoglobin [Mass/?volume] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Myoglobin [Moles/volume] in Serum or Plasma</div>
	 */
	MYOGLOBIN_MOLESVOLUME_IN_SERUM_OR_PLASMA("56887-3", "Myoglobin [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">N Ab [Presence] in Serum or Plasma</div>
	 */
	N_AB_PRESENCE_IN_SERUM_OR_PLASMA("1258-3", "N Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Natriuretic peptide B [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	NATRIURETIC_PEPTIDE_B_MASSVOLUME_IN_SERUM_OR_PLASMA("30934-4", "Natriuretic peptide B [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Natriuretic peptide B [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	NATRIURETIC_PEPTIDE_B_MOLESVOLUME_IN_SERUM_OR_PLASMA("47092-2", "Natriuretic peptide B [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Natriuretic peptide.B prohormone N-Terminal [Mass/?volume]
	 * in Serum or Plasma</div>
	 */
	NATRIURETIC_PEPTIDE_B_PROHORMONE_N_TERMINAL_MASSVOLUME_IN_SERUM_OR_PLASMA("33762-6", "Natriuretic peptide.B prohormone N-Terminal [Mass/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Natriuretic peptide.B prohormone N-Terminal [Moles/?volume]
	 * in Serum or Plasma</div>
	 */
	NATRIURETIC_PEPTIDE_B_PROHORMONE_N_TERMINAL_MOLESVOLUME_IN_SERUM_OR_PLASMA("33763-4", "Natriuretic peptide.B prohormone N-Terminal [Moles/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Neisseria gonorrhoeae DNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("24111-7", "Neisseria gonorrhoeae DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Neutrophil cytoplasmic Ab [interpretation] in Serum</div>
	 */
	NEUTROPHIL_CYTOPLASMIC_AB_INTERPRETATION_IN_SERUM("17352-6", "Neutrophil cytoplasmic Ab [interpretation] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Neutrophil cytoplasmic Ab pattern [interpretation] in Serum
	 * by Immunofluorescence</div>
	 */
	NEUTROPHIL_CYTOPLASMIC_AB_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOFLUORESCENCE("21419-7", "Neutrophil cytoplasmic Ab pattern [interpretation] in Serum by Immunofluorescence", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Neutrophil cytoplasmic Ab pattern [interpretation] in Serum
	 * by Immunofluorescence Narrative</div>
	 */
	NEUTROPHIL_CYTOPLASMIC_AB_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOFLUORESCENCE_NARRATIVE("49308-0", "Neutrophil cytoplasmic Ab pattern [interpretation] in Serum by Immunofluorescence Narrative", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Neutrophil cytoplasmic Ab [Presence] in Serum</div>
	 */
	NEUTROPHIL_CYTOPLASMIC_AB_PRESENCE_IN_SERUM("17351-8", "Neutrophil cytoplasmic Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Neutrophil cytoplasmic Ab [Presence] in Serum by
	 * Immunofluorescence</div>
	 */
	NEUTROPHIL_CYTOPLASMIC_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE("35279-9", "Neutrophil cytoplasmic Ab [Presence] in Serum by Immunofluorescence", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Neutrophil cytoplasmic IgG Ab [Presence] in Serum</div>
	 */
	NEUTROPHIL_CYTOPLASMIC_IGG_AB_PRESENCE_IN_SERUM("17355-9", "Neutrophil cytoplasmic IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Neutrophils.band form/100 leukocytes in Blood by Manual
	 * count</div>
	 */
	NEUTROPHILS_BAND_FORM100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("764-1", "Neutrophils.band form/100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Neutrophils.segmented/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	NEUTROPHILS_SEGMENTED100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("769-0", "Neutrophils.segmented/?100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Nitrite [Presence] in Urine by Automated test strip</div>
	 */
	NITRITE_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP("50558-6", "Nitrite [Presence] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Nitrite [Presence] in Urine by Test strip</div>
	 */
	NITRITE_PRESENCE_IN_URINE_BY_TEST_STRIP("5802-4", "Nitrite [Presence] in Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Norfluoxetine [Mass/volume] in Serum or Plasma</div>
	 */
	NORFLUOXETINE_MASSVOLUME_IN_SERUM_OR_PLASMA("3868-7", "Norfluoxetine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Norfluoxetine [Moles/volume] in Serum or Plasma</div>
	 */
	NORFLUOXETINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14855-1", "Norfluoxetine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Normianserin [Mass/volume] in Serum or Plasma</div>
	 */
	NORMIANSERIN_MASSVOLUME_IN_SERUM_OR_PLASMA("34414-3", "Normianserin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Normirtazapine [Mass/volume] in Serum or Plasma</div>
	 */
	NORMIRTAZAPINE_MASSVOLUME_IN_SERUM_OR_PLASMA("34415-0", "Normirtazapine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Norsertraline [Mass/volume] in Serum or Plasma</div>
	 */
	NORSERTRALINE_MASSVOLUME_IN_SERUM_OR_PLASMA("6897-3", "Norsertraline [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Nortrimipramine [Mass/volume] in Serum or Plasma</div>
	 */
	NORTRIMIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA("16746-0", "Nortrimipramine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Nortrimipramine [Moles/volume] in Serum or Plasma</div>
	 */
	NORTRIMIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("25394-8", "Nortrimipramine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Nortriptyline [Mass/volume] in Serum or Plasma</div>
	 */
	NORTRIPTYLINE_MASSVOLUME_IN_SERUM_OR_PLASMA("3872-9", "Nortriptyline [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Nortriptyline [Moles/volume] in Serum or Plasma</div>
	 */
	NORTRIPTYLINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14856-9", "Nortriptyline [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Norvenlafaxine [Mass/volume] in Serum or Plasma</div>
	 */
	NORVENLAFAXINE_MASSVOLUME_IN_SERUM_OR_PLASMA("9628-9", "Norvenlafaxine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Norvenlafaxine [Moles/volume] in Serum or Plasma</div>
	 */
	NORVENLAFAXINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("48362-8", "Norvenlafaxine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Nuclear Ab [Presence] in Serum</div>
	 */
	NUCLEAR_AB_PRESENCE_IN_SERUM("8061-4", "Nuclear Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Nuclear Ab [Presence] in Serum by Hep2 substrate</div>
	 */
	NUCLEAR_AB_PRESENCE_IN_SERUM_BY_HEP2_SUBSTRATE("59069-5", "Nuclear Ab [Presence] in Serum by Hep2 substrate", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Nuclear Ab [Presence] in Serum by Immunoassay</div>
	 */
	NUCLEAR_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("47383-5", "Nuclear Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Nuclear Ab [Presence] in Serum by Immunofluorescence</div>
	 */
	NUCLEAR_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE("42254-3", "Nuclear Ab [Presence] in Serum by Immunofluorescence", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Opiates [Mass/?volume] in Urine</div>
	 */
	OPIATES_MASSVOLUME_IN_URINE("8220-6", "Opiates [Mass/?volume] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Opiates [Moles/?volume] in Urine</div>
	 */
	OPIATES_MOLESVOLUME_IN_URINE("52952-9", "Opiates [Moles/?volume] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Opiates [Presence] in Urine</div>
	 */
	OPIATES_PRESENCE_IN_URINE("3879-4", "Opiates [Presence] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Opiates [Presence] in Urine by Screen method</div>
	 */
	OPIATES_PRESENCE_IN_URINE_BY_SCREEN_METHOD("19295-5", "Opiates [Presence] in Urine by Screen method", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Osmolality of Serum or Plasma</div>
	 */
	OSMOLALITY_OF_SERUM_OR_PLASMA("2692-2", "Osmolality of Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Osmolality of Urine</div>
	 */
	OSMOLALITY_OF_URINE("2695-5", "Osmolality of Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Ova and parasites identified in Unspecified specimen by
	 * Light microscopy</div>
	 */
	OVA_AND_PARASITES_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_LIGHT_MICROSCOPY("673-4", "Ova and parasites identified in Unspecified specimen by Light microscopy", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Oxygen [Partial pressure] in Blood</div>
	 */
	OXYGEN_PARTIAL_PRESSURE_IN_BLOOD("11556-8", "Oxygen [Partial pressure] in Blood", "18767-4", "20150101", ""),
	/**
	 * <div class="en">Oxygen [Partial pressure] in Venous blood</div>
	 */
	OXYGEN_PARTIAL_PRESSURE_IN_VENOUS_BLOOD("2705-2", "Oxygen [Partial pressure] in Venous blood", "18767-4", "20150101", ""),
	/**
	 * <div class="en">P Ab [Presence] in Serum or Plasma</div>
	 */
	P_AB_PRESENCE_IN_SERUM_OR_PLASMA("1279-9", "P Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">P1 Ab [Presence] in Serum or Plasma</div>
	 */
	P1_AB_PRESENCE_IN_SERUM_OR_PLASMA("1288-0", "P1 Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Parathyrin.intact [Mass/volume] in Serum or Plasma</div>
	 */
	PARATHYRIN_INTACT_MASSVOLUME_IN_SERUM_OR_PLASMA("2731-8", "Parathyrin.intact [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Parathyrin.intact [Moles/volume] in Serum or Plasma</div>
	 */
	PARATHYRIN_INTACT_MOLESVOLUME_IN_SERUM_OR_PLASMA("14866-8", "Parathyrin.intact [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Paroxetine [Mass/volume] in Serum or Plasma</div>
	 */
	PAROXETINE_MASSVOLUME_IN_SERUM_OR_PLASMA("9699-0", "Paroxetine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Paroxetine [Moles/volume] in Serum or Plasma</div>
	 */
	PAROXETINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14867-6", "Paroxetine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Peanut IgE Ab RAST class [Presence] in Serum</div>
	 */
	PEANUT_IGE_AB_RAST_CLASS_PRESENCE_IN_SERUM("15917-8", "Peanut IgE Ab RAST class [Presence] in Serum", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Peanut IgE Ab [Units/volume] in Serum</div>
	 */
	PEANUT_IGE_AB_UNITSVOLUME_IN_SERUM("6206-7", "Peanut IgE Ab [Units/volume] in Serum", "18719-5", "20150101", ""),
	/**
	 * <div class="en">pH of Blood</div>
	 */
	PH_OF_BLOOD("11558-4", "pH of Blood", "18767-4", "20150101", ""),
	/**
	 * <div class="en">pH of Urine by Automated test strip</div>
	 */
	PH_OF_URINE_BY_AUTOMATED_TEST_STRIP("50560-2", "pH of Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">pH of Urine by Test strip</div>
	 */
	PH_OF_URINE_BY_TEST_STRIP("5803-2", "pH of Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">pH of Venous blood</div>
	 */
	PH_OF_VENOUS_BLOOD("2746-6", "pH of Venous blood", "18767-4", "20150101", ""),
	/**
	 * <div class="en">Phosphate crystals amorphous [#/?volume] in Urine
	 * sediment</div>
	 */
	PHOSPHATE_CRYSTALS_AMORPHOUS_VOLUME_IN_URINE_SEDIMENT("13656-4", "Phosphate crystals amorphous [#/?volume] in Urine sediment", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Phosphate [Mass/volume] in Serum or Plasma</div>
	 */
	PHOSPHATE_MASSVOLUME_IN_SERUM_OR_PLASMA("2777-1", "Phosphate [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Phosphate [Moles/volume] in Serum or Plasma</div>
	 */
	PHOSPHATE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14879-1", "Phosphate [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Plasmodium sp identified in Blood by Light microscopy</div>
	 */
	PLASMODIUM_SP_IDENTIFIED_IN_BLOOD_BY_LIGHT_MICROSCOPY("32206-5", "Plasmodium sp identified in Blood by Light microscopy", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Plasmodium sp [Presence] in Blood by Light microscopy</div>
	 */
	PLASMODIUM_SP_PRESENCE_IN_BLOOD_BY_LIGHT_MICROSCOPY("51587-4", "Plasmodium sp [Presence] in Blood by Light microscopy", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Platelets [#/?volume] in Blood</div>
	 */
	PLATELETS_VOLUME_IN_BLOOD("26515-7", "Platelets [#/?volume] in Blood", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Platelets [#/?volume] in Blood by Automated count</div>
	 */
	PLATELETS_VOLUME_IN_BLOOD_BY_AUTOMATED_COUNT("777-3", "Platelets [#/?volume] in Blood by Automated count", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Platelets [#/volume] in Blood by Manual count</div>
	 */
	PLATELETS_VOLUME_IN_BLOOD_BY_MANUAL_COUNT("778-1", "Platelets [#/volume] in Blood by Manual count", "18723-7", "20150101", ""),
	/**
	 * <div class="en">Posaconazole [Susceptibility]</div>
	 */
	POSACONAZOLE_SUSCEPTIBILITY("54188-8", "Posaconazole [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Potassium [Moles/volume] in Serum or Plasma</div>
	 */
	POTASSIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("2823-3", "Potassium [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Procalcitonin [Mass/volume] in Serum or Plasma</div>
	 */
	PROCALCITONIN_MASSVOLUME_IN_SERUM_OR_PLASMA("33959-8", "Procalcitonin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Procalcitonin [Mass/volume] in Serum or Plasma by
	 * Immunoassay</div>
	 */
	PROCALCITONIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY("75241-0", "Procalcitonin [Mass/volume] in Serum or Plasma by Immunoassay", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Prolactin [Mass/volume] in Serum or Plasma</div>
	 */
	PROLACTIN_MASSVOLUME_IN_SERUM_OR_PLASMA("2842-3", "Prolactin [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Prolactin [Mass/volume] in Serum or Plasma by
	 * Immunoassay</div>
	 */
	PROLACTIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY("20568-2", "Prolactin [Mass/volume] in Serum or Plasma by Immunoassay", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Prolactin [Units/volume] in Serum or Plasma</div>
	 */
	PROLACTIN_UNITSVOLUME_IN_SERUM_OR_PLASMA("15081-3", "Prolactin [Units/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Promyelocytes/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	PROMYELOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT("783-1", "Promyelocytes/?100 leukocytes in Blood by Manual count", "18768-2", "20150101", ""),
	/**
	 * <div class="en">Prostate Specific Ag Free [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	PROSTATE_SPECIFIC_AG_FREE_MASSVOLUME_IN_SERUM_OR_PLASMA("10886-0", "Prostate Specific Ag Free [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Prostate specific Ag [Mass/volume] in Serum or Plasma</div>
	 */
	PROSTATE_SPECIFIC_AG_MASSVOLUME_IN_SERUM_OR_PLASMA("2857-1", "Prostate specific Ag [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Protein [Mass/volume] in Serum or Plasma</div>
	 */
	PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA("2885-2", "Protein [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Protein [Presence] in Urine by Automated test strip</div>
	 */
	PROTEIN_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP("57735-3", "Protein [Presence] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Protein [Presence] in Urine by Test strip</div>
	 */
	PROTEIN_PRESENCE_IN_URINE_BY_TEST_STRIP("20454-5", "Protein [Presence] in Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Prothrombin time (PT) actual/?Normal</div>
	 */
	PROTHROMBIN_TIME_PT_ACTUALNORMAL("5894-1", "Prothrombin time (PT) actual/?Normal", "18720-3", "20150101", ""),
	/**
	 * <div class="en">Pyrazinamide 100 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	PYRAZINAMIDE_100_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25229-6", "Pyrazinamide 100 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Pyrazinamide 200 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	PYRAZINAMIDE_200_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("55711-6", "Pyrazinamide 200 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Pyrazinamide 25 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	PYRAZINAMIDE_25_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25186-8", "Pyrazinamide 25 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Pyrazinamide 300 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	PYRAZINAMIDE_300_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("56026-8", "Pyrazinamide 300 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Pyrazinamide [Susceptibility] by Method for Slow-growing
	 * mycobacteria</div>
	 */
	PYRAZINAMIDE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("20461-0", "Pyrazinamide [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">RBC casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	RBC_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("33804-6", "RBC casts [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Reagin Ab [Titer] in Serum</div>
	 */
	REAGIN_AB_TITER_IN_SERUM("11084-1", "Reagin Ab [Titer] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Reagin Ab [Titer] in Serum by RPR</div>
	 */
	REAGIN_AB_TITER_IN_SERUM_BY_RPR("31147-2", "Reagin Ab [Titer] in Serum by RPR", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Reagin Ab [Titer] in Serum by VDRL</div>
	 */
	REAGIN_AB_TITER_IN_SERUM_BY_VDRL("50690-7", "Reagin Ab [Titer] in Serum by VDRL", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Reagin Ab [Units/?volume] in Serum</div>
	 */
	REAGIN_AB_UNITSVOLUME_IN_SERUM("22462-6", "Reagin Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Reagin Ab [Units/?volume] in Serum by RPR</div>
	 */
	REAGIN_AB_UNITSVOLUME_IN_SERUM_BY_RPR("20508-8", "Reagin Ab [Units/?volume] in Serum by RPR", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Reagin Ab [Units/volume] in Serum by VDRL</div>
	 */
	REAGIN_AB_UNITSVOLUME_IN_SERUM_BY_VDRL("5291-0", "Reagin Ab [Units/volume] in Serum by VDRL", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Reboxetine [Moles/volume] in Serum or Plasma</div>
	 */
	REBOXETINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("48352-9", "Reboxetine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Rifampin 1 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	RIFAMPIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25202-3", "Rifampin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Rifampin 14 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	RIFAMPIN_14_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25184-3", "Rifampin 14 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Rifampin 2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	RIFAMPIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25203-1", "Rifampin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Rifampin 40 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	RIFAMPIN_40_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("55712-4", "Rifampin 40 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Rifampin 5 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	RIFAMPIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25204-9", "Rifampin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Rifampin [Susceptibility] by Method for Slow-growing
	 * mycobacteria</div>
	 */
	RIFAMPIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("20385-1", "Rifampin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Rubella virus IgG Ab [Units/volume] in Serum</div>
	 */
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM("8014-3", "Rubella virus IgG Ab [Units/volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Rubella virus IgG Ab [Units/volume] in Serum by
	 * Immunoassay</div>
	 */
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5334-8", "Rubella virus IgG Ab [Units/volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Rubella virus IgM Ab [Presence] in Serum</div>
	 */
	RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM("31616-6", "Rubella virus IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Rubella virus IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("24116-6", "Rubella virus IgM Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Rubella virus IgM Ab [Units/?volume] in Serum</div>
	 */
	RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM("8015-0", "Rubella virus IgM Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Rubella virus IgM Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5335-5", "Rubella virus IgM Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">S Ab [Presence] in Serum or Plasma</div>
	 */
	S_AB_PRESENCE_IN_SERUM_OR_PLASMA("1317-7", "S Ab [Presence] in Serum or Plasma", "18717-9", "20150101", ""),
	/**
	 * <div class="en">Sertraline [Mass/volume] in Serum or Plasma</div>
	 */
	SERTRALINE_MASSVOLUME_IN_SERUM_OR_PLASMA("6906-2", "Sertraline [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Sertraline [Moles/volume] in Serum or Plasma</div>
	 */
	SERTRALINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14911-2", "Sertraline [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Silver Birch IgE Ab RAST class [Presence] in Serum</div>
	 */
	SILVER_BIRCH_IGE_AB_RAST_CLASS_PRESENCE_IN_SERUM("15579-6", "Silver Birch IgE Ab RAST class [Presence] in Serum", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Silver Birch IgE Ab [Units/volume] in Serum</div>
	 */
	SILVER_BIRCH_IGE_AB_UNITSVOLUME_IN_SERUM("15283-5", "Silver Birch IgE Ab [Units/volume] in Serum", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Sodium [Moles/volume] in Serum or Plasma</div>
	 */
	SODIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("2951-2", "Sodium [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Specific gravity of Urine by Automated test strip</div>
	 */
	SPECIFIC_GRAVITY_OF_URINE_BY_AUTOMATED_TEST_STRIP("53326-5", "Specific gravity of Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Specific gravity of Urine by Test strip</div>
	 */
	SPECIFIC_GRAVITY_OF_URINE_BY_TEST_STRIP("5811-5", "Specific gravity of Urine by Test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Streptococcus pyogenes Ag [Presence] in Throat</div>
	 */
	STREPTOCOCCUS_PYOGENES_AG_PRESENCE_IN_THROAT("18481-2", "Streptococcus pyogenes Ag [Presence] in Throat", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Streptomycin 1 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	STREPTOMYCIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("48177-0", "Streptomycin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Streptomycin 10 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	STREPTOMYCIN_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25206-4", "Streptomycin 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Streptomycin 2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	STREPTOMYCIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25205-6", "Streptomycin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Streptomycin 4 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	STREPTOMYCIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("46719-1", "Streptomycin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Streptomycin 6 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	STREPTOMYCIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("25185-0", "Streptomycin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Streptomycin [Susceptibility] by Method for Slow-growing
	 * mycobacteria</div>
	 */
	STREPTOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA("20462-8", "Streptomycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Testosterone [Mass/volume] in Serum or Plasma</div>
	 */
	TESTOSTERONE_MASSVOLUME_IN_SERUM_OR_PLASMA("2986-8", "Testosterone [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Testosterone [Moles/volume] in Serum or Plasma</div>
	 */
	TESTOSTERONE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14913-8", "Testosterone [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Thyroperoxidase Ab [Titer] in Serum or Plasma</div>
	 */
	THYROPEROXIDASE_AB_TITER_IN_SERUM_OR_PLASMA("32786-6", "Thyroperoxidase Ab [Titer] in Serum or Plasma", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Thyroperoxidase Ab [Units/volume] in Serum or Plasma</div>
	 */
	THYROPEROXIDASE_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA("8099-4", "Thyroperoxidase Ab [Units/volume] in Serum or Plasma", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Thyroperoxidase Ab [Units/volume] in Serum or Plasma by
	 * Immunoassay</div>
	 */
	THYROPEROXIDASE_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY("56477-3", "Thyroperoxidase Ab [Units/volume] in Serum or Plasma by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Thyroperoxidase IgG Ab [Units/?volume] in Serum or
	 * Plasma</div>
	 */
	THYROPEROXIDASE_IGG_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA("18332-7", "Thyroperoxidase IgG Ab [Units/?volume] in Serum or Plasma", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Thyrotropin [Units/volume] in Serum or Plasma</div>
	 */
	THYROTROPIN_UNITSVOLUME_IN_SERUM_OR_PLASMA("3016-3", "Thyrotropin [Units/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Thyroxine (T4) free [Mass/volume] in Serum or Plasma</div>
	 */
	THYROXINE_T4_FREE_MASSVOLUME_IN_SERUM_OR_PLASMA("3024-7", "Thyroxine (T4) free [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Thyroxine (T4) free [Moles/volume] in Serum or Plasma</div>
	 */
	THYROXINE_T4_FREE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14920-3", "Thyroxine (T4) free [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Tissue transglutaminase IgA Ab [Units/?volume] in
	 * Serum</div>
	 */
	TISSUE_TRANSGLUTAMINASE_IGA_AB_UNITSVOLUME_IN_SERUM("31017-7", "Tissue transglutaminase IgA Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Tissue transglutaminase IgA Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	TISSUE_TRANSGLUTAMINASE_IGA_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("46128-5", "Tissue transglutaminase IgA Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Toxoplasma gondii Ab [Units/volume] in Serum</div>
	 */
	TOXOPLASMA_GONDII_AB_UNITSVOLUME_IN_SERUM("11598-0", "Toxoplasma gondii Ab [Units/volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Toxoplasma gondii DNA [Presence] in Unspecified specimen by
	 * Probe and target amplification method</div>
	 */
	TOXOPLASMA_GONDII_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("29904-0", "Toxoplasma gondii DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Toxoplasma gondii IgG Ab [Units/volume] in Serum</div>
	 */
	TOXOPLASMA_GONDII_IGG_AB_UNITSVOLUME_IN_SERUM("8039-0", "Toxoplasma gondii IgG Ab [Units/volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Toxoplasma gondii IgG Ab [Units/volume] in Serum by
	 * Immunoassay</div>
	 */
	TOXOPLASMA_GONDII_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5388-4", "Toxoplasma gondii IgG Ab [Units/volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Toxoplasma gondii IgM Ab [Presence] in Serum</div>
	 */
	TOXOPLASMA_GONDII_IGM_AB_PRESENCE_IN_SERUM("25542-2", "Toxoplasma gondii IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Toxoplasma gondii IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	TOXOPLASMA_GONDII_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("40678-5", "Toxoplasma gondii IgM Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Toxoplasma gondii IgM Ab [Units/?volume] in Serum</div>
	 */
	TOXOPLASMA_GONDII_IGM_AB_UNITSVOLUME_IN_SERUM("8040-8", "Toxoplasma gondii IgM Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Toxoplasma gondii IgM Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	TOXOPLASMA_GONDII_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5390-0", "Toxoplasma gondii IgM Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Trazodone [Mass/volume] in Serum or Plasma</div>
	 */
	TRAZODONE_MASSVOLUME_IN_SERUM_OR_PLASMA("4064-2", "Trazodone [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Trazodone [Moles/volume] in Serum or Plasma</div>
	 */
	TRAZODONE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14925-2", "Trazodone [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum Ab [Titer] in Serum by
	 * Hemagglutination</div>
	 */
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION("26009-1", "Treponema pallidum Ab [Titer] in Serum by Hemagglutination", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum Ab [Titer] in Serum by
	 * Immunofluorescence</div>
	 */
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE("34382-2", "Treponema pallidum Ab [Titer] in Serum by Immunofluorescence", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum Ab [Titer] in Serum by Latex
	 * agglutination</div>
	 */
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION("5394-2", "Treponema pallidum Ab [Titer] in Serum by Latex agglutination", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum Ab [Titer] in Serum or Plasma by
	 * Agglutination</div>
	 */
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_OR_PLASMA_BY_AGGLUTINATION("71793-4", "Treponema pallidum Ab [Titer] in Serum or Plasma by Agglutination", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum Ab [Units/volume] in Serum</div>
	 */
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM("11597-2", "Treponema pallidum Ab [Units/volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum Ab [Units/volume] in Serum by
	 * Immunoassay</div>
	 */
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("63464-2", "Treponema pallidum Ab [Units/volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum Ab [Units/?volume] in Serum by Latex
	 * agglutination</div>
	 */
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION("17725-3", "Treponema pallidum Ab [Units/?volume] in Serum by Latex agglutination", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgG Ab [Units/volume] in Serum</div>
	 */
	TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM("22592-0", "Treponema pallidum IgG Ab [Units/volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgG Ab [Units/volume] in Serum by
	 * Immunoassay</div>
	 */
	TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("51838-1", "Treponema pallidum IgG Ab [Units/volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgG Ab [Units/volume] in Serum by
	 * Immunofluorescence</div>
	 */
	TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE("17727-9", "Treponema pallidum IgG Ab [Units/volume] in Serum by Immunofluorescence", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgM Ab [Presence] in Serum</div>
	 */
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM("6562-3", "Treponema pallidum IgM Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("47237-3", "Treponema pallidum IgM Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgM Ab [Presence] in Serum by Immunoblot
	 * (IB)</div>
	 */
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB("40680-1", "Treponema pallidum IgM Ab [Presence] in Serum by Immunoblot (IB)", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgM Ab [Presence] in Serum by
	 * Immunofluorescence</div>
	 */
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE("17729-5", "Treponema pallidum IgM Ab [Presence] in Serum by Immunofluorescence", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgM Ab [Units/?volume] in Serum</div>
	 */
	TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM("22594-6", "Treponema pallidum IgM Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgM Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("51839-9", "Treponema pallidum IgM Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Treponema pallidum IgM Ab [Units/?volume] in Serum by
	 * Immunofluorescence</div>
	 */
	TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE("17728-7", "Treponema pallidum IgM Ab [Units/?volume] in Serum by Immunofluorescence", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Tricyclic antidepressants [Presence] in Serum or
	 * Plasma</div>
	 */
	TRICYCLIC_ANTIDEPRESSANTS_PRESENCE_IN_SERUM_OR_PLASMA("4073-3", "Tricyclic antidepressants [Presence] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Tricyclic antidepressants [Presence] in Urine</div>
	 */
	TRICYCLIC_ANTIDEPRESSANTS_PRESENCE_IN_URINE("11004-9", "Tricyclic antidepressants [Presence] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Tricyclic antidepressants [Presence] in Urine by
	 * Immunoassay</div>
	 */
	TRICYCLIC_ANTIDEPRESSANTS_PRESENCE_IN_URINE_BY_IMMUNOASSAY("6799-1", "Tricyclic antidepressants [Presence] in Urine by Immunoassay", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Tricyclic antidepressants [Presence] in Urine by Screen
	 * method</div>
	 */
	TRICYCLIC_ANTIDEPRESSANTS_PRESENCE_IN_URINE_BY_SCREEN_METHOD("19312-8", "Tricyclic antidepressants [Presence] in Urine by Screen method", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Tricyclic antidepressants screen method [Identifier] in
	 * Urine</div>
	 */
	TRICYCLIC_ANTIDEPRESSANTS_SCREEN_METHOD_IDENTIFIER_IN_URINE("19319-3", "Tricyclic antidepressants screen method [Identifier] in Urine", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Triglyceride [Mass/volume] in Serum or Plasma</div>
	 */
	TRIGLYCERIDE_MASSVOLUME_IN_SERUM_OR_PLASMA("2571-8", "Triglyceride [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Triglyceride [Moles/volume] in Serum or Plasma</div>
	 */
	TRIGLYCERIDE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14927-8", "Triglyceride [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Trimipramine [Mass/volume] in Serum or Plasma</div>
	 */
	TRIMIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA("4083-2", "Trimipramine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Trimipramine [Moles/volume] in Serum or Plasma</div>
	 */
	TRIMIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14931-0", "Trimipramine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Trimipramine+Nortrimipramine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	TRIMIPRAMINE_NORTRIMIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("25812-9", "Trimipramine+Nortrimipramine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Troponin I.cardiac [Mass/volume] in Serum or Plasma</div>
	 */
	TROPONIN_I_CARDIAC_MASSVOLUME_IN_SERUM_OR_PLASMA("10839-9", "Troponin I.cardiac [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Troponin T.cardiac [Mass/?volume] in Serum or Plasma</div>
	 */
	TROPONIN_T_CARDIAC_MASSVOLUME_IN_SERUM_OR_PLASMA("6598-7", "Troponin T.cardiac [Mass/?volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Troponin T.cardiac [Presence] in Serum or Plasma</div>
	 */
	TROPONIN_T_CARDIAC_PRESENCE_IN_SERUM_OR_PLASMA("33204-9", "Troponin T.cardiac [Presence] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Unidentified crystals [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	UNIDENTIFIED_CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("5783-6", "Unidentified crystals [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Urate crystals amorphous [#/?volume] in Urine
	 * sediment</div>
	 */
	URATE_CRYSTALS_AMORPHOUS_VOLUME_IN_URINE_SEDIMENT("13657-2", "Urate crystals amorphous [#/?volume] in Urine sediment", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Urate [Mass/volume] in Serum or Plasma</div>
	 */
	URATE_MASSVOLUME_IN_SERUM_OR_PLASMA("3084-1", "Urate [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Urate [Moles/volume] in Serum or Plasma</div>
	 */
	URATE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14933-6", "Urate [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Urea [Mass/volume] in Serum or Plasma</div>
	 */
	UREA_MASSVOLUME_IN_SERUM_OR_PLASMA("3091-6", "Urea [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Urea [Moles/volume] in Serum or Plasma</div>
	 */
	UREA_MOLESVOLUME_IN_SERUM_OR_PLASMA("22664-7", "Urea [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Urobilinogen [Presence] in Urine by Automated test
	 * strip</div>
	 */
	UROBILINOGEN_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP("62487-4", "Urobilinogen [Presence] in Urine by Automated test strip", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Varicella zoster virus DNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	VARICELLA_ZOSTER_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("11483-5", "Varicella zoster virus DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Varicella zoster virus DNA [#/?volume] (viral load) in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	VARICELLA_ZOSTER_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("49451-8", "Varicella zoster virus DNA [#/?volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "20150101", ""),
	/**
	 * <div class="en">Varicella zoster virus IgG Ab [Presence] in Serum</div>
	 */
	VARICELLA_ZOSTER_VIRUS_IGG_AB_PRESENCE_IN_SERUM("19162-7", "Varicella zoster virus IgG Ab [Presence] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Varicella zoster virus IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	VARICELLA_ZOSTER_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY("15410-4", "Varicella zoster virus IgG Ab [Presence] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Varicella zoster virus IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	VARICELLA_ZOSTER_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM("8047-3", "Varicella zoster virus IgG Ab [Units/?volume] in Serum", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Varicella zoster virus IgG Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	VARICELLA_ZOSTER_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY("5403-1", "Varicella zoster virus IgG Ab [Units/?volume] in Serum by Immunoassay", "18727-8", "20150101", ""),
	/**
	 * <div class="en">Venlafaxine [Mass/volume] in Serum or Plasma</div>
	 */
	VENLAFAXINE_MASSVOLUME_IN_SERUM_OR_PLASMA("9630-5", "Venlafaxine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Venlafaxine [Moles/volume] in Serum or Plasma</div>
	 */
	VENLAFAXINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("34386-3", "Venlafaxine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Venlafaxine+Norvenlafaxine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	VENLAFAXINE_NORVENLAFAXINE_MASSVOLUME_IN_SERUM_OR_PLASMA("62849-5", "Venlafaxine+Norvenlafaxine [Mass/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Venlafaxine+Norvenlafaxine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	VENLAFAXINE_NORVENLAFAXINE_MOLESVOLUME_IN_SERUM_OR_PLASMA("48350-3", "Venlafaxine+Norvenlafaxine [Moles/volume] in Serum or Plasma", "18719-5", "20150101", ""),
	/**
	 * <div class="en">Voriconazole [Susceptibility]</div>
	 */
	VORICONAZOLE_SUSCEPTIBILITY("32379-0", "Voriconazole [Susceptibility]", "18769-0", "20150101", ""),
	/**
	 * <div class="en">Waxy casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	WAXY_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("33862-4", "Waxy casts [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Waxy casts [#/?volume] in Urine sediment</div>
	 */
	WAXY_CASTS_VOLUME_IN_URINE_SEDIMENT("41187-6", "Waxy casts [#/?volume] in Urine sediment", "18729-4", "20150101", ""),
	/**
	 * <div class="en">WBC casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	WBC_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("33825-1", "WBC casts [Presence] in Urine sediment by Light microscopy", "18729-4", "20150101", ""),
	/**
	 * <div class="en">Xg sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	XG_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA("1338-3", "Xg sup(a) Ab [Presence] in Serum or Plasma", "18717-9", "20150101", "");

	/**
	 * <div class="en">Code for 5-Fluorocytosine [Susceptibility]</div>
	 */
	public static final String _5_FLUOROCYTOSINE_SUSCEPTIBILITY_CODE = "18855-7";

	/**
	 * <div class="en">Code for ABO and Rh group [Type] in Blood</div>
	 */
	public static final String ABO_AND_RH_GROUP_TYPE_IN_BLOOD_CODE = "882-1";

	/**
	 * <div class="en">Code for Activated partial thromboplastin time (aPTT) in
	 * Blood by Coagulation assay</div>
	 */
	public static final String ACTIVATED_PARTIAL_THROMBOPLASTIN_TIME_APTT_IN_BLOOD_BY_COAGULATION_ASSAY_CODE = "3173-2";

	/**
	 * <div class="en">Code for Alanine aminotransferase [Enzymatic
	 * activity/volume] in Serum or Plasma</div>
	 */
	public static final String ALANINE_AMINOTRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "1742-6";

	/**
	 * <div class="en">Code for Albumin [Mass/?volume] in Serum or Plasma by
	 * Bromocresol green (BCG) dye binding method</div>
	 */
	public static final String ALBUMIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_BROMOCRESOL_GREEN_BCG_DYE_BINDING_METHOD_CODE = "61151-7";

	/**
	 * <div class="en">Code for Albumin [Mass/?volume] in Serum or Plasma by
	 * Bromocresol purple (BCP) dye binding method</div>
	 */
	public static final String ALBUMIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_BROMOCRESOL_PURPLE_BCP_DYE_BINDING_METHOD_CODE = "61152-5";

	/**
	 * <div class="en">Code for Albumin [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String ALBUMIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "1751-7";

	/**
	 * <div class="en">Code for Albumin [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String ALBUMIN_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "54347-0";

	/**
	 * <div class="en">Code for Alkaline phosphatase [Enzymatic activity/volume]
	 * in Serum or Plasma</div>
	 */
	public static final String ALKALINE_PHOSPHATASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "6768-6";

	/**
	 * <div class="en">Code for Alpha-1-Fetoprotein [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String ALPHA_1_FETOPROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "1834-1";

	/**
	 * <div class="en">Code for Alpha-1-Fetoprotein [Moles/?volume] in Serum or
	 * Plasma</div>
	 */
	public static final String ALPHA_1_FETOPROTEIN_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "19177-5";

	/**
	 * <div class="en">Code for Alpha-1-Fetoprotein [Units/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String ALPHA_1_FETOPROTEIN_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "19176-7";

	/**
	 * <div class="en">Code for Amitriptyline [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String AMITRIPTYLINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3333-2";

	/**
	 * <div class="en">Code for Amitriptyline [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String AMITRIPTYLINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14597-9";

	/**
	 * <div class="en">Code for Amitriptyline+Nortriptyline [Mass/volume] in Serum
	 * or Plasma</div>
	 */
	public static final String AMITRIPTYLINE_NORTRIPTYLINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3335-7";

	/**
	 * <div class="en">Code for Amitriptyline+Nortriptyline [Moles/volume] in
	 * Serum or Plasma</div>
	 */
	public static final String AMITRIPTYLINE_NORTRIPTYLINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14598-7";

	/**
	 * <div class="en">Code for Amphetamines [Presence] in Urine by Screen
	 * method</div>
	 */
	public static final String AMPHETAMINES_PRESENCE_IN_URINE_BY_SCREEN_METHOD_CODE = "19261-7";

	/**
	 * <div class="en">Code for Amphetamines [Presence] in Urine</div>
	 */
	public static final String AMPHETAMINES_PRESENCE_IN_URINE_CODE = "3349-8";

	/**
	 * <div class="en">Code for Amphotericin B [Susceptibility]</div>
	 */
	public static final String AMPHOTERICIN_B_SUSCEPTIBILITY_CODE = "18863-1";

	/**
	 * <div class="en">Code for Amylase [Enzymatic activity/?volume] in Serum or
	 * Plasma</div>
	 */
	public static final String AMYLASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "1798-8";

	/**
	 * <div class="en">Code for Amylase.pancreatic [Enzymatic activity/volume] in
	 * Serum or Plasma</div>
	 */
	public static final String AMYLASE_PANCREATIC_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "1805-1";

	/**
	 * <div class="en">Code for Anidulafungin [Susceptibility]</div>
	 */
	public static final String ANIDULAFUNGIN_SUSCEPTIBILITY_CODE = "57095-2";

	/**
	 * <div class="en">Code for Antidepressants [Identifier] in Serum or
	 * Plasma</div>
	 */
	public static final String ANTIDEPRESSANTS_IDENTIFIER_IN_SERUM_OR_PLASMA_CODE = "16389-9";

	/**
	 * <div class="en">Code for Appearance of Urine</div>
	 */
	public static final String APPEARANCE_OF_URINE_CODE = "5767-9";

	/**
	 * <div class="en">Code for Aspartate aminotransferase [Enzymatic
	 * activity/?volume] in Serum or Plasma</div>
	 */
	public static final String ASPARTATE_AMINOTRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "1920-8";

	/**
	 * <div class="en">Code for Bacteria [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	public static final String BACTERIA_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT_CODE = "33218-9";

	/**
	 * <div class="en">Code for Bacteria identified in Urine by Culture</div>
	 */
	public static final String BACTERIA_IDENTIFIED_IN_URINE_BY_CULTURE_CODE = "630-4";

	/**
	 * <div class="en">Code for Bacteria [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	public static final String BACTERIA_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "25145-4";

	/**
	 * <div class="en">Code for Barbiturates [Presence] in Serum or Plasma by
	 * Screen method</div>
	 */
	public static final String BARBITURATES_PRESENCE_IN_SERUM_OR_PLASMA_BY_SCREEN_METHOD_CODE = "20421-4";

	/**
	 * <div class="en">Code for Barbiturates [Presence] in Serum, Plasma or
	 * Blood</div>
	 */
	public static final String BARBITURATES_PRESENCE_IN_SERUM_PLASMA_OR_BLOOD_CODE = "3376-1";

	/**
	 * <div class="en">Code for Barbiturates [Presence] in Urine by Screen
	 * method</div>
	 */
	public static final String BARBITURATES_PRESENCE_IN_URINE_BY_SCREEN_METHOD_CODE = "19270-8";

	/**
	 * <div class="en">Code for Barbiturates [Presence] in Urine</div>
	 */
	public static final String BARBITURATES_PRESENCE_IN_URINE_CODE = "3377-9";

	/**
	 * <div class="en">Code for Basophils/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	public static final String BASOPHILS100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "707-0";

	/**
	 * <div class="en">Code for Benzodiazepines [Presence] in Serum or
	 * Plasma</div>
	 */
	public static final String BENZODIAZEPINES_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "3389-4";

	/**
	 * <div class="en">Code for Benzodiazepines [Presence] in Urine by Screen
	 * method</div>
	 */
	public static final String BENZODIAZEPINES_PRESENCE_IN_URINE_BY_SCREEN_METHOD_CODE = "14316-4";

	/**
	 * <div class="en">Code for Benzodiazepines [Presence] in Urine</div>
	 */
	public static final String BENZODIAZEPINES_PRESENCE_IN_URINE_CODE = "3390-2";

	/**
	 * <div class="en">Code for Bg sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String BG_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "57902-9";

	/**
	 * <div class="en">Code for Bilirubin.total [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String BILIRUBIN_TOTAL_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "1975-2";

	/**
	 * <div class="en">Code for Bilirubin.total [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String BILIRUBIN_TOTAL_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14631-6";

	/**
	 * <div class="en">Code for Bilirubin.total [Presence] in Urine by Automated
	 * test strip</div>
	 */
	public static final String BILIRUBIN_TOTAL_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "50551-1";

	/**
	 * <div class="en">Code for Bilirubin.total [Presence] in Urine by Test
	 * strip</div>
	 */
	public static final String BILIRUBIN_TOTAL_PRESENCE_IN_URINE_BY_TEST_STRIP_CODE = "5770-3";

	/**
	 * <div class="en">Code for Blasts/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	public static final String BLASTS100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "709-6";

	/**
	 * <div class="en">Code for Blood group antibodies identified in Serum or
	 * Plasma</div>
	 */
	public static final String BLOOD_GROUP_ANTIBODIES_IDENTIFIED_IN_SERUM_OR_PLASMA_CODE = "888-8";

	/**
	 * <div class="en">Code for Blood group antibody screen [Presence] in Serum or
	 * Plasma</div>
	 */
	public static final String BLOOD_GROUP_ANTIBODY_SCREEN_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "890-4";

	/**
	 * <div class="en">Code for C reactive protein [Mass/?volume] in Serum or
	 * Plasma by High sensitivity method</div>
	 */
	public static final String C_REACTIVE_PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_HIGH_SENSITIVITY_METHOD_CODE = "30522-7";

	/**
	 * <div class="en">Code for C reactive protein [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String C_REACTIVE_PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "1988-5";

	/**
	 * <div class="en">Code for Calcidiol [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String CALCIDIOL_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "1989-3";

	/**
	 * <div class="en">Code for Calcidiol [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String CALCIDIOL_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14635-7";

	/**
	 * <div class="en">Code for Calcium [Mass/?volume] in Serum or Plasma</div>
	 */
	public static final String CALCIUM_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "17861-6";

	/**
	 * <div class="en">Code for Calcium [Moles/?volume] in Serum or Plasma</div>
	 */
	public static final String CALCIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2000-8";

	/**
	 * <div class="en">Code for Calcium oxalate crystals [Presence] in Urine
	 * sediment by Light microscopy</div>
	 */
	public static final String CALCIUM_OXALATE_CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "5774-5";

	/**
	 * <div class="en">Code for Cannabinoids [Presence] in Urine by Screen
	 * method</div>
	 */
	public static final String CANNABINOIDS_PRESENCE_IN_URINE_BY_SCREEN_METHOD_CODE = "18282-4";

	/**
	 * <div class="en">Code for Cannabinoids [Presence] in Urine</div>
	 */
	public static final String CANNABINOIDS_PRESENCE_IN_URINE_CODE = "3427-2";

	/**
	 * <div class="en">Code for Carbon dioxide [Partial pressure] in Blood</div>
	 */
	public static final String CARBON_DIOXIDE_PARTIAL_PRESSURE_IN_BLOOD_CODE = "11557-6";

	/**
	 * <div class="en">Code for Carbon dioxide [Partial pressure] in Venous
	 * blood</div>
	 */
	public static final String CARBON_DIOXIDE_PARTIAL_PRESSURE_IN_VENOUS_BLOOD_CODE = "2021-4";

	/**
	 * <div class="en">Code for Carcinoembryonic Ag [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CARCINOEMBRYONIC_AG_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2039-6";

	/**
	 * <div class="en">Code for Carcinoembryonic Ag [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CARCINOEMBRYONIC_AG_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "19167-6";

	/**
	 * <div class="en">Code for Carcinoembryonic Ag [Units/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CARCINOEMBRYONIC_AG_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "19166-8";

	/**
	 * <div class="en">Code for Caspofungin [Susceptibility]</div>
	 */
	public static final String CASPOFUNGIN_SUSCEPTIBILITY_CODE = "32378-2";

	/**
	 * <div class="en">Code for Cat dander IgE Ab RAST class [Presence] in
	 * Serum</div>
	 */
	public static final String CAT_DANDER_IGE_AB_RAST_CLASS_PRESENCE_IN_SERUM_CODE = "15609-1";

	/**
	 * <div class="en">Code for Cat dander IgE Ab [Units/volume] in Serum</div>
	 */
	public static final String CAT_DANDER_IGE_AB_UNITSVOLUME_IN_SERUM_CODE = "6833-8";

	/**
	 * <div class="en">Code for CD16+CD56+ cells [#/volume] in Blood</div>
	 */
	public static final String CD16_CD56_CELLS_VOLUME_IN_BLOOD_CODE = "20402-4";

	/**
	 * <div class="en">Code for CD16+CD56+ cells/100 cells in Blood</div>
	 */
	public static final String CD16_CD56_CELLS100_CELLS_IN_BLOOD_CODE = "18267-5";

	/**
	 * <div class="en">Code for CD19 cells [#/volume] in Blood</div>
	 */
	public static final String CD19_CELLS_VOLUME_IN_BLOOD_CODE = "8116-6";

	/**
	 * <div class="en">Code for CD19 cells/100 cells in Blood</div>
	 */
	public static final String CD19_CELLS100_CELLS_IN_BLOOD_CODE = "8117-4";

	/**
	 * <div class="en">Code for CD3+CD4+ (T4 helper) cells [#/volume] in
	 * Blood</div>
	 */
	public static final String CD3_CD4_T4_HELPER_CELLS_VOLUME_IN_BLOOD_CODE = "24467-3";

	/**
	 * <div class="en">Code for CD3+CD4+ (T4 helper) cells/100 cells in
	 * Blood</div>
	 */
	public static final String CD3_CD4_T4_HELPER_CELLS100_CELLS_IN_BLOOD_CODE = "8123-2";

	/**
	 * <div class="en">Code for CD3+CD4+ (T4 helper) cells/CD3+CD8+ (T8 suppressor
	 * cells) cells [# Ratio] in Blood</div>
	 */
	public static final String CD3_CD4_T4_HELPER_CELLSCD3_CD8_T8_SUPPRESSOR_CELLS_CELLS_RATIO_IN_BLOOD_CODE = "54218-3";

	/**
	 * <div class="en">Code for CD3+CD8+ (T8 suppressor cells) cells [#/volume] in
	 * Blood</div>
	 */
	public static final String CD3_CD8_T8_SUPPRESSOR_CELLS_CELLS_VOLUME_IN_BLOOD_CODE = "14135-8";

	/**
	 * <div class="en">Code for CD3+CD8+ (T8 suppressor cells) cells/100 cells in
	 * Blood</div>
	 */
	public static final String CD3_CD8_T8_SUPPRESSOR_CELLS_CELLS100_CELLS_IN_BLOOD_CODE = "8101-8";

	/**
	 * <div class="en">Code for CD3 cells [#/volume] in Blood</div>
	 */
	public static final String CD3_CELLS_VOLUME_IN_BLOOD_CODE = "8122-4";

	/**
	 * <div class="en">Code for CD3 cells/100 cells in Blood</div>
	 */
	public static final String CD3_CELLS100_CELLS_IN_BLOOD_CODE = "8124-0";

	/**
	 * <div class="en">Code for Chlamydia trachomatis DNA [Presence] in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "21613-5";

	/**
	 * <div class="en">Code for Chloride [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String CHLORIDE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2075-0";

	/**
	 * <div class="en">Code for Cholecalciferol (Vit D3) [Mass/?volume] in Serum
	 * or Plasma</div>
	 */
	public static final String CHOLECALCIFEROL_VIT_D3_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "1990-1";

	/**
	 * <div class="en">Code for Cholecalciferol (Vit D3) [Moles/?volume] in Serum
	 * or Plasma</div>
	 */
	public static final String CHOLECALCIFEROL_VIT_D3_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "33958-0";

	/**
	 * <div class="en">Code for Cholesterol in HDL [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CHOLESTEROL_IN_HDL_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2085-9";

	/**
	 * <div class="en">Code for Cholesterol in HDL [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CHOLESTEROL_IN_HDL_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14646-4";

	/**
	 * <div class="en">Code for Cholesterol [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String CHOLESTEROL_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2093-3";

	/**
	 * <div class="en">Code for Cholesterol [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CHOLESTEROL_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14647-2";

	/**
	 * <div class="en">Code for Choriogonadotropin.beta subunit free
	 * [Moles/?volume] in Serum or Plasma</div>
	 */
	public static final String CHORIOGONADOTROPIN_BETA_SUBUNIT_FREE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2115-4";

	/**
	 * <div class="en">Code for Choriogonadotropin.beta subunit [Units/?volume] in
	 * Serum or Plasma</div>
	 */
	public static final String CHORIOGONADOTROPIN_BETA_SUBUNIT_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "21198-7";

	/**
	 * <div class="en">Code for Choriogonadotropin [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CHORIOGONADOTROPIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "34670-0";

	/**
	 * <div class="en">Code for Choriogonadotropin [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CHORIOGONADOTROPIN_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2119-6";

	/**
	 * <div class="en">Code for Choriogonadotropin [Units/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CHORIOGONADOTROPIN_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "19080-1";

	/**
	 * <div class="en">Code for Chromosome analysis.interphase [interpretation] in
	 * Unspecified specimen by Fluorescent in situ hybridization (FISH)
	 * Narrative</div>
	 */
	public static final String CHROMOSOME_ANALYSIS_INTERPHASE_INTERPRETATION_IN_UNSPECIFIED_SPECIMEN_BY_FLUORESCENT_IN_SITU_HYBRIDIZATION_FISH_NARRATIVE_CODE = "59050-5";

	/**
	 * <div class="en">Code for Chromosome analysis master panel - Blood or
	 * Tissue</div>
	 */
	public static final String CHROMOSOME_ANALYSIS_MASTER_PANEL_BLOOD_OR_TISSUE_CODE = "62389-2";

	/**
	 * <div class="en">Code for Chromosome analysis.metaphase panel - Blood by
	 * Fluorescent in situ hybridization (FISH)</div>
	 */
	public static final String CHROMOSOME_ANALYSIS_METAPHASE_PANEL_BLOOD_BY_FLUORESCENT_IN_SITU_HYBRIDIZATION_FISH_CODE = "62344-7";

	/**
	 * <div class="en">Code for Chromosome [Identifier] in Blood or Tissue by
	 * Molecular genetics method</div>
	 */
	public static final String CHROMOSOME_IDENTIFIER_IN_BLOOD_OR_TISSUE_BY_MOLECULAR_GENETICS_METHOD_CODE = "48000-4";

	/**
	 * <div class="en">Code for Clarity of Urine</div>
	 */
	public static final String CLARITY_OF_URINE_CODE = "32167-9";

	/**
	 * <div class="en">Code for Clostridium difficile DNA [Presence] in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String CLOSTRIDIUM_DIFFICILE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "61367-9";

	/**
	 * <div class="en">Code for Coarse Granular Casts [#/area] in Urine sediment
	 * by Automated count</div>
	 */
	public static final String COARSE_GRANULAR_CASTS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT_CODE = "33227-0";

	/**
	 * <div class="en">Code for Coarse Granular Casts [Presence] in Urine sediment
	 * by Light microscopy</div>
	 */
	public static final String COARSE_GRANULAR_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "32175-2";

	/**
	 * <div class="en">Code for Cobalamin (Vitamin B12) [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String COBALAMIN_VITAMIN_B12_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2132-9";

	/**
	 * <div class="en">Code for Cobalamin (Vitamin B12) [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String COBALAMIN_VITAMIN_B12_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14685-2";

	/**
	 * <div class="en">Code for Cocaine [Presence] in Urine by Screen method</div>
	 */
	public static final String COCAINE_PRESENCE_IN_URINE_BY_SCREEN_METHOD_CODE = "19359-9";

	/**
	 * <div class="en">Code for Cocaine [Presence] in Urine</div>
	 */
	public static final String COCAINE_PRESENCE_IN_URINE_CODE = "3397-7";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "qc-labObsList";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.144.1.2.2016.1";

	/**
	 * <div class="en">Code for Cortisol [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String CORTISOL_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2143-6";

	/**
	 * <div class="en">Code for Cortisol [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String CORTISOL_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14675-3";

	/**
	 * <div class="en">Code for Creatine kinase [Enzymatic activity/volume] in
	 * Serum or Plasma</div>
	 */
	public static final String CREATINE_KINASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "2157-6";

	/**
	 * <div class="en">Code for Creatinine [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String CREATININE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2160-0";

	/**
	 * <div class="en">Code for Creatinine [Mass/volume] in Urine</div>
	 */
	public static final String CREATININE_MASSVOLUME_IN_URINE_CODE = "2161-8";

	/**
	 * <div class="en">Code for Creatinine [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String CREATININE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14682-9";

	/**
	 * <div class="en">Code for Creatinine [Moles/volume] in Urine</div>
	 */
	public static final String CREATININE_MOLESVOLUME_IN_URINE_CODE = "14683-7";

	/**
	 * <div class="en">Code for Crystals.amorphous [Presence] in Urine sediment by
	 * Light microscopy</div>
	 */
	public static final String CRYSTALS_AMORPHOUS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "60340-7";

	/**
	 * <div class="en">Code for Crystals [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	public static final String CRYSTALS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT_CODE = "53322-4";

	/**
	 * <div class="en">Code for Crystals [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	public static final String CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "49755-2";

	/**
	 * <div class="en">Code for Cyclic citrullinated peptide Ab [Units/?volume] in
	 * Serum by Immunoassay</div>
	 */
	public static final String CYCLIC_CITRULLINATED_PEPTIDE_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "32218-0";

	/**
	 * <div class="en">Code for Cyclic citrullinated peptide Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String CYCLIC_CITRULLINATED_PEPTIDE_AB_UNITSVOLUME_IN_SERUM_CODE = "53027-9";

	/**
	 * <div class="en">Code for Cyclic citrullinated peptide IgG Ab
	 * [Units/?volume] in Serum</div>
	 */
	public static final String CYCLIC_CITRULLINATED_PEPTIDE_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "33935-8";

	/**
	 * <div class="en">Code for Cystine crystals [Presence] in Urine sediment by
	 * Light microscopy</div>
	 */
	public static final String CYSTINE_CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "5784-4";

	/**
	 * <div class="en">Code for Cytomegalovirus Ab [Presence] in Serum</div>
	 */
	public static final String CYTOMEGALOVIRUS_AB_PRESENCE_IN_SERUM_CODE = "22239-8";

	/**
	 * <div class="en">Code for Cytomegalovirus DNA [Units/?volume] (viral load)
	 * in Plasma by Probe and target amplification method</div>
	 */
	public static final String CYTOMEGALOVIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "72493-0";

	/**
	 * <div class="en">Code for Cytomegalovirus DNA [#/?volume] (viral load) in
	 * Serum or Plasma by Probe and target amplification method</div>
	 */
	public static final String CYTOMEGALOVIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "30247-1";

	/**
	 * <div class="en">Code for Cytomegalovirus IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String CYTOMEGALOVIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "13949-3";

	/**
	 * <div class="en">Code for Cytomegalovirus IgG Ab [Presence] in Serum</div>
	 */
	public static final String CYTOMEGALOVIRUS_IGG_AB_PRESENCE_IN_SERUM_CODE = "22244-8";

	/**
	 * <div class="en">Code for Cytomegalovirus IgG Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String CYTOMEGALOVIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5124-3";

	/**
	 * <div class="en">Code for Cytomegalovirus IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String CYTOMEGALOVIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "7852-7";

	/**
	 * <div class="en">Code for Cytomegalovirus IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String CYTOMEGALOVIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "24119-0";

	/**
	 * <div class="en">Code for Cytomegalovirus IgM Ab [Presence] in Serum</div>
	 */
	public static final String CYTOMEGALOVIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE = "30325-5";

	/**
	 * <div class="en">Code for Cytomegalovirus IgM Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String CYTOMEGALOVIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5126-8";

	/**
	 * <div class="en">Code for Cytomegalovirus IgM Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String CYTOMEGALOVIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE = "7853-5";

	/**
	 * <div class="en">Code for D Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String D_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "975-3";

	/**
	 * <div class="en">Code for Desipramine [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String DESIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3531-1";

	/**
	 * <div class="en">Code for Desipramine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String DESIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14691-0";

	/**
	 * <div class="en">Code for Digoxin [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String DIGOXIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "10535-3";

	/**
	 * <div class="en">Code for Digoxin [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String DIGOXIN_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14698-5";

	/**
	 * <div class="en">Code for E Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String E_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1018-1";

	/**
	 * <div class="en">Code for Enterovirus RNA [Presence] in Unspecified specimen
	 * by Probe and target amplification method</div>
	 */
	public static final String ENTEROVIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "29591-5";

	/**
	 * <div class="en">Code for Eosinophils/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	public static final String EOSINOPHILS100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "714-6";

	/**
	 * <div class="en">Code for Epithelial cells [#/area] in Urine sediment by
	 * Automated count</div>
	 */
	public static final String EPITHELIAL_CELLS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT_CODE = "33342-7";

	/**
	 * <div class="en">Code for Epithelial cells [Presence] in Urine sediment by
	 * Light microscopy</div>
	 */
	public static final String EPITHELIAL_CELLS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "20453-7";

	/**
	 * <div class="en">Code for Epithelial cells.renal [#/?volume] in Urine
	 * sediment</div>
	 */
	public static final String EPITHELIAL_CELLS_RENAL_VOLUME_IN_URINE_SEDIMENT_CODE = "13653-1";

	/**
	 * <div class="en">Code for Epithelial cells.squamous [#/?volume] in Urine
	 * sediment</div>
	 */
	public static final String EPITHELIAL_CELLS_SQUAMOUS_VOLUME_IN_URINE_SEDIMENT_CODE = "13654-9";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgG Ab [Presence] in
	 * Serum by Immunoassay</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "24114-1";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgG Ab [Presence] in
	 * Serum</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_PRESENCE_IN_SERUM_CODE = "30339-6";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgG Ab [Units/?volume]
	 * in Serum by Immunoassay</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5157-3";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgG Ab [Units/?volume]
	 * in Serum</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "7885-7";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgM Ab [Presence] in
	 * Serum by Immunoassay</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "24115-8";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgM Ab [Presence] in
	 * Serum</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_PRESENCE_IN_SERUM_CODE = "30340-4";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgM Ab [Units/?volume]
	 * in Serum by Immunoassay</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5159-9";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgM Ab [Units/?volume]
	 * in Serum</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_UNITSVOLUME_IN_SERUM_CODE = "7886-5";

	/**
	 * <div class="en">Code for Epstein Barr virus DNA [#/?volume] (viral load) in
	 * Serum or Plasma by Probe and target amplification method</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "47982-4";

	/**
	 * <div class="en">Code for Epstein Barr virus DNA [#/?volume] (viral load) in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "32585-2";

	/**
	 * <div class="en">Code for Epstein Barr virus early IgG Ab [Presence] in
	 * Serum by Immunoassay</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_EARLY_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "40752-8";

	/**
	 * <div class="en">Code for Epstein Barr virus early IgG Ab [Presence] in
	 * Serum</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_EARLY_IGG_AB_PRESENCE_IN_SERUM_CODE = "22295-0";

	/**
	 * <div class="en">Code for Epstein Barr virus early IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_EARLY_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "24007-7";

	/**
	 * <div class="en">Code for Epstein Barr virus nuclear IgG Ab [Presence] in
	 * Serum by Immunoassay</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_NUCLEAR_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "5156-5";

	/**
	 * <div class="en">Code for Epstein Barr virus nuclear IgG Ab [Presence] in
	 * Serum</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_NUCLEAR_IGG_AB_PRESENCE_IN_SERUM_CODE = "7883-2";

	/**
	 * <div class="en">Code for Epstein Barr virus nuclear IgG Ab [Units/?volume]
	 * in Serum by Immunoassay</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_NUCLEAR_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "30083-0";

	/**
	 * <div class="en">Code for Epstein Barr virus nuclear IgG Ab [Units/?volume]
	 * in Serum</div>
	 */
	public static final String EPSTEIN_BARR_VIRUS_NUCLEAR_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "31374-2";

	/**
	 * <div class="en">Code for Erythrocytes [#/area] in Urine sediment by
	 * Automated count</div>
	 */
	public static final String ERYTHROCYTES_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT_CODE = "46419-8";

	/**
	 * <div class="en">Code for Erythrocytes [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	public static final String ERYTHROCYTES_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "32776-7";

	/**
	 * <div class="en">Code for Erythrocytes [#/?volume] in Blood by Automated
	 * count</div>
	 */
	public static final String ERYTHROCYTES_VOLUME_IN_BLOOD_BY_AUTOMATED_COUNT_CODE = "789-8";

	/**
	 * <div class="en">Code for Erythrocytes [#/volume] in Blood by Manual
	 * count</div>
	 */
	public static final String ERYTHROCYTES_VOLUME_IN_BLOOD_BY_MANUAL_COUNT_CODE = "790-6";

	/**
	 * <div class="en">Code for Erythrocytes [#/volume] in Urine by Automated test
	 * strip</div>
	 */
	public static final String ERYTHROCYTES_VOLUME_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "57747-8";

	/**
	 * <div class="en">Code for Erythrocytes [#/volume] in Urine by Test
	 * strip</div>
	 */
	public static final String ERYTHROCYTES_VOLUME_IN_URINE_BY_TEST_STRIP_CODE = "20409-9";

	/**
	 * <div class="en">Code for Erythrocytes [#/?volume] in Urine sediment by
	 * Microscopy high power field</div>
	 */
	public static final String ERYTHROCYTES_VOLUME_IN_URINE_SEDIMENT_BY_MICROSCOPY_HIGH_POWER_FIELD_CODE = "5808-1";

	/**
	 * <div class="en">Code for Estradiol (E2) [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String ESTRADIOL_E2_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2243-4";

	/**
	 * <div class="en">Code for Estradiol (E2) [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String ESTRADIOL_E2_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14715-7";

	/**
	 * <div class="en">Code for Ethambutol 10 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ETHAMBUTOL_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25195-9";

	/**
	 * <div class="en">Code for Ethambutol 2.5 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String ETHAMBUTOL_2_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25230-4";

	/**
	 * <div class="en">Code for Ethambutol 2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ETHAMBUTOL_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "55674-6";

	/**
	 * <div class="en">Code for Ethambutol 5 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ETHAMBUTOL_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25194-2";

	/**
	 * <div class="en">Code for Ethambutol 7.5 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String ETHAMBUTOL_7_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25187-6";

	/**
	 * <div class="en">Code for Ethambutol 8 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ETHAMBUTOL_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "56025-0";

	/**
	 * <div class="en">Code for Ethambutol+Rifampin [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ETHAMBUTOL_RIFAMPIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "55154-9";

	/**
	 * <div class="en">Code for Ethambutol [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ETHAMBUTOL_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "20381-0";

	/**
	 * <div class="en">Code for Ferritin [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String FERRITIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2276-4";

	/**
	 * <div class="en">Code for Fibrin D-dimer FEU [Mass/volume] in Platelet poor
	 * plasma by Immunoassay</div>
	 */
	public static final String FIBRIN_D_DIMER_FEU_MASSVOLUME_IN_PLATELET_POOR_PLASMA_BY_IMMUNOASSAY_CODE = "48067-3";

	/**
	 * <div class="en">Code for Fibrin D-dimer FEU [Mass/volume] in Platelet poor
	 * plasma</div>
	 */
	public static final String FIBRIN_D_DIMER_FEU_MASSVOLUME_IN_PLATELET_POOR_PLASMA_CODE = "48065-7";

	/**
	 * <div class="en">Code for Fibrin D-dimer [Presence] in Platelet poor
	 * plasma</div>
	 */
	public static final String FIBRIN_D_DIMER_PRESENCE_IN_PLATELET_POOR_PLASMA_CODE = "15179-5";

	/**
	 * <div class="en">Code for Fibrinogen [Mass/volume] in Platelet poor plasma
	 * by Coagulation assay</div>
	 */
	public static final String FIBRINOGEN_MASSVOLUME_IN_PLATELET_POOR_PLASMA_BY_COAGULATION_ASSAY_CODE = "3255-7";

	/**
	 * <div class="en">Code for Fine Granular Casts [#/area] in Urine sediment by
	 * Automated count</div>
	 */
	public static final String FINE_GRANULAR_CASTS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT_CODE = "33225-4";

	/**
	 * <div class="en">Code for Fine Granular Casts [Presence] in Urine sediment
	 * by Light microscopy</div>
	 */
	public static final String FINE_GRANULAR_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "32176-0";

	/**
	 * <div class="en">Code for Fluconazole [Susceptibility]</div>
	 */
	public static final String FLUCONAZOLE_SUSCEPTIBILITY_CODE = "18924-1";

	/**
	 * <div class="en">Code for Fluoxetine [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String FLUOXETINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3644-2";

	/**
	 * <div class="en">Code for Fluoxetine [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String FLUOXETINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14728-0";

	/**
	 * <div class="en">Code for Fluoxetine+Norfluoxetine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String FLUOXETINE_NORFLUOXETINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "10339-0";

	/**
	 * <div class="en">Code for Folate [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String FOLATE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2284-8";

	/**
	 * <div class="en">Code for Folate [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String FOLATE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14732-2";

	/**
	 * <div class="en">Code for Follitropin [Units/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String FOLLITROPIN_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "15067-2";

	/**
	 * <div class="en">Code for Fungus identified in Unspecified specimen by
	 * Culture</div>
	 */
	public static final String FUNGUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE = "580-1";

	/**
	 * <div class="en">Code for Fy sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String FY_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1024-9";

	/**
	 * <div class="en">Code for Fy sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String FY_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1030-6";

	/**
	 * <div class="en">Code for Gamma glutamyl transferase [Enzymatic
	 * activity/volume] in Serum or Plasma</div>
	 */
	public static final String GAMMA_GLUTAMYL_TRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "2324-2";

	/**
	 * <div class="en">Code for Glucose [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String GLUCOSE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2345-7";

	/**
	 * <div class="en">Code for Glucose [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String GLUCOSE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14749-6";

	/**
	 * <div class="en">Code for Glucose [Presence] in Urine by Automated test
	 * strip</div>
	 */
	public static final String GLUCOSE_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "50555-2";

	/**
	 * <div class="en">Code for Glucose [Presence] in Urine by Test strip</div>
	 */
	public static final String GLUCOSE_PRESENCE_IN_URINE_BY_TEST_STRIP_CODE = "25428-4";

	/**
	 * <div class="en">Code for Granular casts [Presence] in Urine sediment by
	 * Light microscopy</div>
	 */
	public static final String GRANULAR_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "25160-3";

	/**
	 * <div class="en">Code for H Ab [Presence] in Serum</div>
	 */
	public static final String H_AB_PRESENCE_IN_SERUM_CODE = "1044-7";

	/**
	 * <div class="en">Code for Hematocrit [Volume Fraction] of Blood</div>
	 */
	public static final String HEMATOCRIT_VOLUME_FRACTION_OF_BLOOD_CODE = "20570-8";

	/**
	 * <div class="en">Code for Hemoglobin A1c [Mass/?volume] in Blood</div>
	 */
	public static final String HEMOGLOBIN_A1C_MASSVOLUME_IN_BLOOD_CODE = "41995-2";

	/**
	 * <div class="en">Code for Hemoglobin A1c/Hemoglobin.total in Blood by
	 * HPLC</div>
	 */
	public static final String HEMOGLOBIN_A1CHEMOGLOBIN_TOTAL_IN_BLOOD_BY_HPLC_CODE = "17856-6";

	/**
	 * <div class="en">Code for Hemoglobin A1c/Hemoglobin.total in Blood by IFCC
	 * protocol</div>
	 */
	public static final String HEMOGLOBIN_A1CHEMOGLOBIN_TOTAL_IN_BLOOD_BY_IFCC_PROTOCOL_CODE = "59261-8";

	/**
	 * <div class="en">Code for Hemoglobin A1c/Hemoglobin.total in Blood</div>
	 */
	public static final String HEMOGLOBIN_A1CHEMOGLOBIN_TOTAL_IN_BLOOD_CODE = "4548-4";

	/**
	 * <div class="en">Code for Hemoglobin [Mass/volume] in Blood</div>
	 */
	public static final String HEMOGLOBIN_MASSVOLUME_IN_BLOOD_CODE = "718-7";

	/**
	 * <div class="en">Code for Hemoglobin [Moles/?volume] in Blood</div>
	 */
	public static final String HEMOGLOBIN_MOLESVOLUME_IN_BLOOD_CODE = "59260-0";

	/**
	 * <div class="en">Code for Hemoglobin [Presence] in Urine by Automated test
	 * strip</div>
	 */
	public static final String HEMOGLOBIN_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "57751-0";

	/**
	 * <div class="en">Code for Hemoglobin [Presence] in Urine by Test strip</div>
	 */
	public static final String HEMOGLOBIN_PRESENCE_IN_URINE_BY_TEST_STRIP_CODE = "5794-3";

	/**
	 * <div class="en">Code for Hepatitis A virus Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_A_VIRUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "13951-9";

	/**
	 * <div class="en">Code for Hepatitis A virus Ab [Presence] in Serum</div>
	 */
	public static final String HEPATITIS_A_VIRUS_AB_PRESENCE_IN_SERUM_CODE = "20575-7";

	/**
	 * <div class="en">Code for Hepatitis A virus Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_A_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5183-9";

	/**
	 * <div class="en">Code for Hepatitis A virus Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_A_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE = "22312-3";

	/**
	 * <div class="en">Code for Hepatitis A virus IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_A_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "40724-7";

	/**
	 * <div class="en">Code for Hepatitis A virus IgG Ab [Presence] in Serum</div>
	 */
	public static final String HEPATITIS_A_VIRUS_IGG_AB_PRESENCE_IN_SERUM_CODE = "32018-4";

	/**
	 * <div class="en">Code for Hepatitis A virus IgG Ab [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	public static final String HEPATITIS_A_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5179-7";

	/**
	 * <div class="en">Code for Hepatitis A virus IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_A_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "22313-1";

	/**
	 * <div class="en">Code for Hepatitis A virus IgG+?IgM Ab [Presence] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_A_VIRUS_IGG_IGM_AB_PRESENCE_IN_SERUM_CODE = "51913-2";

	/**
	 * <div class="en">Code for Hepatitis A virus IgM Ab [Presence] in Serum</div>
	 */
	public static final String HEPATITIS_A_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE = "22314-9";

	/**
	 * <div class="en">Code for Hepatitis A virus IgM Ab [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	public static final String HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5181-3";

	/**
	 * <div class="en">Code for Hepatitis A virus IgM Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE = "22315-6";

	/**
	 * <div class="en">Code for Hepatitis B virus core Ab [Presence] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_CORE_AB_PRESENCE_IN_SERUM_CODE = "16933-4";

	/**
	 * <div class="en">Code for Hepatitis B virus core Ab [Presence] in Serum or
	 * Plasma by Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_CORE_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE = "13952-7";

	/**
	 * <div class="en">Code for Hepatitis B virus core Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_CORE_AB_UNITSVOLUME_IN_SERUM_CODE = "22316-4";

	/**
	 * <div class="en">Code for Hepatitis B virus core IgG+?IgM Ab [Presence] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_CORE_IGG_IGM_AB_PRESENCE_IN_SERUM_CODE = "51914-0";

	/**
	 * <div class="en">Code for Hepatitis B virus core IgM Ab [Presence] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_SERUM_CODE = "31204-1";

	/**
	 * <div class="en">Code for Hepatitis B virus core IgM Ab [Presence] in Serum
	 * or Plasma by Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE = "24113-3";

	/**
	 * <div class="en">Code for Hepatitis B virus core IgM Ab [Units/?volume] in
	 * Serum by Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5185-4";

	/**
	 * <div class="en">Code for Hepatitis B virus DNA [Units/?volume] (viral load)
	 * in Serum or Plasma by Probe and target amplification method</div>
	 */
	public static final String HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "42595-9";

	/**
	 * <div class="en">Code for Hepatitis B virus DNA [#/?volume] (viral load) in
	 * Serum or Plasma by Probe and target amplification method</div>
	 */
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "29615-2";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "13953-5";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ab [Presence] in Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_AB_PRESENCE_IN_SERUM_CODE = "22320-6";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5189-6";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_AB_UNITSVOLUME_IN_SERUM_CODE = "22321-4";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ag [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "13954-3";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ag [Presence] in Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM_CODE = "31844-4";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ag [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5191-2";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ag [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_AG_UNITSVOLUME_IN_SERUM_CODE = "31845-1";

	/**
	 * <div class="en">Code for Hepatitis B virus e IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "33463-1";

	/**
	 * <div class="en">Code for Hepatitis B virus e IgG Ab [Presence] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_E_IGG_AB_PRESENCE_IN_SERUM_CODE = "41151-2";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ab [Presence] in Serum
	 * by Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "10900-9";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ab [Presence] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AB_PRESENCE_IN_SERUM_CODE = "22322-2";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ab [Units/?volume] in
	 * Serum by Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5193-8";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AB_UNITSVOLUME_IN_SERUM_CODE = "16935-9";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ag [Presence] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_CODE = "5195-3";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ag [Presence] in Serum
	 * or Plasma by Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE = "5196-1";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ag [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_UNITSVOLUME_IN_SERUM_CODE = "58452-4";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ag [Units/?volume] in
	 * Serum or Plasma by Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_UNITSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE = "63557-3";

	/**
	 * <div class="en">Code for Hepatitis B virus surface IgG Ab [Presence] in
	 * Serum by Immunoassay</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "48070-7";

	/**
	 * <div class="en">Code for Hepatitis B virus surface IgG Ab [Presence] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_IGG_AB_PRESENCE_IN_SERUM_CODE = "49177-9";

	/**
	 * <div class="en">Code for Hepatitis C virus Ab [Presence] in Serum by
	 * Immunoblot (IB)</div>
	 */
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE = "5199-5";

	/**
	 * <div class="en">Code for Hepatitis C virus Ab [Presence] in Serum</div>
	 */
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_CODE = "16128-1";

	/**
	 * <div class="en">Code for Hepatitis C virus Ab [Presence] in Serum or Plasma
	 * by Immunoassay</div>
	 */
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE = "13955-0";

	/**
	 * <div class="en">Code for Hepatitis C virus Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_C_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5198-7";

	/**
	 * <div class="en">Code for Hepatitis C virus genotype [Identifier] in Serum
	 * or Plasma by Probe and target amplification method</div>
	 */
	public static final String HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "32286-7";

	/**
	 * <div class="en">Code for Hepatitis C virus IgG Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "40726-2";

	/**
	 * <div class="en">Code for Hepatitis C virus IgG Ab [Presence] in Serum by
	 * Immunoblot (IB)</div>
	 */
	public static final String HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE = "33462-3";

	/**
	 * <div class="en">Code for Hepatitis C virus IgG Ab [Presence] in Serum</div>
	 */
	public static final String HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_CODE = "16129-9";

	/**
	 * <div class="en">Code for Hepatitis C virus IgG Ab [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	public static final String HEPATITIS_C_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "57006-9";

	/**
	 * <div class="en">Code for Hepatitis C virus IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String HEPATITIS_C_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "16936-7";

	/**
	 * <div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load)
	 * in Serum or Plasma by Probe and target amplification method</div>
	 */
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "11011-4";

	/**
	 * <div class="en">Code for Hepatitis C virus RNA [#/?volume] (viral load) in
	 * Serum or Plasma by Probe and target amplification method</div>
	 */
	public static final String HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "20416-4";

	/**
	 * <div class="en">Code for Herpes simplex virus 1+?2 DNA [Presence] in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String HERPES_SIMPLEX_VIRUS_1_2_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "20444-6";

	/**
	 * <div class="en">Code for Herpes simplex virus 1 DNA [Presence] in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String HERPES_SIMPLEX_VIRUS_1_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "16130-7";

	/**
	 * <div class="en">Code for Herpes simplex virus 2 DNA [Presence] in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String HERPES_SIMPLEX_VIRUS_2_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "16131-5";

	/**
	 * <div class="en">Code for HIV 1+2 Ab+HIV1 p24 Ag [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String HIV_1_2_AB_HIV1_P24_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "56888-1";

	/**
	 * <div class="en">Code for HIV 1+?2 Ab+?HIV1 p24 Ag [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	public static final String HIV_1_2_AB_HIV1_P24_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "58900-2";

	/**
	 * <div class="en">Code for HIV 1+?2 Ab [Presence] in Serum by Immunoblot
	 * (IB)</div>
	 */
	public static final String HIV_1_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE = "44873-8";

	/**
	 * <div class="en">Code for HIV 1+?2 Ab [Presence] in Unspecified specimen by
	 * Rapid immunoassay</div>
	 */
	public static final String HIV_1_2_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_RAPID_IMMUNOASSAY_CODE = "49580-4";

	/**
	 * <div class="en">Code for HIV 1 Ab [Presence] in Serum by Immunoblot
	 * (IB)</div>
	 */
	public static final String HIV_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE = "5221-7";

	/**
	 * <div class="en">Code for HIV 1 IgG Ab [Presence] in Serum by Immunoblot
	 * (IB)</div>
	 */
	public static final String HIV_1_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE = "40732-0";

	/**
	 * <div class="en">Code for HIV 1 RNA [Units/?volume] (viral load) in Serum or
	 * Plasma by Probe and target amplification method</div>
	 */
	public static final String HIV_1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "62469-2";

	/**
	 * <div class="en">Code for HIV 1 RNA [#/?volume] (viral load) in Serum or
	 * Plasma by Probe and target amplification method</div>
	 */
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "20447-9";

	/**
	 * <div class="en">Code for HIV 2 Ab [Presence] in Serum by Immunoblot
	 * (IB)</div>
	 */
	public static final String HIV_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE = "5225-8";

	/**
	 * <div class="en">Code for HIV 2 IgG Ab [Presence] in Serum by Immunoblot
	 * (IB)</div>
	 */
	public static final String HIV_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE = "33806-1";

	/**
	 * <div class="en">Code for Hyaline casts [#/area] in Urine sediment by
	 * Automated count</div>
	 */
	public static final String HYALINE_CASTS_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT_CODE = "33223-9";

	/**
	 * <div class="en">Code for Hyaline casts [Presence] in Urine sediment by
	 * Light microscopy</div>
	 */
	public static final String HYALINE_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "25162-9";

	/**
	 * <div class="en">Code for I Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String I_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1060-3";

	/**
	 * <div class="en">Code for IgA [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String IGA_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2458-8";

	/**
	 * <div class="en">Code for IgE [Units/volume] in Serum or Plasma</div>
	 */
	public static final String IGE_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "19113-0";

	/**
	 * <div class="en">Code for IgG [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String IGG_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2465-3";

	/**
	 * <div class="en">Code for IgM [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String IGM_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2472-9";

	/**
	 * <div class="en">Code for IH Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String IH_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "58078-7";

	/**
	 * <div class="en">Code for Imipramine+Desipramine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String IMIPRAMINE_DESIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "9627-1";

	/**
	 * <div class="en">Code for Imipramine+Desipramine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String IMIPRAMINE_DESIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14794-2";

	/**
	 * <div class="en">Code for Imipramine [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String IMIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3690-5";

	/**
	 * <div class="en">Code for Imipramine [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String IMIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "15107-6";

	/**
	 * <div class="en">Code for Influenza virus A+B RNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	public static final String INFLUENZA_VIRUS_A_B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "62462-7";

	/**
	 * <div class="en">Code for INR in Blood by Coagulation assay</div>
	 */
	public static final String INR_IN_BLOOD_BY_COAGULATION_ASSAY_CODE = "34714-6";

	/**
	 * <div class="en">Code for Iron [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String IRON_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2498-4";

	/**
	 * <div class="en">Code for Iron [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String IRON_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14798-3";

	/**
	 * <div class="en">Code for Isoniazid 0.1 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ISONIAZID_0_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25217-1";

	/**
	 * <div class="en">Code for Isoniazid 0.2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ISONIAZID_0_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25218-9";

	/**
	 * <div class="en">Code for Isoniazid 0.4 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ISONIAZID_0_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "29315-9";

	/**
	 * <div class="en">Code for Isoniazid 1 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ISONIAZID_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25219-7";

	/**
	 * <div class="en">Code for Isoniazid 10 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ISONIAZID_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "55685-2";

	/**
	 * <div class="en">Code for Isoniazid 2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ISONIAZID_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "45215-1";

	/**
	 * <div class="en">Code for Isoniazid 5 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ISONIAZID_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "42651-0";

	/**
	 * <div class="en">Code for Isoniazid [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String ISONIAZID_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "20383-6";

	/**
	 * <div class="en">Code for Itraconazole [Susceptibility]</div>
	 */
	public static final String ITRACONAZOLE_SUSCEPTIBILITY_CODE = "32603-3";

	/**
	 * <div class="en">Code for Jk sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String JK_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1069-4";

	/**
	 * <div class="en">Code for Jk sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String JK_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1075-1";

	/**
	 * <div class="en">Code for Js sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String JS_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1081-9";

	/**
	 * <div class="en">Code for Js sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String JS_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1087-6";

	/**
	 * <div class="en">Code for K Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String K_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1093-4";

	/**
	 * <div class="en">Code for Karyotype [Identifier] in Blood or Tissue
	 * Narrative</div>
	 */
	public static final String KARYOTYPE_IDENTIFIER_IN_BLOOD_OR_TISSUE_NARRATIVE_CODE = "50619-6";

	/**
	 * <div class="en">Code for Karyotype [Identifier] in Blood or Tissue
	 * Nominal</div>
	 */
	public static final String KARYOTYPE_IDENTIFIER_IN_BLOOD_OR_TISSUE_NOMINAL_CODE = "29770-5";

	/**
	 * <div class="en">Code for Ketones [Presence] in Urine by Automated test
	 * strip</div>
	 */
	public static final String KETONES_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "57734-6";

	/**
	 * <div class="en">Code for Kp sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String KP_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1099-1";

	/**
	 * <div class="en">Code for Kp sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String KP_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1105-6";

	/**
	 * <div class="en">Code for Lactate dehydrogenase [Enzymatic activity/volume]
	 * in Serum or Plasma by Lactate to pyruvate reaction</div>
	 */
	public static final String LACTATE_DEHYDROGENASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_BY_LACTATE_TO_PYRUVATE_REACTION_CODE = "14804-9";

	/**
	 * <div class="en">Code for Lactate dehydrogenase [Enzymatic activity/volume]
	 * in Serum or Plasma by Pyruvate to lactate reaction</div>
	 */
	public static final String LACTATE_DEHYDROGENASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_BY_PYRUVATE_TO_LACTATE_REACTION_CODE = "14805-6";

	/**
	 * <div class="en">Code for Le sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String LE_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1112-2";

	/**
	 * <div class="en">Code for Le sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String LE_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1118-9";

	/**
	 * <div class="en">Code for Leucine crystals [Presence] in Urine sediment by
	 * Light microscopy</div>
	 */
	public static final String LEUCINE_CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "5798-4";

	/**
	 * <div class="en">Code for Leukocytes [#/area] in Urine sediment by Automated
	 * count</div>
	 */
	public static final String LEUKOCYTES_AREA_IN_URINE_SEDIMENT_BY_AUTOMATED_COUNT_CODE = "46702-7";

	/**
	 * <div class="en">Code for Leukocytes [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	public static final String LEUKOCYTES_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "20455-2";

	/**
	 * <div class="en">Code for Leukocytes [#/?volume] in Blood by Automated
	 * count</div>
	 */
	public static final String LEUKOCYTES_VOLUME_IN_BLOOD_BY_AUTOMATED_COUNT_CODE = "6690-2";

	/**
	 * <div class="en">Code for Leukocytes [#/volume] in Blood by Manual
	 * count</div>
	 */
	public static final String LEUKOCYTES_VOLUME_IN_BLOOD_BY_MANUAL_COUNT_CODE = "804-5";

	/**
	 * <div class="en">Code for Leukocytes [#/?volume] in unspecified time Urine
	 * sediment by Microscopy high power field</div>
	 */
	public static final String LEUKOCYTES_VOLUME_IN_UNSPECIFIED_TIME_URINE_SEDIMENT_BY_MICROSCOPY_HIGH_POWER_FIELD_CODE = "63555-7";

	/**
	 * <div class="en">Code for Leukocytes [#/volume] in Urine by Automated test
	 * strip</div>
	 */
	public static final String LEUKOCYTES_VOLUME_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "58805-3";

	/**
	 * <div class="en">Code for Leukocytes [#/volume] in Urine by Test strip</div>
	 */
	public static final String LEUKOCYTES_VOLUME_IN_URINE_BY_TEST_STRIP_CODE = "20408-1";

	/**
	 * <div class="en">Code for Lipase [Enzymatic activity/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String LIPASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "3040-3";

	/**
	 * <div class="en">Code for Lithium [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String LITHIUM_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3719-2";

	/**
	 * <div class="en">Code for Lithium [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String LITHIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14334-7";

	/**
	 * <div class="en">Code for little e Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String LITTLE_E_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1162-7";

	/**
	 * <div class="en">Code for little f Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String LITTLE_F_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1168-4";

	/**
	 * <div class="en">Code for little k Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String LITTLE_K_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1192-4";

	/**
	 * <div class="en">Code for little s Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String LITTLE_S_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1210-4";

	/**
	 * <div class="en">Code for Lu sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String LU_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1135-3";

	/**
	 * <div class="en">Code for Lu sup(b) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String LU_SUPB_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1144-5";

	/**
	 * <div class="en">Code for Lutropin [Units/volume] in Serum or Plasma</div>
	 */
	public static final String LUTROPIN_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "10501-5";

	/**
	 * <div class="en">Code for Lymphocytes/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	public static final String LYMPHOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "737-7";

	/**
	 * <div class="en">Code for M Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String M_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1228-6";

	/**
	 * <div class="en">Code for Magnesium [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String MAGNESIUM_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "19123-9";

	/**
	 * <div class="en">Code for Magnesium [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String MAGNESIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2601-3";

	/**
	 * <div class="en">Code for Major crossmatch [interpretation]</div>
	 */
	public static final String MAJOR_CROSSMATCH_INTERPRETATION_CODE = "1250-0";

	/**
	 * <div class="en">Code for Metamyelocytes/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	public static final String METAMYELOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "740-1";

	/**
	 * <div class="en">Code for Methadone [Mass/?volume] in Urine</div>
	 */
	public static final String METHADONE_MASSVOLUME_IN_URINE_CODE = "3774-7";

	/**
	 * <div class="en">Code for Methadone [Moles/?volume] in Urine</div>
	 */
	public static final String METHADONE_MOLESVOLUME_IN_URINE_CODE = "52958-6";

	/**
	 * <div class="en">Code for Methadone [Presence] in Urine by Screen
	 * method</div>
	 */
	public static final String METHADONE_PRESENCE_IN_URINE_BY_SCREEN_METHOD_CODE = "19550-3";

	/**
	 * <div class="en">Code for Methadone [Presence] in Urine</div>
	 */
	public static final String METHADONE_PRESENCE_IN_URINE_CODE = "3773-9";

	/**
	 * <div class="en">Code for Methicillin resistant Staphylococcus aureus (MRSA)
	 * DNA [Presence] by Probe and target amplification method</div>
	 */
	public static final String METHICILLIN_RESISTANT_STAPHYLOCOCCUS_AUREUS_MRSA_DNA_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "35492-8";

	/**
	 * <div class="en">Code for Methicillin resistant Staphylococcus aureus
	 * [Presence] in Unspecified specimen by Organism specific culture</div>
	 */
	public static final String METHICILLIN_RESISTANT_STAPHYLOCOCCUS_AUREUS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE = "13317-3";

	/**
	 * <div class="en">Code for Mianserin [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String MIANSERIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2635-1";

	/**
	 * <div class="en">Code for Mianserin [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String MIANSERIN_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "25721-2";

	/**
	 * <div class="en">Code for Mianserin+Normianserin [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String MIANSERIN_NORMIANSERIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "34341-8";

	/**
	 * <div class="en">Code for Micafungin [Susceptibility]</div>
	 */
	public static final String MICAFUNGIN_SUSCEPTIBILITY_CODE = "65340-2";

	/**
	 * <div class="en">Code for Mirtazapine [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String MIRTAZAPINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "17283-3";

	/**
	 * <div class="en">Code for Mirtazapine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String MIRTAZAPINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "55554-0";

	/**
	 * <div class="en">Code for Mirtazapine+Normirtazapine [Mass/volume] in Serum
	 * or Plasma</div>
	 */
	public static final String MIRTAZAPINE_NORMIRTAZAPINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "62848-7";

	/**
	 * <div class="en">Code for Miscellaneous allergen IgE Ab RAST class
	 * [Presence] in Serum</div>
	 */
	public static final String MISCELLANEOUS_ALLERGEN_IGE_AB_RAST_CLASS_PRESENCE_IN_SERUM_CODE = "33536-4";

	/**
	 * <div class="en">Code for Mixed cellular casts [Presence] in Urine sediment
	 * by Light microscopy</div>
	 */
	public static final String MIXED_CELLULAR_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "34173-5";

	/**
	 * <div class="en">Code for Moclobemide [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String MOCLOBEMIDE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "74941-6";

	/**
	 * <div class="en">Code for Moclobemide [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String MOCLOBEMIDE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "34413-5";

	/**
	 * <div class="en">Code for Monocytes/100 leukocytes in Blood by Manual
	 * count</div>
	 */
	public static final String MONOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "744-3";

	/**
	 * <div class="en">Code for Mycobacterium sp identified in Unspecified
	 * specimen by Organism specific culture</div>
	 */
	public static final String MYCOBACTERIUM_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE = "543-9";

	/**
	 * <div class="en">Code for Mycobacterium tuberculosis complex DNA [Presence]
	 * in Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "38379-4";

	/**
	 * <div class="en">Code for Mycobacterium tuberculosis complex rRNA [Presence]
	 * in Unspecified specimen by DNA probe</div>
	 */
	public static final String MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE = "17296-5";

	/**
	 * <div class="en">Code for Myelocytes/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	public static final String MYELOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "749-2";

	/**
	 * <div class="en">Code for Myoglobin [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String MYOGLOBIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2639-3";

	/**
	 * <div class="en">Code for Myoglobin [Mass/?volume] in Urine</div>
	 */
	public static final String MYOGLOBIN_MASSVOLUME_IN_URINE_CODE = "2641-9";

	/**
	 * <div class="en">Code for Myoglobin [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String MYOGLOBIN_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "56887-3";

	/**
	 * <div class="en">Code for N Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String N_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1258-3";

	/**
	 * <div class="en">Code for Natriuretic peptide B [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NATRIURETIC_PEPTIDE_B_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "30934-4";

	/**
	 * <div class="en">Code for Natriuretic peptide B [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NATRIURETIC_PEPTIDE_B_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "47092-2";

	/**
	 * <div class="en">Code for Natriuretic peptide.B prohormone N-Terminal
	 * [Mass/?volume] in Serum or Plasma</div>
	 */
	public static final String NATRIURETIC_PEPTIDE_B_PROHORMONE_N_TERMINAL_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "33762-6";

	/**
	 * <div class="en">Code for Natriuretic peptide.B prohormone N-Terminal
	 * [Moles/?volume] in Serum or Plasma</div>
	 */
	public static final String NATRIURETIC_PEPTIDE_B_PROHORMONE_N_TERMINAL_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "33763-4";

	/**
	 * <div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "24111-7";

	/**
	 * <div class="en">Code for Neutrophil cytoplasmic Ab [interpretation] in
	 * Serum</div>
	 */
	public static final String NEUTROPHIL_CYTOPLASMIC_AB_INTERPRETATION_IN_SERUM_CODE = "17352-6";

	/**
	 * <div class="en">Code for Neutrophil cytoplasmic Ab pattern [interpretation]
	 * in Serum by Immunofluorescence</div>
	 */
	public static final String NEUTROPHIL_CYTOPLASMIC_AB_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE = "21419-7";

	/**
	 * <div class="en">Code for Neutrophil cytoplasmic Ab pattern [interpretation]
	 * in Serum by Immunofluorescence Narrative</div>
	 */
	public static final String NEUTROPHIL_CYTOPLASMIC_AB_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOFLUORESCENCE_NARRATIVE_CODE = "49308-0";

	/**
	 * <div class="en">Code for Neutrophil cytoplasmic Ab [Presence] in Serum by
	 * Immunofluorescence</div>
	 */
	public static final String NEUTROPHIL_CYTOPLASMIC_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE = "35279-9";

	/**
	 * <div class="en">Code for Neutrophil cytoplasmic Ab [Presence] in
	 * Serum</div>
	 */
	public static final String NEUTROPHIL_CYTOPLASMIC_AB_PRESENCE_IN_SERUM_CODE = "17351-8";

	/**
	 * <div class="en">Code for Neutrophil cytoplasmic IgG Ab [Presence] in
	 * Serum</div>
	 */
	public static final String NEUTROPHIL_CYTOPLASMIC_IGG_AB_PRESENCE_IN_SERUM_CODE = "17355-9";

	/**
	 * <div class="en">Code for Neutrophils.band form/100 leukocytes in Blood by
	 * Manual count</div>
	 */
	public static final String NEUTROPHILS_BAND_FORM100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "764-1";

	/**
	 * <div class="en">Code for Neutrophils.segmented/?100 leukocytes in Blood by
	 * Manual count</div>
	 */
	public static final String NEUTROPHILS_SEGMENTED100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "769-0";

	/**
	 * <div class="en">Code for Nitrite [Presence] in Urine by Automated test
	 * strip</div>
	 */
	public static final String NITRITE_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "50558-6";

	/**
	 * <div class="en">Code for Nitrite [Presence] in Urine by Test strip</div>
	 */
	public static final String NITRITE_PRESENCE_IN_URINE_BY_TEST_STRIP_CODE = "5802-4";

	/**
	 * <div class="en">Code for Norfluoxetine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORFLUOXETINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3868-7";

	/**
	 * <div class="en">Code for Norfluoxetine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORFLUOXETINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14855-1";

	/**
	 * <div class="en">Code for Normianserin [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORMIANSERIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "34414-3";

	/**
	 * <div class="en">Code for Normirtazapine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORMIRTAZAPINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "34415-0";

	/**
	 * <div class="en">Code for Norsertraline [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORSERTRALINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "6897-3";

	/**
	 * <div class="en">Code for Nortrimipramine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORTRIMIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "16746-0";

	/**
	 * <div class="en">Code for Nortrimipramine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORTRIMIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "25394-8";

	/**
	 * <div class="en">Code for Nortriptyline [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORTRIPTYLINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3872-9";

	/**
	 * <div class="en">Code for Nortriptyline [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORTRIPTYLINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14856-9";

	/**
	 * <div class="en">Code for Norvenlafaxine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORVENLAFAXINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "9628-9";

	/**
	 * <div class="en">Code for Norvenlafaxine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String NORVENLAFAXINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "48362-8";

	/**
	 * <div class="en">Code for Nuclear Ab [Presence] in Serum by Hep2
	 * substrate</div>
	 */
	public static final String NUCLEAR_AB_PRESENCE_IN_SERUM_BY_HEP2_SUBSTRATE_CODE = "59069-5";

	/**
	 * <div class="en">Code for Nuclear Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String NUCLEAR_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "47383-5";

	/**
	 * <div class="en">Code for Nuclear Ab [Presence] in Serum by
	 * Immunofluorescence</div>
	 */
	public static final String NUCLEAR_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE = "42254-3";

	/**
	 * <div class="en">Code for Nuclear Ab [Presence] in Serum</div>
	 */
	public static final String NUCLEAR_AB_PRESENCE_IN_SERUM_CODE = "8061-4";

	/**
	 * <div class="en">Code for Opiates [Mass/?volume] in Urine</div>
	 */
	public static final String OPIATES_MASSVOLUME_IN_URINE_CODE = "8220-6";

	/**
	 * <div class="en">Code for Opiates [Moles/?volume] in Urine</div>
	 */
	public static final String OPIATES_MOLESVOLUME_IN_URINE_CODE = "52952-9";

	/**
	 * <div class="en">Code for Opiates [Presence] in Urine by Screen method</div>
	 */
	public static final String OPIATES_PRESENCE_IN_URINE_BY_SCREEN_METHOD_CODE = "19295-5";

	/**
	 * <div class="en">Code for Opiates [Presence] in Urine</div>
	 */
	public static final String OPIATES_PRESENCE_IN_URINE_CODE = "3879-4";

	/**
	 * <div class="en">Code for Osmolality of Serum or Plasma</div>
	 */
	public static final String OSMOLALITY_OF_SERUM_OR_PLASMA_CODE = "2692-2";

	/**
	 * <div class="en">Code for Osmolality of Urine</div>
	 */
	public static final String OSMOLALITY_OF_URINE_CODE = "2695-5";

	/**
	 * <div class="en">Code for Ova and parasites identified in Unspecified
	 * specimen by Light microscopy</div>
	 */
	public static final String OVA_AND_PARASITES_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_LIGHT_MICROSCOPY_CODE = "673-4";

	/**
	 * <div class="en">Code for Oxygen [Partial pressure] in Blood</div>
	 */
	public static final String OXYGEN_PARTIAL_PRESSURE_IN_BLOOD_CODE = "11556-8";

	/**
	 * <div class="en">Code for Oxygen [Partial pressure] in Venous blood</div>
	 */
	public static final String OXYGEN_PARTIAL_PRESSURE_IN_VENOUS_BLOOD_CODE = "2705-2";

	/**
	 * <div class="en">Code for P Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String P_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1279-9";

	/**
	 * <div class="en">Code for P1 Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String P1_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1288-0";

	/**
	 * <div class="en">Code for Parathyrin.intact [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String PARATHYRIN_INTACT_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2731-8";

	/**
	 * <div class="en">Code for Parathyrin.intact [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String PARATHYRIN_INTACT_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14866-8";

	/**
	 * <div class="en">Code for Paroxetine [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String PAROXETINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "9699-0";

	/**
	 * <div class="en">Code for Paroxetine [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String PAROXETINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14867-6";

	/**
	 * <div class="en">Code for Peanut IgE Ab RAST class [Presence] in Serum</div>
	 */
	public static final String PEANUT_IGE_AB_RAST_CLASS_PRESENCE_IN_SERUM_CODE = "15917-8";

	/**
	 * <div class="en">Code for Peanut IgE Ab [Units/volume] in Serum</div>
	 */
	public static final String PEANUT_IGE_AB_UNITSVOLUME_IN_SERUM_CODE = "6206-7";

	/**
	 * <div class="en">Code for pH of Blood</div>
	 */
	public static final String PH_OF_BLOOD_CODE = "11558-4";

	/**
	 * <div class="en">Code for pH of Urine by Automated test strip</div>
	 */
	public static final String PH_OF_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "50560-2";

	/**
	 * <div class="en">Code for pH of Urine by Test strip</div>
	 */
	public static final String PH_OF_URINE_BY_TEST_STRIP_CODE = "5803-2";

	/**
	 * <div class="en">Code for pH of Venous blood</div>
	 */
	public static final String PH_OF_VENOUS_BLOOD_CODE = "2746-6";

	/**
	 * <div class="en">Code for Phosphate crystals amorphous [#/?volume] in Urine
	 * sediment</div>
	 */
	public static final String PHOSPHATE_CRYSTALS_AMORPHOUS_VOLUME_IN_URINE_SEDIMENT_CODE = "13656-4";

	/**
	 * <div class="en">Code for Phosphate [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String PHOSPHATE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2777-1";

	/**
	 * <div class="en">Code for Phosphate [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String PHOSPHATE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14879-1";

	/**
	 * <div class="en">Code for Plasmodium sp identified in Blood by Light
	 * microscopy</div>
	 */
	public static final String PLASMODIUM_SP_IDENTIFIED_IN_BLOOD_BY_LIGHT_MICROSCOPY_CODE = "32206-5";

	/**
	 * <div class="en">Code for Plasmodium sp [Presence] in Blood by Light
	 * microscopy</div>
	 */
	public static final String PLASMODIUM_SP_PRESENCE_IN_BLOOD_BY_LIGHT_MICROSCOPY_CODE = "51587-4";

	/**
	 * <div class="en">Code for Platelets [#/?volume] in Blood by Automated
	 * count</div>
	 */
	public static final String PLATELETS_VOLUME_IN_BLOOD_BY_AUTOMATED_COUNT_CODE = "777-3";

	/**
	 * <div class="en">Code for Platelets [#/volume] in Blood by Manual
	 * count</div>
	 */
	public static final String PLATELETS_VOLUME_IN_BLOOD_BY_MANUAL_COUNT_CODE = "778-1";

	/**
	 * <div class="en">Code for Platelets [#/?volume] in Blood</div>
	 */
	public static final String PLATELETS_VOLUME_IN_BLOOD_CODE = "26515-7";

	/**
	 * <div class="en">Code for Posaconazole [Susceptibility]</div>
	 */
	public static final String POSACONAZOLE_SUSCEPTIBILITY_CODE = "54188-8";

	/**
	 * <div class="en">Code for Potassium [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String POTASSIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2823-3";

	/**
	 * <div class="en">Code for Procalcitonin [Mass/volume] in Serum or Plasma by
	 * Immunoassay</div>
	 */
	public static final String PROCALCITONIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE = "75241-0";

	/**
	 * <div class="en">Code for Procalcitonin [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String PROCALCITONIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "33959-8";

	/**
	 * <div class="en">Code for Prolactin [Mass/volume] in Serum or Plasma by
	 * Immunoassay</div>
	 */
	public static final String PROLACTIN_MASSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE = "20568-2";

	/**
	 * <div class="en">Code for Prolactin [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String PROLACTIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2842-3";

	/**
	 * <div class="en">Code for Prolactin [Units/volume] in Serum or Plasma</div>
	 */
	public static final String PROLACTIN_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "15081-3";

	/**
	 * <div class="en">Code for Promyelocytes/?100 leukocytes in Blood by Manual
	 * count</div>
	 */
	public static final String PROMYELOCYTES100_LEUKOCYTES_IN_BLOOD_BY_MANUAL_COUNT_CODE = "783-1";

	/**
	 * <div class="en">Code for Prostate Specific Ag Free [Mass/volume] in Serum
	 * or Plasma</div>
	 */
	public static final String PROSTATE_SPECIFIC_AG_FREE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "10886-0";

	/**
	 * <div class="en">Code for Prostate specific Ag [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String PROSTATE_SPECIFIC_AG_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2857-1";

	/**
	 * <div class="en">Code for Protein [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2885-2";

	/**
	 * <div class="en">Code for Protein [Presence] in Urine by Automated test
	 * strip</div>
	 */
	public static final String PROTEIN_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "57735-3";

	/**
	 * <div class="en">Code for Protein [Presence] in Urine by Test strip</div>
	 */
	public static final String PROTEIN_PRESENCE_IN_URINE_BY_TEST_STRIP_CODE = "20454-5";

	/**
	 * <div class="en">Code for Prothrombin time (PT) actual/?Normal</div>
	 */
	public static final String PROTHROMBIN_TIME_PT_ACTUALNORMAL_CODE = "5894-1";

	/**
	 * <div class="en">Code for Pyrazinamide 100 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String PYRAZINAMIDE_100_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25229-6";

	/**
	 * <div class="en">Code for Pyrazinamide 200 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String PYRAZINAMIDE_200_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "55711-6";

	/**
	 * <div class="en">Code for Pyrazinamide 25 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String PYRAZINAMIDE_25_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25186-8";

	/**
	 * <div class="en">Code for Pyrazinamide 300 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String PYRAZINAMIDE_300_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "56026-8";

	/**
	 * <div class="en">Code for Pyrazinamide [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String PYRAZINAMIDE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "20461-0";

	/**
	 * <div class="en">Code for RBC casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	public static final String RBC_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "33804-6";

	/**
	 * <div class="en">Code for Reagin Ab [Titer] in Serum by RPR</div>
	 */
	public static final String REAGIN_AB_TITER_IN_SERUM_BY_RPR_CODE = "31147-2";

	/**
	 * <div class="en">Code for Reagin Ab [Titer] in Serum by VDRL</div>
	 */
	public static final String REAGIN_AB_TITER_IN_SERUM_BY_VDRL_CODE = "50690-7";

	/**
	 * <div class="en">Code for Reagin Ab [Titer] in Serum</div>
	 */
	public static final String REAGIN_AB_TITER_IN_SERUM_CODE = "11084-1";

	/**
	 * <div class="en">Code for Reagin Ab [Units/?volume] in Serum by RPR</div>
	 */
	public static final String REAGIN_AB_UNITSVOLUME_IN_SERUM_BY_RPR_CODE = "20508-8";

	/**
	 * <div class="en">Code for Reagin Ab [Units/volume] in Serum by VDRL</div>
	 */
	public static final String REAGIN_AB_UNITSVOLUME_IN_SERUM_BY_VDRL_CODE = "5291-0";

	/**
	 * <div class="en">Code for Reagin Ab [Units/?volume] in Serum</div>
	 */
	public static final String REAGIN_AB_UNITSVOLUME_IN_SERUM_CODE = "22462-6";

	/**
	 * <div class="en">Code for Reboxetine [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String REBOXETINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "48352-9";

	/**
	 * <div class="en">Code for Rifampin 1 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String RIFAMPIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25202-3";

	/**
	 * <div class="en">Code for Rifampin 14 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String RIFAMPIN_14_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25184-3";

	/**
	 * <div class="en">Code for Rifampin 2 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String RIFAMPIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25203-1";

	/**
	 * <div class="en">Code for Rifampin 40 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String RIFAMPIN_40_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "55712-4";

	/**
	 * <div class="en">Code for Rifampin 5 ug/mL [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String RIFAMPIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25204-9";

	/**
	 * <div class="en">Code for Rifampin [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String RIFAMPIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "20385-1";

	/**
	 * <div class="en">Code for Rubella virus IgG Ab [Units/volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5334-8";

	/**
	 * <div class="en">Code for Rubella virus IgG Ab [Units/volume] in Serum</div>
	 */
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "8014-3";

	/**
	 * <div class="en">Code for Rubella virus IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "24116-6";

	/**
	 * <div class="en">Code for Rubella virus IgM Ab [Presence] in Serum</div>
	 */
	public static final String RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE = "31616-6";

	/**
	 * <div class="en">Code for Rubella virus IgM Ab [Units/?volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5335-5";

	/**
	 * <div class="en">Code for Rubella virus IgM Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE = "8015-0";

	/**
	 * <div class="en">Code for S Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String S_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1317-7";

	/**
	 * <div class="en">Code for Sertraline [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String SERTRALINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "6906-2";

	/**
	 * <div class="en">Code for Sertraline [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String SERTRALINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14911-2";

	/**
	 * <div class="en">Code for Silver Birch IgE Ab RAST class [Presence] in
	 * Serum</div>
	 */
	public static final String SILVER_BIRCH_IGE_AB_RAST_CLASS_PRESENCE_IN_SERUM_CODE = "15579-6";

	/**
	 * <div class="en">Code for Silver Birch IgE Ab [Units/volume] in Serum</div>
	 */
	public static final String SILVER_BIRCH_IGE_AB_UNITSVOLUME_IN_SERUM_CODE = "15283-5";

	/**
	 * <div class="en">Code for Sodium [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String SODIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2951-2";

	/**
	 * <div class="en">Code for Specific gravity of Urine by Automated test
	 * strip</div>
	 */
	public static final String SPECIFIC_GRAVITY_OF_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "53326-5";

	/**
	 * <div class="en">Code for Specific gravity of Urine by Test strip</div>
	 */
	public static final String SPECIFIC_GRAVITY_OF_URINE_BY_TEST_STRIP_CODE = "5811-5";

	/**
	 * <div class="en">Code for Streptococcus pyogenes Ag [Presence] in
	 * Throat</div>
	 */
	public static final String STREPTOCOCCUS_PYOGENES_AG_PRESENCE_IN_THROAT_CODE = "18481-2";

	/**
	 * <div class="en">Code for Streptomycin 1 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String STREPTOMYCIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "48177-0";

	/**
	 * <div class="en">Code for Streptomycin 10 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String STREPTOMYCIN_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25206-4";

	/**
	 * <div class="en">Code for Streptomycin 2 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String STREPTOMYCIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25205-6";

	/**
	 * <div class="en">Code for Streptomycin 4 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String STREPTOMYCIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "46719-1";

	/**
	 * <div class="en">Code for Streptomycin 6 ug/mL [Susceptibility] by Method
	 * for Slow-growing mycobacteria</div>
	 */
	public static final String STREPTOMYCIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "25185-0";

	/**
	 * <div class="en">Code for Streptomycin [Susceptibility] by Method for
	 * Slow-growing mycobacteria</div>
	 */
	public static final String STREPTOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE = "20462-8";

	/**
	 * <div class="en">Code for Testosterone [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String TESTOSTERONE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2986-8";

	/**
	 * <div class="en">Code for Testosterone [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String TESTOSTERONE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14913-8";

	/**
	 * <div class="en">Code for Thyroperoxidase Ab [Titer] in Serum or
	 * Plasma</div>
	 */
	public static final String THYROPEROXIDASE_AB_TITER_IN_SERUM_OR_PLASMA_CODE = "32786-6";

	/**
	 * <div class="en">Code for Thyroperoxidase Ab [Units/volume] in Serum or
	 * Plasma by Immunoassay</div>
	 */
	public static final String THYROPEROXIDASE_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE = "56477-3";

	/**
	 * <div class="en">Code for Thyroperoxidase Ab [Units/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String THYROPEROXIDASE_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "8099-4";

	/**
	 * <div class="en">Code for Thyroperoxidase IgG Ab [Units/?volume] in Serum or
	 * Plasma</div>
	 */
	public static final String THYROPEROXIDASE_IGG_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "18332-7";

	/**
	 * <div class="en">Code for Thyrotropin [Units/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String THYROTROPIN_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3016-3";

	/**
	 * <div class="en">Code for Thyroxine (T4) free [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String THYROXINE_T4_FREE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3024-7";

	/**
	 * <div class="en">Code for Thyroxine (T4) free [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String THYROXINE_T4_FREE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14920-3";

	/**
	 * <div class="en">Code for Tissue transglutaminase IgA Ab [Units/?volume] in
	 * Serum by Immunoassay</div>
	 */
	public static final String TISSUE_TRANSGLUTAMINASE_IGA_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "46128-5";

	/**
	 * <div class="en">Code for Tissue transglutaminase IgA Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String TISSUE_TRANSGLUTAMINASE_IGA_AB_UNITSVOLUME_IN_SERUM_CODE = "31017-7";

	/**
	 * <div class="en">Code for Toxoplasma gondii Ab [Units/volume] in Serum</div>
	 */
	public static final String TOXOPLASMA_GONDII_AB_UNITSVOLUME_IN_SERUM_CODE = "11598-0";

	/**
	 * <div class="en">Code for Toxoplasma gondii DNA [Presence] in Unspecified
	 * specimen by Probe and target amplification method</div>
	 */
	public static final String TOXOPLASMA_GONDII_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "29904-0";

	/**
	 * <div class="en">Code for Toxoplasma gondii IgG Ab [Units/volume] in Serum
	 * by Immunoassay</div>
	 */
	public static final String TOXOPLASMA_GONDII_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5388-4";

	/**
	 * <div class="en">Code for Toxoplasma gondii IgG Ab [Units/volume] in
	 * Serum</div>
	 */
	public static final String TOXOPLASMA_GONDII_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "8039-0";

	/**
	 * <div class="en">Code for Toxoplasma gondii IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String TOXOPLASMA_GONDII_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "40678-5";

	/**
	 * <div class="en">Code for Toxoplasma gondii IgM Ab [Presence] in Serum</div>
	 */
	public static final String TOXOPLASMA_GONDII_IGM_AB_PRESENCE_IN_SERUM_CODE = "25542-2";

	/**
	 * <div class="en">Code for Toxoplasma gondii IgM Ab [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	public static final String TOXOPLASMA_GONDII_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5390-0";

	/**
	 * <div class="en">Code for Toxoplasma gondii IgM Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String TOXOPLASMA_GONDII_IGM_AB_UNITSVOLUME_IN_SERUM_CODE = "8040-8";

	/**
	 * <div class="en">Code for Trazodone [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String TRAZODONE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "4064-2";

	/**
	 * <div class="en">Code for Trazodone [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String TRAZODONE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14925-2";

	/**
	 * <div class="en">Code for Treponema pallidum Ab [Titer] in Serum by
	 * Hemagglutination</div>
	 */
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_CODE = "26009-1";

	/**
	 * <div class="en">Code for Treponema pallidum Ab [Titer] in Serum by
	 * Immunofluorescence</div>
	 */
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE = "34382-2";

	/**
	 * <div class="en">Code for Treponema pallidum Ab [Titer] in Serum by Latex
	 * agglutination</div>
	 */
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE = "5394-2";

	/**
	 * <div class="en">Code for Treponema pallidum Ab [Titer] in Serum or Plasma
	 * by Agglutination</div>
	 */
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_OR_PLASMA_BY_AGGLUTINATION_CODE = "71793-4";

	/**
	 * <div class="en">Code for Treponema pallidum Ab [Units/volume] in Serum by
	 * Immunoassay</div>
	 */
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "63464-2";

	/**
	 * <div class="en">Code for Treponema pallidum Ab [Units/?volume] in Serum by
	 * Latex agglutination</div>
	 */
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE = "17725-3";

	/**
	 * <div class="en">Code for Treponema pallidum Ab [Units/volume] in
	 * Serum</div>
	 */
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_CODE = "11597-2";

	/**
	 * <div class="en">Code for Treponema pallidum IgG Ab [Units/volume] in Serum
	 * by Immunoassay</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "51838-1";

	/**
	 * <div class="en">Code for Treponema pallidum IgG Ab [Units/volume] in Serum
	 * by Immunofluorescence</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE = "17727-9";

	/**
	 * <div class="en">Code for Treponema pallidum IgG Ab [Units/volume] in
	 * Serum</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "22592-0";

	/**
	 * <div class="en">Code for Treponema pallidum IgM Ab [Presence] in Serum by
	 * Immunoassay</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "47237-3";

	/**
	 * <div class="en">Code for Treponema pallidum IgM Ab [Presence] in Serum by
	 * Immunoblot (IB)</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE = "40680-1";

	/**
	 * <div class="en">Code for Treponema pallidum IgM Ab [Presence] in Serum by
	 * Immunofluorescence</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE = "17729-5";

	/**
	 * <div class="en">Code for Treponema pallidum IgM Ab [Presence] in
	 * Serum</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_CODE = "6562-3";

	/**
	 * <div class="en">Code for Treponema pallidum IgM Ab [Units/?volume] in Serum
	 * by Immunoassay</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "51839-9";

	/**
	 * <div class="en">Code for Treponema pallidum IgM Ab [Units/?volume] in Serum
	 * by Immunofluorescence</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE = "17728-7";

	/**
	 * <div class="en">Code for Treponema pallidum IgM Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_CODE = "22594-6";

	/**
	 * <div class="en">Code for Tricyclic antidepressants [Presence] in Serum or
	 * Plasma</div>
	 */
	public static final String TRICYCLIC_ANTIDEPRESSANTS_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "4073-3";

	/**
	 * <div class="en">Code for Tricyclic antidepressants [Presence] in Urine by
	 * Immunoassay</div>
	 */
	public static final String TRICYCLIC_ANTIDEPRESSANTS_PRESENCE_IN_URINE_BY_IMMUNOASSAY_CODE = "6799-1";

	/**
	 * <div class="en">Code for Tricyclic antidepressants [Presence] in Urine by
	 * Screen method</div>
	 */
	public static final String TRICYCLIC_ANTIDEPRESSANTS_PRESENCE_IN_URINE_BY_SCREEN_METHOD_CODE = "19312-8";

	/**
	 * <div class="en">Code for Tricyclic antidepressants [Presence] in
	 * Urine</div>
	 */
	public static final String TRICYCLIC_ANTIDEPRESSANTS_PRESENCE_IN_URINE_CODE = "11004-9";

	/**
	 * <div class="en">Code for Tricyclic antidepressants screen method
	 * [Identifier] in Urine</div>
	 */
	public static final String TRICYCLIC_ANTIDEPRESSANTS_SCREEN_METHOD_IDENTIFIER_IN_URINE_CODE = "19319-3";

	/**
	 * <div class="en">Code for Triglyceride [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String TRIGLYCERIDE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2571-8";

	/**
	 * <div class="en">Code for Triglyceride [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String TRIGLYCERIDE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14927-8";

	/**
	 * <div class="en">Code for Trimipramine [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String TRIMIPRAMINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "4083-2";

	/**
	 * <div class="en">Code for Trimipramine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String TRIMIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14931-0";

	/**
	 * <div class="en">Code for Trimipramine+Nortrimipramine [Moles/volume] in
	 * Serum or Plasma</div>
	 */
	public static final String TRIMIPRAMINE_NORTRIMIPRAMINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "25812-9";

	/**
	 * <div class="en">Code for Troponin I.cardiac [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String TROPONIN_I_CARDIAC_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "10839-9";

	/**
	 * <div class="en">Code for Troponin T.cardiac [Mass/?volume] in Serum or
	 * Plasma</div>
	 */
	public static final String TROPONIN_T_CARDIAC_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "6598-7";

	/**
	 * <div class="en">Code for Troponin T.cardiac [Presence] in Serum or
	 * Plasma</div>
	 */
	public static final String TROPONIN_T_CARDIAC_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "33204-9";

	/**
	 * <div class="en">Code for Unidentified crystals [Presence] in Urine sediment
	 * by Light microscopy</div>
	 */
	public static final String UNIDENTIFIED_CRYSTALS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "5783-6";

	/**
	 * <div class="en">Code for Urate crystals amorphous [#/?volume] in Urine
	 * sediment</div>
	 */
	public static final String URATE_CRYSTALS_AMORPHOUS_VOLUME_IN_URINE_SEDIMENT_CODE = "13657-2";

	/**
	 * <div class="en">Code for Urate [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String URATE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3084-1";

	/**
	 * <div class="en">Code for Urate [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String URATE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14933-6";

	/**
	 * <div class="en">Code for Urea [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String UREA_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "3091-6";

	/**
	 * <div class="en">Code for Urea [Moles/volume] in Serum or Plasma</div>
	 */
	public static final String UREA_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "22664-7";

	/**
	 * <div class="en">Code for Urobilinogen [Presence] in Urine by Automated test
	 * strip</div>
	 */
	public static final String UROBILINOGEN_PRESENCE_IN_URINE_BY_AUTOMATED_TEST_STRIP_CODE = "62487-4";

	/**
	 * <div class="en">Code for Varicella zoster virus DNA [Presence] in
	 * Unspecified specimen by Probe and target amplification method</div>
	 */
	public static final String VARICELLA_ZOSTER_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "11483-5";

	/**
	 * <div class="en">Code for Varicella zoster virus DNA [#/?volume] (viral
	 * load) in Unspecified specimen by Probe and target amplification
	 * method</div>
	 */
	public static final String VARICELLA_ZOSTER_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "49451-8";

	/**
	 * <div class="en">Code for Varicella zoster virus IgG Ab [Presence] in Serum
	 * by Immunoassay</div>
	 */
	public static final String VARICELLA_ZOSTER_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE = "15410-4";

	/**
	 * <div class="en">Code for Varicella zoster virus IgG Ab [Presence] in
	 * Serum</div>
	 */
	public static final String VARICELLA_ZOSTER_VIRUS_IGG_AB_PRESENCE_IN_SERUM_CODE = "19162-7";

	/**
	 * <div class="en">Code for Varicella zoster virus IgG Ab [Units/?volume] in
	 * Serum by Immunoassay</div>
	 */
	public static final String VARICELLA_ZOSTER_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE = "5403-1";

	/**
	 * <div class="en">Code for Varicella zoster virus IgG Ab [Units/?volume] in
	 * Serum</div>
	 */
	public static final String VARICELLA_ZOSTER_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE = "8047-3";

	/**
	 * <div class="en">Code for Venlafaxine [Mass/volume] in Serum or Plasma</div>
	 */
	public static final String VENLAFAXINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "9630-5";

	/**
	 * <div class="en">Code for Venlafaxine [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String VENLAFAXINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "34386-3";

	/**
	 * <div class="en">Code for Venlafaxine+Norvenlafaxine [Mass/volume] in Serum
	 * or Plasma</div>
	 */
	public static final String VENLAFAXINE_NORVENLAFAXINE_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "62849-5";

	/**
	 * <div class="en">Code for Venlafaxine+Norvenlafaxine [Moles/volume] in Serum
	 * or Plasma</div>
	 */
	public static final String VENLAFAXINE_NORVENLAFAXINE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "48350-3";

	/**
	 * <div class="en">Code for Voriconazole [Susceptibility]</div>
	 */
	public static final String VORICONAZOLE_SUSCEPTIBILITY_CODE = "32379-0";

	/**
	 * <div class="en">Code for Waxy casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	public static final String WAXY_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "33862-4";

	/**
	 * <div class="en">Code for Waxy casts [#/?volume] in Urine sediment</div>
	 */
	public static final String WAXY_CASTS_VOLUME_IN_URINE_SEDIMENT_CODE = "41187-6";

	/**
	 * <div class="en">Code for WBC casts [Presence] in Urine sediment by Light
	 * microscopy</div>
	 */
	public static final String WBC_CASTS_PRESENCE_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "33825-1";

	/**
	 * <div class="en">Code for Xg sup(a) Ab [Presence] in Serum or Plasma</div>
	 */
	public static final String XG_SUPA_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "1338-3";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static LabObsList getEnum(String code) {
		for (LabObsList x : values()) {
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
	 *          <br>
	 *          <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(LabObsList.class, enumName);
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
	 *          <br>
	 *          <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (LabObsList x : values()) {
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
	protected String code;

	/**
	 * <div class="en">Human readable name</div> <div class="de">Menschenlesbarer
	 * Name</div>
	 */
	protected String displayName;
	/**
	 * <div class="en">Section code for this Element</div> <div class="de">Section
	 * Code für dieses Element</div>
	 */
	protected String sectionCode;

	/**
	 * <div class="en">Start date for the period in which this element can be
	 * used</div> <div class="de">Startdatum der Periode, innerhalb derer dieses
	 * Element valide ist</div>
	 */
	protected Date validFrom;

	/**
	 * <div class="en">End date for the period in which this element can be
	 * used</div> <div class="de">Enddatum der Periode, innerhalb derer dieses
	 * Element valide ist</div>
	 */
	protected Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with given code, displayName,
	 * specialitySectionCode, privacyFilter, validFrom and validTo
	 * parameters</div> <div class="de">Instantiiert dieses Enum Object mittels
	 * der code, displayName, specialitySectionCode, privacyFilter, validFrom und
	 * validTo Parameter</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="en">the code</div>
	 * @param displayName
	 *          <br>
	 *          <div class="en">the display name</div>
	 * @param sectionCode
	 *          <br>
	 *          <div class="en">the patient privacy filter</div>
	 * @param validFrom
	 *          <br>
	 *          <div class="en">the valid from</div>
	 * @param validTo
	 *          <br>
	 *          <div class="en">the valid to</div>
	 */
	private LabObsList(String code, String displayName, String sectionCode, String validFrom,
			String validTo) {
		this.code = code;
		this.displayName = displayName;
		this.sectionCode = sectionCode;
		if (validFrom != null && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if (validTo != null && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		cd.setCodeSystemName(CODE_SYSTEM_NAME);
		return cd;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, CODE_SYSTEM_NAME, displayName);
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
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert die
	 * code system id.</div>
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

	/**
	 * <div class="en">Gets the section code</div> <div class="de">Liefert section
	 * code</div>
	 *
	 * @return the section code
	 */
	public String getSectionCode() {
		return this.sectionCode;
	}

	/**
	 * Checks if the code is valid now.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return isValid(null);
	}

	/**
	 * Checks if the code is valid for the specified date.
	 *
	 * @param date
	 *          the date
	 * @return true, if is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if (validFrom != null && validFrom.after(date)) {
			return false;
		}
		if (validTo != null && validTo.before(date)) {
			return false;
		}
		return true;
	}
}