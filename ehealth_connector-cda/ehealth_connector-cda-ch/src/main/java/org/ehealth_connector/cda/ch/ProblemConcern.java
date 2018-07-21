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
package org.ehealth_connector.cda.ch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.BaseProblemConcern;
import org.ehealth_connector.cda.BaseProblemEntry;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="en">A class representing the problemconcern.</div>
 * <div class="de">Eine Klasse die die Problembelange representiert.</div>
 */
public class ProblemConcern extends BaseProblemConcern {

	/**
	 * Default constructor to instanciate the object.
	 */
	public ProblemConcern() {
	}

	/**
	 * Instantiates a new problem concern.
	 *
	 * @param problemConcernEntry
	 *            the problem concern entry
	 */
	public ProblemConcern(ProblemConcernEntry problemConcernEntry) {
		super(problemConcernEntry);
	}

	/**
	 * Instantiates a new problem concern.
	 *
	 * @param concern
	 *            the concern
	 * @param problemEntry
	 *            the problem entry
	 * @param concernStatus
	 *            the concern status
	 */
	public ProblemConcern(String concern, BaseProblemEntry problemEntry,
			ProblemConcernStatusCode concernStatus) {
		super(concern, problemEntry, concernStatus);
	}

	/**
	 * Instantiates a new problem concern.
	 *
	 * @param concern
	 *            the concern
	 * @param problemEntry
	 *            the problem entry
	 * @param concernStatus
	 *            the concern status
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 */
	public ProblemConcern(String concern, BaseProblemEntry problemEntry,
			ProblemConcernStatusCode concernStatus, Date start, Date end) {
		super(concern, problemEntry, concernStatus, start, end);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractConcern#addId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void addId(Identificator id) {
		final II ii = CdaChUtil.createUniqueIiFromIdentificator(id);
		getConcernEntry().getIds().add(ii);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.BaseProblemConcern#getProblemEntries()
	 */
	@Override
	public List<BaseProblemEntry> getProblemEntries() {
		final List<BaseProblemEntry> pel = new ArrayList<BaseProblemEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mAllergy : getMdhtProblemConcernEntry()
				.getProblemEntries()) {
			final BaseProblemEntry problem = new ProblemEntry(mAllergy);
			pel.add(problem);
		}
		return pel;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.BaseProblemConcern#getProblemEntry()
	 */
	@Override
	public BaseProblemEntry getProblemEntry() {
		final BaseProblemEntry problemEntry = new ProblemEntry(
				copyMdhtProblemConcernEntry().getProblemEntries().get(0));
		return problemEntry;
	}

}
