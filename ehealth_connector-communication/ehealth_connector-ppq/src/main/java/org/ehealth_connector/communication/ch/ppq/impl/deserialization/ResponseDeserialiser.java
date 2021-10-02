package org.ehealth_connector.communication.ch.ppq.impl.deserialization;

import org.ehealth_connector.xua.deserialization.impl.AbstractDeserializerImpl;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.opensaml.saml.saml2.core.Response;
import org.w3c.dom.Element;

public class ResponseDeserialiser extends AbstractDeserializerImpl<Response, Response> {

	@Override
	public Response fromXmlByteArray(byte[] aByteArray) throws DeserializeException {
		try {
			return getOpenSamlDeserializer().deserializeFromByteArray(aByteArray);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public Response fromXmlElement(Element aXmlElement) throws DeserializeException {
		try {
			return getOpenSamlDeserializer().deserializeFromXml(aXmlElement);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public Response fromXmlString(String aXmlString) throws DeserializeException {
		try {
			return getOpenSamlDeserializer().deserializeFromString(aXmlString);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
