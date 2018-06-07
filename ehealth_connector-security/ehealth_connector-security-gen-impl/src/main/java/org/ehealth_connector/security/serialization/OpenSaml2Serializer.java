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
package org.ehealth_connector.security.serialization;

import org.ehealth_connector.security.exceptions.SerializeException;
import org.opensaml.core.xml.XMLObject;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the generic methods of OpenSaml2Serializer for the templated type T.</div>
 * <div class="de">Interface beschreibt die Methoden des OpenSaml2Serializer für den templated Typ T</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface OpenSaml2Serializer {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize an XMLObject to an byte array.</div>
	 * <div class="de">Methode um ein XMLObject in einen byte Array zu serialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aObject
	 * <div class="en">the XMLObject.</div>
	 * <div class="de">das XMLObject.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the serialized byte array.</div>
	 * <div class="de">das serialisierte byte Array.</div>
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
	 * <div class="de">das serialisierte String.</div>
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
	 * <div class="en">Method to serialize an XMLObject to an Element.</div>
	 * <div class="de">Methode um ein XMLObject in ein Element zu serialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aObject
	 * <div class="en">the XMLObject.</div>
	 * <div class="de">das XMLObject.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the serialized Element.</div>
	 * <div class="de">das serialisierte Element.</div>
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
