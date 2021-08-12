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
 * Java-Klasse für COCT_MT440001UV09.ValuedItem complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT440001UV09.ValuedItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" maxOccurs="unbounded"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CD" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *         &lt;element name="unitQuantity" type="{urn:hl7-org:v3}RTO_PQ_PQ" minOccurs="0"/>
 *         &lt;element name="unitPriceAmt" type="{urn:hl7-org:v3}RTO_MO_PQ"/>
 *         &lt;element name="netAmt" type="{urn:hl7-org:v3}MO" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}ActClassInvoiceElement" />
 *       &lt;attribute name="moodCode" use="required" type="{urn:hl7-org:v3}x_ActMoodDefEvn" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT440001UV09.ValuedItem", namespace = "urn:ihe:pharm", propOrder = {
		"realmCode", "typeId", "templateId", "id", "code", "effectiveTime", "unitQuantity",
		"unitPriceAmt", "netAmt" })
public class COCTMT440001UV09ValuedItem {

	@XmlElement(namespace = "urn:hl7-org:v3")
	protected List<CS> realmCode;
	@XmlElement(namespace = "urn:hl7-org:v3")
	protected AllInfrastructureRootTypeId typeId;
	@XmlElement(namespace = "urn:hl7-org:v3")
	protected List<AllInfrastructureRootTemplateId> templateId;
	@XmlElement(required = true)
	protected List<II> id;
	protected CD code;
	protected IVLTS effectiveTime;
	protected RTOPQPQ unitQuantity;
	@XmlElement(required = true)
	protected RTOMOPQ unitPriceAmt;
	protected MO netAmt;
	@XmlAttribute(name = "classCode", required = true)
	protected ActClassInvoiceElement classCode;
	@XmlAttribute(name = "moodCode", required = true)
	protected XActMoodDefEvn moodCode;

	/**
	 * Ruft den Wert der classCode-Eigenschaft ab.
	 *
	 * @return possible object is {@link ActClassInvoiceElement }
	 *
	 */
	public ActClassInvoiceElement getClassCode() {
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
	 * Ruft den Wert der moodCode-Eigenschaft ab.
	 *
	 * @return possible object is {@link XActMoodDefEvn }
	 *
	 */
	public XActMoodDefEvn getMoodCode() {
		return moodCode;
	}

	/**
	 * Ruft den Wert der netAmt-Eigenschaft ab.
	 *
	 * @return possible object is {@link MO }
	 *
	 */
	public MO getNetAmt() {
		return netAmt;
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
	 * Ruft den Wert der typeId-Eigenschaft ab.
	 *
	 * @return possible object is {@link AllInfrastructureRootTypeId }
	 *
	 */
	public AllInfrastructureRootTypeId getTypeId() {
		return typeId;
	}

	/**
	 * Ruft den Wert der unitPriceAmt-Eigenschaft ab.
	 *
	 * @return possible object is {@link RTOMOPQ }
	 *
	 */
	public RTOMOPQ getUnitPriceAmt() {
		return unitPriceAmt;
	}

	/**
	 * Ruft den Wert der unitQuantity-Eigenschaft ab.
	 *
	 * @return possible object is {@link RTOPQPQ }
	 *
	 */
	public RTOPQPQ getUnitQuantity() {
		return unitQuantity;
	}

	/**
	 * Legt den Wert der classCode-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link ActClassInvoiceElement }
	 *
	 */
	public void setClassCode(ActClassInvoiceElement value) {
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
	 * Legt den Wert der moodCode-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link XActMoodDefEvn }
	 *
	 */
	public void setMoodCode(XActMoodDefEvn value) {
		this.moodCode = value;
	}

	/**
	 * Legt den Wert der netAmt-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link MO }
	 *
	 */
	public void setNetAmt(MO value) {
		this.netAmt = value;
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
	 * Legt den Wert der unitPriceAmt-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link RTOMOPQ }
	 *
	 */
	public void setUnitPriceAmt(RTOMOPQ value) {
		this.unitPriceAmt = value;
	}

	/**
	 * Legt den Wert der unitQuantity-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link RTOPQPQ }
	 *
	 */
	public void setUnitQuantity(RTOPQPQ value) {
		this.unitQuantity = value;
	}

}
