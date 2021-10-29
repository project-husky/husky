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

package org.husky.emed.cda.generated.hl7cdar2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Binary data is a raw block of bits. Binary data is a protected type that MUST
 * not be used outside the data type specification.
 *
 *
 * <p>
 * Java-Klasse für BIN complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="BIN">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ANY">
 *       &lt;attribute name="representation" type="{urn:hl7-org:v3}BinaryDataEncoding" default="TXT" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BIN")
@XmlSeeAlso({ ED.class })
public abstract class BIN extends ANY {

    @XmlAttribute(name = "representation")
    protected BinaryDataEncoding representation;

    /**
     * Ruft den Wert der representation-Eigenschaft ab.
     *
     * @return possible object is {@link BinaryDataEncoding }
     *
     */
    public BinaryDataEncoding getRepresentation() {
        if (representation == null) {
            return BinaryDataEncoding.TXT;
        } else {
            return representation;
        }
    }

    /**
     * Legt den Wert der representation-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link BinaryDataEncoding }
     *
     */
    public void setRepresentation(BinaryDataEncoding value) {
        this.representation = value;
    }

}
