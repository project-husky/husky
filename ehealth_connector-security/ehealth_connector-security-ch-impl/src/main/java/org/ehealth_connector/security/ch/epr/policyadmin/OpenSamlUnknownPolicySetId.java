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
package org.ehealth_connector.security.ch.epr.policyadmin;

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
	// There are no special methods defined, but this intermediat interface has
	// to be declared for opensaml reasons
}
