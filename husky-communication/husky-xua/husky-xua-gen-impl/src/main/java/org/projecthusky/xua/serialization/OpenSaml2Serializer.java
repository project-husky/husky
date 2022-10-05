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
package org.projecthusky.xua.serialization;

import org.projecthusky.xua.exceptions.SerializeException;
import org.opensaml.core.xml.XMLObject;
import org.w3c.dom.Element;

/**
 * Interface describing the generic methods of OpenSaml2Serializer for the templated type T.
 */
public interface OpenSaml2Serializer {

	/**
	 * Gets the number of loaded marshallers.
	 *
	 * @return the marshaller count
	 */
	public Integer getLoadedMarshallerCount();

	/**
	 * Method to serialize an XMLObject to an byte array.
	 *
	 * @param aObject the XMLObject.
	 * @return the serialized byte array.
	 * @throws SerializeException throw on occuring errors.
	 */
	byte[] serializeToByteArray(XMLObject aObject) throws SerializeException;

	/**
	 * Method to serialize an XMLObject to a String.
	 *
	 * @param aObject the XMLObject.
	 * @return the serialized String.
	 * @throws SerializeException throw on occuring errors.
	 */
	String serializeToString(XMLObject aObject) throws SerializeException;

	/**
	 * Method to serialize an XMLObject to an xml element.
	 *
	 * @param aObject the XMLObject.
	 *
	 * @return the serialized xml element.
	 * @throws SerializeException throw on occuring errors.
	 */
	Element serializeToXml(XMLObject aObject) throws SerializeException;
}
