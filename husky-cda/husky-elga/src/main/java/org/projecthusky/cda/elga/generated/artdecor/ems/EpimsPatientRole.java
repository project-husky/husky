package org.projecthusky.cda.elga.generated.artdecor.ems;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.common.hl7cdar2.AD;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId;
import org.projecthusky.common.hl7cdar2.POCDMT000040Organization;
import org.projecthusky.common.hl7cdar2.TEL;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.EpimsPatientRole", namespace = "urn:hl7-org:v3", propOrder = { "realmCode", "typeId",
		"templateId", "id", "addr", "telecom",
		"patient", "providerOrganization" })
public class EpimsPatientRole {

	protected List<CS> realmCode;
	protected POCDMT000040InfrastructureRootTypeId typeId;
	protected List<II> templateId;
	@XmlElement(required = true)
	protected List<II> id;
	protected List<AD> addr;
	protected List<TEL> telecom;
	@XmlElement(name = "patient")
	protected EpimsPatient patient;
	protected POCDMT000040Organization providerOrganization;
	@XmlAttribute(name = "nullFlavor")
	protected List<String> nullFlavor;
	@XmlAttribute(name = "classCode")
	protected List<String> classCode;

	/**
	 * Gets the value of the addr property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the addr property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAddr().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link AD }
	 */
	@NonNull
	public List<AD> getAddr() {
		if (addr == null) {
			addr = new ArrayList<>();
		}
		return this.addr;
	}

	/**
	 * Gets the value of the classCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the classCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getClassCode().add(newItem);
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
	 * Gets the value of the id property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the id property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getId().add(newItem);
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
	 * Ruft den Wert der patient-Eigenschaft ab.
	 *
	 * @return possible object is {@link EpimsPatient }
	 */
	public EpimsPatient getPatient() {
		return patient;
	}

	/**
	 * Ruft den Wert der providerOrganization-Eigenschaft ab.
	 *
	 * @return possible object is {@link POCDMT000040Organization }
	 */
	public POCDMT000040Organization getProviderOrganization() {
		return providerOrganization;
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
	 * Gets the value of the telecom property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the telecom property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTelecom().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TEL }
	 */
	@NonNull
	public List<TEL> getTelecom() {
		if (telecom == null) {
			telecom = new ArrayList<>();
		}
		return this.telecom;
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
	 * Ruft den Wert der typeId-Eigenschaft ab.
	 *
	 * @return possible object is {@link POCDMT000040InfrastructureRootTypeId }
	 */
	public POCDMT000040InfrastructureRootTypeId getTypeId() {
		return typeId;
	}

	/**
	 * Legt den Wert der patient-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link EpimsPatient }
	 */
	public void setPatient(EpimsPatient value) {
		this.patient = value;
	}

	/**
	 * Legt den Wert der providerOrganization-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link POCDMT000040Organization }
	 */
	public void setProviderOrganization(POCDMT000040Organization value) {
		this.providerOrganization = value;
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
