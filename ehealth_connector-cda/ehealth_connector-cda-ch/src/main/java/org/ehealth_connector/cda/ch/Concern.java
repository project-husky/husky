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
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch;

import org.ehealth_connector.cda.AbstractConcern;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="en">(Internal) class for concern entries</div>
 * <div class="de">Klasse ConcernEntry.</div> <div class="fr"></div>
 * <div class="it"></div>
 */
public class Concern extends AbstractConcern {

	/**
	 * Instantiates a new concern entry.
	 */
	public Concern() {

	}

	/**
	 * Instantiates a new concern entry.
	 * 
	 * @param concernEntry
	 *            <br>
	 *            <div class="de"> concern entry</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Concern(org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry concernEntry) {
		super(concernEntry);
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractConcern#addId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void addId(Identificator id) {
		final II ii = CdaChUtil.createUuidVacdIdentificator(id);
		getConcernEntry().getIds().add(ii);
	}
}
