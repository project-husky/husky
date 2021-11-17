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
package org.husky.xua.saml2;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of Status.</div>
 * <div class="de">Interface welches die Methoden von Status beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 *
 */
public interface Status {
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the StatusCode.</div>
	 * <div class="de">Methode um den StatusCode zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the StatusCode</div>
	 * <div class="de">den StatusCode</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	StatusCode getStatusCode();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the StatusMessage.</div>
	 * <div class="de">Methode um den StatusMessage zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the StatusMessage as {@link java.lang.String}</div>
	 * <div class="de">die StatusMessage als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getStatusMessage();
}
