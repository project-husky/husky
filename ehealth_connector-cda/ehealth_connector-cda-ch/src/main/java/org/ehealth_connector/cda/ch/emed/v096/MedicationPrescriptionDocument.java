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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.emed.v096;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.utils.Hl7CdaR2Util;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.1.4 Template
 * description: TheMedication Prescription document(IPAG report: eRezept)
 * describes the content and format of a Prescription document generated during
 * the process in which a health care professional decides that the patient
 * needs medication (*).Relation to IHE PharmacyThe Medication Prescription
 * document is based on the<a href=
 * "http://www.ihe.net/uploadedFiles/Documents/Pharmacy/IHE_Pharmacy_Suppl_PRE.pdf">IHE
 * Pharmacy Technical Framework Supplement – Pharmacy Prescription (PRE)</a>.
 */
@XmlRootElement(name = "ClinicalDocument", namespace = "urn:hl7-org:v3")
public class MedicationPrescriptionDocument
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

	public MedicationPrescriptionDocument() {
		super.setTypeId(createHl7TypeIdFixedValue("2.16.840.1.113883.1.3", "POCD_HD000040"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.127.1.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.1"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.1.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.1.1"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.1"));
	}

	/**
	 * Adds a hl7Authenticator Information about an authenticator of a CDA
	 * document. An authenticator MUST be a person.
	 */
	public void addHl7Authenticator(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Authenticator value) {
		getAuthenticator().add(value);
	}

	/**
	 * Adds a hl7Author Information about the author of a CDA document, section
	 * or entry. An author MAY be a person or a device.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7DocumentationOf Information about a health service describing
	 * the context of this CDA document.
	 */
	public void addHl7DocumentationOf(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf value) {
		getDocumentationOf().add(value);
	}

	/**
	 * Adds a hl7InFulfillmentOf Reference to one or more orders which led to
	 * the creation of this CDA document. It SHALL be declared, when the order
	 * reference is relevant for some reason.
	 */
	public void addHl7InFulfillmentOf(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040InFulfillmentOf value) {
		getInFulfillmentOf().add(value);
	}

	/**
	 * Adds a hl7Informant
	 */
	public void addHl7Informant(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Informant12 value) {
		getInformant().add(value);
	}

	/**
	 * Adds a hl7InformationRecipient A recipient of this CDA document
	 * (corresponds to the addressee of a letter - person or
	 * organization).Recipient types: - The main recipient of the document is
	 * indicated by typeCode 'PRCP' (primary recipient).Note: Since it makes no
	 * sense to create a CDA document without doing it for someone, in
	 * Switzerland at least one recipient MUST be declared. If the document is
	 * created for the user's own needs, the user itself or its organization
	 * will be the primary recipient. - Other recipients (copy to; Cc) are
	 * indicated with typeCode, TRC '(secondary recipient).
	 */
	public void addHl7InformationRecipient(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040InformationRecipient value) {
		getInformationRecipient().add(value);
	}

	/**
	 * Adds a hl7Participant Information on a patient contact.
	 */
	public void addHl7Participant(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1 value) {
		getParticipant().add(value);
	}

	/**
	 * Adds a hl7Authenticator Information about an authenticator of a CDA
	 * document. An authenticator MUST be a person.
	 */
	public void clearHl7Authenticator() {
		getAuthenticator().clear();
	}

	/**
	 * Adds a hl7Author Information about the author of a CDA document, section
	 * or entry. An author MAY be a person or a device.
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Adds a hl7DocumentationOf Information about a health service describing
	 * the context of this CDA document.
	 */
	public void clearHl7DocumentationOf() {
		getDocumentationOf().clear();
	}

	/**
	 * Adds a hl7InFulfillmentOf Reference to one or more orders which led to
	 * the creation of this CDA document. It SHALL be declared, when the order
	 * reference is relevant for some reason.
	 */
	public void clearHl7InFulfillmentOf() {
		getInFulfillmentOf().clear();
	}

	/**
	 * Adds a hl7Informant
	 */
	public void clearHl7Informant() {
		getInformant().clear();
	}

	/**
	 * Adds a hl7InformationRecipient A recipient of this CDA document
	 * (corresponds to the addressee of a letter - person or
	 * organization).Recipient types: - The main recipient of the document is
	 * indicated by typeCode 'PRCP' (primary recipient).Note: Since it makes no
	 * sense to create a CDA document without doing it for someone, in
	 * Switzerland at least one recipient MUST be declared. If the document is
	 * created for the user's own needs, the user itself or its organization
	 * will be the primary recipient. - Other recipients (copy to; Cc) are
	 * indicated with typeCode, TRC '(secondary recipient).
	 */
	public void clearHl7InformationRecipient() {
		getInformationRecipient().clear();
	}

	/**
	 * Adds a hl7Participant Information on a patient contact.
	 */
	public void clearHl7Participant() {
		getParticipant().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TypeId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 * @param extension
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId createHl7TypeIdFixedValue(
			String root, String extension) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId retVal = factory
				.createPOCDMT000040InfrastructureRootTypeId();
		retVal.setRoot(root);
		retVal.setExtension(extension);
		return retVal;
	}

	/**
	 * Gets the hl7Code IHE PHARM PRE document code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7Component
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Component2 getHl7Component() {
		return component;
	}

	/**
	 * Gets the hl7ConfidentialityCode Swiss Realm of Confidentiality Code
	 * according to the Swiss EPR regulation.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7ConfidentialityCode() {
		return confidentialityCode;
	}

	/**
	 * Gets the hl7Custodian The organization in whose name this CDA document
	 * has been created (corresponds to the sender of a letter).
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian getHl7Custodian() {
		return custodian;
	}

	/**
	 * Gets the hl7DataEnterer Information about the person that entered
	 * information in this CDA document. It SHALL be declared, when data
	 * recorded in this document has been entered by a person other than the
	 * author but only when this is relevant for some reason.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040DataEnterer getHl7DataEnterer() {
		return dataEnterer;
	}

	/**
	 * Gets the hl7EffectiveTime The document's creation date and time. If this
	 * document replaces a previous version (linked via parentDocument), this is
	 * the date and time of the new version.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7Id A unique identifier for each CDA document instance.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7LanguageCode The RFC 1766 (ISO-639-1 and ISO 3166) based
	 * language in which the narrative texts in this CDA document instance are
	 * written.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7LanguageCode() {
		return languageCode;
	}

	/**
	 * Gets the hl7LegalAuthenticator Information about the legal authenticator
	 * of a CDA document. A legal authenticator MUST be a person.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator getHl7LegalAuthenticator() {
		return legalAuthenticator;
	}

	/**
	 * Gets the hl7RealmCode Swiss Realm (CHE) of HL7 CDA.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.CS> getHl7RealmCode() {
		return realmCode;
	}

	/**
	 * Gets the hl7RecordTarget A human patient for whom this CDA document
	 * instance was created. - Target patientThe HL7 CDA R2 (2005) standard
	 * allows multiple patients.In order to ensure that the information in a CDA
	 * document is unambiguously assigned to one and only patient, a CDA-CH V2
	 * based document MUST contain exactly one patient.Special cases: In
	 * exceptional cases (e.g., new-born twins, both having jaundice), multiple
	 * documents MUST be created (all of the same content, but each with a
	 * unique patient). - Patient identifiersMultiple ids (patient
	 * identification number) MAY be declared.If multiple ids are known, it is
	 * highly recommended to declare all known ids. Especially in cases where
	 * the CDA document instance is kind of an answer to a preceding order
	 * (independent of its data format), all ids specified by the ordering
	 * system SHALL be declared in the CDA document instance. This allows the
	 * receiver to assign its internal patient identification.The patient
	 * identification number MUST be grouped with the OID of its assigning
	 * system. The patient identification number MUST be unique within the
	 * system identified by the OID.The declared OID MUST be found in one of the
	 * public OID registries, such as oid.refdata.ch (preferred), oid-info.com,
	 * hl7.org/oid, www.dimdi.de/static/de/klassi/oid/,
	 * gesundheit.gv.at/OID_Frontend/ etc.OIDs that can't be found in a public
	 * OID registry are NOT ALLOWED. - PseudonymizingIn special cases, the
	 * demographic data of the patient are not allowed to be transmitted or they
	 * have to be pseudonymized.While HL7 CDA or its derivatives like CDA-CH or
	 * Swiss exchange formats nevertheless require these elements in the XML
	 * structure, the affected values MUST be replaced by a nullFlavor of type
	 * "MSK" (masked), in order to support the required data format structure
	 * and simultaneously to shield the real data.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget> getHl7RecordTarget() {
		return recordTarget;
	}

	/**
	 * Gets the hl7SetId The setId element MUST match the document id of the
	 * very first version of that document. It MUST remain the same for all
	 * document versions.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7SetId() {
		return setId;
	}

	/**
	 * Gets the hl7TemplateId Exchange format according to the Swiss EPR
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Title
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return title;
	}

	/**
	 * Gets the hl7TypeId HL7 CDA R2, 2005
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId getHl7TypeId() {
		return typeId;
	}

	/**
	 * Gets the hl7VersionNumber The versionNumber element MUST contain the
	 * value 1 for the very first version of that document. For later versions,
	 * the version number MUST be increased by 1 each.
	 */
	public org.ehealth_connector.common.hl7cdar2.INT getHl7VersionNumber() {
		return versionNumber;
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.II, filled by:
	 * "2.16.756.5.30.1.1.1.1.4"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.II getPredefinedTemplateId21675653011114() {
		return createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.4");
	}

	/**
	 * Sets the version number to 1 and makes sure the setId is the same as the
	 * document id.
	 * 
	 * @param newDocId
	 *            the new doc id
	 */
	public void initFirstVersion(Identificator newDocId) {
		Identificator docId = newDocId;
		if (docId == null)
			docId = new Identificator(Identificator.builder()
					.withRoot(org.openhealthtools.ihe.utils.UUID.generate()).build());
		super.setId(docId.getHl7CdaR2Ii());
		setVersion(docId, 1);
	}

	/**
	 * Increases the version number by one and makes sure the setId remains the
	 * same as previously.
	 * 
	 * @param newDocId
	 *            the new doc id
	 */
	public void initNextVersion(Identificator newDocId) {
		org.ehealth_connector.common.hl7cdar2.II setId = getSetId();
		if (setId == null)
			setId = getId();
		if (setId == null)
			setId = newDocId.getHl7CdaR2Ii();
		Integer version = CdaUtil.getInt(getVersionNumber());
		setId(newDocId.getHl7CdaR2Ii());
		setVersion(new Identificator(setId), version + 1);
	}

	/**
	 * Loads the CDA document from file.
	 * 
	 * @param inputFileName
	 *            the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException the JAXB
	 *         exception\n@throws IOException Signals that an I/O exception has
	 *         occurred.
	 */
	public static MedicationPrescriptionDocument loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * 
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException the JAXB exception\n@throws IOException Signals
	 *            that an I/O exception has occurred.
	 */
	public static MedicationPrescriptionDocument loadFromFile(File inputFile)
			throws JAXBException, IOException {
		MedicationPrescriptionDocument retVal;
		JAXBContext context = JAXBContext.newInstance(MedicationPrescriptionDocument.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<MedicationPrescriptionDocument> root = mar.unmarshal(source,
				MedicationPrescriptionDocument.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Saves the current CDA document to file.
	 * 
	 * @param outputFileName
	 *            the full path and filename of the destination file.
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public void saveToFile(String outputFileName) throws JAXBException,
			ParserConfigurationException, TransformerException, FileNotFoundException {
		saveToFile(new File(outputFileName), null, null);
	}

	/**
	 * Saves the current CDA document to file.
	 * 
	 * @param outputFile
	 *            the destination file.
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public void saveToFile(File outputFile) throws JAXBException, ParserConfigurationException,
			TransformerException, FileNotFoundException {
		saveToFile(outputFile, null, null);
	}

	/**
	 * Saves the current CDA document to file.
	 * 
	 * @param outputFileName
	 *            the full path and filename of the destination file.
	 * @param xsl
	 *            the path and filename or url to the rendering stylesheet
	 * @param css
	 *            the path and filename or url to the rendering css
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception\n@throws FileNotFoundException the
	 *             file not found exception
	 */
	public void saveToFile(String outputFileName, String xsl, String css) throws JAXBException,
			ParserConfigurationException, TransformerException, FileNotFoundException {
		saveToFile(new File(outputFileName), xsl, css);
	}

	/**
	 * Saves the current CDA document to file.
	 * 
	 * @param outputFile
	 *            the destination file.
	 * @param xsl
	 *            the path and filename or url to the rendering stylesheet
	 * @param css
	 *            the path and filename or url to the rendering css
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception\n@throws FileNotFoundException the
	 *             file not found exception
	 */
	public void saveToFile(File outputFile, String xsl, String css) throws JAXBException,
			ParserConfigurationException, TransformerException, FileNotFoundException {
		CdaUtil.saveJaxbObjectToFile(this, outputFile, xsl, css);
	}

	/**
	 * Sets the hl7Code IHE PHARM PRE document code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Component
	 */
	public void setHl7Component(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Component2 value) {
		this.component = value;
	}

	/**
	 * Sets the hl7ConfidentialityCode Swiss Realm of Confidentiality Code
	 * according to the Swiss EPR regulation.
	 */
	public void setHl7ConfidentialityCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.confidentialityCode = value;
	}

	/**
	 * Sets the hl7Custodian The organization in whose name this CDA document
	 * has been created (corresponds to the sender of a letter).
	 */
	public void setHl7Custodian(org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian value) {
		this.custodian = value;
	}

	/**
	 * Sets the hl7DataEnterer Information about the person that entered
	 * information in this CDA document. It SHALL be declared, when data
	 * recorded in this document has been entered by a person other than the
	 * author but only when this is relevant for some reason.
	 */
	public void setHl7DataEnterer(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040DataEnterer value) {
		this.dataEnterer = value;
	}

	/**
	 * Sets the hl7EffectiveTime The document's creation date and time. If this
	 * document replaces a previous version (linked via parentDocument), this is
	 * the date and time of the new version.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7Id A unique identifier for each CDA document instance.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		this.id = value;
	}

	/**
	 * Sets the hl7LanguageCode The RFC 1766 (ISO-639-1 and ISO 3166) based
	 * language in which the narrative texts in this CDA document instance are
	 * written.
	 */
	public void setHl7LanguageCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		this.languageCode = value;
	}

	/**
	 * Sets the hl7LegalAuthenticator Information about the legal authenticator
	 * of a CDA document. A legal authenticator MUST be a person.
	 */
	public void setHl7LegalAuthenticator(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator value) {
		this.legalAuthenticator = value;
	}

	/**
	 * Sets the hl7RealmCode Swiss Realm (CHE) of HL7 CDA.
	 */
	public void setHl7RealmCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		getRealmCode().clear();
		getRealmCode().add(value);
	}

	/**
	 * Sets the hl7RecordTarget A human patient for whom this CDA document
	 * instance was created. - Target patientThe HL7 CDA R2 (2005) standard
	 * allows multiple patients.In order to ensure that the information in a CDA
	 * document is unambiguously assigned to one and only patient, a CDA-CH V2
	 * based document MUST contain exactly one patient.Special cases: In
	 * exceptional cases (e.g., new-born twins, both having jaundice), multiple
	 * documents MUST be created (all of the same content, but each with a
	 * unique patient). - Patient identifiersMultiple ids (patient
	 * identification number) MAY be declared.If multiple ids are known, it is
	 * highly recommended to declare all known ids. Especially in cases where
	 * the CDA document instance is kind of an answer to a preceding order
	 * (independent of its data format), all ids specified by the ordering
	 * system SHALL be declared in the CDA document instance. This allows the
	 * receiver to assign its internal patient identification.The patient
	 * identification number MUST be grouped with the OID of its assigning
	 * system. The patient identification number MUST be unique within the
	 * system identified by the OID.The declared OID MUST be found in one of the
	 * public OID registries, such as oid.refdata.ch (preferred), oid-info.com,
	 * hl7.org/oid, www.dimdi.de/static/de/klassi/oid/,
	 * gesundheit.gv.at/OID_Frontend/ etc.OIDs that can't be found in a public
	 * OID registry are NOT ALLOWED. - PseudonymizingIn special cases, the
	 * demographic data of the patient are not allowed to be transmitted or they
	 * have to be pseudonymized.While HL7 CDA or its derivatives like CDA-CH or
	 * Swiss exchange formats nevertheless require these elements in the XML
	 * structure, the affected values MUST be replaced by a nullFlavor of type
	 * "MSK" (masked), in order to support the required data format structure
	 * and simultaneously to shield the real data.
	 */
	public void setHl7RecordTarget(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget value) {
		getRecordTarget().clear();
		getRecordTarget().add(value);
	}

	/**
	 * Sets the hl7SetId The setId element MUST match the document id of the
	 * very first version of that document. It MUST remain the same for all
	 * document versions.
	 */
	public void setHl7SetId(org.ehealth_connector.common.hl7cdar2.II value) {
		this.setId = value;
	}

	/**
	 * Sets the hl7TemplateId Exchange format according to the Swiss EPR
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Title
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		this.title = value;
	}

	/**
	 * Sets the hl7TypeId HL7 CDA R2, 2005
	 */
	public void setHl7TypeId(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId value) {
		this.typeId = value;
	}

	/**
	 * Sets the hl7VersionNumber The versionNumber element MUST contain the
	 * value 1 for the very first version of that document. For later versions,
	 * the version number MUST be increased by 1 each.
	 */
	public void setHl7VersionNumber(org.ehealth_connector.common.hl7cdar2.INT value) {
		this.versionNumber = value;
	}

	/**
	 * <div class="en">Sets the document set Id and version number.</div>
	 *
	 * <div class="de">Weist dem Dokument eine Set Id und eine Versionsnummer
	 * zu.</div>
	 * 
	 * @param idVersion1
	 *            the set Id (if null, the document ID will be used)
	 * @param version
	 *            the version of the document
	 */
	public void setVersion(Identificator idVersion1, int version) {
		super.setSetId(idVersion1.getHl7CdaR2Ii());
		super.setVersionNumber(Hl7CdaR2Util.createHl7CdaR2Int(version));
	}
}
