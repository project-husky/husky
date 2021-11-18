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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für PPD_PQ complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="PPD_PQ">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}PQ">
 *       &lt;sequence>
 *         &lt;element name="standardDeviation" type="{urn:hl7-org:v3}PQ" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="distributionType" type="{urn:hl7-org:v3}ProbabilityDistributionType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PPD_PQ", propOrder = { "standardDeviation" })
@XmlSeeAlso({ SXCMPPDPQ.class, IVXBPPDPQ.class })
public class PPDPQ extends PQ {

    protected PQ standardDeviation;
    @XmlAttribute(name = "distributionType")
    protected ProbabilityDistributionType distributionType;

    /**
     * Ruft den Wert der distributionType-Eigenschaft ab.
     *
     * @return possible object is {@link ProbabilityDistributionType }
     *
     */
    public ProbabilityDistributionType getDistributionType() {
        return distributionType;
    }

    /**
     * Ruft den Wert der standardDeviation-Eigenschaft ab.
     *
     * @return possible object is {@link PQ }
     *
     */
    public PQ getStandardDeviation() {
        return standardDeviation;
    }

    /**
     * Legt den Wert der distributionType-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link ProbabilityDistributionType }
     *
     */
    public void setDistributionType(ProbabilityDistributionType value) {
        this.distributionType = value;
    }

    /**
     * Legt den Wert der standardDeviation-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link PQ }
     *
     */
    public void setStandardDeviation(PQ value) {
        this.standardDeviation = value;
    }

}
