/* **********************************************************************
 * ehealth_connector-security-gen-api
 *
 * Copyright (c) 2019
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */

package org.ehealth_connector.security.saml2;

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
