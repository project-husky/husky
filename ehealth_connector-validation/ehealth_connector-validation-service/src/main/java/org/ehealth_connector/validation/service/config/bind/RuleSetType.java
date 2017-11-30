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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für RuleSetType complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="RuleSetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="display-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="templateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="file" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="persistable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="cacheable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuleSetType", propOrder = { "description", "displayName", "templateId" })
public class RuleSetType {

	protected String description;
	@XmlElement(name = "display-name")
	protected String displayName;
	protected String templateId;
	@XmlAttribute(name = "file", required = true)
	protected String fileName;
	@XmlAttribute(name = "persistable")
	protected Boolean persistable;
	@XmlAttribute(name = "cacheable")
	protected Boolean cacheable;

	/**
	 * Ruft den Wert der description-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Ruft den Wert der displayName-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Ruft den Wert der fileName-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Ruft den Wert der templateId-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * Ruft den Wert der cacheable-Eigenschaft ab.
	 *
	 * @return possible object is {@link Boolean }
	 *
	 */
	public boolean isCacheable() {
		if (cacheable == null) {
			return true;
		} else {
			return cacheable;
		}
	}

	/**
	 * Ruft den Wert der persistable-Eigenschaft ab.
	 *
	 * @return possible object is {@link Boolean }
	 *
	 */
	public boolean isPersistable() {
		if (persistable == null) {
			return true;
		} else {
			return persistable;
		}
	}

	/**
	 * Legt den Wert der cacheable-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link Boolean }
	 *
	 */
	public void setCacheable(Boolean value) {
		this.cacheable = value;
	}

	/**
	 * Legt den Wert der description-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Legt den Wert der displayName-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setDisplayName(String value) {
		this.displayName = value;
	}

	/**
	 * Legt den Wert der fileName-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setFileName(String value) {
		this.fileName = value;
	}

	/**
	 * Legt den Wert der persistable-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link Boolean }
	 *
	 */
	public void setPersistable(Boolean value) {
		this.persistable = value;
	}

	/**
	 * Legt den Wert der templateId-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setTemplateId(String value) {
		this.templateId = value;
	}

}
