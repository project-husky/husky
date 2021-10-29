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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * A ST that optionally may have a code attached. The text must always be
 * present if a code is present. The code is often a local code.
 *
 *
 * <p>
 * Java-Klasse für SC complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="SC">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ST">
 *       &lt;attribute name="code" type="{urn:hl7-org:v3}cs" />
 *       &lt;attribute name="codeSystem" type="{urn:hl7-org:v3}uid" />
 *       &lt;attribute name="codeSystemName" type="{urn:hl7-org:v3}st" />
 *       &lt;attribute name="codeSystemVersion" type="{urn:hl7-org:v3}st" />
 *       &lt;attribute name="displayName" type="{urn:hl7-org:v3}st" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SC")
public class SC extends ST {

    @XmlAttribute(name = "code")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String code;
    @XmlAttribute(name = "codeSystem")
    protected String codeSystem;
    @XmlAttribute(name = "codeSystemName")
    protected String codeSystemName;
    @XmlAttribute(name = "codeSystemVersion")
    protected String codeSystemVersion;
    @XmlAttribute(name = "displayName")
    protected String displayName;

    /**
     * Ruft den Wert der code-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * Ruft den Wert der codeSystem-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCodeSystem() {
        return codeSystem;
    }

    /**
     * Ruft den Wert der codeSystemName-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCodeSystemName() {
        return codeSystemName;
    }

    /**
     * Ruft den Wert der codeSystemVersion-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCodeSystemVersion() {
        return codeSystemVersion;
    }

    /**
     * Ruft den Wert der displayName-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Legt den Wert der code-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Legt den Wert der codeSystem-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setCodeSystem(String value) {
        this.codeSystem = value;
    }

    /**
     * Legt den Wert der codeSystemName-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setCodeSystemName(String value) {
        this.codeSystemName = value;
    }

    /**
     * Legt den Wert der codeSystemVersion-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setCodeSystemVersion(String value) {
        this.codeSystemVersion = value;
    }

    /**
     * Legt den Wert der displayName-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

}
