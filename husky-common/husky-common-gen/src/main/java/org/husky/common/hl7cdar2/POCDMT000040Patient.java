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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für POCD_MT000040.Patient complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.Patient"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/&gt;
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{urn:hl7-org:v3}PN" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="administrativeGenderCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="birthTime" type="{urn:hl7-org:v3}TS" minOccurs="0"/&gt;
 *         &lt;element name="maritalStatusCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="religiousAffiliationCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="raceCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="ethnicGroupCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="guardian" type="{urn:hl7-org:v3}POCD_MT000040.Guardian" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="birthplace" type="{urn:hl7-org:v3}POCD_MT000040.Birthplace" minOccurs="0"/&gt;
 *         &lt;element name="languageCommunication" type="{urn:hl7-org:v3}POCD_MT000040.LanguageCommunication" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" /&gt;
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}EntityClass" fixed="PSN" /&gt;
 *       &lt;attribute name="determinerCode" type="{urn:hl7-org:v3}EntityDeterminer" fixed="INSTANCE" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Patient", propOrder = {"realmCode", "typeId", "templateId", "id",
        "name", "administrativeGenderCode", "birthTime", "maritalStatusCode",
        "religiousAffiliationCode", "raceCode", "ethnicGroupCode", "guardian", "birthplace",
        "languageCommunication"})
public class POCDMT000040Patient {

    protected List<CS> realmCode;
    protected POCDMT000040InfrastructureRootTypeId typeId;
    protected List<II> templateId;
    protected II id;
    protected List<PN> name;
    protected CE administrativeGenderCode;
    protected TS birthTime;
    protected CE maritalStatusCode;
    protected CE religiousAffiliationCode;
    protected CE raceCode;
    protected CE ethnicGroupCode;
    protected List<POCDMT000040Guardian> guardian;
    protected POCDMT000040Birthplace birthplace;
    protected List<POCDMT000040LanguageCommunication> languageCommunication;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "classCode")
    protected List<String> classCode;
    @XmlAttribute(name = "determinerCode")
    protected String determinerCode;

    /**
     * Ruft den Wert der administrativeGenderCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getAdministrativeGenderCode() {
        return administrativeGenderCode;
    }

    /**
     * Ruft den Wert der birthplace-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040Birthplace }
     */
    public POCDMT000040Birthplace getBirthplace() {
        return birthplace;
    }

    /**
     * Ruft den Wert der birthTime-Eigenschaft ab.
     *
     * @return possible object is {@link TS }
     */
    public TS getBirthTime() {
        return birthTime;
    }

    /**
     * Gets the value of the classCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the classCode property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getClassCode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    @NonNull
    public List<String> getClassCode() {
        if (classCode == null) {
            classCode = new ArrayList<>();
        }
        return this.classCode;
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
     * Ruft den Wert der ethnicGroupCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getEthnicGroupCode() {
        return ethnicGroupCode;
    }

    /**
     * Gets the value of the guardian property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the guardian property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getGuardian().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040Guardian }
     */
    @NonNull
    public List<POCDMT000040Guardian> getGuardian() {
        if (guardian == null) {
            guardian = new ArrayList<>();
        }
        return this.guardian;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     *
     * @return possible object is {@link II }
     */
    public II getId() {
        return id;
    }

    /**
     * Gets the value of the languageCommunication property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the languageCommunication property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getLanguageCommunication().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040LanguageCommunication }
     */
    @NonNull
    public List<POCDMT000040LanguageCommunication> getLanguageCommunication() {
        if (languageCommunication == null) {
            languageCommunication = new ArrayList<>();
        }
        return this.languageCommunication;
    }

    /**
     * Ruft den Wert der maritalStatusCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getMaritalStatusCode() {
        return maritalStatusCode;
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
     * Objects of the following type(s) are allowed in the list {@link PN }
     */
    @NonNull
    public List<PN> getName() {
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
     * Ruft den Wert der raceCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getRaceCode() {
        return raceCode;
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
     * Ruft den Wert der religiousAffiliationCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getReligiousAffiliationCode() {
        return religiousAffiliationCode;
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
     * Legt den Wert der administrativeGenderCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setAdministrativeGenderCode(CE value) {
        this.administrativeGenderCode = value;
    }

    /**
     * Legt den Wert der birthplace-Eigenschaft fest.
     *
     * @param value allowed object is {@link POCDMT000040Birthplace }
     */
    public void setBirthplace(POCDMT000040Birthplace value) {
        this.birthplace = value;
    }

    /**
     * Legt den Wert der birthTime-Eigenschaft fest.
     *
     * @param value allowed object is {@link TS }
     */
    public void setBirthTime(TS value) {
        this.birthTime = value;
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
     * Legt den Wert der ethnicGroupCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setEthnicGroupCode(CE value) {
        this.ethnicGroupCode = value;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     *
     * @param value allowed object is {@link II }
     */
    public void setId(II value) {
        this.id = value;
    }

    /**
     * Legt den Wert der maritalStatusCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setMaritalStatusCode(CE value) {
        this.maritalStatusCode = value;
    }

    /**
     * Legt den Wert der raceCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setRaceCode(CE value) {
        this.raceCode = value;
    }

    /**
     * Legt den Wert der religiousAffiliationCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setReligiousAffiliationCode(CE value) {
        this.religiousAffiliationCode = value;
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
