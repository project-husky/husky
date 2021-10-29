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
// Generiert: 2020.07.09 um 01:07:39 PM CEST
//

package org.husky.common.hl7cdar2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * An identifier that uniquely identifies a thing or object. Examples are object
 * identifier for HL7 RIM objects, medical record number, order id, service
 * catalog item id, Vehicle Identification Number (VIN), etc. Instance
 * identifiers are defined based on ISO object identifiers.
 *
 *
 * <p>
 * Java-Klasse für II complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="II">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ANY">
 *       &lt;attribute name="root" type="{urn:hl7-org:v3}uid" />
 *       &lt;attribute name="extension" type="{urn:hl7-org:v3}st" />
 *       &lt;attribute name="assigningAuthorityName" type="{urn:hl7-org:v3}st" />
 *       &lt;attribute name="displayable" type="{urn:hl7-org:v3}bl" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "II")
@XmlSeeAlso({ POCDMT000040InfrastructureRootTypeId.class, AllInfrastructureRootTemplateId.class,
		AllInfrastructureRootTypeId.class })
public class II extends ANY {

	@XmlAttribute(name = "root")
	protected String root;
	@XmlAttribute(name = "extension")
	protected String extension;
	@XmlAttribute(name = "assigningAuthorityName")
	protected String assigningAuthorityName;
	@XmlAttribute(name = "displayable")
	protected Boolean displayable;

	/**
	 * Ruft den Wert der assigningAuthorityName-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getAssigningAuthorityName() {
		return assigningAuthorityName;
	}

	/**
	 * Ruft den Wert der extension-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Ruft den Wert der root-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getRoot() {
		return root;
	}

	/**
	 * Ruft den Wert der displayable-Eigenschaft ab.
	 *
	 * @return possible object is {@link Boolean }
	 *
	 */
	public Boolean isDisplayable() {
		return displayable;
	}

	/**
	 * Legt den Wert der assigningAuthorityName-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setAssigningAuthorityName(String value) {
		this.assigningAuthorityName = value;
	}

	/**
	 * Legt den Wert der displayable-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link Boolean }
	 *
	 */
	public void setDisplayable(Boolean value) {
		this.displayable = value;
	}

	/**
	 * Legt den Wert der extension-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setExtension(String value) {
		this.extension = value;
	}

	/**
	 * Legt den Wert der root-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setRoot(String value) {
		this.root = value;
	}

}
