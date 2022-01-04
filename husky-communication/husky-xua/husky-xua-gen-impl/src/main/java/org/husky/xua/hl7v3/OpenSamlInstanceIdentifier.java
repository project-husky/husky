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
package org.husky.xua.hl7v3;

import org.opensaml.core.xml.XMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the InstanceIdentifier Interface</div>
 * <div class="de">Beschreibung der Methoden des InstanceIdentifier Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface OpenSamlInstanceIdentifier extends InstanceIdentifier, XMLObject {

	// There are no special methods defined, but the interface has to be
	// declared for selection reasons.

}
