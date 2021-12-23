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

import javax.xml.bind.annotation.*;

/**
 * <p>
 * Java-Klasse für RTO_QTY_QTY complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="RTO_QTY_QTY"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}QTY"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numerator" type="{urn:hl7-org:v3}QTY"/&gt;
 *         &lt;element name="denominator" type="{urn:hl7-org:v3}QTY"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTO_QTY_QTY", propOrder = {"numerator", "denominator"})
@XmlSeeAlso({RTO.class})
public class RTOQTYQTY extends QTY {

    @XmlElement(required = true)
    protected QTY numerator;
    @XmlElement(required = true)
    protected QTY denominator;

    /**
     * Ruft den Wert der denominator-Eigenschaft ab.
     *
     * @return possible object is {@link QTY }
     */
    public QTY getDenominator() {
        return denominator;
    }

    /**
     * Ruft den Wert der numerator-Eigenschaft ab.
     *
     * @return possible object is {@link QTY }
     */
    public QTY getNumerator() {
        return numerator;
    }

    /**
     * Legt den Wert der denominator-Eigenschaft fest.
     *
     * @param value allowed object is {@link QTY }
     */
    public void setDenominator(QTY value) {
        this.denominator = value;
    }

    /**
     * Legt den Wert der numerator-Eigenschaft fest.
     *
     * @param value allowed object is {@link QTY }
     */
    public void setNumerator(QTY value) {
        this.numerator = value;
    }

}
