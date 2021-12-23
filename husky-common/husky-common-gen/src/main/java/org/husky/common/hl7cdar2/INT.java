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
 * Integer numbers (-1,0,1,2, 100, 3398129, etc.) are precise numbers that are results of counting and enumerating.
 * Integer numbers are discrete, the set of integers is infinite but countable. No arbitrary limit is imposed on the
 * range of integer numbers. Two NULL flavors are defined for the positive and negative infinity.
 *
 *
 * <p>
 * Java-Klasse für INT complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="INT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}QTY"&gt;
 *       &lt;attribute name="value" type="{urn:hl7-org:v3}int" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INT")
@XmlSeeAlso({IVXBINT.class, SXCMINT.class, POCDMT000040RegionOfInterestValue.class})
public class INT extends QTY {

    @XmlAttribute(name = "value")
    protected BigInteger value;

    public INT() {
    }

    public INT(final BigInteger value) {
        this.value = value;
    }

    public INT(final int value) {
        this(BigInteger.valueOf(value));
    }

    public INT(final Integer value) {
        if (value == null) {
            this.value = null;
        } else {
            this.value = BigInteger.valueOf(value);
        }
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     *
     * @return possible object is {@link BigInteger }
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     *
     * @param value allowed object is {@link BigInteger }
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

}
