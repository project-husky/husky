/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch;

import java.util.Date;

import org.ehealth_connector.cda.AbstractAllergyProblem;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.enums.AllergiesAndIntolerances;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Jan 6, 2016 5:08:32 PM
 *
 */
public class AllergyProblem extends AbstractAllergyProblem {

	/**
	 * Default constructor to instanciate the object
	 */
	public AllergyProblem() {

	}

	/**
	 * Default constructor to instanciate the object
	 * 
	 * @param allergy
	 */
	public AllergyProblem(AllergiesAndIntolerances allergy) {
		super(allergy);
	}

	/**
	 * Default constructor to instanciate the object
	 * 
	 * @param kindOfAllergy
	 * @param problem
	 * @param startOfProblem
	 * @param endOfProblem
	 */
	public AllergyProblem(AllergiesAndIntolerances kindOfAllergy, Code problem, Date startOfProblem, Date endOfProblem) {
		super(kindOfAllergy, problem, startOfProblem, endOfProblem);
	}

	/**
	 * Default constructor to instanciate the object
	 * 
	 * @param kindOfAllergy
	 * @param problem
	 * @param startOfProblem
	 * @param endOfProblem
	 * @param internalProblemId
	 */
	public AllergyProblem(AllergiesAndIntolerances kindOfAllergy, Code problem, Date startOfProblem, Date endOfProblem,
			Identificator internalProblemId) {
		super(kindOfAllergy, problem, startOfProblem, endOfProblem, internalProblemId);
	}

	/**
	 * Default constructor to instanciate the object
	 * 
	 * @param allergyIntolerance
	 */
	public AllergyProblem(AllergyIntolerance allergyIntolerance) {
		super(allergyIntolerance);
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractAllergyProblem#addId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void addId(Identificator id) {
		final II ii = CdaChUtil.createUuidVacdIdentificator(id);
		getAllergyProblem().getIds().add(ii);
	}

}
