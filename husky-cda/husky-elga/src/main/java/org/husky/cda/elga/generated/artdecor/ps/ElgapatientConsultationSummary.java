/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.generated.artdecor.ps;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.INT;
import org.husky.common.hl7cdar2.POCDMT000040Component2;
import org.husky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId;
import org.husky.common.model.Identificator;

/**
 * Original ART-DECOR template id: 1.2.40.0.34.11.13 Template description:
 * 
 */
@XmlRootElement(name = "ClinicalDocument", namespace = "urn:hl7-org:v3")
public class ElgapatientConsultationSummary
		extends org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument {

	public ElgapatientConsultationSummary() {
		/*
		 * super.setClassCode(
		 * org.husky.common.hl7cdar2.ActClinicalDocument.fromValue("DOCCLIN"));
		 */
		super.getMoodCode().add("EVN");
		super.getRealmCode().add(createHl7RealmCodeFixedValue("AT", null, null, null));
		super.setTypeId(createHl7TypeIdFixedValue("2.16.840.1.113883.1.3", "POCD_HD000040"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.22.1.1"));
		super.setCode(createHl7CodeFixedValue("34131-3", "2.16.840.1.113883.6.1", null, "Outpatient Progress note"));
		super.setConfidentialityCode(
				createHl7ConfidentialityCodeFixedValue("N", "2.16.840.1.113883.5.25", "HL7:Confidentiality", "normal"));
		super.setLanguageCode(createHl7LanguageCodeFixedValue("de-AT", null, null, null));
	}

	/**
	 * Adds a hl7DocumentationOf
	 */
	public void addHl7DocumentationOf(
			org.husky.common.hl7cdar2.POCDMT000040DocumentationOf value) {
		getDocumentationOf().add(value);
	}

	/**
	 * Adds a hl7DocumentationOf
	 */
	public void clearHl7DocumentationOf() {
		getDocumentationOf().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.CE createHl7CodeFixedValue(String code,
			String codeSystem, String codeSystemName, String displayName) {
		org.husky.common.hl7cdar2.CE retVal = new CE();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Component
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 * @param contextConductionInd
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.POCDMT000040Component2 createHl7ComponentFixedValue(
			String typeCode, String contextConductionInd) {
		org.husky.common.hl7cdar2.POCDMT000040Component2 retVal = new POCDMT000040Component2();
		retVal.setTypeCode(org.husky.common.hl7cdar2.ActRelationshipHasComponent
				.fromValue(typeCode));
		retVal.setContextConductionInd(Boolean.parseBoolean(contextConductionInd));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7ConfidentialityCode
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.CE createHl7ConfidentialityCodeFixedValue(
			String code, String codeSystem, String codeSystemName, String displayName) {
		org.husky.common.hl7cdar2.CE retVal = new CE();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7LanguageCode
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.CS createHl7LanguageCodeFixedValue(
			String code, String codeSystem, String codeSystemName, String displayName) {
		org.husky.common.hl7cdar2.CS retVal = new CS();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7RealmCode
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.CS createHl7RealmCodeFixedValue(
			String code, String codeSystem, String codeSystemName, String displayName) {
		org.husky.common.hl7cdar2.CS retVal = new CS();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		org.husky.common.hl7cdar2.II retVal = new II();
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
	private static org.husky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId createHl7TypeIdFixedValue(
			String root, String extension) {
		org.husky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId retVal = new POCDMT000040InfrastructureRootTypeId();
		retVal.setRoot(root);
		retVal.setExtension(extension);
		return retVal;
	}

	/**
	 * Gets the hl7Authenticator
	 */
	public java.util.List<org.husky.common.hl7cdar2.POCDMT000040Authenticator> getHl7Authenticator() {
		return authenticator;
	}

	/**
	 * Gets the hl7Author
	 */
	public java.util.List<org.husky.common.hl7cdar2.POCDMT000040Author> getHl7Author() {
		return author;
	}

	/**
	 * Gets the hl7Code
	 */
	public org.husky.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7Component
	 */
	public org.husky.common.hl7cdar2.POCDMT000040Component2 getHl7Component() {
		return component;
	}

	/**
	 * Gets the hl7ComponentOf
	 */
	public org.husky.common.hl7cdar2.POCDMT000040Component1 getHl7ComponentOf() {
		return componentOf;
	}

	/**
	 * Gets the hl7ConfidentialityCode
	 */
	public org.husky.common.hl7cdar2.CE getHl7ConfidentialityCode() {
		return confidentialityCode;
	}

	/**
	 * Gets the hl7Custodian
	 */
	public org.husky.common.hl7cdar2.POCDMT000040Custodian getHl7Custodian() {
		return custodian;
	}

	/**
	 * Gets the hl7DataEnterer
	 */
	public org.husky.common.hl7cdar2.POCDMT000040DataEnterer getHl7DataEnterer() {
		return dataEnterer;
	}

	/**
	 * Gets the hl7EffectiveTime
	 */
	public org.husky.common.hl7cdar2.TS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7Id
	 */
	public org.husky.common.hl7cdar2.II getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7InformationRecipient
	 */
	public java.util.List<org.husky.common.hl7cdar2.POCDMT000040InformationRecipient> getHl7InformationRecipient() {
		return informationRecipient;
	}

	/**
	 * Gets the hl7LanguageCode
	 */
	public org.husky.common.hl7cdar2.CS getHl7LanguageCode() {
		return languageCode;
	}

	/**
	 * Gets the hl7LegalAuthenticator
	 */
	public org.husky.common.hl7cdar2.POCDMT000040LegalAuthenticator getHl7LegalAuthenticator() {
		return legalAuthenticator;
	}

	/**
	 * Gets the hl7Participant
	 */
	public java.util.List<org.husky.common.hl7cdar2.POCDMT000040Participant1> getHl7Participant() {
		return participant;
	}

	/**
	 * Gets the hl7RealmCode
	 */
	public java.util.List<org.husky.common.hl7cdar2.CS> getHl7RealmCode() {
		return realmCode;
	}

	/**
	 * Gets the hl7RecordTarget
	 */
	public java.util.List<org.husky.common.hl7cdar2.POCDMT000040RecordTarget> getHl7RecordTarget() {
		return recordTarget;
	}

	/**
	 * Gets the hl7RelatedDocument
	 */
	public java.util.List<org.husky.common.hl7cdar2.POCDMT000040RelatedDocument> getHl7RelatedDocument() {
		return relatedDocument;
	}

	/**
	 * Gets the hl7SetId
	 */
	public org.husky.common.hl7cdar2.II getHl7SetId() {
		return setId;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Title
	 */
	public org.husky.common.hl7cdar2.ST getHl7Title() {
		return title;
	}

	/**
	 * Gets the hl7TypeId
	 */
	public org.husky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId getHl7TypeId() {
		return typeId;
	}

	/**
	 * Gets the hl7VersionNumber
	 */
	public org.husky.common.hl7cdar2.INT getHl7VersionNumber() {
		return versionNumber;
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
					.withRoot(UUID.randomUUID().toString()).build());
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
		org.husky.common.hl7cdar2.II setId = getSetId();
		if (setId == null)
			setId = getId();
		if (setId == null)
			setId = newDocId.getHl7CdaR2Ii();
		Integer version = getVersionNumber().getValue().intValue();
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
	public static ElgapatientConsultationSummary loadFromFile(String inputFileName)
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
	public static ElgapatientConsultationSummary loadFromFile(File inputFile)
			throws JAXBException, IOException {
		ElgapatientConsultationSummary retVal;
		JAXBContext context = JAXBContext.newInstance(ElgapatientConsultationSummary.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ElgapatientConsultationSummary> root = mar.unmarshal(source, ElgapatientConsultationSummary.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Sets the hl7Authenticator
	 */
	public void setHl7Authenticator(
			org.husky.common.hl7cdar2.POCDMT000040Authenticator value) {
		getAuthenticator().clear();
		getAuthenticator().add(value);
	}

	/**
	 * Sets the hl7Author
	 */
	public void setHl7Author(org.husky.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().clear();
		getAuthor().add(value);
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Component
	 */
	public void setHl7Component(
			org.husky.common.hl7cdar2.POCDMT000040Component2 value) {
		this.component = value;
	}

	/**
	 * Sets the hl7ComponentOf
	 */
	public void setHl7ComponentOf(
			org.husky.common.hl7cdar2.POCDMT000040Component1 value) {
		this.componentOf = value;
	}

	/**
	 * Sets the hl7ConfidentialityCode
	 */
	public void setHl7ConfidentialityCode(org.husky.common.hl7cdar2.CE value) {
		this.confidentialityCode = value;
	}

	/**
	 * Sets the hl7Custodian
	 */
	public void setHl7Custodian(org.husky.common.hl7cdar2.POCDMT000040Custodian value) {
		this.custodian = value;
	}

	/**
	 * Sets the hl7DataEnterer
	 */
	public void setHl7DataEnterer(
			org.husky.common.hl7cdar2.POCDMT000040DataEnterer value) {
		this.dataEnterer = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 */
	public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 */
	public void setHl7Id(org.husky.common.hl7cdar2.II value) {
		this.id = value;
	}

	/**
	 * Sets the hl7InformationRecipient
	 */
	public void setHl7InformationRecipient(
			org.husky.common.hl7cdar2.POCDMT000040InformationRecipient value) {
		getInformationRecipient().clear();
		getInformationRecipient().add(value);
	}

	/**
	 * Sets the hl7LanguageCode
	 */
	public void setHl7LanguageCode(org.husky.common.hl7cdar2.CS value) {
		this.languageCode = value;
	}

	/**
	 * Sets the hl7LegalAuthenticator
	 */
	public void setHl7LegalAuthenticator(
			org.husky.common.hl7cdar2.POCDMT000040LegalAuthenticator value) {
		this.legalAuthenticator = value;
	}

	/**
	 * Sets the hl7Participant
	 */
	public void setHl7Participant(
			org.husky.common.hl7cdar2.POCDMT000040Participant1 value) {
		getParticipant().clear();
		getParticipant().add(value);
	}

	/**
	 * Sets the hl7RealmCode
	 */
	public void setHl7RealmCode(org.husky.common.hl7cdar2.CS value) {
		getRealmCode().clear();
		getRealmCode().add(value);
	}

	/**
	 * Sets the hl7RecordTarget
	 */
	public void setHl7RecordTarget(
			org.husky.common.hl7cdar2.POCDMT000040RecordTarget value) {
		getRecordTarget().clear();
		getRecordTarget().add(value);
	}

	/**
	 * Sets the hl7RelatedDocument
	 */
	public void setHl7RelatedDocument(
			org.husky.common.hl7cdar2.POCDMT000040RelatedDocument value) {
		getRelatedDocument().clear();
		getRelatedDocument().add(value);
	}

	/**
	 * Sets the hl7SetId
	 */
	public void setHl7SetId(org.husky.common.hl7cdar2.II value) {
		this.setId = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Title
	 */
	public void setHl7Title(org.husky.common.hl7cdar2.ST value) {
		this.title = value;
	}

	/**
	 * Sets the hl7TypeId
	 */
	public void setHl7TypeId(
			org.husky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId value) {
		this.typeId = value;
	}

	/**
	 * Sets the hl7VersionNumber
	 */
	public void setHl7VersionNumber(org.husky.common.hl7cdar2.INT value) {
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
		super.setVersionNumber(new INT(version));
	}
}
