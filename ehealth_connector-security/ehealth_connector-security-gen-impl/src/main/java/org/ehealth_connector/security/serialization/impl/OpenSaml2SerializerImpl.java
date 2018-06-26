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
package org.ehealth_connector.security.serialization.impl;

import java.io.ByteArrayOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.serialization.OpenSaml2Serializer;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.MarshallerFactory;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of OpenSaml2Serializer</div>
 * <div class="de">Implementations Klasse von OpenSaml2Serializer</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class OpenSaml2SerializerImpl implements OpenSaml2Serializer {

	public OpenSaml2SerializerImpl() {
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
	}

	private ByteArrayOutputStream serializeToBytArrayOutputStream(XMLObject aXmlObject)
			throws SerializeException {
		try {
			final Element element = serializeToXml(aXmlObject);

			final Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "no");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(4));

			final ByteArrayOutputStream bas = new ByteArrayOutputStream();
			tr.transform(new DOMSource(element), new StreamResult(bas));

			return bas;
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.serialization.OpenSaml2Serializer#serializeToByteArray(org.opensaml.core.xml.XMLObject)
	 */
	@Override
	public byte[] serializeToByteArray(XMLObject aXmlObject) throws SerializeException {
		return serializeToBytArrayOutputStream(aXmlObject).toByteArray();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.serialization.OpenSaml2Serializer#serializeToString(org.opensaml.core.xml.XMLObject)
	 */
	@Override
	public String serializeToString(XMLObject aXmlObject) throws SerializeException {
		return serializeToBytArrayOutputStream(aXmlObject).toString();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.serialization.OpenSaml2Serializer#serializeToXml(org.opensaml.core.xml.XMLObject)
	 */
	@Override
	public Element serializeToXml(XMLObject aXmlObject) throws SerializeException {
		try {
			final MarshallerFactory marshallerFactory = XMLObjectProviderRegistrySupport
					.getMarshallerFactory();

			final Marshaller marshaller = marshallerFactory.getMarshaller(aXmlObject);

			return marshaller.marshall(aXmlObject);

		} catch (final MarshallingException | NullPointerException e) {
			throw new SerializeException(e);
		}

	}
}
