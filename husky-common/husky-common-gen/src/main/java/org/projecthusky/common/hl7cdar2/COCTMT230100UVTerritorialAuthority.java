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

package org.projecthusky.common.hl7cdar2;

import org.checkerframework.checker.nullness.qual.NonNull;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für COCT_MT230100UV.TerritorialAuthority complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.TerritorialAuthority"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/&gt;
 *         &lt;element name="territory" type="{urn:ihe:pharm}COCT_MT230100UV.Agency" minOccurs="0"/&gt;
 *         &lt;element name="governingCountry" type="{urn:ihe:pharm}COCT_MT230100UV.Country" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}RoleClassTerritoryOfAuthority" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.TerritorialAuthority", namespace = "urn:ihe:pharm", propOrder = {
        "realmCode", "typeId", "templateId", "territory", "governingCountry"})
public class COCTMT230100UVTerritorialAuthority {

    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<CS> realmCode;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected AllInfrastructureRootTypeId typeId;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<AllInfrastructureRootTemplateId> templateId;
    @XmlElementRef(name = "territory", namespace = "urn:ihe:pharm", type = JAXBElement.class, required = false)
    protected JAXBElement<COCTMT230100UVAgency> territory;
    @XmlElementRef(name = "governingCountry", namespace = "urn:ihe:pharm", type = JAXBElement.class, required = false)
    protected JAXBElement<COCTMT230100UVCountry> governingCountry;
    @XmlAttribute(name = "classCode", required = true)
    protected RoleClassTerritoryOfAuthority classCode;

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link RoleClassTerritoryOfAuthority }
     */
    public RoleClassTerritoryOfAuthority getClassCode() {
        return classCode;
    }

    /**
     * Ruft den Wert der governingCountry-Eigenschaft ab.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link COCTMT230100UVCountry }{@code >}
     */
    public JAXBElement<COCTMT230100UVCountry> getGoverningCountry() {
        return governingCountry;
    }

    /**
     * Gets the value of the realmCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
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
     */
    @NonNull
    public List<CS> getRealmCode() {
        if (realmCode == null) {
            realmCode = new ArrayList<>();
        }
        return this.realmCode;
    }

    /**
     * Gets the value of the templateId property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the templateId property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getTemplateId().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link AllInfrastructureRootTemplateId }
     */
    @NonNull
    public List<AllInfrastructureRootTemplateId> getTemplateId() {
        if (templateId == null) {
            templateId = new ArrayList<>();
        }
        return this.templateId;
    }

    /**
     * Ruft den Wert der territory-Eigenschaft ab.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link COCTMT230100UVAgency }{@code >}
     */
    public JAXBElement<COCTMT230100UVAgency> getTerritory() {
        return territory;
    }

    /**
     * Ruft den Wert der typeId-Eigenschaft ab.
     *
     * @return possible object is {@link AllInfrastructureRootTypeId }
     */
    public AllInfrastructureRootTypeId getTypeId() {
        return typeId;
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link RoleClassTerritoryOfAuthority }
     */
    public void setClassCode(RoleClassTerritoryOfAuthority value) {
        this.classCode = value;
    }

    /**
     * Legt den Wert der governingCountry-Eigenschaft fest.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link COCTMT230100UVCountry }{@code >}
     */
    public void setGoverningCountry(JAXBElement<COCTMT230100UVCountry> value) {
        this.governingCountry = value;
    }

    /**
     * Legt den Wert der territory-Eigenschaft fest.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link COCTMT230100UVAgency }{@code >}
     */
    public void setTerritory(JAXBElement<COCTMT230100UVAgency> value) {
        this.territory = value;
    }

    /**
     * Legt den Wert der typeId-Eigenschaft fest.
     *
     * @param value allowed object is {@link AllInfrastructureRootTypeId }
     */
    public void setTypeId(AllInfrastructureRootTypeId value) {
        this.typeId = value;
    }

}
