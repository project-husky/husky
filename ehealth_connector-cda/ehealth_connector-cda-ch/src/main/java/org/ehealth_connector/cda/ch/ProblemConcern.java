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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.AbstractProblemConcern;
import org.ehealth_connector.cda.AbstractProblemEntry;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="en">A class representing the problemconcern.</div>
 * <div class="de">Eine Klasse die die Problembelange representiert.</div>
 */
public class ProblemConcern extends AbstractProblemConcern {

	/**
	 * Default constructor to instanciate the object.
	 */
	public ProblemConcern() {
	}

	/**
	 * Instantiates a new problem concern.
	 *
	 * @param problemConcernEntry
	 *          the problem concern entry
	 */
	public ProblemConcern(ProblemConcernEntry problemConcernEntry) {
		super(problemConcernEntry);
	}

	/**
	 * Instantiates a new problem concern.
	 *
	 * @param concern
	 *          the concern
	 * @param problemEntry
	 *          the problem entry
	 * @param concernStatus
	 *          the concern status
	 */
	public ProblemConcern(String concern, AbstractProblemEntry problemEntry,
			ProblemConcernStatusCode concernStatus) {
		super(concern, problemEntry, concernStatus);
	}

	/**
	 * Instantiates a new problem concern.
	 *
	 * @param concern
	 *          the concern
	 * @param problemEntry
	 *          the problem entry
	 * @param concernStatus
	 *          the concern status
	 * @param start
	 *          the start
	 * @param end
	 *          the end
	 */
	public ProblemConcern(String concern, AbstractProblemEntry problemEntry,
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
		final II ii = CdaChUtil.createUuidVacdIdentificator(id);
		getConcernEntry().getIds().add(ii);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractProblemConcern#getProblemEntries()
	 */
	@Override
	public List<AbstractProblemEntry> getProblemEntries() {
		final List<AbstractProblemEntry> pel = new ArrayList<AbstractProblemEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mAllergy : getMdhtProblemConcernEntry()
				.getProblemEntries()) {
			final AbstractProblemEntry problem = new ProblemEntry(mAllergy);
			pel.add(problem);
		}
		return pel;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractProblemConcern#getProblemEntry()
	 */
	@Override
	public AbstractProblemEntry getProblemEntry() {
		final AbstractProblemEntry problemEntry = new ProblemEntry(
				copyMdhtProblemConcernEntry().getProblemEntries().get(0));
		return problemEntry;
	}

}
