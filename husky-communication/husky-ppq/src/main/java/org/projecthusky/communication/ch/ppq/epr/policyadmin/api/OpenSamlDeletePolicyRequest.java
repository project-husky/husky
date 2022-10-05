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
package org.projecthusky.communication.ch.ppq.epr.policyadmin.api;

/**
* <!-- @formatter:off -->
* <div class="en">Extending interface to integrate DeletePolicyRequest interface to opensaml implementation.</div>
* <div class="de">Erweiterndes Interface um das DeletePolicyRequest Interface in OpenSAML Implementation zu integrieren.</div>
* <div class="fr"></div>
* <div class="it"></div>
* <!-- @formatter:on -->
*/
public interface OpenSamlDeletePolicyRequest
		extends DeletePolicyRequest, OpenSamlAssertionBasedRequest {
	// There are no special methods defined, but this intermediate interface has
	// to be declared for opensaml reasons
}
