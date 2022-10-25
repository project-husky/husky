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
package org.projecthusky.xua.saml2;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of ArtifactResolve. </div>
 * <div class="de">Interface welches die Methoden von ArtifactResolve beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface ArtifactResolve extends Base {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Artifact.</div>
	 * <div class="de">Methode um das Artifact zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Artifact as {@link java.lang.String}</div>
	 * <div class="de">der Artifact als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getArtifact();
}
