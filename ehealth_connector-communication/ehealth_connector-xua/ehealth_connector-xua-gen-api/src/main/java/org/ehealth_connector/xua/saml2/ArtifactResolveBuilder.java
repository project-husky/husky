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

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the AssertionBuilder. </div>
 * <div class="de">Interface welches die Methoden des AssertionBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface ArtifactResolveBuilder extends BaseBuilder<ArtifactResolveBuilder> {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add an Artifact to the ArtifactResolve to be build.</div>
	 * <div class="de">Methode um ein Artifact dem ArtifactResolve hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aArtifact
	 * <div class="en">the Artifact to be added.</div>
	 * <div class="de">das Artifact welches hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public ArtifactResolveBuilder artifact(String aArtifact);
}
