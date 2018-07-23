/*
 *
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
package org.ehealth_connector.cda.ch.lab.lrph.enums;

import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * The Enum LabObsListSnomed.
 */
/*
 * <div class="en">Notifiable Observation</div> <div class="de">Meldepflichtige
 * Beobachtung</div>
 */
public enum LabObsListSnomed {

	/** <div class="en">Brucella</div>. */
	BRUCELLA("26250004", "Brucella", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Brucella abortus</div>. */
	BRUCELLA_ABORTUS("24224000", "Brucella abortus", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Brucella canis</div>. */
	BRUCELLA_CANIS("38025008", "Brucella canis", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Brucella melitensis</div>. */
	BRUCELLA_MELITENSIS("72829003", "Brucella melitensis", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Brucella species</div>. */
	BRUCELLA_SPECIES("116505000", "Brucella species", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Brucella suis</div>. */
	BRUCELLA_SUIS("48317004", "Brucella suis", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Campylobacter</div>. */
	CAMPYLOBACTER("35408001", "Campylobacter", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Campylobacter coli</div>. */
	CAMPYLOBACTER_COLI("40614002", "Campylobacter coli", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Campylobacter curvus</div>. */
	CAMPYLOBACTER_CURVUS("116037008", "Campylobacter curvus", "18725-2", "initials", "20130527",
			""),

	/** <div class="en">Campylobacter fetus</div>. */
	CAMPYLOBACTER_FETUS("84210007", "Campylobacter fetus", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Campylobacter hyointestinalis</div>. */
	CAMPYLOBACTER_HYOINTESTINALIS("9041007", "Campylobacter hyointestinalis", "18725-2", "initials",
			"20130527", ""),

	/** <div class="en">Campylobacter jejuni</div>. */
	CAMPYLOBACTER_JEJUNI("66543000", "Campylobacter jejuni", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Campylobacter lari</div>. */
	CAMPYLOBACTER_LARI("116386003", "Campylobacter lari", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Campylobacter rectus</div>. */
	CAMPYLOBACTER_RECTUS("113525005", "Campylobacter rectus", "18725-2", "initials", "20130527",
			""),

	/** <div class="en">Campylobacter species</div>. */
	CAMPYLOBACTER_SPECIES("116457002", "Campylobacter species", "18725-2", "initials", "20130527",
			""),

	/** <div class="en">Campylobacter sputorum</div>. */
	CAMPYLOBACTER_SPUTORUM("91524009", "Campylobacter sputorum", "18725-2", "initials", "20130527",
			""),

	/** <div class="en">Campylobacter upsaliensis</div>. */
	CAMPYLOBACTER_UPSALIENSIS("103427005", "Campylobacter upsaliensis", "18725-2", "initials",
			"20130527", ""),

	/** <div class="en">Chlamydia trachomatis</div>. */
	CHLAMYDIA_TRACHOMATIS("63938009", "Chlamydia trachomatis", "18725-2", "initials", "20130527",
			""),

	/** <div class="en">Corynebacterium diphtheriae</div>. */
	CORYNEBACTERIUM_DIPHTHERIAE("5851001", "Corynebacterium diphtheriae", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Corynebacterium diphtheriae type gravis</div>. */
	CORYNEBACTERIUM_DIPHTHERIAE_TYPE_GRAVIS("83675005", "Corynebacterium diphtheriae type gravis",
			"18725-2", "none", "20130527", ""),

	/** <div class="en">Corynebacterium diphtheriae type intermedius</div>. */
	CORYNEBACTERIUM_DIPHTHERIAE_TYPE_INTERMEDIUS("70876001",
			"Corynebacterium diphtheriae type intermedius", "18725-2", "none", "20130527", ""),

	/** <div class="en">Corynebacterium diphtheriae type mitis</div>. */
	CORYNEBACTERIUM_DIPHTHERIAE_TYPE_MITIS("13755001", "Corynebacterium diphtheriae type mitis",
			"18725-2", "none", "20130527", ""),

	/** <div class="en">Corynebacterium diphtheriae var belfanti</div>. */
	CORYNEBACTERIUM_DIPHTHERIAE_VAR_BELFANTI("243255007",
			"Corynebacterium diphtheriae var belfanti", "18725-2", "none", "20130527", ""),

	/** <div class="en">Dengue virus</div>. */
	DENGUE_VIRUS("34348001", "Dengue virus", "18725-2", "none", "20130527", ""),

	/** <div class="en">Dengue virus, type 1</div>. */
	DENGUE_VIRUS_TYPE_1("60588009", "Dengue virus, type 1", "18725-2", "none", "20130527", ""),

	/** <div class="en">Dengue virus, type 2</div>. */
	DENGUE_VIRUS_TYPE_2("41328007", "Dengue virus, type 2", "18725-2", "none", "20130527", ""),

	/** <div class="en">Dengue virus, type 3</div>. */
	DENGUE_VIRUS_TYPE_3("8467002", "Dengue virus, type 3", "18725-2", "none", "20130527", ""),

	/** <div class="en">Dengue virus, type 4</div>. */
	DENGUE_VIRUS_TYPE_4("36700002", "Dengue virus, type 4", "18725-2", "none", "20130527", ""),

	/** <div class="en">Francisella tularensis</div>. */
	FRANCISELLA_TULARENSIS("51526001", "Francisella tularensis", "18725-2", "none", "20130527", ""),
	/**
	 * <div class="en">Francisella tularensis ss. holarctica</div>
	 */
	FRANCISELLA_TULARENSIS_SS_HOLARCTICA("60502008", "Francisella tularensis ss. holarctica",
			"18725-2", "none", "20130527", ""),
	/**
	 * <div class="en">Francisella tularensis ss. mediasiatica</div>
	 */
	FRANCISELLA_TULARENSIS_SS_MEDIASIATICA("23930001", "Francisella tularensis ss. mediasiatica",
			"18725-2", "none", "20130527", ""),
	/**
	 * <div class="en">Francisella tularensis ss. tularensis</div>
	 */
	FRANCISELLA_TULARENSIS_SS_TULARENSIS("91508008", "Francisella tularensis ss. tularensis",
			"18725-2", "none", "20130527", ""),

	/** <div class="en">Haemophilus influenzae</div>. */
	HAEMOPHILUS_INFLUENZAE("44470000", "Haemophilus influenzae", "18725-2", "initials", "20130527",
			""),

	/** <div class="en">Haemophilus influenzae, not B</div>. */
	HAEMOPHILUS_INFLUENZAE_NOT_B("115407004", "Haemophilus influenzae, not B", "18725-2",
			"initials", "20130527", ""),

	/** <div class="en">Haemophilus influenzae type A</div>. */
	HAEMOPHILUS_INFLUENZAE_TYPE_A("103441001", "Haemophilus influenzae type A", "18725-2",
			"initials", "20130527", ""),

	/** <div class="en">Haemophilus influenzae type B</div>. */
	HAEMOPHILUS_INFLUENZAE_TYPE_B("103442008", "Haemophilus influenzae type B", "18725-2",
			"initials", "20130527", ""),

	/** <div class="en">Haemophilus influenzae type C</div>. */
	HAEMOPHILUS_INFLUENZAE_TYPE_C("103443003", "Haemophilus influenzae type C", "18725-2",
			"initials", "20130527", ""),

	/** <div class="en">Haemophilus influenzae type D</div>. */
	HAEMOPHILUS_INFLUENZAE_TYPE_D("103444009", "Haemophilus influenzae type D", "18725-2",
			"initials", "20130527", ""),

	/** <div class="en">Haemophilus influenzae type E</div>. */
	HAEMOPHILUS_INFLUENZAE_TYPE_E("103445005", "Haemophilus influenzae type E", "18725-2",
			"initials", "20130527", ""),

	/** <div class="en">Haemophilus influenzae type F</div>. */
	HAEMOPHILUS_INFLUENZAE_TYPE_F("103446006", "Haemophilus influenzae type F", "18725-2",
			"initials", "20130527", ""),

	/** <div class="en">Legionella bozemanii</div>. */
	LEGIONELLA_BOZEMANII("37835001", "Legionella bozemanii", "18725-2", "none", "20130527", ""),

	/** <div class="en">Legionella longbeachae</div>. */
	LEGIONELLA_LONGBEACHAE("89605004", "Legionella longbeachae", "18725-2", "none", "20130527", ""),

	/** <div class="en">Legionella longbeachae, serogroup 1</div>. */
	LEGIONELLA_LONGBEACHAE_SEROGROUP_1("115515003", "Legionella longbeachae, serogroup 1",
			"18725-2", "none", "20130527", ""),

	/** <div class="en">Legionella longbeachae, serogroup 2</div>. */
	LEGIONELLA_LONGBEACHAE_SEROGROUP_2("115516002", "Legionella longbeachae, serogroup 2",
			"18725-2", "none", "20130527", ""),

	/** <div class="en">Legionella pneumophila</div>. */
	LEGIONELLA_PNEUMOPHILA("80897008", "Legionella pneumophila", "18725-2", "none", "20130527", ""),

	/** <div class="en">Legionella pneumophila serogroup 1</div>. */
	LEGIONELLA_PNEUMOPHILA_SEROGROUP_1("103463005", "Legionella pneumophila serogroup 1", "18725-2",
			"none", "20130527", ""),

	/** <div class="en">Legionella pneumophila serogroup 4</div>. */
	LEGIONELLA_PNEUMOPHILA_SEROGROUP_4("103466002", "Legionella pneumophila serogroup 4", "18725-2",
			"none", "20130527", ""),

	/** <div class="en">Legionella pneumophila serogroup 6</div>. */
	LEGIONELLA_PNEUMOPHILA_SEROGROUP_6("103468001", "Legionella pneumophila serogroup 6", "18725-2",
			"none", "20130527", ""),
	/**
	 * <div class="en">Legionella pneumophila ss. pneumophila</div>
	 */
	LEGIONELLA_PNEUMOPHILA_SS_PNEUMOPHILA("103458006", "Legionella pneumophila ss. pneumophila",
			"18725-2", "none", "20130527", ""),

	/** <div class="en">Listeria</div>. */
	LISTERIA("23566007", "Listeria", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Listeria monocytogenes</div>. */
	LISTERIA_MONOCYTOGENES("36094007", "Listeria monocytogenes", "18725-2", "initials", "20130527",
			""),

	/** <div class="en">Mycobacterium africanum</div>. */
	MYCOBACTERIUM_AFRICANUM("51320008", "Mycobacterium africanum", "18725-2", "none", "20130527",
			""),

	/** <div class="en">Mycobacterium bovis</div>. */
	MYCOBACTERIUM_BOVIS("27142009", "Mycobacterium bovis", "18725-2", "none", "20130527", ""),

	/** <div class="en">Mycobacterium caprae</div>. */
	MYCOBACTERIUM_CAPRAE("430579009", "Mycobacterium caprae", "18725-2", "none", "20130527", ""),

	/** <div class="en">Mycobacterium tuberculosis</div>. */
	MYCOBACTERIUM_TUBERCULOSIS("113861009", "Mycobacterium tuberculosis", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Mycobacterium tuberculosis complex</div>. */
	MYCOBACTERIUM_TUBERCULOSIS_COMPLEX("113858008", "Mycobacterium tuberculosis complex", "18725-2",
			"none", "20130527", ""),

	/** <div class="en">Neisseria gonorrhoeae</div>. */
	NEISSERIA_GONORRHOEAE("68704007", "Neisseria gonorrhoeae", "18725-2", "initials", "20130527",
			""),

	/** <div class="en">Neisseria meningitidis</div>. */
	NEISSERIA_MENINGITIDIS("17872004", "Neisseria meningitidis", "18725-2", "none", "20130527", ""),

	/** <div class="en">Neisseria meningitidis group A</div>. */
	NEISSERIA_MENINGITIDIS_GROUP_A("103479006", "Neisseria meningitidis group A", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Neisseria meningitidis group B</div>. */
	NEISSERIA_MENINGITIDIS_GROUP_B("103480009", "Neisseria meningitidis group B", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Neisseria meningitidis group C</div>. */
	NEISSERIA_MENINGITIDIS_GROUP_C("103481008", "Neisseria meningitidis group C", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Neisseria meningitidis group X</div>. */
	NEISSERIA_MENINGITIDIS_GROUP_X("125041003", "Neisseria meningitidis group X", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Neisseria meningitidis group Y</div>. */
	NEISSERIA_MENINGITIDIS_GROUP_Y("103482001", "Neisseria meningitidis group Y", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Neisseria meningitidis group Z</div>. */
	NEISSERIA_MENINGITIDIS_GROUP_Z("125042005", "Neisseria meningitidis group Z", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Neisseria meningitidis W135</div>. */
	NEISSERIA_MENINGITIDIS_W135("103483006", "Neisseria meningitidis W135", "18725-2", "none",
			"20130527", ""),

	/** <div class="en">Salmonella</div>. */
	SALMONELLA("27268008", "Salmonella", "18725-2", "none", "20130527", ""),

	/** <div class="en">Salmonella enteritidis</div>. */
	SALMONELLA_ENTERITIDIS("73525009", "Salmonella enteritidis", "18725-2", "none", "20130527", ""),

	/** <div class="en">Salmonella paratyphi A</div>. */
	SALMONELLA_PARATYPHI_A("79128009", "Salmonella paratyphi A", "18725-2", "none", "20130527", ""),

	/** <div class="en">Salmonella paratyphi B</div>. */
	SALMONELLA_PARATYPHI_B("85908006", "Salmonella paratyphi B", "18725-2", "none", "20130527", ""),

	/** <div class="en">Salmonella paratyphi C</div>. */
	SALMONELLA_PARATYPHI_C("32488009", "Salmonella paratyphi C", "18725-2", "none", "20130527", ""),

	/** <div class="en">Salmonella species</div>. */
	SALMONELLA_SPECIES("372342007", "Salmonella species", "18725-2", "none", "20130527", ""),

	/** <div class="en">Salmonella typhi</div>. */
	SALMONELLA_TYPHI("5595000", "Salmonella typhi", "18725-2", "none", "20130527", ""),

	/** <div class="en">Salmonella typhimurium</div>. */
	SALMONELLA_TYPHIMURIUM("50136005", "Salmonella typhimurium", "18725-2", "none", "20130527", ""),

	/** <div class="en">Shigella boydii</div>. */
	SHIGELLA_BOYDII("55462008", "Shigella boydii", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Shigella dysenteriae</div>. */
	SHIGELLA_DYSENTERIAE("43612004", "Shigella dysenteriae", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Shigella flexneri</div>. */
	SHIGELLA_FLEXNERI("85729005", "Shigella flexneri", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Shigella sonnei</div>. */
	SHIGELLA_SONNEI("4298009", "Shigella sonnei", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Shigella species</div>. */
	SHIGELLA_SPECIES("116498009", "Shigella species", "18725-2", "initials", "20130527", ""),

	/** <div class="en">Streptococcus penumoniae 3</div>. */
	STREPTOCOCCUS_PENUMONIAE_3("103497003", "Streptococcus penumoniae 3", "18725-2", "initials",
			"20130527", ""),

	/** <div class="en">Streptococcus penumoniae, serotype 29</div>. */
	STREPTOCOCCUS_PENUMONIAE_SEROTYPE_29("131363003", "Streptococcus penumoniae, serotype 29",
			"18725-2", "initials", "20130527", ""),

	/** <div class="en">Streptococcus pneumoniae</div>. */
	STREPTOCOCCUS_PNEUMONIAE("9861002", "Streptococcus pneumoniae", "18725-2", "initials",
			"20130527", ""),

	/** <div class="en">Streptococcus pneumoniae 14</div>. */
	STREPTOCOCCUS_PNEUMONIAE_14("103498008", "Streptococcus pneumoniae 14", "18725-2", "initials",
			"20130527", ""),

	/** <div class="en">Streptococcus pneumoniae 7F</div>. */
	STREPTOCOCCUS_PNEUMONIAE_7F("103499000", "Streptococcus pneumoniae 7F", "18725-2", "initials",
			"20130527", ""),

	/** <div class="en">Streptococcus pneumoniae 9N</div>. */
	STREPTOCOCCUS_PNEUMONIAE_9N("103500009", "Streptococcus pneumoniae 9N", "18725-2", "initials",
			"20130527", ""),

	/** <div class="en">Streptococcus pneumoniae, serotype 11</div>. */
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_11("363768008", "Streptococcus pneumoniae, serotype 11",
			"18725-2", "initials", "20130527", ""),

	/** <div class="en">Streptococcus pneumoniae, serotype 12</div>. */
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_12("116500005", "Streptococcus pneumoniae, serotype 12",
			"18725-2", "initials", "20130527", ""),

	/** <div class="en">Streptococcus pneumoniae, serotype 16</div>. */
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_16("131362008", "Streptococcus pneumoniae, serotype 16",
			"18725-2", "initials", "20130527", ""),

	/** <div class="en">Streptococcus pneumoniae, serotype 17</div>. */
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_17("131361001", "Streptococcus pneumoniae, serotype 17",
			"18725-2", "initials", "20130527", ""),

	/** <div class="en">Streptococcus pneumoniae, serotype 19</div>. */
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_19("127541006", "Streptococcus pneumoniae, serotype 19",
			"18725-2", "initials", "20130527", ""),

	/** <div class="en">Streptococcus pneumoniae, serotype 22</div>. */
	STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_22("363767003", "Streptococcus pneumoniae, serotype 22",
			"18725-2", "initials", "20130527", ""),

	/** <div class="en">Vibrio cholerae</div>. */
	VIBRIO_CHOLERAE("75953000", "Vibrio cholerae", "18725-2", "initials", "20130527", "");

	/** <div class="en">Code for Brucella abortus</div>. */
	public static final String BRUCELLA_ABORTUS_CODE = "24224000";

	/** <div class="en">Code for Brucella canis</div>. */
	public static final String BRUCELLA_CANIS_CODE = "38025008";

	/** <div class="en">Code for Brucella</div>. */
	public static final String BRUCELLA_CODE = "26250004";

	/** <div class="en">Code for Brucella melitensis</div>. */
	public static final String BRUCELLA_MELITENSIS_CODE = "72829003";

	/** <div class="en">Code for Brucella species</div>. */
	public static final String BRUCELLA_SPECIES_CODE = "116505000";

	/** <div class="en">Code for Brucella suis</div>. */
	public static final String BRUCELLA_SUIS_CODE = "48317004";

	/** <div class="en">Code for Campylobacter</div>. */
	public static final String CAMPYLOBACTER_CODE = "35408001";

	/** <div class="en">Code for Campylobacter coli</div>. */
	public static final String CAMPYLOBACTER_COLI_CODE = "40614002";

	/** <div class="en">Code for Campylobacter curvus</div>. */
	public static final String CAMPYLOBACTER_CURVUS_CODE = "116037008";

	/** <div class="en">Code for Campylobacter fetus</div>. */
	public static final String CAMPYLOBACTER_FETUS_CODE = "84210007";

	/** <div class="en">Code for Campylobacter hyointestinalis</div>. */
	public static final String CAMPYLOBACTER_HYOINTESTINALIS_CODE = "9041007";

	/** <div class="en">Code for Campylobacter jejuni</div>. */
	public static final String CAMPYLOBACTER_JEJUNI_CODE = "66543000";

	/** <div class="en">Code for Campylobacter lari</div>. */
	public static final String CAMPYLOBACTER_LARI_CODE = "116386003";

	/** <div class="en">Code for Campylobacter rectus</div>. */
	public static final String CAMPYLOBACTER_RECTUS_CODE = "113525005";

	/** <div class="en">Code for Campylobacter species</div>. */
	public static final String CAMPYLOBACTER_SPECIES_CODE = "116457002";

	/** <div class="en">Code for Campylobacter sputorum</div>. */
	public static final String CAMPYLOBACTER_SPUTORUM_CODE = "91524009";

	/** <div class="en">Code for Campylobacter upsaliensis</div>. */
	public static final String CAMPYLOBACTER_UPSALIENSIS_CODE = "103427005";

	/** <div class="en">Code for Chlamydia trachomatis</div>. */
	public static final String CHLAMYDIA_TRACHOMATIS_CODE = "63938009";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>.
	 */
	public static final String CODE_SYSTEM_NAME = "lrph-v1-SNOMED";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>.
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";

	/** <div class="en">Code for Corynebacterium diphtheriae</div>. */
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_CODE = "5851001";

	/**
	 * <div class="en">Code for Corynebacterium diphtheriae type gravis</div>.
	 */
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_TYPE_GRAVIS_CODE = "83675005";

	/**
	 * <div class="en">Code for Corynebacterium diphtheriae type
	 * intermedius</div> .
	 */
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_TYPE_INTERMEDIUS_CODE = "70876001";

	/**
	 * <div class="en">Code for Corynebacterium diphtheriae type mitis</div>.
	 */
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_TYPE_MITIS_CODE = "13755001";

	/**
	 * <div class="en">Code for Corynebacterium diphtheriae var belfanti</div>.
	 */
	public static final String CORYNEBACTERIUM_DIPHTHERIAE_VAR_BELFANTI_CODE = "243255007";

	/** <div class="en">Code for Dengue virus</div>. */
	public static final String DENGUE_VIRUS_CODE = "34348001";

	/** <div class="en">Code for Dengue virus, type 1</div>. */
	public static final String DENGUE_VIRUS_TYPE_1_CODE = "60588009";

	/** <div class="en">Code for Dengue virus, type 2</div>. */
	public static final String DENGUE_VIRUS_TYPE_2_CODE = "41328007";

	/** <div class="en">Code for Dengue virus, type 3</div>. */
	public static final String DENGUE_VIRUS_TYPE_3_CODE = "8467002";

	/** <div class="en">Code for Dengue virus, type 4</div>. */
	public static final String DENGUE_VIRUS_TYPE_4_CODE = "36700002";

	/** <div class="en">Code for Francisella tularensis</div>. */
	public static final String FRANCISELLA_TULARENSIS_CODE = "51526001";

	/**
	 * <div class="en">Code for Francisella tularensis ss. holarctica</div>
	 */
	public static final String FRANCISELLA_TULARENSIS_SS_HOLARCTICA_CODE = "60502008";

	/**
	 * <div class="en">Code for Francisella tularensis ss. mediasiatica</div>
	 */
	public static final String FRANCISELLA_TULARENSIS_SS_MEDIASIATICA_CODE = "23930001";

	/**
	 * <div class="en">Code for Francisella tularensis ss. tularensis</div>
	 */
	public static final String FRANCISELLA_TULARENSIS_SS_TULARENSIS_CODE = "91508008";

	/** <div class="en">Code for Haemophilus influenzae</div>. */
	public static final String HAEMOPHILUS_INFLUENZAE_CODE = "44470000";

	/** <div class="en">Code for Haemophilus influenzae, not B</div>. */
	public static final String HAEMOPHILUS_INFLUENZAE_NOT_B_CODE = "115407004";

	/** <div class="en">Code for Haemophilus influenzae type A</div>. */
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_A_CODE = "103441001";

	/** <div class="en">Code for Haemophilus influenzae type B</div>. */
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_B_CODE = "103442008";

	/** <div class="en">Code for Haemophilus influenzae type C</div>. */
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_C_CODE = "103443003";

	/** <div class="en">Code for Haemophilus influenzae type D</div>. */
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_D_CODE = "103444009";

	/** <div class="en">Code for Haemophilus influenzae type E</div>. */
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_E_CODE = "103445005";

	/** <div class="en">Code for Haemophilus influenzae type F</div>. */
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_F_CODE = "103446006";

	/** <div class="en">Code for Legionella bozemanii</div>. */
	public static final String LEGIONELLA_BOZEMANII_CODE = "37835001";

	/** <div class="en">Code for Legionella longbeachae</div>. */
	public static final String LEGIONELLA_LONGBEACHAE_CODE = "89605004";

	/** <div class="en">Code for Legionella longbeachae, serogroup 1</div>. */
	public static final String LEGIONELLA_LONGBEACHAE_SEROGROUP_1_CODE = "115515003";

	/** <div class="en">Code for Legionella longbeachae, serogroup 2</div>. */
	public static final String LEGIONELLA_LONGBEACHAE_SEROGROUP_2_CODE = "115516002";

	/** <div class="en">Code for Legionella pneumophila</div>. */
	public static final String LEGIONELLA_PNEUMOPHILA_CODE = "80897008";

	/** <div class="en">Code for Legionella pneumophila serogroup 1</div>. */
	public static final String LEGIONELLA_PNEUMOPHILA_SEROGROUP_1_CODE = "103463005";

	/** <div class="en">Code for Legionella pneumophila serogroup 4</div>. */
	public static final String LEGIONELLA_PNEUMOPHILA_SEROGROUP_4_CODE = "103466002";

	/** <div class="en">Code for Legionella pneumophila serogroup 6</div>. */
	public static final String LEGIONELLA_PNEUMOPHILA_SEROGROUP_6_CODE = "103468001";

	/**
	 * <div class="en">Code for Legionella pneumophila ss. pneumophila</div>
	 */
	public static final String LEGIONELLA_PNEUMOPHILA_SS_PNEUMOPHILA_CODE = "103458006";

	/** <div class="en">Code for Listeria</div>. */
	public static final String LISTERIA_CODE = "23566007";

	/** <div class="en">Code for Listeria monocytogenes</div>. */
	public static final String LISTERIA_MONOCYTOGENES_CODE = "36094007";

	/** <div class="en">Code for Mycobacterium africanum</div>. */
	public static final String MYCOBACTERIUM_AFRICANUM_CODE = "51320008";

	/** <div class="en">Code for Mycobacterium bovis</div>. */
	public static final String MYCOBACTERIUM_BOVIS_CODE = "27142009";

	/** <div class="en">Code for Mycobacterium caprae</div>. */
	public static final String MYCOBACTERIUM_CAPRAE_CODE = "430579009";

	/** <div class="en">Code for Mycobacterium tuberculosis</div>. */
	public static final String MYCOBACTERIUM_TUBERCULOSIS_CODE = "113861009";

	/** <div class="en">Code for Mycobacterium tuberculosis complex</div>. */
	public static final String MYCOBACTERIUM_TUBERCULOSIS_COMPLEX_CODE = "113858008";

	/** <div class="en">Code for Neisseria gonorrhoeae</div>. */
	public static final String NEISSERIA_GONORRHOEAE_CODE = "68704007";

	/** <div class="en">Code for Neisseria meningitidis</div>. */
	public static final String NEISSERIA_MENINGITIDIS_CODE = "17872004";

	/** <div class="en">Code for Neisseria meningitidis group A</div>. */
	public static final String NEISSERIA_MENINGITIDIS_GROUP_A_CODE = "103479006";

	/** <div class="en">Code for Neisseria meningitidis group B</div>. */
	public static final String NEISSERIA_MENINGITIDIS_GROUP_B_CODE = "103480009";

	/** <div class="en">Code for Neisseria meningitidis group C</div>. */
	public static final String NEISSERIA_MENINGITIDIS_GROUP_C_CODE = "103481008";

	/** <div class="en">Code for Neisseria meningitidis group X</div>. */
	public static final String NEISSERIA_MENINGITIDIS_GROUP_X_CODE = "125041003";

	/** <div class="en">Code for Neisseria meningitidis group Y</div>. */
	public static final String NEISSERIA_MENINGITIDIS_GROUP_Y_CODE = "103482001";

	/** <div class="en">Code for Neisseria meningitidis group Z</div>. */
	public static final String NEISSERIA_MENINGITIDIS_GROUP_Z_CODE = "125042005";

	/** <div class="en">Code for Neisseria meningitidis W135</div>. */
	public static final String NEISSERIA_MENINGITIDIS_W135_CODE = "103483006";

	/** <div class="en">Code for Salmonella</div>. */
	public static final String SALMONELLA_CODE = "27268008";

	/** <div class="en">Code for Salmonella enteritidis</div>. */
	public static final String SALMONELLA_ENTERITIDIS_CODE = "73525009";

	/** <div class="en">Code for Salmonella paratyphi A</div>. */
	public static final String SALMONELLA_PARATYPHI_A_CODE = "79128009";

	/** <div class="en">Code for Salmonella paratyphi B</div>. */
	public static final String SALMONELLA_PARATYPHI_B_CODE = "85908006";

	/** <div class="en">Code for Salmonella paratyphi C</div>. */
	public static final String SALMONELLA_PARATYPHI_C_CODE = "32488009";

	/** <div class="en">Code for Salmonella species</div>. */
	public static final String SALMONELLA_SPECIES_CODE = "372342007";

	/** <div class="en">Code for Salmonella typhi</div>. */
	public static final String SALMONELLA_TYPHI_CODE = "5595000";

	/** <div class="en">Code for Salmonella typhimurium</div>. */
	public static final String SALMONELLA_TYPHIMURIUM_CODE = "50136005";

	/** <div class="en">Code for Shigella boydii</div>. */
	public static final String SHIGELLA_BOYDII_CODE = "55462008";

	/** <div class="en">Code for Shigella dysenteriae</div>. */
	public static final String SHIGELLA_DYSENTERIAE_CODE = "43612004";

	/** <div class="en">Code for Shigella flexneri</div>. */
	public static final String SHIGELLA_FLEXNERI_CODE = "85729005";

	/** <div class="en">Code for Shigella sonnei</div>. */
	public static final String SHIGELLA_SONNEI_CODE = "4298009";

	/** <div class="en">Code for Shigella species</div>. */
	public static final String SHIGELLA_SPECIES_CODE = "116498009";

	/** <div class="en">Code for Streptococcus penumoniae 3</div>. */
	public static final String STREPTOCOCCUS_PENUMONIAE_3_CODE = "103497003";

	/** <div class="en">Code for Streptococcus penumoniae, serotype 29</div>. */
	public static final String STREPTOCOCCUS_PENUMONIAE_SEROTYPE_29_CODE = "131363003";

	/** <div class="en">Code for Streptococcus pneumoniae 14</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_14_CODE = "103498008";

	/** <div class="en">Code for Streptococcus pneumoniae 7F</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_7F_CODE = "103499000";

	/** <div class="en">Code for Streptococcus pneumoniae 9N</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_9N_CODE = "103500009";

	/** <div class="en">Code for Streptococcus pneumoniae</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_CODE = "9861002";

	/** <div class="en">Code for Streptococcus pneumoniae, serotype 11</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_11_CODE = "363768008";

	/** <div class="en">Code for Streptococcus pneumoniae, serotype 12</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_12_CODE = "116500005";

	/** <div class="en">Code for Streptococcus pneumoniae, serotype 16</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_16_CODE = "131362008";

	/** <div class="en">Code for Streptococcus pneumoniae, serotype 17</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_17_CODE = "131361001";

	/** <div class="en">Code for Streptococcus pneumoniae, serotype 19</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_19_CODE = "127541006";

	/** <div class="en">Code for Streptococcus pneumoniae, serotype 22</div>. */
	public static final String STREPTOCOCCUS_PNEUMONIAE_SEROTYPE_22_CODE = "363767003";

	/** <div class="en">Code for Vibrio cholerae</div>. */
	public static final String VIBRIO_CHOLERAE_CODE = "75953000";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 *
	 * @param code
	 *            the code (as present in this class with enumName_CODE)
	 * @return the according enum object
	 */
	public static LabObsListSnomed getEnum(String code) {
		for (final LabObsListSnomed x : values()) {
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
			Enum.valueOf(LabObsListSnomed.class, enumName);
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
		for (final LabObsListSnomed x : values()) {
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
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>.
	 */
	private String displayName;

	/**
	 * <div class="en">The Patient privacy filter is used to determine the
	 * anonymisation or pseudonymisation mode for the patient data.</div>
	 * <div class="de">Der Patient Privacy Filter wird verwendet, um die Art der
	 * Anonymisierung oder Pseudonymisierung der Patientendaten zu
	 * bestimmen</div>
	 */
	private String patientPrivacyFilter;

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
	 * displayName, specialitySectionCode, privacyFilter, validFrom and validTo
	 * parameters</div> <div class="de">Instantiiert dieses Enum Object mittels
	 * der code, displayName, specialitySectionCode, privacyFilter, validFrom
	 * und validTo Parameter</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="en">the code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="en">the display name</div>
	 * @param sectionCode
	 *            <br>
	 *            <div class="en">the specialty section code</div>
	 * @param patientPrivacyFilter
	 *            <br>
	 *            <div class="en">the patient privacy filter</div>
	 * @param validFrom
	 *            <br>
	 *            <div class="en">the valid from</div>
	 * @param validTo
	 *            <br>
	 *            <div class="en">the valid to</div>
	 */
	private LabObsListSnomed(String code, String displayName, String sectionCode,
			String patientPrivacyFilter, String validFrom, String validTo) {
		this.code = code;
		this.displayName = displayName;
		this.sectionCode = sectionCode;
		this.patientPrivacyFilter = patientPrivacyFilter;
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
		return CODE_SYSTEM_OID;
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
	 * <div class="en">Gets the patient privacy filter</div>
	 * <div class="de">Liefert patient privacy filter</div>.
	 *
	 * @return the patient privacy filter
	 */
	public String getPatientPrivacyFilter() {
		return this.patientPrivacyFilter;
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