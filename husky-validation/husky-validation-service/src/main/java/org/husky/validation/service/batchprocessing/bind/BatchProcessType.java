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
// Generiert: 2016.12.09 um 10:05:27 AM CET
//

package org.husky.validation.service.batchprocessing.bind;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java-Klasse für BatchProcessType complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="BatchProcessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="batchEntry" type="{}BatchEntryType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="configFile" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="validateSchema" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="validateSchematron" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="validatePDF" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchProcessType", propOrder = { "batchEntry" })
public class BatchProcessType {

	@XmlElement(required = true)
	protected List<BatchEntryType> batchEntry;
	@XmlAttribute(name = "id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "configFile", required = true)
	protected String configFile;
	@XmlAttribute(name = "validateSchema", required = true)
	protected boolean validateSchema;
	@XmlAttribute(name = "validateSchematron", required = true)
	protected boolean validateSchematron;
	@XmlAttribute(name = "validatePDF", required = true)
	protected boolean validatePDF;

	/**
	 * Gets the value of the batchEntry property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the batchEntry property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getBatchEntry().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link BatchEntryType }
	 *
	 *
	 */
	public List<BatchEntryType> getBatchEntry() {
		if (batchEntry == null) {
			batchEntry = new ArrayList<BatchEntryType>();
		}
		return this.batchEntry;
	}

	/**
	 * Ruft den Wert der configFile-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getConfigFile() {
		return configFile;
	}

	/**
	 * Ruft den Wert der id-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getId() {
		return id;
	}

	/**
	 * Ruft den Wert der validatePDF-Eigenschaft ab.
	 *
	 */
	public boolean isValidatePDF() {
		return validatePDF;
	}

	/**
	 * Ruft den Wert der validateSchema-Eigenschaft ab.
	 *
	 */
	public boolean isValidateSchema() {
		return validateSchema;
	}

	/**
	 * Ruft den Wert der validateSchematron-Eigenschaft ab.
	 *
	 */
	public boolean isValidateSchematron() {
		return validateSchematron;
	}

	/**
	 * Legt den Wert der configFile-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setConfigFile(String value) {
		this.configFile = value;
	}

	/**
	 * Legt den Wert der id-Eigenschaft fest.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Legt den Wert der validatePDF-Eigenschaft fest.
	 *
	 */
	public void setValidatePDF(boolean value) {
		this.validatePDF = value;
	}

	/**
	 * Legt den Wert der validateSchema-Eigenschaft fest.
	 *
	 */
	public void setValidateSchema(boolean value) {
		this.validateSchema = value;
	}

	/**
	 * Legt den Wert der validateSchematron-Eigenschaft fest.
	 *
	 */
	public void setValidateSchematron(boolean value) {
		this.validateSchematron = value;
	}

}
