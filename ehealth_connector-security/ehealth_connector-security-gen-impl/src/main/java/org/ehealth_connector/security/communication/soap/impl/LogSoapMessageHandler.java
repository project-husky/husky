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

import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.namespace.QName;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class to log out soap messages.</div>
 * <div class="de">Klasse um die soap message zu loggen.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class LogSoapMessageHandler implements SOAPHandler<SOAPMessageContext> {

	private Logger mLogger;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public LogSoapMessageHandler() {
		mLogger = LoggerFactory.getLogger(getClass());
		mLogger.debug("LogSoapMessageHandler()");
	}

	@PostConstruct
	public void init() {
		mLogger.debug("------------------------------------");
		mLogger.debug("In Handler " + this.getClass().getName() + " : init()");
		mLogger.debug("Exiting Handler " + this.getClass().getName() + " : init()");
		mLogger.debug("------------------------------------");
	}

	@PreDestroy
	public void destroy() {
		mLogger.debug("------------------------------------");
		mLogger.debug("In Handler " + this.getClass().getName() + " :destroy()");
		mLogger.debug("Exiting Handler " + this.getClass().getName() + " :destroy()");
		mLogger.debug("------------------------------------");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		mLogger.debug("LogSoapMessageHandler.handleMessage()");
		try {
			final Map<String, List<String>> requestHeaders = (Map<String, List<String>>) context
					.get(SOAPMessageContext.HTTP_REQUEST_HEADERS);
			for (final Entry<String, List<String>> header : requestHeaders.entrySet()) {
				if (header.getValue().isEmpty()) {
					// I don't think this is legal, but let's just dump it,
					// as the point of the dump is to uncover problems.
					mLogger.debug(header.getValue().toString());
				} else {
					for (final String value : header.getValue()) {
						mLogger.debug(header.getKey() + ": " + value);
					}
				}
			}

			final Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			String inout = "";

			if (outboundProperty.booleanValue()) {
				inout = "Request: ";
			} else {
				inout = "Response : ";
			}

			final javax.xml.soap.SOAPMessage soapMsg = context.getMessage();
			context.put("soapMsg", soapMsg);
			context.setScope("soapMsg", MessageContext.Scope.APPLICATION);

			final StringWriter sw = new StringWriter();
			final Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(new DOMSource(soapMsg.getSOAPPart()), new StreamResult(sw));
			mLogger.debug(inout + sw.toString());
		} catch (final Throwable ex) {
			mLogger.debug("Error in soap logging", ex);
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		try {
			final javax.xml.soap.SOAPMessage soapMsg = context.getMessage();
			mLogger.debug(soapMsg.toString());
		} catch (final Throwable ex) {
			mLogger.debug("Error in soap logging", ex);
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public void close(MessageContext context) {
		mLogger.debug("close: " + context);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	@Override
	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}
}
