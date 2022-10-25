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

import org.opensaml.core.xml.XMLObject;

/**
* <!-- @formatter:off -->
* <div class="en">Extending interface to integrate UnknownPolicySetId interface to opensaml implementation.</div>
* <div class="de">Erweiterndes Interface um das UnknownPolicySetId Interface in OpenSAML Implementation zu integrieren.</div>
* <div class="fr"></div>
* <div class="it"></div>
* <!-- @formatter:on -->
*/
public interface OpenSamlUnknownPolicySetId extends UnknownPolicySetId, XMLObject {
	public void setMessage(String aMessage);
	// There are no special methods defined, but this intermediate interface has
	// to be declared for opensaml reasons
}
