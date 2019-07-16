/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda;

import java.util.Date;

import org.ehealth_connector.cda.enums.AllergiesAndIntolerances;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;

/**
 * <div class="en">A class representing the allergy problem information.</div>
 * <div class="de">Eine Klasse die die Informationen zu Allergieprobleme
 * representiert.</div>
 *
 */
public class AllergyProblem extends BaseAllergyProblem {

	/**
	 * Default constructor to instanciate the object.
	 */
	public AllergyProblem() {

	}

	/**
	 * Instantiates a new allergy problem.
	 *
	 * @param allergy
	 *            the allergy
	 */
	public AllergyProblem(AllergiesAndIntolerances allergy) {
		super(allergy);
	}

	/**
	 * Instantiates a new allergy problem.
	 *
	 * @param kindOfAllergy
	 *            the kind of allergy
	 * @param problem
	 *            the problem
	 * @param startOfProblem
	 *            the start of problem
	 * @param endOfProblem
	 *            the end of problem
	 */
	public AllergyProblem(AllergiesAndIntolerances kindOfAllergy, Code problem, Date startOfProblem,
			Date endOfProblem) {
		super(kindOfAllergy, problem, startOfProblem, endOfProblem);
	}

	/**
	 * Instantiates a new allergy problem.
	 *
	 * @param kindOfAllergy
	 *            the kind of allergy
	 * @param problem
	 *            the problem
	 * @param startOfProblem
	 *            the start of problem
	 * @param endOfProblem
	 *            the end of problem
	 * @param internalProblemId
	 *            the internal problem id
	 */
	public AllergyProblem(AllergiesAndIntolerances kindOfAllergy, Code problem, Date startOfProblem,
			Date endOfProblem, Identificator internalProblemId) {
		super(kindOfAllergy, problem, startOfProblem, endOfProblem, internalProblemId);
	}

	/**
	 * Instantiates a new allergy problem.
	 *
	 * @param allergyIntolerance
	 *            the allergy intolerance
	 */
	public AllergyProblem(AllergyIntolerance allergyIntolerance) {
		super(allergyIntolerance);
	}

}
