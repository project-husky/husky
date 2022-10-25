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
package org.projecthusky.xua.communication.xua.impl.ch;

import org.projecthusky.xua.ChEprXuaSpecifications;
import org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder;
import org.projecthusky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;

/**
 * Class implementing the corresponding interface for XUserAssertionRequest building for Swiss EPR.
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
