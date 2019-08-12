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

import org.ehealth_connector.cda.AbstractConcern;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.common.mdht.Identificator;
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
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractConcern#addId(org.ehealth_connector.common.mdht.Identificator)
	 */
	@Override
	public void addId(Identificator id) {
		final II ii = CdaChUtil.createUniqueIiFromIdentificator(id);
		getConcernEntry().getIds().add(ii);
	}
}
