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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für COCT_MT230100UV.Author complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.Author">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="time" type="{urn:hl7-org:v3}TS" minOccurs="0"/>
 *         &lt;element name="territorialAuthority" type="{urn:ihe:pharm}COCT_MT230100UV.TerritorialAuthority"/>
 *       &lt;/sequence>
 *       &lt;attribute name="typeCode" use="required" type="{urn:hl7-org:v3}ParticipationAuthorOriginator" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.Author", namespace = "urn:ihe:pharm", propOrder = { "realmCode",
        "typeId", "templateId", "time", "territorialAuthority" })
public class COCTMT230100UVAuthor {

    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<CS> realmCode;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected AllInfrastructureRootTypeId typeId;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<AllInfrastructureRootTemplateId> templateId;
    protected TS time;
    @XmlElement(required = true)
    protected COCTMT230100UVTerritorialAuthority territorialAuthority;
    @XmlAttribute(name = "typeCode", required = true)
    protected ParticipationAuthorOriginator typeCode;

    /**
     * Gets the value of the realmCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the realmCode property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getRealmCode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link CS }
     *
     *
     */
    public List<CS> getRealmCode() {
        if (realmCode == null) {
            realmCode = new ArrayList<CS>();
        }
        return this.realmCode;
    }

    /**
     * Gets the value of the templateId property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the templateId property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getTemplateId().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllInfrastructureRootTemplateId }
     *
     *
     */
    public List<AllInfrastructureRootTemplateId> getTemplateId() {
        if (templateId == null) {
            templateId = new ArrayList<AllInfrastructureRootTemplateId>();
        }
        return this.templateId;
    }

    /**
     * Ruft den Wert der territorialAuthority-Eigenschaft ab.
     *
     * @return possible object is {@link COCTMT230100UVTerritorialAuthority }
     *
     */
    public COCTMT230100UVTerritorialAuthority getTerritorialAuthority() {
        return territorialAuthority;
    }

    /**
     * Ruft den Wert der time-Eigenschaft ab.
     *
     * @return possible object is {@link TS }
     *
     */
    public TS getTime() {
        return time;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     *
     * @return possible object is {@link ParticipationAuthorOriginator }
     *
     */
    public ParticipationAuthorOriginator getTypeCode() {
        return typeCode;
    }

    /**
     * Ruft den Wert der typeId-Eigenschaft ab.
     *
     * @return possible object is {@link AllInfrastructureRootTypeId }
     *
     */
    public AllInfrastructureRootTypeId getTypeId() {
        return typeId;
    }

    /**
     * Legt den Wert der territorialAuthority-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link COCTMT230100UVTerritorialAuthority }
     *
     */
    public void setTerritorialAuthority(COCTMT230100UVTerritorialAuthority value) {
        this.territorialAuthority = value;
    }

    /**
     * Legt den Wert der time-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link TS }
     *
     */
    public void setTime(TS value) {
        this.time = value;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link ParticipationAuthorOriginator }
     *
     */
    public void setTypeCode(ParticipationAuthorOriginator value) {
        this.typeCode = value;
    }

    /**
     * Legt den Wert der typeId-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link AllInfrastructureRootTypeId }
     *
     */
    public void setTypeId(AllInfrastructureRootTypeId value) {
        this.typeId = value;
    }

}
