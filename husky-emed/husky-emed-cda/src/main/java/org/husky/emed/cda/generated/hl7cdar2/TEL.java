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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * A telephone number (voice or fax), e-mail address, or other locator for a
 * resource (information or service) mediated by telecommunication equipment.
 * The address is specified as a Universal Resource Locator (URL) qualified by
 * time specification and use codes that help in deciding which address to use
 * for a given time and purpose.
 *
 *
 * <p>
 * Java-Klasse für TEL complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="TEL">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}URL">
 *       &lt;sequence>
 *         &lt;element name="useablePeriod" type="{urn:hl7-org:v3}SXCM_TS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="use" type="{urn:hl7-org:v3}set_TelecommunicationAddressUse" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEL", propOrder = { "useablePeriod" })
public class TEL extends URL {

    protected List<SXCMTS> useablePeriod;
    @XmlAttribute(name = "use")
    protected List<String> use;

    /**
     * Gets the value of the use property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
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
     *
     *
     */
    public List<String> getUse() {
        if (use == null) {
            use = new ArrayList<String>();
        }
        return this.use;
    }

    /**
     * Gets the value of the useablePeriod property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the useablePeriod property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getUseablePeriod().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link SXCMTS }
     *
     *
     */
    public List<SXCMTS> getUseablePeriod() {
        if (useablePeriod == null) {
            useablePeriod = new ArrayList<SXCMTS>();
        }
        return this.useablePeriod;
    }

}
