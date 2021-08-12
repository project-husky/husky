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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java-Klasse für StrucDoc.List complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="StrucDoc.List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caption" type="{urn:hl7-org:v3}StrucDoc.Caption" minOccurs="0"/>
 *         &lt;element name="item" type="{urn:hl7-org:v3}StrucDoc.Item" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="styleCode" type="{http://www.w3.org/2001/XMLSchema}NMTOKENS" />
 *       &lt;attribute name="listType" default="unordered">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="ordered"/>
 *             &lt;enumeration value="unordered"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StrucDoc.List", propOrder = { "caption", "item" })
public class StrucDocList {

	protected StrucDocCaption caption;
	@XmlElement(required = true)
	protected List<StrucDocItem> item;
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
	@XmlAttribute(name = "listType")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String listType;

	/**
	 * Ruft den Wert der caption-Eigenschaft ab.
	 *
	 * @return possible object is {@link StrucDocCaption }
	 *
	 */
	public StrucDocCaption getCaption() {
		return caption;
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
	 * Gets the value of the item property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the item property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getItem().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link StrucDocItem }
	 *
	 *
	 */
	public List<StrucDocItem> getItem() {
		if (item == null) {
			item = new ArrayList<StrucDocItem>();
		}
		return this.item;
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
	 * Ruft den Wert der listType-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getListType() {
		if (listType == null) {
			return "unordered";
		} else {
			return listType;
		}
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
	 * Legt den Wert der caption-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link StrucDocCaption }
	 *
	 */
	public void setCaption(StrucDocCaption value) {
		this.caption = value;
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

	/**
	 * Legt den Wert der listType-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setListType(String value) {
		this.listType = value;
	}

}
