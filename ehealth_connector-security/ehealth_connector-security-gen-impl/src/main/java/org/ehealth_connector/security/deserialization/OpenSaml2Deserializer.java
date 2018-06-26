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
 * <div class="en">Interface describing the generic methods of OpenSaml2Deserializer for the templated type T.</div>
 * <div class="de">Interface welches die Methoden des OpenSaml2Deserializer für den templated Typ T beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface OpenSaml2Deserializer<T> {

	T deserializeFromByteArray(byte[] aXmlBytes) throws DeserializeException;

	Element deserializeFromByteArrayToXmlElement(byte[] aXmlBytes) throws DeserializeException;

	T deserializeFromString(String aXmlString) throws DeserializeException;

	T deserializeFromXml(Element aXmlElement) throws DeserializeException;

}
