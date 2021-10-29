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
// Generiert: 2017.04.30 um 04:58:07 AM CEST
//

package org.husky.validation.service.config.bind;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für SchematronType complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="SchematronType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="rule-set" type="{}RuleSetType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dir" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchematronType", propOrder = { "ruleSets" })
public class SchematronType {

	@XmlElement(name = "rule-set", required = true)
	protected List<RuleSetType> ruleSets;
	@XmlAttribute(name = "dir", required = true)
	protected String directory;

	/**
	 * Ruft den Wert der directory-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getDirectory() {
		return directory;
	}

	/**
	 * Gets the value of the ruleSets property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the ruleSets property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getRuleSets().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link RuleSetType }
	 *
	 *
	 */
	public List<RuleSetType> getRuleSets() {
		if (ruleSets == null) {
			ruleSets = new ArrayList<RuleSetType>();
		}
		return this.ruleSets;
	}

	/**
	 * Legt den Wert der directory-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setDirectory(String value) {
		this.directory = value;
	}

}
