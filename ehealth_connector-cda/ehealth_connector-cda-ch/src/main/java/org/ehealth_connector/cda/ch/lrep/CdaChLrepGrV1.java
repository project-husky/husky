/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.1.10
 * Template description: Swiss Laboratory Report - General Report
 *
 * Element description: Swiss Laboratory Report - General ReportConformity rules that are not further modelled in ART-DECOR:
 * - XML encodingUTF-8 encoding is required. All CDA-CH V2 documents MUST start with this line:&lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * - Phone numbersPhone numbers MUST be declared in the international format.Dots (.) MUST be used as separators for grouping of number blocks.The minus sign (-) MUST be used as a separator between public and internal telephone numbers. Purpose: Some telephone exchanges - especially in the US, allow direct dial-up of an internal telephone number after the actual connection has been established over the public telephone network.Examples:&lt;telecom value="tel:+41.33.123.45.67"/&gt;&lt;telecom value="tel:+1.987.654.3210-999"/&gt;
 */
@XmlRootElement(name = "hl7:ClinicalDocument")
public class CdaChLrepGrV1 extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

	/**
	 * Information about an authenticator of a CDA document. An authenticator MUST be a person.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Authenticator> hl7Authenticator;

	/**
	 * Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author> hl7Author;

	/**
	 * A LOINC based document type of a CDA document instance including a translation to the Swiss EPR XDS.b metadata.
	 * - Multidisciplinary laboratory findings:The LOINC code of the document MUST read: 11502-2 (LABORATORY REPORT.TOTAL)
	 * - Laboratory reports of a single laboratory discipline:The LOINC code of the document MUST be taken from the value-set 'Laboratory Specialties'
	 */
	private org.ehealth_connector.common.hl7cdar2.CE hl7Code;

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Component2 hl7Component;

	/**
	 * Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.
	 */
	private org.ehealth_connector.common.hl7cdar2.CE hl7ConfidentialityCode;

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian hl7Custodian;

	/**
	 * Information about the person that entered information in this CDA document. It SHALL be declared, when data recorded in this document has been entered by a person other than the author but only when this is relevant for some reason.
	 */
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040DataEnterer hl7DataEnterer;

	/**
	 * Information about a health service describing the context of this CDA document.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf> hl7DocumentationOf;

	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf> hl7DocumentationOf1;

	/**
	 * Human Patient with Non-Human Subject: The laboratory report contains test results from samples taken from a non-human material that is related to a human patient (e.g., food eaten by the patient or animal that has bitten the patient).
	 */
	private org.ehealth_connector.common.hl7cdar2.TS hl7EffectiveTime;

	/**
	 * A unique identifier for each CDA document instance.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	/**
	 * Reference to one or more orders which led to the creation of this CDA document. It SHALL be declared, when the order reference is relevant for some reason.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040InFulfillmentOf> hl7InFulfillmentOf;

	/**
	 * The laboratory report MUST contain at least one receiver.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040InformationRecipient> hl7InformationRecipient;

	/**
	 * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the narrative texts in this CDA document instance are written.
	 */
	private org.ehealth_connector.common.hl7cdar2.CS hl7LanguageCode;

	/**
	 * Legal authenticator.
	 */
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator hl7LegalAuthenticator;

	/**
	 * Information on a patient's insurance card.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1> hl7Participant;

	/**
	 * Information on a patient's insurance.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1> hl7Participant1;

	/**
	 * Swiss Realm (CHE) of HL7 CDA.
	 */
	private org.ehealth_connector.common.hl7cdar2.CS hl7RealmCode;

	/**
	 * Patient (Human Patient).
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget> hl7RecordTarget;

	/**
	 * Non-Human Subject.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget> hl7RecordTarget1;

	/**
	 * Human Patient with Non-Human Subject.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget> hl7RecordTarget2;

	/**
	 * Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
	 * - Values that were only contained in the previous document have to be treated as deleted.
	 * - Values that are present in both documents are overwritten with the contents of the new document.
	 * - Values that are only contained in the new document are to be added.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedDocument> hl7RelatedDocument;

	/**
	 * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7SetId;

	/**
	 * CDA-CH v2.0 specification. This is an informational reference, only.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	/**
	 * HL7 CDA R2 (2005); contains ClinicalDocument.component as structuredBody.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	/**
	 * HL7 CDA R2 (2005).
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId2;

	/**
	 * CDA-CH-LREP / Laboratory Reports V1 specification. This is an informational reference, only.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId3;

	/**
	 * Exchange format according to the Swiss EPR
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId4;

	/**
	 * Sharing Laboratory Reports (XD-LAB) Content Module, IHE PaLM Technical Framework Revision Revision 8.0 - June 21, 2017.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId5;

	/**
	 * CDA-CH-LREP / Laboratory Reports V1 ART-DECOR model for General Report.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId6;

	/**
	 * The document title must follow the following text format where &lt;human readable code&gt; is the local translation of the document LOINC code:
	 * - [de]: 'Laborbefund - &lt;human readable code&gt;'
	 * - [fr]: 'Rapport de laboratoire - &lt;human readable code&gt;'
	 * - [it]: 'Referto di laboratorio - &lt;human readable code&gt;'
	 * - [en]: 'Laboratory report - &lt;human readable code&gt;'
	 */
	private org.ehealth_connector.common.hl7cdar2.ST hl7Title;

	private org.ehealth_connector.common.hl7cdar2.II hl7TypeId;

	/**
	 * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
	 */
	private org.ehealth_connector.common.hl7cdar2.INT hl7VersionNumber;

	/**
	 * Adds a hl7Authenticator
	 * Information about an authenticator of a CDA document. An authenticator MUST be a person.
	 */
	public void addHl7Authenticator(org.ehealth_connector.common.hl7cdar2.POCDMT000040Authenticator value) {
		if (hl7Authenticator == null)
			hl7Authenticator = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Authenticator>();
		hl7Authenticator.add(value);
	}

	/**
	 * Adds a hl7Author
	 * Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		if (hl7Author == null)
			hl7Author = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author>();
		hl7Author.add(value);
	}

	/**
	 * Adds a hl7DocumentationOf
	 * Information about a health service describing the context of this CDA document.
	 */
	public void addHl7DocumentationOf(org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf value) {
		if (hl7DocumentationOf == null)
			hl7DocumentationOf = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf>();
		hl7DocumentationOf.add(value);
	}

	/**
	 * Adds a hl7DocumentationOf1
	 */
	public void addHl7DocumentationOf1(org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf value) {
		if (hl7DocumentationOf1 == null)
			hl7DocumentationOf1 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf>();
		hl7DocumentationOf1.add(value);
	}

	/**
	 * Adds a hl7InFulfillmentOf
	 * Reference to one or more orders which led to the creation of this CDA document. It SHALL be declared, when the order reference is relevant for some reason.
	 */
	public void addHl7InFulfillmentOf(org.ehealth_connector.common.hl7cdar2.POCDMT000040InFulfillmentOf value) {
		if (hl7InFulfillmentOf == null)
			hl7InFulfillmentOf = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040InFulfillmentOf>();
		hl7InFulfillmentOf.add(value);
	}

	/**
	 * Adds a hl7InformationRecipient
	 * The laboratory report MUST contain at least one receiver.
	 */
	public void addHl7InformationRecipient(org.ehealth_connector.common.hl7cdar2.POCDMT000040InformationRecipient value) {
		if (hl7InformationRecipient == null)
			hl7InformationRecipient = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040InformationRecipient>();
		hl7InformationRecipient.add(value);
	}

	/**
	 * Adds a hl7Participant
	 * Information on a patient's insurance card.
	 */
	public void addHl7Participant(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1 value) {
		if (hl7Participant == null)
			hl7Participant = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1>();
		hl7Participant.add(value);
	}

	/**
	 * Adds a hl7Participant1
	 * Information on a patient's insurance.
	 */
	public void addHl7Participant1(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1 value) {
		if (hl7Participant1 == null)
			hl7Participant1 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1>();
		hl7Participant1.add(value);
	}

	/**
	 * Adds a hl7RecordTarget
	 * Patient (Human Patient).
	 */
	public void addHl7RecordTarget(org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget value) {
		if (hl7RecordTarget == null)
			hl7RecordTarget = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget>();
		hl7RecordTarget.add(value);
	}

	/**
	 * Adds a hl7RecordTarget1
	 * Non-Human Subject.
	 */
	public void addHl7RecordTarget1(org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget value) {
		if (hl7RecordTarget1 == null)
			hl7RecordTarget1 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget>();
		hl7RecordTarget1.add(value);
	}

	/**
	 * Adds a hl7RecordTarget2
	 * Human Patient with Non-Human Subject.
	 */
	public void addHl7RecordTarget2(org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget value) {
		if (hl7RecordTarget2 == null)
			hl7RecordTarget2 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget>();
		hl7RecordTarget2.add(value);
	}

	/**
	 * Adds a hl7RelatedDocument
	 * Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
	 * - Values that were only contained in the previous document have to be treated as deleted.
	 * - Values that are present in both documents are overwritten with the contents of the new document.
	 * - Values that are only contained in the new document are to be added.
	 */
	public void addHl7RelatedDocument(org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedDocument value) {
		if (hl7RelatedDocument == null)
			hl7RelatedDocument = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedDocument>();
		hl7RelatedDocument.add(value);
	}

	/**
	 * Adds a hl7Authenticator
	 * Information about an authenticator of a CDA document. An authenticator MUST be a person.
	 */
	public void clearHl7Authenticator() {
		hl7Authenticator.clear();
	}

	/**
	 * Adds a hl7Author
	 * Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
	 */
	public void clearHl7Author() {
		hl7Author.clear();
	}

	/**
	 * Adds a hl7DocumentationOf
	 * Information about a health service describing the context of this CDA document.
	 */
	public void clearHl7DocumentationOf() {
		hl7DocumentationOf.clear();
	}

	/**
	 * Adds a hl7DocumentationOf1
	 */
	public void clearHl7DocumentationOf1() {
		hl7DocumentationOf1.clear();
	}

	/**
	 * Adds a hl7InFulfillmentOf
	 * Reference to one or more orders which led to the creation of this CDA document. It SHALL be declared, when the order reference is relevant for some reason.
	 */
	public void clearHl7InFulfillmentOf() {
		hl7InFulfillmentOf.clear();
	}

	/**
	 * Adds a hl7InformationRecipient
	 * The laboratory report MUST contain at least one receiver.
	 */
	public void clearHl7InformationRecipient() {
		hl7InformationRecipient.clear();
	}

	/**
	 * Adds a hl7Participant
	 * Information on a patient's insurance card.
	 */
	public void clearHl7Participant() {
		hl7Participant.clear();
	}

	/**
	 * Adds a hl7Participant1
	 * Information on a patient's insurance.
	 */
	public void clearHl7Participant1() {
		hl7Participant1.clear();
	}

	/**
	 * Adds a hl7RecordTarget
	 * Patient (Human Patient).
	 */
	public void clearHl7RecordTarget() {
		hl7RecordTarget.clear();
	}

	/**
	 * Adds a hl7RecordTarget1
	 * Non-Human Subject.
	 */
	public void clearHl7RecordTarget1() {
		hl7RecordTarget1.clear();
	}

	/**
	 * Adds a hl7RecordTarget2
	 * Human Patient with Non-Human Subject.
	 */
	public void clearHl7RecordTarget2() {
		hl7RecordTarget2.clear();
	}

	/**
	 * Adds a hl7RelatedDocument
	 * Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
	 * - Values that were only contained in the previous document have to be treated as deleted.
	 * - Values that are present in both documents are overwritten with the contents of the new document.
	 * - Values that are only contained in the new document are to be added.
	 */
	public void clearHl7RelatedDocument() {
		hl7RelatedDocument.clear();
	}

	/**
	 * Gets the hl7Code
	 * A LOINC based document type of a CDA document instance including a translation to the Swiss EPR XDS.b metadata.
	 * - Multidisciplinary laboratory findings:The LOINC code of the document MUST read: 11502-2 (LABORATORY REPORT.TOTAL)
	 * - Laboratory reports of a single laboratory discipline:The LOINC code of the document MUST be taken from the value-set 'Laboratory Specialties'
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7Component
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Component2 getHl7Component() {
		return hl7Component;
	}

	/**
	 * Gets the hl7ConfidentialityCode
	 * Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7ConfidentialityCode() {
		return hl7ConfidentialityCode;
	}

	/**
	 * Gets the hl7Custodian
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian getHl7Custodian() {
		return hl7Custodian;
	}

	/**
	 * Gets the hl7DataEnterer
	 * Information about the person that entered information in this CDA document. It SHALL be declared, when data recorded in this document has been entered by a person other than the author but only when this is relevant for some reason.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040DataEnterer getHl7DataEnterer() {
		return hl7DataEnterer;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Human Patient with Non-Human Subject: The laboratory report contains test results from samples taken from a non-human material that is related to a human patient (e.g., food eaten by the patient or animal that has bitten the patient).
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7EffectiveTime() {
		return hl7EffectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * A unique identifier for each CDA document instance.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return hl7Id;
	}

	/**
	 * Gets the hl7LanguageCode
	 * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the narrative texts in this CDA document instance are written.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7LanguageCode() {
		return hl7LanguageCode;
	}

	/**
	 * Gets the hl7LegalAuthenticator
	 * Legal authenticator.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator getHl7LegalAuthenticator() {
		return hl7LegalAuthenticator;
	}

	/**
	 * Gets the hl7RealmCode
	 * Swiss Realm (CHE) of HL7 CDA.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7RealmCode() {
		return hl7RealmCode;
	}

	/**
	 * Gets the hl7SetId
	 * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7SetId() {
		return hl7SetId;
	}

	/**
	 * Gets the hl7TemplateId
	 * CDA-CH v2.0 specification. This is an informational reference, only.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		return hl7TemplateId;
	}

	/**
	 * Gets the hl7TemplateId1
	 * HL7 CDA R2 (2005); contains ClinicalDocument.component as structuredBody.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId1() {
		return hl7TemplateId1;
	}

	/**
	 * Gets the hl7TemplateId2
	 * HL7 CDA R2 (2005).
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId2() {
		return hl7TemplateId2;
	}

	/**
	 * Gets the hl7TemplateId3
	 * CDA-CH-LREP / Laboratory Reports V1 specification. This is an informational reference, only.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId3() {
		return hl7TemplateId3;
	}

	/**
	 * Gets the hl7TemplateId4
	 * Exchange format according to the Swiss EPR
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId4() {
		return hl7TemplateId4;
	}

	/**
	 * Gets the hl7TemplateId5
	 * Sharing Laboratory Reports (XD-LAB) Content Module, IHE PaLM Technical Framework Revision Revision 8.0 - June 21, 2017.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId5() {
		return hl7TemplateId5;
	}

	/**
	 * Gets the hl7TemplateId6
	 * CDA-CH-LREP / Laboratory Reports V1 ART-DECOR model for General Report.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId6() {
		return hl7TemplateId6;
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
		return hl7Title;
	}

	/**
	 * Gets the hl7TypeId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TypeId() {
		return hl7TypeId;
	}

	/**
	 * Gets the hl7VersionNumber
	 * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
	 */
	public org.ehealth_connector.common.hl7cdar2.INT getHl7VersionNumber() {
		return hl7VersionNumber;
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
		hl7Code = value;
	}

	/**
	 * Sets the hl7Component
	 */
	public void setHl7Component(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component2 value) {
		hl7Component = value;
	}

	/**
	 * Sets the hl7ConfidentialityCode
	 * Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.
	 */
	public void setHl7ConfidentialityCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		hl7ConfidentialityCode = value;
	}

	/**
	 * Sets the hl7Custodian
	 */
	public void setHl7Custodian(org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian value) {
		hl7Custodian = value;
	}

	/**
	 * Sets the hl7DataEnterer
	 * Information about the person that entered information in this CDA document. It SHALL be declared, when data recorded in this document has been entered by a person other than the author but only when this is relevant for some reason.
	 */
	public void setHl7DataEnterer(org.ehealth_connector.common.hl7cdar2.POCDMT000040DataEnterer value) {
		hl7DataEnterer = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Human Patient with Non-Human Subject: The laboratory report contains test results from samples taken from a non-human material that is related to a human patient (e.g., food eaten by the patient or animal that has bitten the patient).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		hl7EffectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 * A unique identifier for each CDA document instance.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7Id = value;
	}

	/**
	 * Sets the hl7LanguageCode
	 * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the narrative texts in this CDA document instance are written.
	 */
	public void setHl7LanguageCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		hl7LanguageCode = value;
	}

	/**
	 * Sets the hl7LegalAuthenticator
	 * Legal authenticator.
	 */
	public void setHl7LegalAuthenticator(org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator value) {
		hl7LegalAuthenticator = value;
	}

	/**
	 * Sets the hl7RealmCode
	 * Swiss Realm (CHE) of HL7 CDA.
	 */
	public void setHl7RealmCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		hl7RealmCode = value;
	}

	/**
	 * Sets the hl7SetId
	 * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
	 */
	public void setHl7SetId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7SetId = value;
	}

	/**
	 * Sets the hl7TemplateId
	 * CDA-CH v2.0 specification. This is an informational reference, only.
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId = value;
	}

	/**
	 * Sets the hl7TemplateId1
	 * HL7 CDA R2 (2005); contains ClinicalDocument.component as structuredBody.
	 */
	public void setHl7TemplateId1(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId1 = value;
	}

	/**
	 * Sets the hl7TemplateId2
	 * HL7 CDA R2 (2005).
	 */
	public void setHl7TemplateId2(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId2 = value;
	}

	/**
	 * Sets the hl7TemplateId3
	 * CDA-CH-LREP / Laboratory Reports V1 specification. This is an informational reference, only.
	 */
	public void setHl7TemplateId3(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId3 = value;
	}

	/**
	 * Sets the hl7TemplateId4
	 * Exchange format according to the Swiss EPR
	 */
	public void setHl7TemplateId4(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId4 = value;
	}

	/**
	 * Sets the hl7TemplateId5
	 * Sharing Laboratory Reports (XD-LAB) Content Module, IHE PaLM Technical Framework Revision Revision 8.0 - June 21, 2017.
	 */
	public void setHl7TemplateId5(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId5 = value;
	}

	/**
	 * Sets the hl7TemplateId6
	 * CDA-CH-LREP / Laboratory Reports V1 ART-DECOR model for General Report.
	 */
	public void setHl7TemplateId6(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId6 = value;
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
		hl7Title = value;
	}

	/**
	 * Sets the hl7TypeId
	 */
	public void setHl7TypeId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TypeId = value;
	}

	/**
	 * Sets the hl7VersionNumber
	 * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
	 */
	public void setHl7VersionNumber(org.ehealth_connector.common.hl7cdar2.INT value) {
		hl7VersionNumber = value;
	}
}
