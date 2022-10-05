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

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.soap.SOAPHeaderElement;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the internface SOAPHandler to add WSA header.</div>
 * <div class="de">Klasse die das Interface SOAPHandler implementiert um einer Message WSA headers hinzuzufügen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class WsaHeaderSoapHandler implements SOAPHandler<SOAPMessageContext> {

	public static final String IN_OUT_PARAM = "InOutExchange";
	private QName mActionHeader;
	private Logger mLogger;

	private QName mMessageIdHeader;

	private QName mToHeader;

	private WsaHeaderValue mWsaValues;

	public static final String NAMESPACE_SOAPENV_URI = "http://www.w3.org/2003/05/soap-envelope";

	public static final String NAMESPACE_WSA = "wsa";
	public static final String NAMESPACE_WSA_URI = "http://www.w3.org/2005/08/addressing";

	public WsaHeaderSoapHandler(WsaHeaderValue aActionValue) {
		mLogger = LoggerFactory.getLogger(getClass());
		mLogger.trace("WSAHeaderSoapHandler()");

		mActionHeader = new QName(NAMESPACE_WSA_URI, "Action", NAMESPACE_WSA);
		mMessageIdHeader = new QName(NAMESPACE_WSA_URI, "MessageID", NAMESPACE_WSA);
		mToHeader = new QName(NAMESPACE_WSA_URI, "To", NAMESPACE_WSA);

		mWsaValues = aActionValue;

	}

	@Override
	public void close(MessageContext context) {
		mLogger.trace("close: {}", context);
	}

	@Override
	public Set<QName> getHeaders() {
		final Set<QName> headers = new HashSet<>();
		headers.add(mActionHeader);
		headers.add(mMessageIdHeader);
		headers.add(mToHeader);
		mLogger.trace("getHeaders: {}", headers);
		return headers;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		mLogger.error("SOAP Fault: {}", context);
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			final Boolean outboundProperty = (Boolean) context
					.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if (outboundProperty.booleanValue()) {

				final var soapMessage = context.getMessage();
				final var soapHeader = soapMessage.getSOAPHeader();
				mLogger.debug("InOutValue: {}", context.get(IN_OUT_PARAM));

				final String soapEnvelopPrefix = soapMessage.getSOAPPart().getEnvelope()
						.getPrefix();
				final var mustUnderstandAttribute = new QName(NAMESPACE_SOAPENV_URI,
						"mustUnderstand", soapEnvelopPrefix);

				soapHeader.addNamespaceDeclaration(NAMESPACE_WSA, NAMESPACE_WSA_URI);

				if ((mWsaValues.getAction() != null) && !"".equals(mWsaValues.getAction())) {
					setSOAPHeader(soapHeader, mustUnderstandAttribute, mActionHeader, mWsaValues.getAction());
				}

				if ((mWsaValues.getMessageId() != null) && !"".equals(mWsaValues.getMessageId())) {
					setSOAPHeader(soapHeader, mustUnderstandAttribute, mMessageIdHeader, mWsaValues.getMessageId());
				}

				if ((mWsaValues.getTo() != null) && !"".equals(mWsaValues.getTo())) {
					setSOAPHeader(soapHeader, mustUnderstandAttribute, mToHeader, mWsaValues.getTo());
				}

			}

		} catch (final Exception t) {
			mLogger.error("error handling inout stuff", t);
			return false;
		}
		return true;
	}

	private void setSOAPHeader(SOAPHeader soapHeader, QName mustUnderstandAttribute, QName headerQName, String value)
			throws SOAPException {
		final SOAPHeaderElement specificHeader = soapHeader.addHeaderElement(headerQName);
		specificHeader.setValue(value);
		if (mWsaValues.isMustUnderstand()) {
			specificHeader.addAttribute(mustUnderstandAttribute, "true");
		}
	}
}
