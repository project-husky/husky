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

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für COCT_MT230100UV.ManufacturedProduct complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.ManufacturedProduct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/&gt;
 *         &lt;element name="manufacturer" type="{urn:ihe:pharm}COCT_MT230100UV.Manufacturer"/&gt;
 *         &lt;element name="subjectOf1" type="{urn:ihe:pharm}COCT_MT230100UV.Subject25" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="subjectOf2" type="{urn:ihe:pharm}COCT_MT230100UV.Subject15" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="subjectOf3" type="{urn:ihe:pharm}COCT_MT230100UV.Subject16" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" /&gt;
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}RoleClassManufacturedProduct" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.ManufacturedProduct", namespace = "urn:ihe:pharm", propOrder = {
        "realmCode", "typeId", "templateId", "manufacturer", "subjectOf1", "subjectOf2",
        "subjectOf3"})
public class COCTMT230100UVManufacturedProduct {

    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<CS> realmCode;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected AllInfrastructureRootTypeId typeId;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<AllInfrastructureRootTemplateId> templateId;
    @XmlElement(required = true)
    protected COCTMT230100UVManufacturer manufacturer;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubject25> subjectOf1;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubject15> subjectOf2;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubject16> subjectOf3;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "classCode", required = true)
    protected RoleClassManufacturedProduct classCode;

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link RoleClassManufacturedProduct }
     */
    public RoleClassManufacturedProduct getClassCode() {
        return classCode;
    }

    /**
     * Ruft den Wert der manufacturer-Eigenschaft ab.
     *
     * @return possible object is {@link COCTMT230100UVManufacturer }
     */
    public COCTMT230100UVManufacturer getManufacturer() {
        return manufacturer;
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
     * Gets the value of the subjectOf1 property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subjectOf1 property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubjectOf1().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubject25 }
     */
    @NonNull
    public List<COCTMT230100UVSubject25> getSubjectOf1() {
        if (subjectOf1 == null) {
            subjectOf1 = new ArrayList<>();
        }
        return this.subjectOf1;
    }

    /**
     * Gets the value of the subjectOf2 property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subjectOf2 property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubjectOf2().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubject15 }
     */
    @NonNull
    public List<COCTMT230100UVSubject15> getSubjectOf2() {
        if (subjectOf2 == null) {
            subjectOf2 = new ArrayList<>();
        }
        return this.subjectOf2;
    }

    /**
     * Gets the value of the subjectOf3 property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subjectOf3 property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubjectOf3().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubject16 }
     */
    @NonNull
    public List<COCTMT230100UVSubject16> getSubjectOf3() {
        if (subjectOf3 == null) {
            subjectOf3 = new ArrayList<>();
        }
        return this.subjectOf3;
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
     * @param value allowed object is {@link RoleClassManufacturedProduct }
     */
    public void setClassCode(RoleClassManufacturedProduct value) {
        this.classCode = value;
    }

    /**
     * Legt den Wert der manufacturer-Eigenschaft fest.
     *
     * @param value allowed object is {@link COCTMT230100UVManufacturer }
     */
    public void setManufacturer(COCTMT230100UVManufacturer value) {
        this.manufacturer = value;
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
