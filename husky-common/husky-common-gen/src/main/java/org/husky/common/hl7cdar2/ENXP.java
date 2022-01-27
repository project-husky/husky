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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A character string token representing a part of a name. May have a type code signifying the role of the part in the
 * whole entity name, and a qualifier code for more detail about the name part type. Typical name parts for person names
 * are given names, and family names, titles, etc.
 *
 *
 * <p>
 * Java-Klasse für ENXP complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="ENXP"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}ST"&gt;
 *       &lt;attribute name="partType" type="{urn:hl7-org:v3}EntityNamePartType" /&gt;
 *       &lt;attribute name="qualifier" type="{urn:hl7-org:v3}set_EntityNamePartQualifier" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ENXP")
@XmlSeeAlso({EnSuffix.class, EnDelimiter.class, EnGiven.class, EnFamily.class, EnPrefix.class})
public class ENXP extends ST {

    @XmlAttribute(name = "partType")
    protected String partType;
    @XmlAttribute(name = "qualifier")
    protected List<String> qualifier;

    /**
     * Ruft den Wert der partType-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getPartType() {
        return partType;
    }

    /**
     * Gets the value of the qualifier property and sets it to a new list if it was {@code null}.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the qualifier property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getQualifier().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    @NonNull
    public List<String> getQualifier() {
        if (qualifier == null) {
            qualifier = new ArrayList<>();
        }
        return this.qualifier;
    }

    /**
     * Gets the value of the qualifier property. If {@code replaceNullByEmptyList} is set to {@code true}, the
     * property is set to a new list if it was {@code null}.
     *
     * <p>
     * If {@code replaceNullByEmptyList} is set to {@code true}, this accessor method returns a reference to the
     * live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the qualifier property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getQualifier().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    @NonNull
    public List<String> getQualifier(final boolean replaceNullByEmptyList) {
        if (qualifier == null) {
            if (replaceNullByEmptyList) {
                qualifier = new ArrayList<>();
            } else {
                return Collections.emptyList();
            }
        }
        return this.qualifier;
    }

    /**
     * Legt den Wert der partType-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setPartType(String value) {
        this.partType = value;
    }

}
