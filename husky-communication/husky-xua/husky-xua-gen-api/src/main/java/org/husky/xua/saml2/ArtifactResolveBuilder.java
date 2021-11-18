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
