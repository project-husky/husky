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
package org.projecthusky.xua.deserialization.impl;

import org.projecthusky.xua.deserialization.Deserializer;
import org.projecthusky.xua.deserialization.OpenSaml2Deserializer;

/**
 * Abstract implementation class with the common methods and fields.
 *
 * @param <T> the type of the object
 * @param <U> the type of the object for deserializing
 */
public abstract class AbstractDeserializerImpl<T, U> implements Deserializer<U> {
	private OpenSaml2Deserializer<T> openSamlDeserializer;

	/**
	 * Default constructor
	 */
	protected AbstractDeserializerImpl() {
		openSamlDeserializer = new OpenSaml2DeserializerImpl<>();
	}

	/**
	 * Method to get deserializer.
	 * 
	 * @return org.projecthusky.xua.deserialization.OpenSaml2Deserializer
	 */
	protected OpenSaml2Deserializer<T> getOpenSamlDeserializer() {
		return openSamlDeserializer;
	}
}
