/*
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
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2017.04.30 um 04:58:07 AM CEST
//

package org.ehealth_connector.validation.service.config.bind;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für ConfigurationType complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="ConfigurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="application" type="{}ApplicationType" minOccurs="0"/>
 *         &lt;element name="schematron" type="{}SchematronType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="baseDir" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="workDir" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigurationType", propOrder = { "application", "schematron" })
public class ConfigurationType {

	protected ApplicationType application;
	@XmlElement(required = true)
	protected SchematronType schematron;
	@XmlAttribute(name = "baseDir")
	@XmlSchemaType(name = "anySimpleType")
	protected String baseDir;
	@XmlAttribute(name = "workDir")
	@XmlSchemaType(name = "anySimpleType")
	protected String workDir;

	/**
	 * Ruft den Wert der application-Eigenschaft ab.
	 *
	 * @return possible object is {@link ApplicationType }
	 *
	 */
	public ApplicationType getApplication() {
		return application;
	}

	/**
	 * Ruft den Wert der baseDir-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getBaseDir() {
		return baseDir;
	}

	/**
	 * Ruft den Wert der schematron-Eigenschaft ab.
	 *
	 * @return possible object is {@link SchematronType }
	 *
	 */
	public SchematronType getSchematron() {
		return schematron;
	}

	/**
	 * Ruft den Wert der workDir-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getWorkDir() {
		return workDir;
	}

	/**
	 * Legt den Wert der application-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link ApplicationType }
	 *
	 */
	public void setApplication(ApplicationType value) {
		this.application = value;
	}

	/**
	 * Legt den Wert der baseDir-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setBaseDir(String value) {
		this.baseDir = value;
	}

	/**
	 * Legt den Wert der schematron-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link SchematronType }
	 *
	 */
	public void setSchematron(SchematronType value) {
		this.schematron = value;
	}

	/**
	 * Legt den Wert der workDir-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setWorkDir(String value) {
		this.workDir = value;
	}

}
