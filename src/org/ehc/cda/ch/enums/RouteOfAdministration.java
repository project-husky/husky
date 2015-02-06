package org.ehc.cda.ch.enums;

import java.util.Arrays;
import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus HL7 RouteOfAdministration dürfen ebenfalls verwendet werden.Hinweis: Für Impfungen relevante Einträge sind fett markiert.</div>
*<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés de HL7 RouteOfAdministration.Remarque : Les entrées pertinentes pour les vaccins sont indiquées en gras.</div>
*/
public enum RouteOfAdministration {

	/** 
	*<div class="de">Injektion, intradermal</div>
	*<div class="fr">Injection intradermique</div>
	*/
	INJECTION_INTRADERMAL ("IDINJ", "Injection, intradermal "),
	/** 
	*<div class="de">Inhalation, Vernebelung, nasal</div>
	*<div class="fr">Inhalation par nébulisation nasale</div>
	*/
	INHALATION_NEBULIZATION_NASAL ("NASNEB", "Inhalation, nebulization, nasal "),
	/** 
	*<div class="de">Schlucken, oral</div>
	*<div class="fr">Prendre par la bouche</div>
	*/
	SWALLOW_ORAL ("PO", "Swallow, oral "),
	/** 
	*<div class="de">Injektion, subkutan</div>
	*<div class="fr">Injection sous-cutanée</div>
	*/
	INJECTION_SUBCUTANEOUS ("SQ", "Injection, subcutaneous "),
	/** 
	*<div class="de">Diffusion, transdermal</div>
	*<div class="fr">Diffusion transdermique</div>
	*/
	DIFFUSION_TRANSDERMAL ("TRNSDERMD", "Diffusion, transdermal "),
	/** 
	*<div class="de">Injektion, intramuskulär</div>
	*<div class="fr">Injection intra-musculaire</div>
	*/
	INJECTION_INTRAMUSCULAR ("IM", "Injection, intramuscular");
	public static final String INJECTION_INTRADERMAL_CODE="IDINJ";
	public static final String INHALATION_NEBULIZATION_NASAL_CODE="NASNEB";
	public static final String SWALLOW_ORAL_CODE="PO";
	public static final String INJECTION_SUBCUTANEOUS_CODE="SQ";
	public static final String DIFFUSION_TRANSDERMAL_CODE="TRNSDERMD";
	public static final String INJECTION_INTRAMUSCULAR_CODE="IM";


	public static final String CODE_SYSTEM="2.16.840.1.113883.5.112";
	public static final String CODE_SYSTEM_NAME="HL7 RouteOfAdministration";


	private String code;
	private String displayName;

	RouteOfAdministration (String code, String displayName) {
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
		for (RouteOfAdministration x : values()) {
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