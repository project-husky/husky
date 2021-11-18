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
package org.husky.xua.serialization;

import org.husky.xua.exceptions.SerializeException;
import org.opensaml.core.xml.XMLObject;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the generic methods of OpenSaml2Serializer for the templated type T.</div>
 * <div class="de">Interface welches die Methoden des OpenSaml2Serializer für den templated Typ T beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface OpenSaml2Serializer {

	/**
	 * Gets the number of loaded marshallers.
	 *
	 * @return the marshaller count
	 */
	public Integer getLoadedMarshallerCount();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize an XMLObject to an byte array.</div>
	 * <div class="de">Methode um ein XMLObject in ein Byte Array zu serialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aObject
	 * <div class="en">the XMLObject.</div>
	 * <div class="de">das XMLObject.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the serialized byte array.</div>
	 * <div class="de">das serialisierte Byte Array.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">throw on occuring errors.</div>
	 * <div class="de">wird bei auftretenden Fehlern geworfen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	byte[] serializeToByteArray(XMLObject aObject) throws SerializeException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize an XMLObject to a String.</div>
	 * <div class="de">Methode um ein XMLObject in einen String zu serialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aObject
	 * <div class="en">the XMLObject.</div>
	 * <div class="de">das XMLObject.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the serialized String.</div>
	 * <div class="de">der serialisierte String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">throw on occuring errors.</div>
	 * <div class="de">wird bei auftretenden Fehlern geworfen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String serializeToString(XMLObject aObject) throws SerializeException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize an XMLObject to an xml element.</div>
	 * <div class="de">Methode um ein XMLObject in ein XML Element zu serialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aObject
	 * <div class="en">the XMLObject.</div>
	 * <div class="de">das XMLObject.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the serialized xml element.</div>
	 * <div class="de">das serialisierte XML Element.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">throw on occuring errors.</div>
	 * <div class="de">wird bei auftretenden Fehlern geworfen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Element serializeToXml(XMLObject aObject) throws SerializeException;
}
