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

import org.checkerframework.checker.nullness.qual.NonNull;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für SLIST_TS complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="SLIST_TS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}ANY"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="origin" type="{urn:hl7-org:v3}TS"/&gt;
 *         &lt;element name="scale" type="{urn:hl7-org:v3}PQ"/&gt;
 *         &lt;element name="digits" type="{urn:hl7-org:v3}list_int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLIST_TS", propOrder = {"origin", "scale", "digits"})
public class SLISTTS extends ANY {

    @XmlElement(required = true)
    protected TS origin;
    @XmlElement(required = true)
    protected PQ scale;
    @XmlList
    @XmlElement(required = true)
    protected List<BigInteger> digits;

    /**
     * Gets the value of the digits property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the digits property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getDigits().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link BigInteger }
     */
    @NonNull
    public List<BigInteger> getDigits() {
        if (digits == null) {
            digits = new ArrayList<>();
        }
        return this.digits;
    }

    /**
     * Ruft den Wert der origin-Eigenschaft ab.
     *
     * @return possible object is {@link TS }
     */
    public TS getOrigin() {
        return origin;
    }

    /**
     * Ruft den Wert der scale-Eigenschaft ab.
     *
     * @return possible object is {@link PQ }
     */
    public PQ getScale() {
        return scale;
    }

    /**
     * Legt den Wert der origin-Eigenschaft fest.
     *
     * @param value allowed object is {@link TS }
     */
    public void setOrigin(TS value) {
        this.origin = value;
    }

    /**
     * Legt den Wert der scale-Eigenschaft fest.
     *
     * @param value allowed object is {@link PQ }
     */
    public void setScale(PQ value) {
        this.scale = value;
    }

}
