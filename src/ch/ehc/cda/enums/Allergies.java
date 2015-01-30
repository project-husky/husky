package ch.ehc.cda.enums;

import java.util.Arrays;
import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus den, in Kapitel 7.5.2.4 Spezifikation CDA Body Level 3  Problem Entry auf Seite 53 genannten Codesystemen dürfen ebenfalls verwendet werden.</div>
*<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés des systèmes de codes mentionnés au cha-pitre 7.5.2.4 « Spécification CDA Body Level 3  Problem Entry » à la page 53</div>
*/
public enum Allergies {

	/** 
	*<div class="de">Hühnereiweiss</div>
	*<div class="fr">Protéine d’œufs de poule</div>
	*/
	EGG_PROTEIN_SUBSTANCE ("303300008", "Egg protein (substance)"),
	/** 
	*<div class="de">Atopisches Ekzem</div>
	*<div class="fr">Eczéma atopique</div>
	*/
	ATOPIC_DERMATITIS ("24079001", "Atopic dermatitis");
	public static final String EGG_PROTEIN_SUBSTANCE_CODE="303300008";
	public static final String ATOPIC_DERMATITIS_CODE="24079001";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME="SNOMED CT";


	private String code;
	private String displayName;

	Allergies (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public String getCodeValue() {
		return this.code;
	}

	public String getdisplayName() {
		return this.displayName;
	}

	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
		return ehcCode;
	}

	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}

	public boolean isInValueSet(String code) {
		for (Allergies x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public String getCodeSystemId() {
		return CODE_SYSTEM;
	}
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

}