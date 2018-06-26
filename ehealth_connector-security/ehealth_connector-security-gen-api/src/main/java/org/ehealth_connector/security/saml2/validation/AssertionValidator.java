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
package org.ehealth_connector.security.saml2.validation;

import org.ehealth_connector.security.saml2.Assertion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the Methods for the validation of Assertions.</div>
 * <div class="de">Interface welches die Methoden für die Validierung von Assertions beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AssertionValidator extends GenericValidator<Assertion> {

	// There are no special methods defined, but the interface has to be
	// declared for selection reasons.

}
