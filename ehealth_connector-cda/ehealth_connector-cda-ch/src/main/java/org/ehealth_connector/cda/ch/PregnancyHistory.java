/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

import java.util.Date;

import org.ehealth_connector.cda.AbstractPregnancyHistory;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.mdht.Identificator;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 *
 * <div class="en">A class representing the pregnancy history.</div>
 * <div class="de">Eine Klasse die die Schwangerschaftsgeschichte
 * representiert.</div>
 */
public class PregnancyHistory extends AbstractPregnancyHistory {

	/**
	 * Default constructor to instanciate the object.
	 */
	public PregnancyHistory() {
	}

	/**
	 * Instantiates a new pregnancy history.
	 *
	 * @param estimatedBirthDate
	 *            the estimated birth date
	 */
	public PregnancyHistory(Date estimatedBirthDate) {
		super(estimatedBirthDate);
	}

	/**
	 * Instantiates a new pregnancy history.
	 *
	 * @param pregnancy
	 *            the pregnancy
	 */
	public PregnancyHistory(PregnancyObservation pregnancy) {
		super(pregnancy);
	}

	/**
	 * Set an Identificator for the pregnancy history
	 *
	 * @param id
	 *            the Id to be used
	 */
	public void setId(Identificator id) {
		getMdhtPregnancy().getIds().clear();
		getMdhtPregnancy().getIds().add(id.getIi());

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractPregnancyHistory#setInternalId(java.lang.String)
	 */
	@Override
	protected void setInternalId(String id) {
		final II ii = CdaUtil.createUniqueIiFromString(id);
		getMdhtPregnancy().getIds().add(ii);
	}
}
