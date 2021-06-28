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

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en"><p>    <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>This code is used to specify the exact function an actor had in a service in all necessary detail. This domain may include local extensions (CWE).</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ParticipationFunction implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">admitting physician</div>
	 * <!-- @formatter:on -->
	 */
	ADMITTING_PHYSICIAN("ADMPHYS", "2.16.840.1.113883.5.88", "admitting physician",
			"admitting physician", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">anesthesia nurse</div>
	 * <!-- @formatter:on -->
	 */
	ANESTHESIA_NURSE("ANRS", "2.16.840.1.113883.5.88", "anesthesia nurse", "anesthesia nurse",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">anesthesist</div>
	 * <!-- @formatter:on -->
	 */
	ANESTHESIST("ANEST", "2.16.840.1.113883.5.88", "anesthesist", "anesthesist", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">assembly software</div>
	 * <!-- @formatter:on -->
	 */
	ASSEMBLY_SOFTWARE("ASSEMBLER", "2.16.840.1.113883.5.88", "assembly software",
			"assembly software", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">attending physician</div>
	 * <!-- @formatter:on -->
	 */
	ATTENDING_PHYSICIAN("ATTPHYS", "2.16.840.1.113883.5.88", "attending physician",
			"attending physician", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">AuthorizedParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	AUTHORIZEDPARTICIPATIONFUNCTION("_AuthorizedParticipationFunction", "2.16.840.1.113883.5.88",
			"AuthorizedParticipationFunction", "AuthorizedParticipationFunction", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">AuthorizedReceiverParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	AUTHORIZEDRECEIVERPARTICIPATIONFUNCTION_L1("_AuthorizedReceiverParticipationFunction",
			"2.16.840.1.113883.5.88", "AuthorizedReceiverParticipationFunction",
			"AuthorizedReceiverParticipationFunction", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">authorized provider masking author</div>
	 * <!-- @formatter:on -->
	 */
	AUTHORIZED_PROVIDER_MASKING_AUTHOR_L2("PROMSK", "2.16.840.1.113883.5.88",
			"authorized provider masking author", "authorized provider masking author",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">caregiver information receiver</div>
	 * <!-- @formatter:on -->
	 */
	CAREGIVER_INFORMATION_RECEIVER_L2("AUCG", "2.16.840.1.113883.5.88",
			"caregiver information receiver", "caregiver information receiver", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">care team information receiver</div>
	 * <!-- @formatter:on -->
	 */
	CARE_TEAM_INFORMATION_RECEIVER_L2("AUTM", "2.16.840.1.113883.5.88",
			"care team information receiver", "care team information receiver", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">claims adjudication</div>
	 * <!-- @formatter:on -->
	 */
	CLAIMS_ADJUDICATION_L2("CLMADJ", "2.16.840.1.113883.5.88", "claims adjudication",
			"claims adjudication", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">composer software</div>
	 * <!-- @formatter:on -->
	 */
	COMPOSER_SOFTWARE("COMPOSER", "2.16.840.1.113883.5.88", "composer software",
			"composer software", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ConsenterParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	CONSENTERPARTICIPATIONFUNCTION_L1("_ConsenterParticipationFunction", "2.16.840.1.113883.5.88",
			"ConsenterParticipationFunction", "ConsenterParticipationFunction", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">consent overrider</div>
	 * <!-- @formatter:on -->
	 */
	CONSENT_OVERRIDER_L2("AUCOV", "2.16.840.1.113883.5.88", "consent overrider",
			"consent overrider", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CoverageParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	COVERAGEPARTICIPATIONFUNCTION("_CoverageParticipationFunction", "2.16.840.1.113883.5.88",
			"CoverageParticipationFunction", "CoverageParticipationFunction", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">discharging physician</div>
	 * <!-- @formatter:on -->
	 */
	DISCHARGING_PHYSICIAN("DISPHYS", "2.16.840.1.113883.5.88", "discharging physician",
			"discharging physician", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">emergency overrider</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_OVERRIDER_L2("AUEMROV", "2.16.840.1.113883.5.88", "emergency overrider",
			"emergency overrider", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">enrollment broker</div>
	 * <!-- @formatter:on -->
	 */
	ENROLLMENT_BROKER_L2("ENROLL", "2.16.840.1.113883.5.88", "enrollment broker",
			"enrollment broker", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ffs management</div>
	 * <!-- @formatter:on -->
	 */
	FFS_MANAGEMENT_L2("FFSMGT", "2.16.840.1.113883.5.88", "ffs management", "ffs management",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">first assistant surgeon</div>
	 * <!-- @formatter:on -->
	 */
	FIRST_ASSISTANT_SURGEON("FASST", "2.16.840.1.113883.5.88", "first assistant surgeon",
			"first assistant surgeon", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">fully insured</div>
	 * <!-- @formatter:on -->
	 */
	FULLY_INSURED_L2("FULINRD", "2.16.840.1.113883.5.88", "fully insured", "fully insured",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">healthcare power of attorney consent author</div>
	 * <!-- @formatter:on -->
	 */
	HEALTHCARE_POWER_OF_ATTORNEY_CONSENT_AUTHOR_L2("POACON", "2.16.840.1.113883.5.88",
			"healthcare power of attorney consent author",
			"healthcare power of attorney consent author", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">legal guardian consent author</div>
	 * <!-- @formatter:on -->
	 */
	LEGAL_GUARDIAN_CONSENT_AUTHOR_L2("GRDCON", "2.16.840.1.113883.5.88",
			"legal guardian consent author", "legal guardian consent author", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">legitimate relationship information receiver</div>
	 * <!-- @formatter:on -->
	 */
	LEGITIMATE_RELATIONSHIP_INFORMATION_RECEIVER_L2("AULR", "2.16.840.1.113883.5.88",
			"legitimate relationship information receiver",
			"legitimate relationship information receiver", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">managed care management</div>
	 * <!-- @formatter:on -->
	 */
	MANAGED_CARE_MANAGEMENT_L2("MCMGT", "2.16.840.1.113883.5.88", "managed care management",
			"managed care management", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">midwife</div>
	 * <!-- @formatter:on -->
	 */
	MIDWIFE("MDWF", "2.16.840.1.113883.5.88", "midwife", "midwife", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">nurse assistant</div>
	 * <!-- @formatter:on -->
	 */
	NURSE_ASSISTANT("NASST", "2.16.840.1.113883.5.88", "nurse assistant", "nurse assistant",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">OverriderParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	OVERRIDERPARTICIPATIONFUNCTION_L1("_OverriderParticipationFunction", "2.16.840.1.113883.5.88",
			"OverriderParticipationFunction", "OverriderParticipationFunction", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PayorParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	PAYORPARTICIPATIONFUNCTION_L1("_PayorParticipationFunction", "2.16.840.1.113883.5.88",
			"PayorParticipationFunction", "PayorParticipationFunction", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">payor contracting</div>
	 * <!-- @formatter:on -->
	 */
	PAYOR_CONTRACTING_L2("PAYORCNTR", "2.16.840.1.113883.5.88", "payor contracting",
			"payor contracting", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">personal representative consent author</div>
	 * <!-- @formatter:on -->
	 */
	PERSONAL_REPRESENTATIVE_CONSENT_AUTHOR_L2("PRCON", "2.16.840.1.113883.5.88",
			"personal representative consent author", "personal representative consent author",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">primary care physician</div>
	 * <!-- @formatter:on -->
	 */
	PRIMARY_CARE_PHYSICIAN("PCP", "2.16.840.1.113883.5.88", "primary care physician",
			"primary care physician", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">primary surgeon</div>
	 * <!-- @formatter:on -->
	 */
	PRIMARY_SURGEON("PRISURG", "2.16.840.1.113883.5.88", "primary surgeon", "primary surgeon",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">provider management</div>
	 * <!-- @formatter:on -->
	 */
	PROVIDER_MANAGEMENT_L2("PROVMGT", "2.16.840.1.113883.5.88", "provider management",
			"provider management", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">reinsures</div>
	 * <!-- @formatter:on -->
	 */
	REINSURES_L2("REINS", "2.16.840.1.113883.5.88", "reinsures", "reinsures", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">retrocessionaires</div>
	 * <!-- @formatter:on -->
	 */
	RETROCESSIONAIRES_L2("RETROCES", "2.16.840.1.113883.5.88", "retrocessionaires",
			"retrocessionaires", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">reviewer</div>
	 * <!-- @formatter:on -->
	 */
	REVIEWER("REVIEWER", "2.16.840.1.113883.5.88", "reviewer", "reviewer", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">rounding physician</div>
	 * <!-- @formatter:on -->
	 */
	ROUNDING_PHYSICIAN("RNDPHYS", "2.16.840.1.113883.5.88", "rounding physician",
			"rounding physician", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">scrub nurse</div>
	 * <!-- @formatter:on -->
	 */
	SCRUB_NURSE("SNRS", "2.16.840.1.113883.5.88", "scrub nurse", "scrub nurse", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">second assistant surgeon</div>
	 * <!-- @formatter:on -->
	 */
	SECOND_ASSISTANT_SURGEON("SASST", "2.16.840.1.113883.5.88", "second assistant surgeon",
			"second assistant surgeon", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">self insured</div>
	 * <!-- @formatter:on -->
	 */
	SELF_INSURED_L2("SELFINRD", "2.16.840.1.113883.5.88", "self insured", "self insured",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SponsorParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	SPONSORPARTICIPATIONFUNCTION_L1("_SponsorParticipationFunction", "2.16.840.1.113883.5.88",
			"SponsorParticipationFunction", "SponsorParticipationFunction", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">subcontracting risk</div>
	 * <!-- @formatter:on -->
	 */
	SUBCONTRACTING_RISK_L2("SUBCTRT", "2.16.840.1.113883.5.88", "subcontracting risk",
			"subcontracting risk", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">subject of consent author</div>
	 * <!-- @formatter:on -->
	 */
	SUBJECT_OF_CONSENT_AUTHOR_L2("SUBCON", "2.16.840.1.113883.5.88", "subject of consent author",
			"subject of consent author", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">third assistant</div>
	 * <!-- @formatter:on -->
	 */
	THIRD_ASSISTANT("TASST", "2.16.840.1.113883.5.88", "third assistant", "third assistant",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">UnderwriterParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	UNDERWRITERPARTICIPATIONFUNCTION_L1("_UnderwriterParticipationFunction",
			"2.16.840.1.113883.5.88", "UnderwriterParticipationFunction",
			"UnderwriterParticipationFunction", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">underwriting</div>
	 * <!-- @formatter:on -->
	 */
	UNDERWRITING_L2("UNDERWRTNG", "2.16.840.1.113883.5.88", "underwriting", "underwriting",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">utilization management</div>
	 * <!-- @formatter:on -->
	 */
	UTILIZATION_MANAGEMENT_L2("UMGT", "2.16.840.1.113883.5.88", "utilization management",
			"utilization management", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">work area information receiver</div>
	 * <!-- @formatter:on -->
	 */
	WORK_AREA_INFORMATION_RECEIVER_L2("AUWA", "2.16.840.1.113883.5.88",
			"work area information receiver", "work area information receiver", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for admitting physician</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADMITTING_PHYSICIAN_CODE = "ADMPHYS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for anesthesia nurse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANESTHESIA_NURSE_CODE = "ANRS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for anesthesist</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANESTHESIST_CODE = "ANEST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for assembly software</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ASSEMBLY_SOFTWARE_CODE = "ASSEMBLER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for attending physician</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ATTENDING_PHYSICIAN_CODE = "ATTPHYS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for AuthorizedParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUTHORIZEDPARTICIPATIONFUNCTION_CODE = "_AuthorizedParticipationFunction";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for AuthorizedReceiverParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUTHORIZEDRECEIVERPARTICIPATIONFUNCTION_L1_CODE = "_AuthorizedReceiverParticipationFunction";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for authorized provider masking author</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUTHORIZED_PROVIDER_MASKING_AUTHOR_L2_CODE = "PROMSK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for caregiver information receiver</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CAREGIVER_INFORMATION_RECEIVER_L2_CODE = "AUCG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for care team information receiver</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARE_TEAM_INFORMATION_RECEIVER_L2_CODE = "AUTM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for claims adjudication</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLAIMS_ADJUDICATION_L2_CODE = "CLMADJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for composer software</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMPOSER_SOFTWARE_CODE = "COMPOSER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ConsenterParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONSENTERPARTICIPATIONFUNCTION_L1_CODE = "_ConsenterParticipationFunction";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for consent overrider</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONSENT_OVERRIDER_L2_CODE = "AUCOV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CoverageParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COVERAGEPARTICIPATIONFUNCTION_CODE = "_CoverageParticipationFunction";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for discharging physician</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISCHARGING_PHYSICIAN_CODE = "DISPHYS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for emergency overrider</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_OVERRIDER_L2_CODE = "AUEMROV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for enrollment broker</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENROLLMENT_BROKER_L2_CODE = "ENROLL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ffs management</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FFS_MANAGEMENT_L2_CODE = "FFSMGT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for first assistant surgeon</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FIRST_ASSISTANT_SURGEON_CODE = "FASST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for fully insured</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FULLY_INSURED_L2_CODE = "FULINRD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for healthcare power of attorney consent author</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEALTHCARE_POWER_OF_ATTORNEY_CONSENT_AUTHOR_L2_CODE = "POACON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for legal guardian consent author</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LEGAL_GUARDIAN_CONSENT_AUTHOR_L2_CODE = "GRDCON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for legitimate relationship information receiver</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LEGITIMATE_RELATIONSHIP_INFORMATION_RECEIVER_L2_CODE = "AULR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for managed care management</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MANAGED_CARE_MANAGEMENT_L2_CODE = "MCMGT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for midwife</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MIDWIFE_CODE = "MDWF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for nurse assistant</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NURSE_ASSISTANT_CODE = "NASST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for OverriderParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OVERRIDERPARTICIPATIONFUNCTION_L1_CODE = "_OverriderParticipationFunction";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PayorParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAYORPARTICIPATIONFUNCTION_L1_CODE = "_PayorParticipationFunction";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for payor contracting</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAYOR_CONTRACTING_L2_CODE = "PAYORCNTR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for personal representative consent author</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERSONAL_REPRESENTATIVE_CONSENT_AUTHOR_L2_CODE = "PRCON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for primary care physician</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRIMARY_CARE_PHYSICIAN_CODE = "PCP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for primary surgeon</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRIMARY_SURGEON_CODE = "PRISURG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for provider management</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROVIDER_MANAGEMENT_L2_CODE = "PROVMGT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for reinsures</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REINSURES_L2_CODE = "REINS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for retrocessionaires</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RETROCESSIONAIRES_L2_CODE = "RETROCES";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for reviewer</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REVIEWER_CODE = "REVIEWER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for rounding physician</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROUNDING_PHYSICIAN_CODE = "RNDPHYS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for scrub nurse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SCRUB_NURSE_CODE = "SNRS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for second assistant surgeon</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SECOND_ASSISTANT_SURGEON_CODE = "SASST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for self insured</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SELF_INSURED_L2_CODE = "SELFINRD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SponsorParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPONSORPARTICIPATIONFUNCTION_L1_CODE = "_SponsorParticipationFunction";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for subcontracting risk</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBCONTRACTING_RISK_L2_CODE = "SUBCTRT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for subject of consent author</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBJECT_OF_CONSENT_AUTHOR_L2_CODE = "SUBCON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for third assistant</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THIRD_ASSISTANT_CODE = "TASST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for UnderwriterParticipationFunction</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNDERWRITERPARTICIPATIONFUNCTION_L1_CODE = "_UnderwriterParticipationFunction";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for underwriting</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNDERWRITING_L2_CODE = "UNDERWRTNG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for utilization management</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UTILIZATION_MANAGEMENT_L2_CODE = "UMGT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for work area information receiver</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WORK_AREA_INFORMATION_RECEIVER_L2_CODE = "AUWA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.10267";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ParticipationFunction";

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
	public static ParticipationFunction getEnum(String code) {
		for (final ParticipationFunction x : values()) {
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
			Enum.valueOf(ParticipationFunction.class, enumName);
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
		for (final ParticipationFunction x : values()) {
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
	ParticipationFunction(String code, String codeSystem, String displayName, String displayNameEn,
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
