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
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ihe.pharm.enums;

import org.ehealth_connector.common.Code;

/**
 * The Enum OrderableDrugFrom MaterialForm (OID 2.16.840.1.113883.5.85)
 */
public enum OrderableDrugFrom {

	/** <div class="en"> Aerosol</div> */
	AER("AER", "Aerosol"),

	/** <div class="en"> applicatorful</div> */
	APPFUL("APPFUL", "applicatorful"),

	/** <div class="en"> Breath Activated Inhaler</div> */
	BAINHL("BAINHL", "Breath Activated Inhaler"),

	/** <div class="en"> Breath Activated Powder Inhaler</div> */
	BAINHLPWD("BAINHLPWD", "Breath Activated Powder Inhaler"),

	/** <div class="en"> Bar</div> */
	BAR("BAR", "Bar"),

	/** <div class="en"> Bar Soap</div> */
	BARSOAP("BARSOAP", "Bar Soap"),

	/** <div class="en"> Beads</div> */
	BEAD("BEAD", "Beads"),

	/** <div class="en"> Buccal Tablet</div> */
	BUCTAB("BUCTAB", "Buccal Tablet"),

	/** <div class="en"> Cake</div> */
	CAKE("CAKE", "Cake"),

	/** <div class="en"> Capsule</div> */
	CAP("CAP", "Capsule"),

	/** <div class="en"> Caplet</div> */
	CAPLET("CAPLET", "Caplet"),

	/** <div class="en"> Cement</div> */
	CEMENT("CEMENT", "Cement"),

	/** <div class="en"> Chewable Bar</div> */
	CHEWBAR("CHEWBAR", "Chewable Bar"),

	/** <div class="en"> Chewable Tablet</div> */
	CHEWTAB("CHEWTAB", "Chewable Tablet"),

	/** <div class="en"> Coated Particles Tablet</div> */
	CPTAB("CPTAB", "Coated Particles Tablet"),

	/** <div class="en"> Cream</div> */
	CRM("CRM", "Cream"),

	/** <div class="en"> Crystals</div> */
	CRYS("CRYS", "Crystals"),

	/** <div class="en"> Dermal Spray</div> */
	DERMSPRY("DERMSPRY", "Dermal Spray"),

	/** <div class="en"> Disintegrating Tablet</div> */
	DISINTAB("DISINTAB", "Disintegrating Tablet"),

	/** <div class="en"> Disk</div> */
	DISK("DISK", "Disk"),

	/** <div class="en"> Douche</div> */
	DOUCHE("DOUCHE", "Douche"),

	/** <div class="en"> Drops</div> */
	DROP("DROP", "Drops"),

	/** <div class="en"> Delayed Release Tablet</div> */
	DRTAB("DRTAB", "Delayed Release Tablet"),

	/** <div class="en"> Enteric Coated Tablet</div> */
	ECTAB("ECTAB", "Enteric Coated Tablet"),

	/** <div class="en"> Elixir</div> */
	ELIXIR("ELIXIR", "Elixir"),

	/** <div class="en"> Enema</div> */
	ENEMA("ENEMA", "Enema"),

	/** <div class="en"> Enteric Coated Capsule</div> */
	ENTCAP("ENTCAP", "Enteric Coated Capsule"),

	/** <div class="en"> Extended Release Capsule</div> */
	ERCAP("ERCAP", "Extended Release Capsule"),

	/** <div class="en"> 12 Hour Extended Release Capsule</div> */
	ERCAP12("ERCAP12", "12 Hour Extended Release Capsule"),

	/** <div class="en"> 24 Hour Extended Release Capsule</div> */
	ERCAP24("ERCAP24", "24 Hour Extended Release Capsule"),

	/** <div class="en"> Extended Release Enteric Coated Capsule</div> */
	ERECCAP("ERECCAP", "Extended Release Enteric Coated Capsule"),

	/** <div class="en"> Extended Release Enteric Coated Tablet</div> */
	ERECTAB("ERECTAB", "Extended Release Enteric Coated Tablet"),

	/** <div class="en"> Extended Release Enteric Coated Capsule</div> */
	ERENTCAP("ERENTCAP", "Extended Release Enteric Coated Capsule"),

	/** <div class="en"> Extended-Release Suspension</div> */
	ERSUSP("ERSUSP", "Extended-Release Suspension"),

	/** <div class="en"> 12 Hour Extended-Release Suspension</div> */
	ERSUSP12("ERSUSP12", "12 Hour Extended-Release Suspension"),

	/** <div class="en"> 24 Hour Extended Release Suspension</div> */
	ERSUSP24("ERSUSP24", "24 Hour Extended Release Suspension"),

	/** <div class="en"> Extended Release Tablet</div> */
	ERTAB("ERTAB", "Extended Release Tablet"),

	/** <div class="en"> 12 Hour Extended Release Tablet</div> */
	ERTAB12("ERTAB12", "12 Hour Extended Release Tablet"),

	/** <div class="en"> 24 Hour Extended Release Tablet</div> */
	ERTAB24("ERTAB24", "24 Hour Extended Release Tablet"),

	/** <div class="en"> Flakes</div> */
	FLAKE("FLAKE", "Flakes"),

	/** <div class="en"> Foam</div> */
	FOAM("FOAM", "Foam"),

	/** <div class="en"> Foam with Applicator</div> */
	FOAMAPL("FOAMAPL", "Foam with Applicator"),

	/** <div class="en"> Gas for Inhalation</div> */
	GASINHL("GASINHL", "Gas for Inhalation"),

	/** <div class="en"> Gel</div> */
	GEL("GEL", "Gel"),

	/** <div class="en"> Gel with Applicator</div> */
	GELAPL("GELAPL", "Gel with Applicator"),

	/** <div class="en"> Granules</div> */
	GRAN("GRAN", "Granules"),

	/** <div class="en"> ChewingGum</div> */
	GUM("GUM", "ChewingGum"),

	/** <div class="en"> Inhalant</div> */
	INHL("INHL", "Inhalant"),

	/** <div class="en"> Inhalant Powder</div> */
	INHLPWD("INHLPWD", "Inhalant Powder"),

	/** <div class="en"> Inhalant Solution</div> */
	INHLSOL("INHLSOL", "Inhalant Solution"),

	/** <div class="en"> Intraperitoneal Solution</div> */
	IPSOL("IPSOL", "Intraperitoneal Solution"),

	/** <div class="en"> Irrigation Solution</div> */
	IRSOL("IRSOL", "Irrigation Solution"),

	/** <div class="en"> Intrathecal Suspension</div> */
	ITSUSP("ITSUSP", "Intrathecal Suspension"),

	/** <div class="en"> Intravenous Solution</div> */
	IVSOL("IVSOL", "Intravenous Solution"),

	/** <div class="en"> Liniment</div> */
	LIN("LIN", "Liniment"),

	/** <div class="en"> Liquid Cleanser</div> */
	LIQCLN("LIQCLN", "Liquid Cleanser"),

	/** <div class="en"> Medicated Liquid Soap</div> */
	LIQSOAP("LIQSOAP", "Medicated Liquid Soap"),

	/** <div class="en"> Lotion</div> */
	LTN("LTN", "Lotion"),

	/** <div class="en"> Metered Dose Inhaler</div> */
	MDINHL("MDINHL", "Metered Dose Inhaler"),

	/** <div class="en"> Metered Dose Powder Inhaler</div> */
	MDINHLPWD("MDINHLPWD", "Metered Dose Powder Inhaler"),

	/** <div class="en"> Medicated Bar Soap</div> */
	MEDBAR("MEDBAR", "Medicated Bar Soap"),

	/** <div class="en"> Medicated Pad</div> */
	MEDPAD("MEDPAD", "Medicated Pad"),

	/** <div class="en"> Medicated swab</div> */
	MEDSWAB("MEDSWAB", "Medicated swab"),

	/** <div class="en"> Mucous Membrane Topical Solution</div> */
	MUCTOPSOL("MUCTOPSOL", "Mucous Membrane Topical Solution"),

	/** <div class="en"> Nasal Cream</div> */
	NASCRM("NASCRM", "Nasal Cream"),

	/** <div class="en"> Nasal Gel</div> */
	NASGEL("NASGEL", "Nasal Gel"),

	/** <div class="en"> Nasal Inhalant</div> */
	NASINHL("NASINHL", "Nasal Inhalant"),

	/** <div class="en"> Nasal Ointment</div> */
	NASOINT("NASOINT", "Nasal Ointment"),

	/** <div class="en"> Nasal Spray</div> */
	NASSPRY("NASSPRY", "Nasal Spray"),

	/** <div class="en"> Nasal Drops</div> */
	NDROP("NDROP", "Nasal Drops"),

	/** <div class="en"> Oil</div> */
	OIL("OIL", "Oil"),

	/** <div class="en"> Ointment</div> */
	OINT("OINT", "Ointment"),

	/** <div class="en"> Ointment with Applicator</div> */
	OINTAPL("OINTAPL", "Ointment with Applicator"),

	/** <div class="en"> Ophthalmic Cream</div> */
	OPCRM("OPCRM", "Ophthalmic Cream"),

	/** <div class="en"> Ophthalmic Drops</div> */
	OPDROP("OPDROP", "Ophthalmic Drops"),

	/** <div class="en"> Ophthalmic Gel</div> */
	OPGEL("OPGEL", "Ophthalmic Gel"),

	/** <div class="en"> Ophthalmic Irrigation Solution</div> */
	OPIRSOL("OPIRSOL", "Ophthalmic Irrigation Solution"),

	/** <div class="en"> Ophthalmic Ointment</div> */
	OPOINT("OPOINT", "Ophthalmic Ointment"),

	/** <div class="en"> Ophthalmic Suspension</div> */
	OPSUSP("OPSUSP", "Ophthalmic Suspension"),

	/** <div class="en"> Oral Solution</div> */
	ORALSOL("ORALSOL", "Oral Solution"),

	/** <div class="en"> Oral Capsule</div> */
	ORCAP("ORCAP", "Oral Capsule"),

	/** <div class="en"> Oral Cream</div> */
	ORCRM("ORCRM", "Oral Cream"),

	/** <div class="en"> Oral Drops</div> */
	ORDROP("ORDROP", "Oral Drops"),

	/** <div class="en"> Oral Inhalant</div> */
	ORINHL("ORINHL", "Oral Inhalant"),

	/** <div class="en"> Oral Suspension</div> */
	ORSUSP("ORSUSP", "Oral Suspension"),

	/** <div class="en"> Oral Tablet</div> */
	ORTAB("ORTAB", "Oral Tablet"),

	/** <div class="en"> Lozenge/Oral Troche</div> */
	ORTROCHE("ORTROCHE", "Lozenge/Oral Troche"),

	/** <div class="en"> Otic Cream</div> */
	OTCRM("OTCRM", "Otic Cream"),

	/** <div class="en"> Otic Drops</div> */
	OTDROP("OTDROP", "Otic Drops"),

	/** <div class="en"> Otic Gel</div> */
	OTGEL("OTGEL", "Otic Gel"),

	/** <div class="en"> Otic Ointment</div> */
	OTOINT("OTOINT", "Otic Ointment"),

	/** <div class="en"> Otic Suspension</div> */
	OTSUSP("OTSUSP", "Otic Suspension"),

	/** <div class="en"> Pad</div> */
	PAD("PAD", "Pad"),

	/** <div class="en"> Paste</div> */
	PASTE("PASTE", "Paste"),

	/** <div class="en"> Patch</div> */
	PATCH("PATCH", "Patch"),

	/** <div class="en"> Pellet</div> */
	PELLET("PELLET", "Pellet"),

	/** <div class="en"> Pill</div> */
	PILL("PILL", "Pill"),

	/** <div class="en"> Powder</div> */
	POWD("POWD", "Powder"),

	/** <div class="en"> Pudding</div> */
	PUD("PUD", "Pudding"),

	/** <div class="en"> puff</div> */
	PUFF("PUFF", "puff"),

	/** <div class="en"> Powder Spray</div> */
	PWDSPRY("PWDSPRY", "Powder Spray"),

	/** <div class="en"> Rectal Cream</div> */
	RECCRM("RECCRM", "Rectal Cream"),

	/** <div class="en"> Rectal foam</div> */
	RECFORM("RECFORM", "Rectal foam"),

	/** <div class="en"> Rectal Ointment</div> */
	RECOINT("RECOINT", "Rectal Ointment"),

	/** <div class="en"> Rectal Powder</div> */
	RECPWD("RECPWD", "Rectal Powder"),

	/** <div class="en"> Rectal Solution</div> */
	RECSOL("RECSOL", "Rectal Solution"),

	/** <div class="en"> Rectal Spray</div> */
	RECSPRY("RECSPRY", "Rectal Spray"),

	/** <div class="en"> Rectal Suppository</div> */
	RECSUPP("RECSUPP", "Rectal Suppository"),

	/** <div class="en"> Rectal Suspension</div> */
	RECSUSP("RECSUSP", "Rectal Suspension"),

	/** <div class="en"> Mouthwash/Rinse</div> */
	RINSE("RINSE", "Mouthwash/Rinse"),

	/** <div class="en"> scoops</div> */
	SCOOP("SCOOP", "scoops"),

	/** <div class="en"> Shampoo</div> */
	SHMP("SHMP", "Shampoo"),

	/** <div class="en"> Sublingual Tablet</div> */
	SLTAB("SLTAB", "Sublingual Tablet"),

	/** <div class="en"> Solution</div> */
	SOL("SOL", "Solution"),

	/** <div class="en"> sprays</div> */
	SPRY("SPRY", "sprays"),

	/** <div class="en"> Spray with Adaptor</div> */
	SPRYADAPT("SPRYADAPT", "Spray with Adaptor"),

	/** <div class="en"> Sustained Release Buccal Tablet</div> */
	SRBUCTAB("SRBUCTAB", "Sustained Release Buccal Tablet"),

	/** <div class="en"> Suppository</div> */
	SUPP("SUPP", "Suppository"),

	/** <div class="en"> Suspension</div> */
	SUSP("SUSP", "Suspension"),

	/** <div class="en"> Swab</div> */
	SWAB("SWAB", "Swab"),

	/** <div class="en"> Syrup</div> */
	SYRUP("SYRUP", "Syrup"),

	/** <div class="en"> Tablet</div> */
	TAB("TAB", "Tablet"),

	/** <div class="en"> Tincture</div> */
	TINC("TINC", "Tincture"),

	/** <div class="en"> Topical Cream</div> */
	TOPCRM("TOPCRM", "Topical Cream"),

	/** <div class="en"> Topical Gel</div> */
	TOPGEL("TOPGEL", "Topical Gel"),

	/** <div class="en"> Topical Lotion</div> */
	TOPLTN("TOPLTN", "Topical Lotion"),

	/** <div class="en"> Topical Oil</div> */
	TOPOIL("TOPOIL", "Topical Oil"),

	/** <div class="en"> Topical Ointment</div> */
	TOPOINT("TOPOINT", "Topical Ointment"),

	/** <div class="en"> Topical Powder</div> */
	TOPPWD("TOPPWD", "Topical Powder"),

	/** <div class="en"> Topical Solution</div> */
	TOPSOL("TOPSOL", "Topical Solution"),

	/** <div class="en"> Toothpaste</div> */
	TPASTE("TPASTE", "Toothpaste"),

	/** <div class="en"> Transdermal Patch</div> */
	TPATCH("TPATCH", "Transdermal Patch"),

	/** <div class="en"> 16 Hour Transdermal Patch</div> */
	TPATH16("TPATH16", "16 Hour Transdermal Patch"),

	/** <div class="en"> 24 Hour Transdermal Patch</div> */
	TPATH24("TPATH24", "24 Hour Transdermal Patch"),

	/** <div class="en"> Biweekly Transdermal Patch</div> */
	TPATH2WK("TPATH2WK", "Biweekly Transdermal Patch"),

	/** <div class="en"> 72 Hour Transdermal Patch</div> */
	TPATH72("TPATH72", "72 Hour Transdermal Patch"),

	/** <div class="en"> Weekly Transdermal Patch</div> */
	TPATHWK("TPATHWK", "Weekly Transdermal Patch"),

	/** <div class="en"> Urethral Gel</div> */
	URETHGEL("URETHGEL", "Urethral Gel"),

	/** <div class="en"> Urethral suppository</div> */
	URETHSUPP("URETHSUPP", "Urethral suppository"),

	/** <div class="en"> Vaginal Cream</div> */
	VAGCRM("VAGCRM", "Vaginal Cream"),

	/** <div class="en"> Vaginal Cream with Applicator</div> */
	VAGCRMAPL("VAGCRMAPL", "Vaginal Cream with Applicator"),

	/** <div class="en"> Vaginal foam</div> */
	VAGFOAM("VAGFOAM", "Vaginal foam"),

	/** <div class="en"> Vaginal foam with applicator</div> */
	VAGFOAMAPL("VAGFOAMAPL", "Vaginal foam with applicator"),

	/** <div class="en"> Vaginal Gel</div> */
	VAGGEL("VAGGEL", "Vaginal Gel"),

	/** <div class="en"> Vaginal Ointment</div> */
	VAGOINT("VAGOINT", "Vaginal Ointment"),

	/** <div class="en"> Vaginal Ointment with Applicator</div> */
	VAGOINTAPL("VAGOINTAPL", "Vaginal Ointment with Applicator"),

	/** <div class="en"> Vaginal Powder</div> */
	VAGPWD("VAGPWD", "Vaginal Powder"),

	/** <div class="en"> Vaginal Spray</div> */
	VAGSPRY("VAGSPRY", "Vaginal Spray"),

	/** <div class="en"> Vaginal Suppository</div> */
	VAGSUPP("VAGSUPP", "Vaginal Suppository"),

	/** <div class="en"> Vaginal Tablet</div> */
	VAGTAB("VAGTAB", "Vaginal Tablet"),

	/** <div class="en"> Vaginal Gel with Applicator</div> */
	VGELAPL("VGELAPL", "Vaginal Gel with Applicator"),

	/** <div class="en"> Wafer</div> */
	WAFER("WAFER", "Wafer");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "OrderableDrugFrom";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "OID 2.16.840.1.113883.5.85";

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *          the code
	 * @return the enum
	 */
	public static OrderableDrugFrom getEnum(String code) {
		for (final OrderableDrugFrom x : values()) {
			if (x.code.equals(code)) {
				return x;
			}
		}
		return null;
	}

	/** The code. */
	private String code;

	/** The display name. */
	private String displayNameEn;

	/**
	 * Instantiates a new OrderableDrugFrom.
	 *
	 * @param code
	 *          the code
	 * @param displayNameEn
	 *          the display name en
	 * @param displayNameFr
	 *          the display name fr
	 */
	private OrderableDrugFrom(String code, String displayNameEn) {
		this.code = code;
		this.displayNameEn = displayNameEn;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayNameEn);
		return ehcCode;
	}

}
