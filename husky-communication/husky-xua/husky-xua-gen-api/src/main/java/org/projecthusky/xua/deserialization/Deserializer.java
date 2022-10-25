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
