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

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Integer numbers (-1,0,1,2, 100, 3398129, etc.) are precise numbers that are
 * results of counting and enumerating. Integer numbers are discrete, the set of
 * integers is infinite but countable. No arbitrary limit is imposed on the
 * range of integer numbers. Two NULL flavors are defined for the positive and
 * negative infinity.
 *
 *
 * <p>
 * Java-Klasse für INT complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="INT">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}QTY">
 *       &lt;attribute name="value" type="{urn:hl7-org:v3}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INT")
@XmlSeeAlso({ IVXBINT.class, SXCMINT.class, POCDMT000040RegionOfInterestValue.class })
public class INT extends QTY {

	@XmlAttribute(name = "value")
	protected BigInteger value;

	/**
	 * Ruft den Wert der value-Eigenschaft ab.
	 *
	 * @return possible object is {@link BigInteger }
	 *
	 */
	public BigInteger getValue() {
		return value;
	}

	/**
	 * Legt den Wert der value-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link BigInteger }
	 *
	 */
	public void setValue(BigInteger value) {
		this.value = value;
	}

}
