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

package org.ehealth_connector.emed.cda.generated.hl7cdar2;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für GLIST_TS complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="GLIST_TS">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ANY">
 *       &lt;sequence>
 *         &lt;element name="head" type="{urn:hl7-org:v3}TS"/>
 *         &lt;element name="increment" type="{urn:hl7-org:v3}PQ"/>
 *       &lt;/sequence>
 *       &lt;attribute name="period" type="{urn:hl7-org:v3}int" />
 *       &lt;attribute name="denominator" type="{urn:hl7-org:v3}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GLIST_TS", propOrder = { "head", "increment" })
public class GLISTTS extends ANY {

    @XmlElement(required = true)
    protected TS head;
    @XmlElement(required = true)
    protected PQ increment;
    @XmlAttribute(name = "period")
    protected BigInteger period;
    @XmlAttribute(name = "denominator")
    protected BigInteger denominator;

    /**
     * Ruft den Wert der denominator-Eigenschaft ab.
     *
     * @return possible object is {@link BigInteger }
     *
     */
    public BigInteger getDenominator() {
        return denominator;
    }

    /**
     * Ruft den Wert der head-Eigenschaft ab.
     *
     * @return possible object is {@link TS }
     *
     */
    public TS getHead() {
        return head;
    }

    /**
     * Ruft den Wert der increment-Eigenschaft ab.
     *
     * @return possible object is {@link PQ }
     *
     */
    public PQ getIncrement() {
        return increment;
    }

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     *
     * @return possible object is {@link BigInteger }
     *
     */
    public BigInteger getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der denominator-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link BigInteger }
     *
     */
    public void setDenominator(BigInteger value) {
        this.denominator = value;
    }

    /**
     * Legt den Wert der head-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link TS }
     *
     */
    public void setHead(TS value) {
        this.head = value;
    }

    /**
     * Legt den Wert der increment-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link PQ }
     *
     */
    public void setIncrement(PQ value) {
        this.increment = value;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link BigInteger }
     *
     */
    public void setPeriod(BigInteger value) {
        this.period = value;
    }

}
