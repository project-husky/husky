/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Fractional numbers. Typically used whenever quantities are measured,
 * estimated, or computed from other real numbers. The typical representation is
 * decimal, where the number of significant decimal digits is known as the
 * precision. Real numbers are needed beyond integers whenever quantities of the
 * real world are measured, estimated, or computed from other real numbers. The
 * term "Real number" in this specification is used to mean that fractional
 * values are covered without necessarily implying the full set of the
 * mathematical real numbers.
 *
 *
 * <p>
 * Java-Klasse für REAL complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="REAL">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}QTY">
 *       &lt;attribute name="value" type="{urn:hl7-org:v3}real" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REAL")
@XmlSeeAlso({ IVXBREAL.class, SXCMREAL.class })
public class REAL extends QTY {

    @XmlAttribute(name = "value")
    protected String value;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

}
