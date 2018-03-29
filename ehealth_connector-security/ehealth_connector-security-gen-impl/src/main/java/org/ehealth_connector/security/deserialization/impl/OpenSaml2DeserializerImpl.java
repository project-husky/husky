/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.deserialization.impl;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.ehealth_connector.security.deserialization.OpenSaml2Deserializer;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.Unmarshaller;
import org.opensaml.xml.io.UnmarshallerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @since Feb 21, 2018 10:26:58 AM
 *
 */
public class OpenSaml2DeserializerImpl implements OpenSaml2Deserializer {

	protected OpenSaml2DeserializerImpl() {
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.utilities.SerializerDeserializer#deserializeFromString(java.lang.String)
	 */
	@Override
	public XMLObject deserializeFromString(String aXmlString) throws DeserializeException {
		return deserializeFromByteArray(aXmlString.getBytes());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.utilities.SerializerDeserializer#deserializeFromByteArray(byte[])
	 */
	@Override
	public XMLObject deserializeFromByteArray(byte[] aXmlBytes) throws DeserializeException {
		try {
			final Element element = deserializeFromByteArrayToXmlElement(aXmlBytes);

			return deserializeFromXml(element);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.utilities.SerializerDeserializer#deserializeFromXml(org.w3c.dom.Element)
	 */
	@Override
	public XMLObject deserializeFromXml(Element aXmlElement) throws DeserializeException {
		try {
			final UnmarshallerFactory marshallerFactory = Configuration.getUnmarshallerFactory();
			final Unmarshaller unmarshaller = marshallerFactory.getUnmarshaller(aXmlElement);

			return unmarshaller.unmarshall(aXmlElement);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.deserialization.OpenSaml2Deserializer#deserializeFromByteArrayToXmlElement(byte[])
	 */
	@Override
	public Element deserializeFromByteArrayToXmlElement(byte[] aXmlBytes) throws DeserializeException {
		final String FEATURE = "http://xml.org/sax/features/external-general-entities";
		try {
			final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			documentBuilderFactory.setFeature(FEATURE, false);
			final DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
			final Document document = docBuilder.parse(new ByteArrayInputStream(aXmlBytes));

			return document.getDocumentElement();
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
