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
package org.husky.xua.saml2;

import org.husky.xua.hl7v3.InstanceIdentifier;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of AttributeValue. </div>
 * <div class="de">Interface welches die Methoden von AttributeValue beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AttributeValue {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the FriendlyName.</div>
	 * <div class="de">Methode um das FriendlyName zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the FriendlyName as {@link java.lang.String}</div>
	 * <div class="de">der FriendlyName als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	InstanceIdentifier getInstanceIdentifier();

}
