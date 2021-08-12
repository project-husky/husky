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
package org.ehealth_connector.xua.communication.soap.impl;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
					final SOAPHeaderElement actionHeader = soapHeader
							.addHeaderElement(mActionHeader);
					actionHeader.setValue(mWsaValues.getAction());
					if (mWsaValues.isMustUnderstand()) {
						actionHeader.addAttribute(mustUnderstandAttribute, "true");
					}
				}
				if ((mWsaValues.getMessageId() != null) && !"".equals(mWsaValues.getMessageId())) {
					final SOAPHeaderElement relatesMessageIdHeader = soapHeader
							.addHeaderElement(mMessageIdHeader);
					relatesMessageIdHeader.setValue(mWsaValues.getMessageId());
					if (mWsaValues.isMustUnderstand()) {
						relatesMessageIdHeader.addAttribute(mustUnderstandAttribute, "true");
					}
				}
				if ((mWsaValues.getTo() != null) && !"".equals(mWsaValues.getTo())) {
					final SOAPHeaderElement relatesToHeader = soapHeader
							.addHeaderElement(mToHeader);
					relatesToHeader.setValue(mWsaValues.getTo());
					if (mWsaValues.isMustUnderstand()) {
						relatesToHeader.addAttribute(mustUnderstandAttribute, "true");
					}
				}

			}

		} catch (final Exception t) {
			mLogger.error("error handling inout stuff", t);
			return true;
		}
		return true;
	}
}
