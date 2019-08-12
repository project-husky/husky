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
package org.ehealth_connector.cda.ch.lab.lrtp.enums;

import java.util.Date;

import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * The Enum LabObsList.
 */
/*
 * <div class="en">List of laboratory observations</div> <div class="de">Liste
 * der Laborbeobachtungen</div>
 */
public enum LabObsList {

	/** <div class="en">A1 HLA-Antigene</div>. */
	A1_HLA_ANTIGENE("A1", "2.16.756.5.30.1.129.1.1.8", "A1 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">A11 HLA-Antigene</div>. */
	A11_HLA_ANTIGENE("A11", "2.16.756.5.30.1.129.1.1.8", "A11 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">A2 HLA-Antigene</div>. */
	A2_HLA_ANTIGENE("A2", "2.16.756.5.30.1.129.1.1.8", "A2 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">A203 HLA-Antigene</div>. */
	A203_HLA_ANTIGENE("A203", "2.16.756.5.30.1.129.1.1.8", "A203 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A210 HLA-Antigene</div>. */
	A210_HLA_ANTIGENE("A210", "2.16.756.5.30.1.129.1.1.8", "A210 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A23(9) HLA-Antigene</div>. */
	A239_HLA_ANTIGENE("A23", "2.16.756.5.30.1.129.1.1.8", "A23(9) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A24(9) HLA-Antigene</div>. */
	A249_HLA_ANTIGENE("A24", "2.16.756.5.30.1.129.1.1.8", "A24(9) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A25(10) HLA-Antigene</div>. */
	A2510_HLA_ANTIGENE("A25", "2.16.756.5.30.1.129.1.1.8", "A25(10) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A26(10) HLA-Antigene</div>. */
	A2610_HLA_ANTIGENE("A26", "2.16.756.5.30.1.129.1.1.8", "A26(10) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A29(19) HLA-Antigene</div>. */
	A2919_HLA_ANTIGENE("A29", "2.16.756.5.30.1.129.1.1.8", "A29(19) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A3 HLA-Antigene</div>. */
	A3_HLA_ANTIGENE("A3", "2.16.756.5.30.1.129.1.1.8", "A3 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">A30(19) HLA-Antigene</div>. */
	A3019_HLA_ANTIGENE("A30", "2.16.756.5.30.1.129.1.1.8", "A30(19) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A31(19) HLA-Antigene</div>. */
	A3119_HLA_ANTIGENE("A31", "2.16.756.5.30.1.129.1.1.8", "A31(19) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A32(19) HLA-Antigene</div>. */
	A3219_HLA_ANTIGENE("A32", "2.16.756.5.30.1.129.1.1.8", "A32(19) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A33(19) HLA-Antigene</div>. */
	A3319_HLA_ANTIGENE("A33", "2.16.756.5.30.1.129.1.1.8", "A33(19) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A34(10) HLA-Antigene</div>. */
	A3410_HLA_ANTIGENE("A34", "2.16.756.5.30.1.129.1.1.8", "A34(10) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A36 HLA-Antigene</div>. */
	A36_HLA_ANTIGENE("A36", "2.16.756.5.30.1.129.1.1.8", "A36 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">A43 HLA-Antigene</div>. */
	A43_HLA_ANTIGENE("A43", "2.16.756.5.30.1.129.1.1.8", "A43 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">A66(10) HLA-Antigene</div>. */
	A6610_HLA_ANTIGENE("A66", "2.16.756.5.30.1.129.1.1.8", "A66(10) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A68(28) HLA-Antigene</div>. */
	A6828_HLA_ANTIGENE("A68", "2.16.756.5.30.1.129.1.1.8", "A68(28) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A69(28) HLA-Antigene</div>. */
	A6928_HLA_ANTIGENE("A69", "2.16.756.5.30.1.129.1.1.8", "A69(28) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A74(19) HLA-Antigene</div>. */
	A7419_HLA_ANTIGENE("A74", "2.16.756.5.30.1.129.1.1.8", "A74(19) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">A80 HLA-Antigene</div>. */
	A80_HLA_ANTIGENE("A80", "2.16.756.5.30.1.129.1.1.8", "A80 HLA-Antigene", "18724-5", "20140101",
			""),

	/**
	 * <div class="en">Activated partial thromboplastin time (aPTT) in Blood by
	 * Coagulation assay</div>.
	 */
	ACTIVATED_PARTIAL_THROMBOPLASTIN_TIME_APTT_IN_BLOOD_BY_COAGULATION_ASSAY("3173-2",
			"2.16.840.1.113883.6.1",
			"Activated partial thromboplastin time (aPTT) in Blood by Coagulation assay", "18720-3",
			"20140101", ""),

	/**
	 * <div class="en">Alanine aminotransferase [Enzymatic activity/volume] in
	 * Serum or Plasma</div>.
	 */
	ALANINE_AMINOTRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("1742-6",
			"2.16.840.1.113883.6.1",
			"Alanine aminotransferase [Enzymatic activity/volume] in Serum or Plasma", "18719-5",
			"20140101", ""),

	/** <div class="en">Albumin [Mass/volume] in Serum or Plasma</div>. */
	ALBUMIN_MASSVOLUME_IN_SERUM_OR_PLASMA("1751-7", "2.16.840.1.113883.6.1",
			"Albumin [Mass/volume] in Serum or Plasma", "18719-5", "20140101", ""),
	/**
	 * <div class="en">Alkaline phosphatase.liver+bone [Presence] in Serum or
	 * Plasma</div>
	 */
	ALKALINE_PHOSPHATASE_LIVER_BONE_PRESENCE_IN_SERUM_OR_PLASMA("43708-7", "2.16.840.1.113883.6.1",
			"Alkaline phosphatase.liver+bone [Presence] in Serum or Plasma", "18719-5", "20140101",
			""),

	/** <div class="en">Ammonium ion [Moles/volume] in Plasma</div>. */
	AMMONIUM_ION_MOLESVOLUME_IN_PLASMA("1845-7", "2.16.840.1.113883.6.1",
			"Ammonium ion [Moles/volume] in Plasma", "18719-5", "20140101", ""),
	/**
	 * <div class="en">Amylase.pancreatic [Enzymatic activity/volume] in Serum
	 * or Plasma</div>
	 */
	AMYLASE_PANCREATIC_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("1805-1",
			"2.16.840.1.113883.6.1",
			"Amylase.pancreatic [Enzymatic activity/volume] in Serum or Plasma", "18719-5",
			"20140101", ""),

	/**
	 * <div class="en">Aspartate aminotransferase [Enzymatic activity/volume] in
	 * Serum or Plasma</div>.
	 */
	ASPARTATE_AMINOTRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("1920-8",
			"2.16.840.1.113883.6.1",
			"Aspartate aminotransferase [Enzymatic activity/volume] in Serum or Plasma", "18719-5",
			"20140101", ""),

	/** <div class="en">B13 HLA-Antigene</div>. */
	B13_HLA_ANTIGENE("B13", "2.16.756.5.30.1.129.1.1.8", "B13 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B18 HLA-Antigene</div>. */
	B18_HLA_ANTIGENE("B18", "2.16.756.5.30.1.129.1.1.8", "B18 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B27 HLA-Antigene</div>. */
	B27_HLA_ANTIGENE("B27", "2.16.756.5.30.1.129.1.1.8", "B27 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B35 HLA-Antigene</div>. */
	B35_HLA_ANTIGENE("B35", "2.16.756.5.30.1.129.1.1.8", "B35 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B37 HLA-Antigene</div>. */
	B37_HLA_ANTIGENE("B37", "2.16.756.5.30.1.129.1.1.8", "B37 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B38(16) HLA-Antigene</div>. */
	B3816_HLA_ANTIGENE("B38", "2.16.756.5.30.1.129.1.1.8", "B38(16) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B3901 HLA-Antigene</div>. */
	B3901_HLA_ANTIGENE("B3901", "2.16.756.5.30.1.129.1.1.8", "B3901 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B3902 HLA-Antigene</div>. */
	B3902_HLA_ANTIGENE("B3902", "2.16.756.5.30.1.129.1.1.8", "B3902 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B39(16) HLA-Antigene</div>. */
	B3916_HLA_ANTIGENE("B39", "2.16.756.5.30.1.129.1.1.8", "B39(16) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B4005 HLA-Antigene</div>. */
	B4005_HLA_ANTIGENE("B4005", "2.16.756.5.30.1.129.1.1.8", "B4005 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B41 HLA-Antigene</div>. */
	B41_HLA_ANTIGENE("B41", "2.16.756.5.30.1.129.1.1.8", "B41 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B42 HLA-Antigene</div>. */
	B42_HLA_ANTIGENE("B42", "2.16.756.5.30.1.129.1.1.8", "B42 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B44(12) HLA-Antigene</div>. */
	B4412_HLA_ANTIGENE("B44", "2.16.756.5.30.1.129.1.1.8", "B44(12) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B45(12) HLA-Antigene</div>. */
	B4512_HLA_ANTIGENE("B45", "2.16.756.5.30.1.129.1.1.8", "B45(12) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B46 HLA-Antigene</div>. */
	B46_HLA_ANTIGENE("B46", "2.16.756.5.30.1.129.1.1.8", "B46 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B47 HLA-Antigene</div>. */
	B47_HLA_ANTIGENE("B47", "2.16.756.5.30.1.129.1.1.8", "B47 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B48 HLA-Antigene</div>. */
	B48_HLA_ANTIGENE("B48", "2.16.756.5.30.1.129.1.1.8", "B48 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B49(21) HLA-Antigene</div>. */
	B4921_HLA_ANTIGENE("B49", "2.16.756.5.30.1.129.1.1.8", "B49(21) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B50(21) HLA-Antigene</div>. */
	B5021_HLA_ANTIGENE("B50", "2.16.756.5.30.1.129.1.1.8", "B50(21) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B5102 HLA-Antigene</div>. */
	B5102_HLA_ANTIGENE("B5102", "2.16.756.5.30.1.129.1.1.8", "B5102 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B5103 HLA-Antigene</div>. */
	B5103_HLA_ANTIGENE("B5103", "2.16.756.5.30.1.129.1.1.8", "B5103 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B51(5) HLA-Antigene</div>. */
	B515_HLA_ANTIGENE("B51", "2.16.756.5.30.1.129.1.1.8", "B51(5) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B52(5) HLA-Antigene</div>. */
	B525_HLA_ANTIGENE("B52", "2.16.756.5.30.1.129.1.1.8", "B52(5) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B53 HLA-Antigene</div>. */
	B53_HLA_ANTIGENE("B53", "2.16.756.5.30.1.129.1.1.8", "B53 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B54(22) HLA-Antigene</div>. */
	B5422_HLA_ANTIGENE("B54", "2.16.756.5.30.1.129.1.1.8", "B54(22) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B55(22) HLA-Antigene</div>. */
	B5522_HLA_ANTIGENE("B55", "2.16.756.5.30.1.129.1.1.8", "B55(22) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B56(22) HLA-Antigene</div>. */
	B5622_HLA_ANTIGENE("B56", "2.16.756.5.30.1.129.1.1.8", "B56(22) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B57(17) HLA-Antigene</div>. */
	B5717_HLA_ANTIGENE("B57", "2.16.756.5.30.1.129.1.1.8", "B57(17) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B58(17) HLA-Antigene</div>. */
	B5817_HLA_ANTIGENE("B58", "2.16.756.5.30.1.129.1.1.8", "B58(17) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B59 HLA-Antigene</div>. */
	B59_HLA_ANTIGENE("B59", "2.16.756.5.30.1.129.1.1.8", "B59 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B60(40) HLA-Antigene</div>. */
	B6040_HLA_ANTIGENE("B60", "2.16.756.5.30.1.129.1.1.8", "B60(40) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B61(40) HLA-Antigene</div>. */
	B6140_HLA_ANTIGENE("B61", "2.16.756.5.30.1.129.1.1.8", "B61(40) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B62(15) HLA-Antigene</div>. */
	B6215_HLA_ANTIGENE("B62", "2.16.756.5.30.1.129.1.1.8", "B62(15) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B63(15) HLA-Antigene</div>. */
	B6315_HLA_ANTIGENE("B63", "2.16.756.5.30.1.129.1.1.8", "B63(15) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B64(14) HLA-Antigene</div>. */
	B6414_HLA_ANTIGENE("B64", "2.16.756.5.30.1.129.1.1.8", "B64(14) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B65(14) HLA-Antigene</div>. */
	B6514_HLA_ANTIGENE("B65", "2.16.756.5.30.1.129.1.1.8", "B65(14) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B67 HLA-Antigene</div>. */
	B67_HLA_ANTIGENE("B67", "2.16.756.5.30.1.129.1.1.8", "B67 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B7 HLA-Antigene</div>. */
	B7_HLA_ANTIGENE("B7", "2.16.756.5.30.1.129.1.1.8", "B7 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B703 HLA-Antigene</div>. */
	B703_HLA_ANTIGENE("B703", "2.16.756.5.30.1.129.1.1.8", "B703 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B71(70) HLA-Antigene</div>. */
	B7170_HLA_ANTIGENE("B71", "2.16.756.5.30.1.129.1.1.8", "B71(70) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B72(70) HLA-Antigene</div>. */
	B7270_HLA_ANTIGENE("B72", "2.16.756.5.30.1.129.1.1.8", "B72(70) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B73 HLA-Antigene</div>. */
	B73_HLA_ANTIGENE("B73", "2.16.756.5.30.1.129.1.1.8", "B73 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B75(15) HLA-Antigene</div>. */
	B7515_HLA_ANTIGENE("B75", "2.16.756.5.30.1.129.1.1.8", "B75(15) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B76(15) HLA-Antigene</div>. */
	B7615_HLA_ANTIGENE("B76", "2.16.756.5.30.1.129.1.1.8", "B76(15) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B77(15) HLA-Antigene</div>. */
	B7715_HLA_ANTIGENE("B77", "2.16.756.5.30.1.129.1.1.8", "B77(15) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">B78 HLA-Antigene</div>. */
	B78_HLA_ANTIGENE("B78", "2.16.756.5.30.1.129.1.1.8", "B78 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B8 HLA-Antigene</div>. */
	B8_HLA_ANTIGENE("B8", "2.16.756.5.30.1.129.1.1.8", "B8 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B81 HLA-Antigene</div>. */
	B81_HLA_ANTIGENE("B81", "2.16.756.5.30.1.129.1.1.8", "B81 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">B82 HLA-Antigene</div>. */
	B82_HLA_ANTIGENE("B82", "2.16.756.5.30.1.129.1.1.8", "B82 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">Base excess in Blood by calculation</div>. */
	BASE_EXCESS_IN_BLOOD_BY_CALCULATION("11555-0", "2.16.840.1.113883.6.1",
			"Base excess in Blood by calculation", "18767-4", "20140101", ""),
	/**
	 * <div class="en">Bilirubin.direct [Moles/volume] in Serum or Plasma</div>
	 */
	BILIRUBIN_DIRECT_MOLESVOLUME_IN_SERUM_OR_PLASMA("14629-0", "2.16.840.1.113883.6.1",
			"Bilirubin.direct [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),
	/**
	 * <div class="en">Bilirubin.total [Mass/volume] in Urine by Test
	 * strip</div>
	 */
	BILIRUBIN_TOTAL_MASSVOLUME_IN_URINE_BY_TEST_STRIP("20505-4", "2.16.840.1.113883.6.1",
			"Bilirubin.total [Mass/volume] in Urine by Test strip", "18719-5", "20140101", ""),
	/**
	 * <div class="en">Bilirubin.total [Moles/volume] in Blood</div>
	 */
	BILIRUBIN_TOTAL_MOLESVOLUME_IN_BLOOD("54363-7", "2.16.840.1.113883.6.1",
			"Bilirubin.total [Moles/volume] in Blood", "18719-5", "20140101", ""),

	/**
	 * <div class="en">C reactive protein [Mass/volume] in Serum or Plasma</div>
	 * .
	 */
	C_REACTIVE_PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA("1988-5", "2.16.840.1.113883.6.1",
			"C reactive protein [Mass/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Calcium [Moles/volume] in Serum or Plasma</div>. */
	CALCIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("2000-8", "2.16.840.1.113883.6.1",
			"Calcium [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Carbon dioxide [Partial pressure] in Blood</div>. */
	CARBON_DIOXIDE_PARTIAL_PRESSURE_IN_BLOOD("11557-6", "2.16.840.1.113883.6.1",
			"Carbon dioxide [Partial pressure] in Blood", "18767-4", "20140101", ""),

	/** <div class="en">Carbonate [Mass/volume] in Plasma</div>. */
	CARBONATE_MASSVOLUME_IN_PLASMA("2035-4", "2.16.840.1.113883.6.1",
			"Carbonate [Mass/volume] in Plasma", "18767-4", "20140101", ""),

	/**
	 * <div class="en">Coagulation factor V activity actual/normal in Platelet
	 * poor plasma by Coagulation assay</div>.
	 */
	COAGULATION_FACTOR_V_ACTIVITY_ACTUALNORMAL_IN_PLATELET_POOR_PLASMA_BY_COAGULATION_ASSAY(
			"3193-0", "2.16.840.1.113883.6.1",
			"Coagulation factor V activity actual/normal in Platelet poor plasma by Coagulation assay",
			"18720-3", "20140101", ""),
	/**
	 * <div class="en">Creatine kinase [Enzymatic activity/volume] in Serum or
	 * Plasma</div>.
	 */
	CREATINE_KINASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("2157-6", "2.16.840.1.113883.6.1",
			"Creatine kinase [Enzymatic activity/volume] in Serum or Plasma", "18719-5", "20140101",
			""),

	/**
	 * <div class="en">Creatine kinase.MB [Mass/volume] in Serum or Plasma</div>
	 */
	CREATINE_KINASE_MB_MASSVOLUME_IN_SERUM_OR_PLASMA("13969-1", "2.16.840.1.113883.6.1",
			"Creatine kinase.MB [Mass/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Creatinine [Moles/volume] in Serum or Plasma</div>. */
	CREATININE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14682-9", "2.16.840.1.113883.6.1",
			"Creatinine [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Cytomegalovirus Ab [Presence] in Serum</div>. */
	CYTOMEGALOVIRUS_AB_PRESENCE_IN_SERUM("22239-8", "2.16.840.1.113883.6.1",
			"Cytomegalovirus Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/** <div class="en">Cytomegalovirus IgG Ab [Presence] in Serum</div>. */
	CYTOMEGALOVIRUS_IGG_AB_PRESENCE_IN_SERUM("22244-8", "2.16.840.1.113883.6.1",
			"Cytomegalovirus IgG Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/** <div class="en">Cytomegalovirus IgM Ab [Presence] in Serum</div>. */
	CYTOMEGALOVIRUS_IGM_AB_PRESENCE_IN_SERUM("30325-5", "2.16.840.1.113883.6.1",
			"Cytomegalovirus IgM Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/** <div class="en">DQ2 HLA-Antigene</div>. */
	DQ2_HLA_ANTIGENE("DQ2", "2.16.756.5.30.1.129.1.1.8", "DQ2 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">DQ4 HLA-Antigene</div>. */
	DQ4_HLA_ANTIGENE("DQ4", "2.16.756.5.30.1.129.1.1.8", "DQ4 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">DQ5(1) HLA-Antigene</div>. */
	DQ51_HLA_ANTIGENE("DQ5", "2.16.756.5.30.1.129.1.1.8", "DQ5(1) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DQ6(1) HLA-Antigene</div>. */
	DQ61_HLA_ANTIGENE("DQ6", "2.16.756.5.30.1.129.1.1.8", "DQ6(1) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DQ7(3) HLA-Antigene</div>. */
	DQ73_HLA_ANTIGENE("DQ7", "2.16.756.5.30.1.129.1.1.8", "DQ7(3) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DQ8(3) HLA-Antigene</div>. */
	DQ83_HLA_ANTIGENE("DQ8", "2.16.756.5.30.1.129.1.1.8", "DQ8(3) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DQ9(3) HLA-Antigene</div>. */
	DQ93_HLA_ANTIGENE("DQ9", "2.16.756.5.30.1.129.1.1.8", "DQ9(3) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR1 HLA-Antigene</div>. */
	DR1_HLA_ANTIGENE("DR1", "2.16.756.5.30.1.129.1.1.8", "DR1 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">DR10 HLA-Antigene</div>. */
	DR10_HLA_ANTIGENE("DR10", "2.16.756.5.30.1.129.1.1.8", "DR10 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR103 HLA-Antigene</div>. */
	DR103_HLA_ANTIGENE("DR103", "2.16.756.5.30.1.129.1.1.8", "DR103 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR11(5) HLA-Antigene</div>. */
	DR115_HLA_ANTIGENE("DR11", "2.16.756.5.30.1.129.1.1.8", "DR11(5) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR12(5) HLA-Antigene</div>. */
	DR125_HLA_ANTIGENE("DR12", "2.16.756.5.30.1.129.1.1.8", "DR12(5) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR13(6) HLA-Antigene</div>. */
	DR136_HLA_ANTIGENE("DR13", "2.16.756.5.30.1.129.1.1.8", "DR13(6) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR1403 HLA-Antigene</div>. */
	DR1403_HLA_ANTIGENE("DR1403", "2.16.756.5.30.1.129.1.1.8", "DR1403 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR1404 HLA-Antigene</div>. */
	DR1404_HLA_ANTIGENE("DR1404", "2.16.756.5.30.1.129.1.1.8", "DR1404 HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR14(6) HLA-Antigene</div>. */
	DR146_HLA_ANTIGENE("DR14", "2.16.756.5.30.1.129.1.1.8", "DR14(6) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR15(2) HLA-Antigene</div>. */
	DR152_HLA_ANTIGENE("DR15", "2.16.756.5.30.1.129.1.1.8", "DR15(2) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR16(2) HLA-Antigene</div>. */
	DR162_HLA_ANTIGENE("DR16", "2.16.756.5.30.1.129.1.1.8", "DR16(2) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR17(3) HLA-Antigene</div>. */
	DR173_HLA_ANTIGENE("DR17", "2.16.756.5.30.1.129.1.1.8", "DR17(3) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR18(3) HLA-Antigene</div>. */
	DR183_HLA_ANTIGENE("DR18", "2.16.756.5.30.1.129.1.1.8", "DR18(3) HLA-Antigene", "18724-5",
			"20140101", ""),

	/** <div class="en">DR4 HLA-Antigene</div>. */
	DR4_HLA_ANTIGENE("DR4", "2.16.756.5.30.1.129.1.1.8", "DR4 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">DR7 HLA-Antigene</div>. */
	DR7_HLA_ANTIGENE("DR7", "2.16.756.5.30.1.129.1.1.8", "DR7 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">DR8 HLA-Antigene</div>. */
	DR8_HLA_ANTIGENE("DR8", "2.16.756.5.30.1.129.1.1.8", "DR8 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">DR9 HLA-Antigene</div>. */
	DR9_HLA_ANTIGENE("DR9", "2.16.756.5.30.1.129.1.1.8", "DR9 HLA-Antigene", "18724-5", "20140101",
			""),

	/** <div class="en">Epstein Barr virus Ab [Presence] in Serum</div>. */
	EPSTEIN_BARR_VIRUS_AB_PRESENCE_IN_SERUM("49178-7", "2.16.840.1.113883.6.1",
			"Epstein Barr virus Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/**
	 * <div class="en">Epstein Barr virus capsid IgG Ab [Presence] in
	 * Serum</div>.
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_PRESENCE_IN_SERUM("30339-6", "2.16.840.1.113883.6.1",
			"Epstein Barr virus capsid IgG Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/**
	 * <div class="en">Epstein Barr virus capsid IgM Ab [Presence] in
	 * Serum</div>.
	 */
	EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_PRESENCE_IN_SERUM("30340-4", "2.16.840.1.113883.6.1",
			"Epstein Barr virus capsid IgM Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/** <div class="en">Erythrocytes [#/volume] in Urine</div>. */
	ERYTHROCYTES_VOLUME_IN_URINE("30391-7", "2.16.840.1.113883.6.1",
			"Erythrocytes [#/volume] in Urine", "18729-4", "20140101", ""),

	/**
	 * <div class="en">Fibrinogen Ag [Mass/volume] in Platelet poor plasma by
	 * Immunologic method</div>.
	 */
	FIBRINOGEN_AG_MASSVOLUME_IN_PLATELET_POOR_PLASMA_BY_IMMUNOLOGIC_METHOD("3256-5",
			"2.16.840.1.113883.6.1",
			"Fibrinogen Ag [Mass/volume] in Platelet poor plasma by Immunologic method", "18720-3",
			"20140101", ""),

	/** <div class="en">Fractional oxyhemoglobin in Blood</div>. */
	FRACTIONAL_OXYHEMOGLOBIN_IN_BLOOD("11559-2", "2.16.840.1.113883.6.1",
			"Fractional oxyhemoglobin in Blood", "18723-7", "20140101", ""),

	/**
	 * <div class="en">Gamma glutamyl transferase [Enzymatic activity/volume] in
	 * Serum or Plasma</div>.
	 */
	GAMMA_GLUTAMYL_TRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("2324-2",
			"2.16.840.1.113883.6.1",
			"Gamma glutamyl transferase [Enzymatic activity/volume] in Serum or Plasma", "18719-5",
			"20140101", ""),

	/** <div class="en">Glucose [Moles/volume] in Serum or Plasma</div>. */
	GLUCOSE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14749-6", "2.16.840.1.113883.6.1",
			"Glucose [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Glucose [Moles/volume] in Urine by Test strip</div>. */
	GLUCOSE_MOLESVOLUME_IN_URINE_BY_TEST_STRIP("22705-8", "2.16.840.1.113883.6.1",
			"Glucose [Moles/volume] in Urine by Test strip", "18719-5", "20140101", ""),

	/** <div class="en">Hematocrit [Volume Fraction] of Blood</div>. */
	HEMATOCRIT_VOLUME_FRACTION_OF_BLOOD("20570-8", "2.16.840.1.113883.6.1",
			"Hematocrit [Volume Fraction] of Blood", "18723-7", "20140101", ""),
	/**
	 * <div class="en">Hemoglobin A1c/Hemoglobin.total in Blood</div>
	 */
	HEMOGLOBIN_A1CHEMOGLOBIN_TOTAL_IN_BLOOD("4548-4", "2.16.840.1.113883.6.1",
			"Hemoglobin A1c/Hemoglobin.total in Blood", "18723-7", "20140101", ""),

	/** <div class="en">Hemoglobin [Mass/volume] in Blood</div>. */
	HEMOGLOBIN_MASSVOLUME_IN_BLOOD("718-7", "2.16.840.1.113883.6.1",
			"Hemoglobin [Mass/volume] in Blood", "18723-7", "20140101", ""),

	/** <div class="en">Hepatitis B virus core Ab [Presence] in Serum</div>. */
	HEPATITIS_B_VIRUS_CORE_AB_PRESENCE_IN_SERUM("16933-4", "2.16.840.1.113883.6.1",
			"Hepatitis B virus core Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/** <div class="en">Hepatitis B virus e Ab [Presence] in Serum</div>. */
	HEPATITIS_B_VIRUS_E_AB_PRESENCE_IN_SERUM("22320-6", "2.16.840.1.113883.6.1",
			"Hepatitis B virus e Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/**
	 * <div class="en">Hepatitis B virus surface Ab [Presence] in Serum</div>.
	 */
	HEPATITIS_B_VIRUS_SURFACE_AB_PRESENCE_IN_SERUM("22322-2", "2.16.840.1.113883.6.1",
			"Hepatitis B virus surface Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/**
	 * <div class="en">Hepatitis B virus surface Ag [Presence] in Serum</div>.
	 */
	HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM("5195-3", "2.16.840.1.113883.6.1",
			"Hepatitis B virus surface Ag [Presence] in Serum", "18725-2", "20140101", ""),

	/** <div class="en">Hepatitis C virus Ab [Presence] in Serum</div>. */
	HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM("16128-1", "2.16.840.1.113883.6.1",
			"Hepatitis C virus Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/**
	 * <div class="en">Hepatitis C virus RNA [Presence] in Serum or Plasma by
	 * Probe and target amplification method</div>.
	 */
	HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD(
			"11259-9", "2.16.840.1.113883.6.1",
			"Hepatitis C virus RNA [Presence] in Serum or Plasma by Probe and target amplification method",
			"18725-2", "20140101", ""),

	/**
	 * <div class="en">Herpes simplex virus 1 and 2 IgG Ab [interpretation] in
	 * Serum by Immunoassay</div>.
	 */
	HERPES_SIMPLEX_VIRUS_1_AND_2_IGG_AB_INTERPRETATION_IN_SERUM_BY_IMMUNOASSAY("44009-9",
			"2.16.840.1.113883.6.1",
			"Herpes simplex virus 1 and 2 IgG Ab [interpretation] in Serum by Immunoassay",
			"18725-2", "20140101", ""),

	/**
	 * <div class="en">Herpes simplex virus 1 and 2 IgM Ab [interpretation] in
	 * Serum</div>.
	 */
	HERPES_SIMPLEX_VIRUS_1_AND_2_IGM_AB_INTERPRETATION_IN_SERUM("44008-1", "2.16.840.1.113883.6.1",
			"Herpes simplex virus 1 and 2 IgM Ab [interpretation] in Serum", "18725-2", "20140101",
			""),

	/** <div class="en">HIV 1 Ab [Presence] in Serum</div>. */
	HIV_1_AB_PRESENCE_IN_SERUM("7917-8", "2.16.840.1.113883.6.1", "HIV 1 Ab [Presence] in Serum",
			"18725-2", "20140101", ""),

	/** <div class="en">HIV 1 p24 Ag [Presence] in Serum</div>. */
	HIV_1_P24_AG_PRESENCE_IN_SERUM("9821-0", "2.16.840.1.113883.6.1",
			"HIV 1 p24 Ag [Presence] in Serum", "18725-2", "20140101", ""),

	/**
	 * <div class="en">HIV 1 RNA [Presence] in Blood by Probe and target
	 * amplification method</div>.
	 */
	HIV_1_RNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("5017-9",
			"2.16.840.1.113883.6.1",
			"HIV 1 RNA [Presence] in Blood by Probe and target amplification method", "18725-2",
			"20140101", ""),

	/** <div class="en">HIV 2 Ab [Presence] in Serum</div>. */
	HIV_2_AB_PRESENCE_IN_SERUM("7919-4", "2.16.840.1.113883.6.1", "HIV 2 Ab [Presence] in Serum",
			"18725-2", "20140101", ""),

	/**
	 * <div class="en">HIV 2 RNA [Presence] in Serum or Plasma by Probe and
	 * target amplification method</div>.
	 */
	HIV_2_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD("69353-1",
			"2.16.840.1.113883.6.1",
			"HIV 2 RNA [Presence] in Serum or Plasma by Probe and target amplification method",
			"18725-2", "20140101", ""),

	/** <div class="en">HLA-Antibody A1- MFI Value</div>. */
	HLA_ANTIBODY_A1_MFI_VALUE("Anti-A1-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A1- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A11- MFI Value</div>. */
	HLA_ANTIBODY_A11_MFI_VALUE("Anti-A11-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A11- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A2- MFI Value</div>. */
	HLA_ANTIBODY_A2_MFI_VALUE("Anti-A2-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A2- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A203- MFI Value</div>. */
	HLA_ANTIBODY_A203_MFI_VALUE("Anti-A203-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A203- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A210- MFI Value</div>. */
	HLA_ANTIBODY_A210_MFI_VALUE("Anti-A210-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A210- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A23(9)- MFI Value</div>. */
	HLA_ANTIBODY_A239_MFI_VALUE("Anti-A23-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A23(9)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A24(9)- MFI Value</div>. */
	HLA_ANTIBODY_A249_MFI_VALUE("Anti-A24-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A24(9)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A25(10)- MFI Value</div>. */
	HLA_ANTIBODY_A2510_MFI_VALUE("Anti-A25-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A25(10)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A26(10)- MFI Value</div>. */
	HLA_ANTIBODY_A2610_MFI_VALUE("Anti-A26-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A26(10)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A29(19)- MFI Value</div>. */
	HLA_ANTIBODY_A2919_MFI_VALUE("Anti-A29-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A29(19)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A3- MFI Value</div>. */
	HLA_ANTIBODY_A3_MFI_VALUE("Anti-A3-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A3- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A30(19)- MFI Value</div>. */
	HLA_ANTIBODY_A3019_MFI_VALUE("Anti-A30-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A30(19)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A31(19)- MFI Value</div>. */
	HLA_ANTIBODY_A3119_MFI_VALUE("Anti-A31-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A31(19)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A32(19)- MFI Value</div>. */
	HLA_ANTIBODY_A3219_MFI_VALUE("Anti-A32-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A32(19)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A33(19)- MFI Value</div>. */
	HLA_ANTIBODY_A3319_MFI_VALUE("Anti-A33-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A33(19)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A34(10)- MFI Value</div>. */
	HLA_ANTIBODY_A3410_MFI_VALUE("Anti-A34-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A34(10)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A36- MFI Value</div>. */
	HLA_ANTIBODY_A36_MFI_VALUE("Anti-A36-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A36- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A43- MFI Value</div>. */
	HLA_ANTIBODY_A43_MFI_VALUE("Anti-A43-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A43- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A66(10)- MFI Value</div>. */
	HLA_ANTIBODY_A6610_MFI_VALUE("Anti-A66-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A66(10)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A68(28)- MFI Value</div>. */
	HLA_ANTIBODY_A6828_MFI_VALUE("Anti-A68-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A68(28)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A69(28)- MFI Value</div>. */
	HLA_ANTIBODY_A6928_MFI_VALUE("Anti-A69-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A69(28)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A74(19)- MFI Value</div>. */
	HLA_ANTIBODY_A7419_MFI_VALUE("Anti-A74-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A74(19)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody A80- MFI Value</div>. */
	HLA_ANTIBODY_A80_MFI_VALUE("Anti-A80-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody A80- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B13- MFI Value</div>. */
	HLA_ANTIBODY_B13_MFI_VALUE("Anti-B13-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B13- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B18- MFI Value</div>. */
	HLA_ANTIBODY_B18_MFI_VALUE("Anti-B18-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B18- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B27- MFI Value</div>. */
	HLA_ANTIBODY_B27_MFI_VALUE("Anti-B27-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B27- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B35- MFI Value</div>. */
	HLA_ANTIBODY_B35_MFI_VALUE("Anti-B35-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B35- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B37- MFI Value</div>. */
	HLA_ANTIBODY_B37_MFI_VALUE("Anti-B37-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B37- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B38(16)- MFI Value</div>. */
	HLA_ANTIBODY_B3816_MFI_VALUE("Anti-B38-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B38(16)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B3901- MFI Value</div>. */
	HLA_ANTIBODY_B3901_MFI_VALUE("Anti-B3901-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B3901- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B3902- MFI Value</div>. */
	HLA_ANTIBODY_B3902_MFI_VALUE("Anti-B3902-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B3902- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B39(16)- MFI Value</div>. */
	HLA_ANTIBODY_B3916_MFI_VALUE("Anti-B39-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B39(16)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B4005- MFI Value</div>. */
	HLA_ANTIBODY_B4005_MFI_VALUE("Anti-B4005-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B4005- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B41- MFI Value</div>. */
	HLA_ANTIBODY_B41_MFI_VALUE("Anti-B41-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B41- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B42- MFI Value</div>. */
	HLA_ANTIBODY_B42_MFI_VALUE("Anti-B42-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B42- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B44(12)- MFI Value</div>. */
	HLA_ANTIBODY_B4412_MFI_VALUE("Anti-B44-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B44(12)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B45(12)- MFI Value</div>. */
	HLA_ANTIBODY_B4512_MFI_VALUE("Anti-B45-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B45(12)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B46- MFI Value</div>. */
	HLA_ANTIBODY_B46_MFI_VALUE("Anti-B46-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B46- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B47- MFI Value</div>. */
	HLA_ANTIBODY_B47_MFI_VALUE("Anti-B47-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B47- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B48- MFI Value</div>. */
	HLA_ANTIBODY_B48_MFI_VALUE("Anti-B48-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B48- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B49(21)- MFI Value</div>. */
	HLA_ANTIBODY_B4921_MFI_VALUE("Anti-B49-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B49(21)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B50(21)- MFI Value</div>. */
	HLA_ANTIBODY_B5021_MFI_VALUE("Anti-B50-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B50(21)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B5102- MFI Value</div>. */
	HLA_ANTIBODY_B5102_MFI_VALUE("Anti-B5102-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B5102- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B5103- MFI Value</div>. */
	HLA_ANTIBODY_B5103_MFI_VALUE("Anti-B5103-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B5103- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B51(5)- MFI Value</div>. */
	HLA_ANTIBODY_B515_MFI_VALUE("Anti-B51-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B51(5)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B52(5)- MFI Value</div>. */
	HLA_ANTIBODY_B525_MFI_VALUE("Anti-B52-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B52(5)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B53- MFI Value</div>. */
	HLA_ANTIBODY_B53_MFI_VALUE("Anti-B53-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B53- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B54(22)- MFI Value</div>. */
	HLA_ANTIBODY_B5422_MFI_VALUE("Anti-B54-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B54(22)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B55(22)- MFI Value</div>. */
	HLA_ANTIBODY_B5522_MFI_VALUE("Anti-B55-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B55(22)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B56(22)- MFI Value</div>. */
	HLA_ANTIBODY_B5622_MFI_VALUE("Anti-B56-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B56(22)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B57(17)- MFI Value</div>. */
	HLA_ANTIBODY_B5717_MFI_VALUE("Anti-B57-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B57(17)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B58(17)- MFI Value</div>. */
	HLA_ANTIBODY_B5817_MFI_VALUE("Anti-B58-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B58(17)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B59- MFI Value</div>. */
	HLA_ANTIBODY_B59_MFI_VALUE("Anti-B59-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B59- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B60(40)- MFI Value</div>. */
	HLA_ANTIBODY_B6040_MFI_VALUE("Anti-B60-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B60(40)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B61(40)- MFI Value</div>. */
	HLA_ANTIBODY_B6140_MFI_VALUE("Anti-B61-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B61(40)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B62(15)- MFI Value</div>. */
	HLA_ANTIBODY_B6215_MFI_VALUE("Anti-B62-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B62(15)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B63(15)- MFI Value</div>. */
	HLA_ANTIBODY_B6315_MFI_VALUE("Anti-B63-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B63(15)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B64(14)- MFI Value</div>. */
	HLA_ANTIBODY_B6414_MFI_VALUE("Anti-B64-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B64(14)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B65(14)- MFI Value</div>. */
	HLA_ANTIBODY_B6514_MFI_VALUE("Anti-B65-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B65(14)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B67- MFI Value</div>. */
	HLA_ANTIBODY_B67_MFI_VALUE("Anti-B67-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B67- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B7- MFI Value</div>. */
	HLA_ANTIBODY_B7_MFI_VALUE("Anti-B7-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B7- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B703- MFI Value</div>. */
	HLA_ANTIBODY_B703_MFI_VALUE("Anti-B703-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B703- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B71(70)- MFI Value</div>. */
	HLA_ANTIBODY_B7170_MFI_VALUE("Anti-B71-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B71(70)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B72(70)- MFI Value</div>. */
	HLA_ANTIBODY_B7270_MFI_VALUE("Anti-B72-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B72(70)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B73- MFI Value</div>. */
	HLA_ANTIBODY_B73_MFI_VALUE("Anti-B73-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B73- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B75(15)- MFI Value</div>. */
	HLA_ANTIBODY_B7515_MFI_VALUE("Anti-B75-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B75(15)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B76(15)- MFI Value</div>. */
	HLA_ANTIBODY_B7615_MFI_VALUE("Anti-B76-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B76(15)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B77(15)- MFI Value</div>. */
	HLA_ANTIBODY_B7715_MFI_VALUE("Anti-B77-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B77(15)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B78- MFI Value</div>. */
	HLA_ANTIBODY_B78_MFI_VALUE("Anti-B78-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B78- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B8- MFI Value</div>. */
	HLA_ANTIBODY_B8_MFI_VALUE("Anti-B8-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B8- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B81- MFI Value</div>. */
	HLA_ANTIBODY_B81_MFI_VALUE("Anti-B81-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B81- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody B82- MFI Value</div>. */
	HLA_ANTIBODY_B82_MFI_VALUE("Anti-B82-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody B82- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DQ2- MFI Value</div>. */
	HLA_ANTIBODY_DQ2_MFI_VALUE("Anti-DQ2-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DQ2- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DQ4- MFI Value</div>. */
	HLA_ANTIBODY_DQ4_MFI_VALUE("Anti-DQ4-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DQ4- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DQ5(1)- MFI Value</div>. */
	HLA_ANTIBODY_DQ51_MFI_VALUE("Anti-DQ5-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DQ5(1)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DQ6(1)- MFI Value</div>. */
	HLA_ANTIBODY_DQ61_MFI_VALUE("Anti-DQ6-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DQ6(1)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DQ7(3)- MFI Value</div>. */
	HLA_ANTIBODY_DQ73_MFI_VALUE("Anti-DQ7-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DQ7(3)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DQ8(3)- MFI Value</div>. */
	HLA_ANTIBODY_DQ83_MFI_VALUE("Anti-DQ8-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DQ8(3)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DQ9(3)- MFI Value</div>. */
	HLA_ANTIBODY_DQ93_MFI_VALUE("Anti-DQ9-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DQ9(3)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR1- MFI Value</div>. */
	HLA_ANTIBODY_DR1_MFI_VALUE("Anti-DR1-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR1- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR10- MFI Value</div>. */
	HLA_ANTIBODY_DR10_MFI_VALUE("Anti-DR10-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR10- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR103- MFI Value</div>. */
	HLA_ANTIBODY_DR103_MFI_VALUE("Anti-DR103-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR103- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR11(5)- MFI Value</div>. */
	HLA_ANTIBODY_DR115_MFI_VALUE("Anti-DR11-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR11(5)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR12(5)- MFI Value</div>. */
	HLA_ANTIBODY_DR125_MFI_VALUE("Anti-DR12-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR12(5)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR13(6)- MFI Value</div>. */
	HLA_ANTIBODY_DR136_MFI_VALUE("Anti-DR13-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR13(6)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR1403- MFI Value</div>. */
	HLA_ANTIBODY_DR1403_MFI_VALUE("Anti-DR1403-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR1403- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR1404- MFI Value</div>. */
	HLA_ANTIBODY_DR1404_MFI_VALUE("Anti-DR1404-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR1404- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR14(6)- MFI Value</div>. */
	HLA_ANTIBODY_DR146_MFI_VALUE("Anti-DR14-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR14(6)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR15(2)- MFI Value</div>. */
	HLA_ANTIBODY_DR152_MFI_VALUE("Anti-DR15-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR15(2)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR16(2)- MFI Value</div>. */
	HLA_ANTIBODY_DR162_MFI_VALUE("Anti-DR16-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR16(2)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR17(3)- MFI Value</div>. */
	HLA_ANTIBODY_DR173_MFI_VALUE("Anti-DR17-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR17(3)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR18(3)- MFI Value</div>. */
	HLA_ANTIBODY_DR183_MFI_VALUE("Anti-DR18-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR18(3)- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR4- MFI Value</div>. */
	HLA_ANTIBODY_DR4_MFI_VALUE("Anti-DR4-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR4- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR7- MFI Value</div>. */
	HLA_ANTIBODY_DR7_MFI_VALUE("Anti-DR7-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR7- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR8- MFI Value</div>. */
	HLA_ANTIBODY_DR8_MFI_VALUE("Anti-DR8-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR8- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HLA-Antibody DR9- MFI Value</div>. */
	HLA_ANTIBODY_DR9_MFI_VALUE("Anti-DR9-MFI", "2.16.756.5.30.1.129.1.1.8",
			"HLA-Antibody DR9- MFI Value", "18724-5", "20140101", ""),

	/** <div class="en">HTLV 1 Ab [Presence] in Serum</div>. */
	HTLV_1_AB_PRESENCE_IN_SERUM("22359-4", "2.16.840.1.113883.6.1", "HTLV 1 Ab [Presence] in Serum",
			"18725-2", "20140101", ""),

	/** <div class="en">HTLV 2 Ab [Presence] in Serum</div>. */
	HTLV_2_AB_PRESENCE_IN_SERUM("26656-9", "2.16.840.1.113883.6.1", "HTLV 2 Ab [Presence] in Serum",
			"18725-2", "20140101", ""),

	/** <div class="en">INR in Blood by Coagulation assay</div>. */
	INR_IN_BLOOD_BY_COAGULATION_ASSAY("34714-6", "2.16.840.1.113883.6.1",
			"INR in Blood by Coagulation assay", "18720-3", "20140101", ""),

	/**
	 * <div class="en">Lactate dehydrogenase [Enzymatic activity/volume] in
	 * Serum or Plasma by Lactate to pyruvate reaction</div>.
	 */
	LACTATE_DEHYDROGENASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_BY_LACTATE_TO_PYRUVATE_REACTION(
			"14804-9", "2.16.840.1.113883.6.1",
			"Lactate dehydrogenase [Enzymatic activity/volume] in Serum or Plasma by Lactate to pyruvate reaction",
			"18719-5", "20140101", ""),

	/** <div class="en">Leukocytes other [#/volume] in Blood</div>. */
	LEUKOCYTES_OTHER_VOLUME_IN_BLOOD("30406-3", "2.16.840.1.113883.6.1",
			"Leukocytes other [#/volume] in Blood", "18768-2", "20140101", ""),

	/** <div class="en">Leukocytes [#/volume] in Urine</div>. */
	LEUKOCYTES_VOLUME_IN_URINE("30405-5", "2.16.840.1.113883.6.1", "Leukocytes [#/volume] in Urine",
			"18729-4", "20140101", ""),

	/**
	 * <div class="en">Lipase [Enzymatic activity/volume] in Serum or
	 * Plasma</div> .
	 */
	LIPASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA("3040-3", "2.16.840.1.113883.6.1",
			"Lipase [Enzymatic activity/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Magnesium [Moles/volume] in Serum or Plasma</div>. */
	MAGNESIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("2601-3", "2.16.840.1.113883.6.1",
			"Magnesium [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/**
	 * <div class="en">Microscopic observation [Identifier] in Urine sediment by
	 * Light microscopy</div>.
	 */
	MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY("12235-8",
			"2.16.840.1.113883.6.1",
			"Microscopic observation [Identifier] in Urine sediment by Light microscopy", "18729-4",
			"20140101", ""),

	/** <div class="en">Osmolality of Serum or Plasma</div>. */
	OSMOLALITY_OF_SERUM_OR_PLASMA("2692-2", "2.16.840.1.113883.6.1",
			"Osmolality of Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Osmolality of Urine</div>. */
	OSMOLALITY_OF_URINE("2695-5", "2.16.840.1.113883.6.1", "Osmolality of Urine", "18719-5",
			"20140101", ""),

	/** <div class="en">Oxygen [Partial pressure] in Blood</div>. */
	OXYGEN_PARTIAL_PRESSURE_IN_BLOOD("11556-8", "2.16.840.1.113883.6.1",
			"Oxygen [Partial pressure] in Blood", "18767-4", "20140101", ""),

	/** <div class="en">Oxygen saturation in Mixed venous blood</div>. */
	OXYGEN_SATURATION_IN_MIXED_VENOUS_BLOOD("19224-5", "2.16.840.1.113883.6.1",
			"Oxygen saturation in Mixed venous blood", "18767-4", "20140101", ""),

	/** <div class="en">pH of Blood</div>. */
	PH_OF_BLOOD("11558-4", "2.16.840.1.113883.6.1", "pH of Blood", "18767-4", "20140101", ""),

	/** <div class="en">pH of Urine by Test strip</div>. */
	PH_OF_URINE_BY_TEST_STRIP("5803-2", "2.16.840.1.113883.6.1", "pH of Urine by Test strip",
			"18729-4", "20140101", ""),

	/** <div class="en">Phosphate [Moles/volume] in Serum or Plasma</div>. */
	PHOSPHATE_MOLESVOLUME_IN_SERUM_OR_PLASMA("14879-1", "2.16.840.1.113883.6.1",
			"Phosphate [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Platelets [#/volume] in Blood</div>. */
	PLATELETS_VOLUME_IN_BLOOD("26515-7", "2.16.840.1.113883.6.1", "Platelets [#/volume] in Blood",
			"18768-2", "20140101", ""),

	/** <div class="en">Potassium [Moles/volume] in Serum or Plasma</div>. */
	POTASSIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("2823-3", "2.16.840.1.113883.6.1",
			"Potassium [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Potassium [Moles/volume] in Urine</div>. */
	POTASSIUM_MOLESVOLUME_IN_URINE("2828-2", "2.16.840.1.113883.6.1",
			"Potassium [Moles/volume] in Urine", "18719-5", "20140101", ""),

	/** <div class="en">Protein [Mass/volume] in Serum or Plasma</div>. */
	PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA("2885-2", "2.16.840.1.113883.6.1",
			"Protein [Mass/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Protein [Presence] in Urine by Test strip</div>. */
	PROTEIN_PRESENCE_IN_URINE_BY_TEST_STRIP("20454-5", "2.16.840.1.113883.6.1",
			"Protein [Presence] in Urine by Test strip", "18719-5", "20140101", ""),

	/**
	 * <div class="en">Prothrombin time (PT) PIVKA insensitive actual/normal in
	 * Platelet poor plasma by Coagulation assay</div>.
	 */
	PROTHROMBIN_TIME_PT_PIVKA_INSENSITIVE_ACTUALNORMAL_IN_PLATELET_POOR_PLASMA_BY_COAGULATION_ASSAY(
			"52753-1", "2.16.840.1.113883.6.1",
			"Prothrombin time (PT) PIVKA insensitive actual/normal in Platelet poor plasma by Coagulation assay",
			"18720-3", "20140101", ""),

	/** <div class="en">Reagin Ab [Presence] in Serum by VDRL</div>. */
	REAGIN_AB_PRESENCE_IN_SERUM_BY_VDRL("5292-8", "2.16.840.1.113883.6.1",
			"Reagin Ab [Presence] in Serum by VDRL", "18725-2", "20140101", ""),

	/**
	 * <div class="en">Renal tubular casts [#/area] in Urine by Light
	 * microscopy</div>.
	 */
	RENAL_TUBULAR_CASTS_AREA_IN_URINE_BY_LIGHT_MICROSCOPY("30079-8", "2.16.840.1.113883.6.1",
			"Renal tubular casts [#/area] in Urine by Light microscopy", "18729-4", "20140101", ""),

	/** <div class="en">Sodium [Moles/volume] in Serum or Plasma</div>. */
	SODIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA("2951-2", "2.16.840.1.113883.6.1",
			"Sodium [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Sodium [Moles/volume] in Urine</div>. */
	SODIUM_MOLESVOLUME_IN_URINE("2955-3", "2.16.840.1.113883.6.1", "Sodium [Moles/volume] in Urine",
			"18719-5", "20140101", ""),

	/** <div class="en">Toxoplasma gondii IgG Ab [Presence] in Serum</div>. */
	TOXOPLASMA_GONDII_IGG_AB_PRESENCE_IN_SERUM("22580-5", "2.16.840.1.113883.6.1",
			"Toxoplasma gondii IgG Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/** <div class="en">Toxoplasma gondii IgM Ab [Presence] in Serum</div>. */
	TOXOPLASMA_GONDII_IGM_AB_PRESENCE_IN_SERUM("25542-2", "2.16.840.1.113883.6.1",
			"Toxoplasma gondii IgM Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/**
	 * <div class="en">Treponema pallidum Ab [Presence] in Serum by
	 * Hemagglutination</div>.
	 */
	TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_HEMAGGLUTINATION("8041-6", "2.16.840.1.113883.6.1",
			"Treponema pallidum Ab [Presence] in Serum by Hemagglutination", "18725-2", "20140101",
			""),
	/**
	 * <div class="en">Troponin T.cardiac [Mass/volume] in Venous blood</div>
	 */
	TROPONIN_T_CARDIAC_MASSVOLUME_IN_VENOUS_BLOOD("6597-9", "2.16.840.1.113883.6.1",
			"Troponin T.cardiac [Mass/volume] in Venous blood", "18719-5", "20140101", ""),

	/** <div class="en">Unspecified A- HLA-Antigene</div>. */
	UNSPECIFIED_A_HLA_ANTIGENE("A-", "2.16.756.5.30.1.129.1.1.8", "Unspecified A- HLA-Antigene",
			"18724-5", "20140101", ""),

	/** <div class="en">Unspecified B- HLA-Antigene</div>. */
	UNSPECIFIED_B_HLA_ANTIGENE("B-", "2.16.756.5.30.1.129.1.1.8", "Unspecified B- HLA-Antigene",
			"18724-5", "20140101", ""),

	/** <div class="en">Unspecified DQ- HLA-Antigene</div>. */
	UNSPECIFIED_DQ_HLA_ANTIGENE("DQ-", "2.16.756.5.30.1.129.1.1.8", "Unspecified DQ- HLA-Antigene",
			"18724-5", "20140101", ""),

	/** <div class="en">Unspecified DR- HLA-Antigene</div>. */
	UNSPECIFIED_DR_HLA_ANTIGENE("DR-", "2.16.756.5.30.1.129.1.1.8", "Unspecified DR- HLA-Antigene",
			"18724-5", "20140101", ""),

	/** <div class="en">Urea [Moles/volume] in Serum or Plasma</div>. */
	UREA_MOLESVOLUME_IN_SERUM_OR_PLASMA("22664-7", "2.16.840.1.113883.6.1",
			"Urea [Moles/volume] in Serum or Plasma", "18719-5", "20140101", ""),

	/** <div class="en">Urobilinogen [Moles/volume] in Urine</div>. */
	UROBILINOGEN_MOLESVOLUME_IN_URINE("34927-4", "2.16.840.1.113883.6.1",
			"Urobilinogen [Moles/volume] in Urine", "18719-5", "20140101", ""),

	/** <div class="en">Urobilinogen [Presence] in Urine</div>. */
	UROBILINOGEN_PRESENCE_IN_URINE("13658-0", "2.16.840.1.113883.6.1",
			"Urobilinogen [Presence] in Urine", "18719-5", "20140101", ""),

	/**
	 * <div class="en">Varicella zoster virus IgG Ab [Presence] in Serum</div>.
	 */
	VARICELLA_ZOSTER_VIRUS_IGG_AB_PRESENCE_IN_SERUM("19162-7", "2.16.840.1.113883.6.1",
			"Varicella zoster virus IgG Ab [Presence] in Serum", "18725-2", "20140101", ""),

	/**
	 * <div class="en">Varicella zoster virus IgM Ab [Presence] in Serum</div>.
	 */
	VARICELLA_ZOSTER_VIRUS_IGM_AB_PRESENCE_IN_SERUM("21597-0", "2.16.840.1.113883.6.1",
			"Varicella zoster virus IgM Ab [Presence] in Serum", "18725-2", "20140101", "");

	/** <div class="en">Code for A1 HLA-Antigene</div>. */
	public static final String A1_HLA_ANTIGENE_CODE = "A1";

	/** <div class="en">Code for A11 HLA-Antigene</div>. */
	public static final String A11_HLA_ANTIGENE_CODE = "A11";

	/** <div class="en">Code for A2 HLA-Antigene</div>. */
	public static final String A2_HLA_ANTIGENE_CODE = "A2";

	/** <div class="en">Code for A203 HLA-Antigene</div>. */
	public static final String A203_HLA_ANTIGENE_CODE = "A203";

	/** <div class="en">Code for A210 HLA-Antigene</div>. */
	public static final String A210_HLA_ANTIGENE_CODE = "A210";

	/** <div class="en">Code for A23(9) HLA-Antigene</div>. */
	public static final String A239_HLA_ANTIGENE_CODE = "A23";

	/** <div class="en">Code for A24(9) HLA-Antigene</div>. */
	public static final String A249_HLA_ANTIGENE_CODE = "A24";

	/** <div class="en">Code for A25(10) HLA-Antigene</div>. */
	public static final String A2510_HLA_ANTIGENE_CODE = "A25";

	/** <div class="en">Code for A26(10) HLA-Antigene</div>. */
	public static final String A2610_HLA_ANTIGENE_CODE = "A26";

	/** <div class="en">Code for A29(19) HLA-Antigene</div>. */
	public static final String A2919_HLA_ANTIGENE_CODE = "A29";

	/** <div class="en">Code for A3 HLA-Antigene</div>. */
	public static final String A3_HLA_ANTIGENE_CODE = "A3";

	/** <div class="en">Code for A30(19) HLA-Antigene</div>. */
	public static final String A3019_HLA_ANTIGENE_CODE = "A30";

	/** <div class="en">Code for A31(19) HLA-Antigene</div>. */
	public static final String A3119_HLA_ANTIGENE_CODE = "A31";

	/** <div class="en">Code for A32(19) HLA-Antigene</div>. */
	public static final String A3219_HLA_ANTIGENE_CODE = "A32";

	/** <div class="en">Code for A33(19) HLA-Antigene</div>. */
	public static final String A3319_HLA_ANTIGENE_CODE = "A33";

	/** <div class="en">Code for A34(10) HLA-Antigene</div>. */
	public static final String A3410_HLA_ANTIGENE_CODE = "A34";

	/** <div class="en">Code for A36 HLA-Antigene</div>. */
	public static final String A36_HLA_ANTIGENE_CODE = "A36";

	/** <div class="en">Code for A43 HLA-Antigene</div>. */
	public static final String A43_HLA_ANTIGENE_CODE = "A43";

	/** <div class="en">Code for A66(10) HLA-Antigene</div>. */
	public static final String A6610_HLA_ANTIGENE_CODE = "A66";

	/** <div class="en">Code for A68(28) HLA-Antigene</div>. */
	public static final String A6828_HLA_ANTIGENE_CODE = "A68";

	/** <div class="en">Code for A69(28) HLA-Antigene</div>. */
	public static final String A6928_HLA_ANTIGENE_CODE = "A69";

	/** <div class="en">Code for A74(19) HLA-Antigene</div>. */
	public static final String A7419_HLA_ANTIGENE_CODE = "A74";

	/** <div class="en">Code for A80 HLA-Antigene</div>. */
	public static final String A80_HLA_ANTIGENE_CODE = "A80";

	/**
	 * <div class="en">Code for Activated partial thromboplastin time (aPTT) in
	 * Blood by Coagulation assay</div>.
	 */
	public static final String ACTIVATED_PARTIAL_THROMBOPLASTIN_TIME_APTT_IN_BLOOD_BY_COAGULATION_ASSAY_CODE = "3173-2";

	/**
	 * <div class="en">Code for Alanine aminotransferase [Enzymatic
	 * activity/volume] in Serum or Plasma</div>.
	 */
	public static final String ALANINE_AMINOTRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "1742-6";

	/**
	 * <div class="en">Code for Albumin [Mass/volume] in Serum or Plasma</div>.
	 */
	public static final String ALBUMIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "1751-7";

	/**
	 * <div class="en">Code for Alkaline phosphatase.liver+bone [Presence] in
	 * Serum or Plasma</div>
	 */
	public static final String ALKALINE_PHOSPHATASE_LIVER_BONE_PRESENCE_IN_SERUM_OR_PLASMA_CODE = "43708-7";

	/** <div class="en">Code for Ammonium ion [Moles/volume] in Plasma</div>. */
	public static final String AMMONIUM_ION_MOLESVOLUME_IN_PLASMA_CODE = "1845-7";

	/**
	 * <div class="en">Code for Amylase.pancreatic [Enzymatic activity/volume]
	 * in Serum or Plasma</div>
	 */
	public static final String AMYLASE_PANCREATIC_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "1805-1";

	/**
	 * <div class="en">Code for Aspartate aminotransferase [Enzymatic
	 * activity/volume] in Serum or Plasma</div>.
	 */
	public static final String ASPARTATE_AMINOTRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "1920-8";

	/** <div class="en">Code for B13 HLA-Antigene</div>. */
	public static final String B13_HLA_ANTIGENE_CODE = "B13";

	/** <div class="en">Code for B18 HLA-Antigene</div>. */
	public static final String B18_HLA_ANTIGENE_CODE = "B18";

	/** <div class="en">Code for B27 HLA-Antigene</div>. */
	public static final String B27_HLA_ANTIGENE_CODE = "B27";

	/** <div class="en">Code for B35 HLA-Antigene</div>. */
	public static final String B35_HLA_ANTIGENE_CODE = "B35";

	/** <div class="en">Code for B37 HLA-Antigene</div>. */
	public static final String B37_HLA_ANTIGENE_CODE = "B37";

	/** <div class="en">Code for B38(16) HLA-Antigene</div>. */
	public static final String B3816_HLA_ANTIGENE_CODE = "B38";

	/** <div class="en">Code for B3901 HLA-Antigene</div>. */
	public static final String B3901_HLA_ANTIGENE_CODE = "B3901";

	/** <div class="en">Code for B3902 HLA-Antigene</div>. */
	public static final String B3902_HLA_ANTIGENE_CODE = "B3902";

	/** <div class="en">Code for B39(16) HLA-Antigene</div>. */
	public static final String B3916_HLA_ANTIGENE_CODE = "B39";

	/** <div class="en">Code for B4005 HLA-Antigene</div>. */
	public static final String B4005_HLA_ANTIGENE_CODE = "B4005";

	/** <div class="en">Code for B41 HLA-Antigene</div>. */
	public static final String B41_HLA_ANTIGENE_CODE = "B41";

	/** <div class="en">Code for B42 HLA-Antigene</div>. */
	public static final String B42_HLA_ANTIGENE_CODE = "B42";

	/** <div class="en">Code for B44(12) HLA-Antigene</div>. */
	public static final String B4412_HLA_ANTIGENE_CODE = "B44";

	/** <div class="en">Code for B45(12) HLA-Antigene</div>. */
	public static final String B4512_HLA_ANTIGENE_CODE = "B45";

	/** <div class="en">Code for B46 HLA-Antigene</div>. */
	public static final String B46_HLA_ANTIGENE_CODE = "B46";

	/** <div class="en">Code for B47 HLA-Antigene</div>. */
	public static final String B47_HLA_ANTIGENE_CODE = "B47";

	/** <div class="en">Code for B48 HLA-Antigene</div>. */
	public static final String B48_HLA_ANTIGENE_CODE = "B48";

	/** <div class="en">Code for B49(21) HLA-Antigene</div>. */
	public static final String B4921_HLA_ANTIGENE_CODE = "B49";

	/** <div class="en">Code for B50(21) HLA-Antigene</div>. */
	public static final String B5021_HLA_ANTIGENE_CODE = "B50";

	/** <div class="en">Code for B5102 HLA-Antigene</div>. */
	public static final String B5102_HLA_ANTIGENE_CODE = "B5102";

	/** <div class="en">Code for B5103 HLA-Antigene</div>. */
	public static final String B5103_HLA_ANTIGENE_CODE = "B5103";

	/** <div class="en">Code for B51(5) HLA-Antigene</div>. */
	public static final String B515_HLA_ANTIGENE_CODE = "B51";

	/** <div class="en">Code for B52(5) HLA-Antigene</div>. */
	public static final String B525_HLA_ANTIGENE_CODE = "B52";

	/** <div class="en">Code for B53 HLA-Antigene</div>. */
	public static final String B53_HLA_ANTIGENE_CODE = "B53";

	/** <div class="en">Code for B54(22) HLA-Antigene</div>. */
	public static final String B5422_HLA_ANTIGENE_CODE = "B54";

	/** <div class="en">Code for B55(22) HLA-Antigene</div>. */
	public static final String B5522_HLA_ANTIGENE_CODE = "B55";

	/** <div class="en">Code for B56(22) HLA-Antigene</div>. */
	public static final String B5622_HLA_ANTIGENE_CODE = "B56";

	/** <div class="en">Code for B57(17) HLA-Antigene</div>. */
	public static final String B5717_HLA_ANTIGENE_CODE = "B57";

	/** <div class="en">Code for B58(17) HLA-Antigene</div>. */
	public static final String B5817_HLA_ANTIGENE_CODE = "B58";

	/** <div class="en">Code for B59 HLA-Antigene</div>. */
	public static final String B59_HLA_ANTIGENE_CODE = "B59";

	/** <div class="en">Code for B60(40) HLA-Antigene</div>. */
	public static final String B6040_HLA_ANTIGENE_CODE = "B60";

	/** <div class="en">Code for B61(40) HLA-Antigene</div>. */
	public static final String B6140_HLA_ANTIGENE_CODE = "B61";

	/** <div class="en">Code for B62(15) HLA-Antigene</div>. */
	public static final String B6215_HLA_ANTIGENE_CODE = "B62";

	/** <div class="en">Code for B63(15) HLA-Antigene</div>. */
	public static final String B6315_HLA_ANTIGENE_CODE = "B63";

	/** <div class="en">Code for B64(14) HLA-Antigene</div>. */
	public static final String B6414_HLA_ANTIGENE_CODE = "B64";

	/** <div class="en">Code for B65(14) HLA-Antigene</div>. */
	public static final String B6514_HLA_ANTIGENE_CODE = "B65";

	/** <div class="en">Code for B67 HLA-Antigene</div>. */
	public static final String B67_HLA_ANTIGENE_CODE = "B67";

	/** <div class="en">Code for B7 HLA-Antigene</div>. */
	public static final String B7_HLA_ANTIGENE_CODE = "B7";

	/** <div class="en">Code for B703 HLA-Antigene</div>. */
	public static final String B703_HLA_ANTIGENE_CODE = "B703";

	/** <div class="en">Code for B71(70) HLA-Antigene</div>. */
	public static final String B7170_HLA_ANTIGENE_CODE = "B71";

	/** <div class="en">Code for B72(70) HLA-Antigene</div>. */
	public static final String B7270_HLA_ANTIGENE_CODE = "B72";

	/** <div class="en">Code for B73 HLA-Antigene</div>. */
	public static final String B73_HLA_ANTIGENE_CODE = "B73";

	/** <div class="en">Code for B75(15) HLA-Antigene</div>. */
	public static final String B7515_HLA_ANTIGENE_CODE = "B75";

	/** <div class="en">Code for B76(15) HLA-Antigene</div>. */
	public static final String B7615_HLA_ANTIGENE_CODE = "B76";

	/** <div class="en">Code for B77(15) HLA-Antigene</div>. */
	public static final String B7715_HLA_ANTIGENE_CODE = "B77";

	/** <div class="en">Code for B78 HLA-Antigene</div>. */
	public static final String B78_HLA_ANTIGENE_CODE = "B78";

	/** <div class="en">Code for B8 HLA-Antigene</div>. */
	public static final String B8_HLA_ANTIGENE_CODE = "B8";

	/** <div class="en">Code for B81 HLA-Antigene</div>. */
	public static final String B81_HLA_ANTIGENE_CODE = "B81";

	/** <div class="en">Code for B82 HLA-Antigene</div>. */
	public static final String B82_HLA_ANTIGENE_CODE = "B82";

	/** <div class="en">Code for Base excess in Blood by calculation</div>. */
	public static final String BASE_EXCESS_IN_BLOOD_BY_CALCULATION_CODE = "11555-0";

	/**
	 * <div class="en">Code for Bilirubin.direct [Moles/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String BILIRUBIN_DIRECT_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14629-0";

	/**
	 * <div class="en">Code for Bilirubin.total [Mass/volume] in Urine by Test
	 * strip</div>
	 */
	public static final String BILIRUBIN_TOTAL_MASSVOLUME_IN_URINE_BY_TEST_STRIP_CODE = "20505-4";

	/**
	 * <div class="en">Code for Bilirubin.total [Moles/volume] in Blood</div>
	 */
	public static final String BILIRUBIN_TOTAL_MOLESVOLUME_IN_BLOOD_CODE = "54363-7";

	/**
	 * <div class="en">Code for C reactive protein [Mass/volume] in Serum or
	 * Plasma</div>.
	 */
	public static final String C_REACTIVE_PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "1988-5";

	/**
	 * <div class="en">Code for Calcium [Moles/volume] in Serum or Plasma</div>.
	 */
	public static final String CALCIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2000-8";

	/**
	 * <div class="en">Code for Carbon dioxide [Partial pressure] in Blood</div>
	 * .
	 */
	public static final String CARBON_DIOXIDE_PARTIAL_PRESSURE_IN_BLOOD_CODE = "11557-6";

	/** <div class="en">Code for Carbonate [Mass/volume] in Plasma</div>. */
	public static final String CARBONATE_MASSVOLUME_IN_PLASMA_CODE = "2035-4";

	/**
	 * <div class="en">Code for Coagulation factor V activity actual/normal in
	 * Platelet poor plasma by Coagulation assay</div>.
	 */
	public static final String COAGULATION_FACTOR_V_ACTIVITY_ACTUALNORMAL_IN_PLATELET_POOR_PLASMA_BY_COAGULATION_ASSAY_CODE = "3193-0";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>.
	 */
	public static final String CODE_SYSTEM_NAME = "LOINC";

	/**
	 * <div class="en">Code for Creatine kinase [Enzymatic activity/volume] in
	 * Serum or Plasma</div>.
	 */
	public static final String CREATINE_KINASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "2157-6";

	/**
	 * <div class="en">Code for Creatine kinase.MB [Mass/volume] in Serum or
	 * Plasma</div>
	 */
	public static final String CREATINE_KINASE_MB_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "13969-1";

	/**
	 * <div class="en">Code for Creatinine [Moles/volume] in Serum or
	 * Plasma</div> .
	 */
	public static final String CREATININE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14682-9";

	/**
	 * <div class="en">Code for Cytomegalovirus Ab [Presence] in Serum</div>.
	 */
	public static final String CYTOMEGALOVIRUS_AB_PRESENCE_IN_SERUM_CODE = "22239-8";

	/**
	 * <div class="en">Code for Cytomegalovirus IgG Ab [Presence] in Serum</div>
	 * .
	 */
	public static final String CYTOMEGALOVIRUS_IGG_AB_PRESENCE_IN_SERUM_CODE = "22244-8";

	/**
	 * <div class="en">Code for Cytomegalovirus IgM Ab [Presence] in Serum</div>
	 * .
	 */
	public static final String CYTOMEGALOVIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE = "30325-5";

	/** <div class="en">Code for DQ2 HLA-Antigene</div>. */
	public static final String DQ2_HLA_ANTIGENE_CODE = "DQ2";

	/** <div class="en">Code for DQ4 HLA-Antigene</div>. */
	public static final String DQ4_HLA_ANTIGENE_CODE = "DQ4";

	/** <div class="en">Code for DQ5(1) HLA-Antigene</div>. */
	public static final String DQ51_HLA_ANTIGENE_CODE = "DQ5";

	/** <div class="en">Code for DQ6(1) HLA-Antigene</div>. */
	public static final String DQ61_HLA_ANTIGENE_CODE = "DQ6";

	/** <div class="en">Code for DQ7(3) HLA-Antigene</div>. */
	public static final String DQ73_HLA_ANTIGENE_CODE = "DQ7";

	/** <div class="en">Code for DQ8(3) HLA-Antigene</div>. */
	public static final String DQ83_HLA_ANTIGENE_CODE = "DQ8";

	/** <div class="en">Code for DQ9(3) HLA-Antigene</div>. */
	public static final String DQ93_HLA_ANTIGENE_CODE = "DQ9";

	/** <div class="en">Code for DR1 HLA-Antigene</div>. */
	public static final String DR1_HLA_ANTIGENE_CODE = "DR1";

	/** <div class="en">Code for DR10 HLA-Antigene</div>. */
	public static final String DR10_HLA_ANTIGENE_CODE = "DR10";

	/** <div class="en">Code for DR103 HLA-Antigene</div>. */
	public static final String DR103_HLA_ANTIGENE_CODE = "DR103";

	/** <div class="en">Code for DR11(5) HLA-Antigene</div>. */
	public static final String DR115_HLA_ANTIGENE_CODE = "DR11";

	/** <div class="en">Code for DR12(5) HLA-Antigene</div>. */
	public static final String DR125_HLA_ANTIGENE_CODE = "DR12";

	/** <div class="en">Code for DR13(6) HLA-Antigene</div>. */
	public static final String DR136_HLA_ANTIGENE_CODE = "DR13";

	/** <div class="en">Code for DR1403 HLA-Antigene</div>. */
	public static final String DR1403_HLA_ANTIGENE_CODE = "DR1403";

	/** <div class="en">Code for DR1404 HLA-Antigene</div>. */
	public static final String DR1404_HLA_ANTIGENE_CODE = "DR1404";

	/** <div class="en">Code for DR14(6) HLA-Antigene</div>. */
	public static final String DR146_HLA_ANTIGENE_CODE = "DR14";

	/** <div class="en">Code for DR15(2) HLA-Antigene</div>. */
	public static final String DR152_HLA_ANTIGENE_CODE = "DR15";

	/** <div class="en">Code for DR16(2) HLA-Antigene</div>. */
	public static final String DR162_HLA_ANTIGENE_CODE = "DR16";

	/** <div class="en">Code for DR17(3) HLA-Antigene</div>. */
	public static final String DR173_HLA_ANTIGENE_CODE = "DR17";

	/** <div class="en">Code for DR18(3) HLA-Antigene</div>. */
	public static final String DR183_HLA_ANTIGENE_CODE = "DR18";

	/** <div class="en">Code for DR4 HLA-Antigene</div>. */
	public static final String DR4_HLA_ANTIGENE_CODE = "DR4";

	/** <div class="en">Code for DR7 HLA-Antigene</div>. */
	public static final String DR7_HLA_ANTIGENE_CODE = "DR7";

	/** <div class="en">Code for DR8 HLA-Antigene</div>. */
	public static final String DR8_HLA_ANTIGENE_CODE = "DR8";

	/** <div class="en">Code for DR9 HLA-Antigene</div>. */
	public static final String DR9_HLA_ANTIGENE_CODE = "DR9";

	/**
	 * <div class="en">Code for Epstein Barr virus Ab [Presence] in Serum</div>.
	 */
	public static final String EPSTEIN_BARR_VIRUS_AB_PRESENCE_IN_SERUM_CODE = "49178-7";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgG Ab [Presence] in
	 * Serum</div>.
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGG_AB_PRESENCE_IN_SERUM_CODE = "30339-6";

	/**
	 * <div class="en">Code for Epstein Barr virus capsid IgM Ab [Presence] in
	 * Serum</div>.
	 */
	public static final String EPSTEIN_BARR_VIRUS_CAPSID_IGM_AB_PRESENCE_IN_SERUM_CODE = "30340-4";

	/** <div class="en">Code for Erythrocytes [#/volume] in Urine</div>. */
	public static final String ERYTHROCYTES_VOLUME_IN_URINE_CODE = "30391-7";

	/**
	 * <div class="en">Code for Fibrinogen Ag [Mass/volume] in Platelet poor
	 * plasma by Immunologic method</div>.
	 */
	public static final String FIBRINOGEN_AG_MASSVOLUME_IN_PLATELET_POOR_PLASMA_BY_IMMUNOLOGIC_METHOD_CODE = "3256-5";

	/** <div class="en">Code for Fractional oxyhemoglobin in Blood</div>. */
	public static final String FRACTIONAL_OXYHEMOGLOBIN_IN_BLOOD_CODE = "11559-2";

	/**
	 * <div class="en">Code for Gamma glutamyl transferase [Enzymatic
	 * activity/volume] in Serum or Plasma</div>.
	 */
	public static final String GAMMA_GLUTAMYL_TRANSFERASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "2324-2";

	/**
	 * <div class="en">Code for Glucose [Moles/volume] in Serum or Plasma</div>.
	 */
	public static final String GLUCOSE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14749-6";

	/**
	 * <div class="en">Code for Glucose [Moles/volume] in Urine by Test
	 * strip</div>.
	 */
	public static final String GLUCOSE_MOLESVOLUME_IN_URINE_BY_TEST_STRIP_CODE = "22705-8";

	/** <div class="en">Code for Hematocrit [Volume Fraction] of Blood</div>. */
	public static final String HEMATOCRIT_VOLUME_FRACTION_OF_BLOOD_CODE = "20570-8";

	/**
	 * <div class="en">Code for Hemoglobin A1c/Hemoglobin.total in Blood</div>
	 */
	public static final String HEMOGLOBIN_A1CHEMOGLOBIN_TOTAL_IN_BLOOD_CODE = "4548-4";

	/** <div class="en">Code for Hemoglobin [Mass/volume] in Blood</div>. */
	public static final String HEMOGLOBIN_MASSVOLUME_IN_BLOOD_CODE = "718-7";

	/**
	 * <div class="en">Code for Hepatitis B virus core Ab [Presence] in
	 * Serum</div>.
	 */
	public static final String HEPATITIS_B_VIRUS_CORE_AB_PRESENCE_IN_SERUM_CODE = "16933-4";

	/**
	 * <div class="en">Code for Hepatitis B virus e Ab [Presence] in Serum</div>
	 * .
	 */
	public static final String HEPATITIS_B_VIRUS_E_AB_PRESENCE_IN_SERUM_CODE = "22320-6";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ab [Presence] in
	 * Serum</div>.
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AB_PRESENCE_IN_SERUM_CODE = "22322-2";

	/**
	 * <div class="en">Code for Hepatitis B virus surface Ag [Presence] in
	 * Serum</div>.
	 */
	public static final String HEPATITIS_B_VIRUS_SURFACE_AG_PRESENCE_IN_SERUM_CODE = "5195-3";

	/**
	 * <div class="en">Code for Hepatitis C virus Ab [Presence] in Serum</div>.
	 */
	public static final String HEPATITIS_C_VIRUS_AB_PRESENCE_IN_SERUM_CODE = "16128-1";

	/**
	 * <div class="en">Code for Hepatitis C virus RNA [Presence] in Serum or
	 * Plasma by Probe and target amplification method</div>.
	 */
	public static final String HEPATITIS_C_VIRUS_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "11259-9";

	/**
	 * <div class="en">Code for Herpes simplex virus 1 and 2 IgG Ab
	 * [interpretation] in Serum by Immunoassay</div>.
	 */
	public static final String HERPES_SIMPLEX_VIRUS_1_AND_2_IGG_AB_INTERPRETATION_IN_SERUM_BY_IMMUNOASSAY_CODE = "44009-9";

	/**
	 * <div class="en">Code for Herpes simplex virus 1 and 2 IgM Ab
	 * [interpretation] in Serum</div>.
	 */
	public static final String HERPES_SIMPLEX_VIRUS_1_AND_2_IGM_AB_INTERPRETATION_IN_SERUM_CODE = "44008-1";

	/** <div class="en">Code for HIV 1 Ab [Presence] in Serum</div>. */
	public static final String HIV_1_AB_PRESENCE_IN_SERUM_CODE = "7917-8";

	/** <div class="en">Code for HIV 1 p24 Ag [Presence] in Serum</div>. */
	public static final String HIV_1_P24_AG_PRESENCE_IN_SERUM_CODE = "9821-0";

	/**
	 * <div class="en">Code for HIV 1 RNA [Presence] in Blood by Probe and
	 * target amplification method</div>.
	 */
	public static final String HIV_1_RNA_PRESENCE_IN_BLOOD_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "5017-9";

	/** <div class="en">Code for HIV 2 Ab [Presence] in Serum</div>. */
	public static final String HIV_2_AB_PRESENCE_IN_SERUM_CODE = "7919-4";

	/**
	 * <div class="en">Code for HIV 2 RNA [Presence] in Serum or Plasma by Probe
	 * and target amplification method</div>.
	 */
	public static final String HIV_2_RNA_PRESENCE_IN_SERUM_OR_PLASMA_BY_PROBE_AND_TARGET_AMPLIFICATION_METHOD_CODE = "69353-1";

	/** <div class="en">Code for HLA-Antibody A1- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A1_MFI_VALUE_CODE = "Anti-A1-MFI";

	/** <div class="en">Code for HLA-Antibody A11- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A11_MFI_VALUE_CODE = "Anti-A11-MFI";

	/** <div class="en">Code for HLA-Antibody A2- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A2_MFI_VALUE_CODE = "Anti-A2-MFI";

	/** <div class="en">Code for HLA-Antibody A203- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A203_MFI_VALUE_CODE = "Anti-A203-MFI";

	/** <div class="en">Code for HLA-Antibody A210- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A210_MFI_VALUE_CODE = "Anti-A210-MFI";

	/** <div class="en">Code for HLA-Antibody A23(9)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A239_MFI_VALUE_CODE = "Anti-A23-MFI";

	/** <div class="en">Code for HLA-Antibody A24(9)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A249_MFI_VALUE_CODE = "Anti-A24-MFI";

	/** <div class="en">Code for HLA-Antibody A25(10)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A2510_MFI_VALUE_CODE = "Anti-A25-MFI";

	/** <div class="en">Code for HLA-Antibody A26(10)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A2610_MFI_VALUE_CODE = "Anti-A26-MFI";

	/** <div class="en">Code for HLA-Antibody A29(19)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A2919_MFI_VALUE_CODE = "Anti-A29-MFI";

	/** <div class="en">Code for HLA-Antibody A3- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A3_MFI_VALUE_CODE = "Anti-A3-MFI";

	/** <div class="en">Code for HLA-Antibody A30(19)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A3019_MFI_VALUE_CODE = "Anti-A30-MFI";

	/** <div class="en">Code for HLA-Antibody A31(19)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A3119_MFI_VALUE_CODE = "Anti-A31-MFI";

	/** <div class="en">Code for HLA-Antibody A32(19)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A3219_MFI_VALUE_CODE = "Anti-A32-MFI";

	/** <div class="en">Code for HLA-Antibody A33(19)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A3319_MFI_VALUE_CODE = "Anti-A33-MFI";

	/** <div class="en">Code for HLA-Antibody A34(10)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A3410_MFI_VALUE_CODE = "Anti-A34-MFI";

	/** <div class="en">Code for HLA-Antibody A36- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A36_MFI_VALUE_CODE = "Anti-A36-MFI";

	/** <div class="en">Code for HLA-Antibody A43- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A43_MFI_VALUE_CODE = "Anti-A43-MFI";

	/** <div class="en">Code for HLA-Antibody A66(10)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A6610_MFI_VALUE_CODE = "Anti-A66-MFI";

	/** <div class="en">Code for HLA-Antibody A68(28)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A6828_MFI_VALUE_CODE = "Anti-A68-MFI";

	/** <div class="en">Code for HLA-Antibody A69(28)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A6928_MFI_VALUE_CODE = "Anti-A69-MFI";

	/** <div class="en">Code for HLA-Antibody A74(19)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A7419_MFI_VALUE_CODE = "Anti-A74-MFI";

	/** <div class="en">Code for HLA-Antibody A80- MFI Value</div>. */
	public static final String HLA_ANTIBODY_A80_MFI_VALUE_CODE = "Anti-A80-MFI";

	/** <div class="en">Code for HLA-Antibody B13- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B13_MFI_VALUE_CODE = "Anti-B13-MFI";

	/** <div class="en">Code for HLA-Antibody B18- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B18_MFI_VALUE_CODE = "Anti-B18-MFI";

	/** <div class="en">Code for HLA-Antibody B27- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B27_MFI_VALUE_CODE = "Anti-B27-MFI";

	/** <div class="en">Code for HLA-Antibody B35- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B35_MFI_VALUE_CODE = "Anti-B35-MFI";

	/** <div class="en">Code for HLA-Antibody B37- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B37_MFI_VALUE_CODE = "Anti-B37-MFI";

	/** <div class="en">Code for HLA-Antibody B38(16)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B3816_MFI_VALUE_CODE = "Anti-B38-MFI";

	/** <div class="en">Code for HLA-Antibody B3901- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B3901_MFI_VALUE_CODE = "Anti-B3901-MFI";

	/** <div class="en">Code for HLA-Antibody B3902- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B3902_MFI_VALUE_CODE = "Anti-B3902-MFI";

	/** <div class="en">Code for HLA-Antibody B39(16)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B3916_MFI_VALUE_CODE = "Anti-B39-MFI";

	/** <div class="en">Code for HLA-Antibody B4005- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B4005_MFI_VALUE_CODE = "Anti-B4005-MFI";

	/** <div class="en">Code for HLA-Antibody B41- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B41_MFI_VALUE_CODE = "Anti-B41-MFI";

	/** <div class="en">Code for HLA-Antibody B42- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B42_MFI_VALUE_CODE = "Anti-B42-MFI";

	/** <div class="en">Code for HLA-Antibody B44(12)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B4412_MFI_VALUE_CODE = "Anti-B44-MFI";

	/** <div class="en">Code for HLA-Antibody B45(12)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B4512_MFI_VALUE_CODE = "Anti-B45-MFI";

	/** <div class="en">Code for HLA-Antibody B46- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B46_MFI_VALUE_CODE = "Anti-B46-MFI";

	/** <div class="en">Code for HLA-Antibody B47- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B47_MFI_VALUE_CODE = "Anti-B47-MFI";

	/** <div class="en">Code for HLA-Antibody B48- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B48_MFI_VALUE_CODE = "Anti-B48-MFI";

	/** <div class="en">Code for HLA-Antibody B49(21)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B4921_MFI_VALUE_CODE = "Anti-B49-MFI";

	/** <div class="en">Code for HLA-Antibody B50(21)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B5021_MFI_VALUE_CODE = "Anti-B50-MFI";

	/** <div class="en">Code for HLA-Antibody B5102- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B5102_MFI_VALUE_CODE = "Anti-B5102-MFI";

	/** <div class="en">Code for HLA-Antibody B5103- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B5103_MFI_VALUE_CODE = "Anti-B5103-MFI";

	/** <div class="en">Code for HLA-Antibody B51(5)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B515_MFI_VALUE_CODE = "Anti-B51-MFI";

	/** <div class="en">Code for HLA-Antibody B52(5)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B525_MFI_VALUE_CODE = "Anti-B52-MFI";

	/** <div class="en">Code for HLA-Antibody B53- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B53_MFI_VALUE_CODE = "Anti-B53-MFI";

	/** <div class="en">Code for HLA-Antibody B54(22)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B5422_MFI_VALUE_CODE = "Anti-B54-MFI";

	/** <div class="en">Code for HLA-Antibody B55(22)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B5522_MFI_VALUE_CODE = "Anti-B55-MFI";

	/** <div class="en">Code for HLA-Antibody B56(22)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B5622_MFI_VALUE_CODE = "Anti-B56-MFI";

	/** <div class="en">Code for HLA-Antibody B57(17)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B5717_MFI_VALUE_CODE = "Anti-B57-MFI";

	/** <div class="en">Code for HLA-Antibody B58(17)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B5817_MFI_VALUE_CODE = "Anti-B58-MFI";

	/** <div class="en">Code for HLA-Antibody B59- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B59_MFI_VALUE_CODE = "Anti-B59-MFI";

	/** <div class="en">Code for HLA-Antibody B60(40)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B6040_MFI_VALUE_CODE = "Anti-B60-MFI";

	/** <div class="en">Code for HLA-Antibody B61(40)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B6140_MFI_VALUE_CODE = "Anti-B61-MFI";

	/** <div class="en">Code for HLA-Antibody B62(15)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B6215_MFI_VALUE_CODE = "Anti-B62-MFI";

	/** <div class="en">Code for HLA-Antibody B63(15)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B6315_MFI_VALUE_CODE = "Anti-B63-MFI";

	/** <div class="en">Code for HLA-Antibody B64(14)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B6414_MFI_VALUE_CODE = "Anti-B64-MFI";

	/** <div class="en">Code for HLA-Antibody B65(14)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B6514_MFI_VALUE_CODE = "Anti-B65-MFI";

	/** <div class="en">Code for HLA-Antibody B67- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B67_MFI_VALUE_CODE = "Anti-B67-MFI";

	/** <div class="en">Code for HLA-Antibody B7- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B7_MFI_VALUE_CODE = "Anti-B7-MFI";

	/** <div class="en">Code for HLA-Antibody B703- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B703_MFI_VALUE_CODE = "Anti-B703-MFI";

	/** <div class="en">Code for HLA-Antibody B71(70)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B7170_MFI_VALUE_CODE = "Anti-B71-MFI";

	/** <div class="en">Code for HLA-Antibody B72(70)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B7270_MFI_VALUE_CODE = "Anti-B72-MFI";

	/** <div class="en">Code for HLA-Antibody B73- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B73_MFI_VALUE_CODE = "Anti-B73-MFI";

	/** <div class="en">Code for HLA-Antibody B75(15)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B7515_MFI_VALUE_CODE = "Anti-B75-MFI";

	/** <div class="en">Code for HLA-Antibody B76(15)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B7615_MFI_VALUE_CODE = "Anti-B76-MFI";

	/** <div class="en">Code for HLA-Antibody B77(15)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B7715_MFI_VALUE_CODE = "Anti-B77-MFI";

	/** <div class="en">Code for HLA-Antibody B78- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B78_MFI_VALUE_CODE = "Anti-B78-MFI";

	/** <div class="en">Code for HLA-Antibody B8- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B8_MFI_VALUE_CODE = "Anti-B8-MFI";

	/** <div class="en">Code for HLA-Antibody B81- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B81_MFI_VALUE_CODE = "Anti-B81-MFI";

	/** <div class="en">Code for HLA-Antibody B82- MFI Value</div>. */
	public static final String HLA_ANTIBODY_B82_MFI_VALUE_CODE = "Anti-B82-MFI";

	/** <div class="en">Code for HLA-Antibody DQ2- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DQ2_MFI_VALUE_CODE = "Anti-DQ2-MFI";

	/** <div class="en">Code for HLA-Antibody DQ4- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DQ4_MFI_VALUE_CODE = "Anti-DQ4-MFI";

	/** <div class="en">Code for HLA-Antibody DQ5(1)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DQ51_MFI_VALUE_CODE = "Anti-DQ5-MFI";

	/** <div class="en">Code for HLA-Antibody DQ6(1)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DQ61_MFI_VALUE_CODE = "Anti-DQ6-MFI";

	/** <div class="en">Code for HLA-Antibody DQ7(3)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DQ73_MFI_VALUE_CODE = "Anti-DQ7-MFI";

	/** <div class="en">Code for HLA-Antibody DQ8(3)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DQ83_MFI_VALUE_CODE = "Anti-DQ8-MFI";

	/** <div class="en">Code for HLA-Antibody DQ9(3)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DQ93_MFI_VALUE_CODE = "Anti-DQ9-MFI";

	/** <div class="en">Code for HLA-Antibody DR1- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR1_MFI_VALUE_CODE = "Anti-DR1-MFI";

	/** <div class="en">Code for HLA-Antibody DR10- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR10_MFI_VALUE_CODE = "Anti-DR10-MFI";

	/** <div class="en">Code for HLA-Antibody DR103- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR103_MFI_VALUE_CODE = "Anti-DR103-MFI";

	/** <div class="en">Code for HLA-Antibody DR11(5)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR115_MFI_VALUE_CODE = "Anti-DR11-MFI";

	/** <div class="en">Code for HLA-Antibody DR12(5)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR125_MFI_VALUE_CODE = "Anti-DR12-MFI";

	/** <div class="en">Code for HLA-Antibody DR13(6)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR136_MFI_VALUE_CODE = "Anti-DR13-MFI";

	/** <div class="en">Code for HLA-Antibody DR1403- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR1403_MFI_VALUE_CODE = "Anti-DR1403-MFI";

	/** <div class="en">Code for HLA-Antibody DR1404- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR1404_MFI_VALUE_CODE = "Anti-DR1404-MFI";

	/** <div class="en">Code for HLA-Antibody DR14(6)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR146_MFI_VALUE_CODE = "Anti-DR14-MFI";

	/** <div class="en">Code for HLA-Antibody DR15(2)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR152_MFI_VALUE_CODE = "Anti-DR15-MFI";

	/** <div class="en">Code for HLA-Antibody DR16(2)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR162_MFI_VALUE_CODE = "Anti-DR16-MFI";

	/** <div class="en">Code for HLA-Antibody DR17(3)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR173_MFI_VALUE_CODE = "Anti-DR17-MFI";

	/** <div class="en">Code for HLA-Antibody DR18(3)- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR183_MFI_VALUE_CODE = "Anti-DR18-MFI";

	/** <div class="en">Code for HLA-Antibody DR4- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR4_MFI_VALUE_CODE = "Anti-DR4-MFI";

	/** <div class="en">Code for HLA-Antibody DR7- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR7_MFI_VALUE_CODE = "Anti-DR7-MFI";

	/** <div class="en">Code for HLA-Antibody DR8- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR8_MFI_VALUE_CODE = "Anti-DR8-MFI";

	/** <div class="en">Code for HLA-Antibody DR9- MFI Value</div>. */
	public static final String HLA_ANTIBODY_DR9_MFI_VALUE_CODE = "Anti-DR9-MFI";

	/** <div class="en">Code for HTLV 1 Ab [Presence] in Serum</div>. */
	public static final String HTLV_1_AB_PRESENCE_IN_SERUM_CODE = "22359-4";

	/** <div class="en">Code for HTLV 2 Ab [Presence] in Serum</div>. */
	public static final String HTLV_2_AB_PRESENCE_IN_SERUM_CODE = "26656-9";

	/** <div class="en">Code for INR in Blood by Coagulation assay</div>. */
	public static final String INR_IN_BLOOD_BY_COAGULATION_ASSAY_CODE = "34714-6";

	/**
	 * <div class="en">Code for Lactate dehydrogenase [Enzymatic
	 * activity/volume] in Serum or Plasma by Lactate to pyruvate reaction</div>
	 * .
	 */
	public static final String LACTATE_DEHYDROGENASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_BY_LACTATE_TO_PYRUVATE_REACTION_CODE = "14804-9";

	/** <div class="en">Code for Leukocytes other [#/volume] in Blood</div>. */
	public static final String LEUKOCYTES_OTHER_VOLUME_IN_BLOOD_CODE = "30406-3";

	/** <div class="en">Code for Leukocytes [#/volume] in Urine</div>. */
	public static final String LEUKOCYTES_VOLUME_IN_URINE_CODE = "30405-5";

	/**
	 * <div class="en">Code for Lipase [Enzymatic activity/volume] in Serum or
	 * Plasma</div>.
	 */
	public static final String LIPASE_ENZYMATIC_ACTIVITYVOLUME_IN_SERUM_OR_PLASMA_CODE = "3040-3";

	/**
	 * <div class="en">Code for Magnesium [Moles/volume] in Serum or
	 * Plasma</div>.
	 */
	public static final String MAGNESIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2601-3";

	/**
	 * <div class="en">Code for Microscopic observation [Identifier] in Urine
	 * sediment by Light microscopy</div>.
	 */
	public static final String MICROSCOPIC_OBSERVATION_IDENTIFIER_IN_URINE_SEDIMENT_BY_LIGHT_MICROSCOPY_CODE = "12235-8";

	/** <div class="en">Code for Osmolality of Serum or Plasma</div>. */
	public static final String OSMOLALITY_OF_SERUM_OR_PLASMA_CODE = "2692-2";

	/** <div class="en">Code for Osmolality of Urine</div>. */
	public static final String OSMOLALITY_OF_URINE_CODE = "2695-5";

	/** <div class="en">Code for Oxygen [Partial pressure] in Blood</div>. */
	public static final String OXYGEN_PARTIAL_PRESSURE_IN_BLOOD_CODE = "11556-8";

	/**
	 * <div class="en">Code for Oxygen saturation in Mixed venous blood</div>.
	 */
	public static final String OXYGEN_SATURATION_IN_MIXED_VENOUS_BLOOD_CODE = "19224-5";

	/** <div class="en">Code for pH of Blood</div>. */
	public static final String PH_OF_BLOOD_CODE = "11558-4";

	/** <div class="en">Code for pH of Urine by Test strip</div>. */
	public static final String PH_OF_URINE_BY_TEST_STRIP_CODE = "5803-2";

	/**
	 * <div class="en">Code for Phosphate [Moles/volume] in Serum or
	 * Plasma</div>.
	 */
	public static final String PHOSPHATE_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "14879-1";

	/** <div class="en">Code for Platelets [#/volume] in Blood</div>. */
	public static final String PLATELETS_VOLUME_IN_BLOOD_CODE = "26515-7";

	/**
	 * <div class="en">Code for Potassium [Moles/volume] in Serum or
	 * Plasma</div>.
	 */
	public static final String POTASSIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2823-3";

	/** <div class="en">Code for Potassium [Moles/volume] in Urine</div>. */
	public static final String POTASSIUM_MOLESVOLUME_IN_URINE_CODE = "2828-2";

	/**
	 * <div class="en">Code for Protein [Mass/volume] in Serum or Plasma</div>.
	 */
	public static final String PROTEIN_MASSVOLUME_IN_SERUM_OR_PLASMA_CODE = "2885-2";

	/**
	 * <div class="en">Code for Protein [Presence] in Urine by Test strip</div>.
	 */
	public static final String PROTEIN_PRESENCE_IN_URINE_BY_TEST_STRIP_CODE = "20454-5";

	/**
	 * <div class="en">Code for Prothrombin time (PT) PIVKA insensitive
	 * actual/normal in Platelet poor plasma by Coagulation assay</div>.
	 */
	public static final String PROTHROMBIN_TIME_PT_PIVKA_INSENSITIVE_ACTUALNORMAL_IN_PLATELET_POOR_PLASMA_BY_COAGULATION_ASSAY_CODE = "52753-1";

	/** <div class="en">Code for Reagin Ab [Presence] in Serum by VDRL</div>. */
	public static final String REAGIN_AB_PRESENCE_IN_SERUM_BY_VDRL_CODE = "5292-8";

	/**
	 * <div class="en">Code for Renal tubular casts [#/area] in Urine by Light
	 * microscopy</div>.
	 */
	public static final String RENAL_TUBULAR_CASTS_AREA_IN_URINE_BY_LIGHT_MICROSCOPY_CODE = "30079-8";

	/**
	 * <div class="en">Code for Sodium [Moles/volume] in Serum or Plasma</div>.
	 */
	public static final String SODIUM_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "2951-2";

	/** <div class="en">Code for Sodium [Moles/volume] in Urine</div>. */
	public static final String SODIUM_MOLESVOLUME_IN_URINE_CODE = "2955-3";

	/**
	 * <div class="en">Code for Toxoplasma gondii IgG Ab [Presence] in
	 * Serum</div> .
	 */
	public static final String TOXOPLASMA_GONDII_IGG_AB_PRESENCE_IN_SERUM_CODE = "22580-5";

	/**
	 * <div class="en">Code for Toxoplasma gondii IgM Ab [Presence] in
	 * Serum</div> .
	 */
	public static final String TOXOPLASMA_GONDII_IGM_AB_PRESENCE_IN_SERUM_CODE = "25542-2";

	/**
	 * <div class="en">Code for Treponema pallidum Ab [Presence] in Serum by
	 * Hemagglutination</div>.
	 */
	public static final String TREPONEMA_PALLIDUM_AB_PRESENCE_IN_SERUM_BY_HEMAGGLUTINATION_CODE = "8041-6";

	/**
	 * <div class="en">Code for Troponin T.cardiac [Mass/volume] in Venous
	 * blood</div>
	 */
	public static final String TROPONIN_T_CARDIAC_MASSVOLUME_IN_VENOUS_BLOOD_CODE = "6597-9";

	/** <div class="en">Code for Unspecified A- HLA-Antigene</div>. */
	public static final String UNSPECIFIED_A_HLA_ANTIGENE_CODE = "A-";

	/** <div class="en">Code for Unspecified B- HLA-Antigene</div>. */
	public static final String UNSPECIFIED_B_HLA_ANTIGENE_CODE = "B-";

	/** <div class="en">Code for Unspecified DQ- HLA-Antigene</div>. */
	public static final String UNSPECIFIED_DQ_HLA_ANTIGENE_CODE = "DQ-";

	/** <div class="en">Code for Unspecified DR- HLA-Antigene</div>. */
	public static final String UNSPECIFIED_DR_HLA_ANTIGENE_CODE = "DR-";

	/**
	 * <div class="en">Code for Urea [Moles/volume] in Serum or Plasma</div>.
	 */
	public static final String UREA_MOLESVOLUME_IN_SERUM_OR_PLASMA_CODE = "22664-7";

	/** <div class="en">Code for Urobilinogen [Moles/volume] in Urine</div>. */
	public static final String UROBILINOGEN_MOLESVOLUME_IN_URINE_CODE = "34927-4";

	/** <div class="en">Code for Urobilinogen [Presence] in Urine</div>. */
	public static final String UROBILINOGEN_PRESENCE_IN_URINE_CODE = "13658-0";

	/**
	 * <div class="en">Code for Varicella zoster virus IgG Ab [Presence] in
	 * Serum</div>.
	 */
	public static final String VARICELLA_ZOSTER_VIRUS_IGG_AB_PRESENCE_IN_SERUM_CODE = "19162-7";

	/**
	 * <div class="en">Code for Varicella zoster virus IgM Ab [Presence] in
	 * Serum</div>.
	 */
	public static final String VARICELLA_ZOSTER_VIRUS_IGM_AB_PRESENCE_IN_SERUM_CODE = "21597-0";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 *
	 * @param code
	 *            the code (as present in this class with enumName_CODE)
	 * @return the according enum object
	 */
	public static LabObsList getEnum(String code) {
		for (final LabObsList x : values()) {
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
	 *            name of the enum (as present in this class)
	 * @return true, if the enum is in this value set
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
	 *            the code</div>
	 * @return true, if an enum with the given code is part of this value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final LabObsList x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>.
	 */
	private String code;

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>.
	 */
	private String codeSystem;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>.
	 */
	private String displayName;

	/**
	 * <div class="en">Section code for this Element</div>
	 * <div class="de">Section Code für dieses Element</div>.
	 */
	private String sectionCode;

	/**
	 * <div class="en">Start date for the period in which this element can be
	 * used</div> <div class="de">Startdatum der Periode, innerhalb derer dieses
	 * Element valide ist</div>.
	 */
	private Date validFrom;

	/**
	 * <div class="en">End date for the period in which this element can be
	 * used</div> <div class="de">Enddatum der Periode, innerhalb derer dieses
	 * Element valide ist</div>.
	 */
	private Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with given code,
	 * codeSystem, displayName, specialitySectionCode, privacyFilter, validFrom
	 * and validTo parameters</div> <div class="de">Instantiiert dieses Enum
	 * Object mittels code, codeSystem, displayName, specialitySectionCode,
	 * privacyFilter, validFrom und validTo Parameter</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="en">the code</div>
	 * @param codeSystem
	 *            <br>
	 *            <div class="en">the codesystem</div>
	 * @param displayName
	 *            <br>
	 *            <div class="en">the display name</div>
	 * @param sectionCode
	 *            <br>
	 *            <div class="en">the patient privacy filter</div>
	 * @param validFrom
	 *            <br>
	 *            <div class="en">the valid from</div>
	 * @param validTo
	 *            <br>
	 *            <div class="en">the valid to</div>
	 */
	private LabObsList(String code, String codeSystem, String displayName, String sectionCode,
			String validFrom, String validTo) {
		this.code = code;
		this.codeSystem = codeSystem;
		this.displayName = displayName;
		this.sectionCode = sectionCode;
		if ((validFrom != null) && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if ((validTo != null) && !"".equals(validTo)) {
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
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(getCodeSystemOid());
		cd.setCode(code);
		cd.setDisplayName(displayName);
		cd.setCodeSystemName(CODE_SYSTEM_NAME);
		return cd;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>.
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(getCodeSystemOid(), code, CODE_SYSTEM_NAME, displayName);
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
		return this.codeSystem;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
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
	 * <div class="en">Gets the section code</div> <div class="de">Liefert
	 * section code</div>.
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
	 *            the date
	 * @return true, if it is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if ((validFrom != null) && validFrom.after(date)) {
			return false;
		}
		if ((validTo != null) && validTo.before(date)) {
			return false;
		}
		return true;
	}
}