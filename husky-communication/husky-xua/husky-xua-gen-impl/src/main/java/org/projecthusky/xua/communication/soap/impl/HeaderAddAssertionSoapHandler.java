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
package org.projecthusky.xua.communication.soap.impl;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;

import org.projecthusky.xua.core.SecurityHeaderElement;
import org.projecthusky.xua.saml2.utils.XmlAppender;
import org.projecthusky.xua.serialization.impl.OpenSaml2SerializerImpl;
import org.opensaml.core.xml.XMLObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPFactory;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the internface SOAPHandler to add an assertion to securityheader.</div>
 * <div class="de">Klasse die das Interface SOAPHandler implementiert um einer Message eine Assertion dem Security Header hinzuzufügen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class HeaderAddAssertionSoapHandler implements SOAPHandler<SOAPMessageContext> {

	private Logger mLogger;

	private SecurityHeaderElement mSecurityHeaderElement;

	/**
	 * Constructor with param
	 * @param aSecurityHeaderElement the security header element
	 */
	public HeaderAddAssertionSoapHandler(SecurityHeaderElement aSecurityHeaderElement) {
		mLogger = LoggerFactory.getLogger(getClass());
		mLogger.debug("AssertionSoapHandler()");
		mSecurityHeaderElement = aSecurityHeaderElement;
	}

	@Override
	public void close(MessageContext context) {
		mLogger.debug("close: {}", context);
	}

	@Override
	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		mLogger.error("SOAP Fault: {}", context);
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
				final var factory = SOAPFactory.newInstance();

				SOAPHeader header = envelope.getHeader();
				if (header == null) {
					header = envelope.addHeader();
				}
				final SOAPElement securityElem = factory.createElement(new QName(
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
						"Security"));

				final var serializedElement = new OpenSaml2SerializerImpl()
						.serializeToXml((XMLObject) mSecurityHeaderElement.getWrappedObject());

				XmlAppender.addFragment(serializedElement, securityElem);

				header.addChildElement(securityElem);

			} catch (final Exception e) {
				mLogger.error("Exception in handler: {}", e.getMessage(), e);
			}
		} else {
			// inbound
		}
		return true;
	}

}
