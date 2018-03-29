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
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface OpenSaml2Serializer {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 *
	 * @param aObject the typed object to be serialized
	 * @return the serialized xml
	 * @throws SerializeException
	 */
	Element serializeToXml(XMLObject aObject) throws SerializeException;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 *
	 * @param aObject the typed object to be serialized
	 * @return the serialized xml string
	 * @throws SerializeException
	 */
	String serializeToString(XMLObject aObject) throws SerializeException;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 *
	 * @param aObject the typed object to be serialized
	 * @return the serialized xml as byte array
	 * @throws SerializeException
	 */
	byte[] serializeToByteArray(XMLObject aObject) throws SerializeException;
}
