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
package org.projecthusky.xua.hl7v3;

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
	public static final QName TYPE_NAME = new QName(DEFAULT_NS_URI, TYPE_LOCAL_NAME, "hl7");

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the value of the extension.</div>
	 * <div class="de">Methode um den Wert der extension zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The extension as string.</div>
	 * <div class="de">Die Extention als String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getExtension();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the value of the root.</div>
	 * <div class="de">Methode um den Wert von Root zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The root as string.</div>
	 * <div class="de">Die Root als String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getRoot();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the extension.</div>
	 * <div class="de">Methode um die Extension zu setzten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as extension.</div>
	 * <div class="de">Der wert der als Extesion gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setExtension(String value);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the root.</div>
	 * <div class="de">Methode um die Root zu setzten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as root.</div>
	 * <div class="de">Der wert der als Root gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setRoot(String value);

}
