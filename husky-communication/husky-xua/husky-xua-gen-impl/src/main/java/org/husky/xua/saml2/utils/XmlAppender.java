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
package org.husky.xua.saml2.utils;

import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Helper class providing methods to add a fragment of an xml document to an other xml element as child.</div>
 * <div class="de">Helferklasse welche Methoden für das Kopieren von XML Teilen in ein Element als Kind zur Verfügung stellt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public final class XmlAppender {

	private XmlAppender() {
		throw new IllegalStateException("This is a utility class!");
	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to attach a xml fragment to an other xml element.</div>
	 * <div class="de">Method um ein xml Fragment an eine anderes xml element anzuhängen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param sourceElement
	 * <div class="en">The xml fragment</div>
	 * <div class="de">Das xml Fragment</div>
	 * @param destinationElement
	 * <div class="en">The xml element the fragment will be attached.</div>
	 * <div class="de">Das xml Element an den das Fragment angehängt werden soll.</div>
	 * <!-- @formatter:on -->
	 */
	public static void addFragment(Element sourceElement, Element destinationElement) {

		final var document = sourceElement.getOwnerDocument();
		final var docFrag = document.createDocumentFragment();
		final var rootElement = document.getDocumentElement();
		if (rootElement != null) {
			docFrag.appendChild(rootElement);
			final var ownerDoc = destinationElement.getOwnerDocument();
			final var replacingNode = ownerDoc.importNode(docFrag, true);
			destinationElement.appendChild(replacingNode);
		}
	}

}
