//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.08 um 04:56:31 PM CEST 
//


package org.ehealth_connector.cda.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für POCD_MT000040.Material complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="POCD_MT000040.Material">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/>
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="name" type="{urn:hl7-org:v3}EN" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}desc" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}riskCode" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}handlingCode" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}formCode" minOccurs="0"/>
 *         &lt;element name="lotNumberText" type="{urn:hl7-org:v3}ST" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}expirationTime" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}stabilityTime" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}asDistributedProduct" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}asMedicineManufacturer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}asContent" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}asSpecializedKind" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}part" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:ihe:pharm}ingredient" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}EntityClassManufacturedMaterial" fixed="MMAT" />
 *       &lt;attribute name="determinerCode" type="{urn:hl7-org:v3}EntityDeterminerDetermined" fixed="KIND" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Material", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "code",
    "name",
    "desc",
    "riskCode",
    "handlingCode",
    "formCode",
    "lotNumberText",
    "expirationTime",
    "stabilityTime",
    "asDistributedProduct",
    "asMedicineManufacturer",
    "asContent",
    "asSpecializedKind",
    "part",
    "ingredient"
})
public class POCDMT000040Material {

    protected List<CS> realmCode;
    protected POCDMT000040InfrastructureRootTypeId typeId;
    protected List<II> templateId;
    protected CE code;
    protected EN name;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected ED desc;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected CE riskCode;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected CE handlingCode;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected CE formCode;
    protected ST lotNumberText;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected IVLTS expirationTime;
    @XmlElement(namespace = "urn:ihe:pharm")
    protected IVLTS stabilityTime;
    @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    protected List<COCTMT230100UVDistributedProduct> asDistributedProduct;
    @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    protected List<COCTMT230100UVMedicineManufacturer> asMedicineManufacturer;
    @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    protected COCTMT230100UVContent asContent;
    @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    protected List<COCTMT230100UVSpecializedKind> asSpecializedKind;
    @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    protected List<COCTMT230100UVPart> part;
    @XmlElement(namespace = "urn:ihe:pharm", nillable = true)
    protected List<COCTMT230100UVIngredient> ingredient;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "classCode")
    protected String classCode;
    @XmlAttribute(name = "determinerCode")
    protected EntityDeterminerDetermined determinerCode;

    /**
     * Gets the value of the realmCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realmCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealmCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CS }
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
     * Ruft den Wert der typeId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT000040InfrastructureRootTypeId }
     *     
     */
    public POCDMT000040InfrastructureRootTypeId getTypeId() {
        return typeId;
    }

    /**
     * Legt den Wert der typeId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT000040InfrastructureRootTypeId }
     *     
     */
    public void setTypeId(POCDMT000040InfrastructureRootTypeId value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the templateId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templateId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplateId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link II }
     * 
     * 
     */
    public List<II> getTemplateId() {
        if (templateId == null) {
            templateId = new ArrayList<II>();
        }
        return this.templateId;
    }

    /**
     * Ruft den Wert der code-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CE }
     *     
     */
    public CE getCode() {
        return code;
    }

    /**
     * Legt den Wert der code-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CE }
     *     
     */
    public void setCode(CE value) {
        this.code = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EN }
     *     
     */
    public EN getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EN }
     *     
     */
    public void setName(EN value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der desc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ED }
     *     
     */
    public ED getDesc() {
        return desc;
    }

    /**
     * Legt den Wert der desc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ED }
     *     
     */
    public void setDesc(ED value) {
        this.desc = value;
    }

    /**
     * Ruft den Wert der riskCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CE }
     *     
     */
    public CE getRiskCode() {
        return riskCode;
    }

    /**
     * Legt den Wert der riskCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CE }
     *     
     */
    public void setRiskCode(CE value) {
        this.riskCode = value;
    }

    /**
     * Ruft den Wert der handlingCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CE }
     *     
     */
    public CE getHandlingCode() {
        return handlingCode;
    }

    /**
     * Legt den Wert der handlingCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CE }
     *     
     */
    public void setHandlingCode(CE value) {
        this.handlingCode = value;
    }

    /**
     * Ruft den Wert der formCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CE }
     *     
     */
    public CE getFormCode() {
        return formCode;
    }

    /**
     * Legt den Wert der formCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CE }
     *     
     */
    public void setFormCode(CE value) {
        this.formCode = value;
    }

    /**
     * Ruft den Wert der lotNumberText-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ST }
     *     
     */
    public ST getLotNumberText() {
        return lotNumberText;
    }

    /**
     * Legt den Wert der lotNumberText-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ST }
     *     
     */
    public void setLotNumberText(ST value) {
        this.lotNumberText = value;
    }

    /**
     * Ruft den Wert der expirationTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IVLTS }
     *     
     */
    public IVLTS getExpirationTime() {
        return expirationTime;
    }

    /**
     * Legt den Wert der expirationTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IVLTS }
     *     
     */
    public void setExpirationTime(IVLTS value) {
        this.expirationTime = value;
    }

    /**
     * Ruft den Wert der stabilityTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IVLTS }
     *     
     */
    public IVLTS getStabilityTime() {
        return stabilityTime;
    }

    /**
     * Legt den Wert der stabilityTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IVLTS }
     *     
     */
    public void setStabilityTime(IVLTS value) {
        this.stabilityTime = value;
    }

    /**
     * Gets the value of the asDistributedProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asDistributedProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
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
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asMedicineManufacturer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
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
     * Ruft den Wert der asContent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link COCTMT230100UVContent }
     *     
     */
    public COCTMT230100UVContent getAsContent() {
        return asContent;
    }

    /**
     * Legt den Wert der asContent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link COCTMT230100UVContent }
     *     
     */
    public void setAsContent(COCTMT230100UVContent value) {
        this.asContent = value;
    }

    /**
     * Gets the value of the asSpecializedKind property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asSpecializedKind property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
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
     * Gets the value of the part property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the part property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
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
     * Gets the value of the ingredient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ingredient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
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
     * Gets the value of the nullFlavor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nullFlavor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNullFlavor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
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
     * Ruft den Wert der classCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassCode() {
        if (classCode == null) {
            return "MMAT";
        } else {
            return classCode;
        }
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassCode(String value) {
        this.classCode = value;
    }

    /**
     * Ruft den Wert der determinerCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityDeterminerDetermined }
     *     
     */
    public EntityDeterminerDetermined getDeterminerCode() {
        if (determinerCode == null) {
            return EntityDeterminerDetermined.KIND;
        } else {
            return determinerCode;
        }
    }

    /**
     * Legt den Wert der determinerCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityDeterminerDetermined }
     *     
     */
    public void setDeterminerCode(EntityDeterminerDetermined value) {
        this.determinerCode = value;
    }

}
