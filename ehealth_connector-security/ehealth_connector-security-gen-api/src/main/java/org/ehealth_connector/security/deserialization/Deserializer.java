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
package org.ehealth_connector.security.deserialization;

import org.ehealth_connector.security.exceptions.DeserializeException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Typed interface describing the methods for deserializing elements.</div>
 * <div class="de">Interface welches die Methoden für das Deserialisieren von Elemente beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface Deserializer<T> {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to deserialize from an xml String to the to T corresponding model.</div>
	 * <div class="de">Methode um von einem XML String zu einer dem T entsprechenden Modell zu deserialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aByteArray
	 * <div class="en">Method to deserialize the xml byte array</div>
	 *  <div class="de">Methode um das XML Byte Array zu deserialisieren</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 * 	<div class="en">the type T deserialized from xml byte array</div>
	 *  <div class="de">Der typ T deserialisiert vom XML Byte Array</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @throws DeserializeException
	 * 	<div class="en">will be thrown when an error occures on deserialization</div>
	 *  <div class="de">wird geworfen wenn beim Deserialisieren ein Fehler auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	T fromXmlByteArray(byte[] aByteArray) throws DeserializeException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to deserialize from an xml Element to the to T corresponding model.</div>
	 * <div class="de">Methode um von einem XML Element zu einer dem T entsprechenden Modell zu deserialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aXmlElement
	 *  <div class="en">Method to deserialize the xml Element</div>
	 *  <div class="de">Methode um das XML Element zu deserialisieren</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 * 	<div class="en">the type T deserialized from xml Element</div>
	 *  <div class="de">Der Typ T deserialisiert vom XML Element</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @throws DeserializeException
	 * 	<div class="en">will be thrown when an error occures on deserialization</div>
	 *  <div class="de">wird geworfen wenn beim Deserialisieren ein Fehler auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	T fromXmlElement(Element aXmlElement) throws DeserializeException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to deserialize from an xml String to the to T corresponding model.</div>
	 * <div class="de">Methode um von einem XML String zu einer dem T entsprechenden Modell zu deserialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aXmlString
	 *  <div class="en">Method to deserialize the xml String</div>
	 *  <div class="de">Methode um das XML String zu deserialisieren</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 * 	<div class="en">the type T deserialized from xml String</div>
	 *  <div class="de">Der Typ T deserialisiert vom XML String</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @throws DeserializeException
	 * 	<div class="en">will be thrown when an error occures on deserialization</div>
	 *  <div class="de">wird geworfen wenn beim Deserialisieren ein Fehler auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	T fromXmlString(String aXmlString) throws DeserializeException;

}
