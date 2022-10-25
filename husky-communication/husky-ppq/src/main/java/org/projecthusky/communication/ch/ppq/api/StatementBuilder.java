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
package org.projecthusky.communication.ch.ppq.api;

import org.projecthusky.xua.saml2.SimpleBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the StatementBuilder.</div>
 * <div class="de">Interface welches die Methoden des StatementBuilder beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface StatementBuilder extends SimpleBuilder<XACMLPolicyStatementType> {

	// There are no special methods defined, but the interface has to be
	// declared for selection reasons.

}
