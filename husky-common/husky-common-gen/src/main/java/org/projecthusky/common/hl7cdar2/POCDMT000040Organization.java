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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für POCD_MT000040.Organization complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.Organization"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/&gt;
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{urn:hl7-org:v3}ON" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="telecom" type="{urn:hl7-org:v3}TEL" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="addr" type="{urn:hl7-org:v3}AD" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="standardIndustryClassCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="asOrganizationPartOf" type="{urn:hl7-org:v3}POCD_MT000040.OrganizationPartOf" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" /&gt;
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}EntityClassOrganization" fixed="ORG" /&gt;
 *       &lt;attribute name="determinerCode" type="{urn:hl7-org:v3}EntityDeterminer" fixed="INSTANCE" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Organization", propOrder = {"realmCode", "typeId", "templateId",
        "id", "name", "telecom", "addr", "standardIndustryClassCode", "asOrganizationPartOf"})
public class POCDMT000040Organization {

    protected List<CS> realmCode;
    protected POCDMT000040InfrastructureRootTypeId typeId;
    protected List<II> templateId;
    protected List<II> id;
    protected List<ON> name;
    protected List<TEL> telecom;
    protected List<AD> addr;
    protected CE standardIndustryClassCode;
    protected POCDMT000040OrganizationPartOf asOrganizationPartOf;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "classCode")
    protected String classCode;
    @XmlAttribute(name = "determinerCode")
    protected String determinerCode;

    /**
     * Gets the value of the addr property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the addr property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAddr().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link AD }
     */
    @NonNull
    public List<AD> getAddr() {
        if (addr == null) {
            addr = new ArrayList<>();
        }
        return this.addr;
    }

    /**
     * Ruft den Wert der asOrganizationPartOf-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040OrganizationPartOf }
     */
    public POCDMT000040OrganizationPartOf getAsOrganizationPartOf() {
        return asOrganizationPartOf;
    }

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    @NonNull
    public String getClassCode() {
        if (classCode == null) {
            return "ORG";
        } else {
            return classCode;
        }
    }

    /**
     * Ruft den Wert der determinerCode-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    @NonNull
    public String getDeterminerCode() {
        if (determinerCode == null) {
            return "INSTANCE";
        } else {
            return determinerCode;
        }
    }

    /**
     * Gets the value of the id property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the id property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getId().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link II }
     */
    @NonNull
    public List<II> getId() {
        if (id == null) {
            id = new ArrayList<>();
        }
        return this.id;
    }

    /**
     * Gets the value of the name property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the name property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getName().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link ON }
     */
    @NonNull
    public List<ON> getName() {
        if (name == null) {
            name = new ArrayList<>();
        }
        return this.name;
    }

    /**
     * Gets the value of the nullFlavor property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the nullFlavor property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getNullFlavor().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    @NonNull
    public List<String> getNullFlavor() {
        if (nullFlavor == null) {
            nullFlavor = new ArrayList<>();
        }
        return this.nullFlavor;
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
     * Ruft den Wert der standardIndustryClassCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getStandardIndustryClassCode() {
        return standardIndustryClassCode;
    }

    /**
     * Gets the value of the telecom property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the telecom property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getTelecom().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link TEL }
     */
    @NonNull
    public List<TEL> getTelecom() {
        if (telecom == null) {
            telecom = new ArrayList<>();
        }
        return this.telecom;
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
     * Objects of the following type(s) are allowed in the list {@link II }
     */
    @NonNull
    public List<II> getTemplateId() {
        if (templateId == null) {
            templateId = new ArrayList<>();
        }
        return this.templateId;
    }

    /**
     * Ruft den Wert der typeId-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040InfrastructureRootTypeId }
     */
    public POCDMT000040InfrastructureRootTypeId getTypeId() {
        return typeId;
    }

    /**
     * Legt den Wert der asOrganizationPartOf-Eigenschaft fest.
     *
     * @param value allowed object is {@link POCDMT000040OrganizationPartOf }
     */
    public void setAsOrganizationPartOf(POCDMT000040OrganizationPartOf value) {
        this.asOrganizationPartOf = value;
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setClassCode(String value) {
        this.classCode = value;
    }

    /**
     * Legt den Wert der determinerCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setDeterminerCode(String value) {
        this.determinerCode = value;
    }

    /**
     * Legt den Wert der standardIndustryClassCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setStandardIndustryClassCode(CE value) {
        this.standardIndustryClassCode = value;
    }

    /**
     * Legt den Wert der typeId-Eigenschaft fest.
     *
     * @param value allowed object is {@link POCDMT000040InfrastructureRootTypeId }
     */
    public void setTypeId(POCDMT000040InfrastructureRootTypeId value) {
        this.typeId = value;
    }

}
