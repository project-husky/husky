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
 * Java-Klasse für StrucDoc.Thead complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="StrucDoc.Thead">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="tr" type="{urn:hl7-org:v3}StrucDoc.Tr"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="styleCode" type="{http://www.w3.org/2001/XMLSchema}NMTOKENS" />
 *       &lt;attribute name="align">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="left"/>
 *             &lt;enumeration value="center"/>
 *             &lt;enumeration value="right"/>
 *             &lt;enumeration value="justify"/>
 *             &lt;enumeration value="char"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="char" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="charoff" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="valign">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="top"/>
 *             &lt;enumeration value="middle"/>
 *             &lt;enumeration value="bottom"/>
 *             &lt;enumeration value="baseline"/>
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
@XmlType(name = "StrucDoc.Thead", propOrder = { "tr" })
public class StrucDocThead {

	@XmlElement(required = true)
	protected List<StrucDocTr> tr;
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
	@XmlAttribute(name = "align")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String align;
	@XmlAttribute(name = "char")
	protected String _char;
	@XmlAttribute(name = "charoff")
	protected String charoff;
	@XmlAttribute(name = "valign")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String valign;

	/**
	 * Ruft den Wert der align-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getAlign() {
		return align;
	}

	/**
	 * Ruft den Wert der char-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getChar() {
		return _char;
	}

	/**
	 * Ruft den Wert der charoff-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getCharoff() {
		return charoff;
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
	 * Gets the value of the tr property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the tr property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getTr().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link StrucDocTr }
	 *
	 *
	 */
	public List<StrucDocTr> getTr() {
		if (tr == null) {
			tr = new ArrayList<StrucDocTr>();
		}
		return this.tr;
	}

	/**
	 * Ruft den Wert der valign-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getValign() {
		return valign;
	}

	/**
	 * Legt den Wert der align-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setAlign(String value) {
		this.align = value;
	}

	/**
	 * Legt den Wert der char-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setChar(String value) {
		this._char = value;
	}

	/**
	 * Legt den Wert der charoff-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setCharoff(String value) {
		this.charoff = value;
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
	 * Legt den Wert der valign-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setValign(String value) {
		this.valign = value;
	}

}
