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
package org.husky.xua.saml2;

import java.util.List;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the Conditions methods.</div>
 * <div class="de">Interface welches die Conditions Methoden beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface Conditions {
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the AudienceRestriction.</div>
	 * <div class="de">Methode um die AudienceRestriction zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link org.husky.xua.saml2.AudienceRestriction}s</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.husky.xua.saml2.AudienceRestriction}s</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<AudienceRestriction> getAudienceRestrictions();
}
