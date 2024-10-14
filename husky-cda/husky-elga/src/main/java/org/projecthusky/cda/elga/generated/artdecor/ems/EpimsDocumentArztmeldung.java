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
import java.util.UUID;

import javax.annotation.processing.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.common.hl7cdar2.ActClinicalDocument;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Authenticator;
import org.projecthusky.common.hl7cdar2.POCDMT000040Author;
import org.projecthusky.common.hl7cdar2.POCDMT000040Authorization;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component1;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component2;
import org.projecthusky.common.hl7cdar2.POCDMT000040Custodian;
import org.projecthusky.common.hl7cdar2.POCDMT000040DataEnterer;
import org.projecthusky.common.hl7cdar2.POCDMT000040DocumentationOf;
import org.projecthusky.common.hl7cdar2.POCDMT000040InFulfillmentOf;
import org.projecthusky.common.hl7cdar2.POCDMT000040Informant12;
import org.projecthusky.common.hl7cdar2.POCDMT000040InformationRecipient;
import org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId;
import org.projecthusky.common.hl7cdar2.POCDMT000040LegalAuthenticator;
import org.projecthusky.common.hl7cdar2.POCDMT000040Participant1;
import org.projecthusky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.projecthusky.common.hl7cdar2.POCDMT000040RelatedDocument;
import org.projecthusky.common.hl7cdar2.ST;
import org.projecthusky.common.hl7cdar2.TS;

/**
 * epims_document_arztmeldung
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.6.0.2<br>
 * Effective date: 2020-02-20 08:35:37<br>
 * Version: 2020<br>
 * Status: draft
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.EpimsDocumentArztmeldung", propOrder = { "realmCode",
		"typeId",
		"templateId", "id", "code",
		"title", "effectiveTime", "confidentialityCode", "languageCode", "setId", "versionNumber", "copyTime",
		"recordTarget", "author", "dataEnterer", "informant", "custodian", "informationRecipient", "legalAuthenticator",
		"authenticator", "participant", "inFulfillmentOf", "documentationOf", "relatedDocument", "authorization",
		"componentOf", "component" })
@XmlRootElement(name = "ClinicalDocument", namespace = "urn:hl7-org:v3")
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsDocumentArztmeldung {

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
	@XmlElement(required = true, name = "recordTarget")
	protected List<EpimsHeaderRecordTarget> recordTarget;
	protected List<POCDMT000040RelatedDocument> relatedDocument;
	protected II setId;
	protected List<II> templateId;
	protected ST title;
	@XmlElement(required = true)
	protected POCDMT000040InfrastructureRootTypeId typeId;
	protected INT versionNumber;

    public EpimsDocumentArztmeldung() {
		setClassCode(org.projecthusky.common.hl7cdar2.ActClinicalDocument.DOCCLIN);
		getMoodCode().add("EVN");
		getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.1"));
		getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.6"));
		getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.6.0.2"));
		setCode(createHl7CodeFixedValue("34782-3",
                                              "2.16.840.1.113883.6.1",
                                              "LOINC",
                                              "Infectious disease Note"));
		setComponent(createHl7ComponentFixedValue("COMP",
                                                        "true"));
    }

	/**
	 * Gets the value of the authenticator property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the authenticator property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAuthenticator().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Authenticator }
	 */
	@NonNull
	public List<POCDMT000040Authenticator> getAuthenticator() {
		if (authenticator == null) {
			authenticator = new ArrayList<>();
		}
		return this.authenticator;
	}

	/**
	 * Gets the value of the author property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the author property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAuthor().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Author }
	 */
	@NonNull
	public List<POCDMT000040Author> getAuthor() {
		if (author == null) {
			author = new ArrayList<>();
		}
		return this.author;
	}

	/**
	 * Gets the value of the authorization property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the authorization property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAuthorization().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Authorization }
	 */
	@NonNull
	public List<POCDMT000040Authorization> getAuthorization() {
		if (authorization == null) {
			authorization = new ArrayList<>();
		}
		return this.authorization;
	}

	/**
	 * Ruft den Wert der classCode-Eigenschaft ab.
	 *
	 * @return possible object is {@link ActClinicalDocument }
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
	 */
	public CE getCode() {
		return code;
	}

	/**
	 * Ruft den Wert der component-Eigenschaft ab.
	 *
	 * @return possible object is {@link POCDMT000040Component2 }
	 */
	public POCDMT000040Component2 getComponent() {
		return component;
	}

	/**
	 * Ruft den Wert der componentOf-Eigenschaft ab.
	 *
	 * @return possible object is {@link POCDMT000040Component1 }
	 */
	public POCDMT000040Component1 getComponentOf() {
		return componentOf;
	}

	/**
	 * Ruft den Wert der confidentialityCode-Eigenschaft ab.
	 *
	 * @return possible object is {@link CE }
	 */
	public CE getConfidentialityCode() {
		return confidentialityCode;
	}

	/**
	 * Ruft den Wert der copyTime-Eigenschaft ab.
	 *
	 * @return possible object is {@link TS }
	 */
	public TS getCopyTime() {
		return copyTime;
	}

	/**
	 * Ruft den Wert der custodian-Eigenschaft ab.
	 *
	 * @return possible object is {@link POCDMT000040Custodian }
	 */
	public POCDMT000040Custodian getCustodian() {
		return custodian;
	}

	/**
	 * Ruft den Wert der dataEnterer-Eigenschaft ab.
	 *
	 * @return possible object is {@link POCDMT000040DataEnterer }
	 */
	public POCDMT000040DataEnterer getDataEnterer() {
		return dataEnterer;
	}

	/**
	 * Gets the value of the documentationOf property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the documentationOf property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDocumentationOf().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040DocumentationOf }
	 */
	@NonNull
	public List<POCDMT000040DocumentationOf> getDocumentationOf() {
		if (documentationOf == null) {
			documentationOf = new ArrayList<>();
		}
		return this.documentationOf;
	}

	/**
	 * Ruft den Wert der effectiveTime-Eigenschaft ab.
	 *
	 * @return possible object is {@link TS }
	 */
	public TS getEffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Ruft den Wert der id-Eigenschaft ab.
	 *
	 * @return possible object is {@link II }
	 */
	public II getId() {
		return id;
	}

	/**
	 * Ruft den Wert der idAttr-Eigenschaft ab.
	 *
	 * @return possible object is {@link String }
	 */
	public String getIDAttr() {
		return idAttr;
	}

	/**
	 * Gets the value of the informant property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the informant property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getInformant().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Informant12 }
	 */
	@NonNull
	public List<POCDMT000040Informant12> getInformant() {
		if (informant == null) {
			informant = new ArrayList<>();
		}
		return this.informant;
	}

	/**
	 * Gets the value of the informationRecipient property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the informationRecipient property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getInformationRecipient().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040InformationRecipient }
	 */
	@NonNull
	public List<POCDMT000040InformationRecipient> getInformationRecipient() {
		if (informationRecipient == null) {
			informationRecipient = new ArrayList<>();
		}
		return this.informationRecipient;
	}

	/**
	 * Gets the value of the inFulfillmentOf property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the inFulfillmentOf property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getInFulfillmentOf().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040InFulfillmentOf }
	 */
	@NonNull
	public List<POCDMT000040InFulfillmentOf> getInFulfillmentOf() {
		if (inFulfillmentOf == null) {
			inFulfillmentOf = new ArrayList<>();
		}
		return this.inFulfillmentOf;
	}

	/**
	 * Ruft den Wert der languageCode-Eigenschaft ab.
	 *
	 * @return possible object is {@link CS }
	 */
	public CS getLanguageCode() {
		return languageCode;
	}

	/**
	 * Ruft den Wert der legalAuthenticator-Eigenschaft ab.
	 *
	 * @return possible object is {@link POCDMT000040LegalAuthenticator }
	 */
	public POCDMT000040LegalAuthenticator getLegalAuthenticator() {
		return legalAuthenticator;
	}

	/**
	 * Gets the value of the moodCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the moodCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMoodCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 */
	@NonNull
	public List<String> getMoodCode() {
		if (moodCode == null) {
			moodCode = new ArrayList<>();
		}
		return this.moodCode;
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
	 * Gets the value of the participant property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the participant property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getParticipant().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Participant1 }
	 */
	@NonNull
	public List<POCDMT000040Participant1> getParticipant() {
		if (participant == null) {
			participant = new ArrayList<>();
		}
		return this.participant;
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
	 * Gets the value of the recordTarget property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the recordTarget property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRecordTarget().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040RecordTarget }
	 */
	@NonNull
	public List<EpimsHeaderRecordTarget> getRecordTarget() {
		if (recordTarget == null) {
			recordTarget = new ArrayList<>();
		}
		return this.recordTarget;
	}

	/**
	 * Gets the value of the relatedDocument property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the relatedDocument property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRelatedDocument().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040RelatedDocument }
	 */
	@NonNull
	public List<POCDMT000040RelatedDocument> getRelatedDocument() {
		if (relatedDocument == null) {
			relatedDocument = new ArrayList<>();
		}
		return this.relatedDocument;
	}

	/**
	 * Ruft den Wert der setId-Eigenschaft ab.
	 *
	 * @return possible object is {@link II }
	 */
	public II getSetId() {
		return setId;
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
	 * Ruft den Wert der title-Eigenschaft ab.
	 *
	 * @return possible object is {@link ST }
	 */
	public ST getTitle() {
		return title;
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
	 * Ruft den Wert der versionNumber-Eigenschaft ab.
	 *
	 * @return possible object is {@link INT }
	 */
	public INT getVersionNumber() {
		return versionNumber;
	}

	/**
	 * Legt den Wert der classCode-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link ActClinicalDocument }
	 */
	public void setClassCode(ActClinicalDocument value) {
		this.classCode = value;
	}

	/**
	 * Legt den Wert der code-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link CE }
	 */
	public void setCode(CE value) {
		this.code = value;
	}

	/**
	 * Legt den Wert der component-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link POCDMT000040Component2 }
	 */
	public void setComponent(POCDMT000040Component2 value) {
		this.component = value;
	}

	/**
	 * Legt den Wert der componentOf-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link POCDMT000040Component1 }
	 */
	public void setComponentOf(POCDMT000040Component1 value) {
		this.componentOf = value;
	}

	/**
	 * Legt den Wert der confidentialityCode-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link CE }
	 */
	public void setConfidentialityCode(CE value) {
		this.confidentialityCode = value;
	}

	/**
	 * Legt den Wert der copyTime-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link TS }
	 */
	public void setCopyTime(TS value) {
		this.copyTime = value;
	}

	/**
	 * Legt den Wert der custodian-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link POCDMT000040Custodian }
	 */
	public void setCustodian(POCDMT000040Custodian value) {
		this.custodian = value;
	}

	/**
	 * Legt den Wert der dataEnterer-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link POCDMT000040DataEnterer }
	 */
	public void setDataEnterer(POCDMT000040DataEnterer value) {
		this.dataEnterer = value;
	}

	/**
	 * Legt den Wert der effectiveTime-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link TS }
	 */
	public void setEffectiveTime(TS value) {
		this.effectiveTime = value;
	}

	/**
	 * Legt den Wert der id-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link II }
	 */
	public void setId(II value) {
		this.id = value;
	}

	/**
	 * Legt den Wert der idAttr-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link String }
	 */
	public void setIDAttr(String value) {
		this.idAttr = value;
	}

	/**
	 * Legt den Wert der languageCode-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link CS }
	 */
	public void setLanguageCode(CS value) {
		this.languageCode = value;
	}

	/**
	 * Legt den Wert der legalAuthenticator-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link POCDMT000040LegalAuthenticator }
	 */
	public void setLegalAuthenticator(POCDMT000040LegalAuthenticator value) {
		this.legalAuthenticator = value;
	}

	/**
	 * Legt den Wert der setId-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link II }
	 */
	public void setSetId(II value) {
		this.setId = value;
	}

	/**
	 * Legt den Wert der title-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link ST }
	 */
	public void setTitle(ST value) {
		this.title = value;
	}

	/**
	 * Legt den Wert der typeId-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link POCDMT000040InfrastructureRootTypeId }
	 */
	public void setTypeId(POCDMT000040InfrastructureRootTypeId value) {
		this.typeId = value;
	}

	/**
	 * Legt den Wert der versionNumber-Eigenschaft fest.
	 *
	 * @param value allowed object is {@link INT }
	 */
	public void setVersionNumber(INT value) {
		this.versionNumber = value;
	}

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Component
     *
     * @param typeCode the desired fixed value for this argument.
     * @param contextConductionInd the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Component2 createHl7ComponentFixedValue(String typeCode, String contextConductionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Component2 retVal = factory.createPOCDMT000040Component2();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent.fromValue(typeCode));
        if (contextConductionInd != null) {
            retVal.setContextConductionInd(Boolean.parseBoolean(contextConductionInd));
        }
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Authenticator
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Authenticator> getHl7Authenticator() {
        return authenticator;
    }

    /**
     * Gets the hl7Author
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Author> getHl7Author() {
        return author;
    }

    /**
     * Gets the hl7Code
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Component
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040Component2 getHl7Component() {
        return component;
    }

    /**
     * Gets the hl7ConfidentialityCode
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7ConfidentialityCode() {
        return confidentialityCode;
    }

    /**
     * Gets the hl7Custodian
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040Custodian getHl7Custodian() {
        return custodian;
    }

    /**
     * Gets the hl7DocumentationOf
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040DocumentationOf> getHl7DocumentationOf() {
        return documentationOf;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.projecthusky.common.hl7cdar2.TS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Id
     */
    public org.projecthusky.common.hl7cdar2.II getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7InFulfillmentOf
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040InFulfillmentOf> getHl7InFulfillmentOf() {
        return inFulfillmentOf;
    }

    /**
     * Gets the hl7InformationRecipient
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040InformationRecipient> getHl7InformationRecipient() {
        return informationRecipient;
    }

    /**
     * Gets the hl7LanguageCode
     */
	public CS getHl7LanguageCode() {
        return languageCode;
    }

    /**
     * Gets the hl7LegalAuthenticator
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040LegalAuthenticator getHl7LegalAuthenticator() {
        return legalAuthenticator;
    }

    /**
     * Gets the hl7Participant
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Participant1> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7RealmCode
     */
    public List<org.projecthusky.common.hl7cdar2.CS> getHl7RealmCode() {
        return realmCode;
    }

    /**
     * Gets the hl7SetId
     */
    public org.projecthusky.common.hl7cdar2.II getHl7SetId() {
        return setId;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Title
     */
    public org.projecthusky.common.hl7cdar2.ST getHl7Title() {
        return title;
    }

    /**
     * Gets the hl7TypeId
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId getHl7TypeId() {
        return typeId;
    }

    /**
     * Gets the hl7VersionNumber
     */
    public org.projecthusky.common.hl7cdar2.INT getHl7VersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the version number to 1 and makes sure the setId is the same as the document id.
     * @param newDocId the new doc id
     */
    public void initFirstVersion(String newDocId) {
        II docId = new II();
        docId.setRoot(newDocId);
        if (newDocId == null) {
            docId.setRoot(UUID.randomUUID().toString());
        }
        this.setId(docId);
        this.setVersion(docId.getRoot(),
                        1);
    }

    /**
     * Increases the version number by one and makes sure the setId remains the same as previously.
     * @param newDocId the new doc id
     */
    public void initNextVersion(String newDocId) {
        final var id = new II();
        id.setRoot(newDocId);
        II setId = this.getSetId();
        if (setId == null) {
            setId = this.getId();
        }
        if (setId == null) {
            setId = id;
        }
        Integer version = this.getVersionNumber().getValue().intValue();
        this.setId(id);
        this.setVersion(setId.getRoot(),
                        version + 1);
    }

    /**
     * Sets the hl7Authenticator
     */
    public void setHl7Authenticator(org.projecthusky.common.hl7cdar2.POCDMT000040Authenticator value) {
        getAuthenticator().clear();
        getAuthenticator().add(value);
    }

    /**
     * Sets the hl7Author
     */
    public void setHl7Author(org.projecthusky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().clear();
        getAuthor().add(value);
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7Component
     */
    public void setHl7Component(org.projecthusky.common.hl7cdar2.POCDMT000040Component2 value) {
        this.component = value;
    }

    /**
     * Sets the hl7ConfidentialityCode
     */
    public void setHl7ConfidentialityCode(org.projecthusky.common.hl7cdar2.CE value) {
        this.confidentialityCode = value;
    }

    /**
     * Sets the hl7Custodian
     */
    public void setHl7Custodian(org.projecthusky.common.hl7cdar2.POCDMT000040Custodian value) {
        this.custodian = value;
    }

    /**
     * Sets the hl7DocumentationOf
     */
    public void setHl7DocumentationOf(org.projecthusky.common.hl7cdar2.POCDMT000040DocumentationOf value) {
        getDocumentationOf().clear();
        getDocumentationOf().add(value);
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.TS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        this.id = value;
    }

    /**
     * Sets the hl7InFulfillmentOf
     */
    public void setHl7InFulfillmentOf(org.projecthusky.common.hl7cdar2.POCDMT000040InFulfillmentOf value) {
        getInFulfillmentOf().clear();
        getInFulfillmentOf().add(value);
    }

    /**
     * Sets the hl7InformationRecipient
     */
    public void setHl7InformationRecipient(org.projecthusky.common.hl7cdar2.POCDMT000040InformationRecipient value) {
        getInformationRecipient().clear();
        getInformationRecipient().add(value);
    }

    /**
     * Sets the hl7LanguageCode
     */
	public void setHl7LanguageCode(CS value) {
        this.languageCode = value;
    }

    /**
     * Sets the hl7LegalAuthenticator
     */
    public void setHl7LegalAuthenticator(org.projecthusky.common.hl7cdar2.POCDMT000040LegalAuthenticator value) {
        this.legalAuthenticator = value;
    }

    /**
     * Sets the hl7Participant
     */
    public void setHl7Participant(org.projecthusky.common.hl7cdar2.POCDMT000040Participant1 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7RealmCode
     */
    public void setHl7RealmCode(org.projecthusky.common.hl7cdar2.CS value) {
        getRealmCode().clear();
        getRealmCode().add(value);
    }

    /**
     * Sets the hl7SetId
     */
    public void setHl7SetId(org.projecthusky.common.hl7cdar2.II value) {
        this.setId = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Title
     */
    public void setHl7Title(org.projecthusky.common.hl7cdar2.ST value) {
        this.title = value;
    }

    /**
     * Sets the hl7TypeId
     */
    public void setHl7TypeId(org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId value) {
        this.typeId = value;
    }

    /**
     * Sets the hl7VersionNumber
     */
    public void setHl7VersionNumber(org.projecthusky.common.hl7cdar2.INT value) {
        this.versionNumber = value;
    }

    /**
     * <div class="en">Sets the document set Id and version number.</div>
     *
     * <div class="de">Weist dem Dokument eine Set Id und eine Versionsnummer zu.</div>
     * @param idVersion1 the set Id (if null, the document ID will be used)
     * @param version the version of the document
     */
    public void setVersion(String idVersion1, int version) {
        final var id = new II();
        id.setRoot(idVersion1);
		setSetId(id);
		setVersionNumber(new INT(version));
    }

}
