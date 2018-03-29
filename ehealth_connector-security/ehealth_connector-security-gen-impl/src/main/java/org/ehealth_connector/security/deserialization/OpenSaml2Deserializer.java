/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.deserialization;

import org.ehealth_connector.security.exceptions.DeserializeException;
import org.opensaml.xml.XMLObject;
import org.w3c.dom.Element;

/**
 * @since Feb 21, 2018 10:24:01 AM
 *
 */
public interface OpenSaml2Deserializer {

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aXmlElement the xml element to be deserialized 
	 * @return the deserialized object
	 * @throws DeserializeException
	 */
	XMLObject deserializeFromXml(Element aXmlElement) throws DeserializeException;

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aXmlBytes the byte array containing the xml to be deserialized 
	 * @return the deserialized object
	 * @throws DeserializeException
	 */
	XMLObject deserializeFromByteArray(byte[] aXmlBytes) throws DeserializeException;

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aXmlBytes
	 * @return
	 * @throws DeserializeException
	 */
	public Element deserializeFromByteArrayToXmlElement(byte[] aXmlBytes) throws DeserializeException;

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aXmlString the string containing the xml
	 * @return the deserialized object
	 * @throws DeserializeException
	 */
	XMLObject deserializeFromString(String aXmlString) throws DeserializeException;

}
