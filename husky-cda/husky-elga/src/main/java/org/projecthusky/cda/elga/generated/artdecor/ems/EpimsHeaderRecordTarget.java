/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId;
import org.projecthusky.common.hl7cdar2.POCDMT000040PatientRole;

/**
 * epims_header_RecordTarget
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.34<br>
 * Effective date: 2020-02-20 09:20:38<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.EpimsHeaderRecordTarget", namespace = "urn:hl7-org:v3", propOrder = { "realmCode",
		"typeId",
		"templateId", "patientRole" })
public class EpimsHeaderRecordTarget {

	protected List<CS> realmCode;
	protected POCDMT000040InfrastructureRootTypeId typeId;
	protected List<II> templateId;
	@XmlElement(required = true, name = "patientRole")
	protected EpimsPatientRole patientRole;
	@XmlAttribute(name = "nullFlavor")
	protected List<String> nullFlavor;
	@XmlAttribute(name = "typeCode")
	protected List<String> typeCode;
	@XmlAttribute(name = "contextControlCode")
	protected String contextControlCode;

	public EpimsHeaderRecordTarget() {
		getTypeCode().add("RCT");
		setContextControlCode("OP");
		setPatientRole(createHl7PatientRoleFixedValue("PAT"));
	}

	/**
	 * Creates fixed contents for CDA Element hl7PatientRole
	 *
	 * @param classCode the desired fixed value for this argument.
	 */
	private static EpimsPatientRole createHl7PatientRoleFixedValue(String classCode) {
		EpimsPatientRole retVal = new EpimsPatientRole();
		retVal.getClassCode().add(classCode);
		return retVal;
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
	 */
	@NonNull
	public List<String> getNullFlavor() {
		if (nullFlavor == null) {
			nullFlavor = new ArrayList<>();
		}
		return this.nullFlavor;
	}

	/**
	 * Ruft den Wert der patientRole-Eigenschaft ab.
	 *
	 * @return possible object is {@link POCDMT000040PatientRole }
	 */
	public EpimsPatientRole getPatientRole() {
		return patientRole;
	}

	/**
	 * Gets the value of the realmCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the realmCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRealmCode().add(newItem);
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
	 * Gets the value of the templateId property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the templateId property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTemplateId().add(newItem);
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
	 * Gets the value of the typeCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the typeCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTypeCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 */
	@NonNull
	public List<String> getTypeCode() {
		if (typeCode == null) {
			typeCode = new ArrayList<>();
		}
		return this.typeCode;
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
	 * Legt den Wert der contextControlCode-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link String }
	 */
	public void setContextControlCode(String value) {
		this.contextControlCode = value;
	}

	/**
	 * Legt den Wert der patientRole-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link EpimsPatientRole }
	 */
	public void setPatientRole(EpimsPatientRole value) {
		this.patientRole = value;
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
