/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.husky.xua.serialization;

import org.husky.xua.exceptions.SerializeException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Typed interface describing some generic methods for serializing model instances to different serialized forms.</div>
 * <div class="de">Typisiertes Interface welches die Methoden für die Serialisierung von Modell Instanzen in verschiedene Formen der Serialisierung beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * @param <T>
 * <div class="en">the type of instance the methods should deal with.</div>
 * <div class="de">der Typ der Instanz auf welchen die Methoden Anwendung finden.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface Serializer<T> {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize the instance of T into an byte array.</div>
	 * <div class="de">Methode um eine Instanz von T in ein Byte Array zu serialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSecurityObject
	 * <div class="en">the instance to be serialized</div>
	 * <div class="de">die Instanz die serialisert werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the serialized instance as byte array</div>
	 * <div class="de">die serialisierte Instanz als Byte Array</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">will be thrown when an error occures serializing the object</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Serialisieren des Objektes auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	byte[] toXmlByteArray(T aSecurityObject) throws SerializeException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize the instance of T into an xml structure.</div>
	 * <div class="de">Methode um eine Instanz von T in eine XML Struktur zu serialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSecurityObject
	 * <div class="en">the isntance to be serialized</div>
	 * <div class="de">die Instanz die serialisert werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the serialized instance as xml structure</div>
	 * <div class="de">die serialisierte Instanz als XML Struktur</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">will be thrown when an error occures serializing the object</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Serialisieren des Objektes auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Element toXmlElement(T aSecurityObject) throws SerializeException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize the instance of T into a string.</div>
	 * <div class="de">Methode um eine Instanz von T in einen string zu serialisieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSecurityObject
	 * <div class="en">the instance to be serialized</div>
	 * <div class="de">die Instanz die serialisert werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the serialized instance a string</div>
	 * <div class="de">die serialisierte Instanz als string</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">will be thrown when an error occures serializing the object</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Serialisieren des Objektes auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String toXmlString(T aSecurityObject) throws SerializeException;

}
