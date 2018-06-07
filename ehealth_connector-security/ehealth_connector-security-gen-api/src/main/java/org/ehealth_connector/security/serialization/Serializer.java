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
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Typed interface describing some generic methods for serializing model instances to different serialized forms.</div>
 * <div class="de">Typisiertes Interface beschreibend die Methoden für die Serialisierung von Modell instanzen in verschiedene formen der serialisierung.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * @param <T>
 * <div class="en">the type of instance the methods should hanlde with.</div>
 * <div class="de">der Typ der Instanz auf die Methoden Anwendung finden </div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface Serializer<T> {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize the instance of T into an byte array.</div>
	 * <div class="de">Methode um eine Instanz von T in einen byte array zu serialisieren.</div>
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
	 * <div class="de">die serialisierte Instanz als byte array</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">will be thrown when an error occures serializing the object</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim serialisieren des Objektes auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	byte[] toXmlByteArray(T aSecurityObject) throws SerializeException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to serialize the instance of T into an xml structure.</div>
	 * <div class="de">Methode um eine Instanz von T in eine xml struktur zu serialisieren.</div>
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
	 * <div class="de">die serialisierte Instanz als xml Struktur</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">will be thrown when an error occures serializing the object</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim serialisieren des Objektes auftritt</div>
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
	 *  <div class="de">wird geworfen wenn ein Fehler beim serialisieren des Objektes auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String toXmlString(T aSecurityObject) throws SerializeException;

}
