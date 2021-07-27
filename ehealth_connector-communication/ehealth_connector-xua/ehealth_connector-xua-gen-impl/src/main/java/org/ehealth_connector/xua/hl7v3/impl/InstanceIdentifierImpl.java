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
package org.ehealth_connector.xua.hl7v3.impl;

import java.util.List;

import org.ehealth_connector.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface OpenSaml InstanceIdentifier.</div>
 * <div class="de">Implementations Klasse des Interfaces OpenSaml InstanceIdentifier.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class InstanceIdentifierImpl extends AbstractXMLObject
		implements OpenSamlInstanceIdentifier {

	protected String extension;
	protected String root;

	protected InstanceIdentifierImpl(String namespaceURI, String elementLocalName,
			String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}

	@Override
	public String getExtension() {
		return extension;
	}

	@Override
	public List<XMLObject> getOrderedChildren() {
		return null;
	}

	@Override
	public String getRoot() {
		return root;
	}

	@Override
	public void setExtension(String value) {
		extension = value;
	}

	@Override
	public void setRoot(String value) {
		root = value;
	}
}
