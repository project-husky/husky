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

package org.ehealth_connector.common.hl7cdar2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * A name for a person, organization, place or thing. A sequence of name parts,
 * such as given name or family name, prefix, suffix, etc. Examples for entity
 * name values are "Jim Bob Walton, Jr.", "Health Level Seven, Inc.", "Lake
 * Tahoe", etc. An entity name may be as simple as a character string or may
 * consist of several entity name parts, such as, "Jim", "Bob", "Walton", and
 * "Jr.", "Health Level Seven" and "Inc.", "Lake" and "Tahoe".
 *
 *
 * <p>
 * Java-Klasse für EN complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="EN">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ANY">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="delimiter" type="{urn:hl7-org:v3}en.delimiter"/>
 *           &lt;element name="family" type="{urn:hl7-org:v3}en.family"/>
 *           &lt;element name="given" type="{urn:hl7-org:v3}en.given"/>
 *           &lt;element name="prefix" type="{urn:hl7-org:v3}en.prefix"/>
 *           &lt;element name="suffix" type="{urn:hl7-org:v3}en.suffix"/>
 *         &lt;/choice>
 *         &lt;element name="validTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="use" type="{urn:hl7-org:v3}set_EntityNameUse" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EN", propOrder = { "content" })
@XmlSeeAlso({ ON.class, PN.class, TN.class })
// Fix Tony Schaller, medshare GmbH: is an extension of ANY
// (see datatypes-base.xsd)
public class EN extends ANY {

	@XmlElementRefs({
			@XmlElementRef(name = "prefix", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "given", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "validTime", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "family", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "delimiter", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "suffix", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false) })
	@XmlMixed
	protected List<Serializable> content;
	@XmlAttribute(name = "use")
	protected List<String> use;

	/**
	 *
	 * A name for a person, organization, place or thing. A sequence of name
	 * parts, such as given name or family name, prefix, suffix, etc. Examples
	 * for entity name values are "Jim Bob Walton, Jr.", "Health Level Seven,
	 * Inc.", "Lake Tahoe", etc. An entity name may be as simple as a character
	 * string or may consist of several entity name parts, such as, "Jim",
	 * "Bob", "Walton", and "Jr.", "Health Level Seven" and "Inc.", "Lake" and
	 * "Tahoe". Gets the value of the content property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the content property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getContent().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link JAXBElement }{@code <}{@link EnPrefix }{@code >}
	 * {@link JAXBElement }{@code <}{@link EnGiven }{@code >} {@link JAXBElement
	 * }{@code <}{@link IVLTS }{@code >} {@link String } {@link JAXBElement
	 * }{@code <}{@link EnFamily }{@code >} {@link JAXBElement
	 * }{@code <}{@link EnDelimiter }{@code >} {@link JAXBElement
	 * }{@code <}{@link EnSuffix }{@code >}
	 *
	 *
	 */
	public List<Serializable> getContent() {
		if (content == null) {
			content = new ArrayList<Serializable>();
		}
		return this.content;
	}

	/**
	 * Gets the value of the use property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the use property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getUse().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 *
	 *
	 */
	public List<String> getUse() {
		if (use == null) {
			use = new ArrayList<String>();
		}
		return this.use;
	}

}
