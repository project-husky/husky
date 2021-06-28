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
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum SwissVaccinationPlanExposureRisks implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BESCHAEFTIGTE_IM_GESUNDHEITSWESEN</div>
	 * <!-- @formatter:on -->
	 */
	BESCHAEFTIGTE_IM_GESUNDHEITSWESEN("213001", "2.16.756.5.30.1.127.3.3.2",
			"BESCHAEFTIGTE_IM_GESUNDHEITSWESEN", "BESCHAEFTIGTE_IM_GESUNDHEITSWESEN", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ENGE_KONTAKTPERSONEN_VON_MENINGOKOKKEN_ERKRANKTEN</div>
	 * <!-- @formatter:on -->
	 */
	ENGE_KONTAKTPERSONEN_VON_MENINGOKOKKEN_ERKRANKTEN("213028", "2.16.756.5.30.1.127.3.3.2",
			"ENGE_KONTAKTPERSONEN_VON_MENINGOKOKKEN_ERKRANKTEN",
			"ENGE_KONTAKTPERSONEN_VON_MENINGOKOKKEN_ERKRANKTEN", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIET_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN</div>
	 * <!-- @formatter:on -->
	 */
	ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIET_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN(
			"213003", "2.16.756.5.30.1.127.3.3.2",
			"ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIET_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN",
			"ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIET_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FAMILIENANGEHOERIGE_VON_PERSONEN_MIT_EINEM_ERHOEHTEN_RISIKO</div>
	 * <!-- @formatter:on -->
	 */
	FAMILIENANGEHOERIGE_VON_PERSONEN_MIT_EINEM_ERHOEHTEN_RISIKO("213005",
			"2.16.756.5.30.1.127.3.3.2",
			"FAMILIENANGEHOERIGE_VON_PERSONEN_MIT_EINEM_ERHOEHTEN_RISIKO",
			"FAMILIENANGEHOERIGE_VON_PERSONEN_MIT_EINEM_ERHOEHTEN_RISIKO", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FLEDERMAUSFORSCHER_UND_SCHUETZER</div>
	 * <!-- @formatter:on -->
	 */
	FLEDERMAUSFORSCHER_UND_SCHUETZER("213006", "2.16.756.5.30.1.127.3.3.2",
			"FLEDERMAUSFORSCHER_UND_SCHUETZER", "FLEDERMAUSFORSCHER_UND_SCHUETZER", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN</div>
	 * <!-- @formatter:on -->
	 */
	GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN("213007",
			"2.16.756.5.30.1.127.3.3.2",
			"GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN",
			"GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLAERANLAGEN</div>
	 * <!-- @formatter:on -->
	 */
	KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLAERANLAGEN("213010", "2.16.756.5.30.1.127.3.3.2",
			"KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLAERANLAGEN",
			"KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLAERANLAGEN", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">KINDERKRIPPE_HORT_VOR_5_MONATEN</div>
	 * <!-- @formatter:on -->
	 */
	KINDERKRIPPE_HORT_VOR_5_MONATEN("213031", "2.16.756.5.30.1.127.3.3.2",
			"KINDERKRIPPE_HORT_VOR_5_MONATEN", "KINDERKRIPPE_HORT_VOR_5_MONATEN", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">KINDER_AUS_LAENDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITAET_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FUER_EINEN_VORUEBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURUECKKEHREN</div>
	 * <!-- @formatter:on -->
	 */
	KINDER_AUS_LAENDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITAET_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FUER_EINEN_VORUEBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURUECKKEHREN(
			"213011", "2.16.756.5.30.1.127.3.3.2",
			"KINDER_AUS_LAENDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITAET_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FUER_EINEN_VORUEBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURUECKKEHREN",
			"KINDER_AUS_LAENDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITAET_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FUER_EINEN_VORUEBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURUECKKEHREN",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN</div>
	 * <!-- @formatter:on -->
	 */
	KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN("213012",
			"2.16.756.5.30.1.127.3.3.2",
			"KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN",
			"KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">KONTAKTPERSONEN_VON_EINER_SCHWANGEREN_FRAU</div>
	 * <!-- @formatter:on -->
	 */
	KONTAKTPERSONEN_VON_EINER_SCHWANGEREN_FRAU("213032", "2.16.756.5.30.1.127.3.3.2",
			"KONTAKTPERSONEN_VON_EINER_SCHWANGEREN_FRAU",
			"KONTAKTPERSONEN_VON_EINER_SCHWANGEREN_FRAU", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">KONTAKTPERSONEN_VON_HEPATITIS_A_ERKRANKTEN</div>
	 * <!-- @formatter:on -->
	 */
	KONTAKTPERSONEN_VON_HEPATITIS_A_ERKRANKTEN("213027", "2.16.756.5.30.1.127.3.3.2",
			"KONTAKTPERSONEN_VON_HEPATITIS_A_ERKRANKTEN",
			"KONTAKTPERSONEN_VON_HEPATITIS_A_ERKRANKTEN", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">KONTAKTPERSONEN_VON_HEPATITIS_B_ERKRANKTEN</div>
	 * <!-- @formatter:on -->
	 */
	KONTAKTPERSONEN_VON_HEPATITIS_B_ERKRANKTEN("213026", "2.16.756.5.30.1.127.3.3.2",
			"KONTAKTPERSONEN_VON_HEPATITIS_B_ERKRANKTEN",
			"KONTAKTPERSONEN_VON_HEPATITIS_B_ERKRANKTEN", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">LABORPERSONAL_MIT_BAKTERIEN_EXPOSITIONSRISIKO</div>
	 * <!-- @formatter:on -->
	 */
	LABORPERSONAL_MIT_BAKTERIEN_EXPOSITIONSRISIKO("213030", "2.16.756.5.30.1.127.3.3.2",
			"LABORPERSONAL_MIT_BAKTERIEN_EXPOSITIONSRISIKO",
			"LABORPERSONAL_MIT_BAKTERIEN_EXPOSITIONSRISIKO", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">LABORPERSONAL_MIT_VIRUS_EXPOSITIONSRISIKO</div>
	 * <!-- @formatter:on -->
	 */
	LABORPERSONAL_MIT_VIRUS_EXPOSITIONSRISIKO("213029", "2.16.756.5.30.1.127.3.3.2",
			"LABORPERSONAL_MIT_VIRUS_EXPOSITIONSRISIKO",
			"LABORPERSONAL_MIT_VIRUS_EXPOSITIONSRISIKO", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MAENNER_DIE_MIT_MAENNERN_GESCHLECHTSVERKEHR_HABEN</div>
	 * <!-- @formatter:on -->
	 */
	MAENNER_DIE_MIT_MAENNERN_GESCHLECHTSVERKEHR_HABEN("213014", "2.16.756.5.30.1.127.3.3.2",
			"MAENNER_DIE_MIT_MAENNERN_GESCHLECHTSVERKEHR_HABEN",
			"MAENNER_DIE_MIT_MAENNERN_GESCHLECHTSVERKEHR_HABEN", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MITARBEITENDE_VON_KINDERKRIPPEN</div>
	 * <!-- @formatter:on -->
	 */
	MITARBEITENDE_VON_KINDERKRIPPEN("213033", "2.16.756.5.30.1.127.3.3.2",
			"MITARBEITENDE_VON_KINDERKRIPPEN", "MITARBEITENDE_VON_KINDERKRIPPEN", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">NEUGEBORENE_UND_SAEUGLINGE_UNTER_12_MONATEN_AUS_LAENDERN_MIT_HOHER_TUBERKULOSE_PRAEVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURUECKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR</div>
	 * <!-- @formatter:on -->
	 */
	NEUGEBORENE_UND_SAEUGLINGE_UNTER_12_MONATEN_AUS_LAENDERN_MIT_HOHER_TUBERKULOSE_PRAEVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURUECKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR(
			"213024", "2.16.756.5.30.1.127.3.3.2",
			"NEUGEBORENE_UND_SAEUGLINGE_UNTER_12_MONATEN_AUS_LAENDERN_MIT_HOHER_TUBERKULOSE_PRAEVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURUECKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR",
			"NEUGEBORENE_UND_SAEUGLINGE_UNTER_12_MONATEN_AUS_LAENDERN_MIT_HOHER_TUBERKULOSE_PRAEVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURUECKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">NEUGEBORENE_VON_HBSAG_POSITIVEN_MUETTERN</div>
	 * <!-- @formatter:on -->
	 */
	NEUGEBORENE_VON_HBSAG_POSITIVEN_MUETTERN("213025", "2.16.756.5.30.1.127.3.3.2",
			"NEUGEBORENE_VON_HBSAG_POSITIVEN_MUETTERN", "NEUGEBORENE_VON_HBSAG_POSITIVEN_MUETTERN",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FUER_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN</div>
	 * <!-- @formatter:on -->
	 */
	PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FUER_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN(
			"213015", "2.16.756.5.30.1.127.3.3.2",
			"PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FUER_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN",
			"PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FUER_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PERSONEN_AUS_LAENDERN_MIT_HOHER_ODER_INTERMEDIAERER_HEPATITIS_B_ENDEMIZITAET</div>
	 * <!-- @formatter:on -->
	 */
	PERSONEN_AUS_LAENDERN_MIT_HOHER_ODER_INTERMEDIAERER_HEPATITIS_B_ENDEMIZITAET("213016",
			"2.16.756.5.30.1.127.3.3.2",
			"PERSONEN_AUS_LAENDERN_MIT_HOHER_ODER_INTERMEDIAERER_HEPATITIS_B_ENDEMIZITAET",
			"PERSONEN_AUS_LAENDERN_MIT_HOHER_ODER_INTERMEDIAERER_HEPATITIS_B_ENDEMIZITAET",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PERSONEN_MIT_EINER_SEXUELL_UEBERTRAGBAREN_KRANKHEIT</div>
	 * <!-- @formatter:on -->
	 */
	PERSONEN_MIT_EINER_SEXUELL_UEBERTRAGBAREN_KRANKHEIT("213017", "2.16.756.5.30.1.127.3.3.2",
			"PERSONEN_MIT_EINER_SEXUELL_UEBERTRAGBAREN_KRANKHEIT",
			"PERSONEN_MIT_EINER_SEXUELL_UEBERTRAGBAREN_KRANKHEIT", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LAENDERN_MIT_HOHER_ENDEMIZITAET</div>
	 * <!-- @formatter:on -->
	 */
	PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LAENDERN_MIT_HOHER_ENDEMIZITAET("213018",
			"2.16.756.5.30.1.127.3.3.2",
			"PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LAENDERN_MIT_HOHER_ENDEMIZITAET",
			"PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LAENDERN_MIT_HOHER_ENDEMIZITAET",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PERSONEN_MIT_HAEUFIG_WECHSELNDEN_SEXUALPARTNERN</div>
	 * <!-- @formatter:on -->
	 */
	PERSONEN_MIT_HAEUFIG_WECHSELNDEN_SEXUALPARTNERN("213019", "2.16.756.5.30.1.127.3.3.2",
			"PERSONEN_MIT_HAEUFIG_WECHSELNDEN_SEXUALPARTNERN",
			"PERSONEN_MIT_HAEUFIG_WECHSELNDEN_SEXUALPARTNERN", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PERSONEN_MIT_REGELMAESSIGEM_KONTAKT_BERUFLICH_ODER_FAMILIAER_ZU_SAEUGLINGEN_UNTER_6_MONATEN_ODER_SCHWANGERE_FRAUEN</div>
	 * <!-- @formatter:on -->
	 */
	PERSONEN_MIT_REGELMAESSIGEM_KONTAKT_BERUFLICH_ODER_FAMILIAER_ZU_SAEUGLINGEN_UNTER_6_MONATEN_ODER_SCHWANGERE_FRAUEN(
			"213020", "2.16.756.5.30.1.127.3.3.2",
			"PERSONEN_MIT_REGELMAESSIGEM_KONTAKT_BERUFLICH_ODER_FAMILIAER_ZU_SAEUGLINGEN_UNTER_6_MONATEN_ODER_SCHWANGERE_FRAUEN",
			"PERSONEN_MIT_REGELMAESSIGEM_KONTAKT_BERUFLICH_ODER_FAMILIAER_ZU_SAEUGLINGEN_UNTER_6_MONATEN_ODER_SCHWANGERE_FRAUEN",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">REKRUTEN_MILITAER</div>
	 * <!-- @formatter:on -->
	 */
	REKRUTEN_MILITAER("213021", "2.16.756.5.30.1.127.3.3.2", "REKRUTEN_MILITAER",
			"REKRUTEN_MILITAER", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SOZIALARBEITER_GEFAENGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HAEUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN</div>
	 * <!-- @formatter:on -->
	 */
	SOZIALARBEITER_GEFAENGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HAEUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN(
			"213022", "2.16.756.5.30.1.127.3.3.2",
			"SOZIALARBEITER_GEFAENGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HAEUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN",
			"SOZIALARBEITER_GEFAENGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HAEUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TIERAERZTE_INKL_STUDENTEN_PRAXISANGESTELLTE</div>
	 * <!-- @formatter:on -->
	 */
	TIERAERZTE_INKL_STUDENTEN_PRAXISANGESTELLTE("213023", "2.16.756.5.30.1.127.3.3.2",
			"TIERAERZTE_INKL_STUDENTEN_PRAXISANGESTELLTE",
			"TIERAERZTE_INKL_STUDENTEN_PRAXISANGESTELLTE", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BESCHAEFTIGTE_IM_GESUNDHEITSWESEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BESCHAEFTIGTE_IM_GESUNDHEITSWESEN_CODE = "213001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ENGE_KONTAKTPERSONEN_VON_MENINGOKOKKEN_ERKRANKTEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGE_KONTAKTPERSONEN_VON_MENINGOKOKKEN_ERKRANKTEN_CODE = "213028";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIET_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ERWACHSENE_UND_KINDER_AB_6_JAHREN_DIE_IN_ENDEMIEGEBIET_WOHNEN_ODER_SICH_TEILWEISE_DORT_AUFHALTEN_CODE = "213003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FAMILIENANGEHOERIGE_VON_PERSONEN_MIT_EINEM_ERHOEHTEN_RISIKO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FAMILIENANGEHOERIGE_VON_PERSONEN_MIT_EINEM_ERHOEHTEN_RISIKO_CODE = "213005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FLEDERMAUSFORSCHER_UND_SCHUETZER</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FLEDERMAUSFORSCHER_UND_SCHUETZER_CODE = "213006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GEISTIG_BEHINDERTE_PERSONEN_IN_HEIMEN_UND_DEREN_BETREUERINNEN_CODE = "213007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLAERANLAGEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KANALISATIONSARBEITER_UND_ANGESTELLTE_VON_KLAERANLAGEN_CODE = "213010";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for KINDERKRIPPE_HORT_VOR_5_MONATEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KINDERKRIPPE_HORT_VOR_5_MONATEN_CODE = "213031";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for KINDER_AUS_LAENDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITAET_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FUER_EINEN_VORUEBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURUECKKEHREN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KINDER_AUS_LAENDERN_MIT_MITTLERER_UND_HOHER_ENDEMIZITAET_DIE_IN_DER_SCHWEIZ_LEBEN_UND_FUER_EINEN_VORUEBERGEHENDEN_AUFENTHALT_IN_IHR_HERKUNFTSLAND_ZURUECKKEHREN_CODE = "213011";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN_CODE = "213012";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for KONTAKTPERSONEN_VON_EINER_SCHWANGEREN_FRAU</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KONTAKTPERSONEN_VON_EINER_SCHWANGEREN_FRAU_CODE = "213032";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for KONTAKTPERSONEN_VON_HEPATITIS_A_ERKRANKTEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KONTAKTPERSONEN_VON_HEPATITIS_A_ERKRANKTEN_CODE = "213027";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for KONTAKTPERSONEN_VON_HEPATITIS_B_ERKRANKTEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KONTAKTPERSONEN_VON_HEPATITIS_B_ERKRANKTEN_CODE = "213026";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for LABORPERSONAL_MIT_BAKTERIEN_EXPOSITIONSRISIKO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABORPERSONAL_MIT_BAKTERIEN_EXPOSITIONSRISIKO_CODE = "213030";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for LABORPERSONAL_MIT_VIRUS_EXPOSITIONSRISIKO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABORPERSONAL_MIT_VIRUS_EXPOSITIONSRISIKO_CODE = "213029";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MAENNER_DIE_MIT_MAENNERN_GESCHLECHTSVERKEHR_HABEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MAENNER_DIE_MIT_MAENNERN_GESCHLECHTSVERKEHR_HABEN_CODE = "213014";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MITARBEITENDE_VON_KINDERKRIPPEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MITARBEITENDE_VON_KINDERKRIPPEN_CODE = "213033";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for NEUGEBORENE_UND_SAEUGLINGE_UNTER_12_MONATEN_AUS_LAENDERN_MIT_HOHER_TUBERKULOSE_PRAEVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURUECKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUGEBORENE_UND_SAEUGLINGE_UNTER_12_MONATEN_AUS_LAENDERN_MIT_HOHER_TUBERKULOSE_PRAEVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURUECKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR_CODE = "213024";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for NEUGEBORENE_VON_HBSAG_POSITIVEN_MUETTERN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUGEBORENE_VON_HBSAG_POSITIVEN_MUETTERN_CODE = "213025";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FUER_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATIENTINNEN_UND_PATIENTEN_IN_PFLEGEHEIMEN_UND_IN_EINRICHTUNGEN_FUER_PERSONEN_MIT_CHRONISCHEN_ERKRANKUNGEN_CODE = "213015";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PERSONEN_AUS_LAENDERN_MIT_HOHER_ODER_INTERMEDIAERER_HEPATITIS_B_ENDEMIZITAET</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERSONEN_AUS_LAENDERN_MIT_HOHER_ODER_INTERMEDIAERER_HEPATITIS_B_ENDEMIZITAET_CODE = "213016";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PERSONEN_MIT_EINER_SEXUELL_UEBERTRAGBAREN_KRANKHEIT</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERSONEN_MIT_EINER_SEXUELL_UEBERTRAGBAREN_KRANKHEIT_CODE = "213017";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LAENDERN_MIT_HOHER_ENDEMIZITAET</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERSONEN_MIT_ENGEM_KONTAKT_ZU_PERSONEN_AUS_LAENDERN_MIT_HOHER_ENDEMIZITAET_CODE = "213018";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PERSONEN_MIT_HAEUFIG_WECHSELNDEN_SEXUALPARTNERN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERSONEN_MIT_HAEUFIG_WECHSELNDEN_SEXUALPARTNERN_CODE = "213019";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PERSONEN_MIT_REGELMAESSIGEM_KONTAKT_BERUFLICH_ODER_FAMILIAER_ZU_SAEUGLINGEN_UNTER_6_MONATEN_ODER_SCHWANGERE_FRAUEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERSONEN_MIT_REGELMAESSIGEM_KONTAKT_BERUFLICH_ODER_FAMILIAER_ZU_SAEUGLINGEN_UNTER_6_MONATEN_ODER_SCHWANGERE_FRAUEN_CODE = "213020";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for REKRUTEN_MILITAER</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REKRUTEN_MILITAER_CODE = "213021";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SOZIALARBEITER_GEFAENGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HAEUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOZIALARBEITER_GEFAENGNISPERSONAL_UND_POLIZEIANGESTELLTE_MIT_HAEUFIGEM_KONTAKT_ZU_KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_CODE = "213022";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TIERAERZTE_INKL_STUDENTEN_PRAXISANGESTELLTE</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TIERAERZTE_INKL_STUDENTEN_PRAXISANGESTELLTE_CODE = "213023";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.73";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "SwissVaccinationPlanExposureRisks";

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
	public static SwissVaccinationPlanExposureRisks getEnum(String code) {
		for (final SwissVaccinationPlanExposureRisks x : values()) {
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
			Enum.valueOf(SwissVaccinationPlanExposureRisks.class, enumName);
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
		for (final SwissVaccinationPlanExposureRisks x : values()) {
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
	SwissVaccinationPlanExposureRisks(String code, String codeSystem, String displayName,
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
