/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * A character string token representing a part of a name. May have a type code
 * signifying the role of the part in the whole entity name, and a qualifier
 * code for more detail about the name part type. Typical name parts for person
 * names are given names, and family names, titles, etc.
 *
 *
 * <p>
 * Java-Klasse für ENXP complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="ENXP">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ST">
 *       &lt;attribute name="partType" type="{urn:hl7-org:v3}EntityNamePartType" />
 *       &lt;attribute name="qualifier" type="{urn:hl7-org:v3}set_EntityNamePartQualifier" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ENXP")
@XmlSeeAlso({ EnSuffix.class, EnDelimiter.class, EnGiven.class, EnFamily.class, EnPrefix.class })
public class ENXP extends ST {

    @XmlAttribute(name = "partType")
    protected String partType;
    @XmlAttribute(name = "qualifier")
    protected List<String> qualifier;

    /**
     * Ruft den Wert der partType-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getPartType() {
        return partType;
    }

    /**
     * Gets the value of the qualifier property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
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
     *
     *
     */
    public List<String> getQualifier() {
        if (qualifier == null) {
            qualifier = new ArrayList<String>();
        }
        return this.qualifier;
    }

    /**
     * Legt den Wert der partType-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setPartType(String value) {
        this.partType = value;
    }

}
