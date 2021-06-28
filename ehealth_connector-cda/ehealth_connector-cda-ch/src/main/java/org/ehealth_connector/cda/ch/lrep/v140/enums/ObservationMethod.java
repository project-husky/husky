/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.cda.ch.lrep.v140.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en"><p>    <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>A code that provides additional detail about the means or technique used to ascertain the observation.</p><p>    <i>Examples:</i> Blood pressure measurement method: arterial puncture vs. sphygmomanometer (Riva-Rocci), sitting vs. supine position, etc.</p><p>    <i>Constraints:</i> In all observations the method is already partially specified by the Act.code. In this case, the methodCode NEED NOT be used at all. The methodCode MAY still be used to identify this method more clearly in addition to what is implied from the Act.code. However, an information consumer system or process SHOULD NOT depend on this methodCode information for method detail that is implied by the Act.code.</p><p>If the methodCode is used to express method detail that is also implied by the Act.code, the methodCode MUST NOT be in conflict with the implied method of the Act.code.</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ObservationMethod implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Acid fast stain</div>
	 * <!-- @formatter:on -->
	 */
	ACID_FAST_STAIN("0143", "2.16.840.1.113883.5.84", "Acid fast stain", "Acid fast stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Acid fast stain, fluorochrome</div>
	 * <!-- @formatter:on -->
	 */
	ACID_FAST_STAIN_FLUOROCHROME("0144", "2.16.840.1.113883.5.84", "Acid fast stain, fluorochrome",
			"Acid fast stain, fluorochrome", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Acid fast stain, Kinyoun's cold carbolfuchsin</div>
	 * <!-- @formatter:on -->
	 */
	ACID_FAST_STAIN_KINYOUN_S_COLD_CARBOLFUCHSIN("0145", "2.16.840.1.113883.5.84",
			"Acid fast stain, Kinyoun's cold carbolfuchsin",
			"Acid fast stain, Kinyoun's cold carbolfuchsin", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Acid fast stain, Ziehl-Neelsen</div>
	 * <!-- @formatter:on -->
	 */
	ACID_FAST_STAIN_ZIEHL_NEELSEN("0146", "2.16.840.1.113883.5.84",
			"Acid fast stain, Ziehl-Neelsen", "Acid fast stain, Ziehl-Neelsen", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Acid phosphatase stain</div>
	 * <!-- @formatter:on -->
	 */
	ACID_PHOSPHATASE_STAIN("0147", "2.16.840.1.113883.5.84", "Acid phosphatase stain",
			"Acid phosphatase stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Acridine orange stain</div>
	 * <!-- @formatter:on -->
	 */
	ACRIDINE_ORANGE_STAIN("0148", "2.16.840.1.113883.5.84", "Acridine orange stain",
			"Acridine orange stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Active brilliant orange KH stain</div>
	 * <!-- @formatter:on -->
	 */
	ACTIVE_BRILLIANT_ORANGE_KH_STAIN("0149", "2.16.840.1.113883.5.84",
			"Active brilliant orange KH stain", "Active brilliant orange KH stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Aerobic Culture</div>
	 * <!-- @formatter:on -->
	 */
	AEROBIC_CULTURE("0050", "2.16.840.1.113883.5.84", "Aerobic Culture", "Aerobic Culture",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Affinity chromatography</div>
	 * <!-- @formatter:on -->
	 */
	AFFINITY_CHROMATOGRAPHY("0039", "2.16.840.1.113883.5.84", "Affinity chromatography",
			"Affinity chromatography", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Agaorse gel electrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	AGAORSE_GEL_ELECTROPHORESIS("0065", "2.16.840.1.113883.5.84", "Agaorse gel electrophoresis",
			"Agaorse gel electrophoresis", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Agar diffusion</div>
	 * <!-- @formatter:on -->
	 */
	AGAR_DIFFUSION("0062", "2.16.840.1.113883.5.84", "Agar diffusion", "Agar diffusion",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Agar Gel Immunodiffusion</div>
	 * <!-- @formatter:on -->
	 */
	AGAR_GEL_IMMUNODIFFUSION("0063", "2.16.840.1.113883.5.84", "Agar Gel Immunodiffusion",
			"Agar Gel Immunodiffusion", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Agar screen</div>
	 * <!-- @formatter:on -->
	 */
	AGAR_SCREEN_L1("0278", "2.16.840.1.113883.5.84", "Agar screen", "Agar screen", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Agglutination</div>
	 * <!-- @formatter:on -->
	 */
	AGGLUTINATION("0014", "2.16.840.1.113883.5.84", "Agglutination", "Agglutination", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Alazarin red S stain</div>
	 * <!-- @formatter:on -->
	 */
	ALAZARIN_RED_S_STAIN("0150", "2.16.840.1.113883.5.84", "Alazarin red S stain",
			"Alazarin red S stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Alcian blue stain</div>
	 * <!-- @formatter:on -->
	 */
	ALCIAN_BLUE_STAIN("0151", "2.16.840.1.113883.5.84", "Alcian blue stain", "Alcian blue stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Alcian blue with Periodic acid Schiff stain</div>
	 * <!-- @formatter:on -->
	 */
	ALCIAN_BLUE_WITH_PERIODIC_ACID_SCHIFF_STAIN("0152", "2.16.840.1.113883.5.84",
			"Alcian blue with Periodic acid Schiff stain",
			"Alcian blue with Periodic acid Schiff stain", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">algorithm</div>
	 * <!-- @formatter:on -->
	 */
	ALGORITHM("ALGM", "2.16.840.1.113883.5.84", "algorithm", "algorithm", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">algorithm</div>
	 * <!-- @formatter:on -->
	 */
	ALGORITHM_L1("ALGM", "2.16.840.1.113883.5.84", "algorithm", "algorithm", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Anaerobic Culture</div>
	 * <!-- @formatter:on -->
	 */
	ANAEROBIC_CULTURE("0051", "2.16.840.1.113883.5.84", "Anaerobic Culture", "Anaerobic Culture",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Animal Inoculation</div>
	 * <!-- @formatter:on -->
	 */
	ANIMAL_INOCULATION("0026", "2.16.840.1.113883.5.84", "Animal Inoculation", "Animal Inoculation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Antibiotic sensitivity, disk</div>
	 * <!-- @formatter:on -->
	 */
	ANTIBIOTIC_SENSITIVITY_DISK("0240", "2.16.840.1.113883.5.84", "Antibiotic sensitivity, disk",
			"Antibiotic sensitivity, disk", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Antibiotic sensitivity, disk</div>
	 * <!-- @formatter:on -->
	 */
	ANTIBIOTIC_SENSITIVITY_DISK_L1("0240", "2.16.840.1.113883.5.84", "Antibiotic sensitivity, disk",
			"Antibiotic sensitivity, disk", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Anti-complement immunofluorescence (ACIF)</div>
	 * <!-- @formatter:on -->
	 */
	ANTI_COMPLEMENT_IMMUNOFLUORESCENCE_ACIF("0257", "2.16.840.1.113883.5.84",
			"Anti-complement immunofluorescence (ACIF)",
			"Anti-complement immunofluorescence (ACIF)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API 20A</div>
	 * <!-- @formatter:on -->
	 */
	API_20A("0076", "2.16.840.1.113883.5.84", "API 20A", "API 20A", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API 20C AUX</div>
	 * <!-- @formatter:on -->
	 */
	API_20C_AUX("0077", "2.16.840.1.113883.5.84", "API 20C AUX", "API 20C AUX", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API 20E</div>
	 * <!-- @formatter:on -->
	 */
	API_20E("0078", "2.16.840.1.113883.5.84", "API 20E", "API 20E", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API 20NE</div>
	 * <!-- @formatter:on -->
	 */
	API_20NE("0079", "2.16.840.1.113883.5.84", "API 20NE", "API 20NE", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API 20 Strep</div>
	 * <!-- @formatter:on -->
	 */
	API_20_STREP("0075", "2.16.840.1.113883.5.84", "API 20 Strep", "API 20 Strep", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API 50 CH</div>
	 * <!-- @formatter:on -->
	 */
	API_50_CH("0080", "2.16.840.1.113883.5.84", "API 50 CH", "API 50 CH", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API An-IDENT</div>
	 * <!-- @formatter:on -->
	 */
	API_AN_IDENT("0081", "2.16.840.1.113883.5.84", "API An-IDENT", "API An-IDENT", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API Coryne</div>
	 * <!-- @formatter:on -->
	 */
	API_CORYNE("0082", "2.16.840.1.113883.5.84", "API Coryne", "API Coryne", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API Rapid 20E</div>
	 * <!-- @formatter:on -->
	 */
	API_RAPID_20E("0083", "2.16.840.1.113883.5.84", "API Rapid 20E", "API Rapid 20E", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API Staph</div>
	 * <!-- @formatter:on -->
	 */
	API_STAPH("0084", "2.16.840.1.113883.5.84", "API Staph", "API Staph", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">API ZYM</div>
	 * <!-- @formatter:on -->
	 */
	API_ZYM("0085", "2.16.840.1.113883.5.84", "API ZYM", "API ZYM", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Argentaffin silver stain</div>
	 * <!-- @formatter:on -->
	 */
	ARGENTAFFIN_SILVER_STAIN("0154", "2.16.840.1.113883.5.84", "Argentaffin silver stain",
			"Argentaffin silver stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Argentaffin stain</div>
	 * <!-- @formatter:on -->
	 */
	ARGENTAFFIN_STAIN("0153", "2.16.840.1.113883.5.84", "Argentaffin stain", "Argentaffin stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Atomic absorption spectrophotometry (AAS)</div>
	 * <!-- @formatter:on -->
	 */
	ATOMIC_ABSORPTION_SPECTROPHOTOMETRY_AAS("0263", "2.16.840.1.113883.5.84",
			"Atomic absorption spectrophotometry (AAS)",
			"Atomic absorption spectrophotometry (AAS)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Automated count</div>
	 * <!-- @formatter:on -->
	 */
	AUTOMATED_COUNT("0047", "2.16.840.1.113883.5.84", "Automated count", "Automated count",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Azure-eosin stain</div>
	 * <!-- @formatter:on -->
	 */
	AZURE_EOSIN_STAIN("0155", "2.16.840.1.113883.5.84", "Azure-eosin stain", "Azure-eosin stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BACTEC susceptibility test</div>
	 * <!-- @formatter:on -->
	 */
	BACTEC_SUSCEPTIBILITY_TEST("0241", "2.16.840.1.113883.5.84", "BACTEC susceptibility test",
			"BACTEC susceptibility test", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BACTEC susceptibility test</div>
	 * <!-- @formatter:on -->
	 */
	BACTEC_SUSCEPTIBILITY_TEST_L1("0241", "2.16.840.1.113883.5.84", "BACTEC susceptibility test",
			"BACTEC susceptibility test", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bacterial identification</div>
	 * <!-- @formatter:on -->
	 */
	BACTERIAL_IDENTIFICATION("0086", "2.16.840.1.113883.5.84", "Bacterial identification",
			"Bacterial identification", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Basic Fuschin stain</div>
	 * <!-- @formatter:on -->
	 */
	BASIC_FUSCHIN_STAIN("0156", "2.16.840.1.113883.5.84", "Basic Fuschin stain",
			"Basic Fuschin stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">bayesian calculation</div>
	 * <!-- @formatter:on -->
	 */
	BAYESIAN_CALCULATION("BYCL", "2.16.840.1.113883.5.84", "bayesian calculation",
			"bayesian calculation", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">bayesian calculation</div>
	 * <!-- @formatter:on -->
	 */
	BAYESIAN_CALCULATION_L2("BYCL", "2.16.840.1.113883.5.84", "bayesian calculation",
			"bayesian calculation", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bennhold stain</div>
	 * <!-- @formatter:on -->
	 */
	BENNHOLD_STAIN("0157", "2.16.840.1.113883.5.84", "Bennhold stain", "Bennhold stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bennhold's Congo red stain</div>
	 * <!-- @formatter:on -->
	 */
	BENNHOLD_S_CONGO_RED_STAIN("0158", "2.16.840.1.113883.5.84", "Bennhold's Congo red stain",
			"Bennhold's Congo red stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bielschowsky stain</div>
	 * <!-- @formatter:on -->
	 */
	BIELSCHOWSKY_STAIN("0159", "2.16.840.1.113883.5.84", "Bielschowsky stain", "Bielschowsky stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bielschowsky's silver stain</div>
	 * <!-- @formatter:on -->
	 */
	BIELSCHOWSKY_S_SILVER_STAIN("0160", "2.16.840.1.113883.5.84", "Bielschowsky's silver stain",
			"Bielschowsky's silver stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bioassay</div>
	 * <!-- @formatter:on -->
	 */
	BIOASSAY("0025", "2.16.840.1.113883.5.84", "Bioassay", "Bioassay", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bioassay, qualitative</div>
	 * <!-- @formatter:on -->
	 */
	BIOASSAY_QUALITATIVE("0031", "2.16.840.1.113883.5.84", "Bioassay, qualitative",
			"Bioassay, qualitative", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bioassay, quantitative</div>
	 * <!-- @formatter:on -->
	 */
	BIOASSAY_QUANTITATIVE("0032", "2.16.840.1.113883.5.84", "Bioassay, quantitative",
			"Bioassay, quantitative", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bleach stain</div>
	 * <!-- @formatter:on -->
	 */
	BLEACH_STAIN("0161", "2.16.840.1.113883.5.84", "Bleach stain", "Bleach stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bodian stain</div>
	 * <!-- @formatter:on -->
	 */
	BODIAN_STAIN("0162", "2.16.840.1.113883.5.84", "Bodian stain", "Bodian stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Branched Chain DNA</div>
	 * <!-- @formatter:on -->
	 */
	BRANCHED_CHAIN_DNA("0120", "2.16.840.1.113883.5.84", "Branched Chain DNA", "Branched Chain DNA",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Brown-Brenn stain</div>
	 * <!-- @formatter:on -->
	 */
	BROWN_BRENN_STAIN("0163", "2.16.840.1.113883.5.84", "Brown-Brenn stain", "Brown-Brenn stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Buffered acidified plate agglutination</div>
	 * <!-- @formatter:on -->
	 */
	BUFFERED_ACIDIFIED_PLATE_AGGLUTINATION("0015", "2.16.840.1.113883.5.84",
			"Buffered acidified plate agglutination", "Buffered acidified plate agglutination",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Butyrate-esterase stain</div>
	 * <!-- @formatter:on -->
	 */
	BUTYRATE_ESTERASE_STAIN("0164", "2.16.840.1.113883.5.84", "Butyrate-esterase stain",
			"Butyrate-esterase stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Calcofluor white fluorescent stain</div>
	 * <!-- @formatter:on -->
	 */
	CALCOFLUOR_WHITE_FLUORESCENT_STAIN("0165", "2.16.840.1.113883.5.84",
			"Calcofluor white fluorescent stain", "Calcofluor white fluorescent stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Carbol-fuchsin stain</div>
	 * <!-- @formatter:on -->
	 */
	CARBOL_FUCHSIN_STAIN("0166", "2.16.840.1.113883.5.84", "Carbol-fuchsin stain",
			"Carbol-fuchsin stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Card agglutination</div>
	 * <!-- @formatter:on -->
	 */
	CARD_AGGLUTINATION("0016", "2.16.840.1.113883.5.84", "Card agglutination", "Card agglutination",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Carmine stain</div>
	 * <!-- @formatter:on -->
	 */
	CARMINE_STAIN("0167", "2.16.840.1.113883.5.84", "Carmine stain", "Carmine stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chemical method</div>
	 * <!-- @formatter:on -->
	 */
	CHEMICAL_METHOD("0033", "2.16.840.1.113883.5.84", "Chemical method", "Chemical method",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chicken embryo culture</div>
	 * <!-- @formatter:on -->
	 */
	CHICKEN_EMBRYO_CULTURE("0052", "2.16.840.1.113883.5.84", "Chicken embryo culture",
			"Chicken embryo culture", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chromatography</div>
	 * <!-- @formatter:on -->
	 */
	CHROMATOGRAPHY("0038", "2.16.840.1.113883.5.84", "Chromatography", "Chromatography",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Churukian-Schenk stain</div>
	 * <!-- @formatter:on -->
	 */
	CHURUKIAN_SCHENK_STAIN("0168", "2.16.840.1.113883.5.84", "Churukian-Schenk stain",
			"Churukian-Schenk stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Coagulation</div>
	 * <!-- @formatter:on -->
	 */
	COAGULATION("0044", "2.16.840.1.113883.5.84", "Coagulation", "Coagulation", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Complement fixation</div>
	 * <!-- @formatter:on -->
	 */
	COMPLEMENT_FIXATION("0001", "2.16.840.1.113883.5.84", "Complement fixation",
			"Complement fixation", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Computed axial tomography</div>
	 * <!-- @formatter:on -->
	 */
	COMPUTED_AXIAL_TOMOGRAPHY("0002", "2.16.840.1.113883.5.84", "Computed axial tomography",
			"Computed axial tomography", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Congo red stain</div>
	 * <!-- @formatter:on -->
	 */
	CONGO_RED_STAIN("0169", "2.16.840.1.113883.5.84", "Congo red stain", "Congo red stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cresyl echt violet stain</div>
	 * <!-- @formatter:on -->
	 */
	CRESYL_ECHT_VIOLET_STAIN("0170", "2.16.840.1.113883.5.84", "Cresyl echt violet stain",
			"Cresyl echt violet stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Crystal violet stain</div>
	 * <!-- @formatter:on -->
	 */
	CRYSTAL_VIOLET_STAIN("0171", "2.16.840.1.113883.5.84", "Crystal violet stain",
			"Crystal violet stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cytotoxicity</div>
	 * <!-- @formatter:on -->
	 */
	CYTOTOXICITY("0027", "2.16.840.1.113883.5.84", "Cytotoxicity", "Cytotoxicity", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Darkfield microscopy</div>
	 * <!-- @formatter:on -->
	 */
	DARKFIELD_MICROSCOPY("0108", "2.16.840.1.113883.5.84", "Darkfield microscopy",
			"Darkfield microscopy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Delayed secondary enrichment</div>
	 * <!-- @formatter:on -->
	 */
	DELAYED_SECONDARY_ENRICHMENT("0053", "2.16.840.1.113883.5.84", "Delayed secondary enrichment",
			"Delayed secondary enrichment", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">De Galantha stain</div>
	 * <!-- @formatter:on -->
	 */
	DE_GALANTHA_STAIN("0172", "2.16.840.1.113883.5.84", "De Galantha stain", "De Galantha stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dieterle silver impregnation stain</div>
	 * <!-- @formatter:on -->
	 */
	DIETERLE_SILVER_IMPREGNATION_STAIN("0173", "2.16.840.1.113883.5.84",
			"Dieterle silver impregnation stain", "Dieterle silver impregnation stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Differential light absorption chemical test</div>
	 * <!-- @formatter:on -->
	 */
	DIFFERENTIAL_LIGHT_ABSORPTION_CHEMICAL_TEST("0034", "2.16.840.1.113883.5.84",
			"Differential light absorption chemical test",
			"Differential light absorption chemical test", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dipstick</div>
	 * <!-- @formatter:on -->
	 */
	DIPSTICK("0035", "2.16.840.1.113883.5.84", "Dipstick", "Dipstick", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dipstick colorimetric laboratory test</div>
	 * <!-- @formatter:on -->
	 */
	DIPSTICK_COLORIMETRIC_LABORATORY_TEST("0036", "2.16.840.1.113883.5.84",
			"Dipstick colorimetric laboratory test", "Dipstick colorimetric laboratory test",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Disk dilution</div>
	 * <!-- @formatter:on -->
	 */
	DISK_DILUTION("0242", "2.16.840.1.113883.5.84", "Disk dilution", "Disk dilution", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Disk dilution</div>
	 * <!-- @formatter:on -->
	 */
	DISK_DILUTION_L1("0242", "2.16.840.1.113883.5.84", "Disk dilution", "Disk dilution",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Disk induction</div>
	 * <!-- @formatter:on -->
	 */
	DISK_INDUCTION_L1("0279", "2.16.840.1.113883.5.84", "Disk induction", "Disk induction",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">document verification</div>
	 * <!-- @formatter:on -->
	 */
	DOCUMENT_VERIFICATION_L1("VDOC", "2.16.840.1.113883.5.84", "document verification",
			"document verification", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">electronic token verification</div>
	 * <!-- @formatter:on -->
	 */
	ELECTRONIC_TOKEN_VERIFICATION_L1("VTOKEN", "2.16.840.1.113883.5.84",
			"electronic token verification", "electronic token verification", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electron microscopy</div>
	 * <!-- @formatter:on -->
	 */
	ELECTRON_MICROSCOPY("0109", "2.16.840.1.113883.5.84", "Electron microscopy",
			"Electron microscopy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electron microscopy, negative stain</div>
	 * <!-- @formatter:on -->
	 */
	ELECTRON_MICROSCOPY_NEGATIVE_STAIN("0111", "2.16.840.1.113883.5.84",
			"Electron microscopy, negative stain", "Electron microscopy, negative stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electron microscopy, thick section</div>
	 * <!-- @formatter:on -->
	 */
	ELECTRON_MICROSCOPY_THICK_SECTION("0112", "2.16.840.1.113883.5.84",
			"Electron microscopy, thick section", "Electron microscopy, thick section",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electron microscopy, thin section</div>
	 * <!-- @formatter:on -->
	 */
	ELECTRON_MICROSCOPY_THIN_SECTION("0113", "2.16.840.1.113883.5.84",
			"Electron microscopy, thin section", "Electron microscopy, thin section", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electron microscopy tomography</div>
	 * <!-- @formatter:on -->
	 */
	ELECTRON_MICROSCOPY_TOMOGRAPHY("0110", "2.16.840.1.113883.5.84",
			"Electron microscopy tomography", "Electron microscopy tomography", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	ELECTROPHORESIS("0064", "2.16.840.1.113883.5.84", "Electrophoresis", "Electrophoresis",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electrophoresis, citrate agar</div>
	 * <!-- @formatter:on -->
	 */
	ELECTROPHORESIS_CITRATE_AGAR("0066", "2.16.840.1.113883.5.84", "Electrophoresis, citrate agar",
			"Electrophoresis, citrate agar", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ELISA</div>
	 * <!-- @formatter:on -->
	 */
	ELISA("0070", "2.16.840.1.113883.5.84", "ELISA", "ELISA", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ELISA, antigen capture</div>
	 * <!-- @formatter:on -->
	 */
	ELISA_ANTIGEN_CAPTURE("0071", "2.16.840.1.113883.5.84", "ELISA, antigen capture",
			"ELISA, antigen capture", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ELISA, avidin biotin peroxidase complex</div>
	 * <!-- @formatter:on -->
	 */
	ELISA_AVIDIN_BIOTIN_PEROXIDASE_COMPLEX("0072", "2.16.840.1.113883.5.84",
			"ELISA, avidin biotin peroxidase complex", "ELISA, avidin biotin peroxidase complex",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ELISA, peroxidase-antiperoxidase</div>
	 * <!-- @formatter:on -->
	 */
	ELISA_PEROXIDASE_ANTIPEROXIDASE("0074", "2.16.840.1.113883.5.84",
			"ELISA, peroxidase-antiperoxidase", "ELISA, peroxidase-antiperoxidase", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Embryo infective dose 50</div>
	 * <!-- @formatter:on -->
	 */
	EMBRYO_INFECTIVE_DOSE_50("0028", "2.16.840.1.113883.5.84", "Embryo infective dose 50",
			"Embryo infective dose 50", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Embryo lethal dose 50</div>
	 * <!-- @formatter:on -->
	 */
	EMBRYO_LETHAL_DOSE_50("0029", "2.16.840.1.113883.5.84", "Embryo lethal dose 50",
			"Embryo lethal dose 50", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">EMIT</div>
	 * <!-- @formatter:on -->
	 */
	EMIT("0250", "2.16.840.1.113883.5.84", "EMIT", "EMIT", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Equilibrium dialysis</div>
	 * <!-- @formatter:on -->
	 */
	EQUILIBRIUM_DIALYSIS("0255", "2.16.840.1.113883.5.84", "Equilibrium dialysis",
			"Equilibrium dialysis", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Fite-Farco stain</div>
	 * <!-- @formatter:on -->
	 */
	FITE_FARCO_STAIN("0174", "2.16.840.1.113883.5.84", "Fite-Farco stain", "Fite-Farco stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Flocculation</div>
	 * <!-- @formatter:on -->
	 */
	FLOCCULATION("0139", "2.16.840.1.113883.5.84", "Flocculation", "Flocculation", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Flow cytometry (FC)</div>
	 * <!-- @formatter:on -->
	 */
	FLOW_CYTOMETRY_FC("0251", "2.16.840.1.113883.5.84", "Flow cytometry (FC)",
			"Flow cytometry (FC)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Fluorescence polarization immunoassay (FPIA)</div>
	 * <!-- @formatter:on -->
	 */
	FLUORESCENCE_POLARIZATION_IMMUNOASSAY_FPIA("0253", "2.16.840.1.113883.5.84",
			"Fluorescence polarization immunoassay (FPIA)",
			"Fluorescence polarization immunoassay (FPIA)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Fontana-Masson silver stain</div>
	 * <!-- @formatter:on -->
	 */
	FONTANA_MASSON_SILVER_STAIN("0175", "2.16.840.1.113883.5.84", "Fontana-Masson silver stain",
			"Fontana-Masson silver stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Fouchet stain</div>
	 * <!-- @formatter:on -->
	 */
	FOUCHET_STAIN("0176", "2.16.840.1.113883.5.84", "Fouchet stain", "Fouchet stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gas chromatography (GC)</div>
	 * <!-- @formatter:on -->
	 */
	GAS_CHROMATOGRAPHY_GC("0265", "2.16.840.1.113883.5.84", "Gas chromatography (GC)",
			"Gas chromatography (GC)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gas liquid chromatography</div>
	 * <!-- @formatter:on -->
	 */
	GAS_LIQUID_CHROMATOGRAPHY("0040", "2.16.840.1.113883.5.84", "Gas liquid chromatography",
			"Gas liquid chromatography", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GC/MS</div>
	 * <!-- @formatter:on -->
	 */
	GC_MS("0258", "2.16.840.1.113883.5.84", "GC/MS", "GC/MS", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GeneticObservationMethod</div>
	 * <!-- @formatter:on -->
	 */
	GENETICOBSERVATIONMETHOD("_GeneticObservationMethod", "2.16.840.1.113883.5.84",
			"GeneticObservationMethod", "GeneticObservationMethod", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">global introspection</div>
	 * <!-- @formatter:on -->
	 */
	GLOBAL_INTROSPECTION("GINT", "2.16.840.1.113883.5.84", "global introspection",
			"global introspection", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">global introspection</div>
	 * <!-- @formatter:on -->
	 */
	GLOBAL_INTROSPECTION_L1("GINT", "2.16.840.1.113883.5.84", "global introspection",
			"global introspection", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gomori methenamine silver stain</div>
	 * <!-- @formatter:on -->
	 */
	GOMORI_METHENAMINE_SILVER_STAIN("0178", "2.16.840.1.113883.5.84",
			"Gomori methenamine silver stain", "Gomori methenamine silver stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gomori stain</div>
	 * <!-- @formatter:on -->
	 */
	GOMORI_STAIN("0177", "2.16.840.1.113883.5.84", "Gomori stain", "Gomori stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gomori-Wheatly trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	GOMORI_WHEATLY_TRICHROME_STAIN("0179", "2.16.840.1.113883.5.84",
			"Gomori-Wheatly trichrome stain", "Gomori-Wheatly trichrome stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gradient Strip</div>
	 * <!-- @formatter:on -->
	 */
	GRADIENT_STRIP_L1("0275", "2.16.840.1.113883.5.84", "Gradient Strip", "Gradient Strip",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gridley stain</div>
	 * <!-- @formatter:on -->
	 */
	GRIDLEY_STAIN("0180", "2.16.840.1.113883.5.84", "Gridley stain", "Gridley stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Grimelius silver stain</div>
	 * <!-- @formatter:on -->
	 */
	GRIMELIUS_SILVER_STAIN("0181", "2.16.840.1.113883.5.84", "Grimelius silver stain",
			"Grimelius silver stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Grocott methenamine silver stain</div>
	 * <!-- @formatter:on -->
	 */
	GROCOTT_METHENAMINE_SILVER_STAIN("0183", "2.16.840.1.113883.5.84",
			"Grocott methenamine silver stain", "Grocott methenamine silver stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Grocott stain</div>
	 * <!-- @formatter:on -->
	 */
	GROCOTT_STAIN("0182", "2.16.840.1.113883.5.84", "Grocott stain", "Grocott stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hale's colloidal ferric oxide stain</div>
	 * <!-- @formatter:on -->
	 */
	HALE_S_COLLOIDAL_FERRIC_OXIDE_STAIN("0184", "2.16.840.1.113883.5.84",
			"Hale's colloidal ferric oxide stain", "Hale's colloidal ferric oxide stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hale's colloidal iron stain</div>
	 * <!-- @formatter:on -->
	 */
	HALE_S_COLLOIDAL_IRON_STAIN("0185", "2.16.840.1.113883.5.84", "Hale's colloidal iron stain",
			"Hale's colloidal iron stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hansel stain</div>
	 * <!-- @formatter:on -->
	 */
	HANSEL_STAIN("0186", "2.16.840.1.113883.5.84", "Hansel stain", "Hansel stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Harris regressive hematoxylin and eosin stain</div>
	 * <!-- @formatter:on -->
	 */
	HARRIS_REGRESSIVE_HEMATOXYLIN_AND_EOSIN_STAIN("0187", "2.16.840.1.113883.5.84",
			"Harris regressive hematoxylin and eosin stain",
			"Harris regressive hematoxylin and eosin stain", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hemagglutination</div>
	 * <!-- @formatter:on -->
	 */
	HEMAGGLUTINATION("0017", "2.16.840.1.113883.5.84", "Hemagglutination", "Hemagglutination",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hemagglutination inhibition</div>
	 * <!-- @formatter:on -->
	 */
	HEMAGGLUTINATION_INHIBITION("0018", "2.16.840.1.113883.5.84", "Hemagglutination inhibition",
			"Hemagglutination inhibition", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hematoxylin and eosin stain</div>
	 * <!-- @formatter:on -->
	 */
	HEMATOXYLIN_AND_EOSIN_STAIN("0188", "2.16.840.1.113883.5.84", "Hematoxylin and eosin stain",
			"Hematoxylin and eosin stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Highman stain</div>
	 * <!-- @formatter:on -->
	 */
	HIGHMAN_STAIN("0189", "2.16.840.1.113883.5.84", "Highman stain", "Highman stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">High performance liquid chromatography</div>
	 * <!-- @formatter:on -->
	 */
	HIGH_PERFORMANCE_LIQUID_CHROMATOGRAPHY("0041", "2.16.840.1.113883.5.84",
			"High performance liquid chromatography", "High performance liquid chromatography",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">HLAR agar test</div>
	 * <!-- @formatter:on -->
	 */
	HLAR_AGAR_TEST("0003", "2.16.840.1.113883.5.84", "HLAR agar test", "HLAR agar test",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Holzer stain</div>
	 * <!-- @formatter:on -->
	 */
	HOLZER_STAIN("0190", "2.16.840.1.113883.5.84", "Holzer stain", "Holzer stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hybridization Protection Assay</div>
	 * <!-- @formatter:on -->
	 */
	HYBRIDIZATION_PROTECTION_ASSAY("0121", "2.16.840.1.113883.5.84",
			"Hybridization Protection Assay", "Hybridization Protection Assay", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ICP/MS</div>
	 * <!-- @formatter:on -->
	 */
	ICP_MS("0269", "2.16.840.1.113883.5.84", "ICP/MS", "ICP/MS", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IgE immunoassay antibody</div>
	 * <!-- @formatter:on -->
	 */
	IGE_IMMUNOASSAY_ANTIBODY("0260", "2.16.840.1.113883.5.84", "IgE immunoassay antibody",
			"IgE immunoassay antibody", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immune blot</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNE_BLOT("0122", "2.16.840.1.113883.5.84", "Immune blot", "Immune blot", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immune precipitation</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNE_PRECIPITATION("0140", "2.16.840.1.113883.5.84", "Immune precipitation",
			"Immune precipitation", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immune stain</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNE_STAIN("0095", "2.16.840.1.113883.5.84", "Immune stain", "Immune stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoassay</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOASSAY("0101", "2.16.840.1.113883.5.84", "Immunoassay", "Immunoassay", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoassay, qualitative, multiple step</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOASSAY_QUALITATIVE_MULTIPLE_STEP("0102", "2.16.840.1.113883.5.84",
			"Immunoassay, qualitative, multiple step", "Immunoassay, qualitative, multiple step",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoassay, qualitative, single step</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOASSAY_QUALITATIVE_SINGLE_STEP("0103", "2.16.840.1.113883.5.84",
			"Immunoassay, qualitative, single step", "Immunoassay, qualitative, single step",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoassay, semi-quantitative, multiple step</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOASSAY_SEMI_QUANTITATIVE_MULTIPLE_STEP("0105", "2.16.840.1.113883.5.84",
			"Immunoassay, semi-quantitative, multiple step",
			"Immunoassay, semi-quantitative, multiple step", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoassay, semi-quantitative, single step</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOASSAY_SEMI_QUANTITATIVE_SINGLE_STEP("0106", "2.16.840.1.113883.5.84",
			"Immunoassay, semi-quantitative, single step",
			"Immunoassay, semi-quantitative, single step", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunochemiluminescence</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOCHEMILUMINESCENCE("0267", "2.16.840.1.113883.5.84", "Immunochemiluminescence",
			"Immunochemiluminescence", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoelectrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOELECTROPHORESIS("0067", "2.16.840.1.113883.5.84", "Immunoelectrophoresis",
			"Immunoelectrophoresis", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunofixation electrophoresis (IFE)</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOFIXATION_ELECTROPHORESIS_IFE("0254", "2.16.840.1.113883.5.84",
			"Immunofixation electrophoresis (IFE)", "Immunofixation electrophoresis (IFE)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunofluorescent antibody, direct</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOFLUORESCENT_ANTIBODY_DIRECT("0096", "2.16.840.1.113883.5.84",
			"Immunofluorescent antibody, direct", "Immunofluorescent antibody, direct",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunofluorescent antibody, indirect</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOFLUORESCENT_ANTIBODY_INDIRECT("0097", "2.16.840.1.113883.5.84",
			"Immunofluorescent antibody, indirect", "Immunofluorescent antibody, indirect",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoperoxidase, Avidin-Biotin Complex</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOPEROXIDASE_AVIDIN_BIOTIN_COMPLEX("0098", "2.16.840.1.113883.5.84",
			"Immunoperoxidase, Avidin-Biotin Complex", "Immunoperoxidase, Avidin-Biotin Complex",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoperoxidase, Peroxidase anti-peroxidase complex</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOPEROXIDASE_PEROXIDASE_ANTI_PEROXIDASE_COMPLEX("0099", "2.16.840.1.113883.5.84",
			"Immunoperoxidase, Peroxidase anti-peroxidase complex",
			"Immunoperoxidase, Peroxidase anti-peroxidase complex", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoperoxidase, Protein A-peroxidase complex</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNOPEROXIDASE_PROTEIN_A_PEROXIDASE_COMPLEX("0100", "2.16.840.1.113883.5.84",
			"Immunoperoxidase, Protein A-peroxidase complex",
			"Immunoperoxidase, Protein A-peroxidase complex", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunoradiometric assay (IRMA)</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNORADIOMETRIC_ASSAY_IRMA("0270", "2.16.840.1.113883.5.84", "Immunoradiometric assay (IRMA)",
			"Immunoradiometric assay (IRMA)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">In-situ hybridization</div>
	 * <!-- @formatter:on -->
	 */
	IN_SITU_HYBRIDIZATION("0123", "2.16.840.1.113883.5.84", "In-situ hybridization",
			"In-situ hybridization", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ion selective electrode (ISE)</div>
	 * <!-- @formatter:on -->
	 */
	ION_SELECTIVE_ELECTRODE_ISE("0264", "2.16.840.1.113883.5.84", "Ion selective electrode (ISE)",
			"Ion selective electrode (ISE)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Iron hematoxylin stain</div>
	 * <!-- @formatter:on -->
	 */
	IRON_HEMATOXYLIN_STAIN("0191", "2.16.840.1.113883.5.84", "Iron hematoxylin stain",
			"Iron hematoxylin stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Isoelectric focusing (IEF)</div>
	 * <!-- @formatter:on -->
	 */
	ISOELECTRIC_FOCUSING_IEF("0266", "2.16.840.1.113883.5.84", "Isoelectric focusing (IEF)",
			"Isoelectric focusing (IEF)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Jones methenamine silver stain</div>
	 * <!-- @formatter:on -->
	 */
	JONES_METHENAMINE_SILVER_STAIN("0193", "2.16.840.1.113883.5.84",
			"Jones methenamine silver stain", "Jones methenamine silver stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Jones stain</div>
	 * <!-- @formatter:on -->
	 */
	JONES_STAIN("0192", "2.16.840.1.113883.5.84", "Jones stain", "Jones stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Kinetic ELISA</div>
	 * <!-- @formatter:on -->
	 */
	KINETIC_ELISA("0073", "2.16.840.1.113883.5.84", "Kinetic ELISA", "Kinetic ELISA", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Kleihauer-Betke acid elution</div>
	 * <!-- @formatter:on -->
	 */
	KLEIHAUER_BETKE_ACID_ELUTION("0256", "2.16.840.1.113883.5.84", "Kleihauer-Betke acid elution",
			"Kleihauer-Betke acid elution", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Kossa stain</div>
	 * <!-- @formatter:on -->
	 */
	KOSSA_STAIN("0194", "2.16.840.1.113883.5.84", "Kossa stain", "Kossa stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Latex agglutination</div>
	 * <!-- @formatter:on -->
	 */
	LATEX_AGGLUTINATION("0019", "2.16.840.1.113883.5.84", "Latex agglutination",
			"Latex agglutination", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Lawson-Van Gieson stain</div>
	 * <!-- @formatter:on -->
	 */
	LAWSON_VAN_GIESON_STAIN("0195", "2.16.840.1.113883.5.84", "Lawson-Van Gieson stain",
			"Lawson-Van Gieson stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ligase Chain Reaction</div>
	 * <!-- @formatter:on -->
	 */
	LIGASE_CHAIN_REACTION("0124", "2.16.840.1.113883.5.84", "Ligase Chain Reaction",
			"Ligase Chain Reaction", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ligation Activated Transcription</div>
	 * <!-- @formatter:on -->
	 */
	LIGATION_ACTIVATED_TRANSCRIPTION("0125", "2.16.840.1.113883.5.84",
			"Ligation Activated Transcription", "Ligation Activated Transcription", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Liquid Chromatography</div>
	 * <!-- @formatter:on -->
	 */
	LIQUID_CHROMATOGRAPHY("0042", "2.16.840.1.113883.5.84", "Liquid Chromatography",
			"Liquid Chromatography", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Loeffler methylene blue stain</div>
	 * <!-- @formatter:on -->
	 */
	LOEFFLER_METHYLENE_BLUE_STAIN("0196", "2.16.840.1.113883.5.84", "Loeffler methylene blue stain",
			"Loeffler methylene blue stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Luxol fast blue with cresyl violet stain</div>
	 * <!-- @formatter:on -->
	 */
	LUXOL_FAST_BLUE_WITH_CRESYL_VIOLET_STAIN("0197", "2.16.840.1.113883.5.84",
			"Luxol fast blue with cresyl violet stain", "Luxol fast blue with cresyl violet stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Luxol fast blue with Periodic acid-Schiff stain</div>
	 * <!-- @formatter:on -->
	 */
	LUXOL_FAST_BLUE_WITH_PERIODIC_ACID_SCHIFF_STAIN("0198", "2.16.840.1.113883.5.84",
			"Luxol fast blue with Periodic acid-Schiff stain",
			"Luxol fast blue with Periodic acid-Schiff stain", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Lymphocyte Microcytotoxicity Assay</div>
	 * <!-- @formatter:on -->
	 */
	LYMPHOCYTE_MICROCYTOTOXICITY_ASSAY("0261", "2.16.840.1.113883.5.84",
			"Lymphocyte Microcytotoxicity Assay", "Lymphocyte Microcytotoxicity Assay",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MacNeal's tetrachrome blood stain</div>
	 * <!-- @formatter:on -->
	 */
	MACNEAL_S_TETRACHROME_BLOOD_STAIN("0199", "2.16.840.1.113883.5.84",
			"MacNeal's tetrachrome blood stain", "MacNeal's tetrachrome blood stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Macroscopic observation</div>
	 * <!-- @formatter:on -->
	 */
	MACROSCOPIC_OBSERVATION("0004", "2.16.840.1.113883.5.84", "Macroscopic observation",
			"Macroscopic observation", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Magnetic resonance</div>
	 * <!-- @formatter:on -->
	 */
	MAGNETIC_RESONANCE("0005", "2.16.840.1.113883.5.84", "Magnetic resonance", "Magnetic resonance",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mallory-Heidenhain stain</div>
	 * <!-- @formatter:on -->
	 */
	MALLORY_HEIDENHAIN_STAIN("0200", "2.16.840.1.113883.5.84", "Mallory-Heidenhain stain",
			"Mallory-Heidenhain stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Manual cell count</div>
	 * <!-- @formatter:on -->
	 */
	MANUAL_CELL_COUNT("0048", "2.16.840.1.113883.5.84", "Manual cell count", "Manual cell count",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Masson trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	MASSON_TRICHROME_STAIN("0201", "2.16.840.1.113883.5.84", "Masson trichrome stain",
			"Masson trichrome stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mayers progressive hematoxylin and eosin stain</div>
	 * <!-- @formatter:on -->
	 */
	MAYERS_PROGRESSIVE_HEMATOXYLIN_AND_EOSIN_STAIN("0203", "2.16.840.1.113883.5.84",
			"Mayers progressive hematoxylin and eosin stain",
			"Mayers progressive hematoxylin and eosin stain", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mayer mucicarmine stain</div>
	 * <!-- @formatter:on -->
	 */
	MAYER_MUCICARMINE_STAIN("0202", "2.16.840.1.113883.5.84", "Mayer mucicarmine stain",
			"Mayer mucicarmine stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">May-Grunwald Giemsa stain</div>
	 * <!-- @formatter:on -->
	 */
	MAY_GRUNWALD_GIEMSA_STAIN("0204", "2.16.840.1.113883.5.84", "May-Grunwald Giemsa stain",
			"May-Grunwald Giemsa stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Methyl green pyronin stain</div>
	 * <!-- @formatter:on -->
	 */
	METHYL_GREEN_PYRONIN_STAIN("0206", "2.16.840.1.113883.5.84", "Methyl green pyronin stain",
			"Methyl green pyronin stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Methyl green stain</div>
	 * <!-- @formatter:on -->
	 */
	METHYL_GREEN_STAIN("0205", "2.16.840.1.113883.5.84", "Methyl green stain", "Methyl green stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Microaerophilic Culture</div>
	 * <!-- @formatter:on -->
	 */
	MICROAEROPHILIC_CULTURE("0054", "2.16.840.1.113883.5.84", "Microaerophilic Culture",
			"Microaerophilic Culture", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Microparticle enzyme immunoassay (MEIA)</div>
	 * <!-- @formatter:on -->
	 */
	MICROPARTICLE_ENZYME_IMMUNOASSAY_MEIA("0268", "2.16.840.1.113883.5.84",
			"Microparticle enzyme immunoassay (MEIA)", "Microparticle enzyme immunoassay (MEIA)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Microscopy</div>
	 * <!-- @formatter:on -->
	 */
	MICROSCOPY("0107", "2.16.840.1.113883.5.84", "Microscopy", "Microscopy", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Microscopy, Light</div>
	 * <!-- @formatter:on -->
	 */
	MICROSCOPY_LIGHT("0114", "2.16.840.1.113883.5.84", "Microscopy, Light", "Microscopy, Light",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Milk ring test</div>
	 * <!-- @formatter:on -->
	 */
	MILK_RING_TEST("0141", "2.16.840.1.113883.5.84", "Milk ring test", "Milk ring test",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum bactericidal concentration test, macrodilution</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_BACTERICIDAL_CONCENTRATION_TEST_MACRODILUTION("0243", "2.16.840.1.113883.5.84",
			"Minimum bactericidal concentration test, macrodilution",
			"Minimum bactericidal concentration test, macrodilution", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum bactericidal concentration test, microdilution</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_BACTERICIDAL_CONCENTRATION_TEST_MICRODILUTION("0244", "2.16.840.1.113883.5.84",
			"Minimum bactericidal concentration test, microdilution",
			"Minimum bactericidal concentration test, microdilution", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum Inhibitory Concentration</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_INHIBITORY_CONCENTRATION("0272", "2.16.840.1.113883.5.84",
			"Minimum Inhibitory Concentration", "Minimum Inhibitory Concentration", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum Inhibitory Concentration</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_INHIBITORY_CONCENTRATION_L1("0272", "2.16.840.1.113883.5.84",
			"Minimum Inhibitory Concentration", "Minimum Inhibitory Concentration", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum Inhibitory Concentration, macrodilution</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_INHIBITORY_CONCENTRATION_MACRODILUTION("0245", "2.16.840.1.113883.5.84",
			"Minimum Inhibitory Concentration, macrodilution",
			"Minimum Inhibitory Concentration, macrodilution", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum Inhibitory Concentration, macrodilution</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_INHIBITORY_CONCENTRATION_MACRODILUTION_L1("0245", "2.16.840.1.113883.5.84",
			"Minimum Inhibitory Concentration, macrodilution",
			"Minimum Inhibitory Concentration, macrodilution", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum Inhibitory Concentration, microdilution</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_INHIBITORY_CONCENTRATION_MICRODILUTION("0246", "2.16.840.1.113883.5.84",
			"Minimum Inhibitory Concentration, microdilution",
			"Minimum Inhibitory Concentration, microdilution", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum Inhibitory Concentration, microdilution</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_INHIBITORY_CONCENTRATION_MICRODILUTION_L1("0246", "2.16.840.1.113883.5.84",
			"Minimum Inhibitory Concentration, microdilution",
			"Minimum Inhibitory Concentration, microdilution", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum Lethal Concentration (MLC)</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_LETHAL_CONCENTRATION_MLC("0275a", "2.16.840.1.113883.5.84",
			"Minimum Lethal Concentration (MLC)", "Minimum Lethal Concentration (MLC)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minimum Lethal Concentration (MLC)</div>
	 * <!-- @formatter:on -->
	 */
	MINIMUM_LETHAL_CONCENTRATION_MLC_L1("0275a", "2.16.840.1.113883.5.84",
			"Minimum Lethal Concentration (MLC)", "Minimum Lethal Concentration (MLC)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">mini VIDAS</div>
	 * <!-- @formatter:on -->
	 */
	MINI_VIDAS("0087", "2.16.840.1.113883.5.84", "mini VIDAS", "mini VIDAS", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Modified Gomori-Wheatly trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	MODIFIED_GOMORI_WHEATLY_TRICHROME_STAIN("0207", "2.16.840.1.113883.5.84",
			"Modified Gomori-Wheatly trichrome stain", "Modified Gomori-Wheatly trichrome stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Modified Masson trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	MODIFIED_MASSON_TRICHROME_STAIN("0208", "2.16.840.1.113883.5.84",
			"Modified Masson trichrome stain", "Modified Masson trichrome stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Modified trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	MODIFIED_TRICHROME_STAIN("0209", "2.16.840.1.113883.5.84", "Modified trichrome stain",
			"Modified trichrome stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Morphometry</div>
	 * <!-- @formatter:on -->
	 */
	MORPHOMETRY("0006", "2.16.840.1.113883.5.84", "Morphometry", "Morphometry", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mouse intercerebral inoculation</div>
	 * <!-- @formatter:on -->
	 */
	MOUSE_INTERCEREBRAL_INOCULATION("0030", "2.16.840.1.113883.5.84",
			"Mouse intercerebral inoculation", "Mouse intercerebral inoculation", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Movat pentachrome stain</div>
	 * <!-- @formatter:on -->
	 */
	MOVAT_PENTACHROME_STAIN("0210", "2.16.840.1.113883.5.84", "Movat pentachrome stain",
			"Movat pentachrome stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mucicarmine stain</div>
	 * <!-- @formatter:on -->
	 */
	MUCICARMINE_STAIN("0211", "2.16.840.1.113883.5.84", "Mucicarmine stain", "Mucicarmine stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nephelometry</div>
	 * <!-- @formatter:on -->
	 */
	NEPHELOMETRY("0259", "2.16.840.1.113883.5.84", "Nephelometry", "Nephelometry", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neutral red stain</div>
	 * <!-- @formatter:on -->
	 */
	NEUTRAL_RED_STAIN("0212", "2.16.840.1.113883.5.84", "Neutral red stain", "Neutral red stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Night blue stain</div>
	 * <!-- @formatter:on -->
	 */
	NIGHT_BLUE_STAIN("0213", "2.16.840.1.113883.5.84", "Night blue stain", "Night blue stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Non-specific esterase stain</div>
	 * <!-- @formatter:on -->
	 */
	NON_SPECIFIC_ESTERASE_STAIN("0214", "2.16.840.1.113883.5.84", "Non-specific esterase stain",
			"Non-specific esterase stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nucleic Acid Probe</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEIC_ACID_PROBE("0126", "2.16.840.1.113883.5.84", "Nucleic Acid Probe", "Nucleic Acid Probe",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nucleic acid probe with amplification</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEIC_ACID_PROBE_WITH_AMPLIFICATION("0128", "2.16.840.1.113883.5.84",
			"Nucleic acid probe with amplification", "Nucleic acid probe with amplification",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nucleic acid probe with target amplification</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEIC_ACID_PROBE_WITH_TARGET_AMPLIFICATION("0129", "2.16.840.1.113883.5.84",
			"Nucleic acid probe with target amplification",
			"Nucleic acid probe with target amplification", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nucleic acid reverse transcription</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEIC_ACID_REVERSE_TRANSCRIPTION("0130", "2.16.840.1.113883.5.84",
			"Nucleic acid reverse transcription", "Nucleic acid reverse transcription",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nucleic Acid Sequence Based Analysis</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEIC_ACID_SEQUENCE_BASED_ANALYSIS("0131", "2.16.840.1.113883.5.84",
			"Nucleic Acid Sequence Based Analysis", "Nucleic Acid Sequence Based Analysis",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oil red-O stain</div>
	 * <!-- @formatter:on -->
	 */
	OIL_RED_O_STAIN("0215", "2.16.840.1.113883.5.84", "Oil red-O stain", "Oil red-O stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orcein stain</div>
	 * <!-- @formatter:on -->
	 */
	ORCEIN_STAIN("0216", "2.16.840.1.113883.5.84", "Orcein stain", "Orcein stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PCR</div>
	 * <!-- @formatter:on -->
	 */
	PCR_L1("PCR", "2.16.840.1.113883.5.84", "PCR", "PCR", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Perls' stain</div>
	 * <!-- @formatter:on -->
	 */
	PERLS_STAIN("0217", "2.16.840.1.113883.5.84", "Perls' stain", "Perls' stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Phage susceptibility typing</div>
	 * <!-- @formatter:on -->
	 */
	PHAGE_SUSCEPTIBILITY_TYPING("0088", "2.16.840.1.113883.5.84", "Phage susceptibility typing",
			"Phage susceptibility typing", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Phosphotungstic acid-hematoxylin stain</div>
	 * <!-- @formatter:on -->
	 */
	PHOSPHOTUNGSTIC_ACID_HEMATOXYLIN_STAIN("0218", "2.16.840.1.113883.5.84",
			"Phosphotungstic acid-hematoxylin stain", "Phosphotungstic acid-hematoxylin stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Photo optical clot detection</div>
	 * <!-- @formatter:on -->
	 */
	PHOTO_OPTICAL_CLOT_DETECTION("0271", "2.16.840.1.113883.5.84", "Photo optical clot detection",
			"Photo optical clot detection", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Platelet count, Rees-Ecker</div>
	 * <!-- @formatter:on -->
	 */
	PLATELET_COUNT_REES_ECKER("0049", "2.16.840.1.113883.5.84", "Platelet count, Rees-Ecker",
			"Platelet count, Rees-Ecker", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plate agglutination</div>
	 * <!-- @formatter:on -->
	 */
	PLATE_AGGLUTINATION("0020", "2.16.840.1.113883.5.84", "Plate agglutination",
			"Plate agglutination", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Polarizing light microscopy</div>
	 * <!-- @formatter:on -->
	 */
	POLARIZING_LIGHT_MICROSCOPY("0115", "2.16.840.1.113883.5.84", "Polarizing light microscopy",
			"Polarizing light microscopy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Polyacrylamide gel electrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	POLYACRYLAMIDE_GEL_ELECTROPHORESIS("0068", "2.16.840.1.113883.5.84",
			"Polyacrylamide gel electrophoresis", "Polyacrylamide gel electrophoresis",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Polymerase chain reaction</div>
	 * <!-- @formatter:on -->
	 */
	POLYMERASE_CHAIN_REACTION("0132", "2.16.840.1.113883.5.84", "Polymerase chain reaction",
			"Polymerase chain reaction", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Positron emission tomography</div>
	 * <!-- @formatter:on -->
	 */
	POSITRON_EMISSION_TOMOGRAPHY("0007", "2.16.840.1.113883.5.84", "Positron emission tomography",
			"Positron emission tomography", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Potassium ferrocyanide stain</div>
	 * <!-- @formatter:on -->
	 */
	POTASSIUM_FERROCYANIDE_STAIN("0219", "2.16.840.1.113883.5.84", "Potassium ferrocyanide stain",
			"Potassium ferrocyanide stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Precipitin</div>
	 * <!-- @formatter:on -->
	 */
	PRECIPITIN("0142", "2.16.840.1.113883.5.84", "Precipitin", "Precipitin", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Protein A affinity chromatography</div>
	 * <!-- @formatter:on -->
	 */
	PROTEIN_A_AFFINITY_CHROMATOGRAPHY("0043", "2.16.840.1.113883.5.84",
			"Protein A affinity chromatography", "Protein A affinity chromatography", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prussian blue stain</div>
	 * <!-- @formatter:on -->
	 */
	PRUSSIAN_BLUE_STAIN("0220", "2.16.840.1.113883.5.84", "Prussian blue stain",
			"Prussian blue stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Putchler modified Bennhold stain</div>
	 * <!-- @formatter:on -->
	 */
	PUTCHLER_MODIFIED_BENNHOLD_STAIN("0221", "2.16.840.1.113883.5.84",
			"Putchler modified Bennhold stain", "Putchler modified Bennhold stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quad-FERM+</div>
	 * <!-- @formatter:on -->
	 */
	QUAD_FERM("0089", "2.16.840.1.113883.5.84", "Quad-FERM+", "Quad-FERM+", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quantitative microbial culture, cup</div>
	 * <!-- @formatter:on -->
	 */
	QUANTITATIVE_MICROBIAL_CULTURE_CUP("0055", "2.16.840.1.113883.5.84",
			"Quantitative microbial culture, cup", "Quantitative microbial culture, cup",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quantitative microbial culture, droplet</div>
	 * <!-- @formatter:on -->
	 */
	QUANTITATIVE_MICROBIAL_CULTURE_DROPLET("0056", "2.16.840.1.113883.5.84",
			"Quantitative microbial culture, droplet", "Quantitative microbial culture, droplet",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quantitative microbial culture, filter paper</div>
	 * <!-- @formatter:on -->
	 */
	QUANTITATIVE_MICROBIAL_CULTURE_FILTER_PAPER("0057", "2.16.840.1.113883.5.84",
			"Quantitative microbial culture, filter paper",
			"Quantitative microbial culture, filter paper", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quantitative microbial culture, pad culture</div>
	 * <!-- @formatter:on -->
	 */
	QUANTITATIVE_MICROBIAL_CULTURE_PAD_CULTURE("0058", "2.16.840.1.113883.5.84",
			"Quantitative microbial culture, pad culture",
			"Quantitative microbial culture, pad culture", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quantitative microbial culture, pour plate</div>
	 * <!-- @formatter:on -->
	 */
	QUANTITATIVE_MICROBIAL_CULTURE_POUR_PLATE("0059", "2.16.840.1.113883.5.84",
			"Quantitative microbial culture, pour plate",
			"Quantitative microbial culture, pour plate", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quantitative microbial culture, surface streak</div>
	 * <!-- @formatter:on -->
	 */
	QUANTITATIVE_MICROBIAL_CULTURE_SURFACE_STREAK("0060", "2.16.840.1.113883.5.84",
			"Quantitative microbial culture, surface streak",
			"Quantitative microbial culture, surface streak", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quinacrine fluorescent stain</div>
	 * <!-- @formatter:on -->
	 */
	QUINACRINE_FLUORESCENT_STAIN("0222", "2.16.840.1.113883.5.84", "Quinacrine fluorescent stain",
			"Quinacrine fluorescent stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Q-Beta Replicase or probe amplification category method</div>
	 * <!-- @formatter:on -->
	 */
	Q_BETA_REPLICASE_OR_PROBE_AMPLIFICATION_CATEGORY_METHOD("0133", "2.16.840.1.113883.5.84",
			"Q-Beta Replicase or probe amplification category method",
			"Q-Beta Replicase or probe amplification category method", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radial immunodiffusion (RID)</div>
	 * <!-- @formatter:on -->
	 */
	RADIAL_IMMUNODIFFUSION_RID("0252", "2.16.840.1.113883.5.84", "Radial immunodiffusion (RID)",
			"Radial immunodiffusion (RID)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radioimmunoassay</div>
	 * <!-- @formatter:on -->
	 */
	RADIOIMMUNOASSAY("0104", "2.16.840.1.113883.5.84", "Radioimmunoassay", "Radioimmunoassay",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">RAPIDEC Staph</div>
	 * <!-- @formatter:on -->
	 */
	RAPIDEC_STAPH("0090", "2.16.840.1.113883.5.84", "RAPIDEC Staph", "RAPIDEC Staph", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rapid agglutination</div>
	 * <!-- @formatter:on -->
	 */
	RAPID_AGGLUTINATION("0021", "2.16.840.1.113883.5.84", "Rapid agglutination",
			"Rapid agglutination", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">RBC agglutination</div>
	 * <!-- @formatter:on -->
	 */
	RBC_AGGLUTINATION("0022", "2.16.840.1.113883.5.84", "RBC agglutination", "RBC agglutination",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Refractometric</div>
	 * <!-- @formatter:on -->
	 */
	REFRACTOMETRIC("0248", "2.16.840.1.113883.5.84", "Refractometric", "Refractometric",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">registry verification</div>
	 * <!-- @formatter:on -->
	 */
	REGISTRY_VERIFICATION_L1("VREG", "2.16.840.1.113883.5.84", "registry verification",
			"registry verification", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Restriction Fragment Length Polymorphism</div>
	 * <!-- @formatter:on -->
	 */
	RESTRICTION_FRAGMENT_LENGTH_POLYMORPHISM("0134", "2.16.840.1.113883.5.84",
			"Restriction Fragment Length Polymorphism", "Restriction Fragment Length Polymorphism",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Reticulin stain</div>
	 * <!-- @formatter:on -->
	 */
	RETICULIN_STAIN("0223", "2.16.840.1.113883.5.84", "Reticulin stain", "Reticulin stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rhodamine stain</div>
	 * <!-- @formatter:on -->
	 */
	RHODAMINE_STAIN("0224", "2.16.840.1.113883.5.84", "Rhodamine stain", "Rhodamine stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rivanol agglutination</div>
	 * <!-- @formatter:on -->
	 */
	RIVANOL_AGGLUTINATION("0023", "2.16.840.1.113883.5.84", "Rivanol agglutination",
			"Rivanol agglutination", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Safranin stain</div>
	 * <!-- @formatter:on -->
	 */
	SAFRANIN_STAIN("0225", "2.16.840.1.113883.5.84", "Safranin stain", "Safranin stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SAMHSA confirmation</div>
	 * <!-- @formatter:on -->
	 */
	SAMHSA_CONFIRMATION("0008", "2.16.840.1.113883.5.84", "SAMHSA confirmation",
			"SAMHSA confirmation", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SAMHSA screening</div>
	 * <!-- @formatter:on -->
	 */
	SAMHSA_SCREENING("0009", "2.16.840.1.113883.5.84", "SAMHSA screening", "SAMHSA screening",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Scanning electron microscopy</div>
	 * <!-- @formatter:on -->
	 */
	SCANNING_ELECTRON_MICROSCOPY("0116", "2.16.840.1.113883.5.84", "Scanning electron microscopy",
			"Scanning electron microscopy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Schmorl stain</div>
	 * <!-- @formatter:on -->
	 */
	SCHMORL_STAIN("0226", "2.16.840.1.113883.5.84", "Schmorl stain", "Schmorl stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Seiver-Munger stain</div>
	 * <!-- @formatter:on -->
	 */
	SEIVER_MUNGER_STAIN("0227", "2.16.840.1.113883.5.84", "Seiver-Munger stain",
			"Seiver-Munger stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Serum bactericidal titer</div>
	 * <!-- @formatter:on -->
	 */
	SERUM_BACTERICIDAL_TITER_L1("0277", "2.16.840.1.113883.5.84", "Serum bactericidal titer",
			"Serum bactericidal titer", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Serum Neutralization</div>
	 * <!-- @formatter:on -->
	 */
	SERUM_NEUTRALIZATION("0010", "2.16.840.1.113883.5.84", "Serum Neutralization",
			"Serum Neutralization", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Silver stain</div>
	 * <!-- @formatter:on -->
	 */
	SILVER_STAIN("0228", "2.16.840.1.113883.5.84", "Silver stain", "Silver stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Slow Mycobacteria Susceptibility</div>
	 * <!-- @formatter:on -->
	 */
	SLOW_MYCOBACTERIA_SUSCEPTIBILITY_L1("0276", "2.16.840.1.113883.5.84",
			"Slow Mycobacteria Susceptibility", "Slow Mycobacteria Susceptibility", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Somatic Cell culture</div>
	 * <!-- @formatter:on -->
	 */
	SOMATIC_CELL_CULTURE("0061", "2.16.840.1.113883.5.84", "Somatic Cell culture",
			"Somatic Cell culture", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Southern Blot</div>
	 * <!-- @formatter:on -->
	 */
	SOUTHERN_BLOT("0135", "2.16.840.1.113883.5.84", "Southern Blot", "Southern Blot", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Specific esterase stain</div>
	 * <!-- @formatter:on -->
	 */
	SPECIFIC_ESTERASE_STAIN("0229", "2.16.840.1.113883.5.84", "Specific esterase stain",
			"Specific esterase stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Spectrophotometry</div>
	 * <!-- @formatter:on -->
	 */
	SPECTROPHOTOMETRY("0262", "2.16.840.1.113883.5.84", "Spectrophotometry", "Spectrophotometry",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Staphaurex</div>
	 * <!-- @formatter:on -->
	 */
	STAPHAUREX("0091", "2.16.840.1.113883.5.84", "Staphaurex", "Staphaurex", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Starch gel electrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	STARCH_GEL_ELECTROPHORESIS("0069", "2.16.840.1.113883.5.84", "Starch gel electrophoresis",
			"Starch gel electrophoresis", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Steiner silver stain</div>
	 * <!-- @formatter:on -->
	 */
	STEINER_SILVER_STAIN("0230", "2.16.840.1.113883.5.84", "Steiner silver stain",
			"Steiner silver stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Strand Displacement Amplification</div>
	 * <!-- @formatter:on -->
	 */
	STRAND_DISPLACEMENT_AMPLIFICATION("0136", "2.16.840.1.113883.5.84",
			"Strand Displacement Amplification", "Strand Displacement Amplification", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sudan III stain</div>
	 * <!-- @formatter:on -->
	 */
	SUDAN_III_STAIN("0231", "2.16.840.1.113883.5.84", "Sudan III stain", "Sudan III stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sudan IVI stain</div>
	 * <!-- @formatter:on -->
	 */
	SUDAN_IVI_STAIN("0232", "2.16.840.1.113883.5.84", "Sudan IVI stain", "Sudan IVI stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sulfated alcian blue stain</div>
	 * <!-- @formatter:on -->
	 */
	SULFATED_ALCIAN_BLUE_STAIN("0233", "2.16.840.1.113883.5.84", "Sulfated alcian blue stain",
			"Sulfated alcian blue stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Supravital stain</div>
	 * <!-- @formatter:on -->
	 */
	SUPRAVITAL_STAIN("0234", "2.16.840.1.113883.5.84", "Supravital stain", "Supravital stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Susceptibility Testing</div>
	 * <!-- @formatter:on -->
	 */
	SUSCEPTIBILITY_TESTING("0280", "2.16.840.1.113883.5.84", "Susceptibility Testing",
			"Susceptibility Testing", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Test strip</div>
	 * <!-- @formatter:on -->
	 */
	TEST_STRIP("0037", "2.16.840.1.113883.5.84", "Test strip", "Test strip", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Thin layer chromatography (TLC)</div>
	 * <!-- @formatter:on -->
	 */
	THIN_LAYER_CHROMATOGRAPHY_TLC("0249", "2.16.840.1.113883.5.84",
			"Thin layer chromatography (TLC)", "Thin layer chromatography (TLC)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Thioflavine-S stain</div>
	 * <!-- @formatter:on -->
	 */
	THIOFLAVINE_S_STAIN("0235", "2.16.840.1.113883.5.84", "Thioflavine-S stain",
			"Thioflavine-S stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Three micron Giemsa stain</div>
	 * <!-- @formatter:on -->
	 */
	THREE_MICRON_GIEMSA_STAIN("0236", "2.16.840.1.113883.5.84", "Three micron Giemsa stain",
			"Three micron Giemsa stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">3 Self-Sustaining Sequence Replication</div>
	 * <!-- @formatter:on -->
	 */
	THREE_SELF_SUSTAINING_SEQUENCE_REPLICATION("0119", "2.16.840.1.113883.5.84",
			"3 Self-Sustaining Sequence Replication", "3 Self-Sustaining Sequence Replication",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tilt tube coagulation time</div>
	 * <!-- @formatter:on -->
	 */
	TILT_TUBE_COAGULATION_TIME("0045", "2.16.840.1.113883.5.84", "Tilt tube coagulation time",
			"Tilt tube coagulation time", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tilt tube reptilase induced coagulation</div>
	 * <!-- @formatter:on -->
	 */
	TILT_TUBE_REPTILASE_INDUCED_COAGULATION("0046", "2.16.840.1.113883.5.84",
			"Tilt tube reptilase induced coagulation", "Tilt tube reptilase induced coagulation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Titration</div>
	 * <!-- @formatter:on -->
	 */
	TITRATION("0011", "2.16.840.1.113883.5.84", "Titration", "Titration", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transcription Mediated Amplification</div>
	 * <!-- @formatter:on -->
	 */
	TRANSCRIPTION_MEDIATED_AMPLIFICATION("0137", "2.16.840.1.113883.5.84",
			"Transcription Mediated Amplification", "Transcription Mediated Amplification",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transmission electron microscopy</div>
	 * <!-- @formatter:on -->
	 */
	TRANSMISSION_ELECTRON_MICROSCOPY("0117", "2.16.840.1.113883.5.84",
			"Transmission electron microscopy", "Transmission electron microscopy", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transparent tape direct examination</div>
	 * <!-- @formatter:on -->
	 */
	TRANSPARENT_TAPE_DIRECT_EXAMINATION("0118", "2.16.840.1.113883.5.84",
			"Transparent tape direct examination", "Transparent tape direct examination",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tube agglutination</div>
	 * <!-- @formatter:on -->
	 */
	TUBE_AGGLUTINATION("0024", "2.16.840.1.113883.5.84", "Tube agglutination", "Tube agglutination",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Turbidometric</div>
	 * <!-- @formatter:on -->
	 */
	TURBIDOMETRIC("0247", "2.16.840.1.113883.5.84", "Turbidometric", "Turbidometric", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ultrasound</div>
	 * <!-- @formatter:on -->
	 */
	ULTRASOUND("0012", "2.16.840.1.113883.5.84", "Ultrasound", "Ultrasound", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vassar-Culling stain</div>
	 * <!-- @formatter:on -->
	 */
	VASSAR_CULLING_STAIN("0237", "2.16.840.1.113883.5.84", "Vassar-Culling stain",
			"Vassar-Culling stain", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">VerificationMethod</div>
	 * <!-- @formatter:on -->
	 */
	VERIFICATIONMETHOD("_VerificationMethod", "2.16.840.1.113883.5.84", "VerificationMethod",
			"VerificationMethod", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">VIDAS</div>
	 * <!-- @formatter:on -->
	 */
	VIDAS("0092", "2.16.840.1.113883.5.84", "VIDAS", "VIDAS", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Viral Genotype Susceptibility</div>
	 * <!-- @formatter:on -->
	 */
	VIRAL_GENOTYPE_SUSCEPTIBILITY_L1("0273", "2.16.840.1.113883.5.84",
			"Viral Genotype Susceptibility", "Viral Genotype Susceptibility", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Viral Phenotype Susceptibility</div>
	 * <!-- @formatter:on -->
	 */
	VIRAL_PHENOTYPE_SUSCEPTIBILITY_L1("0274", "2.16.840.1.113883.5.84",
			"Viral Phenotype Susceptibility", "Viral Phenotype Susceptibility", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vital Stain</div>
	 * <!-- @formatter:on -->
	 */
	VITAL_STAIN("0238", "2.16.840.1.113883.5.84", "Vital Stain", "Vital Stain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vitek</div>
	 * <!-- @formatter:on -->
	 */
	VITEK("0093", "2.16.840.1.113883.5.84", "Vitek", "Vitek", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">VITEK 2</div>
	 * <!-- @formatter:on -->
	 */
	VITEK_2("0094", "2.16.840.1.113883.5.84", "VITEK 2", "VITEK 2", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">voice-based verification</div>
	 * <!-- @formatter:on -->
	 */
	VOICE_BASED_VERIFICATION_L1("VVOICE", "2.16.840.1.113883.5.84", "voice-based verification",
			"voice-based verification", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">von Kossa stain</div>
	 * <!-- @formatter:on -->
	 */
	VON_KOSSA_STAIN("0239", "2.16.840.1.113883.5.84", "von Kossa stain", "von Kossa stain",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Western Blot</div>
	 * <!-- @formatter:on -->
	 */
	WESTERN_BLOT("0138", "2.16.840.1.113883.5.84", "Western Blot", "Western Blot", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">X-ray crystallography</div>
	 * <!-- @formatter:on -->
	 */
	X_RAY_CRYSTALLOGRAPHY("0013", "2.16.840.1.113883.5.84", "X-ray crystallography",
			"X-ray crystallography", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Acid fast stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACID_FAST_STAIN_CODE = "0143";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Acid fast stain, fluorochrome</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACID_FAST_STAIN_FLUOROCHROME_CODE = "0144";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Acid fast stain, Kinyoun's cold carbolfuchsin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACID_FAST_STAIN_KINYOUN_S_COLD_CARBOLFUCHSIN_CODE = "0145";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Acid fast stain, Ziehl-Neelsen</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACID_FAST_STAIN_ZIEHL_NEELSEN_CODE = "0146";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Acid phosphatase stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACID_PHOSPHATASE_STAIN_CODE = "0147";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Acridine orange stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACRIDINE_ORANGE_STAIN_CODE = "0148";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Active brilliant orange KH stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACTIVE_BRILLIANT_ORANGE_KH_STAIN_CODE = "0149";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Aerobic Culture</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AEROBIC_CULTURE_CODE = "0050";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Affinity chromatography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFFINITY_CHROMATOGRAPHY_CODE = "0039";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Agaorse gel electrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AGAORSE_GEL_ELECTROPHORESIS_CODE = "0065";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Agar diffusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AGAR_DIFFUSION_CODE = "0062";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Agar Gel Immunodiffusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AGAR_GEL_IMMUNODIFFUSION_CODE = "0063";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Agar screen</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AGAR_SCREEN_L1_CODE = "0278";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AGGLUTINATION_CODE = "0014";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Alazarin red S stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALAZARIN_RED_S_STAIN_CODE = "0150";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Alcian blue stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALCIAN_BLUE_STAIN_CODE = "0151";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Alcian blue with Periodic acid Schiff stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALCIAN_BLUE_WITH_PERIODIC_ACID_SCHIFF_STAIN_CODE = "0152";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for algorithm</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALGORITHM_CODE = "ALGM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for algorithm</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALGORITHM_L1_CODE = "ALGM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Anaerobic Culture</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANAEROBIC_CULTURE_CODE = "0051";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Animal Inoculation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANIMAL_INOCULATION_CODE = "0026";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Antibiotic sensitivity, disk</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANTIBIOTIC_SENSITIVITY_DISK_CODE = "0240";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Antibiotic sensitivity, disk</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANTIBIOTIC_SENSITIVITY_DISK_L1_CODE = "0240";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Anti-complement immunofluorescence (ACIF)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANTI_COMPLEMENT_IMMUNOFLUORESCENCE_ACIF_CODE = "0257";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API 20A</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_20A_CODE = "0076";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API 20C AUX</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_20C_AUX_CODE = "0077";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API 20E</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_20E_CODE = "0078";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API 20NE</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_20NE_CODE = "0079";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API 20 Strep</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_20_STREP_CODE = "0075";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API 50 CH</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_50_CH_CODE = "0080";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API An-IDENT</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_AN_IDENT_CODE = "0081";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API Coryne</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_CORYNE_CODE = "0082";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API Rapid 20E</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_RAPID_20E_CODE = "0083";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API Staph</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_STAPH_CODE = "0084";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for API ZYM</div>
	 * <!-- @formatter:on -->
	 */
	public static final String API_ZYM_CODE = "0085";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Argentaffin silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ARGENTAFFIN_SILVER_STAIN_CODE = "0154";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Argentaffin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ARGENTAFFIN_STAIN_CODE = "0153";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Atomic absorption spectrophotometry (AAS)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ATOMIC_ABSORPTION_SPECTROPHOTOMETRY_AAS_CODE = "0263";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Automated count</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUTOMATED_COUNT_CODE = "0047";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Azure-eosin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AZURE_EOSIN_STAIN_CODE = "0155";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BACTEC susceptibility test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BACTEC_SUSCEPTIBILITY_TEST_CODE = "0241";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BACTEC susceptibility test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BACTEC_SUSCEPTIBILITY_TEST_L1_CODE = "0241";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bacterial identification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BACTERIAL_IDENTIFICATION_CODE = "0086";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Basic Fuschin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BASIC_FUSCHIN_STAIN_CODE = "0156";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for bayesian calculation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BAYESIAN_CALCULATION_CODE = "BYCL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for bayesian calculation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BAYESIAN_CALCULATION_L2_CODE = "BYCL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bennhold stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BENNHOLD_STAIN_CODE = "0157";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bennhold's Congo red stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BENNHOLD_S_CONGO_RED_STAIN_CODE = "0158";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bielschowsky stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIELSCHOWSKY_STAIN_CODE = "0159";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bielschowsky's silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIELSCHOWSKY_S_SILVER_STAIN_CODE = "0160";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bioassay</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIOASSAY_CODE = "0025";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bioassay, qualitative</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIOASSAY_QUALITATIVE_CODE = "0031";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bioassay, quantitative</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIOASSAY_QUANTITATIVE_CODE = "0032";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bleach stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BLEACH_STAIN_CODE = "0161";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bodian stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BODIAN_STAIN_CODE = "0162";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Branched Chain DNA</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BRANCHED_CHAIN_DNA_CODE = "0120";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Brown-Brenn stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BROWN_BRENN_STAIN_CODE = "0163";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Buffered acidified plate agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BUFFERED_ACIDIFIED_PLATE_AGGLUTINATION_CODE = "0015";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Butyrate-esterase stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BUTYRATE_ESTERASE_STAIN_CODE = "0164";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Calcofluor white fluorescent stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CALCOFLUOR_WHITE_FLUORESCENT_STAIN_CODE = "0165";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Carbol-fuchsin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARBOL_FUCHSIN_STAIN_CODE = "0166";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Card agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARD_AGGLUTINATION_CODE = "0016";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Carmine stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARMINE_STAIN_CODE = "0167";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chemical method</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEMICAL_METHOD_CODE = "0033";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chicken embryo culture</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHICKEN_EMBRYO_CULTURE_CODE = "0052";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chromatography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHROMATOGRAPHY_CODE = "0038";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Churukian-Schenk stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHURUKIAN_SCHENK_STAIN_CODE = "0168";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Coagulation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COAGULATION_CODE = "0044";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Complement fixation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMPLEMENT_FIXATION_CODE = "0001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Computed axial tomography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMPUTED_AXIAL_TOMOGRAPHY_CODE = "0002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Congo red stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONGO_RED_STAIN_CODE = "0169";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cresyl echt violet stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CRESYL_ECHT_VIOLET_STAIN_CODE = "0170";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Crystal violet stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CRYSTAL_VIOLET_STAIN_CODE = "0171";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cytotoxicity</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CYTOTOXICITY_CODE = "0027";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Darkfield microscopy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DARKFIELD_MICROSCOPY_CODE = "0108";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Delayed secondary enrichment</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DELAYED_SECONDARY_ENRICHMENT_CODE = "0053";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for De Galantha stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DE_GALANTHA_STAIN_CODE = "0172";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dieterle silver impregnation stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIETERLE_SILVER_IMPREGNATION_STAIN_CODE = "0173";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Differential light absorption chemical test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIFFERENTIAL_LIGHT_ABSORPTION_CHEMICAL_TEST_CODE = "0034";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dipstick</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIPSTICK_CODE = "0035";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dipstick colorimetric laboratory test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIPSTICK_COLORIMETRIC_LABORATORY_TEST_CODE = "0036";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Disk dilution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISK_DILUTION_CODE = "0242";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Disk dilution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISK_DILUTION_L1_CODE = "0242";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Disk induction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISK_INDUCTION_L1_CODE = "0279";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for document verification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOCUMENT_VERIFICATION_L1_CODE = "VDOC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for electronic token verification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTRONIC_TOKEN_VERIFICATION_L1_CODE = "VTOKEN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electron microscopy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTRON_MICROSCOPY_CODE = "0109";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electron microscopy, negative stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTRON_MICROSCOPY_NEGATIVE_STAIN_CODE = "0111";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electron microscopy, thick section</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTRON_MICROSCOPY_THICK_SECTION_CODE = "0112";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electron microscopy, thin section</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTRON_MICROSCOPY_THIN_SECTION_CODE = "0113";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electron microscopy tomography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTRON_MICROSCOPY_TOMOGRAPHY_CODE = "0110";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTROPHORESIS_CODE = "0064";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electrophoresis, citrate agar</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTROPHORESIS_CITRATE_AGAR_CODE = "0066";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ELISA</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELISA_CODE = "0070";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ELISA, antigen capture</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELISA_ANTIGEN_CAPTURE_CODE = "0071";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ELISA, avidin biotin peroxidase complex</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELISA_AVIDIN_BIOTIN_PEROXIDASE_COMPLEX_CODE = "0072";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ELISA, peroxidase-antiperoxidase</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELISA_PEROXIDASE_ANTIPEROXIDASE_CODE = "0074";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Embryo infective dose 50</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMBRYO_INFECTIVE_DOSE_50_CODE = "0028";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Embryo lethal dose 50</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMBRYO_LETHAL_DOSE_50_CODE = "0029";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for EMIT</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMIT_CODE = "0250";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Equilibrium dialysis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EQUILIBRIUM_DIALYSIS_CODE = "0255";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Fite-Farco stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FITE_FARCO_STAIN_CODE = "0174";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Flocculation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FLOCCULATION_CODE = "0139";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Flow cytometry (FC)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FLOW_CYTOMETRY_FC_CODE = "0251";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Fluorescence polarization immunoassay (FPIA)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FLUORESCENCE_POLARIZATION_IMMUNOASSAY_FPIA_CODE = "0253";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Fontana-Masson silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FONTANA_MASSON_SILVER_STAIN_CODE = "0175";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Fouchet stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FOUCHET_STAIN_CODE = "0176";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gas chromatography (GC)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GAS_CHROMATOGRAPHY_GC_CODE = "0265";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gas liquid chromatography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GAS_LIQUID_CHROMATOGRAPHY_CODE = "0040";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GC/MS</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GC_MS_CODE = "0258";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GeneticObservationMethod</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENETICOBSERVATIONMETHOD_CODE = "_GeneticObservationMethod";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for global introspection</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GLOBAL_INTROSPECTION_CODE = "GINT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for global introspection</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GLOBAL_INTROSPECTION_L1_CODE = "GINT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gomori methenamine silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GOMORI_METHENAMINE_SILVER_STAIN_CODE = "0178";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gomori stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GOMORI_STAIN_CODE = "0177";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gomori-Wheatly trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GOMORI_WHEATLY_TRICHROME_STAIN_CODE = "0179";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gradient Strip</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRADIENT_STRIP_L1_CODE = "0275";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gridley stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRIDLEY_STAIN_CODE = "0180";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Grimelius silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRIMELIUS_SILVER_STAIN_CODE = "0181";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Grocott methenamine silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GROCOTT_METHENAMINE_SILVER_STAIN_CODE = "0183";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Grocott stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GROCOTT_STAIN_CODE = "0182";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hale's colloidal ferric oxide stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HALE_S_COLLOIDAL_FERRIC_OXIDE_STAIN_CODE = "0184";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hale's colloidal iron stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HALE_S_COLLOIDAL_IRON_STAIN_CODE = "0185";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hansel stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HANSEL_STAIN_CODE = "0186";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Harris regressive hematoxylin and eosin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HARRIS_REGRESSIVE_HEMATOXYLIN_AND_EOSIN_STAIN_CODE = "0187";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hemagglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEMAGGLUTINATION_CODE = "0017";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hemagglutination inhibition</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEMAGGLUTINATION_INHIBITION_CODE = "0018";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hematoxylin and eosin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEMATOXYLIN_AND_EOSIN_STAIN_CODE = "0188";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Highman stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HIGHMAN_STAIN_CODE = "0189";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for High performance liquid chromatography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HIGH_PERFORMANCE_LIQUID_CHROMATOGRAPHY_CODE = "0041";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for HLAR agar test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HLAR_AGAR_TEST_CODE = "0003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Holzer stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOLZER_STAIN_CODE = "0190";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hybridization Protection Assay</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HYBRIDIZATION_PROTECTION_ASSAY_CODE = "0121";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ICP/MS</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ICP_MS_CODE = "0269";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IgE immunoassay antibody</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IGE_IMMUNOASSAY_ANTIBODY_CODE = "0260";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immune blot</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNE_BLOT_CODE = "0122";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immune precipitation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNE_PRECIPITATION_CODE = "0140";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immune stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNE_STAIN_CODE = "0095";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoassay</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOASSAY_CODE = "0101";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoassay, qualitative, multiple step</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOASSAY_QUALITATIVE_MULTIPLE_STEP_CODE = "0102";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoassay, qualitative, single step</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOASSAY_QUALITATIVE_SINGLE_STEP_CODE = "0103";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoassay, semi-quantitative, multiple step</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOASSAY_SEMI_QUANTITATIVE_MULTIPLE_STEP_CODE = "0105";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoassay, semi-quantitative, single step</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOASSAY_SEMI_QUANTITATIVE_SINGLE_STEP_CODE = "0106";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunochemiluminescence</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOCHEMILUMINESCENCE_CODE = "0267";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoelectrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOELECTROPHORESIS_CODE = "0067";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunofixation electrophoresis (IFE)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOFIXATION_ELECTROPHORESIS_IFE_CODE = "0254";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunofluorescent antibody, direct</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOFLUORESCENT_ANTIBODY_DIRECT_CODE = "0096";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunofluorescent antibody, indirect</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOFLUORESCENT_ANTIBODY_INDIRECT_CODE = "0097";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoperoxidase, Avidin-Biotin Complex</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOPEROXIDASE_AVIDIN_BIOTIN_COMPLEX_CODE = "0098";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoperoxidase, Peroxidase anti-peroxidase complex</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOPEROXIDASE_PEROXIDASE_ANTI_PEROXIDASE_COMPLEX_CODE = "0099";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoperoxidase, Protein A-peroxidase complex</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNOPEROXIDASE_PROTEIN_A_PEROXIDASE_COMPLEX_CODE = "0100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunoradiometric assay (IRMA)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNORADIOMETRIC_ASSAY_IRMA_CODE = "0270";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for In-situ hybridization</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IN_SITU_HYBRIDIZATION_CODE = "0123";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ion selective electrode (ISE)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ION_SELECTIVE_ELECTRODE_ISE_CODE = "0264";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Iron hematoxylin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRON_HEMATOXYLIN_STAIN_CODE = "0191";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Isoelectric focusing (IEF)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ISOELECTRIC_FOCUSING_IEF_CODE = "0266";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Jones methenamine silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JONES_METHENAMINE_SILVER_STAIN_CODE = "0193";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Jones stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JONES_STAIN_CODE = "0192";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Kinetic ELISA</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KINETIC_ELISA_CODE = "0073";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Kleihauer-Betke acid elution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KLEIHAUER_BETKE_ACID_ELUTION_CODE = "0256";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Kossa stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KOSSA_STAIN_CODE = "0194";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Latex agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LATEX_AGGLUTINATION_CODE = "0019";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Lawson-Van Gieson stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LAWSON_VAN_GIESON_STAIN_CODE = "0195";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ligase Chain Reaction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LIGASE_CHAIN_REACTION_CODE = "0124";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ligation Activated Transcription</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LIGATION_ACTIVATED_TRANSCRIPTION_CODE = "0125";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Liquid Chromatography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LIQUID_CHROMATOGRAPHY_CODE = "0042";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Loeffler methylene blue stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LOEFFLER_METHYLENE_BLUE_STAIN_CODE = "0196";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Luxol fast blue with cresyl violet stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LUXOL_FAST_BLUE_WITH_CRESYL_VIOLET_STAIN_CODE = "0197";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Luxol fast blue with Periodic acid-Schiff stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LUXOL_FAST_BLUE_WITH_PERIODIC_ACID_SCHIFF_STAIN_CODE = "0198";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Lymphocyte Microcytotoxicity Assay</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LYMPHOCYTE_MICROCYTOTOXICITY_ASSAY_CODE = "0261";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MacNeal's tetrachrome blood stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MACNEAL_S_TETRACHROME_BLOOD_STAIN_CODE = "0199";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Macroscopic observation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MACROSCOPIC_OBSERVATION_CODE = "0004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Magnetic resonance</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MAGNETIC_RESONANCE_CODE = "0005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mallory-Heidenhain stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MALLORY_HEIDENHAIN_STAIN_CODE = "0200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Manual cell count</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MANUAL_CELL_COUNT_CODE = "0048";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Masson trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MASSON_TRICHROME_STAIN_CODE = "0201";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mayers progressive hematoxylin and eosin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MAYERS_PROGRESSIVE_HEMATOXYLIN_AND_EOSIN_STAIN_CODE = "0203";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mayer mucicarmine stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MAYER_MUCICARMINE_STAIN_CODE = "0202";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for May-Grunwald Giemsa stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MAY_GRUNWALD_GIEMSA_STAIN_CODE = "0204";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Methyl green pyronin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String METHYL_GREEN_PYRONIN_STAIN_CODE = "0206";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Methyl green stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String METHYL_GREEN_STAIN_CODE = "0205";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Microaerophilic Culture</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MICROAEROPHILIC_CULTURE_CODE = "0054";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Microparticle enzyme immunoassay (MEIA)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MICROPARTICLE_ENZYME_IMMUNOASSAY_MEIA_CODE = "0268";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Microscopy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MICROSCOPY_CODE = "0107";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Microscopy, Light</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MICROSCOPY_LIGHT_CODE = "0114";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Milk ring test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MILK_RING_TEST_CODE = "0141";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum bactericidal concentration test, macrodilution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_BACTERICIDAL_CONCENTRATION_TEST_MACRODILUTION_CODE = "0243";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum bactericidal concentration test, microdilution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_BACTERICIDAL_CONCENTRATION_TEST_MICRODILUTION_CODE = "0244";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum Inhibitory Concentration</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_INHIBITORY_CONCENTRATION_CODE = "0272";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum Inhibitory Concentration</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_INHIBITORY_CONCENTRATION_L1_CODE = "0272";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum Inhibitory Concentration, macrodilution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_INHIBITORY_CONCENTRATION_MACRODILUTION_CODE = "0245";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum Inhibitory Concentration, macrodilution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_INHIBITORY_CONCENTRATION_MACRODILUTION_L1_CODE = "0245";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum Inhibitory Concentration, microdilution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_INHIBITORY_CONCENTRATION_MICRODILUTION_CODE = "0246";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum Inhibitory Concentration, microdilution</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_INHIBITORY_CONCENTRATION_MICRODILUTION_L1_CODE = "0246";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum Lethal Concentration (MLC)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_LETHAL_CONCENTRATION_MLC_CODE = "0275a";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Minimum Lethal Concentration (MLC)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINIMUM_LETHAL_CONCENTRATION_MLC_L1_CODE = "0275a";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for mini VIDAS</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MINI_VIDAS_CODE = "0087";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Modified Gomori-Wheatly trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODIFIED_GOMORI_WHEATLY_TRICHROME_STAIN_CODE = "0207";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Modified Masson trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODIFIED_MASSON_TRICHROME_STAIN_CODE = "0208";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Modified trichrome stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODIFIED_TRICHROME_STAIN_CODE = "0209";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Morphometry</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MORPHOMETRY_CODE = "0006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mouse intercerebral inoculation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOUSE_INTERCEREBRAL_INOCULATION_CODE = "0030";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Movat pentachrome stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOVAT_PENTACHROME_STAIN_CODE = "0210";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mucicarmine stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUCICARMINE_STAIN_CODE = "0211";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nephelometry</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEPHELOMETRY_CODE = "0259";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neutral red stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUTRAL_RED_STAIN_CODE = "0212";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Night blue stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NIGHT_BLUE_STAIN_CODE = "0213";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Non-specific esterase stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NON_SPECIFIC_ESTERASE_STAIN_CODE = "0214";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nucleic Acid Probe</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEIC_ACID_PROBE_CODE = "0126";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nucleic acid probe with amplification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEIC_ACID_PROBE_WITH_AMPLIFICATION_CODE = "0128";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nucleic acid probe with target amplification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEIC_ACID_PROBE_WITH_TARGET_AMPLIFICATION_CODE = "0129";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nucleic acid reverse transcription</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEIC_ACID_REVERSE_TRANSCRIPTION_CODE = "0130";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nucleic Acid Sequence Based Analysis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEIC_ACID_SEQUENCE_BASED_ANALYSIS_CODE = "0131";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oil red-O stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OIL_RED_O_STAIN_CODE = "0215";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orcein stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORCEIN_STAIN_CODE = "0216";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PCR</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PCR_L1_CODE = "PCR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Perls' stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERLS_STAIN_CODE = "0217";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Phage susceptibility typing</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHAGE_SUSCEPTIBILITY_TYPING_CODE = "0088";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Phosphotungstic acid-hematoxylin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHOSPHOTUNGSTIC_ACID_HEMATOXYLIN_STAIN_CODE = "0218";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Photo optical clot detection</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHOTO_OPTICAL_CLOT_DETECTION_CODE = "0271";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Platelet count, Rees-Ecker</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLATELET_COUNT_REES_ECKER_CODE = "0049";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plate agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLATE_AGGLUTINATION_CODE = "0020";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Polarizing light microscopy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POLARIZING_LIGHT_MICROSCOPY_CODE = "0115";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Polyacrylamide gel electrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POLYACRYLAMIDE_GEL_ELECTROPHORESIS_CODE = "0068";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Polymerase chain reaction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POLYMERASE_CHAIN_REACTION_CODE = "0132";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Positron emission tomography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POSITRON_EMISSION_TOMOGRAPHY_CODE = "0007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Potassium ferrocyanide stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POTASSIUM_FERROCYANIDE_STAIN_CODE = "0219";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Precipitin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRECIPITIN_CODE = "0142";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Protein A affinity chromatography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROTEIN_A_AFFINITY_CHROMATOGRAPHY_CODE = "0043";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prussian blue stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRUSSIAN_BLUE_STAIN_CODE = "0220";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Putchler modified Bennhold stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PUTCHLER_MODIFIED_BENNHOLD_STAIN_CODE = "0221";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quad-FERM+</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUAD_FERM_CODE = "0089";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quantitative microbial culture, cup</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUANTITATIVE_MICROBIAL_CULTURE_CUP_CODE = "0055";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quantitative microbial culture, droplet</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUANTITATIVE_MICROBIAL_CULTURE_DROPLET_CODE = "0056";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quantitative microbial culture, filter paper</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUANTITATIVE_MICROBIAL_CULTURE_FILTER_PAPER_CODE = "0057";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quantitative microbial culture, pad culture</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUANTITATIVE_MICROBIAL_CULTURE_PAD_CULTURE_CODE = "0058";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quantitative microbial culture, pour plate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUANTITATIVE_MICROBIAL_CULTURE_POUR_PLATE_CODE = "0059";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quantitative microbial culture, surface streak</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUANTITATIVE_MICROBIAL_CULTURE_SURFACE_STREAK_CODE = "0060";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quinacrine fluorescent stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUINACRINE_FLUORESCENT_STAIN_CODE = "0222";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Q-Beta Replicase or probe amplification category method</div>
	 * <!-- @formatter:on -->
	 */
	public static final String Q_BETA_REPLICASE_OR_PROBE_AMPLIFICATION_CATEGORY_METHOD_CODE = "0133";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radial immunodiffusion (RID)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIAL_IMMUNODIFFUSION_RID_CODE = "0252";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radioimmunoassay</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOIMMUNOASSAY_CODE = "0104";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for RAPIDEC Staph</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RAPIDEC_STAPH_CODE = "0090";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rapid agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RAPID_AGGLUTINATION_CODE = "0021";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for RBC agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RBC_AGGLUTINATION_CODE = "0022";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Refractometric</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REFRACTOMETRIC_CODE = "0248";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for registry verification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REGISTRY_VERIFICATION_L1_CODE = "VREG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Restriction Fragment Length Polymorphism</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RESTRICTION_FRAGMENT_LENGTH_POLYMORPHISM_CODE = "0134";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Reticulin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RETICULIN_STAIN_CODE = "0223";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rhodamine stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RHODAMINE_STAIN_CODE = "0224";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rivanol agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RIVANOL_AGGLUTINATION_CODE = "0023";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Safranin stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SAFRANIN_STAIN_CODE = "0225";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SAMHSA confirmation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SAMHSA_CONFIRMATION_CODE = "0008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SAMHSA screening</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SAMHSA_SCREENING_CODE = "0009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Scanning electron microscopy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SCANNING_ELECTRON_MICROSCOPY_CODE = "0116";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Schmorl stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SCHMORL_STAIN_CODE = "0226";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Seiver-Munger stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SEIVER_MUNGER_STAIN_CODE = "0227";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Serum bactericidal titer</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SERUM_BACTERICIDAL_TITER_L1_CODE = "0277";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Serum Neutralization</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SERUM_NEUTRALIZATION_CODE = "0010";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SILVER_STAIN_CODE = "0228";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Slow Mycobacteria Susceptibility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SLOW_MYCOBACTERIA_SUSCEPTIBILITY_L1_CODE = "0276";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Somatic Cell culture</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOMATIC_CELL_CULTURE_CODE = "0061";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Southern Blot</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOUTHERN_BLOT_CODE = "0135";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Specific esterase stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPECIFIC_ESTERASE_STAIN_CODE = "0229";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Spectrophotometry</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPECTROPHOTOMETRY_CODE = "0262";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Staphaurex</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STAPHAUREX_CODE = "0091";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Starch gel electrophoresis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STARCH_GEL_ELECTROPHORESIS_CODE = "0069";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Steiner silver stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEINER_SILVER_STAIN_CODE = "0230";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Strand Displacement Amplification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STRAND_DISPLACEMENT_AMPLIFICATION_CODE = "0136";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sudan III stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUDAN_III_STAIN_CODE = "0231";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sudan IVI stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUDAN_IVI_STAIN_CODE = "0232";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sulfated alcian blue stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SULFATED_ALCIAN_BLUE_STAIN_CODE = "0233";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Supravital stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUPRAVITAL_STAIN_CODE = "0234";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Susceptibility Testing</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUSCEPTIBILITY_TESTING_CODE = "0280";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Test strip</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TEST_STRIP_CODE = "0037";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Thin layer chromatography (TLC)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THIN_LAYER_CHROMATOGRAPHY_TLC_CODE = "0249";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Thioflavine-S stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THIOFLAVINE_S_STAIN_CODE = "0235";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Three micron Giemsa stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THREE_MICRON_GIEMSA_STAIN_CODE = "0236";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for 3 Self-Sustaining Sequence Replication</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THREE_SELF_SUSTAINING_SEQUENCE_REPLICATION_CODE = "0119";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tilt tube coagulation time</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TILT_TUBE_COAGULATION_TIME_CODE = "0045";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tilt tube reptilase induced coagulation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TILT_TUBE_REPTILASE_INDUCED_COAGULATION_CODE = "0046";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Titration</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TITRATION_CODE = "0011";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transcription Mediated Amplification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSCRIPTION_MEDIATED_AMPLIFICATION_CODE = "0137";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transmission electron microscopy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSMISSION_ELECTRON_MICROSCOPY_CODE = "0117";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transparent tape direct examination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSPARENT_TAPE_DIRECT_EXAMINATION_CODE = "0118";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tube agglutination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TUBE_AGGLUTINATION_CODE = "0024";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Turbidometric</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TURBIDOMETRIC_CODE = "0247";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ultrasound</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ULTRASOUND_CODE = "0012";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vassar-Culling stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VASSAR_CULLING_STAIN_CODE = "0237";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for VerificationMethod</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VERIFICATIONMETHOD_CODE = "_VerificationMethod";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for VIDAS</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VIDAS_CODE = "0092";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Viral Genotype Susceptibility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VIRAL_GENOTYPE_SUSCEPTIBILITY_L1_CODE = "0273";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Viral Phenotype Susceptibility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VIRAL_PHENOTYPE_SUSCEPTIBILITY_L1_CODE = "0274";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vital Stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VITAL_STAIN_CODE = "0238";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vitek</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VITEK_CODE = "0093";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for VITEK 2</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VITEK_2_CODE = "0094";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for voice-based verification</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VOICE_BASED_VERIFICATION_L1_CODE = "VVOICE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for von Kossa stain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VON_KOSSA_STAIN_CODE = "0239";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Western Blot</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WESTERN_BLOT_CODE = "0138";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for X-ray crystallography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String X_RAY_CRYSTALLOGRAPHY_CODE = "0013";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.14079";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ObservationMethod";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ObservationMethod getEnum(String code) {
		for (final ObservationMethod x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(ObservationMethod.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final ObservationMethod x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Machine interpretable and (inside this class) unique code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	 * <!-- @formatter:on -->
	 */
	private String code;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 * <!-- @formatter:on -->
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	ObservationMethod(String code, String codeSystem, String displayName, String displayNameEn,
			String displayNameDe, String displayNameFr, String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set name.</div>
	 * <div class="de">Liefert den Value Set Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
