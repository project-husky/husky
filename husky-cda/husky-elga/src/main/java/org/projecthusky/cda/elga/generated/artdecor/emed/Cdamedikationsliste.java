/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.emed;

import java.util.List;
import java.util.UUID;

import javax.annotation.processing.Generated;
import javax.xml.bind.annotation.XmlRootElement;

import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * CDAMedikationsliste
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.10007<br>
 * Effective date: 2014-01-31 00:00:00<br>
 * Status: draft
 */
@XmlRootElement(name = "ClinicalDocument", namespace = "urn:hl7-org:v3")
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class Cdamedikationsliste extends POCDMT000040ClinicalDocument {

    public Cdamedikationsliste() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.8.3"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.1.5"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.1"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.8.0.3"));
        super.setId(createHl7IdFixedValue("1.2.40.0.10.1.4.3.4.2.1",
                                          "e-MedAT"));
        super.setCode(createHl7CodeFixedValue("56445-0",
                                              "2.16.840.1.113883.6.1",
                                              null,
                                              "Medication summary Document"));
        super.setTypeId(createHl7TypeIdFixedValue("2.16.840.1.113883.1.3",
                                                  "POCD_HD000040"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.1"));
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
     * Creates fixed contents for CDA Element hl7Id
     *
     * @param root the desired fixed value for this argument.
     * @param assigningAuthorityName the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7IdFixedValue(String root, String assigningAuthorityName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        retVal.setAssigningAuthorityName(assigningAuthorityName);
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
     * Gets the hl7RealmCode
     */
    public List<org.projecthusky.common.hl7cdar2.CS> getHl7RealmCode() {
        return realmCode;
    }

    /**
     * Gets the hl7RecordTarget
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040RecordTarget> getHl7RecordTarget() {
        return recordTarget;
    }

    /**
     * Gets the hl7RelatedDocument
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040RelatedDocument> getHl7RelatedDocument() {
        return relatedDocument;
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
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Component2, filled by: "COMP", "true"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Component2 getPredefinedComponentCompTrue() {
        return createHl7ComponentFixedValue("COMP",
                                            "true");
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
     * Sets the hl7RealmCode
     */
    public void setHl7RealmCode(org.projecthusky.common.hl7cdar2.CS value) {
        getRealmCode().clear();
        getRealmCode().add(value);
    }

    /**
     * Sets the hl7RecordTarget
     */
    public void setHl7RecordTarget(org.projecthusky.common.hl7cdar2.POCDMT000040RecordTarget value) {
        getRecordTarget().clear();
        getRecordTarget().add(value);
    }

    /**
     * Sets the hl7RelatedDocument
     */
    public void setHl7RelatedDocument(org.projecthusky.common.hl7cdar2.POCDMT000040RelatedDocument value) {
        getRelatedDocument().clear();
        getRelatedDocument().add(value);
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
        super.setSetId(id);
        super.setVersionNumber(new INT(version));
    }
}
