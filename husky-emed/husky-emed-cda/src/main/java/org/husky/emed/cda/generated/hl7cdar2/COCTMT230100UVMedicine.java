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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für COCT_MT230100UV.Medicine complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.Medicine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="name" type="{urn:hl7-org:v3}TN" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="desc" type="{urn:hl7-org:v3}ED" minOccurs="0"/>
 *         &lt;element name="riskCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="handlingCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="formCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="lotNumberText" type="{urn:hl7-org:v3}ST" minOccurs="0"/>
 *         &lt;element name="expirationTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *         &lt;element name="stabilityTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *         &lt;element name="asDistributedProduct" type="{urn:ihe:pharm}COCT_MT230100UV.DistributedProduct" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="asMedicineManufacturer" type="{urn:ihe:pharm}COCT_MT230100UV.MedicineManufacturer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="asContent" type="{urn:ihe:pharm}COCT_MT230100UV.Content" minOccurs="0"/>
 *         &lt;element name="asSpecializedKind" type="{urn:ihe:pharm}COCT_MT230100UV.SpecializedKind" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="part" type="{urn:ihe:pharm}COCT_MT230100UV.Part" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ingredient" type="{urn:ihe:pharm}COCT_MT230100UV.Ingredient" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}EntityClassManufacturedMaterial" />
 *       &lt;attribute name="determinerCode" use="required" type="{urn:hl7-org:v3}EntityDeterminer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.Medicine", namespace = "urn:ihe:pharm", propOrder = { "realmCode",
        "typeId", "templateId", "id", "code", "name", "desc", "riskCode", "handlingCode",
        "formCode", "lotNumberText", "expirationTime", "stabilityTime", "asDistributedProduct",
        "asMedicineManufacturer", "asContent", "asSpecializedKind", "part", "ingredient" })
public class COCTMT230100UVMedicine {

    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<CS> realmCode;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected AllInfrastructureRootTypeId typeId;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<AllInfrastructureRootTemplateId> templateId;
    protected II id;
    protected CE code;
    protected List<TN> name;
    protected ED desc;
    protected CE riskCode;
    protected CE handlingCode;
    protected CE formCode;
    protected ST lotNumberText;
    protected IVLTS expirationTime;
    protected IVLTS stabilityTime;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVDistributedProduct> asDistributedProduct;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVMedicineManufacturer> asMedicineManufacturer;
    @XmlElementRef(name = "asContent", namespace = "urn:ihe:pharm", type = JAXBElement.class, required = false)
    protected JAXBElement<COCTMT230100UVContent> asContent;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSpecializedKind> asSpecializedKind;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVPart> part;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVIngredient> ingredient;
    @XmlAttribute(name = "classCode", required = true)
    protected String classCode;
    @XmlAttribute(name = "determinerCode", required = true)
    protected String determinerCode;

    /**
     * Ruft den Wert der asContent-Eigenschaft ab.
     *
     * @return possible object is {@link JAXBElement
     *         }{@code <}{@link COCTMT230100UVContent }{@code >}
     *
     */
    public JAXBElement<COCTMT230100UVContent> getAsContent() {
        return asContent;
    }

    /**
     * Gets the value of the asDistributedProduct property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the asDistributedProduct property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAsDistributedProduct().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVDistributedProduct }
     *
     *
     */
    public List<COCTMT230100UVDistributedProduct> getAsDistributedProduct() {
        if (asDistributedProduct == null) {
            asDistributedProduct = new ArrayList<COCTMT230100UVDistributedProduct>();
        }
        return this.asDistributedProduct;
    }

    /**
     * Gets the value of the asMedicineManufacturer property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the asMedicineManufacturer property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAsMedicineManufacturer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVMedicineManufacturer }
     *
     *
     */
    public List<COCTMT230100UVMedicineManufacturer> getAsMedicineManufacturer() {
        if (asMedicineManufacturer == null) {
            asMedicineManufacturer = new ArrayList<COCTMT230100UVMedicineManufacturer>();
        }
        return this.asMedicineManufacturer;
    }

    /**
     * Gets the value of the asSpecializedKind property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the asSpecializedKind property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAsSpecializedKind().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVSpecializedKind }
     *
     *
     */
    public List<COCTMT230100UVSpecializedKind> getAsSpecializedKind() {
        if (asSpecializedKind == null) {
            asSpecializedKind = new ArrayList<COCTMT230100UVSpecializedKind>();
        }
        return this.asSpecializedKind;
    }

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClassCode() {
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
     * Ruft den Wert der desc-Eigenschaft ab.
     *
     * @return possible object is {@link ED }
     *
     */
    public ED getDesc() {
        return desc;
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
     * Ruft den Wert der expirationTime-Eigenschaft ab.
     *
     * @return possible object is {@link IVLTS }
     *
     */
    public IVLTS getExpirationTime() {
        return expirationTime;
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
     * Ruft den Wert der handlingCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     *
     */
    public CE getHandlingCode() {
        return handlingCode;
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
     * Gets the value of the ingredient property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the ingredient property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getIngredient().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVIngredient }
     *
     *
     */
    public List<COCTMT230100UVIngredient> getIngredient() {
        if (ingredient == null) {
            ingredient = new ArrayList<COCTMT230100UVIngredient>();
        }
        return this.ingredient;
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
     * Gets the value of the part property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the part property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getPart().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT230100UVPart }
     *
     *
     */
    public List<COCTMT230100UVPart> getPart() {
        if (part == null) {
            part = new ArrayList<COCTMT230100UVPart>();
        }
        return this.part;
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
     * Ruft den Wert der riskCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     *
     */
    public CE getRiskCode() {
        return riskCode;
    }

    /**
     * Ruft den Wert der stabilityTime-Eigenschaft ab.
     *
     * @return possible object is {@link IVLTS }
     *
     */
    public IVLTS getStabilityTime() {
        return stabilityTime;
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
     * Legt den Wert der asContent-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link JAXBElement
     *            }{@code <}{@link COCTMT230100UVContent }{@code >}
     *
     */
    public void setAsContent(JAXBElement<COCTMT230100UVContent> value) {
        this.asContent = value;
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setClassCode(String value) {
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
     * Legt den Wert der desc-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link ED }
     *
     */
    public void setDesc(ED value) {
        this.desc = value;
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
     * Legt den Wert der expirationTime-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link IVLTS }
     *
     */
    public void setExpirationTime(IVLTS value) {
        this.expirationTime = value;
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
     * Legt den Wert der handlingCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CE }
     *
     */
    public void setHandlingCode(CE value) {
        this.handlingCode = value;
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
     * Legt den Wert der riskCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CE }
     *
     */
    public void setRiskCode(CE value) {
        this.riskCode = value;
    }

    /**
     * Legt den Wert der stabilityTime-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link IVLTS }
     *
     */
    public void setStabilityTime(IVLTS value) {
        this.stabilityTime = value;
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
