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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A name for a person, organization, place or thing. A sequence of name parts, such as given name or family name,
 * prefix, suffix, etc. Examples for entity name values are "Jim Bob Walton, Jr.", "Health Level Seven, Inc.", "Lake
 * Tahoe", etc. An entity name may be as simple as a character string or may consist of several entity name parts, such
 * as, "Jim", "Bob", "Walton", and "Jr.", "Health Level Seven" and "Inc.", "Lake" and "Tahoe".
 *
 *
 * <p>
 * Java-Klasse für EN complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="EN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}ANY"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="delimiter" type="{urn:hl7-org:v3}en.delimiter"/&gt;
 *           &lt;element name="family" type="{urn:hl7-org:v3}en.family"/&gt;
 *           &lt;element name="given" type="{urn:hl7-org:v3}en.given"/&gt;
 *           &lt;element name="prefix" type="{urn:hl7-org:v3}en.prefix"/&gt;
 *           &lt;element name="suffix" type="{urn:hl7-org:v3}en.suffix"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="validTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="use" type="{urn:hl7-org:v3}set_EntityNameUse" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EN", propOrder = {"content"})
@XmlSeeAlso({ON.class, PN.class, TN.class})
// Fix Tony Schaller, medshare GmbH: is an extension of ANY
// (see datatypes-base.xsd)
public class EN extends ANY {

    @XmlElementRefs({
            @XmlElementRef(name = "prefix", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "given", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "validTime", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "family", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "delimiter", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "suffix", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false)})
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "use")
    protected List<String> use;

    public EN() {
    }

    public EN(final String name) {
        this.setXmlMixed(name);
    }

    /**
     * A name for a person, organization, place or thing. A sequence of name parts, such as given name or family name,
     * prefix, suffix, etc. Examples for entity name values are "Jim Bob Walton, Jr.", "Health Level Seven, Inc.", "Lake
     * Tahoe", etc. An entity name may be as simple as a character string or may consist of several entity name parts,
     * such as, "Jim", "Bob", "Walton", and "Jr.", "Health Level Seven" and "Inc.", "Lake" and "Tahoe". Gets the value
     * of the content property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the content property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link EnPrefix }{@code >}
     * {@link JAXBElement }{@code <}{@link EnGiven }{@code >} {@link JAXBElement }{@code <}{@link IVLTS }{@code >}
     * {@link String } {@link JAXBElement }{@code <}{@link EnFamily }{@code >} {@link JAXBElement }{@code <}{@link
     * EnDelimiter }{@code >} {@link JAXBElement }{@code <}{@link EnSuffix }{@code >}
     */
    @NonNull
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<>();
        }
        return this.content;
    }

    /**
     * Gets the value of the use property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the use property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getUse().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    @NonNull
    public List<String> getUse() {
        if (use == null) {
            use = new ArrayList<>();
        }
        return this.use;
    }

}
