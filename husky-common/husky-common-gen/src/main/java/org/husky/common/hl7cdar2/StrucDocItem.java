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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java-Klasse für StrucDoc.Item complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="StrucDoc.Item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caption" type="{urn:hl7-org:v3}StrucDoc.Caption" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="content" type="{urn:hl7-org:v3}StrucDoc.Content"/>
 *           &lt;element name="linkHtml" type="{urn:hl7-org:v3}StrucDoc.LinkHtml"/>
 *           &lt;element name="sub" type="{urn:hl7-org:v3}StrucDoc.Sub"/>
 *           &lt;element name="sup" type="{urn:hl7-org:v3}StrucDoc.Sup"/>
 *           &lt;element name="br" type="{urn:hl7-org:v3}StrucDoc.Br"/>
 *           &lt;element name="footnote" type="{urn:hl7-org:v3}StrucDoc.Footnote"/>
 *           &lt;element name="footnoteRef" type="{urn:hl7-org:v3}StrucDoc.FootnoteRef"/>
 *           &lt;element name="renderMultiMedia" type="{urn:hl7-org:v3}StrucDoc.RenderMultiMedia"/>
 *           &lt;element name="paragraph" type="{urn:hl7-org:v3}StrucDoc.Paragraph"/>
 *           &lt;element name="list" type="{urn:hl7-org:v3}StrucDoc.List"/>
 *           &lt;element name="table" type="{urn:hl7-org:v3}StrucDoc.Table"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="styleCode" type="{http://www.w3.org/2001/XMLSchema}NMTOKENS" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StrucDoc.Item", propOrder = { "content" })
public class StrucDocItem {

	@XmlElementRefs({
			@XmlElementRef(name = "br", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "footnoteRef", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "caption", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "sub", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "table", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "sup", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "content", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "linkHtml", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "footnote", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "list", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "renderMultiMedia", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "paragraph", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false) })
	@XmlMixed
	protected List<Serializable> content;
	@XmlAttribute(name = "ID")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "language")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NMTOKEN")
	protected String language;
	@XmlAttribute(name = "styleCode")
	@XmlSchemaType(name = "NMTOKENS")
	protected List<String> styleCode;

	/**
	 * Gets the value of the content property.
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
	 * {@link JAXBElement }{@code <}{@link StrucDocBr }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocFootnoteRef }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocCaption }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocLinkHtml }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocList }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocSub }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocTable }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocSup }{@code >} {@link String
	 * } {@link JAXBElement }{@code <}{@link StrucDocContent }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocFootnote }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocRenderMultiMedia }{@code >}
	 * {@link JAXBElement }{@code <}{@link StrucDocParagraph }{@code >}
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
	 * Ruft den Wert der id-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getID() {
		return id;
	}

	/**
	 * Ruft den Wert der language-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Gets the value of the styleCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the styleCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getStyleCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 *
	 *
	 */
	public List<String> getStyleCode() {
		if (styleCode == null) {
			styleCode = new ArrayList<String>();
		}
		return this.styleCode;
	}

	/**
	 * Legt den Wert der id-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setID(String value) {
		this.id = value;
	}

	/**
	 * Legt den Wert der language-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setLanguage(String value) {
		this.language = value;
	}

}
