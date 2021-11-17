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

package org.husky.common.hl7cdar2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für COCT_MT230100UV.Medication complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.Medication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="administerableMedicine" type="{urn:ihe:pharm}COCT_MT230100UV.Medicine"/>
 *         &lt;element name="subjectOf1" type="{urn:ihe:pharm}COCT_MT230100UV.Subject2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subjectOf2" type="{urn:ihe:pharm}COCT_MT230100UV.Subject1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subjectOf3" type="{urn:ihe:pharm}COCT_MT230100UV.Subject22" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subjectOf4" type="{urn:ihe:pharm}COCT_MT230100UV.Subject3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subjectOf5" type="{urn:ihe:pharm}COCT_MT230100UV.Subject7" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}RoleClassAdministerableMaterial" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.Medication", namespace = "urn:ihe:pharm", propOrder = {
        "realmCode", "typeId", "templateId", "administerableMedicine", "subjectOf1", "subjectOf2",
        "subjectOf3", "subjectOf4", "subjectOf5" })
public class COCTMT230100UVMedication {

    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<CS> realmCode;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected AllInfrastructureRootTypeId typeId;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<AllInfrastructureRootTemplateId> templateId;
    @XmlElement(required = true)
    protected COCTMT230100UVMedicine administerableMedicine;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubject2> subjectOf1;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubject1> subjectOf2;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubject22> subjectOf3;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubject3> subjectOf4;
    @XmlElementRef(name = "subjectOf5", namespace = "urn:ihe:pharm", type = JAXBElement.class, required = false)
    protected JAXBElement<COCTMT230100UVSubject7> subjectOf5;
    @XmlAttribute(name = "classCode", required = true)
    protected RoleClassAdministerableMaterial classCode;

    /**
     * Ruft den Wert der administerableMedicine-Eigenschaft ab.
     *
     * @return possible object is {@link COCTMT230100UVMedicine }
     *
     */
    public COCTMT230100UVMedicine getAdministerableMedicine() {
        return administerableMedicine;
    }

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link RoleClassAdministerableMaterial }
     *
     */
    public RoleClassAdministerableMaterial getClassCode() {
        return classCode;
    }

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
     * Gets the value of the subjectOf1 property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subjectOf1 property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubjectOf1().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVSubject2 }
     *
     *
     */
    public List<COCTMT230100UVSubject2> getSubjectOf1() {
        if (subjectOf1 == null) {
            subjectOf1 = new ArrayList<COCTMT230100UVSubject2>();
        }
        return this.subjectOf1;
    }

    /**
     * Gets the value of the subjectOf2 property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subjectOf2 property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubjectOf2().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVSubject1 }
     *
     *
     */
    public List<COCTMT230100UVSubject1> getSubjectOf2() {
        if (subjectOf2 == null) {
            subjectOf2 = new ArrayList<COCTMT230100UVSubject1>();
        }
        return this.subjectOf2;
    }

    /**
     * Gets the value of the subjectOf3 property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subjectOf3 property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubjectOf3().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVSubject22 }
     *
     *
     */
    public List<COCTMT230100UVSubject22> getSubjectOf3() {
        if (subjectOf3 == null) {
            subjectOf3 = new ArrayList<COCTMT230100UVSubject22>();
        }
        return this.subjectOf3;
    }

    /**
     * Gets the value of the subjectOf4 property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subjectOf4 property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubjectOf4().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVSubject3 }
     *
     *
     */
    public List<COCTMT230100UVSubject3> getSubjectOf4() {
        if (subjectOf4 == null) {
            subjectOf4 = new ArrayList<COCTMT230100UVSubject3>();
        }
        return this.subjectOf4;
    }

    /**
     * Ruft den Wert der subjectOf5-Eigenschaft ab.
     *
     * @return possible object is {@link JAXBElement
     *         }{@code <}{@link COCTMT230100UVSubject7 }{@code >}
     *
     */
    public JAXBElement<COCTMT230100UVSubject7> getSubjectOf5() {
        return subjectOf5;
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
     * Ruft den Wert der typeId-Eigenschaft ab.
     *
     * @return possible object is {@link AllInfrastructureRootTypeId }
     *
     */
    public AllInfrastructureRootTypeId getTypeId() {
        return typeId;
    }

    /**
     * Legt den Wert der administerableMedicine-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link COCTMT230100UVMedicine }
     *
     */
    public void setAdministerableMedicine(COCTMT230100UVMedicine value) {
        this.administerableMedicine = value;
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link RoleClassAdministerableMaterial }
     *
     */
    public void setClassCode(RoleClassAdministerableMaterial value) {
        this.classCode = value;
    }

    /**
     * Legt den Wert der subjectOf5-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link JAXBElement
     *            }{@code <}{@link COCTMT230100UVSubject7 }{@code >}
     *
     */
    public void setSubjectOf5(JAXBElement<COCTMT230100UVSubject7> value) {
        this.subjectOf5 = value;
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
