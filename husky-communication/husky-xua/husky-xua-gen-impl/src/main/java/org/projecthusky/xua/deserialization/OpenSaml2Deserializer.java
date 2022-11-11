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
package org.projecthusky.xua.deserialization;

import org.projecthusky.xua.exceptions.DeserializeException;
import org.w3c.dom.Element;

/**
 * Interface describing the generic methods of OpenSaml2Deserializer for the
 * templated type T.
 * @param <T> the type
 * 
 */
public interface OpenSaml2Deserializer<T> {

	/**
	 * Generic method to deserialize type from byte array to instance of T.
	 * 
	 * @param aXmlBytes the byte array
	 * @return the instance of T
	 * @throws DeserializeException will be thrown on deserializing error
	 */
	T deserializeFromByteArray(byte[] aXmlBytes) throws DeserializeException;

	/**
	 * Generic method to deserialize type from byte array to xmlElement
	 * 
	 * @param aXmlBytes the byte array
	 * @return xmlElement instance of T
	 * @throws DeserializeException will be thrown on deserializing error
	 */
	Element deserializeFromByteArrayToXmlElement(byte[] aXmlBytes) throws DeserializeException;

	/**
	 * Generic method to deserialize type from string to instance of T.
	 * 
	 * @param aXmlString the string
	 * @return the instance of T
	 * @throws DeserializeException will be thrown on deserializing error
	 */
	T deserializeFromString(String aXmlString) throws DeserializeException;

	/**
	 * Generic method to deserialize type from xmlElement to instance of T.
	 * 
	 * @param aXmlElement the xmlElement
	 * @return the instance of T
	 * @throws DeserializeException will be thrown on deserializing error
	 */
	T deserializeFromXml(Element aXmlElement) throws DeserializeException;

}
