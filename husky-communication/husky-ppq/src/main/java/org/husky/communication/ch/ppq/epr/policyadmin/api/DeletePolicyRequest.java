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
 * <div class="en">Describing the methods of the DeletePolicyRequest Interface</div>
 * <div class="de">Beschreibung der Methoden des DeletePolicyRequest Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface DeletePolicyRequest extends AssertionBasedRequest {
	/** Element local name. */
	public static final String DEFAULT_ELEMENT_LOCAL_NAME = "DeletePolicyRequest";

	/** Default element name. */
	public static final QName ELEMENT_NAME = new QName(PolicyAdministrationConstants.DEFAULT_NS_URI,
			DEFAULT_ELEMENT_LOCAL_NAME,
			PolicyAdministrationConstants.DEFAULT_PREFIX);

	/** Local name of the XSI type. */
	public static final String TYPE_LOCAL_NAME = "DeletePolicyRequest";

	/** QName of the XSI type. */
	public static final QName TYPE_NAME = new QName(PolicyAdministrationConstants.DEFAULT_NS_URI, TYPE_LOCAL_NAME,
			PolicyAdministrationConstants.DEFAULT_PREFIX);
}
