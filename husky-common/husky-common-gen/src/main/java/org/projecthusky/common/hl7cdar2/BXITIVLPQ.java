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

package org.projecthusky.common.hl7cdar2;

import org.checkerframework.checker.nullness.qual.NonNull;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigInteger;

/**
 * <p>
 * Java-Klasse für BXIT_IVL_PQ complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="BXIT_IVL_PQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}IVL_PQ"&gt;
 *       &lt;attribute name="qty" type="{urn:hl7-org:v3}int" default="1" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BXIT_IVL_PQ")
public class BXITIVLPQ extends IVLPQ {

    @XmlAttribute(name = "qty")
    protected BigInteger qty;

    /**
     * Ruft den Wert der qty-Eigenschaft ab.
     *
     * @return possible object is {@link BigInteger }
     */
    @NonNull
    public BigInteger getQty() {
        if (qty == null) {
            return BigInteger.valueOf(1);
        } else {
            return qty;
        }
    }

    /**
     * Legt den Wert der qty-Eigenschaft fest.
     *
     * @param value allowed object is {@link BigInteger }
     */
    public void setQty(BigInteger value) {
        this.qty = value;
    }

}
