/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
 * Java-Klasse für COCT_MT230100UV.PackagedMedicine complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.PackagedMedicine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="name" type="{urn:hl7-org:v3}TN" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="formCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="lotNumberText" type="{urn:hl7-org:v3}ST" minOccurs="0"/>
 *         &lt;element name="capacityQuantity" type="{urn:hl7-org:v3}PQ" minOccurs="0"/>
 *         &lt;element name="capTypeCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="asManufacturedProduct" type="{urn:ihe:pharm}COCT_MT230100UV.ManufacturedProduct" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="asSuperContent" type="{urn:ihe:pharm}COCT_MT230100UV.SuperContent" minOccurs="0"/>
 *         &lt;element name="subContent" type="{urn:ihe:pharm}COCT_MT230100UV.SubContent" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}EntityClassContainer" />
 *       &lt;attribute name="determinerCode" use="required" type="{urn:hl7-org:v3}EntityDeterminer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.PackagedMedicine", namespace = "urn:ihe:pharm", propOrder = {
        "realmCode", "typeId", "templateId", "id", "code", "name", "formCode", "lotNumberText",
        "capacityQuantity", "capTypeCode", "asManufacturedProduct", "asSuperContent",
        "subContent" })
public class COCTMT230100UVPackagedMedicine {

    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<CS> realmCode;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected AllInfrastructureRootTypeId typeId;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<AllInfrastructureRootTemplateId> templateId;
    protected II id;
    protected CE code;
    protected List<TN> name;
    protected CE formCode;
    protected ST lotNumberText;
    protected PQ capacityQuantity;
    protected CE capTypeCode;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVManufacturedProduct> asManufacturedProduct;
    @XmlElementRef(name = "asSuperContent", namespace = "urn:ihe:pharm", type = JAXBElement.class, required = false)
    protected JAXBElement<COCTMT230100UVSuperContent> asSuperContent;
    @XmlElementRef(name = "subContent", namespace = "urn:ihe:pharm", type = JAXBElement.class, required = false)
    protected JAXBElement<COCTMT230100UVSubContent> subContent;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "classCode", required = true)
    protected EntityClassContainer classCode;
    @XmlAttribute(name = "determinerCode", required = true)
    protected String determinerCode;

    /**
     * Gets the value of the asManufacturedProduct property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the asManufacturedProduct property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAsManufacturedProduct().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVManufacturedProduct }
     *
     *
     */
    public List<COCTMT230100UVManufacturedProduct> getAsManufacturedProduct() {
        if (asManufacturedProduct == null) {
            asManufacturedProduct = new ArrayList<COCTMT230100UVManufacturedProduct>();
        }
        return this.asManufacturedProduct;
    }

    /**
     * Ruft den Wert der asSuperContent-Eigenschaft ab.
     *
     * @return possible object is {@link JAXBElement
     *         }{@code <}{@link COCTMT230100UVSuperContent }{@code >}
     *
     */
    public JAXBElement<COCTMT230100UVSuperContent> getAsSuperContent() {
        return asSuperContent;
    }

    /**
     * Ruft den Wert der capacityQuantity-Eigenschaft ab.
     *
     * @return possible object is {@link PQ }
     *
     */
    public PQ getCapacityQuantity() {
        return capacityQuantity;
    }

    /**
     * Ruft den Wert der capTypeCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     *
     */
    public CE getCapTypeCode() {
        return capTypeCode;
    }

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link EntityClassContainer }
     *
     */
    public EntityClassContainer getClassCode() {
        return classCode;
    }

    /**
     * Ruft den Wert der code-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     *
     */
    public CE getCode() {
        return code;
    }

    /**
     * Ruft den Wert der determinerCode-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDeterminerCode() {
        return determinerCode;
    }

    /**
     * Ruft den Wert der formCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     *
     */
    public CE getFormCode() {
        return formCode;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     *
     * @return possible object is {@link II }
     *
     */
    public II getId() {
        return id;
    }

    /**
     * Ruft den Wert der lotNumberText-Eigenschaft ab.
     *
     * @return possible object is {@link ST }
     *
     */
    public ST getLotNumberText() {
        return lotNumberText;
    }

    /**
     * Gets the value of the name property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the name property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getName().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link TN }
     *
     *
     */
    public List<TN> getName() {
        if (name == null) {
            name = new ArrayList<TN>();
        }
        return this.name;
    }

    /**
     * Gets the value of the nullFlavor property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
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
     *
     *
     */
    public List<String> getNullFlavor() {
        if (nullFlavor == null) {
            nullFlavor = new ArrayList<String>();
        }
        return this.nullFlavor;
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
     * Ruft den Wert der subContent-Eigenschaft ab.
     *
     * @return possible object is {@link JAXBElement
     *         }{@code <}{@link COCTMT230100UVSubContent }{@code >}
     *
     */
    public JAXBElement<COCTMT230100UVSubContent> getSubContent() {
        return subContent;
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
     * Legt den Wert der asSuperContent-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link JAXBElement
     *            }{@code <}{@link COCTMT230100UVSuperContent }{@code >}
     *
     */
    public void setAsSuperContent(JAXBElement<COCTMT230100UVSuperContent> value) {
        this.asSuperContent = value;
    }

    /**
     * Legt den Wert der capacityQuantity-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link PQ }
     *
     */
    public void setCapacityQuantity(PQ value) {
        this.capacityQuantity = value;
    }

    /**
     * Legt den Wert der capTypeCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CE }
     *
     */
    public void setCapTypeCode(CE value) {
        this.capTypeCode = value;
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link EntityClassContainer }
     *
     */
    public void setClassCode(EntityClassContainer value) {
        this.classCode = value;
    }

    /**
     * Legt den Wert der code-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CE }
     *
     */
    public void setCode(CE value) {
        this.code = value;
    }

    /**
     * Legt den Wert der determinerCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setDeterminerCode(String value) {
        this.determinerCode = value;
    }

    /**
     * Legt den Wert der formCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CE }
     *
     */
    public void setFormCode(CE value) {
        this.formCode = value;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link II }
     *
     */
    public void setId(II value) {
        this.id = value;
    }

    /**
     * Legt den Wert der lotNumberText-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link ST }
     *
     */
    public void setLotNumberText(ST value) {
        this.lotNumberText = value;
    }

    /**
     * Legt den Wert der subContent-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link JAXBElement
     *            }{@code <}{@link COCTMT230100UVSubContent }{@code >}
     *
     */
    public void setSubContent(JAXBElement<COCTMT230100UVSubContent> value) {
        this.subContent = value;
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
