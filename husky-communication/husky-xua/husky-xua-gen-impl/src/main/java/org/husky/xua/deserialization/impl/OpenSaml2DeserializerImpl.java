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
package org.husky.xua.deserialization.impl;

import java.io.ByteArrayInputStream;
import java.util.Objects;

import org.husky.xua.deserialization.OpenSaml2Deserializer;
import org.husky.xua.exceptions.DeserializeException;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface OpenSaml2Deserializer<T> .</div>
 * <div class="de">Die Klasse implementiert das entsprechende interfaceOpenSaml2Deserializer<T> .</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class OpenSaml2DeserializerImpl<T> implements OpenSaml2Deserializer<T> {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.deserialization.OpenSaml2Deserializer#deserializeFromByteArray(byte[])
	 */
	@Override
	public T deserializeFromByteArray(byte[] aXmlBytes) throws DeserializeException {
		try {
			final var element = deserializeFromByteArrayToXmlElement(aXmlBytes);

			return deserializeFromXml(element);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.deserialization.OpenSaml2Deserializer#deserializeFromByteArrayToXmlElement(byte[])
	 */
	@Override
	public Element deserializeFromByteArrayToXmlElement(byte[] aXmlBytes) throws DeserializeException {
		try {
			// Use the parser from the OpenSAML ParserPool because its implementation may be different than
			// XmlFactories.newSafeDocumentBuilder()
			final var document = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool())
					.parse(new ByteArrayInputStream(aXmlBytes));
			return document.getDocumentElement();
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.deserialization.OpenSaml2Deserializer#deserializeFromString(java.lang.String)
	 */
	@Override
	public T deserializeFromString(String aXmlString) throws DeserializeException {
		return deserializeFromByteArray(aXmlString.getBytes());
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.deserialization.OpenSaml2Deserializer#deserializeFromXml(org.w3c.dom.Element)
	 */

	@SuppressWarnings("unchecked")
	@Override
	public T deserializeFromXml(Element aXmlElement) throws DeserializeException {
		try {
			final var marshallerFactory = XMLObjectProviderRegistrySupport
					.getUnmarshallerFactory();
			final var unmarshaller = marshallerFactory.getUnmarshaller(aXmlElement);

			return (T) Objects.requireNonNull(unmarshaller).unmarshall(aXmlElement);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
