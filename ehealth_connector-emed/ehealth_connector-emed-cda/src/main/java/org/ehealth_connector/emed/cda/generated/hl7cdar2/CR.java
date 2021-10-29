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

package org.ehealth_connector.emed.cda.generated.hl7cdar2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * A concept qualifier code with optionally named role. Both qualifier role and
 * value codes must be defined by the coding system. For example, if SNOMED RT
 * defines a concept "leg", a role relation "has-laterality", and another
 * concept "left", the concept role relation allows to add the qualifier
 * "has-laterality: left" to a primary code "leg" to construct the meaning "left
 * leg".
 *
 *
 * <p>
 * Java-Klasse für CR complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="CR">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ANY">
 *       &lt;sequence>
 *         &lt;element name="name" type="{urn:hl7-org:v3}CV" minOccurs="0"/>
 *         &lt;element name="value" type="{urn:hl7-org:v3}CD" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inverted" type="{urn:hl7-org:v3}bn" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CR", propOrder = { "name", "value" })
public class CR extends ANY {

    protected CV name;
    protected CD value;
    @XmlAttribute(name = "inverted")
    protected Boolean inverted;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     *
     * @return possible object is {@link CV }
     *
     */
    public CV getName() {
        return name;
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     *
     * @return possible object is {@link CD }
     *
     */
    public CD getValue() {
        return value;
    }

    /**
     * Ruft den Wert der inverted-Eigenschaft ab.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public boolean isInverted() {
        if (inverted == null) {
            return false;
        } else {
            return inverted;
        }
    }

    /**
     * Legt den Wert der inverted-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link Boolean }
     *
     */
    public void setInverted(Boolean value) {
        this.inverted = value;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CV }
     *
     */
    public void setName(CV value) {
        this.name = value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CD }
     *
     */
    public void setValue(CD value) {
        this.value = value;
    }

}
