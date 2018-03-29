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
package org.ehealth_connector.security.communication.xua.impl.ch;

import org.ehealth_connector.security.XUserAssertionConstantsCh;
import org.ehealth_connector.security.communication.xua.XUserAssertionRequestBuilder;
import org.ehealth_connector.security.communication.xua.impl.XUserAssertionRequestBuilderImpl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for XUserAssertionRequest building for Swiss EPR.</div>
 * <div class="de">Die Klasse implementiert das entsprechende interface um XUserAssertionRequest bilden zu k&ooml;nnen für Swiss EPR.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionRequestBuilderChImpl extends XUserAssertionRequestBuilderImpl {

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.xua.XUserAssertionRequestBuilder#dialect(java.lang.String)
	 */
	@Override
	public XUserAssertionRequestBuilder dialect(String aDialect) {
		getClaims().setDialect(XUserAssertionConstantsCh.CH_EPR_2017_ANNEX5_ADDENDUM2);
		return this;
	}

}
