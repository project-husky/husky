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
package org.husky.xua.deserialization.impl;

import org.husky.xua.deserialization.Deserializer;
import org.husky.xua.deserialization.OpenSaml2Deserializer;

/**
 * Abstract implementation class with the common methods and fields.
 */
public abstract class AbstractDeserializerImpl<T, U> implements Deserializer<U> {
	private OpenSaml2Deserializer<T> openSamlDeserializer;

	/**
	 * default constructor
	 */
	protected AbstractDeserializerImpl() {
		openSamlDeserializer = new OpenSaml2DeserializerImpl<>();
	}

	/**
	 * Method to get deserializer
	 * 
	 * @return org.husky.xua.deserialization.OpenSaml2Deserializer
	 */
	protected OpenSaml2Deserializer<T> getOpenSamlDeserializer() {
		return openSamlDeserializer;
	}
}
