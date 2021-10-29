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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * A concept descriptor represents any kind of concept usually by giving a code
 * defined in a code system. A concept descriptor can contain the original text
 * or phrase that served as the basis of the coding and one or more translations
 * into different coding systems. A concept descriptor can also contain
 * qualifiers to describe, e.g., the concept of a "left foot" as a
 * postcoordinated term built from the primary code "FOOT" and the qualifier
 * "LEFT". In exceptional cases, the concept descriptor need not contain a code
 * but only the original text describing that concept.
 *
 *
 * <p>
 * Java-Klasse für CD complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="CD">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ANY">
 *       &lt;sequence>
 *         &lt;element name="originalText" type="{urn:hl7-org:v3}ED" minOccurs="0"/>
 *         &lt;element name="qualifier" type="{urn:hl7-org:v3}CR" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="translation" type="{urn:hl7-org:v3}CD" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" type="{urn:hl7-org:v3}cs" />
 *       &lt;attribute name="codeSystem" type="{urn:hl7-org:v3}uid" />
 *       &lt;attribute name="codeSystemName" type="{urn:hl7-org:v3}st" />
 *       &lt;attribute name="codeSystemVersion" type="{urn:hl7-org:v3}st" />
 *       &lt;attribute name="displayName" type="{urn:hl7-org:v3}st" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CD", propOrder = { "originalText", "qualifier", "translation" })
@XmlSeeAlso({ BXITCD.class, SXCMCD.class, CE.class })
public class CD extends ANY {

	protected ED originalText;
	protected List<CR> qualifier;
	protected List<CD> translation;
	@XmlAttribute(name = "code")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String code;
	@XmlAttribute(name = "codeSystem")
	protected String codeSystem;
	@XmlAttribute(name = "codeSystemName")
	protected String codeSystemName;
	@XmlAttribute(name = "codeSystemVersion")
	protected String codeSystemVersion;
	@XmlAttribute(name = "displayName")
	protected String displayName;

	/**
	 * Ruft den Wert der code-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Ruft den Wert der codeSystem-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getCodeSystem() {
		return codeSystem;
	}

	/**
	 * Ruft den Wert der codeSystemName-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getCodeSystemName() {
		return codeSystemName;
	}

	/**
	 * Ruft den Wert der codeSystemVersion-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getCodeSystemVersion() {
		return codeSystemVersion;
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
	 * Ruft den Wert der originalText-Eigenschaft ab.
	 *
	 * @return possible object is {@link ED }
	 *
	 */
	public ED getOriginalText() {
		return originalText;
	}

	/**
	 * Gets the value of the qualifier property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the qualifier property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getQualifier().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CR }
	 *
	 *
	 */
	public List<CR> getQualifier() {
		if (qualifier == null) {
			qualifier = new ArrayList<CR>();
		}
		return this.qualifier;
	}

	/**
	 * Gets the value of the translation property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the translation property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getTranslation().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CD }
	 *
	 *
	 */
	public List<CD> getTranslation() {
		if (translation == null) {
			translation = new ArrayList<CD>();
		}
		return this.translation;
	}

	/**
	 * Legt den Wert der code-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Legt den Wert der codeSystem-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setCodeSystem(String value) {
		this.codeSystem = value;
	}

	/**
	 * Legt den Wert der codeSystemName-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setCodeSystemName(String value) {
		this.codeSystemName = value;
	}

	/**
	 * Legt den Wert der codeSystemVersion-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setCodeSystemVersion(String value) {
		this.codeSystemVersion = value;
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
	 * Legt den Wert der originalText-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link ED }
	 *
	 */
	public void setOriginalText(ED value) {
		this.originalText = value;
	}

}
