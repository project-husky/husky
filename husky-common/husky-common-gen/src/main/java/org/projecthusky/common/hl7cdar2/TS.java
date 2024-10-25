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

import org.projecthusky.common.enums.NullFlavor;

import jakarta.xml.bind.annotation.*;
import java.util.Objects;

/**
 * A quantity specifying a point on the axis of natural time. A point in time is most often represented as a calendar
 * expression.
 *
 *
 * <p>
 * Java-Klasse für TS complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="TS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}QTY"&gt;
 *       &lt;attribute name="value" type="{urn:hl7-org:v3}ts" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TS")
@XmlSeeAlso({UVPTS.class, PPDTS.class, IVXBTS.class, SXCMTS.class})
public class TS extends QTY {

    @XmlAttribute(name = "value")
    protected String value;

    public TS() {
    }

    public TS(final String value) {
        this.setValue(value);
    }

    public TS(final NullFlavor value) {
        this.getNullFlavor().add(Objects.requireNonNullElse(value, NullFlavor.UNKNOWN_L1).getCodeValue());
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

}
