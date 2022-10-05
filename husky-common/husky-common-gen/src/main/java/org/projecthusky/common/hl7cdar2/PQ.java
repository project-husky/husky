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

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * A dimensioned quantity expressing the result of a measurement act.
 *
 *
 * <p>
 * Java-Klasse für PQ complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="PQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}QTY"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="translation" type="{urn:hl7-org:v3}PQR" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="value" type="{urn:hl7-org:v3}real" /&gt;
 *       &lt;attribute name="unit" type="{urn:hl7-org:v3}cs" default="1" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PQ", propOrder = {"translation"})
@XmlSeeAlso({HXITPQ.class, PPDPQ.class, SXCMPQ.class, IVXBPQ.class})
public class PQ extends QTY {

    protected List<PQR> translation;
    @XmlAttribute(name = "value")
    protected String value;
    @XmlAttribute(name = "unit")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String unit;

    public PQ() {
    }

    public PQ(final String value) {
        this.value = value;
    }

    public PQ(final String value,
              final String unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * Gets the value of the translation property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the translation property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getTranslation().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link PQR }
     */
    @NonNull
    public List<PQR> getTranslation() {
        if (translation == null) {
            translation = new ArrayList<>();
        }
        return this.translation;
    }

    /**
     * Ruft den Wert der unit-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    @NonNull
    public String getUnit() {
        if (unit == null) {
            return "1";
        } else {
            return unit;
        }
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
     * Legt den Wert der unit-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setUnit(String value) {
        this.unit = value;
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
