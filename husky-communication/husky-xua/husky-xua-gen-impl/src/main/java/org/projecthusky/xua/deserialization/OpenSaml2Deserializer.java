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
 * Interface describing the generic methods of OpenSaml2Deserializer for the templated type T.
 */
public interface OpenSaml2Deserializer<T> {

	T deserializeFromByteArray(byte[] aXmlBytes) throws DeserializeException;

	Element deserializeFromByteArrayToXmlElement(byte[] aXmlBytes) throws DeserializeException;

	T deserializeFromString(String aXmlString) throws DeserializeException;

	T deserializeFromXml(Element aXmlElement) throws DeserializeException;

}
