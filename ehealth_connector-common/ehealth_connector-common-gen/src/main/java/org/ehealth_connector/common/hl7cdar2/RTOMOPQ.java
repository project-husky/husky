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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für RTO_MO_PQ complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="RTO_MO_PQ">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}QTY">
 *       &lt;sequence>
 *         &lt;element name="numerator" type="{urn:hl7-org:v3}MO"/>
 *         &lt;element name="denominator" type="{urn:hl7-org:v3}PQ"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTO_MO_PQ", propOrder = { "numerator", "denominator" })
public class RTOMOPQ extends QTY {

	@XmlElement(required = true)
	protected MO numerator;
	@XmlElement(required = true)
	protected PQ denominator;

	/**
	 * Ruft den Wert der denominator-Eigenschaft ab.
	 *
	 * @return possible object is {@link PQ }
	 *
	 */
	public PQ getDenominator() {
		return denominator;
	}

	/**
	 * Ruft den Wert der numerator-Eigenschaft ab.
	 *
	 * @return possible object is {@link MO }
	 *
	 */
	public MO getNumerator() {
		return numerator;
	}

	/**
	 * Legt den Wert der denominator-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link PQ }
	 *
	 */
	public void setDenominator(PQ value) {
		this.denominator = value;
	}

	/**
	 * Legt den Wert der numerator-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link MO }
	 *
	 */
	public void setNumerator(MO value) {
		this.numerator = value;
	}

}
