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
package org.ehealth_connector.xua.saml2.utils;

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
