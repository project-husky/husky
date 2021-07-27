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

package org.ehealth_connector.xua.saml2;

/**
 *
 */
public interface SignatureBase extends Base {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method check if signature is set.</div>
	 * <div class="de">Methode um zu pruefen ob Signatur gesetzt ist.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *         <div class="en">true if signature element is set.</div>
	 *         <div class="de">wahr wenn Signatur Element vorhanden.</div>
	 *         <div class="fr"></div>
	 *         <div class="it"></div>
	 *         <!-- @formatter:on -->
	 */
	boolean hasSignature();

}
