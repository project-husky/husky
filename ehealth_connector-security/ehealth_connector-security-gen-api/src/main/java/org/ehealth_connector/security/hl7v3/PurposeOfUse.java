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
package org.ehealth_connector.security.hl7v3;

import javax.xml.namespace.QName;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the PurposeOfUse Interface</div>
 * <div class="de">Beschreibung der Methoden des PurposeOfUse Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PurposeOfUse {

	/** Element local name. */
	public static final String DEFAULT_ELEMENT_LOCAL_NAME = "PurposeOfUse";

	public static final String DEFAULT_NS_URI = "urn:hl7-org:v3";

	public static final String DEFAULT_PREFIX = "hl7";

	/** Default element name. */
	public static final QName ELEMENT_NAME = new QName(DEFAULT_NS_URI, DEFAULT_ELEMENT_LOCAL_NAME,
			DEFAULT_PREFIX);

	/** Local name of the XSI type. */
	public static final String TYPE_LOCAL_NAME = "PurposeOfUse";

	/** QName of the XSI type. */
	public static final QName TYPE_NAME = new QName("urn:hl7-org:v3", TYPE_LOCAL_NAME, "hl7");

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the code.</div>
	 * <div class="de">Methode um den code zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The Code.</div>
	 * <div class="de">Der Code.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getCode();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the CodeSystem.</div>
	 * <div class="de">Methode um das CodeSystem zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The CodeSystem.</div>
	 * <div class="de">Das CodeSystem.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getCodeSystem();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the CodeSystemName.</div>
	 * <div class="de">Methode um den CodeSystemName zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The CodeSystemName.</div>
	 * <div class="de">Der CodeSystemName.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getCodeSystemName();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the CodeSystemVersion.</div>
	 * <div class="de">Methode um die CodeSystemVersion zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The CodeSystemVersion.</div>
	 * <div class="de">Die CodeSystemVersion.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getCodeSystemVersion();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the DisplayName.</div>
	 * <div class="de">Methode um den DisplayName zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The DisplayName.</div>
	 * <div class="de">Der DisplayName.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getDisplayName();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the Code.</div>
	 * <div class="de">Methode um den Code zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as Code.</div>
	 * <div class="de">Der Wert der als Code gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setCode(String value);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the CodeSystem.</div>
	 * <div class="de">Methode um das CodeSystem zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as CodeSystem.</div>
	 * <div class="de">Der Wert der als CodeSystem gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setCodeSystem(String value);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the CodeSystemName.</div>
	 * <div class="de">Methode um den CodeSystemName zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as CodeSystemName.</div>
	 * <div class="de">Der Wert der als CodeSystemName gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setCodeSystemName(String value);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the CodeSystemVersion.</div>
	 * <div class="de">Methode um die CodeSystemVersion zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as CodeSystemVersion.</div>
	 * <div class="de">Der Wert der als CodeSystemVersion gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setCodeSystemVersion(String value);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the DisplayName.</div>
	 * <div class="de">Methode um den DisplayName zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as DisplayName.</div>
	 * <div class="de">Der Wert der als DisplayName gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setDisplayName(String value);
}
