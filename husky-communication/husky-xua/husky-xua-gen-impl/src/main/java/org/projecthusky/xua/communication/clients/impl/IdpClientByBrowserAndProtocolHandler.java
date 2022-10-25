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
package org.projecthusky.xua.communication.clients.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Base64;
import java.util.Calendar;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.SystemUtils;
import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.communication.clients.IdpClient;
import org.projecthusky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigImpl;
import org.projecthusky.xua.deserialization.impl.ResponseDeserializerImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.saml2.Response;
import org.projecthusky.xua.serialization.impl.AuthnRequestSerializerImpl;
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

	private final IdpClientByBrowserAndProtocolHandlerConfigImpl config;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public IdpClientByBrowserAndProtocolHandler(
			IdpClientByBrowserAndProtocolHandlerConfigImpl clientConfiguration) {
		config = clientConfiguration;
	}

	/*
	 * Here the sonar issue
	 * "Make sure publicly writable directories are used safely here." is
	 * suppressed, because file is only writeable for the owner
	 */
	@SuppressWarnings("java:S5443")
	private void openHtmlFormPage(AuthnRequest aAuthnRequest)
			throws SerializeException, IOException {
		final var serializer = new AuthnRequestSerializerImpl();
		final byte[] authnByteArray = serializer.toXmlByteArray(aAuthnRequest);
		final var samlRequest = Base64.getEncoder().encodeToString(authnByteArray);
		String template = readFromJARFile("/template/authnsubmitform.html");

		template = template.replace("@base64samlrequest@", samlRequest);
		template = template.replace("@bsamlrequesttype@", "SAMLRequest");
		template = template.replace("@idpurl@", config.getUrl());

		logger.debug("html to send to browser: {}", template);

		File tempFile;
		if (SystemUtils.IS_OS_UNIX) {
			FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions
					.asFileAttribute(PosixFilePermissions.fromString("rwx------"));
			tempFile = Files.createTempFile(String.format("saml_%s", UUID.randomUUID().toString()), ".html", attr)
					.toFile();
		} else {
			tempFile = File.createTempFile(String.format("saml_%s", UUID.randomUUID().toString()), ".html");
			var permission = tempFile.setWritable(false, true);

			if (permission) {
				permission = tempFile.setReadable(true);
			}

			if (permission) {
				permission = tempFile.setExecutable(false);
			}

			if (!permission) {
				Files.deleteIfExists(tempFile.toPath());
				logger.error("Application has no permission to change access rights for files");
			}
		}

		try(final var os = new FileOutputStream(tempFile)){
			os.write(template.getBytes());
		}

		logger.info("Please open {} in your browser", tempFile.toURI());

		tempFile.deleteOnExit();
	}

	private Response getResponse(String samlReponse)
			throws DeserializeException {
		final byte[] samlReponseBytes = Base64.getDecoder().decode(samlReponse);
		final var deserializer = new ResponseDeserializerImpl();
		return deserializer.fromXmlByteArray(samlReponseBytes);
	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to read content from a file packed in a jar file.</div>
	 * <div class="de">Methode um den Inhalt eines Files gepacket in einem jar File zu laden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param filename
	 * <div class="en">The name of the file incl. the classpath.</div>
	 * <div class="de">Der Name des Files incl, des Klassenpfades</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">The content of the file as string.</div>
	 * <div class="de">Der Inhalt des Files als String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws IOException
	 * <div class="en">will be thrown occuring an error reading the file.</div>
	 * <div class="de">wird geworfen wenn ein fehler beim lesen auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String readFromJARFile(String filename) throws IOException {
		final InputStream is = getClass().getResourceAsStream(filename);
		final var isr = new InputStreamReader(is);
		final var br = new BufferedReader(isr);
		final var sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		isr.close();
		is.close();
		return sb.toString();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.clients.IdpClient#send(org.projecthusky.xua.authentication.AuthnRequest)
	 */
	@Override
	public Object send(AuthnRequest aAuthnRequest) throws ClientSendException {
		try {

			final var tempFile = new File(System.getProperty("java.io.tmpdir"),
					config.getProtocolHandlerName() + ".io");			
			Files.deleteIfExists(tempFile.toPath());
			openHtmlFormPage(aAuthnRequest);

			return startWaitForResponse(tempFile);

		} catch (final Exception t) {
			throw new ClientSendException(t);
		}
	}

	private Object startWaitForResponse(File response)
			throws IOException, ClientSendException, DeserializeException {
		final var end = Calendar.getInstance();

		// This is the timeout to wait for the SAML response
		end.add(Calendar.MINUTE, 2);
		try {
			while (!response.exists() && !Calendar.getInstance().after(end)) {
				Thread.sleep(200);
			}
			Thread.sleep(200);
		} catch (final InterruptedException e) {
			logger.warn("Interrupted wait for SAML response", e);
			Thread.currentThread().interrupt();
		}

		try(final var in = new BufferedReader(new FileReader(response))){
			String line = in.readLine();
			
			Files.deleteIfExists(response.toPath());
			if (line == null) {
				throw new ClientSendException("No SAML response found");
			}
			line = java.net.URLDecoder.decode(line, "UTF-8");
			logger.info("SAML Response: {}", line);

			if (IdpClientByBrowserAndProtocolHandlerConfigImpl.SamlRequestType.SAMLART
					.equals(config.getSamlRequestType())) {
				final String[] urlSplit = line.split("SAMLart");
				return urlSplit[1].substring(1);
			} else {
				final String[] urlSplit = line.split("SAMLResponse");
				final var samlReponse = urlSplit[1].substring(1);
				return getResponse(samlReponse);
			}
		}
		
	}

}
