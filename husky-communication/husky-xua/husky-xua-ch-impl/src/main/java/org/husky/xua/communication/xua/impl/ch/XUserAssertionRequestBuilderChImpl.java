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
package org.husky.xua.communication.xua.impl.ch;

import org.husky.xua.ChEprXuaSpecifications;
import org.husky.xua.communication.xua.XUserAssertionRequestBuilder;
import org.husky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for XUserAssertionRequest building for Swiss EPR.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um XUserAssertionRequest bilden zu k&ooml;nnen für Swiss EPR.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionRequestBuilderChImpl extends XUserAssertionRequestBuilderImpl {

	public XUserAssertionRequestBuilderChImpl() {
		super();
		getClaims().setDialect(ChEprXuaSpecifications.CLAIMS_DIALECT);
	}

	@Override
	public XUserAssertionRequestBuilder dialect(String aDialect) {
		getClaims().setDialect(ChEprXuaSpecifications.CLAIMS_DIALECT);
		return this;
	}

	public XUserAssertionRequestBuilder principal(String principalId, String principalName) {
		if (principalId != null) {
			addXMLObjectToClaims(
					createStringAttribute(ChEprXuaSpecifications.PRINCIPAL_ID, principalId));
		}

		if (principalName != null) {
			addXMLObjectToClaims(createStringAttribute(ChEprXuaSpecifications.PRINCIPAL_NAME, principalName));
		}
		return this;
	}

}
