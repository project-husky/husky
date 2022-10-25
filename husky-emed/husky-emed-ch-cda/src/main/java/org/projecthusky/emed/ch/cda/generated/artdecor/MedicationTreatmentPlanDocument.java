/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.cda.generated.artdecor;

import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.xml.bind.annotation.XmlRootElement;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * MedicationTreatmentPlanDocument
 * <p>
 * Template description: <br/>TheMedication Treatment Plan document(IPAG report: eMedicationTreatmentPlan) describes one medication of a patient, a (1) medication that has been, is or will be taken by the patient.<br/>Relation to IHE Pharmacy<br/>The Medication Treatment Plan document it derived from the<a href="http://www.ihe.net/uploadedFiles/Documents/Pharmacy/IHE_Pharmacy_Suppl_MTP.pdf">IHE Pharmacy MTP Supplement</a>(Medication Treatment Plan).<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.1.7<br>
 * Effective date: 2017-04-12 13:57:31<br>
 * Version: 2020<br>
 * Status: draft
 */
@XmlRootElement(name = "ClinicalDocument", namespace = "urn:hl7-org:v3")
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class MedicationTreatmentPlanDocument extends POCDMT000040ClinicalDocument {

    public MedicationTreatmentPlanDocument() {
        super.setTypeId(createHl7TypeIdFixedValue("2.16.840.1.113883.1.3",
                                                  "POCD_HD000040"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.127.1.4"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.1"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.1.6"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.1.7"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.1.9"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.2"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.1"));
    }

    /**
     * Adds a hl7Authenticator<br/>
     * Information about an authenticator of a CDA document. An authenticator MUST be a person.
     */
    public void addHl7Authenticator(org.projecthusky.common.hl7cdar2.POCDMT000040Authenticator value) {
        getAuthenticator().add(value);
    }

    /**
     * Adds a hl7Author<br/>
     * Information about the author of a CDA document, section or entry. An author MAY be a person or a device.
     */
    public void addHl7Author(org.projecthusky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().add(value);
    }

    /**
     * Adds a hl7Authorization
     */
    public void addHl7Authorization(org.projecthusky.common.hl7cdar2.POCDMT000040Authorization value) {
        getAuthorization().add(value);
    }

    /**
     * Adds a hl7DocumentationOf<br/>
     * Information about a health service describing the context of this CDA document.
     */
    public void addHl7DocumentationOf(org.projecthusky.common.hl7cdar2.POCDMT000040DocumentationOf value) {
        getDocumentationOf().add(value);
    }

    /**
     * Adds a hl7InFulfillmentOf<br/>
     * Reference to one or more orders which led to the creation of this CDA document. It SHALL be declared, when the order reference is relevant for some reason.
     */
    public void addHl7InFulfillmentOf(org.projecthusky.common.hl7cdar2.POCDMT000040InFulfillmentOf value) {
        getInFulfillmentOf().add(value);
    }

    /**
     * Adds a hl7Informant
     */
    public void addHl7Informant(org.projecthusky.common.hl7cdar2.POCDMT000040Informant12 value) {
        getInformant().add(value);
    }

    /**
     * Adds a hl7InformationRecipient<br/>
     * A recipient of this CDA document (corresponds to the addressee of a letter - person or organization).Recipient types:
     * - The main recipient of the document is indicated by typeCode 'PRCP' (primary recipient).Note: Since it makes no sense to create a CDA document without doing it for someone, in Switzerland at least one recipient MUST be declared. If the document is created for the user's own needs, the user itself or its organization will be the primary recipient.
     * - Other recipients (copy to; Cc) are indicated with typeCode, TRC '(secondary recipient).
     */
    public void addHl7InformationRecipient(org.projecthusky.common.hl7cdar2.POCDMT000040InformationRecipient value) {
        getInformationRecipient().add(value);
    }

    /**
     * Adds a hl7Participant<br/>
     * Information on a patient contact.
     */
    public void addHl7Participant(org.projecthusky.common.hl7cdar2.POCDMT000040Participant1 value) {
        getParticipant().add(value);
    }

    /**
     * Adds a hl7RelatedDocument<br/>
     * Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
     * - Values that were only contained in the previous document have to be treated as deleted.
     * - Values that are present in both documents are overwritten with the contents of the new document.
     * - Values that are only contained in the new document are to be added.
     */
    public void addHl7RelatedDocument(org.projecthusky.common.hl7cdar2.POCDMT000040RelatedDocument value) {
        getRelatedDocument().add(value);
    }

    /**
     * Adds a hl7Authenticator<br/>
     * Information about an authenticator of a CDA document. An authenticator MUST be a person.
     */
    public void clearHl7Authenticator() {
        getAuthenticator().clear();
    }

    /**
     * Adds a hl7Author<br/>
     * Information about the author of a CDA document, section or entry. An author MAY be a person or a device.
     */
    public void clearHl7Author() {
        getAuthor().clear();
    }

    /**
     * Adds a hl7Authorization
     */
    public void clearHl7Authorization() {
        getAuthorization().clear();
    }

    /**
     * Adds a hl7DocumentationOf<br/>
     * Information about a health service describing the context of this CDA document.
     */
    public void clearHl7DocumentationOf() {
        getDocumentationOf().clear();
    }

    /**
     * Adds a hl7InFulfillmentOf<br/>
     * Reference to one or more orders which led to the creation of this CDA document. It SHALL be declared, when the order reference is relevant for some reason.
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
     * Adds a hl7InformationRecipient<br/>
     * A recipient of this CDA document (corresponds to the addressee of a letter - person or organization).Recipient types:
     * - The main recipient of the document is indicated by typeCode 'PRCP' (primary recipient).Note: Since it makes no sense to create a CDA document without doing it for someone, in Switzerland at least one recipient MUST be declared. If the document is created for the user's own needs, the user itself or its organization will be the primary recipient.
     * - Other recipients (copy to; Cc) are indicated with typeCode, TRC '(secondary recipient).
     */
    public void clearHl7InformationRecipient() {
        getInformationRecipient().clear();
    }

    /**
     * Adds a hl7Participant<br/>
     * Information on a patient contact.
     */
    public void clearHl7Participant() {
        getParticipant().clear();
    }

    /**
     * Adds a hl7RelatedDocument<br/>
     * Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
     * - Values that were only contained in the previous document have to be treated as deleted.
     * - Values that are present in both documents are overwritten with the contents of the new document.
     * - Values that are only contained in the new document are to be added.
     */
    public void clearHl7RelatedDocument() {
        getRelatedDocument().clear();
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
     * Creates fixed contents for CDA Element hl7TypeId
     *
     * @param root the desired fixed value for this argument.
     * @param extension the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId createHl7TypeIdFixedValue(String root, String extension) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId retVal = factory.createPOCDMT000040InfrastructureRootTypeId();
        retVal.setRoot(root);
        retVal.setExtension(extension);
        return retVal;
    }

    /**
     * Gets the hl7Code<br/>
     * IHE PHARM MTP document code
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
     * Gets the hl7ComponentOf
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040Component1 getHl7ComponentOf() {
        return componentOf;
    }

    /**
     * Gets the hl7ConfidentialityCode<br/>
     * Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7ConfidentialityCode() {
        return confidentialityCode;
    }

    /**
     * Gets the hl7Custodian<br/>
     * The organization in whose name this CDA document has been created (corresponds to the sender of a letter).
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040Custodian getHl7Custodian() {
        return custodian;
    }

    /**
     * Gets the hl7DataEnterer<br/>
     * Information about the person that entered information in this CDA document. It SHALL be declared, when data recorded in this document has been entered by a person other than the author but only when this is relevant for some reason.
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040DataEnterer getHl7DataEnterer() {
        return dataEnterer;
    }

    /**
     * Gets the hl7EffectiveTime<br/>
     * The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.
     */
    public org.projecthusky.common.hl7cdar2.TS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Id<br/>
     * A unique identifier for each CDA document instance.
     */
    public org.projecthusky.common.hl7cdar2.II getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7LanguageCode<br/>
     * The RFC5646 based language in which the narrative texts in this CDA document instance are written.
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7LanguageCode() {
        return languageCode;
    }

    /**
     * Gets the hl7LegalAuthenticator<br/>
     * Information about the legal authenticator of a CDA document. A legal authenticator MUST be a person.
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040LegalAuthenticator getHl7LegalAuthenticator() {
        return legalAuthenticator;
    }

    /**
     * Gets the hl7RealmCode<br/>
     * Swiss Realm (CHE) of HL7 CDA.
     */
    public List<org.projecthusky.common.hl7cdar2.CS> getHl7RealmCode() {
        return realmCode;
    }

    /**
     * Gets the hl7RecordTarget<br/>
     * A human patient for whom this CDA document instance was created.
     * - Target patientThe HL7 CDA R2 (2005) standard allows multiple patients.In order to ensure that the information in a CDA document is unambiguously assigned to one and only patient, a CDA-CH V2 based document MUST contain exactly one patient.Special cases: In exceptional cases (e.g., new-born twins, both having jaundice), multiple documents MUST be created (all of the same content, but each with a unique patient).
     * - Patient identifiersMultiple ids (patient identification number) MAY be declared.If multiple ids are known, it is highly recommended to declare all known ids. Especially in cases where the CDA document instance is kind of an answer to a preceding order (independent of its data format), all ids specified by the ordering system SHALL be declared in the CDA document instance. This allows the receiver to assign its internal patient identification.The patient identification number MUST be grouped with the OID of its assigning system. The patient identification number MUST be unique within the system identified by the OID.The declared OID MUST be found in one of the public OID registries, such as oid.refdata.ch (preferred), oid-info.com, hl7.org/oid, www.dimdi.de/static/de/klassi/oid/, gesundheit.gv.at/OID_Frontend/ etc.OIDs that can't be found in a public OID registry are NOT ALLOWED.
     * - PseudonymizingIn special cases, the demographic data of the patient are not allowed to be transmitted or they have to be pseudonymized.While HL7 CDA or its derivatives like CDA-CH or Swiss exchange formats nevertheless require these elements in the XML structure, the affected values MUST be replaced by a nullFlavor of type "MSK" (masked), in order to support the required data format structure and simultaneously to shield the real data.
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040RecordTarget> getHl7RecordTarget() {
        return recordTarget;
    }

    /**
     * Gets the hl7SetId<br/>
     * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
     */
    public org.projecthusky.common.hl7cdar2.II getHl7SetId() {
        return setId;
    }

    /**
     * Gets the hl7TemplateId<br/>
     * Exchange format according to the Swiss EPR
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Title<br/>
     * <div>The German title shall be "Therapieentscheid Medikation".</div><div>The French title shall be "Décision thérapeutique relative à la médication".<br/></div><div>The Italian title shall be "Decisione terapeutica di trattamento farmacologico".<br/></div><div>The English title shall be "Medication Treatment Plan".<br/>Titles in other languages are allowed and unrestricted.</div>
     */
    public org.projecthusky.common.hl7cdar2.ST getHl7Title() {
        return title;
    }

    /**
     * Gets the hl7TypeId<br/>
     * HL7 CDA R2, 2005
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId getHl7TypeId() {
        return typeId;
    }

    /**
     * Gets the hl7VersionNumber<br/>
     * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
     */
    public org.projecthusky.common.hl7cdar2.INT getHl7VersionNumber() {
        return versionNumber;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "2.16.756.5.30.1.1.1.1.4"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedTemplateId21675653011114() {
        return createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.4");
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
     * Sets the hl7Code<br/>
     * IHE PHARM MTP document code
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
     * Sets the hl7ComponentOf
     */
    public void setHl7ComponentOf(org.projecthusky.common.hl7cdar2.POCDMT000040Component1 value) {
        this.componentOf = value;
    }

    /**
     * Sets the hl7ConfidentialityCode<br/>
     * Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.
     */
    public void setHl7ConfidentialityCode(org.projecthusky.common.hl7cdar2.CE value) {
        this.confidentialityCode = value;
    }

    /**
     * Sets the hl7Custodian<br/>
     * The organization in whose name this CDA document has been created (corresponds to the sender of a letter).
     */
    public void setHl7Custodian(org.projecthusky.common.hl7cdar2.POCDMT000040Custodian value) {
        this.custodian = value;
    }

    /**
     * Sets the hl7DataEnterer<br/>
     * Information about the person that entered information in this CDA document. It SHALL be declared, when data recorded in this document has been entered by a person other than the author but only when this is relevant for some reason.
     */
    public void setHl7DataEnterer(org.projecthusky.common.hl7cdar2.POCDMT000040DataEnterer value) {
        this.dataEnterer = value;
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.TS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Id<br/>
     * A unique identifier for each CDA document instance.
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        this.id = value;
    }

    /**
     * Sets the hl7LanguageCode<br/>
     * The RFC5646 based language in which the narrative texts in this CDA document instance are written.
     */
    public void setHl7LanguageCode(org.projecthusky.common.hl7cdar2.CS value) {
        this.languageCode = value;
    }

    /**
     * Sets the hl7LegalAuthenticator<br/>
     * Information about the legal authenticator of a CDA document. A legal authenticator MUST be a person.
     */
    public void setHl7LegalAuthenticator(org.projecthusky.common.hl7cdar2.POCDMT000040LegalAuthenticator value) {
        this.legalAuthenticator = value;
    }

    /**
     * Sets the hl7RealmCode<br/>
     * Swiss Realm (CHE) of HL7 CDA.
     */
    public void setHl7RealmCode(org.projecthusky.common.hl7cdar2.CS value) {
        getRealmCode().clear();
        getRealmCode().add(value);
    }

    /**
     * Sets the hl7RecordTarget<br/>
     * A human patient for whom this CDA document instance was created.
     * - Target patientThe HL7 CDA R2 (2005) standard allows multiple patients.In order to ensure that the information in a CDA document is unambiguously assigned to one and only patient, a CDA-CH V2 based document MUST contain exactly one patient.Special cases: In exceptional cases (e.g., new-born twins, both having jaundice), multiple documents MUST be created (all of the same content, but each with a unique patient).
     * - Patient identifiersMultiple ids (patient identification number) MAY be declared.If multiple ids are known, it is highly recommended to declare all known ids. Especially in cases where the CDA document instance is kind of an answer to a preceding order (independent of its data format), all ids specified by the ordering system SHALL be declared in the CDA document instance. This allows the receiver to assign its internal patient identification.The patient identification number MUST be grouped with the OID of its assigning system. The patient identification number MUST be unique within the system identified by the OID.The declared OID MUST be found in one of the public OID registries, such as oid.refdata.ch (preferred), oid-info.com, hl7.org/oid, www.dimdi.de/static/de/klassi/oid/, gesundheit.gv.at/OID_Frontend/ etc.OIDs that can't be found in a public OID registry are NOT ALLOWED.
     * - PseudonymizingIn special cases, the demographic data of the patient are not allowed to be transmitted or they have to be pseudonymized.While HL7 CDA or its derivatives like CDA-CH or Swiss exchange formats nevertheless require these elements in the XML structure, the affected values MUST be replaced by a nullFlavor of type "MSK" (masked), in order to support the required data format structure and simultaneously to shield the real data.
     */
    public void setHl7RecordTarget(org.projecthusky.common.hl7cdar2.POCDMT000040RecordTarget value) {
        getRecordTarget().clear();
        getRecordTarget().add(value);
    }

    /**
     * Sets the hl7SetId<br/>
     * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
     */
    public void setHl7SetId(org.projecthusky.common.hl7cdar2.II value) {
        this.setId = value;
    }

    /**
     * Sets the hl7TemplateId<br/>
     * Exchange format according to the Swiss EPR
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Title<br/>
     * <div>The German title shall be "Therapieentscheid Medikation".</div><div>The French title shall be "Décision thérapeutique relative à la médication".<br/></div><div>The Italian title shall be "Decisione terapeutica di trattamento farmacologico".<br/></div><div>The English title shall be "Medication Treatment Plan".<br/>Titles in other languages are allowed and unrestricted.</div>
     */
    public void setHl7Title(org.projecthusky.common.hl7cdar2.ST value) {
        this.title = value;
    }

    /**
     * Sets the hl7TypeId<br/>
     * HL7 CDA R2, 2005
     */
    public void setHl7TypeId(org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId value) {
        this.typeId = value;
    }

    /**
     * Sets the hl7VersionNumber<br/>
     * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
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
        super.setSetId(id);
        super.setVersionNumber(new INT(version));
    }
}
