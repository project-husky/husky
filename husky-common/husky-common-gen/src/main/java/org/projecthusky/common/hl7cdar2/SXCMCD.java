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

/**
 * <p>
 * Java-Klasse für SXCM_CD complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="SXCM_CD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}CD"&gt;
 *       &lt;attribute name="operator" type="{urn:hl7-org:v3}SetOperator" default="I" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SXCM_CD")
public class SXCMCD extends CD {

    @XmlAttribute(name = "operator")
    protected SetOperator operator;

    /**
     * Ruft den Wert der operator-Eigenschaft ab.
     *
     * @return possible object is {@link SetOperator }
     */
    @NonNull
    public SetOperator getOperator() {
        if (operator == null) {
            return SetOperator.I;
        } else {
            return operator;
        }
    }

    /**
     * Legt den Wert der operator-Eigenschaft fest.
     *
     * @param value allowed object is {@link SetOperator }
     */
    public void setOperator(SetOperator value) {
        this.operator = value;
    }

}
