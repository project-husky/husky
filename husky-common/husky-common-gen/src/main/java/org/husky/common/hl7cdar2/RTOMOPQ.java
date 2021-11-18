/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
