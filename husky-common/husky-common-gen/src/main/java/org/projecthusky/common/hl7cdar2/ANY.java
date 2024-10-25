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
import org.checkerframework.checker.nullness.qual.Nullable;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Defines the basic properties of every data value. This is an abstract type,
 * meaning that no value can be just a data value without belonging to any
 * concrete type. Every concrete type is a specialization of this general
 * abstract DataValue type.
 *
 *
 * <p>
 * Java-Klasse für ANY complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="ANY"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlType(name = "ANY")
@XmlSeeAlso({ BL.class, ANYNonNull.class, CR.class, SLISTTS.class, GLISTPQ.class, SLISTPQ.class, GLISTTS.class,
		II.class, QTY.class, CD.class, URL.class, BIN.class })
// Fix Tony Schaller, medshare GmbH: make the JAXB classes for HL7 CDA R2
// Serializable
public abstract class ANY {

	// Fix Tony Schaller, medshare GmbH: making public in order to access this
	// field from all derivates
	/** null flavor */
	@XmlAttribute(name = "nullFlavor")
	public List<String> nullFlavor;

	/** xmlMixed list */
	private List<String> xmlMixed = new ArrayList<>();

	/**
	 * Method to get
	 * 
	 * @return xmlMixed
	 */
	@XmlMixed
	public List<String> getXmlMixed() {
		return this.xmlMixed;
	}

	/**
	 * Method to set
	 * 
	 * @param xmlMixed the xml mixed list
	 */
	public void setXmlMixed(final List<String> xmlMixed) {
		if (xmlMixed == null) {
			this.xmlMixed = null;
		} else {
			this.xmlMixed = xmlMixed.stream().map(String::strip).filter(string -> !string.isEmpty()).toList();
		}
	}

	/**
	 * Method to set xml mixed list from one xmlmixed
	 * 
	 * @param xmlMixed the xmlMixed entry as string
	 */
	public void setXmlMixed(@Nullable final String xmlMixed) {
		if (xmlMixed == null) {
			this.xmlMixed = null;
		} else {
			this.xmlMixed = List.of(Objects.requireNonNull(xmlMixed));
		}
	}

	/**
	 * Method to get merged xmlMixed.
	 * 
	 * @return the xmlMixed content joint as string
	 */
	@NonNull
	public String getMergedXmlMixed() {
		if (this.xmlMixed == null || this.xmlMixed.isEmpty()) {
			return "";
		} else if (this.xmlMixed.size() == 1) {
			return this.xmlMixed.get(0);
		} else {
			return String.join("", this.xmlMixed);
		}
	}

	/**
	 * Gets the value of the nullFlavor property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the nullFlavor property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getNullFlavor().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * @return returns a list of nullFlavor
	 */
	@NonNull
	public List<String> getNullFlavor() {
		if (nullFlavor == null) {
			nullFlavor = new ArrayList<>();
		}
		return this.nullFlavor;
	}

	/**
	 * Gets the value of the nullFlavor property. If {@code replaceNullByEmptyList}
	 * is set to {@code true}, the property is set to a new list if it was
	 * {@code null}.
	 *
	 * <p>
	 * If {@code replaceNullByEmptyList} is set to {@code true}, this accessor
	 * method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB
	 * object. This is why there is not a <CODE>set</CODE> method for the nullFlavor
	 * property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getNullFlavor().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * @param replaceNullByEmptyList to return if nullFlavor is null an empty list
	 * @return nullFlavor the nullFlavor list
	 */
	@NonNull
	public List<String> getNullFlavor(final boolean replaceNullByEmptyList) {
		if (nullFlavor == null) {
			if (replaceNullByEmptyList) {
				nullFlavor = new ArrayList<>();
			} else {
				return Collections.emptyList();
			}
		}
		return this.nullFlavor;
	}

}
