package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus den, in Kapitel 7.5.2.4 Spezifikation CDA Body Level 3  Problem Entry auf Seite 53 genannten Codesystemen dürfen ebenfalls verwendet werden.</div>
 *<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés des systèmes de codes mentionnés au cha-pitre 7.5.2.4 « Spécification CDA Body Level 3  Problem Entry » à la page 53.</div>
 */
public enum ImmunologicalDisorders {

	/**
	 * <div class="de">Autoimunkrankheit</div> <div class="fr">Maladie
	 * auto-immune</div>
	 */
	AUTOIMMUNE_DISEASE("85828009", "Autoimmune disease"),
	/**
	 * <div class="de">Rheumatismus</div> <div class="fr">Rhumatisme</div>
	 */
	RHEUMATISM("396332003", "Rheumatism"),
	/**
	 * <div class="de">Medikamentöse Immunsuppression</div> <div
	 * class="fr">Immunosuppression médicamenteuse</div>
	 */
	DRUG_INDUCED_IMMUNODEFICIENCY("234645009", "Drug-induced immunodeficiency"),
	/**
	 * <div class="de">HIV-Infektion</div> <div class="fr">Infection VIH</div>
	 */
	HUMAN_IMMUNODEFICIENCY_VIRUS_INFECTION("86406008", "Human immunodeficiency virus infection"),
	/**
	 * <div class="de">Splenektomie</div> <div class="fr">Splénectomie</div>
	 */
	HO_SPLENECTOMY("161626009", "H/O: splenectomy"),
	/**
	 * <div class="de">Asplenie</div> <div class="fr">Asplénie</div>
	 */
	FUNCTIONAL_ASPLENIA("38096003", "Functional asplenia"),
	/**
	 * <div class="de">Antikörpermangel</div> <div class="fr">Déficience en
	 * anticorps</div>
	 */
	SPECIFIC_ANTIBODY_DEFICIENCY("234556002", "Specific antibody deficiency"),
	/**
	 * <div class="de">Defizite des Komplementsystems</div> <div
	 * class="fr">Déficits du système du complément</div>
	 */
	COMPLEMENT_DEFICIENCY_DISEASE("24743004", "Complement deficiency disease"),
	/**
	 * <div class="de">Sichelzellenanämie</div> <div class="fr">Anémie
	 * falciforme</div>
	 */
	SICKLE_CELL_ANEMIA("160320002", "Sickle cell anemia"),
	/**
	 * <div class="de">Defizite im Mannan-bindenden Lektin</div> <div
	 * class="fr">Déficits de la lectine de liaison des mannanes</div>
	 */
	MANNAN_BINDING_PROTEIN_DEFICIENCY("234579001", "Mannan-binding protein deficiency"),
	/**
	 * <div class="de">Protein-C-Defizit</div> <div class="fr"> Déficit en
	 * protéine C</div>
	 */
	PROTEIN_C_DEFICIENCY_DISEASE("76407009", "Protein C deficiency disease"),
	/**
	 * <div class="de">Protein-S-Defizit</div> <div class="fr"> Déficit en
	 * protéine S</div>
	 */
	PROTEIN_S_DEFICIENCY_DISEASE("1563006", "Protein S deficiency disease ");
	public static final String AUTOIMMUNE_DISEASE_CODE = "85828009";
	public static final String RHEUMATISM_CODE = "396332003";
	public static final String DRUG_INDUCED_IMMUNODEFICIENCY_CODE = "234645009";
	public static final String HUMAN_IMMUNODEFICIENCY_VIRUS_INFECTION_CODE = "86406008";
	public static final String HO_SPLENECTOMY_CODE = "161626009";
	public static final String FUNCTIONAL_ASPLENIA_CODE = "38096003";
	public static final String SPECIFIC_ANTIBODY_DEFICIENCY_CODE = "234556002";
	public static final String COMPLEMENT_DEFICIENCY_DISEASE_CODE = "24743004";
	public static final String SICKLE_CELL_ANEMIA_CODE = "160320002";
	public static final String MANNAN_BINDING_PROTEIN_DEFICIENCY_CODE = "234579001";
	public static final String PROTEIN_C_DEFICIENCY_DISEASE_CODE = "76407009";
	public static final String PROTEIN_S_DEFICIENCY_DISEASE_CODE = "1563006";

	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME = "SNOMED CT";

	private String code;
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display
	 * Name</div> <div class="de">Instantiiert dieses Enum Object mittels eines
	 * Codes und einem Display Name</div>
	 * 
	 * @param code
	 * <br>
	 *          <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *          <div class="de"> display name</div>
	 */
	private ImmunologicalDisorders(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * 
	 * @param code
	 * <br>
	 *          <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ImmunologicalDisorders getEnum(String code) {
		for (ImmunologicalDisorders x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 * 
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>
	 * 
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
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
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert die
	 * code system id.</div>
	 * 
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div> <div
	 * class="de">Liefert den eigentlichen Code als String</div>
	 * 
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 * 
	 * @return <div class="en">the display name</div>
	 */
	public String getdisplayName() {
		return displayName;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 * 
	 * 
	 * @param enumName
	 * <br>
	 *          <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden
	 * ist.</div>
	 * 
	 * @param codeValue
	 * <br>
	 *          <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (ImmunologicalDisorders x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}