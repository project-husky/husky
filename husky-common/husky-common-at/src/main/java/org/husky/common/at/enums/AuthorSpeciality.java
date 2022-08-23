/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.common.at.enums;

import org.husky.common.model.Code;

/**
 * <div class="de">Dieses Attribut ist ein beschreibendes Sub-Attribut von
 * author und dient der Beschreibung der Medizinischen Fachrichtung der Person,
 * welche ein Dokument verfasst hat. Diese Information kann für die Suche und
 * Filterung benutzt werden. Es ist denkbar, dass der Patient mit dieser
 * Information eine Hilfestellung erhält zum Setzen oder Verändern der
 * Vertraulichkeitsstufe von Dokumenten, welche relevant ist für die
 * Zugriffssteuerung. Passende internationale Codes werden in einem nächsten
 * Schritt definiert und können später in den IT-Systemen entsprechend
 * abgeglichen werden.</div> <div class="fr"></div>
 */
public enum AuthorSpeciality implements ValueSetEnumInterfaceAt {

	ARZT_FUR_ALLGEMEINE_MEDIZIN("100", "Ärztin/Arzt für Allgemeinmedizin"),

	APPROBIERTE_ARTZIN_ARZT("101", "Approbierte Ärztin/Approbierter Arzt"),

	FACHARZTINFACHARZT_FUR_ANASTHESIOLOGIE("102",
			"Fachärztin/Facharzt für Anästhesiologie und Intensivmedizin"),

	FACHARZTINFACHARZT_FUR_ANATOMIE("103", "Fachärztin/Facharzt für Anatomie"),

	FACHARZTINFACHARZT_FUR_ARBEITSMEDIZIN("104", "Fachärztin/Facharzt für Arbeitsmedizin"),

	FACHARZTINFACHARZT_FUR_AUGENHEILKUNDE("105",
			"Fachärztin/Facharzt für Augenheilkunde und Optometrie"),

	FACHARZTINFACHARZT_FUR_BLUTGRUPPENSEROLOGIE("106",
			"Fachärztin/Facharzt für Blutgruppenserologie und Transfusionsmedizin"),

	FACHARZTINFACHARZT_FUR_CHIRURGIE("107", "Fachärztin/Facharzt für Chirurgie"),

	FACHARZTINFACHARZT_FUR_FRAUENHEILKUNDE("108",
			"Fachärztin/Facharzt für Frauenheilkunde und Geburtshilfe"),

	FACHARZTINFACHARZT_FUR_GERICHTSMEDIZIN("109", "Fachärztin/Facharzt für Gerichtsmedizin"),

	FACHARZTINFACHARZT_FUR_HNO("110", "Fachärztin/Facharzt für Hals-, Nasen- und Ohrenkrankheiten"),

	FACHARZTINFACHARZT_FUR_HAUT("111", "Fachärztin/Facharzt für Haut- und Geschlechtskrankheiten"),

	FACHARZTINFACHARZT_FUR_HERZCHIRURGIE("112", "Fachärztin/Facharzt für Herzchirurgie"),

	FACHARZTINFACHARZT_FUR_HISTOLOGIE("113", "Fachärztin/Facharzt für Histologie und Embryologie"),

	FACHARZTINFACHARZT_FUR_HYGIENE_MIKROBIOLOGIE("114",
			"Fachärztin/Facharzt für Hygiene und Mikrobiologie"),

	FACHARZTINFACHARZT_FUR_IMMUNOLOGIE("115", "Fachärztin/Facharzt für Immunologie"),

	FACHARZTINFACHARZT_FUR_INNERE_MEDIZIN("116", "Fachärztin/Facharzt für Innere Medizin"),

	FACHARZTINFACHARZT_FUR_KINDER_UND_JUGENDCHIRURGIE("117",
			"Fachärztin/Facharzt für Kinder- und Jugendchirurgie"),

	FACHARZTINFACHARZT_FUR_KINDER_UND_JUGENDHEILKUNDE("118",
			"Fachärztin/Facharzt für Kinder- und Jugendheilkunde"),

	FACHARZTINFACHARZT_FUR_KINDER_UND_JUGENDPSYCHIATRIE("119",
			"Fachärztin/Facharzt für Kinder- und Jugendpsychiatrie"),

	FACHARZTINFACHARZT_FUR_LUNGENKRANKHEITEN("120", "Fachärztin/Facharzt für Lungenkrankheiten"),

	FACHARZTINFACHARZT_FUR_MEDIZINISCHE_BIOLOGIE("121",
			"Fachärztin/Facharzt für Medizinische Biologie"),

	FACHARZTINFACHARZT_FUR_MEDIZINISCHE_BIOPHYSIK("122",
			"Fachärztin/Facharzt für Medizinische Biophysik"),

	FACHARZTINFACHARZT_FUR_MEDIZINISCHE_GENETIK("123",
			"Fachärztin/Facharzt für Medizinische Genetik"),

	FACHARZTINFACHARZT_FUR_MEDIZINISCHE_UND_CHEMISCHE_LABORDIAGNOSTIK("124",
			"Fachärztin/Facharzt für Medizinische und Chemische Labordiagnostik"),

	FACHARZTINFACHARZT_FUR_MEDIZINISCHE_LEISTUNGSPHYSIOLOGIE("125",
			"Fachärztin/Facharzt für Medizinische Leistungsphysiologie"),

	FACHARZTINFACHARZT_FUR_MIKROBIOLOGISCH_SEROLOGISCHE_LABORDIAGNOSTIK("126",
			"Fachärztin/Facharzt für Mikrobiologisch-Serologische Labordiagnostik"),

	FACHARZTINFACHARZT_FUR_MUND_KIEFER_UND_GESICHTSCHIRURGIE("127",
			"Fachärztin/Facharzt für Mund-, Kiefer- und Gesichtschirurgie"),

	FACHARZTINFACHARZT_FUR_NEUROBIOLOGIE("128", "Fachärztin/Facharzt für Neurobiologie"),

	FACHARZTINFACHARZT_FUR_NEUROCHIRURGIE("129", "Fachärztin/Facharzt für Neurochirurgie"),

	FACHARZTINFACHARZT_FUR_NEUROLOGIE("130", "Fachärztin/Facharzt für Neurologie"),

	FACHARZTINFACHARZT_FUR_NEUROLOGIE_PSYCHIATRIE("131",
			"Fachärztin/Facharzt für Neurologie und Psychiatrie"),

	FACHARZTINFACHARZT_FUR_NEUROPATHOLOGIE("132", "Fachärztin/Facharzt für Neuropathologie"),

	FACHARZTINFACHARZT_FUR_NUKLEARMEDIZIN("133", "Fachärztin/Facharzt für Nuklearmedizin"),

	FACHARZTINFACHARZT_FUR_ORTHOPAEDIE_ORTHOPADISCHE_CHIRURGIE("134",
			"Fachärztin/Facharzt für Orthopädie und Orthopädische Chirurgie"),

	FACHARZTINFACHARZT_FUR_PATHOLOGIE("135", "Fachärztin/Facharzt für Pathologie"),

	FACHARZTINFACHARZT_FUR_PATHOPHYSIOLOGIE("136", "Fachärztin/Facharzt für Pathophysiologie"),

	FACHARZTINFACHARZT_FUR_PHARMAKOLOGIE_TOXIKOLOGIE("137",
			"Fachärztin/Facharzt für Pharmakologie und Toxikologie"),

	FACHARZTINFACHARZT_FUR_PHYSIKALISCHE_MEDIZIN_UND_REHABILIATION("138",
			"Fachärztin/Facharzt für Physikalische Medizin und Allgemeine Rehabilitation"),

	FACHARZTINFACHARZT_FUR_PHYSIOLOGIE("139", "Fachärztin/Facharzt für Physiologie"),

	FACHARZTINFACHARZT_FUR_PLASTISCHE_ASTHETISCHE_UND_REKONSTRUKTIVE_CHIRURGIE("140",
			"Fachärztin/Facharzt für Plastische, Ästhetische und Rekonstruktive Chirurgie"),

	FACHARZTINFACHARZT_FUR_PSYCHIATRIE("141", "Fachärztin/Facharzt für Psychiatrie"),

	FACHARZTINFACHARZT_FUR_PSYCHIATRIE_NEUROLOGIE("142",
			"Fachärztin/Facharzt für Psychiatrie und Neurologie"),

	FACHARZTINFACHARZT_FUR_PSYCHIATRIE_PSYCHOTHERAPIE("143",
			"Fachärztin/Facharzt für Psychiatrie und Psychotherapeutische Medizin"),

	FACHARZTINFACHARZT_FUR_RADIOLOGIE("144", "Fachärztin/Facharzt für Radiologie"),

	FACHARZTINFACHARZT_FUR_SOZIALMEDIZIN("145", "Fachärztin/Facharzt für Sozialmedizin"),

	FACHARZTINFACHARZT_FUR_PROPHYLAXE_TROPENMEDIZIN("146",
			"Fachärztin/Facharzt für Spezifische Prophylaxe und Tropenmedizin"),

	FACHARZTINFACHARZT_FUR_STRAHLENTHERAPIE_RADIOONKOLOGIE("147",
			"Fachärztin/Facharzt für Strahlentherapie-Radioonkologie"),

	FACHARZTINFACHARZT_FUR_THEORETISCHE_SONDERFAECHER("148",
			"Fachärztin/Facharzt für Theoretische Sonderfächer"),

	FACHARZTINFACHARZT_FUR_THORAXCHIRURGIE("149", "Fachärztin/Facharzt für Thoraxchirurgie"),

	FACHARZTINFACHARZT_FUR_TUMORBIOLOGIE("150", "Fachärztin/Facharzt für Tumorbiologie"),

	FACHARZTINFACHARZT_FUR_UNFALLCHIRURGIE("151", "Fachärztin/Facharzt für Unfallchirurgie"),

	FACHARZTINFACHARZT_FUR_UROLOGIE("152", "Fachärztin/Facharzt für Urologie"),

	FACHARZTINFACHARZT_FUR_VIROLOGIE("153", "Fachärztin/Facharzt für Virologie"),

	FACHARZTINFACHARZT_FUR_ZAHN_MUND_KIEFERHEILKUNDE("154",
			"Fachärztin/Facharzt für Zahn-, Mund- und Kieferheilkunde"),

	FACHARZTINFACHARZT("158", "Fachärztin/Facharzt"),

	ZAHNARZTINZAHNARZT("155", "Zahnärztin/Zahnarzt"),

	DENTIST("156", "Dentistin/Dentist"),

	PHYSIOTHERAPEUTINPHYSIOTHERAPEUT("200", "Psychotherapeutin/Psychotherapeut"),

	KLINISCHER_PSYCHOLOGEKLINISCHE_PSYCHOLOGIN("201",
			"Klinische Psychologin/Klinischer Psychologe"),

	GESUNDHEITSPSYCHOLOGINGESUNDHEITSPSYCHOLOGE("202",
			"Gesundheitspsychologin/Gesundheitspsychologe"),

	MUSIKTHERAPEUTINMUSIKTHERAPEUT("203", "Musiktherapeutin/Musiktherapeut"),

	HEBAMME("204", "Hebamme"),

	PHYSIOTHERAPEUT("205", "Physiotherapeutin/Physiotherapeut"),

	BIOMEDIZINISCHE_ANALYTIKERINBIOMEDIZINISCHER_ANALYTIKER("206",
			"Biomedizinische Analytikerin/Biomedizinischer Analytiker"),

	RADIOLOGIETECHNOLOGINRADIOLOGIETECHNOLOGE("207", "Radiologietechnologin/Radiologietechnologe"),

	DIATOLOGINDIATOLOGE("208", "Diätologin/Diätologe"),

	ERGOTHERAPEUTINERGOTHERAPEUT("209", "Ergotherapeutin/Ergotherapeut"),

	LOGOPADINLOGOPADE("210", "Logopädin/Logopäde"),

	ORTHOPTISTINORTHOPTIST("211", "Orthoptistin/Orthoptist"),

	DIPLOMIERTE_GESUNDHEITS_KRANKEN_SCHWESTER_PFLEGER("212",
			"Diplomierte Gesundheits- und Krankenschwester/Diplomierter Gesundheits- und Krankenpfleger"),

	DIPLOMIERTE_KINDER_KRANKEN_SCHWESTER_PFLEGER("213",
			"Diplomierte Kinderkrankenschwester/Diplomierter Kinderkrankenpfleger"),

	DIPLOMIERTE_PSYCHIATRISCHE_GESUNDHEITS_KRANKEN_SCHWESTER_PFLEGER("214",
			"Diplomierte psychiatrische Gesundheits- und Krankenschwester/Diplomierter psychiatrischer Gesundheits- und Krankenpfleger"),

	HEILMASSEURINHEILMASSEUR("215", "Heilmasseurin/Heilmasseur"),

	DIPLOMIERTE_KARDIOTECHNIKERINKARDIOTECHNIKER("216",
			"Diplomierte Kardiotechnikerin/Diplomierter Kardiotechniker"),

	ALLGEMEINEKRANKENANSTALT("300", "Allgemeine Krankenanstalt"),

	SONDERKRANKENANSTALT("301", "Sonderkrankenanstalt"),

	PFLEGEANSTALT("302", "Pflegeanstalt"),

	SANATORIUM("303", "Sanatorium"),

	SELBSTSTAENDIGES_AMBULATORIUM("304", "Selbstständiges Ambulatorium"),

	PFLEGEEINRICHTUNG("305", "Pflegeeinrichtung"),

	MOBILE_PFLEGE("306", "Mobile Pflege"),

	KURANSTALT("307", "Kuranstalt"),

	STRAF_MASSNAHMENVOLLZUG("309", "Straf- und Maßnahmenvollzug"),

	UNTERSUCHUNGSANSTALT("310", "Untersuchungsanstalt"),

	OEFFENTLICHE_APOTHEKE("311", "Öffentliche Apotheke"),

	GEWEBEBANK("312", "Gewebebank"),

	BLUTSPENDEEINRICHTUNG("313", "Blutspendeeinrichtung"),

	AUGEN_KONTAKTLINSENOPTIK("314", "Augen- und Kontaktlinsenoptik"),

	HOERGERAETAKUSTIK("315", "Hörgeräteakustik"),

	ORTHOPAEDISCHE_PRODUKTE("316", "Orthopädische Produkte"),

	ZAHNTECHNIK("317", "Zahntechnik"),

	RETTUNGSDIENST("318", "Rettungsdienst"),

	ZAHNAERZTLICHE_GRUPPENPRAXIS("319", "Zahnärztliche Gruppenpraxis"),

	AERZTLICHE_GRUPPENPRAXIS("320", "Ärztliche Gruppenpraxis"),

	GEWEBEENTNAHMEEINRICHTUNG("321", "Gewebeentnahmeeinrichtung"),

	ARBEITSMEDIZINISCHESZENTRUM("322", "Arbeitsmedizinisches Zentrum"),

	GESUNDHEITSMANAGEMENT("400", "Gesundheitsmanagement"),

	OEFFENTLICHER_GESUNDHEITSDIENST("401", "Öffentlicher Gesundheitsdienst"),

	ELGA_OMBUDSSTELLE("403", "ELGA-Ombudsstelle"),

	WIDERSRPUCHSSTELLE("404", "Widerspruchstelle"),

	PATIENTENVERTRETUNG("405", "Patientenvertretung"),

	SOZIALVERSICHERUNG("406", "Sozialversicherung"),

	KRANKENFUERSORGE("407", "Krankenfürsorge"),

	GESUNDHEITSVERSORGUNG("408", "Gesundheitsversicherung"),

	IKT_GESUNDHEITSSERVICE("500", "IKT-Gesundheitsservice"),

	VERRECHNUNGSSERVICE("501", "Verrechnungsservice");

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "ELGA_AuthorSpeciality";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "1.2.40.0.34.5.2";

	public static final String ARZT_FUR_ALLGEMEINE_MEDIZIN_CODE = "100";

	public static final String APPROBIERTE_ARTZIN_ARZT_CODE = "101";

	public static final String FACHARZTINFACHARZT_FUR_ANASTHESIOLOGIE_CODE = "102";

	public static final String FACHARZTINFACHARZT_FUR_ANATOMIE_CODE = "103";

	public static final String FACHARZTINFACHARZT_FUR_ARBEITSMEDIZIN_CODE = "104";

	public static final String FACHARZTINFACHARZT_FUR_AUGENHEILKUNDE_CODE = "105";

	public static final String FACHARZTINFACHARZT_FUR_BLUTGRUPPENSEROLOGIE_CODE = "106";

	public static final String FACHARZTINFACHARZT_FUR_CHIRURGIE_CODE = "107";

	public static final String FACHARZTINFACHARZT_FUR_FRAUENHEILKUNDE_CODE = "108";

	public static final String FACHARZTINFACHARZT_FUR_GERICHTSMEDIZIN_CODE = "109";

	public static final String FACHARZTINFACHARZT_FUR_HNO_CODE = "110";

	public static final String FACHARZTINFACHARZT_FUR_HAUT_CODE = "111";

	public static final String FACHARZTINFACHARZT_FUR_HERZCHIRURGIE_CODE = "112";

	public static final String FACHARZTINFACHARZT_FUR_HISTOLOGIE_CODE = "113";

	public static final String FACHARZTINFACHARZT_FUR_HYGIENE_MIKROBIOLOGIE_CODE = "114";

	public static final String FACHARZTINFACHARZT_FUR_IMMUNOLOGIE_CODE = "115";

	public static final String FACHARZTINFACHARZT_FUR_INNERE_MEDIZIN_CODE = "116";

	public static final String FACHARZTINFACHARZT_FUR_KINDER_UND_JUGENDCHIRURGIE_CODE = "117";

	public static final String FACHARZTINFACHARZT_FUR_KINDER_UND_JUGENDHEILKUNDE_CODE = "118";

	public static final String FACHARZTINFACHARZT_FUR_KINDER_UND_JUGENDPSYCHIATRIE_CODE = "119";

	public static final String FACHARZTINFACHARZT_FUR_LUNGENKRANKHEITEN_CODE = "120";

	public static final String FACHARZTINFACHARZT_FUR_MEDIZINISCHE_BIOLOGIE_CODE = "121";

	public static final String FACHARZTINFACHARZT_FUR_MEDIZINISCHE_BIOPHYSIK_CODE = "122";

	public static final String FACHARZTINFACHARZT_FUR_MEDIZINISCHE_GENETIK_CODE = "123";

	public static final String FACHARZTINFACHARZT_FUR_MEDIZINISCHE_UND_CHEMISCHE_LABORDIAGNOSTIK_CODE = "124";

	public static final String FACHARZTINFACHARZT_FUR_MEDIZINISCHE_LEISTUNGSPHYSIOLOGIE_CODE = "125";

	public static final String FACHARZTINFACHARZT_FUR_MIKROBIOLOGISCH_SEROLOGISCHE_LABORDIAGNOSTIK_CODE = "126";

	public static final String FACHARZTINFACHARZT_FUR_MUND_KIEFER_UND_GESICHTSCHIRURGIE_CODE = "127";

	public static final String FACHARZTINFACHARZT_FUR_NEUROBIOLOGIE_CODE = "128";

	public static final String FACHARZTINFACHARZT_FUR_NEUROCHIRURGIE_CODE = "129";

	public static final String FACHARZTINFACHARZT_FUR_NEUROLOGIE_CODE = "130";

	public static final String FACHARZTINFACHARZT_FUR_NEUROLOGIE_PSYCHIATRIE_CODE = "131";

	public static final String FACHARZTINFACHARZT_FUR_NEUROPATHOLOGIE_CODE = "132";

	public static final String FACHARZTINFACHARZT_FUR_NUKLEARMEDIZIN_CODE = "133";

	public static final String FACHARZTINFACHARZT_FUR_ORTHOPAEDIE_ORTHOPADISCHE_CHIRURGIE_CODE = "134";

	public static final String FACHARZTINFACHARZT_FUR_PATHOLOGIE_CODE = "135";

	public static final String FACHARZTINFACHARZT_FUR_PATHOPHYSIOLOGIE_CODE = "136";

	public static final String FFACHARZTINFACHARZT_FUR_PHARMAKOLOGIE_TOXIKOLOGIE_CODE = "137";

	public static final String FACHARZTINFACHARZT_FUR_PHYSIKALISCHE_MEDIZIN_UND_REHABILIATION_CODE = "138";

	public static final String FACHARZTINFACHARZT_FUR_PHYSIOLOGIE_CODE = "139";

	public static final String FACHARZTINFACHARZT_FUR_PLASTISCHE_ASTHETISCHE_UND_REKONSTRUKTIVE_CHIRURGIE_CODE = "140";

	public static final String FACHARZTINFACHARZT_FUR_PSYCHIATRIE_CODE = "141";

	public static final String FACHARZTINFACHARZT_FUR_PSYCHIATRIE_NEUROLOGIE_CODE = "142";

	public static final String FACHARZTINFACHARZT_FUR_PSYCHIATRIE_PSYCHOTHERAPIE_CODE = "143";

	public static final String FACHARZTINFACHARZT_FUR_RADIOLOGIE_CODE = "144";

	public static final String FACHARZTINFACHARZT_FUR_SOZIALMEDIZIN_CODE = "145";

	public static final String FACHARZTINFACHARZT_FUR_PROPHYLAXE_TROPENMEDIZIN_CODE = "146";

	public static final String FACHARZTINFACHARZT_FUR_STRAHLENTHERAPIE_RADIOONKOLOGIE_CODE = "147";

	public static final String FACHARZTINFACHARZT_FUR_THEORETISCHE_SONDERFAECHER_CODE = "148";

	public static final String FACHARZTINFACHARZT_FUR_THORAXCHIRURGIE_CODE = "149";

	public static final String FACHARZTINFACHARZT_FUR_TUMORBIOLOGIE_CODE = "150";

	public static final String FACHARZTINFACHARZT_FUR_UNFALLCHIRURGIE_CODE = "151";

	public static final String FACHARZTINFACHARZT_FUR_UROLOGIE_CODE = "152";

	public static final String FACHARZTINFACHARZT_FUR_VIROLOGIE_CODE = "153";

	public static final String FACHARZTINFACHARZT_FUR_ZAHN_MUND_KIEFERHEILKUNDE_CODE = "154";

	public static final String FACHARZTINFACHARZT_CODE = "158";

	public static final String ZAHNARZTINZAHNARZT_CODE = "155";

	public static final String DENTIST_CODE = "156";

	public static final String PHYSIOTHERAPEUTINPHYSIOTHERAPEUT_CODE = "200";

	public static final String KLINISCHER_PSYCHOLOGEKLINISCHE_PSYCHOLOGIN_CODE = "201";

	public static final String GESUNDHEITSPSYCHOLOGINGESUNDHEITSPSYCHOLOGE_CODE = "202";

	public static final String MUSIKTHERAPEUTINMUSIKTHERAPEUT_CODE = "203";

	public static final String HEBAMME_CODE = "204";

	public static final String PHYSIOTHERAPEUT_CODE = "205";

	public static final String BIOMEDIZINISCHE_ANALYTIKERINBIOMEDIZINISCHER_ANALYTIKER_CODE = "206";

	public static final String RADIOLOGIETECHNOLOGINRADIOLOGIETECHNOLOGE_CODE = "207";

	public static final String DIATOLOGINDIATOLOGE_CODE = "208";

	public static final String ERGOTHERAPEUTINERGOTHERAPEUT_CODE = "209";

	public static final String LOGOPADINLOGOPADE_CODE = "210";

	public static final String ORTHOPTISTINORTHOPTIST_CODE = "211";

	public static final String DIPLOMIERTE_GESUNDHEITS_KRANKEN_SCHWESTER_PFLEGER_CODE = "212";

	public static final String DIPLOMIERTE_KINDER_KRANKEN_SCHWESTER_PFLEGER_CODE = "213";

	public static final String DIPLOMIERTE_PSYCHIATRISCHE_GESUNDHEITS_KRANKEN_SCHWESTER_PFLEGER_CODE = "214";

	public static final String HEILMASSEURINHEILMASSEUR_CODE = "215";

	public static final String DIPLOMIERTE_KARDIOTECHNIKERINKARDIOTECHNIKER_CODE = "216";

	public static final String ALLGEMEINEKRANKENANSTALT_CODE = "300";

	public static final String SONDERKRANKENANSTALT_CODE = "301";

	public static final String PFLEGEANSTALT_CODE = "302";

	public static final String SANATORIUM_CODE = "303";

	public static final String SELBSTSTAENDIGES_AMBULATORIUM_CODE = "304";

	public static final String PFLEGEEINRICHTUNG_CODE = "305";

	public static final String MOBILE_PFLEGE_CODE = "306";

	public static final String KURANSTALT_CODE = "307";

	public static final String STRAF_MASSNAHMENVOLLZUG_CODE = "309";

	public static final String UNTERSUCHUNGSANSTALT_CODE = "310";

	public static final String OEFFENTLICHE_APOTHEKE_CODE = "311";

	public static final String GEWEBEBANK_CODE = "312";

	public static final String BLUTSPENDEEINRICHTUNG_CODE = "313";

	public static final String AUGEN_KONTAKTLINSENOPTIK_CODE = "314";

	public static final String HOERGERAETAKUSTIK_CODE = "315";

	public static final String ORTHOPAEDISCHE_PRODUKTE_CODE = "316";

	public static final String ZAHNTECHNIK_CODE = "317";

	public static final String RETTUNGSDIENST_CODE = "318";

	public static final String ZAHNAERZTLICHE_GRUPPENPRAXIS_CODE = "319";

	public static final String AERZTLICHE_GRUPPENPRAXIS_CODE = "320";

	public static final String GEWEBEENTNAHMEEINRICHTUNG_CODE = "321";

	public static final String ARBEITSMEDIZINISCHESZENTRUM_CODE = "322";

	public static final String GESUNDHEITSMANAGEMENT_CODE = "400";

	public static final String OEFFENTLICHER_GESUNDHEITSDIENST_CODE = "401";

	public static final String ELGA_OMBUDSSTELLE_CODE = "403";

	public static final String WIDERSRPUCHSSTELLE_CODE = "404";

	public static final String PATIENTENVERTRETUNG_CODE = "405";

	public static final String SOZIALVERSICHERUNG_CODE = "406";

	public static final String KRANKENFUERSORGE_CODE = "407";

	public static final String GESUNDHEITSVERSORGUNG_CODE = "408";

	public static final String IKT_GESUNDHEITSSERVICE_CODE = "500";

	public static final String VERRECHNUNGSSERVICE_CODE = "501";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static AuthorSpeciality getEnum(String code) {
		for (final AuthorSpeciality x : values()) {
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
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(AuthorSpeciality.class, enumName);
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
	 *            <div class="de">code</div>
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (AuthorSpeciality x : values()) {
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
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private AuthorSpeciality(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		return new Code(CODE_SYSTEM_OID, code, displayName);
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

	@Override
	public String getCodeSystemId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValueSetId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValueSetName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayNameAt(LanguageCode languageCode) {
		// TODO Auto-generated method stub
		return null;
	}
}
