package org.ehc.cda.ch.enums;

import java.util.Arrays;

import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus den, in Kapitel 7.5.2.4 Spezifikation CDA Body Level 3  Problem Entry auf Seite 53 genannten Codesystemen dürfen ebenfalls verwendet werden.</div>
 *<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés des systèmes de codes mentionnés au cha-pitre 7.5.2.4 « Spécification CDA Body Level 3  Problem Entry » à la page 53.</div>
 */
public enum ImmunologicalDisorders {

	/** 
	 *<div class="de">Autoimunkrankheit</div>
	 *<div class="fr">Maladie auto-immune</div>
	 */
	AUTOIMMUNE_DISEASE ("85828009", "Autoimmune disease"),
	/** 
	 *<div class="de">Rheumatismus</div>
	 *<div class="fr">Rhumatisme</div>
	 */
	RHEUMATISM ("396332003", "Rheumatism"),
	/** 
	 *<div class="de">Medikamentöse Immunsuppression</div>
	 *<div class="fr">Immunosuppression médicamenteuse</div>
	 */
	DRUG_INDUCED_IMMUNODEFICIENCY ("234645009", "Drug-induced immunodeficiency"),
	/** 
	 *<div class="de">HIV-Infektion</div>
	 *<div class="fr">Infection VIH</div>
	 */
	HUMAN_IMMUNODEFICIENCY_VIRUS_INFECTION ("86406008", "Human immunodeficiency virus infection"),
	/** 
	 *<div class="de">Splenektomie</div>
	 *<div class="fr">Splénectomie</div>
	 */
	HO_SPLENECTOMY ("161626009", "H/O: splenectomy"),
	/** 
	 *<div class="de">Asplenie</div>
	 *<div class="fr">Asplénie</div>
	 */
	FUNCTIONAL_ASPLENIA ("38096003", "Functional asplenia"),
	/** 
	 *<div class="de">Antikörpermangel</div>
	 *<div class="fr">Déficience en anticorps</div>
	 */
	SPECIFIC_ANTIBODY_DEFICIENCY ("234556002", "Specific antibody deficiency"),
	/** 
	 *<div class="de">Defizite des Komplementsystems</div>
	 *<div class="fr">Déficits du système du complément</div>
	 */
	COMPLEMENT_DEFICIENCY_DISEASE ("24743004", "Complement deficiency disease"),
	/** 
	 *<div class="de">Sichelzellenanämie</div>
	 *<div class="fr">Anémie falciforme</div>
	 */
	SICKLE_CELL_ANEMIA ("160320002", "Sickle cell anemia"),
	/** 
	 *<div class="de">Defizite im Mannan-bindenden Lektin</div>
	 *<div class="fr">Déficits de la lectine de liaison des mannanes</div>
	 */
	MANNAN_BINDING_PROTEIN_DEFICIENCY ("234579001", "Mannan-binding protein deficiency"),
	/** 
	 *<div class="de">Protein-C-Defizit</div>
	 *<div class="fr"> Déficit en protéine C</div>
	 */
	PROTEIN_C_DEFICIENCY_DISEASE ("76407009", "Protein C deficiency disease"),
	/** 
	 *<div class="de">Protein-S-Defizit</div>
	 *<div class="fr"> Déficit en protéine S</div>
	 */
	PROTEIN_S_DEFICIENCY_DISEASE ("1563006", "Protein S deficiency disease ");
	public static final String AUTOIMMUNE_DISEASE_CODE="85828009";
	public static final String RHEUMATISM_CODE="396332003";
	public static final String DRUG_INDUCED_IMMUNODEFICIENCY_CODE="234645009";
	public static final String HUMAN_IMMUNODEFICIENCY_VIRUS_INFECTION_CODE="86406008";
	public static final String HO_SPLENECTOMY_CODE="161626009";
	public static final String FUNCTIONAL_ASPLENIA_CODE="38096003";
	public static final String SPECIFIC_ANTIBODY_DEFICIENCY_CODE="234556002";
	public static final String COMPLEMENT_DEFICIENCY_DISEASE_CODE="24743004";
	public static final String SICKLE_CELL_ANEMIA_CODE="160320002";
	public static final String MANNAN_BINDING_PROTEIN_DEFICIENCY_CODE="234579001";
	public static final String PROTEIN_C_DEFICIENCY_DISEASE_CODE="76407009";
	public static final String PROTEIN_S_DEFICIENCY_DISEASE_CODE="1563006";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME="SNOMED CT";


	private String code;
	private String displayName;

	ImmunologicalDisorders (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
		return ehcCode;
	}

	public String getCodeSystemId() {
		return CODE_SYSTEM;
	}

	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	public String getCodeValue() {
		return code;
	}

	public String getdisplayName() {
		return displayName;
	}

	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}
	public boolean isInValueSet(String code) {
		for (ImmunologicalDisorders x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}