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
 * Java-Klasse für POCD_MT000040.Encounter complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.Encounter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/&gt;
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="code" type="{urn:hl7-org:v3}CD" minOccurs="0"/&gt;
 *         &lt;element name="text" type="{urn:hl7-org:v3}ED" minOccurs="0"/&gt;
 *         &lt;element name="statusCode" type="{urn:hl7-org:v3}CS" minOccurs="0"/&gt;
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/&gt;
 *         &lt;element name="priorityCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="subject" type="{urn:hl7-org:v3}POCD_MT000040.Subject" minOccurs="0"/&gt;
 *         &lt;element name="specimen" type="{urn:hl7-org:v3}POCD_MT000040.Specimen" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="performer" type="{urn:hl7-org:v3}POCD_MT000040.Performer2" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="author" type="{urn:hl7-org:v3}POCD_MT000040.Author" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="informant" type="{urn:hl7-org:v3}POCD_MT000040.Informant12" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="participant" type="{urn:hl7-org:v3}POCD_MT000040.Participant2" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="entryRelationship" type="{urn:hl7-org:v3}POCD_MT000040.EntryRelationship" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="reference" type="{urn:hl7-org:v3}POCD_MT000040.Reference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="precondition" type="{urn:hl7-org:v3}POCD_MT000040.Precondition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" /&gt;
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}ActClass" /&gt;
 *       &lt;attribute name="moodCode" use="required" type="{urn:hl7-org:v3}x_DocumentEncounterMood" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Encounter", propOrder = {"realmCode", "typeId", "templateId", "id",
        "code", "text", "statusCode", "effectiveTime", "priorityCode", "subject", "specimen",
        "performer", "author", "informant", "participant", "entryRelationship", "reference",
        "precondition"})
public class POCDMT000040Encounter {

    protected List<CS> realmCode;
    protected POCDMT000040InfrastructureRootTypeId typeId;
    protected List<II> templateId;
    protected List<II> id;
    protected CD code;
    protected ED text;
    protected CS statusCode;
    protected IVLTS effectiveTime;
    protected CE priorityCode;
    protected POCDMT000040Subject subject;
    protected List<POCDMT000040Specimen> specimen;
    protected List<POCDMT000040Performer2> performer;
    protected List<POCDMT000040Author> author;
    protected List<POCDMT000040Informant12> informant;
    protected List<POCDMT000040Participant2> participant;
    protected List<POCDMT000040EntryRelationship> entryRelationship;
    protected List<POCDMT000040Reference> reference;
    protected List<POCDMT000040Precondition> precondition;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "classCode", required = true)
    protected List<String> classCode;
    @XmlAttribute(name = "moodCode", required = true)
    protected XDocumentEncounterMood moodCode;

    /**
     * Gets the value of the author property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the author property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAuthor().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040Author }
     */
    @NonNull
    public List<POCDMT000040Author> getAuthor() {
        if (author == null) {
            author = new ArrayList<>();
        }
        return this.author;
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
     * Ruft den Wert der code-Eigenschaft ab.
     *
     * @return possible object is {@link CD }
     */
    public CD getCode() {
        return code;
    }

    /**
     * Ruft den Wert der effectiveTime-Eigenschaft ab.
     *
     * @return possible object is {@link IVLTS }
     */
    public IVLTS getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the value of the entryRelationship property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the entryRelationship property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getEntryRelationship().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040EntryRelationship }
     */
    @NonNull
    public List<POCDMT000040EntryRelationship> getEntryRelationship() {
        if (entryRelationship == null) {
            entryRelationship = new ArrayList<>();
        }
        return this.entryRelationship;
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
     * Gets the value of the informant property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the informant property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getInformant().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040Informant12 }
     */
    @NonNull
    public List<POCDMT000040Informant12> getInformant() {
        if (informant == null) {
            informant = new ArrayList<>();
        }
        return this.informant;
    }

    /**
     * Ruft den Wert der moodCode-Eigenschaft ab.
     *
     * @return possible object is {@link XDocumentEncounterMood }
     */
    public XDocumentEncounterMood getMoodCode() {
        return moodCode;
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
     * Gets the value of the participant property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the participant property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getParticipant().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040Participant2 }
     */
    @NonNull
    public List<POCDMT000040Participant2> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<>();
        }
        return this.participant;
    }

    /**
     * Gets the value of the performer property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the performer property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getPerformer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040Performer2 }
     */
    @NonNull
    public List<POCDMT000040Performer2> getPerformer() {
        if (performer == null) {
            performer = new ArrayList<>();
        }
        return this.performer;
    }

    /**
     * Gets the value of the precondition property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the precondition property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getPrecondition().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040Precondition }
     */
    @NonNull
    public List<POCDMT000040Precondition> getPrecondition() {
        if (precondition == null) {
            precondition = new ArrayList<>();
        }
        return this.precondition;
    }

    /**
     * Ruft den Wert der priorityCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getPriorityCode() {
        return priorityCode;
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
     * Gets the value of the reference property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the reference property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getReference().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040Reference }
     */
    @NonNull
    public List<POCDMT000040Reference> getReference() {
        if (reference == null) {
            reference = new ArrayList<>();
        }
        return this.reference;
    }

    /**
     * Gets the value of the specimen property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the specimen property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getSpecimen().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link POCDMT000040Specimen }
     */
    @NonNull
    public List<POCDMT000040Specimen> getSpecimen() {
        if (specimen == null) {
            specimen = new ArrayList<>();
        }
        return this.specimen;
    }

    /**
     * Ruft den Wert der statusCode-Eigenschaft ab.
     *
     * @return possible object is {@link CS }
     */
    public CS getStatusCode() {
        return statusCode;
    }

    /**
     * Ruft den Wert der subject-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040Subject }
     */
    public POCDMT000040Subject getSubject() {
        return subject;
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
     * Ruft den Wert der text-Eigenschaft ab.
     *
     * @return possible object is {@link ED }
     */
    public ED getText() {
        return text;
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
     * Legt den Wert der code-Eigenschaft fest.
     *
     * @param value allowed object is {@link CD }
     */
    public void setCode(CD value) {
        this.code = value;
    }

    /**
     * Legt den Wert der effectiveTime-Eigenschaft fest.
     *
     * @param value allowed object is {@link IVLTS }
     */
    public void setEffectiveTime(IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Legt den Wert der moodCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link XDocumentEncounterMood }
     */
    public void setMoodCode(XDocumentEncounterMood value) {
        this.moodCode = value;
    }

    /**
     * Legt den Wert der priorityCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setPriorityCode(CE value) {
        this.priorityCode = value;
    }

    /**
     * Legt den Wert der statusCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CS }
     */
    public void setStatusCode(CS value) {
        this.statusCode = value;
    }

    /**
     * Legt den Wert der subject-Eigenschaft fest.
     *
     * @param value allowed object is {@link POCDMT000040Subject }
     */
    public void setSubject(POCDMT000040Subject value) {
        this.subject = value;
    }

    /**
     * Legt den Wert der text-Eigenschaft fest.
     *
     * @param value allowed object is {@link ED }
     */
    public void setText(ED value) {
        this.text = value;
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
