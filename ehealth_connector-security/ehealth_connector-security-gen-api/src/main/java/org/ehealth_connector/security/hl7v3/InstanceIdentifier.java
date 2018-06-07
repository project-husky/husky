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
 * <div class="en">Describing the methods of the InstanceIdentifier Interface</div>
 * <div class="de">Beschreibung der Methoden des InstanceIdentifier Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface InstanceIdentifier {

	/** Element local name. */
	public static final String DEFAULT_ELEMENT_LOCAL_NAME = "InstanceIdentifier";

	public static final String DEFAULT_NS_URI = "urn:hl7-org:v3";

	public static final String DEFAULT_PREFIX = "hl7";

	/** Default element name. */
	public static final QName ELEMENT_NAME = new QName(DEFAULT_NS_URI, DEFAULT_ELEMENT_LOCAL_NAME,
			DEFAULT_PREFIX);

	/** Local name of the XSI type. */
	public static final String TYPE_LOCAL_NAME = "InstanceIdentifier";

	/** QName of the XSI type. */
	public static final QName TYPE_NAME = new QName("urn:hl7-org:v3", TYPE_LOCAL_NAME, "hl7");

	/**
	 * Gets the value of the extension property.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getExtension();

	/**
	 * Gets the value of the root property.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getRoot();

	/**
	 * Sets the value of the extension property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setExtension(String value);

	/**
	 * Sets the value of the root property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setRoot(String value);

}
