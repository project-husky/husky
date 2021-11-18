/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
