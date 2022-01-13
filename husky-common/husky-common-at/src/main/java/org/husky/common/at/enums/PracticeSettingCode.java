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

import java.util.HashMap;
import java.util.Map;

public enum PracticeSettingCode implements ValueSetEnumInterfaceAt {

	GENERAL_PRACTICE("F001", "Allgemeinmedizin"),

	ANAESTHESIOLOGY("F002", "Anästhesiologie und Intensivmedizin"),

	OPHTHALMOLOGY("F005", "Augenheilkunde"),

	TRANSFUSION_MEDICINE("F006", "Blutgruppenserologie und Transfusionsmedizin"),

	SURGERY("F007", "Chirurgie"),

	GYNECOLOGY_AND_OBSTRETRICS("F010", "Gynäkologie und Geburtshilfe"),

	EAR_NOSE_AND_THROAT_MEDICINE("F014", "Hals-, Nasen- und Ohrenkrankheiten"),

	DERMATOLOGY("F015", "Dermatologie"),

	MICROBIOLOGY("F016", "Mikrobiologie"),

	INTERNAL_MEDICINE("F019", "Innere Medizin"),

	INTERDISCIPLINARY_AREA("F023", "Interdisziplinärer Bereich"),

	CHILD_ADOLESCENT_PSYCHATRY("F025", "Kinder- und Jugendpsychiatrie"),

	CHILD_ADOLESCENT_SURGERY("F026", "Kinder- und Jugendchirurgie"),

	PAEDIATRICS("F027", "Kinder- und Jugendheilkunde"),

	LABORATORY_DIAGNOSTIC("F028", "Labordiagnostik"),

	ORAL_AND_MAXILLOFACIAL_SURGERY("F029", "Mund-, Kiefer- und Gesichtschirurgie"),

	NEUROSURGERY("F031", "Neurochirurgie"),

	NEUROLOGY("F032", "Neurologie"),

	NUCLEAR_MEDICINE("F033", "Nuklearmedizin"),

	ORTHOPAEDICS("F035", "Orthopädie und orthopädische Chirurgie"),

	PALLIATIVE_MEDICINE("F036", "Palliativmedizin"),

	PATHOLOGY("F037", "Pathologie"),

	PHYSICAL_MEDICINE("F040", "Physikalische Medizin und Rehabilitation"),

	PLASTIC_SURGERY("F041", "Plastische Chirurgie"),

	PSYCHIATRY("F042", "Psychiatrie"),

	PULMOLOGY("F043", "Pulmologie (Lungenheilkunde)"),

	RADIOLOGY("F044", "Radiologie"),

	REMOBILISATION("F048", "Remobilisation/Nachsorge"),

	ACCIDENT_SURGERY("F052", "Unfallchirurgie"),

	UROLOGY("F053", "Urologie"),

	DENTAL_MEDICINE("F055", "Zahn-, Mund- und Kieferheilkunde"),

	GERIATRIC_MEDICINE("F056", "Akutgeriatrie/Remobilisation"),

	NURSING("F057", "Gesundheits- und Krankenpflege"),

	CARDIAC_SURGERY("F058", "Herzchirurgie"),

	PSYCHOLOGY("F059", "Klinische Psychologie"),

	CURE_PREVENTION("F060", "Kur- und Prävention"),

	PSYCHO_SOMATIC_MEDICINE("F061", "Psychosomatik"),

	RADIATION_ONCOLOGY("F062", "Radioonkologie"),

	LEGAL_DOCUMENTS("F063", "Rechtliche Dokumente"),

	THORACIC_SURGERY("F064", "Thoraxchirurgie"),

	PATIENT_ADMINISTRATION("F065", "Patienten Verwaltung"),

	HOSPITAL_CARE("F066", "Krankenhauspflege");

	public static final String GENERAL_PRACTICE_CODE = "F001";
	public static final String ANAESTHESIOLOGY_CODE = "F002";
	public static final String OPHTHALMOLOGY_CODE = "F005";
	public static final String TRANSFUSION_MEDICINE_CODE = "F006";
	public static final String SURGERY_CODE = "F007";
	public static final String GYNECOLOGY_AND_OBSTRETRICS_CODE = "F010";
	public static final String EAR_NOSE_AND_THROAT_MEDICINE_CODE = "F014";
	public static final String DERMATOLOGY_CODE = "F015";
	public static final String MICROBIOLOGY_CODE = "F016";
	public static final String INTERNAL_MEDICINE_CODE = "F019";
	public static final String INTERDISCIPLINARY_AREA_CODE = "F023";
	public static final String CHILD_ADOLESCENT_PSYCHATRY_CODE = "F025";
	public static final String CHILD_ADOLESCENT_SURGERY_CODE = "F026";
	public static final String PAEDIATRICS_CODE = "F027";
	public static final String LABORATORY_DIAGNOSTIC_CODE = "F028";
	public static final String ORAL_AND_MAXILLOFACIAL_SURGERY_CODE = "F029";
	public static final String NEUROSURGERY_CODE = "F031";
	public static final String NEUROLOGY_CODE = "F032";
	public static final String NUCLEAR_MEDICINE_CODE = "F033";
	public static final String ORTHOPAEDICS_CODE = "F035";
	public static final String PALLIATIVE_MEDICINE_CODE = "F036";
	public static final String PATHOLOGY_CODE = "F037";
	public static final String PHYSICAL_MEDICINE_CODE = "F040";
	public static final String PLASTIC_SURGERY_CODE = "F041";
	public static final String PSYCHIATRY_CODE = "F042";
	public static final String PULMOLOGY_CODE = "F043";
	public static final String RADIOLOGY_CODE = "F044";
	public static final String REMOBILISATION_CODE = "F048";
	public static final String ACCIDENT_SURGERY_CODE = "F052";
	public static final String UROLOGY_CODE = "F053";
	public static final String DENTAL_MEDICINE_CODE = "F055";
	public static final String GERIATRIC_MEDICINE_CODE = "F056";
	public static final String NURSING_CODE = "F057";
	public static final String CARDIAC_SURGERY_CODE = "F058";
	public static final String PSYCHOLOGY_CODE = "F059";
	public static final String CURE_PREVENTION_CODE = "F060";
	public static final String PSYCHO_SOMATIC_MEDICINE_CODE = "F061";
	public static final String RADIATION_ONCOLOGY_CODE = "F062";
	public static final String LEGAL_DOCUMENTS_CODE = "F063";
	public static final String THORACIC_SURGERY_CODE = "F064";
	public static final String PATIENT_ADMINISTRATION_CODE = "F065";
	public static final String HOSPITAL_CARE_CODE = "F066";

	/**
	 * <div class="en">Name of the value set</div> <div class="de">Name des
	 * Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "ELGA_PracticeSetting";

	private static final String CODESYSTEM_OID = "1.2.40.0.34.5.12";

	private static final String VALUE_SET_ID = "1.2.40.0.34.10.75";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static PracticeSettingCode getEnum(String code) {
		for (final PracticeSettingCode x : values()) {
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
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(PracticeSettingCode.class, enumName);
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
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final PracticeSettingCode x : values()) {
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
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instanziiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 */
	PracticeSettingCode(String code, String displayName) {
		this.code = code;
		this.codeSystem = CODESYSTEM_OID;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.GERMAN_AT, displayName);
	}

	/**
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */

	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * den Code System Namen.</div>
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
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */

	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is
	 * returned.</div> <div class="de">Liefert display name gemäss Parameter,
	 * falls es keine Englische Übersetzung gibt, wird der default-Name
	 * zurückgegeben.</div>
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayNameAt(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <div class="en">Gets the value set name.</div> <div class="de">Liefert
	 * den Value Set Namen.</div>
	 *
	 * @return <div class="en">the value set name</div>
	 */

	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
