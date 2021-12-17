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
package org.husky.xua.serialization.impl;

import java.io.ByteArrayOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.husky.common.utils.xml.XmlFactories;
import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.serialization.OpenSaml2Serializer;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

/**
 * Implementation class of OpenSaml2Serializer
 */
public class OpenSaml2SerializerImpl implements OpenSaml2Serializer {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.OpenSaml2Serializer#getLoadedMarshallerCount()
	 */
	@Override
	public Integer getLoadedMarshallerCount() {
		Integer retVal = 0;
		try {
			final var marshallerFactory = XMLObjectProviderRegistrySupport
					.getMarshallerFactory();
			if (marshallerFactory != null) {
				retVal = marshallerFactory.getMarshallers().size();
			}
		} catch (Exception e) {
			// Do nothing
		}
		return retVal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.OpenSaml2Serializer#serializeToByteArray(org.opensaml.core.xml.XMLObject)
	 */
	@Override
	public byte[] serializeToByteArray(XMLObject aXmlObject) throws SerializeException {
		return serializeToByteArrayOutputStream(aXmlObject).toByteArray();
	}

	/**
	 * Serialize to byte array output stream.
	 *
	 * @param aXmlObject
	 *            the a xml object
	 * @return the byte array output stream
	 * @throws SerializeException
	 *             the serialize exception
	 */
	private ByteArrayOutputStream serializeToByteArrayOutputStream(XMLObject aXmlObject)
			throws SerializeException {
		try {
			final var element = serializeToXml(aXmlObject);

			final var tr = XmlFactories.newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "no");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(4));

			final var bas = new ByteArrayOutputStream();
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
	 * @see org.husky.xua.serialization.OpenSaml2Serializer#serializeToString(org.opensaml.core.xml.XMLObject)
	 */
	@Override
	public String serializeToString(XMLObject aXmlObject) throws SerializeException {
		return serializeToByteArrayOutputStream(aXmlObject).toString();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.OpenSaml2Serializer#serializeToXml(org.opensaml.core.xml.XMLObject)
	 */
	@Override
	public Element serializeToXml(XMLObject aXmlObject) throws SerializeException {
		try {
			final var marshallerFactory = XMLObjectProviderRegistrySupport
					.getMarshallerFactory();

			final var marshaller = marshallerFactory.getMarshaller(aXmlObject);

			return marshaller.marshall(aXmlObject);

		} catch (final MarshallingException | NullPointerException e) {
			throw new SerializeException(e);
		}

	}
}
