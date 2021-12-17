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
import java.math.BigInteger;

/**
 * <p>
 * Java-Klasse für GLIST_PQ complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="GLIST_PQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}ANY"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="head" type="{urn:hl7-org:v3}PQ"/&gt;
 *         &lt;element name="increment" type="{urn:hl7-org:v3}PQ"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="period" type="{urn:hl7-org:v3}int" /&gt;
 *       &lt;attribute name="denominator" type="{urn:hl7-org:v3}int" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GLIST_PQ", propOrder = {"head", "increment"})
public class GLISTPQ extends ANY {

    @XmlElement(required = true)
    protected PQ head;
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
     */
    public BigInteger getDenominator() {
        return denominator;
    }

    /**
     * Ruft den Wert der head-Eigenschaft ab.
     *
     * @return possible object is {@link PQ }
     */
    public PQ getHead() {
        return head;
    }

    /**
     * Ruft den Wert der increment-Eigenschaft ab.
     *
     * @return possible object is {@link PQ }
     */
    public PQ getIncrement() {
        return increment;
    }

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     *
     * @return possible object is {@link BigInteger }
     */
    public BigInteger getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der denominator-Eigenschaft fest.
     *
     * @param value allowed object is {@link BigInteger }
     */
    public void setDenominator(BigInteger value) {
        this.denominator = value;
    }

    /**
     * Legt den Wert der head-Eigenschaft fest.
     *
     * @param value allowed object is {@link PQ }
     */
    public void setHead(PQ value) {
        this.head = value;
    }

    /**
     * Legt den Wert der increment-Eigenschaft fest.
     *
     * @param value allowed object is {@link PQ }
     */
    public void setIncrement(PQ value) {
        this.increment = value;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     *
     * @param value allowed object is {@link BigInteger }
     */
    public void setPeriod(BigInteger value) {
        this.period = value;
    }

}
