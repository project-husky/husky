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
package org.husky.xua.communication.soap.impl;

import java.io.StringWriter;
import java.util.Collections;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class to log out soap messages.</div>
 * <div class="de">Klasse um die SOAP Message zu loggen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class LogSoapMessageHandler implements SOAPHandler<SOAPMessageContext> {

	/** The Logger. */
	private Logger mLogger;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public LogSoapMessageHandler() {
		mLogger = LoggerFactory.getLogger(getClass());
		mLogger.debug("LogSoapMessageHandler()");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public void close(MessageContext context) {
		mLogger.debug("close: {}", context);
	}

	@PreDestroy
	public void destroy() {
		mLogger.debug("------------------------------------");
		mLogger.debug("In Handler {} :destroy()", this.getClass().getName());
		mLogger.debug("Exiting Handler {} :destroy()", this.getClass().getName());
		mLogger.debug("------------------------------------");
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

	/**
	 * {@inheritDoc}
	 *
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		try {
			final SOAPMessage soapMsg = context.getMessage();
			mLogger.debug("SOAP Message: {}", soapMsg);
		} catch (final Exception ex) {
			mLogger.debug("Error in soap logging", ex);
			return false;
		}
		return true;
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

			final Boolean outboundProperty = (Boolean) context
					.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			var inout = "";

			if (outboundProperty.booleanValue()) {
				inout = "Request: ";
			} else {
				inout = "Response : ";
			}

			final SOAPMessage soapMsg = context.getMessage();
			context.put("soapMsg", soapMsg);
			context.setScope("soapMsg", MessageContext.Scope.APPLICATION);

			final var sw = new StringWriter();
			final var transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
			final var transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(soapMsg.getSOAPPart()), new StreamResult(sw));
			mLogger.debug("Message: {} {}", inout, sw);
		} catch (final Exception ex) {
			mLogger.debug("Error in soap logging", ex);
			return false;
		}
		return true;
	}

	@PostConstruct
	public void init() {
		mLogger.debug("------------------------------------");
		mLogger.debug("In Handler {} : init()", this.getClass().getName());
		mLogger.debug("Exiting Handler {} : init()", this.getClass().getName());
		mLogger.debug("------------------------------------");
	}
}
