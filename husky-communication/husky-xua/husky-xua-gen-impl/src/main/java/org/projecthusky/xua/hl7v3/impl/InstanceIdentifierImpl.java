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
package org.projecthusky.xua.hl7v3.impl;

import java.util.LinkedList;
import java.util.List;

import org.projecthusky.xua.hl7v3.OpenSamlInstanceIdentifier;
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
public class InstanceIdentifierImpl extends AbstractXMLObject implements OpenSamlInstanceIdentifier {

	/**
	 * the extension
	 */
	protected String extension;
	/**
	 * the root
	 */
	protected String root;

	/**
	 * Constructor with params.
	 * 
	 * @param namespaceURI     the namespace URI
	 * @param elementLocalName the elemetn local name
	 * @param namespacePrefix  the prefix
	 */
	protected InstanceIdentifierImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}

	@Override
	public String getExtension() {
		return extension;
	}

	@Override
	public List<XMLObject> getOrderedChildren() {
		return new LinkedList<>();
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
