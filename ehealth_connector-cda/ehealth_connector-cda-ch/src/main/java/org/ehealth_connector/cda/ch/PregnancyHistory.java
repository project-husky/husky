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

import org.ehealth_connector.cda.AbstractPregnancyHistory;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
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
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractPregnancyHistory#setInternalId(java.lang.String)
	 */
	@Override
	protected void setInternalId(String id) {
		final II ii = CdaChUtil.createUuidVacd(id);
		getMdhtPregnancy().getIds().add(ii);
	}

}
