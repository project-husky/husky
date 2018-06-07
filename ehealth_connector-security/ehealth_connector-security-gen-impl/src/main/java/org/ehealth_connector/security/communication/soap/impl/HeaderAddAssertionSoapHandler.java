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
package org.ehealth_connector.security.communication.soap.impl;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.saml2.utils.XMLAppender;
import org.ehealth_connector.security.serialization.impl.OpenSaml2SerializerImpl;
import org.opensaml.core.xml.XMLObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the internface SOAPHandler to add an assertion to securityheader.</div>
 * <div class="de">Klasse die das interface SOAPHandler implementiert um einer message eine assertion dem security header hinzuzufügen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class HeaderAddAssertionSoapHandler implements SOAPHandler<SOAPMessageContext> {

	private Logger mLogger;

	private SecurityHeaderElement mSecurityHeaderElement;

	public HeaderAddAssertionSoapHandler(SecurityHeaderElement aSecurityHeaderElement) {
		mLogger = LoggerFactory.getLogger(getClass());
		mLogger.debug("AssertionSoapHandler()");
		mSecurityHeaderElement = aSecurityHeaderElement;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// throw new UnsupportedOperationException("Not supported yet.");
		mLogger.error("SOAP Fault: " + context);
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		mLogger.debug("AssertionSoapHandler.handleMessage()");
		final Boolean outboundProperty = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outboundProperty.booleanValue()) {
			try {
				final SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
				final SOAPFactory factory = SOAPFactory.newInstance();

				SOAPHeader header = envelope.getHeader();
				if (header == null) {
					header = envelope.addHeader();
				}
				final SOAPElement securityElem = factory.createElement(new QName(
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
						"Security"));

				final Element serializedElement = new OpenSaml2SerializerImpl()
						.serializeToXml((XMLObject) mSecurityHeaderElement.getWrappedObject());

				XMLAppender.addFragment(serializedElement, securityElem);

				header.addChildElement(securityElem);

			} catch (final Exception e) {
				mLogger.error("Exception in handler: " + e);
			}
		} else {
			// inbound
		}
		return true;
	}

}
