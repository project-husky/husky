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

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für COCT_MT230100UV.Substance complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.Substance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/&gt;
 *         &lt;element name="code" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{urn:hl7-org:v3}TN" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="desc" type="{urn:hl7-org:v3}ED" minOccurs="0"/&gt;
 *         &lt;element name="lotNumberText" type="{urn:hl7-org:v3}ST" minOccurs="0"/&gt;
 *         &lt;element name="asSubstanceManufacturer" type="{urn:ihe:pharm}COCT_MT230100UV.SubstanceManufacturer" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="subIngredient" type="{urn:ihe:pharm}COCT_MT230100UV.SubIngredient" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" /&gt;
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}EntityClassManufacturedMaterial" /&gt;
 *       &lt;attribute name="determinerCode" use="required" type="{urn:hl7-org:v3}EntityDeterminer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.Substance", namespace = "urn:ihe:pharm", propOrder = {"realmCode",
        "typeId", "templateId", "code", "name", "desc", "lotNumberText", "asSubstanceManufacturer",
        "subIngredient"})
public class COCTMT230100UVSubstance {

    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<CS> realmCode;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected AllInfrastructureRootTypeId typeId;
    @XmlElement(namespace = "urn:hl7-org:v3")
    protected List<AllInfrastructureRootTemplateId> templateId;
    protected CE code;
    protected List<TN> name;
    protected ED desc;
    protected ST lotNumberText;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubstanceManufacturer> asSubstanceManufacturer;
    @XmlElement(nillable = true)
    protected List<COCTMT230100UVSubIngredient> subIngredient;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "classCode", required = true)
    protected String classCode;
    @XmlAttribute(name = "determinerCode", required = true)
    protected String determinerCode;

    /**
     * Gets the value of the asSubstanceManufacturer property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the asSubstanceManufacturer property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAsSubstanceManufacturer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubstanceManufacturer }
     */
    @NonNull
    public List<COCTMT230100UVSubstanceManufacturer> getAsSubstanceManufacturer() {
        if (asSubstanceManufacturer == null) {
            asSubstanceManufacturer = new ArrayList<>();
        }
        return this.asSubstanceManufacturer;
    }

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * Ruft den Wert der code-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getCode() {
        return code;
    }

    /**
     * Ruft den Wert der desc-Eigenschaft ab.
     *
     * @return possible object is {@link ED }
     */
    public ED getDesc() {
        return desc;
    }

    /**
     * Ruft den Wert der determinerCode-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getDeterminerCode() {
        return determinerCode;
    }

    /**
     * Ruft den Wert der lotNumberText-Eigenschaft ab.
     *
     * @return possible object is {@link ST }
     */
    public ST getLotNumberText() {
        return lotNumberText;
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
     * Objects of the following type(s) are allowed in the list {@link TN }
     */
    @NonNull
    public List<TN> getName() {
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
     * Gets the value of the subIngredient property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the subIngredient property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSubIngredient().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link COCTMT230100UVSubIngredient }
     */
    @NonNull
    public List<COCTMT230100UVSubIngredient> getSubIngredient() {
        if (subIngredient == null) {
            subIngredient = new ArrayList<>();
        }
        return this.subIngredient;
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
     * @param value allowed object is {@link String }
     */
    public void setClassCode(String value) {
        this.classCode = value;
    }

    /**
     * Legt den Wert der code-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setCode(CE value) {
        this.code = value;
    }

    /**
     * Legt den Wert der desc-Eigenschaft fest.
     *
     * @param value allowed object is {@link ED }
     */
    public void setDesc(ED value) {
        this.desc = value;
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
     * Legt den Wert der lotNumberText-Eigenschaft fest.
     *
     * @param value allowed object is {@link ST }
     */
    public void setLotNumberText(ST value) {
        this.lotNumberText = value;
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
