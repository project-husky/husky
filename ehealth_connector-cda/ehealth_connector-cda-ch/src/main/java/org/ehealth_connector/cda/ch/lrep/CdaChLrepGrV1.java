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
package org.ehealth_connector.cda.ch.lrep;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.XActRelationshipDocument;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.1.10
 * Template description: Swiss Laboratory Report - General Report
 *
 * Element description: Swiss Laboratory Report - General ReportConformity rules that are not further modelled in ART-DECOR:
 * - XML encodingUTF-8 encoding is required. All CDA-CH V2 documents MUST start with this line:&lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * - Phone numbersPhone numbers MUST be declared in the international format.Dots (.) MUST be used as separators for grouping of number blocks.The minus sign (-) MUST be used as a separator between public and internal telephone numbers. Purpose: Some telephone exchanges - especially in the US, allow direct dial-up of an internal telephone number after the actual connection has been established over the public telephone network.Examples:&lt;telecom value="tel:+41.33.123.45.67"/&gt;&lt;telecom value="tel:+1.987.654.3210-999"/&gt;
 */
@XmlRootElement(name = "ClinicalDocument", namespace = "urn:hl7-org:v3")
public class CdaChLrepGrV1 extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

	public CdaChLrepGrV1() {
		super.setTypeId(createHl7TypeIdFixedValue("2.16.840.1.113883.1.3", "POCD_HD000040"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.1"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.3.9.1"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.127.1.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.1.10"));
		codeFixedValue = createHl7CodeFixedValue("2.16.840.1.113883.6.1", "LOINC");
	}

	private org.ehealth_connector.common.hl7cdar2.CE codeFixedValue;

	/**
	 * Adds a hl7Authenticator
	 * Information about an authenticator of a CDA document. An authenticator MUST be a person.
	 */
	public void addHl7Authenticator(org.ehealth_connector.common.hl7cdar2.POCDMT000040Authenticator value) {
		getAuthenticator().add(value);
	}

	/**
	 * Adds a hl7Author
	 * Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7DocumentationOf
	 * Information about a health service describing the context of this CDA document.
	 */
	public void addHl7DocumentationOf(org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf value) {
		getDocumentationOf().add(value);
	}

	/**
	 * Adds a hl7InFulfillmentOf
	 * Reference to one or more orders which led to the creation of this CDA document. It SHALL be declared, when the order reference is relevant for some reason.
	 */
	public void addHl7InFulfillmentOf(org.ehealth_connector.common.hl7cdar2.POCDMT000040InFulfillmentOf value) {
		getInFulfillmentOf().add(value);
	}

	/**
	 * Adds a hl7InformationRecipient
	 * The laboratory report MUST contain at least one receiver.
	 */
	public void addHl7InformationRecipient(org.ehealth_connector.common.hl7cdar2.POCDMT000040InformationRecipient value) {
		getInformationRecipient().add(value);
	}

	/**
	 * Adds a hl7Participant
	 * Information on a patient's insurance card.
	 */
	public void addHl7Participant(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1 value) {
		getParticipant().add(value);
	}

	/**
	 * Adds a hl7RecordTarget
	 * Patient (Human Patient).
	 */
	public void addHl7RecordTarget(org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget value) {
		getRecordTarget().add(value);
	}

	/**
	 * Adds a hl7RelatedDocument
	 * Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
	 * - Values that were only contained in the previous document have to be treated as deleted.
	 * - Values that are present in both documents are overwritten with the contents of the new document.
	 * - Values that are only contained in the new document are to be added.
	 */
	public void addHl7RelatedDocument(org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedDocument value) {
		getRelatedDocument().add(value);
	}

	/**
	 * Adds a hl7Authenticator
	 * Information about an authenticator of a CDA document. An authenticator MUST be a person.
	 */
	public void clearHl7Authenticator() {
		getAuthenticator().clear();
	}

	/**
	 * Adds a hl7Author
	 * Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Adds a hl7DocumentationOf
	 * Information about a health service describing the context of this CDA document.
	 */
	public void clearHl7DocumentationOf() {
		getDocumentationOf().clear();
	}

	/**
	 * Adds a hl7InFulfillmentOf
	 * Reference to one or more orders which led to the creation of this CDA document. It SHALL be declared, when the order reference is relevant for some reason.
	 */
	public void clearHl7InFulfillmentOf() {
		getInFulfillmentOf().clear();
	}

	/**
	 * Adds a hl7InformationRecipient
	 * The laboratory report MUST contain at least one receiver.
	 */
	public void clearHl7InformationRecipient() {
		getInformationRecipient().clear();
	}

	/**
	 * Adds a hl7Participant
	 * Information on a patient's insurance card.
	 */
	public void clearHl7Participant() {
		getParticipant().clear();
	}

	/**
	 * Adds a hl7RecordTarget
	 * Patient (Human Patient).
	 */
	public void clearHl7RecordTarget() {
		getRecordTarget().clear();
	}

	/**
	 * Adds a hl7RelatedDocument
	 * Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
	 * - Values that were only contained in the previous document have to be treated as deleted.
	 * - Values that are present in both documents are overwritten with the contents of the new document.
	 * - Values that are only contained in the new document are to be added.
	 */
	public void clearHl7RelatedDocument() {
		getRelatedDocument().clear();
	}

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7CodeFixedValue(String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7ConfidentialityCode
	 *
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7ConfidentialityCodeFixedValue(String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7DocumentationOf
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf createHl7DocumentationOfFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf retVal = factory.createPOCDMT000040DocumentationOf();
		retVal.getTypeCode().add(typeCode);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7Participant
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1 createHl7ParticipantFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1 retVal = factory.createPOCDMT000040Participant1();
		retVal.getTypeCode().add(typeCode);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7RelatedDocument
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedDocument createHl7RelatedDocumentFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedDocument retVal = factory.createPOCDMT000040RelatedDocument();
		retVal.setTypeCode(XActRelationshipDocument.fromValue(typeCode));
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7TypeId
	 *
	 * @param root the desired fixed value for this argument.
	 * @param extension the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId createHl7TypeIdFixedValue(String root, String extension) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId retVal = factory.createPOCDMT000040InfrastructureRootTypeId();
		retVal.setRoot(root);
		retVal.setExtension(extension);
		return retVal;
	}

	/**
	 * Gets the member codeFixedValue
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getCodeFixedValue() {
		return codeFixedValue;
	}

	/**
	 * Gets the hl7Code
	 * A LOINC based document type of a CDA document instance including a translation to the Swiss EPR XDS.b metadata.
	 * - Multidisciplinary laboratory findings:The LOINC code of the document MUST read: 11502-2 (LABORATORY REPORT.TOTAL)
	 * - Laboratory reports of a single laboratory discipline:The LOINC code of the document MUST be taken from the value-set 'Laboratory Specialties'
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7Component
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Component2 getHl7Component() {
		return super.component;
	}

	/**
	 * Gets the hl7ConfidentialityCode
	 * Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7ConfidentialityCode() {
		return super.confidentialityCode;
	}

	/**
	 * Gets the hl7Custodian
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian getHl7Custodian() {
		return super.custodian;
	}

	/**
	 * Gets the hl7DataEnterer
	 * Information about the person that entered information in this CDA document. It SHALL be declared, when data recorded in this document has been entered by a person other than the author but only when this is relevant for some reason.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040DataEnterer getHl7DataEnterer() {
		return super.dataEnterer;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Human Patient with Non-Human Subject: The laboratory report contains test results from samples taken from a non-human material that is related to a human patient (e.g., food eaten by the patient or animal that has bitten the patient).
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7EffectiveTime() {
		return super.effectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * A unique identifier for each CDA document instance.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return super.id;
	}

	/**
	 * Gets the hl7LanguageCode
	 * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the narrative texts in this CDA document instance are written.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7LanguageCode() {
		return super.languageCode;
	}

	/**
	 * Gets the hl7LegalAuthenticator
	 * Legal authenticator.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator getHl7LegalAuthenticator() {
		return super.legalAuthenticator;
	}

	/**
	 * Gets the hl7RealmCode
	 * Swiss Realm (CHE) of HL7 CDA.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7RealmCode() {
		org.ehealth_connector.common.hl7cdar2.CS retVal = null;
		if (super.getRealmCode() != null)
			if (super.getRealmCode().size() > 0)
				retVal = super.getRealmCode().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7SetId
	 * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7SetId() {
		return super.setId;
	}

	/**
	 * Gets the hl7TemplateId
	 * CDA-CH v2.0 specification. This is an informational reference, only.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getTemplateId() != null)
			if (super.getTemplateId().size() > 0)
				retVal = super.getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Title
	 * The document title must follow the following text format where &lt;human readable code&gt; is the local translation of the document LOINC code:
	 * - [de]: 'Laborbefund - &lt;human readable code&gt;'
	 * - [fr]: 'Rapport de laboratoire - &lt;human readable code&gt;'
	 * - [it]: 'Referto di laboratorio - &lt;human readable code&gt;'
	 * - [en]: 'Laboratory report - &lt;human readable code&gt;'
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return super.title;
	}

	/**
	 * Gets the hl7TypeId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TypeId() {
		return super.typeId;
	}

	/**
	 * Gets the hl7VersionNumber
	 * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
	 */
	public org.ehealth_connector.common.hl7cdar2.INT getHl7VersionNumber() {
		return super.versionNumber;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdaChLrepGrV1 loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdaChLrepGrV1 loadFromFile(File inputFile) throws JAXBException, IOException {
		CdaChLrepGrV1 retVal;
		JAXBContext context = JAXBContext.newInstance(CdaChLrepGrV1.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdaChLrepGrV1> root = mar.unmarshal(source, CdaChLrepGrV1.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFileName the full path and filename of the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(String outputFileName) throws JAXBException {
		saveToFile(new File(outputFileName));
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFile the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(File outputFile) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(this.getClass());
		Marshaller mar = context.createMarshaller();
		mar.setProperty("com.sun.xml.bind.namespacePrefixMapper", new CdaNamespacePrefixMapper());
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(this, outputFile);
	}

	/**
	 * Sets the hl7Code
	 * A LOINC based document type of a CDA document instance including a translation to the Swiss EPR XDS.b metadata.
	 * - Multidisciplinary laboratory findings:The LOINC code of the document MUST read: 11502-2 (LABORATORY REPORT.TOTAL)
	 * - Laboratory reports of a single laboratory discipline:The LOINC code of the document MUST be taken from the value-set 'Laboratory Specialties'
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		super.code = value;
	}

	/**
	 * Sets the hl7Component
	 */
	public void setHl7Component(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component2 value) {
		super.component = value;
	}

	/**
	 * Sets the hl7ConfidentialityCode
	 * Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.
	 */
	public void setHl7ConfidentialityCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		super.confidentialityCode = value;
	}

	/**
	 * Sets the hl7Custodian
	 */
	public void setHl7Custodian(org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian value) {
		super.custodian = value;
	}

	/**
	 * Sets the hl7DataEnterer
	 * Information about the person that entered information in this CDA document. It SHALL be declared, when data recorded in this document has been entered by a person other than the author but only when this is relevant for some reason.
	 */
	public void setHl7DataEnterer(org.ehealth_connector.common.hl7cdar2.POCDMT000040DataEnterer value) {
		super.dataEnterer = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Human Patient with Non-Human Subject: The laboratory report contains test results from samples taken from a non-human material that is related to a human patient (e.g., food eaten by the patient or animal that has bitten the patient).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		super.effectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 * A unique identifier for each CDA document instance.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.id = value;
	}

	/**
	 * Sets the hl7LanguageCode
	 * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the narrative texts in this CDA document instance are written.
	 */
	public void setHl7LanguageCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.languageCode = value;
	}

	/**
	 * Sets the hl7LegalAuthenticator
	 * Legal authenticator.
	 */
	public void setHl7LegalAuthenticator(org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator value) {
		super.legalAuthenticator = value;
	}

	/**
	 * Sets the hl7RealmCode
	 * Swiss Realm (CHE) of HL7 CDA.
	 */
	public void setHl7RealmCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.getRealmCode().clear();
		super.getRealmCode().add(value);
	}

	/**
	 * Sets the hl7SetId
	 * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
	 */
	public void setHl7SetId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.setId = value;
	}

	/**
	 * Sets the hl7TemplateId
	 * CDA-CH v2.0 specification. This is an informational reference, only.
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Title
	 * The document title must follow the following text format where &lt;human readable code&gt; is the local translation of the document LOINC code:
	 * - [de]: 'Laborbefund - &lt;human readable code&gt;'
	 * - [fr]: 'Rapport de laboratoire - &lt;human readable code&gt;'
	 * - [it]: 'Referto di laboratorio - &lt;human readable code&gt;'
	 * - [en]: 'Laboratory report - &lt;human readable code&gt;'
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		super.title = value;
	}

	/**
	 * Sets the hl7TypeId
	 */
	public void setHl7TypeId(org.ehealth_connector.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId value) {
		super.typeId = value;
	}

	/**
	 * Sets the hl7VersionNumber
	 * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
	 */
	public void setHl7VersionNumber(org.ehealth_connector.common.hl7cdar2.INT value) {
		super.versionNumber = value;
	}
}
