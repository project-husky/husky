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

package org.ehealth_connector.emed.cda.generated.hl7cdar2;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java-Klasse für POCD_MT000040.ClinicalDocument complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.ClinicalDocument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId"/>
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CE"/>
 *         &lt;element name="title" type="{urn:hl7-org:v3}ST" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}TS"/>
 *         &lt;element name="confidentialityCode" type="{urn:hl7-org:v3}CE"/>
 *         &lt;element name="languageCode" type="{urn:hl7-org:v3}CS" minOccurs="0"/>
 *         &lt;element name="setId" type="{urn:hl7-org:v3}II" minOccurs="0"/>
 *         &lt;element name="versionNumber" type="{urn:hl7-org:v3}INT" minOccurs="0"/>
 *         &lt;element name="copyTime" type="{urn:hl7-org:v3}TS" minOccurs="0"/>
 *         &lt;element name="recordTarget" type="{urn:hl7-org:v3}POCD_MT000040.RecordTarget" maxOccurs="unbounded"/>
 *         &lt;element name="author" type="{urn:hl7-org:v3}POCD_MT000040.Author" maxOccurs="unbounded"/>
 *         &lt;element name="dataEnterer" type="{urn:hl7-org:v3}POCD_MT000040.DataEnterer" minOccurs="0"/>
 *         &lt;element name="informant" type="{urn:hl7-org:v3}POCD_MT000040.Informant12" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="custodian" type="{urn:hl7-org:v3}POCD_MT000040.Custodian"/>
 *         &lt;element name="informationRecipient" type="{urn:hl7-org:v3}POCD_MT000040.InformationRecipient" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="legalAuthenticator" type="{urn:hl7-org:v3}POCD_MT000040.LegalAuthenticator" minOccurs="0"/>
 *         &lt;element name="authenticator" type="{urn:hl7-org:v3}POCD_MT000040.Authenticator" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="participant" type="{urn:hl7-org:v3}POCD_MT000040.Participant1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inFulfillmentOf" type="{urn:hl7-org:v3}POCD_MT000040.InFulfillmentOf" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="documentationOf" type="{urn:hl7-org:v3}POCD_MT000040.DocumentationOf" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="relatedDocument" type="{urn:hl7-org:v3}POCD_MT000040.RelatedDocument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="authorization" type="{urn:hl7-org:v3}POCD_MT000040.Authorization" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="componentOf" type="{urn:hl7-org:v3}POCD_MT000040.Component1" minOccurs="0"/>
 *         &lt;element name="component" type="{urn:hl7-org:v3}POCD_MT000040.Component2"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}ActClinicalDocument" fixed="DOCCLIN" />
 *       &lt;attribute name="moodCode" type="{urn:hl7-org:v3}ActMood" fixed="EVN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.ClinicalDocument", propOrder = { "realmCode", "typeId", "templateId",
        "id", "code", "title", "effectiveTime", "confidentialityCode", "languageCode", "setId",
        "versionNumber", "copyTime", "recordTarget", "author", "dataEnterer", "informant",
        "custodian", "informationRecipient", "legalAuthenticator", "authenticator", "participant",
        "inFulfillmentOf", "documentationOf", "relatedDocument", "authorization", "componentOf",
        "component" })
// Fix Tony Schaller, medshare GmbH: adding root element for serialization
@XmlRootElement(name = "ClinicalDocument", namespace = "urn:hl7-org:v3")
public class POCDMT000040ClinicalDocument {

    protected List<POCDMT000040Authenticator> authenticator;
    @XmlElement(required = true)
    protected List<POCDMT000040Author> author;
    protected List<POCDMT000040Authorization> authorization;
    @XmlAttribute(name = "classCode")
    protected ActClinicalDocument classCode;
    @XmlElement(required = true)
    protected CE code;
    @XmlElement(required = true)
    protected POCDMT000040Component2 component;
    protected POCDMT000040Component1 componentOf;
    @XmlElement(required = true)
    protected CE confidentialityCode;
    protected TS copyTime;
    @XmlElement(required = true)
    protected POCDMT000040Custodian custodian;
    protected POCDMT000040DataEnterer dataEnterer;
    protected List<POCDMT000040DocumentationOf> documentationOf;
    @XmlElement(required = true)
    protected TS effectiveTime;
    @XmlElement(required = true)
    protected II id;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String idAttr;
    protected List<POCDMT000040Informant12> informant;
    protected List<POCDMT000040InformationRecipient> informationRecipient;
    protected List<POCDMT000040InFulfillmentOf> inFulfillmentOf;
    protected CS languageCode;
    protected POCDMT000040LegalAuthenticator legalAuthenticator;
    @XmlAttribute(name = "moodCode")
    protected List<String> moodCode;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    protected List<POCDMT000040Participant1> participant;
    protected List<CS> realmCode;
    @XmlElement(required = true)
    protected List<POCDMT000040RecordTarget> recordTarget;
    protected List<POCDMT000040RelatedDocument> relatedDocument;
    protected II setId;
    protected List<II> templateId;
    protected ST title;
    @XmlElement(required = true)
    protected POCDMT000040InfrastructureRootTypeId typeId;
    protected INT versionNumber;

    /**
     * Gets the value of the authenticator property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the authenticator property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAuthenticator().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Authenticator }
     *
     *
     */
    @NonNull
    public List<POCDMT000040Authenticator> getAuthenticator() {
        if (authenticator == null) {
            authenticator = new ArrayList<POCDMT000040Authenticator>();
        }
        return this.authenticator;
    }

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
    @NonNull
    public List<POCDMT000040Author> getAuthor() {
        if (author == null) {
            author = new ArrayList<POCDMT000040Author>();
        }
        return this.author;
    }

    /**
     * Gets the value of the authorization property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the authorization property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getAuthorization().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040Authorization }
     *
     *
     */
    @NonNull
    public List<POCDMT000040Authorization> getAuthorization() {
        if (authorization == null) {
            authorization = new ArrayList<POCDMT000040Authorization>();
        }
        return this.authorization;
    }

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     *
     * @return possible object is {@link ActClinicalDocument }
     *
     */
    @NonNull
    public ActClinicalDocument getClassCode() {
        if (classCode == null) {
            return ActClinicalDocument.DOCCLIN;
        } else {
            return classCode;
        }
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
     * Ruft den Wert der component-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040Component2 }
     *
     */
    public POCDMT000040Component2 getComponent() {
        return component;
    }

    /**
     * Ruft den Wert der componentOf-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040Component1 }
     *
     */
    public POCDMT000040Component1 getComponentOf() {
        return componentOf;
    }

    /**
     * Ruft den Wert der confidentialityCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     *
     */
    public CE getConfidentialityCode() {
        return confidentialityCode;
    }

    /**
     * Ruft den Wert der copyTime-Eigenschaft ab.
     *
     * @return possible object is {@link TS }
     *
     */
    public TS getCopyTime() {
        return copyTime;
    }

    /**
     * Ruft den Wert der custodian-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040Custodian }
     *
     */
    public POCDMT000040Custodian getCustodian() {
        return custodian;
    }

    /**
     * Ruft den Wert der dataEnterer-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040DataEnterer }
     *
     */
    public POCDMT000040DataEnterer getDataEnterer() {
        return dataEnterer;
    }

    /**
     * Gets the value of the documentationOf property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the documentationOf property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getDocumentationOf().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040DocumentationOf }
     *
     *
     */
    @NonNull
    public List<POCDMT000040DocumentationOf> getDocumentationOf() {
        if (documentationOf == null) {
            documentationOf = new ArrayList<POCDMT000040DocumentationOf>();
        }
        return this.documentationOf;
    }

    /**
     * Ruft den Wert der effectiveTime-Eigenschaft ab.
     *
     * @return possible object is {@link TS }
     *
     */
    public TS getEffectiveTime() {
        return effectiveTime;
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
     * Ruft den Wert der idAttr-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getIDAttr() {
        return idAttr;
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
    @NonNull
    public List<POCDMT000040Informant12> getInformant() {
        if (informant == null) {
            informant = new ArrayList<POCDMT000040Informant12>();
        }
        return this.informant;
    }

    /**
     * Gets the value of the informationRecipient property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the informationRecipient property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getInformationRecipient().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040InformationRecipient }
     *
     *
     */
    @NonNull
    public List<POCDMT000040InformationRecipient> getInformationRecipient() {
        if (informationRecipient == null) {
            informationRecipient = new ArrayList<POCDMT000040InformationRecipient>();
        }
        return this.informationRecipient;
    }

    /**
     * Gets the value of the inFulfillmentOf property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the inFulfillmentOf property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getInFulfillmentOf().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040InFulfillmentOf }
     *
     *
     */
    @NonNull
    public List<POCDMT000040InFulfillmentOf> getInFulfillmentOf() {
        if (inFulfillmentOf == null) {
            inFulfillmentOf = new ArrayList<POCDMT000040InFulfillmentOf>();
        }
        return this.inFulfillmentOf;
    }

    /**
     * Ruft den Wert der languageCode-Eigenschaft ab.
     *
     * @return possible object is {@link CS }
     *
     */
    public CS getLanguageCode() {
        return languageCode;
    }

    /**
     * Ruft den Wert der legalAuthenticator-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040LegalAuthenticator }
     *
     */
    public POCDMT000040LegalAuthenticator getLegalAuthenticator() {
        return legalAuthenticator;
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
    @NonNull
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
    @NonNull
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
     * {@link POCDMT000040Participant1 }
     *
     *
     */
    @NonNull
    public List<POCDMT000040Participant1> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<POCDMT000040Participant1>();
        }
        return this.participant;
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
    @NonNull
    public List<CS> getRealmCode() {
        if (realmCode == null) {
            realmCode = new ArrayList<CS>();
        }
        return this.realmCode;
    }

    /**
     * Gets the value of the recordTarget property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the recordTarget property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getRecordTarget().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040RecordTarget }
     *
     *
     */
    @NonNull
    public List<POCDMT000040RecordTarget> getRecordTarget() {
        if (recordTarget == null) {
            recordTarget = new ArrayList<POCDMT000040RecordTarget>();
        }
        return this.recordTarget;
    }

    /**
     * Gets the value of the relatedDocument property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the relatedDocument property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getRelatedDocument().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000040RelatedDocument }
     *
     *
     */
    @NonNull
    public List<POCDMT000040RelatedDocument> getRelatedDocument() {
        if (relatedDocument == null) {
            relatedDocument = new ArrayList<POCDMT000040RelatedDocument>();
        }
        return this.relatedDocument;
    }

    /**
     * Ruft den Wert der setId-Eigenschaft ab.
     *
     * @return possible object is {@link II }
     *
     */
    public II getSetId() {
        return setId;
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
    @NonNull
    public List<II> getTemplateId() {
        if (templateId == null) {
            templateId = new ArrayList<II>();
        }
        return this.templateId;
    }

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     *
     * @return possible object is {@link ST }
     *
     */
    public ST getTitle() {
        return title;
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
     * Ruft den Wert der versionNumber-Eigenschaft ab.
     *
     * @return possible object is {@link INT }
     *
     */
    public INT getVersionNumber() {
        return versionNumber;
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link ActClinicalDocument }
     *
     */
    public void setClassCode(ActClinicalDocument value) {
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
     * Legt den Wert der component-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link POCDMT000040Component2 }
     *
     */
    public void setComponent(POCDMT000040Component2 value) {
        this.component = value;
    }

    /**
     * Legt den Wert der componentOf-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link POCDMT000040Component1 }
     *
     */
    public void setComponentOf(POCDMT000040Component1 value) {
        this.componentOf = value;
    }

    /**
     * Legt den Wert der confidentialityCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CE }
     *
     */
    public void setConfidentialityCode(CE value) {
        this.confidentialityCode = value;
    }

    /**
     * Legt den Wert der copyTime-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link TS }
     *
     */
    public void setCopyTime(TS value) {
        this.copyTime = value;
    }

    /**
     * Legt den Wert der custodian-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link POCDMT000040Custodian }
     *
     */
    public void setCustodian(POCDMT000040Custodian value) {
        this.custodian = value;
    }

    /**
     * Legt den Wert der dataEnterer-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link POCDMT000040DataEnterer }
     *
     */
    public void setDataEnterer(POCDMT000040DataEnterer value) {
        this.dataEnterer = value;
    }

    /**
     * Legt den Wert der effectiveTime-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link TS }
     *
     */
    public void setEffectiveTime(TS value) {
        this.effectiveTime = value;
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
     * Legt den Wert der idAttr-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setIDAttr(String value) {
        this.idAttr = value;
    }

    /**
     * Legt den Wert der languageCode-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CS }
     *
     */
    public void setLanguageCode(CS value) {
        this.languageCode = value;
    }

    /**
     * Legt den Wert der legalAuthenticator-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link POCDMT000040LegalAuthenticator }
     *
     */
    public void setLegalAuthenticator(POCDMT000040LegalAuthenticator value) {
        this.legalAuthenticator = value;
    }

    /**
     * Legt den Wert der setId-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link II }
     *
     */
    public void setSetId(II value) {
        this.setId = value;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link ST }
     *
     */
    public void setTitle(ST value) {
        this.title = value;
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

    /**
     * Legt den Wert der versionNumber-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link INT }
     *
     */
    public void setVersionNumber(INT value) {
        this.versionNumber = value;
    }

}
