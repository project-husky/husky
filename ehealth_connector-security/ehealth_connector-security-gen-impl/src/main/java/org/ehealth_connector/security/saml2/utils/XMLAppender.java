/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.saml2.utils;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public final class XMLAppender {

	public static void addFragment(Element sourceElement, Element destinationElement) {

		final Document document = sourceElement.getOwnerDocument();
		final DocumentFragment docFrag = document.createDocumentFragment();
		final Element rootElement = document.getDocumentElement();
		if (rootElement != null) {
			docFrag.appendChild(rootElement);
			final Document ownerDoc = destinationElement.getOwnerDocument();
			final org.w3c.dom.Node replacingNode = ownerDoc.importNode(docFrag, true);
			destinationElement.appendChild(replacingNode);
		}
	}

}
