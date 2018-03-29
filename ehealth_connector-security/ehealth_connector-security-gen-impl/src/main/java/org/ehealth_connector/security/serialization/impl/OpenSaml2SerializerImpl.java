/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.serialization.impl;

import java.io.ByteArrayOutputStream;

import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.serialization.OpenSaml2Serializer;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.Marshaller;
import org.opensaml.xml.io.MarshallerFactory;
import org.opensaml.xml.io.MarshallingException;
import org.w3c.dom.Element;

/**
 * @since Feb 21, 2018 10:26:58 AM
 *
 */
public class OpenSaml2SerializerImpl implements OpenSaml2Serializer {

	protected OpenSaml2SerializerImpl() {
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.utilities.SerializerDeserializer#serializeToByteArray(java.lang.Object)
	 */
	@Override
	public byte[] serializeToByteArray(XMLObject aXmlObject) throws SerializeException {
		return serializeToBytArrayOutputStream(aXmlObject).toByteArray();
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.utilities.SerializerDeserializer#serializeToString(java.lang.Object)
	 */
	@Override
	public String serializeToString(XMLObject aXmlObject) throws SerializeException {
		return serializeToBytArrayOutputStream(aXmlObject).toString();
	}

	private ByteArrayOutputStream serializeToBytArrayOutputStream(XMLObject aXmlObject) throws SerializeException {
		try {
			final Element element = serializeToXml(aXmlObject);

			final Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
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
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.utilities.SerializerDeserializer#serializeToXml(java.lang.Object)
	 */
	@Override
	public Element serializeToXml(XMLObject aXmlObject) throws SerializeException {
		try {
			final MarshallerFactory marshallerFactory = Configuration.getMarshallerFactory();

			final QName qName = aXmlObject.getElementQName();

			final Marshaller marshaller = marshallerFactory.getMarshaller(qName);

			return marshaller.marshall(aXmlObject);

		} catch (final MarshallingException e) {
			throw new SerializeException(e);
		}

	}
}
