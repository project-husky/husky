package ch.ehc.cda.enums;

import java.util.Arrays;
import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus HL7 ActCode dürfen ebenfalls verwendet werden. (Quelle für Subset: [IHE PCC TF-2], 6.3.4.15.4)</div>
*<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés de HL7 ActCode. (Source du sous-ensemble : [IHE PCC TF-2], 6.3.4.15.4)</div>
*/
public enum AllergiesAndIntolerances {

	/** 
	*<div class="de">Überempfindlichkeit des Immunsystems auf bestimmte pharmazeutische Produkte (Arzneimittel).</div>
	*<div class="fr">Hyperréactivité du système immunitaire à certains produits pharmaceutiques (médicaments)</div>
	*/
	DRUG_ALLERGY ("DALG", "Drug Allergy"),
	/** 
	*<div class="de">Unerwünschte Reaktion des Immunsystems bei Anwendung bestimmter Arzneimittel.</div>
	*<div class="fr">Réaction indésirable du système immunitaire lors de l’utilisation de certains médicaments</div>
	*/
	DRUG_INTOLERANCE ("DINT", "Drug Intolerance"),
	/** 
	*<div class="de">Überempfindlichkeit des Immunsystems auf bestimmte Stoffe in Nahrungsmitteln</div>
	*<div class="fr">Hyperréactivité du système immunitaire à certaines substances contenues dans des aliments</div>
	*/
	FOOD_ALLERGY ("FALG", "Food Allergy"),
	/** 
	*<div class="de">Unerwünschte Reaktion des Immunsystems bei Einnahme bestimmter Nahrungsmittel.</div>
	*<div class="fr">Réaction indésirable du système immunitaire en cas d’absorption de certains aliments.</div>
	*/
	FOOD_INTOLERANCE ("FINT", "Food Intolerance");
	public static final String DRUG_ALLERGY_CODE="DALG";
	public static final String DRUG_INTOLERANCE_CODE="DINT";
	public static final String FOOD_ALLERGY_CODE="FALG";
	public static final String FOOD_INTOLERANCE_CODE="FINT";


	public static final String CODE_SYSTEM="2.16.840.1.113883.5.4";
	public static final String CODE_SYSTEM_NAME="HL7 ActCode";


	private String code;
	private String displayName;

	AllergiesAndIntolerances (String code, String displayName) {
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
		for (AllergiesAndIntolerances x : values()) {
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