package org.ehealth_connector.cda.ch.lab.lrph.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

import java.util.Date;
import org.ehealth_connector.common.utils.DateUtil;
/*
*<div class="de">Meldepflichtige Beobachtung</div>
*<div class="fr"></div>
*/
public enum LabObsListLoinc {

	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_ELECTRON_MICROSCOPY ("23381-7", "Abnormal Prion Protein [Presence] in Brain by Electron microscopy", "18725-2", "none", "20130527", "N/A"),
	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_IMMUNE_STAIN ("23380-9", "Abnormal Prion Protein [Presence] in Brain by Immune stain", "18725-2", "none", "20130527", "N/A"),
	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_IMMUNOASSAY ("37425-6", "Abnormal Prion Protein [Presence] in Brain by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_IMMUNOBLOT_IB ("23379-1", "Abnormal Prion Protein [Presence] in Brain by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_LIGHT_MICROSCOPY ("38275-4", "Abnormal Prion Protein [Presence] in Brain by Light microscopy", "18725-2", "none", "20130527", "N/A"),
	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN ("39020-3", "Abnormal Prion Protein [Presence] in Tissue by Immune stain", "18725-2", "none", "20130527", "N/A"),
	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_TISSUE_BY_IMMUNOASSAY ("39021-1", "Abnormal Prion Protein [Presence] in Tissue by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_TISSUE_BY_IMMUNOBLOT_IB ("39320-7", "Abnormal Prion Protein [Presence] in Tissue by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	AMIKACIN_12_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25177-7", "Amikacin 12 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_16_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25175-1", "Amikacin 16 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_1_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("48169-7", "Amikacin 1.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("60564-2", "Amikacin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("42642-9", "Amikacin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25178-5", "Amikacin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_32_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25176-9", "Amikacin 32 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("60565-9", "Amikacin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25179-3", "Amikacin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25174-4", "Amikacin 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMIKACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20373-7", "Amikacin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMOXICILLIN_CLAVULANATE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25310-4", "Amoxicillin+Clavulanate [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	AMPICILLIN_SULBACTAM_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20374-5", "Ampicillin+Sulbactam [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ARBOVIRUS_IDENTIFIED_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE ("6309-9", "Arbovirus identified in Blood by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	ARBOVIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6310-7", "Arbovirus identified in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	ARENAVIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41621-4", "Arenavirus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	AZITHROMYCIN_ETHAMBUTOL_SUSCEPTIBILITY_BY_MINIMUM_INHIBITORY_CONCENTRATION_MIC ("16421-0", "Azithromycin+Ethambutol [Susceptibility] by Minimum inhibitory concentration (MIC)", "18769-0", "conditional", "20130527", "N/A"),
	AZITHROMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23612-5", "Azithromycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM ("22860-1", "Bacillus anthracis Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION ("22862-7", "Bacillus anthracis Ab [Presence] in Serum by Agglutination", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION ("22864-3", "Bacillus anthracis Ab [Presence] in Serum by Complement fixation", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_BY_IMMUNE_DIFFUSION_ID ("22861-9", "Bacillus anthracis Ab [Presence] in Serum by Immune diffusion (ID)", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("22863-5", "Bacillus anthracis Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_TITER_IN_SERUM ("22859-3", "Bacillus anthracis Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_TITER_IN_SERUM_BY_IMMUNE_DIFFUSION_ID ("22865-0", "Bacillus anthracis Ab [Titer] in Serum by Immune diffusion (ID)", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_SERUM ("7814-7", "Bacillus anthracis Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_SERUM_BY_HEMAGGLUTINATION ("5055-9", "Bacillus anthracis Ab [Units/volume] in Serum by Hemagglutination", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOBLOT_IB ("11467-8", "Bacillus anthracis Ab [Units/volume] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN ("22109-3", "Bacillus anthracis Ab [Units/volume] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("11468-6", "Bacillus anthracis Ab [Units/volume] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE ("33697-4", "Bacillus anthracis Ag [Presence] in Isolate by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE ("22866-8", "Bacillus anthracis Ag [Presence] in Tissue by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31726-3", "Bacillus anthracis Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("22867-6", "Bacillus anthracis Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_CAPSULE_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("51976-9", "Bacillus anthracis capsule Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_CELL_WALL_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("44269-9", "Bacillus anthracis cell wall Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41622-2", "Bacillus anthracis DNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41623-0", "Bacillus anthracis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_PRESENCE_IN_ISOLATE_BY_PHAGE_LYSIS ("33698-2", "Bacillus anthracis [Presence] in Isolate by Phage lysis", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("11469-4", "Bacillus anthracis [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	BACILLUS_ANTHRACIS_SPORE_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("44270-7", "Bacillus anthracis spore Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE ("17929-1", "Bacteria # 2 identified in Blood by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_BLOOD_BY_ANAEROBE_CULTURE ("17935-8", "Bacteria # 2 identified in Blood by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_BLOOD_BY_CULTURE ("48727-2", "Bacteria # 2 identified in Blood by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE ("17951-5", "Bacteria # 2 identified in Body fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_BODY_FLUID_BY_ANAEROBE_CULTURE ("17957-2", "Bacteria # 2 identified in Body fluid by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE ("17873-1", "Bacteria # 2 identified in Bone by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE ("17878-0", "Bacteria # 2 identified in Bronchial specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_BURN_BY_CULTURE ("17937-4", "Bacteria # 2 identified in Burn by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_DUODENAL_FLUID_BY_AEROBE_CULTURE ("53614-4", "Bacteria # 2 identified in Duodenal fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE ("17883-0", "Bacteria # 2 identified in Genital specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE ("17942-4", "Bacteria # 2 identified in Line specimen by IV Line culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE ("17888-9", "Bacteria # 2 identified in Nose by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_NOSE_BY_ANAEROBE_CULTURE ("17921-8", "Bacteria # 2 identified in Nose by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE ("17959-8", "Bacteria # 2 identified in Peritoneal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE ("17893-9", "Bacteria # 2 identified in Sputum by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_STOOL_BY_CULTURE ("17964-8", "Bacteria # 2 identified in Stool by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE ("17899-6", "Bacteria # 2 identified in Throat by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE ("17904-4", "Bacteria # 2 identified in Tissue by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_TISSUE_BY_ANAEROBE_CULTURE ("17923-4", "Bacteria # 2 identified in Tissue by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE ("44843-1", "Bacteria # 2 identified in Unspecified specimen by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("44841-5", "Bacteria # 2 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE ("48561-5", "Bacteria # 2 identified in Unspecified specimen by Respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_URINE_BY_CULTURE ("17970-5", "Bacteria # 2 identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE ("17910-1", "Bacteria # 2 identified in Wound deep by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_WOUND_DEEP_BY_ANAEROBE_CULTURE ("17926-7", "Bacteria # 2 identified in Wound deep by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_2_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE ("17916-8", "Bacteria # 2 identified in Wound shallow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE ("17930-9", "Bacteria # 3 identified in Blood by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_BLOOD_BY_ANAEROBE_CULTURE ("17936-6", "Bacteria # 3 identified in Blood by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_BLOOD_BY_CULTURE ("48724-9", "Bacteria # 3 identified in Blood by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE ("17952-3", "Bacteria # 3 identified in Body fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_BODY_FLUID_BY_ANAEROBE_CULTURE ("17958-0", "Bacteria # 3 identified in Body fluid by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE ("17874-9", "Bacteria # 3 identified in Bone by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE ("17879-8", "Bacteria # 3 identified in Bronchial specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_BURN_BY_CULTURE ("17938-2", "Bacteria # 3 identified in Burn by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_DUODENAL_FLUID_BY_AEROBE_CULTURE ("53615-1", "Bacteria # 3 identified in Duodenal fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE ("17884-8", "Bacteria # 3 identified in Genital specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE ("17943-2", "Bacteria # 3 identified in Line specimen by IV Line culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE ("17889-7", "Bacteria # 3 identified in Nose by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_NOSE_BY_ANAEROBE_CULTURE ("17922-6", "Bacteria # 3 identified in Nose by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE ("17960-6", "Bacteria # 3 identified in Peritoneal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE ("17894-7", "Bacteria # 3 identified in Sputum by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_STOOL_BY_CULTURE ("17965-5", "Bacteria # 3 identified in Stool by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE ("17900-2", "Bacteria # 3 identified in Throat by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE ("17905-1", "Bacteria # 3 identified in Tissue by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_TISSUE_BY_ANAEROBE_CULTURE ("17924-2", "Bacteria # 3 identified in Tissue by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_AEROBE_CULTURE ("48567-2", "Bacteria # 3 identified in Unspecified specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE ("44853-0", "Bacteria # 3 identified in Unspecified specimen by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("44842-3", "Bacteria # 3 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE ("48562-3", "Bacteria # 3 identified in Unspecified specimen by Respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_URINE_BY_CULTURE ("17971-3", "Bacteria # 3 identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE ("17911-9", "Bacteria # 3 identified in Wound deep by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_WOUND_DEEP_BY_ANAEROBE_CULTURE ("17927-5", "Bacteria # 3 identified in Wound deep by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_3_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE ("17917-6", "Bacteria # 3 identified in Wound shallow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE ("17931-7", "Bacteria # 4 identified in Blood by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE ("17953-1", "Bacteria # 4 identified in Body fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE ("17875-6", "Bacteria # 4 identified in Bone by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE ("17880-6", "Bacteria # 4 identified in Bronchial specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_BURN_BY_CULTURE ("17939-0", "Bacteria # 4 identified in Burn by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_DUODENAL_FLUID_BY_AEROBE_CULTURE ("53616-9", "Bacteria # 4 identified in Duodenal fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE ("17885-5", "Bacteria # 4 identified in Genital specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE ("17944-0", "Bacteria # 4 identified in Line specimen by IV Line culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE ("17890-5", "Bacteria # 4 identified in Nose by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE ("17961-4", "Bacteria # 4 identified in Peritoneal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE ("17895-4", "Bacteria # 4 identified in Sputum by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_STOOL_BY_CULTURE ("17966-3", "Bacteria # 4 identified in Stool by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE ("17901-0", "Bacteria # 4 identified in Throat by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE ("17906-9", "Bacteria # 4 identified in Tissue by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_TISSUE_BY_ANAEROBE_CULTURE ("59051-3", "Bacteria # 4 identified in Tissue by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE ("44856-3", "Bacteria # 4 identified in Unspecified specimen by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("44844-9", "Bacteria # 4 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE ("48563-1", "Bacteria # 4 identified in Unspecified specimen by Respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_URINE_BY_CULTURE ("17972-1", "Bacteria # 4 identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE ("17912-7", "Bacteria # 4 identified in Wound deep by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_4_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE ("17918-4", "Bacteria # 4 identified in Wound shallow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE ("17932-5", "Bacteria # 5 identified in Blood by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE ("17954-9", "Bacteria # 5 identified in Body fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE ("17876-4", "Bacteria # 5 identified in Bone by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE ("17881-4", "Bacteria # 5 identified in Bronchial specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_BURN_BY_CULTURE ("17940-8", "Bacteria # 5 identified in Burn by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE ("17886-3", "Bacteria # 5 identified in Genital specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE ("17945-7", "Bacteria # 5 identified in Line specimen by IV Line culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE ("17891-3", "Bacteria # 5 identified in Nose by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE ("17962-2", "Bacteria # 5 identified in Peritoneal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE ("17896-2", "Bacteria # 5 identified in Sputum by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_STOOL_BY_CULTURE ("17967-1", "Bacteria # 5 identified in Stool by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE ("17902-8", "Bacteria # 5 identified in Throat by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE ("17907-7", "Bacteria # 5 identified in Tissue by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE ("44857-1", "Bacteria # 5 identified in Unspecified specimen by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("44845-6", "Bacteria # 5 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE ("48564-9", "Bacteria # 5 identified in Unspecified specimen by Respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_URINE_BY_CULTURE ("17973-9", "Bacteria # 5 identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE ("17913-5", "Bacteria # 5 identified in Wound deep by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_5_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE ("17919-2", "Bacteria # 5 identified in Wound shallow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE ("17933-3", "Bacteria # 6 identified in Blood by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE ("17955-6", "Bacteria # 6 identified in Body fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE ("17877-2", "Bacteria # 6 identified in Bone by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE ("17882-2", "Bacteria # 6 identified in Bronchial specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_BURN_BY_CULTURE ("17941-6", "Bacteria # 6 identified in Burn by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE ("17887-1", "Bacteria # 6 identified in Genital specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE ("17946-5", "Bacteria # 6 identified in Line specimen by IV Line culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE ("17892-1", "Bacteria # 6 identified in Nose by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE ("17963-0", "Bacteria # 6 identified in Peritoneal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE ("17897-0", "Bacteria # 6 identified in Sputum by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_STOOL_BY_CULTURE ("17968-9", "Bacteria # 6 identified in Stool by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE ("17903-6", "Bacteria # 6 identified in Throat by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE ("17908-5", "Bacteria # 6 identified in Tissue by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE ("44858-9", "Bacteria # 6 identified in Unspecified specimen by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("44846-4", "Bacteria # 6 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE ("48565-6", "Bacteria # 6 identified in Unspecified specimen by Respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_URINE_BY_CULTURE ("17974-7", "Bacteria # 6 identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE ("17914-3", "Bacteria # 6 identified in Wound deep by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_6_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE ("17920-0", "Bacteria # 6 identified in Wound shallow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_7_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE ("47293-6", "Bacteria # 7 identified in Genital specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_7_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_AEROBE_CULTURE ("48568-0", "Bacteria # 7 identified in Unspecified specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_7_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE ("44859-7", "Bacteria # 7 identified in Unspecified specimen by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_7_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("44848-0", "Bacteria # 7 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_7_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE ("48566-4", "Bacteria # 7 identified in Unspecified specimen by Respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_7_IDENTIFIED_IN_URINE_BY_CULTURE ("44847-2", "Bacteria # 7 identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_7_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE ("47294-4", "Bacteria # 7 identified in Wound shallow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_8_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_AEROBE_CULTURE ("48569-8", "Bacteria # 8 identified in Unspecified specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_8_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("44850-6", "Bacteria # 8 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_8_IDENTIFIED_IN_URINE_BY_CULTURE ("44849-8", "Bacteria # 8 identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_8_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE ("47295-1", "Bacteria # 8 identified in Wound shallow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_AREA_IN_SYNOVIAL_FLUID_BY_MICROSCOPY_HIGH_POWER_FIELD ("11101-3", "Bacteria [#/area] in Synovial fluid by Microscopy high power field", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFICATION_PRESENCE_IN_ISOLATE_BY_CULTURE ("45335-7", "Bacteria Identification [Presence] in Isolate by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_24_HOUR_URINE_BY_CULTURE ("13315-7", "Bacteria identified in 24 hour Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ABSCESS_BY_AEROBE_CULTURE ("595-9", "Bacteria identified in Abscess by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_AMNIOTIC_FLUID_BY_CULTURE ("596-7", "Bacteria identified in Amniotic fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ANAL_BY_CULTURE ("52966-9", "Bacteria identified in Anal by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ASPIRATE_BY_AEROBE_CULTURE ("597-5", "Bacteria identified in Aspirate by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ASPIRATE_BY_ANAEROBE_CULTURE ("598-3", "Bacteria identified in Aspirate by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ASPIRATE_BY_CULTURE ("43411-8", "Bacteria identified in Aspirate by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BILE_FLUID_BY_CULTURE ("53911-4", "Bacteria identified in Bile fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE ("17928-3", "Bacteria identified in Blood by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE_25_DEGREE_C_INCUBATION ("45275-5", "Bacteria identified in Blood by Aerobe culture 25 degree C incubation", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BLOOD_BY_ANAEROBE_CULTURE ("17934-1", "Bacteria identified in Blood by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BLOOD_BY_ANAEROBE_CULTURE_25_DEGREE_C_INCUBATION ("45276-3", "Bacteria identified in Blood by Anaerobe culture 25 degree C incubation", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BLOOD_BY_CULTURE ("600-7", "Bacteria identified in Blood by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE ("610-6", "Bacteria identified in Body fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BODY_FLUID_BY_ANAEROBE_CULTURE ("17956-4", "Bacteria identified in Body fluid by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BODY_FLUID_BY_CULTURE ("611-4", "Bacteria identified in Body fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE ("602-3", "Bacteria identified in Bone by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BONE_MARROW_BY_AEROBE_CULTURE ("19126-2", "Bacteria identified in Bone marrow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BONE_MARROW_BY_CULTURE ("60258-1", "Bacteria identified in Bone marrow by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BRONCHIAL_BRUSH_BY_AEROBE_CULTURE ("43442-3", "Bacteria identified in Bronchial brush by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BRONCHIAL_SPECIMEN ("32810-4", "Bacteria identified in Bronchial specimen", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE ("604-9", "Bacteria identified in Bronchial specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BRONCHOALVEOLAR_LAVAGE_BY_AEROBE_CULTURE ("43441-5", "Bacteria identified in Bronchoalveolar lavage by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_BURN_BY_CULTURE ("603-1", "Bacteria identified in Burn by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_CANNULA_SPECIMEN_BY_AEROBE_CULTURE ("605-6", "Bacteria identified in Cannula specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_CATHETER_TIP_BY_CULTURE ("19128-8", "Bacteria identified in Catheter tip by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_CEREBRAL_SPINAL_FLUID_BY_CULTURE ("606-4", "Bacteria identified in Cerebral spinal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_CERVIX_BY_AEROBE_CULTURE ("14475-8", "Bacteria identified in Cervix by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_CERVIX_BY_ANAEROBE_CULTURE ("12281-2", "Bacteria identified in Cervix by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_CERVIX_BY_CULTURE ("43410-0", "Bacteria identified in Cervix by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_CONTACT_LENS_BY_CULTURE ("56714-9", "Bacteria identified in Contact lens by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_CORNEA_BY_CULTURE ("60257-3", "Bacteria identified in Cornea by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_DIALYSIS_FLUID_BY_CULTURE ("9822-8", "Bacteria identified in Dialysis fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_DRAIN_BY_AEROBE_CULTURE ("607-2", "Bacteria identified in Drain by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_DUODENAL_FLUID_BY_AEROBE_CULTURE ("53617-7", "Bacteria identified in Duodenal fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_EAR_BY_AEROBE_CULTURE ("608-0", "Bacteria identified in Ear by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_EMBRYO_BY_AEROBE_CULTURE ("20694-6", "Bacteria identified in embryo by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ESOPHAGEAL_BRUSHING_BY_CULTURE ("53908-0", "Bacteria identified in Esophageal brushing by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_EYE_BY_AEROBE_CULTURE ("609-8", "Bacteria identified in Eye by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_GASTRIC_FLUID_BY_CULTURE ("52967-7", "Bacteria identified in Gastric fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE ("10352-3", "Bacteria identified in Genital specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ISOLATE ("42803-7", "Bacteria identified in Isolate", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ISOLATE_BY_AEROBE_CULTURE ("32367-5", "Bacteria identified in Isolate by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ISOLATE_BY_ANAEROBE_CULTURE ("20878-5", "Bacteria identified in Isolate by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ISOLATE_BY_ANIMAL_INOCULATION ("20877-7", "Bacteria identified in Isolate by Animal inoculation", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ISOLATE_BY_BACTERIA_SUBTYPING ("612-2", "Bacteria identified in Isolate by Bacteria subtyping", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ISOLATE_BY_CULTURE ("43409-2", "Bacteria identified in Isolate by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ISOLATE_BY_PULSED_FIELD_GEL_ELECTROPHORESIS_PFGE ("42661-9", "Bacteria identified in Isolate by Pulsed-Field Gel Electrophoresis (PFGE)", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE ("616-3", "Bacteria identified in Line specimen by IV Line culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_NASOPHARYNX_BY_AEROBE_CULTURE ("43426-6", "Bacteria identified in Nasopharynx by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_NASOPHARYNX_BY_CULTURE ("43214-6", "Bacteria identified in Nasopharynx by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE ("10353-1", "Bacteria identified in Nose by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_PENIS_BY_AEROBE_CULTURE ("14478-2", "Bacteria identified in Penis by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_PERICARDIAL_FLUID_BY_CULTURE ("56715-6", "Bacteria identified in Pericardial fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_PERITONEAL_DIALYSIS_FLUID_BY_CULTURE ("60032-0", "Bacteria identified in Peritoneal dialysis fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE ("619-7", "Bacteria identified in Peritoneal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_PLACENTA_BY_AEROBE_CULTURE ("617-1", "Bacteria identified in Placenta by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_PLEURAL_FLUID_BY_AEROBE_CULTURE ("17279-1", "Bacteria identified in Pleural fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_PLEURAL_FLUID_BY_CULTURE ("618-9", "Bacteria identified in Pleural fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SEMEN ("13314-0", "Bacteria identified in Semen", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SEMEN_BY_CULTURE ("53558-3", "Bacteria identified in Semen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SINUS_BY_CULTURE ("43307-8", "Bacteria identified in Sinus by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SKIN_BY_AEROBE_CULTURE ("620-5", "Bacteria identified in Skin by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SPUTUM_BY_ACUTE_RESPIRATOY_DISTRESS_ARDS_CULTURE ("19127-0", "Bacteria identified in Sputum by Acute Respiratoy Distress (ARDS) culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE ("622-1", "Bacteria identified in Sputum by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SPUTUM_BY_CULTURE ("6460-0", "Bacteria identified in Sputum by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SPUTUM_BY_CYSTIC_FIBROSIS_RESPIRATORY_CULTURE ("623-9", "Bacteria identified in Sputum by Cystic fibrosis respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SPUTUM_BY_RESPIRATORY_CULTURE ("624-7", "Bacteria identified in Sputum by Respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SPUTUM_TRACHEAL_ASPIRATE_BY_CULTURE ("52973-5", "Bacteria identified in Sputum tracheal aspirate by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_STOOL_BY_ANAEROBE_CULTURE ("6461-8", "Bacteria identified in Stool by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_STOOL_BY_CULTURE ("625-4", "Bacteria identified in Stool by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_SYNOVIAL_FLUID_BY_CULTURE ("621-3", "Bacteria identified in Synovial fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE ("17898-8", "Bacteria identified in Throat by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_THROAT_BY_CULTURE ("626-2", "Bacteria identified in Throat by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE ("627-0", "Bacteria identified in Tissue by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_TISSUE_BY_ANAEROBE_CULTURE ("628-8", "Bacteria identified in Tissue by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_TISSUE_BY_BIOPSY_CULTURE ("20474-3", "Bacteria identified in Tissue by Biopsy culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_TISSUE_BY_CULTURE ("43408-4", "Bacteria identified in Tissue by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_ULCER_BY_AEROBE_CULTURE ("629-6", "Bacteria identified in Ulcer by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN ("23667-9", "Bacteria identified in Unspecified specimen", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_AEROBE_CULTURE ("634-6", "Bacteria identified in Unspecified specimen by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_AEROBE_CULTURE ("21020-3", "Bacteria identified in Unspecified specimen by Anaerobe+Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE ("635-3", "Bacteria identified in Unspecified specimen by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("6463-4", "Bacteria identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE ("32355-0", "Bacteria identified in Unspecified specimen by Respiratory culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_STERILE_BODY_FLUID_CULTURE ("636-1", "Bacteria identified in Unspecified specimen by Sterile body fluid culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_URETHRA_BY_AEROBE_CULTURE ("14477-4", "Bacteria identified in Urethra by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_URETHRA_BY_CULTURE ("10354-9", "Bacteria identified in Urethra by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_URINE_BY_CULTURE ("630-4", "Bacteria identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_VAGINAL_FLUID_BY_AEROBE_CULTURE ("11261-5", "Bacteria identified in Vaginal fluid by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_WATER_BY_CULTURE ("14093-9", "Bacteria identified in Water by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_WOUND_BY_AEROBE_CULTURE ("632-0", "Bacteria identified in Wound by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_WOUND_BY_ANAEROBE_CULTURE ("633-8", "Bacteria identified in Wound by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_WOUND_BY_CULTURE ("6462-6", "Bacteria identified in Wound by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE ("17909-3", "Bacteria identified in Wound deep by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_WOUND_DEEP_BY_ANAEROBE_CULTURE ("17925-9", "Bacteria identified in Wound deep by Anaerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_WOUND_DEEP_BY_CULTURE ("43407-6", "Bacteria identified in Wound deep by Culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE ("17915-0", "Bacteria identified in Wound shallow by Aerobe culture", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_BODY_FLUID_BY_LIGHT_MICROSCOPY ("41599-2", "Bacteria [Presence] in Body fluid by Light microscopy", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_CERVIX_BY_WET_PREPARATION ("44022-2", "Bacteria [Presence] in Cervix by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_EYE_BY_LIGHT_MICROSCOPY ("44039-6", "Bacteria [Presence] in Eye by Light microscopy", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_GENITAL_SPECIMEN_BY_WET_PREPARATION ("12178-0", "Bacteria [Presence] in Genital specimen by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_NOSE_BY_LIGHT_MICROSCOPY ("18192-5", "Bacteria [Presence] in Nose by Light microscopy", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_PERICARDIAL_FLUID_BY_LIGHT_MICROSCOPY ("41598-4", "Bacteria [Presence] in Pericardial fluid by Light microscopy", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_PERITONEAL_FLUID_BY_LIGHT_MICROSCOPY ("41601-6", "Bacteria [Presence] in Peritoneal fluid by Light microscopy", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_PLEURAL_FLUID_BY_LIGHT_MICROSCOPY ("41603-2", "Bacteria [Presence] in Pleural fluid by Light microscopy", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_SYNOVIAL_FLUID_BY_LIGHT_MICROSCOPY ("41600-8", "Bacteria [Presence] in Synovial fluid by Light microscopy", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("44038-8", "Bacteria [Presence] in Unspecified specimen", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_WET_PREPARATION ("32763-5", "Bacteria [Presence] in Unspecified specimen by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	BACTERIA_VOLUME_IN_MOTHERS_MILK ("20695-3", "Bacteria [#/volume] in Mother's milk", "18725-2", "conditional", "20130527", "N/A"),
	BRUCELLA ("26250004", "Brucella", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS ("24224000", "Brucella abortus", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("49196-9", "Brucella abortus Ab [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_ACIDIFIED_BUFFERED_PLATE_AGGLUTINATION ("51832-4", "Brucella abortus Ab [Presence] in Cerebral spinal fluid by Acidified buffered plate agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_CARD_AGGLUTINATION ("48967-4", "Brucella abortus Ab [Presence] in Cerebral spinal fluid by Card agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM ("22147-3", "Brucella abortus Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_ACIDIFIED_BUFFERED_PLATE_AGGLUTINATION ("20727-4", "Brucella abortus Ab [Presence] in Serum by Acidified buffered plate agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_CARD_AGGLUTINATION ("20726-6", "Brucella abortus Ab [Presence] in Serum by Card agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION ("20728-2", "Brucella abortus Ab [Presence] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("20730-8", "Brucella abortus Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_EIA_RST ("20731-6", "Brucella abortus Ab [Presence] in Serum by Immunoassay (EIA) RST", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("22920-3", "Brucella abortus Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION ("5066-6", "Brucella abortus Ab [Presence] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_RAPID_AGGLUTINATION ("20723-3", "Brucella abortus Ab [Presence] in Serum by Rapid agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("33945-7", "Brucella abortus Ab [Titer] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_ANTIHUMAN_GLOBULIN ("63435-2", "Brucella abortus Ab [Titer] in Cerebral spinal fluid by Antihuman globulin", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_SERUM ("22150-7", "Brucella abortus Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_AGGLUTINATION ("6324-8", "Brucella abortus Ab [Titer] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_ANTIHUMAN_GLOBULIN ("63437-8", "Brucella abortus Ab [Titer] in Serum by Antihuman globulin", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION ("6325-5", "Brucella abortus Ab [Titer] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION ("5067-4", "Brucella abortus Ab [Titer] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_PLATE_AGGLUTINATION ("20729-0", "Brucella abortus Ab [Titer] in Serum by Plate agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_RIVANOL_AGGLUTINATION ("20722-5", "Brucella abortus Ab [Titer] in Serum by Rivanol agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_TUBE_AGGLUTINATION ("20719-1", "Brucella abortus Ab [Titer] in Serum by Tube agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_UNITSVOLUME_IN_SERUM ("11586-5", "Brucella abortus Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_UNITSVOLUME_IN_SERUM_BY_AGGLUTINATION ("22921-1", "Brucella abortus Ab [Units/volume] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("19243-5", "Brucella abortus Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("22927-8", "Brucella abortus DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGA_AB_UNITSVOLUME_IN_SERUM ("6910-4", "Brucella abortus IgA Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGA_IGG_IGM_AB_UNITSVOLUME_IN_SERUM ("16486-3", "Brucella abortus IgA+IgG+IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG1_AB_PRESENCE_IN_SERUM ("22924-5", "Brucella abortus IgG1 Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG1_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("22922-9", "Brucella abortus IgG1 Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG1_AND_IGG2_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("71715-7", "Brucella abortus IgG1 and IgG2 Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("42592-6", "Brucella abortus IgG Ab [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_PRESENCE_IN_SERUM ("38243-2", "Brucella abortus IgG Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("23963-2", "Brucella abortus IgG Ab [Titer] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("23986-3", "Brucella abortus IgG Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_TITER_IN_SERUM ("16119-0", "Brucella abortus IgG Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("13212-6", "Brucella abortus IgG Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM ("6911-2", "Brucella abortus IgG Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_AGGLUTINATION ("16487-1", "Brucella abortus IgG Ab [Units/volume] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_COMPLEMENT_FIXATION ("16488-9", "Brucella abortus IgG Ab [Units/volume] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("43843-2", "Brucella abortus IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE ("44818-3", "Brucella abortus IgG Ab [Units/volume] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGG_IGM_AB_UNITSVOLUME_IN_SERUM ("44458-8", "Brucella abortus IgG+IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGM_AB_PRESENCE_IN_SERUM ("38244-0", "Brucella abortus IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("23964-0", "Brucella abortus IgM Ab [Titer] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("23987-1", "Brucella abortus IgM Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGM_AB_TITER_IN_SERUM ("16120-8", "Brucella abortus IgM Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("13213-4", "Brucella abortus IgM Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGM_AB_UNITSVOLUME_IN_SERUM ("22151-5", "Brucella abortus IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("6326-3", "Brucella abortus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE ("44815-9", "Brucella abortus IgM Ab [Units/volume] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_ABORTUS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("22926-0", "Brucella abortus rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS ("38025008", "Brucella canis", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM ("22928-6", "Brucella canis Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION ("22930-2", "Brucella canis Ab [Presence] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_BY_IMMUNE_DIFFUSION_ID ("22929-4", "Brucella canis Ab [Presence] in Serum by Immune diffusion (ID)", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("23681-0", "Brucella canis Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_BY_PLATE_AGGLUTINATION ("24410-3", "Brucella canis Ab [Presence] in Serum by Plate agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_TITER_IN_SERUM ("22152-3", "Brucella canis Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_TITER_IN_SERUM_BY_AGGLUTINATION ("23682-8", "Brucella canis Ab [Titer] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("23683-6", "Brucella canis Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION ("5068-2", "Brucella canis Ab [Titer] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_UNITSVOLUME_IN_SERUM ("11587-3", "Brucella canis Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("6327-1", "Brucella canis Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AB_PRESENCE_IN_SERUM ("38245-7", "Brucella canis IgG Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("43072-8", "Brucella canis IgG Ab [Titer] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("30092-1", "Brucella canis IgG Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AB_TITER_IN_SERUM ("22154-9", "Brucella canis IgG Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("14079-8", "Brucella canis IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("13214-2", "Brucella canis IgG Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AB_UNITSVOLUME_IN_SERUM ("22153-1", "Brucella canis IgG Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("9495-3", "Brucella canis IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGG_AND_IGM_INTERPRETATION_IN_SERUM ("44077-6", "Brucella canis IgG and IgM [interpretation] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGM_AB_PRESENCE_IN_SERUM ("38246-5", "Brucella canis IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("43071-0", "Brucella canis IgM Ab [Titer] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("30093-9", "Brucella canis IgM Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGM_AB_TITER_IN_SERUM ("22156-4", "Brucella canis IgM Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("14080-6", "Brucella canis IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("13215-9", "Brucella canis IgM Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGM_AB_UNITSVOLUME_IN_SERUM ("22155-6", "Brucella canis IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_CANIS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("9496-1", "Brucella canis IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS ("72829003", "Brucella melitensis", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_PRESENCE_IN_SERUM ("22931-0", "Brucella melitensis Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION ("22933-6", "Brucella melitensis Ab [Presence] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION ("22935-1", "Brucella melitensis Ab [Presence] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("22932-8", "Brucella melitensis Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_TITER_IN_SERUM ("22157-2", "Brucella melitensis Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION ("5069-0", "Brucella melitensis Ab [Titer] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_UNITSVOLUME_IN_SERUM ("11588-1", "Brucella melitensis Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_UNITSVOLUME_IN_SERUM_BY_COMPLEMENT_FIXATION ("22934-4", "Brucella melitensis Ab [Units/volume] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION ("16489-7", "Brucella melitensis Ab [Units/volume] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("22936-9", "Brucella melitensis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("57670-2", "Brucella melitensis IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_MELITENSIS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("57671-0", "Brucella melitensis IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM ("22158-0", "Brucella ovis Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION ("22938-5", "Brucella ovis Ab [Presence] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION ("20733-2", "Brucella ovis Ab [Presence] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_BY_IMMUNE_DIFFUSION_ID ("22940-1", "Brucella ovis Ab [Presence] in Serum by Immune diffusion (ID)", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("20732-4", "Brucella ovis Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_OVIS_AB_TITER_IN_SERUM ("23684-4", "Brucella ovis Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_OVIS_AB_UNITSVOLUME_IN_SERUM ("22939-3", "Brucella ovis Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_OVIS_AB_UNITSVOLUME_IN_SERUM_BY_COMPLEMENT_FIXATION ("22937-7", "Brucella ovis Ab [Units/volume] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SPECIES ("116505000", "Brucella species", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_PRESENCE_IN_SERUM ("30202-6", "Brucella sp Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_PRESENCE_IN_SERUM_1ST_SPECIMEN ("30129-1", "Brucella sp Ab [Presence] in Serum --1st specimen", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_PRESENCE_IN_SERUM_2ND_SPECIMEN ("30130-9", "Brucella sp Ab [Presence] in Serum --2nd specimen", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION ("40614-0", "Brucella sp Ab [Presence] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION ("40613-2", "Brucella sp Ab [Presence] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_AGGLUTINATION ("58806-1", "Brucella sp Ab [Titer] in Cerebral spinal fluid by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_TITER_IN_SERUM ("22159-8", "Brucella sp Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_TITER_IN_SERUM_1ST_SPECIMEN ("29250-8", "Brucella sp Ab [Titer] in Serum --1st specimen", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_TITER_IN_SERUM_2ND_SPECIMEN ("29251-6", "Brucella sp Ab [Titer] in Serum --2nd specimen", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_TITER_IN_SERUM_BY_AGGLUTINATION ("19053-8", "Brucella sp Ab [Titer] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("6328-9", "Brucella sp Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_TITER_IN_SERUM_BY_TUBE_AGGLUTINATION ("51671-6", "Brucella sp Ab [Titer] in Serum by Tube agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AB_UNITSVOLUME_IN_SERUM ("10349-9", "Brucella sp Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AG_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("44271-5", "Brucella sp Ag [Identifier] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_AGGLUTINATION ("47001-3", "Brucella sp Ag [Presence] in Unspecified specimen by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("41624-8", "Brucella sp Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_DNA_IDENTIFIER_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53604-5", "Brucella sp DNA [Identifier] in Serum by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41625-5", "Brucella sp DNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_DNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("63465-9", "Brucella sp DNA [Presence] in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41626-3", "Brucella sp DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IDENTIFIED_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE ("551-2", "Brucella sp identified in Blood by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IDENTIFIED_IN_BONE_MARROW_BY_ORGANISM_SPECIFIC_CULTURE ("24003-6", "Brucella sp identified in Bone marrow by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IDENTIFIED_IN_TISSUE_BY_ORGANISM_SPECIFIC_CULTURE ("20734-0", "Brucella sp identified in Tissue by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("552-0", "Brucella sp identified in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGA_AB_UNITSVOLUME_IN_SERUM ("13211-8", "Brucella sp IgA Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGG_AB_PRESENCE_IN_SERUM ("24396-4", "Brucella sp IgG Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("24387-3", "Brucella sp IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGG_AB_TITER_IN_SERUM ("38247-3", "Brucella sp IgG Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGG_AB_TITER_IN_SERUM_1ST_SPECIMEN ("72308-0", "Brucella sp IgG Ab [Titer] in Serum --1st specimen", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGG_AB_TITER_IN_SERUM_2ND_SPECIMEN ("72307-2", "Brucella sp IgG Ab [Titer] in Serum --2nd specimen", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGG_AB_UNITSVOLUME_IN_SERUM ("13210-0", "Brucella sp IgG Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("56630-7", "Brucella sp IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGG_AND_IGM_INTERPRETATION_IN_SERUM ("66485-4", "Brucella sp IgG and IgM [interpretation] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGM_AB_PRESENCE_IN_SERUM ("24397-2", "Brucella sp IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("24388-1", "Brucella sp IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGM_AB_TITER_IN_SERUM ("38248-1", "Brucella sp IgM Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM ("5070-8", "Brucella sp IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("56631-5", "Brucella sp IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SP_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("44797-9", "Brucella sp [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS ("48317004", "Brucella suis", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_PRESENCE_IN_SERUM ("22951-8", "Brucella suis Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("22952-6", "Brucella suis Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_PRESENCE_IN_SERUM_BY_PLATE_AGGLUTINATION ("22950-0", "Brucella suis Ab [Presence] in Serum by Plate agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_TITER_IN_SERUM ("22160-6", "Brucella suis Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION ("5071-6", "Brucella suis Ab [Titer] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_TITER_IN_SERUM_BY_PLATE_AGGLUTINATION ("71717-3", "Brucella suis Ab [Titer] in Serum by Plate agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_TITER_IN_SERUM_BY_TUBE_AGGLUTINATION ("71716-5", "Brucella suis Ab [Titer] in Serum by Tube agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_UNITSVOLUME_IN_SERUM ("11589-9", "Brucella suis Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_UNITSVOLUME_IN_SERUM_BY_COMPLEMENT_FIXATION ("22953-4", "Brucella suis Ab [Units/volume] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION ("16490-5", "Brucella suis Ab [Units/volume] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("22955-9", "Brucella suis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	BRUCELLA_SUIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("22954-2", "Brucella suis rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER ("35408001", "Campylobacter", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_COLI ("40614002", "Campylobacter coli", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_COLI_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("6329-7", "Campylobacter coli rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_COLI_RRNA_UNITSVOLUME_IN_SERUM_BY_DNA_PROBE ("16528-2", "Campylobacter coli rRNA [Units/volume] in Serum by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_CURVUS ("116037008", "Campylobacter curvus", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_FETUS ("84210007", "Campylobacter fetus", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_HYOINTESTINALIS ("9041007", "Campylobacter hyointestinalis", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_JEJUNI ("66543000", "Campylobacter jejuni", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_JEJUNI_CAMPYLOBACTER_COLI_AG_PRESENCE_IN_STOOL ("57768-4", "Campylobacter jejuni+Campylobacter coli Ag [Presence] in Stool", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_JEJUNI_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("61368-7", "Campylobacter jejuni DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_JEJUNI_RRNA_PRESENCE_IN_SERUM_BY_DNA_PROBE ("16530-8", "Campylobacter jejuni rRNA [Presence] in Serum by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_JEJUNI_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("6333-9", "Campylobacter jejuni rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_JEJUNI_RRNA_UNITSVOLUME_IN_SERUM_BY_DNA_PROBE ("16529-0", "Campylobacter jejuni rRNA [Units/volume] in Serum by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_LARI ("116386003", "Campylobacter lari", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_LARI_RRNA_PRESENCE_IN_SERUM_BY_DNA_PROBE ("16532-4", "Campylobacter lari rRNA [Presence] in Serum by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_LARI_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("6334-7", "Campylobacter lari rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_LARI_RRNA_UNITSVOLUME_IN_SERUM_BY_DNA_PROBE ("16531-6", "Campylobacter lari rRNA [Units/volume] in Serum by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_RECTUS ("113525005", "Campylobacter rectus", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SPECIES ("116457002", "Campylobacter species", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SPUTORUM ("91524009", "Campylobacter sputorum", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_DNA_DIARRHEAGENIC_PRESENCE_IN_STOOL_QUALITATIVE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("71429-5", "Campylobacter sp DNA.diarrheagenic [Presence] in Stool Qualitative by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49614-1", "Campylobacter sp DNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_IDENTIFIED_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE ("6330-5", "Campylobacter sp identified in Blood by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_IDENTIFIED_IN_BODY_FLUID_BY_ORGANISM_SPECIFIC_CULTURE ("20739-9", "Campylobacter sp identified in Body fluid by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_IDENTIFIED_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE ("20738-1", "Campylobacter sp identified in Isolate by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE ("6331-3", "Campylobacter sp identified in Stool by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_IDENTIFIED_IN_TISSUE_BY_ORGANISM_SPECIFIC_CULTURE ("20740-7", "Campylobacter sp identified in Tissue by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6332-1", "Campylobacter sp identified in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_RRNA_PRESENCE_IN_SERUM_BY_DNA_PROBE ("16534-0", "Campylobacter sp rRNA [Presence] in Serum by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_SP_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("4992-4", "Campylobacter sp rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CAMPYLOBACTER_UPSALIENSIS ("103427005", "Campylobacter upsaliensis", "18725-2", "initials", "20130527", "N/A"),
	CAPREOMYCIN_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25210-6", "Capreomycin 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CAPREOMYCIN_20_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25211-4", "Capreomycin 20 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CAPREOMYCIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25212-2", "Capreomycin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CAPREOMYCIN_3_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("48170-5", "Capreomycin 3 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CAPREOMYCIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("61355-4", "Capreomycin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CAPREOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23607-5", "Capreomycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CEFOTAXIME_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("50632-9", "Cefotaxime [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CEFOXITIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25220-5", "Cefoxitin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CEFOXITIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25366-6", "Cefoxitin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CEFTAZIDIME_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("58705-5", "Ceftazidime [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CEFTRIAXONE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25367-4", "Ceftriaxone [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CHIKUNGUNYA_VIRUS_IGM_AB_PRESENCE_IN_SERUM ("57934-2", "Chikungunya virus IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	CHIKUNGUNYA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE ("56131-6", "Chikungunya virus IgM Ab [Presence] in Serum or Plasma by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHIKUNGUNYA_VIRUS_IGM_AB_TITER_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE ("56130-8", "Chikungunya virus IgM Ab [Titer] in Serum or Plasma by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHIKUNGUNYA_VIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60260-7", "Chikungunya virus RNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHIKUNGUNYA_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("51664-1", "Chikungunya virus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS ("63938009", "Chlamydia trachomatis", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_ANAL ("34710-4", "Chlamydia trachomatis Ag [Presence] in Anal", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_BLOOD ("31768-5", "Chlamydia trachomatis Ag [Presence] in Blood", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_BLOOD_BY_IMMUNOASSAY ("14468-3", "Chlamydia trachomatis Ag [Presence] in Blood by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_BLOOD_BY_IMMUNOFLUORESCENCE ("14507-8", "Chlamydia trachomatis Ag [Presence] in Blood by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_BODY_FLUID ("47234-0", "Chlamydia trachomatis Ag [Presence] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31770-1", "Chlamydia trachomatis Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("14469-1", "Chlamydia trachomatis Ag [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("14508-6", "Chlamydia trachomatis Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CERVIX ("31771-9", "Chlamydia trachomatis Ag [Presence] in Cervix", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CERVIX_BY_IMMUNOASSAY ("14470-9", "Chlamydia trachomatis Ag [Presence] in Cervix by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CERVIX_BY_IMMUNOFLUORESCENCE ("14509-4", "Chlamydia trachomatis Ag [Presence] in Cervix by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN ("31769-3", "Chlamydia trachomatis Ag [Presence] in Conjunctival specimen", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_IMMUNOASSAY ("6350-3", "Chlamydia trachomatis Ag [Presence] in Conjunctival specimen by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6351-1", "Chlamydia trachomatis Ag [Presence] in Conjunctival specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_GENITAL_SPECIMEN ("45091-6", "Chlamydia trachomatis Ag [Presence] in Genital specimen", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_NASOPHARYNX ("34709-6", "Chlamydia trachomatis Ag [Presence] in Nasopharynx", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOASSAY ("45092-4", "Chlamydia trachomatis Ag [Presence] in Nasopharynx by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_PENIS ("31773-5", "Chlamydia trachomatis Ag [Presence] in Penis", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_PENIS_BY_IMMUNOASSAY ("14473-3", "Chlamydia trachomatis Ag [Presence] in Penis by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_PENIS_BY_IMMUNOFLUORESCENCE ("14512-8", "Chlamydia trachomatis Ag [Presence] in Penis by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_STOOL ("31774-3", "Chlamydia trachomatis Ag [Presence] in Stool", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_STOOL_BY_IMMUNOFLUORESCENCE ("6352-9", "Chlamydia trachomatis Ag [Presence] in Stool by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE ("6353-7", "Chlamydia trachomatis Ag [Presence] in Tissue by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31777-6", "Chlamydia trachomatis Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("6354-5", "Chlamydia trachomatis Ag [Presence] in Unspecified specimen by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6355-2", "Chlamydia trachomatis Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URETHRA ("31776-8", "Chlamydia trachomatis Ag [Presence] in Urethra", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URETHRA_BY_IMMUNOASSAY ("14472-5", "Chlamydia trachomatis Ag [Presence] in Urethra by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URETHRA_BY_IMMUNOFLUORESCENCE ("14511-0", "Chlamydia trachomatis Ag [Presence] in Urethra by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URINE_SEDIMENT ("31775-0", "Chlamydia trachomatis Ag [Presence] in Urine sediment", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URINE_SEDIMENT_BY_IMMUNOASSAY ("14474-1", "Chlamydia trachomatis Ag [Presence] in Urine sediment by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URINE_SEDIMENT_BY_IMMUNOFLUORESCENCE ("14513-6", "Chlamydia trachomatis Ag [Presence] in Urine sediment by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_VAGINAL_FLUID ("31772-7", "Chlamydia trachomatis Ag [Presence] in Vaginal fluid", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_VAGINAL_FLUID_BY_IMMUNOASSAY ("14471-7", "Chlamydia trachomatis Ag [Presence] in Vaginal fluid by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_VAGINAL_FLUID_BY_IMMUNOFLUORESCENCE ("14510-2", "Chlamydia trachomatis Ag [Presence] in Vaginal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("47212-6", "Chlamydia trachomatis DNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_ANAL_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("45090-8", "Chlamydia trachomatis DNA [Presence] in Anal by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("16599-3", "Chlamydia trachomatis DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_CERVICAL_MUCUS_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21189-6", "Chlamydia trachomatis DNA [Presence] in Cervical mucus by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_CERVIX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21190-4", "Chlamydia trachomatis DNA [Presence] in Cervix by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21187-0", "Chlamydia trachomatis DNA [Presence] in Conjunctival specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_GENITAL_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("6356-0", "Chlamydia trachomatis DNA [Presence] in Genital specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_NASOPHARYNX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("45086-6", "Chlamydia trachomatis DNA [Presence] in Nasopharynx by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_PENIS_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("45087-4", "Chlamydia trachomatis DNA [Presence] in Penis by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_SEMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("51578-3", "Chlamydia trachomatis DNA [Presence] in Semen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("43404-3", "Chlamydia trachomatis DNA [Presence] in Unspecified specimen by Probe and signal amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21613-5", "Chlamydia trachomatis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("50311-0", "Chlamydia trachomatis DNA [Presence] in Unspecified specimen from donor by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_URETHRA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21191-2", "Chlamydia trachomatis DNA [Presence] in Urethra by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_URINE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("6357-8", "Chlamydia trachomatis DNA [Presence] in Urine by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_VAGINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("45084-1", "Chlamydia trachomatis DNA [Presence] in Vaginal fluid by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_DNA_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49096-1", "Chlamydia trachomatis DNA [Units/volume] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_L2_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("47211-8", "Chlamydia trachomatis L2 DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_ANAL_BY_ORGANISM_SPECIFIC_CULTURE ("45093-2", "Chlamydia trachomatis [Presence] in Anal by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE ("14461-8", "Chlamydia trachomatis [Presence] in Blood by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE ("14462-6", "Chlamydia trachomatis [Presence] in Cerebral spinal fluid by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_CERVIX_BY_ORGANISM_SPECIFIC_CULTURE ("14463-4", "Chlamydia trachomatis [Presence] in Cervix by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("45094-0", "Chlamydia trachomatis [Presence] in Conjunctival specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_GENITAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("45095-7", "Chlamydia trachomatis [Presence] in Genital specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_NASOPHARYNX_BY_ORGANISM_SPECIFIC_CULTURE ("45096-5", "Chlamydia trachomatis [Presence] in Nasopharynx by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_PENIS_BY_ORGANISM_SPECIFIC_CULTURE ("14466-7", "Chlamydia trachomatis [Presence] in Penis by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6349-5", "Chlamydia trachomatis [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_URETHRA_BY_ORGANISM_SPECIFIC_CULTURE ("14465-9", "Chlamydia trachomatis [Presence] in Urethra by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_URINE_SEDIMENT_BY_ORGANISM_SPECIFIC_CULTURE ("14467-5", "Chlamydia trachomatis [Presence] in Urine sediment by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_VAGINAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE ("14464-2", "Chlamydia trachomatis [Presence] in Vaginal fluid by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_ANAL_BY_DNA_PROBE ("45089-0", "Chlamydia trachomatis rRNA [Presence] in Anal by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_ANAL_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("57287-5", "Chlamydia trachomatis rRNA [Presence] in Anal by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_BLOOD_BY_DNA_PROBE ("38469-3", "Chlamydia trachomatis rRNA [Presence] in Blood by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_CERVIX_BY_DNA_PROBE ("45078-3", "Chlamydia trachomatis rRNA [Presence] in Cervix by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_CERVIX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("50387-0", "Chlamydia trachomatis rRNA [Presence] in Cervix by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_DNA_PROBE ("21188-8", "Chlamydia trachomatis rRNA [Presence] in Conjunctival specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_GENITAL_FLUID_BY_DNA_PROBE ("23838-6", "Chlamydia trachomatis rRNA [Presence] in Genital fluid by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_GENITAL_SPECIMEN_BY_DNA_PROBE ("16600-9", "Chlamydia trachomatis rRNA [Presence] in Genital specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_NASOPHARYNX_BY_DNA_PROBE ("45085-8", "Chlamydia trachomatis rRNA [Presence] in Nasopharynx by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_NASOPHARYNX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("57288-3", "Chlamydia trachomatis rRNA [Presence] in Nasopharynx by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_PENIS_BY_DNA_PROBE ("45088-2", "Chlamydia trachomatis rRNA [Presence] in Penis by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("4993-2", "Chlamydia trachomatis rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("43304-5", "Chlamydia trachomatis rRNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("50411-8", "Chlamydia trachomatis rRNA [Presence] in Unspecified specimen from donor by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_URETHRA_BY_DNA_PROBE ("21192-0", "Chlamydia trachomatis rRNA [Presence] in Urethra by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_URETHRA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53925-4", "Chlamydia trachomatis rRNA [Presence] in Urethra by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_URINE_BY_DNA_PROBE ("16601-7", "Chlamydia trachomatis rRNA [Presence] in Urine by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_URINE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("42931-6", "Chlamydia trachomatis rRNA [Presence] in Urine by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_VAGINAL_FLUID_BY_DNA_PROBE ("45080-9", "Chlamydia trachomatis rRNA [Presence] in Vaginal fluid by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_VAGINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53926-2", "Chlamydia trachomatis rRNA [Presence] in Vaginal fluid by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	CIPROFLOXACIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("55194-5", "Ciprofloxacin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CIPROFLOXACIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25180-1", "Ciprofloxacin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CIPROFLOXACIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25181-9", "Ciprofloxacin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CIPROFLOXACIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25189-2", "Ciprofloxacin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CIPROFLOXACIN_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25188-4", "Ciprofloxacin 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CIPROFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20377-8", "Ciprofloxacin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLARITHROMYCIN_12_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("43987-7", "Clarithromycin 12 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLARITHROMYCIN_16_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25191-8", "Clarithromycin 16 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLARITHROMYCIN_32_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25192-6", "Clarithromycin 32 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLARITHROMYCIN_3_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("43990-1", "Clarithromycin 3 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLARITHROMYCIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("43991-9", "Clarithromycin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLARITHROMYCIN_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25190-0", "Clarithromycin 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLARITHROMYCIN_ETHAMBUTOL_SUSCEPTIBILITY_BY_MINIMUM_INHIBITORY_CONCENTRATION_MIC ("16620-7", "Clarithromycin+Ethambutol [Susceptibility] by Minimum inhibitory concentration (MIC)", "18769-0", "conditional", "20130527", "N/A"),
	CLARITHROMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20375-2", "Clarithromycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLOFAZIMINE_0_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("43988-5", "Clofazimine 0.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLOFAZIMINE_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("43989-3", "Clofazimine 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLOFAZIMINE_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("43986-9", "Clofazimine 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLOFAZIMINE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20376-0", "Clofazimine [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_PRESENCE_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE ("33695-8", "Clostridium botulinum [Presence] in Isolate by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("33694-1", "Clostridium botulinum [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_A_AB_PRESENCE_IN_SERUM ("34664-3", "Clostridium botulinum toxin A Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_A_B_E_F_G_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION ("38989-0", "Clostridium botulinum toxin A+B+E+F+G [Presence] in Unspecified specimen by Mouse bioassay neutralization", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_A_B_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("33712-1", "Clostridium botulinum toxin A+B+E [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_A_B_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION ("33704-8", "Clostridium botulinum toxin A+B+E [Presence] in Unspecified specimen by Mouse bioassay neutralization", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_A_GENE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41631-3", "Clostridium botulinum toxin A gene [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_A_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("33709-7", "Clostridium botulinum toxin A [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_A_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("41630-5", "Clostridium botulinum toxin A [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_A_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION ("33701-4", "Clostridium botulinum toxin A [Presence] in Unspecified specimen by Mouse bioassay neutralization", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_B_GENE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41633-9", "Clostridium botulinum toxin B gene [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_B_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("33713-9", "Clostridium botulinum toxin B [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_B_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("41632-1", "Clostridium botulinum toxin B [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_B_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION ("33705-5", "Clostridium botulinum toxin B [Presence] in Unspecified specimen by Mouse bioassay neutralization", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("33710-5", "Clostridium botulinum toxin E [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("41634-7", "Clostridium botulinum toxin E [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION ("33702-2", "Clostridium botulinum toxin E [Presence] in Unspecified specimen by Mouse bioassay neutralization", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_F_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("33711-3", "Clostridium botulinum toxin F [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_F_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("41635-4", "Clostridium botulinum toxin F [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_F_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION ("33703-0", "Clostridium botulinum toxin F [Presence] in Unspecified specimen by Mouse bioassay neutralization", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_GENE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("46705-0", "Clostridium botulinum toxin gene [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_IDENTIFIER_IN_SERUM_BY_ANIMAL_INOCULATION ("20705-0", "Clostridium botulinum toxin [Identifier] in Serum by Animal inoculation", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN ("44796-1", "Clostridium botulinum toxin [Identifier] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ANIMAL_INOCULATION ("20706-8", "Clostridium botulinum toxin [Identifier] in Unspecified specimen by Animal inoculation", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("44274-9", "Clostridium botulinum toxin [Identifier] in Unspecified specimen by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("33708-9", "Clostridium botulinum toxin [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("45039-5", "Clostridium botulinum toxin [Presence] in Unspecified specimen by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY ("33696-6", "Clostridium botulinum toxin [Presence] in Unspecified specimen by Mouse bioassay", "18725-2", "none", "20130527", "N/A"),
	CLOSTRIDIUM_BOTULINUM_TOXIN_UNITSVOLUME_IN_STOOL ("11470-2", "Clostridium botulinum toxin [Units/volume] in Stool", "18725-2", "none", "20130527", "N/A"),
	CORYNEBACTERIUM_DIPHTHERIAE ("5851001", "Corynebacterium diphtheriae", "18725-2", "none", "20130527", "N/A"),
	CORYNEBACTERIUM_DIPHTHERIAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("67561-1", "Corynebacterium diphtheriae DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	CORYNEBACTERIUM_DIPHTHERIAE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("16676-9", "Corynebacterium diphtheriae [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	CORYNEBACTERIUM_DIPHTHERIAE_TYPE_GRAVIS ("83675005", "Corynebacterium diphtheriae type gravis", "18725-2", "none", "20130527", "N/A"),
	CORYNEBACTERIUM_DIPHTHERIAE_TYPE_INTERMEDIUS ("70876001", "Corynebacterium diphtheriae type intermedius", "18725-2", "none", "20130527", "N/A"),
	CORYNEBACTERIUM_DIPHTHERIAE_TYPE_MITIS ("13755001", "Corynebacterium diphtheriae type mitis", "18725-2", "none", "20130527", "N/A"),
	CORYNEBACTERIUM_DIPHTHERIAE_VAR_BELFANTI ("243255007", "Corynebacterium diphtheriae var belfanti", "18725-2", "none", "20130527", "N/A"),
	COXIELLA_BURNETII_AB_TITER_IN_SERUM ("22211-7", "Coxiella burnetii Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60261-5", "Coxiella burnetii DNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("23024-3", "Coxiella burnetii DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_SEQUENCING ("49124-1", "Coxiella burnetii identified in Unspecified specimen by Sequencing", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_AND_2_IGG_AND_IGM_INTERPRETATION_IN_SERUM ("44006-5", "Coxiella burnetii phase 1 and 2 IgG and IgM [interpretation] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGA_AB_TITER_IN_BODY_FLUID ("49187-8", "Coxiella burnetii phase 1 IgA Ab [Titer] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGA_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE ("48889-0", "Coxiella burnetii phase 1 IgA Ab [Titer] in Body fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGA_AB_TITER_IN_SERUM ("9706-3", "Coxiella burnetii phase 1 IgA Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("48848-6", "Coxiella burnetii phase 1 IgA Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGA_AB_UNITSVOLUME_IN_SERUM ("31312-2", "Coxiella burnetii phase 1 IgA Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGG_AB_PRESENCE_IN_SERUM ("32644-7", "Coxiella burnetii phase 1 IgG Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("48720-7", "Coxiella burnetii phase 1 IgG Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGG_AB_TITER_IN_BODY_FLUID ("49186-0", "Coxiella burnetii phase 1 IgG Ab [Titer] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGG_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE ("48888-2", "Coxiella burnetii phase 1 IgG Ab [Titer] in Body fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGG_AB_TITER_IN_SERUM ("9708-9", "Coxiella burnetii phase 1 IgG Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("34716-1", "Coxiella burnetii phase 1 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGG_AB_UNITSVOLUME_IN_SERUM ("7829-5", "Coxiella burnetii phase 1 IgG Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51810-0", "Coxiella burnetii phase 1 IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_PRESENCE_IN_SERUM ("32645-4", "Coxiella burnetii phase 1 IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("63455-0", "Coxiella burnetii phase 1 IgM Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_TITER_IN_BODY_FLUID ("49185-2", "Coxiella burnetii phase 1 IgM Ab [Titer] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE ("48890-8", "Coxiella burnetii phase 1 IgM Ab [Titer] in Body fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_TITER_IN_SERUM ("9710-5", "Coxiella burnetii phase 1 IgM Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47075-7", "Coxiella burnetii phase 1 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_UNITSVOLUME_IN_SERUM ("7831-1", "Coxiella burnetii phase 1 IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51811-8", "Coxiella burnetii phase 1 IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_1_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE ("42897-9", "Coxiella burnetii phase 1 IgM Ab [Units/volume] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_AB_TITER_IN_SERUM ("38389-3", "Coxiella burnetii phase 2 Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION ("29772-1", "Coxiella burnetii phase 2 Ab [Titer] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("27945-5", "Coxiella burnetii phase 2 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_AB_UNITSVOLUME_IN_SERUM ("31313-0", "Coxiella burnetii phase 2 Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGA_AB_TITER_IN_BODY_FLUID ("49184-5", "Coxiella burnetii phase 2 IgA Ab [Titer] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGA_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE ("48891-6", "Coxiella burnetii phase 2 IgA Ab [Titer] in Body fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGA_AB_TITER_IN_SERUM ("9707-1", "Coxiella burnetii phase 2 IgA Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("48849-4", "Coxiella burnetii phase 2 IgA Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGA_AB_UNITSVOLUME_IN_SERUM ("31316-3", "Coxiella burnetii phase 2 IgA Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_PRESENCE_IN_SERUM ("31314-8", "Coxiella burnetii phase 2 IgG Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("29777-0", "Coxiella burnetii phase 2 IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("48719-9", "Coxiella burnetii phase 2 IgG Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_BODY_FLUID ("49183-7", "Coxiella burnetii phase 2 IgG Ab [Titer] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE ("48893-2", "Coxiella burnetii phase 2 IgG Ab [Titer] in Body fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("58761-8", "Coxiella burnetii phase 2 IgG Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_SERUM ("9709-7", "Coxiella burnetii phase 2 IgG Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("34717-9", "Coxiella burnetii phase 2 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("58762-6", "Coxiella burnetii phase 2 IgG Ab [Units/volume] in Cerebral spinal fluid by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_UNITSVOLUME_IN_SERUM ("7830-3", "Coxiella burnetii phase 2 IgG Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51812-6", "Coxiella burnetii phase 2 IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_PRESENCE_IN_SERUM ("31315-5", "Coxiella burnetii phase 2 IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("29773-9", "Coxiella burnetii phase 2 IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("43928-1", "Coxiella burnetii phase 2 IgM Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_TITER_IN_BODY_FLUID ("49182-9", "Coxiella burnetii phase 2 IgM Ab [Titer] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE ("48892-4", "Coxiella burnetii phase 2 IgM Ab [Titer] in Body fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_TITER_IN_SERUM ("9711-3", "Coxiella burnetii phase 2 IgM Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("44814-2", "Coxiella burnetii phase 2 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_UNITSVOLUME_IN_SERUM ("7832-9", "Coxiella burnetii phase 2 IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PHASE_2_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51813-4", "Coxiella burnetii phase 2 IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	COXIELLA_BURNETII_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("44799-5", "Coxiella burnetii [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	CYCLOSERINE_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25207-2", "Cycloserine 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CYCLOSERINE_20_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25208-0", "Cycloserine 20 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CYCLOSERINE_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25209-8", "Cycloserine 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	CYCLOSERINE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23608-3", "Cycloserine [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	DENGUE_VIRUS ("34348001", "Dengue virus", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_1_2_3_4_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("7855-0", "Dengue virus 1+2+3+4 RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_1_AB_TITER_IN_SERUM ("16736-1", "Dengue virus 1 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_1_AB_UNITSVOLUME_IN_SERUM ("31338-7", "Dengue virus 1 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_1_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60262-3", "Dengue virus 1 RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_2_AB_TITER_IN_SERUM ("16737-9", "Dengue virus 2 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_2_AB_UNITSVOLUME_IN_SERUM ("31339-5", "Dengue virus 2 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_2_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60420-7", "Dengue virus 2 RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_3_AB_TITER_IN_SERUM ("16738-7", "Dengue virus 3 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_3_AB_UNITSVOLUME_IN_SERUM ("31340-3", "Dengue virus 3 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_3_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60419-9", "Dengue virus 3 RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_4_AB_TITER_IN_SERUM ("16739-5", "Dengue virus 4 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_4_AB_UNITSVOLUME_IN_SERUM ("31341-1", "Dengue virus 4 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_4_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60418-1", "Dengue virus 4 RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AB_TITER_IN_SERUM ("33606-5", "Dengue virus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION ("40515-9", "Dengue virus Ab [Titer] in Serum by Complement fixation", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION ("55369-3", "Dengue virus Ab [Titer] in Serum by Hemagglutination inhibition", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("33578-6", "Dengue virus Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST ("55438-6", "Dengue virus Ab [Titer] in Serum by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AB_UNITSVOLUME_IN_SERUM ("7859-2", "Dengue virus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN ("31342-9", "Dengue virus Ab [Units/volume] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AG_PRESENCE_IN_SERUM ("31798-2", "Dengue virus Ag [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AG_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("6384-2", "Dengue virus Ag [Presence] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31799-0", "Dengue virus Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6385-9", "Dengue virus Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_DNA_PRESENCE_IN_SERUM_BY_DNA_PROBE ("6386-7", "Dengue virus DNA [Presence] in Serum by DNA probe", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("6387-5", "Dengue virus DNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGG_AB_TITER_IN_SERUM ("6811-4", "Dengue virus IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM ("23958-2", "Dengue virus IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("23991-3", "Dengue virus IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGG_AND_IGM_INTERPRETATION_IN_SERUM ("51785-4", "Dengue virus IgG and IgM [interpretation] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("34721-1", "Dengue virus IgM Ab [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGM_AB_PRESENCE_IN_SERUM ("25338-5", "Dengue virus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("29663-2", "Dengue virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("25392-2", "Dengue virus IgM Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGM_AB_TITER_IN_SERUM ("6812-2", "Dengue virus IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("23968-1", "Dengue virus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("23992-1", "Dengue virus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_TYPE_1 ("60588009", "Dengue virus, type 1", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_TYPE_2 ("41328007", "Dengue virus, type 2", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_TYPE_3 ("8467002", "Dengue virus, type 3", "18725-2", "none", "20130527", "N/A"),
	DENGUE_VIRUS_TYPE_4 ("36700002", "Dengue virus, type 4", "18725-2", "none", "20130527", "N/A"),
	DIPHTHERIA_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("14483-2", "Diphtheria identified in Bronchial specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	DIPHTHERIA_IDENTIFIED_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE ("6596-1", "Diphtheria identified in Isolate by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	DIPHTHERIA_IDENTIFIED_IN_NOSE_BY_ORGANISM_SPECIFIC_CULTURE ("14481-6", "Diphtheria identified in Nose by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	DIPHTHERIA_IDENTIFIED_IN_SKIN_BY_ORGANISM_SPECIFIC_CULTURE ("14482-4", "Diphtheria identified in Skin by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	DIPHTHERIA_IDENTIFIED_IN_SPUTUM_BY_ORGANISM_SPECIFIC_CULTURE ("14480-8", "Diphtheria identified in Sputum by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	DIPHTHERIA_IDENTIFIED_IN_THROAT_BY_ORGANISM_SPECIFIC_CULTURE ("14479-0", "Diphtheria identified in Throat by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	DIPHTHERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("567-8", "Diphtheria identified in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	DISPLAYNAME ("code value", "displayName", "specialtySection", "patientPrivacyFilter", "validFrom", "validTo"),
	DOXYCYCLINE_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25223-9", "Doxycycline 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	DOXYCYCLINE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20379-4", "Doxycycline [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	EBOLA_VIRUS_AB_TITER_IN_SERUM ("22263-8", "Ebola virus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7862-6", "Ebola virus Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_AB_UNITSVOLUME_IN_SERUM ("11581-6", "Ebola virus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("71768-6", "Ebola virus Ag [Presence] in Unspecified specimen by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("41637-0", "Ebola virus Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("71770-2", "Ebola virus IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("71767-8", "Ebola virus IgG Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("71712-4", "Ebola virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("71711-6", "Ebola virus IgM Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	EBOLA_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41636-2", "Ebola virus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	ERYTHROCYTES_PLASMODIUM_SP_INFECTED1000_ERYTHROCYTES_IN_BLOOD ("48427-9", "Erythrocytes.Plasmodium sp infected/1000 erythrocytes in Blood", "18725-2", "initials", "20130527", "N/A"),
	ERYTHROCYTES_PLASMODIUM_SP_INFECTED100_ERYTHROCYTES_IN_BLOOD ("53556-7", "Erythrocytes.Plasmodium sp infected/100 erythrocytes in Blood", "18725-2", "initials", "20130527", "N/A"),
	ERYTHROMYCIN_15_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25224-7", "Erythromycin 15 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ERYTHROMYCIN_ETHAMBUTOL_SUSCEPTIBILITY_BY_MINIMUM_INHIBITORY_CONCENTRATION_MIC ("16830-2", "Erythromycin+Ethambutol [Susceptibility] by Minimum inhibitory concentration (MIC)", "18769-0", "conditional", "20130527", "N/A"),
	ERYTHROMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20380-2", "Erythromycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ESCHERICHIA_COLI_SHIGA_LIKE_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE ("16835-1", "Escherichia coli shiga-like identified in Stool by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	ESCHERICHIA_COLI_SHIGA_LIKE_PRESENCE_IN_STOOL_BY_IMMUNOASSAY ("21262-1", "Escherichia coli shiga-like [Presence] in Stool by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	ESCHERICHIA_COLI_SHIGA_LIKE_TOXIN_1_AND_2_AG_IDENTIFIER_IN_STOOL_BY_IMMUNOASSAY ("64013-6", "Escherichia coli shiga-like toxin 1 and 2 Ag [Identifier] in Stool by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	ESCHERICHIA_COLI_SHIGA_LIKE_TOXIN_STX1_STX2_H7_FLAGELLAR_FLIC_GENES_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53947-8", "Escherichia coli shiga-like toxin (stx1+stx2)+H7 flagellar (fliC) genes [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	ESCHERICHIA_COLI_SHIGA_LIKE_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("28035-4", "Escherichia coli shiga-like [Units/volume] in Unspecified specimen by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	ESCHERICHIA_COLI_SHIGA_TOXIN_1_AG_PRESENCE_IN_STOOL_BY_IMMUNOASSAY ("51940-5", "Escherichia coli shiga toxin 1 Ag [Presence] in Stool by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	ESCHERICHIA_COLI_SHIGA_TOXIN_2_AG_PRESENCE_IN_STOOL_BY_IMMUNOASSAY ("51939-7", "Escherichia coli shiga toxin 2 Ag [Presence] in Stool by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	ESCHERICHIA_COLI_SHIGA_TOXIN_AG_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN ("53946-0", "Escherichia coli shiga toxin Ag [Identifier] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	ETHAMBUTOL_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25195-9", "Ethambutol 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHAMBUTOL_2_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25230-4", "Ethambutol 2.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHAMBUTOL_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("55674-6", "Ethambutol 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHAMBUTOL_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25194-2", "Ethambutol 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHAMBUTOL_7_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25187-6", "Ethambutol 7.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHAMBUTOL_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("56025-0", "Ethambutol 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHAMBUTOL_RIFAMPIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("55154-9", "Ethambutol+Rifampin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHAMBUTOL_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20381-0", "Ethambutol [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHIONAMIDE_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25231-2", "Ethionamide 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHIONAMIDE_11_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25183-5", "Ethionamide 11 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHIONAMIDE_15_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25198-3", "Ethionamide 15 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHIONAMIDE_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25196-7", "Ethionamide 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ETHIONAMIDE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20382-8", "Ethionamide [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB_TITER_IN_SERUM ("26061-2", "European tick borne encephalitis virus Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION ("26058-8", "European tick borne encephalitis virus Ab [Titer] in Serum by Complement fixation", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB_UNITSVOLUME_IN_SERUM ("31383-3", "European tick borne encephalitis virus Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_INDEX_UNITSVOLUME_IN_SERUM_AND_CSF_BY_IMMUNOASSAY ("69928-0", "European tick borne encephalitis virus IgG Ab index [Units/volume] in Serum and CSF by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("69927-2", "European tick borne encephalitis virus IgG Ab [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("69926-4", "European tick borne encephalitis virus IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM ("26062-0", "European tick borne encephalitis virus IgG Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("26059-6", "European tick borne encephalitis virus IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_INDEX_UNITSVOLUME_IN_SERUM_AND_CSF_BY_IMMUNOASSAY ("69925-6", "European tick borne encephalitis virus IgM Ab index [Units/volume] in Serum and CSF by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("69924-9", "European tick borne encephalitis virus IgM Ab [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("69923-1", "European tick borne encephalitis virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("26063-8", "European tick borne encephalitis virus IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("26060-4", "European tick borne encephalitis virus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	FLAVIVIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6406-3", "Flavivirus identified in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS ("51526001", "Francisella tularensis", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM ("16875-7", "Francisella tularensis Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_AGGLUTINATION ("23125-8", "Francisella tularensis Ab [Titer] in Serum by Agglutination", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION ("23741-2", "Francisella tularensis Ab [Titer] in Serum by Complement fixation", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION ("5167-2", "Francisella tularensis Ab [Titer] in Serum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_MICROAGGLUTINATION ("33683-4", "Francisella tularensis Ab [Titer] in Serum by Microagglutination", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_TUBE_AGGLUTINATION ("33684-2", "Francisella tularensis Ab [Titer] in Serum by Tube agglutination", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AB_UNITSVOLUME_IN_SERUM ("31396-5", "Francisella tularensis Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE ("33678-4", "Francisella tularensis Ag [Presence] in Isolate by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_SERUM ("31828-7", "Francisella tularensis Ag [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("16879-9", "Francisella tularensis Ag [Presence] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN ("23126-6", "Francisella tularensis Ag [Presence] in Tissue by Immune stain", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE ("23127-4", "Francisella tularensis Ag [Presence] in Tissue by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31829-5", "Francisella tularensis Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6408-9", "Francisella tularensis Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_SLIDE_AGGLUTINATION ("45041-1", "Francisella tularensis Ag [Presence] in Unspecified specimen by Slide agglutination", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_A_DNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("23122-5", "Francisella tularensis A DNA [Presence] in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_A_RRNA_PRESENCE_IN_TISSUE_BY_DNA_PROBE ("23123-3", "Francisella tularensis A rRNA [Presence] in Tissue by DNA probe", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_B_DNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("23128-2", "Francisella tularensis B DNA [Presence] in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_B_RRNA_PRESENCE_IN_TISSUE_BY_DNA_PROBE ("23129-0", "Francisella tularensis B rRNA [Presence] in Tissue by DNA probe", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_DNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("33680-0", "Francisella tularensis DNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_DNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("23130-8", "Francisella tularensis DNA [Presence] in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("33679-2", "Francisella tularensis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_IGA_AB_TITER_IN_SERUM ("33576-0", "Francisella tularensis IgA Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_IGG_AB_TITER_IN_SERUM ("33465-6", "Francisella tularensis IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_IGG_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA ("70121-9", "Francisella tularensis IgG Ab [Units/volume] in Serum or Plasma", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_IGM_AB_PRESENCE_IN_SERUM ("7890-7", "Francisella tularensis IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_IGM_AB_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION ("6407-1", "Francisella tularensis IgM Ab [Presence] in Serum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_IGM_AB_TITER_IN_SERUM ("33466-4", "Francisella tularensis IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_IGM_AB_UNITSVOLUME_IN_SERUM ("16878-1", "Francisella tularensis IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_PRESENCE_IN_ISOLATE_BY_CELL_WALL_FATTY_ACID_ANALYSIS ("33682-6", "Francisella tularensis [Presence] in Isolate by Cell wall fatty acid analysis", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_PRESENCE_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE ("33677-6", "Francisella tularensis [Presence] in Isolate by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_CELL_WALL_FATTY_ACID_ANALYSIS ("33681-8", "Francisella tularensis [Presence] in Unspecified specimen by Cell wall fatty acid analysis", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("33676-8", "Francisella tularensis [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_RRNA_PRESENCE_IN_TISSUE_BY_DNA_PROBE ("23131-6", "Francisella tularensis rRNA [Presence] in Tissue by DNA probe", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_SS_HOLARCTICA ("60502008", "Francisella tularensis ss. holarctica", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_SS_MEDIASIATICA ("23930001", "Francisella tularensis ss. mediasiatica", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_SS_TULARENSIS ("91508008", "Francisella tularensis ss. tularensis", "18725-2", "none", "20130527", "N/A"),
	FRANCISELLA_TULARENSIS_SUBTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("46732-4", "Francisella tularensis subtype [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	GATIFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("41494-6", "Gatifloxacin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	GENTAMICIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("50630-3", "Gentamicin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE ("44470000", "Haemophilus influenzae", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("32139-8", "Haemophilus influenzae Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_AG_PRESENCE_IN_URINE ("40771-8", "Haemophilus influenzae Ag [Presence] in Urine", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("16926-8", "Haemophilus influenzae A Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6610-0", "Haemophilus influenzae A Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31833-7", "Haemophilus influenzae A Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6414-7", "Haemophilus influenzae A Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_URINE ("16925-0", "Haemophilus influenzae A Ag [Presence] in Urine", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_A_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("29906-5", "Haemophilus influenzae A DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_BODY_FLUID ("41495-3", "Haemophilus influenzae B Ag [Presence] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("24010-1", "Haemophilus influenzae B Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6611-8", "Haemophilus influenzae B Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("14321-4", "Haemophilus influenzae B Ag [Presence] in Cerebral spinal fluid by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_SERUM ("43429-0", "Haemophilus influenzae B Ag [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31834-5", "Haemophilus influenzae B Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6599-5", "Haemophilus influenzae B Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("21320-7", "Haemophilus influenzae B Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_URINE ("15379-1", "Haemophilus influenzae B Ag [Presence] in Urine", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_AG_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("20486-7", "Haemophilus influenzae B Ag [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53607-8", "Haemophilus influenzae B DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_B_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("29907-3", "Haemophilus influenzae B DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31835-2", "Haemophilus influenzae C Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6612-6", "Haemophilus influenzae C Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31836-0", "Haemophilus influenzae C Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("8271-9", "Haemophilus influenzae C Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("61366-1", "Haemophilus influenzae DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_D_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31837-8", "Haemophilus influenzae D Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_D_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6613-4", "Haemophilus influenzae D Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_D_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31838-6", "Haemophilus influenzae D Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_D_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6416-2", "Haemophilus influenzae D Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_E_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31839-4", "Haemophilus influenzae E Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_E_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6614-2", "Haemophilus influenzae E Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_E_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31840-2", "Haemophilus influenzae E Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_E_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6417-0", "Haemophilus influenzae E Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_F_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31841-0", "Haemophilus influenzae F Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_F_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6615-9", "Haemophilus influenzae F Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_F_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31842-8", "Haemophilus influenzae F Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_F_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6418-8", "Haemophilus influenzae F Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("69410-9", "Haemophilus influenzae [Identifier] in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_NOT_B ("115407004", "Haemophilus influenzae, not B", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("5006-2", "Haemophilus influenzae rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_SEROGROUP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("58473-0", "Haemophilus influenzae serogroup DNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_SEROTYPE_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION ("58739-4", "Haemophilus influenzae serotype [Identifier] in Isolate by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_TYPE_A ("103441001", "Haemophilus influenzae type A", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_TYPE_B ("103442008", "Haemophilus influenzae type B", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_TYPE_C ("103443003", "Haemophilus influenzae type C", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_TYPE_D ("103444009", "Haemophilus influenzae type D", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_TYPE_E ("103445005", "Haemophilus influenzae type E", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_TYPE_F ("103446006", "Haemophilus influenzae type F", "18725-2", "initials", "20130527", "N/A"),
	HAEMOPHILUS_INFLUENZAE_TYPE_IDENTIFIER_IN_ISOLATE ("49721-4", "Haemophilus influenzae type [Identifier] in Isolate", "18725-2", "initials", "20130527", "N/A"),
	HANTAVIRUS_AB_TITER_IN_SERUM ("60264-9", "Hantavirus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_AB_UNITSVOLUME_IN_SERUM ("5046-8", "Hantavirus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN ("65762-7", "Hantavirus Ag [Presence] in Tissue by Immune stain", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_DOBROVA_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE ("70054-2", "Hantavirus dobrova IgM Ab [Presence] in Serum or Plasma by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_HANTAAN_AB_UNITSVOLUME_IN_SERUM ("13289-4", "Hantavirus hantaan Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_HANTAAN_IGG_AB_UNITSVOLUME_IN_SERUM ("7895-6", "Hantavirus hantaan IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_HANTAAN_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE ("70053-4", "Hantavirus hantaan IgM Ab [Presence] in Serum or Plasma by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_HANTAAN_IGM_AB_UNITSVOLUME_IN_SERUM ("7896-4", "Hantavirus hantaan IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_IGG_AB_UNITSVOLUME_IN_SERUM ("35392-0", "Hantavirus IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_IGM_AB_PRESENCE_IN_SERUM ("32131-5", "Hantavirus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("35393-8", "Hantavirus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_PUUMALA_IGG_AB_TITER_IN_SERUM ("22308-1", "Hantavirus puumala IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_PUUMALA_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("21322-3", "Hantavirus puumala IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_PUUMALA_IGG_AB_UNITSVOLUME_IN_SERUM ("7897-2", "Hantavirus puumala IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_PUUMALA_IGG_IGM_AB_UNITSVOLUME_IN_SERUM ("16928-4", "Hantavirus puumala IgG+IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_PUUMALA_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE ("70058-3", "Hantavirus puumala IgM Ab [Presence] in Serum or Plasma by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_PUUMALA_IGM_AB_TITER_IN_SERUM ("22309-9", "Hantavirus puumala IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_PUUMALA_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("21323-1", "Hantavirus puumala IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_PUUMALA_IGM_AB_UNITSVOLUME_IN_SERUM ("7898-0", "Hantavirus puumala IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("7899-8", "Hantavirus RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_SAAREMAA_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE ("70057-5", "Hantavirus saaremaa IgM Ab [Presence] in Serum or Plasma by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_SIN_NOMBRE_IGG_AB_TITER_IN_SERUM ("23867-5", "Hantavirus sin nombre IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_SIN_NOMBRE_IGG_AB_UNITSVOLUME_IN_SERUM ("31408-8", "Hantavirus sin nombre IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_SIN_NOMBRE_IGM_AB_PRESENCE_IN_SERUM ("26650-2", "Hantavirus sin nombre IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_SIN_NOMBRE_IGM_AB_TITER_IN_SERUM ("23868-3", "Hantavirus sin nombre IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	HANTAVIRUS_SIN_NOMBRE_IGM_AB_UNITSVOLUME_IN_SERUM ("31409-6", "Hantavirus sin nombre IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_A_VIRUS_IGM_AB_PRESENCE_IN_BODY_FLUID ("51660-9", "Hepatitis A virus IgM Ab [Presence] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_A_VIRUS_IGM_AB_PRESENCE_IN_SERUM ("22314-9", "Hepatitis A virus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_A_VIRUS_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY ("13950-1", "Hepatitis A virus IgM Ab [Presence] in Serum or Plasma by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("22315-6", "Hepatitis A virus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5181-3", "Hepatitis A virus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_RADIOIMMUNOASSAY_RIA ("5182-1", "Hepatitis A virus IgM Ab [Units/volume] in Serum by Radioimmunoassay (RIA)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_A_VIRUS_IGM_AND_TOTAL_INTERPRETATION_IN_SERUM ("53776-1", "Hepatitis A virus IgM and total [interpretation] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_A_VIRUS_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("7904-6", "Hepatitis A virus RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_BASAL_CORE_PROMOTER_MUTATION_IDENTIFIER_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("54210-0", "Hepatitis B virus basal core promoter mutation [Identifier] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_CORE_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN ("10673-2", "Hepatitis B virus core Ag [Presence] in Tissue by Immune stain", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_BODY_FLUID ("51658-3", "Hepatitis B virus core IgM Ab [Presence] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_SERUM ("31204-1", "Hepatitis B virus core IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY ("24113-3", "Hepatitis B virus core IgM Ab [Presence] in Serum or Plasma by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_CORE_IGM_AB_UNITSVOLUME_IN_SERUM ("22319-8", "Hepatitis B virus core IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_CORE_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5185-4", "Hepatitis B virus core IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_CORE_IGM_AB_UNITSVOLUME_IN_SERUM_BY_RADIOIMMUNOASSAY_RIA ("5186-2", "Hepatitis B virus core IgM Ab [Units/volume] in Serum by Radioimmunoassay (RIA)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49602-6", "Hepatitis B virus DNA [log units/volume] (viral load) in Bone marrow by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49601-8", "Hepatitis B virus DNA [log units/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48398-2", "Hepatitis B virus DNA [log units/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49606-7", "Hepatitis B virus DNA [log units/volume] (viral load) in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49600-0", "Hepatitis B virus DNA [log units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49359-3", "Hepatitis B virus DNA [Log #/volume] (viral load) in Bone marrow by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49367-6", "Hepatitis B virus DNA [Log #/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("40459-0", "Hepatitis B virus DNA [Log #/volume] (viral load) in Serum by Probe and signal amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("45161-7", "Hepatitis B virus DNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49361-9", "Hepatitis B virus DNA [Log #/volume] (viral load) in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49366-8", "Hepatitis B virus DNA [Log #/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_MASSVOLUME_IN_SERUM ("32686-8", "Hepatitis B virus DNA [Mass/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_MASSVOLUME_VIRAL_LOAD_IN_SERUM_BY_DNA_PROBE ("23869-1", "Hepatitis B virus DNA [Mass/volume] (viral load) in Serum by DNA probe", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_MASSVOLUME_VIRAL_LOAD_IN_SERUM_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("29900-8", "Hepatitis B virus DNA [Mass/volume] (viral load) in Serum by Probe and signal amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("5007-0", "Hepatitis B virus DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("29610-3", "Hepatitis B virus DNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("5008-8", "Hepatitis B virus DNA [Presence] in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("5009-6", "Hepatitis B virus DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_IN_SERUM ("11258-1", "Hepatitis B virus DNA [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49358-5", "Hepatitis B virus DNA [Units/volume] (viral load) in Bone marrow by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49357-7", "Hepatitis B virus DNA [Units/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("42595-9", "Hepatitis B virus DNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49368-4", "Hepatitis B virus DNA [Units/volume] (viral load) in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49360-1", "Hepatitis B virus DNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49364-3", "Hepatitis B virus DNA [#/volume] (viral load) in Bone marrow by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49363-5", "Hepatitis B virus DNA [#/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("20442-0", "Hepatitis B virus DNA [#/volume] (viral load) in Serum by Probe and signal amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("29615-2", "Hepatitis B virus DNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_200_COPIESML ("47216-7", "Hepatitis B virus DNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 200 copies/ml", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_500_COPIESML ("48650-6", "Hepatitis B virus DNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 500 copies/mL", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49365-0", "Hepatitis B virus DNA [#/volume] (viral load) in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49362-7", "Hepatitis B virus DNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM ("31844-4", "Hepatitis B virus e Ag [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("13954-3", "Hepatitis B virus e Ag [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM_BY_RADIOIMMUNOASSAY_RIA ("5192-0", "Hepatitis B virus e Ag [Presence] in Serum by Radioimmunoassay (RIA)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("39007-0", "Hepatitis B virus e Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_E_AG_TITER_IN_SERUM ("32178-6", "Hepatitis B virus e Ag [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_E_AG_UNITSVOLUME_IN_SERUM ("31845-1", "Hepatitis B virus e Ag [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_E_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5191-2", "Hepatitis B virus e Ag [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_GENOTYPE_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("32366-7", "Hepatitis B virus genotype [Identifier] in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_POLYMERASE_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("16934-2", "Hepatitis B virus polymerase DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_PRECORE_TAG_PRESENCE_IN_SERUM_QUALITATIVE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("33633-9", "Hepatitis B virus precore TAG [Presence] in Serum Qualitative by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("6421-2", "Hepatitis B virus rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_IN_SERUM_OR_PLASMA_BY_CONFIRMATORY_METHOD ("70154-0", "Hepatitis B virus surface Ag in Serum or Plasma by Confirmatory method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_BLOOD_FROM_DONOR_BY_NEUTRALIZATION_TEST ("50967-9", "Hepatitis B virus surface Ag [Presence] in Blood from donor by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_BODY_FLUID ("51659-1", "Hepatitis B virus surface Ag [Presence] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("42505-8", "Hepatitis B virus surface Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM ("5195-3", "Hepatitis B virus surface Ag [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_BY_RADIOIMMUNOASSAY_RIA ("5197-9", "Hepatitis B virus surface Ag [Presence] in Serum by Radioimmunoassay (RIA)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOASSAY ("47364-5", "Hepatitis B virus surface Ag [Presence] in Serum from donor by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_CONFIRMATORY_METHOD ("65633-0", "Hepatitis B virus surface Ag [Presence] in Serum or Plasma by Confirmatory method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY ("5196-1", "Hepatitis B virus surface Ag [Presence] in Serum or Plasma by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_NEUTRALIZATION_TEST ("7905-3", "Hepatitis B virus surface Ag [Presence] in Serum or Plasma by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN ("10674-0", "Hepatitis B virus surface Ag [Presence] in Tissue by Immune stain", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_TISSUE_QUALITATIVE_BY_ORCEIN_STAIN ("10675-7", "Hepatitis B virus surface Ag [Presence] in Tissue Qualitative by Orcein stain", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_UNITSVOLUME_IN_SERUM ("58452-4", "Hepatitis B virus surface Ag [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_SURFACE_AG_UNITSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY ("63557-3", "Hepatitis B virus surface Ag [Units/volume] in Serum or Plasma by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_S_POL_GENE_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("42322-8", "Hepatitis B virus S+pol gene [Identifier] in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_B_VIRUS_YMDD_PRESENCE_IN_SERUM_OR_PLASMA_QUALITATIVE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("43279-9", "Hepatitis B Virus YMDD [Presence] in Serum or Plasma Qualitative by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_100_3_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9608-1", "Hepatitis C virus 100-3 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_100_5_1_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("23870-9", "Hepatitis C virus 100+5-1-1 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_22_3_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9609-9", "Hepatitis C virus 22-3 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_5_1_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("11076-7", "Hepatitis C virus 5-1-1 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB ("24011-9", "Hepatitis C virus Ab band pattern [interpretation] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_IGG_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB ("34162-8", "Hepatitis C virus Ab.IgG band pattern [interpretation] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOBLOT_IB ("39008-8", "Hepatitis C virus Ab [Presence] in Body fluid by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("5199-5", "Hepatitis C virus Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOASSAY ("47365-2", "Hepatitis C virus Ab [Presence] in Serum from donor by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY ("13955-0", "Hepatitis C virus Ab [Presence] in Serum or Plasma by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_PLASMA_OR_BLOOD_QUALITATIVE_BY_RAPID_IMMUNOASSAY ("72376-7", "Hepatitis C virus Ab [Presence] in Serum, Plasma or Blood Qualitative by Rapid immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_SIGNALCUTOFF_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY ("48159-8", "Hepatitis C virus Ab Signal/Cutoff in Serum or Plasma by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5198-7", "Hepatitis C virus Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AG_PRESENCE_IN_BLOOD_OR_MARROW_FROM_DONOR ("49846-9", "Hepatitis C virus Ag [Presence] in Blood or Marrow from donor", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("54914-7", "Hepatitis C virus Ag [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_C100P_5_1_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("51649-2", "Hepatitis C virus c100p+5-1-1 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_C1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("56926-9", "Hepatitis C virus c1 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_C22P_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("44813-4", "Hepatitis C virus c22p Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_C2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("56927-7", "Hepatitis C virus c2 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_C33C_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9610-7", "Hepatitis C virus c33c Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_E2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("56928-5", "Hepatitis C virus E2 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48574-8", "Hepatitis C virus genotype [Identifier] in Blood by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("32286-7", "Hepatitis C virus genotype [Identifier] in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49607-5", "Hepatitis C virus genotype [Identifier] in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48575-5", "Hepatitis C virus genotype [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("40726-2", "Hepatitis C virus IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("33462-3", "Hepatitis C virus IgG Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("57006-9", "Hepatitis C virus IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("53376-0", "Hepatitis C virus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51824-1", "Hepatitis C virus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_NS3_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("56929-3", "Hepatitis C virus NS3 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_NS4_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("56930-1", "Hepatitis C virus NS4 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_NS5_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("23871-7", "Hepatitis C virus NS5 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49604-2", "Hepatitis C virus RNA [log units/volume] (viral load) in Bone marrow by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49603-4", "Hepatitis C virus RNA [log units/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("42617-1", "Hepatitis C virus RNA [log units/volume] (viral load) in Serum or Plasma by Probe and signal amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("38180-6", "Hepatitis C virus RNA [log units/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49608-3", "Hepatitis C virus RNA [log units/volume] (viral load) in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49605-9", "Hepatitis C virus RNA [log units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49374-2", "Hepatitis C virus RNA [Log #/volume] (viral load) in Bone marrow by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49373-4", "Hepatitis C virus RNA [Log #/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("42003-4", "Hepatitis C virus RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and signal amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("47252-2", "Hepatitis C virus RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49375-9", "Hepatitis C virus RNA [Log #/volume] (viral load) in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49372-6", "Hepatitis C virus RNA [Log #/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("5010-4", "Hepatitis C virus RNA [Presence] in Blood by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_BODY_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("51655-9", "Hepatitis C virus RNA [Presence] in Body fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("11259-9", "Hepatitis C virus RNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("5011-2", "Hepatitis C virus RNA [Presence] in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("48576-3", "Hepatitis C virus RNA [Presence] in Unspecified specimen by Probe and signal amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("5012-0", "Hepatitis C virus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49378-3", "Hepatitis C virus RNA [Units/volume] (viral load) in Bone marrow by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49377-5", "Hepatitis C virus RNA [Units/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("29609-5", "Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and signal amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("11011-4", "Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_500_IUML ("34703-9", "Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 500 IU/mL", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_50_IUML ("34704-7", "Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 50 iU/mL", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_5_IUML ("49758-6", "Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 5 iU/mL", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION ("10676-5", "Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe with amplification", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49379-1", "Hepatitis C virus RNA [Units/volume] (viral load) in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49376-7", "Hepatitis C virus RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49370-0", "Hepatitis C virus RNA [#/volume] (viral load) in Bone marrow by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49369-2", "Hepatitis C virus RNA [#/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("20571-6", "Hepatitis C virus RNA [#/volume] (viral load) in Serum or Plasma by Probe and signal amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("20416-4", "Hepatitis C virus RNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49371-8", "Hepatitis C virus RNA [#/volume] (viral load) in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49380-9", "Hepatitis C virus RNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	HIV_1_2_AB_HIV1_P24_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("56888-1", "HIV 1+2 Ab+HIV1 p24 Ag [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_HIV1_P24_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("58900-2", "HIV 1+2 Ab+HIV1 p24 Ag [Units/volume] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("32602-5", "HIV 1+2 Ab [Presence] in Cerebral spinal fluid", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_PRESENCE_IN_SERUM ("7918-6", "HIV 1+2 Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("44873-8", "HIV 1+2 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_PRESENCE_IN_SERUM_FROM_DONOR ("44533-8", "HIV 1+2 Ab [Presence] in Serum from donor", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY ("31201-7", "HIV 1+2 Ab [Presence] in Serum or Plasma by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("43010-8", "HIV 1+2 Ab [Presence] in Unspecified specimen", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("42600-7", "HIV 1+2 Ab [Presence] in Unspecified specimen by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_QUALITATIVE_BY_RAPID_IMMUNOASSAY ("49580-4", "HIV 1+2 Ab [Presence] in Unspecified specimen Qualitative by Rapid immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_UNITSVOLUME_IN_SERUM ("22357-8", "HIV 1+2 Ab [Units/volume] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5223-3", "HIV 1+2 Ab [Units/volume] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_IGG_AB_PRESENCE_IN_DRIED_BLOOD_SPOT ("54086-4", "HIV 1+2 IgG Ab [Presence] in Dried blood spot", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_IGG_AB_PRESENCE_IN_SERUM ("43009-0", "HIV 1+2 IgG Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("40733-8", "HIV 1+2 IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_IGM_AB_UNITSVOLUME_IN_SERUM ("43008-2", "HIV 1+2 IgM Ab [Units/volume] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_2_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("41290-8", "HIV 1+2 IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB ("13499-9", "HIV 1 Ab band pattern [interpretation] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_IGG_BAND_PATTERN_INTERPRETATION_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB ("28052-9", "HIV 1 Ab.IgG band pattern [interpretation] in Cerebral spinal fluid by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_BODY_FLUID ("29327-4", "HIV 1 Ab [Presence] in Body fluid", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOASSAY ("34591-8", "HIV 1 Ab [Presence] in Body fluid by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOBLOT_IB ("34592-6", "HIV 1 Ab [Presence] in Body fluid by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_CAPILLARY_BLOOD ("41145-4", "HIV 1 Ab [Presence] in Capillary blood", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_CAPILLARY_BLOOD_BY_IMMUNOASSAY ("33866-5", "HIV 1 Ab [Presence] in Capillary blood by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("16974-8", "HIV 1 Ab [Presence] in Cerebral spinal fluid", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB ("57974-8", "HIV 1 Ab [Presence] in Cerebral spinal fluid by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("42627-0", "HIV 1 Ab [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SALIVA_ORAL_FLUID ("41144-7", "HIV 1 Ab [Presence] in Saliva (oral fluid)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOASSAY ("35437-3", "HIV 1 Ab [Presence] in Saliva (oral fluid) by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35439-9", "HIV 1 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SERUM ("7917-8", "HIV 1 Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("29893-5", "HIV 1 Ab [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("5221-7", "HIV 1 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("14092-1", "HIV 1 Ab [Presence] in Serum by Immunofluorescence", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SERUM_FROM_DONOR ("21007-0", "HIV 1 Ab [Presence] in Serum from donor", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_SERUM_PLASMA_OR_BLOOD_QUALITATIVE_BY_RAPID_IMMUNOASSAY ("68961-2", "HIV 1 Ab [Presence] in Serum, Plasma or Blood Qualitative by Rapid immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("53379-4", "HIV 1 Ab [Presence] in Unspecified specimen", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_QUALITATIVE_BY_RAPID_IMMUNOASSAY ("49905-3", "HIV 1 Ab [Presence] in Unspecified specimen Qualitative by Rapid immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_PRESENCE_IN_URINE_BY_IMMUNOBLOT_IB ("32571-2", "HIV 1 Ab [Presence] in Urine by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_UNITSVOLUME_IN_SALIVA_ORAL_FLUID ("41143-9", "HIV 1 Ab [Units/volume] in Saliva (oral fluid)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_UNITSVOLUME_IN_SALIVA_ORAL_FLUID_BY_IMMUNOASSAY ("35438-1", "HIV 1 Ab [Units/volume] in Saliva (oral fluid) by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_UNITSVOLUME_IN_SERUM ("22356-0", "HIV 1 Ab [Units/volume] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5220-9", "HIV 1 Ab [Units/volume] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE ("43599-0", "HIV 1 Ab [Units/volume] in Serum by Immunofluorescence", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("16977-1", "HIV 1 Ag [Presence] in Cerebral spinal fluid", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AG_PRESENCE_IN_SERUM ("24012-7", "HIV 1 Ag [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("5222-5", "HIV 1 Ag [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AG_PRESENCE_IN_SERUM_FROM_DONOR ("44531-2", "HIV 1 Ag [Presence] in Serum from donor", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AG_UNITSVOLUME_IN_SERUM ("16976-3", "HIV 1 Ag [Units/volume] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AND_2_AB_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB ("43185-8", "HIV 1 and 2 Ab band pattern [interpretation] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AND_2_AB_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_RAPID_IMMUNOASSAY ("69668-2", "HIV 1 and 2 Ab [Identifier] in Serum or Plasma by Rapid immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_AND_2_AB_INTERPRETATION_IN_SERUM_NARRATIVE ("42768-2", "HIV 1 and 2 Ab [interpretation] in Serum Narrative", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("44871-2", "HIV 1 DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_DNA_PRESENCE_IN_BLOOD_BY_PROBE_WITH_AMPLIFICATION ("9837-6", "HIV 1 DNA [Presence] in Blood by Probe with amplification", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("30245-5", "HIV 1 DNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP105_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12893-4", "HIV 1 gp105 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP120_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35441-5", "HIV 1 gp120 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP120_AB_PRESENCE_IN_SERUM ("44532-0", "HIV 1 gp120 Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP120_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9661-0", "HIV 1 gp120 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP120_GP160_AB_PRESENCE_IN_SERUM ("43013-2", "HIV 1 gp120+gp160 Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP120_GP160_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("40439-2", "HIV 1 gp120+gp160 Ab [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP120_GP160_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("14126-7", "HIV 1 gp120+gp160 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP160_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35440-7", "HIV 1 gp160 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP160_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9660-2", "HIV 1 gp160 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP34_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12870-2", "HIV 1 gp34 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP40_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("35452-2", "HIV 1 gp40 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP41_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35446-4", "HIV 1 gp41 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP41_AB_PRESENCE_IN_SERUM ("43012-4", "HIV 1 gp41 Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP41_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("40438-4", "HIV 1 gp41 Ab [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP41_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9662-8", "HIV 1 gp41 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_GP41_GP43_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("19110-6", "HIV 1 gp41+gp43 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31430-2", "HIV 1 IgG Ab [Presence] in Cerebral spinal fluid", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB ("28004-0", "HIV 1 IgG Ab [Presence] in Cerebral spinal fluid by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_IGG_AB_PRESENCE_IN_SERUM ("16975-5", "HIV 1 IgG Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("40732-0", "HIV 1 IgG Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_INTERPRETATION_IN_SERUM_BY_IMMUNOASSAY ("44607-0", "HIV 1 [interpretation] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_INTERPRETATION_IN_SERUM_BY_IMMUNOASSAY_NARRATIVE ("49483-1", "HIV 1 [interpretation] in Serum by Immunoassay Narrative", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_O_2_AB_PRESENCE_IN_BODY_FLUID ("57975-5", "HIV 1+O+2 Ab [Presence] in Body fluid", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_O_2_AB_PRESENCE_IN_SERUM_OR_PLASMA ("48345-3", "HIV 1+O+2 Ab [Presence] in Serum or Plasma", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_O_2_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA ("48346-1", "HIV 1+O+2 Ab [Units/volume] in Serum or Plasma", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P15_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12872-8", "HIV 1 p15 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P15_P18_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("16132-3", "HIV 1 p15+p18 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P17_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35449-8", "HIV 1 p17 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P17_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9663-6", "HIV 1 p17 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P17_P18_AB_PRESENCE_IN_SERUM ("32842-7", "HIV 1 p17+p18 Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P17_P18_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("32827-8", "HIV 1 p17+p18 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P18_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35450-6", "HIV 1 p18 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P18_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12859-5", "HIV 1 p18 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P23_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12855-3", "HIV 1 p23 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35448-0", "HIV 1 p24 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AB_PRESENCE_IN_SERUM ("43011-6", "HIV 1 p24 Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("40437-6", "HIV 1 p24 Ab [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9664-4", "HIV 1 p24 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AB_TITER_IN_SERUM_BY_IMMUNOBLOT_IB ("21331-4", "HIV 1 p24 Ab [Titer] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AB_UNITSVOLUME_IN_SERUM ("16978-9", "HIV 1 p24 Ab [Units/volume] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_MASSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("42339-2", "HIV 1 p24 Ag [Mass/volume] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("49718-0", "HIV 1 p24 Ag [Presence] in Cerebral spinal fluid", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_PRESENCE_IN_SERUM ("9821-0", "HIV 1 p24 Ag [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("18396-2", "HIV 1 p24 Ag [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_PRESENCE_IN_SERUM_BY_NEUTRALIZATION_TEST ("33660-2", "HIV 1 p24 Ag [Presence] in Serum by Neutralization test", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOASSAY ("44872-0", "HIV 1 p24 Ag [Presence] in Serum from donor by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("16979-7", "HIV 1 p24 Ag [Units/volume] in Cerebral spinal fluid", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_UNITSVOLUME_IN_SERUM ("9665-1", "HIV 1 p24 Ag [Units/volume] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P24_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("53601-1", "HIV 1 p24 Ag [Units/volume] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P26_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12871-0", "HIV 1 p26 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P28_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12857-9", "HIV 1 p28 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P31_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35447-2", "HIV 1 p31 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P31_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9666-9", "HIV 1 p31 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P31_P32_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("35564-4", "HIV 1 p31+p32 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P32_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12858-7", "HIV 1 p32 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P40_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("35565-1", "HIV 1 p40 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P41_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("31072-2", "HIV 1 p41 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P41_AB_TITER_IN_SERUM_BY_IMMUNOBLOT_IB ("21332-2", "HIV 1 p41 Ab [Titer] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P51_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35445-6", "HIV 1 p51 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P51_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9667-7", "HIV 1 p51 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P53_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12876-9", "HIV 1 p53 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P55_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35444-9", "HIV 1 p55 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P55_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9668-5", "HIV 1 p55 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P58_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12895-9", "HIV 1 p58 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P64_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12875-1", "HIV 1 p64 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P65_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35443-1", "HIV 1 p65 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P65_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12856-1", "HIV 1 p65 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P65_P66_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("33508-3", "HIV 1 p65+p66 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P66_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB ("35442-3", "HIV 1 p66 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P66_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("9669-3", "HIV 1 p66 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_P68_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("12894-2", "HIV 1 p68 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_PROVIRAL_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48023-6", "HIV 1 proviral DNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_INTERPRETATION_IN_SERUM ("24013-5", "HIV 1 RNA [interpretation] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41497-9", "HIV 1 RNA [Log #/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("29539-4", "HIV 1 RNA [Log #/volume] (viral load) in Plasma by Probe and signal amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("29541-0", "HIV 1 RNA [Log #/volume] (viral load) in Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_0_5_LOG_COPIESML ("51780-5", "HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 0.5 log copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_1_7_LOG_COPIESML ("48510-2", "HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 1.7 log copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_2_6_LOG_COPIESML ("48552-4", "HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 2.6 log copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_DETECTION_LIMIT_equals_1_9_LOG_COPIESML ("41516-6", "HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe with amplification detection limit = 1.9 log copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_DETECTION_LIMIT_equals_2_6_LOG_COPIESML ("41514-1", "HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe with amplification detection limit = 2.6 log copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49890-7", "HIV 1 RNA [Log #/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("5017-9", "HIV 1 RNA [Presence] in Blood by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("42917-5", "HIV 1 RNA [Presence] in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("25835-0", "HIV 1 RNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_PRESENCE_IN_SERUM_OR_PLASMA_FROM_DONOR_BY_PROBE_WITH_AMPLIFICATION ("47359-5", "HIV 1 RNA [Presence] in Serum or Plasma from donor by Probe with amplification", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("5018-7", "HIV 1 RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("23876-6", "HIV 1 RNA [Units/volume] (viral load) in Plasma by Probe and signal amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("62469-2", "HIV 1 RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION ("10351-5", "HIV 1 RNA [Units/volume] (viral load) in Serum or Plasma by Probe with amplification", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_IN_SERUM ("21333-0", "HIV 1 RNA [#/volume] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41498-7", "HIV 1 RNA [#/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("59419-2", "HIV 1 RNA [#/volume] (viral load) in Plasma by Probe and signal amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_20_COPIESML ("70241-5", "HIV 1 RNA [#/volume] (viral load) in Plasma by Probe and target amplification method detection limit = 20 copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_DNA_PROBE ("21008-8", "HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by DNA probe", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("20447-9", "HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_400_COPIESML ("48551-6", "HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 400 copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_50_COPIESML ("48511-0", "HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 50 copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_DETECTION_LIMIT_equals_400_COPIESML ("41513-3", "HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe with amplification detection limit = 400 copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_DETECTION_LIMIT_equals_75_COPIESML ("41515-8", "HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe with amplification detection limit = 75 copies/mL", "18725-2", "hiv", "20130527", "N/A"),
	HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("25836-8", "HIV 1 RNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_AB_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB ("31073-0", "HIV 2 Ab band pattern [interpretation] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB ("47029-4", "HIV 2 Ab [Presence] in Cerebral spinal fluid by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_AB_PRESENCE_IN_SERUM ("7919-4", "HIV 2 Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("30361-0", "HIV 2 Ab [Presence] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("5225-8", "HIV 2 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_AB_SIGNALCUTOFF_IN_SERUM_BY_IMMUNOASSAY ("51786-2", "HIV 2 Ab Signal/Cutoff in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_AB_UNITSVOLUME_IN_SERUM ("22358-6", "HIV 2 Ab [Units/volume] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5224-1", "HIV 2 Ab [Units/volume] in Serum by Immunoassay", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("25841-8", "HIV 2 DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("25842-6", "HIV 2 DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_GP105_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("21334-8", "HIV 2 gp105 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_GP120_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("21335-5", "HIV 2 gp120 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_GP125_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("10901-7", "HIV 2 gp125 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_GP140_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("57976-3", "HIV 2 gp140 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_GP15_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("21336-3", "HIV 2 gp15 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_GP34_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("21337-1", "HIV 2 gp34 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_GP36_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("10902-5", "HIV 2 gp36 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_GP80_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("11078-3", "HIV 2 gp80 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_IGG_AB_PRESENCE_IN_SERUM ("33807-9", "HIV 2 IgG Ab [Presence] in Serum", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("33806-1", "HIV 2 IgG Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P15_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("62456-9", "HIV 2 p15 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P16_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("57977-1", "HIV 2 p16 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P26_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("11079-1", "HIV 2 p26 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P31_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("21338-9", "HIV 2 p31 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P31_P34_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("45212-8", "HIV 2 p31+p34 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P34_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("57978-9", "HIV 2 p34 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P41_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("13920-4", "HIV 2 p41 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P53_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("11080-9", "HIV 2 p53 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P55_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("21339-7", "HIV 2 p55 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P56_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("11081-7", "HIV 2 p56 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P58_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("21340-5", "HIV 2 p58 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_P68_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("11082-5", "HIV 2 p68 Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_PROVIRAL_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("34699-9", "HIV 2 proviral DNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("69353-1", "HIV 2 RNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_2_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("69354-9", "HIV 2 RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method", "18725-2", "hiv", "20130527", "N/A"),
	HIV_DNA_PRESENCE_IN_BLOOD_BY_PROBE_WITH_AMPLIFICATION ("9836-8", "HIV DNA [Presence] in Blood by Probe with amplification", "18725-2", "hiv", "20130527", "N/A"),
	HIV_IDENTIFIED_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE ("6429-5", "HIV identified in Blood by Organism specific culture", "18725-2", "hiv", "20130527", "N/A"),
	HIV_IDENTIFIED_IN_SEMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6430-3", "HIV identified in Semen by Organism specific culture", "18725-2", "hiv", "20130527", "N/A"),
	HIV_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6431-1", "HIV identified in Unspecified specimen by Organism specific culture", "18725-2", "hiv", "20130527", "N/A"),
	HUMAN_CORONAVIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN ("41454-0", "Human coronavirus identified in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	IMIPENEM_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23613-3", "Imipenem [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	INFLUENZA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("54240-7", "Influenza virus Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AB_PRESENCE_IN_SERUM_1ST_SPECIMEN ("47232-4", "Influenza virus A Ab [Presence] in Serum --1st specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AB_PRESENCE_IN_SERUM_2ND_SPECIMEN ("47233-2", "Influenza virus A Ab [Presence] in Serum --2nd specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AB_TITER_IN_SERUM_1ST_SPECIMEN ("24289-1", "Influenza virus A Ab [Titer] in Serum --1st specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AB_TITER_IN_SERUM_2ND_SPECIMEN ("24290-9", "Influenza virus A Ab [Titer] in Serum --2nd specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_1ST_SPECIMEN ("24215-6", "Influenza virus A Ab [Titer] in Serum by Complement fixation --1st specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_2ND_SPECIMEN ("24216-4", "Influenza virus A Ab [Titer] in Serum by Complement fixation --2nd specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_IDENTIFIER_IN_ISOLATE ("50697-2", "Influenza virus A Ag [Identifier] in Isolate", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN ("44562-7", "Influenza virus A Ag [Presence] in Bronchial specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_BY_IMMUNOFLUORESCENCE ("44559-3", "Influenza virus A Ag [Presence] in Bronchial specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE ("49529-1", "Influenza virus A Ag [Presence] in Isolate by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NASOPHARYNX ("43874-7", "Influenza virus A Ag [Presence] in Nasopharynx", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOASSAY ("46082-4", "Influenza virus A Ag [Presence] in Nasopharynx by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOFLUORESCENCE ("44558-5", "Influenza virus A Ag [Presence] in Nasopharynx by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NOSE ("44563-5", "Influenza virus A Ag [Presence] in Nose", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NOSE_BY_IMMUNOASSAY ("44564-3", "Influenza virus A Ag [Presence] in Nose by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NOSE_BY_IMMUNOFLUORESCENCE ("44560-1", "Influenza virus A Ag [Presence] in Nose by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_THROAT ("31858-4", "Influenza virus A Ag [Presence] in Throat", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_THROAT_BY_IMMUNOASSAY ("5860-2", "Influenza virus A Ag [Presence] in Throat by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE ("5861-0", "Influenza virus A Ag [Presence] in Throat by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_TRACHEA_BY_IMMUNOFLUORESCENCE ("44561-9", "Influenza virus A Ag [Presence] in Trachea by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31859-2", "Influenza virus A Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNE_DIFFUSION_ID ("22825-4", "Influenza virus A Ag [Presence] in Unspecified specimen by Immune diffusion (ID)", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("5862-8", "Influenza virus A Ag [Presence] in Unspecified specimen by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("5863-6", "Influenza virus A Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN ("44566-8", "Influenza virus A+B Ag [Presence] in Bronchial specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_NASOPHARYNX ("33535-6", "Influenza virus A+B Ag [Presence] in Nasopharynx", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_NOSE ("44567-6", "Influenza virus A+B Ag [Presence] in Nose", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_NOSE_QUALITATIVE_BY_RAPID_IMMUNOASSAY ("72367-6", "Influenza virus A+B Ag [Presence] in Nose Qualitative by Rapid immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_THROAT ("31860-0", "Influenza virus A+B Ag [Presence] in Throat", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_THROAT_BY_IMMUNOASSAY ("6435-2", "Influenza virus A+B Ag [Presence] in Throat by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE ("6436-0", "Influenza virus A+B Ag [Presence] in Throat by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("24015-0", "Influenza virus A+B Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("6437-8", "Influenza virus A+B Ag [Presence] in Unspecified specimen by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6438-6", "Influenza virus A+B Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_THROAT ("31861-8", "Influenza virus A+B+C Ag [Presence] in Throat", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_THROAT_BY_IMMUNOASSAY ("6439-4", "Influenza virus A+B+C Ag [Presence] in Throat by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE ("6440-2", "Influenza virus A+B+C Ag [Presence] in Throat by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31862-6", "Influenza virus A+B+C Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("6441-0", "Influenza virus A+B+C Ag [Presence] in Unspecified specimen by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6442-8", "Influenza virus A+B+C Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_BIOASSAY ("49012-8", "Influenza virus A+B identified in Unspecified specimen by Bioassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_RNA_IDENTIFIER_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49537-4", "Influenza virus A+B RNA [Identifier] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_RNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48509-4", "Influenza virus A+B RNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("62462-7", "Influenza virus A+B RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_CDNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("38381-0", "Influenza virus A cDNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H1_2009_PANDEMIC_AND_INFLUENZA_VIRUS_A_SWINE_ORIGIN_RNA_INTERPRETATION_IN_UNSPECIFIED_SPECIMEN_QUALITATIVE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60494-2", "Influenza virus A H1 2009 pandemic and Influenza virus A swine origin RNA [interpretation] in Unspecified specimen Qualitative by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H1_2009_PANDEMIC_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("55465-9", "Influenza virus A H1 2009 pandemic RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H1_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE ("50701-2", "Influenza virus A H1 Ag [Presence] in Isolate by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H1_H3_B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60538-6", "Influenza virus A H1+H3+B RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H1_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49520-0", "Influenza virus A H1 RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H1_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49521-8", "Influenza virus A H1 RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H2_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("57985-4", "Influenza virus A H2 RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H3_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE ("49522-6", "Influenza virus A H3 Ag [Presence] in Isolate by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H3_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49523-4", "Influenza virus A H3 RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H3_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49524-2", "Influenza virus A H3 RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H5A_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("68986-9", "Influenza virus A H5a RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H5B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("68987-7", "Influenza virus A H5b RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H5_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49526-7", "Influenza virus A H5 RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H5_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("38272-1", "Influenza virus A H5 RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H5_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("44264-0", "Influenza virus A H5 RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H6_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("38271-3", "Influenza virus A H6 RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H6_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("44265-7", "Influenza virus A H6 RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H7_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49527-5", "Influenza virus A H7 RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H7_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("38270-5", "Influenza virus A H7 RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H7_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("44266-5", "Influenza virus A H7 RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H9_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60530-3", "Influenza virus A H9 RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_H9_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49528-3", "Influenza virus A H9 RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_HEMAGGLUTININ_CDNA_IDENTIFIER_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("55133-3", "Influenza virus A hemagglutinin cDNA [Identifier] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_HEMAGGLUTININ_CDNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("39102-9", "Influenza virus A hemagglutinin cDNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_HEMAGGLUTININ_CDNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_SEQUENCING ("39025-2", "Influenza virus A hemagglutinin cDNA [Identifier] in Unspecified specimen by Sequencing", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_HEMAGGLUTININ_RNA_IDENTIFIER_IN_ISOLATE_BY_SEQUENCING ("72767-7", "Influenza virus A hemagglutinin RNA [Identifier] in Isolate by Sequencing", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_HEMAGGLUTININ_TYPE_RNA_IDENTIFIER_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("59424-2", "Influenza virus A hemagglutinin type RNA [Identifier] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_HEMAGGLUTININ_TYPE_RNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("59423-4", "Influenza virus A hemagglutinin type RNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_BIOASSAY ("22826-2", "Influenza virus A identified in Unspecified specimen by Bioassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGA_AB_MASSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("49074-8", "Influenza virus A IgA Ab [Mass/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGA_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("72266-0", "Influenza virus A IgA Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGM_AB_MASSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("49075-5", "Influenza virus A IgM Ab [Mass/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGM_AB_PRESENCE_IN_SERUM ("43838-2", "Influenza virus A IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGM_AB_TITER_IN_SERUM ("9533-1", "Influenza virus A IgM Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGM_AB_UNITSVOLUME_IN_SERUM ("31438-5", "Influenza virus A IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("47312-4", "Influenza virus A IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_1ST_SPECIMEN ("57326-1", "Influenza virus A IgM Ab [Units/volume] in Serum by Immunoassay --1st specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_2ND_SPECIMEN ("57327-9", "Influenza virus A IgM Ab [Units/volume] in Serum by Immunoassay --2nd specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_MATRIX_PROTEIN_RNA_IDENTIFIER_IN_ISOLATE_BY_SEQUENCING ("72201-7", "Influenza virus A matrix protein RNA [Identifier] in Isolate by Sequencing", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_N1_AB_PRESENCE_IN_SERUM ("41142-1", "Influenza virus A N1 Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_N1_AB_PRESENCE_IN_SERUM_BY_NEUTRALIZATION_TEST ("39311-6", "Influenza virus A N1 Ab [Presence] in Serum by Neutralization test", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_N1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("56024-3", "Influenza virus A N1 RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_NEURAMINIDASE_CDNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("39103-7", "Influenza virus A neuraminidase cDNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_NEURAMINIDASE_RNA_IDENTIFIER_IN_ISOLATE_BY_SEQUENCING ("72200-9", "Influenza virus A neuraminidase RNA [Identifier] in Isolate by Sequencing", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_NEURAMINIDASE_RNA_TYPE_IN_UNSPECIFIED_SPECIMEN_BY_SEQUENCING ("61101-2", "Influenza virus A neuraminidase RNA [Type] in Unspecified specimen by Sequencing", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("48310-7", "Influenza virus A [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49531-7", "Influenza virus A RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("34487-9", "Influenza virus A RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("44263-2", "Influenza virus A RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_RNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53250-7", "Influenza virus A RNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_SUBTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNE_DIFFUSION_ID ("22828-8", "Influenza virus A subtype [Identifier] in Unspecified specimen by Immune diffusion (ID)", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_SUBTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("22827-0", "Influenza virus A subtype [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_SWINE_ORIGIN_RNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("55463-4", "Influenza virus A swine origin RNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_A_SWINE_ORIGIN_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("55464-2", "Influenza virus A swine origin RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN ("44576-7", "Influenza virus B Ag [Presence] in Bronchial specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_BY_IMMUNOFLUORESCENCE ("44572-6", "Influenza virus B Ag [Presence] in Bronchial specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_ISOLATE ("54241-5", "Influenza virus B Ag [Presence] in Isolate", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE ("49534-1", "Influenza virus B Ag [Presence] in Isolate by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NASOPHARYNX ("43895-2", "Influenza virus B Ag [Presence] in Nasopharynx", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOASSAY ("46083-2", "Influenza virus B Ag [Presence] in Nasopharynx by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOFLUORESCENCE ("44571-8", "Influenza virus B Ag [Presence] in Nasopharynx by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NOSE ("44577-5", "Influenza virus B Ag [Presence] in Nose", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NOSE_BY_IMMUNOASSAY ("44575-9", "Influenza virus B Ag [Presence] in Nose by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NOSE_BY_IMMUNOFLUORESCENCE ("44573-4", "Influenza virus B Ag [Presence] in Nose by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_THROAT ("31863-4", "Influenza virus B Ag [Presence] in Throat", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_THROAT_BY_IMMUNOASSAY ("5864-4", "Influenza virus B Ag [Presence] in Throat by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE ("5865-1", "Influenza virus B Ag [Presence] in Throat by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_TRACHEA_BY_IMMUNOFLUORESCENCE ("44574-2", "Influenza virus B Ag [Presence] in Trachea by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31864-2", "Influenza virus B Ag [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("5866-9", "Influenza virus B Ag [Presence] in Unspecified specimen by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("5867-7", "Influenza virus B Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGA_AB_MASSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("49076-3", "Influenza virus B IgA Ab [Mass/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGA_AB_PRESENCE_IN_SERUM ("43852-3", "Influenza virus B IgA Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGA_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("72265-2", "Influenza virus B IgA Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGM_AB_MASSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("49078-9", "Influenza virus B IgM Ab [Mass/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGM_AB_PRESENCE_IN_SERUM ("43840-8", "Influenza virus B IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGM_AB_TITER_IN_SERUM ("9536-4", "Influenza virus B IgM Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGM_AB_UNITSVOLUME_IN_SERUM ("17016-7", "Influenza virus B IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("47315-7", "Influenza virus B IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_1ST_SPECIMEN ("57328-7", "Influenza virus B IgM Ab [Units/volume] in Serum by Immunoassay --1st specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_2ND_SPECIMEN ("57329-5", "Influenza virus B IgM Ab [Units/volume] in Serum by Immunoassay --2nd specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("38382-8", "Influenza virus B [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49535-8", "Influenza virus B RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("40982-1", "Influenza virus B RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_B_RNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53251-5", "Influenza virus B RNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_IDENTIFIED_IN_ISOLATE ("54242-3", "Influenza virus identified in Isolate", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_IDENTIFIED_IN_SPUTUM_BY_ORGANISM_SPECIFIC_CULTURE ("6601-9", "Influenza virus identified in Sputum by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_IDENTIFIED_IN_SPUTUM_TRACHEAL_ASPIRATE_BY_ORGANISM_SPECIFIC_CULTURE ("6602-7", "Influenza virus identified in Sputum tracheal aspirate by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_IDENTIFIED_IN_THROAT_BY_ORGANISM_SPECIFIC_CULTURE ("6603-5", "Influenza virus identified in Throat by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN ("54244-9", "Influenza virus identified in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6604-3", "Influenza virus identified in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_SHELL_VIAL_CULTURE ("49538-2", "Influenza virus identified in Unspecified specimen by Shell vial culture", "18725-2", "initials", "20130527", "N/A"),
	INFLUENZA_VIRUS_RNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("54243-1", "Influenza virus RNA [Identifier] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	ISONIAZID_0_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25217-1", "Isoniazid 0.1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ISONIAZID_0_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25218-9", "Isoniazid 0.2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ISONIAZID_0_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("29315-9", "Isoniazid 0.4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ISONIAZID_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("55685-2", "Isoniazid 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ISONIAZID_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25219-7", "Isoniazid 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ISONIAZID_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("45215-1", "Isoniazid 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ISONIAZID_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("42651-0", "Isoniazid 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	ISONIAZID_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20383-6", "Isoniazid [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	KANAMYCIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("49080-5", "Kanamycin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	KANAMYCIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25214-8", "Kanamycin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	KANAMYCIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25182-7", "Kanamycin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	KANAMYCIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25213-0", "Kanamycin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	KANAMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23609-1", "Kanamycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	LASSA_VIRUS_AG_PRESENCE_IN_SERUM ("31867-5", "Lassa virus Ag [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("7946-7", "Lassa virus Ag [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGG_AB_PRESENCE_IN_SERUM ("22377-6", "Lassa virus IgG Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("7942-6", "Lassa virus IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGG_AB_TITER_IN_SERUM ("22378-4", "Lassa virus IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("71710-8", "Lassa virus IgG Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7943-4", "Lassa virus IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM ("31452-6", "Lassa virus IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGM_AB_PRESENCE_IN_SERUM ("22379-2", "Lassa virus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("7944-2", "Lassa virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGM_AB_TITER_IN_SERUM ("22380-0", "Lassa virus IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("71709-0", "Lassa virus IgM Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7945-9", "Lassa virus IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LASSA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("31453-4", "Lassa virus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_BOZEMANII ("37835001", "Legionella bozemanii", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_LONGBEACHAE ("89605004", "Legionella longbeachae", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_LONGBEACHAE_1_2_AB_TITER_IN_SERUM ("32694-2", "Legionella longbeachae 1+2 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_LONGBEACHAE_1_IGM_AB_PRESENCE_IN_SERUM ("17054-8", "Legionella longbeachae 1 IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_LONGBEACHAE_2_IGM_AB_PRESENCE_IN_SERUM ("17056-3", "Legionella longbeachae 2 IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_LONGBEACHAE_SEROGROUP_1 ("115515003", "Legionella longbeachae, serogroup 1", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_LONGBEACHAE_SEROGROUP_2 ("115516002", "Legionella longbeachae, serogroup 2", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_MICDADEI_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("67563-7", "Legionella micdadei DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_NON_PNEUMOPHILA_AB_TITER_IN_SERUM ("46194-7", "Legionella non-pneumophila Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_NON_PNEUMOPHILA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("43193-2", "Legionella non-pneumophila Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA ("80897008", "Legionella pneumophila", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_10_IGG_AB_TITER_IN_SERUM ("47459-3", "Legionella pneumophila 10 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_10_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47082-3", "Legionella pneumophila 10 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_10_IGM_AB_TITER_IN_SERUM ("47460-1", "Legionella pneumophila 10 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_10_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47054-2", "Legionella pneumophila 10 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_11_IGG_AB_TITER_IN_SERUM ("47461-9", "Legionella pneumophila 11 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_11_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47055-9", "Legionella pneumophila 11 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_11_IGM_AB_TITER_IN_SERUM ("47462-7", "Legionella pneumophila 11 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_11_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47056-7", "Legionella pneumophila 11 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_12_IGG_AB_TITER_IN_SERUM ("47463-5", "Legionella pneumophila 12 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_12_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47057-5", "Legionella pneumophila 12 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_12_IGM_AB_TITER_IN_SERUM ("47464-3", "Legionella pneumophila 12 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_12_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47058-3", "Legionella pneumophila 12 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_13_IGG_AB_TITER_IN_SERUM ("47465-0", "Legionella pneumophila 13 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_13_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47059-1", "Legionella pneumophila 13 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_13_IGM_AB_TITER_IN_SERUM ("47466-8", "Legionella pneumophila 13 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_13_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47060-9", "Legionella pneumophila 13 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_14_IGG_AB_TITER_IN_SERUM ("47467-6", "Legionella pneumophila 14 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_14_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47061-7", "Legionella pneumophila 14 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_14_IGM_AB_TITER_IN_SERUM ("47468-4", "Legionella pneumophila 14 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_14_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47062-5", "Legionella pneumophila 14 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_2_3_4_5_6_AB_TITER_IN_SERUM ("32696-7", "Legionella pneumophila 1+2+3+4+5+6 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_2_3_4_5_6_IGG_AB_TITER_IN_SERUM ("53770-4", "Legionella pneumophila 1+2+3+4+5+6 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_2_3_4_5_6_IGM_AB_PRESENCE_IN_SERUM ("49914-5", "Legionella pneumophila 1+2+3+4+5+6 IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_2_3_4_5_6_IGM_AB_TITER_IN_SERUM ("53784-5", "Legionella pneumophila 1+2+3+4+5+6 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_3_4_5_6_8_IGM_AB_PRESENCE_IN_SERUM ("43853-1", "Legionella pneumophila 1+3+4+5+6+8 IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_AB_TITER_IN_SERUM ("17060-5", "Legionella pneumophila 1 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7948-3", "Legionella pneumophila 1 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_AB_UNITSVOLUME_IN_SERUM ("31454-2", "Legionella pneumophila 1 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_AG_PRESENCE_IN_URINE ("31868-3", "Legionella pneumophila 1 Ag [Presence] in Urine", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_AG_PRESENCE_IN_URINE_BY_IMMUNOASSAY ("41499-5", "Legionella pneumophila 1 Ag [Presence] in Urine by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_AG_PRESENCE_IN_URINE_BY_RADIOIMMUNOASSAY_RIA ("9543-0", "Legionella pneumophila 1 Ag [Presence] in Urine by Radioimmunoassay (RIA)", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGG_AB_TITER_IN_SERUM ("22381-8", "Legionella pneumophila 1 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9541-4", "Legionella pneumophila 1 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGG_AB_UNITSVOLUME_IN_SERUM ("31455-9", "Legionella pneumophila 1 IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("58799-8", "Legionella pneumophila 1 IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGM_AB_PRESENCE_IN_SERUM ("35395-3", "Legionella pneumophila 1 IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("43002-5", "Legionella pneumophila 1 IgM Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("31075-5", "Legionella pneumophila 1 IgM Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGM_AB_TITER_IN_SERUM ("22382-6", "Legionella pneumophila 1 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9542-2", "Legionella pneumophila 1 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_1_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("31456-7", "Legionella pneumophila 1 IgM Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_3_4_5_6_8_AB_TITER_IN_SERUM ("46195-4", "Legionella pneumophila 2+3+4+5+6+8 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_3_4_5_6_8_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("43192-4", "Legionella pneumophila 2+3+4+5+6+8 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_AB_TITER_IN_SERUM ("17062-1", "Legionella pneumophila 2 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7949-1", "Legionella pneumophila 2 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_AB_UNITSVOLUME_IN_SERUM ("31457-5", "Legionella pneumophila 2 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_IGG_AB_TITER_IN_SERUM ("22383-4", "Legionella pneumophila 2 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9544-8", "Legionella pneumophila 2 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_IGG_AB_UNITSVOLUME_IN_SERUM ("31458-3", "Legionella pneumophila 2 IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_IGM_AB_TITER_IN_SERUM ("22384-2", "Legionella pneumophila 2 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9545-5", "Legionella pneumophila 2 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_IGM_AB_UNITSVOLUME_IN_SERUM ("17063-9", "Legionella pneumophila 2 IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_2_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("58798-0", "Legionella pneumophila 2 IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_AB_TITER_IN_SERUM ("17064-7", "Legionella pneumophila 3 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7950-9", "Legionella pneumophila 3 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_AB_UNITSVOLUME_IN_SERUM ("31459-1", "Legionella pneumophila 3 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_IGG_AB_TITER_IN_SERUM ("22385-9", "Legionella pneumophila 3 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9546-3", "Legionella pneumophila 3 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_IGG_AB_UNITSVOLUME_IN_SERUM ("31460-9", "Legionella pneumophila 3 IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_IGM_AB_TITER_IN_SERUM ("22386-7", "Legionella pneumophila 3 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9547-1", "Legionella pneumophila 3 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_3_IGM_AB_UNITSVOLUME_IN_SERUM ("17065-4", "Legionella pneumophila 3 IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_AB_TITER_IN_SERUM ("17066-2", "Legionella pneumophila 4 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7951-7", "Legionella pneumophila 4 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_AB_UNITSVOLUME_IN_SERUM ("31461-7", "Legionella pneumophila 4 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_IGG_AB_TITER_IN_SERUM ("22387-5", "Legionella pneumophila 4 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9548-9", "Legionella pneumophila 4 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_IGG_AB_UNITSVOLUME_IN_SERUM ("31462-5", "Legionella pneumophila 4 IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_IGM_AB_TITER_IN_SERUM ("22388-3", "Legionella pneumophila 4 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9549-7", "Legionella pneumophila 4 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_4_IGM_AB_UNITSVOLUME_IN_SERUM ("17067-0", "Legionella pneumophila 4 IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_AB_TITER_IN_SERUM ("17068-8", "Legionella pneumophila 5 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7952-5", "Legionella pneumophila 5 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_AB_UNITSVOLUME_IN_SERUM ("31463-3", "Legionella pneumophila 5 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_IGG_AB_TITER_IN_SERUM ("22389-1", "Legionella pneumophila 5 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9550-5", "Legionella pneumophila 5 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_IGG_AB_UNITSVOLUME_IN_SERUM ("31464-1", "Legionella pneumophila 5 IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_IGM_AB_TITER_IN_SERUM ("22390-9", "Legionella pneumophila 5 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9551-3", "Legionella pneumophila 5 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_5_IGM_AB_UNITSVOLUME_IN_SERUM ("17069-6", "Legionella pneumophila 5 IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_AB_TITER_IN_SERUM ("17070-4", "Legionella pneumophila 6 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7953-3", "Legionella pneumophila 6 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_AB_UNITSVOLUME_IN_SERUM ("31465-8", "Legionella pneumophila 6 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_IGG_AB_TITER_IN_SERUM ("22391-7", "Legionella pneumophila 6 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9552-1", "Legionella pneumophila 6 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_IGG_AB_UNITSVOLUME_IN_SERUM ("31466-6", "Legionella pneumophila 6 IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_IGM_AB_TITER_IN_SERUM ("22392-5", "Legionella pneumophila 6 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("9553-9", "Legionella pneumophila 6 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_6_IGM_AB_UNITSVOLUME_IN_SERUM ("31467-4", "Legionella pneumophila 6 IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_7_8_9_10_11_12_13_14_AB_TITER_IN_SERUM ("54205-0", "Legionella pneumophila 7+8+9+10+11+12+13+14 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_7_AB_TITER_IN_SERUM ("22393-3", "Legionella pneumophila 7 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_7_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7954-1", "Legionella pneumophila 7 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_7_AB_UNITSVOLUME_IN_SERUM ("31468-2", "Legionella pneumophila 7 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_7_IGG_AB_TITER_IN_SERUM ("47469-2", "Legionella pneumophila 7 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_7_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47076-5", "Legionella pneumophila 7 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_7_IGM_AB_TITER_IN_SERUM ("47470-0", "Legionella pneumophila 7 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_7_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47077-3", "Legionella pneumophila 7 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_8_AB_TITER_IN_SERUM ("22394-1", "Legionella pneumophila 8 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_8_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7955-8", "Legionella pneumophila 8 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_8_AB_UNITSVOLUME_IN_SERUM ("31469-0", "Legionella pneumophila 8 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_8_IGG_AB_TITER_IN_SERUM ("47471-8", "Legionella pneumophila 8 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_8_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47078-1", "Legionella pneumophila 8 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_8_IGM_AB_TITER_IN_SERUM ("47472-6", "Legionella pneumophila 8 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_8_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47079-9", "Legionella pneumophila 8 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_9_AB_TITER_IN_SERUM ("22395-8", "Legionella pneumophila 9 Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_9_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("7956-6", "Legionella pneumophila 9 Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_9_AB_UNITSVOLUME_IN_SERUM ("31470-8", "Legionella pneumophila 9 Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_9_IGG_AB_TITER_IN_SERUM ("47473-4", "Legionella pneumophila 9 IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_9_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47080-7", "Legionella pneumophila 9 IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_9_IGM_AB_TITER_IN_SERUM ("47474-2", "Legionella pneumophila 9 IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_9_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("47081-5", "Legionella pneumophila 9 IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM ("22396-6", "Legionella pneumophila Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_1ST_SPECIMEN ("24277-6", "Legionella pneumophila Ab [Titer] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_2ND_SPECIMEN ("24278-4", "Legionella pneumophila Ab [Titer] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("5237-3", "Legionella pneumophila Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_1ST_SPECIMEN ("24203-2", "Legionella pneumophila Ab [Titer] in Serum by Immunofluorescence --1st specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_2ND_SPECIMEN ("24204-0", "Legionella pneumophila Ab [Titer] in Serum by Immunofluorescence --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AB_UNITSVOLUME_IN_SERUM ("31471-6", "Legionella pneumophila Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("30046-7", "Legionella pneumophila Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_SPUTUM ("31869-1", "Legionella pneumophila Ag [Presence] in Sputum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_SPUTUM_BY_IMMUNOFLUORESCENCE ("6445-1", "Legionella pneumophila Ag [Presence] in Sputum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_SPUTUM_BY_LATEX_AGGLUTINATION ("6446-9", "Legionella pneumophila Ag [Presence] in Sputum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("17057-1", "Legionella pneumophila Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("588-4", "Legionella pneumophila Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("6449-3", "Legionella pneumophila Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE ("31870-9", "Legionella pneumophila Ag [Presence] in Urine", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_BY_IMMUNOASSAY ("6447-7", "Legionella pneumophila Ag [Presence] in Urine by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_BY_IMMUNOFLUORESCENCE ("17059-7", "Legionella pneumophila Ag [Presence] in Urine by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_BY_LATEX_AGGLUTINATION ("17058-9", "Legionella pneumophila Ag [Presence] in Urine by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_BY_RADIOIMMUNOASSAY_RIA ("6448-5", "Legionella pneumophila Ag [Presence] in Urine by Radioimmunoassay (RIA)", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_ATYPICAL_AB_PRESENCE_IN_SERUM ("13254-8", "Legionella pneumophila atypical Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_ATYPICAL_AB_TITER_IN_SERUM ("32695-9", "Legionella pneumophila atypical Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_ATYPICAL_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("27966-1", "Legionella pneumophila atypical Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_ATYPICAL_AB_UNITSVOLUME_IN_SERUM ("31473-2", "Legionella pneumophila atypical Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_ATYPICAL_IGM_AB_PRESENCE_IN_SERUM ("18237-8", "Legionella pneumophila atypical IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21363-7", "Legionella pneumophila DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_1ST_SPECIMEN ("57675-1", "Legionella pneumophila IgG Ab [Presence] in Serum by Immunofluorescence --1st specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_2ND_SPECIMEN ("57676-9", "Legionella pneumophila IgG Ab [Presence] in Serum by Immunofluorescence --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGG_AB_TITER_IN_SERUM ("22397-4", "Legionella pneumophila IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("21362-9", "Legionella pneumophila IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_1ST_SPECIMEN ("57008-5", "Legionella pneumophila IgG Ab [Titer] in Serum by Immunofluorescence --1st specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_2ND_SPECIMEN ("56950-9", "Legionella pneumophila IgG Ab [Titer] in Serum by Immunofluorescence --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGG_AB_UNITSVOLUME_IN_SERUM ("30085-5", "Legionella pneumophila IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("29955-2", "Legionella pneumophila IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGM_AB_TITER_IN_SERUM ("22398-2", "Legionella pneumophila IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("16133-1", "Legionella pneumophila IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGM_AB_UNITSVOLUME_IN_SERUM ("31472-4", "Legionella pneumophila IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51814-2", "Legionella pneumophila IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_SEROGROUP_1 ("103463005", "Legionella pneumophila serogroup 1", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_SEROGROUP_4 ("103466002", "Legionella pneumophila serogroup 4", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_SEROGROUP_6 ("103468001", "Legionella pneumophila serogroup 6", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_PNEUMOPHILA_SS_PNEUMOPHILA ("103458006", "Legionella pneumophila ss. pneumophila", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AB_PRESENCE_IN_SERUM_1ST_SPECIMEN ("30143-2", "Legionella sp Ab [Presence] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AB_PRESENCE_IN_SERUM_2ND_SPECIMEN ("30144-0", "Legionella sp Ab [Presence] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("43001-7", "Legionella sp Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("42516-5", "Legionella sp Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AB_TITER_IN_SERUM ("22399-0", "Legionella sp Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AB_TITER_IN_SERUM_2ND_SPECIMEN ("51920-7", "Legionella sp Ab [Titer] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("6450-1", "Legionella sp Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AB_UNITSVOLUME_IN_SERUM ("7957-4", "Legionella sp Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_BY_IMMUNOFLUORESCENCE ("38460-2", "Legionella sp Ag [Presence] in Bronchial specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AG_PRESENCE_IN_PLEURAL_FLUID_BY_IMMUNOFLUORESCENCE ("38461-0", "Legionella sp Ag [Presence] in Pleural fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AG_PRESENCE_IN_SPUTUM_BY_IMMUNOFLUORESCENCE ("38462-8", "Legionella sp Ag [Presence] in Sputum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("26621-3", "Legionella sp Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("39541-8", "Legionella sp Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AG_PRESENCE_IN_URINE ("32781-7", "Legionella sp Ag [Presence] in Urine", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_AG_PRESENCE_IN_URINE_BY_IMMUNOFLUORESCENCE ("38463-6", "Legionella sp Ag [Presence] in Urine by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49616-6", "Legionella sp DNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("589-2", "Legionella sp identified in Bronchial specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IDENTIFIED_IN_PLEURAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE ("38393-5", "Legionella sp identified in Pleural fluid by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IDENTIFIED_IN_SPUTUM_BY_ORGANISM_SPECIFIC_CULTURE ("590-0", "Legionella sp identified in Sputum by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("593-4", "Legionella sp identified in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IDENTIFIED_IN_URINE_BY_ORGANISM_SPECIFIC_CULTURE ("38394-3", "Legionella sp identified in Urine by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION ("71377-6", "Legionella sp [Identifier] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IGM_AB_TITER_IN_SERUM ("39559-0", "Legionella sp IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("28612-0", "Legionella sp IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM ("31474-0", "Legionella sp IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	LEGIONELLA_SP_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("5020-3", "Legionella sp rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	LEVOFLOXACIN_1_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("48173-9", "Levofloxacin 1.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	LEVOFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("53716-7", "Levofloxacin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	LINEZOLID_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("41500-0", "Linezolid [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	LISTERIA ("23566007", "Listeria", "18725-2", "initials", "20130527", "N/A"),
	LISTERIA_MONOCYTOGENES ("36094007", "Listeria monocytogenes", "18725-2", "initials", "20130527", "N/A"),
	LISTERIA_MONOCYTOGENES_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("61369-5", "Listeria monocytogenes DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	LISTERIA_MONOCYTOGENES_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("5021-1", "Listeria monocytogenes rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	LISTERIA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6609-2", "Listeria sp identified in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	MARBURG_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("71708-2", "Marburg virus Ag [Presence] in Unspecified specimen by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MARBURG_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("71769-4", "Marburg virus IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MARBURG_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("71707-4", "Marburg virus IgG Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MARBURG_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("71771-0", "Marburg virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MARBURG_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("71706-6", "Marburg virus IgM Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MARBURG_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41638-8", "Marburg virus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("22498-0", "Measles virus Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_COMPLEMENT_FIXATION ("9565-3", "Measles virus Ab [Titer] in Cerebral spinal fluid by Complement fixation", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_TITER_IN_SERUM ("22499-8", "Measles virus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION ("5243-1", "Measles virus Ab [Titer] in Serum by Complement fixation", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION ("41501-8", "Measles virus Ab [Titer] in Serum by Hemagglutination inhibition", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("17553-9", "Measles virus Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_UNITSVOLUME_IN_SERUM ("7961-6", "Measles virus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_UNITSVOLUME_IN_SERUM_1ST_SPECIMEN ("17555-4", "Measles virus Ab [Units/volume] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_UNITSVOLUME_IN_SERUM_2ND_SPECIMEN ("17556-2", "Measles virus Ab [Units/volume] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5242-3", "Measles virus Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31875-8", "Measles virus Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("14534-2", "Measles virus Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_CERVIX ("31876-6", "Measles virus Ag [Presence] in Cervix", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_CERVIX_BY_IMMUNOFLUORESCENCE ("14540-9", "Measles virus Ag [Presence] in Cervix by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_EYE ("31877-4", "Measles virus Ag [Presence] in Eye", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_EYE_BY_IMMUNOFLUORESCENCE ("14537-5", "Measles virus Ag [Presence] in Eye by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE ("67806-0", "Measles virus Ag [Presence] in Isolate by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_NOSE ("31879-0", "Measles virus Ag [Presence] in Nose", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_NOSE_BY_IMMUNOFLUORESCENCE ("14538-3", "Measles virus Ag [Presence] in Nose by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_PENIS ("31880-8", "Measles virus Ag [Presence] in Penis", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_PENIS_BY_IMMUNOFLUORESCENCE ("14543-3", "Measles virus Ag [Presence] in Penis by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_SERUM_OR_PLASMA ("31881-6", "Measles virus Ag [Presence] in Serum or Plasma", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE ("13328-0", "Measles virus Ag [Presence] in Serum or Plasma by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_SKIN ("31882-4", "Measles virus Ag [Presence] in Skin", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_SKIN_BY_IMMUNOFLUORESCENCE ("14536-7", "Measles virus Ag [Presence] in Skin by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_SPUTUM ("31883-2", "Measles virus Ag [Presence] in Sputum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_SPUTUM_BY_IMMUNOFLUORESCENCE ("14539-1", "Measles virus Ag [Presence] in Sputum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_THROAT ("31884-0", "Measles virus Ag [Presence] in Throat", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE ("14535-9", "Measles virus Ag [Presence] in Throat by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31887-3", "Measles virus Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("12232-5", "Measles virus Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_URETHRA ("31886-5", "Measles virus Ag [Presence] in Urethra", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_URETHRA_BY_IMMUNOFLUORESCENCE ("14544-1", "Measles virus Ag [Presence] in Urethra by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_URINE_SEDIMENT ("31885-7", "Measles virus Ag [Presence] in Urine sediment", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_URINE_SEDIMENT_BY_IMMUNOFLUORESCENCE ("14542-5", "Measles virus Ag [Presence] in Urine sediment by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_VAGINAL_FLUID ("31878-2", "Measles virus Ag [Presence] in Vaginal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_AG_PRESENCE_IN_VAGINAL_FLUID_BY_IMMUNOFLUORESCENCE ("14541-7", "Measles virus Ag [Presence] in Vaginal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_GENOTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60422-3", "Measles virus genotype [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_RATIO_IN_SERUM_1ST_SPECIMEN2ND_SPECIMEN ("25299-9", "Measles virus IgG Ab [Ratio] in Serum --1st specimen/2nd specimen", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("22501-1", "Measles virus IgG Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("21500-4", "Measles virus IgG Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_TITER_IN_SERUM ("22502-9", "Measles virus IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("21501-2", "Measles virus IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_BODY_FLUID ("29242-5", "Measles virus IgG Ab [Units/volume] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("22500-3", "Measles virus IgG Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("9566-1", "Measles virus IgG Ab [Units/volume] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM ("7962-4", "Measles virus IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_1ST_SPECIMEN ("22503-7", "Measles virus IgG Ab [Units/volume] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_2ND_SPECIMEN ("22504-5", "Measles virus IgG Ab [Units/volume] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5244-9", "Measles virus IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_1ST_SPECIMEN ("14304-0", "Measles virus IgG Ab [Units/volume] in Serum by Immunoassay --1st specimen", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_2ND_SPECIMEN ("14305-7", "Measles virus IgG Ab [Units/volume] in Serum by Immunoassay --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AND_IGM_INTERPRETATION_IN_CEREBRAL_SPINAL_FLUID ("44011-5", "Measles virus IgG and IgM [interpretation] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGG_AND_IGM_INTERPRETATION_IN_SERUM ("44012-3", "Measles virus IgG and IgM [interpretation] in Serum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOASSAY ("53537-7", "Measles virus IgM Ab [Presence] in Body fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_PRESENCE_IN_SERUM ("21503-8", "Measles virus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("35276-5", "Measles virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("22505-2", "Measles virus IgM Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("21502-0", "Measles virus IgM Ab [Titer] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_TITER_IN_SERUM ("22506-0", "Measles virus IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("5245-6", "Measles virus IgM Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("13283-7", "Measles virus IgM Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("40649-6", "Measles virus IgM Ab [Units/volume] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("7963-2", "Measles virus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("25421-9", "Measles virus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_RNA_PRESENCE_IN_NOSE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("7964-0", "Measles virus RNA [Presence] in Nose by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MEASLES_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48508-6", "Measles virus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_ANAL_BY_GRAM_STAIN ("72408-8", "Microscopic observation [Identifier] in Anal by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_ASPIRATE_BY_GRAM_STAIN ("14358-6", "Microscopic observation [Identifier] in Aspirate by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_ASPIRATE_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("55222-4", "Microscopic observation [Identifier] in Aspirate by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_ACID_FAST_STAIN ("32699-1", "Microscopic observation [Identifier] in Blood by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_BRILLIANT_CRESYL_BLUE ("29776-2", "Microscopic observation [Identifier] in Blood by Brilliant cresyl blue", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_MALARIA_SMEAR ("32700-7", "Microscopic observation [Identifier] in Blood by Malaria smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_MALARIA_THICK_SMEAR ("637-9", "Microscopic observation [Identifier] in Blood by Malaria thick smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_MALARIA_THIN_SMEAR ("33271-8", "Microscopic observation [Identifier] in Blood by Malaria thin smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_OR_MARROW_BY_PERIODIC_ACID_SCHIFF_STAIN ("9786-5", "Microscopic observation [Identifier] in Blood or Marrow by Periodic acid-Schiff stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_ACID_FAST_STAIN ("32189-3", "Microscopic observation [Identifier] in Body fluid by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("58944-0", "Microscopic observation [Identifier] in Body fluid by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_CRYSTAL_VIOLET_STAIN ("48722-3", "Microscopic observation [Identifier] in Body fluid by Crystal violet stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_GRAM_STAIN ("27112-2", "Microscopic observation [Identifier] in Body fluid by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_KOH_PREPARATION ("68383-9", "Microscopic observation [Identifier] in Body fluid by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53912-2", "Microscopic observation [Identifier] in Body fluid by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_WET_PREPARATION ("23901-2", "Microscopic observation [Identifier] in Body fluid by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BONE_MARROW_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53918-9", "Microscopic observation [Identifier] in Bone marrow by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BONE_MARROW_BY_WRIGHT_GIEMSA_STAIN ("10355-6", "Microscopic observation [Identifier] in Bone marrow by Wright Giemsa stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BRONCHIAL_SPECIMEN_BY_ACID_FAST_STAIN ("24002-8", "Microscopic observation [Identifier] in Bronchial specimen by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BRONCHIAL_SPECIMEN_BY_GRAM_STAIN ("21021-1", "Microscopic observation [Identifier] in Bronchial specimen by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BRONCHIAL_SPECIMEN_BY_IRON_HEMATOXYLIN_STAIN ("32811-2", "Microscopic observation [Identifier] in Bronchial specimen by Iron hematoxylin stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BRONCHIAL_SPECIMEN_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53522-9", "Microscopic observation [Identifier] in Bronchial specimen by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID ("32190-1", "Microscopic observation [Identifier] in Cerebral spinal fluid", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_ACID_FAST_STAIN ("32188-5", "Microscopic observation [Identifier] in Cerebral spinal fluid by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("58943-2", "Microscopic observation [Identifier] in Cerebral spinal fluid by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_ACRIDINE_ORANGE_STAIN ("59474-7", "Microscopic observation [Identifier] in Cerebral spinal fluid by Acridine orange stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_GRAM_STAIN ("14357-8", "Microscopic observation [Identifier] in Cerebral spinal fluid by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_INDIA_INK_PREP ("638-7", "Microscopic observation [Identifier] in Cerebral spinal fluid by India ink prep", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53906-4", "Microscopic observation [Identifier] in Cerebral spinal fluid by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CERVIX_BY_GRAM_STAIN ("6464-2", "Microscopic observation [Identifier] in Cervix by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CERVIX_BY_KOH_PREPARATION ("14355-2", "Microscopic observation [Identifier] in Cervix by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CERVIX_BY_OTHER_STAIN ("18326-9", "Microscopic observation [Identifier] in Cervix by Other stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CERVIX_BY_WET_PREPARATION ("14318-0", "Microscopic observation [Identifier] in Cervix by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_DIALYSIS_FLUID_BY_GRAM_STAIN ("21022-9", "Microscopic observation [Identifier] in Dialysis fluid by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_DUODENAL_FLUID_BY_OTHER_STAIN ("18327-7", "Microscopic observation [Identifier] in Duodenal fluid by Other stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_DUODENAL_FLUID_BY_TRICHROME_STAIN ("6465-9", "Microscopic observation [Identifier] in Duodenal fluid by Trichrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_DUODENAL_FLUID_BY_WET_PREPARATION ("6466-7", "Microscopic observation [Identifier] in Duodenal fluid by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_EAR_BY_GRAM_STAIN ("14365-1", "Microscopic observation [Identifier] in Ear by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_ENDOMETRIUM_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53914-8", "Microscopic observation [Identifier] in Endometrium by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_EYE_BY_GRAM_STAIN ("14364-4", "Microscopic observation [Identifier] in Eye by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_ACID_FAST_STAIN ("11476-9", "Microscopic observation [Identifier] in Gastric fluid by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_ACID_FAST_STAIN_KINYOUN ("640-3", "Microscopic observation [Identifier] in Gastric fluid by Acid fast stain.Kinyoun", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED ("641-1", "Microscopic observation [Identifier] in Gastric fluid by Acid fast stain.Kinyoun modified", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("642-9", "Microscopic observation [Identifier] in Gastric fluid by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_DARK_FIELD_EXAMINATION ("20885-0", "Microscopic observation [Identifier] in Gastric fluid by Dark field examination", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53916-3", "Microscopic observation [Identifier] in Gastric fluid by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GENITAL_FLUID_BY_GRAM_STAIN ("6467-5", "Microscopic observation [Identifier] in Genital fluid by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GENITAL_MUCUS_BY_GRAM_STAIN ("10856-3", "Microscopic observation [Identifier] in Genital mucus by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GENITAL_SPECIMEN_BY_GRAM_STAIN ("48712-4", "Microscopic observation [Identifier] in Genital specimen by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GENITAL_SPECIMEN_BY_WET_PREPARATION ("14317-2", "Microscopic observation [Identifier] in Genital specimen by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_HAIR_BY_KOH_PREPARATION ("10688-0", "Microscopic observation [Identifier] in Hair by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_NAIL_BY_KOH_PREPARATION ("10689-8", "Microscopic observation [Identifier] in Nail by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_NOSE_BY_GRAM_STAIN ("32026-7", "Microscopic observation [Identifier] in Nose by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PENIS_BY_TZANCK_SMEAR ("32186-9", "Microscopic observation [Identifier] in Penis by Tzanck smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PERICARDIAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53915-5", "Microscopic observation [Identifier] in Pericardial fluid by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PERITONEAL_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("58945-7", "Microscopic observation [Identifier] in Peritoneal fluid by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PERITONEAL_FLUID_BY_GRAM_STAIN ("14359-4", "Microscopic observation [Identifier] in Peritoneal fluid by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PERITONEAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53910-6", "Microscopic observation [Identifier] in Peritoneal fluid by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PLEURAL_FLUID_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED ("14353-7", "Microscopic observation [Identifier] in Pleural fluid by Acid fast stain.Kinyoun modified", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PLEURAL_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("58942-4", "Microscopic observation [Identifier] in Pleural fluid by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PLEURAL_FLUID_BY_GRAM_STAIN ("14360-2", "Microscopic observation [Identifier] in Pleural fluid by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PLEURAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53907-2", "Microscopic observation [Identifier] in Pleural fluid by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PUS_BY_GRAM_STAIN ("643-7", "Microscopic observation [Identifier] in Pus by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SKIN_BY_KOH_PREPARATION ("644-5", "Microscopic observation [Identifier] in Skin by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SKIN_BY_TZANCK_SMEAR ("32187-7", "Microscopic observation [Identifier] in Skin by Tzanck smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_ACID_FAST_STAIN ("11477-7", "Microscopic observation [Identifier] in Sputum by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_ACID_FAST_STAIN_KINYOUN ("645-2", "Microscopic observation [Identifier] in Sputum by Acid fast stain.Kinyoun", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED ("646-0", "Microscopic observation [Identifier] in Sputum by Acid fast stain.Kinyoun modified", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("647-8", "Microscopic observation [Identifier] in Sputum by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_CALCOFLUOR_WHITE ("6468-3", "Microscopic observation [Identifier] in Sputum by Calcofluor white", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_GRAM_STAIN ("648-6", "Microscopic observation [Identifier] in Sputum by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_KOH_PREPARATION ("17281-7", "Microscopic observation [Identifier] in Sputum by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53904-9", "Microscopic observation [Identifier] in Sputum by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_ACID_FAST_STAIN ("11478-5", "Microscopic observation [Identifier] in Stool by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_DARK_FIELD_EXAMINATION ("20884-3", "Microscopic observation [Identifier] in Stool by Dark field examination", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_ELECTRON_MICROSCOPY ("8250-3", "Microscopic observation [Identifier] in Stool by Electron microscopy", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_ELECTRON_MICROSCOPY_NEGATIVE_STAIN ("20882-7", "Microscopic observation [Identifier] in Stool by Electron microscopy negative stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_GRAM_STAIN ("649-4", "Microscopic observation [Identifier] in Stool by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_TRICHROME_STAIN ("6469-1", "Microscopic observation [Identifier] in Stool by Trichrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_WET_PREPARATION ("6470-9", "Microscopic observation [Identifier] in Stool by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SYNOVIAL_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("63433-7", "Microscopic observation [Identifier] in Synovial fluid by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SYNOVIAL_FLUID_BY_GRAM_STAIN ("14363-6", "Microscopic observation [Identifier] in Synovial fluid by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SYNOVIAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53913-0", "Microscopic observation [Identifier] in Synovial fluid by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_THROAT_BY_GRAM_STAIN ("14362-8", "Microscopic observation [Identifier] in Throat by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACID_FAST_STAIN ("11479-3", "Microscopic observation [Identifier] in Tissue by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACID_FAST_STAIN_KINYOUN ("6655-5", "Microscopic observation [Identifier] in Tissue by Acid fast stain.Kinyoun", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED ("6656-3", "Microscopic observation [Identifier] in Tissue by Acid fast stain.Kinyoun modified", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("6657-1", "Microscopic observation [Identifier] in Tissue by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACRIDINE_ORANGE_STAIN ("6658-9", "Microscopic observation [Identifier] in Tissue by Acridine orange stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_BIOPSY_CULTURE ("19129-6", "Microscopic observation [Identifier] in Tissue by Biopsy culture", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_CALCOFLUOR_WHITE ("6472-5", "Microscopic observation [Identifier] in Tissue by Calcofluor white", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_CARBOL_FUCHSIN_STAIN ("6659-7", "Microscopic observation [Identifier] in Tissue by Carbol-fuchsin stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_DARK_FIELD_EXAMINATION ("6607-6", "Microscopic observation [Identifier] in Tissue by Dark field examination", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_DRY_MOUNT ("6661-3", "Microscopic observation [Identifier] in Tissue by Dry mount", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ELECTRON_MICROSCOPY_THIN_SECTIION ("20881-9", "Microscopic observation [Identifier] in Tissue by Electron microscopy thin sectiion", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_GIEMSA_STAIN ("6662-1", "Microscopic observation [Identifier] in Tissue by Giemsa stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_GIMENEZ_STAIN ("6663-9", "Microscopic observation [Identifier] in Tissue by Gimenez stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_GRAM_STAIN ("6664-7", "Microscopic observation [Identifier] in Tissue by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_HEMATOXYLIN_AND_EOSIN_STAIN ("6665-4", "Microscopic observation [Identifier] in Tissue by Hematoxylin and eosin stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_INDIA_INK_PREP ("6666-2", "Microscopic observation [Identifier] in Tissue by India ink prep", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_KOH_PREPARATION ("6667-0", "Microscopic observation [Identifier] in Tissue by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_MACCHIAVELLO_STAIN ("6669-6", "Microscopic observation [Identifier] in Tissue by Macchiavello stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_MALARIA_SMEAR ("6670-4", "Microscopic observation [Identifier] in Tissue by Malaria smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_MALARIA_THICK_SMEAR ("17280-9", "Microscopic observation [Identifier] in Tissue by Malaria thick smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_METHENAMINE_SILVER_NITRATE_STAIN ("6671-2", "Microscopic observation [Identifier] in Tissue by Methenamine silver nitrate stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_METHYLENE_BLUE_STAIN_LOEFFLER ("6672-0", "Microscopic observation [Identifier] in Tissue by Methylene blue stain.Loeffler", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_MFADYEAN_STAIN ("6668-8", "Microscopic observation [Identifier] in Tissue by MFadyean stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_NEISSER_STAIN ("6673-8", "Microscopic observation [Identifier] in Tissue by Neisser stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_NIGHT_BLUE_STAIN ("10637-7", "Microscopic observation [Identifier] in Tissue by Night blue stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_OTHER_STAIN ("6471-7", "Microscopic observation [Identifier] in Tissue by Other stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_PERIODIC_ACID_SCHIFF_STAIN ("6675-3", "Microscopic observation [Identifier] in Tissue by Periodic acid-Schiff stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("6677-9", "Microscopic observation [Identifier] in Tissue by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_TRICHROME_STAIN ("6473-3", "Microscopic observation [Identifier] in Tissue by Trichrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_WARTHIN_STARRY_STAIN ("6679-5", "Microscopic observation [Identifier] in Tissue by Warthin-Starry stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_WET_PREPARATION ("6680-3", "Microscopic observation [Identifier] in Tissue by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_WRIGHT_STAIN ("6681-1", "Microscopic observation [Identifier] in Tissue by Wright stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACID_FAST_STAIN ("11545-1", "Microscopic observation [Identifier] in Unspecified specimen by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACID_FAST_STAIN_KINYOUN ("654-4", "Microscopic observation [Identifier] in Unspecified specimen by Acid fast stain.Kinyoun", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED ("655-1", "Microscopic observation [Identifier] in Unspecified specimen by Acid fast stain.Kinyoun modified", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("656-9", "Microscopic observation [Identifier] in Unspecified specimen by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACRIDINE_ORANGE_STAIN ("657-7", "Microscopic observation [Identifier] in Unspecified specimen by Acridine orange stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_CALCOFLUOR_WHITE ("658-5", "Microscopic observation [Identifier] in Unspecified specimen by Calcofluor white", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_CARBOL_FUCHSIN_STAIN ("659-3", "Microscopic observation [Identifier] in Unspecified specimen by Carbol-fuchsin stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_DARK_FIELD_EXAMINATION ("660-1", "Microscopic observation [Identifier] in Unspecified specimen by Dark field examination", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_DRY_MOUNT ("661-9", "Microscopic observation [Identifier] in Unspecified specimen by Dry mount", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ELECTRON_MICROSCOPY ("34166-9", "Microscopic observation [Identifier] in Unspecified specimen by Electron microscopy", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_GIEMSA_STAIN ("662-7", "Microscopic observation [Identifier] in Unspecified specimen by Giemsa stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_GIMENEZ_STAIN ("663-5", "Microscopic observation [Identifier] in Unspecified specimen by Gimenez stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_GRAM_STAIN ("664-3", "Microscopic observation [Identifier] in Unspecified specimen by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_HEMATOXYLIN_AND_EOSIN_STAIN ("665-0", "Microscopic observation [Identifier] in Unspecified specimen by Hematoxylin and eosin stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("35347-4", "Microscopic observation [Identifier] in Unspecified specimen by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_INDIA_INK_PREP ("666-8", "Microscopic observation [Identifier] in Unspecified specimen by India ink prep", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IRON_HEMATOXYLIN_STAIN ("14841-1", "Microscopic observation [Identifier] in Unspecified specimen by Iron hematoxylin stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_KINYOUN_IRON_HEMATOXYLIN_STAIN ("14842-9", "Microscopic observation [Identifier] in Unspecified specimen by Kinyoun iron hematoxylin stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_KOH_PREPARATION ("667-6", "Microscopic observation [Identifier] in Unspecified specimen by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_LACTOPHENOL_BLUE ("51700-3", "Microscopic observation [Identifier] in Unspecified specimen by Lactophenol blue", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_MACCHIAVELLO_STAIN ("669-2", "Microscopic observation [Identifier] in Unspecified specimen by Macchiavello stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_MALACHITE_GREEN_STAIN ("33699-0", "Microscopic observation [Identifier] in Unspecified specimen by Malachite green stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_METHENAMINE_SILVER_NITRATE_STAIN ("670-0", "Microscopic observation [Identifier] in Unspecified specimen by Methenamine silver nitrate stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_METHYLENE_BLUE_STAIN_LOEFFLER ("671-8", "Microscopic observation [Identifier] in Unspecified specimen by Methylene blue stain.Loeffler", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_MFADYEAN_STAIN ("668-4", "Microscopic observation [Identifier] in Unspecified specimen by MFadyean stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_NEISSER_STAIN ("672-6", "Microscopic observation [Identifier] in Unspecified specimen by Neisser stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_OTHER_STAIN ("11546-9", "Microscopic observation [Identifier] in Unspecified specimen by Other stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PERIODIC_ACID_SCHIFF_STAIN ("674-2", "Microscopic observation [Identifier] in Unspecified specimen by Periodic acid-Schiff stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("676-7", "Microscopic observation [Identifier] in Unspecified specimen by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_SMEAR ("20431-3", "Microscopic observation [Identifier] in Unspecified specimen by Smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_TOLUIDINE_BLUE_O_STAIN ("677-5", "Microscopic observation [Identifier] in Unspecified specimen by Toluidine blue O stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_TRICHROME_STAIN ("678-3", "Microscopic observation [Identifier] in Unspecified specimen by Trichrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_TZANCK_SMEAR ("45043-7", "Microscopic observation [Identifier] in Unspecified specimen by Tzanck smear", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WARTHIN_STARRY_STAIN ("679-1", "Microscopic observation [Identifier] in Unspecified specimen by Warthin-Starry stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WAYSON_STAIN ("44098-2", "Microscopic observation [Identifier] in Unspecified specimen by Wayson stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WET_PREPARATION ("680-9", "Microscopic observation [Identifier] in Unspecified specimen by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WRIGHT_GIEMSA_STAIN ("682-5", "Microscopic observation [Identifier] in Unspecified specimen by Wright Giemsa stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WRIGHT_STAIN ("681-7", "Microscopic observation [Identifier] in Unspecified specimen by Wright stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URETHRA_BY_GRAM_STAIN ("6474-1", "Microscopic observation [Identifier] in Urethra by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URETHRA_BY_WET_PREPARATION ("57851-8", "Microscopic observation [Identifier] in Urethra by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_ACID_FAST_STAIN ("11480-1", "Microscopic observation [Identifier] in Urine by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_ACID_FAST_STAIN_KINYOUN ("650-2", "Microscopic observation [Identifier] in Urine by Acid fast stain.Kinyoun", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED ("651-0", "Microscopic observation [Identifier] in Urine by Acid fast stain.Kinyoun modified", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN ("652-8", "Microscopic observation [Identifier] in Urine by Acid fast stain.Ziehl-Neelsen", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_DARK_FIELD_EXAMINATION ("20883-5", "Microscopic observation [Identifier] in Urine by Dark field examination", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_GRAM_STAIN ("653-6", "Microscopic observation [Identifier] in Urine by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_KOH_PREPARATION ("68958-8", "Microscopic observation [Identifier] in Urine by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN ("53905-6", "Microscopic observation [Identifier] in Urine by Rhodamine-auramine fluorochrome stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_VAGINAL_FLUID_BY_GRAM_STAIN ("14361-0", "Microscopic observation [Identifier] in Vaginal fluid by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_VAGINAL_FLUID_BY_KOH_PREPARATION ("14356-0", "Microscopic observation [Identifier] in Vaginal fluid by KOH preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_VAGINAL_FLUID_BY_WET_PREPARATION ("14319-8", "Microscopic observation [Identifier] in Vaginal fluid by Wet preparation", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_WOUND_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED ("14354-5", "Microscopic observation [Identifier] in Wound by Acid fast stain.Kinyoun modified", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_WOUND_BY_GRAM_STAIN ("10357-2", "Microscopic observation [Identifier] in Wound by Gram stain", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_IN_UNSPECIFIED_SPECIMEN_BY_ELECTRON_MICROSCOPY_NARRATIVE ("50668-3", "Microscopic observation in Unspecified specimen by Electron microscopy Narrative", "18725-2", "conditional", "20130527", "N/A"),
	MICROSCOPIC_OBSERVATION_PRESENCE_IN_UNSPECIFIED_SPECIMEN_QUALITATIVE_BY_ACID_FAST_STAIN ("72357-7", "Microscopic observation [Presence] in Unspecified specimen Qualitative by Acid fast stain", "18725-2", "conditional", "20130527", "N/A"),
	MINOCYCLINE_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25225-4", "Minocycline 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	MINOCYCLINE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("55156-4", "Minocycline [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	MOXIFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("41502-6", "Moxifloxacin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_AFRICANUM ("51320008", "Mycobacterium africanum", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_BOVIS ("27142009", "Mycobacterium bovis", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_CAPRAE ("430579009", "Mycobacterium caprae", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS ("113861009", "Mycobacterium tuberculosis", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_COMPLEX ("113858008", "Mycobacterium tuberculosis complex", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("38379-4", "Mycobacterium tuberculosis complex DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_GENOTYPE_IDENTIFIER_IN_ISOLATE ("42717-9", "Mycobacterium tuberculosis complex genotype [Identifier] in Isolate", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("17296-5", "Mycobacterium tuberculosis complex rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48174-7", "Mycobacterium tuberculosis complex rRNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_DNA_PRESENCE_IN_BODY_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("58931-7", "Mycobacterium tuberculosis DNA [Presence] in Body fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("13956-8", "Mycobacterium tuberculosis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_DNA_RPOB_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("46244-0", "Mycobacterium tuberculosis DNA rpoB [Identifier] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_DNA_VOLUME_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53257-2", "Mycobacterium tuberculosis DNA [#/volume] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_ETHAMBUTOL_RESISTANCE_EMBB_GENE_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("46247-3", "Mycobacterium tuberculosis ethambutol resistance (embB) gene [Identifier] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_FLUOROQUINOLONE_RESISTANCE_GYRA_GENE_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("72276-9", "Mycobacterium tuberculosis fluoroquinolone resistance (gyrA) gene [Presence] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_ISONIAZID_HIGH_LEVEL_RESISTANCE_KATG_GENE_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("46246-5", "Mycobacterium tuberculosis isoniazid high level resistance (katG) gene [Identifier] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_ISONIAZID_LOW_LEVEL_RESISTANCE_INHA_GENE_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("63072-3", "Mycobacterium tuberculosis isoniazid low level resistance (inhA) gene [Presence] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_ISONIAZID_RESISTANTMYCOBACTERIUM_TUBERCULOSIS_ISONIAZID_RESISTANCE_KATG_INHA_GENES_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48175-4", "Mycobacterium tuberculosis.isoniazid resistantMycobacterium tuberculosis isoniazid resistance (katG + inhA) genes [Presence] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_PYRAZINAMIDE_RESISTANCE_PNCA_GENE_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("46245-7", "Mycobacterium tuberculosis pyrazinamide resistance (pncA) gene [Identifier] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_RIFAMPIN_RESISTANCE_GENE_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("33634-7", "Mycobacterium tuberculosis rifampin resistance gene [Identifier] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_RIFAMPIN_RESISTANCE_RPOB_GENE_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("48176-2", "Mycobacterium tuberculosis rifampin resistance (rpoB) gene [Presence] by Probe and target amplification method", "18769-0", "conditional", "20130527", "N/A"),
	MYCOBACTERIUM_TUBERCULOSIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("5027-8", "Mycobacterium tuberculosis rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE ("68704007", "Neisseria gonorrhoeae", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_CERVICAL_MUCUS_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21414-8", "Neisseria gonorrhoeae DNA [Presence] in Cervical mucus by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("35735-0", "Neisseria gonorrhoeae DNA [Presence] in Conjunctival specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_GENITAL_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("47387-6", "Neisseria gonorrhoeae DNA [Presence] in Genital specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_NASOPHARYNX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("57180-2", "Neisseria gonorrhoeae DNA [Presence] in Nasopharynx by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD ("43403-5", "Neisseria gonorrhoeae DNA [Presence] in Unspecified specimen by Probe and signal amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("24111-7", "Neisseria gonorrhoeae DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("50326-8", "Neisseria gonorrhoeae DNA [Presence] in Unspecified specimen from donor by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_URETHRA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21415-5", "Neisseria gonorrhoeae DNA [Presence] in Urethra by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_URINE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("21416-3", "Neisseria gonorrhoeae DNA [Presence] in Urine by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_VAGINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("32705-6", "Neisseria gonorrhoeae DNA [Presence] in Vaginal fluid by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_ANAL_BY_ORGANISM_SPECIFIC_CULTURE ("14127-5", "Neisseria gonorrhoeae [Presence] in Anal by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_CERVIX_BY_ORGANISM_SPECIFIC_CULTURE ("688-2", "Neisseria gonorrhoeae [Presence] in Cervix by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("30099-6", "Neisseria gonorrhoeae [Presence] in Conjunctival specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_ENDOMETRIUM_BY_ORGANISM_SPECIFIC_CULTURE ("690-8", "Neisseria gonorrhoeae [Presence] in Endometrium by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_GENITAL_LOCHIA_BY_ORGANISM_SPECIFIC_CULTURE ("692-4", "Neisseria gonorrhoeae [Presence] in Genital lochia by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_GENITAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("691-6", "Neisseria gonorrhoeae [Presence] in Genital specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_SEMEN_BY_ORGANISM_SPECIFIC_CULTURE ("694-0", "Neisseria gonorrhoeae [Presence] in Semen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_SYNOVIAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE ("695-7", "Neisseria gonorrhoeae [Presence] in Synovial fluid by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_THROAT_BY_ORGANISM_SPECIFIC_CULTURE ("696-5", "Neisseria gonorrhoeae [Presence] in Throat by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("698-1", "Neisseria gonorrhoeae [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_URETHRA_BY_ORGANISM_SPECIFIC_CULTURE ("697-3", "Neisseria gonorrhoeae [Presence] in Urethra by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_PRESENCE_IN_VAGINAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE ("693-2", "Neisseria gonorrhoeae [Presence] in Vaginal fluid by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_ANAL_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("57458-2", "Neisseria gonorrhoeae rRNA [Presence] in Anal by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_CERVIX_BY_DNA_PROBE ("32198-4", "Neisseria gonorrhoeae rRNA [Presence] in Cervix by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_CERVIX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("50388-8", "Neisseria gonorrhoeae rRNA [Presence] in Cervix by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_DNA_PROBE ("33904-4", "Neisseria gonorrhoeae rRNA [Presence] in Conjunctival specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_NASOPHARYNX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("57289-1", "Neisseria gonorrhoeae rRNA [Presence] in Nasopharynx by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_PENIS_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53878-5", "Neisseria gonorrhoeae rRNA [Presence] in Penis by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_THROAT_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60255-7", "Neisseria gonorrhoeae rRNA [Presence] in Throat by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("5028-6", "Neisseria gonorrhoeae rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("43305-2", "Neisseria gonorrhoeae rRNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("50412-6", "Neisseria gonorrhoeae rRNA [Presence] in Unspecified specimen from donor by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_URETHRA_BY_DNA_PROBE ("32199-2", "Neisseria gonorrhoeae rRNA [Presence] in Urethra by DNA probe", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_URETHRA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53927-0", "Neisseria gonorrhoeae rRNA [Presence] in Urethra by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_URINE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60256-5", "Neisseria gonorrhoeae rRNA [Presence] in Urine by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_VAGINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53879-3", "Neisseria gonorrhoeae rRNA [Presence] in Vaginal fluid by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS ("17872004", "Neisseria meningitidis", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("6508-6", "Neisseria meningitidis Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN ("65763-5", "Neisseria meningitidis Ag [Presence] in Tissue by Immune stain", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31912-9", "Neisseria meningitidis Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6492-3", "Neisseria meningitidis Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_URINE ("17323-7", "Neisseria meningitidis Ag [Presence] in Urine", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_AG_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("31911-1", "Neisseria meningitidis Ag [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_AG_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("17324-5", "Neisseria meningitidis Ag [Units/volume] in Cerebral spinal fluid by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31907-9", "Neisseria meningitidis A Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("6493-1", "Neisseria meningitidis A Ag [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("17326-0", "Neisseria meningitidis A Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("6494-9", "Neisseria meningitidis A Ag [Presence] in Cerebral spinal fluid by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION ("42369-9", "Neisseria meningitidis A Ag [Presence] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31908-7", "Neisseria meningitidis A Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6495-6", "Neisseria meningitidis A Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("30094-7", "Neisseria meningitidis A Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31909-5", "Neisseria meningitidis A+C+w135+Y Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("19133-8", "Neisseria meningitidis A+C+w135+Y Ag [Presence] in Cerebral spinal fluid by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_SERUM ("33396-3", "Neisseria meningitidis A+C+w135+Y Ag [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION ("33397-1", "Neisseria meningitidis A+C+w135+Y Ag [Presence] in Serum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31910-3", "Neisseria meningitidis A+C+w135+Y Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("19259-1", "Neisseria meningitidis A+C+w135+Y Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_URINE ("32706-4", "Neisseria meningitidis A+C+w135+Y Ag [Presence] in Urine", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_URINE_BY_LATEX_AGGLUTINATION ("33398-9", "Neisseria meningitidis A+C+w135+Y Ag [Presence] in Urine by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_W135_AG_PRESENCE_IN_BODY_FLUID ("42341-8", "Neisseria meningitidis A+w135 Ag [Presence] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("20487-5", "Neisseria meningitidis A+Y Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("32848-4", "Neisseria meningitidis A+Y Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("32851-8", "Neisseria meningitidis A+Y Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_A_Y_AG_PRESENCE_IN_URINE ("17321-1", "Neisseria meningitidis A+Y Ag [Presence] in Urine", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_BODY_FLUID ("41503-4", "Neisseria meningitidis B Ag [Presence] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("24017-6", "Neisseria meningitidis B Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("6496-4", "Neisseria meningitidis B Ag [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6497-2", "Neisseria meningitidis B Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("6498-0", "Neisseria meningitidis B Ag [Presence] in Cerebral spinal fluid by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION ("42370-7", "Neisseria meningitidis B Ag [Presence] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_SERUM ("43430-8", "Neisseria meningitidis B Ag [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31913-7", "Neisseria meningitidis B Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("30095-4", "Neisseria meningitidis B Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_URINE ("24018-4", "Neisseria meningitidis B Ag [Presence] in Urine", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_URINE_BY_LATEX_AGGLUTINATION ("17328-6", "Neisseria meningitidis B Ag [Presence] in Urine by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31916-0", "Neisseria meningitidis C Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("6499-8", "Neisseria meningitidis C Ag [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("17329-4", "Neisseria meningitidis C Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("6500-3", "Neisseria meningitidis C Ag [Presence] in Cerebral spinal fluid by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION ("42371-5", "Neisseria meningitidis C Ag [Presence] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31917-8", "Neisseria meningitidis C Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6501-1", "Neisseria meningitidis C Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("30096-2", "Neisseria meningitidis C Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_W135_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("19022-3", "Neisseria meningitidis C+w135 Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_W135_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("32841-9", "Neisseria meningitidis C+w135 Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_W135_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("32800-5", "Neisseria meningitidis C+w135 Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_C_W135_AG_PRESENCE_IN_URINE ("17325-2", "Neisseria meningitidis C+w135 Ag [Presence] in Urine", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53606-0", "Neisseria meningitidis DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49671-1", "Neisseria meningitidis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_D_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION ("42372-3", "Neisseria meningitidis D Ag [Presence] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_GROUP_A ("103479006", "Neisseria meningitidis group A", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_GROUP_B ("103480009", "Neisseria meningitidis group B", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_GROUP_C ("103481008", "Neisseria meningitidis group C", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_GROUP_X ("125041003", "Neisseria meningitidis group X", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_GROUP_Y ("103482001", "Neisseria meningitidis group Y", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_GROUP_Z ("125042005", "Neisseria meningitidis group Z", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION ("45183-1", "Neisseria meningitidis [Identifier] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_IDENTIFIER_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE ("44093-3", "Neisseria meningitidis [Identifier] in Isolate by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_POLYVALENT_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("17332-8", "Neisseria meningitidis polyvalent Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("16134-9", "Neisseria meningitidis [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_RRNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_DNA_PROBE ("6509-4", "Neisseria meningitidis rRNA [Presence] in Cerebral spinal fluid by DNA probe", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("5029-4", "Neisseria meningitidis rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_SEROGROUP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("71788-4", "Neisseria meningitidis serogroup DNA [Identifier] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135 ("103483006", "Neisseria meningitidis W135", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31918-6", "Neisseria meningitidis w135 Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6506-0", "Neisseria meningitidis w135 Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("6507-8", "Neisseria meningitidis w135 Ag [Presence] in Cerebral spinal fluid by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION ("42368-1", "Neisseria meningitidis w135 Ag [Presence] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_SERUM_OR_PLASMA ("31919-4", "Neisseria meningitidis w135 Ag [Presence] in Serum or Plasma", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_LATEX_AGGLUTINATION ("17333-6", "Neisseria meningitidis w135 Ag [Presence] in Serum or Plasma by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31920-2", "Neisseria meningitidis w135 Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("30097-0", "Neisseria meningitidis w135 Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_X_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION ("42373-1", "Neisseria meningitidis X Ag [Presence] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("17330-2", "Neisseria meningitidis Y Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("6503-7", "Neisseria meningitidis Y Ag [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6504-5", "Neisseria meningitidis Y Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("6505-2", "Neisseria meningitidis Y Ag [Presence] in Cerebral spinal fluid by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION ("42374-9", "Neisseria meningitidis Y Ag [Presence] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31921-0", "Neisseria meningitidis Y Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION ("30098-8", "Neisseria meningitidis Y Ag [Presence] in Unspecified specimen by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Z_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION ("42376-4", "Neisseria meningitidis Z Ag [Presence] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	NEISSERIA_MENINGITIDIS_Z_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_1 ("42375-6", "Neisseria meningitidis Z Ag [Presence] in Isolate by Agglutination 1", "18725-2", "none", "20130527", "N/A"),
	OFLOXACIN_1_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("72168-8", "Ofloxacin 1.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	OFLOXACIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("41408-6", "Ofloxacin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	OFLOXACIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("41409-4", "Ofloxacin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	OFLOXACIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("41410-2", "Ofloxacin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	OFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20384-4", "Ofloxacin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PARA_AMINOSALICYLATE_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("48685-2", "Para aminosalicylate 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PARA_AMINOSALICYLATE_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25215-5", "Para aminosalicylate 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PARA_AMINOSALICYLATE_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25216-3", "Para aminosalicylate 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PARA_AMINOSALICYLATE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23611-7", "Para aminosalicylate [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PLASMODIUM_FALCIPARUM_AG_UNITSVOLUME_IN_BLOOD_BY_IMMUNOFLUORESCENCE ("10709-4", "Plasmodium falciparum Ag [Units/volume] in Blood by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_FALCIPARUM_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41447-4", "Plasmodium falciparum DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_KNOWLESI_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("70568-1", "Plasmodium knowlesi DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_MALARIAE_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41448-2", "Plasmodium malariae DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_OVALE_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41449-0", "Plasmodium ovale DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_AG_IDENTIFIER_IN_BLOOD ("51865-4", "Plasmodium sp Ag [Identifier] in Blood", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_AG_IDENTIFIER_IN_BLOOD_BY_RAPID_IMMUNOASSAY ("70569-9", "Plasmodium sp Ag [Identifier] in Blood by Rapid immunoassay", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_AG_PRESENCE_IN_BLOOD ("50687-3", "Plasmodium sp Ag [Presence] in Blood", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_AG_PRESENCE_IN_BLOOD_BY_IMMUNOASSAY ("46094-9", "Plasmodium sp Ag [Presence] in Blood by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_DNA_IDENTIFIER_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("47260-5", "Plasmodium sp DNA [Identifier] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("47085-6", "Plasmodium sp DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_IDENTIFIED_IN_BLOOD_BY_LIGHT_MICROSCOPY ("32206-5", "Plasmodium sp identified in Blood by Light microscopy", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_IDENTIFIED_IN_BLOOD_BY_THIN_FILM ("10710-2", "Plasmodium sp identified in Blood by Thin film", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_SP_PRESENCE_IN_BLOOD_BY_LIGHT_MICROSCOPY ("51587-4", "Plasmodium sp [Presence] in Blood by Light microscopy", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_VIVAX_AG_UNITSVOLUME_IN_BLOOD ("31931-9", "Plasmodium vivax Ag [Units/volume] in Blood", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_VIVAX_AG_UNITSVOLUME_IN_BLOOD_BY_IMMUNOFLUORESCENCE ("10711-0", "Plasmodium vivax Ag [Units/volume] in Blood by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	PLASMODIUM_VIVAX_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41450-8", "Plasmodium vivax DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	POLIO_VIRUS_1_AB_TITER_IN_SERUM_1ST_SPECIMEN ("24243-8", "Polio virus 1 Ab [Titer] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_1_AB_TITER_IN_SERUM_2ND_SPECIMEN ("24244-6", "Polio virus 1 Ab [Titer] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_1_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_2ND_SPECIMEN ("24170-3", "Polio virus 1 Ab [Titer] in Serum by Neutralization test --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_2_AB_TITER_IN_SERUM_1ST_SPECIMEN ("24245-3", "Polio virus 2 Ab [Titer] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_2_AB_TITER_IN_SERUM_2ND_SPECIMEN ("24246-1", "Polio virus 2 Ab [Titer] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_2_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_1ST_SPECIMEN ("24171-1", "Polio virus 2 Ab [Titer] in Serum by Neutralization test --1st specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_2_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_2ND_SPECIMEN ("24172-9", "Polio virus 2 Ab [Titer] in Serum by Neutralization test --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_3_AB_TITER_IN_SERUM_1ST_SPECIMEN ("24247-9", "Polio virus 3 Ab [Titer] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_3_AB_TITER_IN_SERUM_2ND_SPECIMEN ("24248-7", "Polio virus 3 Ab [Titer] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_3_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_1ST_SPECIMEN ("24173-7", "Polio virus 3 Ab [Titer] in Serum by Neutralization test --1st specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_3_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_2ND_SPECIMEN ("24174-5", "Polio virus 3 Ab [Titer] in Serum by Neutralization test --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE ("53645-8", "Polio virus identified in Stool by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_IDENTIFIED_TYPE_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE ("60546-9", "Polio virus identified [Type] in Isolate by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_2ND_SPECIMEN ("40783-3", "Polio virus IgG Ab [Titer] in Cerebral spinal fluid --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_IGG_AB_TITER_IN_SERUM_2ND_SPECIMEN ("40708-0", "Polio virus IgG Ab [Titer] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_1ST_SPECIMEN ("40782-5", "Polio virus IgM Ab [Titer] in Cerebral spinal fluid --1st specimen", "18725-2", "none", "20130527", "N/A"),
	POLIO_VIRUS_IGM_AB_TITER_IN_SERUM_1ST_SPECIMEN ("40781-7", "Polio virus IgM Ab [Titer] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	PROTHIONAMIDE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("63565-6", "Prothionamide [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PYRAZINAMIDE_100_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25229-6", "Pyrazinamide 100 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PYRAZINAMIDE_200_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("55711-6", "Pyrazinamide 200 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PYRAZINAMIDE_25_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25186-8", "Pyrazinamide 25 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PYRAZINAMIDE_300_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("56026-8", "Pyrazinamide 300 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	PYRAZINAMIDE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20461-0", "Pyrazinamide [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	QUINUPRISTIN_DALFOPRISTIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("58712-1", "Quinupristin+Dalfopristin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RABIES_VIRUS_AG_PRESENCE_IN_BRAIN_BY_IMMUNE_STAIN ("23390-8", "Rabies virus Ag [Presence] in Brain by Immune stain", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_AG_PRESENCE_IN_BRAIN_BY_IMMUNOASSAY ("23389-0", "Rabies virus Ag [Presence] in Brain by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE ("6528-4", "Rabies virus Ag [Presence] in Tissue by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNE_STAIN ("23391-6", "Rabies virus Ag [Presence] in Unspecified specimen by Immune stain", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("6532-6", "Rabies virus Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_IDENTIFIED_IN_TISSUE_BY_ORGANISM_SPECIFIC_CULTURE ("6536-7", "Rabies virus identified in Tissue by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6539-1", "Rabies virus identified in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_PRESENCE_IN_BRAIN_BY_LIGHT_MICROSCOPY ("23388-2", "Rabies virus [Presence] in Brain by Light microscopy", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60270-6", "Rabies virus RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("51647-6", "Rabies virus RNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("51646-8", "Rabies virus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_STRAIN_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("70866-9", "Rabies virus strain identified in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RABIES_VIRUS_STRAIN_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_SEQUENCING ("70867-7", "Rabies virus strain identified in Unspecified specimen by Sequencing", "18725-2", "none", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("22459-2", "Reagin Ab [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_VDRL ("5290-2", "Reagin Ab [Presence] in Cerebral spinal fluid by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_CORD_BLOOD ("43813-5", "Reagin Ab [Presence] in Cord blood", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_CORD_BLOOD_BY_VDRL ("51783-9", "Reagin Ab [Presence] in Cord blood by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_SERUM ("22461-8", "Reagin Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_SERUM_BY_RPR ("20507-0", "Reagin Ab [Presence] in Serum by RPR", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_SERUM_BY_VDRL ("5292-8", "Reagin Ab [Presence] in Serum by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_SERUM_FROM_DONOR ("22463-4", "Reagin Ab [Presence] in Serum from donor", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_RPR ("47360-3", "Reagin Ab [Presence] in Serum from donor by RPR", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_VDRL ("21030-2", "Reagin Ab [Presence] in Serum from donor by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("22464-2", "Reagin Ab [Presence] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_VDRL ("14904-7", "Reagin Ab [Presence] in Unspecified specimen by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("46203-6", "Reagin Ab [Titer] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_VDRL ("31146-4", "Reagin Ab [Titer] in Cerebral spinal fluid by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_TITER_IN_SERUM ("11084-1", "Reagin Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_TITER_IN_SERUM_BY_RPR ("31147-2", "Reagin Ab [Titer] in Serum by RPR", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_TITER_IN_SERUM_BY_VDRL ("50690-7", "Reagin Ab [Titer] in Serum by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_TITER_IN_UNSPECIFIED_SPECIMEN ("47476-7", "Reagin Ab [Titer] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_TITER_IN_UNSPECIFIED_SPECIMEN_BY_VDRL ("47235-7", "Reagin Ab [Titer] in Unspecified specimen by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("22460-0", "Reagin Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_VDRL ("5289-4", "Reagin Ab [Units/volume] in Cerebral spinal fluid by VDRL", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_UNITSVOLUME_IN_SERUM ("22462-6", "Reagin Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_UNITSVOLUME_IN_SERUM_BY_RPR ("20508-8", "Reagin Ab [Units/volume] in Serum by RPR", "18725-2", "initials", "20130527", "N/A"),
	REAGIN_AB_UNITSVOLUME_IN_SERUM_BY_VDRL ("5291-0", "Reagin Ab [Units/volume] in Serum by VDRL", "18725-2", "initials", "20130527", "N/A"),
	RIFABUTIN_0_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("42655-1", "Rifabutin 0.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFABUTIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25199-1", "Rifabutin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFABUTIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25200-7", "Rifabutin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFABUTIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25201-5", "Rifabutin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFABUTIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20386-9", "Rifabutin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFAMPIN_14_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25184-3", "Rifampin 14 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFAMPIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25202-3", "Rifampin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFAMPIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25203-1", "Rifampin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFAMPIN_40_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("55712-4", "Rifampin 40 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFAMPIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25204-9", "Rifampin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFAMPIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20385-1", "Rifampin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AB_TITER_IN_SERUM ("23400-5", "Rift valley fever virus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST ("23396-5", "Rift valley fever virus Ab [Titer] in Serum by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AB_UNITSVOLUME_IN_SERUM ("31612-5", "Rift valley fever virus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_BLOOD_BY_NEUTRALIZATION_TEST ("23402-1", "Rift valley fever virus Ag [Presence] in Blood by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_SERUM_BY_IMMUNE_DIFFUSION_ID ("23406-2", "Rift valley fever virus Ag [Presence] in Serum by Immune diffusion (ID)", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("71778-5", "Rift valley fever virus Ag [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_DIFFUSION_ID ("23405-4", "Rift valley fever virus Ag [Presence] in Tissue by Immune diffusion (ID)", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE ("23404-7", "Rift valley fever virus Ag [Presence] in Tissue by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_TISSUE_BY_NEUTRALIZATION_TEST ("23401-3", "Rift valley fever virus Ag [Presence] in Tissue by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31951-7", "Rift valley fever virus Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("23403-9", "Rift valley fever virus Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("71784-3", "Rift valley fever virus IgG Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("71781-9", "Rift valley fever virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RIFT_VALLEY_FEVER_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("71779-3", "Rift valley fever virus IgM Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("42967-0", "Rubella virus Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("40542-3", "Rubella virus Ab [Titer] in Cerebral spinal fluid by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_TITER_IN_SERUM ("22497-2", "Rubella virus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION ("50694-9", "Rubella virus Ab [Titer] in Serum by Hemagglutination inhibition", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION ("5333-0", "Rubella virus Ab [Titer] in Serum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("17549-7", "Rubella virus Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("9576-0", "Rubella virus Ab [Units/volume] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_UNITSVOLUME_IN_SERUM ("8013-5", "Rubella virus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION ("5330-6", "Rubella virus Ab [Units/volume] in Serum by Hemagglutination inhibition", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51931-4", "Rubella virus Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION ("17550-5", "Rubella virus Ab [Units/volume] in Serum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31955-8", "Rubella virus Ag [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("14523-5", "Rubella virus Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_CERVIX ("31956-6", "Rubella virus Ag [Presence] in Cervix", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_CERVIX_BY_IMMUNOFLUORESCENCE ("14529-2", "Rubella virus Ag [Presence] in Cervix by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_EYE ("31957-4", "Rubella virus Ag [Presence] in Eye", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_EYE_BY_IMMUNOFLUORESCENCE ("14526-8", "Rubella virus Ag [Presence] in Eye by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_NOSE ("31959-0", "Rubella virus Ag [Presence] in Nose", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_NOSE_BY_IMMUNOFLUORESCENCE ("14527-6", "Rubella virus Ag [Presence] in Nose by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_PENIS ("31960-8", "Rubella virus Ag [Presence] in Penis", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_PENIS_BY_IMMUNOFLUORESCENCE ("14532-6", "Rubella virus Ag [Presence] in Penis by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_SKIN ("31961-6", "Rubella virus Ag [Presence] in Skin", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_SKIN_BY_IMMUNOFLUORESCENCE ("14525-0", "Rubella virus Ag [Presence] in Skin by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_SPUTUM ("31962-4", "Rubella virus Ag [Presence] in Sputum", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_SPUTUM_BY_IMMUNOFLUORESCENCE ("14528-4", "Rubella virus Ag [Presence] in Sputum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_THROAT ("31963-2", "Rubella virus Ag [Presence] in Throat", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE ("14524-3", "Rubella virus Ag [Presence] in Throat by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("31966-5", "Rubella virus Ag [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("12251-5", "Rubella virus Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_URETHRA ("31965-7", "Rubella virus Ag [Presence] in Urethra", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_URETHRA_BY_IMMUNOFLUORESCENCE ("14533-4", "Rubella virus Ag [Presence] in Urethra by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_URINE_SEDIMENT ("31964-0", "Rubella virus Ag [Presence] in Urine sediment", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_URINE_SEDIMENT_BY_IMMUNOFLUORESCENCE ("14531-8", "Rubella virus Ag [Presence] in Urine sediment by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_VAGINAL_FLUID ("31958-2", "Rubella virus Ag [Presence] in Vaginal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_AG_PRESENCE_IN_VAGINAL_FLUID_BY_IMMUNOFLUORESCENCE ("14530-0", "Rubella virus Ag [Presence] in Vaginal fluid by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IDENTIFIED_IN_SERUM_BY_ORGANISM_SPECIFIC_CULTURE ("6548-2", "Rubella virus identified in Serum by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_RATIO_IN_SERUM_1ST_SPECIMEN2ND_SPECIMEN ("25298-1", "Rubella virus IgG Ab [Ratio] in Serum --1st specimen/2nd specimen", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("46110-3", "Rubella virus IgG Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_TITER_IN_SERUM ("41763-4", "Rubella virus IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_BODY_FLUID ("29343-1", "Rubella virus IgG Ab [Units/volume] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("13281-1", "Rubella virus IgG Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("17551-3", "Rubella virus IgG Ab [Units/volume] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM ("8014-3", "Rubella virus IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUMDS_2ND_SPECIMEN ("13280-3", "Rubella virus IgG Ab [Units/volume] in Serumds --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_1ST_SPECIMEN ("13279-5", "Rubella virus IgG Ab [Units/volume] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5334-8", "Rubella virus IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOASSAY ("69765-6", "Rubella virus IgM Ab [Presence] in Body fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("17552-1", "Rubella virus IgM Ab [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("40669-4", "Rubella virus IgM Ab [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM ("31616-6", "Rubella virus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("24116-6", "Rubella virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION ("25420-1", "Rubella virus IgM Ab [Presence] in Serum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("46109-5", "Rubella virus IgM Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_TITER_IN_SERUM ("49107-6", "Rubella virus IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_BODY_FLUID ("31047-4", "Rubella virus IgM Ab [Units/volume] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("13282-9", "Rubella virus IgM Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("8015-0", "Rubella virus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("5335-5", "Rubella virus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60274-8", "Rubella virus RNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	RUBELLA_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("54091-4", "Rubella virus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA ("27268008", "Salmonella", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_ENTERICA_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("61370-3", "Salmonella enterica DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_ENTERITIDIS ("73525009", "Salmonella enteritidis", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_ENTERITIDIS_PRESENCE_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE ("23602-6", "Salmonella enteritidis [Presence] in Stool by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_ENTERITIDIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("34891-2", "Salmonella enteritidis [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_GALLINARUM_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("23431-0", "Salmonella gallinarum DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_GALLINARUM_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("23432-8", "Salmonella gallinarum rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_PARATYPHI_A ("79128009", "Salmonella paratyphi A", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_PARATYPHI_B ("85908006", "Salmonella paratyphi B", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_PARATYPHI_C ("32488009", "Salmonella paratyphi C", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_PULLORUM_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("23435-1", "Salmonella pullorum DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_PULLORUM_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("23436-9", "Salmonella pullorum rRNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SPECIES ("372342007", "Salmonella species", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SP_ANTIGENIC_FORMULA_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION ("56475-7", "Salmonella sp antigenic formula [Identifier] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SP_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49612-5", "Salmonella sp DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SP_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE ("20955-1", "Salmonella sp identified in Stool by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SP_IDENTIFIED_IN_TISSUE_BY_ORGANISM_SPECIFIC_CULTURE ("20953-6", "Salmonella sp identified in Tissue by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("17563-8", "Salmonella sp identified in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SP_IDENTIFIED_TYPE_IN_ISOLATE ("59846-6", "Salmonella sp identified [Type] in Isolate", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SP_SEROTYPE_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION ("20951-0", "Salmonella sp serotype [Identifier] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_SP_SEROVAR_TYPE_IN_ISOLATE ("65756-9", "Salmonella sp serovar [Type] in Isolate", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_TYPHI ("5595000", "Salmonella typhi", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_TYPHIMURIUM ("50136005", "Salmonella typhimurium", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_TYPHI_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("70021-1", "Salmonella typhi DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SALMONELLA_TYPHI_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION ("53956-9", "Salmonella typhi [Identifier] in Isolate by Agglutination", "18725-2", "none", "20130527", "N/A"),
	SARS_CORONAVIRUS_AB_TITER_IN_SERUM ("60426-4", "SARS coronavirus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	SARS_CORONAVIRUS_IGM_AB_PRESENCE_IN_SERUM ("42956-3", "SARS coronavirus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	SARS_CORONAVIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("41991-1", "SARS coronavirus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	SARS_CORONAVIRUS_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60275-5", "SARS coronavirus RNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SARS_CORONAVIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("60534-5", "SARS coronavirus RNA [Presence] in Serum or Plasma by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SARS_CORONAVIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41458-1", "SARS coronavirus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	SHIGELLA_BOYDII ("55462008", "Shigella boydii", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_BOYDII_AG_PRESENCE_IN_ISOLATE ("42256-8", "Shigella boydii Ag [Presence] in Isolate", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_DYSENTERIAE ("43612004", "Shigella dysenteriae", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_DYSENTERIAE_AG_PRESENCE_IN_ISOLATE ("42257-6", "Shigella dysenteriae Ag [Presence] in Isolate", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_FLEXNERI ("85729005", "Shigella flexneri", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_FLEXNERI_AG_PRESENCE_IN_ISOLATE ("42258-4", "Shigella flexneri Ag [Presence] in Isolate", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_SONNEI ("4298009", "Shigella sonnei", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_SONNEI_AG_PRESENCE_IN_ISOLATE ("42259-2", "Shigella sonnei Ag [Presence] in Isolate", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_SPECIES ("116498009", "Shigella species", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_SP_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("46455-2", "Shigella sp DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_SP_IDENTIFIED_IN_FEED_BY_ORGANISM_SPECIFIC_CULTURE ("20964-3", "Shigella sp identified in Feed by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("17576-0", "Shigella sp identified in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_SP_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("46454-5", "Shigella sp [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	SHIGELLA_SP_SEROTYPE_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION ("49056-5", "Shigella sp serotype [Identifier] in Isolate by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	SPARFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23610-9", "Sparfloxacin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	STREPTOCOCCUS_PENUMONIAE_3 ("103497003", "Streptococcus penumoniae 3", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PENUMONIAE_SEROTYPE_29 ("131363003", "Streptococcus penumoniae, serotype 29", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE ("9861002", "Streptococcus pneumoniae", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_14 ("103498008", "Streptococcus pneumoniae 14", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_7F ("103499000", "Streptococcus pneumoniae 7F", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_9N ("103500009", "Streptococcus pneumoniae 9N", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("20489-1", "Streptococcus pneumoniae Ag [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("6553-2", "Streptococcus pneumoniae Ag [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION ("14322-2", "Streptococcus pneumoniae Ag [Presence] in Cerebral spinal fluid by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_SERUM ("11086-6", "Streptococcus pneumoniae Ag [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_URINE ("24027-5", "Streptococcus pneumoniae Ag [Presence] in Urine", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53917-1", "Streptococcus pneumoniae DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_11 ("363768008", "Streptococcus pneumoniae, serotype 11", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_12 ("116500005", "Streptococcus pneumoniae, serotype 12", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_16 ("131362008", "Streptococcus pneumoniae, serotype 16", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_17 ("131361001", "Streptococcus pneumoniae, serotype 17", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_19 ("127541006", "Streptococcus pneumoniae, serotype 19", "18725-2", "initials", "20130527", "N/A"),
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_22 ("363767003", "Streptococcus pneumoniae, serotype 22", "18725-2", "initials", "20130527", "N/A"),
	STREPTOMYCIN_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25206-4", "Streptomycin 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	STREPTOMYCIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("48177-0", "Streptomycin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	STREPTOMYCIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25205-6", "Streptomycin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	STREPTOMYCIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("46719-1", "Streptomycin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	STREPTOMYCIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25185-0", "Streptomycin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	STREPTOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20462-8", "Streptomycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	SULFISOXAZOLE_300_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25226-2", "Sulfisoxazole 300 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	TOBRAMYCIN_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25227-0", "Tobramycin 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	TOBRAMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25800-4", "Tobramycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("22586-2", "Treponema pallidum Ab [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_HEMAGGLUTINATION ("50689-9", "Treponema pallidum Ab [Presence] in Cerebral spinal fluid by Hemagglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("9826-9", "Treponema pallidum Ab [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM ("22587-0", "Treponema pallidum Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION ("24312-1", "Treponema pallidum Ab [Presence] in Serum by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_HEMAGGLUTINATION ("8041-6", "Treponema pallidum Ab [Presence] in Serum by Hemagglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_IMMOBILIZATION ("17723-8", "Treponema pallidum Ab [Presence] in Serum by Immobilization", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("24110-9", "Treponema pallidum Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("57032-5", "Treponema pallidum Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("5393-4", "Treponema pallidum Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_FROM_DONOR ("46206-9", "Treponema pallidum Ab [Presence] in Serum from donor", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOFLUORESCENCE ("43238-5", "Treponema pallidum Ab [Presence] in Serum from donor by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("51475-2", "Treponema pallidum Ab [Titer] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_HEMAGGLUTINATION ("50695-6", "Treponema pallidum Ab [Titer] in Cerebral spinal fluid by Hemagglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM ("22590-4", "Treponema pallidum Ab [Titer] in Serum", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION ("26009-1", "Treponema pallidum Ab [Titer] in Serum by Hemagglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("34382-2", "Treponema pallidum Ab [Titer] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION ("5394-2", "Treponema pallidum Ab [Titer] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_OR_PLASMA_BY_AGGLUTINATION ("71793-4", "Treponema pallidum Ab [Titer] in Serum or Plasma by Agglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_BLOOD ("22585-4", "Treponema pallidum Ab [Units/volume] in Blood", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_BLOOD_BY_IMMUNOFLUORESCENCE ("13288-6", "Treponema pallidum Ab [Units/volume] in Blood by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_BODY_FLUID ("47511-1", "Treponema pallidum Ab [Units/volume] in Body fluid", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_BODY_FLUID_BY_HEMAGGLUTINATION ("39015-3", "Treponema pallidum Ab [Units/volume] in Body fluid by Hemagglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("51474-5", "Treponema pallidum Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_HEMAGGLUTINATION ("49800-6", "Treponema pallidum Ab [Units/volume] in Cerebral spinal fluid by Hemagglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM ("11597-2", "Treponema pallidum Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_IMMOBILIZATION ("5392-6", "Treponema pallidum Ab [Units/volume] in Serum by Immobilization", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("63464-2", "Treponema pallidum Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE ("17724-6", "Treponema pallidum Ab [Units/volume] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION ("17725-3", "Treponema pallidum Ab [Units/volume] in Serum by Latex agglutination", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN ("41122-3", "Treponema pallidum Ab [Units/volume] in Unspecified specimen", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53605-2", "Treponema pallidum DNA [Presence] in Blood by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_DNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("49799-0", "Treponema pallidum DNA [Presence] in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41163-7", "Treponema pallidum DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("58031-6", "Treponema pallidum IgG Ab [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("58751-9", "Treponema pallidum IgG Ab [Presence] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM ("6561-5", "Treponema pallidum IgG Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("47238-1", "Treponema pallidum IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("40679-3", "Treponema pallidum IgG Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("17726-1", "Treponema pallidum IgG Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_FROM_DONOR ("47513-7", "Treponema pallidum IgG Ab [Presence] in Serum from donor", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOASSAY ("47361-1", "Treponema pallidum IgG Ab [Presence] in Serum from donor by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("47512-9", "Treponema pallidum IgG Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("47051-8", "Treponema pallidum IgG Ab [Units/volume] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM ("22592-0", "Treponema pallidum IgG Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51838-1", "Treponema pallidum IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE ("17727-9", "Treponema pallidum IgG Ab [Units/volume] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_IGM_AB_PRESENCE_IN_SERUM ("34147-9", "Treponema pallidum IgG+IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGG_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("47236-5", "Treponema pallidum IgG+IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB ("69946-2", "Treponema pallidum IgM Ab [Presence] in Cerebral spinal fluid by Immunoblot (IB)", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM ("6562-3", "Treponema pallidum IgM Ab [Presence] in Serum", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("47237-3", "Treponema pallidum IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB ("40680-1", "Treponema pallidum IgM Ab [Presence] in Serum by Immunoblot (IB)", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("17729-5", "Treponema pallidum IgM Ab [Presence] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("47514-5", "Treponema pallidum IgM Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("47063-3", "Treponema pallidum IgM Ab [Units/volume] in Cerebral spinal fluid by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM ("22594-6", "Treponema pallidum IgM Ab [Units/volume] in Serum", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("51839-9", "Treponema pallidum IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE ("17728-7", "Treponema pallidum IgM Ab [Units/volume] in Serum by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TREPONEMA_PALLIDUM_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("29310-0", "Treponema pallidum [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "initials", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_AB_PRESENCE_IN_SERUM ("22595-3", "Trichinella spiralis Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("19253-4", "Trichinella spiralis Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_AB_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION ("17732-9", "Trichinella spiralis Ab [Presence] in Serum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_AB_TITER_IN_SERUM ("22596-1", "Trichinella spiralis Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("25993-7", "Trichinella spiralis Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION ("5395-9", "Trichinella spiralis Ab [Titer] in Serum by Latex agglutination", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_AB_UNITSVOLUME_IN_SERUM ("8042-4", "Trichinella spiralis Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("41426-8", "Trichinella spiralis Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGA_AB_PRESENCE_IN_SERUM ("17733-7", "Trichinella spiralis IgA Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGA_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("13922-0", "Trichinella spiralis IgA Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGG_AB_PRESENCE_IN_SERUM ("8043-2", "Trichinella spiralis IgG Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("6563-1", "Trichinella spiralis IgG Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGG_AB_TITER_IN_SERUM ("53387-7", "Trichinella spiralis IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("52979-2", "Trichinella spiralis IgG Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGG_AB_UNITSVOLUME_IN_SERUM ("17734-5", "Trichinella spiralis IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("25423-5", "Trichinella spiralis IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGM_AB_PRESENCE_IN_SERUM ("17735-2", "Trichinella spiralis IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("13923-8", "Trichinella spiralis IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SPIRALIS_PRESENCE_IN_TISSUE_BY_LIGHT_MICROSCOPY ("23499-7", "Trichinella spiralis [Presence] in Tissue by Light microscopy", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SP_AB_PRESENCE_IN_SERUM ("26661-9", "Trichinella sp Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SP_IGA_AB_UNITSVOLUME_IN_SERUM ("33587-7", "Trichinella sp IgA Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SP_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE ("56992-1", "Trichinella sp IgG Ab [Presence] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SP_IGG_AB_UNITSVOLUME_IN_SERUM ("32768-4", "Trichinella sp IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SP_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("32723-9", "Trichinella sp IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM ("31687-7", "Trichinella sp IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	TRICHINELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("27426-6", "Trichinella sp IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	TRIMETHOPRIM_SULFAMETHOXAZOLE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("20387-7", "Trimethoprim+Sulfamethoxazole [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	TRIMETHOPRIM_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23614-1", "Trimethoprim [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	VACCINIA_VIRUS_AB_UNITSVOLUME_IN_SERUM ("5400-7", "Vaccinia virus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	VACCINIA_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("35390-4", "Vaccinia virus DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	VANCOMYCIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("25228-8", "Vancomycin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	VANCOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23615-8", "Vancomycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	VARIOLA_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41856-6", "Variola virus DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	VIBRIO_CHOLERAE ("75953000", "Vibrio cholerae", "18725-2", "initials", "20130527", "N/A"),
	VIBRIO_CHOLERAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("61371-1", "Vibrio cholerae DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	VIBRIO_CHOLERAE_TOXIN_AG_PRESENCE_IN_ISOLATE_QUALITATIVE ("53941-1", "Vibrio cholerae toxin Ag [Presence] in Isolate Qualitative", "18725-2", "initials", "20130527", "N/A"),
	VIBRIO_CHOLERAE_TOXIN_GENE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("53942-9", "Vibrio cholerae toxin gene [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "initials", "20130527", "N/A"),
	VIBRIO_SP_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE ("6579-7", "Vibrio sp identified in Stool by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	VIBRIO_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("6581-3", "Vibrio sp identified in Unspecified specimen by Organism specific culture", "18725-2", "initials", "20130527", "N/A"),
	VIOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA ("23616-6", "Viomycin [Susceptibility] by Method for Slow-growing mycobacteria", "18769-0", "conditional", "20130527", "N/A"),
	VIRUS_2_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("17975-4", "Virus # 2 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("17976-2", "Virus # 3 identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_AMNIOTIC_FLUID_BY_CULTURE ("11484-3", "Virus identified in Amniotic fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_BLOOD_BY_CULTURE ("5883-4", "Virus identified in Blood by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_BLOOD_BY_IMMUNOFLUORESCENCE ("14489-9", "Virus identified in Blood by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_BODY_FLUID_BY_CULTURE ("40479-8", "Virus identified in Body fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_CEREBRAL_SPINAL_FLUID_BY_CULTURE ("5884-2", "Virus identified in Cerebral spinal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_CEREBRAL_SPINAL_FLUID_BY_ELECTRON_MICROSCOPY ("10736-7", "Virus identified in Cerebral spinal fluid by Electron microscopy", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE ("14488-1", "Virus identified in Cerebral spinal fluid by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_CERVIX_BY_CULTURE ("14452-7", "Virus identified in Cervix by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_CERVIX_BY_IMMUNOFLUORESCENCE ("14493-1", "Virus identified in Cervix by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_EYE_BY_CULTURE ("14451-9", "Virus identified in Eye by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_EYE_BY_IMMUNOFLUORESCENCE ("14492-3", "Virus identified in Eye by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_CULTURE ("40480-6", "Virus identified in Genital specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_ISOLATE ("42808-6", "Virus identified in Isolate", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_ISOLATE_BY_CULTURE ("6608-4", "Virus identified in Isolate by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_ISOLATE_BY_VIRAL_SUBTYPING ("615-5", "Virus identified in Isolate by Viral subtyping", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_LUNG_TISSUE_BY_CULTURE ("72374-2", "Virus identified in Lung tissue by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_NASOPHARYNX_BY_CULTURE ("72373-4", "Virus identified in Nasopharynx by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_NOSE_BY_CULTURE ("14454-3", "Virus identified in Nose by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_PENIS_BY_CULTURE ("14459-2", "Virus identified in Penis by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_PENIS_BY_IMMUNOFLUORESCENCE ("14497-2", "Virus identified in Penis by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE ("14456-8", "Virus identified in Peritoneal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_PLEURAL_FLUID_BY_CULTURE ("14455-0", "Virus identified in Pleural fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_SEMEN_BY_CULTURE ("6583-9", "Virus identified in Semen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_SEMEN_BY_IMMUNOFLUORESCENCE ("14490-7", "Virus identified in Semen by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_SKIN_BY_CULTURE ("5885-9", "Virus identified in Skin by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_SPUTUM_BY_CULTURE ("14458-4", "Virus identified in Sputum by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_SPUTUM_BY_IMMUNOFLUORESCENCE ("14496-4", "Virus identified in Sputum by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_STOOL_BY_CULTURE ("5886-7", "Virus identified in Stool by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_STOOL_BY_ELECTRON_MICROSCOPY ("10737-5", "Virus identified in Stool by Electron microscopy", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_THROAT_BY_CULTURE ("5887-5", "Virus identified in Throat by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_THROAT_BY_IMMUNOFLUORESCENCE ("14491-5", "Virus identified in Throat by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_TISSUE_BY_CULTURE ("5888-3", "Virus identified in Tissue by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_TISSUE_BY_ELECTRON_MICROSCOPY ("10738-3", "Virus identified in Tissue by Electron microscopy", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN ("41461-5", "Virus identified in Unspecified specimen", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE ("6584-7", "Virus identified in Unspecified specimen by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ELECTRON_MICROSCOPY ("10739-1", "Virus identified in Unspecified specimen by Electron microscopy", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("12272-1", "Virus identified in Unspecified specimen by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_SHELL_VIAL_CULTURE ("50024-9", "Virus identified in Unspecified specimen by Shell vial culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_URETHRA_BY_CULTURE ("14460-0", "Virus identified in Urethra by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_URETHRA_BY_IMMUNOFLUORESCENCE ("14498-0", "Virus identified in Urethra by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_URINE_BY_CULTURE ("14457-6", "Virus identified in Urine by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_URINE_SEDIMENT_BY_IMMUNOFLUORESCENCE ("14495-6", "Virus identified in Urine sediment by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_VAGINAL_FLUID_BY_CULTURE ("14453-5", "Virus identified in Vaginal fluid by Culture", "18725-2", "conditional", "20130527", "N/A"),
	VIRUS_IDENTIFIED_IN_VAGINAL_FLUID_BY_IMMUNOFLUORESCENCE ("14494-9", "Virus identified in Vaginal fluid by Immunofluorescence", "18725-2", "conditional", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("41224-7", "West Nile virus Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_NEUTRALIZATION_TEST ("29570-9", "West Nile virus Ab [Titer] in Cerebral spinal fluid by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_TITER_IN_SERUM ("41225-4", "West Nile virus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION ("55380-0", "West Nile virus Ab [Titer] in Serum by Hemagglutination inhibition", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST ("29568-3", "West Nile virus Ab [Titer] in Serum by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_TITER_IN_UNSPECIFIED_SPECIMEN ("29781-2", "West Nile virus Ab [Titer] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_TITER_IN_UNSPECIFIED_SPECIMEN_BY_NEUTRALIZATION_TEST ("29779-6", "West Nile virus Ab [Titer] in Unspecified specimen by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("41206-4", "West Nile virus Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_UNITSVOLUME_IN_SERUM ("39555-8", "West Nile virus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("41194-2", "West Nile virus Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN ("31700-8", "West Nile virus Ab [Units/volume] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AG_PRESENCE_IN_BLOOD_OR_MARROW_FROM_DONOR ("50015-7", "West Nile virus Ag [Presence] in Blood or Marrow from donor", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN ("32371-7", "West Nile virus Ag [Presence] in Tissue by Immune stain", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("41643-8", "West Nile virus Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGG_AB_TITER_IN_BODY_FLUID ("41196-7", "West Nile virus IgG Ab [Titer] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("33328-6", "West Nile virus IgG Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGG_AB_TITER_IN_SERUM ("33329-4", "West Nile virus IgG Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("29537-8", "West Nile virus IgG Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("39572-3", "West Nile virus IgG Ab [Units/volume] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM ("29535-2", "West Nile virus IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("38997-3", "West Nile virus IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOASSAY ("62436-1", "West Nile virus IgM Ab [Presence] in Body fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID ("31703-2", "West Nile virus IgM Ab [Presence] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("29569-1", "West Nile virus IgM Ab [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_SERUM ("31704-0", "West Nile virus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY ("29567-5", "West Nile virus IgM Ab [Presence] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("29780-4", "West Nile virus IgM Ab [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("29778-8", "West Nile virus IgM Ab [Presence] in Unspecified specimen by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("41642-0", "West Nile virus IgM Ab [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_TITER_IN_BODY_FLUID ("41195-9", "West Nile virus IgM Ab [Titer] in Body fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID ("33330-2", "West Nile virus IgM Ab [Titer] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("43342-5", "West Nile virus IgM Ab [Titer] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_TITER_IN_SERUM ("33331-0", "West Nile virus IgM Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("43343-3", "West Nile virus IgM Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID ("29538-6", "West Nile virus IgM Ab [Units/volume] in Cerebral spinal fluid", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("39573-1", "West Nile virus IgM Ab [Units/volume] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("29536-0", "West Nile virus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("38166-5", "West Nile virus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_POLYVALENT_E_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN ("36900-9", "West Nile virus polyvalent E Ab [Presence] in Unspecified specimen", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_POLYVALENT_E_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY ("36896-9", "West Nile virus polyvalent E Ab [Presence] in Unspecified specimen by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_RNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("34460-6", "West Nile virus RNA [Presence] in Blood by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_RNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("34461-4", "West Nile virus RNA [Presence] in Cerebral spinal fluid by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("32361-8", "West Nile virus RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_RNA_PRESENCE_IN_SERUM_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("41212-2", "West Nile virus RNA [Presence] in Serum from donor by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_RNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("32370-9", "West Nile virus RNA [Presence] in Tissue by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE ("37985-9", "West Nile virus RNA [Presence] in Unspecified specimen by DNA probe", "18725-2", "none", "20130527", "N/A"),
	WEST_NILE_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("34892-0", "West Nile virus RNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_NEUTRALIZATION_TEST ("71783-5", "Yellow fever virus Ab [Titer] in Cerebral spinal fluid by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_AB_TITER_IN_SERUM ("22618-3", "Yellow fever virus Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_AB_TITER_IN_SERUM_1ST_SPECIMEN ("41247-8", "Yellow fever virus Ab [Titer] in Serum --1st specimen", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_AB_TITER_IN_SERUM_2ND_SPECIMEN ("41246-0", "Yellow fever virus Ab [Titer] in Serum --2nd specimen", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE ("6589-6", "Yellow fever virus Ab [Titer] in Serum by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_AB_UNITSVOLUME_IN_SERUM ("8054-9", "Yellow fever virus Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_NEUTRALIZATION_TEST ("6591-2", "Yellow fever virus Ab [Units/volume] in Serum by Neutralization test", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM ("8055-6", "Yellow fever virus IgG Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("6592-0", "Yellow fever virus IgG Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY ("71782-7", "Yellow fever virus IgM Ab [Presence] in Cerebral spinal fluid by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_IGM_AB_PRESENCE_IN_SERUM ("41216-3", "Yellow fever virus IgM Ab [Presence] in Serum", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM ("8056-4", "Yellow fever virus IgM Ab [Units/volume] in Serum", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY ("6593-8", "Yellow fever virus IgM Ab [Units/volume] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	YELLOW_FEVER_VIRUS_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("8057-2", "Yellow fever virus RNA [Presence] in Serum by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_AB_TITER_IN_SERUM ("33707-1", "Yersinia pestis Ab [Titer] in Serum", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_AB_TITER_IN_SERUM_BY_IMMUNOASSAY ("33690-9", "Yersinia pestis Ab [Titer] in Serum by Immunoassay", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE ("33688-3", "Yersinia pestis Ag [Presence] in Isolate by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE ("33687-5", "Yersinia pestis Ag [Presence] in Unspecified specimen by Immunofluorescence", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_DNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("33692-5", "Yersinia pestis DNA [Presence] in Isolate by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD ("33691-7", "Yersinia pestis DNA [Presence] in Unspecified specimen by Probe and target amplification method", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_PRESENCE_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE ("33686-7", "Yersinia pestis [Presence] in Isolate by Organism specific culture", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_PRESENCE_IN_ISOLATE_BY_PHAGE_LYSIS ("33693-3", "Yersinia pestis [Presence] in Isolate by Phage lysis", "18725-2", "none", "20130527", "N/A"),
	YERSINIA_PESTIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE ("33685-9", "Yersinia pestis [Presence] in Unspecified specimen by Organism specific culture", "18725-2", "none", "20130527", "N/A");

	/** 
	*<div class="en">Code for Abnormal Prion Protein [Presence] in Brain by Electron microscopy</div>
	*/
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_ELECTRON_MICROSCOPY_CODE="23381-7";

	/** 
	*<div class="en">Code for Abnormal Prion Protein [Presence] in Brain by Immune stain</div>
	*/
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_IMMUNE_STAIN_CODE="23380-9";

	/** 
	*<div class="en">Code for Abnormal Prion Protein [Presence] in Brain by Immunoassay</div>
	*/
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_IMMUNOASSAY_CODE="37425-6";

	/** 
	*<div class="en">Code for Abnormal Prion Protein [Presence] in Brain by Immunoblot (IB)</div>
	*/
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_IMMUNOBLOT_IB_CODE="23379-1";

	/** 
	*<div class="en">Code for Abnormal Prion Protein [Presence] in Brain by Light microscopy</div>
	*/
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_LIGHT_MICROSCOPY_CODE="38275-4";

	/** 
	*<div class="en">Code for Abnormal Prion Protein [Presence] in Tissue by Immune stain</div>
	*/
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN_CODE="39020-3";

	/** 
	*<div class="en">Code for Abnormal Prion Protein [Presence] in Tissue by Immunoassay</div>
	*/
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_TISSUE_BY_IMMUNOASSAY_CODE="39021-1";

	/** 
	*<div class="en">Code for Abnormal Prion Protein [Presence] in Tissue by Immunoblot (IB)</div>
	*/
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_TISSUE_BY_IMMUNOBLOT_IB_CODE="39320-7";

	/** 
	*<div class="en">Code for Amikacin 12 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_12_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25177-7";

	/** 
	*<div class="en">Code for Amikacin 16 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_16_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25175-1";

	/** 
	*<div class="en">Code for Amikacin 1.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_1_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="48169-7";

	/** 
	*<div class="en">Code for Amikacin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="60564-2";

	/** 
	*<div class="en">Code for Amikacin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="42642-9";

	/** 
	*<div class="en">Code for Amikacin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25178-5";

	/** 
	*<div class="en">Code for Amikacin 32 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_32_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25176-9";

	/** 
	*<div class="en">Code for Amikacin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="60565-9";

	/** 
	*<div class="en">Code for Amikacin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25179-3";

	/** 
	*<div class="en">Code for Amikacin 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25174-4";

	/** 
	*<div class="en">Code for Amikacin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMIKACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20373-7";

	/** 
	*<div class="en">Code for Amoxicillin+Clavulanate [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMOXICILLIN_CLAVULANATE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25310-4";

	/** 
	*<div class="en">Code for Ampicillin+Sulbactam [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AMPICILLIN_SULBACTAM_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20374-5";

	/** 
	*<div class="en">Code for Arbovirus identified in Blood by Organism specific culture</div>
	*/
	public static final String ARBOVIRUS_IDENTIFIED_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6309-9";

	/** 
	*<div class="en">Code for Arbovirus identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String ARBOVIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6310-7";

	/** 
	*<div class="en">Code for Arenavirus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String ARENAVIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41621-4";

	/** 
	*<div class="en">Code for Azithromycin+Ethambutol [Susceptibility] by Minimum inhibitory concentration (MIC)</div>
	*/
	public static final String AZITHROMYCIN_ETHAMBUTOL_SUSCEPTIBILITY_BY_MINIMUM_INHIBITORY_CONCENTRATION_MIC_CODE="16421-0";

	/** 
	*<div class="en">Code for Azithromycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String AZITHROMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23612-5";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Presence] in Serum</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_CODE="22860-1";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Presence] in Serum by Agglutination</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION_CODE="22862-7";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Presence] in Serum by Complement fixation</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="22864-3";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Presence] in Serum by Immune diffusion (ID)</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_BY_IMMUNE_DIFFUSION_ID_CODE="22861-9";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="22863-5";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Titer] in Serum</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_TITER_IN_SERUM_CODE="22859-3";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Titer] in Serum by Immune diffusion (ID)</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_TITER_IN_SERUM_BY_IMMUNE_DIFFUSION_ID_CODE="22865-0";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Units/volume] in Serum</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_SERUM_CODE="7814-7";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Units/volume] in Serum by Hemagglutination</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_SERUM_BY_HEMAGGLUTINATION_CODE="5055-9";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Units/volume] in Serum by Immunoblot (IB)</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="11467-8";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Units/volume] in Unspecified specimen</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_CODE="22109-3";

	/** 
	*<div class="en">Code for Bacillus anthracis Ab [Units/volume] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="11468-6";

	/** 
	*<div class="en">Code for Bacillus anthracis Ag [Presence] in Isolate by Immunofluorescence</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE_CODE="33697-4";

	/** 
	*<div class="en">Code for Bacillus anthracis Ag [Presence] in Tissue by Immunofluorescence</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE_CODE="22866-8";

	/** 
	*<div class="en">Code for Bacillus anthracis Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31726-3";

	/** 
	*<div class="en">Code for Bacillus anthracis Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String BACILLUS_ANTHRACIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="22867-6";

	/** 
	*<div class="en">Code for Bacillus anthracis capsule Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String BACILLUS_ANTHRACIS_CAPSULE_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="51976-9";

	/** 
	*<div class="en">Code for Bacillus anthracis cell wall Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String BACILLUS_ANTHRACIS_CELL_WALL_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="44269-9";

	/** 
	*<div class="en">Code for Bacillus anthracis DNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String BACILLUS_ANTHRACIS_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41622-2";

	/** 
	*<div class="en">Code for Bacillus anthracis DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String BACILLUS_ANTHRACIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41623-0";

	/** 
	*<div class="en">Code for Bacillus anthracis [Presence] in Isolate by Phage lysis</div>
	*/
	public static final String BACILLUS_ANTHRACIS_PRESENCE_IN_ISOLATE_BY_PHAGE_LYSIS_CODE="33698-2";

	/** 
	*<div class="en">Code for Bacillus anthracis [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String BACILLUS_ANTHRACIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="11469-4";

	/** 
	*<div class="en">Code for Bacillus anthracis spore Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String BACILLUS_ANTHRACIS_SPORE_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="44270-7";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Blood by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE_CODE="17929-1";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Blood by Anaerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_BLOOD_BY_ANAEROBE_CULTURE_CODE="17935-8";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Blood by Culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_BLOOD_BY_CULTURE_CODE="48727-2";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Body fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE_CODE="17951-5";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Body fluid by Anaerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_BODY_FLUID_BY_ANAEROBE_CULTURE_CODE="17957-2";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Bone by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE_CODE="17873-1";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Bronchial specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17878-0";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Burn by Culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_BURN_BY_CULTURE_CODE="17937-4";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Duodenal fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_DUODENAL_FLUID_BY_AEROBE_CULTURE_CODE="53614-4";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Genital specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17883-0";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Line specimen by IV Line culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE_CODE="17942-4";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Nose by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE_CODE="17888-9";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Nose by Anaerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_NOSE_BY_ANAEROBE_CULTURE_CODE="17921-8";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Peritoneal fluid by Culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE_CODE="17959-8";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Sputum by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE_CODE="17893-9";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Stool by Culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_STOOL_BY_CULTURE_CODE="17964-8";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Throat by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE_CODE="17899-6";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Tissue by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE_CODE="17904-4";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Tissue by Anaerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_TISSUE_BY_ANAEROBE_CULTURE_CODE="17923-4";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Unspecified specimen by Anaerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE_CODE="44843-1";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Unspecified specimen by Culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="44841-5";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Unspecified specimen by Respiratory culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE_CODE="48561-5";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Urine by Culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="17970-5";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Wound deep by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE_CODE="17910-1";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Wound deep by Anaerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_WOUND_DEEP_BY_ANAEROBE_CULTURE_CODE="17926-7";

	/** 
	*<div class="en">Code for Bacteria # 2 identified in Wound shallow by Aerobe culture</div>
	*/
	public static final String BACTERIA_2_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE_CODE="17916-8";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Blood by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE_CODE="17930-9";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Blood by Anaerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_BLOOD_BY_ANAEROBE_CULTURE_CODE="17936-6";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Blood by Culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_BLOOD_BY_CULTURE_CODE="48724-9";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Body fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE_CODE="17952-3";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Body fluid by Anaerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_BODY_FLUID_BY_ANAEROBE_CULTURE_CODE="17958-0";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Bone by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE_CODE="17874-9";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Bronchial specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17879-8";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Burn by Culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_BURN_BY_CULTURE_CODE="17938-2";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Duodenal fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_DUODENAL_FLUID_BY_AEROBE_CULTURE_CODE="53615-1";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Genital specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17884-8";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Line specimen by IV Line culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE_CODE="17943-2";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Nose by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE_CODE="17889-7";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Nose by Anaerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_NOSE_BY_ANAEROBE_CULTURE_CODE="17922-6";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Peritoneal fluid by Culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE_CODE="17960-6";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Sputum by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE_CODE="17894-7";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Stool by Culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_STOOL_BY_CULTURE_CODE="17965-5";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Throat by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE_CODE="17900-2";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Tissue by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE_CODE="17905-1";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Tissue by Anaerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_TISSUE_BY_ANAEROBE_CULTURE_CODE="17924-2";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Unspecified specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_AEROBE_CULTURE_CODE="48567-2";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Unspecified specimen by Anaerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE_CODE="44853-0";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Unspecified specimen by Culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="44842-3";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Unspecified specimen by Respiratory culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE_CODE="48562-3";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Urine by Culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="17971-3";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Wound deep by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE_CODE="17911-9";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Wound deep by Anaerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_WOUND_DEEP_BY_ANAEROBE_CULTURE_CODE="17927-5";

	/** 
	*<div class="en">Code for Bacteria # 3 identified in Wound shallow by Aerobe culture</div>
	*/
	public static final String BACTERIA_3_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE_CODE="17917-6";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Blood by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE_CODE="17931-7";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Body fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE_CODE="17953-1";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Bone by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE_CODE="17875-6";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Bronchial specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17880-6";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Burn by Culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_BURN_BY_CULTURE_CODE="17939-0";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Duodenal fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_DUODENAL_FLUID_BY_AEROBE_CULTURE_CODE="53616-9";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Genital specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17885-5";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Line specimen by IV Line culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE_CODE="17944-0";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Nose by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE_CODE="17890-5";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Peritoneal fluid by Culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE_CODE="17961-4";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Sputum by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE_CODE="17895-4";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Stool by Culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_STOOL_BY_CULTURE_CODE="17966-3";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Throat by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE_CODE="17901-0";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Tissue by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE_CODE="17906-9";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Tissue by Anaerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_TISSUE_BY_ANAEROBE_CULTURE_CODE="59051-3";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Unspecified specimen by Anaerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE_CODE="44856-3";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Unspecified specimen by Culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="44844-9";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Unspecified specimen by Respiratory culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE_CODE="48563-1";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Urine by Culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="17972-1";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Wound deep by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE_CODE="17912-7";

	/** 
	*<div class="en">Code for Bacteria # 4 identified in Wound shallow by Aerobe culture</div>
	*/
	public static final String BACTERIA_4_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE_CODE="17918-4";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Blood by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE_CODE="17932-5";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Body fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE_CODE="17954-9";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Bone by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE_CODE="17876-4";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Bronchial specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17881-4";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Burn by Culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_BURN_BY_CULTURE_CODE="17940-8";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Genital specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17886-3";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Line specimen by IV Line culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE_CODE="17945-7";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Nose by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE_CODE="17891-3";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Peritoneal fluid by Culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE_CODE="17962-2";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Sputum by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE_CODE="17896-2";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Stool by Culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_STOOL_BY_CULTURE_CODE="17967-1";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Throat by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE_CODE="17902-8";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Tissue by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE_CODE="17907-7";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Unspecified specimen by Anaerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE_CODE="44857-1";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Unspecified specimen by Culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="44845-6";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Unspecified specimen by Respiratory culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE_CODE="48564-9";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Urine by Culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="17973-9";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Wound deep by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE_CODE="17913-5";

	/** 
	*<div class="en">Code for Bacteria # 5 identified in Wound shallow by Aerobe culture</div>
	*/
	public static final String BACTERIA_5_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE_CODE="17919-2";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Blood by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE_CODE="17933-3";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Body fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE_CODE="17955-6";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Bone by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE_CODE="17877-2";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Bronchial specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17882-2";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Burn by Culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_BURN_BY_CULTURE_CODE="17941-6";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Genital specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="17887-1";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Line specimen by IV Line culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE_CODE="17946-5";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Nose by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE_CODE="17892-1";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Peritoneal fluid by Culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE_CODE="17963-0";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Sputum by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE_CODE="17897-0";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Stool by Culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_STOOL_BY_CULTURE_CODE="17968-9";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Throat by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE_CODE="17903-6";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Tissue by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE_CODE="17908-5";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Unspecified specimen by Anaerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE_CODE="44858-9";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Unspecified specimen by Culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="44846-4";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Unspecified specimen by Respiratory culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE_CODE="48565-6";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Urine by Culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="17974-7";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Wound deep by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE_CODE="17914-3";

	/** 
	*<div class="en">Code for Bacteria # 6 identified in Wound shallow by Aerobe culture</div>
	*/
	public static final String BACTERIA_6_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE_CODE="17920-0";

	/** 
	*<div class="en">Code for Bacteria # 7 identified in Genital specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_7_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="47293-6";

	/** 
	*<div class="en">Code for Bacteria # 7 identified in Unspecified specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_7_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_AEROBE_CULTURE_CODE="48568-0";

	/** 
	*<div class="en">Code for Bacteria # 7 identified in Unspecified specimen by Anaerobe culture</div>
	*/
	public static final String BACTERIA_7_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE_CODE="44859-7";

	/** 
	*<div class="en">Code for Bacteria # 7 identified in Unspecified specimen by Culture</div>
	*/
	public static final String BACTERIA_7_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="44848-0";

	/** 
	*<div class="en">Code for Bacteria # 7 identified in Unspecified specimen by Respiratory culture</div>
	*/
	public static final String BACTERIA_7_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE_CODE="48566-4";

	/** 
	*<div class="en">Code for Bacteria # 7 identified in Urine by Culture</div>
	*/
	public static final String BACTERIA_7_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="44847-2";

	/** 
	*<div class="en">Code for Bacteria # 7 identified in Wound shallow by Aerobe culture</div>
	*/
	public static final String BACTERIA_7_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE_CODE="47294-4";

	/** 
	*<div class="en">Code for Bacteria # 8 identified in Unspecified specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_8_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_AEROBE_CULTURE_CODE="48569-8";

	/** 
	*<div class="en">Code for Bacteria # 8 identified in Unspecified specimen by Culture</div>
	*/
	public static final String BACTERIA_8_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="44850-6";

	/** 
	*<div class="en">Code for Bacteria # 8 identified in Urine by Culture</div>
	*/
	public static final String BACTERIA_8_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="44849-8";

	/** 
	*<div class="en">Code for Bacteria # 8 identified in Wound shallow by Aerobe culture</div>
	*/
	public static final String BACTERIA_8_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE_CODE="47295-1";

	/** 
	*<div class="en">Code for Bacteria [#/area] in Synovial fluid by Microscopy high power field</div>
	*/
	public static final String BACTERIA_AREA_IN_SYNOVIAL_FLUID_BY_MICROSCOPY_HIGH_POWER_FIELD_CODE="11101-3";

	/** 
	*<div class="en">Code for Bacteria Identification [Presence] in Isolate by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFICATION_PRESENCE_IN_ISOLATE_BY_CULTURE_CODE="45335-7";

	/** 
	*<div class="en">Code for Bacteria identified in 24 hour Urine by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_24_HOUR_URINE_BY_CULTURE_CODE="13315-7";

	/** 
	*<div class="en">Code for Bacteria identified in Abscess by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ABSCESS_BY_AEROBE_CULTURE_CODE="595-9";

	/** 
	*<div class="en">Code for Bacteria identified in Amniotic fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_AMNIOTIC_FLUID_BY_CULTURE_CODE="596-7";

	/** 
	*<div class="en">Code for Bacteria identified in Anal by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ANAL_BY_CULTURE_CODE="52966-9";

	/** 
	*<div class="en">Code for Bacteria identified in Aspirate by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ASPIRATE_BY_AEROBE_CULTURE_CODE="597-5";

	/** 
	*<div class="en">Code for Bacteria identified in Aspirate by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ASPIRATE_BY_ANAEROBE_CULTURE_CODE="598-3";

	/** 
	*<div class="en">Code for Bacteria identified in Aspirate by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ASPIRATE_BY_CULTURE_CODE="43411-8";

	/** 
	*<div class="en">Code for Bacteria identified in Bile fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BILE_FLUID_BY_CULTURE_CODE="53911-4";

	/** 
	*<div class="en">Code for Bacteria identified in Blood by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE_CODE="17928-3";

	/** 
	*<div class="en">Code for Bacteria identified in Blood by Aerobe culture 25 degree C incubation</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BLOOD_BY_AEROBE_CULTURE_25_DEGREE_C_INCUBATION_CODE="45275-5";

	/** 
	*<div class="en">Code for Bacteria identified in Blood by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BLOOD_BY_ANAEROBE_CULTURE_CODE="17934-1";

	/** 
	*<div class="en">Code for Bacteria identified in Blood by Anaerobe culture 25 degree C incubation</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BLOOD_BY_ANAEROBE_CULTURE_25_DEGREE_C_INCUBATION_CODE="45276-3";

	/** 
	*<div class="en">Code for Bacteria identified in Blood by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BLOOD_BY_CULTURE_CODE="600-7";

	/** 
	*<div class="en">Code for Bacteria identified in Body fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BODY_FLUID_BY_AEROBE_CULTURE_CODE="610-6";

	/** 
	*<div class="en">Code for Bacteria identified in Body fluid by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BODY_FLUID_BY_ANAEROBE_CULTURE_CODE="17956-4";

	/** 
	*<div class="en">Code for Bacteria identified in Body fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BODY_FLUID_BY_CULTURE_CODE="611-4";

	/** 
	*<div class="en">Code for Bacteria identified in Bone by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BONE_BY_AEROBE_CULTURE_CODE="602-3";

	/** 
	*<div class="en">Code for Bacteria identified in Bone marrow by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BONE_MARROW_BY_AEROBE_CULTURE_CODE="19126-2";

	/** 
	*<div class="en">Code for Bacteria identified in Bone marrow by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BONE_MARROW_BY_CULTURE_CODE="60258-1";

	/** 
	*<div class="en">Code for Bacteria identified in Bronchial brush by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BRONCHIAL_BRUSH_BY_AEROBE_CULTURE_CODE="43442-3";

	/** 
	*<div class="en">Code for Bacteria identified in Bronchial specimen</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_CODE="32810-4";

	/** 
	*<div class="en">Code for Bacteria identified in Bronchial specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="604-9";

	/** 
	*<div class="en">Code for Bacteria identified in Bronchoalveolar lavage by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BRONCHOALVEOLAR_LAVAGE_BY_AEROBE_CULTURE_CODE="43441-5";

	/** 
	*<div class="en">Code for Bacteria identified in Burn by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_BURN_BY_CULTURE_CODE="603-1";

	/** 
	*<div class="en">Code for Bacteria identified in Cannula specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_CANNULA_SPECIMEN_BY_AEROBE_CULTURE_CODE="605-6";

	/** 
	*<div class="en">Code for Bacteria identified in Catheter tip by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_CATHETER_TIP_BY_CULTURE_CODE="19128-8";

	/** 
	*<div class="en">Code for Bacteria identified in Cerebral spinal fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_CEREBRAL_SPINAL_FLUID_BY_CULTURE_CODE="606-4";

	/** 
	*<div class="en">Code for Bacteria identified in Cervix by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_CERVIX_BY_AEROBE_CULTURE_CODE="14475-8";

	/** 
	*<div class="en">Code for Bacteria identified in Cervix by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_CERVIX_BY_ANAEROBE_CULTURE_CODE="12281-2";

	/** 
	*<div class="en">Code for Bacteria identified in Cervix by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_CERVIX_BY_CULTURE_CODE="43410-0";

	/** 
	*<div class="en">Code for Bacteria identified in Contact lens by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_CONTACT_LENS_BY_CULTURE_CODE="56714-9";

	/** 
	*<div class="en">Code for Bacteria identified in Cornea by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_CORNEA_BY_CULTURE_CODE="60257-3";

	/** 
	*<div class="en">Code for Bacteria identified in Dialysis fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_DIALYSIS_FLUID_BY_CULTURE_CODE="9822-8";

	/** 
	*<div class="en">Code for Bacteria identified in Drain by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_DRAIN_BY_AEROBE_CULTURE_CODE="607-2";

	/** 
	*<div class="en">Code for Bacteria identified in Duodenal fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_DUODENAL_FLUID_BY_AEROBE_CULTURE_CODE="53617-7";

	/** 
	*<div class="en">Code for Bacteria identified in Ear by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_EAR_BY_AEROBE_CULTURE_CODE="608-0";

	/** 
	*<div class="en">Code for Bacteria identified in embryo by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_EMBRYO_BY_AEROBE_CULTURE_CODE="20694-6";

	/** 
	*<div class="en">Code for Bacteria identified in Esophageal brushing by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ESOPHAGEAL_BRUSHING_BY_CULTURE_CODE="53908-0";

	/** 
	*<div class="en">Code for Bacteria identified in Eye by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_EYE_BY_AEROBE_CULTURE_CODE="609-8";

	/** 
	*<div class="en">Code for Bacteria identified in Gastric fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_GASTRIC_FLUID_BY_CULTURE_CODE="52967-7";

	/** 
	*<div class="en">Code for Bacteria identified in Genital specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_AEROBE_CULTURE_CODE="10352-3";

	/** 
	*<div class="en">Code for Bacteria identified in Isolate</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ISOLATE_CODE="42803-7";

	/** 
	*<div class="en">Code for Bacteria identified in Isolate by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ISOLATE_BY_AEROBE_CULTURE_CODE="32367-5";

	/** 
	*<div class="en">Code for Bacteria identified in Isolate by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ISOLATE_BY_ANAEROBE_CULTURE_CODE="20878-5";

	/** 
	*<div class="en">Code for Bacteria identified in Isolate by Animal inoculation</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ISOLATE_BY_ANIMAL_INOCULATION_CODE="20877-7";

	/** 
	*<div class="en">Code for Bacteria identified in Isolate by Bacteria subtyping</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ISOLATE_BY_BACTERIA_SUBTYPING_CODE="612-2";

	/** 
	*<div class="en">Code for Bacteria identified in Isolate by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ISOLATE_BY_CULTURE_CODE="43409-2";

	/** 
	*<div class="en">Code for Bacteria identified in Isolate by Pulsed-Field Gel Electrophoresis (PFGE)</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ISOLATE_BY_PULSED_FIELD_GEL_ELECTROPHORESIS_PFGE_CODE="42661-9";

	/** 
	*<div class="en">Code for Bacteria identified in Line specimen by IV Line culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_LINE_SPECIMEN_BY_IV_LINE_CULTURE_CODE="616-3";

	/** 
	*<div class="en">Code for Bacteria identified in Nasopharynx by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_NASOPHARYNX_BY_AEROBE_CULTURE_CODE="43426-6";

	/** 
	*<div class="en">Code for Bacteria identified in Nasopharynx by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_NASOPHARYNX_BY_CULTURE_CODE="43214-6";

	/** 
	*<div class="en">Code for Bacteria identified in Nose by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_NOSE_BY_AEROBE_CULTURE_CODE="10353-1";

	/** 
	*<div class="en">Code for Bacteria identified in Penis by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_PENIS_BY_AEROBE_CULTURE_CODE="14478-2";

	/** 
	*<div class="en">Code for Bacteria identified in Pericardial fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_PERICARDIAL_FLUID_BY_CULTURE_CODE="56715-6";

	/** 
	*<div class="en">Code for Bacteria identified in Peritoneal dialysis fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_PERITONEAL_DIALYSIS_FLUID_BY_CULTURE_CODE="60032-0";

	/** 
	*<div class="en">Code for Bacteria identified in Peritoneal fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE_CODE="619-7";

	/** 
	*<div class="en">Code for Bacteria identified in Placenta by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_PLACENTA_BY_AEROBE_CULTURE_CODE="617-1";

	/** 
	*<div class="en">Code for Bacteria identified in Pleural fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_PLEURAL_FLUID_BY_AEROBE_CULTURE_CODE="17279-1";

	/** 
	*<div class="en">Code for Bacteria identified in Pleural fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_PLEURAL_FLUID_BY_CULTURE_CODE="618-9";

	/** 
	*<div class="en">Code for Bacteria identified in Semen</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SEMEN_CODE="13314-0";

	/** 
	*<div class="en">Code for Bacteria identified in Semen by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SEMEN_BY_CULTURE_CODE="53558-3";

	/** 
	*<div class="en">Code for Bacteria identified in Sinus by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SINUS_BY_CULTURE_CODE="43307-8";

	/** 
	*<div class="en">Code for Bacteria identified in Skin by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SKIN_BY_AEROBE_CULTURE_CODE="620-5";

	/** 
	*<div class="en">Code for Bacteria identified in Sputum by Acute Respiratoy Distress (ARDS) culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SPUTUM_BY_ACUTE_RESPIRATOY_DISTRESS_ARDS_CULTURE_CODE="19127-0";

	/** 
	*<div class="en">Code for Bacteria identified in Sputum by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SPUTUM_BY_AEROBE_CULTURE_CODE="622-1";

	/** 
	*<div class="en">Code for Bacteria identified in Sputum by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SPUTUM_BY_CULTURE_CODE="6460-0";

	/** 
	*<div class="en">Code for Bacteria identified in Sputum by Cystic fibrosis respiratory culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SPUTUM_BY_CYSTIC_FIBROSIS_RESPIRATORY_CULTURE_CODE="623-9";

	/** 
	*<div class="en">Code for Bacteria identified in Sputum by Respiratory culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SPUTUM_BY_RESPIRATORY_CULTURE_CODE="624-7";

	/** 
	*<div class="en">Code for Bacteria identified in Sputum tracheal aspirate by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SPUTUM_TRACHEAL_ASPIRATE_BY_CULTURE_CODE="52973-5";

	/** 
	*<div class="en">Code for Bacteria identified in Stool by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_STOOL_BY_ANAEROBE_CULTURE_CODE="6461-8";

	/** 
	*<div class="en">Code for Bacteria identified in Stool by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_STOOL_BY_CULTURE_CODE="625-4";

	/** 
	*<div class="en">Code for Bacteria identified in Synovial fluid by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_SYNOVIAL_FLUID_BY_CULTURE_CODE="621-3";

	/** 
	*<div class="en">Code for Bacteria identified in Throat by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_THROAT_BY_AEROBE_CULTURE_CODE="17898-8";

	/** 
	*<div class="en">Code for Bacteria identified in Throat by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_THROAT_BY_CULTURE_CODE="626-2";

	/** 
	*<div class="en">Code for Bacteria identified in Tissue by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_TISSUE_BY_AEROBE_CULTURE_CODE="627-0";

	/** 
	*<div class="en">Code for Bacteria identified in Tissue by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_TISSUE_BY_ANAEROBE_CULTURE_CODE="628-8";

	/** 
	*<div class="en">Code for Bacteria identified in Tissue by Biopsy culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_TISSUE_BY_BIOPSY_CULTURE_CODE="20474-3";

	/** 
	*<div class="en">Code for Bacteria identified in Tissue by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_TISSUE_BY_CULTURE_CODE="43408-4";

	/** 
	*<div class="en">Code for Bacteria identified in Ulcer by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_ULCER_BY_AEROBE_CULTURE_CODE="629-6";

	/** 
	*<div class="en">Code for Bacteria identified in Unspecified specimen</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_CODE="23667-9";

	/** 
	*<div class="en">Code for Bacteria identified in Unspecified specimen by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_AEROBE_CULTURE_CODE="634-6";

	/** 
	*<div class="en">Code for Bacteria identified in Unspecified specimen by Anaerobe+Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_AEROBE_CULTURE_CODE="21020-3";

	/** 
	*<div class="en">Code for Bacteria identified in Unspecified specimen by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ANAEROBE_CULTURE_CODE="635-3";

	/** 
	*<div class="en">Code for Bacteria identified in Unspecified specimen by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="6463-4";

	/** 
	*<div class="en">Code for Bacteria identified in Unspecified specimen by Respiratory culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_RESPIRATORY_CULTURE_CODE="32355-0";

	/** 
	*<div class="en">Code for Bacteria identified in Unspecified specimen by Sterile body fluid culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_STERILE_BODY_FLUID_CULTURE_CODE="636-1";

	/** 
	*<div class="en">Code for Bacteria identified in Urethra by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_URETHRA_BY_AEROBE_CULTURE_CODE="14477-4";

	/** 
	*<div class="en">Code for Bacteria identified in Urethra by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_URETHRA_BY_CULTURE_CODE="10354-9";

	/** 
	*<div class="en">Code for Bacteria identified in Urine by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="630-4";

	/** 
	*<div class="en">Code for Bacteria identified in Vaginal fluid by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_VAGINAL_FLUID_BY_AEROBE_CULTURE_CODE="11261-5";

	/** 
	*<div class="en">Code for Bacteria identified in Water by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_WATER_BY_CULTURE_CODE="14093-9";

	/** 
	*<div class="en">Code for Bacteria identified in Wound by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_WOUND_BY_AEROBE_CULTURE_CODE="632-0";

	/** 
	*<div class="en">Code for Bacteria identified in Wound by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_WOUND_BY_ANAEROBE_CULTURE_CODE="633-8";

	/** 
	*<div class="en">Code for Bacteria identified in Wound by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_WOUND_BY_CULTURE_CODE="6462-6";

	/** 
	*<div class="en">Code for Bacteria identified in Wound deep by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_WOUND_DEEP_BY_AEROBE_CULTURE_CODE="17909-3";

	/** 
	*<div class="en">Code for Bacteria identified in Wound deep by Anaerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_WOUND_DEEP_BY_ANAEROBE_CULTURE_CODE="17925-9";

	/** 
	*<div class="en">Code for Bacteria identified in Wound deep by Culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_WOUND_DEEP_BY_CULTURE_CODE="43407-6";

	/** 
	*<div class="en">Code for Bacteria identified in Wound shallow by Aerobe culture</div>
	*/
	public static final String BACTERIA_IDENTIFIED_IN_WOUND_SHALLOW_BY_AEROBE_CULTURE_CODE="17915-0";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Body fluid by Light microscopy</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_BODY_FLUID_BY_LIGHT_MICROSCOPY_CODE="41599-2";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Cervix by Wet preparation</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_CERVIX_BY_WET_PREPARATION_CODE="44022-2";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Eye by Light microscopy</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_EYE_BY_LIGHT_MICROSCOPY_CODE="44039-6";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Genital specimen by Wet preparation</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_GENITAL_SPECIMEN_BY_WET_PREPARATION_CODE="12178-0";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Nose by Light microscopy</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_NOSE_BY_LIGHT_MICROSCOPY_CODE="18192-5";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Pericardial fluid by Light microscopy</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_PERICARDIAL_FLUID_BY_LIGHT_MICROSCOPY_CODE="41598-4";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Peritoneal fluid by Light microscopy</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_PERITONEAL_FLUID_BY_LIGHT_MICROSCOPY_CODE="41601-6";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Pleural fluid by Light microscopy</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_PLEURAL_FLUID_BY_LIGHT_MICROSCOPY_CODE="41603-2";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Synovial fluid by Light microscopy</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_SYNOVIAL_FLUID_BY_LIGHT_MICROSCOPY_CODE="41600-8";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Unspecified specimen</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="44038-8";

	/** 
	*<div class="en">Code for Bacteria [Presence] in Unspecified specimen by Wet preparation</div>
	*/
	public static final String BACTERIA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_WET_PREPARATION_CODE="32763-5";

	/** 
	*<div class="en">Code for Bacteria [#/volume] in Mother's milk</div>
	*/
	public static final String BACTERIA_VOLUME_IN_MOTHERS_MILK_CODE="20695-3";

	/** 
	*<div class="en">Code for Brucella</div>
	*/
	public static final String BRUCELLA_CODE="26250004";

	/** 
	*<div class="en">Code for Brucella abortus</div>
	*/
	public static final String BRUCELLA_ABORTUS_CODE="24224000";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="49196-9";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Cerebral spinal fluid by Acidified buffered plate agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_ACIDIFIED_BUFFERED_PLATE_AGGLUTINATION_CODE="51832-4";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Cerebral spinal fluid by Card agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_CARD_AGGLUTINATION_CODE="48967-4";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_CODE="22147-3";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum by Acidified buffered plate agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_ACIDIFIED_BUFFERED_PLATE_AGGLUTINATION_CODE="20727-4";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum by Card agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_CARD_AGGLUTINATION_CODE="20726-6";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="20728-2";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="20730-8";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum by Immunoassay (EIA) RST</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_EIA_RST_CODE="20731-6";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="22920-3";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum by Latex agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5066-6";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Presence] in Serum by Rapid agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_SERUM_BY_RAPID_AGGLUTINATION_CODE="20723-3";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="33945-7";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Cerebral spinal fluid by Antihuman globulin</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_ANTIHUMAN_GLOBULIN_CODE="63435-2";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_CODE="22150-7";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_AGGLUTINATION_CODE="6324-8";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Serum by Antihuman globulin</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_ANTIHUMAN_GLOBULIN_CODE="63437-8";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="6325-5";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Serum by Latex agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5067-4";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Serum by Plate agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_PLATE_AGGLUTINATION_CODE="20729-0";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Serum by Rivanol agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_RIVANOL_AGGLUTINATION_CODE="20722-5";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Titer] in Serum by Tube agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_TITER_IN_SERUM_BY_TUBE_AGGLUTINATION_CODE="20719-1";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_UNITSVOLUME_IN_SERUM_CODE="11586-5";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Units/volume] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_UNITSVOLUME_IN_SERUM_BY_AGGLUTINATION_CODE="22921-1";

	/** 
	*<div class="en">Code for Brucella abortus Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_ABORTUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="19243-5";

	/** 
	*<div class="en">Code for Brucella abortus DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String BRUCELLA_ABORTUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="22927-8";

	/** 
	*<div class="en">Code for Brucella abortus IgA Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGA_AB_UNITSVOLUME_IN_SERUM_CODE="6910-4";

	/** 
	*<div class="en">Code for Brucella abortus IgA+IgG+IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGA_IGG_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="16486-3";

	/** 
	*<div class="en">Code for Brucella abortus IgG1 Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG1_AB_PRESENCE_IN_SERUM_CODE="22924-5";

	/** 
	*<div class="en">Code for Brucella abortus IgG1 Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG1_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="22922-9";

	/** 
	*<div class="en">Code for Brucella abortus IgG1 and IgG2 Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG1_AND_IGG2_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="71715-7";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="42592-6";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_PRESENCE_IN_SERUM_CODE="38243-2";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="23963-2";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="23986-3";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_TITER_IN_SERUM_CODE="16119-0";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="13212-6";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="6911-2";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Units/volume] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_AGGLUTINATION_CODE="16487-1";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Units/volume] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="16488-9";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="43843-2";

	/** 
	*<div class="en">Code for Brucella abortus IgG Ab [Units/volume] in Serum by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="44818-3";

	/** 
	*<div class="en">Code for Brucella abortus IgG+IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGG_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="44458-8";

	/** 
	*<div class="en">Code for Brucella abortus IgM Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGM_AB_PRESENCE_IN_SERUM_CODE="38244-0";

	/** 
	*<div class="en">Code for Brucella abortus IgM Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="23964-0";

	/** 
	*<div class="en">Code for Brucella abortus IgM Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="23987-1";

	/** 
	*<div class="en">Code for Brucella abortus IgM Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGM_AB_TITER_IN_SERUM_CODE="16120-8";

	/** 
	*<div class="en">Code for Brucella abortus IgM Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="13213-4";

	/** 
	*<div class="en">Code for Brucella abortus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="22151-5";

	/** 
	*<div class="en">Code for Brucella abortus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="6326-3";

	/** 
	*<div class="en">Code for Brucella abortus IgM Ab [Units/volume] in Serum by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_ABORTUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="44815-9";

	/** 
	*<div class="en">Code for Brucella abortus rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String BRUCELLA_ABORTUS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="22926-0";

	/** 
	*<div class="en">Code for Brucella canis</div>
	*/
	public static final String BRUCELLA_CANIS_CODE="38025008";

	/** 
	*<div class="en">Code for Brucella canis Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_CODE="22928-6";

	/** 
	*<div class="en">Code for Brucella canis Ab [Presence] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION_CODE="22930-2";

	/** 
	*<div class="en">Code for Brucella canis Ab [Presence] in Serum by Immune diffusion (ID)</div>
	*/
	public static final String BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_BY_IMMUNE_DIFFUSION_ID_CODE="22929-4";

	/** 
	*<div class="en">Code for Brucella canis Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="23681-0";

	/** 
	*<div class="en">Code for Brucella canis Ab [Presence] in Serum by Plate agglutination</div>
	*/
	public static final String BRUCELLA_CANIS_AB_PRESENCE_IN_SERUM_BY_PLATE_AGGLUTINATION_CODE="24410-3";

	/** 
	*<div class="en">Code for Brucella canis Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_AB_TITER_IN_SERUM_CODE="22152-3";

	/** 
	*<div class="en">Code for Brucella canis Ab [Titer] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_CANIS_AB_TITER_IN_SERUM_BY_AGGLUTINATION_CODE="23682-8";

	/** 
	*<div class="en">Code for Brucella canis Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_CANIS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="23683-6";

	/** 
	*<div class="en">Code for Brucella canis Ab [Titer] in Serum by Latex agglutination</div>
	*/
	public static final String BRUCELLA_CANIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5068-2";

	/** 
	*<div class="en">Code for Brucella canis Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_AB_UNITSVOLUME_IN_SERUM_CODE="11587-3";

	/** 
	*<div class="en">Code for Brucella canis Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_CANIS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="6327-1";

	/** 
	*<div class="en">Code for Brucella canis IgG Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AB_PRESENCE_IN_SERUM_CODE="38245-7";

	/** 
	*<div class="en">Code for Brucella canis IgG Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="43072-8";

	/** 
	*<div class="en">Code for Brucella canis IgG Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="30092-1";

	/** 
	*<div class="en">Code for Brucella canis IgG Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AB_TITER_IN_SERUM_CODE="22154-9";

	/** 
	*<div class="en">Code for Brucella canis IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="14079-8";

	/** 
	*<div class="en">Code for Brucella canis IgG Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="13214-2";

	/** 
	*<div class="en">Code for Brucella canis IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="22153-1";

	/** 
	*<div class="en">Code for Brucella canis IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="9495-3";

	/** 
	*<div class="en">Code for Brucella canis IgG and IgM [interpretation] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_IGG_AND_IGM_INTERPRETATION_IN_SERUM_CODE="44077-6";

	/** 
	*<div class="en">Code for Brucella canis IgM Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_IGM_AB_PRESENCE_IN_SERUM_CODE="38246-5";

	/** 
	*<div class="en">Code for Brucella canis IgM Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_CANIS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="43071-0";

	/** 
	*<div class="en">Code for Brucella canis IgM Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_CANIS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="30093-9";

	/** 
	*<div class="en">Code for Brucella canis IgM Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_IGM_AB_TITER_IN_SERUM_CODE="22156-4";

	/** 
	*<div class="en">Code for Brucella canis IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_CANIS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="14080-6";

	/** 
	*<div class="en">Code for Brucella canis IgM Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String BRUCELLA_CANIS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="13215-9";

	/** 
	*<div class="en">Code for Brucella canis IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_CANIS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="22155-6";

	/** 
	*<div class="en">Code for Brucella canis IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_CANIS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="9496-1";

	/** 
	*<div class="en">Code for Brucella melitensis</div>
	*/
	public static final String BRUCELLA_MELITENSIS_CODE="72829003";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_PRESENCE_IN_SERUM_CODE="22931-0";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Presence] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION_CODE="22933-6";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Presence] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="22935-1";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="22932-8";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_TITER_IN_SERUM_CODE="22157-2";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Titer] in Serum by Latex agglutination</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5069-0";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_UNITSVOLUME_IN_SERUM_CODE="11588-1";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Units/volume] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_UNITSVOLUME_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="22934-4";

	/** 
	*<div class="en">Code for Brucella melitensis Ab [Units/volume] in Serum by Latex agglutination</div>
	*/
	public static final String BRUCELLA_MELITENSIS_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="16489-7";

	/** 
	*<div class="en">Code for Brucella melitensis DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String BRUCELLA_MELITENSIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="22936-9";

	/** 
	*<div class="en">Code for Brucella melitensis IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_MELITENSIS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="57670-2";

	/** 
	*<div class="en">Code for Brucella melitensis IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_MELITENSIS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="57671-0";

	/** 
	*<div class="en">Code for Brucella ovis Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_CODE="22158-0";

	/** 
	*<div class="en">Code for Brucella ovis Ab [Presence] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION_CODE="22938-5";

	/** 
	*<div class="en">Code for Brucella ovis Ab [Presence] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="20733-2";

	/** 
	*<div class="en">Code for Brucella ovis Ab [Presence] in Serum by Immune diffusion (ID)</div>
	*/
	public static final String BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_BY_IMMUNE_DIFFUSION_ID_CODE="22940-1";

	/** 
	*<div class="en">Code for Brucella ovis Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_OVIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="20732-4";

	/** 
	*<div class="en">Code for Brucella ovis Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_OVIS_AB_TITER_IN_SERUM_CODE="23684-4";

	/** 
	*<div class="en">Code for Brucella ovis Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_OVIS_AB_UNITSVOLUME_IN_SERUM_CODE="22939-3";

	/** 
	*<div class="en">Code for Brucella ovis Ab [Units/volume] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_OVIS_AB_UNITSVOLUME_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="22937-7";

	/** 
	*<div class="en">Code for Brucella species</div>
	*/
	public static final String BRUCELLA_SPECIES_CODE="116505000";

	/** 
	*<div class="en">Code for Brucella sp Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_SP_AB_PRESENCE_IN_SERUM_CODE="30202-6";

	/** 
	*<div class="en">Code for Brucella sp Ab [Presence] in Serum --1st specimen</div>
	*/
	public static final String BRUCELLA_SP_AB_PRESENCE_IN_SERUM_1ST_SPECIMEN_CODE="30129-1";

	/** 
	*<div class="en">Code for Brucella sp Ab [Presence] in Serum --2nd specimen</div>
	*/
	public static final String BRUCELLA_SP_AB_PRESENCE_IN_SERUM_2ND_SPECIMEN_CODE="30130-9";

	/** 
	*<div class="en">Code for Brucella sp Ab [Presence] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_SP_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION_CODE="40614-0";

	/** 
	*<div class="en">Code for Brucella sp Ab [Presence] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_SP_AB_PRESENCE_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="40613-2";

	/** 
	*<div class="en">Code for Brucella sp Ab [Titer] in Cerebral spinal fluid by Agglutination</div>
	*/
	public static final String BRUCELLA_SP_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_AGGLUTINATION_CODE="58806-1";

	/** 
	*<div class="en">Code for Brucella sp Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_SP_AB_TITER_IN_SERUM_CODE="22159-8";

	/** 
	*<div class="en">Code for Brucella sp Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String BRUCELLA_SP_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="29250-8";

	/** 
	*<div class="en">Code for Brucella sp Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String BRUCELLA_SP_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="29251-6";

	/** 
	*<div class="en">Code for Brucella sp Ab [Titer] in Serum by Agglutination</div>
	*/
	public static final String BRUCELLA_SP_AB_TITER_IN_SERUM_BY_AGGLUTINATION_CODE="19053-8";

	/** 
	*<div class="en">Code for Brucella sp Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_SP_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="6328-9";

	/** 
	*<div class="en">Code for Brucella sp Ab [Titer] in Serum by Tube agglutination</div>
	*/
	public static final String BRUCELLA_SP_AB_TITER_IN_SERUM_BY_TUBE_AGGLUTINATION_CODE="51671-6";

	/** 
	*<div class="en">Code for Brucella sp Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_SP_AB_UNITSVOLUME_IN_SERUM_CODE="10349-9";

	/** 
	*<div class="en">Code for Brucella sp Ag [Identifier] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_SP_AG_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="44271-5";

	/** 
	*<div class="en">Code for Brucella sp Ag [Presence] in Unspecified specimen by Agglutination</div>
	*/
	public static final String BRUCELLA_SP_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_AGGLUTINATION_CODE="47001-3";

	/** 
	*<div class="en">Code for Brucella sp Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String BRUCELLA_SP_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="41624-8";

	/** 
	*<div class="en">Code for Brucella sp DNA [Identifier] in Serum by Probe and target amplification method</div>
	*/
	public static final String BRUCELLA_SP_DNA_IDENTIFIER_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53604-5";

	/** 
	*<div class="en">Code for Brucella sp DNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String BRUCELLA_SP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41625-5";

	/** 
	*<div class="en">Code for Brucella sp DNA [Presence] in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String BRUCELLA_SP_DNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="63465-9";

	/** 
	*<div class="en">Code for Brucella sp DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String BRUCELLA_SP_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41626-3";

	/** 
	*<div class="en">Code for Brucella sp identified in Blood by Organism specific culture</div>
	*/
	public static final String BRUCELLA_SP_IDENTIFIED_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE_CODE="551-2";

	/** 
	*<div class="en">Code for Brucella sp identified in Bone marrow by Organism specific culture</div>
	*/
	public static final String BRUCELLA_SP_IDENTIFIED_IN_BONE_MARROW_BY_ORGANISM_SPECIFIC_CULTURE_CODE="24003-6";

	/** 
	*<div class="en">Code for Brucella sp identified in Tissue by Organism specific culture</div>
	*/
	public static final String BRUCELLA_SP_IDENTIFIED_IN_TISSUE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="20734-0";

	/** 
	*<div class="en">Code for Brucella sp identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String BRUCELLA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="552-0";

	/** 
	*<div class="en">Code for Brucella sp IgA Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_SP_IGA_AB_UNITSVOLUME_IN_SERUM_CODE="13211-8";

	/** 
	*<div class="en">Code for Brucella sp IgG Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_SP_IGG_AB_PRESENCE_IN_SERUM_CODE="24396-4";

	/** 
	*<div class="en">Code for Brucella sp IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_SP_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="24387-3";

	/** 
	*<div class="en">Code for Brucella sp IgG Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_SP_IGG_AB_TITER_IN_SERUM_CODE="38247-3";

	/** 
	*<div class="en">Code for Brucella sp IgG Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String BRUCELLA_SP_IGG_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="72308-0";

	/** 
	*<div class="en">Code for Brucella sp IgG Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String BRUCELLA_SP_IGG_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="72307-2";

	/** 
	*<div class="en">Code for Brucella sp IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_SP_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="13210-0";

	/** 
	*<div class="en">Code for Brucella sp IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_SP_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="56630-7";

	/** 
	*<div class="en">Code for Brucella sp IgG and IgM [interpretation] in Serum</div>
	*/
	public static final String BRUCELLA_SP_IGG_AND_IGM_INTERPRETATION_IN_SERUM_CODE="66485-4";

	/** 
	*<div class="en">Code for Brucella sp IgM Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_SP_IGM_AB_PRESENCE_IN_SERUM_CODE="24397-2";

	/** 
	*<div class="en">Code for Brucella sp IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_SP_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="24388-1";

	/** 
	*<div class="en">Code for Brucella sp IgM Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_SP_IGM_AB_TITER_IN_SERUM_CODE="38248-1";

	/** 
	*<div class="en">Code for Brucella sp IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="5070-8";

	/** 
	*<div class="en">Code for Brucella sp IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="56631-5";

	/** 
	*<div class="en">Code for Brucella sp [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String BRUCELLA_SP_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="44797-9";

	/** 
	*<div class="en">Code for Brucella suis</div>
	*/
	public static final String BRUCELLA_SUIS_CODE="48317004";

	/** 
	*<div class="en">Code for Brucella suis Ab [Presence] in Serum</div>
	*/
	public static final String BRUCELLA_SUIS_AB_PRESENCE_IN_SERUM_CODE="22951-8";

	/** 
	*<div class="en">Code for Brucella suis Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String BRUCELLA_SUIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="22952-6";

	/** 
	*<div class="en">Code for Brucella suis Ab [Presence] in Serum by Plate agglutination</div>
	*/
	public static final String BRUCELLA_SUIS_AB_PRESENCE_IN_SERUM_BY_PLATE_AGGLUTINATION_CODE="22950-0";

	/** 
	*<div class="en">Code for Brucella suis Ab [Titer] in Serum</div>
	*/
	public static final String BRUCELLA_SUIS_AB_TITER_IN_SERUM_CODE="22160-6";

	/** 
	*<div class="en">Code for Brucella suis Ab [Titer] in Serum by Latex agglutination</div>
	*/
	public static final String BRUCELLA_SUIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5071-6";

	/** 
	*<div class="en">Code for Brucella suis Ab [Titer] in Serum by Plate agglutination</div>
	*/
	public static final String BRUCELLA_SUIS_AB_TITER_IN_SERUM_BY_PLATE_AGGLUTINATION_CODE="71717-3";

	/** 
	*<div class="en">Code for Brucella suis Ab [Titer] in Serum by Tube agglutination</div>
	*/
	public static final String BRUCELLA_SUIS_AB_TITER_IN_SERUM_BY_TUBE_AGGLUTINATION_CODE="71716-5";

	/** 
	*<div class="en">Code for Brucella suis Ab [Units/volume] in Serum</div>
	*/
	public static final String BRUCELLA_SUIS_AB_UNITSVOLUME_IN_SERUM_CODE="11589-9";

	/** 
	*<div class="en">Code for Brucella suis Ab [Units/volume] in Serum by Complement fixation</div>
	*/
	public static final String BRUCELLA_SUIS_AB_UNITSVOLUME_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="22953-4";

	/** 
	*<div class="en">Code for Brucella suis Ab [Units/volume] in Serum by Latex agglutination</div>
	*/
	public static final String BRUCELLA_SUIS_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="16490-5";

	/** 
	*<div class="en">Code for Brucella suis DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String BRUCELLA_SUIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="22955-9";

	/** 
	*<div class="en">Code for Brucella suis rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String BRUCELLA_SUIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="22954-2";

	/** 
	*<div class="en">Code for Campylobacter</div>
	*/
	public static final String CAMPYLOBACTER_CODE="35408001";

	/** 
	*<div class="en">Code for Campylobacter coli</div>
	*/
	public static final String CAMPYLOBACTER_COLI_CODE="40614002";

	/** 
	*<div class="en">Code for Campylobacter coli rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_COLI_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="6329-7";

	/** 
	*<div class="en">Code for Campylobacter coli rRNA [Units/volume] in Serum by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_COLI_RRNA_UNITSVOLUME_IN_SERUM_BY_DNA_PROBE_CODE="16528-2";

	/** 
	*<div class="en">Code for Campylobacter curvus</div>
	*/
	public static final String CAMPYLOBACTER_CURVUS_CODE="116037008";

	/** 
	*<div class="en">Code for Campylobacter fetus</div>
	*/
	public static final String CAMPYLOBACTER_FETUS_CODE="84210007";

	/** 
	*<div class="en">Code for Campylobacter hyointestinalis</div>
	*/
	public static final String CAMPYLOBACTER_HYOINTESTINALIS_CODE="9041007";

	/** 
	*<div class="en">Code for Campylobacter jejuni</div>
	*/
	public static final String CAMPYLOBACTER_JEJUNI_CODE="66543000";

	/** 
	*<div class="en">Code for Campylobacter jejuni+Campylobacter coli Ag [Presence] in Stool</div>
	*/
	public static final String CAMPYLOBACTER_JEJUNI_CAMPYLOBACTER_COLI_AG_PRESENCE_IN_STOOL_CODE="57768-4";

	/** 
	*<div class="en">Code for Campylobacter jejuni DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CAMPYLOBACTER_JEJUNI_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="61368-7";

	/** 
	*<div class="en">Code for Campylobacter jejuni rRNA [Presence] in Serum by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_JEJUNI_RRNA_PRESENCE_IN_SERUM_BY_DNA_PROBE_CODE="16530-8";

	/** 
	*<div class="en">Code for Campylobacter jejuni rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_JEJUNI_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="6333-9";

	/** 
	*<div class="en">Code for Campylobacter jejuni rRNA [Units/volume] in Serum by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_JEJUNI_RRNA_UNITSVOLUME_IN_SERUM_BY_DNA_PROBE_CODE="16529-0";

	/** 
	*<div class="en">Code for Campylobacter lari</div>
	*/
	public static final String CAMPYLOBACTER_LARI_CODE="116386003";

	/** 
	*<div class="en">Code for Campylobacter lari rRNA [Presence] in Serum by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_LARI_RRNA_PRESENCE_IN_SERUM_BY_DNA_PROBE_CODE="16532-4";

	/** 
	*<div class="en">Code for Campylobacter lari rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_LARI_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="6334-7";

	/** 
	*<div class="en">Code for Campylobacter lari rRNA [Units/volume] in Serum by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_LARI_RRNA_UNITSVOLUME_IN_SERUM_BY_DNA_PROBE_CODE="16531-6";

	/** 
	*<div class="en">Code for Campylobacter rectus</div>
	*/
	public static final String CAMPYLOBACTER_RECTUS_CODE="113525005";

	/** 
	*<div class="en">Code for Campylobacter species</div>
	*/
	public static final String CAMPYLOBACTER_SPECIES_CODE="116457002";

	/** 
	*<div class="en">Code for Campylobacter sputorum</div>
	*/
	public static final String CAMPYLOBACTER_SPUTORUM_CODE="91524009";

	/** 
	*<div class="en">Code for Campylobacter sp DNA.diarrheagenic [Presence] in Stool Qualitative by Probe and target amplification method</div>
	*/
	public static final String CAMPYLOBACTER_SP_DNA_DIARRHEAGENIC_PRESENCE_IN_STOOL_QUALITATIVE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="71429-5";

	/** 
	*<div class="en">Code for Campylobacter sp DNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CAMPYLOBACTER_SP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49614-1";

	/** 
	*<div class="en">Code for Campylobacter sp identified in Blood by Organism specific culture</div>
	*/
	public static final String CAMPYLOBACTER_SP_IDENTIFIED_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6330-5";

	/** 
	*<div class="en">Code for Campylobacter sp identified in Body fluid by Organism specific culture</div>
	*/
	public static final String CAMPYLOBACTER_SP_IDENTIFIED_IN_BODY_FLUID_BY_ORGANISM_SPECIFIC_CULTURE_CODE="20739-9";

	/** 
	*<div class="en">Code for Campylobacter sp identified in Isolate by Organism specific culture</div>
	*/
	public static final String CAMPYLOBACTER_SP_IDENTIFIED_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="20738-1";

	/** 
	*<div class="en">Code for Campylobacter sp identified in Stool by Organism specific culture</div>
	*/
	public static final String CAMPYLOBACTER_SP_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6331-3";

	/** 
	*<div class="en">Code for Campylobacter sp identified in Tissue by Organism specific culture</div>
	*/
	public static final String CAMPYLOBACTER_SP_IDENTIFIED_IN_TISSUE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="20740-7";

	/** 
	*<div class="en">Code for Campylobacter sp identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String CAMPYLOBACTER_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6332-1";

	/** 
	*<div class="en">Code for Campylobacter sp rRNA [Presence] in Serum by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_SP_RRNA_PRESENCE_IN_SERUM_BY_DNA_PROBE_CODE="16534-0";

	/** 
	*<div class="en">Code for Campylobacter sp rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String CAMPYLOBACTER_SP_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="4992-4";

	/** 
	*<div class="en">Code for Campylobacter upsaliensis</div>
	*/
	public static final String CAMPYLOBACTER_UPSALIENSIS_CODE="103427005";

	/** 
	*<div class="en">Code for Capreomycin 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CAPREOMYCIN_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25210-6";

	/** 
	*<div class="en">Code for Capreomycin 20 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CAPREOMYCIN_20_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25211-4";

	/** 
	*<div class="en">Code for Capreomycin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CAPREOMYCIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25212-2";

	/** 
	*<div class="en">Code for Capreomycin 3 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CAPREOMYCIN_3_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="48170-5";

	/** 
	*<div class="en">Code for Capreomycin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CAPREOMYCIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="61355-4";

	/** 
	*<div class="en">Code for Capreomycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CAPREOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23607-5";

	/** 
	*<div class="en">Code for Cefotaxime [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CEFOTAXIME_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="50632-9";

	/** 
	*<div class="en">Code for Cefoxitin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CEFOXITIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25220-5";

	/** 
	*<div class="en">Code for Cefoxitin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CEFOXITIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25366-6";

	/** 
	*<div class="en">Code for Ceftazidime [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CEFTAZIDIME_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="58705-5";

	/** 
	*<div class="en">Code for Ceftriaxone [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CEFTRIAXONE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25367-4";

	/** 
	*<div class="en">Code for Chikungunya virus IgM Ab [Presence] in Serum</div>
	*/
	public static final String CHIKUNGUNYA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="57934-2";

	/** 
	*<div class="en">Code for Chikungunya virus IgM Ab [Presence] in Serum or Plasma by Immunofluorescence</div>
	*/
	public static final String CHIKUNGUNYA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE_CODE="56131-6";

	/** 
	*<div class="en">Code for Chikungunya virus IgM Ab [Titer] in Serum or Plasma by Immunofluorescence</div>
	*/
	public static final String CHIKUNGUNYA_VIRUS_IGM_AB_TITER_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE_CODE="56130-8";

	/** 
	*<div class="en">Code for Chikungunya virus RNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String CHIKUNGUNYA_VIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60260-7";

	/** 
	*<div class="en">Code for Chikungunya virus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CHIKUNGUNYA_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="51664-1";

	/** 
	*<div class="en">Code for Chlamydia trachomatis</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_CODE="63938009";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Anal</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_ANAL_CODE="34710-4";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Blood</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_BLOOD_CODE="31768-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Blood by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_BLOOD_BY_IMMUNOASSAY_CODE="14468-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Blood by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_BLOOD_BY_IMMUNOFLUORESCENCE_CODE="14507-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Body fluid</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_BODY_FLUID_CODE="47234-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31770-1";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="14469-1";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="14508-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Cervix</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CERVIX_CODE="31771-9";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Cervix by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CERVIX_BY_IMMUNOASSAY_CODE="14470-9";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Cervix by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CERVIX_BY_IMMUNOFLUORESCENCE_CODE="14509-4";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Conjunctival specimen</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_CODE="31769-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Conjunctival specimen by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_IMMUNOASSAY_CODE="6350-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Conjunctival specimen by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6351-1";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Genital specimen</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_GENITAL_SPECIMEN_CODE="45091-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Nasopharynx</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_NASOPHARYNX_CODE="34709-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Nasopharynx by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOASSAY_CODE="45092-4";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Penis</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_PENIS_CODE="31773-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Penis by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_PENIS_BY_IMMUNOASSAY_CODE="14473-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Penis by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_PENIS_BY_IMMUNOFLUORESCENCE_CODE="14512-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Stool</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_STOOL_CODE="31774-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Stool by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_STOOL_BY_IMMUNOFLUORESCENCE_CODE="6352-9";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Tissue by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE_CODE="6353-7";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31777-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="6354-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6355-2";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Urethra</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URETHRA_CODE="31776-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Urethra by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URETHRA_BY_IMMUNOASSAY_CODE="14472-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Urethra by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URETHRA_BY_IMMUNOFLUORESCENCE_CODE="14511-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Urine sediment</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URINE_SEDIMENT_CODE="31775-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Urine sediment by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URINE_SEDIMENT_BY_IMMUNOASSAY_CODE="14474-1";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Urine sediment by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_URINE_SEDIMENT_BY_IMMUNOFLUORESCENCE_CODE="14513-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Vaginal fluid</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_VAGINAL_FLUID_CODE="31772-7";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Vaginal fluid by Immunoassay</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_VAGINAL_FLUID_BY_IMMUNOASSAY_CODE="14471-7";

	/** 
	*<div class="en">Code for Chlamydia trachomatis Ag [Presence] in Vaginal fluid by Immunofluorescence</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_AG_PRESENCE_IN_VAGINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="14510-2";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="47212-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Anal by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_ANAL_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="45090-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="16599-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Cervical mucus by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_CERVICAL_MUCUS_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21189-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Cervix by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_CERVIX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21190-4";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Conjunctival specimen by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21187-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Genital specimen by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_GENITAL_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="6356-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Nasopharynx by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_NASOPHARYNX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="45086-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Penis by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_PENIS_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="45087-4";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Semen by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_SEMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="51578-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Unspecified specimen by Probe and signal amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="43404-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21613-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Unspecified specimen from donor by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="50311-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Urethra by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_URETHRA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21191-2";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Urine by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_URINE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="6357-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Presence] in Vaginal fluid by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_PRESENCE_IN_VAGINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="45084-1";

	/** 
	*<div class="en">Code for Chlamydia trachomatis DNA [Units/volume] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_DNA_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49096-1";

	/** 
	*<div class="en">Code for Chlamydia trachomatis L2 DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_L2_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="47211-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Anal by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_ANAL_BY_ORGANISM_SPECIFIC_CULTURE_CODE="45093-2";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Blood by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14461-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Cerebral spinal fluid by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14462-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Cervix by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_CERVIX_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14463-4";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Conjunctival specimen by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="45094-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Genital specimen by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_GENITAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="45095-7";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Nasopharynx by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_NASOPHARYNX_BY_ORGANISM_SPECIFIC_CULTURE_CODE="45096-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Penis by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_PENIS_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14466-7";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6349-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Urethra by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_URETHRA_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14465-9";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Urine sediment by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_URINE_SEDIMENT_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14467-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis [Presence] in Vaginal fluid by Organism specific culture</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_PRESENCE_IN_VAGINAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14464-2";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Anal by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_ANAL_BY_DNA_PROBE_CODE="45089-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Anal by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_ANAL_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="57287-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Blood by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_BLOOD_BY_DNA_PROBE_CODE="38469-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Cervix by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_CERVIX_BY_DNA_PROBE_CODE="45078-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Cervix by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_CERVIX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="50387-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Conjunctival specimen by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_DNA_PROBE_CODE="21188-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Genital fluid by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_GENITAL_FLUID_BY_DNA_PROBE_CODE="23838-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Genital specimen by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_GENITAL_SPECIMEN_BY_DNA_PROBE_CODE="16600-9";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Nasopharynx by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_NASOPHARYNX_BY_DNA_PROBE_CODE="45085-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Nasopharynx by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_NASOPHARYNX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="57288-3";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Penis by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_PENIS_BY_DNA_PROBE_CODE="45088-2";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="4993-2";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="43304-5";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Unspecified specimen from donor by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="50411-8";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Urethra by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_URETHRA_BY_DNA_PROBE_CODE="21192-0";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Urethra by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_URETHRA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53925-4";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Urine by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_URINE_BY_DNA_PROBE_CODE="16601-7";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Urine by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_URINE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="42931-6";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Vaginal fluid by DNA probe</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_VAGINAL_FLUID_BY_DNA_PROBE_CODE="45080-9";

	/** 
	*<div class="en">Code for Chlamydia trachomatis rRNA [Presence] in Vaginal fluid by Probe and target amplification method</div>
	*/
	public static final String CHLAMYDIA_TRACHOMATIS_RRNA_PRESENCE_IN_VAGINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53926-2";

	/** 
	*<div class="en">Code for Ciprofloxacin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CIPROFLOXACIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="55194-5";

	/** 
	*<div class="en">Code for Ciprofloxacin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CIPROFLOXACIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25180-1";

	/** 
	*<div class="en">Code for Ciprofloxacin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CIPROFLOXACIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25181-9";

	/** 
	*<div class="en">Code for Ciprofloxacin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CIPROFLOXACIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25189-2";

	/** 
	*<div class="en">Code for Ciprofloxacin 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CIPROFLOXACIN_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25188-4";

	/** 
	*<div class="en">Code for Ciprofloxacin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CIPROFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20377-8";

	/** 
	*<div class="en">Code for Clarithromycin 12 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLARITHROMYCIN_12_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="43987-7";

	/** 
	*<div class="en">Code for Clarithromycin 16 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLARITHROMYCIN_16_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25191-8";

	/** 
	*<div class="en">Code for Clarithromycin 32 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLARITHROMYCIN_32_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25192-6";

	/** 
	*<div class="en">Code for Clarithromycin 3 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLARITHROMYCIN_3_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="43990-1";

	/** 
	*<div class="en">Code for Clarithromycin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLARITHROMYCIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="43991-9";

	/** 
	*<div class="en">Code for Clarithromycin 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLARITHROMYCIN_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25190-0";

	/** 
	*<div class="en">Code for Clarithromycin+Ethambutol [Susceptibility] by Minimum inhibitory concentration (MIC)</div>
	*/
	public static final String CLARITHROMYCIN_ETHAMBUTOL_SUSCEPTIBILITY_BY_MINIMUM_INHIBITORY_CONCENTRATION_MIC_CODE="16620-7";

	/** 
	*<div class="en">Code for Clarithromycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLARITHROMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20375-2";

	/** 
	*<div class="en">Code for Clofazimine 0.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLOFAZIMINE_0_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="43988-5";

	/** 
	*<div class="en">Code for Clofazimine 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLOFAZIMINE_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="43989-3";

	/** 
	*<div class="en">Code for Clofazimine 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLOFAZIMINE_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="43986-9";

	/** 
	*<div class="en">Code for Clofazimine [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CLOFAZIMINE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20376-0";

	/** 
	*<div class="en">Code for Clostridium botulinum [Presence] in Isolate by Organism specific culture</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_PRESENCE_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="33695-8";

	/** 
	*<div class="en">Code for Clostridium botulinum [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="33694-1";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin A Ab [Presence] in Serum</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_A_AB_PRESENCE_IN_SERUM_CODE="34664-3";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin A+B+E+F+G [Presence] in Unspecified specimen by Mouse bioassay neutralization</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_A_B_E_F_G_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION_CODE="38989-0";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin A+B+E [Presence] in Unspecified specimen</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_A_B_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="33712-1";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin A+B+E [Presence] in Unspecified specimen by Mouse bioassay neutralization</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_A_B_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION_CODE="33704-8";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin A gene [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_A_GENE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41631-3";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin A [Presence] in Unspecified specimen</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_A_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="33709-7";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin A [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_A_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="41630-5";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin A [Presence] in Unspecified specimen by Mouse bioassay neutralization</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_A_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION_CODE="33701-4";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin B gene [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_B_GENE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41633-9";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin B [Presence] in Unspecified specimen</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_B_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="33713-9";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin B [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_B_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="41632-1";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin B [Presence] in Unspecified specimen by Mouse bioassay neutralization</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_B_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION_CODE="33705-5";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin E [Presence] in Unspecified specimen</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="33710-5";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin E [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="41634-7";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin E [Presence] in Unspecified specimen by Mouse bioassay neutralization</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_E_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION_CODE="33702-2";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin F [Presence] in Unspecified specimen</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_F_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="33711-3";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin F [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_F_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="41635-4";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin F [Presence] in Unspecified specimen by Mouse bioassay neutralization</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_F_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_NEUTRALIZATION_CODE="33703-0";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin gene [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_GENE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="46705-0";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin [Identifier] in Serum by Animal inoculation</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_IDENTIFIER_IN_SERUM_BY_ANIMAL_INOCULATION_CODE="20705-0";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin [Identifier] in Unspecified specimen</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_CODE="44796-1";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin [Identifier] in Unspecified specimen by Animal inoculation</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ANIMAL_INOCULATION_CODE="20706-8";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin [Identifier] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="44274-9";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin [Presence] in Unspecified specimen</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="33708-9";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="45039-5";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin [Presence] in Unspecified specimen by Mouse bioassay</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_MOUSE_BIOASSAY_CODE="33696-6";

	/** 
	*<div class="en">Code for Clostridium botulinum toxin [Units/volume] in Stool</div>
	*/
	public static final String CLOSTRIDIUM_BOTULINUM_TOXIN_UNITSVOLUME_IN_STOOL_CODE="11470-2";

	/** 
	*<div class="en">Code for Corynebacterium diphtheriae</div>
	*/
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_CODE="5851001";

	/** 
	*<div class="en">Code for Corynebacterium diphtheriae DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="67561-1";

	/** 
	*<div class="en">Code for Corynebacterium diphtheriae [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="16676-9";

	/** 
	*<div class="en">Code for Corynebacterium diphtheriae type gravis</div>
	*/
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_TYPE_GRAVIS_CODE="83675005";

	/** 
	*<div class="en">Code for Corynebacterium diphtheriae type intermedius</div>
	*/
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_TYPE_INTERMEDIUS_CODE="70876001";

	/** 
	*<div class="en">Code for Corynebacterium diphtheriae type mitis</div>
	*/
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_TYPE_MITIS_CODE="13755001";

	/** 
	*<div class="en">Code for Corynebacterium diphtheriae var belfanti</div>
	*/
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_VAR_BELFANTI_CODE="243255007";

	/** 
	*<div class="en">Code for Coxiella burnetii Ab [Titer] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_AB_TITER_IN_SERUM_CODE="22211-7";

	/** 
	*<div class="en">Code for Coxiella burnetii DNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String COXIELLA_BURNETII_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60261-5";

	/** 
	*<div class="en">Code for Coxiella burnetii DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String COXIELLA_BURNETII_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="23024-3";

	/** 
	*<div class="en">Code for Coxiella burnetii identified in Unspecified specimen by Sequencing</div>
	*/
	public static final String COXIELLA_BURNETII_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_SEQUENCING_CODE="49124-1";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 and 2 IgG and IgM [interpretation] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_AND_2_IGG_AND_IGM_INTERPRETATION_IN_SERUM_CODE="44006-5";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgA Ab [Titer] in Body fluid</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGA_AB_TITER_IN_BODY_FLUID_CODE="49187-8";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgA Ab [Titer] in Body fluid by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGA_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE_CODE="48889-0";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgA Ab [Titer] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGA_AB_TITER_IN_SERUM_CODE="9706-3";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgA Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="48848-6";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgA Ab [Units/volume] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGA_AB_UNITSVOLUME_IN_SERUM_CODE="31312-2";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgG Ab [Presence] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGG_AB_PRESENCE_IN_SERUM_CODE="32644-7";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgG Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="48720-7";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgG Ab [Titer] in Body fluid</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGG_AB_TITER_IN_BODY_FLUID_CODE="49186-0";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgG Ab [Titer] in Body fluid by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGG_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE_CODE="48888-2";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgG Ab [Titer] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGG_AB_TITER_IN_SERUM_CODE="9708-9";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="34716-1";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="7829-5";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51810-0";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Presence] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_PRESENCE_IN_SERUM_CODE="32645-4";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="63455-0";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Titer] in Body fluid</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_TITER_IN_BODY_FLUID_CODE="49185-2";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Titer] in Body fluid by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE_CODE="48890-8";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Titer] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_TITER_IN_SERUM_CODE="9710-5";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47075-7";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="7831-1";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51811-8";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 1 IgM Ab [Units/volume] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_1_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="42897-9";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 Ab [Titer] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_AB_TITER_IN_SERUM_CODE="38389-3";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 Ab [Titer] in Serum by Complement fixation</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="29772-1";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="27945-5";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 Ab [Units/volume] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_AB_UNITSVOLUME_IN_SERUM_CODE="31313-0";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgA Ab [Titer] in Body fluid</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGA_AB_TITER_IN_BODY_FLUID_CODE="49184-5";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgA Ab [Titer] in Body fluid by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGA_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE_CODE="48891-6";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgA Ab [Titer] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGA_AB_TITER_IN_SERUM_CODE="9707-1";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgA Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="48849-4";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgA Ab [Units/volume] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGA_AB_UNITSVOLUME_IN_SERUM_CODE="31316-3";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Presence] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_PRESENCE_IN_SERUM_CODE="31314-8";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="29777-0";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="48719-9";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Titer] in Body fluid</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_BODY_FLUID_CODE="49183-7";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Titer] in Body fluid by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE_CODE="48893-2";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="58761-8";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Titer] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_SERUM_CODE="9709-7";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="34717-9";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Units/volume] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="58762-6";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="7830-3";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51812-6";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Presence] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_PRESENCE_IN_SERUM_CODE="31315-5";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="29773-9";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="43928-1";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Titer] in Body fluid</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_TITER_IN_BODY_FLUID_CODE="49182-9";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Titer] in Body fluid by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_TITER_IN_BODY_FLUID_BY_IMMUNOFLUORESCENCE_CODE="48892-4";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Titer] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_TITER_IN_SERUM_CODE="9711-3";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="44814-2";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="7832-9";

	/** 
	*<div class="en">Code for Coxiella burnetii phase 2 IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String COXIELLA_BURNETII_PHASE_2_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51813-4";

	/** 
	*<div class="en">Code for Coxiella burnetii [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String COXIELLA_BURNETII_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="44799-5";

	/** 
	*<div class="en">Code for Cycloserine 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CYCLOSERINE_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25207-2";

	/** 
	*<div class="en">Code for Cycloserine 20 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CYCLOSERINE_20_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25208-0";

	/** 
	*<div class="en">Code for Cycloserine 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CYCLOSERINE_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25209-8";

	/** 
	*<div class="en">Code for Cycloserine [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String CYCLOSERINE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23608-3";

	/** 
	*<div class="en">Code for Dengue virus</div>
	*/
	public static final String DENGUE_VIRUS_CODE="34348001";

	/** 
	*<div class="en">Code for Dengue virus 1+2+3+4 RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String DENGUE_VIRUS_1_2_3_4_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="7855-0";

	/** 
	*<div class="en">Code for Dengue virus 1 Ab [Titer] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_1_AB_TITER_IN_SERUM_CODE="16736-1";

	/** 
	*<div class="en">Code for Dengue virus 1 Ab [Units/volume] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_1_AB_UNITSVOLUME_IN_SERUM_CODE="31338-7";

	/** 
	*<div class="en">Code for Dengue virus 1 RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String DENGUE_VIRUS_1_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60262-3";

	/** 
	*<div class="en">Code for Dengue virus 2 Ab [Titer] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_2_AB_TITER_IN_SERUM_CODE="16737-9";

	/** 
	*<div class="en">Code for Dengue virus 2 Ab [Units/volume] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_2_AB_UNITSVOLUME_IN_SERUM_CODE="31339-5";

	/** 
	*<div class="en">Code for Dengue virus 2 RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String DENGUE_VIRUS_2_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60420-7";

	/** 
	*<div class="en">Code for Dengue virus 3 Ab [Titer] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_3_AB_TITER_IN_SERUM_CODE="16738-7";

	/** 
	*<div class="en">Code for Dengue virus 3 Ab [Units/volume] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_3_AB_UNITSVOLUME_IN_SERUM_CODE="31340-3";

	/** 
	*<div class="en">Code for Dengue virus 3 RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String DENGUE_VIRUS_3_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60419-9";

	/** 
	*<div class="en">Code for Dengue virus 4 Ab [Titer] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_4_AB_TITER_IN_SERUM_CODE="16739-5";

	/** 
	*<div class="en">Code for Dengue virus 4 Ab [Units/volume] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_4_AB_UNITSVOLUME_IN_SERUM_CODE="31341-1";

	/** 
	*<div class="en">Code for Dengue virus 4 RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String DENGUE_VIRUS_4_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60418-1";

	/** 
	*<div class="en">Code for Dengue virus Ab [Titer] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_AB_TITER_IN_SERUM_CODE="33606-5";

	/** 
	*<div class="en">Code for Dengue virus Ab [Titer] in Serum by Complement fixation</div>
	*/
	public static final String DENGUE_VIRUS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="40515-9";

	/** 
	*<div class="en">Code for Dengue virus Ab [Titer] in Serum by Hemagglutination inhibition</div>
	*/
	public static final String DENGUE_VIRUS_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION_CODE="55369-3";

	/** 
	*<div class="en">Code for Dengue virus Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String DENGUE_VIRUS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="33578-6";

	/** 
	*<div class="en">Code for Dengue virus Ab [Titer] in Serum by Neutralization test</div>
	*/
	public static final String DENGUE_VIRUS_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_CODE="55438-6";

	/** 
	*<div class="en">Code for Dengue virus Ab [Units/volume] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="7859-2";

	/** 
	*<div class="en">Code for Dengue virus Ab [Units/volume] in Unspecified specimen</div>
	*/
	public static final String DENGUE_VIRUS_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_CODE="31342-9";

	/** 
	*<div class="en">Code for Dengue virus Ag [Presence] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_AG_PRESENCE_IN_SERUM_CODE="31798-2";

	/** 
	*<div class="en">Code for Dengue virus Ag [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String DENGUE_VIRUS_AG_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="6384-2";

	/** 
	*<div class="en">Code for Dengue virus Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String DENGUE_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31799-0";

	/** 
	*<div class="en">Code for Dengue virus Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String DENGUE_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6385-9";

	/** 
	*<div class="en">Code for Dengue virus DNA [Presence] in Serum by DNA probe</div>
	*/
	public static final String DENGUE_VIRUS_DNA_PRESENCE_IN_SERUM_BY_DNA_PROBE_CODE="6386-7";

	/** 
	*<div class="en">Code for Dengue virus DNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String DENGUE_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="6387-5";

	/** 
	*<div class="en">Code for Dengue virus IgG Ab [Titer] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_IGG_AB_TITER_IN_SERUM_CODE="6811-4";

	/** 
	*<div class="en">Code for Dengue virus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="23958-2";

	/** 
	*<div class="en">Code for Dengue virus IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String DENGUE_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="23991-3";

	/** 
	*<div class="en">Code for Dengue virus IgG and IgM [interpretation] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_IGG_AND_IGM_INTERPRETATION_IN_SERUM_CODE="51785-4";

	/** 
	*<div class="en">Code for Dengue virus IgM Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String DENGUE_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="34721-1";

	/** 
	*<div class="en">Code for Dengue virus IgM Ab [Presence] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="25338-5";

	/** 
	*<div class="en">Code for Dengue virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String DENGUE_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="29663-2";

	/** 
	*<div class="en">Code for Dengue virus IgM Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String DENGUE_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="25392-2";

	/** 
	*<div class="en">Code for Dengue virus IgM Ab [Titer] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_IGM_AB_TITER_IN_SERUM_CODE="6812-2";

	/** 
	*<div class="en">Code for Dengue virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String DENGUE_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="23968-1";

	/** 
	*<div class="en">Code for Dengue virus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String DENGUE_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="23992-1";

	/** 
	*<div class="en">Code for Dengue virus, type 1</div>
	*/
	public static final String DENGUE_VIRUS_TYPE_1_CODE="60588009";

	/** 
	*<div class="en">Code for Dengue virus, type 2</div>
	*/
	public static final String DENGUE_VIRUS_TYPE_2_CODE="41328007";

	/** 
	*<div class="en">Code for Dengue virus, type 3</div>
	*/
	public static final String DENGUE_VIRUS_TYPE_3_CODE="8467002";

	/** 
	*<div class="en">Code for Dengue virus, type 4</div>
	*/
	public static final String DENGUE_VIRUS_TYPE_4_CODE="36700002";

	/** 
	*<div class="en">Code for Diphtheria identified in Bronchial specimen by Organism specific culture</div>
	*/
	public static final String DIPHTHERIA_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14483-2";

	/** 
	*<div class="en">Code for Diphtheria identified in Isolate by Organism specific culture</div>
	*/
	public static final String DIPHTHERIA_IDENTIFIED_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6596-1";

	/** 
	*<div class="en">Code for Diphtheria identified in Nose by Organism specific culture</div>
	*/
	public static final String DIPHTHERIA_IDENTIFIED_IN_NOSE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14481-6";

	/** 
	*<div class="en">Code for Diphtheria identified in Skin by Organism specific culture</div>
	*/
	public static final String DIPHTHERIA_IDENTIFIED_IN_SKIN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14482-4";

	/** 
	*<div class="en">Code for Diphtheria identified in Sputum by Organism specific culture</div>
	*/
	public static final String DIPHTHERIA_IDENTIFIED_IN_SPUTUM_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14480-8";

	/** 
	*<div class="en">Code for Diphtheria identified in Throat by Organism specific culture</div>
	*/
	public static final String DIPHTHERIA_IDENTIFIED_IN_THROAT_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14479-0";

	/** 
	*<div class="en">Code for Diphtheria identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String DIPHTHERIA_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="567-8";

	/** 
	*<div class="en">Code for displayName</div>
	*/
	public static final String DISPLAYNAME_CODE="code value";

	/** 
	*<div class="en">Code for Doxycycline 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String DOXYCYCLINE_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25223-9";

	/** 
	*<div class="en">Code for Doxycycline [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String DOXYCYCLINE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20379-4";

	/** 
	*<div class="en">Code for Ebola virus Ab [Titer] in Serum</div>
	*/
	public static final String EBOLA_VIRUS_AB_TITER_IN_SERUM_CODE="22263-8";

	/** 
	*<div class="en">Code for Ebola virus Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String EBOLA_VIRUS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7862-6";

	/** 
	*<div class="en">Code for Ebola virus Ab [Units/volume] in Serum</div>
	*/
	public static final String EBOLA_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="11581-6";

	/** 
	*<div class="en">Code for Ebola virus Ag [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String EBOLA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="71768-6";

	/** 
	*<div class="en">Code for Ebola virus Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String EBOLA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="41637-0";

	/** 
	*<div class="en">Code for Ebola virus IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String EBOLA_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="71770-2";

	/** 
	*<div class="en">Code for Ebola virus IgG Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String EBOLA_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="71767-8";

	/** 
	*<div class="en">Code for Ebola virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String EBOLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="71712-4";

	/** 
	*<div class="en">Code for Ebola virus IgM Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String EBOLA_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="71711-6";

	/** 
	*<div class="en">Code for Ebola virus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String EBOLA_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41636-2";

	/** 
	*<div class="en">Code for Erythrocytes.Plasmodium sp infected/1000 erythrocytes in Blood</div>
	*/
	public static final String ERYTHROCYTES_PLASMODIUM_SP_INFECTED1000_ERYTHROCYTES_IN_BLOOD_CODE="48427-9";

	/** 
	*<div class="en">Code for Erythrocytes.Plasmodium sp infected/100 erythrocytes in Blood</div>
	*/
	public static final String ERYTHROCYTES_PLASMODIUM_SP_INFECTED100_ERYTHROCYTES_IN_BLOOD_CODE="53556-7";

	/** 
	*<div class="en">Code for Erythromycin 15 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ERYTHROMYCIN_15_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25224-7";

	/** 
	*<div class="en">Code for Erythromycin+Ethambutol [Susceptibility] by Minimum inhibitory concentration (MIC)</div>
	*/
	public static final String ERYTHROMYCIN_ETHAMBUTOL_SUSCEPTIBILITY_BY_MINIMUM_INHIBITORY_CONCENTRATION_MIC_CODE="16830-2";

	/** 
	*<div class="en">Code for Erythromycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ERYTHROMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20380-2";

	/** 
	*<div class="en">Code for Escherichia coli shiga-like identified in Stool by Organism specific culture</div>
	*/
	public static final String ESCHERICHIA_COLI_SHIGA_LIKE_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE_CODE="16835-1";

	/** 
	*<div class="en">Code for Escherichia coli shiga-like [Presence] in Stool by Immunoassay</div>
	*/
	public static final String ESCHERICHIA_COLI_SHIGA_LIKE_PRESENCE_IN_STOOL_BY_IMMUNOASSAY_CODE="21262-1";

	/** 
	*<div class="en">Code for Escherichia coli shiga-like toxin 1 and 2 Ag [Identifier] in Stool by Immunoassay</div>
	*/
	public static final String ESCHERICHIA_COLI_SHIGA_LIKE_TOXIN_1_AND_2_AG_IDENTIFIER_IN_STOOL_BY_IMMUNOASSAY_CODE="64013-6";

	/** 
	*<div class="en">Code for Escherichia coli shiga-like toxin (stx1+stx2)+H7 flagellar (fliC) genes [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String ESCHERICHIA_COLI_SHIGA_LIKE_TOXIN_STX1_STX2_H7_FLAGELLAR_FLIC_GENES_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53947-8";

	/** 
	*<div class="en">Code for Escherichia coli shiga-like [Units/volume] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String ESCHERICHIA_COLI_SHIGA_LIKE_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="28035-4";

	/** 
	*<div class="en">Code for Escherichia coli shiga toxin 1 Ag [Presence] in Stool by Immunoassay</div>
	*/
	public static final String ESCHERICHIA_COLI_SHIGA_TOXIN_1_AG_PRESENCE_IN_STOOL_BY_IMMUNOASSAY_CODE="51940-5";

	/** 
	*<div class="en">Code for Escherichia coli shiga toxin 2 Ag [Presence] in Stool by Immunoassay</div>
	*/
	public static final String ESCHERICHIA_COLI_SHIGA_TOXIN_2_AG_PRESENCE_IN_STOOL_BY_IMMUNOASSAY_CODE="51939-7";

	/** 
	*<div class="en">Code for Escherichia coli shiga toxin Ag [Identifier] in Unspecified specimen</div>
	*/
	public static final String ESCHERICHIA_COLI_SHIGA_TOXIN_AG_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_CODE="53946-0";

	/** 
	*<div class="en">Code for Ethambutol 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHAMBUTOL_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25195-9";

	/** 
	*<div class="en">Code for Ethambutol 2.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHAMBUTOL_2_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25230-4";

	/** 
	*<div class="en">Code for Ethambutol 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHAMBUTOL_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="55674-6";

	/** 
	*<div class="en">Code for Ethambutol 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHAMBUTOL_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25194-2";

	/** 
	*<div class="en">Code for Ethambutol 7.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHAMBUTOL_7_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25187-6";

	/** 
	*<div class="en">Code for Ethambutol 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHAMBUTOL_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="56025-0";

	/** 
	*<div class="en">Code for Ethambutol+Rifampin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHAMBUTOL_RIFAMPIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="55154-9";

	/** 
	*<div class="en">Code for Ethambutol [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHAMBUTOL_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20381-0";

	/** 
	*<div class="en">Code for Ethionamide 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHIONAMIDE_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25231-2";

	/** 
	*<div class="en">Code for Ethionamide 11 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHIONAMIDE_11_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25183-5";

	/** 
	*<div class="en">Code for Ethionamide 15 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHIONAMIDE_15_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25198-3";

	/** 
	*<div class="en">Code for Ethionamide 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHIONAMIDE_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25196-7";

	/** 
	*<div class="en">Code for Ethionamide [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ETHIONAMIDE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20382-8";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus Ab [Titer] in Serum</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB_TITER_IN_SERUM_CODE="26061-2";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus Ab [Titer] in Serum by Complement fixation</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="26058-8";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus Ab [Units/volume] in Serum</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="31383-3";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgG Ab index [Units/volume] in Serum and CSF by Immunoassay</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_INDEX_UNITSVOLUME_IN_SERUM_AND_CSF_BY_IMMUNOASSAY_CODE="69928-0";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgG Ab [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="69927-2";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="69926-4";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="26062-0";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="26059-6";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgM Ab index [Units/volume] in Serum and CSF by Immunoassay</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_INDEX_UNITSVOLUME_IN_SERUM_AND_CSF_BY_IMMUNOASSAY_CODE="69925-6";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgM Ab [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="69924-9";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="69923-1";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="26063-8";

	/** 
	*<div class="en">Code for European tick borne encephalitis virus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="26060-4";

	/** 
	*<div class="en">Code for Flavivirus identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String FLAVIVIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6406-3";

	/** 
	*<div class="en">Code for Francisella tularensis</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_CODE="51526001";

	/** 
	*<div class="en">Code for Francisella tularensis Ab [Titer] in Serum</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_CODE="16875-7";

	/** 
	*<div class="en">Code for Francisella tularensis Ab [Titer] in Serum by Agglutination</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_AGGLUTINATION_CODE="23125-8";

	/** 
	*<div class="en">Code for Francisella tularensis Ab [Titer] in Serum by Complement fixation</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="23741-2";

	/** 
	*<div class="en">Code for Francisella tularensis Ab [Titer] in Serum by Latex agglutination</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5167-2";

	/** 
	*<div class="en">Code for Francisella tularensis Ab [Titer] in Serum by Microagglutination</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_MICROAGGLUTINATION_CODE="33683-4";

	/** 
	*<div class="en">Code for Francisella tularensis Ab [Titer] in Serum by Tube agglutination</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AB_TITER_IN_SERUM_BY_TUBE_AGGLUTINATION_CODE="33684-2";

	/** 
	*<div class="en">Code for Francisella tularensis Ab [Units/volume] in Serum</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AB_UNITSVOLUME_IN_SERUM_CODE="31396-5";

	/** 
	*<div class="en">Code for Francisella tularensis Ag [Presence] in Isolate by Immunofluorescence</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE_CODE="33678-4";

	/** 
	*<div class="en">Code for Francisella tularensis Ag [Presence] in Serum</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_SERUM_CODE="31828-7";

	/** 
	*<div class="en">Code for Francisella tularensis Ag [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="16879-9";

	/** 
	*<div class="en">Code for Francisella tularensis Ag [Presence] in Tissue by Immune stain</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN_CODE="23126-6";

	/** 
	*<div class="en">Code for Francisella tularensis Ag [Presence] in Tissue by Immunofluorescence</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE_CODE="23127-4";

	/** 
	*<div class="en">Code for Francisella tularensis Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31829-5";

	/** 
	*<div class="en">Code for Francisella tularensis Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6408-9";

	/** 
	*<div class="en">Code for Francisella tularensis Ag [Presence] in Unspecified specimen by Slide agglutination</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_SLIDE_AGGLUTINATION_CODE="45041-1";

	/** 
	*<div class="en">Code for Francisella tularensis A DNA [Presence] in Tissue by Probe and target amplification method</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_A_DNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="23122-5";

	/** 
	*<div class="en">Code for Francisella tularensis A rRNA [Presence] in Tissue by DNA probe</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_A_RRNA_PRESENCE_IN_TISSUE_BY_DNA_PROBE_CODE="23123-3";

	/** 
	*<div class="en">Code for Francisella tularensis B DNA [Presence] in Tissue by Probe and target amplification method</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_B_DNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="23128-2";

	/** 
	*<div class="en">Code for Francisella tularensis B rRNA [Presence] in Tissue by DNA probe</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_B_RRNA_PRESENCE_IN_TISSUE_BY_DNA_PROBE_CODE="23129-0";

	/** 
	*<div class="en">Code for Francisella tularensis DNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_DNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="33680-0";

	/** 
	*<div class="en">Code for Francisella tularensis DNA [Presence] in Tissue by Probe and target amplification method</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_DNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="23130-8";

	/** 
	*<div class="en">Code for Francisella tularensis DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="33679-2";

	/** 
	*<div class="en">Code for Francisella tularensis IgA Ab [Titer] in Serum</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_IGA_AB_TITER_IN_SERUM_CODE="33576-0";

	/** 
	*<div class="en">Code for Francisella tularensis IgG Ab [Titer] in Serum</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_IGG_AB_TITER_IN_SERUM_CODE="33465-6";

	/** 
	*<div class="en">Code for Francisella tularensis IgG Ab [Units/volume] in Serum or Plasma</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_IGG_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE="70121-9";

	/** 
	*<div class="en">Code for Francisella tularensis IgM Ab [Presence] in Serum</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_IGM_AB_PRESENCE_IN_SERUM_CODE="7890-7";

	/** 
	*<div class="en">Code for Francisella tularensis IgM Ab [Presence] in Serum by Latex agglutination</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_IGM_AB_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="6407-1";

	/** 
	*<div class="en">Code for Francisella tularensis IgM Ab [Titer] in Serum</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_IGM_AB_TITER_IN_SERUM_CODE="33466-4";

	/** 
	*<div class="en">Code for Francisella tularensis IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="16878-1";

	/** 
	*<div class="en">Code for Francisella tularensis [Presence] in Isolate by Cell wall fatty acid analysis</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_PRESENCE_IN_ISOLATE_BY_CELL_WALL_FATTY_ACID_ANALYSIS_CODE="33682-6";

	/** 
	*<div class="en">Code for Francisella tularensis [Presence] in Isolate by Organism specific culture</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_PRESENCE_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="33677-6";

	/** 
	*<div class="en">Code for Francisella tularensis [Presence] in Unspecified specimen by Cell wall fatty acid analysis</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_CELL_WALL_FATTY_ACID_ANALYSIS_CODE="33681-8";

	/** 
	*<div class="en">Code for Francisella tularensis [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="33676-8";

	/** 
	*<div class="en">Code for Francisella tularensis rRNA [Presence] in Tissue by DNA probe</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_RRNA_PRESENCE_IN_TISSUE_BY_DNA_PROBE_CODE="23131-6";

	/** 
	*<div class="en">Code for Francisella tularensis ss. holarctica</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_SS_HOLARCTICA_CODE="60502008";

	/** 
	*<div class="en">Code for Francisella tularensis ss. mediasiatica</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_SS_MEDIASIATICA_CODE="23930001";

	/** 
	*<div class="en">Code for Francisella tularensis ss. tularensis</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_SS_TULARENSIS_CODE="91508008";

	/** 
	*<div class="en">Code for Francisella tularensis subtype [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String FRANCISELLA_TULARENSIS_SUBTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="46732-4";

	/** 
	*<div class="en">Code for Gatifloxacin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String GATIFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="41494-6";

	/** 
	*<div class="en">Code for Gentamicin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String GENTAMICIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="50630-3";

	/** 
	*<div class="en">Code for Haemophilus influenzae</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_CODE="44470000";

	/** 
	*<div class="en">Code for Haemophilus influenzae Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="32139-8";

	/** 
	*<div class="en">Code for Haemophilus influenzae Ag [Presence] in Urine</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_AG_PRESENCE_IN_URINE_CODE="40771-8";

	/** 
	*<div class="en">Code for Haemophilus influenzae A Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="16926-8";

	/** 
	*<div class="en">Code for Haemophilus influenzae A Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6610-0";

	/** 
	*<div class="en">Code for Haemophilus influenzae A Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31833-7";

	/** 
	*<div class="en">Code for Haemophilus influenzae A Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6414-7";

	/** 
	*<div class="en">Code for Haemophilus influenzae A Ag [Presence] in Urine</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_A_AG_PRESENCE_IN_URINE_CODE="16925-0";

	/** 
	*<div class="en">Code for Haemophilus influenzae A DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_A_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="29906-5";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Body fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_BODY_FLUID_CODE="41495-3";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="24010-1";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6611-8";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="14321-4";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Serum</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_SERUM_CODE="43429-0";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31834-5";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6599-5";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="21320-7";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Presence] in Urine</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_PRESENCE_IN_URINE_CODE="15379-1";

	/** 
	*<div class="en">Code for Haemophilus influenzae B Ag [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_AG_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="20486-7";

	/** 
	*<div class="en">Code for Haemophilus influenzae B DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53607-8";

	/** 
	*<div class="en">Code for Haemophilus influenzae B DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_B_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="29907-3";

	/** 
	*<div class="en">Code for Haemophilus influenzae C Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31835-2";

	/** 
	*<div class="en">Code for Haemophilus influenzae C Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6612-6";

	/** 
	*<div class="en">Code for Haemophilus influenzae C Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31836-0";

	/** 
	*<div class="en">Code for Haemophilus influenzae C Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="8271-9";

	/** 
	*<div class="en">Code for Haemophilus influenzae DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="61366-1";

	/** 
	*<div class="en">Code for Haemophilus influenzae D Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_D_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31837-8";

	/** 
	*<div class="en">Code for Haemophilus influenzae D Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_D_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6613-4";

	/** 
	*<div class="en">Code for Haemophilus influenzae D Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_D_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31838-6";

	/** 
	*<div class="en">Code for Haemophilus influenzae D Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_D_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6416-2";

	/** 
	*<div class="en">Code for Haemophilus influenzae E Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_E_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31839-4";

	/** 
	*<div class="en">Code for Haemophilus influenzae E Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_E_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6614-2";

	/** 
	*<div class="en">Code for Haemophilus influenzae E Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_E_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31840-2";

	/** 
	*<div class="en">Code for Haemophilus influenzae E Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_E_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6417-0";

	/** 
	*<div class="en">Code for Haemophilus influenzae F Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_F_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31841-0";

	/** 
	*<div class="en">Code for Haemophilus influenzae F Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_F_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6615-9";

	/** 
	*<div class="en">Code for Haemophilus influenzae F Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_F_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31842-8";

	/** 
	*<div class="en">Code for Haemophilus influenzae F Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_F_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6418-8";

	/** 
	*<div class="en">Code for Haemophilus influenzae [Identifier] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="69410-9";

	/** 
	*<div class="en">Code for Haemophilus influenzae, not B</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_NOT_B_CODE="115407004";

	/** 
	*<div class="en">Code for Haemophilus influenzae rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="5006-2";

	/** 
	*<div class="en">Code for Haemophilus influenzae serogroup DNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_SEROGROUP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="58473-0";

	/** 
	*<div class="en">Code for Haemophilus influenzae serotype [Identifier] in Isolate by Agglutination</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_SEROTYPE_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION_CODE="58739-4";

	/** 
	*<div class="en">Code for Haemophilus influenzae type A</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_A_CODE="103441001";

	/** 
	*<div class="en">Code for Haemophilus influenzae type B</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_B_CODE="103442008";

	/** 
	*<div class="en">Code for Haemophilus influenzae type C</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_C_CODE="103443003";

	/** 
	*<div class="en">Code for Haemophilus influenzae type D</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_D_CODE="103444009";

	/** 
	*<div class="en">Code for Haemophilus influenzae type E</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_E_CODE="103445005";

	/** 
	*<div class="en">Code for Haemophilus influenzae type F</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_F_CODE="103446006";

	/** 
	*<div class="en">Code for Haemophilus influenzae type [Identifier] in Isolate</div>
	*/
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_IDENTIFIER_IN_ISOLATE_CODE="49721-4";

	/** 
	*<div class="en">Code for Hantavirus Ab [Titer] in Serum</div>
	*/
	public static final String HANTAVIRUS_AB_TITER_IN_SERUM_CODE="60264-9";

	/** 
	*<div class="en">Code for Hantavirus Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="5046-8";

	/** 
	*<div class="en">Code for Hantavirus Ag [Presence] in Tissue by Immune stain</div>
	*/
	public static final String HANTAVIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN_CODE="65762-7";

	/** 
	*<div class="en">Code for Hantavirus dobrova IgM Ab [Presence] in Serum or Plasma by Immunofluorescence</div>
	*/
	public static final String HANTAVIRUS_DOBROVA_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE_CODE="70054-2";

	/** 
	*<div class="en">Code for Hantavirus hantaan Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_HANTAAN_AB_UNITSVOLUME_IN_SERUM_CODE="13289-4";

	/** 
	*<div class="en">Code for Hantavirus hantaan IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_HANTAAN_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="7895-6";

	/** 
	*<div class="en">Code for Hantavirus hantaan IgM Ab [Presence] in Serum or Plasma by Immunofluorescence</div>
	*/
	public static final String HANTAVIRUS_HANTAAN_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE_CODE="70053-4";

	/** 
	*<div class="en">Code for Hantavirus hantaan IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_HANTAAN_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="7896-4";

	/** 
	*<div class="en">Code for Hantavirus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="35392-0";

	/** 
	*<div class="en">Code for Hantavirus IgM Ab [Presence] in Serum</div>
	*/
	public static final String HANTAVIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="32131-5";

	/** 
	*<div class="en">Code for Hantavirus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="35393-8";

	/** 
	*<div class="en">Code for Hantavirus puumala IgG Ab [Titer] in Serum</div>
	*/
	public static final String HANTAVIRUS_PUUMALA_IGG_AB_TITER_IN_SERUM_CODE="22308-1";

	/** 
	*<div class="en">Code for Hantavirus puumala IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String HANTAVIRUS_PUUMALA_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="21322-3";

	/** 
	*<div class="en">Code for Hantavirus puumala IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_PUUMALA_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="7897-2";

	/** 
	*<div class="en">Code for Hantavirus puumala IgG+IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_PUUMALA_IGG_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="16928-4";

	/** 
	*<div class="en">Code for Hantavirus puumala IgM Ab [Presence] in Serum or Plasma by Immunofluorescence</div>
	*/
	public static final String HANTAVIRUS_PUUMALA_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE_CODE="70058-3";

	/** 
	*<div class="en">Code for Hantavirus puumala IgM Ab [Titer] in Serum</div>
	*/
	public static final String HANTAVIRUS_PUUMALA_IGM_AB_TITER_IN_SERUM_CODE="22309-9";

	/** 
	*<div class="en">Code for Hantavirus puumala IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String HANTAVIRUS_PUUMALA_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="21323-1";

	/** 
	*<div class="en">Code for Hantavirus puumala IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_PUUMALA_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="7898-0";

	/** 
	*<div class="en">Code for Hantavirus RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String HANTAVIRUS_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="7899-8";

	/** 
	*<div class="en">Code for Hantavirus saaremaa IgM Ab [Presence] in Serum or Plasma by Immunofluorescence</div>
	*/
	public static final String HANTAVIRUS_SAAREMAA_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE_CODE="70057-5";

	/** 
	*<div class="en">Code for Hantavirus sin nombre IgG Ab [Titer] in Serum</div>
	*/
	public static final String HANTAVIRUS_SIN_NOMBRE_IGG_AB_TITER_IN_SERUM_CODE="23867-5";

	/** 
	*<div class="en">Code for Hantavirus sin nombre IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_SIN_NOMBRE_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="31408-8";

	/** 
	*<div class="en">Code for Hantavirus sin nombre IgM Ab [Presence] in Serum</div>
	*/
	public static final String HANTAVIRUS_SIN_NOMBRE_IGM_AB_PRESENCE_IN_SERUM_CODE="26650-2";

	/** 
	*<div class="en">Code for Hantavirus sin nombre IgM Ab [Titer] in Serum</div>
	*/
	public static final String HANTAVIRUS_SIN_NOMBRE_IGM_AB_TITER_IN_SERUM_CODE="23868-3";

	/** 
	*<div class="en">Code for Hantavirus sin nombre IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HANTAVIRUS_SIN_NOMBRE_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="31409-6";

	/** 
	*<div class="en">Code for Hepatitis A virus IgM Ab [Presence] in Body fluid</div>
	*/
	public static final String HEPATITIS_A_VIRUS_IGM_AB_PRESENCE_IN_BODY_FLUID_CODE="51660-9";

	/** 
	*<div class="en">Code for Hepatitis A virus IgM Ab [Presence] in Serum</div>
	*/
	public static final String HEPATITIS_A_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="22314-9";

	/** 
	*<div class="en">Code for Hepatitis A virus IgM Ab [Presence] in Serum or Plasma by Immunoassay</div>
	*/
	public static final String HEPATITIS_A_VIRUS_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE="13950-1";

	/** 
	*<div class="en">Code for Hepatitis A virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="22315-6";

	/** 
	*<div class="en">Code for Hepatitis A virus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5181-3";

	/** 
	*<div class="en">Code for Hepatitis A virus IgM Ab [Units/volume] in Serum by Radioimmunoassay (RIA)</div>
	*/
	public static final String HEPATITIS_A_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_RADIOIMMUNOASSAY_RIA_CODE="5182-1";

	/** 
	*<div class="en">Code for Hepatitis A virus IgM and total [interpretation] in Serum</div>
	*/
	public static final String HEPATITIS_A_VIRUS_IGM_AND_TOTAL_INTERPRETATION_IN_SERUM_CODE="53776-1";

	/** 
	*<div class="en">Code for Hepatitis A virus RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_A_VIRUS_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="7904-6";

	/** 
	*<div class="en">Code for Hepatitis B virus basal core promoter mutation [Identifier] in Serum by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_BASAL_CORE_PROMOTER_MUTATION_IDENTIFIER_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="54210-0";

	/** 
	*<div class="en">Code for Hepatitis B virus core Ag [Presence] in Tissue by Immune stain</div>
	*/
	public static final String HEPATITIS_B_VIRUS_CORE_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN_CODE="10673-2";

	/** 
	*<div class="en">Code for Hepatitis B virus core IgM Ab [Presence] in Body fluid</div>
	*/
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_BODY_FLUID_CODE="51658-3";

	/** 
	*<div class="en">Code for Hepatitis B virus core IgM Ab [Presence] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_SERUM_CODE="31204-1";

	/** 
	*<div class="en">Code for Hepatitis B virus core IgM Ab [Presence] in Serum or Plasma by Immunoassay</div>
	*/
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE="24113-3";

	/** 
	*<div class="en">Code for Hepatitis B virus core IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="22319-8";

	/** 
	*<div class="en">Code for Hepatitis B virus core IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5185-4";

	/** 
	*<div class="en">Code for Hepatitis B virus core IgM Ab [Units/volume] in Serum by Radioimmunoassay (RIA)</div>
	*/
	public static final String HEPATITIS_B_VIRUS_CORE_IGM_AB_UNITSVOLUME_IN_SERUM_BY_RADIOIMMUNOASSAY_RIA_CODE="5186-2";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [log units/volume] (viral load) in Bone marrow by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49602-6";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [log units/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49601-8";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [log units/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48398-2";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [log units/volume] (viral load) in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49606-7";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [log units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49600-0";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Log #/volume] (viral load) in Bone marrow by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49359-3";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Log #/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49367-6";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Log #/volume] (viral load) in Serum by Probe and signal amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="40459-0";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="45161-7";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Log #/volume] (viral load) in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49361-9";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Log #/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_LOG_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49366-8";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Mass/volume] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_MASSVOLUME_IN_SERUM_CODE="32686-8";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Mass/volume] (viral load) in Serum by DNA probe</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_MASSVOLUME_VIRAL_LOAD_IN_SERUM_BY_DNA_PROBE_CODE="23869-1";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Mass/volume] (viral load) in Serum by Probe and signal amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_MASSVOLUME_VIRAL_LOAD_IN_SERUM_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="29900-8";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="5007-0";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="29610-3";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Presence] in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="5008-8";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="5009-6";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Units/volume] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_IN_SERUM_CODE="11258-1";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Units/volume] (viral load) in Bone marrow by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49358-5";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Units/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49357-7";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="42595-9";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Units/volume] (viral load) in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49368-4";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49360-1";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [#/volume] (viral load) in Bone marrow by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49364-3";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [#/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49363-5";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [#/volume] (viral load) in Serum by Probe and signal amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="20442-0";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="29615-2";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 200 copies/ml</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_200_COPIESML_CODE="47216-7";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 500 copies/mL</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_500_COPIESML_CODE="48650-6";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [#/volume] (viral load) in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49365-0";

	/** 
	*<div class="en">Code for Hepatitis B virus DNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_DNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49362-7";

	/** 
	*<div class="en">Code for Hepatitis B virus e Ag [Presence] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM_CODE="31844-4";

	/** 
	*<div class="en">Code for Hepatitis B virus e Ag [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="13954-3";

	/** 
	*<div class="en">Code for Hepatitis B virus e Ag [Presence] in Serum by Radioimmunoassay (RIA)</div>
	*/
	public static final String HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_SERUM_BY_RADIOIMMUNOASSAY_RIA_CODE="5192-0";

	/** 
	*<div class="en">Code for Hepatitis B virus e Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String HEPATITIS_B_VIRUS_E_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="39007-0";

	/** 
	*<div class="en">Code for Hepatitis B virus e Ag [Titer] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_E_AG_TITER_IN_SERUM_CODE="32178-6";

	/** 
	*<div class="en">Code for Hepatitis B virus e Ag [Units/volume] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_E_AG_UNITSVOLUME_IN_SERUM_CODE="31845-1";

	/** 
	*<div class="en">Code for Hepatitis B virus e Ag [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_B_VIRUS_E_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5191-2";

	/** 
	*<div class="en">Code for Hepatitis B virus genotype [Identifier] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_GENOTYPE_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="32366-7";

	/** 
	*<div class="en">Code for Hepatitis B virus polymerase DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_POLYMERASE_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="16934-2";

	/** 
	*<div class="en">Code for Hepatitis B virus precore TAG [Presence] in Serum Qualitative by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_PRECORE_TAG_PRESENCE_IN_SERUM_QUALITATIVE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="33633-9";

	/** 
	*<div class="en">Code for Hepatitis B virus rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String HEPATITIS_B_VIRUS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="6421-2";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag in Serum or Plasma by Confirmatory method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_IN_SERUM_OR_PLASMA_BY_CONFIRMATORY_METHOD_CODE="70154-0";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Blood from donor by Neutralization test</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_BLOOD_FROM_DONOR_BY_NEUTRALIZATION_TEST_CODE="50967-9";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Body fluid</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_BODY_FLUID_CODE="51659-1";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="42505-8";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_CODE="5195-3";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Serum by Radioimmunoassay (RIA)</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_BY_RADIOIMMUNOASSAY_RIA_CODE="5197-9";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Serum from donor by Immunoassay</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOASSAY_CODE="47364-5";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Serum or Plasma by Confirmatory method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_CONFIRMATORY_METHOD_CODE="65633-0";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Serum or Plasma by Immunoassay</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE="5196-1";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Serum or Plasma by Neutralization test</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_NEUTRALIZATION_TEST_CODE="7905-3";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Tissue by Immune stain</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN_CODE="10674-0";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Presence] in Tissue Qualitative by Orcein stain</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_TISSUE_QUALITATIVE_BY_ORCEIN_STAIN_CODE="10675-7";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Units/volume] in Serum</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_UNITSVOLUME_IN_SERUM_CODE="58452-4";

	/** 
	*<div class="en">Code for Hepatitis B virus surface Ag [Units/volume] in Serum or Plasma by Immunoassay</div>
	*/
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_UNITSVOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE="63557-3";

	/** 
	*<div class="en">Code for Hepatitis B virus S+pol gene [Identifier] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_S_POL_GENE_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="42322-8";

	/** 
	*<div class="en">Code for Hepatitis B Virus YMDD [Presence] in Serum or Plasma Qualitative by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_B_VIRUS_YMDD_PRESENCE_IN_SERUM_OR_PLASMA_QUALITATIVE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="43279-9";

	/** 
	*<div class="en">Code for Hepatitis C virus 100-3 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_100_3_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9608-1";

	/** 
	*<div class="en">Code for Hepatitis C virus 100+5-1-1 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_100_5_1_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="23870-9";

	/** 
	*<div class="en">Code for Hepatitis C virus 22-3 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_22_3_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9609-9";

	/** 
	*<div class="en">Code for Hepatitis C virus 5-1-1 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_5_1_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="11076-7";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab band pattern [interpretation] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="24011-9";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab.IgG band pattern [interpretation] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_IGG_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="34162-8";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab [Presence] in Body fluid by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOBLOT_IB_CODE="39008-8";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="5199-5";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab [Presence] in Serum from donor by Immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOASSAY_CODE="47365-2";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab [Presence] in Serum or Plasma by Immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE="13955-0";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab [Presence] in Serum, Plasma or Blood Qualitative by Rapid immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_PLASMA_OR_BLOOD_QUALITATIVE_BY_RAPID_IMMUNOASSAY_CODE="72376-7";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab Signal/Cutoff in Serum or Plasma by Immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_SIGNALCUTOFF_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE="48159-8";

	/** 
	*<div class="en">Code for Hepatitis C virus Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5198-7";

	/** 
	*<div class="en">Code for Hepatitis C virus Ag [Presence] in Blood or Marrow from donor</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AG_PRESENCE_IN_BLOOD_OR_MARROW_FROM_DONOR_CODE="49846-9";

	/** 
	*<div class="en">Code for Hepatitis C virus Ag [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="54914-7";

	/** 
	*<div class="en">Code for Hepatitis C virus c100p+5-1-1 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_C100P_5_1_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="51649-2";

	/** 
	*<div class="en">Code for Hepatitis C virus c1 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_C1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="56926-9";

	/** 
	*<div class="en">Code for Hepatitis C virus c22p Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_C22P_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="44813-4";

	/** 
	*<div class="en">Code for Hepatitis C virus c2 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_C2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="56927-7";

	/** 
	*<div class="en">Code for Hepatitis C virus c33c Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_C33C_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9610-7";

	/** 
	*<div class="en">Code for Hepatitis C virus E2 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_E2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="56928-5";

	/** 
	*<div class="en">Code for Hepatitis C virus genotype [Identifier] in Blood by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48574-8";

	/** 
	*<div class="en">Code for Hepatitis C virus genotype [Identifier] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="32286-7";

	/** 
	*<div class="en">Code for Hepatitis C virus genotype [Identifier] in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49607-5";

	/** 
	*<div class="en">Code for Hepatitis C virus genotype [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_GENOTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48575-5";

	/** 
	*<div class="en">Code for Hepatitis C virus IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="40726-2";

	/** 
	*<div class="en">Code for Hepatitis C virus IgG Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="33462-3";

	/** 
	*<div class="en">Code for Hepatitis C virus IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="57006-9";

	/** 
	*<div class="en">Code for Hepatitis C virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HEPATITIS_C_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="53376-0";

	/** 
	*<div class="en">Code for Hepatitis C virus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HEPATITIS_C_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51824-1";

	/** 
	*<div class="en">Code for Hepatitis C virus NS3 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_NS3_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="56929-3";

	/** 
	*<div class="en">Code for Hepatitis C virus NS4 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_NS4_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="56930-1";

	/** 
	*<div class="en">Code for Hepatitis C virus NS5 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HEPATITIS_C_VIRUS_NS5_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="23871-7";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [log units/volume] (viral load) in Bone marrow by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49604-2";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [log units/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49603-4";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [log units/volume] (viral load) in Serum or Plasma by Probe and signal amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="42617-1";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [log units/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="38180-6";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [log units/volume] (viral load) in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49608-3";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [log units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49605-9";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Log #/volume] (viral load) in Bone marrow by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49374-2";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Log #/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49373-4";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and signal amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="42003-4";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="47252-2";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Log #/volume] (viral load) in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49375-9";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Log #/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_LOG_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49372-6";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="5010-4";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Presence] in Body fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_BODY_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="51655-9";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="11259-9";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Presence] in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="5011-2";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Presence] in Unspecified specimen by Probe and signal amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="48576-3";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="5012-0";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Bone marrow by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49378-3";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49377-5";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and signal amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="29609-5";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="11011-4";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 500 IU/mL</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_500_IUML_CODE="34703-9";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 50 iU/mL</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_50_IUML_CODE="34704-7";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 5 iU/mL</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_5_IUML_CODE="49758-6";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Serum or Plasma by Probe with amplification</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_CODE="10676-5";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49379-1";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49376-7";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [#/volume] (viral load) in Bone marrow by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_BONE_MARROW_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49370-0";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [#/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49369-2";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [#/volume] (viral load) in Serum or Plasma by Probe and signal amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="20571-6";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="20416-4";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [#/volume] (viral load) in Tissue by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49371-8";

	/** 
	*<div class="en">Code for Hepatitis C virus RNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HEPATITIS_C_VIRUS_RNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49380-9";

	/** 
	*<div class="en">Code for HIV 1+2 Ab+HIV1 p24 Ag [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_2_AB_HIV1_P24_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="56888-1";

	/** 
	*<div class="en">Code for HIV 1+2 Ab+HIV1 p24 Ag [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_2_AB_HIV1_P24_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="58900-2";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HIV_1_2_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="32602-5";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_2_AB_PRESENCE_IN_SERUM_CODE="7918-6";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="44873-8";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Presence] in Serum from donor</div>
	*/
	public static final String HIV_1_2_AB_PRESENCE_IN_SERUM_FROM_DONOR_CODE="44533-8";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Presence] in Serum or Plasma by Immunoassay</div>
	*/
	public static final String HIV_1_2_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY_CODE="31201-7";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Presence] in Unspecified specimen</div>
	*/
	public static final String HIV_1_2_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="43010-8";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String HIV_1_2_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="42600-7";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Presence] in Unspecified specimen Qualitative by Rapid immunoassay</div>
	*/
	public static final String HIV_1_2_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_QUALITATIVE_BY_RAPID_IMMUNOASSAY_CODE="49580-4";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Units/volume] in Serum</div>
	*/
	public static final String HIV_1_2_AB_UNITSVOLUME_IN_SERUM_CODE="22357-8";

	/** 
	*<div class="en">Code for HIV 1+2 Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_2_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5223-3";

	/** 
	*<div class="en">Code for HIV 1+2 IgG Ab [Presence] in Dried blood spot</div>
	*/
	public static final String HIV_1_2_IGG_AB_PRESENCE_IN_DRIED_BLOOD_SPOT_CODE="54086-4";

	/** 
	*<div class="en">Code for HIV 1+2 IgG Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_2_IGG_AB_PRESENCE_IN_SERUM_CODE="43009-0";

	/** 
	*<div class="en">Code for HIV 1+2 IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="40733-8";

	/** 
	*<div class="en">Code for HIV 1+2 IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String HIV_1_2_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="43008-2";

	/** 
	*<div class="en">Code for HIV 1+2 IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_2_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="41290-8";

	/** 
	*<div class="en">Code for HIV 1 Ab band pattern [interpretation] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_AB_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="13499-9";

	/** 
	*<div class="en">Code for HIV 1 Ab.IgG band pattern [interpretation] in Cerebral spinal fluid by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_AB_IGG_BAND_PATTERN_INTERPRETATION_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB_CODE="28052-9";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Body fluid</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_BODY_FLUID_CODE="29327-4";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Body fluid by Immunoassay</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOASSAY_CODE="34591-8";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Body fluid by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOBLOT_IB_CODE="34592-6";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Capillary blood</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_CAPILLARY_BLOOD_CODE="41145-4";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Capillary blood by Immunoassay</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_CAPILLARY_BLOOD_BY_IMMUNOASSAY_CODE="33866-5";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="16974-8";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Cerebral spinal fluid by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB_CODE="57974-8";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="42627-0";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Saliva (oral fluid)</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_CODE="41144-7";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Saliva (oral fluid) by Immunoassay</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOASSAY_CODE="35437-3";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35439-9";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SERUM_CODE="7917-8";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="29893-5";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="5221-7";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="14092-1";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Serum from donor</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SERUM_FROM_DONOR_CODE="21007-0";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Serum, Plasma or Blood Qualitative by Rapid immunoassay</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_SERUM_PLASMA_OR_BLOOD_QUALITATIVE_BY_RAPID_IMMUNOASSAY_CODE="68961-2";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Unspecified specimen</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="53379-4";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Unspecified specimen Qualitative by Rapid immunoassay</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_QUALITATIVE_BY_RAPID_IMMUNOASSAY_CODE="49905-3";

	/** 
	*<div class="en">Code for HIV 1 Ab [Presence] in Urine by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_AB_PRESENCE_IN_URINE_BY_IMMUNOBLOT_IB_CODE="32571-2";

	/** 
	*<div class="en">Code for HIV 1 Ab [Units/volume] in Saliva (oral fluid)</div>
	*/
	public static final String HIV_1_AB_UNITSVOLUME_IN_SALIVA_ORAL_FLUID_CODE="41143-9";

	/** 
	*<div class="en">Code for HIV 1 Ab [Units/volume] in Saliva (oral fluid) by Immunoassay</div>
	*/
	public static final String HIV_1_AB_UNITSVOLUME_IN_SALIVA_ORAL_FLUID_BY_IMMUNOASSAY_CODE="35438-1";

	/** 
	*<div class="en">Code for HIV 1 Ab [Units/volume] in Serum</div>
	*/
	public static final String HIV_1_AB_UNITSVOLUME_IN_SERUM_CODE="22356-0";

	/** 
	*<div class="en">Code for HIV 1 Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5220-9";

	/** 
	*<div class="en">Code for HIV 1 Ab [Units/volume] in Serum by Immunofluorescence</div>
	*/
	public static final String HIV_1_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="43599-0";

	/** 
	*<div class="en">Code for HIV 1 Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HIV_1_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="16977-1";

	/** 
	*<div class="en">Code for HIV 1 Ag [Presence] in Serum</div>
	*/
	public static final String HIV_1_AG_PRESENCE_IN_SERUM_CODE="24012-7";

	/** 
	*<div class="en">Code for HIV 1 Ag [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="5222-5";

	/** 
	*<div class="en">Code for HIV 1 Ag [Presence] in Serum from donor</div>
	*/
	public static final String HIV_1_AG_PRESENCE_IN_SERUM_FROM_DONOR_CODE="44531-2";

	/** 
	*<div class="en">Code for HIV 1 Ag [Units/volume] in Serum</div>
	*/
	public static final String HIV_1_AG_UNITSVOLUME_IN_SERUM_CODE="16976-3";

	/** 
	*<div class="en">Code for HIV 1 and 2 Ab band pattern [interpretation] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_AND_2_AB_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="43185-8";

	/** 
	*<div class="en">Code for HIV 1 and 2 Ab [Identifier] in Serum or Plasma by Rapid immunoassay</div>
	*/
	public static final String HIV_1_AND_2_AB_IDENTIFIER_IN_SERUM_OR_PLASMA_BY_RAPID_IMMUNOASSAY_CODE="69668-2";

	/** 
	*<div class="en">Code for HIV 1 and 2 Ab [interpretation] in Serum Narrative</div>
	*/
	public static final String HIV_1_AND_2_AB_INTERPRETATION_IN_SERUM_NARRATIVE_CODE="42768-2";

	/** 
	*<div class="en">Code for HIV 1 DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String HIV_1_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="44871-2";

	/** 
	*<div class="en">Code for HIV 1 DNA [Presence] in Blood by Probe with amplification</div>
	*/
	public static final String HIV_1_DNA_PRESENCE_IN_BLOOD_BY_PROBE_WITH_AMPLIFICATION_CODE="9837-6";

	/** 
	*<div class="en">Code for HIV 1 DNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_1_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="30245-5";

	/** 
	*<div class="en">Code for HIV 1 gp105 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP105_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12893-4";

	/** 
	*<div class="en">Code for HIV 1 gp120 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP120_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35441-5";

	/** 
	*<div class="en">Code for HIV 1 gp120 Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_GP120_AB_PRESENCE_IN_SERUM_CODE="44532-0";

	/** 
	*<div class="en">Code for HIV 1 gp120 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP120_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9661-0";

	/** 
	*<div class="en">Code for HIV 1 gp120+gp160 Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_GP120_GP160_AB_PRESENCE_IN_SERUM_CODE="43013-2";

	/** 
	*<div class="en">Code for HIV 1 gp120+gp160 Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_GP120_GP160_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="40439-2";

	/** 
	*<div class="en">Code for HIV 1 gp120+gp160 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP120_GP160_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="14126-7";

	/** 
	*<div class="en">Code for HIV 1 gp160 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP160_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35440-7";

	/** 
	*<div class="en">Code for HIV 1 gp160 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP160_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9660-2";

	/** 
	*<div class="en">Code for HIV 1 gp34 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP34_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12870-2";

	/** 
	*<div class="en">Code for HIV 1 gp40 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP40_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="35452-2";

	/** 
	*<div class="en">Code for HIV 1 gp41 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP41_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35446-4";

	/** 
	*<div class="en">Code for HIV 1 gp41 Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_GP41_AB_PRESENCE_IN_SERUM_CODE="43012-4";

	/** 
	*<div class="en">Code for HIV 1 gp41 Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_GP41_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="40438-4";

	/** 
	*<div class="en">Code for HIV 1 gp41 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP41_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9662-8";

	/** 
	*<div class="en">Code for HIV 1 gp41+gp43 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_GP41_GP43_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="19110-6";

	/** 
	*<div class="en">Code for HIV 1 IgG Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HIV_1_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31430-2";

	/** 
	*<div class="en">Code for HIV 1 IgG Ab [Presence] in Cerebral spinal fluid by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB_CODE="28004-0";

	/** 
	*<div class="en">Code for HIV 1 IgG Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_IGG_AB_PRESENCE_IN_SERUM_CODE="16975-5";

	/** 
	*<div class="en">Code for HIV 1 IgG Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="40732-0";

	/** 
	*<div class="en">Code for HIV 1 [interpretation] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_INTERPRETATION_IN_SERUM_BY_IMMUNOASSAY_CODE="44607-0";

	/** 
	*<div class="en">Code for HIV 1 [interpretation] in Serum by Immunoassay Narrative</div>
	*/
	public static final String HIV_1_INTERPRETATION_IN_SERUM_BY_IMMUNOASSAY_NARRATIVE_CODE="49483-1";

	/** 
	*<div class="en">Code for HIV 1+O+2 Ab [Presence] in Body fluid</div>
	*/
	public static final String HIV_1_O_2_AB_PRESENCE_IN_BODY_FLUID_CODE="57975-5";

	/** 
	*<div class="en">Code for HIV 1+O+2 Ab [Presence] in Serum or Plasma</div>
	*/
	public static final String HIV_1_O_2_AB_PRESENCE_IN_SERUM_OR_PLASMA_CODE="48345-3";

	/** 
	*<div class="en">Code for HIV 1+O+2 Ab [Units/volume] in Serum or Plasma</div>
	*/
	public static final String HIV_1_O_2_AB_UNITSVOLUME_IN_SERUM_OR_PLASMA_CODE="48346-1";

	/** 
	*<div class="en">Code for HIV 1 p15 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P15_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12872-8";

	/** 
	*<div class="en">Code for HIV 1 p15+p18 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P15_P18_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="16132-3";

	/** 
	*<div class="en">Code for HIV 1 p17 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P17_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35449-8";

	/** 
	*<div class="en">Code for HIV 1 p17 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P17_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9663-6";

	/** 
	*<div class="en">Code for HIV 1 p17+p18 Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_P17_P18_AB_PRESENCE_IN_SERUM_CODE="32842-7";

	/** 
	*<div class="en">Code for HIV 1 p17+p18 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P17_P18_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="32827-8";

	/** 
	*<div class="en">Code for HIV 1 p18 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P18_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35450-6";

	/** 
	*<div class="en">Code for HIV 1 p18 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P18_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12859-5";

	/** 
	*<div class="en">Code for HIV 1 p23 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P23_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12855-3";

	/** 
	*<div class="en">Code for HIV 1 p24 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P24_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35448-0";

	/** 
	*<div class="en">Code for HIV 1 p24 Ab [Presence] in Serum</div>
	*/
	public static final String HIV_1_P24_AB_PRESENCE_IN_SERUM_CODE="43011-6";

	/** 
	*<div class="en">Code for HIV 1 p24 Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_P24_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="40437-6";

	/** 
	*<div class="en">Code for HIV 1 p24 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P24_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9664-4";

	/** 
	*<div class="en">Code for HIV 1 p24 Ab [Titer] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P24_AB_TITER_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21331-4";

	/** 
	*<div class="en">Code for HIV 1 p24 Ab [Units/volume] in Serum</div>
	*/
	public static final String HIV_1_P24_AB_UNITSVOLUME_IN_SERUM_CODE="16978-9";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Mass/volume] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_P24_AG_MASSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="42339-2";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String HIV_1_P24_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="49718-0";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Presence] in Serum</div>
	*/
	public static final String HIV_1_P24_AG_PRESENCE_IN_SERUM_CODE="9821-0";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_P24_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="18396-2";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Presence] in Serum by Neutralization test</div>
	*/
	public static final String HIV_1_P24_AG_PRESENCE_IN_SERUM_BY_NEUTRALIZATION_TEST_CODE="33660-2";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Presence] in Serum from donor by Immunoassay</div>
	*/
	public static final String HIV_1_P24_AG_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOASSAY_CODE="44872-0";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String HIV_1_P24_AG_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="16979-7";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Units/volume] in Serum</div>
	*/
	public static final String HIV_1_P24_AG_UNITSVOLUME_IN_SERUM_CODE="9665-1";

	/** 
	*<div class="en">Code for HIV 1 p24 Ag [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HIV_1_P24_AG_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="53601-1";

	/** 
	*<div class="en">Code for HIV 1 p26 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P26_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12871-0";

	/** 
	*<div class="en">Code for HIV 1 p28 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P28_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12857-9";

	/** 
	*<div class="en">Code for HIV 1 p31 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P31_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35447-2";

	/** 
	*<div class="en">Code for HIV 1 p31 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P31_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9666-9";

	/** 
	*<div class="en">Code for HIV 1 p31+p32 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P31_P32_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="35564-4";

	/** 
	*<div class="en">Code for HIV 1 p32 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P32_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12858-7";

	/** 
	*<div class="en">Code for HIV 1 p40 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P40_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="35565-1";

	/** 
	*<div class="en">Code for HIV 1 p41 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P41_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="31072-2";

	/** 
	*<div class="en">Code for HIV 1 p41 Ab [Titer] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P41_AB_TITER_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21332-2";

	/** 
	*<div class="en">Code for HIV 1 p51 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P51_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35445-6";

	/** 
	*<div class="en">Code for HIV 1 p51 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P51_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9667-7";

	/** 
	*<div class="en">Code for HIV 1 p53 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P53_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12876-9";

	/** 
	*<div class="en">Code for HIV 1 p55 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P55_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35444-9";

	/** 
	*<div class="en">Code for HIV 1 p55 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P55_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9668-5";

	/** 
	*<div class="en">Code for HIV 1 p58 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P58_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12895-9";

	/** 
	*<div class="en">Code for HIV 1 p64 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P64_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12875-1";

	/** 
	*<div class="en">Code for HIV 1 p65 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P65_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35443-1";

	/** 
	*<div class="en">Code for HIV 1 p65 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P65_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12856-1";

	/** 
	*<div class="en">Code for HIV 1 p65+p66 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P65_P66_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="33508-3";

	/** 
	*<div class="en">Code for HIV 1 p66 Ab [Presence] in Saliva (oral fluid) by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P66_AB_PRESENCE_IN_SALIVA_ORAL_FLUID_BY_IMMUNOBLOT_IB_CODE="35442-3";

	/** 
	*<div class="en">Code for HIV 1 p66 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P66_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="9669-3";

	/** 
	*<div class="en">Code for HIV 1 p68 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_1_P68_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="12894-2";

	/** 
	*<div class="en">Code for HIV 1 proviral DNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_1_PROVIRAL_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48023-6";

	/** 
	*<div class="en">Code for HIV 1 RNA [interpretation] in Serum</div>
	*/
	public static final String HIV_1_RNA_INTERPRETATION_IN_SERUM_CODE="24013-5";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41497-9";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Plasma by Probe and signal amplification method</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="29539-4";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="29541-0";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 0.5 log copies/mL</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_0_5_LOG_COPIESML_CODE="51780-5";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 1.7 log copies/mL</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_1_7_LOG_COPIESML_CODE="48510-2";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 2.6 log copies/mL</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_2_6_LOG_COPIESML_CODE="48552-4";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe with amplification detection limit = 1.9 log copies/mL</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_DETECTION_LIMIT_equals_1_9_LOG_COPIESML_CODE="41516-6";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Serum or Plasma by Probe with amplification detection limit = 2.6 log copies/mL</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_DETECTION_LIMIT_equals_2_6_LOG_COPIESML_CODE="41514-1";

	/** 
	*<div class="en">Code for HIV 1 RNA [Log #/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_LOG_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49890-7";

	/** 
	*<div class="en">Code for HIV 1 RNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="5017-9";

	/** 
	*<div class="en">Code for HIV 1 RNA [Presence] in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="42917-5";

	/** 
	*<div class="en">Code for HIV 1 RNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="25835-0";

	/** 
	*<div class="en">Code for HIV 1 RNA [Presence] in Serum or Plasma from donor by Probe with amplification</div>
	*/
	public static final String HIV_1_RNA_PRESENCE_IN_SERUM_OR_PLASMA_FROM_DONOR_BY_PROBE_WITH_AMPLIFICATION_CODE="47359-5";

	/** 
	*<div class="en">Code for HIV 1 RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="5018-7";

	/** 
	*<div class="en">Code for HIV 1 RNA [Units/volume] (viral load) in Plasma by Probe and signal amplification method</div>
	*/
	public static final String HIV_1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="23876-6";

	/** 
	*<div class="en">Code for HIV 1 RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="62469-2";

	/** 
	*<div class="en">Code for HIV 1 RNA [Units/volume] (viral load) in Serum or Plasma by Probe with amplification</div>
	*/
	public static final String HIV_1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_CODE="10351-5";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] in Serum</div>
	*/
	public static final String HIV_1_RNA_VOLUME_IN_SERUM_CODE="21333-0";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41498-7";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Plasma by Probe and signal amplification method</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="59419-2";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Plasma by Probe and target amplification method detection limit = 20 copies/mL</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_20_COPIESML_CODE="70241-5";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by DNA probe</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_DNA_PROBE_CODE="21008-8";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="20447-9";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 400 copies/mL</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_400_COPIESML_CODE="48551-6";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe and target amplification method detection limit = 50 copies/mL</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_DETECTION_LIMIT_equals_50_COPIESML_CODE="48511-0";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe with amplification detection limit = 400 copies/mL</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_DETECTION_LIMIT_equals_400_COPIESML_CODE="41513-3";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by Probe with amplification detection limit = 75 copies/mL</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_WITH_AMPLIFICATION_DETECTION_LIMIT_equals_75_COPIESML_CODE="41515-8";

	/** 
	*<div class="en">Code for HIV 1 RNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HIV_1_RNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="25836-8";

	/** 
	*<div class="en">Code for HIV 2 Ab band pattern [interpretation] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_AB_BAND_PATTERN_INTERPRETATION_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="31073-0";

	/** 
	*<div class="en">Code for HIV 2 Ab [Presence] in Cerebral spinal fluid by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB_CODE="47029-4";

	/** 
	*<div class="en">Code for HIV 2 Ab [Presence] in Serum</div>
	*/
	public static final String HIV_2_AB_PRESENCE_IN_SERUM_CODE="7919-4";

	/** 
	*<div class="en">Code for HIV 2 Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String HIV_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="30361-0";

	/** 
	*<div class="en">Code for HIV 2 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="5225-8";

	/** 
	*<div class="en">Code for HIV 2 Ab Signal/Cutoff in Serum by Immunoassay</div>
	*/
	public static final String HIV_2_AB_SIGNALCUTOFF_IN_SERUM_BY_IMMUNOASSAY_CODE="51786-2";

	/** 
	*<div class="en">Code for HIV 2 Ab [Units/volume] in Serum</div>
	*/
	public static final String HIV_2_AB_UNITSVOLUME_IN_SERUM_CODE="22358-6";

	/** 
	*<div class="en">Code for HIV 2 Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String HIV_2_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5224-1";

	/** 
	*<div class="en">Code for HIV 2 DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String HIV_2_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="25841-8";

	/** 
	*<div class="en">Code for HIV 2 DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String HIV_2_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="25842-6";

	/** 
	*<div class="en">Code for HIV 2 gp105 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_GP105_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21334-8";

	/** 
	*<div class="en">Code for HIV 2 gp120 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_GP120_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21335-5";

	/** 
	*<div class="en">Code for HIV 2 gp125 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_GP125_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="10901-7";

	/** 
	*<div class="en">Code for HIV 2 gp140 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_GP140_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="57976-3";

	/** 
	*<div class="en">Code for HIV 2 gp15 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_GP15_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21336-3";

	/** 
	*<div class="en">Code for HIV 2 gp34 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_GP34_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21337-1";

	/** 
	*<div class="en">Code for HIV 2 gp36 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_GP36_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="10902-5";

	/** 
	*<div class="en">Code for HIV 2 gp80 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_GP80_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="11078-3";

	/** 
	*<div class="en">Code for HIV 2 IgG Ab [Presence] in Serum</div>
	*/
	public static final String HIV_2_IGG_AB_PRESENCE_IN_SERUM_CODE="33807-9";

	/** 
	*<div class="en">Code for HIV 2 IgG Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="33806-1";

	/** 
	*<div class="en">Code for HIV 2 p15 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P15_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="62456-9";

	/** 
	*<div class="en">Code for HIV 2 p16 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P16_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="57977-1";

	/** 
	*<div class="en">Code for HIV 2 p26 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P26_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="11079-1";

	/** 
	*<div class="en">Code for HIV 2 p31 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P31_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21338-9";

	/** 
	*<div class="en">Code for HIV 2 p31+p34 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P31_P34_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="45212-8";

	/** 
	*<div class="en">Code for HIV 2 p34 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P34_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="57978-9";

	/** 
	*<div class="en">Code for HIV 2 p41 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P41_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="13920-4";

	/** 
	*<div class="en">Code for HIV 2 p53 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P53_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="11080-9";

	/** 
	*<div class="en">Code for HIV 2 p55 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P55_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21339-7";

	/** 
	*<div class="en">Code for HIV 2 p56 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P56_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="11081-7";

	/** 
	*<div class="en">Code for HIV 2 p58 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P58_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="21340-5";

	/** 
	*<div class="en">Code for HIV 2 p68 Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String HIV_2_P68_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="11082-5";

	/** 
	*<div class="en">Code for HIV 2 proviral DNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_2_PROVIRAL_DNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="34699-9";

	/** 
	*<div class="en">Code for HIV 2 RNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_2_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="69353-1";

	/** 
	*<div class="en">Code for HIV 2 RNA [Units/volume] (viral load) in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String HIV_2_RNA_UNITSVOLUME_VIRAL_LOAD_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="69354-9";

	/** 
	*<div class="en">Code for HIV DNA [Presence] in Blood by Probe with amplification</div>
	*/
	public static final String HIV_DNA_PRESENCE_IN_BLOOD_BY_PROBE_WITH_AMPLIFICATION_CODE="9836-8";

	/** 
	*<div class="en">Code for HIV identified in Blood by Organism specific culture</div>
	*/
	public static final String HIV_IDENTIFIED_IN_BLOOD_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6429-5";

	/** 
	*<div class="en">Code for HIV identified in Semen by Organism specific culture</div>
	*/
	public static final String HIV_IDENTIFIED_IN_SEMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6430-3";

	/** 
	*<div class="en">Code for HIV identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String HIV_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6431-1";

	/** 
	*<div class="en">Code for Human coronavirus identified in Unspecified specimen</div>
	*/
	public static final String HUMAN_CORONAVIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_CODE="41454-0";

	/** 
	*<div class="en">Code for Imipenem [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String IMIPENEM_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23613-3";

	/** 
	*<div class="en">Code for Influenza virus Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="54240-7";

	/** 
	*<div class="en">Code for Influenza virus A Ab [Presence] in Serum --1st specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AB_PRESENCE_IN_SERUM_1ST_SPECIMEN_CODE="47232-4";

	/** 
	*<div class="en">Code for Influenza virus A Ab [Presence] in Serum --2nd specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AB_PRESENCE_IN_SERUM_2ND_SPECIMEN_CODE="47233-2";

	/** 
	*<div class="en">Code for Influenza virus A Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="24289-1";

	/** 
	*<div class="en">Code for Influenza virus A Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="24290-9";

	/** 
	*<div class="en">Code for Influenza virus A Ab [Titer] in Serum by Complement fixation --1st specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_1ST_SPECIMEN_CODE="24215-6";

	/** 
	*<div class="en">Code for Influenza virus A Ab [Titer] in Serum by Complement fixation --2nd specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_2ND_SPECIMEN_CODE="24216-4";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Identifier] in Isolate</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_IDENTIFIER_IN_ISOLATE_CODE="50697-2";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Bronchial specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_CODE="44562-7";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Bronchial specimen by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="44559-3";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Isolate by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE_CODE="49529-1";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Nasopharynx</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NASOPHARYNX_CODE="43874-7";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Nasopharynx by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOASSAY_CODE="46082-4";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Nasopharynx by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOFLUORESCENCE_CODE="44558-5";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Nose</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NOSE_CODE="44563-5";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Nose by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NOSE_BY_IMMUNOASSAY_CODE="44564-3";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Nose by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_NOSE_BY_IMMUNOFLUORESCENCE_CODE="44560-1";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Throat</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_THROAT_CODE="31858-4";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Throat by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_THROAT_BY_IMMUNOASSAY_CODE="5860-2";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Throat by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE_CODE="5861-0";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Trachea by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_TRACHEA_BY_IMMUNOFLUORESCENCE_CODE="44561-9";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31859-2";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Unspecified specimen by Immune diffusion (ID)</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNE_DIFFUSION_ID_CODE="22825-4";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="5862-8";

	/** 
	*<div class="en">Code for Influenza virus A Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="5863-6";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Bronchial specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_CODE="44566-8";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Nasopharynx</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_NASOPHARYNX_CODE="33535-6";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Nose</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_NOSE_CODE="44567-6";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Nose Qualitative by Rapid immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_NOSE_QUALITATIVE_BY_RAPID_IMMUNOASSAY_CODE="72367-6";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Throat</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_THROAT_CODE="31860-0";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Throat by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_THROAT_BY_IMMUNOASSAY_CODE="6435-2";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Throat by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE_CODE="6436-0";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="24015-0";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="6437-8";

	/** 
	*<div class="en">Code for Influenza virus A+B Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6438-6";

	/** 
	*<div class="en">Code for Influenza virus A+B+C Ag [Presence] in Throat</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_THROAT_CODE="31861-8";

	/** 
	*<div class="en">Code for Influenza virus A+B+C Ag [Presence] in Throat by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_THROAT_BY_IMMUNOASSAY_CODE="6439-4";

	/** 
	*<div class="en">Code for Influenza virus A+B+C Ag [Presence] in Throat by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE_CODE="6440-2";

	/** 
	*<div class="en">Code for Influenza virus A+B+C Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31862-6";

	/** 
	*<div class="en">Code for Influenza virus A+B+C Ag [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="6441-0";

	/** 
	*<div class="en">Code for Influenza virus A+B+C Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6442-8";

	/** 
	*<div class="en">Code for Influenza virus A+B identified in Unspecified specimen by Bioassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_BIOASSAY_CODE="49012-8";

	/** 
	*<div class="en">Code for Influenza virus A+B RNA [Identifier] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_RNA_IDENTIFIER_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49537-4";

	/** 
	*<div class="en">Code for Influenza virus A+B RNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_RNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48509-4";

	/** 
	*<div class="en">Code for Influenza virus A+B RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="62462-7";

	/** 
	*<div class="en">Code for Influenza virus A cDNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_CDNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="38381-0";

	/** 
	*<div class="en">Code for Influenza virus A H1 2009 pandemic and Influenza virus A swine origin RNA [interpretation] in Unspecified specimen Qualitative by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H1_2009_PANDEMIC_AND_INFLUENZA_VIRUS_A_SWINE_ORIGIN_RNA_INTERPRETATION_IN_UNSPECIFIED_SPECIMEN_QUALITATIVE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60494-2";

	/** 
	*<div class="en">Code for Influenza virus A H1 2009 pandemic RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H1_2009_PANDEMIC_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="55465-9";

	/** 
	*<div class="en">Code for Influenza virus A H1 Ag [Presence] in Isolate by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H1_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE_CODE="50701-2";

	/** 
	*<div class="en">Code for Influenza virus A H1+H3+B RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H1_H3_B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60538-6";

	/** 
	*<div class="en">Code for Influenza virus A H1 RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H1_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49520-0";

	/** 
	*<div class="en">Code for Influenza virus A H1 RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H1_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49521-8";

	/** 
	*<div class="en">Code for Influenza virus A H2 RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H2_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="57985-4";

	/** 
	*<div class="en">Code for Influenza virus A H3 Ag [Presence] in Isolate by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H3_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE_CODE="49522-6";

	/** 
	*<div class="en">Code for Influenza virus A H3 RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H3_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49523-4";

	/** 
	*<div class="en">Code for Influenza virus A H3 RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H3_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49524-2";

	/** 
	*<div class="en">Code for Influenza virus A H5a RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H5A_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="68986-9";

	/** 
	*<div class="en">Code for Influenza virus A H5b RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H5B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="68987-7";

	/** 
	*<div class="en">Code for Influenza virus A H5 RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H5_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49526-7";

	/** 
	*<div class="en">Code for Influenza virus A H5 RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H5_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="38272-1";

	/** 
	*<div class="en">Code for Influenza virus A H5 RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H5_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="44264-0";

	/** 
	*<div class="en">Code for Influenza virus A H6 RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H6_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="38271-3";

	/** 
	*<div class="en">Code for Influenza virus A H6 RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H6_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="44265-7";

	/** 
	*<div class="en">Code for Influenza virus A H7 RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H7_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49527-5";

	/** 
	*<div class="en">Code for Influenza virus A H7 RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H7_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="38270-5";

	/** 
	*<div class="en">Code for Influenza virus A H7 RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H7_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="44266-5";

	/** 
	*<div class="en">Code for Influenza virus A H9 RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H9_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60530-3";

	/** 
	*<div class="en">Code for Influenza virus A H9 RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_H9_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49528-3";

	/** 
	*<div class="en">Code for Influenza virus A hemagglutinin cDNA [Identifier] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_HEMAGGLUTININ_CDNA_IDENTIFIER_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="55133-3";

	/** 
	*<div class="en">Code for Influenza virus A hemagglutinin cDNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_HEMAGGLUTININ_CDNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="39102-9";

	/** 
	*<div class="en">Code for Influenza virus A hemagglutinin cDNA [Identifier] in Unspecified specimen by Sequencing</div>
	*/
	public static final String INFLUENZA_VIRUS_A_HEMAGGLUTININ_CDNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_SEQUENCING_CODE="39025-2";

	/** 
	*<div class="en">Code for Influenza virus A hemagglutinin RNA [Identifier] in Isolate by Sequencing</div>
	*/
	public static final String INFLUENZA_VIRUS_A_HEMAGGLUTININ_RNA_IDENTIFIER_IN_ISOLATE_BY_SEQUENCING_CODE="72767-7";

	/** 
	*<div class="en">Code for Influenza virus A hemagglutinin type RNA [Identifier] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_HEMAGGLUTININ_TYPE_RNA_IDENTIFIER_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="59424-2";

	/** 
	*<div class="en">Code for Influenza virus A hemagglutinin type RNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_HEMAGGLUTININ_TYPE_RNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="59423-4";

	/** 
	*<div class="en">Code for Influenza virus A identified in Unspecified specimen by Bioassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_BIOASSAY_CODE="22826-2";

	/** 
	*<div class="en">Code for Influenza virus A IgA Ab [Mass/volume] in Cerebral spinal fluid</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGA_AB_MASSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="49074-8";

	/** 
	*<div class="en">Code for Influenza virus A IgA Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGA_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="72266-0";

	/** 
	*<div class="en">Code for Influenza virus A IgM Ab [Mass/volume] in Cerebral spinal fluid</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGM_AB_MASSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="49075-5";

	/** 
	*<div class="en">Code for Influenza virus A IgM Ab [Presence] in Serum</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGM_AB_PRESENCE_IN_SERUM_CODE="43838-2";

	/** 
	*<div class="en">Code for Influenza virus A IgM Ab [Titer] in Serum</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGM_AB_TITER_IN_SERUM_CODE="9533-1";

	/** 
	*<div class="en">Code for Influenza virus A IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="31438-5";

	/** 
	*<div class="en">Code for Influenza virus A IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="47312-4";

	/** 
	*<div class="en">Code for Influenza virus A IgM Ab [Units/volume] in Serum by Immunoassay --1st specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_1ST_SPECIMEN_CODE="57326-1";

	/** 
	*<div class="en">Code for Influenza virus A IgM Ab [Units/volume] in Serum by Immunoassay --2nd specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_A_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_2ND_SPECIMEN_CODE="57327-9";

	/** 
	*<div class="en">Code for Influenza virus A matrix protein RNA [Identifier] in Isolate by Sequencing</div>
	*/
	public static final String INFLUENZA_VIRUS_A_MATRIX_PROTEIN_RNA_IDENTIFIER_IN_ISOLATE_BY_SEQUENCING_CODE="72201-7";

	/** 
	*<div class="en">Code for Influenza virus A N1 Ab [Presence] in Serum</div>
	*/
	public static final String INFLUENZA_VIRUS_A_N1_AB_PRESENCE_IN_SERUM_CODE="41142-1";

	/** 
	*<div class="en">Code for Influenza virus A N1 Ab [Presence] in Serum by Neutralization test</div>
	*/
	public static final String INFLUENZA_VIRUS_A_N1_AB_PRESENCE_IN_SERUM_BY_NEUTRALIZATION_TEST_CODE="39311-6";

	/** 
	*<div class="en">Code for Influenza virus A N1 RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_N1_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="56024-3";

	/** 
	*<div class="en">Code for Influenza virus A neuraminidase cDNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_NEURAMINIDASE_CDNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="39103-7";

	/** 
	*<div class="en">Code for Influenza virus A neuraminidase RNA [Identifier] in Isolate by Sequencing</div>
	*/
	public static final String INFLUENZA_VIRUS_A_NEURAMINIDASE_RNA_IDENTIFIER_IN_ISOLATE_BY_SEQUENCING_CODE="72200-9";

	/** 
	*<div class="en">Code for Influenza virus A neuraminidase RNA [Type] in Unspecified specimen by Sequencing</div>
	*/
	public static final String INFLUENZA_VIRUS_A_NEURAMINIDASE_RNA_TYPE_IN_UNSPECIFIED_SPECIMEN_BY_SEQUENCING_CODE="61101-2";

	/** 
	*<div class="en">Code for Influenza virus A [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String INFLUENZA_VIRUS_A_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="48310-7";

	/** 
	*<div class="en">Code for Influenza virus A RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49531-7";

	/** 
	*<div class="en">Code for Influenza virus A RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="34487-9";

	/** 
	*<div class="en">Code for Influenza virus A RNA [Units/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_RNA_UNITSVOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="44263-2";

	/** 
	*<div class="en">Code for Influenza virus A RNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_RNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53250-7";

	/** 
	*<div class="en">Code for Influenza virus A subtype [Identifier] in Unspecified specimen by Immune diffusion (ID)</div>
	*/
	public static final String INFLUENZA_VIRUS_A_SUBTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNE_DIFFUSION_ID_CODE="22828-8";

	/** 
	*<div class="en">Code for Influenza virus A subtype [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_SUBTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="22827-0";

	/** 
	*<div class="en">Code for Influenza virus A swine origin RNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_SWINE_ORIGIN_RNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="55463-4";

	/** 
	*<div class="en">Code for Influenza virus A swine origin RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_A_SWINE_ORIGIN_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="55464-2";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Bronchial specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_CODE="44576-7";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Bronchial specimen by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="44572-6";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Isolate</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_ISOLATE_CODE="54241-5";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Isolate by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE_CODE="49534-1";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Nasopharynx</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NASOPHARYNX_CODE="43895-2";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Nasopharynx by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOASSAY_CODE="46083-2";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Nasopharynx by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NASOPHARYNX_BY_IMMUNOFLUORESCENCE_CODE="44571-8";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Nose</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NOSE_CODE="44577-5";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Nose by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NOSE_BY_IMMUNOASSAY_CODE="44575-9";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Nose by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_NOSE_BY_IMMUNOFLUORESCENCE_CODE="44573-4";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Throat</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_THROAT_CODE="31863-4";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Throat by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_THROAT_BY_IMMUNOASSAY_CODE="5864-4";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Throat by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE_CODE="5865-1";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Trachea by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_TRACHEA_BY_IMMUNOFLUORESCENCE_CODE="44574-2";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31864-2";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="5866-9";

	/** 
	*<div class="en">Code for Influenza virus B Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String INFLUENZA_VIRUS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="5867-7";

	/** 
	*<div class="en">Code for Influenza virus B IgA Ab [Mass/volume] in Cerebral spinal fluid</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGA_AB_MASSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="49076-3";

	/** 
	*<div class="en">Code for Influenza virus B IgA Ab [Presence] in Serum</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGA_AB_PRESENCE_IN_SERUM_CODE="43852-3";

	/** 
	*<div class="en">Code for Influenza virus B IgA Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGA_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="72265-2";

	/** 
	*<div class="en">Code for Influenza virus B IgM Ab [Mass/volume] in Cerebral spinal fluid</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGM_AB_MASSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="49078-9";

	/** 
	*<div class="en">Code for Influenza virus B IgM Ab [Presence] in Serum</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGM_AB_PRESENCE_IN_SERUM_CODE="43840-8";

	/** 
	*<div class="en">Code for Influenza virus B IgM Ab [Titer] in Serum</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGM_AB_TITER_IN_SERUM_CODE="9536-4";

	/** 
	*<div class="en">Code for Influenza virus B IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="17016-7";

	/** 
	*<div class="en">Code for Influenza virus B IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="47315-7";

	/** 
	*<div class="en">Code for Influenza virus B IgM Ab [Units/volume] in Serum by Immunoassay --1st specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_1ST_SPECIMEN_CODE="57328-7";

	/** 
	*<div class="en">Code for Influenza virus B IgM Ab [Units/volume] in Serum by Immunoassay --2nd specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_B_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_2ND_SPECIMEN_CODE="57329-5";

	/** 
	*<div class="en">Code for Influenza virus B [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String INFLUENZA_VIRUS_B_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="38382-8";

	/** 
	*<div class="en">Code for Influenza virus B RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_B_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49535-8";

	/** 
	*<div class="en">Code for Influenza virus B RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_B_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="40982-1";

	/** 
	*<div class="en">Code for Influenza virus B RNA [#/volume] (viral load) in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String INFLUENZA_VIRUS_B_RNA_VOLUME_VIRAL_LOAD_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53251-5";

	/** 
	*<div class="en">Code for Influenza virus identified in Isolate</div>
	*/
	public static final String INFLUENZA_VIRUS_IDENTIFIED_IN_ISOLATE_CODE="54242-3";

	/** 
	*<div class="en">Code for Influenza virus identified in Sputum by Organism specific culture</div>
	*/
	public static final String INFLUENZA_VIRUS_IDENTIFIED_IN_SPUTUM_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6601-9";

	/** 
	*<div class="en">Code for Influenza virus identified in Sputum tracheal aspirate by Organism specific culture</div>
	*/
	public static final String INFLUENZA_VIRUS_IDENTIFIED_IN_SPUTUM_TRACHEAL_ASPIRATE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6602-7";

	/** 
	*<div class="en">Code for Influenza virus identified in Throat by Organism specific culture</div>
	*/
	public static final String INFLUENZA_VIRUS_IDENTIFIED_IN_THROAT_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6603-5";

	/** 
	*<div class="en">Code for Influenza virus identified in Unspecified specimen</div>
	*/
	public static final String INFLUENZA_VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_CODE="54244-9";

	/** 
	*<div class="en">Code for Influenza virus identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String INFLUENZA_VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6604-3";

	/** 
	*<div class="en">Code for Influenza virus identified in Unspecified specimen by Shell vial culture</div>
	*/
	public static final String INFLUENZA_VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_SHELL_VIAL_CULTURE_CODE="49538-2";

	/** 
	*<div class="en">Code for Influenza virus RNA [Identifier] in Unspecified specimen by DNA probe</div>
	*/
	public static final String INFLUENZA_VIRUS_RNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="54243-1";

	/** 
	*<div class="en">Code for Isoniazid 0.1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ISONIAZID_0_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25217-1";

	/** 
	*<div class="en">Code for Isoniazid 0.2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ISONIAZID_0_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25218-9";

	/** 
	*<div class="en">Code for Isoniazid 0.4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ISONIAZID_0_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="29315-9";

	/** 
	*<div class="en">Code for Isoniazid 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ISONIAZID_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="55685-2";

	/** 
	*<div class="en">Code for Isoniazid 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ISONIAZID_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25219-7";

	/** 
	*<div class="en">Code for Isoniazid 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ISONIAZID_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="45215-1";

	/** 
	*<div class="en">Code for Isoniazid 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ISONIAZID_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="42651-0";

	/** 
	*<div class="en">Code for Isoniazid [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String ISONIAZID_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20383-6";

	/** 
	*<div class="en">Code for Kanamycin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String KANAMYCIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="49080-5";

	/** 
	*<div class="en">Code for Kanamycin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String KANAMYCIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25214-8";

	/** 
	*<div class="en">Code for Kanamycin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String KANAMYCIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25182-7";

	/** 
	*<div class="en">Code for Kanamycin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String KANAMYCIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25213-0";

	/** 
	*<div class="en">Code for Kanamycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String KANAMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23609-1";

	/** 
	*<div class="en">Code for Lassa virus Ag [Presence] in Serum</div>
	*/
	public static final String LASSA_VIRUS_AG_PRESENCE_IN_SERUM_CODE="31867-5";

	/** 
	*<div class="en">Code for Lassa virus Ag [Presence] in Serum by Immunoassay</div>
	*/
	public static final String LASSA_VIRUS_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="7946-7";

	/** 
	*<div class="en">Code for Lassa virus IgG Ab [Presence] in Serum</div>
	*/
	public static final String LASSA_VIRUS_IGG_AB_PRESENCE_IN_SERUM_CODE="22377-6";

	/** 
	*<div class="en">Code for Lassa virus IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String LASSA_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="7942-6";

	/** 
	*<div class="en">Code for Lassa virus IgG Ab [Titer] in Serum</div>
	*/
	public static final String LASSA_VIRUS_IGG_AB_TITER_IN_SERUM_CODE="22378-4";

	/** 
	*<div class="en">Code for Lassa virus IgG Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String LASSA_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="71710-8";

	/** 
	*<div class="en">Code for Lassa virus IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LASSA_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7943-4";

	/** 
	*<div class="en">Code for Lassa virus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String LASSA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="31452-6";

	/** 
	*<div class="en">Code for Lassa virus IgM Ab [Presence] in Serum</div>
	*/
	public static final String LASSA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="22379-2";

	/** 
	*<div class="en">Code for Lassa virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String LASSA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="7944-2";

	/** 
	*<div class="en">Code for Lassa virus IgM Ab [Titer] in Serum</div>
	*/
	public static final String LASSA_VIRUS_IGM_AB_TITER_IN_SERUM_CODE="22380-0";

	/** 
	*<div class="en">Code for Lassa virus IgM Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String LASSA_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="71709-0";

	/** 
	*<div class="en">Code for Lassa virus IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LASSA_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7945-9";

	/** 
	*<div class="en">Code for Lassa virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String LASSA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="31453-4";

	/** 
	*<div class="en">Code for Legionella bozemanii</div>
	*/
	public static final String LEGIONELLA_BOZEMANII_CODE="37835001";

	/** 
	*<div class="en">Code for Legionella longbeachae</div>
	*/
	public static final String LEGIONELLA_LONGBEACHAE_CODE="89605004";

	/** 
	*<div class="en">Code for Legionella longbeachae 1+2 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_LONGBEACHAE_1_2_AB_TITER_IN_SERUM_CODE="32694-2";

	/** 
	*<div class="en">Code for Legionella longbeachae 1 IgM Ab [Presence] in Serum</div>
	*/
	public static final String LEGIONELLA_LONGBEACHAE_1_IGM_AB_PRESENCE_IN_SERUM_CODE="17054-8";

	/** 
	*<div class="en">Code for Legionella longbeachae 2 IgM Ab [Presence] in Serum</div>
	*/
	public static final String LEGIONELLA_LONGBEACHAE_2_IGM_AB_PRESENCE_IN_SERUM_CODE="17056-3";

	/** 
	*<div class="en">Code for Legionella longbeachae, serogroup 1</div>
	*/
	public static final String LEGIONELLA_LONGBEACHAE_SEROGROUP_1_CODE="115515003";

	/** 
	*<div class="en">Code for Legionella longbeachae, serogroup 2</div>
	*/
	public static final String LEGIONELLA_LONGBEACHAE_SEROGROUP_2_CODE="115516002";

	/** 
	*<div class="en">Code for Legionella micdadei DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String LEGIONELLA_MICDADEI_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="67563-7";

	/** 
	*<div class="en">Code for Legionella non-pneumophila Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_NON_PNEUMOPHILA_AB_TITER_IN_SERUM_CODE="46194-7";

	/** 
	*<div class="en">Code for Legionella non-pneumophila Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_NON_PNEUMOPHILA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="43193-2";

	/** 
	*<div class="en">Code for Legionella pneumophila</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_CODE="80897008";

	/** 
	*<div class="en">Code for Legionella pneumophila 10 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_10_IGG_AB_TITER_IN_SERUM_CODE="47459-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 10 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_10_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47082-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 10 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_10_IGM_AB_TITER_IN_SERUM_CODE="47460-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 10 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_10_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47054-2";

	/** 
	*<div class="en">Code for Legionella pneumophila 11 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_11_IGG_AB_TITER_IN_SERUM_CODE="47461-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 11 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_11_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47055-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 11 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_11_IGM_AB_TITER_IN_SERUM_CODE="47462-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 11 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_11_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47056-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 12 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_12_IGG_AB_TITER_IN_SERUM_CODE="47463-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 12 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_12_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47057-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 12 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_12_IGM_AB_TITER_IN_SERUM_CODE="47464-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 12 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_12_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47058-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 13 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_13_IGG_AB_TITER_IN_SERUM_CODE="47465-0";

	/** 
	*<div class="en">Code for Legionella pneumophila 13 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_13_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47059-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 13 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_13_IGM_AB_TITER_IN_SERUM_CODE="47466-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 13 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_13_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47060-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 14 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_14_IGG_AB_TITER_IN_SERUM_CODE="47467-6";

	/** 
	*<div class="en">Code for Legionella pneumophila 14 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_14_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47061-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 14 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_14_IGM_AB_TITER_IN_SERUM_CODE="47468-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 14 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_14_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47062-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 1+2+3+4+5+6 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_2_3_4_5_6_AB_TITER_IN_SERUM_CODE="32696-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 1+2+3+4+5+6 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_2_3_4_5_6_IGG_AB_TITER_IN_SERUM_CODE="53770-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 1+2+3+4+5+6 IgM Ab [Presence] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_2_3_4_5_6_IGM_AB_PRESENCE_IN_SERUM_CODE="49914-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 1+2+3+4+5+6 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_2_3_4_5_6_IGM_AB_TITER_IN_SERUM_CODE="53784-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 1+3+4+5+6+8 IgM Ab [Presence] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_3_4_5_6_8_IGM_AB_PRESENCE_IN_SERUM_CODE="43853-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_AB_TITER_IN_SERUM_CODE="17060-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7948-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_AB_UNITSVOLUME_IN_SERUM_CODE="31454-2";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 Ag [Presence] in Urine</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_AG_PRESENCE_IN_URINE_CODE="31868-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 Ag [Presence] in Urine by Immunoassay</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_AG_PRESENCE_IN_URINE_BY_IMMUNOASSAY_CODE="41499-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 Ag [Presence] in Urine by Radioimmunoassay (RIA)</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_AG_PRESENCE_IN_URINE_BY_RADIOIMMUNOASSAY_RIA_CODE="9543-0";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGG_AB_TITER_IN_SERUM_CODE="22381-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9541-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="31455-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="58799-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgM Ab [Presence] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGM_AB_PRESENCE_IN_SERUM_CODE="35395-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgM Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="43002-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgM Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="31075-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGM_AB_TITER_IN_SERUM_CODE="22382-6";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9542-2";

	/** 
	*<div class="en">Code for Legionella pneumophila 1 IgM Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_1_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="31456-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 2+3+4+5+6+8 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_3_4_5_6_8_AB_TITER_IN_SERUM_CODE="46195-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 2+3+4+5+6+8 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_3_4_5_6_8_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="43192-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_AB_TITER_IN_SERUM_CODE="17062-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7949-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_AB_UNITSVOLUME_IN_SERUM_CODE="31457-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_IGG_AB_TITER_IN_SERUM_CODE="22383-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9544-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="31458-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_IGM_AB_TITER_IN_SERUM_CODE="22384-2";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9545-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="17063-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 2 IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_2_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="58798-0";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_AB_TITER_IN_SERUM_CODE="17064-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7950-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_AB_UNITSVOLUME_IN_SERUM_CODE="31459-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_IGG_AB_TITER_IN_SERUM_CODE="22385-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9546-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="31460-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_IGM_AB_TITER_IN_SERUM_CODE="22386-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9547-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 3 IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_3_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="17065-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_AB_TITER_IN_SERUM_CODE="17066-2";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7951-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_AB_UNITSVOLUME_IN_SERUM_CODE="31461-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_IGG_AB_TITER_IN_SERUM_CODE="22387-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9548-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="31462-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_IGM_AB_TITER_IN_SERUM_CODE="22388-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9549-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 4 IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_4_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="17067-0";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_AB_TITER_IN_SERUM_CODE="17068-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7952-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_AB_UNITSVOLUME_IN_SERUM_CODE="31463-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_IGG_AB_TITER_IN_SERUM_CODE="22389-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9550-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="31464-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_IGM_AB_TITER_IN_SERUM_CODE="22390-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9551-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 5 IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_5_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="17069-6";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_AB_TITER_IN_SERUM_CODE="17070-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7953-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_AB_UNITSVOLUME_IN_SERUM_CODE="31465-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_IGG_AB_TITER_IN_SERUM_CODE="22391-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9552-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="31466-6";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_IGM_AB_TITER_IN_SERUM_CODE="22392-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="9553-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 6 IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_6_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="31467-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 7+8+9+10+11+12+13+14 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_7_8_9_10_11_12_13_14_AB_TITER_IN_SERUM_CODE="54205-0";

	/** 
	*<div class="en">Code for Legionella pneumophila 7 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_7_AB_TITER_IN_SERUM_CODE="22393-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 7 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_7_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7954-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 7 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_7_AB_UNITSVOLUME_IN_SERUM_CODE="31468-2";

	/** 
	*<div class="en">Code for Legionella pneumophila 7 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_7_IGG_AB_TITER_IN_SERUM_CODE="47469-2";

	/** 
	*<div class="en">Code for Legionella pneumophila 7 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_7_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47076-5";

	/** 
	*<div class="en">Code for Legionella pneumophila 7 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_7_IGM_AB_TITER_IN_SERUM_CODE="47470-0";

	/** 
	*<div class="en">Code for Legionella pneumophila 7 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_7_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47077-3";

	/** 
	*<div class="en">Code for Legionella pneumophila 8 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_8_AB_TITER_IN_SERUM_CODE="22394-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 8 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_8_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7955-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 8 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_8_AB_UNITSVOLUME_IN_SERUM_CODE="31469-0";

	/** 
	*<div class="en">Code for Legionella pneumophila 8 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_8_IGG_AB_TITER_IN_SERUM_CODE="47471-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 8 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_8_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47078-1";

	/** 
	*<div class="en">Code for Legionella pneumophila 8 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_8_IGM_AB_TITER_IN_SERUM_CODE="47472-6";

	/** 
	*<div class="en">Code for Legionella pneumophila 8 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_8_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47079-9";

	/** 
	*<div class="en">Code for Legionella pneumophila 9 Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_9_AB_TITER_IN_SERUM_CODE="22395-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 9 Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_9_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="7956-6";

	/** 
	*<div class="en">Code for Legionella pneumophila 9 Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_9_AB_UNITSVOLUME_IN_SERUM_CODE="31470-8";

	/** 
	*<div class="en">Code for Legionella pneumophila 9 IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_9_IGG_AB_TITER_IN_SERUM_CODE="47473-4";

	/** 
	*<div class="en">Code for Legionella pneumophila 9 IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_9_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47080-7";

	/** 
	*<div class="en">Code for Legionella pneumophila 9 IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_9_IGM_AB_TITER_IN_SERUM_CODE="47474-2";

	/** 
	*<div class="en">Code for Legionella pneumophila 9 IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_9_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="47081-5";

	/** 
	*<div class="en">Code for Legionella pneumophila Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_CODE="22396-6";

	/** 
	*<div class="en">Code for Legionella pneumophila Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="24277-6";

	/** 
	*<div class="en">Code for Legionella pneumophila Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="24278-4";

	/** 
	*<div class="en">Code for Legionella pneumophila Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="5237-3";

	/** 
	*<div class="en">Code for Legionella pneumophila Ab [Titer] in Serum by Immunofluorescence --1st specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_1ST_SPECIMEN_CODE="24203-2";

	/** 
	*<div class="en">Code for Legionella pneumophila Ab [Titer] in Serum by Immunofluorescence --2nd specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_2ND_SPECIMEN_CODE="24204-0";

	/** 
	*<div class="en">Code for Legionella pneumophila Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AB_UNITSVOLUME_IN_SERUM_CODE="31471-6";

	/** 
	*<div class="en">Code for Legionella pneumophila Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="30046-7";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Sputum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_SPUTUM_CODE="31869-1";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Sputum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_SPUTUM_BY_IMMUNOFLUORESCENCE_CODE="6445-1";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Sputum by Latex agglutination</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_SPUTUM_BY_LATEX_AGGLUTINATION_CODE="6446-9";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="17057-1";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="588-4";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="6449-3";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Urine</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_CODE="31870-9";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Urine by Immunoassay</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_BY_IMMUNOASSAY_CODE="6447-7";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Urine by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_BY_IMMUNOFLUORESCENCE_CODE="17059-7";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Urine by Latex agglutination</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_BY_LATEX_AGGLUTINATION_CODE="17058-9";

	/** 
	*<div class="en">Code for Legionella pneumophila Ag [Presence] in Urine by Radioimmunoassay (RIA)</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_AG_PRESENCE_IN_URINE_BY_RADIOIMMUNOASSAY_RIA_CODE="6448-5";

	/** 
	*<div class="en">Code for Legionella pneumophila atypical Ab [Presence] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_ATYPICAL_AB_PRESENCE_IN_SERUM_CODE="13254-8";

	/** 
	*<div class="en">Code for Legionella pneumophila atypical Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_ATYPICAL_AB_TITER_IN_SERUM_CODE="32695-9";

	/** 
	*<div class="en">Code for Legionella pneumophila atypical Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_ATYPICAL_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="27966-1";

	/** 
	*<div class="en">Code for Legionella pneumophila atypical Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_ATYPICAL_AB_UNITSVOLUME_IN_SERUM_CODE="31473-2";

	/** 
	*<div class="en">Code for Legionella pneumophila atypical IgM Ab [Presence] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_ATYPICAL_IGM_AB_PRESENCE_IN_SERUM_CODE="18237-8";

	/** 
	*<div class="en">Code for Legionella pneumophila DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21363-7";

	/** 
	*<div class="en">Code for Legionella pneumophila IgG Ab [Presence] in Serum by Immunofluorescence --1st specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_1ST_SPECIMEN_CODE="57675-1";

	/** 
	*<div class="en">Code for Legionella pneumophila IgG Ab [Presence] in Serum by Immunofluorescence --2nd specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_2ND_SPECIMEN_CODE="57676-9";

	/** 
	*<div class="en">Code for Legionella pneumophila IgG Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGG_AB_TITER_IN_SERUM_CODE="22397-4";

	/** 
	*<div class="en">Code for Legionella pneumophila IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="21362-9";

	/** 
	*<div class="en">Code for Legionella pneumophila IgG Ab [Titer] in Serum by Immunofluorescence --1st specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_1ST_SPECIMEN_CODE="57008-5";

	/** 
	*<div class="en">Code for Legionella pneumophila IgG Ab [Titer] in Serum by Immunofluorescence --2nd specimen</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_2ND_SPECIMEN_CODE="56950-9";

	/** 
	*<div class="en">Code for Legionella pneumophila IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="30085-5";

	/** 
	*<div class="en">Code for Legionella pneumophila IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="29955-2";

	/** 
	*<div class="en">Code for Legionella pneumophila IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGM_AB_TITER_IN_SERUM_CODE="22398-2";

	/** 
	*<div class="en">Code for Legionella pneumophila IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="16133-1";

	/** 
	*<div class="en">Code for Legionella pneumophila IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="31472-4";

	/** 
	*<div class="en">Code for Legionella pneumophila IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51814-2";

	/** 
	*<div class="en">Code for Legionella pneumophila serogroup 1</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_SEROGROUP_1_CODE="103463005";

	/** 
	*<div class="en">Code for Legionella pneumophila serogroup 4</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_SEROGROUP_4_CODE="103466002";

	/** 
	*<div class="en">Code for Legionella pneumophila serogroup 6</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_SEROGROUP_6_CODE="103468001";

	/** 
	*<div class="en">Code for Legionella pneumophila ss. pneumophila</div>
	*/
	public static final String LEGIONELLA_PNEUMOPHILA_SS_PNEUMOPHILA_CODE="103458006";

	/** 
	*<div class="en">Code for Legionella sp Ab [Presence] in Serum --1st specimen</div>
	*/
	public static final String LEGIONELLA_SP_AB_PRESENCE_IN_SERUM_1ST_SPECIMEN_CODE="30143-2";

	/** 
	*<div class="en">Code for Legionella sp Ab [Presence] in Serum --2nd specimen</div>
	*/
	public static final String LEGIONELLA_SP_AB_PRESENCE_IN_SERUM_2ND_SPECIMEN_CODE="30144-0";

	/** 
	*<div class="en">Code for Legionella sp Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String LEGIONELLA_SP_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="43001-7";

	/** 
	*<div class="en">Code for Legionella sp Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_SP_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="42516-5";

	/** 
	*<div class="en">Code for Legionella sp Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_SP_AB_TITER_IN_SERUM_CODE="22399-0";

	/** 
	*<div class="en">Code for Legionella sp Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String LEGIONELLA_SP_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="51920-7";

	/** 
	*<div class="en">Code for Legionella sp Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_SP_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="6450-1";

	/** 
	*<div class="en">Code for Legionella sp Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_SP_AB_UNITSVOLUME_IN_SERUM_CODE="7957-4";

	/** 
	*<div class="en">Code for Legionella sp Ag [Presence] in Bronchial specimen by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_SP_AG_PRESENCE_IN_BRONCHIAL_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="38460-2";

	/** 
	*<div class="en">Code for Legionella sp Ag [Presence] in Pleural fluid by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_SP_AG_PRESENCE_IN_PLEURAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="38461-0";

	/** 
	*<div class="en">Code for Legionella sp Ag [Presence] in Sputum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_SP_AG_PRESENCE_IN_SPUTUM_BY_IMMUNOFLUORESCENCE_CODE="38462-8";

	/** 
	*<div class="en">Code for Legionella sp Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String LEGIONELLA_SP_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="26621-3";

	/** 
	*<div class="en">Code for Legionella sp Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_SP_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="39541-8";

	/** 
	*<div class="en">Code for Legionella sp Ag [Presence] in Urine</div>
	*/
	public static final String LEGIONELLA_SP_AG_PRESENCE_IN_URINE_CODE="32781-7";

	/** 
	*<div class="en">Code for Legionella sp Ag [Presence] in Urine by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_SP_AG_PRESENCE_IN_URINE_BY_IMMUNOFLUORESCENCE_CODE="38463-6";

	/** 
	*<div class="en">Code for Legionella sp DNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String LEGIONELLA_SP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49616-6";

	/** 
	*<div class="en">Code for Legionella sp identified in Bronchial specimen by Organism specific culture</div>
	*/
	public static final String LEGIONELLA_SP_IDENTIFIED_IN_BRONCHIAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="589-2";

	/** 
	*<div class="en">Code for Legionella sp identified in Pleural fluid by Organism specific culture</div>
	*/
	public static final String LEGIONELLA_SP_IDENTIFIED_IN_PLEURAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE_CODE="38393-5";

	/** 
	*<div class="en">Code for Legionella sp identified in Sputum by Organism specific culture</div>
	*/
	public static final String LEGIONELLA_SP_IDENTIFIED_IN_SPUTUM_BY_ORGANISM_SPECIFIC_CULTURE_CODE="590-0";

	/** 
	*<div class="en">Code for Legionella sp identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String LEGIONELLA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="593-4";

	/** 
	*<div class="en">Code for Legionella sp identified in Urine by Organism specific culture</div>
	*/
	public static final String LEGIONELLA_SP_IDENTIFIED_IN_URINE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="38394-3";

	/** 
	*<div class="en">Code for Legionella sp [Identifier] in Isolate by Agglutination</div>
	*/
	public static final String LEGIONELLA_SP_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION_CODE="71377-6";

	/** 
	*<div class="en">Code for Legionella sp IgM Ab [Titer] in Serum</div>
	*/
	public static final String LEGIONELLA_SP_IGM_AB_TITER_IN_SERUM_CODE="39559-0";

	/** 
	*<div class="en">Code for Legionella sp IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String LEGIONELLA_SP_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="28612-0";

	/** 
	*<div class="en">Code for Legionella sp IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String LEGIONELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="31474-0";

	/** 
	*<div class="en">Code for Legionella sp rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String LEGIONELLA_SP_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="5020-3";

	/** 
	*<div class="en">Code for Levofloxacin 1.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String LEVOFLOXACIN_1_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="48173-9";

	/** 
	*<div class="en">Code for Levofloxacin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String LEVOFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="53716-7";

	/** 
	*<div class="en">Code for Linezolid [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String LINEZOLID_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="41500-0";

	/** 
	*<div class="en">Code for Listeria</div>
	*/
	public static final String LISTERIA_CODE="23566007";

	/** 
	*<div class="en">Code for Listeria monocytogenes</div>
	*/
	public static final String LISTERIA_MONOCYTOGENES_CODE="36094007";

	/** 
	*<div class="en">Code for Listeria monocytogenes DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String LISTERIA_MONOCYTOGENES_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="61369-5";

	/** 
	*<div class="en">Code for Listeria monocytogenes rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String LISTERIA_MONOCYTOGENES_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="5021-1";

	/** 
	*<div class="en">Code for Listeria sp identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String LISTERIA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6609-2";

	/** 
	*<div class="en">Code for Marburg virus Ag [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String MARBURG_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="71708-2";

	/** 
	*<div class="en">Code for Marburg virus IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String MARBURG_VIRUS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="71769-4";

	/** 
	*<div class="en">Code for Marburg virus IgG Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String MARBURG_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="71707-4";

	/** 
	*<div class="en">Code for Marburg virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String MARBURG_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="71771-0";

	/** 
	*<div class="en">Code for Marburg virus IgM Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String MARBURG_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="71706-6";

	/** 
	*<div class="en">Code for Marburg virus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String MARBURG_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41638-8";

	/** 
	*<div class="en">Code for Measles virus Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String MEASLES_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="22498-0";

	/** 
	*<div class="en">Code for Measles virus Ab [Titer] in Cerebral spinal fluid by Complement fixation</div>
	*/
	public static final String MEASLES_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_COMPLEMENT_FIXATION_CODE="9565-3";

	/** 
	*<div class="en">Code for Measles virus Ab [Titer] in Serum</div>
	*/
	public static final String MEASLES_VIRUS_AB_TITER_IN_SERUM_CODE="22499-8";

	/** 
	*<div class="en">Code for Measles virus Ab [Titer] in Serum by Complement fixation</div>
	*/
	public static final String MEASLES_VIRUS_AB_TITER_IN_SERUM_BY_COMPLEMENT_FIXATION_CODE="5243-1";

	/** 
	*<div class="en">Code for Measles virus Ab [Titer] in Serum by Hemagglutination inhibition</div>
	*/
	public static final String MEASLES_VIRUS_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION_CODE="41501-8";

	/** 
	*<div class="en">Code for Measles virus Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String MEASLES_VIRUS_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="17553-9";

	/** 
	*<div class="en">Code for Measles virus Ab [Units/volume] in Serum</div>
	*/
	public static final String MEASLES_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="7961-6";

	/** 
	*<div class="en">Code for Measles virus Ab [Units/volume] in Serum --1st specimen</div>
	*/
	public static final String MEASLES_VIRUS_AB_UNITSVOLUME_IN_SERUM_1ST_SPECIMEN_CODE="17555-4";

	/** 
	*<div class="en">Code for Measles virus Ab [Units/volume] in Serum --2nd specimen</div>
	*/
	public static final String MEASLES_VIRUS_AB_UNITSVOLUME_IN_SERUM_2ND_SPECIMEN_CODE="17556-2";

	/** 
	*<div class="en">Code for Measles virus Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String MEASLES_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5242-3";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31875-8";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="14534-2";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Cervix</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_CERVIX_CODE="31876-6";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Cervix by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_CERVIX_BY_IMMUNOFLUORESCENCE_CODE="14540-9";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Eye</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_EYE_CODE="31877-4";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Eye by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_EYE_BY_IMMUNOFLUORESCENCE_CODE="14537-5";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Isolate by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE_CODE="67806-0";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Nose</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_NOSE_CODE="31879-0";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Nose by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_NOSE_BY_IMMUNOFLUORESCENCE_CODE="14538-3";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Penis</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_PENIS_CODE="31880-8";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Penis by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_PENIS_BY_IMMUNOFLUORESCENCE_CODE="14543-3";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Serum or Plasma</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_SERUM_OR_PLASMA_CODE="31881-6";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Serum or Plasma by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOFLUORESCENCE_CODE="13328-0";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Skin</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_SKIN_CODE="31882-4";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Skin by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_SKIN_BY_IMMUNOFLUORESCENCE_CODE="14536-7";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Sputum</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_SPUTUM_CODE="31883-2";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Sputum by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_SPUTUM_BY_IMMUNOFLUORESCENCE_CODE="14539-1";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Throat</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_THROAT_CODE="31884-0";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Throat by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE_CODE="14535-9";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31887-3";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="12232-5";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Urethra</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_URETHRA_CODE="31886-5";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Urethra by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_URETHRA_BY_IMMUNOFLUORESCENCE_CODE="14544-1";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Urine sediment</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_URINE_SEDIMENT_CODE="31885-7";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Urine sediment by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_URINE_SEDIMENT_BY_IMMUNOFLUORESCENCE_CODE="14542-5";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Vaginal fluid</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_VAGINAL_FLUID_CODE="31878-2";

	/** 
	*<div class="en">Code for Measles virus Ag [Presence] in Vaginal fluid by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_AG_PRESENCE_IN_VAGINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="14541-7";

	/** 
	*<div class="en">Code for Measles virus genotype [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String MEASLES_VIRUS_GENOTYPE_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60422-3";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Ratio] in Serum --1st specimen/2nd specimen</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_RATIO_IN_SERUM_1ST_SPECIMEN2ND_SPECIMEN_CODE="25299-9";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="22501-1";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="21500-4";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Titer] in Serum</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_TITER_IN_SERUM_CODE="22502-9";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="21501-2";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Body fluid</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_BODY_FLUID_CODE="29242-5";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="22500-3";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="9566-1";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="7962-4";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Serum --1st specimen</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_1ST_SPECIMEN_CODE="22503-7";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Serum --2nd specimen</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_2ND_SPECIMEN_CODE="22504-5";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5244-9";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Serum by Immunoassay --1st specimen</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_1ST_SPECIMEN_CODE="14304-0";

	/** 
	*<div class="en">Code for Measles virus IgG Ab [Units/volume] in Serum by Immunoassay --2nd specimen</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_2ND_SPECIMEN_CODE="14305-7";

	/** 
	*<div class="en">Code for Measles virus IgG and IgM [interpretation] in Cerebral spinal fluid</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AND_IGM_INTERPRETATION_IN_CEREBRAL_SPINAL_FLUID_CODE="44011-5";

	/** 
	*<div class="en">Code for Measles virus IgG and IgM [interpretation] in Serum</div>
	*/
	public static final String MEASLES_VIRUS_IGG_AND_IGM_INTERPRETATION_IN_SERUM_CODE="44012-3";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Presence] in Body fluid by Immunoassay</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOASSAY_CODE="53537-7";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Presence] in Serum</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="21503-8";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="35276-5";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="22505-2";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Titer] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="21502-0";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Titer] in Serum</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_TITER_IN_SERUM_CODE="22506-0";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="5245-6";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="13283-7";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Units/volume] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="40649-6";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="7963-2";

	/** 
	*<div class="en">Code for Measles virus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String MEASLES_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="25421-9";

	/** 
	*<div class="en">Code for Measles virus RNA [Presence] in Nose by Probe and target amplification method</div>
	*/
	public static final String MEASLES_VIRUS_RNA_PRESENCE_IN_NOSE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="7964-0";

	/** 
	*<div class="en">Code for Measles virus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String MEASLES_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48508-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Anal by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_ANAL_BY_GRAM_STAIN_CODE="72408-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Aspirate by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_ASPIRATE_BY_GRAM_STAIN_CODE="14358-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Aspirate by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_ASPIRATE_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="55222-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Blood by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_ACID_FAST_STAIN_CODE="32699-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Blood by Brilliant cresyl blue</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_BRILLIANT_CRESYL_BLUE_CODE="29776-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Blood by Malaria smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_MALARIA_SMEAR_CODE="32700-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Blood by Malaria thick smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_MALARIA_THICK_SMEAR_CODE="637-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Blood by Malaria thin smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_BY_MALARIA_THIN_SMEAR_CODE="33271-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Blood or Marrow by Periodic acid-Schiff stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BLOOD_OR_MARROW_BY_PERIODIC_ACID_SCHIFF_STAIN_CODE="9786-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Body fluid by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_ACID_FAST_STAIN_CODE="32189-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Body fluid by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="58944-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Body fluid by Crystal violet stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_CRYSTAL_VIOLET_STAIN_CODE="48722-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Body fluid by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_GRAM_STAIN_CODE="27112-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Body fluid by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_KOH_PREPARATION_CODE="68383-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Body fluid by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53912-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Body fluid by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BODY_FLUID_BY_WET_PREPARATION_CODE="23901-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Bone marrow by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BONE_MARROW_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53918-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Bone marrow by Wright Giemsa stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BONE_MARROW_BY_WRIGHT_GIEMSA_STAIN_CODE="10355-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Bronchial specimen by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BRONCHIAL_SPECIMEN_BY_ACID_FAST_STAIN_CODE="24002-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Bronchial specimen by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BRONCHIAL_SPECIMEN_BY_GRAM_STAIN_CODE="21021-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Bronchial specimen by Iron hematoxylin stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BRONCHIAL_SPECIMEN_BY_IRON_HEMATOXYLIN_STAIN_CODE="32811-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Bronchial specimen by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_BRONCHIAL_SPECIMEN_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53522-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cerebral spinal fluid</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_CODE="32190-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cerebral spinal fluid by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_ACID_FAST_STAIN_CODE="32188-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cerebral spinal fluid by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="58943-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cerebral spinal fluid by Acridine orange stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_ACRIDINE_ORANGE_STAIN_CODE="59474-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cerebral spinal fluid by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_GRAM_STAIN_CODE="14357-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cerebral spinal fluid by India ink prep</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_INDIA_INK_PREP_CODE="638-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cerebral spinal fluid by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CEREBRAL_SPINAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53906-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cervix by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CERVIX_BY_GRAM_STAIN_CODE="6464-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cervix by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CERVIX_BY_KOH_PREPARATION_CODE="14355-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cervix by Other stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CERVIX_BY_OTHER_STAIN_CODE="18326-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Cervix by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_CERVIX_BY_WET_PREPARATION_CODE="14318-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Dialysis fluid by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_DIALYSIS_FLUID_BY_GRAM_STAIN_CODE="21022-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Duodenal fluid by Other stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_DUODENAL_FLUID_BY_OTHER_STAIN_CODE="18327-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Duodenal fluid by Trichrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_DUODENAL_FLUID_BY_TRICHROME_STAIN_CODE="6465-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Duodenal fluid by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_DUODENAL_FLUID_BY_WET_PREPARATION_CODE="6466-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Ear by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_EAR_BY_GRAM_STAIN_CODE="14365-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Endometrium by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_ENDOMETRIUM_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53914-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Eye by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_EYE_BY_GRAM_STAIN_CODE="14364-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Gastric fluid by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_ACID_FAST_STAIN_CODE="11476-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Gastric fluid by Acid fast stain.Kinyoun</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_ACID_FAST_STAIN_KINYOUN_CODE="640-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Gastric fluid by Acid fast stain.Kinyoun modified</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED_CODE="641-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Gastric fluid by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="642-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Gastric fluid by Dark field examination</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_DARK_FIELD_EXAMINATION_CODE="20885-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Gastric fluid by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GASTRIC_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53916-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Genital fluid by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GENITAL_FLUID_BY_GRAM_STAIN_CODE="6467-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Genital mucus by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GENITAL_MUCUS_BY_GRAM_STAIN_CODE="10856-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Genital specimen by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GENITAL_SPECIMEN_BY_GRAM_STAIN_CODE="48712-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Genital specimen by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_GENITAL_SPECIMEN_BY_WET_PREPARATION_CODE="14317-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Hair by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_HAIR_BY_KOH_PREPARATION_CODE="10688-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Nail by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_NAIL_BY_KOH_PREPARATION_CODE="10689-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Nose by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_NOSE_BY_GRAM_STAIN_CODE="32026-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Penis by Tzanck smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PENIS_BY_TZANCK_SMEAR_CODE="32186-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Pericardial fluid by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PERICARDIAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53915-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Peritoneal fluid by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PERITONEAL_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="58945-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Peritoneal fluid by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PERITONEAL_FLUID_BY_GRAM_STAIN_CODE="14359-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Peritoneal fluid by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PERITONEAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53910-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Pleural fluid by Acid fast stain.Kinyoun modified</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PLEURAL_FLUID_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED_CODE="14353-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Pleural fluid by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PLEURAL_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="58942-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Pleural fluid by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PLEURAL_FLUID_BY_GRAM_STAIN_CODE="14360-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Pleural fluid by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PLEURAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53907-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Pus by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_PUS_BY_GRAM_STAIN_CODE="643-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Skin by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SKIN_BY_KOH_PREPARATION_CODE="644-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Skin by Tzanck smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SKIN_BY_TZANCK_SMEAR_CODE="32187-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Sputum by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_ACID_FAST_STAIN_CODE="11477-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Sputum by Acid fast stain.Kinyoun</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_ACID_FAST_STAIN_KINYOUN_CODE="645-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Sputum by Acid fast stain.Kinyoun modified</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED_CODE="646-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Sputum by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="647-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Sputum by Calcofluor white</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_CALCOFLUOR_WHITE_CODE="6468-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Sputum by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_GRAM_STAIN_CODE="648-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Sputum by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_KOH_PREPARATION_CODE="17281-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Sputum by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SPUTUM_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53904-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Stool by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_ACID_FAST_STAIN_CODE="11478-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Stool by Dark field examination</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_DARK_FIELD_EXAMINATION_CODE="20884-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Stool by Electron microscopy</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_ELECTRON_MICROSCOPY_CODE="8250-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Stool by Electron microscopy negative stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_ELECTRON_MICROSCOPY_NEGATIVE_STAIN_CODE="20882-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Stool by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_GRAM_STAIN_CODE="649-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Stool by Trichrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_TRICHROME_STAIN_CODE="6469-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Stool by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_STOOL_BY_WET_PREPARATION_CODE="6470-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Synovial fluid by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SYNOVIAL_FLUID_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="63433-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Synovial fluid by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SYNOVIAL_FLUID_BY_GRAM_STAIN_CODE="14363-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Synovial fluid by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_SYNOVIAL_FLUID_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53913-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Throat by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_THROAT_BY_GRAM_STAIN_CODE="14362-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACID_FAST_STAIN_CODE="11479-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Acid fast stain.Kinyoun</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACID_FAST_STAIN_KINYOUN_CODE="6655-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Acid fast stain.Kinyoun modified</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED_CODE="6656-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="6657-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Acridine orange stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ACRIDINE_ORANGE_STAIN_CODE="6658-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Biopsy culture</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_BIOPSY_CULTURE_CODE="19129-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Calcofluor white</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_CALCOFLUOR_WHITE_CODE="6472-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Carbol-fuchsin stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_CARBOL_FUCHSIN_STAIN_CODE="6659-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Dark field examination</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_DARK_FIELD_EXAMINATION_CODE="6607-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Dry mount</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_DRY_MOUNT_CODE="6661-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Electron microscopy thin sectiion</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_ELECTRON_MICROSCOPY_THIN_SECTIION_CODE="20881-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Giemsa stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_GIEMSA_STAIN_CODE="6662-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Gimenez stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_GIMENEZ_STAIN_CODE="6663-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_GRAM_STAIN_CODE="6664-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Hematoxylin and eosin stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_HEMATOXYLIN_AND_EOSIN_STAIN_CODE="6665-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by India ink prep</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_INDIA_INK_PREP_CODE="6666-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_KOH_PREPARATION_CODE="6667-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Macchiavello stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_MACCHIAVELLO_STAIN_CODE="6669-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Malaria smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_MALARIA_SMEAR_CODE="6670-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Malaria thick smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_MALARIA_THICK_SMEAR_CODE="17280-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Methenamine silver nitrate stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_METHENAMINE_SILVER_NITRATE_STAIN_CODE="6671-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Methylene blue stain.Loeffler</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_METHYLENE_BLUE_STAIN_LOEFFLER_CODE="6672-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by MFadyean stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_MFADYEAN_STAIN_CODE="6668-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Neisser stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_NEISSER_STAIN_CODE="6673-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Night blue stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_NIGHT_BLUE_STAIN_CODE="10637-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Other stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_OTHER_STAIN_CODE="6471-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Periodic acid-Schiff stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_PERIODIC_ACID_SCHIFF_STAIN_CODE="6675-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="6677-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Trichrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_TRICHROME_STAIN_CODE="6473-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Warthin-Starry stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_WARTHIN_STARRY_STAIN_CODE="6679-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_WET_PREPARATION_CODE="6680-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Tissue by Wright stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_TISSUE_BY_WRIGHT_STAIN_CODE="6681-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACID_FAST_STAIN_CODE="11545-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Acid fast stain.Kinyoun</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACID_FAST_STAIN_KINYOUN_CODE="654-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Acid fast stain.Kinyoun modified</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED_CODE="655-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="656-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Acridine orange stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ACRIDINE_ORANGE_STAIN_CODE="657-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Calcofluor white</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_CALCOFLUOR_WHITE_CODE="658-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Carbol-fuchsin stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_CARBOL_FUCHSIN_STAIN_CODE="659-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Dark field examination</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_DARK_FIELD_EXAMINATION_CODE="660-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Dry mount</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_DRY_MOUNT_CODE="661-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Electron microscopy</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_ELECTRON_MICROSCOPY_CODE="34166-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Giemsa stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_GIEMSA_STAIN_CODE="662-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Gimenez stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_GIMENEZ_STAIN_CODE="663-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_GRAM_STAIN_CODE="664-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Hematoxylin and eosin stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_HEMATOXYLIN_AND_EOSIN_STAIN_CODE="665-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="35347-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by India ink prep</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_INDIA_INK_PREP_CODE="666-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Iron hematoxylin stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_IRON_HEMATOXYLIN_STAIN_CODE="14841-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Kinyoun iron hematoxylin stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_KINYOUN_IRON_HEMATOXYLIN_STAIN_CODE="14842-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_KOH_PREPARATION_CODE="667-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Lactophenol blue</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_LACTOPHENOL_BLUE_CODE="51700-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Macchiavello stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_MACCHIAVELLO_STAIN_CODE="669-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Malachite green stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_MALACHITE_GREEN_STAIN_CODE="33699-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Methenamine silver nitrate stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_METHENAMINE_SILVER_NITRATE_STAIN_CODE="670-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Methylene blue stain.Loeffler</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_METHYLENE_BLUE_STAIN_LOEFFLER_CODE="671-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by MFadyean stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_MFADYEAN_STAIN_CODE="668-4";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Neisser stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_NEISSER_STAIN_CODE="672-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Other stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_OTHER_STAIN_CODE="11546-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Periodic acid-Schiff stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PERIODIC_ACID_SCHIFF_STAIN_CODE="674-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="676-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_SMEAR_CODE="20431-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Toluidine blue O stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_TOLUIDINE_BLUE_O_STAIN_CODE="677-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Trichrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_TRICHROME_STAIN_CODE="678-3";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Tzanck smear</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_TZANCK_SMEAR_CODE="45043-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Warthin-Starry stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WARTHIN_STARRY_STAIN_CODE="679-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Wayson stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WAYSON_STAIN_CODE="44098-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WET_PREPARATION_CODE="680-9";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Wright Giemsa stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WRIGHT_GIEMSA_STAIN_CODE="682-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Unspecified specimen by Wright stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_WRIGHT_STAIN_CODE="681-7";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urethra by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URETHRA_BY_GRAM_STAIN_CODE="6474-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urethra by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URETHRA_BY_WET_PREPARATION_CODE="57851-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urine by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_ACID_FAST_STAIN_CODE="11480-1";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urine by Acid fast stain.Kinyoun</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_ACID_FAST_STAIN_KINYOUN_CODE="650-2";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urine by Acid fast stain.Kinyoun modified</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED_CODE="651-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urine by Acid fast stain.Ziehl-Neelsen</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE="652-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urine by Dark field examination</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_DARK_FIELD_EXAMINATION_CODE="20883-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urine by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_GRAM_STAIN_CODE="653-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urine by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_KOH_PREPARATION_CODE="68958-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Urine by Rhodamine-auramine fluorochrome stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_BY_RHODAMINE_AURAMINE_FLUOROCHROME_STAIN_CODE="53905-6";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Vaginal fluid by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_VAGINAL_FLUID_BY_GRAM_STAIN_CODE="14361-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Vaginal fluid by KOH preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_VAGINAL_FLUID_BY_KOH_PREPARATION_CODE="14356-0";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Vaginal fluid by Wet preparation</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_VAGINAL_FLUID_BY_WET_PREPARATION_CODE="14319-8";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Wound by Acid fast stain.Kinyoun modified</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_WOUND_BY_ACID_FAST_STAIN_KINYOUN_MODIFIED_CODE="14354-5";

	/** 
	*<div class="en">Code for Microscopic observation [Identifier] in Wound by Gram stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_WOUND_BY_GRAM_STAIN_CODE="10357-2";

	/** 
	*<div class="en">Code for Microscopic observation in Unspecified specimen by Electron microscopy Narrative</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_IN_UNSPECIFIED_SPECIMEN_BY_ELECTRON_MICROSCOPY_NARRATIVE_CODE="50668-3";

	/** 
	*<div class="en">Code for Microscopic observation [Presence] in Unspecified specimen Qualitative by Acid fast stain</div>
	*/
	public static final String MICROSCOPIC_OBSERVATION_PRESENCE_IN_UNSPECIFIED_SPECIMEN_QUALITATIVE_BY_ACID_FAST_STAIN_CODE="72357-7";

	/** 
	*<div class="en">Code for Minocycline 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String MINOCYCLINE_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25225-4";

	/** 
	*<div class="en">Code for Minocycline [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String MINOCYCLINE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="55156-4";

	/** 
	*<div class="en">Code for Moxifloxacin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String MOXIFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="41502-6";

	/** 
	*<div class="en">Code for Mycobacterium africanum</div>
	*/
	public static final String MYCOBACTERIUM_AFRICANUM_CODE="51320008";

	/** 
	*<div class="en">Code for Mycobacterium bovis</div>
	*/
	public static final String MYCOBACTERIUM_BOVIS_CODE="27142009";

	/** 
	*<div class="en">Code for Mycobacterium caprae</div>
	*/
	public static final String MYCOBACTERIUM_CAPRAE_CODE="430579009";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_CODE="113861009";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis complex</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_CODE="113858008";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis complex DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="38379-4";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis complex genotype [Identifier] in Isolate</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_GENOTYPE_IDENTIFIER_IN_ISOLATE_CODE="42717-9";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis complex rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="17296-5";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis complex rRNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48174-7";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis DNA [Presence] in Body fluid by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_DNA_PRESENCE_IN_BODY_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="58931-7";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="13956-8";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis DNA rpoB [Identifier] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_DNA_RPOB_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="46244-0";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis DNA [#/volume] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_DNA_VOLUME_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53257-2";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis ethambutol resistance (embB) gene [Identifier] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_ETHAMBUTOL_RESISTANCE_EMBB_GENE_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="46247-3";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis fluoroquinolone resistance (gyrA) gene [Presence] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_FLUOROQUINOLONE_RESISTANCE_GYRA_GENE_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="72276-9";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis isoniazid high level resistance (katG) gene [Identifier] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_ISONIAZID_HIGH_LEVEL_RESISTANCE_KATG_GENE_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="46246-5";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis isoniazid low level resistance (inhA) gene [Presence] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_ISONIAZID_LOW_LEVEL_RESISTANCE_INHA_GENE_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="63072-3";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis.isoniazid resistantMycobacterium tuberculosis isoniazid resistance (katG + inhA) genes [Presence] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_ISONIAZID_RESISTANTMYCOBACTERIUM_TUBERCULOSIS_ISONIAZID_RESISTANCE_KATG_INHA_GENES_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48175-4";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis pyrazinamide resistance (pncA) gene [Identifier] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_PYRAZINAMIDE_RESISTANCE_PNCA_GENE_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="46245-7";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis rifampin resistance gene [Identifier] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_RIFAMPIN_RESISTANCE_GENE_IDENTIFIER_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="33634-7";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis rifampin resistance (rpoB) gene [Presence] by Probe and target amplification method</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_RIFAMPIN_RESISTANCE_RPOB_GENE_PRESENCE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="48176-2";

	/** 
	*<div class="en">Code for Mycobacterium tuberculosis rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String MYCOBACTERIUM_TUBERCULOSIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="5027-8";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_CODE="68704007";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Cervical mucus by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_CERVICAL_MUCUS_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21414-8";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Conjunctival specimen by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="35735-0";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Genital specimen by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_GENITAL_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="47387-6";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Nasopharynx by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_NASOPHARYNX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="57180-2";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Unspecified specimen by Probe and signal amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_SIGNAL_AMPLIFICATION_METHOD_CODE="43403-5";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="24111-7";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Unspecified specimen from donor by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="50326-8";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Urethra by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_URETHRA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21415-5";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Urine by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_URINE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="21416-3";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae DNA [Presence] in Vaginal fluid by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_DNA_PRESENCE_IN_VAGINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="32705-6";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Anal by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_ANAL_BY_ORGANISM_SPECIFIC_CULTURE_CODE="14127-5";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Cervix by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_CERVIX_BY_ORGANISM_SPECIFIC_CULTURE_CODE="688-2";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Conjunctival specimen by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="30099-6";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Endometrium by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_ENDOMETRIUM_BY_ORGANISM_SPECIFIC_CULTURE_CODE="690-8";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Genital lochia by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_GENITAL_LOCHIA_BY_ORGANISM_SPECIFIC_CULTURE_CODE="692-4";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Genital specimen by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_GENITAL_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="691-6";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Semen by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_SEMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="694-0";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Synovial fluid by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_SYNOVIAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE_CODE="695-7";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Throat by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_THROAT_BY_ORGANISM_SPECIFIC_CULTURE_CODE="696-5";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="698-1";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Urethra by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_URETHRA_BY_ORGANISM_SPECIFIC_CULTURE_CODE="697-3";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae [Presence] in Vaginal fluid by Organism specific culture</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_PRESENCE_IN_VAGINAL_FLUID_BY_ORGANISM_SPECIFIC_CULTURE_CODE="693-2";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Anal by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_ANAL_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="57458-2";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Cervix by DNA probe</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_CERVIX_BY_DNA_PROBE_CODE="32198-4";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Cervix by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_CERVIX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="50388-8";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Conjunctival specimen by DNA probe</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_CONJUNCTIVAL_SPECIMEN_BY_DNA_PROBE_CODE="33904-4";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Nasopharynx by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_NASOPHARYNX_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="57289-1";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Penis by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_PENIS_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53878-5";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Throat by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_THROAT_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60255-7";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="5028-6";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="43305-2";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Unspecified specimen from donor by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="50412-6";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Urethra by DNA probe</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_URETHRA_BY_DNA_PROBE_CODE="32199-2";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Urethra by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_URETHRA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53927-0";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Urine by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_URINE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60256-5";

	/** 
	*<div class="en">Code for Neisseria gonorrhoeae rRNA [Presence] in Vaginal fluid by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_GONORRHOEAE_RRNA_PRESENCE_IN_VAGINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53879-3";

	/** 
	*<div class="en">Code for Neisseria meningitidis</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_CODE="17872004";

	/** 
	*<div class="en">Code for Neisseria meningitidis Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="6508-6";

	/** 
	*<div class="en">Code for Neisseria meningitidis Ag [Presence] in Tissue by Immune stain</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN_CODE="65763-5";

	/** 
	*<div class="en">Code for Neisseria meningitidis Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31912-9";

	/** 
	*<div class="en">Code for Neisseria meningitidis Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6492-3";

	/** 
	*<div class="en">Code for Neisseria meningitidis Ag [Presence] in Urine</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_AG_PRESENCE_IN_URINE_CODE="17323-7";

	/** 
	*<div class="en">Code for Neisseria meningitidis Ag [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_AG_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="31911-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis Ag [Units/volume] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_AG_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="17324-5";

	/** 
	*<div class="en">Code for Neisseria meningitidis A Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31907-9";

	/** 
	*<div class="en">Code for Neisseria meningitidis A Ag [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="6493-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis A Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="17326-0";

	/** 
	*<div class="en">Code for Neisseria meningitidis A Ag [Presence] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="6494-9";

	/** 
	*<div class="en">Code for Neisseria meningitidis A Ag [Presence] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_CODE="42369-9";

	/** 
	*<div class="en">Code for Neisseria meningitidis A Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31908-7";

	/** 
	*<div class="en">Code for Neisseria meningitidis A Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6495-6";

	/** 
	*<div class="en">Code for Neisseria meningitidis A Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="30094-7";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+C+w135+Y Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31909-5";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+C+w135+Y Ag [Presence] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="19133-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+C+w135+Y Ag [Presence] in Serum</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_SERUM_CODE="33396-3";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+C+w135+Y Ag [Presence] in Serum by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="33397-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+C+w135+Y Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31910-3";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+C+w135+Y Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="19259-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+C+w135+Y Ag [Presence] in Urine</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_URINE_CODE="32706-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+C+w135+Y Ag [Presence] in Urine by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_C_W135_Y_AG_PRESENCE_IN_URINE_BY_LATEX_AGGLUTINATION_CODE="33398-9";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+w135 Ag [Presence] in Body fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_W135_AG_PRESENCE_IN_BODY_FLUID_CODE="42341-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+Y Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="20487-5";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+Y Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="32848-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+Y Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="32851-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis A+Y Ag [Presence] in Urine</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_A_Y_AG_PRESENCE_IN_URINE_CODE="17321-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Body fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_BODY_FLUID_CODE="41503-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="24017-6";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="6496-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6497-2";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="6498-0";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_CODE="42370-7";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Serum</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_SERUM_CODE="43430-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31913-7";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="30095-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Urine</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_URINE_CODE="24018-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis B Ag [Presence] in Urine by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_B_AG_PRESENCE_IN_URINE_BY_LATEX_AGGLUTINATION_CODE="17328-6";

	/** 
	*<div class="en">Code for Neisseria meningitidis C Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31916-0";

	/** 
	*<div class="en">Code for Neisseria meningitidis C Ag [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="6499-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis C Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="17329-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis C Ag [Presence] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="6500-3";

	/** 
	*<div class="en">Code for Neisseria meningitidis C Ag [Presence] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_CODE="42371-5";

	/** 
	*<div class="en">Code for Neisseria meningitidis C Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31917-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis C Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6501-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis C Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="30096-2";

	/** 
	*<div class="en">Code for Neisseria meningitidis C+w135 Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_W135_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="19022-3";

	/** 
	*<div class="en">Code for Neisseria meningitidis C+w135 Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_W135_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="32841-9";

	/** 
	*<div class="en">Code for Neisseria meningitidis C+w135 Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_W135_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="32800-5";

	/** 
	*<div class="en">Code for Neisseria meningitidis C+w135 Ag [Presence] in Urine</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_C_W135_AG_PRESENCE_IN_URINE_CODE="17325-2";

	/** 
	*<div class="en">Code for Neisseria meningitidis DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53606-0";

	/** 
	*<div class="en">Code for Neisseria meningitidis DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49671-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis D Ag [Presence] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_D_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_CODE="42372-3";

	/** 
	*<div class="en">Code for Neisseria meningitidis group A</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_GROUP_A_CODE="103479006";

	/** 
	*<div class="en">Code for Neisseria meningitidis group B</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_GROUP_B_CODE="103480009";

	/** 
	*<div class="en">Code for Neisseria meningitidis group C</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_GROUP_C_CODE="103481008";

	/** 
	*<div class="en">Code for Neisseria meningitidis group X</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_GROUP_X_CODE="125041003";

	/** 
	*<div class="en">Code for Neisseria meningitidis group Y</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_GROUP_Y_CODE="103482001";

	/** 
	*<div class="en">Code for Neisseria meningitidis group Z</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_GROUP_Z_CODE="125042005";

	/** 
	*<div class="en">Code for Neisseria meningitidis [Identifier] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION_CODE="45183-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis [Identifier] in Isolate by Organism specific culture</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_IDENTIFIER_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="44093-3";

	/** 
	*<div class="en">Code for Neisseria meningitidis polyvalent Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_POLYVALENT_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="17332-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="16134-9";

	/** 
	*<div class="en">Code for Neisseria meningitidis rRNA [Presence] in Cerebral spinal fluid by DNA probe</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_RRNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_DNA_PROBE_CODE="6509-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="5029-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis serogroup DNA [Identifier] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_SEROGROUP_DNA_IDENTIFIER_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="71788-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis W135</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_CODE="103483006";

	/** 
	*<div class="en">Code for Neisseria meningitidis w135 Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31918-6";

	/** 
	*<div class="en">Code for Neisseria meningitidis w135 Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6506-0";

	/** 
	*<div class="en">Code for Neisseria meningitidis w135 Ag [Presence] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="6507-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis w135 Ag [Presence] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_CODE="42368-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis w135 Ag [Presence] in Serum or Plasma</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_SERUM_OR_PLASMA_CODE="31919-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis w135 Ag [Presence] in Serum or Plasma by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_SERUM_OR_PLASMA_BY_LATEX_AGGLUTINATION_CODE="17333-6";

	/** 
	*<div class="en">Code for Neisseria meningitidis w135 Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31920-2";

	/** 
	*<div class="en">Code for Neisseria meningitidis w135 Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_W135_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="30097-0";

	/** 
	*<div class="en">Code for Neisseria meningitidis X Ag [Presence] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_X_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_CODE="42373-1";

	/** 
	*<div class="en">Code for Neisseria meningitidis Y Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="17330-2";

	/** 
	*<div class="en">Code for Neisseria meningitidis Y Ag [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="6503-7";

	/** 
	*<div class="en">Code for Neisseria meningitidis Y Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6504-5";

	/** 
	*<div class="en">Code for Neisseria meningitidis Y Ag [Presence] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="6505-2";

	/** 
	*<div class="en">Code for Neisseria meningitidis Y Ag [Presence] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_CODE="42374-9";

	/** 
	*<div class="en">Code for Neisseria meningitidis Y Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31921-0";

	/** 
	*<div class="en">Code for Neisseria meningitidis Y Ag [Presence] in Unspecified specimen by Latex agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Y_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_LATEX_AGGLUTINATION_CODE="30098-8";

	/** 
	*<div class="en">Code for Neisseria meningitidis Z Ag [Presence] in Isolate by Agglutination</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Z_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_CODE="42376-4";

	/** 
	*<div class="en">Code for Neisseria meningitidis Z Ag [Presence] in Isolate by Agglutination 1</div>
	*/
	public static final String NEISSERIA_MENINGITIDIS_Z_AG_PRESENCE_IN_ISOLATE_BY_AGGLUTINATION_1_CODE="42375-6";

	/** 
	*<div class="en">Code for Ofloxacin 1.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String OFLOXACIN_1_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="72168-8";

	/** 
	*<div class="en">Code for Ofloxacin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String OFLOXACIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="41408-6";

	/** 
	*<div class="en">Code for Ofloxacin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String OFLOXACIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="41409-4";

	/** 
	*<div class="en">Code for Ofloxacin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String OFLOXACIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="41410-2";

	/** 
	*<div class="en">Code for Ofloxacin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String OFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20384-4";

	/** 
	*<div class="en">Code for Para aminosalicylate 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PARA_AMINOSALICYLATE_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="48685-2";

	/** 
	*<div class="en">Code for Para aminosalicylate 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PARA_AMINOSALICYLATE_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25215-5";

	/** 
	*<div class="en">Code for Para aminosalicylate 8 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PARA_AMINOSALICYLATE_8_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25216-3";

	/** 
	*<div class="en">Code for Para aminosalicylate [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PARA_AMINOSALICYLATE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23611-7";

	/** 
	*<div class="en">Code for Plasmodium falciparum Ag [Units/volume] in Blood by Immunofluorescence</div>
	*/
	public static final String PLASMODIUM_FALCIPARUM_AG_UNITSVOLUME_IN_BLOOD_BY_IMMUNOFLUORESCENCE_CODE="10709-4";

	/** 
	*<div class="en">Code for Plasmodium falciparum DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String PLASMODIUM_FALCIPARUM_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41447-4";

	/** 
	*<div class="en">Code for Plasmodium knowlesi DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String PLASMODIUM_KNOWLESI_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="70568-1";

	/** 
	*<div class="en">Code for Plasmodium malariae DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String PLASMODIUM_MALARIAE_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41448-2";

	/** 
	*<div class="en">Code for Plasmodium ovale DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String PLASMODIUM_OVALE_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41449-0";

	/** 
	*<div class="en">Code for Plasmodium sp Ag [Identifier] in Blood</div>
	*/
	public static final String PLASMODIUM_SP_AG_IDENTIFIER_IN_BLOOD_CODE="51865-4";

	/** 
	*<div class="en">Code for Plasmodium sp Ag [Identifier] in Blood by Rapid immunoassay</div>
	*/
	public static final String PLASMODIUM_SP_AG_IDENTIFIER_IN_BLOOD_BY_RAPID_IMMUNOASSAY_CODE="70569-9";

	/** 
	*<div class="en">Code for Plasmodium sp Ag [Presence] in Blood</div>
	*/
	public static final String PLASMODIUM_SP_AG_PRESENCE_IN_BLOOD_CODE="50687-3";

	/** 
	*<div class="en">Code for Plasmodium sp Ag [Presence] in Blood by Immunoassay</div>
	*/
	public static final String PLASMODIUM_SP_AG_PRESENCE_IN_BLOOD_BY_IMMUNOASSAY_CODE="46094-9";

	/** 
	*<div class="en">Code for Plasmodium sp DNA [Identifier] in Blood by Probe and target amplification method</div>
	*/
	public static final String PLASMODIUM_SP_DNA_IDENTIFIER_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="47260-5";

	/** 
	*<div class="en">Code for Plasmodium sp DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String PLASMODIUM_SP_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="47085-6";

	/** 
	*<div class="en">Code for Plasmodium sp identified in Blood by Light microscopy</div>
	*/
	public static final String PLASMODIUM_SP_IDENTIFIED_IN_BLOOD_BY_LIGHT_MICROSCOPY_CODE="32206-5";

	/** 
	*<div class="en">Code for Plasmodium sp identified in Blood by Thin film</div>
	*/
	public static final String PLASMODIUM_SP_IDENTIFIED_IN_BLOOD_BY_THIN_FILM_CODE="10710-2";

	/** 
	*<div class="en">Code for Plasmodium sp [Presence] in Blood by Light microscopy</div>
	*/
	public static final String PLASMODIUM_SP_PRESENCE_IN_BLOOD_BY_LIGHT_MICROSCOPY_CODE="51587-4";

	/** 
	*<div class="en">Code for Plasmodium vivax Ag [Units/volume] in Blood</div>
	*/
	public static final String PLASMODIUM_VIVAX_AG_UNITSVOLUME_IN_BLOOD_CODE="31931-9";

	/** 
	*<div class="en">Code for Plasmodium vivax Ag [Units/volume] in Blood by Immunofluorescence</div>
	*/
	public static final String PLASMODIUM_VIVAX_AG_UNITSVOLUME_IN_BLOOD_BY_IMMUNOFLUORESCENCE_CODE="10711-0";

	/** 
	*<div class="en">Code for Plasmodium vivax DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String PLASMODIUM_VIVAX_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41450-8";

	/** 
	*<div class="en">Code for Polio virus 1 Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String POLIO_VIRUS_1_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="24243-8";

	/** 
	*<div class="en">Code for Polio virus 1 Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String POLIO_VIRUS_1_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="24244-6";

	/** 
	*<div class="en">Code for Polio virus 1 Ab [Titer] in Serum by Neutralization test --2nd specimen</div>
	*/
	public static final String POLIO_VIRUS_1_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_2ND_SPECIMEN_CODE="24170-3";

	/** 
	*<div class="en">Code for Polio virus 2 Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String POLIO_VIRUS_2_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="24245-3";

	/** 
	*<div class="en">Code for Polio virus 2 Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String POLIO_VIRUS_2_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="24246-1";

	/** 
	*<div class="en">Code for Polio virus 2 Ab [Titer] in Serum by Neutralization test --1st specimen</div>
	*/
	public static final String POLIO_VIRUS_2_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_1ST_SPECIMEN_CODE="24171-1";

	/** 
	*<div class="en">Code for Polio virus 2 Ab [Titer] in Serum by Neutralization test --2nd specimen</div>
	*/
	public static final String POLIO_VIRUS_2_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_2ND_SPECIMEN_CODE="24172-9";

	/** 
	*<div class="en">Code for Polio virus 3 Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String POLIO_VIRUS_3_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="24247-9";

	/** 
	*<div class="en">Code for Polio virus 3 Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String POLIO_VIRUS_3_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="24248-7";

	/** 
	*<div class="en">Code for Polio virus 3 Ab [Titer] in Serum by Neutralization test --1st specimen</div>
	*/
	public static final String POLIO_VIRUS_3_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_1ST_SPECIMEN_CODE="24173-7";

	/** 
	*<div class="en">Code for Polio virus 3 Ab [Titer] in Serum by Neutralization test --2nd specimen</div>
	*/
	public static final String POLIO_VIRUS_3_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_2ND_SPECIMEN_CODE="24174-5";

	/** 
	*<div class="en">Code for Polio virus identified in Stool by Organism specific culture</div>
	*/
	public static final String POLIO_VIRUS_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE_CODE="53645-8";

	/** 
	*<div class="en">Code for Polio virus identified [Type] in Isolate by Organism specific culture</div>
	*/
	public static final String POLIO_VIRUS_IDENTIFIED_TYPE_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="60546-9";

	/** 
	*<div class="en">Code for Polio virus IgG Ab [Titer] in Cerebral spinal fluid --2nd specimen</div>
	*/
	public static final String POLIO_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_2ND_SPECIMEN_CODE="40783-3";

	/** 
	*<div class="en">Code for Polio virus IgG Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String POLIO_VIRUS_IGG_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="40708-0";

	/** 
	*<div class="en">Code for Polio virus IgM Ab [Titer] in Cerebral spinal fluid --1st specimen</div>
	*/
	public static final String POLIO_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_1ST_SPECIMEN_CODE="40782-5";

	/** 
	*<div class="en">Code for Polio virus IgM Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String POLIO_VIRUS_IGM_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="40781-7";

	/** 
	*<div class="en">Code for Prothionamide [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PROTHIONAMIDE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="63565-6";

	/** 
	*<div class="en">Code for Pyrazinamide 100 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PYRAZINAMIDE_100_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25229-6";

	/** 
	*<div class="en">Code for Pyrazinamide 200 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PYRAZINAMIDE_200_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="55711-6";

	/** 
	*<div class="en">Code for Pyrazinamide 25 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PYRAZINAMIDE_25_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25186-8";

	/** 
	*<div class="en">Code for Pyrazinamide 300 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PYRAZINAMIDE_300_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="56026-8";

	/** 
	*<div class="en">Code for Pyrazinamide [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String PYRAZINAMIDE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20461-0";

	/** 
	*<div class="en">Code for Quinupristin+Dalfopristin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String QUINUPRISTIN_DALFOPRISTIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="58712-1";

	/** 
	*<div class="en">Code for Rabies virus Ag [Presence] in Brain by Immune stain</div>
	*/
	public static final String RABIES_VIRUS_AG_PRESENCE_IN_BRAIN_BY_IMMUNE_STAIN_CODE="23390-8";

	/** 
	*<div class="en">Code for Rabies virus Ag [Presence] in Brain by Immunoassay</div>
	*/
	public static final String RABIES_VIRUS_AG_PRESENCE_IN_BRAIN_BY_IMMUNOASSAY_CODE="23389-0";

	/** 
	*<div class="en">Code for Rabies virus Ag [Presence] in Tissue by Immunofluorescence</div>
	*/
	public static final String RABIES_VIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE_CODE="6528-4";

	/** 
	*<div class="en">Code for Rabies virus Ag [Presence] in Unspecified specimen by Immune stain</div>
	*/
	public static final String RABIES_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNE_STAIN_CODE="23391-6";

	/** 
	*<div class="en">Code for Rabies virus Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String RABIES_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="6532-6";

	/** 
	*<div class="en">Code for Rabies virus identified in Tissue by Organism specific culture</div>
	*/
	public static final String RABIES_VIRUS_IDENTIFIED_IN_TISSUE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6536-7";

	/** 
	*<div class="en">Code for Rabies virus identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String RABIES_VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6539-1";

	/** 
	*<div class="en">Code for Rabies virus [Presence] in Brain by Light microscopy</div>
	*/
	public static final String RABIES_VIRUS_PRESENCE_IN_BRAIN_BY_LIGHT_MICROSCOPY_CODE="23388-2";

	/** 
	*<div class="en">Code for Rabies virus RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String RABIES_VIRUS_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60270-6";

	/** 
	*<div class="en">Code for Rabies virus RNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String RABIES_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="51647-6";

	/** 
	*<div class="en">Code for Rabies virus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String RABIES_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="51646-8";

	/** 
	*<div class="en">Code for Rabies virus strain identified in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String RABIES_VIRUS_STRAIN_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="70866-9";

	/** 
	*<div class="en">Code for Rabies virus strain identified in Unspecified specimen by Sequencing</div>
	*/
	public static final String RABIES_VIRUS_STRAIN_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_SEQUENCING_CODE="70867-7";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="22459-2";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Cerebral spinal fluid by VDRL</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_VDRL_CODE="5290-2";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Cord blood</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_CORD_BLOOD_CODE="43813-5";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Cord blood by VDRL</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_CORD_BLOOD_BY_VDRL_CODE="51783-9";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Serum</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_SERUM_CODE="22461-8";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Serum by RPR</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_SERUM_BY_RPR_CODE="20507-0";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Serum by VDRL</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_SERUM_BY_VDRL_CODE="5292-8";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Serum from donor</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_SERUM_FROM_DONOR_CODE="22463-4";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Serum from donor by RPR</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_RPR_CODE="47360-3";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Serum from donor by VDRL</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_VDRL_CODE="21030-2";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Unspecified specimen</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="22464-2";

	/** 
	*<div class="en">Code for Reagin Ab [Presence] in Unspecified specimen by VDRL</div>
	*/
	public static final String REAGIN_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_VDRL_CODE="14904-7";

	/** 
	*<div class="en">Code for Reagin Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String REAGIN_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="46203-6";

	/** 
	*<div class="en">Code for Reagin Ab [Titer] in Cerebral spinal fluid by VDRL</div>
	*/
	public static final String REAGIN_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_VDRL_CODE="31146-4";

	/** 
	*<div class="en">Code for Reagin Ab [Titer] in Serum</div>
	*/
	public static final String REAGIN_AB_TITER_IN_SERUM_CODE="11084-1";

	/** 
	*<div class="en">Code for Reagin Ab [Titer] in Serum by RPR</div>
	*/
	public static final String REAGIN_AB_TITER_IN_SERUM_BY_RPR_CODE="31147-2";

	/** 
	*<div class="en">Code for Reagin Ab [Titer] in Serum by VDRL</div>
	*/
	public static final String REAGIN_AB_TITER_IN_SERUM_BY_VDRL_CODE="50690-7";

	/** 
	*<div class="en">Code for Reagin Ab [Titer] in Unspecified specimen</div>
	*/
	public static final String REAGIN_AB_TITER_IN_UNSPECIFIED_SPECIMEN_CODE="47476-7";

	/** 
	*<div class="en">Code for Reagin Ab [Titer] in Unspecified specimen by VDRL</div>
	*/
	public static final String REAGIN_AB_TITER_IN_UNSPECIFIED_SPECIMEN_BY_VDRL_CODE="47235-7";

	/** 
	*<div class="en">Code for Reagin Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String REAGIN_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="22460-0";

	/** 
	*<div class="en">Code for Reagin Ab [Units/volume] in Cerebral spinal fluid by VDRL</div>
	*/
	public static final String REAGIN_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_VDRL_CODE="5289-4";

	/** 
	*<div class="en">Code for Reagin Ab [Units/volume] in Serum</div>
	*/
	public static final String REAGIN_AB_UNITSVOLUME_IN_SERUM_CODE="22462-6";

	/** 
	*<div class="en">Code for Reagin Ab [Units/volume] in Serum by RPR</div>
	*/
	public static final String REAGIN_AB_UNITSVOLUME_IN_SERUM_BY_RPR_CODE="20508-8";

	/** 
	*<div class="en">Code for Reagin Ab [Units/volume] in Serum by VDRL</div>
	*/
	public static final String REAGIN_AB_UNITSVOLUME_IN_SERUM_BY_VDRL_CODE="5291-0";

	/** 
	*<div class="en">Code for Rifabutin 0.5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFABUTIN_0_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="42655-1";

	/** 
	*<div class="en">Code for Rifabutin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFABUTIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25199-1";

	/** 
	*<div class="en">Code for Rifabutin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFABUTIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25200-7";

	/** 
	*<div class="en">Code for Rifabutin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFABUTIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25201-5";

	/** 
	*<div class="en">Code for Rifabutin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFABUTIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20386-9";

	/** 
	*<div class="en">Code for Rifampin 14 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFAMPIN_14_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25184-3";

	/** 
	*<div class="en">Code for Rifampin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFAMPIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25202-3";

	/** 
	*<div class="en">Code for Rifampin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFAMPIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25203-1";

	/** 
	*<div class="en">Code for Rifampin 40 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFAMPIN_40_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="55712-4";

	/** 
	*<div class="en">Code for Rifampin 5 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFAMPIN_5_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25204-9";

	/** 
	*<div class="en">Code for Rifampin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String RIFAMPIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20385-1";

	/** 
	*<div class="en">Code for Rift valley fever virus Ab [Titer] in Serum</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AB_TITER_IN_SERUM_CODE="23400-5";

	/** 
	*<div class="en">Code for Rift valley fever virus Ab [Titer] in Serum by Neutralization test</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_CODE="23396-5";

	/** 
	*<div class="en">Code for Rift valley fever virus Ab [Units/volume] in Serum</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="31612-5";

	/** 
	*<div class="en">Code for Rift valley fever virus Ag [Presence] in Blood by Neutralization test</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_BLOOD_BY_NEUTRALIZATION_TEST_CODE="23402-1";

	/** 
	*<div class="en">Code for Rift valley fever virus Ag [Presence] in Serum by Immune diffusion (ID)</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_SERUM_BY_IMMUNE_DIFFUSION_ID_CODE="23406-2";

	/** 
	*<div class="en">Code for Rift valley fever virus Ag [Presence] in Serum by Immunoassay</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="71778-5";

	/** 
	*<div class="en">Code for Rift valley fever virus Ag [Presence] in Tissue by Immune diffusion (ID)</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_DIFFUSION_ID_CODE="23405-4";

	/** 
	*<div class="en">Code for Rift valley fever virus Ag [Presence] in Tissue by Immunofluorescence</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNOFLUORESCENCE_CODE="23404-7";

	/** 
	*<div class="en">Code for Rift valley fever virus Ag [Presence] in Tissue by Neutralization test</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_TISSUE_BY_NEUTRALIZATION_TEST_CODE="23401-3";

	/** 
	*<div class="en">Code for Rift valley fever virus Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31951-7";

	/** 
	*<div class="en">Code for Rift valley fever virus Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="23403-9";

	/** 
	*<div class="en">Code for Rift valley fever virus IgG Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="71784-3";

	/** 
	*<div class="en">Code for Rift valley fever virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="71781-9";

	/** 
	*<div class="en">Code for Rift valley fever virus IgM Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String RIFT_VALLEY_FEVER_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="71779-3";

	/** 
	*<div class="en">Code for Rubella virus Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="42967-0";

	/** 
	*<div class="en">Code for Rubella virus Ab [Titer] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String RUBELLA_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="40542-3";

	/** 
	*<div class="en">Code for Rubella virus Ab [Titer] in Serum</div>
	*/
	public static final String RUBELLA_VIRUS_AB_TITER_IN_SERUM_CODE="22497-2";

	/** 
	*<div class="en">Code for Rubella virus Ab [Titer] in Serum by Hemagglutination inhibition</div>
	*/
	public static final String RUBELLA_VIRUS_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION_CODE="50694-9";

	/** 
	*<div class="en">Code for Rubella virus Ab [Titer] in Serum by Latex agglutination</div>
	*/
	public static final String RUBELLA_VIRUS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5333-0";

	/** 
	*<div class="en">Code for Rubella virus Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="17549-7";

	/** 
	*<div class="en">Code for Rubella virus Ab [Units/volume] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String RUBELLA_VIRUS_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="9576-0";

	/** 
	*<div class="en">Code for Rubella virus Ab [Units/volume] in Serum</div>
	*/
	public static final String RUBELLA_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="8013-5";

	/** 
	*<div class="en">Code for Rubella virus Ab [Units/volume] in Serum by Hemagglutination inhibition</div>
	*/
	public static final String RUBELLA_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION_CODE="5330-6";

	/** 
	*<div class="en">Code for Rubella virus Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String RUBELLA_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51931-4";

	/** 
	*<div class="en">Code for Rubella virus Ab [Units/volume] in Serum by Latex agglutination</div>
	*/
	public static final String RUBELLA_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="17550-5";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31955-8";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="14523-5";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Cervix</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_CERVIX_CODE="31956-6";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Cervix by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_CERVIX_BY_IMMUNOFLUORESCENCE_CODE="14529-2";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Eye</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_EYE_CODE="31957-4";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Eye by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_EYE_BY_IMMUNOFLUORESCENCE_CODE="14526-8";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Nose</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_NOSE_CODE="31959-0";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Nose by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_NOSE_BY_IMMUNOFLUORESCENCE_CODE="14527-6";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Penis</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_PENIS_CODE="31960-8";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Penis by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_PENIS_BY_IMMUNOFLUORESCENCE_CODE="14532-6";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Skin</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_SKIN_CODE="31961-6";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Skin by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_SKIN_BY_IMMUNOFLUORESCENCE_CODE="14525-0";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Sputum</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_SPUTUM_CODE="31962-4";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Sputum by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_SPUTUM_BY_IMMUNOFLUORESCENCE_CODE="14528-4";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Throat</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_THROAT_CODE="31963-2";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Throat by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_THROAT_BY_IMMUNOFLUORESCENCE_CODE="14524-3";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Unspecified specimen</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="31966-5";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="12251-5";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Urethra</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_URETHRA_CODE="31965-7";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Urethra by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_URETHRA_BY_IMMUNOFLUORESCENCE_CODE="14533-4";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Urine sediment</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_URINE_SEDIMENT_CODE="31964-0";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Urine sediment by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_URINE_SEDIMENT_BY_IMMUNOFLUORESCENCE_CODE="14531-8";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Vaginal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_VAGINAL_FLUID_CODE="31958-2";

	/** 
	*<div class="en">Code for Rubella virus Ag [Presence] in Vaginal fluid by Immunofluorescence</div>
	*/
	public static final String RUBELLA_VIRUS_AG_PRESENCE_IN_VAGINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="14530-0";

	/** 
	*<div class="en">Code for Rubella virus identified in Serum by Organism specific culture</div>
	*/
	public static final String RUBELLA_VIRUS_IDENTIFIED_IN_SERUM_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6548-2";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Ratio] in Serum --1st specimen/2nd specimen</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_RATIO_IN_SERUM_1ST_SPECIMEN2ND_SPECIMEN_CODE="25298-1";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="46110-3";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Titer] in Serum</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_TITER_IN_SERUM_CODE="41763-4";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Units/volume] in Body fluid</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_BODY_FLUID_CODE="29343-1";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="13281-1";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Units/volume] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="17551-3";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="8014-3";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Units/volume] in Serumds --2nd specimen</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUMDS_2ND_SPECIMEN_CODE="13280-3";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Units/volume] in Serum --1st specimen</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_1ST_SPECIMEN_CODE="13279-5";

	/** 
	*<div class="en">Code for Rubella virus IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String RUBELLA_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5334-8";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Presence] in Body fluid by Immunoassay</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOASSAY_CODE="69765-6";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="17552-1";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="40669-4";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Presence] in Serum</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="31616-6";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="24116-6";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Presence] in Serum by Latex agglutination</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="25420-1";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="46109-5";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Titer] in Serum</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_TITER_IN_SERUM_CODE="49107-6";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Units/volume] in Body fluid</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_BODY_FLUID_CODE="31047-4";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="13282-9";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="8015-0";

	/** 
	*<div class="en">Code for Rubella virus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String RUBELLA_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="5335-5";

	/** 
	*<div class="en">Code for Rubella virus RNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String RUBELLA_VIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60274-8";

	/** 
	*<div class="en">Code for Rubella virus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String RUBELLA_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="54091-4";

	/** 
	*<div class="en">Code for Salmonella</div>
	*/
	public static final String SALMONELLA_CODE="27268008";

	/** 
	*<div class="en">Code for Salmonella enterica DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String SALMONELLA_ENTERICA_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="61370-3";

	/** 
	*<div class="en">Code for Salmonella enteritidis</div>
	*/
	public static final String SALMONELLA_ENTERITIDIS_CODE="73525009";

	/** 
	*<div class="en">Code for Salmonella enteritidis [Presence] in Stool by Organism specific culture</div>
	*/
	public static final String SALMONELLA_ENTERITIDIS_PRESENCE_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE_CODE="23602-6";

	/** 
	*<div class="en">Code for Salmonella enteritidis [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String SALMONELLA_ENTERITIDIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="34891-2";

	/** 
	*<div class="en">Code for Salmonella gallinarum DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String SALMONELLA_GALLINARUM_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="23431-0";

	/** 
	*<div class="en">Code for Salmonella gallinarum rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String SALMONELLA_GALLINARUM_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="23432-8";

	/** 
	*<div class="en">Code for Salmonella paratyphi A</div>
	*/
	public static final String SALMONELLA_PARATYPHI_A_CODE="79128009";

	/** 
	*<div class="en">Code for Salmonella paratyphi B</div>
	*/
	public static final String SALMONELLA_PARATYPHI_B_CODE="85908006";

	/** 
	*<div class="en">Code for Salmonella paratyphi C</div>
	*/
	public static final String SALMONELLA_PARATYPHI_C_CODE="32488009";

	/** 
	*<div class="en">Code for Salmonella pullorum DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String SALMONELLA_PULLORUM_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="23435-1";

	/** 
	*<div class="en">Code for Salmonella pullorum rRNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String SALMONELLA_PULLORUM_RRNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="23436-9";

	/** 
	*<div class="en">Code for Salmonella species</div>
	*/
	public static final String SALMONELLA_SPECIES_CODE="372342007";

	/** 
	*<div class="en">Code for Salmonella sp antigenic formula [Identifier] in Isolate by Agglutination</div>
	*/
	public static final String SALMONELLA_SP_ANTIGENIC_FORMULA_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION_CODE="56475-7";

	/** 
	*<div class="en">Code for Salmonella sp DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String SALMONELLA_SP_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49612-5";

	/** 
	*<div class="en">Code for Salmonella sp identified in Stool by Organism specific culture</div>
	*/
	public static final String SALMONELLA_SP_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE_CODE="20955-1";

	/** 
	*<div class="en">Code for Salmonella sp identified in Tissue by Organism specific culture</div>
	*/
	public static final String SALMONELLA_SP_IDENTIFIED_IN_TISSUE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="20953-6";

	/** 
	*<div class="en">Code for Salmonella sp identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String SALMONELLA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="17563-8";

	/** 
	*<div class="en">Code for Salmonella sp identified [Type] in Isolate</div>
	*/
	public static final String SALMONELLA_SP_IDENTIFIED_TYPE_IN_ISOLATE_CODE="59846-6";

	/** 
	*<div class="en">Code for Salmonella sp serotype [Identifier] in Isolate by Agglutination</div>
	*/
	public static final String SALMONELLA_SP_SEROTYPE_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION_CODE="20951-0";

	/** 
	*<div class="en">Code for Salmonella sp serovar [Type] in Isolate</div>
	*/
	public static final String SALMONELLA_SP_SEROVAR_TYPE_IN_ISOLATE_CODE="65756-9";

	/** 
	*<div class="en">Code for Salmonella typhi</div>
	*/
	public static final String SALMONELLA_TYPHI_CODE="5595000";

	/** 
	*<div class="en">Code for Salmonella typhimurium</div>
	*/
	public static final String SALMONELLA_TYPHIMURIUM_CODE="50136005";

	/** 
	*<div class="en">Code for Salmonella typhi DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String SALMONELLA_TYPHI_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="70021-1";

	/** 
	*<div class="en">Code for Salmonella typhi [Identifier] in Isolate by Agglutination</div>
	*/
	public static final String SALMONELLA_TYPHI_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION_CODE="53956-9";

	/** 
	*<div class="en">Code for SARS coronavirus Ab [Titer] in Serum</div>
	*/
	public static final String SARS_CORONAVIRUS_AB_TITER_IN_SERUM_CODE="60426-4";

	/** 
	*<div class="en">Code for SARS coronavirus IgM Ab [Presence] in Serum</div>
	*/
	public static final String SARS_CORONAVIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="42956-3";

	/** 
	*<div class="en">Code for SARS coronavirus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String SARS_CORONAVIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="41991-1";

	/** 
	*<div class="en">Code for SARS coronavirus RNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String SARS_CORONAVIRUS_RNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60275-5";

	/** 
	*<div class="en">Code for SARS coronavirus RNA [Presence] in Serum or Plasma by Probe and target amplification method</div>
	*/
	public static final String SARS_CORONAVIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="60534-5";

	/** 
	*<div class="en">Code for SARS coronavirus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String SARS_CORONAVIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41458-1";

	/** 
	*<div class="en">Code for Shigella boydii</div>
	*/
	public static final String SHIGELLA_BOYDII_CODE="55462008";

	/** 
	*<div class="en">Code for Shigella boydii Ag [Presence] in Isolate</div>
	*/
	public static final String SHIGELLA_BOYDII_AG_PRESENCE_IN_ISOLATE_CODE="42256-8";

	/** 
	*<div class="en">Code for Shigella dysenteriae</div>
	*/
	public static final String SHIGELLA_DYSENTERIAE_CODE="43612004";

	/** 
	*<div class="en">Code for Shigella dysenteriae Ag [Presence] in Isolate</div>
	*/
	public static final String SHIGELLA_DYSENTERIAE_AG_PRESENCE_IN_ISOLATE_CODE="42257-6";

	/** 
	*<div class="en">Code for Shigella flexneri</div>
	*/
	public static final String SHIGELLA_FLEXNERI_CODE="85729005";

	/** 
	*<div class="en">Code for Shigella flexneri Ag [Presence] in Isolate</div>
	*/
	public static final String SHIGELLA_FLEXNERI_AG_PRESENCE_IN_ISOLATE_CODE="42258-4";

	/** 
	*<div class="en">Code for Shigella sonnei</div>
	*/
	public static final String SHIGELLA_SONNEI_CODE="4298009";

	/** 
	*<div class="en">Code for Shigella sonnei Ag [Presence] in Isolate</div>
	*/
	public static final String SHIGELLA_SONNEI_AG_PRESENCE_IN_ISOLATE_CODE="42259-2";

	/** 
	*<div class="en">Code for Shigella species</div>
	*/
	public static final String SHIGELLA_SPECIES_CODE="116498009";

	/** 
	*<div class="en">Code for Shigella sp DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String SHIGELLA_SP_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="46455-2";

	/** 
	*<div class="en">Code for Shigella sp identified in Feed by Organism specific culture</div>
	*/
	public static final String SHIGELLA_SP_IDENTIFIED_IN_FEED_BY_ORGANISM_SPECIFIC_CULTURE_CODE="20964-3";

	/** 
	*<div class="en">Code for Shigella sp identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String SHIGELLA_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="17576-0";

	/** 
	*<div class="en">Code for Shigella sp [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String SHIGELLA_SP_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="46454-5";

	/** 
	*<div class="en">Code for Shigella sp serotype [Identifier] in Isolate by Agglutination</div>
	*/
	public static final String SHIGELLA_SP_SEROTYPE_IDENTIFIER_IN_ISOLATE_BY_AGGLUTINATION_CODE="49056-5";

	/** 
	*<div class="en">Code for Sparfloxacin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String SPARFLOXACIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23610-9";

	/** 
	*<div class="en">Code for Streptococcus penumoniae 3</div>
	*/
	public static final String STREPTOCOCCUS_PENUMONIAE_3_CODE="103497003";

	/** 
	*<div class="en">Code for Streptococcus penumoniae, serotype 29</div>
	*/
	public static final String STREPTOCOCCUS_PENUMONIAE_SEROTYPE_29_CODE="131363003";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_CODE="9861002";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae 14</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_14_CODE="103498008";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae 7F</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_7F_CODE="103499000";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae 9N</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_9N_CODE="103500009";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae Ag [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="20489-1";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae Ag [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="6553-2";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae Ag [Presence] in Cerebral spinal fluid by Latex agglutination</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_LATEX_AGGLUTINATION_CODE="14322-2";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae Ag [Presence] in Serum</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_SERUM_CODE="11086-6";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae Ag [Presence] in Urine</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_AG_PRESENCE_IN_URINE_CODE="24027-5";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53917-1";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae, serotype 11</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_11_CODE="363768008";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae, serotype 12</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_12_CODE="116500005";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae, serotype 16</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_16_CODE="131362008";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae, serotype 17</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_17_CODE="131361001";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae, serotype 19</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_19_CODE="127541006";

	/** 
	*<div class="en">Code for Streptococcus pneumoniae, serotype 22</div>
	*/
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_22_CODE="363767003";

	/** 
	*<div class="en">Code for Streptomycin 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String STREPTOMYCIN_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25206-4";

	/** 
	*<div class="en">Code for Streptomycin 1 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String STREPTOMYCIN_1_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="48177-0";

	/** 
	*<div class="en">Code for Streptomycin 2 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String STREPTOMYCIN_2_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25205-6";

	/** 
	*<div class="en">Code for Streptomycin 4 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String STREPTOMYCIN_4_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="46719-1";

	/** 
	*<div class="en">Code for Streptomycin 6 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String STREPTOMYCIN_6_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25185-0";

	/** 
	*<div class="en">Code for Streptomycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String STREPTOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20462-8";

	/** 
	*<div class="en">Code for Sulfisoxazole 300 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String SULFISOXAZOLE_300_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25226-2";

	/** 
	*<div class="en">Code for Tobramycin 10 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String TOBRAMYCIN_10_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25227-0";

	/** 
	*<div class="en">Code for Tobramycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String TOBRAMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25800-4";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="22586-2";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Cerebral spinal fluid by Hemagglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_HEMAGGLUTINATION_CODE="50689-9";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="9826-9";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_CODE="22587-0";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum by Agglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_AGGLUTINATION_CODE="24312-1";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum by Hemagglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_HEMAGGLUTINATION_CODE="8041-6";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum by Immobilization</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_IMMOBILIZATION_CODE="17723-8";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="24110-9";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="57032-5";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="5393-4";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum from donor</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_FROM_DONOR_CODE="46206-9";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Presence] in Serum from donor by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOFLUORESCENCE_CODE="43238-5";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="51475-2";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Titer] in Cerebral spinal fluid by Hemagglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_HEMAGGLUTINATION_CODE="50695-6";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Titer] in Serum</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_CODE="22590-4";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Titer] in Serum by Hemagglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_CODE="26009-1";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="34382-2";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Titer] in Serum by Latex agglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5394-2";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Titer] in Serum or Plasma by Agglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_TITER_IN_SERUM_OR_PLASMA_BY_AGGLUTINATION_CODE="71793-4";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Blood</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_BLOOD_CODE="22585-4";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Blood by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_BLOOD_BY_IMMUNOFLUORESCENCE_CODE="13288-6";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Body fluid</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_BODY_FLUID_CODE="47511-1";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Body fluid by Hemagglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_BODY_FLUID_BY_HEMAGGLUTINATION_CODE="39015-3";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="51474-5";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Cerebral spinal fluid by Hemagglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_HEMAGGLUTINATION_CODE="49800-6";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Serum</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_CODE="11597-2";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Serum by Immobilization</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_IMMOBILIZATION_CODE="5392-6";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="63464-2";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Serum by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="17724-6";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Serum by Latex agglutination</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="17725-3";

	/** 
	*<div class="en">Code for Treponema pallidum Ab [Units/volume] in Unspecified specimen</div>
	*/
	public static final String TREPONEMA_PALLIDUM_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_CODE="41122-3";

	/** 
	*<div class="en">Code for Treponema pallidum DNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String TREPONEMA_PALLIDUM_DNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53605-2";

	/** 
	*<div class="en">Code for Treponema pallidum DNA [Presence] in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String TREPONEMA_PALLIDUM_DNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="49799-0";

	/** 
	*<div class="en">Code for Treponema pallidum DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String TREPONEMA_PALLIDUM_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41163-7";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="58031-6";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Presence] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="58751-9";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Presence] in Serum</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_CODE="6561-5";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="47238-1";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="40679-3";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="17726-1";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Presence] in Serum from donor</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_FROM_DONOR_CODE="47513-7";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Presence] in Serum from donor by Immunoassay</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_PRESENCE_IN_SERUM_FROM_DONOR_BY_IMMUNOASSAY_CODE="47361-1";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="47512-9";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Units/volume] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="47051-8";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="22592-0";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51838-1";

	/** 
	*<div class="en">Code for Treponema pallidum IgG Ab [Units/volume] in Serum by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="17727-9";

	/** 
	*<div class="en">Code for Treponema pallidum IgG+IgM Ab [Presence] in Serum</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_IGM_AB_PRESENCE_IN_SERUM_CODE="34147-9";

	/** 
	*<div class="en">Code for Treponema pallidum IgG+IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGG_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="47236-5";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Presence] in Cerebral spinal fluid by Immunoblot (IB)</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOBLOT_IB_CODE="69946-2";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Presence] in Serum</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_CODE="6562-3";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="47237-3";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Presence] in Serum by Immunoblot (IB)</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOBLOT_IB_CODE="40680-1";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="17729-5";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="47514-5";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Units/volume] in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="47063-3";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="22594-6";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="51839-9";

	/** 
	*<div class="en">Code for Treponema pallidum IgM Ab [Units/volume] in Serum by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="17728-7";

	/** 
	*<div class="en">Code for Treponema pallidum [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String TREPONEMA_PALLIDUM_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="29310-0";

	/** 
	*<div class="en">Code for Trichinella spiralis Ab [Presence] in Serum</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_AB_PRESENCE_IN_SERUM_CODE="22595-3";

	/** 
	*<div class="en">Code for Trichinella spiralis Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="19253-4";

	/** 
	*<div class="en">Code for Trichinella spiralis Ab [Presence] in Serum by Latex agglutination</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_AB_PRESENCE_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="17732-9";

	/** 
	*<div class="en">Code for Trichinella spiralis Ab [Titer] in Serum</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_AB_TITER_IN_SERUM_CODE="22596-1";

	/** 
	*<div class="en">Code for Trichinella spiralis Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="25993-7";

	/** 
	*<div class="en">Code for Trichinella spiralis Ab [Titer] in Serum by Latex agglutination</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_AB_TITER_IN_SERUM_BY_LATEX_AGGLUTINATION_CODE="5395-9";

	/** 
	*<div class="en">Code for Trichinella spiralis Ab [Units/volume] in Serum</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_AB_UNITSVOLUME_IN_SERUM_CODE="8042-4";

	/** 
	*<div class="en">Code for Trichinella spiralis Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="41426-8";

	/** 
	*<div class="en">Code for Trichinella spiralis IgA Ab [Presence] in Serum</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGA_AB_PRESENCE_IN_SERUM_CODE="17733-7";

	/** 
	*<div class="en">Code for Trichinella spiralis IgA Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGA_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="13922-0";

	/** 
	*<div class="en">Code for Trichinella spiralis IgG Ab [Presence] in Serum</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGG_AB_PRESENCE_IN_SERUM_CODE="8043-2";

	/** 
	*<div class="en">Code for Trichinella spiralis IgG Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="6563-1";

	/** 
	*<div class="en">Code for Trichinella spiralis IgG Ab [Titer] in Serum</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGG_AB_TITER_IN_SERUM_CODE="53387-7";

	/** 
	*<div class="en">Code for Trichinella spiralis IgG Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGG_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="52979-2";

	/** 
	*<div class="en">Code for Trichinella spiralis IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="17734-5";

	/** 
	*<div class="en">Code for Trichinella spiralis IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="25423-5";

	/** 
	*<div class="en">Code for Trichinella spiralis IgM Ab [Presence] in Serum</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGM_AB_PRESENCE_IN_SERUM_CODE="17735-2";

	/** 
	*<div class="en">Code for Trichinella spiralis IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="13923-8";

	/** 
	*<div class="en">Code for Trichinella spiralis [Presence] in Tissue by Light microscopy</div>
	*/
	public static final String TRICHINELLA_SPIRALIS_PRESENCE_IN_TISSUE_BY_LIGHT_MICROSCOPY_CODE="23499-7";

	/** 
	*<div class="en">Code for Trichinella sp Ab [Presence] in Serum</div>
	*/
	public static final String TRICHINELLA_SP_AB_PRESENCE_IN_SERUM_CODE="26661-9";

	/** 
	*<div class="en">Code for Trichinella sp IgA Ab [Units/volume] in Serum</div>
	*/
	public static final String TRICHINELLA_SP_IGA_AB_UNITSVOLUME_IN_SERUM_CODE="33587-7";

	/** 
	*<div class="en">Code for Trichinella sp IgG Ab [Presence] in Serum by Immunofluorescence</div>
	*/
	public static final String TRICHINELLA_SP_IGG_AB_PRESENCE_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="56992-1";

	/** 
	*<div class="en">Code for Trichinella sp IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String TRICHINELLA_SP_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="32768-4";

	/** 
	*<div class="en">Code for Trichinella sp IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String TRICHINELLA_SP_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="32723-9";

	/** 
	*<div class="en">Code for Trichinella sp IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String TRICHINELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="31687-7";

	/** 
	*<div class="en">Code for Trichinella sp IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String TRICHINELLA_SP_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="27426-6";

	/** 
	*<div class="en">Code for Trimethoprim+Sulfamethoxazole [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String TRIMETHOPRIM_SULFAMETHOXAZOLE_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="20387-7";

	/** 
	*<div class="en">Code for Trimethoprim [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String TRIMETHOPRIM_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23614-1";

	/** 
	*<div class="en">Code for Vaccinia virus Ab [Units/volume] in Serum</div>
	*/
	public static final String VACCINIA_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="5400-7";

	/** 
	*<div class="en">Code for Vaccinia virus DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String VACCINIA_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="35390-4";

	/** 
	*<div class="en">Code for Vancomycin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String VANCOMYCIN_30_UGML_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="25228-8";

	/** 
	*<div class="en">Code for Vancomycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String VANCOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23615-8";

	/** 
	*<div class="en">Code for Variola virus DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String VARIOLA_VIRUS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41856-6";

	/** 
	*<div class="en">Code for Vibrio cholerae</div>
	*/
	public static final String VIBRIO_CHOLERAE_CODE="75953000";

	/** 
	*<div class="en">Code for Vibrio cholerae DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String VIBRIO_CHOLERAE_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="61371-1";

	/** 
	*<div class="en">Code for Vibrio cholerae toxin Ag [Presence] in Isolate Qualitative</div>
	*/
	public static final String VIBRIO_CHOLERAE_TOXIN_AG_PRESENCE_IN_ISOLATE_QUALITATIVE_CODE="53941-1";

	/** 
	*<div class="en">Code for Vibrio cholerae toxin gene [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String VIBRIO_CHOLERAE_TOXIN_GENE_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="53942-9";

	/** 
	*<div class="en">Code for Vibrio sp identified in Stool by Organism specific culture</div>
	*/
	public static final String VIBRIO_SP_IDENTIFIED_IN_STOOL_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6579-7";

	/** 
	*<div class="en">Code for Vibrio sp identified in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String VIBRIO_SP_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="6581-3";

	/** 
	*<div class="en">Code for Viomycin [Susceptibility] by Method for Slow-growing mycobacteria</div>
	*/
	public static final String VIOMYCIN_SUSCEPTIBILITY_BY_METHOD_FOR_SLOW_GROWING_MYCOBACTERIA_CODE="23616-6";

	/** 
	*<div class="en">Code for Virus # 2 identified in Unspecified specimen by Culture</div>
	*/
	public static final String VIRUS_2_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="17975-4";

	/** 
	*<div class="en">Code for Virus # 3 identified in Unspecified specimen by Culture</div>
	*/
	public static final String VIRUS_3_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="17976-2";

	/** 
	*<div class="en">Code for Virus identified in Amniotic fluid by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_AMNIOTIC_FLUID_BY_CULTURE_CODE="11484-3";

	/** 
	*<div class="en">Code for Virus identified in Blood by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_BLOOD_BY_CULTURE_CODE="5883-4";

	/** 
	*<div class="en">Code for Virus identified in Blood by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_BLOOD_BY_IMMUNOFLUORESCENCE_CODE="14489-9";

	/** 
	*<div class="en">Code for Virus identified in Body fluid by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_BODY_FLUID_BY_CULTURE_CODE="40479-8";

	/** 
	*<div class="en">Code for Virus identified in Cerebral spinal fluid by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_CEREBRAL_SPINAL_FLUID_BY_CULTURE_CODE="5884-2";

	/** 
	*<div class="en">Code for Virus identified in Cerebral spinal fluid by Electron microscopy</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_CEREBRAL_SPINAL_FLUID_BY_ELECTRON_MICROSCOPY_CODE="10736-7";

	/** 
	*<div class="en">Code for Virus identified in Cerebral spinal fluid by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="14488-1";

	/** 
	*<div class="en">Code for Virus identified in Cervix by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_CERVIX_BY_CULTURE_CODE="14452-7";

	/** 
	*<div class="en">Code for Virus identified in Cervix by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_CERVIX_BY_IMMUNOFLUORESCENCE_CODE="14493-1";

	/** 
	*<div class="en">Code for Virus identified in Eye by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_EYE_BY_CULTURE_CODE="14451-9";

	/** 
	*<div class="en">Code for Virus identified in Eye by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_EYE_BY_IMMUNOFLUORESCENCE_CODE="14492-3";

	/** 
	*<div class="en">Code for Virus identified in Genital specimen by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_GENITAL_SPECIMEN_BY_CULTURE_CODE="40480-6";

	/** 
	*<div class="en">Code for Virus identified in Isolate</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_ISOLATE_CODE="42808-6";

	/** 
	*<div class="en">Code for Virus identified in Isolate by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_ISOLATE_BY_CULTURE_CODE="6608-4";

	/** 
	*<div class="en">Code for Virus identified in Isolate by Viral subtyping</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_ISOLATE_BY_VIRAL_SUBTYPING_CODE="615-5";

	/** 
	*<div class="en">Code for Virus identified in Lung tissue by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_LUNG_TISSUE_BY_CULTURE_CODE="72374-2";

	/** 
	*<div class="en">Code for Virus identified in Nasopharynx by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_NASOPHARYNX_BY_CULTURE_CODE="72373-4";

	/** 
	*<div class="en">Code for Virus identified in Nose by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_NOSE_BY_CULTURE_CODE="14454-3";

	/** 
	*<div class="en">Code for Virus identified in Penis by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_PENIS_BY_CULTURE_CODE="14459-2";

	/** 
	*<div class="en">Code for Virus identified in Penis by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_PENIS_BY_IMMUNOFLUORESCENCE_CODE="14497-2";

	/** 
	*<div class="en">Code for Virus identified in Peritoneal fluid by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_PERITONEAL_FLUID_BY_CULTURE_CODE="14456-8";

	/** 
	*<div class="en">Code for Virus identified in Pleural fluid by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_PLEURAL_FLUID_BY_CULTURE_CODE="14455-0";

	/** 
	*<div class="en">Code for Virus identified in Semen by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_SEMEN_BY_CULTURE_CODE="6583-9";

	/** 
	*<div class="en">Code for Virus identified in Semen by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_SEMEN_BY_IMMUNOFLUORESCENCE_CODE="14490-7";

	/** 
	*<div class="en">Code for Virus identified in Skin by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_SKIN_BY_CULTURE_CODE="5885-9";

	/** 
	*<div class="en">Code for Virus identified in Sputum by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_SPUTUM_BY_CULTURE_CODE="14458-4";

	/** 
	*<div class="en">Code for Virus identified in Sputum by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_SPUTUM_BY_IMMUNOFLUORESCENCE_CODE="14496-4";

	/** 
	*<div class="en">Code for Virus identified in Stool by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_STOOL_BY_CULTURE_CODE="5886-7";

	/** 
	*<div class="en">Code for Virus identified in Stool by Electron microscopy</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_STOOL_BY_ELECTRON_MICROSCOPY_CODE="10737-5";

	/** 
	*<div class="en">Code for Virus identified in Throat by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_THROAT_BY_CULTURE_CODE="5887-5";

	/** 
	*<div class="en">Code for Virus identified in Throat by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_THROAT_BY_IMMUNOFLUORESCENCE_CODE="14491-5";

	/** 
	*<div class="en">Code for Virus identified in Tissue by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_TISSUE_BY_CULTURE_CODE="5888-3";

	/** 
	*<div class="en">Code for Virus identified in Tissue by Electron microscopy</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_TISSUE_BY_ELECTRON_MICROSCOPY_CODE="10738-3";

	/** 
	*<div class="en">Code for Virus identified in Unspecified specimen</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_CODE="41461-5";

	/** 
	*<div class="en">Code for Virus identified in Unspecified specimen by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_CULTURE_CODE="6584-7";

	/** 
	*<div class="en">Code for Virus identified in Unspecified specimen by Electron microscopy</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_ELECTRON_MICROSCOPY_CODE="10739-1";

	/** 
	*<div class="en">Code for Virus identified in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="12272-1";

	/** 
	*<div class="en">Code for Virus identified in Unspecified specimen by Shell vial culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_UNSPECIFIED_SPECIMEN_BY_SHELL_VIAL_CULTURE_CODE="50024-9";

	/** 
	*<div class="en">Code for Virus identified in Urethra by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_URETHRA_BY_CULTURE_CODE="14460-0";

	/** 
	*<div class="en">Code for Virus identified in Urethra by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_URETHRA_BY_IMMUNOFLUORESCENCE_CODE="14498-0";

	/** 
	*<div class="en">Code for Virus identified in Urine by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_URINE_BY_CULTURE_CODE="14457-6";

	/** 
	*<div class="en">Code for Virus identified in Urine sediment by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_URINE_SEDIMENT_BY_IMMUNOFLUORESCENCE_CODE="14495-6";

	/** 
	*<div class="en">Code for Virus identified in Vaginal fluid by Culture</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_VAGINAL_FLUID_BY_CULTURE_CODE="14453-5";

	/** 
	*<div class="en">Code for Virus identified in Vaginal fluid by Immunofluorescence</div>
	*/
	public static final String VIRUS_IDENTIFIED_IN_VAGINAL_FLUID_BY_IMMUNOFLUORESCENCE_CODE="14494-9";

	/** 
	*<div class="en">Code for West Nile virus Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="41224-7";

	/** 
	*<div class="en">Code for West Nile virus Ab [Titer] in Cerebral spinal fluid by Neutralization test</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_NEUTRALIZATION_TEST_CODE="29570-9";

	/** 
	*<div class="en">Code for West Nile virus Ab [Titer] in Serum</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_TITER_IN_SERUM_CODE="41225-4";

	/** 
	*<div class="en">Code for West Nile virus Ab [Titer] in Serum by Hemagglutination inhibition</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_TITER_IN_SERUM_BY_HEMAGGLUTINATION_INHIBITION_CODE="55380-0";

	/** 
	*<div class="en">Code for West Nile virus Ab [Titer] in Serum by Neutralization test</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_TITER_IN_SERUM_BY_NEUTRALIZATION_TEST_CODE="29568-3";

	/** 
	*<div class="en">Code for West Nile virus Ab [Titer] in Unspecified specimen</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_TITER_IN_UNSPECIFIED_SPECIMEN_CODE="29781-2";

	/** 
	*<div class="en">Code for West Nile virus Ab [Titer] in Unspecified specimen by Neutralization test</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_TITER_IN_UNSPECIFIED_SPECIMEN_BY_NEUTRALIZATION_TEST_CODE="29779-6";

	/** 
	*<div class="en">Code for West Nile virus Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="41206-4";

	/** 
	*<div class="en">Code for West Nile virus Ab [Units/volume] in Serum</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="39555-8";

	/** 
	*<div class="en">Code for West Nile virus Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="41194-2";

	/** 
	*<div class="en">Code for West Nile virus Ab [Units/volume] in Unspecified specimen</div>
	*/
	public static final String WEST_NILE_VIRUS_AB_UNITSVOLUME_IN_UNSPECIFIED_SPECIMEN_CODE="31700-8";

	/** 
	*<div class="en">Code for West Nile virus Ag [Presence] in Blood or Marrow from donor</div>
	*/
	public static final String WEST_NILE_VIRUS_AG_PRESENCE_IN_BLOOD_OR_MARROW_FROM_DONOR_CODE="50015-7";

	/** 
	*<div class="en">Code for West Nile virus Ag [Presence] in Tissue by Immune stain</div>
	*/
	public static final String WEST_NILE_VIRUS_AG_PRESENCE_IN_TISSUE_BY_IMMUNE_STAIN_CODE="32371-7";

	/** 
	*<div class="en">Code for West Nile virus Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String WEST_NILE_VIRUS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="41643-8";

	/** 
	*<div class="en">Code for West Nile virus IgG Ab [Titer] in Body fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_IGG_AB_TITER_IN_BODY_FLUID_CODE="41196-7";

	/** 
	*<div class="en">Code for West Nile virus IgG Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_IGG_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="33328-6";

	/** 
	*<div class="en">Code for West Nile virus IgG Ab [Titer] in Serum</div>
	*/
	public static final String WEST_NILE_VIRUS_IGG_AB_TITER_IN_SERUM_CODE="33329-4";

	/** 
	*<div class="en">Code for West Nile virus IgG Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="29537-8";

	/** 
	*<div class="en">Code for West Nile virus IgG Ab [Units/volume] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGG_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="39572-3";

	/** 
	*<div class="en">Code for West Nile virus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String WEST_NILE_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="29535-2";

	/** 
	*<div class="en">Code for West Nile virus IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="38997-3";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Presence] in Body fluid by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_BODY_FLUID_BY_IMMUNOASSAY_CODE="62436-1";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Presence] in Cerebral spinal fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE="31703-2";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="29569-1";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Presence] in Serum</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="31704-0";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Presence] in Serum by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_SERUM_BY_IMMUNOASSAY_CODE="29567-5";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Presence] in Unspecified specimen</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="29780-4";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="29778-8";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="41642-0";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Titer] in Body fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_TITER_IN_BODY_FLUID_CODE="41195-9";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Titer] in Cerebral spinal fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_CODE="33330-2";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Titer] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="43342-5";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Titer] in Serum</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_TITER_IN_SERUM_CODE="33331-0";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="43343-3";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Units/volume] in Cerebral spinal fluid</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_CODE="29538-6";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Units/volume] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_UNITSVOLUME_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="39573-1";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="29536-0";

	/** 
	*<div class="en">Code for West Nile virus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="38166-5";

	/** 
	*<div class="en">Code for West Nile virus polyvalent E Ab [Presence] in Unspecified specimen</div>
	*/
	public static final String WEST_NILE_VIRUS_POLYVALENT_E_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_CODE="36900-9";

	/** 
	*<div class="en">Code for West Nile virus polyvalent E Ab [Presence] in Unspecified specimen by Immunoassay</div>
	*/
	public static final String WEST_NILE_VIRUS_POLYVALENT_E_AB_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOASSAY_CODE="36896-9";

	/** 
	*<div class="en">Code for West Nile virus RNA [Presence] in Blood by Probe and target amplification method</div>
	*/
	public static final String WEST_NILE_VIRUS_RNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="34460-6";

	/** 
	*<div class="en">Code for West Nile virus RNA [Presence] in Cerebral spinal fluid by Probe and target amplification method</div>
	*/
	public static final String WEST_NILE_VIRUS_RNA_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="34461-4";

	/** 
	*<div class="en">Code for West Nile virus RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String WEST_NILE_VIRUS_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="32361-8";

	/** 
	*<div class="en">Code for West Nile virus RNA [Presence] in Serum from donor by Probe and target amplification method</div>
	*/
	public static final String WEST_NILE_VIRUS_RNA_PRESENCE_IN_SERUM_FROM_DONOR_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="41212-2";

	/** 
	*<div class="en">Code for West Nile virus RNA [Presence] in Tissue by Probe and target amplification method</div>
	*/
	public static final String WEST_NILE_VIRUS_RNA_PRESENCE_IN_TISSUE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="32370-9";

	/** 
	*<div class="en">Code for West Nile virus RNA [Presence] in Unspecified specimen by DNA probe</div>
	*/
	public static final String WEST_NILE_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_DNA_PROBE_CODE="37985-9";

	/** 
	*<div class="en">Code for West Nile virus RNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String WEST_NILE_VIRUS_RNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="34892-0";

	/** 
	*<div class="en">Code for Yellow fever virus Ab [Titer] in Cerebral spinal fluid by Neutralization test</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_AB_TITER_IN_CEREBRAL_SPINAL_FLUID_BY_NEUTRALIZATION_TEST_CODE="71783-5";

	/** 
	*<div class="en">Code for Yellow fever virus Ab [Titer] in Serum</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_AB_TITER_IN_SERUM_CODE="22618-3";

	/** 
	*<div class="en">Code for Yellow fever virus Ab [Titer] in Serum --1st specimen</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_AB_TITER_IN_SERUM_1ST_SPECIMEN_CODE="41247-8";

	/** 
	*<div class="en">Code for Yellow fever virus Ab [Titer] in Serum --2nd specimen</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_AB_TITER_IN_SERUM_2ND_SPECIMEN_CODE="41246-0";

	/** 
	*<div class="en">Code for Yellow fever virus Ab [Titer] in Serum by Immunofluorescence</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_AB_TITER_IN_SERUM_BY_IMMUNOFLUORESCENCE_CODE="6589-6";

	/** 
	*<div class="en">Code for Yellow fever virus Ab [Units/volume] in Serum</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_AB_UNITSVOLUME_IN_SERUM_CODE="8054-9";

	/** 
	*<div class="en">Code for Yellow fever virus Ab [Units/volume] in Serum by Neutralization test</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_AB_UNITSVOLUME_IN_SERUM_BY_NEUTRALIZATION_TEST_CODE="6591-2";

	/** 
	*<div class="en">Code for Yellow fever virus IgG Ab [Units/volume] in Serum</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_CODE="8055-6";

	/** 
	*<div class="en">Code for Yellow fever virus IgG Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_IGG_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="6592-0";

	/** 
	*<div class="en">Code for Yellow fever virus IgM Ab [Presence] in Cerebral spinal fluid by Immunoassay</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_IGM_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_BY_IMMUNOASSAY_CODE="71782-7";

	/** 
	*<div class="en">Code for Yellow fever virus IgM Ab [Presence] in Serum</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE="41216-3";

	/** 
	*<div class="en">Code for Yellow fever virus IgM Ab [Units/volume] in Serum</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_CODE="8056-4";

	/** 
	*<div class="en">Code for Yellow fever virus IgM Ab [Units/volume] in Serum by Immunoassay</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_IGM_AB_UNITSVOLUME_IN_SERUM_BY_IMMUNOASSAY_CODE="6593-8";

	/** 
	*<div class="en">Code for Yellow fever virus RNA [Presence] in Serum by Probe and target amplification method</div>
	*/
	public static final String YELLOW_FEVER_VIRUS_RNA_PRESENCE_IN_SERUM_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="8057-2";

	/** 
	*<div class="en">Code for Yersinia pestis Ab [Titer] in Serum</div>
	*/
	public static final String YERSINIA_PESTIS_AB_TITER_IN_SERUM_CODE="33707-1";

	/** 
	*<div class="en">Code for Yersinia pestis Ab [Titer] in Serum by Immunoassay</div>
	*/
	public static final String YERSINIA_PESTIS_AB_TITER_IN_SERUM_BY_IMMUNOASSAY_CODE="33690-9";

	/** 
	*<div class="en">Code for Yersinia pestis Ag [Presence] in Isolate by Immunofluorescence</div>
	*/
	public static final String YERSINIA_PESTIS_AG_PRESENCE_IN_ISOLATE_BY_IMMUNOFLUORESCENCE_CODE="33688-3";

	/** 
	*<div class="en">Code for Yersinia pestis Ag [Presence] in Unspecified specimen by Immunofluorescence</div>
	*/
	public static final String YERSINIA_PESTIS_AG_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_IMMUNOFLUORESCENCE_CODE="33687-5";

	/** 
	*<div class="en">Code for Yersinia pestis DNA [Presence] in Isolate by Probe and target amplification method</div>
	*/
	public static final String YERSINIA_PESTIS_DNA_PRESENCE_IN_ISOLATE_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="33692-5";

	/** 
	*<div class="en">Code for Yersinia pestis DNA [Presence] in Unspecified specimen by Probe and target amplification method</div>
	*/
	public static final String YERSINIA_PESTIS_DNA_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE="33691-7";

	/** 
	*<div class="en">Code for Yersinia pestis [Presence] in Isolate by Organism specific culture</div>
	*/
	public static final String YERSINIA_PESTIS_PRESENCE_IN_ISOLATE_BY_ORGANISM_SPECIFIC_CULTURE_CODE="33686-7";

	/** 
	*<div class="en">Code for Yersinia pestis [Presence] in Isolate by Phage lysis</div>
	*/
	public static final String YERSINIA_PESTIS_PRESENCE_IN_ISOLATE_BY_PHAGE_LYSIS_CODE="33693-3";

	/** 
	*<div class="en">Code for Yersinia pestis [Presence] in Unspecified specimen by Organism specific culture</div>
	*/
	public static final String YERSINIA_PESTIS_PRESENCE_IN_UNSPECIFIED_SPECIMEN_BY_ORGANISM_SPECIFIC_CULTURE_CODE="33685-9";



	/**
	* <div class="en">Identifier of the Code System</div>
	* <div class="de">Identifikator für das Code System</div>
	*/
	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.127.3.2.20121101.1";

	/**
	* <div class="en">Name of the Code System</div>
	* <div class="de">Name des Codes Systems</div>
	*/
	public static final String CODE_SYSTEM_NAME="LabReportListLoinc";


	/**
	* <div class="en">Machine interpretable and (inside this class) unique code</div>
	* <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	*/
	protected String code;

	/**
	* <div class="en">Human readable name</div>
	* <div class="de">Menschenlesbarer Name</div>
	*/
	protected String displayName;

	/**
	* <div class="en">The Patient privacy filter is used to determine the anonymisation or pseudonymisation mode for the patient data.</div>
	* <div class="de">Der Patient Privacy Filter wird verwendet, um die Art der Anonymisierung oder Pseudonymisierung der Patientendaten zu bestimmen</div>
	*/
	protected String patientPrivacyFilter;

	/**
	* <div class="en">Section code for this Element</div>
	* <div class="de">Section Code für dieses Element</div>
	*/
	protected String sectionCode;

	/**
	* <div class="en">Start date for the period in which this element can be used</div>
	* <div class="de">Startdatum der Periode, innerhalb derer dieses Element valide ist</div>
	*/
	protected Date validFrom;

	/**
	* <div class="en">End date for the period in which this element can be used</div>
	* <div class="de">Enddatum der Periode, innerhalb derer dieses Element valide ist</div>
	*/
	protected Date validTo;
	
	/**
	* <div class="en">Instantiates this Enum Object with given code, displayName, specialitySectionCode, privacyFilter, validFrom and validTo parameters</div>
	* <div class="de">Instantiiert dieses Enum Object mittels der code, displayName, specialitySectionCode, privacyFilter, validFrom und validTo Parameter</div>
	*
	* @param code <br>
	*	<div class="en">the code</div>
	* @param displayName <br>
	*	<div class="en">the display name</div>
	* @param sectionCode <br>
	*	<div class="en">the specialty section code</div>
	* @param patientPrivacyFilter <br>
	*	<div class="en">the patient privacy filter</div>
	* @param validFrom <br>
	*<div class="en">the valid from</div>
	* @param validTo <br>
	*<div class="en">the valid to</div>
	*/
	private LabObsListLoinc(String code, String displayName, String sectionCode, String patientPrivacyFilter, String validFrom, String validTo) {
		this.code = code;
		this.displayName = displayName;
		this.sectionCode = sectionCode;
		this.patientPrivacyFilter = patientPrivacyFilter;
			if (validFrom != null && !"".equals(validFrom)) {
		this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
				if (validFrom != null && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
	}

	/**
	* <div class="en">Gets the ehealthconnector Code Object</div>
	* <div class="de">Liefert das ehealthconnector Code Objekt</div>
	*
	* @return <div class="en">the code</div>
	*/
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
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
		return cd;
	}

	/**
	* <div class="en">Gets the code system name.</div>
	* <div class="de">Liefert code system name.</div>
	*
	* @return <div class="en">the code system name</div>
	*/
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	* <div class="en">Gets the code system id.</div>
	* <div class="de">Liefert die code system id.</div>
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
	* <div class="en">Gets the display name.</div>
	* <div class="de">Liefert display name.</div>
	*
	* @return <div class="en">the display name</div>
	*/
	public String getDisplayName() {
		return this.displayName;
	}
 
	/**
	* <div class="en">Gets the Enum with a given code</div>
	* <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	*
	* @param code <br>
	*      <div class="de"> code</div>
	* @return <div class="en">the enum</div>
	*/
	public static LabObsListLoinc getEnum(String code) {
		for (LabObsListLoinc x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
  
	/**
	* <div class="en">Checks if a given enum is part of this value set.</div>
	* <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets ist.</div>
	*
	*
	* @param enumName <br>
	*      <div class="de"> enumName</div>
	* @return true, if enum is in this value set
	*/
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(LabObsListLoinc.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}


	/**
	* <div class="en">Checks if a given code value is in this value set.</div>
	* <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden ist.</div>
	*
	* @param codeValue <br>
	*      <div class="de"> code</div>
	* @return true, if is in value set
	*/
	public static boolean isInValueSet(String codeValue) {
		for (LabObsListLoinc x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Gets the section code</div>
	 * <div class="de">Liefert section code</div>
	 * 
	 * @return the section code
	 */
	public String getSectionCode() {
		return this.sectionCode;
	}

	/**
	 * <div class="en">Gets the patient privacy filter</div>
	 * <div class="de">Liefert patient privacy filter</div>
	 * 
	 * @return the patient privacy filter
	 */
	public String getPatientPrivacyFilter() {
		return this.patientPrivacyFilter;
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
	 *            the date
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