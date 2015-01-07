/*******************************************************************************
*
* The authorship of this code and the accompanying materials is held by
* medshare GmbH, Switzerland. All rights reserved.
* http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the
* Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the
* Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
*
* Year of publication: 2014
*
*******************************************************************************/

package org.ehc.cda;

import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

import org.ehc.cda.ConvenienceUtilsEnums.AllergySubstanceType;
import org.ehc.cda.ConvenienceUtilsEnums.AllergyType;
import org.ehc.cda.ConvenienceUtilsEnums.Severity;

/**
 * Codierte Allergie oder Unverträglichkeit
 */
public class AllergyIntolerance {

	private org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance mAllergyIntolerance;
	
	/**
	 * Erzeugt ein Objekt welches eine Allergie oder Unverträglichkeit
	 * repräsentiert. Dieses Objekt kann einem AllergyIntoleranceConcern
	 * hinzugefügt werden.
	 * 
	 * @param codedIntolerance
	 *          Codierte Intoleranz
	 * @param substanceThatCausesIntolerance
	 *          Substanz die die Intoleranz auslöst
	 * @param severity
	 *          Schweregrad der Intoleranz
	 * 
	 */
	public AllergyIntolerance(AllergyType codedIntolerance,	AllergySubstanceType substanceThatCausesIntolerance, Severity severity) {
		this.mAllergyIntolerance = IHEFactory.eINSTANCE.createAllergyIntolerance().init();
		mAllergyIntolerance.getValues().add(createAllergyCode(substanceThatCausesIntolerance));
	}
	
	private CD createAllergyCode(AllergySubstanceType type) {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setCode(getCode(type));
		code.setCodeSystem("2.16.840.1.113883.6.96");
		code.setCodeSystemName("SNOMED CT");
		code.setDisplayName(getDisplayName(type));
		return code;
	}
	
	private String getCode(AllergySubstanceType type) {
		if (AllergySubstanceType.EggProtein == type) {
			return "213020009";
		} else if (AllergySubstanceType.Atopic_dermatitis == type) {
			return "24079001";
		} else {
			throw new IllegalArgumentException("Cannot get code for AllergySubstanceType " + type);
		}
	}
	
	private String getDisplayName(AllergySubstanceType type) {
		if (AllergySubstanceType.EggProtein == type) {
			return "Egg protein allergy (disorder)";
		} else if (AllergySubstanceType.Atopic_dermatitis == type) {
			return "Atopisches Ekzem (disorder)";
		} else {
			throw new IllegalArgumentException("Cannot get display name for AllergySubstanceType " + type);
		}
	}
	
	
	
	public org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance getAllergyIntolerance() {
		return mAllergyIntolerance;
	}

}
