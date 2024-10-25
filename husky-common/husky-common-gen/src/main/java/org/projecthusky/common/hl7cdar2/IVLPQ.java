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

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für IVL_PQ complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="IVL_PQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}SXCM_PQ"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="low" type="{urn:hl7-org:v3}IVXB_PQ"/&gt;
 *           &lt;choice minOccurs="0"&gt;
 *             &lt;element name="width" type="{urn:hl7-org:v3}PQ" minOccurs="0"/&gt;
 *             &lt;element name="high" type="{urn:hl7-org:v3}IVXB_PQ" minOccurs="0"/&gt;
 *           &lt;/choice&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="high" type="{urn:hl7-org:v3}IVXB_PQ"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="width" type="{urn:hl7-org:v3}PQ"/&gt;
 *           &lt;element name="high" type="{urn:hl7-org:v3}IVXB_PQ" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="center" type="{urn:hl7-org:v3}PQ"/&gt;
 *           &lt;element name="width" type="{urn:hl7-org:v3}PQ" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IVL_PQ", propOrder = {"rest"})
@XmlSeeAlso({BXITIVLPQ.class})
public class IVLPQ extends SXCMPQ {

    @XmlElementRefs({
            @XmlElementRef(name = "width", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "center", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "high", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "low", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false)})
    protected List<JAXBElement<? extends PQ>> rest;

    public IVLPQ() {
    }

    public IVLPQ(final String value) {
        this.value = value;
    }

    public IVLPQ(final String value,
                 final String unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * Ruft das restliche Contentmodell ab.
     *
     * <p>
     * Sie rufen diese "catch-all"-Eigenschaft aus folgendem Grund ab: Der Feldname "High" wird von zwei verschiedenen
     * Teilen eines Schemas verwendet. Siehe: Zeile 196 von file:/C:/src/git/ehc-trunk/common/ehealth_connector-common-gen/src/main/resources/schemas/hl7cdar2/coreschemas/datatypes.xsd
     * Zeile 187 von file:/C:/src/git/ehc-trunk/common/ehealth_connector-common-gen/src/main/resources/schemas/hl7cdar2/coreschemas/datatypes.xsd
     * <p>
     * Um diese Eigenschaft zu entfernen, wenden Sie eine Eigenschaftenanpassung für eine der beiden folgenden
     * Deklarationen an, um deren Namen zu ändern: Gets the value of the rest property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the rest property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getRest().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link PQ }{@code >} {@link
     * JAXBElement }{@code <}{@link IVXBPQ }{@code >} {@link JAXBElement }{@code <}{@link PQ }{@code >} {@link
     * JAXBElement }{@code <}{@link IVXBPQ }{@code >}
     */
    @NonNull
    public List<JAXBElement<? extends PQ>> getRest() {
        if (rest == null) {
            rest = new ArrayList<>();
        }
        return this.rest;
    }

}
