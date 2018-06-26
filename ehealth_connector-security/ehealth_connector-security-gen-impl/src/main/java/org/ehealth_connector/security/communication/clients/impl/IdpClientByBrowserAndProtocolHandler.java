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
package org.ehealth_connector.security.communication.clients.impl;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Calendar;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.clients.IdpClient;
import org.ehealth_connector.security.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigImpl;
import org.ehealth_connector.security.deserialization.impl.ResponseDeserializerImpl;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.serialization.impl.AuthnRequestSerializerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the IdP Client starting a browser for login..</div>
 * <div class="de">Klasse die den IdP Client für das Login mit dem Browser implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientByBrowserAndProtocolHandler implements IdpClient {

	private IdpClientByBrowserAndProtocolHandlerConfigImpl config;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public IdpClientByBrowserAndProtocolHandler(
			IdpClientByBrowserAndProtocolHandlerConfigImpl clientConfiguration) {
		config = clientConfiguration;
	}

	private File getHtmlFormPage(AuthnRequest aAuthnRequest)
			throws SerializeException, IOException, URISyntaxException {
		final AuthnRequestSerializerImpl serializer = new AuthnRequestSerializerImpl();
		final byte[] authnByteArray = serializer.toXmlByteArray(aAuthnRequest);
		final String samlRequest = Base64.getEncoder().encodeToString(authnByteArray);
		String template = readFromJARFile("/template/authnsubmitform.html");

		template = template.replaceAll("@base64samlrequest@", samlRequest);
		template = template.replaceAll("@idpurl@", config.getUrl());

		final File tempFile = File.createTempFile("saml_", ".html");
		tempFile.deleteOnExit();

		final FileOutputStream os = new FileOutputStream(tempFile);
		os.write(template.getBytes());
		os.close();
		return tempFile;
	}

	private Response getResponse(String samlReponse)
			throws DeserializeException, UnsupportedEncodingException {
		final byte[] samlReponseBytes = Base64.getDecoder().decode(samlReponse);
		final ResponseDeserializerImpl deserializer = new ResponseDeserializerImpl();
		return deserializer.fromXmlByteArray(samlReponseBytes);
	}

	public String readFromJARFile(String filename) throws IOException {
		final InputStream is = getClass().getResourceAsStream(filename);
		final InputStreamReader isr = new InputStreamReader(is);
		final BufferedReader br = new BufferedReader(isr);
		final StringBuffer sb = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		isr.close();
		is.close();
		return sb.toString();
	}

	@Override
	public Response send(AuthnRequest aAuthnRequest) throws ClientSendException {
		try {

			final File htmlFile = getHtmlFormPage(aAuthnRequest);
			startBrowser(htmlFile.toURI());

			return startWaitForResponse();

		} catch (final Throwable t) {
			logger.error("An error occured sending authnrequest.", t);
			throw new ClientSendException(t);
		}
	}

	private void startBrowser(URI requestUri) {
		try {
			if (Desktop.isDesktopSupported()) {
				final Desktop desktop = Desktop.getDesktop();

				desktop.browse(requestUri);
			} else {
				logger.error("Desktop not supported.");
			}
		} catch (final Throwable t) {
			logger.error("An error occured starting the browser.", t);
		}
	}

	private Response startWaitForResponse()
			throws IOException, ClientSendException, DeserializeException {
		final Calendar end = Calendar.getInstance();
		end.add(Calendar.MINUTE, 1);

		final File tempFile = new File(System.getProperty("java.io.tmpdir"),
				config.getProtocolHandlerName() + ".io");
		if (tempFile.exists()) {
			tempFile.delete();
		}
		tempFile.createNewFile();
		final BufferedReader in = new BufferedReader(new FileReader(tempFile));
		String line = in.readLine();
		while ((line == null) || line.isEmpty()
				|| !line.startsWith(config.getProtocolHandlerName())) {
			line = in.readLine();
			if (Calendar.getInstance().after(end)) {
				break;
			}
		}

		in.close();
		if (tempFile.exists()) {
			tempFile.delete();
		}
		if ((line == null) && (!line.startsWith(config.getProtocolHandlerName()))) {
			throw new ClientSendException("No SAML response found");
		}
		line = java.net.URLDecoder.decode(line, "UTF-8");
		final String[] urlSplit = line.split("SAMLResponse");
		final String samlReponse = urlSplit[1].substring(1);

		return getResponse(samlReponse);
	}
}
