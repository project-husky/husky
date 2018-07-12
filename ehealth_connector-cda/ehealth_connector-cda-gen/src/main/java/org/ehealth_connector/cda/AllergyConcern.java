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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="en">A class representing the allergy concern information.</div>
 * <div class="de">Eine Klasse die die Informationen zu Allergiebelangen
 * representiert.</div>
 */
public class AllergyConcern extends AbstractAllergyConcern {

	/**
	 * Default constructor to instanciate the object
	 */
	public AllergyConcern() {
	}

	/**
	 * Instantiates a new allergy concern.
	 *
	 * @param allergyConcern
	 *            the allergy concern
	 */
	public AllergyConcern(AllergyIntoleranceConcern allergyConcern) {
		super(allergyConcern);
	}

	/**
	 * Instantiates a new allergy concern.
	 *
	 * @param concern
	 *            the concern
	 * @param problemEntry
	 *            the problem entry
	 * @param concernStatus
	 *            the concern status
	 */
	public AllergyConcern(String concern, AbstractAllergyProblem problemEntry,
			ProblemConcernStatusCode concernStatus) {
		super(concern, problemEntry, concernStatus);
	}

	/**
	 * Instantiates a new allergy concern.
	 *
	 * @param concern
	 *            the concern
	 * @param begin
	 *            the begin
	 * @param end
	 *            the end
	 * @param problemEntry
	 *            the problem entry
	 * @param concernStatus
	 *            the concern status
	 */
	public AllergyConcern(String concern, Date begin, Date end, AbstractAllergyProblem problemEntry,
			ProblemConcernStatusCode concernStatus) {
		super(concern, begin, end, problemEntry, concernStatus);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractConcern#addId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void addId(Identificator id) {
		final II ii = CdaUtil.createUniqueIiFromIdentificator(id);
		getConcernEntry().getIds().add(ii);
	}

}
