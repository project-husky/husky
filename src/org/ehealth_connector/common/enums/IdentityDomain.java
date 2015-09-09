/* **********************************************************************
 * Author: pkistler
 * Date  : Jul 14, 2015
 * File  : IndentityDomain.java
 * **********************************************************************
 * ehealth_connector-common
 *
 * Copyright (c) 2015
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * 
 * This code is made available under the terms of the Eclipse Public License v1.0.
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 * **********************************************************************
 */

package org.ehealth_connector.common.enums;

/**
 * Interface for CodeSystems
 * 
 * @author pkistler 
 * @version 1.0
 * @created Jul 14, 2015 3:28:44 PM
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
