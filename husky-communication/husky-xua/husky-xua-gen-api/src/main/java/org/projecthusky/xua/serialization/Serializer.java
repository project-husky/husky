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
