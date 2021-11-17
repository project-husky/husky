/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
	public static final QName ELEMENT_NAME = new QName(DEFAULT_NS_URI, DEFAULT_ELEMENT_LOCAL_NAME,
			DEFAULT_PREFIX);

	/** Local name of the XSI type. */
	public static final String TYPE_LOCAL_NAME = "DeletePolicyRequest";

	/** QName of the XSI type. */
	public static final QName TYPE_NAME = new QName(DEFAULT_NS_URI, TYPE_LOCAL_NAME,
			DEFAULT_PREFIX);
}
