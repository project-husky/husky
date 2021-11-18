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

package org.husky.xua.saml2;

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
