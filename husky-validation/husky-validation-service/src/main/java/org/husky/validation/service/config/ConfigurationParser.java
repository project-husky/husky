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

package org.husky.validation.service.config;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.husky.validation.service.config.bind.ConfigurationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * Parser for the application's XML configuration file.
 * <p>
 * The application's configuration is obtained by parsing a given XML
 * configuration file. This is done by calling the {@link #parse()} method.
 * During the parsing process the configuration file is validated against the
 * XML schema (the grammar of the XML file).
 */
public class ConfigurationParser {

	/**
	 * A <tt>ValidationEventHandler</tt> which collects all events. The
	 * {@link ValidationHandler#handleEvent(ValidationEvent)} method is
	 * overwritten to only continue the current process if the event's severity
	 * is {@link ValidationEvent#WARNING}.
	 */
	static class ValidationHandler extends ValidationEventCollector {

		/**
		 * {@inheritDoc}
		 * <p>
		 * This implementation attempts to continue the current unmarshal,
		 * validate, or marshal operation only if the message's severity is
		 * {@link ValidationEvent#WARNING}. If an error or a fatal error is
		 * reported the provider will terminate the current operation.
		 * </p>
		 */
		@Override
		public boolean handleEvent(ValidationEvent event) {
			return (super.handleEvent(event) && (event.getSeverity() == ValidationEvent.WARNING));
		}

	} // End of class ValidationHandler

	/** The name of the XML schema file. */
	private static final String SCHEMA_NAME = "/configuration.xsd";

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** A validation handler which collects all events. */
	private ValidationEventCollector validationHandler;

	/** The XML configuration file. */
	private final File configFile;

	/**
	 * Constructs of new configuration parser from the specified XML file.
	 *
	 * @param configFile
	 *            the XML configuration file.
	 * @throws NullPointerException
	 *             if the specified configuration file is <tt>null</tt>.
	 */
	public ConfigurationParser(File configFile) {
		if (configFile == null) {
			throw new NullPointerException("The configuration file must not be null");
		}
		this.configFile = configFile;
	}

	/**
	 * Creates and returns the schema instance.
	 *
	 * @return a new {@link Schema} from the parsed schema.
	 * @throws SAXException             if a SAX error occurs during parsing the
	 *                                  schema.
	 * @throws IOException
	 * @throws IllegalArgumentException if no implementation of the schema language
	 *                                  is available.
	 */
	protected Schema createSchema() throws SAXException, IOException {
		try (InputStream in = getClass().getResourceAsStream(SCHEMA_NAME)) {
			if (in == null) {
				throw new FileNotFoundException("Could not find schema as resource: " + SCHEMA_NAME);
			}

			final Source schemaSource = new StreamSource(in);
			final var schemaFactory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
			schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			return schemaFactory.newSchema(schemaSource);
		}
	}

	/**
	 * Returns the XML configuration file.
	 *
	 * @return the XML configuration file.
	 */
	public File getConfigFile() {
		return configFile;
	}

	/**
	 * Returns the validation event handler. Hook for sub-classer.
	 *
	 * @return the validation event handler.
	 */
	protected ValidationEventCollector getValidationHandler() {
		if (validationHandler == null) {
			validationHandler = new ValidationHandler();
		}
		return validationHandler;
	}

	/**
	 * Parses the XML configuration file and returns the unmarshalled root
	 * element.
	 *
	 * @return the unmarshalled root element.
	 * @throws ConfigurationException
	 *             if the configuration file cannot be opened for reading, or if
	 *             the configuration file is not valid, or if any unexpected
	 *             errors occur while unmarshalling.
	 * @throws IllegalArgumentException
	 *             if no implementation of the schema language is available.
	 */
	public ConfigurationType parse() throws ConfigurationException {
		log.info("Parsing configuration file: '{}'", getConfigFile());
		try (InputStream in = new BufferedInputStream(new FileInputStream(getConfigFile()))) {
			return unmarshal(ConfigurationType.class, in);
		} catch (final Exception e) {
			throw new ConfigurationException(e);
		} finally {
			processValidationEvents();
		}
	}

	/**
	 * Processes all the events collected during the last parsing of the
	 * configuration file. After a call to this method all the collected events
	 * are cleared.
	 * <p>
	 * An exception is thrown on the first event with severity error or fatal
	 * error. Warnings are simply logged and do not throw any exception.
	 * </p>
	 *
	 * @throws ConfigurationException
	 *             on the first event with severity error or fatal error.
	 */
	protected void processValidationEvents() throws ConfigurationException {
		final ValidationEventCollector handler = getValidationHandler();
		final ValidationEvent[] validationEvents = handler.getEvents();
		handler.reset();
		for (final ValidationEvent event : validationEvents) {
			final int line = event.getLocator().getLineNumber();
			final int column = event.getLocator().getColumnNumber();

			final var sb = new StringBuilder();
			sb.append(getConfigFile() + ":");
			if ((line != -1) && (column != -1)) {
				sb.append(line + ":" + column + ": ");
			}

			if (ValidationEvent.WARNING == event.getSeverity()) {
				log.warn("{}{}", sb, event.getMessage());
			} else if (ValidationEvent.ERROR == event.getSeverity()
					|| ValidationEvent.FATAL_ERROR == event.getSeverity()) {
				throw new ConfigurationException(sb.toString() + "Invalid configuration entry",
						event.getLinkedException());
			}
		}
	}

	/**
	 * Generic XML unmarshal method. Besides of unmarshalling the root element, this
	 * method performs a validation against the XML schema and collects all
	 * validation events.
	 *
	 * @param <T>      the type of the XML element to unmarshal.
	 * @param docClass the class of the XML element to unmarshal.
	 * @param in       the input stream from where the XML is read.
	 * @return the unmarshalled instance of the specified XML element.
	 * @throws JAXBException            if an error was encountered while creating
	 *                                  the <tt>JAXBContext</tt> or the
	 *                                  <tt>Unmarshaller</tt> object, or if an error
	 *                                  was encountered while setting the event
	 *                                  handler, or if any unexpected errors occur
	 *                                  while unmarshalling.
	 * @throws SAXException             if a SAX error occurs during parsing the
	 *                                  schema.
	 * @throws IOException
	 * @throws IllegalArgumentException if no implementation of the schema language
	 *                                  is available.
	 */
	@SuppressWarnings("unchecked")
	private <T> T unmarshal(Class<T> docClass, InputStream in)
			throws JAXBException, SAXException, IOException {
		final String packageName = docClass.getPackage().getName();
		final var jc = JAXBContext.newInstance(packageName);
		final var u = jc.createUnmarshaller();
		u.setEventHandler(getValidationHandler());
		u.setSchema(createSchema());
		final JAXBElement<T> doc = (JAXBElement<T>) u.unmarshal(in);
		return doc.getValue();
	}

} // End of class Configuration
