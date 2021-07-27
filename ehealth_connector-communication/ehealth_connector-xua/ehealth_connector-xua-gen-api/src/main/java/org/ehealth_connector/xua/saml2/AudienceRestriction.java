/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.xua.saml2;

import java.util.List;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of AudienceRestriction. </div>
 * <div class="de">Interface welches die Methoden von AudienceRestriction beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AudienceRestriction {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Audiences.</div>
	 * <div class="de">Methode um die Audiences zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link org.ehealth_connector.xua.saml2.Audience}s</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.ehealth_connector.xua.saml2.Audience}s</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<Audience> getAudiences();

}
