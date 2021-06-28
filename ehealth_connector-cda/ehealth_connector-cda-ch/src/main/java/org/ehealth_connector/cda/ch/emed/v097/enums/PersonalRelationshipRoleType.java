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
package org.ehealth_connector.cda.ch.emed.v097.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of PersonalRelationshipRoleType values
 *
 * <div class="en"><p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>Types of personal relationships between two living subjects.</p><p> <i>Example:</i> Parent, sibling, unrelated friend, neighbor</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 *
 * Identifier: 2.16.840.1.113883.1.11.19563
 * Effective date: 2014-03-26 00:00
 * Version: DEFN=UV=VO=1360-20160323
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-03-05")
public enum PersonalRelationshipRoleType implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">adopted child</div>
	 * <!-- @formatter:on -->
	 */
	ADOPTED_CHILD_L3("CHLDADOPT", "2.16.840.1.113883.5.111", "adopted child", "adopted child",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">adopted daughter</div>
	 * <!-- @formatter:on -->
	 */
	ADOPTED_DAUGHTER_L4("DAUADOPT", "2.16.840.1.113883.5.111", "adopted daughter",
			"adopted daughter", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">adopted son</div>
	 * <!-- @formatter:on -->
	 */
	ADOPTED_SON_L4("SONADOPT", "2.16.840.1.113883.5.111", "adopted son", "adopted son",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">adoptive father</div>
	 * <!-- @formatter:on -->
	 */
	ADOPTIVE_FATHER_L4("ADOPTF", "2.16.840.1.113883.5.111", "adoptive father", "adoptive father",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">adoptive mother</div>
	 * <!-- @formatter:on -->
	 */
	ADOPTIVE_MOTHER_L4("ADOPTM", "2.16.840.1.113883.5.111", "adoptive mother", "adoptive mother",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">adoptive parent</div>
	 * <!-- @formatter:on -->
	 */
	ADOPTIVE_PARENT_L3("ADOPTP", "2.16.840.1.113883.5.111", "adoptive parent", "adoptive parent",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">aunt</div>
	 * <!-- @formatter:on -->
	 */
	AUNT_L3("AUNT", "2.16.840.1.113883.5.111", "aunt", "aunt", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">brother-in-law</div>
	 * <!-- @formatter:on -->
	 */
	BROTHER_IN_LAW_L5("BROINLAW", "2.16.840.1.113883.5.111", "brother-in-law", "brother-in-law",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">brother</div>
	 * <!-- @formatter:on -->
	 */
	BROTHER_L3("BRO", "2.16.840.1.113883.5.111", "brother", "brother", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">child-in-law</div>
	 * <!-- @formatter:on -->
	 */
	CHILD_IN_LAW_L4("CHLDINLAW", "2.16.840.1.113883.5.111", "child-in-law", "child-in-law",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">child</div>
	 * <!-- @formatter:on -->
	 */
	CHILD_L2("CHILD", "2.16.840.1.113883.5.111", "child", "child", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">cousin</div>
	 * <!-- @formatter:on -->
	 */
	COUSIN_L3("COUSN", "2.16.840.1.113883.5.111", "cousin", "cousin", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">daughter in-law</div>
	 * <!-- @formatter:on -->
	 */
	DAUGHTER_IN_LAW_L5("DAUINLAW", "2.16.840.1.113883.5.111", "daughter in-law", "daughter in-law",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">daughter</div>
	 * <!-- @formatter:on -->
	 */
	DAUGHTER_L3("DAUC", "2.16.840.1.113883.5.111", "daughter", "daughter", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">domestic partner</div>
	 * <!-- @formatter:on -->
	 */
	DOMESTIC_PARTNER_L3("DOMPART", "2.16.840.1.113883.5.111", "domestic partner",
			"domestic partner", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">extended family member</div>
	 * <!-- @formatter:on -->
	 */
	EXTENDED_FAMILY_MEMBER_L2("EXT", "2.16.840.1.113883.5.111", "extended family member",
			"extended family member", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">family member</div>
	 * <!-- @formatter:on -->
	 */
	FAMILY_MEMBER_L1("FAMMEMB", "2.16.840.1.113883.5.111", "family member", "family member",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">father-in-law</div>
	 * <!-- @formatter:on -->
	 */
	FATHER_IN_LAW_L5("FTHINLAW", "2.16.840.1.113883.5.111", "father-in-law", "father-in-law",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">father</div>
	 * <!-- @formatter:on -->
	 */
	FATHER_L3("FTH", "2.16.840.1.113883.5.111", "father", "father", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">former spouse</div>
	 * <!-- @formatter:on -->
	 */
	FORMER_SPOUSE_L3("FMRSPS", "2.16.840.1.113883.5.111", "former spouse", "former spouse",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">foster child</div>
	 * <!-- @formatter:on -->
	 */
	FOSTER_CHILD_L3("CHLDFOST", "2.16.840.1.113883.5.111", "foster child", "foster child",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">foster daughter</div>
	 * <!-- @formatter:on -->
	 */
	FOSTER_DAUGHTER_L4("DAUFOST", "2.16.840.1.113883.5.111", "foster daughter", "foster daughter",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">foster father</div>
	 * <!-- @formatter:on -->
	 */
	FOSTER_FATHER_L4("FTHFOST", "2.16.840.1.113883.5.111", "foster father", "foster father",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">foster mother</div>
	 * <!-- @formatter:on -->
	 */
	FOSTER_MOTHER_L4("MTHFOST", "2.16.840.1.113883.5.111", "foster mother", "foster mother",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">foster parent</div>
	 * <!-- @formatter:on -->
	 */
	FOSTER_PARENT_L3("PRNFOST", "2.16.840.1.113883.5.111", "foster parent", "foster parent",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">foster son</div>
	 * <!-- @formatter:on -->
	 */
	FOSTER_SON_L4("SONFOST", "2.16.840.1.113883.5.111", "foster son", "foster son", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">fraternal twin brother</div>
	 * <!-- @formatter:on -->
	 */
	FRATERNAL_TWIN_BROTHER_L6("FTWINBRO", "2.16.840.1.113883.5.111", "fraternal twin brother",
			"fraternal twin brother", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">fraternal twin</div>
	 * <!-- @formatter:on -->
	 */
	FRATERNAL_TWIN_L5("FTWIN", "2.16.840.1.113883.5.111", "fraternal twin", "fraternal twin",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">fraternal twin sister</div>
	 * <!-- @formatter:on -->
	 */
	FRATERNAL_TWIN_SISTER_L6("FTWINSIS", "2.16.840.1.113883.5.111", "fraternal twin sister",
			"fraternal twin sister", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">gestational mother</div>
	 * <!-- @formatter:on -->
	 */
	GESTATIONAL_MOTHER_L4("GESTM", "2.16.840.1.113883.5.111", "gestational mother",
			"gestational mother", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">grandchild</div>
	 * <!-- @formatter:on -->
	 */
	GRANDCHILD_L3("GRNDCHILD", "2.16.840.1.113883.5.111", "grandchild", "grandchild", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">granddaughter</div>
	 * <!-- @formatter:on -->
	 */
	GRANDDAUGHTER_L4("GRNDDAU", "2.16.840.1.113883.5.111", "granddaughter", "granddaughter",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">grandfather</div>
	 * <!-- @formatter:on -->
	 */
	GRANDFATHER_L4("GRFTH", "2.16.840.1.113883.5.111", "grandfather", "grandfather", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">grandmother</div>
	 * <!-- @formatter:on -->
	 */
	GRANDMOTHER_L4("GRMTH", "2.16.840.1.113883.5.111", "grandmother", "grandmother", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">grandparent</div>
	 * <!-- @formatter:on -->
	 */
	GRANDPARENT_L3("GRPRN", "2.16.840.1.113883.5.111", "grandparent", "grandparent", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">grandson</div>
	 * <!-- @formatter:on -->
	 */
	GRANDSON_L4("GRNDSON", "2.16.840.1.113883.5.111", "grandson", "grandson", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">great grandfather</div>
	 * <!-- @formatter:on -->
	 */
	GREAT_GRANDFATHER_L4("GGRFTH", "2.16.840.1.113883.5.111", "great grandfather",
			"great grandfather", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">great grandmother</div>
	 * <!-- @formatter:on -->
	 */
	GREAT_GRANDMOTHER_L4("GGRMTH", "2.16.840.1.113883.5.111", "great grandmother",
			"great grandmother", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">great grandparent</div>
	 * <!-- @formatter:on -->
	 */
	GREAT_GRANDPARENT_L3("GGRPRN", "2.16.840.1.113883.5.111", "great grandparent",
			"great grandparent", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">half-brother</div>
	 * <!-- @formatter:on -->
	 */
	HALF_BROTHER_L4("HBRO", "2.16.840.1.113883.5.111", "half-brother", "half-brother",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">half-sibling</div>
	 * <!-- @formatter:on -->
	 */
	HALF_SIBLING_L3("HSIB", "2.16.840.1.113883.5.111", "half-sibling", "half-sibling",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">half-sister</div>
	 * <!-- @formatter:on -->
	 */
	HALF_SISTER_L4("HSIS", "2.16.840.1.113883.5.111", "half-sister", "half-sister", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">husband</div>
	 * <!-- @formatter:on -->
	 */
	HUSBAND_L4("HUSB", "2.16.840.1.113883.5.111", "husband", "husband", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">identical twin brother</div>
	 * <!-- @formatter:on -->
	 */
	IDENTICAL_TWIN_BROTHER_L6("ITWINBRO", "2.16.840.1.113883.5.111", "identical twin brother",
			"identical twin brother", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">identical twin</div>
	 * <!-- @formatter:on -->
	 */
	IDENTICAL_TWIN_L5("ITWIN", "2.16.840.1.113883.5.111", "identical twin", "identical twin",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">identical twin sister</div>
	 * <!-- @formatter:on -->
	 */
	IDENTICAL_TWIN_SISTER_L6("ITWINSIS", "2.16.840.1.113883.5.111", "identical twin sister",
			"identical twin sister", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">inlaw</div>
	 * <!-- @formatter:on -->
	 */
	INLAW_L3("INLAW", "2.16.840.1.113883.5.111", "inlaw", "inlaw", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal aunt</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_AUNT_L4("MAUNT", "2.16.840.1.113883.5.111", "maternal aunt", "maternal aunt",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal cousin</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_COUSIN_L4("MCOUSN", "2.16.840.1.113883.5.111", "maternal cousin", "maternal cousin",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal grandfather</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_GRANDFATHER_L5("MGRFTH", "2.16.840.1.113883.5.111", "maternal grandfather",
			"maternal grandfather", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal grandmother</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_GRANDMOTHER_L5("MGRMTH", "2.16.840.1.113883.5.111", "maternal grandmother",
			"maternal grandmother", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal grandparent</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_GRANDPARENT_L4("MGRPRN", "2.16.840.1.113883.5.111", "maternal grandparent",
			"maternal grandparent", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal great-grandfather</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_GREAT_GRANDFATHER_L5("MGGRFTH", "2.16.840.1.113883.5.111",
			"maternal great-grandfather", "maternal great-grandfather", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal great-grandmother</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_GREAT_GRANDMOTHER_L5("MGGRMTH", "2.16.840.1.113883.5.111",
			"maternal great-grandmother", "maternal great-grandmother", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal great-grandparent</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_GREAT_GRANDPARENT_L4("MGGRPRN", "2.16.840.1.113883.5.111",
			"maternal great-grandparent", "maternal great-grandparent", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">maternal uncle</div>
	 * <!-- @formatter:on -->
	 */
	MATERNAL_UNCLE_L4("MUNCLE", "2.16.840.1.113883.5.111", "maternal uncle", "maternal uncle",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">mother-in-law</div>
	 * <!-- @formatter:on -->
	 */
	MOTHER_IN_LAW_L5("MTHINLAW", "2.16.840.1.113883.5.111", "mother-in-law", "mother-in-law",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">mother</div>
	 * <!-- @formatter:on -->
	 */
	MOTHER_L3("MTH", "2.16.840.1.113883.5.111", "mother", "mother", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural brother</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_BROTHER_L4("NBRO", "2.16.840.1.113883.5.111", "natural brother", "natural brother",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural child</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_CHILD_L3("NCHILD", "2.16.840.1.113883.5.111", "natural child", "natural child",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural daughter</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_DAUGHTER_L4("DAU", "2.16.840.1.113883.5.111", "natural daughter", "natural daughter",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural father</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_FATHER_L4("NFTH", "2.16.840.1.113883.5.111", "natural father", "natural father",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural father of fetus</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_FATHER_OF_FETUS_L5("NFTHF", "2.16.840.1.113883.5.111", "natural father of fetus",
			"natural father of fetus", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural mother</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_MOTHER_L4("NMTH", "2.16.840.1.113883.5.111", "natural mother", "natural mother",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural mother of fetus</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_MOTHER_OF_FETUS_L5("NMTHF", "2.16.840.1.113883.5.111", "natural mother of fetus",
			"natural mother of fetus", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural parent</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_PARENT_L3("NPRN", "2.16.840.1.113883.5.111", "natural parent", "natural parent",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural sibling</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_SIBLING_L3("NSIB", "2.16.840.1.113883.5.111", "natural sibling", "natural sibling",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural sister</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_SISTER_L4("NSIS", "2.16.840.1.113883.5.111", "natural sister", "natural sister",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">natural son</div>
	 * <!-- @formatter:on -->
	 */
	NATURAL_SON_L4("SON", "2.16.840.1.113883.5.111", "natural son", "natural son", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">neighbor</div>
	 * <!-- @formatter:on -->
	 */
	NEIGHBOR_L1("NBOR", "2.16.840.1.113883.5.111", "neighbor", "neighbor", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">nephew</div>
	 * <!-- @formatter:on -->
	 */
	NEPHEW_L4("NEPHEW", "2.16.840.1.113883.5.111", "nephew", "nephew", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">niece</div>
	 * <!-- @formatter:on -->
	 */
	NIECE_L4("NIECE", "2.16.840.1.113883.5.111", "niece", "niece", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">niece/nephew</div>
	 * <!-- @formatter:on -->
	 */
	NIECE_NEPHEW_L3("NIENEPH", "2.16.840.1.113883.5.111", "niece/nephew", "niece/nephew",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">parent in-law</div>
	 * <!-- @formatter:on -->
	 */
	PARENT_IN_LAW_L4("PRNINLAW", "2.16.840.1.113883.5.111", "parent in-law", "parent in-law",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">parent</div>
	 * <!-- @formatter:on -->
	 */
	PARENT_L2("PRN", "2.16.840.1.113883.5.111", "parent", "parent", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal aunt</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_AUNT_L4("PAUNT", "2.16.840.1.113883.5.111", "paternal aunt", "paternal aunt",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal cousin</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_COUSIN_L4("PCOUSN", "2.16.840.1.113883.5.111", "paternal cousin", "paternal cousin",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal grandfather</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_GRANDFATHER_L5("PGRFTH", "2.16.840.1.113883.5.111", "paternal grandfather",
			"paternal grandfather", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal grandmother</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_GRANDMOTHER_L5("PGRMTH", "2.16.840.1.113883.5.111", "paternal grandmother",
			"paternal grandmother", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal grandparent</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_GRANDPARENT_L4("PGRPRN", "2.16.840.1.113883.5.111", "paternal grandparent",
			"paternal grandparent", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal great-grandfather</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_GREAT_GRANDFATHER_L5("PGGRFTH", "2.16.840.1.113883.5.111",
			"paternal great-grandfather", "paternal great-grandfather", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal great-grandmother</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_GREAT_GRANDMOTHER_L5("PGGRMTH", "2.16.840.1.113883.5.111",
			"paternal great-grandmother", "paternal great-grandmother", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal great-grandparent</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_GREAT_GRANDPARENT_L4("PGGRPRN", "2.16.840.1.113883.5.111",
			"paternal great-grandparent", "paternal great-grandparent", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">paternal uncle</div>
	 * <!-- @formatter:on -->
	 */
	PATERNAL_UNCLE_L4("PUNCLE", "2.16.840.1.113883.5.111", "paternal uncle", "paternal uncle",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Roommate</div>
	 * <!-- @formatter:on -->
	 */
	ROOMMATE_L1("ROOM", "2.16.840.1.113883.5.111", "Roommate", "Roommate", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">self</div>
	 * <!-- @formatter:on -->
	 */
	SELF_L1("ONESELF", "2.16.840.1.113883.5.111", "self", "self", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">sibling in-law</div>
	 * <!-- @formatter:on -->
	 */
	SIBLING_IN_LAW_L4("SIBINLAW", "2.16.840.1.113883.5.111", "sibling in-law", "sibling in-law",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">sibling</div>
	 * <!-- @formatter:on -->
	 */
	SIBLING_L2("SIB", "2.16.840.1.113883.5.111", "sibling", "sibling", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">significant other</div>
	 * <!-- @formatter:on -->
	 */
	SIGNIFICANT_OTHER_L2("SIGOTHR", "2.16.840.1.113883.5.111", "significant other",
			"significant other", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">sister-in-law</div>
	 * <!-- @formatter:on -->
	 */
	SISTER_IN_LAW_L5("SISINLAW", "2.16.840.1.113883.5.111", "sister-in-law", "sister-in-law",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">sister</div>
	 * <!-- @formatter:on -->
	 */
	SISTER_L3("SIS", "2.16.840.1.113883.5.111", "sister", "sister", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">son in-law</div>
	 * <!-- @formatter:on -->
	 */
	SON_IN_LAW_L5("SONINLAW", "2.16.840.1.113883.5.111", "son in-law", "son in-law", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">son</div>
	 * <!-- @formatter:on -->
	 */
	SON_L3("SONC", "2.16.840.1.113883.5.111", "son", "son", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">spouse</div>
	 * <!-- @formatter:on -->
	 */
	SPOUSE_L3("SPS", "2.16.840.1.113883.5.111", "spouse", "spouse", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">stepbrother</div>
	 * <!-- @formatter:on -->
	 */
	STEPBROTHER_L4("STPBRO", "2.16.840.1.113883.5.111", "stepbrother", "stepbrother", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">stepdaughter</div>
	 * <!-- @formatter:on -->
	 */
	STEPDAUGHTER_L4("STPDAU", "2.16.840.1.113883.5.111", "stepdaughter", "stepdaughter",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">stepfather</div>
	 * <!-- @formatter:on -->
	 */
	STEPFATHER_L4("STPFTH", "2.16.840.1.113883.5.111", "stepfather", "stepfather", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">stepmother</div>
	 * <!-- @formatter:on -->
	 */
	STEPMOTHER_L4("STPMTH", "2.16.840.1.113883.5.111", "stepmother", "stepmother", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">stepsister</div>
	 * <!-- @formatter:on -->
	 */
	STEPSISTER_L4("STPSIS", "2.16.840.1.113883.5.111", "stepsister", "stepsister", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">stepson</div>
	 * <!-- @formatter:on -->
	 */
	STEPSON_L4("STPSON", "2.16.840.1.113883.5.111", "stepson", "stepson", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">step child</div>
	 * <!-- @formatter:on -->
	 */
	STEP_CHILD_L3("STPCHLD", "2.16.840.1.113883.5.111", "step child", "step child", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">step parent</div>
	 * <!-- @formatter:on -->
	 */
	STEP_PARENT_L3("STPPRN", "2.16.840.1.113883.5.111", "step parent", "step parent", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">step sibling</div>
	 * <!-- @formatter:on -->
	 */
	STEP_SIBLING_L3("STPSIB", "2.16.840.1.113883.5.111", "step sibling", "step sibling",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">twin brother</div>
	 * <!-- @formatter:on -->
	 */
	TWIN_BROTHER_L5("TWINBRO", "2.16.840.1.113883.5.111", "twin brother", "twin brother",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">twin</div>
	 * <!-- @formatter:on -->
	 */
	TWIN_L4("TWIN", "2.16.840.1.113883.5.111", "twin", "twin", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">twin sister</div>
	 * <!-- @formatter:on -->
	 */
	TWIN_SISTER_L5("TWINSIS", "2.16.840.1.113883.5.111", "twin sister", "twin sister",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">uncle</div>
	 * <!-- @formatter:on -->
	 */
	UNCLE_L3("UNCLE", "2.16.840.1.113883.5.111", "uncle", "uncle", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">unrelated friend</div>
	 * <!-- @formatter:on -->
	 */
	UNRELATED_FRIEND_L1("FRND", "2.16.840.1.113883.5.111", "unrelated friend", "unrelated friend",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">wife</div>
	 * <!-- @formatter:on -->
	 */
	WIFE_L4("WIFE", "2.16.840.1.113883.5.111", "wife", "wife", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for adopted child</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADOPTED_CHILD_L3_CODE = "CHLDADOPT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for adopted daughter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADOPTED_DAUGHTER_L4_CODE = "DAUADOPT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for adopted son</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADOPTED_SON_L4_CODE = "SONADOPT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for adoptive father</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADOPTIVE_FATHER_L4_CODE = "ADOPTF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for adoptive mother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADOPTIVE_MOTHER_L4_CODE = "ADOPTM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for adoptive parent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADOPTIVE_PARENT_L3_CODE = "ADOPTP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for aunt</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUNT_L3_CODE = "AUNT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for brother-in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BROTHER_IN_LAW_L5_CODE = "BROINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for brother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BROTHER_L3_CODE = "BRO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for child-in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHILD_IN_LAW_L4_CODE = "CHLDINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for child</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHILD_L2_CODE = "CHILD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for cousin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COUSIN_L3_CODE = "COUSN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for daughter in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DAUGHTER_IN_LAW_L5_CODE = "DAUINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for daughter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DAUGHTER_L3_CODE = "DAUC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for domestic partner</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOMESTIC_PARTNER_L3_CODE = "DOMPART";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for extended family member</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXTENDED_FAMILY_MEMBER_L2_CODE = "EXT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for family member</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FAMILY_MEMBER_L1_CODE = "FAMMEMB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for father-in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FATHER_IN_LAW_L5_CODE = "FTHINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for father</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FATHER_L3_CODE = "FTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for former spouse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FORMER_SPOUSE_L3_CODE = "FMRSPS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for foster child</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FOSTER_CHILD_L3_CODE = "CHLDFOST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for foster daughter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FOSTER_DAUGHTER_L4_CODE = "DAUFOST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for foster father</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FOSTER_FATHER_L4_CODE = "FTHFOST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for foster mother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FOSTER_MOTHER_L4_CODE = "MTHFOST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for foster parent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FOSTER_PARENT_L3_CODE = "PRNFOST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for foster son</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FOSTER_SON_L4_CODE = "SONFOST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for fraternal twin brother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRATERNAL_TWIN_BROTHER_L6_CODE = "FTWINBRO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for fraternal twin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRATERNAL_TWIN_L5_CODE = "FTWIN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for fraternal twin sister</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRATERNAL_TWIN_SISTER_L6_CODE = "FTWINSIS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for gestational mother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GESTATIONAL_MOTHER_L4_CODE = "GESTM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for grandchild</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANDCHILD_L3_CODE = "GRNDCHILD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for granddaughter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANDDAUGHTER_L4_CODE = "GRNDDAU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for grandfather</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANDFATHER_L4_CODE = "GRFTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for grandmother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANDMOTHER_L4_CODE = "GRMTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for grandparent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANDPARENT_L3_CODE = "GRPRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for grandson</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANDSON_L4_CODE = "GRNDSON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for great grandfather</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GREAT_GRANDFATHER_L4_CODE = "GGRFTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for great grandmother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GREAT_GRANDMOTHER_L4_CODE = "GGRMTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for great grandparent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GREAT_GRANDPARENT_L3_CODE = "GGRPRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for half-brother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HALF_BROTHER_L4_CODE = "HBRO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for half-sibling</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HALF_SIBLING_L3_CODE = "HSIB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for half-sister</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HALF_SISTER_L4_CODE = "HSIS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for husband</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HUSBAND_L4_CODE = "HUSB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for identical twin brother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IDENTICAL_TWIN_BROTHER_L6_CODE = "ITWINBRO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for identical twin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IDENTICAL_TWIN_L5_CODE = "ITWIN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for identical twin sister</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IDENTICAL_TWIN_SISTER_L6_CODE = "ITWINSIS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for inlaw</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INLAW_L3_CODE = "INLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal aunt</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_AUNT_L4_CODE = "MAUNT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal cousin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_COUSIN_L4_CODE = "MCOUSN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal grandfather</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_GRANDFATHER_L5_CODE = "MGRFTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal grandmother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_GRANDMOTHER_L5_CODE = "MGRMTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal grandparent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_GRANDPARENT_L4_CODE = "MGRPRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal great-grandfather</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_GREAT_GRANDFATHER_L5_CODE = "MGGRFTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal great-grandmother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_GREAT_GRANDMOTHER_L5_CODE = "MGGRMTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal great-grandparent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_GREAT_GRANDPARENT_L4_CODE = "MGGRPRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for maternal uncle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATERNAL_UNCLE_L4_CODE = "MUNCLE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for mother-in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOTHER_IN_LAW_L5_CODE = "MTHINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for mother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOTHER_L3_CODE = "MTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural brother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_BROTHER_L4_CODE = "NBRO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural child</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_CHILD_L3_CODE = "NCHILD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural daughter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_DAUGHTER_L4_CODE = "DAU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural father</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_FATHER_L4_CODE = "NFTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural father of fetus</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_FATHER_OF_FETUS_L5_CODE = "NFTHF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural mother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_MOTHER_L4_CODE = "NMTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural mother of fetus</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_MOTHER_OF_FETUS_L5_CODE = "NMTHF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural parent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_PARENT_L3_CODE = "NPRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural sibling</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_SIBLING_L3_CODE = "NSIB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural sister</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_SISTER_L4_CODE = "NSIS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for natural son</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATURAL_SON_L4_CODE = "SON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for neighbor</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEIGHBOR_L1_CODE = "NBOR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for nephew</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEPHEW_L4_CODE = "NEPHEW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for niece</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NIECE_L4_CODE = "NIECE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for niece/nephew</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NIECE_NEPHEW_L3_CODE = "NIENEPH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for parent in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PARENT_IN_LAW_L4_CODE = "PRNINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for parent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PARENT_L2_CODE = "PRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal aunt</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_AUNT_L4_CODE = "PAUNT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal cousin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_COUSIN_L4_CODE = "PCOUSN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal grandfather</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_GRANDFATHER_L5_CODE = "PGRFTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal grandmother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_GRANDMOTHER_L5_CODE = "PGRMTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal grandparent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_GRANDPARENT_L4_CODE = "PGRPRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal great-grandfather</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_GREAT_GRANDFATHER_L5_CODE = "PGGRFTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal great-grandmother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_GREAT_GRANDMOTHER_L5_CODE = "PGGRMTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal great-grandparent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_GREAT_GRANDPARENT_L4_CODE = "PGGRPRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for paternal uncle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATERNAL_UNCLE_L4_CODE = "PUNCLE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Roommate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROOMMATE_L1_CODE = "ROOM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for self</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SELF_L1_CODE = "ONESELF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for sibling in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIBLING_IN_LAW_L4_CODE = "SIBINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for sibling</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIBLING_L2_CODE = "SIB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for significant other</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIGNIFICANT_OTHER_L2_CODE = "SIGOTHR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for sister-in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SISTER_IN_LAW_L5_CODE = "SISINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for sister</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SISTER_L3_CODE = "SIS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for son in-law</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SON_IN_LAW_L5_CODE = "SONINLAW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for son</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SON_L3_CODE = "SONC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for spouse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPOUSE_L3_CODE = "SPS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for stepbrother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEPBROTHER_L4_CODE = "STPBRO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for stepdaughter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEPDAUGHTER_L4_CODE = "STPDAU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for stepfather</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEPFATHER_L4_CODE = "STPFTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for stepmother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEPMOTHER_L4_CODE = "STPMTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for stepsister</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEPSISTER_L4_CODE = "STPSIS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for stepson</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEPSON_L4_CODE = "STPSON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for step child</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEP_CHILD_L3_CODE = "STPCHLD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for step parent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEP_PARENT_L3_CODE = "STPPRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for step sibling</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STEP_SIBLING_L3_CODE = "STPSIB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for twin brother</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TWIN_BROTHER_L5_CODE = "TWINBRO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for twin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TWIN_L4_CODE = "TWIN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for twin sister</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TWIN_SISTER_L5_CODE = "TWINSIS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for uncle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNCLE_L3_CODE = "UNCLE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for unrelated friend</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNRELATED_FRIEND_L1_CODE = "FRND";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for wife</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WIFE_L4_CODE = "WIFE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.19563";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "PersonalRelationshipRoleType";

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
	public static PersonalRelationshipRoleType getEnum(final String code) {
		for (final PersonalRelationshipRoleType x : values()) {
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
	public static boolean isEnumOfValueSet(final String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(PersonalRelationshipRoleType.class, enumName);
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
	public static boolean isInValueSet(final String codeValue) {
		for (final PersonalRelationshipRoleType x : values()) {
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
	PersonalRelationshipRoleType(final String code, final String codeSystem,
			final String displayName, final String displayNameEn, final String displayNameDe,
			final String displayNameFr, final String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		this.displayNames = new HashMap<>();
		this.displayNames.put(null, displayName);
		this.displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		this.displayNames.put(LanguageCode.GERMAN, displayNameDe);
		this.displayNames.put(LanguageCode.FRENCH, displayNameFr);
		this.displayNames.put(LanguageCode.ITALIAN, displayNameIt);
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
		String displayName = this.displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return this.displayNames.get(null);
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
