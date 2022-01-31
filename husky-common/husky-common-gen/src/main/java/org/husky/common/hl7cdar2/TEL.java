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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * A telephone number (voice or fax), e-mail address, or other locator for a resource (information or service) mediated
 * by telecommunication equipment. The address is specified as a Universal Resource Locator (URL) qualified by time
 * specification and use codes that help in deciding which address to use for a given time and purpose.
 *
 *
 * <p>
 * Java-Klasse für TEL complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="TEL"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}URL"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="useablePeriod" type="{urn:hl7-org:v3}SXCM_TS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="use" type="{urn:hl7-org:v3}set_TelecommunicationAddressUse" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEL", propOrder = {"useablePeriod"})
public class TEL extends URL {

    protected List<SXCMTS> useablePeriod;
    @XmlAttribute(name = "use")
    protected List<String> use;

    public TEL() {
    }

    public TEL(final String value) {
        this.value = value;
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

    /**
     * Gets the value of the useablePeriod property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
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
     */
    @NonNull
    public List<SXCMTS> getUseablePeriod() {
        if (useablePeriod == null) {
            useablePeriod = new ArrayList<>();
        }
        return this.useablePeriod;
    }

}
