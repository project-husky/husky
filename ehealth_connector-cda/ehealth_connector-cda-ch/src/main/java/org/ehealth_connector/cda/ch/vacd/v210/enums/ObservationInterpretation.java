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
package org.ehealth_connector.cda.ch.vacd.v210.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en"><p>    <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>One or more codes specifying a rough qualitative interpretation of the observation, such as "normal", "abnormal", "below normal", "change up", "resistant", "susceptible", etc.</p><p>    <i>Discussion:</i> These interpretation codes are sometimes called "abnormal flags", however, the judgment of normalcy is just one of the common rough interpretations, and is often not relevant. For example, the susceptibility interpretations are not about "normalcy", and for any observation of a pathologic condition, it does not make sense to state the normalcy, since pathologic conditions are never considered "normal."</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ObservationInterpretation implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Abnormal</div>
	 * <!-- @formatter:on -->
	 */
	ABNORMAL_L1("A", "2.16.840.1.113883.5.83", "Abnormal", "Abnormal", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">above high threshold</div>
	 * <!-- @formatter:on -->
	 */
	ABOVE_HIGH_THRESHOLD_L1("HX", "2.16.840.1.113883.5.83", "above high threshold",
			"above high threshold", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Anti-complementary substances present</div>
	 * <!-- @formatter:on -->
	 */
	ANTI_COMPLEMENTARY_SUBSTANCES_PRESENT_L1("AC", "2.16.840.1.113883.5.83",
			"Anti-complementary substances present", "Anti-complementary substances present",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">below low threshold</div>
	 * <!-- @formatter:on -->
	 */
	BELOW_LOW_THRESHOLD_L1("LX", "2.16.840.1.113883.5.83", "below low threshold",
			"below low threshold", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Better</div>
	 * <!-- @formatter:on -->
	 */
	BETTER_L1("B", "2.16.840.1.113883.5.83", "Better", "Better", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Carrier</div>
	 * <!-- @formatter:on -->
	 */
	CARRIER_L1("CAR", "2.16.840.1.113883.5.83", "Carrier", "Carrier", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Critical abnormal</div>
	 * <!-- @formatter:on -->
	 */
	CRITICAL_ABNORMAL_L2("AA", "2.16.840.1.113883.5.83", "Critical abnormal", "Critical abnormal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Critical high</div>
	 * <!-- @formatter:on -->
	 */
	CRITICAL_HIGH_L3("HH", "2.16.840.1.113883.5.83", "Critical high", "Critical high",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Critical high</div>
	 * <!-- @formatter:on -->
	 */
	CRITICAL_HIGH_L4("HH", "2.16.840.1.113883.5.83", "Critical high", "Critical high",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Critical low</div>
	 * <!-- @formatter:on -->
	 */
	CRITICAL_LOW_L3("LL", "2.16.840.1.113883.5.83", "Critical low", "Critical low", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Critical low</div>
	 * <!-- @formatter:on -->
	 */
	CRITICAL_LOW_L4("LL", "2.16.840.1.113883.5.83", "Critical low", "Critical low", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cytotoxic substance present</div>
	 * <!-- @formatter:on -->
	 */
	CYTOTOXIC_SUBSTANCE_PRESENT_L1("TOX", "2.16.840.1.113883.5.83", "Cytotoxic substance present",
			"Cytotoxic substance present", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Detected</div>
	 * <!-- @formatter:on -->
	 */
	DETECTED_L2("DET", "2.16.840.1.113883.5.83", "Detected", "Detected", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Equivocal</div>
	 * <!-- @formatter:on -->
	 */
	EQUIVOCAL_L2("E", "2.16.840.1.113883.5.83", "Equivocal", "Equivocal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Expected</div>
	 * <!-- @formatter:on -->
	 */
	EXPECTED_L1("EXP", "2.16.840.1.113883.5.83", "Expected", "Expected", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GeneticObservationInterpretation</div>
	 * <!-- @formatter:on -->
	 */
	GENETICOBSERVATIONINTERPRETATION("_GeneticObservationInterpretation", "2.16.840.1.113883.5.83",
			"GeneticObservationInterpretation", "GeneticObservationInterpretation", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">High</div>
	 * <!-- @formatter:on -->
	 */
	HIGH_L2("H", "2.16.840.1.113883.5.83", "High", "High", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hold for Medical Review</div>
	 * <!-- @formatter:on -->
	 */
	HOLD_FOR_MEDICAL_REVIEW("HM", "2.16.840.1.113883.5.83", "Hold for Medical Review",
			"Hold for Medical Review", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Indeterminate</div>
	 * <!-- @formatter:on -->
	 */
	INDETERMINATE_L1("IND", "2.16.840.1.113883.5.83", "Indeterminate", "Indeterminate",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insufficient evidence</div>
	 * <!-- @formatter:on -->
	 */
	INSUFFICIENT_EVIDENCE_L1("IE", "2.16.840.1.113883.5.83", "Insufficient evidence",
			"Insufficient evidence", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intermediate</div>
	 * <!-- @formatter:on -->
	 */
	INTERMEDIATE_L1("I", "2.16.840.1.113883.5.83", "Intermediate", "Intermediate", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Interpretation qualifiers in separate OBX segments</div>
	 * <!-- @formatter:on -->
	 */
	INTERPRETATION_QUALIFIERS_IN_SEPARATE_OBX_SEGMENTS("OBX", "2.16.840.1.113883.5.83",
			"Interpretation qualifiers in separate OBX segments",
			"Interpretation qualifiers in separate OBX segments", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Low</div>
	 * <!-- @formatter:on -->
	 */
	LOW_L2("L", "2.16.840.1.113883.5.83", "Low", "Low", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">moderately susceptible</div>
	 * <!-- @formatter:on -->
	 */
	MODERATELY_SUSCEPTIBLE_L1("MS", "2.16.840.1.113883.5.83", "moderately susceptible",
			"moderately susceptible", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Negative</div>
	 * <!-- @formatter:on -->
	 */
	NEGATIVE_L1("NEG", "2.16.840.1.113883.5.83", "Negative", "Negative", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Non-reactive</div>
	 * <!-- @formatter:on -->
	 */
	NON_REACTIVE_L1("NR", "2.16.840.1.113883.5.83", "Non-reactive", "Non-reactive", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Non-susceptible</div>
	 * <!-- @formatter:on -->
	 */
	NON_SUSCEPTIBLE_L1("NS", "2.16.840.1.113883.5.83", "Non-susceptible", "Non-susceptible",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Normal</div>
	 * <!-- @formatter:on -->
	 */
	NORMAL_L1("N", "2.16.840.1.113883.5.83", "Normal", "Normal", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Not detected</div>
	 * <!-- @formatter:on -->
	 */
	NOT_DETECTED_L2("ND", "2.16.840.1.113883.5.83", "Not detected", "Not detected", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">No CLSI defined breakpoint</div>
	 * <!-- @formatter:on -->
	 */
	NO_CLSI_DEFINED_BREAKPOINT_L1("NCL", "2.16.840.1.113883.5.83", "No CLSI defined breakpoint",
			"No CLSI defined breakpoint", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ObservationInterpretationChange</div>
	 * <!-- @formatter:on -->
	 */
	OBSERVATIONINTERPRETATIONCHANGE("_ObservationInterpretationChange", "2.16.840.1.113883.5.83",
			"ObservationInterpretationChange", "ObservationInterpretationChange", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ObservationInterpretationDetection</div>
	 * <!-- @formatter:on -->
	 */
	OBSERVATIONINTERPRETATIONDETECTION("ObservationInterpretationDetection",
			"2.16.840.1.113883.5.83", "ObservationInterpretationDetection",
			"ObservationInterpretationDetection", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ObservationInterpretationExceptions</div>
	 * <!-- @formatter:on -->
	 */
	OBSERVATIONINTERPRETATIONEXCEPTIONS("_ObservationInterpretationExceptions",
			"2.16.840.1.113883.5.83", "ObservationInterpretationExceptions",
			"ObservationInterpretationExceptions", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ObservationInterpretationExpectation</div>
	 * <!-- @formatter:on -->
	 */
	OBSERVATIONINTERPRETATIONEXPECTATION("ObservationInterpretationExpectation",
			"2.16.840.1.113883.5.83", "ObservationInterpretationExpectation",
			"ObservationInterpretationExpectation", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ObservationInterpretationNormality</div>
	 * <!-- @formatter:on -->
	 */
	OBSERVATIONINTERPRETATIONNORMALITY("_ObservationInterpretationNormality",
			"2.16.840.1.113883.5.83", "ObservationInterpretationNormality",
			"ObservationInterpretationNormality", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ObservationInterpretationSusceptibility</div>
	 * <!-- @formatter:on -->
	 */
	OBSERVATIONINTERPRETATIONSUSCEPTIBILITY("_ObservationInterpretationSusceptibility",
			"2.16.840.1.113883.5.83", "ObservationInterpretationSusceptibility",
			"ObservationInterpretationSusceptibility", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Off scale high</div>
	 * <!-- @formatter:on -->
	 */
	OFF_SCALE_HIGH_L1(">", "2.16.840.1.113883.5.83", "Off scale high", "Off scale high",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Off scale low</div>
	 * <!-- @formatter:on -->
	 */
	OFF_SCALE_LOW_L1("<", "2.16.840.1.113883.5.83", "Off scale low", "Off scale low", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">outside threshold</div>
	 * <!-- @formatter:on -->
	 */
	OUTSIDE_THRESHOLD("EX", "2.16.840.1.113883.5.83", "outside threshold", "outside threshold",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Positive</div>
	 * <!-- @formatter:on -->
	 */
	POSITIVE_L1("POS", "2.16.840.1.113883.5.83", "Positive", "Positive", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Quality control failure</div>
	 * <!-- @formatter:on -->
	 */
	QUALITY_CONTROL_FAILURE_L1("QCF", "2.16.840.1.113883.5.83", "Quality control failure",
			"Quality control failure", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Reactive</div>
	 * <!-- @formatter:on -->
	 */
	REACTIVE_L1("RR", "2.16.840.1.113883.5.83", "Reactive", "Reactive", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ReactivityObservationInterpretation</div>
	 * <!-- @formatter:on -->
	 */
	REACTIVITYOBSERVATIONINTERPRETATION("ReactivityObservationInterpretation",
			"2.16.840.1.113883.5.83", "ReactivityObservationInterpretation",
			"ReactivityObservationInterpretation", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Resistant</div>
	 * <!-- @formatter:on -->
	 */
	RESISTANT_L1("R", "2.16.840.1.113883.5.83", "Resistant", "Resistant", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Significantly high</div>
	 * <!-- @formatter:on -->
	 */
	SIGNIFICANTLY_HIGH_L3("H>", "2.16.840.1.113883.5.83", "Significantly high",
			"Significantly high", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Significantly low</div>
	 * <!-- @formatter:on -->
	 */
	SIGNIFICANTLY_LOW_L3("L<", "2.16.840.1.113883.5.83", "Significantly low", "Significantly low",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Significant change down</div>
	 * <!-- @formatter:on -->
	 */
	SIGNIFICANT_CHANGE_DOWN_L1("D", "2.16.840.1.113883.5.83", "Significant change down",
			"Significant change down", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Significant change up</div>
	 * <!-- @formatter:on -->
	 */
	SIGNIFICANT_CHANGE_UP_L1("U", "2.16.840.1.113883.5.83", "Significant change up",
			"Significant change up", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Susceptible-dose dependent</div>
	 * <!-- @formatter:on -->
	 */
	SUSCEPTIBLE_DOSE_DEPENDENT_L2("SDD", "2.16.840.1.113883.5.83", "Susceptible-dose dependent",
			"Susceptible-dose dependent", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Susceptible</div>
	 * <!-- @formatter:on -->
	 */
	SUSCEPTIBLE_L1("S", "2.16.840.1.113883.5.83", "Susceptible", "Susceptible", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Synergy - resistant</div>
	 * <!-- @formatter:on -->
	 */
	SYNERGY_RESISTANT_L2("SYN-R", "2.16.840.1.113883.5.83", "Synergy - resistant",
			"Synergy - resistant", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Synergy - susceptible</div>
	 * <!-- @formatter:on -->
	 */
	SYNERGY_SUSCEPTIBLE_L2("SYN-S", "2.16.840.1.113883.5.83", "Synergy - susceptible",
			"Synergy - susceptible", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Unexpected</div>
	 * <!-- @formatter:on -->
	 */
	UNEXPECTED_L1("UNE", "2.16.840.1.113883.5.83", "Unexpected", "Unexpected", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">very susceptible</div>
	 * <!-- @formatter:on -->
	 */
	VERY_SUSCEPTIBLE_L1("VS", "2.16.840.1.113883.5.83", "very susceptible", "very susceptible",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Weakly reactive</div>
	 * <!-- @formatter:on -->
	 */
	WEAKLY_REACTIVE_L2("WR", "2.16.840.1.113883.5.83", "Weakly reactive", "Weakly reactive",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Worse</div>
	 * <!-- @formatter:on -->
	 */
	WORSE_L1("W", "2.16.840.1.113883.5.83", "Worse", "Worse", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Abnormal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ABNORMAL_L1_CODE = "A";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for above high threshold</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ABOVE_HIGH_THRESHOLD_L1_CODE = "HX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Anti-complementary substances present</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANTI_COMPLEMENTARY_SUBSTANCES_PRESENT_L1_CODE = "AC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for below low threshold</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BELOW_LOW_THRESHOLD_L1_CODE = "LX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Better</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETTER_L1_CODE = "B";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Carrier</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARRIER_L1_CODE = "CAR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Critical abnormal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CRITICAL_ABNORMAL_L2_CODE = "AA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Critical high</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CRITICAL_HIGH_L3_CODE = "HH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Critical high</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CRITICAL_HIGH_L4_CODE = "HH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Critical low</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CRITICAL_LOW_L3_CODE = "LL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Critical low</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CRITICAL_LOW_L4_CODE = "LL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cytotoxic substance present</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CYTOTOXIC_SUBSTANCE_PRESENT_L1_CODE = "TOX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Detected</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DETECTED_L2_CODE = "DET";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Equivocal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EQUIVOCAL_L2_CODE = "E";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Expected</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXPECTED_L1_CODE = "EXP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GeneticObservationInterpretation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENETICOBSERVATIONINTERPRETATION_CODE = "_GeneticObservationInterpretation";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for High</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HIGH_L2_CODE = "H";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hold for Medical Review</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOLD_FOR_MEDICAL_REVIEW_CODE = "HM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Indeterminate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INDETERMINATE_L1_CODE = "IND";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insufficient evidence</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSUFFICIENT_EVIDENCE_L1_CODE = "IE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intermediate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTERMEDIATE_L1_CODE = "I";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Interpretation qualifiers in separate OBX segments</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTERPRETATION_QUALIFIERS_IN_SEPARATE_OBX_SEGMENTS_CODE = "OBX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Low</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LOW_L2_CODE = "L";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for moderately susceptible</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODERATELY_SUSCEPTIBLE_L1_CODE = "MS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Negative</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEGATIVE_L1_CODE = "NEG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Non-reactive</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NON_REACTIVE_L1_CODE = "NR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Non-susceptible</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NON_SUSCEPTIBLE_L1_CODE = "NS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Normal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NORMAL_L1_CODE = "N";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Not detected</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NOT_DETECTED_L2_CODE = "ND";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for No CLSI defined breakpoint</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NO_CLSI_DEFINED_BREAKPOINT_L1_CODE = "NCL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ObservationInterpretationChange</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSERVATIONINTERPRETATIONCHANGE_CODE = "_ObservationInterpretationChange";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ObservationInterpretationDetection</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSERVATIONINTERPRETATIONDETECTION_CODE = "ObservationInterpretationDetection";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ObservationInterpretationExceptions</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSERVATIONINTERPRETATIONEXCEPTIONS_CODE = "_ObservationInterpretationExceptions";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ObservationInterpretationExpectation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSERVATIONINTERPRETATIONEXPECTATION_CODE = "ObservationInterpretationExpectation";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ObservationInterpretationNormality</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSERVATIONINTERPRETATIONNORMALITY_CODE = "_ObservationInterpretationNormality";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ObservationInterpretationSusceptibility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSERVATIONINTERPRETATIONSUSCEPTIBILITY_CODE = "_ObservationInterpretationSusceptibility";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Off scale high</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OFF_SCALE_HIGH_L1_CODE = ">";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Off scale low</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OFF_SCALE_LOW_L1_CODE = "<";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for outside threshold</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OUTSIDE_THRESHOLD_CODE = "EX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Positive</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POSITIVE_L1_CODE = "POS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Quality control failure</div>
	 * <!-- @formatter:on -->
	 */
	public static final String QUALITY_CONTROL_FAILURE_L1_CODE = "QCF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Reactive</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REACTIVE_L1_CODE = "RR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ReactivityObservationInterpretation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REACTIVITYOBSERVATIONINTERPRETATION_CODE = "ReactivityObservationInterpretation";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Resistant</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RESISTANT_L1_CODE = "R";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Significantly high</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIGNIFICANTLY_HIGH_L3_CODE = "H>";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Significantly low</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIGNIFICANTLY_LOW_L3_CODE = "L<";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Significant change down</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIGNIFICANT_CHANGE_DOWN_L1_CODE = "D";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Significant change up</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIGNIFICANT_CHANGE_UP_L1_CODE = "U";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Susceptible-dose dependent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUSCEPTIBLE_DOSE_DEPENDENT_L2_CODE = "SDD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Susceptible</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUSCEPTIBLE_L1_CODE = "S";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Synergy - resistant</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SYNERGY_RESISTANT_L2_CODE = "SYN-R";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Synergy - susceptible</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SYNERGY_SUSCEPTIBLE_L2_CODE = "SYN-S";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Unexpected</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNEXPECTED_L1_CODE = "UNE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for very susceptible</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VERY_SUSCEPTIBLE_L1_CODE = "VS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Weakly reactive</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WEAKLY_REACTIVE_L2_CODE = "WR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Worse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WORSE_L1_CODE = "W";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.78";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ObservationInterpretation";

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
	public static ObservationInterpretation getEnum(String code) {
		for (final ObservationInterpretation x : values()) {
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
			Enum.valueOf(ObservationInterpretation.class, enumName);
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
		for (final ObservationInterpretation x : values()) {
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
	ObservationInterpretation(String code, String codeSystem, String displayName,
			String displayNameEn, String displayNameDe, String displayNameFr,
			String displayNameIt) {
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
