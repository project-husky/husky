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

package org.ehealth_connector.common.hl7cdar2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für COCT_MT230100UV.Characteristic complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.Characteristic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CE"/>
 *         &lt;element name="text" type="{urn:hl7-org:v3}ED" minOccurs="0"/>
 *         &lt;element name="value" type="{urn:hl7-org:v3}ANY" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}ActClassObservation" />
 *       &lt;attribute name="moodCode" use="required" type="{urn:hl7-org:v3}ActMoodEventOccurrence" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.Characteristic", namespace = "urn:ihe:pharm", propOrder = {
		"realmCode", "typeId", "templateId", "code", "text", "value" })
public class COCTMT230100UVCharacteristic {

	@XmlElement(namespace = "urn:hl7-org:v3")
	protected List<CS> realmCode;
	@XmlElement(namespace = "urn:hl7-org:v3")
	protected AllInfrastructureRootTypeId typeId;
	@XmlElement(namespace = "urn:hl7-org:v3")
	protected List<AllInfrastructureRootTemplateId> templateId;
	@XmlElement(required = true)
	protected CE code;
	protected ED text;
	protected ANY value;
	@XmlAttribute(name = "nullFlavor")
	protected List<String> nullFlavor;
	@XmlAttribute(name = "classCode", required = true)
	protected List<String> classCode;
	@XmlAttribute(name = "moodCode", required = true)
	protected ActMoodEventOccurrence moodCode;

	/**
	 * Gets the value of the classCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
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
	 *
	 *
	 */
	public List<String> getClassCode() {
		if (classCode == null) {
			classCode = new ArrayList<String>();
		}
		return this.classCode;
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
	 * Ruft den Wert der moodCode-Eigenschaft ab.
	 *
	 * @return possible object is {@link ActMoodEventOccurrence }
	 *
	 */
	public ActMoodEventOccurrence getMoodCode() {
		return moodCode;
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
	 * Ruft den Wert der text-Eigenschaft ab.
	 *
	 * @return possible object is {@link ED }
	 *
	 */
	public ED getText() {
		return text;
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
	 * Ruft den Wert der value-Eigenschaft ab.
	 *
	 * @return possible object is {@link ANY }
	 *
	 */
	public ANY getValue() {
		return value;
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
	 * Legt den Wert der moodCode-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link ActMoodEventOccurrence }
	 *
	 */
	public void setMoodCode(ActMoodEventOccurrence value) {
		this.moodCode = value;
	}

	/**
	 * Legt den Wert der text-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link ED }
	 *
	 */
	public void setText(ED value) {
		this.text = value;
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

	/**
	 * Legt den Wert der value-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link ANY }
	 *
	 */
	public void setValue(ANY value) {
		this.value = value;
	}

}
