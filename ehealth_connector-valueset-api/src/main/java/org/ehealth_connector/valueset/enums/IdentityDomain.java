/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.valueset.enums;

/**
 * Interface for CodeSystems
 * 
 */
public interface IdentityDomain {
	/**
	 * @return <div class="en">Delivers the code systems OID value</div>
	 */
	String getCodeSystemId();

	/**
	 * @return <div class="en">Delivers the codes system textual content</div>
	 */
	String getCodeSystemName();
}
