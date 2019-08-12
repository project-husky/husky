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
package org.ehealth_connector.communication.tls;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLSocket;

import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openhealthtools.ihe.common.ws.IHESOAPSenderFactory;

/**
 * see
 * http://stackoverflow.com/questions/32587141/how-to-force-commons-httpclient-3
 * -1-to-use-tls-1-2-only-for-https
 *
 * <pre>
 * org.openhealthtools.ihe.common.ws.AbstractIHESOAPSender registers in the static initialization block the IHEHTTPSecureSockets
 *
 * 	private static Protocol httpProtocolHandler;
 *	static {
 *		httpsProtocolHandler = new Protocol("https", (IHEHTTPSocketFactoryWrapper)(new IHEHTTPSecureSocketFactoryWrapper()), 443);
 *		httpProtocolHandler = new Protocol("http", new IHEHTTPSocketFactoryWrapper(), 80);
 *
 *		Protocol.registerProtocol("https", httpsProtocolHandler);
 * </pre>
 */
public class CustomHttpsTLSv11v12SocketFactory implements SecureProtocolSocketFactory {
	/**
	 *
	 * Method to setup the custom https tls12 socket factory.
	 *
	 */
	static public void setup() {

		// get the protocolls for https
		final String scheme = "https";
		final Protocol baseHttps = Protocol.getProtocol(scheme);

		// get the socket factory
		final ProtocolSocketFactory baseFactory = baseHttps.getSocketFactory();

		// provoke initialization
		IHESOAPSenderFactory.getSOAP12Sender();

		// create the custom factory
		final ProtocolSocketFactory customFactory = new CustomHttpsTLSv11v12SocketFactory(
				baseFactory);

		// get default port
		final int defaultPort = baseHttps.getDefaultPort();

		// create the custom https protocol with the custom settings
		final Protocol customHttps = new Protocol(scheme, customFactory, defaultPort);

		// register the protocol
		Protocol.registerProtocol(scheme, customHttps);

	}

	/** the logger */
	private Log logger;

	/** the SecureProtocolSocketFactory */
	private final SecureProtocolSocketFactory base;

	/**
	 *
	 * Default constructor to instanciate the object
	 *
	 * @param base
	 *            the protocol socket factory
	 */
	public CustomHttpsTLSv11v12SocketFactory(ProtocolSocketFactory base) {
		logger = LogFactory.getLog(getClass());
		if ((base == null) || !(base instanceof SecureProtocolSocketFactory)) {
			throw new IllegalArgumentException();
		}
		this.base = (SecureProtocolSocketFactory) base;
	}

	/**
	 *
	 * Method to check for TLS1.2 and add it if its missing
	 *
	 * @param socket
	 *            the sock to get the enabled protocols.
	 * @return the completed socket.
	 */
	private Socket checkAndAddTLS11_12(Socket socket) {
		// if socket not SSLSocket return it.
		if (!(socket instanceof SSLSocket)) {
			return socket;
		}

		// cast socket to sslsocket
		final SSLSocket sslSocket = (SSLSocket) socket;

		// get all enabled protocols
		final String[] protocols = sslSocket.getEnabledProtocols();

		// create new list of enabled protocols
		final List<String> protocolList = new ArrayList<>();

		boolean noTls11 = true;
		boolean noTls12 = true;

		// loop over list of protocols to check for TLS1.2
		for (final String protocol : protocols) {
			logger.trace("Protocol: " + protocol);
			protocolList.add(protocol);
			if ("TLSv1.1".equals(protocol)) {
				logger.trace("TLSv1.1 as enabled protocol found.");
				noTls11 = false;
			}
			if ("TLSv1.2".equals(protocol)) {
				logger.trace("TLSv1.2 as enabled protocol found.");
				noTls12 = false;
			}
		}
		if (noTls12 || noTls11) {
			if (noTls11) {
				logger.debug("No TLSv1.1 found. Add it to the enabled protocols");
				protocolList.add("TLSv1.1");
			}
			if (noTls12) {
				logger.debug("No TLSv1.2 found. Add it to the enabled protocols");
				protocolList.add("TLSv1.2");
			}

		}
		final String[] protocollArray = protocolList.toArray(new String[protocolList.size()]);
		// set the completed list of enabled protocols to the socket
		sslSocket.setEnabledProtocols(protocollArray);
		return sslSocket;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory#createSocket(java.net.Socket,
	 *      java.lang.String, int, boolean)
	 */
	@Override
	public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
			throws IOException {
		return checkAndAddTLS11_12(base.createSocket(socket, host, port, autoClose));
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.apache.commons.httpclient.protocol.ProtocolSocketFactory#createSocket(java.lang.String,
	 *      int)
	 */
	@Override
	public Socket createSocket(String host, int port) throws IOException {
		return checkAndAddTLS11_12(base.createSocket(host, port));
	}

	@Override
	public Socket createSocket(String host, int port, InetAddress localAddress, int localPort)
			throws IOException {
		return checkAndAddTLS11_12(base.createSocket(host, port, localAddress, localPort));
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.apache.commons.httpclient.protocol.ProtocolSocketFactory#createSocket(java.lang.String,
	 *      int, java.net.InetAddress, int,
	 *      org.apache.commons.httpclient.params.HttpConnectionParams)
	 */
	@Override
	public Socket createSocket(String host, int port, InetAddress localAddress, int localPort,
			HttpConnectionParams params) throws IOException {
		logger.debug(host + " " + port + " " + params);
		return checkAndAddTLS11_12(base.createSocket(host, port, localAddress, localPort, params));
	}

}