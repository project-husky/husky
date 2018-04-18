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
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface PurposeOfUse {

	/** Element local name. */
	public static final String DEFAULT_ELEMENT_LOCAL_NAME = "PurposeOfUse";

	public static final String DEFAULT_NS_URI = "urn:hl7-org:v3";

	public static final String DEFAULT_PREFIX = "hl7";

	/** Default element name. */
	public static final QName ELEMENT_NAME = new QName(DEFAULT_NS_URI, DEFAULT_ELEMENT_LOCAL_NAME, DEFAULT_PREFIX);

	/** Local name of the XSI type. */
	public static final String TYPE_LOCAL_NAME = "PurposeOfUse";

	/** QName of the XSI type. */
	public static final QName TYPE_NAME = new QName("urn:hl7-org:v3", TYPE_LOCAL_NAME, "hl7");

	/**
	 * Gets the value of the code property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCode();

	/**
	 * Sets the value of the code property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCode(String value);

	/**
	 * Gets the value of the codeSystem property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodeSystem();

	/**
	 * Sets the value of the codeSystem property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodeSystem(String value);

	/**
	 * Gets the value of the codeSystemName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodeSystemName();

	/**
	 * Sets the value of the codeSystemName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodeSystemName(String value);

	/**
	 * Gets the value of the codeSystemVersion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodeSystemVersion();

	/**
	 * Sets the value of the codeSystemVersion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodeSystemVersion(String value);

	/**
	 * Gets the value of the displayName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDisplayName();

	/**
	 * Sets the value of the displayName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDisplayName(String value);
}
