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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Note: because this type is defined as an extension of SXCM_T, all of the attributes and elements accepted for T are
 * also accepted by this definition. However, they are NOT allowed by the normative description of this type.
 * Unfortunately, we cannot write a general purpose schematron contraints to provide that extra validation, thus
 * applications must be aware that instance (fragments) that pass validation with this might might still not be legal.
 *
 *
 * <p>
 * Java-Klasse für EIVL_TS complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="EIVL_TS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}SXCM_TS"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="event" type="{urn:hl7-org:v3}EIVL.event" minOccurs="0"/&gt;
 *         &lt;element name="offset" type="{urn:hl7-org:v3}IVL_PQ" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EIVL_TS", propOrder = {"event", "offset"})
public class EIVLTS extends SXCMTS {

    protected EIVLEvent event;
    protected IVLPQ offset;

    /**
     * Ruft den Wert der event-Eigenschaft ab.
     *
     * @return possible object is {@link EIVLEvent }
     */
    public EIVLEvent getEvent() {
        return event;
    }

    /**
     * Ruft den Wert der offset-Eigenschaft ab.
     *
     * @return possible object is {@link IVLPQ }
     */
    public IVLPQ getOffset() {
        return offset;
    }

    /**
     * Legt den Wert der event-Eigenschaft fest.
     *
     * @param value allowed object is {@link EIVLEvent }
     */
    public void setEvent(EIVLEvent value) {
        this.event = value;
    }

    /**
     * Legt den Wert der offset-Eigenschaft fest.
     *
     * @param value allowed object is {@link IVLPQ }
     */
    public void setOffset(IVLPQ value) {
        this.offset = value;
    }

}
