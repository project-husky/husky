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

package org.husky.common.hl7cdar2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für COCT_MT230100UV.Part complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="COCT_MT230100UV.Part">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="quantity" type="{urn:hl7-org:v3}RTO_PQ_PQ" minOccurs="0"/>
 *         &lt;element name="partMedicine" type="{urn:ihe:pharm}COCT_MT230100UV.Medicine"/>
 *         &lt;element name="subjectOf" type="{urn:ihe:pharm}COCT_MT230100UV.Subject4" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}RoleClassPart" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.Part", namespace = "urn:ihe:pharm", propOrder = { "realmCode",
		"typeId", "templateId", "quantity", "partMedicine", "subjectOf" })
public class COCTMT230100UVPart {

	@XmlElement(namespace = "urn:hl7-org:v3")
	protected List<CS> realmCode;
	@XmlElement(namespace = "urn:hl7-org:v3")
	protected AllInfrastructureRootTypeId typeId;
	@XmlElement(namespace = "urn:hl7-org:v3")
	protected List<AllInfrastructureRootTemplateId> templateId;
	protected RTOPQPQ quantity;
	@XmlElement(required = true)
	protected COCTMT230100UVMedicine partMedicine;
	@XmlElement(nillable = true)
	protected List<COCTMT230100UVSubject4> subjectOf;
	@XmlAttribute(name = "nullFlavor")
	protected List<String> nullFlavor;
	@XmlAttribute(name = "classCode", required = true)
	protected RoleClassPart classCode;

	/**
	 * Ruft den Wert der classCode-Eigenschaft ab.
	 *
	 * @return possible object is {@link RoleClassPart }
	 *
	 */
	public RoleClassPart getClassCode() {
		return classCode;
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
	 * Ruft den Wert der partMedicine-Eigenschaft ab.
	 *
	 * @return possible object is {@link COCTMT230100UVMedicine }
	 *
	 */
	public COCTMT230100UVMedicine getPartMedicine() {
		return partMedicine;
	}

	/**
	 * Ruft den Wert der quantity-Eigenschaft ab.
	 *
	 * @return possible object is {@link RTOPQPQ }
	 *
	 */
	public RTOPQPQ getQuantity() {
		return quantity;
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
	 * Gets the value of the subjectOf property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the subjectOf property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getSubjectOf().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link COCTMT230100UVSubject4 }
	 *
	 *
	 */
	public List<COCTMT230100UVSubject4> getSubjectOf() {
		if (subjectOf == null) {
			subjectOf = new ArrayList<COCTMT230100UVSubject4>();
		}
		return this.subjectOf;
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
	 * Legt den Wert der classCode-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link RoleClassPart }
	 *
	 */
	public void setClassCode(RoleClassPart value) {
		this.classCode = value;
	}

	/**
	 * Legt den Wert der partMedicine-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link COCTMT230100UVMedicine }
	 *
	 */
	public void setPartMedicine(COCTMT230100UVMedicine value) {
		this.partMedicine = value;
	}

	/**
	 * Legt den Wert der quantity-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link RTOPQPQ }
	 *
	 */
	public void setQuantity(RTOPQPQ value) {
		this.quantity = value;
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
