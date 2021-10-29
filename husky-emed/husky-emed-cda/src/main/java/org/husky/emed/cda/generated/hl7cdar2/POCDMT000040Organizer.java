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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für POCD_MT000040.Organizer complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.Organizer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/>
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CD" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{urn:hl7-org:v3}CS"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *         &lt;element name="subject" type="{urn:hl7-org:v3}POCD_MT000040.Subject" minOccurs="0"/>
 *         &lt;element name="specimen" type="{urn:hl7-org:v3}POCD_MT000040.Specimen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="performer" type="{urn:hl7-org:v3}POCD_MT000040.Performer2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="author" type="{urn:hl7-org:v3}POCD_MT000040.Author" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="informant" type="{urn:hl7-org:v3}POCD_MT000040.Informant12" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="participant" type="{urn:hl7-org:v3}POCD_MT000040.Participant2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reference" type="{urn:hl7-org:v3}POCD_MT000040.Reference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="precondition" type="{urn:hl7-org:v3}POCD_MT000040.Precondition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="component" type="{urn:hl7-org:v3}POCD_MT000040.Component4" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}x_ActClassDocumentEntryOrganizer" />
 *       &lt;attribute name="moodCode" use="required" type="{urn:hl7-org:v3}ActMood" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Organizer", propOrder = { "realmCode", "typeId", "templateId", "id",
        "code", "statusCode", "effectiveTime", "subject", "specimen", "performer", "author",
        "informant", "participant", "reference", "precondition", "component" })
public class POCDMT000040Organizer {

    protected List<CS> realmCode;
    protected POCDMT000040InfrastructureRootTypeId typeId;
    protected List<II> templateId;
    protected List<II> id;
    protected CD code;
    @XmlElement(required = true)
    protected CS statusCode;
    protected IVLTS effectiveTime;
    protected POCDMT000040Subject subject;
    protected List<POCDMT000040Specimen> specimen;
    protected List<POCDMT000040Performer2> performer;
    protected List<POCDMT000040Author> author;
    protected List<POCDMT000040Informant12> informant;
    protected List<POCDMT000040Participant2> participant;
    protected List<POCDMT000040Reference> reference;
    protected List<POCDMT000040Precondition> precondition;
    protected List<POCDMT000040Component4> component;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "classCode", required = true)
    protected XActClassDocumentEntryOrganizer classCode;
    @XmlAttribute(name = "moodCode", required = true)
    protected List<String> moodCode;

    /**
     * Gets the value of the author property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the author property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAuthor().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Author }
     *
     *
     */
    public List<POCDMT000040Author> getAuthor() {
        if (author == null) {
            author = new ArrayList<POCDMT000040Author>();
        }
        return this.author;
    }

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link XActClassDocumentEntryOrganizer }
     *
     */
    public XActClassDocumentEntryOrganizer getClassCode() {
        return classCode;
    }

    /**
     * Ruft den Wert der code-Eigenschaft ab.
     *
     * @return possible object is {@link CD }
     *
     */
    public CD getCode() {
        return code;
    }

    /**
     * Gets the value of the component property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the component property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getComponent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Component4 }
     *
     *
     */
    public List<POCDMT000040Component4> getComponent() {
        if (component == null) {
            component = new ArrayList<POCDMT000040Component4>();
        }
        return this.component;
    }

    /**
     * Ruft den Wert der effectiveTime-Eigenschaft ab.
     *
     * @return possible object is {@link IVLTS }
     *
     */
    public IVLTS getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the value of the id property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
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
     *
     *
     */
    public List<II> getId() {
        if (id == null) {
            id = new ArrayList<II>();
        }
        return this.id;
    }

    /**
     * Gets the value of the informant property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the informant property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getInformant().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Informant12 }
     *
     *
     */
    public List<POCDMT000040Informant12> getInformant() {
        if (informant == null) {
            informant = new ArrayList<POCDMT000040Informant12>();
        }
        return this.informant;
    }

    /**
     * Gets the value of the moodCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the moodCode property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getMoodCode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     *
     *
     */
    public List<String> getMoodCode() {
        if (moodCode == null) {
            moodCode = new ArrayList<String>();
        }
        return this.moodCode;
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
     * Gets the value of the participant property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the participant property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getParticipant().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Participant2 }
     *
     *
     */
    public List<POCDMT000040Participant2> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<POCDMT000040Participant2>();
        }
        return this.participant;
    }

    /**
     * Gets the value of the performer property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the performer property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getPerformer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Performer2 }
     *
     *
     */
    public List<POCDMT000040Performer2> getPerformer() {
        if (performer == null) {
            performer = new ArrayList<POCDMT000040Performer2>();
        }
        return this.performer;
    }

    /**
     * Gets the value of the precondition property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the precondition property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getPrecondition().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Precondition }
     *
     *
     */
    public List<POCDMT000040Precondition> getPrecondition() {
        if (precondition == null) {
            precondition = new ArrayList<POCDMT000040Precondition>();
        }
        return this.precondition;
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
     * Gets the value of the reference property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the reference property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getReference().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Reference }
     *
     *
     */
    public List<POCDMT000040Reference> getReference() {
        if (reference == null) {
            reference = new ArrayList<POCDMT000040Reference>();
        }
        return this.reference;
    }

    /**
     * Gets the value of the specimen property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the specimen property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSpecimen().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Specimen }
     *
     *
     */
    public List<POCDMT000040Specimen> getSpecimen() {
        if (specimen == null) {
            specimen = new ArrayList<POCDMT000040Specimen>();
        }
        return this.specimen;
    }

    /**
     * Ruft den Wert der statusCode-Eigenschaft ab.
     *
     * @return possible object is {@link CS }
     *
     */
    public CS getStatusCode() {
        return statusCode;
    }

    /**
     * Ruft den Wert der subject-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040Subject }
     *
     */
    public POCDMT000040Subject getSubject() {
        return subject;
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
     * Objects of the following type(s) are allowed in the list {@link II }
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
     * Ruft den Wert der typeId-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040InfrastructureRootTypeId }
     *
     */
    public POCDMT000040InfrastructureRootTypeId getTypeId() {
        return typeId;
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link XActClassDocumentEntryOrganizer }
     *
     */
    public void setClassCode(XActClassDocumentEntryOrganizer value) {
        this.classCode = value;
    }

    /**
     * Legt den Wert der code-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CD }
     *
     */
    public void setCode(CD value) {
        this.code = value;
    }

    /**
     * Legt den Wert der effectiveTime-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link IVLTS }
     *
     */
    public void setEffectiveTime(IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Legt den Wert der statusCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CS }
     *
     */
    public void setStatusCode(CS value) {
        this.statusCode = value;
    }

    /**
     * Legt den Wert der subject-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link POCDMT000040Subject }
     *
     */
    public void setSubject(POCDMT000040Subject value) {
        this.subject = value;
    }

    /**
     * Legt den Wert der typeId-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link POCDMT000040InfrastructureRootTypeId
     *            }
     *
     */
    public void setTypeId(POCDMT000040InfrastructureRootTypeId value) {
        this.typeId = value;
    }

}
