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
 * Java-Klasse für POCD_MT000040.Subject complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.Subject"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/&gt;
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="awarenessCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/&gt;
 *         &lt;element name="relatedSubject" type="{urn:hl7-org:v3}POCD_MT000040.RelatedSubject"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" /&gt;
 *       &lt;attribute name="typeCode" type="{urn:hl7-org:v3}ParticipationTargetSubject" fixed="SBJ" /&gt;
 *       &lt;attribute name="contextControlCode" type="{urn:hl7-org:v3}ContextControl" fixed="OP" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Subject", propOrder = {"realmCode", "typeId", "templateId",
        "awarenessCode", "relatedSubject"})
public class POCDMT000040Subject {

    protected List<CS> realmCode;
    protected POCDMT000040InfrastructureRootTypeId typeId;
    protected List<II> templateId;
    protected CE awarenessCode;
    @XmlElement(required = true)
    protected POCDMT000040RelatedSubject relatedSubject;
    @XmlAttribute(name = "nullFlavor")
    protected List<String> nullFlavor;
    @XmlAttribute(name = "typeCode")
    protected ParticipationTargetSubject typeCode;
    @XmlAttribute(name = "contextControlCode")
    protected String contextControlCode;

    /**
     * Ruft den Wert der awarenessCode-Eigenschaft ab.
     *
     * @return possible object is {@link CE }
     */
    public CE getAwarenessCode() {
        return awarenessCode;
    }

    /**
     * Ruft den Wert der contextControlCode-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    @NonNull
    public String getContextControlCode() {
        if (contextControlCode == null) {
            return "OP";
        } else {
            return contextControlCode;
        }
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
     * Ruft den Wert der relatedSubject-Eigenschaft ab.
     *
     * @return possible object is {@link POCDMT000040RelatedSubject }
     */
    public POCDMT000040RelatedSubject getRelatedSubject() {
        return relatedSubject;
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
     * Ruft den Wert der typeCode-Eigenschaft ab.
     *
     * @return possible object is {@link ParticipationTargetSubject }
     */
    @NonNull
    public ParticipationTargetSubject getTypeCode() {
        if (typeCode == null) {
            return ParticipationTargetSubject.SBJ;
        } else {
            return typeCode;
        }
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
     * Legt den Wert der awarenessCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link CE }
     */
    public void setAwarenessCode(CE value) {
        this.awarenessCode = value;
    }

    /**
     * Legt den Wert der contextControlCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setContextControlCode(String value) {
        this.contextControlCode = value;
    }

    /**
     * Legt den Wert der relatedSubject-Eigenschaft fest.
     *
     * @param value allowed object is {@link POCDMT000040RelatedSubject }
     */
    public void setRelatedSubject(POCDMT000040RelatedSubject value) {
        this.relatedSubject = value;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     *
     * @param value allowed object is {@link ParticipationTargetSubject }
     */
    public void setTypeCode(ParticipationTargetSubject value) {
        this.typeCode = value;
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
