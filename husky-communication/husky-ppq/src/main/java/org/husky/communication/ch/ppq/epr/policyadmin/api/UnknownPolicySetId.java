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
package org.husky.communication.ch.ppq.epr.policyadmin.api;

import javax.xml.namespace.QName;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the UnknownPolicySetId Interface</div>
 * <div class="de">Beschreibung der Methoden des UnknownPolicySetId Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface UnknownPolicySetId extends BasePolicyAdministration {

	/** Element local name. */
	public static final String DEFAULT_ELEMENT_LOCAL_NAME = "UnknownPolicySetId";

	/** Default element name. */
	public static final QName ELEMENT_NAME = new QName(DEFAULT_NS_URI, DEFAULT_ELEMENT_LOCAL_NAME,
			DEFAULT_PREFIX);

	/** Local name of the XSI type. */
	public static final String TYPE_LOCAL_NAME = "UnknownPolicySetId";

	/** QName of the XSI type. */
	public static final QName TYPE_NAME = new QName(DEFAULT_NS_URI, TYPE_LOCAL_NAME,
			DEFAULT_PREFIX);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the message out of the UnknownPolicySetId.</div>
	 * <div class="de">Methode um die Nachricht aus dem UnknownPolicySetId zu lesen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The status of the response.</div>
	 * <div class="de">Der Status der Response.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getMessage();
}
