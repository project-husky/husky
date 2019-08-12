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
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2016.12.09 um 10:05:27 AM CET
//

package org.ehealth_connector.validation.service.batchprocessing.bind;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the
 * org.ehealth_connector.validation.service.batchprocessing.bind package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _BatchConfiguration_QNAME = new QName("", "batchConfiguration");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package:
	 * org.ehealth_connector.validation.service.batchprocessing.bind
	 *
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link JAXBElement
	 * }{@code <}{@link BatchConfigurationType }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "", name = "batchConfiguration")
	public JAXBElement<BatchConfigurationType> createBatchConfiguration(
			BatchConfigurationType value) {
		return new JAXBElement<BatchConfigurationType>(_BatchConfiguration_QNAME,
				BatchConfigurationType.class, null, value);
	}

	/**
	 * Create an instance of {@link BatchConfigurationType }
	 *
	 */
	public BatchConfigurationType createBatchConfigurationType() {
		return new BatchConfigurationType();
	}

	/**
	 * Create an instance of {@link BatchEntryType }
	 *
	 */
	public BatchEntryType createBatchEntryType() {
		return new BatchEntryType();
	}

	/**
	 * Create an instance of {@link BatchProcessType }
	 *
	 */
	public BatchProcessType createBatchProcessType() {
		return new BatchProcessType();
	}

}
