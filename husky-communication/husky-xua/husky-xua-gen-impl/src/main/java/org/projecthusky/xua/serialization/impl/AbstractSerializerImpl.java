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
package org.projecthusky.xua.serialization.impl;

import org.projecthusky.xua.serialization.OpenSaml2Serializer;

/**
 * Abstract implementation class with the common methods and fields.
 */
public abstract class AbstractSerializerImpl {

	/**
	 * The opensaml serializer
	 */
	private OpenSaml2Serializer openSamlSerializer;

	/**
	 * default constructor
	 */
	protected AbstractSerializerImpl() {
		openSamlSerializer = new OpenSaml2SerializerImpl();
	}

	/**
	 * method to get serializer
	 * 
	 * @return serializer
	 */
	public OpenSaml2Serializer getOpenSamlSerializer() {
		return openSamlSerializer;
	}

	/**
	 * method to set serializer
	 * 
	 * @param openSamlSerializer serializer
	 */
	public void setOpenSamlSerializer(OpenSaml2Serializer openSamlSerializer) {
		this.openSamlSerializer = openSamlSerializer;
	}

}
