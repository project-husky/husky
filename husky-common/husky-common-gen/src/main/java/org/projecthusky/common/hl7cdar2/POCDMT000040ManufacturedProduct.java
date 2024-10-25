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

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für POCD_MT000040.ManufacturedProduct complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.ManufacturedProduct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/&gt;
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="manufacturedLabeledDrug" type="{urn:hl7-org:v3}POCD_MT000040.LabeledDrug"/&gt;
 *           &lt;element name="manufacturedMaterial" type="{urn:hl7-org:v3}POCD_MT000040.Material"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="manufacturerOrganization" type="{urn:hl7-org:v3}POCD_MT000040.Organization" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ihe:pharm}subjectOf1" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ihe:pharm}subjectOf2" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ihe:pharm}subjectOf3" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ihe:pharm}subjectOf4" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ihe:pharm}subjectOf5" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" /&gt;
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}RoleClassManufacturedProduct" fixed="MANU" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.ManufacturedProduct", propOrder = {"realmCode", "typeId",
        "templateId", "id", "manufacturedLabeledDrug", "manufacturedMaterial",
        "manufacturerOrganization", "subjectOf1", "subjectOf2", "subjectOf3", "subjectOf4",
        "subjectOf5"})
public class POCDMT000040ManufacturedProduct {

    @XmlAttribute(name = "classCode")
    protected RoleClassManufacturedProduct classCode;
    protected List<II> id;
    protected POCDMT000040LabeledDrug manufacturedLabeledDrug;
    protected POCDMT000040Material manufacturedMaterial;
    protected POCDMT000040Organization manufacturerOrganization;
    // end of fix
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    protected List<CS> realmCode;
    // Fix Tony Schaller, medshare GmbH: not existing elements shall not appear
    // as nil, but shall not appear at all.
    // @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    // protected List<COCTMT230100UVSubject2> subjectOf1;
    // @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    // protected List<COCTMT230100UVSubject1> subjectOf2;
    // @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    // protected List<COCTMT230100UVSubject22> subjectOf3;
    // @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    // protected List<COCTMT230100UVSubject3> subjectOf4;
    // @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    // protected COCTMT230100UVSubject7 subjectOf5;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected List<COCTMT230100UVSubject2> subjectOf1;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected List<COCTMT230100UVSubject1> subjectOf2;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected List<COCTMT230100UVSubject22> subjectOf3;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected List<COCTMT230100UVSubject3> subjectOf4;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected COCTMT230100UVSubject7 subjectOf5;
    protected List<II> templateId;
    protected POCDMT000040InfrastructureRootTypeId typeId;

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link RoleClassManufacturedProduct }
     */
    @NonNull
    public RoleClassManufacturedProduct getClassCode() {
        if (classCode == null) {
            return RoleClassManufacturedProduct.MANU;
        } else {
            return classCode;
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
     * Ruft den Wert der manufacturedLabeledDrug-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040LabeledDrug }
     */
    public POCDMT000040LabeledDrug getManufacturedLabeledDrug() {
        return manufacturedLabeledDrug;
    }

    /**
     * Ruft den Wert der manufacturedMaterial-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040Material }
     */
    public POCDMT000040Material getManufacturedMaterial() {
        return manufacturedMaterial;
    }

    /**
     * Ruft den Wert der manufacturerOrganization-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040Organization }
     */
    public POCDMT000040Organization getManufacturerOrganization() {
        return manufacturerOrganization;
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
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubject2 }
     */
    @NonNull
    public List<COCTMT230100UVSubject2> getSubjectOf1() {
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
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubject1 }
     */
    @NonNull
    public List<COCTMT230100UVSubject1> getSubjectOf2() {
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
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubject22 }
     */
    @NonNull
    public List<COCTMT230100UVSubject22> getSubjectOf3() {
        if (subjectOf3 == null) {
            subjectOf3 = new ArrayList<>();
        }
        return this.subjectOf3;
    }

    /**
     * Gets the value of the subjectOf4 property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subjectOf4 property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubjectOf4().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubject3 }
     */
    @NonNull
    public List<COCTMT230100UVSubject3> getSubjectOf4() {
        if (subjectOf4 == null) {
            subjectOf4 = new ArrayList<>();
        }
        return this.subjectOf4;
    }

    /**
     * Ruft den Wert der subjectOf5-Eigenschaft ab.
     *
     * @return possible object is {@link COCTMT230100UVSubject7 }
     */
    public COCTMT230100UVSubject7 getSubjectOf5() {
        return subjectOf5;
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
     * Legt den Wert der classCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link RoleClassManufacturedProduct }
     */
    public void setClassCode(RoleClassManufacturedProduct value) {
        this.classCode = value;
    }

    /**
     * Legt den Wert der manufacturedLabeledDrug-Eigenschaft fest.
     *
     * @param value allowed object is {@link POCDMT000040LabeledDrug }
     */
    public void setManufacturedLabeledDrug(POCDMT000040LabeledDrug value) {
        this.manufacturedLabeledDrug = value;
    }

    /**
     * Legt den Wert der manufacturedMaterial-Eigenschaft fest.
     *
     * @param value allowed object is {@link POCDMT000040Material }
     */
    public void setManufacturedMaterial(POCDMT000040Material value) {
        this.manufacturedMaterial = value;
    }

    /**
     * Legt den Wert der manufacturerOrganization-Eigenschaft fest.
     *
     * @param value allowed object is {@link POCDMT000040Organization }
     */
    public void setManufacturerOrganization(POCDMT000040Organization value) {
        this.manufacturerOrganization = value;
    }

    /**
     * Legt den Wert der subjectOf5-Eigenschaft fest.
     *
     * @param value allowed object is {@link COCTMT230100UVSubject7 }
     */
    public void setSubjectOf5(COCTMT230100UVSubject7 value) {
        this.subjectOf5 = value;
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
